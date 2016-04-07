
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_alcance_tipos_cliente_crear  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_alcance_tipos_cliente_crear" );
      ((Element)v.get(0)).setAttribute("cod","0644" );
      ((Element)v.get(0)).setAttribute("titulo","Ingresar valores de descuento" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
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
      ((Element)v.get(3)).setAttribute("src","utilidadesDTO.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Elemento padre:5 / Elemento actual: 6   */
      v.add(doc.createTextNode("\r          \r         var arrLimpia = new Array();\r         var arrComboTiposCliente;\r         var  arrComboSubtiposCliente    ;\r\r    function onLoadPag(){     \r  \r  configurarMenuSecundario('formulario');\r         fMostrarMensajeError();\r         set('formulario.casoDeUso', get('formulario.hidCasoDeUso'));\r\r         accionError();\r\r         eval (ON_RSZ);\r         mostrarListado();\r\r         guardoConExito();\r         btnProxy(2,'1');\r         \r         document.getElementById(\"InsertarP2\").style.backgroundColor = \"#496A9A\";\r         document.getElementById(\"InsertarP2\").style.color = \"#FFFFFF\";\r         if (get('formulario.hidCasoDeUso') != 'consultar' )  \r           ColocarValoresDeLaMatrizDeDescuento();\r                  \r         if (get('formulario.hidCasoDeUso') == 'consultar' )  {\r                                   \r                                                                                                            resguardarCombos();\r             sicc_cambiar_estado(\"cbTiposCliente\",false);   \r             sicc_cambiar_estado(\"cbSubtiposCliente\",false);   \r             deshabilitarHabilitarBoton('botonContenido','btnAceptar','D');\r             deshabilitarHabilitarBoton('botonContenido','btnAnadir','D');\r             deshabilitarHabilitarBoton('botonContenido','btnEliminar','D');\r             \r             document.all.rbDefinirCliente[0].disabled=true;\r             document.all.rbDefinirCliente[1].disabled=true;\r                                       listado1.actualizaDat();\r             listado1.repinta();                   \r         }\r\r                    function resguardarCombos(){\r             arrComboTiposCliente= get(\"formulario.cbTiposCliente\");   \r             arrComboSubtiposCliente= get(\"formulario.cbSubtiposCliente\");  \r          }\r                  \r                           set('formulario.rbDefinirCliente',get('formulario.hidChkDefinirCliente'));\r         \r                  \r         set('formulario.hidUltimoElementoEnLaLista','1');\r         if (get('formulario.hidCasoDeUso') != 'consultar' ) { \r           focaliza(\"formulario.cbTiposCliente\");\r                  \r         }\r                                    \r                                    \r         tomarDatosPagina();\r                 \r    }\r         \r             function ocultarListado()\r             {\r                  DrdEnsanchaConMargenDcho('listado1',12);\r                  document.all[\"Cplistado1\"].style.visibility='hidden';\r                  document.all[\"CpLin1listado1\"].style.visibility='hidden';\r                  document.all[\"CpLin2listado1\"].style.visibility='hidden';\r                  document.all[\"CpLin3listado1\"].style.visibility='hidden';\r                  document.all[\"CpLin4listado1\"].style.visibility='hidden';\r                  document.all[\"primera1Div\"].style.visibility='hidden';\r                  document.all[\"ret1Div\"].style.visibility='hidden';\r                  document.all[\"ava1Div\"].style.visibility='hidden';\r                  document.all[\"separaDiv\"].style.visibility='hidden';\r                  document.all[\"btnAnadirDiv\"].style.visibility='hidden';\r                  document.all[\"btnEliminarDiv\"].style.visibility='hidden';\r                  eval (ON_RSZ);  \r             }\r         \r             function mostrarListado()\r             {\r                  DrdEnsanchaConMargenDcho('listado1',12);\r                  document.all[\"Cplistado1\"].style.visibility='visible';\r                  document.all[\"CpLin1listado1\"].style.visibility='visible';\r                  document.all[\"CpLin2listado1\"].style.visibility='visible';\r                  document.all[\"CpLin3listado1\"].style.visibility='visible';\r                  document.all[\"CpLin4listado1\"].style.visibility='visible';\r                  document.all[\"primera1Div\"].style.visibility='hidden';\r                  document.all[\"ret1Div\"].style.visibility='hidden';\r                  document.all[\"ava1Div\"].style.visibility='hidden';\r                  document.all[\"separaDiv\"].style.visibility='hidden';\r                  document.all[\"btnAnadirDiv\"].style.visibility='visible';\r                  document.all[\"btnEliminarDiv\"].style.visibility='visible';\r                  eval (ON_RSZ);           \r             }\r         \r                            function	tomarDatosPagina(){\r                                    arrLimpia[0] = get(\"formulario.cbTiposCliente\");\r                                    arrLimpia[1] = get(\"formulario.cbSubtiposCliente\");\r                                    arrLimpia[2] = get(\"formulario.rbDefinirCliente\");\r                   }\r         \r         function fLimpiar()\r         {\r             if (get('formulario.hidCasoDeUso') != 'consultar' )  {\r                  set(\"formulario.cbTiposCliente\",arrLimpia[0]);\r                  \r                  var datosNuevo = new Array();\r                  datosNuevo[0] = [\"\",\"\"];    \r                  set_combo(\"formulario.cbSubtiposCliente\", datosNuevo);\r\r                  if (get('formulario.hidCasoDeUso')=='insertar'){\r                      set('formulario.rbDefinirCliente','N'); \r                  }\r                  else{\r                      var sel = get('formulario.selTiposClientes');\r                      sel = sel.split(\",\");\r                      set('formulario.cbTiposCliente', sel);\r                      buscoTipoCliente();\r                      var sels = get('formulario.selSubtiposClientes');\r                      sels = sels.split(\",\");\r                      set('formulario.cbSubtiposCliente',sels);\r                      \r                      set('formulario.rbDefinirCliente','S'); \r                  }\r\r                  focaliza('formulario.cbTiposCliente');\r             }\r         }\r         \r         \r         \r             function accionAceptar()\r             {\r                 \r                 var vCantValoresEnLista = listado1.datos.length;\r                  if(vCantValoresEnLista > 0){\r                      if( GestionarMensaje('2533'))\r                      {\r                           /*Limpiar lista editable de registros.*/\r             \r                           var nuevos_datos = new Array();\r                           listado1.setDatos(nuevos_datos);\r                      }\r                  }\r             }\r         \r             function accionAniadir(){\r                \r                  var vCantiMaximaItems = get('formulario.txtNmaximoTiposClientes');\r                           var vCantValoresEnLista = listado1.datos.length;\r                  if(vCantiMaximaItems != \"\"){\r                      if (vCantValoresEnLista <= vCantiMaximaItems){\r         \r                           levantaModalClasi();\r                                             \r                      }else {\r                                         GestionarMensaje('1437');\r                                    }\r                  }else levantaModalClasi();\r         \r             }\r         \r    function levantaModalClasi(){\r         if (fValidarCOMBO('formulario.cbSubtiposCliente') == true){\r             if (get('formulario.VisiblePorcentaje') == 'S' && get('formulario.ModificablePorcentaje') == 'S' ){\r                  var obj = new Object();\r                                                      var vSubTipoClienteSeleccionado = getComboSeleccionado('formulario.cbSubtiposCliente');\r                  obj.hidSubTipoCliSel = vSubTipoClienteSeleccionado;\r         \r                  var whnd = mostrarModalSICC('LPMantenimientoAlcanceTipoCliente','aniadir',obj,null,200);\r                  if(whnd!=null){\r                      var posi = parseInt(get('formulario.hidUltimoElementoEnLaLista'), 10);\r                      var codigo = listado1.generaCodigo( posi );\r         \r                      var datos = codigo + \"|\" + whnd[0] + \"|\" +  whnd[1] + \"|\" +  whnd[2] + \"|\" +  whnd[3];  \r                      if (!existeFila(datos)){\r                           var newRow = new Array();\r                           newRow = datos.split(\"|\");\r                           listado1.insertar(newRow);\r                           set('formulario.hidUltimoElementoEnLaLista', codigo);\r                      }\r                  }\r             }\r         }\r    }\r\r    function existeFila(datos)\r    {\r         var codigo = listado1.codigos();\r         var newRow = new Array();\r         newRow = datos.split(\"|\");\r         var flag = false;\r         var a = 0;\r\r         while( (a < codigo.length ) && (flag == false) ){\r             \r             if( newRow[1] == listado1.extraeDato(codigo[a], 0)!=\"\") {                if( newRow[3] == cdos_trim(listado1.extraeDato(codigo[a], 2))){                                       flag = true;\r                      listado1.insertaDato (codigo[a],4,newRow[5]);\r                              }\r             }\r             a++;\r                  }         return flag;\r    }\r         \r    function accionSiguiente() {\r         if (get('formulario.hidCasoDeUso')!=\"consultar\") {\r                  if ( sicc_validaciones_generales(\"grupo1\")) {\r                         if (ObtenerInformacionDescuentosDefinidos())\r                         {\r                             set('formulario.hidChkDefinirCliente',get('formulario.rbDefinirCliente','V'));\r                             set('formulario.conectorAction', 'LPMantenimientoAlcanceTipoCliente');\r                             set('formulario.accion', 'siguiente');\r                             enviaSICC('formulario');\r                         }else\r                           focaliza(\"formulario.cbSubtiposCliente\");\r                  }\r         } else {\r                    set('formulario.hidChkDefinirCliente',get('formulario.rbDefinirCliente','V'));\r                    set('formulario.conectorAction', 'LPMantenimientoAlcanceTipoCliente');\r                    set('formulario.accion', 'siguiente');\r                    enviaSICC('formulario');\r         }\r    }\r         \r    function accionEliminar()\r    {\r         var cantElementosSel = listado1.codSeleccionados();\r         if ( cantElementosSel.length == 0)\r         {\r             GestionarMensaje(\"4\", null, null, null);\r             return ;\r         }\r         listado1.eliminarSelecc();\r    }\r         \r    function tiposClienteOnChange(){\r         if (get('formulario.hidCasoDeUso') != 'consultar' ){\r                           buscoTipoCliente();	\r                    }else{\r                            set(\"formulario.cbTiposCliente\",arrComboTiposCliente);\r                    }\r             }\r    \r         function subtiposClienteOnChange(){\r                   if (get('formulario.hidCasoDeUso') == 'consultar' ){\r                   		 set(\"formulario.cbSubtiposCliente\",arrComboSubtiposCliente);\r                   }\r         } \r         \r    function buscoTipoCliente(){\r         var combo = get(\"formulario.cbTiposCliente\");\r         var id = get(\"formulario.SubtipoClienteOid\");\r         var desc = get(\"formulario.SubtipoClienteDesc\");\r         var padre = get(\"formulario.SubtipoClienteOidPadre\");\r         if (combo !=\"\"){\r             if (combo.length == 1)      {\r                  id = id.split(\",\");\r                  desc = desc.split(\",\");\r                  padre = padre.split(\",\");\r                  var largo = padre.length;\r                  var opciones = new Array();\r                  var j = 1;\r                  var i = 0;\r                  opciones[0] = [\"\", \"\"];\r                  for(i=0; i < largo; i++){                        if(padre[i] == combo){\r                           opciones[j] = [id[i], desc[i]];\r                           j++;\r                     }\r                  }\r             }\r             if (combo.length > 1){\r                  id = id.split(\",\");\r                  desc = desc.split(\",\");\r                  padre = padre.split(\",\");\r                  var largo = padre.length;\r                  var opciones = new Array();\r                  var j = 1;\r                  var i = 0;\r                  var c = 0;\r                  opciones[0] = [\"\", \"\"];\r                  for(c=0;c<combo.length;c++){                       for(i=0; i < largo; i++){                            if(padre[i] == combo[c]){\r                                opciones[j] = [id[i], desc[i]];\r                                j++;\r                           }\r                      }\r                  }\r             }            \r                  if (opciones.length >0)\r                      set_combo(\"formulario.cbSubtiposCliente\", opciones);                  \r         }else{\r             opciones = new Array();\r             opciones[0] = [\"\", \"\"];\r             set_combo(\"formulario.cbSubtiposCliente\", opciones);\r         }\r    }\r            \r         \r             function ColocarValoresDeLaMatrizDeDescuento()\r             {\r                  if (get('formulario.VisibleTiposClientes') == 'N')\r                      ocultarListado();\r                           \r                           if (get('formulario.ModificableTiposClientes') == 'N')\r                                accion('formulario.cbTiposCliente','.disabled=false');\r         \r                  if (get('formulario.VisibleDescuentoCliente') == 'N'){\r                                              visibilidad('capaDefinirCliente','O');\r                  }\r         \r                           if (get('formulario.ModificableDescuentoCliente') == 'N')\r                           {\r                                    document.all.rbDefinirCliente[0].disabled=false;\r                                    document.all.rbDefinirCliente[1].disabled=false;\r                           }\r                           \r                  var sel = get('formulario.selTiposClientes');\r                  sel = sel.split(\",\");\r                  set('formulario.cbTiposCliente', sel);\r                  buscoTipoCliente();\r                  var sels = get('formulario.selSubtiposClientes');\r                  sels = sels.split(\",\");\r                  set('formulario.cbSubtiposCliente',sels);\r             }\r         \r             function listado2String(){\r                           var codigo = listado1.codigos();\r                           var toAdd = \"\";\r                           var total = \"\";\r                           var vHasta = \"\";\r         \r                           for(var a = 0; a < codigo.length ; a++){\r                                    toAdd = codigo[a];\r                                    toAdd = toAdd + \"|\" + cdos_trim(listado1.extraeDato(codigo[a], 0));                  \r                                                                                          var clasificacion = cdos_trim(listado1.extraeDato(codigo[a], 2));\r                                             if  (clasificacion != '')\r                                             toAdd = toAdd + \"|\" + clasificacion;                                              else \r                                                      toAdd = toAdd + \"|0\";\r                                            \r                      toAdd = toAdd + \"|\" + cdos_trim(listado1.extraeDato(codigo[a], 1));\r                      toAdd = toAdd + \"|\" + cdos_trim(listado1.extraeDato(codigo[a], 3));\r\r                                    total = total + \"$\" + toAdd;\r                           }		\r                           return total;\r                  }\r             \r             \r             function ObtenerInformacionDescuentosDefinidos()\r             {\r                                    var descuentosAdicionales = listado2String();\r                  set('formulario.hidDescuentos',descuentosAdicionales);\r         \r                  var vTipoCliente = getComboSeleccionado('formulario.cbTiposCliente');\r                  var vSubTipoCliente = getComboSeleccionado('formulario.cbSubtiposCliente');\r\r                                     if (get('formulario.hidCasoDeUso') != 'consultar' )  {\r                                             if( (get(\"formulario.ObligatorioTiposClientes\")=='S') &&\r                                                                vSubTipoCliente == '')\r                                             {\r                                                      GestionarMensaje('910');\r                                                      return false;\r                                             }\r                                    }\r         \r                  set('formulario.hidOidTipoClienteSel', vTipoCliente);\r                  set('formulario.hidOidSubTipoClienteSel', vSubTipoCliente);\r                  return true;\r             }\r         \r    function fGuardar() {\r                           \r         if ( sicc_validaciones_generales(\"grupo1\")) {\r             if( ObtenerInformacionDescuentosDefinidos())\r             {\r                  set('formulario.hidChkDefinirCliente',get('formulario.rbDefinirCliente','V'));\r                  set('formulario.conectorAction', 'LPMantenimientoAlcanceTipoCliente');\r                                    set('formulario.accion', 'guardar');                  \r                  enviaSICC('formulario');\r             }else\r             focaliza(\"formulario.cbSubtiposCliente\");\r         }\r    }\r\r         function accionExitosa(){\r                  window.close();\r         }\r         \r    function accionGuardar() {\r         if ( sicc_validaciones_generales(\"grupo1\")) {\r           if( ObtenerInformacionDescuentosDefinidos()){\r             set('formulario.hidChkDefinirCliente',get('formulario.rbDefinirCliente','V'));\r             set('formulario.conectorAction', 'LPMantenimientoAlcanceTipoCliente');\r             set('formulario.accion', 'siguiente');\r             enviaSICC('formulario');\r           }else\r                  focaliza(\"formulario.cbSubtiposCliente\");\r         }\r    }\r             \r    function focalista(){\r                  focalizaBotonHTML('botonContenido','btnAnadir');\r    }    \r\r    function focalista2(){\r                    focalizaBotonHTML('botonContenido','btnAceptar');\r    }\r\r   function focalizaListaShTab(FILAEVENTO) {\r         if(FILAEVENTO == 0){\r                          focalizaBotonHTML('botonContenido','btnAceptar');\r         }        \r    }\r\r   function fVolver(){\r         onClickPestanya('0');\r    }\r\r    function navegaPestaniasDetalle(pestanya){\r      if ( sicc_validaciones_generales(\"grupo1\")) {\r         set('formulario.conectorAction', 'LPMantenimientoAlcanceTipoCliente');\r         set('formulario.accion', 'siguiente');\r         if (pestanya == 2){\r             set(\"formulario.hidPestanya\", \"2\");\r                          enviaSICC('formulario');  \r         }\r      }  \r    }\r        \r    function onTabSiguiente()\r    {\r         if ( get('formulario.hidCasoDeUso')!='consultar' )\r             focaliza('formulario.cbTiposCliente')\r    }\r    \r    function accionError(){\r         fMostrarMensajeError();\r    }\r             \r         function onClickPestanya(valor) {\r\r                  set('formulario.idPestanyaDest', valor);\r           \r                  if (get('formulario.hidCasoDeUso')!=\"consultar\") {\r                         if ( sicc_validaciones_generales(\"grupo1\")) \r                         {\r                           if (ObtenerInformacionDescuentosDefinidos())\r                           { 				\r\r                                    if (valor != \"1\") {                                                                                                                  \r                                      set('formulario.hidChkDefinirCliente',get('formulario.rbDefinirCliente','V'));\r                                      set('formulario.conectorAction', 'LPMantenimientoAlcanceTipoCliente');\r                                      set('formulario.accion', 'almacenar');\r\r                                      enviaSICC('formulario');        \r                                    }                                  \r                           } else {\r                              focaliza(\"formulario.cbSubtiposCliente\");\r                           }\r                         }                   } else {                         set('formulario.conectorAction', 'LPMantenimientoAlcanceTipoCliente');             \r                        set('formulario.accion', 'redirigir');\r                        enviaSICC('formulario');          \r                  }            }\r\r\r           \r    "));
      ((Element)v.get(5)).appendChild((Text)v.get(6));

      /* Termina nodo Texto:6   */
      /* Termina nodo:5   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cbTiposCliente" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","1301" );
      ((Element)v.get(8)).setAttribute("group","grupo1" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","cbSubtiposCliente" );
      ((Element)v.get(9)).setAttribute("required","false" );
      ((Element)v.get(9)).setAttribute("cod","1302" );
      ((Element)v.get(9)).setAttribute("group","grupo1" );
      ((Element)v.get(7)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */
      /* Termina nodo:7   */

      /* Empieza nodo:10 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(10)).setAttribute("nombre","formulario" );
      ((Element)v.get(10)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(10));

      /* Empieza nodo:11 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","accion" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","hidIdioma" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hidCasoDeUso" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","varNoLimpiarSICC" );
      ((Element)v.get(18)).setAttribute("valor","true" );
      ((Element)v.get(10)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hidOidDescuento" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hidSubTipoCliSel" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hidChkDefinirCliente" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","SubtipoClienteOid" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","SubtipoClienteDesc" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","SubtipoClienteOidPadre" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","selTiposClientes" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","selSubtiposClientes" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hidOidTipoClienteSel" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hidOidSubTipoClienteSel" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hidDescuentos" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","VisibleTiposClientes" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","ObligatorioTiposClientes" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","ModificableTiposClientes" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","txtNmaximoTiposClientes" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","VisiblePorcentaje" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","ObligatorioPorcentaje" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","ModificablePorcentaje" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","txtNmaximoPorcentaje" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","VisibleDescuentoCliente" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","ObligatorioDescuentoCliente" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","ModificableDescuentoCliente" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","hidUltimoElementoEnLaLista" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","hExito" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","idPestanyaDest" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(44)).setAttribute("nombre","capa1" );
      ((Element)v.get(10)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("table"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(45)).setAttribute("bgcolor","red" );
      ((Element)v.get(45)).setAttribute("width","100%" );
      ((Element)v.get(45)).setAttribute("height","100%" );
      ((Element)v.get(45)).setAttribute("border","0" );
      ((Element)v.get(45)).setAttribute("align","center" );
      ((Element)v.get(45)).setAttribute("cellpadding","0" );
      ((Element)v.get(45)).setAttribute("cellspacing","0" );
      ((Element)v.get(45)).setAttribute("class","menu5" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).setAttribute("width","12" );
      ((Element)v.get(47)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(47)).setAttribute("class","menu5texto" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(48)).setAttribute("src","b.gif" );
      ((Element)v.get(48)).setAttribute("width","12" );
      ((Element)v.get(48)).setAttribute("height","10" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:49 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(49)).setAttribute("class","menu5texto" );
      ((Element)v.get(46)).appendChild((Element)v.get(49));

      /* Elemento padre:49 / Elemento actual: 50   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(49)).appendChild((Text)v.get(50));

      /* Termina nodo Texto:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:51 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).setAttribute("width","10" );
      ((Element)v.get(51)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(51)).setAttribute("class","menu5texto" );
      ((Element)v.get(46)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(52)).setAttribute("src","b.gif" );
      ((Element)v.get(52)).setAttribute("width","10" );
      ((Element)v.get(52)).setAttribute("height","0" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:53 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).setAttribute("width","10" );
      ((Element)v.get(53)).setAttribute("class","menu5texto" );
      ((Element)v.get(46)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(54)).setAttribute("src","b.gif" );
      ((Element)v.get(54)).setAttribute("width","10" );
      ((Element)v.get(54)).setAttribute("height","8" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:55 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).setAttribute("width","20" );
      ((Element)v.get(55)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(55)).setAttribute("class","menu5texto" );
      ((Element)v.get(46)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("table"));
      ((Element)v.get(56)).setAttribute("width","75" );
      ((Element)v.get(56)).setAttribute("border","0" );
      ((Element)v.get(56)).setAttribute("align","center" );
      ((Element)v.get(56)).setAttribute("cellpadding","1" );
      ((Element)v.get(56)).setAttribute("cellspacing","0" );
      ((Element)v.get(56)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(57)).setAttribute("align","center" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(58)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("a"));
      ((Element)v.get(59)).setAttribute("href","#" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(60)).setAttribute("ID","InsertarP1" );
      ((Element)v.get(60)).setAttribute("onmouseover","poneManito('InsertarP1');" );
      ((Element)v.get(60)).setAttribute("onclick","onClickPestanya('0')" );
      ((Element)v.get(60)).setAttribute("style","width:80px;border-style:solid; border-color:#496A9A;border-width:2px;position:relative;top:3px;text-align:center;color:#496A9A;font-family: Arial, Helvetica, sans-serif;font-size: 11px;font-weight: bold; visibility:visible" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));

      /* Elemento padre:60 / Elemento actual: 61   */
      v.add(doc.createTextNode("Datos generales"));
      ((Element)v.get(60)).appendChild((Text)v.get(61));

      /* Termina nodo Texto:61   */
      /* Termina nodo:60   */
      /* Termina nodo:59   */
      /* Termina nodo:58   */
      /* Termina nodo:57   */
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:62 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).setAttribute("width","10" );
      ((Element)v.get(62)).setAttribute("class","menu5texto" );
      ((Element)v.get(46)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(63)).setAttribute("src","b.gif" );
      ((Element)v.get(63)).setAttribute("width","10" );
      ((Element)v.get(63)).setAttribute("height","8" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:64 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).setAttribute("width","20" );
      ((Element)v.get(64)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(64)).setAttribute("class","menu5texto" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(46)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("table"));
      ((Element)v.get(65)).setAttribute("width","75" );
      ((Element)v.get(65)).setAttribute("border","0" );
      ((Element)v.get(65)).setAttribute("align","center" );
      ((Element)v.get(65)).setAttribute("cellpadding","1" );
      ((Element)v.get(65)).setAttribute("cellspacing","0" );
      ((Element)v.get(65)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(66)).setAttribute("align","center" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(67)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(68)).setAttribute("ID","InsertarP2" );
      ((Element)v.get(68)).setAttribute("onclick","onClickPestanya('1')" );
      ((Element)v.get(68)).setAttribute("style","width:80px;border-style:solid; border-color:#496A9A;border-width:2px;position:relative;top:3px;text-align:center;color:#496A9A;font-family: Arial, Helvetica, sans-serif;font-size: 11px;font-weight: bold; visibility:visible" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Elemento padre:68 / Elemento actual: 69   */
      v.add(doc.createTextNode("Tipo de cliente"));
      ((Element)v.get(68)).appendChild((Text)v.get(69));

      /* Termina nodo Texto:69   */
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:70 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).setAttribute("width","10" );
      ((Element)v.get(70)).setAttribute("class","menu5texto" );
      ((Element)v.get(46)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(71)).setAttribute("src","b.gif" );
      ((Element)v.get(71)).setAttribute("width","10" );
      ((Element)v.get(71)).setAttribute("height","8" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:72 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).setAttribute("width","20" );
      ((Element)v.get(72)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(72)).setAttribute("class","menu5texto" );
      ((Element)v.get(46)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("table"));
      ((Element)v.get(73)).setAttribute("width","75" );
      ((Element)v.get(73)).setAttribute("border","0" );
      ((Element)v.get(73)).setAttribute("align","center" );
      ((Element)v.get(73)).setAttribute("cellpadding","1" );
      ((Element)v.get(73)).setAttribute("cellspacing","0" );
      ((Element)v.get(73)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(74)).setAttribute("align","center" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(75)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(76)).setAttribute("ID","InsertarP3" );
      ((Element)v.get(76)).setAttribute("onmouseover","poneManito('InsertarP3');" );
      ((Element)v.get(76)).setAttribute("onclick","onClickPestanya('2')" );
      ((Element)v.get(76)).setAttribute("style","width:80px;border-style:solid; border-color:#496A9A;border-width:2px;position:relative;top:3px;text-align:center;color:#496A9A;font-family: Arial, Helvetica, sans-serif;font-size: 11px;font-weight: bold; visibility:visible" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Elemento padre:76 / Elemento actual: 77   */
      v.add(doc.createTextNode("Alcance administrativo"));
      ((Element)v.get(76)).appendChild((Text)v.get(77));

      /* Termina nodo Texto:77   */
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:78 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).setAttribute("width","10" );
      ((Element)v.get(78)).setAttribute("class","menu5texto" );
      ((Element)v.get(46)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","10" );
      ((Element)v.get(79)).setAttribute("height","8" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:80 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).setAttribute("width","20" );
      ((Element)v.get(80)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(80)).setAttribute("class","menu5texto" );
      ((Element)v.get(46)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("table"));
      ((Element)v.get(81)).setAttribute("width","75" );
      ((Element)v.get(81)).setAttribute("border","0" );
      ((Element)v.get(81)).setAttribute("align","center" );
      ((Element)v.get(81)).setAttribute("cellpadding","1" );
      ((Element)v.get(81)).setAttribute("cellspacing","0" );
      ((Element)v.get(81)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(82)).setAttribute("align","center" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(83)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("DIV"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(84)).setAttribute("ID","InsertarP4" );
      ((Element)v.get(84)).setAttribute("onmouseover","poneManito('InsertarP4');" );
      ((Element)v.get(84)).setAttribute("onclick","onClickPestanya('3')" );
      ((Element)v.get(84)).setAttribute("style","width:80px;border-style:solid; border-color:#496A9A;border-width:2px;position:relative;top:3px;text-align:center;color:#496A9A;font-family: Arial, Helvetica, sans-serif;font-size: 11px;font-weight: bold; visibility:visible" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Elemento padre:84 / Elemento actual: 85   */
      v.add(doc.createTextNode("Base de cálculo"));
      ((Element)v.get(84)).appendChild((Text)v.get(85));

      /* Termina nodo Texto:85   */
      /* Termina nodo:84   */
      /* Termina nodo:83   */
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:86 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(86)).setAttribute("width","10" );
      ((Element)v.get(86)).setAttribute("class","menu5texto" );
      ((Element)v.get(46)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(87)).setAttribute("src","b.gif" );
      ((Element)v.get(87)).setAttribute("width","10" );
      ((Element)v.get(87)).setAttribute("height","8" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:88 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).setAttribute("width","20" );
      ((Element)v.get(88)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(88)).setAttribute("class","menu5texto" );
      ((Element)v.get(46)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("table"));
      ((Element)v.get(89)).setAttribute("width","75" );
      ((Element)v.get(89)).setAttribute("border","0" );
      ((Element)v.get(89)).setAttribute("align","center" );
      ((Element)v.get(89)).setAttribute("cellpadding","1" );
      ((Element)v.get(89)).setAttribute("cellspacing","0" );
      ((Element)v.get(89)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(90)).setAttribute("align","center" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(91)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(92)).setAttribute("ID","InsertarP5" );
      ((Element)v.get(92)).setAttribute("onmouseover","poneManito('InsertarP5');" );
      ((Element)v.get(92)).setAttribute("onclick","onClickPestanya('4')" );
      ((Element)v.get(92)).setAttribute("style","width:80px;border-style:solid; border-color:#496A9A;border-width:2px;position:relative;top:3px;text-align:center;color:#496A9A;font-family: Arial, Helvetica, sans-serif;font-size: 11px;font-weight: bold; visibility:visible" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Elemento padre:92 / Elemento actual: 93   */
      v.add(doc.createTextNode("Aplicación de descuento"));
      ((Element)v.get(92)).appendChild((Text)v.get(93));

      /* Termina nodo Texto:93   */
      /* Termina nodo:92   */
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:94 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).setAttribute("width","16" );
      ((Element)v.get(94)).setAttribute("class","menu5texto" );
      ((Element)v.get(46)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(95)).setAttribute("src","b.gif" );
      ((Element)v.get(95)).setAttribute("width","12" );
      ((Element)v.get(95)).setAttribute("height","8" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:96 / Elemento padre: 44   */
      v.add(doc.createElement("table"));
      ((Element)v.get(96)).setAttribute("width","100%" );
      ((Element)v.get(96)).setAttribute("border","0" );
      ((Element)v.get(96)).setAttribute("cellspacing","0" );
      ((Element)v.get(96)).setAttribute("cellpadding","0" );
      ((Element)v.get(44)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).setAttribute("width","12" );
      ((Element)v.get(98)).setAttribute("align","center" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(99)).setAttribute("src","b.gif" );
      ((Element)v.get(99)).setAttribute("width","12" );
      ((Element)v.get(99)).setAttribute("height","12" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:100 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).setAttribute("width","750" );
      ((Element)v.get(97)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(101)).setAttribute("src","b.gif" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:102 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).setAttribute("width","12" );
      ((Element)v.get(97)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).setAttribute("width","12" );
      ((Element)v.get(103)).setAttribute("height","1" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:97   */

      /* Empieza nodo:104 / Elemento padre: 96   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(96)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:107 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(109)).setAttribute("class","legend" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(110)).setAttribute("nombre","lblDatosClientes" );
      ((Element)v.get(110)).setAttribute("alto","13" );
      ((Element)v.get(110)).setAttribute("filas","1" );
      ((Element)v.get(110)).setAttribute("valor","" );
      ((Element)v.get(110)).setAttribute("cod","0091" );
      ((Element)v.get(110)).setAttribute("id","legend" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:111 / Elemento padre: 108   */
      v.add(doc.createElement("table"));
      ((Element)v.get(111)).setAttribute("width","100%" );
      ((Element)v.get(111)).setAttribute("border","0" );
      ((Element)v.get(111)).setAttribute("align","center" );
      ((Element)v.get(111)).setAttribute("cellspacing","0" );
      ((Element)v.get(111)).setAttribute("cellpadding","0" );
      ((Element)v.get(108)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("table"));
      ((Element)v.get(114)).setAttribute("width","676" );
      ((Element)v.get(114)).setAttribute("border","0" );
      ((Element)v.get(114)).setAttribute("align","left" );
      ((Element)v.get(114)).setAttribute("cellspacing","0" );
      ((Element)v.get(114)).setAttribute("cellpadding","0" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).setAttribute("colspan","4" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(117)).setAttribute("src","b.gif" );
      ((Element)v.get(117)).setAttribute("width","8" );
      ((Element)v.get(117)).setAttribute("height","8" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:118 / Elemento padre: 114   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(114)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(120)).setAttribute("src","b.gif" );
      ((Element)v.get(120)).setAttribute("width","8" );
      ((Element)v.get(120)).setAttribute("height","8" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:121 / Elemento padre: 118   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(122)).setAttribute("nombre","lblTiposCliente" );
      ((Element)v.get(122)).setAttribute("alto","13" );
      ((Element)v.get(122)).setAttribute("filas","1" );
      ((Element)v.get(122)).setAttribute("valor","" );
      ((Element)v.get(122)).setAttribute("id","datosTitle" );
      ((Element)v.get(122)).setAttribute("cod","1301" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:123 / Elemento padre: 118   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(124)).setAttribute("src","b.gif" );
      ((Element)v.get(124)).setAttribute("width","25" );
      ((Element)v.get(124)).setAttribute("height","8" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:125 / Elemento padre: 118   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(126)).setAttribute("nombre","lblSubtiposCliente" );
      ((Element)v.get(126)).setAttribute("alto","13" );
      ((Element)v.get(126)).setAttribute("filas","1" );
      ((Element)v.get(126)).setAttribute("valor","" );
      ((Element)v.get(126)).setAttribute("id","datosTitle" );
      ((Element)v.get(126)).setAttribute("cod","1302" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:127 / Elemento padre: 118   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).setAttribute("width","100%" );
      ((Element)v.get(118)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(128)).setAttribute("src","b.gif" );
      ((Element)v.get(128)).setAttribute("width","8" );
      ((Element)v.get(128)).setAttribute("height","8" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */
      /* Termina nodo:118   */

      /* Empieza nodo:129 / Elemento padre: 114   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(114)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(131)).setAttribute("src","b.gif" );
      ((Element)v.get(131)).setAttribute("width","8" );
      ((Element)v.get(131)).setAttribute("height","8" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:132 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(132)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(129)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(133)).setAttribute("nombre","cbTiposCliente" );
      ((Element)v.get(133)).setAttribute("id","datosCampos" );
      ((Element)v.get(133)).setAttribute("size","5" );
      ((Element)v.get(133)).setAttribute("multiple","S" );
      ((Element)v.get(133)).setAttribute("req","S" );
      ((Element)v.get(133)).setAttribute("valorinicial","" );
      ((Element)v.get(133)).setAttribute("textoinicial","" );
      ((Element)v.get(133)).setAttribute("onchange","tiposClienteOnChange();" );
      ((Element)v.get(133)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnSiguiente')" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:135 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(136)).setAttribute("src","b.gif" );
      ((Element)v.get(136)).setAttribute("width","25" );
      ((Element)v.get(136)).setAttribute("height","8" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:137 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(137)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(137)).setAttribute("valign","bottom" );
      ((Element)v.get(129)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(138)).setAttribute("nombre","cbSubtiposCliente" );
      ((Element)v.get(138)).setAttribute("id","datosCampos" );
      ((Element)v.get(138)).setAttribute("size","5" );
      ((Element)v.get(138)).setAttribute("onchange","subtiposClienteOnChange();" );
      ((Element)v.get(138)).setAttribute("multiple","S" );
      ((Element)v.get(138)).setAttribute("req","N" );
      ((Element)v.get(138)).setAttribute("valorinicial","" );
      ((Element)v.get(138)).setAttribute("textoinicial","" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:140 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).setAttribute("width","100%" );
      ((Element)v.get(129)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(141)).setAttribute("src","b.gif" );
      ((Element)v.get(141)).setAttribute("width","8" );
      ((Element)v.get(141)).setAttribute("height","8" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:129   */

      /* Empieza nodo:142 / Elemento padre: 114   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(114)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).setAttribute("colspan","4" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(144)).setAttribute("src","b.gif" );
      ((Element)v.get(144)).setAttribute("width","8" );
      ((Element)v.get(144)).setAttribute("height","8" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:142   */
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:112   */
      /* Termina nodo:111   */
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:145 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(146)).setAttribute("src","b.gif" );
      ((Element)v.get(146)).setAttribute("width","8" );
      ((Element)v.get(146)).setAttribute("height","12" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:104   */

      /* Empieza nodo:147 / Elemento padre: 96   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(96)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(149)).setAttribute("src","b.gif" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:150 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("table"));
      ((Element)v.get(152)).setAttribute("width","100%" );
      ((Element)v.get(152)).setAttribute("border","0" );
      ((Element)v.get(152)).setAttribute("align","center" );
      ((Element)v.get(152)).setAttribute("cellspacing","0" );
      ((Element)v.get(152)).setAttribute("cellpadding","0" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("tr"));
   }

   private void getXML630(Document doc) {
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).setAttribute("class","botonera" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(155)).setAttribute("nombre","btnAceptar" );
      ((Element)v.get(155)).setAttribute("ID","botonContenido" );
      ((Element)v.get(155)).setAttribute("tipo","html" );
      ((Element)v.get(155)).setAttribute("accion","accionAceptar();" );
      ((Element)v.get(155)).setAttribute("estado","false" );
      ((Element)v.get(155)).setAttribute("ontab","focalista()" );
      ((Element)v.get(155)).setAttribute("cod","12" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:156 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(157)).setAttribute("src","b.gif" );
      ((Element)v.get(157)).setAttribute("width","8" );
      ((Element)v.get(157)).setAttribute("height","12" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:156   */
      /* Termina nodo:147   */

      /* Empieza nodo:158 / Elemento padre: 96   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(96)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(159)).setAttribute("width","12" );
      ((Element)v.get(159)).setAttribute("align","center" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(160)).setAttribute("src","b.gif" );
      ((Element)v.get(160)).setAttribute("width","12" );
      ((Element)v.get(160)).setAttribute("height","8" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:161 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(161)).setAttribute("width","750" );
      ((Element)v.get(158)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(162)).setAttribute("src","b.gif" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:163 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).setAttribute("width","12" );
      ((Element)v.get(158)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(164)).setAttribute("src","b.gif" );
      ((Element)v.get(164)).setAttribute("width","12" );
      ((Element)v.get(164)).setAttribute("height","8" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */
      /* Termina nodo:158   */
      /* Termina nodo:96   */
      /* Termina nodo:44   */

      /* Empieza nodo:165 / Elemento padre: 10   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(165)).setAttribute("nombre","listado1" );
      ((Element)v.get(165)).setAttribute("ancho","680" );
      ((Element)v.get(165)).setAttribute("alto","301" );
      ((Element)v.get(165)).setAttribute("x","12" );
      ((Element)v.get(165)).setAttribute("y","170" );
      ((Element)v.get(165)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(165)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(10)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(166)).setAttribute("precarga","S" );
      ((Element)v.get(166)).setAttribute("conROver","S" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(167)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(167)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(167)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(167)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */

      /* Empieza nodo:168 / Elemento padre: 166   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(168)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(168)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(168)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(168)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(166)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */

      /* Empieza nodo:169 / Elemento padre: 166   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(169)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(169)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(166)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:166   */

      /* Empieza nodo:170 / Elemento padre: 165   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(165)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(171)).setAttribute("borde","1" );
      ((Element)v.get(171)).setAttribute("horizDatos","1" );
      ((Element)v.get(171)).setAttribute("horizCabecera","1" );
      ((Element)v.get(171)).setAttribute("vertical","1" );
      ((Element)v.get(171)).setAttribute("horizTitulo","1" );
      ((Element)v.get(171)).setAttribute("horizBase","1" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */

      /* Empieza nodo:172 / Elemento padre: 170   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(172)).setAttribute("borde","#999999" );
      ((Element)v.get(172)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(172)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(172)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(172)).setAttribute("horizCabecera","#999999" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(172)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(172)).setAttribute("horizBase","#999999" );
      ((Element)v.get(170)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:170   */

      /* Empieza nodo:173 / Elemento padre: 165   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(173)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(173)).setAttribute("alto","22" );
      ((Element)v.get(173)).setAttribute("imgFondo","" );
      ((Element)v.get(173)).setAttribute("cod","00102" );
      ((Element)v.get(173)).setAttribute("ID","datosTitle" );
      ((Element)v.get(165)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */

      /* Empieza nodo:174 / Elemento padre: 165   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(174)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(174)).setAttribute("alto","22" );
      ((Element)v.get(174)).setAttribute("imgFondo","" );
      ((Element)v.get(165)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */

      /* Empieza nodo:175 / Elemento padre: 165   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(175)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(175)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(175)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(175)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(175)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(175)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(165)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(176)).setAttribute("ancho","50" );
      ((Element)v.get(176)).setAttribute("minimizable","S" );
      ((Element)v.get(176)).setAttribute("minimizada","N" );
      ((Element)v.get(176)).setAttribute("oculta","S" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */

      /* Empieza nodo:177 / Elemento padre: 175   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(177)).setAttribute("ancho","50" );
      ((Element)v.get(177)).setAttribute("minimizable","S" );
      ((Element)v.get(177)).setAttribute("minimizada","N" );
      ((Element)v.get(175)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */

      /* Empieza nodo:178 / Elemento padre: 175   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(178)).setAttribute("ancho","40" );
      ((Element)v.get(178)).setAttribute("minimizable","S" );
      ((Element)v.get(178)).setAttribute("minimizada","N" );
      ((Element)v.get(178)).setAttribute("oculta","S" );
      ((Element)v.get(175)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */

      /* Empieza nodo:179 / Elemento padre: 175   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(179)).setAttribute("ancho","50" );
      ((Element)v.get(179)).setAttribute("minimizable","S" );
      ((Element)v.get(179)).setAttribute("minimizada","N" );
      ((Element)v.get(175)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:175   */

      /* Empieza nodo:180 / Elemento padre: 165   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(180)).setAttribute("alto","20" );
      ((Element)v.get(180)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(180)).setAttribute("imgFondo","" );
      ((Element)v.get(180)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(165)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(181)).setAttribute("colFondo","" );
      ((Element)v.get(181)).setAttribute("ID","EstCab" );
      ((Element)v.get(181)).setAttribute("align","center" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));

      /* Elemento padre:181 / Elemento actual: 182   */
      v.add(doc.createTextNode("oidTipoClasificacion"));
      ((Element)v.get(181)).appendChild((Text)v.get(182));

      /* Termina nodo Texto:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:183 / Elemento padre: 180   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(183)).setAttribute("colFondo","" );
      ((Element)v.get(183)).setAttribute("ID","EstCab" );
      ((Element)v.get(183)).setAttribute("align","center" );
      ((Element)v.get(183)).setAttribute("cod","756" );
      ((Element)v.get(180)).appendChild((Element)v.get(183));

      /* Elemento padre:183 / Elemento actual: 184   */
      v.add(doc.createTextNode("Tipo clasificación"));
      ((Element)v.get(183)).appendChild((Text)v.get(184));

      /* Termina nodo Texto:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:185 / Elemento padre: 180   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(185)).setAttribute("colFondo","" );
      ((Element)v.get(185)).setAttribute("ID","EstCab" );
      ((Element)v.get(185)).setAttribute("align","center" );
      ((Element)v.get(180)).appendChild((Element)v.get(185));

      /* Elemento padre:185 / Elemento actual: 186   */
      v.add(doc.createTextNode("oidClasificacion"));
      ((Element)v.get(185)).appendChild((Text)v.get(186));

      /* Termina nodo Texto:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:187 / Elemento padre: 180   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(187)).setAttribute("colFondo","" );
      ((Element)v.get(187)).setAttribute("ID","EstCab" );
      ((Element)v.get(187)).setAttribute("align","center" );
      ((Element)v.get(187)).setAttribute("cod","550" );
      ((Element)v.get(180)).appendChild((Element)v.get(187));

      /* Elemento padre:187 / Elemento actual: 188   */
      v.add(doc.createTextNode("Clasificación"));
      ((Element)v.get(187)).appendChild((Text)v.get(188));

      /* Termina nodo Texto:188   */
      /* Termina nodo:187   */
      /* Termina nodo:180   */

      /* Empieza nodo:189 / Elemento padre: 165   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(189)).setAttribute("alto","22" );
      ((Element)v.get(189)).setAttribute("accion","" );
      ((Element)v.get(189)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(189)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(189)).setAttribute("maxSel","-1" );
      ((Element)v.get(189)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(189)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(189)).setAttribute("colorROver","#D0D9E8" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(189)).setAttribute("onLoad","" );
      ((Element)v.get(189)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(165)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(190)).setAttribute("tipo","texto" );
      ((Element)v.get(190)).setAttribute("ID","EstDat" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */

      /* Empieza nodo:191 / Elemento padre: 189   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(191)).setAttribute("tipo","texto" );
      ((Element)v.get(191)).setAttribute("ID","EstDat" );
      ((Element)v.get(189)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */

      /* Empieza nodo:192 / Elemento padre: 189   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(192)).setAttribute("tipo","texto" );
      ((Element)v.get(192)).setAttribute("ID","EstDat2" );
      ((Element)v.get(189)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */

      /* Empieza nodo:193 / Elemento padre: 189   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(193)).setAttribute("tipo","texto" );
      ((Element)v.get(193)).setAttribute("ID","EstDat2" );
      ((Element)v.get(189)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:189   */

      /* Empieza nodo:194 / Elemento padre: 165   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(165)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */

      /* Empieza nodo:195 / Elemento padre: 165   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(195)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(195)).setAttribute("ancho","680" );
      ((Element)v.get(195)).setAttribute("sep","$" );
      ((Element)v.get(195)).setAttribute("x","12" );
      ((Element)v.get(195)).setAttribute("class","botonera" );
      ((Element)v.get(195)).setAttribute("y","448" );
      ((Element)v.get(195)).setAttribute("control","|" );
      ((Element)v.get(195)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(195)).setAttribute("rowset","" );
      ((Element)v.get(195)).setAttribute("cargainicial","N" );
      ((Element)v.get(165)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(196)).setAttribute("nombre","ret1" );
      ((Element)v.get(196)).setAttribute("x","37" );
      ((Element)v.get(196)).setAttribute("y","452" );
      ((Element)v.get(196)).setAttribute("ID","botonContenido" );
      ((Element)v.get(196)).setAttribute("img","retroceder_on" );
      ((Element)v.get(196)).setAttribute("tipo","0" );
      ((Element)v.get(196)).setAttribute("estado","false" );
      ((Element)v.get(196)).setAttribute("alt","" );
      ((Element)v.get(196)).setAttribute("codigo","" );
      ((Element)v.get(196)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */

      /* Empieza nodo:197 / Elemento padre: 195   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(197)).setAttribute("nombre","ava1" );
      ((Element)v.get(197)).setAttribute("x","52" );
      ((Element)v.get(197)).setAttribute("y","452" );
      ((Element)v.get(197)).setAttribute("ID","botonContenido" );
      ((Element)v.get(197)).setAttribute("img","avanzar_on" );
      ((Element)v.get(197)).setAttribute("tipo","0" );
      ((Element)v.get(197)).setAttribute("estado","false" );
      ((Element)v.get(197)).setAttribute("alt","" );
      ((Element)v.get(197)).setAttribute("codigo","" );
      ((Element)v.get(197)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(195)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:195   */
      /* Termina nodo:165   */

      /* Empieza nodo:198 / Elemento padre: 10   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(198)).setAttribute("nombre","primera1" );
      ((Element)v.get(198)).setAttribute("x","20" );
      ((Element)v.get(198)).setAttribute("y","452" );
      ((Element)v.get(198)).setAttribute("ID","botonContenido" );
      ((Element)v.get(198)).setAttribute("img","primera_on" );
      ((Element)v.get(198)).setAttribute("tipo","-2" );
      ((Element)v.get(198)).setAttribute("estado","false" );
      ((Element)v.get(198)).setAttribute("alt","" );
      ((Element)v.get(198)).setAttribute("codigo","" );
      ((Element)v.get(198)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(10)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */

      /* Empieza nodo:199 / Elemento padre: 10   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(199)).setAttribute("nombre","separa" );
      ((Element)v.get(199)).setAttribute("x","59" );
      ((Element)v.get(199)).setAttribute("y","448" );
      ((Element)v.get(199)).setAttribute("ID","botonContenido" );
      ((Element)v.get(199)).setAttribute("img","separa_base" );
      ((Element)v.get(199)).setAttribute("tipo","0" );
      ((Element)v.get(199)).setAttribute("estado","false" );
      ((Element)v.get(199)).setAttribute("alt","" );
      ((Element)v.get(199)).setAttribute("codigo","" );
      ((Element)v.get(199)).setAttribute("accion","" );
      ((Element)v.get(10)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */

      /* Empieza nodo:200 / Elemento padre: 10   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(200)).setAttribute("nombre","btnAnadir" );
      ((Element)v.get(200)).setAttribute("x","13" );
      ((Element)v.get(200)).setAttribute("y","449" );
      ((Element)v.get(200)).setAttribute("ID","botonContenido" );
      ((Element)v.get(200)).setAttribute("tipo","html" );
      ((Element)v.get(200)).setAttribute("estado","false" );
      ((Element)v.get(200)).setAttribute("accion","accionAniadir();" );
      ((Element)v.get(200)).setAttribute("cod","404" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(200)).setAttribute("onshtab","focalista2()" );
      ((Element)v.get(10)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */

      /* Empieza nodo:201 / Elemento padre: 10   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(201)).setAttribute("nombre","btnEliminar" );
      ((Element)v.get(201)).setAttribute("x","61" );
      ((Element)v.get(201)).setAttribute("y","449" );
      ((Element)v.get(201)).setAttribute("ID","botonContenido" );
      ((Element)v.get(201)).setAttribute("tipo","html" );
      ((Element)v.get(201)).setAttribute("estado","false" );
      ((Element)v.get(201)).setAttribute("accion","accionEliminar();" );
      ((Element)v.get(201)).setAttribute("cod","1254" );
      ((Element)v.get(10)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */

      /* Empieza nodo:202 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(202)).setAttribute("nombre","capa2" );
      ((Element)v.get(202)).setAttribute("alto","100" );
      ((Element)v.get(202)).setAttribute("ancho","100%" );
      ((Element)v.get(202)).setAttribute("colorf","" );
      ((Element)v.get(202)).setAttribute("borde","0" );
      ((Element)v.get(202)).setAttribute("imagenf","" );
      ((Element)v.get(202)).setAttribute("repeat","" );
      ((Element)v.get(202)).setAttribute("padding","" );
      ((Element)v.get(202)).setAttribute("visibilidad","visible" );
      ((Element)v.get(202)).setAttribute("contravsb","" );
      ((Element)v.get(202)).setAttribute("x","0" );
      ((Element)v.get(202)).setAttribute("y","483" );
      ((Element)v.get(202)).setAttribute("zindex","" );
      ((Element)v.get(10)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("table"));
      ((Element)v.get(203)).setAttribute("width","100%" );
      ((Element)v.get(203)).setAttribute("border","0" );
      ((Element)v.get(203)).setAttribute("cellspacing","0" );
      ((Element)v.get(203)).setAttribute("cellpadding","0" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(203)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).setAttribute("width","12" );
      ((Element)v.get(205)).setAttribute("align","center" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(206)).setAttribute("src","b.gif" );
      ((Element)v.get(206)).setAttribute("width","12" );
      ((Element)v.get(206)).setAttribute("height","12" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */

      /* Empieza nodo:207 / Elemento padre: 204   */
      v.add(doc.createElement("td"));
      ((Element)v.get(207)).setAttribute("width","750" );
      ((Element)v.get(204)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(208)).setAttribute("src","b.gif" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:207   */

      /* Empieza nodo:209 / Elemento padre: 204   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).setAttribute("width","12" );
      ((Element)v.get(204)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(210)).setAttribute("src","b.gif" );
      ((Element)v.get(210)).setAttribute("width","12" );
      ((Element)v.get(210)).setAttribute("height","1" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */
      /* Termina nodo:209   */
      /* Termina nodo:204   */

      /* Empieza nodo:211 / Elemento padre: 203   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(203)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("td"));
      ((Element)v.get(211)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(213)).setAttribute("src","b.gif" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:212   */

      /* Empieza nodo:214 / Elemento padre: 211   */
      v.add(doc.createElement("td"));
      ((Element)v.get(211)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(214)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(216)).setAttribute("class","legend" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(217)).setAttribute("nombre","lblClientesEspecificos" );
      ((Element)v.get(217)).setAttribute("alto","13" );
      ((Element)v.get(217)).setAttribute("filas","1" );
      ((Element)v.get(217)).setAttribute("valor","" );
      ((Element)v.get(217)).setAttribute("cod","00464" );
      ((Element)v.get(217)).setAttribute("id","legend" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:216   */

      /* Empieza nodo:218 / Elemento padre: 215   */
      v.add(doc.createElement("table"));
      ((Element)v.get(218)).setAttribute("width","100%" );
      ((Element)v.get(218)).setAttribute("border","0" );
      ((Element)v.get(218)).setAttribute("align","center" );
      ((Element)v.get(218)).setAttribute("cellspacing","0" );
      ((Element)v.get(218)).setAttribute("cellpadding","0" );
      ((Element)v.get(215)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(218)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("td"));
   }

   private void getXML990(Document doc) {
      ((Element)v.get(219)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("table"));
      ((Element)v.get(221)).setAttribute("width","676" );
      ((Element)v.get(221)).setAttribute("border","0" );
      ((Element)v.get(221)).setAttribute("align","left" );
      ((Element)v.get(221)).setAttribute("cellspacing","0" );
      ((Element)v.get(221)).setAttribute("cellpadding","0" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(221)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("td"));
      ((Element)v.get(223)).setAttribute("colspan","4" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(224)).setAttribute("src","b.gif" );
      ((Element)v.get(224)).setAttribute("width","8" );
      ((Element)v.get(224)).setAttribute("height","8" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:223   */
      /* Termina nodo:222   */

      /* Empieza nodo:225 / Elemento padre: 221   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(221)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(225)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(227)).setAttribute("src","b.gif" );
      ((Element)v.get(227)).setAttribute("width","8" );
      ((Element)v.get(227)).setAttribute("height","8" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */

      /* Empieza nodo:228 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(225)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(229)).setAttribute("nombre","lblDefinirCliente" );
      ((Element)v.get(229)).setAttribute("alto","13" );
      ((Element)v.get(229)).setAttribute("filas","1" );
      ((Element)v.get(229)).setAttribute("valor","" );
      ((Element)v.get(229)).setAttribute("id","datosTitle" );
      ((Element)v.get(229)).setAttribute("cod","2183" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */
      /* Termina nodo:228   */

      /* Empieza nodo:230 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(230)).setAttribute("width","100%" );
      ((Element)v.get(225)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(231)).setAttribute("src","b.gif" );
      ((Element)v.get(231)).setAttribute("width","473" );
      ((Element)v.get(231)).setAttribute("height","8" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */
      /* Termina nodo:230   */
      /* Termina nodo:225   */

      /* Empieza nodo:232 / Elemento padre: 221   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(221)).appendChild((Element)v.get(232));

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
      ((Element)v.get(235)).setAttribute("class","datosCampos" );
      ((Element)v.get(232)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(236)).setAttribute("nombre","capaDefinirCliente" );
      ((Element)v.get(236)).setAttribute("colorf","" );
      ((Element)v.get(236)).setAttribute("borde","0" );
      ((Element)v.get(236)).setAttribute("imagenf","" );
      ((Element)v.get(236)).setAttribute("repeat","" );
      ((Element)v.get(236)).setAttribute("padding","" );
      ((Element)v.get(236)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(236)).setAttribute("contravsb","" );
      ((Element)v.get(236)).setAttribute("zindex","" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(237)).setAttribute("nombre","rbDefinirCliente" );
      ((Element)v.get(237)).setAttribute("tipo","H" );
      ((Element)v.get(237)).setAttribute("id","datosCampos" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(238)).setAttribute("valor","S" );
      ((Element)v.get(238)).setAttribute("check","N" );
      ((Element)v.get(238)).setAttribute("onfocus","" );
      ((Element)v.get(238)).setAttribute("id","datosCampos" );
      ((Element)v.get(238)).setAttribute("cod","117" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));

      /* Elemento padre:238 / Elemento actual: 239   */
      v.add(doc.createTextNode("yy"));
      ((Element)v.get(238)).appendChild((Text)v.get(239));

      /* Termina nodo Texto:239   */
      /* Termina nodo:238   */

      /* Empieza nodo:240 / Elemento padre: 237   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(240)).setAttribute("valor","N" );
      ((Element)v.get(240)).setAttribute("check","N" );
      ((Element)v.get(240)).setAttribute("onfocus","" );
      ((Element)v.get(240)).setAttribute("id","datosCampos" );
      ((Element)v.get(240)).setAttribute("cod","87" );
      ((Element)v.get(237)).appendChild((Element)v.get(240));

      /* Elemento padre:240 / Elemento actual: 241   */
      v.add(doc.createTextNode("nn"));
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(240)).appendChild((Text)v.get(241));

      /* Termina nodo Texto:241   */
      /* Termina nodo:240   */
      /* Termina nodo:237   */
      /* Termina nodo:236   */
      /* Termina nodo:235   */

      /* Empieza nodo:242 / Elemento padre: 232   */
      v.add(doc.createElement("td"));
      ((Element)v.get(242)).setAttribute("width","100%" );
      ((Element)v.get(232)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(243)).setAttribute("src","b.gif" );
      ((Element)v.get(243)).setAttribute("width","8" );
      ((Element)v.get(243)).setAttribute("height","8" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:242   */
      /* Termina nodo:232   */

      /* Empieza nodo:244 / Elemento padre: 221   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(221)).appendChild((Element)v.get(244));

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
      /* Termina nodo:221   */
      /* Termina nodo:220   */
      /* Termina nodo:219   */
      /* Termina nodo:218   */
      /* Termina nodo:215   */
      /* Termina nodo:214   */

      /* Empieza nodo:247 / Elemento padre: 211   */
      v.add(doc.createElement("td"));
      ((Element)v.get(211)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(248)).setAttribute("src","b.gif" );
      ((Element)v.get(248)).setAttribute("width","8" );
      ((Element)v.get(248)).setAttribute("height","12" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */
      /* Termina nodo:247   */
      /* Termina nodo:211   */

      /* Empieza nodo:249 / Elemento padre: 203   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(203)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("td"));
      ((Element)v.get(249)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(251)).setAttribute("src","b.gif" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:250   */

      /* Empieza nodo:252 / Elemento padre: 249   */
      v.add(doc.createElement("td"));
      ((Element)v.get(249)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(252)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("table"));
      ((Element)v.get(254)).setAttribute("width","100%" );
      ((Element)v.get(254)).setAttribute("border","0" );
      ((Element)v.get(254)).setAttribute("align","center" );
      ((Element)v.get(254)).setAttribute("cellspacing","0" );
      ((Element)v.get(254)).setAttribute("cellpadding","0" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(254)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("td"));
      ((Element)v.get(256)).setAttribute("class","botonera" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(257)).setAttribute("nombre","btnSiguiente" );
      ((Element)v.get(257)).setAttribute("ID","botonContenido" );
      ((Element)v.get(257)).setAttribute("tipo","html" );
      ((Element)v.get(257)).setAttribute("accion","accionSiguiente();" );
      ((Element)v.get(257)).setAttribute("estado","false" );
      ((Element)v.get(257)).setAttribute("cod","446" );
      ((Element)v.get(257)).setAttribute("ontab","onTabSiguiente();" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */
      /* Termina nodo:256   */
      /* Termina nodo:255   */
      /* Termina nodo:254   */
      /* Termina nodo:253   */
      /* Termina nodo:252   */

      /* Empieza nodo:258 / Elemento padre: 249   */
      v.add(doc.createElement("td"));
      ((Element)v.get(249)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(259)).setAttribute("src","b.gif" );
      ((Element)v.get(259)).setAttribute("width","8" );
      ((Element)v.get(259)).setAttribute("height","12" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */
      /* Termina nodo:258   */
      /* Termina nodo:249   */

      /* Empieza nodo:260 / Elemento padre: 203   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(203)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("td"));
      ((Element)v.get(261)).setAttribute("width","12" );
      ((Element)v.get(261)).setAttribute("align","center" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(262)).setAttribute("src","b.gif" );
      ((Element)v.get(262)).setAttribute("width","12" );
      ((Element)v.get(262)).setAttribute("height","12" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */
      /* Termina nodo:261   */

      /* Empieza nodo:263 / Elemento padre: 260   */
      v.add(doc.createElement("td"));
      ((Element)v.get(263)).setAttribute("width","750" );
      ((Element)v.get(260)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(264)).setAttribute("src","b.gif" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */
      /* Termina nodo:263   */

      /* Empieza nodo:265 / Elemento padre: 260   */
      v.add(doc.createElement("td"));
      ((Element)v.get(265)).setAttribute("width","12" );
      ((Element)v.get(260)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(266)).setAttribute("src","b.gif" );
      ((Element)v.get(266)).setAttribute("width","12" );
      ((Element)v.get(266)).setAttribute("height","12" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */
      /* Termina nodo:265   */
      /* Termina nodo:260   */
      /* Termina nodo:203   */
      /* Termina nodo:202   */
      /* Termina nodo:10   */


   }

}
