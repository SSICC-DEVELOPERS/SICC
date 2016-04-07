
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_ejecutivos_cuenta_insertar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_ejecutivos_cuenta_insertar" );
      ((Element)v.get(0)).setAttribute("titulo","Insertar ejecutivos de cuenta" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Insertar parámetros de cartera" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Empieza nodo:2 / Elemento padre: 1   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(2)).setAttribute("name","cbEjecutivoCuenta" );
      ((Element)v.get(2)).setAttribute("required","true" );
      ((Element)v.get(2)).setAttribute("cod","854" );
      ((Element)v.get(1)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 1   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(3)).setAttribute("name","cbMarca" );
      ((Element)v.get(3)).setAttribute("required","true" );
      ((Element)v.get(3)).setAttribute("cod","6" );
      ((Element)v.get(1)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 1   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(4)).setAttribute("name","cbCanal" );
      ((Element)v.get(4)).setAttribute("required","true" );
      ((Element)v.get(4)).setAttribute("cod","7" );
      ((Element)v.get(1)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 1   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(5)).setAttribute("name","cbSubgerenciaVentas" );
      ((Element)v.get(5)).setAttribute("required","true" );
      ((Element)v.get(5)).setAttribute("cod","124" );
      ((Element)v.get(1)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 1   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(6)).setAttribute("name","cbNivelRiesgo" );
      ((Element)v.get(6)).setAttribute("required","true" );
      ((Element)v.get(6)).setAttribute("cod","928" );
      ((Element)v.get(1)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */
      /* Termina nodo:1   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(7));

      /* Elemento padre:7 / Elemento actual: 8   */
      v.add(doc.createTextNode("\r   \r\r    var comboSGV;\r    var comboRegion;\r    var comboZona;\r\r    var oidAsignacion;\r    var strEjecutivoCuenta;\r    var oidEjecutivoCuenta;\r    var strMarca;\r    var oidMarca;\r    var strCanal;\r    var oidCanal;\r    var strSubgerenciasVentas;\r    var oidSubgerenciasVentas;\r    var strRegion;\r    var oidRegion;\r    var strZona;\r    var oidZona;\r    var strNivelRiesgo;\r    var oidNivelRiesgo;\r\r  function obtieneValoresSGV(){\r    var cantElems = combo_get(\"frmInsertarCartera.cbSubgerenciaVentas\", \"L\", \"\");\r    var oids = new Array();\r\r    for (var i = 0; i < cantElems; i++)	{\r      var oid = combo_get(\"frmInsertarCartera.cbSubgerenciaVentas\", \"V\", i);\r      var desc = combo_get(\"frmInsertarCartera.cbSubgerenciaVentas\", \"T\", i);\r      if ( oid != \"\")		{\r        var array = new Array(oid, desc);\r        oids[oids.length] = array;\r      }\r    }\r    return oids;\r  }\r\r  function obtieneValoresRegion(){\r  \r    var cantElems = combo_get(\"frmInsertarCartera.cbRegion\", \"L\", \"\");\r    var oids = new Array();\r\r    for (var i = 0; i < cantElems; i++)	{\r      var oid = combo_get(\"frmInsertarCartera.cbRegion\", \"V\", i);\r      var desc = combo_get(\"frmInsertarCartera.cbRegion\", \"T\", i);\r      if ( oid != \"\")		{\r        var array = new Array(oid, desc);\r        oids[oids.length] = array;\r      }\r    }\r    return oids;\r  }  \r\r  function obtieneValoresZona(){\r	\r\r	var cantElems = combo_get(\"frmInsertarCartera.cbZona\", \"L\", \"\");\r    var oids = new Array();\r\r    for (var i = 0; i < cantElems; i++)	{\r      var oid = combo_get(\"frmInsertarCartera.cbZona\", \"V\", i);\r      var desc = combo_get(\"frmInsertarCartera.cbZona\", \"T\", i);\r      if ( oid != \"\")		{\r        var array = new Array(oid, desc);\r        oids[oids.length] = array;\r      }\r    }\r    return oids;\r  }  \r\r  function agregaEspacioBlanco(array) {\r    var nuevoArray = new Array();\r    nuevoArray[0] = [\"\", \"\"];\r\r    for (var i = 0; i < array.length; i++) {\r      nuevoArray[i+1] = array[i];\r    }\r    return nuevoArray;\r  }\r\r  function onLoadPag()   {\r    configurarMenuSecundario('frmInsertarCartera');  \r    \r    DrdEnsanchaConMargenDcho('listado1',12);\r\r    document.all[\"Cplistado1\"].style.visibility='';\r    document.all[\"CpLin1listado1\"].style.visibility='';\r    document.all[\"CpLin2listado1\"].style.visibility='';\r    document.all[\"CpLin3listado1\"].style.visibility='';\r    document.all[\"CpLin4listado1\"].style.visibility='';\r\r    document.all[\"primera1Div\"].style.visibility='';\r    document.all[\"ret1Div\"].style.visibility='';\r    document.all[\"ava1Div\"].style.visibility='';\r    document.all[\"separaDiv\"].style.visibility='';\r\r    btnProxy(4, 0);\r	var caso = get('frmInsertarCartera.casoDeUso');\r	\r\r    if (get('frmInsertarCartera.casoDeUso') == 'modificarInsert'){\r        		\r		var iSeleccionado  = new Array();         \r		iSeleccionado[0]   = get('frmInsertarCartera.oidEjecutivo'); \r		set('frmInsertarCartera.cbEjecutivoCuenta',iSeleccionado);\r	\r		accion('frmInsertarCartera.cbEjecutivoCuenta','.disabled=true');\r        \r		cargarAsignaciones();\r\r		for(var i=0; i <5; i++) {\r          focaliza('frmInsertarCartera.cbMarca');\r        }\r		\r    }else if (get('frmInsertarCartera.casoDeUso') == 'consultarInsert' ||\r              get('frmInsertarCartera.casoDeUso') == 'eliminarInsert'){\r				\r		var iSeleccionado = new Array();         \r		iSeleccionado[0] = get('frmInsertarCartera.oidEjecutivo'); \r		set('frmInsertarCartera.cbEjecutivoCuenta',iSeleccionado);\r		\r		accion('frmInsertarCartera.cbEjecutivoCuenta','.disabled=true');\r        accion('frmInsertarCartera.cbMarca','.disabled=true');\r        accion('frmInsertarCartera.cbCanal','.disabled=true');\r        accion('frmInsertarCartera.cbSubgerenciaVentas','.disabled=true');\r        accion('frmInsertarCartera.cbRegion','.disabled=true');\r        accion('frmInsertarCartera.cbZona','.disabled=true');\r        accion('frmInsertarCartera.cbNivelRiesgo','.disabled=true');\r\r        deshabilitarHabilitarBoton('botonContenido','btnAnadir','D');\r        deshabilitarHabilitarBoton('botonContenido','btnModificar','D');\r        \r        cargarAsignaciones();\r    }\r\r    eval (ON_RSZ);\r\r    if (get('frmInsertarCartera.focoUltimo') == 'true'){\r      focalizaBotonHTML_XY('btnModificar');      \r    }    \r    else {\r      if(document.getElementById('cbEjecutivoCuenta').disabled!=true) {\r        focaliza('frmInsertarCartera.cbEjecutivoCuenta','');\r      }         \r    }\r		\r    var marca = get('frmInsertarCartera.marcaDefecto');\r    var canal = get('frmInsertarCartera.canalDefecto'); \r    var sgv = get('frmInsertarCartera.sgvDefecto');\r    var region = get('frmInsertarCartera.regionDefecto');\r    var zona = get('frmInsertarCartera.zonaDefecto');  \r\r	set('frmInsertarCartera.cbMarca', new Array(marca));\r    set('frmInsertarCartera.cbCanal', new Array(canal));\r    set('frmInsertarCartera.cbSubgerenciaVentas', new Array(sgv));\r    set('frmInsertarCartera.cbRegion', new Array(region));\r    set('frmInsertarCartera.cbZona', new Array(zona));   \r\r    comboSGV = obtieneValoresSGV();      \r    comboRegion = obtieneValoresRegion();\r    comboZona = obtieneValoresZona();\r  }\r\r    function aniadirFila() {\r        var oidASIGN = get('frmInsertarCartera.hOidAsigna');\r\r        if ( validarCamposInsercionLista()){\r           var vOidNivel = get('frmInsertarCartera.cbNivelRiesgo');\r           \r			     if ( !((vOidNivel.length > 1) && (oidASIGN != ''))){\r				      var ejecutivoCuenta = document.getElementById('cbEjecutivoCuenta');\r				      var marca = document.getElementById('cbMarca');\r				      var canal = document.getElementById('cbCanal');\r				      var subgerenciasVentas = document.getElementById('cbSubgerenciaVentas');					  		\r					  var region = document.getElementById('cbRegion');\r				      var zona = document.getElementById('cbZona');\r				      var nivelRiesgo = document.getElementById('cbNivelRiesgo');\r\r              strEjecutivoCuenta = ejecutivoCuenta.options[ejecutivoCuenta.selectedIndex].text;\r              oidEjecutivoCuenta = ejecutivoCuenta.options[ejecutivoCuenta.selectedIndex].value;\r              strMarca = marca.options[marca.selectedIndex].text;\r              oidMarca = marca.options[marca.selectedIndex].value;\r              strCanal = canal.options[canal.selectedIndex].text;\r              oidCanal = canal.options[canal.selectedIndex].value;\r              strSubgerenciasVentas = subgerenciasVentas.options[subgerenciasVentas.selectedIndex].text;\r              oidSubgerenciasVentas = subgerenciasVentas.options[subgerenciasVentas.selectedIndex].value;\r              \r   	      strRegion             = '';\r      	      oidRegion             = '';\r  	      strZona               = '';\r 	      oidZona               = '';\r\r	      if (region.selectedIndex != -1){\r     	         strRegion             = region.options[region.selectedIndex].text;\r       	         oidRegion             = region.options[region.selectedIndex].value;				\r	      }\r\r	      if (zona.selectedIndex != -1){\r		  strZona               = zona.options[zona.selectedIndex].text;\r		  oidZona               = zona.options[zona.selectedIndex].value;	\r	      }\r\r              if (oidASIGN != ''){\r                 \r                 strNivelRiesgo = nivelRiesgo.options[nivelRiesgo.selectedIndex].text;\r                 oidNivelRiesgo = nivelRiesgo.options[nivelRiesgo.selectedIndex].value;\r					       modificarFilaListado(oidASIGN);\r					       set('frmInsertarCartera.hOidAsigna','');\r				      }else{\r                 for(var i=0; i <vOidNivel.length; i++){\r                    var newRow = new Array();\r                    newRow[newRow.length] = listado1.generaCodigo();\r\r                    for(var x=0; x < nivelRiesgo.length; x++){\r                       if(vOidNivel[i] == nivelRiesgo.options[x].value){\r                          strNivelRiesgo = nivelRiesgo.options[x].text;\r                          oidNivelRiesgo = nivelRiesgo.options[x].value;\r                          agregarALlistado(newRow);\r                        }\r                    }\r       \r                 }\r				      }			\r			     }else{\r              GestionarMensaje('CAR002');\r           }\r        }\r    }\r\r    function modificarFilaListado(oidASIGN){\r                        listado1.insertaDato(oidASIGN,1,strEjecutivoCuenta);\r        listado1.insertaDato(oidASIGN,2,strMarca);\r        listado1.insertaDato(oidASIGN,3,strCanal);\r        listado1.insertaDato(oidASIGN,4,strSubgerenciasVentas);\r        listado1.insertaDato(oidASIGN,5,strRegion);\r        listado1.insertaDato(oidASIGN,6,strZona);\r        listado1.insertaDato(oidASIGN,7,strNivelRiesgo);\r        listado1.insertaDato(oidASIGN,8,oidEjecutivoCuenta);\r        listado1.insertaDato(oidASIGN,9,oidMarca);\r        listado1.insertaDato(oidASIGN,10,oidCanal);\r        listado1.insertaDato(oidASIGN,11,oidSubgerenciasVentas);\r        listado1.insertaDato(oidASIGN,12,oidRegion);\r        listado1.insertaDato(oidASIGN,13,oidZona);\r        listado1.insertaDato(oidASIGN,14,oidNivelRiesgo);\r    }\r\r    function agregarALlistado(newRow){\r\r            newRow[newRow.length] = \"\";\r            newRow[newRow.length] = strEjecutivoCuenta;\r            newRow[newRow.length] = strMarca ;\r            newRow[newRow.length] = strCanal ;\r            newRow[newRow.length] = strSubgerenciasVentas ;\r            newRow[newRow.length] = strRegion ;\r            newRow[newRow.length] = strZona ;       \r            newRow[newRow.length] = strNivelRiesgo ;\r            newRow[newRow.length] = oidEjecutivoCuenta ;\r            newRow[newRow.length] = oidMarca;\r            newRow[newRow.length] = oidCanal ;\r            newRow[newRow.length] = oidSubgerenciasVentas ;\r            newRow[newRow.length] = oidRegion ;\r            newRow[newRow.length] = oidZona ;       \r            newRow[newRow.length] = oidNivelRiesgo ;\r\r            listado1.insertar(newRow);\r            listado1.repinta();\r    }\r\r    function cargarAsignaciones(){\r        var asignaciones = get('frmInsertarCartera.asignaciones');\r        var arra = asignaciones.split('|');\r\r        for (var i=0;i<arra.length-1 ;i++)  {\r            var asign = arra[i].split(',');\r            var newRow = new Array();\r\r            oidAsignacion = asign[0];\r            strEjecutivoCuenta = asign[1];\r            oidEjecutivoCuenta = asign[8];\r            strMarca = asign[2];\r            oidMarca = asign[9];\r            strCanal = asign[3];\r            oidCanal = asign[10];\r            strSubgerenciasVentas = asign[4];\r            oidSubgerenciasVentas = asign[11];\r            strRegion = asign[5];\r            oidRegion = asign[12];\r            strZona = asign[6];\r            oidZona = asign[13];\r            strNivelRiesgo = asign[7];\r            oidNivelRiesgo = asign[14];\r            newRow[newRow.length] = oidAsignacion;\r            agregarALlistado(newRow);\r        }\r        \r    }\r\r    function modificarFila(){\r\r		if (listado1.numSelecc() == 0) {\r		                  GestionarMensaje('50');\r		}\r		if (listado1.numSelecc() > 1 ) {\r		       		       GestionarMensaje('8');\r		       deseleccionaListado();\r		}\r		if(listado1.numSelecc()== 1){\r            var iSeleccionado = new Array(); \r            var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);\r\r            var oidEjec = listado1.datos[posicion][9];\r            var oidNiv = listado1.datos[posicion][15];\r\r            iSeleccionado[0] = oidEjec ;\r            set('frmInsertarCartera.cbEjecutivoCuenta',iSeleccionado);\r            iSeleccionado[0] = oidNiv;\r            set('frmInsertarCartera.cbNivelRiesgo',iSeleccionado);\r\r            var oidAsign = listado1.codSeleccionados();\r\r            cargarCamposPantalla(posicion);\r\r            set('frmInsertarCartera.hOidAsigna',oidAsign);\r        }else{\r            GestionarMensaje(\"4\");\r        }\r    }\r\r\r\r    function cargarCamposPantalla( posicion ){\r\r        var iSeleccionado = new Array(); \r        var oidMar = listado1.datos[posicion][10];\r        var oidCanal = listado1.datos[posicion][11];\r\r        iSeleccionado[0] = oidMar ;\r        set('frmInsertarCartera.cbMarca',iSeleccionado);\r        iSeleccionado[0] = oidCanal ;\r        set('frmInsertarCartera.cbCanal',iSeleccionado);\r\r		asignar([['COMBO','frmInsertarCartera.cbSubgerenciaVentas',\r                          'ConectorDruidaTransactionQuery',\r                          'dtoSalida.resultado_ROWSET',\r                          formarCadenaDT('ZONRecargaSubgerenciaVentas', \r                            'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', \r                            MakeParametersSG()), \r						  'recargarSubgerencia(datos);']]);	\r    }\r\r    function MakeParametersSG(){\r        var arr = new Array();\r        arr[arr.length] = new Array(\"oidPais\", get('frmInsertarCartera.hPais'));\r        arr[arr.length] = new Array(\"oidMarca\", get('frmInsertarCartera.cbMarca'));\r        arr[arr.length] = new Array(\"oidCanal\", get('frmInsertarCartera.cbCanal'));\r        return arr;\r    }\r\r    function MakeParametersRG(){\r        var arr = new Array();\r        arr[arr.length] = new Array(\"oidSGV\", get('frmInsertarCartera.cbSubgerenciaVentas'));\r        return arr;\r    }\r\r    function MakeParametersZN(){\r        var arr = new Array();\r        arr[arr.length] = new Array(\"oidRegion\", get('frmInsertarCartera.cbRegion'));\r        return arr;    \r    }\r\r    function recargarSubgerencia(datos){\r\r        var  arr = new Array();\r\r        arr[arr.length] = new Array([''],['']);\r        for (var i=0 ;i< datos.length ; i++)  {\r            arr[arr.length] = datos[i];\r        }\r\r        set_combo('frmInsertarCartera.cbSubgerenciaVentas',arr);\r\r\r        var iSeleccionado = new Array(); \r        var oidSubGer = listado1.datos[posicion][12];\r        iSeleccionado[0] = oidSubGer ;\r\r        set('frmInsertarCartera.cbSubgerenciaVentas',iSeleccionado);\r\r         asignar([['COMBO','frmInsertarCartera.cbRegion',\r                          'ConectorDruidaTransactionQuery',\r                          'dtoSalida.resultado_ROWSET',\r                          formarCadenaDT('ZONRecargaRegiones', \r                            'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', \r                            MakeParametersRG()), \r						  'recargarRegion(datos);']]);	\r\r                          \r    }\r\r    function recargarRegion(datos){\r\r        var  arr = new Array();\r\r        arr[arr.length] = new Array([''],['']);\r        for (var i=0 ;i< datos.length ; i++)  {\r            arr[arr.length] = datos[i];\r        }\r\r        set_combo('frmInsertarCartera.cbRegion',arr);\r        \r        var iSeleccionado = new Array(); \r        var oidReg = listado1.datos[posicion][13];\r\r        iSeleccionado[0] = oidReg;\r        set('frmInsertarCartera.cbRegion',iSeleccionado); \r\r        asignar([['COMBO','frmInsertarCartera.cbZona',\r                          'ConectorDruidaTransactionQuery',\r                          'dtoSalida.resultado_ROWSET',\r                          formarCadenaDT('ZONRecargaZonas', \r                            'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', \r                            MakeParametersZN()), \r						  'recargarZona(datos);']]);	\r        \r    }\r\r    function recargarZona(datos){\r\r        var  arr = new Array();\r\r        arr[arr.length] = new Array([''],['']);\r        for (var i=0 ;i< datos.length ; i++)  {\r            arr[arr.length] = datos[i];\r        }\r\r        set_combo('frmInsertarCartera.cbZona',arr);\r        \r        var iSeleccionado = new Array(); \r        var oidZon = listado1.datos[posicion][14];\r        iSeleccionado[0] = oidZon;\r        set('frmInsertarCartera.cbZona',iSeleccionado);\r    }\r    \r    function obtenerPosicionListaEditable(clave, lista){\r          this.posicion = 0;\r          if (lista.codSeleccionados().length > 0){\r              for(var k=0;k<lista.datos.length;k++) {\r                     if (lista.datos[k][0] == clave) {\r                        posicion=k;\r                        break;\r                     }\r                            }          \r                     return posicion;\r                  }\r    }\r    \r    function fGuardar(){\r        if (listado1.datos.length >= 1)  {\r            var strListado = obtenerListado();\r            set('frmInsertarCartera.hListado', strListado);\r\r            var list = get('frmInsertarCartera.hListado');\r            set('frmInsertarCartera.accion','guardarAsignaciones');\r            eval('frmInsertarCartera').oculto = 'S';\r            enviaSICC('frmInsertarCartera','','','N');       \r        }        \r    }\r\r    function fLimpiar(){\r        if (get('frmInsertarCartera.casoDeUso') == 'modificarInsert'){\r            var iSeleccionado = new Array(); \r            iSeleccionado[0] = get('frmInsertarCartera.oidEjecutivo'); \r            set('frmInsertarCartera.cbEjecutivoCuenta',iSeleccionado);\r            listado1.setDatos(new Array());\r            cargarAsignaciones();\r        }      \r\r        var nuevoSGV = agregaEspacioBlanco(comboSGV);\r        var nuevoRegion = agregaEspacioBlanco(comboRegion);\r        var nuevoZona = agregaEspacioBlanco(comboZona);      \r\r        set_combo('frmInsertarCartera.cbSubgerenciaVentas',nuevoSGV, []);\r        set_combo('frmInsertarCartera.cbRegion',nuevoRegion, []);\r        set_combo('frmInsertarCartera.cbZona',nuevoZona, []);\r\r        var marca = get('frmInsertarCartera.marcaDefecto');\r        var canal = get('frmInsertarCartera.canalDefecto'); \r        var sgv = get('frmInsertarCartera.sgvDefecto');\r        var region = get('frmInsertarCartera.regionDefecto');\r        var zona = get('frmInsertarCartera.zonaDefecto');         \r\r        set('frmInsertarCartera.cbMarca', new Array(marca));\r        set('frmInsertarCartera.cbCanal', new Array(canal));\r        set('frmInsertarCartera.cbSubgerenciaVentas', new Array(sgv));\r        set('frmInsertarCartera.cbRegion', new Array(region));\r        set('frmInsertarCartera.cbZona', new Array(zona));\r        \r        focaliza('frmInsertarCartera.cbEjecutivoCuenta','');\r    }\r\r    function fBorrar(){\r        if (listado1.numSelecc() >= 1)  {\r             listado1.eliminarSelecc();	                \r        }else{\r            GestionarMensaje(\"4\");\r        }\r    }\r\r    function guardoCorrectamente(){\r        \r        if (get('frmInsertarCartera.casoDeUso') == 'modificarInsert'){\r            this.close();\r        }else{\r          eval('frmInsertarCartera').oculto = 'N';\r          listado1.setDatos(new Array());\r         \r          fLimpiar();\r          set('frmInsertarCartera.cbEjecutivoCuenta', '');\r          set('frmInsertarCartera.cbNivelRiesgo', '');\r          focaliza('frmInsertarCartera.cbEjecutivoCuenta','');\r        }\r        \r                                       \r                                        \r    }\r\r    function noPudoGuardar(){\r        eval('frmInsertarCartera').oculto = 'N';\r        focaliza('frmInsertarCartera.cbEjecutivoCuenta','');\r    }\r\r    function obtenerListado(){\r        var cantidad = listado1.codigos().length;\r        var toAdd = \"\";\r        var codigo = \"\";\r\r\r        codigo = listado1.codigos();\r        for (var i=0; i< cantidad; i++)  {\r            toAdd = toAdd + \"#\" + codigo[i];\r            toAdd = toAdd + \"|\" + listado1.extraeDato(codigo[i], 8);\r            toAdd = toAdd + \"|\" + listado1.extraeDato(codigo[i], 9);\r            toAdd = toAdd + \"|\" + listado1.extraeDato(codigo[i], 10);            \r            toAdd = toAdd + \"|\" + listado1.extraeDato(codigo[i], 11);\r\r	    if (cdos_trim(listado1.extraeDato(codigo[i], 12)).length == 0) {\r	        toAdd = toAdd + \"|\" + '_'\r	    }else{\r	        toAdd = toAdd + \"|\" + listado1.extraeDato(codigo[i], 12);			\r	    }\r\r	    if (cdos_trim(listado1.extraeDato(codigo[i], 13)).length == 0) {\r	        toAdd = toAdd + \"|\" + '_'\r	    }else{\r                toAdd = toAdd + \"|\" + listado1.extraeDato(codigo[i], 13);	        \r	    }\r\r            toAdd = toAdd + \"|\" + listado1.extraeDato(codigo[i], 14);\r\r        }\r\r        return toAdd;\r    }\r\r    function pestaniaEjecutivo(){\r            set('frmInsertarCartera.casoDeUso', get('frmInsertarCartera.casoDeUso'));\r            set('frmInsertarCartera.accion','inserta');\r            eval('frmInsertarCartera').oculto = 'N';\r            enviaSICC('frmInsertarCartera','','','N');\r    }\r\r     function validarCamposInsercionLista(){\r           if(!sicc_validaciones_generales()){\r              return false;\r           }else{\r              return true;\r           }\r        }\r\r    function onchange_Canal(){\r        var arr = new Array();\r        vaciarCbSubgerencia();\r\r        if ((get('frmInsertarCartera.cbMarca') != '') || (get('frmInsertarCartera.cbCanal') != '')){\r            arr[arr.length] = new Array(\"oidPais\", get('frmInsertarCartera.hPais'));\r            if (get('frmInsertarCartera.cbMarca') != \"\")\r                arr[arr.length] = new Array(\"oidMarca\", get('frmInsertarCartera.cbMarca'));\r            if (get('frmInsertarCartera.cbCanal') != \"\")\r                arr[arr.length] = new Array(\"oidCanal\", get('frmInsertarCartera.cbCanal'));\r            recargaCombo('frmInsertarCartera.cbSubgerenciaVentas','ZONRecargaSubgerenciaVentas','es.indra.sicc.dtos.zon.DTOUnidadAdministrativa',arr);        \r        }\r    }\r\r    function onchange_Marca(){\r        var arr = new Array();\r\r        vaciarCbSubgerencia();\r        if ((get('frmInsertarCartera.cbMarca') != '') || (get('frmInsertarCartera.cbCanal') != '')){\r            arr[arr.length] = new Array(\"oidPais\", get('frmInsertarCartera.hPais'));\r            if (get('frmInsertarCartera.cbMarca') != \"\")\r                arr[arr.length] = new Array(\"oidMarca\", get('frmInsertarCartera.cbMarca'));\r            if (get('frmInsertarCartera.cbCanal') != \"\")\r                arr[arr.length] = new Array(\"oidCanal\", get('frmInsertarCartera.cbCanal'));\r            recargaCombo('frmInsertarCartera.cbSubgerenciaVentas','ZONRecargaSubgerenciaVentas','es.indra.sicc.dtos.zon.DTOUnidadAdministrativa',arr);\r        }\r    }\r\r    function onchange_Subgerencia(){\r        var arr = new Array();\r        vaciarCbRegion();\r        if (get('frmInsertarCartera.cbSubgerenciaVentas') != '')  {\r            arr[arr.length] = new Array(\"oidSGV\",get('frmInsertarCartera.cbSubgerenciaVentas'));\r            recargaCombo('frmInsertarCartera.cbRegion','ZONRecargaRegiones','es.indra.sicc.dtos.zon.DTOUnidadAdministrativa',arr);\r        }\r    }\r\r    function onchange_Region(){\r        var arr = new Array();\r        vaciarCbZona();\r        if (get('frmInsertarCartera.cbRegion') != '')  {\r            arr[arr.length] = new Array(\"oidRegion\",get('frmInsertarCartera.cbRegion'));\r            recargaCombo('frmInsertarCartera.cbZona','ZONRecargaZonas','es.indra.sicc.dtos.zon.DTOUnidadAdministrativa',arr);                \r        }\r        \r    }\r\r    function fVolver(){\r        this.close();\r    }\r\r    function ontab_btnAnadir(){\r        focalizaBotonHTML('botonContenido', 'btnModificar');\r    }\r\r    function onshtab_cbEjecutivoCuenta(){\r        focalizaBotonHTML('botonContenido', 'btnModificar');\r    }\r\r    function onshtab_btnModificar(){\r        focalizaBotonHTML('botonContenido', 'btnAnadir');\r    }\r\r    function ontab_btnModificar(){\r        if (get('frmInsertarCartera.casoDeUso') == 'modificarInsert')  {\r            focaliza('frmInsertarCartera.cbMarca','');        \r        }else{\r            focaliza('frmInsertarCartera.cbEjecutivoCuenta','');\r        }\r    }\r\r\r    function onshtab_cbMarca(){\r        if (get('frmInsertarCartera.casoDeUso') == 'modificarInsert')  {\r            focalizaBotonHTML('botonContenido', 'btnModificar');\r        }else{\r            focaliza('frmInsertarCartera.cbEjecutivoCuenta','');\r        }\r    }\r\r    function vaciarCbSubgerencia(){\r        var aCombo = new Array(new Array(\"\",\"\"));\r        set_combo('frmInsertarCartera.cbSubgerenciaVentas', aCombo, []);\r        vaciarCbRegion();\r    }\r\r    function vaciarCbRegion(){\r        var aCombo = new Array(new Array(\"\",\"\"));\r        set_combo('frmInsertarCartera.cbRegion', aCombo, []);\r        vaciarCbZona();\r    }\r\r    function vaciarCbZona(){\r        var aCombo = new Array(new Array(\"\",\"\"));\r        set_combo('frmInsertarCartera.cbZona', aCombo, []);\r    }\r\r    function voyEjecutivosCuenta() {\r      pestaniaEjecutivo();\r    }\r\r        function poneManito(nombre) {          \r          var nombre = document.getElementById(nombre);\r          nombre.style.cursor = \"hand\";\r         }\r\r   \r  "));
      ((Element)v.get(7)).appendChild((Text)v.get(8));

      /* Termina nodo Texto:8   */
      /* Termina nodo:7   */

      /* Empieza nodo:9 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(9)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(10)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(11)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(12)).setAttribute("nombre","frmInsertarCartera" );
      ((Element)v.get(0)).appendChild((Element)v.get(12));

      /* Empieza nodo:13 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","accion" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(15)).setAttribute("valor","LPEjecutivosCuenta" );
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
      ((Element)v.get(18)).setAttribute("nombre","hListado" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","oidAsignacion" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","asignaciones" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","oidEjecutivo" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","IDPrincipal" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","oidJerarquia" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hPais" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hIdioma" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hOidAsigna" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","focoUltimo" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","marcaDefecto" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","canalDefecto" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","sgvDefecto" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","regionDefecto" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","zonaDefecto" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 12   */
      v.add(doc.createElement("table"));
      ((Element)v.get(33)).setAttribute("width","100%" );
      ((Element)v.get(33)).setAttribute("height","100%" );
      ((Element)v.get(33)).setAttribute("border","0" );
      ((Element)v.get(33)).setAttribute("align","center" );
      ((Element)v.get(33)).setAttribute("cellpadding","0" );
      ((Element)v.get(33)).setAttribute("cellspacing","0" );
      ((Element)v.get(33)).setAttribute("class","menu4" );
      ((Element)v.get(12)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).setAttribute("width","12" );
      ((Element)v.get(35)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(35)).setAttribute("class","menu5texto" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(36)).setAttribute("src","b.gif" );
      ((Element)v.get(36)).setAttribute("width","12" );
      ((Element)v.get(36)).setAttribute("height","30" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */
      /* Termina nodo:35   */

      /* Empieza nodo:37 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(37)).setAttribute("class","menu5texto" );
      ((Element)v.get(34)).appendChild((Element)v.get(37));

      /* Elemento padre:37 / Elemento actual: 38   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(37)).appendChild((Text)v.get(38));

      /* Termina nodo Texto:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:39 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).setAttribute("width","10" );
      ((Element)v.get(39)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(39)).setAttribute("class","menu5texto" );
      ((Element)v.get(34)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(40)).setAttribute("src","b.gif" );
      ((Element)v.get(40)).setAttribute("width","10" );
      ((Element)v.get(40)).setAttribute("height","8" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */
      /* Termina nodo:39   */

      /* Empieza nodo:41 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).setAttribute("width","92" );
      ((Element)v.get(41)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(41)).setAttribute("class","menu5texto" );
      ((Element)v.get(34)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("table"));
      ((Element)v.get(42)).setAttribute("width","75" );
      ((Element)v.get(42)).setAttribute("border","1" );
      ((Element)v.get(42)).setAttribute("align","center" );
      ((Element)v.get(42)).setAttribute("cellpadding","1" );
      ((Element)v.get(42)).setAttribute("cellspacing","0" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(42)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(42)).setAttribute("bgcolor","#496A9A" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(43)).setAttribute("align","left" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(45)).setAttribute("nombre","lblUnidades" );
      ((Element)v.get(45)).setAttribute("ancho","150" );
      ((Element)v.get(45)).setAttribute("alto","13" );
      ((Element)v.get(45)).setAttribute("filas","1" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(45)).setAttribute("id","menu5textoblanca" );
      ((Element)v.get(45)).setAttribute("cod","0043" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */
      /* Termina nodo:43   */
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:46 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).setAttribute("width","10" );
      ((Element)v.get(46)).setAttribute("class","menu5texto" );
      ((Element)v.get(34)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(47)).setAttribute("src","b.gif" );
      ((Element)v.get(47)).setAttribute("width","10" );
      ((Element)v.get(47)).setAttribute("height","8" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).setAttribute("width","20" );
      ((Element)v.get(48)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(48)).setAttribute("class","menu5texto" );
      ((Element)v.get(34)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("table"));
      ((Element)v.get(49)).setAttribute("width","75" );
      ((Element)v.get(49)).setAttribute("border","1" );
      ((Element)v.get(49)).setAttribute("align","center" );
      ((Element)v.get(49)).setAttribute("cellpadding","1" );
      ((Element)v.get(49)).setAttribute("cellspacing","0" );
      ((Element)v.get(49)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(50)).setAttribute("align","left" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).setAttribute("id","ejecutivo" );
      ((Element)v.get(51)).setAttribute("onmouseover","poneManito('ejecutivo');" );
      ((Element)v.get(51)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(51)).setAttribute("onclick","pestaniaEjecutivo();" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(52)).setAttribute("nombre","lblEjecutivosCuenta" );
      ((Element)v.get(52)).setAttribute("ancho","100" );
      ((Element)v.get(52)).setAttribute("alto","13" );
      ((Element)v.get(52)).setAttribute("filas","1" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(52)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(52)).setAttribute("cod","00403" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */
      /* Termina nodo:50   */
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:53 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).setAttribute("width","16" );
      ((Element)v.get(53)).setAttribute("class","menu5texto" );
      ((Element)v.get(34)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(54)).setAttribute("src","b.gif" );
      ((Element)v.get(54)).setAttribute("width","12" );
      ((Element)v.get(54)).setAttribute("height","8" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */
      /* Termina nodo:34   */
      /* Termina nodo:33   */

      /* Empieza nodo:55 / Elemento padre: 12   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(55)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(12)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("table"));
      ((Element)v.get(56)).setAttribute("width","100%" );
      ((Element)v.get(56)).setAttribute("border","0" );
      ((Element)v.get(56)).setAttribute("cellspacing","0" );
      ((Element)v.get(56)).setAttribute("cellpadding","0" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).setAttribute("width","12" );
      ((Element)v.get(58)).setAttribute("align","center" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(59)).setAttribute("src","b.gif" );
      ((Element)v.get(59)).setAttribute("width","12" );
      ((Element)v.get(59)).setAttribute("height","12" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:60 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).setAttribute("width","750" );
      ((Element)v.get(57)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(61)).setAttribute("src","b.gif" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:62 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).setAttribute("width","12" );
      ((Element)v.get(57)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(63)).setAttribute("src","b.gif" );
      ((Element)v.get(63)).setAttribute("width","12" );
      ((Element)v.get(63)).setAttribute("height","1" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */
      /* Termina nodo:57   */

      /* Empieza nodo:64 / Elemento padre: 56   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(56)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(66)).setAttribute("src","b.gif" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:67 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(69)).setAttribute("class","legend" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(70)).setAttribute("nombre","lblUnidadesAdministrativas" );
      ((Element)v.get(70)).setAttribute("alto","13" );
      ((Element)v.get(70)).setAttribute("filas","1" );
      ((Element)v.get(70)).setAttribute("cod","0043" );
      ((Element)v.get(70)).setAttribute("id","legend" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:71 / Elemento padre: 68   */
      v.add(doc.createElement("table"));
      ((Element)v.get(71)).setAttribute("width","100%" );
      ((Element)v.get(71)).setAttribute("border","0" );
      ((Element)v.get(71)).setAttribute("align","center" );
      ((Element)v.get(71)).setAttribute("cellspacing","0" );
      ((Element)v.get(71)).setAttribute("cellpadding","0" );
      ((Element)v.get(68)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("table"));
      ((Element)v.get(74)).setAttribute("width","737" );
      ((Element)v.get(74)).setAttribute("border","0" );
      ((Element)v.get(74)).setAttribute("align","left" );
      ((Element)v.get(74)).setAttribute("cellspacing","0" );
      ((Element)v.get(74)).setAttribute("cellpadding","0" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).setAttribute("colspan","4" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(77)).setAttribute("src","b.gif" );
      ((Element)v.get(77)).setAttribute("width","8" );
      ((Element)v.get(77)).setAttribute("height","8" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:78 / Elemento padre: 74   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(74)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(80)).setAttribute("src","b.gif" );
      ((Element)v.get(80)).setAttribute("width","8" );
      ((Element)v.get(80)).setAttribute("height","8" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:81 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(82)).setAttribute("nombre","lblEjecutivoCuenta" );
      ((Element)v.get(82)).setAttribute("alto","13" );
      ((Element)v.get(82)).setAttribute("filas","1" );
      ((Element)v.get(82)).setAttribute("valor","" );
      ((Element)v.get(82)).setAttribute("id","datosTitle" );
      ((Element)v.get(82)).setAttribute("cod","854" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).setAttribute("width","100%" );
      ((Element)v.get(78)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(84)).setAttribute("src","b.gif" );
      ((Element)v.get(84)).setAttribute("width","8" );
      ((Element)v.get(84)).setAttribute("height","8" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */
      /* Termina nodo:78   */

      /* Empieza nodo:85 / Elemento padre: 74   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(74)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(85)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(87)).setAttribute("src","b.gif" );
      ((Element)v.get(87)).setAttribute("width","8" );
      ((Element)v.get(87)).setAttribute("height","8" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:88 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(85)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(89)).setAttribute("nombre","cbEjecutivoCuenta" );
      ((Element)v.get(89)).setAttribute("id","datosCampos" );
      ((Element)v.get(89)).setAttribute("size","1" );
      ((Element)v.get(89)).setAttribute("multiple","N" );
      ((Element)v.get(89)).setAttribute("req","S" );
      ((Element)v.get(89)).setAttribute("valorinicial","" );
      ((Element)v.get(89)).setAttribute("textoinicial","" );
      ((Element)v.get(89)).setAttribute("onshtab","onshtab_cbEjecutivoCuenta();" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:91 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).setAttribute("width","100%" );
      ((Element)v.get(85)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(92)).setAttribute("width","8" );
      ((Element)v.get(92)).setAttribute("height","8" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */
      /* Termina nodo:85   */

      /* Empieza nodo:93 / Elemento padre: 74   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(74)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).setAttribute("colspan","4" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(95)).setAttribute("src","b.gif" );
      ((Element)v.get(95)).setAttribute("width","8" );
      ((Element)v.get(95)).setAttribute("height","8" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:74   */
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:96 / Elemento padre: 71   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(71)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("table"));
      ((Element)v.get(98)).setAttribute("width","737" );
      ((Element)v.get(98)).setAttribute("border","0" );
      ((Element)v.get(98)).setAttribute("align","left" );
      ((Element)v.get(98)).setAttribute("cellspacing","0" );
      ((Element)v.get(98)).setAttribute("cellpadding","0" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(101)).setAttribute("src","b.gif" );
      ((Element)v.get(101)).setAttribute("width","8" );
      ((Element)v.get(101)).setAttribute("height","8" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:102 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(103)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(103)).setAttribute("alto","13" );
      ((Element)v.get(103)).setAttribute("filas","1" );
      ((Element)v.get(103)).setAttribute("valor","" );
      ((Element)v.get(103)).setAttribute("id","datosTitle" );
      ((Element)v.get(103)).setAttribute("cod","6" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(105)).setAttribute("src","b.gif" );
      ((Element)v.get(105)).setAttribute("width","25" );
      ((Element)v.get(105)).setAttribute("height","8" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:106 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(107)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(107)).setAttribute("alto","13" );
      ((Element)v.get(107)).setAttribute("filas","1" );
      ((Element)v.get(107)).setAttribute("valor","" );
      ((Element)v.get(107)).setAttribute("id","datosTitle" );
      ((Element)v.get(107)).setAttribute("cod","7" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:108 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).setAttribute("width","100%" );
      ((Element)v.get(99)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(109)).setAttribute("src","b.gif" );
      ((Element)v.get(109)).setAttribute("width","8" );
      ((Element)v.get(109)).setAttribute("height","8" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */
      /* Termina nodo:99   */

      /* Empieza nodo:110 / Elemento padre: 98   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(98)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(112)).setAttribute("src","b.gif" );
      ((Element)v.get(112)).setAttribute("width","8" );
      ((Element)v.get(112)).setAttribute("height","8" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:113 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(110)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(114)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(114)).setAttribute("id","datosCampos" );
      ((Element)v.get(114)).setAttribute("size","1" );
      ((Element)v.get(114)).setAttribute("multiple","N" );
      ((Element)v.get(114)).setAttribute("req","S" );
      ((Element)v.get(114)).setAttribute("valorinicial","" );
      ((Element)v.get(114)).setAttribute("textoinicial","" );
      ((Element)v.get(114)).setAttribute("onchange","onchange_Canal();" );
      ((Element)v.get(114)).setAttribute("onshtab","onshtab_cbMarca();" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(116)).setAttribute("ID","1" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(117)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(117)).setAttribute("TIPO","STRING" );
      ((Element)v.get(117)).setAttribute("VALOR","" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */

      /* Empieza nodo:118 / Elemento padre: 116   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(118)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(118)).setAttribute("TIPO","STRING" );
      ((Element)v.get(118)).setAttribute("VALOR","" );
      ((Element)v.get(116)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:116   */
      /* Termina nodo:115   */
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:119 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(120)).setAttribute("src","b.gif" );
      ((Element)v.get(120)).setAttribute("width","25" );
      ((Element)v.get(120)).setAttribute("height","8" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:121 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(121)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(110)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(122)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(122)).setAttribute("id","datosCampos" );
      ((Element)v.get(122)).setAttribute("size","1" );
      ((Element)v.get(122)).setAttribute("multiple","N" );
      ((Element)v.get(122)).setAttribute("req","S" );
      ((Element)v.get(122)).setAttribute("valorinicial","" );
      ((Element)v.get(122)).setAttribute("textoinicial","" );
      ((Element)v.get(122)).setAttribute("onchange","onchange_Marca();" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(124)).setAttribute("ID","1" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(125)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(125)).setAttribute("TIPO","STRING" );
      ((Element)v.get(125)).setAttribute("VALOR","" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */

      /* Empieza nodo:126 / Elemento padre: 124   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(126)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(126)).setAttribute("TIPO","STRING" );
      ((Element)v.get(126)).setAttribute("VALOR","" );
      ((Element)v.get(124)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:124   */
      /* Termina nodo:123   */
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:127 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).setAttribute("width","100%" );
      ((Element)v.get(110)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(128)).setAttribute("src","b.gif" );
      ((Element)v.get(128)).setAttribute("width","8" );
      ((Element)v.get(128)).setAttribute("height","8" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */
      /* Termina nodo:110   */

      /* Empieza nodo:129 / Elemento padre: 98   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(98)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).setAttribute("colspan","4" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(131)).setAttribute("src","b.gif" );
      ((Element)v.get(131)).setAttribute("width","8" );
      ((Element)v.get(131)).setAttribute("height","8" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */
      /* Termina nodo:129   */
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:132 / Elemento padre: 71   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(71)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("td"));
      ((Element)v.get(132)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("table"));
      ((Element)v.get(134)).setAttribute("width","737" );
      ((Element)v.get(134)).setAttribute("border","0" );
      ((Element)v.get(134)).setAttribute("align","left" );
      ((Element)v.get(134)).setAttribute("cellspacing","0" );
      ((Element)v.get(134)).setAttribute("cellpadding","0" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(134)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("td"));
      ((Element)v.get(135)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(137)).setAttribute("src","b.gif" );
      ((Element)v.get(137)).setAttribute("width","8" );
      ((Element)v.get(137)).setAttribute("height","8" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:138 / Elemento padre: 135   */
      v.add(doc.createElement("td"));
      ((Element)v.get(135)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(139)).setAttribute("nombre","lblSubgerenciaVentas" );
      ((Element)v.get(139)).setAttribute("alto","13" );
      ((Element)v.get(139)).setAttribute("filas","1" );
      ((Element)v.get(139)).setAttribute("valor","" );
      ((Element)v.get(139)).setAttribute("id","datosTitle" );
      ((Element)v.get(139)).setAttribute("cod","124" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */

      /* Empieza nodo:140 / Elemento padre: 135   */
      v.add(doc.createElement("td"));
      ((Element)v.get(135)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(141)).setAttribute("src","b.gif" );
      ((Element)v.get(141)).setAttribute("width","25" );
      ((Element)v.get(141)).setAttribute("height","8" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:142 / Elemento padre: 135   */
      v.add(doc.createElement("td"));
      ((Element)v.get(135)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(143)).setAttribute("nombre","lblRegión" );
      ((Element)v.get(143)).setAttribute("alto","13" );
      ((Element)v.get(143)).setAttribute("filas","1" );
      ((Element)v.get(143)).setAttribute("valor","" );
      ((Element)v.get(143)).setAttribute("id","datosTitle" );
      ((Element)v.get(143)).setAttribute("cod","109" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */

      /* Empieza nodo:144 / Elemento padre: 135   */
      v.add(doc.createElement("td"));
      ((Element)v.get(144)).setAttribute("width","100%" );
      ((Element)v.get(135)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(145)).setAttribute("src","b.gif" );
      ((Element)v.get(145)).setAttribute("width","8" );
      ((Element)v.get(145)).setAttribute("height","8" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */
      /* Termina nodo:135   */

      /* Empieza nodo:146 / Elemento padre: 134   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(134)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(148)).setAttribute("src","b.gif" );
      ((Element)v.get(148)).setAttribute("width","8" );
      ((Element)v.get(148)).setAttribute("height","8" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */

      /* Empieza nodo:149 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(146)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(150)).setAttribute("nombre","cbSubgerenciaVentas" );
      ((Element)v.get(150)).setAttribute("id","datosCampos" );
      ((Element)v.get(150)).setAttribute("size","1" );
      ((Element)v.get(150)).setAttribute("multiple","N" );
      ((Element)v.get(150)).setAttribute("req","S" );
      ((Element)v.get(150)).setAttribute("valorinicial","" );
      ((Element)v.get(150)).setAttribute("textoinicial","" );
      ((Element)v.get(150)).setAttribute("onchange","onchange_Subgerencia();" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(152)).setAttribute("ID","1" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(153)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(153)).setAttribute("TIPO","STRING" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(153)).setAttribute("VALOR","00" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */

      /* Empieza nodo:154 / Elemento padre: 152   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(154)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(154)).setAttribute("TIPO","STRING" );
      ((Element)v.get(154)).setAttribute("VALOR","" );
      ((Element)v.get(152)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:152   */
      /* Termina nodo:151   */
      /* Termina nodo:150   */
      /* Termina nodo:149   */

      /* Empieza nodo:155 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","b.gif" );
      ((Element)v.get(156)).setAttribute("width","25" );
      ((Element)v.get(156)).setAttribute("height","8" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:157 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(146)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(158)).setAttribute("nombre","cbRegion" );
      ((Element)v.get(158)).setAttribute("id","datosCampos" );
      ((Element)v.get(158)).setAttribute("size","1" );
      ((Element)v.get(158)).setAttribute("multiple","N" );
      ((Element)v.get(158)).setAttribute("req","N" );
      ((Element)v.get(158)).setAttribute("valorinicial","" );
      ((Element)v.get(158)).setAttribute("textoinicial","" );
      ((Element)v.get(158)).setAttribute("onchange","onchange_Region();" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(158)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(160)).setAttribute("ID","1" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(161)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(161)).setAttribute("TIPO","STRING" );
      ((Element)v.get(161)).setAttribute("VALOR","00" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */

      /* Empieza nodo:162 / Elemento padre: 160   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(162)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(162)).setAttribute("TIPO","STRING" );
      ((Element)v.get(162)).setAttribute("VALOR","" );
      ((Element)v.get(160)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:160   */
      /* Termina nodo:159   */
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:163 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).setAttribute("width","100%" );
      ((Element)v.get(146)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(164)).setAttribute("src","b.gif" );
      ((Element)v.get(164)).setAttribute("width","8" );
      ((Element)v.get(164)).setAttribute("height","8" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */
      /* Termina nodo:146   */

      /* Empieza nodo:165 / Elemento padre: 134   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(134)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("td"));
      ((Element)v.get(166)).setAttribute("colspan","4" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(167)).setAttribute("src","b.gif" );
      ((Element)v.get(167)).setAttribute("width","8" );
      ((Element)v.get(167)).setAttribute("height","8" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */
      /* Termina nodo:165   */
      /* Termina nodo:134   */
      /* Termina nodo:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:168 / Elemento padre: 71   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(71)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("td"));
      ((Element)v.get(168)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("table"));
      ((Element)v.get(170)).setAttribute("width","737" );
      ((Element)v.get(170)).setAttribute("border","0" );
      ((Element)v.get(170)).setAttribute("align","left" );
      ((Element)v.get(170)).setAttribute("cellspacing","0" );
      ((Element)v.get(170)).setAttribute("cellpadding","0" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(170)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("td"));
      ((Element)v.get(171)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(173)).setAttribute("src","b.gif" );
      ((Element)v.get(173)).setAttribute("width","8" );
      ((Element)v.get(173)).setAttribute("height","8" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:172   */

      /* Empieza nodo:174 / Elemento padre: 171   */
      v.add(doc.createElement("td"));
      ((Element)v.get(171)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(175)).setAttribute("nombre","lblZona" );
      ((Element)v.get(175)).setAttribute("alto","13" );
      ((Element)v.get(175)).setAttribute("filas","1" );
      ((Element)v.get(175)).setAttribute("valor","" );
      ((Element)v.get(175)).setAttribute("id","datosTitle" );
      ((Element)v.get(175)).setAttribute("cod","143" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */

      /* Empieza nodo:176 / Elemento padre: 171   */
   }

   private void getXML720(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(171)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(177)).setAttribute("src","b.gif" );
      ((Element)v.get(177)).setAttribute("width","25" );
      ((Element)v.get(177)).setAttribute("height","8" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:178 / Elemento padre: 171   */
      v.add(doc.createElement("td"));
      ((Element)v.get(171)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(179)).setAttribute("nombre","lblNivelRiesgo" );
      ((Element)v.get(179)).setAttribute("alto","13" );
      ((Element)v.get(179)).setAttribute("filas","1" );
      ((Element)v.get(179)).setAttribute("valor","" );
      ((Element)v.get(179)).setAttribute("id","datosTitle" );
      ((Element)v.get(179)).setAttribute("cod","928" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */

      /* Empieza nodo:180 / Elemento padre: 171   */
      v.add(doc.createElement("td"));
      ((Element)v.get(180)).setAttribute("width","100%" );
      ((Element)v.get(171)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(181)).setAttribute("src","b.gif" );
      ((Element)v.get(181)).setAttribute("width","8" );
      ((Element)v.get(181)).setAttribute("height","8" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */
      /* Termina nodo:171   */

      /* Empieza nodo:182 / Elemento padre: 170   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(170)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("td"));
      ((Element)v.get(182)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(184)).setAttribute("src","b.gif" );
      ((Element)v.get(184)).setAttribute("width","8" );
      ((Element)v.get(184)).setAttribute("height","8" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:185 / Elemento padre: 182   */
      v.add(doc.createElement("td"));
      ((Element)v.get(185)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(185)).setAttribute("valign","top" );
      ((Element)v.get(182)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(186)).setAttribute("nombre","cbZona" );
      ((Element)v.get(186)).setAttribute("id","datosCampos" );
      ((Element)v.get(186)).setAttribute("size","1" );
      ((Element)v.get(186)).setAttribute("multiple","N" );
      ((Element)v.get(186)).setAttribute("req","N" );
      ((Element)v.get(186)).setAttribute("valorinicial","" );
      ((Element)v.get(186)).setAttribute("textoinicial","" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(186)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(188)).setAttribute("ID","1" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(189)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(189)).setAttribute("TIPO","STRING" );
      ((Element)v.get(189)).setAttribute("VALOR","00" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */

      /* Empieza nodo:190 / Elemento padre: 188   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(190)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(190)).setAttribute("TIPO","STRING" );
      ((Element)v.get(190)).setAttribute("VALOR","" );
      ((Element)v.get(188)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:188   */
      /* Termina nodo:187   */
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:191 / Elemento padre: 182   */
      v.add(doc.createElement("td"));
      ((Element)v.get(182)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(192)).setAttribute("src","b.gif" );
      ((Element)v.get(192)).setAttribute("width","25" );
      ((Element)v.get(192)).setAttribute("height","8" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */

      /* Empieza nodo:193 / Elemento padre: 182   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(182)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(194)).setAttribute("nombre","cbNivelRiesgo" );
      ((Element)v.get(194)).setAttribute("id","datosCampos" );
      ((Element)v.get(194)).setAttribute("size","5" );
      ((Element)v.get(194)).setAttribute("multiple","S" );
      ((Element)v.get(194)).setAttribute("req","S" );
      ((Element)v.get(194)).setAttribute("valorinicial","" );
      ((Element)v.get(194)).setAttribute("textoinicial","" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(194)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(196)).setAttribute("ID","1" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(197)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(197)).setAttribute("TIPO","STRING" );
      ((Element)v.get(197)).setAttribute("VALOR","00" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */

      /* Empieza nodo:198 / Elemento padre: 196   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(198)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(198)).setAttribute("TIPO","STRING" );
      ((Element)v.get(198)).setAttribute("VALOR","" );
      ((Element)v.get(196)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:196   */

      /* Empieza nodo:199 / Elemento padre: 195   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(199)).setAttribute("ID","2" );
      ((Element)v.get(195)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(200)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(200)).setAttribute("TIPO","STRING" );
      ((Element)v.get(200)).setAttribute("VALOR","00" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */

      /* Empieza nodo:201 / Elemento padre: 199   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(201)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(201)).setAttribute("TIPO","STRING" );
      ((Element)v.get(201)).setAttribute("VALOR","" );
      ((Element)v.get(199)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:199   */

      /* Empieza nodo:202 / Elemento padre: 195   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(202)).setAttribute("ID","3" );
      ((Element)v.get(195)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(203)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(203)).setAttribute("TIPO","STRING" );
      ((Element)v.get(203)).setAttribute("VALOR","00" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */

      /* Empieza nodo:204 / Elemento padre: 202   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(204)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(204)).setAttribute("TIPO","STRING" );
      ((Element)v.get(204)).setAttribute("VALOR","" );
      ((Element)v.get(202)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:202   */

      /* Empieza nodo:205 / Elemento padre: 195   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(205)).setAttribute("ID","4" );
      ((Element)v.get(195)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(206)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(206)).setAttribute("TIPO","STRING" );
      ((Element)v.get(206)).setAttribute("VALOR","00" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */

      /* Empieza nodo:207 / Elemento padre: 205   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(207)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(207)).setAttribute("TIPO","STRING" );
      ((Element)v.get(207)).setAttribute("VALOR","" );
      ((Element)v.get(205)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:205   */
      /* Termina nodo:195   */
      /* Termina nodo:194   */
      /* Termina nodo:193   */

      /* Empieza nodo:208 / Elemento padre: 182   */
      v.add(doc.createElement("td"));
      ((Element)v.get(208)).setAttribute("width","100%" );
      ((Element)v.get(182)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(209)).setAttribute("src","b.gif" );
      ((Element)v.get(209)).setAttribute("width","8" );
      ((Element)v.get(209)).setAttribute("height","8" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */
      /* Termina nodo:182   */

      /* Empieza nodo:210 / Elemento padre: 170   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(170)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("td"));
      ((Element)v.get(211)).setAttribute("colspan","4" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(212)).setAttribute("src","b.gif" );
      ((Element)v.get(212)).setAttribute("width","8" );
      ((Element)v.get(212)).setAttribute("height","8" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:211   */
      /* Termina nodo:210   */
      /* Termina nodo:170   */
      /* Termina nodo:169   */
      /* Termina nodo:168   */
      /* Termina nodo:71   */
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:213 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(214)).setAttribute("src","b.gif" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */
      /* Termina nodo:64   */

      /* Empieza nodo:215 / Elemento padre: 56   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(56)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("td"));
      ((Element)v.get(215)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(217)).setAttribute("src","b.gif" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:216   */

      /* Empieza nodo:218 / Elemento padre: 215   */
      v.add(doc.createElement("td"));
      ((Element)v.get(215)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(218)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("table"));
      ((Element)v.get(220)).setAttribute("width","100%" );
      ((Element)v.get(220)).setAttribute("border","0" );
      ((Element)v.get(220)).setAttribute("align","center" );
      ((Element)v.get(220)).setAttribute("cellspacing","0" );
      ((Element)v.get(220)).setAttribute("cellpadding","0" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(220)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("td"));
      ((Element)v.get(222)).setAttribute("class","botonera" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(221)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(223)).setAttribute("nombre","btnAnadir" );
      ((Element)v.get(223)).setAttribute("ID","botonContenido" );
      ((Element)v.get(223)).setAttribute("tipo","html" );
      ((Element)v.get(223)).setAttribute("accion","aniadirFila();" );
      ((Element)v.get(223)).setAttribute("estado","false" );
      ((Element)v.get(223)).setAttribute("cod","404" );
      ((Element)v.get(223)).setAttribute("ontab","ontab_btnAnadir();" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:222   */
      /* Termina nodo:221   */
      /* Termina nodo:220   */
      /* Termina nodo:219   */
      /* Termina nodo:218   */

      /* Empieza nodo:224 / Elemento padre: 215   */
      v.add(doc.createElement("td"));
      ((Element)v.get(215)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(225)).setAttribute("src","b.gif" );
      ((Element)v.get(225)).setAttribute("width","8" );
      ((Element)v.get(225)).setAttribute("height","12" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */
      /* Termina nodo:215   */

      /* Empieza nodo:226 / Elemento padre: 56   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(56)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("td"));
      ((Element)v.get(227)).setAttribute("width","12" );
      ((Element)v.get(227)).setAttribute("align","center" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(228)).setAttribute("src","b.gif" );
      ((Element)v.get(228)).setAttribute("width","12" );
      ((Element)v.get(228)).setAttribute("height","12" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */
      /* Termina nodo:227   */

      /* Empieza nodo:229 / Elemento padre: 226   */
      v.add(doc.createElement("td"));
      ((Element)v.get(229)).setAttribute("width","756" );
      ((Element)v.get(226)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(230)).setAttribute("src","b.gif" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */

      /* Empieza nodo:231 / Elemento padre: 226   */
      v.add(doc.createElement("td"));
      ((Element)v.get(231)).setAttribute("width","12" );
      ((Element)v.get(226)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(232)).setAttribute("src","b.gif" );
      ((Element)v.get(232)).setAttribute("width","12" );
      ((Element)v.get(232)).setAttribute("height","1" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:231   */
      /* Termina nodo:226   */
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:233 / Elemento padre: 12   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(233)).setAttribute("nombre","listado1" );
      ((Element)v.get(233)).setAttribute("ancho","740" );
      ((Element)v.get(233)).setAttribute("alto","317" );
      ((Element)v.get(233)).setAttribute("x","12" );
      ((Element)v.get(233)).setAttribute("y","326" );
      ((Element)v.get(233)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(233)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(12)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(234)).setAttribute("precarga","S" );
      ((Element)v.get(234)).setAttribute("conROver","S" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(235)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(235)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(235)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(235)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */

      /* Empieza nodo:236 / Elemento padre: 234   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(236)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(236)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(236)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(236)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(234)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */

      /* Empieza nodo:237 / Elemento padre: 234   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(237)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(237)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(234)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */
      /* Termina nodo:234   */

      /* Empieza nodo:238 / Elemento padre: 233   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(233)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(239)).setAttribute("borde","1" );
      ((Element)v.get(239)).setAttribute("horizDatos","1" );
      ((Element)v.get(239)).setAttribute("horizCabecera","1" );
      ((Element)v.get(239)).setAttribute("vertical","1" );
      ((Element)v.get(239)).setAttribute("horizTitulo","1" );
      ((Element)v.get(239)).setAttribute("horizBase","1" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */

      /* Empieza nodo:240 / Elemento padre: 238   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(240)).setAttribute("borde","#999999" );
      ((Element)v.get(240)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(240)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(240)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(240)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(240)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(240)).setAttribute("horizBase","#999999" );
      ((Element)v.get(238)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:238   */

      /* Empieza nodo:241 / Elemento padre: 233   */
   }

   private void getXML990(Document doc) {
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(241)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(241)).setAttribute("alto","22" );
      ((Element)v.get(241)).setAttribute("imgFondo","" );
      ((Element)v.get(241)).setAttribute("cod","00211" );
      ((Element)v.get(241)).setAttribute("ID","datosTitle" );
      ((Element)v.get(233)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */

      /* Empieza nodo:242 / Elemento padre: 233   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(242)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(242)).setAttribute("alto","22" );
      ((Element)v.get(242)).setAttribute("imgFondo","" );
      ((Element)v.get(233)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */

      /* Empieza nodo:243 / Elemento padre: 233   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(243)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(243)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(243)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(243)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(243)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(243)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(233)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(244)).setAttribute("ancho","30" );
      ((Element)v.get(244)).setAttribute("minimizable","S" );
      ((Element)v.get(244)).setAttribute("minimizada","N" );
      ((Element)v.get(244)).setAttribute("oculta","S" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */

      /* Empieza nodo:245 / Elemento padre: 243   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(245)).setAttribute("ancho","50" );
      ((Element)v.get(245)).setAttribute("minimizable","S" );
      ((Element)v.get(245)).setAttribute("minimizada","N" );
      ((Element)v.get(243)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */

      /* Empieza nodo:246 / Elemento padre: 243   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(246)).setAttribute("ancho","30" );
      ((Element)v.get(246)).setAttribute("minimizable","S" );
      ((Element)v.get(246)).setAttribute("minimizada","N" );
      ((Element)v.get(243)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */

      /* Empieza nodo:247 / Elemento padre: 243   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(247)).setAttribute("ancho","30" );
      ((Element)v.get(247)).setAttribute("minimizable","S" );
      ((Element)v.get(247)).setAttribute("minimizada","N" );
      ((Element)v.get(243)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */

      /* Empieza nodo:248 / Elemento padre: 243   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(248)).setAttribute("ancho","50" );
      ((Element)v.get(248)).setAttribute("minimizable","S" );
      ((Element)v.get(248)).setAttribute("minimizada","N" );
      ((Element)v.get(243)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */

      /* Empieza nodo:249 / Elemento padre: 243   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(249)).setAttribute("ancho","30" );
      ((Element)v.get(249)).setAttribute("minimizable","S" );
      ((Element)v.get(249)).setAttribute("minimizada","N" );
      ((Element)v.get(243)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */

      /* Empieza nodo:250 / Elemento padre: 243   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(250)).setAttribute("ancho","50" );
      ((Element)v.get(250)).setAttribute("minimizable","S" );
      ((Element)v.get(250)).setAttribute("minimizada","N" );
      ((Element)v.get(243)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */

      /* Empieza nodo:251 / Elemento padre: 243   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(251)).setAttribute("ancho","30" );
      ((Element)v.get(251)).setAttribute("minimizable","S" );
      ((Element)v.get(251)).setAttribute("minimizada","N" );
      ((Element)v.get(243)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */

      /* Empieza nodo:252 / Elemento padre: 243   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(252)).setAttribute("ancho","30" );
      ((Element)v.get(252)).setAttribute("minimizable","S" );
      ((Element)v.get(252)).setAttribute("minimizada","N" );
      ((Element)v.get(252)).setAttribute("oculta","S" );
      ((Element)v.get(243)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */

      /* Empieza nodo:253 / Elemento padre: 243   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(253)).setAttribute("ancho","30" );
      ((Element)v.get(253)).setAttribute("minimizable","S" );
      ((Element)v.get(253)).setAttribute("minimizada","N" );
      ((Element)v.get(253)).setAttribute("oculta","S" );
      ((Element)v.get(243)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */

      /* Empieza nodo:254 / Elemento padre: 243   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(254)).setAttribute("ancho","30" );
      ((Element)v.get(254)).setAttribute("minimizable","S" );
      ((Element)v.get(254)).setAttribute("minimizada","N" );
      ((Element)v.get(254)).setAttribute("oculta","S" );
      ((Element)v.get(243)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */

      /* Empieza nodo:255 / Elemento padre: 243   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(255)).setAttribute("ancho","30" );
      ((Element)v.get(255)).setAttribute("minimizable","S" );
      ((Element)v.get(255)).setAttribute("minimizada","N" );
      ((Element)v.get(255)).setAttribute("oculta","S" );
      ((Element)v.get(243)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */

      /* Empieza nodo:256 / Elemento padre: 243   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(256)).setAttribute("ancho","30" );
      ((Element)v.get(256)).setAttribute("minimizable","S" );
      ((Element)v.get(256)).setAttribute("minimizada","N" );
      ((Element)v.get(256)).setAttribute("oculta","S" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(243)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */

      /* Empieza nodo:257 / Elemento padre: 243   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(257)).setAttribute("ancho","30" );
      ((Element)v.get(257)).setAttribute("minimizable","S" );
      ((Element)v.get(257)).setAttribute("minimizada","N" );
      ((Element)v.get(257)).setAttribute("oculta","S" );
      ((Element)v.get(243)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */

      /* Empieza nodo:258 / Elemento padre: 243   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(258)).setAttribute("ancho","30" );
      ((Element)v.get(258)).setAttribute("minimizable","S" );
      ((Element)v.get(258)).setAttribute("minimizada","N" );
      ((Element)v.get(258)).setAttribute("oculta","S" );
      ((Element)v.get(243)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */
      /* Termina nodo:243   */

      /* Empieza nodo:259 / Elemento padre: 233   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(259)).setAttribute("alto","20" );
      ((Element)v.get(259)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(259)).setAttribute("imgFondo","" );
      ((Element)v.get(259)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(233)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(260)).setAttribute("colFondo","" );
      ((Element)v.get(260)).setAttribute("ID","EstCab" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));

      /* Elemento padre:260 / Elemento actual: 261   */
      v.add(doc.createTextNode("oidAsignacion"));
      ((Element)v.get(260)).appendChild((Text)v.get(261));

      /* Termina nodo Texto:261   */
      /* Termina nodo:260   */

      /* Empieza nodo:262 / Elemento padre: 259   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(262)).setAttribute("colFondo","" );
      ((Element)v.get(262)).setAttribute("ID","EstCab" );
      ((Element)v.get(262)).setAttribute("cod","854" );
      ((Element)v.get(259)).appendChild((Element)v.get(262));

      /* Elemento padre:262 / Elemento actual: 263   */
      v.add(doc.createTextNode("Ejecutivo cuenta"));
      ((Element)v.get(262)).appendChild((Text)v.get(263));

      /* Termina nodo Texto:263   */
      /* Termina nodo:262   */

      /* Empieza nodo:264 / Elemento padre: 259   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(264)).setAttribute("colFondo","" );
      ((Element)v.get(264)).setAttribute("ID","EstCab" );
      ((Element)v.get(264)).setAttribute("cod","6" );
      ((Element)v.get(259)).appendChild((Element)v.get(264));

      /* Elemento padre:264 / Elemento actual: 265   */
      v.add(doc.createTextNode("Marca"));
      ((Element)v.get(264)).appendChild((Text)v.get(265));

      /* Termina nodo Texto:265   */
      /* Termina nodo:264   */

      /* Empieza nodo:266 / Elemento padre: 259   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(266)).setAttribute("colFondo","" );
      ((Element)v.get(266)).setAttribute("ID","EstCab" );
      ((Element)v.get(266)).setAttribute("cod","7" );
      ((Element)v.get(259)).appendChild((Element)v.get(266));

      /* Elemento padre:266 / Elemento actual: 267   */
      v.add(doc.createTextNode("Canal"));
      ((Element)v.get(266)).appendChild((Text)v.get(267));

      /* Termina nodo Texto:267   */
      /* Termina nodo:266   */

      /* Empieza nodo:268 / Elemento padre: 259   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(268)).setAttribute("colFondo","" );
      ((Element)v.get(268)).setAttribute("ID","EstCab" );
      ((Element)v.get(268)).setAttribute("cod","124" );
      ((Element)v.get(259)).appendChild((Element)v.get(268));

      /* Elemento padre:268 / Elemento actual: 269   */
      v.add(doc.createTextNode("Subgerencia ventas"));
      ((Element)v.get(268)).appendChild((Text)v.get(269));

      /* Termina nodo Texto:269   */
      /* Termina nodo:268   */

      /* Empieza nodo:270 / Elemento padre: 259   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(270)).setAttribute("colFondo","" );
      ((Element)v.get(270)).setAttribute("ID","EstCab" );
      ((Element)v.get(270)).setAttribute("cod","109" );
      ((Element)v.get(259)).appendChild((Element)v.get(270));

      /* Elemento padre:270 / Elemento actual: 271   */
      v.add(doc.createTextNode("Región"));
      ((Element)v.get(270)).appendChild((Text)v.get(271));

      /* Termina nodo Texto:271   */
      /* Termina nodo:270   */

      /* Empieza nodo:272 / Elemento padre: 259   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(272)).setAttribute("colFondo","" );
      ((Element)v.get(272)).setAttribute("ID","EstCab" );
      ((Element)v.get(272)).setAttribute("cod","143" );
      ((Element)v.get(259)).appendChild((Element)v.get(272));

      /* Elemento padre:272 / Elemento actual: 273   */
      v.add(doc.createTextNode("Zona"));
      ((Element)v.get(272)).appendChild((Text)v.get(273));

      /* Termina nodo Texto:273   */
      /* Termina nodo:272   */

      /* Empieza nodo:274 / Elemento padre: 259   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(274)).setAttribute("colFondo","" );
      ((Element)v.get(274)).setAttribute("ID","EstCab" );
      ((Element)v.get(274)).setAttribute("cod","928" );
      ((Element)v.get(259)).appendChild((Element)v.get(274));

      /* Elemento padre:274 / Elemento actual: 275   */
      v.add(doc.createTextNode("Nivel riesgo"));
      ((Element)v.get(274)).appendChild((Text)v.get(275));

      /* Termina nodo Texto:275   */
      /* Termina nodo:274   */

      /* Empieza nodo:276 / Elemento padre: 259   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(276)).setAttribute("colFondo","" );
      ((Element)v.get(276)).setAttribute("ID","EstCab" );
      ((Element)v.get(259)).appendChild((Element)v.get(276));

      /* Elemento padre:276 / Elemento actual: 277   */
      v.add(doc.createTextNode("oidEjecutivo"));
      ((Element)v.get(276)).appendChild((Text)v.get(277));

      /* Termina nodo Texto:277   */
      /* Termina nodo:276   */

      /* Empieza nodo:278 / Elemento padre: 259   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(278)).setAttribute("colFondo","" );
      ((Element)v.get(278)).setAttribute("ID","EstCab" );
      ((Element)v.get(259)).appendChild((Element)v.get(278));

      /* Elemento padre:278 / Elemento actual: 279   */
      v.add(doc.createTextNode("oidMarca"));
      ((Element)v.get(278)).appendChild((Text)v.get(279));

      /* Termina nodo Texto:279   */
      /* Termina nodo:278   */

      /* Empieza nodo:280 / Elemento padre: 259   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(280)).setAttribute("colFondo","" );
      ((Element)v.get(280)).setAttribute("ID","EstCab" );
      ((Element)v.get(259)).appendChild((Element)v.get(280));

      /* Elemento padre:280 / Elemento actual: 281   */
   }

   private void getXML1170(Document doc) {
      v.add(doc.createTextNode("oidCanal"));
      ((Element)v.get(280)).appendChild((Text)v.get(281));

      /* Termina nodo Texto:281   */
      /* Termina nodo:280   */

      /* Empieza nodo:282 / Elemento padre: 259   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(282)).setAttribute("colFondo","" );
      ((Element)v.get(282)).setAttribute("ID","EstCab" );
      ((Element)v.get(259)).appendChild((Element)v.get(282));

      /* Elemento padre:282 / Elemento actual: 283   */
      v.add(doc.createTextNode("oidSubgerencia"));
      ((Element)v.get(282)).appendChild((Text)v.get(283));

      /* Termina nodo Texto:283   */
      /* Termina nodo:282   */

      /* Empieza nodo:284 / Elemento padre: 259   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(284)).setAttribute("colFondo","" );
      ((Element)v.get(284)).setAttribute("ID","EstCab" );
      ((Element)v.get(259)).appendChild((Element)v.get(284));

      /* Elemento padre:284 / Elemento actual: 285   */
      v.add(doc.createTextNode("oidRegion"));
      ((Element)v.get(284)).appendChild((Text)v.get(285));

      /* Termina nodo Texto:285   */
      /* Termina nodo:284   */

      /* Empieza nodo:286 / Elemento padre: 259   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(286)).setAttribute("colFondo","" );
      ((Element)v.get(286)).setAttribute("ID","EstCab" );
      ((Element)v.get(259)).appendChild((Element)v.get(286));

      /* Elemento padre:286 / Elemento actual: 287   */
      v.add(doc.createTextNode("oidZona"));
      ((Element)v.get(286)).appendChild((Text)v.get(287));

      /* Termina nodo Texto:287   */
      /* Termina nodo:286   */

      /* Empieza nodo:288 / Elemento padre: 259   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(288)).setAttribute("colFondo","" );
      ((Element)v.get(288)).setAttribute("ID","EstCab" );
      ((Element)v.get(259)).appendChild((Element)v.get(288));

      /* Elemento padre:288 / Elemento actual: 289   */
      v.add(doc.createTextNode("oidNivelRiesgo"));
      ((Element)v.get(288)).appendChild((Text)v.get(289));

      /* Termina nodo Texto:289   */
      /* Termina nodo:288   */
      /* Termina nodo:259   */

      /* Empieza nodo:290 / Elemento padre: 233   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(290)).setAttribute("alto","22" );
      ((Element)v.get(290)).setAttribute("accion","" );
      ((Element)v.get(290)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(290)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(290)).setAttribute("maxSel","-1" );
      ((Element)v.get(290)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(290)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(290)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(290)).setAttribute("onLoad","" );
      ((Element)v.get(290)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(233)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(291)).setAttribute("tipo","texto" );
      ((Element)v.get(291)).setAttribute("ID","EstDat" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */

      /* Empieza nodo:292 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(292)).setAttribute("tipo","texto" );
      ((Element)v.get(292)).setAttribute("ID","EstDat2" );
      ((Element)v.get(290)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */

      /* Empieza nodo:293 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(293)).setAttribute("tipo","texto" );
      ((Element)v.get(293)).setAttribute("ID","EstDat" );
      ((Element)v.get(290)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */

      /* Empieza nodo:294 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(294)).setAttribute("tipo","texto" );
      ((Element)v.get(294)).setAttribute("ID","EstDat2" );
      ((Element)v.get(290)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */

      /* Empieza nodo:295 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(295)).setAttribute("tipo","texto" );
      ((Element)v.get(295)).setAttribute("ID","EstDat" );
      ((Element)v.get(290)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */

      /* Empieza nodo:296 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(296)).setAttribute("tipo","texto" );
      ((Element)v.get(296)).setAttribute("ID","EstDat2" );
      ((Element)v.get(290)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */

      /* Empieza nodo:297 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(297)).setAttribute("tipo","texto" );
      ((Element)v.get(297)).setAttribute("ID","EstDat" );
      ((Element)v.get(290)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */

      /* Empieza nodo:298 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(298)).setAttribute("tipo","texto" );
      ((Element)v.get(298)).setAttribute("ID","EstDat2" );
      ((Element)v.get(290)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */

      /* Empieza nodo:299 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(299)).setAttribute("tipo","texto" );
      ((Element)v.get(299)).setAttribute("ID","EstDat" );
      ((Element)v.get(290)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */

      /* Empieza nodo:300 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(300)).setAttribute("tipo","texto" );
      ((Element)v.get(300)).setAttribute("ID","EstDat2" );
      ((Element)v.get(290)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */

      /* Empieza nodo:301 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(301)).setAttribute("tipo","texto" );
      ((Element)v.get(301)).setAttribute("ID","EstDat" );
      ((Element)v.get(290)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */

      /* Empieza nodo:302 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(302)).setAttribute("tipo","texto" );
      ((Element)v.get(302)).setAttribute("ID","EstDat2" );
      ((Element)v.get(290)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */

      /* Empieza nodo:303 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(303)).setAttribute("tipo","texto" );
      ((Element)v.get(303)).setAttribute("ID","EstDat" );
      ((Element)v.get(290)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */

      /* Empieza nodo:304 / Elemento padre: 290   */
   }

   private void getXML1260(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(304)).setAttribute("tipo","texto" );
      ((Element)v.get(304)).setAttribute("ID","EstDat2" );
      ((Element)v.get(290)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */

      /* Empieza nodo:305 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(305)).setAttribute("tipo","texto" );
      ((Element)v.get(305)).setAttribute("ID","EstDat" );
      ((Element)v.get(290)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */
      /* Termina nodo:290   */

      /* Empieza nodo:306 / Elemento padre: 233   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(233)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */

      /* Empieza nodo:307 / Elemento padre: 233   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(307)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(307)).setAttribute("ancho","740" );
      ((Element)v.get(307)).setAttribute("sep","$" );
      ((Element)v.get(307)).setAttribute("x","12" );
      ((Element)v.get(307)).setAttribute("class","botonera" );
      ((Element)v.get(307)).setAttribute("y","620" );
      ((Element)v.get(307)).setAttribute("control","|" );
      ((Element)v.get(307)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(307)).setAttribute("rowset","" );
      ((Element)v.get(307)).setAttribute("cargainicial","N" );
      ((Element)v.get(233)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(308)).setAttribute("nombre","ret1" );
      ((Element)v.get(308)).setAttribute("x","37" );
      ((Element)v.get(308)).setAttribute("y","624" );
      ((Element)v.get(308)).setAttribute("ID","botonContenido" );
      ((Element)v.get(308)).setAttribute("img","retroceder_on" );
      ((Element)v.get(308)).setAttribute("tipo","0" );
      ((Element)v.get(308)).setAttribute("estado","false" );
      ((Element)v.get(308)).setAttribute("alt","" );
      ((Element)v.get(308)).setAttribute("codigo","" );
      ((Element)v.get(308)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */

      /* Empieza nodo:309 / Elemento padre: 307   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(309)).setAttribute("nombre","ava1" );
      ((Element)v.get(309)).setAttribute("x","52" );
      ((Element)v.get(309)).setAttribute("y","624" );
      ((Element)v.get(309)).setAttribute("ID","botonContenido" );
      ((Element)v.get(309)).setAttribute("img","avanzar_on" );
      ((Element)v.get(309)).setAttribute("tipo","0" );
      ((Element)v.get(309)).setAttribute("estado","false" );
      ((Element)v.get(309)).setAttribute("alt","" );
      ((Element)v.get(309)).setAttribute("codigo","" );
      ((Element)v.get(309)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(307)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */
      /* Termina nodo:307   */
      /* Termina nodo:233   */

      /* Empieza nodo:310 / Elemento padre: 12   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(310)).setAttribute("nombre","primera1" );
      ((Element)v.get(310)).setAttribute("x","20" );
      ((Element)v.get(310)).setAttribute("y","624" );
      ((Element)v.get(310)).setAttribute("ID","botonContenido" );
      ((Element)v.get(310)).setAttribute("img","primera_on" );
      ((Element)v.get(310)).setAttribute("tipo","-2" );
      ((Element)v.get(310)).setAttribute("estado","false" );
      ((Element)v.get(310)).setAttribute("alt","" );
      ((Element)v.get(310)).setAttribute("codigo","" );
      ((Element)v.get(310)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(12)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */

      /* Empieza nodo:311 / Elemento padre: 12   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(311)).setAttribute("nombre","separa" );
      ((Element)v.get(311)).setAttribute("x","59" );
      ((Element)v.get(311)).setAttribute("y","620" );
      ((Element)v.get(311)).setAttribute("ID","botonContenido" );
      ((Element)v.get(311)).setAttribute("img","separa_base" );
      ((Element)v.get(311)).setAttribute("tipo","0" );
      ((Element)v.get(311)).setAttribute("estado","false" );
      ((Element)v.get(311)).setAttribute("alt","" );
      ((Element)v.get(311)).setAttribute("codigo","" );
      ((Element)v.get(311)).setAttribute("accion","" );
      ((Element)v.get(12)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */

      /* Empieza nodo:312 / Elemento padre: 12   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(312)).setAttribute("nombre","btnModificar" );
      ((Element)v.get(312)).setAttribute("x","80" );
      ((Element)v.get(312)).setAttribute("y","621" );
      ((Element)v.get(312)).setAttribute("ID","botonContenido" );
      ((Element)v.get(312)).setAttribute("img","" );
      ((Element)v.get(312)).setAttribute("tipo","html" );
      ((Element)v.get(312)).setAttribute("estado","false" );
      ((Element)v.get(312)).setAttribute("cod","2" );
      ((Element)v.get(312)).setAttribute("accion","modificarFila();" );
      ((Element)v.get(312)).setAttribute("ontab","voyEjecutivosCuenta();" );
      ((Element)v.get(312)).setAttribute("onshtab","onshtab_btnModificar();" );
      ((Element)v.get(12)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */

      /* Empieza nodo:313 / Elemento padre: 12   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(313)).setAttribute("nombre","capaEspacio2" );
      ((Element)v.get(313)).setAttribute("alto","18" );
      ((Element)v.get(313)).setAttribute("ancho","50" );
      ((Element)v.get(313)).setAttribute("colorf","" );
      ((Element)v.get(313)).setAttribute("x","0" );
      ((Element)v.get(313)).setAttribute("y","643" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(12)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */
      /* Termina nodo:12   */


   }

}
