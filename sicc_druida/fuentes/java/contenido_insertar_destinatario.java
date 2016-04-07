
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_insertar_destinatario  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_insertar_destinatario" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Insertar mensajes" );
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
      ((Element)v.get(2)).setAttribute("src","scripts_clientes.js" );
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
      v.add(doc.createTextNode("\r\r\r\rvar tipoClasi = new Array();\rvar clasi = new Array();\rvar tipoSubti = new Array();\rvar tipoClien = new Array();\r\rfunction onLoadPag(){\r  \r	  configurarMenuSecundario(\"frmAsignacionDestinatarios\");\r	  fMostrarMensajeError();\r\r	  varNoLimpiarSICC = true;\r\r    DrdEnsanchaConMargenDcho('listado1',26);\r    document.all[\"Cplistado1\"].style.visibility='';\r    document.all[\"CpLin1listado1\"].style.visibility='';\r    document.all[\"CpLin2listado1\"].style.visibility='';\r    document.all[\"CpLin3listado1\"].style.visibility='';\r    document.all[\"CpLin4listado1\"].style.visibility='';\r    document.all[\"separaDiv\"].style.visibility='hidden';\r    document.all[\"primera1Div\"].style.visibility='hidden';\r    document.all[\"ret1Div\"].style.visibility='hidden';\r    document.all[\"ava1Div\"].style.visibility='hidden';\r   \r    eval (ON_RSZ);\r\r    var vUnidadesAdministrativas = get( 'frmAsignacionDestinatarios.hUnidadesAdministrativas' );\r	  var vTipoCliente = get( 'frmAsignacionDestinatarios.hTipoCliente' );\r    var vMarca = get( 'frmAsignacionDestinatarios.hMarca' );\r    var vCodigoVenta = get( 'frmAsignacionDestinatarios.hCodigoVenta' );\r	\r\r	\r	if( vUnidadesAdministrativas=='S' ){\r	  var div=document.getElementById( \"pUnidadesAdministrativas\" );\r	    	  div.attachEvent(\"onclick\", mostrarSolapaUnidadesAdministrativas);\r    }\r\r	if( vTipoCliente=='S' ){\r	  var div=document.getElementById( \"pTipoCliente\" );\r		  div.attachEvent(\"onclick\", mostrarSolapaTipoCliente);\r\r	  	  sicc_cambiar_estado('cbTipoCliente', true);\r	}\r\r	if( vMarca=='S' ){\r	  var div=document.getElementById( \"pMarca\" );\r			  div.attachEvent(\"onclick\", mostrarSolapaMarca);\r\r	  	  sicc_cambiar_estado('cbMarca4', true);\r   }\r\r	if( vCodigoVenta=='S' ){\r	  var div=document.getElementById( \"pCodigoVenta\" );\r	 		  div.attachEvent(\"onclick\", mostrarSolapaCodigoVenta);\r\r	  	  sicc_cambiar_estado('txtCodigoVenta', true);\r	}\r\r\r	 	 if( vUnidadesAdministrativas=='S' ){\r			  mostrarSolapaUnidadesAdministrativas();\r	 } else if( vTipoCliente=='S' ){\r			  mostrarSolapaTipoCliente();\r	 } else if( vMarca=='S' ){\r			  mostrarSolapaMarca();\r	 } else if( vCodigoVenta=='S' ){\r			  mostrarSolapaCodigoVenta();\r	 }\r \r	 	 if( get('frmAsignacionDestinatarios.opcionMenu')=='Modificar mensaje' || get('frmAsignacionDestinatarios.opcionMenu')=='Consultar mensaje' ||\r	 get('frmAsignacionDestinatarios.opcionMenu')=='Eliminar mensaje' ){\r\r      if(vUnidadesAdministrativas == 'S'){ \r         recargaListaUnidades();\r      }\r\r      if(vTipoCliente == 'S'){\r         procesaTipoCliente();\r      }\r\r    \r      \r      var hidMarca = get( 'frmAsignacionDestinatarios.hMarcasSeleccionadas' );\r      \r      if( hidMarca != '' ){\r             var aMarca = hidMarca.split(',');\r             set('frmAsignacionDestinatarios.cbMarca4', aMarca );\r      }\r\r   }\r      	 if( get('frmAsignacionDestinatarios.opcionMenu')=='Consultar mensaje' ||\r		   get('frmAsignacionDestinatarios.opcionMenu')=='Eliminar mensaje' ){\r          document.all[\"btnEliminarDiv\"].style.visibility='hidden';\r          \r  			  deshabilitarTodos();\r	 }\r\r   if( get('frmAsignacionDestinatarios.opcionMenu')=='Insertar mensaje'){\r      cargarValoresPorDefecto();     \r   }\r   \r}\r   function cargarValoresPorDefecto(){\r      var marca =      get('frmAsignacionDestinatarios.marcaPorDefecto');\r      var canal =      get('frmAsignacionDestinatarios.canalPorDefecto');\r\r      if (marca != null){\r\r         iSeleccionado = new Array(); \r         iSeleccionado[0] = marca;\r         set('frmAsignacionDestinatarios.cbMarca2',iSeleccionado);\r\r         iSeleccionado = new Array(); \r         iSeleccionado[0] = canal;\r         set('frmAsignacionDestinatarios.cbCanal', iSeleccionado);\r                  \r         asignar([['COMBO','frmAsignacionDestinatarios.cbRegion',\r                          'ConectorDruidaTransactionQuery',\r                          'dtoSalida.resultado_ROWSET',\r                          formarCadenaDT('ZONRecargaRegiones', \r                            'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', \r                            MakeParametersRegion()), \r						               'recargarRegion(datos);']]);	\r            \r         \r      }\r   } \r\r  function MakeParametersRegion(){\r        var arr = new Array();\r        arr[arr.length] = new Array(\"oidPais\", get('frmAsignacionDestinatarios.oidPais'));\r        arr[arr.length] = new Array(\"oidMarca\", get('frmAsignacionDestinatarios.cbMarca'));\r        arr[arr.length] = new Array(\"oidCanal\", get('frmAsignacionDestinatarios.cbCanal'));\r        return arr;\r    }\r\r function recargarRegion(datos){\r\r        var  arr = new Array();\r        var region =     get('frmAsignacionDestinatarios.regionPorDefecto');\r\r        arr[arr.length] = new Array([''],['']);\r        for (var i=0 ;i< datos.length ; i++)  {\r            arr[arr.length] = datos[i];\r        }\r\r        set_combo('frmAsignacionDestinatarios.cbRegion',arr);\r\r\r        var iSeleccionado = new Array(); \r        var oidRegion = region;\r        iSeleccionado[0] = oidRegion ;\r\r        set('frmAsignacionDestinatarios.cbRegion',iSeleccionado);\r\r         asignar([['COMBO','frmAsignacionDestinatarios.cbZona',\r                          'ConectorDruidaTransactionQuery',\r                          'dtoSalida.resultado_ROWSET',\r                          formarCadenaDT('ZONRecargaZonas', \r                            'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', \r                            armaArrayRegion()), \r						              'recargarZona(datos);']]);	\r\r                          \r    }\r  function recargarZona(datos){\r\r        var  arr = new Array();\r        var zona =       get('frmAsignacionDestinatarios.zonaPorDefecto');\r\r        arr[arr.length] = new Array([''],['']);\r        for (var i=0 ;i< datos.length ; i++)  {\r            arr[arr.length] = datos[i];\r        }\r\r        set_combo('frmAsignacionDestinatarios.cbZona',arr);\r        \r        var iSeleccionado = new Array(); \r        var oidZona = zona;\r\r        iSeleccionado[0] = oidZona;\r        set('frmAsignacionDestinatarios.cbZona',iSeleccionado); \r\r        asignar([['COMBO','frmAsignacionDestinatarios.cbSeccion',\r                          'ConectorDruidaTransactionQuery',\r                          'dtoSalida.resultado_ROWSET',\r                          formarCadenaDT('ZONRecargaSecciones', \r                            'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', \r                            armaArrayZona()), \r						               'recargarSeccion(datos);']]);	\r        \r    }\r\r\r  function recargarSeccion(datos){\r\r        var  arr = new Array();\r        var seccion =       get('frmAsignacionDestinatarios.seccionPorDefecto');\r\r        arr[arr.length] = new Array([''],['']);\r        for (var i=0 ;i< datos.length ; i++)  {\r            arr[arr.length] = datos[i];\r        }\r\r        set_combo('frmAsignacionDestinatarios.cbSeccion',arr);\r        \r        var iSeleccionado = new Array(); \r        var oidSeccion = seccion;\r\r        iSeleccionado[0] = oidSeccion;\r        set('frmAsignacionDestinatarios.cbSeccion',iSeleccionado); \r\r        asignar([['COMBO','frmAsignacionDestinatarios.cbTerritorio',\r                          'ConectorDruidaTransactionQuery',\r                          'dtoSalida.resultado_ROWSET',\r                          formarCadenaDT('ZONRecargaSecciones', \r                            'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', \r                            armaArraySeccion()), \r						               'recargarTerritorio(datos);']]);	\r        \r    }\r     function recargarTerritorio(datos){\r\r        var  arr = new Array();\r        var seccion =       get('frmAsignacionDestinatarios.terriPorDefecto');\r\r        arr[arr.length] = new Array([''],['']);\r        for (var i=0 ;i< datos.length ; i++)  {\r            arr[arr.length] = datos[i];\r        }\r\r        set_combo('frmAsignacionDestinatarios.cbTerritorio',arr);\r        \r        var iSeleccionado = new Array(); \r        var oidTerritorio = seccion;\r\r        iSeleccionado[0] = oidTerritorio;\r        set('frmAsignacionDestinatarios.cbTerritorio',iSeleccionado); \r\r        \r    }\r\r\r function mostrarSolapaUnidadesAdministrativas(){\r		  var div  = document.getElementById( \"pUnidadesAdministrativas\" );\r      var div2 = document.getElementById( \"pTipoCliente\" );\r      var div3 = document.getElementById( \"pMarca\" );\r      var div4 = document.getElementById( \"pCodigoVenta\" );\r		  div.bgColor  = \"#496A9A\";\r      div2.bgColor = \"\";\r      div3.bgColor = \"\";\r      div4.bgColor = \"\" ;\r		  mostrarSolapa('2');\r      muestraCapa();\r }\r\r function mostrarSolapaTipoCliente(){\r		  var div=document.getElementById( \"pTipoCliente\" );\r      var div2 = document.getElementById( \"pUnidadesAdministrativas\" );\r      var div3 = document.getElementById( \"pMarca\" );\r      var div4 = document.getElementById( \"pCodigoVenta\" );\r      \r		  div.bgColor = \"#496A9A\";\r      div2.bgColor = \"\";\r      div3.bgColor = \"\";\r      div4.bgColor = \"\" ;\r		\r		  mostrarSolapa('3');\r      ocultaCapa();\r }\r\r function mostrarSolapaMarca(){\r		  var div  = document.getElementById( \"pMarca\" );\r      var div2 = document.getElementById( \"pUnidadesAdministrativas\" );\r      var div3 =document.getElementById( \"pTipoCliente\" );\r      var div4 = document.getElementById( \"pCodigoVenta\" );\r      \r		  div.bgColor = \"#496A9A\";\r      div2.bgColor = \"\";\r      div3.bgColor = \"\";\r      div4.bgColor = \"\" ;\r		  mostrarSolapa('4');\r		  \r      ocultaCapa();\r }\r\r function mostrarSolapaCodigoVenta(){\r		  var div= document.getElementById( \"pCodigoVenta\" );\r      var div2  = document.getElementById( \"pMarca\" );\r      var div3 = document.getElementById( \"pUnidadesAdministrativas\" );\r      var div4 =document.getElementById( \"pTipoCliente\" );\r      \r		  div.bgColor = \"#496A9A\";\r      div2.bgColor = \"\";\r      div3.bgColor = \"\";\r      div4.bgColor = \"\" ;\r		  mostrarSolapa('5');\r		\r      ocultaCapa();\r }\r\r function mostrarSolapa(a){\r		  if( a=='2'||a=='3'||a=='4'||a=='5')\r				   ocultarSolapas();\r            \r		  if(a=='2'){\r				   visibilidad('camposBusqueda2','V');\r				   if( cbRegion.disabled == false ){\r							focaliza( 'frmAsignacionDestinatarios.cbMarca2' );\r				   }\r		  }\r		  else if(a=='3'){\r				   visibilidad('camposBusqueda3','V');\r				   if( cbTipoCliente.disabled == false ){\r							focaliza( 'frmAsignacionDestinatarios.cbTipoCliente' );\r				   }\r		  }\r		  else if(a=='4'){\r				   visibilidad('camposBusqueda4','V');\r				   if( cbMarca4.disabled == false ){\r							focaliza( 'frmAsignacionDestinatarios.cbMarca4' );\r				   }\r		  }\r		  else if(a=='5'){\r				   visibilidad('camposBusqueda5','V');\r				   if( txtCodigoVenta.disabled == false ){\r							focaliza( 'frmAsignacionDestinatarios.txtCodigoVenta' );\r				   }\r		  }\r }\r    \r function ocultarSolapas(){\r		  if( get_visibilidad('camposBusqueda2') ){\r				   visibilidad('camposBusqueda2','O');\r		  }\r		  if( get_visibilidad('camposBusqueda3') ){\r				   visibilidad('camposBusqueda3','O');\r		  }\r		  if( get_visibilidad('camposBusqueda4') ){\r				   visibilidad('camposBusqueda4','O');\r		  }\r		  if( get_visibilidad('camposBusqueda5') ){\r				   visibilidad('camposBusqueda5','O');\r		  }\r }\r\r\rfunction fGuardar(){\r		var vUnidadesAdministrativas = get( 'frmAsignacionDestinatarios.hUnidadesAdministrativas' );\r		var vTipoCliente = get( 'frmAsignacionDestinatarios.hTipoCliente' );\r		var vMarca = get( 'frmAsignacionDestinatarios.hMarca' );\r		var vCodigoVenta = get( 'frmAsignacionDestinatarios.hCodigoVenta' );\r\r		tipoClasi = new Array();\r		clasi = new Array();\r		tipoSubti = new Array();\r		tipoClien = new Array();\r\r		var estructuraTipoCliente = new Array();\r		\r		generarTiposClientes();\r\r		for (var i=0; i< clasi.length; i++){\r			estructuraTipoCliente[estructuraTipoCliente.length] = clasi[i];\r    }\r\r		for (var i=0; i< tipoClasi.length; i++){\r			estructuraTipoCliente[estructuraTipoCliente.length] = tipoClasi[i];\r    }\r\r		for (var i=0; i< tipoSubti.length; i++){\r			estructuraTipoCliente[estructuraTipoCliente.length] = tipoSubti[i];\r    }\r\r		for (var i=0; i< tipoClien.length; i++){\r			estructuraTipoCliente[estructuraTipoCliente.length] = tipoClien[i];\r    }\r\r    var elementos = new String();\r\r		for (var i=0;i<estructuraTipoCliente.length; i++){\r        elementos = elementos + estructuraTipoCliente[i] + '#';\r    }\r   \r    set('frmAsignacionDestinatarios.elementosSeleccionados', elementos);\r    		\r   \r		/*if(!sicc_validaciones_generales('grupo2')){\r			  visibilidad('camposBusqueda2','O');\r		  	visibilidad('camposBusqueda3','O');\r		  	visibilidad('camposBusqueda4','O');\r		  	visibilidad('camposBusqueda5','O');\r        ocultaCapa();\r			  return false;\r		}*/\r\r\r\r    var correcto = comprobarDatos();\r    if( correcto ){\r\r       if(validacionCapas()){\r          recolectarListaUA();\r      \r          setMV('frmAsignacionDestinatarios.cbMarca2', 'N');\r          setMV('frmAsignacionDestinatarios.cbCanal', 'N');\r          setMV('frmAsignacionDestinatarios.cbRegion', 'N');\r      \r          set( 'frmAsignacionDestinatarios.oculto', 'S' );\r          set( 'frmAsignacionDestinatarios.accion', 'Guardar' );\r          set( 'frmAsignacionDestinatarios.conectorAction', 'LPDestinatarios' );\r  \r          enviaSICC( 'frmAsignacionDestinatarios' );\r      \r       }\r    }\r      \r \r }\r\r   function validacionCapas(){\r      \r	    var vTipoCliente = get( 'frmAsignacionDestinatarios.hTipoCliente' );\r      var vMarca = get( 'frmAsignacionDestinatarios.hMarca' );\r      var vCodigoVenta = get( 'frmAsignacionDestinatarios.hCodigoVenta' );\r\r      if(vTipoCliente == 'S'){\r         if(get('frmAsignacionDestinatarios.cbTipoCliente') == ''){\r\r            visibilidad('camposBusqueda2','O');\r		  	    visibilidad('camposBusqueda4','O');\r		  	    visibilidad('camposBusqueda5','O');\r            visibilidad('camposBusqueda3','V');\r            mostrarSolapaTipoCliente();\r            GestionarMensaje('1107');\r            focaliza('frmAsignacionDestinatarios.cbTipoCliente');\r            return false;\r         }\r      }\r\r      if(vMarca == 'S'){\r         if(get('frmAsignacionDestinatarios.cbMarca4') == ''){\r\r            visibilidad('camposBusqueda2','O');\r		  	    visibilidad('camposBusqueda3','O');\r		  	    visibilidad('camposBusqueda5','O');\r            visibilidad('camposBusqueda4','V');\r            mostrarSolapaMarca();\r            GestionarMensaje('1525');\r            focaliza('frmAsignacionDestinatarios.cbMarca4');\r            return false;\r         }\r      }\r\r      if(vCodigoVenta == 'S'){\r         if(get('frmAsignacionDestinatarios.txtCodigoVenta') == ''){\r\r            visibilidad('camposBusqueda2','O');\r		  	    visibilidad('camposBusqueda3','O');\r		  	    visibilidad('camposBusqueda4','O');\r            visibilidad('camposBusqueda5','V');\r            mostrarSolapaCodigoVenta();\r            GestionarMensaje('1404');\r            focaliza('frmAsignacionDestinatarios.txtCodigoVenta');\r            return false;\r         }\r      }\r\r      return true;\r   }\r\r   function retorna(){\r            this.close();\r   }\r   \r\r   function recolectarListaUA(){\r      var datosLista = new String();\r      for (var i=0; i < listado1.datos.length; i++){\r      \r         datosLista = datosLista + listado1.datos[i][5] + ',';\r         datosLista = datosLista + listado1.datos[i][6] + ',';\r         datosLista = datosLista + listado1.datos[i][7] + ',';\r         datosLista = datosLista + listado1.datos[i][8] + \"#\";\r      }\r           set('frmAsignacionDestinatarios.hidListaUnidades', datosLista);\r         }\r\r\r\r		  function mostrarMensajeNumerico(campo){\r				   var msg = sicc_obtenerDescripcion(campo);\r				   focaliza(\"frmAsignacionDestinatarios.\" + campo);\r				   cdos_mostrarAlert(GestionarMensaje(\"000000000000100\" ,  \"\\\"\" + msg + \"\\\"\"));\r		  }\r\r	function generarTiposClientes(){\r		var oidS = new Array();\r		oidS = get( 'frmAsignacionDestinatarios.cbClasificacion');\r\r		for (var i=0; i < oidS.length; i++){\r			var oidTipoClasi = obtenerOidTipoClasi(oidS[i]);\r			var oidTipoSubti = obtenerOidTipoSubti(oidTipoClasi);\r			var oidTipoClien = obtenerOidTipoClien(oidTipoSubti);\r			var estructuraClasi = new Array();\r			estructuraClasi[0]  = oidTipoClien;\r			estructuraClasi[1]  = oidTipoSubti;\r			estructuraClasi[2]  = oidTipoClasi;\r			estructuraClasi[3]  = oidS[i];\r			clasi[clasi.length] = estructuraClasi;\r		}\r\r		oidS = get( 'frmAsignacionDestinatarios.cbTipoClasificacion');\r		for (var i=0; i < oidS.length; i++){\r			if (esNivel2(oidS[i])) {\r				var oidTipoSubti = obtenerOidTipoSubti(oidS[i]);\r				var oidTipoClien = obtenerOidTipoClien(oidTipoSubti);\r				var estructuraTipoClasi = new Array();\r				estructuraTipoClasi[0] = oidTipoClien;\r				estructuraTipoClasi[1] = oidTipoSubti;\r				estructuraTipoClasi[2] = oidS[i];\r				tipoClasi[tipoClasi.length] = estructuraTipoClasi;\r			}			\r		}\r\r		oidS = get( 'frmAsignacionDestinatarios.cbSubtipoCliente');\r		for (var i=0; i < oidS.length; i++){\r			if (esNivel1(oidS[i]))  {\r				var oidTipoClien = obtenerOidTipoClien(oidS[i]);\r				var estructuraTipoSubti = new Array();\r				estructuraTipoSubti[0] = oidTipoClien;\r				estructuraTipoSubti[1] = oidS[i];\r				tipoSubti[tipoSubti.length] = estructuraTipoSubti;\r			}			\r		}\r\r		oidS = get('frmAsignacionDestinatarios.cbTipoCliente');\r		for (var i=0; i < oidS.length; i++){\r			if (esNivel0(oidS[i]))  {\r				var estructuraTipoClien = new Array();\r				estructuraTipoClien[0] = oidS[i];\r				tipoClien[tipoClien.length] = estructuraTipoClien;\r			}			\r		}\r\r	}\r\r	function obtenerOidTipoClasi(oidClasi){\r		for (var i=0;i<lstClasificacion.datos.longitud; i++)\r			if (lstClasificacion.datos.ij(i,0) == oidClasi)\r				return lstClasificacion.datos.ij(i,1)\r	}\r \r	function obtenerOidTipoSubti(oidTipoClasi){\r		for (var i=0;i<lstTipoClasificacion.datos.longitud; i++)\r			if (lstTipoClasificacion.datos.ij(i,0) == oidTipoClasi)\r				return lstTipoClasificacion.datos.ij(i,1)\r	}\r\r	function obtenerOidTipoClien(oidTipoSubti){\r		for (var i=0;i<lstSubtipo.datos.longitud; i++)\r			if (lstSubtipo.datos.ij(i,0) == oidTipoSubti)\r				return lstSubtipo.datos.ij(i,1)\r	}\r\r\r	function esNivel0(oid){\r		for (var i=0; i<tipoSubti.length; i++){\r			var estructura = tipoSubti[i];\r			if (estructura[0] == oid){\r				return false;\r			}\r		}\r		for (var i=0; i<tipoClasi.length; i++){\r			var estructura = tipoClasi[i];\r			if (estructura[0] == oid)\r				return false;\r		}\r		for (var i=0; i<clasi.length; i++){\r			var estructura = clasi[i];\r			if (estructura[0] == oid)\r				return false;\r		}\r		return true;\r	}\r\r	function esNivel1(oid){\r		for (var i=0; i<tipoClasi.length; i++){\r			var estructura = tipoClasi[i];\r			if (estructura[1] == oid)\r				return false;\r		}\r		for (var i=0; i<clasi.length; i++){\r			var estructura = clasi[i];\r			if (estructura[1] == oid)\r				return false;\r		}\r		return true;\r	}\r	function esNivel2(oid){\r		for (var i=0; i<clasi.length; i++){\r			var estructura = clasi[i];\r			if (estructura[2] == oid){\r				return false;\r			}\r\r		}\r		return true;\r	}\r\r\r	function fLimpiar(){\r		  if( get_visibilidad( 'camposBusqueda2' ) ){\r         if( get('frmAsignacionDestinatarios.opcionMenu')=='Insertar mensaje'){\r            cargarValoresPorDefecto();     \r         }else{\r           set('frmAsignacionDestinatarios.cbMarca2', '')\r           set('frmAsignacionDestinatarios.cbCanal', '')\r           \r			     var aCombo = new Array(new Array(\"\",\"\"));\r      \r           set_combo( 'frmAsignacionDestinatarios.cbRegion' ,aCombo, []);\r           set_combo( 'frmAsignacionDestinatarios.cbZona' ,aCombo, []);\r           set_combo( 'frmAsignacionDestinatarios.cbSeccion' ,aCombo, []);\r           set_combo( 'frmAsignacionDestinatarios.cbTerritorio' ,aCombo, []);\r				   focaliza('frmAsignacionDestinatarios.cbMarca2');\r         }\r				   \r		  } else if( get_visibilidad( 'camposBusqueda3' ) ){\r				   set( 'frmAsignacionDestinatarios.cbTipoCliente', new Array() );\r				   set_combo( 'frmAsignacionDestinatarios.cbSubtipoCliente', new Array() );\r				   set_combo( 'frmAsignacionDestinatarios.cbTipoClasificacion', new Array() );\r				   set_combo( 'frmAsignacionDestinatarios.cbClasificacion', new Array() );\r				   accion('frmAsignacionDestinatarios.cbSubtipoCliente','.disabled=true');\r				   accion('frmAsignacionDestinatarios.cbTipoClasificacion','.disabled=true');\r				   accion('frmAsignacionDestinatarios.cbClasificacion','.disabled=true');\r				   if( cbTipoCliente.disabled == false ){\r							focaliza( 'frmAsignacionDestinatarios.cbTipoCliente' );\r				   }\r		  } else if( get_visibilidad( 'camposBusqueda4' ) ){\r				   set( 'frmAsignacionDestinatarios.cbMarca4', new Array() );\r				   if( cbMarca4.disabled == false ){\r							focaliza( 'frmAsignacionDestinatarios.cbMarca4' );\r				   }\r		  } else if( get_visibilidad( 'camposBusqueda5' ) ){\r				   set( 'frmAsignacionDestinatarios.txtCodigoVenta', '' );\r				   if( txtCodigoVenta.disabled == false ){\r							focaliza( 'frmAsignacionDestinatarios.txtCodigoVenta' );\r				   }\r		  } \r }\r\r  function filtrarCampos(){\r		  if( vUnidadesAdministrativas != 'S' ){\r			  set( 'frmAsignacionDestinatarios.cbRegion' );\r				   set( 'frmAsignacionDestinatarios.cbZona' )\r				   set( 'frmAsignacionDestinatarios.cbSeccion' )\r				   set( 'frmAsignacionDestinatarios.cbTerritorio' )\r		  }\r		  if( vTipoCliente != 'S' ){\r		  }\r		  if( vMarca != 'S' ){\r		  }\r		  if( vCodigoVenta != 'S' ){\r		  }\r }\r\r\r function comprobarDatos(){\r		  var correcto = true;\r\r      if( get ('frmAsignacionDestinatarios.unidadAdministrativa') == 'S'){\r         correcto = comprobarUnidadAdministrativa();\r\r      }\r\r		/*  if( get( 'frmAsignacionDestinatarios.tipoCliente' )=='S' ){\r				   correcto = comprobarTipoCliente();\r		  }\r\r		  if( correcto && get( 'frmAsignacionDestinatarios.marca' )=='S' ){\r				   correcto = comprobarMarca();\r		  }\r\r		  if( correcto && get( 'frmAsignacionDestinatarios.codigoVenta' )=='S' ){\r				   correcto = comprobarCodigoVenta();\r		  }*/\r\r		  return correcto;\r }\r\r   function comprobarUnidadAdministrativa(){\r      var lista = listado1.datos.length;\r\r      if (lista == 0){\r         visibilidad('camposBusqueda3','O');\r         visibilidad('camposBusqueda4','O');\r         visibilidad('camposBusqueda5','O');\r         visibilidad('camposBusqueda2','V');\r         mostrarSolapaUnidadesAdministrativas();\r                  GestionarMensaje(1392);\r         focaliza('frmAsignacionDestinatarios.cbMarca2');\r         return false;\r      }else{\r         return true;\r      }\r   }\r \r\r function comprobarTipoCliente(){\r		  var sel = get( 'frmAsignacionDestinatarios.cbTipoCliente' );\r		  if( sel.toString()=='' ){\r				   GestionarMensaje(1107);\r				   return false;\r		  }\r		  return true;\r }\r\r function comprobarMarca(){\r		  var sel = get( 'frmAsignacionDestinatarios.cbMarca4' );\r		  if( sel.toString()=='' ){\r				   GestionarMensaje(1076);\r				   return false;\r		  }\r		  return true;\r }\r\r\r function comprobarCodigoVenta(){\r		  var cv = get( 'frmAsignacionDestinatarios.txtCodigoVenta' );\r\r		  if( cv == '' ){\r				   GestionarMensaje( 1143 );\r				   return false;\r		  }\r\r		  		  var acv = cv.split(';');\r\r		  for( i = 0; i < acv.length; i++ ){\r				   if( !validarNumeroCodVenta( acv[i] ) ){\r							return false;\r				   }\r                           \r		  }\r\r		  return true;\r }\r\r\r function validarNumeroCodVenta( num ){\r                  \r		  var x = esNumero( num );\r\r		  if( x == 'OK' ){\r				   return true;\r		  } else{\r				   GestionarMensaje( 2560 );\r				   if( txtCodigoVenta.disabled == false ){\r							focaliza( 'frmAsignacionDestinatarios.txtCodigoVenta' );\r				   }\r				   return false;\r		  }\r }\r\r\r function accionAnadirCliente(){\r		   }\r\r function accionEliminarCliente(){\r		  if( get_visibilidad( 'frmAsignacionDestinatarios.camposBusqueda8' ) ){\r				   if( listado1.numSelecc() > 0){\r							listado1.eliminarSelecc();\r							listado1.repintaDat();\r				   }\r		  }\r }\r\r\rfunction validarDestinatarios(){\r var resultado = false;\r   \r if (get_visibilidad('camposBusqueda2')){\r		  if (fValidarCOMBO('frmAsignacionDestinatarios.cbRegion') && get('frmAsignacionDestinatarios.cbRegion')!=''){\r				   resultado=true;\r		  }\r }else if (get_visibilidad('camposBusqueda3')){\r		  if (fValidarCOMBO('frmAsignacionDestinatarios.cbTipo') && get('frmAsignacionDestinatarios.cbTipo')!=''){\r				   resultado=true;\r		  }\r }else if (get_visibilidad('camposBusqueda4')){\r		  if (fValidarCOMBO('frmAsignacionDestinatarios.cbMarca4') && get('frmAsignacionDestinatarios.cbMarca4')!=''){\r				   resultado=true;\r		  }\r }else if (get_visibilidad('camposBusqueda5')){\r		  if (fValidarCTEXT('frmAsignacionDestinatarios.txtCodVenta')){\r				   resultado=true;\r		  }\r }else if (get_visibilidad('camposBusqueda6')){\r		  resultado=true;\r }\r return resultado;\r}\r\r \rfunction cambioTipo(){\r\r if( get('frmAsignacionDestinatarios.opcionMenu')=='Consultar mensaje' || get('frmAsignacionDestinatarios.opcionMenu')=='Eliminar mensaje' ){\r    return;\r }else{\r \r     opciones = new Array();\r     set_combo('frmAsignacionDestinatarios.cbSubtipoCliente',opciones);                      \r     tipo = get('frmAsignacionDestinatarios.cbTipoCliente','V');\r     combo_add('frmAsignacionDestinatarios.cbSubtipoCliente', '', '');\r     if (tipo.length==1 &&  tipo==\"\"){\r          accion( 'frmAsignacionDestinatarios.cbSubtipoCliente', '.disabled=true' );\r          set_combo('frmAsignacionDestinatarios.cbTipoClasificacion',opciones);\r          accion( 'frmAsignacionDestinatarios.cbTipoClasificacion', '.disabled=true' );\r          set_combo('frmAsignacionDestinatarios.cbClasificacion',opciones);\r          accion( 'frmAsignacionDestinatarios.cbClasificacion', '.disabled=true' );\r     }else{\r          accion( 'frmAsignacionDestinatarios.cbSubtipoCliente', '.disabled=false' );\r          var x=0;\r          for(var k=0;k<lstSubtipo.datos.longitud;k++) {\r               for(var y=0;y<tipo.length;y++){\r                  if (lstSubtipo.datos.ij(k,1) == tipo[y]){ 			 \r                       combo_add('frmAsignacionDestinatarios.cbSubtipoCliente',lstSubtipo.datos.ij(k,0),lstSubtipo.datos.ij(k,2));\r                       x++;\r                  }\r               }\r          }\r\r          if (x < 1){\r               accion( 'frmAsignacionDestinatarios.cbSubtipoCliente', '.disabled=true' );\r               set_combo('frmAsignacionDestinatarios.cbTipoClasificacion',opciones);\r               accion( 'frmAsignacionDestinatarios.cbTipoClasificacion', '.disabled=true' );\r               set_combo('frmAsignacionDestinatarios.cbClasificacion',opciones);\r               accion( 'frmAsignacionDestinatarios.cbClasificacion', '.disabled=true' );\r          }else{\r               accion( 'frmAsignacionDestinatarios.cbSubtipoCliente', '.disabled=false' );\r               accion( 'frmAsignacionDestinatarios.cbTipoClasificacion', '.disabled=false' );\r               accion( 'frmAsignacionDestinatarios.cbClasificacion', '.disabled=false' );\r               iSeleccionado = new Array(); \r               iSeleccionado[0] = get('frmAsignacionDestinatarios.hSubtipo')==\"\"?\"0\":get('frmAsignacionDestinatarios.hSubtipo');\r               set('frmAsignacionDestinatarios.cbSubtipoCliente',iSeleccionado);\r          }\r      }\r   }\r}\r \rfunction cambioSubtipo(){\rif( get('frmAsignacionDestinatarios.opcionMenu')=='Consultar mensaje' || get('frmAsignacionDestinatarios.opcionMenu')=='Eliminar mensaje' ){\r    return;\r }else{\r     opciones = new Array();\r     set_combo('frmAsignacionDestinatarios.cbTipoClasificacion',opciones);          \r     var subTipo = get('frmAsignacionDestinatarios.cbSubtipoCliente','V');\r     combo_add('frmAsignacionDestinatarios.cbTipoClasificacion', '', '');\r     if (subTipo.length==1 &&  subTipo==\"\"){\r          accion( 'frmAsignacionDestinatarios.cbTipoClasificacion', '.disabled=true' );\r          set_combo('frmAsignacionDestinatarios.cbClasificacion',opciones);\r          accion( 'frmAsignacionDestinatarios.cbClasificacion', '.disabled=true' );\r     }else{\r          accion( 'frmAsignacionDestinatarios.cbSeccion', '.disabled=false' );\r          var x=0;\r          for(var k=0;k<lstTipoClasificacion.datos.longitud;k++) {\r               for(var y=0;y<subTipo.length;y++){\r                  if (lstTipoClasificacion.datos.ij(k,1) == subTipo[y]){ 			 \r                       combo_add('frmAsignacionDestinatarios.cbTipoClasificacion',lstTipoClasificacion.datos.ij(k,0),lstTipoClasificacion.datos.ij(k,2));\r                       x++;\r                  }\r               }\r          }\r\r          if (x<1){\r               accion( 'frmAsignacionDestinatarios.cbTipoClasificacion', '.disabled=true' );\r               set_combo('frmAsignacionDestinatarios.cbClasificacion',opciones);\r               accion( 'frmAsignacionDestinatarios.cbClasificacion', '.disabled=true' );\r          }else{\r               accion( 'frmAsignacionDestinatarios.cbTipoClasificacion', '.disabled=false' );\r               accion( 'frmAsignacionDestinatarios.cbClasificacion', '.disabled=false' );\r               iSeleccionado = new Array(); \r               iSeleccionado[0] = get('frmAsignacionDestinatarios.hTipoClasificacion')==\"\"?\"0\":get('frmAsignacionDestinatarios.hTipoClasificacion');\r               set('frmAsignacionDestinatarios.cbTipoClasificacion',iSeleccionado);\r          }\r     }\r   }\r}\r\rfunction cambioTipoClasificacion(){\r  if( get('frmAsignacionDestinatarios.opcionMenu')=='Consultar mensaje' || get('frmAsignacionDestinatarios.opcionMenu')=='Eliminar mensaje' ){\r      return;\r  }else{\r     opciones = new Array();\r     set_combo('frmAsignacionDestinatarios.cbClasificacion',opciones);                      \r     var tipoClasificacion = get('frmAsignacionDestinatarios.cbTipoClasificacion','V');\r     combo_add('frmAsignacionDestinatarios.cbClasificacion', '', '');\r     \r\r     var x=0;\r     for(var k=0;k<lstClasificacion.datos.longitud;k++) {\r               for(var y=0;y<tipoClasificacion.length;y++){\r                  if (lstClasificacion.datos.ij(k,1) == tipoClasificacion[y]){ 			 \r                       combo_add('frmAsignacionDestinatarios.cbClasificacion',lstClasificacion.datos.ij(k,0),lstClasificacion.datos.ij(k,2));\r                       x++;\r                  }\r               }\r      }\r\r      if (x<1){\r         accion( 'frmAsignacionDestinatarios.cbClasificacion', '.disabled=true' );\r      }else{\r           accion( 'frmAsignacionDestinatarios.cbClasificacion', '.disabled=false' );\r           iSeleccionado = new Array(); \r           iSeleccionado[0] = get('frmAsignacionDestinatarios.hClasificacion')==\"\"?\"0\":get('frmAsignacionDestinatarios.hClasificacion');\r           set('frmAsignacionDestinatarios.cbClasificacion',iSeleccionado);\r      }\r      \r    }\r}\r\rfunction procesaTipoCliente(){\r\r   if( get('frmAsignacionDestinatarios.opcionMenu')=='Consultar mensaje' || get('frmAsignacionDestinatarios.opcionMenu')=='Eliminar mensaje' ){\r     seleccionaTipoCliente();\r     var subtipo   = procesaArray2(get('frmAsignacionDestinatarios.hSeleccionSubtipoCliente'));\r     var tipoClasi = procesaArray2(get('frmAsignacionDestinatarios.hSeleccionTipoClasificacion'));\r     var clasi     = procesaArray2(get('frmAsignacionDestinatarios.hSeleccionClasificacion'));\r     \r     set_combo('frmAsignacionDestinatarios.cbSubtipoCliente', obtenerDescripciones(subtipo, lstSubtipo));\r     set_combo('frmAsignacionDestinatarios.cbTipoClasificacion', obtenerDescripciones(tipoClasi, lstTipoClasificacion));\r     set_combo('frmAsignacionDestinatarios.cbClasificacion', obtenerDescripciones(clasi, lstClasificacion));\r      \r    \r	 }else{    \r     set('frmAsignacionDestinatarios.cbTipoCliente',procesaArray(get('frmAsignacionDestinatarios.hSeleccionTipoCliente')));\r     cambioTipo();  \r     set('frmAsignacionDestinatarios.cbSubtipoCliente',procesaArray(get('frmAsignacionDestinatarios.hSeleccionSubtipoCliente')));\r     cambioSubtipo();\r     set('frmAsignacionDestinatarios.cbTipoClasificacion',procesaArray(get('frmAsignacionDestinatarios.hSeleccionTipoClasificacion')));\r     cambioTipoClasificacion();\r     set('frmAsignacionDestinatarios.cbClasificacion',procesaArray(get('frmAsignacionDestinatarios.hSeleccionClasificacion')));\r   }        \r	 \r}\r\r   function seleccionaTipoCliente(){\r\r      var tipoClienSelec = get('frmAsignacionDestinatarios.hSeleccionTipoCliente');\r 	  var tipoCliTemp    = tipoClienSelec.split(','); \r      var tipoCliFinal   = new Array();\r      var valoresCombo   = obtieneOidsComboTipoCliente();\r      var dato = new Array();\r      var descripcion = new Array();\r	  var encontro ;\r\r      tipoCliFinal[tipoCliFinal.length] = tipoCliTemp[0];\r\r	  for(var m = 1; m < tipoCliTemp.length; m++){\r          encontro = false;\r	      for(var y = 0; y < tipoCliFinal.length; y++){\r			 if(tipoCliTemp[m] == tipoCliFinal[y]){\r			    encontro = true;\r             }\r		  }\r         	  \r		  if(encontro == false){\r  		      tipoCliFinal[tipoCliFinal.length] = tipoCliTemp[m];			 \r		  }\r\r	  }\r\r      \r      for (var i = 0; i < valoresCombo.length; i++){\r          dato = valoresCombo[i];\r     \r          for(var x = 0; x < tipoCliFinal.length; x++){\r             if(dato[0] == tipoCliFinal[x]){\r               var desc = descripcion.length;\r               var temp =  new Array();\r               temp[0] = dato[0];\r               temp[1] = dato[1];\r               descripcion[desc] =  temp;\r               \r             }\r          }\r          \r      }       \r      set_combo('frmAsignacionDestinatarios.cbTipoCliente', descripcion);\r   }\r\r  function obtenerDescripciones(oids, listado){\r	   var array = new Array();\r\r	   for( var i=0; i<oids.length; i++){\r		   for(var j=0;j<listado.datos.longitud; j++){\r			   if (listado.datos.ij(j,0) == oids[i]){\r				   var fila = new Array();\r				   fila[fila.length] = listado.datos.ij(j,0);\r				   fila[fila.length] = listado.datos.ij(j,2);\r				   array[array.length] = fila;\r			   }\r		   }\r	   }\r	   return array;\r  }\r\r\r\r   function obtieneOidsComboTipoCliente(){\r	    var cantElems = combo_get(\"frmAsignacionDestinatarios.cbTipoCliente\", \"L\", \"\");\r	    var oids = new Array();\r\r	    for (var i = 0; i < cantElems; i++){\r         var oid = combo_get(\"frmAsignacionDestinatarios.cbTipoCliente\", \"V\", i);\r	       var desc = combo_get(\"frmAsignacionDestinatarios.cbTipoCliente\", \"T\", i);\r	       if ( oid != \"\"){\r	          var array = new Array(oid, desc);\r	          oids[oids.length] \r     	      var desc = combo_get(\"frmAsignacionDestinatarios.cbTipoCliente\", \"T\", i);\r\r	          if ( oid != \"\"){\r	             var array = new Array(oid, desc);\r	             oids[oids.length] = array;\r	          }\r	       }\r      }\r      return oids;\r   }\r\r\r  	function procesaArray (valor){\r		var array = valor.split(',');\r		return array;\r	}\r   \r\r	function procesaArray2 (valor){\r		var arrTemp = valor.split(',');\r		var arrFinal = new Array();\r		var encontro;\r		\r		arrFinal[arrFinal.length] = arrTemp[0];\r\r  	    for(var m = 1; m < arrTemp.length; m++){\r 		   \r		   encontro = false;\r	       \r		   for(var y = 0; y < arrFinal.length; y++){\r		     \r  		     if(arrTemp[m] == arrFinal[y]){\r			    encontro = true\r		     }	  \r		  }\r          \r		  if(encontro == false){\r    	      arrFinal[arrFinal.length] = arrTemp[m];			 \r		  }\r		}\r\r   	    return arrFinal;\r	}\r\r	function obtieneHijo(valor, listaHija){\r		var array = new Array();\r		var x=0;\r		for (var i=0;i<listaHija.datos.longitud;i++){\r			for (var k=0;k<valor.length;k++){\r				if (valor[k]==listaHija.datos.ij(i,0)){\r					 array[x] = listaHija.datos.ij(i,2);\r					 x++;\r				}\r			}\r		}\r		return array;\r	}\r\r		function obtieneHijo2(valor, listaHija){\r		var array = new Array();\r		var x=0;\r    \r		for (var i=0;i<listaHija.datos.longitud;i++){\r      			for (var k=0;k<valor.length;k++){\r                \r				if (valor[k]==listaHija.datos.ij(i,0)){\r           \r					 array[x] = listaHija.datos.ij(i,1);\r           					 x++;\r				}\r			}\r		}\r\r    \r		return array;\r	}\r\r\r	function fVolver(){\r	   this.close();\r  }\r\r   \r function posicionarComboUnidadesAdministrativas( cmb, tab ){\r         \r		  		  		  		  		  \r		  \r		  		  		  \r		  if( tab == 'ontab' ){\r				   if( cmb == 'cbRegion' ){\r							focalizaZona();\r				   } else if( cmb == 'cbZona' ){\r							focalizaSeccion();\r				   } else if( cmb == 'cbSeccion' ){\r							focalizaTerritorio();\r				   } else if( cmb == 'cbTerritorio' ){\r							focalizaBotonHTML('botonContenido','btnAnadir');\r				   }\r		  } else if( tab == 'onshtab' ){\r				   if( cmb == 'cbRegion' ){\r							focalizaTerritorio();\r				   } else if( cmb == 'cbZona' ){\r							focalizaRegion();\r				   } else if( cmb == 'cbSeccion' ){\r							focalizaZona();\r				   } else if( cmb == 'cbTerritorio' ){\r							focalizaSeccion();\r				   }\r		  }\r }\r\r function focalizaRegion(){\r		  if( cbRegion.disabled != true ){\r				   focaliza( 'frmAsignacionDestinatarios.cbRegion' );\r		  }\r }\r\r function focalizaZona(){\r		  if( cbZona.disabled != true ){\r				   focaliza( 'frmAsignacionDestinatarios.cbZona' );\r		  }\r }\r\r function focalizaSeccion(){\r		  if( cbSeccion.disabled != true ){\r				   focaliza( 'frmAsignacionDestinatarios.cbSeccion' );\r		  }\r         \r }\r\r function focalizaTerritorio(){\r		  if( cbTerritorio.disabled != true ){\r				   focaliza( 'frmAsignacionDestinatarios.cbTerritorio' );\r		  }\r }\r\r function posicionarComboTipoCliente( cmb, tab ){\r         \r		  		  		  		  		  \r		  \r		  		  		  \r		  if( tab == 'ontab' ){\r				   if( cmb == 'cbClasificacion' ){\r							if( cbTipoCliente.disabled != true ){\r									 focaliza( 'frmAsignacionDestinatarios.cbTipoCliente' );\r							}\r				   }\r		  } else if( tab == 'onshtab' ){\r				   if( cmb == 'cbTipoCliente' ){\r							if( cbClasificacion.disabled != true ){\r									 focaliza( 'frmAsignacionDestinatarios.cbClasificacion' );\r							}\r				   }\r		  }\r }\r\r\r function deshabilitarTodos(){\r		  accion('frmAsignacionDestinatarios.txtCodigoVenta','.disabled=true');\r      accion('frmAsignacionDestinatarios.cbMarca2','.disabled=true');\r      accion('frmAsignacionDestinatarios.cbCanal','.disabled=true');\r		  accion('frmAsignacionDestinatarios.cbRegion','.disabled=true');\r		  accion('frmAsignacionDestinatarios.cbZona','.disabled=true');\r		  accion('frmAsignacionDestinatarios.cbSeccion','.disabled=true');\r		  accion('frmAsignacionDestinatarios.cbTerritorio','.disabled=true');\r	}   \r\r\r  function marcaOnChange(){\r     var marca = get('frmAsignacionDestinatarios.cbMarca2');\r  \r     if(marca != ''){\r        correcto = comprobarCanal();\r        if(correcto){\r           vaciarCombos();\r           recargaCombo( 'frmAsignacionDestinatarios.cbRegion', 'ZONRecargaRegiones','es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', armaArray());\r        }\r     }else{\r        vaciarCombos();\r     }\r  }\r\r  function canalOnChange(){\r     var canal = get('frmAsignacionDestinatarios.cbCanal');\r\r     if(canal != ''){\r        correcto = comprobarMarcaUA();\r\r        if(correcto){\r           vaciarCombos();\r           recargaCombo( 'frmAsignacionDestinatarios.cbRegion', 'ZONRecargaRegiones','es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', armaArray());\r        }\r     }else{\r        vaciarCombos();\r     }\r  }\r\r\r   function regionOnChange(){\r      vaciarCombos2();      \r      recargaCombo( 'frmAsignacionDestinatarios.cbZona', 'ZONRecargaZonas','es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', armaArrayRegion());\r   }\r\r\r   function zonaOnChange(){\r      vaciarCombos3();  \r      recargaCombo( 'frmAsignacionDestinatarios.cbSeccion', 'ZONRecargaSecciones','es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', armaArrayZona());\r   }\r\r\r   function seccionOnChange(){\r      vaciarCombos4();  \r      recargaCombo( 'frmAsignacionDestinatarios.cbTerritorio', 'ZONRecargaTerritorios','es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', armaArraySeccion());\r   }\r\r\r   function comprobarMarcaUA(){\r      var marcaUA = get('frmAsignacionDestinatarios.cbMarca2');\r\r     if(marcaUA == ''){\r                vaciarCombos();\r        return false;\r     }else{\r        return true;\r     }\r   }\r\r function comprobarCanal(){\r \r     var canal = get('frmAsignacionDestinatarios.cbCanal');\r\r     if(canal == ''){\r        vaciarCombos();\r        return false;\r     }else{\r        return true;\r     }\r  }\r\r\r   function armaArray(){\r      var arr = new Array();\r\r      arr[arr.length] = new Array('oidPais',get('frmAsignacionDestinatarios.oidPais'));   \r      arr[arr.length] = new Array('oidMarca',get('frmAsignacionDestinatarios.cbMarca2'));\r      arr[arr.length] = new Array('oidCanal',get('frmAsignacionDestinatarios.cbCanal'));\r\r      return arr;\r      \r   }  \r\r\r   function armaArrayRegion(){\r      var arr = new Array();\r\r      arr[arr.length] = new Array('oidPais',get('frmAsignacionDestinatarios.oidPais'));   \r      arr[arr.length] = new Array('oidMarca',get('frmAsignacionDestinatarios.cbMarca2'));\r      arr[arr.length] = new Array('oidCanal',get('frmAsignacionDestinatarios.cbCanal'));\r      arr[arr.length] = new Array('oidRegion',get('frmAsignacionDestinatarios.cbRegion'));\r\r      return arr;\r   }\r\r\r   function armaArrayZona(){\r      var arr = new Array();\r\r      arr[arr.length] = new Array('oidPais',get('frmAsignacionDestinatarios.oidPais'));   \r      arr[arr.length] = new Array('oidMarca',get('frmAsignacionDestinatarios.cbMarca2'));\r      arr[arr.length] = new Array('oidCanal',get('frmAsignacionDestinatarios.cbCanal'));\r      arr[arr.length] = new Array('oidRegion',get('frmAsignacionDestinatarios.cbRegion'));\r      arr[arr.length] = new Array('oidZona',get('frmAsignacionDestinatarios.cbZona'));\r\r      return arr;\r   }\r\r\r   function armaArraySeccion(){\r      var arr = new Array();\r\r      arr[arr.length] = new Array('oidPais',get('frmAsignacionDestinatarios.oidPais'));   \r      arr[arr.length] = new Array('oidMarca',get('frmAsignacionDestinatarios.cbMarca2'));\r      arr[arr.length] = new Array('oidCanal',get('frmAsignacionDestinatarios.cbCanal'));\r      arr[arr.length] = new Array('oidRegion',get('frmAsignacionDestinatarios.cbRegion'));\r      arr[arr.length] = new Array('oidZona',get('frmAsignacionDestinatarios.cbZona'));\r      arr[arr.length] = new Array('oidSeccion',get('frmAsignacionDestinatarios.cbSeccion'));\r\r      return arr;\r   }\r\r\r   function incluirUA(){\r   if( get('frmAsignacionDestinatarios.opcionMenu')=='Consultar mensaje' || get('frmAsignacionDestinatarios.opcionMenu')=='Eliminar mensaje' ){\r      return;\r   }else{\r\r     if(!sicc_validaciones_generales('grupo1')){\r        return;\r\r     }else{\r\r        var region     = document.getElementById('cbRegion');\r        var zona       = document.getElementById('cbZona');\r        var seccion    = document.getElementById('cbSeccion');\r        var territorio = document.getElementById('cbTerritorio')\r\r        var descRegion     = region.options[region.selectedIndex].text; \r        var descZona       = zona.options[zona.selectedIndex].text; \r        var descSeccion    = seccion.options[seccion.selectedIndex].text;\r        var descTerritorio = territorio.options[territorio.selectedIndex].text;\r\r        var oidRegion      = region.options[region.selectedIndex].value; \r        var oidZona        = zona.options[zona.selectedIndex].value; \r        var oidSeccion     = seccion.options[seccion.selectedIndex].value;\r        var oidTerritorio  = territorio.options[territorio.selectedIndex].value;\r\r        var linea = new Array();\r        linea[linea.length] = 'g';\r        linea[linea.length] = descRegion;\r        linea[linea.length] = descZona;\r        linea[linea.length] = descSeccion;\r        linea[linea.length] = descTerritorio;\r        linea[linea.length] = oidRegion;\r        linea[linea.length] = oidZona;\r        linea[linea.length] = oidSeccion;\r        linea[linea.length] = oidTerritorio;\r      \r        listado1.insertar(linea);\r        listado1.repinta();\r                set('frmAsignacionDestinatarios.cbMarca2', '')\r        set('frmAsignacionDestinatarios.cbCanal', '')\r           \r        var aCombo = new Array(new Array(\"\",\"\"));\r      \r        set_combo( 'frmAsignacionDestinatarios.cbRegion' ,aCombo, []);\r        set_combo( 'frmAsignacionDestinatarios.cbZona' ,aCombo, []);\r        set_combo( 'frmAsignacionDestinatarios.cbSeccion' ,aCombo, []);\r        set_combo( 'frmAsignacionDestinatarios.cbTerritorio' ,aCombo, []);\r        focaliza('frmAsignacionDestinatarios.cbMarca2');\r      \r        }\r      }\r   }\r\r\r   function eliminarUA(){\r      if( listado1.numSelecc() > 0){\r		     listado1.eliminarSelecc();\r				 listado1.repintaDat();\r			}else{\r         GestionarMensaje(\"50\");\r      }\r   }\r   \r\r   function muestraCapa(){\r      document.all[\"Cplistado1\"].style.visibility='visible';\r      document.all[\"CpLin1listado1\"].style.visibility='visible';\r      document.all[\"CpLin2listado1\"].style.visibility='visible';\r      document.all[\"CpLin3listado1\"].style.visibility='visible';\r      document.all[\"CpLin4listado1\"].style.visibility='visible';\r      document.all[\"separaDiv\"].style.visibility='hidden';\r      document.all[\"primera1Div\"].style.visibility='hidden';\r      document.all[\"ret1Div\"].style.visibility='hidden';\r      document.all[\"ava1Div\"].style.visibility='hidden';\r\r      if(get('frmAsignacionDestinatarios.opcionMenu')=='Modificar mensaje'){\r         document.all[\"btnEliminarDiv\"].style.visibility='visible';\r      }\r   }\r\r\r   function ocultaCapa(){\r      document.all[\"Cplistado1\"].style.visibility='hidden';\r      document.all[\"CpLin1listado1\"].style.visibility='hidden';\r      document.all[\"CpLin2listado1\"].style.visibility='hidden';\r      document.all[\"CpLin3listado1\"].style.visibility='hidden';\r      document.all[\"CpLin4listado1\"].style.visibility='hidden';\r      document.all[\"separaDiv\"].style.visibility='hidden';\r      document.all[\"primera1Div\"].style.visibility='hidden';\r      document.all[\"ret1Div\"].style.visibility='hidden';\r      document.all[\"ava1Div\"].style.visibility='hidden';\r      document.all[\"btnEliminarDiv\"].style.visibility='hidden';\r   }\r\r   function vaciarCombos(){\r      var aCombo = new Array(new Array(\"\",\"\"));\r      \r      set_combo( 'frmAsignacionDestinatarios.cbRegion' ,aCombo, []);\r      set_combo( 'frmAsignacionDestinatarios.cbZona' ,aCombo, []);\r      set_combo( 'frmAsignacionDestinatarios.cbSeccion' ,aCombo, []);\r      set_combo( 'frmAsignacionDestinatarios.cbTerritorio' ,aCombo, []);\r   }\r\rfunction vaciarCombos2(){\r      var aCombo = new Array(new Array(\"\",\"\"));\r          \r      set_combo( 'frmAsignacionDestinatarios.cbZona' ,aCombo, []);\r      set_combo( 'frmAsignacionDestinatarios.cbSeccion' ,aCombo, []);\r      set_combo( 'frmAsignacionDestinatarios.cbTerritorio' ,aCombo, []);\r   }\r\rfunction vaciarCombos3(){\r      var aCombo = new Array(new Array(\"\",\"\"));\r           \r      set_combo( 'frmAsignacionDestinatarios.cbSeccion' ,aCombo, []);\r      set_combo( 'frmAsignacionDestinatarios.cbTerritorio' ,aCombo, []);\r   }\r\rfunction vaciarCombos4(){\r      var aCombo = new Array(new Array(\"\",\"\"));\r\r      set_combo( 'frmAsignacionDestinatarios.cbTerritorio' ,aCombo, []);\r   }\r\r   function recargaListaUnidades(){\r   \r      var datosLista = get('frmAsignacionDestinatarios.hValoresLista');\r      \r      if(datosLista != ''){\r        var primerPars  = datosLista.split('#');\r\r        for (var i=0; i< primerPars.length; i++){\r           var segundoPars = primerPars[i].split('|');\r                      \r           var lineaLista = new Array();\r\r           lineaLista[0] = segundoPars[0];\r           lineaLista[1] = segundoPars[1] ;\r           lineaLista[2] = segundoPars[2] ;\r           lineaLista[3] = segundoPars[3];  \r           lineaLista[4] = segundoPars[4];\r\r\r           if(segundoPars[5] != 'null'){\r              lineaLista[5] = segundoPars[5];\r           }else{\r              lineaLista[5] = '';           \r           }\r\r           if(segundoPars[6] != 'null'){\r              lineaLista[6] = segundoPars[6];\r           }else{\r              lineaLista[6] = '';           \r           } \r\r           if(segundoPars[7] != 'null'){\r              lineaLista[7] = segundoPars[7];\r           }else{\r              lineaLista[7] = '';           \r           }\r\r           if(segundoPars[8] != 'null'){\r              lineaLista[8] = segundoPars[8];\r           }else{\r              lineaLista[8] = '';           \r           } \r  \r\r           listado1.insertar(lineaLista);\r           listado1.repinta();\r                                                      \r        }\r      }\r   }\r\r   \r"));
      ((Element)v.get(5)).appendChild((Text)v.get(6));

      /* Termina nodo Texto:6   */
      /* Termina nodo:5   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cbMarca2" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("group","grupo1" );
      ((Element)v.get(8)).setAttribute("cod","6" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","cbCanal" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("group","grupo1" );
      ((Element)v.get(9)).setAttribute("cod","7" );
      ((Element)v.get(7)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","cbRegion" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("group","grupo1" );
      ((Element)v.get(10)).setAttribute("cod","109" );
      ((Element)v.get(7)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","cbTipoCliente" );
      ((Element)v.get(11)).setAttribute("required","true" );
      ((Element)v.get(11)).setAttribute("cod","393" );
      ((Element)v.get(11)).setAttribute("group","grupo2" );
      ((Element)v.get(7)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","cbMarca4" );
      ((Element)v.get(12)).setAttribute("required","true" );
      ((Element)v.get(12)).setAttribute("cod","6" );
      ((Element)v.get(12)).setAttribute("group","grupo2" );
      ((Element)v.get(7)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","txtCodigoVenta" );
      ((Element)v.get(13)).setAttribute("required","true" );
      ((Element)v.get(13)).setAttribute("cod","336" );
      ((Element)v.get(13)).setAttribute("group","grupo2" );
      ((Element)v.get(7)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */
      /* Termina nodo:7   */

      /* Empieza nodo:14 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(14)).setAttribute("nombre","frmAsignacionDestinatarios" );
      ((Element)v.get(14)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(14));

      /* Empieza nodo:15 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","accion" );
      ((Element)v.get(15)).setAttribute("valor","S" );
      ((Element)v.get(14)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hUnidadesAdministrativas" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hTipoCliente" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hMarca" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hCodigoVenta" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hGeneracionPedido" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","oidMensaje" );
      ((Element)v.get(22)).setAttribute("valor","S" );
      ((Element)v.get(14)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","oidTipoMensaje" );
      ((Element)v.get(23)).setAttribute("valor","S" );
      ((Element)v.get(14)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","unidadAdministrativa" );
      ((Element)v.get(24)).setAttribute("valor","S" );
      ((Element)v.get(14)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","tipoCliente" );
      ((Element)v.get(25)).setAttribute("valor","S" );
      ((Element)v.get(14)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","marca" );
      ((Element)v.get(26)).setAttribute("valor","S" );
      ((Element)v.get(14)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","codigoVenta" );
      ((Element)v.get(27)).setAttribute("valor","S" );
      ((Element)v.get(14)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","programa" );
      ((Element)v.get(28)).setAttribute("valor","S" );
      ((Element)v.get(14)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","consultoras" );
      ((Element)v.get(29)).setAttribute("valor","S" );
      ((Element)v.get(14)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hModulo" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","hCodMensaje" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","hTipoMensaje" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","hDescripcion" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","hProceso" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","hProgramaAsociado" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","hGenDatos" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","hBloqueGrupo" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","hPermanencia" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","hDesde" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","hHasta" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","hTipoPeriodo" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","hPeriodoDesde" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 14   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","hPeriodoHasta" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","hTextoFijoYDatosVariables" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","hNVariable" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","hAsignacionDestinatario" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","hAsigDest" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","hRegion" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","hSubtipo" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","hFlagUnidadesAdministrativas" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","hFlagTipoCliente" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","hFlagMarca" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","hFlagCodigoVenta" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(54)).setAttribute("nombre","hFlagGeneracionPedido" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(55)).setAttribute("nombre","hZona" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(56)).setAttribute("nombre","hVolver" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(57)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(58)).setAttribute("nombre","hNivel" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(59)).setAttribute("nombre","hNivelTipificacion" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(60)).setAttribute("nombre","oidPais" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(61)).setAttribute("nombre","seleccionRegion" );
      ((Element)v.get(61)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(62)).setAttribute("nombre","seleccionZona" );
      ((Element)v.get(62)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(63)).setAttribute("nombre","seleccionSeccion" );
      ((Element)v.get(63)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(64)).setAttribute("nombre","seleccionTerritorio" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */

      /* Empieza nodo:65 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(65)).setAttribute("nombre","seleccionTipoCliente" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(65)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */

      /* Empieza nodo:66 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(66)).setAttribute("nombre","seleccionSubtipoCliente" );
      ((Element)v.get(66)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(67)).setAttribute("nombre","seleccionTipoClasificacion" );
      ((Element)v.get(67)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */

      /* Empieza nodo:68 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(68)).setAttribute("nombre","seleccionClasificacion" );
      ((Element)v.get(68)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */

      /* Empieza nodo:69 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(69)).setAttribute("nombre","hSeleccionRegion" );
      ((Element)v.get(69)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */

      /* Empieza nodo:70 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(70)).setAttribute("nombre","hSeleccionZona" );
      ((Element)v.get(70)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(71)).setAttribute("nombre","hSeleccionSeccion" );
      ((Element)v.get(71)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */

      /* Empieza nodo:72 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(72)).setAttribute("nombre","hSeleccionTerritorio" );
      ((Element)v.get(72)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */

      /* Empieza nodo:73 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(73)).setAttribute("nombre","hSeleccionTipoCliente" );
      ((Element)v.get(73)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */

      /* Empieza nodo:74 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(74)).setAttribute("nombre","hSeleccionSubtipoCliente" );
      ((Element)v.get(74)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */

      /* Empieza nodo:75 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(75)).setAttribute("nombre","hSeleccionTipoClasificacion" );
      ((Element)v.get(75)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */

      /* Empieza nodo:76 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(76)).setAttribute("nombre","hSeleccionClasificacion" );
      ((Element)v.get(76)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */

      /* Empieza nodo:77 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(77)).setAttribute("nombre","hMarcasSeleccionadas" );
      ((Element)v.get(77)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */

      /* Empieza nodo:78 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(78)).setAttribute("nombre","oidMensajeSeleccionado" );
      ((Element)v.get(78)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */

      /* Empieza nodo:79 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(79)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(79)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */

      /* Empieza nodo:80 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(80)).setAttribute("nombre","elementosSeleccionados" );
      ((Element)v.get(80)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */

      /* Empieza nodo:81 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(81)).setAttribute("nombre","hidListaUnidades" );
      ((Element)v.get(81)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */

      /* Empieza nodo:82 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(82)).setAttribute("nombre","hValoresLista" );
      ((Element)v.get(82)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(83)).setAttribute("nombre","marcaPorDefecto" );
      ((Element)v.get(83)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */

      /* Empieza nodo:84 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(84)).setAttribute("nombre","canalPorDefecto" );
      ((Element)v.get(84)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */

      /* Empieza nodo:85 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(85)).setAttribute("nombre","regionPorDefecto" );
      ((Element)v.get(85)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(86)).setAttribute("nombre","zonaPorDefecto" );
      ((Element)v.get(86)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(87)).setAttribute("nombre","seccionPorDefecto" );
      ((Element)v.get(87)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */

      /* Empieza nodo:88 / Elemento padre: 14   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(88)).setAttribute("nombre","terriPorDefecto" );
      ((Element)v.get(88)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */

      /* Empieza nodo:89 / Elemento padre: 14   */
      v.add(doc.createElement("table"));
      ((Element)v.get(89)).setAttribute("width","100%" );
      ((Element)v.get(89)).setAttribute("height","100%" );
      ((Element)v.get(89)).setAttribute("border","0" );
      ((Element)v.get(89)).setAttribute("align","center" );
      ((Element)v.get(89)).setAttribute("cellpadding","0" );
      ((Element)v.get(89)).setAttribute("cellspacing","0" );
      ((Element)v.get(89)).setAttribute("class","menu4" );
      ((Element)v.get(14)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).setAttribute("width","12" );
      ((Element)v.get(91)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(91)).setAttribute("class","menu5texto" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(92)).setAttribute("width","12" );
      ((Element)v.get(92)).setAttribute("height","35" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:93 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(93)).setAttribute("class","menu5texto" );
      ((Element)v.get(90)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(94)).setAttribute("src","b.gif" );
      ((Element)v.get(94)).setAttribute("width","8" );
      ((Element)v.get(94)).setAttribute("height","8" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:95 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).setAttribute("width","10" );
      ((Element)v.get(95)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(95)).setAttribute("class","menu5texto" );
      ((Element)v.get(90)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(96)).setAttribute("src","b.gif" );
      ((Element)v.get(96)).setAttribute("width","10" );
      ((Element)v.get(96)).setAttribute("height","8" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:97 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).setAttribute("width","92" );
      ((Element)v.get(97)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(97)).setAttribute("class","menu5texto" );
      ((Element)v.get(90)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("table"));
      ((Element)v.get(98)).setAttribute("width","75" );
      ((Element)v.get(98)).setAttribute("border","1" );
      ((Element)v.get(98)).setAttribute("align","center" );
      ((Element)v.get(98)).setAttribute("cellpadding","1" );
      ((Element)v.get(98)).setAttribute("cellspacing","0" );
      ((Element)v.get(98)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(99)).setAttribute("align","center" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(101)).setAttribute("nombre","lblUnidadAdministrativaP" );
      ((Element)v.get(101)).setAttribute("alto","13" );
      ((Element)v.get(101)).setAttribute("filas","1" );
      ((Element)v.get(101)).setAttribute("valor","" );
      ((Element)v.get(101)).setAttribute("id","pUnidadesAdministrativas" );
      ((Element)v.get(101)).setAttribute("cod","0043" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:102 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).setAttribute("width","10" );
      ((Element)v.get(102)).setAttribute("class","menu5texto" );
      ((Element)v.get(90)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).setAttribute("width","10" );
      ((Element)v.get(103)).setAttribute("height","8" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).setAttribute("width","20" );
      ((Element)v.get(104)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(104)).setAttribute("class","menu5texto" );
      ((Element)v.get(90)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("table"));
      ((Element)v.get(105)).setAttribute("width","75" );
      ((Element)v.get(105)).setAttribute("border","1" );
      ((Element)v.get(105)).setAttribute("align","center" );
      ((Element)v.get(105)).setAttribute("cellpadding","1" );
   }

   private void getXML450(Document doc) {
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
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(108)).setAttribute("nombre","lblTipoCLienteP" );
      ((Element)v.get(108)).setAttribute("alto","13" );
      ((Element)v.get(108)).setAttribute("filas","1" );
      ((Element)v.get(108)).setAttribute("valor","" );
      ((Element)v.get(108)).setAttribute("id","pTipoCliente" );
      ((Element)v.get(108)).setAttribute("cod","0068" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:109 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).setAttribute("width","10" );
      ((Element)v.get(109)).setAttribute("class","menu5texto" );
      ((Element)v.get(90)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(110)).setAttribute("src","b.gif" );
      ((Element)v.get(110)).setAttribute("width","10" );
      ((Element)v.get(110)).setAttribute("height","8" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:111 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).setAttribute("width","20" );
      ((Element)v.get(111)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(111)).setAttribute("class","menu5texto" );
      ((Element)v.get(90)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("table"));
      ((Element)v.get(112)).setAttribute("width","75" );
      ((Element)v.get(112)).setAttribute("border","1" );
      ((Element)v.get(112)).setAttribute("align","center" );
      ((Element)v.get(112)).setAttribute("cellpadding","1" );
      ((Element)v.get(112)).setAttribute("cellspacing","0" );
      ((Element)v.get(112)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(113)).setAttribute("align","center" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(115)).setAttribute("nombre","lblMarcaP" );
      ((Element)v.get(115)).setAttribute("alto","13" );
      ((Element)v.get(115)).setAttribute("filas","1" );
      ((Element)v.get(115)).setAttribute("valor","" );
      ((Element)v.get(115)).setAttribute("id","pMarca" );
      ((Element)v.get(115)).setAttribute("cod","0069" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:116 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).setAttribute("width","10" );
      ((Element)v.get(116)).setAttribute("class","menu5texto" );
      ((Element)v.get(90)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(117)).setAttribute("src","b.gif" );
      ((Element)v.get(117)).setAttribute("width","10" );
      ((Element)v.get(117)).setAttribute("height","8" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).setAttribute("width","20" );
      ((Element)v.get(118)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(118)).setAttribute("class","menu5texto" );
      ((Element)v.get(90)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("table"));
      ((Element)v.get(119)).setAttribute("width","75" );
      ((Element)v.get(119)).setAttribute("border","1" );
      ((Element)v.get(119)).setAttribute("align","center" );
      ((Element)v.get(119)).setAttribute("cellpadding","1" );
      ((Element)v.get(119)).setAttribute("cellspacing","0" );
      ((Element)v.get(119)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(120)).setAttribute("align","center" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("td"));
      ((Element)v.get(121)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(122)).setAttribute("nombre","lblCodigoVentaP" );
      ((Element)v.get(122)).setAttribute("alto","13" );
      ((Element)v.get(122)).setAttribute("filas","1" );
      ((Element)v.get(122)).setAttribute("valor","" );
      ((Element)v.get(122)).setAttribute("id","pCodigoVenta" );
      ((Element)v.get(122)).setAttribute("cod","0070" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:123 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(123)).setAttribute("width","16" );
      ((Element)v.get(123)).setAttribute("class","menu5texto" );
      ((Element)v.get(90)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(124)).setAttribute("src","b.gif" );
      ((Element)v.get(124)).setAttribute("width","12" );
      ((Element)v.get(124)).setAttribute("height","8" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:125 / Elemento padre: 14   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(125)).setAttribute("nombre","camposBusqueda2" );
      ((Element)v.get(125)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(14)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("table"));
      ((Element)v.get(126)).setAttribute("width","100%" );
      ((Element)v.get(126)).setAttribute("border","0" );
      ((Element)v.get(126)).setAttribute("cellspacing","0" );
      ((Element)v.get(126)).setAttribute("cellpadding","0" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).setAttribute("width","12" );
      ((Element)v.get(128)).setAttribute("align","center" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(129)).setAttribute("src","b.gif" );
      ((Element)v.get(129)).setAttribute("width","12" );
      ((Element)v.get(129)).setAttribute("height","12" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:130 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).setAttribute("width","750" );
      ((Element)v.get(127)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(131)).setAttribute("src","b.gif" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:132 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(132)).setAttribute("width","12" );
      ((Element)v.get(127)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(133)).setAttribute("src","b.gif" );
      ((Element)v.get(133)).setAttribute("width","12" );
      ((Element)v.get(133)).setAttribute("height","1" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:127   */

      /* Empieza nodo:134 / Elemento padre: 126   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(126)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(136)).setAttribute("src","b.gif" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:137 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(137)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(139)).setAttribute("class","legend" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(140)).setAttribute("nombre","lblUnidadesAdministrativas" );
      ((Element)v.get(140)).setAttribute("alto","13" );
      ((Element)v.get(140)).setAttribute("filas","1" );
      ((Element)v.get(140)).setAttribute("valor","" );
      ((Element)v.get(140)).setAttribute("id","legend" );
      ((Element)v.get(140)).setAttribute("cod","0043" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:141 / Elemento padre: 138   */
      v.add(doc.createElement("table"));
      ((Element)v.get(141)).setAttribute("width","100%" );
      ((Element)v.get(141)).setAttribute("border","0" );
      ((Element)v.get(141)).setAttribute("align","center" );
      ((Element)v.get(141)).setAttribute("cellspacing","0" );
      ((Element)v.get(141)).setAttribute("cellpadding","0" );
      ((Element)v.get(138)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("table"));
      ((Element)v.get(144)).setAttribute("width","100%" );
      ((Element)v.get(144)).setAttribute("align","left" );
      ((Element)v.get(144)).setAttribute("border","0" );
      ((Element)v.get(144)).setAttribute("cellspacing","0" );
      ((Element)v.get(144)).setAttribute("cellpadding","0" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(144)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).setAttribute("colspan","4" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(147)).setAttribute("src","b.gif" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(147)).setAttribute("width","8" );
      ((Element)v.get(147)).setAttribute("height","8" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */
      /* Termina nodo:145   */

      /* Empieza nodo:148 / Elemento padre: 144   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(144)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("td"));
      ((Element)v.get(148)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(150)).setAttribute("src","b.gif" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */

      /* Empieza nodo:151 / Elemento padre: 148   */
      v.add(doc.createElement("td"));
      ((Element)v.get(148)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(153)).setAttribute("class","legend" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(154)).setAttribute("nombre","lblDatosAnadir" );
      ((Element)v.get(154)).setAttribute("alto","13" );
      ((Element)v.get(154)).setAttribute("filas","1" );
      ((Element)v.get(154)).setAttribute("valor","" );
      ((Element)v.get(154)).setAttribute("id","legend" );
      ((Element)v.get(154)).setAttribute("cod","00280" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:155 / Elemento padre: 152   */
      v.add(doc.createElement("table"));
      ((Element)v.get(155)).setAttribute("width","100%" );
      ((Element)v.get(155)).setAttribute("border","0" );
      ((Element)v.get(155)).setAttribute("align","center" );
      ((Element)v.get(155)).setAttribute("cellspacing","0" );
      ((Element)v.get(155)).setAttribute("cellpadding","0" );
      ((Element)v.get(152)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(155)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("td"));
      ((Element)v.get(156)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("table"));
      ((Element)v.get(158)).setAttribute("width","707" );
      ((Element)v.get(158)).setAttribute("border","0" );
      ((Element)v.get(158)).setAttribute("align","left" );
      ((Element)v.get(158)).setAttribute("cellspacing","0" );
      ((Element)v.get(158)).setAttribute("cellpadding","0" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(158)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).setAttribute("colspan","4" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(161)).setAttribute("src","b.gif" );
      ((Element)v.get(161)).setAttribute("width","8" );
      ((Element)v.get(161)).setAttribute("height","8" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:162 / Elemento padre: 158   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(158)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(164)).setAttribute("src","b.gif" );
      ((Element)v.get(164)).setAttribute("width","8" );
      ((Element)v.get(164)).setAttribute("height","8" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:165 / Elemento padre: 162   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(166)).setAttribute("nombre","lblMarca2" );
      ((Element)v.get(166)).setAttribute("alto","13" );
      ((Element)v.get(166)).setAttribute("filas","1" );
      ((Element)v.get(166)).setAttribute("valor","" );
      ((Element)v.get(166)).setAttribute("id","datosTitle" );
      ((Element)v.get(166)).setAttribute("cod","6" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:167 / Elemento padre: 162   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(168)).setAttribute("src","b.gif" );
      ((Element)v.get(168)).setAttribute("width","25" );
      ((Element)v.get(168)).setAttribute("height","8" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */

      /* Empieza nodo:169 / Elemento padre: 162   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(170)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(170)).setAttribute("alto","13" );
      ((Element)v.get(170)).setAttribute("filas","1" );
      ((Element)v.get(170)).setAttribute("valor","" );
      ((Element)v.get(170)).setAttribute("id","datosTitle" );
      ((Element)v.get(170)).setAttribute("cod","7" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:171 / Elemento padre: 162   */
      v.add(doc.createElement("td"));
   }

   private void getXML720(Document doc) {
      ((Element)v.get(171)).setAttribute("width","100%" );
      ((Element)v.get(162)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(172)).setAttribute("src","b.gif" );
      ((Element)v.get(172)).setAttribute("width","8" );
      ((Element)v.get(172)).setAttribute("height","8" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */
      /* Termina nodo:162   */

      /* Empieza nodo:173 / Elemento padre: 158   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(158)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(173)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(175)).setAttribute("src","b.gif" );
      ((Element)v.get(175)).setAttribute("width","8" );
      ((Element)v.get(175)).setAttribute("height","8" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */

      /* Empieza nodo:176 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(173)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(177)).setAttribute("nombre","cbMarca2" );
      ((Element)v.get(177)).setAttribute("id","datosCampos" );
      ((Element)v.get(177)).setAttribute("size","1" );
      ((Element)v.get(177)).setAttribute("multiple","N" );
      ((Element)v.get(177)).setAttribute("req","S" );
      ((Element)v.get(177)).setAttribute("valorinicial","" );
      ((Element)v.get(177)).setAttribute("textoinicial","" );
      ((Element)v.get(177)).setAttribute("onchange","marcaOnChange();" );
      ((Element)v.get(177)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnAnadir')" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:179 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(173)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(180)).setAttribute("src","b.gif" );
      ((Element)v.get(180)).setAttribute("width","25" );
      ((Element)v.get(180)).setAttribute("height","8" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:181 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(181)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(173)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(182)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(182)).setAttribute("id","datosCampos" );
      ((Element)v.get(182)).setAttribute("size","1" );
      ((Element)v.get(182)).setAttribute("multiple","N" );
      ((Element)v.get(182)).setAttribute("req","S" );
      ((Element)v.get(182)).setAttribute("valorinicial","" );
      ((Element)v.get(182)).setAttribute("textoinicial","" );
      ((Element)v.get(182)).setAttribute("onchange","canalOnChange();" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(182)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:184 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(184)).setAttribute("width","100%" );
      ((Element)v.get(173)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(185)).setAttribute("src","b.gif" );
      ((Element)v.get(185)).setAttribute("width","8" );
      ((Element)v.get(185)).setAttribute("height","8" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:184   */
      /* Termina nodo:173   */

      /* Empieza nodo:186 / Elemento padre: 158   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(158)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("td"));
      ((Element)v.get(187)).setAttribute("colspan","4" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(188)).setAttribute("src","b.gif" );
      ((Element)v.get(188)).setAttribute("width","8" );
      ((Element)v.get(188)).setAttribute("height","8" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */
      /* Termina nodo:186   */
      /* Termina nodo:158   */
      /* Termina nodo:157   */
      /* Termina nodo:156   */

      /* Empieza nodo:189 / Elemento padre: 155   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(155)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("td"));
      ((Element)v.get(189)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("table"));
      ((Element)v.get(191)).setAttribute("width","707" );
      ((Element)v.get(191)).setAttribute("border","0" );
      ((Element)v.get(191)).setAttribute("align","left" );
      ((Element)v.get(191)).setAttribute("cellspacing","0" );
      ((Element)v.get(191)).setAttribute("cellpadding","0" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(191)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("td"));
      ((Element)v.get(192)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(194)).setAttribute("src","b.gif" );
      ((Element)v.get(194)).setAttribute("width","8" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(194)).setAttribute("height","8" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */

      /* Empieza nodo:195 / Elemento padre: 192   */
      v.add(doc.createElement("td"));
      ((Element)v.get(192)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(196)).setAttribute("nombre","lblRegion" );
      ((Element)v.get(196)).setAttribute("alto","13" );
      ((Element)v.get(196)).setAttribute("filas","1" );
      ((Element)v.get(196)).setAttribute("valor","" );
      ((Element)v.get(196)).setAttribute("id","datosTitle" );
      ((Element)v.get(196)).setAttribute("cod","109" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */

      /* Empieza nodo:197 / Elemento padre: 192   */
      v.add(doc.createElement("td"));
      ((Element)v.get(192)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(198)).setAttribute("src","b.gif" );
      ((Element)v.get(198)).setAttribute("width","25" );
      ((Element)v.get(198)).setAttribute("height","8" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */

      /* Empieza nodo:199 / Elemento padre: 192   */
      v.add(doc.createElement("td"));
      ((Element)v.get(192)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(200)).setAttribute("nombre","lblZona" );
      ((Element)v.get(200)).setAttribute("alto","13" );
      ((Element)v.get(200)).setAttribute("filas","1" );
      ((Element)v.get(200)).setAttribute("valor","" );
      ((Element)v.get(200)).setAttribute("id","datosTitle" );
      ((Element)v.get(200)).setAttribute("cod","143" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */

      /* Empieza nodo:201 / Elemento padre: 192   */
      v.add(doc.createElement("td"));
      ((Element)v.get(201)).setAttribute("width","100%" );
      ((Element)v.get(192)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(202)).setAttribute("src","b.gif" );
      ((Element)v.get(202)).setAttribute("width","8" );
      ((Element)v.get(202)).setAttribute("height","8" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:201   */
      /* Termina nodo:192   */

      /* Empieza nodo:203 / Elemento padre: 191   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(191)).appendChild((Element)v.get(203));

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
      ((Element)v.get(206)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(203)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(207)).setAttribute("nombre","cbRegion" );
      ((Element)v.get(207)).setAttribute("id","datosCampos" );
      ((Element)v.get(207)).setAttribute("size","1" );
      ((Element)v.get(207)).setAttribute("multiple","N" );
      ((Element)v.get(207)).setAttribute("req","S" );
      ((Element)v.get(207)).setAttribute("valorinicial","" );
      ((Element)v.get(207)).setAttribute("textoinicial","" );
      ((Element)v.get(207)).setAttribute("onchange","regionOnChange();" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:209 / Elemento padre: 203   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(210)).setAttribute("src","b.gif" );
      ((Element)v.get(210)).setAttribute("width","25" );
      ((Element)v.get(210)).setAttribute("height","8" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */
      /* Termina nodo:209   */

      /* Empieza nodo:211 / Elemento padre: 203   */
      v.add(doc.createElement("td"));
      ((Element)v.get(211)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(211)).setAttribute("valign","bottom" );
      ((Element)v.get(203)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(212)).setAttribute("nombre","cbZona" );
      ((Element)v.get(212)).setAttribute("id","datosCampos" );
      ((Element)v.get(212)).setAttribute("size","1" );
      ((Element)v.get(212)).setAttribute("multiple","N" );
      ((Element)v.get(212)).setAttribute("req","N" );
      ((Element)v.get(212)).setAttribute("valorinicial","" );
      ((Element)v.get(212)).setAttribute("textoinicial","" );
      ((Element)v.get(212)).setAttribute("onchange","zonaOnChange();" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:212   */
      /* Termina nodo:211   */

      /* Empieza nodo:214 / Elemento padre: 203   */
      v.add(doc.createElement("td"));
      ((Element)v.get(214)).setAttribute("width","100%" );
      ((Element)v.get(203)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(215)).setAttribute("src","b.gif" );
      ((Element)v.get(215)).setAttribute("width","8" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(215)).setAttribute("height","8" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:214   */
      /* Termina nodo:203   */

      /* Empieza nodo:216 / Elemento padre: 191   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(191)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(217)).setAttribute("colspan","4" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(218)).setAttribute("src","b.gif" );
      ((Element)v.get(218)).setAttribute("width","8" );
      ((Element)v.get(218)).setAttribute("height","8" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */
      /* Termina nodo:217   */
      /* Termina nodo:216   */
      /* Termina nodo:191   */
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:219 / Elemento padre: 155   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(155)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("td"));
      ((Element)v.get(219)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("table"));
      ((Element)v.get(221)).setAttribute("width","707" );
      ((Element)v.get(221)).setAttribute("border","0" );
      ((Element)v.get(221)).setAttribute("align","left" );
      ((Element)v.get(221)).setAttribute("cellspacing","0" );
      ((Element)v.get(221)).setAttribute("cellpadding","0" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(221)).appendChild((Element)v.get(222));

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
      ((Element)v.get(226)).setAttribute("nombre","lblSeccion" );
      ((Element)v.get(226)).setAttribute("alto","13" );
      ((Element)v.get(226)).setAttribute("filas","1" );
      ((Element)v.get(226)).setAttribute("valor","" );
      ((Element)v.get(226)).setAttribute("id","datosTitle" );
      ((Element)v.get(226)).setAttribute("cod","112" );
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
      ((Element)v.get(230)).setAttribute("nombre","lblTerritorio" );
      ((Element)v.get(230)).setAttribute("alto","13" );
      ((Element)v.get(230)).setAttribute("filas","1" );
      ((Element)v.get(230)).setAttribute("valor","" );
      ((Element)v.get(230)).setAttribute("id","datosTitle" );
      ((Element)v.get(230)).setAttribute("cod","126" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */

      /* Empieza nodo:231 / Elemento padre: 222   */
      v.add(doc.createElement("td"));
      ((Element)v.get(231)).setAttribute("width","100%" );
      ((Element)v.get(222)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(232)).setAttribute("src","b.gif" );
      ((Element)v.get(232)).setAttribute("width","8" );
      ((Element)v.get(232)).setAttribute("height","8" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:231   */
      /* Termina nodo:222   */

      /* Empieza nodo:233 / Elemento padre: 221   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(221)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("td"));
      ((Element)v.get(233)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(235)).setAttribute("src","b.gif" );
      ((Element)v.get(235)).setAttribute("width","8" );
      ((Element)v.get(235)).setAttribute("height","8" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:234   */

      /* Empieza nodo:236 / Elemento padre: 233   */
      v.add(doc.createElement("td"));
      ((Element)v.get(236)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(233)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(237)).setAttribute("nombre","cbSeccion" );
      ((Element)v.get(237)).setAttribute("id","datosCampos" );
      ((Element)v.get(237)).setAttribute("size","1" );
      ((Element)v.get(237)).setAttribute("multiple","N" );
      ((Element)v.get(237)).setAttribute("req","N" );
      ((Element)v.get(237)).setAttribute("valorinicial","" );
      ((Element)v.get(237)).setAttribute("textoinicial","" );
      ((Element)v.get(237)).setAttribute("onchange","seccionOnChange();" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("ROWSET"));
   }

   private void getXML990(Document doc) {
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:237   */
      /* Termina nodo:236   */

      /* Empieza nodo:239 / Elemento padre: 233   */
      v.add(doc.createElement("td"));
      ((Element)v.get(233)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(240)).setAttribute("src","b.gif" );
      ((Element)v.get(240)).setAttribute("width","25" );
      ((Element)v.get(240)).setAttribute("height","8" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:239   */

      /* Empieza nodo:241 / Elemento padre: 233   */
      v.add(doc.createElement("td"));
      ((Element)v.get(241)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(233)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(242)).setAttribute("nombre","cbTerritorio" );
      ((Element)v.get(242)).setAttribute("id","datosCampos" );
      ((Element)v.get(242)).setAttribute("size","1" );
      ((Element)v.get(242)).setAttribute("multiple","N" );
      ((Element)v.get(242)).setAttribute("req","N" );
      ((Element)v.get(242)).setAttribute("valorinicial","" );
      ((Element)v.get(242)).setAttribute("textoinicial","" );
      ((Element)v.get(242)).setAttribute("ontab","posicionarComboUnidadesAdministrativas( 'cbTerritorio', 'ontab');" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(242)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:242   */
      /* Termina nodo:241   */

      /* Empieza nodo:244 / Elemento padre: 233   */
      v.add(doc.createElement("td"));
      ((Element)v.get(244)).setAttribute("width","100%" );
      ((Element)v.get(233)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(245)).setAttribute("src","b.gif" );
      ((Element)v.get(245)).setAttribute("width","8" );
      ((Element)v.get(245)).setAttribute("height","8" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:244   */
      /* Termina nodo:233   */

      /* Empieza nodo:246 / Elemento padre: 221   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(221)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("td"));
      ((Element)v.get(247)).setAttribute("colspan","4" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(248)).setAttribute("src","b.gif" );
      ((Element)v.get(248)).setAttribute("width","8" );
      ((Element)v.get(248)).setAttribute("height","8" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */
      /* Termina nodo:247   */
      /* Termina nodo:246   */
      /* Termina nodo:221   */
      /* Termina nodo:220   */
      /* Termina nodo:219   */
      /* Termina nodo:155   */
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:249 / Elemento padre: 148   */
      v.add(doc.createElement("td"));
      ((Element)v.get(148)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(250)).setAttribute("src","b.gif" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */
      /* Termina nodo:249   */
      /* Termina nodo:148   */

      /* Empieza nodo:251 / Elemento padre: 144   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(144)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("td"));
      ((Element)v.get(251)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(253)).setAttribute("src","b.gif" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */
      /* Termina nodo:252   */

      /* Empieza nodo:254 / Elemento padre: 251   */
      v.add(doc.createElement("td"));
      ((Element)v.get(251)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(254)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("table"));
      ((Element)v.get(256)).setAttribute("width","100%" );
      ((Element)v.get(256)).setAttribute("border","0" );
      ((Element)v.get(256)).setAttribute("align","center" );
      ((Element)v.get(256)).setAttribute("cellspacing","0" );
      ((Element)v.get(256)).setAttribute("cellpadding","0" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(256)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("td"));
      ((Element)v.get(258)).setAttribute("class","botonera" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(259)).setAttribute("nombre","btnAnadir" );
      ((Element)v.get(259)).setAttribute("ID","botonContenido" );
      ((Element)v.get(259)).setAttribute("tipo","html" );
      ((Element)v.get(259)).setAttribute("accion","incluirUA();" );
      ((Element)v.get(259)).setAttribute("estado","false" );
      ((Element)v.get(259)).setAttribute("cod","404" );
      ((Element)v.get(259)).setAttribute("ontab","focaliza('frmAsignacionDestinatarios.cbMarca2')" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */
      /* Termina nodo:258   */
      /* Termina nodo:257   */
      /* Termina nodo:256   */
      /* Termina nodo:255   */
      /* Termina nodo:254   */

      /* Empieza nodo:260 / Elemento padre: 251   */
      v.add(doc.createElement("td"));
      ((Element)v.get(251)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(261)).setAttribute("src","b.gif" );
      ((Element)v.get(261)).setAttribute("width","8" );
      ((Element)v.get(261)).setAttribute("height","12" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */
      /* Termina nodo:260   */
      /* Termina nodo:251   */

      /* Empieza nodo:262 / Elemento padre: 144   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(144)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("td"));
      ((Element)v.get(263)).setAttribute("width","12" );
      ((Element)v.get(263)).setAttribute("align","center" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(262)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(264)).setAttribute("src","b.gif" );
      ((Element)v.get(264)).setAttribute("width","12" );
      ((Element)v.get(264)).setAttribute("height","356" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */
      /* Termina nodo:263   */

      /* Empieza nodo:265 / Elemento padre: 262   */
      v.add(doc.createElement("td"));
      ((Element)v.get(265)).setAttribute("width","756" );
      ((Element)v.get(262)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(266)).setAttribute("src","b.gif" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */
      /* Termina nodo:265   */

      /* Empieza nodo:267 / Elemento padre: 262   */
      v.add(doc.createElement("td"));
      ((Element)v.get(267)).setAttribute("width","12" );
      ((Element)v.get(262)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(268)).setAttribute("src","b.gif" );
      ((Element)v.get(268)).setAttribute("width","12" );
      ((Element)v.get(268)).setAttribute("height","1" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */
      /* Termina nodo:267   */
      /* Termina nodo:262   */
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:269 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(270)).setAttribute("src","b.gif" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */
      /* Termina nodo:269   */
      /* Termina nodo:134   */

      /* Empieza nodo:271 / Elemento padre: 126   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(126)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("td"));
      ((Element)v.get(272)).setAttribute("width","12" );
      ((Element)v.get(272)).setAttribute("align","center" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(273)).setAttribute("src","b.gif" );
      ((Element)v.get(273)).setAttribute("width","12" );
      ((Element)v.get(273)).setAttribute("height","12" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */
      /* Termina nodo:272   */

      /* Empieza nodo:274 / Elemento padre: 271   */
      v.add(doc.createElement("td"));
      ((Element)v.get(274)).setAttribute("width","756" );
      ((Element)v.get(271)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(275)).setAttribute("src","b.gif" );
      ((Element)v.get(274)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */
      /* Termina nodo:274   */

      /* Empieza nodo:276 / Elemento padre: 271   */
      v.add(doc.createElement("td"));
      ((Element)v.get(276)).setAttribute("width","12" );
      ((Element)v.get(271)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(277)).setAttribute("src","b.gif" );
      ((Element)v.get(277)).setAttribute("width","12" );
      ((Element)v.get(277)).setAttribute("height","1" );
      ((Element)v.get(276)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */
      /* Termina nodo:276   */
      /* Termina nodo:271   */
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:278 / Elemento padre: 14   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(278)).setAttribute("nombre","listado1" );
      ((Element)v.get(278)).setAttribute("ancho","711" );
      ((Element)v.get(278)).setAttribute("alto","317" );
      ((Element)v.get(278)).setAttribute("x","26" );
      ((Element)v.get(278)).setAttribute("y","260" );
      ((Element)v.get(278)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(278)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(14)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(279)).setAttribute("precarga","S" );
      ((Element)v.get(279)).setAttribute("conROver","S" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(280)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(280)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(280)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(280)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(279)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */

      /* Empieza nodo:281 / Elemento padre: 279   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(281)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(281)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(281)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(281)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(279)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */

      /* Empieza nodo:282 / Elemento padre: 279   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(282)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(282)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(279)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */
      /* Termina nodo:279   */

      /* Empieza nodo:283 / Elemento padre: 278   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(278)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(284)).setAttribute("borde","1" );
      ((Element)v.get(284)).setAttribute("horizDatos","1" );
      ((Element)v.get(284)).setAttribute("horizCabecera","1" );
      ((Element)v.get(284)).setAttribute("vertical","0" );
      ((Element)v.get(284)).setAttribute("horizTitulo","1" );
      ((Element)v.get(284)).setAttribute("horizBase","1" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */

      /* Empieza nodo:285 / Elemento padre: 283   */
      v.add(doc.createElement("COLOR"));
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(285)).setAttribute("borde","#999999" );
      ((Element)v.get(285)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(285)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(285)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(285)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(285)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(285)).setAttribute("horizBase","#999999" );
      ((Element)v.get(283)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */
      /* Termina nodo:283   */

      /* Empieza nodo:286 / Elemento padre: 278   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(286)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(286)).setAttribute("alto","22" );
      ((Element)v.get(286)).setAttribute("imgFondo","" );
      ((Element)v.get(286)).setAttribute("cod","00622" );
      ((Element)v.get(286)).setAttribute("ID","datosTitle" );
      ((Element)v.get(278)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */

      /* Empieza nodo:287 / Elemento padre: 278   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(287)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(287)).setAttribute("alto","22" );
      ((Element)v.get(287)).setAttribute("imgFondo","" );
      ((Element)v.get(278)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */

      /* Empieza nodo:288 / Elemento padre: 278   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(288)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(288)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(288)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(288)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(288)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(288)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(278)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(289)).setAttribute("ancho","50" );
      ((Element)v.get(289)).setAttribute("minimizable","S" );
      ((Element)v.get(289)).setAttribute("minimizada","N" );
      ((Element)v.get(288)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */

      /* Empieza nodo:290 / Elemento padre: 288   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(290)).setAttribute("ancho","50" );
      ((Element)v.get(290)).setAttribute("minimizable","S" );
      ((Element)v.get(290)).setAttribute("minimizada","N" );
      ((Element)v.get(288)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */

      /* Empieza nodo:291 / Elemento padre: 288   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(291)).setAttribute("ancho","50" );
      ((Element)v.get(291)).setAttribute("minimizable","S" );
      ((Element)v.get(291)).setAttribute("minimizada","N" );
      ((Element)v.get(288)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */

      /* Empieza nodo:292 / Elemento padre: 288   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(292)).setAttribute("ancho","50" );
      ((Element)v.get(292)).setAttribute("minimizable","S" );
      ((Element)v.get(292)).setAttribute("minimizada","N" );
      ((Element)v.get(288)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */

      /* Empieza nodo:293 / Elemento padre: 288   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(293)).setAttribute("ancho","30" );
      ((Element)v.get(293)).setAttribute("minimizable","S" );
      ((Element)v.get(293)).setAttribute("minimizada","N" );
      ((Element)v.get(293)).setAttribute("oculta","S" );
      ((Element)v.get(288)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */

      /* Empieza nodo:294 / Elemento padre: 288   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(294)).setAttribute("ancho","30" );
      ((Element)v.get(294)).setAttribute("minimizable","S" );
      ((Element)v.get(294)).setAttribute("minimizada","N" );
      ((Element)v.get(294)).setAttribute("oculta","S" );
      ((Element)v.get(288)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */

      /* Empieza nodo:295 / Elemento padre: 288   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(295)).setAttribute("ancho","30" );
      ((Element)v.get(295)).setAttribute("minimizable","S" );
      ((Element)v.get(295)).setAttribute("minimizada","N" );
      ((Element)v.get(295)).setAttribute("oculta","S" );
      ((Element)v.get(288)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */

      /* Empieza nodo:296 / Elemento padre: 288   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(296)).setAttribute("ancho","30" );
      ((Element)v.get(296)).setAttribute("minimizable","S" );
      ((Element)v.get(296)).setAttribute("minimizada","N" );
      ((Element)v.get(296)).setAttribute("oculta","S" );
      ((Element)v.get(288)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */
      /* Termina nodo:288   */

      /* Empieza nodo:297 / Elemento padre: 278   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(297)).setAttribute("alto","20" );
      ((Element)v.get(297)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(297)).setAttribute("imgFondo","" );
      ((Element)v.get(297)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(278)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(298)).setAttribute("colFondo","" );
      ((Element)v.get(298)).setAttribute("ID","EstCab" );
      ((Element)v.get(298)).setAttribute("cod","109" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));

      /* Elemento padre:298 / Elemento actual: 299   */
      v.add(doc.createTextNode("Región"));
      ((Element)v.get(298)).appendChild((Text)v.get(299));

      /* Termina nodo Texto:299   */
      /* Termina nodo:298   */

      /* Empieza nodo:300 / Elemento padre: 297   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(300)).setAttribute("colFondo","" );
      ((Element)v.get(300)).setAttribute("ID","EstCab" );
      ((Element)v.get(300)).setAttribute("cod","143" );
      ((Element)v.get(297)).appendChild((Element)v.get(300));

      /* Elemento padre:300 / Elemento actual: 301   */
   }

   private void getXML1260(Document doc) {
      v.add(doc.createTextNode("Zona"));
      ((Element)v.get(300)).appendChild((Text)v.get(301));

      /* Termina nodo Texto:301   */
      /* Termina nodo:300   */

      /* Empieza nodo:302 / Elemento padre: 297   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(302)).setAttribute("colFondo","" );
      ((Element)v.get(302)).setAttribute("ID","EstCab" );
      ((Element)v.get(302)).setAttribute("cod","112" );
      ((Element)v.get(297)).appendChild((Element)v.get(302));

      /* Elemento padre:302 / Elemento actual: 303   */
      v.add(doc.createTextNode("Sección"));
      ((Element)v.get(302)).appendChild((Text)v.get(303));

      /* Termina nodo Texto:303   */
      /* Termina nodo:302   */

      /* Empieza nodo:304 / Elemento padre: 297   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(304)).setAttribute("colFondo","" );
      ((Element)v.get(304)).setAttribute("ID","EstCab" );
      ((Element)v.get(304)).setAttribute("cod","126" );
      ((Element)v.get(297)).appendChild((Element)v.get(304));

      /* Elemento padre:304 / Elemento actual: 305   */
      v.add(doc.createTextNode("Terriorio"));
      ((Element)v.get(304)).appendChild((Text)v.get(305));

      /* Termina nodo Texto:305   */
      /* Termina nodo:304   */

      /* Empieza nodo:306 / Elemento padre: 297   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(306)).setAttribute("colFondo","" );
      ((Element)v.get(306)).setAttribute("ID","EstCab" );
      ((Element)v.get(297)).appendChild((Element)v.get(306));

      /* Elemento padre:306 / Elemento actual: 307   */
      v.add(doc.createTextNode("oidRegión"));
      ((Element)v.get(306)).appendChild((Text)v.get(307));

      /* Termina nodo Texto:307   */
      /* Termina nodo:306   */

      /* Empieza nodo:308 / Elemento padre: 297   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(308)).setAttribute("colFondo","" );
      ((Element)v.get(308)).setAttribute("ID","EstCab" );
      ((Element)v.get(297)).appendChild((Element)v.get(308));

      /* Elemento padre:308 / Elemento actual: 309   */
      v.add(doc.createTextNode("oidZona"));
      ((Element)v.get(308)).appendChild((Text)v.get(309));

      /* Termina nodo Texto:309   */
      /* Termina nodo:308   */

      /* Empieza nodo:310 / Elemento padre: 297   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(310)).setAttribute("colFondo","" );
      ((Element)v.get(310)).setAttribute("ID","EstCab" );
      ((Element)v.get(297)).appendChild((Element)v.get(310));

      /* Elemento padre:310 / Elemento actual: 311   */
      v.add(doc.createTextNode("oidSección"));
      ((Element)v.get(310)).appendChild((Text)v.get(311));

      /* Termina nodo Texto:311   */
      /* Termina nodo:310   */

      /* Empieza nodo:312 / Elemento padre: 297   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(312)).setAttribute("colFondo","" );
      ((Element)v.get(312)).setAttribute("ID","EstCab" );
      ((Element)v.get(297)).appendChild((Element)v.get(312));

      /* Elemento padre:312 / Elemento actual: 313   */
      v.add(doc.createTextNode("oidTerriorio"));
      ((Element)v.get(312)).appendChild((Text)v.get(313));

      /* Termina nodo Texto:313   */
      /* Termina nodo:312   */
      /* Termina nodo:297   */

      /* Empieza nodo:314 / Elemento padre: 278   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(314)).setAttribute("alto","22" );
      ((Element)v.get(314)).setAttribute("accion","" );
      ((Element)v.get(314)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(314)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(314)).setAttribute("maxSel","-1" );
      ((Element)v.get(314)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(314)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(314)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(314)).setAttribute("onLoad","" );
      ((Element)v.get(314)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(278)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(315)).setAttribute("tipo","texto" );
      ((Element)v.get(315)).setAttribute("ID","EstDat2" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */

      /* Empieza nodo:316 / Elemento padre: 314   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(316)).setAttribute("tipo","texto" );
      ((Element)v.get(316)).setAttribute("ID","EstDat" );
      ((Element)v.get(314)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */

      /* Empieza nodo:317 / Elemento padre: 314   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(317)).setAttribute("tipo","texto" );
      ((Element)v.get(317)).setAttribute("ID","EstDat2" );
      ((Element)v.get(314)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */

      /* Empieza nodo:318 / Elemento padre: 314   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(318)).setAttribute("tipo","texto" );
      ((Element)v.get(318)).setAttribute("ID","EstDat" );
      ((Element)v.get(314)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */

      /* Empieza nodo:319 / Elemento padre: 314   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(319)).setAttribute("tipo","texto" );
      ((Element)v.get(319)).setAttribute("ID","EstDat2" );
      ((Element)v.get(314)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */

      /* Empieza nodo:320 / Elemento padre: 314   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(320)).setAttribute("tipo","texto" );
      ((Element)v.get(320)).setAttribute("ID","EstDat" );
      ((Element)v.get(314)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */

      /* Empieza nodo:321 / Elemento padre: 314   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(321)).setAttribute("tipo","texto" );
      ((Element)v.get(321)).setAttribute("ID","EstDat2" );
      ((Element)v.get(314)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */

      /* Empieza nodo:322 / Elemento padre: 314   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(322)).setAttribute("tipo","texto" );
      ((Element)v.get(322)).setAttribute("ID","EstDat" );
      ((Element)v.get(314)).appendChild((Element)v.get(322));
      /* Termina nodo:322   */
      /* Termina nodo:314   */

      /* Empieza nodo:323 / Elemento padre: 278   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(278)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */

      /* Empieza nodo:324 / Elemento padre: 278   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(324)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(324)).setAttribute("ancho","711" );
      ((Element)v.get(324)).setAttribute("sep","$" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(324)).setAttribute("x","26" );
      ((Element)v.get(324)).setAttribute("class","botonera" );
      ((Element)v.get(324)).setAttribute("y","554" );
      ((Element)v.get(324)).setAttribute("control","|" );
      ((Element)v.get(324)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(324)).setAttribute("rowset","" );
      ((Element)v.get(324)).setAttribute("cargainicial","N" );
      ((Element)v.get(278)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(325)).setAttribute("nombre","ret1" );
      ((Element)v.get(325)).setAttribute("x","51" );
      ((Element)v.get(325)).setAttribute("y","558" );
      ((Element)v.get(325)).setAttribute("ID","botonContenido" );
      ((Element)v.get(325)).setAttribute("img","retroceder_on" );
      ((Element)v.get(325)).setAttribute("tipo","0" );
      ((Element)v.get(325)).setAttribute("estado","false" );
      ((Element)v.get(325)).setAttribute("alt","" );
      ((Element)v.get(325)).setAttribute("codigo","" );
      ((Element)v.get(325)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */

      /* Empieza nodo:326 / Elemento padre: 324   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(326)).setAttribute("nombre","ava1" );
      ((Element)v.get(326)).setAttribute("x","66" );
      ((Element)v.get(326)).setAttribute("y","558" );
      ((Element)v.get(326)).setAttribute("ID","botonContenido" );
      ((Element)v.get(326)).setAttribute("img","avanzar_on" );
      ((Element)v.get(326)).setAttribute("tipo","0" );
      ((Element)v.get(326)).setAttribute("estado","false" );
      ((Element)v.get(326)).setAttribute("alt","" );
      ((Element)v.get(326)).setAttribute("codigo","" );
      ((Element)v.get(326)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(324)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */
      /* Termina nodo:324   */
      /* Termina nodo:278   */

      /* Empieza nodo:327 / Elemento padre: 14   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(327)).setAttribute("nombre","primera1" );
      ((Element)v.get(327)).setAttribute("x","34" );
      ((Element)v.get(327)).setAttribute("y","558" );
      ((Element)v.get(327)).setAttribute("ID","botonContenido" );
      ((Element)v.get(327)).setAttribute("img","primera_on" );
      ((Element)v.get(327)).setAttribute("tipo","0" );
      ((Element)v.get(327)).setAttribute("estado","false" );
      ((Element)v.get(327)).setAttribute("alt","" );
      ((Element)v.get(327)).setAttribute("codigo","" );
      ((Element)v.get(327)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(14)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */

      /* Empieza nodo:328 / Elemento padre: 14   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(328)).setAttribute("nombre","separa" );
      ((Element)v.get(328)).setAttribute("x","73" );
      ((Element)v.get(328)).setAttribute("y","554" );
      ((Element)v.get(328)).setAttribute("ID","botonContenido" );
      ((Element)v.get(328)).setAttribute("img","separa_base" );
      ((Element)v.get(328)).setAttribute("tipo","0" );
      ((Element)v.get(328)).setAttribute("estado","false" );
      ((Element)v.get(328)).setAttribute("alt","" );
      ((Element)v.get(328)).setAttribute("codigo","" );
      ((Element)v.get(328)).setAttribute("accion","" );
      ((Element)v.get(14)).appendChild((Element)v.get(328));
      /* Termina nodo:328   */

      /* Empieza nodo:329 / Elemento padre: 14   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(329)).setAttribute("nombre","btnEliminar" );
      ((Element)v.get(329)).setAttribute("x","27" );
      ((Element)v.get(329)).setAttribute("y","555" );
      ((Element)v.get(329)).setAttribute("ID","botonContenido" );
      ((Element)v.get(329)).setAttribute("tipo","html" );
      ((Element)v.get(329)).setAttribute("estado","false" );
      ((Element)v.get(329)).setAttribute("cod","1254" );
      ((Element)v.get(329)).setAttribute("accion","eliminarUA();" );
      ((Element)v.get(14)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */

      /* Empieza nodo:330 / Elemento padre: 14   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(330)).setAttribute("nombre","camposBusqueda3" );
      ((Element)v.get(330)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(14)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("table"));
      ((Element)v.get(331)).setAttribute("width","100%" );
      ((Element)v.get(331)).setAttribute("border","0" );
      ((Element)v.get(331)).setAttribute("cellspacing","0" );
      ((Element)v.get(331)).setAttribute("cellpadding","0" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(331)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("td"));
      ((Element)v.get(333)).setAttribute("width","12" );
      ((Element)v.get(333)).setAttribute("align","center" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(334)).setAttribute("src","b.gif" );
      ((Element)v.get(334)).setAttribute("width","12" );
      ((Element)v.get(334)).setAttribute("height","12" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */
      /* Termina nodo:333   */

      /* Empieza nodo:335 / Elemento padre: 332   */
      v.add(doc.createElement("td"));
      ((Element)v.get(335)).setAttribute("width","750" );
      ((Element)v.get(332)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
   }

   private void getXML1440(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(336)).setAttribute("src","b.gif" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */
      /* Termina nodo:335   */

      /* Empieza nodo:337 / Elemento padre: 332   */
      v.add(doc.createElement("td"));
      ((Element)v.get(337)).setAttribute("width","12" );
      ((Element)v.get(332)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(338)).setAttribute("src","b.gif" );
      ((Element)v.get(338)).setAttribute("width","12" );
      ((Element)v.get(338)).setAttribute("height","1" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */
      /* Termina nodo:337   */
      /* Termina nodo:332   */

      /* Empieza nodo:339 / Elemento padre: 331   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(331)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("td"));
      ((Element)v.get(339)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(341)).setAttribute("src","b.gif" );
      ((Element)v.get(340)).appendChild((Element)v.get(341));
      /* Termina nodo:341   */
      /* Termina nodo:340   */

      /* Empieza nodo:342 / Elemento padre: 339   */
      v.add(doc.createElement("td"));
      ((Element)v.get(339)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(342)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(344)).setAttribute("class","legend" );
      ((Element)v.get(343)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(345)).setAttribute("nombre","lblTipoCliente" );
      ((Element)v.get(345)).setAttribute("alto","13" );
      ((Element)v.get(345)).setAttribute("filas","1" );
      ((Element)v.get(345)).setAttribute("valor","" );
      ((Element)v.get(345)).setAttribute("id","legend" );
      ((Element)v.get(345)).setAttribute("cod","0068" );
      ((Element)v.get(344)).appendChild((Element)v.get(345));
      /* Termina nodo:345   */
      /* Termina nodo:344   */

      /* Empieza nodo:346 / Elemento padre: 343   */
      v.add(doc.createElement("table"));
      ((Element)v.get(346)).setAttribute("width","100%" );
      ((Element)v.get(346)).setAttribute("border","0" );
      ((Element)v.get(346)).setAttribute("align","center" );
      ((Element)v.get(346)).setAttribute("cellspacing","0" );
      ((Element)v.get(346)).setAttribute("cellpadding","0" );
      ((Element)v.get(343)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(346)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("td"));
      ((Element)v.get(347)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("table"));
      ((Element)v.get(349)).setAttribute("width","731" );
      ((Element)v.get(349)).setAttribute("border","0" );
      ((Element)v.get(349)).setAttribute("align","left" );
      ((Element)v.get(349)).setAttribute("cellspacing","0" );
      ((Element)v.get(349)).setAttribute("cellpadding","0" );
      ((Element)v.get(348)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(349)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("td"));
      ((Element)v.get(351)).setAttribute("colspan","8" );
      ((Element)v.get(350)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(352)).setAttribute("src","b.gif" );
      ((Element)v.get(352)).setAttribute("width","8" );
      ((Element)v.get(352)).setAttribute("height","8" );
      ((Element)v.get(351)).appendChild((Element)v.get(352));
      /* Termina nodo:352   */
      /* Termina nodo:351   */
      /* Termina nodo:350   */

      /* Empieza nodo:353 / Elemento padre: 349   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(349)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("td"));
      ((Element)v.get(353)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(355)).setAttribute("src","b.gif" );
      ((Element)v.get(355)).setAttribute("width","8" );
      ((Element)v.get(355)).setAttribute("height","8" );
      ((Element)v.get(354)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */
      /* Termina nodo:354   */

      /* Empieza nodo:356 / Elemento padre: 353   */
      v.add(doc.createElement("td"));
      ((Element)v.get(353)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(357)).setAttribute("nombre","lblTipo" );
      ((Element)v.get(357)).setAttribute("alto","13" );
      ((Element)v.get(357)).setAttribute("filas","1" );
      ((Element)v.get(357)).setAttribute("valor","" );
      ((Element)v.get(357)).setAttribute("id","datosTitle" );
      ((Element)v.get(357)).setAttribute("cod","393" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */
      /* Termina nodo:356   */

      /* Empieza nodo:358 / Elemento padre: 353   */
      v.add(doc.createElement("td"));
      ((Element)v.get(353)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(359)).setAttribute("src","b.gif" );
      ((Element)v.get(359)).setAttribute("width","25" );
      ((Element)v.get(359)).setAttribute("height","8" );
      ((Element)v.get(358)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */
      /* Termina nodo:358   */

      /* Empieza nodo:360 / Elemento padre: 353   */
      v.add(doc.createElement("td"));
      ((Element)v.get(353)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(361)).setAttribute("nombre","lblSubtipo" );
      ((Element)v.get(361)).setAttribute("alto","13" );
      ((Element)v.get(361)).setAttribute("filas","1" );
      ((Element)v.get(361)).setAttribute("valor","" );
      ((Element)v.get(361)).setAttribute("id","datosTitle" );
      ((Element)v.get(361)).setAttribute("cod","595" );
      ((Element)v.get(360)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */
      /* Termina nodo:360   */

      /* Empieza nodo:362 / Elemento padre: 353   */
      v.add(doc.createElement("td"));
      ((Element)v.get(362)).setAttribute("width","100%" );
      ((Element)v.get(353)).appendChild((Element)v.get(362));

      /* Empieza nodo:363 / Elemento padre: 362   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(363)).setAttribute("src","b.gif" );
      ((Element)v.get(363)).setAttribute("width","8" );
      ((Element)v.get(363)).setAttribute("height","8" );
      ((Element)v.get(362)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */
      /* Termina nodo:362   */
      /* Termina nodo:353   */

      /* Empieza nodo:364 / Elemento padre: 349   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(349)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("td"));
      ((Element)v.get(364)).appendChild((Element)v.get(365));

      /* Empieza nodo:366 / Elemento padre: 365   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(366)).setAttribute("src","b.gif" );
      ((Element)v.get(366)).setAttribute("width","8" );
      ((Element)v.get(366)).setAttribute("height","8" );
      ((Element)v.get(365)).appendChild((Element)v.get(366));
      /* Termina nodo:366   */
      /* Termina nodo:365   */

      /* Empieza nodo:367 / Elemento padre: 364   */
      v.add(doc.createElement("td"));
      ((Element)v.get(367)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(364)).appendChild((Element)v.get(367));

      /* Empieza nodo:368 / Elemento padre: 367   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(368)).setAttribute("nombre","cbTipoCliente" );
      ((Element)v.get(368)).setAttribute("id","datosCampos" );
      ((Element)v.get(368)).setAttribute("size","5" );
      ((Element)v.get(368)).setAttribute("multiple","S" );
      ((Element)v.get(368)).setAttribute("req","S" );
      ((Element)v.get(368)).setAttribute("valorinicial","" );
      ((Element)v.get(368)).setAttribute("textoinicial","" );
      ((Element)v.get(368)).setAttribute("onchange","cambioTipo();" );
      ((Element)v.get(368)).setAttribute("onshtab","posicionarComboTipoCliente('cbTipoCliente', 'onshtab');" );
      ((Element)v.get(367)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(368)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */
      /* Termina nodo:368   */
      /* Termina nodo:367   */

      /* Empieza nodo:370 / Elemento padre: 364   */
      v.add(doc.createElement("td"));
      ((Element)v.get(364)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(371)).setAttribute("src","b.gif" );
      ((Element)v.get(371)).setAttribute("width","25" );
      ((Element)v.get(371)).setAttribute("height","8" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */
      /* Termina nodo:370   */

      /* Empieza nodo:372 / Elemento padre: 364   */
      v.add(doc.createElement("td"));
      ((Element)v.get(364)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(373)).setAttribute("nombre","cbSubtipoCliente" );
      ((Element)v.get(373)).setAttribute("id","datosCampos" );
      ((Element)v.get(373)).setAttribute("size","5" );
      ((Element)v.get(373)).setAttribute("multiple","S" );
      ((Element)v.get(373)).setAttribute("req","N" );
      ((Element)v.get(373)).setAttribute("valorinicial","" );
      ((Element)v.get(373)).setAttribute("textoinicial","" );
      ((Element)v.get(373)).setAttribute("onchange","cambioSubtipo();" );
      ((Element)v.get(372)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(373)).appendChild((Element)v.get(374));
      /* Termina nodo:374   */
      /* Termina nodo:373   */
      /* Termina nodo:372   */

      /* Empieza nodo:375 / Elemento padre: 364   */
      v.add(doc.createElement("td"));
      ((Element)v.get(375)).setAttribute("width","100%" );
      ((Element)v.get(364)).appendChild((Element)v.get(375));

      /* Empieza nodo:376 / Elemento padre: 375   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(376)).setAttribute("src","b.gif" );
      ((Element)v.get(376)).setAttribute("width","8" );
      ((Element)v.get(376)).setAttribute("height","8" );
      ((Element)v.get(375)).appendChild((Element)v.get(376));
      /* Termina nodo:376   */
      /* Termina nodo:375   */
      /* Termina nodo:364   */

      /* Empieza nodo:377 / Elemento padre: 349   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(349)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("td"));
      ((Element)v.get(378)).setAttribute("colspan","9" );
      ((Element)v.get(377)).appendChild((Element)v.get(378));

      /* Empieza nodo:379 / Elemento padre: 378   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(379)).setAttribute("src","b.gif" );
      ((Element)v.get(379)).setAttribute("width","8" );
      ((Element)v.get(379)).setAttribute("height","8" );
      ((Element)v.get(378)).appendChild((Element)v.get(379));
      /* Termina nodo:379   */
      /* Termina nodo:378   */
      /* Termina nodo:377   */
      /* Termina nodo:349   */
      /* Termina nodo:348   */
      /* Termina nodo:347   */

      /* Empieza nodo:380 / Elemento padre: 346   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(346)).appendChild((Element)v.get(380));

      /* Empieza nodo:381 / Elemento padre: 380   */
      v.add(doc.createElement("td"));
      ((Element)v.get(380)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("table"));
      ((Element)v.get(382)).setAttribute("width","731" );
      ((Element)v.get(382)).setAttribute("border","0" );
      ((Element)v.get(382)).setAttribute("align","left" );
      ((Element)v.get(382)).setAttribute("cellspacing","0" );
      ((Element)v.get(382)).setAttribute("cellpadding","0" );
      ((Element)v.get(381)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
   }

   private void getXML1620(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(382)).appendChild((Element)v.get(383));

      /* Empieza nodo:384 / Elemento padre: 383   */
      v.add(doc.createElement("td"));
      ((Element)v.get(383)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(385)).setAttribute("src","b.gif" );
      ((Element)v.get(385)).setAttribute("width","8" );
      ((Element)v.get(385)).setAttribute("height","8" );
      ((Element)v.get(384)).appendChild((Element)v.get(385));
      /* Termina nodo:385   */
      /* Termina nodo:384   */

      /* Empieza nodo:386 / Elemento padre: 383   */
      v.add(doc.createElement("td"));
      ((Element)v.get(383)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(387)).setAttribute("nombre","lblTipoClasificacion" );
      ((Element)v.get(387)).setAttribute("alto","13" );
      ((Element)v.get(387)).setAttribute("filas","1" );
      ((Element)v.get(387)).setAttribute("valor","" );
      ((Element)v.get(387)).setAttribute("id","datosTitle" );
      ((Element)v.get(387)).setAttribute("cod","756" );
      ((Element)v.get(386)).appendChild((Element)v.get(387));
      /* Termina nodo:387   */
      /* Termina nodo:386   */

      /* Empieza nodo:388 / Elemento padre: 383   */
      v.add(doc.createElement("td"));
      ((Element)v.get(383)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(389)).setAttribute("src","b.gif" );
      ((Element)v.get(389)).setAttribute("width","25" );
      ((Element)v.get(389)).setAttribute("height","8" );
      ((Element)v.get(388)).appendChild((Element)v.get(389));
      /* Termina nodo:389   */
      /* Termina nodo:388   */

      /* Empieza nodo:390 / Elemento padre: 383   */
      v.add(doc.createElement("td"));
      ((Element)v.get(383)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(391)).setAttribute("nombre","lblClasificacion" );
      ((Element)v.get(391)).setAttribute("alto","13" );
      ((Element)v.get(391)).setAttribute("filas","1" );
      ((Element)v.get(391)).setAttribute("valor","" );
      ((Element)v.get(391)).setAttribute("id","datosTitle" );
      ((Element)v.get(391)).setAttribute("cod","550" );
      ((Element)v.get(390)).appendChild((Element)v.get(391));
      /* Termina nodo:391   */
      /* Termina nodo:390   */

      /* Empieza nodo:392 / Elemento padre: 383   */
      v.add(doc.createElement("td"));
      ((Element)v.get(392)).setAttribute("width","100%" );
      ((Element)v.get(383)).appendChild((Element)v.get(392));

      /* Empieza nodo:393 / Elemento padre: 392   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(393)).setAttribute("src","b.gif" );
      ((Element)v.get(393)).setAttribute("width","8" );
      ((Element)v.get(393)).setAttribute("height","8" );
      ((Element)v.get(392)).appendChild((Element)v.get(393));
      /* Termina nodo:393   */
      /* Termina nodo:392   */
      /* Termina nodo:383   */

      /* Empieza nodo:394 / Elemento padre: 382   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(382)).appendChild((Element)v.get(394));

      /* Empieza nodo:395 / Elemento padre: 394   */
      v.add(doc.createElement("td"));
      ((Element)v.get(394)).appendChild((Element)v.get(395));

      /* Empieza nodo:396 / Elemento padre: 395   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(396)).setAttribute("src","b.gif" );
      ((Element)v.get(396)).setAttribute("width","8" );
      ((Element)v.get(396)).setAttribute("height","8" );
      ((Element)v.get(395)).appendChild((Element)v.get(396));
      /* Termina nodo:396   */
      /* Termina nodo:395   */

      /* Empieza nodo:397 / Elemento padre: 394   */
      v.add(doc.createElement("td"));
      ((Element)v.get(394)).appendChild((Element)v.get(397));

      /* Empieza nodo:398 / Elemento padre: 397   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(398)).setAttribute("nombre","cbTipoClasificacion" );
      ((Element)v.get(398)).setAttribute("id","datosCampos" );
      ((Element)v.get(398)).setAttribute("size","5" );
      ((Element)v.get(398)).setAttribute("multiple","S" );
      ((Element)v.get(398)).setAttribute("req","N" );
      ((Element)v.get(398)).setAttribute("valorinicial","" );
      ((Element)v.get(398)).setAttribute("textoinicial","" );
      ((Element)v.get(398)).setAttribute("onchange","cambioTipoClasificacion();" );
      ((Element)v.get(397)).appendChild((Element)v.get(398));

      /* Empieza nodo:399 / Elemento padre: 398   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(398)).appendChild((Element)v.get(399));
      /* Termina nodo:399   */
      /* Termina nodo:398   */
      /* Termina nodo:397   */

      /* Empieza nodo:400 / Elemento padre: 394   */
      v.add(doc.createElement("td"));
      ((Element)v.get(394)).appendChild((Element)v.get(400));

      /* Empieza nodo:401 / Elemento padre: 400   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(401)).setAttribute("src","b.gif" );
      ((Element)v.get(401)).setAttribute("width","25" );
      ((Element)v.get(401)).setAttribute("height","8" );
      ((Element)v.get(400)).appendChild((Element)v.get(401));
      /* Termina nodo:401   */
      /* Termina nodo:400   */

      /* Empieza nodo:402 / Elemento padre: 394   */
      v.add(doc.createElement("td"));
      ((Element)v.get(394)).appendChild((Element)v.get(402));

      /* Empieza nodo:403 / Elemento padre: 402   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(403)).setAttribute("nombre","cbClasificacion" );
      ((Element)v.get(403)).setAttribute("id","datosCampos" );
      ((Element)v.get(403)).setAttribute("size","5" );
      ((Element)v.get(403)).setAttribute("multiple","S" );
      ((Element)v.get(403)).setAttribute("req","N" );
      ((Element)v.get(403)).setAttribute("valorinicial","" );
      ((Element)v.get(403)).setAttribute("textoinicial","" );
      ((Element)v.get(403)).setAttribute("ontab","posicionarComboTipoCliente('cbClasificacion', 'ontab');" );
      ((Element)v.get(402)).appendChild((Element)v.get(403));

      /* Empieza nodo:404 / Elemento padre: 403   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(403)).appendChild((Element)v.get(404));
      /* Termina nodo:404   */
      /* Termina nodo:403   */
      /* Termina nodo:402   */

      /* Empieza nodo:405 / Elemento padre: 394   */
      v.add(doc.createElement("td"));
      ((Element)v.get(405)).setAttribute("width","100%" );
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(394)).appendChild((Element)v.get(405));

      /* Empieza nodo:406 / Elemento padre: 405   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(406)).setAttribute("src","b.gif" );
      ((Element)v.get(406)).setAttribute("width","8" );
      ((Element)v.get(406)).setAttribute("height","8" );
      ((Element)v.get(405)).appendChild((Element)v.get(406));
      /* Termina nodo:406   */
      /* Termina nodo:405   */
      /* Termina nodo:394   */

      /* Empieza nodo:407 / Elemento padre: 382   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(382)).appendChild((Element)v.get(407));

      /* Empieza nodo:408 / Elemento padre: 407   */
      v.add(doc.createElement("td"));
      ((Element)v.get(408)).setAttribute("colspan","9" );
      ((Element)v.get(407)).appendChild((Element)v.get(408));

      /* Empieza nodo:409 / Elemento padre: 408   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(409)).setAttribute("src","b.gif" );
      ((Element)v.get(409)).setAttribute("width","8" );
      ((Element)v.get(409)).setAttribute("height","8" );
      ((Element)v.get(408)).appendChild((Element)v.get(409));
      /* Termina nodo:409   */
      /* Termina nodo:408   */
      /* Termina nodo:407   */
      /* Termina nodo:382   */
      /* Termina nodo:381   */
      /* Termina nodo:380   */
      /* Termina nodo:346   */
      /* Termina nodo:343   */
      /* Termina nodo:342   */

      /* Empieza nodo:410 / Elemento padre: 339   */
      v.add(doc.createElement("td"));
      ((Element)v.get(339)).appendChild((Element)v.get(410));

      /* Empieza nodo:411 / Elemento padre: 410   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(411)).setAttribute("src","b.gif" );
      ((Element)v.get(410)).appendChild((Element)v.get(411));
      /* Termina nodo:411   */
      /* Termina nodo:410   */
      /* Termina nodo:339   */

      /* Empieza nodo:412 / Elemento padre: 331   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(331)).appendChild((Element)v.get(412));

      /* Empieza nodo:413 / Elemento padre: 412   */
      v.add(doc.createElement("td"));
      ((Element)v.get(413)).setAttribute("width","12" );
      ((Element)v.get(413)).setAttribute("align","center" );
      ((Element)v.get(412)).appendChild((Element)v.get(413));

      /* Empieza nodo:414 / Elemento padre: 413   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(414)).setAttribute("src","b.gif" );
      ((Element)v.get(414)).setAttribute("width","12" );
      ((Element)v.get(414)).setAttribute("height","12" );
      ((Element)v.get(413)).appendChild((Element)v.get(414));
      /* Termina nodo:414   */
      /* Termina nodo:413   */

      /* Empieza nodo:415 / Elemento padre: 412   */
      v.add(doc.createElement("td"));
      ((Element)v.get(415)).setAttribute("width","756" );
      ((Element)v.get(412)).appendChild((Element)v.get(415));

      /* Empieza nodo:416 / Elemento padre: 415   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(416)).setAttribute("src","b.gif" );
      ((Element)v.get(415)).appendChild((Element)v.get(416));
      /* Termina nodo:416   */
      /* Termina nodo:415   */

      /* Empieza nodo:417 / Elemento padre: 412   */
      v.add(doc.createElement("td"));
      ((Element)v.get(417)).setAttribute("width","12" );
      ((Element)v.get(412)).appendChild((Element)v.get(417));

      /* Empieza nodo:418 / Elemento padre: 417   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(418)).setAttribute("src","b.gif" );
      ((Element)v.get(418)).setAttribute("width","12" );
      ((Element)v.get(418)).setAttribute("height","1" );
      ((Element)v.get(417)).appendChild((Element)v.get(418));
      /* Termina nodo:418   */
      /* Termina nodo:417   */
      /* Termina nodo:412   */
      /* Termina nodo:331   */
      /* Termina nodo:330   */

      /* Empieza nodo:419 / Elemento padre: 14   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(419)).setAttribute("nombre","camposBusqueda4" );
      ((Element)v.get(419)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(14)).appendChild((Element)v.get(419));

      /* Empieza nodo:420 / Elemento padre: 419   */
      v.add(doc.createElement("table"));
      ((Element)v.get(420)).setAttribute("width","100%" );
      ((Element)v.get(420)).setAttribute("border","0" );
      ((Element)v.get(420)).setAttribute("cellspacing","0" );
      ((Element)v.get(420)).setAttribute("cellpadding","0" );
      ((Element)v.get(419)).appendChild((Element)v.get(420));

      /* Empieza nodo:421 / Elemento padre: 420   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(420)).appendChild((Element)v.get(421));

      /* Empieza nodo:422 / Elemento padre: 421   */
      v.add(doc.createElement("td"));
      ((Element)v.get(422)).setAttribute("width","12" );
      ((Element)v.get(422)).setAttribute("align","center" );
      ((Element)v.get(421)).appendChild((Element)v.get(422));

      /* Empieza nodo:423 / Elemento padre: 422   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(423)).setAttribute("src","b.gif" );
      ((Element)v.get(423)).setAttribute("width","12" );
      ((Element)v.get(423)).setAttribute("height","12" );
      ((Element)v.get(422)).appendChild((Element)v.get(423));
      /* Termina nodo:423   */
      /* Termina nodo:422   */

      /* Empieza nodo:424 / Elemento padre: 421   */
      v.add(doc.createElement("td"));
      ((Element)v.get(424)).setAttribute("width","750" );
      ((Element)v.get(421)).appendChild((Element)v.get(424));

      /* Empieza nodo:425 / Elemento padre: 424   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(425)).setAttribute("src","b.gif" );
      ((Element)v.get(424)).appendChild((Element)v.get(425));
      /* Termina nodo:425   */
      /* Termina nodo:424   */

      /* Empieza nodo:426 / Elemento padre: 421   */
      v.add(doc.createElement("td"));
      ((Element)v.get(426)).setAttribute("width","12" );
      ((Element)v.get(421)).appendChild((Element)v.get(426));

      /* Empieza nodo:427 / Elemento padre: 426   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(427)).setAttribute("src","b.gif" );
      ((Element)v.get(427)).setAttribute("width","12" );
      ((Element)v.get(427)).setAttribute("height","1" );
      ((Element)v.get(426)).appendChild((Element)v.get(427));
      /* Termina nodo:427   */
      /* Termina nodo:426   */
      /* Termina nodo:421   */

      /* Empieza nodo:428 / Elemento padre: 420   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(420)).appendChild((Element)v.get(428));

      /* Empieza nodo:429 / Elemento padre: 428   */
      v.add(doc.createElement("td"));
      ((Element)v.get(428)).appendChild((Element)v.get(429));

      /* Empieza nodo:430 / Elemento padre: 429   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(430)).setAttribute("src","b.gif" );
      ((Element)v.get(429)).appendChild((Element)v.get(430));
      /* Termina nodo:430   */
      /* Termina nodo:429   */

      /* Empieza nodo:431 / Elemento padre: 428   */
      v.add(doc.createElement("td"));
      ((Element)v.get(428)).appendChild((Element)v.get(431));

      /* Empieza nodo:432 / Elemento padre: 431   */
   }

   private void getXML1800(Document doc) {
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(431)).appendChild((Element)v.get(432));

      /* Empieza nodo:433 / Elemento padre: 432   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(433)).setAttribute("class","legend" );
      ((Element)v.get(432)).appendChild((Element)v.get(433));

      /* Empieza nodo:434 / Elemento padre: 433   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(434)).setAttribute("nombre","lblMarcaT" );
      ((Element)v.get(434)).setAttribute("alto","13" );
      ((Element)v.get(434)).setAttribute("filas","1" );
      ((Element)v.get(434)).setAttribute("valor","" );
      ((Element)v.get(434)).setAttribute("id","legend" );
      ((Element)v.get(434)).setAttribute("cod","0069" );
      ((Element)v.get(433)).appendChild((Element)v.get(434));
      /* Termina nodo:434   */
      /* Termina nodo:433   */

      /* Empieza nodo:435 / Elemento padre: 432   */
      v.add(doc.createElement("table"));
      ((Element)v.get(435)).setAttribute("width","100%" );
      ((Element)v.get(435)).setAttribute("border","0" );
      ((Element)v.get(435)).setAttribute("align","center" );
      ((Element)v.get(435)).setAttribute("cellspacing","0" );
      ((Element)v.get(435)).setAttribute("cellpadding","0" );
      ((Element)v.get(432)).appendChild((Element)v.get(435));

      /* Empieza nodo:436 / Elemento padre: 435   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(435)).appendChild((Element)v.get(436));

      /* Empieza nodo:437 / Elemento padre: 436   */
      v.add(doc.createElement("td"));
      ((Element)v.get(436)).appendChild((Element)v.get(437));

      /* Empieza nodo:438 / Elemento padre: 437   */
      v.add(doc.createElement("table"));
      ((Element)v.get(438)).setAttribute("width","731" );
      ((Element)v.get(438)).setAttribute("border","0" );
      ((Element)v.get(438)).setAttribute("align","left" );
      ((Element)v.get(438)).setAttribute("cellspacing","0" );
      ((Element)v.get(438)).setAttribute("cellpadding","0" );
      ((Element)v.get(437)).appendChild((Element)v.get(438));

      /* Empieza nodo:439 / Elemento padre: 438   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(438)).appendChild((Element)v.get(439));

      /* Empieza nodo:440 / Elemento padre: 439   */
      v.add(doc.createElement("td"));
      ((Element)v.get(440)).setAttribute("colspan","8" );
      ((Element)v.get(439)).appendChild((Element)v.get(440));

      /* Empieza nodo:441 / Elemento padre: 440   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(441)).setAttribute("src","b.gif" );
      ((Element)v.get(441)).setAttribute("width","8" );
      ((Element)v.get(441)).setAttribute("height","8" );
      ((Element)v.get(440)).appendChild((Element)v.get(441));
      /* Termina nodo:441   */
      /* Termina nodo:440   */
      /* Termina nodo:439   */

      /* Empieza nodo:442 / Elemento padre: 438   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(438)).appendChild((Element)v.get(442));

      /* Empieza nodo:443 / Elemento padre: 442   */
      v.add(doc.createElement("td"));
      ((Element)v.get(442)).appendChild((Element)v.get(443));

      /* Empieza nodo:444 / Elemento padre: 443   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(444)).setAttribute("src","b.gif" );
      ((Element)v.get(444)).setAttribute("width","8" );
      ((Element)v.get(444)).setAttribute("height","8" );
      ((Element)v.get(443)).appendChild((Element)v.get(444));
      /* Termina nodo:444   */
      /* Termina nodo:443   */

      /* Empieza nodo:445 / Elemento padre: 442   */
      v.add(doc.createElement("td"));
      ((Element)v.get(442)).appendChild((Element)v.get(445));

      /* Empieza nodo:446 / Elemento padre: 445   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(446)).setAttribute("nombre","lblMarca4" );
      ((Element)v.get(446)).setAttribute("alto","13" );
      ((Element)v.get(446)).setAttribute("filas","1" );
      ((Element)v.get(446)).setAttribute("valor","" );
      ((Element)v.get(446)).setAttribute("id","datosTitle" );
      ((Element)v.get(446)).setAttribute("cod","6" );
      ((Element)v.get(445)).appendChild((Element)v.get(446));
      /* Termina nodo:446   */
      /* Termina nodo:445   */

      /* Empieza nodo:447 / Elemento padre: 442   */
      v.add(doc.createElement("td"));
      ((Element)v.get(447)).setAttribute("width","100%" );
      ((Element)v.get(442)).appendChild((Element)v.get(447));

      /* Empieza nodo:448 / Elemento padre: 447   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(448)).setAttribute("src","b.gif" );
      ((Element)v.get(448)).setAttribute("width","8" );
      ((Element)v.get(448)).setAttribute("height","8" );
      ((Element)v.get(447)).appendChild((Element)v.get(448));
      /* Termina nodo:448   */
      /* Termina nodo:447   */
      /* Termina nodo:442   */

      /* Empieza nodo:449 / Elemento padre: 438   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(438)).appendChild((Element)v.get(449));

      /* Empieza nodo:450 / Elemento padre: 449   */
      v.add(doc.createElement("td"));
      ((Element)v.get(449)).appendChild((Element)v.get(450));

      /* Empieza nodo:451 / Elemento padre: 450   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(451)).setAttribute("src","b.gif" );
      ((Element)v.get(451)).setAttribute("width","8" );
      ((Element)v.get(451)).setAttribute("height","8" );
      ((Element)v.get(450)).appendChild((Element)v.get(451));
      /* Termina nodo:451   */
      /* Termina nodo:450   */

      /* Empieza nodo:452 / Elemento padre: 449   */
      v.add(doc.createElement("td"));
      ((Element)v.get(452)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(449)).appendChild((Element)v.get(452));

      /* Empieza nodo:453 / Elemento padre: 452   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(453)).setAttribute("nombre","cbMarca4" );
      ((Element)v.get(453)).setAttribute("id","datosCampos" );
      ((Element)v.get(453)).setAttribute("size","5" );
      ((Element)v.get(453)).setAttribute("multiple","S" );
      ((Element)v.get(453)).setAttribute("req","S" );
      ((Element)v.get(453)).setAttribute("valorinicial","" );
      ((Element)v.get(453)).setAttribute("textoinicial","" );
      ((Element)v.get(453)).setAttribute("ontab","focaliza('frmAsignacionDestinatarios.cbMarca4')" );
      ((Element)v.get(453)).setAttribute("onshtab","focaliza('frmAsignacionDestinatarios.cbMarca4')" );
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(452)).appendChild((Element)v.get(453));

      /* Empieza nodo:454 / Elemento padre: 453   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(453)).appendChild((Element)v.get(454));
      /* Termina nodo:454   */
      /* Termina nodo:453   */
      /* Termina nodo:452   */

      /* Empieza nodo:455 / Elemento padre: 449   */
      v.add(doc.createElement("td"));
      ((Element)v.get(455)).setAttribute("width","100%" );
      ((Element)v.get(449)).appendChild((Element)v.get(455));

      /* Empieza nodo:456 / Elemento padre: 455   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(456)).setAttribute("src","b.gif" );
      ((Element)v.get(456)).setAttribute("width","8" );
      ((Element)v.get(456)).setAttribute("height","8" );
      ((Element)v.get(455)).appendChild((Element)v.get(456));
      /* Termina nodo:456   */
      /* Termina nodo:455   */
      /* Termina nodo:449   */

      /* Empieza nodo:457 / Elemento padre: 438   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(438)).appendChild((Element)v.get(457));

      /* Empieza nodo:458 / Elemento padre: 457   */
      v.add(doc.createElement("td"));
      ((Element)v.get(458)).setAttribute("colspan","9" );
      ((Element)v.get(457)).appendChild((Element)v.get(458));

      /* Empieza nodo:459 / Elemento padre: 458   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(459)).setAttribute("src","b.gif" );
      ((Element)v.get(459)).setAttribute("width","8" );
      ((Element)v.get(459)).setAttribute("height","8" );
      ((Element)v.get(458)).appendChild((Element)v.get(459));
      /* Termina nodo:459   */
      /* Termina nodo:458   */
      /* Termina nodo:457   */
      /* Termina nodo:438   */
      /* Termina nodo:437   */
      /* Termina nodo:436   */
      /* Termina nodo:435   */
      /* Termina nodo:432   */
      /* Termina nodo:431   */

      /* Empieza nodo:460 / Elemento padre: 428   */
      v.add(doc.createElement("td"));
      ((Element)v.get(428)).appendChild((Element)v.get(460));

      /* Empieza nodo:461 / Elemento padre: 460   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(461)).setAttribute("src","b.gif" );
      ((Element)v.get(460)).appendChild((Element)v.get(461));
      /* Termina nodo:461   */
      /* Termina nodo:460   */
      /* Termina nodo:428   */

      /* Empieza nodo:462 / Elemento padre: 420   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(420)).appendChild((Element)v.get(462));

      /* Empieza nodo:463 / Elemento padre: 462   */
      v.add(doc.createElement("td"));
      ((Element)v.get(463)).setAttribute("width","12" );
      ((Element)v.get(463)).setAttribute("align","center" );
      ((Element)v.get(462)).appendChild((Element)v.get(463));

      /* Empieza nodo:464 / Elemento padre: 463   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(464)).setAttribute("src","b.gif" );
      ((Element)v.get(464)).setAttribute("width","12" );
      ((Element)v.get(464)).setAttribute("height","12" );
      ((Element)v.get(463)).appendChild((Element)v.get(464));
      /* Termina nodo:464   */
      /* Termina nodo:463   */

      /* Empieza nodo:465 / Elemento padre: 462   */
      v.add(doc.createElement("td"));
      ((Element)v.get(465)).setAttribute("width","756" );
      ((Element)v.get(462)).appendChild((Element)v.get(465));

      /* Empieza nodo:466 / Elemento padre: 465   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(466)).setAttribute("src","b.gif" );
      ((Element)v.get(465)).appendChild((Element)v.get(466));
      /* Termina nodo:466   */
      /* Termina nodo:465   */

      /* Empieza nodo:467 / Elemento padre: 462   */
      v.add(doc.createElement("td"));
      ((Element)v.get(467)).setAttribute("width","12" );
      ((Element)v.get(462)).appendChild((Element)v.get(467));

      /* Empieza nodo:468 / Elemento padre: 467   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(468)).setAttribute("src","b.gif" );
      ((Element)v.get(468)).setAttribute("width","12" );
      ((Element)v.get(468)).setAttribute("height","1" );
      ((Element)v.get(467)).appendChild((Element)v.get(468));
      /* Termina nodo:468   */
      /* Termina nodo:467   */
      /* Termina nodo:462   */
      /* Termina nodo:420   */
      /* Termina nodo:419   */

      /* Empieza nodo:469 / Elemento padre: 14   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(469)).setAttribute("nombre","camposBusqueda5" );
      ((Element)v.get(469)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(14)).appendChild((Element)v.get(469));

      /* Empieza nodo:470 / Elemento padre: 469   */
      v.add(doc.createElement("table"));
      ((Element)v.get(470)).setAttribute("width","100%" );
      ((Element)v.get(470)).setAttribute("border","0" );
      ((Element)v.get(470)).setAttribute("cellspacing","0" );
      ((Element)v.get(470)).setAttribute("cellpadding","0" );
      ((Element)v.get(469)).appendChild((Element)v.get(470));

      /* Empieza nodo:471 / Elemento padre: 470   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(470)).appendChild((Element)v.get(471));

      /* Empieza nodo:472 / Elemento padre: 471   */
      v.add(doc.createElement("td"));
      ((Element)v.get(472)).setAttribute("width","12" );
      ((Element)v.get(472)).setAttribute("align","center" );
      ((Element)v.get(471)).appendChild((Element)v.get(472));

      /* Empieza nodo:473 / Elemento padre: 472   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(473)).setAttribute("src","b.gif" );
      ((Element)v.get(473)).setAttribute("width","12" );
      ((Element)v.get(473)).setAttribute("height","12" );
      ((Element)v.get(472)).appendChild((Element)v.get(473));
      /* Termina nodo:473   */
      /* Termina nodo:472   */

      /* Empieza nodo:474 / Elemento padre: 471   */
      v.add(doc.createElement("td"));
      ((Element)v.get(474)).setAttribute("width","750" );
      ((Element)v.get(471)).appendChild((Element)v.get(474));

      /* Empieza nodo:475 / Elemento padre: 474   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(475)).setAttribute("src","b.gif" );
      ((Element)v.get(474)).appendChild((Element)v.get(475));
      /* Termina nodo:475   */
      /* Termina nodo:474   */

      /* Empieza nodo:476 / Elemento padre: 471   */
      v.add(doc.createElement("td"));
      ((Element)v.get(476)).setAttribute("width","12" );
      ((Element)v.get(471)).appendChild((Element)v.get(476));

      /* Empieza nodo:477 / Elemento padre: 476   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(477)).setAttribute("src","b.gif" );
      ((Element)v.get(477)).setAttribute("width","12" );
      ((Element)v.get(477)).setAttribute("height","1" );
      ((Element)v.get(476)).appendChild((Element)v.get(477));
      /* Termina nodo:477   */
      /* Termina nodo:476   */
      /* Termina nodo:471   */

      /* Empieza nodo:478 / Elemento padre: 470   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(470)).appendChild((Element)v.get(478));

      /* Empieza nodo:479 / Elemento padre: 478   */
      v.add(doc.createElement("td"));
      ((Element)v.get(478)).appendChild((Element)v.get(479));

      /* Empieza nodo:480 / Elemento padre: 479   */
   }

   private void getXML1980(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(480)).setAttribute("src","b.gif" );
      ((Element)v.get(479)).appendChild((Element)v.get(480));
      /* Termina nodo:480   */
      /* Termina nodo:479   */

      /* Empieza nodo:481 / Elemento padre: 478   */
      v.add(doc.createElement("td"));
      ((Element)v.get(478)).appendChild((Element)v.get(481));

      /* Empieza nodo:482 / Elemento padre: 481   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(481)).appendChild((Element)v.get(482));

      /* Empieza nodo:483 / Elemento padre: 482   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(483)).setAttribute("class","legend" );
      ((Element)v.get(482)).appendChild((Element)v.get(483));

      /* Empieza nodo:484 / Elemento padre: 483   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(484)).setAttribute("nombre","lblCodigoVenta" );
      ((Element)v.get(484)).setAttribute("alto","13" );
      ((Element)v.get(484)).setAttribute("filas","1" );
      ((Element)v.get(484)).setAttribute("valor","" );
      ((Element)v.get(484)).setAttribute("id","legend" );
      ((Element)v.get(484)).setAttribute("cod","0070" );
      ((Element)v.get(483)).appendChild((Element)v.get(484));
      /* Termina nodo:484   */
      /* Termina nodo:483   */

      /* Empieza nodo:485 / Elemento padre: 482   */
      v.add(doc.createElement("table"));
      ((Element)v.get(485)).setAttribute("width","100%" );
      ((Element)v.get(485)).setAttribute("border","0" );
      ((Element)v.get(485)).setAttribute("align","center" );
      ((Element)v.get(485)).setAttribute("cellspacing","0" );
      ((Element)v.get(485)).setAttribute("cellpadding","0" );
      ((Element)v.get(482)).appendChild((Element)v.get(485));

      /* Empieza nodo:486 / Elemento padre: 485   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(485)).appendChild((Element)v.get(486));

      /* Empieza nodo:487 / Elemento padre: 486   */
      v.add(doc.createElement("td"));
      ((Element)v.get(486)).appendChild((Element)v.get(487));

      /* Empieza nodo:488 / Elemento padre: 487   */
      v.add(doc.createElement("table"));
      ((Element)v.get(488)).setAttribute("width","731" );
      ((Element)v.get(488)).setAttribute("border","0" );
      ((Element)v.get(488)).setAttribute("align","left" );
      ((Element)v.get(488)).setAttribute("cellspacing","0" );
      ((Element)v.get(488)).setAttribute("cellpadding","0" );
      ((Element)v.get(487)).appendChild((Element)v.get(488));

      /* Empieza nodo:489 / Elemento padre: 488   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(488)).appendChild((Element)v.get(489));

      /* Empieza nodo:490 / Elemento padre: 489   */
      v.add(doc.createElement("td"));
      ((Element)v.get(490)).setAttribute("colspan","8" );
      ((Element)v.get(489)).appendChild((Element)v.get(490));

      /* Empieza nodo:491 / Elemento padre: 490   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(491)).setAttribute("src","b.gif" );
      ((Element)v.get(491)).setAttribute("width","8" );
      ((Element)v.get(491)).setAttribute("height","8" );
      ((Element)v.get(490)).appendChild((Element)v.get(491));
      /* Termina nodo:491   */
      /* Termina nodo:490   */
      /* Termina nodo:489   */

      /* Empieza nodo:492 / Elemento padre: 488   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(488)).appendChild((Element)v.get(492));

      /* Empieza nodo:493 / Elemento padre: 492   */
      v.add(doc.createElement("td"));
      ((Element)v.get(492)).appendChild((Element)v.get(493));

      /* Empieza nodo:494 / Elemento padre: 493   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(494)).setAttribute("src","b.gif" );
      ((Element)v.get(494)).setAttribute("width","8" );
      ((Element)v.get(494)).setAttribute("height","8" );
      ((Element)v.get(493)).appendChild((Element)v.get(494));
      /* Termina nodo:494   */
      /* Termina nodo:493   */

      /* Empieza nodo:495 / Elemento padre: 492   */
      v.add(doc.createElement("td"));
      ((Element)v.get(492)).appendChild((Element)v.get(495));

      /* Empieza nodo:496 / Elemento padre: 495   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(496)).setAttribute("nombre","lblCodVenta" );
      ((Element)v.get(496)).setAttribute("alto","13" );
      ((Element)v.get(496)).setAttribute("filas","1" );
      ((Element)v.get(496)).setAttribute("valor","" );
      ((Element)v.get(496)).setAttribute("id","datosTitle" );
      ((Element)v.get(496)).setAttribute("cod","336" );
      ((Element)v.get(495)).appendChild((Element)v.get(496));
      /* Termina nodo:496   */
      /* Termina nodo:495   */

      /* Empieza nodo:497 / Elemento padre: 492   */
      v.add(doc.createElement("td"));
      ((Element)v.get(497)).setAttribute("width","100%" );
      ((Element)v.get(492)).appendChild((Element)v.get(497));

      /* Empieza nodo:498 / Elemento padre: 497   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(498)).setAttribute("src","b.gif" );
      ((Element)v.get(498)).setAttribute("width","8" );
      ((Element)v.get(498)).setAttribute("height","8" );
      ((Element)v.get(497)).appendChild((Element)v.get(498));
      /* Termina nodo:498   */
      /* Termina nodo:497   */
      /* Termina nodo:492   */

      /* Empieza nodo:499 / Elemento padre: 488   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(488)).appendChild((Element)v.get(499));

      /* Empieza nodo:500 / Elemento padre: 499   */
      v.add(doc.createElement("td"));
      ((Element)v.get(499)).appendChild((Element)v.get(500));

      /* Empieza nodo:501 / Elemento padre: 500   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(501)).setAttribute("src","b.gif" );
      ((Element)v.get(501)).setAttribute("width","8" );
      ((Element)v.get(501)).setAttribute("height","8" );
      ((Element)v.get(500)).appendChild((Element)v.get(501));
      /* Termina nodo:501   */
      /* Termina nodo:500   */

      /* Empieza nodo:502 / Elemento padre: 499   */
      v.add(doc.createElement("td"));
      ((Element)v.get(502)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(499)).appendChild((Element)v.get(502));

      /* Empieza nodo:503 / Elemento padre: 502   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(503)).setAttribute("nombre","txtCodigoVenta" );
      ((Element)v.get(503)).setAttribute("id","datosCampos" );
      ((Element)v.get(503)).setAttribute("max","40" );
      ((Element)v.get(503)).setAttribute("tipo","" );
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(503)).setAttribute("onchange","" );
      ((Element)v.get(503)).setAttribute("req","S" );
      ((Element)v.get(503)).setAttribute("size","40" );
      ((Element)v.get(503)).setAttribute("valor","" );
      ((Element)v.get(503)).setAttribute("validacion","" );
      ((Element)v.get(503)).setAttribute("ontab","focaliza('frmAsignacionDestinatarios.txtCodigoVenta')" );
      ((Element)v.get(503)).setAttribute("onshtab","focaliza('frmAsignacionDestinatarios.txtCodigoVenta')" );
      ((Element)v.get(502)).appendChild((Element)v.get(503));
      /* Termina nodo:503   */
      /* Termina nodo:502   */

      /* Empieza nodo:504 / Elemento padre: 499   */
      v.add(doc.createElement("td"));
      ((Element)v.get(504)).setAttribute("width","100%" );
      ((Element)v.get(499)).appendChild((Element)v.get(504));

      /* Empieza nodo:505 / Elemento padre: 504   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(505)).setAttribute("src","b.gif" );
      ((Element)v.get(505)).setAttribute("width","8" );
      ((Element)v.get(505)).setAttribute("height","8" );
      ((Element)v.get(504)).appendChild((Element)v.get(505));
      /* Termina nodo:505   */
      /* Termina nodo:504   */
      /* Termina nodo:499   */

      /* Empieza nodo:506 / Elemento padre: 488   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(488)).appendChild((Element)v.get(506));

      /* Empieza nodo:507 / Elemento padre: 506   */
      v.add(doc.createElement("td"));
      ((Element)v.get(507)).setAttribute("colspan","9" );
      ((Element)v.get(506)).appendChild((Element)v.get(507));

      /* Empieza nodo:508 / Elemento padre: 507   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(508)).setAttribute("src","b.gif" );
      ((Element)v.get(508)).setAttribute("width","8" );
      ((Element)v.get(508)).setAttribute("height","8" );
      ((Element)v.get(507)).appendChild((Element)v.get(508));
      /* Termina nodo:508   */
      /* Termina nodo:507   */
      /* Termina nodo:506   */
      /* Termina nodo:488   */
      /* Termina nodo:487   */
      /* Termina nodo:486   */
      /* Termina nodo:485   */
      /* Termina nodo:482   */
      /* Termina nodo:481   */

      /* Empieza nodo:509 / Elemento padre: 478   */
      v.add(doc.createElement("td"));
      ((Element)v.get(478)).appendChild((Element)v.get(509));

      /* Empieza nodo:510 / Elemento padre: 509   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(510)).setAttribute("src","b.gif" );
      ((Element)v.get(509)).appendChild((Element)v.get(510));
      /* Termina nodo:510   */
      /* Termina nodo:509   */
      /* Termina nodo:478   */

      /* Empieza nodo:511 / Elemento padre: 470   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(470)).appendChild((Element)v.get(511));

      /* Empieza nodo:512 / Elemento padre: 511   */
      v.add(doc.createElement("td"));
      ((Element)v.get(512)).setAttribute("width","12" );
      ((Element)v.get(512)).setAttribute("align","center" );
      ((Element)v.get(511)).appendChild((Element)v.get(512));

      /* Empieza nodo:513 / Elemento padre: 512   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(513)).setAttribute("src","b.gif" );
      ((Element)v.get(513)).setAttribute("width","12" );
      ((Element)v.get(513)).setAttribute("height","12" );
      ((Element)v.get(512)).appendChild((Element)v.get(513));
      /* Termina nodo:513   */
      /* Termina nodo:512   */

      /* Empieza nodo:514 / Elemento padre: 511   */
      v.add(doc.createElement("td"));
      ((Element)v.get(514)).setAttribute("width","756" );
      ((Element)v.get(511)).appendChild((Element)v.get(514));

      /* Empieza nodo:515 / Elemento padre: 514   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(515)).setAttribute("src","b.gif" );
      ((Element)v.get(514)).appendChild((Element)v.get(515));
      /* Termina nodo:515   */
      /* Termina nodo:514   */

      /* Empieza nodo:516 / Elemento padre: 511   */
      v.add(doc.createElement("td"));
      ((Element)v.get(516)).setAttribute("width","12" );
      ((Element)v.get(511)).appendChild((Element)v.get(516));

      /* Empieza nodo:517 / Elemento padre: 516   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(517)).setAttribute("src","b.gif" );
      ((Element)v.get(517)).setAttribute("width","12" );
      ((Element)v.get(517)).setAttribute("height","1" );
      ((Element)v.get(516)).appendChild((Element)v.get(517));
      /* Termina nodo:517   */
      /* Termina nodo:516   */
      /* Termina nodo:511   */
      /* Termina nodo:470   */
      /* Termina nodo:469   */

      /* Empieza nodo:518 / Elemento padre: 14   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(518)).setAttribute("nombre","capaSubtipo" );
      ((Element)v.get(518)).setAttribute("alto","3" );
      ((Element)v.get(518)).setAttribute("ancho","624" );
      ((Element)v.get(518)).setAttribute("colorf","" );
      ((Element)v.get(518)).setAttribute("borde","0" );
      ((Element)v.get(518)).setAttribute("imagenf","" );
      ((Element)v.get(518)).setAttribute("repeat","" );
      ((Element)v.get(518)).setAttribute("padding","" );
      ((Element)v.get(518)).setAttribute("visibilidad","visible" );
      ((Element)v.get(518)).setAttribute("contravsb","" );
      ((Element)v.get(518)).setAttribute("x","0" );
      ((Element)v.get(518)).setAttribute("y","165" );
      ((Element)v.get(518)).setAttribute("zindex","" );
      ((Element)v.get(14)).appendChild((Element)v.get(518));

      /* Empieza nodo:519 / Elemento padre: 518   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(519)).setAttribute("seleccion","boton" );
      ((Element)v.get(519)).setAttribute("nombre","lstSubtipo" );
      ((Element)v.get(519)).setAttribute("x","12" );
      ((Element)v.get(519)).setAttribute("y","10" );
      ((Element)v.get(519)).setAttribute("ancho","600" );
      ((Element)v.get(519)).setAttribute("alto","3" );
      ((Element)v.get(519)).setAttribute("multisel","-1" );
      ((Element)v.get(519)).setAttribute("incy","10" );
      ((Element)v.get(519)).setAttribute("incx","10" );
      ((Element)v.get(519)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(519)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(519)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(519)).setAttribute("accion","" );
      ((Element)v.get(519)).setAttribute("sep","|" );
      ((Element)v.get(519)).setAttribute("pixelsborde","2" );
      ((Element)v.get(519)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(518)).appendChild((Element)v.get(519));

      /* Empieza nodo:520 / Elemento padre: 519   */
      v.add(doc.createElement("CABECERA"));
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(520)).setAttribute("nombre","cab1" );
      ((Element)v.get(520)).setAttribute("height","20" );
      ((Element)v.get(519)).appendChild((Element)v.get(520));

      /* Empieza nodo:521 / Elemento padre: 520   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(521)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(521)).setAttribute("ancho","40" );
      ((Element)v.get(520)).appendChild((Element)v.get(521));
      /* Termina nodo:521   */

      /* Empieza nodo:522 / Elemento padre: 520   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(522)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(522)).setAttribute("ancho","60" );
      ((Element)v.get(520)).appendChild((Element)v.get(522));

      /* Elemento padre:522 / Elemento actual: 523   */
      v.add(doc.createTextNode("Subtipo"));
      ((Element)v.get(522)).appendChild((Text)v.get(523));

      /* Termina nodo Texto:523   */
      /* Termina nodo:522   */

      /* Empieza nodo:524 / Elemento padre: 520   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(524)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(524)).setAttribute("ancho","440" );
      ((Element)v.get(520)).appendChild((Element)v.get(524));

      /* Elemento padre:524 / Elemento actual: 525   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(524)).appendChild((Text)v.get(525));

      /* Termina nodo Texto:525   */
      /* Termina nodo:524   */
      /* Termina nodo:520   */

      /* Empieza nodo:526 / Elemento padre: 519   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(526)).setAttribute("ancho","590" );
      ((Element)v.get(526)).setAttribute("filas","1" );
      ((Element)v.get(526)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(519)).appendChild((Element)v.get(526));

      /* Empieza nodo:527 / Elemento padre: 526   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(527)).setAttribute("ancho","40" );
      ((Element)v.get(527)).setAttribute("caracteres","20" );
      ((Element)v.get(526)).appendChild((Element)v.get(527));
      /* Termina nodo:527   */

      /* Empieza nodo:528 / Elemento padre: 526   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(528)).setAttribute("ancho","60" );
      ((Element)v.get(528)).setAttribute("caracteres","20" );
      ((Element)v.get(526)).appendChild((Element)v.get(528));
      /* Termina nodo:528   */

      /* Empieza nodo:529 / Elemento padre: 526   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(529)).setAttribute("ancho","440" );
      ((Element)v.get(529)).setAttribute("caracteres","30" );
      ((Element)v.get(526)).appendChild((Element)v.get(529));
      /* Termina nodo:529   */
      /* Termina nodo:526   */

      /* Empieza nodo:530 / Elemento padre: 519   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(519)).appendChild((Element)v.get(530));
      /* Termina nodo:530   */
      /* Termina nodo:519   */
      /* Termina nodo:518   */

      /* Empieza nodo:531 / Elemento padre: 14   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(531)).setAttribute("nombre","capaTipoClasificacion" );
      ((Element)v.get(531)).setAttribute("alto","3" );
      ((Element)v.get(531)).setAttribute("ancho","624" );
      ((Element)v.get(531)).setAttribute("colorf","" );
      ((Element)v.get(531)).setAttribute("borde","0" );
      ((Element)v.get(531)).setAttribute("imagenf","" );
      ((Element)v.get(531)).setAttribute("repeat","" );
      ((Element)v.get(531)).setAttribute("padding","" );
      ((Element)v.get(531)).setAttribute("visibilidad","visible" );
      ((Element)v.get(531)).setAttribute("contravsb","" );
      ((Element)v.get(531)).setAttribute("x","0" );
      ((Element)v.get(531)).setAttribute("y","165" );
      ((Element)v.get(531)).setAttribute("zindex","" );
      ((Element)v.get(14)).appendChild((Element)v.get(531));

      /* Empieza nodo:532 / Elemento padre: 531   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(532)).setAttribute("seleccion","boton" );
      ((Element)v.get(532)).setAttribute("nombre","lstTipoClasificacion" );
      ((Element)v.get(532)).setAttribute("x","12" );
      ((Element)v.get(532)).setAttribute("y","10" );
      ((Element)v.get(532)).setAttribute("ancho","600" );
      ((Element)v.get(532)).setAttribute("alto","3" );
      ((Element)v.get(532)).setAttribute("multisel","-1" );
      ((Element)v.get(532)).setAttribute("incy","10" );
      ((Element)v.get(532)).setAttribute("incx","10" );
      ((Element)v.get(532)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(532)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(532)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(532)).setAttribute("accion","" );
      ((Element)v.get(532)).setAttribute("sep","|" );
      ((Element)v.get(532)).setAttribute("pixelsborde","2" );
      ((Element)v.get(532)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(531)).appendChild((Element)v.get(532));

      /* Empieza nodo:533 / Elemento padre: 532   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(533)).setAttribute("nombre","cab1" );
      ((Element)v.get(533)).setAttribute("height","20" );
      ((Element)v.get(532)).appendChild((Element)v.get(533));

      /* Empieza nodo:534 / Elemento padre: 533   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(534)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(534)).setAttribute("ancho","40" );
      ((Element)v.get(533)).appendChild((Element)v.get(534));
      /* Termina nodo:534   */

      /* Empieza nodo:535 / Elemento padre: 533   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(535)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(535)).setAttribute("ancho","60" );
      ((Element)v.get(533)).appendChild((Element)v.get(535));

      /* Elemento padre:535 / Elemento actual: 536   */
      v.add(doc.createTextNode("TipoClasificacion"));
      ((Element)v.get(535)).appendChild((Text)v.get(536));

      /* Termina nodo Texto:536   */
      /* Termina nodo:535   */

      /* Empieza nodo:537 / Elemento padre: 533   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(537)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(537)).setAttribute("ancho","440" );
      ((Element)v.get(533)).appendChild((Element)v.get(537));

      /* Elemento padre:537 / Elemento actual: 538   */
      v.add(doc.createTextNode("Descripción"));
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(537)).appendChild((Text)v.get(538));

      /* Termina nodo Texto:538   */
      /* Termina nodo:537   */
      /* Termina nodo:533   */

      /* Empieza nodo:539 / Elemento padre: 532   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(539)).setAttribute("ancho","590" );
      ((Element)v.get(539)).setAttribute("filas","1" );
      ((Element)v.get(539)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(532)).appendChild((Element)v.get(539));

      /* Empieza nodo:540 / Elemento padre: 539   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(540)).setAttribute("ancho","40" );
      ((Element)v.get(540)).setAttribute("caracteres","20" );
      ((Element)v.get(539)).appendChild((Element)v.get(540));
      /* Termina nodo:540   */

      /* Empieza nodo:541 / Elemento padre: 539   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(541)).setAttribute("ancho","60" );
      ((Element)v.get(541)).setAttribute("caracteres","20" );
      ((Element)v.get(539)).appendChild((Element)v.get(541));
      /* Termina nodo:541   */

      /* Empieza nodo:542 / Elemento padre: 539   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(542)).setAttribute("ancho","440" );
      ((Element)v.get(542)).setAttribute("caracteres","30" );
      ((Element)v.get(539)).appendChild((Element)v.get(542));
      /* Termina nodo:542   */
      /* Termina nodo:539   */

      /* Empieza nodo:543 / Elemento padre: 532   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(532)).appendChild((Element)v.get(543));
      /* Termina nodo:543   */
      /* Termina nodo:532   */
      /* Termina nodo:531   */

      /* Empieza nodo:544 / Elemento padre: 14   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(544)).setAttribute("nombre","capaClasificacion" );
      ((Element)v.get(544)).setAttribute("alto","3" );
      ((Element)v.get(544)).setAttribute("ancho","624" );
      ((Element)v.get(544)).setAttribute("colorf","" );
      ((Element)v.get(544)).setAttribute("borde","0" );
      ((Element)v.get(544)).setAttribute("imagenf","" );
      ((Element)v.get(544)).setAttribute("repeat","" );
      ((Element)v.get(544)).setAttribute("padding","" );
      ((Element)v.get(544)).setAttribute("visibilidad","visible" );
      ((Element)v.get(544)).setAttribute("contravsb","" );
      ((Element)v.get(544)).setAttribute("x","0" );
      ((Element)v.get(544)).setAttribute("y","165" );
      ((Element)v.get(544)).setAttribute("zindex","" );
      ((Element)v.get(14)).appendChild((Element)v.get(544));

      /* Empieza nodo:545 / Elemento padre: 544   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(545)).setAttribute("seleccion","boton" );
      ((Element)v.get(545)).setAttribute("nombre","lstClasificacion" );
      ((Element)v.get(545)).setAttribute("x","12" );
      ((Element)v.get(545)).setAttribute("y","10" );
      ((Element)v.get(545)).setAttribute("ancho","600" );
      ((Element)v.get(545)).setAttribute("alto","3" );
      ((Element)v.get(545)).setAttribute("multisel","-1" );
      ((Element)v.get(545)).setAttribute("incy","10" );
      ((Element)v.get(545)).setAttribute("incx","10" );
      ((Element)v.get(545)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(545)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(545)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(545)).setAttribute("accion","" );
      ((Element)v.get(545)).setAttribute("sep","|" );
      ((Element)v.get(545)).setAttribute("pixelsborde","2" );
      ((Element)v.get(545)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(544)).appendChild((Element)v.get(545));

      /* Empieza nodo:546 / Elemento padre: 545   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(546)).setAttribute("nombre","cab1" );
      ((Element)v.get(546)).setAttribute("height","20" );
      ((Element)v.get(545)).appendChild((Element)v.get(546));

      /* Empieza nodo:547 / Elemento padre: 546   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(547)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(547)).setAttribute("ancho","40" );
      ((Element)v.get(546)).appendChild((Element)v.get(547));
      /* Termina nodo:547   */

      /* Empieza nodo:548 / Elemento padre: 546   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(548)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(548)).setAttribute("ancho","60" );
      ((Element)v.get(546)).appendChild((Element)v.get(548));

      /* Elemento padre:548 / Elemento actual: 549   */
      v.add(doc.createTextNode("Clasificacion"));
      ((Element)v.get(548)).appendChild((Text)v.get(549));

      /* Termina nodo Texto:549   */
      /* Termina nodo:548   */

      /* Empieza nodo:550 / Elemento padre: 546   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(550)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(550)).setAttribute("ancho","440" );
      ((Element)v.get(546)).appendChild((Element)v.get(550));

      /* Elemento padre:550 / Elemento actual: 551   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(550)).appendChild((Text)v.get(551));

      /* Termina nodo Texto:551   */
      /* Termina nodo:550   */
      /* Termina nodo:546   */

      /* Empieza nodo:552 / Elemento padre: 545   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(552)).setAttribute("ancho","590" );
      ((Element)v.get(552)).setAttribute("filas","1" );
      ((Element)v.get(552)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(545)).appendChild((Element)v.get(552));

      /* Empieza nodo:553 / Elemento padre: 552   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(553)).setAttribute("ancho","40" );
      ((Element)v.get(553)).setAttribute("caracteres","20" );
      ((Element)v.get(552)).appendChild((Element)v.get(553));
      /* Termina nodo:553   */

      /* Empieza nodo:554 / Elemento padre: 552   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(554)).setAttribute("ancho","60" );
      ((Element)v.get(554)).setAttribute("caracteres","20" );
      ((Element)v.get(552)).appendChild((Element)v.get(554));
      /* Termina nodo:554   */

      /* Empieza nodo:555 / Elemento padre: 552   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(555)).setAttribute("ancho","440" );
      ((Element)v.get(555)).setAttribute("caracteres","30" );
      ((Element)v.get(552)).appendChild((Element)v.get(555));
      /* Termina nodo:555   */
      /* Termina nodo:552   */

      /* Empieza nodo:556 / Elemento padre: 545   */
   }

   private void getXML2340(Document doc) {
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(545)).appendChild((Element)v.get(556));
      /* Termina nodo:556   */
      /* Termina nodo:545   */
      /* Termina nodo:544   */
      /* Termina nodo:14   */


   }

}
