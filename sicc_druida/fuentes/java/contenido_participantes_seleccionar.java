
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_participantes_seleccionar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_participantes_seleccionar" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","Crear Concurso" );
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
      v.add(doc.createTextNode("\r  \r\r	function fLimpiar() {\r		onLoadPag();\r	}\r\r	function onLoadPag()   {  \r		configurarMenuSecundario('formulario');\r		DrdEnsanchaConMargenDcho('listado1',26);\r		document.all[\"Cplistado1\"].style.visibility='';\r		document.all[\"CpLin1listado1\"].style.visibility='';\r		document.all[\"CpLin2listado1\"].style.visibility='';\r		document.all[\"CpLin3listado1\"].style.visibility='';\r		document.all[\"CpLin4listado1\"].style.visibility='';\r		document.all[\"separaDiv\"].style.visibility='hidden';\r		document.all[\"primera1Div\"].style.visibility='hidden';\r		document.all[\"ret1Div\"].style.visibility='hidden';\r		document.all[\"ava1Div\"].style.visibility='hidden';\r		document.all[\"btnExcluirDiv\"].style.visibility='';\r		document.all[\"btnExcluirTodosDiv\"].style.visibility='';\r		eval (ON_RSZ);\r\r		if (get('formulario.opcionMenu') == 'Consultar Concurso')  {\r						mostrarLista('N');\r			document.getElementById(\"btnAceptar\").disabled = true;	  \r			btnProxy(5, 0);\r			btnProxy(7, 0);\r			btnProxy(8, 0);\r			btnProxy(9, 0);\r		}\r		else{\r						mostrarLista('S');\r			focalizaBotonHTML('botonContenido','btnExcluir');\r		}\r			\r		if (get('formulario.lstClasificacionParticipantesConsultoras') != null)\r			cargaLista(listado1,get('formulario.lstClasificacionParticipantesConsultoras'));\r		if (get('formulario.lstClasificacionParticipantes') != null)\r			cargaLista(listado2, get('formulario.lstClasificacionParticipantes'));\r				\r		if (listado1.datos.length > 0)\r			set('formulario.hidUltimoElementoEnLaLista', listado2.datos.length);\r\r		if (get('formulario.hConcuConsultora') == 'S') {\r						var tit = objValidacionSICC[objValidacionSICC.length-1].mostrar;\r			listado1.datosTitulo[0] = tit;\r			listado1.repintaTit(); \r		}\r    }\r   \r   function mostrarLista(estado)\r   {   \r        if (estado == 'N'){\r            DrdEnsanchaConMargenDcho('listado2',26);\r            document.all[\"Cplistado2\"].style.visibility='hidden';\r            document.all[\"CpLin1listado2\"].style.visibility='hidden';\r            document.all[\"CpLin2listado2\"].style.visibility='hidden';\r            document.all[\"CpLin3listado2\"].style.visibility='hidden';\r            document.all[\"CpLin4listado2\"].style.visibility='hidden';\r            document.all[\"separa2Div\"].style.visibility='hidden';\r            document.all[\"primera2Div\"].style.visibility='hidden';\r            document.all[\"ret2Div\"].style.visibility='hidden';\r            document.all[\"ava2Div\"].style.visibility='hidden';\r            document.all[\"btnAnadirDiv\"].style.visibility='hidden';\r            document.all[\"btnAnadirTodosDiv\"].style.visibility='hidden';\r            deshabilitarHabilitarBoton('botonContenido','btnExcluir','D');\r            deshabilitarHabilitarBoton('botonContenido','btnExcluirTodos','D');\r        }else{\r            DrdEnsanchaConMargenDcho('listado2',26);\r            document.all[\"Cplistado2\"].style.visibility='visible';\r            document.all[\"CpLin1listado2\"].style.visibility='visible';\r            document.all[\"CpLin2listado2\"].style.visibility='visible';\r            document.all[\"CpLin3listado2\"].style.visibility='visible';\r            document.all[\"CpLin4listado2\"].style.visibility='visible';\r            document.all[\"separa2Div\"].style.visibility='visible';\r            document.all[\"primera2Div\"].style.visibility='hidden';\r            document.all[\"ret2Div\"].style.visibility='visible';\r            document.all[\"ava2Div\"].style.visibility='visible';\r            document.all[\"btnAnadirDiv\"].style.visibility='visible';\r            document.all[\"btnAnadirTodosDiv\"].style.visibility='visible';\r            deshabilitarHabilitarBoton('botonContenido','btnExcluir','A');\r            deshabilitarHabilitarBoton('botonContenido','btnExcluirTodos','A');\r        }\r        eval (ON_RSZ);\r   }\r   \r   function cargaLista(lista, items)\r   {\r        if (items != null)\r        {\r            actualizaListado(lista, items);\r        }\r   }\r   \r   function accionExcluir()\r   {\r                                                excluyeEltosSel(listado1, listado2);\r   }\r   \r   function accionExcluirTodos()\r   {\r\r                            excluyeTodosLosEltos(listado1, listado2);\r   }\r   \r   function accionAniadir()\r   {\r\r                                                             aniadeEltosSel(listado2, listado1);\r   }\r   \r   function accionAniadirTodos()\r   {\r\r                aniadeTodosLosEltos(listado2, listado1);\r   }\r   \r   function accionAceptar() {\r   	   	   var datosGerentes = listado1.datos;\r\r	   if(datosGerentes.length>0) {\r			var clasifParticConsul = listado1Tostring();\r			var clasifPartic = listado2Tostring();\r        \r			var arr = new Array();\r			arr[0] = clasifParticConsul;\r			arr[1] = clasifPartic;\r			returnValue = arr;\r			close();\r	   }\r	   else {\r	      GestionarMensaje('INC034');\r          return false;\r	   }	  \r   }\r   \r   \r\r	function actualizaListado(lista, listaItems){\r		var fila = listaItems.split('$');\r		for(i=0;i<fila.length;i++){\r			if (fila[i] != ''){\r				var newRow = new Array();\r				newRow = fila[i].split(\"|\");\r				lista.insertar(newRow);\r			}\r		}\r	}\r    \r    function listado1Tostring(){\r        \r        listado1.actualizaDat();\r        var codigo = listado1.codigos();\r        var total = \"\";\r        for(var a = 0; a < codigo.length ; a++){\r            var toAdd = \"\";\r            toAdd = \"oid:\"+ codigo[a];\r            if(listado1.extraeDato(codigo[a], 0)!= null && listado1.extraeDato(codigo[a], 0)!=\"\")\r				toAdd = toAdd + \"|\" + \"oPc:\" + listado1.extraeDato(codigo[a], 0);                if(listado1.extraeDato(codigo[a], 1)!= null && listado1.extraeDato(codigo[a], 1)!=\"\")\r				toAdd = toAdd + \"|\" + \"oPar:\" + listado1.extraeDato(codigo[a], 1);                if(listado1.extraeDato(codigo[a], 2)!= null && listado1.extraeDato(codigo[a], 2)!=\"\")\r				toAdd = toAdd + \"|\" + \"desc:\" + listado1.extraeDato(codigo[a], 2);                \r            total = total + \"$\" + toAdd;\r		}	\r		return total;\r	}  \r  \r    \r     function listado2Tostring(){\r        listado2.actualizaDat();\r        var codigo = listado2.codigos();\r        var total = \"\";\r        for(var a = 0; a < codigo.length ; a++){\r            var toAdd = \"\";\r            toAdd = \"oPar:\"+ codigo[a];\r\r            if(listado2.extraeDato(codigo[a], 0)!= null && listado2.extraeDato(codigo[a], 0)!=\"\")\r                toAdd = toAdd + \"|\" + \"desc:\" + listado2.extraeDato(codigo[a], 0);                total = total + \"$\" + toAdd;\r		}	\r		return total;\r	}\r    \r\r    function aniadeEltosSel (listaOr, listaDe)\r    {\r        listaOr.actualizaDat();\r        listaDe.actualizaDat();\r        var cantElementosL1 = listaOr.codSeleccionados();		\r\r        if ( cantElementosL1.length == 0){\r            GestionarMensaje(\"4\", null, null, null);\r            return;\r        }\r        \r        var codigo = listaOr.codSeleccionados();\r		var total = \"\";\r        lon = codigo.length;\r        \r		for(var a = 0; a < lon ; a++){\r            if (isInListado1(codigo[a], listaDe) == 0) \r            {            \r                var posi = parseInt(get('formulario.hidUltimoElementoEnLaLista'), 10);\r                var iPos = listaDe.generaCodigo( posi );\r                \r                toAdd = iPos + \"|\" + null;\r                toAdd = toAdd + \"|\" + codigo[a]  + \"|\" + listaOr.extraeDato(codigo[a], 0);\r                \r                var newRow = new Array();\r                newRow = toAdd.split(\"|\");\r                listaDe.insertar(newRow);\r                \r                set('formulario.hidUltimoElementoEnLaLista', iPos);\r            }\r        }\r        listaOr.eliminarSelecc();\r   }\r   \r    function aniadeTodosLosEltos (listaOr, listaDe)\r    {\r        listaOr.actualizaDat();\r        listaDe.actualizaDat();\r        var codigo = listaOr.codigos();\r        lon =  codigo.length;\r        \r		for(var a = 0; a < lon ; a++){\r            if (isInListado1(codigo[a], listaDe) == 0) \r            {            \r                var posi = parseInt(get('formulario.hidUltimoElementoEnLaLista'), 10);\r                var iPos = listaDe.generaCodigo( posi );\r            \rtoAdd = iPos + \"|\" + null  + \"|\" + codigo[a]  + \"|\" + listaOr.extraeDato(codigo[a], 0);\r                var newRow = new Array();\r                newRow = toAdd.split(\"|\");\r                listaDe.insertar(newRow);\r                set('formulario.hidUltimoElementoEnLaLista', iPos);\r            }\r        }\r        var nuevos_datos = new Array();\r        listaOr.setDatos(nuevos_datos);\r   }\r   \r   function isInListado1(item, listaDestino)\r   {\r        listaDestino.actualizaDat();\r        var codListD = listaDestino.codigos();\r        var lonLisD = listaDestino.datos.length;\r        \r        var estaEnLista = 0;\r        \r        for(var b = 0; b < lonLisD ; b++)\r        {\r            var vDestino = listaDestino.extraeDato(codListD[b], 1);\r            if (item == vDestino)\r            {\r                estaEnLista = 1;    \r            }\r        }\r        return estaEnLista;\r   }\r   \r    function fVolver(){\r        window.close();\r    }\r    \r    function excluyeEltosSel (listaOr, listaDe)\r    {\r        listaOr.actualizaDat();\r        listaDe.actualizaDat();\r        var cantElementosL1 = listaOr.codSeleccionados();		\r        \r        if ( cantElementosL1.length == 0){\r            GestionarMensaje(\"4\", null, null, null);\r            return;\r        }\r        \r        var codigo = listaOr.codSeleccionados();\r		var total = \"\";\r        lon =  codigo.length;\r		for(var a = 0; a < lon ; a++){\r            var item = listaOr.extraeDato(codigo[a], 1); \r            if ( isInListado2(item, listaDe) == 0)\r            {                toAdd = listaOr.extraeDato(codigo[a], 1);\r				toAdd = toAdd + \"|\" + listaOr.extraeDato(codigo[a], 2);\r                var newRow = new Array();\r                newRow = toAdd.split(\"|\");\r                listaDe.insertar(newRow);\r            }\r        } \r        listaOr.eliminarSelecc();\r   }\r   \r   function excluyeTodosLosEltos (listaOr, listaDe)\r    {\r        listaOr.actualizaDat();\r        listaDe.actualizaDat();\r        var codigo = listaOr.codigos();\r        lon =  codigo.length;\r		for(var a = 0; a < lon ; a++){\r                        var item = listaOr.extraeDato(codigo[a], 1); \r            if ( isInListado2(item, listaDe) == 0)\r            {                toAdd = listaOr.extraeDato(codigo[a], 1);\r				toAdd = toAdd + \"|\" + listaOr.extraeDato(codigo[a], 2);\r                var newRow = new Array();\r                newRow = toAdd.split(\"|\");\r                listaDe.insertar(newRow);\r            }\r        } \r        var nuevos_datos = new Array();\r        listaOr.setDatos(nuevos_datos);\r   }\r   \r   function isInListado2(item, listaDestino)\r   {\r        listaDestino.actualizaDat();\r        var codListD = listaDestino.codigos();\r        var lonLisD = listaDestino.datos.length;\r        \r        var estaEnLista = 0;\r        \r        for(var b = 0; b < lonLisD ; b++)\r        {\r            if (item == codListD[b])\r            {\r                estaEnLista = 1;    \r            }\r        }\r        \r        return estaEnLista;\r   }\r   \r   \r"));
      ((Element)v.get(1)).appendChild((Text)v.get(2));

      /* Termina nodo Texto:2   */
      /* Termina nodo:1   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(3));

      /* Empieza nodo:4 / Elemento padre: 3   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(4)).setAttribute("name","txtTest" );
      ((Element)v.get(4)).setAttribute("cod","00316" );
      ((Element)v.get(4)).setAttribute("required","false" );
      ((Element)v.get(3)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */
      /* Termina nodo:3   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(6)).setAttribute("nombre","formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","accion" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","lstClasificacionParticipantes" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","lstClasificacionParticipantesConsultoras" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","hidUltimoElementoEnLaLista" );
      ((Element)v.get(12)).setAttribute("valor","1" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","hConcuConsultora" );
      ((Element)v.get(13)).setAttribute("valor","N" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(14)).setAttribute("nombre","capaEspacio1" );
      ((Element)v.get(14)).setAttribute("x","0" );
      ((Element)v.get(14)).setAttribute("y","0" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));

      /* Empieza nodo:15 / Elemento padre: 14   */
      v.add(doc.createElement("table"));
      ((Element)v.get(15)).setAttribute("width","100%" );
      ((Element)v.get(15)).setAttribute("border","0" );
      ((Element)v.get(15)).setAttribute("cellspacing","0" );
      ((Element)v.get(15)).setAttribute("cellpadding","0" );
      ((Element)v.get(14)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(15)).appendChild((Element)v.get(16));

      /* Empieza nodo:17 / Elemento padre: 16   */
      v.add(doc.createElement("td"));
      ((Element)v.get(17)).setAttribute("width","12" );
      ((Element)v.get(17)).setAttribute("align","center" );
      ((Element)v.get(16)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(18)).setAttribute("src","b.gif" );
      ((Element)v.get(18)).setAttribute("width","12" );
      ((Element)v.get(18)).setAttribute("height","12" );
      ((Element)v.get(17)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */
      /* Termina nodo:17   */

      /* Empieza nodo:19 / Elemento padre: 16   */
      v.add(doc.createElement("td"));
      ((Element)v.get(19)).setAttribute("width","750" );
      ((Element)v.get(16)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(20)).setAttribute("src","b.gif" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */
      /* Termina nodo:19   */

      /* Empieza nodo:21 / Elemento padre: 16   */
      v.add(doc.createElement("td"));
      ((Element)v.get(21)).setAttribute("width","12" );
      ((Element)v.get(16)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(22)).setAttribute("src","b.gif" );
      ((Element)v.get(22)).setAttribute("width","12" );
      ((Element)v.get(22)).setAttribute("height","1" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(21)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */
      /* Termina nodo:21   */
      /* Termina nodo:16   */

      /* Empieza nodo:23 / Elemento padre: 15   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(15)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(23)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(25)).setAttribute("src","b.gif" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */
      /* Termina nodo:24   */

      /* Empieza nodo:26 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(23)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(26)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(28)).setAttribute("class","legend" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(29)).setAttribute("nombre","lblParticipantes" );
      ((Element)v.get(29)).setAttribute("alto","13" );
      ((Element)v.get(29)).setAttribute("filas","1" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(29)).setAttribute("id","legend" );
      ((Element)v.get(29)).setAttribute("cod","0022" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */
      /* Termina nodo:28   */

      /* Empieza nodo:30 / Elemento padre: 27   */
      v.add(doc.createElement("table"));
      ((Element)v.get(30)).setAttribute("width","100%" );
      ((Element)v.get(30)).setAttribute("border","0" );
      ((Element)v.get(30)).setAttribute("align","center" );
      ((Element)v.get(30)).setAttribute("cellspacing","0" );
      ((Element)v.get(30)).setAttribute("cellpadding","0" );
      ((Element)v.get(27)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(30)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("table"));
      ((Element)v.get(33)).setAttribute("width","648" );
      ((Element)v.get(33)).setAttribute("align","left" );
      ((Element)v.get(33)).setAttribute("border","0" );
      ((Element)v.get(33)).setAttribute("cellspacing","0" );
      ((Element)v.get(33)).setAttribute("cellpadding","0" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).setAttribute("colspan","3" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(36)).setAttribute("src","b.gif" );
      ((Element)v.get(36)).setAttribute("width","8" );
      ((Element)v.get(36)).setAttribute("height","653" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */
      /* Termina nodo:35   */
      /* Termina nodo:34   */
      /* Termina nodo:33   */
      /* Termina nodo:32   */
      /* Termina nodo:31   */
      /* Termina nodo:30   */
      /* Termina nodo:27   */
      /* Termina nodo:26   */
      /* Termina nodo:23   */

      /* Empieza nodo:37 / Elemento padre: 15   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(15)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(39)).setAttribute("src","b.gif" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:40 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("table"));
      ((Element)v.get(42)).setAttribute("width","100%" );
      ((Element)v.get(42)).setAttribute("border","0" );
      ((Element)v.get(42)).setAttribute("align","center" );
      ((Element)v.get(42)).setAttribute("cellspacing","0" );
      ((Element)v.get(42)).setAttribute("cellpadding","0" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).setAttribute("class","botonera" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(45)).setAttribute("nombre","btnAceptar" );
      ((Element)v.get(45)).setAttribute("ID","botonContenido" );
      ((Element)v.get(45)).setAttribute("tipo","html" );
      ((Element)v.get(45)).setAttribute("accion","accionAceptar();" );
      ((Element)v.get(45)).setAttribute("estado","false" );
      ((Element)v.get(45)).setAttribute("cod","12" );
      ((Element)v.get(45)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnAnadirTodos');" );
      ((Element)v.get(45)).setAttribute("ontab","focalizaBotonHTML('botonContenido','btnExcluir');" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */
      /* Termina nodo:43   */
      /* Termina nodo:42   */
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:46 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(47)).setAttribute("src","b.gif" );
      ((Element)v.get(47)).setAttribute("width","8" );
      ((Element)v.get(47)).setAttribute("height","12" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */
      /* Termina nodo:37   */

      /* Empieza nodo:48 / Elemento padre: 15   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(15)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).setAttribute("width","12" );
      ((Element)v.get(49)).setAttribute("align","center" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(50)).setAttribute("src","b.gif" );
      ((Element)v.get(50)).setAttribute("width","12" );
      ((Element)v.get(50)).setAttribute("height","12" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:51 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).setAttribute("width","756" );
      ((Element)v.get(48)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(52)).setAttribute("src","b.gif" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:53 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).setAttribute("width","12" );
      ((Element)v.get(48)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(54)).setAttribute("src","b.gif" );
      ((Element)v.get(54)).setAttribute("width","12" );
      ((Element)v.get(54)).setAttribute("height","1" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */
      /* Termina nodo:48   */
      /* Termina nodo:15   */
      /* Termina nodo:14   */

      /* Empieza nodo:55 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(55)).setAttribute("nombre","listado1" );
      ((Element)v.get(55)).setAttribute("ancho","620" );
      ((Element)v.get(55)).setAttribute("alto","301" );
      ((Element)v.get(55)).setAttribute("x","26" );
      ((Element)v.get(55)).setAttribute("y","37" );
      ((Element)v.get(55)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(55)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(56)).setAttribute("precarga","S" );
      ((Element)v.get(56)).setAttribute("conROver","S" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(57)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(57)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(57)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(57)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 56   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(58)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(58)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(58)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(58)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(56)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 56   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(59)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(59)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(56)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:56   */

      /* Empieza nodo:60 / Elemento padre: 55   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(55)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(61)).setAttribute("borde","1" );
      ((Element)v.get(61)).setAttribute("horizDatos","1" );
      ((Element)v.get(61)).setAttribute("horizCabecera","1" );
      ((Element)v.get(61)).setAttribute("vertical","0" );
      ((Element)v.get(61)).setAttribute("horizTitulo","1" );
      ((Element)v.get(61)).setAttribute("horizBase","1" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 60   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(62)).setAttribute("borde","#999999" );
      ((Element)v.get(62)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(62)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(62)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(62)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(62)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(62)).setAttribute("horizBase","#999999" );
      ((Element)v.get(60)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:60   */

      /* Empieza nodo:63 / Elemento padre: 55   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(63)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(63)).setAttribute("alto","22" );
      ((Element)v.get(63)).setAttribute("imgFondo","" );
      ((Element)v.get(63)).setAttribute("cod","00312" );
      ((Element)v.get(63)).setAttribute("ID","datosTitle" );
      ((Element)v.get(55)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 55   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(64)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(64)).setAttribute("alto","22" );
      ((Element)v.get(64)).setAttribute("imgFondo","" );
      ((Element)v.get(55)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */

      /* Empieza nodo:65 / Elemento padre: 55   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(65)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(65)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(65)).setAttribute("blancosAInsertar","1" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(65)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(65)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(65)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(55)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(66)).setAttribute("ancho","30" );
      ((Element)v.get(66)).setAttribute("minimizable","S" );
      ((Element)v.get(66)).setAttribute("minimizada","N" );
      ((Element)v.get(66)).setAttribute("oculta","S" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 65   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(67)).setAttribute("ancho","30" );
      ((Element)v.get(67)).setAttribute("minimizable","S" );
      ((Element)v.get(67)).setAttribute("minimizada","N" );
      ((Element)v.get(67)).setAttribute("oculta","S" );
      ((Element)v.get(65)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */

      /* Empieza nodo:68 / Elemento padre: 65   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(68)).setAttribute("ancho","5" );
      ((Element)v.get(68)).setAttribute("minimizable","S" );
      ((Element)v.get(68)).setAttribute("minimizada","N" );
      ((Element)v.get(65)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:65   */

      /* Empieza nodo:69 / Elemento padre: 55   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(69)).setAttribute("alto","20" );
      ((Element)v.get(69)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(69)).setAttribute("imgFondo","" );
      ((Element)v.get(69)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(55)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(70)).setAttribute("colFondo","" );
      ((Element)v.get(70)).setAttribute("ID","EstCab" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Elemento padre:70 / Elemento actual: 71   */
      v.add(doc.createTextNode("oidParticipanteConsultora"));
      ((Element)v.get(70)).appendChild((Text)v.get(71));

      /* Termina nodo Texto:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:72 / Elemento padre: 69   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(72)).setAttribute("colFondo","" );
      ((Element)v.get(72)).setAttribute("ID","EstCab" );
      ((Element)v.get(69)).appendChild((Element)v.get(72));

      /* Elemento padre:72 / Elemento actual: 73   */
      v.add(doc.createTextNode("oidParticipante"));
      ((Element)v.get(72)).appendChild((Text)v.get(73));

      /* Termina nodo Texto:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:74 / Elemento padre: 69   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(74)).setAttribute("colFondo","" );
      ((Element)v.get(74)).setAttribute("ID","EstCab" );
      ((Element)v.get(74)).setAttribute("cod","9" );
      ((Element)v.get(74)).setAttribute("align","center" );
      ((Element)v.get(69)).appendChild((Element)v.get(74));

      /* Elemento padre:74 / Elemento actual: 75   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(74)).appendChild((Text)v.get(75));

      /* Termina nodo Texto:75   */
      /* Termina nodo:74   */
      /* Termina nodo:69   */

      /* Empieza nodo:76 / Elemento padre: 55   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(76)).setAttribute("alto","22" );
      ((Element)v.get(76)).setAttribute("accion","" );
      ((Element)v.get(76)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(76)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(76)).setAttribute("maxSel","-1" );
      ((Element)v.get(76)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(76)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(76)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(76)).setAttribute("onLoad","" );
      ((Element)v.get(76)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(55)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(77)).setAttribute("tipo","texto" );
      ((Element)v.get(77)).setAttribute("ID","EstDat2" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */

      /* Empieza nodo:78 / Elemento padre: 76   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(78)).setAttribute("tipo","texto" );
      ((Element)v.get(78)).setAttribute("ID","EstDat2" );
      ((Element)v.get(76)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */

      /* Empieza nodo:79 / Elemento padre: 76   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(79)).setAttribute("tipo","texto" );
      ((Element)v.get(79)).setAttribute("ID","EstDat" );
      ((Element)v.get(76)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:76   */

      /* Empieza nodo:80 / Elemento padre: 55   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(55)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */

      /* Empieza nodo:81 / Elemento padre: 55   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(81)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(81)).setAttribute("ancho","500" );
      ((Element)v.get(81)).setAttribute("sep","$" );
      ((Element)v.get(81)).setAttribute("x","12" );
      ((Element)v.get(81)).setAttribute("class","botonera" );
      ((Element)v.get(81)).setAttribute("y","315" );
      ((Element)v.get(81)).setAttribute("control","|" );
      ((Element)v.get(81)).setAttribute("conector","" );
      ((Element)v.get(81)).setAttribute("rowset","" );
      ((Element)v.get(81)).setAttribute("cargainicial","N" );
      ((Element)v.get(55)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(82)).setAttribute("nombre","ret1" );
      ((Element)v.get(82)).setAttribute("x","37" );
      ((Element)v.get(82)).setAttribute("y","319" );
      ((Element)v.get(82)).setAttribute("ID","botonContenido" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(82)).setAttribute("img","retroceder_on" );
      ((Element)v.get(82)).setAttribute("tipo","0" );
      ((Element)v.get(82)).setAttribute("estado","false" );
      ((Element)v.get(82)).setAttribute("alt","" );
      ((Element)v.get(82)).setAttribute("codigo","" );
      ((Element)v.get(82)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 81   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(83)).setAttribute("nombre","ava1" );
      ((Element)v.get(83)).setAttribute("x","52" );
      ((Element)v.get(83)).setAttribute("y","319" );
      ((Element)v.get(83)).setAttribute("ID","botonContenido" );
      ((Element)v.get(83)).setAttribute("img","avanzar_on" );
      ((Element)v.get(83)).setAttribute("tipo","0" );
      ((Element)v.get(83)).setAttribute("estado","false" );
      ((Element)v.get(83)).setAttribute("alt","" );
      ((Element)v.get(83)).setAttribute("codigo","" );
      ((Element)v.get(83)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(81)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:81   */
      /* Termina nodo:55   */

      /* Empieza nodo:84 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(84)).setAttribute("nombre","primera1" );
      ((Element)v.get(84)).setAttribute("x","20" );
      ((Element)v.get(84)).setAttribute("y","319" );
      ((Element)v.get(84)).setAttribute("ID","botonContenido" );
      ((Element)v.get(84)).setAttribute("img","primera_on" );
      ((Element)v.get(84)).setAttribute("tipo","-2" );
      ((Element)v.get(84)).setAttribute("estado","false" );
      ((Element)v.get(84)).setAttribute("alt","" );
      ((Element)v.get(84)).setAttribute("codigo","" );
      ((Element)v.get(84)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(6)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */

      /* Empieza nodo:85 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(85)).setAttribute("nombre","separa" );
      ((Element)v.get(85)).setAttribute("x","59" );
      ((Element)v.get(85)).setAttribute("y","315" );
      ((Element)v.get(85)).setAttribute("ID","botonContenido" );
      ((Element)v.get(85)).setAttribute("img","separa_base" );
      ((Element)v.get(85)).setAttribute("tipo","0" );
      ((Element)v.get(85)).setAttribute("estado","false" );
      ((Element)v.get(85)).setAttribute("alt","" );
      ((Element)v.get(85)).setAttribute("codigo","" );
      ((Element)v.get(85)).setAttribute("accion","" );
      ((Element)v.get(6)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(86)).setAttribute("nombre","btnExcluir" );
      ((Element)v.get(86)).setAttribute("x","27" );
      ((Element)v.get(86)).setAttribute("y","316" );
      ((Element)v.get(86)).setAttribute("ID","botonContenido" );
      ((Element)v.get(86)).setAttribute("tipo","html" );
      ((Element)v.get(86)).setAttribute("estado","false" );
      ((Element)v.get(86)).setAttribute("accion","accionExcluir();" );
      ((Element)v.get(86)).setAttribute("cod","2421" );
      ((Element)v.get(86)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnAceptar');" );
      ((Element)v.get(86)).setAttribute("ontab","focalizaBotonHTML('botonContenido','btnExcluirTodos');" );
      ((Element)v.get(6)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(87)).setAttribute("nombre","btnExcluirTodos" );
      ((Element)v.get(87)).setAttribute("x","75" );
      ((Element)v.get(87)).setAttribute("y","316" );
      ((Element)v.get(87)).setAttribute("ID","botonContenido" );
      ((Element)v.get(87)).setAttribute("tipo","html" );
      ((Element)v.get(87)).setAttribute("accion","accionExcluirTodos();" );
      ((Element)v.get(87)).setAttribute("estado","false" );
      ((Element)v.get(87)).setAttribute("cod","2422" );
      ((Element)v.get(87)).setAttribute("ontab","focalizaBotonHTML('botonContenido','btnAnadir');" );
      ((Element)v.get(6)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */

      /* Empieza nodo:88 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(88)).setAttribute("nombre","listado2" );
      ((Element)v.get(88)).setAttribute("ancho","620" );
      ((Element)v.get(88)).setAttribute("alto","301" );
      ((Element)v.get(88)).setAttribute("x","26" );
      ((Element)v.get(88)).setAttribute("y","362" );
      ((Element)v.get(88)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(88)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(89)).setAttribute("precarga","S" );
      ((Element)v.get(89)).setAttribute("conROver","S" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(90)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(90)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(90)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(90)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */

      /* Empieza nodo:91 / Elemento padre: 89   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(91)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(91)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(91)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(91)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(89)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 89   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(92)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(92)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(89)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:89   */

      /* Empieza nodo:93 / Elemento padre: 88   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(88)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(94)).setAttribute("borde","1" );
      ((Element)v.get(94)).setAttribute("horizDatos","1" );
      ((Element)v.get(94)).setAttribute("horizCabecera","1" );
      ((Element)v.get(94)).setAttribute("vertical","0" );
      ((Element)v.get(94)).setAttribute("horizTitulo","1" );
      ((Element)v.get(94)).setAttribute("horizBase","1" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */

      /* Empieza nodo:95 / Elemento padre: 93   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(95)).setAttribute("borde","#999999" );
      ((Element)v.get(95)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(95)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(95)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(95)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(95)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(95)).setAttribute("horizBase","#999999" );
      ((Element)v.get(93)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:93   */

      /* Empieza nodo:96 / Elemento padre: 88   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(96)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(96)).setAttribute("alto","22" );
      ((Element)v.get(96)).setAttribute("imgFondo","" );
      ((Element)v.get(96)).setAttribute("cod","00313" );
      ((Element)v.get(96)).setAttribute("ID","datosTitle" );
      ((Element)v.get(88)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */

      /* Empieza nodo:97 / Elemento padre: 88   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(97)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(97)).setAttribute("alto","22" );
      ((Element)v.get(97)).setAttribute("imgFondo","" );
      ((Element)v.get(88)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */

      /* Empieza nodo:98 / Elemento padre: 88   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(98)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(98)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(98)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(98)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(98)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(98)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(88)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(99)).setAttribute("ancho","5" );
      ((Element)v.get(99)).setAttribute("minimizable","S" );
      ((Element)v.get(99)).setAttribute("minimizada","N" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:100 / Elemento padre: 88   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(100)).setAttribute("alto","20" );
      ((Element)v.get(100)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(100)).setAttribute("imgFondo","" );
      ((Element)v.get(100)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(88)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(101)).setAttribute("colFondo","" );
      ((Element)v.get(101)).setAttribute("ID","EstCab" );
      ((Element)v.get(101)).setAttribute("cod","9" );
      ((Element)v.get(101)).setAttribute("align","center" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Elemento padre:101 / Elemento actual: 102   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(101)).appendChild((Text)v.get(102));

      /* Termina nodo Texto:102   */
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:103 / Elemento padre: 88   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(103)).setAttribute("alto","22" );
      ((Element)v.get(103)).setAttribute("accion","" );
      ((Element)v.get(103)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(103)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(103)).setAttribute("maxSel","-1" );
      ((Element)v.get(103)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(103)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(103)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(103)).setAttribute("onLoad","" );
      ((Element)v.get(103)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(88)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(104)).setAttribute("tipo","texto" );
      ((Element)v.get(104)).setAttribute("ID","EstDat" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 88   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(88)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */

      /* Empieza nodo:106 / Elemento padre: 88   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(106)).setAttribute("nombre","mipgndo2" );
      ((Element)v.get(106)).setAttribute("ancho","500" );
      ((Element)v.get(106)).setAttribute("sep","$" );
      ((Element)v.get(106)).setAttribute("x","12" );
      ((Element)v.get(106)).setAttribute("class","botonera" );
      ((Element)v.get(106)).setAttribute("y","640" );
      ((Element)v.get(106)).setAttribute("control","|" );
      ((Element)v.get(106)).setAttribute("conector","" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(106)).setAttribute("rowset","" );
      ((Element)v.get(106)).setAttribute("cargainicial","N" );
      ((Element)v.get(88)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(107)).setAttribute("nombre","ret2" );
      ((Element)v.get(107)).setAttribute("x","37" );
      ((Element)v.get(107)).setAttribute("y","644" );
      ((Element)v.get(107)).setAttribute("ID","botonContenido" );
      ((Element)v.get(107)).setAttribute("img","retroceder_on" );
      ((Element)v.get(107)).setAttribute("tipo","0" );
      ((Element)v.get(107)).setAttribute("estado","false" );
      ((Element)v.get(107)).setAttribute("alt","" );
      ((Element)v.get(107)).setAttribute("codigo","" );
      ((Element)v.get(107)).setAttribute("accion","mipgndo2.retroceder();" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */

      /* Empieza nodo:108 / Elemento padre: 106   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(108)).setAttribute("nombre","ava2" );
      ((Element)v.get(108)).setAttribute("x","52" );
      ((Element)v.get(108)).setAttribute("y","644" );
      ((Element)v.get(108)).setAttribute("ID","botonContenido" );
      ((Element)v.get(108)).setAttribute("img","avanzar_on" );
      ((Element)v.get(108)).setAttribute("tipo","0" );
      ((Element)v.get(108)).setAttribute("estado","false" );
      ((Element)v.get(108)).setAttribute("alt","" );
      ((Element)v.get(108)).setAttribute("codigo","" );
      ((Element)v.get(108)).setAttribute("accion","mipgndo2.avanzar();" );
      ((Element)v.get(106)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:106   */
      /* Termina nodo:88   */

      /* Empieza nodo:109 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(109)).setAttribute("nombre","primera2" );
      ((Element)v.get(109)).setAttribute("x","20" );
      ((Element)v.get(109)).setAttribute("y","644" );
      ((Element)v.get(109)).setAttribute("ID","botonContenido" );
      ((Element)v.get(109)).setAttribute("img","primera_on" );
      ((Element)v.get(109)).setAttribute("tipo","-2" );
      ((Element)v.get(109)).setAttribute("estado","false" );
      ((Element)v.get(109)).setAttribute("alt","" );
      ((Element)v.get(109)).setAttribute("codigo","" );
      ((Element)v.get(109)).setAttribute("accion","mipgndo2.retrocederPrimeraPagina();" );
      ((Element)v.get(6)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */

      /* Empieza nodo:110 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(110)).setAttribute("nombre","separa2" );
      ((Element)v.get(110)).setAttribute("x","59" );
      ((Element)v.get(110)).setAttribute("y","640" );
      ((Element)v.get(110)).setAttribute("ID","botonContenido" );
      ((Element)v.get(110)).setAttribute("img","separa_base" );
      ((Element)v.get(110)).setAttribute("tipo","0" );
      ((Element)v.get(110)).setAttribute("estado","false" );
      ((Element)v.get(110)).setAttribute("alt","" );
      ((Element)v.get(110)).setAttribute("codigo","" );
      ((Element)v.get(110)).setAttribute("accion","" );
      ((Element)v.get(6)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */

      /* Empieza nodo:111 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(111)).setAttribute("nombre","btnAnadir" );
      ((Element)v.get(111)).setAttribute("x","27" );
      ((Element)v.get(111)).setAttribute("y","641" );
      ((Element)v.get(111)).setAttribute("ID","botonContenido" );
      ((Element)v.get(111)).setAttribute("tipo","html" );
      ((Element)v.get(111)).setAttribute("estado","false" );
      ((Element)v.get(111)).setAttribute("accion","accionAniadir();" );
      ((Element)v.get(111)).setAttribute("cod","404" );
      ((Element)v.get(111)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnExcluirTodos');" );
      ((Element)v.get(6)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */

      /* Empieza nodo:112 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(112)).setAttribute("nombre","btnAnadirTodos" );
      ((Element)v.get(112)).setAttribute("x","75" );
      ((Element)v.get(112)).setAttribute("y","641" );
      ((Element)v.get(112)).setAttribute("ID","botonContenido" );
      ((Element)v.get(112)).setAttribute("tipo","html" );
      ((Element)v.get(112)).setAttribute("estado","false" );
      ((Element)v.get(112)).setAttribute("cod","1670" );
      ((Element)v.get(112)).setAttribute("accion","accionAniadirTodos();" );
      ((Element)v.get(112)).setAttribute("ontab","focalizaBotonHTML('botonContenido','btnAceptar');" );
      ((Element)v.get(6)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:6   */


   }

}
