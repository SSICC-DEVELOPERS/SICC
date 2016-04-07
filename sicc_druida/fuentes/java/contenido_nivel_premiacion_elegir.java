
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_nivel_premiacion_elegir  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_nivel_premiacion_elegir" );
      ((Element)v.get(0)).setAttribute("cod","0502" );
      ((Element)v.get(0)).setAttribute("titulo","Elegir premios de recomendacion" );
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
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Elemento padre:4 / Elemento actual: 5   */
      v.add(doc.createTextNode("\r   \r\r  LP = 'LPElegirPremiosRecomendacion';\r\r  function onLoadPag() {\r  \r    configurarMenuSecundario(\"formulario\");\r	DrdEnsanchaConMargenDcho('listado1',12);\r\r    document.all[\"Cplistado1\"].style.visibility='';\r    document.all[\"CpLin1listado1\"].style.visibility='';\r    document.all[\"CpLin2listado1\"].style.visibility='';\r    document.all[\"CpLin3listado1\"].style.visibility='';\r    document.all[\"CpLin4listado1\"].style.visibility='';\r\r    document.all[\"primera1Div\"].style.visibility='';\r    document.all[\"ret1Div\"].style.visibility='';\r    document.all[\"ava1Div\"].style.visibility='';\r    document.all[\"separaDiv\"].style.visibility='';	\r    document.all[\"btnAceptarDiv\"].style.visibility='';	\r    eval (ON_RSZ);\r\r    var arr = [[\"oidConcurso\", get(\"formulario.hidOidConcursoParametrosGenerales\")]];\r\r	configurarPaginado(mipgndo, \r					   \"INCBuscarNivelesPremiacion\", \r					   \"ConectorBuscarNivelesPremiacion\", \r					   \"es.indra.sicc.dtos.inc.DTOElegirPremiosRec\",\r					   arr);\r\r    focalizaBotonHTML_XY('btnAceptar');\r  }\r      \r   function onClickAceptar() { \r		fGuardar(); \r   }\r\r   function fGuardar() {\r     \r     pos = chkPos()\r	 if (pos != -1) {\r         set('formulario.hidOid', listado1.datos[pos][0]);\r         set('formulario.hidNumeronivel', listado1.datos[pos][1]);\r		 set('formulario.hidNumeropremio', listado1.datos[pos][2]);\r		 set('formulario.hidTipopremio', listado1.datos[pos][3]);\r		 set('formulario.hidCostepuntos', listado1.datos[pos][4]);\r		 set('formulario.hidOid_para_gral', listado1.datos[pos][5]);\r		 set('formulario.hidPerd_oid_peri_desd', listado1.datos[pos][6]);\r		 set('formulario.hidNum_conc', listado1.datos[pos][7]);\r		 set('formulario.hidNum_vers', listado1.datos[pos][8]);		\r		 set('formulario.hidCantidadinicial', listado1.datos[pos][9]);\r		 set('formulario.hidCantidadfinal', listado1.datos[pos][10]);\r		 set('formulario.hidPuntosservicio', listado1.datos[pos][11]);\r		 set('formulario.hidNivelelegido', listado1.datos[pos][12]);\r		 set('formulario.hidOid_para_nive_prem', listado1.datos[pos][13]);\r		 set('formulario.hidRecomendado', get(\"formulario.hidRecomendado\"));\r		 set('formulario.hidRecomendante', get(\"formulario.hidRecomendante\"));\r         set('formulario.hidPeriodoContacto', get(\"formulario.hidPeriodoContacto\"));\r		 callMethod('guardarPremio', true);\r	 }\r   }\r\r   function chkPos() \r   {	if (listado1.numSelecc() == 1)\r			return obtenerPosicionListaEditable(listado1.codSeleccionados(), listado1);			\r		else\r		{  if (listado1.numSelecc() > 1)\r			  cdos_mostrarAlert(GestionarMensaje(\"240\"));	  \r		   else\r		   {  if (listado1.numSelecc() < 1)\r				  GestionarMensaje(\"4\");\r		   }\r		}\r		return -1;\r	} \r	\r	function callMethod(){  \r	if (!arguments[1])\r	     eval('formulario').oculto='S';\r	   set('formulario.conectorAction', (arguments[2]) ? arguments[2] : LP);\r	   set('formulario.accion', arguments[0]);\r	   enviaSICC('formulario', null, null, 'N');\r	}\r\r    function cerrar() { \r		window.close(); \r	}\r	\r	function fVolver() { \r		window.close(); \r	}\r   \r   \r"));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(6)).setAttribute("nombre","formulario" );
      ((Element)v.get(6)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","accion" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","oidIdioma" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","oidPais" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","hidRecomendado" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hidRecomendante" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hidPeriodoContacto" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hidPeriodoVinculo" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hidOidConcursoParametrosGenerales" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hidOid" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hidNumeronivel" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hidNumeropremio" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","hidTipopremio" );
      ((Element)v.get(22)).setAttribute("valor","" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(6)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","hidCostepuntos" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hidOid_para_gral" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hidPerd_oid_peri_desd" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hidNum_conc" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hidNum_vers" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hidCantidadinicial" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hidCantidadfinal" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hidPuntosservicio" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","hidNivelelegido" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","hidOid_para_nive_prem" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 6   */
      v.add(doc.createElement("table"));
      ((Element)v.get(33)).setAttribute("width","100%" );
      ((Element)v.get(33)).setAttribute("border","0" );
      ((Element)v.get(33)).setAttribute("cellspacing","0" );
      ((Element)v.get(33)).setAttribute("cellpadding","0" );
      ((Element)v.get(6)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).setAttribute("width","12" );
      ((Element)v.get(35)).setAttribute("align","center" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(36)).setAttribute("src","b.gif" );
      ((Element)v.get(36)).setAttribute("width","12" );
      ((Element)v.get(36)).setAttribute("height","12" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */
      /* Termina nodo:35   */

      /* Empieza nodo:37 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).setAttribute("width","400" );
      ((Element)v.get(34)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(38)).setAttribute("src","b.gif" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:39 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).setAttribute("width","12" );
      ((Element)v.get(34)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(40)).setAttribute("src","b.gif" );
      ((Element)v.get(40)).setAttribute("width","12" );
      ((Element)v.get(40)).setAttribute("height","1" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */
      /* Termina nodo:39   */
      /* Termina nodo:34   */
      /* Termina nodo:33   */

      /* Empieza nodo:41 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(41)).setAttribute("nombre","listado1" );
      ((Element)v.get(41)).setAttribute("ancho","400" );
      ((Element)v.get(41)).setAttribute("alto","300" );
      ((Element)v.get(41)).setAttribute("x","12" );
      ((Element)v.get(41)).setAttribute("y","12" );
      ((Element)v.get(41)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(41)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(42)).setAttribute("precarga","S" );
      ((Element)v.get(42)).setAttribute("conROver","S" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(43)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(43)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(43)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(43)).setAttribute("desactivado","btnLista2D.gif" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 42   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(44)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(44)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(44)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(44)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(42)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 42   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(45)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(45)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(42)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:42   */

      /* Empieza nodo:46 / Elemento padre: 41   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(41)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(47)).setAttribute("borde","1" );
      ((Element)v.get(47)).setAttribute("horizDatos","1" );
      ((Element)v.get(47)).setAttribute("horizCabecera","1" );
      ((Element)v.get(47)).setAttribute("vertical","1" );
      ((Element)v.get(47)).setAttribute("horizTitulo","1" );
      ((Element)v.get(47)).setAttribute("horizBase","1" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 46   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(48)).setAttribute("borde","#999999" );
      ((Element)v.get(48)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(48)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(48)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(48)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(48)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(48)).setAttribute("horizBase","#999999" );
      ((Element)v.get(46)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:46   */

      /* Empieza nodo:49 / Elemento padre: 41   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(49)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(49)).setAttribute("alto","22" );
      ((Element)v.get(49)).setAttribute("imgFondo","" );
      ((Element)v.get(49)).setAttribute("cod","00290" );
      ((Element)v.get(49)).setAttribute("ID","datosTitle" );
      ((Element)v.get(41)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 41   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(50)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(50)).setAttribute("alto","22" );
      ((Element)v.get(50)).setAttribute("imgFondo","" );
      ((Element)v.get(41)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 41   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(51)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(51)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(51)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(51)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(51)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(51)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(41)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(52)).setAttribute("ancho","100" );
      ((Element)v.get(52)).setAttribute("minimizable","S" );
      ((Element)v.get(52)).setAttribute("minimizada","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 51   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(53)).setAttribute("ancho","100" );
      ((Element)v.get(53)).setAttribute("minimizable","S" );
      ((Element)v.get(53)).setAttribute("minimizada","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 51   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(54)).setAttribute("ancho","100" );
      ((Element)v.get(54)).setAttribute("minimizable","S" );
      ((Element)v.get(54)).setAttribute("minimizada","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 51   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(55)).setAttribute("ancho","0" );
      ((Element)v.get(55)).setAttribute("minimizable","S" );
      ((Element)v.get(55)).setAttribute("minimizada","N" );
      ((Element)v.get(55)).setAttribute("oculta","S" );
      ((Element)v.get(51)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 51   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(56)).setAttribute("ancho","0" );
      ((Element)v.get(56)).setAttribute("minimizable","S" );
      ((Element)v.get(56)).setAttribute("minimizada","N" );
      ((Element)v.get(56)).setAttribute("oculta","S" );
      ((Element)v.get(51)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 51   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(57)).setAttribute("ancho","0" );
      ((Element)v.get(57)).setAttribute("minimizable","S" );
      ((Element)v.get(57)).setAttribute("minimizada","N" );
      ((Element)v.get(57)).setAttribute("oculta","S" );
      ((Element)v.get(51)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 51   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(58)).setAttribute("ancho","0" );
      ((Element)v.get(58)).setAttribute("minimizable","S" );
      ((Element)v.get(58)).setAttribute("minimizada","N" );
      ((Element)v.get(58)).setAttribute("oculta","S" );
      ((Element)v.get(51)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 51   */
      v.add(doc.createElement("COL"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(59)).setAttribute("ancho","0" );
      ((Element)v.get(59)).setAttribute("minimizable","S" );
      ((Element)v.get(59)).setAttribute("minimizada","N" );
      ((Element)v.get(59)).setAttribute("oculta","S" );
      ((Element)v.get(51)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 51   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(60)).setAttribute("ancho","0" );
      ((Element)v.get(60)).setAttribute("minimizable","S" );
      ((Element)v.get(60)).setAttribute("minimizada","N" );
      ((Element)v.get(60)).setAttribute("oculta","S" );
      ((Element)v.get(51)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 51   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(61)).setAttribute("ancho","0" );
      ((Element)v.get(61)).setAttribute("minimizable","S" );
      ((Element)v.get(61)).setAttribute("minimizada","N" );
      ((Element)v.get(61)).setAttribute("oculta","S" );
      ((Element)v.get(51)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 51   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(62)).setAttribute("ancho","0" );
      ((Element)v.get(62)).setAttribute("minimizable","S" );
      ((Element)v.get(62)).setAttribute("minimizada","N" );
      ((Element)v.get(62)).setAttribute("oculta","S" );
      ((Element)v.get(51)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 51   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(63)).setAttribute("ancho","0" );
      ((Element)v.get(63)).setAttribute("minimizable","S" );
      ((Element)v.get(63)).setAttribute("minimizada","N" );
      ((Element)v.get(63)).setAttribute("oculta","S" );
      ((Element)v.get(51)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 51   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(64)).setAttribute("ancho","0" );
      ((Element)v.get(64)).setAttribute("minimizable","S" );
      ((Element)v.get(64)).setAttribute("minimizada","N" );
      ((Element)v.get(64)).setAttribute("oculta","S" );
      ((Element)v.get(51)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:51   */

      /* Empieza nodo:65 / Elemento padre: 41   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(65)).setAttribute("alto","20" );
      ((Element)v.get(65)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(65)).setAttribute("imgFondo","" );
      ((Element)v.get(65)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(41)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(66)).setAttribute("colFondo","" );
      ((Element)v.get(66)).setAttribute("ID","EstCab" );
      ((Element)v.get(66)).setAttribute("cod","1664" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 65   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(67)).setAttribute("colFondo","" );
      ((Element)v.get(67)).setAttribute("ID","EstCab" );
      ((Element)v.get(67)).setAttribute("cod","1691" );
      ((Element)v.get(65)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */

      /* Empieza nodo:68 / Elemento padre: 65   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(68)).setAttribute("colFondo","" );
      ((Element)v.get(68)).setAttribute("ID","EstCab" );
      ((Element)v.get(68)).setAttribute("cod","1696" );
      ((Element)v.get(65)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */

      /* Empieza nodo:69 / Elemento padre: 65   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(69)).setAttribute("colFondo","" );
      ((Element)v.get(69)).setAttribute("ID","EstCab" );
      ((Element)v.get(69)).setAttribute("cod","" );
      ((Element)v.get(65)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */

      /* Empieza nodo:70 / Elemento padre: 65   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(70)).setAttribute("colFondo","" );
      ((Element)v.get(70)).setAttribute("ID","EstCab" );
      ((Element)v.get(70)).setAttribute("cod","" );
      ((Element)v.get(65)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 65   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(71)).setAttribute("colFondo","" );
      ((Element)v.get(71)).setAttribute("ID","EstCab" );
      ((Element)v.get(71)).setAttribute("cod","" );
      ((Element)v.get(65)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */

      /* Empieza nodo:72 / Elemento padre: 65   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(72)).setAttribute("colFondo","" );
      ((Element)v.get(72)).setAttribute("ID","EstCab" );
      ((Element)v.get(72)).setAttribute("cod","" );
      ((Element)v.get(65)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */

      /* Empieza nodo:73 / Elemento padre: 65   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(73)).setAttribute("colFondo","" );
      ((Element)v.get(73)).setAttribute("ID","EstCab" );
      ((Element)v.get(73)).setAttribute("cod","" );
      ((Element)v.get(65)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */

      /* Empieza nodo:74 / Elemento padre: 65   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(74)).setAttribute("colFondo","" );
      ((Element)v.get(74)).setAttribute("ID","EstCab" );
      ((Element)v.get(74)).setAttribute("cod","" );
      ((Element)v.get(65)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */

      /* Empieza nodo:75 / Elemento padre: 65   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(75)).setAttribute("colFondo","" );
      ((Element)v.get(75)).setAttribute("ID","EstCab" );
      ((Element)v.get(75)).setAttribute("cod","" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(65)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */

      /* Empieza nodo:76 / Elemento padre: 65   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(76)).setAttribute("colFondo","" );
      ((Element)v.get(76)).setAttribute("ID","EstCab" );
      ((Element)v.get(76)).setAttribute("cod","" );
      ((Element)v.get(65)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */

      /* Empieza nodo:77 / Elemento padre: 65   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(77)).setAttribute("colFondo","" );
      ((Element)v.get(77)).setAttribute("ID","EstCab" );
      ((Element)v.get(77)).setAttribute("cod","" );
      ((Element)v.get(65)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */

      /* Empieza nodo:78 / Elemento padre: 65   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(78)).setAttribute("colFondo","" );
      ((Element)v.get(78)).setAttribute("ID","EstCab" );
      ((Element)v.get(78)).setAttribute("cod","" );
      ((Element)v.get(65)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:65   */

      /* Empieza nodo:79 / Elemento padre: 41   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(79)).setAttribute("alto","22" );
      ((Element)v.get(79)).setAttribute("accion","" );
      ((Element)v.get(79)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(79)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(79)).setAttribute("maxSel","1" );
      ((Element)v.get(79)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(79)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(79)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(79)).setAttribute("onLoad","" );
      ((Element)v.get(79)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(41)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(80)).setAttribute("tipo","texto" );
      ((Element)v.get(80)).setAttribute("ID","EstDat" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */

      /* Empieza nodo:81 / Elemento padre: 79   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(81)).setAttribute("tipo","texto" );
      ((Element)v.get(81)).setAttribute("ID","EstDat2" );
      ((Element)v.get(79)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */

      /* Empieza nodo:82 / Elemento padre: 79   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(82)).setAttribute("tipo","texto" );
      ((Element)v.get(82)).setAttribute("ID","EstDat" );
      ((Element)v.get(79)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 79   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(83)).setAttribute("tipo","texto" );
      ((Element)v.get(83)).setAttribute("ID","EstDat" );
      ((Element)v.get(79)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */

      /* Empieza nodo:84 / Elemento padre: 79   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(84)).setAttribute("tipo","texto" );
      ((Element)v.get(84)).setAttribute("ID","EstDat" );
      ((Element)v.get(79)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */

      /* Empieza nodo:85 / Elemento padre: 79   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(85)).setAttribute("tipo","texto" );
      ((Element)v.get(85)).setAttribute("ID","EstDat" );
      ((Element)v.get(79)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 79   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(86)).setAttribute("tipo","texto" );
      ((Element)v.get(86)).setAttribute("ID","EstDat" );
      ((Element)v.get(79)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 79   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(87)).setAttribute("tipo","texto" );
      ((Element)v.get(87)).setAttribute("ID","EstDat" );
      ((Element)v.get(79)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */

      /* Empieza nodo:88 / Elemento padre: 79   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(88)).setAttribute("tipo","texto" );
      ((Element)v.get(88)).setAttribute("ID","EstDat" );
      ((Element)v.get(79)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */

      /* Empieza nodo:89 / Elemento padre: 79   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(89)).setAttribute("tipo","texto" );
      ((Element)v.get(89)).setAttribute("ID","EstDat" );
      ((Element)v.get(79)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */

      /* Empieza nodo:90 / Elemento padre: 79   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(90)).setAttribute("tipo","texto" );
      ((Element)v.get(90)).setAttribute("ID","EstDat" );
      ((Element)v.get(79)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */

      /* Empieza nodo:91 / Elemento padre: 79   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(91)).setAttribute("tipo","texto" );
      ((Element)v.get(91)).setAttribute("ID","EstDat" );
      ((Element)v.get(79)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 79   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(92)).setAttribute("tipo","texto" );
      ((Element)v.get(92)).setAttribute("ID","EstDat" );
      ((Element)v.get(79)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:79   */

      /* Empieza nodo:93 / Elemento padre: 41   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(41)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */

      /* Empieza nodo:94 / Elemento padre: 41   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(94)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(94)).setAttribute("ancho","400" );
      ((Element)v.get(94)).setAttribute("sep","$" );
      ((Element)v.get(94)).setAttribute("x","12" );
      ((Element)v.get(94)).setAttribute("class","botonera" );
      ((Element)v.get(94)).setAttribute("y","289" );
      ((Element)v.get(94)).setAttribute("control","|" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(94)).setAttribute("conector","conector_inc" );
      ((Element)v.get(94)).setAttribute("rowset","" );
      ((Element)v.get(94)).setAttribute("cargainicial","N" );
      ((Element)v.get(41)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(95)).setAttribute("nombre","ret1" );
      ((Element)v.get(95)).setAttribute("x","37" );
      ((Element)v.get(95)).setAttribute("y","293" );
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
      ((Element)v.get(96)).setAttribute("y","293" );
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
      /* Termina nodo:41   */

      /* Empieza nodo:97 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(97)).setAttribute("nombre","primera1" );
      ((Element)v.get(97)).setAttribute("x","20" );
      ((Element)v.get(97)).setAttribute("y","293" );
      ((Element)v.get(97)).setAttribute("ID","botonContenido" );
      ((Element)v.get(97)).setAttribute("img","primera_on" );
      ((Element)v.get(97)).setAttribute("tipo","-2" );
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
      ((Element)v.get(98)).setAttribute("y","289" );
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
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(99)).setAttribute("nombre","btnAceptar" );
      ((Element)v.get(99)).setAttribute("x","80" );
      ((Element)v.get(99)).setAttribute("y","290" );
      ((Element)v.get(99)).setAttribute("ID","botonContenido" );
      ((Element)v.get(99)).setAttribute("img","" );
      ((Element)v.get(99)).setAttribute("tipo","html" );
      ((Element)v.get(99)).setAttribute("estado","false" );
      ((Element)v.get(99)).setAttribute("cod","12" );
      ((Element)v.get(99)).setAttribute("accion","onClickAceptar()" );
      ((Element)v.get(6)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */

      /* Empieza nodo:100 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(100)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(100)).setAttribute("alto","12" );
      ((Element)v.get(100)).setAttribute("ancho","100" );
      ((Element)v.get(100)).setAttribute("colorf","" );
      ((Element)v.get(100)).setAttribute("borde","0" );
      ((Element)v.get(100)).setAttribute("imagenf","" );
      ((Element)v.get(100)).setAttribute("repeat","" );
      ((Element)v.get(100)).setAttribute("padding","" );
      ((Element)v.get(100)).setAttribute("visibilidad","visible" );
      ((Element)v.get(100)).setAttribute("contravsb","" );
      ((Element)v.get(100)).setAttribute("x","0" );
      ((Element)v.get(100)).setAttribute("y","293" );
      ((Element)v.get(100)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:6   */


   }

}
