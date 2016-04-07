
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_mensajes_recordatorios_generar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_mensajes_recordatorios_generar" );
      ((Element)v.get(0)).setAttribute("cod","0266" );
      ((Element)v.get(0)).setAttribute("titulo","Generar Mensajes Recordatorios" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Generar Mensajes Recordatorios" );
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
      v.add(doc.createTextNode("\r     \r      \r	function onLoadPag()   \r	{\r	    configurarMenuSecundario('frmFormulario');\r		fMostrarMensajeError();\r        ocultaLista(); \r		DrdEnsanchaConMargenDcho('listado1',12);\r        focaliza('frmFormulario.cbEtapa');\r		 btnProxy(2,0)\r	}\r  \r	function marcaOnChange(){\r		recargaCombos();	\r	}\r	\r	function canalOnChange(){\r		recargaCombos();	\r	}\r\r		function recargaCombos(){\r		if( get(\"frmFormulario.cbMarca\")!=\"\"  && get(\"frmFormulario.cbCanal\")!=\"\" ){\r			recargaCombo('frmFormulario.cbPeriodo', 'CRAObtienePeriodos', \r                'es.indra.sicc.dtos.cra.DTOPeriodo', arrMarcaCanal()); \r\r			recargaCombo('frmFormulario.cbSubgerenciaVentas', 'ZONRecargaSubgerenciaVentas', \r            'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', arrCanalMarca());\r		\r		}\r	}\r\r\r	\r	function arrMarcaCanal(){\r		 var arr = new Array();\r	 	 arr[arr.length] = new Array('pais',get('frmFormulario.oidPais'));\r		 arr[arr.length] = new Array('marca',get('frmFormulario.cbMarca'));	\r   	     arr[arr.length] = new Array('canal',get('frmFormulario.cbCanal'));	\r		 return arr;\r	}\r\r\r		function arrCanalMarca(){\r\r		 var arr = new Array();\r		 arr[arr.length] = new Array('oidPais',get('frmFormulario.oidPais'));\r		 arr[arr.length] = new Array('oidMarca',get('frmFormulario.cbMarca'));	\r		 arr[arr.length] = new Array('oidCanal',get('frmFormulario.cbCanal'));	\r		 return arr;\r	}\r\r	\r    function subGerenciaOnChange(){\r    /*\r    regargaCombo('regionDesde', 'ZONRecargaRegiones, 'DTOUnidadAdministrativa', [ ['oidSGV', get(subgerenciaVentas)]); \r    regargaCombo('regionHasta', 'ZONRecargaRegiones, 'DTOUnidadAdministrativa', [ ['oidSGV', get(subgerenciaVentas)]);\r    \r    */		\r\r	\r            var vSGV = get(\"frmFormulario.cbSubgerenciaVentas\");\r            if( vSGV != '' && vSGV != null )\r            {\r                recargaCombo('frmFormulario.cbRegionDesde', 'ZONRecargaRegiones', \r                    'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', arrOidSGV());\r\r                recargaCombo('frmFormulario.cbRegionHasta', 'ZONRecargaRegiones', \r                    'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', arrOidSGV());\r            }\r            else\r            {\r                var datosNuevo = new Array();\r                datosNuevo[0] = [\"\",\"\"];    \r                set_combo(\"frmFormulario.cbRegionDesde\", datosNuevo);\r                set_combo(\"frmFormulario.cbRegionHasta\", datosNuevo);\r                regionDesdeOnChange();\r                regionHastaOnChange();\r            }\r	}\r\rfunction arrOidSGV(){\r	var arr = new Array();\r	arr[arr.length] = new Array('oidPais', get('frmFormulario.oidPais'));\r	arr[arr.length] = new Array('oidSGV', get('frmFormulario.cbSubgerenciaVentas'));\r	return arr;\r}\r\r\r\r\r\r	function regionDesdeOnChange(){\r        var vRegionDesde = get(\"frmFormulario.cbRegionDesde\");\r        if( vRegionDesde != '' && vRegionDesde != null )\r        {\r		  recargaCombo(\"frmFormulario.cbZonaDesde\", 'ZONRecargaZonas', \r            'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', arrRegionDesde()); \r        }\r        else\r        {\r            var datosNuevo = new Array();\r            datosNuevo[0] = [\"\",\"\"];    \r            set_combo(\"frmFormulario.cbZonaDesde\", datosNuevo);            \r            zonaDesdeOnChange();\r        }\r	}\r\r\r	function regionHastaOnChange(){\r        var vRegionHasta = get(\"frmFormulario.cbRegionHasta\");\r        if( vRegionHasta != '' && vRegionHasta != null )\r        {\r            recargaCombo(\"frmFormulario.cbZonaHasta\", 'ZONRecargaZonas', \r            'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', arrRegionHasta()); \r        }\r        else\r        {\r            var datosNuevo = new Array();\r            datosNuevo[0] = [\"\",\"\"];    \r            set_combo(\"frmFormulario.cbZonaHasta\", datosNuevo);\r            zonaHastaOnChange();\r        }\r	} \r\r\r\r	function arrRegionDesde(){\r		var arr = new Array();\r		arr[arr.length] = new Array('oidIdioma',get(\"frmFormulario.oidIdioma\"));\r		arr[arr.length] = new Array('oidPais',get(\"frmFormulario.oidPais\"));\r		arr[arr.length] = new Array('oidRegion',get(\"frmFormulario.cbRegionDesde\"));\r		return arr;\r	}\r\r\r	function arrRegionHasta(){\r		var arr = new Array();\r		arr[arr.length] = new Array('oidIdioma',get(\"frmFormulario.oidIdioma\"));\r		arr[arr.length] = new Array('oidPais',get(\"frmFormulario.oidPais\"));\r		arr[arr.length] = new Array('oidRegion',get(\"frmFormulario.cbRegionHasta\"));\r		return arr;\r	}\r\r	function zonaDesdeOnChange(){\r        var vZona = get(\"frmFormulario.cbZonaDesde\");\r        if( vZona != '' && vZona != null )\r        {\r            recargaCombo(\"frmFormulario.cbSeccionDesde\", 'ZONRecargaSecciones', \r                'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', arrZonaDesde());\r        }\r        else\r        {\r            var datosNuevo = new Array();\r            datosNuevo[0] = [\"\",\"\"];    \r            set_combo(\"frmFormulario.cbSeccionDesde\", datosNuevo);\r            seccionDesdeOnChange();\r        }\r	}\r\r	function zonaHastaOnChange(){\r\r        var vZonaHasta = get(\"frmFormulario.cbZonaHasta\");\r        if( vZonaHasta != '' && vZonaHasta != null )\r        {\r            recargaCombo(\"frmFormulario.cbSeccionHasta\", 'ZONRecargaSecciones', \r                'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', arrZonaHasta());\r        }\r        else\r        {\r            var datosNuevo = new Array();\r            datosNuevo[0] = [\"\",\"\"];    \r            set_combo(\"frmFormulario.cbSeccionHasta\", datosNuevo);\r            seccionHastaOnChange();\r        }\r	}\r\r	function arrZonaDesde(){\r		var arr = new Array();\r		arr[arr.length] = new Array('oidIdioma',get(\"frmFormulario.oidIdioma\"));\r		arr[arr.length] = new Array('oidPais',get(\"frmFormulario.oidPais\"));\r		arr[arr.length] = new Array('oidZona',get(\"frmFormulario.cbZonaDesde\"));\r		return arr;\r	}\r\r\r	function arrZonaHasta(){\r		var arr = new Array();\r		arr[arr.length] = new Array('oidIdioma',get(\"frmFormulario.oidIdioma\"));\r		arr[arr.length] = new Array('oidPais',get(\"frmFormulario.oidPais\"));\r		arr[arr.length] = new Array('oidZona',get(\"frmFormulario.cbZonaHasta\"));\r		return arr;\r	}\r\r\r    function onClickBuscar(){\r\r        if(sicc_validaciones_generales(\"g1\")){\r\r			if (validarValores()){\r                tomarValores();\r\r               configurarPaginado(mipgndo,'COBBuscarClientesAsignados',\r                'ConectorBuscarClientesAsignados','es.indra.sicc.dtos.cob.DTOBuscarClientesAsignados', \r                armarArray()); \r            }\r        }\r    }\r\r    function tomarValores()\r    {\r        var regionDesde = get('frmFormulario.cbRegionDesde','V');\r        var regionHasta = get('frmFormulario.cbRegionHasta','V');\r        var zonaDesde = get('frmFormulario.cbZonaDesde','V');\r        var zonaHasta = get('frmFormulario.cbZonaHasta','V');\r        var seccionDesde = get('frmFormulario.cbSeccionDesde','V');\r        var seccionHasta = get('frmFormulario.cbSeccionHasta','V');\r        var terrDesde = get('frmFormulario.txtTerritorioDesde');\r        var terrHasta = get('frmFormulario.txtTerritorioHasta');\r        var oidSeleccionados = 0;\r    \r    /*------------------------ Obligatorios ------------------------*/\r        set('frmFormulario.etapa', get('frmFormulario.cbEtapa','V') );\r        set('frmFormulario.marca', get('frmFormulario.cbMarca','V') );\r        set('frmFormulario.canal', get('frmFormulario.cbCanal','V') );\r        set('frmFormulario.periodo', get('frmFormulario.cbPeriodo','V') );\r        set('frmFormulario.subGerenciaVenta', get('frmFormulario.cbSubgerenciaVentas','V'));\r    \r    /*------------------------ Opcionales ------------------------*/\r        if (regionDesde != null && regionDesde != '')\r            set('frmFormulario.regionDesde',regionDesde );\r        \r        if (regionHasta != null && regionHasta != '')    \r            set('frmFormulario.regionHasta',regionHasta );\r        \r        if (zonaDesde != null && zonaDesde != '')\r            set('frmFormulario.zonaDesde', zonaDesde );\r        \r        if (zonaHasta != null && zonaHasta != '')\r            set('frmFormulario.zonaHasta', zonaHasta );\r        \r        if (seccionDesde != null && seccionDesde != '')            \r            set('frmFormulario.seccionDesde',seccionDesde );\r        \r        if (seccionHasta != null && seccionHasta != '')            \r            set('frmFormulario.seccionHasta', seccionHasta );\r        \r        if (terrDesde != null && terrDesde != '')            \r            set('frmFormulario.territorioDesde',terrDesde);\r        \r        if (terrHasta != null && terrHasta != '')            \r            set('frmFormulario.territorioHasta',terrHasta);\r        \r           \r    }\r\r    function armarArray(){\r        var arr = new Array();\r        arr[arr.length] = new Array('oidIdioma',get('frmFormulario.oidIdioma'));\r        arr[arr.length] = new Array('oidPais',get('frmFormulario.oidPais'));\r        \r     if (get('frmFormulario.cbEtapa','V')!='')\r            arr[arr.length] = new Array('etapa', get('frmFormulario.cbEtapa','V'));\r        if (get('frmFormulario.cbMarca','V')!='')\r            arr[arr.length] = new Array('marca', get('frmFormulario.cbMarca','V'));\r        if (get('frmFormulario.cbCanal','V')!='')\r            arr[arr.length] = new Array('canal', get('frmFormulario.cbCanal','V'));\r        if (get('frmFormulario.cbPeriodo','V')!='')\r        	arr[arr.length] = new Array('periodo', get('frmFormulario.cbPeriodo','V'));\r                    if (get('frmFormulario.cbSubgerenciaVentas','V')!='')    \r            arr[arr.length] = new Array('subgerenciaVentas', get('frmFormulario.cbSubgerenciaVentas','V'));    \r        if (get('frmFormulario.cbRegionDesde','V')!='')\r            arr[arr.length] = new Array('regionDesde', get('frmFormulario.cbRegionDesde','V'));\r        if (get('frmFormulario.cbRegionHasta','V')!='')    \r            arr[arr.length] = new Array('regionHasta', get('frmFormulario.cbRegionHasta','V'));\r        if (get('frmFormulario.cbZonaDesde','V')!='')    \r            arr[arr.length] = new Array('zonaDesde', get('frmFormulario.cbZonaDesde','V'));\r        if (get('frmFormulario.cbZonaHasta','V')!='')                    \r            arr[arr.length] = new Array('zonaHasta', get('frmFormulario.cbZonaHasta','V'));\r        if (get('frmFormulario.cbSeccionDesde','V')!='')    \r            arr[arr.length] = new Array('seccionDesde', get('frmFormulario.cbSeccionDesde','V'));\r        if (get('frmFormulario.cbSeccionHasta','V')!='')    \r            arr[arr.length] = new Array('seccionHasta', get('frmFormulario.cbSeccionHasta','V'));\r        if (get('frmFormulario.txtTerritorioDesde')!='')    \r            arr[arr.length] = new Array('territorioDesde', get('frmFormulario.txtTerritorioDesde'));\r        if (get('frmFormulario.txtTerritorioHasta')!='')    \r            arr[arr.length] = new Array('territorioHasta', get('frmFormulario.txtTerritorioHasta'));\r   \r        return arr;\r    }\r\r\r    function accionGenerarMensajes(){\r        \r        if (listado1.numSelecc() != 0) {\r            var obj = new Object();\r            var lValores = listado2String();\r            obj.oidEtapa    = get('frmFormulario.cbEtapa',  'V');\r            obj.oidMarca    = get('frmFormulario.cbMarca',  'V');\r            obj.oidCanal    = get('frmFormulario.cbCanal',  'V');\r            obj.oidPeriodo  = get('frmFormulario.cbPeriodo','V');\r            obj.oidSeleccionados = lValores;\r            obj.accion = \"generarMensajes\";\r            \r            mostrarModalSICC('LPGenerarMensajesRecordatorios','generarMensajes',obj,800,300);	\r        } \r        else {\r           GestionarMensaje('1022',null,null,null);\r           return false;\r        }\r    }\r        \r    function listado2String(){\r        \r        codigo = listado1.codSeleccionados();\r        \r        var total = \"\";\r		for(var a = 0; a < codigo.length ; a++)\r		{\r            var toAdd = \"\";\r			toAdd = toAdd + \"|\" + \"oid:\" + codigo[a];				toAdd = toAdd + \"|\" + \"asigna:\" + listado1.extraeDato(codigo[a], 0);\r			toAdd = toAdd + \"|\" + \"codigo:\" + listado1.extraeDato(codigo[a], 1);\r            toAdd = toAdd + \"|\" + \"nombre:\" + listado1.extraeDato(codigo[a], 2);\r			toAdd = toAdd + \"|\" + \"usucobra:\" + listado1.extraeDato(codigo[a], 3);\r            toAdd = toAdd + \"|\" + \"importe:\" + listado1.extraeDato(codigo[a], 4);\r            total = total + \"$\" + toAdd;\r        }\r\r       return total;\r    }\r    \r    function validarValores()\r    {\r        if (get('frmFormulario.cbRegionHasta','V')!=''){\r            if (get('frmFormulario.cbRegionDesde','V')=='')\r            {\r                GestionarMensaje('1484','Region');\r                return false;\r            }\r        }\r        \r        if (get('frmFormulario.cbZonaHasta','V')!=''){\r            if (get('frmFormulario.cbZonaDesde','V')=='')\r            {\r                GestionarMensaje('1484','Zona');\r                return false;\r            }\r        }\r        \r        if (get('frmFormulario.cbSeccionHasta','V')!=''){\r            if (get('frmFormulario.cbSeccionDesde','V')=='')\r            {\r                GestionarMensaje('1484','Seccion');\r                return false;\r            }\r        }\r        \r        if (get('frmFormulario.txtTerritorioHasta')!=''){\r            if (get('frmFormulario.txtTerritorioDesde')=='')\r            {\r                GestionarMensaje('1484','Territorio');\r                return false;\r            }\r        }\r        \r		if (get('frmFormulario.txtTerritorioDesde')!=''){\r            if (get('frmFormulario.txtTerritorioHasta')=='')\r            {\r                GestionarMensaje('1484','Territorio');\r                return false;\r            }\r        }\r\r        return true\r    }\r    \r        function trataLista(ultima, rowset, error){\r        var tamano = rowset.length;\r    \r		if (tamano !=0) {\r            document.all[\"Cplistado1\"].style.visibility='visible';\r            document.all[\"CpLin1listado1\"].style.visibility='visible';\r            document.all[\"CpLin2listado1\"].style.visibility='visible';\r            document.all[\"CpLin3listado1\"].style.visibility='visible';\r            document.all[\"CpLin4listado1\"].style.visibility='visible';\r    \r            document.all[\"primera1Div\"].style.visibility='visible';\r            document.all[\"ret1Div\"].style.visibility='visible';\r            document.all[\"ava1Div\"].style.visibility='visible';\r            document.all[\"separaDiv\"].style.visibility='visible';\r            document.all[\"GenerarMensajesDiv\"].style.visibility='visible';\r            eval (ON_RSZ); \r            return true;\r        }\r        else\r        {\r            ocultaLista();\r            cdos_mostrarAlert(error);\r            return false;\r        }\r    }\r    \r    function ocultaLista()\r    {\r        document.all[\"Cplistado1\"].style.visibility='hidden';\r	    document.all[\"CpLin1listado1\"].style.visibility='hidden';\r	    document.all[\"CpLin2listado1\"].style.visibility='hidden';\r	    document.all[\"CpLin3listado1\"].style.visibility='hidden';\r	    document.all[\"CpLin4listado1\"].style.visibility='hidden';\r\r	    document.all[\"primera1Div\"].style.visibility='hidden';\r	    document.all[\"ret1Div\"].style.visibility='hidden';\r	    document.all[\"ava1Div\"].style.visibility='hidden';\r	    document.all[\"separaDiv\"].style.visibility='hidden';\r        document.all[\"GenerarMensajesDiv\"].style.visibility='hidden';\r\r	    eval (ON_RSZ); \r    }\r\r\rfunction fLimpiar(){\r	var arr = new Array();  \r	arr[0] = \"\";\r	set('frmFormulario.cbEtapa',arr);\r	set('frmFormulario.cbMarca',arr);\r	set('frmFormulario.cbCanal',arr);\r	var aCombo = new Array(new Array(\"\",\"\"));\r    set_combo('frmFormulario.cbPeriodo',aCombo, []);\r	set_combo('frmFormulario.cbSubgerenciaVentas',aCombo, []);\r	set_combo('frmFormulario.cbRegionDesde',aCombo, []);\r	set_combo('frmFormulario.cbRegionHasta',aCombo, []);\r	set_combo('frmFormulario.cbZonaDesde',aCombo, []);\r	set_combo('frmFormulario.cbZonaHasta',aCombo, []);\r	set_combo('frmFormulario.cbSeccionDesde',aCombo, []);\r	set_combo('frmFormulario.cbSeccionHasta',aCombo, []);\r	set('frmFormulario.txtTerritorioDesde',\"\");\r	set('frmFormulario.txtTerritorioHasta',\"\");\r  \r    focaliza(\"frmFormulario.cbEtapa\");\r}\r\r\r\r		function focoBoton(){\r			focalizaBotonHTML('btnBuscar');\r		}\r\r		function focoTerri(){\r			focaliza(\"frmFormulario.txtTerritorioDesde\");\r		}\r\r		function focoCbEtapa(){\r			focaliza(\"frmFormulario.cbEtapa\");\r		}\r\r		function focoTerri2(){\r			focaliza(\"frmFormulario.txtTerritorioHasta\");\r		}\r\r		function focoEtapaBtn(){\r			focalizaBotonHTML('btnBuscar');\r		}\r    \r    \r    \r    \r    \r        \r    \r    function focalizaTab(){\r      if(document.all[\"Cplistado1\"].style.visibility=='hidden'){\r          focaliza(\"frmFormulario.cbEtapa\");\r      }else{\r          focalizaBotonHTML_XY('GenerarMensajes');\r     }\r    }\r  \r  \r  function focalizaShTab(){  \r		if(document.all[\"Cplistado1\"].style.visibility=='hidden'){\r			focalizaBotonHTML('botonContenido','btnBuscar');\r		}else{\r				focalizaBotonHTML_XY('GenerarMensajes');\r			}\r    }\r  \r  \r  \r    \r    \r    \r    \r    \r    \r    \r    \r    \r\r  "));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","cbEtapa" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","865" );
      ((Element)v.get(7)).setAttribute("group","g1" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cbMarca" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","6" );
      ((Element)v.get(8)).setAttribute("group","g1" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","cbCanal" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","7" );
      ((Element)v.get(9)).setAttribute("group","g1" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","cbPeriodo" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","30" );
      ((Element)v.get(10)).setAttribute("group","g1" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","cbSubgerenciaVentas" );
      ((Element)v.get(11)).setAttribute("required","true" );
      ((Element)v.get(11)).setAttribute("cod","124" );
      ((Element)v.get(11)).setAttribute("group","g1" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */
      /* Termina nodo:6   */

      /* Empieza nodo:12 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(12)).setAttribute("nombre","frmFormulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(12));

      /* Empieza nodo:13 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","accion" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","oidIdioma" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","oidPais" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","etapa" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 12   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","marca" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","canal" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","periodo" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","subGerenciaVenta" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","regionDesde" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","regionHasta" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","zonaDesde" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","zonaHasta" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","seccionDesde" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","seccionHasta" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","territorioDesde" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","territorioHasta" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","oidEtapa" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","oidMarca" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","oidCanal" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","oidPeriodo" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","oidSeleccionados" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 12   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(38)).setAttribute("nombre","capaEspacio1" );
      ((Element)v.get(38)).setAttribute("x","0" );
      ((Element)v.get(38)).setAttribute("y","0" );
      ((Element)v.get(12)).appendChild((Element)v.get(38));

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
      ((Element)v.get(42)).setAttribute("width","12" );
      ((Element)v.get(42)).setAttribute("height","12" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:43 / Elemento padre: 40   */
   }

   private void getXML180(Document doc) {
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
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(53)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(53)).setAttribute("alto","13" );
      ((Element)v.get(53)).setAttribute("filas","1" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(53)).setAttribute("id","legend" );
      ((Element)v.get(53)).setAttribute("cod","0075" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:54 / Elemento padre: 51   */
      v.add(doc.createElement("table"));
      ((Element)v.get(54)).setAttribute("width","100%" );
      ((Element)v.get(54)).setAttribute("border","0" );
      ((Element)v.get(54)).setAttribute("align","center" );
      ((Element)v.get(54)).setAttribute("cellspacing","0" );
      ((Element)v.get(54)).setAttribute("cellpadding","0" );
      ((Element)v.get(51)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("table"));
      ((Element)v.get(57)).setAttribute("width","661" );
      ((Element)v.get(57)).setAttribute("border","0" );
      ((Element)v.get(57)).setAttribute("align","left" );
      ((Element)v.get(57)).setAttribute("cellspacing","0" );
      ((Element)v.get(57)).setAttribute("cellpadding","0" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).setAttribute("colspan","3" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(60)).setAttribute("src","b.gif" );
      ((Element)v.get(60)).setAttribute("width","8" );
      ((Element)v.get(60)).setAttribute("height","8" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:61 / Elemento padre: 57   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(57)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(63)).setAttribute("src","b.gif" );
      ((Element)v.get(63)).setAttribute("width","8" );
      ((Element)v.get(63)).setAttribute("height","8" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:64 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(65)).setAttribute("nombre","lblEtapa" );
      ((Element)v.get(65)).setAttribute("alto","13" );
      ((Element)v.get(65)).setAttribute("filas","1" );
      ((Element)v.get(65)).setAttribute("valor","" );
      ((Element)v.get(65)).setAttribute("id","datosTitle" );
      ((Element)v.get(65)).setAttribute("cod","865" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:66 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).setAttribute("width","100%" );
      ((Element)v.get(61)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(67)).setAttribute("src","b.gif" );
      ((Element)v.get(67)).setAttribute("width","8" );
      ((Element)v.get(67)).setAttribute("height","8" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:61   */

      /* Empieza nodo:68 / Elemento padre: 57   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(68)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(57)).appendChild((Element)v.get(68));

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
      ((Element)v.get(71)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(68)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(72)).setAttribute("nombre","cbEtapa" );
      ((Element)v.get(72)).setAttribute("id","datosCampos" );
      ((Element)v.get(72)).setAttribute("size","1" );
      ((Element)v.get(72)).setAttribute("multiple","N" );
      ((Element)v.get(72)).setAttribute("req","S" );
      ((Element)v.get(72)).setAttribute("valorinicial","" );
      ((Element)v.get(72)).setAttribute("textoinicial","" );
      ((Element)v.get(72)).setAttribute("onshtab","focalizaShTab();" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:74 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).setAttribute("width","100%" );
      ((Element)v.get(68)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(75)).setAttribute("width","8" );
      ((Element)v.get(75)).setAttribute("height","8" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:68   */

      /* Empieza nodo:76 / Elemento padre: 57   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(57)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).setAttribute("colspan","3" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(78)).setAttribute("width","8" );
      ((Element)v.get(78)).setAttribute("height","7" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */
      /* Termina nodo:76   */
      /* Termina nodo:57   */
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:79 / Elemento padre: 54   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(54)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("table"));
      ((Element)v.get(81)).setAttribute("width","661" );
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
      ((Element)v.get(86)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(86)).setAttribute("alto","13" );
      ((Element)v.get(86)).setAttribute("filas","1" );
      ((Element)v.get(86)).setAttribute("valor","" );
      ((Element)v.get(86)).setAttribute("id","datosTitle" );
      ((Element)v.get(86)).setAttribute("cod","6" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(88)).setAttribute("src","b.gif" );
      ((Element)v.get(88)).setAttribute("width","25" );
      ((Element)v.get(88)).setAttribute("height","8" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:89 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(90)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(90)).setAttribute("alto","13" );
      ((Element)v.get(90)).setAttribute("filas","1" );
      ((Element)v.get(90)).setAttribute("valor","" );
      ((Element)v.get(90)).setAttribute("id","datosTitle" );
      ((Element)v.get(90)).setAttribute("cod","7" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:91 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).setAttribute("width","100%" );
      ((Element)v.get(82)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(92)).setAttribute("width","8" );
      ((Element)v.get(92)).setAttribute("height","8" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */
      /* Termina nodo:82   */

      /* Empieza nodo:93 / Elemento padre: 81   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(81)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(95)).setAttribute("src","b.gif" );
      ((Element)v.get(95)).setAttribute("width","8" );
      ((Element)v.get(95)).setAttribute("height","8" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:96 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(93)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(97)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(97)).setAttribute("id","datosCampos" );
      ((Element)v.get(97)).setAttribute("size","1" );
      ((Element)v.get(97)).setAttribute("multiple","N" );
      ((Element)v.get(97)).setAttribute("req","S" );
      ((Element)v.get(97)).setAttribute("valorinicial","" );
      ((Element)v.get(97)).setAttribute("textoinicial","" );
      ((Element)v.get(97)).setAttribute("onchange","marcaOnChange()" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:99 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(100)).setAttribute("src","b.gif" );
      ((Element)v.get(100)).setAttribute("width","25" );
      ((Element)v.get(100)).setAttribute("height","8" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:101 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(101)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(93)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(102)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(102)).setAttribute("id","datosCampos" );
      ((Element)v.get(102)).setAttribute("size","1" );
      ((Element)v.get(102)).setAttribute("multiple","N" );
      ((Element)v.get(102)).setAttribute("req","S" );
      ((Element)v.get(102)).setAttribute("valorinicial","" );
      ((Element)v.get(102)).setAttribute("textoinicial","" );
      ((Element)v.get(102)).setAttribute("onchange","canalOnChange()" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:104 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).setAttribute("width","100%" );
      ((Element)v.get(93)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(105)).setAttribute("src","b.gif" );
      ((Element)v.get(105)).setAttribute("width","8" );
      ((Element)v.get(105)).setAttribute("height","8" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */
      /* Termina nodo:93   */

      /* Empieza nodo:106 / Elemento padre: 81   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(81)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).setAttribute("colspan","3" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(108)).setAttribute("src","b.gif" );
      ((Element)v.get(108)).setAttribute("width","8" );
      ((Element)v.get(108)).setAttribute("height","7" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */
      /* Termina nodo:106   */
      /* Termina nodo:81   */
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:109 / Elemento padre: 54   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(54)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("table"));
      ((Element)v.get(111)).setAttribute("width","661" );
      ((Element)v.get(111)).setAttribute("border","0" );
      ((Element)v.get(111)).setAttribute("align","left" );
      ((Element)v.get(111)).setAttribute("cellspacing","0" );
      ((Element)v.get(111)).setAttribute("cellpadding","0" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(114)).setAttribute("src","b.gif" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(114)).setAttribute("width","8" );
      ((Element)v.get(114)).setAttribute("height","8" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:115 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(116)).setAttribute("nombre","lblPeriodo" );
      ((Element)v.get(116)).setAttribute("alto","13" );
      ((Element)v.get(116)).setAttribute("filas","1" );
      ((Element)v.get(116)).setAttribute("valor","" );
      ((Element)v.get(116)).setAttribute("id","datosTitle" );
      ((Element)v.get(116)).setAttribute("cod","276" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:117 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(118)).setAttribute("src","b.gif" );
      ((Element)v.get(118)).setAttribute("width","25" );
      ((Element)v.get(118)).setAttribute("height","8" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:119 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(120)).setAttribute("nombre","lblSubgerenciaVentas" );
      ((Element)v.get(120)).setAttribute("alto","13" );
      ((Element)v.get(120)).setAttribute("filas","1" );
      ((Element)v.get(120)).setAttribute("valor","" );
      ((Element)v.get(120)).setAttribute("id","datosTitle" );
      ((Element)v.get(120)).setAttribute("cod","124" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:121 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(121)).setAttribute("width","100%" );
      ((Element)v.get(112)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(122)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).setAttribute("width","8" );
      ((Element)v.get(122)).setAttribute("height","8" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */
      /* Termina nodo:112   */

      /* Empieza nodo:123 / Elemento padre: 111   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(111)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(125)).setAttribute("src","b.gif" );
      ((Element)v.get(125)).setAttribute("width","8" );
      ((Element)v.get(125)).setAttribute("height","8" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */

      /* Empieza nodo:126 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(123)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(127)).setAttribute("nombre","cbPeriodo" );
      ((Element)v.get(127)).setAttribute("id","datosCampos" );
      ((Element)v.get(127)).setAttribute("size","1" );
      ((Element)v.get(127)).setAttribute("multiple","N" );
      ((Element)v.get(127)).setAttribute("req","S" );
      ((Element)v.get(127)).setAttribute("valorinicial","" );
      ((Element)v.get(127)).setAttribute("textoinicial","" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */
      /* Termina nodo:126   */

      /* Empieza nodo:129 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(130)).setAttribute("src","b.gif" );
      ((Element)v.get(130)).setAttribute("width","25" );
      ((Element)v.get(130)).setAttribute("height","8" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:131 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(123)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(132)).setAttribute("nombre","cbSubgerenciaVentas" );
      ((Element)v.get(132)).setAttribute("id","datosCampos" );
      ((Element)v.get(132)).setAttribute("size","1" );
      ((Element)v.get(132)).setAttribute("multiple","N" );
      ((Element)v.get(132)).setAttribute("req","S" );
      ((Element)v.get(132)).setAttribute("valorinicial","" );
      ((Element)v.get(132)).setAttribute("textoinicial","" );
      ((Element)v.get(132)).setAttribute("onchange","subGerenciaOnChange()" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:134 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).setAttribute("width","100%" );
      ((Element)v.get(123)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(135)).setAttribute("src","b.gif" );
      ((Element)v.get(135)).setAttribute("width","8" );
      ((Element)v.get(135)).setAttribute("height","8" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */
      /* Termina nodo:123   */

      /* Empieza nodo:136 / Elemento padre: 111   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(111)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(137)).setAttribute("colspan","5" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(138)).setAttribute("src","b.gif" );
      ((Element)v.get(138)).setAttribute("width","8" );
      ((Element)v.get(138)).setAttribute("height","7" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */
      /* Termina nodo:136   */
      /* Termina nodo:111   */
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:139 / Elemento padre: 54   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(54)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("table"));
      ((Element)v.get(141)).setAttribute("width","661" );
      ((Element)v.get(141)).setAttribute("border","0" );
      ((Element)v.get(141)).setAttribute("align","left" );
      ((Element)v.get(141)).setAttribute("cellspacing","0" );
      ((Element)v.get(141)).setAttribute("cellpadding","0" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(144)).setAttribute("src","b.gif" );
      ((Element)v.get(144)).setAttribute("width","8" );
      ((Element)v.get(144)).setAttribute("height","8" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */

      /* Empieza nodo:145 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(146)).setAttribute("nombre","lblRegionDesde" );
      ((Element)v.get(146)).setAttribute("alto","13" );
      ((Element)v.get(146)).setAttribute("filas","1" );
      ((Element)v.get(146)).setAttribute("valor","" );
      ((Element)v.get(146)).setAttribute("id","datosTitle" );
      ((Element)v.get(146)).setAttribute("cod","982" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */

      /* Empieza nodo:147 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(148)).setAttribute("src","b.gif" );
      ((Element)v.get(148)).setAttribute("width","25" );
      ((Element)v.get(148)).setAttribute("height","8" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */

      /* Empieza nodo:149 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(150)).setAttribute("nombre","lblRegionHasta" );
      ((Element)v.get(150)).setAttribute("alto","13" );
      ((Element)v.get(150)).setAttribute("filas","1" );
      ((Element)v.get(150)).setAttribute("valor","" );
      ((Element)v.get(150)).setAttribute("id","datosTitle" );
      ((Element)v.get(150)).setAttribute("cod","983" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */

      /* Empieza nodo:151 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(151)).setAttribute("width","100%" );
      ((Element)v.get(142)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(152)).setAttribute("src","b.gif" );
      ((Element)v.get(152)).setAttribute("width","8" );
      ((Element)v.get(152)).setAttribute("height","8" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */
      /* Termina nodo:142   */

      /* Empieza nodo:153 / Elemento padre: 141   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(141)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(155)).setAttribute("src","b.gif" );
      ((Element)v.get(155)).setAttribute("width","8" );
      ((Element)v.get(155)).setAttribute("height","8" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */

      /* Empieza nodo:156 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(157)).setAttribute("nombre","cbRegionDesde" );
      ((Element)v.get(157)).setAttribute("id","datosCampos" );
      ((Element)v.get(157)).setAttribute("size","1" );
      ((Element)v.get(157)).setAttribute("multiple","N" );
      ((Element)v.get(157)).setAttribute("req","N" );
      ((Element)v.get(157)).setAttribute("valorinicial","" );
      ((Element)v.get(157)).setAttribute("textoinicial","" );
      ((Element)v.get(157)).setAttribute("onchange","regionDesdeOnChange()" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */
      /* Termina nodo:156   */

      /* Empieza nodo:159 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
   }

   private void getXML630(Document doc) {
      ((Element)v.get(153)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(160)).setAttribute("src","b.gif" );
      ((Element)v.get(160)).setAttribute("width","25" );
      ((Element)v.get(160)).setAttribute("height","8" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:161 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(162)).setAttribute("nombre","cbRegionHasta" );
      ((Element)v.get(162)).setAttribute("id","datosCampos" );
      ((Element)v.get(162)).setAttribute("size","1" );
      ((Element)v.get(162)).setAttribute("multiple","N" );
      ((Element)v.get(162)).setAttribute("req","N" );
      ((Element)v.get(162)).setAttribute("valorinicial","" );
      ((Element)v.get(162)).setAttribute("textoinicial","" );
      ((Element)v.get(162)).setAttribute("onchange","regionHastaOnChange()" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:164 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
      ((Element)v.get(164)).setAttribute("width","100%" );
      ((Element)v.get(153)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(165)).setAttribute("src","b.gif" );
      ((Element)v.get(165)).setAttribute("width","8" );
      ((Element)v.get(165)).setAttribute("height","8" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */
      /* Termina nodo:153   */

      /* Empieza nodo:166 / Elemento padre: 141   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(141)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).setAttribute("colspan","3" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(168)).setAttribute("src","b.gif" );
      ((Element)v.get(168)).setAttribute("width","8" );
      ((Element)v.get(168)).setAttribute("height","7" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */
      /* Termina nodo:166   */
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:169 / Elemento padre: 54   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(54)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("td"));
      ((Element)v.get(169)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("table"));
      ((Element)v.get(171)).setAttribute("width","661" );
      ((Element)v.get(171)).setAttribute("border","0" );
      ((Element)v.get(171)).setAttribute("align","left" );
      ((Element)v.get(171)).setAttribute("cellspacing","0" );
      ((Element)v.get(171)).setAttribute("cellpadding","0" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(171)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(174)).setAttribute("src","b.gif" );
      ((Element)v.get(174)).setAttribute("width","8" );
      ((Element)v.get(174)).setAttribute("height","8" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */

      /* Empieza nodo:175 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(176)).setAttribute("nombre","lblZonaDesde" );
      ((Element)v.get(176)).setAttribute("alto","13" );
      ((Element)v.get(176)).setAttribute("filas","1" );
      ((Element)v.get(176)).setAttribute("valor","" );
      ((Element)v.get(176)).setAttribute("id","datosTitle" );
      ((Element)v.get(176)).setAttribute("cod","1040" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:177 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(178)).setAttribute("src","b.gif" );
      ((Element)v.get(178)).setAttribute("width","25" );
      ((Element)v.get(178)).setAttribute("height","8" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */

      /* Empieza nodo:179 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(180)).setAttribute("nombre","lblZonaHasta" );
      ((Element)v.get(180)).setAttribute("alto","13" );
      ((Element)v.get(180)).setAttribute("filas","1" );
      ((Element)v.get(180)).setAttribute("valor","" );
      ((Element)v.get(180)).setAttribute("id","datosTitle" );
      ((Element)v.get(180)).setAttribute("cod","1041" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:181 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(181)).setAttribute("width","100%" );
      ((Element)v.get(172)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(182)).setAttribute("src","b.gif" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(182)).setAttribute("width","8" );
      ((Element)v.get(182)).setAttribute("height","8" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */
      /* Termina nodo:172   */

      /* Empieza nodo:183 / Elemento padre: 171   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(171)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("td"));
      ((Element)v.get(183)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(185)).setAttribute("src","b.gif" );
      ((Element)v.get(185)).setAttribute("width","8" );
      ((Element)v.get(185)).setAttribute("height","8" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:184   */

      /* Empieza nodo:186 / Elemento padre: 183   */
      v.add(doc.createElement("td"));
      ((Element)v.get(183)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(187)).setAttribute("nombre","cbZonaDesde" );
      ((Element)v.get(187)).setAttribute("id","datosCampos" );
      ((Element)v.get(187)).setAttribute("size","1" );
      ((Element)v.get(187)).setAttribute("multiple","N" );
      ((Element)v.get(187)).setAttribute("req","N" );
      ((Element)v.get(187)).setAttribute("valorinicial","" );
      ((Element)v.get(187)).setAttribute("textoinicial","" );
      ((Element)v.get(187)).setAttribute("onchange","zonaDesdeOnChange()" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */
      /* Termina nodo:186   */

      /* Empieza nodo:189 / Elemento padre: 183   */
      v.add(doc.createElement("td"));
      ((Element)v.get(183)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(190)).setAttribute("src","b.gif" );
      ((Element)v.get(190)).setAttribute("width","25" );
      ((Element)v.get(190)).setAttribute("height","8" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:191 / Elemento padre: 183   */
      v.add(doc.createElement("td"));
      ((Element)v.get(183)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(192)).setAttribute("nombre","cbZonaHasta" );
      ((Element)v.get(192)).setAttribute("id","datosCampos" );
      ((Element)v.get(192)).setAttribute("size","1" );
      ((Element)v.get(192)).setAttribute("multiple","N" );
      ((Element)v.get(192)).setAttribute("req","N" );
      ((Element)v.get(192)).setAttribute("valorinicial","" );
      ((Element)v.get(192)).setAttribute("textoinicial","" );
      ((Element)v.get(192)).setAttribute("onchange","zonaHastaOnChange()" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */
      /* Termina nodo:191   */

      /* Empieza nodo:194 / Elemento padre: 183   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).setAttribute("width","100%" );
      ((Element)v.get(183)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(195)).setAttribute("src","b.gif" );
      ((Element)v.get(195)).setAttribute("width","8" );
      ((Element)v.get(195)).setAttribute("height","8" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */
      /* Termina nodo:183   */

      /* Empieza nodo:196 / Elemento padre: 171   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(171)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("td"));
      ((Element)v.get(197)).setAttribute("colspan","3" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(198)).setAttribute("src","b.gif" );
      ((Element)v.get(198)).setAttribute("width","8" );
      ((Element)v.get(198)).setAttribute("height","7" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */
      /* Termina nodo:196   */
      /* Termina nodo:171   */
      /* Termina nodo:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:199 / Elemento padre: 54   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(54)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("table"));
      ((Element)v.get(201)).setAttribute("width","661" );
      ((Element)v.get(201)).setAttribute("border","0" );
      ((Element)v.get(201)).setAttribute("align","left" );
      ((Element)v.get(201)).setAttribute("cellspacing","0" );
      ((Element)v.get(201)).setAttribute("cellpadding","0" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(201)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(202)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(204)).setAttribute("src","b.gif" );
      ((Element)v.get(204)).setAttribute("width","8" );
      ((Element)v.get(204)).setAttribute("height","8" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */

      /* Empieza nodo:205 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(202)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(206)).setAttribute("nombre","lblSeccionDesde" );
      ((Element)v.get(206)).setAttribute("alto","13" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(206)).setAttribute("filas","1" );
      ((Element)v.get(206)).setAttribute("valor","" );
      ((Element)v.get(206)).setAttribute("id","datosTitle" );
      ((Element)v.get(206)).setAttribute("cod","985" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */

      /* Empieza nodo:207 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(202)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(208)).setAttribute("src","b.gif" );
      ((Element)v.get(208)).setAttribute("width","25" );
      ((Element)v.get(208)).setAttribute("height","8" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:207   */

      /* Empieza nodo:209 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(202)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(210)).setAttribute("nombre","lblSeccionHasta" );
      ((Element)v.get(210)).setAttribute("alto","13" );
      ((Element)v.get(210)).setAttribute("filas","1" );
      ((Element)v.get(210)).setAttribute("valor","" );
      ((Element)v.get(210)).setAttribute("id","datosTitle" );
      ((Element)v.get(210)).setAttribute("cod","986" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */
      /* Termina nodo:209   */

      /* Empieza nodo:211 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(211)).setAttribute("width","100%" );
      ((Element)v.get(202)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(212)).setAttribute("src","b.gif" );
      ((Element)v.get(212)).setAttribute("width","8" );
      ((Element)v.get(212)).setAttribute("height","8" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:211   */
      /* Termina nodo:202   */

      /* Empieza nodo:213 / Elemento padre: 201   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(201)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("td"));
      ((Element)v.get(213)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(215)).setAttribute("src","b.gif" );
      ((Element)v.get(215)).setAttribute("width","8" );
      ((Element)v.get(215)).setAttribute("height","8" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:214   */

      /* Empieza nodo:216 / Elemento padre: 213   */
      v.add(doc.createElement("td"));
      ((Element)v.get(213)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(217)).setAttribute("nombre","cbSeccionDesde" );
      ((Element)v.get(217)).setAttribute("id","datosCampos" );
      ((Element)v.get(217)).setAttribute("size","1" );
      ((Element)v.get(217)).setAttribute("multiple","N" );
      ((Element)v.get(217)).setAttribute("req","N" );
      ((Element)v.get(217)).setAttribute("valorinicial","" );
      ((Element)v.get(217)).setAttribute("textoinicial","" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(217)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */
      /* Termina nodo:217   */
      /* Termina nodo:216   */

      /* Empieza nodo:219 / Elemento padre: 213   */
      v.add(doc.createElement("td"));
      ((Element)v.get(213)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(220)).setAttribute("src","b.gif" );
      ((Element)v.get(220)).setAttribute("width","25" );
      ((Element)v.get(220)).setAttribute("height","8" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:219   */

      /* Empieza nodo:221 / Elemento padre: 213   */
      v.add(doc.createElement("td"));
      ((Element)v.get(213)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(222)).setAttribute("nombre","cbSeccionHasta" );
      ((Element)v.get(222)).setAttribute("id","datosCampos" );
      ((Element)v.get(222)).setAttribute("size","1" );
      ((Element)v.get(222)).setAttribute("multiple","N" );
      ((Element)v.get(222)).setAttribute("req","N" );
      ((Element)v.get(222)).setAttribute("valorinicial","" );
      ((Element)v.get(222)).setAttribute("textoinicial","" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(222)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:222   */
      /* Termina nodo:221   */

      /* Empieza nodo:224 / Elemento padre: 213   */
      v.add(doc.createElement("td"));
      ((Element)v.get(224)).setAttribute("width","100%" );
      ((Element)v.get(213)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(225)).setAttribute("src","b.gif" );
      ((Element)v.get(225)).setAttribute("width","8" );
      ((Element)v.get(225)).setAttribute("height","8" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */
      /* Termina nodo:213   */

      /* Empieza nodo:226 / Elemento padre: 201   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(201)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("td"));
      ((Element)v.get(227)).setAttribute("colspan","3" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(228)).setAttribute("src","b.gif" );
      ((Element)v.get(228)).setAttribute("width","8" );
      ((Element)v.get(228)).setAttribute("height","7" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */
      /* Termina nodo:227   */
      /* Termina nodo:226   */
      /* Termina nodo:201   */
      /* Termina nodo:200   */
      /* Termina nodo:199   */

      /* Empieza nodo:229 / Elemento padre: 54   */
   }

   private void getXML900(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(54)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("td"));
      ((Element)v.get(229)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("table"));
      ((Element)v.get(231)).setAttribute("width","661" );
      ((Element)v.get(231)).setAttribute("border","0" );
      ((Element)v.get(231)).setAttribute("align","left" );
      ((Element)v.get(231)).setAttribute("cellspacing","0" );
      ((Element)v.get(231)).setAttribute("cellpadding","0" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(231)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("td"));
      ((Element)v.get(232)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(234)).setAttribute("src","b.gif" );
      ((Element)v.get(234)).setAttribute("width","8" );
      ((Element)v.get(234)).setAttribute("height","8" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */
      /* Termina nodo:233   */

      /* Empieza nodo:235 / Elemento padre: 232   */
      v.add(doc.createElement("td"));
      ((Element)v.get(232)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(236)).setAttribute("nombre","lblTerritorioDesde" );
      ((Element)v.get(236)).setAttribute("alto","13" );
      ((Element)v.get(236)).setAttribute("filas","1" );
      ((Element)v.get(236)).setAttribute("valor","" );
      ((Element)v.get(236)).setAttribute("id","datosTitle" );
      ((Element)v.get(236)).setAttribute("cod","997" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */
      /* Termina nodo:235   */

      /* Empieza nodo:237 / Elemento padre: 232   */
      v.add(doc.createElement("td"));
      ((Element)v.get(232)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(238)).setAttribute("src","b.gif" );
      ((Element)v.get(238)).setAttribute("width","25" );
      ((Element)v.get(238)).setAttribute("height","8" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:237   */

      /* Empieza nodo:239 / Elemento padre: 232   */
      v.add(doc.createElement("td"));
      ((Element)v.get(232)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(240)).setAttribute("nombre","lblTerritorioHasta" );
      ((Element)v.get(240)).setAttribute("alto","13" );
      ((Element)v.get(240)).setAttribute("filas","1" );
      ((Element)v.get(240)).setAttribute("valor","" );
      ((Element)v.get(240)).setAttribute("id","datosTitle" );
      ((Element)v.get(240)).setAttribute("cod","998" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:239   */

      /* Empieza nodo:241 / Elemento padre: 232   */
      v.add(doc.createElement("td"));
      ((Element)v.get(241)).setAttribute("width","100%" );
      ((Element)v.get(232)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(242)).setAttribute("src","b.gif" );
      ((Element)v.get(242)).setAttribute("width","8" );
      ((Element)v.get(242)).setAttribute("height","8" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:241   */
      /* Termina nodo:232   */

      /* Empieza nodo:243 / Elemento padre: 231   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(231)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("td"));
      ((Element)v.get(243)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(245)).setAttribute("src","b.gif" );
      ((Element)v.get(245)).setAttribute("width","8" );
      ((Element)v.get(245)).setAttribute("height","8" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:244   */

      /* Empieza nodo:246 / Elemento padre: 243   */
      v.add(doc.createElement("td"));
      ((Element)v.get(243)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(247)).setAttribute("nombre","txtTerritorioDesde" );
      ((Element)v.get(247)).setAttribute("id","datosCampos" );
      ((Element)v.get(247)).setAttribute("max","40" );
      ((Element)v.get(247)).setAttribute("tipo","" );
      ((Element)v.get(247)).setAttribute("onchange","" );
      ((Element)v.get(247)).setAttribute("req","N" );
      ((Element)v.get(247)).setAttribute("size","40" );
      ((Element)v.get(247)).setAttribute("valor","" );
      ((Element)v.get(247)).setAttribute("validacion","" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */
      /* Termina nodo:246   */

      /* Empieza nodo:248 / Elemento padre: 243   */
      v.add(doc.createElement("td"));
      ((Element)v.get(243)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(249)).setAttribute("src","b.gif" );
      ((Element)v.get(249)).setAttribute("width","25" );
      ((Element)v.get(249)).setAttribute("height","8" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:248   */

      /* Empieza nodo:250 / Elemento padre: 243   */
      v.add(doc.createElement("td"));
      ((Element)v.get(243)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(251)).setAttribute("nombre","txtTerritorioHasta" );
      ((Element)v.get(251)).setAttribute("id","datosCampos" );
      ((Element)v.get(251)).setAttribute("max","40" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(251)).setAttribute("tipo","" );
      ((Element)v.get(251)).setAttribute("onchange","" );
      ((Element)v.get(251)).setAttribute("req","N" );
      ((Element)v.get(251)).setAttribute("size","40" );
      ((Element)v.get(251)).setAttribute("valor","" );
      ((Element)v.get(251)).setAttribute("validacion","" );
      ((Element)v.get(251)).setAttribute("ontab","focoBoton();" );
      ((Element)v.get(251)).setAttribute("onshtab","focoTerri();" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:250   */

      /* Empieza nodo:252 / Elemento padre: 243   */
      v.add(doc.createElement("td"));
      ((Element)v.get(252)).setAttribute("width","100%" );
      ((Element)v.get(243)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(253)).setAttribute("src","b.gif" );
      ((Element)v.get(253)).setAttribute("width","8" );
      ((Element)v.get(253)).setAttribute("height","8" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */
      /* Termina nodo:252   */
      /* Termina nodo:243   */

      /* Empieza nodo:254 / Elemento padre: 231   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(231)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("td"));
      ((Element)v.get(255)).setAttribute("colspan","3" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(256)).setAttribute("src","b.gif" );
      ((Element)v.get(256)).setAttribute("width","8" );
      ((Element)v.get(256)).setAttribute("height","7" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */
      /* Termina nodo:255   */
      /* Termina nodo:254   */
      /* Termina nodo:231   */
      /* Termina nodo:230   */
      /* Termina nodo:229   */
      /* Termina nodo:54   */
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:257 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(258)).setAttribute("src","b.gif" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */
      /* Termina nodo:257   */
      /* Termina nodo:47   */

      /* Empieza nodo:259 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("td"));
      ((Element)v.get(259)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(261)).setAttribute("src","b.gif" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */
      /* Termina nodo:260   */

      /* Empieza nodo:262 / Elemento padre: 259   */
      v.add(doc.createElement("td"));
      ((Element)v.get(259)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(262)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("table"));
      ((Element)v.get(264)).setAttribute("width","100%" );
      ((Element)v.get(264)).setAttribute("border","0" );
      ((Element)v.get(264)).setAttribute("align","center" );
      ((Element)v.get(264)).setAttribute("cellspacing","0" );
      ((Element)v.get(264)).setAttribute("cellpadding","0" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(264)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("td"));
      ((Element)v.get(266)).setAttribute("class","botonera" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(267)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(267)).setAttribute("ID","botonContenido" );
      ((Element)v.get(267)).setAttribute("tipo","html" );
      ((Element)v.get(267)).setAttribute("accion","onClickBuscar();" );
      ((Element)v.get(267)).setAttribute("estado","false" );
      ((Element)v.get(267)).setAttribute("cod","1" );
      ((Element)v.get(267)).setAttribute("ontab","focalizaTab();" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */
      /* Termina nodo:266   */
      /* Termina nodo:265   */
      /* Termina nodo:264   */
      /* Termina nodo:263   */
      /* Termina nodo:262   */

      /* Empieza nodo:268 / Elemento padre: 259   */
      v.add(doc.createElement("td"));
      ((Element)v.get(259)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(269)).setAttribute("src","b.gif" );
      ((Element)v.get(269)).setAttribute("width","8" );
      ((Element)v.get(269)).setAttribute("height","12" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */
      /* Termina nodo:268   */
      /* Termina nodo:259   */

      /* Empieza nodo:270 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("td"));
      ((Element)v.get(271)).setAttribute("width","12" );
      ((Element)v.get(271)).setAttribute("align","center" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(272)).setAttribute("src","b.gif" );
      ((Element)v.get(272)).setAttribute("width","12" );
      ((Element)v.get(272)).setAttribute("height","12" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */
      /* Termina nodo:271   */

      /* Empieza nodo:273 / Elemento padre: 270   */
      v.add(doc.createElement("td"));
      ((Element)v.get(273)).setAttribute("width","756" );
      ((Element)v.get(270)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(274)).setAttribute("src","b.gif" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */
      /* Termina nodo:273   */

      /* Empieza nodo:275 / Elemento padre: 270   */
      v.add(doc.createElement("td"));
      ((Element)v.get(275)).setAttribute("width","12" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(270)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(276)).setAttribute("src","b.gif" );
      ((Element)v.get(276)).setAttribute("width","12" );
      ((Element)v.get(276)).setAttribute("height","1" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:275   */
      /* Termina nodo:270   */
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:277 / Elemento padre: 12   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(277)).setAttribute("nombre","listado1" );
      ((Element)v.get(277)).setAttribute("ancho","664" );
      ((Element)v.get(277)).setAttribute("alto","317" );
      ((Element)v.get(277)).setAttribute("x","12" );
      ((Element)v.get(277)).setAttribute("y","360" );
      ((Element)v.get(277)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(277)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(12)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(278)).setAttribute("precarga","S" );
      ((Element)v.get(278)).setAttribute("conROver","S" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(279)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(279)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(279)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(279)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */

      /* Empieza nodo:280 / Elemento padre: 278   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(280)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(280)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(280)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(280)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(278)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */

      /* Empieza nodo:281 / Elemento padre: 278   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(281)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(281)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(278)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */
      /* Termina nodo:278   */

      /* Empieza nodo:282 / Elemento padre: 277   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(277)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(283)).setAttribute("borde","1" );
      ((Element)v.get(283)).setAttribute("horizDatos","1" );
      ((Element)v.get(283)).setAttribute("horizCabecera","1" );
      ((Element)v.get(283)).setAttribute("vertical","1" );
      ((Element)v.get(283)).setAttribute("horizTitulo","1" );
      ((Element)v.get(283)).setAttribute("horizBase","1" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */

      /* Empieza nodo:284 / Elemento padre: 282   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(284)).setAttribute("borde","#999999" );
      ((Element)v.get(284)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(284)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(284)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(284)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(284)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(284)).setAttribute("horizBase","#999999" );
      ((Element)v.get(282)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */
      /* Termina nodo:282   */

      /* Empieza nodo:285 / Elemento padre: 277   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(285)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(285)).setAttribute("alto","22" );
      ((Element)v.get(285)).setAttribute("imgFondo","" );
      ((Element)v.get(285)).setAttribute("cod","00135" );
      ((Element)v.get(285)).setAttribute("ID","datosTitle" );
      ((Element)v.get(277)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */

      /* Empieza nodo:286 / Elemento padre: 277   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(286)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(286)).setAttribute("alto","22" );
      ((Element)v.get(286)).setAttribute("imgFondo","" );
      ((Element)v.get(277)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */

      /* Empieza nodo:287 / Elemento padre: 277   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(287)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(287)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(287)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(287)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(287)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(287)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(277)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(288)).setAttribute("ancho","30" );
      ((Element)v.get(288)).setAttribute("minimizable","S" );
      ((Element)v.get(288)).setAttribute("minimizada","N" );
      ((Element)v.get(288)).setAttribute("oculta","S" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */

      /* Empieza nodo:289 / Elemento padre: 287   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(289)).setAttribute("ancho","30" );
      ((Element)v.get(289)).setAttribute("minimizable","S" );
      ((Element)v.get(289)).setAttribute("minimizada","N" );
      ((Element)v.get(287)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */

      /* Empieza nodo:290 / Elemento padre: 287   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(290)).setAttribute("ancho","20" );
      ((Element)v.get(290)).setAttribute("minimizable","S" );
      ((Element)v.get(290)).setAttribute("minimizada","N" );
      ((Element)v.get(287)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */

      /* Empieza nodo:291 / Elemento padre: 287   */
   }

   private void getXML1170(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(291)).setAttribute("ancho","30" );
      ((Element)v.get(291)).setAttribute("minimizable","S" );
      ((Element)v.get(291)).setAttribute("minimizada","N" );
      ((Element)v.get(291)).setAttribute("oculta","S" );
      ((Element)v.get(287)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */

      /* Empieza nodo:292 / Elemento padre: 287   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(292)).setAttribute("ancho","20" );
      ((Element)v.get(292)).setAttribute("minimizable","S" );
      ((Element)v.get(292)).setAttribute("minimizada","N" );
      ((Element)v.get(287)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */
      /* Termina nodo:287   */

      /* Empieza nodo:293 / Elemento padre: 277   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(293)).setAttribute("alto","20" );
      ((Element)v.get(293)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(293)).setAttribute("imgFondo","" );
      ((Element)v.get(293)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(277)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(294)).setAttribute("colFondo","" );
      ((Element)v.get(294)).setAttribute("ID","EstCab" );
      ((Element)v.get(293)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */

      /* Empieza nodo:295 / Elemento padre: 293   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(295)).setAttribute("colFondo","" );
      ((Element)v.get(295)).setAttribute("ID","EstCab" );
      ((Element)v.get(295)).setAttribute("cod","263" );
      ((Element)v.get(293)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */

      /* Empieza nodo:296 / Elemento padre: 293   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(296)).setAttribute("colFondo","" );
      ((Element)v.get(296)).setAttribute("ID","EstCab" );
      ((Element)v.get(296)).setAttribute("cod","1039" );
      ((Element)v.get(293)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */

      /* Empieza nodo:297 / Elemento padre: 293   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(297)).setAttribute("colFondo","" );
      ((Element)v.get(297)).setAttribute("ID","EstCab" );
      ((Element)v.get(293)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */

      /* Empieza nodo:298 / Elemento padre: 293   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(298)).setAttribute("colFondo","" );
      ((Element)v.get(298)).setAttribute("ID","EstCab" );
      ((Element)v.get(298)).setAttribute("cod","573" );
      ((Element)v.get(293)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */
      /* Termina nodo:293   */

      /* Empieza nodo:299 / Elemento padre: 277   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(299)).setAttribute("alto","22" );
      ((Element)v.get(299)).setAttribute("accion","" );
      ((Element)v.get(299)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(299)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(299)).setAttribute("maxSel","-1" );
      ((Element)v.get(299)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(299)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(299)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(299)).setAttribute("onLoad","" );
      ((Element)v.get(299)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(277)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(300)).setAttribute("tipo","texto" );
      ((Element)v.get(300)).setAttribute("ID","EstDat" );
      ((Element)v.get(299)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */

      /* Empieza nodo:301 / Elemento padre: 299   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(301)).setAttribute("tipo","texto" );
      ((Element)v.get(301)).setAttribute("ID","EstDat2" );
      ((Element)v.get(299)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */

      /* Empieza nodo:302 / Elemento padre: 299   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(302)).setAttribute("tipo","texto" );
      ((Element)v.get(302)).setAttribute("ID","EstDat" );
      ((Element)v.get(299)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */

      /* Empieza nodo:303 / Elemento padre: 299   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(303)).setAttribute("tipo","texto" );
      ((Element)v.get(303)).setAttribute("ID","EstDat2" );
      ((Element)v.get(299)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */

      /* Empieza nodo:304 / Elemento padre: 299   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(304)).setAttribute("tipo","texto" );
      ((Element)v.get(304)).setAttribute("ID","EstDat" );
      ((Element)v.get(299)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */
      /* Termina nodo:299   */

      /* Empieza nodo:305 / Elemento padre: 277   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(277)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */

      /* Empieza nodo:306 / Elemento padre: 277   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(306)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(306)).setAttribute("ancho","664" );
      ((Element)v.get(306)).setAttribute("sep","$" );
      ((Element)v.get(306)).setAttribute("x","12" );
      ((Element)v.get(306)).setAttribute("class","botonera" );
      ((Element)v.get(306)).setAttribute("y","654" );
      ((Element)v.get(306)).setAttribute("control","|" );
      ((Element)v.get(306)).setAttribute("conector","" );
      ((Element)v.get(306)).setAttribute("rowset","" );
      ((Element)v.get(306)).setAttribute("cargainicial","N" );
      ((Element)v.get(306)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'trataLista(ultima, rowset)')" );
      ((Element)v.get(277)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(307)).setAttribute("nombre","ret1" );
      ((Element)v.get(307)).setAttribute("x","37" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(307)).setAttribute("y","658" );
      ((Element)v.get(307)).setAttribute("ID","botonContenido" );
      ((Element)v.get(307)).setAttribute("img","retroceder_on" );
      ((Element)v.get(307)).setAttribute("tipo","0" );
      ((Element)v.get(307)).setAttribute("estado","false" );
      ((Element)v.get(307)).setAttribute("alt","" );
      ((Element)v.get(307)).setAttribute("codigo","" );
      ((Element)v.get(307)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */

      /* Empieza nodo:308 / Elemento padre: 306   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(308)).setAttribute("nombre","ava1" );
      ((Element)v.get(308)).setAttribute("x","52" );
      ((Element)v.get(308)).setAttribute("y","658" );
      ((Element)v.get(308)).setAttribute("ID","botonContenido" );
      ((Element)v.get(308)).setAttribute("img","avanzar_on" );
      ((Element)v.get(308)).setAttribute("tipo","0" );
      ((Element)v.get(308)).setAttribute("estado","false" );
      ((Element)v.get(308)).setAttribute("alt","" );
      ((Element)v.get(308)).setAttribute("codigo","" );
      ((Element)v.get(308)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(306)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */
      /* Termina nodo:306   */
      /* Termina nodo:277   */

      /* Empieza nodo:309 / Elemento padre: 12   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(309)).setAttribute("nombre","primera1" );
      ((Element)v.get(309)).setAttribute("x","20" );
      ((Element)v.get(309)).setAttribute("y","658" );
      ((Element)v.get(309)).setAttribute("ID","botonContenido" );
      ((Element)v.get(309)).setAttribute("img","primera_on" );
      ((Element)v.get(309)).setAttribute("tipo","-2" );
      ((Element)v.get(309)).setAttribute("estado","false" );
      ((Element)v.get(309)).setAttribute("alt","" );
      ((Element)v.get(309)).setAttribute("codigo","" );
      ((Element)v.get(309)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(12)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */

      /* Empieza nodo:310 / Elemento padre: 12   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(310)).setAttribute("nombre","separa" );
      ((Element)v.get(310)).setAttribute("x","59" );
      ((Element)v.get(310)).setAttribute("y","654" );
      ((Element)v.get(310)).setAttribute("ID","botonContenido" );
      ((Element)v.get(310)).setAttribute("img","separa_base" );
      ((Element)v.get(310)).setAttribute("tipo","0" );
      ((Element)v.get(310)).setAttribute("estado","false" );
      ((Element)v.get(310)).setAttribute("alt","" );
      ((Element)v.get(310)).setAttribute("codigo","" );
      ((Element)v.get(310)).setAttribute("accion","" );
      ((Element)v.get(12)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */

      /* Empieza nodo:311 / Elemento padre: 12   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(311)).setAttribute("nombre","GenerarMensajes" );
      ((Element)v.get(311)).setAttribute("x","13" );
      ((Element)v.get(311)).setAttribute("y","655" );
      ((Element)v.get(311)).setAttribute("ID","botonContenido" );
      ((Element)v.get(311)).setAttribute("tipo","html" );
      ((Element)v.get(311)).setAttribute("estado","false" );
      ((Element)v.get(311)).setAttribute("cod","887" );
      ((Element)v.get(311)).setAttribute("accion","accionGenerarMensajes();" );
      ((Element)v.get(311)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnBuscar');" );
      ((Element)v.get(311)).setAttribute("ontab","focaliza('frmFormulario.cbEtapa');" );
      ((Element)v.get(12)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */

      /* Empieza nodo:312 / Elemento padre: 12   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(312)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(312)).setAttribute("alto","12" );
      ((Element)v.get(312)).setAttribute("ancho","50" );
      ((Element)v.get(312)).setAttribute("colorf","" );
      ((Element)v.get(312)).setAttribute("borde","0" );
      ((Element)v.get(312)).setAttribute("imagenf","" );
      ((Element)v.get(312)).setAttribute("repeat","" );
      ((Element)v.get(312)).setAttribute("padding","" );
      ((Element)v.get(312)).setAttribute("visibilidad","visible" );
      ((Element)v.get(312)).setAttribute("contravsb","" );
      ((Element)v.get(312)).setAttribute("x","0" );
      ((Element)v.get(312)).setAttribute("y","677" );
      ((Element)v.get(312)).setAttribute("zindex","" );
      ((Element)v.get(12)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */
      /* Termina nodo:12   */


   }

}
