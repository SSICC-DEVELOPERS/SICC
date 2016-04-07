
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_usuarios_buscar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_usuarios_buscar" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","inicializar();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("cod","06" );
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
      v.add(doc.createTextNode("\r  \r\r                  var vSeleccionado = new Array();\r\r         function muestraLista(ultima, rowset){\r                  var tamano = rowset.length;\r                  if (tamano > 0) {\r                  var casoDeUso = get(\"frmFormulario.casoDeUso\");\r                  if (casoDeUso == 'consultar') {\r\r                           document.all[\"DetalleDiv\"].style.visibility='';	    \r                           document.all[\"ModificarDiv\"].style.visibility='hidden';\r\r                  } else {\r                           if (casoDeUso == 'Modificar') {\r                                    document.all[\"DetalleDiv\"].style.visibility='hidden';	    \r                                    document.all[\"ModificarDiv\"].style.visibility='';\r                           } else {\r                                     btnProxy(4,1);\r                                    document.all[\"DetalleDiv\"].style.visibility='hidden';	    \r                                    document.all[\"ModificarDiv\"].style.visibility='hidden';\r                           }\r                  }\r                            document.all[\"Cplistado1\"].style.visibility='';\r                            document.all[\"CpLin1listado1\"].style.visibility='';\r                            document.all[\"CpLin2listado1\"].style.visibility='';\r                            document.all[\"CpLin3listado1\"].style.visibility='';\r                            document.all[\"CpLin4listado1\"].style.visibility='';\r                            document.all[\"ava1Div\"].style.visibility='';\r                            document.all[\"ret1Div\"].style.visibility='';\r                            document.all[\"separa1Div\"].style.visibility='';\r                            document.all[\"primera1Div\"].style.visibility='';\r\r                            eval (ON_RSZ);\r\r                   focaliza('frmFormulario.txtUsuario','');\r                            return true;\r                  } else {\r                   btnProxy(4,0);\r           focaliza('frmFormulario.txtUsuario','');\r                                        return false;\r                   }\r         }\r\r\r\r         function MostrarLista() {\r\r                  DrdEnsanchaConMargenDcho('listado1',12);\r                  var casoDeUso = get(\"frmFormulario.casoDeUso\");\r                  if (casoDeUso == 'consultar') {\r\r                           document.all[\"DetalleDiv\"].style.visibility='';	    \r                           document.all[\"ModificarDiv\"].style.visibility='hidden';\r\r                  } else {\r                           if (casoDeUso == 'Modificar') {\r                                    document.all[\"DetalleDiv\"].style.visibility='hidden';	    \r                                    document.all[\"ModificarDiv\"].style.visibility='';\r                           } else {\r                                    document.all[\"DetalleDiv\"].style.visibility='hidden';	    \r                                    document.all[\"ModificarDiv\"].style.visibility='hidden';\r                           }\r                  }\r                            document.all[\"Cplistado1\"].style.visibility='';\r                            document.all[\"CpLin1listado1\"].style.visibility='';\r                            document.all[\"CpLin2listado1\"].style.visibility='';\r                            document.all[\"CpLin3listado1\"].style.visibility='';\r                            document.all[\"CpLin4listado1\"].style.visibility='';\r                            document.all[\"ava1Div\"].style.visibility='';\r                            document.all[\"ret1Div\"].style.visibility='';\r                            document.all[\"separa1Div\"].style.visibility='';\r                            document.all[\"primera1Div\"].style.visibility='';\r\r                   eval (ON_RSZ);\r         }\r\r  function onLoadPag()   {\r  \r    DrdEnsanchaConMargenDcho('listado1',12);\r\r     document.all[\"Cplistado1\"].style.visibility='hidden';\r     document.all[\"CpLin1listado1\"].style.visibility='hidden';\r     document.all[\"CpLin2listado1\"].style.visibility='hidden';\r     document.all[\"CpLin3listado1\"].style.visibility='hidden';\r     document.all[\"CpLin4listado1\"].style.visibility='hidden';\r     document.all[\"ava1Div\"].style.visibility='hidden';\r     document.all[\"ret1Div\"].style.visibility='hidden';\r     document.all[\"separa1Div\"].style.visibility='hidden';\r     document.all[\"ModificarDiv\"].style.visibility='hidden';\r          document.all[\"primera1Div\"].style.visibility='hidden';\r          document.all[\"DetalleDiv\"].style.visibility='hidden';\r\r     eval (ON_RSZ);  \r\r   }\r   \r\r    var formName = 'frmFormulario.';\r         \r         var permitidos = \"abcdefghijklmnÒopqrstuvwxyzABCDEFGHIJKLMN—OPQRSTUVWXYZ0123456789·ÈÌÛ˙¡…Õ”⁄%_-\";\r\r\rfunction llenarComboHabilitado(){\r\r                           var si = GestionarMensaje(\"1010\");\r                           var no = GestionarMensaje(\"1011\");\r                           var datosCombos = new Array();\r                           datosCombos[0] = ['', ''];\r                           datosCombos[1] = ['N', GestionarMensaje('86')];\r                           datosCombos[2] = ['S', GestionarMensaje('84')];\r\r                           set_combo('frmFormulario.cbUsuarioHablitado', datosCombos);\r\r                                                               var opciones = new Array();\r                                    opciones[0]=['',''];\r                                    opciones[1]=['BATCH',GestionarMensaje('89')];\r                                    opciones[2]=['INTERACTIVO',GestionarMensaje('88')];\r                                    opciones[3]=['TERCERO',GestionarMensaje('90')];\r                                    set_combo(formName + 'cbTipoUsuario', opciones );\r\r}\r           \r           function inicializar(){\r                           fMostrarMensajeError();\r                           onLoadPag();\r                           llenarComboHabilitado();\r                           \r                           var exito = get(\"frmFormulario.exito\");\r                           if (exito == \"S\"){\r                                    var wnd = fMostrarMensajeExito();\r                                    set(\"frmFormulario.exito\", \"\");\r                                    set(\"frmFormulario.accion\", \"\");\r                                    enviaSICC(\"frmFormulario\");\r\r                           }\r          \r                                    \r          marcarSelecciones();\r                           \r                  configurarMenuSecundario(\"frmFormulario\");\r\r          focaliza('frmFormulario.txtUsuario','');\r           btnProxy(4,0);\r\r      }\r\r\r           function datosComboSimple(vectorDatos ){\r                              var i = 0;\r                              var opciones = new Array();\r                              for(var k=1; k <= eval( vectorDatos + '.length'); k++){\r                                                      opciones[i] = [ eval(vectorDatos)[k-1]];\r                                                      i++;\r                              }\r\r                              return opciones;\r           }\r\r\r                  function marcarSelecciones(){\r\r\r                                                      \r                           vSeleccionado[0]=(get(formName + 'hPerfil')).split('|');			\r                           var vS =datosComboSimple('vSeleccionado[0]');\r                           set(formName + 'cbPerfil', vS);                             \r                           vSeleccionado[0]=get(formName + 'hDepartamento');\r                           set(formName + 'cbDepartamento', vSeleccionado);                            \r                           vSeleccionado[0]=get(formName + 'hTipoUsuario');\r                           set(formName + 'cbTipoUsuario', vSeleccionado);                            \r                           vSeleccionado[0]=get(formName + 'hUsuarioHabilitado');\r                           set(formName + 'cbUsuarioHablitado', vSeleccionado);                   }\r\r             function validarAlfanumericoConEspeciales(valor) {\r                           var c;\r         \r                           for(var i=0;i<valor.length;i++) {\r                                    c=valor.charAt(i);\r         \r                                    if (permitidos.indexOf(c)==-1) {\r                                             return false;\r                                    }\r                           }\r                           return true;\r              }\r\r         function camposValidos(){\r                  var result 		= true;\r         var formName 	= 'frmFormulario.';\r         \r          var txtUsuario                            = get(formName + 'txtUsuario');\r          var txtNombre1                   = get(formName + 'txtNombre1');\r          var txtNombre2          = get(formName + 'txtNombre2');\r          var txtApellido1        = get(formName + 'txtApellido1');\r          var txtApellido2        = get(formName + 'txtApellido2');\r                           \r                  if ( 	result  && !validarAlfanumericoConEspeciales(txtUsuario) ){\r                                             GestionarMensaje(\"995\", null, null, null);\r                                    focaliza(formName + 'txtUsuario','');\r                                    result = false;   		\r                  }\r\r                  return result;\r         }\r   \r      function enviarFormulario()\r                  {          \r                           var fechaDesde = get(\"frmFormulario.txtValidezDesde\");\r                           var fechaHasta = get(\"frmFormulario.txtHasta\");\r                           var formatoFecha = get(\"frmFormulario.hFormatoFechaPais\");\r\r\r\r                           if (fechaDesde != \"\")                            {\r                                    var valido = EsFechaValida_SICC(fechaDesde, \"frmFormulario\");\r                                    if (valido == false)\r                                    {\r                                             focaliza(\"frmFormulario.txtValidezDesde\", \"\");\r                                             GestionarMensaje(\"1006\", formatoFecha, null, null);\r                                             return;\r                                    }\r                           }\r\r\r                           if (fechaHasta != \"\")                            {\r                                    var valido = EsFechaValida_SICC(fechaHasta, \"frmFormulario\");\r                                    if (valido == false)\r                                    {\r                                             focaliza(\"frmFormulario.txtHasta\", \"\");\r                                             GestionarMensaje(\"1006\", formatoFecha, null, null);\r                                             return;\r                                    }\r                           }			 \r\r\r                                             if ( camposValidos() ){\r\rconfigurarPaginado(mipgndo1,\"MENBuscarUsuarios\",\"ConectorBuscarUsuario\",\"es.indra.sicc.dtos.men.DTOEntradaCriteriosDeBusquedaUsuarios\", \r[\r['formatoFecha', formatoFecha],\r['idUsuario', get('frmFormulario.txtUsuario')],\r['nombreUsuario1',  get('frmFormulario.txtNombre1')],\r['nombreUsuario2', get('frmFormulario.txtNombre2')],\r['apellidoUsuario1', get('frmFormulario.txtApellido1')],\r['apellidoUsuario2', get('frmFormulario.txtApellido2')],\r['perfil', get('frmFormulario.cbPerfil')],\r['telefonoContacto', get('frmFormulario.txtTelefono')],\r['departamento', get('frmFormulario.cbDepartamento')],\r['validezDesde', get('frmFormulario.txtValidezDesde')],\r['validezHasta', get('frmFormulario.txtHasta')],\r['tipoUsuario', get('frmFormulario.cbTipoUsuario')],\r['usuarioHabilitado', get('frmFormulario.cbUsuarioHablitado')]\r]);\r\r     document.all[\"Cplistado1\"].style.visibility='hidden';\r     document.all[\"CpLin1listado1\"].style.visibility='hidden';\r     document.all[\"CpLin2listado1\"].style.visibility='hidden';\r     document.all[\"CpLin3listado1\"].style.visibility='hidden';\r     document.all[\"CpLin4listado1\"].style.visibility='hidden';\r     document.all[\"ava1Div\"].style.visibility='hidden';\r     document.all[\"ret1Div\"].style.visibility='hidden';\r     document.all[\"separa1Div\"].style.visibility='hidden';\r     document.all[\"ModificarDiv\"].style.visibility='hidden';\r          document.all[\"primera1Div\"].style.visibility='hidden';\r          document.all[\"DetalleDiv\"].style.visibility='hidden';\r\r                                             }\r      }\r\r      function fBorrar(){\r                                             if (listado1.numSelecc() == 1){\r                                                      var sele = listado1.extraeDato(listado1.codSeleccionados(),0);\r                                                      if(sele != get('frmFormulario.usuarioSesion')) {\r                                                                if ( GestionarMensaje('5',null,null,null) ){\r                                                                                           set('frmFormulario.elementosSeleccionados',sele);\r                                                                                           set('frmFormulario.accion','Eliminar');\r                                                                                           set('frmFormulario.conectorAction','LPEliminarUsuarios');\r                                                                                           enviaSICC('frmFormulario');		 \r                                                                }\r                                                      } else {\r                                                                GestionarMensaje('1310',null,null,null)\r                                                      }\r                                             } else {\r                                                      GestionarMensaje('8',null,null,null);             \r                                             }      \r                           }\r\r      function modificar(){\r                                             if (listado1.numSelecc() == 1){\r                                                      var sele = listado1.extraeDato(listado1.codSeleccionados(),0);\r                                                      set('frmFormulario.elementosSeleccionados',sele);\r                                             var parametros = new Object();\r                                             parametros.elementosSeleccionados = sele;\r                                                      var salida = mostrarModalSICC('LPModificarUsuarios', 'Modificar', parametros);\r                                                      if(salida != null && salida){\r                                                                enviarFormulario();\r                                                      }\r                                             } else {\r                                                      GestionarMensaje('8',null,null,null);             \r                                             }                   \r      }\r\r\r      function consultar(){\r                                             if (listado1.numSelecc() == 1){\r                                                      var sele = listado1.extraeDato(listado1.codSeleccionados(),0);\r                                                      set('frmFormulario.elementosSeleccionados',sele);\r                                             var parametros = new Object();\r                                             parametros.elementosSeleccionados = sele;\r                                                      mostrarModalSICC('LPConsultarUsuarios', 'Consultar', parametros);\r                                             } else {\r                                                      GestionarMensaje('8',null,null,null);             \r                                             }          \r      }\r\r      function reintentar(){\r          enviaSICC('frmFormulario',null,null,'N');\r      }\r\r      function cancelar(){\r      }\r\rfunction verificarFechas(errorCode) {\r\r          switch (errorCode)\r          {\r          case 0:                     return true;\r          case 1:                     \r                  GestionarMensaje('1006', get(\"frmFormulario.hFormatoFechaPais\") , null, null);\r                  focaliza(\"frmFormulario.txtValidezDesde\", '');\r                  break;\r          case 2:	                     GestionarMensaje('1006', get(\"frmFormulario.hFormatoFechaPais\"), null, null);\r                  focaliza(\"frmFormulario.txtHasta\", '');\r                  break;\r         }\r\r         return false;\r\r}\r\r   \r   "));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(6)).setAttribute("nombre","frmFormulario" );
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
      ((Element)v.get(8)).setAttribute("valor","LPConsultarUsuarios" );
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
      ((Element)v.get(10)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","elementosSeleccionados" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","hiddenIdentificadorUsuario" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","hPerfil" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hDepartamento" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hTipoUsuario" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hUsuarioHabilitado" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","exito" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","usuarioSesion" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(20)).setAttribute("nombre","capa" );
      ((Element)v.get(6)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("table"));
      ((Element)v.get(21)).setAttribute("width","100%" );
      ((Element)v.get(21)).setAttribute("border","0" );
      ((Element)v.get(21)).setAttribute("cellspacing","0" );
      ((Element)v.get(21)).setAttribute("cellpadding","0" );
      ((Element)v.get(20)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(21)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("td"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(23)).setAttribute("width","12" );
      ((Element)v.get(23)).setAttribute("align","center" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(24)).setAttribute("src","b.gif" );
      ((Element)v.get(24)).setAttribute("width","12" );
      ((Element)v.get(24)).setAttribute("height","12" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */
      /* Termina nodo:23   */

      /* Empieza nodo:25 / Elemento padre: 22   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).setAttribute("width","750" );
      ((Element)v.get(22)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(26)).setAttribute("src","b.gif" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */
      /* Termina nodo:25   */

      /* Empieza nodo:27 / Elemento padre: 22   */
      v.add(doc.createElement("td"));
      ((Element)v.get(27)).setAttribute("width","12" );
      ((Element)v.get(22)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(28)).setAttribute("src","b.gif" );
      ((Element)v.get(28)).setAttribute("width","12" );
      ((Element)v.get(28)).setAttribute("height","1" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:27   */
      /* Termina nodo:22   */

      /* Empieza nodo:29 / Elemento padre: 21   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(21)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(31)).setAttribute("src","b.gif" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */
      /* Termina nodo:30   */

      /* Empieza nodo:32 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(34)).setAttribute("class","legend" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(35)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(35)).setAttribute("alto","13" );
      ((Element)v.get(35)).setAttribute("filas","1" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(35)).setAttribute("id","legend" );
      ((Element)v.get(35)).setAttribute("cod","0075" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:36 / Elemento padre: 33   */
      v.add(doc.createElement("table"));
      ((Element)v.get(36)).setAttribute("width","100%" );
      ((Element)v.get(36)).setAttribute("border","0" );
      ((Element)v.get(36)).setAttribute("align","center" );
      ((Element)v.get(36)).setAttribute("cellspacing","0" );
      ((Element)v.get(36)).setAttribute("cellpadding","0" );
      ((Element)v.get(33)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("table"));
      ((Element)v.get(39)).setAttribute("width","660" );
      ((Element)v.get(39)).setAttribute("border","0" );
      ((Element)v.get(39)).setAttribute("align","left" );
      ((Element)v.get(39)).setAttribute("cellspacing","0" );
      ((Element)v.get(39)).setAttribute("cellpadding","0" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).setAttribute("colspan","4" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(42)).setAttribute("src","b.gif" );
      ((Element)v.get(42)).setAttribute("width","8" );
      ((Element)v.get(42)).setAttribute("height","8" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:43 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(45)).setAttribute("src","b.gif" );
      ((Element)v.get(45)).setAttribute("width","8" );
      ((Element)v.get(45)).setAttribute("height","8" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:46 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(47)).setAttribute("nombre","lblUsuario" );
      ((Element)v.get(47)).setAttribute("alto","13" );
      ((Element)v.get(47)).setAttribute("filas","1" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(47)).setAttribute("id","datosTitle" );
      ((Element)v.get(47)).setAttribute("cod","136" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).setAttribute("width","25" );
      ((Element)v.get(49)).setAttribute("height","8" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(51)).setAttribute("nombre","lblApellido1" );
      ((Element)v.get(51)).setAttribute("ancho","85" );
      ((Element)v.get(51)).setAttribute("alto","13" );
      ((Element)v.get(51)).setAttribute("filas","1" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(51)).setAttribute("id","datosTitle" );
      ((Element)v.get(51)).setAttribute("cod","16" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:52 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(53)).setAttribute("src","b.gif" );
      ((Element)v.get(53)).setAttribute("width","25" );
      ((Element)v.get(53)).setAttribute("height","8" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:54 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(55)).setAttribute("nombre","lblApellido2" );
      ((Element)v.get(55)).setAttribute("ancho","85" );
      ((Element)v.get(55)).setAttribute("alto","13" );
      ((Element)v.get(55)).setAttribute("filas","1" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(55)).setAttribute("id","datosTitle" );
      ((Element)v.get(55)).setAttribute("cod","17" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:56 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).setAttribute("width","100%" );
      ((Element)v.get(43)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(57)).setAttribute("src","b.gif" );
      ((Element)v.get(57)).setAttribute("width","8" );
      ((Element)v.get(57)).setAttribute("height","8" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */
      /* Termina nodo:43   */

      /* Empieza nodo:58 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(60)).setAttribute("src","b.gif" );
      ((Element)v.get(60)).setAttribute("width","8" );
      ((Element)v.get(60)).setAttribute("height","8" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(62)).setAttribute("nombre","txtUsuario" );
      ((Element)v.get(62)).setAttribute("id","datosCampos" );
      ((Element)v.get(62)).setAttribute("max","20" );
      ((Element)v.get(62)).setAttribute("tipo","" );
      ((Element)v.get(62)).setAttribute("onchange","" );
      ((Element)v.get(62)).setAttribute("req","N" );
      ((Element)v.get(62)).setAttribute("size","20" );
      ((Element)v.get(62)).setAttribute("valor","" );
      ((Element)v.get(62)).setAttribute("validacion","" );
      ((Element)v.get(62)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnBuscar');" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(64)).setAttribute("src","b.gif" );
      ((Element)v.get(64)).setAttribute("width","25" );
      ((Element)v.get(64)).setAttribute("height","8" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(66)).setAttribute("nombre","txtApellido1" );
      ((Element)v.get(66)).setAttribute("id","datosCampos" );
      ((Element)v.get(66)).setAttribute("max","25" );
      ((Element)v.get(66)).setAttribute("tipo","" );
      ((Element)v.get(66)).setAttribute("onchange","" );
      ((Element)v.get(66)).setAttribute("req","N" );
      ((Element)v.get(66)).setAttribute("size","25" );
      ((Element)v.get(66)).setAttribute("valor","" );
      ((Element)v.get(66)).setAttribute("validacion","" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:67 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(68)).setAttribute("width","25" );
      ((Element)v.get(68)).setAttribute("height","8" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:69 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(70)).setAttribute("nombre","txtApellido2" );
      ((Element)v.get(70)).setAttribute("id","datosCampos" );
      ((Element)v.get(70)).setAttribute("max","25" );
      ((Element)v.get(70)).setAttribute("tipo","" );
      ((Element)v.get(70)).setAttribute("onchange","" );
      ((Element)v.get(70)).setAttribute("req","N" );
      ((Element)v.get(70)).setAttribute("size","25" );
      ((Element)v.get(70)).setAttribute("valor","" );
      ((Element)v.get(70)).setAttribute("validacion","" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:71 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).setAttribute("width","100%" );
      ((Element)v.get(58)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(72)).setAttribute("width","8" );
      ((Element)v.get(72)).setAttribute("height","8" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:58   */
      /* Termina nodo:39   */
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:73 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("table"));
      ((Element)v.get(75)).setAttribute("width","660" );
      ((Element)v.get(75)).setAttribute("border","0" );
      ((Element)v.get(75)).setAttribute("align","left" );
      ((Element)v.get(75)).setAttribute("cellspacing","0" );
      ((Element)v.get(75)).setAttribute("cellpadding","0" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).setAttribute("colspan","4" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(78)).setAttribute("width","8" );
      ((Element)v.get(78)).setAttribute("height","8" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:79 / Elemento padre: 75   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(75)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(81)).setAttribute("src","b.gif" );
      ((Element)v.get(81)).setAttribute("width","8" );
      ((Element)v.get(81)).setAttribute("height","8" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:82 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(83)).setAttribute("nombre","lblNombre1" );
      ((Element)v.get(83)).setAttribute("ancho","85" );
      ((Element)v.get(83)).setAttribute("alto","13" );
      ((Element)v.get(83)).setAttribute("filas","1" );
      ((Element)v.get(83)).setAttribute("valor","" );
      ((Element)v.get(83)).setAttribute("id","datosTitle" );
      ((Element)v.get(83)).setAttribute("cod","93" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:84 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(85)).setAttribute("src","b.gif" );
      ((Element)v.get(85)).setAttribute("width","25" );
      ((Element)v.get(85)).setAttribute("height","8" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:86 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(87)).setAttribute("nombre","lblNombre2" );
      ((Element)v.get(87)).setAttribute("ancho","85" );
      ((Element)v.get(87)).setAttribute("alto","13" );
      ((Element)v.get(87)).setAttribute("filas","1" );
      ((Element)v.get(87)).setAttribute("valor","" );
      ((Element)v.get(87)).setAttribute("id","datosTitle" );
      ((Element)v.get(87)).setAttribute("cod","94" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:88 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(89)).setAttribute("src","b.gif" );
      ((Element)v.get(89)).setAttribute("width","25" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(89)).setAttribute("height","8" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:90 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(91)).setAttribute("nombre","lblTelefono" );
      ((Element)v.get(91)).setAttribute("ancho","60" );
      ((Element)v.get(91)).setAttribute("alto","13" );
      ((Element)v.get(91)).setAttribute("filas","1" );
      ((Element)v.get(91)).setAttribute("valor","" );
      ((Element)v.get(91)).setAttribute("id","datosTitle" );
      ((Element)v.get(91)).setAttribute("cod","125" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:92 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","b.gif" );
      ((Element)v.get(93)).setAttribute("width","25" );
      ((Element)v.get(93)).setAttribute("height","8" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:94 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(95)).setAttribute("nombre","lblDepartamento" );
      ((Element)v.get(95)).setAttribute("ancho","85" );
      ((Element)v.get(95)).setAttribute("alto","13" );
      ((Element)v.get(95)).setAttribute("filas","1" );
      ((Element)v.get(95)).setAttribute("valor","" );
      ((Element)v.get(95)).setAttribute("id","datosTitle" );
      ((Element)v.get(95)).setAttribute("cod","45" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:96 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).setAttribute("width","100%" );
      ((Element)v.get(79)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(97)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).setAttribute("width","8" );
      ((Element)v.get(97)).setAttribute("height","8" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */
      /* Termina nodo:79   */

      /* Empieza nodo:98 / Elemento padre: 75   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(75)).appendChild((Element)v.get(98));

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
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(102)).setAttribute("nombre","txtNombre1" );
      ((Element)v.get(102)).setAttribute("id","datosCampos" );
      ((Element)v.get(102)).setAttribute("max","25" );
      ((Element)v.get(102)).setAttribute("tipo","" );
      ((Element)v.get(102)).setAttribute("onchange","" );
      ((Element)v.get(102)).setAttribute("req","N" );
      ((Element)v.get(102)).setAttribute("size","25" );
      ((Element)v.get(102)).setAttribute("valor","" );
      ((Element)v.get(102)).setAttribute("validacion","" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(104)).setAttribute("width","25" );
      ((Element)v.get(104)).setAttribute("height","8" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(106)).setAttribute("nombre","txtNombre2" );
      ((Element)v.get(106)).setAttribute("id","datosCampos" );
      ((Element)v.get(106)).setAttribute("max","25" );
      ((Element)v.get(106)).setAttribute("tipo","" );
      ((Element)v.get(106)).setAttribute("onchange","" );
      ((Element)v.get(106)).setAttribute("req","N" );
      ((Element)v.get(106)).setAttribute("size","25" );
      ((Element)v.get(106)).setAttribute("valor","" );
      ((Element)v.get(106)).setAttribute("validacion","" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:107 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(108)).setAttribute("src","b.gif" );
      ((Element)v.get(108)).setAttribute("width","25" );
      ((Element)v.get(108)).setAttribute("height","8" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(110)).setAttribute("nombre","txtTelefono" );
      ((Element)v.get(110)).setAttribute("id","datosCampos" );
      ((Element)v.get(110)).setAttribute("max","12" );
      ((Element)v.get(110)).setAttribute("tipo","" );
      ((Element)v.get(110)).setAttribute("onchange","" );
      ((Element)v.get(110)).setAttribute("req","N" );
      ((Element)v.get(110)).setAttribute("size","15" );
      ((Element)v.get(110)).setAttribute("valor","" );
      ((Element)v.get(110)).setAttribute("validacion","" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:111 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(112)).setAttribute("src","b.gif" );
      ((Element)v.get(112)).setAttribute("width","25" );
      ((Element)v.get(112)).setAttribute("height","8" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:113 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(114)).setAttribute("nombre","cbDepartamento" );
      ((Element)v.get(114)).setAttribute("id","datosCampos" );
      ((Element)v.get(114)).setAttribute("size","1" );
      ((Element)v.get(114)).setAttribute("multiple","N" );
      ((Element)v.get(114)).setAttribute("req","N" );
      ((Element)v.get(114)).setAttribute("valorinicial","" );
      ((Element)v.get(114)).setAttribute("textoinicial","" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:116 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).setAttribute("width","100%" );
      ((Element)v.get(98)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(117)).setAttribute("src","b.gif" );
      ((Element)v.get(117)).setAttribute("width","8" );
      ((Element)v.get(117)).setAttribute("height","8" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */
      /* Termina nodo:98   */
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:118 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("table"));
      ((Element)v.get(120)).setAttribute("width","660" );
      ((Element)v.get(120)).setAttribute("border","0" );
      ((Element)v.get(120)).setAttribute("align","left" );
      ((Element)v.get(120)).setAttribute("cellspacing","0" );
      ((Element)v.get(120)).setAttribute("cellpadding","0" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(120)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).setAttribute("colspan","4" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(123)).setAttribute("src","b.gif" );
      ((Element)v.get(123)).setAttribute("width","8" );
      ((Element)v.get(123)).setAttribute("height","8" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:124 / Elemento padre: 120   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(120)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(126)).setAttribute("src","b.gif" );
      ((Element)v.get(126)).setAttribute("width","8" );
      ((Element)v.get(126)).setAttribute("height","8" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:127 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(128)).setAttribute("nombre","lblValidezDesde" );
      ((Element)v.get(128)).setAttribute("ancho","70" );
      ((Element)v.get(128)).setAttribute("alto","13" );
      ((Element)v.get(128)).setAttribute("filas","1" );
      ((Element)v.get(128)).setAttribute("valor","" );
      ((Element)v.get(128)).setAttribute("id","datosTitle" );
      ((Element)v.get(128)).setAttribute("cod","141" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:129 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(130)).setAttribute("src","b.gif" );
      ((Element)v.get(130)).setAttribute("width","25" );
      ((Element)v.get(130)).setAttribute("height","8" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:131 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(132)).setAttribute("nombre","lblHasta" );
      ((Element)v.get(132)).setAttribute("ancho","75" );
      ((Element)v.get(132)).setAttribute("alto","13" );
      ((Element)v.get(132)).setAttribute("filas","1" );
      ((Element)v.get(132)).setAttribute("valor","" );
      ((Element)v.get(132)).setAttribute("id","datosTitle" );
      ((Element)v.get(132)).setAttribute("cod","142" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:133 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(134)).setAttribute("src","b.gif" );
      ((Element)v.get(134)).setAttribute("width","25" );
      ((Element)v.get(134)).setAttribute("height","8" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:135 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(136)).setAttribute("nombre","lblTipoUsuario" );
      ((Element)v.get(136)).setAttribute("alto","13" );
      ((Element)v.get(136)).setAttribute("filas","1" );
      ((Element)v.get(136)).setAttribute("valor","" );
      ((Element)v.get(136)).setAttribute("id","datosTitle" );
      ((Element)v.get(136)).setAttribute("cod","131" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:137 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(138)).setAttribute("src","b.gif" );
      ((Element)v.get(138)).setAttribute("width","25" );
      ((Element)v.get(138)).setAttribute("height","8" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:139 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(140)).setAttribute("nombre","lblUsuarioHablitado" );
      ((Element)v.get(140)).setAttribute("alto","13" );
      ((Element)v.get(140)).setAttribute("filas","1" );
      ((Element)v.get(140)).setAttribute("valor","" );
      ((Element)v.get(140)).setAttribute("id","datosTitle" );
      ((Element)v.get(140)).setAttribute("cod","138" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:141 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(141)).setAttribute("width","100%" );
      ((Element)v.get(124)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(142)).setAttribute("src","b.gif" );
      ((Element)v.get(142)).setAttribute("width","8" );
      ((Element)v.get(142)).setAttribute("height","8" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:124   */

      /* Empieza nodo:143 / Elemento padre: 120   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(120)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(145)).setAttribute("src","b.gif" );
      ((Element)v.get(145)).setAttribute("width","8" );
      ((Element)v.get(145)).setAttribute("height","8" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */

      /* Empieza nodo:146 / Elemento padre: 143   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(147)).setAttribute("nombre","txtValidezDesde" );
      ((Element)v.get(147)).setAttribute("id","datosCampos" );
      ((Element)v.get(147)).setAttribute("max","10" );
      ((Element)v.get(147)).setAttribute("tipo","" );
      ((Element)v.get(147)).setAttribute("onchange","" );
      ((Element)v.get(147)).setAttribute("req","N" );
      ((Element)v.get(147)).setAttribute("size","12" );
      ((Element)v.get(147)).setAttribute("valor","" );
      ((Element)v.get(147)).setAttribute("validacion","" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */

      /* Empieza nodo:148 / Elemento padre: 143   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(149)).setAttribute("src","b.gif" );
      ((Element)v.get(149)).setAttribute("width","25" );
      ((Element)v.get(149)).setAttribute("height","10" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:150 / Elemento padre: 143   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(151)).setAttribute("nombre","txtHasta" );
      ((Element)v.get(151)).setAttribute("id","datosCampos" );
      ((Element)v.get(151)).setAttribute("max","10" );
      ((Element)v.get(151)).setAttribute("tipo","" );
      ((Element)v.get(151)).setAttribute("onchange","" );
      ((Element)v.get(151)).setAttribute("req","N" );
      ((Element)v.get(151)).setAttribute("size","12" );
      ((Element)v.get(151)).setAttribute("valor","" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(151)).setAttribute("validacion","" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:152 / Elemento padre: 143   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(153)).setAttribute("src","b.gif" );
      ((Element)v.get(153)).setAttribute("width","25" );
      ((Element)v.get(153)).setAttribute("height","10" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */

      /* Empieza nodo:154 / Elemento padre: 143   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(155)).setAttribute("nombre","cbTipoUsuario" );
      ((Element)v.get(155)).setAttribute("id","datosCampos" );
      ((Element)v.get(155)).setAttribute("size","1" );
      ((Element)v.get(155)).setAttribute("multiple","N" );
      ((Element)v.get(155)).setAttribute("req","N" );
      ((Element)v.get(155)).setAttribute("valorinicial","" );
      ((Element)v.get(155)).setAttribute("textoinicial","" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */
      /* Termina nodo:154   */

      /* Empieza nodo:157 / Elemento padre: 143   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(158)).setAttribute("src","b.gif" );
      ((Element)v.get(158)).setAttribute("width","25" );
      ((Element)v.get(158)).setAttribute("height","8" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:159 / Elemento padre: 143   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("table"));
      ((Element)v.get(160)).setAttribute("width","100%" );
      ((Element)v.get(160)).setAttribute("border","0" );
      ((Element)v.get(160)).setAttribute("cellspacing","0" );
      ((Element)v.get(160)).setAttribute("cellpadding","0" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(163)).setAttribute("nombre","cbUsuarioHablitado" );
      ((Element)v.get(163)).setAttribute("id","datosCampos" );
      ((Element)v.get(163)).setAttribute("size","1" );
      ((Element)v.get(163)).setAttribute("multiple","N" );
      ((Element)v.get(163)).setAttribute("req","N" );
      ((Element)v.get(163)).setAttribute("valorinicial","" );
      ((Element)v.get(163)).setAttribute("textoinicial","" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */
      /* Termina nodo:162   */
      /* Termina nodo:161   */
      /* Termina nodo:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:165 / Elemento padre: 143   */
      v.add(doc.createElement("td"));
      ((Element)v.get(165)).setAttribute("width","100%" );
      ((Element)v.get(143)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(166)).setAttribute("src","b.gif" );
      ((Element)v.get(166)).setAttribute("width","8" );
      ((Element)v.get(166)).setAttribute("height","8" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */
      /* Termina nodo:143   */
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:167 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("table"));
      ((Element)v.get(169)).setAttribute("width","660" );
      ((Element)v.get(169)).setAttribute("border","0" );
      ((Element)v.get(169)).setAttribute("align","left" );
      ((Element)v.get(169)).setAttribute("cellspacing","0" );
      ((Element)v.get(169)).setAttribute("cellpadding","0" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(169)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("td"));
      ((Element)v.get(171)).setAttribute("colspan","4" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(172)).setAttribute("src","b.gif" );
      ((Element)v.get(172)).setAttribute("width","8" );
      ((Element)v.get(172)).setAttribute("height","8" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */
      /* Termina nodo:170   */

      /* Empieza nodo:173 / Elemento padre: 169   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(169)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(173)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(175)).setAttribute("src","b.gif" );
      ((Element)v.get(175)).setAttribute("width","8" );
      ((Element)v.get(175)).setAttribute("height","8" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */

      /* Empieza nodo:176 / Elemento padre: 173   */
   }

   private void getXML720(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(173)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(177)).setAttribute("nombre","lblPerfil" );
      ((Element)v.get(177)).setAttribute("alto","13" );
      ((Element)v.get(177)).setAttribute("filas","1" );
      ((Element)v.get(177)).setAttribute("valor","" );
      ((Element)v.get(177)).setAttribute("id","datosTitle" );
      ((Element)v.get(177)).setAttribute("cod","104" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:178 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).setAttribute("width","100%" );
      ((Element)v.get(173)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(179)).setAttribute("src","b.gif" );
      ((Element)v.get(179)).setAttribute("width","8" );
      ((Element)v.get(179)).setAttribute("height","8" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */
      /* Termina nodo:173   */

      /* Empieza nodo:180 / Elemento padre: 169   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(169)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(180)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(182)).setAttribute("src","b.gif" );
      ((Element)v.get(182)).setAttribute("width","8" );
      ((Element)v.get(182)).setAttribute("height","8" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:183 / Elemento padre: 180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(180)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(184)).setAttribute("nombre","cbPerfil" );
      ((Element)v.get(184)).setAttribute("id","datosCampos" );
      ((Element)v.get(184)).setAttribute("size","5" );
      ((Element)v.get(184)).setAttribute("multiple","S" );
      ((Element)v.get(184)).setAttribute("req","N" );
      ((Element)v.get(184)).setAttribute("valorinicial","" );
      ((Element)v.get(184)).setAttribute("textoinicial","" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:186 / Elemento padre: 180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(186)).setAttribute("width","100%" );
      ((Element)v.get(180)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(187)).setAttribute("src","b.gif" );
      ((Element)v.get(187)).setAttribute("width","8" );
      ((Element)v.get(187)).setAttribute("height","8" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:186   */
      /* Termina nodo:180   */

      /* Empieza nodo:188 / Elemento padre: 169   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(169)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("td"));
      ((Element)v.get(189)).setAttribute("colspan","4" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(190)).setAttribute("src","b.gif" );
      ((Element)v.get(190)).setAttribute("width","8" );
      ((Element)v.get(190)).setAttribute("height","8" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */
      /* Termina nodo:188   */
      /* Termina nodo:169   */
      /* Termina nodo:168   */
      /* Termina nodo:167   */
      /* Termina nodo:36   */
      /* Termina nodo:33   */
      /* Termina nodo:32   */

      /* Empieza nodo:191 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(192)).setAttribute("src","b.gif" );
      ((Element)v.get(192)).setAttribute("width","8" );
      ((Element)v.get(192)).setAttribute("height","12" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */
      /* Termina nodo:29   */

      /* Empieza nodo:193 / Elemento padre: 21   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(21)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(195)).setAttribute("src","b.gif" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */

      /* Empieza nodo:196 / Elemento padre: 193   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(196)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("table"));
      ((Element)v.get(198)).setAttribute("width","100%" );
      ((Element)v.get(198)).setAttribute("border","0" );
      ((Element)v.get(198)).setAttribute("align","center" );
      ((Element)v.get(198)).setAttribute("cellspacing","0" );
      ((Element)v.get(198)).setAttribute("cellpadding","0" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(198)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(200)).setAttribute("class","botonera" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(201)).setAttribute("nombre","btnBuscar" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(201)).setAttribute("ID","botonContenido" );
      ((Element)v.get(201)).setAttribute("tipo","html" );
      ((Element)v.get(201)).setAttribute("accion","javascript:enviarFormulario();" );
      ((Element)v.get(201)).setAttribute("estado","false" );
      ((Element)v.get(201)).setAttribute("cod","1" );
      ((Element)v.get(201)).setAttribute("ontab","focaliza('frmFormulario.txtUsuario');" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */
      /* Termina nodo:199   */
      /* Termina nodo:198   */
      /* Termina nodo:197   */
      /* Termina nodo:196   */

      /* Empieza nodo:202 / Elemento padre: 193   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(203)).setAttribute("src","b.gif" );
      ((Element)v.get(203)).setAttribute("width","8" );
      ((Element)v.get(203)).setAttribute("height","12" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */
      /* Termina nodo:193   */

      /* Empieza nodo:204 / Elemento padre: 21   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(21)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).setAttribute("width","12" );
      ((Element)v.get(205)).setAttribute("align","center" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(206)).setAttribute("src","b.gif" );
      ((Element)v.get(206)).setAttribute("width","12" );
      ((Element)v.get(206)).setAttribute("height","24" );
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
      ((Element)v.get(210)).setAttribute("height","24" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */
      /* Termina nodo:209   */
      /* Termina nodo:204   */
      /* Termina nodo:21   */
      /* Termina nodo:20   */

      /* Empieza nodo:211 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(211)).setAttribute("nombre","listado1" );
      ((Element)v.get(211)).setAttribute("ancho","663" );
      ((Element)v.get(211)).setAttribute("alto","317" );
      ((Element)v.get(211)).setAttribute("x","12" );
      ((Element)v.get(211)).setAttribute("y","293" );
      ((Element)v.get(211)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(211)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(212)).setAttribute("precarga","S" );
      ((Element)v.get(212)).setAttribute("conROver","S" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(213)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(213)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(213)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(213)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */

      /* Empieza nodo:214 / Elemento padre: 212   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(214)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(214)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(214)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(214)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(212)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */

      /* Empieza nodo:215 / Elemento padre: 212   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(215)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(215)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(212)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:212   */

      /* Empieza nodo:216 / Elemento padre: 211   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(211)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(217)).setAttribute("borde","1" );
      ((Element)v.get(217)).setAttribute("horizDatos","1" );
      ((Element)v.get(217)).setAttribute("horizCabecera","1" );
      ((Element)v.get(217)).setAttribute("vertical","1" );
      ((Element)v.get(217)).setAttribute("horizTitulo","1" );
      ((Element)v.get(217)).setAttribute("horizBase","1" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */

      /* Empieza nodo:218 / Elemento padre: 216   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(218)).setAttribute("borde","#999999" );
      ((Element)v.get(218)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(218)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(218)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(218)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(218)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(218)).setAttribute("horizBase","#999999" );
      ((Element)v.get(216)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */
      /* Termina nodo:216   */

      /* Empieza nodo:219 / Elemento padre: 211   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(219)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(219)).setAttribute("alto","22" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(219)).setAttribute("imgFondo","" );
      ((Element)v.get(219)).setAttribute("cod","00135" );
      ((Element)v.get(219)).setAttribute("ID","datosTitle" );
      ((Element)v.get(211)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */

      /* Empieza nodo:220 / Elemento padre: 211   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(220)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(220)).setAttribute("alto","22" );
      ((Element)v.get(220)).setAttribute("imgFondo","" );
      ((Element)v.get(211)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */

      /* Empieza nodo:221 / Elemento padre: 211   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(221)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(221)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(221)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(221)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(221)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(221)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(211)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(222)).setAttribute("ancho","20" );
      ((Element)v.get(222)).setAttribute("minimizable","S" );
      ((Element)v.get(222)).setAttribute("minimizada","N" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */

      /* Empieza nodo:223 / Elemento padre: 221   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(223)).setAttribute("ancho","20" );
      ((Element)v.get(223)).setAttribute("minimizable","S" );
      ((Element)v.get(223)).setAttribute("minimizada","N" );
      ((Element)v.get(221)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */

      /* Empieza nodo:224 / Elemento padre: 221   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(224)).setAttribute("ancho","20" );
      ((Element)v.get(224)).setAttribute("minimizable","S" );
      ((Element)v.get(224)).setAttribute("minimizada","N" );
      ((Element)v.get(221)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */

      /* Empieza nodo:225 / Elemento padre: 221   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(225)).setAttribute("ancho","20" );
      ((Element)v.get(225)).setAttribute("minimizable","S" );
      ((Element)v.get(225)).setAttribute("minimizada","N" );
      ((Element)v.get(221)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */

      /* Empieza nodo:226 / Elemento padre: 221   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(226)).setAttribute("ancho","20" );
      ((Element)v.get(226)).setAttribute("minimizable","S" );
      ((Element)v.get(226)).setAttribute("minimizada","N" );
      ((Element)v.get(221)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */
      /* Termina nodo:221   */

      /* Empieza nodo:227 / Elemento padre: 211   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(227)).setAttribute("alto","20" );
      ((Element)v.get(227)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(227)).setAttribute("imgFondo","" );
      ((Element)v.get(227)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(211)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(228)).setAttribute("colFondo","" );
      ((Element)v.get(228)).setAttribute("ID","EstCab" );
      ((Element)v.get(228)).setAttribute("cod","136" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */

      /* Empieza nodo:229 / Elemento padre: 227   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(229)).setAttribute("colFondo","" );
      ((Element)v.get(229)).setAttribute("ID","EstCab" );
      ((Element)v.get(229)).setAttribute("cod","16" );
      ((Element)v.get(227)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */

      /* Empieza nodo:230 / Elemento padre: 227   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(230)).setAttribute("colFondo","" );
      ((Element)v.get(230)).setAttribute("ID","EstCab" );
      ((Element)v.get(230)).setAttribute("cod","93" );
      ((Element)v.get(227)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */

      /* Empieza nodo:231 / Elemento padre: 227   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(231)).setAttribute("colFondo","" );
      ((Element)v.get(231)).setAttribute("ID","EstCab" );
      ((Element)v.get(231)).setAttribute("cod","131" );
      ((Element)v.get(227)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */

      /* Empieza nodo:232 / Elemento padre: 227   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(232)).setAttribute("colFondo","" );
      ((Element)v.get(232)).setAttribute("ID","EstCab" );
      ((Element)v.get(232)).setAttribute("cod","104" );
      ((Element)v.get(227)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:227   */

      /* Empieza nodo:233 / Elemento padre: 211   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(233)).setAttribute("alto","22" );
      ((Element)v.get(233)).setAttribute("accion","" );
      ((Element)v.get(233)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(233)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(233)).setAttribute("maxSel","1" );
      ((Element)v.get(233)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(233)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(233)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(233)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(211)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(234)).setAttribute("tipo","texto" );
      ((Element)v.get(234)).setAttribute("ID","EstDat" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */

      /* Empieza nodo:235 / Elemento padre: 233   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(235)).setAttribute("tipo","texto" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(235)).setAttribute("ID","EstDat2" );
      ((Element)v.get(233)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */

      /* Empieza nodo:236 / Elemento padre: 233   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(236)).setAttribute("tipo","texto" );
      ((Element)v.get(236)).setAttribute("ID","EstDat" );
      ((Element)v.get(233)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */

      /* Empieza nodo:237 / Elemento padre: 233   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(237)).setAttribute("tipo","texto" );
      ((Element)v.get(237)).setAttribute("ID","EstDat2" );
      ((Element)v.get(233)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */

      /* Empieza nodo:238 / Elemento padre: 233   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(238)).setAttribute("tipo","texto" );
      ((Element)v.get(238)).setAttribute("ID","EstDat" );
      ((Element)v.get(233)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:233   */

      /* Empieza nodo:239 / Elemento padre: 211   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(211)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */

      /* Empieza nodo:240 / Elemento padre: 211   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(240)).setAttribute("nombre","mipgndo1" );
      ((Element)v.get(240)).setAttribute("ancho","663" );
      ((Element)v.get(240)).setAttribute("sep","$" );
      ((Element)v.get(240)).setAttribute("x","12" );
      ((Element)v.get(240)).setAttribute("class","botonera" );
      ((Element)v.get(240)).setAttribute("y","587" );
      ((Element)v.get(240)).setAttribute("control","|" );
      ((Element)v.get(240)).setAttribute("conector","" );
      ((Element)v.get(240)).setAttribute("rowset","" );
      ((Element)v.get(240)).setAttribute("cargainicial","N" );
      ((Element)v.get(240)).setAttribute("onload","procesarPaginado(mipgndo1, msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(211)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(241)).setAttribute("nombre","ret1" );
      ((Element)v.get(241)).setAttribute("x","37" );
      ((Element)v.get(241)).setAttribute("y","591" );
      ((Element)v.get(241)).setAttribute("ID","botonContenido" );
      ((Element)v.get(241)).setAttribute("img","retroceder_on" );
      ((Element)v.get(241)).setAttribute("tipo","0" );
      ((Element)v.get(241)).setAttribute("estado","false" );
      ((Element)v.get(241)).setAttribute("alt","" );
      ((Element)v.get(241)).setAttribute("codigo","" );
      ((Element)v.get(241)).setAttribute("accion","mipgndo1.retroceder();" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */

      /* Empieza nodo:242 / Elemento padre: 240   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(242)).setAttribute("nombre","ava1" );
      ((Element)v.get(242)).setAttribute("x","52" );
      ((Element)v.get(242)).setAttribute("y","591" );
      ((Element)v.get(242)).setAttribute("ID","botonContenido" );
      ((Element)v.get(242)).setAttribute("img","avanzar_on" );
      ((Element)v.get(242)).setAttribute("tipo","0" );
      ((Element)v.get(242)).setAttribute("estado","false" );
      ((Element)v.get(242)).setAttribute("alt","" );
      ((Element)v.get(242)).setAttribute("codigo","" );
      ((Element)v.get(242)).setAttribute("accion","mipgndo1.avanzar();" );
      ((Element)v.get(240)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:240   */
      /* Termina nodo:211   */

      /* Empieza nodo:243 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(243)).setAttribute("nombre","primera1" );
      ((Element)v.get(243)).setAttribute("x","20" );
      ((Element)v.get(243)).setAttribute("y","591" );
      ((Element)v.get(243)).setAttribute("ID","botonContenido" );
      ((Element)v.get(243)).setAttribute("img","primera_on" );
      ((Element)v.get(243)).setAttribute("tipo","-2" );
      ((Element)v.get(243)).setAttribute("estado","false" );
      ((Element)v.get(243)).setAttribute("alt","" );
      ((Element)v.get(243)).setAttribute("codigo","" );
      ((Element)v.get(243)).setAttribute("accion","mipgndo1.retrocederPrimeraPagina();" );
      ((Element)v.get(6)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */

      /* Empieza nodo:244 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(244)).setAttribute("nombre","separa1" );
      ((Element)v.get(244)).setAttribute("x","59" );
      ((Element)v.get(244)).setAttribute("y","587" );
      ((Element)v.get(244)).setAttribute("ID","botonContenido" );
      ((Element)v.get(244)).setAttribute("img","separa_base" );
      ((Element)v.get(244)).setAttribute("tipo","0" );
      ((Element)v.get(244)).setAttribute("estado","false" );
      ((Element)v.get(244)).setAttribute("alt","" );
      ((Element)v.get(244)).setAttribute("codigo","" );
      ((Element)v.get(244)).setAttribute("accion","" );
      ((Element)v.get(6)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */

      /* Empieza nodo:245 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(245)).setAttribute("nombre","Modificar" );
      ((Element)v.get(245)).setAttribute("x","80" );
      ((Element)v.get(245)).setAttribute("y","588" );
      ((Element)v.get(245)).setAttribute("ID","botonContenido" );
      ((Element)v.get(245)).setAttribute("img","" );
      ((Element)v.get(245)).setAttribute("tipo","html" );
      ((Element)v.get(245)).setAttribute("estado","false" );
      ((Element)v.get(245)).setAttribute("alt","" );
      ((Element)v.get(245)).setAttribute("cod","2" );
      ((Element)v.get(245)).setAttribute("accion","javascript:modificar();" );
      ((Element)v.get(6)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */

      /* Empieza nodo:246 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(246)).setAttribute("nombre","Detalle" );
      ((Element)v.get(246)).setAttribute("x","80" );
      ((Element)v.get(246)).setAttribute("y","588" );
      ((Element)v.get(246)).setAttribute("ID","botonContenido" );
      ((Element)v.get(246)).setAttribute("img","" );
      ((Element)v.get(246)).setAttribute("tipo","html" );
      ((Element)v.get(246)).setAttribute("estado","false" );
      ((Element)v.get(246)).setAttribute("alt","" );
      ((Element)v.get(246)).setAttribute("cod","3" );
      ((Element)v.get(246)).setAttribute("accion","javascript:consultar();" );
      ((Element)v.get(6)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */

      /* Empieza nodo:247 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(247)).setAttribute("nombre","capaEspacio2" );
      ((Element)v.get(247)).setAttribute("alto","18" );
      ((Element)v.get(247)).setAttribute("ancho","100" );
      ((Element)v.get(247)).setAttribute("colorf","" );
      ((Element)v.get(247)).setAttribute("borde","0" );
      ((Element)v.get(247)).setAttribute("imagenf","" );
      ((Element)v.get(247)).setAttribute("repeat","" );
      ((Element)v.get(247)).setAttribute("padding","" );
      ((Element)v.get(247)).setAttribute("visibilidad","visible" );
      ((Element)v.get(247)).setAttribute("contravsb","" );
      ((Element)v.get(247)).setAttribute("x","0" );
      ((Element)v.get(247)).setAttribute("y","610" );
      ((Element)v.get(247)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */
      /* Termina nodo:6   */


   }

}
