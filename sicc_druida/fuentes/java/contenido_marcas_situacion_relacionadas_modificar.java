
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_marcas_situacion_relacionadas_modificar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_marcas_situacion_relacionadas_modificar" );
      ((Element)v.get(0)).setAttribute("cod","0405" );
      ((Element)v.get(0)).setAttribute("titulo","Modificar marcas de situaci�n relacionadas por tipo de abono" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Modificar marcas de situaci�n relacionadas por tipo de abono" );
      ((Element)v.get(0)).setAttribute("onload","Init();" );
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
      v.add(doc.createTextNode("\r   \r    var subProcesoHabilitado = false;\r    var tipoAbonoHabilitado = false; \r\r     function Init()   {   \r     \r      \r      DrdEnsanchaConMargenDcho('listado1',12); \r      eval(ON_RSZ); \r\r            var opcion = get(\"frmMarcas.opcionMenu\");\r      var caso = get(\"frmMarcas.casoDeUso\");\r      if(caso == \"eliminar\") {\r        listado1.maxSel = \"-1\";\r      }\r      \r      document.all[\"Cplistado1\"].style.visibility='hidden'; \r      document.all[\"CpLin1listado1\"].style.visibility='hidden'; \r      document.all[\"CpLin2listado1\"].style.visibility='hidden'; \r      document.all[\"CpLin3listado1\"].style.visibility='hidden'; \r      document.all[\"CpLin4listado1\"].style.visibility='hidden'; \r\r      document.all[\"primera1Div\"].style.visibility='hidden'; \r      document.all[\"ret1Div\"].style.visibility='hidden'; \r      document.all[\"ava1Div\"].style.visibility='hidden'; \r      document.all[\"ModificarDiv\"].style.visibility='hidden';\r      document.all[\"DetalleDiv\"].style.visibility='hidden';\r      document.all[\"DetalleEliminaDiv\"].style.visibility='hidden';\r	  document.all[\"separaDiv\"].style.visibility='hidden';\r      \r      configurarMenuSecundario(\"frmMarcas\");\r      focaliza(\"frmMarcas.cmbProcesos\");\r\r      if((get('frmMarcas.casoDeUso')=='vuelveModificar')||(get('frmMarcas.casoDeUso')=='vuelveEliminar')){\r	       set('frmMarcas.cmbProcesos',get('frmMarcas.hProcesos'));\r		     set('frmMarcas.cmbSubProcesos',get('frmMarcas.hSubProcesos'));\r		     set('frmMarcas.cmbTipoCargo',get('frmMarcas.hTipoCargo'));       	\r         \r         if( get('frmMarcas.casoDeUso')=='vuelveEliminar' ) {\r            set('frmMarcas.casoDeUso','eliminar');\r            btnProxy(4, '1');\r         }\r         else if( get('frmMarcas.casoDeUso')=='vuelveModificar' ) {\r                set('frmMarcas.casoDeUso','modificar');\r              }\r      }\r\r      if (get('frmMarcas.errDescripcion')!='') {\r        var wnd = fMostrarMensajeError(get('frmMarcas.errCodigo'), get('frmMarcas.errDescripcion'));\r      }   \r\r      accion(\"frmMarcas.cmbSubProcesos\",\".disabled=true\");\r      accion(\"frmMarcas.cmbTipoCargo\",\".disabled=true\");  \r    }\r\r   function deselectBugLISTAEDITABLE(list){\r      for(var x = 0; x < list.datos.length; x++)\r           list.deselecciona (x); \r   }\r\r   function fLimpiar(){\r      var objArr = document.all['cmbProcesos'];\r      for(var i=0; i < objArr.length; i++){\r        if(objArr[i].tagName && objArr[i].tagName.toUpperCase()==\"SELECT\"){\r          if (!objArr[i].disabled)\r              set('frmMarcas.cmbProcesos','');					\r        }\r      }\r\r      var objArr = document.all['cmbTipoCargo'];\r      for(var i=0; i < objArr.length; i++){\r        if(objArr[i].tagName && objArr[i].tagName.toUpperCase()==\"SELECT\"){\r          if (!objArr[i].disabled) {\r            var aCombo = new Array(new Array(\"\",\"\"));\r            set_combo('frmMarcas.cmbTipoCargo',aCombo, []);\r          }\r        }\r      }\r      \r      var objArr = document.all['cmbSubProcesos'];\r      for(var i=0; i < objArr.length; i++){\r        if(objArr[i].tagName && objArr[i].tagName.toUpperCase()==\"SELECT\"){\r          if (!objArr[i].disabled) {\r            var aCombo = new Array(new Array(\"\",\"\"));\r            set_combo('frmMarcas.cmbSubProcesos',aCombo, []);				\r          }\r        }\r      }\r\r      accion(\"frmMarcas.cmbSubProcesos\",\".disabled=true\");  \r      accion(\"frmMarcas.cmbTipoCargo\",\".disabled=true\");\r      subProcesoHabilitado = false;\r      tipoAbonoHabilitado = false; \r      focaliza(\"frmMarcas.cmbProcesos\");   \r   }\r\r   function accionModificar() {\r      \r      if (listado1.numSelecc()!= 1) {\r          GestionarMensaje('1022',null,null,null);\r		      return false;\r      }\r\r      var arrAux = new Array();\r      arrAux = listado1.codSeleccionados();\r      var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);\r      var obj = new Object();\r      \r      obj.oid = listado1.datos[posicion][5];\r      \r      obj.oidProceso = listado1.datos[posicion][5];\r      obj.oidSubproceso = listado1.datos[posicion][6];\r      obj.oidTipoAbono = listado1.datos[posicion][0];\r      \r      \r      \r      \r      \r      obj.casoDeUso=\"modificar\";\r      obj.accion = \"modificar\";\r      \r      mostrarModalSICC('LPMarcasTipo','modificar',obj,800,600);\r		  accionBuscar();\r      focaliza(\"frmMarcas.cmbProcesos\");\r   }\r\r   function accionEliminar() {\r     if((get('frmMarcas.casoDeUso').toString()==\"eliminar\")){\r           if (listado1.numSelecc()== 1){		\r               var arrAux = new Array();\r               arrAux = listado1.codSeleccionados();\r               var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);		\r               var obj = new Object();\r			   \r               obj.oid=listado1.datos[posicion][0];               \r               obj.oidProceso = listado1.datos[posicion][5];\r               obj.oidSubproceso = listado1.datos[posicion][6];\r               obj.oidTipoAbono = listado1.datos[posicion][0];               \r               \r               obj.casoDeUso = \"eliminar\";\r               obj.accion = \"detalle\";\r               mostrarModalSICC('LPMarcasTipo','detalle',obj,800,600);\r               accionBuscar();\r           }else{\r            GestionarMensaje('4');\r           }\r        }\r   }\r   \r   \r   \r     function accionVerDetalle (){   \r      if((get('frmMarcas.casoDeUso').toString()==\"consultar\")){\r	       if (listado1.numSelecc()== 1){		\r		         var arrAux = new Array();\r		         arrAux = listado1.codSeleccionados();\r		         var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);		\r		         \r             var obj = new Object();\r             obj.oid=listado1.datos[posicion][0];\r             \r             obj.oidProceso = listado1.datos[posicion][5];\r             obj.oidSubproceso = listado1.datos[posicion][6];\r             obj.oidTipoAbono = listado1.datos[posicion][0];\r             \r		     obj.casoDeUso = \"consultar\";\r             obj.accion = \"detalle\";\r             \r		         mostrarModalSICC('LPMarcasTipo','detalle',obj,800,600);\r             accionBuscar();\r  	     }else{\r		      GestionarMensaje('4');\r	       }\r      }\r   }\r\r    function accionConsultar(){   \r      if((get('frmMarcas.casoDeUso').toString()==\"consultar\")){\r	       if (listado1.numSelecc()== 1){		\r		         var arrAux = new Array();\r		         arrAux = listado1.codSeleccionados();\r		         var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);		\r             var obj = new Object();\r             obj.oid=listado1.datos[posicion][0];\r             \r		         obj.casoDeUso = \"consultar\";\r             obj.accion = \"detalle\";\r             \r		         mostrarModalSICC('LPMarcasTipo','detalle',obj,800,600);\r             accionBuscar();\r  	     }else{\r		      GestionarMensaje('4');\r	       }\r      }\r   }\r\r   function obtenerPosicionListaEditable(clave, lista){\r      this.posicion = 0;\r      if (lista.codSeleccionados().length > 0){\r         for(var k=0;k<lista.datos.length;k++) {\r               if (lista.datos[k][0] == clave) {\r                  posicion=k;\r                  break;\r               }\r		     }         \r	       return posicion;\r	     }\r   }\r\r   function procesoOnChange() {\r      var valor = get(\"frmMarcas.cmbProcesos\");\r      if(valor==\"\") {\r\r        var objArr = document.all['cmbSubProcesos'];\r        for(var i=0; i < objArr.length; i++){\r          if(objArr[i].tagName && objArr[i].tagName.toUpperCase()==\"SELECT\"){\r            if (!objArr[i].disabled) {\r              var aCombo = new Array(new Array(\"\",\"\"));\r              set_combo('frmMarcas.cmbSubProcesos',aCombo, []);				\r            }\r          }\r        }\r\r        var objArr = document.all['cmbTipoCargo'];\r        for(var i=0; i < objArr.length; i++){\r          if(objArr[i].tagName && objArr[i].tagName.toUpperCase()==\"SELECT\"){\r            if (!objArr[i].disabled) {\r              var aCombo = new Array(new Array(\"\",\"\"));\r              set_combo('frmMarcas.cmbTipoCargo',aCombo, []);\r            }\r          }\r        }\r\r        accion(\"frmMarcas.cmbSubProcesos\",\".disabled=true\");\r        accion(\"frmMarcas.cmbTipoCargo\",\".disabled=true\");\r        subProcesoHabilitado = false;\r        return;\r      }\r    \r      var arr = new Array();\r      arr[arr.length]=new Array(\"oid\", get(\"frmMarcas.cmbProcesos\"));\r      recargaCombo(\"frmMarcas.cmbSubProcesos\", 'CCCobtieneSubprocesos', 'es.indra.sicc.util.DTOOID', arr);\r      \r      accion(\"frmMarcas.cmbSubProcesos\",\".disabled=false\");\r\r      var objArr = document.all['cmbTipoCargo'];\r      for(var i=0; i < objArr.length; i++){\r        if(objArr[i].tagName && objArr[i].tagName.toUpperCase()==\"SELECT\"){\r          if (!objArr[i].disabled) {\r            var aCombo = new Array(new Array(\"\",\"\"));\r            set_combo('frmMarcas.cmbTipoCargo',aCombo, []);\r          }\r        }\r      }\r      \r      accion(\"frmMarcas.cmbTipoCargo\",\".disabled=true\");\r      subProcesoHabilitado = true;\r   }\r\r   function subprocesoOnChange() {\r      var valor = get(\"frmMarcas.cmbSubProcesos\");\r      if(valor==\"\") {\r        var objArr = document.all['cmbTipoCargo'];\r        for(var i=0; i < objArr.length; i++){\r          if(objArr[i].tagName && objArr[i].tagName.toUpperCase()==\"SELECT\"){\r            if (!objArr[i].disabled) {\r              var aCombo = new Array(new Array(\"\",\"\"));\r              set_combo('frmMarcas.cmbTipoCargo',aCombo, []);\r            }\r          }\r        }      \r        accion(\"frmMarcas.cmbTipoCargo\",\".disabled=true\");\r        tipoAbonoHabilitado = false;\r        return;      \r      }\r      \r      var arr = new Array();      \r      arr[arr.length]=new Array(\"oid\", get(\"frmMarcas.cmbSubProcesos\"));\r      arr[arr.length]=new Array(\"oidIdioma\", get(\"frmMarcas.hIdioma\"));      \r      recargaCombo(\"frmMarcas.cmbTipoCargo\", 'CCCObtenerTIposAbonosSubproceso', 'es.indra.sicc.util.DTOOID', arr);\r      accion(\"frmMarcas.cmbTipoCargo\",\".disabled=false\");\r      tipoAbonoHabilitado = true;\r    }    \r    \r\r   function accionBuscar(){   \r       \r       \r      \r      deselectBugLISTAEDITABLE(listado1);\r      \r      var arr = new Array();\r      arr[arr.length] = new Array(\"proceso\", get(\"frmMarcas.cmbProcesos\")+\"\");\r      arr[arr.length] = new Array(\"subproceso\", get(\"frmMarcas.cmbSubProcesos\")+\"\");\r      arr[arr.length] = new Array(\"tipoAbono\", get(\"frmMarcas.cmbTipoCargo\")+\"\");\r      \r      configurarPaginado(mipgndo,\"CCCBuscarMarcasTipo\",\"ConectorBuscarMarcasTipo\",\"es.indra.sicc.dtos.ccc.DTOMarcasPorTipoAbono\",arr);      \r      \r      document.all[\"primera1Div\"].style.visibility='';\r      document.all[\"ret1Div\"].style.visibility='';\r      document.all[\"ava1Div\"].style.visibility='';\r\r      document.all[\"Cplistado1\"].style.visibility=''; \r      document.all[\"CpLin1listado1\"].style.visibility=''; \r      document.all[\"CpLin2listado1\"].style.visibility=''; \r      document.all[\"CpLin3listado1\"].style.visibility=''; \r      document.all[\"CpLin4listado1\"].style.visibility=''; \r	  document.all[\"separaDiv\"].style.visibility='';\r\r    \r      if(get('frmMarcas.casoDeUso')=='modificar') {\r        document.all[\"DetalleDiv\"].style.visibility='hidden';	\r		    document.all[\"ModificarDiv\"].style.visibility='';\r        document.all[\"DetalleEliminaDiv\"].style.visibility='hidden';\r		  }\r\r      if(get('frmMarcas.casoDeUso')=='consultar') { \r        document.all[\"DetalleDiv\"].style.visibility='';	\r	 	    document.all[\"ModificarDiv\"].style.visibility='hidden';\r        document.all[\"DetalleEliminaDiv\"].style.visibility='hidden';\r      }\r      \r      if(get('frmMarcas.casoDeUso')=='eliminar') {\r        document.all[\"DetalleDiv\"].style.visibility='hidden';	\r	 	    document.all[\"ModificarDiv\"].style.visibility='hidden';\r        document.all[\"DetalleEliminaDiv\"].style.visibility='';\r      }\r      ocultaCapas();      \r   }\r\r   function fBorrar() {\r     if (listado1.numSelecc()== 0) {\r       GestionarMensaje('1021',null,null,null);\r       return false;\r     }\r     \r     codSelec = listado1.codSeleccionados(); \r     eliminarFilas(codSelec,\"CCCeliminaMarcasTipo\", mipgndo); \r      \r   }  \r\r  function comboProceso() {\r    focaliza(\"frmMarcas.cmbProcesos\");\r  }\r  \r  function comboSubProcesos() {\r    if(subProcesoHabilitado==false) {\r        focalizaBotonHTML('botonContenido','btnBuscar');\r        return;\r    }\r    focaliza(\"frmMarcas.cmbSubProcesos\");\r  }\r\r  function comboTipo() {      \r      if((subProcesoHabilitado==false) && (tipoAbonoHabilitado==false)) {\r        focaliza(\"frmMarcas.cmbProcesos\");\r        return;\r      }\r\r      if((subProcesoHabilitado==true) && (tipoAbonoHabilitado==false)) {\r        focaliza(\"frmMarcas.cmbSubProcesos\");\r        return;\r      }\r\r      if((subProcesoHabilitado==true) && (tipoAbonoHabilitado==true)) {\r        focaliza(\"frmMarcas.cmbTipoCargo\");\r        return;\r      }            \r  }\r\r  function comboBoton() {\r      if(tipoAbonoHabilitado==false) {\r        focalizaBotonHTML('botonContenido','btnBuscar');\r        return;\r      }  \r      focaliza(\"frmMarcas.cmbTipoCargo\");      \r  }  \r\r  function botonBuscar() {\r    focalizaBotonHTML('botonContenido','btnBuscar');\r  }\r \r  function botonLista() {\r    var oculto = document.all[\"Cplistado1\"].style.visibility;\r\r    if(oculto=='hidden') {\r      focaliza(\"frmMarcas.cmbProcesos\");\r      return;    \r    }  \r\r    var caso = get('frmMarcas.casoDeUso');\r\r    if(caso=='modificar'){\r      focalizaBotonHTML_XY('Modificar')\r    }\r\r    if(caso=='consultar'){\r      focalizaBotonHTML_XY('Detalle')\r    }  \r\r    if(caso=='eliminar'){\r      focalizaBotonHTML_XY('DetalleElimina');\r    }      \r  }\r\r  function ultimoBoton() {\r      var oculto = document.all[\"Cplistado1\"].style.visibility;\r\r      if(oculto=='hidden') {\r        focalizaBotonHTML('botonContenido','btnBuscar');\r        return;    \r      }  \r\r      var caso = get('frmMarcas.casoDeUso');\r\r      if(caso=='modificar'){\r        focalizaBotonHTML_XY('Modificar');\r      }\r\r      if(caso=='consultar'){\r        focalizaBotonHTML_XY('Detalle');\r      }\r\r      if(caso=='eliminar'){\r        focalizaBotonHTML_XY('DetalleElimina');\r      }      \r  }\r\r  function ocultaCapas(){	\r      document.all[\"Cplistado1\"].style.visibility='hidden';\r      document.all[\"CpLin1listado1\"].style.visibility='hidden';\r      document.all[\"CpLin2listado1\"].style.visibility='hidden';\r      document.all[\"CpLin3listado1\"].style.visibility='hidden';\r      document.all[\"CpLin4listado1\"].style.visibility='hidden';\r      document.all[\"primera1Div\"].style.visibility='hidden';\r      document.all[\"ret1Div\"].style.visibility='hidden';\r      document.all[\"ava1Div\"].style.visibility='hidden';\r      document.all[\"separaDiv\"].style.visibility='hidden';\r	  document.all[\"ModificarDiv\"].style.visibility='hidden';\r	  document.all[\"DetalleDiv\"].style.visibility='hidden';\r      document.all[\"DetalleEliminaDiv\"].style.visibility='hidden';\r  }\r\r\r  function muestraCapas() {\r	 document.all[\"Cplistado1\"].style.visibility='';\r     document.all[\"CpLin1listado1\"].style.visibility='';\r     document.all[\"CpLin2listado1\"].style.visibility='';\r     document.all[\"CpLin3listado1\"].style.visibility='';\r     document.all[\"CpLin4listado1\"].style.visibility='';\r     document.all[\"primera1Div\"].style.visibility='';\r     document.all[\"ret1Div\"].style.visibility='';\r     document.all[\"ava1Div\"].style.visibility='';\r     document.all[\"separaDiv\"].style.visibility='';\r\r	 if(get('frmMarcas.casoDeUso')=='modificar') {\r		document.all[\"DetalleDiv\"].style.visibility='hidden';	\r		document.all[\"ModificarDiv\"].style.visibility='';\r        document.all[\"DetalleEliminaDiv\"].style.visibility='hidden';        \r	 }\r\r     if(get('frmMarcas.casoDeUso')=='consultar') { \r        document.all[\"DetalleDiv\"].style.visibility='';	\r        document.all[\"ModificarDiv\"].style.visibility='hidden';     \r        document.all[\"DetalleEliminaDiv\"].style.visibility='hidden';\r     }\r\r     if(get('frmMarcas.casoDeUso')=='eliminar') { \r        document.all[\"DetalleDiv\"].style.visibility='hidden';	\r        document.all[\"ModificarDiv\"].style.visibility='hidden';  \r        document.all[\"DetalleEliminaDiv\"].style.visibility='';\r     }\r  }\r\r  function muestraLista( ultima, rowset, error){\r      var tamano = rowset.length;\r			if (tamano > 0) {\r        muestraCapas();\r        eval (ON_RSZ);\r				focaliza('frmMarcas.cmbProcesos');\r				return true;\r      }\r\r      else {\r        ocultaCapas();\r                focaliza('frmMarcas.cmbProcesos');\r                return false;\r      }\r    }\r    \r   \r"));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(6)).setAttribute("nombre","frmMarcas" );
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
      ((Element)v.get(9)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","oid" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","oidProceso" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","oidSubproceso" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","oidTipoAbono" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hProcesos" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hSubProcesos" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hTipoCargo" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","elementosSeleccionados" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hPais" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hIdioma" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 6   */
      v.add(doc.createElement("table"));
      ((Element)v.get(22)).setAttribute("width","100%" );
      ((Element)v.get(22)).setAttribute("border","0" );
      ((Element)v.get(22)).setAttribute("cellspacing","0" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).setAttribute("cellpadding","0" );
      ((Element)v.get(6)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(22)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(24)).setAttribute("width","12" );
      ((Element)v.get(24)).setAttribute("align","center" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(25)).setAttribute("src","b.gif" );
      ((Element)v.get(25)).setAttribute("width","12" );
      ((Element)v.get(25)).setAttribute("height","12" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */
      /* Termina nodo:24   */

      /* Empieza nodo:26 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).setAttribute("width","750" );
      ((Element)v.get(23)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(27)).setAttribute("src","b.gif" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */
      /* Termina nodo:26   */

      /* Empieza nodo:28 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(28)).setAttribute("width","12" );
      ((Element)v.get(23)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(29)).setAttribute("src","b.gif" );
      ((Element)v.get(29)).setAttribute("width","12" );
      ((Element)v.get(29)).setAttribute("height","1" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */
      /* Termina nodo:28   */
      /* Termina nodo:23   */

      /* Empieza nodo:30 / Elemento padre: 22   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(22)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("td"));
      ((Element)v.get(30)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(32)).setAttribute("src","b.gif" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */
      /* Termina nodo:31   */

      /* Empieza nodo:33 / Elemento padre: 30   */
      v.add(doc.createElement("td"));
      ((Element)v.get(30)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(35)).setAttribute("class","legend" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(36)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(36)).setAttribute("ancho","160" );
      ((Element)v.get(36)).setAttribute("alto","13" );
      ((Element)v.get(36)).setAttribute("filas","1" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(36)).setAttribute("id","legend" );
      ((Element)v.get(36)).setAttribute("cod","0075" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */
      /* Termina nodo:35   */

      /* Empieza nodo:37 / Elemento padre: 34   */
      v.add(doc.createElement("table"));
      ((Element)v.get(37)).setAttribute("width","100%" );
      ((Element)v.get(37)).setAttribute("border","0" );
      ((Element)v.get(37)).setAttribute("align","center" );
      ((Element)v.get(37)).setAttribute("cellspacing","0" );
      ((Element)v.get(37)).setAttribute("cellpadding","0" );
      ((Element)v.get(34)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("td"));
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("table"));
      ((Element)v.get(40)).setAttribute("width","526" );
      ((Element)v.get(40)).setAttribute("border","0" );
      ((Element)v.get(40)).setAttribute("align","left" );
      ((Element)v.get(40)).setAttribute("cellspacing","0" );
      ((Element)v.get(40)).setAttribute("cellpadding","0" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).setAttribute("colspan","4" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(43)).setAttribute("src","b.gif" );
      ((Element)v.get(43)).setAttribute("width","8" );
      ((Element)v.get(43)).setAttribute("height","8" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:44 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(46)).setAttribute("src","b.gif" );
      ((Element)v.get(46)).setAttribute("width","8" );
      ((Element)v.get(46)).setAttribute("height","8" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:47 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(48)).setAttribute("nombre","lblProceso" );
      ((Element)v.get(48)).setAttribute("alto","17" );
      ((Element)v.get(48)).setAttribute("filas","1" );
      ((Element)v.get(48)).setAttribute("id","datosTitle" );
      ((Element)v.get(48)).setAttribute("cod","689" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:49 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(50)).setAttribute("src","b.gif" );
      ((Element)v.get(50)).setAttribute("width","25" );
      ((Element)v.get(50)).setAttribute("height","8" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:51 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(52)).setAttribute("nombre","lblSubproceso" );
      ((Element)v.get(52)).setAttribute("alto","17" );
      ((Element)v.get(52)).setAttribute("filas","1" );
      ((Element)v.get(52)).setAttribute("id","datosTitle" );
      ((Element)v.get(52)).setAttribute("cod","696" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:53 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).setAttribute("width","100%" );
      ((Element)v.get(44)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(54)).setAttribute("src","b.gif" );
      ((Element)v.get(54)).setAttribute("width","8" );
      ((Element)v.get(54)).setAttribute("height","8" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */
      /* Termina nodo:44   */

      /* Empieza nodo:55 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(57)).setAttribute("src","b.gif" );
      ((Element)v.get(57)).setAttribute("width","8" );
      ((Element)v.get(57)).setAttribute("height","8" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:58 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(55)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(59)).setAttribute("nombre","cmbProcesos" );
      ((Element)v.get(59)).setAttribute("size","1" );
      ((Element)v.get(59)).setAttribute("multiple","N" );
      ((Element)v.get(59)).setAttribute("req","N" );
      ((Element)v.get(59)).setAttribute("valorinicial","" );
      ((Element)v.get(59)).setAttribute("textoinicial","" );
      ((Element)v.get(59)).setAttribute("id","datosCampos" );
      ((Element)v.get(59)).setAttribute("onchange","procesoOnChange();" );
      ((Element)v.get(59)).setAttribute("ontab","comboSubProcesos();" );
      ((Element)v.get(59)).setAttribute("onshtab","ultimoBoton();" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:61 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(62)).setAttribute("width","25" );
      ((Element)v.get(62)).setAttribute("height","8" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(55)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(64)).setAttribute("nombre","cmbSubProcesos" );
      ((Element)v.get(64)).setAttribute("size","1" );
      ((Element)v.get(64)).setAttribute("multiple","N" );
      ((Element)v.get(64)).setAttribute("req","N" );
      ((Element)v.get(64)).setAttribute("valorinicial","" );
      ((Element)v.get(64)).setAttribute("textoinicial","" );
      ((Element)v.get(64)).setAttribute("id","datosCampos" );
      ((Element)v.get(64)).setAttribute("onchange","subprocesoOnChange();" );
      ((Element)v.get(64)).setAttribute("ontab","comboBoton();" );
      ((Element)v.get(64)).setAttribute("onshtab","comboProceso();" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:66 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).setAttribute("width","100%" );
      ((Element)v.get(55)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(67)).setAttribute("src","b.gif" );
      ((Element)v.get(67)).setAttribute("width","8" );
      ((Element)v.get(67)).setAttribute("height","8" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:55   */

      /* Empieza nodo:68 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).setAttribute("colspan","4" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(70)).setAttribute("src","b.gif" );
      ((Element)v.get(70)).setAttribute("width","8" );
      ((Element)v.get(70)).setAttribute("height","8" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:40   */
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:71 / Elemento padre: 37   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(37)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("table"));
      ((Element)v.get(73)).setAttribute("width","526" );
      ((Element)v.get(73)).setAttribute("border","0" );
      ((Element)v.get(73)).setAttribute("align","left" );
      ((Element)v.get(73)).setAttribute("cellspacing","0" );
      ((Element)v.get(73)).setAttribute("cellpadding","0" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","8" );
      ((Element)v.get(76)).setAttribute("height","8" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(78)).setAttribute("nombre","lblTipoAbono" );
      ((Element)v.get(78)).setAttribute("alto","17" );
      ((Element)v.get(78)).setAttribute("filas","1" );
      ((Element)v.get(78)).setAttribute("id","datosTitle" );
      ((Element)v.get(78)).setAttribute("cod","1357" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:79 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).setAttribute("width","100%" );
      ((Element)v.get(74)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(80)).setAttribute("src","b.gif" );
      ((Element)v.get(80)).setAttribute("width","8" );
      ((Element)v.get(80)).setAttribute("height","8" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */
      /* Termina nodo:74   */

      /* Empieza nodo:81 / Elemento padre: 73   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(73)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("td"));
      ((Element)v.get(81)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(83)).setAttribute("src","b.gif" );
      ((Element)v.get(83)).setAttribute("width","8" );
      ((Element)v.get(83)).setAttribute("height","8" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:84 / Elemento padre: 81   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(81)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(85)).setAttribute("nombre","cmbTipoCargo" );
      ((Element)v.get(85)).setAttribute("size","1" );
      ((Element)v.get(85)).setAttribute("multiple","N" );
      ((Element)v.get(85)).setAttribute("req","N" );
      ((Element)v.get(85)).setAttribute("valorinicial","" );
      ((Element)v.get(85)).setAttribute("textoinicial","" );
      ((Element)v.get(85)).setAttribute("id","datosCampos" );
      ((Element)v.get(85)).setAttribute("ontab","botonBuscar();" );
      ((Element)v.get(85)).setAttribute("onshtab","comboSubProcesos();" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:87 / Elemento padre: 81   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).setAttribute("width","100%" );
      ((Element)v.get(81)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(88)).setAttribute("src","b.gif" );
      ((Element)v.get(88)).setAttribute("width","8" );
      ((Element)v.get(88)).setAttribute("height","8" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */
      /* Termina nodo:81   */

      /* Empieza nodo:89 / Elemento padre: 73   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(73)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).setAttribute("colspan","4" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(91)).setAttribute("src","b.gif" );
      ((Element)v.get(91)).setAttribute("width","8" );
      ((Element)v.get(91)).setAttribute("height","8" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:89   */
      /* Termina nodo:73   */
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:37   */
      /* Termina nodo:34   */
      /* Termina nodo:33   */

      /* Empieza nodo:92 / Elemento padre: 30   */
      v.add(doc.createElement("td"));
      ((Element)v.get(30)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","b.gif" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:30   */

      /* Empieza nodo:94 / Elemento padre: 22   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(22)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(96)).setAttribute("src","b.gif" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:97 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("table"));
      ((Element)v.get(99)).setAttribute("width","100%" );
      ((Element)v.get(99)).setAttribute("border","0" );
      ((Element)v.get(99)).setAttribute("align","center" );
      ((Element)v.get(99)).setAttribute("cellspacing","0" );
      ((Element)v.get(99)).setAttribute("cellpadding","0" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(101)).setAttribute("class","botonera" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(102)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(102)).setAttribute("ID","botonContenido" );
      ((Element)v.get(102)).setAttribute("tipo","html" );
      ((Element)v.get(102)).setAttribute("accion","accionBuscar();" );
      ((Element)v.get(102)).setAttribute("estado","false" );
      ((Element)v.get(102)).setAttribute("cod","1" );
      ((Element)v.get(102)).setAttribute("ontab","botonLista();" );
      ((Element)v.get(102)).setAttribute("onshtab","comboTipo();" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:103 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(104)).setAttribute("width","8" );
      ((Element)v.get(104)).setAttribute("height","12" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */
      /* Termina nodo:94   */

      /* Empieza nodo:105 / Elemento padre: 22   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(22)).appendChild((Element)v.get(105));

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
      /* Termina nodo:22   */

      /* Empieza nodo:112 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(112)).setAttribute("nombre","listado1" );
      ((Element)v.get(112)).setAttribute("ancho","530" );
      ((Element)v.get(112)).setAttribute("alto","317" );
      ((Element)v.get(112)).setAttribute("x","12" );
      ((Element)v.get(112)).setAttribute("y","162" );
      ((Element)v.get(112)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(112)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(112));

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
   }

   private void getXML450(Document doc) {
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
      ((Element)v.get(118)).setAttribute("vertical","0" );
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
      ((Element)v.get(120)).setAttribute("cod","00135" );
      ((Element)v.get(120)).setAttribute("ID","datosTitle" );
      ((Element)v.get(112)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */

      /* Empieza nodo:121 / Elemento padre: 112   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(121)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(121)).setAttribute("alto","22" );
      ((Element)v.get(121)).setAttribute("imgFondo","" );
      ((Element)v.get(112)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */

      /* Empieza nodo:122 / Elemento padre: 112   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(122)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(122)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(122)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(122)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(122)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(122)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(112)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(123)).setAttribute("ancho","50" );
      ((Element)v.get(123)).setAttribute("minimizable","S" );
      ((Element)v.get(123)).setAttribute("minimizada","N" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */

      /* Empieza nodo:124 / Elemento padre: 122   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(124)).setAttribute("ancho","48" );
      ((Element)v.get(124)).setAttribute("minimizable","S" );
      ((Element)v.get(124)).setAttribute("minimizada","N" );
      ((Element)v.get(122)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */

      /* Empieza nodo:125 / Elemento padre: 122   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(125)).setAttribute("ancho","100" );
      ((Element)v.get(125)).setAttribute("minimizable","S" );
      ((Element)v.get(125)).setAttribute("minimizada","N" );
      ((Element)v.get(122)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */

      /* Empieza nodo:126 / Elemento padre: 122   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(126)).setAttribute("ancho","50" );
      ((Element)v.get(126)).setAttribute("minimizable","S" );
      ((Element)v.get(126)).setAttribute("minimizada","N" );
      ((Element)v.get(122)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:122   */

      /* Empieza nodo:127 / Elemento padre: 112   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(127)).setAttribute("alto","20" );
      ((Element)v.get(127)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(127)).setAttribute("imgFondo","" );
      ((Element)v.get(127)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(112)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(128)).setAttribute("colFondo","" );
      ((Element)v.get(128)).setAttribute("ID","EstCab" );
      ((Element)v.get(128)).setAttribute("cod","689" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */

      /* Empieza nodo:129 / Elemento padre: 127   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(129)).setAttribute("colFondo","" );
      ((Element)v.get(129)).setAttribute("ID","EstCab" );
      ((Element)v.get(129)).setAttribute("cod","696" );
      ((Element)v.get(127)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */

      /* Empieza nodo:130 / Elemento padre: 127   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(130)).setAttribute("colFondo","" );
      ((Element)v.get(130)).setAttribute("ID","EstCab" );
      ((Element)v.get(130)).setAttribute("cod","1357" );
      ((Element)v.get(127)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */

      /* Empieza nodo:131 / Elemento padre: 127   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(131)).setAttribute("colFondo","" );
      ((Element)v.get(131)).setAttribute("ID","EstCab" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(131)).setAttribute("cod","169" );
      ((Element)v.get(127)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:127   */

      /* Empieza nodo:132 / Elemento padre: 112   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(132)).setAttribute("alto","22" );
      ((Element)v.get(132)).setAttribute("accion","" );
      ((Element)v.get(132)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(132)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(132)).setAttribute("maxSel","1" );
      ((Element)v.get(132)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(132)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(132)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(132)).setAttribute("onLoad","" );
      ((Element)v.get(132)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(112)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(133)).setAttribute("tipo","texto" );
      ((Element)v.get(133)).setAttribute("ID","EstDat" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */

      /* Empieza nodo:134 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(134)).setAttribute("tipo","texto" );
      ((Element)v.get(134)).setAttribute("ID","EstDat2" );
      ((Element)v.get(132)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */

      /* Empieza nodo:135 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(135)).setAttribute("tipo","texto" );
      ((Element)v.get(135)).setAttribute("ID","EstDat" );
      ((Element)v.get(132)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */

      /* Empieza nodo:136 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(136)).setAttribute("tipo","texto" );
      ((Element)v.get(136)).setAttribute("ID","EstDat2" );
      ((Element)v.get(132)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:132   */

      /* Empieza nodo:137 / Elemento padre: 112   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(112)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */

      /* Empieza nodo:138 / Elemento padre: 112   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(138)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(138)).setAttribute("ancho","530" );
      ((Element)v.get(138)).setAttribute("sep","$" );
      ((Element)v.get(138)).setAttribute("x","12" );
      ((Element)v.get(138)).setAttribute("class","botonera" );
      ((Element)v.get(138)).setAttribute("y","456" );
      ((Element)v.get(138)).setAttribute("control","" );
      ((Element)v.get(138)).setAttribute("conector","" );
      ((Element)v.get(138)).setAttribute("rowset","" );
      ((Element)v.get(138)).setAttribute("cargainicial","N" );
      ((Element)v.get(138)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(112)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(139)).setAttribute("nombre","ret1" );
      ((Element)v.get(139)).setAttribute("x","37" );
      ((Element)v.get(139)).setAttribute("y","460" );
      ((Element)v.get(139)).setAttribute("ID","botonContenido" );
      ((Element)v.get(139)).setAttribute("img","retroceder_on" );
      ((Element)v.get(139)).setAttribute("tipo","0" );
      ((Element)v.get(139)).setAttribute("estado","false" );
      ((Element)v.get(139)).setAttribute("alt","" );
      ((Element)v.get(139)).setAttribute("codigo","" );
      ((Element)v.get(139)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */

      /* Empieza nodo:140 / Elemento padre: 138   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(140)).setAttribute("nombre","ava1" );
      ((Element)v.get(140)).setAttribute("x","52" );
      ((Element)v.get(140)).setAttribute("y","460" );
      ((Element)v.get(140)).setAttribute("ID","botonContenido" );
      ((Element)v.get(140)).setAttribute("img","avanzar_on" );
      ((Element)v.get(140)).setAttribute("tipo","0" );
      ((Element)v.get(140)).setAttribute("estado","false" );
      ((Element)v.get(140)).setAttribute("alt","" );
      ((Element)v.get(140)).setAttribute("codigo","" );
      ((Element)v.get(140)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(138)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:138   */
      /* Termina nodo:112   */

      /* Empieza nodo:141 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(141)).setAttribute("nombre","primera1" );
      ((Element)v.get(141)).setAttribute("x","20" );
      ((Element)v.get(141)).setAttribute("y","460" );
      ((Element)v.get(141)).setAttribute("ID","botonContenido" );
      ((Element)v.get(141)).setAttribute("img","primera_on" );
      ((Element)v.get(141)).setAttribute("tipo","-2" );
      ((Element)v.get(141)).setAttribute("estado","false" );
      ((Element)v.get(141)).setAttribute("alt","" );
      ((Element)v.get(141)).setAttribute("codigo","" );
      ((Element)v.get(141)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(6)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */

      /* Empieza nodo:142 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(142)).setAttribute("nombre","separa" );
      ((Element)v.get(142)).setAttribute("x","59" );
      ((Element)v.get(142)).setAttribute("y","456" );
      ((Element)v.get(142)).setAttribute("ID","botonContenido" );
      ((Element)v.get(142)).setAttribute("img","separa_base" );
      ((Element)v.get(142)).setAttribute("tipo","0" );
      ((Element)v.get(142)).setAttribute("estado","false" );
      ((Element)v.get(142)).setAttribute("alt","" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(142)).setAttribute("codigo","" );
      ((Element)v.get(142)).setAttribute("accion","" );
      ((Element)v.get(6)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */

      /* Empieza nodo:143 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(143)).setAttribute("nombre","Modificar" );
      ((Element)v.get(143)).setAttribute("x","80" );
      ((Element)v.get(143)).setAttribute("y","457" );
      ((Element)v.get(143)).setAttribute("ID","botonContenido" );
      ((Element)v.get(143)).setAttribute("img","" );
      ((Element)v.get(143)).setAttribute("tipo","html" );
      ((Element)v.get(143)).setAttribute("estado","false" );
      ((Element)v.get(143)).setAttribute("alt","" );
      ((Element)v.get(143)).setAttribute("cod","2" );
      ((Element)v.get(143)).setAttribute("accion","accionModificar();" );
      ((Element)v.get(143)).setAttribute("ontab","comboProceso();" );
      ((Element)v.get(143)).setAttribute("onshtab","botonBuscar();" );
      ((Element)v.get(6)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */

      /* Empieza nodo:144 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(144)).setAttribute("nombre","Detalle" );
      ((Element)v.get(144)).setAttribute("x","80" );
      ((Element)v.get(144)).setAttribute("y","457" );
      ((Element)v.get(144)).setAttribute("ID","botonContenido" );
      ((Element)v.get(144)).setAttribute("img","" );
      ((Element)v.get(144)).setAttribute("tipo","html" );
      ((Element)v.get(144)).setAttribute("estado","false" );
      ((Element)v.get(144)).setAttribute("alt","" );
      ((Element)v.get(144)).setAttribute("cod","3" );
      ((Element)v.get(144)).setAttribute("accion","accionVerDetalle();" );
      ((Element)v.get(144)).setAttribute("ontab","comboProceso();" );
      ((Element)v.get(144)).setAttribute("onshtab","botonBuscar();" );
      ((Element)v.get(6)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */

      /* Empieza nodo:145 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(145)).setAttribute("nombre","DetalleElimina" );
      ((Element)v.get(145)).setAttribute("x","80" );
      ((Element)v.get(145)).setAttribute("y","457" );
      ((Element)v.get(145)).setAttribute("ID","botonContenido" );
      ((Element)v.get(145)).setAttribute("img","" );
      ((Element)v.get(145)).setAttribute("tipo","html" );
      ((Element)v.get(145)).setAttribute("estado","false" );
      ((Element)v.get(145)).setAttribute("alt","" );
      ((Element)v.get(145)).setAttribute("cod","3" );
      ((Element)v.get(145)).setAttribute("accion","accionEliminar();" );
      ((Element)v.get(145)).setAttribute("ontab","comboProceso();" );
      ((Element)v.get(145)).setAttribute("onshtab","botonBuscar();" );
      ((Element)v.get(6)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */

      /* Empieza nodo:146 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(146)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(146)).setAttribute("alto","12" );
      ((Element)v.get(146)).setAttribute("ancho","100%" );
      ((Element)v.get(146)).setAttribute("colorf","" );
      ((Element)v.get(146)).setAttribute("borde","0" );
      ((Element)v.get(146)).setAttribute("imagenf","" );
      ((Element)v.get(146)).setAttribute("repeat","" );
      ((Element)v.get(146)).setAttribute("padding","" );
      ((Element)v.get(146)).setAttribute("visibilidad","visible" );
      ((Element)v.get(146)).setAttribute("contravsb","" );
      ((Element)v.get(146)).setAttribute("x","0" );
      ((Element)v.get(146)).setAttribute("y","479" );
      ((Element)v.get(146)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:6   */


   }

}
