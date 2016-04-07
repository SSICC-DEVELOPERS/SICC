
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_grupos_solicitud_modificar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_grupos_solicitud_modificar" );
      ((Element)v.get(0)).setAttribute("cod","0647" );
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
      ((Element)v.get(2)).setAttribute("src","i18NJS.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Elemento padre:5 / Elemento actual: 6   */
      v.add(doc.createTextNode("\r   \r\r  function onLoadPag()   {	\r	ocultarLista();\r    DrdEnsanchaConMargenDcho('listado1',12);\r    eval (ON_RSZ);  \r	 configurarMenuSecundario(\"frmFormulario\");\r		 var hayErrores = chequeaErrores();\r		 if (hayErrores != true)\r		 {\r			 muestraSeleccionAnterior();\r	  		 cargaComboDias();\r	 		 focaliza(\"frmUnico.cbTipoDireccion\", \"\");\r			 return;\r		 }\r		 focaliza('frmFormulario.txtCodGrupoSolicitud');\r          btnProxy(4, 0);\r		\r		 if(get('frmFormulario.recargar')==\"recargar\"){\r			\r			configurarPaginado(mipgndo, \"CARGrupoSolicitudBuscar\", \"CARBuscarGrupoSol\", \"es.indra.sicc.dtos.car.DTOCriteriosGrupoSol\",armarArray());\r			document.all[\"DetalleDiv\"].style.visibility='hidden';\r			document.all[\"ModificarDiv\"].style.visibility='';\r			document.all[\"EliminaDiv\"].style.visibility='hidden';\r			mostrarLista();\r		 }\r\r     if(get('frmFormulario.casoDeUso')=='elimina'){      \r      listado1.maxSel = \"-1\";			\r		}     \r   }\r   \r   function  chequeaErrores()\r	{\r		var errCod = get(\"frmFormulario.errCodigo\");\r\r		if (errCod != null)\r		{\r				fMostrarMensajeError();\r				return true;\r		}\r\r		return false;\r\r	}\r	function ocultarLista(){\r    document.all[\"Cplistado1\"].style.visibility='hidden';\r    document.all[\"CpLin1listado1\"].style.visibility='hidden';\r    document.all[\"CpLin2listado1\"].style.visibility='hidden';\r    document.all[\"CpLin3listado1\"].style.visibility='hidden';\r    document.all[\"CpLin4listado1\"].style.visibility='hidden';\r\r    document.all[\"primera1Div\"].style.visibility='hidden';\r    document.all[\"ret1Div\"].style.visibility='hidden';\r    document.all[\"ava1Div\"].style.visibility='hidden';\r    document.all[\"separaDiv\"].style.visibility='hidden';\r    document.all[\"DetalleDiv\"].style.visibility='hidden';\r	document.all[\"ModificarDiv\"].style.visibility='hidden';\r	document.all[\"EliminaDiv\"].style.visibility='hidden';\r}\r\rfunction mostrarLista(){\r    document.all[\"Cplistado1\"].style.visibility='';\r    document.all[\"CpLin1listado1\"].style.visibility='';\r    document.all[\"CpLin2listado1\"].style.visibility='';\r    document.all[\"CpLin3listado1\"].style.visibility='';\r    document.all[\"CpLin4listado1\"].style.visibility='';\r\r    document.all[\"primera1Div\"].style.visibility='';\r    document.all[\"ret1Div\"].style.visibility='';\r    document.all[\"ava1Div\"].style.visibility='';\r    document.all[\"separaDiv\"].style.visibility='';\r   		\r}\r\rfunction Buscar(){\r	var x= get('frmFormulario.txtCodGrupoSolicitud');\r	set('frmFormulario.txtCodGrupoSolicitud',x.toUpperCase());\r	configurarPaginado(mipgndo, \"CARGrupoSolicitudBuscar\", \"CARBuscarGrupoSol\", \"es.indra.sicc.dtos.car.DTOCriteriosGrupoSol\",armarArray());\r	focaliza('frmFormulario.txtCodGrupoSolicitud');\r	if(get('frmFormulario.casoDeUso')=='consulta'){\r		document.all[\"ModificarDiv\"].style.visibility='hidden';\r		document.all[\"DetalleDiv\"].style.visibility='';\r		mostrarLista();\r		\r		\r	}\r	if(get('frmFormulario.casoDeUso')=='elimina'){\r		document.all[\"ModificarDiv\"].style.visibility='hidden';\r		document.all[\"DetalleDiv\"].style.visibility='';\r				mostrarLista();\r	}\r	if(get('frmFormulario.casoDeUso')=='modifica'){\r		document.all[\"DetalleDiv\"].style.visibility='hidden';\r		document.all[\"ModificarDiv\"].style.visibility='';\r		document.all[\"EliminaDiv\"].style.visibility='hidden';\r		mostrarLista();\r	}\r	set('frmFormulario.flag','T');\r	\r	\r	\r	\r}\rfunction armarArray(){\r			var hh = new Array();\r			hh[0] = new Array('codGrupoSolicitud',get('frmFormulario.txtCodGrupoSolicitud'));\r			hh[1] = new Array('tiposSolicitud',get('frmFormulario.cbCodTipoSolicitud'));\r			hh[2] = new Array('descripcion',get('frmFormulario.txtDescripcion'));\r           \r            return hh;\r}\r\rfunction modificar(){\r        var codigos = new Array();\r		codigos = listado1.codSeleccionados();\r\r		if(codigos==''){\r			GestionarMensaje('1021', null , null, null);\r			focaliza(\"frmFormulario.txtCodGrupoSolicitud\");\r			return;\r		}\r\r        var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);\r		set('frmFormulario.oidGrupoSol',codigos[0]);\r		set('frmFormulario.codSelecc',listado1.codSeleccionados());\r		\r		var obj = new Object();\r		obj.i = get('frmFormulario.codSelecc');\r		mostrarModalSICC('LPGrupoSolicitud','modificaGrupo',obj);\r		configurarPaginado(mipgndo, \"CARGrupoSolicitudBuscar\", \"CARBuscarGrupoSol\", \r            \"es.indra.sicc.dtos.car.DTOCriteriosGrupoSol\",armarArray());\r					\r        set('frmFormulario.casoDeUso','modifica');\r       /* set('frmFormulario.recargar','');\r        set('frmFormulario.conectorAction','LPGrupoSolicitud');\r        enviaSICC('frmFormulario');								 */\r		\r}\rfunction eliminar(){\r	codigos = listado1.codSeleccionados();\r	if(codigos==''){\r			GestionarMensaje('1021', null , null, null);\r			focaliza(\"frmFormulario.txtCodGrupoSolicitud\");\r			return;\r		}\r			eliminarFilas(listado1.codSeleccionados(),'CARGrupoSolicitudEliminar',mipgndo);\r			\r}\r\r\r\rfunction consultar(){\r	var i=listado1.codSeleccionados();	\r	if(i==''){\r			GestionarMensaje('1021', null , null, null);\r			focaliza(\"frmFormulario.txtCodGrupoSolicitud\");\r			return;\r		}\r	mostrarModalSICC('LPGrupoSolicitud','detalleGrupo',i);\r}\r\rfunction detalle(){\r	\r		var codigos = new Array();\r		codigos = listado1.codSeleccionados();\r		if(codigos=='')\r	{\r			GestionarMensaje('1021', null , null, null);\r			focaliza(\"frmFormulario.txtCodGrupoSolicitud\");\r			return;\r		}\r        var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);\r		set('frmFormulario.codSelecc',codigos[0]);\r		var obj = new Object();\r		obj.i = get('frmFormulario.codSelecc');\r    obj.caso = get('frmFormulario.casoDeUso');\r    \r		\r		mostrarModalSICC('LPGrupoSolicitud','detalleGrupo',obj);\r}\r\rfunction muestraLista( ultima, rowset){\r	var tamano = rowset.length;\r	if (tamano > 0) {\r	  \r				eval (ON_RSZ);\r		focaliza(\"frmFormulario.txtCodGrupoSolicitud\");\r    if(get('frmFormulario.casoDeUso')=='elimina'){\r      btnProxy(4, 1);\r    }		\r		return true;\r	\r	} else {\r    if(get('frmFormulario.casoDeUso')=='elimina'){\r      btnProxy(4, 0);\r    }		\r		ocultarLista();\r		focaliza(\"frmFormulario.txtCodGrupoSolicitud\");	\r		set('frmFormulario.flag','');\r		return false;\r	}\r	\r}\rfunction TabUp(){\r	if(get('frmFormulario.flag')=='T'){\r		var obj=document.getElementsByName(\"btnBuscar\");\r			obj.item(0).focus();\r	}else{\r		focaliza(\"frmFormulario.txtCodGrupoSolicitud\");\r	}\r}\r\rfunction despuesBuscar() {\r  if(document.all[\"ModificarDiv\"].style.visibility=='') {\r    focalizaBotonHTML_XY('Modificar');      \r  }\r  \r  if(document.all[\"EliminaDiv\"].style.visibility=='') {\r    focalizaBotonHTML_XY('Elimina');      \r  }\r  \r  if(document.all[\"DetalleDiv\"].style.visibility=='') {\r    focalizaBotonHTML_XY('Detalle');      \r  }\r\r  if((document.all[\"ModificarDiv\"].style.visibility!='') && (document.all[\"EliminaDiv\"].style.visibility!='') && (document.all[\"DetalleDiv\"].style.visibility!='')) {\r    focaliza('frmFormulario.txtCodGrupoSolicitud');\r  }\r}\r\rfunction focoCodigo() {\r  focaliza('frmFormulario.txtCodGrupoSolicitud');\r}\r\rfunction goDown(){\r	if(get('frmFormulario.flag')=='T'){\r		if(get('frmFormulario.casoDeUso')=='consulta'){\r			var obj=document.getElementsByName(\"Detalle\");\r			obj.item(0).focus();\r		}\r\r		if(get('frmFormulario.casoDeUso')=='elimina'){\r			var obj=document.getElementsByName(\"Elimina\");\r			obj.item(0).focus();\r		}\r\r		if(get('frmFormulario.casoDeUso')=='modifica'){\r			var obj=document.getElementsByName(\"Modificar\");\r			obj.item(0).focus();\r		}\r	\r   }\r	if(get('frmFormulario.flag')!='T'){\r				var obj=document.getElementsByName(\"btnBuscar\");\r		obj.item(0).focus();\r	}\r}\r\rfunction TabShift(){\r	\r	if(get('frmFormulario.flag')=='T'){\r		\r				var obj=document.getElementsByName(\"btnBuscar\");\r			obj.item(0).focus();\r	}else{\r		focaliza('frmFormulario.txtCodGrupoSolicitud');	\r		}\r}\r\rfunction fLimpiar(){\r	focaliza('frmFormulario.txtCodGrupoSolicitud');\r}\r\rfunction fBorrar(){\r  eliminar();\r}\r\r   \r   \r"));
      ((Element)v.get(5)).appendChild((Text)v.get(6));

      /* Termina nodo Texto:6   */
      /* Termina nodo:5   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(7)).setAttribute("nombre","frmFormulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","accion" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","exito" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","codSelecc" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","cod" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","flag" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","recargar" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 7   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(18)).setAttribute("nombre","capa" );
      ((Element)v.get(7)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","oidGrupoSol" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 18   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(20)).setAttribute("nombre","oidIdioma" );
      ((Element)v.get(18)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 18   */
      v.add(doc.createElement("table"));
      ((Element)v.get(21)).setAttribute("width","100%" );
      ((Element)v.get(21)).setAttribute("border","0" );
      ((Element)v.get(21)).setAttribute("cellspacing","0" );
      ((Element)v.get(21)).setAttribute("cellpadding","0" );
      ((Element)v.get(18)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(21)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("td"));
      ((Element)v.get(23)).setAttribute("width","12" );
      ((Element)v.get(23)).setAttribute("align","center" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(24)).setAttribute("src","b.gif" );
      ((Element)v.get(24)).setAttribute("width","12" );
      ((Element)v.get(24)).setAttribute("height","12" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */
      /* Termina nodo:23   */

      /* Empieza nodo:25 / Elemento padre: 22   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).setAttribute("width","750" );
      ((Element)v.get(22)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(26)).setAttribute("src","b.gif" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */
      /* Termina nodo:25   */

      /* Empieza nodo:27 / Elemento padre: 22   */
      v.add(doc.createElement("td"));
      ((Element)v.get(27)).setAttribute("width","12" );
      ((Element)v.get(22)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(28)).setAttribute("src","b.gif" );
      ((Element)v.get(28)).setAttribute("width","12" );
      ((Element)v.get(28)).setAttribute("height","1" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:27   */
      /* Termina nodo:22   */

      /* Empieza nodo:29 / Elemento padre: 21   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(21)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(31)).setAttribute("src","b.gif" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */
      /* Termina nodo:30   */

      /* Empieza nodo:32 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(34)).setAttribute("class","legend" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(35)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(35)).setAttribute("alto","13" );
      ((Element)v.get(35)).setAttribute("filas","1" );
      ((Element)v.get(35)).setAttribute("cod","0075" );
      ((Element)v.get(35)).setAttribute("id","legend" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:36 / Elemento padre: 33   */
      v.add(doc.createElement("table"));
      ((Element)v.get(36)).setAttribute("width","100%" );
      ((Element)v.get(36)).setAttribute("border","0" );
      ((Element)v.get(36)).setAttribute("align","center" );
      ((Element)v.get(36)).setAttribute("cellspacing","0" );
      ((Element)v.get(36)).setAttribute("cellpadding","0" );
      ((Element)v.get(33)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("table"));
      ((Element)v.get(39)).setAttribute("width","705" );
      ((Element)v.get(39)).setAttribute("border","0" );
      ((Element)v.get(39)).setAttribute("align","left" );
      ((Element)v.get(39)).setAttribute("cellspacing","0" );
      ((Element)v.get(39)).setAttribute("cellpadding","0" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).setAttribute("colspan","4" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(42)).setAttribute("src","b.gif" );
      ((Element)v.get(42)).setAttribute("width","8" );
      ((Element)v.get(42)).setAttribute("height","8" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:43 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(45)).setAttribute("src","b.gif" );
      ((Element)v.get(45)).setAttribute("width","8" );
      ((Element)v.get(45)).setAttribute("height","8" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:46 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(47)).setAttribute("nombre","lblCodGrupoSolicitud" );
      ((Element)v.get(47)).setAttribute("alto","13" );
      ((Element)v.get(47)).setAttribute("filas","1" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(47)).setAttribute("id","datosTitle" );
      ((Element)v.get(47)).setAttribute("cod","2249" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).setAttribute("width","25" );
      ((Element)v.get(49)).setAttribute("height","8" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(51)).setAttribute("nombre","lblCodTipoSolicitud" );
      ((Element)v.get(51)).setAttribute("alto","13" );
      ((Element)v.get(51)).setAttribute("filas","1" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(51)).setAttribute("id","datosTitle" );
      ((Element)v.get(51)).setAttribute("cod","415" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:52 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(53)).setAttribute("src","b.gif" );
      ((Element)v.get(53)).setAttribute("width","25" );
      ((Element)v.get(53)).setAttribute("height","8" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:54 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(55)).setAttribute("nombre","lblDescripcion" );
      ((Element)v.get(55)).setAttribute("alto","13" );
      ((Element)v.get(55)).setAttribute("filas","1" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(55)).setAttribute("id","datosTitle" );
      ((Element)v.get(55)).setAttribute("cod","9" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:56 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).setAttribute("width","100%" );
      ((Element)v.get(43)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(57)).setAttribute("src","b.gif" );
      ((Element)v.get(57)).setAttribute("width","8" );
      ((Element)v.get(57)).setAttribute("height","8" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */
      /* Termina nodo:43   */

      /* Empieza nodo:58 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(60)).setAttribute("src","b.gif" );
      ((Element)v.get(60)).setAttribute("width","8" );
      ((Element)v.get(60)).setAttribute("height","8" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(62)).setAttribute("nombre","txtCodGrupoSolicitud" );
      ((Element)v.get(62)).setAttribute("id","datosCampos" );
      ((Element)v.get(62)).setAttribute("max","2" );
      ((Element)v.get(62)).setAttribute("tipo","" );
      ((Element)v.get(62)).setAttribute("onchange","" );
      ((Element)v.get(62)).setAttribute("req","N" );
      ((Element)v.get(62)).setAttribute("size","2" );
      ((Element)v.get(62)).setAttribute("valor","" );
      ((Element)v.get(62)).setAttribute("validacion","" );
      ((Element)v.get(62)).setAttribute("onshtab","goDown();" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(64)).setAttribute("src","b.gif" );
      ((Element)v.get(64)).setAttribute("width","25" );
      ((Element)v.get(64)).setAttribute("height","8" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(58)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(66)).setAttribute("nombre","cbCodTipoSolicitud" );
      ((Element)v.get(66)).setAttribute("id","datosCampos" );
      ((Element)v.get(66)).setAttribute("size","1" );
      ((Element)v.get(66)).setAttribute("multiple","N" );
      ((Element)v.get(66)).setAttribute("req","N" );
      ((Element)v.get(66)).setAttribute("valorinicial","" );
      ((Element)v.get(66)).setAttribute("textoinicial","" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:68 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(69)).setAttribute("src","b.gif" );
      ((Element)v.get(69)).setAttribute("width","25" );
      ((Element)v.get(69)).setAttribute("height","8" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:70 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(71)).setAttribute("nombre","txtDescripcion" );
      ((Element)v.get(71)).setAttribute("id","datosCampos" );
      ((Element)v.get(71)).setAttribute("max","40" );
      ((Element)v.get(71)).setAttribute("tipo","" );
      ((Element)v.get(71)).setAttribute("onchange","" );
      ((Element)v.get(71)).setAttribute("req","N" );
      ((Element)v.get(71)).setAttribute("size","40" );
      ((Element)v.get(71)).setAttribute("valor","" );
      ((Element)v.get(71)).setAttribute("validacion","" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:72 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).setAttribute("width","100%" );
      ((Element)v.get(58)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(73)).setAttribute("src","b.gif" );
      ((Element)v.get(73)).setAttribute("width","8" );
      ((Element)v.get(73)).setAttribute("height","8" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */
      /* Termina nodo:58   */

      /* Empieza nodo:74 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).setAttribute("colspan","4" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","8" );
      ((Element)v.get(76)).setAttribute("height","8" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:39   */
      /* Termina nodo:38   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */
      /* Termina nodo:33   */
      /* Termina nodo:32   */

      /* Empieza nodo:77 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */
      /* Termina nodo:29   */

      /* Empieza nodo:79 / Elemento padre: 21   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(21)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(81)).setAttribute("src","b.gif" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:82 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("table"));
      ((Element)v.get(84)).setAttribute("width","100%" );
      ((Element)v.get(84)).setAttribute("border","0" );
      ((Element)v.get(84)).setAttribute("align","center" );
      ((Element)v.get(84)).setAttribute("cellspacing","0" );
      ((Element)v.get(84)).setAttribute("cellpadding","0" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(86)).setAttribute("class","botonera" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(87)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(87)).setAttribute("ID","botonContenido" );
      ((Element)v.get(87)).setAttribute("tipo","html" );
      ((Element)v.get(87)).setAttribute("accion","Buscar();" );
      ((Element)v.get(87)).setAttribute("estado","false" );
      ((Element)v.get(87)).setAttribute("cod","1" );
      ((Element)v.get(87)).setAttribute("ontab","despuesBuscar();" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:88 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(89)).setAttribute("src","b.gif" );
      ((Element)v.get(89)).setAttribute("width","8" );
      ((Element)v.get(89)).setAttribute("height","12" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:79   */

      /* Empieza nodo:90 / Elemento padre: 21   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(21)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).setAttribute("width","12" );
      ((Element)v.get(91)).setAttribute("align","center" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(92)).setAttribute("width","12" );
      ((Element)v.get(92)).setAttribute("height","12" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:93 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).setAttribute("width","756" );
      ((Element)v.get(90)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(94)).setAttribute("src","b.gif" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:95 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).setAttribute("width","12" );
      ((Element)v.get(90)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(96)).setAttribute("src","b.gif" );
      ((Element)v.get(96)).setAttribute("width","12" );
      ((Element)v.get(96)).setAttribute("height","1" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:90   */
      /* Termina nodo:21   */
      /* Termina nodo:18   */

      /* Empieza nodo:97 / Elemento padre: 7   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(97)).setAttribute("nombre","listado1" );
      ((Element)v.get(97)).setAttribute("ancho","708" );
      ((Element)v.get(97)).setAttribute("alto","299" );
      ((Element)v.get(97)).setAttribute("x","12" );
      ((Element)v.get(97)).setAttribute("y","124" );
      ((Element)v.get(97)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(97)).setAttribute("msgDebugJS","N" );
      ((Element)v.get(7)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(98)).setAttribute("precarga","S" );
      ((Element)v.get(98)).setAttribute("conROver","S" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(99)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(99)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(99)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(99)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */

      /* Empieza nodo:100 / Elemento padre: 98   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(100)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(100)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(100)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(100)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(98)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */

      /* Empieza nodo:101 / Elemento padre: 98   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(101)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(101)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(98)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:98   */

      /* Empieza nodo:102 / Elemento padre: 97   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(97)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(103)).setAttribute("borde","1" );
      ((Element)v.get(103)).setAttribute("horizDatos","1" );
      ((Element)v.get(103)).setAttribute("horizCabecera","1" );
      ((Element)v.get(103)).setAttribute("vertical","1" );
      ((Element)v.get(103)).setAttribute("horizTitulo","1" );
      ((Element)v.get(103)).setAttribute("horizBase","1" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */

      /* Empieza nodo:104 / Elemento padre: 102   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(104)).setAttribute("borde","#999999" );
      ((Element)v.get(104)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(104)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(104)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(104)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(104)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(104)).setAttribute("horizBase","#999999" );
      ((Element)v.get(102)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:102   */

      /* Empieza nodo:105 / Elemento padre: 97   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(105)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(105)).setAttribute("alto","22" );
      ((Element)v.get(105)).setAttribute("imgFondo","" );
      ((Element)v.get(105)).setAttribute("cod","00135" );
      ((Element)v.get(105)).setAttribute("ID","datosTitle" );
      ((Element)v.get(97)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */

      /* Empieza nodo:106 / Elemento padre: 97   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(106)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(106)).setAttribute("alto","22" );
      ((Element)v.get(106)).setAttribute("imgFondo","" );
      ((Element)v.get(97)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */

      /* Empieza nodo:107 / Elemento padre: 97   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(107)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(107)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(107)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(107)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(107)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(107)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(97)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(108)).setAttribute("ancho","100" );
      ((Element)v.get(108)).setAttribute("minimizable","S" );
      ((Element)v.get(108)).setAttribute("minimizada","N" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */

      /* Empieza nodo:109 / Elemento padre: 107   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(109)).setAttribute("ancho","100" );
      ((Element)v.get(109)).setAttribute("minimizable","S" );
      ((Element)v.get(109)).setAttribute("minimizada","N" );
      ((Element)v.get(107)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */

      /* Empieza nodo:110 / Elemento padre: 107   */
      v.add(doc.createElement("COL"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(110)).setAttribute("ancho","100" );
      ((Element)v.get(110)).setAttribute("minimizable","S" );
      ((Element)v.get(110)).setAttribute("minimizada","N" );
      ((Element)v.get(107)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:107   */

      /* Empieza nodo:111 / Elemento padre: 97   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(111)).setAttribute("alto","20" );
      ((Element)v.get(111)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(111)).setAttribute("imgFondo","" );
      ((Element)v.get(111)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(97)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(112)).setAttribute("colFondo","" );
      ((Element)v.get(112)).setAttribute("ID","EstCab" );
      ((Element)v.get(112)).setAttribute("cod","2249" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */

      /* Empieza nodo:113 / Elemento padre: 111   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(113)).setAttribute("colFondo","" );
      ((Element)v.get(113)).setAttribute("ID","EstCab" );
      ((Element)v.get(113)).setAttribute("cod","415" );
      ((Element)v.get(111)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */

      /* Empieza nodo:114 / Elemento padre: 111   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(114)).setAttribute("colFondo","" );
      ((Element)v.get(114)).setAttribute("ID","EstCab" );
      ((Element)v.get(114)).setAttribute("cod","9" );
      ((Element)v.get(111)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:111   */

      /* Empieza nodo:115 / Elemento padre: 97   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(115)).setAttribute("alto","22" );
      ((Element)v.get(115)).setAttribute("accion","" );
      ((Element)v.get(115)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(115)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(115)).setAttribute("maxSel","1" );
      ((Element)v.get(115)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(115)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(115)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(115)).setAttribute("onLoad","" );
      ((Element)v.get(115)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(97)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(116)).setAttribute("tipo","texto" );
      ((Element)v.get(116)).setAttribute("ID","EstDat" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */

      /* Empieza nodo:117 / Elemento padre: 115   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(117)).setAttribute("tipo","texto" );
      ((Element)v.get(117)).setAttribute("ID","EstDat2" );
      ((Element)v.get(115)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */

      /* Empieza nodo:118 / Elemento padre: 115   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(118)).setAttribute("tipo","texto" );
      ((Element)v.get(118)).setAttribute("ID","EstDat" );
      ((Element)v.get(115)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:115   */

      /* Empieza nodo:119 / Elemento padre: 97   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(97)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(120)).setAttribute("ID","1" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(121)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(121)).setAttribute("TIPO","STRING" );
      ((Element)v.get(121)).setAttribute("VALOR","COD0" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */

      /* Empieza nodo:122 / Elemento padre: 120   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(122)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(122)).setAttribute("TIPO","STRING" );
      ((Element)v.get(122)).setAttribute("VALOR","x1" );
      ((Element)v.get(120)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */

      /* Empieza nodo:123 / Elemento padre: 120   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(123)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(123)).setAttribute("TIPO","STRING" );
      ((Element)v.get(123)).setAttribute("VALOR","x1" );
      ((Element)v.get(120)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */

      /* Empieza nodo:124 / Elemento padre: 120   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(124)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(124)).setAttribute("TIPO","STRING" );
      ((Element)v.get(124)).setAttribute("VALOR","" );
      ((Element)v.get(120)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:120   */

      /* Empieza nodo:125 / Elemento padre: 119   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(125)).setAttribute("ID","2" );
      ((Element)v.get(119)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(126)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(126)).setAttribute("TIPO","STRING" );
      ((Element)v.get(126)).setAttribute("VALOR","COD1" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */

      /* Empieza nodo:127 / Elemento padre: 125   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(127)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(127)).setAttribute("TIPO","STRING" );
      ((Element)v.get(127)).setAttribute("VALOR","x1" );
      ((Element)v.get(125)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */

      /* Empieza nodo:128 / Elemento padre: 125   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(128)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(128)).setAttribute("TIPO","STRING" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(128)).setAttribute("VALOR","x1" );
      ((Element)v.get(125)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */

      /* Empieza nodo:129 / Elemento padre: 125   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(129)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(129)).setAttribute("TIPO","STRING" );
      ((Element)v.get(129)).setAttribute("VALOR","" );
      ((Element)v.get(125)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:125   */

      /* Empieza nodo:130 / Elemento padre: 119   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(130)).setAttribute("ID","3" );
      ((Element)v.get(119)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(131)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(131)).setAttribute("TIPO","STRING" );
      ((Element)v.get(131)).setAttribute("VALOR","COD2" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */

      /* Empieza nodo:132 / Elemento padre: 130   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(132)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(132)).setAttribute("TIPO","STRING" );
      ((Element)v.get(132)).setAttribute("VALOR","x1" );
      ((Element)v.get(130)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */

      /* Empieza nodo:133 / Elemento padre: 130   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(133)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(133)).setAttribute("TIPO","STRING" );
      ((Element)v.get(133)).setAttribute("VALOR","x1" );
      ((Element)v.get(130)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */

      /* Empieza nodo:134 / Elemento padre: 130   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(134)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(134)).setAttribute("TIPO","STRING" );
      ((Element)v.get(134)).setAttribute("VALOR","" );
      ((Element)v.get(130)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:130   */

      /* Empieza nodo:135 / Elemento padre: 119   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(135)).setAttribute("ID","1" );
      ((Element)v.get(119)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(136)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(136)).setAttribute("TIPO","STRING" );
      ((Element)v.get(136)).setAttribute("VALOR","COD3" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */

      /* Empieza nodo:137 / Elemento padre: 135   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(137)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(137)).setAttribute("TIPO","STRING" );
      ((Element)v.get(137)).setAttribute("VALOR","x1" );
      ((Element)v.get(135)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */

      /* Empieza nodo:138 / Elemento padre: 135   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(138)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(138)).setAttribute("TIPO","STRING" );
      ((Element)v.get(138)).setAttribute("VALOR","x1" );
      ((Element)v.get(135)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */

      /* Empieza nodo:139 / Elemento padre: 135   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(139)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(139)).setAttribute("TIPO","STRING" );
      ((Element)v.get(139)).setAttribute("VALOR","" );
      ((Element)v.get(135)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:135   */

      /* Empieza nodo:140 / Elemento padre: 119   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(140)).setAttribute("ID","2" );
      ((Element)v.get(119)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(141)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(141)).setAttribute("TIPO","STRING" );
      ((Element)v.get(141)).setAttribute("VALOR","COD4" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */

      /* Empieza nodo:142 / Elemento padre: 140   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(142)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(142)).setAttribute("TIPO","STRING" );
      ((Element)v.get(142)).setAttribute("VALOR","x1" );
      ((Element)v.get(140)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */

      /* Empieza nodo:143 / Elemento padre: 140   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(143)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(143)).setAttribute("TIPO","STRING" );
      ((Element)v.get(143)).setAttribute("VALOR","x1" );
      ((Element)v.get(140)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */

      /* Empieza nodo:144 / Elemento padre: 140   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(144)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(144)).setAttribute("TIPO","STRING" );
      ((Element)v.get(144)).setAttribute("VALOR","" );
      ((Element)v.get(140)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:140   */

      /* Empieza nodo:145 / Elemento padre: 119   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(145)).setAttribute("ID","3" );
      ((Element)v.get(119)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(146)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(146)).setAttribute("TIPO","STRING" );
      ((Element)v.get(146)).setAttribute("VALOR","COD5" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */

      /* Empieza nodo:147 / Elemento padre: 145   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(147)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(147)).setAttribute("TIPO","STRING" );
      ((Element)v.get(147)).setAttribute("VALOR","x1" );
      ((Element)v.get(145)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */

      /* Empieza nodo:148 / Elemento padre: 145   */
      v.add(doc.createElement("CAMPO"));
   }

   private void getXML630(Document doc) {
      ((Element)v.get(148)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(148)).setAttribute("TIPO","STRING" );
      ((Element)v.get(148)).setAttribute("VALOR","x1" );
      ((Element)v.get(145)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */

      /* Empieza nodo:149 / Elemento padre: 145   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(149)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(149)).setAttribute("TIPO","STRING" );
      ((Element)v.get(149)).setAttribute("VALOR","" );
      ((Element)v.get(145)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:145   */

      /* Empieza nodo:150 / Elemento padre: 119   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(150)).setAttribute("ID","3" );
      ((Element)v.get(119)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(151)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(151)).setAttribute("TIPO","STRING" );
      ((Element)v.get(151)).setAttribute("VALOR","COD6" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */

      /* Empieza nodo:152 / Elemento padre: 150   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(152)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(152)).setAttribute("TIPO","STRING" );
      ((Element)v.get(152)).setAttribute("VALOR","x1" );
      ((Element)v.get(150)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */

      /* Empieza nodo:153 / Elemento padre: 150   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(153)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(153)).setAttribute("TIPO","STRING" );
      ((Element)v.get(153)).setAttribute("VALOR","x1" );
      ((Element)v.get(150)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */

      /* Empieza nodo:154 / Elemento padre: 150   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(154)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(154)).setAttribute("TIPO","STRING" );
      ((Element)v.get(154)).setAttribute("VALOR","" );
      ((Element)v.get(150)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:150   */

      /* Empieza nodo:155 / Elemento padre: 119   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(155)).setAttribute("ID","1" );
      ((Element)v.get(119)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(156)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(156)).setAttribute("TIPO","STRING" );
      ((Element)v.get(156)).setAttribute("VALOR","COD0" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */

      /* Empieza nodo:157 / Elemento padre: 155   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(157)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(157)).setAttribute("TIPO","STRING" );
      ((Element)v.get(157)).setAttribute("VALOR","x1" );
      ((Element)v.get(155)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */

      /* Empieza nodo:158 / Elemento padre: 155   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(158)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(158)).setAttribute("TIPO","STRING" );
      ((Element)v.get(158)).setAttribute("VALOR","x1" );
      ((Element)v.get(155)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */

      /* Empieza nodo:159 / Elemento padre: 155   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(159)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(159)).setAttribute("TIPO","STRING" );
      ((Element)v.get(159)).setAttribute("VALOR","" );
      ((Element)v.get(155)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:155   */

      /* Empieza nodo:160 / Elemento padre: 119   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(160)).setAttribute("ID","2" );
      ((Element)v.get(119)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(161)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(161)).setAttribute("TIPO","STRING" );
      ((Element)v.get(161)).setAttribute("VALOR","COD1" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */

      /* Empieza nodo:162 / Elemento padre: 160   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(162)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(162)).setAttribute("TIPO","STRING" );
      ((Element)v.get(162)).setAttribute("VALOR","x1" );
      ((Element)v.get(160)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */

      /* Empieza nodo:163 / Elemento padre: 160   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(163)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(163)).setAttribute("TIPO","STRING" );
      ((Element)v.get(163)).setAttribute("VALOR","x1" );
      ((Element)v.get(160)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */

      /* Empieza nodo:164 / Elemento padre: 160   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(164)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(164)).setAttribute("TIPO","STRING" );
      ((Element)v.get(164)).setAttribute("VALOR","" );
      ((Element)v.get(160)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:160   */

      /* Empieza nodo:165 / Elemento padre: 119   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(165)).setAttribute("ID","3" );
      ((Element)v.get(119)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(166)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(166)).setAttribute("TIPO","STRING" );
      ((Element)v.get(166)).setAttribute("VALOR","COD2" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */

      /* Empieza nodo:167 / Elemento padre: 165   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(167)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(167)).setAttribute("TIPO","STRING" );
      ((Element)v.get(167)).setAttribute("VALOR","x1" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(165)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */

      /* Empieza nodo:168 / Elemento padre: 165   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(168)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(168)).setAttribute("TIPO","STRING" );
      ((Element)v.get(168)).setAttribute("VALOR","x1" );
      ((Element)v.get(165)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */

      /* Empieza nodo:169 / Elemento padre: 165   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(169)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(169)).setAttribute("TIPO","STRING" );
      ((Element)v.get(169)).setAttribute("VALOR","" );
      ((Element)v.get(165)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:165   */
      /* Termina nodo:119   */

      /* Empieza nodo:170 / Elemento padre: 97   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(170)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(170)).setAttribute("ancho","708" );
      ((Element)v.get(170)).setAttribute("sep","$" );
      ((Element)v.get(170)).setAttribute("x","12" );
      ((Element)v.get(170)).setAttribute("class","botonera" );
      ((Element)v.get(170)).setAttribute("y","400" );
      ((Element)v.get(170)).setAttribute("control","" );
      ((Element)v.get(170)).setAttribute("conector","" );
      ((Element)v.get(170)).setAttribute("rowset","" );
      ((Element)v.get(170)).setAttribute("cargainicial","N" );
      ((Element)v.get(170)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(97)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(171)).setAttribute("nombre","ret1" );
      ((Element)v.get(171)).setAttribute("x","37" );
      ((Element)v.get(171)).setAttribute("y","404" );
      ((Element)v.get(171)).setAttribute("ID","botonContenido" );
      ((Element)v.get(171)).setAttribute("img","retroceder_on" );
      ((Element)v.get(171)).setAttribute("tipo","0" );
      ((Element)v.get(171)).setAttribute("estado","false" );
      ((Element)v.get(171)).setAttribute("alt","" );
      ((Element)v.get(171)).setAttribute("codigo","" );
      ((Element)v.get(171)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */

      /* Empieza nodo:172 / Elemento padre: 170   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(172)).setAttribute("nombre","ava1" );
      ((Element)v.get(172)).setAttribute("x","52" );
      ((Element)v.get(172)).setAttribute("y","404" );
      ((Element)v.get(172)).setAttribute("ID","botonContenido" );
      ((Element)v.get(172)).setAttribute("img","avanzar_on" );
      ((Element)v.get(172)).setAttribute("tipo","0" );
      ((Element)v.get(172)).setAttribute("estado","false" );
      ((Element)v.get(172)).setAttribute("alt","" );
      ((Element)v.get(172)).setAttribute("codigo","" );
      ((Element)v.get(172)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(170)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:170   */
      /* Termina nodo:97   */

      /* Empieza nodo:173 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(173)).setAttribute("nombre","primera1" );
      ((Element)v.get(173)).setAttribute("x","20" );
      ((Element)v.get(173)).setAttribute("y","404" );
      ((Element)v.get(173)).setAttribute("ID","botonContenido" );
      ((Element)v.get(173)).setAttribute("img","primera_on" );
      ((Element)v.get(173)).setAttribute("tipo","-2" );
      ((Element)v.get(173)).setAttribute("estado","false" );
      ((Element)v.get(173)).setAttribute("alt","" );
      ((Element)v.get(173)).setAttribute("codigo","" );
      ((Element)v.get(173)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(7)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */

      /* Empieza nodo:174 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(174)).setAttribute("nombre","separa" );
      ((Element)v.get(174)).setAttribute("x","59" );
      ((Element)v.get(174)).setAttribute("y","400" );
      ((Element)v.get(174)).setAttribute("ID","botonContenido" );
      ((Element)v.get(174)).setAttribute("img","separa_base" );
      ((Element)v.get(174)).setAttribute("tipo","0" );
      ((Element)v.get(174)).setAttribute("estado","false" );
      ((Element)v.get(174)).setAttribute("alt","" );
      ((Element)v.get(174)).setAttribute("codigo","" );
      ((Element)v.get(174)).setAttribute("accion","" );
      ((Element)v.get(7)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */

      /* Empieza nodo:175 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(175)).setAttribute("nombre","Modificar" );
      ((Element)v.get(175)).setAttribute("x","80" );
      ((Element)v.get(175)).setAttribute("y","401" );
      ((Element)v.get(175)).setAttribute("ID","botonContenido" );
      ((Element)v.get(175)).setAttribute("img","" );
      ((Element)v.get(175)).setAttribute("tipo","html" );
      ((Element)v.get(175)).setAttribute("estado","false" );
      ((Element)v.get(175)).setAttribute("cod","2" );
      ((Element)v.get(175)).setAttribute("accion","modificar();" );
      ((Element)v.get(175)).setAttribute("ontab","focoCodigo();" );
      ((Element)v.get(175)).setAttribute("onshtab","TabShift();" );
      ((Element)v.get(7)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */

      /* Empieza nodo:176 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(176)).setAttribute("nombre","Detalle" );
      ((Element)v.get(176)).setAttribute("x","80" );
      ((Element)v.get(176)).setAttribute("y","401" );
      ((Element)v.get(176)).setAttribute("ID","botonContenido" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(176)).setAttribute("img","" );
      ((Element)v.get(176)).setAttribute("tipo","html" );
      ((Element)v.get(176)).setAttribute("estado","false" );
      ((Element)v.get(176)).setAttribute("cod","3" );
      ((Element)v.get(176)).setAttribute("accion","detalle();" );
      ((Element)v.get(176)).setAttribute("ontab","focoCodigo();" );
      ((Element)v.get(176)).setAttribute("onshtab","TabShift();" );
      ((Element)v.get(7)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */

      /* Empieza nodo:177 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(177)).setAttribute("nombre","Elimina" );
      ((Element)v.get(177)).setAttribute("x","80" );
      ((Element)v.get(177)).setAttribute("y","401" );
      ((Element)v.get(177)).setAttribute("ID","botonContenido" );
      ((Element)v.get(177)).setAttribute("img","" );
      ((Element)v.get(177)).setAttribute("tipo","html" );
      ((Element)v.get(177)).setAttribute("estado","false" );
      ((Element)v.get(177)).setAttribute("cod","1254" );
      ((Element)v.get(177)).setAttribute("accion","eliminar();" );
      ((Element)v.get(177)).setAttribute("ontab","focoCodigo();" );
      ((Element)v.get(177)).setAttribute("onshtab","TabShift();" );
      ((Element)v.get(7)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */

      /* Empieza nodo:178 / Elemento padre: 7   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(178)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(178)).setAttribute("alto","18" );
      ((Element)v.get(178)).setAttribute("ancho","100" );
      ((Element)v.get(178)).setAttribute("colorf","" );
      ((Element)v.get(178)).setAttribute("borde","0" );
      ((Element)v.get(178)).setAttribute("imagenf","" );
      ((Element)v.get(178)).setAttribute("repeat","" );
      ((Element)v.get(178)).setAttribute("padding","" );
      ((Element)v.get(178)).setAttribute("visibilidad","visible" );
      ((Element)v.get(178)).setAttribute("contravsb","" );
      ((Element)v.get(178)).setAttribute("x","0" );
      ((Element)v.get(178)).setAttribute("y","423" );
      ((Element)v.get(178)).setAttribute("zindex","" );
      ((Element)v.get(7)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:7   */


   }

}
