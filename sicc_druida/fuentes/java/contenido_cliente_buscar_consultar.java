
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_cliente_buscar_consultar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_clientes_buscar_consultar" );
      ((Element)v.get(0)).setAttribute("cod","0409" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","cargarPagina();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(2));

      /* Elemento padre:2 / Elemento actual: 3   */
      v.add(doc.createTextNode("\r\r\r		\r		function cargarPagina(){\r			  		   configurarMenuSecundario(\"frmContenido\");\r\r			var hayErrores = chequeaErrores();\r			seteaTitulosPestanya();\r\r			if (hayErrores != true)\r			{\r					recargaCombos();\r					focaliza(\"frmContenido.cbTipoCliente\", \"\");\r					return;\r			}\r			recargaCombos();\r			focaliza(\"frmContenido.cbTipoCliente\", \"\");\r\r	}\r\r		function refreshSubTipo()\r		{\r\r			var oidSubTipo = get(\"frmContenido.oidSubTipo\");\r			var descSubTipo = get(\"frmContenido.descSubTipo\");\r			var padreSubTipo = get(\"frmContenido.padreSubTipo\");\r\r			var oidTipo = get(\"frmContenido.cbTipoCliente\");\r\r			oidSubTipo = oidSubTipo.split(\",\");\r			descSubTipo = descSubTipo.split(\",\");\r			padreSubTipo = padreSubTipo.split(\",\");\r\r			var opciones = new Array();\r			var longitud = oidSubTipo.length;\r\r			opciones[0] = [\"\",\"\"];\r			var j = 1;\r\r			for ( var i=1 ;  i < longitud; i++)\r			{\r					if (padreSubTipo[i] == oidTipo)\r					{\r						opciones[j] = [ oidSubTipo[i], descSubTipo[i] ];\r						j++;\r					}\r			}\r			set_combo(\"frmContenido.cbSubtipoCliente\", opciones);\r	\r		}\r\r function siguientePestanya(pestanya)\r {\r      \r      set(\"frmContenido.conectorAction\", \"LPBusquedaCliente\");\r      \r		if (pestanya == -1)\r		  set('frmContenido.accion', \"\");\r		if (pestanya == 1)\r   	  set('frmContenido.accion', \"siguientePestanya1\");\r      if (pestanya == 2)\r        set('frmContenido.accion', 'siguientePestanya2');\r      if (pestanya == 3)   \r         set('frmContenido.accion', 'siguientePestanya3');\r      if(pestanya == 4)   \r          set('frmContenido.accion', 'siguientePestanya4');\r			\r		set(\"frmContenido.conectorAction\", \"LPBusquedaCliente\");\r		seteaHiddens();\r		enviaSICC('frmContenido');  \r\r  }\r	\r	function seteaHiddens()\r	{\r				var tipo = get(\"frmContenido.cbTipoCliente\");\r		var subTipo = get(\"frmContenido.cbSubtipoCliente\");\r\r		set(\"frmContenido.hidTipo\", tipo);\r		set(\"frmContenido.hidSubTipo\", subTipo);\r\r	}\r\r	function recargaCombos()\r	{\r		var tipo = get(\"frmContenido.hidTipo\");\r		var subTipo = get(\"frmContenido.hidSubTipo\");\r		\r		set(\"frmContenido.cbTipoCliente\", new Array(tipo) );\r				refreshSubTipo();\r\r		set(\"frmContenido.cbSubtipoCliente\", new Array(subTipo) );\r\r	}\r\r	function buscar()\r	{\r		duplicaFormulario();\r\r		set(\"frmContenidoBusq.conectorAction\", \"LPBusquedaCliente\");\r		set(\"frmContenidoBusq.accion\", \"buscar\");\r\r		var tipo = get(\"frmContenido.cbTipoCliente\");\r		var subTipo = get(\"frmContenido.cbSubtipoCliente\");\r		var casoDeUso = get(\"frmContenido.casoDeUso\");\r\r		set(\"frmContenidoBusq.hidTipo\", tipo);\r		set(\"frmContenidoBusq.hidSubTipo\", subTipo);\r		set(\"frmContenidoBusq.casoDeUso\", casoDeUso);\r		\r		enviaSICC(\"frmContenidoBusq\");\r\r	}\r\r	function chequeaErrores()\r	{\r		var errCod = get(\"frmContenido.errCodigo\");\r\r		if (errCod != null)\r		{\r				fMostrarMensajeError();\r				return true;\r		}\r\r		return false;\r\r	}\r\r	function seteaTitulosPestanya()\r	{\r\r			var tituloP = GestionarMensaje(\"1512\", null, null, null);\r			document.getElementById(\"ConsultarPSub1\").innerText = tituloP;\r\r			var tituloP = GestionarMensaje(\"1511\", null, null, null);\r			document.getElementById(\"ConsultarP0\").innerText = tituloP;\r\r			var tituloP = GestionarMensaje(\"1507\", null, null, null);\r			document.getElementById(\"ConsultarP1\").innerText = tituloP;\r\r			var tituloP = GestionarMensaje(\"1508\", null, null, null);\r			document.getElementById(\"ConsultarP2\").innerText = tituloP;\r\r			var tituloP = GestionarMensaje(\"1509\", null, null, null);\r			document.getElementById(\"ConsultarP3\").innerText = tituloP;\r\r			var tituloP = GestionarMensaje(\"1510\", null, null, null);\r			document.getElementById(\"ConsultarP4\").innerText = tituloP;\r\r			document.getElementById(\"ConsultarP0\").style.backgroundColor = \"#496A9A\";\r			document.getElementById(\"ConsultarP0\").style.color = \"#FFFFFF\";\r\r	}\r\r	function fLimpiar()\r	{\r		recargaCombos();\r		focaliza(\"frmContenido.cbTipoCliente\", \"\");\r	}\r\rfunction duplicaFormulario()\r{\r		  		set(\"frmContenidoBusq.accion\", get(\"frmContenido.accion\") );\r		set(\"frmContenidoBusq.conectorAction\", get(\"frmContenido.conectorAction\") );\r		set(\"frmContenidoBusq.errCodigo\", get(\"frmContenido.errCodigo\") );\r		set(\"frmContenidoBusq.errDescripcion\", get(\"frmContenido.errDescripcion\") );\r		set(\"frmContenidoBusq.errSeverity\", get(\"frmContenido.errSeverity\") );\r		set(\"frmContenidoBusq.casoDeUso\", get(\"frmContenido.casoDeUso\") );\r		set(\"frmContenidoBusq.hidCriterioBusqueda1\", get(\"frmContenido.hidCriterioBusqueda1\") );\r		set(\"frmContenidoBusq.hidCriterioBusqueda2\", get(\"frmContenido.hidCriterioBusqueda2\") );\r		set(\"frmContenidoBusq.hidCriterioBusqueda2\", get(\"frmContenido.hidCriterioBusqueda2\") );\r		set(\"frmContenidoBusq.hidTipo\", get(\"frmContenido.hidTipo\") );\r		set(\"frmContenidoBusq.hidSubTipo\", get(\"frmContenido.hidSubTipo\") );\r		set(\"frmContenidoBusq.hidtextCodCliente\", get(\"frmContenido.hidtextCodCliente\") );\r		set(\"frmContenidoBusq.hidcbTipoDocId\", get(\"frmContenido.hidcbTipoDocId\") );\r		set(\"frmContenidoBusq.hidtextNDocId\", get(\"frmContenido.hidtextNDocId\") );\r		set(\"frmContenidoBusq.hidrbDocPrincipal\", get(\"frmContenido.hidrbDocPrincipal\") );\r		set(\"frmContenidoBusq.hidcbPersonaCliente\", get(\"frmContenido.hidcbPersonaCliente\") );\r		set(\"frmContenidoBusq.hidtextApellido1\", get(\"frmContenido.hidtextApellido1\") );\r		set(\"frmContenidoBusq.hidtextApellido2\", get(\"frmContenido.hidtextApellido2\") );\r		set(\"frmContenidoBusq.hidtextApellidoCasada\", get(\"frmContenido.hidtextApellidoCasada\") );\r		set(\"frmContenidoBusq.hidtextNombre1\", get(\"frmContenido.hidtextNombre1\") );\r		set(\"frmContenidoBusq.hidtextNombre2\", get(\"frmContenido.hidtextNombre2\") );\r		set(\"frmContenidoBusq.hidcbTratamiento\", get(\"frmContenido.hidcbTratamiento\") );\r		set(\"frmContenidoBusq.hidrbSexo\", get(\"frmContenido.hidrbSexo\") );\r		set(\"frmContenidoBusq.hidcbFormaPago\", get(\"frmContenido.hidcbFormaPago\") );\r		set(\"frmContenidoBusq.hidtextFechaNacimiento\", get(\"frmContenido.hidtextFechaNacimiento\") );\r		set(\"frmContenidoBusq.hidtextCodEmpleado\", get(\"frmContenido.hidtextCodEmpleado\") );\r		set(\"frmContenidoBusq.hidcbNacionalidad\", get(\"frmContenido.hidcbNacionalidad\") );\r		set(\"frmContenidoBusq.hidcbEstadoCivil\", get(\"frmContenido.hidcbEstadoCivil\") );\r		set(\"frmContenidoBusq.hidtextOcupacion\", get(\"frmContenido.hidtextOcupacion\") );\r		set(\"frmContenidoBusq.hidtextProfesion\", get(\"frmContenido.hidtextProfesion\") );\r		set(\"frmContenidoBusq.hidtextCentroTrabajo\", get(\"frmContenido.hidtextCentroTrabajo\") );\r		set(\"frmContenidoBusq.hidtextCargoDesempena\", get(\"frmContenido.hidtextCargoDesempena\") );\r		set(\"frmContenidoBusq.hidcbNivelEstudios\", get(\"frmContenido.hidcbNivelEstudios\") );\r		set(\"frmContenidoBusq.hidtextCentroEstudios\", get(\"frmContenido.hidtextCentroEstudios\") );\r		set(\"frmContenidoBusq.hidtextNHijos\", get(\"frmContenido.hidtextNHijos\") );\r		set(\"frmContenidoBusq.hidtextNPersonasDependientes\", get(\"frmContenido.hidtextNPersonasDependientes\") );\r		set(\"frmContenidoBusq.hidcbNivelSocioEconomico\", get(\"frmContenido.hidcbNivelSocioEconomico\") );\r		set(\"frmContenidoBusq.hidcbCicloVidaFamiliar\", get(\"frmContenido.hidcbCicloVidaFamiliar\") );\r		set(\"frmContenidoBusq.hidrbDeseaCorrespondencia\", get(\"frmContenido.hidrbDeseaCorrespondencia\") );\r		set(\"frmContenidoBusq.hidtextImporteIngresoFamiliar\", get(\"frmContenido.hidtextImporteIngresoFamiliar\") );\r		set(\"frmContenidoBusq.hidcbPaisVinculo\", get(\"frmContenido.hidcbPaisVinculo\") );\r		set(\"frmContenidoBusq.hidtextClienteVinculo\", get(\"frmContenido.hidtextClienteVinculo\") );\r		set(\"frmContenidoBusq.hidcbTipoVinculo\", get(\"frmContenido.hidcbTipoVinculo\") );\r		set(\"frmContenidoBusq.hidtextFechaD\", get(\"frmContenido.hidtextFechaD\") );\r		set(\"frmContenidoBusq.hidtextFechaH\", get(\"frmContenido.hidtextFechaH\") );\r		set(\"frmContenidoBusq.hidrbVinculoPrincipal\", get(\"frmContenido.hidrbVinculoPrincipal\") );\r		set(\"frmContenidoBusq.hidcb\", get(\"frmContenido.hidcb\") );\r		set(\"frmContenidoBusq.hidtextDescripcion\", get(\"frmContenido.hidtextDescripcion\") );\r		set(\"frmContenidoBusq.hidcbPaisContactado\", get(\"frmContenido.hidcbPaisContactado\") );\r		set(\"frmContenidoBusq.hidtextCodClienteContactado\", get(\"frmContenido.hidtextCodClienteContactado\") );\r		set(\"frmContenidoBusq.hidcbTipoClienteContactado\", get(\"frmContenido.hidcbTipoClienteContactado\") );\r		set(\"frmContenidoBusq.hidcbCodTipoContactado\", get(\"frmContenido.hidcbCodTipoContactado\") );\r		set(\"frmContenidoBusq.hidtextFechaContacto\", get(\"frmContenido.hidtextFechaContacto\") );\r		set(\"frmContenidoBusq.hidtextFecha1PedidoContacto\", get(\"frmContenido.hidtextFecha1PedidoContacto\") );\r		set(\"frmContenidoBusq.hidtextFechaSiguienteContacto\", get(\"frmContenido.hidtextFechaSiguienteContacto\") );\r		set(\"frmContenidoBusq.hidtxtFechaIngresoActual\", get(\"frmContenido.hidtxtFechaIngresoActual\") ); \r\r		set(\"frmContenidoBusq.hidcbTipoDireccion\", get(\"frmContenido.hidcbTipoDireccion\") ); \r		set(\"frmContenidoBusq.hidcbTipoVia\", get(\"frmContenido.hidcbTipoVia\") ); \r		set(\"frmContenidoBusq.hidtextNombreVia\", get(\"frmContenido.hidtextNombreVia\") ); \r		set(\"frmContenidoBusq.hidtextNPrincipal\", get(\"frmContenido.hidtextNPrincipal\") ); \r		set(\"frmContenidoBusq.hidtextCodPostal\", get(\"frmContenido.hidtextCodPostal\") ); \r		set(\"frmContenidoBusq.hidtextInterior\", get(\"frmContenido.hidtextInterior\") ); \r		set(\"frmContenidoBusq.hidtextManzana\", get(\"frmContenido.hidtextManzana\") ); \r		set(\"frmContenidoBusq.hidtextLote\", get(\"frmContenido.hidtextLote\") ); \r		set(\"frmContenidoBusq.hidtextKm\", get(\"frmContenido.hidtextKm\") ); \r		set(\"frmContenidoBusq.hidrbDireccionPrincipal\", get(\"frmContenido.hidrbDireccionPrincipal\") ); \r		set(\"frmContenidoBusq.hidtextObservaciones\", get(\"frmContenido.hidtextObservaciones\") ); \r		set(\"frmContenidoBusq.hidcbTipoComunicacion\", get(\"frmContenido.hidcbTipoComunicacion\") ); \r		set(\"frmContenidoBusq.hidcbDiaComunicacion\", get(\"frmContenido.hidcbDiaComunicacion\") ); \r		set(\"frmContenidoBusq.hidrbComunicacionPrincipal\", get(\"frmContenido.hidrbComunicacionPrincipal\") ); \r		set(\"frmContenidoBusq.hidtextHoraDesde\", get(\"frmContenido.hidtextHoraDesde\") ); \r		set(\"frmContenidoBusq.hidtextHoraHasta\", get(\"frmContenido.hidtextHoraHasta\") ); \r		set(\"frmContenidoBusq.hidcbIntervaloComunicacion\", get(\"frmContenido.hidcbIntervaloComunicacion\") ); \r		set(\"frmContenidoBusq.hidtextTextoComunicacion\", get(\"frmContenido.hidtextTextoComunicacion\") ); \r		set(\"frmContenidoBusq.hidcbMarca\", get(\"frmContenido.hidcbMarca\") ); \r		set(\"frmContenidoBusq.hidcbVia\", get(\"frmContenido.hidcbVia\") ); \r\r		set(\"frmContenidoBusq.hidcbTipoTarjeta\", get(\"frmContenido.hidcbTipoTarjeta\") ); \r		set(\"frmContenidoBusq.hidcbClasesTarjeta\", get(\"frmContenido.hidcbClasesTarjeta\") ); \r		set(\"frmContenidoBusq.hidcbEntidadBancaria\", get(\"frmContenido.hidcbEntidadBancaria\") ); \r		set(\"frmContenidoBusq.hidcbMarcaPestanya4\", get(\"frmContenido.hidcbMarcaPestanya4\") ); \r		set(\"frmContenidoBusq.hidcbCanal\", get(\"frmContenido.hidcbCanal\") ); \r		set(\"frmContenidoBusq.hidcbTipoClasificacion\", get(\"frmContenido.hidcbTipoClasificacion\") ); \r		set(\"frmContenidoBusq.hidcbTipoProblema\", get(\"frmContenido.hidcbTipoProblema\") ); \r		set(\"frmContenidoBusq.hidrbSolucion\", get(\"frmContenido.hidrbSolucion\") ); \r		set(\"frmContenidoBusq.hidcbTipoSolucion\", get(\"frmContenido.hidcbTipoSolucion\") ); \r		set(\"frmContenidoBusq.hidtextDescripcionProblema\", get(\"frmContenido.hidtextDescripcionProblema\") ); \r		set(\"frmContenidoBusq.hidtextDescripcionSolucion\", get(\"frmContenido.hidtextDescripcionSolucion\") ); \r		set(\"frmContenidoBusq.hidcbClasificacion\", get(\"frmContenido.hidcbClasificacion\") ); \r		set(\"frmContenidoBusq.hidtextNegocioProducto\", get(\"frmContenido.hidtextNegocioProducto\") ); \r		set(\"frmContenidoBusq.ListaComboClasificacion\", get(\"frmContenido.ListaComboClasificacion\") ); \r\r}\r\rfunction noHayRegistros()\r{\r	}\r\rfunction hayRegistros()\r{\r		seteaHiddens();\r\r		set(\"frmContenido.conectorAction\", \"LPBusquedaCliente\");\r		set(\"frmContenido.accion\", \"buscarPagina\");			\r\r		var tipo = get(\"frmContenido.cbTipoCliente\");\r		var subTipo = get(\"frmContenido.cbSubtipoCliente\");\r		var casoDeUso = get(\"frmContenido.casoDeUso\");\r\r		set(\"frmContenido.hidTipo\", tipo);\r		set(\"frmContenido.hidSubTipo\", subTipo);\r		set(\"frmContenido.casoDeUso\", casoDeUso);\r		\r		enviaSICC(\"frmContenido\");\r\r	\r}\r\r\r\r\r\r"));
      ((Element)v.get(2)).appendChild((Text)v.get(3));

      /* Termina nodo Texto:3   */
      /* Termina nodo:2   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(4)).setAttribute("nombre","frmContenido" );
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
      ((Element)v.get(7)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","oidSubTipo" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","padreSubTipo" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","descSubTipo" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","hidCriterioBusqueda1" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","hidCriterioBusqueda2" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hidTipo" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hidSubTipo" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hidtextCodCliente" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hidcbTipoDocId" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hidtextNDocId" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hidrbDocPrincipal" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hidcbPersonaCliente" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","hidtextApellido1" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","hidtextApellido2" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hidtextApellidoCasada" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hidtextNombre1" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hidtextNombre2" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hidcbTratamiento" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hidrbSexo" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hidcbFormaPago" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hidtextFechaNacimiento" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","hidtextCodEmpleado" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","hidcbNacionalidad" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","hidcbEstadoCivil" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","hidtextOcupacion" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","hidtextProfesion" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","hidtextCentroTrabajo" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","hidtextCargoDesempena" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","hidcbNivelEstudios" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","hidtextCentroEstudios" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","hidtextNHijos" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","hidtextNPersonasDependientes" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","hidcbNivelSocioEconomico" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","hidcbCicloVidaFamiliar" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","hidrbDeseaCorrespondencia" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 4   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","hidtextImporteIngresoFamiliar" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","hidcbPaisVinculo" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","hidtextClienteVinculo" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","hidcbTipoVinculo" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","hidtextFechaD" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","hidtextFechaH" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","hidrbVinculoPrincipal" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","hidcb" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","hidtextDescripcion" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(54)).setAttribute("nombre","hidcbPaisContactado" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(55)).setAttribute("nombre","hidtextCodClienteContactado" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(56)).setAttribute("nombre","hidcbTipoClienteContactado" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(57)).setAttribute("nombre","hidcbCodTipoContactado" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(58)).setAttribute("nombre","hidtextFechaContacto" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(59)).setAttribute("nombre","hidtextFecha1PedidoContacto" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(60)).setAttribute("nombre","hidtextFechaSiguienteContacto" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(61)).setAttribute("nombre","hidtxtFechaIngresoActual" );
      ((Element)v.get(61)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(62)).setAttribute("nombre","hidcbTipoDireccion" );
      ((Element)v.get(62)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(63)).setAttribute("nombre","hidcbTipoVia" );
      ((Element)v.get(63)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(64)).setAttribute("nombre","hidtextNombreVia" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */

      /* Empieza nodo:65 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(65)).setAttribute("nombre","hidtextNPrincipal" );
      ((Element)v.get(65)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */

      /* Empieza nodo:66 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(66)).setAttribute("nombre","hidtextCodPostal" );
      ((Element)v.get(66)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(67)).setAttribute("nombre","hidtextInterior" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(67)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */

      /* Empieza nodo:68 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(68)).setAttribute("nombre","hidtextManzana" );
      ((Element)v.get(68)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */

      /* Empieza nodo:69 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(69)).setAttribute("nombre","hidtextLote" );
      ((Element)v.get(69)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */

      /* Empieza nodo:70 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(70)).setAttribute("nombre","hidtextKm" );
      ((Element)v.get(70)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(71)).setAttribute("nombre","hidrbDireccionPrincipal" );
      ((Element)v.get(71)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */

      /* Empieza nodo:72 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(72)).setAttribute("nombre","hidtextObservaciones" );
      ((Element)v.get(72)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */

      /* Empieza nodo:73 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(73)).setAttribute("nombre","hidcbTipoComunicacion" );
      ((Element)v.get(73)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */

      /* Empieza nodo:74 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(74)).setAttribute("nombre","hidcbDiaComunicacion" );
      ((Element)v.get(74)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */

      /* Empieza nodo:75 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(75)).setAttribute("nombre","hidrbComunicacionPrincipal" );
      ((Element)v.get(75)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */

      /* Empieza nodo:76 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(76)).setAttribute("nombre","hidtextHoraDesde" );
      ((Element)v.get(76)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */

      /* Empieza nodo:77 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(77)).setAttribute("nombre","hidtextHoraHasta" );
      ((Element)v.get(77)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */

      /* Empieza nodo:78 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(78)).setAttribute("nombre","hidcbIntervaloComunicacion" );
      ((Element)v.get(78)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */

      /* Empieza nodo:79 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(79)).setAttribute("nombre","hidtextTextoComunicacion" );
      ((Element)v.get(79)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */

      /* Empieza nodo:80 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(80)).setAttribute("nombre","hidcbMarca" );
      ((Element)v.get(80)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */

      /* Empieza nodo:81 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(81)).setAttribute("nombre","hidcbVia" );
      ((Element)v.get(81)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */

      /* Empieza nodo:82 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(82)).setAttribute("nombre","hidcbTipoTarjeta" );
      ((Element)v.get(82)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(83)).setAttribute("nombre","hidcbClasesTarjeta" );
      ((Element)v.get(83)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */

      /* Empieza nodo:84 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(84)).setAttribute("nombre","hidcbEntidadBancaria" );
      ((Element)v.get(84)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */

      /* Empieza nodo:85 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(85)).setAttribute("nombre","hidcbMarcaPestanya4" );
      ((Element)v.get(85)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(86)).setAttribute("nombre","hidcbCanal" );
      ((Element)v.get(86)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(87)).setAttribute("nombre","hidcbTipoClasificacion" );
      ((Element)v.get(87)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */

      /* Empieza nodo:88 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(88)).setAttribute("nombre","hidcbTipoProblema" );
      ((Element)v.get(88)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */

      /* Empieza nodo:89 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(89)).setAttribute("nombre","hidrbSolucion" );
      ((Element)v.get(89)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */

      /* Empieza nodo:90 / Elemento padre: 4   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(90)).setAttribute("nombre","hidcbTipoSolucion" );
      ((Element)v.get(90)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */

      /* Empieza nodo:91 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(91)).setAttribute("nombre","hidtextDescripcionProblema" );
      ((Element)v.get(91)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(92)).setAttribute("nombre","hidtextDescripcionSolucion" );
      ((Element)v.get(92)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */

      /* Empieza nodo:93 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(93)).setAttribute("nombre","hidcbClasificacion" );
      ((Element)v.get(93)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */

      /* Empieza nodo:94 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(94)).setAttribute("nombre","hidtextNegocioProducto" );
      ((Element)v.get(94)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */

      /* Empieza nodo:95 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(95)).setAttribute("nombre","ListaComboClasificacion" );
      ((Element)v.get(95)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */

      /* Empieza nodo:96 / Elemento padre: 4   */
      v.add(doc.createElement("table"));
      ((Element)v.get(96)).setAttribute("width","100%" );
      ((Element)v.get(96)).setAttribute("height","100%" );
      ((Element)v.get(96)).setAttribute("border","0" );
      ((Element)v.get(96)).setAttribute("align","center" );
      ((Element)v.get(96)).setAttribute("cellpadding","0" );
      ((Element)v.get(96)).setAttribute("cellspacing","0" );
      ((Element)v.get(96)).setAttribute("class","menu4" );
      ((Element)v.get(4)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).setAttribute("width","12" );
      ((Element)v.get(98)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(98)).setAttribute("class","menu5texto" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(99)).setAttribute("src","b.gif" );
      ((Element)v.get(99)).setAttribute("width","12" );
      ((Element)v.get(99)).setAttribute("height","30" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:100 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(100)).setAttribute("class","menu5texto" );
      ((Element)v.get(97)).appendChild((Element)v.get(100));

      /* Elemento padre:100 / Elemento actual: 101   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(100)).appendChild((Text)v.get(101));

      /* Termina nodo Texto:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:102 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).setAttribute("width","10" );
      ((Element)v.get(102)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(102)).setAttribute("class","menu5texto" );
      ((Element)v.get(97)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).setAttribute("width","10" );
      ((Element)v.get(103)).setAttribute("height","8" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).setAttribute("width","92" );
      ((Element)v.get(104)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(104)).setAttribute("class","menu5texto" );
      ((Element)v.get(97)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("table"));
      ((Element)v.get(105)).setAttribute("width","90" );
      ((Element)v.get(105)).setAttribute("border","0" );
      ((Element)v.get(105)).setAttribute("align","center" );
      ((Element)v.get(105)).setAttribute("cellpadding","1" );
      ((Element)v.get(105)).setAttribute("cellspacing","0" );
      ((Element)v.get(105)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(106)).setAttribute("align","center" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(107)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("a"));
      ((Element)v.get(108)).setAttribute("href","Javascript:siguientePestanya(-1);" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(109)).setAttribute("ID","ConsultarPSub1" );
      ((Element)v.get(109)).setAttribute("onclick","" );
      ((Element)v.get(109)).setAttribute("style","width:90px;border-style:solid; border-color:#496A9A;   border-width:2px;position:relative;top:3px;text-align:center;color:#496A9A;   font-family: Arial, Helvetica, sans-serif;font-size: 11px;font-weight: bold; visibility:visible" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Elemento padre:109 / Elemento actual: 110   */
      v.add(doc.createTextNode("Tipo / subtipo"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(109)).appendChild((Text)v.get(110));

      /* Termina nodo Texto:110   */
      /* Termina nodo:109   */
      /* Termina nodo:108   */
      /* Termina nodo:107   */
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:111 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).setAttribute("width","10" );
      ((Element)v.get(111)).setAttribute("class","menu5texto" );
      ((Element)v.get(97)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(112)).setAttribute("src","b.gif" );
      ((Element)v.get(112)).setAttribute("width","10" );
      ((Element)v.get(112)).setAttribute("height","8" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:113 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).setAttribute("width","20" );
      ((Element)v.get(113)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(113)).setAttribute("class","menu5texto" );
      ((Element)v.get(97)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("table"));
      ((Element)v.get(114)).setAttribute("width","75" );
      ((Element)v.get(114)).setAttribute("border","0" );
      ((Element)v.get(114)).setAttribute("align","center" );
      ((Element)v.get(114)).setAttribute("cellpadding","1" );
      ((Element)v.get(114)).setAttribute("cellspacing","0" );
      ((Element)v.get(114)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(115)).setAttribute("align","center" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(116)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("a"));
      ((Element)v.get(117)).setAttribute("href","#" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(118)).setAttribute("ID","ConsultarP0" );
      ((Element)v.get(118)).setAttribute("onclick","" );
      ((Element)v.get(118)).setAttribute("style","width:80px;border-style:solid; border-color:#496A9A;   border-width:2px;position:relative;top:3px;text-align:center;color:#496A9A;   font-family: Arial, Helvetica, sans-serif;font-size: 11px;font-weight: bold; visibility:visible" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Elemento padre:118 / Elemento actual: 119   */
      v.add(doc.createTextNode("Tipo / subtipo"));
      ((Element)v.get(118)).appendChild((Text)v.get(119));

      /* Termina nodo Texto:119   */
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:116   */
      /* Termina nodo:115   */
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:120 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).setAttribute("width","10" );
      ((Element)v.get(120)).setAttribute("class","menu5texto" );
      ((Element)v.get(97)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(121)).setAttribute("width","10" );
      ((Element)v.get(121)).setAttribute("height","8" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:122 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).setAttribute("width","20" );
      ((Element)v.get(122)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(122)).setAttribute("class","menu5texto" );
      ((Element)v.get(97)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("table"));
      ((Element)v.get(123)).setAttribute("width","75" );
      ((Element)v.get(123)).setAttribute("border","0" );
      ((Element)v.get(123)).setAttribute("align","center" );
      ((Element)v.get(123)).setAttribute("cellpadding","1" );
      ((Element)v.get(123)).setAttribute("cellspacing","0" );
      ((Element)v.get(123)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(124)).setAttribute("align","center" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(125)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("a"));
      ((Element)v.get(126)).setAttribute("href","Javascript:siguientePestanya(1);" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(127)).setAttribute("ID","ConsultarP1" );
      ((Element)v.get(127)).setAttribute("onclick","" );
      ((Element)v.get(127)).setAttribute("style","width:80px;border-style:solid; border-color:#496A9A;   border-width:2px;position:relative;top:3px;text-align:center;color:#496A9A;   font-family: Arial, Helvetica, sans-serif;font-size: 11px;font-weight: bold; visibility:visible" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Elemento padre:127 / Elemento actual: 128   */
      v.add(doc.createTextNode("Pestanya 1"));
      ((Element)v.get(127)).appendChild((Text)v.get(128));

      /* Termina nodo Texto:128   */
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:129 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).setAttribute("width","10" );
      ((Element)v.get(129)).setAttribute("class","menu5texto" );
      ((Element)v.get(97)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(130)).setAttribute("src","b.gif" );
      ((Element)v.get(130)).setAttribute("width","10" );
      ((Element)v.get(130)).setAttribute("height","8" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:131 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).setAttribute("width","20" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(131)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(131)).setAttribute("class","menu5texto" );
      ((Element)v.get(97)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("table"));
      ((Element)v.get(132)).setAttribute("width","75" );
      ((Element)v.get(132)).setAttribute("border","0" );
      ((Element)v.get(132)).setAttribute("align","center" );
      ((Element)v.get(132)).setAttribute("cellpadding","1" );
      ((Element)v.get(132)).setAttribute("cellspacing","0" );
      ((Element)v.get(132)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(133)).setAttribute("align","center" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(134)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("a"));
      ((Element)v.get(135)).setAttribute("href","Javascript:siguientePestanya(2);" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(136)).setAttribute("ID","ConsultarP2" );
      ((Element)v.get(136)).setAttribute("onclick","" );
      ((Element)v.get(136)).setAttribute("style","width:80px;border-style:solid; border-color:#496A9A;   border-width:2px;position:relative;top:3px;text-align:center;color:#496A9A;   font-family: Arial, Helvetica, sans-serif;font-size: 11px;font-weight: bold; visibility:visible" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));

      /* Elemento padre:136 / Elemento actual: 137   */
      v.add(doc.createTextNode("Pestanya 2"));
      ((Element)v.get(136)).appendChild((Text)v.get(137));

      /* Termina nodo Texto:137   */
      /* Termina nodo:136   */
      /* Termina nodo:135   */
      /* Termina nodo:134   */
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:138 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).setAttribute("width","10" );
      ((Element)v.get(138)).setAttribute("class","menu5texto" );
      ((Element)v.get(97)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(139)).setAttribute("src","b.gif" );
      ((Element)v.get(139)).setAttribute("width","10" );
      ((Element)v.get(139)).setAttribute("height","8" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */

      /* Empieza nodo:140 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).setAttribute("width","20" );
      ((Element)v.get(140)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(140)).setAttribute("class","menu5texto" );
      ((Element)v.get(97)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("table"));
      ((Element)v.get(141)).setAttribute("width","75" );
      ((Element)v.get(141)).setAttribute("border","0" );
      ((Element)v.get(141)).setAttribute("align","center" );
      ((Element)v.get(141)).setAttribute("cellpadding","1" );
      ((Element)v.get(141)).setAttribute("cellspacing","0" );
      ((Element)v.get(141)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(142)).setAttribute("align","center" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(143)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("a"));
      ((Element)v.get(144)).setAttribute("href","Javascript:siguientePestanya(3);" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(145)).setAttribute("ID","ConsultarP3" );
      ((Element)v.get(145)).setAttribute("onclick","" );
      ((Element)v.get(145)).setAttribute("style","width:80px;border-style:solid; border-color:#496A9A;   border-width:2px;position:relative;top:3px;text-align:center;color:#496A9A;   font-family: Arial, Helvetica, sans-serif;font-size: 11px;font-weight: bold; visibility:visible" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));

      /* Elemento padre:145 / Elemento actual: 146   */
      v.add(doc.createTextNode("Pestanya 3"));
      ((Element)v.get(145)).appendChild((Text)v.get(146));

      /* Termina nodo Texto:146   */
      /* Termina nodo:145   */
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:147 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).setAttribute("width","10" );
      ((Element)v.get(147)).setAttribute("class","menu5texto" );
      ((Element)v.get(97)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(148)).setAttribute("src","b.gif" );
      ((Element)v.get(148)).setAttribute("width","10" );
      ((Element)v.get(148)).setAttribute("height","8" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */

      /* Empieza nodo:149 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).setAttribute("width","20" );
      ((Element)v.get(149)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(149)).setAttribute("class","menu5texto" );
      ((Element)v.get(97)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("table"));
      ((Element)v.get(150)).setAttribute("width","75" );
      ((Element)v.get(150)).setAttribute("border","0" );
      ((Element)v.get(150)).setAttribute("align","center" );
      ((Element)v.get(150)).setAttribute("cellpadding","1" );
      ((Element)v.get(150)).setAttribute("cellspacing","0" );
      ((Element)v.get(150)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("tr"));
   }

   private void getXML630(Document doc) {
      ((Element)v.get(151)).setAttribute("align","center" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("td"));
      ((Element)v.get(152)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(152)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("a"));
      ((Element)v.get(153)).setAttribute("href","Javascript:siguientePestanya(4);" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(154)).setAttribute("ID","ConsultarP4" );
      ((Element)v.get(154)).setAttribute("onclick","" );
      ((Element)v.get(154)).setAttribute("style","width:80px;border-style:solid; border-color:#496A9A;   border-width:2px;position:relative;top:3px;text-align:center;color:#496A9A;   font-family: Arial, Helvetica, sans-serif;font-size: 11px;font-weight: bold; visibility:visible" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Elemento padre:154 / Elemento actual: 155   */
      v.add(doc.createTextNode("Pestanya 4"));
      ((Element)v.get(154)).appendChild((Text)v.get(155));

      /* Termina nodo Texto:155   */
      /* Termina nodo:154   */
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:151   */
      /* Termina nodo:150   */
      /* Termina nodo:149   */

      /* Empieza nodo:156 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(156)).setAttribute("width","16" );
      ((Element)v.get(156)).setAttribute("class","menu5texto" );
      ((Element)v.get(97)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(157)).setAttribute("src","b.gif" );
      ((Element)v.get(157)).setAttribute("width","12" );
      ((Element)v.get(157)).setAttribute("height","8" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:156   */
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:158 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(158)).setAttribute("nombre","capaContenido" );
      ((Element)v.get(4)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("table"));
      ((Element)v.get(159)).setAttribute("width","100%" );
      ((Element)v.get(159)).setAttribute("border","0" );
      ((Element)v.get(159)).setAttribute("cellspacing","0" );
      ((Element)v.get(159)).setAttribute("cellpadding","0" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(159)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(161)).setAttribute("width","12" );
      ((Element)v.get(161)).setAttribute("align","center" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(162)).setAttribute("src","b.gif" );
      ((Element)v.get(162)).setAttribute("width","12" );
      ((Element)v.get(162)).setAttribute("height","12" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:163 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).setAttribute("width","750" );
      ((Element)v.get(160)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(164)).setAttribute("src","b.gif" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:165 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(165)).setAttribute("width","12" );
      ((Element)v.get(160)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(166)).setAttribute("src","b.gif" );
      ((Element)v.get(166)).setAttribute("width","12" );
      ((Element)v.get(166)).setAttribute("height","1" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */
      /* Termina nodo:160   */

      /* Empieza nodo:167 / Elemento padre: 159   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(159)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(169)).setAttribute("src","b.gif" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:168   */

      /* Empieza nodo:170 / Elemento padre: 167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(170)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(172)).setAttribute("class","legend" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(173)).setAttribute("nombre","lblCriterios" );
      ((Element)v.get(173)).setAttribute("alto","13" );
      ((Element)v.get(173)).setAttribute("filas","1" );
      ((Element)v.get(173)).setAttribute("valor","Datos Búsqueda" );
      ((Element)v.get(173)).setAttribute("id","legend" );
      ((Element)v.get(173)).setAttribute("cod","0075" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:172   */

      /* Empieza nodo:174 / Elemento padre: 171   */
      v.add(doc.createElement("table"));
      ((Element)v.get(174)).setAttribute("width","100%" );
      ((Element)v.get(174)).setAttribute("border","0" );
      ((Element)v.get(174)).setAttribute("align","center" );
      ((Element)v.get(174)).setAttribute("cellspacing","0" );
      ((Element)v.get(174)).setAttribute("cellpadding","0" );
      ((Element)v.get(171)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(174)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
   }

   private void getXML720(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).setAttribute("colspan","4" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(177)).setAttribute("src","b.gif" );
      ((Element)v.get(177)).setAttribute("width","8" );
      ((Element)v.get(177)).setAttribute("height","8" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:178 / Elemento padre: 174   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(174)).appendChild((Element)v.get(178));

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
      ((Element)v.get(182)).setAttribute("nombre","lblTipoCliente" );
      ((Element)v.get(182)).setAttribute("alto","13" );
      ((Element)v.get(182)).setAttribute("filas","1" );
      ((Element)v.get(182)).setAttribute("valor","" );
      ((Element)v.get(182)).setAttribute("id","datosTitle" );
      ((Element)v.get(182)).setAttribute("cod","393" );
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
      ((Element)v.get(186)).setAttribute("nombre","lblSubtipoCliente" );
      ((Element)v.get(186)).setAttribute("alto","13" );
      ((Element)v.get(186)).setAttribute("filas","1" );
      ((Element)v.get(186)).setAttribute("valor","" );
      ((Element)v.get(186)).setAttribute("id","datosTitle" );
      ((Element)v.get(186)).setAttribute("cod","595" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:187 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(187)).setAttribute("width","100%" );
      ((Element)v.get(178)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(188)).setAttribute("src","b.gif" );
      ((Element)v.get(188)).setAttribute("width","8" );
      ((Element)v.get(188)).setAttribute("height","8" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */
      /* Termina nodo:178   */

      /* Empieza nodo:189 / Elemento padre: 174   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(174)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("td"));
      ((Element)v.get(189)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(191)).setAttribute("src","b.gif" );
      ((Element)v.get(191)).setAttribute("width","8" );
      ((Element)v.get(191)).setAttribute("height","8" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */

      /* Empieza nodo:192 / Elemento padre: 189   */
      v.add(doc.createElement("td"));
      ((Element)v.get(192)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(189)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(193)).setAttribute("nombre","cbTipoCliente" );
      ((Element)v.get(193)).setAttribute("id","datosCampos" );
      ((Element)v.get(193)).setAttribute("size","1" );
      ((Element)v.get(193)).setAttribute("multiple","N" );
      ((Element)v.get(193)).setAttribute("onshtab","siguientePestanya(-1);" );
      ((Element)v.get(193)).setAttribute("onchange","refreshSubTipo();" );
      ((Element)v.get(193)).setAttribute("req","N" );
      ((Element)v.get(193)).setAttribute("valorinicial","" );
      ((Element)v.get(193)).setAttribute("textoinicial","" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */
      /* Termina nodo:192   */

      /* Empieza nodo:195 / Elemento padre: 189   */
      v.add(doc.createElement("td"));
      ((Element)v.get(189)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(196)).setAttribute("src","b.gif" );
      ((Element)v.get(196)).setAttribute("width","25" );
      ((Element)v.get(196)).setAttribute("height","8" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */

      /* Empieza nodo:197 / Elemento padre: 189   */
      v.add(doc.createElement("td"));
      ((Element)v.get(197)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(189)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(198)).setAttribute("nombre","cbSubtipoCliente" );
      ((Element)v.get(198)).setAttribute("id","datosCampos" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(198)).setAttribute("size","1" );
      ((Element)v.get(198)).setAttribute("multiple","N" );
      ((Element)v.get(198)).setAttribute("req","N" );
      ((Element)v.get(198)).setAttribute("valorinicial","" );
      ((Element)v.get(198)).setAttribute("textoinicial","" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(198)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:198   */
      /* Termina nodo:197   */

      /* Empieza nodo:200 / Elemento padre: 189   */
      v.add(doc.createElement("td"));
      ((Element)v.get(200)).setAttribute("width","100%" );
      ((Element)v.get(189)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(201)).setAttribute("src","b.gif" );
      ((Element)v.get(201)).setAttribute("width","8" );
      ((Element)v.get(201)).setAttribute("height","8" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */
      /* Termina nodo:189   */

      /* Empieza nodo:202 / Elemento padre: 174   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(174)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).setAttribute("colspan","4" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(204)).setAttribute("src","b.gif" );
      ((Element)v.get(204)).setAttribute("width","8" );
      ((Element)v.get(204)).setAttribute("height","8" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */
      /* Termina nodo:202   */
      /* Termina nodo:174   */
      /* Termina nodo:171   */
      /* Termina nodo:170   */

      /* Empieza nodo:205 / Elemento padre: 167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(206)).setAttribute("src","b.gif" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */
      /* Termina nodo:167   */

      /* Empieza nodo:207 / Elemento padre: 159   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(159)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("td"));
      ((Element)v.get(207)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(209)).setAttribute("src","b.gif" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:210 / Elemento padre: 207   */
      v.add(doc.createElement("td"));
      ((Element)v.get(207)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(210)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("table"));
      ((Element)v.get(212)).setAttribute("width","100%" );
      ((Element)v.get(212)).setAttribute("border","0" );
      ((Element)v.get(212)).setAttribute("align","center" );
      ((Element)v.get(212)).setAttribute("cellspacing","0" );
      ((Element)v.get(212)).setAttribute("cellpadding","0" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(212)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("td"));
      ((Element)v.get(214)).setAttribute("class","botonera" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(215)).setAttribute("nombre","btnSiguiente" );
      ((Element)v.get(215)).setAttribute("ID","botonContenido" );
      ((Element)v.get(215)).setAttribute("tipo","html" );
      ((Element)v.get(215)).setAttribute("accion","siguientePestanya(1);" );
      ((Element)v.get(215)).setAttribute("estado","false" );
      ((Element)v.get(215)).setAttribute("cod","446" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */

      /* Empieza nodo:216 / Elemento padre: 214   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(216)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(216)).setAttribute("ID","botonContenido" );
      ((Element)v.get(216)).setAttribute("tipo","html" );
      ((Element)v.get(216)).setAttribute("accion","buscar();" );
      ((Element)v.get(216)).setAttribute("ontab","siguientePestanya(1);" );
      ((Element)v.get(216)).setAttribute("estado","false" );
      ((Element)v.get(216)).setAttribute("cod","1" );
      ((Element)v.get(214)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */
      /* Termina nodo:214   */
      /* Termina nodo:213   */
      /* Termina nodo:212   */
      /* Termina nodo:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:217 / Elemento padre: 207   */
      v.add(doc.createElement("td"));
      ((Element)v.get(207)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(218)).setAttribute("src","b.gif" );
      ((Element)v.get(218)).setAttribute("width","8" );
      ((Element)v.get(218)).setAttribute("height","12" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */
      /* Termina nodo:217   */
      /* Termina nodo:207   */

      /* Empieza nodo:219 / Elemento padre: 159   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(159)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("td"));
      ((Element)v.get(220)).setAttribute("width","12" );
      ((Element)v.get(220)).setAttribute("align","center" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(221)).setAttribute("src","b.gif" );
      ((Element)v.get(221)).setAttribute("width","12" );
      ((Element)v.get(221)).setAttribute("height","12" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:220   */

      /* Empieza nodo:222 / Elemento padre: 219   */
      v.add(doc.createElement("td"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(222)).setAttribute("width","750" );
      ((Element)v.get(219)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(223)).setAttribute("src","b.gif" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:222   */

      /* Empieza nodo:224 / Elemento padre: 219   */
      v.add(doc.createElement("td"));
      ((Element)v.get(224)).setAttribute("width","12" );
      ((Element)v.get(219)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(225)).setAttribute("src","b.gif" );
      ((Element)v.get(225)).setAttribute("width","12" );
      ((Element)v.get(225)).setAttribute("height","1" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */
      /* Termina nodo:219   */
      /* Termina nodo:159   */
      /* Termina nodo:158   */
      /* Termina nodo:4   */

      /* Empieza nodo:226 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(226)).setAttribute("nombre","frmContenidoBusq" );
      ((Element)v.get(226)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(227)).setAttribute("nombre","accion" );
      ((Element)v.get(227)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */

      /* Empieza nodo:228 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(228)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(228)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */

      /* Empieza nodo:229 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(229)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(229)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */

      /* Empieza nodo:230 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(230)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(230)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */

      /* Empieza nodo:231 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(231)).setAttribute("nombre","oidSubTipo" );
      ((Element)v.get(231)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */

      /* Empieza nodo:232 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(232)).setAttribute("nombre","padreSubTipo" );
      ((Element)v.get(232)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */

      /* Empieza nodo:233 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(233)).setAttribute("nombre","descSubTipo" );
      ((Element)v.get(233)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */

      /* Empieza nodo:234 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(234)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(234)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */

      /* Empieza nodo:235 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(235)).setAttribute("nombre","hidCriterioBusqueda1" );
      ((Element)v.get(235)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */

      /* Empieza nodo:236 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(236)).setAttribute("nombre","hidCriterioBusqueda2" );
      ((Element)v.get(236)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */

      /* Empieza nodo:237 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(237)).setAttribute("nombre","hidTipo" );
      ((Element)v.get(237)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */

      /* Empieza nodo:238 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(238)).setAttribute("nombre","hidSubTipo" );
      ((Element)v.get(238)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */

      /* Empieza nodo:239 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(239)).setAttribute("nombre","hidtextCodCliente" );
      ((Element)v.get(239)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */

      /* Empieza nodo:240 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(240)).setAttribute("nombre","hidcbTipoDocId" );
      ((Element)v.get(240)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */

      /* Empieza nodo:241 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(241)).setAttribute("nombre","hidtextNDocId" );
      ((Element)v.get(241)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */

      /* Empieza nodo:242 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(242)).setAttribute("nombre","hidrbDocPrincipal" );
      ((Element)v.get(242)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */

      /* Empieza nodo:243 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(243)).setAttribute("nombre","hidcbPersonaCliente" );
      ((Element)v.get(243)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */

      /* Empieza nodo:244 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(244)).setAttribute("nombre","hidtextApellido1" );
      ((Element)v.get(244)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */

      /* Empieza nodo:245 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML990(Document doc) {
      ((Element)v.get(245)).setAttribute("nombre","hidtextApellido2" );
      ((Element)v.get(245)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */

      /* Empieza nodo:246 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(246)).setAttribute("nombre","hidtextApellidoCasada" );
      ((Element)v.get(246)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */

      /* Empieza nodo:247 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(247)).setAttribute("nombre","hidtextNombre1" );
      ((Element)v.get(247)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */

      /* Empieza nodo:248 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(248)).setAttribute("nombre","hidtextNombre2" );
      ((Element)v.get(248)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */

      /* Empieza nodo:249 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(249)).setAttribute("nombre","hidcbTratamiento" );
      ((Element)v.get(249)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */

      /* Empieza nodo:250 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(250)).setAttribute("nombre","hidrbSexo" );
      ((Element)v.get(250)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */

      /* Empieza nodo:251 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(251)).setAttribute("nombre","hidcbFormaPago" );
      ((Element)v.get(251)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */

      /* Empieza nodo:252 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(252)).setAttribute("nombre","hidtextFechaNacimiento" );
      ((Element)v.get(252)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */

      /* Empieza nodo:253 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(253)).setAttribute("nombre","hidtextCodEmpleado" );
      ((Element)v.get(253)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */

      /* Empieza nodo:254 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(254)).setAttribute("nombre","hidcbNacionalidad" );
      ((Element)v.get(254)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */

      /* Empieza nodo:255 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(255)).setAttribute("nombre","hidcbEstadoCivil" );
      ((Element)v.get(255)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */

      /* Empieza nodo:256 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(256)).setAttribute("nombre","hidtextOcupacion" );
      ((Element)v.get(256)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */

      /* Empieza nodo:257 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(257)).setAttribute("nombre","hidtextProfesion" );
      ((Element)v.get(257)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */

      /* Empieza nodo:258 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(258)).setAttribute("nombre","hidtextCentroTrabajo" );
      ((Element)v.get(258)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */

      /* Empieza nodo:259 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(259)).setAttribute("nombre","hidtextCargoDesempena" );
      ((Element)v.get(259)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */

      /* Empieza nodo:260 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(260)).setAttribute("nombre","hidcbNivelEstudios" );
      ((Element)v.get(260)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */

      /* Empieza nodo:261 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(261)).setAttribute("nombre","hidtextCentroEstudios" );
      ((Element)v.get(261)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */

      /* Empieza nodo:262 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(262)).setAttribute("nombre","hidtextNHijos" );
      ((Element)v.get(262)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */

      /* Empieza nodo:263 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(263)).setAttribute("nombre","hidtextNPersonasDependientes" );
      ((Element)v.get(263)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */

      /* Empieza nodo:264 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(264)).setAttribute("nombre","hidcbNivelSocioEconomico" );
      ((Element)v.get(264)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */

      /* Empieza nodo:265 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(265)).setAttribute("nombre","hidcbCicloVidaFamiliar" );
      ((Element)v.get(265)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */

      /* Empieza nodo:266 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(266)).setAttribute("nombre","hidrbDeseaCorrespondencia" );
      ((Element)v.get(266)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */

      /* Empieza nodo:267 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(267)).setAttribute("nombre","hidtextImporteIngresoFamiliar" );
      ((Element)v.get(267)).setAttribute("valor","" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(226)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */

      /* Empieza nodo:268 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(268)).setAttribute("nombre","hidcbPaisVinculo" );
      ((Element)v.get(268)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */

      /* Empieza nodo:269 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(269)).setAttribute("nombre","hidtextClienteVinculo" );
      ((Element)v.get(269)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */

      /* Empieza nodo:270 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(270)).setAttribute("nombre","hidcbTipoVinculo" );
      ((Element)v.get(270)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */

      /* Empieza nodo:271 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(271)).setAttribute("nombre","hidtextFechaD" );
      ((Element)v.get(271)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */

      /* Empieza nodo:272 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(272)).setAttribute("nombre","hidtextFechaH" );
      ((Element)v.get(272)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */

      /* Empieza nodo:273 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(273)).setAttribute("nombre","hidrbVinculoPrincipal" );
      ((Element)v.get(273)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */

      /* Empieza nodo:274 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(274)).setAttribute("nombre","hidcb" );
      ((Element)v.get(274)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */

      /* Empieza nodo:275 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(275)).setAttribute("nombre","hidtextDescripcion" );
      ((Element)v.get(275)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */

      /* Empieza nodo:276 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(276)).setAttribute("nombre","hidcbPaisContactado" );
      ((Element)v.get(276)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */

      /* Empieza nodo:277 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(277)).setAttribute("nombre","hidtextCodClienteContactado" );
      ((Element)v.get(277)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */

      /* Empieza nodo:278 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(278)).setAttribute("nombre","hidcbTipoClienteContactado" );
      ((Element)v.get(278)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */

      /* Empieza nodo:279 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(279)).setAttribute("nombre","hidcbCodTipoContactado" );
      ((Element)v.get(279)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */

      /* Empieza nodo:280 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(280)).setAttribute("nombre","hidtextFechaContacto" );
      ((Element)v.get(280)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */

      /* Empieza nodo:281 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(281)).setAttribute("nombre","hidtextFecha1PedidoContacto" );
      ((Element)v.get(281)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */

      /* Empieza nodo:282 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(282)).setAttribute("nombre","hidtextFechaSiguienteContacto" );
      ((Element)v.get(282)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */

      /* Empieza nodo:283 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(283)).setAttribute("nombre","hidtxtFechaIngresoActual" );
      ((Element)v.get(283)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */

      /* Empieza nodo:284 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(284)).setAttribute("nombre","hidcbTipoDireccion" );
      ((Element)v.get(284)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */

      /* Empieza nodo:285 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(285)).setAttribute("nombre","hidcbTipoVia" );
      ((Element)v.get(285)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */

      /* Empieza nodo:286 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(286)).setAttribute("nombre","hidtextNombreVia" );
      ((Element)v.get(286)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */

      /* Empieza nodo:287 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(287)).setAttribute("nombre","hidtextNPrincipal" );
      ((Element)v.get(287)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */

      /* Empieza nodo:288 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(288)).setAttribute("nombre","hidtextCodPostal" );
      ((Element)v.get(288)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */

      /* Empieza nodo:289 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(289)).setAttribute("nombre","hidtextInterior" );
      ((Element)v.get(289)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */

      /* Empieza nodo:290 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(290)).setAttribute("nombre","hidtextManzana" );
      ((Element)v.get(290)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */

      /* Empieza nodo:291 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(291)).setAttribute("nombre","hidtextLote" );
      ((Element)v.get(291)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */

      /* Empieza nodo:292 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(292)).setAttribute("nombre","hidtextKm" );
      ((Element)v.get(292)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */

      /* Empieza nodo:293 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(293)).setAttribute("nombre","hidrbDireccionPrincipal" );
      ((Element)v.get(293)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */

      /* Empieza nodo:294 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(294)).setAttribute("nombre","hidtextObservaciones" );
      ((Element)v.get(294)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */

      /* Empieza nodo:295 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(295)).setAttribute("nombre","hidcbTipoComunicacion" );
      ((Element)v.get(295)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */

      /* Empieza nodo:296 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(296)).setAttribute("nombre","hidcbDiaComunicacion" );
      ((Element)v.get(296)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */

      /* Empieza nodo:297 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(297)).setAttribute("nombre","hidrbComunicacionPrincipal" );
      ((Element)v.get(297)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */

      /* Empieza nodo:298 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(298)).setAttribute("nombre","hidtextHoraDesde" );
      ((Element)v.get(298)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */

      /* Empieza nodo:299 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(299)).setAttribute("nombre","hidtextHoraHasta" );
      ((Element)v.get(299)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */

      /* Empieza nodo:300 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(300)).setAttribute("nombre","hidcbIntervaloComunicacion" );
      ((Element)v.get(300)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */

      /* Empieza nodo:301 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(301)).setAttribute("nombre","hidtextTextoComunicacion" );
      ((Element)v.get(301)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */

      /* Empieza nodo:302 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(302)).setAttribute("nombre","hidcbMarca" );
      ((Element)v.get(302)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */

      /* Empieza nodo:303 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(303)).setAttribute("nombre","hidcbVia" );
      ((Element)v.get(303)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */

      /* Empieza nodo:304 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(304)).setAttribute("nombre","hidcbTipoTarjeta" );
      ((Element)v.get(304)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */

      /* Empieza nodo:305 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(305)).setAttribute("nombre","hidcbClasesTarjeta" );
      ((Element)v.get(305)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */

      /* Empieza nodo:306 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(306)).setAttribute("nombre","hidcbEntidadBancaria" );
      ((Element)v.get(306)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */

      /* Empieza nodo:307 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(307)).setAttribute("nombre","hidcbMarcaPestanya4" );
      ((Element)v.get(307)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */

      /* Empieza nodo:308 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(308)).setAttribute("nombre","hidcbCanal" );
      ((Element)v.get(308)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */

      /* Empieza nodo:309 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(309)).setAttribute("nombre","hidcbTipoClasificacion" );
      ((Element)v.get(309)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */

      /* Empieza nodo:310 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(310)).setAttribute("nombre","hidcbTipoProblema" );
      ((Element)v.get(310)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */

      /* Empieza nodo:311 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(311)).setAttribute("nombre","hidrbSolucion" );
      ((Element)v.get(311)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */

      /* Empieza nodo:312 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(312)).setAttribute("nombre","hidcbTipoSolucion" );
      ((Element)v.get(312)).setAttribute("valor","" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(226)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */

      /* Empieza nodo:313 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(313)).setAttribute("nombre","hidtextDescripcionProblema" );
      ((Element)v.get(313)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */

      /* Empieza nodo:314 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(314)).setAttribute("nombre","hidtextDescripcionSolucion" );
      ((Element)v.get(314)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */

      /* Empieza nodo:315 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(315)).setAttribute("nombre","hidcbClasificacion" );
      ((Element)v.get(315)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */

      /* Empieza nodo:316 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(316)).setAttribute("nombre","hidtextNegocioProducto" );
      ((Element)v.get(316)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */

      /* Empieza nodo:317 / Elemento padre: 226   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(317)).setAttribute("nombre","ListaComboClasificacion" );
      ((Element)v.get(317)).setAttribute("valor","" );
      ((Element)v.get(226)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */
      /* Termina nodo:226   */


   }

}
