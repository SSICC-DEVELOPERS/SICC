
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_grupos_zonas_modificar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_grupos_zonas_modificar" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("cod","066" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","I18NJS.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Elemento padre:4 / Elemento actual: 5   */
      v.add(doc.createTextNode("    \r          \r       function onLoadPag(){   \r\r            configurarMenuSecundario(\"frmModificarGruposZonas\");   \r            posicionarCombos();   \r            \r            \r         \r            var accion = get('frmModificarGruposZonas.accion');\r         \r\r            if(accion == 'muestraConsulta' || accion == 'muestraModificacion' || accion == 'muestraBorrado'){\r               document.all[\"btnMoverZonas\"].style.visibility='hidden';   \r               document.all[\"btnModificarDatosGrupo\"].style.visibility='hidden';   \r               document.all[\"btnAsignarZonas\"].style.visibility='hidden';                    \r               document.all[\"capaMostrarArbolGruposZonas\"].style.visibility='hidden';\r			   document.all[\"scrollPrincipal\"].style.visibility='hidden';\r			}\r            \r            if (get('frmModificarGruposZonas.accion')=='consultar'||   \r                 get('frmModificarGruposZonas.accion')=='eliminar'){   \r              if (get('frmModificarGruposZonas.hCasoDeUso')=='consultar'||   \r                   get('frmModificarGruposZonas.hCasoDeUso')=='eliminar'){   \r                 document.all[\"btnMoverZonas\"].style.visibility='hidden';   \r                 document.all[\"btnModificarDatosGrupo\"].style.visibility='hidden';   \r                 document.all[\"btnAsignarZonas\"].style.visibility='hidden';              \r              } else if (get('frmModificarGruposZonas.hCasoDeUso')=='modificar'){   \r                 document.all[\"btnMoverZonas\"].style.visibility='visible';   \r                 document.all[\"btnModificarDatosGrupo\"].style.visibility='visible';   \r                 document.all[\"btnAsignarZonas\"].style.visibility='visible';   \r              }   \r            }   \r            if (get('frmModificarGruposZonas.accion')=='muestraBuscar'){   \r                 document.all[\"btnMoverZonas\"].style.visibility='hidden';   \r                 document.all[\"btnModificarDatosGrupo\"].style.visibility='hidden';   \r                 document.all[\"btnAsignarZonas\"].style.visibility='hidden';                    \r                 document.all[\"capaMostrarArbolGruposZonas\"].style.visibility='hidden';\r				 document.all[\"scrollPrincipal\"].style.visibility='hidden';\r			}   \r            focaliza('frmModificarGruposZonas.cbMarcas');   \r            mostrarCodigoError();   \r       }   \r    \r\r       function posicionarCombos(){              \r            if (get('frmModificarGruposZonas.hMarca')!=''){   \r              iSeleccionadob = new Array();             \r              iSeleccionadob[0] = get('frmModificarGruposZonas.hMarca');         \r              set('frmModificarGruposZonas.cbMarcas',iSeleccionadob);                     \r            }    \r            if (get('frmModificarGruposZonas.hCanal')!=''){   \r              iSeleccionadob = new Array();             \r              iSeleccionadob[0] = get('frmModificarGruposZonas.hCanal');         \r              set('frmModificarGruposZonas.cbCanales',iSeleccionadob);                     \r            }   \r       }   \r\r	   \r	   function mostrarCodigoError() {     \r                  \r          var vErrCodigo = get('frmModificarGruposZonas.errCodigo');   \r          var vErrDescrip = get('frmModificarGruposZonas.errDescripcion');   \r             \r          if (get('frmModificarGruposZonas.errDescripcion')!='') {   \r                 var wnd = fMostrarMensajeError( vErrCodigo,vErrDescrip);   \r                 /*if (get('frmModificarGruposZonas.errCodigo')=='260020002')   \r                       focaliza('frmModificarGruposZonas.');*/   \r          }   \r             \r       }                \r    \r				\r       function fGuardar(){   \r          accionGuardarModificarDatos();   \r       }   \r    \r\r       function fBorrar(){   \r          accionEliminar();   \r       }   \r    \r\r		function fLimpiar() {\r			document.all[\"btnMoverZonas\"].style.visibility='hidden';   \r			document.all[\"btnModificarDatosGrupo\"].style.visibility='hidden';   \r            document.all[\"btnAsignarZonas\"].style.visibility='hidden';                    \r            document.all[\"capaMostrarArbolGruposZonas\"].style.visibility='hidden';\r            document.all[\"scrollPrincipal\"].style.visibility='hidden';\r		}\r\r\r       function accionAsignarZonas(){  \r        if(toSeleccionado()){\r           if(get('frmModificarGruposZonas.hGrupoSeleccionado')!=''){   \r                 var parametros = new Object();     \r                 parametros.hGrupoSeleccionado = get('frmModificarGruposZonas.hGrupoSeleccionado');   \r                 parametros.hMarca = get('frmModificarGruposZonas.hMarca');   \r                 parametros.hCanal = get('frmModificarGruposZonas.hCanal');               \r                 var res = mostrarModalSICC(\"LPMantieneGruposZonas\", \"asignarZonas\", parametros, 520, 250);             \r                 if (res=='guardo')   \r                     accionConsultar();                   \r           }else{   \r              GestionarMensaje('4');   \r           }\r\r         }\r       }   \r    \r\r       function accionGuardarModificarDatos(){   \r               set('frmModificarGruposZonas.accion','guardarModificarDatos');             \r               set('frmModificarGruposZonas.conectorAction','LPMantieneGruposZonas');   \r               envia('frmModificarGruposZonas');    \r       }   \r    \r\r       function accionModificarDatosGrupo(){ \r            if(toSeleccionado()){\r               if(get('frmModificarGruposZonas.hGrupoSeleccionado')!=''){   \r                     var parametros = new Object();     \r                     parametros.hGrupoSeleccionado = get('frmModificarGruposZonas.hGrupoSeleccionado');   \r                     parametros.hMarca = get('frmModificarGruposZonas.hMarca');   \r                     parametros.hCanal = get('frmModificarGruposZonas.hCanal');               \r                     var res = mostrarModalSICC(\"LPMantieneGruposZonas\", \"modificarDatosGrupo\", parametros, 650, 150);   \r    \r                     if (res=='guardo')   \r                          accionConsultar();    \r               } else {   \r                   GestionarMensaje('4');   \r               }\r           }\r       }   \r    \r\r       function accionMoverEntreGrupos(){   \r          if(toSeleccionado()){\r               if(get('frmModificarGruposZonas.hGrupoSeleccionado')!=''){   \r                   var parametros = new Object();     \r                   parametros.hGrupoSeleccionado = get('frmModificarGruposZonas.hGrupoSeleccionado');   \r                   parametros.hMarca = get('frmModificarGruposZonas.hMarca');   \r                   parametros.hCanal = get('frmModificarGruposZonas.hCanal');   \r                   var res = mostrarModalSICC(\"LPMantieneGruposZonas\", \"moverEntreGrupos\", parametros, 600, 300);   \r    \r                                          accionConsultar();   \r               } else {   \r                   GestionarMensaje('4');   \r               }     \r          }\r       }   \r       function fhoja(){   \r           \r       } \r       \r       function accionConsultar(){   \r          if(!sicc_validaciones_generales()){   \r             return false;   \r          }   \r\r          set('frmModificarGruposZonas.accion','consultar');             \r          set('frmModificarGruposZonas.conectorAction','LPMantieneGruposZonas');   \r          envia('frmModificarGruposZonas');              \r       }         \r    \r       function accionEliminar(){   \r\r          if(!sicc_validaciones_generales()){   \r             return false;   \r          }   \r\r          if(toSeleccionado()){\r\r             if(get('frmModificarGruposZonas.hGrupoSeleccionado')!=''){   \r                if(GestionarMensaje('5')) {   \r                      set('frmModificarGruposZonas.accion','eliminar');             \r                      set('frmModificarGruposZonas.conectorAction','LPMantieneGruposZonas');   \r                      envia('frmModificarGruposZonas');   \r                }   \r             }else{   \r                GestionarMensaje('4');\r             }\r          }   \r       }   \r    \r             \r          \r       function cargarArbol(){          var v1 = get('frmModificarGruposZonas.hArbol');   \r          if(v1 != ''){   \r              var v3 = eval(v1);   \r              miarbol.init(v3);   \r              miarbol.display();   \r                                                 }                       \r       }         \r    \r       function shtabMarcas(){         \r          var casoDeUso = get('frmModificarGruposZonas.hCasoDeUso');   \r          var accion = get('frmModificarGruposZonas.accion');   \r          var errCodigo = get('frmModificarGruposZonas.errCodigo');   \r                              if (casoDeUso=='eliminar'||casoDeUso=='consultar'||   \r              (casoDeUso=='modificar'&&accion=='muestraModificacion')){   \r              document.all.btnBuscar.focus();   \r          } else if (accion=='consultar'&&errCodigo==''){   \r              document.all.btnAsignarZonas.focus();   \r          } else {   \r              document.all.btnBuscar.focus();   \r          }         \r       }   \r       \r       function tabBuscar(){   \r          var casoDeUso = get('frmModificarGruposZonas.hCasoDeUso');   \r          var accion = get('frmModificarGruposZonas.accion');   \r          var errCodigo = get('frmModificarGruposZonas.errCodigo');   \r                              if (casoDeUso=='eliminar'||casoDeUso=='consultar'||   \r              (casoDeUso=='modificar'&&accion=='muestraModificacion')){   \r              focaliza('frmModificarGruposZonas.cbMarcas');   \r          } else if (accion=='consultar'&&errCodigo==''){   \r              document.all.btnMoverZonas.focus();   \r          } else {   \r              focaliza('frmModificarGruposZonas.cbMarcas');   \r          }   \r       }   \r       function shtabMover(){   \r            document.all.btnBuscar.focus();   \r       }   \r\r       window.seleccionadoArbol=-1;       window.seleccionadoArbolEsPadre=false;              \r        function returnFalse() {\r          return false;\r         }\r\r        function miFuncionArbol(nombreArbol,opcion,abriendocerrando,padreseleccionando,soypadre){\r          if (soypadre && !padreseleccionando) {\r            return true;          }\r  \r          var cod=eval(nombreArbol).E.ij(opcion,0)\r\r          if (abriendocerrando==1)   {               if (seleccionadoArbol!=-1)   {\r              if (seleccionadoArbolEsPadre)   \r                arbol('name0','O',seleccionadoArbol,1,\"\",true);\r              else   \r                arbol('name0','O',seleccionadoArbol,1);\r              }\r              seleccionadoArbol=opcion;\r              seleccionadoArbolEsPadre=soypadre;\r            }else                    seleccionadoArbol=-1;\r              return true;         }\r\r\r        function getOidPadre(){\r          var nivelPulsado = name0.entradas[seleccionadoArbol][0];\r          var result =''; \r          var victor = nivelPulsado.split('.'); \r          if (victor.length>0) {\r            result = victor [0];\r          }\r          else return '';\r\r          for (i=1;i<victor.length -1;i++ )\r            result  = result +'.'+victor[i];\r\r          return arbolM(name0,'C?',result);        }\r\r        function verificaSeleccionado() {\r\r			 			 \r          if (seleccionadoArbol != -1 && seleccionadoArbol != 0 )  {\r            set('frmModificarGruposZonas.hGrupoSeleccionado',name0.entradas[seleccionadoArbol][2]);             return 1;\r          }else if (seleccionadoArbol == 0) {            \r            set('frmModificarGruposZonas.hGrupoSeleccionado','-1');             return 2;\r          } else\r			 {\r				set('frmModificarGruposZonas.hGrupoSeleccionado','-1'); 				return 3;\r			 }\r        }\r\r        function toSeleccionado(){\r			 var retorno = verificaSeleccionado();\r\r			 if ( retorno == 1){\r				return true;\r			 }\r			 if (retorno == 2) \r			 {\r            GestionarMensaje('1350',null,null,null);\r				return false;\r			 }\r\r			 if (retorno == 3)\r			 {\r            GestionarMensaje('97',null,null,null);            \r            return false;\r			 }\r\r/*          if(verificaSeleccionado()) {\r             \r            return true;\r          }\r          else {\r            GestionarMensaje('97',null,null,null);            \r            return false;\r          }*/\r        }\r\r        function funcionFinal () {\r          return false;\r        }\r\r       \r   "));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","cbMarcas" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","6" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cbCanales" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","7" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */
      /* Termina nodo:6   */

      /* Empieza nodo:9 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(9)).setAttribute("nombre","frmModificarGruposZonas" );
      ((Element)v.get(0)).appendChild((Element)v.get(9));

      /* Empieza nodo:10 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","accion" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(11)).setAttribute("valor","LPMantieneGruposZonas" );
      ((Element)v.get(9)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","hCasoDeUso" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hArbol" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hMarca" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hCanal" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hGrupoSeleccionado" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 9   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(19)).setAttribute("nombre","capaBusqueda" );
      ((Element)v.get(19)).setAttribute("x","0" );
      ((Element)v.get(19)).setAttribute("y","0" );
      ((Element)v.get(9)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("table"));
      ((Element)v.get(20)).setAttribute("width","100%" );
      ((Element)v.get(20)).setAttribute("border","0" );
      ((Element)v.get(20)).setAttribute("cellspacing","0" );
      ((Element)v.get(20)).setAttribute("cellpadding","0" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(20)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("td"));
      ((Element)v.get(22)).setAttribute("width","12" );
      ((Element)v.get(22)).setAttribute("align","center" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(21)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(23)).setAttribute("src","b.gif" );
      ((Element)v.get(23)).setAttribute("width","12" );
      ((Element)v.get(23)).setAttribute("height","12" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */
      /* Termina nodo:22   */

      /* Empieza nodo:24 / Elemento padre: 21   */
      v.add(doc.createElement("td"));
      ((Element)v.get(24)).setAttribute("width","750" );
      ((Element)v.get(21)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(25)).setAttribute("src","b.gif" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */
      /* Termina nodo:24   */

      /* Empieza nodo:26 / Elemento padre: 21   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).setAttribute("width","12" );
      ((Element)v.get(21)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(27)).setAttribute("src","b.gif" );
      ((Element)v.get(27)).setAttribute("width","12" );
      ((Element)v.get(27)).setAttribute("height","1" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */
      /* Termina nodo:26   */
      /* Termina nodo:21   */

      /* Empieza nodo:28 / Elemento padre: 20   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(20)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("td"));
      ((Element)v.get(28)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(30)).setAttribute("src","b.gif" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */
      /* Termina nodo:29   */

      /* Empieza nodo:31 / Elemento padre: 28   */
      v.add(doc.createElement("td"));
      ((Element)v.get(28)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(33)).setAttribute("class","legend" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(34)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(34)).setAttribute("alto","13" );
      ((Element)v.get(34)).setAttribute("filas","1" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(34)).setAttribute("id","legend" );
      ((Element)v.get(34)).setAttribute("cod","0075" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */
      /* Termina nodo:33   */

      /* Empieza nodo:35 / Elemento padre: 32   */
      v.add(doc.createElement("table"));
      ((Element)v.get(35)).setAttribute("width","100%" );
      ((Element)v.get(35)).setAttribute("border","0" );
      ((Element)v.get(35)).setAttribute("align","center" );
      ((Element)v.get(35)).setAttribute("cellspacing","0" );
      ((Element)v.get(35)).setAttribute("cellpadding","0" );
      ((Element)v.get(32)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("table"));
      ((Element)v.get(38)).setAttribute("width","500" );
      ((Element)v.get(38)).setAttribute("border","0" );
      ((Element)v.get(38)).setAttribute("align","left" );
      ((Element)v.get(38)).setAttribute("cellspacing","0" );
      ((Element)v.get(38)).setAttribute("cellpadding","0" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).setAttribute("colspan","3" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(41)).setAttribute("src","b.gif" );
      ((Element)v.get(41)).setAttribute("width","8" );
      ((Element)v.get(41)).setAttribute("height","8" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */
      /* Termina nodo:39   */

      /* Empieza nodo:42 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(44)).setAttribute("src","b.gif" );
      ((Element)v.get(44)).setAttribute("width","8" );
      ((Element)v.get(44)).setAttribute("height","8" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:45 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(46)).setAttribute("nombre","lblPais" );
      ((Element)v.get(46)).setAttribute("alto","13" );
      ((Element)v.get(46)).setAttribute("filas","1" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(46)).setAttribute("id","datosTitle" );
      ((Element)v.get(46)).setAttribute("cod","5" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:47 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(42)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(48)).setAttribute("src","b.gif" );
      ((Element)v.get(48)).setAttribute("width","25" );
      ((Element)v.get(48)).setAttribute("height","8" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:49 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(50)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(50)).setAttribute("alto","13" );
      ((Element)v.get(50)).setAttribute("filas","1" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(50)).setAttribute("id","datosTitle" );
      ((Element)v.get(50)).setAttribute("cod","6" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:51 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(52)).setAttribute("src","b.gif" );
      ((Element)v.get(52)).setAttribute("width","25" );
      ((Element)v.get(52)).setAttribute("height","8" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:53 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(54)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(54)).setAttribute("alto","13" );
      ((Element)v.get(54)).setAttribute("filas","1" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(54)).setAttribute("id","datosTitle" );
      ((Element)v.get(54)).setAttribute("cod","7" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:55 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).setAttribute("width","100%" );
      ((Element)v.get(42)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(56)).setAttribute("src","b.gif" );
      ((Element)v.get(56)).setAttribute("width","8" );
      ((Element)v.get(56)).setAttribute("height","8" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */
      /* Termina nodo:42   */

      /* Empieza nodo:57 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(59)).setAttribute("src","b.gif" );
      ((Element)v.get(59)).setAttribute("width","8" );
      ((Element)v.get(59)).setAttribute("height","8" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:60 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).setAttribute("valign","bottom" );
      ((Element)v.get(57)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(61)).setAttribute("nombre","lblPaisActual" );
      ((Element)v.get(61)).setAttribute("alto","13" );
      ((Element)v.get(61)).setAttribute("filas","1" );
      ((Element)v.get(61)).setAttribute("valor","xxxx" );
      ((Element)v.get(61)).setAttribute("id","datosCampos" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:62 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(63)).setAttribute("src","b.gif" );
      ((Element)v.get(63)).setAttribute("width","25" );
      ((Element)v.get(63)).setAttribute("height","8" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:64 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(57)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(65)).setAttribute("nombre","cbMarcas" );
      ((Element)v.get(65)).setAttribute("id","datosCampos" );
      ((Element)v.get(65)).setAttribute("size","1" );
      ((Element)v.get(65)).setAttribute("multiple","N" );
      ((Element)v.get(65)).setAttribute("req","S" );
      ((Element)v.get(65)).setAttribute("valorinicial","" );
      ((Element)v.get(65)).setAttribute("textoinicial","" );
      ((Element)v.get(65)).setAttribute("onshtab","shtabMarcas();" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:67 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(68)).setAttribute("width","25" );
      ((Element)v.get(68)).setAttribute("height","8" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:69 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(69)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(57)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(70)).setAttribute("nombre","cbCanales" );
      ((Element)v.get(70)).setAttribute("id","datosCampos" );
      ((Element)v.get(70)).setAttribute("size","1" );
      ((Element)v.get(70)).setAttribute("multiple","N" );
      ((Element)v.get(70)).setAttribute("req","S" );
      ((Element)v.get(70)).setAttribute("valorinicial","" );
      ((Element)v.get(70)).setAttribute("textoinicial","" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:72 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).setAttribute("width","100%" );
      ((Element)v.get(57)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(73)).setAttribute("src","b.gif" );
      ((Element)v.get(73)).setAttribute("width","8" );
      ((Element)v.get(73)).setAttribute("height","8" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */
      /* Termina nodo:57   */

      /* Empieza nodo:74 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).setAttribute("colspan","3" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","8" );
      ((Element)v.get(76)).setAttribute("height","8" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:38   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */
      /* Termina nodo:35   */
      /* Termina nodo:32   */
      /* Termina nodo:31   */

      /* Empieza nodo:77 / Elemento padre: 28   */
      v.add(doc.createElement("td"));
      ((Element)v.get(28)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */
      /* Termina nodo:28   */

      /* Empieza nodo:79 / Elemento padre: 20   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(20)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(81)).setAttribute("src","b.gif" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:82 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("table"));
      ((Element)v.get(84)).setAttribute("width","100%" );
      ((Element)v.get(84)).setAttribute("border","0" );
      ((Element)v.get(84)).setAttribute("align","center" );
      ((Element)v.get(84)).setAttribute("cellspacing","0" );
      ((Element)v.get(84)).setAttribute("cellpadding","0" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(86)).setAttribute("class","botonera" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(87)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(87)).setAttribute("ID","botonContenido" );
      ((Element)v.get(87)).setAttribute("tipo","html" );
      ((Element)v.get(87)).setAttribute("estado","false" );
      ((Element)v.get(87)).setAttribute("cod","1" );
      ((Element)v.get(87)).setAttribute("accion","accionConsultar();" );
      ((Element)v.get(87)).setAttribute("ontab","tabBuscar();" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:88 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(89)).setAttribute("src","b.gif" );
      ((Element)v.get(89)).setAttribute("width","8" );
      ((Element)v.get(89)).setAttribute("height","12" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:79   */

      /* Empieza nodo:90 / Elemento padre: 20   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(20)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).setAttribute("width","12" );
      ((Element)v.get(91)).setAttribute("align","center" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(92)).setAttribute("width","12" );
      ((Element)v.get(92)).setAttribute("height","12" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:93 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).setAttribute("width","756" );
      ((Element)v.get(90)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(94)).setAttribute("src","b.gif" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:95 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).setAttribute("width","12" );
      ((Element)v.get(90)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(96)).setAttribute("src","b.gif" );
      ((Element)v.get(96)).setAttribute("width","12" );
      ((Element)v.get(96)).setAttribute("height","1" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:90   */
      /* Termina nodo:20   */
      /* Termina nodo:19   */

      /* Empieza nodo:97 / Elemento padre: 9   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(97)).setAttribute("nombre","capaMostrarArbolGruposZonas" );
      ((Element)v.get(97)).setAttribute("x","0" );
      ((Element)v.get(97)).setAttribute("y","104" );
      ((Element)v.get(97)).setAttribute("visibilidad","" );
      ((Element)v.get(9)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("table"));
      ((Element)v.get(98)).setAttribute("width","100%" );
      ((Element)v.get(98)).setAttribute("border","0" );
      ((Element)v.get(98)).setAttribute("cellspacing","0" );
      ((Element)v.get(98)).setAttribute("cellpadding","0" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).setAttribute("width","12" );
      ((Element)v.get(100)).setAttribute("align","center" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(101)).setAttribute("src","b.gif" );
      ((Element)v.get(101)).setAttribute("width","12" );
      ((Element)v.get(101)).setAttribute("height","12" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:102 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).setAttribute("width","150" );
      ((Element)v.get(102)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(99)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).setAttribute("width","12" );
      ((Element)v.get(99)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(105)).setAttribute("src","b.gif" );
      ((Element)v.get(105)).setAttribute("width","12" );
      ((Element)v.get(105)).setAttribute("height","1" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */
      /* Termina nodo:99   */

      /* Empieza nodo:106 / Elemento padre: 98   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(98)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(108)).setAttribute("src","b.gif" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(111)).setAttribute("class","legend" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(112)).setAttribute("nombre","lblGruposZonas" );
      ((Element)v.get(112)).setAttribute("alto","13" );
      ((Element)v.get(112)).setAttribute("filas","1" );
      ((Element)v.get(112)).setAttribute("valor","" );
      ((Element)v.get(112)).setAttribute("id","legend" );
      ((Element)v.get(112)).setAttribute("cod","00497" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:113 / Elemento padre: 110   */
      v.add(doc.createElement("table"));
      ((Element)v.get(113)).setAttribute("width","100%" );
      ((Element)v.get(113)).setAttribute("border","0" );
      ((Element)v.get(113)).setAttribute("align","center" );
      ((Element)v.get(113)).setAttribute("cellspacing","0" );
      ((Element)v.get(113)).setAttribute("cellpadding","0" );
      ((Element)v.get(110)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(116)).setAttribute("src","b.gif" );
      ((Element)v.get(116)).setAttribute("width","8" );
      ((Element)v.get(116)).setAttribute("height","230" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:117 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).setAttribute("width","100%" );
      ((Element)v.get(114)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(118)).setAttribute("src","b.gif" );
      ((Element)v.get(118)).setAttribute("width","8" );
      ((Element)v.get(118)).setAttribute("height","8" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:119 / Elemento padre: 110   */
      v.add(doc.createElement("SCROLL"));
      ((Element)v.get(119)).setAttribute("nombre","scrollPrincipal" );
      ((Element)v.get(119)).setAttribute("x","20" );
      ((Element)v.get(119)).setAttribute("y","25" );
      ((Element)v.get(119)).setAttribute("ancho","310" );
      ((Element)v.get(119)).setAttribute("alto","220" );
      ((Element)v.get(119)).setAttribute("colorf","" );
      ((Element)v.get(119)).setAttribute("visibilidad","visible" );
      ((Element)v.get(119)).setAttribute("incx","10" );
      ((Element)v.get(119)).setAttribute("incy","10" );
      ((Element)v.get(119)).setAttribute("colores","" );
      ((Element)v.get(110)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("REJILLA"));
      ((Element)v.get(120)).setAttribute("nombre","RArbol" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:121 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(122)).setAttribute("src","b.gif" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */
      /* Termina nodo:106   */

      /* Empieza nodo:123 / Elemento padre: 98   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(98)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(125)).setAttribute("src","b.gif" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */

      /* Empieza nodo:126 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("table"));
      ((Element)v.get(128)).setAttribute("width","100%" );
      ((Element)v.get(128)).setAttribute("border","0" );
      ((Element)v.get(128)).setAttribute("align","center" );
      ((Element)v.get(128)).setAttribute("cellspacing","0" );
      ((Element)v.get(128)).setAttribute("cellpadding","0" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).setAttribute("class","botonera" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("table"));
      ((Element)v.get(131)).setAttribute("width","500" );
      ((Element)v.get(131)).setAttribute("border","0" );
      ((Element)v.get(131)).setAttribute("align","left" );
      ((Element)v.get(131)).setAttribute("cellspacing","0" );
      ((Element)v.get(131)).setAttribute("cellpadding","0" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).setAttribute("class","botonera" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(134)).setAttribute("nombre","btnAsignarZonas" );
      ((Element)v.get(134)).setAttribute("ID","botonContenido" );
      ((Element)v.get(134)).setAttribute("tipo","html" );
      ((Element)v.get(134)).setAttribute("accion","accionAsignarZonas();" );
      ((Element)v.get(134)).setAttribute("estado","false" );
      ((Element)v.get(134)).setAttribute("cod","235" );
      ((Element)v.get(134)).setAttribute("ontab","focaliza('frmModificarGruposZonas.cbMarcas');" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */

      /* Empieza nodo:135 / Elemento padre: 133   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(135)).setAttribute("nombre","btnModificarDatosGrupo" );
      ((Element)v.get(135)).setAttribute("ID","botonContenido" );
      ((Element)v.get(135)).setAttribute("tipo","html" );
      ((Element)v.get(135)).setAttribute("accion","accionModificarDatosGrupo();" );
      ((Element)v.get(135)).setAttribute("estado","false" );
      ((Element)v.get(135)).setAttribute("cod","234" );
      ((Element)v.get(133)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */

      /* Empieza nodo:136 / Elemento padre: 133   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(136)).setAttribute("nombre","btnMoverZonas" );
      ((Element)v.get(136)).setAttribute("ID","botonContenido" );
      ((Element)v.get(136)).setAttribute("tipo","html" );
      ((Element)v.get(136)).setAttribute("accion","accionMoverEntreGrupos();" );
      ((Element)v.get(136)).setAttribute("estado","false" );
      ((Element)v.get(136)).setAttribute("cod","233" );
      ((Element)v.get(136)).setAttribute("onshtab","shtabMover();" );
      ((Element)v.get(133)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:131   */
      /* Termina nodo:130   */
      /* Termina nodo:129   */
      /* Termina nodo:128   */
      /* Termina nodo:127   */
      /* Termina nodo:126   */

      /* Empieza nodo:137 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(138)).setAttribute("src","b.gif" );
      ((Element)v.get(138)).setAttribute("width","8" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(138)).setAttribute("height","12" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */
      /* Termina nodo:123   */

      /* Empieza nodo:139 / Elemento padre: 98   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(98)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).setAttribute("width","12" );
      ((Element)v.get(140)).setAttribute("align","center" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(141)).setAttribute("src","b.gif" );
      ((Element)v.get(141)).setAttribute("width","12" );
      ((Element)v.get(141)).setAttribute("height","12" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:142 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).setAttribute("width","156" );
      ((Element)v.get(139)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(143)).setAttribute("src","b.gif" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */

      /* Empieza nodo:144 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(144)).setAttribute("width","12" );
      ((Element)v.get(139)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(145)).setAttribute("src","b.gif" );
      ((Element)v.get(145)).setAttribute("width","12" );
      ((Element)v.get(145)).setAttribute("height","1" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */
      /* Termina nodo:139   */
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:9   */


   }

}
