
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_cliente_consultar_detalle  implements es.indra.druida.base.ObjetoXML {
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
         

      getXML810(doc);
         

      getXML900(doc);
         

      getXML990(doc);
         

      getXML1080(doc);
         

      getXML1170(doc);
         

      getXML1260(doc);
         

      getXML1350(doc);
         

      getXML1440(doc);
         

      getXML1530(doc);
         

      getXML1620(doc);
         

      getXML1710(doc);
         

      getXML1800(doc);
         

      getXML1890(doc);
         

      getXML1980(doc);
         

      getXML2070(doc);
         

      getXML2160(doc);
         

      getXML2250(doc);
         

      getXML2340(doc);
         

      getXML2430(doc);
         

      getXML2520(doc);
         

      getXML2610(doc);
         

      getXML2700(doc);
         

      getXML2790(doc);
         

      getXML2880(doc);
         

      getXML2970(doc);
         

      getXML3060(doc);
         

      getXML3150(doc);
         

      getXML3240(doc);
         

      getXML3330(doc);
         

      getXML3420(doc);
         

      getXML3510(doc);
         

      getXML3600(doc);
         

      getXML3690(doc);
         

      getXML3780(doc);
         

      getXML3870(doc);
         

      getXML3960(doc);
         

      getXML4050(doc);
         

      getXML4140(doc);
         

      getXML4230(doc);
         

      getXML4320(doc);
         

      getXML4410(doc);
         

      getXML4500(doc);
         

      getXML4590(doc);
         
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
      ((Element)v.get(0)).setAttribute("onload","Init()" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","contenido_cliente_consultar_detalle.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(4)).setAttribute("nombre","frmInsertarCliente" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(5)).setAttribute("nombre","accion" );
      ((Element)v.get(5)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(6)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","dtoOid" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","hidCapasAMostrar" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","hidPestanya" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","hidCodigoCliente" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","hFormatoFechaPais" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","hidSexo" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hidTratamiento" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hidFormaPago" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hidNacionalidad" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hidEstadoCivil" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hidNSE" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hidNivelEstudios" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hidCicloVidaFamiliar" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).setAttribute("nombre","hidCorresp" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","hidInbound" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hidTipoClienteContactado" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hidPaisClienteContactado" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hFechaNacimiento" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hchkIndActivo" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","codCliente" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hidDescTipoCliente" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 4   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(30)).setAttribute("nombre","listado0" );
      ((Element)v.get(30)).setAttribute("ancho","711" );
      ((Element)v.get(30)).setAttribute("alto","115" );
      ((Element)v.get(30)).setAttribute("x","12" );
      ((Element)v.get(30)).setAttribute("y","12" );
      ((Element)v.get(30)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(30)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(4)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(31)).setAttribute("precarga","S" );
      ((Element)v.get(31)).setAttribute("conROver","S" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(32)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(32)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(32)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(32)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 31   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(33)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(33)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(33)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(33)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(31)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 31   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(34)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(34)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(31)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */
      /* Termina nodo:31   */

      /* Empieza nodo:35 / Elemento padre: 30   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(30)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(36)).setAttribute("borde","1" );
      ((Element)v.get(36)).setAttribute("horizDatos","1" );
      ((Element)v.get(36)).setAttribute("horizCabecera","1" );
      ((Element)v.get(36)).setAttribute("vertical","1" );
      ((Element)v.get(36)).setAttribute("horizTitulo","1" );
      ((Element)v.get(36)).setAttribute("horizBase","1" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 35   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(37)).setAttribute("borde","#999999" );
      ((Element)v.get(37)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(37)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(37)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(37)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(37)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(37)).setAttribute("horizBase","#999999" );
      ((Element)v.get(35)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */
      /* Termina nodo:35   */

      /* Empieza nodo:38 / Elemento padre: 30   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(38)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(38)).setAttribute("alto","22" );
      ((Element)v.get(38)).setAttribute("imgFondo","" );
      ((Element)v.get(38)).setAttribute("cod","00135" );
      ((Element)v.get(38)).setAttribute("ID","datosTitle" );
      ((Element)v.get(30)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 30   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(39)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(39)).setAttribute("alto","22" );
      ((Element)v.get(39)).setAttribute("imgFondo","" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(30)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 30   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(40)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(40)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(40)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(40)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(40)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(40)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(30)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(41)).setAttribute("ancho","30" );
      ((Element)v.get(41)).setAttribute("minimizable","S" );
      ((Element)v.get(41)).setAttribute("minimizada","N" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 40   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(42)).setAttribute("ancho","30" );
      ((Element)v.get(42)).setAttribute("minimizable","S" );
      ((Element)v.get(42)).setAttribute("minimizada","N" );
      ((Element)v.get(40)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:40   */

      /* Empieza nodo:43 / Elemento padre: 30   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(43)).setAttribute("alto","20" );
      ((Element)v.get(43)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(43)).setAttribute("imgFondo","" );
      ((Element)v.get(43)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(30)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(44)).setAttribute("colFondo","" );
      ((Element)v.get(44)).setAttribute("ID","EstCab" );
      ((Element)v.get(44)).setAttribute("cod","393" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 43   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(45)).setAttribute("colFondo","" );
      ((Element)v.get(45)).setAttribute("ID","EstCab" );
      ((Element)v.get(45)).setAttribute("cod","595" );
      ((Element)v.get(43)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:43   */

      /* Empieza nodo:46 / Elemento padre: 30   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(46)).setAttribute("alto","22" );
      ((Element)v.get(46)).setAttribute("accion","" );
      ((Element)v.get(46)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(46)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(46)).setAttribute("maxSel","-1" );
      ((Element)v.get(46)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(46)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(46)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(46)).setAttribute("onLoad","" );
      ((Element)v.get(46)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(30)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(47)).setAttribute("tipo","texto" );
      ((Element)v.get(47)).setAttribute("ID","EstDat" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 46   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(48)).setAttribute("tipo","texto" );
      ((Element)v.get(48)).setAttribute("ID","EstDat2" );
      ((Element)v.get(46)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:46   */

      /* Empieza nodo:49 / Elemento padre: 30   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(30)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 30   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(50)).setAttribute("nombre","mipgndo0" );
      ((Element)v.get(50)).setAttribute("ancho","668" );
      ((Element)v.get(50)).setAttribute("sep","$" );
      ((Element)v.get(50)).setAttribute("x","12" );
      ((Element)v.get(50)).setAttribute("class","botonera" );
      ((Element)v.get(50)).setAttribute("y","104" );
      ((Element)v.get(50)).setAttribute("control","|" );
      ((Element)v.get(50)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(50)).setAttribute("rowset","" );
      ((Element)v.get(50)).setAttribute("cargainicial","N" );
      ((Element)v.get(30)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(51)).setAttribute("nombre","ret0" );
      ((Element)v.get(51)).setAttribute("x","37" );
      ((Element)v.get(51)).setAttribute("y","104" );
      ((Element)v.get(51)).setAttribute("ID","botonContenido" );
      ((Element)v.get(51)).setAttribute("img","retroceder_on" );
      ((Element)v.get(51)).setAttribute("tipo","0" );
      ((Element)v.get(51)).setAttribute("estado","false" );
      ((Element)v.get(51)).setAttribute("alt","" );
      ((Element)v.get(51)).setAttribute("codigo","" );
      ((Element)v.get(51)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 50   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(52)).setAttribute("nombre","ava0" );
      ((Element)v.get(52)).setAttribute("x","52" );
      ((Element)v.get(52)).setAttribute("y","104" );
      ((Element)v.get(52)).setAttribute("ID","botonContenido" );
      ((Element)v.get(52)).setAttribute("img","avanzar_on" );
      ((Element)v.get(52)).setAttribute("tipo","0" );
      ((Element)v.get(52)).setAttribute("estado","false" );
      ((Element)v.get(52)).setAttribute("alt","" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(52)).setAttribute("codigo","" );
      ((Element)v.get(52)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(50)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:50   */
      /* Termina nodo:30   */

      /* Empieza nodo:53 / Elemento padre: 4   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(53)).setAttribute("nombre","primera0" );
      ((Element)v.get(53)).setAttribute("x","20" );
      ((Element)v.get(53)).setAttribute("y","104" );
      ((Element)v.get(53)).setAttribute("ID","botonContenido" );
      ((Element)v.get(53)).setAttribute("img","primera_on" );
      ((Element)v.get(53)).setAttribute("tipo","-2" );
      ((Element)v.get(53)).setAttribute("estado","false" );
      ((Element)v.get(53)).setAttribute("alt","" );
      ((Element)v.get(53)).setAttribute("codigo","" );
      ((Element)v.get(53)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(4)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 4   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(54)).setAttribute("nombre","Siguiente0" );
      ((Element)v.get(54)).setAttribute("x","13" );
      ((Element)v.get(54)).setAttribute("y","105" );
      ((Element)v.get(54)).setAttribute("ID","botonContenido" );
      ((Element)v.get(54)).setAttribute("img","" );
      ((Element)v.get(54)).setAttribute("tipo","html" );
      ((Element)v.get(54)).setAttribute("estado","false" );
      ((Element)v.get(54)).setAttribute("alt","" );
      ((Element)v.get(54)).setAttribute("cod","446" );
      ((Element)v.get(54)).setAttribute("accion","navegaPestaniasDetalle('1');" );
      ((Element)v.get(4)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(55)).setAttribute("nombre","capaFormulario1" );
      ((Element)v.get(55)).setAttribute("x","0" );
      ((Element)v.get(55)).setAttribute("y","0" );
      ((Element)v.get(55)).setAttribute("ancho","100%" );
      ((Element)v.get(55)).setAttribute("alto","100" );
      ((Element)v.get(55)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(4)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("table"));
      ((Element)v.get(56)).setAttribute("width","100%" );
      ((Element)v.get(56)).setAttribute("border","0" );
      ((Element)v.get(56)).setAttribute("cellspacing","0" );
      ((Element)v.get(56)).setAttribute("cellpadding","0" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).setAttribute("width","12" );
      ((Element)v.get(58)).setAttribute("align","center" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(59)).setAttribute("src","b.gif" );
      ((Element)v.get(59)).setAttribute("width","12" );
      ((Element)v.get(59)).setAttribute("height","12" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:60 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).setAttribute("width","750" );
      ((Element)v.get(57)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(61)).setAttribute("src","b.gif" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:62 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).setAttribute("width","12" );
      ((Element)v.get(57)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(63)).setAttribute("src","b.gif" );
      ((Element)v.get(63)).setAttribute("width","12" );
      ((Element)v.get(63)).setAttribute("height","1" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */
      /* Termina nodo:57   */

      /* Empieza nodo:64 / Elemento padre: 56   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(56)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(66)).setAttribute("src","b.gif" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:67 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(69)).setAttribute("class","legend" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(70)).setAttribute("nombre","lbl1TitDatosComunes" );
      ((Element)v.get(70)).setAttribute("alto","13" );
      ((Element)v.get(70)).setAttribute("filas","1" );
      ((Element)v.get(70)).setAttribute("valor","" );
      ((Element)v.get(70)).setAttribute("cod","00159" );
      ((Element)v.get(70)).setAttribute("id","legend" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:71 / Elemento padre: 68   */
      v.add(doc.createElement("table"));
      ((Element)v.get(71)).setAttribute("width","100%" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(71)).setAttribute("border","0" );
      ((Element)v.get(71)).setAttribute("align","center" );
      ((Element)v.get(71)).setAttribute("cellspacing","0" );
      ((Element)v.get(71)).setAttribute("cellpadding","0" );
      ((Element)v.get(68)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("table"));
      ((Element)v.get(74)).setAttribute("width","708" );
      ((Element)v.get(74)).setAttribute("border","0" );
      ((Element)v.get(74)).setAttribute("align","left" );
      ((Element)v.get(74)).setAttribute("cellspacing","0" );
      ((Element)v.get(74)).setAttribute("cellpadding","0" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).setAttribute("colspan","4" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(77)).setAttribute("src","b.gif" );
      ((Element)v.get(77)).setAttribute("width","8" );
      ((Element)v.get(77)).setAttribute("height","8" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:78 / Elemento padre: 74   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(74)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(80)).setAttribute("src","b.gif" );
      ((Element)v.get(80)).setAttribute("width","8" );
      ((Element)v.get(80)).setAttribute("height","8" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:81 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(82)).setAttribute("nombre","lbl1CodCliente" );
      ((Element)v.get(82)).setAttribute("alto","13" );
      ((Element)v.get(82)).setAttribute("filas","1" );
      ((Element)v.get(82)).setAttribute("valor","" );
      ((Element)v.get(82)).setAttribute("id","datosTitle" );
      ((Element)v.get(82)).setAttribute("cod","263" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).setAttribute("width","100%" );
      ((Element)v.get(78)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(84)).setAttribute("src","b.gif" );
      ((Element)v.get(84)).setAttribute("width","8" );
      ((Element)v.get(84)).setAttribute("height","8" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */
      /* Termina nodo:78   */

      /* Empieza nodo:85 / Elemento padre: 74   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(74)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(87)).setAttribute("src","b.gif" );
      ((Element)v.get(87)).setAttribute("width","8" );
      ((Element)v.get(87)).setAttribute("height","8" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:88 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(89)).setAttribute("nombre","lbl1CodClienteActual" );
      ((Element)v.get(89)).setAttribute("alto","13" );
      ((Element)v.get(89)).setAttribute("filas","1" );
      ((Element)v.get(89)).setAttribute("valor","" );
      ((Element)v.get(89)).setAttribute("id","datosCampos" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:90 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).setAttribute("width","100%" );
      ((Element)v.get(85)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(91)).setAttribute("src","b.gif" );
      ((Element)v.get(91)).setAttribute("width","8" );
      ((Element)v.get(91)).setAttribute("height","8" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:85   */

      /* Empieza nodo:92 / Elemento padre: 74   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(74)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).setAttribute("colspan","4" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(94)).setAttribute("src","b.gif" );
      ((Element)v.get(94)).setAttribute("width","8" );
      ((Element)v.get(94)).setAttribute("height","8" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:74   */
      /* Termina nodo:73   */
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:95 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(64)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(96)).setAttribute("src","b.gif" );
      ((Element)v.get(96)).setAttribute("width","8" );
      ((Element)v.get(96)).setAttribute("height","12" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:64   */

      /* Empieza nodo:97 / Elemento padre: 56   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(56)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).setAttribute("width","12" );
      ((Element)v.get(98)).setAttribute("align","center" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(99)).setAttribute("src","b.gif" );
      ((Element)v.get(99)).setAttribute("width","12" );
      ((Element)v.get(99)).setAttribute("height","24" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:100 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).setAttribute("width","750" );
      ((Element)v.get(97)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(101)).setAttribute("src","b.gif" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:102 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).setAttribute("width","12" );
      ((Element)v.get(97)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).setAttribute("width","12" );
      ((Element)v.get(103)).setAttribute("height","24" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:97   */
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:104 / Elemento padre: 4   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(104)).setAttribute("nombre","listado1" );
      ((Element)v.get(104)).setAttribute("ancho","711" );
      ((Element)v.get(104)).setAttribute("alto","317" );
      ((Element)v.get(104)).setAttribute("x","12" );
      ((Element)v.get(104)).setAttribute("y","92" );
      ((Element)v.get(104)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(104)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(4)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(105)).setAttribute("precarga","S" );
      ((Element)v.get(105)).setAttribute("conROver","S" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(106)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(106)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(106)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(106)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */

      /* Empieza nodo:107 / Elemento padre: 105   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(107)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(107)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(107)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(107)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(105)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */

      /* Empieza nodo:108 / Elemento padre: 105   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(108)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(108)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(105)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:105   */

      /* Empieza nodo:109 / Elemento padre: 104   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(104)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(110)).setAttribute("borde","1" );
      ((Element)v.get(110)).setAttribute("horizDatos","1" );
      ((Element)v.get(110)).setAttribute("horizCabecera","1" );
      ((Element)v.get(110)).setAttribute("vertical","1" );
      ((Element)v.get(110)).setAttribute("horizTitulo","1" );
      ((Element)v.get(110)).setAttribute("horizBase","1" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */

      /* Empieza nodo:111 / Elemento padre: 109   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(111)).setAttribute("borde","#999999" );
      ((Element)v.get(111)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(111)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(111)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(111)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(111)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(111)).setAttribute("horizBase","#999999" );
      ((Element)v.get(109)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:109   */

      /* Empieza nodo:112 / Elemento padre: 104   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(112)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(112)).setAttribute("alto","22" );
      ((Element)v.get(112)).setAttribute("imgFondo","" );
      ((Element)v.get(112)).setAttribute("cod","0053" );
      ((Element)v.get(112)).setAttribute("ID","datosTitle" );
      ((Element)v.get(104)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */

      /* Empieza nodo:113 / Elemento padre: 104   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(113)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(113)).setAttribute("alto","22" );
      ((Element)v.get(113)).setAttribute("imgFondo","" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(104)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */

      /* Empieza nodo:114 / Elemento padre: 104   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(114)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(114)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(114)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(114)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(114)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(104)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(115)).setAttribute("ancho","190" );
      ((Element)v.get(115)).setAttribute("minimizable","S" );
      ((Element)v.get(115)).setAttribute("minimizada","N" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */

      /* Empieza nodo:116 / Elemento padre: 114   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(116)).setAttribute("ancho","100" );
      ((Element)v.get(116)).setAttribute("minimizable","S" );
      ((Element)v.get(116)).setAttribute("minimizada","N" );
      ((Element)v.get(114)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */

      /* Empieza nodo:117 / Elemento padre: 114   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(117)).setAttribute("ancho","80" );
      ((Element)v.get(117)).setAttribute("minimizable","S" );
      ((Element)v.get(117)).setAttribute("minimizada","N" );
      ((Element)v.get(114)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */

      /* Empieza nodo:118 / Elemento padre: 114   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(118)).setAttribute("ancho","100" );
      ((Element)v.get(118)).setAttribute("minimizable","S" );
      ((Element)v.get(118)).setAttribute("minimizada","N" );
      ((Element)v.get(114)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:114   */

      /* Empieza nodo:119 / Elemento padre: 104   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(119)).setAttribute("alto","20" );
      ((Element)v.get(119)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(119)).setAttribute("imgFondo","" );
      ((Element)v.get(119)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(104)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(120)).setAttribute("colFondo","" );
      ((Element)v.get(120)).setAttribute("ID","EstCab" );
      ((Element)v.get(120)).setAttribute("align","center" );
      ((Element)v.get(120)).setAttribute("cod","1126" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */

      /* Empieza nodo:121 / Elemento padre: 119   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(121)).setAttribute("colFondo","" );
      ((Element)v.get(121)).setAttribute("ID","EstCab" );
      ((Element)v.get(121)).setAttribute("align","center" );
      ((Element)v.get(121)).setAttribute("cod","1364" );
      ((Element)v.get(119)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */

      /* Empieza nodo:122 / Elemento padre: 119   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(122)).setAttribute("colFondo","" );
      ((Element)v.get(122)).setAttribute("ID","EstCab" );
      ((Element)v.get(122)).setAttribute("align","center" );
      ((Element)v.get(122)).setAttribute("cod","1073" );
      ((Element)v.get(119)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */

      /* Empieza nodo:123 / Elemento padre: 119   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(123)).setAttribute("colFondo","" );
      ((Element)v.get(123)).setAttribute("ID","EstCab" );
      ((Element)v.get(123)).setAttribute("align","center" );
      ((Element)v.get(123)).setAttribute("cod","1113" );
      ((Element)v.get(119)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:119   */

      /* Empieza nodo:124 / Elemento padre: 104   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(124)).setAttribute("alto","22" );
      ((Element)v.get(124)).setAttribute("accion","" );
      ((Element)v.get(124)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(124)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(124)).setAttribute("maxSel","-1" );
      ((Element)v.get(124)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(124)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(124)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(124)).setAttribute("onLoad","" );
      ((Element)v.get(124)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(104)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(125)).setAttribute("tipo","texto" );
      ((Element)v.get(125)).setAttribute("ID","EstDat" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */

      /* Empieza nodo:126 / Elemento padre: 124   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(126)).setAttribute("tipo","texto" );
      ((Element)v.get(126)).setAttribute("ID","EstDat2" );
      ((Element)v.get(124)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */

      /* Empieza nodo:127 / Elemento padre: 124   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(127)).setAttribute("tipo","texto" );
      ((Element)v.get(127)).setAttribute("ID","EstDat" );
      ((Element)v.get(124)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */

      /* Empieza nodo:128 / Elemento padre: 124   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(128)).setAttribute("tipo","texto" );
      ((Element)v.get(128)).setAttribute("ID","EstDat2" );
      ((Element)v.get(124)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:124   */

      /* Empieza nodo:129 / Elemento padre: 104   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(104)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */

      /* Empieza nodo:130 / Elemento padre: 104   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(130)).setAttribute("nombre","mipgndo1" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(130)).setAttribute("ancho","711" );
      ((Element)v.get(130)).setAttribute("sep","$" );
      ((Element)v.get(130)).setAttribute("x","12" );
      ((Element)v.get(130)).setAttribute("class","botonera" );
      ((Element)v.get(130)).setAttribute("y","386" );
      ((Element)v.get(130)).setAttribute("control","|" );
      ((Element)v.get(130)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(130)).setAttribute("rowset","" );
      ((Element)v.get(130)).setAttribute("cargainicial","N" );
      ((Element)v.get(104)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(131)).setAttribute("nombre","ret1" );
      ((Element)v.get(131)).setAttribute("x","37" );
      ((Element)v.get(131)).setAttribute("y","390" );
      ((Element)v.get(131)).setAttribute("ID","botonContenido" );
      ((Element)v.get(131)).setAttribute("img","retroceder_on" );
      ((Element)v.get(131)).setAttribute("tipo","0" );
      ((Element)v.get(131)).setAttribute("estado","false" );
      ((Element)v.get(131)).setAttribute("alt","" );
      ((Element)v.get(131)).setAttribute("codigo","" );
      ((Element)v.get(131)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */

      /* Empieza nodo:132 / Elemento padre: 130   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(132)).setAttribute("nombre","ava1" );
      ((Element)v.get(132)).setAttribute("x","52" );
      ((Element)v.get(132)).setAttribute("y","390" );
      ((Element)v.get(132)).setAttribute("ID","botonContenido" );
      ((Element)v.get(132)).setAttribute("img","avanzar_on" );
      ((Element)v.get(132)).setAttribute("tipo","0" );
      ((Element)v.get(132)).setAttribute("estado","false" );
      ((Element)v.get(132)).setAttribute("alt","" );
      ((Element)v.get(132)).setAttribute("codigo","" );
      ((Element)v.get(132)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(130)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:130   */
      /* Termina nodo:104   */

      /* Empieza nodo:133 / Elemento padre: 4   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(133)).setAttribute("nombre","primera1" );
      ((Element)v.get(133)).setAttribute("x","20" );
      ((Element)v.get(133)).setAttribute("y","390" );
      ((Element)v.get(133)).setAttribute("ID","botonContenido" );
      ((Element)v.get(133)).setAttribute("img","primera_on" );
      ((Element)v.get(133)).setAttribute("tipo","-2" );
      ((Element)v.get(133)).setAttribute("estado","false" );
      ((Element)v.get(133)).setAttribute("alt","" );
      ((Element)v.get(133)).setAttribute("codigo","" );
      ((Element)v.get(133)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(4)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */

      /* Empieza nodo:134 / Elemento padre: 4   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(134)).setAttribute("nombre","Siguiente1" );
      ((Element)v.get(134)).setAttribute("x","71" );
      ((Element)v.get(134)).setAttribute("y","387" );
      ((Element)v.get(134)).setAttribute("ID","botonContenido" );
      ((Element)v.get(134)).setAttribute("img","" );
      ((Element)v.get(134)).setAttribute("tipo","html" );
      ((Element)v.get(134)).setAttribute("estado","false" );
      ((Element)v.get(134)).setAttribute("alt","" );
      ((Element)v.get(134)).setAttribute("cod","446" );
      ((Element)v.get(134)).setAttribute("accion","navegaPestaniasDetalle('2');" );
      ((Element)v.get(4)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */

      /* Empieza nodo:135 / Elemento padre: 4   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(135)).setAttribute("nombre","Anterior1" );
      ((Element)v.get(135)).setAttribute("x","13" );
      ((Element)v.get(135)).setAttribute("y","387" );
      ((Element)v.get(135)).setAttribute("ID","botonContenido" );
      ((Element)v.get(135)).setAttribute("img","" );
      ((Element)v.get(135)).setAttribute("tipo","html" );
      ((Element)v.get(135)).setAttribute("estado","false" );
      ((Element)v.get(135)).setAttribute("alt","" );
      ((Element)v.get(135)).setAttribute("cod","1649" );
      ((Element)v.get(135)).setAttribute("accion","navegaPestaniasDetalle('0');" );
      ((Element)v.get(4)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */

      /* Empieza nodo:136 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(136)).setAttribute("nombre","capaFormulario2" );
      ((Element)v.get(136)).setAttribute("x","0" );
      ((Element)v.get(136)).setAttribute("y","0" );
      ((Element)v.get(136)).setAttribute("alto","100%" );
      ((Element)v.get(136)).setAttribute("ancho","100%" );
      ((Element)v.get(136)).setAttribute("visibilidad","" );
      ((Element)v.get(4)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("table"));
      ((Element)v.get(137)).setAttribute("width","100%" );
      ((Element)v.get(137)).setAttribute("border","0" );
      ((Element)v.get(137)).setAttribute("cellspacing","0" );
      ((Element)v.get(137)).setAttribute("cellpadding","0" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(137)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).setAttribute("width","12" );
      ((Element)v.get(139)).setAttribute("align","center" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
   }

   private void getXML720(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(140)).setAttribute("src","b.gif" );
      ((Element)v.get(140)).setAttribute("width","12" );
      ((Element)v.get(140)).setAttribute("height","12" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:141 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(141)).setAttribute("width","750" );
      ((Element)v.get(138)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(142)).setAttribute("src","b.gif" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:143 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).setAttribute("width","12" );
      ((Element)v.get(138)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(144)).setAttribute("src","b.gif" );
      ((Element)v.get(144)).setAttribute("width","12" );
      ((Element)v.get(144)).setAttribute("height","1" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:138   */

      /* Empieza nodo:145 / Elemento padre: 137   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(137)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(147)).setAttribute("src","b.gif" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */

      /* Empieza nodo:148 / Elemento padre: 145   */
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(148)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(150)).setAttribute("class","legend" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(151)).setAttribute("nombre","lbl2TitDatosBasicos" );
      ((Element)v.get(151)).setAttribute("alto","13" );
      ((Element)v.get(151)).setAttribute("filas","1" );
      ((Element)v.get(151)).setAttribute("valor","" );
      ((Element)v.get(151)).setAttribute("cod","00142" );
      ((Element)v.get(151)).setAttribute("id","legend" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:152 / Elemento padre: 149   */
      v.add(doc.createElement("table"));
      ((Element)v.get(152)).setAttribute("width","100%" );
      ((Element)v.get(152)).setAttribute("border","0" );
      ((Element)v.get(152)).setAttribute("align","center" );
      ((Element)v.get(152)).setAttribute("cellspacing","0" );
      ((Element)v.get(152)).setAttribute("cellpadding","0" );
      ((Element)v.get(149)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("table"));
      ((Element)v.get(155)).setAttribute("width","708" );
      ((Element)v.get(155)).setAttribute("border","0" );
      ((Element)v.get(155)).setAttribute("align","left" );
      ((Element)v.get(155)).setAttribute("cellspacing","0" );
      ((Element)v.get(155)).setAttribute("cellpadding","0" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(155)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).setAttribute("colspan","4" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(158)).setAttribute("src","b.gif" );
      ((Element)v.get(158)).setAttribute("width","8" );
      ((Element)v.get(158)).setAttribute("height","8" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */
      /* Termina nodo:156   */

      /* Empieza nodo:159 / Elemento padre: 155   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(155)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("td"));
      ((Element)v.get(159)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(161)).setAttribute("src","b.gif" );
      ((Element)v.get(161)).setAttribute("width","8" );
      ((Element)v.get(161)).setAttribute("height","8" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:162 / Elemento padre: 159   */
      v.add(doc.createElement("td"));
      ((Element)v.get(159)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(163)).setAttribute("nombre","lbl2Apellido1" );
      ((Element)v.get(163)).setAttribute("alto","13" );
      ((Element)v.get(163)).setAttribute("filas","1" );
      ((Element)v.get(163)).setAttribute("valor","" );
      ((Element)v.get(163)).setAttribute("id","datosTitle" );
      ((Element)v.get(163)).setAttribute("cod","16" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */

      /* Empieza nodo:164 / Elemento padre: 159   */
      v.add(doc.createElement("td"));
      ((Element)v.get(159)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
   }

   private void getXML810(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(165)).setAttribute("src","b.gif" );
      ((Element)v.get(165)).setAttribute("width","25" );
      ((Element)v.get(165)).setAttribute("height","8" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */

      /* Empieza nodo:166 / Elemento padre: 159   */
      v.add(doc.createElement("td"));
      ((Element)v.get(159)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(167)).setAttribute("nombre","lbl2Apellido2" );
      ((Element)v.get(167)).setAttribute("alto","13" );
      ((Element)v.get(167)).setAttribute("filas","1" );
      ((Element)v.get(167)).setAttribute("valor","" );
      ((Element)v.get(167)).setAttribute("id","datosTitle" );
      ((Element)v.get(167)).setAttribute("cod","17" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */

      /* Empieza nodo:168 / Elemento padre: 159   */
      v.add(doc.createElement("td"));
      ((Element)v.get(159)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(169)).setAttribute("src","b.gif" );
      ((Element)v.get(169)).setAttribute("width","25" );
      ((Element)v.get(169)).setAttribute("height","8" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:168   */

      /* Empieza nodo:170 / Elemento padre: 159   */
      v.add(doc.createElement("td"));
      ((Element)v.get(159)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(171)).setAttribute("nombre","lbl2ApellidoCasada" );
      ((Element)v.get(171)).setAttribute("alto","13" );
      ((Element)v.get(171)).setAttribute("filas","1" );
      ((Element)v.get(171)).setAttribute("valor","" );
      ((Element)v.get(171)).setAttribute("id","datosTitle" );
      ((Element)v.get(171)).setAttribute("cod","18" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:170   */

      /* Empieza nodo:172 / Elemento padre: 159   */
      v.add(doc.createElement("td"));
      ((Element)v.get(159)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(173)).setAttribute("src","b.gif" );
      ((Element)v.get(173)).setAttribute("width","25" );
      ((Element)v.get(173)).setAttribute("height","8" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:172   */

      /* Empieza nodo:174 / Elemento padre: 159   */
      v.add(doc.createElement("td"));
      ((Element)v.get(159)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(175)).setAttribute("nombre","lbl2IndActivo" );
      ((Element)v.get(175)).setAttribute("alto","13" );
      ((Element)v.get(175)).setAttribute("filas","1" );
      ((Element)v.get(175)).setAttribute("valor","" );
      ((Element)v.get(175)).setAttribute("id","datosTitle" );
      ((Element)v.get(175)).setAttribute("cod","905" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */

      /* Empieza nodo:176 / Elemento padre: 159   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).setAttribute("width","100%" );
      ((Element)v.get(159)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(177)).setAttribute("src","b.gif" );
      ((Element)v.get(177)).setAttribute("width","8" );
      ((Element)v.get(177)).setAttribute("height","8" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */
      /* Termina nodo:159   */

      /* Empieza nodo:178 / Elemento padre: 155   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(155)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(180)).setAttribute("src","b.gif" );
      ((Element)v.get(180)).setAttribute("width","8" );
      ((Element)v.get(180)).setAttribute("height","8" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:181 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(182)).setAttribute("nombre","lbl2dtApellido1" );
      ((Element)v.get(182)).setAttribute("alto","13" );
      ((Element)v.get(182)).setAttribute("filas","1" );
      ((Element)v.get(182)).setAttribute("valor","xxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(182)).setAttribute("id","datosCampos" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:183 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(184)).setAttribute("src","b.gif" );
      ((Element)v.get(184)).setAttribute("width","25" );
      ((Element)v.get(184)).setAttribute("height","8" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:185 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(186)).setAttribute("nombre","lbl2dtApellido2" );
      ((Element)v.get(186)).setAttribute("alto","13" );
      ((Element)v.get(186)).setAttribute("filas","1" );
      ((Element)v.get(186)).setAttribute("valor","xxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(186)).setAttribute("id","datosCampos" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:187 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(188)).setAttribute("src","b.gif" );
      ((Element)v.get(188)).setAttribute("width","25" );
      ((Element)v.get(188)).setAttribute("height","8" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:189 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(190)).setAttribute("nombre","lbl2dtApellidoCasada" );
      ((Element)v.get(190)).setAttribute("alto","13" );
      ((Element)v.get(190)).setAttribute("filas","1" );
      ((Element)v.get(190)).setAttribute("valor","xxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(190)).setAttribute("id","datosCampos" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:191 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(192)).setAttribute("src","b.gif" );
      ((Element)v.get(192)).setAttribute("width","25" );
      ((Element)v.get(192)).setAttribute("height","8" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */

      /* Empieza nodo:193 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(194)).setAttribute("check","" );
      ((Element)v.get(194)).setAttribute("id","datosCampos" );
      ((Element)v.get(194)).setAttribute("msjreq","" );
      ((Element)v.get(194)).setAttribute("nombre","ckIndActivo" );
      ((Element)v.get(194)).setAttribute("onclick","" );
      ((Element)v.get(194)).setAttribute("onfocus","" );
      ((Element)v.get(194)).setAttribute("readonly","" );
      ((Element)v.get(194)).setAttribute("req","" );
      ((Element)v.get(194)).setAttribute("tabindex","1" );
      ((Element)v.get(194)).setAttribute("texto","" );
      ((Element)v.get(194)).setAttribute("validacion","" );
      ((Element)v.get(194)).setAttribute("onshtab","" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */

      /* Empieza nodo:195 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(195)).setAttribute("width","100%" );
      ((Element)v.get(178)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(196)).setAttribute("src","b.gif" );
      ((Element)v.get(196)).setAttribute("width","8" );
      ((Element)v.get(196)).setAttribute("height","8" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */
      /* Termina nodo:178   */

      /* Empieza nodo:197 / Elemento padre: 155   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(155)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("td"));
      ((Element)v.get(198)).setAttribute("colspan","4" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(199)).setAttribute("src","b.gif" );
      ((Element)v.get(199)).setAttribute("width","8" );
      ((Element)v.get(199)).setAttribute("height","8" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:198   */
      /* Termina nodo:197   */
      /* Termina nodo:155   */
      /* Termina nodo:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:200 / Elemento padre: 152   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(152)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("td"));
      ((Element)v.get(200)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("table"));
      ((Element)v.get(202)).setAttribute("width","708" );
      ((Element)v.get(202)).setAttribute("border","0" );
      ((Element)v.get(202)).setAttribute("align","left" );
      ((Element)v.get(202)).setAttribute("cellspacing","0" );
      ((Element)v.get(202)).setAttribute("cellpadding","0" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(202)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(205)).setAttribute("src","b.gif" );
      ((Element)v.get(205)).setAttribute("width","8" );
      ((Element)v.get(205)).setAttribute("height","8" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */
      /* Termina nodo:204   */

      /* Empieza nodo:206 / Elemento padre: 203   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(207)).setAttribute("nombre","lbl2Nombre1" );
      ((Element)v.get(207)).setAttribute("alto","13" );
      ((Element)v.get(207)).setAttribute("filas","1" );
      ((Element)v.get(207)).setAttribute("valor","" );
      ((Element)v.get(207)).setAttribute("id","datosTitle" );
      ((Element)v.get(207)).setAttribute("cod","93" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:208 / Elemento padre: 203   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
   }

   private void getXML990(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(209)).setAttribute("src","b.gif" );
      ((Element)v.get(209)).setAttribute("width","25" );
      ((Element)v.get(209)).setAttribute("height","8" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:210 / Elemento padre: 203   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(211)).setAttribute("nombre","lbl2Nombre2" );
      ((Element)v.get(211)).setAttribute("alto","13" );
      ((Element)v.get(211)).setAttribute("filas","1" );
      ((Element)v.get(211)).setAttribute("valor","" );
      ((Element)v.get(211)).setAttribute("id","datosTitle" );
      ((Element)v.get(211)).setAttribute("cod","94" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:212 / Elemento padre: 203   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(213)).setAttribute("src","b.gif" );
      ((Element)v.get(213)).setAttribute("width","25" );
      ((Element)v.get(213)).setAttribute("height","8" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:212   */

      /* Empieza nodo:214 / Elemento padre: 203   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(215)).setAttribute("nombre","lbl2Tratamiento" );
      ((Element)v.get(215)).setAttribute("alto","13" );
      ((Element)v.get(215)).setAttribute("filas","1" );
      ((Element)v.get(215)).setAttribute("valor","" );
      ((Element)v.get(215)).setAttribute("id","datosTitle" );
      ((Element)v.get(215)).setAttribute("cod","757" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:214   */

      /* Empieza nodo:216 / Elemento padre: 203   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(217)).setAttribute("src","b.gif" );
      ((Element)v.get(217)).setAttribute("width","25" );
      ((Element)v.get(217)).setAttribute("height","8" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:216   */

      /* Empieza nodo:218 / Elemento padre: 203   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(219)).setAttribute("nombre","lbl2Sexo" );
      ((Element)v.get(219)).setAttribute("alto","13" );
      ((Element)v.get(219)).setAttribute("filas","1" );
      ((Element)v.get(219)).setAttribute("valor","" );
      ((Element)v.get(219)).setAttribute("id","datosTitle" );
      ((Element)v.get(219)).setAttribute("cod","1122" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */

      /* Empieza nodo:220 / Elemento padre: 203   */
      v.add(doc.createElement("td"));
      ((Element)v.get(220)).setAttribute("width","100%" );
      ((Element)v.get(203)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(221)).setAttribute("src","b.gif" );
      ((Element)v.get(221)).setAttribute("width","8" );
      ((Element)v.get(221)).setAttribute("height","8" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:220   */
      /* Termina nodo:203   */

      /* Empieza nodo:222 / Elemento padre: 202   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(202)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("td"));
      ((Element)v.get(222)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(224)).setAttribute("src","b.gif" );
      ((Element)v.get(224)).setAttribute("width","8" );
      ((Element)v.get(224)).setAttribute("height","8" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:223   */

      /* Empieza nodo:225 / Elemento padre: 222   */
      v.add(doc.createElement("td"));
      ((Element)v.get(222)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(226)).setAttribute("nombre","lbl2dtNombre1" );
      ((Element)v.get(226)).setAttribute("alto","13" );
      ((Element)v.get(226)).setAttribute("filas","1" );
      ((Element)v.get(226)).setAttribute("valor","" );
      ((Element)v.get(226)).setAttribute("id","datosCampos" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */
      /* Termina nodo:225   */

      /* Empieza nodo:227 / Elemento padre: 222   */
      v.add(doc.createElement("td"));
      ((Element)v.get(222)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(228)).setAttribute("src","b.gif" );
      ((Element)v.get(228)).setAttribute("width","25" );
      ((Element)v.get(228)).setAttribute("height","8" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */
      /* Termina nodo:227   */

      /* Empieza nodo:229 / Elemento padre: 222   */
      v.add(doc.createElement("td"));
      ((Element)v.get(222)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(230)).setAttribute("nombre","lbl2dtNombre2" );
      ((Element)v.get(230)).setAttribute("alto","13" );
      ((Element)v.get(230)).setAttribute("filas","1" );
      ((Element)v.get(230)).setAttribute("valor","" );
      ((Element)v.get(230)).setAttribute("id","datosCampos" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */

      /* Empieza nodo:231 / Elemento padre: 222   */
      v.add(doc.createElement("td"));
      ((Element)v.get(222)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(232)).setAttribute("src","b.gif" );
      ((Element)v.get(232)).setAttribute("width","25" );
      ((Element)v.get(232)).setAttribute("height","8" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:231   */

      /* Empieza nodo:233 / Elemento padre: 222   */
      v.add(doc.createElement("td"));
      ((Element)v.get(222)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(234)).setAttribute("nombre","lbl2dtTratamiento" );
      ((Element)v.get(234)).setAttribute("alto","13" );
      ((Element)v.get(234)).setAttribute("filas","1" );
      ((Element)v.get(234)).setAttribute("valor","" );
      ((Element)v.get(234)).setAttribute("id","datosCampos" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */
      /* Termina nodo:233   */

      /* Empieza nodo:235 / Elemento padre: 222   */
      v.add(doc.createElement("td"));
      ((Element)v.get(222)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(236)).setAttribute("src","b.gif" );
      ((Element)v.get(236)).setAttribute("width","25" );
      ((Element)v.get(236)).setAttribute("height","8" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */
      /* Termina nodo:235   */

      /* Empieza nodo:237 / Elemento padre: 222   */
      v.add(doc.createElement("td"));
      ((Element)v.get(222)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(238)).setAttribute("nombre","lbl2dtSexo" );
      ((Element)v.get(238)).setAttribute("alto","13" );
      ((Element)v.get(238)).setAttribute("filas","1" );
      ((Element)v.get(238)).setAttribute("valor","" );
      ((Element)v.get(238)).setAttribute("id","datosCampos" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:237   */

      /* Empieza nodo:239 / Elemento padre: 222   */
      v.add(doc.createElement("td"));
      ((Element)v.get(239)).setAttribute("width","100%" );
      ((Element)v.get(222)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(240)).setAttribute("src","b.gif" );
      ((Element)v.get(240)).setAttribute("width","8" );
      ((Element)v.get(240)).setAttribute("height","8" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:239   */
      /* Termina nodo:222   */

      /* Empieza nodo:241 / Elemento padre: 202   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(202)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("td"));
      ((Element)v.get(242)).setAttribute("colspan","4" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(243)).setAttribute("src","b.gif" );
      ((Element)v.get(243)).setAttribute("width","8" );
      ((Element)v.get(243)).setAttribute("height","8" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:242   */
      /* Termina nodo:241   */
      /* Termina nodo:202   */
      /* Termina nodo:201   */
      /* Termina nodo:200   */

      /* Empieza nodo:244 / Elemento padre: 152   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(152)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(244)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("table"));
      ((Element)v.get(246)).setAttribute("width","708" );
      ((Element)v.get(246)).setAttribute("border","0" );
      ((Element)v.get(246)).setAttribute("align","left" );
      ((Element)v.get(246)).setAttribute("cellspacing","0" );
      ((Element)v.get(246)).setAttribute("cellpadding","0" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(246)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("td"));
      ((Element)v.get(247)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(249)).setAttribute("src","b.gif" );
      ((Element)v.get(249)).setAttribute("width","8" );
      ((Element)v.get(249)).setAttribute("height","8" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:248   */

      /* Empieza nodo:250 / Elemento padre: 247   */
      v.add(doc.createElement("td"));
      ((Element)v.get(247)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(251)).setAttribute("nombre","lbl2FormaPago" );
      ((Element)v.get(251)).setAttribute("alto","13" );
      ((Element)v.get(251)).setAttribute("filas","1" );
      ((Element)v.get(251)).setAttribute("valor","" );
      ((Element)v.get(251)).setAttribute("id","datosTitle" );
      ((Element)v.get(251)).setAttribute("cod","541" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:250   */

      /* Empieza nodo:252 / Elemento padre: 247   */
      v.add(doc.createElement("td"));
      ((Element)v.get(247)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(253)).setAttribute("src","b.gif" );
      ((Element)v.get(253)).setAttribute("width","25" );
      ((Element)v.get(253)).setAttribute("height","8" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */
      /* Termina nodo:252   */

      /* Empieza nodo:254 / Elemento padre: 247   */
      v.add(doc.createElement("td"));
      ((Element)v.get(247)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
   }

   private void getXML1170(Document doc) {
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(255)).setAttribute("nombre","lbl2FechaIngreso" );
      ((Element)v.get(255)).setAttribute("alto","13" );
      ((Element)v.get(255)).setAttribute("filas","1" );
      ((Element)v.get(255)).setAttribute("valor","" );
      ((Element)v.get(255)).setAttribute("id","datosTitle" );
      ((Element)v.get(255)).setAttribute("cod","499" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */
      /* Termina nodo:254   */

      /* Empieza nodo:256 / Elemento padre: 247   */
      v.add(doc.createElement("td"));
      ((Element)v.get(256)).setAttribute("width","100%" );
      ((Element)v.get(247)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(257)).setAttribute("src","b.gif" );
      ((Element)v.get(257)).setAttribute("width","8" );
      ((Element)v.get(257)).setAttribute("height","8" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */
      /* Termina nodo:256   */
      /* Termina nodo:247   */

      /* Empieza nodo:258 / Elemento padre: 246   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(246)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("td"));
      ((Element)v.get(258)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(260)).setAttribute("src","b.gif" );
      ((Element)v.get(260)).setAttribute("width","8" );
      ((Element)v.get(260)).setAttribute("height","8" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:259   */

      /* Empieza nodo:261 / Elemento padre: 258   */
      v.add(doc.createElement("td"));
      ((Element)v.get(258)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(262)).setAttribute("nombre","lbl2dtFormaPago" );
      ((Element)v.get(262)).setAttribute("alto","13" );
      ((Element)v.get(262)).setAttribute("filas","1" );
      ((Element)v.get(262)).setAttribute("valor","" );
      ((Element)v.get(262)).setAttribute("id","datosCampos" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */
      /* Termina nodo:261   */

      /* Empieza nodo:263 / Elemento padre: 258   */
      v.add(doc.createElement("td"));
      ((Element)v.get(258)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(264)).setAttribute("src","b.gif" );
      ((Element)v.get(264)).setAttribute("width","25" );
      ((Element)v.get(264)).setAttribute("height","8" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */
      /* Termina nodo:263   */

      /* Empieza nodo:265 / Elemento padre: 258   */
      v.add(doc.createElement("td"));
      ((Element)v.get(258)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(266)).setAttribute("nombre","lbl2dtFechaIngreso" );
      ((Element)v.get(266)).setAttribute("alto","13" );
      ((Element)v.get(266)).setAttribute("filas","1" );
      ((Element)v.get(266)).setAttribute("valor","" );
      ((Element)v.get(266)).setAttribute("id","datosCampos" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */
      /* Termina nodo:265   */

      /* Empieza nodo:267 / Elemento padre: 258   */
      v.add(doc.createElement("td"));
      ((Element)v.get(267)).setAttribute("width","100%" );
      ((Element)v.get(258)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(268)).setAttribute("src","b.gif" );
      ((Element)v.get(268)).setAttribute("width","8" );
      ((Element)v.get(268)).setAttribute("height","8" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */
      /* Termina nodo:267   */
      /* Termina nodo:258   */

      /* Empieza nodo:269 / Elemento padre: 246   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(246)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("td"));
      ((Element)v.get(270)).setAttribute("colspan","4" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(271)).setAttribute("src","b.gif" );
      ((Element)v.get(271)).setAttribute("width","8" );
      ((Element)v.get(271)).setAttribute("height","8" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */
      /* Termina nodo:270   */
      /* Termina nodo:269   */
      /* Termina nodo:246   */
      /* Termina nodo:245   */
      /* Termina nodo:244   */
      /* Termina nodo:152   */
      /* Termina nodo:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:272 / Elemento padre: 145   */
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(273)).setAttribute("src","b.gif" );
      ((Element)v.get(273)).setAttribute("width","8" );
      ((Element)v.get(273)).setAttribute("height","12" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */
      /* Termina nodo:272   */
      /* Termina nodo:145   */

      /* Empieza nodo:274 / Elemento padre: 137   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(137)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(275)).setAttribute("width","12" );
      ((Element)v.get(275)).setAttribute("align","center" );
      ((Element)v.get(274)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(276)).setAttribute("src","b.gif" );
      ((Element)v.get(276)).setAttribute("width","12" );
      ((Element)v.get(276)).setAttribute("height","15" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:275   */

      /* Empieza nodo:277 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(277)).setAttribute("width","750" );
      ((Element)v.get(274)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(278)).setAttribute("src","b.gif" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */
      /* Termina nodo:277   */

      /* Empieza nodo:279 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(279)).setAttribute("width","12" );
      ((Element)v.get(274)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(280)).setAttribute("src","b.gif" );
      ((Element)v.get(280)).setAttribute("width","12" );
      ((Element)v.get(280)).setAttribute("height","15" );
      ((Element)v.get(279)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */
      /* Termina nodo:279   */
      /* Termina nodo:274   */

      /* Empieza nodo:281 / Elemento padre: 137   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(137)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
      ((Element)v.get(281)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(283)).setAttribute("src","b.gif" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */
      /* Termina nodo:282   */

      /* Empieza nodo:284 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
      ((Element)v.get(281)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(284)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(286)).setAttribute("class","legend" );
      ((Element)v.get(285)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(287)).setAttribute("nombre","lbl2TitDatosAdiccionales" );
      ((Element)v.get(287)).setAttribute("alto","13" );
      ((Element)v.get(287)).setAttribute("filas","1" );
      ((Element)v.get(287)).setAttribute("valor","" );
      ((Element)v.get(287)).setAttribute("cod","0052" );
      ((Element)v.get(287)).setAttribute("id","legend" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */
      /* Termina nodo:286   */

      /* Empieza nodo:288 / Elemento padre: 285   */
      v.add(doc.createElement("table"));
      ((Element)v.get(288)).setAttribute("width","100%" );
      ((Element)v.get(288)).setAttribute("border","0" );
      ((Element)v.get(288)).setAttribute("align","center" );
      ((Element)v.get(288)).setAttribute("cellspacing","0" );
      ((Element)v.get(288)).setAttribute("cellpadding","0" );
      ((Element)v.get(285)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(288)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("td"));
      ((Element)v.get(289)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("table"));
      ((Element)v.get(291)).setAttribute("width","708" );
      ((Element)v.get(291)).setAttribute("border","0" );
      ((Element)v.get(291)).setAttribute("align","left" );
      ((Element)v.get(291)).setAttribute("cellspacing","0" );
      ((Element)v.get(291)).setAttribute("cellpadding","0" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(291)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("td"));
      ((Element)v.get(293)).setAttribute("colspan","4" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(294)).setAttribute("src","b.gif" );
      ((Element)v.get(294)).setAttribute("width","8" );
      ((Element)v.get(294)).setAttribute("height","8" );
      ((Element)v.get(293)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */
      /* Termina nodo:293   */
      /* Termina nodo:292   */

      /* Empieza nodo:295 / Elemento padre: 291   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(291)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("td"));
      ((Element)v.get(295)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(297)).setAttribute("src","b.gif" );
      ((Element)v.get(297)).setAttribute("width","8" );
      ((Element)v.get(297)).setAttribute("height","8" );
      ((Element)v.get(296)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */
      /* Termina nodo:296   */

      /* Empieza nodo:298 / Elemento padre: 295   */
      v.add(doc.createElement("td"));
      ((Element)v.get(295)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(299)).setAttribute("nombre","lbl2FechaNacimiento" );
      ((Element)v.get(299)).setAttribute("alto","13" );
      ((Element)v.get(299)).setAttribute("filas","1" );
      ((Element)v.get(299)).setAttribute("valor","" );
      ((Element)v.get(299)).setAttribute("id","datosTitle" );
      ((Element)v.get(299)).setAttribute("cod","877" );
      ((Element)v.get(298)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */
      /* Termina nodo:298   */

      /* Empieza nodo:300 / Elemento padre: 295   */
      v.add(doc.createElement("td"));
      ((Element)v.get(295)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(301)).setAttribute("src","b.gif" );
      ((Element)v.get(301)).setAttribute("width","25" );
      ((Element)v.get(301)).setAttribute("height","8" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */
      /* Termina nodo:300   */

      /* Empieza nodo:302 / Elemento padre: 295   */
      v.add(doc.createElement("td"));
      ((Element)v.get(295)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(303)).setAttribute("nombre","lbl2CodEmpleado" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(303)).setAttribute("alto","13" );
      ((Element)v.get(303)).setAttribute("filas","1" );
      ((Element)v.get(303)).setAttribute("valor","" );
      ((Element)v.get(303)).setAttribute("id","datosTitle" );
      ((Element)v.get(303)).setAttribute("cod","1336" );
      ((Element)v.get(302)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */
      /* Termina nodo:302   */

      /* Empieza nodo:304 / Elemento padre: 295   */
      v.add(doc.createElement("td"));
      ((Element)v.get(295)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(305)).setAttribute("src","b.gif" );
      ((Element)v.get(305)).setAttribute("width","25" );
      ((Element)v.get(305)).setAttribute("height","8" );
      ((Element)v.get(304)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */
      /* Termina nodo:304   */

      /* Empieza nodo:306 / Elemento padre: 295   */
      v.add(doc.createElement("td"));
      ((Element)v.get(295)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(307)).setAttribute("nombre","lbl2Nacionalidad" );
      ((Element)v.get(307)).setAttribute("alto","13" );
      ((Element)v.get(307)).setAttribute("filas","1" );
      ((Element)v.get(307)).setAttribute("valor","" );
      ((Element)v.get(307)).setAttribute("id","datosTitle" );
      ((Element)v.get(307)).setAttribute("cod","1095" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */
      /* Termina nodo:306   */

      /* Empieza nodo:308 / Elemento padre: 295   */
      v.add(doc.createElement("td"));
      ((Element)v.get(295)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(309)).setAttribute("src","b.gif" );
      ((Element)v.get(309)).setAttribute("width","25" );
      ((Element)v.get(309)).setAttribute("height","8" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */
      /* Termina nodo:308   */

      /* Empieza nodo:310 / Elemento padre: 295   */
      v.add(doc.createElement("td"));
      ((Element)v.get(295)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(311)).setAttribute("nombre","lbl2Edad" );
      ((Element)v.get(311)).setAttribute("alto","13" );
      ((Element)v.get(311)).setAttribute("filas","1" );
      ((Element)v.get(311)).setAttribute("valor","" );
      ((Element)v.get(311)).setAttribute("id","datosTitle" );
      ((Element)v.get(311)).setAttribute("cod","1074" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */
      /* Termina nodo:310   */

      /* Empieza nodo:312 / Elemento padre: 295   */
      v.add(doc.createElement("td"));
      ((Element)v.get(295)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(313)).setAttribute("src","b.gif" );
      ((Element)v.get(313)).setAttribute("width","25" );
      ((Element)v.get(313)).setAttribute("height","8" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */
      /* Termina nodo:312   */

      /* Empieza nodo:314 / Elemento padre: 295   */
      v.add(doc.createElement("td"));
      ((Element)v.get(295)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(315)).setAttribute("nombre","lbl2EstadoCivil" );
      ((Element)v.get(315)).setAttribute("alto","13" );
      ((Element)v.get(315)).setAttribute("filas","1" );
      ((Element)v.get(315)).setAttribute("valor","" );
      ((Element)v.get(315)).setAttribute("id","datosTitle" );
      ((Element)v.get(315)).setAttribute("cod","1076" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */
      /* Termina nodo:314   */

      /* Empieza nodo:316 / Elemento padre: 295   */
      v.add(doc.createElement("td"));
      ((Element)v.get(316)).setAttribute("width","100%" );
      ((Element)v.get(295)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(317)).setAttribute("src","b.gif" );
      ((Element)v.get(317)).setAttribute("width","8" );
      ((Element)v.get(317)).setAttribute("height","8" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */
      /* Termina nodo:316   */
      /* Termina nodo:295   */

      /* Empieza nodo:318 / Elemento padre: 291   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(291)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("td"));
      ((Element)v.get(318)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(320)).setAttribute("src","b.gif" );
      ((Element)v.get(320)).setAttribute("width","8" );
      ((Element)v.get(320)).setAttribute("height","8" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */
      /* Termina nodo:319   */

      /* Empieza nodo:321 / Elemento padre: 318   */
      v.add(doc.createElement("td"));
      ((Element)v.get(318)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(322)).setAttribute("nombre","lbl2dtFechaNacimiento" );
      ((Element)v.get(322)).setAttribute("alto","13" );
      ((Element)v.get(322)).setAttribute("filas","1" );
      ((Element)v.get(322)).setAttribute("valor","" );
      ((Element)v.get(322)).setAttribute("id","datosCampos" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));
      /* Termina nodo:322   */
      /* Termina nodo:321   */

      /* Empieza nodo:323 / Elemento padre: 318   */
      v.add(doc.createElement("td"));
      ((Element)v.get(318)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(324)).setAttribute("src","b.gif" );
      ((Element)v.get(324)).setAttribute("width","25" );
      ((Element)v.get(324)).setAttribute("height","8" );
      ((Element)v.get(323)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */
      /* Termina nodo:323   */

      /* Empieza nodo:325 / Elemento padre: 318   */
   }

   private void getXML1440(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(318)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(326)).setAttribute("nombre","lbl2dtCodEmpleado" );
      ((Element)v.get(326)).setAttribute("alto","13" );
      ((Element)v.get(326)).setAttribute("filas","1" );
      ((Element)v.get(326)).setAttribute("valor","" );
      ((Element)v.get(326)).setAttribute("id","datosCampos" );
      ((Element)v.get(325)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */
      /* Termina nodo:325   */

      /* Empieza nodo:327 / Elemento padre: 318   */
      v.add(doc.createElement("td"));
      ((Element)v.get(318)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(328)).setAttribute("src","b.gif" );
      ((Element)v.get(328)).setAttribute("width","25" );
      ((Element)v.get(328)).setAttribute("height","8" );
      ((Element)v.get(327)).appendChild((Element)v.get(328));
      /* Termina nodo:328   */
      /* Termina nodo:327   */

      /* Empieza nodo:329 / Elemento padre: 318   */
      v.add(doc.createElement("td"));
      ((Element)v.get(318)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(330)).setAttribute("nombre","lbl2dtNacionalidad" );
      ((Element)v.get(330)).setAttribute("alto","13" );
      ((Element)v.get(330)).setAttribute("filas","1" );
      ((Element)v.get(330)).setAttribute("valor","" );
      ((Element)v.get(330)).setAttribute("id","datosCampos" );
      ((Element)v.get(329)).appendChild((Element)v.get(330));
      /* Termina nodo:330   */
      /* Termina nodo:329   */

      /* Empieza nodo:331 / Elemento padre: 318   */
      v.add(doc.createElement("td"));
      ((Element)v.get(318)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(332)).setAttribute("src","b.gif" );
      ((Element)v.get(332)).setAttribute("width","25" );
      ((Element)v.get(332)).setAttribute("height","8" );
      ((Element)v.get(331)).appendChild((Element)v.get(332));
      /* Termina nodo:332   */
      /* Termina nodo:331   */

      /* Empieza nodo:333 / Elemento padre: 318   */
      v.add(doc.createElement("td"));
      ((Element)v.get(318)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(334)).setAttribute("nombre","lbl2dtEdad" );
      ((Element)v.get(334)).setAttribute("alto","13" );
      ((Element)v.get(334)).setAttribute("filas","1" );
      ((Element)v.get(334)).setAttribute("valor","" );
      ((Element)v.get(334)).setAttribute("id","datosCampos" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */
      /* Termina nodo:333   */

      /* Empieza nodo:335 / Elemento padre: 318   */
      v.add(doc.createElement("td"));
      ((Element)v.get(318)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(336)).setAttribute("src","b.gif" );
      ((Element)v.get(336)).setAttribute("width","25" );
      ((Element)v.get(336)).setAttribute("height","8" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */
      /* Termina nodo:335   */

      /* Empieza nodo:337 / Elemento padre: 318   */
      v.add(doc.createElement("td"));
      ((Element)v.get(318)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(338)).setAttribute("nombre","lbl2dtEstadoCivil" );
      ((Element)v.get(338)).setAttribute("alto","13" );
      ((Element)v.get(338)).setAttribute("filas","1" );
      ((Element)v.get(338)).setAttribute("valor","" );
      ((Element)v.get(338)).setAttribute("id","datosCampos" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */
      /* Termina nodo:337   */

      /* Empieza nodo:339 / Elemento padre: 318   */
      v.add(doc.createElement("td"));
      ((Element)v.get(339)).setAttribute("width","100%" );
      ((Element)v.get(318)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(340)).setAttribute("src","b.gif" );
      ((Element)v.get(340)).setAttribute("width","8" );
      ((Element)v.get(340)).setAttribute("height","8" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */
      /* Termina nodo:339   */
      /* Termina nodo:318   */

      /* Empieza nodo:341 / Elemento padre: 291   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(291)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("td"));
      ((Element)v.get(342)).setAttribute("colspan","4" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(343)).setAttribute("src","b.gif" );
      ((Element)v.get(343)).setAttribute("width","8" );
      ((Element)v.get(343)).setAttribute("height","8" );
      ((Element)v.get(342)).appendChild((Element)v.get(343));
      /* Termina nodo:343   */
      /* Termina nodo:342   */
      /* Termina nodo:341   */
      /* Termina nodo:291   */
      /* Termina nodo:290   */
      /* Termina nodo:289   */

      /* Empieza nodo:344 / Elemento padre: 288   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(288)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("td"));
      ((Element)v.get(344)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("table"));
      ((Element)v.get(346)).setAttribute("width","708" );
      ((Element)v.get(346)).setAttribute("border","0" );
      ((Element)v.get(346)).setAttribute("align","left" );
      ((Element)v.get(346)).setAttribute("cellspacing","0" );
      ((Element)v.get(346)).setAttribute("cellpadding","0" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(346)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("td"));
      ((Element)v.get(347)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
   }

   private void getXML1530(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(349)).setAttribute("src","b.gif" );
      ((Element)v.get(349)).setAttribute("width","8" );
      ((Element)v.get(349)).setAttribute("height","8" );
      ((Element)v.get(348)).appendChild((Element)v.get(349));
      /* Termina nodo:349   */
      /* Termina nodo:348   */

      /* Empieza nodo:350 / Elemento padre: 347   */
      v.add(doc.createElement("td"));
      ((Element)v.get(347)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(351)).setAttribute("nombre","lbl2Ocupacion" );
      ((Element)v.get(351)).setAttribute("alto","13" );
      ((Element)v.get(351)).setAttribute("filas","1" );
      ((Element)v.get(351)).setAttribute("valor","" );
      ((Element)v.get(351)).setAttribute("id","datosTitle" );
      ((Element)v.get(351)).setAttribute("cod","1109" );
      ((Element)v.get(350)).appendChild((Element)v.get(351));
      /* Termina nodo:351   */
      /* Termina nodo:350   */

      /* Empieza nodo:352 / Elemento padre: 347   */
      v.add(doc.createElement("td"));
      ((Element)v.get(347)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(353)).setAttribute("src","b.gif" );
      ((Element)v.get(353)).setAttribute("width","25" );
      ((Element)v.get(353)).setAttribute("height","8" );
      ((Element)v.get(352)).appendChild((Element)v.get(353));
      /* Termina nodo:353   */
      /* Termina nodo:352   */

      /* Empieza nodo:354 / Elemento padre: 347   */
      v.add(doc.createElement("td"));
      ((Element)v.get(347)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(355)).setAttribute("nombre","lbl2Profesion" );
      ((Element)v.get(355)).setAttribute("alto","13" );
      ((Element)v.get(355)).setAttribute("filas","1" );
      ((Element)v.get(355)).setAttribute("valor","" );
      ((Element)v.get(355)).setAttribute("id","datosTitle" );
      ((Element)v.get(355)).setAttribute("cod","1117" );
      ((Element)v.get(354)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */
      /* Termina nodo:354   */

      /* Empieza nodo:356 / Elemento padre: 347   */
      v.add(doc.createElement("td"));
      ((Element)v.get(356)).setAttribute("width","100%" );
      ((Element)v.get(347)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(357)).setAttribute("src","b.gif" );
      ((Element)v.get(357)).setAttribute("width","8" );
      ((Element)v.get(357)).setAttribute("height","8" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */
      /* Termina nodo:356   */
      /* Termina nodo:347   */

      /* Empieza nodo:358 / Elemento padre: 346   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(346)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("td"));
      ((Element)v.get(358)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(360)).setAttribute("src","b.gif" );
      ((Element)v.get(360)).setAttribute("width","8" );
      ((Element)v.get(360)).setAttribute("height","8" );
      ((Element)v.get(359)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */
      /* Termina nodo:359   */

      /* Empieza nodo:361 / Elemento padre: 358   */
      v.add(doc.createElement("td"));
      ((Element)v.get(358)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(362)).setAttribute("nombre","lbl2dtOcupacion" );
      ((Element)v.get(362)).setAttribute("alto","13" );
      ((Element)v.get(362)).setAttribute("filas","1" );
      ((Element)v.get(362)).setAttribute("valor","" );
      ((Element)v.get(362)).setAttribute("id","datosCampos" );
      ((Element)v.get(361)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */
      /* Termina nodo:361   */

      /* Empieza nodo:363 / Elemento padre: 358   */
      v.add(doc.createElement("td"));
      ((Element)v.get(358)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(364)).setAttribute("src","b.gif" );
      ((Element)v.get(364)).setAttribute("width","25" );
      ((Element)v.get(364)).setAttribute("height","8" );
      ((Element)v.get(363)).appendChild((Element)v.get(364));
      /* Termina nodo:364   */
      /* Termina nodo:363   */

      /* Empieza nodo:365 / Elemento padre: 358   */
      v.add(doc.createElement("td"));
      ((Element)v.get(358)).appendChild((Element)v.get(365));

      /* Empieza nodo:366 / Elemento padre: 365   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(366)).setAttribute("nombre","lbl2dtProfesion" );
      ((Element)v.get(366)).setAttribute("alto","13" );
      ((Element)v.get(366)).setAttribute("filas","1" );
      ((Element)v.get(366)).setAttribute("valor","" );
      ((Element)v.get(366)).setAttribute("id","datosCampos" );
      ((Element)v.get(365)).appendChild((Element)v.get(366));
      /* Termina nodo:366   */
      /* Termina nodo:365   */

      /* Empieza nodo:367 / Elemento padre: 358   */
      v.add(doc.createElement("td"));
      ((Element)v.get(367)).setAttribute("width","100%" );
      ((Element)v.get(358)).appendChild((Element)v.get(367));

      /* Empieza nodo:368 / Elemento padre: 367   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(368)).setAttribute("src","b.gif" );
      ((Element)v.get(368)).setAttribute("width","8" );
      ((Element)v.get(368)).setAttribute("height","8" );
      ((Element)v.get(367)).appendChild((Element)v.get(368));
      /* Termina nodo:368   */
      /* Termina nodo:367   */
      /* Termina nodo:358   */

      /* Empieza nodo:369 / Elemento padre: 346   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(346)).appendChild((Element)v.get(369));

      /* Empieza nodo:370 / Elemento padre: 369   */
      v.add(doc.createElement("td"));
      ((Element)v.get(370)).setAttribute("colspan","4" );
      ((Element)v.get(369)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(371)).setAttribute("src","b.gif" );
      ((Element)v.get(371)).setAttribute("width","8" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(371)).setAttribute("height","8" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */
      /* Termina nodo:370   */
      /* Termina nodo:369   */
      /* Termina nodo:346   */
      /* Termina nodo:345   */
      /* Termina nodo:344   */

      /* Empieza nodo:372 / Elemento padre: 288   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(288)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("td"));
      ((Element)v.get(372)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("table"));
      ((Element)v.get(374)).setAttribute("width","708" );
      ((Element)v.get(374)).setAttribute("border","0" );
      ((Element)v.get(374)).setAttribute("align","left" );
      ((Element)v.get(374)).setAttribute("cellspacing","0" );
      ((Element)v.get(374)).setAttribute("cellpadding","0" );
      ((Element)v.get(373)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(374)).appendChild((Element)v.get(375));

      /* Empieza nodo:376 / Elemento padre: 375   */
      v.add(doc.createElement("td"));
      ((Element)v.get(375)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(377)).setAttribute("src","b.gif" );
      ((Element)v.get(377)).setAttribute("width","8" );
      ((Element)v.get(377)).setAttribute("height","8" );
      ((Element)v.get(376)).appendChild((Element)v.get(377));
      /* Termina nodo:377   */
      /* Termina nodo:376   */

      /* Empieza nodo:378 / Elemento padre: 375   */
      v.add(doc.createElement("td"));
      ((Element)v.get(375)).appendChild((Element)v.get(378));

      /* Empieza nodo:379 / Elemento padre: 378   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(379)).setAttribute("nombre","lbl2CentroTrabajo" );
      ((Element)v.get(379)).setAttribute("alto","13" );
      ((Element)v.get(379)).setAttribute("filas","1" );
      ((Element)v.get(379)).setAttribute("valor","" );
      ((Element)v.get(379)).setAttribute("id","datosTitle" );
      ((Element)v.get(379)).setAttribute("cod","1055" );
      ((Element)v.get(378)).appendChild((Element)v.get(379));
      /* Termina nodo:379   */
      /* Termina nodo:378   */

      /* Empieza nodo:380 / Elemento padre: 375   */
      v.add(doc.createElement("td"));
      ((Element)v.get(375)).appendChild((Element)v.get(380));

      /* Empieza nodo:381 / Elemento padre: 380   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(381)).setAttribute("src","b.gif" );
      ((Element)v.get(381)).setAttribute("width","25" );
      ((Element)v.get(381)).setAttribute("height","8" );
      ((Element)v.get(380)).appendChild((Element)v.get(381));
      /* Termina nodo:381   */
      /* Termina nodo:380   */

      /* Empieza nodo:382 / Elemento padre: 375   */
      v.add(doc.createElement("td"));
      ((Element)v.get(375)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(383)).setAttribute("nombre","lbl2CargoDesempena" );
      ((Element)v.get(383)).setAttribute("alto","13" );
      ((Element)v.get(383)).setAttribute("filas","1" );
      ((Element)v.get(383)).setAttribute("valor","" );
      ((Element)v.get(383)).setAttribute("id","datosTitle" );
      ((Element)v.get(383)).setAttribute("cod","1053" );
      ((Element)v.get(382)).appendChild((Element)v.get(383));
      /* Termina nodo:383   */
      /* Termina nodo:382   */

      /* Empieza nodo:384 / Elemento padre: 375   */
      v.add(doc.createElement("td"));
      ((Element)v.get(384)).setAttribute("width","100%" );
      ((Element)v.get(375)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(385)).setAttribute("src","b.gif" );
      ((Element)v.get(385)).setAttribute("width","8" );
      ((Element)v.get(385)).setAttribute("height","8" );
      ((Element)v.get(384)).appendChild((Element)v.get(385));
      /* Termina nodo:385   */
      /* Termina nodo:384   */
      /* Termina nodo:375   */

      /* Empieza nodo:386 / Elemento padre: 374   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(374)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("td"));
      ((Element)v.get(386)).appendChild((Element)v.get(387));

      /* Empieza nodo:388 / Elemento padre: 387   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(388)).setAttribute("src","b.gif" );
      ((Element)v.get(388)).setAttribute("width","8" );
      ((Element)v.get(388)).setAttribute("height","8" );
      ((Element)v.get(387)).appendChild((Element)v.get(388));
      /* Termina nodo:388   */
      /* Termina nodo:387   */

      /* Empieza nodo:389 / Elemento padre: 386   */
      v.add(doc.createElement("td"));
      ((Element)v.get(386)).appendChild((Element)v.get(389));

      /* Empieza nodo:390 / Elemento padre: 389   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(390)).setAttribute("nombre","lbl2dtCentroTrabajo" );
      ((Element)v.get(390)).setAttribute("alto","13" );
      ((Element)v.get(390)).setAttribute("filas","1" );
      ((Element)v.get(390)).setAttribute("valor","" );
      ((Element)v.get(390)).setAttribute("id","datosCampos" );
      ((Element)v.get(389)).appendChild((Element)v.get(390));
      /* Termina nodo:390   */
      /* Termina nodo:389   */

      /* Empieza nodo:391 / Elemento padre: 386   */
      v.add(doc.createElement("td"));
      ((Element)v.get(386)).appendChild((Element)v.get(391));

      /* Empieza nodo:392 / Elemento padre: 391   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(392)).setAttribute("src","b.gif" );
      ((Element)v.get(392)).setAttribute("width","25" );
      ((Element)v.get(392)).setAttribute("height","8" );
      ((Element)v.get(391)).appendChild((Element)v.get(392));
      /* Termina nodo:392   */
      /* Termina nodo:391   */

      /* Empieza nodo:393 / Elemento padre: 386   */
      v.add(doc.createElement("td"));
      ((Element)v.get(386)).appendChild((Element)v.get(393));

      /* Empieza nodo:394 / Elemento padre: 393   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(394)).setAttribute("nombre","lbl2dtCargoDesempena" );
      ((Element)v.get(394)).setAttribute("alto","13" );
      ((Element)v.get(394)).setAttribute("filas","1" );
      ((Element)v.get(394)).setAttribute("valor","" );
      ((Element)v.get(394)).setAttribute("id","datosCampos" );
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(393)).appendChild((Element)v.get(394));
      /* Termina nodo:394   */
      /* Termina nodo:393   */

      /* Empieza nodo:395 / Elemento padre: 386   */
      v.add(doc.createElement("td"));
      ((Element)v.get(395)).setAttribute("width","100%" );
      ((Element)v.get(386)).appendChild((Element)v.get(395));

      /* Empieza nodo:396 / Elemento padre: 395   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(396)).setAttribute("src","b.gif" );
      ((Element)v.get(396)).setAttribute("width","8" );
      ((Element)v.get(396)).setAttribute("height","8" );
      ((Element)v.get(395)).appendChild((Element)v.get(396));
      /* Termina nodo:396   */
      /* Termina nodo:395   */
      /* Termina nodo:386   */

      /* Empieza nodo:397 / Elemento padre: 374   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(374)).appendChild((Element)v.get(397));

      /* Empieza nodo:398 / Elemento padre: 397   */
      v.add(doc.createElement("td"));
      ((Element)v.get(398)).setAttribute("colspan","4" );
      ((Element)v.get(397)).appendChild((Element)v.get(398));

      /* Empieza nodo:399 / Elemento padre: 398   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(399)).setAttribute("src","b.gif" );
      ((Element)v.get(399)).setAttribute("width","8" );
      ((Element)v.get(399)).setAttribute("height","8" );
      ((Element)v.get(398)).appendChild((Element)v.get(399));
      /* Termina nodo:399   */
      /* Termina nodo:398   */
      /* Termina nodo:397   */
      /* Termina nodo:374   */
      /* Termina nodo:373   */
      /* Termina nodo:372   */

      /* Empieza nodo:400 / Elemento padre: 288   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(288)).appendChild((Element)v.get(400));

      /* Empieza nodo:401 / Elemento padre: 400   */
      v.add(doc.createElement("td"));
      ((Element)v.get(400)).appendChild((Element)v.get(401));

      /* Empieza nodo:402 / Elemento padre: 401   */
      v.add(doc.createElement("table"));
      ((Element)v.get(402)).setAttribute("width","708" );
      ((Element)v.get(402)).setAttribute("border","0" );
      ((Element)v.get(402)).setAttribute("align","left" );
      ((Element)v.get(402)).setAttribute("cellspacing","0" );
      ((Element)v.get(402)).setAttribute("cellpadding","0" );
      ((Element)v.get(401)).appendChild((Element)v.get(402));

      /* Empieza nodo:403 / Elemento padre: 402   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(402)).appendChild((Element)v.get(403));

      /* Empieza nodo:404 / Elemento padre: 403   */
      v.add(doc.createElement("td"));
      ((Element)v.get(403)).appendChild((Element)v.get(404));

      /* Empieza nodo:405 / Elemento padre: 404   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(405)).setAttribute("src","b.gif" );
      ((Element)v.get(405)).setAttribute("width","8" );
      ((Element)v.get(405)).setAttribute("height","8" );
      ((Element)v.get(404)).appendChild((Element)v.get(405));
      /* Termina nodo:405   */
      /* Termina nodo:404   */

      /* Empieza nodo:406 / Elemento padre: 403   */
      v.add(doc.createElement("td"));
      ((Element)v.get(403)).appendChild((Element)v.get(406));

      /* Empieza nodo:407 / Elemento padre: 406   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(407)).setAttribute("nombre","lbl2NivelEstudios" );
      ((Element)v.get(407)).setAttribute("alto","13" );
      ((Element)v.get(407)).setAttribute("filas","1" );
      ((Element)v.get(407)).setAttribute("valor","" );
      ((Element)v.get(407)).setAttribute("id","datosTitle" );
      ((Element)v.get(407)).setAttribute("cod","1106" );
      ((Element)v.get(406)).appendChild((Element)v.get(407));
      /* Termina nodo:407   */
      /* Termina nodo:406   */

      /* Empieza nodo:408 / Elemento padre: 403   */
      v.add(doc.createElement("td"));
      ((Element)v.get(403)).appendChild((Element)v.get(408));

      /* Empieza nodo:409 / Elemento padre: 408   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(409)).setAttribute("src","b.gif" );
      ((Element)v.get(409)).setAttribute("width","25" );
      ((Element)v.get(409)).setAttribute("height","8" );
      ((Element)v.get(408)).appendChild((Element)v.get(409));
      /* Termina nodo:409   */
      /* Termina nodo:408   */

      /* Empieza nodo:410 / Elemento padre: 403   */
      v.add(doc.createElement("td"));
      ((Element)v.get(403)).appendChild((Element)v.get(410));

      /* Empieza nodo:411 / Elemento padre: 410   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(411)).setAttribute("nombre","lbl2CentroEstudios" );
      ((Element)v.get(411)).setAttribute("alto","13" );
      ((Element)v.get(411)).setAttribute("filas","1" );
      ((Element)v.get(411)).setAttribute("valor","" );
      ((Element)v.get(411)).setAttribute("id","datosTitle" );
      ((Element)v.get(411)).setAttribute("cod","1054" );
      ((Element)v.get(410)).appendChild((Element)v.get(411));
      /* Termina nodo:411   */
      /* Termina nodo:410   */

      /* Empieza nodo:412 / Elemento padre: 403   */
      v.add(doc.createElement("td"));
      ((Element)v.get(403)).appendChild((Element)v.get(412));

      /* Empieza nodo:413 / Elemento padre: 412   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(413)).setAttribute("src","b.gif" );
      ((Element)v.get(413)).setAttribute("width","25" );
      ((Element)v.get(413)).setAttribute("height","8" );
      ((Element)v.get(412)).appendChild((Element)v.get(413));
      /* Termina nodo:413   */
      /* Termina nodo:412   */

      /* Empieza nodo:414 / Elemento padre: 403   */
      v.add(doc.createElement("td"));
      ((Element)v.get(403)).appendChild((Element)v.get(414));

      /* Empieza nodo:415 / Elemento padre: 414   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(415)).setAttribute("nombre","lbl2NHijos" );
      ((Element)v.get(415)).setAttribute("alto","13" );
      ((Element)v.get(415)).setAttribute("filas","1" );
      ((Element)v.get(415)).setAttribute("valor","" );
      ((Element)v.get(415)).setAttribute("id","datosTitle" );
      ((Element)v.get(415)).setAttribute("cod","1108" );
      ((Element)v.get(414)).appendChild((Element)v.get(415));
      /* Termina nodo:415   */
      /* Termina nodo:414   */

      /* Empieza nodo:416 / Elemento padre: 403   */
      v.add(doc.createElement("td"));
      ((Element)v.get(403)).appendChild((Element)v.get(416));

      /* Empieza nodo:417 / Elemento padre: 416   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(417)).setAttribute("src","b.gif" );
      ((Element)v.get(417)).setAttribute("width","25" );
      ((Element)v.get(417)).setAttribute("height","8" );
      ((Element)v.get(416)).appendChild((Element)v.get(417));
      /* Termina nodo:417   */
      /* Termina nodo:416   */

      /* Empieza nodo:418 / Elemento padre: 403   */
   }

   private void getXML1800(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(403)).appendChild((Element)v.get(418));

      /* Empieza nodo:419 / Elemento padre: 418   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(419)).setAttribute("nombre","lbl2NPersonasDependientes" );
      ((Element)v.get(419)).setAttribute("alto","13" );
      ((Element)v.get(419)).setAttribute("filas","1" );
      ((Element)v.get(419)).setAttribute("valor","" );
      ((Element)v.get(419)).setAttribute("id","datosTitle" );
      ((Element)v.get(419)).setAttribute("cod","1337" );
      ((Element)v.get(418)).appendChild((Element)v.get(419));
      /* Termina nodo:419   */
      /* Termina nodo:418   */

      /* Empieza nodo:420 / Elemento padre: 403   */
      v.add(doc.createElement("td"));
      ((Element)v.get(420)).setAttribute("width","100%" );
      ((Element)v.get(403)).appendChild((Element)v.get(420));

      /* Empieza nodo:421 / Elemento padre: 420   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(421)).setAttribute("src","b.gif" );
      ((Element)v.get(421)).setAttribute("width","8" );
      ((Element)v.get(421)).setAttribute("height","8" );
      ((Element)v.get(420)).appendChild((Element)v.get(421));
      /* Termina nodo:421   */
      /* Termina nodo:420   */
      /* Termina nodo:403   */

      /* Empieza nodo:422 / Elemento padre: 402   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(402)).appendChild((Element)v.get(422));

      /* Empieza nodo:423 / Elemento padre: 422   */
      v.add(doc.createElement("td"));
      ((Element)v.get(422)).appendChild((Element)v.get(423));

      /* Empieza nodo:424 / Elemento padre: 423   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(424)).setAttribute("src","b.gif" );
      ((Element)v.get(424)).setAttribute("width","8" );
      ((Element)v.get(424)).setAttribute("height","8" );
      ((Element)v.get(423)).appendChild((Element)v.get(424));
      /* Termina nodo:424   */
      /* Termina nodo:423   */

      /* Empieza nodo:425 / Elemento padre: 422   */
      v.add(doc.createElement("td"));
      ((Element)v.get(422)).appendChild((Element)v.get(425));

      /* Empieza nodo:426 / Elemento padre: 425   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(426)).setAttribute("nombre","lbl2dtNivelEstudios" );
      ((Element)v.get(426)).setAttribute("alto","13" );
      ((Element)v.get(426)).setAttribute("filas","1" );
      ((Element)v.get(426)).setAttribute("valor","" );
      ((Element)v.get(426)).setAttribute("id","datosCampos" );
      ((Element)v.get(425)).appendChild((Element)v.get(426));
      /* Termina nodo:426   */
      /* Termina nodo:425   */

      /* Empieza nodo:427 / Elemento padre: 422   */
      v.add(doc.createElement("td"));
      ((Element)v.get(422)).appendChild((Element)v.get(427));

      /* Empieza nodo:428 / Elemento padre: 427   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(428)).setAttribute("src","b.gif" );
      ((Element)v.get(428)).setAttribute("width","25" );
      ((Element)v.get(428)).setAttribute("height","8" );
      ((Element)v.get(427)).appendChild((Element)v.get(428));
      /* Termina nodo:428   */
      /* Termina nodo:427   */

      /* Empieza nodo:429 / Elemento padre: 422   */
      v.add(doc.createElement("td"));
      ((Element)v.get(422)).appendChild((Element)v.get(429));

      /* Empieza nodo:430 / Elemento padre: 429   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(430)).setAttribute("nombre","lbl2dtCentroEstudios" );
      ((Element)v.get(430)).setAttribute("alto","13" );
      ((Element)v.get(430)).setAttribute("filas","1" );
      ((Element)v.get(430)).setAttribute("valor","" );
      ((Element)v.get(430)).setAttribute("id","datosCampos" );
      ((Element)v.get(429)).appendChild((Element)v.get(430));
      /* Termina nodo:430   */
      /* Termina nodo:429   */

      /* Empieza nodo:431 / Elemento padre: 422   */
      v.add(doc.createElement("td"));
      ((Element)v.get(422)).appendChild((Element)v.get(431));

      /* Empieza nodo:432 / Elemento padre: 431   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(432)).setAttribute("src","b.gif" );
      ((Element)v.get(432)).setAttribute("width","25" );
      ((Element)v.get(432)).setAttribute("height","8" );
      ((Element)v.get(431)).appendChild((Element)v.get(432));
      /* Termina nodo:432   */
      /* Termina nodo:431   */

      /* Empieza nodo:433 / Elemento padre: 422   */
      v.add(doc.createElement("td"));
      ((Element)v.get(422)).appendChild((Element)v.get(433));

      /* Empieza nodo:434 / Elemento padre: 433   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(434)).setAttribute("nombre","lbl2dtNHijos" );
      ((Element)v.get(434)).setAttribute("alto","13" );
      ((Element)v.get(434)).setAttribute("filas","1" );
      ((Element)v.get(434)).setAttribute("valor","" );
      ((Element)v.get(434)).setAttribute("id","datosCampos" );
      ((Element)v.get(433)).appendChild((Element)v.get(434));
      /* Termina nodo:434   */
      /* Termina nodo:433   */

      /* Empieza nodo:435 / Elemento padre: 422   */
      v.add(doc.createElement("td"));
      ((Element)v.get(422)).appendChild((Element)v.get(435));

      /* Empieza nodo:436 / Elemento padre: 435   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(436)).setAttribute("src","b.gif" );
      ((Element)v.get(436)).setAttribute("width","25" );
      ((Element)v.get(436)).setAttribute("height","8" );
      ((Element)v.get(435)).appendChild((Element)v.get(436));
      /* Termina nodo:436   */
      /* Termina nodo:435   */

      /* Empieza nodo:437 / Elemento padre: 422   */
      v.add(doc.createElement("td"));
      ((Element)v.get(422)).appendChild((Element)v.get(437));

      /* Empieza nodo:438 / Elemento padre: 437   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(438)).setAttribute("nombre","lbl2dtNPersonasDependientes" );
      ((Element)v.get(438)).setAttribute("alto","13" );
      ((Element)v.get(438)).setAttribute("filas","1" );
      ((Element)v.get(438)).setAttribute("valor","" );
      ((Element)v.get(438)).setAttribute("id","datosCampos" );
      ((Element)v.get(437)).appendChild((Element)v.get(438));
      /* Termina nodo:438   */
      /* Termina nodo:437   */

      /* Empieza nodo:439 / Elemento padre: 422   */
      v.add(doc.createElement("td"));
      ((Element)v.get(439)).setAttribute("width","100%" );
      ((Element)v.get(422)).appendChild((Element)v.get(439));

      /* Empieza nodo:440 / Elemento padre: 439   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(440)).setAttribute("src","b.gif" );
      ((Element)v.get(440)).setAttribute("width","8" );
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(440)).setAttribute("height","8" );
      ((Element)v.get(439)).appendChild((Element)v.get(440));
      /* Termina nodo:440   */
      /* Termina nodo:439   */
      /* Termina nodo:422   */

      /* Empieza nodo:441 / Elemento padre: 402   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(402)).appendChild((Element)v.get(441));

      /* Empieza nodo:442 / Elemento padre: 441   */
      v.add(doc.createElement("td"));
      ((Element)v.get(442)).setAttribute("colspan","4" );
      ((Element)v.get(441)).appendChild((Element)v.get(442));

      /* Empieza nodo:443 / Elemento padre: 442   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(443)).setAttribute("src","b.gif" );
      ((Element)v.get(443)).setAttribute("width","8" );
      ((Element)v.get(443)).setAttribute("height","8" );
      ((Element)v.get(442)).appendChild((Element)v.get(443));
      /* Termina nodo:443   */
      /* Termina nodo:442   */
      /* Termina nodo:441   */
      /* Termina nodo:402   */
      /* Termina nodo:401   */
      /* Termina nodo:400   */

      /* Empieza nodo:444 / Elemento padre: 288   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(288)).appendChild((Element)v.get(444));

      /* Empieza nodo:445 / Elemento padre: 444   */
      v.add(doc.createElement("td"));
      ((Element)v.get(444)).appendChild((Element)v.get(445));

      /* Empieza nodo:446 / Elemento padre: 445   */
      v.add(doc.createElement("table"));
      ((Element)v.get(446)).setAttribute("width","708" );
      ((Element)v.get(446)).setAttribute("border","0" );
      ((Element)v.get(446)).setAttribute("align","left" );
      ((Element)v.get(446)).setAttribute("cellspacing","0" );
      ((Element)v.get(446)).setAttribute("cellpadding","0" );
      ((Element)v.get(445)).appendChild((Element)v.get(446));

      /* Empieza nodo:447 / Elemento padre: 446   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(446)).appendChild((Element)v.get(447));

      /* Empieza nodo:448 / Elemento padre: 447   */
      v.add(doc.createElement("td"));
      ((Element)v.get(447)).appendChild((Element)v.get(448));

      /* Empieza nodo:449 / Elemento padre: 448   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(449)).setAttribute("src","b.gif" );
      ((Element)v.get(449)).setAttribute("width","8" );
      ((Element)v.get(449)).setAttribute("height","8" );
      ((Element)v.get(448)).appendChild((Element)v.get(449));
      /* Termina nodo:449   */
      /* Termina nodo:448   */

      /* Empieza nodo:450 / Elemento padre: 447   */
      v.add(doc.createElement("td"));
      ((Element)v.get(447)).appendChild((Element)v.get(450));

      /* Empieza nodo:451 / Elemento padre: 450   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(451)).setAttribute("nombre","lbl2NivelSocioEconomico" );
      ((Element)v.get(451)).setAttribute("alto","13" );
      ((Element)v.get(451)).setAttribute("filas","1" );
      ((Element)v.get(451)).setAttribute("valor","" );
      ((Element)v.get(451)).setAttribute("id","datosTitle" );
      ((Element)v.get(451)).setAttribute("cod","1107" );
      ((Element)v.get(450)).appendChild((Element)v.get(451));
      /* Termina nodo:451   */
      /* Termina nodo:450   */

      /* Empieza nodo:452 / Elemento padre: 447   */
      v.add(doc.createElement("td"));
      ((Element)v.get(447)).appendChild((Element)v.get(452));

      /* Empieza nodo:453 / Elemento padre: 452   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(453)).setAttribute("src","b.gif" );
      ((Element)v.get(453)).setAttribute("width","25" );
      ((Element)v.get(453)).setAttribute("height","8" );
      ((Element)v.get(452)).appendChild((Element)v.get(453));
      /* Termina nodo:453   */
      /* Termina nodo:452   */

      /* Empieza nodo:454 / Elemento padre: 447   */
      v.add(doc.createElement("td"));
      ((Element)v.get(447)).appendChild((Element)v.get(454));

      /* Empieza nodo:455 / Elemento padre: 454   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(455)).setAttribute("nombre","lbl2CicloVidaFamiliar" );
      ((Element)v.get(455)).setAttribute("alto","13" );
      ((Element)v.get(455)).setAttribute("filas","1" );
      ((Element)v.get(455)).setAttribute("valor","" );
      ((Element)v.get(455)).setAttribute("id","datosTitle" );
      ((Element)v.get(455)).setAttribute("cod","1056" );
      ((Element)v.get(454)).appendChild((Element)v.get(455));
      /* Termina nodo:455   */
      /* Termina nodo:454   */

      /* Empieza nodo:456 / Elemento padre: 447   */
      v.add(doc.createElement("td"));
      ((Element)v.get(447)).appendChild((Element)v.get(456));

      /* Empieza nodo:457 / Elemento padre: 456   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(457)).setAttribute("src","b.gif" );
      ((Element)v.get(457)).setAttribute("width","25" );
      ((Element)v.get(457)).setAttribute("height","8" );
      ((Element)v.get(456)).appendChild((Element)v.get(457));
      /* Termina nodo:457   */
      /* Termina nodo:456   */

      /* Empieza nodo:458 / Elemento padre: 447   */
      v.add(doc.createElement("td"));
      ((Element)v.get(447)).appendChild((Element)v.get(458));

      /* Empieza nodo:459 / Elemento padre: 458   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(459)).setAttribute("nombre","lbl2DeseaCorrespondencia" );
      ((Element)v.get(459)).setAttribute("alto","13" );
      ((Element)v.get(459)).setAttribute("filas","1" );
      ((Element)v.get(459)).setAttribute("valor","" );
      ((Element)v.get(459)).setAttribute("id","datosTitle" );
      ((Element)v.get(459)).setAttribute("cod","1050" );
      ((Element)v.get(458)).appendChild((Element)v.get(459));
      /* Termina nodo:459   */
      /* Termina nodo:458   */

      /* Empieza nodo:460 / Elemento padre: 447   */
      v.add(doc.createElement("td"));
      ((Element)v.get(447)).appendChild((Element)v.get(460));

      /* Empieza nodo:461 / Elemento padre: 460   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(461)).setAttribute("src","b.gif" );
      ((Element)v.get(461)).setAttribute("width","25" );
      ((Element)v.get(461)).setAttribute("height","8" );
      ((Element)v.get(460)).appendChild((Element)v.get(461));
      /* Termina nodo:461   */
      /* Termina nodo:460   */

      /* Empieza nodo:462 / Elemento padre: 447   */
      v.add(doc.createElement("td"));
      ((Element)v.get(447)).appendChild((Element)v.get(462));

      /* Empieza nodo:463 / Elemento padre: 462   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(463)).setAttribute("nombre","lbl2ImporteIngresoFamiliar" );
      ((Element)v.get(463)).setAttribute("alto","13" );
      ((Element)v.get(463)).setAttribute("filas","1" );
      ((Element)v.get(463)).setAttribute("valor","" );
   }

   private void getXML1980(Document doc) {
      ((Element)v.get(463)).setAttribute("id","datosTitle" );
      ((Element)v.get(463)).setAttribute("cod","1080" );
      ((Element)v.get(462)).appendChild((Element)v.get(463));
      /* Termina nodo:463   */
      /* Termina nodo:462   */

      /* Empieza nodo:464 / Elemento padre: 447   */
      v.add(doc.createElement("td"));
      ((Element)v.get(464)).setAttribute("width","100%" );
      ((Element)v.get(447)).appendChild((Element)v.get(464));

      /* Empieza nodo:465 / Elemento padre: 464   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(465)).setAttribute("src","b.gif" );
      ((Element)v.get(465)).setAttribute("width","8" );
      ((Element)v.get(465)).setAttribute("height","8" );
      ((Element)v.get(464)).appendChild((Element)v.get(465));
      /* Termina nodo:465   */
      /* Termina nodo:464   */
      /* Termina nodo:447   */

      /* Empieza nodo:466 / Elemento padre: 446   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(446)).appendChild((Element)v.get(466));

      /* Empieza nodo:467 / Elemento padre: 466   */
      v.add(doc.createElement("td"));
      ((Element)v.get(466)).appendChild((Element)v.get(467));

      /* Empieza nodo:468 / Elemento padre: 467   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(468)).setAttribute("src","b.gif" );
      ((Element)v.get(468)).setAttribute("width","8" );
      ((Element)v.get(468)).setAttribute("height","8" );
      ((Element)v.get(467)).appendChild((Element)v.get(468));
      /* Termina nodo:468   */
      /* Termina nodo:467   */

      /* Empieza nodo:469 / Elemento padre: 466   */
      v.add(doc.createElement("td"));
      ((Element)v.get(466)).appendChild((Element)v.get(469));

      /* Empieza nodo:470 / Elemento padre: 469   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(470)).setAttribute("nombre","lbl2dtNivelSocioEconomico" );
      ((Element)v.get(470)).setAttribute("alto","13" );
      ((Element)v.get(470)).setAttribute("filas","1" );
      ((Element)v.get(470)).setAttribute("valor","x1" );
      ((Element)v.get(470)).setAttribute("id","datosCampos" );
      ((Element)v.get(469)).appendChild((Element)v.get(470));
      /* Termina nodo:470   */
      /* Termina nodo:469   */

      /* Empieza nodo:471 / Elemento padre: 466   */
      v.add(doc.createElement("td"));
      ((Element)v.get(466)).appendChild((Element)v.get(471));

      /* Empieza nodo:472 / Elemento padre: 471   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(472)).setAttribute("src","b.gif" );
      ((Element)v.get(472)).setAttribute("width","25" );
      ((Element)v.get(472)).setAttribute("height","8" );
      ((Element)v.get(471)).appendChild((Element)v.get(472));
      /* Termina nodo:472   */
      /* Termina nodo:471   */

      /* Empieza nodo:473 / Elemento padre: 466   */
      v.add(doc.createElement("td"));
      ((Element)v.get(466)).appendChild((Element)v.get(473));

      /* Empieza nodo:474 / Elemento padre: 473   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(474)).setAttribute("nombre","lbl2dtCicloVidaFamiliar" );
      ((Element)v.get(474)).setAttribute("alto","13" );
      ((Element)v.get(474)).setAttribute("filas","1" );
      ((Element)v.get(474)).setAttribute("valor","x1" );
      ((Element)v.get(474)).setAttribute("id","datosCampos" );
      ((Element)v.get(473)).appendChild((Element)v.get(474));
      /* Termina nodo:474   */
      /* Termina nodo:473   */

      /* Empieza nodo:475 / Elemento padre: 466   */
      v.add(doc.createElement("td"));
      ((Element)v.get(466)).appendChild((Element)v.get(475));

      /* Empieza nodo:476 / Elemento padre: 475   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(476)).setAttribute("src","b.gif" );
      ((Element)v.get(476)).setAttribute("width","25" );
      ((Element)v.get(476)).setAttribute("height","8" );
      ((Element)v.get(475)).appendChild((Element)v.get(476));
      /* Termina nodo:476   */
      /* Termina nodo:475   */

      /* Empieza nodo:477 / Elemento padre: 466   */
      v.add(doc.createElement("td"));
      ((Element)v.get(466)).appendChild((Element)v.get(477));

      /* Empieza nodo:478 / Elemento padre: 477   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(478)).setAttribute("nombre","lbl2dtDeseaCorrespondencia" );
      ((Element)v.get(478)).setAttribute("alto","13" );
      ((Element)v.get(478)).setAttribute("filas","1" );
      ((Element)v.get(478)).setAttribute("valor","x1" );
      ((Element)v.get(478)).setAttribute("id","datosCampos" );
      ((Element)v.get(477)).appendChild((Element)v.get(478));
      /* Termina nodo:478   */
      /* Termina nodo:477   */

      /* Empieza nodo:479 / Elemento padre: 466   */
      v.add(doc.createElement("td"));
      ((Element)v.get(466)).appendChild((Element)v.get(479));

      /* Empieza nodo:480 / Elemento padre: 479   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(480)).setAttribute("src","b.gif" );
      ((Element)v.get(480)).setAttribute("width","25" );
      ((Element)v.get(480)).setAttribute("height","8" );
      ((Element)v.get(479)).appendChild((Element)v.get(480));
      /* Termina nodo:480   */
      /* Termina nodo:479   */

      /* Empieza nodo:481 / Elemento padre: 466   */
      v.add(doc.createElement("td"));
      ((Element)v.get(466)).appendChild((Element)v.get(481));

      /* Empieza nodo:482 / Elemento padre: 481   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(482)).setAttribute("nombre","lbl2dtImporteIngresoFamiliar" );
      ((Element)v.get(482)).setAttribute("alto","13" );
      ((Element)v.get(482)).setAttribute("filas","1" );
      ((Element)v.get(482)).setAttribute("valor","" );
      ((Element)v.get(482)).setAttribute("id","datosCampos" );
      ((Element)v.get(481)).appendChild((Element)v.get(482));
      /* Termina nodo:482   */
      /* Termina nodo:481   */

      /* Empieza nodo:483 / Elemento padre: 466   */
      v.add(doc.createElement("td"));
      ((Element)v.get(483)).setAttribute("width","100%" );
      ((Element)v.get(466)).appendChild((Element)v.get(483));

      /* Empieza nodo:484 / Elemento padre: 483   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(484)).setAttribute("src","b.gif" );
      ((Element)v.get(484)).setAttribute("width","8" );
      ((Element)v.get(484)).setAttribute("height","8" );
      ((Element)v.get(483)).appendChild((Element)v.get(484));
      /* Termina nodo:484   */
      /* Termina nodo:483   */
      /* Termina nodo:466   */

      /* Empieza nodo:485 / Elemento padre: 446   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(446)).appendChild((Element)v.get(485));

      /* Empieza nodo:486 / Elemento padre: 485   */
      v.add(doc.createElement("td"));
      ((Element)v.get(486)).setAttribute("colspan","4" );
      ((Element)v.get(485)).appendChild((Element)v.get(486));

      /* Empieza nodo:487 / Elemento padre: 486   */
   }

   private void getXML2070(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(487)).setAttribute("src","b.gif" );
      ((Element)v.get(487)).setAttribute("width","8" );
      ((Element)v.get(487)).setAttribute("height","8" );
      ((Element)v.get(486)).appendChild((Element)v.get(487));
      /* Termina nodo:487   */
      /* Termina nodo:486   */
      /* Termina nodo:485   */
      /* Termina nodo:446   */
      /* Termina nodo:445   */
      /* Termina nodo:444   */
      /* Termina nodo:288   */
      /* Termina nodo:285   */
      /* Termina nodo:284   */

      /* Empieza nodo:488 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
      ((Element)v.get(281)).appendChild((Element)v.get(488));

      /* Empieza nodo:489 / Elemento padre: 488   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(489)).setAttribute("src","b.gif" );
      ((Element)v.get(489)).setAttribute("width","8" );
      ((Element)v.get(489)).setAttribute("height","12" );
      ((Element)v.get(488)).appendChild((Element)v.get(489));
      /* Termina nodo:489   */
      /* Termina nodo:488   */
      /* Termina nodo:281   */

      /* Empieza nodo:490 / Elemento padre: 137   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(137)).appendChild((Element)v.get(490));

      /* Empieza nodo:491 / Elemento padre: 490   */
      v.add(doc.createElement("td"));
      ((Element)v.get(491)).setAttribute("width","12" );
      ((Element)v.get(491)).setAttribute("align","center" );
      ((Element)v.get(490)).appendChild((Element)v.get(491));

      /* Empieza nodo:492 / Elemento padre: 491   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(492)).setAttribute("src","b.gif" );
      ((Element)v.get(492)).setAttribute("width","12" );
      ((Element)v.get(492)).setAttribute("height","969" );
      ((Element)v.get(491)).appendChild((Element)v.get(492));
      /* Termina nodo:492   */
      /* Termina nodo:491   */

      /* Empieza nodo:493 / Elemento padre: 490   */
      v.add(doc.createElement("td"));
      ((Element)v.get(493)).setAttribute("width","750" );
      ((Element)v.get(490)).appendChild((Element)v.get(493));

      /* Empieza nodo:494 / Elemento padre: 493   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(494)).setAttribute("src","b.gif" );
      ((Element)v.get(493)).appendChild((Element)v.get(494));
      /* Termina nodo:494   */
      /* Termina nodo:493   */

      /* Empieza nodo:495 / Elemento padre: 490   */
      v.add(doc.createElement("td"));
      ((Element)v.get(495)).setAttribute("width","12" );
      ((Element)v.get(495)).setAttribute("align","center" );
      ((Element)v.get(490)).appendChild((Element)v.get(495));

      /* Empieza nodo:496 / Elemento padre: 495   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(496)).setAttribute("src","b.gif" );
      ((Element)v.get(496)).setAttribute("width","12" );
      ((Element)v.get(496)).setAttribute("height","969" );
      ((Element)v.get(495)).appendChild((Element)v.get(496));
      /* Termina nodo:496   */
      /* Termina nodo:495   */
      /* Termina nodo:490   */

      /* Empieza nodo:497 / Elemento padre: 137   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(137)).appendChild((Element)v.get(497));

      /* Empieza nodo:498 / Elemento padre: 497   */
      v.add(doc.createElement("td"));
      ((Element)v.get(497)).appendChild((Element)v.get(498));

      /* Empieza nodo:499 / Elemento padre: 498   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(499)).setAttribute("src","b.gif" );
      ((Element)v.get(498)).appendChild((Element)v.get(499));
      /* Termina nodo:499   */
      /* Termina nodo:498   */

      /* Empieza nodo:500 / Elemento padre: 497   */
      v.add(doc.createElement("td"));
      ((Element)v.get(497)).appendChild((Element)v.get(500));

      /* Empieza nodo:501 / Elemento padre: 500   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(500)).appendChild((Element)v.get(501));

      /* Empieza nodo:502 / Elemento padre: 501   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(502)).setAttribute("class","legend" );
      ((Element)v.get(501)).appendChild((Element)v.get(502));

      /* Empieza nodo:503 / Elemento padre: 502   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(503)).setAttribute("nombre","lbl2TitGrupoPrimerContacto" );
      ((Element)v.get(503)).setAttribute("alto","13" );
      ((Element)v.get(503)).setAttribute("filas","1" );
      ((Element)v.get(503)).setAttribute("valor","" );
      ((Element)v.get(503)).setAttribute("cod","0056" );
      ((Element)v.get(503)).setAttribute("id","legend" );
      ((Element)v.get(502)).appendChild((Element)v.get(503));
      /* Termina nodo:503   */
      /* Termina nodo:502   */

      /* Empieza nodo:504 / Elemento padre: 501   */
      v.add(doc.createElement("table"));
      ((Element)v.get(504)).setAttribute("width","100%" );
      ((Element)v.get(504)).setAttribute("border","0" );
      ((Element)v.get(504)).setAttribute("align","center" );
      ((Element)v.get(504)).setAttribute("cellspacing","0" );
      ((Element)v.get(504)).setAttribute("cellpadding","0" );
      ((Element)v.get(501)).appendChild((Element)v.get(504));

      /* Empieza nodo:505 / Elemento padre: 504   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(504)).appendChild((Element)v.get(505));

      /* Empieza nodo:506 / Elemento padre: 505   */
      v.add(doc.createElement("td"));
      ((Element)v.get(505)).appendChild((Element)v.get(506));

      /* Empieza nodo:507 / Elemento padre: 506   */
      v.add(doc.createElement("table"));
      ((Element)v.get(507)).setAttribute("width","708" );
      ((Element)v.get(507)).setAttribute("border","0" );
      ((Element)v.get(507)).setAttribute("align","left" );
      ((Element)v.get(507)).setAttribute("cellspacing","0" );
      ((Element)v.get(507)).setAttribute("cellpadding","0" );
      ((Element)v.get(506)).appendChild((Element)v.get(507));

      /* Empieza nodo:508 / Elemento padre: 507   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(507)).appendChild((Element)v.get(508));

      /* Empieza nodo:509 / Elemento padre: 508   */
      v.add(doc.createElement("td"));
      ((Element)v.get(509)).setAttribute("colspan","4" );
      ((Element)v.get(508)).appendChild((Element)v.get(509));

      /* Empieza nodo:510 / Elemento padre: 509   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(510)).setAttribute("src","b.gif" );
      ((Element)v.get(510)).setAttribute("width","8" );
      ((Element)v.get(510)).setAttribute("height","8" );
      ((Element)v.get(509)).appendChild((Element)v.get(510));
      /* Termina nodo:510   */
      /* Termina nodo:509   */
      /* Termina nodo:508   */

      /* Empieza nodo:511 / Elemento padre: 507   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(507)).appendChild((Element)v.get(511));

      /* Empieza nodo:512 / Elemento padre: 511   */
   }

   private void getXML2160(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(511)).appendChild((Element)v.get(512));

      /* Empieza nodo:513 / Elemento padre: 512   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(513)).setAttribute("src","b.gif" );
      ((Element)v.get(513)).setAttribute("width","8" );
      ((Element)v.get(513)).setAttribute("height","8" );
      ((Element)v.get(512)).appendChild((Element)v.get(513));
      /* Termina nodo:513   */
      /* Termina nodo:512   */

      /* Empieza nodo:514 / Elemento padre: 511   */
      v.add(doc.createElement("td"));
      ((Element)v.get(511)).appendChild((Element)v.get(514));

      /* Empieza nodo:515 / Elemento padre: 514   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(515)).setAttribute("nombre","lbl2CodClienteContactado" );
      ((Element)v.get(515)).setAttribute("alto","13" );
      ((Element)v.get(515)).setAttribute("filas","1" );
      ((Element)v.get(515)).setAttribute("valor","" );
      ((Element)v.get(515)).setAttribute("id","datosTitle" );
      ((Element)v.get(515)).setAttribute("cod","1060" );
      ((Element)v.get(514)).appendChild((Element)v.get(515));
      /* Termina nodo:515   */
      /* Termina nodo:514   */

      /* Empieza nodo:516 / Elemento padre: 511   */
      v.add(doc.createElement("td"));
      ((Element)v.get(511)).appendChild((Element)v.get(516));

      /* Empieza nodo:517 / Elemento padre: 516   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(517)).setAttribute("src","b.gif" );
      ((Element)v.get(517)).setAttribute("width","25" );
      ((Element)v.get(517)).setAttribute("height","8" );
      ((Element)v.get(516)).appendChild((Element)v.get(517));
      /* Termina nodo:517   */
      /* Termina nodo:516   */

      /* Empieza nodo:518 / Elemento padre: 511   */
      v.add(doc.createElement("td"));
      ((Element)v.get(511)).appendChild((Element)v.get(518));

      /* Empieza nodo:519 / Elemento padre: 518   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(519)).setAttribute("nombre","lbl2TipoClienteContactado" );
      ((Element)v.get(519)).setAttribute("alto","13" );
      ((Element)v.get(519)).setAttribute("filas","1" );
      ((Element)v.get(519)).setAttribute("valor","" );
      ((Element)v.get(519)).setAttribute("id","datosTitle" );
      ((Element)v.get(519)).setAttribute("cod","1125" );
      ((Element)v.get(518)).appendChild((Element)v.get(519));
      /* Termina nodo:519   */
      /* Termina nodo:518   */

      /* Empieza nodo:520 / Elemento padre: 511   */
      v.add(doc.createElement("td"));
      ((Element)v.get(511)).appendChild((Element)v.get(520));

      /* Empieza nodo:521 / Elemento padre: 520   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(521)).setAttribute("src","b.gif" );
      ((Element)v.get(521)).setAttribute("width","25" );
      ((Element)v.get(521)).setAttribute("height","8" );
      ((Element)v.get(520)).appendChild((Element)v.get(521));
      /* Termina nodo:521   */
      /* Termina nodo:520   */

      /* Empieza nodo:522 / Elemento padre: 511   */
      v.add(doc.createElement("td"));
      ((Element)v.get(511)).appendChild((Element)v.get(522));

      /* Empieza nodo:523 / Elemento padre: 522   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(523)).setAttribute("nombre","lbl2TipoClienteContacto" );
      ((Element)v.get(523)).setAttribute("alto","13" );
      ((Element)v.get(523)).setAttribute("filas","1" );
      ((Element)v.get(523)).setAttribute("valor","" );
      ((Element)v.get(523)).setAttribute("id","datosTitle" );
      ((Element)v.get(523)).setAttribute("cod","1343" );
      ((Element)v.get(522)).appendChild((Element)v.get(523));
      /* Termina nodo:523   */
      /* Termina nodo:522   */

      /* Empieza nodo:524 / Elemento padre: 511   */
      v.add(doc.createElement("td"));
      ((Element)v.get(511)).appendChild((Element)v.get(524));

      /* Empieza nodo:525 / Elemento padre: 524   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(525)).setAttribute("src","b.gif" );
      ((Element)v.get(525)).setAttribute("width","25" );
      ((Element)v.get(525)).setAttribute("height","8" );
      ((Element)v.get(524)).appendChild((Element)v.get(525));
      /* Termina nodo:525   */
      /* Termina nodo:524   */

      /* Empieza nodo:526 / Elemento padre: 511   */
      v.add(doc.createElement("td"));
      ((Element)v.get(511)).appendChild((Element)v.get(526));

      /* Empieza nodo:527 / Elemento padre: 526   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(527)).setAttribute("nombre","lbl2CodTipoContacto" );
      ((Element)v.get(527)).setAttribute("alto","13" );
      ((Element)v.get(527)).setAttribute("filas","1" );
      ((Element)v.get(527)).setAttribute("valor","" );
      ((Element)v.get(527)).setAttribute("id","datosTitle" );
      ((Element)v.get(527)).setAttribute("cod","1065" );
      ((Element)v.get(526)).appendChild((Element)v.get(527));
      /* Termina nodo:527   */
      /* Termina nodo:526   */

      /* Empieza nodo:528 / Elemento padre: 511   */
      v.add(doc.createElement("td"));
      ((Element)v.get(528)).setAttribute("width","100%" );
      ((Element)v.get(511)).appendChild((Element)v.get(528));

      /* Empieza nodo:529 / Elemento padre: 528   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(529)).setAttribute("src","b.gif" );
      ((Element)v.get(529)).setAttribute("width","8" );
      ((Element)v.get(529)).setAttribute("height","8" );
      ((Element)v.get(528)).appendChild((Element)v.get(529));
      /* Termina nodo:529   */
      /* Termina nodo:528   */
      /* Termina nodo:511   */

      /* Empieza nodo:530 / Elemento padre: 507   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(507)).appendChild((Element)v.get(530));

      /* Empieza nodo:531 / Elemento padre: 530   */
      v.add(doc.createElement("td"));
      ((Element)v.get(530)).appendChild((Element)v.get(531));

      /* Empieza nodo:532 / Elemento padre: 531   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(532)).setAttribute("src","b.gif" );
      ((Element)v.get(532)).setAttribute("width","8" );
      ((Element)v.get(532)).setAttribute("height","8" );
      ((Element)v.get(531)).appendChild((Element)v.get(532));
      /* Termina nodo:532   */
      /* Termina nodo:531   */

      /* Empieza nodo:533 / Elemento padre: 530   */
      v.add(doc.createElement("td"));
      ((Element)v.get(530)).appendChild((Element)v.get(533));

      /* Empieza nodo:534 / Elemento padre: 533   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(534)).setAttribute("nombre","lbl2dtCodClienteContactado" );
      ((Element)v.get(534)).setAttribute("alto","13" );
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(534)).setAttribute("filas","1" );
      ((Element)v.get(534)).setAttribute("valor","" );
      ((Element)v.get(534)).setAttribute("id","datosCampos" );
      ((Element)v.get(533)).appendChild((Element)v.get(534));
      /* Termina nodo:534   */
      /* Termina nodo:533   */

      /* Empieza nodo:535 / Elemento padre: 530   */
      v.add(doc.createElement("td"));
      ((Element)v.get(530)).appendChild((Element)v.get(535));

      /* Empieza nodo:536 / Elemento padre: 535   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(536)).setAttribute("src","b.gif" );
      ((Element)v.get(536)).setAttribute("width","25" );
      ((Element)v.get(536)).setAttribute("height","8" );
      ((Element)v.get(535)).appendChild((Element)v.get(536));
      /* Termina nodo:536   */
      /* Termina nodo:535   */

      /* Empieza nodo:537 / Elemento padre: 530   */
      v.add(doc.createElement("td"));
      ((Element)v.get(530)).appendChild((Element)v.get(537));

      /* Empieza nodo:538 / Elemento padre: 537   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(538)).setAttribute("nombre","lbl2dtTipoClienteContactado" );
      ((Element)v.get(538)).setAttribute("alto","13" );
      ((Element)v.get(538)).setAttribute("filas","1" );
      ((Element)v.get(538)).setAttribute("valor","" );
      ((Element)v.get(538)).setAttribute("id","datosCampos" );
      ((Element)v.get(537)).appendChild((Element)v.get(538));
      /* Termina nodo:538   */
      /* Termina nodo:537   */

      /* Empieza nodo:539 / Elemento padre: 530   */
      v.add(doc.createElement("td"));
      ((Element)v.get(530)).appendChild((Element)v.get(539));

      /* Empieza nodo:540 / Elemento padre: 539   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(540)).setAttribute("src","b.gif" );
      ((Element)v.get(540)).setAttribute("width","25" );
      ((Element)v.get(540)).setAttribute("height","8" );
      ((Element)v.get(539)).appendChild((Element)v.get(540));
      /* Termina nodo:540   */
      /* Termina nodo:539   */

      /* Empieza nodo:541 / Elemento padre: 530   */
      v.add(doc.createElement("td"));
      ((Element)v.get(530)).appendChild((Element)v.get(541));

      /* Empieza nodo:542 / Elemento padre: 541   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(542)).setAttribute("nombre","lbl2dtTipoClienteContacto" );
      ((Element)v.get(542)).setAttribute("alto","13" );
      ((Element)v.get(542)).setAttribute("filas","1" );
      ((Element)v.get(542)).setAttribute("valor","" );
      ((Element)v.get(542)).setAttribute("id","datosCampos" );
      ((Element)v.get(541)).appendChild((Element)v.get(542));
      /* Termina nodo:542   */
      /* Termina nodo:541   */

      /* Empieza nodo:543 / Elemento padre: 530   */
      v.add(doc.createElement("td"));
      ((Element)v.get(530)).appendChild((Element)v.get(543));

      /* Empieza nodo:544 / Elemento padre: 543   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(544)).setAttribute("src","b.gif" );
      ((Element)v.get(544)).setAttribute("width","25" );
      ((Element)v.get(544)).setAttribute("height","8" );
      ((Element)v.get(543)).appendChild((Element)v.get(544));
      /* Termina nodo:544   */
      /* Termina nodo:543   */

      /* Empieza nodo:545 / Elemento padre: 530   */
      v.add(doc.createElement("td"));
      ((Element)v.get(530)).appendChild((Element)v.get(545));

      /* Empieza nodo:546 / Elemento padre: 545   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(546)).setAttribute("nombre","lbl2dtCodTipoContacto" );
      ((Element)v.get(546)).setAttribute("alto","13" );
      ((Element)v.get(546)).setAttribute("filas","1" );
      ((Element)v.get(546)).setAttribute("valor","" );
      ((Element)v.get(546)).setAttribute("id","datosCampos" );
      ((Element)v.get(545)).appendChild((Element)v.get(546));
      /* Termina nodo:546   */
      /* Termina nodo:545   */

      /* Empieza nodo:547 / Elemento padre: 530   */
      v.add(doc.createElement("td"));
      ((Element)v.get(547)).setAttribute("width","100%" );
      ((Element)v.get(530)).appendChild((Element)v.get(547));

      /* Empieza nodo:548 / Elemento padre: 547   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(548)).setAttribute("src","b.gif" );
      ((Element)v.get(548)).setAttribute("width","8" );
      ((Element)v.get(548)).setAttribute("height","8" );
      ((Element)v.get(547)).appendChild((Element)v.get(548));
      /* Termina nodo:548   */
      /* Termina nodo:547   */
      /* Termina nodo:530   */

      /* Empieza nodo:549 / Elemento padre: 507   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(507)).appendChild((Element)v.get(549));

      /* Empieza nodo:550 / Elemento padre: 549   */
      v.add(doc.createElement("td"));
      ((Element)v.get(550)).setAttribute("colspan","4" );
      ((Element)v.get(549)).appendChild((Element)v.get(550));

      /* Empieza nodo:551 / Elemento padre: 550   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(551)).setAttribute("src","b.gif" );
      ((Element)v.get(551)).setAttribute("width","8" );
      ((Element)v.get(551)).setAttribute("height","8" );
      ((Element)v.get(550)).appendChild((Element)v.get(551));
      /* Termina nodo:551   */
      /* Termina nodo:550   */
      /* Termina nodo:549   */
      /* Termina nodo:507   */
      /* Termina nodo:506   */
      /* Termina nodo:505   */

      /* Empieza nodo:552 / Elemento padre: 504   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(504)).appendChild((Element)v.get(552));

      /* Empieza nodo:553 / Elemento padre: 552   */
      v.add(doc.createElement("td"));
      ((Element)v.get(552)).appendChild((Element)v.get(553));

      /* Empieza nodo:554 / Elemento padre: 553   */
      v.add(doc.createElement("table"));
      ((Element)v.get(554)).setAttribute("width","708" );
      ((Element)v.get(554)).setAttribute("border","0" );
      ((Element)v.get(554)).setAttribute("align","left" );
      ((Element)v.get(554)).setAttribute("cellspacing","0" );
      ((Element)v.get(554)).setAttribute("cellpadding","0" );
      ((Element)v.get(553)).appendChild((Element)v.get(554));

      /* Empieza nodo:555 / Elemento padre: 554   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(554)).appendChild((Element)v.get(555));

      /* Empieza nodo:556 / Elemento padre: 555   */
      v.add(doc.createElement("td"));
      ((Element)v.get(555)).appendChild((Element)v.get(556));

      /* Empieza nodo:557 / Elemento padre: 556   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(557)).setAttribute("src","b.gif" );
      ((Element)v.get(557)).setAttribute("width","8" );
      ((Element)v.get(557)).setAttribute("height","8" );
      ((Element)v.get(556)).appendChild((Element)v.get(557));
      /* Termina nodo:557   */
      /* Termina nodo:556   */

      /* Empieza nodo:558 / Elemento padre: 555   */
   }

   private void getXML2340(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(555)).appendChild((Element)v.get(558));

      /* Empieza nodo:559 / Elemento padre: 558   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(559)).setAttribute("nombre","lbl2FechaContacto" );
      ((Element)v.get(559)).setAttribute("alto","13" );
      ((Element)v.get(559)).setAttribute("filas","1" );
      ((Element)v.get(559)).setAttribute("valor","" );
      ((Element)v.get(559)).setAttribute("id","datosTitle" );
      ((Element)v.get(559)).setAttribute("cod","1078" );
      ((Element)v.get(558)).appendChild((Element)v.get(559));
      /* Termina nodo:559   */
      /* Termina nodo:558   */

      /* Empieza nodo:560 / Elemento padre: 555   */
      v.add(doc.createElement("td"));
      ((Element)v.get(555)).appendChild((Element)v.get(560));

      /* Empieza nodo:561 / Elemento padre: 560   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(561)).setAttribute("src","b.gif" );
      ((Element)v.get(561)).setAttribute("width","25" );
      ((Element)v.get(561)).setAttribute("height","8" );
      ((Element)v.get(560)).appendChild((Element)v.get(561));
      /* Termina nodo:561   */
      /* Termina nodo:560   */

      /* Empieza nodo:562 / Elemento padre: 555   */
      v.add(doc.createElement("td"));
      ((Element)v.get(555)).appendChild((Element)v.get(562));

      /* Empieza nodo:563 / Elemento padre: 562   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(563)).setAttribute("nombre","lbl2FechaSiguienteContacto" );
      ((Element)v.get(563)).setAttribute("alto","13" );
      ((Element)v.get(563)).setAttribute("filas","1" );
      ((Element)v.get(563)).setAttribute("valor","" );
      ((Element)v.get(563)).setAttribute("id","datosTitle" );
      ((Element)v.get(563)).setAttribute("cod","1342" );
      ((Element)v.get(562)).appendChild((Element)v.get(563));
      /* Termina nodo:563   */
      /* Termina nodo:562   */

      /* Empieza nodo:564 / Elemento padre: 555   */
      v.add(doc.createElement("td"));
      ((Element)v.get(555)).appendChild((Element)v.get(564));

      /* Empieza nodo:565 / Elemento padre: 564   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(565)).setAttribute("src","b.gif" );
      ((Element)v.get(565)).setAttribute("width","25" );
      ((Element)v.get(565)).setAttribute("height","8" );
      ((Element)v.get(564)).appendChild((Element)v.get(565));
      /* Termina nodo:565   */
      /* Termina nodo:564   */

      /* Empieza nodo:566 / Elemento padre: 555   */
      v.add(doc.createElement("td"));
      ((Element)v.get(555)).appendChild((Element)v.get(566));

      /* Empieza nodo:567 / Elemento padre: 566   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(567)).setAttribute("nombre","lbl2Marca" );
      ((Element)v.get(567)).setAttribute("alto","13" );
      ((Element)v.get(567)).setAttribute("filas","1" );
      ((Element)v.get(567)).setAttribute("valor","" );
      ((Element)v.get(567)).setAttribute("id","datosTitle" );
      ((Element)v.get(567)).setAttribute("cod","6" );
      ((Element)v.get(566)).appendChild((Element)v.get(567));
      /* Termina nodo:567   */
      /* Termina nodo:566   */

      /* Empieza nodo:568 / Elemento padre: 555   */
      v.add(doc.createElement("td"));
      ((Element)v.get(568)).setAttribute("width","100%" );
      ((Element)v.get(555)).appendChild((Element)v.get(568));

      /* Empieza nodo:569 / Elemento padre: 568   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(569)).setAttribute("src","b.gif" );
      ((Element)v.get(569)).setAttribute("width","8" );
      ((Element)v.get(569)).setAttribute("height","8" );
      ((Element)v.get(568)).appendChild((Element)v.get(569));
      /* Termina nodo:569   */
      /* Termina nodo:568   */
      /* Termina nodo:555   */

      /* Empieza nodo:570 / Elemento padre: 554   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(554)).appendChild((Element)v.get(570));

      /* Empieza nodo:571 / Elemento padre: 570   */
      v.add(doc.createElement("td"));
      ((Element)v.get(570)).appendChild((Element)v.get(571));

      /* Empieza nodo:572 / Elemento padre: 571   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(572)).setAttribute("src","b.gif" );
      ((Element)v.get(572)).setAttribute("width","8" );
      ((Element)v.get(572)).setAttribute("height","8" );
      ((Element)v.get(571)).appendChild((Element)v.get(572));
      /* Termina nodo:572   */
      /* Termina nodo:571   */

      /* Empieza nodo:573 / Elemento padre: 570   */
      v.add(doc.createElement("td"));
      ((Element)v.get(570)).appendChild((Element)v.get(573));

      /* Empieza nodo:574 / Elemento padre: 573   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(574)).setAttribute("nombre","lbl2dtFechaContacto" );
      ((Element)v.get(574)).setAttribute("alto","13" );
      ((Element)v.get(574)).setAttribute("filas","1" );
      ((Element)v.get(574)).setAttribute("valor","" );
      ((Element)v.get(574)).setAttribute("id","datosCampos" );
      ((Element)v.get(573)).appendChild((Element)v.get(574));
      /* Termina nodo:574   */
      /* Termina nodo:573   */

      /* Empieza nodo:575 / Elemento padre: 570   */
      v.add(doc.createElement("td"));
      ((Element)v.get(570)).appendChild((Element)v.get(575));

      /* Empieza nodo:576 / Elemento padre: 575   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(576)).setAttribute("src","b.gif" );
      ((Element)v.get(576)).setAttribute("width","25" );
      ((Element)v.get(576)).setAttribute("height","8" );
      ((Element)v.get(575)).appendChild((Element)v.get(576));
      /* Termina nodo:576   */
      /* Termina nodo:575   */

      /* Empieza nodo:577 / Elemento padre: 570   */
      v.add(doc.createElement("td"));
      ((Element)v.get(570)).appendChild((Element)v.get(577));

      /* Empieza nodo:578 / Elemento padre: 577   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(578)).setAttribute("nombre","lbl2dtFechaSiguienteContacto" );
      ((Element)v.get(578)).setAttribute("alto","13" );
      ((Element)v.get(578)).setAttribute("filas","1" );
      ((Element)v.get(578)).setAttribute("valor","" );
      ((Element)v.get(578)).setAttribute("id","datosCampos" );
      ((Element)v.get(577)).appendChild((Element)v.get(578));
      /* Termina nodo:578   */
      /* Termina nodo:577   */

      /* Empieza nodo:579 / Elemento padre: 570   */
      v.add(doc.createElement("td"));
      ((Element)v.get(570)).appendChild((Element)v.get(579));

      /* Empieza nodo:580 / Elemento padre: 579   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(580)).setAttribute("src","b.gif" );
   }

   private void getXML2430(Document doc) {
      ((Element)v.get(580)).setAttribute("width","25" );
      ((Element)v.get(580)).setAttribute("height","8" );
      ((Element)v.get(579)).appendChild((Element)v.get(580));
      /* Termina nodo:580   */
      /* Termina nodo:579   */

      /* Empieza nodo:581 / Elemento padre: 570   */
      v.add(doc.createElement("td"));
      ((Element)v.get(570)).appendChild((Element)v.get(581));

      /* Empieza nodo:582 / Elemento padre: 581   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(582)).setAttribute("nombre","lbl2dtMarca" );
      ((Element)v.get(582)).setAttribute("alto","13" );
      ((Element)v.get(582)).setAttribute("filas","1" );
      ((Element)v.get(582)).setAttribute("valor","" );
      ((Element)v.get(582)).setAttribute("id","datosCampos" );
      ((Element)v.get(581)).appendChild((Element)v.get(582));
      /* Termina nodo:582   */
      /* Termina nodo:581   */

      /* Empieza nodo:583 / Elemento padre: 570   */
      v.add(doc.createElement("td"));
      ((Element)v.get(583)).setAttribute("width","100%" );
      ((Element)v.get(570)).appendChild((Element)v.get(583));

      /* Empieza nodo:584 / Elemento padre: 583   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(584)).setAttribute("src","b.gif" );
      ((Element)v.get(584)).setAttribute("width","8" );
      ((Element)v.get(584)).setAttribute("height","8" );
      ((Element)v.get(583)).appendChild((Element)v.get(584));
      /* Termina nodo:584   */
      /* Termina nodo:583   */
      /* Termina nodo:570   */

      /* Empieza nodo:585 / Elemento padre: 554   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(554)).appendChild((Element)v.get(585));

      /* Empieza nodo:586 / Elemento padre: 585   */
      v.add(doc.createElement("td"));
      ((Element)v.get(586)).setAttribute("colspan","4" );
      ((Element)v.get(585)).appendChild((Element)v.get(586));

      /* Empieza nodo:587 / Elemento padre: 586   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(587)).setAttribute("src","b.gif" );
      ((Element)v.get(587)).setAttribute("width","8" );
      ((Element)v.get(587)).setAttribute("height","8" );
      ((Element)v.get(586)).appendChild((Element)v.get(587));
      /* Termina nodo:587   */
      /* Termina nodo:586   */
      /* Termina nodo:585   */
      /* Termina nodo:554   */
      /* Termina nodo:553   */
      /* Termina nodo:552   */

      /* Empieza nodo:588 / Elemento padre: 504   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(504)).appendChild((Element)v.get(588));

      /* Empieza nodo:589 / Elemento padre: 588   */
      v.add(doc.createElement("td"));
      ((Element)v.get(588)).appendChild((Element)v.get(589));

      /* Empieza nodo:590 / Elemento padre: 589   */
      v.add(doc.createElement("table"));
      ((Element)v.get(590)).setAttribute("width","708" );
      ((Element)v.get(590)).setAttribute("border","0" );
      ((Element)v.get(590)).setAttribute("align","left" );
      ((Element)v.get(590)).setAttribute("cellspacing","0" );
      ((Element)v.get(590)).setAttribute("cellpadding","0" );
      ((Element)v.get(589)).appendChild((Element)v.get(590));

      /* Empieza nodo:591 / Elemento padre: 590   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(590)).appendChild((Element)v.get(591));

      /* Empieza nodo:592 / Elemento padre: 591   */
      v.add(doc.createElement("td"));
      ((Element)v.get(591)).appendChild((Element)v.get(592));

      /* Empieza nodo:593 / Elemento padre: 592   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(593)).setAttribute("src","b.gif" );
      ((Element)v.get(593)).setAttribute("width","8" );
      ((Element)v.get(593)).setAttribute("height","8" );
      ((Element)v.get(592)).appendChild((Element)v.get(593));
      /* Termina nodo:593   */
      /* Termina nodo:592   */

      /* Empieza nodo:594 / Elemento padre: 591   */
      v.add(doc.createElement("td"));
      ((Element)v.get(591)).appendChild((Element)v.get(594));

      /* Empieza nodo:595 / Elemento padre: 594   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(595)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(595)).setAttribute("alto","13" );
      ((Element)v.get(595)).setAttribute("filas","1" );
      ((Element)v.get(595)).setAttribute("valor","" );
      ((Element)v.get(595)).setAttribute("id","datosTitle" );
      ((Element)v.get(595)).setAttribute("cod","7" );
      ((Element)v.get(594)).appendChild((Element)v.get(595));
      /* Termina nodo:595   */
      /* Termina nodo:594   */

      /* Empieza nodo:596 / Elemento padre: 591   */
      v.add(doc.createElement("td"));
      ((Element)v.get(591)).appendChild((Element)v.get(596));

      /* Empieza nodo:597 / Elemento padre: 596   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(597)).setAttribute("src","b.gif" );
      ((Element)v.get(597)).setAttribute("width","25" );
      ((Element)v.get(597)).setAttribute("height","8" );
      ((Element)v.get(596)).appendChild((Element)v.get(597));
      /* Termina nodo:597   */
      /* Termina nodo:596   */

      /* Empieza nodo:598 / Elemento padre: 591   */
      v.add(doc.createElement("td"));
      ((Element)v.get(591)).appendChild((Element)v.get(598));

      /* Empieza nodo:599 / Elemento padre: 598   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(599)).setAttribute("nombre","lblPeriodoPrimerPedido" );
      ((Element)v.get(599)).setAttribute("alto","13" );
      ((Element)v.get(599)).setAttribute("filas","1" );
      ((Element)v.get(599)).setAttribute("valor","" );
      ((Element)v.get(599)).setAttribute("id","datosTitle" );
      ((Element)v.get(599)).setAttribute("cod","2420" );
      ((Element)v.get(598)).appendChild((Element)v.get(599));
      /* Termina nodo:599   */
      /* Termina nodo:598   */

      /* Empieza nodo:600 / Elemento padre: 591   */
      v.add(doc.createElement("td"));
      ((Element)v.get(600)).setAttribute("width","100%" );
      ((Element)v.get(591)).appendChild((Element)v.get(600));

      /* Empieza nodo:601 / Elemento padre: 600   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(601)).setAttribute("src","b.gif" );
      ((Element)v.get(601)).setAttribute("width","8" );
      ((Element)v.get(601)).setAttribute("height","8" );
      ((Element)v.get(600)).appendChild((Element)v.get(601));
      /* Termina nodo:601   */
      /* Termina nodo:600   */
      /* Termina nodo:591   */

      /* Empieza nodo:602 / Elemento padre: 590   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(590)).appendChild((Element)v.get(602));

      /* Empieza nodo:603 / Elemento padre: 602   */
      v.add(doc.createElement("td"));
      ((Element)v.get(602)).appendChild((Element)v.get(603));

      /* Empieza nodo:604 / Elemento padre: 603   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML2520(Document doc) {
      ((Element)v.get(604)).setAttribute("src","b.gif" );
      ((Element)v.get(604)).setAttribute("width","8" );
      ((Element)v.get(604)).setAttribute("height","8" );
      ((Element)v.get(603)).appendChild((Element)v.get(604));
      /* Termina nodo:604   */
      /* Termina nodo:603   */

      /* Empieza nodo:605 / Elemento padre: 602   */
      v.add(doc.createElement("td"));
      ((Element)v.get(602)).appendChild((Element)v.get(605));

      /* Empieza nodo:606 / Elemento padre: 605   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(606)).setAttribute("nombre","lbldtCanal" );
      ((Element)v.get(606)).setAttribute("alto","13" );
      ((Element)v.get(606)).setAttribute("filas","1" );
      ((Element)v.get(606)).setAttribute("valor","" );
      ((Element)v.get(606)).setAttribute("id","datosCampos" );
      ((Element)v.get(605)).appendChild((Element)v.get(606));
      /* Termina nodo:606   */
      /* Termina nodo:605   */

      /* Empieza nodo:607 / Elemento padre: 602   */
      v.add(doc.createElement("td"));
      ((Element)v.get(602)).appendChild((Element)v.get(607));

      /* Empieza nodo:608 / Elemento padre: 607   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(608)).setAttribute("src","b.gif" );
      ((Element)v.get(608)).setAttribute("width","25" );
      ((Element)v.get(608)).setAttribute("height","8" );
      ((Element)v.get(607)).appendChild((Element)v.get(608));
      /* Termina nodo:608   */
      /* Termina nodo:607   */

      /* Empieza nodo:609 / Elemento padre: 602   */
      v.add(doc.createElement("td"));
      ((Element)v.get(602)).appendChild((Element)v.get(609));

      /* Empieza nodo:610 / Elemento padre: 609   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(610)).setAttribute("nombre","lbldtPeriodoPrimerPedido" );
      ((Element)v.get(610)).setAttribute("alto","13" );
      ((Element)v.get(610)).setAttribute("filas","1" );
      ((Element)v.get(610)).setAttribute("valor","" );
      ((Element)v.get(610)).setAttribute("id","datosCampos" );
      ((Element)v.get(609)).appendChild((Element)v.get(610));
      /* Termina nodo:610   */
      /* Termina nodo:609   */

      /* Empieza nodo:611 / Elemento padre: 602   */
      v.add(doc.createElement("td"));
      ((Element)v.get(611)).setAttribute("width","100%" );
      ((Element)v.get(602)).appendChild((Element)v.get(611));

      /* Empieza nodo:612 / Elemento padre: 611   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(612)).setAttribute("src","b.gif" );
      ((Element)v.get(612)).setAttribute("width","8" );
      ((Element)v.get(612)).setAttribute("height","8" );
      ((Element)v.get(611)).appendChild((Element)v.get(612));
      /* Termina nodo:612   */
      /* Termina nodo:611   */
      /* Termina nodo:602   */

      /* Empieza nodo:613 / Elemento padre: 590   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(590)).appendChild((Element)v.get(613));

      /* Empieza nodo:614 / Elemento padre: 613   */
      v.add(doc.createElement("td"));
      ((Element)v.get(614)).setAttribute("colspan","4" );
      ((Element)v.get(613)).appendChild((Element)v.get(614));

      /* Empieza nodo:615 / Elemento padre: 614   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(615)).setAttribute("src","b.gif" );
      ((Element)v.get(615)).setAttribute("width","8" );
      ((Element)v.get(615)).setAttribute("height","8" );
      ((Element)v.get(614)).appendChild((Element)v.get(615));
      /* Termina nodo:615   */
      /* Termina nodo:614   */
      /* Termina nodo:613   */
      /* Termina nodo:590   */
      /* Termina nodo:589   */
      /* Termina nodo:588   */
      /* Termina nodo:504   */
      /* Termina nodo:501   */
      /* Termina nodo:500   */

      /* Empieza nodo:616 / Elemento padre: 497   */
      v.add(doc.createElement("td"));
      ((Element)v.get(497)).appendChild((Element)v.get(616));

      /* Empieza nodo:617 / Elemento padre: 616   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(617)).setAttribute("src","b.gif" );
      ((Element)v.get(617)).setAttribute("width","8" );
      ((Element)v.get(617)).setAttribute("height","12" );
      ((Element)v.get(616)).appendChild((Element)v.get(617));
      /* Termina nodo:617   */
      /* Termina nodo:616   */
      /* Termina nodo:497   */

      /* Empieza nodo:618 / Elemento padre: 137   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(137)).appendChild((Element)v.get(618));

      /* Empieza nodo:619 / Elemento padre: 618   */
      v.add(doc.createElement("td"));
      ((Element)v.get(618)).appendChild((Element)v.get(619));

      /* Empieza nodo:620 / Elemento padre: 619   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(620)).setAttribute("src","b.gif" );
      ((Element)v.get(619)).appendChild((Element)v.get(620));
      /* Termina nodo:620   */
      /* Termina nodo:619   */

      /* Empieza nodo:621 / Elemento padre: 618   */
      v.add(doc.createElement("td"));
      ((Element)v.get(618)).appendChild((Element)v.get(621));

      /* Empieza nodo:622 / Elemento padre: 621   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(621)).appendChild((Element)v.get(622));

      /* Empieza nodo:623 / Elemento padre: 622   */
      v.add(doc.createElement("table"));
      ((Element)v.get(623)).setAttribute("width","100%" );
      ((Element)v.get(623)).setAttribute("border","0" );
      ((Element)v.get(623)).setAttribute("align","center" );
      ((Element)v.get(623)).setAttribute("cellspacing","0" );
      ((Element)v.get(623)).setAttribute("cellpadding","0" );
      ((Element)v.get(622)).appendChild((Element)v.get(623));

      /* Empieza nodo:624 / Elemento padre: 623   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(623)).appendChild((Element)v.get(624));

      /* Empieza nodo:625 / Elemento padre: 624   */
      v.add(doc.createElement("td"));
      ((Element)v.get(625)).setAttribute("class","botonera" );
      ((Element)v.get(624)).appendChild((Element)v.get(625));

      /* Empieza nodo:626 / Elemento padre: 625   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(626)).setAttribute("nombre","btnAnterior" );
      ((Element)v.get(626)).setAttribute("ID","botonContenido" );
      ((Element)v.get(626)).setAttribute("tipo","html" );
      ((Element)v.get(626)).setAttribute("accion","navegaPestaniasDetalle(1);" );
      ((Element)v.get(626)).setAttribute("estado","false" );
      ((Element)v.get(626)).setAttribute("cod","1649" );
      ((Element)v.get(625)).appendChild((Element)v.get(626));
      /* Termina nodo:626   */

      /* Empieza nodo:627 / Elemento padre: 625   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(627)).setAttribute("nombre","btnSiguiente" );
      ((Element)v.get(627)).setAttribute("ID","botonContenido" );
      ((Element)v.get(627)).setAttribute("tipo","html" );
      ((Element)v.get(627)).setAttribute("accion","navegaPestaniasDetalle(3);" );
   }

   private void getXML2610(Document doc) {
      ((Element)v.get(627)).setAttribute("estado","false" );
      ((Element)v.get(627)).setAttribute("cod","446" );
      ((Element)v.get(625)).appendChild((Element)v.get(627));
      /* Termina nodo:627   */
      /* Termina nodo:625   */
      /* Termina nodo:624   */
      /* Termina nodo:623   */
      /* Termina nodo:622   */
      /* Termina nodo:621   */

      /* Empieza nodo:628 / Elemento padre: 618   */
      v.add(doc.createElement("td"));
      ((Element)v.get(618)).appendChild((Element)v.get(628));

      /* Empieza nodo:629 / Elemento padre: 628   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(629)).setAttribute("src","b.gif" );
      ((Element)v.get(629)).setAttribute("width","8" );
      ((Element)v.get(629)).setAttribute("height","12" );
      ((Element)v.get(628)).appendChild((Element)v.get(629));
      /* Termina nodo:629   */
      /* Termina nodo:628   */
      /* Termina nodo:618   */

      /* Empieza nodo:630 / Elemento padre: 137   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(137)).appendChild((Element)v.get(630));

      /* Empieza nodo:631 / Elemento padre: 630   */
      v.add(doc.createElement("td"));
      ((Element)v.get(631)).setAttribute("width","12" );
      ((Element)v.get(631)).setAttribute("align","center" );
      ((Element)v.get(630)).appendChild((Element)v.get(631));

      /* Empieza nodo:632 / Elemento padre: 631   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(632)).setAttribute("src","b.gif" );
      ((Element)v.get(632)).setAttribute("width","12" );
      ((Element)v.get(632)).setAttribute("height","12" );
      ((Element)v.get(631)).appendChild((Element)v.get(632));
      /* Termina nodo:632   */
      /* Termina nodo:631   */

      /* Empieza nodo:633 / Elemento padre: 630   */
      v.add(doc.createElement("td"));
      ((Element)v.get(633)).setAttribute("width","750" );
      ((Element)v.get(630)).appendChild((Element)v.get(633));

      /* Empieza nodo:634 / Elemento padre: 633   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(634)).setAttribute("src","b.gif" );
      ((Element)v.get(633)).appendChild((Element)v.get(634));
      /* Termina nodo:634   */
      /* Termina nodo:633   */

      /* Empieza nodo:635 / Elemento padre: 630   */
      v.add(doc.createElement("td"));
      ((Element)v.get(635)).setAttribute("width","12" );
      ((Element)v.get(630)).appendChild((Element)v.get(635));

      /* Empieza nodo:636 / Elemento padre: 635   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(636)).setAttribute("src","b.gif" );
      ((Element)v.get(636)).setAttribute("width","12" );
      ((Element)v.get(636)).setAttribute("height","12" );
      ((Element)v.get(635)).appendChild((Element)v.get(636));
      /* Termina nodo:636   */
      /* Termina nodo:635   */
      /* Termina nodo:630   */
      /* Termina nodo:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:637 / Elemento padre: 4   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(637)).setAttribute("nombre","listado2" );
      ((Element)v.get(637)).setAttribute("ancho","711" );
      ((Element)v.get(637)).setAttribute("alto","277" );
      ((Element)v.get(637)).setAttribute("x","12" );
      ((Element)v.get(637)).setAttribute("y","367" );
      ((Element)v.get(637)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(637)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(4)).appendChild((Element)v.get(637));

      /* Empieza nodo:638 / Elemento padre: 637   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(638)).setAttribute("precarga","S" );
      ((Element)v.get(638)).setAttribute("conROver","S" );
      ((Element)v.get(637)).appendChild((Element)v.get(638));

      /* Empieza nodo:639 / Elemento padre: 638   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(639)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(639)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(639)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(639)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(638)).appendChild((Element)v.get(639));
      /* Termina nodo:639   */

      /* Empieza nodo:640 / Elemento padre: 638   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(640)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(640)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(640)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(640)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(638)).appendChild((Element)v.get(640));
      /* Termina nodo:640   */
      /* Termina nodo:638   */

      /* Empieza nodo:641 / Elemento padre: 637   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(637)).appendChild((Element)v.get(641));

      /* Empieza nodo:642 / Elemento padre: 641   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(642)).setAttribute("borde","1" );
      ((Element)v.get(642)).setAttribute("horizDatos","1" );
      ((Element)v.get(642)).setAttribute("horizCabecera","1" );
      ((Element)v.get(642)).setAttribute("vertical","1" );
      ((Element)v.get(642)).setAttribute("horizTitulo","1" );
      ((Element)v.get(642)).setAttribute("horizBase","1" );
      ((Element)v.get(641)).appendChild((Element)v.get(642));
      /* Termina nodo:642   */

      /* Empieza nodo:643 / Elemento padre: 641   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(643)).setAttribute("borde","#999999" );
      ((Element)v.get(643)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(643)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(643)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(643)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(643)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(643)).setAttribute("horizBase","#999999" );
      ((Element)v.get(641)).appendChild((Element)v.get(643));
      /* Termina nodo:643   */
      /* Termina nodo:641   */

      /* Empieza nodo:644 / Elemento padre: 637   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(644)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(644)).setAttribute("alto","22" );
      ((Element)v.get(644)).setAttribute("imgFondo","" );
      ((Element)v.get(644)).setAttribute("cod","0057" );
      ((Element)v.get(644)).setAttribute("ID","datosTitle" );
      ((Element)v.get(637)).appendChild((Element)v.get(644));
      /* Termina nodo:644   */

      /* Empieza nodo:645 / Elemento padre: 637   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(645)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(645)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(645)).setAttribute("blancosAInsertar","1" );
   }

   private void getXML2700(Document doc) {
      ((Element)v.get(645)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(645)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(637)).appendChild((Element)v.get(645));

      /* Empieza nodo:646 / Elemento padre: 645   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(646)).setAttribute("ancho","98" );
      ((Element)v.get(646)).setAttribute("minimizable","S" );
      ((Element)v.get(646)).setAttribute("minimizada","N" );
      ((Element)v.get(645)).appendChild((Element)v.get(646));
      /* Termina nodo:646   */

      /* Empieza nodo:647 / Elemento padre: 645   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(647)).setAttribute("ancho","68" );
      ((Element)v.get(647)).setAttribute("minimizable","S" );
      ((Element)v.get(647)).setAttribute("minimizada","N" );
      ((Element)v.get(645)).appendChild((Element)v.get(647));
      /* Termina nodo:647   */

      /* Empieza nodo:648 / Elemento padre: 645   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(648)).setAttribute("ancho","73" );
      ((Element)v.get(648)).setAttribute("minimizable","S" );
      ((Element)v.get(648)).setAttribute("minimizada","N" );
      ((Element)v.get(645)).appendChild((Element)v.get(648));
      /* Termina nodo:648   */

      /* Empieza nodo:649 / Elemento padre: 645   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(649)).setAttribute("ancho","73" );
      ((Element)v.get(649)).setAttribute("minimizable","S" );
      ((Element)v.get(649)).setAttribute("minimizada","N" );
      ((Element)v.get(645)).appendChild((Element)v.get(649));
      /* Termina nodo:649   */

      /* Empieza nodo:650 / Elemento padre: 645   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(650)).setAttribute("ancho","89" );
      ((Element)v.get(650)).setAttribute("minimizable","S" );
      ((Element)v.get(650)).setAttribute("minimizada","N" );
      ((Element)v.get(645)).appendChild((Element)v.get(650));
      /* Termina nodo:650   */
      /* Termina nodo:645   */

      /* Empieza nodo:651 / Elemento padre: 637   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(651)).setAttribute("alto","20" );
      ((Element)v.get(651)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(651)).setAttribute("imgFondo","" );
      ((Element)v.get(651)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(637)).appendChild((Element)v.get(651));

      /* Empieza nodo:652 / Elemento padre: 651   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(652)).setAttribute("colFondo","" );
      ((Element)v.get(652)).setAttribute("ID","EstCab" );
      ((Element)v.get(652)).setAttribute("align","center" );
      ((Element)v.get(652)).setAttribute("cod","1058" );
      ((Element)v.get(651)).appendChild((Element)v.get(652));
      /* Termina nodo:652   */

      /* Empieza nodo:653 / Elemento padre: 651   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(653)).setAttribute("colFondo","" );
      ((Element)v.get(653)).setAttribute("ID","EstCab" );
      ((Element)v.get(653)).setAttribute("align","center" );
      ((Element)v.get(653)).setAttribute("cod","1131" );
      ((Element)v.get(651)).appendChild((Element)v.get(653));
      /* Termina nodo:653   */

      /* Empieza nodo:654 / Elemento padre: 651   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(654)).setAttribute("colFondo","" );
      ((Element)v.get(654)).setAttribute("ID","EstCab" );
      ((Element)v.get(654)).setAttribute("align","center" );
      ((Element)v.get(654)).setAttribute("cod","59" );
      ((Element)v.get(651)).appendChild((Element)v.get(654));
      /* Termina nodo:654   */

      /* Empieza nodo:655 / Elemento padre: 651   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(655)).setAttribute("colFondo","" );
      ((Element)v.get(655)).setAttribute("ID","EstCab" );
      ((Element)v.get(655)).setAttribute("align","center" );
      ((Element)v.get(655)).setAttribute("cod","1339" );
      ((Element)v.get(651)).appendChild((Element)v.get(655));
      /* Termina nodo:655   */

      /* Empieza nodo:656 / Elemento padre: 651   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(656)).setAttribute("colFondo","" );
      ((Element)v.get(656)).setAttribute("ID","EstCab" );
      ((Element)v.get(656)).setAttribute("align","center" );
      ((Element)v.get(656)).setAttribute("cod","1139" );
      ((Element)v.get(651)).appendChild((Element)v.get(656));
      /* Termina nodo:656   */
      /* Termina nodo:651   */

      /* Empieza nodo:657 / Elemento padre: 637   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(657)).setAttribute("alto","22" );
      ((Element)v.get(657)).setAttribute("accion","" );
      ((Element)v.get(657)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(657)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(657)).setAttribute("maxSel","-1" );
      ((Element)v.get(657)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(657)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(657)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(657)).setAttribute("onLoad","" );
      ((Element)v.get(657)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(637)).appendChild((Element)v.get(657));

      /* Empieza nodo:658 / Elemento padre: 657   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(658)).setAttribute("tipo","texto" );
      ((Element)v.get(658)).setAttribute("ID","EstDat" );
      ((Element)v.get(657)).appendChild((Element)v.get(658));
      /* Termina nodo:658   */

      /* Empieza nodo:659 / Elemento padre: 657   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(659)).setAttribute("tipo","texto" );
      ((Element)v.get(659)).setAttribute("ID","EstDat2" );
      ((Element)v.get(657)).appendChild((Element)v.get(659));
      /* Termina nodo:659   */

      /* Empieza nodo:660 / Elemento padre: 657   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(660)).setAttribute("tipo","texto" );
      ((Element)v.get(660)).setAttribute("ID","EstDat" );
      ((Element)v.get(657)).appendChild((Element)v.get(660));
      /* Termina nodo:660   */

      /* Empieza nodo:661 / Elemento padre: 657   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(661)).setAttribute("tipo","texto" );
   }

   private void getXML2790(Document doc) {
      ((Element)v.get(661)).setAttribute("ID","EstDat2" );
      ((Element)v.get(657)).appendChild((Element)v.get(661));
      /* Termina nodo:661   */

      /* Empieza nodo:662 / Elemento padre: 657   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(662)).setAttribute("tipo","texto" );
      ((Element)v.get(662)).setAttribute("ID","EstDat" );
      ((Element)v.get(657)).appendChild((Element)v.get(662));
      /* Termina nodo:662   */
      /* Termina nodo:657   */

      /* Empieza nodo:663 / Elemento padre: 637   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(637)).appendChild((Element)v.get(663));
      /* Termina nodo:663   */

      /* Empieza nodo:664 / Elemento padre: 637   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(664)).setAttribute("nombre","mipgndo2" );
      ((Element)v.get(664)).setAttribute("ancho","711" );
      ((Element)v.get(664)).setAttribute("sep","$" );
      ((Element)v.get(664)).setAttribute("x","12" );
      ((Element)v.get(664)).setAttribute("class","botonera" );
      ((Element)v.get(664)).setAttribute("y","657" );
      ((Element)v.get(664)).setAttribute("control","|" );
      ((Element)v.get(664)).setAttribute("conector","conector_campos" );
      ((Element)v.get(664)).setAttribute("rowset","" );
      ((Element)v.get(664)).setAttribute("cargainicial","N" );
      ((Element)v.get(637)).appendChild((Element)v.get(664));

      /* Empieza nodo:665 / Elemento padre: 664   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(665)).setAttribute("nombre","ret2" );
      ((Element)v.get(665)).setAttribute("x","37" );
      ((Element)v.get(665)).setAttribute("y","657" );
      ((Element)v.get(665)).setAttribute("ID","botonContenido" );
      ((Element)v.get(665)).setAttribute("img","retroceder_on" );
      ((Element)v.get(665)).setAttribute("tipo","0" );
      ((Element)v.get(665)).setAttribute("estado","false" );
      ((Element)v.get(665)).setAttribute("alt","" );
      ((Element)v.get(665)).setAttribute("codigo","" );
      ((Element)v.get(665)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(664)).appendChild((Element)v.get(665));
      /* Termina nodo:665   */

      /* Empieza nodo:666 / Elemento padre: 664   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(666)).setAttribute("nombre","ava2" );
      ((Element)v.get(666)).setAttribute("x","52" );
      ((Element)v.get(666)).setAttribute("y","657" );
      ((Element)v.get(666)).setAttribute("ID","botonContenido" );
      ((Element)v.get(666)).setAttribute("img","avanzar_on" );
      ((Element)v.get(666)).setAttribute("tipo","0" );
      ((Element)v.get(666)).setAttribute("estado","false" );
      ((Element)v.get(666)).setAttribute("alt","" );
      ((Element)v.get(666)).setAttribute("codigo","" );
      ((Element)v.get(666)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(664)).appendChild((Element)v.get(666));
      /* Termina nodo:666   */
      /* Termina nodo:664   */
      /* Termina nodo:637   */

      /* Empieza nodo:667 / Elemento padre: 4   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(667)).setAttribute("nombre","primera2" );
      ((Element)v.get(667)).setAttribute("x","20" );
      ((Element)v.get(667)).setAttribute("y","657" );
      ((Element)v.get(667)).setAttribute("ID","botonContenido" );
      ((Element)v.get(667)).setAttribute("img","primera_on" );
      ((Element)v.get(667)).setAttribute("tipo","-2" );
      ((Element)v.get(667)).setAttribute("estado","false" );
      ((Element)v.get(667)).setAttribute("alt","" );
      ((Element)v.get(667)).setAttribute("codigo","" );
      ((Element)v.get(667)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(4)).appendChild((Element)v.get(667));
      /* Termina nodo:667   */

      /* Empieza nodo:668 / Elemento padre: 4   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(668)).setAttribute("nombre","listado3" );
      ((Element)v.get(668)).setAttribute("ancho","711" );
      ((Element)v.get(668)).setAttribute("alto","277" );
      ((Element)v.get(668)).setAttribute("x","12" );
      ((Element)v.get(668)).setAttribute("y","669" );
      ((Element)v.get(668)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(668)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(4)).appendChild((Element)v.get(668));

      /* Empieza nodo:669 / Elemento padre: 668   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(669)).setAttribute("precarga","S" );
      ((Element)v.get(669)).setAttribute("conROver","S" );
      ((Element)v.get(668)).appendChild((Element)v.get(669));

      /* Empieza nodo:670 / Elemento padre: 669   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(670)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(670)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(670)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(670)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(669)).appendChild((Element)v.get(670));
      /* Termina nodo:670   */

      /* Empieza nodo:671 / Elemento padre: 669   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(671)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(671)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(671)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(671)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(669)).appendChild((Element)v.get(671));
      /* Termina nodo:671   */
      /* Termina nodo:669   */

      /* Empieza nodo:672 / Elemento padre: 668   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(668)).appendChild((Element)v.get(672));

      /* Empieza nodo:673 / Elemento padre: 672   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(673)).setAttribute("borde","1" );
      ((Element)v.get(673)).setAttribute("horizDatos","1" );
      ((Element)v.get(673)).setAttribute("horizCabecera","1" );
      ((Element)v.get(673)).setAttribute("vertical","1" );
      ((Element)v.get(673)).setAttribute("horizTitulo","1" );
      ((Element)v.get(673)).setAttribute("horizBase","1" );
   }

   private void getXML2880(Document doc) {
      ((Element)v.get(672)).appendChild((Element)v.get(673));
      /* Termina nodo:673   */

      /* Empieza nodo:674 / Elemento padre: 672   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(674)).setAttribute("borde","#999999" );
      ((Element)v.get(674)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(674)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(674)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(674)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(674)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(674)).setAttribute("horizBase","#999999" );
      ((Element)v.get(672)).appendChild((Element)v.get(674));
      /* Termina nodo:674   */
      /* Termina nodo:672   */

      /* Empieza nodo:675 / Elemento padre: 668   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(675)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(675)).setAttribute("alto","22" );
      ((Element)v.get(675)).setAttribute("imgFondo","" );
      ((Element)v.get(675)).setAttribute("cod","0055" );
      ((Element)v.get(675)).setAttribute("ID","datosTitle" );
      ((Element)v.get(668)).appendChild((Element)v.get(675));
      /* Termina nodo:675   */

      /* Empieza nodo:676 / Elemento padre: 668   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(676)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(676)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(676)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(676)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(676)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(668)).appendChild((Element)v.get(676));

      /* Empieza nodo:677 / Elemento padre: 676   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(677)).setAttribute("ancho","105" );
      ((Element)v.get(677)).setAttribute("minimizable","S" );
      ((Element)v.get(677)).setAttribute("minimizada","N" );
      ((Element)v.get(676)).appendChild((Element)v.get(677));
      /* Termina nodo:677   */

      /* Empieza nodo:678 / Elemento padre: 676   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(678)).setAttribute("ancho","400" );
      ((Element)v.get(678)).setAttribute("minimizable","S" );
      ((Element)v.get(678)).setAttribute("minimizada","N" );
      ((Element)v.get(676)).appendChild((Element)v.get(678));
      /* Termina nodo:678   */
      /* Termina nodo:676   */

      /* Empieza nodo:679 / Elemento padre: 668   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(679)).setAttribute("alto","20" );
      ((Element)v.get(679)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(679)).setAttribute("imgFondo","" );
      ((Element)v.get(679)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(668)).appendChild((Element)v.get(679));

      /* Empieza nodo:680 / Elemento padre: 679   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(680)).setAttribute("colFondo","" );
      ((Element)v.get(680)).setAttribute("ID","EstCab" );
      ((Element)v.get(680)).setAttribute("align","center" );
      ((Element)v.get(680)).setAttribute("cod","1127" );
      ((Element)v.get(679)).appendChild((Element)v.get(680));
      /* Termina nodo:680   */

      /* Empieza nodo:681 / Elemento padre: 679   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(681)).setAttribute("colFondo","" );
      ((Element)v.get(681)).setAttribute("ID","EstCab" );
      ((Element)v.get(681)).setAttribute("align","center" );
      ((Element)v.get(681)).setAttribute("cod","9" );
      ((Element)v.get(679)).appendChild((Element)v.get(681));
      /* Termina nodo:681   */
      /* Termina nodo:679   */

      /* Empieza nodo:682 / Elemento padre: 668   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(682)).setAttribute("alto","22" );
      ((Element)v.get(682)).setAttribute("accion","" );
      ((Element)v.get(682)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(682)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(682)).setAttribute("maxSel","-1" );
      ((Element)v.get(682)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(682)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(682)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(682)).setAttribute("onLoad","" );
      ((Element)v.get(682)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(668)).appendChild((Element)v.get(682));

      /* Empieza nodo:683 / Elemento padre: 682   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(683)).setAttribute("tipo","texto" );
      ((Element)v.get(683)).setAttribute("ID","EstDat" );
      ((Element)v.get(682)).appendChild((Element)v.get(683));
      /* Termina nodo:683   */

      /* Empieza nodo:684 / Elemento padre: 682   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(684)).setAttribute("tipo","texto" );
      ((Element)v.get(684)).setAttribute("ID","EstDat2" );
      ((Element)v.get(682)).appendChild((Element)v.get(684));
      /* Termina nodo:684   */
      /* Termina nodo:682   */

      /* Empieza nodo:685 / Elemento padre: 668   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(668)).appendChild((Element)v.get(685));
      /* Termina nodo:685   */

      /* Empieza nodo:686 / Elemento padre: 668   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(686)).setAttribute("nombre","mipgndo3" );
      ((Element)v.get(686)).setAttribute("ancho","711" );
      ((Element)v.get(686)).setAttribute("sep","$" );
      ((Element)v.get(686)).setAttribute("x","12" );
      ((Element)v.get(686)).setAttribute("class","botonera" );
      ((Element)v.get(686)).setAttribute("y","980" );
      ((Element)v.get(686)).setAttribute("control","|" );
      ((Element)v.get(686)).setAttribute("conector","conector_campos" );
      ((Element)v.get(686)).setAttribute("rowset","" );
      ((Element)v.get(686)).setAttribute("cargainicial","N" );
      ((Element)v.get(668)).appendChild((Element)v.get(686));

      /* Empieza nodo:687 / Elemento padre: 686   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(687)).setAttribute("nombre","ret3" );
      ((Element)v.get(687)).setAttribute("x","42" );
      ((Element)v.get(687)).setAttribute("y","980" );
   }

   private void getXML2970(Document doc) {
      ((Element)v.get(687)).setAttribute("ID","botonContenido" );
      ((Element)v.get(687)).setAttribute("img","retroceder_on" );
      ((Element)v.get(687)).setAttribute("tipo","0" );
      ((Element)v.get(687)).setAttribute("estado","false" );
      ((Element)v.get(687)).setAttribute("alt","" );
      ((Element)v.get(687)).setAttribute("codigo","" );
      ((Element)v.get(687)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(686)).appendChild((Element)v.get(687));
      /* Termina nodo:687   */

      /* Empieza nodo:688 / Elemento padre: 686   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(688)).setAttribute("nombre","ava3" );
      ((Element)v.get(688)).setAttribute("x","57" );
      ((Element)v.get(688)).setAttribute("y","980" );
      ((Element)v.get(688)).setAttribute("ID","botonContenido" );
      ((Element)v.get(688)).setAttribute("img","avanzar_on" );
      ((Element)v.get(688)).setAttribute("tipo","0" );
      ((Element)v.get(688)).setAttribute("estado","false" );
      ((Element)v.get(688)).setAttribute("alt","" );
      ((Element)v.get(688)).setAttribute("codigo","" );
      ((Element)v.get(688)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(686)).appendChild((Element)v.get(688));
      /* Termina nodo:688   */
      /* Termina nodo:686   */
      /* Termina nodo:668   */

      /* Empieza nodo:689 / Elemento padre: 4   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(689)).setAttribute("nombre","primera3" );
      ((Element)v.get(689)).setAttribute("x","25" );
      ((Element)v.get(689)).setAttribute("y","980" );
      ((Element)v.get(689)).setAttribute("ID","botonContenido" );
      ((Element)v.get(689)).setAttribute("img","primera_on" );
      ((Element)v.get(689)).setAttribute("tipo","-2" );
      ((Element)v.get(689)).setAttribute("estado","false" );
      ((Element)v.get(689)).setAttribute("alt","" );
      ((Element)v.get(689)).setAttribute("codigo","" );
      ((Element)v.get(689)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(4)).appendChild((Element)v.get(689));
      /* Termina nodo:689   */

      /* Empieza nodo:690 / Elemento padre: 4   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(690)).setAttribute("nombre","listado4" );
      ((Element)v.get(690)).setAttribute("ancho","711" );
      ((Element)v.get(690)).setAttribute("alto","317" );
      ((Element)v.get(690)).setAttribute("x","12" );
      ((Element)v.get(690)).setAttribute("y","971" );
      ((Element)v.get(690)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(690)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(4)).appendChild((Element)v.get(690));

      /* Empieza nodo:691 / Elemento padre: 690   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(691)).setAttribute("precarga","S" );
      ((Element)v.get(691)).setAttribute("conROver","S" );
      ((Element)v.get(690)).appendChild((Element)v.get(691));

      /* Empieza nodo:692 / Elemento padre: 691   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(692)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(692)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(692)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(692)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(691)).appendChild((Element)v.get(692));
      /* Termina nodo:692   */

      /* Empieza nodo:693 / Elemento padre: 691   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(693)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(693)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(693)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(693)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(691)).appendChild((Element)v.get(693));
      /* Termina nodo:693   */
      /* Termina nodo:691   */

      /* Empieza nodo:694 / Elemento padre: 690   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(690)).appendChild((Element)v.get(694));

      /* Empieza nodo:695 / Elemento padre: 694   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(695)).setAttribute("borde","1" );
      ((Element)v.get(695)).setAttribute("horizDatos","1" );
      ((Element)v.get(695)).setAttribute("horizCabecera","1" );
      ((Element)v.get(695)).setAttribute("vertical","1" );
      ((Element)v.get(695)).setAttribute("horizTitulo","1" );
      ((Element)v.get(695)).setAttribute("horizBase","1" );
      ((Element)v.get(694)).appendChild((Element)v.get(695));
      /* Termina nodo:695   */

      /* Empieza nodo:696 / Elemento padre: 694   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(696)).setAttribute("borde","#999999" );
      ((Element)v.get(696)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(696)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(696)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(696)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(696)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(696)).setAttribute("horizBase","#999999" );
      ((Element)v.get(694)).appendChild((Element)v.get(696));
      /* Termina nodo:696   */
      /* Termina nodo:694   */

      /* Empieza nodo:697 / Elemento padre: 690   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(697)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(697)).setAttribute("alto","22" );
      ((Element)v.get(697)).setAttribute("imgFondo","" );
      ((Element)v.get(697)).setAttribute("cod","0054" );
      ((Element)v.get(697)).setAttribute("ID","datosTitle" );
      ((Element)v.get(690)).appendChild((Element)v.get(697));
      /* Termina nodo:697   */

      /* Empieza nodo:698 / Elemento padre: 690   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(698)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(698)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(698)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(698)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(698)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(690)).appendChild((Element)v.get(698));

      /* Empieza nodo:699 / Elemento padre: 698   */
   }

   private void getXML3060(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(699)).setAttribute("ancho","212" );
      ((Element)v.get(699)).setAttribute("minimizable","S" );
      ((Element)v.get(699)).setAttribute("minimizada","N" );
      ((Element)v.get(698)).appendChild((Element)v.get(699));
      /* Termina nodo:699   */

      /* Empieza nodo:700 / Elemento padre: 698   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(700)).setAttribute("ancho","92" );
      ((Element)v.get(700)).setAttribute("minimizable","S" );
      ((Element)v.get(700)).setAttribute("minimizada","N" );
      ((Element)v.get(698)).appendChild((Element)v.get(700));
      /* Termina nodo:700   */

      /* Empieza nodo:701 / Elemento padre: 698   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(701)).setAttribute("ancho","402" );
      ((Element)v.get(701)).setAttribute("minimizable","S" );
      ((Element)v.get(701)).setAttribute("minimizada","N" );
      ((Element)v.get(698)).appendChild((Element)v.get(701));
      /* Termina nodo:701   */
      /* Termina nodo:698   */

      /* Empieza nodo:702 / Elemento padre: 690   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(702)).setAttribute("alto","20" );
      ((Element)v.get(702)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(702)).setAttribute("imgFondo","" );
      ((Element)v.get(702)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(690)).appendChild((Element)v.get(702));

      /* Empieza nodo:703 / Elemento padre: 702   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(703)).setAttribute("colFondo","" );
      ((Element)v.get(703)).setAttribute("ID","EstCab" );
      ((Element)v.get(703)).setAttribute("align","center" );
      ((Element)v.get(703)).setAttribute("cod","6" );
      ((Element)v.get(702)).appendChild((Element)v.get(703));
      /* Termina nodo:703   */

      /* Empieza nodo:704 / Elemento padre: 702   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(704)).setAttribute("colFondo","" );
      ((Element)v.get(704)).setAttribute("ID","EstCab" );
      ((Element)v.get(704)).setAttribute("align","center" );
      ((Element)v.get(704)).setAttribute("cod","1340" );
      ((Element)v.get(702)).appendChild((Element)v.get(704));
      /* Termina nodo:704   */

      /* Empieza nodo:705 / Elemento padre: 702   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(705)).setAttribute("colFondo","" );
      ((Element)v.get(705)).setAttribute("ID","EstCab" );
      ((Element)v.get(705)).setAttribute("align","center" );
      ((Element)v.get(705)).setAttribute("cod","487" );
      ((Element)v.get(702)).appendChild((Element)v.get(705));
      /* Termina nodo:705   */
      /* Termina nodo:702   */

      /* Empieza nodo:706 / Elemento padre: 690   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(706)).setAttribute("alto","22" );
      ((Element)v.get(706)).setAttribute("accion","" );
      ((Element)v.get(706)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(706)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(706)).setAttribute("maxSel","-1" );
      ((Element)v.get(706)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(706)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(706)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(706)).setAttribute("onLoad","" );
      ((Element)v.get(706)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(690)).appendChild((Element)v.get(706));

      /* Empieza nodo:707 / Elemento padre: 706   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(707)).setAttribute("tipo","texto" );
      ((Element)v.get(707)).setAttribute("ID","EstDat" );
      ((Element)v.get(706)).appendChild((Element)v.get(707));
      /* Termina nodo:707   */

      /* Empieza nodo:708 / Elemento padre: 706   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(708)).setAttribute("tipo","texto" );
      ((Element)v.get(708)).setAttribute("ID","EstDat2" );
      ((Element)v.get(706)).appendChild((Element)v.get(708));
      /* Termina nodo:708   */

      /* Empieza nodo:709 / Elemento padre: 706   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(709)).setAttribute("tipo","texto" );
      ((Element)v.get(709)).setAttribute("ID","EstDat" );
      ((Element)v.get(706)).appendChild((Element)v.get(709));
      /* Termina nodo:709   */
      /* Termina nodo:706   */

      /* Empieza nodo:710 / Elemento padre: 690   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(690)).appendChild((Element)v.get(710));
      /* Termina nodo:710   */

      /* Empieza nodo:711 / Elemento padre: 690   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(711)).setAttribute("nombre","mipgndo4" );
      ((Element)v.get(711)).setAttribute("ancho","711" );
      ((Element)v.get(711)).setAttribute("sep","$" );
      ((Element)v.get(711)).setAttribute("x","12" );
      ((Element)v.get(711)).setAttribute("class","botonera" );
      ((Element)v.get(711)).setAttribute("y","1303" );
      ((Element)v.get(711)).setAttribute("control","|" );
      ((Element)v.get(711)).setAttribute("conector","conector_campos" );
      ((Element)v.get(711)).setAttribute("rowset","" );
      ((Element)v.get(711)).setAttribute("cargainicial","N" );
      ((Element)v.get(690)).appendChild((Element)v.get(711));

      /* Empieza nodo:712 / Elemento padre: 711   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(712)).setAttribute("nombre","ret4" );
      ((Element)v.get(712)).setAttribute("x","42" );
      ((Element)v.get(712)).setAttribute("y","1303" );
      ((Element)v.get(712)).setAttribute("ID","botonContenido" );
      ((Element)v.get(712)).setAttribute("img","retroceder_on" );
      ((Element)v.get(712)).setAttribute("tipo","0" );
      ((Element)v.get(712)).setAttribute("estado","false" );
      ((Element)v.get(712)).setAttribute("alt","" );
      ((Element)v.get(712)).setAttribute("codigo","" );
      ((Element)v.get(712)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(711)).appendChild((Element)v.get(712));
      /* Termina nodo:712   */

      /* Empieza nodo:713 / Elemento padre: 711   */
      v.add(doc.createElement("BOTON"));
   }

   private void getXML3150(Document doc) {
      ((Element)v.get(713)).setAttribute("nombre","ava4" );
      ((Element)v.get(713)).setAttribute("x","57" );
      ((Element)v.get(713)).setAttribute("y","1303" );
      ((Element)v.get(713)).setAttribute("ID","botonContenido" );
      ((Element)v.get(713)).setAttribute("img","avanzar_on" );
      ((Element)v.get(713)).setAttribute("tipo","0" );
      ((Element)v.get(713)).setAttribute("estado","false" );
      ((Element)v.get(713)).setAttribute("alt","" );
      ((Element)v.get(713)).setAttribute("codigo","" );
      ((Element)v.get(713)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(711)).appendChild((Element)v.get(713));
      /* Termina nodo:713   */
      /* Termina nodo:711   */
      /* Termina nodo:690   */

      /* Empieza nodo:714 / Elemento padre: 4   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(714)).setAttribute("nombre","primera4" );
      ((Element)v.get(714)).setAttribute("x","25" );
      ((Element)v.get(714)).setAttribute("y","1303" );
      ((Element)v.get(714)).setAttribute("ID","botonContenido" );
      ((Element)v.get(714)).setAttribute("img","primera_on" );
      ((Element)v.get(714)).setAttribute("tipo","-2" );
      ((Element)v.get(714)).setAttribute("estado","false" );
      ((Element)v.get(714)).setAttribute("alt","" );
      ((Element)v.get(714)).setAttribute("codigo","" );
      ((Element)v.get(714)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(4)).appendChild((Element)v.get(714));
      /* Termina nodo:714   */

      /* Empieza nodo:715 / Elemento padre: 4   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(715)).setAttribute("nombre","listado5" );
      ((Element)v.get(715)).setAttribute("ancho","711" );
      ((Element)v.get(715)).setAttribute("alto","293" );
      ((Element)v.get(715)).setAttribute("x","12" );
      ((Element)v.get(715)).setAttribute("y","12" );
      ((Element)v.get(715)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(715)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(4)).appendChild((Element)v.get(715));

      /* Empieza nodo:716 / Elemento padre: 715   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(716)).setAttribute("precarga","S" );
      ((Element)v.get(716)).setAttribute("conROver","S" );
      ((Element)v.get(715)).appendChild((Element)v.get(716));

      /* Empieza nodo:717 / Elemento padre: 716   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(717)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(717)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(717)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(717)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(716)).appendChild((Element)v.get(717));
      /* Termina nodo:717   */

      /* Empieza nodo:718 / Elemento padre: 716   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(718)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(718)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(718)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(718)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(716)).appendChild((Element)v.get(718));
      /* Termina nodo:718   */
      /* Termina nodo:716   */

      /* Empieza nodo:719 / Elemento padre: 715   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(715)).appendChild((Element)v.get(719));

      /* Empieza nodo:720 / Elemento padre: 719   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(720)).setAttribute("borde","1" );
      ((Element)v.get(720)).setAttribute("horizDatos","1" );
      ((Element)v.get(720)).setAttribute("horizCabecera","1" );
      ((Element)v.get(720)).setAttribute("vertical","1" );
      ((Element)v.get(720)).setAttribute("horizTitulo","1" );
      ((Element)v.get(720)).setAttribute("horizBase","1" );
      ((Element)v.get(719)).appendChild((Element)v.get(720));
      /* Termina nodo:720   */

      /* Empieza nodo:721 / Elemento padre: 719   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(721)).setAttribute("borde","#999999" );
      ((Element)v.get(721)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(721)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(721)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(721)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(721)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(721)).setAttribute("horizBase","#999999" );
      ((Element)v.get(719)).appendChild((Element)v.get(721));
      /* Termina nodo:721   */
      /* Termina nodo:719   */

      /* Empieza nodo:722 / Elemento padre: 715   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(722)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(722)).setAttribute("alto","22" );
      ((Element)v.get(722)).setAttribute("imgFondo","" );
      ((Element)v.get(722)).setAttribute("cod","00143" );
      ((Element)v.get(722)).setAttribute("ID","datosTitle" );
      ((Element)v.get(715)).appendChild((Element)v.get(722));
      /* Termina nodo:722   */

      /* Empieza nodo:723 / Elemento padre: 715   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(723)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(723)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(723)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(723)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(723)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(715)).appendChild((Element)v.get(723));

      /* Empieza nodo:724 / Elemento padre: 723   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(724)).setAttribute("ancho","90" );
      ((Element)v.get(724)).setAttribute("minimizable","S" );
      ((Element)v.get(724)).setAttribute("minimizada","N" );
      ((Element)v.get(723)).appendChild((Element)v.get(724));
      /* Termina nodo:724   */

      /* Empieza nodo:725 / Elemento padre: 723   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(725)).setAttribute("ancho","90" );
      ((Element)v.get(725)).setAttribute("minimizable","S" );
      ((Element)v.get(725)).setAttribute("minimizada","N" );
   }

   private void getXML3240(Document doc) {
      ((Element)v.get(723)).appendChild((Element)v.get(725));
      /* Termina nodo:725   */

      /* Empieza nodo:726 / Elemento padre: 723   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(726)).setAttribute("ancho","61" );
      ((Element)v.get(726)).setAttribute("minimizable","S" );
      ((Element)v.get(726)).setAttribute("minimizada","N" );
      ((Element)v.get(723)).appendChild((Element)v.get(726));
      /* Termina nodo:726   */

      /* Empieza nodo:727 / Elemento padre: 723   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(727)).setAttribute("ancho","215" );
      ((Element)v.get(727)).setAttribute("minimizable","S" );
      ((Element)v.get(727)).setAttribute("minimizada","N" );
      ((Element)v.get(723)).appendChild((Element)v.get(727));
      /* Termina nodo:727   */

      /* Empieza nodo:728 / Elemento padre: 723   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(728)).setAttribute("ancho","73" );
      ((Element)v.get(728)).setAttribute("minimizable","S" );
      ((Element)v.get(728)).setAttribute("minimizada","N" );
      ((Element)v.get(723)).appendChild((Element)v.get(728));
      /* Termina nodo:728   */

      /* Empieza nodo:729 / Elemento padre: 723   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(729)).setAttribute("ancho","72" );
      ((Element)v.get(729)).setAttribute("minimizable","S" );
      ((Element)v.get(729)).setAttribute("minimizada","N" );
      ((Element)v.get(723)).appendChild((Element)v.get(729));
      /* Termina nodo:729   */

      /* Empieza nodo:730 / Elemento padre: 723   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(730)).setAttribute("ancho","315" );
      ((Element)v.get(730)).setAttribute("minimizable","S" );
      ((Element)v.get(730)).setAttribute("minimizada","N" );
      ((Element)v.get(723)).appendChild((Element)v.get(730));
      /* Termina nodo:730   */

      /* Empieza nodo:731 / Elemento padre: 723   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(731)).setAttribute("ancho","115" );
      ((Element)v.get(731)).setAttribute("minimizable","S" );
      ((Element)v.get(731)).setAttribute("minimizada","N" );
      ((Element)v.get(723)).appendChild((Element)v.get(731));
      /* Termina nodo:731   */
      /* Termina nodo:723   */

      /* Empieza nodo:732 / Elemento padre: 715   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(732)).setAttribute("alto","20" );
      ((Element)v.get(732)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(732)).setAttribute("imgFondo","" );
      ((Element)v.get(732)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(715)).appendChild((Element)v.get(732));

      /* Empieza nodo:733 / Elemento padre: 732   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(733)).setAttribute("colFondo","" );
      ((Element)v.get(733)).setAttribute("ID","EstCab" );
      ((Element)v.get(733)).setAttribute("align","center" );
      ((Element)v.get(733)).setAttribute("cod","227" );
      ((Element)v.get(732)).appendChild((Element)v.get(733));
      /* Termina nodo:733   */

      /* Empieza nodo:734 / Elemento padre: 732   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(734)).setAttribute("colFondo","" );
      ((Element)v.get(734)).setAttribute("ID","EstCab" );
      ((Element)v.get(734)).setAttribute("align","center" );
      ((Element)v.get(734)).setAttribute("cod","159" );
      ((Element)v.get(732)).appendChild((Element)v.get(734));
      /* Termina nodo:734   */

      /* Empieza nodo:735 / Elemento padre: 732   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(735)).setAttribute("colFondo","" );
      ((Element)v.get(735)).setAttribute("ID","EstCab" );
      ((Element)v.get(735)).setAttribute("align","center" );
      ((Element)v.get(735)).setAttribute("cod","215" );
      ((Element)v.get(732)).appendChild((Element)v.get(735));
      /* Termina nodo:735   */

      /* Empieza nodo:736 / Elemento padre: 732   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(736)).setAttribute("colFondo","" );
      ((Element)v.get(736)).setAttribute("ID","EstCab" );
      ((Element)v.get(736)).setAttribute("align","center" );
      ((Element)v.get(736)).setAttribute("cod","216" );
      ((Element)v.get(732)).appendChild((Element)v.get(736));
      /* Termina nodo:736   */

      /* Empieza nodo:737 / Elemento padre: 732   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(737)).setAttribute("colFondo","" );
      ((Element)v.get(737)).setAttribute("ID","EstCab" );
      ((Element)v.get(737)).setAttribute("align","center" );
      ((Element)v.get(737)).setAttribute("cod","939" );
      ((Element)v.get(732)).appendChild((Element)v.get(737));
      /* Termina nodo:737   */

      /* Empieza nodo:738 / Elemento padre: 732   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(738)).setAttribute("colFondo","" );
      ((Element)v.get(738)).setAttribute("ID","EstCab" );
      ((Element)v.get(738)).setAttribute("align","center" );
      ((Element)v.get(738)).setAttribute("cod","1344" );
      ((Element)v.get(732)).appendChild((Element)v.get(738));
      /* Termina nodo:738   */

      /* Empieza nodo:739 / Elemento padre: 732   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(739)).setAttribute("colFondo","" );
      ((Element)v.get(739)).setAttribute("ID","EstCab" );
      ((Element)v.get(739)).setAttribute("align","center" );
      ((Element)v.get(739)).setAttribute("cod","169" );
      ((Element)v.get(732)).appendChild((Element)v.get(739));
      /* Termina nodo:739   */

      /* Empieza nodo:740 / Elemento padre: 732   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(740)).setAttribute("colFondo","" );
      ((Element)v.get(740)).setAttribute("ID","EstCab" );
      ((Element)v.get(740)).setAttribute("align","center" );
      ((Element)v.get(740)).setAttribute("cod","1349" );
      ((Element)v.get(732)).appendChild((Element)v.get(740));
      /* Termina nodo:740   */
      /* Termina nodo:732   */

      /* Empieza nodo:741 / Elemento padre: 715   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(741)).setAttribute("alto","22" );
      ((Element)v.get(741)).setAttribute("accion","" );
      ((Element)v.get(741)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(741)).setAttribute("formaEnvio","xml" );
   }

   private void getXML3330(Document doc) {
      ((Element)v.get(741)).setAttribute("maxSel","-1" );
      ((Element)v.get(741)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(741)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(741)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(741)).setAttribute("onLoad","" );
      ((Element)v.get(741)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(715)).appendChild((Element)v.get(741));

      /* Empieza nodo:742 / Elemento padre: 741   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(742)).setAttribute("tipo","texto" );
      ((Element)v.get(742)).setAttribute("ID","EstDat2" );
      ((Element)v.get(741)).appendChild((Element)v.get(742));
      /* Termina nodo:742   */

      /* Empieza nodo:743 / Elemento padre: 741   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(743)).setAttribute("tipo","texto" );
      ((Element)v.get(743)).setAttribute("ID","EstDat" );
      ((Element)v.get(741)).appendChild((Element)v.get(743));
      /* Termina nodo:743   */

      /* Empieza nodo:744 / Elemento padre: 741   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(744)).setAttribute("tipo","texto" );
      ((Element)v.get(744)).setAttribute("ID","EstDat2" );
      ((Element)v.get(741)).appendChild((Element)v.get(744));
      /* Termina nodo:744   */

      /* Empieza nodo:745 / Elemento padre: 741   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(745)).setAttribute("tipo","texto" );
      ((Element)v.get(745)).setAttribute("ID","EstDat" );
      ((Element)v.get(741)).appendChild((Element)v.get(745));
      /* Termina nodo:745   */

      /* Empieza nodo:746 / Elemento padre: 741   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(746)).setAttribute("tipo","texto" );
      ((Element)v.get(746)).setAttribute("ID","EstDat2" );
      ((Element)v.get(741)).appendChild((Element)v.get(746));
      /* Termina nodo:746   */

      /* Empieza nodo:747 / Elemento padre: 741   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(747)).setAttribute("tipo","texto" );
      ((Element)v.get(747)).setAttribute("ID","EstDat" );
      ((Element)v.get(741)).appendChild((Element)v.get(747));
      /* Termina nodo:747   */

      /* Empieza nodo:748 / Elemento padre: 741   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(748)).setAttribute("tipo","texto" );
      ((Element)v.get(748)).setAttribute("ID","EstDat2" );
      ((Element)v.get(741)).appendChild((Element)v.get(748));
      /* Termina nodo:748   */

      /* Empieza nodo:749 / Elemento padre: 741   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(749)).setAttribute("tipo","texto" );
      ((Element)v.get(749)).setAttribute("ID","EstDat" );
      ((Element)v.get(741)).appendChild((Element)v.get(749));
      /* Termina nodo:749   */
      /* Termina nodo:741   */

      /* Empieza nodo:750 / Elemento padre: 715   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(715)).appendChild((Element)v.get(750));
      /* Termina nodo:750   */

      /* Empieza nodo:751 / Elemento padre: 715   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(751)).setAttribute("nombre","mipgndo5" );
      ((Element)v.get(751)).setAttribute("ancho","711" );
      ((Element)v.get(751)).setAttribute("sep","$" );
      ((Element)v.get(751)).setAttribute("x","12" );
      ((Element)v.get(751)).setAttribute("class","botonera" );
      ((Element)v.get(751)).setAttribute("y","293" );
      ((Element)v.get(751)).setAttribute("control","|" );
      ((Element)v.get(751)).setAttribute("conector","conector_campos" );
      ((Element)v.get(751)).setAttribute("rowset","" );
      ((Element)v.get(751)).setAttribute("cargainicial","N" );
      ((Element)v.get(715)).appendChild((Element)v.get(751));

      /* Empieza nodo:752 / Elemento padre: 751   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(752)).setAttribute("nombre","ret5" );
      ((Element)v.get(752)).setAttribute("x","42" );
      ((Element)v.get(752)).setAttribute("y","293" );
      ((Element)v.get(752)).setAttribute("ID","botonContenido" );
      ((Element)v.get(752)).setAttribute("img","retroceder_on" );
      ((Element)v.get(752)).setAttribute("tipo","0" );
      ((Element)v.get(752)).setAttribute("estado","false" );
      ((Element)v.get(752)).setAttribute("alt","" );
      ((Element)v.get(752)).setAttribute("codigo","" );
      ((Element)v.get(752)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(751)).appendChild((Element)v.get(752));
      /* Termina nodo:752   */

      /* Empieza nodo:753 / Elemento padre: 751   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(753)).setAttribute("nombre","ava5" );
      ((Element)v.get(753)).setAttribute("x","57" );
      ((Element)v.get(753)).setAttribute("y","293" );
      ((Element)v.get(753)).setAttribute("ID","botonContenido" );
      ((Element)v.get(753)).setAttribute("img","avanzar_on" );
      ((Element)v.get(753)).setAttribute("tipo","0" );
      ((Element)v.get(753)).setAttribute("estado","false" );
      ((Element)v.get(753)).setAttribute("alt","" );
      ((Element)v.get(753)).setAttribute("codigo","" );
      ((Element)v.get(753)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(751)).appendChild((Element)v.get(753));
      /* Termina nodo:753   */
      /* Termina nodo:751   */
      /* Termina nodo:715   */

      /* Empieza nodo:754 / Elemento padre: 4   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(754)).setAttribute("nombre","primera5" );
      ((Element)v.get(754)).setAttribute("x","25" );
      ((Element)v.get(754)).setAttribute("y","293" );
      ((Element)v.get(754)).setAttribute("ID","botonContenido" );
      ((Element)v.get(754)).setAttribute("img","primera_on" );
      ((Element)v.get(754)).setAttribute("tipo","-2" );
      ((Element)v.get(754)).setAttribute("estado","false" );
      ((Element)v.get(754)).setAttribute("alt","" );
      ((Element)v.get(754)).setAttribute("codigo","" );
      ((Element)v.get(754)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(4)).appendChild((Element)v.get(754));
      /* Termina nodo:754   */

      /* Empieza nodo:755 / Elemento padre: 4   */
      v.add(doc.createElement("LISTAEDITABLE"));
   }

   private void getXML3420(Document doc) {
      ((Element)v.get(755)).setAttribute("nombre","listado6" );
      ((Element)v.get(755)).setAttribute("ancho","711" );
      ((Element)v.get(755)).setAttribute("alto","293" );
      ((Element)v.get(755)).setAttribute("x","12" );
      ((Element)v.get(755)).setAttribute("y","330" );
      ((Element)v.get(755)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(755)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(4)).appendChild((Element)v.get(755));

      /* Empieza nodo:756 / Elemento padre: 755   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(756)).setAttribute("precarga","S" );
      ((Element)v.get(756)).setAttribute("conROver","S" );
      ((Element)v.get(755)).appendChild((Element)v.get(756));

      /* Empieza nodo:757 / Elemento padre: 756   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(757)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(757)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(757)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(757)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(756)).appendChild((Element)v.get(757));
      /* Termina nodo:757   */

      /* Empieza nodo:758 / Elemento padre: 756   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(758)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(758)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(758)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(758)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(756)).appendChild((Element)v.get(758));
      /* Termina nodo:758   */
      /* Termina nodo:756   */

      /* Empieza nodo:759 / Elemento padre: 755   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(755)).appendChild((Element)v.get(759));

      /* Empieza nodo:760 / Elemento padre: 759   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(760)).setAttribute("borde","1" );
      ((Element)v.get(760)).setAttribute("horizDatos","1" );
      ((Element)v.get(760)).setAttribute("horizCabecera","1" );
      ((Element)v.get(760)).setAttribute("vertical","1" );
      ((Element)v.get(760)).setAttribute("horizTitulo","1" );
      ((Element)v.get(760)).setAttribute("horizBase","1" );
      ((Element)v.get(759)).appendChild((Element)v.get(760));
      /* Termina nodo:760   */

      /* Empieza nodo:761 / Elemento padre: 759   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(761)).setAttribute("borde","#999999" );
      ((Element)v.get(761)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(761)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(761)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(761)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(761)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(761)).setAttribute("horizBase","#999999" );
      ((Element)v.get(759)).appendChild((Element)v.get(761));
      /* Termina nodo:761   */
      /* Termina nodo:759   */

      /* Empieza nodo:762 / Elemento padre: 755   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(762)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(762)).setAttribute("alto","22" );
      ((Element)v.get(762)).setAttribute("imgFondo","" );
      ((Element)v.get(762)).setAttribute("cod","00144" );
      ((Element)v.get(762)).setAttribute("ID","datosTitle" );
      ((Element)v.get(755)).appendChild((Element)v.get(762));
      /* Termina nodo:762   */

      /* Empieza nodo:763 / Elemento padre: 755   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(763)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(763)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(763)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(763)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(763)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(755)).appendChild((Element)v.get(763));

      /* Empieza nodo:764 / Elemento padre: 763   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(764)).setAttribute("ancho","120" );
      ((Element)v.get(764)).setAttribute("minimizable","S" );
      ((Element)v.get(764)).setAttribute("minimizada","N" );
      ((Element)v.get(763)).appendChild((Element)v.get(764));
      /* Termina nodo:764   */

      /* Empieza nodo:765 / Elemento padre: 763   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(765)).setAttribute("ancho","120" );
      ((Element)v.get(765)).setAttribute("minimizable","S" );
      ((Element)v.get(765)).setAttribute("minimizada","N" );
      ((Element)v.get(763)).appendChild((Element)v.get(765));
      /* Termina nodo:765   */

      /* Empieza nodo:766 / Elemento padre: 763   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(766)).setAttribute("ancho","120" );
      ((Element)v.get(766)).setAttribute("minimizable","S" );
      ((Element)v.get(766)).setAttribute("minimizada","N" );
      ((Element)v.get(763)).appendChild((Element)v.get(766));
      /* Termina nodo:766   */

      /* Empieza nodo:767 / Elemento padre: 763   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(767)).setAttribute("ancho","160" );
      ((Element)v.get(767)).setAttribute("minimizable","S" );
      ((Element)v.get(767)).setAttribute("minimizada","N" );
      ((Element)v.get(763)).appendChild((Element)v.get(767));
      /* Termina nodo:767   */

      /* Empieza nodo:768 / Elemento padre: 763   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(768)).setAttribute("ancho","120" );
      ((Element)v.get(768)).setAttribute("minimizable","S" );
      ((Element)v.get(768)).setAttribute("minimizada","N" );
      ((Element)v.get(763)).appendChild((Element)v.get(768));
      /* Termina nodo:768   */

      /* Empieza nodo:769 / Elemento padre: 763   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(769)).setAttribute("ancho","120" );
      ((Element)v.get(769)).setAttribute("minimizable","S" );
      ((Element)v.get(769)).setAttribute("minimizada","N" );
      ((Element)v.get(763)).appendChild((Element)v.get(769));
      /* Termina nodo:769   */

      /* Empieza nodo:770 / Elemento padre: 763   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(770)).setAttribute("ancho","160" );
      ((Element)v.get(770)).setAttribute("minimizable","S" );
   }

   private void getXML3510(Document doc) {
      ((Element)v.get(770)).setAttribute("minimizada","N" );
      ((Element)v.get(763)).appendChild((Element)v.get(770));
      /* Termina nodo:770   */
      /* Termina nodo:763   */

      /* Empieza nodo:771 / Elemento padre: 755   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(771)).setAttribute("alto","20" );
      ((Element)v.get(771)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(771)).setAttribute("imgFondo","" );
      ((Element)v.get(771)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(755)).appendChild((Element)v.get(771));

      /* Empieza nodo:772 / Elemento padre: 771   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(772)).setAttribute("colFondo","" );
      ((Element)v.get(772)).setAttribute("ID","EstCab" );
      ((Element)v.get(772)).setAttribute("align","center" );
      ((Element)v.get(772)).setAttribute("cod","1350" );
      ((Element)v.get(771)).appendChild((Element)v.get(772));
      /* Termina nodo:772   */

      /* Empieza nodo:773 / Elemento padre: 771   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(773)).setAttribute("colFondo","" );
      ((Element)v.get(773)).setAttribute("ID","EstCab" );
      ((Element)v.get(773)).setAttribute("align","center" );
      ((Element)v.get(773)).setAttribute("cod","1351" );
      ((Element)v.get(771)).appendChild((Element)v.get(773));
      /* Termina nodo:773   */

      /* Empieza nodo:774 / Elemento padre: 771   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(774)).setAttribute("colFondo","" );
      ((Element)v.get(774)).setAttribute("ID","EstCab" );
      ((Element)v.get(774)).setAttribute("align","center" );
      ((Element)v.get(774)).setAttribute("cod","1352" );
      ((Element)v.get(771)).appendChild((Element)v.get(774));
      /* Termina nodo:774   */

      /* Empieza nodo:775 / Elemento padre: 771   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(775)).setAttribute("colFondo","" );
      ((Element)v.get(775)).setAttribute("ID","EstCab" );
      ((Element)v.get(775)).setAttribute("align","center" );
      ((Element)v.get(775)).setAttribute("cod","1353" );
      ((Element)v.get(771)).appendChild((Element)v.get(775));
      /* Termina nodo:775   */

      /* Empieza nodo:776 / Elemento padre: 771   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(776)).setAttribute("colFondo","" );
      ((Element)v.get(776)).setAttribute("ID","EstCab" );
      ((Element)v.get(776)).setAttribute("align","center" );
      ((Element)v.get(776)).setAttribute("cod","1354" );
      ((Element)v.get(771)).appendChild((Element)v.get(776));
      /* Termina nodo:776   */

      /* Empieza nodo:777 / Elemento padre: 771   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(777)).setAttribute("colFondo","" );
      ((Element)v.get(777)).setAttribute("ID","EstCab" );
      ((Element)v.get(777)).setAttribute("align","center" );
      ((Element)v.get(777)).setAttribute("cod","1355" );
      ((Element)v.get(771)).appendChild((Element)v.get(777));
      /* Termina nodo:777   */

      /* Empieza nodo:778 / Elemento padre: 771   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(778)).setAttribute("colFondo","" );
      ((Element)v.get(778)).setAttribute("ID","EstCab" );
      ((Element)v.get(778)).setAttribute("align","center" );
      ((Element)v.get(778)).setAttribute("cod","1356" );
      ((Element)v.get(771)).appendChild((Element)v.get(778));
      /* Termina nodo:778   */
      /* Termina nodo:771   */

      /* Empieza nodo:779 / Elemento padre: 755   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(779)).setAttribute("alto","22" );
      ((Element)v.get(779)).setAttribute("accion","" );
      ((Element)v.get(779)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(779)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(779)).setAttribute("maxSel","-1" );
      ((Element)v.get(779)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(779)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(779)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(779)).setAttribute("onLoad","" );
      ((Element)v.get(779)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(755)).appendChild((Element)v.get(779));

      /* Empieza nodo:780 / Elemento padre: 779   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(780)).setAttribute("tipo","texto" );
      ((Element)v.get(780)).setAttribute("ID","EstDat" );
      ((Element)v.get(779)).appendChild((Element)v.get(780));
      /* Termina nodo:780   */

      /* Empieza nodo:781 / Elemento padre: 779   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(781)).setAttribute("tipo","texto" );
      ((Element)v.get(781)).setAttribute("ID","EstDat2" );
      ((Element)v.get(779)).appendChild((Element)v.get(781));
      /* Termina nodo:781   */

      /* Empieza nodo:782 / Elemento padre: 779   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(782)).setAttribute("tipo","texto" );
      ((Element)v.get(782)).setAttribute("ID","EstDat" );
      ((Element)v.get(779)).appendChild((Element)v.get(782));
      /* Termina nodo:782   */

      /* Empieza nodo:783 / Elemento padre: 779   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(783)).setAttribute("tipo","texto" );
      ((Element)v.get(783)).setAttribute("ID","EstDat2" );
      ((Element)v.get(779)).appendChild((Element)v.get(783));
      /* Termina nodo:783   */

      /* Empieza nodo:784 / Elemento padre: 779   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(784)).setAttribute("tipo","texto" );
      ((Element)v.get(784)).setAttribute("ID","EstDat" );
      ((Element)v.get(779)).appendChild((Element)v.get(784));
      /* Termina nodo:784   */

      /* Empieza nodo:785 / Elemento padre: 779   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(785)).setAttribute("tipo","texto" );
      ((Element)v.get(785)).setAttribute("ID","EstDat2" );
      ((Element)v.get(779)).appendChild((Element)v.get(785));
      /* Termina nodo:785   */

      /* Empieza nodo:786 / Elemento padre: 779   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(786)).setAttribute("tipo","texto" );
      ((Element)v.get(786)).setAttribute("ID","EstDat" );
      ((Element)v.get(779)).appendChild((Element)v.get(786));
      /* Termina nodo:786   */
      /* Termina nodo:779   */

      /* Empieza nodo:787 / Elemento padre: 755   */
   }

   private void getXML3600(Document doc) {
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(755)).appendChild((Element)v.get(787));
      /* Termina nodo:787   */

      /* Empieza nodo:788 / Elemento padre: 755   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(788)).setAttribute("nombre","mipgndo6" );
      ((Element)v.get(788)).setAttribute("ancho","711" );
      ((Element)v.get(788)).setAttribute("sep","$" );
      ((Element)v.get(788)).setAttribute("x","12" );
      ((Element)v.get(788)).setAttribute("class","botonera" );
      ((Element)v.get(788)).setAttribute("y","630" );
      ((Element)v.get(788)).setAttribute("control","|" );
      ((Element)v.get(788)).setAttribute("conector","conector_campos" );
      ((Element)v.get(788)).setAttribute("rowset","" );
      ((Element)v.get(788)).setAttribute("cargainicial","N" );
      ((Element)v.get(755)).appendChild((Element)v.get(788));

      /* Empieza nodo:789 / Elemento padre: 788   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(789)).setAttribute("nombre","ret6" );
      ((Element)v.get(789)).setAttribute("x","42" );
      ((Element)v.get(789)).setAttribute("y","630" );
      ((Element)v.get(789)).setAttribute("ID","botonContenido" );
      ((Element)v.get(789)).setAttribute("img","retroceder_on" );
      ((Element)v.get(789)).setAttribute("tipo","0" );
      ((Element)v.get(789)).setAttribute("estado","false" );
      ((Element)v.get(789)).setAttribute("alt","" );
      ((Element)v.get(789)).setAttribute("codigo","" );
      ((Element)v.get(789)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(788)).appendChild((Element)v.get(789));
      /* Termina nodo:789   */

      /* Empieza nodo:790 / Elemento padre: 788   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(790)).setAttribute("nombre","ava6" );
      ((Element)v.get(790)).setAttribute("x","57" );
      ((Element)v.get(790)).setAttribute("y","630" );
      ((Element)v.get(790)).setAttribute("ID","botonContenido" );
      ((Element)v.get(790)).setAttribute("img","avanzar_on" );
      ((Element)v.get(790)).setAttribute("tipo","0" );
      ((Element)v.get(790)).setAttribute("estado","false" );
      ((Element)v.get(790)).setAttribute("alt","" );
      ((Element)v.get(790)).setAttribute("codigo","" );
      ((Element)v.get(790)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(788)).appendChild((Element)v.get(790));
      /* Termina nodo:790   */
      /* Termina nodo:788   */
      /* Termina nodo:755   */

      /* Empieza nodo:791 / Elemento padre: 4   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(791)).setAttribute("nombre","primera6" );
      ((Element)v.get(791)).setAttribute("x","25" );
      ((Element)v.get(791)).setAttribute("y","630" );
      ((Element)v.get(791)).setAttribute("ID","botonContenido" );
      ((Element)v.get(791)).setAttribute("img","primera_on" );
      ((Element)v.get(791)).setAttribute("tipo","-2" );
      ((Element)v.get(791)).setAttribute("estado","false" );
      ((Element)v.get(791)).setAttribute("alt","" );
      ((Element)v.get(791)).setAttribute("codigo","" );
      ((Element)v.get(791)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(4)).appendChild((Element)v.get(791));
      /* Termina nodo:791   */

      /* Empieza nodo:792 / Elemento padre: 4   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(792)).setAttribute("nombre","listado7" );
      ((Element)v.get(792)).setAttribute("ancho","711" );
      ((Element)v.get(792)).setAttribute("alto","299" );
      ((Element)v.get(792)).setAttribute("x","12" );
      ((Element)v.get(792)).setAttribute("y","648" );
      ((Element)v.get(792)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(792)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(4)).appendChild((Element)v.get(792));

      /* Empieza nodo:793 / Elemento padre: 792   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(793)).setAttribute("precarga","S" );
      ((Element)v.get(793)).setAttribute("conROver","S" );
      ((Element)v.get(792)).appendChild((Element)v.get(793));

      /* Empieza nodo:794 / Elemento padre: 793   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(794)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(794)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(794)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(794)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(793)).appendChild((Element)v.get(794));
      /* Termina nodo:794   */

      /* Empieza nodo:795 / Elemento padre: 793   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(795)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(795)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(795)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(795)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(793)).appendChild((Element)v.get(795));
      /* Termina nodo:795   */
      /* Termina nodo:793   */

      /* Empieza nodo:796 / Elemento padre: 792   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(792)).appendChild((Element)v.get(796));

      /* Empieza nodo:797 / Elemento padre: 796   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(797)).setAttribute("borde","1" );
      ((Element)v.get(797)).setAttribute("horizDatos","1" );
      ((Element)v.get(797)).setAttribute("horizCabecera","1" );
      ((Element)v.get(797)).setAttribute("vertical","1" );
      ((Element)v.get(797)).setAttribute("horizTitulo","1" );
      ((Element)v.get(797)).setAttribute("horizBase","1" );
      ((Element)v.get(796)).appendChild((Element)v.get(797));
      /* Termina nodo:797   */

      /* Empieza nodo:798 / Elemento padre: 796   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(798)).setAttribute("borde","#999999" );
      ((Element)v.get(798)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(798)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(798)).setAttribute("horizDatos","#FFFFFF" );
   }

   private void getXML3690(Document doc) {
      ((Element)v.get(798)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(798)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(798)).setAttribute("horizBase","#999999" );
      ((Element)v.get(796)).appendChild((Element)v.get(798));
      /* Termina nodo:798   */
      /* Termina nodo:796   */

      /* Empieza nodo:799 / Elemento padre: 792   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(799)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(799)).setAttribute("alto","22" );
      ((Element)v.get(799)).setAttribute("imgFondo","" );
      ((Element)v.get(799)).setAttribute("cod","00145" );
      ((Element)v.get(799)).setAttribute("ID","datosTitle" );
      ((Element)v.get(792)).appendChild((Element)v.get(799));
      /* Termina nodo:799   */

      /* Empieza nodo:800 / Elemento padre: 792   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(800)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(800)).setAttribute("alto","22" );
      ((Element)v.get(800)).setAttribute("imgFondo","" );
      ((Element)v.get(792)).appendChild((Element)v.get(800));
      /* Termina nodo:800   */

      /* Empieza nodo:801 / Elemento padre: 792   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(801)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(801)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(801)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(801)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(801)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(792)).appendChild((Element)v.get(801));

      /* Empieza nodo:802 / Elemento padre: 801   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(802)).setAttribute("ancho","40" );
      ((Element)v.get(802)).setAttribute("minimizable","S" );
      ((Element)v.get(802)).setAttribute("minimizada","N" );
      ((Element)v.get(801)).appendChild((Element)v.get(802));
      /* Termina nodo:802   */
      /* Termina nodo:801   */

      /* Empieza nodo:803 / Elemento padre: 792   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(803)).setAttribute("alto","20" );
      ((Element)v.get(803)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(803)).setAttribute("imgFondo","" );
      ((Element)v.get(803)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(792)).appendChild((Element)v.get(803));

      /* Empieza nodo:804 / Elemento padre: 803   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(804)).setAttribute("colFondo","" );
      ((Element)v.get(804)).setAttribute("ID","EstCab" );
      ((Element)v.get(804)).setAttribute("align","center" );
      ((Element)v.get(804)).setAttribute("cod","6" );
      ((Element)v.get(803)).appendChild((Element)v.get(804));
      /* Termina nodo:804   */
      /* Termina nodo:803   */

      /* Empieza nodo:805 / Elemento padre: 792   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(805)).setAttribute("alto","22" );
      ((Element)v.get(805)).setAttribute("accion","" );
      ((Element)v.get(805)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(805)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(805)).setAttribute("maxSel","-1" );
      ((Element)v.get(805)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(805)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(805)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(805)).setAttribute("onLoad","" );
      ((Element)v.get(805)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(792)).appendChild((Element)v.get(805));

      /* Empieza nodo:806 / Elemento padre: 805   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(806)).setAttribute("tipo","texto" );
      ((Element)v.get(806)).setAttribute("ID","EstDat" );
      ((Element)v.get(805)).appendChild((Element)v.get(806));
      /* Termina nodo:806   */
      /* Termina nodo:805   */

      /* Empieza nodo:807 / Elemento padre: 792   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(792)).appendChild((Element)v.get(807));
      /* Termina nodo:807   */

      /* Empieza nodo:808 / Elemento padre: 792   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(808)).setAttribute("nombre","mipgndo7" );
      ((Element)v.get(808)).setAttribute("ancho","711" );
      ((Element)v.get(808)).setAttribute("sep","$" );
      ((Element)v.get(808)).setAttribute("x","12" );
      ((Element)v.get(808)).setAttribute("class","botonera" );
      ((Element)v.get(808)).setAttribute("y","925" );
      ((Element)v.get(808)).setAttribute("control","|" );
      ((Element)v.get(808)).setAttribute("conector","conector_campos" );
      ((Element)v.get(808)).setAttribute("rowset","" );
      ((Element)v.get(808)).setAttribute("cargainicial","N" );
      ((Element)v.get(792)).appendChild((Element)v.get(808));

      /* Empieza nodo:809 / Elemento padre: 808   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(809)).setAttribute("nombre","ret7" );
      ((Element)v.get(809)).setAttribute("x","166" );
      ((Element)v.get(809)).setAttribute("y","925" );
      ((Element)v.get(809)).setAttribute("ID","botonContenido" );
      ((Element)v.get(809)).setAttribute("img","retroceder_on" );
      ((Element)v.get(809)).setAttribute("tipo","0" );
      ((Element)v.get(809)).setAttribute("estado","false" );
      ((Element)v.get(809)).setAttribute("alt","" );
      ((Element)v.get(809)).setAttribute("codigo","" );
      ((Element)v.get(809)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(808)).appendChild((Element)v.get(809));
      /* Termina nodo:809   */

      /* Empieza nodo:810 / Elemento padre: 808   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(810)).setAttribute("nombre","ava7" );
      ((Element)v.get(810)).setAttribute("x","181" );
      ((Element)v.get(810)).setAttribute("y","925" );
      ((Element)v.get(810)).setAttribute("ID","botonContenido" );
      ((Element)v.get(810)).setAttribute("img","avanzar_on" );
      ((Element)v.get(810)).setAttribute("tipo","0" );
      ((Element)v.get(810)).setAttribute("estado","false" );
   }

   private void getXML3780(Document doc) {
      ((Element)v.get(810)).setAttribute("alt","" );
      ((Element)v.get(810)).setAttribute("codigo","" );
      ((Element)v.get(810)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(808)).appendChild((Element)v.get(810));
      /* Termina nodo:810   */
      /* Termina nodo:808   */
      /* Termina nodo:792   */

      /* Empieza nodo:811 / Elemento padre: 4   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(811)).setAttribute("nombre","primera7" );
      ((Element)v.get(811)).setAttribute("x","149" );
      ((Element)v.get(811)).setAttribute("y","925" );
      ((Element)v.get(811)).setAttribute("ID","botonContenido" );
      ((Element)v.get(811)).setAttribute("img","primera_on" );
      ((Element)v.get(811)).setAttribute("tipo","-2" );
      ((Element)v.get(811)).setAttribute("estado","false" );
      ((Element)v.get(811)).setAttribute("alt","" );
      ((Element)v.get(811)).setAttribute("codigo","" );
      ((Element)v.get(811)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(4)).appendChild((Element)v.get(811));
      /* Termina nodo:811   */

      /* Empieza nodo:812 / Elemento padre: 4   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(812)).setAttribute("nombre","Anterior7" );
      ((Element)v.get(812)).setAttribute("x","13" );
      ((Element)v.get(812)).setAttribute("y","925" );
      ((Element)v.get(812)).setAttribute("ID","botonContenido" );
      ((Element)v.get(812)).setAttribute("tipo","html" );
      ((Element)v.get(812)).setAttribute("estado","false" );
      ((Element)v.get(812)).setAttribute("cod","1649" );
      ((Element)v.get(812)).setAttribute("accion","navegaPestaniasDetalle(2);" );
      ((Element)v.get(4)).appendChild((Element)v.get(812));
      /* Termina nodo:812   */

      /* Empieza nodo:813 / Elemento padre: 4   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(813)).setAttribute("nombre","Siguiente7" );
      ((Element)v.get(813)).setAttribute("x","71" );
      ((Element)v.get(813)).setAttribute("y","925" );
      ((Element)v.get(813)).setAttribute("ID","botonContenido" );
      ((Element)v.get(813)).setAttribute("tipo","html" );
      ((Element)v.get(813)).setAttribute("estado","false" );
      ((Element)v.get(813)).setAttribute("cod","446" );
      ((Element)v.get(813)).setAttribute("accion","navegaPestaniasDetalle(4);" );
      ((Element)v.get(4)).appendChild((Element)v.get(813));
      /* Termina nodo:813   */

      /* Empieza nodo:814 / Elemento padre: 4   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(814)).setAttribute("nombre","listado8" );
      ((Element)v.get(814)).setAttribute("ancho","711" );
      ((Element)v.get(814)).setAttribute("alto","293" );
      ((Element)v.get(814)).setAttribute("x","12" );
      ((Element)v.get(814)).setAttribute("y","12" );
      ((Element)v.get(814)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(814)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(4)).appendChild((Element)v.get(814));

      /* Empieza nodo:815 / Elemento padre: 814   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(815)).setAttribute("precarga","S" );
      ((Element)v.get(815)).setAttribute("conROver","S" );
      ((Element)v.get(814)).appendChild((Element)v.get(815));

      /* Empieza nodo:816 / Elemento padre: 815   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(816)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(816)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(816)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(816)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(815)).appendChild((Element)v.get(816));
      /* Termina nodo:816   */

      /* Empieza nodo:817 / Elemento padre: 815   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(817)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(817)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(817)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(817)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(815)).appendChild((Element)v.get(817));
      /* Termina nodo:817   */
      /* Termina nodo:815   */

      /* Empieza nodo:818 / Elemento padre: 814   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(814)).appendChild((Element)v.get(818));

      /* Empieza nodo:819 / Elemento padre: 818   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(819)).setAttribute("borde","1" );
      ((Element)v.get(819)).setAttribute("horizDatos","1" );
      ((Element)v.get(819)).setAttribute("horizCabecera","1" );
      ((Element)v.get(819)).setAttribute("vertical","1" );
      ((Element)v.get(819)).setAttribute("horizTitulo","1" );
      ((Element)v.get(819)).setAttribute("horizBase","1" );
      ((Element)v.get(818)).appendChild((Element)v.get(819));
      /* Termina nodo:819   */

      /* Empieza nodo:820 / Elemento padre: 818   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(820)).setAttribute("borde","#999999" );
      ((Element)v.get(820)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(820)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(820)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(820)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(820)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(820)).setAttribute("horizBase","#999999" );
      ((Element)v.get(818)).appendChild((Element)v.get(820));
      /* Termina nodo:820   */
      /* Termina nodo:818   */

      /* Empieza nodo:821 / Elemento padre: 814   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(821)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(821)).setAttribute("alto","22" );
      ((Element)v.get(821)).setAttribute("imgFondo","" );
      ((Element)v.get(821)).setAttribute("cod","0058" );
      ((Element)v.get(821)).setAttribute("ID","datosTitle" );
      ((Element)v.get(814)).appendChild((Element)v.get(821));
      /* Termina nodo:821   */

      /* Empieza nodo:822 / Elemento padre: 814   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(822)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(822)).setAttribute("permiteOrdenar","S" );
   }

   private void getXML3870(Document doc) {
      ((Element)v.get(822)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(822)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(822)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(814)).appendChild((Element)v.get(822));

      /* Empieza nodo:823 / Elemento padre: 822   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(823)).setAttribute("ancho","80" );
      ((Element)v.get(823)).setAttribute("minimizable","S" );
      ((Element)v.get(823)).setAttribute("minimizada","N" );
      ((Element)v.get(822)).appendChild((Element)v.get(823));
      /* Termina nodo:823   */

      /* Empieza nodo:824 / Elemento padre: 822   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(824)).setAttribute("ancho","95" );
      ((Element)v.get(824)).setAttribute("minimizable","S" );
      ((Element)v.get(824)).setAttribute("minimizada","N" );
      ((Element)v.get(822)).appendChild((Element)v.get(824));
      /* Termina nodo:824   */

      /* Empieza nodo:825 / Elemento padre: 822   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(825)).setAttribute("ancho","215" );
      ((Element)v.get(825)).setAttribute("minimizable","S" );
      ((Element)v.get(825)).setAttribute("minimizada","N" );
      ((Element)v.get(822)).appendChild((Element)v.get(825));
      /* Termina nodo:825   */
      /* Termina nodo:822   */

      /* Empieza nodo:826 / Elemento padre: 814   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(826)).setAttribute("alto","20" );
      ((Element)v.get(826)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(826)).setAttribute("imgFondo","" );
      ((Element)v.get(826)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(814)).appendChild((Element)v.get(826));

      /* Empieza nodo:827 / Elemento padre: 826   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(827)).setAttribute("colFondo","" );
      ((Element)v.get(827)).setAttribute("ID","EstCab" );
      ((Element)v.get(827)).setAttribute("align","center" );
      ((Element)v.get(827)).setAttribute("cod","1130" );
      ((Element)v.get(826)).appendChild((Element)v.get(827));
      /* Termina nodo:827   */

      /* Empieza nodo:828 / Elemento padre: 826   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(828)).setAttribute("colFondo","" );
      ((Element)v.get(828)).setAttribute("ID","EstCab" );
      ((Element)v.get(828)).setAttribute("align","center" );
      ((Element)v.get(828)).setAttribute("cod","1057" );
      ((Element)v.get(826)).appendChild((Element)v.get(828));
      /* Termina nodo:828   */

      /* Empieza nodo:829 / Elemento padre: 826   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(829)).setAttribute("colFondo","" );
      ((Element)v.get(829)).setAttribute("ID","EstCab" );
      ((Element)v.get(829)).setAttribute("align","center" );
      ((Element)v.get(829)).setAttribute("cod","1075" );
      ((Element)v.get(826)).appendChild((Element)v.get(829));
      /* Termina nodo:829   */
      /* Termina nodo:826   */

      /* Empieza nodo:830 / Elemento padre: 814   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(830)).setAttribute("alto","22" );
      ((Element)v.get(830)).setAttribute("accion","" );
      ((Element)v.get(830)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(830)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(830)).setAttribute("maxSel","-1" );
      ((Element)v.get(830)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(830)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(830)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(830)).setAttribute("onLoad","" );
      ((Element)v.get(830)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(814)).appendChild((Element)v.get(830));

      /* Empieza nodo:831 / Elemento padre: 830   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(831)).setAttribute("tipo","texto" );
      ((Element)v.get(831)).setAttribute("ID","EstDat" );
      ((Element)v.get(830)).appendChild((Element)v.get(831));
      /* Termina nodo:831   */

      /* Empieza nodo:832 / Elemento padre: 830   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(832)).setAttribute("tipo","texto" );
      ((Element)v.get(832)).setAttribute("ID","EstDat2" );
      ((Element)v.get(830)).appendChild((Element)v.get(832));
      /* Termina nodo:832   */

      /* Empieza nodo:833 / Elemento padre: 830   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(833)).setAttribute("tipo","texto" );
      ((Element)v.get(833)).setAttribute("ID","EstDat" );
      ((Element)v.get(830)).appendChild((Element)v.get(833));
      /* Termina nodo:833   */
      /* Termina nodo:830   */

      /* Empieza nodo:834 / Elemento padre: 814   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(814)).appendChild((Element)v.get(834));
      /* Termina nodo:834   */

      /* Empieza nodo:835 / Elemento padre: 814   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(835)).setAttribute("nombre","mipgndo8" );
      ((Element)v.get(835)).setAttribute("ancho","711" );
      ((Element)v.get(835)).setAttribute("sep","$" );
      ((Element)v.get(835)).setAttribute("x","12" );
      ((Element)v.get(835)).setAttribute("class","botonera" );
      ((Element)v.get(835)).setAttribute("y","293" );
      ((Element)v.get(835)).setAttribute("control","|" );
      ((Element)v.get(835)).setAttribute("conector","conector_campos" );
      ((Element)v.get(835)).setAttribute("rowset","" );
      ((Element)v.get(835)).setAttribute("cargainicial","N" );
      ((Element)v.get(814)).appendChild((Element)v.get(835));

      /* Empieza nodo:836 / Elemento padre: 835   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(836)).setAttribute("nombre","ret8" );
      ((Element)v.get(836)).setAttribute("x","42" );
      ((Element)v.get(836)).setAttribute("y","293" );
      ((Element)v.get(836)).setAttribute("ID","botonContenido" );
      ((Element)v.get(836)).setAttribute("img","retroceder_on" );
      ((Element)v.get(836)).setAttribute("tipo","0" );
      ((Element)v.get(836)).setAttribute("estado","false" );
      ((Element)v.get(836)).setAttribute("alt","" );
   }

   private void getXML3960(Document doc) {
      ((Element)v.get(836)).setAttribute("codigo","" );
      ((Element)v.get(836)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(835)).appendChild((Element)v.get(836));
      /* Termina nodo:836   */

      /* Empieza nodo:837 / Elemento padre: 835   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(837)).setAttribute("nombre","ava8" );
      ((Element)v.get(837)).setAttribute("x","57" );
      ((Element)v.get(837)).setAttribute("y","293" );
      ((Element)v.get(837)).setAttribute("ID","botonContenido" );
      ((Element)v.get(837)).setAttribute("img","avanzar_on" );
      ((Element)v.get(837)).setAttribute("tipo","0" );
      ((Element)v.get(837)).setAttribute("estado","false" );
      ((Element)v.get(837)).setAttribute("alt","" );
      ((Element)v.get(837)).setAttribute("codigo","" );
      ((Element)v.get(837)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(835)).appendChild((Element)v.get(837));
      /* Termina nodo:837   */
      /* Termina nodo:835   */
      /* Termina nodo:814   */

      /* Empieza nodo:838 / Elemento padre: 4   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(838)).setAttribute("nombre","primera8" );
      ((Element)v.get(838)).setAttribute("x","25" );
      ((Element)v.get(838)).setAttribute("y","293" );
      ((Element)v.get(838)).setAttribute("ID","botonContenido" );
      ((Element)v.get(838)).setAttribute("img","primera_on" );
      ((Element)v.get(838)).setAttribute("tipo","-2" );
      ((Element)v.get(838)).setAttribute("estado","false" );
      ((Element)v.get(838)).setAttribute("alt","" );
      ((Element)v.get(838)).setAttribute("codigo","" );
      ((Element)v.get(838)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(4)).appendChild((Element)v.get(838));
      /* Termina nodo:838   */

      /* Empieza nodo:839 / Elemento padre: 4   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(839)).setAttribute("nombre","listado9" );
      ((Element)v.get(839)).setAttribute("ancho","711" );
      ((Element)v.get(839)).setAttribute("alto","293" );
      ((Element)v.get(839)).setAttribute("x","12" );
      ((Element)v.get(839)).setAttribute("y","330" );
      ((Element)v.get(839)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(839)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(4)).appendChild((Element)v.get(839));

      /* Empieza nodo:840 / Elemento padre: 839   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(840)).setAttribute("precarga","S" );
      ((Element)v.get(840)).setAttribute("conROver","S" );
      ((Element)v.get(839)).appendChild((Element)v.get(840));

      /* Empieza nodo:841 / Elemento padre: 840   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(841)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(841)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(841)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(841)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(840)).appendChild((Element)v.get(841));
      /* Termina nodo:841   */

      /* Empieza nodo:842 / Elemento padre: 840   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(842)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(842)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(842)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(842)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(840)).appendChild((Element)v.get(842));
      /* Termina nodo:842   */
      /* Termina nodo:840   */

      /* Empieza nodo:843 / Elemento padre: 839   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(839)).appendChild((Element)v.get(843));

      /* Empieza nodo:844 / Elemento padre: 843   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(844)).setAttribute("borde","1" );
      ((Element)v.get(844)).setAttribute("horizDatos","1" );
      ((Element)v.get(844)).setAttribute("horizCabecera","1" );
      ((Element)v.get(844)).setAttribute("vertical","1" );
      ((Element)v.get(844)).setAttribute("horizTitulo","1" );
      ((Element)v.get(844)).setAttribute("horizBase","1" );
      ((Element)v.get(843)).appendChild((Element)v.get(844));
      /* Termina nodo:844   */

      /* Empieza nodo:845 / Elemento padre: 843   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(845)).setAttribute("borde","#999999" );
      ((Element)v.get(845)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(845)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(845)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(845)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(845)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(845)).setAttribute("horizBase","#999999" );
      ((Element)v.get(843)).appendChild((Element)v.get(845));
      /* Termina nodo:845   */
      /* Termina nodo:843   */

      /* Empieza nodo:846 / Elemento padre: 839   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(846)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(846)).setAttribute("alto","22" );
      ((Element)v.get(846)).setAttribute("imgFondo","" );
      ((Element)v.get(846)).setAttribute("cod","0059" );
      ((Element)v.get(846)).setAttribute("ID","datosTitle" );
      ((Element)v.get(839)).appendChild((Element)v.get(846));
      /* Termina nodo:846   */

      /* Empieza nodo:847 / Elemento padre: 839   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(847)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(847)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(847)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(847)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(847)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(839)).appendChild((Element)v.get(847));

      /* Empieza nodo:848 / Elemento padre: 847   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(848)).setAttribute("ancho","100" );
      ((Element)v.get(848)).setAttribute("minimizable","S" );
      ((Element)v.get(848)).setAttribute("minimizada","N" );
      ((Element)v.get(847)).appendChild((Element)v.get(848));
      /* Termina nodo:848   */

      /* Empieza nodo:849 / Elemento padre: 847   */
   }

   private void getXML4050(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(849)).setAttribute("ancho","100" );
      ((Element)v.get(849)).setAttribute("minimizable","S" );
      ((Element)v.get(849)).setAttribute("minimizada","N" );
      ((Element)v.get(847)).appendChild((Element)v.get(849));
      /* Termina nodo:849   */

      /* Empieza nodo:850 / Elemento padre: 847   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(850)).setAttribute("ancho","100" );
      ((Element)v.get(850)).setAttribute("minimizable","S" );
      ((Element)v.get(850)).setAttribute("minimizada","N" );
      ((Element)v.get(847)).appendChild((Element)v.get(850));
      /* Termina nodo:850   */

      /* Empieza nodo:851 / Elemento padre: 847   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(851)).setAttribute("ancho","100" );
      ((Element)v.get(851)).setAttribute("minimizable","S" );
      ((Element)v.get(851)).setAttribute("minimizada","N" );
      ((Element)v.get(847)).appendChild((Element)v.get(851));
      /* Termina nodo:851   */

      /* Empieza nodo:852 / Elemento padre: 847   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(852)).setAttribute("ancho","100" );
      ((Element)v.get(852)).setAttribute("minimizable","S" );
      ((Element)v.get(852)).setAttribute("minimizada","N" );
      ((Element)v.get(847)).appendChild((Element)v.get(852));
      /* Termina nodo:852   */

      /* Empieza nodo:853 / Elemento padre: 847   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(853)).setAttribute("ancho","75" );
      ((Element)v.get(853)).setAttribute("minimizable","S" );
      ((Element)v.get(853)).setAttribute("minimizada","N" );
      ((Element)v.get(847)).appendChild((Element)v.get(853));
      /* Termina nodo:853   */
      /* Termina nodo:847   */

      /* Empieza nodo:854 / Elemento padre: 839   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(854)).setAttribute("alto","20" );
      ((Element)v.get(854)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(854)).setAttribute("imgFondo","" );
      ((Element)v.get(854)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(839)).appendChild((Element)v.get(854));

      /* Empieza nodo:855 / Elemento padre: 854   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(855)).setAttribute("colFondo","" );
      ((Element)v.get(855)).setAttribute("ID","EstCab" );
      ((Element)v.get(855)).setAttribute("align","center" );
      ((Element)v.get(855)).setAttribute("cod","6" );
      ((Element)v.get(854)).appendChild((Element)v.get(855));
      /* Termina nodo:855   */

      /* Empieza nodo:856 / Elemento padre: 854   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(856)).setAttribute("colFondo","" );
      ((Element)v.get(856)).setAttribute("ID","EstCab" );
      ((Element)v.get(856)).setAttribute("align","center" );
      ((Element)v.get(856)).setAttribute("cod","7" );
      ((Element)v.get(854)).appendChild((Element)v.get(856));
      /* Termina nodo:856   */

      /* Empieza nodo:857 / Elemento padre: 854   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(857)).setAttribute("colFondo","" );
      ((Element)v.get(857)).setAttribute("ID","EstCab" );
      ((Element)v.get(857)).setAttribute("align","center" );
      ((Element)v.get(857)).setAttribute("cod","1869" );
      ((Element)v.get(854)).appendChild((Element)v.get(857));
      /* Termina nodo:857   */

      /* Empieza nodo:858 / Elemento padre: 854   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(858)).setAttribute("colFondo","" );
      ((Element)v.get(858)).setAttribute("ID","EstCab" );
      ((Element)v.get(858)).setAttribute("align","center" );
      ((Element)v.get(858)).setAttribute("cod","595" );
      ((Element)v.get(854)).appendChild((Element)v.get(858));
      /* Termina nodo:858   */

      /* Empieza nodo:859 / Elemento padre: 854   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(859)).setAttribute("colFondo","" );
      ((Element)v.get(859)).setAttribute("ID","EstCab" );
      ((Element)v.get(859)).setAttribute("align","center" );
      ((Element)v.get(859)).setAttribute("cod","756" );
      ((Element)v.get(854)).appendChild((Element)v.get(859));
      /* Termina nodo:859   */

      /* Empieza nodo:860 / Elemento padre: 854   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(860)).setAttribute("colFondo","" );
      ((Element)v.get(860)).setAttribute("ID","EstCab" );
      ((Element)v.get(860)).setAttribute("align","center" );
      ((Element)v.get(860)).setAttribute("cod","550" );
      ((Element)v.get(854)).appendChild((Element)v.get(860));
      /* Termina nodo:860   */
      /* Termina nodo:854   */

      /* Empieza nodo:861 / Elemento padre: 839   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(861)).setAttribute("alto","22" );
      ((Element)v.get(861)).setAttribute("accion","" );
      ((Element)v.get(861)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(861)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(861)).setAttribute("maxSel","-1" );
      ((Element)v.get(861)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(861)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(861)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(861)).setAttribute("onLoad","" );
      ((Element)v.get(861)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(839)).appendChild((Element)v.get(861));

      /* Empieza nodo:862 / Elemento padre: 861   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(862)).setAttribute("tipo","texto" );
      ((Element)v.get(862)).setAttribute("ID","EstDat" );
      ((Element)v.get(861)).appendChild((Element)v.get(862));
      /* Termina nodo:862   */

      /* Empieza nodo:863 / Elemento padre: 861   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(863)).setAttribute("tipo","texto" );
      ((Element)v.get(863)).setAttribute("ID","EstDat2" );
      ((Element)v.get(861)).appendChild((Element)v.get(863));
      /* Termina nodo:863   */

      /* Empieza nodo:864 / Elemento padre: 861   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(864)).setAttribute("tipo","texto" );
      ((Element)v.get(864)).setAttribute("ID","EstDat" );
   }

   private void getXML4140(Document doc) {
      ((Element)v.get(861)).appendChild((Element)v.get(864));
      /* Termina nodo:864   */

      /* Empieza nodo:865 / Elemento padre: 861   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(865)).setAttribute("tipo","texto" );
      ((Element)v.get(865)).setAttribute("ID","EstDat2" );
      ((Element)v.get(861)).appendChild((Element)v.get(865));
      /* Termina nodo:865   */

      /* Empieza nodo:866 / Elemento padre: 861   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(866)).setAttribute("tipo","texto" );
      ((Element)v.get(866)).setAttribute("ID","EstDat" );
      ((Element)v.get(861)).appendChild((Element)v.get(866));
      /* Termina nodo:866   */

      /* Empieza nodo:867 / Elemento padre: 861   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(867)).setAttribute("tipo","texto" );
      ((Element)v.get(867)).setAttribute("ID","EstDat2" );
      ((Element)v.get(861)).appendChild((Element)v.get(867));
      /* Termina nodo:867   */
      /* Termina nodo:861   */

      /* Empieza nodo:868 / Elemento padre: 839   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(839)).appendChild((Element)v.get(868));
      /* Termina nodo:868   */

      /* Empieza nodo:869 / Elemento padre: 839   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(869)).setAttribute("nombre","mipgndo9" );
      ((Element)v.get(869)).setAttribute("ancho","711" );
      ((Element)v.get(869)).setAttribute("sep","$" );
      ((Element)v.get(869)).setAttribute("x","12" );
      ((Element)v.get(869)).setAttribute("class","botonera" );
      ((Element)v.get(869)).setAttribute("y","616" );
      ((Element)v.get(869)).setAttribute("control","|" );
      ((Element)v.get(869)).setAttribute("conector","conector_campos" );
      ((Element)v.get(869)).setAttribute("rowset","" );
      ((Element)v.get(869)).setAttribute("cargainicial","N" );
      ((Element)v.get(839)).appendChild((Element)v.get(869));

      /* Empieza nodo:870 / Elemento padre: 869   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(870)).setAttribute("nombre","ret9" );
      ((Element)v.get(870)).setAttribute("x","42" );
      ((Element)v.get(870)).setAttribute("y","616" );
      ((Element)v.get(870)).setAttribute("ID","botonContenido" );
      ((Element)v.get(870)).setAttribute("img","retroceder_on" );
      ((Element)v.get(870)).setAttribute("tipo","0" );
      ((Element)v.get(870)).setAttribute("estado","false" );
      ((Element)v.get(870)).setAttribute("alt","" );
      ((Element)v.get(870)).setAttribute("codigo","" );
      ((Element)v.get(870)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(869)).appendChild((Element)v.get(870));
      /* Termina nodo:870   */

      /* Empieza nodo:871 / Elemento padre: 869   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(871)).setAttribute("nombre","ava9" );
      ((Element)v.get(871)).setAttribute("x","57" );
      ((Element)v.get(871)).setAttribute("y","616" );
      ((Element)v.get(871)).setAttribute("ID","botonContenido" );
      ((Element)v.get(871)).setAttribute("img","avanzar_on" );
      ((Element)v.get(871)).setAttribute("tipo","0" );
      ((Element)v.get(871)).setAttribute("estado","false" );
      ((Element)v.get(871)).setAttribute("alt","" );
      ((Element)v.get(871)).setAttribute("codigo","" );
      ((Element)v.get(871)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(869)).appendChild((Element)v.get(871));
      /* Termina nodo:871   */
      /* Termina nodo:869   */
      /* Termina nodo:839   */

      /* Empieza nodo:872 / Elemento padre: 4   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(872)).setAttribute("nombre","primera9" );
      ((Element)v.get(872)).setAttribute("x","25" );
      ((Element)v.get(872)).setAttribute("y","616" );
      ((Element)v.get(872)).setAttribute("ID","botonContenido" );
      ((Element)v.get(872)).setAttribute("img","primera_on" );
      ((Element)v.get(872)).setAttribute("tipo","-2" );
      ((Element)v.get(872)).setAttribute("estado","false" );
      ((Element)v.get(872)).setAttribute("alt","" );
      ((Element)v.get(872)).setAttribute("codigo","" );
      ((Element)v.get(872)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(4)).appendChild((Element)v.get(872));
      /* Termina nodo:872   */

      /* Empieza nodo:873 / Elemento padre: 4   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(873)).setAttribute("nombre","listado10" );
      ((Element)v.get(873)).setAttribute("ancho","711" );
      ((Element)v.get(873)).setAttribute("alto","294" );
      ((Element)v.get(873)).setAttribute("x","12" );
      ((Element)v.get(873)).setAttribute("y","647" );
      ((Element)v.get(873)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(873)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(4)).appendChild((Element)v.get(873));

      /* Empieza nodo:874 / Elemento padre: 873   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(874)).setAttribute("precarga","S" );
      ((Element)v.get(874)).setAttribute("conROver","S" );
      ((Element)v.get(873)).appendChild((Element)v.get(874));

      /* Empieza nodo:875 / Elemento padre: 874   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(875)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(875)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(875)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(875)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(874)).appendChild((Element)v.get(875));
      /* Termina nodo:875   */

      /* Empieza nodo:876 / Elemento padre: 874   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(876)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(876)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(876)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(876)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(874)).appendChild((Element)v.get(876));
      /* Termina nodo:876   */
      /* Termina nodo:874   */

      /* Empieza nodo:877 / Elemento padre: 873   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(873)).appendChild((Element)v.get(877));

      /* Empieza nodo:878 / Elemento padre: 877   */
   }

   private void getXML4230(Document doc) {
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(878)).setAttribute("borde","1" );
      ((Element)v.get(878)).setAttribute("horizDatos","1" );
      ((Element)v.get(878)).setAttribute("horizCabecera","1" );
      ((Element)v.get(878)).setAttribute("vertical","1" );
      ((Element)v.get(878)).setAttribute("horizTitulo","1" );
      ((Element)v.get(878)).setAttribute("horizBase","1" );
      ((Element)v.get(877)).appendChild((Element)v.get(878));
      /* Termina nodo:878   */

      /* Empieza nodo:879 / Elemento padre: 877   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(879)).setAttribute("borde","#999999" );
      ((Element)v.get(879)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(879)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(879)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(879)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(879)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(879)).setAttribute("horizBase","#999999" );
      ((Element)v.get(877)).appendChild((Element)v.get(879));
      /* Termina nodo:879   */
      /* Termina nodo:877   */

      /* Empieza nodo:880 / Elemento padre: 873   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(880)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(880)).setAttribute("alto","22" );
      ((Element)v.get(880)).setAttribute("imgFondo","" );
      ((Element)v.get(880)).setAttribute("cod","0060" );
      ((Element)v.get(880)).setAttribute("ID","datosTitle" );
      ((Element)v.get(873)).appendChild((Element)v.get(880));
      /* Termina nodo:880   */

      /* Empieza nodo:881 / Elemento padre: 873   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(881)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(881)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(881)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(881)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(881)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(873)).appendChild((Element)v.get(881));

      /* Empieza nodo:882 / Elemento padre: 881   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(882)).setAttribute("ancho","97" );
      ((Element)v.get(882)).setAttribute("minimizable","S" );
      ((Element)v.get(882)).setAttribute("minimizada","N" );
      ((Element)v.get(881)).appendChild((Element)v.get(882));
      /* Termina nodo:882   */

      /* Empieza nodo:883 / Elemento padre: 881   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(883)).setAttribute("ancho","305" );
      ((Element)v.get(883)).setAttribute("minimizable","S" );
      ((Element)v.get(883)).setAttribute("minimizada","N" );
      ((Element)v.get(881)).appendChild((Element)v.get(883));
      /* Termina nodo:883   */

      /* Empieza nodo:884 / Elemento padre: 881   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(884)).setAttribute("ancho","55" );
      ((Element)v.get(884)).setAttribute("minimizable","S" );
      ((Element)v.get(884)).setAttribute("minimizada","N" );
      ((Element)v.get(881)).appendChild((Element)v.get(884));
      /* Termina nodo:884   */

      /* Empieza nodo:885 / Elemento padre: 881   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(885)).setAttribute("ancho","90" );
      ((Element)v.get(885)).setAttribute("minimizable","S" );
      ((Element)v.get(885)).setAttribute("minimizada","N" );
      ((Element)v.get(881)).appendChild((Element)v.get(885));
      /* Termina nodo:885   */

      /* Empieza nodo:886 / Elemento padre: 881   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(886)).setAttribute("ancho","305" );
      ((Element)v.get(886)).setAttribute("minimizable","S" );
      ((Element)v.get(886)).setAttribute("minimizada","N" );
      ((Element)v.get(881)).appendChild((Element)v.get(886));
      /* Termina nodo:886   */

      /* Empieza nodo:887 / Elemento padre: 881   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(887)).setAttribute("ancho","305" );
      ((Element)v.get(887)).setAttribute("minimizable","S" );
      ((Element)v.get(887)).setAttribute("minimizada","N" );
      ((Element)v.get(881)).appendChild((Element)v.get(887));
      /* Termina nodo:887   */
      /* Termina nodo:881   */

      /* Empieza nodo:888 / Elemento padre: 873   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(888)).setAttribute("alto","20" );
      ((Element)v.get(888)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(888)).setAttribute("imgFondo","" );
      ((Element)v.get(888)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(873)).appendChild((Element)v.get(888));

      /* Empieza nodo:889 / Elemento padre: 888   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(889)).setAttribute("colFondo","" );
      ((Element)v.get(889)).setAttribute("ID","EstCab" );
      ((Element)v.get(889)).setAttribute("align","center" );
      ((Element)v.get(889)).setAttribute("cod","1128" );
      ((Element)v.get(888)).appendChild((Element)v.get(889));
      /* Termina nodo:889   */

      /* Empieza nodo:890 / Elemento padre: 888   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(890)).setAttribute("colFondo","" );
      ((Element)v.get(890)).setAttribute("ID","EstCab" );
      ((Element)v.get(890)).setAttribute("align","center" );
      ((Element)v.get(890)).setAttribute("cod","1067" );
      ((Element)v.get(888)).appendChild((Element)v.get(890));
      /* Termina nodo:890   */

      /* Empieza nodo:891 / Elemento padre: 888   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(891)).setAttribute("colFondo","" );
      ((Element)v.get(891)).setAttribute("ID","EstCab" );
      ((Element)v.get(891)).setAttribute("align","center" );
      ((Element)v.get(891)).setAttribute("cod","1123" );
      ((Element)v.get(888)).appendChild((Element)v.get(891));
      /* Termina nodo:891   */

      /* Empieza nodo:892 / Elemento padre: 888   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(892)).setAttribute("colFondo","" );
      ((Element)v.get(892)).setAttribute("ID","EstCab" );
      ((Element)v.get(892)).setAttribute("align","center" );
      ((Element)v.get(892)).setAttribute("cod","1129" );
   }

   private void getXML4320(Document doc) {
      ((Element)v.get(888)).appendChild((Element)v.get(892));
      /* Termina nodo:892   */

      /* Empieza nodo:893 / Elemento padre: 888   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(893)).setAttribute("colFondo","" );
      ((Element)v.get(893)).setAttribute("ID","EstCab" );
      ((Element)v.get(893)).setAttribute("align","center" );
      ((Element)v.get(893)).setAttribute("cod","1069" );
      ((Element)v.get(888)).appendChild((Element)v.get(893));
      /* Termina nodo:893   */

      /* Empieza nodo:894 / Elemento padre: 888   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(894)).setAttribute("colFondo","" );
      ((Element)v.get(894)).setAttribute("ID","EstCab" );
      ((Element)v.get(894)).setAttribute("align","center" );
      ((Element)v.get(894)).setAttribute("cod","1096" );
      ((Element)v.get(888)).appendChild((Element)v.get(894));
      /* Termina nodo:894   */
      /* Termina nodo:888   */

      /* Empieza nodo:895 / Elemento padre: 873   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(895)).setAttribute("alto","22" );
      ((Element)v.get(895)).setAttribute("accion","" );
      ((Element)v.get(895)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(895)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(895)).setAttribute("maxSel","-1" );
      ((Element)v.get(895)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(895)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(895)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(895)).setAttribute("onLoad","" );
      ((Element)v.get(895)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(873)).appendChild((Element)v.get(895));

      /* Empieza nodo:896 / Elemento padre: 895   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(896)).setAttribute("tipo","texto" );
      ((Element)v.get(896)).setAttribute("ID","EstDat" );
      ((Element)v.get(895)).appendChild((Element)v.get(896));
      /* Termina nodo:896   */

      /* Empieza nodo:897 / Elemento padre: 895   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(897)).setAttribute("tipo","texto" );
      ((Element)v.get(897)).setAttribute("ID","EstDat2" );
      ((Element)v.get(895)).appendChild((Element)v.get(897));
      /* Termina nodo:897   */

      /* Empieza nodo:898 / Elemento padre: 895   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(898)).setAttribute("tipo","texto" );
      ((Element)v.get(898)).setAttribute("ID","EstDat" );
      ((Element)v.get(895)).appendChild((Element)v.get(898));
      /* Termina nodo:898   */

      /* Empieza nodo:899 / Elemento padre: 895   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(899)).setAttribute("tipo","texto" );
      ((Element)v.get(899)).setAttribute("ID","EstDat2" );
      ((Element)v.get(895)).appendChild((Element)v.get(899));
      /* Termina nodo:899   */

      /* Empieza nodo:900 / Elemento padre: 895   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(900)).setAttribute("tipo","texto" );
      ((Element)v.get(900)).setAttribute("ID","EstDat" );
      ((Element)v.get(895)).appendChild((Element)v.get(900));
      /* Termina nodo:900   */

      /* Empieza nodo:901 / Elemento padre: 895   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(901)).setAttribute("tipo","texto" );
      ((Element)v.get(901)).setAttribute("ID","EstDat2" );
      ((Element)v.get(895)).appendChild((Element)v.get(901));
      /* Termina nodo:901   */
      /* Termina nodo:895   */

      /* Empieza nodo:902 / Elemento padre: 873   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(873)).appendChild((Element)v.get(902));
      /* Termina nodo:902   */

      /* Empieza nodo:903 / Elemento padre: 873   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(903)).setAttribute("nombre","mipgndo10" );
      ((Element)v.get(903)).setAttribute("ancho","711" );
      ((Element)v.get(903)).setAttribute("sep","$" );
      ((Element)v.get(903)).setAttribute("x","12" );
      ((Element)v.get(903)).setAttribute("class","botonera" );
      ((Element)v.get(903)).setAttribute("y","939" );
      ((Element)v.get(903)).setAttribute("control","|" );
      ((Element)v.get(903)).setAttribute("conector","conector_campos" );
      ((Element)v.get(903)).setAttribute("rowset","" );
      ((Element)v.get(903)).setAttribute("cargainicial","N" );
      ((Element)v.get(873)).appendChild((Element)v.get(903));

      /* Empieza nodo:904 / Elemento padre: 903   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(904)).setAttribute("nombre","ret10" );
      ((Element)v.get(904)).setAttribute("x","42" );
      ((Element)v.get(904)).setAttribute("y","939" );
      ((Element)v.get(904)).setAttribute("ID","botonContenido" );
      ((Element)v.get(904)).setAttribute("img","retroceder_on" );
      ((Element)v.get(904)).setAttribute("tipo","0" );
      ((Element)v.get(904)).setAttribute("estado","false" );
      ((Element)v.get(904)).setAttribute("alt","" );
      ((Element)v.get(904)).setAttribute("codigo","" );
      ((Element)v.get(904)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(903)).appendChild((Element)v.get(904));
      /* Termina nodo:904   */

      /* Empieza nodo:905 / Elemento padre: 903   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(905)).setAttribute("nombre","ava10" );
      ((Element)v.get(905)).setAttribute("x","57" );
      ((Element)v.get(905)).setAttribute("y","939" );
      ((Element)v.get(905)).setAttribute("ID","botonContenido" );
      ((Element)v.get(905)).setAttribute("img","avanzar_on" );
      ((Element)v.get(905)).setAttribute("tipo","0" );
      ((Element)v.get(905)).setAttribute("estado","false" );
      ((Element)v.get(905)).setAttribute("alt","" );
      ((Element)v.get(905)).setAttribute("codigo","" );
      ((Element)v.get(905)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(903)).appendChild((Element)v.get(905));
      /* Termina nodo:905   */
      /* Termina nodo:903   */
      /* Termina nodo:873   */

      /* Empieza nodo:906 / Elemento padre: 4   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(906)).setAttribute("nombre","primera10" );
      ((Element)v.get(906)).setAttribute("x","25" );
   }

   private void getXML4410(Document doc) {
      ((Element)v.get(906)).setAttribute("y","939" );
      ((Element)v.get(906)).setAttribute("ID","botonContenido" );
      ((Element)v.get(906)).setAttribute("img","primera_on" );
      ((Element)v.get(906)).setAttribute("tipo","-2" );
      ((Element)v.get(906)).setAttribute("estado","false" );
      ((Element)v.get(906)).setAttribute("alt","" );
      ((Element)v.get(906)).setAttribute("codigo","" );
      ((Element)v.get(906)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(4)).appendChild((Element)v.get(906));
      /* Termina nodo:906   */

      /* Empieza nodo:907 / Elemento padre: 4   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(907)).setAttribute("nombre","listado11" );
      ((Element)v.get(907)).setAttribute("ancho","711" );
      ((Element)v.get(907)).setAttribute("alto","317" );
      ((Element)v.get(907)).setAttribute("x","12" );
      ((Element)v.get(907)).setAttribute("y","966" );
      ((Element)v.get(907)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(907)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(4)).appendChild((Element)v.get(907));

      /* Empieza nodo:908 / Elemento padre: 907   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(908)).setAttribute("precarga","S" );
      ((Element)v.get(908)).setAttribute("conROver","S" );
      ((Element)v.get(907)).appendChild((Element)v.get(908));

      /* Empieza nodo:909 / Elemento padre: 908   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(909)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(909)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(909)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(909)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(908)).appendChild((Element)v.get(909));
      /* Termina nodo:909   */

      /* Empieza nodo:910 / Elemento padre: 908   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(910)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(910)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(910)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(910)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(908)).appendChild((Element)v.get(910));
      /* Termina nodo:910   */
      /* Termina nodo:908   */

      /* Empieza nodo:911 / Elemento padre: 907   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(907)).appendChild((Element)v.get(911));

      /* Empieza nodo:912 / Elemento padre: 911   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(912)).setAttribute("borde","1" );
      ((Element)v.get(912)).setAttribute("horizDatos","1" );
      ((Element)v.get(912)).setAttribute("horizCabecera","1" );
      ((Element)v.get(912)).setAttribute("vertical","1" );
      ((Element)v.get(912)).setAttribute("horizTitulo","1" );
      ((Element)v.get(912)).setAttribute("horizBase","1" );
      ((Element)v.get(911)).appendChild((Element)v.get(912));
      /* Termina nodo:912   */

      /* Empieza nodo:913 / Elemento padre: 911   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(913)).setAttribute("borde","#999999" );
      ((Element)v.get(913)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(913)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(913)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(913)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(913)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(913)).setAttribute("horizBase","#999999" );
      ((Element)v.get(911)).appendChild((Element)v.get(913));
      /* Termina nodo:913   */
      /* Termina nodo:911   */

      /* Empieza nodo:914 / Elemento padre: 907   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(914)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(914)).setAttribute("alto","22" );
      ((Element)v.get(914)).setAttribute("imgFondo","" );
      ((Element)v.get(914)).setAttribute("cod","00155" );
      ((Element)v.get(914)).setAttribute("ID","datosTitle" );
      ((Element)v.get(907)).appendChild((Element)v.get(914));
      /* Termina nodo:914   */

      /* Empieza nodo:915 / Elemento padre: 907   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(915)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(915)).setAttribute("alto","22" );
      ((Element)v.get(915)).setAttribute("imgFondo","" );
      ((Element)v.get(907)).appendChild((Element)v.get(915));
      /* Termina nodo:915   */

      /* Empieza nodo:916 / Elemento padre: 907   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(916)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(916)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(916)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(916)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(916)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(907)).appendChild((Element)v.get(916));

      /* Empieza nodo:917 / Elemento padre: 916   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(917)).setAttribute("ancho","220" );
      ((Element)v.get(917)).setAttribute("minimizable","S" );
      ((Element)v.get(917)).setAttribute("minimizada","N" );
      ((Element)v.get(916)).appendChild((Element)v.get(917));
      /* Termina nodo:917   */

      /* Empieza nodo:918 / Elemento padre: 916   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(918)).setAttribute("ancho","77" );
      ((Element)v.get(918)).setAttribute("minimizable","S" );
      ((Element)v.get(918)).setAttribute("minimizada","N" );
      ((Element)v.get(916)).appendChild((Element)v.get(918));
      /* Termina nodo:918   */

      /* Empieza nodo:919 / Elemento padre: 916   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(919)).setAttribute("ancho","77" );
      ((Element)v.get(919)).setAttribute("minimizable","S" );
      ((Element)v.get(919)).setAttribute("minimizada","N" );
      ((Element)v.get(916)).appendChild((Element)v.get(919));
      /* Termina nodo:919   */

      /* Empieza nodo:920 / Elemento padre: 916   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(920)).setAttribute("ancho","77" );
      ((Element)v.get(920)).setAttribute("minimizable","S" );
   }

   private void getXML4500(Document doc) {
      ((Element)v.get(920)).setAttribute("minimizada","N" );
      ((Element)v.get(916)).appendChild((Element)v.get(920));
      /* Termina nodo:920   */
      /* Termina nodo:916   */

      /* Empieza nodo:921 / Elemento padre: 907   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(921)).setAttribute("alto","20" );
      ((Element)v.get(921)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(921)).setAttribute("imgFondo","" );
      ((Element)v.get(921)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(907)).appendChild((Element)v.get(921));

      /* Empieza nodo:922 / Elemento padre: 921   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(922)).setAttribute("colFondo","" );
      ((Element)v.get(922)).setAttribute("ID","EstCab" );
      ((Element)v.get(922)).setAttribute("align","center" );
      ((Element)v.get(922)).setAttribute("cod","6" );
      ((Element)v.get(921)).appendChild((Element)v.get(922));
      /* Termina nodo:922   */

      /* Empieza nodo:923 / Elemento padre: 921   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(923)).setAttribute("colFondo","" );
      ((Element)v.get(923)).setAttribute("ID","EstCab" );
      ((Element)v.get(923)).setAttribute("align","center" );
      ((Element)v.get(923)).setAttribute("cod","1365" );
      ((Element)v.get(921)).appendChild((Element)v.get(923));
      /* Termina nodo:923   */

      /* Empieza nodo:924 / Elemento padre: 921   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(924)).setAttribute("colFondo","" );
      ((Element)v.get(924)).setAttribute("ID","EstCab" );
      ((Element)v.get(924)).setAttribute("align","center" );
      ((Element)v.get(924)).setAttribute("cod","1366" );
      ((Element)v.get(921)).appendChild((Element)v.get(924));
      /* Termina nodo:924   */

      /* Empieza nodo:925 / Elemento padre: 921   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(925)).setAttribute("colFondo","" );
      ((Element)v.get(925)).setAttribute("ID","EstCab" );
      ((Element)v.get(925)).setAttribute("align","center" );
      ((Element)v.get(925)).setAttribute("cod","188" );
      ((Element)v.get(921)).appendChild((Element)v.get(925));
      /* Termina nodo:925   */
      /* Termina nodo:921   */

      /* Empieza nodo:926 / Elemento padre: 907   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(926)).setAttribute("alto","22" );
      ((Element)v.get(926)).setAttribute("accion","" );
      ((Element)v.get(926)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(926)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(926)).setAttribute("maxSel","-1" );
      ((Element)v.get(926)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(926)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(926)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(926)).setAttribute("onLoad","" );
      ((Element)v.get(926)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(907)).appendChild((Element)v.get(926));

      /* Empieza nodo:927 / Elemento padre: 926   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(927)).setAttribute("tipo","texto" );
      ((Element)v.get(927)).setAttribute("ID","EstDat" );
      ((Element)v.get(926)).appendChild((Element)v.get(927));
      /* Termina nodo:927   */

      /* Empieza nodo:928 / Elemento padre: 926   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(928)).setAttribute("tipo","texto" );
      ((Element)v.get(928)).setAttribute("ID","EstDat2" );
      ((Element)v.get(926)).appendChild((Element)v.get(928));
      /* Termina nodo:928   */

      /* Empieza nodo:929 / Elemento padre: 926   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(929)).setAttribute("tipo","texto" );
      ((Element)v.get(929)).setAttribute("ID","EstDat" );
      ((Element)v.get(926)).appendChild((Element)v.get(929));
      /* Termina nodo:929   */

      /* Empieza nodo:930 / Elemento padre: 926   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(930)).setAttribute("tipo","texto" );
      ((Element)v.get(930)).setAttribute("ID","EstDat2" );
      ((Element)v.get(926)).appendChild((Element)v.get(930));
      /* Termina nodo:930   */
      /* Termina nodo:926   */

      /* Empieza nodo:931 / Elemento padre: 907   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(907)).appendChild((Element)v.get(931));
      /* Termina nodo:931   */

      /* Empieza nodo:932 / Elemento padre: 907   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(932)).setAttribute("nombre","mipgndo11" );
      ((Element)v.get(932)).setAttribute("ancho","711" );
      ((Element)v.get(932)).setAttribute("sep","$" );
      ((Element)v.get(932)).setAttribute("x","12" );
      ((Element)v.get(932)).setAttribute("class","botonera" );
      ((Element)v.get(932)).setAttribute("y","1260" );
      ((Element)v.get(932)).setAttribute("control","|" );
      ((Element)v.get(932)).setAttribute("conector","conector_campos" );
      ((Element)v.get(932)).setAttribute("rowset","" );
      ((Element)v.get(932)).setAttribute("cargainicial","N" );
      ((Element)v.get(907)).appendChild((Element)v.get(932));

      /* Empieza nodo:933 / Elemento padre: 932   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(933)).setAttribute("nombre","ret11" );
      ((Element)v.get(933)).setAttribute("x","100" );
      ((Element)v.get(933)).setAttribute("y","1277" );
      ((Element)v.get(933)).setAttribute("ID","botonContenido" );
      ((Element)v.get(933)).setAttribute("img","retroceder_on" );
      ((Element)v.get(933)).setAttribute("tipo","0" );
      ((Element)v.get(933)).setAttribute("estado","false" );
      ((Element)v.get(933)).setAttribute("alt","" );
      ((Element)v.get(933)).setAttribute("codigo","" );
      ((Element)v.get(933)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(932)).appendChild((Element)v.get(933));
      /* Termina nodo:933   */

      /* Empieza nodo:934 / Elemento padre: 932   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(934)).setAttribute("nombre","ava11" );
      ((Element)v.get(934)).setAttribute("x","115" );
      ((Element)v.get(934)).setAttribute("y","1277" );
   }

   private void getXML4590(Document doc) {
      ((Element)v.get(934)).setAttribute("ID","botonContenido" );
      ((Element)v.get(934)).setAttribute("img","avanzar_on" );
      ((Element)v.get(934)).setAttribute("tipo","0" );
      ((Element)v.get(934)).setAttribute("estado","false" );
      ((Element)v.get(934)).setAttribute("alt","" );
      ((Element)v.get(934)).setAttribute("codigo","" );
      ((Element)v.get(934)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(932)).appendChild((Element)v.get(934));
      /* Termina nodo:934   */
      /* Termina nodo:932   */
      /* Termina nodo:907   */

      /* Empieza nodo:935 / Elemento padre: 4   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(935)).setAttribute("nombre","primera11" );
      ((Element)v.get(935)).setAttribute("x","83" );
      ((Element)v.get(935)).setAttribute("y","1277" );
      ((Element)v.get(935)).setAttribute("ID","botonContenido" );
      ((Element)v.get(935)).setAttribute("img","primera_on" );
      ((Element)v.get(935)).setAttribute("tipo","-2" );
      ((Element)v.get(935)).setAttribute("estado","false" );
      ((Element)v.get(935)).setAttribute("alt","" );
      ((Element)v.get(935)).setAttribute("codigo","" );
      ((Element)v.get(935)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(4)).appendChild((Element)v.get(935));
      /* Termina nodo:935   */

      /* Empieza nodo:936 / Elemento padre: 4   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(936)).setAttribute("nombre","Anterior11" );
      ((Element)v.get(936)).setAttribute("x","13" );
      ((Element)v.get(936)).setAttribute("y","1261" );
      ((Element)v.get(936)).setAttribute("accion","navegaPestaniasDetalle(3);" );
      ((Element)v.get(936)).setAttribute("ID","botonContenido" );
      ((Element)v.get(936)).setAttribute("tipo","html" );
      ((Element)v.get(936)).setAttribute("estado","false" );
      ((Element)v.get(936)).setAttribute("cod","1649" );
      ((Element)v.get(4)).appendChild((Element)v.get(936));
      /* Termina nodo:936   */
      /* Termina nodo:4   */


   }

}
