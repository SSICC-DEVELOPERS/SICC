
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_participantes_seleccionar_ranking  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_participantes_seleccionar_ranking" );
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
      ((Element)v.get(4)).setAttribute("src","pestanyas_concurso_ranking_inc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(6)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(7)).setAttribute("src","contenido_participantes_seleccionar_ranking.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(8)).setAttribute("nombre","formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(8));

      /* Empieza nodo:9 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","accion" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","hidIngresoPAR" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","lstClasificacionParticipantes" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","lstClasificacionParticipantesConsultoras" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hidUltimoElementoEnLaLista" );
      ((Element)v.get(15)).setAttribute("valor","1" );
      ((Element)v.get(8)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 8   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(16)).setAttribute("nombre","capaEspacio1" );
      ((Element)v.get(16)).setAttribute("x","0" );
      ((Element)v.get(16)).setAttribute("y","0" );
      ((Element)v.get(8)).appendChild((Element)v.get(16));

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
      ((Element)v.get(19)).setAttribute("width","12" );
      ((Element)v.get(19)).setAttribute("align","center" );
      ((Element)v.get(18)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(20)).setAttribute("src","b.gif" );
      ((Element)v.get(20)).setAttribute("width","12" );
      ((Element)v.get(20)).setAttribute("height","12" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */
      /* Termina nodo:19   */

      /* Empieza nodo:21 / Elemento padre: 18   */
      v.add(doc.createElement("td"));
      ((Element)v.get(21)).setAttribute("width","750" );
      ((Element)v.get(18)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(22)).setAttribute("src","b.gif" );
      ((Element)v.get(21)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */
      /* Termina nodo:21   */

      /* Empieza nodo:23 / Elemento padre: 18   */
      v.add(doc.createElement("td"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(23)).setAttribute("width","12" );
      ((Element)v.get(18)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(24)).setAttribute("src","b.gif" );
      ((Element)v.get(24)).setAttribute("width","12" );
      ((Element)v.get(24)).setAttribute("height","1" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */
      /* Termina nodo:23   */
      /* Termina nodo:18   */

      /* Empieza nodo:25 / Elemento padre: 17   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(17)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(27)).setAttribute("src","b.gif" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */
      /* Termina nodo:26   */

      /* Empieza nodo:28 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(28)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(30)).setAttribute("class","legend" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(31)).setAttribute("nombre","lblParticipantes" );
      ((Element)v.get(31)).setAttribute("alto","13" );
      ((Element)v.get(31)).setAttribute("filas","1" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(31)).setAttribute("id","legend" );
      ((Element)v.get(31)).setAttribute("cod","0022" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */
      /* Termina nodo:30   */

      /* Empieza nodo:32 / Elemento padre: 29   */
      v.add(doc.createElement("table"));
      ((Element)v.get(32)).setAttribute("width","100%" );
      ((Element)v.get(32)).setAttribute("border","0" );
      ((Element)v.get(32)).setAttribute("align","center" );
      ((Element)v.get(32)).setAttribute("cellspacing","0" );
      ((Element)v.get(32)).setAttribute("cellpadding","0" );
      ((Element)v.get(29)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("table"));
      ((Element)v.get(35)).setAttribute("width","648" );
      ((Element)v.get(35)).setAttribute("align","left" );
      ((Element)v.get(35)).setAttribute("border","0" );
      ((Element)v.get(35)).setAttribute("cellspacing","0" );
      ((Element)v.get(35)).setAttribute("cellpadding","0" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).setAttribute("colspan","3" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(38)).setAttribute("src","b.gif" );
      ((Element)v.get(38)).setAttribute("width","8" );
      ((Element)v.get(38)).setAttribute("height","653" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */
      /* Termina nodo:35   */
      /* Termina nodo:34   */
      /* Termina nodo:33   */
      /* Termina nodo:32   */
      /* Termina nodo:29   */
      /* Termina nodo:28   */
      /* Termina nodo:25   */

      /* Empieza nodo:39 / Elemento padre: 17   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(17)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(41)).setAttribute("src","b.gif" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:42 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("table"));
      ((Element)v.get(44)).setAttribute("width","100%" );
      ((Element)v.get(44)).setAttribute("border","0" );
      ((Element)v.get(44)).setAttribute("align","center" );
      ((Element)v.get(44)).setAttribute("cellspacing","0" );
      ((Element)v.get(44)).setAttribute("cellpadding","0" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).setAttribute("class","botonera" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(47)).setAttribute("nombre","btnAceptar" );
      ((Element)v.get(47)).setAttribute("ID","botonContenido" );
      ((Element)v.get(47)).setAttribute("tipo","html" );
      ((Element)v.get(47)).setAttribute("accion","accionAceptar();" );
      ((Element)v.get(47)).setAttribute("estado","false" );
      ((Element)v.get(47)).setAttribute("cod","12" );
      ((Element)v.get(47)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnAnadirTodos');" );
      ((Element)v.get(47)).setAttribute("ontab","focalizaBotonHTML('botonContenido','btnExcluir');" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */
      /* Termina nodo:45   */
      /* Termina nodo:44   */
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:48 / Elemento padre: 39   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).setAttribute("width","8" );
      ((Element)v.get(49)).setAttribute("height","12" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */
      /* Termina nodo:39   */

      /* Empieza nodo:50 / Elemento padre: 17   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(17)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).setAttribute("width","12" );
      ((Element)v.get(51)).setAttribute("align","center" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(52)).setAttribute("src","b.gif" );
      ((Element)v.get(52)).setAttribute("width","12" );
      ((Element)v.get(52)).setAttribute("height","12" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:53 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).setAttribute("width","756" );
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
      ((Element)v.get(56)).setAttribute("height","1" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */
      /* Termina nodo:50   */
      /* Termina nodo:17   */
      /* Termina nodo:16   */

      /* Empieza nodo:57 / Elemento padre: 8   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(57)).setAttribute("nombre","listado1" );
      ((Element)v.get(57)).setAttribute("ancho","620" );
      ((Element)v.get(57)).setAttribute("alto","301" );
      ((Element)v.get(57)).setAttribute("x","26" );
      ((Element)v.get(57)).setAttribute("y","37" );
      ((Element)v.get(57)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(57)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(8)).appendChild((Element)v.get(57));

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
      ((Element)v.get(63)).setAttribute("vertical","0" );
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
      ((Element)v.get(65)).setAttribute("cod","00312" );
      ((Element)v.get(65)).setAttribute("ID","datosTitle" );
      ((Element)v.get(57)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */

      /* Empieza nodo:66 / Elemento padre: 57   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(66)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(66)).setAttribute("alto","22" );
   }

   private void getXML270(Document doc) {
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
      ((Element)v.get(67)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(57)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(68)).setAttribute("ancho","30" );
      ((Element)v.get(68)).setAttribute("minimizable","S" );
      ((Element)v.get(68)).setAttribute("minimizada","N" );
      ((Element)v.get(68)).setAttribute("oculta","S" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */

      /* Empieza nodo:69 / Elemento padre: 67   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(69)).setAttribute("ancho","30" );
      ((Element)v.get(69)).setAttribute("minimizable","S" );
      ((Element)v.get(69)).setAttribute("minimizada","N" );
      ((Element)v.get(69)).setAttribute("oculta","S" );
      ((Element)v.get(67)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */

      /* Empieza nodo:70 / Elemento padre: 67   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(70)).setAttribute("ancho","5" );
      ((Element)v.get(70)).setAttribute("minimizable","S" );
      ((Element)v.get(70)).setAttribute("minimizada","N" );
      ((Element)v.get(67)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:67   */

      /* Empieza nodo:71 / Elemento padre: 57   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(71)).setAttribute("alto","20" );
      ((Element)v.get(71)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(71)).setAttribute("imgFondo","" );
      ((Element)v.get(71)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(57)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(72)).setAttribute("colFondo","" );
      ((Element)v.get(72)).setAttribute("ID","EstCab" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Elemento padre:72 / Elemento actual: 73   */
      v.add(doc.createTextNode("oidParticipanteConsultora"));
      ((Element)v.get(72)).appendChild((Text)v.get(73));

      /* Termina nodo Texto:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:74 / Elemento padre: 71   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(74)).setAttribute("colFondo","" );
      ((Element)v.get(74)).setAttribute("ID","EstCab" );
      ((Element)v.get(71)).appendChild((Element)v.get(74));

      /* Elemento padre:74 / Elemento actual: 75   */
      v.add(doc.createTextNode("oidParticipante"));
      ((Element)v.get(74)).appendChild((Text)v.get(75));

      /* Termina nodo Texto:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 71   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(76)).setAttribute("colFondo","" );
      ((Element)v.get(76)).setAttribute("ID","EstCab" );
      ((Element)v.get(76)).setAttribute("cod","9" );
      ((Element)v.get(76)).setAttribute("align","center" );
      ((Element)v.get(71)).appendChild((Element)v.get(76));

      /* Elemento padre:76 / Elemento actual: 77   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(76)).appendChild((Text)v.get(77));

      /* Termina nodo Texto:77   */
      /* Termina nodo:76   */
      /* Termina nodo:71   */

      /* Empieza nodo:78 / Elemento padre: 57   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(78)).setAttribute("alto","22" );
      ((Element)v.get(78)).setAttribute("accion","" );
      ((Element)v.get(78)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(78)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(78)).setAttribute("maxSel","-1" );
      ((Element)v.get(78)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(78)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(78)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(78)).setAttribute("onLoad","" );
      ((Element)v.get(78)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(57)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(79)).setAttribute("tipo","texto" );
      ((Element)v.get(79)).setAttribute("ID","EstDat2" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */

      /* Empieza nodo:80 / Elemento padre: 78   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(80)).setAttribute("tipo","texto" );
      ((Element)v.get(80)).setAttribute("ID","EstDat2" );
      ((Element)v.get(78)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */

      /* Empieza nodo:81 / Elemento padre: 78   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(81)).setAttribute("tipo","texto" );
      ((Element)v.get(81)).setAttribute("ID","EstDat" );
      ((Element)v.get(78)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:78   */

      /* Empieza nodo:82 / Elemento padre: 57   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(57)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 57   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(83)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(83)).setAttribute("ancho","500" );
      ((Element)v.get(83)).setAttribute("sep","$" );
      ((Element)v.get(83)).setAttribute("x","12" );
      ((Element)v.get(83)).setAttribute("class","botonera" );
      ((Element)v.get(83)).setAttribute("y","315" );
      ((Element)v.get(83)).setAttribute("control","|" );
      ((Element)v.get(83)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(83)).setAttribute("rowset","" );
      ((Element)v.get(83)).setAttribute("cargainicial","N" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(57)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(84)).setAttribute("nombre","ret1" );
      ((Element)v.get(84)).setAttribute("x","37" );
      ((Element)v.get(84)).setAttribute("y","319" );
      ((Element)v.get(84)).setAttribute("ID","botonContenido" );
      ((Element)v.get(84)).setAttribute("img","retroceder_on" );
      ((Element)v.get(84)).setAttribute("tipo","0" );
      ((Element)v.get(84)).setAttribute("estado","false" );
      ((Element)v.get(84)).setAttribute("alt","" );
      ((Element)v.get(84)).setAttribute("codigo","" );
      ((Element)v.get(84)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */

      /* Empieza nodo:85 / Elemento padre: 83   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(85)).setAttribute("nombre","ava1" );
      ((Element)v.get(85)).setAttribute("x","52" );
      ((Element)v.get(85)).setAttribute("y","319" );
      ((Element)v.get(85)).setAttribute("ID","botonContenido" );
      ((Element)v.get(85)).setAttribute("img","avanzar_on" );
      ((Element)v.get(85)).setAttribute("tipo","0" );
      ((Element)v.get(85)).setAttribute("estado","false" );
      ((Element)v.get(85)).setAttribute("alt","" );
      ((Element)v.get(85)).setAttribute("codigo","" );
      ((Element)v.get(85)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(83)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:83   */
      /* Termina nodo:57   */

      /* Empieza nodo:86 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(86)).setAttribute("nombre","primera1" );
      ((Element)v.get(86)).setAttribute("x","20" );
      ((Element)v.get(86)).setAttribute("y","319" );
      ((Element)v.get(86)).setAttribute("ID","botonContenido" );
      ((Element)v.get(86)).setAttribute("img","primera_on" );
      ((Element)v.get(86)).setAttribute("tipo","-2" );
      ((Element)v.get(86)).setAttribute("estado","false" );
      ((Element)v.get(86)).setAttribute("alt","" );
      ((Element)v.get(86)).setAttribute("codigo","" );
      ((Element)v.get(86)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(8)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(87)).setAttribute("nombre","separa" );
      ((Element)v.get(87)).setAttribute("x","59" );
      ((Element)v.get(87)).setAttribute("y","315" );
      ((Element)v.get(87)).setAttribute("ID","botonContenido" );
      ((Element)v.get(87)).setAttribute("img","separa_base" );
      ((Element)v.get(87)).setAttribute("tipo","0" );
      ((Element)v.get(87)).setAttribute("estado","false" );
      ((Element)v.get(87)).setAttribute("alt","" );
      ((Element)v.get(87)).setAttribute("codigo","" );
      ((Element)v.get(87)).setAttribute("accion","" );
      ((Element)v.get(8)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */

      /* Empieza nodo:88 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(88)).setAttribute("nombre","btnExcluir" );
      ((Element)v.get(88)).setAttribute("x","27" );
      ((Element)v.get(88)).setAttribute("y","316" );
      ((Element)v.get(88)).setAttribute("ID","botonContenido" );
      ((Element)v.get(88)).setAttribute("tipo","html" );
      ((Element)v.get(88)).setAttribute("estado","false" );
      ((Element)v.get(88)).setAttribute("accion","accionExcluir();" );
      ((Element)v.get(88)).setAttribute("cod","2421" );
      ((Element)v.get(88)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnAceptar');" );
      ((Element)v.get(88)).setAttribute("ontab","focalizaBotonHTML('botonContenido','btnExcluirTodos');" );
      ((Element)v.get(8)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */

      /* Empieza nodo:89 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(89)).setAttribute("nombre","btnExcluirTodos" );
      ((Element)v.get(89)).setAttribute("x","75" );
      ((Element)v.get(89)).setAttribute("y","316" );
      ((Element)v.get(89)).setAttribute("ID","botonContenido" );
      ((Element)v.get(89)).setAttribute("tipo","html" );
      ((Element)v.get(89)).setAttribute("accion","accionExcluirTodos();" );
      ((Element)v.get(89)).setAttribute("estado","false" );
      ((Element)v.get(89)).setAttribute("cod","2422" );
      ((Element)v.get(89)).setAttribute("ontab","focalizaBotonHTML('botonContenido','btnAnadir');" );
      ((Element)v.get(8)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */

      /* Empieza nodo:90 / Elemento padre: 8   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(90)).setAttribute("nombre","listado2" );
      ((Element)v.get(90)).setAttribute("ancho","620" );
      ((Element)v.get(90)).setAttribute("alto","301" );
      ((Element)v.get(90)).setAttribute("x","26" );
      ((Element)v.get(90)).setAttribute("y","362" );
      ((Element)v.get(90)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(90)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(8)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(91)).setAttribute("precarga","S" );
      ((Element)v.get(91)).setAttribute("conROver","S" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(92)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(92)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(92)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(92)).setAttribute("desactivado","btnLista2D.gif" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */

      /* Empieza nodo:93 / Elemento padre: 91   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(93)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(93)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(93)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(93)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(91)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */

      /* Empieza nodo:94 / Elemento padre: 91   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(94)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(94)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(91)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:91   */

      /* Empieza nodo:95 / Elemento padre: 90   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(90)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(96)).setAttribute("borde","1" );
      ((Element)v.get(96)).setAttribute("horizDatos","1" );
      ((Element)v.get(96)).setAttribute("horizCabecera","1" );
      ((Element)v.get(96)).setAttribute("vertical","0" );
      ((Element)v.get(96)).setAttribute("horizTitulo","1" );
      ((Element)v.get(96)).setAttribute("horizBase","1" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */

      /* Empieza nodo:97 / Elemento padre: 95   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(97)).setAttribute("borde","#999999" );
      ((Element)v.get(97)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(97)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(97)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(97)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(97)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(97)).setAttribute("horizBase","#999999" );
      ((Element)v.get(95)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:95   */

      /* Empieza nodo:98 / Elemento padre: 90   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(98)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(98)).setAttribute("alto","22" );
      ((Element)v.get(98)).setAttribute("imgFondo","" );
      ((Element)v.get(98)).setAttribute("cod","00313" );
      ((Element)v.get(98)).setAttribute("ID","datosTitle" );
      ((Element)v.get(90)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */

      /* Empieza nodo:99 / Elemento padre: 90   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(99)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(99)).setAttribute("alto","22" );
      ((Element)v.get(99)).setAttribute("imgFondo","" );
      ((Element)v.get(90)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */

      /* Empieza nodo:100 / Elemento padre: 90   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(100)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(100)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(100)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(100)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(100)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(100)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(90)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(101)).setAttribute("ancho","5" );
      ((Element)v.get(101)).setAttribute("minimizable","S" );
      ((Element)v.get(101)).setAttribute("minimizada","N" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:102 / Elemento padre: 90   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(102)).setAttribute("alto","20" );
      ((Element)v.get(102)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(102)).setAttribute("imgFondo","" );
      ((Element)v.get(102)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(90)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(103)).setAttribute("colFondo","" );
      ((Element)v.get(103)).setAttribute("ID","EstCab" );
      ((Element)v.get(103)).setAttribute("cod","9" );
      ((Element)v.get(103)).setAttribute("align","center" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));

      /* Elemento padre:103 / Elemento actual: 104   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(103)).appendChild((Text)v.get(104));

      /* Termina nodo Texto:104   */
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:105 / Elemento padre: 90   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(105)).setAttribute("alto","22" );
      ((Element)v.get(105)).setAttribute("accion","" );
      ((Element)v.get(105)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(105)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(105)).setAttribute("maxSel","-1" );
      ((Element)v.get(105)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(105)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(105)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(105)).setAttribute("onLoad","" );
      ((Element)v.get(105)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(90)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(106)).setAttribute("tipo","texto" );
      ((Element)v.get(106)).setAttribute("ID","EstDat" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:107 / Elemento padre: 90   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(90)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */

      /* Empieza nodo:108 / Elemento padre: 90   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(108)).setAttribute("nombre","mipgndo2" );
      ((Element)v.get(108)).setAttribute("ancho","500" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(108)).setAttribute("sep","$" );
      ((Element)v.get(108)).setAttribute("x","12" );
      ((Element)v.get(108)).setAttribute("class","botonera" );
      ((Element)v.get(108)).setAttribute("y","640" );
      ((Element)v.get(108)).setAttribute("control","|" );
      ((Element)v.get(108)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(108)).setAttribute("rowset","" );
      ((Element)v.get(108)).setAttribute("cargainicial","N" );
      ((Element)v.get(90)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(109)).setAttribute("nombre","ret2" );
      ((Element)v.get(109)).setAttribute("x","37" );
      ((Element)v.get(109)).setAttribute("y","644" );
      ((Element)v.get(109)).setAttribute("ID","botonContenido" );
      ((Element)v.get(109)).setAttribute("img","retroceder_on" );
      ((Element)v.get(109)).setAttribute("tipo","0" );
      ((Element)v.get(109)).setAttribute("estado","false" );
      ((Element)v.get(109)).setAttribute("alt","" );
      ((Element)v.get(109)).setAttribute("codigo","" );
      ((Element)v.get(109)).setAttribute("accion","mipgndo2.retroceder();" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */

      /* Empieza nodo:110 / Elemento padre: 108   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(110)).setAttribute("nombre","ava2" );
      ((Element)v.get(110)).setAttribute("x","52" );
      ((Element)v.get(110)).setAttribute("y","644" );
      ((Element)v.get(110)).setAttribute("ID","botonContenido" );
      ((Element)v.get(110)).setAttribute("img","avanzar_on" );
      ((Element)v.get(110)).setAttribute("tipo","0" );
      ((Element)v.get(110)).setAttribute("estado","false" );
      ((Element)v.get(110)).setAttribute("alt","" );
      ((Element)v.get(110)).setAttribute("codigo","" );
      ((Element)v.get(110)).setAttribute("accion","mipgndo2.avanzar();" );
      ((Element)v.get(108)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:108   */
      /* Termina nodo:90   */

      /* Empieza nodo:111 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(111)).setAttribute("nombre","primera2" );
      ((Element)v.get(111)).setAttribute("x","20" );
      ((Element)v.get(111)).setAttribute("y","644" );
      ((Element)v.get(111)).setAttribute("ID","botonContenido" );
      ((Element)v.get(111)).setAttribute("img","primera_on" );
      ((Element)v.get(111)).setAttribute("tipo","-2" );
      ((Element)v.get(111)).setAttribute("estado","false" );
      ((Element)v.get(111)).setAttribute("alt","" );
      ((Element)v.get(111)).setAttribute("codigo","" );
      ((Element)v.get(111)).setAttribute("accion","mipgndo2.retrocederPrimeraPagina();" );
      ((Element)v.get(8)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */

      /* Empieza nodo:112 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(112)).setAttribute("nombre","separa2" );
      ((Element)v.get(112)).setAttribute("x","59" );
      ((Element)v.get(112)).setAttribute("y","640" );
      ((Element)v.get(112)).setAttribute("ID","botonContenido" );
      ((Element)v.get(112)).setAttribute("img","separa_base" );
      ((Element)v.get(112)).setAttribute("tipo","0" );
      ((Element)v.get(112)).setAttribute("estado","false" );
      ((Element)v.get(112)).setAttribute("alt","" );
      ((Element)v.get(112)).setAttribute("codigo","" );
      ((Element)v.get(112)).setAttribute("accion","" );
      ((Element)v.get(8)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */

      /* Empieza nodo:113 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(113)).setAttribute("nombre","btnAnadir" );
      ((Element)v.get(113)).setAttribute("x","27" );
      ((Element)v.get(113)).setAttribute("y","641" );
      ((Element)v.get(113)).setAttribute("ID","botonContenido" );
      ((Element)v.get(113)).setAttribute("tipo","html" );
      ((Element)v.get(113)).setAttribute("estado","false" );
      ((Element)v.get(113)).setAttribute("accion","accionAniadir();" );
      ((Element)v.get(113)).setAttribute("cod","404" );
      ((Element)v.get(113)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnExcluirTodos');" );
      ((Element)v.get(8)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */

      /* Empieza nodo:114 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(114)).setAttribute("nombre","btnAnadirTodos" );
      ((Element)v.get(114)).setAttribute("x","75" );
      ((Element)v.get(114)).setAttribute("y","641" );
      ((Element)v.get(114)).setAttribute("ID","botonContenido" );
      ((Element)v.get(114)).setAttribute("tipo","html" );
      ((Element)v.get(114)).setAttribute("estado","false" );
      ((Element)v.get(114)).setAttribute("cod","1670" );
      ((Element)v.get(114)).setAttribute("accion","accionAniadirTodos();" );
      ((Element)v.get(114)).setAttribute("ontab","focalizaBotonHTML('botonContenido','btnAceptar');" );
      ((Element)v.get(8)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:8   */


   }

}
