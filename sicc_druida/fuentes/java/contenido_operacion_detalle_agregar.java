
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_operacion_detalle_agregar  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         

      getXML180(doc);
         

      getXML270(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_operacion_detalle_agregar" );
      ((Element)v.get(0)).setAttribute("cod","0144" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","contenido_operacion_detalle_agregar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("STYLE"));
      ((Element)v.get(5)).setAttribute("TYPE","text/css" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Elemento padre:5 / Elemento actual: 6   */
      v.add(doc.createTextNode("\r   \r#Cplistado1 {visibility:hidden;}\r#CpLin1listado1 {visibility:hidden;}\r#CpLin2listado1 {visibility:hidden;}\r#CpLin3listado1 {visibility:hidden;}\r#CpLin4listado1 {visibility:hidden;}\r#primera1Div {visibility:hidden;}\r#ret1Div {visibility:hidden;}\r#ava1Div {visibility:hidden;}\r#separaDiv {visibility:hidden;}\r#AceptarDiv {visibility:hidden;}\r   \r"));
      ((Element)v.get(5)).appendChild((Text)v.get(6));

      /* Termina nodo Texto:6   */
      /* Termina nodo:5   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(7)).setAttribute("nombre","frmContenido" );
      ((Element)v.get(0)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","accion" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","casoUso" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","idioma" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","pais" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(7)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","fechaFiltro" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","oidCliente" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","oidNumDocumento" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 7   */
      v.add(doc.createElement("table"));
      ((Element)v.get(16)).setAttribute("width","100%" );
      ((Element)v.get(16)).setAttribute("border","0" );
      ((Element)v.get(16)).setAttribute("cellspacing","0" );
      ((Element)v.get(16)).setAttribute("cellpadding","0" );
      ((Element)v.get(7)).appendChild((Element)v.get(16));

      /* Empieza nodo:17 / Elemento padre: 16   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(16)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("td"));
      ((Element)v.get(17)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(19)).setAttribute("src","b.gif" );
      ((Element)v.get(19)).setAttribute("width","702" );
      ((Element)v.get(19)).setAttribute("height","1" );
      ((Element)v.get(18)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */
      /* Termina nodo:18   */
      /* Termina nodo:17   */
      /* Termina nodo:16   */

      /* Empieza nodo:20 / Elemento padre: 7   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(20)).setAttribute("nombre","listado1" );
      ((Element)v.get(20)).setAttribute("ancho","678" );
      ((Element)v.get(20)).setAttribute("alto","299" );
      ((Element)v.get(20)).setAttribute("x","12" );
      ((Element)v.get(20)).setAttribute("y","12" );
      ((Element)v.get(20)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(20)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(7)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(21)).setAttribute("precarga","S" );
      ((Element)v.get(21)).setAttribute("conROver","S" );
      ((Element)v.get(20)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("BTNSELECCION"));
   }

   private void getXML90(Document doc) {
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
      ((Element)v.get(28)).setAttribute("cod","00301" );
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
      ((Element)v.get(31)).setAttribute("ancho","120" );
      ((Element)v.get(31)).setAttribute("minimizable","S" );
      ((Element)v.get(31)).setAttribute("minimizada","N" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 30   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(32)).setAttribute("ancho","120" );
      ((Element)v.get(32)).setAttribute("minimizable","S" );
      ((Element)v.get(32)).setAttribute("minimizada","N" );
      ((Element)v.get(32)).setAttribute("orden","alfanumerico" );
      ((Element)v.get(30)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 30   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(33)).setAttribute("ancho","110" );
      ((Element)v.get(33)).setAttribute("minimizable","S" );
      ((Element)v.get(33)).setAttribute("minimizada","N" );
      ((Element)v.get(30)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 30   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(34)).setAttribute("ancho","110" );
      ((Element)v.get(34)).setAttribute("minimizable","S" );
      ((Element)v.get(34)).setAttribute("minimizada","N" );
      ((Element)v.get(30)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 30   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(35)).setAttribute("ancho","110" );
      ((Element)v.get(35)).setAttribute("minimizable","S" );
      ((Element)v.get(35)).setAttribute("minimizada","N" );
      ((Element)v.get(35)).setAttribute("orden","numerico" );
      ((Element)v.get(30)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */
      /* Termina nodo:30   */

      /* Empieza nodo:36 / Elemento padre: 20   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(36)).setAttribute("alto","20" );
      ((Element)v.get(36)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(36)).setAttribute("imgFondo","" );
      ((Element)v.get(36)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(20)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(37)).setAttribute("colFondo","" );
      ((Element)v.get(37)).setAttribute("ID","EstCab" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(37)).setAttribute("cod","501" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 36   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(38)).setAttribute("colFondo","" );
      ((Element)v.get(38)).setAttribute("ID","EstCab" );
      ((Element)v.get(38)).setAttribute("cod","367" );
      ((Element)v.get(36)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 36   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(39)).setAttribute("colFondo","" );
      ((Element)v.get(39)).setAttribute("ID","EstCab" );
      ((Element)v.get(39)).setAttribute("cod","392" );
      ((Element)v.get(36)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 36   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(40)).setAttribute("colFondo","" );
      ((Element)v.get(40)).setAttribute("ID","EstCab" );
      ((Element)v.get(40)).setAttribute("cod","276" );
      ((Element)v.get(36)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 36   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(41)).setAttribute("colFondo","" );
      ((Element)v.get(41)).setAttribute("ID","EstCab" );
      ((Element)v.get(41)).setAttribute("cod","132" );
      ((Element)v.get(36)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:36   */

      /* Empieza nodo:42 / Elemento padre: 20   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(42)).setAttribute("alto","22" );
      ((Element)v.get(42)).setAttribute("accion","" );
      ((Element)v.get(42)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(42)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(42)).setAttribute("maxSel","1" );
      ((Element)v.get(42)).setAttribute("deseleccionaSiMaxSel","S" );
      ((Element)v.get(42)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(42)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(42)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(42)).setAttribute("onLoad","" );
      ((Element)v.get(42)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(20)).appendChild((Element)v.get(42));

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
      ((Element)v.get(45)).setAttribute("tipo","texto" );
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
      ((Element)v.get(47)).setAttribute("tipo","texto" );
      ((Element)v.get(47)).setAttribute("ID","EstDat" );
      ((Element)v.get(42)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:42   */

      /* Empieza nodo:48 / Elemento padre: 20   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(20)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 20   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(49)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(49)).setAttribute("ancho","678" );
      ((Element)v.get(49)).setAttribute("sep","$" );
      ((Element)v.get(49)).setAttribute("x","12" );
      ((Element)v.get(49)).setAttribute("class","botonera" );
      ((Element)v.get(49)).setAttribute("y","288" );
      ((Element)v.get(49)).setAttribute("control","|" );
      ((Element)v.get(49)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(49)).setAttribute("rowset","" );
      ((Element)v.get(49)).setAttribute("onload","procesarPaginado(mipgndo, msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(49)).setAttribute("cargainicial","N" );
      ((Element)v.get(20)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(50)).setAttribute("nombre","ret1" );
      ((Element)v.get(50)).setAttribute("x","37" );
      ((Element)v.get(50)).setAttribute("y","292" );
      ((Element)v.get(50)).setAttribute("ID","botonContenido" );
      ((Element)v.get(50)).setAttribute("img","retroceder_on" );
      ((Element)v.get(50)).setAttribute("tipo","0" );
      ((Element)v.get(50)).setAttribute("estado","false" );
      ((Element)v.get(50)).setAttribute("alt","" );
      ((Element)v.get(50)).setAttribute("codigo","" );
      ((Element)v.get(50)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 49   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(51)).setAttribute("nombre","ava1" );
      ((Element)v.get(51)).setAttribute("x","52" );
      ((Element)v.get(51)).setAttribute("y","292" );
      ((Element)v.get(51)).setAttribute("ID","botonContenido" );
      ((Element)v.get(51)).setAttribute("img","avanzar_on" );
      ((Element)v.get(51)).setAttribute("tipo","0" );
      ((Element)v.get(51)).setAttribute("estado","false" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(51)).setAttribute("alt","" );
      ((Element)v.get(51)).setAttribute("codigo","" );
      ((Element)v.get(51)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(49)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:49   */
      /* Termina nodo:20   */

      /* Empieza nodo:52 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(52)).setAttribute("nombre","primera1" );
      ((Element)v.get(52)).setAttribute("x","20" );
      ((Element)v.get(52)).setAttribute("y","292" );
      ((Element)v.get(52)).setAttribute("ID","botonContenido" );
      ((Element)v.get(52)).setAttribute("img","primera_on" );
      ((Element)v.get(52)).setAttribute("tipo","-2" );
      ((Element)v.get(52)).setAttribute("estado","false" );
      ((Element)v.get(52)).setAttribute("alt","" );
      ((Element)v.get(52)).setAttribute("codigo","" );
      ((Element)v.get(52)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(7)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(53)).setAttribute("nombre","separa" );
      ((Element)v.get(53)).setAttribute("x","59" );
      ((Element)v.get(53)).setAttribute("y","288" );
      ((Element)v.get(53)).setAttribute("ID","botonContenido" );
      ((Element)v.get(53)).setAttribute("img","separa_base" );
      ((Element)v.get(53)).setAttribute("tipo","0" );
      ((Element)v.get(53)).setAttribute("estado","false" );
      ((Element)v.get(53)).setAttribute("alt","" );
      ((Element)v.get(53)).setAttribute("codigo","" );
      ((Element)v.get(53)).setAttribute("accion","" );
      ((Element)v.get(7)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(54)).setAttribute("nombre","Aceptar" );
      ((Element)v.get(54)).setAttribute("x","80" );
      ((Element)v.get(54)).setAttribute("y","289" );
      ((Element)v.get(54)).setAttribute("accion","onClickAceptar()" );
      ((Element)v.get(54)).setAttribute("ontab","document.all['Aceptar'].focus()" );
      ((Element)v.get(54)).setAttribute("onshtab","document.all['Aceptar'].focus()" );
      ((Element)v.get(54)).setAttribute("ID","botonContenido" );
      ((Element)v.get(54)).setAttribute("tipo","html" );
      ((Element)v.get(54)).setAttribute("estado","false" );
      ((Element)v.get(54)).setAttribute("cod","12" );
      ((Element)v.get(7)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 7   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(55)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(55)).setAttribute("alto","12" );
      ((Element)v.get(55)).setAttribute("ancho","50" );
      ((Element)v.get(55)).setAttribute("colorf","" );
      ((Element)v.get(55)).setAttribute("borde","0" );
      ((Element)v.get(55)).setAttribute("imagenf","" );
      ((Element)v.get(55)).setAttribute("repeat","" );
      ((Element)v.get(55)).setAttribute("padding","" );
      ((Element)v.get(55)).setAttribute("visibilidad","visible" );
      ((Element)v.get(55)).setAttribute("contravsb","" );
      ((Element)v.get(55)).setAttribute("x","0" );
      ((Element)v.get(55)).setAttribute("y","311" );
      ((Element)v.get(55)).setAttribute("zindex","" );
      ((Element)v.get(7)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:7   */


   }

}
