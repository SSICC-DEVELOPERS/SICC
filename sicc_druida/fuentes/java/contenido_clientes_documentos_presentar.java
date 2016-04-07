
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_clientes_documentos_presentar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_clientes_documentos_presentar" );
      ((Element)v.get(0)).setAttribute("cod","0561" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("STYLE"));
      ((Element)v.get(1)).setAttribute("TYPE","text/css" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Elemento padre:1 / Elemento actual: 2   */
      v.add(doc.createTextNode("\r   \r\r#ret1Div {visibility:hidden;}\r#ava1Div {visibility:hidden;}\r#primera1Div {visibility:hidden;}\r#separaDiv {visibility:hidden;}\r#Cplistado1{visibility:hidden;}\r#CpLin1listado1{visibility:hidden;}\r#CpLin2listado1{visibility:hidden;}\r#CpLin3listado1{visibility:hidden;}\r#CpLin4listado1{visibility:hidden;}\r\r   \r"));
      ((Element)v.get(1)).appendChild((Text)v.get(2));

      /* Termina nodo Texto:2   */
      /* Termina nodo:1   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(6)).setAttribute("src","i18NJS.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(7)).setAttribute("src","contenido_clientes_documentos_presentar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(8)).setAttribute("nombre","formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(8));

      /* Empieza nodo:9 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","idioma" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","pais" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","casoUso" );
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
      ((Element)v.get(14)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","oidCliente" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","oidTipoCliente" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","oidSubtipoCliente" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","indConsultoraInterna" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","oidContacto" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 8   */
      v.add(doc.createElement("table"));
      ((Element)v.get(22)).setAttribute("width","100%" );
      ((Element)v.get(22)).setAttribute("border","0" );
      ((Element)v.get(22)).setAttribute("cellspacing","0" );
      ((Element)v.get(22)).setAttribute("cellpadding","0" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(8)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(22)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(24)).setAttribute("width","100%" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(25)).setAttribute("src","b.gif" );
      ((Element)v.get(25)).setAttribute("width","424" );
      ((Element)v.get(25)).setAttribute("height","8" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */
      /* Termina nodo:24   */
      /* Termina nodo:23   */
      /* Termina nodo:22   */

      /* Empieza nodo:26 / Elemento padre: 8   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(26)).setAttribute("nombre","listado1" );
      ((Element)v.get(26)).setAttribute("ancho","400" );
      ((Element)v.get(26)).setAttribute("alto","301" );
      ((Element)v.get(26)).setAttribute("x","12" );
      ((Element)v.get(26)).setAttribute("y","12" );
      ((Element)v.get(26)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(26)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(8)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(27)).setAttribute("precarga","S" );
      ((Element)v.get(27)).setAttribute("conROver","S" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(28)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(28)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(28)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(28)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 27   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(29)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(29)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(29)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(29)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(27)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 27   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(30)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(30)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(27)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */
      /* Termina nodo:27   */

      /* Empieza nodo:31 / Elemento padre: 26   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(26)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(32)).setAttribute("borde","1" );
      ((Element)v.get(32)).setAttribute("horizDatos","1" );
      ((Element)v.get(32)).setAttribute("horizCabecera","1" );
      ((Element)v.get(32)).setAttribute("vertical","0" );
      ((Element)v.get(32)).setAttribute("horizTitulo","1" );
      ((Element)v.get(32)).setAttribute("horizBase","1" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 31   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(33)).setAttribute("borde","#999999" );
      ((Element)v.get(33)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(33)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(33)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(33)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(33)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(33)).setAttribute("horizBase","#999999" );
      ((Element)v.get(31)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */
      /* Termina nodo:31   */

      /* Empieza nodo:34 / Elemento padre: 26   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(34)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(34)).setAttribute("alto","22" );
      ((Element)v.get(34)).setAttribute("imgFondo","" );
      ((Element)v.get(34)).setAttribute("cod","00431" );
      ((Element)v.get(34)).setAttribute("ID","datosTitle" );
      ((Element)v.get(26)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 26   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(35)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(35)).setAttribute("alto","22" );
      ((Element)v.get(35)).setAttribute("imgFondo","" );
      ((Element)v.get(26)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 26   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(36)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(36)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(36)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(36)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(36)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(36)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(26)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(37)).setAttribute("ancho","1" );
      ((Element)v.get(37)).setAttribute("minimizable","S" );
      ((Element)v.get(37)).setAttribute("minimizada","N" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:38 / Elemento padre: 26   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(38)).setAttribute("alto","20" );
      ((Element)v.get(38)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(38)).setAttribute("imgFondo","" );
      ((Element)v.get(38)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(26)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(39)).setAttribute("colFondo","" );
      ((Element)v.get(39)).setAttribute("ID","EstCab" );
      ((Element)v.get(39)).setAttribute("align","center" );
      ((Element)v.get(39)).setAttribute("cod","2785" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:40 / Elemento padre: 26   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(40)).setAttribute("alto","22" );
      ((Element)v.get(40)).setAttribute("accion","" );
      ((Element)v.get(40)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(40)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(40)).setAttribute("maxSel","-1" );
      ((Element)v.get(40)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(40)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(40)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(40)).setAttribute("onLoad","" );
      ((Element)v.get(40)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(26)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(41)).setAttribute("tipo","texto" );
      ((Element)v.get(41)).setAttribute("ID","EstDat" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:42 / Elemento padre: 26   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(26)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 26   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(43)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(43)).setAttribute("ancho","400" );
      ((Element)v.get(43)).setAttribute("sep","$" );
      ((Element)v.get(43)).setAttribute("x","12" );
      ((Element)v.get(43)).setAttribute("class","botonera" );
      ((Element)v.get(43)).setAttribute("y","290" );
      ((Element)v.get(43)).setAttribute("control","|" );
      ((Element)v.get(43)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(43)).setAttribute("onload","procesarPaginado(mipgndo, msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(43)).setAttribute("rowset","" );
      ((Element)v.get(43)).setAttribute("cargainicial","N" );
      ((Element)v.get(26)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(44)).setAttribute("nombre","ret1" );
      ((Element)v.get(44)).setAttribute("x","37" );
      ((Element)v.get(44)).setAttribute("y","294" );
      ((Element)v.get(44)).setAttribute("ID","botonContenido" );
      ((Element)v.get(44)).setAttribute("img","retroceder_on" );
      ((Element)v.get(44)).setAttribute("tipo","0" );
      ((Element)v.get(44)).setAttribute("estado","false" );
      ((Element)v.get(44)).setAttribute("alt","" );
      ((Element)v.get(44)).setAttribute("codigo","" );
      ((Element)v.get(44)).setAttribute("ontab","document.all['ava1I'].parentElement.focus();" );
      ((Element)v.get(44)).setAttribute("onshtab","document.all['primera1I'].parentElement.focus();" );
      ((Element)v.get(44)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 43   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(45)).setAttribute("nombre","ava1" );
      ((Element)v.get(45)).setAttribute("x","52" );
      ((Element)v.get(45)).setAttribute("y","294" );
      ((Element)v.get(45)).setAttribute("ID","botonContenido" );
      ((Element)v.get(45)).setAttribute("img","avanzar_on" );
      ((Element)v.get(45)).setAttribute("tipo","0" );
      ((Element)v.get(45)).setAttribute("estado","false" );
      ((Element)v.get(45)).setAttribute("alt","" );
      ((Element)v.get(45)).setAttribute("codigo","" );
      ((Element)v.get(45)).setAttribute("ontab","navPestana('lblDireccion');" );
      ((Element)v.get(45)).setAttribute("onshtab","document.all['ret1I'].parentElement.focus();" );
      ((Element)v.get(45)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(43)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:43   */
      /* Termina nodo:26   */

      /* Empieza nodo:46 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(46)).setAttribute("nombre","primera1" );
      ((Element)v.get(46)).setAttribute("x","20" );
      ((Element)v.get(46)).setAttribute("y","294" );
      ((Element)v.get(46)).setAttribute("ID","botonContenido" );
      ((Element)v.get(46)).setAttribute("img","primera_on" );
      ((Element)v.get(46)).setAttribute("tipo","-2" );
      ((Element)v.get(46)).setAttribute("estado","false" );
      ((Element)v.get(46)).setAttribute("alt","" );
      ((Element)v.get(46)).setAttribute("codigo","" );
      ((Element)v.get(46)).setAttribute("ontab","document.all['ret1I'].parentElement.focus();" );
      ((Element)v.get(46)).setAttribute("onshtab","document.all['ava1I'].parentElement.focus();" );
      ((Element)v.get(46)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(8)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(47)).setAttribute("nombre","separa" );
      ((Element)v.get(47)).setAttribute("x","59" );
      ((Element)v.get(47)).setAttribute("y","290" );
      ((Element)v.get(47)).setAttribute("ID","botonContenido" );
      ((Element)v.get(47)).setAttribute("img","separa_base" );
      ((Element)v.get(47)).setAttribute("tipo","0" );
      ((Element)v.get(47)).setAttribute("estado","false" );
      ((Element)v.get(47)).setAttribute("alt","" );
      ((Element)v.get(47)).setAttribute("codigo","" );
      ((Element)v.get(47)).setAttribute("accion","" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(8)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 8   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(48)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(48)).setAttribute("alto","12" );
      ((Element)v.get(48)).setAttribute("ancho","100%" );
      ((Element)v.get(48)).setAttribute("colorf","" );
      ((Element)v.get(48)).setAttribute("borde","0" );
      ((Element)v.get(48)).setAttribute("imagenf","" );
      ((Element)v.get(48)).setAttribute("repeat","" );
      ((Element)v.get(48)).setAttribute("padding","" );
      ((Element)v.get(48)).setAttribute("visibilidad","visible" );
      ((Element)v.get(48)).setAttribute("contravsb","" );
      ((Element)v.get(48)).setAttribute("x","0" );
      ((Element)v.get(48)).setAttribute("y","313" );
      ((Element)v.get(48)).setAttribute("zindex","" );
      ((Element)v.get(8)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:8   */


   }

}
