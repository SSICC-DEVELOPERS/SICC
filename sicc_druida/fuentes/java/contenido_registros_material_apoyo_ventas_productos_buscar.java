
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_registros_material_apoyo_ventas_productos_buscar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_registros_material_apoyo_ventas_productos_buscar" );
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
      ((Element)v.get(2)).setAttribute("src","contenido_registros_material_apoyo_ventas_productos_buscar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

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
      ((Element)v.get(5)).setAttribute("src","validaciones_sicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(6)).setAttribute("nombre","formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","accion" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","casoUso" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(12)).setAttribute("nombre","listado2" );
      ((Element)v.get(12)).setAttribute("ancho","664" );
      ((Element)v.get(12)).setAttribute("alto","317" );
      ((Element)v.get(12)).setAttribute("x","12" );
      ((Element)v.get(12)).setAttribute("y","12" );
      ((Element)v.get(12)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(12)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));

      /* Empieza nodo:13 / Elemento padre: 12   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(13)).setAttribute("precarga","S" );
      ((Element)v.get(13)).setAttribute("conROver","S" );
      ((Element)v.get(12)).appendChild((Element)v.get(13));

      /* Empieza nodo:14 / Elemento padre: 13   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(14)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(14)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(14)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(14)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(13)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 13   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(15)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(15)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(15)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(15)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(13)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 13   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(16)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(16)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(13)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */
      /* Termina nodo:13   */

      /* Empieza nodo:17 / Elemento padre: 12   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(12)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(18)).setAttribute("borde","1" );
      ((Element)v.get(18)).setAttribute("horizDatos","1" );
      ((Element)v.get(18)).setAttribute("horizCabecera","1" );
      ((Element)v.get(18)).setAttribute("vertical","0" );
      ((Element)v.get(18)).setAttribute("horizTitulo","1" );
      ((Element)v.get(18)).setAttribute("horizBase","1" );
      ((Element)v.get(17)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 17   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(19)).setAttribute("borde","#999999" );
      ((Element)v.get(19)).setAttribute("vertCabecera","#E0E0E0" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(19)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(19)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(19)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(19)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(19)).setAttribute("horizBase","#999999" );
      ((Element)v.get(17)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */
      /* Termina nodo:17   */

      /* Empieza nodo:20 / Elemento padre: 12   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(20)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(20)).setAttribute("alto","22" );
      ((Element)v.get(20)).setAttribute("imgFondo","" );
      ((Element)v.get(20)).setAttribute("cod","0094" );
      ((Element)v.get(20)).setAttribute("ID","datosTitle" );
      ((Element)v.get(12)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 12   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(21)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(21)).setAttribute("alto","22" );
      ((Element)v.get(21)).setAttribute("imgFondo","" );
      ((Element)v.get(12)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 12   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(22)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(22)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(22)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(22)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(22)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(22)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(12)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(23)).setAttribute("ancho","100" );
      ((Element)v.get(23)).setAttribute("minimizable","S" );
      ((Element)v.get(23)).setAttribute("minimizada","N" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 22   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(24)).setAttribute("ancho","120" );
      ((Element)v.get(24)).setAttribute("minimizable","S" );
      ((Element)v.get(24)).setAttribute("minimizada","N" );
      ((Element)v.get(24)).setAttribute("orden","alfanumerico" );
      ((Element)v.get(22)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 22   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(25)).setAttribute("ancho","100" );
      ((Element)v.get(25)).setAttribute("minimizable","S" );
      ((Element)v.get(25)).setAttribute("minimizada","N" );
      ((Element)v.get(22)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 22   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(26)).setAttribute("ancho","100" );
      ((Element)v.get(26)).setAttribute("minimizable","S" );
      ((Element)v.get(26)).setAttribute("minimizada","N" );
      ((Element)v.get(22)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 22   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(27)).setAttribute("ancho","100" );
      ((Element)v.get(27)).setAttribute("minimizable","S" );
      ((Element)v.get(27)).setAttribute("minimizada","N" );
      ((Element)v.get(22)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 22   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(28)).setAttribute("ancho","60" );
      ((Element)v.get(28)).setAttribute("minimizable","S" );
      ((Element)v.get(28)).setAttribute("minimizada","N" );
      ((Element)v.get(28)).setAttribute("oculta","S" );
      ((Element)v.get(22)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:22   */

      /* Empieza nodo:29 / Elemento padre: 12   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(29)).setAttribute("alto","20" );
      ((Element)v.get(29)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(29)).setAttribute("imgFondo","" );
      ((Element)v.get(29)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(12)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(30)).setAttribute("colFondo","" );
      ((Element)v.get(30)).setAttribute("ID","EstCab" );
      ((Element)v.get(30)).setAttribute("align","center" );
      ((Element)v.get(30)).setAttribute("cod","337" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));

      /* Elemento padre:30 / Elemento actual: 31   */
      v.add(doc.createTextNode("Cód. producto"));
      ((Element)v.get(30)).appendChild((Text)v.get(31));

      /* Termina nodo Texto:31   */
      /* Termina nodo:30   */

      /* Empieza nodo:32 / Elemento padre: 29   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(32)).setAttribute("colFondo","" );
      ((Element)v.get(32)).setAttribute("ID","EstCab" );
      ((Element)v.get(32)).setAttribute("cod","338" );
      ((Element)v.get(29)).appendChild((Element)v.get(32));

      /* Elemento padre:32 / Elemento actual: 33   */
      v.add(doc.createTextNode("Descripción producto"));
      ((Element)v.get(32)).appendChild((Text)v.get(33));

      /* Termina nodo Texto:33   */
      /* Termina nodo:32   */

      /* Empieza nodo:34 / Elemento padre: 29   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(34)).setAttribute("colFondo","" );
      ((Element)v.get(34)).setAttribute("ID","EstCab" );
      ((Element)v.get(34)).setAttribute("cod","495" );
      ((Element)v.get(29)).appendChild((Element)v.get(34));

      /* Elemento padre:34 / Elemento actual: 35   */
      v.add(doc.createTextNode("Nº unidades"));
      ((Element)v.get(34)).appendChild((Text)v.get(35));

      /* Termina nodo Texto:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:36 / Elemento padre: 29   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(36)).setAttribute("colFondo","" );
      ((Element)v.get(36)).setAttribute("ID","EstCab" );
      ((Element)v.get(36)).setAttribute("cod","863" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(29)).appendChild((Element)v.get(36));

      /* Elemento padre:36 / Elemento actual: 37   */
      v.add(doc.createTextNode("Estado envío"));
      ((Element)v.get(36)).appendChild((Text)v.get(37));

      /* Termina nodo Texto:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:38 / Elemento padre: 29   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(38)).setAttribute("colFondo","" );
      ((Element)v.get(38)).setAttribute("ID","EstCab" );
      ((Element)v.get(38)).setAttribute("cod","862" );
      ((Element)v.get(29)).appendChild((Element)v.get(38));

      /* Elemento padre:38 / Elemento actual: 39   */
      v.add(doc.createTextNode("Estado autorización"));
      ((Element)v.get(38)).appendChild((Text)v.get(39));

      /* Termina nodo Texto:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:40 / Elemento padre: 29   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(40)).setAttribute("colFondo","" );
      ((Element)v.get(40)).setAttribute("ID","EstCab" );
      ((Element)v.get(40)).setAttribute("align","center" );
      ((Element)v.get(29)).appendChild((Element)v.get(40));

      /* Elemento padre:40 / Elemento actual: 41   */
      v.add(doc.createTextNode("hidModificado"));
      ((Element)v.get(40)).appendChild((Text)v.get(41));

      /* Termina nodo Texto:41   */
      /* Termina nodo:40   */
      /* Termina nodo:29   */

      /* Empieza nodo:42 / Elemento padre: 12   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(42)).setAttribute("alto","22" );
      ((Element)v.get(42)).setAttribute("accion","" );
      ((Element)v.get(42)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(42)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(42)).setAttribute("maxSel","-1" );
      ((Element)v.get(42)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(42)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(42)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(42)).setAttribute("onLoad","" );
      ((Element)v.get(42)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(12)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(43)).setAttribute("tipo","texto" );
      ((Element)v.get(43)).setAttribute("ID","EstDat" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 42   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(44)).setAttribute("tipo","texto" );
      ((Element)v.get(44)).setAttribute("ID","EstDat2" );
      ((Element)v.get(42)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 42   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(45)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(45)).setAttribute("nombre","txtNumUnidades2" );
      ((Element)v.get(45)).setAttribute("onchange","cambiaUnidades(FILAEVENTO);" );
      ((Element)v.get(45)).setAttribute("size","10" );
      ((Element)v.get(45)).setAttribute("max","10" );
      ((Element)v.get(45)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(45)).setAttribute("ID","EstDat" );
      ((Element)v.get(42)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 42   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(46)).setAttribute("tipo","texto" );
      ((Element)v.get(46)).setAttribute("ID","EstDat2" );
      ((Element)v.get(42)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 42   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(47)).setAttribute("tipo","combo" );
      ((Element)v.get(47)).setAttribute("nombre","cbEstadoAutorizacion2" );
      ((Element)v.get(47)).setAttribute("onchange","estadoAutorizacion(FILAEVENTO);" );
      ((Element)v.get(47)).setAttribute("IDOBJ","EstDatForm" );
      ((Element)v.get(47)).setAttribute("ID","EstDat" );
      ((Element)v.get(42)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(50)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(50)).setAttribute("TIPO","STRING" );
      ((Element)v.get(50)).setAttribute("VALOR","3" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 49   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(51)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(51)).setAttribute("TIPO","STRING" );
      ((Element)v.get(51)).setAttribute("VALOR","Autorizado" );
      ((Element)v.get(49)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:49   */

      /* Empieza nodo:52 / Elemento padre: 48   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(48)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(53)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(53)).setAttribute("TIPO","STRING" );
      ((Element)v.get(53)).setAttribute("VALOR","5" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 52   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(54)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(54)).setAttribute("TIPO","STRING" );
      ((Element)v.get(54)).setAttribute("VALOR","Enviado para autorización" );
      ((Element)v.get(52)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:52   */

      /* Empieza nodo:55 / Elemento padre: 48   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(48)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(56)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(56)).setAttribute("TIPO","STRING" );
      ((Element)v.get(56)).setAttribute("VALOR","2" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 55   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(57)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(57)).setAttribute("TIPO","STRING" );
      ((Element)v.get(57)).setAttribute("VALOR","Pendiente" );
      ((Element)v.get(55)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:55   */

      /* Empieza nodo:58 / Elemento padre: 48   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(48)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(59)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(59)).setAttribute("TIPO","STRING" );
      ((Element)v.get(59)).setAttribute("VALOR","4" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 58   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(60)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(60)).setAttribute("TIPO","STRING" );
      ((Element)v.get(60)).setAttribute("VALOR","No autorizado" );
      ((Element)v.get(58)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:58   */

      /* Empieza nodo:61 / Elemento padre: 48   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(48)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(62)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(62)).setAttribute("TIPO","STRING" );
      ((Element)v.get(62)).setAttribute("VALOR","1" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 61   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(63)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(63)).setAttribute("TIPO","STRING" );
      ((Element)v.get(63)).setAttribute("VALOR","Sin autorización" );
      ((Element)v.get(61)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:61   */
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:64 / Elemento padre: 42   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(64)).setAttribute("tipo","texto" );
      ((Element)v.get(64)).setAttribute("ID","EstDat" );
      ((Element)v.get(42)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:42   */

      /* Empieza nodo:65 / Elemento padre: 12   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(12)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */

      /* Empieza nodo:66 / Elemento padre: 12   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(66)).setAttribute("nombre","mipgndo2" );
      ((Element)v.get(66)).setAttribute("ancho","664" );
      ((Element)v.get(66)).setAttribute("sep","$" );
      ((Element)v.get(66)).setAttribute("x","12" );
      ((Element)v.get(66)).setAttribute("class","botonera" );
      ((Element)v.get(66)).setAttribute("y","306" );
      ((Element)v.get(66)).setAttribute("control","|" );
      ((Element)v.get(66)).setAttribute("conector","conectorSandra1" );
      ((Element)v.get(66)).setAttribute("rowset","" );
      ((Element)v.get(66)).setAttribute("cargainicial","N" );
      ((Element)v.get(12)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(67)).setAttribute("nombre","ret2" );
      ((Element)v.get(67)).setAttribute("x","37" );
      ((Element)v.get(67)).setAttribute("y","310" );
      ((Element)v.get(67)).setAttribute("ID","botonContenido" );
      ((Element)v.get(67)).setAttribute("img","retroceder_on" );
      ((Element)v.get(67)).setAttribute("tipo","0" );
      ((Element)v.get(67)).setAttribute("estado","false" );
      ((Element)v.get(67)).setAttribute("alt","" );
      ((Element)v.get(67)).setAttribute("codigo","" );
      ((Element)v.get(67)).setAttribute("accion","mipgndo2.retroceder();" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */

      /* Empieza nodo:68 / Elemento padre: 66   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(68)).setAttribute("nombre","ava2" );
      ((Element)v.get(68)).setAttribute("x","52" );
      ((Element)v.get(68)).setAttribute("y","310" );
      ((Element)v.get(68)).setAttribute("ID","botonContenido" );
      ((Element)v.get(68)).setAttribute("img","avanzar_on" );
      ((Element)v.get(68)).setAttribute("tipo","0" );
      ((Element)v.get(68)).setAttribute("estado","false" );
      ((Element)v.get(68)).setAttribute("alt","" );
      ((Element)v.get(68)).setAttribute("codigo","" );
      ((Element)v.get(68)).setAttribute("accion","mipgndo2.avanzar();" );
      ((Element)v.get(66)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:66   */
      /* Termina nodo:12   */

      /* Empieza nodo:69 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(69)).setAttribute("nombre","primera2" );
      ((Element)v.get(69)).setAttribute("x","20" );
      ((Element)v.get(69)).setAttribute("y","310" );
      ((Element)v.get(69)).setAttribute("ID","botonContenido" );
      ((Element)v.get(69)).setAttribute("img","primera_on" );
      ((Element)v.get(69)).setAttribute("tipo","1" );
      ((Element)v.get(69)).setAttribute("estado","false" );
      ((Element)v.get(69)).setAttribute("alt","" );
      ((Element)v.get(69)).setAttribute("codigo","" );
      ((Element)v.get(69)).setAttribute("accion","mipgndo2.retrocederPrimeraPagina();" );
      ((Element)v.get(6)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */

      /* Empieza nodo:70 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(70)).setAttribute("nombre","separa2" );
      ((Element)v.get(70)).setAttribute("x","59" );
      ((Element)v.get(70)).setAttribute("y","306" );
      ((Element)v.get(70)).setAttribute("ID","botonContenido" );
      ((Element)v.get(70)).setAttribute("img","separa_base" );
      ((Element)v.get(70)).setAttribute("tipo","0" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(70)).setAttribute("estado","false" );
      ((Element)v.get(70)).setAttribute("alt","" );
      ((Element)v.get(70)).setAttribute("codigo","" );
      ((Element)v.get(70)).setAttribute("accion","" );
      ((Element)v.get(6)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(71)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(71)).setAttribute("alto","24" );
      ((Element)v.get(71)).setAttribute("ancho","100%" );
      ((Element)v.get(71)).setAttribute("colorf","" );
      ((Element)v.get(71)).setAttribute("borde","0" );
      ((Element)v.get(71)).setAttribute("imagenf","" );
      ((Element)v.get(71)).setAttribute("repeat","" );
      ((Element)v.get(71)).setAttribute("padding","" );
      ((Element)v.get(71)).setAttribute("visibilidad","visible" );
      ((Element)v.get(71)).setAttribute("contravsb","" );
      ((Element)v.get(71)).setAttribute("x","0" );
      ((Element)v.get(71)).setAttribute("y","329" );
      ((Element)v.get(71)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:6   */


   }

}
