
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_campana_recalcular  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_campana_recalcular" );
      ((Element)v.get(0)).setAttribute("cod","0303" );
      ((Element)v.get(0)).setAttribute("titulo","Simular Estimados Business Planning" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","loadpag();" );
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
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(5)).setAttribute("name","cbSubtipoCliente" );
      ((Element)v.get(5)).setAttribute("required","false" );
      ((Element)v.get(5)).setAttribute("cod","595" );
      ((Element)v.get(5)).setAttribute("group","grupo1" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(6)).setAttribute("name","cbTipoClasificacion" );
      ((Element)v.get(6)).setAttribute("required","false" );
      ((Element)v.get(6)).setAttribute("cod","756" );
      ((Element)v.get(6)).setAttribute("group","grupo1" );
      ((Element)v.get(4)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","cbClasificacion" );
      ((Element)v.get(7)).setAttribute("required","false" );
      ((Element)v.get(7)).setAttribute("cod","550" );
      ((Element)v.get(7)).setAttribute("group","grupo1" );
      ((Element)v.get(4)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","txtUnidadesPromedio" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","1017" );
      ((Element)v.get(8)).setAttribute("format","e" );
      ((Element)v.get(8)).setAttribute("min","0" );
      ((Element)v.get(8)).setAttribute("max","9999999999" );
      ((Element)v.get(8)).setAttribute("group","txtUnidadesPromedio" );
      ((Element)v.get(4)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","txtUnidadesTotales" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","1015" );
      ((Element)v.get(9)).setAttribute("format","e" );
      ((Element)v.get(9)).setAttribute("min","0" );
      ((Element)v.get(9)).setAttribute("max","9999999999" );
      ((Element)v.get(9)).setAttribute("group","txtUnidadesTotales" );
      ((Element)v.get(4)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */
      /* Termina nodo:4   */

      /* Empieza nodo:10 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(10));

      /* Elemento padre:10 / Elemento actual: 11   */
      v.add(doc.createTextNode("\r   \r\r  var varNoLimpiarSICC = true;\r\r  function loadpag(){\r    configurarMenuSecundario(\"formulario\");\r    poneSeleccionados();\r    subtipoClienteOnChange();\r    poneSeleccionados();\r    tipoClasificacionOnChange();\r    poneSeleccionados();\r    focoSubtipoCliente();\r\r	\r	 	 var campoDeshabilitar = get(\"formulario.campoDeshabilitar\");\r	 \r	 eval(\"accion('formulario.\" + campoDeshabilitar + \"', '.disabled=true');\");\r\r	 fMostrarMensajeError();\r\r\r  }\r\r  function poneSeleccionados() {\r    var subtipos = get ('formulario.codigos1');\r    var subtipo = new Array();\r    subtipo = subtipos.split(\"/\");\r\r    var tipoClasificacion = get ('formulario.codigos2');\r    var clasificacion = get ('formulario.codigos3');    \r\r    set('formulario.cbTipoClasificacion', new Array(tipoClasificacion));\r    set('formulario.cbClasificacion', new Array(clasificacion));\r    set('formulario.cbSubtipoCliente', subtipo);  \r  }\r\r  function fVolver() {    \r    window.close();\r  }  \r\r  function focoSubtipoCliente() {\r    focaliza(\"formulario.cbSubtipoCliente\");\r  }\r\r  function focoBotonRecalcular() {\r    focalizaBotonHTML('botonContenido','btnRecalcular');         \r  }\r\r  function accionRecalcular() {\r\r 	 	 var campoDeshabilitado = get(\"formulario.campoDeshabilitar\");\r	 var campoAValidar = \"\";\r	 if ( campoDeshabilitado == \"txtUnidadesPromedio\")\r		 campoAValidar = \"txtUnidadesTotales\";\r	 \r	 if ( campoDeshabilitado == \"txtUnidadesTotales\")\r 		 campoAValidar = \"txtUnidadesPromedio\";\r\r	 \r	 if ( sicc_validaciones_generales(\"grupo1\") && sicc_validaciones_generales(campoAValidar) )\r	 {\r      var codVenta = get('formulario.codVenta');\r      var idsSubtiposCliente = get('formulario.cbSubtipoCliente');\r      var idTipoClasificacion = get('formulario.cbTipoClasificacion');\r      var idClasificacion = get('formulario.cbClasificacion');\r      var valUnidadesPromedio = get('formulario.txtUnidadesPromedio');\r      var valUnidadesTotales = get('formulario.txtUnidadesTotales');\r      var oidDetalleMAV = get('formulario.oidDetalleMAV');      \r\r      set('formulario.codVenta',codVenta);\r      set('formulario.idsSubtiposCliente',idsSubtiposCliente);\r      set('formulario.idTipoClasificacion',idTipoClasificacion);\r      set('formulario.idClasificacion',idClasificacion);\r      set('formulario.valUnidadesPromedio',valUnidadesPromedio);\r      set('formulario.valUnidadesTotales',valUnidadesTotales);      \r      set('formulario.oidDetalleMAV',oidDetalleMAV);\r    \r      set('formulario.conectorAction', 'LPSimularEstimadosBP');\r      eval('formulario').oculto='S';\r      set('formulario.accion', 'recalcular');                \r      enviaSICC('formulario', null,  null, 'N');     \r    }   \r  }\r\r  function accionAceptar() {\r\r	 var campoDeshabilitado = get(\"formulario.campoDeshabilitar\");\r	 var campoAValidar = \"\";\r	 if ( campoDeshabilitado == \"txtUnidadesPromedio\")\r		 campoAValidar = \"txtUnidadesTotales\";\r	 \r	 if ( campoDeshabilitado == \"txtUnidadesTotales\")\r 		 campoAValidar = \"txtUnidadesPromedio\";\r\r	 if ( sicc_validaciones_generales(\"grupo1\") && sicc_validaciones_generales(campoAValidar) )\r	 {\r      var codVenta = get('formulario.codVenta');\r      var idsSubtiposCliente = get('formulario.cbSubtipoCliente');\r      var idTipoClasificacion = get('formulario.cbTipoClasificacion');\r      var idClasificacion = get('formulario.cbClasificacion');\r      var valUnidadesPromedio = get('formulario.txtUnidadesPromedio');\r      var valUnidadesTotales = get('formulario.txtUnidadesTotales');\r      var oidDetalleMAV = get('formulario.oidDetalleMAV');      \r\r      set('formulario.codVenta',codVenta);\r      set('formulario.idsSubtiposCliente',idsSubtiposCliente);\r      set('formulario.idTipoClasificacion',idTipoClasificacion);\r      set('formulario.idClasificacion',idClasificacion);\r      set('formulario.valUnidadesPromedio',valUnidadesPromedio);\r      set('formulario.valUnidadesTotales',valUnidadesTotales);      \r      set('formulario.oidDetalleMAV',oidDetalleMAV);\r    \r      set('formulario.conectorAction', 'LPSimularEstimadosBP');\r      eval('formulario').oculto='S';\r      set('formulario.accion', 'actualizar');                \r      enviaSICC('formulario', null,  null, 'N');     \r      \r    }   \r  }\r\r  function despuesAceptar(nuevosValores) {\r      window.close();  \r  }\r  \r  function accionAceptarOld() {\r    var array = new Array();\r    \r    var oiddetamav = get('formulario.tempoidDetaMAV');\r    var codsap = get('formulario.templbldtCodProducto');\r    var valcodivent = get('formulario.templbldtCodVenta');\r    var desproducto = get('formulario.templbldtDescripcionProducto');\r    var dessubtipocliente = get('formulario.tempcbSubtipoCliente');\r    var tipoclasificacion = get('formulario.tempcbTipoClasificacion');\r    var clasificacion = get('formulario.tempcbClasificacion');\r    var clientesestimados = get('formulario.templbldtNumClientesEstimados');\r    var promedio = get('formulario.temptxtUnidadesPromedio');\r    var totales = get('formulario.temptxtUnidadesTotales');\r    var disponibles = get('formulario.templbldtUnidadesDisponibles');\r    var dessubc = get('formulario.templbldtCondicion');\r    var valcond = get('formulario.templbldtValorCondicion');\r    var oidtipoclasificacion = get('formulario.tempoidTipoClasificacion');\r    var oidclasificacion = get('formulario.tempoidClasificacion');\r    var oidsubtipos = get('formulario.tempoidSubtipos');    \r\r    array[0]= oiddetamav;\r    array[1]= codsap;\r    array[2]= valcodivent;\r    array[3]= desproducto;\r    array[4]= dessubtipocliente;\r    array[5]= tipoclasificacion;\r    array[6]= clasificacion;\r    array[7]= clientesestimados;\r    array[8]= promedio;\r    array[9]= totales;\r    array[10]= disponibles;\r    array[11]= dessubc;\r    array[12]= valcond;\r    array[13]= oidtipoclasificacion;\r    array[14]= oidclasificacion;\r    array[15]= oidsubtipos;\r    array[16]= \"true\";\r\r    if(array[0]==\"\") {      \r      returnValue = null;  \r    }\r    else {\r      returnValue = array;  \r    }\r    window.close();\r  }\r\r  function subtipoClienteOnChange() {\r    var idSubtipo = get('formulario.cbSubtipoCliente');    \r    var nuevosValores = new Array();\r    var longTipoCla = listaTipoClasificacion.datos.longitud;\r    var i=0;\r	      \r    for (var j = 0; j < longTipoCla; j++)		{\r      for(var h = 0; h < idSubtipo.length; h++) {\r        if(listaTipoClasificacion.datos.ij(j, 1)==idSubtipo[h]) {\r          if(i==0) {\r            var nuevoRegistro = new Array();\r            nuevoRegistro[0] = \"\"; \r            nuevoRegistro[1] = \"\";\r            nuevosValores[i] = nuevoRegistro;\r            i++;\r          }\r          var oid = listaTipoClasificacion.datos.ij(j, 0);\r          var des = listaTipoClasificacion.datos.ij(j, 2);\r          var nuevoRegistro = new Array();\r          nuevoRegistro[0] = oid; \r          nuevoRegistro[1] = des;\r          nuevosValores[i] = nuevoRegistro;         \r          i++;\r        }    \r      }\r    }\r    \r    set_combo(\"formulario.cbTipoClasificacion\",nuevosValores);\r    var arrayVacio = new Array();\r    set_combo(\"formulario.cbClasificacion\",arrayVacio);\r  }\r\r  function tipoClasificacionOnChange() {\r    var idTipoClasificacion = get('formulario.cbTipoClasificacion');\r    var nuevosValores = new Array();\r    var longCla = listaClasificacion.datos.longitud;\r    var i=0;\r	      \r    for (var j = 0; j < longCla; j++)		{\r      if(listaClasificacion.datos.ij(j, 1)==idTipoClasificacion) {\r        if(i==0) {\r          var nuevoRegistro = new Array();\r          nuevoRegistro[0] = \"\"; \r          nuevoRegistro[1] = \"\";\r          nuevosValores[i] = nuevoRegistro;\r          i++;\r        }\r        var oid = listaClasificacion.datos.ij(j, 0);\r        var des = listaClasificacion.datos.ij(j, 2);\r        var nuevoRegistro = new Array();\r        nuevoRegistro[0] = oid; \r        nuevoRegistro[1] = des;\r        nuevosValores[i] = nuevoRegistro;         \r        i++;\r      }\r	  }  \r    set_combo(\"formulario.cbClasificacion\",nuevosValores);\r  }\r\r  function despuesRecalcular(nuevosValores) {\r    var valores = nuevosValores.split(\",\");\r\r    var valorCondicion = valores[0];    \r    var condicion = valores[1];\r    var unidadesTotales = valores[2];\r    var unidadesDisponibles = valores[3];\r    var unidadesPromedio = valores[4];\r    var clientesEstimados = valores[5];\r    var clasificacion = valores[6];\r    var tipoClasificacion = valores[7];\r    var idsSub = valores[8];\r    var descripcionProducto = valores[9];\r    var codigoVenta = valores[10];\r    var codigoSAP = valores[11];\r    var oidDetalleMAV = valores[12];\r \r    var cadaIDSubtipo = idsSub.split(\"/\");\r\r    if(valorCondicion==\"null\") valorCondicion=\"\";\r    if(condicion==\"null\") condicion=\"\";\r    if(unidadesTotales==\"null\") unidadesTotales=\"\";\r    if(unidadesDisponibles==\"null\") unidadesDisponibles=\"\";\r    if(unidadesPromedio==\"null\") unidadesPromedio=\"\";\r    if(clientesEstimados==\"null\") clientesEstimados=\"\";\r    if(clasificacion==\"null\") clasificacion=\"\";\r    if(tipoClasificacion==\"null\") tipoClasificacion=\"\";\r    if(idsSub==\"null\") idsSub=\"\";\r    if(descripcionProducto==\"null\") descripcionProducto=\"\";\r    if(codigoVenta==\"null\") codigoVenta=\"\";\r    if(codigoSAP==\"null\") codigoSAP=\"\";\r    if(oidDetalleMAV==\"null\") oidDetalleMAV=\"\";\r\r    \r    var longitud = combo_get('formulario.cbTipoClasificacion','L');\r    var seluno = get('formulario.cbTipoClasificacion');\r    var textCbTipo = \"\";\r\r    for(var i=0; i<longitud; i++) {      \r      var seldos = combo_get('formulario.cbTipoClasificacion','V', i);\r\r      if(seluno==seldos) {\r        textCbTipo = combo_get('formulario.cbTipoClasificacion','T', i);      \r      }\r    }\r\r    \r    var longitud = combo_get('formulario.cbClasificacion','L');\r    var seluno = get('formulario.cbClasificacion');\r    var textCbClasi = \"\";\r\r    for(var i=0; i<longitud; i++) {      \r      var seldos = combo_get('formulario.cbClasificacion','V', i);\r\r      if(seluno==seldos) {\r        textCbClasi = combo_get('formulario.cbClasificacion','T', i);      \r      }\r    }\r\r        \r    var longitud = combo_get('formulario.cbSubtipoCliente','L');\r    var seluno = get('formulario.cbSubtipoCliente');\r    var textSubtipo = \"\";\r\r    for(var j=0; j<seluno.length; j++) {\r      for(var i=0; i<longitud; i++) {\r        var seldos = combo_get('formulario.cbSubtipoCliente','V', i);\r        if(seluno[j]==seldos) {\r          if(textSubtipo==\"\") {\r            textSubtipo = combo_get('formulario.cbSubtipoCliente','T', i);\r          }\r          else {\r            textSubtipo = textSubtipo + \" / \"  + combo_get('formulario.cbSubtipoCliente','T', i);\r          }              \r        }\r      }   \r    }    \r\r    set(\"formulario.tempoidDetaMAV\", oidDetalleMAV);\r    set(\"formulario.templbldtCodProducto\", codigoSAP);\r    set(\"formulario.templbldtCodVenta\", codigoVenta);\r    set(\"formulario.templbldtDescripcionProducto\", descripcionProducto);\r    set(\"formulario.tempcbSubtipoCliente\", textSubtipo);\r    set(\"formulario.tempcbTipoClasificacion\", textCbTipo);\r    set(\"formulario.tempcbClasificacion\", textCbClasi);\r    set(\"formulario.templbldtNumClientesEstimados\", clientesEstimados);\r    set(\"formulario.temptxtUnidadesPromedio\", unidadesPromedio);\r    set(\"formulario.temptxtUnidadesTotales\", unidadesTotales);\r    set(\"formulario.templbldtUnidadesDisponibles\", unidadesDisponibles);\r    set(\"formulario.templbldtCondicion\", condicion);\r    set(\"formulario.templbldtValorCondicion\", valorCondicion);\r    set(\"formulario.tempoidTipoClasificacion\", tipoClasificacion);\r    set(\"formulario.tempoidClasificacion\", clasificacion);\r    set(\"formulario.tempoidSubtipos\", idsSub);    \r\r    txt_to(\"lbldtCodProducto\", codigoSAP);\r    txt_to(\"lbldtCodVenta\", codigoVenta);\r    txt_to(\"lbldtDescripcionProducto\", descripcionProducto);\r    txt_to(\"lbldtNumClientesEstimados\", clientesEstimados);\r    txt_to(\"lbldtUnidadesDisponibles\", unidadesDisponibles);\r    txt_to(\"lbldtCondicion\", condicion);\r    txt_to(\"lbldtValorCondicion\", valorCondicion);   \r\r 	 	 var campoDeshabilitado = get(\"formulario.campoDeshabilitar\");\r	 var campoAValidar = \"\";\r	 if ( campoDeshabilitado == \"txtUnidadesPromedio\")\r		 set(\"formulario.txtUnidadesPromedio\", unidadesPromedio);\r	 \r	 if ( campoDeshabilitado == \"txtUnidadesTotales\")\r 		 set(\"formulario.txtUnidadesTotales\", unidadesTotales);\r\r	 \r/*    set(\"formulario.txtUnidadesPromedio\", unidadesPromedio);\r    set(\"formulario.txtUnidadesTotales\", unidadesTotales);*/\r\r    set('formulario.cbSubtipoCliente', cadaIDSubtipo);\r    set('formulario.cbTipoClasificacion', new Array(tipoClasificacion));\r    set('formulario.cbClasificacion', new Array(clasificacion));         \r\r    eval(\"formulario\").oculto= 'N';\r    focoSubtipoCliente();\r  }\r\r  function fLimpiar() {  \r    poneSeleccionados();\r    subtipoClienteOnChange();\r    poneSeleccionados();\r    tipoClasificacionOnChange();\r    poneSeleccionados();\r\r    var cliEsti = get('formulario.cliEsti');\r    var uniPro = get('formulario.uniPro');\r    var uniTot = get('formulario.uniTot');\r    var uniDis = get('formulario.uniDis');    \r    var condi = get('formulario.condi');    \r    var valCondi = get('formulario.valCondi');    \r\r    txt_to(\"lbldtNumClientesEstimados\", cliEsti);\r    txt_to(\"lbldtUnidadesDisponibles\", uniDis);\r    txt_to(\"lbldtCondicion\", condi);\r    txt_to(\"lbldtValorCondicion\", valCondi);\r    \r    set(\"formulario.txtUnidadesPromedio\", uniPro);\r    set(\"formulario.txtUnidadesTotales\", uniTot);\r\r    focoSubtipoCliente();\r  }\r   \r   \r"));
      ((Element)v.get(10)).appendChild((Text)v.get(11));

      /* Termina nodo Texto:11   */
      /* Termina nodo:10   */

      /* Empieza nodo:12 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(12)).setAttribute("nombre","formulario" );
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
      ((Element)v.get(15)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","idioma" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","pais" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","marca" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","tip_cli" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","actividad" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","campana" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","seleccion" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","codigos1" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","codigos2" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","codigos3" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","oid_det" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","idsSubtiposCliente" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","idTipoClasificacion" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","idClasificacion" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","valUnidadesPromedio" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","valUnidadesTotales" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","oidDetalleMAV" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","codVenta" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","valorCondicion" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","condicion" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","unidadesTotales" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","unidadesDisponibles" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","unidadesPromedio" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","clientesEstimados" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 12   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","clasificacion" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","tipoClasificacion" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","descripcionProducto" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","codigoVenta" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","codigoSAP" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","oidDetalleMAV" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","tempoidDetaMAV" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","templbldtCodProducto" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","templbldtCodVenta" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","templbldtDescripcionProducto" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","tempcbSubtipoCliente" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","tempcbTipoClasificacion" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(54)).setAttribute("nombre","tempcbClasificacion" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(55)).setAttribute("nombre","templbldtNumClientesEstimados" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(56)).setAttribute("nombre","temptxtUnidadesPromedio" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(57)).setAttribute("nombre","temptxtUnidadesTotales" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(58)).setAttribute("nombre","templbldtUnidadesDisponibles" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(59)).setAttribute("nombre","templbldtCondicion" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(60)).setAttribute("nombre","templbldtValorCondicion" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(61)).setAttribute("nombre","tempoidTipoClasificacion" );
      ((Element)v.get(61)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(62)).setAttribute("nombre","tempoidClasificacion" );
      ((Element)v.get(62)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(63)).setAttribute("nombre","tempoidSubtipos" );
      ((Element)v.get(63)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(64)).setAttribute("nombre","cliEsti" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */

      /* Empieza nodo:65 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(65)).setAttribute("nombre","uniPro" );
      ((Element)v.get(65)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */

      /* Empieza nodo:66 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(66)).setAttribute("nombre","uniTot" );
      ((Element)v.get(66)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(67)).setAttribute("nombre","uniDis" );
      ((Element)v.get(67)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */

      /* Empieza nodo:68 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(68)).setAttribute("nombre","condi" );
      ((Element)v.get(68)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */

      /* Empieza nodo:69 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(69)).setAttribute("nombre","valCondi" );
      ((Element)v.get(69)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */

      /* Empieza nodo:70 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(70)).setAttribute("nombre","campoDeshabilitar" );
      ((Element)v.get(70)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 12   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(71)).setAttribute("nombre","capa1" );
      ((Element)v.get(12)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("table"));
      ((Element)v.get(72)).setAttribute("width","100%" );
      ((Element)v.get(72)).setAttribute("border","0" );
      ((Element)v.get(72)).setAttribute("cellspacing","0" );
      ((Element)v.get(72)).setAttribute("cellpadding","0" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).setAttribute("width","12" );
      ((Element)v.get(74)).setAttribute("align","center" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(75)).setAttribute("width","12" );
      ((Element)v.get(75)).setAttribute("height","12" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).setAttribute("width","750" );
      ((Element)v.get(73)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(77)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).setAttribute("width","12" );
      ((Element)v.get(73)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","12" );
      ((Element)v.get(79)).setAttribute("height","1" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:73   */

      /* Empieza nodo:80 / Elemento padre: 72   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(72)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(85)).setAttribute("class","legend" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(86)).setAttribute("nombre","lblDetalleCampana" );
      ((Element)v.get(86)).setAttribute("alto","13" );
      ((Element)v.get(86)).setAttribute("filas","1" );
      ((Element)v.get(86)).setAttribute("id","legend" );
      ((Element)v.get(86)).setAttribute("cod","00169" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 84   */
      v.add(doc.createElement("table"));
      ((Element)v.get(87)).setAttribute("width","100%" );
      ((Element)v.get(87)).setAttribute("border","0" );
      ((Element)v.get(87)).setAttribute("align","center" );
      ((Element)v.get(87)).setAttribute("cellspacing","0" );
      ((Element)v.get(87)).setAttribute("cellpadding","0" );
      ((Element)v.get(84)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("table"));
      ((Element)v.get(90)).setAttribute("width","455" );
      ((Element)v.get(90)).setAttribute("border","0" );
      ((Element)v.get(90)).setAttribute("align","left" );
      ((Element)v.get(90)).setAttribute("cellspacing","0" );
      ((Element)v.get(90)).setAttribute("cellpadding","0" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(90)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).setAttribute("colspan","4" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","b.gif" );
      ((Element)v.get(93)).setAttribute("width","8" );
      ((Element)v.get(93)).setAttribute("height","8" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:94 / Elemento padre: 90   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(90)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(96)).setAttribute("src","b.gif" );
      ((Element)v.get(96)).setAttribute("width","8" );
      ((Element)v.get(96)).setAttribute("height","8" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:97 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(98)).setAttribute("nombre","lblCodProducto" );
      ((Element)v.get(98)).setAttribute("alto","13" );
      ((Element)v.get(98)).setAttribute("filas","1" );
      ((Element)v.get(98)).setAttribute("id","datosTitle" );
      ((Element)v.get(98)).setAttribute("cod","337" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:99 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(100)).setAttribute("src","b.gif" );
      ((Element)v.get(100)).setAttribute("width","25" );
      ((Element)v.get(100)).setAttribute("height","8" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:101 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(102)).setAttribute("nombre","lblCodVenta" );
      ((Element)v.get(102)).setAttribute("alto","13" );
      ((Element)v.get(102)).setAttribute("filas","1" );
      ((Element)v.get(102)).setAttribute("id","datosTitle" );
      ((Element)v.get(102)).setAttribute("cod","336" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(104)).setAttribute("width","25" );
      ((Element)v.get(104)).setAttribute("height","8" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(106)).setAttribute("nombre","lblDescripcionProducto" );
      ((Element)v.get(106)).setAttribute("alto","13" );
      ((Element)v.get(106)).setAttribute("filas","1" );
      ((Element)v.get(106)).setAttribute("id","datosTitle" );
      ((Element)v.get(106)).setAttribute("cod","338" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:107 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).setAttribute("width","100%" );
      ((Element)v.get(94)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(108)).setAttribute("src","b.gif" );
      ((Element)v.get(108)).setAttribute("width","8" );
      ((Element)v.get(108)).setAttribute("height","8" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */
      /* Termina nodo:94   */

      /* Empieza nodo:109 / Elemento padre: 90   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(90)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(111)).setAttribute("src","b.gif" );
      ((Element)v.get(111)).setAttribute("width","8" );
      ((Element)v.get(111)).setAttribute("height","8" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:112 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(113)).setAttribute("nombre","lbldtCodProducto" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(113)).setAttribute("alto","13" );
      ((Element)v.get(113)).setAttribute("filas","1" );
      ((Element)v.get(113)).setAttribute("id","datosCampos" );
      ((Element)v.get(113)).setAttribute("valor","" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:114 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(115)).setAttribute("src","b.gif" );
      ((Element)v.get(115)).setAttribute("width","25" );
      ((Element)v.get(115)).setAttribute("height","8" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:116 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(117)).setAttribute("nombre","lbldtCodVenta" );
      ((Element)v.get(117)).setAttribute("alto","13" );
      ((Element)v.get(117)).setAttribute("filas","1" );
      ((Element)v.get(117)).setAttribute("id","datosCampos" );
      ((Element)v.get(117)).setAttribute("valor","" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(119)).setAttribute("src","b.gif" );
      ((Element)v.get(119)).setAttribute("width","25" );
      ((Element)v.get(119)).setAttribute("height","8" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:120 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(121)).setAttribute("nombre","lbldtDescripcionProducto" );
      ((Element)v.get(121)).setAttribute("alto","13" );
      ((Element)v.get(121)).setAttribute("filas","1" );
      ((Element)v.get(121)).setAttribute("id","datosCampos" );
      ((Element)v.get(121)).setAttribute("valor","" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:122 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).setAttribute("width","100%" );
      ((Element)v.get(109)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(123)).setAttribute("src","b.gif" );
      ((Element)v.get(123)).setAttribute("width","8" );
      ((Element)v.get(123)).setAttribute("height","8" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */
      /* Termina nodo:109   */

      /* Empieza nodo:124 / Elemento padre: 90   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(90)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).setAttribute("colspan","4" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(126)).setAttribute("src","b.gif" );
      ((Element)v.get(126)).setAttribute("width","8" );
      ((Element)v.get(126)).setAttribute("height","8" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:90   */
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:127 / Elemento padre: 87   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(87)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("table"));
      ((Element)v.get(129)).setAttribute("width","455" );
      ((Element)v.get(129)).setAttribute("border","0" );
      ((Element)v.get(129)).setAttribute("align","left" );
      ((Element)v.get(129)).setAttribute("cellspacing","0" );
      ((Element)v.get(129)).setAttribute("cellpadding","0" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(132)).setAttribute("src","b.gif" );
      ((Element)v.get(132)).setAttribute("width","8" );
      ((Element)v.get(132)).setAttribute("height","8" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:133 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(134)).setAttribute("nombre","lblSubtipoCliente" );
      ((Element)v.get(134)).setAttribute("alto","13" );
      ((Element)v.get(134)).setAttribute("filas","1" );
      ((Element)v.get(134)).setAttribute("id","datosTitle" );
      ((Element)v.get(134)).setAttribute("cod","595" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:135 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(136)).setAttribute("src","b.gif" );
      ((Element)v.get(136)).setAttribute("width","25" );
      ((Element)v.get(136)).setAttribute("height","8" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:137 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(138)).setAttribute("nombre","lblTipoClasificacion" );
      ((Element)v.get(138)).setAttribute("alto","13" );
      ((Element)v.get(138)).setAttribute("filas","1" );
      ((Element)v.get(138)).setAttribute("id","datosTitle" );
      ((Element)v.get(138)).setAttribute("cod","756" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:139 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).setAttribute("width","100%" );
      ((Element)v.get(130)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(140)).setAttribute("src","b.gif" );
      ((Element)v.get(140)).setAttribute("width","8" );
      ((Element)v.get(140)).setAttribute("height","8" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */
      /* Termina nodo:130   */

      /* Empieza nodo:141 / Elemento padre: 129   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(129)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("td"));
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(143)).setAttribute("src","b.gif" );
      ((Element)v.get(143)).setAttribute("width","8" );
      ((Element)v.get(143)).setAttribute("height","8" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */

      /* Empieza nodo:144 / Elemento padre: 141   */
      v.add(doc.createElement("td"));
      ((Element)v.get(144)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(141)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(145)).setAttribute("nombre","cbSubtipoCliente" );
      ((Element)v.get(145)).setAttribute("size","5" );
      ((Element)v.get(145)).setAttribute("multiple","S" );
      ((Element)v.get(145)).setAttribute("valorinicial","" );
      ((Element)v.get(145)).setAttribute("textoinicial","" );
      ((Element)v.get(145)).setAttribute("id","datosCampos" );
      ((Element)v.get(145)).setAttribute("req","N" );
      ((Element)v.get(145)).setAttribute("onshtab","focoBotonRecalcular();" );
      ((Element)v.get(145)).setAttribute("onchange","subtipoClienteOnChange();" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:144   */

      /* Empieza nodo:147 / Elemento padre: 141   */
      v.add(doc.createElement("td"));
      ((Element)v.get(141)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(148)).setAttribute("src","b.gif" );
      ((Element)v.get(148)).setAttribute("width","25" );
      ((Element)v.get(148)).setAttribute("height","8" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */

      /* Empieza nodo:149 / Elemento padre: 141   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(149)).setAttribute("valign","top" );
      ((Element)v.get(141)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(150)).setAttribute("nombre","cbTipoClasificacion" );
      ((Element)v.get(150)).setAttribute("size","1" );
      ((Element)v.get(150)).setAttribute("multiple","N" );
      ((Element)v.get(150)).setAttribute("valorinicial","" );
      ((Element)v.get(150)).setAttribute("textoinicial","" );
      ((Element)v.get(150)).setAttribute("id","datosCampos" );
      ((Element)v.get(150)).setAttribute("req","N" );
      ((Element)v.get(150)).setAttribute("onchange","tipoClasificacionOnChange();" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */
      /* Termina nodo:149   */

      /* Empieza nodo:152 / Elemento padre: 141   */
      v.add(doc.createElement("td"));
      ((Element)v.get(152)).setAttribute("width","100%" );
      ((Element)v.get(141)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(153)).setAttribute("src","b.gif" );
      ((Element)v.get(153)).setAttribute("width","8" );
      ((Element)v.get(153)).setAttribute("height","8" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:141   */

      /* Empieza nodo:154 / Elemento padre: 129   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(129)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(155)).setAttribute("colspan","4" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","b.gif" );
      ((Element)v.get(156)).setAttribute("width","8" );
      ((Element)v.get(156)).setAttribute("height","8" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */
      /* Termina nodo:154   */
      /* Termina nodo:129   */
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:157 / Elemento padre: 87   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(87)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("table"));
      ((Element)v.get(159)).setAttribute("width","455" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(159)).setAttribute("border","0" );
      ((Element)v.get(159)).setAttribute("align","left" );
      ((Element)v.get(159)).setAttribute("cellspacing","0" );
      ((Element)v.get(159)).setAttribute("cellpadding","0" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(159)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(162)).setAttribute("src","b.gif" );
      ((Element)v.get(162)).setAttribute("width","8" );
      ((Element)v.get(162)).setAttribute("height","8" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:163 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(164)).setAttribute("nombre","lblClasificacion" );
      ((Element)v.get(164)).setAttribute("alto","13" );
      ((Element)v.get(164)).setAttribute("filas","1" );
      ((Element)v.get(164)).setAttribute("id","datosTitle" );
      ((Element)v.get(164)).setAttribute("cod","550" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:165 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(166)).setAttribute("src","b.gif" );
      ((Element)v.get(166)).setAttribute("width","25" );
      ((Element)v.get(166)).setAttribute("height","8" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:167 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(168)).setAttribute("nombre","lblNumClientesEstimados" );
      ((Element)v.get(168)).setAttribute("alto","13" );
      ((Element)v.get(168)).setAttribute("filas","1" );
      ((Element)v.get(168)).setAttribute("id","datosTitle" );
      ((Element)v.get(168)).setAttribute("cod","931" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */

      /* Empieza nodo:169 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(170)).setAttribute("src","b.gif" );
      ((Element)v.get(170)).setAttribute("width","25" );
      ((Element)v.get(170)).setAttribute("height","8" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:171 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(172)).setAttribute("nombre","lblUnidadesPromedio" );
      ((Element)v.get(172)).setAttribute("alto","13" );
      ((Element)v.get(172)).setAttribute("filas","1" );
      ((Element)v.get(172)).setAttribute("id","datosTitle" );
      ((Element)v.get(172)).setAttribute("cod","1017" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */

      /* Empieza nodo:173 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(174)).setAttribute("src","b.gif" );
      ((Element)v.get(174)).setAttribute("width","25" );
      ((Element)v.get(174)).setAttribute("height","8" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */

      /* Empieza nodo:175 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(176)).setAttribute("nombre","lblUnidadesTotales" );
      ((Element)v.get(176)).setAttribute("alto","13" );
      ((Element)v.get(176)).setAttribute("filas","1" );
      ((Element)v.get(176)).setAttribute("id","datosTitle" );
      ((Element)v.get(176)).setAttribute("cod","1015" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:177 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).setAttribute("width","100%" );
      ((Element)v.get(160)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(178)).setAttribute("src","b.gif" );
      ((Element)v.get(178)).setAttribute("width","8" );
      ((Element)v.get(178)).setAttribute("height","8" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */
      /* Termina nodo:160   */

      /* Empieza nodo:179 / Elemento padre: 159   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(159)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(179)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(181)).setAttribute("src","b.gif" );
      ((Element)v.get(181)).setAttribute("width","8" );
      ((Element)v.get(181)).setAttribute("height","8" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */

      /* Empieza nodo:182 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(182)).setAttribute("nowrap","nowrap" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(179)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(183)).setAttribute("nombre","cbClasificacion" );
      ((Element)v.get(183)).setAttribute("size","1" );
      ((Element)v.get(183)).setAttribute("multiple","N" );
      ((Element)v.get(183)).setAttribute("valorinicial","" );
      ((Element)v.get(183)).setAttribute("textoinicial","" );
      ((Element)v.get(183)).setAttribute("id","datosCampos" );
      ((Element)v.get(183)).setAttribute("req","N" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */
      /* Termina nodo:182   */

      /* Empieza nodo:185 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(179)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(186)).setAttribute("src","b.gif" );
      ((Element)v.get(186)).setAttribute("width","25" );
      ((Element)v.get(186)).setAttribute("height","8" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:187 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(179)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(188)).setAttribute("nombre","lbldtNumClientesEstimados" );
      ((Element)v.get(188)).setAttribute("alto","13" );
      ((Element)v.get(188)).setAttribute("filas","1" );
      ((Element)v.get(188)).setAttribute("id","datosCampos" );
      ((Element)v.get(188)).setAttribute("valor","" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:189 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(179)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(190)).setAttribute("src","b.gif" );
      ((Element)v.get(190)).setAttribute("width","25" );
      ((Element)v.get(190)).setAttribute("height","8" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:191 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(191)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(179)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(192)).setAttribute("nombre","txtUnidadesPromedio" );
      ((Element)v.get(192)).setAttribute("id","datosCampos" );
      ((Element)v.get(192)).setAttribute("max","10" );
      ((Element)v.get(192)).setAttribute("tipo","" );
      ((Element)v.get(192)).setAttribute("onchange","" );
      ((Element)v.get(192)).setAttribute("req","N" );
      ((Element)v.get(192)).setAttribute("size","10" );
      ((Element)v.get(192)).setAttribute("valor","" );
      ((Element)v.get(192)).setAttribute("validacion","" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */

      /* Empieza nodo:193 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(179)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(194)).setAttribute("src","b.gif" );
      ((Element)v.get(194)).setAttribute("width","25" );
      ((Element)v.get(194)).setAttribute("height","8" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */

      /* Empieza nodo:195 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(195)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(179)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(196)).setAttribute("nombre","txtUnidadesTotales" );
      ((Element)v.get(196)).setAttribute("id","datosCampos" );
      ((Element)v.get(196)).setAttribute("max","10" );
      ((Element)v.get(196)).setAttribute("tipo","" );
      ((Element)v.get(196)).setAttribute("onchange","" );
      ((Element)v.get(196)).setAttribute("req","N" );
      ((Element)v.get(196)).setAttribute("size","10" );
      ((Element)v.get(196)).setAttribute("valor","" );
      ((Element)v.get(196)).setAttribute("validacion","" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */

      /* Empieza nodo:197 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(197)).setAttribute("width","100%" );
      ((Element)v.get(179)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(198)).setAttribute("src","b.gif" );
      ((Element)v.get(198)).setAttribute("width","8" );
      ((Element)v.get(198)).setAttribute("height","8" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */
      /* Termina nodo:179   */

      /* Empieza nodo:199 / Elemento padre: 159   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(159)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(200)).setAttribute("colspan","4" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(201)).setAttribute("src","b.gif" );
      ((Element)v.get(201)).setAttribute("width","8" );
      ((Element)v.get(201)).setAttribute("height","8" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */
      /* Termina nodo:199   */
      /* Termina nodo:159   */
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:202 / Elemento padre: 87   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(87)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
   }

   private void getXML810(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(202)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("table"));
      ((Element)v.get(204)).setAttribute("width","455" );
      ((Element)v.get(204)).setAttribute("border","0" );
      ((Element)v.get(204)).setAttribute("align","left" );
      ((Element)v.get(204)).setAttribute("cellspacing","0" );
      ((Element)v.get(204)).setAttribute("cellpadding","0" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(204)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(207)).setAttribute("src","b.gif" );
      ((Element)v.get(207)).setAttribute("width","8" );
      ((Element)v.get(207)).setAttribute("height","8" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:208 / Elemento padre: 205   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(209)).setAttribute("nombre","lblUnidadesDisponibles" );
      ((Element)v.get(209)).setAttribute("alto","13" );
      ((Element)v.get(209)).setAttribute("filas","1" );
      ((Element)v.get(209)).setAttribute("id","datosTitle" );
      ((Element)v.get(209)).setAttribute("cod","1011" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:210 / Elemento padre: 205   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(211)).setAttribute("src","b.gif" );
      ((Element)v.get(211)).setAttribute("width","25" );
      ((Element)v.get(211)).setAttribute("height","8" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:212 / Elemento padre: 205   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(213)).setAttribute("nombre","lblCondicion" );
      ((Element)v.get(213)).setAttribute("alto","13" );
      ((Element)v.get(213)).setAttribute("filas","1" );
      ((Element)v.get(213)).setAttribute("id","datosTitle" );
      ((Element)v.get(213)).setAttribute("cod","1376" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:212   */

      /* Empieza nodo:214 / Elemento padre: 205   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(215)).setAttribute("src","b.gif" );
      ((Element)v.get(215)).setAttribute("width","25" );
      ((Element)v.get(215)).setAttribute("height","8" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:214   */

      /* Empieza nodo:216 / Elemento padre: 205   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(217)).setAttribute("nombre","lblValorCondicion" );
      ((Element)v.get(217)).setAttribute("alto","13" );
      ((Element)v.get(217)).setAttribute("filas","1" );
      ((Element)v.get(217)).setAttribute("id","datosTitle" );
      ((Element)v.get(217)).setAttribute("cod","1377" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:216   */

      /* Empieza nodo:218 / Elemento padre: 205   */
      v.add(doc.createElement("td"));
      ((Element)v.get(218)).setAttribute("width","100%" );
      ((Element)v.get(205)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(219)).setAttribute("src","b.gif" );
      ((Element)v.get(219)).setAttribute("width","8" );
      ((Element)v.get(219)).setAttribute("height","8" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */
      /* Termina nodo:205   */

      /* Empieza nodo:220 / Elemento padre: 204   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(204)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("td"));
      ((Element)v.get(220)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(222)).setAttribute("src","b.gif" );
      ((Element)v.get(222)).setAttribute("width","8" );
      ((Element)v.get(222)).setAttribute("height","8" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:221   */

      /* Empieza nodo:223 / Elemento padre: 220   */
      v.add(doc.createElement("td"));
      ((Element)v.get(220)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(224)).setAttribute("nombre","lbldtUnidadesDisponibles" );
      ((Element)v.get(224)).setAttribute("alto","13" );
      ((Element)v.get(224)).setAttribute("filas","1" );
      ((Element)v.get(224)).setAttribute("id","datosCampos" );
      ((Element)v.get(224)).setAttribute("valor","" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:223   */

      /* Empieza nodo:225 / Elemento padre: 220   */
      v.add(doc.createElement("td"));
      ((Element)v.get(220)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(226)).setAttribute("src","b.gif" );
      ((Element)v.get(226)).setAttribute("width","25" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(226)).setAttribute("height","8" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */
      /* Termina nodo:225   */

      /* Empieza nodo:227 / Elemento padre: 220   */
      v.add(doc.createElement("td"));
      ((Element)v.get(220)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(228)).setAttribute("nombre","lbldtCondicion" );
      ((Element)v.get(228)).setAttribute("alto","13" );
      ((Element)v.get(228)).setAttribute("filas","1" );
      ((Element)v.get(228)).setAttribute("id","datosCampos" );
      ((Element)v.get(228)).setAttribute("valor","" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */
      /* Termina nodo:227   */

      /* Empieza nodo:229 / Elemento padre: 220   */
      v.add(doc.createElement("td"));
      ((Element)v.get(220)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(230)).setAttribute("src","b.gif" );
      ((Element)v.get(230)).setAttribute("width","25" );
      ((Element)v.get(230)).setAttribute("height","8" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */

      /* Empieza nodo:231 / Elemento padre: 220   */
      v.add(doc.createElement("td"));
      ((Element)v.get(220)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(232)).setAttribute("nombre","lbldtValorCondicion" );
      ((Element)v.get(232)).setAttribute("alto","13" );
      ((Element)v.get(232)).setAttribute("filas","1" );
      ((Element)v.get(232)).setAttribute("id","datosCampos" );
      ((Element)v.get(232)).setAttribute("valor","" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:231   */

      /* Empieza nodo:233 / Elemento padre: 220   */
      v.add(doc.createElement("td"));
      ((Element)v.get(233)).setAttribute("width","100%" );
      ((Element)v.get(220)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(234)).setAttribute("src","b.gif" );
      ((Element)v.get(234)).setAttribute("width","8" );
      ((Element)v.get(234)).setAttribute("height","8" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */
      /* Termina nodo:233   */
      /* Termina nodo:220   */

      /* Empieza nodo:235 / Elemento padre: 204   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(204)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("td"));
      ((Element)v.get(236)).setAttribute("colspan","4" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(237)).setAttribute("src","b.gif" );
      ((Element)v.get(237)).setAttribute("width","8" );
      ((Element)v.get(237)).setAttribute("height","8" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */
      /* Termina nodo:236   */
      /* Termina nodo:235   */
      /* Termina nodo:204   */
      /* Termina nodo:203   */
      /* Termina nodo:202   */
      /* Termina nodo:87   */
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:238 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(239)).setAttribute("src","b.gif" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */
      /* Termina nodo:238   */
      /* Termina nodo:80   */

      /* Empieza nodo:240 / Elemento padre: 72   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(72)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("td"));
      ((Element)v.get(240)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(242)).setAttribute("src","b.gif" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:241   */

      /* Empieza nodo:243 / Elemento padre: 240   */
      v.add(doc.createElement("td"));
      ((Element)v.get(240)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(243)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("table"));
      ((Element)v.get(245)).setAttribute("width","100%" );
      ((Element)v.get(245)).setAttribute("border","0" );
      ((Element)v.get(245)).setAttribute("align","center" );
      ((Element)v.get(245)).setAttribute("cellspacing","0" );
      ((Element)v.get(245)).setAttribute("cellpadding","0" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(245)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("td"));
      ((Element)v.get(247)).setAttribute("class","botonera" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(248)).setAttribute("nombre","btnAceptar" );
      ((Element)v.get(248)).setAttribute("ID","botonContenido" );
      ((Element)v.get(248)).setAttribute("tipo","html" );
      ((Element)v.get(248)).setAttribute("accion","accionAceptar();" );
      ((Element)v.get(248)).setAttribute("estado","false" );
      ((Element)v.get(248)).setAttribute("cod","12" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */

      /* Empieza nodo:249 / Elemento padre: 247   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(249)).setAttribute("nombre","btnRecalcular" );
      ((Element)v.get(249)).setAttribute("ID","botonContenido" );
      ((Element)v.get(249)).setAttribute("tipo","html" );
      ((Element)v.get(249)).setAttribute("accion","accionRecalcular();" );
      ((Element)v.get(249)).setAttribute("estado","false" );
      ((Element)v.get(249)).setAttribute("cod","978" );
      ((Element)v.get(249)).setAttribute("ontab","focoSubtipoCliente();" );
      ((Element)v.get(247)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:247   */
      /* Termina nodo:246   */
      /* Termina nodo:245   */
      /* Termina nodo:244   */
      /* Termina nodo:243   */

      /* Empieza nodo:250 / Elemento padre: 240   */
   }

   private void getXML990(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(240)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(251)).setAttribute("src","b.gif" );
      ((Element)v.get(251)).setAttribute("width","8" );
      ((Element)v.get(251)).setAttribute("height","12" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:250   */
      /* Termina nodo:240   */

      /* Empieza nodo:252 / Elemento padre: 72   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(72)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("td"));
      ((Element)v.get(253)).setAttribute("width","12" );
      ((Element)v.get(253)).setAttribute("align","center" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(254)).setAttribute("src","b.gif" );
      ((Element)v.get(254)).setAttribute("width","12" );
      ((Element)v.get(254)).setAttribute("height","12" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */
      /* Termina nodo:253   */

      /* Empieza nodo:255 / Elemento padre: 252   */
      v.add(doc.createElement("td"));
      ((Element)v.get(255)).setAttribute("width","756" );
      ((Element)v.get(252)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(256)).setAttribute("src","b.gif" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */
      /* Termina nodo:255   */

      /* Empieza nodo:257 / Elemento padre: 252   */
      v.add(doc.createElement("td"));
      ((Element)v.get(257)).setAttribute("width","12" );
      ((Element)v.get(252)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(258)).setAttribute("src","b.gif" );
      ((Element)v.get(258)).setAttribute("width","12" );
      ((Element)v.get(258)).setAttribute("height","1" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */
      /* Termina nodo:257   */
      /* Termina nodo:252   */
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:259 / Elemento padre: 12   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(259)).setAttribute("nombre","capaTipoClasificacion" );
      ((Element)v.get(259)).setAttribute("alto","10" );
      ((Element)v.get(259)).setAttribute("ancho","10" );
      ((Element)v.get(259)).setAttribute("colorf","" );
      ((Element)v.get(259)).setAttribute("borde","1" );
      ((Element)v.get(259)).setAttribute("imagenf","" );
      ((Element)v.get(259)).setAttribute("repeat","" );
      ((Element)v.get(259)).setAttribute("padding","" );
      ((Element)v.get(259)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(259)).setAttribute("contravsb","" );
      ((Element)v.get(259)).setAttribute("zindex","" );
      ((Element)v.get(259)).setAttribute("x","10" );
      ((Element)v.get(259)).setAttribute("y","10" );
      ((Element)v.get(12)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(260)).setAttribute("seleccion","boton" );
      ((Element)v.get(260)).setAttribute("nombre","listaTipoClasificacion" );
      ((Element)v.get(260)).setAttribute("ancho","582" );
      ((Element)v.get(260)).setAttribute("alto","150" );
      ((Element)v.get(260)).setAttribute("multisel","-1" );
      ((Element)v.get(260)).setAttribute("incy","1" );
      ((Element)v.get(260)).setAttribute("incx","10" );
      ((Element)v.get(260)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(260)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(260)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(260)).setAttribute("accion","" );
      ((Element)v.get(260)).setAttribute("sep","|" );
      ((Element)v.get(260)).setAttribute("pixelsborde","3" );
      ((Element)v.get(260)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(261)).setAttribute("nombre","cabecera" );
      ((Element)v.get(261)).setAttribute("height","20" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(262)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(262)).setAttribute("ancho","13" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */

      /* Empieza nodo:263 / Elemento padre: 261   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(263)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(263)).setAttribute("ancho","300" );
      ((Element)v.get(261)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(264)).setAttribute("nombre","lb1" );
      ((Element)v.get(264)).setAttribute("ancho","300" );
      ((Element)v.get(264)).setAttribute("alto","20" );
      ((Element)v.get(264)).setAttribute("filas","1" );
      ((Element)v.get(264)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(264)).setAttribute("valor","Divisiones Políticas" );
      ((Element)v.get(264)).setAttribute("enviaroculto","N" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */
      /* Termina nodo:263   */

      /* Empieza nodo:265 / Elemento padre: 261   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(265)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(265)).setAttribute("ancho","150" );
      ((Element)v.get(261)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(266)).setAttribute("nombre","lb2" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(266)).setAttribute("ancho","150" );
      ((Element)v.get(266)).setAttribute("alto","20" );
      ((Element)v.get(266)).setAttribute("filas","1" );
      ((Element)v.get(266)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(266)).setAttribute("valor","País 01" );
      ((Element)v.get(266)).setAttribute("enviaroculto","N" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */
      /* Termina nodo:265   */
      /* Termina nodo:261   */

      /* Empieza nodo:267 / Elemento padre: 260   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(267)).setAttribute("ancho","10" );
      ((Element)v.get(267)).setAttribute("filas","1" );
      ((Element)v.get(267)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(260)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(268)).setAttribute("ancho","13" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */

      /* Empieza nodo:269 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(269)).setAttribute("ancho","300" );
      ((Element)v.get(269)).setAttribute("caracteres","100" );
      ((Element)v.get(267)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */

      /* Empieza nodo:270 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(270)).setAttribute("ancho","150" );
      ((Element)v.get(270)).setAttribute("caracteres","30" );
      ((Element)v.get(267)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */
      /* Termina nodo:267   */

      /* Empieza nodo:271 / Elemento padre: 260   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(260)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */
      /* Termina nodo:260   */
      /* Termina nodo:259   */

      /* Empieza nodo:272 / Elemento padre: 12   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(272)).setAttribute("nombre","capaClasificacion" );
      ((Element)v.get(272)).setAttribute("alto","10" );
      ((Element)v.get(272)).setAttribute("ancho","10" );
      ((Element)v.get(272)).setAttribute("colorf","" );
      ((Element)v.get(272)).setAttribute("borde","1" );
      ((Element)v.get(272)).setAttribute("imagenf","" );
      ((Element)v.get(272)).setAttribute("repeat","" );
      ((Element)v.get(272)).setAttribute("padding","" );
      ((Element)v.get(272)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(272)).setAttribute("contravsb","" );
      ((Element)v.get(272)).setAttribute("zindex","" );
      ((Element)v.get(272)).setAttribute("x","10" );
      ((Element)v.get(272)).setAttribute("y","10" );
      ((Element)v.get(12)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(273)).setAttribute("seleccion","boton" );
      ((Element)v.get(273)).setAttribute("nombre","listaClasificacion" );
      ((Element)v.get(273)).setAttribute("ancho","582" );
      ((Element)v.get(273)).setAttribute("alto","150" );
      ((Element)v.get(273)).setAttribute("multisel","-1" );
      ((Element)v.get(273)).setAttribute("incy","1" );
      ((Element)v.get(273)).setAttribute("incx","10" );
      ((Element)v.get(273)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(273)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(273)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(273)).setAttribute("accion","" );
      ((Element)v.get(273)).setAttribute("sep","|" );
      ((Element)v.get(273)).setAttribute("pixelsborde","3" );
      ((Element)v.get(273)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(274)).setAttribute("nombre","cabecera" );
      ((Element)v.get(274)).setAttribute("height","20" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(275)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(275)).setAttribute("ancho","13" );
      ((Element)v.get(274)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */

      /* Empieza nodo:276 / Elemento padre: 274   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(276)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(276)).setAttribute("ancho","300" );
      ((Element)v.get(274)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(277)).setAttribute("nombre","lb1" );
      ((Element)v.get(277)).setAttribute("ancho","300" );
      ((Element)v.get(277)).setAttribute("alto","20" );
      ((Element)v.get(277)).setAttribute("filas","1" );
      ((Element)v.get(277)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(277)).setAttribute("valor","Divisiones Políticas" );
      ((Element)v.get(277)).setAttribute("enviaroculto","N" );
      ((Element)v.get(276)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */
      /* Termina nodo:276   */

      /* Empieza nodo:278 / Elemento padre: 274   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(278)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(278)).setAttribute("ancho","150" );
      ((Element)v.get(274)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(279)).setAttribute("nombre","lb2" );
      ((Element)v.get(279)).setAttribute("ancho","150" );
      ((Element)v.get(279)).setAttribute("alto","20" );
      ((Element)v.get(279)).setAttribute("filas","1" );
      ((Element)v.get(279)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(279)).setAttribute("valor","País 01" );
      ((Element)v.get(279)).setAttribute("enviaroculto","N" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */
      /* Termina nodo:278   */
      /* Termina nodo:274   */

      /* Empieza nodo:280 / Elemento padre: 273   */
   }

   private void getXML1170(Document doc) {
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(280)).setAttribute("ancho","10" );
      ((Element)v.get(280)).setAttribute("filas","1" );
      ((Element)v.get(280)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(273)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(281)).setAttribute("ancho","13" );
      ((Element)v.get(280)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */

      /* Empieza nodo:282 / Elemento padre: 280   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(282)).setAttribute("ancho","300" );
      ((Element)v.get(282)).setAttribute("caracteres","100" );
      ((Element)v.get(280)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */

      /* Empieza nodo:283 / Elemento padre: 280   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(283)).setAttribute("ancho","150" );
      ((Element)v.get(283)).setAttribute("caracteres","30" );
      ((Element)v.get(280)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */
      /* Termina nodo:280   */

      /* Empieza nodo:284 / Elemento padre: 273   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(273)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */
      /* Termina nodo:273   */
      /* Termina nodo:272   */
      /* Termina nodo:12   */


   }

}
