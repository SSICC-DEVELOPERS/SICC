
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_patron_crear_seccion  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_patron_crear" );
      ((Element)v.get(0)).setAttribute("cod","0248" );
      ((Element)v.get(0)).setAttribute("titulo","Crear patrón" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Crear patrón" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Elemento padre:1 / Elemento actual: 2   */
      v.add(doc.createTextNode("\r    \r    var oidsPrevios  = new Array();\r    var FORM = \"frmFormulario\";\r/********************* LISTENERS DE LA PAGINA ********************************/\r    function fGuardar() {\r        accionGuardar();        \r    }\r    \r    function fLimpiar() {\r        accionLimpiar();\r    }\r    \r    function fVolver() {\r        this.close();\r    }\r    \r    function fBorrar() {\r        return accionEliminar();     \r    }\r    function fEliminar() {\r        return accionEliminar(); \r    }\r    function guardarOK(oidPatron, oidPatronPeriodo, codigoError) {\r        if ( !codigoError ) {\r            var arrayRet = new Array();\r            arrayRet[0] = oidPatron;\r            arrayRet[1] = oidPatronPeriodo;\r\r            eval(FORM).oculto = \"S\"; \r            this.returnValue = arrayRet;\r            this.close();\r        } else{\r            GestionarMensaje(codigoError);\r		}\r\r    }\r\r    function guardarKO() {\r    }\r\r\r/*********************** METODOS DE PGDatosSeccion ****************************/\r    function onLoadPag()   {\r		\r        configurarMenuSecundario(FORM);\r		fMostrarMensajeError();\r        DrdEnsanchaConMargenDcho('listaMensajes',12);\r        document.all[\"CplistaMensajes\"].style.visibility='';\r        document.all[\"CpLin1listaMensajes\"].style.visibility='';\r        document.all[\"CpLin2listaMensajes\"].style.visibility='';\r        document.all[\"CpLin3listaMensajes\"].style.visibility='';\r        document.all[\"CpLin4listaMensajes\"].style.visibility='';\r        document.all[\"primera1Div\"].style.visibility='';\r        document.all[\"ret1Div\"].style.visibility='';\r        document.all[\"ava1Div\"].style.visibility='';\r        document.all[\"separaDiv\"].style.visibility='';\r        document.all[\"btCrearMensajeDiv\"].style.visibility='';\r        document.all[\"btModificarMensajeDiv\"].style.visibility='';\r        document.all[\"btAnadirMensajeDiv\"].style.visibility='';\r\r        DrdEnsanchaConMargenDcho('listaMensajesSeccion',24);\r        document.all[\"CplistaMensajesSeccion\"].style.visibility='';\r        document.all[\"CpLin1listaMensajesSeccion\"].style.visibility='';\r        document.all[\"CpLin2listaMensajesSeccion\"].style.visibility='';\r        document.all[\"CpLin3listaMensajesSeccion\"].style.visibility='';\r        document.all[\"CpLin4listaMensajesSeccion\"].style.visibility='';\r        document.all[\"primera2Div\"].style.visibility='hidden';\r        document.all[\"ret2Div\"].style.visibility='hidden';\r        document.all[\"ava2Div\"].style.visibility='hidden';\r        document.all[\"separa2Div\"].style.visibility='hidden';\r\r        eval (ON_RSZ);\r\r\r        configurarPaginado\r            ( mipgndo\r            , \"MSGObtenerMensajesPorPais\"\r            , \"ConectorObtenerMensajesPorPais\"\r            , \"es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion\"\r            , paramsPaginado() );\r\r        var codigos = listaMensajesSeccion.codigos();\r        for ( i=0; i < codigos.length; i++ ) {\r            oidsPrevios[i] = new Array();\r            oidsPrevios[i][0] = codigos[i];\r            oidsPrevios[i][1] = listaMensajesSeccion.extraeDato(codigos[i], 0);\r            oidsPrevios[i][2] = listaMensajesSeccion.extraeDato(codigos[i], 1);\r            oidsPrevios[i][3] = listaMensajesSeccion.extraeDato(codigos[i], 2);\r        }        \r        set(FORM + \".cbOrdenSecuencia\", [get(FORM + '.hddnOrdenInicial')]);\r        set(FORM + \".cbMetacaracteresEstructura\", [get(FORM + '.hddnMetacaracter')]);\r		if (get(FORM + '.hOrdenInicialHabilitado') == 'N')\r			accion(FORM + '.cbOrdenSecuencia', '.disabled=true' );\r		else\r			accion(FORM + '.cbOrdenSecuencia', '.disabled=false' );\r    }\r\r    function accionAnadirMensaje() {\r		  if ( listaMensajes.numSelecc() != 0 ) {\r                        var selecs = listaMensajes.codSeleccionados();\r            var hashCodigos = new Array();\r            for ( i=0; i < selecs.length; i++ ) \r                hashCodigos[\"'\"+selecs[i]+\"'\"] = true;\r                \r            var codigos = listaMensajesSeccion.codigos();\r            var lastOrden = codigos.length;                         var hashOidsSelecs = new Array();\r            for ( i=0; i < codigos.length; i++ ) \r                hashOidsSelecs[\"'\"+codigos[i]+\"'\"] = true;            \r\r				            if ( lastOrden != 0 )\r                lastOrden = listaMensajesSeccion.extraeDato(codigos[lastOrden-1], 0);\r                \r            if ( lastOrden == NaN )\r                lastOrden == 0;\r                \r            var codigos = listaMensajes.codigos();\r            for ( i=0; i < codigos.length; i++ ) {\r                if  (   hashCodigos[\"'\"+codigos[i]+\"'\"] ) {\r                    if ( !hashOidsSelecs[\"'\"+codigos[i]+\"'\"] ) {\r                        lastOrden++;\r                        var datos = new Array();\r                        datos[0] = codigos[i];\r                        datos[1] = lastOrden;\r                        datos[2] = listaMensajes.extraeDato(codigos[i], 0);\r								datos[3] = listaMensajes.extraeDato(codigos[i], 2);\r                        listaMensajesSeccion.insertar(datos);\r                    }\r                    listaMensajes.deselecciona(i);\r                }\r            }\r        }\r\r    }\r\r    function accionGuardar() {\r                var correcto = comprobarDatosSeccion();\r        if ( correcto == true ) \r        { \r			if (verificacionNumerica() == 'true') {\r				set(FORM+\".accion\",\"Guardar seccion\"); \r				setListaMensajes(); 								eval(FORM).oculto = \"S\";\r				enviaSICC(FORM);\r			}\r        } \r        else             GestionarMensaje('1421');\r    }\r\r	function verificacionNumerica(){\r		for (var i=0; i < listaMensajesSeccion.datos.length; i++)  {\r			if (fValidarNumero(listaMensajesSeccion.datos[i][1],200,0,999) != 'OK')  {\r						GestionarMensaje('405');\r						document.all['Orden_' + i].focus();\r						return 'false';\r			}\r		}\r		return 'true';\r	}\r\r    function comprobarDatosSeccion() {\r    \r            	if (!sicc_validaciones_generales()) \r            return false;\r\r        var codigos = listaMensajesSeccion.codigos(); \r                if ( codigos.length == 0 )\r            return false;\r\r                for ( i=0; i < codigos.length; i++) {\r            var orden = listaMensajesSeccion.extraeDato(codigos[i], 0);\r            if ( !orden || orden == \"\" )\r                return false;\r        }\r\r                return true;\r    }\r\r    /**\r     *  Este método se ejecuta al pulsar sobre el botón Eliminar del menú secundario \r     */\r    function accionEliminar() {\r                if ( listaMensajesSeccion.numSelecc() != 0 )\r            listaMensajesSeccion.eliminarSelecc();     }\r\r    /**\r     *  Método que se activa al pulsar sobre el botón btCrearMensaje \r     */\r    function accionCrearMensaje() {\r                            	var obj = new Object();\r    	obj.opcionMenu = \"Insertar mensaje\";\r		obj.casoDeUso = \"Insertar mensaje\";\r    	obj.accion = \"\";\r    			mostrarModalSICC('LPMantenimientoMensajes','', obj);\r        /* Se bloquea la ejecución hasta el cierre de la ventana emergente */ \r                                recargarMensajes();\r\r    }\r\r    /**\r     *  Método que se activa al pulsar sobre el botón btModificarMensaje \r     */\r    function accionModificarMensaje() {\r                	var obj = new Object();\r    	obj.opcionMenu = \"Modificar mensaje\";\r		obj.casoDeUso = \"Modificar mensaje\";\r    	obj.accion = \"\";\r    			mostrarModalSICC('LPMantenimientoMensajes','', obj);\r    /* Se bloquea la ejecución hasta el cierre de la ventana emergente */     \r            recargarMensajes()\r    }\r\r    /*********************** METODOS INTERNOS ********************************/\r    function paramsPaginado() {\r        var array = new Array();\r        array[array.length] = new Array(\"oidPais\" , get(FORM+\".pais_activo\"));      \r        array[array.length] = new Array(\"oidIdioma\", get(FORM+\".idioma_activo\"));\r        return array;\r    }\r\r    /**\r     * setListaMensajes. Aplano la listaMensajes para poder pasarla y trabajarla en la LP.\r     */\r    function setListaMensajes() {\r        var codigos = listaMensajesSeccion.codigos();\r        \r        var strOidMensajes = \"\";\r        var strOrdenImpresionMensajes = \"\";\r        var strCodMsg = \"\";\r        var strTextoMensajes = \"\";\r        \r        for ( i=0; i < codigos.length; i++) {\r            var oidM = codigos[i];\r            var orden = listaMensajesSeccion.extraeDato(codigos[i], 0);\r            var codMsg = listaMensajesSeccion.extraeDato(codigos[i], 1);\r            var texto = listaMensajesSeccion.extraeDato(codigos[i], 2);\r            strOidMensajes = strOidMensajes +oidM;\r            strOrdenImpresionMensajes = strOrdenImpresionMensajes +orden;\r				strCodMsg = strCodMsg +codMsg;\r            strTextoMensajes = strTextoMensajes +texto;\r\r            if ( i != (codigos.length - 1 ) ) {\r                strOidMensajes += \"\\n\";\r                strOrdenImpresionMensajes += \"\\n\";\r                strCodMsg += \"\\n\";\r                strTextoMensajes += \"\\n\";\r            }\r        }\r\r        set(FORM+\".hddnOidMensajes\", strOidMensajes);\r        set(FORM+\".hddnCodMensajes\", strCodMsg);\r        set(FORM+\".hddnOrdenesImpresion\", strOrdenImpresionMensajes);\r        set(FORM+\".hddnTextoMensajes\", strTextoMensajes);\r        \r    }\r\r    function recargarMensajes() {\r        configurarPaginado\r            ( mipgndo\r            , \"MSGObtenerMensajesPorPais\"\r            , \"ConectorObtenerMensajesPorPais\"\r            , \"es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion\"\r            , paramsPaginado() );\r    }\r\r    function accionLimpiar() {\r                recargarMensajes();\r                var codigos = listaMensajesSeccion.codigos();\r        for ( i=0; i < codigos.length; i++ ) {\r            listaMensajesSeccion.selecciona(i);\r        }\r        listaMensajesSeccion.eliminarSelecc();\r                for ( i=0; i < oidsPrevios.length ; i++ ) {\r            listaMensajesSeccion.insertar(oidsPrevios[i]);\r        }\r        set(FORM + \".cbOrdenSecuencia\", [get(FORM + '.hddnOrdenInicial')]);\r        set(FORM + \".cbMetacaracteresEstructura\", [get(FORM + '.hddnMetacaracter')]);\r    }\r\r	function onKeyDown_ctexto(){\r\r\r	}\r\r    \r"));
      ((Element)v.get(1)).appendChild((Text)v.get(2));

      /* Termina nodo Texto:2   */
      /* Termina nodo:1   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(3));

      /* Empieza nodo:4 / Elemento padre: 3   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(4)).setAttribute("name","txtCodigoSeccion" );
      ((Element)v.get(4)).setAttribute("required","true" );
      ((Element)v.get(4)).setAttribute("cod","824" );
      ((Element)v.get(3)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 3   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(5)).setAttribute("name","cbOrdenSecuencia" );
      ((Element)v.get(5)).setAttribute("required","true" );
      ((Element)v.get(5)).setAttribute("cod","952" );
      ((Element)v.get(3)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */
      /* Termina nodo:3   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(6)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(7)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(8)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(9)).setAttribute("nombre","frmFormulario" );
      ((Element)v.get(9)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(9));

      /* Empieza nodo:10 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","accion" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(12)).setAttribute("valor","LPDatosSeccion" );
      ((Element)v.get(9)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","numeroSeccion" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","numeroSecciones" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","oidSeccion" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","oidPatron" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","oidPeriodo" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","oidPatronOrigen" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","oidPatronPeriodo" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","descripcionPais" );
      ((Element)v.get(22)).setAttribute("valor","" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(9)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","codigoPatron" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","descripcionPatron" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","oidMedioEnvio" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","oidFormulario" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","activo" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","patronPeriodo" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hddnOidMensajes" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hddnCodMensajes" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","hddnOrdenesImpresion" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","hddnTextoMensajes" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","hddnOrdenInicial" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","hddnMetacaracter" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","hOrdenInicialHabilitado" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","idioma_activo" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","pais_activo" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 9   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(38)).setAttribute("nombre","capaSeccion1" );
      ((Element)v.get(38)).setAttribute("alto","100%" );
      ((Element)v.get(38)).setAttribute("ancho","100%" );
      ((Element)v.get(38)).setAttribute("colorf","" );
      ((Element)v.get(38)).setAttribute("borde","1" );
      ((Element)v.get(38)).setAttribute("imagenf","" );
      ((Element)v.get(38)).setAttribute("repeat","" );
      ((Element)v.get(38)).setAttribute("padding","" );
      ((Element)v.get(38)).setAttribute("visibilidad","visible" );
      ((Element)v.get(38)).setAttribute("contravsb","" );
      ((Element)v.get(38)).setAttribute("zindex","" );
      ((Element)v.get(38)).setAttribute("x","" );
      ((Element)v.get(38)).setAttribute("y","0" );
      ((Element)v.get(9)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("table"));
      ((Element)v.get(39)).setAttribute("width","100%" );
      ((Element)v.get(39)).setAttribute("border","0" );
      ((Element)v.get(39)).setAttribute("cellspacing","0" );
      ((Element)v.get(39)).setAttribute("cellpadding","0" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).setAttribute("width","12" );
      ((Element)v.get(41)).setAttribute("align","center" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(42)).setAttribute("src","b.gif" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(42)).setAttribute("width","12" );
      ((Element)v.get(42)).setAttribute("height","12" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:43 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).setAttribute("width","750" );
      ((Element)v.get(40)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(44)).setAttribute("src","b.gif" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:45 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).setAttribute("width","12" );
      ((Element)v.get(40)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(46)).setAttribute("src","b.gif" );
      ((Element)v.get(46)).setAttribute("width","12" );
      ((Element)v.get(46)).setAttribute("height","1" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */
      /* Termina nodo:40   */

      /* Empieza nodo:47 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(52)).setAttribute("class","legend" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("table"));
      ((Element)v.get(53)).setAttribute("border","0" );
      ((Element)v.get(53)).setAttribute("bordercolor","#CCCCCC" );
      ((Element)v.get(53)).setAttribute("cellspacing","0" );
      ((Element)v.get(53)).setAttribute("cellpadding","0" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(53)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(56)).setAttribute("nombre","lbSeccion" );
      ((Element)v.get(56)).setAttribute("alto","13" );
      ((Element)v.get(56)).setAttribute("filas","1" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(56)).setAttribute("id","legend" );
      ((Element)v.get(56)).setAttribute("cod","00234" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:57 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(58)).setAttribute("src","b.gif" );
      ((Element)v.get(58)).setAttribute("width","8" );
      ((Element)v.get(58)).setAttribute("height","8" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:59 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(60)).setAttribute("nombre","Seccion1" );
      ((Element)v.get(60)).setAttribute("alto","13" );
      ((Element)v.get(60)).setAttribute("filas","1" );
      ((Element)v.get(60)).setAttribute("valor","1" );
      ((Element)v.get(60)).setAttribute("id","legend" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */
      /* Termina nodo:54   */
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:61 / Elemento padre: 51   */
      v.add(doc.createElement("table"));
      ((Element)v.get(61)).setAttribute("width","100%" );
      ((Element)v.get(61)).setAttribute("border","0" );
      ((Element)v.get(61)).setAttribute("align","center" );
      ((Element)v.get(61)).setAttribute("cellspacing","0" );
      ((Element)v.get(61)).setAttribute("cellpadding","0" );
      ((Element)v.get(51)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("table"));
      ((Element)v.get(64)).setAttribute("width","612" );
      ((Element)v.get(64)).setAttribute("border","0" );
      ((Element)v.get(64)).setAttribute("align","left" );
      ((Element)v.get(64)).setAttribute("cellspacing","0" );
      ((Element)v.get(64)).setAttribute("cellpadding","0" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).setAttribute("colspan","8" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(67)).setAttribute("src","b.gif" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(67)).setAttribute("width","8" );
      ((Element)v.get(67)).setAttribute("height","319" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:68 / Elemento padre: 64   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(64)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(70)).setAttribute("src","b.gif" );
      ((Element)v.get(70)).setAttribute("width","8" );
      ((Element)v.get(70)).setAttribute("height","8" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:71 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(72)).setAttribute("nombre","lblCodigoSeccion" );
      ((Element)v.get(72)).setAttribute("alto","13" );
      ((Element)v.get(72)).setAttribute("filas","1" );
      ((Element)v.get(72)).setAttribute("valor","" );
      ((Element)v.get(72)).setAttribute("id","datosTitle" );
      ((Element)v.get(72)).setAttribute("cod","824" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:73 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(74)).setAttribute("src","b.gif" );
      ((Element)v.get(74)).setAttribute("width","25" );
      ((Element)v.get(74)).setAttribute("height","8" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:75 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(76)).setAttribute("nombre","lblOrdenSecuencia" );
      ((Element)v.get(76)).setAttribute("alto","13" );
      ((Element)v.get(76)).setAttribute("filas","1" );
      ((Element)v.get(76)).setAttribute("valor","" );
      ((Element)v.get(76)).setAttribute("id","datosTitle" );
      ((Element)v.get(76)).setAttribute("cod","952" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(78)).setAttribute("width","25" );
      ((Element)v.get(78)).setAttribute("height","8" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:79 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(80)).setAttribute("nombre","lblMetacaracteresEstructura" );
      ((Element)v.get(80)).setAttribute("alto","13" );
      ((Element)v.get(80)).setAttribute("filas","1" );
      ((Element)v.get(80)).setAttribute("valor","" );
      ((Element)v.get(80)).setAttribute("id","datosTitle" );
      ((Element)v.get(80)).setAttribute("cod","2479" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:81 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(81)).setAttribute("width","100%" );
      ((Element)v.get(68)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(82)).setAttribute("width","8" );
      ((Element)v.get(82)).setAttribute("height","8" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:68   */

      /* Empieza nodo:83 / Elemento padre: 64   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(64)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(85)).setAttribute("src","b.gif" );
      ((Element)v.get(85)).setAttribute("width","8" );
      ((Element)v.get(85)).setAttribute("height","8" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:86 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(86)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(83)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(87)).setAttribute("nombre","txtCodigoSeccion" );
      ((Element)v.get(87)).setAttribute("id","datosCampos" );
      ((Element)v.get(87)).setAttribute("max","4" );
      ((Element)v.get(87)).setAttribute("tipo","" );
      ((Element)v.get(87)).setAttribute("onchange","" );
      ((Element)v.get(87)).setAttribute("req","S" );
      ((Element)v.get(87)).setAttribute("size","4" );
      ((Element)v.get(87)).setAttribute("valor","" );
      ((Element)v.get(87)).setAttribute("validacion","" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:88 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(89)).setAttribute("src","b.gif" );
      ((Element)v.get(89)).setAttribute("width","25" );
      ((Element)v.get(89)).setAttribute("height","8" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:90 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(83)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(91)).setAttribute("nombre","cbOrdenSecuencia" );
      ((Element)v.get(91)).setAttribute("id","datosCampos" );
      ((Element)v.get(91)).setAttribute("size","1" );
      ((Element)v.get(91)).setAttribute("multiple","N" );
      ((Element)v.get(91)).setAttribute("req","S" );
      ((Element)v.get(91)).setAttribute("valorinicial","" );
      ((Element)v.get(91)).setAttribute("textoinicial","" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:93 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(94)).setAttribute("src","b.gif" );
      ((Element)v.get(94)).setAttribute("width","25" );
      ((Element)v.get(94)).setAttribute("height","8" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:95 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(96)).setAttribute("nombre","cbMetacaracteresEstructura" );
      ((Element)v.get(96)).setAttribute("id","datosCampos" );
      ((Element)v.get(96)).setAttribute("size","1" );
      ((Element)v.get(96)).setAttribute("multiple","N" );
      ((Element)v.get(96)).setAttribute("req","N" );
      ((Element)v.get(96)).setAttribute("valorinicial","" );
      ((Element)v.get(96)).setAttribute("textoinicial","" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:98 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).setAttribute("width","100%" );
      ((Element)v.get(83)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(99)).setAttribute("src","b.gif" );
      ((Element)v.get(99)).setAttribute("width","8" );
      ((Element)v.get(99)).setAttribute("height","8" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:83   */

      /* Empieza nodo:100 / Elemento padre: 64   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(64)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(101)).setAttribute("colspan","9" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(102)).setAttribute("src","b.gif" );
      ((Element)v.get(102)).setAttribute("width","8" );
      ((Element)v.get(102)).setAttribute("height","8" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */
      /* Termina nodo:100   */
      /* Termina nodo:64   */
      /* Termina nodo:63   */
      /* Termina nodo:62   */
      /* Termina nodo:61   */
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:103 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */
      /* Termina nodo:47   */

      /* Empieza nodo:105 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).setAttribute("width","12" );
      ((Element)v.get(106)).setAttribute("align","center" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(107)).setAttribute("src","b.gif" );
      ((Element)v.get(107)).setAttribute("width","12" );
      ((Element)v.get(107)).setAttribute("height","12" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:108 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).setAttribute("width","756" );
      ((Element)v.get(105)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(109)).setAttribute("src","b.gif" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:110 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).setAttribute("width","12" );
      ((Element)v.get(105)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(111)).setAttribute("src","b.gif" );
      ((Element)v.get(111)).setAttribute("width","12" );
      ((Element)v.get(111)).setAttribute("height","1" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */
      /* Termina nodo:105   */
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:112 / Elemento padre: 9   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(112)).setAttribute("nombre","listaMensajesSeccion" );
      ((Element)v.get(112)).setAttribute("ancho","591" );
      ((Element)v.get(112)).setAttribute("alto","295" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(112)).setAttribute("x","24" );
      ((Element)v.get(112)).setAttribute("y","37" );
      ((Element)v.get(112)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(112)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(9)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(113)).setAttribute("precarga","S" );
      ((Element)v.get(113)).setAttribute("conROver","S" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(114)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(114)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(114)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(114)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */

      /* Empieza nodo:115 / Elemento padre: 113   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(115)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(115)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(115)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(115)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(113)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */

      /* Empieza nodo:116 / Elemento padre: 113   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(116)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(116)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(113)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:113   */

      /* Empieza nodo:117 / Elemento padre: 112   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(112)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(118)).setAttribute("borde","1" );
      ((Element)v.get(118)).setAttribute("horizDatos","1" );
      ((Element)v.get(118)).setAttribute("horizCabecera","1" );
      ((Element)v.get(118)).setAttribute("vertical","1" );
      ((Element)v.get(118)).setAttribute("horizTitulo","1" );
      ((Element)v.get(118)).setAttribute("horizBase","1" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */

      /* Empieza nodo:119 / Elemento padre: 117   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(119)).setAttribute("borde","#999999" );
      ((Element)v.get(119)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(119)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(119)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(119)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(119)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(119)).setAttribute("horizBase","#999999" );
      ((Element)v.get(117)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:117   */

      /* Empieza nodo:120 / Elemento padre: 112   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(120)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(120)).setAttribute("alto","22" );
      ((Element)v.get(120)).setAttribute("imgFondo","" );
      ((Element)v.get(120)).setAttribute("ID","datosTitle" );
      ((Element)v.get(120)).setAttribute("cod","00545" );
      ((Element)v.get(112)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */

      /* Empieza nodo:121 / Elemento padre: 112   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(121)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(121)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(121)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(121)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(121)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(121)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(112)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(122)).setAttribute("ancho","150" );
      ((Element)v.get(122)).setAttribute("minimizable","S" );
      ((Element)v.get(122)).setAttribute("minimizada","N" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */

      /* Empieza nodo:123 / Elemento padre: 121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(123)).setAttribute("ancho","150" );
      ((Element)v.get(123)).setAttribute("minimizable","S" );
      ((Element)v.get(123)).setAttribute("minimizada","N" );
      ((Element)v.get(121)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */

      /* Empieza nodo:124 / Elemento padre: 121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(124)).setAttribute("ancho","500" );
      ((Element)v.get(124)).setAttribute("minimizable","S" );
      ((Element)v.get(124)).setAttribute("minimizada","N" );
      ((Element)v.get(121)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:121   */

      /* Empieza nodo:125 / Elemento padre: 112   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(125)).setAttribute("alto","20" );
      ((Element)v.get(125)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(125)).setAttribute("imgFondo","" );
      ((Element)v.get(125)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(125)).setAttribute("ajustarAMitadInf","S" );
      ((Element)v.get(112)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(126)).setAttribute("colFondo","" );
      ((Element)v.get(126)).setAttribute("ID","EstCab" );
      ((Element)v.get(126)).setAttribute("cod","951" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Elemento padre:126 / Elemento actual: 127   */
      v.add(doc.createTextNode("Orden impresión mensaje"));
      ((Element)v.get(126)).appendChild((Text)v.get(127));

      /* Termina nodo Texto:127   */
      /* Termina nodo:126   */

      /* Empieza nodo:128 / Elemento padre: 125   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(128)).setAttribute("colFondo","" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(128)).setAttribute("ID","EstCab" );
      ((Element)v.get(128)).setAttribute("align","center" );
      ((Element)v.get(128)).setAttribute("cod","821" );
      ((Element)v.get(125)).appendChild((Element)v.get(128));

      /* Elemento padre:128 / Elemento actual: 129   */
      v.add(doc.createTextNode("Cód. mensaje"));
      ((Element)v.get(128)).appendChild((Text)v.get(129));

      /* Termina nodo Texto:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:130 / Elemento padre: 125   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(130)).setAttribute("colFondo","" );
      ((Element)v.get(130)).setAttribute("ID","EstCab" );
      ((Element)v.get(130)).setAttribute("align","center" );
      ((Element)v.get(130)).setAttribute("cod","2480" );
      ((Element)v.get(125)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:125   */

      /* Empieza nodo:131 / Elemento padre: 112   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(131)).setAttribute("alto","22" );
      ((Element)v.get(131)).setAttribute("accion","" );
      ((Element)v.get(131)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(131)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(131)).setAttribute("maxSel","-1" );
      ((Element)v.get(131)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(131)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(131)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(131)).setAttribute("onLoad","" );
      ((Element)v.get(131)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(112)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(132)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(132)).setAttribute("nombre","Orden" );
      ((Element)v.get(132)).setAttribute("size","4" );
      ((Element)v.get(132)).setAttribute("max","4" );
      ((Element)v.get(132)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(132)).setAttribute("ID","EstDat2" );
      ((Element)v.get(132)).setAttribute("onKeyDown","if(event.keyCode==13){window.event.cancelBubble=true;return false;}" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */

      /* Empieza nodo:133 / Elemento padre: 131   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(133)).setAttribute("tipo","texto" );
      ((Element)v.get(133)).setAttribute("ID","EstDat" );
      ((Element)v.get(131)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */

      /* Empieza nodo:134 / Elemento padre: 131   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(134)).setAttribute("tipo","texto" );
      ((Element)v.get(134)).setAttribute("ID","EstDat2" );
      ((Element)v.get(131)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:131   */

      /* Empieza nodo:135 / Elemento padre: 112   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(112)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */

      /* Empieza nodo:136 / Elemento padre: 112   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(136)).setAttribute("nombre","mipgndo2" );
      ((Element)v.get(136)).setAttribute("ancho","591" );
      ((Element)v.get(136)).setAttribute("sep","$" );
      ((Element)v.get(136)).setAttribute("x","12" );
      ((Element)v.get(136)).setAttribute("class","botonera" );
      ((Element)v.get(136)).setAttribute("y","309" );
      ((Element)v.get(136)).setAttribute("control","|" );
      ((Element)v.get(136)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(136)).setAttribute("rowset","" );
      ((Element)v.get(136)).setAttribute("cargainicial","N" );
      ((Element)v.get(112)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(137)).setAttribute("nombre","ret2" );
      ((Element)v.get(137)).setAttribute("x","49" );
      ((Element)v.get(137)).setAttribute("y","313" );
      ((Element)v.get(137)).setAttribute("ID","botonContenido" );
      ((Element)v.get(137)).setAttribute("img","retroceder_on" );
      ((Element)v.get(137)).setAttribute("tipo","0" );
      ((Element)v.get(137)).setAttribute("estado","false" );
      ((Element)v.get(137)).setAttribute("alt","" );
      ((Element)v.get(137)).setAttribute("codigo","" );
      ((Element)v.get(137)).setAttribute("accion","mipgndo2.retroceder();" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */

      /* Empieza nodo:138 / Elemento padre: 136   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(138)).setAttribute("nombre","ava2" );
      ((Element)v.get(138)).setAttribute("x","64" );
      ((Element)v.get(138)).setAttribute("y","325" );
      ((Element)v.get(138)).setAttribute("ID","botonContenido" );
      ((Element)v.get(138)).setAttribute("img","avanzar_on" );
      ((Element)v.get(138)).setAttribute("tipo","0" );
      ((Element)v.get(138)).setAttribute("estado","false" );
      ((Element)v.get(138)).setAttribute("alt","" );
      ((Element)v.get(138)).setAttribute("codigo","" );
      ((Element)v.get(138)).setAttribute("accion","mipgndo2.avanzar();" );
      ((Element)v.get(136)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:136   */
      /* Termina nodo:112   */

      /* Empieza nodo:139 / Elemento padre: 9   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(139)).setAttribute("nombre","primera2" );
      ((Element)v.get(139)).setAttribute("x","32" );
      ((Element)v.get(139)).setAttribute("y","313" );
      ((Element)v.get(139)).setAttribute("ID","botonContenido" );
      ((Element)v.get(139)).setAttribute("img","primera_on" );
      ((Element)v.get(139)).setAttribute("tipo","1" );
      ((Element)v.get(139)).setAttribute("estado","false" );
      ((Element)v.get(139)).setAttribute("alt","" );
      ((Element)v.get(139)).setAttribute("codigo","" );
      ((Element)v.get(139)).setAttribute("accion","mipgndo2.retrocederPrimeraPagina();" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(9)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */

      /* Empieza nodo:140 / Elemento padre: 9   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(140)).setAttribute("nombre","separa2" );
      ((Element)v.get(140)).setAttribute("x","71" );
      ((Element)v.get(140)).setAttribute("y","309" );
      ((Element)v.get(140)).setAttribute("ID","botonContenido" );
      ((Element)v.get(140)).setAttribute("img","separa_base" );
      ((Element)v.get(140)).setAttribute("tipo","0" );
      ((Element)v.get(140)).setAttribute("estado","false" );
      ((Element)v.get(140)).setAttribute("alt","" );
      ((Element)v.get(140)).setAttribute("codigo","" );
      ((Element)v.get(140)).setAttribute("accion","" );
      ((Element)v.get(9)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */

      /* Empieza nodo:141 / Elemento padre: 9   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(141)).setAttribute("nombre","listaMensajes" );
      ((Element)v.get(141)).setAttribute("ancho","616" );
      ((Element)v.get(141)).setAttribute("alto","299" );
      ((Element)v.get(141)).setAttribute("x","12" );
      ((Element)v.get(141)).setAttribute("y","413" );
      ((Element)v.get(141)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(141)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(9)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(142)).setAttribute("precarga","S" );
      ((Element)v.get(142)).setAttribute("conROver","S" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(143)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(143)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(143)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(143)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */

      /* Empieza nodo:144 / Elemento padre: 142   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(144)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(144)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(144)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(144)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(142)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */

      /* Empieza nodo:145 / Elemento padre: 142   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(145)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(145)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(142)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:142   */

      /* Empieza nodo:146 / Elemento padre: 141   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(141)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(147)).setAttribute("borde","1" );
      ((Element)v.get(147)).setAttribute("horizDatos","1" );
      ((Element)v.get(147)).setAttribute("horizCabecera","1" );
      ((Element)v.get(147)).setAttribute("vertical","1" );
      ((Element)v.get(147)).setAttribute("horizTitulo","1" );
      ((Element)v.get(147)).setAttribute("horizBase","1" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */

      /* Empieza nodo:148 / Elemento padre: 146   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(148)).setAttribute("borde","#999999" );
      ((Element)v.get(148)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(148)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(148)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(148)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(148)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(148)).setAttribute("horizBase","#999999" );
      ((Element)v.get(146)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:146   */

      /* Empieza nodo:149 / Elemento padre: 141   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(149)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(149)).setAttribute("alto","22" );
      ((Element)v.get(149)).setAttribute("imgFondo","" );
      ((Element)v.get(149)).setAttribute("cod","00405" );
      ((Element)v.get(149)).setAttribute("ID","datosTitle" );
      ((Element)v.get(141)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */

      /* Empieza nodo:150 / Elemento padre: 141   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(150)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(150)).setAttribute("alto","22" );
      ((Element)v.get(150)).setAttribute("imgFondo","" );
      ((Element)v.get(141)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */

      /* Empieza nodo:151 / Elemento padre: 141   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(151)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(151)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(151)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(151)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(151)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(151)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(141)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(152)).setAttribute("ancho","80" );
      ((Element)v.get(152)).setAttribute("minimizable","S" );
      ((Element)v.get(152)).setAttribute("minimizada","N" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */

      /* Empieza nodo:153 / Elemento padre: 151   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(153)).setAttribute("ancho","500" );
      ((Element)v.get(153)).setAttribute("minimizable","S" );
      ((Element)v.get(153)).setAttribute("minimizada","N" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(151)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */

      /* Empieza nodo:154 / Elemento padre: 151   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(154)).setAttribute("ancho","80" );
      ((Element)v.get(154)).setAttribute("minimizable","S" );
      ((Element)v.get(154)).setAttribute("minimizada","N" );
      ((Element)v.get(154)).setAttribute("oculta","S" );
      ((Element)v.get(151)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:151   */

      /* Empieza nodo:155 / Elemento padre: 141   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(155)).setAttribute("alto","20" );
      ((Element)v.get(155)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(155)).setAttribute("imgFondo","" );
      ((Element)v.get(155)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(155)).setAttribute("ajustarAMitadInf","S" );
      ((Element)v.get(141)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(156)).setAttribute("colFondo","" );
      ((Element)v.get(156)).setAttribute("ID","EstCab" );
      ((Element)v.get(156)).setAttribute("align","center" );
      ((Element)v.get(156)).setAttribute("cod","821" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));

      /* Elemento padre:156 / Elemento actual: 157   */
      v.add(doc.createTextNode("Cód. mensaje"));
      ((Element)v.get(156)).appendChild((Text)v.get(157));

      /* Termina nodo Texto:157   */
      /* Termina nodo:156   */

      /* Empieza nodo:158 / Elemento padre: 155   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(158)).setAttribute("colFondo","" );
      ((Element)v.get(158)).setAttribute("ID","EstCab" );
      ((Element)v.get(158)).setAttribute("cod","9" );
      ((Element)v.get(155)).appendChild((Element)v.get(158));

      /* Elemento padre:158 / Elemento actual: 159   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(158)).appendChild((Text)v.get(159));

      /* Termina nodo Texto:159   */
      /* Termina nodo:158   */

      /* Empieza nodo:160 / Elemento padre: 155   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(160)).setAttribute("colFondo","" );
      ((Element)v.get(160)).setAttribute("ID","EstCab" );
      ((Element)v.get(160)).setAttribute("cod","" );
      ((Element)v.get(155)).appendChild((Element)v.get(160));

      /* Elemento padre:160 / Elemento actual: 161   */
      v.add(doc.createTextNode("texto"));
      ((Element)v.get(160)).appendChild((Text)v.get(161));

      /* Termina nodo Texto:161   */
      /* Termina nodo:160   */
      /* Termina nodo:155   */

      /* Empieza nodo:162 / Elemento padre: 141   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(162)).setAttribute("alto","22" );
      ((Element)v.get(162)).setAttribute("accion","" );
      ((Element)v.get(162)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(162)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(162)).setAttribute("maxSel","-1" );
      ((Element)v.get(162)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(162)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(162)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(162)).setAttribute("onLoad","" );
      ((Element)v.get(162)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(141)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(163)).setAttribute("tipo","texto" );
      ((Element)v.get(163)).setAttribute("ID","EstDat2" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */

      /* Empieza nodo:164 / Elemento padre: 162   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(164)).setAttribute("tipo","texto" );
      ((Element)v.get(164)).setAttribute("ID","EstDat" );
      ((Element)v.get(162)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */

      /* Empieza nodo:165 / Elemento padre: 162   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(165)).setAttribute("tipo","texto" );
      ((Element)v.get(165)).setAttribute("ID","EstDat2" );
      ((Element)v.get(162)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:162   */

      /* Empieza nodo:166 / Elemento padre: 141   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(141)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */

      /* Empieza nodo:167 / Elemento padre: 141   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(167)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(167)).setAttribute("ancho","616" );
      ((Element)v.get(167)).setAttribute("sep","$" );
      ((Element)v.get(167)).setAttribute("x","12" );
      ((Element)v.get(167)).setAttribute("class","botonera" );
      ((Element)v.get(167)).setAttribute("y","689" );
      ((Element)v.get(167)).setAttribute("control","|" );
      ((Element)v.get(167)).setAttribute("conector","conectorSandra1" );
      ((Element)v.get(167)).setAttribute("rowset","" );
      ((Element)v.get(167)).setAttribute("cargainicial","N" );
      ((Element)v.get(141)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(168)).setAttribute("nombre","ret1" );
      ((Element)v.get(168)).setAttribute("x","37" );
      ((Element)v.get(168)).setAttribute("y","693" );
      ((Element)v.get(168)).setAttribute("ID","botonContenido" );
      ((Element)v.get(168)).setAttribute("img","retroceder_on" );
      ((Element)v.get(168)).setAttribute("tipo","0" );
      ((Element)v.get(168)).setAttribute("estado","false" );
      ((Element)v.get(168)).setAttribute("alt","" );
      ((Element)v.get(168)).setAttribute("codigo","" );
      ((Element)v.get(168)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */

      /* Empieza nodo:169 / Elemento padre: 167   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(169)).setAttribute("nombre","ava1" );
      ((Element)v.get(169)).setAttribute("x","52" );
      ((Element)v.get(169)).setAttribute("y","693" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(169)).setAttribute("ID","botonContenido" );
      ((Element)v.get(169)).setAttribute("img","avanzar_on" );
      ((Element)v.get(169)).setAttribute("tipo","0" );
      ((Element)v.get(169)).setAttribute("estado","false" );
      ((Element)v.get(169)).setAttribute("alt","" );
      ((Element)v.get(169)).setAttribute("codigo","" );
      ((Element)v.get(169)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(167)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */

      /* Empieza nodo:170 / Elemento padre: 167   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(170)).setAttribute("nombre","primera1" );
      ((Element)v.get(170)).setAttribute("x","20" );
      ((Element)v.get(170)).setAttribute("y","693" );
      ((Element)v.get(170)).setAttribute("ID","botonContenido" );
      ((Element)v.get(170)).setAttribute("img","primera_on" );
      ((Element)v.get(170)).setAttribute("tipo","1" );
      ((Element)v.get(170)).setAttribute("estado","false" );
      ((Element)v.get(170)).setAttribute("alt","" );
      ((Element)v.get(170)).setAttribute("codigo","" );
      ((Element)v.get(170)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(167)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */

      /* Empieza nodo:171 / Elemento padre: 167   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(171)).setAttribute("nombre","separa" );
      ((Element)v.get(171)).setAttribute("x","59" );
      ((Element)v.get(171)).setAttribute("y","689" );
      ((Element)v.get(171)).setAttribute("ID","botonContenido" );
      ((Element)v.get(171)).setAttribute("img","separa_base" );
      ((Element)v.get(171)).setAttribute("tipo","0" );
      ((Element)v.get(171)).setAttribute("estado","false" );
      ((Element)v.get(171)).setAttribute("alt","" );
      ((Element)v.get(171)).setAttribute("codigo","" );
      ((Element)v.get(171)).setAttribute("accion","" );
      ((Element)v.get(167)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:167   */
      /* Termina nodo:141   */

      /* Empieza nodo:172 / Elemento padre: 9   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(172)).setAttribute("nombre","btCrearMensaje" );
      ((Element)v.get(172)).setAttribute("x","80" );
      ((Element)v.get(172)).setAttribute("y","690" );
      ((Element)v.get(172)).setAttribute("ID","botonContenido" );
      ((Element)v.get(172)).setAttribute("tipo","html" );
      ((Element)v.get(172)).setAttribute("estado","false" );
      ((Element)v.get(172)).setAttribute("cod","2481" );
      ((Element)v.get(172)).setAttribute("accion","accionCrearMensaje()" );
      ((Element)v.get(9)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */

      /* Empieza nodo:173 / Elemento padre: 9   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(173)).setAttribute("nombre","btModificarMensaje" );
      ((Element)v.get(173)).setAttribute("x","185" );
      ((Element)v.get(173)).setAttribute("y","690" );
      ((Element)v.get(173)).setAttribute("ID","botonContenido" );
      ((Element)v.get(173)).setAttribute("tipo","html" );
      ((Element)v.get(173)).setAttribute("estado","false" );
      ((Element)v.get(173)).setAttribute("cod","2482" );
      ((Element)v.get(173)).setAttribute("accion","accionModificarMensaje()" );
      ((Element)v.get(9)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */

      /* Empieza nodo:174 / Elemento padre: 9   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(174)).setAttribute("nombre","btAnadirMensaje" );
      ((Element)v.get(174)).setAttribute("x","315" );
      ((Element)v.get(174)).setAttribute("y","690" );
      ((Element)v.get(174)).setAttribute("ID","botonContenido" );
      ((Element)v.get(174)).setAttribute("tipo","html" );
      ((Element)v.get(174)).setAttribute("estado","false" );
      ((Element)v.get(174)).setAttribute("cod","2483" );
      ((Element)v.get(174)).setAttribute("accion","accionAnadirMensaje()" );
      ((Element)v.get(9)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */

      /* Empieza nodo:175 / Elemento padre: 9   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(175)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(175)).setAttribute("alto","12" );
      ((Element)v.get(175)).setAttribute("ancho","50" );
      ((Element)v.get(175)).setAttribute("x","0" );
      ((Element)v.get(175)).setAttribute("y","712" );
      ((Element)v.get(9)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:9   */


   }

}
