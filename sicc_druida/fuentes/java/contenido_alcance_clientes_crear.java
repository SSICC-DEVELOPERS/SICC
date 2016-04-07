
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_alcance_clientes_crear  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_alcance_clientes_crear" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","Ingresar valores de descuento" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag()" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","utilidadesDTO.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Elemento padre:5 / Elemento actual: 6   */
      v.add(doc.createTextNode("\r   \r\r    function onLoadPag()   {\r        configurarMenuSecundario('formulario');\r	fMostrarMensajeError();\r        DrdEnsanchaConMargenDcho('listado1',12);\r\r	guardoConExito();\r	btnProxy(2,'1');\r	\r\r	set('formulario.casoDeUso', get('formulario.hidCasoDeUso'));\r\r        document.all[\"Cplistado1\"].style.visibility='visible';\r        document.all[\"CpLin1listado1\"].style.visibility='visible';\r        document.all[\"CpLin2listado1\"].style.visibility='visible';\r        document.all[\"CpLin3listado1\"].style.visibility='visible';\r        document.all[\"CpLin4listado1\"].style.visibility='visible';\r        document.all[\"primera1Div\"].style.visibility='';\r        document.all[\"ret1Div\"].style.visibility='';\r        document.all[\"ava1Div\"].style.visibility='';\r        document.all[\"separaDiv\"].style.visibility='';\r        document.all[\"btnSiguienteDiv\"].style.visibility='';\r        document.all[\"btnAnadirDiv\"].style.visibility='';\r        eval(ON_RSZ);\r	\r        document.getElementById(\"InsertarP2\").style.backgroundColor = \"#496A9A\";\r        document.getElementById(\"InsertarP2\").style.color = \"#FFFFFF\";\r        if (get('formulario.hidCasoDeUso') == 'consultar' )  {\r			deshabilitarHabilitarBoton('botonContenido','btnAnadir','D');\r            focalizaBotonHTML_XY('btnSiguiente');  \r		}\r        else\r            focalizaBotonHTML('botonContenido','btnAnadir');\r        \r\r/*\r*/       \r        if (get('formulario.hidCasoDeUso') == 'consultar' ||    get('formulario.hidCasoDeUso') == 'modificar'){\r						if (get('formulario.hidCasoDeUso') == 'consultar' )	{\r					deshabilitarHabilitarBoton('botonContenido','anadir','D')\r			}\r		}\r   }\r\r    function navegaPestaniasDetalle(pestanya) {\r        set('formulario.conectorAction', 'LPMantenimientoAlcanceCliente');\r\r	set('formulario.idPestanyaDest', pestanya);\r\r	var registros = listado2string();\r\r	tomoRowsListaEditableDsctos(registros);\r        \r        var pestDest = get(\"formulario.idPestanyaDest\");         var pestActual = 1;\r\r		if  ( parseInt(pestDest, 10) != parseInt(pestActual,10) ){\r            if (pestanya == 0)\r                set(\"formulario.hidPestanya\", \"0\");\r            if (pestanya == 1)\r               set(\"formulario.hidPestanya\", \"1\");\r            if (pestanya == 2)\r              set(\"formulario.hidPestanya\", \"2\");\r            if (pestanya == 3)\r                set(\"formulario.hidPestanya\", \"3\");\r            if (pestanya == 4)  \r                set(\"formulario.hidPestanya\", \"4\");\r\r	    if (get('formulario.hidCasoDeUso')!=\"consultar\") {\r	      set('formulario.accion', 'almacenar');\r	    } else { 	      set('formulario.accion', 'redirigir');\r	    }\r\r            enviaSICC('formulario');  \r	}\r    }\r\r    function accionSiguiente() {\r        	tomoRowsListaEditableDsctos(listado2string());\r\r        set('formulario.conectorAction', 'LPMantenimientoAlcanceCliente');\r        set('formulario.accion', 'siguiente');\r        enviaSICC('formulario');\r    }\r\r    function tomoRowsListaEditableDsctos(lineaTotal) {\r        set(\"formulario.hidContenidoDescuentosClientes\", lineaTotal);\r    }\r\r    function listado2string(){\r      var codigo = listado1.codigos();\r      var toAdd = \"\";\r      var total = \"\";\r   \r      for (var a = 0; a < codigo.length ; a++){\r           toAdd = codigo[a];\r           toAdd = toAdd + \"|\" + listado1.extraeDato(codigo[a], 0);\r           toAdd = toAdd + \"|\" + dejaEsp(listado1.extraeDato(codigo[a], 1));\r           toAdd = toAdd + \"|\" + dejaEsp(listado1.extraeDato(codigo[a], 2));\r           toAdd = toAdd + \"|\" + dejaEsp(listado1.extraeDato(codigo[a], 3));\r           toAdd = toAdd + \"|\" + dejaEsp(listado1.extraeDato(codigo[a], 4));\r\r           total = total + \"$\" + toAdd;\r      }          \r            return total;\r    }\r\r    function accionAniadir() {\r                        var parametrosError = 'sin params';\r                var obj = new Object();\r        obj.hidOidDescuento = get('formulario.hidOidDescuento');\r\r         var whnd = mostrarModalSICC('LPMantenimientoAlcanceCliente','aniadir',obj,null,180);\r\r	 if (whnd != null) {\r		 toAdd = whnd[0];\r		 toAdd = toAdd + \"|\" + whnd[1];\r		 toAdd = toAdd + \"|\" + whnd[2];\r		 toAdd = toAdd + \"|\" + whnd[3];\r		 toAdd = toAdd + \"|\" + whnd[4];\r		 toAdd = toAdd + \"|\" + whnd[5];\r\r		 pasaListaTemporal(toAdd);\r	 }\r        \r    }\r\r    function pasaListaTemporal(datos){\r           var newRow = new Array();\r           newRow = datos.split(\"|\");\r           listado1.insertar(newRow);\r     }\r	\r    function mostrarLista(ultima, rowset){\r		DrdEnsanchaConMargenDcho('listado1',12);\r        document.all[\"Cplistado1\"].style.visibility='visible';\r        document.all[\"CpLin1listado1\"].style.visibility='visible';\r        document.all[\"CpLin2listado1\"].style.visibility='visible';\r        document.all[\"CpLin3listado1\"].style.visibility='visible';\r        document.all[\"CpLin4listado1\"].style.visibility='visible';\r        document.all[\"primera1Div\"].style.visibility='visible';\r        document.all[\"ret1Div\"].style.visibility='visible';\r        document.all[\"ava1Div\"].style.visibility='visible';\r        document.all[\"separaDiv\"].style.visibility='visible';\r        document.all[\"btnSiguienteDiv\"].style.visibility='visible';\r        document.all[\"btnAnadirDiv\"].style.visibility='visible';\r		eval(ON_RSZ);\r		listado1.repinta();\r		return true;\r    }\r\r    function accionBuscar(){\r\r	    configurarPaginado(mipgndo,'DTOConsultarAlcanceClienteDTO','ConectorBuscarAlcanceClienteDTOPag',\r            'es.indra.sicc.dtos.dto.DTOEBuscarAlcanceClienteDTO',armaArray());\r    }\r\r    function armaArray(){ \r        var arrDatos = new Array();\r        var i=0;\r        		arrDatos[i] = new Array('oidIdioma',get('formulario.hidIdioma'));\r		i++;\r        arrDatos[i] = new Array('oidPais',get('formulario.hidPais'));\r		i++;\r\r        if (get('formulario.hidOidDescuento')!=''){\r            arrDatos[i] = new Array('oidDescuento',get('formulario.hidOidDescuento'));\r            i++;\r        }\r		return arrDatos;\r    }\r\r  \r\r    function fBorrar() {\r         if(listado1.numSelecc() > 0){            \r            var codigos = listado1.codigos();\r\r            /*for (var i = 0; i < codigos.length ; i++ ){\r                   listado1.seleccionaCod(codigos[i]) ;\r            } */\r            listado1.eliminarSelecc();	\r	 }else{\r            GestionarMensaje('406');\r        	return ;\r        }\r      \r    }\r\r    function fVolver(){\r	set('formulario.conectorAction', 'LPMantenimientoAlcanceCliente');\r\r	set('formulario.idPestanyaDest', '1');\r\r\r	var registros = listado2string();\r\r	tomoRowsListaEditableDsctos(registros);\r               set(\"formulario.hidPestanya\", \"1\");\r	    if (get('formulario.hidCasoDeUso')!=\"consultar\") {\r	      set('formulario.accion', 'almacenar');\r	    } else { 	      set('formulario.accion', 'redirigir');\r	    }\r\r	    enviaSICC('formulario');\r    }\r	\r    function fGuardar() {\r         tomoRowsListaEditableDsctos(listado2string());\r         set('formulario.conectorAction', 'LPMantenimientoAlcanceCliente');\r         set('formulario.accion', 'guardar');                \r         enviaSICC('formulario');\r    }\r    \r    function onTabSiguiente()\r    {\r        if ( get('formulario.hidCasoDeUso')!='consultar' )\r            focalizaBotonHTML('botonContenido','btnAnadir');\r    }\r\r    function dejaEsp(A){\r        if (A.length == 0){\r            return ' ';\r        }else{\r            return A;\r      }\r    }\r   \r   \r"));
      ((Element)v.get(5)).appendChild((Text)v.get(6));

      /* Termina nodo Texto:6   */
      /* Termina nodo:5   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(7)).setAttribute("nombre","formulario" );
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
      ((Element)v.get(12)).setAttribute("nombre","hidHabilitaAniadir" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","hidCasoDeUso" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","hidOidDescuento" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hidCodCliente" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hidImporteDescuento" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hidImporteFijoDescuento" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hidContenidoDescuentosClientes" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","idPestanyaDest" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hExito" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 7   */
      v.add(doc.createElement("table"));
      ((Element)v.get(22)).setAttribute("bgcolor","red" );
      ((Element)v.get(22)).setAttribute("width","100%" );
      ((Element)v.get(22)).setAttribute("height","100%" );
      ((Element)v.get(22)).setAttribute("border","0" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).setAttribute("align","center" );
      ((Element)v.get(22)).setAttribute("cellpadding","0" );
      ((Element)v.get(22)).setAttribute("cellspacing","0" );
      ((Element)v.get(22)).setAttribute("class","menu5" );
      ((Element)v.get(7)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(22)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(24)).setAttribute("width","12" );
      ((Element)v.get(24)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(24)).setAttribute("class","menu5texto" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(25)).setAttribute("src","b.gif" );
      ((Element)v.get(25)).setAttribute("width","12" );
      ((Element)v.get(25)).setAttribute("height","10" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */
      /* Termina nodo:24   */

      /* Empieza nodo:26 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(26)).setAttribute("class","menu5texto" );
      ((Element)v.get(23)).appendChild((Element)v.get(26));

      /* Elemento padre:26 / Elemento actual: 27   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(26)).appendChild((Text)v.get(27));

      /* Termina nodo Texto:27   */
      /* Termina nodo:26   */

      /* Empieza nodo:28 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(28)).setAttribute("width","10" );
      ((Element)v.get(28)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(28)).setAttribute("class","menu5texto" );
      ((Element)v.get(23)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(29)).setAttribute("src","b.gif" );
      ((Element)v.get(29)).setAttribute("width","10" );
      ((Element)v.get(29)).setAttribute("height","0" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */
      /* Termina nodo:28   */

      /* Empieza nodo:30 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(30)).setAttribute("width","10" );
      ((Element)v.get(30)).setAttribute("class","menu5texto" );
      ((Element)v.get(23)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(31)).setAttribute("src","b.gif" );
      ((Element)v.get(31)).setAttribute("width","10" );
      ((Element)v.get(31)).setAttribute("height","8" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */
      /* Termina nodo:30   */

      /* Empieza nodo:32 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(32)).setAttribute("width","20" );
      ((Element)v.get(32)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(32)).setAttribute("class","menu5texto" );
      ((Element)v.get(23)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("table"));
      ((Element)v.get(33)).setAttribute("width","75" );
      ((Element)v.get(33)).setAttribute("border","0" );
      ((Element)v.get(33)).setAttribute("align","center" );
      ((Element)v.get(33)).setAttribute("cellpadding","1" );
      ((Element)v.get(33)).setAttribute("cellspacing","0" );
      ((Element)v.get(33)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(34)).setAttribute("align","center" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(35)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("a"));
      ((Element)v.get(36)).setAttribute("href","#" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(37)).setAttribute("ID","InsertarP1" );
      ((Element)v.get(37)).setAttribute("onmouseover","poneManito('InsertarP1');" );
      ((Element)v.get(37)).setAttribute("onclick","navegaPestaniasDetalle('0')" );
      ((Element)v.get(37)).setAttribute("style","width:80px;border-style:solid; border-color:#496A9A;border-width:2px;position:relative;top:3px;text-align:center;color:#496A9A;font-family: Arial, Helvetica, sans-serif;font-size: 11px;font-weight: bold; visibility:visible" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Elemento padre:37 / Elemento actual: 38   */
      v.add(doc.createTextNode("Datos generales"));
      ((Element)v.get(37)).appendChild((Text)v.get(38));

      /* Termina nodo Texto:38   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */
      /* Termina nodo:35   */
      /* Termina nodo:34   */
      /* Termina nodo:33   */
      /* Termina nodo:32   */

      /* Empieza nodo:39 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).setAttribute("width","10" );
      ((Element)v.get(39)).setAttribute("class","menu5texto" );
      ((Element)v.get(23)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(40)).setAttribute("src","b.gif" );
      ((Element)v.get(40)).setAttribute("width","10" );
      ((Element)v.get(40)).setAttribute("height","8" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */
      /* Termina nodo:39   */

      /* Empieza nodo:41 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).setAttribute("width","20" );
      ((Element)v.get(41)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(41)).setAttribute("class","menu5texto" );
      ((Element)v.get(23)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("table"));
      ((Element)v.get(42)).setAttribute("width","75" );
      ((Element)v.get(42)).setAttribute("border","0" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(42)).setAttribute("align","center" );
      ((Element)v.get(42)).setAttribute("cellpadding","1" );
      ((Element)v.get(42)).setAttribute("cellspacing","0" );
      ((Element)v.get(42)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(43)).setAttribute("align","center" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(44)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(45)).setAttribute("ID","InsertarP2" );
      ((Element)v.get(45)).setAttribute("onclick","navegaPestaniasDetalle('1')" );
      ((Element)v.get(45)).setAttribute("style","width:80px;border-style:solid; border-color:#496A9A;border-width:2px;position:relative;top:3px;text-align:center;color:#496A9A;font-family: Arial, Helvetica, sans-serif;font-size: 11px;font-weight: bold; visibility:visible" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Elemento padre:45 / Elemento actual: 46   */
      v.add(doc.createTextNode("Tipo de cliente"));
      ((Element)v.get(45)).appendChild((Text)v.get(46));

      /* Termina nodo Texto:46   */
      /* Termina nodo:45   */
      /* Termina nodo:44   */
      /* Termina nodo:43   */
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:47 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).setAttribute("width","10" );
      ((Element)v.get(47)).setAttribute("class","menu5texto" );
      ((Element)v.get(23)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(48)).setAttribute("src","b.gif" );
      ((Element)v.get(48)).setAttribute("width","10" );
      ((Element)v.get(48)).setAttribute("height","8" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:49 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).setAttribute("width","20" );
      ((Element)v.get(49)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(49)).setAttribute("class","menu5texto" );
      ((Element)v.get(23)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("table"));
      ((Element)v.get(50)).setAttribute("width","75" );
      ((Element)v.get(50)).setAttribute("border","0" );
      ((Element)v.get(50)).setAttribute("align","center" );
      ((Element)v.get(50)).setAttribute("cellpadding","1" );
      ((Element)v.get(50)).setAttribute("cellspacing","0" );
      ((Element)v.get(50)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(51)).setAttribute("align","center" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(52)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(53)).setAttribute("ID","InsertarP3" );
      ((Element)v.get(53)).setAttribute("onmouseover","poneManito('InsertarP3');" );
      ((Element)v.get(53)).setAttribute("onclick","navegaPestaniasDetalle('2')" );
      ((Element)v.get(53)).setAttribute("style","width:80px;border-style:solid; border-color:#496A9A;border-width:2px;position:relative;top:3px;text-align:center;color:#496A9A;font-family: Arial, Helvetica, sans-serif;font-size: 11px;font-weight: bold; visibility:visible" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Elemento padre:53 / Elemento actual: 54   */
      v.add(doc.createTextNode("Alcance administrativo"));
      ((Element)v.get(53)).appendChild((Text)v.get(54));

      /* Termina nodo Texto:54   */
      /* Termina nodo:53   */
      /* Termina nodo:52   */
      /* Termina nodo:51   */
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:55 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).setAttribute("width","10" );
      ((Element)v.get(55)).setAttribute("class","menu5texto" );
      ((Element)v.get(23)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(56)).setAttribute("src","b.gif" );
      ((Element)v.get(56)).setAttribute("width","10" );
      ((Element)v.get(56)).setAttribute("height","8" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:57 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).setAttribute("width","20" );
      ((Element)v.get(57)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(57)).setAttribute("class","menu5texto" );
      ((Element)v.get(23)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("table"));
      ((Element)v.get(58)).setAttribute("width","75" );
      ((Element)v.get(58)).setAttribute("border","0" );
      ((Element)v.get(58)).setAttribute("align","center" );
      ((Element)v.get(58)).setAttribute("cellpadding","1" );
      ((Element)v.get(58)).setAttribute("cellspacing","0" );
      ((Element)v.get(58)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(59)).setAttribute("align","center" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(60)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(61)).setAttribute("ID","InsertarP4" );
      ((Element)v.get(61)).setAttribute("onmouseover","poneManito('InsertarP4');" );
      ((Element)v.get(61)).setAttribute("onclick","navegaPestaniasDetalle('3')" );
      ((Element)v.get(61)).setAttribute("style","width:80px;border-style:solid; border-color:#496A9A;border-width:2px;position:relative;top:3px;text-align:center;color:#496A9A;font-family: Arial, Helvetica, sans-serif;font-size: 11px;font-weight: bold; visibility:visible" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(60)).appendChild((Element)v.get(61));

      /* Elemento padre:61 / Elemento actual: 62   */
      v.add(doc.createTextNode("Base de cálculo"));
      ((Element)v.get(61)).appendChild((Text)v.get(62));

      /* Termina nodo Texto:62   */
      /* Termina nodo:61   */
      /* Termina nodo:60   */
      /* Termina nodo:59   */
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:63 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).setAttribute("width","10" );
      ((Element)v.get(63)).setAttribute("class","menu5texto" );
      ((Element)v.get(23)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(64)).setAttribute("src","b.gif" );
      ((Element)v.get(64)).setAttribute("width","10" );
      ((Element)v.get(64)).setAttribute("height","8" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).setAttribute("width","20" );
      ((Element)v.get(65)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(65)).setAttribute("class","menu5texto" );
      ((Element)v.get(23)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("table"));
      ((Element)v.get(66)).setAttribute("width","75" );
      ((Element)v.get(66)).setAttribute("border","0" );
      ((Element)v.get(66)).setAttribute("align","center" );
      ((Element)v.get(66)).setAttribute("cellpadding","1" );
      ((Element)v.get(66)).setAttribute("cellspacing","0" );
      ((Element)v.get(66)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(67)).setAttribute("align","center" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(68)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(69)).setAttribute("ID","InsertarP5" );
      ((Element)v.get(69)).setAttribute("onmouseover","poneManito('InsertarP5');" );
      ((Element)v.get(69)).setAttribute("onclick","navegaPestaniasDetalle('4')" );
      ((Element)v.get(69)).setAttribute("style","width:80px;border-style:solid; border-color:#496A9A;border-width:2px;position:relative;top:3px;text-align:center;color:#496A9A;font-family: Arial, Helvetica, sans-serif;font-size: 11px;font-weight: bold; visibility:visible" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Elemento padre:69 / Elemento actual: 70   */
      v.add(doc.createTextNode("Aplicación de descuento"));
      ((Element)v.get(69)).appendChild((Text)v.get(70));

      /* Termina nodo Texto:70   */
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:71 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).setAttribute("width","16" );
      ((Element)v.get(71)).setAttribute("class","menu5texto" );
      ((Element)v.get(23)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(72)).setAttribute("width","12" );
      ((Element)v.get(72)).setAttribute("height","8" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:23   */
      /* Termina nodo:22   */

      /* Empieza nodo:73 / Elemento padre: 7   */
      v.add(doc.createElement("table"));
      ((Element)v.get(73)).setAttribute("width","100%" );
      ((Element)v.get(73)).setAttribute("border","0" );
      ((Element)v.get(73)).setAttribute("cellspacing","0" );
      ((Element)v.get(73)).setAttribute("cellpadding","0" );
      ((Element)v.get(7)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).setAttribute("width","100%" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","424" );
      ((Element)v.get(76)).setAttribute("height","8" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:77 / Elemento padre: 7   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(77)).setAttribute("nombre","listado1" );
      ((Element)v.get(77)).setAttribute("ancho","400" );
      ((Element)v.get(77)).setAttribute("alto","317" );
      ((Element)v.get(77)).setAttribute("x","12" );
      ((Element)v.get(77)).setAttribute("y","30" );
      ((Element)v.get(77)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(77)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(7)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(78)).setAttribute("precarga","S" );
      ((Element)v.get(78)).setAttribute("conROver","S" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(79)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(79)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(79)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(79)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */

      /* Empieza nodo:80 / Elemento padre: 78   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(80)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(80)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(80)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(80)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(78)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */

      /* Empieza nodo:81 / Elemento padre: 78   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(81)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(81)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(78)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:78   */

      /* Empieza nodo:82 / Elemento padre: 77   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(77)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(83)).setAttribute("borde","1" );
      ((Element)v.get(83)).setAttribute("horizDatos","1" );
      ((Element)v.get(83)).setAttribute("horizCabecera","1" );
      ((Element)v.get(83)).setAttribute("vertical","1" );
      ((Element)v.get(83)).setAttribute("horizTitulo","1" );
      ((Element)v.get(83)).setAttribute("horizBase","1" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */

      /* Empieza nodo:84 / Elemento padre: 82   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(84)).setAttribute("borde","#999999" );
      ((Element)v.get(84)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(84)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(84)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(84)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(84)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(84)).setAttribute("horizBase","#999999" );
      ((Element)v.get(82)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:82   */

      /* Empieza nodo:85 / Elemento padre: 77   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(85)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(85)).setAttribute("alto","22" );
      ((Element)v.get(85)).setAttribute("imgFondo","" );
      ((Element)v.get(85)).setAttribute("cod","00101" );
      ((Element)v.get(85)).setAttribute("ID","datosTitle" );
      ((Element)v.get(77)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 77   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(86)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(86)).setAttribute("alto","22" );
      ((Element)v.get(86)).setAttribute("imgFondo","" );
      ((Element)v.get(77)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 77   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(87)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(87)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(87)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(87)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(87)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(87)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(77)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(88)).setAttribute("ancho","90" );
      ((Element)v.get(88)).setAttribute("minimizable","S" );
      ((Element)v.get(88)).setAttribute("minimizada","N" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */

      /* Empieza nodo:89 / Elemento padre: 87   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(89)).setAttribute("ancho","150" );
      ((Element)v.get(89)).setAttribute("minimizable","S" );
      ((Element)v.get(89)).setAttribute("minimizada","N" );
      ((Element)v.get(87)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */

      /* Empieza nodo:90 / Elemento padre: 87   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(90)).setAttribute("ancho","150" );
      ((Element)v.get(90)).setAttribute("minimizable","S" );
      ((Element)v.get(90)).setAttribute("minimizada","N" );
      ((Element)v.get(87)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */

      /* Empieza nodo:91 / Elemento padre: 87   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(91)).setAttribute("ancho","100" );
      ((Element)v.get(91)).setAttribute("minimizable","S" );
      ((Element)v.get(91)).setAttribute("minimizada","N" );
      ((Element)v.get(87)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 87   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(92)).setAttribute("ancho","110" );
      ((Element)v.get(92)).setAttribute("minimizable","S" );
      ((Element)v.get(92)).setAttribute("minimizada","N" );
      ((Element)v.get(87)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:87   */

      /* Empieza nodo:93 / Elemento padre: 77   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(93)).setAttribute("alto","20" );
      ((Element)v.get(93)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(93)).setAttribute("imgFondo","" );
      ((Element)v.get(93)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(93)).setAttribute("ajustarAMitadInf","S" );
      ((Element)v.get(77)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(94)).setAttribute("colFondo","" );
      ((Element)v.get(94)).setAttribute("ID","EstCab" );
      ((Element)v.get(94)).setAttribute("cod","263" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Elemento padre:94 / Elemento actual: 95   */
      v.add(doc.createTextNode("Cód. cliente"));
      ((Element)v.get(94)).appendChild((Text)v.get(95));

      /* Termina nodo Texto:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:96 / Elemento padre: 93   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(96)).setAttribute("colFondo","" );
      ((Element)v.get(96)).setAttribute("ID","EstCab" );
      ((Element)v.get(96)).setAttribute("cod","1039" );
      ((Element)v.get(93)).appendChild((Element)v.get(96));

      /* Elemento padre:96 / Elemento actual: 97   */
      v.add(doc.createTextNode("Nombre"));
      ((Element)v.get(96)).appendChild((Text)v.get(97));

      /* Termina nodo Texto:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:98 / Elemento padre: 93   */
      v.add(doc.createElement("COL"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(98)).setAttribute("colFondo","" );
      ((Element)v.get(98)).setAttribute("ID","EstCab" );
      ((Element)v.get(98)).setAttribute("cod","1141" );
      ((Element)v.get(93)).appendChild((Element)v.get(98));

      /* Elemento padre:98 / Elemento actual: 99   */
      v.add(doc.createTextNode("Apellidos"));
      ((Element)v.get(98)).appendChild((Text)v.get(99));

      /* Termina nodo Texto:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:100 / Elemento padre: 93   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(100)).setAttribute("colFondo","" );
      ((Element)v.get(100)).setAttribute("ID","EstCab" );
      ((Element)v.get(100)).setAttribute("cod","971" );
      ((Element)v.get(93)).appendChild((Element)v.get(100));

      /* Elemento padre:100 / Elemento actual: 101   */
      v.add(doc.createTextNode("Porcentaje dto."));
      ((Element)v.get(100)).appendChild((Text)v.get(101));

      /* Termina nodo Texto:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:102 / Elemento padre: 93   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(102)).setAttribute("colFondo","" );
      ((Element)v.get(102)).setAttribute("ID","EstCab" );
      ((Element)v.get(102)).setAttribute("cod","898" );
      ((Element)v.get(93)).appendChild((Element)v.get(102));

      /* Elemento padre:102 / Elemento actual: 103   */
      v.add(doc.createTextNode("Importe fijo dto."));
      ((Element)v.get(102)).appendChild((Text)v.get(103));

      /* Termina nodo Texto:103   */
      /* Termina nodo:102   */
      /* Termina nodo:93   */

      /* Empieza nodo:104 / Elemento padre: 77   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(104)).setAttribute("alto","22" );
      ((Element)v.get(104)).setAttribute("accion","" );
      ((Element)v.get(104)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(104)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(104)).setAttribute("maxSel","-1" );
      ((Element)v.get(104)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(104)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(104)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(104)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(77)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(105)).setAttribute("tipo","texto" );
      ((Element)v.get(105)).setAttribute("ID","EstDat" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */

      /* Empieza nodo:106 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(106)).setAttribute("tipo","texto" );
      ((Element)v.get(106)).setAttribute("ID","EstDat2" );
      ((Element)v.get(104)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */

      /* Empieza nodo:107 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(107)).setAttribute("tipo","texto" );
      ((Element)v.get(107)).setAttribute("ID","EstDat" );
      ((Element)v.get(104)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */

      /* Empieza nodo:108 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(108)).setAttribute("tipo","texto" );
      ((Element)v.get(108)).setAttribute("ID","EstDat2" );
      ((Element)v.get(104)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */

      /* Empieza nodo:109 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(109)).setAttribute("tipo","texto" );
      ((Element)v.get(109)).setAttribute("ID","EstDat" );
      ((Element)v.get(104)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:104   */

      /* Empieza nodo:110 / Elemento padre: 77   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(77)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */

      /* Empieza nodo:111 / Elemento padre: 77   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(111)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(111)).setAttribute("ancho","400" );
      ((Element)v.get(111)).setAttribute("sep","$" );
      ((Element)v.get(111)).setAttribute("x","12" );
      ((Element)v.get(111)).setAttribute("class","botonera" );
      ((Element)v.get(111)).setAttribute("y","306" );
      ((Element)v.get(111)).setAttribute("control","|" );
      ((Element)v.get(111)).setAttribute("conector","" );
      ((Element)v.get(111)).setAttribute("rowset","" );
      ((Element)v.get(111)).setAttribute("cargainicial","N" );
      ((Element)v.get(111)).setAttribute("onload","" );
      ((Element)v.get(77)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(112)).setAttribute("nombre","ret1" );
      ((Element)v.get(112)).setAttribute("x","37" );
      ((Element)v.get(112)).setAttribute("y","328" );
      ((Element)v.get(112)).setAttribute("ID","botonContenido" );
      ((Element)v.get(112)).setAttribute("img","retroceder_on" );
      ((Element)v.get(112)).setAttribute("tipo","0" );
      ((Element)v.get(112)).setAttribute("estado","false" );
      ((Element)v.get(112)).setAttribute("alt","" );
      ((Element)v.get(112)).setAttribute("codigo","" );
      ((Element)v.get(112)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */

      /* Empieza nodo:113 / Elemento padre: 111   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(113)).setAttribute("nombre","ava1" );
      ((Element)v.get(113)).setAttribute("x","52" );
      ((Element)v.get(113)).setAttribute("y","328" );
      ((Element)v.get(113)).setAttribute("ID","botonContenido" );
      ((Element)v.get(113)).setAttribute("img","avanzar_on" );
      ((Element)v.get(113)).setAttribute("tipo","0" );
      ((Element)v.get(113)).setAttribute("estado","false" );
      ((Element)v.get(113)).setAttribute("alt","" );
      ((Element)v.get(113)).setAttribute("codigo","" );
      ((Element)v.get(113)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(111)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:111   */
      /* Termina nodo:77   */

      /* Empieza nodo:114 / Elemento padre: 7   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(114)).setAttribute("nombre","primera1" );
      ((Element)v.get(114)).setAttribute("x","20" );
      ((Element)v.get(114)).setAttribute("y","328" );
      ((Element)v.get(114)).setAttribute("ID","botonContenido" );
      ((Element)v.get(114)).setAttribute("img","primera_on" );
      ((Element)v.get(114)).setAttribute("tipo","-2" );
      ((Element)v.get(114)).setAttribute("estado","false" );
      ((Element)v.get(114)).setAttribute("alt","" );
      ((Element)v.get(114)).setAttribute("codigo","" );
      ((Element)v.get(114)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(7)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */

      /* Empieza nodo:115 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(115)).setAttribute("nombre","separa" );
      ((Element)v.get(115)).setAttribute("x","59" );
      ((Element)v.get(115)).setAttribute("y","324" );
      ((Element)v.get(115)).setAttribute("ID","botonContenido" );
      ((Element)v.get(115)).setAttribute("img","separa_base" );
      ((Element)v.get(115)).setAttribute("tipo","0" );
      ((Element)v.get(115)).setAttribute("estado","false" );
      ((Element)v.get(115)).setAttribute("alt","" );
      ((Element)v.get(115)).setAttribute("codigo","" );
      ((Element)v.get(115)).setAttribute("accion","" );
      ((Element)v.get(7)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */

      /* Empieza nodo:116 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(116)).setAttribute("nombre","btnSiguiente" );
      ((Element)v.get(116)).setAttribute("x","80" );
      ((Element)v.get(116)).setAttribute("y","325" );
      ((Element)v.get(116)).setAttribute("ID","botonContenido" );
      ((Element)v.get(116)).setAttribute("tipo","html" );
      ((Element)v.get(116)).setAttribute("estado","false" );
      ((Element)v.get(116)).setAttribute("cod","446" );
      ((Element)v.get(116)).setAttribute("accion","accionSiguiente();" );
      ((Element)v.get(116)).setAttribute("ontab","onTabSiguiente();" );
      ((Element)v.get(116)).setAttribute("onshtab","focalizaBotonHTML_XY('btnSiguiente');" );
      ((Element)v.get(7)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */

      /* Empieza nodo:117 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(117)).setAttribute("nombre","btnAnadir" );
      ((Element)v.get(117)).setAttribute("x","146" );
      ((Element)v.get(117)).setAttribute("y","325" );
      ((Element)v.get(117)).setAttribute("ID","botonContenido" );
      ((Element)v.get(117)).setAttribute("tipo","html" );
      ((Element)v.get(117)).setAttribute("estado","false" );
      ((Element)v.get(117)).setAttribute("cod","404" );
      ((Element)v.get(117)).setAttribute("accion","accionAniadir();" );
      ((Element)v.get(117)).setAttribute("ontab","focalizaBotonHTML('botonContenido','btnSiguiente')" );
      ((Element)v.get(7)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */

      /* Empieza nodo:118 / Elemento padre: 7   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(118)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(118)).setAttribute("alto","12" );
      ((Element)v.get(118)).setAttribute("ancho","100%" );
      ((Element)v.get(118)).setAttribute("colorf","" );
      ((Element)v.get(118)).setAttribute("borde","0" );
      ((Element)v.get(118)).setAttribute("imagenf","" );
      ((Element)v.get(118)).setAttribute("repeat","" );
      ((Element)v.get(118)).setAttribute("padding","" );
      ((Element)v.get(118)).setAttribute("visibilidad","visible" );
      ((Element)v.get(118)).setAttribute("contravsb","" );
      ((Element)v.get(118)).setAttribute("x","0" );
      ((Element)v.get(118)).setAttribute("y","329" );
      ((Element)v.get(118)).setAttribute("zindex","" );
      ((Element)v.get(7)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:7   */


   }

}
