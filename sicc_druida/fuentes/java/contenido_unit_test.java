
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_unit_test  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_unit_test" );
      ((Element)v.get(0)).setAttribute("cod","0" );
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
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Elemento padre:4 / Elemento actual: 5   */
      v.add(doc.createTextNode("\r\r \r function onLoadPag()\r {	configurarMenuSecundario(\"formulario\");\r	fMostrarMensajeError();	  \r	focaliza(\"formulario.cbEstadoComision\");\r\r    \r	addLP('LPMantenerVersionConcurso')\r	addLP('LPConsultarCuentaCorrientePuntos')\r	addLP('LPEvaluarCambiosYSolicitudes')\r	addLP('LPAceptarModificacion')\r	addLP('LPMarcarComisiones')\r	addLP('LPInsertarPlantillaCom')\r	addLP('LPModificarPlantillaCom')\r	addLP('LPCopiarPlantillaCom')\r	addLP('LPInsertarComisiones')\r	addLP('LPModificarComisiones')\r	addLP('LPMarcarPlantillasCom')\r	\r\r\r	addBID('INCModificarVersionesConcurso')\r\r\r	txt_to('lblEstadoComision','Componente LP');\r\r	if(get('formulario.resultMLNF') != '')\r	   alert(get('formulario.resultMLNF'));\r\r\r\r	if(get('formulario.cerrarVentana') == \"1\")\r	   window.close();\r }\r\r\r function addLP(){combo_add('formulario.cbEstadoComision',arguments[0],arguments[0]);}\r function addBID(){combo_add('formulario.cbBusinessID',arguments[0],arguments[0]);}\r\r /*Cuando se pulsa el botón Guardar del menú secundario. \r	Proceso \r	======== \r	Se invoca LPMantenimientoComisiones a través de un EnviarOculto con: \r	accion = \"GuardarPermitirModificar\" \r	oidComision = varOidComision \r	oidEstado = cmbEstado\r */\r function onClickGuardar()\r {\r	if(sicc_validaciones_generales()) \r	{	 \r		 eval('formulario').oculto = 'S'\r		 set('formulario.conectorAction', 'LPDosMantenimientoComisiones')\r		 set('formulario.accion', 'GuardarPermitirModificar')\r		 enviaSICC('formulario', null, null, 'N')\r	}\r }\r\r  function fGuardar(){ onClickGuardar(); }\r  function fVolver(){ window.close(); }\r\r\r  function showResult(){alert(arguments[0])}\r\r  function fLimpiar()\r  {		set_combo('formulario.cbEstadoComision','');\r		focaliza('formulario.cbEstadoComision');\r  }\r\r function toDetalle()\r {\r   if(document.all[\"btnModificarDiv\"].style.visibility == 'visible')           \r	   focalizaBotonHTML('botonContenido', 'btnModificar'); \r   else\r   {\r	   if(document.all[\"btnDetalleDiv\"].style.visibility == 'visible')\r		 focalizaBotonHTML('botonContenido','btnDetalle');\r	   else\r	   {\r		 if(arguments[0])\r			 focalizaBotonHTML('botonContenido','btnBuscar');\r		 else\r			 focaliza('formulario.txtCodUsuario');\r	   }\r   }\r }\r\r function restartPort()\r {\r\r   var stop_ = \"http:\r\r }\r\r\r function onClickLP()\r {\r      parent.frames[1].callMenu(get('formulario.cbEstadoComision') + '&idFuncion=')\r }\r\r function onClickMLNF(){testLoadDTOSalida()}\r\r\r    function testLoadDTOSalida()\r   {  obj = new Object()\r      \r	  \r	     obj.oid = '1013' 	     obj.bid = 'COMCargaConfirmarModificar'\r	     obj.con = 'ConectorCargaConfirmarModificar'\r         obj.update = 'Y' \r\r	  	  mostrarModalSICC('LPUnitTest','test', obj, 600, 160)\r\r      /*set('formulario.oid', '1013')\r      set('formulario.bid', 'COMCargaConfirmarModificar')\r      set('formulario.con', 'ConectorCargaConfirmarModificar')\r      set('formulario.update', 'Y')\r\r	  eval('formulario').oculto = 'S'\r	  set('formulario.conectorAction', 'LPUnitTest')\r	  set('formulario.accion', 'test')\r	  enviaSICC('formulario', null, null, 'N')*/\r	  \r\r   }\r      /*eval('formulario').oculto = 'S'\r	  set('formulario.conectorAction', 'LPDosMantenimientoComisiones')\r	  set('formulario.accion', 'ConfirmarAceptar')\r	  enviaSICC('formulario', null, null, 'N')*/\r\r\r  \r"));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","cbEstadoComision" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","1713" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */
      /* Termina nodo:6   */

      /* Empieza nodo:8 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(8)).setAttribute("nombre","formulario" );
      ((Element)v.get(8)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(8));

      /* Empieza nodo:9 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","accion" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","varOidIdioma" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","varOidPais" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","varOidComision" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","oidComision" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","enviarOculto" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","resultMLNF" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 8   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(19)).setAttribute("nombre","capaContenido" );
      ((Element)v.get(8)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("table"));
      ((Element)v.get(20)).setAttribute("width","100%" );
      ((Element)v.get(20)).setAttribute("border","0" );
      ((Element)v.get(20)).setAttribute("cellspacing","0" );
      ((Element)v.get(20)).setAttribute("cellpadding","0" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(20)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("td"));
      ((Element)v.get(22)).setAttribute("width","12" );
      ((Element)v.get(22)).setAttribute("align","center" );
      ((Element)v.get(21)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(23)).setAttribute("src","b.gif" );
      ((Element)v.get(23)).setAttribute("width","12" );
      ((Element)v.get(23)).setAttribute("height","12" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */
      /* Termina nodo:22   */

      /* Empieza nodo:24 / Elemento padre: 21   */
      v.add(doc.createElement("td"));
      ((Element)v.get(24)).setAttribute("width","750" );
      ((Element)v.get(21)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(25)).setAttribute("src","b.gif" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */
      /* Termina nodo:24   */

      /* Empieza nodo:26 / Elemento padre: 21   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).setAttribute("width","12" );
      ((Element)v.get(21)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(27)).setAttribute("src","b.gif" );
      ((Element)v.get(27)).setAttribute("width","12" );
      ((Element)v.get(27)).setAttribute("height","1" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */
      /* Termina nodo:26   */
      /* Termina nodo:21   */

      /* Empieza nodo:28 / Elemento padre: 20   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(20)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("td"));
      ((Element)v.get(28)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(30)).setAttribute("src","b.gif" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */
      /* Termina nodo:29   */

      /* Empieza nodo:31 / Elemento padre: 28   */
      v.add(doc.createElement("td"));
      ((Element)v.get(28)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(33)).setAttribute("class","legend" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(34)).setAttribute("nombre","lblDatosComision" );
      ((Element)v.get(34)).setAttribute("alto","13" );
      ((Element)v.get(34)).setAttribute("filas","1" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(34)).setAttribute("id","legend" );
      ((Element)v.get(34)).setAttribute("cod","00363" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */
      /* Termina nodo:33   */

      /* Empieza nodo:35 / Elemento padre: 32   */
      v.add(doc.createElement("table"));
      ((Element)v.get(35)).setAttribute("width","100%" );
      ((Element)v.get(35)).setAttribute("border","0" );
      ((Element)v.get(35)).setAttribute("align","center" );
      ((Element)v.get(35)).setAttribute("cellspacing","0" );
      ((Element)v.get(35)).setAttribute("cellpadding","0" );
      ((Element)v.get(32)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("table"));
      ((Element)v.get(38)).setAttribute("width","400" );
      ((Element)v.get(38)).setAttribute("border","0" );
      ((Element)v.get(38)).setAttribute("align","left" );
      ((Element)v.get(38)).setAttribute("cellspacing","0" );
      ((Element)v.get(38)).setAttribute("cellpadding","0" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).setAttribute("colspan","4" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(41)).setAttribute("src","b.gif" );
      ((Element)v.get(41)).setAttribute("width","8" );
      ((Element)v.get(41)).setAttribute("height","8" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */
      /* Termina nodo:39   */

      /* Empieza nodo:42 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(44)).setAttribute("src","b.gif" );
      ((Element)v.get(44)).setAttribute("width","8" );
      ((Element)v.get(44)).setAttribute("height","8" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:45 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(46)).setAttribute("nombre","lblEstadoComision" );
      ((Element)v.get(46)).setAttribute("alto","13" );
      ((Element)v.get(46)).setAttribute("filas","1" );
      ((Element)v.get(46)).setAttribute("valor","Componente LP" );
      ((Element)v.get(46)).setAttribute("id","datosTitle" );
      ((Element)v.get(46)).setAttribute("cod","0" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:47 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).setAttribute("width","100%" );
      ((Element)v.get(42)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(48)).setAttribute("src","b.gif" );
      ((Element)v.get(48)).setAttribute("width","8" );
      ((Element)v.get(48)).setAttribute("height","8" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */
      /* Termina nodo:42   */

      /* Empieza nodo:49 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(51)).setAttribute("src","b.gif" );
      ((Element)v.get(51)).setAttribute("width","8" );
      ((Element)v.get(51)).setAttribute("height","8" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:52 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(49)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(53)).setAttribute("nombre","cbEstadoComision" );
      ((Element)v.get(53)).setAttribute("id","datosCampos" );
      ((Element)v.get(53)).setAttribute("size","1" );
      ((Element)v.get(53)).setAttribute("multiple","N" );
      ((Element)v.get(53)).setAttribute("req","N" );
      ((Element)v.get(53)).setAttribute("valorinicial","" );
      ((Element)v.get(53)).setAttribute("textoinicial","" );
      ((Element)v.get(53)).setAttribute("onteab","focaliza('formulario.cbEstadoComision');" );
      ((Element)v.get(53)).setAttribute("onshtab","focaliza('formulario.cbEstadoComision');" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:55 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).setAttribute("width","100%" );
      ((Element)v.get(49)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(56)).setAttribute("src","b.gif" );
      ((Element)v.get(56)).setAttribute("width","8" );
      ((Element)v.get(56)).setAttribute("height","8" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */
      /* Termina nodo:49   */

      /* Empieza nodo:57 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).setAttribute("colspan","4" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(59)).setAttribute("src","b.gif" );
      ((Element)v.get(59)).setAttribute("width","8" );
      ((Element)v.get(59)).setAttribute("height","8" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:60 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(62)).setAttribute("width","8" );
      ((Element)v.get(62)).setAttribute("height","8" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(60)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(64)).setAttribute("nombre","cbBusinessID" );
      ((Element)v.get(64)).setAttribute("id","datosCampos" );
      ((Element)v.get(64)).setAttribute("size","1" );
      ((Element)v.get(64)).setAttribute("multiple","N" );
      ((Element)v.get(64)).setAttribute("req","N" );
      ((Element)v.get(64)).setAttribute("valorinicial","" );
      ((Element)v.get(64)).setAttribute("textoinicial","" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:66 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).setAttribute("width","100%" );
      ((Element)v.get(60)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(67)).setAttribute("src","b.gif" );
      ((Element)v.get(67)).setAttribute("width","8" );
      ((Element)v.get(67)).setAttribute("height","8" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:60   */

      /* Empieza nodo:68 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).setAttribute("colspan","4" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(70)).setAttribute("src","b.gif" );
      ((Element)v.get(70)).setAttribute("width","8" );
      ((Element)v.get(70)).setAttribute("height","8" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:38   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */
      /* Termina nodo:35   */
      /* Termina nodo:32   */
      /* Termina nodo:31   */

      /* Empieza nodo:71 / Elemento padre: 28   */
      v.add(doc.createElement("td"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(28)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:28   */

      /* Empieza nodo:73 / Elemento padre: 20   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(20)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).setAttribute("width","12" );
      ((Element)v.get(74)).setAttribute("align","center" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(75)).setAttribute("width","12" );
      ((Element)v.get(75)).setAttribute("height","12" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).setAttribute("width","750" );
      ((Element)v.get(73)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(77)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).setAttribute("width","12" );
      ((Element)v.get(73)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","12" );
      ((Element)v.get(79)).setAttribute("height","1" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:73   */
      /* Termina nodo:20   */

      /* Empieza nodo:80 / Elemento padre: 19   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(80)).setAttribute("nombre","btnDetalle" );
      ((Element)v.get(80)).setAttribute("x","240" );
      ((Element)v.get(80)).setAttribute("y","40" );
      ((Element)v.get(80)).setAttribute("ID","botonContenido" );
      ((Element)v.get(80)).setAttribute("tipo","html" );
      ((Element)v.get(80)).setAttribute("estado","false" );
      ((Element)v.get(80)).setAttribute("cod","1" );
      ((Element)v.get(80)).setAttribute("accion","onClickLP()" );
      ((Element)v.get(19)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */

      /* Empieza nodo:81 / Elemento padre: 19   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(81)).setAttribute("nombre","btnMLNF" );
      ((Element)v.get(81)).setAttribute("x","180" );
      ((Element)v.get(81)).setAttribute("y","120" );
      ((Element)v.get(81)).setAttribute("ID","botonContenido" );
      ((Element)v.get(81)).setAttribute("tipo","html" );
      ((Element)v.get(81)).setAttribute("estado","false" );
      ((Element)v.get(81)).setAttribute("cod","1" );
      ((Element)v.get(81)).setAttribute("accion","onClickMLNF()" );
      ((Element)v.get(19)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:19   */
      /* Termina nodo:8   */


   }

}
