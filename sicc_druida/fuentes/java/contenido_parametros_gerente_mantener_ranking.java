
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_parametros_gerente_mantener_ranking  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_parametros_gerente_mantener_ranking" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","Insertar concurso de ranking" );
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
      ((Element)v.get(2)).setAttribute("src","pestanyas_concurso_ranking_inc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(3));

      /* Elemento padre:3 / Elemento actual: 4   */
      v.add(doc.createTextNode("\r    \rvar vConstantesPestInc = new Array();\r    \rfunction onLoadPag() {  \r\r    configurarMenuSecundario('formulario');\r    fMostrarMensajeError();\r   \r      \r    var menu = get(\"formulario.opcionMenu\");    \r \r    var forma =  get(\"formulario.oidFormaCalculo\");\r   \r    if (forma != \"\"){\r        marcaSeleccionDelUsuario('formulario.cbFormaCalculo', get('formulario.oidFormaCalculo'));\r    } else {\r        accion(\"formulario.cbBaseCalculo\", \".disabled=true\");\r        accion(\"formulario.cbTipoVenta\", \".disabled=true\");\r    }\r   \r   \r    var calculo = get(\"formulario.oidPlantillaBaseCalculo\");\r    if (calculo != \"\"){\r        accion(\"formulario.cbBaseCalculo\", \".disabled=false\");\r        marcaSeleccionDelUsuario('formulario.cbBaseCalculo', get('formulario.oidPlantillaBaseCalculo'));\r    } else {\r        accion(\"formulario.cbTipoVenta\", \".disabled=true\");\r    }\r   \r    var venta = get(\"formulario.oidTipoVta\");\r      \r    if (venta != \"\"){\r        accion(\"formulario.cbTipoVenta\", \".disabled=false\");\r        marcaSeleccionDelUsuario('formulario.cbTipoVenta', get('formulario.oidTipoVta'));  \r    }\r   \r    \r    if (menu == \"Crear Concurso Ranking\"){\r    \r        accion(\"formulario.cbBaseCalculo\", \".disabled=true\");\r        accion(\"formulario.cbTipoVenta\", \".disabled=true\");\r   \r   }\r   \r   if (get('formulario.hidIndGerentes') == '1'){      \r                                comprobarHabilitacionCombos();\r   }\r   \r   if (menu == \"Modificar Concurso Ranking\"){\r    \r       /* accion(\"formulario.cbBaseCalculo\", \".disabled=true\");\r        accion(\"formulario.cbTipoVenta\", \".disabled=true\");*/\r        \r         btnProxy(2, 1);\r         btnProxy(3, 0);\r         btnProxy(4, 0);\r         btnProxy(7, 0);\r         btnProxy(8, 0);\r         btnProxy(9, 0);        \r   \r   }         \r  \r   var combos= get(\"formulario.cbBaseTipoVenta\");      \r   if (combos==\"SI\"){\r       accion(\"formulario.cbFormaCalculo\", \".disabled=true\");\r       accion(\"formulario.cbBaseCalculo\", \".disabled=true\");\r       accion(\"formulario.cbTipoVenta\", \".disabled=true\");      \r    }\r      \r    var  baseC = get(\"formulario.cbBaseC\");\r    if (baseC ==\"N\"){      \r        accion(\"formulario.cbBaseCalculo\", \".disabled=false\");      \r    }\r  \r    var tipoV = get(\"formulario.cbTipo\");\r    if (tipoV==\"N\"){\r        accion(\"formulario.cbTipoVenta\", \".disabled=false\"); \r    }\r    \r    var vConst = get('formulario.hidConstantesPestINC');\r    vConstantesPestInc = vConst.split(\"|\");\r    \r    if (menu == \"Consultar Concurso Ranking\"){\r         deshabilitaCamposTodos(); \r         btnProxy(1, 0);\r         btnProxy(2, 1);\r         btnProxy(3, 0);\r         btnProxy(4, 0);\r         btnProxy(5, 0);\r         btnProxy(7, 0);\r         btnProxy(8, 0);\r         btnProxy(9, 0);    \r         \r    } else {\r        focoComboFormaCalculo();\r    }\r    \r		finCargaPagina = true;\r    \r}\r\r function marcaSeleccionDelUsuario(pControl, datos){\r		datos = datos.split(\",\");\r		var comb = pControl;\r		set(comb, datos);\r	}\r\r\r function marcaSeleccionDelUsuario(pControl, datos){\r		datos = datos.split(\",\");\r		var comb = pControl;\r		set(comb, datos);\r }\r\r\rfunction focoComboFormaCalculo() {\r	focaliza('formulario.cbFormaCalculo');\r}\r\rfunction focoComboTipoVenta() {\r	focaliza('formulario.cbTipoVenta');\r}\r    \r    \rfunction comprobarHabilitacionCombos(){\r     \r     if ( get('formulario.oid_Forma_Calc_Base_Calc') !=\"\"){           \r        if (get('formulario.oidFormaCalculo') == get('formulario.oid_Forma_Calc_Base_Calc')){        \r         marcaSeleccionDelUsuario('formulario.cbFormaCalculo', get('formulario.oidFormaCalculo'));\r            \r         if (get('formulario.oidPlantillaBaseCalculo') == get('formulario.oidBC_Calculo_Monto')){         \r            accion(\"formulario.cbBaseCalculo\", \".disabled=false\");\r            accion(\"formulario.cbTipoVenta\", \".disabled=false\");\r           \r          \r            if (get('formulario.oidPlantillaBaseCalculo')!= ''){                    marcaSeleccionDelUsuario('formulario.cbBaseCalculo', get('formulario.oidPlantillaBaseCalculo'));\r             }                \r             if (get('formulario.oidTipoVta')!= ''){                   marcaSeleccionDelUsuario('formulario.cbTipoVenta', get('formulario.oidTipoVta'));\r             }                \r        }              \r              accion(\"formulario.cbBaseCalculo\", \".disabled=true\");\r              accion(\"formulario.cbTipoVenta\", \".disabled=true\");             \r                  \r        }       \r        accion(\"formulario.cbBaseCalculo\", \".disabled=true\");\r        accion(\"formulario.cbTipoVenta\", \".disabled=true\");\r      \r    \r     }      else{\r     \r          accion(\"formulario.cbBaseCalculo\", \".disabled=true\");\r          accion(\"formulario.cbTipoVenta\", \".disabled=true\");\r      \r     }\r}    \r\rfunction deshabilitaCamposTodos(){\r      accion(\"formulario.cbBaseCalculo\", \".disabled=true\");\r      accion(\"formulario.cbFormaCalculo\", \".disabled=true\");\r      accion(\"formulario.cbTipoVenta\", \".disabled=true\");\r     /* deshabilitarHabilitarBoton('botonContenido','btnAceptar1','D');\r      deshabilitarHabilitarBoton('botonContenido','btnParticipantes','D');\r      deshabilitarHabilitarBoton('botonContenido','btnAceptar2','D');*/\r}\r    \r\rfunction marcaSeleccionDelUsuario(pControl, datos){\r		datos = datos.split(\",\");\r		var comb = pControl;\r		set(comb, datos);\r}\r\r\r function comprobarDatosObligatorios(){\r\r     var datosObligatorios = true;\r    \r     if(get('formulario.cbFormaCalculo')== ''){\r        datosObligatorios = false;\r        \r     } else if(get('formulario.cbFormaCalculo','V') == get('formulario.oid_Forma_Calc_Base_Calc')){\r     \r         if(get('formulario.cbBaseCalculo')== ''){\r            datosObligatorios = false;\r            \r         } else if(get('formulario.cbBaseCalculo','V') == get('formulario.oidBC_Calculo_Monto')){\r         \r            if(get('formulario.cbTipoVenta')== ''){\r                datosObligatorios = false;\r            }\r         }\r     }\r     \r     return datosObligatorios;            \r  }\r\r function onClickParticipantes(){\r\r     var obj = new Object();\r     obj.opcionMenu = get('formulario.opcionMenu');\r     var whnd = mostrarModalSICC('LPMantenerParametrosGerentesRanking','cargar clasificacion participantes ranking',obj);\r   \r     if (whnd != null){\r     \r            set ('formulario.hidLstClasConsul',whnd[0]);\r            set ('formulario.hidListaClasif',whnd[1]);\r            \r            set('formulario.conectorAction', 'LPMantenerParametrosGerentesRanking');\r            eval('formulario').oculto=\"S\"; \r            set('formulario.accion', 'almacenar Clasificacion Participantes Ranking');\r            enviaSICC('formulario','','','N');\r      }\r\r}\r\rfunction accionExitosa(){\r	eval('formulario').oculto=\"N\";\r}\r\r\rfunction onChangeBaseCalculo(){\r \r  if (get('formulario.cbBaseCalculo','V') == get('formulario.oidBC_Calculo_Monto')){\r           accion(\"formulario.cbTipoVenta\", \".disabled=false\"); \r  }else{\r         set(\"formulario.cbTipoVenta\", \"\"); \r     accion(\"formulario.cbTipoVenta\", \".disabled=true\"); \r  }\r}\r\r\rfunction primerCampo(){\r focaliza(\"formulario.cbFormaCalculo\");\r}\r\rfunction fVolver(){\r      window.close();\r}\r\rfunction focalizaTab(campo){  \r\r  if(campo==1){ \r            \r		if(cbFormaCalculo.disabled == false )\r				 focalizaBotonHTML('botonContenido','btnParticipantes');\r		 else\r				focalizaBotonHTML('botonContenido','btnParticipantes');\r  }else if(campo==2){\r      			if(cbBaseCalculo.disabled == false ){\r				focaliza(\"formulario.cbBaseCalculo\");\r			}else{				\r      primerCampo();\r		}\r    }else if(campo==3){\r      			if( cbTipoVenta.disabled == false ){\r       focaliza(\"formulario.cbTipoVenta\");\r              } \r			else{\r         primerCampo();\r      }  \r		}else if(campo==4){\r      			if( cbTipoVenta.disabled == false ){\r                primerCampo();       \r       } \r    }\r}\r\r\rfunction focalizaShTab(campo){  \r\r    if(campo==1){\r      \r		if(cbTipoVenta.disabled == false ){\r				\r            if(cbBaseCalculo.disabled == false ){\r                focaliza(\"formulario.cbTipoVenta\");\r            }\r		}else{\r            focalizaBotonHTML('botonContenido','btnParticipantes');\r            if(cbBaseCalculo.disabled == false ){\r                focaliza(\"formulario.cbBaseCalculo\");\r            }\r        }\r    }else if(campo==2){\r              focalizaBotonHTML('botonContenido','btnParticipantes');\r    }\r    else if(campo==3){\r        focaliza(\"formulario.cbBaseCalculo\");\r    \r    }\r\r  }\r\r\r\rfunction onChangeFormaCalculo(){\r    if(get('formulario.hidOidFormaCalculo')==get('formulario.oid_Forma_Calc_Vbles_Vta')){\r        if (GestionarMensaje('1573')){\r                      if (get('formulario.cbFormaCalculo','V') == get('formulario.oid_Forma_Calc_Base_Calc')){\r                set(\"formulario.hidOidFormaCalculo\", get('formulario.cbFormaCalculo','V'));\r                               accion(\"formulario.cbBaseCalculo\", \".disabled=false\"); \r                set(\"formulario.hIndEstadoVariablesVenta\", \"N\");\r                \r           }else{\r               set(\"formulario.cbTipoVenta\", \"\");\r               set(\"formulario.cbBaseCalculo\", \"\");\r               \r               set(\"formulario.hidOidFormaCalculo\", get('formulario.cbFormaCalculo','V'));\r               \r               accion(\"formulario.cbTipoVenta\", \".disabled=true\"); \r               accion(\"formulario.cbBaseCalculo\", \".disabled=true\"); \r               set(\"formulario.hIndEstadoVariablesVenta\", \"N\");\r               \r               if (get('formulario.cbFormaCalculo','V') == get('formulario.oid_Forma_Calc_Vbles_Vta')){\r                  set(\"formulario.hIndEstadoVariablesVenta\", \"S\");\r               }\r           }\r                      set('formulario.conectorAction', 'LPMantenerParametrosGerentesRanking');\r           set('formulario.accion', 'Inicializar Variable Venta');\r           eval('formulario').oculto = 'S';\r           enviaSICC('formulario', null, null, 'N');\r            \r        } else {\r            iSeleccionado = new Array(); \r            iSeleccionado[0] = get('formulario.hidOidFormaCalculo');\r            set('formulario.cbFormaCalculo',iSeleccionado);\r            return;\r        }\r    } else {\r      if (get('formulario.cbFormaCalculo','V') == get('formulario.oid_Forma_Calc_Base_Calc')){\r          set(\"formulario.hidOidFormaCalculo\", get('formulario.cbFormaCalculo','V'));\r                   accion(\"formulario.cbBaseCalculo\", \".disabled=false\"); \r          set(\"formulario.hIndEstadoVariablesVenta\", \"N\");\r          \r      }else{\r         set(\"formulario.cbTipoVenta\", \"\");\r         set(\"formulario.cbBaseCalculo\", \"\");\r         \r         set(\"formulario.hidOidFormaCalculo\", get('formulario.cbFormaCalculo','V'));\r         \r         accion(\"formulario.cbTipoVenta\", \".disabled=true\"); \r         accion(\"formulario.cbBaseCalculo\", \".disabled=true\"); \r         set(\"formulario.hIndEstadoVariablesVenta\", \"N\");\r         \r         if (get('formulario.cbFormaCalculo','V') == get('formulario.oid_Forma_Calc_Vbles_Vta')){\r            set(\"formulario.hIndEstadoVariablesVenta\", \"S\");\r         }\r      }\r    }\r}\r\r\rfunction accionGuardar(){\r\r   var vDatosOblig = comprobarDatosObligatorios();   \r  \r   set('formulario.datosObligatorios', vDatosOblig);\r   set('formulario.conectorAction', 'LPMantenerParametrosGerentesRanking');\r   eval('formulario').oculto=\"S\"; \r   \r   set('formulario.accion', 'guardar');\r   enviaSICC('formulario','','','N');\r  \r}\r\r    \rfunction fGuardar(){\r    accionGuardar();\r}\r \r \rfunction accionError(){\r    fMostrarMensajeError();\r}\r \r \r\r function fLimpiar(){\r     if(get('formulario.opcionMenu')!=\"Modificar Concurso Ranking\"){  \r     \r        if (GestionarMensaje('1573')){\r            set(\"formulario.cbFormaCalculo\", \"\");\r            set(\"formulario.cbBaseCalculo\", \"\");\r            set(\"formulario.cbTipoVenta\", \"\");\r            \r            accion(\"formulario.cbTipoVenta\", \".disabled=true\"); \r            accion(\"formulario.cbBaseCalculo\", \".disabled=true\");\r            \r            focaliza(\"formulario.cbFormaCalculo\");\r            \r            set(\"formulario.hIndEstadoVariablesVenta\", \"N\");\r            \r                        set('formulario.conectorAction', 'LPMantenerParametrosGerentesRanking');\r            set('formulario.accion', 'Inicializar Variable Venta');\r            eval('formulario').oculto = 'S';\r            enviaSICC('formulario', null, null, 'N');\r        }\r        \r    } else{\r        set('formulario.conectorAction', 'LPMantenerParametrosGerentesRanking'); \r        set('formulario.accion', '');\r        eval('formulario').oculto = 'N';\r        enviaSICC('formulario',null,null,'N');\r    }\r }\r \r \r function accionError(){\r        fMostrarMensajeError();\r  }\r  \r  \r function guardarKO(){\r    if(get('formulario.opcionMenu')==\"Modificar Concurso Ranking\"){  \r          btnProxy(1,1);\r          btnProxy(2,1);\r          btnProxy(3,0);\r          btnProxy(4,0);\r          btnProxy(5,1);\r          btnProxy(7,0);\r          btnProxy(8,0);\r          btnProxy(9,0);\r          \r          focaliza('formulario.cbFormaCalculo');\r          \r      } else {\r          focaliza('formulario.cbFormaCalculo');\r      }\r }\r\r  function inicializoVariableVenta(){\r      if(get('formulario.opcionMenu')==\"Modificar Concurso Ranking\"){  \r          btnProxy(1,1);\r          btnProxy(2,1);\r          btnProxy(3,0);\r          btnProxy(4,0);\r          btnProxy(5,1);\r          btnProxy(7,0);\r          btnProxy(8,0);\r          btnProxy(9,0);\r          \r          focaliza('formulario.cbFormaCalculo');\r          \r      } else {\r          focaliza('formulario.cbFormaCalculo');\r      }\r  }\r\r\r\r\r\r\r\r\r"));
      ((Element)v.get(3)).appendChild((Text)v.get(4));

      /* Termina nodo Texto:4   */
      /* Termina nodo:3   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(6)).setAttribute("name","cbFormaCalculo" );
      ((Element)v.get(6)).setAttribute("required","true" );
      ((Element)v.get(6)).setAttribute("group","grupo1" );
      ((Element)v.get(6)).setAttribute("cod","00288" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","cbBaseCalculo" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","1181" );
      ((Element)v.get(7)).setAttribute("group","grupo1" );
      ((Element)v.get(5)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cbTipoVenta" );
      ((Element)v.get(8)).setAttribute("required","false" );
      ((Element)v.get(8)).setAttribute("cod","1622" );
      ((Element)v.get(8)).setAttribute("group","grupo1" );
      ((Element)v.get(5)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */
      /* Termina nodo:5   */

      /* Empieza nodo:9 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(9)).setAttribute("nombre","formulario" );
      ((Element)v.get(9)).setAttribute("oculto","N" );
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
      ((Element)v.get(11)).setAttribute("valor","" );
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
      ((Element)v.get(14)).setAttribute("nombre","idPestanyaDest" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","datosObligatorios" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","oidBaseCalculo" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","oidVariablesVenta" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hidIndGerentes" );
      ((Element)v.get(19)).setAttribute("valor","0" );
      ((Element)v.get(9)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hidListaClasif" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hidLstClasConsul" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","hidLstMVR" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","hidIngresoPAR" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hidVariablesVenta" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","pestania" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","oidParamGerentes" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","oidFormaCalculo" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","oidPlantillaBaseCalculo" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","oidParamBaseCalculo" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hidConstantesPestINC" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","oidBC_Calculo_Monto" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","oid_Forma_Calc_Base_Calc" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","oid_Forma_Calc_Vbles_Vta" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","oidTipoVta" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","ocultaParticipante" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","hIndEstadoParametrosGerentes" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","hIndEstadoParametrosConsultoras" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","hIndEstadoVariablesVenta" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","cbBaseTipoVenta" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","cbBaseC" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","cbTipo" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","hidOidFormaCalculo" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 9   */
      v.add(doc.createElement("table"));
      ((Element)v.get(43)).setAttribute("width","100%" );
      ((Element)v.get(43)).setAttribute("height","100%" );
      ((Element)v.get(43)).setAttribute("border","0" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(43)).setAttribute("align","center" );
      ((Element)v.get(43)).setAttribute("cellpadding","0" );
      ((Element)v.get(43)).setAttribute("cellspacing","0" );
      ((Element)v.get(43)).setAttribute("class","menu4" );
      ((Element)v.get(9)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).setAttribute("width","12" );
      ((Element)v.get(45)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(45)).setAttribute("class","menu5texto" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(46)).setAttribute("src","b.gif" );
      ((Element)v.get(46)).setAttribute("width","12" );
      ((Element)v.get(46)).setAttribute("height","30" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:47 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(47)).setAttribute("class","menu5texto" );
      ((Element)v.get(44)).appendChild((Element)v.get(47));

      /* Elemento padre:47 / Elemento actual: 48   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(47)).appendChild((Text)v.get(48));

      /* Termina nodo Texto:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:49 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).setAttribute("width","10" );
      ((Element)v.get(49)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(49)).setAttribute("class","menu5texto" );
      ((Element)v.get(44)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(50)).setAttribute("src","b.gif" );
      ((Element)v.get(50)).setAttribute("width","10" );
      ((Element)v.get(50)).setAttribute("height","8" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:51 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).setAttribute("width","92" );
      ((Element)v.get(51)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(51)).setAttribute("class","menu5texto" );
      ((Element)v.get(44)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("table"));
      ((Element)v.get(52)).setAttribute("width","75" );
      ((Element)v.get(52)).setAttribute("border","1" );
      ((Element)v.get(52)).setAttribute("align","center" );
      ((Element)v.get(52)).setAttribute("cellpadding","1" );
      ((Element)v.get(52)).setAttribute("cellspacing","0" );
      ((Element)v.get(52)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(52)).setAttribute("onmouseover","activarPuntero('formulario', 1, 'lblDatosGenerales');" );
      ((Element)v.get(52)).setAttribute("onclick","onClickPestanyaHabilitada(1, 'formulario', 'LPMantenerParametrosGerentesRanking');" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(53)).setAttribute("align","center" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(54)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(55)).setAttribute("nombre","lblDatosGenerales" );
      ((Element)v.get(55)).setAttribute("alto","13" );
      ((Element)v.get(55)).setAttribute("filas","1" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(55)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(55)).setAttribute("cod","0011" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */
      /* Termina nodo:53   */
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:56 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).setAttribute("width","10" );
      ((Element)v.get(56)).setAttribute("class","menu5texto" );
      ((Element)v.get(44)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(57)).setAttribute("src","b.gif" );
      ((Element)v.get(57)).setAttribute("width","10" );
      ((Element)v.get(57)).setAttribute("height","8" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:58 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).setAttribute("width","20" );
      ((Element)v.get(58)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(58)).setAttribute("class","menu5texto" );
      ((Element)v.get(44)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("table"));
      ((Element)v.get(59)).setAttribute("width","75" );
      ((Element)v.get(59)).setAttribute("border","1" );
      ((Element)v.get(59)).setAttribute("align","center" );
      ((Element)v.get(59)).setAttribute("cellpadding","1" );
      ((Element)v.get(59)).setAttribute("cellspacing","0" );
      ((Element)v.get(59)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(59)).setAttribute("onmouseover","activarPuntero('formulario', 2, 'lblAlcanceGeografico');" );
      ((Element)v.get(59)).setAttribute("onclick","onClickPestanyaHabilitada(2, 'formulario', 'LPMantenerParametrosGerentesRanking');" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(60)).setAttribute("align","center" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(61)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(62)).setAttribute("nombre","lblAlcanceGeografico" );
      ((Element)v.get(62)).setAttribute("alto","13" );
      ((Element)v.get(62)).setAttribute("filas","1" );
      ((Element)v.get(62)).setAttribute("valor","" );
      ((Element)v.get(62)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(62)).setAttribute("cod","00368" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */
      /* Termina nodo:60   */
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:63 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).setAttribute("width","10" );
      ((Element)v.get(63)).setAttribute("class","menu5texto" );
      ((Element)v.get(44)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(64)).setAttribute("src","b.gif" );
      ((Element)v.get(64)).setAttribute("width","10" );
      ((Element)v.get(64)).setAttribute("height","8" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).setAttribute("width","20" );
      ((Element)v.get(65)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(65)).setAttribute("class","menu5texto" );
      ((Element)v.get(44)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("table"));
      ((Element)v.get(66)).setAttribute("width","75" );
      ((Element)v.get(66)).setAttribute("border","1" );
      ((Element)v.get(66)).setAttribute("align","center" );
      ((Element)v.get(66)).setAttribute("cellpadding","1" );
      ((Element)v.get(66)).setAttribute("cellspacing","0" );
      ((Element)v.get(66)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(66)).setAttribute("bgcolor","#496A9A" );
      ((Element)v.get(66)).setAttribute("onmouseover","activarPuntero('formulario', 3, 'lblParametrosGerentes');" );
      ((Element)v.get(66)).setAttribute("onclick","onClickPestanyaHabilitada(3, 'formulario', 'LPMantenerParametrosGerentesRanking');" );
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
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(69)).setAttribute("nombre","lblParametrosGerentes" );
      ((Element)v.get(69)).setAttribute("alto","13" );
      ((Element)v.get(69)).setAttribute("filas","1" );
      ((Element)v.get(69)).setAttribute("valor","" );
      ((Element)v.get(69)).setAttribute("id","menu5textoblanca" );
      ((Element)v.get(69)).setAttribute("cod","00594" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:70 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).setAttribute("width","10" );
      ((Element)v.get(70)).setAttribute("class","menu5texto" );
      ((Element)v.get(44)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(71)).setAttribute("src","b.gif" );
      ((Element)v.get(71)).setAttribute("width","10" );
      ((Element)v.get(71)).setAttribute("height","8" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:72 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).setAttribute("width","20" );
      ((Element)v.get(72)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(72)).setAttribute("class","menu5texto" );
      ((Element)v.get(44)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("table"));
      ((Element)v.get(73)).setAttribute("width","75" );
      ((Element)v.get(73)).setAttribute("border","1" );
      ((Element)v.get(73)).setAttribute("align","center" );
      ((Element)v.get(73)).setAttribute("cellpadding","1" );
      ((Element)v.get(73)).setAttribute("cellspacing","0" );
      ((Element)v.get(73)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(73)).setAttribute("onmouseover","activarPuntero('formulario', 4, 'lblParametrosConsultoras');" );
      ((Element)v.get(73)).setAttribute("onclick","onClickPestanyaHabilitada(4, 'formulario', 'LPMantenerParametrosGerentesRanking');" );
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
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(76)).setAttribute("nombre","lblParametrosConsultoras" );
      ((Element)v.get(76)).setAttribute("alto","13" );
      ((Element)v.get(76)).setAttribute("filas","1" );
      ((Element)v.get(76)).setAttribute("valor","" );
      ((Element)v.get(76)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(76)).setAttribute("cod","00595" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:77 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).setAttribute("width","16" );
      ((Element)v.get(77)).setAttribute("class","menu5texto" );
      ((Element)v.get(44)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(78)).setAttribute("width","12" );
      ((Element)v.get(78)).setAttribute("height","8" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:79 / Elemento padre: 9   */
      v.add(doc.createElement("table"));
      ((Element)v.get(79)).setAttribute("width","100%" );
      ((Element)v.get(79)).setAttribute("height","100%" );
      ((Element)v.get(79)).setAttribute("border","0" );
      ((Element)v.get(79)).setAttribute("align","center" );
      ((Element)v.get(79)).setAttribute("cellpadding","0" );
      ((Element)v.get(79)).setAttribute("cellspacing","0" );
      ((Element)v.get(79)).setAttribute("class","menu4" );
      ((Element)v.get(9)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(79)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(81)).setAttribute("width","12" );
      ((Element)v.get(81)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(81)).setAttribute("class","menu5texto" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(82)).setAttribute("width","12" );
      ((Element)v.get(82)).setAttribute("height","30" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(83)).setAttribute("class","menu5texto" );
      ((Element)v.get(80)).appendChild((Element)v.get(83));

      /* Elemento padre:83 / Elemento actual: 84   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(83)).appendChild((Text)v.get(84));

      /* Termina nodo Texto:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:85 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).setAttribute("width","10" );
      ((Element)v.get(85)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(85)).setAttribute("class","menu5texto" );
      ((Element)v.get(80)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).setAttribute("width","10" );
      ((Element)v.get(86)).setAttribute("height","8" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).setAttribute("width","20" );
      ((Element)v.get(87)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(87)).setAttribute("class","menu5texto" );
      ((Element)v.get(80)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("table"));
      ((Element)v.get(88)).setAttribute("width","75" );
      ((Element)v.get(88)).setAttribute("border","1" );
      ((Element)v.get(88)).setAttribute("align","center" );
      ((Element)v.get(88)).setAttribute("cellpadding","1" );
      ((Element)v.get(88)).setAttribute("cellspacing","0" );
      ((Element)v.get(88)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(88)).setAttribute("onmouseover","activarPuntero('formulario', 5, 'lblProductos');" );
      ((Element)v.get(88)).setAttribute("onclick","onClickPestanyaHabilitada(5,'formulario', 'LPMantenerParametrosGerentesRanking');" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(89)).setAttribute("align","center" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(90)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(91)).setAttribute("nombre","lblProductos" );
      ((Element)v.get(91)).setAttribute("alto","13" );
      ((Element)v.get(91)).setAttribute("filas","1" );
      ((Element)v.get(91)).setAttribute("valor","" );
      ((Element)v.get(91)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(91)).setAttribute("cod","0094" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:92 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).setAttribute("width","10" );
      ((Element)v.get(92)).setAttribute("class","menu5texto" );
      ((Element)v.get(80)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","b.gif" );
      ((Element)v.get(93)).setAttribute("width","10" );
      ((Element)v.get(93)).setAttribute("height","8" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:94 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).setAttribute("width","20" );
      ((Element)v.get(94)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(94)).setAttribute("class","menu5texto" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(80)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("table"));
      ((Element)v.get(95)).setAttribute("width","75" );
      ((Element)v.get(95)).setAttribute("border","1" );
      ((Element)v.get(95)).setAttribute("align","center" );
      ((Element)v.get(95)).setAttribute("cellpadding","1" );
      ((Element)v.get(95)).setAttribute("cellspacing","0" );
      ((Element)v.get(95)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(95)).setAttribute("onmouseover","activarPuntero('formulario', 6, 'lblPremios');" );
      ((Element)v.get(95)).setAttribute("onclick","onClickPestanyaHabilitada(6, 'formulario', 'LPMantenerParametrosGerentesRanking');" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(96)).setAttribute("align","center" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(97)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(98)).setAttribute("nombre","lblPremios" );
      ((Element)v.get(98)).setAttribute("alto","13" );
      ((Element)v.get(98)).setAttribute("filas","1" );
      ((Element)v.get(98)).setAttribute("valor","" );
      ((Element)v.get(98)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(98)).setAttribute("cod","00394" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:99 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).setAttribute("width","10" );
      ((Element)v.get(99)).setAttribute("class","menu5texto" );
      ((Element)v.get(80)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(100)).setAttribute("src","b.gif" );
      ((Element)v.get(100)).setAttribute("width","10" );
      ((Element)v.get(100)).setAttribute("height","8" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:101 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(101)).setAttribute("width","20" );
      ((Element)v.get(101)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(101)).setAttribute("class","menu5texto" );
      ((Element)v.get(80)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("table"));
      ((Element)v.get(102)).setAttribute("width","75" );
      ((Element)v.get(102)).setAttribute("border","1" );
      ((Element)v.get(102)).setAttribute("align","center" );
      ((Element)v.get(102)).setAttribute("cellpadding","1" );
      ((Element)v.get(102)).setAttribute("cellspacing","0" );
      ((Element)v.get(102)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(102)).setAttribute("onmouseover","activarPuntero('formulario', 7, 'lblVariablesVenta');" );
      ((Element)v.get(102)).setAttribute("onclick","onClickPestanyaHabilitada(7, 'formulario', 'LPMantenerParametrosGerentesRanking');" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(103)).setAttribute("align","center" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(104)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(105)).setAttribute("nombre","lblVariablesVenta" );
      ((Element)v.get(105)).setAttribute("alto","13" );
      ((Element)v.get(105)).setAttribute("filas","1" );
      ((Element)v.get(105)).setAttribute("valor","" );
      ((Element)v.get(105)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(105)).setAttribute("cod","1951" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:106 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).setAttribute("width","16" );
      ((Element)v.get(106)).setAttribute("class","menu5texto" );
      ((Element)v.get(80)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(107)).setAttribute("src","b.gif" );
      ((Element)v.get(107)).setAttribute("width","12" );
      ((Element)v.get(107)).setAttribute("height","8" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:108 / Elemento padre: 9   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(108)).setAttribute("nombre","capa1" );
      ((Element)v.get(108)).setAttribute("alto","110" );
      ((Element)v.get(108)).setAttribute("ancho","100%" );
      ((Element)v.get(108)).setAttribute("colorf","" );
      ((Element)v.get(108)).setAttribute("borde","0" );
      ((Element)v.get(108)).setAttribute("imagenf","" );
      ((Element)v.get(108)).setAttribute("repeat","" );
      ((Element)v.get(108)).setAttribute("padding","" );
      ((Element)v.get(108)).setAttribute("visibilidad","visible" );
      ((Element)v.get(108)).setAttribute("contravsb","" );
      ((Element)v.get(108)).setAttribute("x","0" );
      ((Element)v.get(108)).setAttribute("y","70" );
      ((Element)v.get(108)).setAttribute("zindex","" );
      ((Element)v.get(9)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("table"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(109)).setAttribute("width","100%" );
      ((Element)v.get(109)).setAttribute("border","0" );
      ((Element)v.get(109)).setAttribute("cellspacing","0" );
      ((Element)v.get(109)).setAttribute("cellpadding","0" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).setAttribute("width","12" );
      ((Element)v.get(111)).setAttribute("align","center" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(112)).setAttribute("src","b.gif" );
      ((Element)v.get(112)).setAttribute("width","12" );
      ((Element)v.get(112)).setAttribute("height","12" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:113 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).setAttribute("width","750" );
      ((Element)v.get(110)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(114)).setAttribute("src","b.gif" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:115 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).setAttribute("width","12" );
      ((Element)v.get(110)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(116)).setAttribute("src","b.gif" );
      ((Element)v.get(116)).setAttribute("width","12" );
      ((Element)v.get(116)).setAttribute("height","1" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */
      /* Termina nodo:110   */

      /* Empieza nodo:117 / Elemento padre: 109   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(109)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(119)).setAttribute("src","b.gif" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:120 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(120)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(122)).setAttribute("class","legend" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(123)).setAttribute("nombre","lblDatosAdicionales" );
      ((Element)v.get(123)).setAttribute("alto","13" );
      ((Element)v.get(123)).setAttribute("filas","1" );
      ((Element)v.get(123)).setAttribute("valor","" );
      ((Element)v.get(123)).setAttribute("id","legend" );
      ((Element)v.get(123)).setAttribute("cod","0052" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:124 / Elemento padre: 121   */
      v.add(doc.createElement("table"));
      ((Element)v.get(124)).setAttribute("width","100%" );
      ((Element)v.get(124)).setAttribute("border","0" );
      ((Element)v.get(124)).setAttribute("align","center" );
      ((Element)v.get(124)).setAttribute("cellspacing","0" );
      ((Element)v.get(124)).setAttribute("cellpadding","0" );
      ((Element)v.get(121)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("table"));
      ((Element)v.get(127)).setAttribute("width","696" );
      ((Element)v.get(127)).setAttribute("border","0" );
      ((Element)v.get(127)).setAttribute("align","left" );
      ((Element)v.get(127)).setAttribute("cellspacing","0" );
      ((Element)v.get(127)).setAttribute("cellpadding","0" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).setAttribute("colspan","4" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(130)).setAttribute("src","b.gif" );
      ((Element)v.get(130)).setAttribute("width","8" );
      ((Element)v.get(130)).setAttribute("height","8" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:131 / Elemento padre: 127   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(127)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(133)).setAttribute("src","b.gif" );
      ((Element)v.get(133)).setAttribute("width","8" );
      ((Element)v.get(133)).setAttribute("height","8" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:134 / Elemento padre: 131   */
      v.add(doc.createElement("td"));
   }

   private void getXML630(Document doc) {
      ((Element)v.get(131)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(135)).setAttribute("nombre","lblFormaCalculo1" );
      ((Element)v.get(135)).setAttribute("alto","13" );
      ((Element)v.get(135)).setAttribute("filas","1" );
      ((Element)v.get(135)).setAttribute("valor","" );
      ((Element)v.get(135)).setAttribute("id","datosTitle" );
      ((Element)v.get(135)).setAttribute("cod","1671" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 131   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).setAttribute("width","100%" );
      ((Element)v.get(131)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(137)).setAttribute("src","b.gif" );
      ((Element)v.get(137)).setAttribute("width","266" );
      ((Element)v.get(137)).setAttribute("height","8" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */
      /* Termina nodo:131   */

      /* Empieza nodo:138 / Elemento padre: 127   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(127)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(140)).setAttribute("src","b.gif" );
      ((Element)v.get(140)).setAttribute("width","8" );
      ((Element)v.get(140)).setAttribute("height","8" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:141 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(141)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(138)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(142)).setAttribute("nombre","cbFormaCalculo" );
      ((Element)v.get(142)).setAttribute("id","datosCampos" );
      ((Element)v.get(142)).setAttribute("size","1" );
      ((Element)v.get(142)).setAttribute("multiple","N" );
      ((Element)v.get(142)).setAttribute("req","S" );
      ((Element)v.get(142)).setAttribute("valorinicial","" );
      ((Element)v.get(142)).setAttribute("textoinicial","" );
      ((Element)v.get(142)).setAttribute("onshtab","focalizaShTab(1);" );
      ((Element)v.get(142)).setAttribute("onchange","onChangeFormaCalculo();" );
      ((Element)v.get(142)).setAttribute("ontab","focalizaTab(1);" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:144 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(144)).setAttribute("width","100%" );
      ((Element)v.get(138)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(145)).setAttribute("src","b.gif" );
      ((Element)v.get(145)).setAttribute("width","8" );
      ((Element)v.get(145)).setAttribute("height","8" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */
      /* Termina nodo:138   */

      /* Empieza nodo:146 / Elemento padre: 127   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(127)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).setAttribute("colspan","4" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(148)).setAttribute("src","b.gif" );
      ((Element)v.get(148)).setAttribute("width","8" );
      ((Element)v.get(148)).setAttribute("height","8" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */
      /* Termina nodo:146   */
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:149 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(150)).setAttribute("src","b.gif" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */
      /* Termina nodo:117   */

      /* Empieza nodo:151 / Elemento padre: 109   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(109)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("td"));
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(153)).setAttribute("src","b.gif" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */

      /* Empieza nodo:154 / Elemento padre: 151   */
      v.add(doc.createElement("td"));
      ((Element)v.get(151)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("table"));
      ((Element)v.get(156)).setAttribute("width","100%" );
      ((Element)v.get(156)).setAttribute("border","0" );
      ((Element)v.get(156)).setAttribute("align","center" );
      ((Element)v.get(156)).setAttribute("cellspacing","0" );
      ((Element)v.get(156)).setAttribute("cellpadding","0" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(156)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).setAttribute("class","botonera" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("BOTON"));
   }

   private void getXML720(Document doc) {
      ((Element)v.get(159)).setAttribute("nombre","btnParticipantes" );
      ((Element)v.get(159)).setAttribute("ID","botonContenido" );
      ((Element)v.get(159)).setAttribute("tipo","html" );
      ((Element)v.get(159)).setAttribute("accion","onClickParticipantes();" );
      ((Element)v.get(159)).setAttribute("estado","false" );
      ((Element)v.get(159)).setAttribute("cod","745" );
      ((Element)v.get(159)).setAttribute("ontab","focalizaTab(2);" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */
      /* Termina nodo:157   */
      /* Termina nodo:156   */
      /* Termina nodo:155   */
      /* Termina nodo:154   */

      /* Empieza nodo:160 / Elemento padre: 151   */
      v.add(doc.createElement("td"));
      ((Element)v.get(151)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(161)).setAttribute("src","b.gif" );
      ((Element)v.get(161)).setAttribute("width","8" );
      ((Element)v.get(161)).setAttribute("height","12" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */
      /* Termina nodo:151   */

      /* Empieza nodo:162 / Elemento padre: 109   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(109)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).setAttribute("width","12" );
      ((Element)v.get(163)).setAttribute("align","center" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(164)).setAttribute("src","b.gif" );
      ((Element)v.get(164)).setAttribute("width","12" );
      ((Element)v.get(164)).setAttribute("height","12" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:165 / Elemento padre: 162   */
      v.add(doc.createElement("td"));
      ((Element)v.get(165)).setAttribute("width","756" );
      ((Element)v.get(162)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(166)).setAttribute("src","b.gif" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:167 / Elemento padre: 162   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).setAttribute("width","12" );
      ((Element)v.get(162)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(168)).setAttribute("src","b.gif" );
      ((Element)v.get(168)).setAttribute("width","12" );
      ((Element)v.get(168)).setAttribute("height","1" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */
      /* Termina nodo:162   */
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:169 / Elemento padre: 9   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(169)).setAttribute("nombre","capa2" );
      ((Element)v.get(169)).setAttribute("alto","110" );
      ((Element)v.get(169)).setAttribute("ancho","100%" );
      ((Element)v.get(169)).setAttribute("colorf","" );
      ((Element)v.get(169)).setAttribute("borde","0" );
      ((Element)v.get(169)).setAttribute("imagenf","" );
      ((Element)v.get(169)).setAttribute("repeat","" );
      ((Element)v.get(169)).setAttribute("padding","" );
      ((Element)v.get(169)).setAttribute("visibilidad","visible" );
      ((Element)v.get(169)).setAttribute("contravsb","" );
      ((Element)v.get(169)).setAttribute("x","0" );
      ((Element)v.get(169)).setAttribute("y","175" );
      ((Element)v.get(169)).setAttribute("zindex","" );
      ((Element)v.get(9)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("table"));
      ((Element)v.get(170)).setAttribute("width","100%" );
      ((Element)v.get(170)).setAttribute("border","0" );
      ((Element)v.get(170)).setAttribute("cellspacing","0" );
      ((Element)v.get(170)).setAttribute("cellpadding","0" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(170)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).setAttribute("width","12" );
      ((Element)v.get(172)).setAttribute("align","center" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(173)).setAttribute("src","b.gif" );
      ((Element)v.get(173)).setAttribute("width","12" );
      ((Element)v.get(173)).setAttribute("height","12" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:172   */

      /* Empieza nodo:174 / Elemento padre: 171   */
      v.add(doc.createElement("td"));
      ((Element)v.get(174)).setAttribute("width","750" );
      ((Element)v.get(171)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(175)).setAttribute("src","b.gif" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */

      /* Empieza nodo:176 / Elemento padre: 171   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).setAttribute("width","12" );
      ((Element)v.get(171)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(177)).setAttribute("src","b.gif" );
      ((Element)v.get(177)).setAttribute("width","12" );
      ((Element)v.get(177)).setAttribute("height","1" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */
      /* Termina nodo:171   */

      /* Empieza nodo:178 / Elemento padre: 170   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(170)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
   }

   private void getXML810(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(180)).setAttribute("src","b.gif" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:181 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(181)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(183)).setAttribute("class","legend" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(184)).setAttribute("nombre","lblFormaCalculo2" );
      ((Element)v.get(184)).setAttribute("alto","13" );
      ((Element)v.get(184)).setAttribute("filas","1" );
      ((Element)v.get(184)).setAttribute("valor","" );
      ((Element)v.get(184)).setAttribute("id","legend" );
      ((Element)v.get(184)).setAttribute("cod","00288" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:185 / Elemento padre: 182   */
      v.add(doc.createElement("table"));
      ((Element)v.get(185)).setAttribute("width","100%" );
      ((Element)v.get(185)).setAttribute("border","0" );
      ((Element)v.get(185)).setAttribute("align","center" );
      ((Element)v.get(185)).setAttribute("cellspacing","0" );
      ((Element)v.get(185)).setAttribute("cellpadding","0" );
      ((Element)v.get(182)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(185)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("td"));
      ((Element)v.get(186)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("table"));
      ((Element)v.get(188)).setAttribute("width","696" );
      ((Element)v.get(188)).setAttribute("border","0" );
      ((Element)v.get(188)).setAttribute("align","left" );
      ((Element)v.get(188)).setAttribute("cellspacing","0" );
      ((Element)v.get(188)).setAttribute("cellpadding","0" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(188)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("td"));
      ((Element)v.get(190)).setAttribute("colspan","4" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(191)).setAttribute("src","b.gif" );
      ((Element)v.get(191)).setAttribute("width","8" );
      ((Element)v.get(191)).setAttribute("height","8" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:192 / Elemento padre: 188   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(188)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("td"));
      ((Element)v.get(192)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(194)).setAttribute("src","b.gif" );
      ((Element)v.get(194)).setAttribute("width","8" );
      ((Element)v.get(194)).setAttribute("height","8" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */

      /* Empieza nodo:195 / Elemento padre: 192   */
      v.add(doc.createElement("td"));
      ((Element)v.get(192)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(196)).setAttribute("nombre","lblBaseCalculo" );
      ((Element)v.get(196)).setAttribute("alto","13" );
      ((Element)v.get(196)).setAttribute("filas","1" );
      ((Element)v.get(196)).setAttribute("valor","" );
      ((Element)v.get(196)).setAttribute("id","datosTitle" );
      ((Element)v.get(196)).setAttribute("cod","1181" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */

      /* Empieza nodo:197 / Elemento padre: 192   */
      v.add(doc.createElement("td"));
      ((Element)v.get(197)).setAttribute("width","100%" );
      ((Element)v.get(192)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(198)).setAttribute("src","b.gif" );
      ((Element)v.get(198)).setAttribute("width","8" );
      ((Element)v.get(198)).setAttribute("height","8" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */
      /* Termina nodo:192   */

      /* Empieza nodo:199 / Elemento padre: 188   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(188)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(201)).setAttribute("src","b.gif" );
      ((Element)v.get(201)).setAttribute("width","8" );
      ((Element)v.get(201)).setAttribute("height","8" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */

      /* Empieza nodo:202 / Elemento padre: 199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(202)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(199)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(203)).setAttribute("nombre","cbBaseCalculo" );
      ((Element)v.get(203)).setAttribute("id","datosCampos" );
      ((Element)v.get(203)).setAttribute("size","1" );
      ((Element)v.get(203)).setAttribute("multiple","N" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(203)).setAttribute("req","S" );
      ((Element)v.get(203)).setAttribute("valorinicial","" );
      ((Element)v.get(203)).setAttribute("textoinicial","" );
      ((Element)v.get(203)).setAttribute("onchange","onChangeBaseCalculo();" );
      ((Element)v.get(203)).setAttribute("ontab","focalizaTab(3);" );
      ((Element)v.get(203)).setAttribute("onshtab","focalizaShTab(2);" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */
      /* Termina nodo:202   */

      /* Empieza nodo:205 / Elemento padre: 199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).setAttribute("width","100%" );
      ((Element)v.get(199)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(206)).setAttribute("src","b.gif" );
      ((Element)v.get(206)).setAttribute("width","8" );
      ((Element)v.get(206)).setAttribute("height","8" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */
      /* Termina nodo:199   */

      /* Empieza nodo:207 / Elemento padre: 188   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(188)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("td"));
      ((Element)v.get(208)).setAttribute("colspan","4" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(209)).setAttribute("src","b.gif" );
      ((Element)v.get(209)).setAttribute("width","8" );
      ((Element)v.get(209)).setAttribute("height","8" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */
      /* Termina nodo:207   */
      /* Termina nodo:188   */
      /* Termina nodo:187   */
      /* Termina nodo:186   */
      /* Termina nodo:185   */
      /* Termina nodo:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:210 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(211)).setAttribute("src","b.gif" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */
      /* Termina nodo:178   */

      /* Empieza nodo:212 / Elemento padre: 170   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(170)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("td"));
      ((Element)v.get(213)).setAttribute("width","12" );
      ((Element)v.get(213)).setAttribute("align","center" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(214)).setAttribute("src","b.gif" );
      ((Element)v.get(214)).setAttribute("width","12" );
      ((Element)v.get(214)).setAttribute("height","15" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */

      /* Empieza nodo:215 / Elemento padre: 212   */
      v.add(doc.createElement("td"));
      ((Element)v.get(215)).setAttribute("width","756" );
      ((Element)v.get(212)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(216)).setAttribute("src","b.gif" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */
      /* Termina nodo:215   */

      /* Empieza nodo:217 / Elemento padre: 212   */
      v.add(doc.createElement("td"));
      ((Element)v.get(217)).setAttribute("width","12" );
      ((Element)v.get(212)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(218)).setAttribute("src","b.gif" );
      ((Element)v.get(218)).setAttribute("width","12" );
      ((Element)v.get(218)).setAttribute("height","1" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */
      /* Termina nodo:217   */
      /* Termina nodo:212   */
      /* Termina nodo:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:219 / Elemento padre: 9   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(219)).setAttribute("nombre","capa3" );
      ((Element)v.get(219)).setAttribute("alto","120" );
      ((Element)v.get(219)).setAttribute("ancho","100%" );
      ((Element)v.get(219)).setAttribute("colorf","" );
      ((Element)v.get(219)).setAttribute("borde","0" );
      ((Element)v.get(219)).setAttribute("imagenf","" );
      ((Element)v.get(219)).setAttribute("repeat","" );
      ((Element)v.get(219)).setAttribute("padding","" );
      ((Element)v.get(219)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(219)).setAttribute("contravsb","" );
      ((Element)v.get(219)).setAttribute("x","0" );
      ((Element)v.get(219)).setAttribute("y","255" );
      ((Element)v.get(219)).setAttribute("zindex","" );
      ((Element)v.get(9)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("table"));
      ((Element)v.get(220)).setAttribute("width","100%" );
      ((Element)v.get(220)).setAttribute("border","0" );
      ((Element)v.get(220)).setAttribute("cellspacing","0" );
      ((Element)v.get(220)).setAttribute("cellpadding","0" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(220)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("td"));
      ((Element)v.get(222)).setAttribute("width","12" );
      ((Element)v.get(222)).setAttribute("align","center" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(223)).setAttribute("src","b.gif" );
      ((Element)v.get(223)).setAttribute("width","12" );
      ((Element)v.get(223)).setAttribute("height","12" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:222   */

      /* Empieza nodo:224 / Elemento padre: 221   */
      v.add(doc.createElement("td"));
   }

   private void getXML990(Document doc) {
      ((Element)v.get(224)).setAttribute("width","750" );
      ((Element)v.get(221)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(225)).setAttribute("src","b.gif" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */

      /* Empieza nodo:226 / Elemento padre: 221   */
      v.add(doc.createElement("td"));
      ((Element)v.get(226)).setAttribute("width","12" );
      ((Element)v.get(221)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(227)).setAttribute("src","b.gif" );
      ((Element)v.get(227)).setAttribute("width","12" );
      ((Element)v.get(227)).setAttribute("height","1" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */
      /* Termina nodo:221   */

      /* Empieza nodo:228 / Elemento padre: 220   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(220)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("td"));
      ((Element)v.get(228)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(230)).setAttribute("src","b.gif" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */

      /* Empieza nodo:231 / Elemento padre: 228   */
      v.add(doc.createElement("td"));
      ((Element)v.get(228)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(231)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(233)).setAttribute("class","legend" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(234)).setAttribute("nombre","lblRecomendadas" );
      ((Element)v.get(234)).setAttribute("alto","13" );
      ((Element)v.get(234)).setAttribute("filas","1" );
      ((Element)v.get(234)).setAttribute("valor","" );
      ((Element)v.get(234)).setAttribute("id","legend" );
      ((Element)v.get(234)).setAttribute("cod","00289" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */
      /* Termina nodo:233   */

      /* Empieza nodo:235 / Elemento padre: 232   */
      v.add(doc.createElement("table"));
      ((Element)v.get(235)).setAttribute("width","100%" );
      ((Element)v.get(235)).setAttribute("border","0" );
      ((Element)v.get(235)).setAttribute("align","center" );
      ((Element)v.get(235)).setAttribute("cellspacing","0" );
      ((Element)v.get(235)).setAttribute("cellpadding","0" );
      ((Element)v.get(232)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(235)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(236)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("table"));
      ((Element)v.get(238)).setAttribute("width","696" );
      ((Element)v.get(238)).setAttribute("border","0" );
      ((Element)v.get(238)).setAttribute("align","left" );
      ((Element)v.get(238)).setAttribute("cellspacing","0" );
      ((Element)v.get(238)).setAttribute("cellpadding","0" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(238)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("td"));
      ((Element)v.get(240)).setAttribute("colspan","4" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(241)).setAttribute("src","b.gif" );
      ((Element)v.get(241)).setAttribute("width","8" );
      ((Element)v.get(241)).setAttribute("height","8" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */
      /* Termina nodo:240   */
      /* Termina nodo:239   */

      /* Empieza nodo:242 / Elemento padre: 238   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(238)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("td"));
      ((Element)v.get(242)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(244)).setAttribute("src","b.gif" );
      ((Element)v.get(244)).setAttribute("width","8" );
      ((Element)v.get(244)).setAttribute("height","8" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */
      /* Termina nodo:243   */

      /* Empieza nodo:245 / Elemento padre: 242   */
      v.add(doc.createElement("td"));
      ((Element)v.get(242)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(246)).setAttribute("nombre","lblRecomendacionEfectiva" );
      ((Element)v.get(246)).setAttribute("alto","13" );
      ((Element)v.get(246)).setAttribute("filas","1" );
      ((Element)v.get(246)).setAttribute("valor","" );
      ((Element)v.get(246)).setAttribute("id","datosTitle" );
      ((Element)v.get(246)).setAttribute("cod","1672" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */
      /* Termina nodo:245   */

      /* Empieza nodo:247 / Elemento padre: 242   */
      v.add(doc.createElement("td"));
      ((Element)v.get(242)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(248)).setAttribute("src","b.gif" );
      ((Element)v.get(248)).setAttribute("width","25" );
      ((Element)v.get(248)).setAttribute("height","8" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */
      /* Termina nodo:247   */

      /* Empieza nodo:249 / Elemento padre: 242   */
      v.add(doc.createElement("td"));
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(242)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(250)).setAttribute("nombre","lblPeriodoInicialEvaluacion" );
      ((Element)v.get(250)).setAttribute("alto","13" );
      ((Element)v.get(250)).setAttribute("filas","1" );
      ((Element)v.get(250)).setAttribute("valor","" );
      ((Element)v.get(250)).setAttribute("id","datosTitle" );
      ((Element)v.get(250)).setAttribute("cod","1674" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */
      /* Termina nodo:249   */

      /* Empieza nodo:251 / Elemento padre: 242   */
      v.add(doc.createElement("td"));
      ((Element)v.get(242)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(252)).setAttribute("src","b.gif" );
      ((Element)v.get(252)).setAttribute("width","25" );
      ((Element)v.get(252)).setAttribute("height","8" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */
      /* Termina nodo:251   */

      /* Empieza nodo:253 / Elemento padre: 242   */
      v.add(doc.createElement("td"));
      ((Element)v.get(242)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(254)).setAttribute("nombre","lblNumPeriodosEvaluar" );
      ((Element)v.get(254)).setAttribute("alto","13" );
      ((Element)v.get(254)).setAttribute("filas","1" );
      ((Element)v.get(254)).setAttribute("valor","" );
      ((Element)v.get(254)).setAttribute("id","datosTitle" );
      ((Element)v.get(254)).setAttribute("cod","1675" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */
      /* Termina nodo:253   */

      /* Empieza nodo:255 / Elemento padre: 242   */
      v.add(doc.createElement("td"));
      ((Element)v.get(242)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(256)).setAttribute("src","b.gif" );
      ((Element)v.get(256)).setAttribute("width","25" );
      ((Element)v.get(256)).setAttribute("height","8" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */
      /* Termina nodo:255   */

      /* Empieza nodo:257 / Elemento padre: 242   */
      v.add(doc.createElement("td"));
      ((Element)v.get(242)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(258)).setAttribute("nombre","lblNumMinPedidos" );
      ((Element)v.get(258)).setAttribute("alto","13" );
      ((Element)v.get(258)).setAttribute("filas","1" );
      ((Element)v.get(258)).setAttribute("valor","" );
      ((Element)v.get(258)).setAttribute("id","datosTitle" );
      ((Element)v.get(258)).setAttribute("cod","1676" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */
      /* Termina nodo:257   */

      /* Empieza nodo:259 / Elemento padre: 242   */
      v.add(doc.createElement("td"));
      ((Element)v.get(242)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(260)).setAttribute("src","b.gif" );
      ((Element)v.get(260)).setAttribute("width","25" );
      ((Element)v.get(260)).setAttribute("height","8" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:259   */

      /* Empieza nodo:261 / Elemento padre: 242   */
      v.add(doc.createElement("td"));
      ((Element)v.get(242)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(262)).setAttribute("nombre","lblNumMinPedidosRecomendada" );
      ((Element)v.get(262)).setAttribute("alto","13" );
      ((Element)v.get(262)).setAttribute("filas","1" );
      ((Element)v.get(262)).setAttribute("valor","" );
      ((Element)v.get(262)).setAttribute("id","datosTitle" );
      ((Element)v.get(262)).setAttribute("cod","2423" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */
      /* Termina nodo:261   */

      /* Empieza nodo:263 / Elemento padre: 242   */
      v.add(doc.createElement("td"));
      ((Element)v.get(263)).setAttribute("width","100%" );
      ((Element)v.get(242)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(264)).setAttribute("src","b.gif" );
      ((Element)v.get(264)).setAttribute("width","8" );
      ((Element)v.get(264)).setAttribute("height","8" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */
      /* Termina nodo:263   */
      /* Termina nodo:242   */

      /* Empieza nodo:265 / Elemento padre: 238   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(238)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("td"));
      ((Element)v.get(265)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(267)).setAttribute("src","b.gif" );
      ((Element)v.get(267)).setAttribute("width","8" );
      ((Element)v.get(267)).setAttribute("height","8" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */
      /* Termina nodo:266   */

      /* Empieza nodo:268 / Elemento padre: 265   */
      v.add(doc.createElement("td"));
      ((Element)v.get(265)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(269)).setAttribute("nombre","ckRecomendacionEfectiva" );
      ((Element)v.get(269)).setAttribute("id","datosCampos" );
      ((Element)v.get(269)).setAttribute("onclick","" );
      ((Element)v.get(269)).setAttribute("check","S" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */
      /* Termina nodo:268   */

      /* Empieza nodo:270 / Elemento padre: 265   */
      v.add(doc.createElement("td"));
      ((Element)v.get(265)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(271)).setAttribute("src","b.gif" );
      ((Element)v.get(271)).setAttribute("width","25" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(271)).setAttribute("height","8" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */
      /* Termina nodo:270   */

      /* Empieza nodo:272 / Elemento padre: 265   */
      v.add(doc.createElement("td"));
      ((Element)v.get(272)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(265)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(273)).setAttribute("nombre","cbPeriodoInicialEvaluacion" );
      ((Element)v.get(273)).setAttribute("id","datosCampos" );
      ((Element)v.get(273)).setAttribute("size","1" );
      ((Element)v.get(273)).setAttribute("multiple","N" );
      ((Element)v.get(273)).setAttribute("req","N" );
      ((Element)v.get(273)).setAttribute("valorinicial","" );
      ((Element)v.get(273)).setAttribute("textoinicial","" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(273)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */
      /* Termina nodo:273   */
      /* Termina nodo:272   */

      /* Empieza nodo:275 / Elemento padre: 265   */
      v.add(doc.createElement("td"));
      ((Element)v.get(265)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(276)).setAttribute("src","b.gif" );
      ((Element)v.get(276)).setAttribute("width","25" );
      ((Element)v.get(276)).setAttribute("height","8" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:275   */

      /* Empieza nodo:277 / Elemento padre: 265   */
      v.add(doc.createElement("td"));
      ((Element)v.get(265)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(278)).setAttribute("nombre","txtNumPeriodosEvaluar" );
      ((Element)v.get(278)).setAttribute("id","datosCampos" );
      ((Element)v.get(278)).setAttribute("max","2" );
      ((Element)v.get(278)).setAttribute("tipo","" );
      ((Element)v.get(278)).setAttribute("onchange","" );
      ((Element)v.get(278)).setAttribute("req","N" );
      ((Element)v.get(278)).setAttribute("size","2" );
      ((Element)v.get(278)).setAttribute("valor","" );
      ((Element)v.get(278)).setAttribute("validacion","" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */
      /* Termina nodo:277   */

      /* Empieza nodo:279 / Elemento padre: 265   */
      v.add(doc.createElement("td"));
      ((Element)v.get(265)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(280)).setAttribute("src","b.gif" );
      ((Element)v.get(280)).setAttribute("width","25" );
      ((Element)v.get(280)).setAttribute("height","8" );
      ((Element)v.get(279)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */
      /* Termina nodo:279   */

      /* Empieza nodo:281 / Elemento padre: 265   */
      v.add(doc.createElement("td"));
      ((Element)v.get(265)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(282)).setAttribute("nombre","txtNumMinPedidos" );
      ((Element)v.get(282)).setAttribute("id","datosCampos" );
      ((Element)v.get(282)).setAttribute("max","3" );
      ((Element)v.get(282)).setAttribute("tipo","" );
      ((Element)v.get(282)).setAttribute("onchange","" );
      ((Element)v.get(282)).setAttribute("req","N" );
      ((Element)v.get(282)).setAttribute("size","3" );
      ((Element)v.get(282)).setAttribute("valor","" );
      ((Element)v.get(282)).setAttribute("validacion","" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */
      /* Termina nodo:281   */

      /* Empieza nodo:283 / Elemento padre: 265   */
      v.add(doc.createElement("td"));
      ((Element)v.get(265)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(284)).setAttribute("src","b.gif" );
      ((Element)v.get(284)).setAttribute("width","25" );
      ((Element)v.get(284)).setAttribute("height","8" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */
      /* Termina nodo:283   */

      /* Empieza nodo:285 / Elemento padre: 265   */
      v.add(doc.createElement("td"));
      ((Element)v.get(265)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(286)).setAttribute("nombre","txtNumMinPedidosRecomendada" );
      ((Element)v.get(286)).setAttribute("id","datosCampos" );
      ((Element)v.get(286)).setAttribute("max","3" );
      ((Element)v.get(286)).setAttribute("tipo","" );
      ((Element)v.get(286)).setAttribute("onchange","" );
      ((Element)v.get(286)).setAttribute("req","N" );
      ((Element)v.get(286)).setAttribute("size","3" );
      ((Element)v.get(286)).setAttribute("valor","" );
      ((Element)v.get(286)).setAttribute("validacion","" );
      ((Element)v.get(285)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */
      /* Termina nodo:285   */

      /* Empieza nodo:287 / Elemento padre: 265   */
      v.add(doc.createElement("td"));
      ((Element)v.get(287)).setAttribute("width","100%" );
      ((Element)v.get(265)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(288)).setAttribute("src","b.gif" );
      ((Element)v.get(288)).setAttribute("width","8" );
      ((Element)v.get(288)).setAttribute("height","8" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */
      /* Termina nodo:287   */
      /* Termina nodo:265   */

      /* Empieza nodo:289 / Elemento padre: 238   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(238)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("td"));
      ((Element)v.get(290)).setAttribute("colspan","4" );
      ((Element)v.get(289)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(291)).setAttribute("src","b.gif" );
      ((Element)v.get(291)).setAttribute("width","8" );
      ((Element)v.get(291)).setAttribute("height","8" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */
      /* Termina nodo:290   */
      /* Termina nodo:289   */
      /* Termina nodo:238   */
      /* Termina nodo:237   */
      /* Termina nodo:236   */
      /* Termina nodo:235   */
      /* Termina nodo:232   */
      /* Termina nodo:231   */

      /* Empieza nodo:292 / Elemento padre: 228   */
      v.add(doc.createElement("td"));
      ((Element)v.get(228)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(293)).setAttribute("src","b.gif" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */
      /* Termina nodo:292   */
      /* Termina nodo:228   */

      /* Empieza nodo:294 / Elemento padre: 220   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(220)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("td"));
      ((Element)v.get(294)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(296)).setAttribute("src","b.gif" );
      ((Element)v.get(295)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */
      /* Termina nodo:295   */

      /* Empieza nodo:297 / Elemento padre: 294   */
      v.add(doc.createElement("td"));
      ((Element)v.get(294)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(297)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("table"));
      ((Element)v.get(299)).setAttribute("width","100%" );
      ((Element)v.get(299)).setAttribute("border","0" );
      ((Element)v.get(299)).setAttribute("align","center" );
      ((Element)v.get(299)).setAttribute("cellspacing","0" );
      ((Element)v.get(299)).setAttribute("cellpadding","0" );
      ((Element)v.get(298)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(299)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("td"));
      ((Element)v.get(301)).setAttribute("class","botonera" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(302)).setAttribute("nombre","btnMontoVentas" );
      ((Element)v.get(302)).setAttribute("ID","botonContenido" );
      ((Element)v.get(302)).setAttribute("tipo","html" );
      ((Element)v.get(302)).setAttribute("accion","" );
      ((Element)v.get(302)).setAttribute("estado","false" );
      ((Element)v.get(302)).setAttribute("cod","1677" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */
      /* Termina nodo:301   */
      /* Termina nodo:300   */
      /* Termina nodo:299   */
      /* Termina nodo:298   */
      /* Termina nodo:297   */

      /* Empieza nodo:303 / Elemento padre: 294   */
      v.add(doc.createElement("td"));
      ((Element)v.get(294)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(304)).setAttribute("src","b.gif" );
      ((Element)v.get(304)).setAttribute("width","8" );
      ((Element)v.get(304)).setAttribute("height","12" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */
      /* Termina nodo:303   */
      /* Termina nodo:294   */

      /* Empieza nodo:305 / Elemento padre: 220   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(220)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("td"));
      ((Element)v.get(306)).setAttribute("width","12" );
      ((Element)v.get(306)).setAttribute("align","center" );
      ((Element)v.get(305)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(307)).setAttribute("src","b.gif" );
      ((Element)v.get(307)).setAttribute("width","12" );
      ((Element)v.get(307)).setAttribute("height","12" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */
      /* Termina nodo:306   */

      /* Empieza nodo:308 / Elemento padre: 305   */
      v.add(doc.createElement("td"));
      ((Element)v.get(308)).setAttribute("width","756" );
      ((Element)v.get(305)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(309)).setAttribute("src","b.gif" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */
      /* Termina nodo:308   */

      /* Empieza nodo:310 / Elemento padre: 305   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).setAttribute("width","12" );
      ((Element)v.get(305)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(311)).setAttribute("src","b.gif" );
      ((Element)v.get(311)).setAttribute("width","12" );
      ((Element)v.get(311)).setAttribute("height","1" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */
      /* Termina nodo:310   */
      /* Termina nodo:305   */
      /* Termina nodo:220   */
      /* Termina nodo:219   */

      /* Empieza nodo:312 / Elemento padre: 9   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(312)).setAttribute("nombre","capa4" );
      ((Element)v.get(312)).setAttribute("alto","90" );
      ((Element)v.get(312)).setAttribute("ancho","100%" );
      ((Element)v.get(312)).setAttribute("colorf","" );
      ((Element)v.get(312)).setAttribute("borde","0" );
      ((Element)v.get(312)).setAttribute("imagenf","" );
      ((Element)v.get(312)).setAttribute("repeat","" );
      ((Element)v.get(312)).setAttribute("padding","" );
      ((Element)v.get(312)).setAttribute("visibilidad","" );
      ((Element)v.get(312)).setAttribute("contravsb","" );
      ((Element)v.get(312)).setAttribute("x","0" );
      ((Element)v.get(312)).setAttribute("y","255" );
      ((Element)v.get(312)).setAttribute("zindex","" );
      ((Element)v.get(9)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("table"));
      ((Element)v.get(313)).setAttribute("width","100%" );
      ((Element)v.get(313)).setAttribute("border","0" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(313)).setAttribute("cellspacing","0" );
      ((Element)v.get(313)).setAttribute("cellpadding","0" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(313)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("td"));
      ((Element)v.get(315)).setAttribute("width","12" );
      ((Element)v.get(315)).setAttribute("align","center" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(316)).setAttribute("src","b.gif" );
      ((Element)v.get(316)).setAttribute("width","12" );
      ((Element)v.get(316)).setAttribute("height","12" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */
      /* Termina nodo:315   */

      /* Empieza nodo:317 / Elemento padre: 314   */
      v.add(doc.createElement("td"));
      ((Element)v.get(317)).setAttribute("width","750" );
      ((Element)v.get(314)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(318)).setAttribute("src","b.gif" );
      ((Element)v.get(317)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */
      /* Termina nodo:317   */

      /* Empieza nodo:319 / Elemento padre: 314   */
      v.add(doc.createElement("td"));
      ((Element)v.get(319)).setAttribute("width","12" );
      ((Element)v.get(314)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(320)).setAttribute("src","b.gif" );
      ((Element)v.get(320)).setAttribute("width","12" );
      ((Element)v.get(320)).setAttribute("height","1" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */
      /* Termina nodo:319   */
      /* Termina nodo:314   */

      /* Empieza nodo:321 / Elemento padre: 313   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(313)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("td"));
      ((Element)v.get(321)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(323)).setAttribute("src","b.gif" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */
      /* Termina nodo:322   */

      /* Empieza nodo:324 / Elemento padre: 321   */
      v.add(doc.createElement("td"));
      ((Element)v.get(321)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(324)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(326)).setAttribute("class","legend" );
      ((Element)v.get(325)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(327)).setAttribute("nombre","lblDatosMonto" );
      ((Element)v.get(327)).setAttribute("alto","13" );
      ((Element)v.get(327)).setAttribute("filas","1" );
      ((Element)v.get(327)).setAttribute("valor","" );
      ((Element)v.get(327)).setAttribute("id","legend" );
      ((Element)v.get(327)).setAttribute("cod","917" );
      ((Element)v.get(326)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */
      /* Termina nodo:326   */

      /* Empieza nodo:328 / Elemento padre: 325   */
      v.add(doc.createElement("table"));
      ((Element)v.get(328)).setAttribute("width","100%" );
      ((Element)v.get(328)).setAttribute("border","0" );
      ((Element)v.get(328)).setAttribute("align","center" );
      ((Element)v.get(328)).setAttribute("cellspacing","0" );
      ((Element)v.get(328)).setAttribute("cellpadding","0" );
      ((Element)v.get(325)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(328)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("td"));
      ((Element)v.get(329)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("table"));
      ((Element)v.get(331)).setAttribute("width","696" );
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
      ((Element)v.get(333)).setAttribute("colspan","4" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(334)).setAttribute("src","b.gif" );
      ((Element)v.get(334)).setAttribute("width","8" );
      ((Element)v.get(334)).setAttribute("height","8" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */
      /* Termina nodo:333   */
      /* Termina nodo:332   */

      /* Empieza nodo:335 / Elemento padre: 331   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(331)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("td"));
      ((Element)v.get(335)).appendChild((Element)v.get(336));

      /* Empieza nodo:337 / Elemento padre: 336   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(337)).setAttribute("src","b.gif" );
      ((Element)v.get(337)).setAttribute("width","8" );
      ((Element)v.get(337)).setAttribute("height","8" );
      ((Element)v.get(336)).appendChild((Element)v.get(337));
      /* Termina nodo:337   */
      /* Termina nodo:336   */

      /* Empieza nodo:338 / Elemento padre: 335   */
      v.add(doc.createElement("td"));
      ((Element)v.get(335)).appendChild((Element)v.get(338));

      /* Empieza nodo:339 / Elemento padre: 338   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(339)).setAttribute("nombre","lblTipoVenta" );
      ((Element)v.get(339)).setAttribute("alto","13" );
      ((Element)v.get(339)).setAttribute("filas","1" );
      ((Element)v.get(339)).setAttribute("valor","" );
      ((Element)v.get(339)).setAttribute("id","datosTitle" );
      ((Element)v.get(339)).setAttribute("cod","1622" );
      ((Element)v.get(338)).appendChild((Element)v.get(339));
      /* Termina nodo:339   */
      /* Termina nodo:338   */

      /* Empieza nodo:340 / Elemento padre: 335   */
      v.add(doc.createElement("td"));
      ((Element)v.get(340)).setAttribute("width","100%" );
      ((Element)v.get(335)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(341)).setAttribute("src","b.gif" );
      ((Element)v.get(341)).setAttribute("width","8" );
      ((Element)v.get(341)).setAttribute("height","8" );
      ((Element)v.get(340)).appendChild((Element)v.get(341));
      /* Termina nodo:341   */
      /* Termina nodo:340   */
      /* Termina nodo:335   */

      /* Empieza nodo:342 / Elemento padre: 331   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(331)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
      v.add(doc.createElement("td"));
      ((Element)v.get(342)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(344)).setAttribute("src","b.gif" );
      ((Element)v.get(344)).setAttribute("width","8" );
      ((Element)v.get(344)).setAttribute("height","8" );
      ((Element)v.get(343)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */
      /* Termina nodo:343   */

      /* Empieza nodo:345 / Elemento padre: 342   */
      v.add(doc.createElement("td"));
      ((Element)v.get(345)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(342)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(346)).setAttribute("nombre","cbTipoVenta" );
      ((Element)v.get(346)).setAttribute("id","datosCampos" );
      ((Element)v.get(346)).setAttribute("size","1" );
      ((Element)v.get(346)).setAttribute("multiple","N" );
      ((Element)v.get(346)).setAttribute("req","S" );
      ((Element)v.get(346)).setAttribute("valorinicial","" );
      ((Element)v.get(346)).setAttribute("textoinicial","" );
      ((Element)v.get(346)).setAttribute("ontab","focalizaTab(4);" );
      ((Element)v.get(346)).setAttribute("onshtab","focalizaShTab(3);" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(346)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */
      /* Termina nodo:346   */
      /* Termina nodo:345   */

      /* Empieza nodo:348 / Elemento padre: 342   */
      v.add(doc.createElement("td"));
      ((Element)v.get(348)).setAttribute("width","100%" );
      ((Element)v.get(342)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(349)).setAttribute("src","b.gif" );
      ((Element)v.get(349)).setAttribute("width","8" );
      ((Element)v.get(349)).setAttribute("height","8" );
      ((Element)v.get(348)).appendChild((Element)v.get(349));
      /* Termina nodo:349   */
      /* Termina nodo:348   */
      /* Termina nodo:342   */

      /* Empieza nodo:350 / Elemento padre: 331   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(331)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("td"));
      ((Element)v.get(351)).setAttribute("colspan","4" );
      ((Element)v.get(350)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(352)).setAttribute("src","b.gif" );
      ((Element)v.get(352)).setAttribute("width","8" );
      ((Element)v.get(352)).setAttribute("height","8" );
      ((Element)v.get(351)).appendChild((Element)v.get(352));
      /* Termina nodo:352   */
      /* Termina nodo:351   */
      /* Termina nodo:350   */
      /* Termina nodo:331   */
      /* Termina nodo:330   */
      /* Termina nodo:329   */
      /* Termina nodo:328   */
      /* Termina nodo:325   */
      /* Termina nodo:324   */

      /* Empieza nodo:353 / Elemento padre: 321   */
      v.add(doc.createElement("td"));
      ((Element)v.get(321)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(354)).setAttribute("src","b.gif" );
      ((Element)v.get(353)).appendChild((Element)v.get(354));
      /* Termina nodo:354   */
      /* Termina nodo:353   */
      /* Termina nodo:321   */

      /* Empieza nodo:355 / Elemento padre: 313   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(313)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("td"));
      ((Element)v.get(356)).setAttribute("width","12" );
      ((Element)v.get(356)).setAttribute("align","center" );
      ((Element)v.get(355)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(357)).setAttribute("src","b.gif" );
      ((Element)v.get(357)).setAttribute("width","12" );
      ((Element)v.get(357)).setAttribute("height","12" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */
      /* Termina nodo:356   */

      /* Empieza nodo:358 / Elemento padre: 355   */
      v.add(doc.createElement("td"));
      ((Element)v.get(358)).setAttribute("width","756" );
      ((Element)v.get(355)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(359)).setAttribute("src","b.gif" );
      ((Element)v.get(358)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */
      /* Termina nodo:358   */

      /* Empieza nodo:360 / Elemento padre: 355   */
      v.add(doc.createElement("td"));
      ((Element)v.get(360)).setAttribute("width","12" );
      ((Element)v.get(355)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(361)).setAttribute("src","b.gif" );
      ((Element)v.get(361)).setAttribute("width","12" );
      ((Element)v.get(361)).setAttribute("height","1" );
      ((Element)v.get(360)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */
      /* Termina nodo:360   */
      /* Termina nodo:355   */
      /* Termina nodo:313   */
      /* Termina nodo:312   */
      /* Termina nodo:9   */


   }

}
