
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_descuentos_buscar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_descuentos_buscar" );
      ((Element)v.get(0)).setAttribute("cod","0233" );
      ((Element)v.get(0)).setAttribute("titulo","Consultar descuentoes" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag()" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Elemento padre:1 / Elemento actual: 2   */
      v.add(doc.createTextNode("\r   \r	var formName = \"formulario\";\r    \r    function onLoadPag()   {\r        configurarMenuSecundario('formulario');\r        ocultarLista();\r\r        DrdEnsanchaConMargenDcho('listado1',12);\r        /* document.all[\"Cplistado1\"].style.visibility='';\r        document.all[\"CpLin1listado1\"].style.visibility='';\r        document.all[\"CpLin2listado1\"].style.visibility='';\r        document.all[\"CpLin3listado1\"].style.visibility='';\r        document.all[\"CpLin4listado1\"].style.visibility='';\r        document.all[\"separaDiv\"].style.visibility='';\r        document.all[\"primera1Div\"].style.visibility='';\r        document.all[\"ret1Div\"].style.visibility='';\r        document.all[\"ava1Div\"].style.visibility='';\r        document.all[\"btnDetalleDiv\"].style.visibility='';\r        document.all[\"btnModificarDiv\"].style.visibility='hidden';	  */  	    \r        eval (ON_RSZ);  \r\r        txt_to('lbldtPais',get('formulario.descPais'));\r        focaliza('formulario.txtNumDescuento');\r\r        if(get(\"formulario.caso\")==\"volver\"){\r				            volver();\r			}\r\r           if(get(\"formulario.casoDeUso\")==\"eliminar\")\r                listado1.maxSel = -1;\r            else listado1.maxSel = 1;\r    }\r\r    function ocultarLista() {\r        document.all[\"Cplistado1\"].style.visibility='hidden';\r        document.all[\"CpLin1listado1\"].style.visibility='hidden';\r        document.all[\"CpLin2listado1\"].style.visibility='hidden';\r        document.all[\"CpLin3listado1\"].style.visibility='hidden';\r        document.all[\"CpLin4listado1\"].style.visibility='hidden';\r        document.all[\"separaDiv\"].style.visibility='hidden';\r        document.all[\"primera1Div\"].style.visibility='hidden';\r        document.all[\"ret1Div\"].style.visibility='hidden';\r        document.all[\"ava1Div\"].style.visibility='hidden';\r        document.all[\"btnDetalleDiv\"].style.visibility='hidden';\r        document.all[\"btnModificarDiv\"].style.visibility='hidden';	 \r    }\r\r    function mostrarLista() {\r	  document.all[\"Cplistado1\"].style.visibility='visible';\r        document.all[\"CpLin1listado1\"].style.visibility='visible';\r        document.all[\"CpLin2listado1\"].style.visibility='visible';\r        document.all[\"CpLin3listado1\"].style.visibility='visible';\r        document.all[\"CpLin4listado1\"].style.visibility='visible';\r        document.all[\"separaDiv\"].style.visibility='visible';\r        document.all[\"primera1Div\"].style.visibility='visible';\r        document.all[\"ret1Div\"].style.visibility='visible';\r        document.all[\"ava1Div\"].style.visibility='visible';\r\r      if (get('formulario.casoDeUso')=='modificar')\r        document.all[\"btnModificarDiv\"].style.visibility='visible';	 \r\r      if (get('formulario.casoDeUso')=='consultar')\r		  document.all[\"btnDetalleDiv\"].style.visibility='visible';\r\r      if (get('formulario.casoDeUso')=='eliminar'){\r        document.all[\"btnDetalleDiv\"].style.visibility='visible';\r		 btnProxy(4, '1');	\r      }\r\r    }\r\r    function fLimpiar(){\r        limpiaCombos();       \r        txt_to('lbldtPais',get('formulario.descPais'));\r        set(\"formulario.txtNumDescuento\", \"\");\r        set(\"formulario.txtDescripcion\", \"\");\r        set(\"formulario.cbMatrizActiva\", \"\");\r        set(\"formulario.cbMarca\", \"\");\r        set(\"formulario.cbCanal\", \"\");  \r        \r        focaliza('formulario.txtNumDescuento')\r            }\r\r    function limpiaCombos()\r    {\r        var datosNuevo = new Array();\r        datosNuevo[0] = [\"\",\"\"];    \r        set_combo(\"formulario.cbPeriodoDesde\", datosNuevo);\r        set_combo(\"formulario.cbPeriodoHasta\", datosNuevo);\r    }\r\r    function buscar(){\r        if(sicc_validaciones_generales())\r         configurarPaginado (mipgndo,'DTOBuscarDescuentos','ConectorBuscarDescuentos','es.indra.sicc.dtos.dto.DTOEBuscarDescuentos', armarArray());\r    }\r\r    function armarArray()\r    {\r        var vArray = new Array();\r        var i = 0;\r        vArray[i] = new Array('oidIdioma',get(\"formulario.oidIdioma\"));\r        i++;\r        vArray[i] = new Array('oidPais',get(\"formulario.oidPais\"));\r        i++;\r        \r        if (get('formulario.txtNumDescuento')!=''){\r            vArray[i] = new Array('oidDescuento',get('formulario.txtNumDescuento'));\r            i++;\r        }\r\r        if (get('formulario.txtDescripcion')!=''){\r            vArray[i] = new Array('descripcion',get('formulario.txtDescripcion'));\r            i++;\r        }\r        if (get('formulario.cbMarca','V')!=''){\r            vArray[i] = new Array('oidMarca',get('formulario.cbMarca','V'));\r            i++;\r        }\r        if (get('formulario.cbCanal','V')!=''){\r            vArray[i] = new Array('oidCanal',get('formulario.cbCanal','V'));\r            i++;\r        }\r\r        if (get('formulario.cbPeriodoDesde','V')!=''){\r            vArray[i] = new Array('oidPeriodoDesde',get('formulario.cbPeriodoDesde','V'));\r            i++;\r        }\r        if (get('formulario.cbPeriodoHasta','V')!=''){\r            vArray[i] = new Array('oidPeriodoHasta',get('formulario.cbPeriodoHasta','V'));\r            i++;\r        }\r        if (get('formulario.cbActiva','V')!=''){\r            vArray[i] = new Array('activo',get('formulario.cbActiva','V'));\r            i++;\r        }\r	return vArray;\r    }\r\r\r   function seleccionar(caso){\r        if(listado1.numSelecc() > 1) {\r        	GestionarMensaje('2525', null, null, null);\r        	return ;\r        }else{\r\r				if (listado1.numSelecc() != 0) {\r		 /*cambios a generados a raiz de la incidencia 19064\r		   pperez */\r			 \r			 var oid;\r			 var obj = new Object();\r			 if(caso == 1) obj.casoDeUso = 'consultar';\r			 if(caso == 2) obj.casoDeUso = 'modificar';\r\r			 var codigo = listado1.codSeleccionados();\r			 obj.codSeleccionados =  codigo[0];\r\r			 var whnd = mostrarModalSICC('LPMantenimientoDTO','seleccionar',obj);\r			 buscar();\r		} else {\r			GestionarMensaje('50', null, null, null);\r			return ;			\r		}\r	}\r   }\r\r   function fBorrar(){\r        accionEliminar();\r    }\r\r    function accionEliminar ()\r    {\r        if(listado1.numSelecc() > 0)\r        {            \r            var listaOidsEliminar = \"\";\r            var codigo = \"\";\r        \r            codigo = listado1.codSeleccionados();\r            for(var a = 0; a < codigo.length ; a++){\r                listaOidsEliminar = listado1.extraeDato(codigo[a], 0);\r            } \r            \r            eliminarFilas(listado1.codSeleccionados(),'DTOEliminarDescuentos', mipgndo);\r        }else{\r            GestionarMensaje('406');\r        	return ;\r        }\r    }\r\r    function checkTable(){\r		if(document.all[\"Cplistado1\"].style.visibility == 'hidden') {\r		  focalizaBotonHTML('botonContenido','btnBuscar');\r		} else {\r		  if(get('formulario.casoDeUso') == \"consultar\" || get('formulario.casoDeUso')== \"eliminar\")     \r			focalizaBotonHTML('botonContenido','btnDetalle');\r		 else\r			focalizaBotonHTML('botonContenido','btnModificar');\r		}\r	}\r\r\r	function checkTable2(){\r		if(document.all[\"Cplistado1\"].style.visibility == 'hidden') {\r		  focaliza('formulario.txtNumDescuento');\r		} else {\r		  if(get('formulario.casoDeUso') == \"consultar\" || get('formulario.casoDeUso') == \"eliminar\")     \r			focalizaBotonHTML('botonContenido','btnDetalle');\r		 else\r			focalizaBotonHTML('botonContenido','btnModificar');\r		}\r	}\r\r\r	function prueba(ultima, rowset, error){\r    var tamano = rowset.length;\r    \r		if (tamano > 0) {\r			 document.all[\"Cplistado1\"].style.visibility='';\r			 document.all[\"CpLin1listado1\"].style.visibility='';\r			 document.all[\"CpLin2listado1\"].style.visibility='';\r			 document.all[\"CpLin3listado1\"].style.visibility='';\r			 document.all[\"CpLin4listado1\"].style.visibility='';\r			 document.all[\"primera1Div\"].style.visibility='';\r			 document.all[\"ret1Div\"].style.visibility='';\r			 document.all[\"ava1Div\"].style.visibility='';\r			 document.all[\"separaDiv\"].style.visibility='';\r			 document.all[\"btnDetalleDiv\"].style.visibility='visible';\r			 eval (ON_RSZ);\r\r			 if (get('formulario.casoDeUso')=='modificar')\r				 document.all[\"btnModificarDiv\"].style.visibility='visible';\r			 if(get('formulario.casoDeUso')=='eliminar')\r				btnProxy(4, '1');	\r			 return true;\r		}  else {\r			 document.all[\"Cplistado1\"].style.visibility='hidden';\r			 document.all[\"CpLin1listado1\"].style.visibility='hidden';\r			 document.all[\"CpLin2listado1\"].style.visibility='hidden';\r			 document.all[\"CpLin3listado1\"].style.visibility='hidden';\r			 document.all[\"CpLin4listado1\"].style.visibility='hidden';\r			 document.all[\"primera1Div\"].style.visibility='hidden';\r			 document.all[\"ret1Div\"].style.visibility='hidden';\r			 document.all[\"ava1Div\"].style.visibility='hidden';\r			 document.all[\"separaDiv\"].style.visibility='hidden';\r			 document.all[\"btnDetalleDiv\"].style.visibility='hidden';\r			 document.all[\"btnModificarDiv\"].style.visibility='hidden';\r							\r			  focaliza('formulario.txtNumDescuento','');\r			  cdos_mostrarAlert(error); \r			  return false;\r		}\r  } \r\r  function volver(){\r        set(\"formulario.txtNumDescuento\",get(\"formulario.oidDescuento\"));\r        set(\"formulario.txtDescripcion\",get(\"formulario.descripcion\"));\r        set(\"formulario.cbMarca\",new Array(get(\"formulario.oidMarca\")));\r        set(\"formulario.cbCanal\",new Array(get(\"formulario.oidCanal\")));\r        set(\"formulario.cbPeriodoDesde\",new Array(get(\"formulario.periodoDesde\")));\r        set(\"formulario.cbPeriodoHasta\",new Array(get(\"formulario.periodoHasta\")));\r        set(\"formulario.cbActiva\",new Array(get(\"formulario.activo\")));\r        buscar();\r  }\r\r\r    function marcaOnChange(){\r        if (get('formulario.cbMarca','V') != '' &&  get('formulario.cbCanal','V') != ''){\r            recargaCombo(formName + \".cbPeriodoDesde\",\"CRAObtenerPeriodos\",\"es.indra.sicc.dtos.cra.DTOPeriodo\",makeParametersMarcaOnChange(),\"\");\r            recargaCombo(formName + \".cbPeriodoHasta\",\"CRAObtenerPeriodos\",\"es.indra.sicc.dtos.cra.DTOPeriodo\",makeParametersMarcaOnChange(),\"\");	\r            }\r        else\r        {\r            var datosNuevo = new Array();\r            datosNuevo[0] = [\"\",\"\"];    \r            set_combo(\"formulario.cbPeriodoDesde\", datosNuevo);\r            set_combo(\"formulario.cbPeriodoHasta\", datosNuevo);\r        }\r    }\r\r    function makeParametersMarcaOnChange() {\r        var parametros = new Array([],[],[]);\r\r        parametros[0][0] = 'pais';\r        parametros[0][1] = get('formulario.oidPais');        \r\r        parametros[1][0] = 'marca';\r        parametros[1][1]= get('formulario.cbMarca','V');\r\r        parametros[2][0] = 'canal';\r        parametros[2][1]= get('formulario.cbCanal','V');\r\r        return parametros;    \r    }\r\r\r    function canalOnChange(){\r                {\r            marcaOnChange();\r        }\r        \r    }\r    \r   \r"));
      ((Element)v.get(1)).appendChild((Text)v.get(2));

      /* Termina nodo Texto:2   */
      /* Termina nodo:1   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","txtNumDescuento" );
      ((Element)v.get(7)).setAttribute("required","false" );
      ((Element)v.get(7)).setAttribute("cod","933" );
      ((Element)v.get(7)).setAttribute("format","e" );
      ((Element)v.get(7)).setAttribute("min","0" );
      ((Element)v.get(7)).setAttribute("max","99999" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */
      /* Termina nodo:6   */

      /* Empieza nodo:8 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(8)).setAttribute("nombre","formulario" );
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
      ((Element)v.get(11)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","caso" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","multRowSel" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","oidIdioma" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","oidPais" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","descPais" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","oidDescuento" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","descripcion" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","oidMarca" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","oidCanal" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","periodoDesde" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","periodoHasta" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","activo" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","tipoAccion" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hidOidCabeceraSel" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","codSeleccionados" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 8   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(29)).setAttribute("nombre","capa1" );
      ((Element)v.get(8)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("table"));
      ((Element)v.get(30)).setAttribute("width","100%" );
      ((Element)v.get(30)).setAttribute("border","0" );
      ((Element)v.get(30)).setAttribute("cellspacing","0" );
      ((Element)v.get(30)).setAttribute("cellpadding","0" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(30)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(32)).setAttribute("width","12" );
      ((Element)v.get(32)).setAttribute("align","center" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(33)).setAttribute("src","b.gif" );
      ((Element)v.get(33)).setAttribute("width","12" );
      ((Element)v.get(33)).setAttribute("height","12" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */
      /* Termina nodo:32   */

      /* Empieza nodo:34 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(34)).setAttribute("width","750" );
      ((Element)v.get(31)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(35)).setAttribute("src","b.gif" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:36 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).setAttribute("width","12" );
      ((Element)v.get(31)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(37)).setAttribute("src","b.gif" );
      ((Element)v.get(37)).setAttribute("width","12" );
      ((Element)v.get(37)).setAttribute("height","1" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */
      /* Termina nodo:36   */
      /* Termina nodo:31   */

      /* Empieza nodo:38 / Elemento padre: 30   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(30)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("td"));
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(40)).setAttribute("src","b.gif" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */
      /* Termina nodo:39   */

      /* Empieza nodo:41 / Elemento padre: 38   */
      v.add(doc.createElement("td"));
      ((Element)v.get(38)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(43)).setAttribute("class","legend" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(44)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(44)).setAttribute("alto","13" );
      ((Element)v.get(44)).setAttribute("filas","1" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(44)).setAttribute("cod","0075" );
      ((Element)v.get(44)).setAttribute("id","legend" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:45 / Elemento padre: 42   */
      v.add(doc.createElement("table"));
      ((Element)v.get(45)).setAttribute("width","100%" );
      ((Element)v.get(45)).setAttribute("border","0" );
      ((Element)v.get(45)).setAttribute("align","center" );
      ((Element)v.get(45)).setAttribute("cellspacing","0" );
      ((Element)v.get(45)).setAttribute("cellpadding","0" );
      ((Element)v.get(42)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("tr"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("table"));
      ((Element)v.get(48)).setAttribute("width","675" );
      ((Element)v.get(48)).setAttribute("border","0" );
      ((Element)v.get(48)).setAttribute("align","left" );
      ((Element)v.get(48)).setAttribute("cellspacing","0" );
      ((Element)v.get(48)).setAttribute("cellpadding","0" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).setAttribute("colspan","4" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(51)).setAttribute("src","b.gif" );
      ((Element)v.get(51)).setAttribute("width","8" );
      ((Element)v.get(51)).setAttribute("height","8" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:52 / Elemento padre: 48   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(48)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(54)).setAttribute("src","b.gif" );
      ((Element)v.get(54)).setAttribute("width","8" );
      ((Element)v.get(54)).setAttribute("height","8" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:55 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(56)).setAttribute("nombre","lblPais" );
      ((Element)v.get(56)).setAttribute("alto","13" );
      ((Element)v.get(56)).setAttribute("filas","1" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(56)).setAttribute("id","datosTitle" );
      ((Element)v.get(56)).setAttribute("cod","5" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:57 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(58)).setAttribute("src","b.gif" );
      ((Element)v.get(58)).setAttribute("width","25" );
      ((Element)v.get(58)).setAttribute("height","8" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:59 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(60)).setAttribute("nombre","lblNumDescuento" );
      ((Element)v.get(60)).setAttribute("alto","13" );
      ((Element)v.get(60)).setAttribute("filas","1" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(60)).setAttribute("id","datosTitle" );
      ((Element)v.get(60)).setAttribute("cod","933" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(62)).setAttribute("width","25" );
      ((Element)v.get(62)).setAttribute("height","8" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(64)).setAttribute("nombre","lblDescripcion" );
      ((Element)v.get(64)).setAttribute("alto","13" );
      ((Element)v.get(64)).setAttribute("filas","1" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(64)).setAttribute("id","datosTitle" );
      ((Element)v.get(64)).setAttribute("cod","9" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(66)).setAttribute("src","b.gif" );
      ((Element)v.get(66)).setAttribute("width","25" );
      ((Element)v.get(66)).setAttribute("height","8" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:67 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(68)).setAttribute("nombre","lblActivo" );
      ((Element)v.get(68)).setAttribute("alto","13" );
      ((Element)v.get(68)).setAttribute("filas","1" );
      ((Element)v.get(68)).setAttribute("valor","" );
      ((Element)v.get(68)).setAttribute("id","datosTitle" );
      ((Element)v.get(68)).setAttribute("cod","795" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:69 / Elemento padre: 52   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).setAttribute("width","100%" );
      ((Element)v.get(69)).setAttribute("colspan","2" );
      ((Element)v.get(52)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(70)).setAttribute("src","b.gif" );
      ((Element)v.get(70)).setAttribute("width","8" );
      ((Element)v.get(70)).setAttribute("height","8" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */
      /* Termina nodo:52   */

      /* Empieza nodo:71 / Elemento padre: 48   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(48)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(73)).setAttribute("src","b.gif" );
      ((Element)v.get(73)).setAttribute("width","8" );
      ((Element)v.get(73)).setAttribute("height","8" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:74 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(75)).setAttribute("nombre","lbldtPais" );
      ((Element)v.get(75)).setAttribute("alto","13" );
      ((Element)v.get(75)).setAttribute("filas","1" );
      ((Element)v.get(75)).setAttribute("id","datosCampos" );
      ((Element)v.get(75)).setAttribute("valor","" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(77)).setAttribute("src","b.gif" );
      ((Element)v.get(77)).setAttribute("width","25" );
      ((Element)v.get(77)).setAttribute("height","8" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(79)).setAttribute("nombre","txtNumDescuento" );
      ((Element)v.get(79)).setAttribute("id","datosCampos" );
      ((Element)v.get(79)).setAttribute("max","5" );
      ((Element)v.get(79)).setAttribute("tipo","" );
      ((Element)v.get(79)).setAttribute("onchange","" );
      ((Element)v.get(79)).setAttribute("req","N" );
      ((Element)v.get(79)).setAttribute("size","5" );
      ((Element)v.get(79)).setAttribute("valor","" );
      ((Element)v.get(79)).setAttribute("validacion","" );
      ((Element)v.get(79)).setAttribute("onshtab","checkTable();" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:80 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(81)).setAttribute("src","b.gif" );
      ((Element)v.get(81)).setAttribute("width","25" );
      ((Element)v.get(81)).setAttribute("height","8" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:82 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(83)).setAttribute("nombre","txtDescripcion" );
      ((Element)v.get(83)).setAttribute("id","datosCampos" );
      ((Element)v.get(83)).setAttribute("max","40" );
      ((Element)v.get(83)).setAttribute("tipo","" );
      ((Element)v.get(83)).setAttribute("onchange","" );
      ((Element)v.get(83)).setAttribute("req","N" );
      ((Element)v.get(83)).setAttribute("size","40" );
      ((Element)v.get(83)).setAttribute("valor","" );
      ((Element)v.get(83)).setAttribute("validacion","" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:84 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(85)).setAttribute("src","b.gif" );
      ((Element)v.get(85)).setAttribute("width","25" );
      ((Element)v.get(85)).setAttribute("height","8" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:86 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(86)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(71)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(87)).setAttribute("nombre","cbActiva" );
      ((Element)v.get(87)).setAttribute("id","datosCampos" );
      ((Element)v.get(87)).setAttribute("size","1" );
      ((Element)v.get(87)).setAttribute("multiple","N" );
      ((Element)v.get(87)).setAttribute("req","N" );
      ((Element)v.get(87)).setAttribute("valorinicial","" );
      ((Element)v.get(87)).setAttribute("textoinicial","" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("ROW"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(89)).setAttribute("ID","1" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(90)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(90)).setAttribute("TIPO","STRING" );
      ((Element)v.get(90)).setAttribute("VALOR","true" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */

      /* Empieza nodo:91 / Elemento padre: 89   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(91)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(91)).setAttribute("TIPO","STRING" );
      ((Element)v.get(91)).setAttribute("VALOR","Sí" );
      ((Element)v.get(89)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:89   */

      /* Empieza nodo:92 / Elemento padre: 88   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(92)).setAttribute("ID","2" );
      ((Element)v.get(88)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(93)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(93)).setAttribute("TIPO","STRING" );
      ((Element)v.get(93)).setAttribute("VALOR","false" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */

      /* Empieza nodo:94 / Elemento padre: 92   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(94)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(94)).setAttribute("TIPO","STRING" );
      ((Element)v.get(94)).setAttribute("VALOR","No" );
      ((Element)v.get(92)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:92   */
      /* Termina nodo:88   */
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:95 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).setAttribute("width","100%" );
      ((Element)v.get(71)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(96)).setAttribute("src","b.gif" );
      ((Element)v.get(96)).setAttribute("width","8" );
      ((Element)v.get(96)).setAttribute("height","8" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:71   */

      /* Empieza nodo:97 / Elemento padre: 48   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(48)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).setAttribute("colspan","4" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(99)).setAttribute("src","b.gif" );
      ((Element)v.get(99)).setAttribute("width","8" );
      ((Element)v.get(99)).setAttribute("height","8" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:48   */
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:100 / Elemento padre: 45   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(45)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("table"));
      ((Element)v.get(102)).setAttribute("width","675" );
      ((Element)v.get(102)).setAttribute("border","0" );
      ((Element)v.get(102)).setAttribute("align","left" );
      ((Element)v.get(102)).setAttribute("cellspacing","0" );
      ((Element)v.get(102)).setAttribute("cellpadding","0" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(102)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(105)).setAttribute("src","b.gif" );
      ((Element)v.get(105)).setAttribute("width","8" );
      ((Element)v.get(105)).setAttribute("height","8" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:106 / Elemento padre: 103   */
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(107)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(107)).setAttribute("alto","13" );
      ((Element)v.get(107)).setAttribute("filas","1" );
      ((Element)v.get(107)).setAttribute("valor","" );
      ((Element)v.get(107)).setAttribute("id","datosTitle" );
      ((Element)v.get(107)).setAttribute("cod","6" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:108 / Elemento padre: 103   */
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(109)).setAttribute("src","b.gif" );
      ((Element)v.get(109)).setAttribute("width","25" );
      ((Element)v.get(109)).setAttribute("height","8" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:110 / Elemento padre: 103   */
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(111)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(111)).setAttribute("alto","13" );
      ((Element)v.get(111)).setAttribute("filas","1" );
      ((Element)v.get(111)).setAttribute("valor","" );
      ((Element)v.get(111)).setAttribute("id","datosTitle" );
      ((Element)v.get(111)).setAttribute("cod","7" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:112 / Elemento padre: 103   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(113)).setAttribute("src","b.gif" );
      ((Element)v.get(113)).setAttribute("width","25" );
      ((Element)v.get(113)).setAttribute("height","8" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:114 / Elemento padre: 103   */
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(115)).setAttribute("nombre","lblPeriodoDesde" );
      ((Element)v.get(115)).setAttribute("alto","13" );
      ((Element)v.get(115)).setAttribute("filas","1" );
      ((Element)v.get(115)).setAttribute("valor","" );
      ((Element)v.get(115)).setAttribute("id","datosTitle" );
      ((Element)v.get(115)).setAttribute("cod","1175" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:116 / Elemento padre: 103   */
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(117)).setAttribute("src","b.gif" );
      ((Element)v.get(117)).setAttribute("width","25" );
      ((Element)v.get(117)).setAttribute("height","8" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 103   */
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(119)).setAttribute("nombre","lblPeriodoHasta" );
      ((Element)v.get(119)).setAttribute("alto","13" );
      ((Element)v.get(119)).setAttribute("filas","1" );
      ((Element)v.get(119)).setAttribute("valor","" );
      ((Element)v.get(119)).setAttribute("id","datosTitle" );
      ((Element)v.get(119)).setAttribute("cod","1176" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:120 / Elemento padre: 103   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).setAttribute("width","100%" );
      ((Element)v.get(120)).setAttribute("colspan","2" );
      ((Element)v.get(103)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(121)).setAttribute("width","8" );
      ((Element)v.get(121)).setAttribute("height","8" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */
      /* Termina nodo:103   */

      /* Empieza nodo:122 / Elemento padre: 102   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(102)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(124)).setAttribute("src","b.gif" );
      ((Element)v.get(124)).setAttribute("width","8" );
      ((Element)v.get(124)).setAttribute("height","8" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:125 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(122)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(126)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(126)).setAttribute("id","datosCampos" );
      ((Element)v.get(126)).setAttribute("size","1" );
      ((Element)v.get(126)).setAttribute("multiple","N" );
      ((Element)v.get(126)).setAttribute("req","N" );
      ((Element)v.get(126)).setAttribute("valorinicial","" );
      ((Element)v.get(126)).setAttribute("textoinicial","" );
      ((Element)v.get(126)).setAttribute("onchange","marcaOnChange();" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:128 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(129)).setAttribute("src","b.gif" );
      ((Element)v.get(129)).setAttribute("width","25" );
      ((Element)v.get(129)).setAttribute("height","8" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:130 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(122)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(131)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(131)).setAttribute("id","datosCampos" );
      ((Element)v.get(131)).setAttribute("size","1" );
      ((Element)v.get(131)).setAttribute("multiple","N" );
      ((Element)v.get(131)).setAttribute("req","N" );
      ((Element)v.get(131)).setAttribute("valorinicial","" );
      ((Element)v.get(131)).setAttribute("textoinicial","" );
      ((Element)v.get(131)).setAttribute("onchange","canalOnChange();" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:133 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(122)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(134)).setAttribute("src","b.gif" );
      ((Element)v.get(134)).setAttribute("width","25" );
      ((Element)v.get(134)).setAttribute("height","8" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:135 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(135)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(122)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(136)).setAttribute("nombre","cbPeriodoDesde" );
      ((Element)v.get(136)).setAttribute("id","datosCampos" );
      ((Element)v.get(136)).setAttribute("size","1" );
      ((Element)v.get(136)).setAttribute("multiple","N" );
      ((Element)v.get(136)).setAttribute("req","N" );
      ((Element)v.get(136)).setAttribute("valorinicial","" );
      ((Element)v.get(136)).setAttribute("textoinicial","" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:138 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(139)).setAttribute("src","b.gif" );
      ((Element)v.get(139)).setAttribute("width","25" );
      ((Element)v.get(139)).setAttribute("height","8" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */

      /* Empieza nodo:140 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(122)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(141)).setAttribute("nombre","cbPeriodoHasta" );
      ((Element)v.get(141)).setAttribute("id","datosCampos" );
      ((Element)v.get(141)).setAttribute("size","1" );
      ((Element)v.get(141)).setAttribute("multiple","N" );
      ((Element)v.get(141)).setAttribute("req","N" );
      ((Element)v.get(141)).setAttribute("valorinicial","" );
      ((Element)v.get(141)).setAttribute("textoinicial","" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:143 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).setAttribute("width","100%" );
      ((Element)v.get(122)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(144)).setAttribute("src","b.gif" );
      ((Element)v.get(144)).setAttribute("width","8" );
      ((Element)v.get(144)).setAttribute("height","8" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:122   */

      /* Empieza nodo:145 / Elemento padre: 102   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(102)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).setAttribute("colspan","4" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(147)).setAttribute("src","b.gif" );
      ((Element)v.get(147)).setAttribute("width","8" );
      ((Element)v.get(147)).setAttribute("height","8" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:102   */
      /* Termina nodo:101   */
      /* Termina nodo:100   */
      /* Termina nodo:45   */
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:148 / Elemento padre: 38   */
      v.add(doc.createElement("td"));
      ((Element)v.get(38)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(149)).setAttribute("src","b.gif" );
      ((Element)v.get(149)).setAttribute("width","8" );
      ((Element)v.get(149)).setAttribute("height","12" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */
      /* Termina nodo:38   */

      /* Empieza nodo:150 / Elemento padre: 30   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(30)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(152)).setAttribute("src","b.gif" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:153 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("table"));
      ((Element)v.get(155)).setAttribute("width","100%" );
      ((Element)v.get(155)).setAttribute("border","0" );
      ((Element)v.get(155)).setAttribute("align","center" );
      ((Element)v.get(155)).setAttribute("cellspacing","0" );
      ((Element)v.get(155)).setAttribute("cellpadding","0" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(155)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).setAttribute("class","botonera" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("BOTON"));
   }

   private void getXML630(Document doc) {
      ((Element)v.get(158)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(158)).setAttribute("ID","botonContenido" );
      ((Element)v.get(158)).setAttribute("tipo","html" );
      ((Element)v.get(158)).setAttribute("accion","buscar();" );
      ((Element)v.get(158)).setAttribute("estado","false" );
      ((Element)v.get(158)).setAttribute("cod","1" );
      ((Element)v.get(158)).setAttribute("ontab","checkTable2();" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */
      /* Termina nodo:156   */
      /* Termina nodo:155   */
      /* Termina nodo:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:159 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(160)).setAttribute("src","b.gif" );
      ((Element)v.get(160)).setAttribute("width","8" );
      ((Element)v.get(160)).setAttribute("height","12" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */
      /* Termina nodo:150   */

      /* Empieza nodo:161 / Elemento padre: 30   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(30)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).setAttribute("width","12" );
      ((Element)v.get(162)).setAttribute("align","center" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(163)).setAttribute("src","b.gif" );
      ((Element)v.get(163)).setAttribute("width","12" );
      ((Element)v.get(163)).setAttribute("height","24" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */

      /* Empieza nodo:164 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(164)).setAttribute("width","750" );
      ((Element)v.get(161)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(165)).setAttribute("src","b.gif" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */

      /* Empieza nodo:166 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(166)).setAttribute("width","12" );
      ((Element)v.get(161)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(167)).setAttribute("src","b.gif" );
      ((Element)v.get(167)).setAttribute("width","12" );
      ((Element)v.get(167)).setAttribute("height","24" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */
      /* Termina nodo:161   */
      /* Termina nodo:30   */
      /* Termina nodo:29   */

      /* Empieza nodo:168 / Elemento padre: 8   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(168)).setAttribute("nombre","listado1" );
      ((Element)v.get(168)).setAttribute("ancho","679" );
      ((Element)v.get(168)).setAttribute("alto","317" );
      ((Element)v.get(168)).setAttribute("x","12" );
      ((Element)v.get(168)).setAttribute("y","163" );
      ((Element)v.get(168)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(168)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(8)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(169)).setAttribute("precarga","S" );
      ((Element)v.get(169)).setAttribute("conROver","S" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(170)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(170)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(170)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(170)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */

      /* Empieza nodo:171 / Elemento padre: 169   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(171)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(171)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(171)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(171)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(169)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */

      /* Empieza nodo:172 / Elemento padre: 169   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(172)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(172)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(169)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:169   */

      /* Empieza nodo:173 / Elemento padre: 168   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(168)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(174)).setAttribute("borde","1" );
      ((Element)v.get(174)).setAttribute("horizDatos","1" );
      ((Element)v.get(174)).setAttribute("horizCabecera","1" );
      ((Element)v.get(174)).setAttribute("vertical","0" );
      ((Element)v.get(174)).setAttribute("horizTitulo","1" );
      ((Element)v.get(174)).setAttribute("horizBase","1" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */

      /* Empieza nodo:175 / Elemento padre: 173   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(175)).setAttribute("borde","#999999" );
      ((Element)v.get(175)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(175)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(175)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(175)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(175)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(175)).setAttribute("horizBase","#999999" );
      ((Element)v.get(173)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:173   */

      /* Empieza nodo:176 / Elemento padre: 168   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(176)).setAttribute("colFondo","#CECFCE" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(176)).setAttribute("alto","22" );
      ((Element)v.get(176)).setAttribute("imgFondo","" );
      ((Element)v.get(176)).setAttribute("cod","00135" );
      ((Element)v.get(176)).setAttribute("ID","datosTitle" );
      ((Element)v.get(168)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */

      /* Empieza nodo:177 / Elemento padre: 168   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(177)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(177)).setAttribute("alto","22" );
      ((Element)v.get(177)).setAttribute("imgFondo","" );
      ((Element)v.get(168)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */

      /* Empieza nodo:178 / Elemento padre: 168   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(178)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(178)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(178)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(178)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(178)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(178)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(168)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(179)).setAttribute("ancho","175" );
      ((Element)v.get(179)).setAttribute("minimizable","S" );
      ((Element)v.get(179)).setAttribute("minimizada","N" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */

      /* Empieza nodo:180 / Elemento padre: 178   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(180)).setAttribute("ancho","76" );
      ((Element)v.get(180)).setAttribute("minimizable","S" );
      ((Element)v.get(180)).setAttribute("minimizada","N" );
      ((Element)v.get(178)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */

      /* Empieza nodo:181 / Elemento padre: 178   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(181)).setAttribute("ancho","76" );
      ((Element)v.get(181)).setAttribute("minimizable","S" );
      ((Element)v.get(181)).setAttribute("minimizada","N" );
      ((Element)v.get(178)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */

      /* Empieza nodo:182 / Elemento padre: 178   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(182)).setAttribute("ancho","76" );
      ((Element)v.get(182)).setAttribute("minimizable","S" );
      ((Element)v.get(182)).setAttribute("minimizada","N" );
      ((Element)v.get(178)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */

      /* Empieza nodo:183 / Elemento padre: 178   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(183)).setAttribute("ancho","48" );
      ((Element)v.get(183)).setAttribute("minimizable","S" );
      ((Element)v.get(183)).setAttribute("minimizada","N" );
      ((Element)v.get(183)).setAttribute("orden","" );
      ((Element)v.get(178)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */

      /* Empieza nodo:184 / Elemento padre: 178   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(184)).setAttribute("ancho","190" );
      ((Element)v.get(184)).setAttribute("minimizable","S" );
      ((Element)v.get(184)).setAttribute("minimizada","N" );
      ((Element)v.get(178)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:178   */

      /* Empieza nodo:185 / Elemento padre: 168   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(185)).setAttribute("alto","20" );
      ((Element)v.get(185)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(185)).setAttribute("imgFondo","" );
      ((Element)v.get(185)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(168)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(186)).setAttribute("colFondo","" );
      ((Element)v.get(186)).setAttribute("ID","EstCab" );
      ((Element)v.get(186)).setAttribute("align","center" );
      ((Element)v.get(186)).setAttribute("cod","933" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));

      /* Elemento padre:186 / Elemento actual: 187   */
      v.add(doc.createTextNode("Nº descuento"));
      ((Element)v.get(186)).appendChild((Text)v.get(187));

      /* Termina nodo Texto:187   */
      /* Termina nodo:186   */

      /* Empieza nodo:188 / Elemento padre: 185   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(188)).setAttribute("colFondo","" );
      ((Element)v.get(188)).setAttribute("ID","EstCab" );
      ((Element)v.get(188)).setAttribute("align","center" );
      ((Element)v.get(188)).setAttribute("cod","9" );
      ((Element)v.get(185)).appendChild((Element)v.get(188));

      /* Elemento padre:188 / Elemento actual: 189   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(188)).appendChild((Text)v.get(189));

      /* Termina nodo Texto:189   */
      /* Termina nodo:188   */

      /* Empieza nodo:190 / Elemento padre: 185   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(190)).setAttribute("colFondo","" );
      ((Element)v.get(190)).setAttribute("ID","EstCab" );
      ((Element)v.get(190)).setAttribute("align","center" );
      ((Element)v.get(190)).setAttribute("cod","1175" );
      ((Element)v.get(185)).appendChild((Element)v.get(190));

      /* Elemento padre:190 / Elemento actual: 191   */
      v.add(doc.createTextNode("Período desde"));
      ((Element)v.get(190)).appendChild((Text)v.get(191));

      /* Termina nodo Texto:191   */
      /* Termina nodo:190   */

      /* Empieza nodo:192 / Elemento padre: 185   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(192)).setAttribute("colFondo","" );
      ((Element)v.get(192)).setAttribute("ID","EstCab" );
      ((Element)v.get(192)).setAttribute("align","center" );
      ((Element)v.get(192)).setAttribute("cod","1176" );
      ((Element)v.get(185)).appendChild((Element)v.get(192));

      /* Elemento padre:192 / Elemento actual: 193   */
      v.add(doc.createTextNode("Período hasta"));
      ((Element)v.get(192)).appendChild((Text)v.get(193));

      /* Termina nodo Texto:193   */
      /* Termina nodo:192   */

      /* Empieza nodo:194 / Elemento padre: 185   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(194)).setAttribute("colFondo","" );
      ((Element)v.get(194)).setAttribute("ID","EstCab" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(194)).setAttribute("align","center" );
      ((Element)v.get(194)).setAttribute("cod","795" );
      ((Element)v.get(185)).appendChild((Element)v.get(194));

      /* Elemento padre:194 / Elemento actual: 195   */
      v.add(doc.createTextNode("Activo"));
      ((Element)v.get(194)).appendChild((Text)v.get(195));

      /* Termina nodo Texto:195   */
      /* Termina nodo:194   */

      /* Empieza nodo:196 / Elemento padre: 185   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(196)).setAttribute("colFondo","" );
      ((Element)v.get(196)).setAttribute("ID","EstCab" );
      ((Element)v.get(196)).setAttribute("align","center" );
      ((Element)v.get(196)).setAttribute("cod","5" );
      ((Element)v.get(185)).appendChild((Element)v.get(196));

      /* Elemento padre:196 / Elemento actual: 197   */
      v.add(doc.createTextNode("País"));
      ((Element)v.get(196)).appendChild((Text)v.get(197));

      /* Termina nodo Texto:197   */
      /* Termina nodo:196   */
      /* Termina nodo:185   */

      /* Empieza nodo:198 / Elemento padre: 168   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(198)).setAttribute("alto","22" );
      ((Element)v.get(198)).setAttribute("accion","" );
      ((Element)v.get(198)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(198)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(198)).setAttribute("maxSel","-1" );
      ((Element)v.get(198)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(198)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(198)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(198)).setAttribute("onLoad","" );
      ((Element)v.get(198)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(168)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(199)).setAttribute("tipo","texto" );
      ((Element)v.get(199)).setAttribute("ID","EstDat" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */

      /* Empieza nodo:200 / Elemento padre: 198   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(200)).setAttribute("tipo","texto" );
      ((Element)v.get(200)).setAttribute("ID","EstDat2" );
      ((Element)v.get(198)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */

      /* Empieza nodo:201 / Elemento padre: 198   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(201)).setAttribute("tipo","texto" );
      ((Element)v.get(201)).setAttribute("ID","EstDat" );
      ((Element)v.get(198)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */

      /* Empieza nodo:202 / Elemento padre: 198   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(202)).setAttribute("tipo","texto" );
      ((Element)v.get(202)).setAttribute("ID","EstDat2" );
      ((Element)v.get(198)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */

      /* Empieza nodo:203 / Elemento padre: 198   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(203)).setAttribute("tipo","texto" );
      ((Element)v.get(203)).setAttribute("ID","EstDat" );
      ((Element)v.get(198)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */

      /* Empieza nodo:204 / Elemento padre: 198   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(204)).setAttribute("tipo","texto" );
      ((Element)v.get(204)).setAttribute("ID","EstDat2" );
      ((Element)v.get(198)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:198   */

      /* Empieza nodo:205 / Elemento padre: 168   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(168)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */

      /* Empieza nodo:206 / Elemento padre: 168   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(206)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(206)).setAttribute("ancho","679" );
      ((Element)v.get(206)).setAttribute("sep","$" );
      ((Element)v.get(206)).setAttribute("x","12" );
      ((Element)v.get(206)).setAttribute("class","botonera" );
      ((Element)v.get(206)).setAttribute("y","457" );
      ((Element)v.get(206)).setAttribute("control","|" );
      ((Element)v.get(206)).setAttribute("conector","" );
      ((Element)v.get(206)).setAttribute("rowset","" );
      ((Element)v.get(206)).setAttribute("cargainicial","" );
      ((Element)v.get(206)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'prueba(ultima, rowset)')" );
      ((Element)v.get(168)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(207)).setAttribute("nombre","ret1" );
      ((Element)v.get(207)).setAttribute("x","37" );
      ((Element)v.get(207)).setAttribute("y","461" );
      ((Element)v.get(207)).setAttribute("ID","botonContenido" );
      ((Element)v.get(207)).setAttribute("img","retroceder_on" );
      ((Element)v.get(207)).setAttribute("tipo","0" );
      ((Element)v.get(207)).setAttribute("estado","false" );
      ((Element)v.get(207)).setAttribute("alt","" );
      ((Element)v.get(207)).setAttribute("codigo","" );
      ((Element)v.get(207)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */

      /* Empieza nodo:208 / Elemento padre: 206   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(208)).setAttribute("nombre","ava1" );
      ((Element)v.get(208)).setAttribute("x","52" );
      ((Element)v.get(208)).setAttribute("y","461" );
      ((Element)v.get(208)).setAttribute("ID","botonContenido" );
      ((Element)v.get(208)).setAttribute("img","avanzar_on" );
      ((Element)v.get(208)).setAttribute("tipo","0" );
      ((Element)v.get(208)).setAttribute("estado","false" );
      ((Element)v.get(208)).setAttribute("alt","" );
      ((Element)v.get(208)).setAttribute("codigo","" );
      ((Element)v.get(208)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(206)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:206   */
      /* Termina nodo:168   */

      /* Empieza nodo:209 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(209)).setAttribute("nombre","primera1" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(209)).setAttribute("x","20" );
      ((Element)v.get(209)).setAttribute("y","461" );
      ((Element)v.get(209)).setAttribute("ID","botonContenido" );
      ((Element)v.get(209)).setAttribute("img","primera_on" );
      ((Element)v.get(209)).setAttribute("tipo","-2" );
      ((Element)v.get(209)).setAttribute("estado","false" );
      ((Element)v.get(209)).setAttribute("alt","" );
      ((Element)v.get(209)).setAttribute("codigo","" );
      ((Element)v.get(209)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(8)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */

      /* Empieza nodo:210 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(210)).setAttribute("nombre","separa" );
      ((Element)v.get(210)).setAttribute("x","59" );
      ((Element)v.get(210)).setAttribute("y","457" );
      ((Element)v.get(210)).setAttribute("ID","botonContenido" );
      ((Element)v.get(210)).setAttribute("img","separa_base" );
      ((Element)v.get(210)).setAttribute("tipo","0" );
      ((Element)v.get(210)).setAttribute("estado","false" );
      ((Element)v.get(210)).setAttribute("alt","" );
      ((Element)v.get(210)).setAttribute("codigo","" );
      ((Element)v.get(210)).setAttribute("accion","" );
      ((Element)v.get(8)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */

      /* Empieza nodo:211 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(211)).setAttribute("nombre","btnDetalle" );
      ((Element)v.get(211)).setAttribute("x","80" );
      ((Element)v.get(211)).setAttribute("y","458" );
      ((Element)v.get(211)).setAttribute("ID","botonContenido" );
      ((Element)v.get(211)).setAttribute("tipo","html" );
      ((Element)v.get(211)).setAttribute("estado","false" );
      ((Element)v.get(211)).setAttribute("cod","3" );
      ((Element)v.get(211)).setAttribute("accion","seleccionar(1);" );
      ((Element)v.get(211)).setAttribute("ontab","focaliza('formulario.txtNumDescuento')" );
      ((Element)v.get(211)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnBuscar')" );
      ((Element)v.get(8)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */

      /* Empieza nodo:212 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(212)).setAttribute("nombre","btnModificar" );
      ((Element)v.get(212)).setAttribute("x","80" );
      ((Element)v.get(212)).setAttribute("y","458" );
      ((Element)v.get(212)).setAttribute("ID","botonContenido" );
      ((Element)v.get(212)).setAttribute("tipo","html" );
      ((Element)v.get(212)).setAttribute("estado","false" );
      ((Element)v.get(212)).setAttribute("cod","2" );
      ((Element)v.get(212)).setAttribute("accion","seleccionar(2);" );
      ((Element)v.get(212)).setAttribute("ontab","focaliza('formulario.txtNumDescuento')" );
      ((Element)v.get(212)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnBuscar')" );
      ((Element)v.get(8)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */

      /* Empieza nodo:213 / Elemento padre: 8   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(213)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(213)).setAttribute("alto","12" );
      ((Element)v.get(213)).setAttribute("ancho","100%" );
      ((Element)v.get(213)).setAttribute("colorf","" );
      ((Element)v.get(213)).setAttribute("borde","0" );
      ((Element)v.get(213)).setAttribute("imagenf","" );
      ((Element)v.get(213)).setAttribute("repeat","" );
      ((Element)v.get(213)).setAttribute("padding","" );
      ((Element)v.get(213)).setAttribute("visibilidad","visible" );
      ((Element)v.get(213)).setAttribute("contravsb","" );
      ((Element)v.get(213)).setAttribute("x","0" );
      ((Element)v.get(213)).setAttribute("y","480" );
      ((Element)v.get(213)).setAttribute("zindex","" );
      ((Element)v.get(8)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:8   */


   }

}
