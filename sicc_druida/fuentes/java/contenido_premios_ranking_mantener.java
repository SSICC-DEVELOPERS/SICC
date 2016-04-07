
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_premios_ranking_mantener  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_premios_ranking_mantener" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag()" );
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

      /* Elemento padre:5 / Elemento actual: 6   */
      v.add(doc.createTextNode("\r     \r      \r	function onLoadPag() {\r      configurarMenuSecundario('formulario');\r    \r      if(!fMostrarMensajeError()) {\r         \r          cargarPantalla();		         \r             \r          if(get('formulario.opcionMenu')==\"Consultar Concurso Ranking\"){  \r              deshabilitarPantalla();\r              btnProxy(1,0);\r              btnProxy(2,1);\r              btnProxy(3,0);\r              btnProxy(4,0);\r              btnProxy(5,0);\r              btnProxy(7,0);\r              btnProxy(8,0);\r              btnProxy(9,0);\r              \r          } else if(get('formulario.opcionMenu')==\"Modificar Concurso Ranking\"){  \r              btnProxy(1,1);\r              btnProxy(2,1);\r              btnProxy(3,0);\r              btnProxy(4,0);\r              btnProxy(5,1);\r              btnProxy(7,0);\r              btnProxy(8,0);\r              btnProxy(9,0);\r              \r              focaliza(\"formulario.txtNumNiveles\");\r              \r          } else {\r              focaliza(\"formulario.txtNumNiveles\");\r          }\r          \r      } \r      \r      finCargaPagina = true;\r\r	}\r  \r  function cargarPantalla() {\r            iSeleccionado = new Array(); \r      \r      iSeleccionado[0] = get('formulario.hCbPeriodoDespacho');\r      set('formulario.cbPeriodoDespacho', iSeleccionado);\r      \r            if(get('formulario.ckComunicacion')==\"N\")\r          accion('formulario.txtMensaje', '.disabled=true');\r      \r  }\r  \r  \r  function deshabilitarPantalla() {\r  \r      accion('formulario.txtNumNiveles', '.disabled=true');    \r      accion('formulario.cbPeriodoDespacho', '.disabled=true');     \r      accion('formulario.ckComunicacion', '.disabled=true');    \r      accion('formulario.txtMensaje', '.disabled=true');\r  }\r  \r  \r  function onChangeComunicacion() {\r      if(get('formulario.ckComunicacion')==\"S\") {\r         accion('formulario.txtMensaje', '.disabled=false');  \r      } else {\r         set('formulario.txtMensaje', '');         \r         accion('formulario.txtMensaje', '.disabled=true'); \r      }\r  }\r  \r  \r  function comprobarDatosObligatorios (){\r    var datosObligatorios = true;\r    \r    if(get('formulario.txtNumNiveles')== '')\r        datosObligatorios = false;\r    \r    return datosObligatorios;            \r  }\r  \r  \r  function fGuardar(){\r      if(sicc_validaciones_generales(\"gAlmacenar\")){\r\r          eval('formulario').oculto = 'S';\r          set('formulario.conectorAction', 'LPMantenerPremiosRanking');\r          set('formulario.accion', 'guardar');\r          set('formulario.datosObligatorios', comprobarDatosObligatorios());\r          enviaSICC('formulario','','','N');\r      }\r  }\r  \r  function guardarKO(){\r  \r      if(get('formulario.opcionMenu')==\"Modificar Concurso Ranking\"){  \r          btnProxy(1,1);\r          btnProxy(2,1);\r          btnProxy(3,0);\r          btnProxy(4,0);\r          btnProxy(5,1);\r          btnProxy(7,0);\r          btnProxy(8,0);\r          btnProxy(9,0);\r          \r          focaliza(\"formulario.txtNumNiveles\");\r          \r      } else {\r          focaliza(\"formulario.txtNumNiveles\");\r      }\r          \r  }\r\r  \r  \r  function accionDefinirNiveles(){\r  \r    if(sicc_validaciones_generales(\"gAlmacenar\")){\r                var obj = new Object();\r        obj.opcionMenu = get('formulario.opcionMenu')\r        obj.accion = 'cargar mantener nivel';\r        obj.numeroNiveles = get('formulario.txtNumNiveles');\r        \r        var retorno = mostrarModalSICC('LPMantenerPremiosRanking', 'cargar mantener nivel', obj, '795', '595');\r          \r        focaliza(\"formulario.txtNumNiveles\");			\r    }\r	}\r  \r  function fLimpiar(){\r      if(get('formulario.opcionMenu')==\"Crear Concurso Ranking\"){\r      \r          set('formulario.txtNumNiveles', '');  \r          set('formulario.cbPeriodoDespacho', '');    \r          set('formulario.ckComunicacion', 'N');    \r          set('formulario.txtMensaje', ''); \r          accion('formulario.txtMensaje', '.disabled=true');\r          \r          focaliza(\"formulario.txtNumNiveles\");\r          \r      } else {\r          set('formulario.conectorAction', 'LPMantenerPremiosRanking');\r          set('formulario.accion', '');\r          enviaSICC('formulario','','','N');\r      }\r  }\r  \r function fVolver(){\r      window.close();\r }\r\r  \r  function focalizaTab(){\r      focaliza(\"formulario.txtNumNiveles\");\r  }\r    \r  function focalizaShTab(){  \r      focalizaBotonHTML('botonContenido','btnDefinirNiveles');\r  }\r        \r  \r \r"));
      ((Element)v.get(5)).appendChild((Text)v.get(6));

      /* Termina nodo Texto:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(5)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","txtNumNiveles" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("min","0" );
      ((Element)v.get(8)).setAttribute("max","999" );
      ((Element)v.get(8)).setAttribute("format","e" );
      ((Element)v.get(8)).setAttribute("group","gAlmacenar" );
      ((Element)v.get(8)).setAttribute("cod","1818" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */
      /* Termina nodo:7   */
      /* Termina nodo:5   */

      /* Empieza nodo:9 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(9)).setAttribute("nombre","formulario" );
      ((Element)v.get(9)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(9));

      /* Empieza nodo:10 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","accion" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hPais" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hIdioma" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","datosObligatorios" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","idPestanyaDest" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hIndEstadoParametrosGerentes" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hIndEstadoParametrosConsultoras" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hIndEstadoVariablesVenta" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).setAttribute("nombre","oidParamGralesPremiacion" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","IND_INACTIVO" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","IND_ACTIVO" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hCbPeriodoDespacho" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","niveles" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","cantidadPremiosArticulos" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 9   */
      v.add(doc.createElement("table"));
      ((Element)v.get(28)).setAttribute("width","100%" );
      ((Element)v.get(28)).setAttribute("height","100%" );
      ((Element)v.get(28)).setAttribute("border","0" );
      ((Element)v.get(28)).setAttribute("align","center" );
      ((Element)v.get(28)).setAttribute("cellpadding","0" );
      ((Element)v.get(28)).setAttribute("cellspacing","0" );
      ((Element)v.get(28)).setAttribute("class","menu4" );
      ((Element)v.get(9)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(28)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(30)).setAttribute("width","12" );
      ((Element)v.get(30)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(30)).setAttribute("class","menu5texto" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(31)).setAttribute("src","b.gif" );
      ((Element)v.get(31)).setAttribute("width","12" );
      ((Element)v.get(31)).setAttribute("height","30" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */
      /* Termina nodo:30   */

      /* Empieza nodo:32 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(32)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(32)).setAttribute("class","menu5texto" );
      ((Element)v.get(29)).appendChild((Element)v.get(32));

      /* Elemento padre:32 / Elemento actual: 33   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(32)).appendChild((Text)v.get(33));

      /* Termina nodo Texto:33   */
      /* Termina nodo:32   */

      /* Empieza nodo:34 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(34)).setAttribute("width","10" );
      ((Element)v.get(34)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(34)).setAttribute("class","menu5texto" );
      ((Element)v.get(29)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(35)).setAttribute("src","b.gif" );
      ((Element)v.get(35)).setAttribute("width","10" );
      ((Element)v.get(35)).setAttribute("height","8" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:36 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).setAttribute("width","92" );
      ((Element)v.get(36)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(36)).setAttribute("class","menu5texto" );
      ((Element)v.get(29)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("table"));
      ((Element)v.get(37)).setAttribute("width","75" );
      ((Element)v.get(37)).setAttribute("border","1" );
      ((Element)v.get(37)).setAttribute("align","center" );
      ((Element)v.get(37)).setAttribute("cellpadding","1" );
      ((Element)v.get(37)).setAttribute("cellspacing","0" );
      ((Element)v.get(37)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(37)).setAttribute("onmouseover","activarPuntero('formulario',1,'lblDatosGenerales');" );
      ((Element)v.get(37)).setAttribute("onclick","onClickPestanyaHabilitada(1, 'formulario', 'LPMantenerPremiosRanking');" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).setAttribute("align","center" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(39)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(40)).setAttribute("nombre","lblDatosGenerales" );
      ((Element)v.get(40)).setAttribute("alto","13" );
      ((Element)v.get(40)).setAttribute("filas","1" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(40)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(40)).setAttribute("cod","0011" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */
      /* Termina nodo:39   */
      /* Termina nodo:38   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:41 / Elemento padre: 29   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).setAttribute("width","10" );
      ((Element)v.get(41)).setAttribute("class","menu5texto" );
      ((Element)v.get(29)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(42)).setAttribute("src","b.gif" );
      ((Element)v.get(42)).setAttribute("width","10" );
      ((Element)v.get(42)).setAttribute("height","8" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:43 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).setAttribute("width","20" );
      ((Element)v.get(43)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(43)).setAttribute("class","menu5texto" );
      ((Element)v.get(29)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("table"));
      ((Element)v.get(44)).setAttribute("width","75" );
      ((Element)v.get(44)).setAttribute("border","1" );
      ((Element)v.get(44)).setAttribute("align","center" );
      ((Element)v.get(44)).setAttribute("cellpadding","1" );
      ((Element)v.get(44)).setAttribute("cellspacing","0" );
      ((Element)v.get(44)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(44)).setAttribute("onmouseover","activarPuntero('formulario',2,'lblAlcanceGeografico');" );
      ((Element)v.get(44)).setAttribute("onclick","onClickPestanyaHabilitada(2, 'formulario', 'LPMantenerPremiosRanking');" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(45)).setAttribute("align","center" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(46)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(47)).setAttribute("nombre","lblAlcanceGeografico" );
      ((Element)v.get(47)).setAttribute("alto","13" );
      ((Element)v.get(47)).setAttribute("filas","1" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(47)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(47)).setAttribute("cod","00368" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */
      /* Termina nodo:45   */
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:48 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).setAttribute("width","10" );
      ((Element)v.get(48)).setAttribute("class","menu5texto" );
      ((Element)v.get(29)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).setAttribute("width","10" );
      ((Element)v.get(49)).setAttribute("height","8" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).setAttribute("width","20" );
      ((Element)v.get(50)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(50)).setAttribute("class","menu5texto" );
      ((Element)v.get(29)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("table"));
      ((Element)v.get(51)).setAttribute("width","75" );
      ((Element)v.get(51)).setAttribute("border","1" );
      ((Element)v.get(51)).setAttribute("align","center" );
      ((Element)v.get(51)).setAttribute("cellpadding","1" );
      ((Element)v.get(51)).setAttribute("cellspacing","0" );
      ((Element)v.get(51)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(51)).setAttribute("onmouseover","activarPuntero('formulario',3,'lblParametrosGerentes');" );
      ((Element)v.get(51)).setAttribute("onclick","onClickPestanyaHabilitada(3, 'formulario', 'LPMantenerPremiosRanking');" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(52)).setAttribute("align","center" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(53)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(54)).setAttribute("nombre","lblParametrosGerentes" );
      ((Element)v.get(54)).setAttribute("alto","13" );
      ((Element)v.get(54)).setAttribute("filas","1" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(54)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(54)).setAttribute("cod","00594" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */
      /* Termina nodo:52   */
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:55 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).setAttribute("width","10" );
      ((Element)v.get(55)).setAttribute("class","menu5texto" );
      ((Element)v.get(29)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(56)).setAttribute("src","b.gif" );
      ((Element)v.get(56)).setAttribute("width","10" );
      ((Element)v.get(56)).setAttribute("height","8" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:57 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).setAttribute("width","20" );
      ((Element)v.get(57)).setAttribute("nowrap","nowrap" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(57)).setAttribute("class","menu5texto" );
      ((Element)v.get(29)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("table"));
      ((Element)v.get(58)).setAttribute("width","75" );
      ((Element)v.get(58)).setAttribute("border","1" );
      ((Element)v.get(58)).setAttribute("align","center" );
      ((Element)v.get(58)).setAttribute("cellpadding","1" );
      ((Element)v.get(58)).setAttribute("cellspacing","0" );
      ((Element)v.get(58)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(58)).setAttribute("onmouseover","activarPuntero('formulario',4,'lblParametrosConsultoras');" );
      ((Element)v.get(58)).setAttribute("onclick","onClickPestanyaHabilitada(4, 'formulario', 'LPMantenerPremiosRanking');" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(59)).setAttribute("align","center" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(60)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(61)).setAttribute("nombre","lblParametrosConsultoras" );
      ((Element)v.get(61)).setAttribute("alto","13" );
      ((Element)v.get(61)).setAttribute("filas","1" );
      ((Element)v.get(61)).setAttribute("valor","" );
      ((Element)v.get(61)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(61)).setAttribute("cod","00595" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */
      /* Termina nodo:59   */
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:62 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).setAttribute("width","16" );
      ((Element)v.get(62)).setAttribute("class","menu5texto" );
      ((Element)v.get(29)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(63)).setAttribute("src","b.gif" );
      ((Element)v.get(63)).setAttribute("width","12" );
      ((Element)v.get(63)).setAttribute("height","8" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */
      /* Termina nodo:29   */
      /* Termina nodo:28   */

      /* Empieza nodo:64 / Elemento padre: 9   */
      v.add(doc.createElement("table"));
      ((Element)v.get(64)).setAttribute("width","100%" );
      ((Element)v.get(64)).setAttribute("height","100%" );
      ((Element)v.get(64)).setAttribute("border","0" );
      ((Element)v.get(64)).setAttribute("align","center" );
      ((Element)v.get(64)).setAttribute("cellpadding","0" );
      ((Element)v.get(64)).setAttribute("cellspacing","0" );
      ((Element)v.get(64)).setAttribute("class","menu4" );
      ((Element)v.get(9)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).setAttribute("width","12" );
      ((Element)v.get(66)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(66)).setAttribute("class","menu5texto" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(67)).setAttribute("src","b.gif" );
      ((Element)v.get(67)).setAttribute("width","12" );
      ((Element)v.get(67)).setAttribute("height","30" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:68 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(68)).setAttribute("class","menu5texto" );
      ((Element)v.get(65)).appendChild((Element)v.get(68));

      /* Elemento padre:68 / Elemento actual: 69   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(68)).appendChild((Text)v.get(69));

      /* Termina nodo Texto:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:70 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).setAttribute("width","10" );
      ((Element)v.get(70)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(70)).setAttribute("class","menu5texto" );
      ((Element)v.get(65)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(71)).setAttribute("src","b.gif" );
      ((Element)v.get(71)).setAttribute("width","10" );
      ((Element)v.get(71)).setAttribute("height","8" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:72 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).setAttribute("width","20" );
      ((Element)v.get(72)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(72)).setAttribute("class","menu5texto" );
      ((Element)v.get(65)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("table"));
      ((Element)v.get(73)).setAttribute("width","75" );
      ((Element)v.get(73)).setAttribute("border","1" );
      ((Element)v.get(73)).setAttribute("align","center" );
      ((Element)v.get(73)).setAttribute("cellpadding","1" );
      ((Element)v.get(73)).setAttribute("cellspacing","0" );
      ((Element)v.get(73)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(73)).setAttribute("onmouseover","activarPuntero('formulario',5,'lblProductos');" );
      ((Element)v.get(73)).setAttribute("onclick","onClickPestanyaHabilitada(5, 'formulario', 'LPMantenerPremiosRanking');" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(74)).setAttribute("align","center" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(75)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(76)).setAttribute("nombre","lblProductos" );
      ((Element)v.get(76)).setAttribute("alto","13" );
      ((Element)v.get(76)).setAttribute("filas","1" );
      ((Element)v.get(76)).setAttribute("valor","" );
      ((Element)v.get(76)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(76)).setAttribute("cod","0094" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:77 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).setAttribute("width","10" );
      ((Element)v.get(77)).setAttribute("class","menu5texto" );
      ((Element)v.get(65)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(78)).setAttribute("width","10" );
      ((Element)v.get(78)).setAttribute("height","8" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:79 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).setAttribute("width","20" );
      ((Element)v.get(79)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(79)).setAttribute("class","menu5texto" );
      ((Element)v.get(65)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("table"));
      ((Element)v.get(80)).setAttribute("width","75" );
      ((Element)v.get(80)).setAttribute("border","1" );
      ((Element)v.get(80)).setAttribute("align","center" );
      ((Element)v.get(80)).setAttribute("cellpadding","1" );
      ((Element)v.get(80)).setAttribute("cellspacing","0" );
      ((Element)v.get(80)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(80)).setAttribute("bgcolor","#496A9A" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(81)).setAttribute("align","center" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(82)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(83)).setAttribute("nombre","lblPremios" );
      ((Element)v.get(83)).setAttribute("alto","13" );
      ((Element)v.get(83)).setAttribute("filas","1" );
      ((Element)v.get(83)).setAttribute("valor","" );
      ((Element)v.get(83)).setAttribute("id","menu5textoblanca" );
      ((Element)v.get(83)).setAttribute("cod","00394" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:84 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).setAttribute("width","10" );
      ((Element)v.get(84)).setAttribute("class","menu5texto" );
      ((Element)v.get(65)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(85)).setAttribute("src","b.gif" );
      ((Element)v.get(85)).setAttribute("width","10" );
      ((Element)v.get(85)).setAttribute("height","8" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:86 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(86)).setAttribute("width","20" );
      ((Element)v.get(86)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(86)).setAttribute("class","menu5texto" );
      ((Element)v.get(65)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("table"));
      ((Element)v.get(87)).setAttribute("width","75" );
      ((Element)v.get(87)).setAttribute("border","1" );
      ((Element)v.get(87)).setAttribute("align","center" );
      ((Element)v.get(87)).setAttribute("cellpadding","1" );
      ((Element)v.get(87)).setAttribute("cellspacing","0" );
      ((Element)v.get(87)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(87)).setAttribute("onmouseover","activarPuntero('formulario',7,'lblVariablesVenta');" );
      ((Element)v.get(87)).setAttribute("onclick","onClickPestanyaHabilitada(7, 'formulario', 'LPMantenerPremiosRanking');" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(88)).setAttribute("align","center" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(89)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(90)).setAttribute("nombre","lblVariablesVenta" );
      ((Element)v.get(90)).setAttribute("alto","13" );
      ((Element)v.get(90)).setAttribute("filas","1" );
      ((Element)v.get(90)).setAttribute("valor","" );
      ((Element)v.get(90)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(90)).setAttribute("cod","1951" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:91 / Elemento padre: 65   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).setAttribute("width","16" );
      ((Element)v.get(91)).setAttribute("class","menu5texto" );
      ((Element)v.get(65)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(92)).setAttribute("width","12" );
      ((Element)v.get(92)).setAttribute("height","8" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:93 / Elemento padre: 9   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(93)).setAttribute("nombre","capa1" );
      ((Element)v.get(9)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("table"));
      ((Element)v.get(94)).setAttribute("width","100%" );
      ((Element)v.get(94)).setAttribute("border","0" );
      ((Element)v.get(94)).setAttribute("cellspacing","0" );
      ((Element)v.get(94)).setAttribute("cellpadding","0" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).setAttribute("width","12" );
      ((Element)v.get(96)).setAttribute("align","center" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(97)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).setAttribute("width","12" );
      ((Element)v.get(97)).setAttribute("height","12" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:98 / Elemento padre: 95   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).setAttribute("width","750" );
      ((Element)v.get(95)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(99)).setAttribute("src","b.gif" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:100 / Elemento padre: 95   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).setAttribute("width","12" );
      ((Element)v.get(95)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(101)).setAttribute("src","b.gif" );
      ((Element)v.get(101)).setAttribute("width","12" );
      ((Element)v.get(101)).setAttribute("height","1" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */
      /* Termina nodo:95   */

      /* Empieza nodo:102 / Elemento padre: 94   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(94)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(105)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(107)).setAttribute("class","legend" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(108)).setAttribute("nombre","lblDatosPremiosRanking" );
      ((Element)v.get(108)).setAttribute("alto","13" );
      ((Element)v.get(108)).setAttribute("filas","1" );
      ((Element)v.get(108)).setAttribute("valor","" );
      ((Element)v.get(108)).setAttribute("id","legend" );
      ((Element)v.get(108)).setAttribute("cod","00600" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 106   */
      v.add(doc.createElement("table"));
      ((Element)v.get(109)).setAttribute("width","100%" );
      ((Element)v.get(109)).setAttribute("border","0" );
      ((Element)v.get(109)).setAttribute("align","center" );
      ((Element)v.get(109)).setAttribute("cellspacing","0" );
      ((Element)v.get(109)).setAttribute("cellpadding","0" );
      ((Element)v.get(106)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("table"));
      ((Element)v.get(112)).setAttribute("width","413" );
      ((Element)v.get(112)).setAttribute("border","0" );
      ((Element)v.get(112)).setAttribute("align","left" );
      ((Element)v.get(112)).setAttribute("cellspacing","0" );
      ((Element)v.get(112)).setAttribute("cellpadding","0" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).setAttribute("colspan","4" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(115)).setAttribute("src","b.gif" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(115)).setAttribute("width","8" );
      ((Element)v.get(115)).setAttribute("height","8" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:116 / Elemento padre: 112   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(112)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(118)).setAttribute("src","b.gif" );
      ((Element)v.get(118)).setAttribute("width","8" );
      ((Element)v.get(118)).setAttribute("height","8" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:119 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(120)).setAttribute("nombre","lblNumNiveles" );
      ((Element)v.get(120)).setAttribute("alto","13" );
      ((Element)v.get(120)).setAttribute("filas","1" );
      ((Element)v.get(120)).setAttribute("valor","" );
      ((Element)v.get(120)).setAttribute("id","datosTitle" );
      ((Element)v.get(120)).setAttribute("cod","1818" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:121 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(122)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).setAttribute("width","25" );
      ((Element)v.get(122)).setAttribute("height","8" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:123 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(124)).setAttribute("nombre","lblPeriodoDespacho" );
      ((Element)v.get(124)).setAttribute("alto","13" );
      ((Element)v.get(124)).setAttribute("filas","1" );
      ((Element)v.get(124)).setAttribute("valor","" );
      ((Element)v.get(124)).setAttribute("id","datosTitle" );
      ((Element)v.get(124)).setAttribute("cod","1843" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:125 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(126)).setAttribute("src","b.gif" );
      ((Element)v.get(126)).setAttribute("width","25" );
      ((Element)v.get(126)).setAttribute("height","8" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:127 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(128)).setAttribute("nombre","lblComunicacion" );
      ((Element)v.get(128)).setAttribute("alto","13" );
      ((Element)v.get(128)).setAttribute("filas","1" );
      ((Element)v.get(128)).setAttribute("valor","" );
      ((Element)v.get(128)).setAttribute("id","datosTitle" );
      ((Element)v.get(128)).setAttribute("cod","1812" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:129 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(130)).setAttribute("src","b.gif" );
      ((Element)v.get(130)).setAttribute("width","25" );
      ((Element)v.get(130)).setAttribute("height","8" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:131 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(132)).setAttribute("nombre","lblMensaje" );
      ((Element)v.get(132)).setAttribute("alto","13" );
      ((Element)v.get(132)).setAttribute("filas","1" );
      ((Element)v.get(132)).setAttribute("valor","" );
      ((Element)v.get(132)).setAttribute("id","datosTitle" );
      ((Element)v.get(132)).setAttribute("cod","531" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:133 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).setAttribute("width","100%" );
      ((Element)v.get(116)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(134)).setAttribute("src","b.gif" );
      ((Element)v.get(134)).setAttribute("width","8" );
      ((Element)v.get(134)).setAttribute("height","8" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */
      /* Termina nodo:116   */

      /* Empieza nodo:135 / Elemento padre: 112   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(112)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("td"));
      ((Element)v.get(135)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(137)).setAttribute("src","b.gif" );
      ((Element)v.get(137)).setAttribute("width","8" );
      ((Element)v.get(137)).setAttribute("height","8" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:138 / Elemento padre: 135   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(135)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(139)).setAttribute("nombre","txtNumNiveles" );
      ((Element)v.get(139)).setAttribute("id","datosCampos" );
      ((Element)v.get(139)).setAttribute("max","3" );
      ((Element)v.get(139)).setAttribute("tipo","" );
      ((Element)v.get(139)).setAttribute("onchange","" );
      ((Element)v.get(139)).setAttribute("req","S" );
      ((Element)v.get(139)).setAttribute("size","3" );
      ((Element)v.get(139)).setAttribute("valor","" );
      ((Element)v.get(139)).setAttribute("onshtab","focalizaShTab();" );
      ((Element)v.get(139)).setAttribute("validacion","" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */

      /* Empieza nodo:140 / Elemento padre: 135   */
      v.add(doc.createElement("td"));
      ((Element)v.get(135)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(141)).setAttribute("src","b.gif" );
      ((Element)v.get(141)).setAttribute("width","25" );
      ((Element)v.get(141)).setAttribute("height","8" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:142 / Elemento padre: 135   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(135)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(143)).setAttribute("nombre","cbPeriodoDespacho" );
      ((Element)v.get(143)).setAttribute("id","datosCampos" );
      ((Element)v.get(143)).setAttribute("size","1" );
      ((Element)v.get(143)).setAttribute("multiple","N" );
      ((Element)v.get(143)).setAttribute("req","N" );
      ((Element)v.get(143)).setAttribute("valorinicial","" );
      ((Element)v.get(143)).setAttribute("textoinicial","" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:142   */

      /* Empieza nodo:145 / Elemento padre: 135   */
      v.add(doc.createElement("td"));
      ((Element)v.get(135)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(146)).setAttribute("src","b.gif" );
      ((Element)v.get(146)).setAttribute("width","25" );
      ((Element)v.get(146)).setAttribute("height","8" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */

      /* Empieza nodo:147 / Elemento padre: 135   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(147)).setAttribute("valign","top" );
      ((Element)v.get(135)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(148)).setAttribute("check","" );
      ((Element)v.get(148)).setAttribute("id","" );
      ((Element)v.get(148)).setAttribute("msjreq","" );
      ((Element)v.get(148)).setAttribute("nombre","ckComunicacion" );
      ((Element)v.get(148)).setAttribute("onclick","onChangeComunicacion()" );
      ((Element)v.get(148)).setAttribute("onfocus","" );
      ((Element)v.get(148)).setAttribute("readonly","" );
      ((Element)v.get(148)).setAttribute("req","" );
      ((Element)v.get(148)).setAttribute("tabindex","1" );
      ((Element)v.get(148)).setAttribute("texto","" );
      ((Element)v.get(148)).setAttribute("validacion","" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */

      /* Empieza nodo:149 / Elemento padre: 135   */
      v.add(doc.createElement("td"));
      ((Element)v.get(135)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(150)).setAttribute("src","b.gif" );
      ((Element)v.get(150)).setAttribute("width","25" );
      ((Element)v.get(150)).setAttribute("height","8" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */

      /* Empieza nodo:151 / Elemento padre: 135   */
      v.add(doc.createElement("td"));
      ((Element)v.get(151)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(135)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(152)).setAttribute("nombre","txtMensaje" );
      ((Element)v.get(152)).setAttribute("id","datosCampos" );
      ((Element)v.get(152)).setAttribute("max","5" );
      ((Element)v.get(152)).setAttribute("tipo","" );
      ((Element)v.get(152)).setAttribute("onchange","" );
      ((Element)v.get(152)).setAttribute("req","N" );
      ((Element)v.get(152)).setAttribute("size","5" );
      ((Element)v.get(152)).setAttribute("valor","" );
      ((Element)v.get(152)).setAttribute("validacion","" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:153 / Elemento padre: 135   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).setAttribute("width","100%" );
      ((Element)v.get(135)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(154)).setAttribute("src","b.gif" );
      ((Element)v.get(154)).setAttribute("width","8" );
      ((Element)v.get(154)).setAttribute("height","8" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */
      /* Termina nodo:135   */

      /* Empieza nodo:155 / Elemento padre: 112   */
      v.add(doc.createElement("tr"));
   }

   private void getXML720(Document doc) {
      ((Element)v.get(112)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("td"));
      ((Element)v.get(156)).setAttribute("colspan","4" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(157)).setAttribute("src","b.gif" );
      ((Element)v.get(157)).setAttribute("width","8" );
      ((Element)v.get(157)).setAttribute("height","8" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:156   */
      /* Termina nodo:155   */
      /* Termina nodo:112   */
      /* Termina nodo:111   */
      /* Termina nodo:110   */
      /* Termina nodo:109   */
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:158 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(159)).setAttribute("src","b.gif" );
      ((Element)v.get(159)).setAttribute("width","8" );
      ((Element)v.get(159)).setAttribute("height","12" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */
      /* Termina nodo:102   */

      /* Empieza nodo:160 / Elemento padre: 94   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(94)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(162)).setAttribute("src","b.gif" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:163 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(163)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("table"));
      ((Element)v.get(165)).setAttribute("width","100%" );
      ((Element)v.get(165)).setAttribute("border","0" );
      ((Element)v.get(165)).setAttribute("align","center" );
      ((Element)v.get(165)).setAttribute("cellspacing","0" );
      ((Element)v.get(165)).setAttribute("cellpadding","0" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(165)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).setAttribute("class","botonera" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(168)).setAttribute("nombre","btnDefinirNiveles" );
      ((Element)v.get(168)).setAttribute("ID","botonContenido" );
      ((Element)v.get(168)).setAttribute("tipo","html" );
      ((Element)v.get(168)).setAttribute("accion","accionDefinirNiveles()" );
      ((Element)v.get(168)).setAttribute("estado","false" );
      ((Element)v.get(168)).setAttribute("ontab","focalizaTab();" );
      ((Element)v.get(168)).setAttribute("cod","1801" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */
      /* Termina nodo:166   */
      /* Termina nodo:165   */
      /* Termina nodo:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:169 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(170)).setAttribute("src","b.gif" );
      ((Element)v.get(170)).setAttribute("width","8" );
      ((Element)v.get(170)).setAttribute("height","12" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */
      /* Termina nodo:160   */

      /* Empieza nodo:171 / Elemento padre: 94   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(94)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).setAttribute("width","12" );
      ((Element)v.get(172)).setAttribute("align","center" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(173)).setAttribute("src","b.gif" );
      ((Element)v.get(173)).setAttribute("width","12" );
      ((Element)v.get(173)).setAttribute("height","12" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:172   */

      /* Empieza nodo:174 / Elemento padre: 171   */
      v.add(doc.createElement("td"));
      ((Element)v.get(174)).setAttribute("width","750" );
      ((Element)v.get(171)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(175)).setAttribute("src","b.gif" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */

      /* Empieza nodo:176 / Elemento padre: 171   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).setAttribute("width","12" );
      ((Element)v.get(171)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(177)).setAttribute("src","b.gif" );
      ((Element)v.get(177)).setAttribute("width","12" );
      ((Element)v.get(177)).setAttribute("height","12" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */
      /* Termina nodo:171   */
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:9   */


   }

}
