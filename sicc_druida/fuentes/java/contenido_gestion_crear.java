
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_gestion_crear  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_gestion_crear" );
      ((Element)v.get(0)).setAttribute("cod","0246" );
      ((Element)v.get(0)).setAttribute("titulo","Crear Gestión" );
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
      ((Element)v.get(4)).setAttribute("src","contenido_gestion_crear.js" );
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
      ((Element)v.get(7)).setAttribute("nombre","conectorAction" );
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
      ((Element)v.get(10)).setAttribute("nombre","hIdioma" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","hPais" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","hOidAccionCob" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(13)).setAttribute("nombre","capaEspacio1" );
      ((Element)v.get(5)).appendChild((Element)v.get(13));

      /* Empieza nodo:14 / Elemento padre: 13   */
      v.add(doc.createElement("table"));
      ((Element)v.get(14)).setAttribute("width","100%" );
      ((Element)v.get(14)).setAttribute("border","0" );
      ((Element)v.get(14)).setAttribute("cellspacing","0" );
      ((Element)v.get(14)).setAttribute("cellpadding","0" );
      ((Element)v.get(13)).appendChild((Element)v.get(14));

      /* Empieza nodo:15 / Elemento padre: 14   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(14)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("td"));
      ((Element)v.get(15)).appendChild((Element)v.get(16));

      /* Empieza nodo:17 / Elemento padre: 16   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(17)).setAttribute("src","b.gif" );
      ((Element)v.get(17)).setAttribute("width","524" );
      ((Element)v.get(17)).setAttribute("height","12" );
      ((Element)v.get(16)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */
      /* Termina nodo:16   */
      /* Termina nodo:15   */
      /* Termina nodo:14   */
      /* Termina nodo:13   */

      /* Empieza nodo:18 / Elemento padre: 5   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(18)).setAttribute("nombre","listado1" );
      ((Element)v.get(18)).setAttribute("ancho","500" );
      ((Element)v.get(18)).setAttribute("alto","299" );
      ((Element)v.get(18)).setAttribute("x","12" );
      ((Element)v.get(18)).setAttribute("y","12" );
      ((Element)v.get(18)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(18)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(5)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(19)).setAttribute("precarga","S" );
      ((Element)v.get(19)).setAttribute("conROver","S" );
      ((Element)v.get(18)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(20)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(20)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(20)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(20)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 19   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(21)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(21)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(21)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(21)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(19)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 19   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(22)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(22)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(19)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */
      /* Termina nodo:19   */

      /* Empieza nodo:23 / Elemento padre: 18   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(18)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(24)).setAttribute("borde","1" );
      ((Element)v.get(24)).setAttribute("horizDatos","1" );
      ((Element)v.get(24)).setAttribute("horizCabecera","1" );
      ((Element)v.get(24)).setAttribute("vertical","1" );
      ((Element)v.get(24)).setAttribute("horizTitulo","1" );
      ((Element)v.get(24)).setAttribute("horizBase","1" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 23   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(25)).setAttribute("borde","#999999" );
      ((Element)v.get(25)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(25)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(25)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(25)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(25)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(25)).setAttribute("horizBase","#999999" );
      ((Element)v.get(23)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */
      /* Termina nodo:23   */

      /* Empieza nodo:26 / Elemento padre: 18   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(26)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(26)).setAttribute("alto","22" );
      ((Element)v.get(26)).setAttribute("imgFondo","" );
      ((Element)v.get(26)).setAttribute("cod","00436" );
      ((Element)v.get(26)).setAttribute("ID","datosTitle" );
      ((Element)v.get(18)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 18   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(27)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(27)).setAttribute("alto","22" );
      ((Element)v.get(27)).setAttribute("imgFondo","" );
      ((Element)v.get(18)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 18   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(28)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(28)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(28)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(28)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(28)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(28)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(18)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(29)).setAttribute("ancho","110" );
      ((Element)v.get(29)).setAttribute("minimizable","S" );
      ((Element)v.get(29)).setAttribute("minimizada","N" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 28   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(30)).setAttribute("ancho","200" );
      ((Element)v.get(30)).setAttribute("minimizable","S" );
      ((Element)v.get(30)).setAttribute("minimizada","N" );
      ((Element)v.get(28)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 28   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(31)).setAttribute("ancho","80" );
      ((Element)v.get(31)).setAttribute("minimizable","S" );
      ((Element)v.get(31)).setAttribute("minimizada","N" );
      ((Element)v.get(28)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */
      /* Termina nodo:28   */

      /* Empieza nodo:32 / Elemento padre: 18   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(32)).setAttribute("alto","20" );
      ((Element)v.get(32)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(32)).setAttribute("imgFondo","" );
      ((Element)v.get(32)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(18)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(33)).setAttribute("colFondo","" );
      ((Element)v.get(33)).setAttribute("ID","EstCab" );
      ((Element)v.get(33)).setAttribute("cod","816" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 32   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(34)).setAttribute("colFondo","" );
      ((Element)v.get(34)).setAttribute("ID","EstCab" );
      ((Element)v.get(34)).setAttribute("cod","842" );
      ((Element)v.get(32)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 32   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(35)).setAttribute("colFondo","" );
      ((Element)v.get(35)).setAttribute("ID","EstCab" );
      ((Element)v.get(35)).setAttribute("cod","994" );
      ((Element)v.get(32)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */
      /* Termina nodo:32   */

      /* Empieza nodo:36 / Elemento padre: 18   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(36)).setAttribute("alto","22" );
      ((Element)v.get(36)).setAttribute("accion","" );
      ((Element)v.get(36)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(36)).setAttribute("formaEnvio","xml" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(36)).setAttribute("maxSel","1" );
      ((Element)v.get(36)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(36)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(36)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(36)).setAttribute("onLoad","" );
      ((Element)v.get(36)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(18)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(37)).setAttribute("tipo","texto" );
      ((Element)v.get(37)).setAttribute("ID","EstDat" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 36   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(38)).setAttribute("tipo","texto" );
      ((Element)v.get(38)).setAttribute("ID","EstDat2" );
      ((Element)v.get(36)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 36   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(39)).setAttribute("tipo","texto" );
      ((Element)v.get(39)).setAttribute("ID","EstDat" );
      ((Element)v.get(36)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:36   */

      /* Empieza nodo:40 / Elemento padre: 18   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(18)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 18   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(41)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(41)).setAttribute("ancho","524" );
      ((Element)v.get(41)).setAttribute("sep","$" );
      ((Element)v.get(41)).setAttribute("x","12" );
      ((Element)v.get(41)).setAttribute("class","botonera" );
      ((Element)v.get(41)).setAttribute("y","288" );
      ((Element)v.get(41)).setAttribute("control","|" );
      ((Element)v.get(41)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(41)).setAttribute("rowset","" );
      ((Element)v.get(41)).setAttribute("cargainicial","N" );
      ((Element)v.get(18)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(42)).setAttribute("nombre","ret1" );
      ((Element)v.get(42)).setAttribute("x","37" );
      ((Element)v.get(42)).setAttribute("y","292" );
      ((Element)v.get(42)).setAttribute("ID","botonContenido" );
      ((Element)v.get(42)).setAttribute("img","retroceder_on" );
      ((Element)v.get(42)).setAttribute("tipo","0" );
      ((Element)v.get(42)).setAttribute("estado","false" );
      ((Element)v.get(42)).setAttribute("alt","" );
      ((Element)v.get(42)).setAttribute("codigo","" );
      ((Element)v.get(42)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 41   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(43)).setAttribute("nombre","ava1" );
      ((Element)v.get(43)).setAttribute("x","52" );
      ((Element)v.get(43)).setAttribute("y","292" );
      ((Element)v.get(43)).setAttribute("ID","botonContenido" );
      ((Element)v.get(43)).setAttribute("img","avanzar_on" );
      ((Element)v.get(43)).setAttribute("tipo","0" );
      ((Element)v.get(43)).setAttribute("estado","false" );
      ((Element)v.get(43)).setAttribute("alt","" );
      ((Element)v.get(43)).setAttribute("codigo","" );
      ((Element)v.get(43)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(41)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:41   */
      /* Termina nodo:18   */

      /* Empieza nodo:44 / Elemento padre: 5   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(44)).setAttribute("nombre","primera1" );
      ((Element)v.get(44)).setAttribute("x","20" );
      ((Element)v.get(44)).setAttribute("y","292" );
      ((Element)v.get(44)).setAttribute("ID","botonContenido" );
      ((Element)v.get(44)).setAttribute("img","primera_on" );
      ((Element)v.get(44)).setAttribute("tipo","-2" );
      ((Element)v.get(44)).setAttribute("estado","false" );
      ((Element)v.get(44)).setAttribute("alt","" );
      ((Element)v.get(44)).setAttribute("codigo","" );
      ((Element)v.get(44)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(5)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 5   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(45)).setAttribute("nombre","separa" );
      ((Element)v.get(45)).setAttribute("x","59" );
      ((Element)v.get(45)).setAttribute("y","288" );
      ((Element)v.get(45)).setAttribute("ID","botonContenido" );
      ((Element)v.get(45)).setAttribute("img","separa_base" );
      ((Element)v.get(45)).setAttribute("tipo","0" );
      ((Element)v.get(45)).setAttribute("estado","false" );
      ((Element)v.get(45)).setAttribute("alt","" );
      ((Element)v.get(45)).setAttribute("codigo","" );
      ((Element)v.get(45)).setAttribute("accion","" );
      ((Element)v.get(5)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 5   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(46)).setAttribute("nombre","Crear" );
      ((Element)v.get(46)).setAttribute("x","80" );
      ((Element)v.get(46)).setAttribute("y","289" );
      ((Element)v.get(46)).setAttribute("ID","botonContenido" );
      ((Element)v.get(46)).setAttribute("tipo","html" );
      ((Element)v.get(46)).setAttribute("estado","false" );
      ((Element)v.get(46)).setAttribute("cod","835" );
      ((Element)v.get(46)).setAttribute("accion","crearOnClick();" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(46)).setAttribute("onshtab","focalizaBotonHTML_XY('Crear');" );
      ((Element)v.get(46)).setAttribute("ontab","focalizaBotonHTML_XY('Crear');" );
      ((Element)v.get(5)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(47)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(47)).setAttribute("alto","12" );
      ((Element)v.get(47)).setAttribute("ancho","50" );
      ((Element)v.get(47)).setAttribute("colorf","" );
      ((Element)v.get(47)).setAttribute("borde","0" );
      ((Element)v.get(47)).setAttribute("imagenf","" );
      ((Element)v.get(47)).setAttribute("repeat","" );
      ((Element)v.get(47)).setAttribute("padding","" );
      ((Element)v.get(47)).setAttribute("visibilidad","visible" );
      ((Element)v.get(47)).setAttribute("contravsb","" );
      ((Element)v.get(47)).setAttribute("x","0" );
      ((Element)v.get(47)).setAttribute("y","311" );
      ((Element)v.get(47)).setAttribute("zindex","" );
      ((Element)v.get(5)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:5   */


   }

}
