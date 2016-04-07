
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_concurso_seleccionado_consultar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_concurso_seleccionado_consultar" );
      ((Element)v.get(0)).setAttribute("cod","0945" );
      ((Element)v.get(0)).setAttribute("titulo","Consulta general de concursos" );
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
      v.add(doc.createTextNode("\r     \r      \r         function onLoadPag() {\r                  configurarMenuSecundario(\"frmFormulario\");\r                  configurarBotonesPorDefecto();\r                  asignarLabels();\r                  cargarLista();\r                  focoBotonDatosPersonales();\r         }\r\r\r         function configurarBotonesPorDefecto() {\r                                    \r                  document.all[\"btnRecomendacion\"].disabled = true;\r                  document.all[\"btnMultinivel\"].disabled = true;\r\r                                    if (get(\"frmFormulario.recomendacion\") == \"habilitar\") {\r                           document.all[\"btnRecomendacion\"].disabled = false;\r                  }\r\r                  if (get(\"frmFormulario.multinivel\") == \"habilitar\") {\r                           document.all[\"btnMultinivel\"].disabled = false;\r                  }\r         }\r\r         function mostrarListaResultados() {\r                  DrdEnsanchaConMargenDcho('listado1',12);	    \r             document.all[\"Cplistado1\"].style.visibility='';\r             document.all[\"CpLin1listado1\"].style.visibility='';\r             document.all[\"CpLin2listado1\"].style.visibility='';\r             document.all[\"CpLin3listado1\"].style.visibility='';\r             document.all[\"CpLin4listado1\"].style.visibility='';\r             document.all[\"primera1Div\"].style.visibility='';\r             document.all[\"ret1Div\"].style.visibility='';\r             document.all[\"ava1Div\"].style.visibility='';\r             document.all[\"separaDiv\"].style.visibility='';\r             eval (ON_RSZ); \r         }\r\r         function cargarLista() {\r                  var arr = new Array();\r\r                  arr[arr.length] = \r                  new Array(\"oidConcurso\", get(\"frmFormulario.oidConcurso\")+\"\"); \r                  arr[arr.length] = \r                  new Array(\"oidCliente\", get(\"frmFormulario.oidCliente\")+\"\");\r                  arr[arr.length] = \r                  new Array(\"numeroConcurso\", get(\"frmFormulario.numeroConcurso\")+\"\");\r                  arr[arr.length] = \r                  new Array(\"oidRegion\", get(\"frmFormulario.oidRegion\")+\"\"); \r                  arr[arr.length] = \r                  new Array(\"oidZona\", get(\"frmFormulario.oidZona\")+\"\");\r                  arr[arr.length] = \r                  new Array(\"oidSeccion\", get(\"frmFormulario.oidSeccion\")+\"\"); 		\r                  arr[arr.length] = \r                  new Array(\"oidPais\", get(\"frmFormulario.oidPais\")+\"\");		\r                  arr[arr.length] = \r                  new Array(\"oidIdioma\", get(\"frmFormulario.oidIdioma\")+\"\"); \r      \r                  configurarPaginado(mipgndo,\"INCConsultarDetalleConcursoSeleccionado\", \r                  \"ConectorConsultarDetalleConcursoSelecCC\",\r                  \"es.indra.sicc.dtos.inc.DTOCabeceraConsultaIntegral\",arr);\r         }\r\r         function asignarLabels() {\r                  txt_to('lbldtCodCliente', get(\"frmFormulario.codigoCliente\"));\r                  txt_to('lbldtNombreApellido', get(\"frmFormulario.nombreApellidos\"));\r                  txt_to('lbldtNumConcurso', get(\"frmFormulario.numeroConcurso\"));\r                  txt_to('lbldtDescripcion', get(\"frmFormulario.descripcionConcurso\"));\r                  txt_to('lbldtPeriodoInicial', get(\"frmFormulario.periodoInicial\"));\r                  txt_to('lbldtPeriodoFinal', get(\"frmFormulario.periodoFinal\"));\r                  txt_to('lbldtNivelAlcanzado', get(\"frmFormulario.nivelAlcanzado\"));\r                  txt_to('lbldtSituacion', get(\"frmFormulario.situacion\"));\r                                    txt_to('lbldtTotalPuntaje', get(\"frmFormulario.totalPuntaje\"));\r                  txt_to('lbldtCodDuplacyz', get(\"frmFormulario.codDuplaCyz\"));\r                  txt_to('lbldtNombreDuplacyz', get(\"frmFormulario.nombreDuplaCyz\"));\r\r                  txt_to('lbldtVentaBase', get(\"frmFormulario.ventaBase\"));\r                  txt_to('lbldtTotalPuntajeObtenido', get(\"frmFormulario.totalPuntajeObtenido\"));\r                  txt_to('lbldtTotalPuntajePerdido', get(\"frmFormulario.totalPuntajePerdido\"));\r                  txt_to('lbldtTotalPuntajeUtilizado', get(\"frmFormulario.totalPuntajeUtilizado\"));\r                  txt_to('lbldtSaldoPuntaje', get(\"frmFormulario.saldoPuntaje\"));\r                  txt_to('lbldtPuntajeDisponible', get(\"frmFormulario.puntajeDisponible\"));\r         }\r\r         function focoBotonDatosPersonales() {\r                  focalizaBotonHTML('botonContenido','btnDatosPersonales');\r         }	\r\r         function focoBotonMotivos() {\r                  focalizaBotonHTML('botonContenido','btnMotivoDescalificacion');\r         }\r\r         function accionDatosPersonales() {\r                  var obj = new Object();\r                  obj.dtoOid = get(\"frmFormulario.oidCliente\");\r                  var retorno = mostrarModalSICC('LPBusquedaCliente', 'consultar', obj);\r         }\r\r         function accionDatosGenerales() {\r                  var obj = new Object();\r                  obj.opcionMenu = \"Consultar Concurso\";\r                  obj.oidConcurso = get(\"frmFormulario.oidConcurso\");\r                  obj.oidPlantilla = get(\"frmFormulario.oidPlantilla\");\r                  var retorno = mostrarModalSICC('LPMantenerParametrosGenerales', '', obj);\r         } \r\r         function accionRecomendacion() {		\r                  var obj = new Object();\r                  var retorno = mostrarModalSICC('LPConsultaIntegralVarios', \r                  'consultarRecomendacionPart', obj);	\r         }\r\r         function accionMultinivel() {\r                  var obj = new Object();\r                  var retorno = mostrarModalSICC('LPConsultaConcursoSeleccionado', \r                  'consultarMultinivel', obj);	\r         }\r         \r         function accionPremiosSeleccionados() {\r                  var obj = new Object();\r                  var retorno = mostrarModalSICC('LPConsultaIntegralVarios', \r                  'consultaPremiosSeleccionadosPart', obj);	\r         } \r         \r         function accionPremiosProcesados() {\r                  var obj = new Object();\r                  var retorno = mostrarModalSICC('LPConsultaConcursoSeleccionado', \r                  'consultarPremiosProcesados', obj);	\r         } \r         \r         function accionMotivosDescalificacion() {\r                  var obj = new Object();\r                  var retorno = mostrarModalSICC('LPConsultaIntegralVarios', \r                  'consultarMotivosDescalificacionPart', obj);	\r         } 	\r\r             function accionDetalleSolicitudes() {\r                  var obj = new Object();\r                  var retorno = mostrarModalSICC('LPConsultaConcursoSeleccionado', \r                  'consultarDetalleSolicitudes', obj);	\r         } 	\r\r         function fVolver() {\r                  window.close();\r         }\r         \r         function muestraLista(ultima, rowset, error){\r                  mostrarListaResultados();\r                  return true;\r         }\r\r  \r  "));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(6)).setAttribute("nombre","frmFormulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","accion" );
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
      ((Element)v.get(11)).setAttribute("nombre","oidPais" );
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
      ((Element)v.get(13)).setAttribute("nombre","codigoCliente" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","nombreApellidos" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","numeroConcurso" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","descripcionConcurso" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","periodoInicial" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","periodoFinal" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","oidConcurso" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","oidCliente" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","oidRegion" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","oidZona" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 6   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","oidSeccion" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","oidPlantilla" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","recomendacion" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","multinivel" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","nivelAlcanzado" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","situacion" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","totalPuntaje" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","codDuplaCyz" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","nombreDuplaCyz" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","ventaBase" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","totalPuntajeObtenido" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","totalPuntajePerdido" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","totalPuntajeUtilizado" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","saldoPuntaje" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","puntajeDisponible" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","dtoOid" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(39)).setAttribute("nombre","capaEspacio1" );
      ((Element)v.get(39)).setAttribute("x","0" );
      ((Element)v.get(39)).setAttribute("y","0" );
      ((Element)v.get(6)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("table"));
      ((Element)v.get(40)).setAttribute("width","100%" );
      ((Element)v.get(40)).setAttribute("border","0" );
      ((Element)v.get(40)).setAttribute("cellspacing","0" );
      ((Element)v.get(40)).setAttribute("cellpadding","0" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).setAttribute("width","12" );
      ((Element)v.get(42)).setAttribute("align","center" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(43)).setAttribute("src","b.gif" );
      ((Element)v.get(43)).setAttribute("width","12" );
      ((Element)v.get(43)).setAttribute("height","12" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:44 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).setAttribute("width","750" );
      ((Element)v.get(41)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(45)).setAttribute("src","b.gif" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:46 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).setAttribute("width","12" );
      ((Element)v.get(41)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(47)).setAttribute("src","b.gif" );
      ((Element)v.get(47)).setAttribute("width","12" );
      ((Element)v.get(47)).setAttribute("height","1" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */
      /* Termina nodo:41   */

      /* Empieza nodo:48 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(50)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:51 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(53)).setAttribute("class","legend" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(54)).setAttribute("nombre","lblDatosCabecera" );
      ((Element)v.get(54)).setAttribute("alto","13" );
      ((Element)v.get(54)).setAttribute("filas","1" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(54)).setAttribute("id","legend" );
      ((Element)v.get(54)).setAttribute("cod","00156" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:55 / Elemento padre: 52   */
      v.add(doc.createElement("table"));
      ((Element)v.get(55)).setAttribute("width","100%" );
      ((Element)v.get(55)).setAttribute("border","0" );
      ((Element)v.get(55)).setAttribute("align","center" );
      ((Element)v.get(55)).setAttribute("cellspacing","0" );
      ((Element)v.get(55)).setAttribute("cellpadding","0" );
      ((Element)v.get(52)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("table"));
      ((Element)v.get(58)).setAttribute("width","600" );
      ((Element)v.get(58)).setAttribute("border","0" );
      ((Element)v.get(58)).setAttribute("align","left" );
      ((Element)v.get(58)).setAttribute("cellspacing","0" );
      ((Element)v.get(58)).setAttribute("cellpadding","0" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).setAttribute("colspan","3" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(61)).setAttribute("src","b.gif" );
      ((Element)v.get(61)).setAttribute("width","8" );
      ((Element)v.get(61)).setAttribute("height","8" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:62 / Elemento padre: 58   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(58)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(64)).setAttribute("src","b.gif" );
      ((Element)v.get(64)).setAttribute("width","8" );
      ((Element)v.get(64)).setAttribute("height","8" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(66)).setAttribute("nombre","lblCodCliente" );
      ((Element)v.get(66)).setAttribute("alto","13" );
      ((Element)v.get(66)).setAttribute("filas","1" );
      ((Element)v.get(66)).setAttribute("valor","" );
      ((Element)v.get(66)).setAttribute("id","datosTitle" );
      ((Element)v.get(66)).setAttribute("cod","263" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:67 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).setAttribute("width","100%" );
      ((Element)v.get(62)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(68)).setAttribute("width","8" );
      ((Element)v.get(68)).setAttribute("height","8" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:62   */

      /* Empieza nodo:69 / Elemento padre: 58   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(58)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(71)).setAttribute("src","b.gif" );
      ((Element)v.get(71)).setAttribute("width","8" );
      ((Element)v.get(71)).setAttribute("height","8" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:72 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(73)).setAttribute("nombre","lbldtCodCliente" );
      ((Element)v.get(73)).setAttribute("alto","13" );
      ((Element)v.get(73)).setAttribute("filas","1" );
      ((Element)v.get(73)).setAttribute("valor","" );
      ((Element)v.get(73)).setAttribute("id","datosCampos" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:74 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).setAttribute("width","100%" );
      ((Element)v.get(69)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(75)).setAttribute("width","8" );
      ((Element)v.get(75)).setAttribute("height","8" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:69   */

      /* Empieza nodo:76 / Elemento padre: 58   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(58)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).setAttribute("colspan","3" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(78)).setAttribute("width","8" );
      ((Element)v.get(78)).setAttribute("height","8" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */
      /* Termina nodo:76   */
      /* Termina nodo:58   */
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:79 / Elemento padre: 55   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(55)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("table"));
      ((Element)v.get(81)).setAttribute("width","600" );
      ((Element)v.get(81)).setAttribute("border","0" );
      ((Element)v.get(81)).setAttribute("align","left" );
      ((Element)v.get(81)).setAttribute("cellspacing","0" );
      ((Element)v.get(81)).setAttribute("cellpadding","0" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(81)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(84)).setAttribute("src","b.gif" );
      ((Element)v.get(84)).setAttribute("width","8" );
      ((Element)v.get(84)).setAttribute("height","8" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:85 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(86)).setAttribute("nombre","lblNombreApellido" );
      ((Element)v.get(86)).setAttribute("alto","13" );
      ((Element)v.get(86)).setAttribute("filas","1" );
      ((Element)v.get(86)).setAttribute("valor","" );
      ((Element)v.get(86)).setAttribute("id","datosTitle" );
      ((Element)v.get(86)).setAttribute("cod","943" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).setAttribute("width","100%" );
      ((Element)v.get(82)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(88)).setAttribute("src","b.gif" );
      ((Element)v.get(88)).setAttribute("width","8" );
      ((Element)v.get(88)).setAttribute("height","8" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */
      /* Termina nodo:82   */

      /* Empieza nodo:89 / Elemento padre: 81   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(81)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(91)).setAttribute("src","b.gif" );
      ((Element)v.get(91)).setAttribute("width","8" );
      ((Element)v.get(91)).setAttribute("height","8" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:92 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(93)).setAttribute("nombre","lbldtNombreApellido" );
      ((Element)v.get(93)).setAttribute("alto","13" );
      ((Element)v.get(93)).setAttribute("filas","1" );
      ((Element)v.get(93)).setAttribute("valor","" );
      ((Element)v.get(93)).setAttribute("id","datosCampos" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:94 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(94)).setAttribute("width","100%" );
      ((Element)v.get(89)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(95)).setAttribute("src","b.gif" );
      ((Element)v.get(95)).setAttribute("width","8" );
      ((Element)v.get(95)).setAttribute("height","8" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:89   */

      /* Empieza nodo:96 / Elemento padre: 81   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(81)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).setAttribute("colspan","3" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(98)).setAttribute("src","b.gif" );
      ((Element)v.get(98)).setAttribute("width","8" );
      ((Element)v.get(98)).setAttribute("height","8" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:96   */
      /* Termina nodo:81   */
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:99 / Elemento padre: 55   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(55)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("table"));
      ((Element)v.get(101)).setAttribute("width","600" );
      ((Element)v.get(101)).setAttribute("border","0" );
      ((Element)v.get(101)).setAttribute("align","left" );
      ((Element)v.get(101)).setAttribute("cellspacing","0" );
      ((Element)v.get(101)).setAttribute("cellpadding","0" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(104)).setAttribute("width","8" );
      ((Element)v.get(104)).setAttribute("height","8" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(106)).setAttribute("nombre","lblNumConcurso" );
      ((Element)v.get(106)).setAttribute("alto","13" );
      ((Element)v.get(106)).setAttribute("filas","1" );
      ((Element)v.get(106)).setAttribute("valor","" );
      ((Element)v.get(106)).setAttribute("id","datosTitle" );
      ((Element)v.get(106)).setAttribute("cod","1604" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:107 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(108)).setAttribute("src","b.gif" );
      ((Element)v.get(108)).setAttribute("width","25" );
      ((Element)v.get(108)).setAttribute("height","8" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(110)).setAttribute("nombre","lblDescripcion" );
      ((Element)v.get(110)).setAttribute("alto","13" );
      ((Element)v.get(110)).setAttribute("filas","1" );
      ((Element)v.get(110)).setAttribute("valor","" );
      ((Element)v.get(110)).setAttribute("id","datosTitle" );
      ((Element)v.get(110)).setAttribute("cod","9" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:111 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).setAttribute("width","100%" );
      ((Element)v.get(102)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(112)).setAttribute("src","b.gif" );
      ((Element)v.get(112)).setAttribute("width","8" );
      ((Element)v.get(112)).setAttribute("height","8" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */
      /* Termina nodo:102   */

      /* Empieza nodo:113 / Elemento padre: 101   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(101)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(115)).setAttribute("src","b.gif" );
      ((Element)v.get(115)).setAttribute("width","8" );
      ((Element)v.get(115)).setAttribute("height","8" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:116 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(117)).setAttribute("nombre","lbldtNumConcurso" );
      ((Element)v.get(117)).setAttribute("alto","13" );
      ((Element)v.get(117)).setAttribute("filas","1" );
      ((Element)v.get(117)).setAttribute("valor","" );
      ((Element)v.get(117)).setAttribute("id","datosCampos" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 113   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(119)).setAttribute("src","b.gif" );
      ((Element)v.get(119)).setAttribute("width","25" );
      ((Element)v.get(119)).setAttribute("height","8" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:120 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(121)).setAttribute("nombre","lbldtDescripcion" );
      ((Element)v.get(121)).setAttribute("alto","13" );
      ((Element)v.get(121)).setAttribute("filas","1" );
      ((Element)v.get(121)).setAttribute("valor","" );
      ((Element)v.get(121)).setAttribute("id","datosCampos" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:122 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).setAttribute("width","100%" );
      ((Element)v.get(113)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(123)).setAttribute("src","b.gif" );
      ((Element)v.get(123)).setAttribute("width","8" );
      ((Element)v.get(123)).setAttribute("height","8" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */
      /* Termina nodo:113   */

      /* Empieza nodo:124 / Elemento padre: 101   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(101)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).setAttribute("colspan","3" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(126)).setAttribute("src","b.gif" );
      ((Element)v.get(126)).setAttribute("width","8" );
      ((Element)v.get(126)).setAttribute("height","8" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:101   */
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:127 / Elemento padre: 55   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(55)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("table"));
      ((Element)v.get(129)).setAttribute("width","600" );
      ((Element)v.get(129)).setAttribute("border","0" );
      ((Element)v.get(129)).setAttribute("align","left" );
      ((Element)v.get(129)).setAttribute("cellspacing","0" );
      ((Element)v.get(129)).setAttribute("cellpadding","0" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(132)).setAttribute("src","b.gif" );
      ((Element)v.get(132)).setAttribute("width","8" );
      ((Element)v.get(132)).setAttribute("height","8" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:133 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(134)).setAttribute("nombre","lblPeriodoInicial" );
      ((Element)v.get(134)).setAttribute("alto","13" );
      ((Element)v.get(134)).setAttribute("filas","1" );
      ((Element)v.get(134)).setAttribute("valor","" );
      ((Element)v.get(134)).setAttribute("id","datosTitle" );
      ((Element)v.get(134)).setAttribute("cod","2631" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:135 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(136)).setAttribute("src","b.gif" );
      ((Element)v.get(136)).setAttribute("width","25" );
      ((Element)v.get(136)).setAttribute("height","8" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:137 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(138)).setAttribute("nombre","lblPeriodoFinal" );
      ((Element)v.get(138)).setAttribute("alto","13" );
      ((Element)v.get(138)).setAttribute("filas","1" );
      ((Element)v.get(138)).setAttribute("valor","" );
      ((Element)v.get(138)).setAttribute("id","datosTitle" );
      ((Element)v.get(138)).setAttribute("cod","2632" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:139 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(140)).setAttribute("src","b.gif" );
      ((Element)v.get(140)).setAttribute("width","25" );
      ((Element)v.get(140)).setAttribute("height","8" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:141 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(142)).setAttribute("nombre","lblNivelAlcanzado" );
      ((Element)v.get(142)).setAttribute("alto","13" );
      ((Element)v.get(142)).setAttribute("filas","1" );
      ((Element)v.get(142)).setAttribute("valor","" );
      ((Element)v.get(142)).setAttribute("id","datosTitle" );
      ((Element)v.get(142)).setAttribute("cod","2875" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:143 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(144)).setAttribute("src","b.gif" );
      ((Element)v.get(144)).setAttribute("width","25" );
      ((Element)v.get(144)).setAttribute("height","8" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */

      /* Empieza nodo:145 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(146)).setAttribute("nombre","lblSituacion" );
      ((Element)v.get(146)).setAttribute("alto","13" );
      ((Element)v.get(146)).setAttribute("filas","1" );
      ((Element)v.get(146)).setAttribute("valor","" );
      ((Element)v.get(146)).setAttribute("id","datosTitle" );
      ((Element)v.get(146)).setAttribute("cod","695" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */

      /* Empieza nodo:147 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).setAttribute("width","100%" );
      ((Element)v.get(130)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(148)).setAttribute("src","b.gif" );
      ((Element)v.get(148)).setAttribute("width","8" );
      ((Element)v.get(148)).setAttribute("height","8" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */
      /* Termina nodo:130   */

      /* Empieza nodo:149 / Elemento padre: 129   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(129)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(151)).setAttribute("src","b.gif" );
      ((Element)v.get(151)).setAttribute("width","8" );
      ((Element)v.get(151)).setAttribute("height","8" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:152 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(153)).setAttribute("nombre","lbldtPeriodoInicial" );
      ((Element)v.get(153)).setAttribute("alto","13" );
      ((Element)v.get(153)).setAttribute("filas","1" );
      ((Element)v.get(153)).setAttribute("valor","" );
      ((Element)v.get(153)).setAttribute("id","datosCampos" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */

      /* Empieza nodo:154 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(155)).setAttribute("src","b.gif" );
      ((Element)v.get(155)).setAttribute("width","25" );
      ((Element)v.get(155)).setAttribute("height","8" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */

      /* Empieza nodo:156 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(157)).setAttribute("nombre","lbldtPeriodoFinal" );
      ((Element)v.get(157)).setAttribute("alto","13" );
      ((Element)v.get(157)).setAttribute("filas","1" );
      ((Element)v.get(157)).setAttribute("valor","" );
      ((Element)v.get(157)).setAttribute("id","datosCampos" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:156   */

      /* Empieza nodo:158 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(159)).setAttribute("src","b.gif" );
      ((Element)v.get(159)).setAttribute("width","25" );
      ((Element)v.get(159)).setAttribute("height","8" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */

      /* Empieza nodo:160 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(161)).setAttribute("nombre","lbldtNivelAlcanzado" );
      ((Element)v.get(161)).setAttribute("alto","13" );
      ((Element)v.get(161)).setAttribute("filas","1" );
      ((Element)v.get(161)).setAttribute("valor","" );
      ((Element)v.get(161)).setAttribute("id","datosCampos" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:162 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(163)).setAttribute("src","b.gif" );
      ((Element)v.get(163)).setAttribute("width","25" );
      ((Element)v.get(163)).setAttribute("height","8" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */

      /* Empieza nodo:164 / Elemento padre: 149   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(165)).setAttribute("nombre","lbldtSituacion" );
      ((Element)v.get(165)).setAttribute("alto","13" );
      ((Element)v.get(165)).setAttribute("filas","1" );
      ((Element)v.get(165)).setAttribute("valor","" );
      ((Element)v.get(165)).setAttribute("id","datosCampos" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */

      /* Empieza nodo:166 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(166)).setAttribute("width","100%" );
      ((Element)v.get(149)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(167)).setAttribute("src","b.gif" );
      ((Element)v.get(167)).setAttribute("width","8" );
      ((Element)v.get(167)).setAttribute("height","8" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */
      /* Termina nodo:149   */

      /* Empieza nodo:168 / Elemento padre: 129   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(129)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("td"));
      ((Element)v.get(169)).setAttribute("colspan","3" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(170)).setAttribute("src","b.gif" );
      ((Element)v.get(170)).setAttribute("width","8" );
      ((Element)v.get(170)).setAttribute("height","8" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */
      /* Termina nodo:168   */
      /* Termina nodo:129   */
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:171 / Elemento padre: 55   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(55)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("td"));
      ((Element)v.get(171)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("table"));
      ((Element)v.get(173)).setAttribute("width","600" );
      ((Element)v.get(173)).setAttribute("border","0" );
      ((Element)v.get(173)).setAttribute("align","left" );
      ((Element)v.get(173)).setAttribute("cellspacing","0" );
      ((Element)v.get(173)).setAttribute("cellpadding","0" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(173)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(174)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(176)).setAttribute("src","b.gif" );
      ((Element)v.get(176)).setAttribute("width","8" );
      ((Element)v.get(176)).setAttribute("height","8" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:177 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(174)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(178)).setAttribute("nombre","lblTotalpuntahe" );
      ((Element)v.get(178)).setAttribute("alto","13" );
      ((Element)v.get(178)).setAttribute("filas","1" );
      ((Element)v.get(178)).setAttribute("valor","" );
      ((Element)v.get(178)).setAttribute("id","datosTitle" );
      ((Element)v.get(178)).setAttribute("cod","2886" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */

      /* Empieza nodo:179 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(174)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(180)).setAttribute("src","b.gif" );
      ((Element)v.get(180)).setAttribute("width","25" );
      ((Element)v.get(180)).setAttribute("height","8" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:181 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(174)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(182)).setAttribute("nombre","lblCodDuplacyz" );
      ((Element)v.get(182)).setAttribute("alto","13" );
      ((Element)v.get(182)).setAttribute("filas","1" );
      ((Element)v.get(182)).setAttribute("valor","" );
      ((Element)v.get(182)).setAttribute("id","datosTitle" );
      ((Element)v.get(182)).setAttribute("cod","3376" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:183 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(174)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(184)).setAttribute("src","b.gif" );
      ((Element)v.get(184)).setAttribute("width","25" );
      ((Element)v.get(184)).setAttribute("height","8" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:185 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(174)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(186)).setAttribute("nombre","lblNombreDuplacyz" );
      ((Element)v.get(186)).setAttribute("alto","13" );
      ((Element)v.get(186)).setAttribute("filas","1" );
      ((Element)v.get(186)).setAttribute("valor","" );
      ((Element)v.get(186)).setAttribute("id","datosTitle" );
      ((Element)v.get(186)).setAttribute("cod","3377" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:187 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(174)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(188)).setAttribute("src","b.gif" );
      ((Element)v.get(188)).setAttribute("width","25" );
      ((Element)v.get(188)).setAttribute("height","8" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:189 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(174)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(190)).setAttribute("nombre","lblVentaBase" );
      ((Element)v.get(190)).setAttribute("alto","13" );
      ((Element)v.get(190)).setAttribute("filas","1" );
      ((Element)v.get(190)).setAttribute("valor","" );
      ((Element)v.get(190)).setAttribute("id","datosTitle" );
      ((Element)v.get(190)).setAttribute("cod","3364" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:191 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(191)).setAttribute("width","100%" );
      ((Element)v.get(174)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(192)).setAttribute("src","b.gif" );
      ((Element)v.get(192)).setAttribute("width","8" );
      ((Element)v.get(192)).setAttribute("height","8" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */
      /* Termina nodo:174   */

      /* Empieza nodo:193 / Elemento padre: 173   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(173)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(195)).setAttribute("src","b.gif" );
      ((Element)v.get(195)).setAttribute("width","8" );
      ((Element)v.get(195)).setAttribute("height","8" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */

      /* Empieza nodo:196 / Elemento padre: 193   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(197)).setAttribute("nombre","lbldtTotalPuntaje" );
      ((Element)v.get(197)).setAttribute("alto","13" );
      ((Element)v.get(197)).setAttribute("filas","1" );
      ((Element)v.get(197)).setAttribute("valor","" );
      ((Element)v.get(197)).setAttribute("id","datosCampos" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:196   */

      /* Empieza nodo:198 / Elemento padre: 193   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(199)).setAttribute("src","b.gif" );
      ((Element)v.get(199)).setAttribute("width","25" );
      ((Element)v.get(199)).setAttribute("height","8" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:198   */

      /* Empieza nodo:200 / Elemento padre: 193   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(201)).setAttribute("nombre","lbldtCodDuplacyz" );
      ((Element)v.get(201)).setAttribute("alto","13" );
      ((Element)v.get(201)).setAttribute("filas","1" );
      ((Element)v.get(201)).setAttribute("valor","" );
      ((Element)v.get(201)).setAttribute("id","datosCampos" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */

      /* Empieza nodo:202 / Elemento padre: 193   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(203)).setAttribute("src","b.gif" );
      ((Element)v.get(203)).setAttribute("width","25" );
      ((Element)v.get(203)).setAttribute("height","8" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */

      /* Empieza nodo:204 / Elemento padre: 193   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(205)).setAttribute("nombre","lbldtNombreDuplacyz" );
      ((Element)v.get(205)).setAttribute("alto","13" );
      ((Element)v.get(205)).setAttribute("filas","1" );
      ((Element)v.get(205)).setAttribute("valor","" );
      ((Element)v.get(205)).setAttribute("id","datosCampos" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */
      /* Termina nodo:204   */

      /* Empieza nodo:206 / Elemento padre: 193   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(207)).setAttribute("src","b.gif" );
      ((Element)v.get(207)).setAttribute("width","25" );
      ((Element)v.get(207)).setAttribute("height","8" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:208 / Elemento padre: 193   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(209)).setAttribute("nombre","lbldtVentaBase" );
      ((Element)v.get(209)).setAttribute("alto","13" );
      ((Element)v.get(209)).setAttribute("filas","1" );
      ((Element)v.get(209)).setAttribute("valor","" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(209)).setAttribute("id","datosCampos" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:210 / Elemento padre: 193   */
      v.add(doc.createElement("td"));
      ((Element)v.get(210)).setAttribute("width","100%" );
      ((Element)v.get(193)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(211)).setAttribute("src","b.gif" );
      ((Element)v.get(211)).setAttribute("width","8" );
      ((Element)v.get(211)).setAttribute("height","8" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */
      /* Termina nodo:193   */

      /* Empieza nodo:212 / Elemento padre: 173   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(173)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("td"));
      ((Element)v.get(213)).setAttribute("colspan","3" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(214)).setAttribute("src","b.gif" );
      ((Element)v.get(214)).setAttribute("width","8" );
      ((Element)v.get(214)).setAttribute("height","8" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */
      /* Termina nodo:212   */
      /* Termina nodo:173   */
      /* Termina nodo:172   */
      /* Termina nodo:171   */
      /* Termina nodo:55   */
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:215 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(216)).setAttribute("src","b.gif" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */
      /* Termina nodo:215   */
      /* Termina nodo:48   */

      /* Empieza nodo:217 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("td"));
      ((Element)v.get(218)).setAttribute("colspan","3" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(219)).setAttribute("src","b.gif" );
      ((Element)v.get(219)).setAttribute("width","12" );
      ((Element)v.get(219)).setAttribute("height","365" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */
      /* Termina nodo:217   */

      /* Empieza nodo:220 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("td"));
      ((Element)v.get(220)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(222)).setAttribute("src","b.gif" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:221   */

      /* Empieza nodo:223 / Elemento padre: 220   */
      v.add(doc.createElement("td"));
      ((Element)v.get(220)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(223)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(225)).setAttribute("class","legend" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(226)).setAttribute("nombre","lblResumen" );
      ((Element)v.get(226)).setAttribute("alto","13" );
      ((Element)v.get(226)).setAttribute("filas","1" );
      ((Element)v.get(226)).setAttribute("valor","" );
      ((Element)v.get(226)).setAttribute("id","legend" );
      ((Element)v.get(226)).setAttribute("cod","2890" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */
      /* Termina nodo:225   */

      /* Empieza nodo:227 / Elemento padre: 224   */
      v.add(doc.createElement("table"));
      ((Element)v.get(227)).setAttribute("width","100%" );
      ((Element)v.get(227)).setAttribute("border","0" );
      ((Element)v.get(227)).setAttribute("align","center" );
      ((Element)v.get(227)).setAttribute("cellspacing","0" );
      ((Element)v.get(227)).setAttribute("cellpadding","0" );
      ((Element)v.get(224)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(227)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("td"));
      ((Element)v.get(228)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("table"));
      ((Element)v.get(230)).setAttribute("width","600" );
      ((Element)v.get(230)).setAttribute("border","0" );
      ((Element)v.get(230)).setAttribute("align","left" );
      ((Element)v.get(230)).setAttribute("cellspacing","0" );
      ((Element)v.get(230)).setAttribute("cellpadding","0" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(230)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("td"));
      ((Element)v.get(232)).setAttribute("colspan","3" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(233)).setAttribute("src","b.gif" );
      ((Element)v.get(233)).setAttribute("width","8" );
      ((Element)v.get(233)).setAttribute("height","8" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */
      /* Termina nodo:232   */
      /* Termina nodo:231   */

      /* Empieza nodo:234 / Elemento padre: 230   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(230)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("td"));
      ((Element)v.get(234)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(236)).setAttribute("src","b.gif" );
      ((Element)v.get(236)).setAttribute("width","8" );
      ((Element)v.get(236)).setAttribute("height","8" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */
      /* Termina nodo:235   */

      /* Empieza nodo:237 / Elemento padre: 234   */
      v.add(doc.createElement("td"));
      ((Element)v.get(234)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(238)).setAttribute("nombre","lblTotalPuntajeObtenido" );
      ((Element)v.get(238)).setAttribute("alto","13" );
      ((Element)v.get(238)).setAttribute("filas","1" );
      ((Element)v.get(238)).setAttribute("valor","" );
      ((Element)v.get(238)).setAttribute("id","datosTitle" );
      ((Element)v.get(238)).setAttribute("cod","2883" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:237   */

      /* Empieza nodo:239 / Elemento padre: 234   */
      v.add(doc.createElement("td"));
      ((Element)v.get(234)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(240)).setAttribute("src","b.gif" );
      ((Element)v.get(240)).setAttribute("width","25" );
      ((Element)v.get(240)).setAttribute("height","8" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:239   */

      /* Empieza nodo:241 / Elemento padre: 234   */
      v.add(doc.createElement("td"));
      ((Element)v.get(234)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(242)).setAttribute("nombre","lblTotalPuntajePerdido" );
      ((Element)v.get(242)).setAttribute("alto","13" );
      ((Element)v.get(242)).setAttribute("filas","1" );
      ((Element)v.get(242)).setAttribute("valor","" );
      ((Element)v.get(242)).setAttribute("id","datosTitle" );
      ((Element)v.get(242)).setAttribute("cod","2884" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:241   */

      /* Empieza nodo:243 / Elemento padre: 234   */
      v.add(doc.createElement("td"));
      ((Element)v.get(234)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(244)).setAttribute("src","b.gif" );
      ((Element)v.get(244)).setAttribute("width","25" );
      ((Element)v.get(244)).setAttribute("height","8" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */
      /* Termina nodo:243   */

      /* Empieza nodo:245 / Elemento padre: 234   */
      v.add(doc.createElement("td"));
      ((Element)v.get(234)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(246)).setAttribute("nombre","lblTotalPuntajeUtilizado" );
      ((Element)v.get(246)).setAttribute("alto","13" );
      ((Element)v.get(246)).setAttribute("filas","1" );
      ((Element)v.get(246)).setAttribute("valor","" );
      ((Element)v.get(246)).setAttribute("id","datosTitle" );
      ((Element)v.get(246)).setAttribute("cod","2885" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */
      /* Termina nodo:245   */

      /* Empieza nodo:247 / Elemento padre: 234   */
      v.add(doc.createElement("td"));
      ((Element)v.get(247)).setAttribute("width","100%" );
      ((Element)v.get(234)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(248)).setAttribute("src","b.gif" );
      ((Element)v.get(248)).setAttribute("width","8" );
      ((Element)v.get(248)).setAttribute("height","8" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */
      /* Termina nodo:247   */
      /* Termina nodo:234   */

      /* Empieza nodo:249 / Elemento padre: 230   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(230)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("td"));
      ((Element)v.get(249)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(251)).setAttribute("src","b.gif" );
      ((Element)v.get(251)).setAttribute("width","8" );
      ((Element)v.get(251)).setAttribute("height","8" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:250   */

      /* Empieza nodo:252 / Elemento padre: 249   */
      v.add(doc.createElement("td"));
      ((Element)v.get(249)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(253)).setAttribute("nombre","lbldtTotalPuntajeObtenido" );
      ((Element)v.get(253)).setAttribute("alto","13" );
      ((Element)v.get(253)).setAttribute("filas","1" );
      ((Element)v.get(253)).setAttribute("valor","" );
      ((Element)v.get(253)).setAttribute("id","datosCampos" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */
      /* Termina nodo:252   */

      /* Empieza nodo:254 / Elemento padre: 249   */
      v.add(doc.createElement("td"));
      ((Element)v.get(249)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(255)).setAttribute("src","b.gif" );
      ((Element)v.get(255)).setAttribute("width","25" );
      ((Element)v.get(255)).setAttribute("height","8" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */
      /* Termina nodo:254   */

      /* Empieza nodo:256 / Elemento padre: 249   */
      v.add(doc.createElement("td"));
      ((Element)v.get(249)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(257)).setAttribute("nombre","lbldtTotalPuntajePerdido" );
      ((Element)v.get(257)).setAttribute("alto","13" );
      ((Element)v.get(257)).setAttribute("filas","1" );
      ((Element)v.get(257)).setAttribute("valor","" );
      ((Element)v.get(257)).setAttribute("id","datosCampos" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */
      /* Termina nodo:256   */

      /* Empieza nodo:258 / Elemento padre: 249   */
   }

   private void getXML990(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(249)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(259)).setAttribute("src","b.gif" );
      ((Element)v.get(259)).setAttribute("width","25" );
      ((Element)v.get(259)).setAttribute("height","8" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */
      /* Termina nodo:258   */

      /* Empieza nodo:260 / Elemento padre: 249   */
      v.add(doc.createElement("td"));
      ((Element)v.get(249)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(261)).setAttribute("nombre","lbldtTotalPuntajeUtilizado" );
      ((Element)v.get(261)).setAttribute("alto","13" );
      ((Element)v.get(261)).setAttribute("filas","1" );
      ((Element)v.get(261)).setAttribute("valor","" );
      ((Element)v.get(261)).setAttribute("id","datosCampos" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */
      /* Termina nodo:260   */

      /* Empieza nodo:262 / Elemento padre: 249   */
      v.add(doc.createElement("td"));
      ((Element)v.get(262)).setAttribute("width","100%" );
      ((Element)v.get(249)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(263)).setAttribute("src","b.gif" );
      ((Element)v.get(263)).setAttribute("width","8" );
      ((Element)v.get(263)).setAttribute("height","8" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:262   */
      /* Termina nodo:249   */

      /* Empieza nodo:264 / Elemento padre: 230   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(230)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("td"));
      ((Element)v.get(265)).setAttribute("colspan","3" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(266)).setAttribute("src","b.gif" );
      ((Element)v.get(266)).setAttribute("width","8" );
      ((Element)v.get(266)).setAttribute("height","8" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */
      /* Termina nodo:265   */
      /* Termina nodo:264   */
      /* Termina nodo:230   */
      /* Termina nodo:229   */
      /* Termina nodo:228   */

      /* Empieza nodo:267 / Elemento padre: 227   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(227)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("td"));
      ((Element)v.get(267)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("table"));
      ((Element)v.get(269)).setAttribute("width","600" );
      ((Element)v.get(269)).setAttribute("border","0" );
      ((Element)v.get(269)).setAttribute("align","left" );
      ((Element)v.get(269)).setAttribute("cellspacing","0" );
      ((Element)v.get(269)).setAttribute("cellpadding","0" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(269)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("td"));
      ((Element)v.get(270)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(272)).setAttribute("src","b.gif" );
      ((Element)v.get(272)).setAttribute("width","8" );
      ((Element)v.get(272)).setAttribute("height","8" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */
      /* Termina nodo:271   */

      /* Empieza nodo:273 / Elemento padre: 270   */
      v.add(doc.createElement("td"));
      ((Element)v.get(270)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(274)).setAttribute("nombre","lblSaldoPuntaje" );
      ((Element)v.get(274)).setAttribute("alto","13" );
      ((Element)v.get(274)).setAttribute("filas","1" );
      ((Element)v.get(274)).setAttribute("valor","" );
      ((Element)v.get(274)).setAttribute("id","datosTitle" );
      ((Element)v.get(274)).setAttribute("cod","2886" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */
      /* Termina nodo:273   */

      /* Empieza nodo:275 / Elemento padre: 270   */
      v.add(doc.createElement("td"));
      ((Element)v.get(270)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(276)).setAttribute("src","b.gif" );
      ((Element)v.get(276)).setAttribute("width","25" );
      ((Element)v.get(276)).setAttribute("height","8" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:275   */

      /* Empieza nodo:277 / Elemento padre: 270   */
      v.add(doc.createElement("td"));
      ((Element)v.get(270)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(278)).setAttribute("nombre","lblPuntajeDisponible" );
      ((Element)v.get(278)).setAttribute("alto","13" );
      ((Element)v.get(278)).setAttribute("filas","1" );
      ((Element)v.get(278)).setAttribute("valor","" );
      ((Element)v.get(278)).setAttribute("id","datosTitle" );
      ((Element)v.get(278)).setAttribute("cod","2887" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */
      /* Termina nodo:277   */

      /* Empieza nodo:279 / Elemento padre: 270   */
      v.add(doc.createElement("td"));
      ((Element)v.get(279)).setAttribute("width","100%" );
      ((Element)v.get(270)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(280)).setAttribute("src","b.gif" );
      ((Element)v.get(280)).setAttribute("width","8" );
      ((Element)v.get(280)).setAttribute("height","8" );
      ((Element)v.get(279)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */
      /* Termina nodo:279   */
      /* Termina nodo:270   */

      /* Empieza nodo:281 / Elemento padre: 269   */
      v.add(doc.createElement("tr"));
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(269)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
      ((Element)v.get(281)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(283)).setAttribute("src","b.gif" );
      ((Element)v.get(283)).setAttribute("width","8" );
      ((Element)v.get(283)).setAttribute("height","8" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */
      /* Termina nodo:282   */

      /* Empieza nodo:284 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
      ((Element)v.get(281)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(285)).setAttribute("nombre","lbldtSaldoPuntaje" );
      ((Element)v.get(285)).setAttribute("alto","13" );
      ((Element)v.get(285)).setAttribute("filas","1" );
      ((Element)v.get(285)).setAttribute("valor","" );
      ((Element)v.get(285)).setAttribute("id","datosCampos" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */
      /* Termina nodo:284   */

      /* Empieza nodo:286 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
      ((Element)v.get(281)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(287)).setAttribute("src","b.gif" );
      ((Element)v.get(287)).setAttribute("width","25" );
      ((Element)v.get(287)).setAttribute("height","8" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */
      /* Termina nodo:286   */

      /* Empieza nodo:288 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
      ((Element)v.get(281)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(289)).setAttribute("nombre","lbldtPuntajeDisponible" );
      ((Element)v.get(289)).setAttribute("alto","13" );
      ((Element)v.get(289)).setAttribute("filas","1" );
      ((Element)v.get(289)).setAttribute("valor","" );
      ((Element)v.get(289)).setAttribute("id","datosCampos" );
      ((Element)v.get(288)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */
      /* Termina nodo:288   */

      /* Empieza nodo:290 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
      ((Element)v.get(290)).setAttribute("width","100%" );
      ((Element)v.get(281)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(291)).setAttribute("src","b.gif" );
      ((Element)v.get(291)).setAttribute("width","8" );
      ((Element)v.get(291)).setAttribute("height","8" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */
      /* Termina nodo:290   */
      /* Termina nodo:281   */

      /* Empieza nodo:292 / Elemento padre: 269   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(269)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("td"));
      ((Element)v.get(293)).setAttribute("colspan","3" );
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
      /* Termina nodo:269   */
      /* Termina nodo:268   */
      /* Termina nodo:267   */
      /* Termina nodo:227   */
      /* Termina nodo:224   */
      /* Termina nodo:223   */

      /* Empieza nodo:295 / Elemento padre: 220   */
      v.add(doc.createElement("td"));
      ((Element)v.get(220)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(296)).setAttribute("src","b.gif" );
      ((Element)v.get(295)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */
      /* Termina nodo:295   */
      /* Termina nodo:220   */

      /* Empieza nodo:297 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("td"));
      ((Element)v.get(297)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(299)).setAttribute("src","b.gif" );
      ((Element)v.get(298)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */
      /* Termina nodo:298   */

      /* Empieza nodo:300 / Elemento padre: 297   */
      v.add(doc.createElement("td"));
      ((Element)v.get(297)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(300)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("table"));
      ((Element)v.get(302)).setAttribute("width","100%" );
      ((Element)v.get(302)).setAttribute("border","0" );
      ((Element)v.get(302)).setAttribute("align","center" );
      ((Element)v.get(302)).setAttribute("cellspacing","0" );
      ((Element)v.get(302)).setAttribute("cellpadding","0" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(302)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("td"));
      ((Element)v.get(304)).setAttribute("class","botonera" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(305)).setAttribute("nombre","btnDatosPersonales" );
      ((Element)v.get(305)).setAttribute("ID","botonContenido" );
      ((Element)v.get(305)).setAttribute("tipo","html" );
      ((Element)v.get(305)).setAttribute("accion","accionDatosPersonales();" );
      ((Element)v.get(305)).setAttribute("estado","false" );
      ((Element)v.get(305)).setAttribute("cod","00508" );
      ((Element)v.get(305)).setAttribute("onshtab","focoBotonMotivos();" );
      ((Element)v.get(304)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */

      /* Empieza nodo:306 / Elemento padre: 304   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(306)).setAttribute("nombre","btnDatosGenerales" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(306)).setAttribute("ID","botonContenido" );
      ((Element)v.get(306)).setAttribute("tipo","html" );
      ((Element)v.get(306)).setAttribute("accion","accionDatosGenerales();" );
      ((Element)v.get(306)).setAttribute("estado","false" );
      ((Element)v.get(306)).setAttribute("cod","0011" );
      ((Element)v.get(304)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */

      /* Empieza nodo:307 / Elemento padre: 304   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(307)).setAttribute("nombre","btnMultinivel" );
      ((Element)v.get(307)).setAttribute("ID","botonContenido" );
      ((Element)v.get(307)).setAttribute("tipo","html" );
      ((Element)v.get(307)).setAttribute("accion","accionMultinivel();" );
      ((Element)v.get(307)).setAttribute("estado","false" );
      ((Element)v.get(307)).setAttribute("cod","00400" );
      ((Element)v.get(304)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */

      /* Empieza nodo:308 / Elemento padre: 304   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(308)).setAttribute("nombre","btnPremiosSeleccionados" );
      ((Element)v.get(308)).setAttribute("ID","botonContenido" );
      ((Element)v.get(308)).setAttribute("tipo","html" );
      ((Element)v.get(308)).setAttribute("accion","accionPremiosSeleccionados();" );
      ((Element)v.get(308)).setAttribute("estado","false" );
      ((Element)v.get(308)).setAttribute("cod","2873" );
      ((Element)v.get(304)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */

      /* Empieza nodo:309 / Elemento padre: 304   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(309)).setAttribute("nombre","btnPremiosProcesados" );
      ((Element)v.get(309)).setAttribute("ID","botonContenido" );
      ((Element)v.get(309)).setAttribute("tipo","html" );
      ((Element)v.get(309)).setAttribute("accion","accionPremiosProcesados();" );
      ((Element)v.get(309)).setAttribute("estado","false" );
      ((Element)v.get(309)).setAttribute("cod","2871" );
      ((Element)v.get(304)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */
      /* Termina nodo:304   */
      /* Termina nodo:303   */

      /* Empieza nodo:310 / Elemento padre: 302   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(302)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(311)).setAttribute("class","botonera" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(312)).setAttribute("nombre","btnRecomendacion" );
      ((Element)v.get(312)).setAttribute("ID","botonContenido" );
      ((Element)v.get(312)).setAttribute("tipo","html" );
      ((Element)v.get(312)).setAttribute("accion","accionRecomendacion();" );
      ((Element)v.get(312)).setAttribute("estado","false" );
      ((Element)v.get(312)).setAttribute("cod","2872" );
      ((Element)v.get(311)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */

      /* Empieza nodo:313 / Elemento padre: 311   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(313)).setAttribute("nombre","btnMotivoDescalificacion" );
      ((Element)v.get(313)).setAttribute("ID","botonContenido" );
      ((Element)v.get(313)).setAttribute("tipo","html" );
      ((Element)v.get(313)).setAttribute("accion","accionMotivosDescalificacion();" );
      ((Element)v.get(313)).setAttribute("estado","false" );
      ((Element)v.get(313)).setAttribute("cod","2874" );
      ((Element)v.get(311)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */

      /* Empieza nodo:314 / Elemento padre: 311   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(314)).setAttribute("nombre","btnDetalleSolicitudes" );
      ((Element)v.get(314)).setAttribute("ID","botonContenido" );
      ((Element)v.get(314)).setAttribute("tipo","html" );
      ((Element)v.get(314)).setAttribute("accion","accionDetalleSolicitudes();" );
      ((Element)v.get(314)).setAttribute("estado","false" );
      ((Element)v.get(314)).setAttribute("cod","3394" );
      ((Element)v.get(314)).setAttribute("ontab","focoBotonDatosPersonales();" );
      ((Element)v.get(311)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */
      /* Termina nodo:311   */
      /* Termina nodo:310   */
      /* Termina nodo:302   */
      /* Termina nodo:301   */
      /* Termina nodo:300   */

      /* Empieza nodo:315 / Elemento padre: 297   */
      v.add(doc.createElement("td"));
      ((Element)v.get(297)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(316)).setAttribute("src","b.gif" );
      ((Element)v.get(316)).setAttribute("width","8" );
      ((Element)v.get(316)).setAttribute("height","12" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */
      /* Termina nodo:315   */
      /* Termina nodo:297   */

      /* Empieza nodo:317 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("td"));
      ((Element)v.get(318)).setAttribute("width","12" );
      ((Element)v.get(318)).setAttribute("align","center" );
      ((Element)v.get(317)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(319)).setAttribute("src","b.gif" );
      ((Element)v.get(319)).setAttribute("width","12" );
      ((Element)v.get(319)).setAttribute("height","12" );
      ((Element)v.get(318)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */
      /* Termina nodo:318   */

      /* Empieza nodo:320 / Elemento padre: 317   */
      v.add(doc.createElement("td"));
      ((Element)v.get(320)).setAttribute("width","756" );
      ((Element)v.get(317)).appendChild((Element)v.get(320));

      /* Empieza nodo:321 / Elemento padre: 320   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(321)).setAttribute("src","b.gif" );
      ((Element)v.get(320)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */
      /* Termina nodo:320   */

      /* Empieza nodo:322 / Elemento padre: 317   */
      v.add(doc.createElement("td"));
      ((Element)v.get(322)).setAttribute("width","12" );
      ((Element)v.get(317)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(323)).setAttribute("src","b.gif" );
      ((Element)v.get(323)).setAttribute("width","12" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(323)).setAttribute("height","1" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */
      /* Termina nodo:322   */
      /* Termina nodo:317   */
      /* Termina nodo:40   */
      /* Termina nodo:39   */

      /* Empieza nodo:324 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(324)).setAttribute("nombre","listado1" );
      ((Element)v.get(324)).setAttribute("ancho","604" );
      ((Element)v.get(324)).setAttribute("alto","317" );
      ((Element)v.get(324)).setAttribute("x","12" );
      ((Element)v.get(324)).setAttribute("y","210" );
      ((Element)v.get(324)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(324)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(325)).setAttribute("precarga","S" );
      ((Element)v.get(325)).setAttribute("conROver","S" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(326)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(326)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(326)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(326)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(325)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */

      /* Empieza nodo:327 / Elemento padre: 325   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(327)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(327)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(327)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(327)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(325)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */

      /* Empieza nodo:328 / Elemento padre: 325   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(328)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(328)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(325)).appendChild((Element)v.get(328));
      /* Termina nodo:328   */
      /* Termina nodo:325   */

      /* Empieza nodo:329 / Elemento padre: 324   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(324)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(330)).setAttribute("borde","1" );
      ((Element)v.get(330)).setAttribute("horizDatos","1" );
      ((Element)v.get(330)).setAttribute("horizCabecera","1" );
      ((Element)v.get(330)).setAttribute("vertical","1" );
      ((Element)v.get(330)).setAttribute("horizTitulo","1" );
      ((Element)v.get(330)).setAttribute("horizBase","1" );
      ((Element)v.get(329)).appendChild((Element)v.get(330));
      /* Termina nodo:330   */

      /* Empieza nodo:331 / Elemento padre: 329   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(331)).setAttribute("borde","#999999" );
      ((Element)v.get(331)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(331)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(331)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(331)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(331)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(331)).setAttribute("horizBase","#999999" );
      ((Element)v.get(329)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */
      /* Termina nodo:329   */

      /* Empieza nodo:332 / Elemento padre: 324   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(332)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(332)).setAttribute("alto","22" );
      ((Element)v.get(332)).setAttribute("imgFondo","" );
      ((Element)v.get(332)).setAttribute("cod","00133" );
      ((Element)v.get(332)).setAttribute("ID","datosTitle" );
      ((Element)v.get(324)).appendChild((Element)v.get(332));
      /* Termina nodo:332   */

      /* Empieza nodo:333 / Elemento padre: 324   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(333)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(333)).setAttribute("alto","22" );
      ((Element)v.get(333)).setAttribute("imgFondo","" );
      ((Element)v.get(324)).appendChild((Element)v.get(333));
      /* Termina nodo:333   */

      /* Empieza nodo:334 / Elemento padre: 324   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(334)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(334)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(334)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(334)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(334)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(334)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(324)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(335)).setAttribute("ancho","60" );
      ((Element)v.get(335)).setAttribute("minimizable","S" );
      ((Element)v.get(335)).setAttribute("minimizada","N" );
      ((Element)v.get(334)).appendChild((Element)v.get(335));
      /* Termina nodo:335   */

      /* Empieza nodo:336 / Elemento padre: 334   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(336)).setAttribute("ancho","120" );
      ((Element)v.get(336)).setAttribute("minimizable","S" );
      ((Element)v.get(336)).setAttribute("minimizada","N" );
      ((Element)v.get(336)).setAttribute("orden","dd-mm-aaaa" );
      ((Element)v.get(334)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */

      /* Empieza nodo:337 / Elemento padre: 334   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(337)).setAttribute("ancho","100" );
      ((Element)v.get(337)).setAttribute("minimizable","S" );
      ((Element)v.get(337)).setAttribute("minimizada","N" );
      ((Element)v.get(334)).appendChild((Element)v.get(337));
      /* Termina nodo:337   */

      /* Empieza nodo:338 / Elemento padre: 334   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(338)).setAttribute("ancho","150" );
      ((Element)v.get(338)).setAttribute("minimizable","S" );
      ((Element)v.get(338)).setAttribute("minimizada","N" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(334)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */

      /* Empieza nodo:339 / Elemento padre: 334   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(339)).setAttribute("ancho","150" );
      ((Element)v.get(339)).setAttribute("minimizable","S" );
      ((Element)v.get(339)).setAttribute("minimizada","N" );
      ((Element)v.get(334)).appendChild((Element)v.get(339));
      /* Termina nodo:339   */

      /* Empieza nodo:340 / Elemento padre: 334   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(340)).setAttribute("ancho","150" );
      ((Element)v.get(340)).setAttribute("minimizable","S" );
      ((Element)v.get(340)).setAttribute("minimizada","N" );
      ((Element)v.get(340)).setAttribute("orden","dd-mm-aaaa" );
      ((Element)v.get(334)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */
      /* Termina nodo:334   */

      /* Empieza nodo:341 / Elemento padre: 324   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(341)).setAttribute("alto","20" );
      ((Element)v.get(341)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(341)).setAttribute("imgFondo","" );
      ((Element)v.get(341)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(324)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(342)).setAttribute("colFondo","" );
      ((Element)v.get(342)).setAttribute("ID","EstCab" );
      ((Element)v.get(342)).setAttribute("cod","276" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));

      /* Elemento padre:342 / Elemento actual: 343   */
      v.add(doc.createTextNode("Período"));
      ((Element)v.get(342)).appendChild((Text)v.get(343));

      /* Termina nodo Texto:343   */
      /* Termina nodo:342   */

      /* Empieza nodo:344 / Elemento padre: 341   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(344)).setAttribute("colFondo","" );
      ((Element)v.get(344)).setAttribute("ID","EstCab" );
      ((Element)v.get(344)).setAttribute("cod","651" );
      ((Element)v.get(341)).appendChild((Element)v.get(344));

      /* Elemento padre:344 / Elemento actual: 345   */
      v.add(doc.createTextNode("Fecha movimiento"));
      ((Element)v.get(344)).appendChild((Text)v.get(345));

      /* Termina nodo Texto:345   */
      /* Termina nodo:344   */

      /* Empieza nodo:346 / Elemento padre: 341   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(346)).setAttribute("colFondo","" );
      ((Element)v.get(346)).setAttribute("ID","EstCab" );
      ((Element)v.get(346)).setAttribute("cod","304" );
      ((Element)v.get(341)).appendChild((Element)v.get(346));

      /* Elemento padre:346 / Elemento actual: 347   */
      v.add(doc.createTextNode("Tipo movimiento"));
      ((Element)v.get(346)).appendChild((Text)v.get(347));

      /* Termina nodo Texto:347   */
      /* Termina nodo:346   */

      /* Empieza nodo:348 / Elemento padre: 341   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(348)).setAttribute("colFondo","" );
      ((Element)v.get(348)).setAttribute("ID","EstCab" );
      ((Element)v.get(348)).setAttribute("cod","467" );
      ((Element)v.get(341)).appendChild((Element)v.get(348));

      /* Elemento padre:348 / Elemento actual: 349   */
      v.add(doc.createTextNode("Puntaje"));
      ((Element)v.get(348)).appendChild((Text)v.get(349));

      /* Termina nodo Texto:349   */
      /* Termina nodo:348   */

      /* Empieza nodo:350 / Elemento padre: 341   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(350)).setAttribute("colFondo","" );
      ((Element)v.get(350)).setAttribute("ID","EstCab" );
      ((Element)v.get(350)).setAttribute("cod","9" );
      ((Element)v.get(341)).appendChild((Element)v.get(350));

      /* Elemento padre:350 / Elemento actual: 351   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(350)).appendChild((Text)v.get(351));

      /* Termina nodo Texto:351   */
      /* Termina nodo:350   */

      /* Empieza nodo:352 / Elemento padre: 341   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(352)).setAttribute("colFondo","" );
      ((Element)v.get(352)).setAttribute("ID","EstCab" );
      ((Element)v.get(352)).setAttribute("cod","2432" );
      ((Element)v.get(341)).appendChild((Element)v.get(352));

      /* Elemento padre:352 / Elemento actual: 353   */
      v.add(doc.createTextNode("Fecha de ultima actualizacion"));
      ((Element)v.get(352)).appendChild((Text)v.get(353));

      /* Termina nodo Texto:353   */
      /* Termina nodo:352   */
      /* Termina nodo:341   */

      /* Empieza nodo:354 / Elemento padre: 324   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(354)).setAttribute("alto","22" );
      ((Element)v.get(354)).setAttribute("accion","" );
      ((Element)v.get(354)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(354)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(354)).setAttribute("maxSel","-1" );
      ((Element)v.get(354)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(354)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(354)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(354)).setAttribute("onLoad","" );
      ((Element)v.get(354)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(324)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(355)).setAttribute("tipo","texto" );
      ((Element)v.get(355)).setAttribute("ID","EstDat" );
      ((Element)v.get(354)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */

      /* Empieza nodo:356 / Elemento padre: 354   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(356)).setAttribute("tipo","texto" );
      ((Element)v.get(356)).setAttribute("ID","EstDat2" );
      ((Element)v.get(354)).appendChild((Element)v.get(356));
      /* Termina nodo:356   */

      /* Empieza nodo:357 / Elemento padre: 354   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(357)).setAttribute("tipo","texto" );
      ((Element)v.get(357)).setAttribute("ID","EstDat" );
      ((Element)v.get(354)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */

      /* Empieza nodo:358 / Elemento padre: 354   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(358)).setAttribute("tipo","texto" );
      ((Element)v.get(358)).setAttribute("ID","EstDat2" );
      ((Element)v.get(354)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */

      /* Empieza nodo:359 / Elemento padre: 354   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(359)).setAttribute("tipo","texto" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(359)).setAttribute("ID","EstDat" );
      ((Element)v.get(354)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */

      /* Empieza nodo:360 / Elemento padre: 354   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(360)).setAttribute("tipo","texto" );
      ((Element)v.get(360)).setAttribute("ID","EstDat2" );
      ((Element)v.get(354)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */
      /* Termina nodo:354   */

      /* Empieza nodo:361 / Elemento padre: 324   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(324)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */

      /* Empieza nodo:362 / Elemento padre: 324   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(362)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(362)).setAttribute("ancho","604" );
      ((Element)v.get(362)).setAttribute("sep","$" );
      ((Element)v.get(362)).setAttribute("x","12" );
      ((Element)v.get(362)).setAttribute("class","botonera" );
      ((Element)v.get(362)).setAttribute("y","485" );
      ((Element)v.get(362)).setAttribute("control","|" );
      ((Element)v.get(362)).setAttribute("conector","" );
      ((Element)v.get(362)).setAttribute("rowset","" );
      ((Element)v.get(362)).setAttribute("cargainicial","N" );
      ((Element)v.get(362)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(324)).appendChild((Element)v.get(362));

      /* Empieza nodo:363 / Elemento padre: 362   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(363)).setAttribute("nombre","ret1" );
      ((Element)v.get(363)).setAttribute("x","37" );
      ((Element)v.get(363)).setAttribute("y","508" );
      ((Element)v.get(363)).setAttribute("ID","botonContenido" );
      ((Element)v.get(363)).setAttribute("img","retroceder_on" );
      ((Element)v.get(363)).setAttribute("tipo","0" );
      ((Element)v.get(363)).setAttribute("estado","false" );
      ((Element)v.get(363)).setAttribute("alt","" );
      ((Element)v.get(363)).setAttribute("codigo","" );
      ((Element)v.get(363)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(362)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */

      /* Empieza nodo:364 / Elemento padre: 362   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(364)).setAttribute("nombre","ava1" );
      ((Element)v.get(364)).setAttribute("x","52" );
      ((Element)v.get(364)).setAttribute("y","508" );
      ((Element)v.get(364)).setAttribute("ID","botonContenido" );
      ((Element)v.get(364)).setAttribute("img","avanzar_on" );
      ((Element)v.get(364)).setAttribute("tipo","0" );
      ((Element)v.get(364)).setAttribute("estado","false" );
      ((Element)v.get(364)).setAttribute("alt","" );
      ((Element)v.get(364)).setAttribute("codigo","" );
      ((Element)v.get(364)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(362)).appendChild((Element)v.get(364));
      /* Termina nodo:364   */
      /* Termina nodo:362   */
      /* Termina nodo:324   */

      /* Empieza nodo:365 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(365)).setAttribute("nombre","primera1" );
      ((Element)v.get(365)).setAttribute("x","20" );
      ((Element)v.get(365)).setAttribute("y","508" );
      ((Element)v.get(365)).setAttribute("ID","botonContenido" );
      ((Element)v.get(365)).setAttribute("img","primera_on" );
      ((Element)v.get(365)).setAttribute("tipo","0" );
      ((Element)v.get(365)).setAttribute("estado","false" );
      ((Element)v.get(365)).setAttribute("alt","" );
      ((Element)v.get(365)).setAttribute("codigo","" );
      ((Element)v.get(365)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(6)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */

      /* Empieza nodo:366 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(366)).setAttribute("nombre","separa" );
      ((Element)v.get(366)).setAttribute("x","59" );
      ((Element)v.get(366)).setAttribute("y","504" );
      ((Element)v.get(366)).setAttribute("ID","botonContenido" );
      ((Element)v.get(366)).setAttribute("img","separa_base" );
      ((Element)v.get(366)).setAttribute("tipo","0" );
      ((Element)v.get(366)).setAttribute("estado","false" );
      ((Element)v.get(366)).setAttribute("alt","" );
      ((Element)v.get(366)).setAttribute("codigo","" );
      ((Element)v.get(366)).setAttribute("accion","" );
      ((Element)v.get(6)).appendChild((Element)v.get(366));
      /* Termina nodo:366   */
      /* Termina nodo:6   */


   }

}
