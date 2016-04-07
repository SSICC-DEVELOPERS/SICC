
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_kit_productos_insertar  implements es.indra.druida.base.ObjetoXML {
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
         

      getXML2430(doc);
         

      getXML2520(doc);
         

      getXML2610(doc);
         

      getXML2700(doc);
         

      getXML2790(doc);
         

      getXML2880(doc);
         

      getXML2970(doc);
         

      getXML3060(doc);
         

      getXML3150(doc);
         

      getXML3240(doc);
         

      getXML3330(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_kit_productos_insertar" );
      ((Element)v.get(0)).setAttribute("cod","0401" );
      ((Element)v.get(0)).setAttribute("titulo","Insertar kit de Productos" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Mantenimiento de kit de Productos" );
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
      ((Element)v.get(3)).setAttribute("src","i18NJS.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","validaciones_sicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Elemento padre:6 / Elemento actual: 7   */
      v.add(doc.createTextNode("\r   \r\rvar LPName = \"LPInsertarKit\";\rvar formName = \"frmKitProductos\";\rvar numDecimales = null;\rvar entornoSeparador = null;\rvar sizeOfCTEXT = 6;\rvar sizeInt = null;\rvar HR_DLG = true;\rvar use_case = null;\r\r\rfunction onLoadPag(){\r   configurarMenuSecundario(formName);   \r   var exito = _get(\"exito\");\r\r   if(exito == \"reload\"){\r           _set(\"exito\",\"LOAD\");\r           setTimeout(\"reload_kit('LPModificarKit')\",2000);\r   }\r\r   if(exito == \"reload_insert\"){\r           _set(\"exito\",\"LOAD\");\r           setTimeout(\"reload_kit('LPInsertarKit')\",2000);\r   } \r   if(chequeaErrores()){      \r            DrdEnsanchaConMargenDcho('listado1',38);\r      document.all[\"primera1Div\"].style.visibility='hidden';\r      document.all[\"ret1Div\"].style.visibility='hidden';\r      document.all[\"ava1Div\"].style.visibility='hidden';\r      eval (ON_RSZ);      \r\r           if(exito == \"TRUE_NO_DLG\"){\r                           fMostrarMensajeExito('insertar');\r           }	  \r           if(exito == \"TRUE\"){\r                    returnValue = \"update\";  close();\r           } else {\r                             completarComboTipo();\r                             use_case = _get(\"casoDeUso\");\r\r                             if(use_case == \"Modificar\" || use_case == \"Consultar\") {\r                                        LPName = \"LPModificarKit\";\r                                         setCombosOrig(); \r             asignarCombosPeriodos();\r                             }			 \r\r                             if(use_case == \"Insertar\") {\r                                  HR_DLG = false;\r                                         btnProxy(2, '0');\r                                                                                                                     _foc(\"cbMarca2\");\r                    cargaCanal(\"1\");\r                             }\r                             if((use_case == \"Modificar\") || (use_case == \"Insertar\")){\r                                      validarModificable(\"txtDescripcionSAP\");          <!-- 1 --> \r           validarModificable(\"txtCodigoAntiguo\");           <!-- 2 -->   \r                                             validarModificable(\"txtDescripcionCorta\");        <!-- 3 -->\r                                             validarModificable(\"rbIndicadorLote\");            <!-- 4 -->\r                                             validarModificable(\"cbIndicadorPS\");              <!-- 5 -->   \r                                             validarModificable(\"cbMarca\");                     <!-- 6 -->\r                                             validarModificable(\"cbUnidadNegocio\");            <!-- 7 --> \r                                             validarModificable(\"cbNegocio\");                   <!-- 8 -->     \r                                             validarModificable(\"cbGenerico\");                  <!-- 9 -->\r                                             validarModificable(\"cbSuperGenerico\");            <!-- 10 -->\r                                             validarModificable(\"txtJerarquia1\");              <!-- 11 -->           \r                                             validarModificable(\"txtJerarquia2\");              <!-- 12 -->\r                                             validarModificable(\"txtJerarquia3\");              <!-- 13 -->    \r                                             validarModificable(\"cbLinea\");                     <!-- 14 -->        \r                                             validarModificable(\"txtAtributo1\");                <!-- 15 -->\r                                             validarModificable(\"txtAtributo2\");                <!-- 16 -->\r                                             validarModificable(\"txtAtributo3\");                <!-- 17 -->     \r                                             validarModificable(\"txtDimensionAlto\");           <!-- 18 -->\r                                             validarModificable(\"txtDimensionLargo\");          <!-- 19 -->\r                                             validarModificable(\"txtDimensionAncho\");          <!-- 20 -->    \r                                             validarModificable(\"cbUnidadMedidaDimensiones\"); <!-- 21 -->\r                                             validarModificable(\"txtVolumen_modificable\");    <!-- 22 -->\r                                             validarModificable(\"cbUnidadMedidaVolumen\");     <!-- 23 -->   \r                                             validarModificable(\"txtPeso_modificable\");        <!-- 24 -->\r                                             validarModificable(\"cbUnidadMedidaPeso\");         <!-- 25 -->\r                                             validarModificable(\"txtUnidadesDentroPedido\");   <!-- 26 --> \r                                             validarModificable(\"txtUnidadesCaja\");            <!-- 27 -->\r                                             validarModificable(\"txtCosteEstandar\");           <!-- 28 -->\r                                             validarModificable(\"txtPrecioPosicionamiento\");  <!-- 29 -->\r                                             validarModificable(\"cbSituacion_modificable\");   <!-- 30 -->\r                                             validarModificable(\"cbEstatusProducto\");          <!-- 31 -->\r                                             validarModificable(\"cbIndicadorDentroCaja\");     <!-- 32 -->   \r                                             validarModificable(\"cbCodigoPagoFraccionado\");   <!-- 33 -->\r                                             validarModificable(\"txtPrecioCatalogo\");          <!-- 34 -->\r           validarModificable(\"txtGrupoArticulos\");\r                                             validarModificable(\"txtPrecioContable\");          <!-- 35 -->\r                                             btnProxy(3,'0');                                               btnProxy(7,'1');             btnProxy(8,'1');                                  btnProxy(9,'1');                                               set(formName + '.');\r                                      _foc(\"cbMarca2\");\r                                             LoadTableCache();\r                             }\r                             if(use_case == \"Consultar\") {\r                                      disable(\"txtCodigoSAP\");\r                                      disable(\"txtDescripcionSAP\");\r                                      disable(\"txtDescripcionCorta\");\r                                      disable(\"txtCodigoAntiguo\");\r                                      disable(\"txtDimensionAlto\");\r                                      disable(\"txtDimensionAncho\");\r                                      disable(\"txtDimensionLargo\");\r                                      disable(\"txtVolumen\");\r                                      disable(\"txtPeso\");\r                                      disable(\"txtCosteEstandar\");\r                                      disable(\"txtPrecioCatalogo\");\r           disable(\"txtGrupoArticulos\");\r                                      disable(\"txtPrecioContable\");\r                                      disable(\"txtPorcentajeUnidades\");\r                                      disable(\"txtUnidadesDentroPedido\");\r                                      disable(\"txtUnidadesCaja\");\r                                      disable(\"txtAtributo1\");\r                                      disable(\"txtAtributo2\");\r                                      disable(\"txtAtributo3\");\r                                      disable(\"txtJerarquia1\");\r                                      disable(\"txtJerarquia2\");\r                                      disable(\"txtJerarquia3\");\r                                      disable(\"cbCodigoPagoFraccionado\");\r                                      disable(\"txtCodigoImpuesto\");\r                                      disable(\"txtPrecioPosicionamiento\");\r                                      disable(\"cbIndicadorPS\");\r                                      disable(\"cbMarca\");\r                                      disable(\"cbMarca2\");\r                                      disable(\"cbCanal\");\r                                      disable(\"cbPeriodoInicio\");\r                                      disable(\"cbPeriodoFin\");\r                                      disable(\"cbLinea\");\r                                      disable(\"cbNegocio\");\r                                      disable(\"cbUnidadNegocio\");\r                                      disable(\"cbGenerico\");\r                                      disable(\"cbSuperGenerico\");\r                                      disable(\"cbEstatusProducto\");\r                                      disable(\"cbSituacion\");\r                                      disable(\"cbUnidadMedidaDimensiones\");\r                                      disable(\"cbUnidadMedidaVolumen\");\r                                      disable(\"cbUnidadMedidaPeso\");\r                                      disable(\"cbIndicadorDentroCaja\");\r                                      disable(\"rbIndicadorLote\");				  \r                                                                            disable(\"txtProductos\");\r                                      disable(\"txtNumeroUnidades\");\r                                                                                                                  btnProxy(1,'0');\r                                      btnProxy(3,'0');                                       btnProxy(4,'0');\r                                      btnProxy(5,'0');\r                                      btnProxy(7,'0');            btnProxy(8,'0');                                       btnProxy(9,'0');                                       \r                                                                            var boton = document.getElementById('botonContenido');\r                                      boton.disabled = true;\r                              }\r                              \r                    }\r                        }\r         /*\r                   debugger\r                   configurarMenuSecundario(formName);\r         */	 \r}\r\r\rvar tableCache = new Array();\r\rfunction LoadTableCache(){\r   for(var i =0;i < listado1.datos.length;i++) \r      tableCache[i] = new Array(listado1.datos[i][0],listado1.datos[i][1],listado1.datos[i][2]);\r}\r\rfunction LoadTableFromCache(tblCache){   \r   for(var i =0;i < tblCache.length;i++) {\r      var nuevaFila = new Array();\r                  nuevaFila[0] = tblCache[i][0];\r             nuevaFila[1] = tblCache[i][1];\r             nuevaFila[2] = tblCache[i][2];\r                           listado1.insertar(nuevaFila);\r                           listado1.repinta();\r   }   \r}\r\rfunction asignarCombosPeriodos(){\r                      if ((_get('cbMarca2')!='') && (_get('cbCanal')!='')){\r                  asignar([['COMBO',formName + '.cbPeriodoInicio', \r                                                                         'ConectorDruidaTransactionQuery', \r                                                                         'dtoSalida.resultado_ROWSET',\r                                                                         formarCadenaDT('MAEBusquedaPeriodos', 'es.indra.sicc.dtos.mae.DTOBusquedaPeriodos', \r                                                                         MakeParameters(_get('cbMarca'),_get('cbCanal'))), \r                                                                         'recargarPeriodoIni(datos);']]);	\r                  asignar([['COMBO',formName + '.cbPeriodoFin', \r                                                                         'ConectorDruidaTransactionQuery', \r                                                                         'dtoSalida.resultado_ROWSET',\r                                                                         formarCadenaDT('MAEBusquedaPeriodos', 'es.indra.sicc.dtos.mae.DTOBusquedaPeriodos', \r                                                                         MakeParameters(_get('cbMarca'),_get('cbCanal'))), \r                                                                         'recargarPeriodoFin(datos);']]);\r\r                  arr = new Array();\r                  arr[arr.length] = new Array('oidPais', get('frmKitProductos.hid_oidPais'));\r                  arr[arr.length] = new Array('oid', get('frmKitProductos.cbMarca2'));\r\r                  asignar([['COMBO',formName + '.cbMarca', \r                                                                         'ConectorDruidaTransactionQuery', \r                                                                         'dtoSalida.resultado_ROWSET',\r                                                                         formarCadenaDT('SEGRecuperarMarcasProductoMP', 'es.indra.sicc.util.DTOOID', \r                                                                         arr), \r                                                                         'recargarMarcaProductos(datos);']]);\r\r                                                                         \r         \r  \r         }\r}\r\rfunction setCombosOrig(){\r                  var ind = _get(\"hid_cbIndicadorPS\");\r\r         if(ind == \"true\"){\r            _set(\"hid_cbIndicadorPS\",\"1\");\r         }else{\r            _set(\"hid_cbIndicadorPS\",\"0\");\r         }\r\r         var canal = _get(\"hid_cbCanal\");	\r         _selectV(\"cbIndicadorPS\");   \r         _selectV(\"cbGenerico\");\r\r          \r         _selectV(\"cbMarca2\");\r        \r         \r                   \r         _selectV(\"cbSuperGenerico\");\r         _selectV(\"cbEstatusProducto\");\r         _selectV(\"cbSituacion\");\r         _selectV(\"cbUnidadMedidaDimensiones\");\r         _selectV(\"cbLinea\");          _selectV(\"cbUnidadMedidaVolumen\");\r         _selectV(\"cbNegocio\");        _selectV(\"cbUnidadMedidaPeso\");\r         _selectV(\"cbUnidadNegocio\"); _selectV(\"cbIndicadorDentroCaja\");\r         _selectV(\"cbCodigoPagoFraccionado\");\r         _selectV(\"rbIndicadorLote\");\r       \r         cargaCanal(\"1\");\r         _selectV(\"cbCanal\");\r}\r\rfunction reload_kit(lp){  \r         set(formName + '.conectorAction',lp);\r         set(formName + '.accion', '');\r         enviaSICC(formName);\r}\r\rfunction ReturnNClose(){\r    returnValue = \"update\";  \r    close();\r}\r\rfunction selectPeriodos(){\r   _selectV(\"cbPeriodoInicio\");_selectV(\"cbPeriodoFin\");\r}\r\rfunction completarComboTipo(){\r    var descrip = GestionarMensaje(984, \"\", \"\", \"\");\r    var cod = GestionarMensaje(985, \"\", \"\", \"\");\r    combo_add(formName + '.cbIndicadorPS', \"1\", GestionarMensaje(1009, \"\", \"\", \"\"));\r    combo_add(formName + '.cbIndicadorPS', \"0\", GestionarMensaje(1008, \"\", \"\", \"\"));\r    combo_add(formName + '.cbSituacion', \"A\", GestionarMensaje(156, \"\", \"\", \"\"));\r    combo_add(formName + '.cbSituacion', \"N\", GestionarMensaje(157, \"\", \"\", \"\"));\r         combo_add(formName + '.cbIndicadorDentroCaja', \"B\", GestionarMensaje(1013, \"\", \"\", \"\"));\r    combo_add(formName + '.cbIndicadorDentroCaja', \"C\", GestionarMensaje(1012, \"\", \"\", \"\"));         \r}\r\rfunction anadir(){\r    if(ValidaNum(get(formName + \".txtNumeroUnidades\").toString()) == \"OK\"){\r         if(get(formName + \".txtProductos\").toString() != \"\" && get(formName + \".txtNumeroUnidades\").toString() != \"\") {\r             var nuevaFila = new Array(); nuevaFila[0] = \"D\"; \r             nuevaFila[1] = get(formName + \".txtProductos\").toString();\r             nuevaFila[2] = get(formName + \".txtNumeroUnidades\").toString();\r                           listado1.insertar(nuevaFila);\r                           listado1.repinta(); \r									set(formName + \".txtProductos\",'');\r									set(formName + \".txtNumeroUnidades\",'');\r         }\r    } else {\r            GestionarMensaje(1197, \"\", \"\", \"\");\r            _foc(\"txtNumeroUnidades\");\r         }\r}\r\rfunction recargarPeriodoFin(datos){\r    set_combo(formName + '.cbPeriodoFin',datos, []);\r    if (get(formName + '.hid_cbPeriodoFin')!=''){\r      iSeleccionadob = new Array();          \r      iSeleccionadob[0] = get(formName + '.hid_cbPeriodoFin');      \r      set(formName + '.cbPeriodoFin',iSeleccionadob);        \r    }   \r}\r\rfunction recargarPeriodoIni(datos){\r\r    set_combo(formName + '.cbPeriodoInicio',datos, []);\r    if (get(formName + '.hid_cbPeriodoInicio')!=''){\r      iSeleccionadob = new Array();          \r      iSeleccionadob[0] = get(formName + '.hid_cbPeriodoInicio');      \r      set(formName + '.cbPeriodoInicio',iSeleccionadob);        \r    }   \r}\r\rfunction recargarMarcaProductos(datos){\r\r    set_combo(formName + '.cbMarca',datos, []);\r    if (get(formName + '.hid_cbMarca')!=''){\r      iSeleccionadob = new Array();          \r      iSeleccionadob[0] = get(formName + '.hid_cbMarca');      \r      set(formName + '.cbMarca',iSeleccionadob);        \r    }   \r}\r\rfunction cargarPeriodos(){\r    var marca = get(formName + '.cbMarca2').toString();\r    var canal = get(formName + '.cbCanal').toString();\r         if(marca == '' || canal == '') {\r           set_combo(formName + '.cbPeriodoInicio','');\r           set_combo(formName + '.cbPeriodoFin','');\r         }\r    if(marca != \"\" && canal != \"\" ) {        \r         recargaCombo(formName + '.cbPeriodoInicio', 'MAEBusquedaPeriodos', 'es.indra.sicc.dtos.mae.DTOBusquedaPeriodos',  MakeParameters(marca,canal));\r         recargaCombo(formName + '.cbPeriodoFin', 'MAEBusquedaPeriodos', 'es.indra.sicc.dtos.mae.DTOBusquedaPeriodos', MakeParameters(marca,canal));\r    }\r         return true;\r}\r\rfunction cargaCanal(id){\r    set_combo(formName + '.cbCanal','');\r         set_combo(formName + '.cbPeriodoInicio','');\r         combo_add(formName + '.cbPeriodoInicio','','');\r         set_combo(formName + '.cbPeriodoFin','');\r         combo_add(formName + '.cbPeriodoFin','','');\r    combo_add(formName + '.cbCanal','','');\r\r    for(var i = 0; i < lstOculta.datos.longitud;i++) {\r\r\r             combo_add(formName + '.cbCanal', lstOculta.datos.ij(i,0), lstOculta.datos.ij(i,1));\r    }\r}\r\rfunction MakeParameters(marca,canal){\r    var parametros = new Array([],[],[]);\r    parametros[0][0] = \"oidPais\";\r         parametros[0][1] = _get(\"hid_oidPais\");\r    parametros[1][0] = \"marca\";\r    parametros[1][1] = marca;\r    parametros[2][0] = \"canal\";\r    parametros[2][1] = canal;\r        return parametros;\r}\r\rfunction fGuardar(){\r    numDecimales = _get(\"hid_NumeroDecimales\");       entornoSeparador = (_get(\"hid_SeparadorDecimales\") == \",\")?true:false;\r                  if(checkRequired(\"txtCodigoSAP\",\"1172\")) return;\r         if(checkRequiredField(\"txtCodigoAntiguo\",\"1186\")) return;\r         if(checkRequiredField(\"txtDescripcionSAP\",\"1138\")) return;\r         if(checkRequiredField(\"txtDescripcionCorta\",\"1140\")) return;\r         if(checkRequiredField(\"rbIndicadorLote\",\"1141\")){ _foc(\"rbIndicadorLote\"); return;}\r         if(checkRequiredField(\"cbIndicadorPS\",\"1142\")) return;              <!-- 15 -->\r         if(checkRequiredField(\"cbMarca\",\"1076\")) return;                     <!-- 20 -->\r         if(checkRequiredField(\"cbUnidadNegocio\",\"1143\")) return;            <!-- 29 -->\r         if(checkRequiredField(\"cbNegocio\",\"1144\")) return;                   <!-- 21 -->\r         if(checkRequiredField(\"cbGenerico\",\"1145\")) return;                  <!-- 12 -->\r         if(checkRequiredField(\"cbSuperGenerico\",\"1146\")) return;            <!-- 28 -->\r         if(checkRequiredField(\"txtJerarquia1\",\"1147\")) return;        \r    if(checkRequiredField(\"txtJerarquia2\",\"1148\")) return;\r    if(checkRequiredField(\"txtJerarquia3\",\"1149\")) return;\r         if(checkRequiredField(\"cbLinea\",\"1150\")) return;                     <!-- 19 -->\r         if(checkRequiredField(\"txtAtributo1\",\"1151\")) return;\r         if(checkRequiredField(\"txtAtributo2\",\"1152\")) return;\r         if(checkRequiredField(\"txtAtributo3\",\"1153\")) return;\r         if(checkRequiredField(\"txtDimensionAlto\",\"1154\")) return;\r    if(checkRequiredField(\"txtGrupoArticulos\",\"2473\")) return;\r         \r          if ( _get(\"txtDimensionAlto\") != \"\"){\r                   var valido = sicc_valida_numero(\"txtDimensionAlto\", GestionarMensaje('1352', null, null, null), 0, 999999, \"Entero\");\r                   if (!valido) { return; }\r         }\r\r   if(checkRequiredField(\"txtDimensionLargo\",\"1155\")) return;\r         if ( _get(\"txtDimensionLargo\") != \"\"){\r                   var valido = sicc_valida_numero(\"txtDimensionLargo\", GestionarMensaje('1354', null, null, null), 0, 999999, \"Entero\");\r                   if (!valido) { return; }\r         }\r\r         if(checkRequiredField(\"txtDimensionAncho\",\"1156\")) return;\r         if ( _get(\"txtDimensionAncho\") != \"\"){\r                   var valido = sicc_valida_numero(\"txtDimensionAncho\", GestionarMensaje('1353', null, null, null), 0, 999999, \"Entero\");\r                   if (!valido) { return; }\r         }\r\r         if(checkRequiredField(\"cbUnidadMedidaDimensiones\",\"1157\")) return; <!-- 30 -->\r\r   if(checkRequiredField(\"txtVolumen\",\"1158\")) return;\r         if ( _get(\"txtVolumen\") != \"\"){\r                   var valido = sicc_valida_numero(\"txtVolumen\", GestionarMensaje('1355', null, null, null), 0, 999999, \"Entero\");\r                   if (!valido) { return; }\r         }\r\r         if(checkRequiredField(\"cbUnidadMedidaVolumen\",\"1159\")) return;\r\r    if(checkRequiredField(\"txtPeso\",\"1160\")) return;\r          if ( _get(\"txtPeso\") != \"\"){\r                            var valido = sicc_valida_numero(\"txtPeso\", GestionarMensaje('1351', null, null, null), 0, 999999, \"Entero\");\r                            if (!valido) { \r                               return; \r                            }\r          }\r\r         if(checkRequiredField(\"cbUnidadMedidaPeso\",\"1161\")) return;         <!-- 31 -->\r\r         if(checkRequiredField(\"txtUnidadesDentroPedido\",\"1162\")) return;\r         if ( _get(\"txtUnidadesDentroPedido\") != \"\"){\r                   var valido = sicc_valida_numero(\"txtUnidadesDentroPedido\", GestionarMensaje('1357', null, null, null), 0, 99999, \"Entero\");\r                   if (!valido) { \r                      return; \r                   }\r         }\r\r         if(checkRequiredField(\"txtUnidadesCaja\",\"1163\")) return;\r   if ( _get(\"txtUnidadesCaja\") != \"\"){\r             var valido = sicc_valida_numero(\"txtUnidadesCaja\", GestionarMensaje('1356', null, null, null), 0, 99999, \"Entero\");\r                   if (!valido) { \r                      return; \r                   }\r         }\r\r   if(checkRequiredField(\"txtCosteEstandar\",\"1164\")) return;\r         if ( _get(\"txtCosteEstandar\") != \"\"){\r                   var valido = sicc_valida_numero(\"txtCosteEstandar\", GestionarMensaje('1358', null, null, null), \"0\", \"999.99\", \"Moneda\");\r                   if (!valido) { \r                      return; \r                   }\r         }\r\r         if(checkRequiredField(\"txtPrecioPosicionamiento\",\"1165\")) return;\r         if ( _get(\"txtPrecioPosicionamiento\") ){\r                   var valido = sicc_valida_numero(\"txtPrecioPosicionamiento\", GestionarMensaje('1359', null, null, null), \"0\", \"999.99\", \"Moneda\");\r                   if (!valido) { \r                      return; \r                   }\r   } \r\r\r             sizeOfCTEXT = 13;\r         if(checkRequiredField(\"cbSituacion\",\"1166\")) return;                 <!-- 27 -->\r         if(checkRequiredField(\"cbEstatusProducto\",\"1167\")) return;          <!-- 11 -->\r         if(checkRequiredField(\"cbIndicadorDentroCaja\",\"1168\")) return;     <!-- 13 -->\r         if(checkRequiredField(\"cbCodigoPagoFraccionado\",\"1169\")) return;   <!-- 5 -->\r\r         if(checkRequiredField(\"txtPrecioCatalogo\",\"1170\")) return;\r          if ( _get(\"txtPrecioCatalogo\") != \"\"){\r                            var valido = sicc_valida_numero(\"txtPrecioCatalogo\", GestionarMensaje('1360', null, null, null), \"0\", \"9999999999.99\", \"Moneda\");\r                            if (!valido) { \r                               return; \r                            }\r          }\r\r    if(checkRequiredField(\"txtPrecioContable\",\"1171\")) return;\r          if ( _get(\"txtPrecioContable\") != \"\"){\r                            var valido = sicc_valida_numero(\"txtPrecioContable\", GestionarMensaje('1361', null, null, null), \"0\", \"9999999999.99\", \"Moneda\");\r                            if (!valido) { \r                               return; \r                            }\r          }\r\r\r         if(checkRequiredField(\"txtPorcentajeUnidades\",\"1173\")) return;     \r              if ( _get(\"txtPorcentajeUnidades\") != \"\"){\r                            var valido = sicc_valida_numero(\"txtPorcentajeUnidades\", GestionarMensaje('1362', null, null, null), \"0\", \"100\", \"Entero\");\r                            if (!valido) { \r                               return; \r                            }\r          }\r\r            \r    if(listado1.datos.length > 0) {\r         var lst_oid_productos = \"\";\r         var lst_productos= \"\";\r         var lst_num_unidades= \"\";\r         var p = \"|\";\r         for(var i =0;i < listado1.datos.length;i++) {\r                                        lst_oid_productos += listado1.datos[i][0] + p;\r             lst_productos += listado1.datos[i][1] + p;\r             lst_num_unidades += listado1.datos[i][2] + p;\r         }\r                  lst_productos += \"D\";\r                           set(formName + \".hid_lstColumnOidProductos\", lst_oid_productos);\r         set(formName + \".hid_lstColumnProductos\", lst_productos);\r         set(formName + \".hid_lstColumnNumUnidades\", lst_num_unidades);\r    }else{ /*gestionarMensaje();*/ \r			set(formName + \".hid_lstColumnOidProductos\", '');\r			set(formName + \".hid_lstColumnProductos\", '');\r			set(formName + \".hid_lstColumnNumUnidades\",'');\r	 }\r\r         if(get(formName + \".txtDescripcionSAP\")==\"\")\r                  set(formName + \".txtDescripcionSAP\", \"   \");\r\r      set(formName + \".accion\", \"Guardar\");\r      set(formName + \".conectorAction\", LPName); /* Nombre de LP esta asignado anteriormente en la carga */\r\r    enviaSICC(formName);\r}\r\r\rfunction fBorrar(){ \r   listado1.eliminarSelecc();\r}\r\r\rfunction fVolver(){ \r   if(HR_DLG) close(); \r}\r\rfunction reload_insertar(){   \r         fLimpiarGenericoSICC();\r         btnProxy(2, '0');\r                      \r         set_combo(formName + '.cbCanal','');\r         set_combo(formName + '.cbPeriodoInicio','');\r         set_combo(formName + '.cbPeriodoFin','');\r\r         var arrCheck = document.all[\"rbIndicadorLote\"];\r\r         for(var i=0; i< arrCheck.length; i++){\r                  if(arrCheck[i].type && arrCheck[i].type.toUpperCase() == \"RADIO\"){\r                           document.all[\"rbIndicadorLote\"][i].checked = false;\r                  }\r         }\r\r         listado1.setDatos(new Array());\r         \r\r         \r}\r\rfunction validarModificable(fld){\r  if(_get(\"hid_\" + fld + \"_modificable\") == \"N\")\r        disable(fld);\r}\r\rfunction fLimpiar(){\r         if(use_case != \"Insertar\") {\r             listado1.setDatos(new Array());\r             LoadTableFromCache(tableCache);\r                  setCombosOrig();\r                  asignarCombosPeriodos();             \r         }\r         if(use_case == \"Insertar\") {\r             listado1.setDatos(new Array());\r                  \r                                             \r                  \r                  set_combo(formName + '.cbCanal','');\r                  set_combo(formName + '.cbPeriodoInicio','');\r                                    set_combo(formName + '.cbPeriodoFin','');\r                                    \r    var arrCheck = document.all[\"rbIndicadorLote\"];\r\r           for(var i=0; i< arrCheck.length; i++){\r                     if(arrCheck[i].type && arrCheck[i].type.toUpperCase() == \"RADIO\"){\r                              document.all[\"rbIndicadorLote\"][i].checked = false;\r                     }\r            }\r    \r\r         } \r}\r\rfunction checkPorcentaje(field, cod){\r  if(_get(field)!=\"\"){\r            if(ValidaNum(_get(field))!=\"OK\" || parseInt(_get(field)) > 100 || parseInt(_get(field)) == 0 )  {\r                   cdos_mostrarAlert(GestionarMensaje(cod, null , null, null));\r                   _foc(field);\r                   return true;\r            }\r    }\r}\r\r/*--------------------------------------------------------------------------------------------\r *---------------------- INCLUDES ------------------------------------------------------------\r *--------------------------------------------------------------------------------------------*/\rvar doc = \"document.all.\"; \r\rfunction disable(field){\r   if(field.substr(0,2)==\"rb\")\r                  for(i=0;   i<(eval(doc+field).length-1) && eval(doc+field+\"[\"+ i++ +\"].disabled=true;\"););	        \r     else accion(formName+'.'+field,'.disabled=true'); \r}\r\rfunction _selectV(id){\r  if(id.substr(0,2) == \"cb\") {\r        set(formName + \".\" + id,new Array(_get(\"hid_\" + id)));\r  } else {\r    set(formName + \".\" + id,(_get(\"hid_\" + id) == \"true\")?1:0);\r  }\r}\rfunction _get(id) { \r   return get(formName + '.' + id ).toString(); \r}\rfunction _set(id,value) { \r   set(formName + '.' + id , value) \r}\rfunction _foc(id) { \r   focaliza(formName + '.' + id); \r}\r\rvar first_col = 0;\r\rfunction chequeaErrores(){\r         var codigoError = get(formName + \".errCodigo\");\r    if (codigoError == \"\") {\r                     return true;\r         } else   {\r                     fMostrarMensajeError();\r                     if (codigoError == 280050001) {\r                                                            set(formName + \".conectorAction\", LPName);\r                              set(formName + \".accion\", \"Volver\");\r                              enviaSICC(formName)\r                           }\r                                                                                    return false;\r         }\r}\r\rfunction checkFloatNoEmpty(field,cod){\r             sizeInt=(sizeOfCTEXT-1)-numDecimales;\r    var strINT = 'Y';\r    var strDES = 'Y';\r    for(i = 1; i < sizeInt; i++)\r        strINT += 'Y';\r    for(j = 1; j < numDecimales; j++)\r        strDES += 'Y';\r    var sep = _get(\"hid_SeparadorDecimales\");\r    if(_get(field)!=\"\"){\r      if(ValidaFloat(_get(field),sizeInt,numDecimales,entornoSeparador)!=\"OK\"){\r          cdos_mostrarAlert(GestionarMensaje(cod, strINT+sep+strDES, null, null)); \r                   _foc(field); \r                   return true;\r           }\r    }\r}\rfunction checkNumNoEmpty(field, cod){\r         if(_get(field)!=\"\"){\r            if(ValidaNum(_get(field))!=\"OK\")  {\r                   cdos_mostrarAlert(GestionarMensaje(cod, null , null, null));\r                   _foc(field);\r                   return true;\r            }\r    }\r}\rfunction checkRequiredField(field, cod){\r                  if(_get(\"hid_\"+ field +\"_req\") == \"REQ\" && _get(field) == ''){\r      cdos_mostrarAlert(GestionarMensaje(cod, null, null, null));\r                      _foc(field); \r           return true;\r         }\r}\r\rfunction checkRequired(field, cod){\r         if(_get(field) == ''){\r      cdos_mostrarAlert(GestionarMensaje(cod, null, null, null));\r                      _foc(field); \r           return true;\r         }\r}\rfunction convertReq(id){\r    if(_get(\"hid_\" + id + \"_req\") == \"REQ\")\r           setMV(formName + '.' + id,'C');\r}\rfunction handle_error(){\r    HR_DLG = false;\r  btnProxy(2, '0');\r}\r\rfunction onSeleccionaMarca(){\r   arr = new Array();\r\r   arr[arr.length] = new Array('oidPais', get('frmKitProductos.hid_oidPais'));\r   arr[arr.length] = new Array('oid', get('frmKitProductos.cbMarca2'));\r         \r   recargaCombo('frmKitProductos.cbMarca', 'SEGRecuperarMarcasProductoMP', 'es.indra.sicc.util.DTOOID', arr );\r\r\r\r}\r   \r"));
      ((Element)v.get(6)).appendChild((Text)v.get(7));

      /* Termina nodo Texto:7   */
      /* Termina nodo:6   */

      /* Empieza nodo:8 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(8)).setAttribute("nombre","frmKitProductos" );
      ((Element)v.get(8)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(8));

      /* Empieza nodo:9 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","accion" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","hid_oidPais" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","hid_oidIdioma" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(12)).setAttribute("valor","LPInsertarKit" );
      ((Element)v.get(8)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","hid_lstColumnOidProductos" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hid_lstColumnProductos" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hid_lstColumnNumUnidades" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hid_SeparadorDecimales" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hid_NumeroDecimales" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hid_Oid" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","oid" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(23)).setAttribute("nombre","hid_cbCodigoPagoFraccionado" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hid_cbIndicadorPS" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hid_cbMarca" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hid_cbMarca2" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hid_cbCanal" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hid_cbTipoPeriodo" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hid_cbPeriodoInicio" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hid_cbPeriodoFin" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","hid_cbLinea" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","hid_cbNegocio" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","hid_cbUnidadNegocio" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","hid_cbGenerico" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","hid_cbSuperGenerico" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","hid_cbEstatusProducto" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","hid_cbSituacion" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","hid_cbUnidadMedidaDimensiones" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","hid_cbUnidadMedidaVolumen" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","hid_cbUnidadMedidaPeso" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","hid_cbIndicadorDentroCaja" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","hid_rbIndicadorLote" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","hid_txtAtributo1_req" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","hid_txtAtributo2_req" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","hid_txtAtributo3_req" );
      ((Element)v.get(45)).setAttribute("valor","" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(8)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","hid_txtCodigoAntiguo_req" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","hid_cbCodigoPagoFraccionado_req" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","hid_cbEstatusProducto_req" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","hid_cbGenerico_req" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","hid_cbIndicadorDentroCaja_req" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","hid_cbIndicadorPS_req" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","hid_cbLinea_req" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","hid_cbMarca_req" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(54)).setAttribute("nombre","hid_cbNegocio_req" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(55)).setAttribute("nombre","hid_cbSituacion_req" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(56)).setAttribute("nombre","hid_cbSuperGenerico_req" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(57)).setAttribute("nombre","hid_cbUnidadNegocio_req" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(58)).setAttribute("nombre","hid_cbUnidadMedidaDimensiones_req" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(59)).setAttribute("nombre","hid_cbUnidadMedidaPeso_req" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(60)).setAttribute("nombre","hid_cbUnidadMedidaVolumen_req" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(61)).setAttribute("nombre","hid_txtDescripcionCorta_req" );
      ((Element)v.get(61)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(62)).setAttribute("nombre","hid_txtDescripcionSAP_req" );
      ((Element)v.get(62)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(63)).setAttribute("nombre","hid_txtDimensionAlto_req" );
      ((Element)v.get(63)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(64)).setAttribute("nombre","hid_txtDimensionAncho_req" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */

      /* Empieza nodo:65 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(65)).setAttribute("nombre","hid_txtDimensionLargo_req" );
      ((Element)v.get(65)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */

      /* Empieza nodo:66 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(66)).setAttribute("nombre","hid_rbIndicadorLote_req" );
      ((Element)v.get(66)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(67)).setAttribute("nombre","hid_txtJerarquia1_req" );
      ((Element)v.get(67)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */

      /* Empieza nodo:68 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(68)).setAttribute("nombre","hid_txtJerarquia2_req" );
      ((Element)v.get(68)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */

      /* Empieza nodo:69 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(69)).setAttribute("nombre","hid_txtJerarquia3_req" );
      ((Element)v.get(69)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */

      /* Empieza nodo:70 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(70)).setAttribute("nombre","hid_txtPeso_req" );
      ((Element)v.get(70)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(71)).setAttribute("nombre","hid_txtPrecioCatalogo_req" );
      ((Element)v.get(71)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */

      /* Empieza nodo:72 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(72)).setAttribute("nombre","hid_txtGrupoArticulos_req" );
      ((Element)v.get(72)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */

      /* Empieza nodo:73 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(73)).setAttribute("nombre","hid_txtPrecioContable_req" );
      ((Element)v.get(73)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */

      /* Empieza nodo:74 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(74)).setAttribute("nombre","hid_txtCosteEstandar_req" );
      ((Element)v.get(74)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */

      /* Empieza nodo:75 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(75)).setAttribute("nombre","hid_txtPrecioPosicionamiento_req" );
      ((Element)v.get(75)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */

      /* Empieza nodo:76 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(76)).setAttribute("nombre","hid_txtUnidadesDentroPedido_req" );
      ((Element)v.get(76)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */

      /* Empieza nodo:77 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(77)).setAttribute("nombre","hid_txtUnidadesCaja_req" );
      ((Element)v.get(77)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */

      /* Empieza nodo:78 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(78)).setAttribute("nombre","hid_txtVolumen_req" );
      ((Element)v.get(78)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */

      /* Empieza nodo:79 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(79)).setAttribute("nombre","hid_txtAtributo1_modificable" );
      ((Element)v.get(79)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */

      /* Empieza nodo:80 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(80)).setAttribute("nombre","hid_txtAtributo2_modificable" );
      ((Element)v.get(80)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */

      /* Empieza nodo:81 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(81)).setAttribute("nombre","hid_txtAtributo3_modificable" );
      ((Element)v.get(81)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */

      /* Empieza nodo:82 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(82)).setAttribute("nombre","hid_txtCodigoAntiguo_modificable" );
      ((Element)v.get(82)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(83)).setAttribute("nombre","hid_cbCodigoPagoFraccionado_modificable" );
      ((Element)v.get(83)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */

      /* Empieza nodo:84 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(84)).setAttribute("nombre","hid_txtDescripcionCorta_modificable" );
      ((Element)v.get(84)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */

      /* Empieza nodo:85 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(85)).setAttribute("nombre","hid_txtDescripcionSAP_modificable" );
      ((Element)v.get(85)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(86)).setAttribute("nombre","hid_txtDimensionAlto_modificable" );
      ((Element)v.get(86)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(87)).setAttribute("nombre","hid_txtDimensionAncho_modificable" );
      ((Element)v.get(87)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */

      /* Empieza nodo:88 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(88)).setAttribute("nombre","hid_txtDimensionLargo_modificable" );
      ((Element)v.get(88)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */

      /* Empieza nodo:89 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(89)).setAttribute("nombre","hid_cbEstatusProducto_modificable" );
      ((Element)v.get(89)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */

      /* Empieza nodo:90 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(90)).setAttribute("nombre","hid_cbGenerico_modificable" );
      ((Element)v.get(90)).setAttribute("valor","" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(8)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */

      /* Empieza nodo:91 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(91)).setAttribute("nombre","hid_cbIndicadorDentroCaja_modificable" );
      ((Element)v.get(91)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(92)).setAttribute("nombre","hid_rbIndicadorLote_modificable" );
      ((Element)v.get(92)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */

      /* Empieza nodo:93 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(93)).setAttribute("nombre","hid_cbIndicadorPS_modificable" );
      ((Element)v.get(93)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */

      /* Empieza nodo:94 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(94)).setAttribute("nombre","hid_txtJerarquia1_modificable" );
      ((Element)v.get(94)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */

      /* Empieza nodo:95 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(95)).setAttribute("nombre","hid_txtJerarquia2_modificable" );
      ((Element)v.get(95)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */

      /* Empieza nodo:96 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(96)).setAttribute("nombre","hid_txtJerarquia3_modificable" );
      ((Element)v.get(96)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */

      /* Empieza nodo:97 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(97)).setAttribute("nombre","hid_cbLinea_modificable" );
      ((Element)v.get(97)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */

      /* Empieza nodo:98 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(98)).setAttribute("nombre","hid_cbMarca_modificable" );
      ((Element)v.get(98)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */

      /* Empieza nodo:99 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(99)).setAttribute("nombre","hid_cbNegocio_modificable" );
      ((Element)v.get(99)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */

      /* Empieza nodo:100 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(100)).setAttribute("nombre","hid_txtPeso_modificable" );
      ((Element)v.get(100)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */

      /* Empieza nodo:101 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(101)).setAttribute("nombre","hid_txtPrecioCatalogo_modificable" );
      ((Element)v.get(101)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */

      /* Empieza nodo:102 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(102)).setAttribute("nombre","hid_txtGrupoArticulos_modificable" );
      ((Element)v.get(102)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */

      /* Empieza nodo:103 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(103)).setAttribute("nombre","hid_txtPrecioContable_modificable" );
      ((Element)v.get(103)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */

      /* Empieza nodo:104 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(104)).setAttribute("nombre","hid_txtCosteEstandar_modificable" );
      ((Element)v.get(104)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */

      /* Empieza nodo:105 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(105)).setAttribute("nombre","hid_txtPrecioPosicionamiento_modificable" );
      ((Element)v.get(105)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */

      /* Empieza nodo:106 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(106)).setAttribute("nombre","hid_cbSituacion_modificable" );
      ((Element)v.get(106)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */

      /* Empieza nodo:107 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(107)).setAttribute("nombre","hid_cbSuperGenerico_modificable" );
      ((Element)v.get(107)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */

      /* Empieza nodo:108 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(108)).setAttribute("nombre","hid_cbUnidadNegocio_modificable" );
      ((Element)v.get(108)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */

      /* Empieza nodo:109 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(109)).setAttribute("nombre","hid_cbUnidadMedidaDimensiones_modificable" );
      ((Element)v.get(109)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */

      /* Empieza nodo:110 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(110)).setAttribute("nombre","hid_cbUnidadMedidaPeso_modificable" );
      ((Element)v.get(110)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */

      /* Empieza nodo:111 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(111)).setAttribute("nombre","hid_cbUnidadMedidaVolumen_modificable" );
      ((Element)v.get(111)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */

      /* Empieza nodo:112 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(112)).setAttribute("nombre","hid_txtUnidadesDentroPedido_modificable" );
      ((Element)v.get(112)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */

      /* Empieza nodo:113 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(113)).setAttribute("nombre","hid_txtUnidadesCaja_modificable" );
      ((Element)v.get(113)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */

      /* Empieza nodo:114 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(114)).setAttribute("nombre","hid_txtVolumen_modificable" );
      ((Element)v.get(114)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */

      /* Empieza nodo:115 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(115)).setAttribute("nombre","hid_temp" );
      ((Element)v.get(115)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */

      /* Empieza nodo:116 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(116)).setAttribute("nombre","exito" );
      ((Element)v.get(116)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */

      /* Empieza nodo:117 / Elemento padre: 8   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(117)).setAttribute("nombre","capaPrototipo" );
      ((Element)v.get(8)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("table"));
      ((Element)v.get(118)).setAttribute("width","100%" );
      ((Element)v.get(118)).setAttribute("border","0" );
      ((Element)v.get(118)).setAttribute("cellspacing","0" );
      ((Element)v.get(118)).setAttribute("cellpadding","0" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).setAttribute("width","12" );
      ((Element)v.get(120)).setAttribute("align","center" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(121)).setAttribute("width","12" );
      ((Element)v.get(121)).setAttribute("height","12" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:122 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).setAttribute("width","750" );
      ((Element)v.get(119)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(123)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:124 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).setAttribute("width","12" );
      ((Element)v.get(119)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(125)).setAttribute("src","b.gif" );
      ((Element)v.get(125)).setAttribute("width","12" );
      ((Element)v.get(125)).setAttribute("height","1" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:119   */

      /* Empieza nodo:126 / Elemento padre: 118   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(118)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(128)).setAttribute("src","b.gif" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:129 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(131)).setAttribute("class","legend" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(132)).setAttribute("nombre","lblDatosAlta" );
      ((Element)v.get(132)).setAttribute("alto","13" );
      ((Element)v.get(132)).setAttribute("filas","1" );
      ((Element)v.get(132)).setAttribute("valor","" );
      ((Element)v.get(132)).setAttribute("id","legend" );
      ((Element)v.get(132)).setAttribute("cod","00127" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:133 / Elemento padre: 130   */
      v.add(doc.createElement("table"));
      ((Element)v.get(133)).setAttribute("width","100%" );
      ((Element)v.get(133)).setAttribute("border","0" );
      ((Element)v.get(133)).setAttribute("align","center" );
      ((Element)v.get(133)).setAttribute("cellspacing","0" );
      ((Element)v.get(133)).setAttribute("cellpadding","0" );
      ((Element)v.get(130)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(133)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("table"));
      ((Element)v.get(136)).setAttribute("width","100%" );
      ((Element)v.get(136)).setAttribute("border","0" );
      ((Element)v.get(136)).setAttribute("align","center" );
      ((Element)v.get(136)).setAttribute("cellspacing","0" );
      ((Element)v.get(136)).setAttribute("cellpadding","0" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("tr"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).setAttribute("colspan","3" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(139)).setAttribute("src","b.gif" );
      ((Element)v.get(139)).setAttribute("width","8" );
      ((Element)v.get(139)).setAttribute("height","8" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:140 / Elemento padre: 136   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(136)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(142)).setAttribute("src","b.gif" );
      ((Element)v.get(142)).setAttribute("width","8" );
      ((Element)v.get(142)).setAttribute("height","8" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:143 / Elemento padre: 140   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).setAttribute("width","100%" );
      ((Element)v.get(140)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("table"));
      ((Element)v.get(144)).setAttribute("width","100%" );
      ((Element)v.get(144)).setAttribute("border","0" );
      ((Element)v.get(144)).setAttribute("cellspacing","0" );
      ((Element)v.get(144)).setAttribute("cellpadding","0" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(144)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(146)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(148)).setAttribute("class","legend" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(149)).setAttribute("nombre","lblPeriodosValidez" );
      ((Element)v.get(149)).setAttribute("alto","13" );
      ((Element)v.get(149)).setAttribute("filas","1" );
      ((Element)v.get(149)).setAttribute("valor","" );
      ((Element)v.get(149)).setAttribute("id","legend" );
      ((Element)v.get(149)).setAttribute("cod","00158" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:150 / Elemento padre: 147   */
      v.add(doc.createElement("table"));
      ((Element)v.get(150)).setAttribute("width","100%" );
      ((Element)v.get(150)).setAttribute("border","0" );
      ((Element)v.get(150)).setAttribute("align","center" );
      ((Element)v.get(150)).setAttribute("cellspacing","0" );
      ((Element)v.get(150)).setAttribute("cellpadding","0" );
      ((Element)v.get(147)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("td"));
      ((Element)v.get(152)).setAttribute("colspan","4" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(153)).setAttribute("src","b.gif" );
      ((Element)v.get(153)).setAttribute("width","8" );
      ((Element)v.get(153)).setAttribute("height","8" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:154 / Elemento padre: 150   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(150)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","b.gif" );
      ((Element)v.get(156)).setAttribute("width","8" );
      ((Element)v.get(156)).setAttribute("height","8" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:157 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(158)).setAttribute("nombre","lblMarca2" );
      ((Element)v.get(158)).setAttribute("alto","13" );
      ((Element)v.get(158)).setAttribute("filas","1" );
      ((Element)v.get(158)).setAttribute("valor","" );
      ((Element)v.get(158)).setAttribute("id","datosTitle" );
      ((Element)v.get(158)).setAttribute("cod","6" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:159 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(160)).setAttribute("src","b.gif" );
      ((Element)v.get(160)).setAttribute("width","25" );
      ((Element)v.get(160)).setAttribute("height","8" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:161 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML630(Document doc) {
      ((Element)v.get(162)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(162)).setAttribute("alto","13" );
      ((Element)v.get(162)).setAttribute("filas","1" );
      ((Element)v.get(162)).setAttribute("valor","" );
      ((Element)v.get(162)).setAttribute("id","datosTitle" );
      ((Element)v.get(162)).setAttribute("cod","7" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:163 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).setAttribute("width","100%" );
      ((Element)v.get(154)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(164)).setAttribute("src","b.gif" );
      ((Element)v.get(164)).setAttribute("width","8" );
      ((Element)v.get(164)).setAttribute("height","8" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */
      /* Termina nodo:154   */

      /* Empieza nodo:165 / Elemento padre: 150   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(150)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("td"));
      ((Element)v.get(165)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(167)).setAttribute("src","b.gif" );
      ((Element)v.get(167)).setAttribute("width","8" );
      ((Element)v.get(167)).setAttribute("height","8" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */

      /* Empieza nodo:168 / Elemento padre: 165   */
      v.add(doc.createElement("td"));
      ((Element)v.get(168)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(165)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(169)).setAttribute("nombre","cbMarca2" );
      ((Element)v.get(169)).setAttribute("id","datosCampos" );
      ((Element)v.get(169)).setAttribute("size","1" );
      ((Element)v.get(169)).setAttribute("multiple","N" );
      ((Element)v.get(169)).setAttribute("req","N" );
      ((Element)v.get(169)).setAttribute("valorinicial","" );
      ((Element)v.get(169)).setAttribute("textoinicial","" );
      ((Element)v.get(169)).setAttribute("onchange","cargarPeriodos();onSeleccionaMarca()" );
      ((Element)v.get(169)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnAnadir')" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */
      /* Termina nodo:168   */

      /* Empieza nodo:171 / Elemento padre: 165   */
      v.add(doc.createElement("td"));
      ((Element)v.get(165)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(172)).setAttribute("src","b.gif" );
      ((Element)v.get(172)).setAttribute("width","25" );
      ((Element)v.get(172)).setAttribute("height","8" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */

      /* Empieza nodo:173 / Elemento padre: 165   */
      v.add(doc.createElement("td"));
      ((Element)v.get(173)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(165)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(174)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(174)).setAttribute("id","datosCampos" );
      ((Element)v.get(174)).setAttribute("size","1" );
      ((Element)v.get(174)).setAttribute("multiple","N" );
      ((Element)v.get(174)).setAttribute("req","N" );
      ((Element)v.get(174)).setAttribute("valorinicial","" );
      ((Element)v.get(174)).setAttribute("textoinicial","" );
      ((Element)v.get(174)).setAttribute("onchange","cargarPeriodos();" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */
      /* Termina nodo:173   */

      /* Empieza nodo:176 / Elemento padre: 165   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).setAttribute("witdth","100%" );
      ((Element)v.get(165)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(177)).setAttribute("src","b.gif" );
      ((Element)v.get(177)).setAttribute("width","232" );
      ((Element)v.get(177)).setAttribute("height","8" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:178 / Elemento padre: 165   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).setAttribute("width","100%" );
      ((Element)v.get(165)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(179)).setAttribute("src","b.gif" );
      ((Element)v.get(179)).setAttribute("width","8" );
      ((Element)v.get(179)).setAttribute("height","8" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */
      /* Termina nodo:165   */

      /* Empieza nodo:180 / Elemento padre: 150   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(150)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(181)).setAttribute("colspan","4" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(182)).setAttribute("src","b.gif" );
      ((Element)v.get(182)).setAttribute("width","8" );
      ((Element)v.get(182)).setAttribute("height","8" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */
      /* Termina nodo:180   */
      /* Termina nodo:150   */

      /* Empieza nodo:183 / Elemento padre: 147   */
      v.add(doc.createElement("table"));
      ((Element)v.get(183)).setAttribute("width","100%" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(183)).setAttribute("border","0" );
      ((Element)v.get(183)).setAttribute("align","center" );
      ((Element)v.get(183)).setAttribute("cellspacing","0" );
      ((Element)v.get(183)).setAttribute("cellpadding","0" );
      ((Element)v.get(147)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(183)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("td"));
      ((Element)v.get(184)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(186)).setAttribute("src","b.gif" );
      ((Element)v.get(186)).setAttribute("width","8" );
      ((Element)v.get(186)).setAttribute("height","8" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:187 / Elemento padre: 184   */
      v.add(doc.createElement("td"));
      ((Element)v.get(184)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(188)).setAttribute("nombre","lblPeriodoInicio" );
      ((Element)v.get(188)).setAttribute("alto","13" );
      ((Element)v.get(188)).setAttribute("filas","1" );
      ((Element)v.get(188)).setAttribute("valor","" );
      ((Element)v.get(188)).setAttribute("id","datosTitle" );
      ((Element)v.get(188)).setAttribute("cod","1241" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:189 / Elemento padre: 184   */
      v.add(doc.createElement("td"));
      ((Element)v.get(184)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(190)).setAttribute("src","b.gif" );
      ((Element)v.get(190)).setAttribute("width","25" );
      ((Element)v.get(190)).setAttribute("height","8" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:191 / Elemento padre: 184   */
      v.add(doc.createElement("td"));
      ((Element)v.get(184)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(192)).setAttribute("nombre","lblPeriodoFin" );
      ((Element)v.get(192)).setAttribute("alto","13" );
      ((Element)v.get(192)).setAttribute("filas","1" );
      ((Element)v.get(192)).setAttribute("valor","" );
      ((Element)v.get(192)).setAttribute("id","datosTitle" );
      ((Element)v.get(192)).setAttribute("cod","967" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */

      /* Empieza nodo:193 / Elemento padre: 184   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).setAttribute("width","100%" );
      ((Element)v.get(184)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(194)).setAttribute("src","b.gif" );
      ((Element)v.get(194)).setAttribute("width","8" );
      ((Element)v.get(194)).setAttribute("height","8" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */
      /* Termina nodo:184   */

      /* Empieza nodo:195 / Elemento padre: 183   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(183)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
      ((Element)v.get(195)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(197)).setAttribute("src","b.gif" );
      ((Element)v.get(197)).setAttribute("width","8" );
      ((Element)v.get(197)).setAttribute("height","8" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:196   */

      /* Empieza nodo:198 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
      ((Element)v.get(198)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(198)).setAttribute("valign","bottom" );
      ((Element)v.get(195)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(199)).setAttribute("nombre","cbPeriodoInicio" );
      ((Element)v.get(199)).setAttribute("id","datosCampos" );
      ((Element)v.get(199)).setAttribute("size","1" );
      ((Element)v.get(199)).setAttribute("multiple","N" );
      ((Element)v.get(199)).setAttribute("req","N" );
      ((Element)v.get(199)).setAttribute("valorinicial","" );
      ((Element)v.get(199)).setAttribute("textoinicial","" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */
      /* Termina nodo:198   */

      /* Empieza nodo:201 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
      ((Element)v.get(195)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(202)).setAttribute("src","b.gif" );
      ((Element)v.get(202)).setAttribute("width","25" );
      ((Element)v.get(202)).setAttribute("height","8" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:201   */

      /* Empieza nodo:203 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(195)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(204)).setAttribute("nombre","cbPeriodoFin" );
      ((Element)v.get(204)).setAttribute("id","datosCampos" );
      ((Element)v.get(204)).setAttribute("size","1" );
      ((Element)v.get(204)).setAttribute("multiple","N" );
      ((Element)v.get(204)).setAttribute("req","N" );
      ((Element)v.get(204)).setAttribute("valorinicial","" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(204)).setAttribute("textoinicial","" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */
      /* Termina nodo:204   */
      /* Termina nodo:203   */

      /* Empieza nodo:206 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
      ((Element)v.get(206)).setAttribute("width","100%" );
      ((Element)v.get(195)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(207)).setAttribute("src","b.gif" );
      ((Element)v.get(207)).setAttribute("width","8" );
      ((Element)v.get(207)).setAttribute("height","8" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:206   */
      /* Termina nodo:195   */

      /* Empieza nodo:208 / Elemento padre: 183   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(183)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).setAttribute("colspan","4" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(210)).setAttribute("src","b.gif" );
      ((Element)v.get(210)).setAttribute("width","8" );
      ((Element)v.get(210)).setAttribute("height","8" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */
      /* Termina nodo:209   */
      /* Termina nodo:208   */
      /* Termina nodo:183   */
      /* Termina nodo:147   */
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:144   */
      /* Termina nodo:143   */

      /* Empieza nodo:211 / Elemento padre: 140   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(212)).setAttribute("src","b.gif" );
      ((Element)v.get(212)).setAttribute("width","12" );
      ((Element)v.get(212)).setAttribute("height","12" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:211   */
      /* Termina nodo:140   */

      /* Empieza nodo:213 / Elemento padre: 136   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(136)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("td"));
      ((Element)v.get(214)).setAttribute("colspan","4" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(215)).setAttribute("src","b.gif" );
      ((Element)v.get(215)).setAttribute("width","8" );
      ((Element)v.get(215)).setAttribute("height","8" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:214   */
      /* Termina nodo:213   */
      /* Termina nodo:136   */
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:216 / Elemento padre: 133   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(133)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("table"));
      ((Element)v.get(218)).setAttribute("width","699" );
      ((Element)v.get(218)).setAttribute("border","0" );
      ((Element)v.get(218)).setAttribute("align","left" );
      ((Element)v.get(218)).setAttribute("cellspacing","0" );
      ((Element)v.get(218)).setAttribute("cellpadding","0" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(218)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("td"));
      ((Element)v.get(220)).setAttribute("colspan","4" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(221)).setAttribute("src","b.gif" );
      ((Element)v.get(221)).setAttribute("width","8" );
      ((Element)v.get(221)).setAttribute("height","8" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:220   */
      /* Termina nodo:219   */

      /* Empieza nodo:222 / Elemento padre: 218   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(218)).appendChild((Element)v.get(222));

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
      ((Element)v.get(226)).setAttribute("nombre","lblCodigoSAP" );
      ((Element)v.get(226)).setAttribute("alto","13" );
      ((Element)v.get(226)).setAttribute("filas","1" );
      ((Element)v.get(226)).setAttribute("valor","" );
      ((Element)v.get(226)).setAttribute("id","datosTitle" );
      ((Element)v.get(226)).setAttribute("cod","585" );
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
      ((Element)v.get(230)).setAttribute("nombre","lblCodigoAntiguo" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(230)).setAttribute("alto","13" );
      ((Element)v.get(230)).setAttribute("filas","1" );
      ((Element)v.get(230)).setAttribute("valor","" );
      ((Element)v.get(230)).setAttribute("id","datosTitle" );
      ((Element)v.get(230)).setAttribute("cod","1059" );
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

      /* Empieza nodo:233 / Elemento padre: 218   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(218)).appendChild((Element)v.get(233));

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
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(237)).setAttribute("nombre","txtCodigoSAP" );
      ((Element)v.get(237)).setAttribute("id","datosCampos" );
      ((Element)v.get(237)).setAttribute("max","20" );
      ((Element)v.get(237)).setAttribute("tipo","" );
      ((Element)v.get(237)).setAttribute("onchange","" );
      ((Element)v.get(237)).setAttribute("req","N" );
      ((Element)v.get(237)).setAttribute("size","20" );
      ((Element)v.get(237)).setAttribute("valor","" );
      ((Element)v.get(237)).setAttribute("validacion","" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */
      /* Termina nodo:236   */

      /* Empieza nodo:238 / Elemento padre: 233   */
      v.add(doc.createElement("td"));
      ((Element)v.get(233)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(239)).setAttribute("src","b.gif" );
      ((Element)v.get(239)).setAttribute("width","25" );
      ((Element)v.get(239)).setAttribute("height","8" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */
      /* Termina nodo:238   */

      /* Empieza nodo:240 / Elemento padre: 233   */
      v.add(doc.createElement("td"));
      ((Element)v.get(240)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(233)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(241)).setAttribute("nombre","txtCodigoAntiguo" );
      ((Element)v.get(241)).setAttribute("id","datosCampos" );
      ((Element)v.get(241)).setAttribute("max","18" );
      ((Element)v.get(241)).setAttribute("tipo","" );
      ((Element)v.get(241)).setAttribute("onchange","" );
      ((Element)v.get(241)).setAttribute("req","N" );
      ((Element)v.get(241)).setAttribute("size","18" );
      ((Element)v.get(241)).setAttribute("valor","" );
      ((Element)v.get(241)).setAttribute("validacion","" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */
      /* Termina nodo:240   */

      /* Empieza nodo:242 / Elemento padre: 233   */
      v.add(doc.createElement("td"));
      ((Element)v.get(242)).setAttribute("width","100%" );
      ((Element)v.get(233)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(243)).setAttribute("src","b.gif" );
      ((Element)v.get(243)).setAttribute("width","8" );
      ((Element)v.get(243)).setAttribute("height","8" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:242   */
      /* Termina nodo:233   */

      /* Empieza nodo:244 / Elemento padre: 218   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(218)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(245)).setAttribute("colspan","4" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(246)).setAttribute("src","b.gif" );
      ((Element)v.get(246)).setAttribute("width","8" );
      ((Element)v.get(246)).setAttribute("height","8" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */
      /* Termina nodo:245   */
      /* Termina nodo:244   */
      /* Termina nodo:218   */
      /* Termina nodo:217   */
      /* Termina nodo:216   */

      /* Empieza nodo:247 / Elemento padre: 133   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(133)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("td"));
      ((Element)v.get(247)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("table"));
      ((Element)v.get(249)).setAttribute("width","699" );
      ((Element)v.get(249)).setAttribute("border","0" );
      ((Element)v.get(249)).setAttribute("align","left" );
      ((Element)v.get(249)).setAttribute("cellspacing","0" );
      ((Element)v.get(249)).setAttribute("cellpadding","0" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(249)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
   }

   private void getXML990(Document doc) {
      ((Element)v.get(250)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(252)).setAttribute("src","b.gif" );
      ((Element)v.get(252)).setAttribute("width","8" );
      ((Element)v.get(252)).setAttribute("height","8" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */
      /* Termina nodo:251   */

      /* Empieza nodo:253 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(254)).setAttribute("nombre","lblDescripcionSAP" );
      ((Element)v.get(254)).setAttribute("alto","13" );
      ((Element)v.get(254)).setAttribute("filas","1" );
      ((Element)v.get(254)).setAttribute("valor","" );
      ((Element)v.get(254)).setAttribute("id","datosTitle" );
      ((Element)v.get(254)).setAttribute("cod","1068" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */
      /* Termina nodo:253   */

      /* Empieza nodo:255 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(256)).setAttribute("src","b.gif" );
      ((Element)v.get(256)).setAttribute("width","25" );
      ((Element)v.get(256)).setAttribute("height","8" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */
      /* Termina nodo:255   */

      /* Empieza nodo:257 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(258)).setAttribute("nombre","lblDescripcionCorta" );
      ((Element)v.get(258)).setAttribute("alto","13" );
      ((Element)v.get(258)).setAttribute("filas","1" );
      ((Element)v.get(258)).setAttribute("valor","" );
      ((Element)v.get(258)).setAttribute("id","datosTitle" );
      ((Element)v.get(258)).setAttribute("cod","47" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */
      /* Termina nodo:257   */

      /* Empieza nodo:259 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(259)).setAttribute("width","100%" );
      ((Element)v.get(250)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(260)).setAttribute("src","b.gif" );
      ((Element)v.get(260)).setAttribute("width","8" );
      ((Element)v.get(260)).setAttribute("height","8" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:259   */
      /* Termina nodo:250   */

      /* Empieza nodo:261 / Elemento padre: 249   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(249)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("td"));
      ((Element)v.get(261)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(263)).setAttribute("src","b.gif" );
      ((Element)v.get(263)).setAttribute("width","8" );
      ((Element)v.get(263)).setAttribute("height","8" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:262   */

      /* Empieza nodo:264 / Elemento padre: 261   */
      v.add(doc.createElement("td"));
      ((Element)v.get(264)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(261)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(265)).setAttribute("nombre","txtDescripcionSAP" );
      ((Element)v.get(265)).setAttribute("id","datosCampos" );
      ((Element)v.get(265)).setAttribute("max","40" );
      ((Element)v.get(265)).setAttribute("tipo","" );
      ((Element)v.get(265)).setAttribute("onchange","" );
      ((Element)v.get(265)).setAttribute("req","N" );
      ((Element)v.get(265)).setAttribute("size","40" );
      ((Element)v.get(265)).setAttribute("valor","" );
      ((Element)v.get(265)).setAttribute("validacion","" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */

      /* Empieza nodo:266 / Elemento padre: 264   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(266)).setAttribute("src","iconmultidioma.gif" );
      ((Element)v.get(266)).setAttribute("width","21" );
      ((Element)v.get(266)).setAttribute("height","15" );
      ((Element)v.get(266)).setAttribute("onclick","levantarI18N('frmKitProductos','1');" );
      ((Element)v.get(264)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */
      /* Termina nodo:264   */

      /* Empieza nodo:267 / Elemento padre: 261   */
      v.add(doc.createElement("td"));
      ((Element)v.get(261)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(268)).setAttribute("src","b.gif" );
      ((Element)v.get(268)).setAttribute("width","25" );
      ((Element)v.get(268)).setAttribute("height","8" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */
      /* Termina nodo:267   */

      /* Empieza nodo:269 / Elemento padre: 261   */
      v.add(doc.createElement("td"));
      ((Element)v.get(269)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(261)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(270)).setAttribute("nombre","txtDescripcionCorta" );
      ((Element)v.get(270)).setAttribute("id","datosCampos" );
      ((Element)v.get(270)).setAttribute("max","40" );
      ((Element)v.get(270)).setAttribute("tipo","" );
      ((Element)v.get(270)).setAttribute("onchange","" );
      ((Element)v.get(270)).setAttribute("req","N" );
      ((Element)v.get(270)).setAttribute("size","40" );
      ((Element)v.get(270)).setAttribute("valor","" );
      ((Element)v.get(270)).setAttribute("validacion","" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(269)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */
      /* Termina nodo:269   */

      /* Empieza nodo:271 / Elemento padre: 261   */
      v.add(doc.createElement("td"));
      ((Element)v.get(271)).setAttribute("width","100%" );
      ((Element)v.get(261)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(272)).setAttribute("src","b.gif" );
      ((Element)v.get(272)).setAttribute("width","8" );
      ((Element)v.get(272)).setAttribute("height","8" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */
      /* Termina nodo:271   */
      /* Termina nodo:261   */

      /* Empieza nodo:273 / Elemento padre: 249   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(249)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("td"));
      ((Element)v.get(274)).setAttribute("colspan","4" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(275)).setAttribute("src","b.gif" );
      ((Element)v.get(275)).setAttribute("width","8" );
      ((Element)v.get(275)).setAttribute("height","8" );
      ((Element)v.get(274)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */
      /* Termina nodo:274   */
      /* Termina nodo:273   */
      /* Termina nodo:249   */
      /* Termina nodo:248   */
      /* Termina nodo:247   */

      /* Empieza nodo:276 / Elemento padre: 133   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(133)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("td"));
      ((Element)v.get(276)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("table"));
      ((Element)v.get(278)).setAttribute("width","699" );
      ((Element)v.get(278)).setAttribute("border","0" );
      ((Element)v.get(278)).setAttribute("align","left" );
      ((Element)v.get(278)).setAttribute("cellspacing","0" );
      ((Element)v.get(278)).setAttribute("cellpadding","0" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(278)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("td"));
      ((Element)v.get(279)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(281)).setAttribute("src","b.gif" );
      ((Element)v.get(281)).setAttribute("width","8" );
      ((Element)v.get(281)).setAttribute("height","8" );
      ((Element)v.get(280)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */
      /* Termina nodo:280   */

      /* Empieza nodo:282 / Elemento padre: 279   */
      v.add(doc.createElement("td"));
      ((Element)v.get(279)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(283)).setAttribute("nombre","lblIndicadorKit" );
      ((Element)v.get(283)).setAttribute("alto","13" );
      ((Element)v.get(283)).setAttribute("filas","1" );
      ((Element)v.get(283)).setAttribute("valor","" );
      ((Element)v.get(283)).setAttribute("id","datosTitle" );
      ((Element)v.get(283)).setAttribute("cod","1237" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */
      /* Termina nodo:282   */

      /* Empieza nodo:284 / Elemento padre: 279   */
      v.add(doc.createElement("td"));
      ((Element)v.get(279)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(285)).setAttribute("src","b.gif" );
      ((Element)v.get(285)).setAttribute("width","25" );
      ((Element)v.get(285)).setAttribute("height","8" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */
      /* Termina nodo:284   */

      /* Empieza nodo:286 / Elemento padre: 279   */
      v.add(doc.createElement("td"));
      ((Element)v.get(279)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(287)).setAttribute("nombre","lblIndicadorLote" );
      ((Element)v.get(287)).setAttribute("alto","13" );
      ((Element)v.get(287)).setAttribute("filas","1" );
      ((Element)v.get(287)).setAttribute("valor","" );
      ((Element)v.get(287)).setAttribute("id","datosTitle" );
      ((Element)v.get(287)).setAttribute("cod","1086" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */
      /* Termina nodo:286   */

      /* Empieza nodo:288 / Elemento padre: 279   */
      v.add(doc.createElement("td"));
      ((Element)v.get(279)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(289)).setAttribute("src","b.gif" );
      ((Element)v.get(289)).setAttribute("width","25" );
      ((Element)v.get(289)).setAttribute("height","8" );
      ((Element)v.get(288)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */
      /* Termina nodo:288   */

      /* Empieza nodo:290 / Elemento padre: 279   */
      v.add(doc.createElement("td"));
      ((Element)v.get(279)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(291)).setAttribute("nombre","lblIndicadorPS" );
      ((Element)v.get(291)).setAttribute("alto","13" );
      ((Element)v.get(291)).setAttribute("filas","1" );
      ((Element)v.get(291)).setAttribute("valor","" );
      ((Element)v.get(291)).setAttribute("id","datosTitle" );
      ((Element)v.get(291)).setAttribute("cod","1087" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */
      /* Termina nodo:290   */

      /* Empieza nodo:292 / Elemento padre: 279   */
      v.add(doc.createElement("td"));
      ((Element)v.get(279)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(293)).setAttribute("src","b.gif" );
      ((Element)v.get(293)).setAttribute("width","25" );
      ((Element)v.get(293)).setAttribute("height","8" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */
      /* Termina nodo:292   */

      /* Empieza nodo:294 / Elemento padre: 279   */
   }

   private void getXML1170(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(279)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(295)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(295)).setAttribute("alto","13" );
      ((Element)v.get(295)).setAttribute("filas","1" );
      ((Element)v.get(295)).setAttribute("valor","" );
      ((Element)v.get(295)).setAttribute("id","datosTitle" );
      ((Element)v.get(295)).setAttribute("cod","2448" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */
      /* Termina nodo:294   */

      /* Empieza nodo:296 / Elemento padre: 279   */
      v.add(doc.createElement("td"));
      ((Element)v.get(296)).setAttribute("width","100%" );
      ((Element)v.get(279)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(297)).setAttribute("src","b.gif" );
      ((Element)v.get(297)).setAttribute("width","8" );
      ((Element)v.get(297)).setAttribute("height","8" );
      ((Element)v.get(296)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */
      /* Termina nodo:296   */
      /* Termina nodo:279   */

      /* Empieza nodo:298 / Elemento padre: 278   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(278)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("td"));
      ((Element)v.get(298)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(300)).setAttribute("src","b.gif" );
      ((Element)v.get(300)).setAttribute("width","8" );
      ((Element)v.get(300)).setAttribute("height","8" );
      ((Element)v.get(299)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */
      /* Termina nodo:299   */

      /* Empieza nodo:301 / Elemento padre: 298   */
      v.add(doc.createElement("td"));
      ((Element)v.get(298)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(302)).setAttribute("nombre","lblIndicadorKitXX" );
      ((Element)v.get(302)).setAttribute("alto","13" );
      ((Element)v.get(302)).setAttribute("filas","1" );
      ((Element)v.get(302)).setAttribute("valor","" );
      ((Element)v.get(302)).setAttribute("id","datosCampos" );
      ((Element)v.get(302)).setAttribute("cod","117" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */
      /* Termina nodo:301   */

      /* Empieza nodo:303 / Elemento padre: 298   */
      v.add(doc.createElement("td"));
      ((Element)v.get(298)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(304)).setAttribute("src","b.gif" );
      ((Element)v.get(304)).setAttribute("width","25" );
      ((Element)v.get(304)).setAttribute("height","8" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */
      /* Termina nodo:303   */

      /* Empieza nodo:305 / Elemento padre: 298   */
      v.add(doc.createElement("td"));
      ((Element)v.get(305)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(298)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("table"));
      ((Element)v.get(305)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(306)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("td"));
      ((Element)v.get(308)).setAttribute("class","datosCampos" );
      ((Element)v.get(308)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(309)).setAttribute("nombre","rbIndicadorLote" );
      ((Element)v.get(309)).setAttribute("tipo","H" );
      ((Element)v.get(309)).setAttribute("id","datosCampos" );
      ((Element)v.get(309)).setAttribute("req","N" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(310)).setAttribute("valor","1" );
      ((Element)v.get(310)).setAttribute("check","" );
      ((Element)v.get(310)).setAttribute("onfocus","" );
      ((Element)v.get(310)).setAttribute("id","datosCampos" );
      ((Element)v.get(309)).appendChild((Element)v.get(310));

      /* Elemento padre:310 / Elemento actual: 311   */
      v.add(doc.createTextNode("Sí  "));
      ((Element)v.get(310)).appendChild((Text)v.get(311));

      /* Termina nodo Texto:311   */
      /* Termina nodo:310   */

      /* Empieza nodo:312 / Elemento padre: 309   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(312)).setAttribute("valor","0" );
      ((Element)v.get(312)).setAttribute("check","" );
      ((Element)v.get(312)).setAttribute("onfocus","" );
      ((Element)v.get(312)).setAttribute("id","datosCampos" );
      ((Element)v.get(309)).appendChild((Element)v.get(312));

      /* Elemento padre:312 / Elemento actual: 313   */
      v.add(doc.createTextNode("No"));
      ((Element)v.get(312)).appendChild((Text)v.get(313));

      /* Termina nodo Texto:313   */
      /* Termina nodo:312   */
      /* Termina nodo:309   */
      /* Termina nodo:308   */
      /* Termina nodo:307   */
      /* Termina nodo:306   */
      /* Termina nodo:305   */

      /* Empieza nodo:314 / Elemento padre: 298   */
      v.add(doc.createElement("td"));
      ((Element)v.get(298)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(315)).setAttribute("src","b.gif" );
      ((Element)v.get(315)).setAttribute("width","25" );
      ((Element)v.get(315)).setAttribute("height","8" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */
      /* Termina nodo:314   */

      /* Empieza nodo:316 / Elemento padre: 298   */
      v.add(doc.createElement("td"));
      ((Element)v.get(316)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(298)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(317)).setAttribute("nombre","cbIndicadorPS" );
      ((Element)v.get(317)).setAttribute("id","datosCampos" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(317)).setAttribute("size","1" );
      ((Element)v.get(317)).setAttribute("multiple","N" );
      ((Element)v.get(317)).setAttribute("req","N" );
      ((Element)v.get(317)).setAttribute("valorinicial","" );
      ((Element)v.get(317)).setAttribute("textoinicial","" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(317)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */
      /* Termina nodo:317   */
      /* Termina nodo:316   */

      /* Empieza nodo:319 / Elemento padre: 298   */
      v.add(doc.createElement("td"));
      ((Element)v.get(298)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(320)).setAttribute("src","b.gif" );
      ((Element)v.get(320)).setAttribute("width","25" );
      ((Element)v.get(320)).setAttribute("height","8" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */
      /* Termina nodo:319   */

      /* Empieza nodo:321 / Elemento padre: 298   */
      v.add(doc.createElement("td"));
      ((Element)v.get(298)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(322)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(322)).setAttribute("id","datosCampos" );
      ((Element)v.get(322)).setAttribute("size","1" );
      ((Element)v.get(322)).setAttribute("multiple","N" );
      ((Element)v.get(322)).setAttribute("req","N" );
      ((Element)v.get(322)).setAttribute("valorinicial","" );
      ((Element)v.get(322)).setAttribute("textoinicial","" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(322)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */
      /* Termina nodo:322   */
      /* Termina nodo:321   */

      /* Empieza nodo:324 / Elemento padre: 298   */
      v.add(doc.createElement("td"));
      ((Element)v.get(324)).setAttribute("width","100%" );
      ((Element)v.get(298)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(325)).setAttribute("src","b.gif" );
      ((Element)v.get(325)).setAttribute("width","8" );
      ((Element)v.get(325)).setAttribute("height","8" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */
      /* Termina nodo:324   */
      /* Termina nodo:298   */

      /* Empieza nodo:326 / Elemento padre: 278   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(278)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("td"));
      ((Element)v.get(327)).setAttribute("colspan","4" );
      ((Element)v.get(326)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(328)).setAttribute("src","b.gif" );
      ((Element)v.get(328)).setAttribute("width","8" );
      ((Element)v.get(328)).setAttribute("height","8" );
      ((Element)v.get(327)).appendChild((Element)v.get(328));
      /* Termina nodo:328   */
      /* Termina nodo:327   */
      /* Termina nodo:326   */
      /* Termina nodo:278   */
      /* Termina nodo:277   */
      /* Termina nodo:276   */

      /* Empieza nodo:329 / Elemento padre: 133   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(133)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("td"));
      ((Element)v.get(329)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("table"));
      ((Element)v.get(331)).setAttribute("width","699" );
      ((Element)v.get(331)).setAttribute("border","0" );
      ((Element)v.get(331)).setAttribute("align","left" );
      ((Element)v.get(331)).setAttribute("cellspacing","0" );
      ((Element)v.get(331)).setAttribute("cellpadding","0" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(331)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("td"));
      ((Element)v.get(332)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(334)).setAttribute("src","b.gif" );
      ((Element)v.get(334)).setAttribute("width","8" );
      ((Element)v.get(334)).setAttribute("height","8" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */
      /* Termina nodo:333   */

      /* Empieza nodo:335 / Elemento padre: 332   */
      v.add(doc.createElement("td"));
      ((Element)v.get(332)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(336)).setAttribute("nombre","lblUnidadNegocio" );
      ((Element)v.get(336)).setAttribute("alto","13" );
      ((Element)v.get(336)).setAttribute("filas","1" );
      ((Element)v.get(336)).setAttribute("valor","" );
      ((Element)v.get(336)).setAttribute("id","datosTitle" );
      ((Element)v.get(336)).setAttribute("cod","1338" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */
      /* Termina nodo:335   */

      /* Empieza nodo:337 / Elemento padre: 332   */
      v.add(doc.createElement("td"));
      ((Element)v.get(332)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(338)).setAttribute("src","b.gif" );
      ((Element)v.get(338)).setAttribute("width","25" );
      ((Element)v.get(338)).setAttribute("height","8" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */
      /* Termina nodo:337   */

      /* Empieza nodo:339 / Elemento padre: 332   */
      v.add(doc.createElement("td"));
      ((Element)v.get(332)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(340)).setAttribute("nombre","lblNegocio" );
      ((Element)v.get(340)).setAttribute("alto","13" );
      ((Element)v.get(340)).setAttribute("filas","1" );
      ((Element)v.get(340)).setAttribute("valor","" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(340)).setAttribute("id","datosTitle" );
      ((Element)v.get(340)).setAttribute("cod","588" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */
      /* Termina nodo:339   */

      /* Empieza nodo:341 / Elemento padre: 332   */
      v.add(doc.createElement("td"));
      ((Element)v.get(341)).setAttribute("width","100%" );
      ((Element)v.get(332)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(342)).setAttribute("src","b.gif" );
      ((Element)v.get(342)).setAttribute("width","8" );
      ((Element)v.get(342)).setAttribute("height","8" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */
      /* Termina nodo:341   */
      /* Termina nodo:332   */

      /* Empieza nodo:343 / Elemento padre: 331   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(331)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("td"));
      ((Element)v.get(343)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(345)).setAttribute("src","b.gif" );
      ((Element)v.get(345)).setAttribute("width","8" );
      ((Element)v.get(345)).setAttribute("height","8" );
      ((Element)v.get(344)).appendChild((Element)v.get(345));
      /* Termina nodo:345   */
      /* Termina nodo:344   */

      /* Empieza nodo:346 / Elemento padre: 343   */
      v.add(doc.createElement("td"));
      ((Element)v.get(346)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(343)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(347)).setAttribute("nombre","cbUnidadNegocio" );
      ((Element)v.get(347)).setAttribute("id","datosCampos" );
      ((Element)v.get(347)).setAttribute("size","1" );
      ((Element)v.get(347)).setAttribute("multiple","N" );
      ((Element)v.get(347)).setAttribute("req","N" );
      ((Element)v.get(347)).setAttribute("valorinicial","" );
      ((Element)v.get(347)).setAttribute("textoinicial","" );
      ((Element)v.get(346)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(347)).appendChild((Element)v.get(348));
      /* Termina nodo:348   */
      /* Termina nodo:347   */
      /* Termina nodo:346   */

      /* Empieza nodo:349 / Elemento padre: 343   */
      v.add(doc.createElement("td"));
      ((Element)v.get(343)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(350)).setAttribute("src","b.gif" );
      ((Element)v.get(350)).setAttribute("width","25" );
      ((Element)v.get(350)).setAttribute("height","8" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */
      /* Termina nodo:349   */

      /* Empieza nodo:351 / Elemento padre: 343   */
      v.add(doc.createElement("td"));
      ((Element)v.get(351)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(343)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(352)).setAttribute("nombre","cbNegocio" );
      ((Element)v.get(352)).setAttribute("id","datosCampos" );
      ((Element)v.get(352)).setAttribute("size","1" );
      ((Element)v.get(352)).setAttribute("multiple","N" );
      ((Element)v.get(352)).setAttribute("req","N" );
      ((Element)v.get(352)).setAttribute("valorinicial","" );
      ((Element)v.get(352)).setAttribute("textoinicial","" );
      ((Element)v.get(351)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(352)).appendChild((Element)v.get(353));
      /* Termina nodo:353   */
      /* Termina nodo:352   */
      /* Termina nodo:351   */

      /* Empieza nodo:354 / Elemento padre: 343   */
      v.add(doc.createElement("td"));
      ((Element)v.get(354)).setAttribute("width","100%" );
      ((Element)v.get(343)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(355)).setAttribute("src","b.gif" );
      ((Element)v.get(355)).setAttribute("width","8" );
      ((Element)v.get(355)).setAttribute("height","8" );
      ((Element)v.get(354)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */
      /* Termina nodo:354   */
      /* Termina nodo:343   */

      /* Empieza nodo:356 / Elemento padre: 331   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(331)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("td"));
      ((Element)v.get(357)).setAttribute("colspan","4" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(358)).setAttribute("src","b.gif" );
      ((Element)v.get(358)).setAttribute("width","8" );
      ((Element)v.get(358)).setAttribute("height","8" );
      ((Element)v.get(357)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */
      /* Termina nodo:357   */
      /* Termina nodo:356   */
      /* Termina nodo:331   */
      /* Termina nodo:330   */
      /* Termina nodo:329   */

      /* Empieza nodo:359 / Elemento padre: 133   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(133)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("td"));
      ((Element)v.get(359)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("table"));
      ((Element)v.get(361)).setAttribute("width","699" );
      ((Element)v.get(361)).setAttribute("border","0" );
      ((Element)v.get(361)).setAttribute("align","left" );
      ((Element)v.get(361)).setAttribute("cellspacing","0" );
      ((Element)v.get(361)).setAttribute("cellpadding","0" );
      ((Element)v.get(360)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(361)).appendChild((Element)v.get(362));

      /* Empieza nodo:363 / Elemento padre: 362   */
      v.add(doc.createElement("td"));
      ((Element)v.get(362)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(364)).setAttribute("src","b.gif" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(364)).setAttribute("width","8" );
      ((Element)v.get(364)).setAttribute("height","8" );
      ((Element)v.get(363)).appendChild((Element)v.get(364));
      /* Termina nodo:364   */
      /* Termina nodo:363   */

      /* Empieza nodo:365 / Elemento padre: 362   */
      v.add(doc.createElement("td"));
      ((Element)v.get(362)).appendChild((Element)v.get(365));

      /* Empieza nodo:366 / Elemento padre: 365   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(366)).setAttribute("nombre","lblGenerico" );
      ((Element)v.get(366)).setAttribute("alto","13" );
      ((Element)v.get(366)).setAttribute("filas","1" );
      ((Element)v.get(366)).setAttribute("valor","" );
      ((Element)v.get(366)).setAttribute("id","datosTitle" );
      ((Element)v.get(366)).setAttribute("cod","589" );
      ((Element)v.get(365)).appendChild((Element)v.get(366));
      /* Termina nodo:366   */
      /* Termina nodo:365   */

      /* Empieza nodo:367 / Elemento padre: 362   */
      v.add(doc.createElement("td"));
      ((Element)v.get(362)).appendChild((Element)v.get(367));

      /* Empieza nodo:368 / Elemento padre: 367   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(368)).setAttribute("src","b.gif" );
      ((Element)v.get(368)).setAttribute("width","25" );
      ((Element)v.get(368)).setAttribute("height","8" );
      ((Element)v.get(367)).appendChild((Element)v.get(368));
      /* Termina nodo:368   */
      /* Termina nodo:367   */

      /* Empieza nodo:369 / Elemento padre: 362   */
      v.add(doc.createElement("td"));
      ((Element)v.get(362)).appendChild((Element)v.get(369));

      /* Empieza nodo:370 / Elemento padre: 369   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(370)).setAttribute("nombre","lblSuperGenerico" );
      ((Element)v.get(370)).setAttribute("alto","13" );
      ((Element)v.get(370)).setAttribute("filas","1" );
      ((Element)v.get(370)).setAttribute("valor","" );
      ((Element)v.get(370)).setAttribute("id","datosTitle" );
      ((Element)v.get(370)).setAttribute("cod","590" );
      ((Element)v.get(369)).appendChild((Element)v.get(370));
      /* Termina nodo:370   */
      /* Termina nodo:369   */

      /* Empieza nodo:371 / Elemento padre: 362   */
      v.add(doc.createElement("td"));
      ((Element)v.get(371)).setAttribute("width","100%" );
      ((Element)v.get(362)).appendChild((Element)v.get(371));

      /* Empieza nodo:372 / Elemento padre: 371   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(372)).setAttribute("src","b.gif" );
      ((Element)v.get(372)).setAttribute("width","8" );
      ((Element)v.get(372)).setAttribute("height","8" );
      ((Element)v.get(371)).appendChild((Element)v.get(372));
      /* Termina nodo:372   */
      /* Termina nodo:371   */
      /* Termina nodo:362   */

      /* Empieza nodo:373 / Elemento padre: 361   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(361)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("td"));
      ((Element)v.get(373)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(375)).setAttribute("src","b.gif" );
      ((Element)v.get(375)).setAttribute("width","8" );
      ((Element)v.get(375)).setAttribute("height","8" );
      ((Element)v.get(374)).appendChild((Element)v.get(375));
      /* Termina nodo:375   */
      /* Termina nodo:374   */

      /* Empieza nodo:376 / Elemento padre: 373   */
      v.add(doc.createElement("td"));
      ((Element)v.get(376)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(373)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(377)).setAttribute("nombre","cbGenerico" );
      ((Element)v.get(377)).setAttribute("id","datosCampos" );
      ((Element)v.get(377)).setAttribute("size","1" );
      ((Element)v.get(377)).setAttribute("multiple","N" );
      ((Element)v.get(377)).setAttribute("req","N" );
      ((Element)v.get(377)).setAttribute("valorinicial","" );
      ((Element)v.get(377)).setAttribute("textoinicial","" );
      ((Element)v.get(376)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(377)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */
      /* Termina nodo:377   */
      /* Termina nodo:376   */

      /* Empieza nodo:379 / Elemento padre: 373   */
      v.add(doc.createElement("td"));
      ((Element)v.get(373)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(380)).setAttribute("src","b.gif" );
      ((Element)v.get(380)).setAttribute("width","25" );
      ((Element)v.get(380)).setAttribute("height","8" );
      ((Element)v.get(379)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */
      /* Termina nodo:379   */

      /* Empieza nodo:381 / Elemento padre: 373   */
      v.add(doc.createElement("td"));
      ((Element)v.get(381)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(373)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(382)).setAttribute("nombre","cbSuperGenerico" );
      ((Element)v.get(382)).setAttribute("id","datosCampos" );
      ((Element)v.get(382)).setAttribute("size","1" );
      ((Element)v.get(382)).setAttribute("multiple","N" );
      ((Element)v.get(382)).setAttribute("req","N" );
      ((Element)v.get(382)).setAttribute("valorinicial","" );
      ((Element)v.get(382)).setAttribute("textoinicial","" );
      ((Element)v.get(381)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(382)).appendChild((Element)v.get(383));
      /* Termina nodo:383   */
      /* Termina nodo:382   */
      /* Termina nodo:381   */

      /* Empieza nodo:384 / Elemento padre: 373   */
      v.add(doc.createElement("td"));
      ((Element)v.get(384)).setAttribute("width","100%" );
      ((Element)v.get(373)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(385)).setAttribute("src","b.gif" );
      ((Element)v.get(385)).setAttribute("width","8" );
      ((Element)v.get(385)).setAttribute("height","8" );
      ((Element)v.get(384)).appendChild((Element)v.get(385));
      /* Termina nodo:385   */
      /* Termina nodo:384   */
      /* Termina nodo:373   */

      /* Empieza nodo:386 / Elemento padre: 361   */
   }

   private void getXML1530(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(361)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("td"));
      ((Element)v.get(387)).setAttribute("colspan","4" );
      ((Element)v.get(386)).appendChild((Element)v.get(387));

      /* Empieza nodo:388 / Elemento padre: 387   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(388)).setAttribute("src","b.gif" );
      ((Element)v.get(388)).setAttribute("width","8" );
      ((Element)v.get(388)).setAttribute("height","8" );
      ((Element)v.get(387)).appendChild((Element)v.get(388));
      /* Termina nodo:388   */
      /* Termina nodo:387   */
      /* Termina nodo:386   */
      /* Termina nodo:361   */
      /* Termina nodo:360   */
      /* Termina nodo:359   */

      /* Empieza nodo:389 / Elemento padre: 133   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(133)).appendChild((Element)v.get(389));

      /* Empieza nodo:390 / Elemento padre: 389   */
      v.add(doc.createElement("td"));
      ((Element)v.get(389)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("table"));
      ((Element)v.get(391)).setAttribute("width","699" );
      ((Element)v.get(391)).setAttribute("border","0" );
      ((Element)v.get(391)).setAttribute("align","left" );
      ((Element)v.get(391)).setAttribute("cellspacing","0" );
      ((Element)v.get(391)).setAttribute("cellpadding","0" );
      ((Element)v.get(390)).appendChild((Element)v.get(391));

      /* Empieza nodo:392 / Elemento padre: 391   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(391)).appendChild((Element)v.get(392));

      /* Empieza nodo:393 / Elemento padre: 392   */
      v.add(doc.createElement("td"));
      ((Element)v.get(392)).appendChild((Element)v.get(393));

      /* Empieza nodo:394 / Elemento padre: 393   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(394)).setAttribute("src","b.gif" );
      ((Element)v.get(394)).setAttribute("width","8" );
      ((Element)v.get(394)).setAttribute("height","8" );
      ((Element)v.get(393)).appendChild((Element)v.get(394));
      /* Termina nodo:394   */
      /* Termina nodo:393   */

      /* Empieza nodo:395 / Elemento padre: 392   */
      v.add(doc.createElement("td"));
      ((Element)v.get(392)).appendChild((Element)v.get(395));

      /* Empieza nodo:396 / Elemento padre: 395   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(396)).setAttribute("nombre","lblJerarquia1" );
      ((Element)v.get(396)).setAttribute("alto","13" );
      ((Element)v.get(396)).setAttribute("filas","1" );
      ((Element)v.get(396)).setAttribute("valor","" );
      ((Element)v.get(396)).setAttribute("id","datosTitle" );
      ((Element)v.get(396)).setAttribute("cod","1088" );
      ((Element)v.get(395)).appendChild((Element)v.get(396));
      /* Termina nodo:396   */
      /* Termina nodo:395   */

      /* Empieza nodo:397 / Elemento padre: 392   */
      v.add(doc.createElement("td"));
      ((Element)v.get(392)).appendChild((Element)v.get(397));

      /* Empieza nodo:398 / Elemento padre: 397   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(398)).setAttribute("src","b.gif" );
      ((Element)v.get(398)).setAttribute("width","25" );
      ((Element)v.get(398)).setAttribute("height","8" );
      ((Element)v.get(397)).appendChild((Element)v.get(398));
      /* Termina nodo:398   */
      /* Termina nodo:397   */

      /* Empieza nodo:399 / Elemento padre: 392   */
      v.add(doc.createElement("td"));
      ((Element)v.get(392)).appendChild((Element)v.get(399));

      /* Empieza nodo:400 / Elemento padre: 399   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(400)).setAttribute("nombre","lblJerarquia2" );
      ((Element)v.get(400)).setAttribute("alto","13" );
      ((Element)v.get(400)).setAttribute("filas","1" );
      ((Element)v.get(400)).setAttribute("valor","" );
      ((Element)v.get(400)).setAttribute("id","datosTitle" );
      ((Element)v.get(400)).setAttribute("cod","1089" );
      ((Element)v.get(399)).appendChild((Element)v.get(400));
      /* Termina nodo:400   */
      /* Termina nodo:399   */

      /* Empieza nodo:401 / Elemento padre: 392   */
      v.add(doc.createElement("td"));
      ((Element)v.get(392)).appendChild((Element)v.get(401));

      /* Empieza nodo:402 / Elemento padre: 401   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(402)).setAttribute("src","b.gif" );
      ((Element)v.get(402)).setAttribute("width","25" );
      ((Element)v.get(402)).setAttribute("height","8" );
      ((Element)v.get(401)).appendChild((Element)v.get(402));
      /* Termina nodo:402   */
      /* Termina nodo:401   */

      /* Empieza nodo:403 / Elemento padre: 392   */
      v.add(doc.createElement("td"));
      ((Element)v.get(392)).appendChild((Element)v.get(403));

      /* Empieza nodo:404 / Elemento padre: 403   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(404)).setAttribute("nombre","lblJerarquia3" );
      ((Element)v.get(404)).setAttribute("alto","13" );
      ((Element)v.get(404)).setAttribute("filas","1" );
      ((Element)v.get(404)).setAttribute("valor","" );
      ((Element)v.get(404)).setAttribute("id","datosTitle" );
      ((Element)v.get(404)).setAttribute("cod","1090" );
      ((Element)v.get(403)).appendChild((Element)v.get(404));
      /* Termina nodo:404   */
      /* Termina nodo:403   */

      /* Empieza nodo:405 / Elemento padre: 392   */
      v.add(doc.createElement("td"));
      ((Element)v.get(392)).appendChild((Element)v.get(405));

      /* Empieza nodo:406 / Elemento padre: 405   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(406)).setAttribute("src","b.gif" );
      ((Element)v.get(406)).setAttribute("width","25" );
      ((Element)v.get(406)).setAttribute("height","8" );
      ((Element)v.get(405)).appendChild((Element)v.get(406));
      /* Termina nodo:406   */
      /* Termina nodo:405   */

      /* Empieza nodo:407 / Elemento padre: 392   */
      v.add(doc.createElement("td"));
      ((Element)v.get(392)).appendChild((Element)v.get(407));

      /* Empieza nodo:408 / Elemento padre: 407   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(408)).setAttribute("nombre","lblLinea" );
      ((Element)v.get(408)).setAttribute("alto","13" );
      ((Element)v.get(408)).setAttribute("filas","1" );
      ((Element)v.get(408)).setAttribute("valor","" );
      ((Element)v.get(408)).setAttribute("id","datosTitle" );
      ((Element)v.get(408)).setAttribute("cod","1091" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(407)).appendChild((Element)v.get(408));
      /* Termina nodo:408   */
      /* Termina nodo:407   */

      /* Empieza nodo:409 / Elemento padre: 392   */
      v.add(doc.createElement("td"));
      ((Element)v.get(392)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(410)).setAttribute("src","b.gif" );
      ((Element)v.get(410)).setAttribute("width","25" );
      ((Element)v.get(410)).setAttribute("height","8" );
      ((Element)v.get(409)).appendChild((Element)v.get(410));
      /* Termina nodo:410   */
      /* Termina nodo:409   */

      /* Empieza nodo:411 / Elemento padre: 392   */
      v.add(doc.createElement("td"));
      ((Element)v.get(392)).appendChild((Element)v.get(411));

      /* Empieza nodo:412 / Elemento padre: 411   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(412)).setAttribute("nombre","lblAtributo1" );
      ((Element)v.get(412)).setAttribute("alto","13" );
      ((Element)v.get(412)).setAttribute("filas","1" );
      ((Element)v.get(412)).setAttribute("valor","" );
      ((Element)v.get(412)).setAttribute("id","datosTitle" );
      ((Element)v.get(412)).setAttribute("cod","481" );
      ((Element)v.get(411)).appendChild((Element)v.get(412));
      /* Termina nodo:412   */
      /* Termina nodo:411   */

      /* Empieza nodo:413 / Elemento padre: 392   */
      v.add(doc.createElement("td"));
      ((Element)v.get(392)).appendChild((Element)v.get(413));

      /* Empieza nodo:414 / Elemento padre: 413   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(414)).setAttribute("src","b.gif" );
      ((Element)v.get(414)).setAttribute("width","25" );
      ((Element)v.get(414)).setAttribute("height","8" );
      ((Element)v.get(413)).appendChild((Element)v.get(414));
      /* Termina nodo:414   */
      /* Termina nodo:413   */

      /* Empieza nodo:415 / Elemento padre: 392   */
      v.add(doc.createElement("td"));
      ((Element)v.get(392)).appendChild((Element)v.get(415));

      /* Empieza nodo:416 / Elemento padre: 415   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(416)).setAttribute("nombre","lblAtributo2" );
      ((Element)v.get(416)).setAttribute("alto","13" );
      ((Element)v.get(416)).setAttribute("filas","1" );
      ((Element)v.get(416)).setAttribute("valor","Marca" );
      ((Element)v.get(416)).setAttribute("id","datosTitle" );
      ((Element)v.get(416)).setAttribute("cod","482" );
      ((Element)v.get(415)).appendChild((Element)v.get(416));
      /* Termina nodo:416   */
      /* Termina nodo:415   */

      /* Empieza nodo:417 / Elemento padre: 392   */
      v.add(doc.createElement("td"));
      ((Element)v.get(392)).appendChild((Element)v.get(417));

      /* Empieza nodo:418 / Elemento padre: 417   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(418)).setAttribute("src","b.gif" );
      ((Element)v.get(418)).setAttribute("width","25" );
      ((Element)v.get(418)).setAttribute("height","8" );
      ((Element)v.get(417)).appendChild((Element)v.get(418));
      /* Termina nodo:418   */
      /* Termina nodo:417   */

      /* Empieza nodo:419 / Elemento padre: 392   */
      v.add(doc.createElement("td"));
      ((Element)v.get(392)).appendChild((Element)v.get(419));

      /* Empieza nodo:420 / Elemento padre: 419   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(420)).setAttribute("nombre","lblAtributo3" );
      ((Element)v.get(420)).setAttribute("alto","13" );
      ((Element)v.get(420)).setAttribute("filas","1" );
      ((Element)v.get(420)).setAttribute("valor","" );
      ((Element)v.get(420)).setAttribute("id","datosTitle" );
      ((Element)v.get(420)).setAttribute("cod","483" );
      ((Element)v.get(419)).appendChild((Element)v.get(420));
      /* Termina nodo:420   */
      /* Termina nodo:419   */

      /* Empieza nodo:421 / Elemento padre: 392   */
      v.add(doc.createElement("td"));
      ((Element)v.get(421)).setAttribute("width","100%" );
      ((Element)v.get(392)).appendChild((Element)v.get(421));

      /* Empieza nodo:422 / Elemento padre: 421   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(422)).setAttribute("src","b.gif" );
      ((Element)v.get(422)).setAttribute("width","8" );
      ((Element)v.get(422)).setAttribute("height","8" );
      ((Element)v.get(421)).appendChild((Element)v.get(422));
      /* Termina nodo:422   */
      /* Termina nodo:421   */
      /* Termina nodo:392   */

      /* Empieza nodo:423 / Elemento padre: 391   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(391)).appendChild((Element)v.get(423));

      /* Empieza nodo:424 / Elemento padre: 423   */
      v.add(doc.createElement("td"));
      ((Element)v.get(423)).appendChild((Element)v.get(424));

      /* Empieza nodo:425 / Elemento padre: 424   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(425)).setAttribute("src","b.gif" );
      ((Element)v.get(425)).setAttribute("width","8" );
      ((Element)v.get(425)).setAttribute("height","8" );
      ((Element)v.get(424)).appendChild((Element)v.get(425));
      /* Termina nodo:425   */
      /* Termina nodo:424   */

      /* Empieza nodo:426 / Elemento padre: 423   */
      v.add(doc.createElement("td"));
      ((Element)v.get(426)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(426)).setAttribute("valign","bottom" );
      ((Element)v.get(423)).appendChild((Element)v.get(426));

      /* Empieza nodo:427 / Elemento padre: 426   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(427)).setAttribute("nombre","txtJerarquia1" );
      ((Element)v.get(427)).setAttribute("id","datosCampos" );
      ((Element)v.get(427)).setAttribute("max","3" );
      ((Element)v.get(427)).setAttribute("tipo","" );
      ((Element)v.get(427)).setAttribute("onchange","" );
      ((Element)v.get(427)).setAttribute("req","N" );
      ((Element)v.get(427)).setAttribute("size","3" );
      ((Element)v.get(427)).setAttribute("valor","" );
      ((Element)v.get(427)).setAttribute("validacion","" );
      ((Element)v.get(426)).appendChild((Element)v.get(427));
      /* Termina nodo:427   */
      /* Termina nodo:426   */

      /* Empieza nodo:428 / Elemento padre: 423   */
      v.add(doc.createElement("td"));
      ((Element)v.get(423)).appendChild((Element)v.get(428));

      /* Empieza nodo:429 / Elemento padre: 428   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(429)).setAttribute("src","b.gif" );
      ((Element)v.get(429)).setAttribute("width","25" );
      ((Element)v.get(429)).setAttribute("height","8" );
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(428)).appendChild((Element)v.get(429));
      /* Termina nodo:429   */
      /* Termina nodo:428   */

      /* Empieza nodo:430 / Elemento padre: 423   */
      v.add(doc.createElement("td"));
      ((Element)v.get(430)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(430)).setAttribute("valign","bottom" );
      ((Element)v.get(423)).appendChild((Element)v.get(430));

      /* Empieza nodo:431 / Elemento padre: 430   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(431)).setAttribute("nombre","txtJerarquia2" );
      ((Element)v.get(431)).setAttribute("id","datosCampos" );
      ((Element)v.get(431)).setAttribute("max","3" );
      ((Element)v.get(431)).setAttribute("tipo","" );
      ((Element)v.get(431)).setAttribute("onchange","" );
      ((Element)v.get(431)).setAttribute("req","N" );
      ((Element)v.get(431)).setAttribute("size","3" );
      ((Element)v.get(431)).setAttribute("valor","" );
      ((Element)v.get(431)).setAttribute("validacion","" );
      ((Element)v.get(430)).appendChild((Element)v.get(431));
      /* Termina nodo:431   */
      /* Termina nodo:430   */

      /* Empieza nodo:432 / Elemento padre: 423   */
      v.add(doc.createElement("td"));
      ((Element)v.get(423)).appendChild((Element)v.get(432));

      /* Empieza nodo:433 / Elemento padre: 432   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(433)).setAttribute("src","b.gif" );
      ((Element)v.get(433)).setAttribute("width","25" );
      ((Element)v.get(433)).setAttribute("height","8" );
      ((Element)v.get(432)).appendChild((Element)v.get(433));
      /* Termina nodo:433   */
      /* Termina nodo:432   */

      /* Empieza nodo:434 / Elemento padre: 423   */
      v.add(doc.createElement("td"));
      ((Element)v.get(434)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(434)).setAttribute("valign","bottom" );
      ((Element)v.get(423)).appendChild((Element)v.get(434));

      /* Empieza nodo:435 / Elemento padre: 434   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(435)).setAttribute("nombre","txtJerarquia3" );
      ((Element)v.get(435)).setAttribute("id","datosCampos" );
      ((Element)v.get(435)).setAttribute("max","3" );
      ((Element)v.get(435)).setAttribute("tipo","" );
      ((Element)v.get(435)).setAttribute("onchange","" );
      ((Element)v.get(435)).setAttribute("req","N" );
      ((Element)v.get(435)).setAttribute("size","3" );
      ((Element)v.get(435)).setAttribute("valor","" );
      ((Element)v.get(435)).setAttribute("validacion","" );
      ((Element)v.get(434)).appendChild((Element)v.get(435));
      /* Termina nodo:435   */
      /* Termina nodo:434   */

      /* Empieza nodo:436 / Elemento padre: 423   */
      v.add(doc.createElement("td"));
      ((Element)v.get(423)).appendChild((Element)v.get(436));

      /* Empieza nodo:437 / Elemento padre: 436   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(437)).setAttribute("src","b.gif" );
      ((Element)v.get(437)).setAttribute("width","25" );
      ((Element)v.get(437)).setAttribute("height","8" );
      ((Element)v.get(436)).appendChild((Element)v.get(437));
      /* Termina nodo:437   */
      /* Termina nodo:436   */

      /* Empieza nodo:438 / Elemento padre: 423   */
      v.add(doc.createElement("td"));
      ((Element)v.get(438)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(423)).appendChild((Element)v.get(438));

      /* Empieza nodo:439 / Elemento padre: 438   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(439)).setAttribute("nombre","cbLinea" );
      ((Element)v.get(439)).setAttribute("id","datosCampos" );
      ((Element)v.get(439)).setAttribute("size","1" );
      ((Element)v.get(439)).setAttribute("multiple","N" );
      ((Element)v.get(439)).setAttribute("req","N" );
      ((Element)v.get(439)).setAttribute("valorinicial","" );
      ((Element)v.get(439)).setAttribute("textoinicial","" );
      ((Element)v.get(438)).appendChild((Element)v.get(439));

      /* Empieza nodo:440 / Elemento padre: 439   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(439)).appendChild((Element)v.get(440));
      /* Termina nodo:440   */
      /* Termina nodo:439   */
      /* Termina nodo:438   */

      /* Empieza nodo:441 / Elemento padre: 423   */
      v.add(doc.createElement("td"));
      ((Element)v.get(423)).appendChild((Element)v.get(441));

      /* Empieza nodo:442 / Elemento padre: 441   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(442)).setAttribute("src","b.gif" );
      ((Element)v.get(442)).setAttribute("width","25" );
      ((Element)v.get(442)).setAttribute("height","8" );
      ((Element)v.get(441)).appendChild((Element)v.get(442));
      /* Termina nodo:442   */
      /* Termina nodo:441   */

      /* Empieza nodo:443 / Elemento padre: 423   */
      v.add(doc.createElement("td"));
      ((Element)v.get(443)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(443)).setAttribute("valign","bottom" );
      ((Element)v.get(423)).appendChild((Element)v.get(443));

      /* Empieza nodo:444 / Elemento padre: 443   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(444)).setAttribute("nombre","txtAtributo1" );
      ((Element)v.get(444)).setAttribute("id","datosCampos" );
      ((Element)v.get(444)).setAttribute("max","3" );
      ((Element)v.get(444)).setAttribute("tipo","" );
      ((Element)v.get(444)).setAttribute("onchange","" );
      ((Element)v.get(444)).setAttribute("req","N" );
      ((Element)v.get(444)).setAttribute("size","3" );
      ((Element)v.get(444)).setAttribute("valor","" );
      ((Element)v.get(444)).setAttribute("validacion","" );
      ((Element)v.get(443)).appendChild((Element)v.get(444));
      /* Termina nodo:444   */
      /* Termina nodo:443   */

      /* Empieza nodo:445 / Elemento padre: 423   */
      v.add(doc.createElement("td"));
      ((Element)v.get(423)).appendChild((Element)v.get(445));

      /* Empieza nodo:446 / Elemento padre: 445   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(446)).setAttribute("src","b.gif" );
      ((Element)v.get(446)).setAttribute("width","25" );
      ((Element)v.get(446)).setAttribute("height","8" );
      ((Element)v.get(445)).appendChild((Element)v.get(446));
      /* Termina nodo:446   */
      /* Termina nodo:445   */

      /* Empieza nodo:447 / Elemento padre: 423   */
      v.add(doc.createElement("td"));
      ((Element)v.get(447)).setAttribute("nowrap","nowrap" );
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(447)).setAttribute("valign","bottom" );
      ((Element)v.get(423)).appendChild((Element)v.get(447));

      /* Empieza nodo:448 / Elemento padre: 447   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(448)).setAttribute("nombre","txtAtributo2" );
      ((Element)v.get(448)).setAttribute("id","datosCampos" );
      ((Element)v.get(448)).setAttribute("max","4" );
      ((Element)v.get(448)).setAttribute("tipo","" );
      ((Element)v.get(448)).setAttribute("onchange","" );
      ((Element)v.get(448)).setAttribute("req","N" );
      ((Element)v.get(448)).setAttribute("size","4" );
      ((Element)v.get(448)).setAttribute("valor","" );
      ((Element)v.get(448)).setAttribute("validacion","" );
      ((Element)v.get(447)).appendChild((Element)v.get(448));
      /* Termina nodo:448   */
      /* Termina nodo:447   */

      /* Empieza nodo:449 / Elemento padre: 423   */
      v.add(doc.createElement("td"));
      ((Element)v.get(423)).appendChild((Element)v.get(449));

      /* Empieza nodo:450 / Elemento padre: 449   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(450)).setAttribute("src","b.gif" );
      ((Element)v.get(450)).setAttribute("width","25" );
      ((Element)v.get(450)).setAttribute("height","8" );
      ((Element)v.get(449)).appendChild((Element)v.get(450));
      /* Termina nodo:450   */
      /* Termina nodo:449   */

      /* Empieza nodo:451 / Elemento padre: 423   */
      v.add(doc.createElement("td"));
      ((Element)v.get(451)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(451)).setAttribute("valign","bottom" );
      ((Element)v.get(423)).appendChild((Element)v.get(451));

      /* Empieza nodo:452 / Elemento padre: 451   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(452)).setAttribute("nombre","txtAtributo3" );
      ((Element)v.get(452)).setAttribute("id","datosCampos" );
      ((Element)v.get(452)).setAttribute("max","10" );
      ((Element)v.get(452)).setAttribute("tipo","" );
      ((Element)v.get(452)).setAttribute("onchange","" );
      ((Element)v.get(452)).setAttribute("req","N" );
      ((Element)v.get(452)).setAttribute("size","10" );
      ((Element)v.get(452)).setAttribute("valor","" );
      ((Element)v.get(452)).setAttribute("validacion","" );
      ((Element)v.get(451)).appendChild((Element)v.get(452));
      /* Termina nodo:452   */
      /* Termina nodo:451   */

      /* Empieza nodo:453 / Elemento padre: 423   */
      v.add(doc.createElement("td"));
      ((Element)v.get(453)).setAttribute("width","100%" );
      ((Element)v.get(423)).appendChild((Element)v.get(453));

      /* Empieza nodo:454 / Elemento padre: 453   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(454)).setAttribute("src","b.gif" );
      ((Element)v.get(454)).setAttribute("width","8" );
      ((Element)v.get(454)).setAttribute("height","8" );
      ((Element)v.get(453)).appendChild((Element)v.get(454));
      /* Termina nodo:454   */
      /* Termina nodo:453   */
      /* Termina nodo:423   */

      /* Empieza nodo:455 / Elemento padre: 391   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(391)).appendChild((Element)v.get(455));

      /* Empieza nodo:456 / Elemento padre: 455   */
      v.add(doc.createElement("td"));
      ((Element)v.get(456)).setAttribute("colspan","4" );
      ((Element)v.get(455)).appendChild((Element)v.get(456));

      /* Empieza nodo:457 / Elemento padre: 456   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(457)).setAttribute("src","b.gif" );
      ((Element)v.get(457)).setAttribute("width","8" );
      ((Element)v.get(457)).setAttribute("height","8" );
      ((Element)v.get(456)).appendChild((Element)v.get(457));
      /* Termina nodo:457   */
      /* Termina nodo:456   */
      /* Termina nodo:455   */
      /* Termina nodo:391   */
      /* Termina nodo:390   */
      /* Termina nodo:389   */

      /* Empieza nodo:458 / Elemento padre: 133   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(133)).appendChild((Element)v.get(458));

      /* Empieza nodo:459 / Elemento padre: 458   */
      v.add(doc.createElement("td"));
      ((Element)v.get(458)).appendChild((Element)v.get(459));

      /* Empieza nodo:460 / Elemento padre: 459   */
      v.add(doc.createElement("table"));
      ((Element)v.get(460)).setAttribute("width","699" );
      ((Element)v.get(460)).setAttribute("border","0" );
      ((Element)v.get(460)).setAttribute("align","left" );
      ((Element)v.get(460)).setAttribute("cellspacing","0" );
      ((Element)v.get(460)).setAttribute("cellpadding","0" );
      ((Element)v.get(459)).appendChild((Element)v.get(460));

      /* Empieza nodo:461 / Elemento padre: 460   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(460)).appendChild((Element)v.get(461));

      /* Empieza nodo:462 / Elemento padre: 461   */
      v.add(doc.createElement("td"));
      ((Element)v.get(461)).appendChild((Element)v.get(462));

      /* Empieza nodo:463 / Elemento padre: 462   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(463)).setAttribute("src","b.gif" );
      ((Element)v.get(463)).setAttribute("width","8" );
      ((Element)v.get(463)).setAttribute("height","8" );
      ((Element)v.get(462)).appendChild((Element)v.get(463));
      /* Termina nodo:463   */
      /* Termina nodo:462   */

      /* Empieza nodo:464 / Elemento padre: 461   */
      v.add(doc.createElement("td"));
      ((Element)v.get(461)).appendChild((Element)v.get(464));

      /* Empieza nodo:465 / Elemento padre: 464   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(465)).setAttribute("nombre","lblDimensionAlto" );
      ((Element)v.get(465)).setAttribute("alto","13" );
      ((Element)v.get(465)).setAttribute("filas","1" );
      ((Element)v.get(465)).setAttribute("valor","" );
      ((Element)v.get(465)).setAttribute("id","datosTitle" );
      ((Element)v.get(465)).setAttribute("cod","1070" );
      ((Element)v.get(464)).appendChild((Element)v.get(465));
      /* Termina nodo:465   */
      /* Termina nodo:464   */

      /* Empieza nodo:466 / Elemento padre: 461   */
      v.add(doc.createElement("td"));
      ((Element)v.get(461)).appendChild((Element)v.get(466));

      /* Empieza nodo:467 / Elemento padre: 466   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(467)).setAttribute("src","b.gif" );
      ((Element)v.get(467)).setAttribute("width","25" );
      ((Element)v.get(467)).setAttribute("height","8" );
      ((Element)v.get(466)).appendChild((Element)v.get(467));
      /* Termina nodo:467   */
      /* Termina nodo:466   */

      /* Empieza nodo:468 / Elemento padre: 461   */
   }

   private void getXML1890(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(461)).appendChild((Element)v.get(468));

      /* Empieza nodo:469 / Elemento padre: 468   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(469)).setAttribute("nombre","lblDimensionLargo" );
      ((Element)v.get(469)).setAttribute("alto","13" );
      ((Element)v.get(469)).setAttribute("filas","1" );
      ((Element)v.get(469)).setAttribute("valor","Marca" );
      ((Element)v.get(469)).setAttribute("id","datosTitle" );
      ((Element)v.get(469)).setAttribute("cod","1072" );
      ((Element)v.get(468)).appendChild((Element)v.get(469));
      /* Termina nodo:469   */
      /* Termina nodo:468   */

      /* Empieza nodo:470 / Elemento padre: 461   */
      v.add(doc.createElement("td"));
      ((Element)v.get(461)).appendChild((Element)v.get(470));

      /* Empieza nodo:471 / Elemento padre: 470   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(471)).setAttribute("src","b.gif" );
      ((Element)v.get(471)).setAttribute("width","25" );
      ((Element)v.get(471)).setAttribute("height","8" );
      ((Element)v.get(470)).appendChild((Element)v.get(471));
      /* Termina nodo:471   */
      /* Termina nodo:470   */

      /* Empieza nodo:472 / Elemento padre: 461   */
      v.add(doc.createElement("td"));
      ((Element)v.get(461)).appendChild((Element)v.get(472));

      /* Empieza nodo:473 / Elemento padre: 472   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(473)).setAttribute("nombre","lblDimensionAncho" );
      ((Element)v.get(473)).setAttribute("alto","13" );
      ((Element)v.get(473)).setAttribute("filas","1" );
      ((Element)v.get(473)).setAttribute("valor","" );
      ((Element)v.get(473)).setAttribute("id","datosTitle" );
      ((Element)v.get(473)).setAttribute("cod","1071" );
      ((Element)v.get(472)).appendChild((Element)v.get(473));
      /* Termina nodo:473   */
      /* Termina nodo:472   */

      /* Empieza nodo:474 / Elemento padre: 461   */
      v.add(doc.createElement("td"));
      ((Element)v.get(461)).appendChild((Element)v.get(474));

      /* Empieza nodo:475 / Elemento padre: 474   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(475)).setAttribute("src","b.gif" );
      ((Element)v.get(475)).setAttribute("width","25" );
      ((Element)v.get(475)).setAttribute("height","8" );
      ((Element)v.get(474)).appendChild((Element)v.get(475));
      /* Termina nodo:475   */
      /* Termina nodo:474   */

      /* Empieza nodo:476 / Elemento padre: 461   */
      v.add(doc.createElement("td"));
      ((Element)v.get(461)).appendChild((Element)v.get(476));

      /* Empieza nodo:477 / Elemento padre: 476   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(477)).setAttribute("nombre","lblUnidadMedidaDimensiones" );
      ((Element)v.get(477)).setAttribute("alto","13" );
      ((Element)v.get(477)).setAttribute("filas","1" );
      ((Element)v.get(477)).setAttribute("valor","" );
      ((Element)v.get(477)).setAttribute("id","datosTitle" );
      ((Element)v.get(477)).setAttribute("cod","1133" );
      ((Element)v.get(476)).appendChild((Element)v.get(477));
      /* Termina nodo:477   */
      /* Termina nodo:476   */

      /* Empieza nodo:478 / Elemento padre: 461   */
      v.add(doc.createElement("td"));
      ((Element)v.get(461)).appendChild((Element)v.get(478));

      /* Empieza nodo:479 / Elemento padre: 478   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(479)).setAttribute("src","b.gif" );
      ((Element)v.get(479)).setAttribute("width","25" );
      ((Element)v.get(479)).setAttribute("height","8" );
      ((Element)v.get(478)).appendChild((Element)v.get(479));
      /* Termina nodo:479   */
      /* Termina nodo:478   */

      /* Empieza nodo:480 / Elemento padre: 461   */
      v.add(doc.createElement("td"));
      ((Element)v.get(461)).appendChild((Element)v.get(480));

      /* Empieza nodo:481 / Elemento padre: 480   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(481)).setAttribute("nombre","lblVolumen" );
      ((Element)v.get(481)).setAttribute("alto","13" );
      ((Element)v.get(481)).setAttribute("filas","1" );
      ((Element)v.get(481)).setAttribute("valor","" );
      ((Element)v.get(481)).setAttribute("id","datosTitle" );
      ((Element)v.get(481)).setAttribute("cod","1140" );
      ((Element)v.get(480)).appendChild((Element)v.get(481));
      /* Termina nodo:481   */
      /* Termina nodo:480   */

      /* Empieza nodo:482 / Elemento padre: 461   */
      v.add(doc.createElement("td"));
      ((Element)v.get(461)).appendChild((Element)v.get(482));

      /* Empieza nodo:483 / Elemento padre: 482   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(483)).setAttribute("src","b.gif" );
      ((Element)v.get(483)).setAttribute("width","25" );
      ((Element)v.get(483)).setAttribute("height","8" );
      ((Element)v.get(482)).appendChild((Element)v.get(483));
      /* Termina nodo:483   */
      /* Termina nodo:482   */

      /* Empieza nodo:484 / Elemento padre: 461   */
      v.add(doc.createElement("td"));
      ((Element)v.get(461)).appendChild((Element)v.get(484));

      /* Empieza nodo:485 / Elemento padre: 484   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(485)).setAttribute("nombre","lblUnidadMedidaVolumen" );
      ((Element)v.get(485)).setAttribute("alto","13" );
      ((Element)v.get(485)).setAttribute("filas","1" );
      ((Element)v.get(485)).setAttribute("valor","Marca" );
      ((Element)v.get(485)).setAttribute("id","datosTitle" );
      ((Element)v.get(485)).setAttribute("cod","1135" );
      ((Element)v.get(484)).appendChild((Element)v.get(485));
      /* Termina nodo:485   */
      /* Termina nodo:484   */

      /* Empieza nodo:486 / Elemento padre: 461   */
      v.add(doc.createElement("td"));
      ((Element)v.get(486)).setAttribute("width","100%" );
      ((Element)v.get(461)).appendChild((Element)v.get(486));

      /* Empieza nodo:487 / Elemento padre: 486   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(487)).setAttribute("src","b.gif" );
      ((Element)v.get(487)).setAttribute("width","8" );
      ((Element)v.get(487)).setAttribute("height","8" );
      ((Element)v.get(486)).appendChild((Element)v.get(487));
      /* Termina nodo:487   */
      /* Termina nodo:486   */
      /* Termina nodo:461   */

      /* Empieza nodo:488 / Elemento padre: 460   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(460)).appendChild((Element)v.get(488));

      /* Empieza nodo:489 / Elemento padre: 488   */
      v.add(doc.createElement("td"));
      ((Element)v.get(488)).appendChild((Element)v.get(489));

      /* Empieza nodo:490 / Elemento padre: 489   */
   }

   private void getXML1980(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(490)).setAttribute("src","b.gif" );
      ((Element)v.get(490)).setAttribute("width","8" );
      ((Element)v.get(490)).setAttribute("height","8" );
      ((Element)v.get(489)).appendChild((Element)v.get(490));
      /* Termina nodo:490   */
      /* Termina nodo:489   */

      /* Empieza nodo:491 / Elemento padre: 488   */
      v.add(doc.createElement("td"));
      ((Element)v.get(491)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(491)).setAttribute("valign","bottom" );
      ((Element)v.get(488)).appendChild((Element)v.get(491));

      /* Empieza nodo:492 / Elemento padre: 491   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(492)).setAttribute("nombre","txtDimensionAlto" );
      ((Element)v.get(492)).setAttribute("id","datosCampos" );
      ((Element)v.get(492)).setAttribute("max","6" );
      ((Element)v.get(492)).setAttribute("tipo","" );
      ((Element)v.get(492)).setAttribute("onchange","" );
      ((Element)v.get(492)).setAttribute("req","N" );
      ((Element)v.get(492)).setAttribute("size","6" );
      ((Element)v.get(492)).setAttribute("valor","" );
      ((Element)v.get(492)).setAttribute("validacion","" );
      ((Element)v.get(491)).appendChild((Element)v.get(492));
      /* Termina nodo:492   */
      /* Termina nodo:491   */

      /* Empieza nodo:493 / Elemento padre: 488   */
      v.add(doc.createElement("td"));
      ((Element)v.get(488)).appendChild((Element)v.get(493));

      /* Empieza nodo:494 / Elemento padre: 493   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(494)).setAttribute("src","b.gif" );
      ((Element)v.get(494)).setAttribute("width","25" );
      ((Element)v.get(494)).setAttribute("height","8" );
      ((Element)v.get(493)).appendChild((Element)v.get(494));
      /* Termina nodo:494   */
      /* Termina nodo:493   */

      /* Empieza nodo:495 / Elemento padre: 488   */
      v.add(doc.createElement("td"));
      ((Element)v.get(495)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(495)).setAttribute("valign","bottom" );
      ((Element)v.get(488)).appendChild((Element)v.get(495));

      /* Empieza nodo:496 / Elemento padre: 495   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(496)).setAttribute("nombre","txtDimensionLargo" );
      ((Element)v.get(496)).setAttribute("id","datosCampos" );
      ((Element)v.get(496)).setAttribute("max","6" );
      ((Element)v.get(496)).setAttribute("tipo","" );
      ((Element)v.get(496)).setAttribute("onchange","" );
      ((Element)v.get(496)).setAttribute("req","N" );
      ((Element)v.get(496)).setAttribute("size","6" );
      ((Element)v.get(496)).setAttribute("valor","" );
      ((Element)v.get(496)).setAttribute("validacion","" );
      ((Element)v.get(495)).appendChild((Element)v.get(496));
      /* Termina nodo:496   */
      /* Termina nodo:495   */

      /* Empieza nodo:497 / Elemento padre: 488   */
      v.add(doc.createElement("td"));
      ((Element)v.get(488)).appendChild((Element)v.get(497));

      /* Empieza nodo:498 / Elemento padre: 497   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(498)).setAttribute("src","b.gif" );
      ((Element)v.get(498)).setAttribute("width","25" );
      ((Element)v.get(498)).setAttribute("height","8" );
      ((Element)v.get(497)).appendChild((Element)v.get(498));
      /* Termina nodo:498   */
      /* Termina nodo:497   */

      /* Empieza nodo:499 / Elemento padre: 488   */
      v.add(doc.createElement("td"));
      ((Element)v.get(499)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(499)).setAttribute("valign","bottom" );
      ((Element)v.get(488)).appendChild((Element)v.get(499));

      /* Empieza nodo:500 / Elemento padre: 499   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(500)).setAttribute("nombre","txtDimensionAncho" );
      ((Element)v.get(500)).setAttribute("id","datosCampos" );
      ((Element)v.get(500)).setAttribute("max","6" );
      ((Element)v.get(500)).setAttribute("tipo","" );
      ((Element)v.get(500)).setAttribute("onchange","" );
      ((Element)v.get(500)).setAttribute("req","N" );
      ((Element)v.get(500)).setAttribute("size","6" );
      ((Element)v.get(500)).setAttribute("valor","" );
      ((Element)v.get(500)).setAttribute("validacion","" );
      ((Element)v.get(499)).appendChild((Element)v.get(500));
      /* Termina nodo:500   */
      /* Termina nodo:499   */

      /* Empieza nodo:501 / Elemento padre: 488   */
      v.add(doc.createElement("td"));
      ((Element)v.get(488)).appendChild((Element)v.get(501));

      /* Empieza nodo:502 / Elemento padre: 501   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(502)).setAttribute("src","b.gif" );
      ((Element)v.get(502)).setAttribute("width","25" );
      ((Element)v.get(502)).setAttribute("height","8" );
      ((Element)v.get(501)).appendChild((Element)v.get(502));
      /* Termina nodo:502   */
      /* Termina nodo:501   */

      /* Empieza nodo:503 / Elemento padre: 488   */
      v.add(doc.createElement("td"));
      ((Element)v.get(488)).appendChild((Element)v.get(503));

      /* Empieza nodo:504 / Elemento padre: 503   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(504)).setAttribute("nombre","cbUnidadMedidaDimensiones" );
      ((Element)v.get(504)).setAttribute("id","datosCampos" );
      ((Element)v.get(504)).setAttribute("size","1" );
      ((Element)v.get(504)).setAttribute("multiple","N" );
      ((Element)v.get(504)).setAttribute("req","N" );
      ((Element)v.get(504)).setAttribute("valorinicial","" );
      ((Element)v.get(504)).setAttribute("textoinicial","" );
      ((Element)v.get(503)).appendChild((Element)v.get(504));

      /* Empieza nodo:505 / Elemento padre: 504   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(504)).appendChild((Element)v.get(505));
      /* Termina nodo:505   */
      /* Termina nodo:504   */
      /* Termina nodo:503   */

      /* Empieza nodo:506 / Elemento padre: 488   */
      v.add(doc.createElement("td"));
      ((Element)v.get(488)).appendChild((Element)v.get(506));

      /* Empieza nodo:507 / Elemento padre: 506   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(507)).setAttribute("src","b.gif" );
      ((Element)v.get(507)).setAttribute("width","25" );
      ((Element)v.get(507)).setAttribute("height","8" );
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(506)).appendChild((Element)v.get(507));
      /* Termina nodo:507   */
      /* Termina nodo:506   */

      /* Empieza nodo:508 / Elemento padre: 488   */
      v.add(doc.createElement("td"));
      ((Element)v.get(508)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(508)).setAttribute("valign","bottom" );
      ((Element)v.get(488)).appendChild((Element)v.get(508));

      /* Empieza nodo:509 / Elemento padre: 508   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(509)).setAttribute("nombre","txtVolumen" );
      ((Element)v.get(509)).setAttribute("id","datosCampos" );
      ((Element)v.get(509)).setAttribute("max","6" );
      ((Element)v.get(509)).setAttribute("tipo","" );
      ((Element)v.get(509)).setAttribute("onchange","" );
      ((Element)v.get(509)).setAttribute("req","N" );
      ((Element)v.get(509)).setAttribute("size","6" );
      ((Element)v.get(509)).setAttribute("valor","" );
      ((Element)v.get(509)).setAttribute("validacion","" );
      ((Element)v.get(508)).appendChild((Element)v.get(509));
      /* Termina nodo:509   */
      /* Termina nodo:508   */

      /* Empieza nodo:510 / Elemento padre: 488   */
      v.add(doc.createElement("td"));
      ((Element)v.get(488)).appendChild((Element)v.get(510));

      /* Empieza nodo:511 / Elemento padre: 510   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(511)).setAttribute("src","b.gif" );
      ((Element)v.get(511)).setAttribute("width","25" );
      ((Element)v.get(511)).setAttribute("height","8" );
      ((Element)v.get(510)).appendChild((Element)v.get(511));
      /* Termina nodo:511   */
      /* Termina nodo:510   */

      /* Empieza nodo:512 / Elemento padre: 488   */
      v.add(doc.createElement("td"));
      ((Element)v.get(488)).appendChild((Element)v.get(512));

      /* Empieza nodo:513 / Elemento padre: 512   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(513)).setAttribute("nombre","cbUnidadMedidaVolumen" );
      ((Element)v.get(513)).setAttribute("id","datosCampos" );
      ((Element)v.get(513)).setAttribute("size","1" );
      ((Element)v.get(513)).setAttribute("multiple","N" );
      ((Element)v.get(513)).setAttribute("req","N" );
      ((Element)v.get(513)).setAttribute("valorinicial","" );
      ((Element)v.get(513)).setAttribute("textoinicial","" );
      ((Element)v.get(512)).appendChild((Element)v.get(513));

      /* Empieza nodo:514 / Elemento padre: 513   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(513)).appendChild((Element)v.get(514));
      /* Termina nodo:514   */
      /* Termina nodo:513   */
      /* Termina nodo:512   */

      /* Empieza nodo:515 / Elemento padre: 488   */
      v.add(doc.createElement("td"));
      ((Element)v.get(515)).setAttribute("width","100%" );
      ((Element)v.get(488)).appendChild((Element)v.get(515));

      /* Empieza nodo:516 / Elemento padre: 515   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(516)).setAttribute("src","b.gif" );
      ((Element)v.get(516)).setAttribute("width","8" );
      ((Element)v.get(516)).setAttribute("height","8" );
      ((Element)v.get(515)).appendChild((Element)v.get(516));
      /* Termina nodo:516   */
      /* Termina nodo:515   */
      /* Termina nodo:488   */

      /* Empieza nodo:517 / Elemento padre: 460   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(460)).appendChild((Element)v.get(517));

      /* Empieza nodo:518 / Elemento padre: 517   */
      v.add(doc.createElement("td"));
      ((Element)v.get(518)).setAttribute("colspan","4" );
      ((Element)v.get(517)).appendChild((Element)v.get(518));

      /* Empieza nodo:519 / Elemento padre: 518   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(519)).setAttribute("src","b.gif" );
      ((Element)v.get(519)).setAttribute("width","8" );
      ((Element)v.get(519)).setAttribute("height","8" );
      ((Element)v.get(518)).appendChild((Element)v.get(519));
      /* Termina nodo:519   */
      /* Termina nodo:518   */
      /* Termina nodo:517   */
      /* Termina nodo:460   */
      /* Termina nodo:459   */
      /* Termina nodo:458   */

      /* Empieza nodo:520 / Elemento padre: 133   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(133)).appendChild((Element)v.get(520));

      /* Empieza nodo:521 / Elemento padre: 520   */
      v.add(doc.createElement("td"));
      ((Element)v.get(520)).appendChild((Element)v.get(521));

      /* Empieza nodo:522 / Elemento padre: 521   */
      v.add(doc.createElement("table"));
      ((Element)v.get(522)).setAttribute("width","699" );
      ((Element)v.get(522)).setAttribute("border","0" );
      ((Element)v.get(522)).setAttribute("align","left" );
      ((Element)v.get(522)).setAttribute("cellspacing","0" );
      ((Element)v.get(522)).setAttribute("cellpadding","0" );
      ((Element)v.get(521)).appendChild((Element)v.get(522));

      /* Empieza nodo:523 / Elemento padre: 522   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(522)).appendChild((Element)v.get(523));

      /* Empieza nodo:524 / Elemento padre: 523   */
      v.add(doc.createElement("td"));
      ((Element)v.get(523)).appendChild((Element)v.get(524));

      /* Empieza nodo:525 / Elemento padre: 524   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(525)).setAttribute("src","b.gif" );
      ((Element)v.get(525)).setAttribute("width","8" );
      ((Element)v.get(525)).setAttribute("height","8" );
      ((Element)v.get(524)).appendChild((Element)v.get(525));
      /* Termina nodo:525   */
      /* Termina nodo:524   */

      /* Empieza nodo:526 / Elemento padre: 523   */
      v.add(doc.createElement("td"));
      ((Element)v.get(523)).appendChild((Element)v.get(526));

      /* Empieza nodo:527 / Elemento padre: 526   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(527)).setAttribute("nombre","lblPeso" );
      ((Element)v.get(527)).setAttribute("alto","13" );
      ((Element)v.get(527)).setAttribute("filas","1" );
      ((Element)v.get(527)).setAttribute("valor","" );
      ((Element)v.get(527)).setAttribute("id","datosTitle" );
      ((Element)v.get(527)).setAttribute("cod","1115" );
      ((Element)v.get(526)).appendChild((Element)v.get(527));
      /* Termina nodo:527   */
      /* Termina nodo:526   */

      /* Empieza nodo:528 / Elemento padre: 523   */
      v.add(doc.createElement("td"));
      ((Element)v.get(523)).appendChild((Element)v.get(528));

      /* Empieza nodo:529 / Elemento padre: 528   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(529)).setAttribute("src","b.gif" );
      ((Element)v.get(529)).setAttribute("width","25" );
      ((Element)v.get(529)).setAttribute("height","8" );
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(528)).appendChild((Element)v.get(529));
      /* Termina nodo:529   */
      /* Termina nodo:528   */

      /* Empieza nodo:530 / Elemento padre: 523   */
      v.add(doc.createElement("td"));
      ((Element)v.get(523)).appendChild((Element)v.get(530));

      /* Empieza nodo:531 / Elemento padre: 530   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(531)).setAttribute("nombre","lblUnidadMedidaPeso" );
      ((Element)v.get(531)).setAttribute("alto","13" );
      ((Element)v.get(531)).setAttribute("filas","1" );
      ((Element)v.get(531)).setAttribute("valor","" );
      ((Element)v.get(531)).setAttribute("id","datosTitle" );
      ((Element)v.get(531)).setAttribute("cod","1134" );
      ((Element)v.get(530)).appendChild((Element)v.get(531));
      /* Termina nodo:531   */
      /* Termina nodo:530   */

      /* Empieza nodo:532 / Elemento padre: 523   */
      v.add(doc.createElement("td"));
      ((Element)v.get(523)).appendChild((Element)v.get(532));

      /* Empieza nodo:533 / Elemento padre: 532   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(533)).setAttribute("src","b.gif" );
      ((Element)v.get(533)).setAttribute("width","25" );
      ((Element)v.get(533)).setAttribute("height","8" );
      ((Element)v.get(532)).appendChild((Element)v.get(533));
      /* Termina nodo:533   */
      /* Termina nodo:532   */

      /* Empieza nodo:534 / Elemento padre: 523   */
      v.add(doc.createElement("td"));
      ((Element)v.get(523)).appendChild((Element)v.get(534));

      /* Empieza nodo:535 / Elemento padre: 534   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(535)).setAttribute("nombre","lblUnidadesDentroPedido" );
      ((Element)v.get(535)).setAttribute("alto","13" );
      ((Element)v.get(535)).setAttribute("filas","1" );
      ((Element)v.get(535)).setAttribute("valor","" );
      ((Element)v.get(535)).setAttribute("id","datosTitle" );
      ((Element)v.get(535)).setAttribute("cod","1132" );
      ((Element)v.get(534)).appendChild((Element)v.get(535));
      /* Termina nodo:535   */
      /* Termina nodo:534   */

      /* Empieza nodo:536 / Elemento padre: 523   */
      v.add(doc.createElement("td"));
      ((Element)v.get(523)).appendChild((Element)v.get(536));

      /* Empieza nodo:537 / Elemento padre: 536   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(537)).setAttribute("src","b.gif" );
      ((Element)v.get(537)).setAttribute("width","25" );
      ((Element)v.get(537)).setAttribute("height","8" );
      ((Element)v.get(536)).appendChild((Element)v.get(537));
      /* Termina nodo:537   */
      /* Termina nodo:536   */

      /* Empieza nodo:538 / Elemento padre: 523   */
      v.add(doc.createElement("td"));
      ((Element)v.get(523)).appendChild((Element)v.get(538));

      /* Empieza nodo:539 / Elemento padre: 538   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(539)).setAttribute("nombre","lblUnidadesCaja" );
      ((Element)v.get(539)).setAttribute("alto","13" );
      ((Element)v.get(539)).setAttribute("filas","1" );
      ((Element)v.get(539)).setAttribute("valor","Marca" );
      ((Element)v.get(539)).setAttribute("id","datosTitle" );
      ((Element)v.get(539)).setAttribute("cod","1136" );
      ((Element)v.get(538)).appendChild((Element)v.get(539));
      /* Termina nodo:539   */
      /* Termina nodo:538   */

      /* Empieza nodo:540 / Elemento padre: 523   */
      v.add(doc.createElement("td"));
      ((Element)v.get(523)).appendChild((Element)v.get(540));

      /* Empieza nodo:541 / Elemento padre: 540   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(541)).setAttribute("src","b.gif" );
      ((Element)v.get(541)).setAttribute("width","25" );
      ((Element)v.get(541)).setAttribute("height","8" );
      ((Element)v.get(540)).appendChild((Element)v.get(541));
      /* Termina nodo:541   */
      /* Termina nodo:540   */

      /* Empieza nodo:542 / Elemento padre: 523   */
      v.add(doc.createElement("td"));
      ((Element)v.get(523)).appendChild((Element)v.get(542));

      /* Empieza nodo:543 / Elemento padre: 542   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(543)).setAttribute("nombre","lblCosteEstandar" );
      ((Element)v.get(543)).setAttribute("alto","13" );
      ((Element)v.get(543)).setAttribute("filas","1" );
      ((Element)v.get(543)).setAttribute("valor","" );
      ((Element)v.get(543)).setAttribute("id","datosTitle" );
      ((Element)v.get(543)).setAttribute("cod","604" );
      ((Element)v.get(542)).appendChild((Element)v.get(543));
      /* Termina nodo:543   */
      /* Termina nodo:542   */

      /* Empieza nodo:544 / Elemento padre: 523   */
      v.add(doc.createElement("td"));
      ((Element)v.get(523)).appendChild((Element)v.get(544));

      /* Empieza nodo:545 / Elemento padre: 544   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(545)).setAttribute("src","b.gif" );
      ((Element)v.get(545)).setAttribute("width","25" );
      ((Element)v.get(545)).setAttribute("height","8" );
      ((Element)v.get(544)).appendChild((Element)v.get(545));
      /* Termina nodo:545   */
      /* Termina nodo:544   */

      /* Empieza nodo:546 / Elemento padre: 523   */
      v.add(doc.createElement("td"));
      ((Element)v.get(523)).appendChild((Element)v.get(546));

      /* Empieza nodo:547 / Elemento padre: 546   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(547)).setAttribute("nombre","lblPrecioPosicionamiento" );
      ((Element)v.get(547)).setAttribute("alto","13" );
      ((Element)v.get(547)).setAttribute("filas","1" );
      ((Element)v.get(547)).setAttribute("valor","" );
      ((Element)v.get(547)).setAttribute("id","datosTitle" );
      ((Element)v.get(547)).setAttribute("cod","1116" );
      ((Element)v.get(546)).appendChild((Element)v.get(547));
      /* Termina nodo:547   */
      /* Termina nodo:546   */

      /* Empieza nodo:548 / Elemento padre: 523   */
      v.add(doc.createElement("td"));
      ((Element)v.get(548)).setAttribute("width","100%" );
      ((Element)v.get(523)).appendChild((Element)v.get(548));

      /* Empieza nodo:549 / Elemento padre: 548   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(549)).setAttribute("src","b.gif" );
      ((Element)v.get(549)).setAttribute("width","8" );
      ((Element)v.get(549)).setAttribute("height","8" );
      ((Element)v.get(548)).appendChild((Element)v.get(549));
      /* Termina nodo:549   */
      /* Termina nodo:548   */
      /* Termina nodo:523   */

      /* Empieza nodo:550 / Elemento padre: 522   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(522)).appendChild((Element)v.get(550));

      /* Empieza nodo:551 / Elemento padre: 550   */
      v.add(doc.createElement("td"));
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(550)).appendChild((Element)v.get(551));

      /* Empieza nodo:552 / Elemento padre: 551   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(552)).setAttribute("src","b.gif" );
      ((Element)v.get(552)).setAttribute("width","8" );
      ((Element)v.get(552)).setAttribute("height","8" );
      ((Element)v.get(551)).appendChild((Element)v.get(552));
      /* Termina nodo:552   */
      /* Termina nodo:551   */

      /* Empieza nodo:553 / Elemento padre: 550   */
      v.add(doc.createElement("td"));
      ((Element)v.get(553)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(550)).appendChild((Element)v.get(553));

      /* Empieza nodo:554 / Elemento padre: 553   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(554)).setAttribute("nombre","txtPeso" );
      ((Element)v.get(554)).setAttribute("id","datosCampos" );
      ((Element)v.get(554)).setAttribute("max","6" );
      ((Element)v.get(554)).setAttribute("tipo","" );
      ((Element)v.get(554)).setAttribute("onchange","" );
      ((Element)v.get(554)).setAttribute("req","N" );
      ((Element)v.get(554)).setAttribute("size","6" );
      ((Element)v.get(554)).setAttribute("valor","" );
      ((Element)v.get(554)).setAttribute("validacion","" );
      ((Element)v.get(553)).appendChild((Element)v.get(554));
      /* Termina nodo:554   */
      /* Termina nodo:553   */

      /* Empieza nodo:555 / Elemento padre: 550   */
      v.add(doc.createElement("td"));
      ((Element)v.get(550)).appendChild((Element)v.get(555));

      /* Empieza nodo:556 / Elemento padre: 555   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(556)).setAttribute("src","b.gif" );
      ((Element)v.get(556)).setAttribute("width","25" );
      ((Element)v.get(556)).setAttribute("height","8" );
      ((Element)v.get(555)).appendChild((Element)v.get(556));
      /* Termina nodo:556   */
      /* Termina nodo:555   */

      /* Empieza nodo:557 / Elemento padre: 550   */
      v.add(doc.createElement("td"));
      ((Element)v.get(550)).appendChild((Element)v.get(557));

      /* Empieza nodo:558 / Elemento padre: 557   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(558)).setAttribute("nombre","cbUnidadMedidaPeso" );
      ((Element)v.get(558)).setAttribute("id","datosCampos" );
      ((Element)v.get(558)).setAttribute("size","1" );
      ((Element)v.get(558)).setAttribute("multiple","N" );
      ((Element)v.get(558)).setAttribute("req","N" );
      ((Element)v.get(558)).setAttribute("valorinicial","" );
      ((Element)v.get(558)).setAttribute("textoinicial","" );
      ((Element)v.get(557)).appendChild((Element)v.get(558));

      /* Empieza nodo:559 / Elemento padre: 558   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(558)).appendChild((Element)v.get(559));
      /* Termina nodo:559   */
      /* Termina nodo:558   */
      /* Termina nodo:557   */

      /* Empieza nodo:560 / Elemento padre: 550   */
      v.add(doc.createElement("td"));
      ((Element)v.get(550)).appendChild((Element)v.get(560));

      /* Empieza nodo:561 / Elemento padre: 560   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(561)).setAttribute("src","b.gif" );
      ((Element)v.get(561)).setAttribute("width","25" );
      ((Element)v.get(561)).setAttribute("height","8" );
      ((Element)v.get(560)).appendChild((Element)v.get(561));
      /* Termina nodo:561   */
      /* Termina nodo:560   */

      /* Empieza nodo:562 / Elemento padre: 550   */
      v.add(doc.createElement("td"));
      ((Element)v.get(550)).appendChild((Element)v.get(562));

      /* Empieza nodo:563 / Elemento padre: 562   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(563)).setAttribute("nombre","txtUnidadesDentroPedido" );
      ((Element)v.get(563)).setAttribute("id","datosCampos" );
      ((Element)v.get(563)).setAttribute("max","5" );
      ((Element)v.get(563)).setAttribute("tipo","" );
      ((Element)v.get(563)).setAttribute("onchange","" );
      ((Element)v.get(563)).setAttribute("req","N" );
      ((Element)v.get(563)).setAttribute("size","5" );
      ((Element)v.get(563)).setAttribute("valor","" );
      ((Element)v.get(563)).setAttribute("validacion","" );
      ((Element)v.get(562)).appendChild((Element)v.get(563));
      /* Termina nodo:563   */
      /* Termina nodo:562   */

      /* Empieza nodo:564 / Elemento padre: 550   */
      v.add(doc.createElement("td"));
      ((Element)v.get(550)).appendChild((Element)v.get(564));

      /* Empieza nodo:565 / Elemento padre: 564   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(565)).setAttribute("src","b.gif" );
      ((Element)v.get(565)).setAttribute("width","25" );
      ((Element)v.get(565)).setAttribute("height","8" );
      ((Element)v.get(564)).appendChild((Element)v.get(565));
      /* Termina nodo:565   */
      /* Termina nodo:564   */

      /* Empieza nodo:566 / Elemento padre: 550   */
      v.add(doc.createElement("td"));
      ((Element)v.get(550)).appendChild((Element)v.get(566));

      /* Empieza nodo:567 / Elemento padre: 566   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(567)).setAttribute("nombre","txtUnidadesCaja" );
      ((Element)v.get(567)).setAttribute("id","datosCampos" );
      ((Element)v.get(567)).setAttribute("max","5" );
      ((Element)v.get(567)).setAttribute("tipo","" );
      ((Element)v.get(567)).setAttribute("onchange","" );
      ((Element)v.get(567)).setAttribute("req","N" );
      ((Element)v.get(567)).setAttribute("size","5" );
      ((Element)v.get(567)).setAttribute("valor","" );
      ((Element)v.get(567)).setAttribute("validacion","" );
      ((Element)v.get(566)).appendChild((Element)v.get(567));
      /* Termina nodo:567   */
      /* Termina nodo:566   */

      /* Empieza nodo:568 / Elemento padre: 550   */
      v.add(doc.createElement("td"));
      ((Element)v.get(550)).appendChild((Element)v.get(568));

      /* Empieza nodo:569 / Elemento padre: 568   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(569)).setAttribute("src","b.gif" );
      ((Element)v.get(569)).setAttribute("width","25" );
      ((Element)v.get(569)).setAttribute("height","8" );
      ((Element)v.get(568)).appendChild((Element)v.get(569));
      /* Termina nodo:569   */
      /* Termina nodo:568   */

      /* Empieza nodo:570 / Elemento padre: 550   */
      v.add(doc.createElement("td"));
      ((Element)v.get(550)).appendChild((Element)v.get(570));

      /* Empieza nodo:571 / Elemento padre: 570   */
      v.add(doc.createElement("CTEXTO"));
   }

   private void getXML2340(Document doc) {
      ((Element)v.get(571)).setAttribute("nombre","txtCosteEstandar" );
      ((Element)v.get(571)).setAttribute("id","datosCampos" );
      ((Element)v.get(571)).setAttribute("max","6" );
      ((Element)v.get(571)).setAttribute("tipo","" );
      ((Element)v.get(571)).setAttribute("onchange","" );
      ((Element)v.get(571)).setAttribute("req","N" );
      ((Element)v.get(571)).setAttribute("size","6" );
      ((Element)v.get(571)).setAttribute("valor","" );
      ((Element)v.get(571)).setAttribute("validacion","" );
      ((Element)v.get(570)).appendChild((Element)v.get(571));
      /* Termina nodo:571   */
      /* Termina nodo:570   */

      /* Empieza nodo:572 / Elemento padre: 550   */
      v.add(doc.createElement("td"));
      ((Element)v.get(550)).appendChild((Element)v.get(572));

      /* Empieza nodo:573 / Elemento padre: 572   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(573)).setAttribute("src","b.gif" );
      ((Element)v.get(573)).setAttribute("width","25" );
      ((Element)v.get(573)).setAttribute("height","8" );
      ((Element)v.get(572)).appendChild((Element)v.get(573));
      /* Termina nodo:573   */
      /* Termina nodo:572   */

      /* Empieza nodo:574 / Elemento padre: 550   */
      v.add(doc.createElement("td"));
      ((Element)v.get(550)).appendChild((Element)v.get(574));

      /* Empieza nodo:575 / Elemento padre: 574   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(575)).setAttribute("nombre","txtPrecioPosicionamiento" );
      ((Element)v.get(575)).setAttribute("id","datosCampos" );
      ((Element)v.get(575)).setAttribute("max","6" );
      ((Element)v.get(575)).setAttribute("tipo","" );
      ((Element)v.get(575)).setAttribute("onchange","" );
      ((Element)v.get(575)).setAttribute("req","N" );
      ((Element)v.get(575)).setAttribute("size","6" );
      ((Element)v.get(575)).setAttribute("valor","" );
      ((Element)v.get(575)).setAttribute("validacion","" );
      ((Element)v.get(574)).appendChild((Element)v.get(575));
      /* Termina nodo:575   */
      /* Termina nodo:574   */

      /* Empieza nodo:576 / Elemento padre: 550   */
      v.add(doc.createElement("td"));
      ((Element)v.get(576)).setAttribute("width","100%" );
      ((Element)v.get(550)).appendChild((Element)v.get(576));

      /* Empieza nodo:577 / Elemento padre: 576   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(577)).setAttribute("src","b.gif" );
      ((Element)v.get(577)).setAttribute("width","8" );
      ((Element)v.get(577)).setAttribute("height","8" );
      ((Element)v.get(576)).appendChild((Element)v.get(577));
      /* Termina nodo:577   */
      /* Termina nodo:576   */
      /* Termina nodo:550   */

      /* Empieza nodo:578 / Elemento padre: 522   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(522)).appendChild((Element)v.get(578));

      /* Empieza nodo:579 / Elemento padre: 578   */
      v.add(doc.createElement("td"));
      ((Element)v.get(579)).setAttribute("colspan","4" );
      ((Element)v.get(578)).appendChild((Element)v.get(579));

      /* Empieza nodo:580 / Elemento padre: 579   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(580)).setAttribute("src","b.gif" );
      ((Element)v.get(580)).setAttribute("width","8" );
      ((Element)v.get(580)).setAttribute("height","8" );
      ((Element)v.get(579)).appendChild((Element)v.get(580));
      /* Termina nodo:580   */
      /* Termina nodo:579   */
      /* Termina nodo:578   */
      /* Termina nodo:522   */
      /* Termina nodo:521   */
      /* Termina nodo:520   */

      /* Empieza nodo:581 / Elemento padre: 133   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(133)).appendChild((Element)v.get(581));

      /* Empieza nodo:582 / Elemento padre: 581   */
      v.add(doc.createElement("td"));
      ((Element)v.get(581)).appendChild((Element)v.get(582));

      /* Empieza nodo:583 / Elemento padre: 582   */
      v.add(doc.createElement("table"));
      ((Element)v.get(583)).setAttribute("width","699" );
      ((Element)v.get(583)).setAttribute("border","0" );
      ((Element)v.get(583)).setAttribute("align","left" );
      ((Element)v.get(583)).setAttribute("cellspacing","0" );
      ((Element)v.get(583)).setAttribute("cellpadding","0" );
      ((Element)v.get(582)).appendChild((Element)v.get(583));

      /* Empieza nodo:584 / Elemento padre: 583   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(583)).appendChild((Element)v.get(584));

      /* Empieza nodo:585 / Elemento padre: 584   */
      v.add(doc.createElement("td"));
      ((Element)v.get(584)).appendChild((Element)v.get(585));

      /* Empieza nodo:586 / Elemento padre: 585   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(586)).setAttribute("src","b.gif" );
      ((Element)v.get(586)).setAttribute("width","8" );
      ((Element)v.get(586)).setAttribute("height","8" );
      ((Element)v.get(585)).appendChild((Element)v.get(586));
      /* Termina nodo:586   */
      /* Termina nodo:585   */

      /* Empieza nodo:587 / Elemento padre: 584   */
      v.add(doc.createElement("td"));
      ((Element)v.get(584)).appendChild((Element)v.get(587));

      /* Empieza nodo:588 / Elemento padre: 587   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(588)).setAttribute("nombre","lblSituacion" );
      ((Element)v.get(588)).setAttribute("alto","13" );
      ((Element)v.get(588)).setAttribute("filas","1" );
      ((Element)v.get(588)).setAttribute("valor","" );
      ((Element)v.get(588)).setAttribute("id","datosTitle" );
      ((Element)v.get(588)).setAttribute("cod","695" );
      ((Element)v.get(587)).appendChild((Element)v.get(588));
      /* Termina nodo:588   */
      /* Termina nodo:587   */

      /* Empieza nodo:589 / Elemento padre: 584   */
      v.add(doc.createElement("td"));
      ((Element)v.get(584)).appendChild((Element)v.get(589));

      /* Empieza nodo:590 / Elemento padre: 589   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(590)).setAttribute("src","b.gif" );
      ((Element)v.get(590)).setAttribute("width","25" );
      ((Element)v.get(590)).setAttribute("height","8" );
      ((Element)v.get(589)).appendChild((Element)v.get(590));
      /* Termina nodo:590   */
      /* Termina nodo:589   */

      /* Empieza nodo:591 / Elemento padre: 584   */
      v.add(doc.createElement("td"));
      ((Element)v.get(584)).appendChild((Element)v.get(591));

      /* Empieza nodo:592 / Elemento padre: 591   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(592)).setAttribute("nombre","lblEstatusProducto" );
      ((Element)v.get(592)).setAttribute("alto","13" );
   }

   private void getXML2430(Document doc) {
      ((Element)v.get(592)).setAttribute("filas","1" );
      ((Element)v.get(592)).setAttribute("valor","" );
      ((Element)v.get(592)).setAttribute("id","datosTitle" );
      ((Element)v.get(592)).setAttribute("cod","1077" );
      ((Element)v.get(591)).appendChild((Element)v.get(592));
      /* Termina nodo:592   */
      /* Termina nodo:591   */

      /* Empieza nodo:593 / Elemento padre: 584   */
      v.add(doc.createElement("td"));
      ((Element)v.get(584)).appendChild((Element)v.get(593));

      /* Empieza nodo:594 / Elemento padre: 593   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(594)).setAttribute("src","b.gif" );
      ((Element)v.get(594)).setAttribute("width","25" );
      ((Element)v.get(594)).setAttribute("height","8" );
      ((Element)v.get(593)).appendChild((Element)v.get(594));
      /* Termina nodo:594   */
      /* Termina nodo:593   */

      /* Empieza nodo:595 / Elemento padre: 584   */
      v.add(doc.createElement("td"));
      ((Element)v.get(584)).appendChild((Element)v.get(595));

      /* Empieza nodo:596 / Elemento padre: 595   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(596)).setAttribute("nombre","lblIndicadorDentroCaja" );
      ((Element)v.get(596)).setAttribute("alto","13" );
      ((Element)v.get(596)).setAttribute("filas","1" );
      ((Element)v.get(596)).setAttribute("valor","" );
      ((Element)v.get(596)).setAttribute("id","datosTitle" );
      ((Element)v.get(596)).setAttribute("cod","1083" );
      ((Element)v.get(595)).appendChild((Element)v.get(596));
      /* Termina nodo:596   */
      /* Termina nodo:595   */

      /* Empieza nodo:597 / Elemento padre: 584   */
      v.add(doc.createElement("td"));
      ((Element)v.get(597)).setAttribute("width","100%" );
      ((Element)v.get(584)).appendChild((Element)v.get(597));

      /* Empieza nodo:598 / Elemento padre: 597   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(598)).setAttribute("src","b.gif" );
      ((Element)v.get(598)).setAttribute("width","8" );
      ((Element)v.get(598)).setAttribute("height","8" );
      ((Element)v.get(597)).appendChild((Element)v.get(598));
      /* Termina nodo:598   */
      /* Termina nodo:597   */
      /* Termina nodo:584   */

      /* Empieza nodo:599 / Elemento padre: 583   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(583)).appendChild((Element)v.get(599));

      /* Empieza nodo:600 / Elemento padre: 599   */
      v.add(doc.createElement("td"));
      ((Element)v.get(599)).appendChild((Element)v.get(600));

      /* Empieza nodo:601 / Elemento padre: 600   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(601)).setAttribute("src","b.gif" );
      ((Element)v.get(601)).setAttribute("width","8" );
      ((Element)v.get(601)).setAttribute("height","8" );
      ((Element)v.get(600)).appendChild((Element)v.get(601));
      /* Termina nodo:601   */
      /* Termina nodo:600   */

      /* Empieza nodo:602 / Elemento padre: 599   */
      v.add(doc.createElement("td"));
      ((Element)v.get(602)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(599)).appendChild((Element)v.get(602));

      /* Empieza nodo:603 / Elemento padre: 602   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(603)).setAttribute("nombre","cbSituacion" );
      ((Element)v.get(603)).setAttribute("id","datosCampos" );
      ((Element)v.get(603)).setAttribute("size","1" );
      ((Element)v.get(603)).setAttribute("multiple","N" );
      ((Element)v.get(603)).setAttribute("req","N" );
      ((Element)v.get(603)).setAttribute("valorinicial","" );
      ((Element)v.get(603)).setAttribute("textoinicial","" );
      ((Element)v.get(602)).appendChild((Element)v.get(603));

      /* Empieza nodo:604 / Elemento padre: 603   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(603)).appendChild((Element)v.get(604));
      /* Termina nodo:604   */
      /* Termina nodo:603   */
      /* Termina nodo:602   */

      /* Empieza nodo:605 / Elemento padre: 599   */
      v.add(doc.createElement("td"));
      ((Element)v.get(599)).appendChild((Element)v.get(605));

      /* Empieza nodo:606 / Elemento padre: 605   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(606)).setAttribute("src","b.gif" );
      ((Element)v.get(606)).setAttribute("width","25" );
      ((Element)v.get(606)).setAttribute("height","8" );
      ((Element)v.get(605)).appendChild((Element)v.get(606));
      /* Termina nodo:606   */
      /* Termina nodo:605   */

      /* Empieza nodo:607 / Elemento padre: 599   */
      v.add(doc.createElement("td"));
      ((Element)v.get(607)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(599)).appendChild((Element)v.get(607));

      /* Empieza nodo:608 / Elemento padre: 607   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(608)).setAttribute("nombre","cbEstatusProducto" );
      ((Element)v.get(608)).setAttribute("id","datosCampos" );
      ((Element)v.get(608)).setAttribute("size","1" );
      ((Element)v.get(608)).setAttribute("multiple","N" );
      ((Element)v.get(608)).setAttribute("req","N" );
      ((Element)v.get(608)).setAttribute("valorinicial","" );
      ((Element)v.get(608)).setAttribute("textoinicial","" );
      ((Element)v.get(607)).appendChild((Element)v.get(608));

      /* Empieza nodo:609 / Elemento padre: 608   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(608)).appendChild((Element)v.get(609));
      /* Termina nodo:609   */
      /* Termina nodo:608   */
      /* Termina nodo:607   */

      /* Empieza nodo:610 / Elemento padre: 599   */
      v.add(doc.createElement("td"));
      ((Element)v.get(599)).appendChild((Element)v.get(610));

      /* Empieza nodo:611 / Elemento padre: 610   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(611)).setAttribute("src","b.gif" );
      ((Element)v.get(611)).setAttribute("width","25" );
      ((Element)v.get(611)).setAttribute("height","8" );
      ((Element)v.get(610)).appendChild((Element)v.get(611));
      /* Termina nodo:611   */
      /* Termina nodo:610   */

      /* Empieza nodo:612 / Elemento padre: 599   */
      v.add(doc.createElement("td"));
      ((Element)v.get(612)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(599)).appendChild((Element)v.get(612));

      /* Empieza nodo:613 / Elemento padre: 612   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(613)).setAttribute("nombre","cbIndicadorDentroCaja" );
      ((Element)v.get(613)).setAttribute("id","datosCampos" );
      ((Element)v.get(613)).setAttribute("size","1" );
      ((Element)v.get(613)).setAttribute("multiple","N" );
      ((Element)v.get(613)).setAttribute("req","N" );
   }

   private void getXML2520(Document doc) {
      ((Element)v.get(613)).setAttribute("valorinicial","" );
      ((Element)v.get(613)).setAttribute("textoinicial","" );
      ((Element)v.get(612)).appendChild((Element)v.get(613));

      /* Empieza nodo:614 / Elemento padre: 613   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(613)).appendChild((Element)v.get(614));
      /* Termina nodo:614   */
      /* Termina nodo:613   */
      /* Termina nodo:612   */

      /* Empieza nodo:615 / Elemento padre: 599   */
      v.add(doc.createElement("td"));
      ((Element)v.get(615)).setAttribute("width","100%" );
      ((Element)v.get(599)).appendChild((Element)v.get(615));

      /* Empieza nodo:616 / Elemento padre: 615   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(616)).setAttribute("src","b.gif" );
      ((Element)v.get(616)).setAttribute("width","8" );
      ((Element)v.get(616)).setAttribute("height","8" );
      ((Element)v.get(615)).appendChild((Element)v.get(616));
      /* Termina nodo:616   */
      /* Termina nodo:615   */
      /* Termina nodo:599   */

      /* Empieza nodo:617 / Elemento padre: 583   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(583)).appendChild((Element)v.get(617));

      /* Empieza nodo:618 / Elemento padre: 617   */
      v.add(doc.createElement("td"));
      ((Element)v.get(618)).setAttribute("colspan","4" );
      ((Element)v.get(617)).appendChild((Element)v.get(618));

      /* Empieza nodo:619 / Elemento padre: 618   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(619)).setAttribute("src","b.gif" );
      ((Element)v.get(619)).setAttribute("width","8" );
      ((Element)v.get(619)).setAttribute("height","8" );
      ((Element)v.get(618)).appendChild((Element)v.get(619));
      /* Termina nodo:619   */
      /* Termina nodo:618   */
      /* Termina nodo:617   */
      /* Termina nodo:583   */
      /* Termina nodo:582   */
      /* Termina nodo:581   */

      /* Empieza nodo:620 / Elemento padre: 133   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(133)).appendChild((Element)v.get(620));

      /* Empieza nodo:621 / Elemento padre: 620   */
      v.add(doc.createElement("td"));
      ((Element)v.get(620)).appendChild((Element)v.get(621));

      /* Empieza nodo:622 / Elemento padre: 621   */
      v.add(doc.createElement("table"));
      ((Element)v.get(622)).setAttribute("width","699" );
      ((Element)v.get(622)).setAttribute("border","0" );
      ((Element)v.get(622)).setAttribute("align","left" );
      ((Element)v.get(622)).setAttribute("cellspacing","0" );
      ((Element)v.get(622)).setAttribute("cellpadding","0" );
      ((Element)v.get(621)).appendChild((Element)v.get(622));

      /* Empieza nodo:623 / Elemento padre: 622   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(622)).appendChild((Element)v.get(623));

      /* Empieza nodo:624 / Elemento padre: 623   */
      v.add(doc.createElement("td"));
      ((Element)v.get(623)).appendChild((Element)v.get(624));

      /* Empieza nodo:625 / Elemento padre: 624   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(625)).setAttribute("src","b.gif" );
      ((Element)v.get(625)).setAttribute("width","8" );
      ((Element)v.get(625)).setAttribute("height","8" );
      ((Element)v.get(624)).appendChild((Element)v.get(625));
      /* Termina nodo:625   */
      /* Termina nodo:624   */

      /* Empieza nodo:626 / Elemento padre: 623   */
      v.add(doc.createElement("td"));
      ((Element)v.get(623)).appendChild((Element)v.get(626));

      /* Empieza nodo:627 / Elemento padre: 626   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(627)).setAttribute("nombre","lblCodigoPagoFraccionado" );
      ((Element)v.get(627)).setAttribute("alto","13" );
      ((Element)v.get(627)).setAttribute("filas","1" );
      ((Element)v.get(627)).setAttribute("valor","" );
      ((Element)v.get(627)).setAttribute("id","datosTitle" );
      ((Element)v.get(627)).setAttribute("cod","541" );
      ((Element)v.get(626)).appendChild((Element)v.get(627));
      /* Termina nodo:627   */
      /* Termina nodo:626   */

      /* Empieza nodo:628 / Elemento padre: 623   */
      v.add(doc.createElement("td"));
      ((Element)v.get(623)).appendChild((Element)v.get(628));

      /* Empieza nodo:629 / Elemento padre: 628   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(629)).setAttribute("src","b.gif" );
      ((Element)v.get(629)).setAttribute("width","25" );
      ((Element)v.get(629)).setAttribute("height","8" );
      ((Element)v.get(628)).appendChild((Element)v.get(629));
      /* Termina nodo:629   */
      /* Termina nodo:628   */

      /* Empieza nodo:630 / Elemento padre: 623   */
      v.add(doc.createElement("td"));
      ((Element)v.get(623)).appendChild((Element)v.get(630));

      /* Empieza nodo:631 / Elemento padre: 630   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(631)).setAttribute("nombre","lblCodigoImpuesto" );
      ((Element)v.get(631)).setAttribute("alto","13" );
      ((Element)v.get(631)).setAttribute("filas","1" );
      ((Element)v.get(631)).setAttribute("valor","Marca" );
      ((Element)v.get(631)).setAttribute("id","datosTitle" );
      ((Element)v.get(631)).setAttribute("cod","1062" );
      ((Element)v.get(630)).appendChild((Element)v.get(631));
      /* Termina nodo:631   */
      /* Termina nodo:630   */

      /* Empieza nodo:632 / Elemento padre: 623   */
      v.add(doc.createElement("td"));
      ((Element)v.get(623)).appendChild((Element)v.get(632));

      /* Empieza nodo:633 / Elemento padre: 632   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(633)).setAttribute("src","b.gif" );
      ((Element)v.get(633)).setAttribute("width","25" );
      ((Element)v.get(633)).setAttribute("height","8" );
      ((Element)v.get(632)).appendChild((Element)v.get(633));
      /* Termina nodo:633   */
      /* Termina nodo:632   */

      /* Empieza nodo:634 / Elemento padre: 623   */
      v.add(doc.createElement("td"));
      ((Element)v.get(623)).appendChild((Element)v.get(634));

      /* Empieza nodo:635 / Elemento padre: 634   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(635)).setAttribute("nombre","lblPrecioCatalogo" );
      ((Element)v.get(635)).setAttribute("alto","13" );
      ((Element)v.get(635)).setAttribute("filas","1" );
      ((Element)v.get(635)).setAttribute("valor","" );
      ((Element)v.get(635)).setAttribute("id","datosTitle" );
      ((Element)v.get(635)).setAttribute("cod","503" );
      ((Element)v.get(634)).appendChild((Element)v.get(635));
      /* Termina nodo:635   */
      /* Termina nodo:634   */

      /* Empieza nodo:636 / Elemento padre: 623   */
      v.add(doc.createElement("td"));
      ((Element)v.get(623)).appendChild((Element)v.get(636));

      /* Empieza nodo:637 / Elemento padre: 636   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML2610(Document doc) {
      ((Element)v.get(637)).setAttribute("src","b.gif" );
      ((Element)v.get(637)).setAttribute("width","25" );
      ((Element)v.get(637)).setAttribute("height","8" );
      ((Element)v.get(636)).appendChild((Element)v.get(637));
      /* Termina nodo:637   */
      /* Termina nodo:636   */

      /* Empieza nodo:638 / Elemento padre: 623   */
      v.add(doc.createElement("td"));
      ((Element)v.get(623)).appendChild((Element)v.get(638));

      /* Empieza nodo:639 / Elemento padre: 638   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(639)).setAttribute("nombre","lblPrecioContable" );
      ((Element)v.get(639)).setAttribute("alto","13" );
      ((Element)v.get(639)).setAttribute("filas","1" );
      ((Element)v.get(639)).setAttribute("valor","" );
      ((Element)v.get(639)).setAttribute("id","datosTitle" );
      ((Element)v.get(639)).setAttribute("cod","974" );
      ((Element)v.get(638)).appendChild((Element)v.get(639));
      /* Termina nodo:639   */
      /* Termina nodo:638   */

      /* Empieza nodo:640 / Elemento padre: 623   */
      v.add(doc.createElement("td"));
      ((Element)v.get(623)).appendChild((Element)v.get(640));

      /* Empieza nodo:641 / Elemento padre: 640   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(641)).setAttribute("src","b.gif" );
      ((Element)v.get(641)).setAttribute("width","25" );
      ((Element)v.get(641)).setAttribute("height","8" );
      ((Element)v.get(640)).appendChild((Element)v.get(641));
      /* Termina nodo:641   */
      /* Termina nodo:640   */

      /* Empieza nodo:642 / Elemento padre: 623   */
      v.add(doc.createElement("td"));
      ((Element)v.get(623)).appendChild((Element)v.get(642));

      /* Empieza nodo:643 / Elemento padre: 642   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(643)).setAttribute("nombre","lblGrupoArticulos" );
      ((Element)v.get(643)).setAttribute("alto","13" );
      ((Element)v.get(643)).setAttribute("filas","1" );
      ((Element)v.get(643)).setAttribute("valor","" );
      ((Element)v.get(643)).setAttribute("id","datosTitle" );
      ((Element)v.get(643)).setAttribute("cod","2473" );
      ((Element)v.get(642)).appendChild((Element)v.get(643));
      /* Termina nodo:643   */
      /* Termina nodo:642   */

      /* Empieza nodo:644 / Elemento padre: 623   */
      v.add(doc.createElement("td"));
      ((Element)v.get(623)).appendChild((Element)v.get(644));

      /* Empieza nodo:645 / Elemento padre: 644   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(645)).setAttribute("src","b.gif" );
      ((Element)v.get(645)).setAttribute("width","25" );
      ((Element)v.get(645)).setAttribute("height","8" );
      ((Element)v.get(644)).appendChild((Element)v.get(645));
      /* Termina nodo:645   */
      /* Termina nodo:644   */

      /* Empieza nodo:646 / Elemento padre: 623   */
      v.add(doc.createElement("td"));
      ((Element)v.get(623)).appendChild((Element)v.get(646));

      /* Empieza nodo:647 / Elemento padre: 646   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(647)).setAttribute("nombre","lblPorcentajeUnidades" );
      ((Element)v.get(647)).setAttribute("alto","13" );
      ((Element)v.get(647)).setAttribute("filas","1" );
      ((Element)v.get(647)).setAttribute("valor","" );
      ((Element)v.get(647)).setAttribute("id","datosTitle" );
      ((Element)v.get(647)).setAttribute("cod","1240" );
      ((Element)v.get(646)).appendChild((Element)v.get(647));
      /* Termina nodo:647   */
      /* Termina nodo:646   */

      /* Empieza nodo:648 / Elemento padre: 623   */
      v.add(doc.createElement("td"));
      ((Element)v.get(648)).setAttribute("width","100%" );
      ((Element)v.get(623)).appendChild((Element)v.get(648));

      /* Empieza nodo:649 / Elemento padre: 648   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(649)).setAttribute("src","b.gif" );
      ((Element)v.get(649)).setAttribute("width","8" );
      ((Element)v.get(649)).setAttribute("height","8" );
      ((Element)v.get(648)).appendChild((Element)v.get(649));
      /* Termina nodo:649   */
      /* Termina nodo:648   */
      /* Termina nodo:623   */

      /* Empieza nodo:650 / Elemento padre: 622   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(622)).appendChild((Element)v.get(650));

      /* Empieza nodo:651 / Elemento padre: 650   */
      v.add(doc.createElement("td"));
      ((Element)v.get(650)).appendChild((Element)v.get(651));

      /* Empieza nodo:652 / Elemento padre: 651   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(652)).setAttribute("src","b.gif" );
      ((Element)v.get(652)).setAttribute("width","8" );
      ((Element)v.get(652)).setAttribute("height","8" );
      ((Element)v.get(651)).appendChild((Element)v.get(652));
      /* Termina nodo:652   */
      /* Termina nodo:651   */

      /* Empieza nodo:653 / Elemento padre: 650   */
      v.add(doc.createElement("td"));
      ((Element)v.get(653)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(653)).setAttribute("valign","bottom" );
      ((Element)v.get(650)).appendChild((Element)v.get(653));

      /* Empieza nodo:654 / Elemento padre: 653   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(654)).setAttribute("nombre","cbCodigoPagoFraccionado" );
      ((Element)v.get(654)).setAttribute("id","datosCampos" );
      ((Element)v.get(654)).setAttribute("size","1" );
      ((Element)v.get(654)).setAttribute("multiple","N" );
      ((Element)v.get(654)).setAttribute("req","N" );
      ((Element)v.get(654)).setAttribute("valorinicial","" );
      ((Element)v.get(654)).setAttribute("textoinicial","" );
      ((Element)v.get(653)).appendChild((Element)v.get(654));

      /* Empieza nodo:655 / Elemento padre: 654   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(654)).appendChild((Element)v.get(655));
      /* Termina nodo:655   */
      /* Termina nodo:654   */
      /* Termina nodo:653   */

      /* Empieza nodo:656 / Elemento padre: 650   */
      v.add(doc.createElement("td"));
      ((Element)v.get(650)).appendChild((Element)v.get(656));

      /* Empieza nodo:657 / Elemento padre: 656   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(657)).setAttribute("src","b.gif" );
      ((Element)v.get(657)).setAttribute("width","25" );
      ((Element)v.get(657)).setAttribute("height","8" );
      ((Element)v.get(656)).appendChild((Element)v.get(657));
      /* Termina nodo:657   */
      /* Termina nodo:656   */

      /* Empieza nodo:658 / Elemento padre: 650   */
      v.add(doc.createElement("td"));
      ((Element)v.get(658)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(658)).setAttribute("valign","bottom" );
   }

   private void getXML2700(Document doc) {
      ((Element)v.get(650)).appendChild((Element)v.get(658));

      /* Empieza nodo:659 / Elemento padre: 658   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(659)).setAttribute("nombre","txtCodigoImpuesto" );
      ((Element)v.get(659)).setAttribute("id","datosCampos" );
      ((Element)v.get(659)).setAttribute("max","2" );
      ((Element)v.get(659)).setAttribute("tipo","" );
      ((Element)v.get(659)).setAttribute("onchange","" );
      ((Element)v.get(659)).setAttribute("req","N" );
      ((Element)v.get(659)).setAttribute("size","2" );
      ((Element)v.get(659)).setAttribute("valor","" );
      ((Element)v.get(659)).setAttribute("validacion","" );
      ((Element)v.get(658)).appendChild((Element)v.get(659));
      /* Termina nodo:659   */
      /* Termina nodo:658   */

      /* Empieza nodo:660 / Elemento padre: 650   */
      v.add(doc.createElement("td"));
      ((Element)v.get(650)).appendChild((Element)v.get(660));

      /* Empieza nodo:661 / Elemento padre: 660   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(661)).setAttribute("src","b.gif" );
      ((Element)v.get(661)).setAttribute("width","25" );
      ((Element)v.get(661)).setAttribute("height","8" );
      ((Element)v.get(660)).appendChild((Element)v.get(661));
      /* Termina nodo:661   */
      /* Termina nodo:660   */

      /* Empieza nodo:662 / Elemento padre: 650   */
      v.add(doc.createElement("td"));
      ((Element)v.get(662)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(662)).setAttribute("valign","bottom" );
      ((Element)v.get(650)).appendChild((Element)v.get(662));

      /* Empieza nodo:663 / Elemento padre: 662   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(663)).setAttribute("nombre","txtPrecioCatalogo" );
      ((Element)v.get(663)).setAttribute("id","datosCampos" );
      ((Element)v.get(663)).setAttribute("max","13" );
      ((Element)v.get(663)).setAttribute("tipo","" );
      ((Element)v.get(663)).setAttribute("onchange","" );
      ((Element)v.get(663)).setAttribute("req","N" );
      ((Element)v.get(663)).setAttribute("size","13" );
      ((Element)v.get(663)).setAttribute("valor","" );
      ((Element)v.get(663)).setAttribute("validacion","" );
      ((Element)v.get(662)).appendChild((Element)v.get(663));
      /* Termina nodo:663   */
      /* Termina nodo:662   */

      /* Empieza nodo:664 / Elemento padre: 650   */
      v.add(doc.createElement("td"));
      ((Element)v.get(650)).appendChild((Element)v.get(664));

      /* Empieza nodo:665 / Elemento padre: 664   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(665)).setAttribute("src","b.gif" );
      ((Element)v.get(665)).setAttribute("width","25" );
      ((Element)v.get(665)).setAttribute("height","8" );
      ((Element)v.get(664)).appendChild((Element)v.get(665));
      /* Termina nodo:665   */
      /* Termina nodo:664   */

      /* Empieza nodo:666 / Elemento padre: 650   */
      v.add(doc.createElement("td"));
      ((Element)v.get(666)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(666)).setAttribute("valign","bottom" );
      ((Element)v.get(650)).appendChild((Element)v.get(666));

      /* Empieza nodo:667 / Elemento padre: 666   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(667)).setAttribute("nombre","txtPrecioContable" );
      ((Element)v.get(667)).setAttribute("id","datosCampos" );
      ((Element)v.get(667)).setAttribute("max","13" );
      ((Element)v.get(667)).setAttribute("tipo","" );
      ((Element)v.get(667)).setAttribute("onchange","" );
      ((Element)v.get(667)).setAttribute("req","N" );
      ((Element)v.get(667)).setAttribute("size","13" );
      ((Element)v.get(667)).setAttribute("valor","" );
      ((Element)v.get(667)).setAttribute("validacion","" );
      ((Element)v.get(666)).appendChild((Element)v.get(667));
      /* Termina nodo:667   */
      /* Termina nodo:666   */

      /* Empieza nodo:668 / Elemento padre: 650   */
      v.add(doc.createElement("td"));
      ((Element)v.get(650)).appendChild((Element)v.get(668));

      /* Empieza nodo:669 / Elemento padre: 668   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(669)).setAttribute("src","b.gif" );
      ((Element)v.get(669)).setAttribute("width","25" );
      ((Element)v.get(669)).setAttribute("height","8" );
      ((Element)v.get(668)).appendChild((Element)v.get(669));
      /* Termina nodo:669   */
      /* Termina nodo:668   */

      /* Empieza nodo:670 / Elemento padre: 650   */
      v.add(doc.createElement("td"));
      ((Element)v.get(670)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(650)).appendChild((Element)v.get(670));

      /* Empieza nodo:671 / Elemento padre: 670   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(671)).setAttribute("nombre","txtGrupoArticulos" );
      ((Element)v.get(671)).setAttribute("id","datosCampos" );
      ((Element)v.get(671)).setAttribute("max","9" );
      ((Element)v.get(671)).setAttribute("tipo","" );
      ((Element)v.get(671)).setAttribute("onchange","" );
      ((Element)v.get(671)).setAttribute("req","N" );
      ((Element)v.get(671)).setAttribute("size","11" );
      ((Element)v.get(671)).setAttribute("valor","" );
      ((Element)v.get(671)).setAttribute("validacion","" );
      ((Element)v.get(670)).appendChild((Element)v.get(671));
      /* Termina nodo:671   */
      /* Termina nodo:670   */

      /* Empieza nodo:672 / Elemento padre: 650   */
      v.add(doc.createElement("td"));
      ((Element)v.get(650)).appendChild((Element)v.get(672));

      /* Empieza nodo:673 / Elemento padre: 672   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(673)).setAttribute("src","b.gif" );
      ((Element)v.get(673)).setAttribute("width","25" );
      ((Element)v.get(673)).setAttribute("height","8" );
      ((Element)v.get(672)).appendChild((Element)v.get(673));
      /* Termina nodo:673   */
      /* Termina nodo:672   */

      /* Empieza nodo:674 / Elemento padre: 650   */
      v.add(doc.createElement("td"));
      ((Element)v.get(674)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(674)).setAttribute("valign","bottom" );
      ((Element)v.get(674)).setAttribute("class","datosCampos" );
      ((Element)v.get(650)).appendChild((Element)v.get(674));

      /* Empieza nodo:675 / Elemento padre: 674   */
      v.add(doc.createElement("CTEXTO"));
   }

   private void getXML2790(Document doc) {
      ((Element)v.get(675)).setAttribute("nombre","txtPorcentajeUnidades" );
      ((Element)v.get(675)).setAttribute("id","datosCampos" );
      ((Element)v.get(675)).setAttribute("max","3" );
      ((Element)v.get(675)).setAttribute("tipo","" );
      ((Element)v.get(675)).setAttribute("onchange","" );
      ((Element)v.get(675)).setAttribute("req","N" );
      ((Element)v.get(675)).setAttribute("size","3" );
      ((Element)v.get(675)).setAttribute("valor","" );
      ((Element)v.get(675)).setAttribute("validacion","" );
      ((Element)v.get(674)).appendChild((Element)v.get(675));
      /* Termina nodo:675   */

      /* Elemento padre:674 / Elemento actual: 676   */
      v.add(doc.createTextNode("%"));
      ((Element)v.get(674)).appendChild((Text)v.get(676));

      /* Termina nodo Texto:676   */
      /* Termina nodo:674   */

      /* Empieza nodo:677 / Elemento padre: 650   */
      v.add(doc.createElement("td"));
      ((Element)v.get(650)).appendChild((Element)v.get(677));

      /* Empieza nodo:678 / Elemento padre: 677   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(678)).setAttribute("src","b.gif" );
      ((Element)v.get(678)).setAttribute("width","25" );
      ((Element)v.get(678)).setAttribute("height","8" );
      ((Element)v.get(677)).appendChild((Element)v.get(678));
      /* Termina nodo:678   */
      /* Termina nodo:677   */

      /* Empieza nodo:679 / Elemento padre: 650   */
      v.add(doc.createElement("td"));
      ((Element)v.get(679)).setAttribute("width","100%" );
      ((Element)v.get(650)).appendChild((Element)v.get(679));

      /* Empieza nodo:680 / Elemento padre: 679   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(680)).setAttribute("src","b.gif" );
      ((Element)v.get(680)).setAttribute("width","8" );
      ((Element)v.get(680)).setAttribute("height","8" );
      ((Element)v.get(679)).appendChild((Element)v.get(680));
      /* Termina nodo:680   */
      /* Termina nodo:679   */
      /* Termina nodo:650   */

      /* Empieza nodo:681 / Elemento padre: 622   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(622)).appendChild((Element)v.get(681));

      /* Empieza nodo:682 / Elemento padre: 681   */
      v.add(doc.createElement("td"));
      ((Element)v.get(682)).setAttribute("colspan","4" );
      ((Element)v.get(681)).appendChild((Element)v.get(682));

      /* Empieza nodo:683 / Elemento padre: 682   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(683)).setAttribute("src","b.gif" );
      ((Element)v.get(683)).setAttribute("width","8" );
      ((Element)v.get(683)).setAttribute("height","8" );
      ((Element)v.get(682)).appendChild((Element)v.get(683));
      /* Termina nodo:683   */
      /* Termina nodo:682   */
      /* Termina nodo:681   */
      /* Termina nodo:622   */
      /* Termina nodo:621   */
      /* Termina nodo:620   */

      /* Empieza nodo:684 / Elemento padre: 133   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(133)).appendChild((Element)v.get(684));

      /* Empieza nodo:685 / Elemento padre: 684   */
      v.add(doc.createElement("td"));
      ((Element)v.get(684)).appendChild((Element)v.get(685));

      /* Empieza nodo:686 / Elemento padre: 685   */
      v.add(doc.createElement("table"));
      ((Element)v.get(686)).setAttribute("width","100%" );
      ((Element)v.get(686)).setAttribute("border","0" );
      ((Element)v.get(686)).setAttribute("align","center" );
      ((Element)v.get(686)).setAttribute("cellspacing","0" );
      ((Element)v.get(686)).setAttribute("cellpadding","0" );
      ((Element)v.get(685)).appendChild((Element)v.get(686));

      /* Empieza nodo:687 / Elemento padre: 686   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(686)).appendChild((Element)v.get(687));

      /* Empieza nodo:688 / Elemento padre: 687   */
      v.add(doc.createElement("td"));
      ((Element)v.get(688)).setAttribute("colspan","3" );
      ((Element)v.get(687)).appendChild((Element)v.get(688));

      /* Empieza nodo:689 / Elemento padre: 688   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(689)).setAttribute("src","b.gif" );
      ((Element)v.get(689)).setAttribute("width","8" );
      ((Element)v.get(689)).setAttribute("height","8" );
      ((Element)v.get(688)).appendChild((Element)v.get(689));
      /* Termina nodo:689   */
      /* Termina nodo:688   */
      /* Termina nodo:687   */

      /* Empieza nodo:690 / Elemento padre: 686   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(686)).appendChild((Element)v.get(690));

      /* Empieza nodo:691 / Elemento padre: 690   */
      v.add(doc.createElement("td"));
      ((Element)v.get(690)).appendChild((Element)v.get(691));

      /* Empieza nodo:692 / Elemento padre: 691   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(692)).setAttribute("src","b.gif" );
      ((Element)v.get(692)).setAttribute("width","8" );
      ((Element)v.get(692)).setAttribute("height","8" );
      ((Element)v.get(691)).appendChild((Element)v.get(692));
      /* Termina nodo:692   */
      /* Termina nodo:691   */

      /* Empieza nodo:693 / Elemento padre: 690   */
      v.add(doc.createElement("td"));
      ((Element)v.get(693)).setAttribute("width","100%" );
      ((Element)v.get(690)).appendChild((Element)v.get(693));

      /* Empieza nodo:694 / Elemento padre: 693   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(693)).appendChild((Element)v.get(694));

      /* Empieza nodo:695 / Elemento padre: 694   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(695)).setAttribute("class","legend" );
      ((Element)v.get(694)).appendChild((Element)v.get(695));

      /* Empieza nodo:696 / Elemento padre: 695   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(696)).setAttribute("nombre","lblAnadirProductos" );
      ((Element)v.get(696)).setAttribute("alto","13" );
      ((Element)v.get(696)).setAttribute("filas","1" );
      ((Element)v.get(696)).setAttribute("valor","" );
      ((Element)v.get(696)).setAttribute("id","legend" );
      ((Element)v.get(696)).setAttribute("cod","1238" );
      ((Element)v.get(695)).appendChild((Element)v.get(696));
      /* Termina nodo:696   */
      /* Termina nodo:695   */

      /* Empieza nodo:697 / Elemento padre: 694   */
      v.add(doc.createElement("table"));
      ((Element)v.get(697)).setAttribute("width","100%" );
      ((Element)v.get(697)).setAttribute("border","0" );
      ((Element)v.get(697)).setAttribute("align","center" );
      ((Element)v.get(697)).setAttribute("cellspacing","0" );
      ((Element)v.get(697)).setAttribute("cellpadding","0" );
      ((Element)v.get(694)).appendChild((Element)v.get(697));

      /* Empieza nodo:698 / Elemento padre: 697   */
   }

   private void getXML2880(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(697)).appendChild((Element)v.get(698));

      /* Empieza nodo:699 / Elemento padre: 698   */
      v.add(doc.createElement("td"));
      ((Element)v.get(698)).appendChild((Element)v.get(699));

      /* Empieza nodo:700 / Elemento padre: 699   */
      v.add(doc.createElement("table"));
      ((Element)v.get(700)).setAttribute("width","687" );
      ((Element)v.get(700)).setAttribute("border","0" );
      ((Element)v.get(700)).setAttribute("align","left" );
      ((Element)v.get(700)).setAttribute("cellspacing","0" );
      ((Element)v.get(700)).setAttribute("cellpadding","0" );
      ((Element)v.get(699)).appendChild((Element)v.get(700));

      /* Empieza nodo:701 / Elemento padre: 700   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(700)).appendChild((Element)v.get(701));

      /* Empieza nodo:702 / Elemento padre: 701   */
      v.add(doc.createElement("td"));
      ((Element)v.get(702)).setAttribute("colspan","4" );
      ((Element)v.get(701)).appendChild((Element)v.get(702));

      /* Empieza nodo:703 / Elemento padre: 702   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(703)).setAttribute("src","b.gif" );
      ((Element)v.get(703)).setAttribute("width","8" );
      ((Element)v.get(703)).setAttribute("height","341" );
      ((Element)v.get(702)).appendChild((Element)v.get(703));
      /* Termina nodo:703   */
      /* Termina nodo:702   */
      /* Termina nodo:701   */

      /* Empieza nodo:704 / Elemento padre: 700   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(700)).appendChild((Element)v.get(704));

      /* Empieza nodo:705 / Elemento padre: 704   */
      v.add(doc.createElement("td"));
      ((Element)v.get(704)).appendChild((Element)v.get(705));

      /* Empieza nodo:706 / Elemento padre: 705   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(706)).setAttribute("src","b.gif" );
      ((Element)v.get(706)).setAttribute("width","8" );
      ((Element)v.get(706)).setAttribute("height","8" );
      ((Element)v.get(705)).appendChild((Element)v.get(706));
      /* Termina nodo:706   */
      /* Termina nodo:705   */

      /* Empieza nodo:707 / Elemento padre: 704   */
      v.add(doc.createElement("td"));
      ((Element)v.get(704)).appendChild((Element)v.get(707));

      /* Empieza nodo:708 / Elemento padre: 707   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(708)).setAttribute("nombre","lblProductos1" );
      ((Element)v.get(708)).setAttribute("alto","13" );
      ((Element)v.get(708)).setAttribute("filas","1" );
      ((Element)v.get(708)).setAttribute("valor","" );
      ((Element)v.get(708)).setAttribute("id","datosTitle" );
      ((Element)v.get(708)).setAttribute("cod","515" );
      ((Element)v.get(707)).appendChild((Element)v.get(708));
      /* Termina nodo:708   */
      /* Termina nodo:707   */

      /* Empieza nodo:709 / Elemento padre: 704   */
      v.add(doc.createElement("td"));
      ((Element)v.get(704)).appendChild((Element)v.get(709));

      /* Empieza nodo:710 / Elemento padre: 709   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(710)).setAttribute("src","b.gif" );
      ((Element)v.get(710)).setAttribute("width","25" );
      ((Element)v.get(710)).setAttribute("height","8" );
      ((Element)v.get(709)).appendChild((Element)v.get(710));
      /* Termina nodo:710   */
      /* Termina nodo:709   */

      /* Empieza nodo:711 / Elemento padre: 704   */
      v.add(doc.createElement("td"));
      ((Element)v.get(704)).appendChild((Element)v.get(711));

      /* Empieza nodo:712 / Elemento padre: 711   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(712)).setAttribute("nombre","lblNumeroUnidades1" );
      ((Element)v.get(712)).setAttribute("alto","13" );
      ((Element)v.get(712)).setAttribute("filas","1" );
      ((Element)v.get(712)).setAttribute("valor","" );
      ((Element)v.get(712)).setAttribute("id","datosTitle" );
      ((Element)v.get(712)).setAttribute("cod","495" );
      ((Element)v.get(711)).appendChild((Element)v.get(712));
      /* Termina nodo:712   */
      /* Termina nodo:711   */

      /* Empieza nodo:713 / Elemento padre: 704   */
      v.add(doc.createElement("td"));
      ((Element)v.get(713)).setAttribute("width","100%" );
      ((Element)v.get(704)).appendChild((Element)v.get(713));

      /* Empieza nodo:714 / Elemento padre: 713   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(714)).setAttribute("src","b.gif" );
      ((Element)v.get(714)).setAttribute("width","8" );
      ((Element)v.get(714)).setAttribute("height","8" );
      ((Element)v.get(713)).appendChild((Element)v.get(714));
      /* Termina nodo:714   */
      /* Termina nodo:713   */
      /* Termina nodo:704   */

      /* Empieza nodo:715 / Elemento padre: 700   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(700)).appendChild((Element)v.get(715));

      /* Empieza nodo:716 / Elemento padre: 715   */
      v.add(doc.createElement("td"));
      ((Element)v.get(715)).appendChild((Element)v.get(716));

      /* Empieza nodo:717 / Elemento padre: 716   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(717)).setAttribute("src","b.gif" );
      ((Element)v.get(717)).setAttribute("width","8" );
      ((Element)v.get(717)).setAttribute("height","8" );
      ((Element)v.get(716)).appendChild((Element)v.get(717));
      /* Termina nodo:717   */
      /* Termina nodo:716   */

      /* Empieza nodo:718 / Elemento padre: 715   */
      v.add(doc.createElement("td"));
      ((Element)v.get(715)).appendChild((Element)v.get(718));

      /* Empieza nodo:719 / Elemento padre: 718   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(719)).setAttribute("nombre","txtProductos" );
      ((Element)v.get(719)).setAttribute("id","datosCampos" );
      ((Element)v.get(719)).setAttribute("size","20" );
      ((Element)v.get(719)).setAttribute("max","20" );
      ((Element)v.get(719)).setAttribute("multiple","N" );
      ((Element)v.get(719)).setAttribute("req","N" );
      ((Element)v.get(719)).setAttribute("valorinicial","" );
      ((Element)v.get(719)).setAttribute("textoinicial","productos0productos0productos0productos0" );
      ((Element)v.get(718)).appendChild((Element)v.get(719));
      /* Termina nodo:719   */
      /* Termina nodo:718   */

      /* Empieza nodo:720 / Elemento padre: 715   */
      v.add(doc.createElement("td"));
      ((Element)v.get(715)).appendChild((Element)v.get(720));

      /* Empieza nodo:721 / Elemento padre: 720   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(721)).setAttribute("src","b.gif" );
   }

   private void getXML2970(Document doc) {
      ((Element)v.get(721)).setAttribute("width","25" );
      ((Element)v.get(721)).setAttribute("height","8" );
      ((Element)v.get(720)).appendChild((Element)v.get(721));
      /* Termina nodo:721   */
      /* Termina nodo:720   */

      /* Empieza nodo:722 / Elemento padre: 715   */
      v.add(doc.createElement("td"));
      ((Element)v.get(715)).appendChild((Element)v.get(722));

      /* Empieza nodo:723 / Elemento padre: 722   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(723)).setAttribute("nombre","txtNumeroUnidades" );
      ((Element)v.get(723)).setAttribute("id","datosCampos" );
      ((Element)v.get(723)).setAttribute("max","4" );
      ((Element)v.get(723)).setAttribute("tipo","" );
      ((Element)v.get(723)).setAttribute("onchange","" );
      ((Element)v.get(723)).setAttribute("req","N" );
      ((Element)v.get(723)).setAttribute("size","4" );
      ((Element)v.get(723)).setAttribute("valor","" );
      ((Element)v.get(723)).setAttribute("validacion","" );
      ((Element)v.get(722)).appendChild((Element)v.get(723));
      /* Termina nodo:723   */
      /* Termina nodo:722   */

      /* Empieza nodo:724 / Elemento padre: 715   */
      v.add(doc.createElement("td"));
      ((Element)v.get(724)).setAttribute("width","100%" );
      ((Element)v.get(715)).appendChild((Element)v.get(724));

      /* Empieza nodo:725 / Elemento padre: 724   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(725)).setAttribute("src","b.gif" );
      ((Element)v.get(725)).setAttribute("width","8" );
      ((Element)v.get(725)).setAttribute("height","8" );
      ((Element)v.get(724)).appendChild((Element)v.get(725));
      /* Termina nodo:725   */
      /* Termina nodo:724   */
      /* Termina nodo:715   */

      /* Empieza nodo:726 / Elemento padre: 700   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(700)).appendChild((Element)v.get(726));

      /* Empieza nodo:727 / Elemento padre: 726   */
      v.add(doc.createElement("td"));
      ((Element)v.get(727)).setAttribute("colspan","4" );
      ((Element)v.get(726)).appendChild((Element)v.get(727));

      /* Empieza nodo:728 / Elemento padre: 727   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(728)).setAttribute("src","b.gif" );
      ((Element)v.get(728)).setAttribute("width","8" );
      ((Element)v.get(728)).setAttribute("height","8" );
      ((Element)v.get(727)).appendChild((Element)v.get(728));
      /* Termina nodo:728   */
      /* Termina nodo:727   */
      /* Termina nodo:726   */
      /* Termina nodo:700   */
      /* Termina nodo:699   */
      /* Termina nodo:698   */
      /* Termina nodo:697   */
      /* Termina nodo:694   */
      /* Termina nodo:693   */

      /* Empieza nodo:729 / Elemento padre: 690   */
      v.add(doc.createElement("td"));
      ((Element)v.get(690)).appendChild((Element)v.get(729));

      /* Empieza nodo:730 / Elemento padre: 729   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(730)).setAttribute("src","b.gif" );
      ((Element)v.get(730)).setAttribute("width","12" );
      ((Element)v.get(730)).setAttribute("height","12" );
      ((Element)v.get(729)).appendChild((Element)v.get(730));
      /* Termina nodo:730   */
      /* Termina nodo:729   */
      /* Termina nodo:690   */

      /* Empieza nodo:731 / Elemento padre: 686   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(686)).appendChild((Element)v.get(731));

      /* Empieza nodo:732 / Elemento padre: 731   */
      v.add(doc.createElement("td"));
      ((Element)v.get(731)).appendChild((Element)v.get(732));

      /* Empieza nodo:733 / Elemento padre: 732   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(733)).setAttribute("src","b.gif" );
      ((Element)v.get(732)).appendChild((Element)v.get(733));
      /* Termina nodo:733   */
      /* Termina nodo:732   */

      /* Empieza nodo:734 / Elemento padre: 731   */
      v.add(doc.createElement("td"));
      ((Element)v.get(731)).appendChild((Element)v.get(734));

      /* Empieza nodo:735 / Elemento padre: 734   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(734)).appendChild((Element)v.get(735));

      /* Empieza nodo:736 / Elemento padre: 735   */
      v.add(doc.createElement("table"));
      ((Element)v.get(736)).setAttribute("width","100%" );
      ((Element)v.get(736)).setAttribute("border","0" );
      ((Element)v.get(736)).setAttribute("align","center" );
      ((Element)v.get(736)).setAttribute("cellspacing","0" );
      ((Element)v.get(736)).setAttribute("cellpadding","0" );
      ((Element)v.get(735)).appendChild((Element)v.get(736));

      /* Empieza nodo:737 / Elemento padre: 736   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(736)).appendChild((Element)v.get(737));

      /* Empieza nodo:738 / Elemento padre: 737   */
      v.add(doc.createElement("td"));
      ((Element)v.get(738)).setAttribute("class","botonera" );
      ((Element)v.get(738)).setAttribute("width","100%" );
      ((Element)v.get(737)).appendChild((Element)v.get(738));

      /* Empieza nodo:739 / Elemento padre: 738   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(739)).setAttribute("nombre","btnAnadir" );
      ((Element)v.get(739)).setAttribute("ID","botonContenido" );
      ((Element)v.get(739)).setAttribute("tipo","html" );
      ((Element)v.get(739)).setAttribute("accion","anadir();" );
      ((Element)v.get(739)).setAttribute("estado","false" );
      ((Element)v.get(739)).setAttribute("cod","404" );
      ((Element)v.get(739)).setAttribute("ontab","_foc('txtCodigoSAP')" );
      ((Element)v.get(738)).appendChild((Element)v.get(739));
      /* Termina nodo:739   */
      /* Termina nodo:738   */
      /* Termina nodo:737   */
      /* Termina nodo:736   */
      /* Termina nodo:735   */
      /* Termina nodo:734   */

      /* Empieza nodo:740 / Elemento padre: 731   */
      v.add(doc.createElement("td"));
      ((Element)v.get(731)).appendChild((Element)v.get(740));

      /* Empieza nodo:741 / Elemento padre: 740   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(741)).setAttribute("src","b.gif" );
      ((Element)v.get(741)).setAttribute("width","12" );
      ((Element)v.get(741)).setAttribute("height","12" );
      ((Element)v.get(740)).appendChild((Element)v.get(741));
      /* Termina nodo:741   */
      /* Termina nodo:740   */
      /* Termina nodo:731   */

      /* Empieza nodo:742 / Elemento padre: 686   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(686)).appendChild((Element)v.get(742));

      /* Empieza nodo:743 / Elemento padre: 742   */
      v.add(doc.createElement("td"));
      ((Element)v.get(743)).setAttribute("colspan","4" );
      ((Element)v.get(742)).appendChild((Element)v.get(743));

      /* Empieza nodo:744 / Elemento padre: 743   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(744)).setAttribute("src","b.gif" );
      ((Element)v.get(744)).setAttribute("width","8" );
      ((Element)v.get(744)).setAttribute("height","8" );
   }

   private void getXML3060(Document doc) {
      ((Element)v.get(743)).appendChild((Element)v.get(744));
      /* Termina nodo:744   */
      /* Termina nodo:743   */
      /* Termina nodo:742   */
      /* Termina nodo:686   */
      /* Termina nodo:685   */
      /* Termina nodo:684   */
      /* Termina nodo:133   */
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:745 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).appendChild((Element)v.get(745));

      /* Empieza nodo:746 / Elemento padre: 745   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(746)).setAttribute("src","b.gif" );
      ((Element)v.get(745)).appendChild((Element)v.get(746));
      /* Termina nodo:746   */
      /* Termina nodo:745   */
      /* Termina nodo:126   */

      /* Empieza nodo:747 / Elemento padre: 118   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(118)).appendChild((Element)v.get(747));

      /* Empieza nodo:748 / Elemento padre: 747   */
      v.add(doc.createElement("td"));
      ((Element)v.get(748)).setAttribute("width","12" );
      ((Element)v.get(748)).setAttribute("align","center" );
      ((Element)v.get(747)).appendChild((Element)v.get(748));

      /* Empieza nodo:749 / Elemento padre: 748   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(749)).setAttribute("src","b.gif" );
      ((Element)v.get(749)).setAttribute("width","12" );
      ((Element)v.get(749)).setAttribute("height","12" );
      ((Element)v.get(748)).appendChild((Element)v.get(749));
      /* Termina nodo:749   */
      /* Termina nodo:748   */

      /* Empieza nodo:750 / Elemento padre: 747   */
      v.add(doc.createElement("td"));
      ((Element)v.get(750)).setAttribute("width","756" );
      ((Element)v.get(747)).appendChild((Element)v.get(750));

      /* Empieza nodo:751 / Elemento padre: 750   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(751)).setAttribute("src","b.gif" );
      ((Element)v.get(750)).appendChild((Element)v.get(751));
      /* Termina nodo:751   */
      /* Termina nodo:750   */

      /* Empieza nodo:752 / Elemento padre: 747   */
      v.add(doc.createElement("td"));
      ((Element)v.get(752)).setAttribute("width","12" );
      ((Element)v.get(747)).appendChild((Element)v.get(752));

      /* Empieza nodo:753 / Elemento padre: 752   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(753)).setAttribute("src","b.gif" );
      ((Element)v.get(753)).setAttribute("width","12" );
      ((Element)v.get(753)).setAttribute("height","1" );
      ((Element)v.get(752)).appendChild((Element)v.get(753));
      /* Termina nodo:753   */
      /* Termina nodo:752   */
      /* Termina nodo:747   */
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:754 / Elemento padre: 8   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(754)).setAttribute("nombre","listado1" );
      ((Element)v.get(754)).setAttribute("ancho","667" );
      ((Element)v.get(754)).setAttribute("alto","317" );
      ((Element)v.get(754)).setAttribute("x","32" );
      ((Element)v.get(754)).setAttribute("y","586" );
      ((Element)v.get(754)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(754)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(8)).appendChild((Element)v.get(754));

      /* Empieza nodo:755 / Elemento padre: 754   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(755)).setAttribute("precarga","S" );
      ((Element)v.get(755)).setAttribute("conROver","S" );
      ((Element)v.get(754)).appendChild((Element)v.get(755));

      /* Empieza nodo:756 / Elemento padre: 755   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(756)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(756)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(756)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(756)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(755)).appendChild((Element)v.get(756));
      /* Termina nodo:756   */

      /* Empieza nodo:757 / Elemento padre: 755   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(757)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(757)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(757)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(757)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(755)).appendChild((Element)v.get(757));
      /* Termina nodo:757   */

      /* Empieza nodo:758 / Elemento padre: 755   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(758)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(758)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(755)).appendChild((Element)v.get(758));
      /* Termina nodo:758   */
      /* Termina nodo:755   */

      /* Empieza nodo:759 / Elemento padre: 754   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(754)).appendChild((Element)v.get(759));

      /* Empieza nodo:760 / Elemento padre: 759   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(760)).setAttribute("borde","1" );
      ((Element)v.get(760)).setAttribute("horizDatos","1" );
      ((Element)v.get(760)).setAttribute("horizCabecera","1" );
      ((Element)v.get(760)).setAttribute("vertical","1" );
      ((Element)v.get(760)).setAttribute("horizTitulo","1" );
      ((Element)v.get(760)).setAttribute("horizBase","1" );
      ((Element)v.get(759)).appendChild((Element)v.get(760));
      /* Termina nodo:760   */

      /* Empieza nodo:761 / Elemento padre: 759   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(761)).setAttribute("borde","#999999" );
      ((Element)v.get(761)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(761)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(761)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(761)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(761)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(761)).setAttribute("horizBase","#999999" );
      ((Element)v.get(759)).appendChild((Element)v.get(761));
      /* Termina nodo:761   */
      /* Termina nodo:759   */

      /* Empieza nodo:762 / Elemento padre: 754   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(762)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(762)).setAttribute("alto","22" );
      ((Element)v.get(762)).setAttribute("imgFondo","" );
      ((Element)v.get(762)).setAttribute("cod","00135" );
      ((Element)v.get(762)).setAttribute("ID","datosTitle" );
      ((Element)v.get(754)).appendChild((Element)v.get(762));
      /* Termina nodo:762   */

      /* Empieza nodo:763 / Elemento padre: 754   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(763)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(763)).setAttribute("alto","22" );
      ((Element)v.get(763)).setAttribute("imgFondo","" );
   }

   private void getXML3150(Document doc) {
      ((Element)v.get(754)).appendChild((Element)v.get(763));
      /* Termina nodo:763   */

      /* Empieza nodo:764 / Elemento padre: 754   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(764)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(764)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(764)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(764)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(764)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(764)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(754)).appendChild((Element)v.get(764));

      /* Empieza nodo:765 / Elemento padre: 764   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(765)).setAttribute("ancho","10" );
      ((Element)v.get(765)).setAttribute("minimizable","S" );
      ((Element)v.get(765)).setAttribute("minimizada","N" );
      ((Element)v.get(764)).appendChild((Element)v.get(765));
      /* Termina nodo:765   */

      /* Empieza nodo:766 / Elemento padre: 764   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(766)).setAttribute("ancho","20" );
      ((Element)v.get(766)).setAttribute("minimizable","S" );
      ((Element)v.get(766)).setAttribute("minimizada","N" );
      ((Element)v.get(764)).appendChild((Element)v.get(766));
      /* Termina nodo:766   */
      /* Termina nodo:764   */

      /* Empieza nodo:767 / Elemento padre: 754   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(767)).setAttribute("alto","20" );
      ((Element)v.get(767)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(767)).setAttribute("imgFondo","" );
      ((Element)v.get(767)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(754)).appendChild((Element)v.get(767));

      /* Empieza nodo:768 / Elemento padre: 767   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(768)).setAttribute("colFondo","" );
      ((Element)v.get(768)).setAttribute("ID","EstCab" );
      ((Element)v.get(768)).setAttribute("cod","515" );
      ((Element)v.get(767)).appendChild((Element)v.get(768));
      /* Termina nodo:768   */

      /* Empieza nodo:769 / Elemento padre: 767   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(769)).setAttribute("colFondo","" );
      ((Element)v.get(769)).setAttribute("ID","EstCab" );
      ((Element)v.get(769)).setAttribute("cod","495" );
      ((Element)v.get(767)).appendChild((Element)v.get(769));
      /* Termina nodo:769   */
      /* Termina nodo:767   */

      /* Empieza nodo:770 / Elemento padre: 754   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(770)).setAttribute("alto","22" );
      ((Element)v.get(770)).setAttribute("accion","" );
      ((Element)v.get(770)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(770)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(770)).setAttribute("maxSel","-1" );
      ((Element)v.get(770)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(770)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(770)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(770)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(754)).appendChild((Element)v.get(770));

      /* Empieza nodo:771 / Elemento padre: 770   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(771)).setAttribute("tipo","texto" );
      ((Element)v.get(771)).setAttribute("ID","EstDat" );
      ((Element)v.get(770)).appendChild((Element)v.get(771));
      /* Termina nodo:771   */

      /* Empieza nodo:772 / Elemento padre: 770   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(772)).setAttribute("tipo","texto" );
      ((Element)v.get(772)).setAttribute("ID","EstDat2" );
      ((Element)v.get(770)).appendChild((Element)v.get(772));
      /* Termina nodo:772   */
      /* Termina nodo:770   */

      /* Empieza nodo:773 / Elemento padre: 754   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(754)).appendChild((Element)v.get(773));
      /* Termina nodo:773   */

      /* Empieza nodo:774 / Elemento padre: 754   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(774)).setAttribute("nombre","mipgndo1" );
      ((Element)v.get(774)).setAttribute("ancho","667" );
      ((Element)v.get(774)).setAttribute("sep","$" );
      ((Element)v.get(774)).setAttribute("x","32" );
      ((Element)v.get(774)).setAttribute("class","botonera" );
      ((Element)v.get(774)).setAttribute("y","880" );
      ((Element)v.get(774)).setAttribute("control","|" );
      ((Element)v.get(774)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(774)).setAttribute("rowset","" );
      ((Element)v.get(774)).setAttribute("cargainicial","N" );
      ((Element)v.get(754)).appendChild((Element)v.get(774));

      /* Empieza nodo:775 / Elemento padre: 774   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(775)).setAttribute("nombre","ret1" );
      ((Element)v.get(775)).setAttribute("x","57" );
      ((Element)v.get(775)).setAttribute("y","884" );
      ((Element)v.get(775)).setAttribute("ID","botonContenido" );
      ((Element)v.get(775)).setAttribute("img","retroceder_on" );
      ((Element)v.get(775)).setAttribute("tipo","0" );
      ((Element)v.get(775)).setAttribute("estado","false" );
      ((Element)v.get(775)).setAttribute("alt","" );
      ((Element)v.get(775)).setAttribute("codigo","" );
      ((Element)v.get(775)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(774)).appendChild((Element)v.get(775));
      /* Termina nodo:775   */

      /* Empieza nodo:776 / Elemento padre: 774   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(776)).setAttribute("nombre","ava1" );
      ((Element)v.get(776)).setAttribute("x","72" );
      ((Element)v.get(776)).setAttribute("y","884" );
      ((Element)v.get(776)).setAttribute("ID","botonContenido" );
      ((Element)v.get(776)).setAttribute("img","avanzar_on" );
      ((Element)v.get(776)).setAttribute("tipo","0" );
      ((Element)v.get(776)).setAttribute("estado","false" );
      ((Element)v.get(776)).setAttribute("alt","" );
      ((Element)v.get(776)).setAttribute("codigo","" );
   }

   private void getXML3240(Document doc) {
      ((Element)v.get(776)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(774)).appendChild((Element)v.get(776));
      /* Termina nodo:776   */
      /* Termina nodo:774   */
      /* Termina nodo:754   */

      /* Empieza nodo:777 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(777)).setAttribute("nombre","primera1" );
      ((Element)v.get(777)).setAttribute("x","40" );
      ((Element)v.get(777)).setAttribute("y","884" );
      ((Element)v.get(777)).setAttribute("ID","botonContenido" );
      ((Element)v.get(777)).setAttribute("img","primera_on" );
      ((Element)v.get(777)).setAttribute("tipo","-2" );
      ((Element)v.get(777)).setAttribute("estado","false" );
      ((Element)v.get(777)).setAttribute("alt","" );
      ((Element)v.get(777)).setAttribute("codigo","" );
      ((Element)v.get(777)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(8)).appendChild((Element)v.get(777));
      /* Termina nodo:777   */

      /* Empieza nodo:778 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(778)).setAttribute("nombre","separa1" );
      ((Element)v.get(778)).setAttribute("x","79" );
      ((Element)v.get(778)).setAttribute("y","880" );
      ((Element)v.get(778)).setAttribute("ID","botonContenido" );
      ((Element)v.get(778)).setAttribute("img","separa_base" );
      ((Element)v.get(778)).setAttribute("tipo","0" );
      ((Element)v.get(778)).setAttribute("estado","false" );
      ((Element)v.get(778)).setAttribute("alt","" );
      ((Element)v.get(778)).setAttribute("codigo","" );
      ((Element)v.get(778)).setAttribute("accion","" );
      ((Element)v.get(8)).appendChild((Element)v.get(778));
      /* Termina nodo:778   */

      /* Empieza nodo:779 / Elemento padre: 8   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(779)).setAttribute("nombre","capaLista" );
      ((Element)v.get(779)).setAttribute("alto","100%" );
      ((Element)v.get(779)).setAttribute("ancho","100%" );
      ((Element)v.get(779)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(779)).setAttribute("borde","0" );
      ((Element)v.get(779)).setAttribute("imagenf","" );
      ((Element)v.get(779)).setAttribute("repeat","" );
      ((Element)v.get(779)).setAttribute("padding","" );
      ((Element)v.get(779)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(779)).setAttribute("contravsb","" );
      ((Element)v.get(779)).setAttribute("x","0" );
      ((Element)v.get(779)).setAttribute("y","0" );
      ((Element)v.get(779)).setAttribute("zindex","" );
      ((Element)v.get(8)).appendChild((Element)v.get(779));

      /* Empieza nodo:780 / Elemento padre: 779   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(780)).setAttribute("seleccion","boton" );
      ((Element)v.get(780)).setAttribute("nombre","lstOculta" );
      ((Element)v.get(780)).setAttribute("x","0" );
      ((Element)v.get(780)).setAttribute("y","0" );
      ((Element)v.get(780)).setAttribute("ancho","580" );
      ((Element)v.get(780)).setAttribute("alto","150" );
      ((Element)v.get(780)).setAttribute("multisel","-1" );
      ((Element)v.get(780)).setAttribute("incy","10" );
      ((Element)v.get(780)).setAttribute("incx","12" );
      ((Element)v.get(780)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(780)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(780)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(780)).setAttribute("accion","" );
      ((Element)v.get(780)).setAttribute("sep","|" );
      ((Element)v.get(780)).setAttribute("pixelsborde","3" );
      ((Element)v.get(780)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(779)).appendChild((Element)v.get(780));

      /* Empieza nodo:781 / Elemento padre: 780   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(781)).setAttribute("nombre","cab1" );
      ((Element)v.get(781)).setAttribute("height","20" );
      ((Element)v.get(780)).appendChild((Element)v.get(781));

      /* Empieza nodo:782 / Elemento padre: 781   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(782)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(782)).setAttribute("ancho","13" );
      ((Element)v.get(781)).appendChild((Element)v.get(782));
      /* Termina nodo:782   */

      /* Empieza nodo:783 / Elemento padre: 781   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(783)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(783)).setAttribute("ancho","50" );
      ((Element)v.get(781)).appendChild((Element)v.get(783));

      /* Empieza nodo:784 / Elemento padre: 783   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(784)).setAttribute("nombre","lblTit01" );
      ((Element)v.get(784)).setAttribute("ancho","50" );
      ((Element)v.get(784)).setAttribute("alto","20" );
      ((Element)v.get(784)).setAttribute("filas","1" );
      ((Element)v.get(784)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(784)).setAttribute("valor","Desc" );
      ((Element)v.get(784)).setAttribute("cod","" );
      ((Element)v.get(784)).setAttribute("enviaroculto","N" );
      ((Element)v.get(783)).appendChild((Element)v.get(784));
      /* Termina nodo:784   */
      /* Termina nodo:783   */

      /* Empieza nodo:785 / Elemento padre: 781   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(785)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(785)).setAttribute("ancho","50" );
      ((Element)v.get(781)).appendChild((Element)v.get(785));

      /* Empieza nodo:786 / Elemento padre: 785   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(786)).setAttribute("nombre","lblTit02" );
      ((Element)v.get(786)).setAttribute("ancho","50" );
      ((Element)v.get(786)).setAttribute("alto","20" );
      ((Element)v.get(786)).setAttribute("filas","1" );
   }

   private void getXML3330(Document doc) {
      ((Element)v.get(786)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(786)).setAttribute("valor","tipo" );
      ((Element)v.get(786)).setAttribute("cod","" );
      ((Element)v.get(786)).setAttribute("enviaroculto","N" );
      ((Element)v.get(785)).appendChild((Element)v.get(786));
      /* Termina nodo:786   */
      /* Termina nodo:785   */
      /* Termina nodo:781   */

      /* Empieza nodo:787 / Elemento padre: 780   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(787)).setAttribute("ancho","2533" );
      ((Element)v.get(787)).setAttribute("filas","1" );
      ((Element)v.get(787)).setAttribute("bloquesid","['datosCamposCenterImpar','datosCamposCenterPar']" );
      ((Element)v.get(780)).appendChild((Element)v.get(787));

      /* Empieza nodo:788 / Elemento padre: 787   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(788)).setAttribute("ancho","13" );
      ((Element)v.get(788)).setAttribute("caracteres","1" );
      ((Element)v.get(787)).appendChild((Element)v.get(788));
      /* Termina nodo:788   */

      /* Empieza nodo:789 / Elemento padre: 787   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(789)).setAttribute("ancho","50" );
      ((Element)v.get(789)).setAttribute("caracteres","20" );
      ((Element)v.get(787)).appendChild((Element)v.get(789));
      /* Termina nodo:789   */

      /* Empieza nodo:790 / Elemento padre: 787   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(790)).setAttribute("ancho","50" );
      ((Element)v.get(790)).setAttribute("caracteres","20" );
      ((Element)v.get(787)).appendChild((Element)v.get(790));
      /* Termina nodo:790   */
      /* Termina nodo:787   */

      /* Empieza nodo:791 / Elemento padre: 780   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(780)).appendChild((Element)v.get(791));
      /* Termina nodo:791   */
      /* Termina nodo:780   */
      /* Termina nodo:779   */
      /* Termina nodo:8   */


   }

}
