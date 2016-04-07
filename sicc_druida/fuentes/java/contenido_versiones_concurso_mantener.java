
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_versiones_concurso_mantener  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_versiones_concurso_mantener" );
      ((Element)v.get(0)).setAttribute("cod","0494" );
      ((Element)v.get(0)).setAttribute("titulo","Mantener Versiones Concurso" );
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
      v.add(doc.createTextNode("\r   \r\r  var LP = 'LPMantenimientoVersiones';\r\r  function onLoadPag()  {  	  \r      configurarMenuSecundario(\"formulario\");\r	  DrdEnsanchaConMargenDcho('listado1',12);\r      document.all[\"Cplistado1\"].style.visibility='';\r      document.all[\"CpLin1listado1\"].style.visibility='';\r      document.all[\"CpLin2listado1\"].style.visibility='';\r      document.all[\"CpLin3listado1\"].style.visibility='';\r      document.all[\"CpLin4listado1\"].style.visibility='';\r      document.all[\"primera1Div\"].style.visibility='';\r      document.all[\"ret1Div\"].style.visibility='';\r      document.all[\"ava1Div\"].style.visibility='';\r      document.all[\"separaDiv\"].style.visibility='';	    \r      eval (ON_RSZ);\r\r      var arr = [ [\"oidPais\", get(\"formulario.oidPais\")], [\"oidIdioma\", get(\"formulario.oidIdioma\")] ];\r	  configurarPaginado(mipgndo, \"INCObtenerVersionesConcurso\", \"ConectorVersionesConcurso\", \r  	  \"es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOOIDPaginado\", arr);\r\r	  btnProxy(1,0);\r	  btnProxy(2,1);\r	  btnProxy(3,0);\r	  btnProxy(4,0);	  \r      btnProxy(5,1);\r	  btnProxy(6,0);\r	  btnProxy(7,0);\r\r	  focalizaBotonHTML_XY('btnSolicitaAutorizacion');\r   }\r  \r  function accionSolicitarAutorizacion() {   \r	    pos = chkPos();		\r\r		if (pos != -1) {   \r			var maxVersion = obtenerMaximoNumeroVersion();\r\r		    set('formulario.maxVersion', maxVersion);	\r			set('formulario.oid', listado1.datos[pos][0]);\r	        set('formulario.oidConcurso', listado1.datos[pos][1]);\r		    set('formulario.oidConcursoOrigen', listado1.datos[pos][2]);\r			set('formulario.numeroConcurso', listado1.datos[pos][3]);\r	        set('formulario._version', listado1.datos[pos][4]);\r		    set('formulario.oidPeriodoDesde', listado1.datos[pos][7]);\r		    set('formulario.fechaInicio', listado1.datos[pos][9]);\r		    set('formulario.fechaFin', listado1.datos[pos][10]);	\r			set('formulario.oidEstadoConcurso', listado1.datos[pos][5]);	\r\r			callMethod('autorizacion');\r		}\r	}\r\r			/*function accionSolicitarAutorizacion() {   \r		eval('formulario').oculto = 'S';\r		set('formulario.conectorAction', \"LPMantenimientoVersiones\");\r	    set('formulario.accion', 'autorizacion');\r		enviaSICC('formulario', null, null, 'N');	\r	}\r	function fin() {\r		alert(\"fin\");\r	}*/\r\r	function obtenerMaximoNumeroVersion() {\r		pos = chkPos();\r		var numConcursoSelecc = listado1.datos[pos][3];\r		var version = \"\";\r\r		for(var i=0; i<listado1.datos.length; i++) {\r			if(numConcursoSelecc == listado1.datos[i][3]) {\r				if(i==0) {\r					version = listado1.datos[i][4];\r				}\r				else {\r					if(version<listado1.datos[i][4]) {\r						version = listado1.datos[i][4];\r					}\r				}				\r			}\r		}\r\r		return version;\r	}\r\r\r	/*\r    * Ejecuta el cierre de la ventana modal luedo de guardar la modificacion.\r    */\r    function vueltaSolicitarAutorizacion() {\r				var arr = [ [\"oidPais\", get(\"formulario.oidPais\")], [\"oidIdioma\", get(\"formulario.oidIdioma\")] ];\r		configurarPaginado(mipgndo, \r						 \"INCObtenerVersionesConcurso\", \r						 \"ConectorVersionesConcurso\", \r						 \"es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOOIDPaginado\",\r						 arr);\r    }	\r\r	function accionModificarConcurso() 	{	\r	    pos = chkPos()\r        if (pos != -1) {   \r		    if ( listado1.datos[pos][5] == get('formulario.cteEstadoAutorizado')) {   \r			    obj = new Object();\r 	            obj.oid = listado1.datos[pos][0];\r		 	    obj.oidConcursoOrigen = listado1.datos[pos][2];\r			    obj.oidEstado = listado1.datos[pos][5];\r				obj.numeroConcurso = listado1.datos[pos][3];  		 	 	obj.oidConcurso = listado1.datos[pos][1];   			    obj._version = listado1.datos[pos][4];\r					   \r				 var datosNuevaVersion = mostrarModalSICC(LP, 'generar', obj, 820, 200);\r				 				 if (datosNuevaVersion != null) {   \r												eval('formulario').oculto = 'S';\r						set('formulario.conectorAction', LP);\r						set('formulario.oid', obj.oid);\r						set('formulario.datosNuevaVersion', datosNuevaVersion);						\r						set('formulario.accion', 'modificar');\r						enviaSICC('formulario', null, null, 'N');\r				  } \r		   }\r		    else\r		       GestionarMensaje(1564); \r	    }\r	}	\r\r	/* Ssantana, 09/05/2006, versionado */ \r	function accionPuestaMarcha() {   \r		pos = chkPos()\r        if (pos != -1) { \r		  if (listado1.datos[pos][5] == get('formulario.cteEstadoModificacion')) {  			  \r			 var puestaEnMarcha = listado1.datos[pos][11];\r			 /*alert(\"puestaEnMarcha \" + puestaEnMarcha);\r 			 alert(\"listado1.datos[pos] \" + listado1.datos[pos]);*/\r			 if (puestaEnMarcha != undefined && puestaEnMarcha != null && puestaEnMarcha != '') {\r				 set('formulario.oid', listado1.datos[pos][0]);\r				 eval('formulario').oculto='S';		\r				 set('formulario.conectorAction', \"LPMantenimientoVersiones\");\r				 set('formulario.accion', 'puesta marcha');\r		  		 enviaSICC('formulario', null, null, 'N');\r			 }\r			 else {\r				GestionarMensaje(\"INC056\");\r											 }\r		  } else {\r		    GestionarMensaje(1565); \r		  }\r		}  \r	}\r	/* Ssantana, 09/05/2006, versionado */ \r\r	function accionBorrarSolicitudRechazada(){   \r	    pos = chkPos()\r        if (pos != -1) {\r		   if (listado1.datos[pos][5] == get('formulario.cteEstadoRechazadaAutorizacion')) { \r		      set('formulario.oid', listado1.datos[pos][0]);\r\r			  eval('formulario').oculto='S';		\r		  	  set('formulario.conectorAction', \"LPMantenimientoVersiones\");\r			  set('formulario.accion', \"actualizar solicitud rechazada\");\r			  enviaSICC('formulario', null, null, 'N');\r		   }\r		   else \r		      GestionarMensaje(1566);		    \r		}\r	}\r\r	function vueltaActualizarSolicitudRechazada() {\r		eval('formulario').oculto='S';	\r				var arr = [ [\"oidPais\", get(\"formulario.oidPais\")], [\"oidIdioma\", get(\"formulario.oidIdioma\")] ];\r		configurarPaginado(mipgndo, \r						 \"INCObtenerVersionesConcurso\", \r						 \"ConectorVersionesConcurso\", \r						 \"es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOOIDPaginado\",\r						 arr);\r	}\r\r	function accionBorrarModificacionRechazada() {  \r	   pos = chkPos()\r       if ( pos != -1) {\r	      if (listado1.datos[pos][5] == get('formulario.cteEstadoRechazadaAprobacion')) { \r		    set('formulario.oid', listado1.datos[pos][0]);\r												set('formulario.oidConcurso', listado1.datos[pos][1]);\r		    eval('formulario').oculto='S';		\r	  	    set('formulario.conectorAction', \"LPMantenimientoVersiones\");\r			set('formulario.accion', \"borrar modificacion rechazada\");\r			enviaSICC('formulario', null, null, 'N');\r		  }\r		  else\r		    GestionarMensaje(1567); \r	   }\r	}\r\r	function vueltaBorrarModificacion() {\r		eval('formulario').oculto='S';	\r				var arr = [ [\"oidPais\", get(\"formulario.oidPais\")], [\"oidIdioma\", get(\"formulario.oidIdioma\")] ];\r		configurarPaginado(mipgndo, \r						 \"INCObtenerVersionesConcurso\", \r						 \"ConectorVersionesConcurso\", \r						 \"es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOOIDPaginado\",\r						 arr);\r	}\r\r	function accionBorrarModificacion()	{  \r	   pos = chkPos()\r       if ( pos != -1) {\r	      if (listado1.datos[pos][5] == get('formulario.cteEstadoModificacion')) { \r		    set('formulario.oid', listado1.datos[pos][0]);\r			callMethod('borrar modificacion', true);\r		  }\r		  else\r		    GestionarMensaje(1568);\r	   }\r	}\r\r      function chkPos()  {	\r		if (listado1.numSelecc() == 1)\r			return obtenerPosicionListaEditable(listado1.codSeleccionados(), listado1);			\r		else {  \r			if (listado1.numSelecc() > 1)\r			  cdos_mostrarAlert(GestionarMensaje(\"240\"));	  \r		    else {  \r				if (listado1.numSelecc() < 1)\r				  GestionarMensaje(\"4\");\r		    }\r		}\r		return -1;\r	} \r	\r		function callMethod() {  \r		if (!arguments[1]) {\r			eval('formulario').oculto='S';\r		}\r		\r		set('formulario.conectorAction', (arguments[2]) ? arguments[2] : LP);\r		set('formulario.accion', arguments[0]);\r		enviaSICC('formulario', null, null, 'N');\r	}\r   \r   \r"));
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
      ((Element)v.get(14)).setAttribute("nombre","cteEstadoAutorizado" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","cteEstadoModificacion" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","cteEstadoRechazadaAutorizacion" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","cteEstadoRechazadaAprobacion" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","oid" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","oidConcursoOrigen" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","_version" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","oidConcurso" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","numeroConcurso" );
      ((Element)v.get(22)).setAttribute("valor","" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(6)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","fechaInicio" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","fechaFin" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","oidPeriodoHasta" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","oidPeriodoDesde" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","varChkPagoATiempo" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","datosNuevaVersion" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","oidGenerada" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","maxVersion" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","oidEstadoConcurso" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 6   */
      v.add(doc.createElement("table"));
      ((Element)v.get(32)).setAttribute("width","100%" );
      ((Element)v.get(32)).setAttribute("border","0" );
      ((Element)v.get(32)).setAttribute("cellspacing","0" );
      ((Element)v.get(32)).setAttribute("cellpadding","0" );
      ((Element)v.get(6)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(34)).setAttribute("width","100%" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(35)).setAttribute("src","b.gif" );
      ((Element)v.get(35)).setAttribute("width","580" );
      ((Element)v.get(35)).setAttribute("height","8" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */
      /* Termina nodo:34   */
      /* Termina nodo:33   */
      /* Termina nodo:32   */

      /* Empieza nodo:36 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(36)).setAttribute("nombre","listado1" );
      ((Element)v.get(36)).setAttribute("ancho","556" );
      ((Element)v.get(36)).setAttribute("alto","322" );
      ((Element)v.get(36)).setAttribute("x","12" );
      ((Element)v.get(36)).setAttribute("y","12" );
      ((Element)v.get(36)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(36)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(37)).setAttribute("precarga","S" );
      ((Element)v.get(37)).setAttribute("conROver","S" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(38)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(38)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(38)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(38)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 37   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(39)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(39)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(39)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(39)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(37)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 37   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(40)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(40)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(37)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */
      /* Termina nodo:37   */

      /* Empieza nodo:41 / Elemento padre: 36   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(36)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(42)).setAttribute("borde","1" );
      ((Element)v.get(42)).setAttribute("horizDatos","1" );
      ((Element)v.get(42)).setAttribute("horizCabecera","1" );
      ((Element)v.get(42)).setAttribute("vertical","1" );
      ((Element)v.get(42)).setAttribute("horizTitulo","1" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(42)).setAttribute("horizBase","1" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 41   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(43)).setAttribute("borde","#999999" );
      ((Element)v.get(43)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(43)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(43)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(43)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(43)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(43)).setAttribute("horizBase","#999999" );
      ((Element)v.get(41)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:41   */

      /* Empieza nodo:44 / Elemento padre: 36   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(44)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(44)).setAttribute("alto","22" );
      ((Element)v.get(44)).setAttribute("imgFondo","" );
      ((Element)v.get(44)).setAttribute("cod","00283" );
      ((Element)v.get(44)).setAttribute("ID","datosTitle" );
      ((Element)v.get(36)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 36   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(45)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(45)).setAttribute("alto","44" );
      ((Element)v.get(45)).setAttribute("imgFondo","" );
      ((Element)v.get(36)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 36   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(46)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(46)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(46)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(46)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(46)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(46)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(36)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(47)).setAttribute("ancho","100" );
      ((Element)v.get(47)).setAttribute("minimizable","S" );
      ((Element)v.get(47)).setAttribute("minimizada","N" );
      ((Element)v.get(47)).setAttribute("oculta","S" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 46   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(48)).setAttribute("ancho","100" );
      ((Element)v.get(48)).setAttribute("minimizable","S" );
      ((Element)v.get(48)).setAttribute("minimizada","N" );
      ((Element)v.get(48)).setAttribute("oculta","S" );
      ((Element)v.get(46)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 46   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(49)).setAttribute("ancho","100" );
      ((Element)v.get(49)).setAttribute("minimizable","S" );
      ((Element)v.get(49)).setAttribute("minimizada","N" );
      ((Element)v.get(46)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 46   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(50)).setAttribute("ancho","100" );
      ((Element)v.get(50)).setAttribute("minimizable","S" );
      ((Element)v.get(50)).setAttribute("minimizada","N" );
      ((Element)v.get(46)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 46   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(51)).setAttribute("ancho","100" );
      ((Element)v.get(51)).setAttribute("minimizable","S" );
      ((Element)v.get(51)).setAttribute("minimizada","N" );
      ((Element)v.get(51)).setAttribute("oculta","S" );
      ((Element)v.get(46)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 46   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(52)).setAttribute("ancho","100" );
      ((Element)v.get(52)).setAttribute("minimizable","S" );
      ((Element)v.get(52)).setAttribute("minimizada","N" );
      ((Element)v.get(46)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 46   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(53)).setAttribute("ancho","100" );
      ((Element)v.get(53)).setAttribute("minimizable","S" );
      ((Element)v.get(53)).setAttribute("minimizada","N" );
      ((Element)v.get(53)).setAttribute("oculta","S" );
      ((Element)v.get(46)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 46   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(54)).setAttribute("ancho","100" );
      ((Element)v.get(54)).setAttribute("minimizable","S" );
      ((Element)v.get(54)).setAttribute("minimizada","N" );
      ((Element)v.get(54)).setAttribute("oculta","S" );
      ((Element)v.get(46)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 46   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(55)).setAttribute("ancho","100" );
      ((Element)v.get(55)).setAttribute("minimizable","S" );
      ((Element)v.get(55)).setAttribute("minimizada","N" );
      ((Element)v.get(55)).setAttribute("oculta","S" );
      ((Element)v.get(46)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 46   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(56)).setAttribute("ancho","100" );
      ((Element)v.get(56)).setAttribute("minimizable","S" );
      ((Element)v.get(56)).setAttribute("minimizada","N" );
      ((Element)v.get(56)).setAttribute("oculta","S" );
      ((Element)v.get(46)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 46   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(57)).setAttribute("ancho","100" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(57)).setAttribute("minimizable","S" );
      ((Element)v.get(57)).setAttribute("minimizada","N" );
      ((Element)v.get(57)).setAttribute("oculta","S" );
      ((Element)v.get(46)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:46   */

      /* Empieza nodo:58 / Elemento padre: 36   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(58)).setAttribute("alto","20" );
      ((Element)v.get(58)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(58)).setAttribute("imgFondo","" );
      ((Element)v.get(58)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(36)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(59)).setAttribute("colFondo","" );
      ((Element)v.get(59)).setAttribute("ID","EstCab" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Elemento padre:59 / Elemento actual: 60   */
      v.add(doc.createTextNode("oidConcurso"));
      ((Element)v.get(59)).appendChild((Text)v.get(60));

      /* Termina nodo Texto:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 58   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(61)).setAttribute("colFondo","" );
      ((Element)v.get(61)).setAttribute("ID","EstCab" );
      ((Element)v.get(58)).appendChild((Element)v.get(61));

      /* Elemento padre:61 / Elemento actual: 62   */
      v.add(doc.createTextNode("oidConcursoOrigen"));
      ((Element)v.get(61)).appendChild((Text)v.get(62));

      /* Termina nodo Texto:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 58   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(63)).setAttribute("colFondo","" );
      ((Element)v.get(63)).setAttribute("ID","EstCab" );
      ((Element)v.get(63)).setAttribute("cod","1604" );
      ((Element)v.get(58)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 58   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(64)).setAttribute("colFondo","" );
      ((Element)v.get(64)).setAttribute("ID","EstCab" );
      ((Element)v.get(64)).setAttribute("cod","1607" );
      ((Element)v.get(58)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */

      /* Empieza nodo:65 / Elemento padre: 58   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(65)).setAttribute("colFondo","" );
      ((Element)v.get(65)).setAttribute("ID","EstCab" );
      ((Element)v.get(58)).appendChild((Element)v.get(65));

      /* Elemento padre:65 / Elemento actual: 66   */
      v.add(doc.createTextNode("oidEstado"));
      ((Element)v.get(65)).appendChild((Text)v.get(66));

      /* Termina nodo Texto:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:67 / Elemento padre: 58   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(67)).setAttribute("colFondo","" );
      ((Element)v.get(67)).setAttribute("ID","EstCab" );
      ((Element)v.get(67)).setAttribute("cod","1641" );
      ((Element)v.get(58)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */

      /* Empieza nodo:68 / Elemento padre: 58   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(68)).setAttribute("colFondo","" );
      ((Element)v.get(68)).setAttribute("ID","EstCab" );
      ((Element)v.get(58)).appendChild((Element)v.get(68));

      /* Elemento padre:68 / Elemento actual: 69   */
      v.add(doc.createTextNode("oidPeriodoDesde"));
      ((Element)v.get(68)).appendChild((Text)v.get(69));

      /* Termina nodo Texto:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:70 / Elemento padre: 58   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(70)).setAttribute("colFondo","" );
      ((Element)v.get(70)).setAttribute("ID","EstCab" );
      ((Element)v.get(58)).appendChild((Element)v.get(70));

      /* Elemento padre:70 / Elemento actual: 71   */
      v.add(doc.createTextNode("oidPeriodoHasta"));
      ((Element)v.get(70)).appendChild((Text)v.get(71));

      /* Termina nodo Texto:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:72 / Elemento padre: 58   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(72)).setAttribute("colFondo","" );
      ((Element)v.get(72)).setAttribute("ID","EstCab" );
      ((Element)v.get(58)).appendChild((Element)v.get(72));

      /* Elemento padre:72 / Elemento actual: 73   */
      v.add(doc.createTextNode("oidFechaInicio"));
      ((Element)v.get(72)).appendChild((Text)v.get(73));

      /* Termina nodo Texto:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:74 / Elemento padre: 58   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(74)).setAttribute("colFondo","" );
      ((Element)v.get(74)).setAttribute("ID","EstCab" );
      ((Element)v.get(58)).appendChild((Element)v.get(74));

      /* Elemento padre:74 / Elemento actual: 75   */
      v.add(doc.createTextNode("oidFechaFin"));
      ((Element)v.get(74)).appendChild((Text)v.get(75));

      /* Termina nodo Texto:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 58   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(76)).setAttribute("colFondo","" );
      ((Element)v.get(76)).setAttribute("ID","EstCab" );
      ((Element)v.get(58)).appendChild((Element)v.get(76));

      /* Elemento padre:76 / Elemento actual: 77   */
      v.add(doc.createTextNode("OidPuestaEnMarca"));
      ((Element)v.get(76)).appendChild((Text)v.get(77));

      /* Termina nodo Texto:77   */
      /* Termina nodo:76   */
      /* Termina nodo:58   */

      /* Empieza nodo:78 / Elemento padre: 36   */
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
      ((Element)v.get(36)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(79)).setAttribute("tipo","texto" );
      ((Element)v.get(79)).setAttribute("ID","EstDat" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */

      /* Empieza nodo:80 / Elemento padre: 78   */
      v.add(doc.createElement("COL"));
   }

   private void getXML360(Document doc) {
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

      /* Empieza nodo:82 / Elemento padre: 78   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(82)).setAttribute("tipo","texto" );
      ((Element)v.get(82)).setAttribute("ID","EstDat2" );
      ((Element)v.get(78)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 78   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(83)).setAttribute("tipo","texto" );
      ((Element)v.get(83)).setAttribute("ID","EstDat" );
      ((Element)v.get(78)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */

      /* Empieza nodo:84 / Elemento padre: 78   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(84)).setAttribute("tipo","texto" );
      ((Element)v.get(84)).setAttribute("ID","EstDat" );
      ((Element)v.get(78)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */

      /* Empieza nodo:85 / Elemento padre: 78   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(85)).setAttribute("tipo","texto" );
      ((Element)v.get(85)).setAttribute("ID","EstDat2" );
      ((Element)v.get(78)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 78   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(86)).setAttribute("tipo","texto" );
      ((Element)v.get(86)).setAttribute("ID","EstDat" );
      ((Element)v.get(78)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 78   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(87)).setAttribute("tipo","texto" );
      ((Element)v.get(87)).setAttribute("ID","EstDat2" );
      ((Element)v.get(78)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */

      /* Empieza nodo:88 / Elemento padre: 78   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(88)).setAttribute("tipo","texto" );
      ((Element)v.get(88)).setAttribute("ID","EstDat" );
      ((Element)v.get(78)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */

      /* Empieza nodo:89 / Elemento padre: 78   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(89)).setAttribute("tipo","texto" );
      ((Element)v.get(89)).setAttribute("ID","EstDat" );
      ((Element)v.get(78)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:78   */

      /* Empieza nodo:90 / Elemento padre: 36   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(36)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */

      /* Empieza nodo:91 / Elemento padre: 36   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(91)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(91)).setAttribute("ancho","556" );
      ((Element)v.get(91)).setAttribute("sep","$" );
      ((Element)v.get(91)).setAttribute("x","12" );
      ((Element)v.get(91)).setAttribute("class","botonera" );
      ((Element)v.get(91)).setAttribute("y","289" );
      ((Element)v.get(91)).setAttribute("control","|" );
      ((Element)v.get(91)).setAttribute("conector","conector_inc" );
      ((Element)v.get(91)).setAttribute("rowset","" );
      ((Element)v.get(91)).setAttribute("cargainicial","N" );
      ((Element)v.get(36)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(92)).setAttribute("nombre","ret1" );
      ((Element)v.get(92)).setAttribute("x","37" );
      ((Element)v.get(92)).setAttribute("y","304" );
      ((Element)v.get(92)).setAttribute("ID","botonContenido" );
      ((Element)v.get(92)).setAttribute("img","retroceder_on" );
      ((Element)v.get(92)).setAttribute("tipo","0" );
      ((Element)v.get(92)).setAttribute("estado","false" );
      ((Element)v.get(92)).setAttribute("alt","" );
      ((Element)v.get(92)).setAttribute("codigo","" );
      ((Element)v.get(92)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */

      /* Empieza nodo:93 / Elemento padre: 91   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(93)).setAttribute("nombre","ava1" );
      ((Element)v.get(93)).setAttribute("x","52" );
      ((Element)v.get(93)).setAttribute("y","304" );
      ((Element)v.get(93)).setAttribute("ID","botonContenido" );
      ((Element)v.get(93)).setAttribute("img","avanzar_on" );
      ((Element)v.get(93)).setAttribute("tipo","0" );
      ((Element)v.get(93)).setAttribute("estado","false" );
      ((Element)v.get(93)).setAttribute("alt","" );
      ((Element)v.get(93)).setAttribute("codigo","" );
      ((Element)v.get(93)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(91)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:91   */
      /* Termina nodo:36   */

      /* Empieza nodo:94 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(94)).setAttribute("nombre","primera1" );
      ((Element)v.get(94)).setAttribute("x","20" );
      ((Element)v.get(94)).setAttribute("y","304" );
      ((Element)v.get(94)).setAttribute("ID","botonContenido" );
      ((Element)v.get(94)).setAttribute("img","primera_on" );
      ((Element)v.get(94)).setAttribute("tipo","-2" );
      ((Element)v.get(94)).setAttribute("estado","false" );
      ((Element)v.get(94)).setAttribute("alt","" );
      ((Element)v.get(94)).setAttribute("codigo","" );
      ((Element)v.get(94)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(6)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */

      /* Empieza nodo:95 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(95)).setAttribute("nombre","separa" );
      ((Element)v.get(95)).setAttribute("x","59" );
      ((Element)v.get(95)).setAttribute("y","289" );
      ((Element)v.get(95)).setAttribute("ID","botonContenido" );
      ((Element)v.get(95)).setAttribute("img","separa_base" );
      ((Element)v.get(95)).setAttribute("tipo","0" );
      ((Element)v.get(95)).setAttribute("estado","false" );
      ((Element)v.get(95)).setAttribute("alt","" );
      ((Element)v.get(95)).setAttribute("codigo","" );
      ((Element)v.get(95)).setAttribute("accion","" );
      ((Element)v.get(6)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */

      /* Empieza nodo:96 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(96)).setAttribute("nombre","separa2" );
      ((Element)v.get(96)).setAttribute("x","59" );
      ((Element)v.get(96)).setAttribute("y","311" );
      ((Element)v.get(96)).setAttribute("ID","botonContenido" );
      ((Element)v.get(96)).setAttribute("img","separa_base" );
      ((Element)v.get(96)).setAttribute("tipo","0" );
      ((Element)v.get(96)).setAttribute("estado","false" );
      ((Element)v.get(96)).setAttribute("alt","" );
      ((Element)v.get(96)).setAttribute("codigo","" );
      ((Element)v.get(96)).setAttribute("accion","" );
      ((Element)v.get(6)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */

      /* Empieza nodo:97 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(97)).setAttribute("nombre","btnSolicitaAutorizacion" );
      ((Element)v.get(97)).setAttribute("x","80" );
      ((Element)v.get(97)).setAttribute("y","290" );
      ((Element)v.get(97)).setAttribute("ID","botonContenido" );
      ((Element)v.get(97)).setAttribute("img","" );
      ((Element)v.get(97)).setAttribute("tipo","html" );
      ((Element)v.get(97)).setAttribute("estado","false" );
      ((Element)v.get(97)).setAttribute("cod","2818" );
      ((Element)v.get(97)).setAttribute("accion","accionSolicitarAutorizacion();" );
      ((Element)v.get(97)).setAttribute("onshtab","focalizaBotonHTML_XY('btnBorrarModificar')" );
      ((Element)v.get(6)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */

      /* Empieza nodo:98 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(98)).setAttribute("nombre","btnModificaConcurso" );
      ((Element)v.get(98)).setAttribute("x","230" );
      ((Element)v.get(98)).setAttribute("y","290" );
      ((Element)v.get(98)).setAttribute("ID","botonContenido" );
      ((Element)v.get(98)).setAttribute("img","" );
      ((Element)v.get(98)).setAttribute("tipo","html" );
      ((Element)v.get(98)).setAttribute("estado","false" );
      ((Element)v.get(98)).setAttribute("cod","0486" );
      ((Element)v.get(98)).setAttribute("accion","accionModificarConcurso();" );
      ((Element)v.get(6)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */

      /* Empieza nodo:99 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(99)).setAttribute("nombre","btnPuestaMarcha" );
      ((Element)v.get(99)).setAttribute("x","369" );
      ((Element)v.get(99)).setAttribute("y","290" );
      ((Element)v.get(99)).setAttribute("ID","botonContenido" );
      ((Element)v.get(99)).setAttribute("img","" );
      ((Element)v.get(99)).setAttribute("tipo","html" );
      ((Element)v.get(99)).setAttribute("estado","false" );
      ((Element)v.get(99)).setAttribute("cod","2819" );
      ((Element)v.get(99)).setAttribute("accion","accionPuestaMarcha();" );
      ((Element)v.get(6)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */

      /* Empieza nodo:100 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(100)).setAttribute("nombre","btnBorrarSolicitud" );
      ((Element)v.get(100)).setAttribute("x","80" );
      ((Element)v.get(100)).setAttribute("y","312" );
      ((Element)v.get(100)).setAttribute("ID","botonContenido" );
      ((Element)v.get(100)).setAttribute("img","" );
      ((Element)v.get(100)).setAttribute("tipo","html" );
      ((Element)v.get(100)).setAttribute("estado","false" );
      ((Element)v.get(100)).setAttribute("cod","2820" );
      ((Element)v.get(100)).setAttribute("accion","accionBorrarSolicitudRechazada();" );
      ((Element)v.get(6)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */

      /* Empieza nodo:101 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(101)).setAttribute("nombre","btnBorrarModificarRechazada" );
      ((Element)v.get(101)).setAttribute("x","272" );
      ((Element)v.get(101)).setAttribute("y","312" );
      ((Element)v.get(101)).setAttribute("ID","botonContenido" );
      ((Element)v.get(101)).setAttribute("img","" );
      ((Element)v.get(101)).setAttribute("tipo","html" );
      ((Element)v.get(101)).setAttribute("estado","false" );
      ((Element)v.get(101)).setAttribute("cod","2821" );
      ((Element)v.get(101)).setAttribute("accion","accionBorrarModificacionRechazada();" );
      ((Element)v.get(6)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */

      /* Empieza nodo:102 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(102)).setAttribute("nombre","btnBorrarModificar" );
      ((Element)v.get(102)).setAttribute("x","495" );
      ((Element)v.get(102)).setAttribute("y","312" );
      ((Element)v.get(102)).setAttribute("ID","botonContenido" );
      ((Element)v.get(102)).setAttribute("img","" );
      ((Element)v.get(102)).setAttribute("tipo","html" );
      ((Element)v.get(102)).setAttribute("estado","false" );
      ((Element)v.get(102)).setAttribute("cod","2822" );
      ((Element)v.get(102)).setAttribute("accion","accionBorrarModificacion();" );
      ((Element)v.get(102)).setAttribute("ontab","focalizaBotonHTML_XY('btnSolicitaAutorizacion')" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(6)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */

      /* Empieza nodo:103 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(103)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(103)).setAttribute("alto","12" );
      ((Element)v.get(103)).setAttribute("ancho","100" );
      ((Element)v.get(103)).setAttribute("colorf","" );
      ((Element)v.get(103)).setAttribute("borde","0" );
      ((Element)v.get(103)).setAttribute("imagenf","" );
      ((Element)v.get(103)).setAttribute("repeat","" );
      ((Element)v.get(103)).setAttribute("padding","" );
      ((Element)v.get(103)).setAttribute("visibilidad","visible" );
      ((Element)v.get(103)).setAttribute("contravsb","" );
      ((Element)v.get(103)).setAttribute("x","0" );
      ((Element)v.get(103)).setAttribute("y","334" );
      ((Element)v.get(103)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:6   */


   }

}
