
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_general_concursos_consultar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_general_concursos_consultar" );
      ((Element)v.get(0)).setAttribute("cod","0945" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
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
      v.add(doc.createTextNode("    \r  \r\r         var invocado = \"\";\r         \r         function onLoadPag() {        \r                  configurarMenuSecundario(\"formulario\");\r                  ocultarLista();\r\r				  				  if(get(\"formulario.txtCodCliente\")!=\"\") {\r\r				    invocado = \"Call Center\";\r\r					onChangectCodigoCliente();\r				  }\r\r                  focoCodigoCliente();\r    }\r\r         function fLimpiar() {\r                  set(\"formulario.varOidCliente\", \"\");      \r                  set(\"formulario.oidConcurso\", \"\");   \r                  onLoadPag();\r         }\r\r         function focoCodigoCliente() {\r                  focaliza(\"formulario.txtCodCliente\");\r         }\r\r         function ocultarLista() {\r                  DrdEnsanchaConMargenDcho('listado1',12);      \r                  document.all[\"Cplistado1\"].style.visibility='hidden'; \r                  document.all[\"CpLin1listado1\"].style.visibility='hidden';  \r                  document.all[\"CpLin2listado1\"].style.visibility='hidden'; \r                  document.all[\"CpLin3listado1\"].style.visibility='hidden';\r                  document.all[\"CpLin4listado1\"].style.visibility='hidden';         		\r                  document.all[\"primera1Div\"].style.visibility='hidden'; \r                  document.all[\"ret1Div\"].style.visibility='hidden';\r                  document.all[\"ava1Div\"].style.visibility='hidden';  \r                  document.all[\"separaDiv\"].style.visibility='hidden';            \r                  document.getElementById(\"Detalle\").style.visibility = \"hidden\";\r                  document.getElementById(\"PremiosProcesados\").style.visibility = \"hidden\";\r                  document.getElementById(\"Recomendacion\").style.visibility = \"hidden\";\r                  document.getElementById(\"PremiosSeleccionados\").style.visibility = \"hidden\";\r                  document.getElementById(\"MotivosDescalificacion\").style.visibility = \"hidden\";\r				  document.getElementById(\"PremiosAsociadosNivel\").style.visibility = \"hidden\";\r                  eval (ON_RSZ);             \r         }\r\r         function mostrarListaResultados() {\r                  DrdEnsanchaConMargenDcho('listado1',12);      \r                  document.all[\"Cplistado1\"].style.visibility='visible'; \r                  document.all[\"CpLin1listado1\"].style.visibility='visible';  \r                  document.all[\"CpLin2listado1\"].style.visibility='visible'; \r                  document.all[\"CpLin3listado1\"].style.visibility='visible';\r                  document.all[\"CpLin4listado1\"].style.visibility='visible';         		\r                  document.all[\"primera1Div\"].style.visibility='visible'; \r                  document.all[\"ret1Div\"].style.visibility='visible';\r                  document.all[\"ava1Div\"].style.visibility='visible';  \r                  document.all[\"separaDiv\"].style.visibility='visible';            \r                  document.getElementById(\"Detalle\").style.visibility = \"visible\";\r                  document.getElementById(\"PremiosProcesados\").style.visibility = \"visible\";\r                  document.getElementById(\"Recomendacion\").style.visibility = \"visible\";\r                  document.getElementById(\"PremiosSeleccionados\").style.visibility = \"visible\";\r                  document.getElementById(\"MotivosDescalificacion\").style.visibility = \"visible\";\r				  document.getElementById(\"PremiosAsociadosNivel\").style.visibility = \"visible\";\r                  eval (ON_RSZ);             \r         }\r\r         function onClickboBusquedaCliente() {	\r             var obj = new Object();\r                  var whnd = mostrarModalSICC('LPBusquedaRapidaCliente','',obj);\r  \r                  if(whnd!=null){\r                    var oid = whnd[0];\r                var cod = whnd[1];      \r           	  var nombre1 = whnd[2];\r                var nombre2 = whnd[3];\r                    var apellido1 = whnd[4];\r                var apellido2 = whnd[5];\r\r                    var nombreCompleto = nombre1 + \" \" + nombre2 + \" \" + apellido1 \r                    + \" \" + apellido2\r      \r                    set(\"formulario.txtCodCliente\", cod);\r                    set(\"formulario.varOidCliente\", oid);      \r                    set(\"formulario.laNombreApellido\", nombreCompleto);      		  \r                    txt_to('lbldtNombreApellidos', nombreCompleto);\r					onChangectCodigoCliente();\r                  }\r         }\r\r         function onChangectCodigoCliente() {		\r		  		  ocultarLista();\r                  clienteOnBlur();\r                                                      set(\"formulario.varOidCliente\", \"\");    \r                  txt_to('lbldtNombreApellidos', \"\");\r\r                  if(get(\"formulario.txtCodCliente\")!=\"\") {\r                           eval(\"formulario\").oculto= \"S\";\r                           set(\"formulario.conectorAction\", \"LPConsultaGeneralConcurso\");\r                           set(\"formulario.accion\", \"cargaClienteConcurso\");\r                           set(\"formulario.codigoCliente\", get(\"formulario.txtCodCliente\"));\r                           set(\"formulario.numeroConcurso\", get(\"formulario.txtNumconcurso\"));\r                           enviaSICC('formulario', '', '', 'N');\r                  }		\r         }\r\r         function parseaCombo(str){	\r                  var arr = new Array();	\r                  var arrVacio = new Array();\r                  arrVacio[0] = \"\";\r                  arrVacio[1] = \"\";\r                  arr[0] = arrVacio;\r\r                  var filas = str.split('|');\r\r                  for(var i=0; i<filas.length; i++) {\r                           var campos = filas[i];\r                           var campo = campos.split(\",\");\r                           arrIn = new Array();\r                           arrIn[0] = campo[0];\r                           arrIn[1] = campo[1];                           \r                           arr[i+1] = arrIn;      		\r                  }\r\r                  return arr;\r         }  \r\r         function seteandoOidDefecto(oidDefault) {\r         var oidSeleccionado = new Array();\r         oidSeleccionado = oidDefault.split(\",\");             \r                  set(\"formulario.cbUnidadAdministrativa\", oidSeleccionado);\r         }\r\r		 function finalizaCargaClienteConcurso(oidCliente, codigoCliente, \r             nombresApellidos, oidConcurso, unidades, oidDefault, numeroConcurso) {\r             set_combo(\"formulario.cbUnidadAdministrativa\", parseaCombo(unidades));\r                  if(oidDefault!=\"\") {\r                           seteandoOidDefecto(oidDefault);\r                  }\r                  if(oidCliente!=\"\") {\r                           set(\"formulario.varOidCliente\", oidCliente);      \r                  }\r                  else {\r                           set(\"formulario.varOidCliente\", \"\");      \r                  }\r\r                  if(codigoCliente!=\"\") {\r                           set(\"formulario.txtCodCliente\", codigoCliente);\r                  }\r                  else {\r                           set(\"formulario.txtCodCliente\", \"\");\r                  }\r                  if(nombresApellidos!=\"\") {\r                           set(\"formulario.laNombreApellido\", nombresApellidos);      		  \r                           set(\"formulario.tempNombreApellido\", nombresApellidos);      		  \r                  }\r                  else {\r                           set(\"formulario.laNombreApellido\", \"\");      		  \r                           set(\"formulario.tempNombreApellido\", \"\");      		  \r                  }\r                  if(nombresApellidos!=\"\") {\r                           txt_to('lbldtNombreApellidos', nombresApellidos);\r                  }\r                  else {\r                           txt_to('lbldtNombreApellidos', nombresApellidos);\r                  }\r                  if(oidConcurso!=\"\") {\r                           set(\"formulario.oidConcurso\", oidConcurso);      	\r                  }\r                  else {\r                           set(\"formulario.oidConcurso\", \"\");      	\r                  }\r                  \r                  if(numeroConcurso!=\"\") {\r                           set(\"formulario.txtNumconcurso\", numeroConcurso);      	\r                  }\r                  else { \r                           set(\"formulario.txtNumconcurso\", \"\");      	\r                  }\r                  eval(\"formulario\").oculto= \"N\";\r                  focaliza(\"formulario.cbUnidadAdministrativa\");	\r				  \r				  				  if(invocado == \"Call Center\"){\r					 onClickboBuscar();\r				  }\r         }\r\r         function errorFinalizaCargaClienteConcurso() {\r                  eval(\"formulario\").oculto= \"N\";\r\r                  var arr = new Array();	\r                  var arrVacio = new Array();\r                  arrVacio[0] = \"\";\r                  arrVacio[1] = \"\";\r                  arr[0] = arrVacio;\r\r                  set_combo(\"formulario.cbUnidadAdministrativa\", arr);\r                  set(\"formulario.txtCodCliente\", \"\");		\r                  focoCodigoCliente();		\r         }\r\r         function errorAsignarOidsOcultos() {\r                  eval(\"formulario\").oculto= \"N\";\r\r                  set(\"formulario.oidSeccion\", \"\");\r                  set(\"formulario.oidZona\", \"\");\r                  set(\"formulario.oidRegion\", \"\");\r         }\r\r         function asignarOidsOcultos(oidSeccion, oidZona, oidRegion) {\r                  eval(\"formulario\").oculto= \"N\";\r\r                  set(\"formulario.oidSeccion\", oidSeccion);\r                  set(\"formulario.oidZona\", oidZona);\r                  set(\"formulario.oidRegion\", oidRegion);\r\r                  var arr = new Array();\r                  arr[arr.length] = \r                  new Array(\"oidCliente\", get(\"formulario.varOidCliente\")+\"\");\r\r                  arr[arr.length] = \r                  new Array(\"oidConcurso\", get(\"formulario.oidConcurso\")+\"\"); \r\r                  arr[arr.length] = \r                  new Array(\"numeroConcurso\", get(\"formulario.txtNumconcurso\")+\"\");\r\r                  arr[arr.length] = \r				  new Array(\"oidRegion\", get(\"formulario.oidRegion\")+\"\"); \r\r				  arr[arr.length] = \r				  new Array(\"oidZona\", get(\"formulario.oidZona\")+\"\");\r\r				  arr[arr.length] = \r				  new Array(\"oidSeccion\", get(\"formulario.oidSeccion\")+\"\"); \r\r				  				  arr[arr.length] = \r				  new Array(\"oidTipoConcurso\", get(\"formulario.cbTipoConcurso\")+\"\"); \r\r				  arr[arr.length] = \r				  new Array(\"oidEstadoConcurso\", get(\"formulario.cbEstadoConcurso\")+\"\"); \r           \r                  configurarPaginado(mipgndo,\"INCBuscaConcursosConsultaIntegral\", \r                  \"ConectorBuscaConcursosConsultaIntegral\",\r                  \"es.indra.sicc.dtos.inc.DTOCabeceraConsultaIntegral\",arr);		\r         }\r\r         function onClickboBuscar() {\r                  if(!sicc_validaciones_generales('grupoCodigoCliente')) {\r                           return;\r                  }\r\r                  if(get(\"formulario.cbUnidadAdministrativa\")!=\"\") {\r                           eval(\"formulario\").oculto= \"S\";\r                           set(\"formulario.conectorAction\", \"LPConsultaGeneralConcurso\");\r                           set(\"formulario.accion\", \"recuperarValoresUA\");\r                           set(\"formulario.oidUA\", get(\"formulario.cbUnidadAdministrativa\"));\r                           enviaSICC('formulario', '', '', 'N');\r                  }\r                  else {\r                           var arr = new Array();\r                           arr[arr.length] = \r                           new Array(\"oidCliente\", get(\"formulario.varOidCliente\")+\"\");\r\r                           arr[arr.length] = \r                           new Array(\"oidConcurso\", get(\"formulario.oidConcurso\")+\"\"); \r\r                           arr[arr.length] = \r                           new Array(\"numeroConcurso\", get(\"formulario.txtNumconcurso\")+\"\");\r\r                           arr[arr.length] = \r                           new Array(\"oidRegion\", get(\"formulario.oidRegion\")+\"\"); \r\r                           arr[arr.length] = \r                           new Array(\"oidZona\", get(\"formulario.oidZona\")+\"\");\r\r                           arr[arr.length] = \r                           new Array(\"oidSeccion\", get(\"formulario.oidSeccion\")+\"\"); \r							\r						   						   arr[arr.length] = \r                           new Array(\"oidTipoConcurso\", get(\"formulario.cbTipoConcurso\")+\"\"); \r\r						   arr[arr.length] = \r                           new Array(\"oidEstadoConcurso\", get(\"formulario.cbEstadoConcurso\")+\"\"); \r                    \r                           configurarPaginado(mipgndo,\"INCBuscaConcursosConsultaIntegral\", \r                           \"ConectorBuscaConcursosConsultaIntegral\",\r                           \"es.indra.sicc.dtos.inc.DTOCabeceraConsultaIntegral\",arr);		\r                  }		\r         }\r\r         function obtenerPosicionListaEditable(clave, lista){\r                  this.posicion = 0;\r                  if (lista.codSeleccionados().length > 0){\r                           for(var k=0;k<lista.datos.length;k++) {\r                                    if (lista.datos[k][0] == clave) {\r                                             posicion=k;\r                                             break;\r                                    }\r                           }        \r                           return posicion;\r                  }\r   }\r\r         function obtenerValoresRegistro() {\r                  var obj = new Object();\r\r                  listado1.actualizaDat();\r                  datos = listado1.datos;\r\r                                                      var filaMarcada = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);\r\r                                    var oidConcurso = datos[filaMarcada][1]; \r\r                                    var numeroConcurso = datos[filaMarcada][2]; \r\r                                    var nombreConcurso = datos[filaMarcada][3]; \r\r                                    var oidPeriodoInicial = datos[filaMarcada][4]; \r\r                                    var periodoInicial = datos[filaMarcada][5]; \r\r                                    var oidPeriodoFinal = datos[filaMarcada][6]; \r\r                                    var periodoFinal = datos[filaMarcada][7]; \r\r                                    var faseCalificacion = datos[filaMarcada][9]; \r\r                                    var oidBaseCalculo = datos[filaMarcada][10]; \r\r                                    var multinivel = datos[filaMarcada][11]; 		\r\r                                    var oidPlantilla = datos[filaMarcada][13]; 		\r                  \r                  obj.oidConcurso = oidConcurso;\r                  obj.numeroConcurso = numeroConcurso;\r                  obj.nombreConcurso = nombreConcurso;\r                  obj.oidPeriodoInicial = oidPeriodoInicial;\r                  obj.periodoInicial = periodoInicial;\r                  obj.oidPeriodoFinal = oidPeriodoFinal;\r                  obj.periodoFinal = periodoFinal;\r                  obj.faseCalificacion = faseCalificacion;\r                  obj.oidBaseCalculo = oidBaseCalculo;\r                  obj.multinivel = multinivel;\r                  obj.oidPlantilla = oidPlantilla;\r\r                  return obj;\r         }\r\r         function onClickboDetalle() {\r                  if (listado1.numSelecc()!=1) {\r                           GestionarMensaje('INC037',null,null,null);\r                      return false;		\r             }	\r\r                  var obj = obtenerValoresRegistro();\r                  obj.varBotonPresionado = \"detalle\";\r                  var retorno = mostrarModalSICC('LPConsultaGeneralConcurso', \r                  'direccionaPeticionDetalle', obj);\r         }\r\r         function obtenerValoresCriteriosBusqueda() {\r                  var obj = new Object();\r\r                  var busquedaCodClien = get(\"formulario.txtCodCliente\");\r                  var busquedaOidClien = get(\"formulario.varOidCliente\");\r                  var busquedaNomApe = get(\"formulario.tempNombreApellido\");\r                  var busquedaNumConcu = get(\"formulario.txtNumconcurso\");\r                  \r                  obj.busquedaCodClien = busquedaCodClien;\r                  obj.busquedaOidClien = busquedaOidClien;\r                  obj.busquedaNomApe = busquedaNomApe;\r                  obj.busquedaNumConcu = busquedaNumConcu;\r\r                  return obj; \r         }\r\r         function onClickboPremiosProcesados() {		\r                  var obj = obtenerValoresCriteriosBusqueda();\r                  obj.varBotonPresionado = \"premiosProcesados\";\r                  var retorno = mostrarModalSICC('LPConsultaGeneralConcurso', \r                  'direccionaPeticionDetalle', obj);\r         }\r		\r		 		 function onClickboPremiosAsociadosNivel() {\r			if (listado1.numSelecc() >= 1){\r			  if (listado1.numSelecc() == 1){   \r\r				  var obj = new Object();\r\r                  listado1.actualizaDat();\r                  datos = listado1.datos;\r\r                                                      var filaMarcada = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);\r\r                                    var oidConcurso = datos[filaMarcada][1]; \r				  var busquedaCodClien = get(\"formulario.txtCodCliente\");\r                  var busquedaOidClien = get(\"formulario.varOidCliente\");\r                  var busquedaNomApe = get(\"formulario.tempNombreApellido\");\r                  var busquedaNumConcu = get(\"formulario.txtNumconcurso\");\r                  \r                  obj.busquedaCodClien = busquedaCodClien;\r                  obj.busquedaOidClien = busquedaOidClien;\r                  obj.busquedaNomApe = busquedaNomApe;\r                  obj.busquedaNumConcu = busquedaNumConcu;\r				  obj.oidConcurso = oidConcurso;\r\r                  obj.varBotonPresionado = \"premiosAsociadosNivel\";\r                  var retorno = mostrarModalSICC('LPConsultaGeneralConcurso', \r                  'direccionaPeticionDetalle', obj);\r\r			   } else{\r					GestionarMensaje('8',null,null,null);\r			   }\r			} else{\r				   GestionarMensaje('4',null,null,null);                        \r			} \r\r         }\r\r         function onClickboRecomendacion() {		\r                  var obj = obtenerValoresCriteriosBusqueda();\r                  obj.varBotonPresionado = \"recomendacion\";\r                  var retorno = mostrarModalSICC('LPConsultaGeneralConcurso', \r                  'direccionaPeticionDetalle', obj);\r         }\r\r         function onClickboPremiosSeleccionados() {\r                  var obj = obtenerValoresCriteriosBusqueda();\r                  obj.varBotonPresionado = \"premiosSeleccionados\";\r                  var retorno = mostrarModalSICC('LPConsultaGeneralConcurso', \r                  'direccionaPeticionDetalle', obj);\r         }\r\r         function onClickboMotivosDescalificacion() {\r                  var obj = obtenerValoresCriteriosBusqueda();\r                  obj.varBotonPresionado = \"motivosDescalificacion\";\r                  var retorno = mostrarModalSICC('LPConsultaGeneralConcurso', \r                  'direccionaPeticionDetalle', obj);\r         }\r\r         function ontabBotonBuscar() {\r                  if(document.getElementById(\"Detalle\").style.visibility == \"hidden\") {\r                           focoCodigoCliente();\r                  }\r                  else {\r                           focalizaBotonHTML('botonContenido','Detalle');\r                  }\r         }\r\r         function onshtabCodigoCliente() {\r                  if(document.getElementById(\"Detalle\").style.visibility == \"hidden\") {\r                           focoBotonBuscar();\r                  }\r                  else {\r                           focalizaBotonHTML('botonContenido','PremiosAsociadosNivel');\r                  }\r         }\r\r         function ontabBotonMotivos() {\r                  focoCodigoCliente();\r         }\r\r         function onshtabBotonDetalle() {\r                  focoBotonBuscar();\r         }\r\r         function focoBotonBuscar() {\r                  focalizaBotonHTML('botonContenido','btnBuscar');\r         }\r\r         function muestraLista(ultima, rowset, error){\r                  var tamano = rowset.length;\r         \r                  if (tamano > 0) {\r                           mostrarListaResultados();\r                      eval (ON_RSZ);\r                           focoBotonBuscar();\r                           return true;\r                  }\r                  else {\r                           ocultarLista();\r                           eval (ON_RSZ);\r                           focoBotonBuscar();\r                      return false;\r                  }\r\r                  return true;\r         }\r\r         function clienteOnBlur() {\r                  var longiCod = get('formulario.hLongCliente');\r                  var elTexto  = get('formulario.txtCodCliente');\r\r                  if(elTexto.length!=0){\r                           var faltantes = longiCod -  elTexto.length;\r                           var resultCod = new String(\"\");\r                           \r                           if(faltantes > 0){\r                                    for(var t = 0 ; t<faltantes; t++){\r                                             resultCod = resultCod + \"0\";\r                                    }\r                           }\r                           \r                           resultCod = resultCod + elTexto;\r                           set('formulario.txtCodCliente', resultCod);\r            }\r         } \r\r     \r"));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","txtCodCliente" );
      ((Element)v.get(7)).setAttribute("group","grupoCodigoCliente" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","263" );
      ((Element)v.get(7)).setAttribute("format","t" );
      ((Element)v.get(7)).setAttribute("min","0" );
      ((Element)v.get(7)).setAttribute("max","15" );
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
      ((Element)v.get(11)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","oidPais" );
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
      ((Element)v.get(15)).setAttribute("nombre","codigoCliente" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","varOidCliente" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","laNombreApellido" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","tempNombreApellido" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","numeroConcurso" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","oidConcurso" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","nombreConcurso" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).setAttribute("nombre","oidPeriodoInicial" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","periodoInicial" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","oidPeriodoFinal" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","periodoFinal" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","faseCalificacion" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","oidBaseCalculo" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","multinivel" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","busquedaCodClien" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","busquedaOidClien" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","busquedaNomApe" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","busquedaNumConcu" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","oidPlantilla" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","hLongCliente" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","oidRegion" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","oidZona" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","oidSeccion" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","oidUA" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 8   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(39)).setAttribute("nombre","capa1" );
      ((Element)v.get(8)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("table"));
      ((Element)v.get(40)).setAttribute("width","100%" );
      ((Element)v.get(40)).setAttribute("border","0" );
      ((Element)v.get(40)).setAttribute("cellspacing","0" );
      ((Element)v.get(40)).setAttribute("cellpadding","0" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).setAttribute("width","12" );
      ((Element)v.get(42)).setAttribute("align","center" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(43)).setAttribute("src","b.gif" );
      ((Element)v.get(43)).setAttribute("width","12" );
      ((Element)v.get(43)).setAttribute("height","12" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:44 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).setAttribute("width","750" );
      ((Element)v.get(41)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(45)).setAttribute("src","b.gif" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:46 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).setAttribute("width","12" );
      ((Element)v.get(41)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(47)).setAttribute("src","b.gif" );
      ((Element)v.get(47)).setAttribute("width","12" );
      ((Element)v.get(47)).setAttribute("height","1" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */
      /* Termina nodo:41   */

      /* Empieza nodo:48 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(50)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:51 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(53)).setAttribute("class","legend" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(54)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(54)).setAttribute("alto","13" );
      ((Element)v.get(54)).setAttribute("filas","1" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(54)).setAttribute("id","legend" );
      ((Element)v.get(54)).setAttribute("cod","0075" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:55 / Elemento padre: 52   */
      v.add(doc.createElement("table"));
      ((Element)v.get(55)).setAttribute("width","100%" );
      ((Element)v.get(55)).setAttribute("border","0" );
      ((Element)v.get(55)).setAttribute("align","center" );
      ((Element)v.get(55)).setAttribute("cellspacing","0" );
      ((Element)v.get(55)).setAttribute("cellpadding","0" );
      ((Element)v.get(52)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("table"));
      ((Element)v.get(58)).setAttribute("width","575" );
      ((Element)v.get(58)).setAttribute("border","0" );
      ((Element)v.get(58)).setAttribute("align","left" );
      ((Element)v.get(58)).setAttribute("cellspacing","0" );
      ((Element)v.get(58)).setAttribute("cellpadding","0" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).setAttribute("colspan","3" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(61)).setAttribute("src","b.gif" );
      ((Element)v.get(61)).setAttribute("width","8" );
      ((Element)v.get(61)).setAttribute("height","8" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:62 / Elemento padre: 58   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(58)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(64)).setAttribute("src","b.gif" );
      ((Element)v.get(64)).setAttribute("width","8" );
      ((Element)v.get(64)).setAttribute("height","8" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(66)).setAttribute("nombre","lblCodCliente" );
      ((Element)v.get(66)).setAttribute("alto","13" );
      ((Element)v.get(66)).setAttribute("filas","1" );
      ((Element)v.get(66)).setAttribute("valor","" );
      ((Element)v.get(66)).setAttribute("id","datosTitle" );
      ((Element)v.get(66)).setAttribute("cod","263" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:67 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(68)).setAttribute("width","25" );
      ((Element)v.get(68)).setAttribute("height","8" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:69 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(70)).setAttribute("nombre","lblNombreApellidos" );
      ((Element)v.get(70)).setAttribute("alto","13" );
      ((Element)v.get(70)).setAttribute("filas","1" );
      ((Element)v.get(70)).setAttribute("valor","" );
      ((Element)v.get(70)).setAttribute("id","datosTitle" );
      ((Element)v.get(70)).setAttribute("cod","943" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:71 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).setAttribute("width","100%" );
      ((Element)v.get(62)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(72)).setAttribute("width","8" );
      ((Element)v.get(72)).setAttribute("height","8" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:62   */

      /* Empieza nodo:73 / Elemento padre: 58   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(58)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(75)).setAttribute("width","8" );
      ((Element)v.get(75)).setAttribute("height","8" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(73)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(77)).setAttribute("nombre","txtCodCliente" );
      ((Element)v.get(77)).setAttribute("id","datosCampos" );
      ((Element)v.get(77)).setAttribute("max","15" );
      ((Element)v.get(77)).setAttribute("tipo","" );
      ((Element)v.get(77)).setAttribute("req","S" );
      ((Element)v.get(77)).setAttribute("size","22" );
      ((Element)v.get(77)).setAttribute("valor","" );
      ((Element)v.get(77)).setAttribute("validacion","" );
      ((Element)v.get(77)).setAttribute("onshtab","onshtabCodigoCliente();" );
      ((Element)v.get(77)).setAttribute("onchange","onChangectCodigoCliente();" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","iconBuscar.gif" );
      ((Element)v.get(79)).setAttribute("onclick","onClickboBusquedaCliente();" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:80 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(81)).setAttribute("nombre","lbldtNombreApellidos" );
      ((Element)v.get(81)).setAttribute("alto","13" );
      ((Element)v.get(81)).setAttribute("filas","1" );
      ((Element)v.get(81)).setAttribute("valor","" );
      ((Element)v.get(81)).setAttribute("id","datosCampos" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:82 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).setAttribute("width","100%" );
      ((Element)v.get(73)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(83)).setAttribute("src","b.gif" );
      ((Element)v.get(83)).setAttribute("width","8" );
      ((Element)v.get(83)).setAttribute("height","8" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */
      /* Termina nodo:73   */

      /* Empieza nodo:84 / Elemento padre: 58   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(58)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).setAttribute("colspan","3" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).setAttribute("width","8" );
      ((Element)v.get(86)).setAttribute("height","7" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:58   */
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:87 / Elemento padre: 55   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(55)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("table"));
      ((Element)v.get(89)).setAttribute("width","575" );
      ((Element)v.get(89)).setAttribute("border","0" );
      ((Element)v.get(89)).setAttribute("align","left" );
      ((Element)v.get(89)).setAttribute("cellspacing","0" );
      ((Element)v.get(89)).setAttribute("cellpadding","0" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(92)).setAttribute("width","8" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(92)).setAttribute("height","8" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:93 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(94)).setAttribute("nombre","lblUnidadAdministrativa" );
      ((Element)v.get(94)).setAttribute("alto","13" );
      ((Element)v.get(94)).setAttribute("filas","1" );
      ((Element)v.get(94)).setAttribute("valor","" );
      ((Element)v.get(94)).setAttribute("id","datosTitle" );
      ((Element)v.get(94)).setAttribute("cod","3070" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:95 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).setAttribute("width","100%" );
      ((Element)v.get(90)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(96)).setAttribute("src","b.gif" );
      ((Element)v.get(96)).setAttribute("width","8" );
      ((Element)v.get(96)).setAttribute("height","8" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:90   */

      /* Empieza nodo:97 / Elemento padre: 89   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(89)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(99)).setAttribute("src","b.gif" );
      ((Element)v.get(99)).setAttribute("width","8" );
      ((Element)v.get(99)).setAttribute("height","8" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:100 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(101)).setAttribute("nombre","cbUnidadAdministrativa" );
      ((Element)v.get(101)).setAttribute("id","datosCampos" );
      ((Element)v.get(101)).setAttribute("size","1" );
      ((Element)v.get(101)).setAttribute("onchange","" );
      ((Element)v.get(101)).setAttribute("multiple","N" );
      ((Element)v.get(101)).setAttribute("req","N" );
      ((Element)v.get(101)).setAttribute("valorinicial","" );
      ((Element)v.get(101)).setAttribute("textoinicial","" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:103 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).setAttribute("width","100%" );
      ((Element)v.get(97)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(104)).setAttribute("width","8" );
      ((Element)v.get(104)).setAttribute("height","8" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */
      /* Termina nodo:97   */

      /* Empieza nodo:105 / Elemento padre: 89   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(89)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).setAttribute("colspan","3" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(107)).setAttribute("src","b.gif" );
      ((Element)v.get(107)).setAttribute("width","8" );
      ((Element)v.get(107)).setAttribute("height","8" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:108 / Elemento padre: 55   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(55)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("table"));
      ((Element)v.get(110)).setAttribute("width","575" );
      ((Element)v.get(110)).setAttribute("border","0" );
      ((Element)v.get(110)).setAttribute("align","left" );
      ((Element)v.get(110)).setAttribute("cellspacing","0" );
      ((Element)v.get(110)).setAttribute("cellpadding","0" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(113)).setAttribute("src","b.gif" );
      ((Element)v.get(113)).setAttribute("width","8" );
      ((Element)v.get(113)).setAttribute("height","8" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:114 / Elemento padre: 111   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(115)).setAttribute("nombre","lblNumConcurso" );
      ((Element)v.get(115)).setAttribute("alto","13" );
      ((Element)v.get(115)).setAttribute("filas","1" );
      ((Element)v.get(115)).setAttribute("valor","" );
      ((Element)v.get(115)).setAttribute("id","datosTitle" );
      ((Element)v.get(115)).setAttribute("cod","1604" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:116 / Elemento padre: 111   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(117)).setAttribute("src","b.gif" );
      ((Element)v.get(117)).setAttribute("width","8" );
      ((Element)v.get(117)).setAttribute("height","8" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 111   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(119)).setAttribute("nombre","lblTipoConcurso" );
      ((Element)v.get(119)).setAttribute("alto","13" );
      ((Element)v.get(119)).setAttribute("filas","1" );
      ((Element)v.get(119)).setAttribute("valor","" );
      ((Element)v.get(119)).setAttribute("id","datosTitle" );
      ((Element)v.get(119)).setAttribute("cod","2417" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:120 / Elemento padre: 111   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(121)).setAttribute("width","8" );
      ((Element)v.get(121)).setAttribute("height","8" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:122 / Elemento padre: 111   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(123)).setAttribute("nombre","lblEstadoConcurso" );
      ((Element)v.get(123)).setAttribute("alto","13" );
      ((Element)v.get(123)).setAttribute("filas","1" );
      ((Element)v.get(123)).setAttribute("valor","" );
      ((Element)v.get(123)).setAttribute("id","datosTitle" );
      ((Element)v.get(123)).setAttribute("cod","1641" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:124 / Elemento padre: 111   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).setAttribute("width","100%" );
      ((Element)v.get(111)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(125)).setAttribute("src","b.gif" );
      ((Element)v.get(125)).setAttribute("width","8" );
      ((Element)v.get(125)).setAttribute("height","8" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:111   */

      /* Empieza nodo:126 / Elemento padre: 110   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(110)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(128)).setAttribute("src","b.gif" );
      ((Element)v.get(128)).setAttribute("width","8" );
      ((Element)v.get(128)).setAttribute("height","8" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:129 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(130)).setAttribute("nombre","txtNumconcurso" );
      ((Element)v.get(130)).setAttribute("id","datosCampos" );
      ((Element)v.get(130)).setAttribute("max","6" );
      ((Element)v.get(130)).setAttribute("tipo","" );
      ((Element)v.get(130)).setAttribute("onchange","" );
      ((Element)v.get(130)).setAttribute("req","N" );
      ((Element)v.get(130)).setAttribute("size","6" );
      ((Element)v.get(130)).setAttribute("valor","" );
      ((Element)v.get(130)).setAttribute("validacion","" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:131 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(132)).setAttribute("src","b.gif" );
      ((Element)v.get(132)).setAttribute("width","8" );
      ((Element)v.get(132)).setAttribute("height","8" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:133 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(134)).setAttribute("nombre","cbTipoConcurso" );
      ((Element)v.get(134)).setAttribute("id","datosCampos" );
      ((Element)v.get(134)).setAttribute("size","1" );
      ((Element)v.get(134)).setAttribute("onchange","" );
      ((Element)v.get(134)).setAttribute("multiple","N" );
      ((Element)v.get(134)).setAttribute("req","N" );
      ((Element)v.get(134)).setAttribute("valorinicial","" );
      ((Element)v.get(134)).setAttribute("textoinicial","" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:136 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(137)).setAttribute("src","b.gif" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(137)).setAttribute("width","8" );
      ((Element)v.get(137)).setAttribute("height","8" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:138 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(139)).setAttribute("nombre","cbEstadoConcurso" );
      ((Element)v.get(139)).setAttribute("id","datosCampos" );
      ((Element)v.get(139)).setAttribute("size","1" );
      ((Element)v.get(139)).setAttribute("onchange","" );
      ((Element)v.get(139)).setAttribute("multiple","N" );
      ((Element)v.get(139)).setAttribute("req","N" );
      ((Element)v.get(139)).setAttribute("valorinicial","" );
      ((Element)v.get(139)).setAttribute("textoinicial","" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */
      /* Termina nodo:138   */

      /* Empieza nodo:141 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(141)).setAttribute("width","100%" );
      ((Element)v.get(126)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(142)).setAttribute("src","b.gif" );
      ((Element)v.get(142)).setAttribute("width","8" );
      ((Element)v.get(142)).setAttribute("height","8" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:126   */

      /* Empieza nodo:143 / Elemento padre: 110   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(110)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("td"));
      ((Element)v.get(144)).setAttribute("colspan","3" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(145)).setAttribute("src","b.gif" );
      ((Element)v.get(145)).setAttribute("width","8" );
      ((Element)v.get(145)).setAttribute("height","8" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:110   */
      /* Termina nodo:109   */
      /* Termina nodo:108   */
      /* Termina nodo:55   */
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:146 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(147)).setAttribute("src","b.gif" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */
      /* Termina nodo:48   */

      /* Empieza nodo:148 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("td"));
      ((Element)v.get(148)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(150)).setAttribute("src","b.gif" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */

      /* Empieza nodo:151 / Elemento padre: 148   */
      v.add(doc.createElement("td"));
      ((Element)v.get(148)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("table"));
      ((Element)v.get(153)).setAttribute("width","100%" );
      ((Element)v.get(153)).setAttribute("border","0" );
      ((Element)v.get(153)).setAttribute("align","center" );
      ((Element)v.get(153)).setAttribute("cellspacing","0" );
      ((Element)v.get(153)).setAttribute("cellpadding","0" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(155)).setAttribute("class","botonera" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(156)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(156)).setAttribute("ID","botonContenido" );
      ((Element)v.get(156)).setAttribute("tipo","html" );
      ((Element)v.get(156)).setAttribute("accion","onClickboBuscar();" );
      ((Element)v.get(156)).setAttribute("estado","false" );
      ((Element)v.get(156)).setAttribute("cod","1" );
      ((Element)v.get(156)).setAttribute("ontab","ontabBotonBuscar();" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */
      /* Termina nodo:154   */
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:157 / Elemento padre: 148   */
      v.add(doc.createElement("td"));
      ((Element)v.get(148)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(158)).setAttribute("src","b.gif" );
      ((Element)v.get(158)).setAttribute("width","8" );
      ((Element)v.get(158)).setAttribute("height","12" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */
      /* Termina nodo:148   */

      /* Empieza nodo:159 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).setAttribute("width","12" );
      ((Element)v.get(160)).setAttribute("align","center" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(161)).setAttribute("src","b.gif" );
      ((Element)v.get(161)).setAttribute("width","12" );
      ((Element)v.get(161)).setAttribute("height","12" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:162 / Elemento padre: 159   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).setAttribute("width","756" );
      ((Element)v.get(159)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(163)).setAttribute("src","b.gif" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */

      /* Empieza nodo:164 / Elemento padre: 159   */
      v.add(doc.createElement("td"));
      ((Element)v.get(164)).setAttribute("width","12" );
      ((Element)v.get(159)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(165)).setAttribute("src","b.gif" );
      ((Element)v.get(165)).setAttribute("width","12" );
      ((Element)v.get(165)).setAttribute("height","1" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */
      /* Termina nodo:159   */
      /* Termina nodo:40   */
      /* Termina nodo:39   */

      /* Empieza nodo:166 / Elemento padre: 8   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(166)).setAttribute("nombre","listado1" );
      ((Element)v.get(166)).setAttribute("ancho","808" );
      ((Element)v.get(166)).setAttribute("alto","317" );
      ((Element)v.get(166)).setAttribute("x","12" );
      ((Element)v.get(166)).setAttribute("y","202" );
      ((Element)v.get(166)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(166)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(8)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(167)).setAttribute("precarga","S" );
      ((Element)v.get(167)).setAttribute("conROver","S" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(168)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(168)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(168)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(168)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */

      /* Empieza nodo:169 / Elemento padre: 167   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(169)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(169)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(169)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(169)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(167)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */

      /* Empieza nodo:170 / Elemento padre: 167   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(170)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(170)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(167)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:167   */

      /* Empieza nodo:171 / Elemento padre: 166   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(166)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(172)).setAttribute("borde","1" );
      ((Element)v.get(172)).setAttribute("horizDatos","1" );
      ((Element)v.get(172)).setAttribute("horizCabecera","1" );
      ((Element)v.get(172)).setAttribute("vertical","1" );
      ((Element)v.get(172)).setAttribute("horizTitulo","1" );
      ((Element)v.get(172)).setAttribute("horizBase","1" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */

      /* Empieza nodo:173 / Elemento padre: 171   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(173)).setAttribute("borde","#999999" );
      ((Element)v.get(173)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(173)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(173)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(173)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(173)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(173)).setAttribute("horizBase","#999999" );
      ((Element)v.get(171)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:171   */

      /* Empieza nodo:174 / Elemento padre: 166   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(174)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(174)).setAttribute("alto","22" );
      ((Element)v.get(174)).setAttribute("imgFondo","" );
      ((Element)v.get(174)).setAttribute("cod","00135" );
      ((Element)v.get(174)).setAttribute("ID","datosTitle" );
      ((Element)v.get(166)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */

      /* Empieza nodo:175 / Elemento padre: 166   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(175)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(175)).setAttribute("alto","22" );
      ((Element)v.get(175)).setAttribute("imgFondo","" );
      ((Element)v.get(166)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */

      /* Empieza nodo:176 / Elemento padre: 166   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(176)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(176)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(176)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(176)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(176)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(176)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(166)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(177)).setAttribute("ancho","100" );
      ((Element)v.get(177)).setAttribute("minimizable","S" );
      ((Element)v.get(177)).setAttribute("minimizada","N" );
      ((Element)v.get(177)).setAttribute("oculta","S" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */

      /* Empieza nodo:178 / Elemento padre: 176   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(178)).setAttribute("ancho","100" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(178)).setAttribute("minimizable","S" );
      ((Element)v.get(178)).setAttribute("minimizada","N" );
      ((Element)v.get(176)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */

      /* Empieza nodo:179 / Elemento padre: 176   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(179)).setAttribute("ancho","100" );
      ((Element)v.get(179)).setAttribute("minimizable","S" );
      ((Element)v.get(179)).setAttribute("minimizada","N" );
      ((Element)v.get(176)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */

      /* Empieza nodo:180 / Elemento padre: 176   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(180)).setAttribute("ancho","100" );
      ((Element)v.get(180)).setAttribute("minimizable","S" );
      ((Element)v.get(180)).setAttribute("minimizada","N" );
      ((Element)v.get(180)).setAttribute("oculta","S" );
      ((Element)v.get(176)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */

      /* Empieza nodo:181 / Elemento padre: 176   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(181)).setAttribute("ancho","100" );
      ((Element)v.get(181)).setAttribute("minimizable","S" );
      ((Element)v.get(181)).setAttribute("minimizada","N" );
      ((Element)v.get(176)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */

      /* Empieza nodo:182 / Elemento padre: 176   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(182)).setAttribute("ancho","100" );
      ((Element)v.get(182)).setAttribute("minimizable","S" );
      ((Element)v.get(182)).setAttribute("minimizada","N" );
      ((Element)v.get(182)).setAttribute("oculta","S" );
      ((Element)v.get(176)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */

      /* Empieza nodo:183 / Elemento padre: 176   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(183)).setAttribute("ancho","100" );
      ((Element)v.get(183)).setAttribute("minimizable","S" );
      ((Element)v.get(183)).setAttribute("minimizada","N" );
      ((Element)v.get(176)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */

      /* Empieza nodo:184 / Elemento padre: 176   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(184)).setAttribute("ancho","100" );
      ((Element)v.get(184)).setAttribute("minimizable","S" );
      ((Element)v.get(184)).setAttribute("minimizada","N" );
      ((Element)v.get(176)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */

      /* Empieza nodo:185 / Elemento padre: 176   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(185)).setAttribute("ancho","100" );
      ((Element)v.get(185)).setAttribute("minimizable","S" );
      ((Element)v.get(185)).setAttribute("minimizada","N" );
      ((Element)v.get(185)).setAttribute("oculta","S" );
      ((Element)v.get(176)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */

      /* Empieza nodo:186 / Elemento padre: 176   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(186)).setAttribute("ancho","100" );
      ((Element)v.get(186)).setAttribute("minimizable","S" );
      ((Element)v.get(186)).setAttribute("minimizada","N" );
      ((Element)v.get(186)).setAttribute("oculta","S" );
      ((Element)v.get(176)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */

      /* Empieza nodo:187 / Elemento padre: 176   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(187)).setAttribute("ancho","100" );
      ((Element)v.get(187)).setAttribute("minimizable","S" );
      ((Element)v.get(187)).setAttribute("minimizada","N" );
      ((Element)v.get(187)).setAttribute("oculta","S" );
      ((Element)v.get(176)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */

      /* Empieza nodo:188 / Elemento padre: 176   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(188)).setAttribute("ancho","100" );
      ((Element)v.get(188)).setAttribute("minimizable","S" );
      ((Element)v.get(188)).setAttribute("minimizada","N" );
      ((Element)v.get(176)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */

      /* Empieza nodo:189 / Elemento padre: 176   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(189)).setAttribute("ancho","100" );
      ((Element)v.get(189)).setAttribute("minimizable","S" );
      ((Element)v.get(189)).setAttribute("minimizada","N" );
      ((Element)v.get(189)).setAttribute("oculta","S" );
      ((Element)v.get(176)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */

      /* Empieza nodo:190 / Elemento padre: 176   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(190)).setAttribute("ancho","100" );
      ((Element)v.get(190)).setAttribute("minimizable","S" );
      ((Element)v.get(190)).setAttribute("minimizada","N" );
      ((Element)v.get(176)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */

      /* Empieza nodo:191 / Elemento padre: 176   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(191)).setAttribute("ancho","100" );
      ((Element)v.get(191)).setAttribute("minimizable","S" );
      ((Element)v.get(191)).setAttribute("minimizada","N" );
      ((Element)v.get(176)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */

      /* Empieza nodo:192 / Elemento padre: 176   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(192)).setAttribute("ancho","100" );
      ((Element)v.get(192)).setAttribute("minimizable","S" );
      ((Element)v.get(192)).setAttribute("minimizada","N" );
      ((Element)v.get(176)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:176   */

      /* Empieza nodo:193 / Elemento padre: 166   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(193)).setAttribute("alto","30" );
      ((Element)v.get(193)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(193)).setAttribute("imgFondo","" );
      ((Element)v.get(193)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(166)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(194)).setAttribute("colFondo","" );
      ((Element)v.get(194)).setAttribute("ID","EstCab" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */

      /* Empieza nodo:195 / Elemento padre: 193   */
      v.add(doc.createElement("COL"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(195)).setAttribute("colFondo","" );
      ((Element)v.get(195)).setAttribute("ID","EstCab" );
      ((Element)v.get(195)).setAttribute("cod","1604" );
      ((Element)v.get(193)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */

      /* Empieza nodo:196 / Elemento padre: 193   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(196)).setAttribute("colFondo","" );
      ((Element)v.get(196)).setAttribute("ID","EstCab" );
      ((Element)v.get(196)).setAttribute("cod","9" );
      ((Element)v.get(193)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */

      /* Empieza nodo:197 / Elemento padre: 193   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(197)).setAttribute("colFondo","" );
      ((Element)v.get(197)).setAttribute("ID","EstCab" );
      ((Element)v.get(193)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */

      /* Empieza nodo:198 / Elemento padre: 193   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(198)).setAttribute("colFondo","" );
      ((Element)v.get(198)).setAttribute("ID","EstCab" );
      ((Element)v.get(198)).setAttribute("cod","1241" );
      ((Element)v.get(193)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */

      /* Empieza nodo:199 / Elemento padre: 193   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(199)).setAttribute("colFondo","" );
      ((Element)v.get(199)).setAttribute("ID","EstCab" );
      ((Element)v.get(193)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */

      /* Empieza nodo:200 / Elemento padre: 193   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(200)).setAttribute("colFondo","" );
      ((Element)v.get(200)).setAttribute("ID","EstCab" );
      ((Element)v.get(200)).setAttribute("cod","967" );
      ((Element)v.get(193)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */

      /* Empieza nodo:201 / Elemento padre: 193   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(201)).setAttribute("colFondo","" );
      ((Element)v.get(201)).setAttribute("ID","EstCab" );
      ((Element)v.get(201)).setAttribute("cod","6" );
      ((Element)v.get(193)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */

      /* Empieza nodo:202 / Elemento padre: 193   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(202)).setAttribute("colFondo","" );
      ((Element)v.get(202)).setAttribute("ID","EstCab" );
      ((Element)v.get(193)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */

      /* Empieza nodo:203 / Elemento padre: 193   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(203)).setAttribute("colFondo","" );
      ((Element)v.get(203)).setAttribute("ID","EstCab" );
      ((Element)v.get(193)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */

      /* Empieza nodo:204 / Elemento padre: 193   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(204)).setAttribute("colFondo","" );
      ((Element)v.get(204)).setAttribute("ID","EstCab" );
      ((Element)v.get(193)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */

      /* Empieza nodo:205 / Elemento padre: 193   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(205)).setAttribute("colFondo","" );
      ((Element)v.get(205)).setAttribute("ID","EstCab" );
      ((Element)v.get(205)).setAttribute("cod","1641" );
      ((Element)v.get(193)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */

      /* Empieza nodo:206 / Elemento padre: 193   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(206)).setAttribute("colFondo","" );
      ((Element)v.get(206)).setAttribute("ID","EstCab" );
      ((Element)v.get(193)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */

      /* Empieza nodo:207 / Elemento padre: 193   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(207)).setAttribute("colFondo","" );
      ((Element)v.get(207)).setAttribute("ID","EstCab" );
      ((Element)v.get(207)).setAttribute("cod","3370" );
      ((Element)v.get(193)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */

      /* Empieza nodo:208 / Elemento padre: 193   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(208)).setAttribute("colFondo","" );
      ((Element)v.get(208)).setAttribute("ID","EstCab" );
      ((Element)v.get(208)).setAttribute("cod","3371" );
      ((Element)v.get(193)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */

      /* Empieza nodo:209 / Elemento padre: 193   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(209)).setAttribute("colFondo","" );
      ((Element)v.get(209)).setAttribute("ID","EstCab" );
      ((Element)v.get(209)).setAttribute("cod","3372" );
      ((Element)v.get(193)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:193   */

      /* Empieza nodo:210 / Elemento padre: 166   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(210)).setAttribute("alto","22" );
      ((Element)v.get(210)).setAttribute("accion","" );
      ((Element)v.get(210)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(210)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(210)).setAttribute("maxSel","1" );
      ((Element)v.get(210)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(210)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(210)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(210)).setAttribute("onLoad","" );
      ((Element)v.get(210)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(166)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(211)).setAttribute("tipo","texto" );
      ((Element)v.get(211)).setAttribute("ID","EstDat" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */

      /* Empieza nodo:212 / Elemento padre: 210   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(212)).setAttribute("tipo","texto" );
      ((Element)v.get(212)).setAttribute("ID","EstDat" );
      ((Element)v.get(210)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */

      /* Empieza nodo:213 / Elemento padre: 210   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(213)).setAttribute("tipo","texto" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(213)).setAttribute("ID","EstDat2" );
      ((Element)v.get(210)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */

      /* Empieza nodo:214 / Elemento padre: 210   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(214)).setAttribute("tipo","texto" );
      ((Element)v.get(214)).setAttribute("ID","EstDat2" );
      ((Element)v.get(210)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */

      /* Empieza nodo:215 / Elemento padre: 210   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(215)).setAttribute("tipo","texto" );
      ((Element)v.get(215)).setAttribute("ID","EstDat" );
      ((Element)v.get(210)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */

      /* Empieza nodo:216 / Elemento padre: 210   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(216)).setAttribute("tipo","texto" );
      ((Element)v.get(216)).setAttribute("ID","EstDat" );
      ((Element)v.get(210)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */

      /* Empieza nodo:217 / Elemento padre: 210   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(217)).setAttribute("tipo","texto" );
      ((Element)v.get(217)).setAttribute("ID","EstDat2" );
      ((Element)v.get(210)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */

      /* Empieza nodo:218 / Elemento padre: 210   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(218)).setAttribute("tipo","texto" );
      ((Element)v.get(218)).setAttribute("ID","EstDat" );
      ((Element)v.get(210)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */

      /* Empieza nodo:219 / Elemento padre: 210   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(219)).setAttribute("tipo","texto" );
      ((Element)v.get(219)).setAttribute("ID","EstDat2" );
      ((Element)v.get(210)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */

      /* Empieza nodo:220 / Elemento padre: 210   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(220)).setAttribute("tipo","texto" );
      ((Element)v.get(220)).setAttribute("ID","EstDat2" );
      ((Element)v.get(210)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */

      /* Empieza nodo:221 / Elemento padre: 210   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(221)).setAttribute("tipo","texto" );
      ((Element)v.get(221)).setAttribute("ID","EstDat2" );
      ((Element)v.get(210)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */

      /* Empieza nodo:222 / Elemento padre: 210   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(222)).setAttribute("tipo","texto" );
      ((Element)v.get(222)).setAttribute("ID","EstDat2" );
      ((Element)v.get(210)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */

      /* Empieza nodo:223 / Elemento padre: 210   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(223)).setAttribute("tipo","texto" );
      ((Element)v.get(223)).setAttribute("ID","EstDat2" );
      ((Element)v.get(210)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */

      /* Empieza nodo:224 / Elemento padre: 210   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(224)).setAttribute("tipo","texto" );
      ((Element)v.get(224)).setAttribute("ID","EstDat" );
      ((Element)v.get(210)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */

      /* Empieza nodo:225 / Elemento padre: 210   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(225)).setAttribute("tipo","texto" );
      ((Element)v.get(225)).setAttribute("ID","EstDat2" );
      ((Element)v.get(210)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */

      /* Empieza nodo:226 / Elemento padre: 210   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(226)).setAttribute("tipo","texto" );
      ((Element)v.get(226)).setAttribute("ID","EstDat" );
      ((Element)v.get(210)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */
      /* Termina nodo:210   */

      /* Empieza nodo:227 / Elemento padre: 166   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(166)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */

      /* Empieza nodo:228 / Elemento padre: 166   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(228)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(228)).setAttribute("ancho","878" );
      ((Element)v.get(228)).setAttribute("sep","$" );
      ((Element)v.get(228)).setAttribute("x","12" );
      ((Element)v.get(228)).setAttribute("class","botonera" );
      ((Element)v.get(228)).setAttribute("y","496" );
      ((Element)v.get(228)).setAttribute("control","|" );
      ((Element)v.get(228)).setAttribute("conector","" );
      ((Element)v.get(228)).setAttribute("rowset","" );
      ((Element)v.get(228)).setAttribute("cargainicial","N" );
      ((Element)v.get(228)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(166)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(229)).setAttribute("nombre","ret1" );
      ((Element)v.get(229)).setAttribute("x","37" );
      ((Element)v.get(229)).setAttribute("y","500" );
      ((Element)v.get(229)).setAttribute("ID","botonContenido" );
      ((Element)v.get(229)).setAttribute("img","retroceder_on" );
      ((Element)v.get(229)).setAttribute("tipo","0" );
      ((Element)v.get(229)).setAttribute("estado","false" );
      ((Element)v.get(229)).setAttribute("alt","" );
      ((Element)v.get(229)).setAttribute("codigo","" );
      ((Element)v.get(229)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */

      /* Empieza nodo:230 / Elemento padre: 228   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(230)).setAttribute("nombre","ava1" );
      ((Element)v.get(230)).setAttribute("x","52" );
      ((Element)v.get(230)).setAttribute("y","500" );
      ((Element)v.get(230)).setAttribute("ID","botonContenido" );
      ((Element)v.get(230)).setAttribute("img","avanzar_on" );
      ((Element)v.get(230)).setAttribute("tipo","0" );
      ((Element)v.get(230)).setAttribute("estado","false" );
      ((Element)v.get(230)).setAttribute("alt","" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(230)).setAttribute("codigo","" );
      ((Element)v.get(230)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(228)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:228   */
      /* Termina nodo:166   */

      /* Empieza nodo:231 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(231)).setAttribute("nombre","primera1" );
      ((Element)v.get(231)).setAttribute("x","20" );
      ((Element)v.get(231)).setAttribute("y","500" );
      ((Element)v.get(231)).setAttribute("ID","botonContenido" );
      ((Element)v.get(231)).setAttribute("img","primera_on" );
      ((Element)v.get(231)).setAttribute("tipo","0" );
      ((Element)v.get(231)).setAttribute("estado","false" );
      ((Element)v.get(231)).setAttribute("alt","" );
      ((Element)v.get(231)).setAttribute("codigo","" );
      ((Element)v.get(231)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(8)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */

      /* Empieza nodo:232 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(232)).setAttribute("nombre","separa" );
      ((Element)v.get(232)).setAttribute("x","59" );
      ((Element)v.get(232)).setAttribute("y","496" );
      ((Element)v.get(232)).setAttribute("ID","botonContenido" );
      ((Element)v.get(232)).setAttribute("img","separa_base" );
      ((Element)v.get(232)).setAttribute("tipo","0" );
      ((Element)v.get(232)).setAttribute("estado","false" );
      ((Element)v.get(232)).setAttribute("alt","" );
      ((Element)v.get(232)).setAttribute("codigo","" );
      ((Element)v.get(232)).setAttribute("accion","" );
      ((Element)v.get(8)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */

      /* Empieza nodo:233 / Elemento padre: 8   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(233)).setAttribute("nombre","capaCombo" );
      ((Element)v.get(233)).setAttribute("x","77" );
      ((Element)v.get(233)).setAttribute("y","494" );
      ((Element)v.get(8)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("table"));
      ((Element)v.get(233)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(234)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("td"));
      ((Element)v.get(235)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(237)).setAttribute("nombre","Detalle" );
      ((Element)v.get(237)).setAttribute("ID","botonContenido" );
      ((Element)v.get(237)).setAttribute("img","" );
      ((Element)v.get(237)).setAttribute("tipo","html" );
      ((Element)v.get(237)).setAttribute("estado","false" );
      ((Element)v.get(237)).setAttribute("alt","" );
      ((Element)v.get(237)).setAttribute("cod","3" );
      ((Element)v.get(237)).setAttribute("accion","onClickboDetalle();" );
      ((Element)v.get(237)).setAttribute("onshtab","onshtabBotonDetalle();" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */

      /* Empieza nodo:238 / Elemento padre: 236   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(238)).setAttribute("nombre","PremiosProcesados" );
      ((Element)v.get(238)).setAttribute("ID","botonContenido" );
      ((Element)v.get(238)).setAttribute("img","" );
      ((Element)v.get(238)).setAttribute("tipo","html" );
      ((Element)v.get(238)).setAttribute("estado","false" );
      ((Element)v.get(238)).setAttribute("alt","" );
      ((Element)v.get(238)).setAttribute("cod","2871" );
      ((Element)v.get(238)).setAttribute("accion","onClickboPremiosProcesados();" );
      ((Element)v.get(236)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */

      /* Empieza nodo:239 / Elemento padre: 236   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(239)).setAttribute("nombre","Recomendacion" );
      ((Element)v.get(239)).setAttribute("ID","botonContenido" );
      ((Element)v.get(239)).setAttribute("img","" );
      ((Element)v.get(239)).setAttribute("tipo","html" );
      ((Element)v.get(239)).setAttribute("estado","false" );
      ((Element)v.get(239)).setAttribute("alt","" );
      ((Element)v.get(239)).setAttribute("cod","2872" );
      ((Element)v.get(239)).setAttribute("accion","onClickboRecomendacion();" );
      ((Element)v.get(236)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */

      /* Empieza nodo:240 / Elemento padre: 236   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(240)).setAttribute("nombre","PremiosSeleccionados" );
      ((Element)v.get(240)).setAttribute("ID","botonContenido" );
      ((Element)v.get(240)).setAttribute("img","" );
      ((Element)v.get(240)).setAttribute("tipo","html" );
      ((Element)v.get(240)).setAttribute("estado","false" );
      ((Element)v.get(240)).setAttribute("alt","" );
      ((Element)v.get(240)).setAttribute("cod","2873" );
      ((Element)v.get(240)).setAttribute("accion","onClickboPremiosSeleccionados();" );
      ((Element)v.get(236)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */

      /* Empieza nodo:241 / Elemento padre: 236   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(241)).setAttribute("nombre","MotivosDescalificacion" );
      ((Element)v.get(241)).setAttribute("ID","botonContenido" );
      ((Element)v.get(241)).setAttribute("img","" );
      ((Element)v.get(241)).setAttribute("tipo","html" );
      ((Element)v.get(241)).setAttribute("estado","false" );
      ((Element)v.get(241)).setAttribute("alt","" );
      ((Element)v.get(241)).setAttribute("cod","2874" );
      ((Element)v.get(241)).setAttribute("accion","onClickboMotivosDescalificacion();" );
      ((Element)v.get(236)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */

      /* Empieza nodo:242 / Elemento padre: 236   */
      v.add(doc.createElement("BOTON"));
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(242)).setAttribute("nombre","PremiosAsociadosNivel" );
      ((Element)v.get(242)).setAttribute("ID","botonContenido" );
      ((Element)v.get(242)).setAttribute("img","" );
      ((Element)v.get(242)).setAttribute("tipo","html" );
      ((Element)v.get(242)).setAttribute("estado","false" );
      ((Element)v.get(242)).setAttribute("alt","" );
      ((Element)v.get(242)).setAttribute("cod","3373" );
      ((Element)v.get(242)).setAttribute("accion","onClickboPremiosAsociadosNivel();" );
      ((Element)v.get(242)).setAttribute("ontab","ontabBotonMotivos();" );
      ((Element)v.get(236)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:236   */
      /* Termina nodo:235   */
      /* Termina nodo:234   */
      /* Termina nodo:233   */
      /* Termina nodo:8   */


   }

}
