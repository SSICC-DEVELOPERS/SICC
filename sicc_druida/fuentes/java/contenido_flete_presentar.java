
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_flete_presentar  implements es.indra.druida.base.ObjetoXML {
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
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_flete_presentar" );
      ((Element)v.get(0)).setAttribute("cod","0428" );
      ((Element)v.get(0)).setAttribute("titulo","Presentar Flete" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Presentar Flete" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Elemento padre:1 / Elemento actual: 2   */
      v.add(doc.createTextNode("    \r  \r   function onLoadPag()   \r    {           \r      DrdEnsanchaConMargenDcho('listado1',12); \r     \r      document.all[\"Cplistado1\"].style.visibility=''; \r      document.all[\"CpLin1listado1\"].style.visibility='';  \r      document.all[\"CpLin2listado1\"].style.visibility=''; \r      document.all[\"CpLin3listado1\"].style.visibility='';\r      document.all[\"CpLin4listado1\"].style.visibility='';  \r      \r      document.all[\"primera1Div\"].style.visibility=''; \r      document.all[\"ret1Div\"].style.visibility='';\r      document.all[\"ava1Div\"].style.visibility='';  \r      document.all[\"separaDiv\"].style.visibility=''; \r          \r      eval (ON_RSZ);   \r         \r    }\r     \r"));
      ((Element)v.get(1)).appendChild((Text)v.get(2));

      /* Termina nodo Texto:2   */
      /* Termina nodo:1   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(3)).setAttribute("nombre","formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));

      /* Empieza nodo:4 / Elemento padre: 3   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(4)).setAttribute("nombre","capa1" );
      ((Element)v.get(3)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("table"));
      ((Element)v.get(5)).setAttribute("width","100%" );
      ((Element)v.get(5)).setAttribute("border","0" );
      ((Element)v.get(5)).setAttribute("cellspacing","0" );
      ((Element)v.get(5)).setAttribute("cellpadding","0" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(5)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("td"));
      ((Element)v.get(6)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(8)).setAttribute("src","b.gif" );
      ((Element)v.get(8)).setAttribute("width","524" );
      ((Element)v.get(8)).setAttribute("height","12" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */
      /* Termina nodo:7   */
      /* Termina nodo:6   */
      /* Termina nodo:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:9 / Elemento padre: 3   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(9)).setAttribute("nombre","listado1" );
      ((Element)v.get(9)).setAttribute("ancho","500" );
      ((Element)v.get(9)).setAttribute("alto","317" );
      ((Element)v.get(9)).setAttribute("x","12" );
      ((Element)v.get(9)).setAttribute("y","12" );
      ((Element)v.get(9)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(9)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(3)).appendChild((Element)v.get(9));

      /* Empieza nodo:10 / Elemento padre: 9   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(10)).setAttribute("precarga","S" );
      ((Element)v.get(10)).setAttribute("conROver","S" );
      ((Element)v.get(9)).appendChild((Element)v.get(10));

      /* Empieza nodo:11 / Elemento padre: 10   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(11)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(11)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(11)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(11)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(10)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 10   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(12)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(12)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(12)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(12)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(10)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 10   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(13)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(13)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(10)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */
      /* Termina nodo:10   */

      /* Empieza nodo:14 / Elemento padre: 9   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(9)).appendChild((Element)v.get(14));

      /* Empieza nodo:15 / Elemento padre: 14   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(15)).setAttribute("borde","1" );
      ((Element)v.get(15)).setAttribute("horizDatos","1" );
      ((Element)v.get(15)).setAttribute("horizCabecera","1" );
      ((Element)v.get(15)).setAttribute("vertical","1" );
      ((Element)v.get(15)).setAttribute("horizTitulo","1" );
      ((Element)v.get(15)).setAttribute("horizBase","1" );
      ((Element)v.get(14)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 14   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(16)).setAttribute("borde","#999999" );
      ((Element)v.get(16)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(16)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(16)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(16)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(16)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(16)).setAttribute("horizBase","#999999" );
      ((Element)v.get(14)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */
      /* Termina nodo:14   */

      /* Empieza nodo:17 / Elemento padre: 9   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(17)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(17)).setAttribute("alto","22" );
      ((Element)v.get(17)).setAttribute("imgFondo","" );
      ((Element)v.get(17)).setAttribute("cod","00181" );
      ((Element)v.get(17)).setAttribute("ID","datosTitle" );
      ((Element)v.get(9)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 9   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("BASE"));
      ((Element)v.get(18)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(18)).setAttribute("alto","22" );
      ((Element)v.get(18)).setAttribute("imgFondo","" );
      ((Element)v.get(9)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 9   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(19)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(19)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(19)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(19)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(19)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(19)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(9)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(20)).setAttribute("ancho","100" );
      ((Element)v.get(20)).setAttribute("minimizable","S" );
      ((Element)v.get(20)).setAttribute("minimizada","N" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 19   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(21)).setAttribute("ancho","100" );
      ((Element)v.get(21)).setAttribute("minimizable","S" );
      ((Element)v.get(21)).setAttribute("minimizada","N" );
      ((Element)v.get(19)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 19   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(22)).setAttribute("ancho","100" );
      ((Element)v.get(22)).setAttribute("minimizable","S" );
      ((Element)v.get(22)).setAttribute("minimizada","N" );
      ((Element)v.get(19)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 19   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(23)).setAttribute("ancho","100" );
      ((Element)v.get(23)).setAttribute("minimizable","S" );
      ((Element)v.get(23)).setAttribute("minimizada","N" );
      ((Element)v.get(19)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 19   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(24)).setAttribute("ancho","100" );
      ((Element)v.get(24)).setAttribute("minimizable","S" );
      ((Element)v.get(24)).setAttribute("minimizada","N" );
      ((Element)v.get(19)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 19   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(25)).setAttribute("ancho","100" );
      ((Element)v.get(25)).setAttribute("minimizable","S" );
      ((Element)v.get(25)).setAttribute("minimizada","N" );
      ((Element)v.get(19)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */
      /* Termina nodo:19   */

      /* Empieza nodo:26 / Elemento padre: 9   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(26)).setAttribute("alto","20" );
      ((Element)v.get(26)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(26)).setAttribute("imgFondo","" );
      ((Element)v.get(26)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(9)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(27)).setAttribute("colFondo","" );
      ((Element)v.get(27)).setAttribute("ID","EstCab" );
      ((Element)v.get(27)).setAttribute("cod","9" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 26   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(28)).setAttribute("colFondo","" );
      ((Element)v.get(28)).setAttribute("ID","EstCab" );
      ((Element)v.get(28)).setAttribute("cod","1414" );
      ((Element)v.get(26)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 26   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(29)).setAttribute("colFondo","" );
      ((Element)v.get(29)).setAttribute("ID","EstCab" );
      ((Element)v.get(29)).setAttribute("cod","1415" );
      ((Element)v.get(26)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 26   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(30)).setAttribute("colFondo","" );
      ((Element)v.get(30)).setAttribute("ID","EstCab" );
      ((Element)v.get(30)).setAttribute("cod","469" );
      ((Element)v.get(26)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 26   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(31)).setAttribute("colFondo","" );
      ((Element)v.get(31)).setAttribute("ID","EstCab" );
      ((Element)v.get(31)).setAttribute("cod","1416" );
      ((Element)v.get(26)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 26   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(32)).setAttribute("colFondo","" );
      ((Element)v.get(32)).setAttribute("ID","EstCab" );
      ((Element)v.get(32)).setAttribute("cod","1418" );
      ((Element)v.get(26)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */
      /* Termina nodo:26   */

      /* Empieza nodo:33 / Elemento padre: 9   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(33)).setAttribute("alto","22" );
      ((Element)v.get(33)).setAttribute("accion","" );
      ((Element)v.get(33)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(33)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(33)).setAttribute("maxSel","-1" );
      ((Element)v.get(33)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(33)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(33)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(33)).setAttribute("onLoad","" );
      ((Element)v.get(33)).setAttribute("colorSelecc","#D0D9E8" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(9)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(34)).setAttribute("tipo","texto" );
      ((Element)v.get(34)).setAttribute("ID","EstDat" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 33   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(35)).setAttribute("tipo","texto" );
      ((Element)v.get(35)).setAttribute("ID","EstDat2" );
      ((Element)v.get(33)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 33   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(36)).setAttribute("tipo","texto" );
      ((Element)v.get(36)).setAttribute("ID","EstDat" );
      ((Element)v.get(33)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 33   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(37)).setAttribute("tipo","texto" );
      ((Element)v.get(37)).setAttribute("ID","EstDat2" );
      ((Element)v.get(33)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 33   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(38)).setAttribute("tipo","texto" );
      ((Element)v.get(38)).setAttribute("ID","EstDat" );
      ((Element)v.get(33)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 33   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(39)).setAttribute("tipo","texto" );
      ((Element)v.get(39)).setAttribute("ID","EstDat2" );
      ((Element)v.get(33)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:33   */

      /* Empieza nodo:40 / Elemento padre: 9   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(9)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(41)).setAttribute("ID","1" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(42)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(42)).setAttribute("TIPO","STRING" );
      ((Element)v.get(42)).setAttribute("VALOR","COD0" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 41   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(43)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(43)).setAttribute("TIPO","STRING" );
      ((Element)v.get(43)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(41)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 41   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(44)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(44)).setAttribute("TIPO","STRING" );
      ((Element)v.get(44)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(41)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 41   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(45)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(45)).setAttribute("TIPO","STRING" );
      ((Element)v.get(45)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(41)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 41   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(46)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(46)).setAttribute("TIPO","STRING" );
      ((Element)v.get(46)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(41)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 41   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(47)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(47)).setAttribute("TIPO","STRING" );
      ((Element)v.get(47)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(41)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 41   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(48)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(48)).setAttribute("TIPO","STRING" );
      ((Element)v.get(48)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(41)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:41   */

      /* Empieza nodo:49 / Elemento padre: 40   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(49)).setAttribute("ID","2" );
      ((Element)v.get(40)).appendChild((Element)v.get(49));

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
      ((Element)v.get(51)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(49)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 49   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(52)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(52)).setAttribute("TIPO","STRING" );
      ((Element)v.get(52)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(49)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 49   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(53)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(53)).setAttribute("TIPO","STRING" );
      ((Element)v.get(53)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(49)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 49   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(54)).setAttribute("NOMBRE","dato4" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(54)).setAttribute("TIPO","STRING" );
      ((Element)v.get(54)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(49)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 49   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(55)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(55)).setAttribute("TIPO","STRING" );
      ((Element)v.get(55)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(49)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 49   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(56)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(56)).setAttribute("TIPO","STRING" );
      ((Element)v.get(56)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(49)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:49   */

      /* Empieza nodo:57 / Elemento padre: 40   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(57)).setAttribute("ID","3" );
      ((Element)v.get(40)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(58)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(58)).setAttribute("TIPO","STRING" );
      ((Element)v.get(58)).setAttribute("VALOR","COD2" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 57   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(59)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(59)).setAttribute("TIPO","STRING" );
      ((Element)v.get(59)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(57)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 57   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(60)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(60)).setAttribute("TIPO","STRING" );
      ((Element)v.get(60)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(57)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 57   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(61)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(61)).setAttribute("TIPO","STRING" );
      ((Element)v.get(61)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(57)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 57   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(62)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(62)).setAttribute("TIPO","STRING" );
      ((Element)v.get(62)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(57)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 57   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(63)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(63)).setAttribute("TIPO","STRING" );
      ((Element)v.get(63)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(57)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 57   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(64)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(64)).setAttribute("TIPO","STRING" );
      ((Element)v.get(64)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(57)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:57   */

      /* Empieza nodo:65 / Elemento padre: 40   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(65)).setAttribute("ID","1" );
      ((Element)v.get(40)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(66)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(66)).setAttribute("TIPO","STRING" );
      ((Element)v.get(66)).setAttribute("VALOR","COD3" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 65   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(67)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(67)).setAttribute("TIPO","STRING" );
      ((Element)v.get(67)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(65)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */

      /* Empieza nodo:68 / Elemento padre: 65   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(68)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(68)).setAttribute("TIPO","STRING" );
      ((Element)v.get(68)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(65)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */

      /* Empieza nodo:69 / Elemento padre: 65   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(69)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(69)).setAttribute("TIPO","STRING" );
      ((Element)v.get(69)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(65)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */

      /* Empieza nodo:70 / Elemento padre: 65   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(70)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(70)).setAttribute("TIPO","STRING" );
      ((Element)v.get(70)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(65)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 65   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(71)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(71)).setAttribute("TIPO","STRING" );
      ((Element)v.get(71)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(65)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */

      /* Empieza nodo:72 / Elemento padre: 65   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(72)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(72)).setAttribute("TIPO","STRING" );
      ((Element)v.get(72)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(65)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:65   */

      /* Empieza nodo:73 / Elemento padre: 40   */
      v.add(doc.createElement("ROW"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(73)).setAttribute("ID","2" );
      ((Element)v.get(40)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(74)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(74)).setAttribute("TIPO","STRING" );
      ((Element)v.get(74)).setAttribute("VALOR","COD4" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */

      /* Empieza nodo:75 / Elemento padre: 73   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(75)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(75)).setAttribute("TIPO","STRING" );
      ((Element)v.get(75)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(73)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */

      /* Empieza nodo:76 / Elemento padre: 73   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(76)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(76)).setAttribute("TIPO","STRING" );
      ((Element)v.get(76)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(73)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */

      /* Empieza nodo:77 / Elemento padre: 73   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(77)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(77)).setAttribute("TIPO","STRING" );
      ((Element)v.get(77)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(73)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */

      /* Empieza nodo:78 / Elemento padre: 73   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(78)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(78)).setAttribute("TIPO","STRING" );
      ((Element)v.get(78)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(73)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */

      /* Empieza nodo:79 / Elemento padre: 73   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(79)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(79)).setAttribute("TIPO","STRING" );
      ((Element)v.get(79)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(73)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */

      /* Empieza nodo:80 / Elemento padre: 73   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(80)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(80)).setAttribute("TIPO","STRING" );
      ((Element)v.get(80)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(73)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:73   */

      /* Empieza nodo:81 / Elemento padre: 40   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(81)).setAttribute("ID","3" );
      ((Element)v.get(40)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(82)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(82)).setAttribute("TIPO","STRING" );
      ((Element)v.get(82)).setAttribute("VALOR","COD5" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 81   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(83)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(83)).setAttribute("TIPO","STRING" );
      ((Element)v.get(83)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(81)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */

      /* Empieza nodo:84 / Elemento padre: 81   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(84)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(84)).setAttribute("TIPO","STRING" );
      ((Element)v.get(84)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(81)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */

      /* Empieza nodo:85 / Elemento padre: 81   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(85)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(85)).setAttribute("TIPO","STRING" );
      ((Element)v.get(85)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(81)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 81   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(86)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(86)).setAttribute("TIPO","STRING" );
      ((Element)v.get(86)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(81)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 81   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(87)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(87)).setAttribute("TIPO","STRING" );
      ((Element)v.get(87)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(81)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */

      /* Empieza nodo:88 / Elemento padre: 81   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(88)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(88)).setAttribute("TIPO","STRING" );
      ((Element)v.get(88)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(81)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:81   */

      /* Empieza nodo:89 / Elemento padre: 40   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(89)).setAttribute("ID","3" );
      ((Element)v.get(40)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(90)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(90)).setAttribute("TIPO","STRING" );
      ((Element)v.get(90)).setAttribute("VALOR","COD6" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */

      /* Empieza nodo:91 / Elemento padre: 89   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(91)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(91)).setAttribute("TIPO","STRING" );
      ((Element)v.get(91)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(89)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 89   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(92)).setAttribute("NOMBRE","dato4" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(92)).setAttribute("TIPO","STRING" );
      ((Element)v.get(92)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(89)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */

      /* Empieza nodo:93 / Elemento padre: 89   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(93)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(93)).setAttribute("TIPO","STRING" );
      ((Element)v.get(93)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(89)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */

      /* Empieza nodo:94 / Elemento padre: 89   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(94)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(94)).setAttribute("TIPO","STRING" );
      ((Element)v.get(94)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(89)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */

      /* Empieza nodo:95 / Elemento padre: 89   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(95)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(95)).setAttribute("TIPO","STRING" );
      ((Element)v.get(95)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(89)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */

      /* Empieza nodo:96 / Elemento padre: 89   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(96)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(96)).setAttribute("TIPO","STRING" );
      ((Element)v.get(96)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(89)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:89   */

      /* Empieza nodo:97 / Elemento padre: 40   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(97)).setAttribute("ID","1" );
      ((Element)v.get(40)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(98)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(98)).setAttribute("TIPO","STRING" );
      ((Element)v.get(98)).setAttribute("VALOR","COD0" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */

      /* Empieza nodo:99 / Elemento padre: 97   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(99)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(99)).setAttribute("TIPO","STRING" );
      ((Element)v.get(99)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(97)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */

      /* Empieza nodo:100 / Elemento padre: 97   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(100)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(100)).setAttribute("TIPO","STRING" );
      ((Element)v.get(100)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(97)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */

      /* Empieza nodo:101 / Elemento padre: 97   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(101)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(101)).setAttribute("TIPO","STRING" );
      ((Element)v.get(101)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(97)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */

      /* Empieza nodo:102 / Elemento padre: 97   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(102)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(102)).setAttribute("TIPO","STRING" );
      ((Element)v.get(102)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(97)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */

      /* Empieza nodo:103 / Elemento padre: 97   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(103)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(103)).setAttribute("TIPO","STRING" );
      ((Element)v.get(103)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(97)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */

      /* Empieza nodo:104 / Elemento padre: 97   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(104)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(104)).setAttribute("TIPO","STRING" );
      ((Element)v.get(104)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(97)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:97   */

      /* Empieza nodo:105 / Elemento padre: 40   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(105)).setAttribute("ID","2" );
      ((Element)v.get(40)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(106)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(106)).setAttribute("TIPO","STRING" );
      ((Element)v.get(106)).setAttribute("VALOR","COD1" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */

      /* Empieza nodo:107 / Elemento padre: 105   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(107)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(107)).setAttribute("TIPO","STRING" );
      ((Element)v.get(107)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(105)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */

      /* Empieza nodo:108 / Elemento padre: 105   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(108)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(108)).setAttribute("TIPO","STRING" );
      ((Element)v.get(108)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(105)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */

      /* Empieza nodo:109 / Elemento padre: 105   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(109)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(109)).setAttribute("TIPO","STRING" );
      ((Element)v.get(109)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(105)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */

      /* Empieza nodo:110 / Elemento padre: 105   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(110)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(110)).setAttribute("TIPO","STRING" );
      ((Element)v.get(110)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(105)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */

      /* Empieza nodo:111 / Elemento padre: 105   */
      v.add(doc.createElement("CAMPO"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(111)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(111)).setAttribute("TIPO","STRING" );
      ((Element)v.get(111)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(105)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */

      /* Empieza nodo:112 / Elemento padre: 105   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(112)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(112)).setAttribute("TIPO","STRING" );
      ((Element)v.get(112)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(105)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:105   */

      /* Empieza nodo:113 / Elemento padre: 40   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(113)).setAttribute("ID","3" );
      ((Element)v.get(40)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(114)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(114)).setAttribute("TIPO","STRING" );
      ((Element)v.get(114)).setAttribute("VALOR","COD2" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */

      /* Empieza nodo:115 / Elemento padre: 113   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(115)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(115)).setAttribute("TIPO","STRING" );
      ((Element)v.get(115)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(113)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */

      /* Empieza nodo:116 / Elemento padre: 113   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(116)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(116)).setAttribute("TIPO","STRING" );
      ((Element)v.get(116)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(113)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */

      /* Empieza nodo:117 / Elemento padre: 113   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(117)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(117)).setAttribute("TIPO","STRING" );
      ((Element)v.get(117)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(113)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */

      /* Empieza nodo:118 / Elemento padre: 113   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(118)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(118)).setAttribute("TIPO","STRING" );
      ((Element)v.get(118)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(113)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */

      /* Empieza nodo:119 / Elemento padre: 113   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(119)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(119)).setAttribute("TIPO","STRING" );
      ((Element)v.get(119)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(113)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */

      /* Empieza nodo:120 / Elemento padre: 113   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(120)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(120)).setAttribute("TIPO","STRING" );
      ((Element)v.get(120)).setAttribute("VALOR","xxxxxxxxxx,x1" );
      ((Element)v.get(113)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:113   */
      /* Termina nodo:40   */

      /* Empieza nodo:121 / Elemento padre: 9   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(121)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(121)).setAttribute("ancho","500" );
      ((Element)v.get(121)).setAttribute("sep","$" );
      ((Element)v.get(121)).setAttribute("x","12" );
      ((Element)v.get(121)).setAttribute("class","botonera" );
      ((Element)v.get(121)).setAttribute("y","306" );
      ((Element)v.get(121)).setAttribute("control","|" );
      ((Element)v.get(121)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(121)).setAttribute("rowset","" );
      ((Element)v.get(121)).setAttribute("cargainicial","N" );
      ((Element)v.get(9)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(122)).setAttribute("nombre","ret1" );
      ((Element)v.get(122)).setAttribute("x","37" );
      ((Element)v.get(122)).setAttribute("y","310" );
      ((Element)v.get(122)).setAttribute("ID","botonContenido" );
      ((Element)v.get(122)).setAttribute("img","retroceder_on" );
      ((Element)v.get(122)).setAttribute("tipo","0" );
      ((Element)v.get(122)).setAttribute("estado","false" );
      ((Element)v.get(122)).setAttribute("alt","" );
      ((Element)v.get(122)).setAttribute("codigo","" );
      ((Element)v.get(122)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */

      /* Empieza nodo:123 / Elemento padre: 121   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(123)).setAttribute("nombre","ava1" );
      ((Element)v.get(123)).setAttribute("x","52" );
      ((Element)v.get(123)).setAttribute("y","310" );
      ((Element)v.get(123)).setAttribute("ID","botonContenido" );
      ((Element)v.get(123)).setAttribute("img","avanzar_on" );
      ((Element)v.get(123)).setAttribute("tipo","0" );
      ((Element)v.get(123)).setAttribute("estado","false" );
      ((Element)v.get(123)).setAttribute("alt","" );
      ((Element)v.get(123)).setAttribute("codigo","" );
      ((Element)v.get(123)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(121)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:121   */
      /* Termina nodo:9   */

      /* Empieza nodo:124 / Elemento padre: 3   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(124)).setAttribute("nombre","primera1" );
      ((Element)v.get(124)).setAttribute("x","20" );
      ((Element)v.get(124)).setAttribute("y","310" );
      ((Element)v.get(124)).setAttribute("ID","botonContenido" );
      ((Element)v.get(124)).setAttribute("img","primera_on" );
      ((Element)v.get(124)).setAttribute("tipo","-2" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(124)).setAttribute("estado","false" );
      ((Element)v.get(124)).setAttribute("alt","" );
      ((Element)v.get(124)).setAttribute("codigo","" );
      ((Element)v.get(124)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(3)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */

      /* Empieza nodo:125 / Elemento padre: 3   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(125)).setAttribute("nombre","separa" );
      ((Element)v.get(125)).setAttribute("x","59" );
      ((Element)v.get(125)).setAttribute("y","306" );
      ((Element)v.get(125)).setAttribute("ID","botonContenido" );
      ((Element)v.get(125)).setAttribute("img","separa_base" );
      ((Element)v.get(125)).setAttribute("tipo","0" );
      ((Element)v.get(125)).setAttribute("estado","false" );
      ((Element)v.get(125)).setAttribute("alt","" );
      ((Element)v.get(125)).setAttribute("codigo","" );
      ((Element)v.get(125)).setAttribute("accion","" );
      ((Element)v.get(3)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */

      /* Empieza nodo:126 / Elemento padre: 3   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(126)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(126)).setAttribute("alto","12" );
      ((Element)v.get(126)).setAttribute("ancho","50" );
      ((Element)v.get(126)).setAttribute("x","0" );
      ((Element)v.get(126)).setAttribute("y","329" );
      ((Element)v.get(3)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:3   */


   }

}
