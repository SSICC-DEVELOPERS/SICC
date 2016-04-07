
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_alcance_administrativo_crear  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_alcance_administrativo_crear" );
      ((Element)v.get(0)).setAttribute("cod","0644" );
      ((Element)v.get(0)).setAttribute("titulo","Alcance administrativo" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Elemento padre:1 / Elemento actual: 2   */
      v.add(doc.createTextNode("\r   \r\r    function onLoadPag() {  \r		guardoConExito();\r        DrdEnsanchaConMargenDcho('listado1',12);\r        document.all[\"Cplistado1\"].style.visibility='';\r        document.all[\"CpLin1listado1\"].style.visibility='';\r        document.all[\"CpLin2listado1\"].style.visibility='';\r        document.all[\"CpLin3listado1\"].style.visibility='';\r        document.all[\"CpLin4listado1\"].style.visibility='';\r        document.all[\"separaDiv\"].style.visibility='hidden';\r        document.all[\"primera1Div\"].style.visibility='hidden';\r        document.all[\"ret1Div\"].style.visibility='hidden';\r        document.all[\"ava1Div\"].style.visibility='hidden';\r        document.all[\"btnSiguienteDiv\"].style.visibility='';\r        document.all[\"btnAnadirDiv\"].style.visibility='';\r        eval (ON_RSZ);  \r\r        configurarMenuSecundario('formulario');\r		fMostrarMensajeError();\r        \r        document.getElementById(\"InsertarP3\").style.backgroundColor = \"#496A9A\";\r        document.getElementById(\"InsertarP3\").style.color = \"#FFFFFF\";\r\r		ColocarValoresDeLaMatrizDeDescuento();\r		btnProxy(2,\"1\");\r\r        if (get('formulario.casoDeUso') == 'consultar' || \r			get('formulario.casoDeUso') == 'modificar'){\r									\r			if (get('formulario.casoDeUso') == 'consultar' ){\r								deshabilitarHabilitarBoton('botonContenido','btnAnadir','D');\r				deshabilitarHabilitarBoton('botonContenido','btnEliminar','D');\r				accion('formulario.rbNacional','.disabled=true');\r				document.all.rbNacional[0].disabled=true;\r				document.all.rbNacional[1].disabled=true;\r                focalizaBotonHTML_XY('btnSiguiente');\r                btnProxy(3,\"1\");\r			}\r		}\r        if (get('formulario.casoDeUso') != 'consultar' )\r            focaliza(\"formulario.rbNacional\",\"\");\r            \r\r        set('formulario.hidUltimoElementoEnLaLista','1'); \r        \r    }\r\r\r    function navegaPestaniasDetalle(pestanya){\r        set('formulario.conectorAction', 'LPMantenimientoAlcanceAdministrativo');\r        set('formulario.accion', 'siguiente');\r		if (pestanya == 3){\r            set(\"formulario.hidPestanya\", \"3\");\r    		enviaSICC('formulario');  \r		}\r    }\r\r\r    function accionAniadir() {\r        var vValorNacional = get ('formulario.rbNacional','V');\r        var obj = new Object();\r\r        obj.hidOidDescuento = get('formulario.hidOidDescuento');\r        var whnd = mostrarModalSICC('LPMantenimientoAlcanceAdministrativo',\r		'aniadir',obj,null, 250);\r        if(whnd==null){\r\r        }\r        else{\r	                    var posi = parseInt(get('formulario.hidUltimoElementoEnLaLista'), 10);\r            var codigo = listado1.generaCodigo( posi );\r                    \r                    var datos = codigo + \"|\" + whnd[0] + \"|\" +  whnd[1] + \"|\" +  \r					whnd[2] + \"|\" +  whnd[3] + \"|\" +  whnd[4];  \r                    datos = datos + \"|\" + whnd[5] + \"|\" +  whnd[6] ;\r\r                                        if (!existeFila(datos)) {\r                        var newRow = new Array();\r                        newRow = datos.split(\"|\");\r                        listado1.insertar(newRow);\r                        set('formulario.hidUltimoElementoEnLaLista', codigo);\r                    }\r             \r        }\r    }\r    \r    function existeFila(datos)  {\r        listado1.actualizaDat();\r        var codigo = listado1.codigos();\r        var newRow = new Array();\r        newRow = datos.split(\"|\");\r        var flag = false;\r        var a = 0;\r        \r        while( (a < codigo.length ) && (flag == false) ){\r            if( cdos_trim(newRow[1]) == \r			cdos_trim(listado1.extraeDato(codigo[a], 0)) )\r            {	            if( cdos_trim(newRow[3]) == \r				cdos_trim(listado1.extraeDato(codigo[a], 2)))\r                {                    if( cdos_trim(newRow[5]) == \r					cdos_trim(listado1.extraeDato(codigo[a], 4)))\r                    {                        flag = true;\r                        listado1.insertaDato (codigo[a],6,newRow[7]);\r                    }\r                }\r            }			\r            a++;\r		}        \r        return flag;\r    }\r\r    function accionEliminar() {\r        var cantElementosSel = listado1.codSeleccionados();\r		if ( cantElementosSel.length == 0) {\r			GestionarMensaje(\"4\", null, null, null);\r			return ;\r		}\r		listado1.eliminarSelecc();\r    }\r\r    \r    function siguiente() {      \r	   if(get('formulario.casoDeUso') != 'consultar' ){\r		  if( validarAlcance() ) /* Inc 9820 */{\r				set('formulario.hidAlcance', get ('formulario.rbNacional','V'));			\r				ObtenerInformacionDescuentosDefinidos();\r				set('formulario.conectorAction', \r				'LPMantenimientoAlcanceAdministrativo');\r				set('formulario.accion', 'siguiente');\r				enviaSICC('formulario');\r    		}\r		}\r		else{\r				set('formulario.hidAlcance', get ('formulario.rbNacional','V'));			\r				ObtenerInformacionDescuentosDefinidos();\r				set('formulario.conectorAction', \r				'LPMantenimientoAlcanceAdministrativo');\r				set('formulario.accion', 'siguiente');\r				enviaSICC('formulario');\r		}\r        \r    }\r\r	 function fGuardar(){\r        if( validarAlcance() ) { /* Inc 9820 */\r			set('formulario.hidAlcance', get ('formulario.rbNacional','V'));			\r            ObtenerInformacionDescuentosDefinidos();    \r            set('formulario.conectorAction', \r			'LPMantenimientoAlcanceAdministrativo');\r                        set('formulario.accion', 'guardar');\r            enviaSICC('formulario');\r        }\r	 }\r\r    function accionGuardar() {\r        if( validarAlcance() ) { /* Inc 9820 */\r			set('formulario.hidAlcance', get ('formulario.rbNacional','V'));			\r            ObtenerInformacionDescuentosDefinidos();    \r            set('formulario.conectorAction', \r			'LPMantenimientoAlcanceAdministrativo');\r            set('formulario.accion', 'siguiente');\r            enviaSICC('formulario');\r        }\r    }\r\r    function ObtenerInformacionDescuentosDefinidos()  {\r        var descuentosAdicionales = listado2String();\r        set('formulario.hidDetalleUnidadesAdmin',descuentosAdicionales);\r    }\r\r	function listado2String(){\r		var codigo = listado1.codigos();\r		var total = \"\";\r		var longitud = codigo.length;\r\r		for(var a = 0; a < longitud; a++){\r			var toAdd = \"\";\r			toAdd = \"oid:\"+ codigo[a];\r\r			if(listado1.extraeDato(codigo[a], 0)!= null && \r			listado1.extraeDato(codigo[a], 0)!=\"\")\r				toAdd = toAdd + \"|\" + \"sgv:\" + \r				listado1.extraeDato(codigo[a], 0);   \r							\r			if(listado1.extraeDato(codigo[a], 2)!= null && \r			listado1.extraeDato(codigo[a], 2)!=\"\")\r				toAdd = toAdd + \"|\" + \"r:\"  + \r				listado1.extraeDato(codigo[a], 2);    \r							\r			if(listado1.extraeDato(codigo[a], 4)!= null && \r			listado1.extraeDato(codigo[a], 4)!=\"\")\r				toAdd = toAdd + \"|\" + \"z:\"  + \r				listado1.extraeDato(codigo[a], 4);    \r							\r			if(listado1.extraeDato(codigo[a], 6)!= null && \r			listado1.extraeDato(codigo[a], 6)!=\"\")\r				toAdd = toAdd + \"|\" + \"da:\"  + \r				listado1.extraeDato(codigo[a], 6);   \r				\r			if(listado1.extraeDato(codigo[a], 1)!= null && \r			listado1.extraeDato(codigo[a], 1)!=\"\")\r				toAdd = toAdd + \"|\" + \"descsgv:\"  + \r				listado1.extraeDato(codigo[a], 1); \r				\r			if(listado1.extraeDato(codigo[a], 3)!= null && \r			listado1.extraeDato(codigo[a], 3)!=\"\")\r				toAdd = toAdd + \"|\" + \"descr:\"  + \r				listado1.extraeDato(codigo[a], 3); \r						\r			if(listado1.extraeDato(codigo[a], 5)!= null && \r			listado1.extraeDato(codigo[a], 5)!=\"\")\r				toAdd = toAdd + \"|\" + \"descz:\"  + \r				listado1.extraeDato(codigo[a], 5); \r				      	\r			total = total + \"$\" + toAdd;\r		}		\r		return total;\r	}\r\r\r    function ColocarValoresDeLaMatrizDeDescuento() {\r        if (get('formulario.VisibleAlcance') == 'N') {\r            visibilidad('formulario.rbNacional','hidden');\r        }\r		\r        if (get('formulario.ModificableAlcance') == 'N') {\r            document.all.rbNacional[0].disabled=false;\r            document.all.rbNacional[1].disabled=false;\r        }\r		\r		var primera = get('formulario.primeraEntradaPestanya');			\r\r		if(primera==\"S\" && get('formulario.casoDeUso') == 'insertar') {\r			var valor = get('formulario.selAlcanceAdministrativoDescuento');			\r		}\r		else {\r			var valor = get('formulario.hidAlcance');\r		}\r\r        set('formulario.rbNacional',valor);\r    }\r\r    function fVolver(){\r	        /*if ( get('formulario.casoDeUso') == \"consultar\" || \r			get('formulario.casoDeUso') == \"modificar\")  {\r				window.close();\r			}\r			else {\r				set(\"formulario.conectorAction\",\"LPMantenimientoDTO\");\r				set(\"formulario.accion\",\"volver\");\r				enviaSICC(\"formulario\");\r			}*/\r\r			onClickPestanya('1');\r    }\r\r    function validarAlcance() { /*Sol Inc 9820*/\r        var respuesta = true;\r        var vDescuento;\r        var vValorNacional = get ('formulario.rbNacional','V');\r        var codigo = listado1.codigos();\r		var longitud = codigo.length;\r        \r        if ( vValorNacional == 'S') {\r            if (codigo.length  > 0) {\r                for(var a = 0; a < longitud ; a++)  {\r                    vDescuento = \r					cdos_trim(listado1.extraeDato(codigo[a], 6));\r					                    if (vDescuento == 0 || vDescuento == '') {\r                        GestionarMensaje('1249', 'Alcance');\r                        respuesta = false;\r                    }\r                }\r            }\r        }\r        else  {\r            if (codigo.length  <= 0) {\r                GestionarMensaje('1430', 'Alcance');\r                respuesta = false;\r            }\r        }\r        return respuesta;\r    }\r    \r	function fLimpiar() {\r        if (get('formulario.casoDeUso') != 'consultar' ){\r            var valor = get('formulario.hidAlcance');\r			set('formulario.rbNacional',valor);\r\r            focaliza('formulario.rbNacional');\r        }\r    }\r\r    function onTabSiguiente() {\r        if (get('formulario.casoDeUso') != 'consultar' )            \r            focalizaBotonHTML_XY('btnAnadir');\r        else {\r            focalizaBotonHTML_XY('btnSiguiente');\r        }\r    }\r    \r    function onShTabSiguiente() {\r        if (get('formulario.casoDeUso') != 'consultar' )\r            focaliza('formulario.rbNacional');\r        else {\r            focalizaBotonHTML_XY('btnSiguiente');\r        }\r    }\r    \r    function accionExitosa(){\r		window.close();\r    }\r\r    function accionError(){\r        fMostrarMensajeError();\r    }\r\r			function onClickPestanya(pestanya) {\r		set(\"formulario.idPestanyaDest\", pestanya);		\r		set(\"formulario.casoDeUso\", get('formulario.casoDeUso'));		\r		set('formulario.hidAlcance', get('formulario.rbNacional','V'));\r\r		if(get('formulario.casoDeUso')!= 'consultar'){\r			if(validarAlcance()) {\r				ObtenerInformacionDescuentosDefinidos();\r				set('formulario.conectorAction', \r				'LPMantenimientoAlcanceAdministrativo');\r				set('formulario.accion', 'almacenar');              \r				enviaSICC('formulario');\r			}			\r		}\r		else {\r			set('formulario.conectorAction', \r			'LPMantenimientoAlcanceAdministrativo');\r			set('formulario.accion', 'redirigir');              \r			enviaSICC('formulario');\r		}\r	}\r\r   \r"));
      ((Element)v.get(1)).appendChild((Text)v.get(2));

      /* Termina nodo Texto:2   */
      /* Termina nodo:1   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(6)).setAttribute("src","utilidadesDTO.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(7)).setAttribute("nombre","formulario" );
      ((Element)v.get(7)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","accion" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","hidPais" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","hidIdioma" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","hidDetalleUnidadesAdmin" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","hidOidDescuento" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","hidPestanya" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hidAlcance" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","idPestanyaDest" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hExito" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","primeraEntradaPestanya" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","VisibleAlcance" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","ObligatorioAlcance" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","ModificableAlcance" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 7   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","selAlcanceAdministrativoDescuento" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hidUltimoElementoEnLaLista" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 7   */
      v.add(doc.createElement("table"));
      ((Element)v.get(25)).setAttribute("bgcolor","red" );
      ((Element)v.get(25)).setAttribute("width","100%" );
      ((Element)v.get(25)).setAttribute("height","100%" );
      ((Element)v.get(25)).setAttribute("border","0" );
      ((Element)v.get(25)).setAttribute("align","center" );
      ((Element)v.get(25)).setAttribute("cellpadding","0" );
      ((Element)v.get(25)).setAttribute("cellspacing","0" );
      ((Element)v.get(25)).setAttribute("class","menu5" );
      ((Element)v.get(7)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(25)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(27)).setAttribute("width","12" );
      ((Element)v.get(27)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(27)).setAttribute("class","menu5texto" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(28)).setAttribute("src","b.gif" );
      ((Element)v.get(28)).setAttribute("width","12" );
      ((Element)v.get(28)).setAttribute("height","10" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:27   */

      /* Empieza nodo:29 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(29)).setAttribute("class","menu5texto" );
      ((Element)v.get(26)).appendChild((Element)v.get(29));

      /* Elemento padre:29 / Elemento actual: 30   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(29)).appendChild((Text)v.get(30));

      /* Termina nodo Texto:30   */
      /* Termina nodo:29   */

      /* Empieza nodo:31 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).setAttribute("width","10" );
      ((Element)v.get(31)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(31)).setAttribute("class","menu5texto" );
      ((Element)v.get(26)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(32)).setAttribute("src","b.gif" );
      ((Element)v.get(32)).setAttribute("width","10" );
      ((Element)v.get(32)).setAttribute("height","0" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */
      /* Termina nodo:31   */

      /* Empieza nodo:33 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(33)).setAttribute("width","10" );
      ((Element)v.get(33)).setAttribute("class","menu5texto" );
      ((Element)v.get(26)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(34)).setAttribute("src","b.gif" );
      ((Element)v.get(34)).setAttribute("width","10" );
      ((Element)v.get(34)).setAttribute("height","8" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */
      /* Termina nodo:33   */

      /* Empieza nodo:35 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).setAttribute("width","20" );
      ((Element)v.get(35)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(35)).setAttribute("class","menu5texto" );
      ((Element)v.get(26)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("table"));
      ((Element)v.get(36)).setAttribute("width","75" );
      ((Element)v.get(36)).setAttribute("border","0" );
      ((Element)v.get(36)).setAttribute("align","center" );
      ((Element)v.get(36)).setAttribute("cellpadding","1" );
      ((Element)v.get(36)).setAttribute("cellspacing","0" );
      ((Element)v.get(36)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(37)).setAttribute("align","center" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(38)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(38)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("a"));
      ((Element)v.get(39)).setAttribute("href","#" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(40)).setAttribute("ID","InsertarP1" );
      ((Element)v.get(40)).setAttribute("onmouseover","poneManito('InsertarP1');" );
      ((Element)v.get(40)).setAttribute("onclick","onClickPestanya('0')" );
      ((Element)v.get(40)).setAttribute("style","width:80px;border-style:solid; border-color:#496A9A;border-width:2px;position:relative;top:3px;text-align:center;color:#496A9A;font-family: Arial, Helvetica, sans-serif;font-size: 11px;font-weight: bold; visibility:visible" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Elemento padre:40 / Elemento actual: 41   */
      v.add(doc.createTextNode("Datos generales"));
      ((Element)v.get(40)).appendChild((Text)v.get(41));

      /* Termina nodo Texto:41   */
      /* Termina nodo:40   */
      /* Termina nodo:39   */
      /* Termina nodo:38   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */
      /* Termina nodo:35   */

      /* Empieza nodo:42 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).setAttribute("width","10" );
      ((Element)v.get(42)).setAttribute("class","menu5texto" );
      ((Element)v.get(26)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(43)).setAttribute("src","b.gif" );
      ((Element)v.get(43)).setAttribute("width","10" );
      ((Element)v.get(43)).setAttribute("height","8" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:44 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).setAttribute("width","20" );
      ((Element)v.get(44)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(44)).setAttribute("class","menu5texto" );
      ((Element)v.get(26)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("table"));
      ((Element)v.get(45)).setAttribute("width","75" );
      ((Element)v.get(45)).setAttribute("border","0" );
      ((Element)v.get(45)).setAttribute("align","center" );
      ((Element)v.get(45)).setAttribute("cellpadding","1" );
      ((Element)v.get(45)).setAttribute("cellspacing","0" );
      ((Element)v.get(45)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(46)).setAttribute("align","center" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(47)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(48)).setAttribute("ID","InsertarP2" );
      ((Element)v.get(48)).setAttribute("onmouseover","poneManito('InsertarP2');" );
      ((Element)v.get(48)).setAttribute("onclick","onClickPestanya('1')" );
      ((Element)v.get(48)).setAttribute("style","width:80px;border-style:solid; border-color:#496A9A;border-width:2px;position:relative;top:3px;text-align:center;color:#496A9A;font-family: Arial, Helvetica, sans-serif;font-size: 11px;font-weight: bold; visibility:visible" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Elemento padre:48 / Elemento actual: 49   */
      v.add(doc.createTextNode("Tipo de cliente"));
      ((Element)v.get(48)).appendChild((Text)v.get(49));

      /* Termina nodo Texto:49   */
      /* Termina nodo:48   */
      /* Termina nodo:47   */
      /* Termina nodo:46   */
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:50 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).setAttribute("width","10" );
      ((Element)v.get(50)).setAttribute("class","menu5texto" );
      ((Element)v.get(26)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(51)).setAttribute("src","b.gif" );
      ((Element)v.get(51)).setAttribute("width","10" );
      ((Element)v.get(51)).setAttribute("height","8" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:52 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).setAttribute("width","20" );
      ((Element)v.get(52)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(52)).setAttribute("class","menu5texto" );
      ((Element)v.get(26)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("table"));
      ((Element)v.get(53)).setAttribute("width","75" );
      ((Element)v.get(53)).setAttribute("border","0" );
      ((Element)v.get(53)).setAttribute("align","center" );
      ((Element)v.get(53)).setAttribute("cellpadding","1" );
      ((Element)v.get(53)).setAttribute("cellspacing","0" );
      ((Element)v.get(53)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(54)).setAttribute("align","center" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(55)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(56)).setAttribute("ID","InsertarP3" );
      ((Element)v.get(56)).setAttribute("style","width:80px;border-style:solid; border-color:#496A9A;border-width:2px;position:relative;top:3px;text-align:center;color:#496A9A;font-family: Arial, Helvetica, sans-serif;font-size: 11px;font-weight: bold; visibility:visible" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Elemento padre:56 / Elemento actual: 57   */
      v.add(doc.createTextNode("Alcance administrativo"));
      ((Element)v.get(56)).appendChild((Text)v.get(57));

      /* Termina nodo Texto:57   */
      /* Termina nodo:56   */
      /* Termina nodo:55   */
      /* Termina nodo:54   */
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:58 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).setAttribute("width","10" );
      ((Element)v.get(58)).setAttribute("class","menu5texto" );
      ((Element)v.get(26)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(59)).setAttribute("src","b.gif" );
      ((Element)v.get(59)).setAttribute("width","10" );
      ((Element)v.get(59)).setAttribute("height","8" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:60 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).setAttribute("width","20" );
      ((Element)v.get(60)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(60)).setAttribute("class","menu5texto" );
      ((Element)v.get(26)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("table"));
      ((Element)v.get(61)).setAttribute("width","75" );
      ((Element)v.get(61)).setAttribute("border","0" );
      ((Element)v.get(61)).setAttribute("align","center" );
      ((Element)v.get(61)).setAttribute("cellpadding","1" );
      ((Element)v.get(61)).setAttribute("cellspacing","0" );
      ((Element)v.get(61)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(62)).setAttribute("align","center" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(63)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(64)).setAttribute("ID","InsertarP4" );
      ((Element)v.get(64)).setAttribute("onmouseover","poneManito('InsertarP4');" );
      ((Element)v.get(64)).setAttribute("onclick","onClickPestanya('3')" );
      ((Element)v.get(64)).setAttribute("style","width:80px;border-style:solid; border-color:#496A9A;border-width:2px;position:relative;top:3px;text-align:center;color:#496A9A;font-family: Arial, Helvetica, sans-serif;font-size: 11px;font-weight: bold; visibility:visible" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Elemento padre:64 / Elemento actual: 65   */
      v.add(doc.createTextNode("Base de cálculo"));
      ((Element)v.get(64)).appendChild((Text)v.get(65));

      /* Termina nodo Texto:65   */
      /* Termina nodo:64   */
      /* Termina nodo:63   */
      /* Termina nodo:62   */
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:66 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).setAttribute("width","10" );
      ((Element)v.get(66)).setAttribute("class","menu5texto" );
      ((Element)v.get(26)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(67)).setAttribute("src","b.gif" );
      ((Element)v.get(67)).setAttribute("width","10" );
      ((Element)v.get(67)).setAttribute("height","8" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:68 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).setAttribute("width","20" );
      ((Element)v.get(68)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(68)).setAttribute("class","menu5texto" );
      ((Element)v.get(26)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("table"));
      ((Element)v.get(69)).setAttribute("width","75" );
      ((Element)v.get(69)).setAttribute("border","0" );
      ((Element)v.get(69)).setAttribute("align","center" );
      ((Element)v.get(69)).setAttribute("cellpadding","1" );
      ((Element)v.get(69)).setAttribute("cellspacing","0" );
      ((Element)v.get(69)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(70)).setAttribute("align","center" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(71)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(72)).setAttribute("ID","InsertarP5" );
      ((Element)v.get(72)).setAttribute("onmouseover","poneManito('InsertarP5');" );
      ((Element)v.get(72)).setAttribute("onclick","onClickPestanya('4')" );
      ((Element)v.get(72)).setAttribute("style","width:80px;border-style:solid; border-color:#496A9A;border-width:2px;position:relative;top:3px;text-align:center;color:#496A9A;font-family: Arial, Helvetica, sans-serif;font-size: 11px;font-weight: bold; visibility:visible" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Elemento padre:72 / Elemento actual: 73   */
      v.add(doc.createTextNode("Aplicación de descuento"));
      ((Element)v.get(72)).appendChild((Text)v.get(73));

      /* Termina nodo Texto:73   */
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:70   */
      /* Termina nodo:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:74 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).setAttribute("width","16" );
      ((Element)v.get(74)).setAttribute("class","menu5texto" );
      ((Element)v.get(26)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(75)).setAttribute("width","12" );
      ((Element)v.get(75)).setAttribute("height","8" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:26   */
      /* Termina nodo:25   */

      /* Empieza nodo:76 / Elemento padre: 7   */
      v.add(doc.createElement("table"));
      ((Element)v.get(76)).setAttribute("width","100%" );
      ((Element)v.get(76)).setAttribute("border","0" );
      ((Element)v.get(76)).setAttribute("cellspacing","0" );
      ((Element)v.get(76)).setAttribute("cellpadding","0" );
      ((Element)v.get(7)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).setAttribute("width","12" );
      ((Element)v.get(78)).setAttribute("align","center" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","12" );
      ((Element)v.get(79)).setAttribute("height","12" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:80 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).setAttribute("width","750" );
      ((Element)v.get(77)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(81)).setAttribute("src","b.gif" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:82 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).setAttribute("width","12" );
      ((Element)v.get(77)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(83)).setAttribute("src","b.gif" );
      ((Element)v.get(83)).setAttribute("width","12" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(83)).setAttribute("height","1" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */
      /* Termina nodo:77   */

      /* Empieza nodo:84 / Elemento padre: 76   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(76)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(89)).setAttribute("class","legend" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(90)).setAttribute("nombre","lblAlcance" );
      ((Element)v.get(90)).setAttribute("alto","13" );
      ((Element)v.get(90)).setAttribute("filas","1" );
      ((Element)v.get(90)).setAttribute("valor","" );
      ((Element)v.get(90)).setAttribute("cod","00100" );
      ((Element)v.get(90)).setAttribute("id","legend" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:91 / Elemento padre: 88   */
      v.add(doc.createElement("table"));
      ((Element)v.get(91)).setAttribute("width","100%" );
      ((Element)v.get(91)).setAttribute("border","0" );
      ((Element)v.get(91)).setAttribute("align","center" );
      ((Element)v.get(91)).setAttribute("cellspacing","0" );
      ((Element)v.get(91)).setAttribute("cellpadding","0" );
      ((Element)v.get(88)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("table"));
      ((Element)v.get(94)).setAttribute("width","400" );
      ((Element)v.get(94)).setAttribute("border","0" );
      ((Element)v.get(94)).setAttribute("align","left" );
      ((Element)v.get(94)).setAttribute("cellspacing","0" );
      ((Element)v.get(94)).setAttribute("cellpadding","0" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).setAttribute("colspan","4" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(97)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).setAttribute("width","8" );
      ((Element)v.get(97)).setAttribute("height","8" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:98 / Elemento padre: 94   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(94)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(100)).setAttribute("src","b.gif" );
      ((Element)v.get(100)).setAttribute("width","8" );
      ((Element)v.get(100)).setAttribute("height","8" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:101 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(102)).setAttribute("nombre","lblNacional" );
      ((Element)v.get(102)).setAttribute("alto","13" );
      ((Element)v.get(102)).setAttribute("filas","1" );
      ((Element)v.get(102)).setAttribute("valor","" );
      ((Element)v.get(102)).setAttribute("id","datosTitle" );
      ((Element)v.get(102)).setAttribute("cod","926" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).setAttribute("width","100%" );
      ((Element)v.get(98)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(104)).setAttribute("width","105" );
      ((Element)v.get(104)).setAttribute("height","8" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */
      /* Termina nodo:98   */

      /* Empieza nodo:105 / Elemento padre: 94   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(94)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(107)).setAttribute("src","b.gif" );
      ((Element)v.get(107)).setAttribute("width","8" );
      ((Element)v.get(107)).setAttribute("height","8" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:108 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).setAttribute("class","datosCampos" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(105)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(109)).setAttribute("nombre","rbNacional" );
      ((Element)v.get(109)).setAttribute("tipo","H" );
      ((Element)v.get(109)).setAttribute("id","datosCampos" );
      ((Element)v.get(109)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnEliminar')" );
      ((Element)v.get(109)).setAttribute("ontab","focalizaBotonHTML('botonContenido','btnSiguiente')" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(110)).setAttribute("valor","S" );
      ((Element)v.get(110)).setAttribute("check","N" );
      ((Element)v.get(110)).setAttribute("onfocus","" );
      ((Element)v.get(110)).setAttribute("id","datosCampos" );
      ((Element)v.get(110)).setAttribute("cod","117" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Elemento padre:110 / Elemento actual: 111   */
      v.add(doc.createTextNode("yy"));
      ((Element)v.get(110)).appendChild((Text)v.get(111));

      /* Termina nodo Texto:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:112 / Elemento padre: 109   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(112)).setAttribute("valor","N" );
      ((Element)v.get(112)).setAttribute("check","N" );
      ((Element)v.get(112)).setAttribute("onfocus","" );
      ((Element)v.get(112)).setAttribute("id","datosCampos" );
      ((Element)v.get(112)).setAttribute("cod","87" );
      ((Element)v.get(109)).appendChild((Element)v.get(112));

      /* Elemento padre:112 / Elemento actual: 113   */
      v.add(doc.createTextNode("nn"));
      ((Element)v.get(112)).appendChild((Text)v.get(113));

      /* Termina nodo Texto:113   */
      /* Termina nodo:112   */
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:114 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).setAttribute("width","100%" );
      ((Element)v.get(105)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(115)).setAttribute("src","b.gif" );
      ((Element)v.get(115)).setAttribute("width","8" );
      ((Element)v.get(115)).setAttribute("height","8" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */
      /* Termina nodo:105   */

      /* Empieza nodo:116 / Elemento padre: 94   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(94)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).setAttribute("colspan","4" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(118)).setAttribute("src","b.gif" );
      ((Element)v.get(118)).setAttribute("width","8" );
      ((Element)v.get(118)).setAttribute("height","8" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:116   */
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:91   */
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:119 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(120)).setAttribute("src","b.gif" );
      ((Element)v.get(120)).setAttribute("width","8" );
      ((Element)v.get(120)).setAttribute("height","12" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:84   */

      /* Empieza nodo:121 / Elemento padre: 76   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(76)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).setAttribute("width","12" );
      ((Element)v.get(122)).setAttribute("align","center" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(123)).setAttribute("src","b.gif" );
      ((Element)v.get(123)).setAttribute("width","12" );
      ((Element)v.get(123)).setAttribute("height","24" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:124 / Elemento padre: 121   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).setAttribute("width","750" );
      ((Element)v.get(121)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(125)).setAttribute("src","b.gif" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */

      /* Empieza nodo:126 / Elemento padre: 121   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).setAttribute("width","12" );
      ((Element)v.get(121)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(127)).setAttribute("src","b.gif" );
      ((Element)v.get(127)).setAttribute("width","12" );
      ((Element)v.get(127)).setAttribute("height","24" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:121   */
      /* Termina nodo:76   */

      /* Empieza nodo:128 / Elemento padre: 7   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(128)).setAttribute("nombre","listado1" );
      ((Element)v.get(128)).setAttribute("ancho","404" );
      ((Element)v.get(128)).setAttribute("alto","317" );
      ((Element)v.get(128)).setAttribute("x","12" );
      ((Element)v.get(128)).setAttribute("y","119" );
      ((Element)v.get(128)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(128)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(7)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(129)).setAttribute("precarga","S" );
      ((Element)v.get(129)).setAttribute("conROver","S" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("BTNSELECCION"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(130)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(130)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(130)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(130)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */

      /* Empieza nodo:131 / Elemento padre: 129   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(131)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(131)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(131)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(131)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(129)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */

      /* Empieza nodo:132 / Elemento padre: 129   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(132)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(132)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(129)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:129   */

      /* Empieza nodo:133 / Elemento padre: 128   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(128)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(134)).setAttribute("borde","1" );
      ((Element)v.get(134)).setAttribute("horizDatos","1" );
      ((Element)v.get(134)).setAttribute("horizCabecera","1" );
      ((Element)v.get(134)).setAttribute("vertical","0" );
      ((Element)v.get(134)).setAttribute("horizTitulo","1" );
      ((Element)v.get(134)).setAttribute("horizBase","1" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */

      /* Empieza nodo:135 / Elemento padre: 133   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(135)).setAttribute("borde","#999999" );
      ((Element)v.get(135)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(135)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(135)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(135)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(135)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(135)).setAttribute("horizBase","#999999" );
      ((Element)v.get(133)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:133   */

      /* Empieza nodo:136 / Elemento padre: 128   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(136)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(136)).setAttribute("alto","22" );
      ((Element)v.get(136)).setAttribute("imgFondo","" );
      ((Element)v.get(136)).setAttribute("cod","0043" );
      ((Element)v.get(136)).setAttribute("ID","datosTitle" );
      ((Element)v.get(128)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */

      /* Empieza nodo:137 / Elemento padre: 128   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(137)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(137)).setAttribute("alto","22" );
      ((Element)v.get(137)).setAttribute("imgFondo","" );
      ((Element)v.get(128)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */

      /* Empieza nodo:138 / Elemento padre: 128   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(138)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(138)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(138)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(138)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(138)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(138)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(128)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(139)).setAttribute("ancho","30" );
      ((Element)v.get(139)).setAttribute("minimizable","S" );
      ((Element)v.get(139)).setAttribute("minimizada","N" );
      ((Element)v.get(139)).setAttribute("oculta","S" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */

      /* Empieza nodo:140 / Elemento padre: 138   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(140)).setAttribute("ancho","240" );
      ((Element)v.get(140)).setAttribute("minimizable","S" );
      ((Element)v.get(140)).setAttribute("minimizada","N" );
      ((Element)v.get(138)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */

      /* Empieza nodo:141 / Elemento padre: 138   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(141)).setAttribute("ancho","30" );
      ((Element)v.get(141)).setAttribute("minimizable","S" );
      ((Element)v.get(141)).setAttribute("minimizada","N" );
      ((Element)v.get(141)).setAttribute("oculta","S" );
      ((Element)v.get(138)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */

      /* Empieza nodo:142 / Elemento padre: 138   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(142)).setAttribute("ancho","240" );
      ((Element)v.get(142)).setAttribute("minimizable","S" );
      ((Element)v.get(142)).setAttribute("minimizada","N" );
      ((Element)v.get(138)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */

      /* Empieza nodo:143 / Elemento padre: 138   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(143)).setAttribute("ancho","30" );
      ((Element)v.get(143)).setAttribute("minimizable","S" );
      ((Element)v.get(143)).setAttribute("minimizada","N" );
      ((Element)v.get(143)).setAttribute("oculta","S" );
      ((Element)v.get(138)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */

      /* Empieza nodo:144 / Elemento padre: 138   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(144)).setAttribute("ancho","240" );
      ((Element)v.get(144)).setAttribute("minimizable","S" );
      ((Element)v.get(144)).setAttribute("minimizada","N" );
      ((Element)v.get(138)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */

      /* Empieza nodo:145 / Elemento padre: 138   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(145)).setAttribute("ancho","150" );
      ((Element)v.get(145)).setAttribute("minimizable","S" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(145)).setAttribute("minimizada","N" );
      ((Element)v.get(145)).setAttribute("orden","" );
      ((Element)v.get(138)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:138   */

      /* Empieza nodo:146 / Elemento padre: 128   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(146)).setAttribute("alto","20" );
      ((Element)v.get(146)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(146)).setAttribute("imgFondo","" );
      ((Element)v.get(146)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(128)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(147)).setAttribute("colFondo","" );
      ((Element)v.get(147)).setAttribute("ID","EstCab" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));

      /* Elemento padre:147 / Elemento actual: 148   */
      v.add(doc.createTextNode("oidSubgerenciaVentas"));
      ((Element)v.get(147)).appendChild((Text)v.get(148));

      /* Termina nodo Texto:148   */
      /* Termina nodo:147   */

      /* Empieza nodo:149 / Elemento padre: 146   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(149)).setAttribute("colFondo","" );
      ((Element)v.get(149)).setAttribute("ID","EstCab" );
      ((Element)v.get(149)).setAttribute("align","center" );
      ((Element)v.get(149)).setAttribute("cod","124" );
      ((Element)v.get(146)).appendChild((Element)v.get(149));

      /* Elemento padre:149 / Elemento actual: 150   */
      v.add(doc.createTextNode("Subgerencia ventas"));
      ((Element)v.get(149)).appendChild((Text)v.get(150));

      /* Termina nodo Texto:150   */
      /* Termina nodo:149   */

      /* Empieza nodo:151 / Elemento padre: 146   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(151)).setAttribute("colFondo","" );
      ((Element)v.get(151)).setAttribute("ID","EstCab" );
      ((Element)v.get(146)).appendChild((Element)v.get(151));

      /* Elemento padre:151 / Elemento actual: 152   */
      v.add(doc.createTextNode("oidRegion"));
      ((Element)v.get(151)).appendChild((Text)v.get(152));

      /* Termina nodo Texto:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:153 / Elemento padre: 146   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(153)).setAttribute("colFondo","" );
      ((Element)v.get(153)).setAttribute("ID","EstCab" );
      ((Element)v.get(153)).setAttribute("cod","1308" );
      ((Element)v.get(146)).appendChild((Element)v.get(153));

      /* Elemento padre:153 / Elemento actual: 154   */
      v.add(doc.createTextNode("Regiones"));
      ((Element)v.get(153)).appendChild((Text)v.get(154));

      /* Termina nodo Texto:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:155 / Elemento padre: 146   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(155)).setAttribute("colFondo","" );
      ((Element)v.get(155)).setAttribute("ID","EstCab" );
      ((Element)v.get(146)).appendChild((Element)v.get(155));

      /* Elemento padre:155 / Elemento actual: 156   */
      v.add(doc.createTextNode("oidZona"));
      ((Element)v.get(155)).appendChild((Text)v.get(156));

      /* Termina nodo Texto:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:157 / Elemento padre: 146   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(157)).setAttribute("colFondo","" );
      ((Element)v.get(157)).setAttribute("ID","EstCab" );
      ((Element)v.get(157)).setAttribute("cod","1309" );
      ((Element)v.get(146)).appendChild((Element)v.get(157));

      /* Elemento padre:157 / Elemento actual: 158   */
      v.add(doc.createTextNode("Zonas"));
      ((Element)v.get(157)).appendChild((Text)v.get(158));

      /* Termina nodo Texto:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:159 / Elemento padre: 146   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(159)).setAttribute("colFondo","" );
      ((Element)v.get(159)).setAttribute("ID","EstCab" );
      ((Element)v.get(159)).setAttribute("cod","791" );
      ((Element)v.get(146)).appendChild((Element)v.get(159));

      /* Elemento padre:159 / Elemento actual: 160   */
      v.add(doc.createTextNode("Porcentaje adiccional dto."));
      ((Element)v.get(159)).appendChild((Text)v.get(160));

      /* Termina nodo Texto:160   */
      /* Termina nodo:159   */
      /* Termina nodo:146   */

      /* Empieza nodo:161 / Elemento padre: 128   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(161)).setAttribute("alto","22" );
      ((Element)v.get(161)).setAttribute("accion","" );
      ((Element)v.get(161)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(161)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(161)).setAttribute("maxSel","-1" );
      ((Element)v.get(161)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(161)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(161)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(161)).setAttribute("onLoad","" );
      ((Element)v.get(161)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(128)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(162)).setAttribute("tipo","texto" );
      ((Element)v.get(162)).setAttribute("ID","EstDat" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */

      /* Empieza nodo:163 / Elemento padre: 161   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(163)).setAttribute("tipo","texto" );
      ((Element)v.get(163)).setAttribute("ID","EstDat" );
      ((Element)v.get(161)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */

      /* Empieza nodo:164 / Elemento padre: 161   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(164)).setAttribute("tipo","texto" );
      ((Element)v.get(164)).setAttribute("ID","EstDat2" );
      ((Element)v.get(161)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */

      /* Empieza nodo:165 / Elemento padre: 161   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(165)).setAttribute("tipo","texto" );
      ((Element)v.get(165)).setAttribute("ID","EstDat2" );
      ((Element)v.get(161)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */

      /* Empieza nodo:166 / Elemento padre: 161   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(166)).setAttribute("tipo","texto" );
      ((Element)v.get(166)).setAttribute("ID","EstDat" );
      ((Element)v.get(161)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */

      /* Empieza nodo:167 / Elemento padre: 161   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(167)).setAttribute("tipo","texto" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(167)).setAttribute("ID","EstDat" );
      ((Element)v.get(161)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */

      /* Empieza nodo:168 / Elemento padre: 161   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(168)).setAttribute("tipo","texto" );
      ((Element)v.get(168)).setAttribute("ID","EstDat2" );
      ((Element)v.get(161)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:161   */

      /* Empieza nodo:169 / Elemento padre: 128   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(128)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */

      /* Empieza nodo:170 / Elemento padre: 128   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(170)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(170)).setAttribute("ancho","726" );
      ((Element)v.get(170)).setAttribute("sep","$" );
      ((Element)v.get(170)).setAttribute("x","12" );
      ((Element)v.get(170)).setAttribute("class","botonera" );
      ((Element)v.get(170)).setAttribute("y","413" );
      ((Element)v.get(170)).setAttribute("control","|" );
      ((Element)v.get(170)).setAttribute("conector","" );
      ((Element)v.get(170)).setAttribute("rowset","" );
      ((Element)v.get(170)).setAttribute("cargainicial","N" );
      ((Element)v.get(128)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(171)).setAttribute("nombre","ret1" );
      ((Element)v.get(171)).setAttribute("x","37" );
      ((Element)v.get(171)).setAttribute("y","417" );
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
      ((Element)v.get(172)).setAttribute("y","417" );
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
      /* Termina nodo:128   */

      /* Empieza nodo:173 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(173)).setAttribute("nombre","primera1" );
      ((Element)v.get(173)).setAttribute("x","20" );
      ((Element)v.get(173)).setAttribute("y","417" );
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
      ((Element)v.get(174)).setAttribute("y","413" );
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
      ((Element)v.get(175)).setAttribute("nombre","btnSiguiente" );
      ((Element)v.get(175)).setAttribute("x","13" );
      ((Element)v.get(175)).setAttribute("y","414" );
      ((Element)v.get(175)).setAttribute("ID","botonContenido" );
      ((Element)v.get(175)).setAttribute("tipo","html" );
      ((Element)v.get(175)).setAttribute("estado","false" );
      ((Element)v.get(175)).setAttribute("cod","446" );
      ((Element)v.get(175)).setAttribute("accion","siguiente();" );
      ((Element)v.get(175)).setAttribute("ontab","onTabSiguiente();" );
      ((Element)v.get(175)).setAttribute("onshtab","onShTabSiguiente();" );
      ((Element)v.get(7)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */

      /* Empieza nodo:176 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(176)).setAttribute("nombre","btnAnadir" );
      ((Element)v.get(176)).setAttribute("x","79" );
      ((Element)v.get(176)).setAttribute("y","414" );
      ((Element)v.get(176)).setAttribute("ID","botonContenido" );
      ((Element)v.get(176)).setAttribute("tipo","html" );
      ((Element)v.get(176)).setAttribute("estado","false" );
      ((Element)v.get(176)).setAttribute("cod","404" );
      ((Element)v.get(176)).setAttribute("accion","accionAniadir();" );
      ((Element)v.get(176)).setAttribute("ontab","focalizaBotonHTML_XY('btnEliminar');" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(176)).setAttribute("onshtab","focalizaBotonHTML_XY('btnSiguiente');" );
      ((Element)v.get(7)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */

      /* Empieza nodo:177 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(177)).setAttribute("nombre","btnEliminar" );
      ((Element)v.get(177)).setAttribute("x","127" );
      ((Element)v.get(177)).setAttribute("y","414" );
      ((Element)v.get(177)).setAttribute("ID","botonContenido" );
      ((Element)v.get(177)).setAttribute("tipo","html" );
      ((Element)v.get(177)).setAttribute("estado","false" );
      ((Element)v.get(177)).setAttribute("cod","1254" );
      ((Element)v.get(177)).setAttribute("accion","accionEliminar();" );
      ((Element)v.get(177)).setAttribute("ontab","focaliza('formulario.rbNacional');" );
      ((Element)v.get(177)).setAttribute("onshtab","focalizaBotonHTML_XY('btnAnadir');" );
      ((Element)v.get(7)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */

      /* Empieza nodo:178 / Elemento padre: 7   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(178)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(178)).setAttribute("alto","12" );
      ((Element)v.get(178)).setAttribute("ancho","2" );
      ((Element)v.get(178)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(178)).setAttribute("borde","0" );
      ((Element)v.get(178)).setAttribute("x","0" );
      ((Element)v.get(178)).setAttribute("y","436" );
      ((Element)v.get(7)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:7   */


   }

}
