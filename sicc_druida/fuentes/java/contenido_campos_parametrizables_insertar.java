
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_campos_parametrizables_insertar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_campos_parametrizables_insertar" );
      ((Element)v.get(0)).setAttribute("cod","0368" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Insertar Campos Obligatorios" );
      ((Element)v.get(0)).setAttribute("onload","Inicio();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(2));

      /* Elemento padre:2 / Elemento actual: 3   */
      v.add(doc.createTextNode("\r  \r\r  function Inicio() {\r    configurarMenuSecundario(\"frmFormulario\");\r    varNoLimpiarSICC = true;\r\r    if (get('frmFormulario.hCasoDeUso') == \"Insertar\" && get('frmFormulario.accion') == \"\") {\r      completarComboTipo();\r      set('frmFormulario.cbTipoCampo',['']);       completarComboNombreCampo();\r      accion('frmFormulario.cbSubTipoCliente','.disabled=true');\r      focaliza('frmFormulario.cbTipoCampo');\r    }\r\r    if (get('frmFormulario.hCasoDeUso') == \"Consultar\") {\r      completarCamposConsulta();\r      document.all.IngresoObligatorio[0].disabled=true;\r      document.all.IngresoObligatorio[1].disabled=true;\r      document.all.ModificableporUsuario[0].disabled=true;\r      document.all.ModificableporUsuario[1].disabled=true;      \r      accion('frmFormulario.txtValorPorDefecto','.disabled=true');\r      \r      if ( get('frmFormulario.hTipoCampo') == '1' )  {\r         document.all[\"capaCbSubTipoCLiente\"].style.visibility = 'hidden';\r         document.all[\"capaCbTipoCLiente\"].style.visibility = 'hidden';\r         document.all[\"capaLblSubTipoCLiente\"].style.visibility = 'hidden';\r         document.all[\"capaLblTipoCLiente\"].style.visibility = 'hidden';\r         document.all[\"capaLblValorDefecto\"].style.visibility = 'hidden';\r         document.all[\"capaTxtValorDefecto\"].style.visibility = 'hidden';\r      }\r    }\r\r    if (  (get('frmFormulario.hCasoDeUso') == \"Modificar\") && (get('frmFormulario.accion') == \"\")  ) {\r      focaliza('frmFormulario.IngresoObligatorio');\r      completarComboTipo();\r      set( 'frmFormulario.cbTipoCampo', [get('frmFormulario.hTipoCampo')] );\r\r      if ( get('frmFormulario.hTipoCampo') == '1' )  {\r         document.all[\"capaCbSubTipoCLiente\"].style.visibility = 'hidden';\r         document.all[\"capaCbTipoCLiente\"].style.visibility = 'hidden';\r         document.all[\"capaLblSubTipoCLiente\"].style.visibility = 'hidden';\r         document.all[\"capaLblTipoCLiente\"].style.visibility = 'hidden';\r         document.all[\"capaLblValorDefecto\"].style.visibility = 'hidden';\r         document.all[\"capaTxtValorDefecto\"].style.visibility = 'hidden';\r      }\r      \r      combo_add('frmFormulario.cbTipoCliente',1,get('frmFormulario.hTipoCliente'));\r      set('frmFormulario.cbTipoCliente',[1]);                \r      combo_add('frmFormulario.cbSubTipoCliente',1,get('frmFormulario.hSubtipoCliente'));\r      set('frmFormulario.cbSubTipoCliente',[1]);\r      combo_add('frmFormulario.cbNombreCampo',1,get('frmFormulario.hNombreCampo'));\r      set('frmFormulario.cbNombreCampo',[1]);\r      accion('frmFormulario.cbTipoCampo','.disabled=true');\r      accion('frmFormulario.cbTipoCliente','.disabled=true');\r      accion('frmFormulario.cbSubTipoCliente','.disabled=true');\r      accion('frmFormulario.cbNombreCampo','.disabled=true');\r      set('frmFormulario.IngresoObligatorio', get('frmFormulario.hObligatorio'));\r      set('frmFormulario.ModificableporUsuario', get('frmFormulario.hModificable'));\r    }\r\r         if( get('frmFormulario.hCasoDeUso') == \"Insertar\" ){\r                  habilitarValidacionesTodosLosCampos();\r         }\r\r    if(mostrarError()==0) {\r      fLimpiar();\r    }\r  }\r\r  function completarComboTipo(){\r    var pro = GestionarMensaje(982);\r    var cli = GestionarMensaje(983);\r    combo_add('frmFormulario.cbTipoCampo', \"0\", cli);\r    combo_add('frmFormulario.cbTipoCampo', \"1\", pro);\r  }\r\r  function completarComboSubtipoCliente()  {\r    set_combo('frmFormulario.cbSubTipoCliente',[]);\r    if ( get('frmFormulario.cbTipoCliente') == \"\" ) {\r      accion( 'frmFormulario.cbSubTipoCliente', '.disabled=true' );\r      set_combo(\"frmFormulario.cbSubTipoCliente\", eval('[[\"\"],[\"\"]]'));          \r    }   else {\r      accion( 'frmFormulario.cbSubTipoCliente', '.disabled=false' );\r      combo_add('frmFormulario.cbSubTipoCliente', '', '');\r      var tipoCliente = get('frmFormulario.cbTipoCliente','V');\r      \r      for(var k=0;k<listaOcultaSTC.datos.longitud;k++) {\r                                    if ( listaOcultaSTC.datos.ij(k,1) == tipoCliente ) {\r                                             combo_add('frmFormulario.cbSubTipoCliente',listaOcultaSTC.datos.ij(k,0),listaOcultaSTC.datos.ij(k,2));\r                                    }\r      }\r      var seleccionComboSubtipoCliente = new Array();\r                           seleccionComboSubtipoCliente[ 0 ] = get('frmFormulario.hSubtipoCliente');\r                           set( 'frmFormulario.cbSubTipoCliente', seleccionComboSubtipoCliente );\r    }\r  }\r\r         function completarComboNombreCampo()  {\r                  set_combo('frmFormulario.cbNombreCampo',[]);\r    \r                  if ( get('frmFormulario.cbTipoCampo').toString() == '' ){\r                           set( 'frmFormulario.cbTipoCliente', [''] );\r                           set( 'frmFormulario.cbSubTipoCliente', [''] );\r                           set('frmFormulario.txtValorPorDefecto', '');\r                           accion( 'frmFormulario.cbTipoCliente', '.disabled=true' );\r                           accion( 'frmFormulario.cbSubTipoCliente', '.disabled=true' );\r                           accion( 'frmFormulario.txtValorPorDefecto', '.disabled=true' );\r                           cargaNombreCampo();\r                  } else {\r                           accion( 'frmFormulario.cbTipoCliente', '.disabled=false' );\r                           accion( 'frmFormulario.txtValorPorDefecto', '.disabled=false' );\r                           cargaNombreCampo();\r                  }\r         }\r\r         function cargaNombreCampo(){\r                  combo_add('frmFormulario.cbNombreCampo', '', '');\r                  var tipoCliProd = get('frmFormulario.cbTipoCampo','T');\r\r                  for(var k=0;k<listaOcultaNC.datos.longitud;k++) {\r                           if ( listaOcultaNC.datos.ij(k,2) == tipoCliProd ) {\r                                    combo_add('frmFormulario.cbNombreCampo', listaOcultaNC.datos.ij(k, 0), listaOcultaNC.datos.ij(k,1));\r                           }\r                  }\r                  var seleccionComboNombreCampo = new Array();\r                  seleccionComboNombreCampo[ 0 ] = get('frmFormulario.hNombreCampo');\r                  set( 'frmFormulario.cbNombreCampo', seleccionComboNombreCampo );\r         }\r\r         function habilitarValidacionesTodosLosCampos(){\r                  sicc_cambiar_estado('cbTipoCampo', true);\r                  sicc_cambiar_estado('cbTipoCliente', true);\r                  sicc_cambiar_estado('cbSubTipoCliente', true);\r                  sicc_cambiar_estado('cbNombreCampo', true);\r                  sicc_cambiar_estado('IngresoObligatorio', true);\r                  sicc_cambiar_estado('ModificableporUsuario', true);\r                  sicc_cambiar_estado('txtValorPorDefecto', true);\r         }\r\r                  function habilitarValidacionDeCampos(){\r\r                  var CLIENTES  = '0';\r                  var PRODUCTOS = '1';\r                  var tipoCampo = get( 'frmFormulario.cbTipoCampo', 'V' ).toString();\r\r                  if( tipoCampo == '' ){\r                           sicc_cambiar_estado('cbTipoCampo', true);\r                           sicc_cambiar_estado('cbTipoCliente', false);\r                           sicc_cambiar_estado('cbSubTipoCliente', false);\r                           sicc_cambiar_estado('cbNombreCampo', true);\r                           sicc_cambiar_estado('IngresoObligatorio', true);\r                           sicc_cambiar_estado('ModificableporUsuario', true);\r                           sicc_cambiar_estado('txtValorPorDefecto', false);\r                  } else if( tipoCampo == CLIENTES ){\r                           sicc_cambiar_estado('cbTipoCampo', true);\r                           sicc_cambiar_estado('cbTipoCliente', true);\r                           sicc_cambiar_estado('cbSubTipoCliente', true);\r                           sicc_cambiar_estado('cbNombreCampo', true);\r                           sicc_cambiar_estado('IngresoObligatorio', true);\r                           sicc_cambiar_estado('ModificableporUsuario', true);\r                           sicc_cambiar_estado('txtValorPorDefecto', true);\r                  } else if( tipoCampo == PRODUCTOS ){\r                           sicc_cambiar_estado('cbTipoCampo', true);\r                           sicc_cambiar_estado('cbTipoCliente', false);\r                           sicc_cambiar_estado('cbSubTipoCliente', false);\r                           sicc_cambiar_estado('cbNombreCampo', true);\r                           sicc_cambiar_estado('IngresoObligatorio', true);\r                           sicc_cambiar_estado('ModificableporUsuario', true);\r                           sicc_cambiar_estado('txtValorPorDefecto', false);\r                  }\r         }\r\r  function completarCamposConsulta()  {\r         completarComboTipo();\r    set( 'frmFormulario.cbTipoCampo', [get('frmFormulario.hTipoCampo')] );\r\r    combo_add('frmFormulario.cbTipoCliente',1,get('frmFormulario.hTipoCliente'));\r    set('frmFormulario.cbTipoCliente',[1]);                \r    combo_add('frmFormulario.cbSubTipoCliente',1,get('frmFormulario.hSubtipoCliente'));\r    set('frmFormulario.cbSubTipoCliente',[1]);\r    combo_add('frmFormulario.cbNombreCampo',1,get('frmFormulario.hNombreCampo'));\r    set('frmFormulario.cbNombreCampo',[1]);\r\r    accion('frmFormulario.cbTipoCampo','.disabled=true');\r    accion('frmFormulario.cbTipoCliente','.disabled=true');\r    accion('frmFormulario.cbSubTipoCliente','.disabled=true');\r    accion('frmFormulario.cbNombreCampo','.disabled=true');\r    set('frmFormulario.IngresoObligatorio', get('frmFormulario.hObligatorio'));\r    set('frmFormulario.ModificableporUsuario', get('frmFormulario.hModificable'));\r  }\r\r  function mostrarError() {\r    if ( get('frmFormulario.errCodigo')!= \"\" )  {\r      var errMsg = fMostrarMensajeError( get('frmFormulario.errCodigo'),get('frmFormulario.errDescripcion') );\r      return 1;\r    }\r    return 0;\r  }\r\r  function fGuardar() {\r    if(get('frmFormulario.hCasoDeUso') == 'Insertar'){\r      if( !sicc_validaciones_generales() ){\r         return false;\r      }\r      set('frmFormulario.conectorAction','LPInsertarConfiguracionCampos');\r      set('frmFormulario.accion','Guardar');\r      enviaSICC('frmFormulario');\r    }\r\r    if ( get('frmFormulario.hCasoDeUso') == 'Modificar' )  {\r      if(get('frmFormulario.txtValorPorDefecto') == '' && get('frmFormulario.cbTipoCampo') == '0'){\r         GestionarMensaje(1109);\r         focaliza('frmFormulario.txtValorPorDefecto');\r         return;\r      } else {\r         setMV('frmFormulario.txtValorPorDefecto', 'N');\r      }\r\r      if(get('frmFormulario.IngresoObligatorio') == \"\"){\r         GestionarMensaje(1000);\r         document.all.tags(\"INPUT\")[\"IngresoObligatorio\"][0].focus();\r         return;\r      }\r\r      if(get('frmFormulario.ModificableporUsuario') == \"\")  {\r         GestionarMensaje(1001);\r         document.all.tags(\"INPUT\")[\"ModificableporUsuario\"][0].focus();\r         return;\r      }\r\r      set('frmFormulario.accion','Guardar');\r      set('frmFormulario.conectorAction','LPModificarConfiguracionCampos');\r      enviaSICC('frmFormulario');\r    }\r  }\r\r  function fVolver(){\r    window.close();\r  }\r\r  function habilitacionCombosCli()  {\r    if ( get('frmFormulario.cbTipoCampo','T') == GestionarMensaje(982) )  {\r      setMV('frmFormulario.cbTipoCliente', 'N');\r      setMV('frmFormulario.cbSubTipoCliente', 'N');\r      setMV('frmFormulario.txtValorPorDefecto', 'N');\r\r      document.all[\"capaCbSubTipoCLiente\"].style.visibility = 'hidden';\r      document.all[\"capaCbTipoCLiente\"].style.visibility = 'hidden';\r      document.all[\"capaLblSubTipoCLiente\"].style.visibility = 'hidden';\r      document.all[\"capaLblTipoCLiente\"].style.visibility = 'hidden';\r      document.all[\"capaLblValorDefecto\"].style.visibility = 'hidden';\r      document.all[\"capaTxtValorDefecto\"].style.visibility = 'hidden';\r\r      document.all.IngresoObligatorio[0].checked=false;\r      document.all.IngresoObligatorio[1].checked=false;\r      document.all.ModificableporUsuario[0].checked=false;\r      document.all.ModificableporUsuario[1].checked=false; \r\r      return false;\r    } else {\r      setMV('frmFormulario.cbTipoCliente', 'S');\r      setMV('frmFormulario.cbSubTipoCliente', 'S');\r      setMV('frmFormulario.txtValorPorDefecto', 'S');\r\r      document.all[\"capaCbSubTipoCLiente\"].style.visibility = 'visible';\r      document.all[\"capaCbTipoCLiente\"].style.visibility = 'visible';\r      document.all[\"capaLblSubTipoCLiente\"].style.visibility = 'visible';\r      document.all[\"capaLblTipoCLiente\"].style.visibility = 'visible';\r      document.all[\"capaLblValorDefecto\"].style.visibility = 'visible';\r      document.all[\"capaTxtValorDefecto\"].style.visibility = 'visible';\r\r      document.all.IngresoObligatorio[0].checked=false;\r      document.all.IngresoObligatorio[1].checked=false;\r      document.all.ModificableporUsuario[0].checked=false;\r      document.all.ModificableporUsuario[1].checked=false; \r      \r      return true;\r    }\r  }\r\r  function  fLimpiar(){\r    if ( get('frmFormulario.hCasoDeUso')=='Insertar' ) {\r      focaliza('frmFormulario.cbTipoCampo');\r      set('frmFormulario.cbTipoCampo',[''] );\r      completarComboNombreCampo();\r      set('frmFormulario.cbNombreCampo', [] );\r      set('frmFormulario.IngresoObligatorio','');\r      set('frmFormulario.ModificableporUsuario','');\r      set('frmFormulario.txtValorPorDefecto','');\r      if ( habilitacionCombosCli() )  {\r         set( 'frmFormulario.cbTipoCliente', [] );\r         set_combo(\"frmFormulario.cbSubTipoCliente\", eval('[[\"\"],[\"\"]]'));                          \r         accion( 'frmFormulario.cbSubTipoCliente', '.disabled=true' );\r      }\r    }\r    \r    if ( get('frmFormulario.hCasoDeUso')=='Modificar' ) {\r      set('frmFormulario.txtValorPorDefecto',get('frmFormulario.hValorPorDefecto'));\r      set('frmFormulario.ModificableporUsuario',get('frmFormulario.hModificable'));\r      set('frmFormulario.IngresoObligatorio',get('frmFormulario.hObligatorio'));\r      focaliza('frmFormulario.IngresoObligatorio');\r    }\r  }\r\r  function focalizarOnTabVxD(){\r    try {\r      focaliza('frmFormulario.cbTipoCampo');\r    } catch (e)  {\r      focaliza('frmFormulario.IngresoObligatorio');\r    }\r  }\r\r  function focalizarOnShTabTipoCampo()  {\r    focaliza('frmFormulario.txtValorPorDefecto');\r  }\r\r  function ingObligOnTab()  {\r    focaliza('frmFormulario.ModificableporUsuario');\r  }\r\r  function ingObligOnShTab()  {\r    if ( get('frmFormulario.hCasoDeUso') == 'Insertar' ){\r      try {\r         focaliza('frmFormulario.cbNombreCampo');\r      } catch (e)  {\r         try {\r           focaliza('frmFormulario.cbSubTipoCliente');\r         } catch (e)  {\r           focaliza('frmFormulario.cbTipoCliente');\r         }\r      }\r      if ( get('frmFormulario.hCasoDeUso') == 'Modificar' ){\r         focaliza('frmFormulario.txtValorPorDefecto');\r      }\r    }\r  }\r\rfunction setTabFocus( campo ){\r         if( campo == 'cbTipoCampo' ){\r                  if( cbTipoCliente.disabled == false && document.all[\"capaCbTipoCLiente\"].style.visibility != 'hidden' ){\r                           focaliza('frmFormulario.cbTipoCliente');\r                  }else{\r                           setTabFocus('cbTipoCliente');\r                                             }\r         }else if(campo =='cbTipoCliente'){\r                  if( cbSubTipoCliente.disabled == false && document.all[\"capaCbSubTipoCLiente\"].style.visibility != 'hidden' ){\r                           focaliza('frmFormulario.cbSubTipoCliente');\r                  }else{\r                           setTabFocus('cbSubTipoCliente');\r                                             }\r    }else if(campo =='cbSubTipoCliente'){\r                  if(cbNombreCampo.disabled == false){\r                           focaliza('frmFormulario.cbNombreCampo');\r                  }else{\r                           setTabFocus('cbNombreCampo');\r                  }\r    }else if(campo =='cbNombreCampo'){\r                  focaliza('frmFormulario.IngresoObligatorio');\r    }else if(campo =='IngresoObligatorio'){\r                  focaliza('frmFormulario.ModificableporUsuario');\r    }else if(campo =='ModificableporUsuario'){\r                  if(txtValorPorDefecto.disabled == false && document.all[\"capaTxtValorDefecto\"].style.visibility != 'hidden' ){\r                           focaliza('frmFormulario.txtValorPorDefecto');\r                  }else{\r                           setTabFocus('txtValorPorDefecto');\r                                             }\r    }else if(campo =='txtValorPorDefecto'){\r                  if(cbTipoCampo.disabled == false){\r                           focaliza('frmFormulario.cbTipoCampo');\r                  }else{\r                           setTabFocus('cbTipoCampo');\r                  }\r         }\r}\r\rfunction setSHTabFocus( campo ){\r         if( campo == 'cbTipoCampo' ){\r                  if(txtValorPorDefecto.disabled == false && document.all[\"capaTxtValorDefecto\"].style.visibility != 'hidden' ){\r                           focaliza('frmFormulario.txtValorPorDefecto');\r                  }else{\r                           setSHTabFocus('txtValorPorDefecto');\r                                             }\r    }else if(campo =='cbTipoCliente'){\r                  if( cbTipoCampo.disabled == false ){\r                           focaliza('frmFormulario.cbTipoCampo');\r                  }else{\r                           setSHTabFocus('cbTipoCampo');\r                  }\r    }else if(campo =='cbSubTipoCliente'){\r                  if(cbTipoCliente.disabled == false && document.all[\"capaCbTipoCLiente\"].style.visibility != 'hidden'){\r                           focaliza('frmFormulario.cbTipoCliente');\r                  }else{\r                           setSHTabFocus('cbTipoCliente');\r                  }\r    }else if(campo =='cbNombreCampo'){\r                  if( cbSubTipoCliente.disabled == false && document.all[\"capaCbSubTipoCLiente\"].style.visibility != 'hidden' ){\r                           focaliza('frmFormulario.cbSubTipoCliente');\r                                                      }else{\r                           setSHTabFocus('cbSubTipoCliente');\r                                             }\r    }else if(campo =='IngresoObligatorio'){\r                  if(cbNombreCampo.disabled == false){\r                           focaliza('frmFormulario.cbNombreCampo');\r                  }else{\r                           setSHTabFocus('cbNombreCampo');\r                  }\r    }else if(campo =='ModificableporUsuario'){\r                  focaliza('frmFormulario.IngresoObligatorio');\r    }else if(campo =='txtValorPorDefecto'){\r                  focaliza('frmFormulario.ModificableporUsuario');\r    }\r}\r\r   \r"));
      ((Element)v.get(2)).appendChild((Text)v.get(3));

      /* Termina nodo Texto:3   */
      /* Termina nodo:2   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(5)).setAttribute("name","cbTipoCampo" );
      ((Element)v.get(5)).setAttribute("required","false" );
      ((Element)v.get(5)).setAttribute("cod","1361" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(6)).setAttribute("name","cbTipoCliente" );
      ((Element)v.get(6)).setAttribute("required","false" );
      ((Element)v.get(6)).setAttribute("cod","1869" );
      ((Element)v.get(4)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","cbSubTipoCliente" );
      ((Element)v.get(7)).setAttribute("required","false" );
      ((Element)v.get(7)).setAttribute("cod","595" );
      ((Element)v.get(4)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cbNombreCampo" );
      ((Element)v.get(8)).setAttribute("required","false" );
      ((Element)v.get(8)).setAttribute("cod","1285" );
      ((Element)v.get(4)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","IngresoObligatorio" );
      ((Element)v.get(9)).setAttribute("required","false" );
      ((Element)v.get(9)).setAttribute("cod","1362" );
      ((Element)v.get(4)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","ModificableporUsuario" );
      ((Element)v.get(10)).setAttribute("required","false" );
      ((Element)v.get(10)).setAttribute("cod","1363" );
      ((Element)v.get(4)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","txtValorPorDefecto" );
      ((Element)v.get(11)).setAttribute("required","true" );
      ((Element)v.get(11)).setAttribute("cod","1286" );
      ((Element)v.get(11)).setAttribute("format","t" );
      ((Element)v.get(11)).setAttribute("chars"," abcdefghijklllmnñopqrstuvwxyz0123456789" );
      ((Element)v.get(4)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */
      /* Termina nodo:4   */

      /* Empieza nodo:12 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(12)).setAttribute("nombre","frmFormulario" );
      ((Element)v.get(12)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(12));

      /* Empieza nodo:13 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","hCasoDeUso" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","accion" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hOID" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hTipoCampo" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hNombreCampo" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hObligatorio" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hModificable" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hValorPorDefecto" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","hTipoCliente" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","hSubtipoCliente" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hFiltroTipo" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hFiltroNombreCampo" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hFiltroObligatorio" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hFiltroModificable" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hFiltroValorPorDefecto" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hFiltroTipoCliente" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hFiltroSubtipoCliente" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","exito" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 12   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(34)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(34)).setAttribute("x","0" );
      ((Element)v.get(34)).setAttribute("y","0" );
      ((Element)v.get(12)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("table"));
      ((Element)v.get(35)).setAttribute("width","100%" );
      ((Element)v.get(35)).setAttribute("border","0" );
      ((Element)v.get(35)).setAttribute("cellspacing","0" );
      ((Element)v.get(35)).setAttribute("cellpadding","0" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).setAttribute("width","12" );
      ((Element)v.get(37)).setAttribute("align","center" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(38)).setAttribute("src","b.gif" );
      ((Element)v.get(38)).setAttribute("width","12" );
      ((Element)v.get(38)).setAttribute("height","12" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:39 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).setAttribute("width","750" );
      ((Element)v.get(36)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(40)).setAttribute("src","b.gif" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */
      /* Termina nodo:39   */

      /* Empieza nodo:41 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).setAttribute("width","12" );
      ((Element)v.get(36)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(42)).setAttribute("src","b.gif" );
      ((Element)v.get(42)).setAttribute("width","12" );
      ((Element)v.get(42)).setAttribute("height","1" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */
      /* Termina nodo:36   */

      /* Empieza nodo:43 / Elemento padre: 35   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(45)).setAttribute("src","b.gif" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:46 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(48)).setAttribute("class","legend" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(49)).setAttribute("nombre","lblDatosAlta" );
      ((Element)v.get(49)).setAttribute("alto","13" );
      ((Element)v.get(49)).setAttribute("filas","1" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(49)).setAttribute("id","legend" );
      ((Element)v.get(49)).setAttribute("cod","00127" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 47   */
      v.add(doc.createElement("table"));
      ((Element)v.get(50)).setAttribute("width","100%" );
      ((Element)v.get(50)).setAttribute("border","0" );
      ((Element)v.get(50)).setAttribute("align","center" );
      ((Element)v.get(50)).setAttribute("cellspacing","0" );
      ((Element)v.get(50)).setAttribute("cellpadding","0" );
      ((Element)v.get(47)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).setAttribute("colspan","3" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(53)).setAttribute("src","b.gif" );
      ((Element)v.get(53)).setAttribute("width","8" );
      ((Element)v.get(53)).setAttribute("height","8" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:54 / Elemento padre: 50   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(50)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(56)).setAttribute("src","b.gif" );
      ((Element)v.get(56)).setAttribute("width","8" );
      ((Element)v.get(56)).setAttribute("height","8" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:57 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(58)).setAttribute("nombre","lblTipoCampo" );
      ((Element)v.get(58)).setAttribute("alto","13" );
      ((Element)v.get(58)).setAttribute("filas","1" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(58)).setAttribute("id","datosTitle" );
      ((Element)v.get(58)).setAttribute("cod","1361" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:59 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(60)).setAttribute("src","b.gif" );
      ((Element)v.get(60)).setAttribute("width","25" );
      ((Element)v.get(60)).setAttribute("height","8" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(62)).setAttribute("nombre","capaLblTipoCLiente" );
      ((Element)v.get(62)).setAttribute("alto","50" );
      ((Element)v.get(62)).setAttribute("ancho","100%" );
      ((Element)v.get(62)).setAttribute("colorf","" );
      ((Element)v.get(62)).setAttribute("borde","0" );
      ((Element)v.get(62)).setAttribute("imagenf","" );
      ((Element)v.get(62)).setAttribute("repeat","" );
      ((Element)v.get(62)).setAttribute("padding","" );
      ((Element)v.get(62)).setAttribute("visibilidad","visible" );
      ((Element)v.get(62)).setAttribute("contravsb","" );
      ((Element)v.get(62)).setAttribute("x","160" );
      ((Element)v.get(62)).setAttribute("y","30" );
      ((Element)v.get(62)).setAttribute("zindex","" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("table"));
      ((Element)v.get(63)).setAttribute("width","100%" );
      ((Element)v.get(63)).setAttribute("border","0" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(66)).setAttribute("nombre","lblTipoCliente" );
      ((Element)v.get(66)).setAttribute("alto","13" );
      ((Element)v.get(66)).setAttribute("filas","1" );
      ((Element)v.get(66)).setAttribute("valor","" );
      ((Element)v.get(66)).setAttribute("id","datosTitle" );
      ((Element)v.get(66)).setAttribute("cod","1869" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:63   */
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:67 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(68)).setAttribute("width","25" );
      ((Element)v.get(68)).setAttribute("height","8" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:69 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(70)).setAttribute("nombre","capaLblSubTipoCLiente" );
      ((Element)v.get(70)).setAttribute("alto","50" );
      ((Element)v.get(70)).setAttribute("ancho","100%" );
      ((Element)v.get(70)).setAttribute("colorf","" );
      ((Element)v.get(70)).setAttribute("borde","0" );
      ((Element)v.get(70)).setAttribute("imagenf","" );
      ((Element)v.get(70)).setAttribute("repeat","" );
      ((Element)v.get(70)).setAttribute("padding","" );
      ((Element)v.get(70)).setAttribute("visibilidad","visible" );
      ((Element)v.get(70)).setAttribute("contravsb","" );
      ((Element)v.get(70)).setAttribute("x","620" );
      ((Element)v.get(70)).setAttribute("y","30" );
      ((Element)v.get(70)).setAttribute("zindex","" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("table"));
      ((Element)v.get(71)).setAttribute("width","100%" );
      ((Element)v.get(71)).setAttribute("border","0" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(74)).setAttribute("nombre","lblSubtipoCliente" );
      ((Element)v.get(74)).setAttribute("alto","13" );
      ((Element)v.get(74)).setAttribute("filas","1" );
      ((Element)v.get(74)).setAttribute("valor","" );
      ((Element)v.get(74)).setAttribute("id","datosTitle" );
      ((Element)v.get(74)).setAttribute("cod","595" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:75 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).setAttribute("width","100%" );
      ((Element)v.get(54)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","8" );
      ((Element)v.get(76)).setAttribute("height","8" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:54   */

      /* Empieza nodo:77 / Elemento padre: 50   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(50)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","8" );
      ((Element)v.get(79)).setAttribute("height","8" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:80 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(77)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(81)).setAttribute("nombre","cbTipoCampo" );
      ((Element)v.get(81)).setAttribute("id","datosCampos" );
      ((Element)v.get(81)).setAttribute("size","1" );
      ((Element)v.get(81)).setAttribute("multiple","N" );
      ((Element)v.get(81)).setAttribute("req","S" );
      ((Element)v.get(81)).setAttribute("valorinicial","" );
      ((Element)v.get(81)).setAttribute("textoinicial","" );
      ((Element)v.get(81)).setAttribute("onchange","completarComboNombreCampo();habilitacionCombosCli();habilitarValidacionDeCampos();" );
      ((Element)v.get(81)).setAttribute("ontab","setTabFocus('cbTipoCampo');" );
      ((Element)v.get(81)).setAttribute("onshtab","setSHTabFocus('cbTipoCampo');" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:83 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(84)).setAttribute("src","b.gif" );
      ((Element)v.get(84)).setAttribute("width","25" );
      ((Element)v.get(84)).setAttribute("height","8" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:85 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(85)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(77)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(86)).setAttribute("nombre","capaCbTipoCLiente" );
      ((Element)v.get(86)).setAttribute("alto","50" );
      ((Element)v.get(86)).setAttribute("ancho","100%" );
      ((Element)v.get(86)).setAttribute("colorf","" );
      ((Element)v.get(86)).setAttribute("borde","0" );
      ((Element)v.get(86)).setAttribute("imagenf","" );
      ((Element)v.get(86)).setAttribute("repeat","" );
      ((Element)v.get(86)).setAttribute("padding","" );
      ((Element)v.get(86)).setAttribute("visibilidad","visible" );
      ((Element)v.get(86)).setAttribute("contravsb","" );
      ((Element)v.get(86)).setAttribute("x","160" );
      ((Element)v.get(86)).setAttribute("y","43" );
      ((Element)v.get(86)).setAttribute("zindex","" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("table"));
      ((Element)v.get(87)).setAttribute("width","100%" );
      ((Element)v.get(87)).setAttribute("border","0" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(90)).setAttribute("nombre","cbTipoCliente" );
      ((Element)v.get(90)).setAttribute("id","datosCampos" );
      ((Element)v.get(90)).setAttribute("size","1" );
      ((Element)v.get(90)).setAttribute("multiple","N" );
      ((Element)v.get(90)).setAttribute("req","S" );
      ((Element)v.get(90)).setAttribute("valorinicial","" );
      ((Element)v.get(90)).setAttribute("textoinicial","" );
      ((Element)v.get(90)).setAttribute("onchange","completarComboSubtipoCliente();" );
      ((Element)v.get(90)).setAttribute("ontab","setTabFocus('cbTipoCliente');" );
      ((Element)v.get(90)).setAttribute("onshtab","setSHTabFocus('cbTipoCliente');" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:92 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","b.gif" );
      ((Element)v.get(93)).setAttribute("width","25" );
      ((Element)v.get(93)).setAttribute("height","8" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:94 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(77)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(95)).setAttribute("nombre","capaCbSubTipoCLiente" );
      ((Element)v.get(95)).setAttribute("alto","50" );
      ((Element)v.get(95)).setAttribute("ancho","100%" );
      ((Element)v.get(95)).setAttribute("colorf","" );
      ((Element)v.get(95)).setAttribute("borde","0" );
      ((Element)v.get(95)).setAttribute("imagenf","" );
      ((Element)v.get(95)).setAttribute("repeat","" );
      ((Element)v.get(95)).setAttribute("padding","" );
      ((Element)v.get(95)).setAttribute("visibilidad","visible" );
      ((Element)v.get(95)).setAttribute("contravsb","" );
      ((Element)v.get(95)).setAttribute("x","620" );
      ((Element)v.get(95)).setAttribute("y","43" );
      ((Element)v.get(95)).setAttribute("zindex","" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("table"));
      ((Element)v.get(96)).setAttribute("width","100%" );
      ((Element)v.get(96)).setAttribute("border","0" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(99)).setAttribute("nombre","cbSubTipoCliente" );
      ((Element)v.get(99)).setAttribute("id","datosCampos" );
      ((Element)v.get(99)).setAttribute("size","1" );
      ((Element)v.get(99)).setAttribute("multiple","N" );
      ((Element)v.get(99)).setAttribute("req","S" );
      ((Element)v.get(99)).setAttribute("valorinicial","" );
      ((Element)v.get(99)).setAttribute("textoinicial","" );
      ((Element)v.get(99)).setAttribute("ontab","setTabFocus('cbSubTipoCliente');" );
      ((Element)v.get(99)).setAttribute("onshtab","setSHTabFocus('cbSubTipoCliente');" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:101 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(101)).setAttribute("width","100%" );
      ((Element)v.get(77)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(102)).setAttribute("src","b.gif" );
      ((Element)v.get(102)).setAttribute("width","8" );
      ((Element)v.get(102)).setAttribute("height","8" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */
      /* Termina nodo:77   */

      /* Empieza nodo:103 / Elemento padre: 50   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(50)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).setAttribute("colspan","3" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(105)).setAttribute("src","b.gif" );
      ((Element)v.get(105)).setAttribute("width","8" );
      ((Element)v.get(105)).setAttribute("height","7" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */
      /* Termina nodo:103   */
      /* Termina nodo:50   */

      /* Empieza nodo:106 / Elemento padre: 47   */
      v.add(doc.createElement("table"));
      ((Element)v.get(106)).setAttribute("width","100%" );
      ((Element)v.get(106)).setAttribute("border","0" );
      ((Element)v.get(106)).setAttribute("align","center" );
      ((Element)v.get(106)).setAttribute("cellspacing","0" );
      ((Element)v.get(106)).setAttribute("cellpadding","0" );
      ((Element)v.get(47)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(109)).setAttribute("src","b.gif" );
      ((Element)v.get(109)).setAttribute("width","8" );
      ((Element)v.get(109)).setAttribute("height","8" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:110 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(111)).setAttribute("nombre","lblNombreCampo" );
      ((Element)v.get(111)).setAttribute("alto","13" );
      ((Element)v.get(111)).setAttribute("filas","1" );
      ((Element)v.get(111)).setAttribute("valor","" );
      ((Element)v.get(111)).setAttribute("id","datosTitle" );
      ((Element)v.get(111)).setAttribute("cod","1285" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:112 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(113)).setAttribute("src","b.gif" );
      ((Element)v.get(113)).setAttribute("width","25" );
      ((Element)v.get(113)).setAttribute("height","8" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:114 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(115)).setAttribute("nombre","lblObligatorio" );
      ((Element)v.get(115)).setAttribute("alto","13" );
      ((Element)v.get(115)).setAttribute("filas","1" );
      ((Element)v.get(115)).setAttribute("valor","" );
      ((Element)v.get(115)).setAttribute("id","datosTitle" );
      ((Element)v.get(115)).setAttribute("cod","1362" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:116 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(117)).setAttribute("src","b.gif" );
      ((Element)v.get(117)).setAttribute("width","25" );
      ((Element)v.get(117)).setAttribute("height","8" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(119)).setAttribute("nombre","lblModificable" );
      ((Element)v.get(119)).setAttribute("alto","13" );
      ((Element)v.get(119)).setAttribute("filas","1" );
      ((Element)v.get(119)).setAttribute("valor","" );
      ((Element)v.get(119)).setAttribute("id","datosTitle" );
      ((Element)v.get(119)).setAttribute("cod","1363" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:120 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).setAttribute("width","100%" );
      ((Element)v.get(107)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(121)).setAttribute("width","8" );
      ((Element)v.get(121)).setAttribute("height","8" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */
      /* Termina nodo:107   */

      /* Empieza nodo:122 / Elemento padre: 106   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(106)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(124)).setAttribute("src","b.gif" );
      ((Element)v.get(124)).setAttribute("width","8" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(124)).setAttribute("height","8" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:125 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(122)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(126)).setAttribute("nombre","cbNombreCampo" );
      ((Element)v.get(126)).setAttribute("id","datosCampos" );
      ((Element)v.get(126)).setAttribute("size","1" );
      ((Element)v.get(126)).setAttribute("multiple","N" );
      ((Element)v.get(126)).setAttribute("req","S" );
      ((Element)v.get(126)).setAttribute("valorinicial","" );
      ((Element)v.get(126)).setAttribute("textoinicial","" );
      ((Element)v.get(126)).setAttribute("ontab","setTabFocus('cbNombreCampo');" );
      ((Element)v.get(126)).setAttribute("onshtab","setSHTabFocus('cbNombreCampo');" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:128 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(129)).setAttribute("src","b.gif" );
      ((Element)v.get(129)).setAttribute("width","25" );
      ((Element)v.get(129)).setAttribute("height","8" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:130 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(130)).setAttribute("class","datosCampos" );
      ((Element)v.get(122)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("table"));
      ((Element)v.get(131)).setAttribute("width","100%" );
      ((Element)v.get(131)).setAttribute("border","0" );
      ((Element)v.get(131)).setAttribute("cellspacing","0" );
      ((Element)v.get(131)).setAttribute("cellpadding","0" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(133)).setAttribute("nombre","IngresoObligatorio" );
      ((Element)v.get(133)).setAttribute("tipo","H" );
      ((Element)v.get(133)).setAttribute("id","datosCampos" );
      ((Element)v.get(133)).setAttribute("ontab","setTabFocus('IngresoObligatorio');" );
      ((Element)v.get(133)).setAttribute("onshtab","setSHTabFocus('IngresoObligatorio');" );
      ((Element)v.get(133)).setAttribute("req","S" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(134)).setAttribute("valor","S" );
      ((Element)v.get(134)).setAttribute("check","N" );
      ((Element)v.get(134)).setAttribute("onfocus","" );
      ((Element)v.get(134)).setAttribute("id","datosCampos" );
      ((Element)v.get(134)).setAttribute("cod","117" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));

      /* Elemento padre:134 / Elemento actual: 135   */
      v.add(doc.createTextNode("S"));
      ((Element)v.get(134)).appendChild((Text)v.get(135));

      /* Termina nodo Texto:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 133   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(136)).setAttribute("valor","N" );
      ((Element)v.get(136)).setAttribute("onfocus","" );
      ((Element)v.get(136)).setAttribute("id","datosCampos" );
      ((Element)v.get(136)).setAttribute("cod","87" );
      ((Element)v.get(133)).appendChild((Element)v.get(136));

      /* Elemento padre:136 / Elemento actual: 137   */
      v.add(doc.createTextNode("N"));
      ((Element)v.get(136)).appendChild((Text)v.get(137));

      /* Termina nodo Texto:137   */
      /* Termina nodo:136   */
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:138 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(139)).setAttribute("src","b.gif" );
      ((Element)v.get(139)).setAttribute("width","25" );
      ((Element)v.get(139)).setAttribute("height","8" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */

      /* Empieza nodo:140 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(140)).setAttribute("class","datosCampos" );
      ((Element)v.get(122)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("table"));
      ((Element)v.get(141)).setAttribute("width","100%" );
      ((Element)v.get(141)).setAttribute("border","0" );
      ((Element)v.get(141)).setAttribute("cellspacing","0" );
      ((Element)v.get(141)).setAttribute("cellpadding","0" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(143)).setAttribute("nombre","ModificableporUsuario" );
      ((Element)v.get(143)).setAttribute("tipo","H" );
      ((Element)v.get(143)).setAttribute("id","datosCampos" );
      ((Element)v.get(143)).setAttribute("ontab","setTabFocus('ModificableporUsuario');" );
      ((Element)v.get(143)).setAttribute("onshtab","setSHTabFocus('ModificableporUsuario');" );
      ((Element)v.get(143)).setAttribute("req","S" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("RBINPUT"));
   }

   private void getXML630(Document doc) {
      ((Element)v.get(144)).setAttribute("valor","S" );
      ((Element)v.get(144)).setAttribute("check","N" );
      ((Element)v.get(144)).setAttribute("onfocus","" );
      ((Element)v.get(144)).setAttribute("id","datosCampos" );
      ((Element)v.get(144)).setAttribute("cod","117" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Elemento padre:144 / Elemento actual: 145   */
      v.add(doc.createTextNode("S"));
      ((Element)v.get(144)).appendChild((Text)v.get(145));

      /* Termina nodo Texto:145   */
      /* Termina nodo:144   */

      /* Empieza nodo:146 / Elemento padre: 143   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(146)).setAttribute("valor","N" );
      ((Element)v.get(146)).setAttribute("onfocus","" );
      ((Element)v.get(146)).setAttribute("id","datosCampos" );
      ((Element)v.get(146)).setAttribute("cod","87" );
      ((Element)v.get(143)).appendChild((Element)v.get(146));

      /* Elemento padre:146 / Elemento actual: 147   */
      v.add(doc.createTextNode("N"));
      ((Element)v.get(146)).appendChild((Text)v.get(147));

      /* Termina nodo Texto:147   */
      /* Termina nodo:146   */
      /* Termina nodo:143   */
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:148 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(148)).setAttribute("width","100%" );
      ((Element)v.get(122)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(149)).setAttribute("src","b.gif" );
      ((Element)v.get(149)).setAttribute("width","8" );
      ((Element)v.get(149)).setAttribute("height","8" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */
      /* Termina nodo:122   */

      /* Empieza nodo:150 / Elemento padre: 106   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(106)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(151)).setAttribute("colspan","3" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(152)).setAttribute("src","b.gif" );
      ((Element)v.get(152)).setAttribute("width","8" );
      ((Element)v.get(152)).setAttribute("height","8" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */
      /* Termina nodo:150   */
      /* Termina nodo:106   */

      /* Empieza nodo:153 / Elemento padre: 47   */
      v.add(doc.createElement("table"));
      ((Element)v.get(153)).setAttribute("width","100%" );
      ((Element)v.get(153)).setAttribute("border","0" );
      ((Element)v.get(153)).setAttribute("align","center" );
      ((Element)v.get(153)).setAttribute("cellspacing","0" );
      ((Element)v.get(153)).setAttribute("cellpadding","0" );
      ((Element)v.get(47)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(153)).appendChild((Element)v.get(154));

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
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(158)).setAttribute("nombre","capaLblValorDefecto" );
      ((Element)v.get(158)).setAttribute("alto","50" );
      ((Element)v.get(158)).setAttribute("ancho","100%" );
      ((Element)v.get(158)).setAttribute("colorf","" );
      ((Element)v.get(158)).setAttribute("borde","0" );
      ((Element)v.get(158)).setAttribute("imagenf","" );
      ((Element)v.get(158)).setAttribute("repeat","" );
      ((Element)v.get(158)).setAttribute("padding","" );
      ((Element)v.get(158)).setAttribute("visibilidad","visible" );
      ((Element)v.get(158)).setAttribute("contravsb","" );
      ((Element)v.get(158)).setAttribute("x","24" );
      ((Element)v.get(158)).setAttribute("y","112" );
      ((Element)v.get(158)).setAttribute("zindex","" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("table"));
      ((Element)v.get(159)).setAttribute("width","100%" );
      ((Element)v.get(159)).setAttribute("border","0" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(159)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(161)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(162)).setAttribute("nombre","lblValorPorDefecto" );
      ((Element)v.get(162)).setAttribute("alto","13" );
      ((Element)v.get(162)).setAttribute("filas","1" );
      ((Element)v.get(162)).setAttribute("valor","" );
      ((Element)v.get(162)).setAttribute("id","datosTitle" );
      ((Element)v.get(162)).setAttribute("cod","1286" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:161   */
      /* Termina nodo:160   */
      /* Termina nodo:159   */
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:163 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).setAttribute("width","100%" );
      ((Element)v.get(154)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(164)).setAttribute("src","b.gif" );
      ((Element)v.get(164)).setAttribute("width","8" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(164)).setAttribute("height","8" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */
      /* Termina nodo:154   */

      /* Empieza nodo:165 / Elemento padre: 153   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(153)).appendChild((Element)v.get(165));

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
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(169)).setAttribute("nombre","capaTxtValorDefecto" );
      ((Element)v.get(169)).setAttribute("alto","50" );
      ((Element)v.get(169)).setAttribute("ancho","100%" );
      ((Element)v.get(169)).setAttribute("colorf","" );
      ((Element)v.get(169)).setAttribute("borde","0" );
      ((Element)v.get(169)).setAttribute("imagenf","" );
      ((Element)v.get(169)).setAttribute("repeat","" );
      ((Element)v.get(169)).setAttribute("padding","" );
      ((Element)v.get(169)).setAttribute("visibilidad","visible" );
      ((Element)v.get(169)).setAttribute("contravsb","" );
      ((Element)v.get(169)).setAttribute("x","24" );
      ((Element)v.get(169)).setAttribute("y","125" );
      ((Element)v.get(169)).setAttribute("zindex","" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("table"));
      ((Element)v.get(170)).setAttribute("width","100%" );
      ((Element)v.get(170)).setAttribute("border","0" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(170)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(173)).setAttribute("nombre","txtValorPorDefecto" );
      ((Element)v.get(173)).setAttribute("id","datosCampos" );
      ((Element)v.get(173)).setAttribute("max","40" );
      ((Element)v.get(173)).setAttribute("tipo","" );
      ((Element)v.get(173)).setAttribute("onchange","" );
      ((Element)v.get(173)).setAttribute("req","S" );
      ((Element)v.get(173)).setAttribute("size","40" );
      ((Element)v.get(173)).setAttribute("valor","" );
      ((Element)v.get(173)).setAttribute("validacion","" );
      ((Element)v.get(173)).setAttribute("ontab","setTabFocus('txtValorPorDefecto');" );
      ((Element)v.get(173)).setAttribute("onshtab","setSHTabFocus('txtValorPorDefecto');" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:172   */
      /* Termina nodo:171   */
      /* Termina nodo:170   */
      /* Termina nodo:169   */
      /* Termina nodo:168   */

      /* Empieza nodo:174 / Elemento padre: 165   */
      v.add(doc.createElement("td"));
      ((Element)v.get(174)).setAttribute("width","100%" );
      ((Element)v.get(165)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(175)).setAttribute("src","b.gif" );
      ((Element)v.get(175)).setAttribute("width","8" );
      ((Element)v.get(175)).setAttribute("height","30" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */
      /* Termina nodo:165   */

      /* Empieza nodo:176 / Elemento padre: 153   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(153)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).setAttribute("colspan","3" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(178)).setAttribute("src","b.gif" );
      ((Element)v.get(178)).setAttribute("width","8" );
      ((Element)v.get(178)).setAttribute("height","8" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */
      /* Termina nodo:176   */
      /* Termina nodo:153   */
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:179 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(180)).setAttribute("src","b.gif" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:179   */
      /* Termina nodo:43   */

      /* Empieza nodo:181 / Elemento padre: 35   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("td"));
      ((Element)v.get(182)).setAttribute("width","12" );
      ((Element)v.get(182)).setAttribute("align","center" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(183)).setAttribute("src","b.gif" );
      ((Element)v.get(183)).setAttribute("width","12" );
      ((Element)v.get(183)).setAttribute("height","12" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:182   */

      /* Empieza nodo:184 / Elemento padre: 181   */
      v.add(doc.createElement("td"));
      ((Element)v.get(184)).setAttribute("width","756" );
      ((Element)v.get(181)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(185)).setAttribute("src","b.gif" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:184   */

      /* Empieza nodo:186 / Elemento padre: 181   */
      v.add(doc.createElement("td"));
      ((Element)v.get(186)).setAttribute("width","12" );
      ((Element)v.get(181)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(187)).setAttribute("src","b.gif" );
      ((Element)v.get(187)).setAttribute("width","12" );
      ((Element)v.get(187)).setAttribute("height","1" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:186   */
      /* Termina nodo:181   */
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:188 / Elemento padre: 12   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(188)).setAttribute("nombre","capaListaOcultaNC" );
      ((Element)v.get(188)).setAttribute("alto","100%" );
      ((Element)v.get(188)).setAttribute("ancho","100%" );
      ((Element)v.get(188)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(188)).setAttribute("borde","0" );
      ((Element)v.get(188)).setAttribute("imagenf","" );
      ((Element)v.get(188)).setAttribute("repeat","" );
      ((Element)v.get(188)).setAttribute("padding","" );
      ((Element)v.get(188)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(188)).setAttribute("contravsb","" );
      ((Element)v.get(188)).setAttribute("x","0" );
      ((Element)v.get(188)).setAttribute("y","460" );
      ((Element)v.get(188)).setAttribute("zindex","" );
      ((Element)v.get(12)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(189)).setAttribute("seleccion","boton" );
      ((Element)v.get(189)).setAttribute("nombre","listaOcultaNC" );
      ((Element)v.get(189)).setAttribute("ancho","580" );
      ((Element)v.get(189)).setAttribute("alto","100" );
      ((Element)v.get(189)).setAttribute("entradax","" );
      ((Element)v.get(189)).setAttribute("entraday","" );
      ((Element)v.get(189)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(189)).setAttribute("oncolor","" );
      ((Element)v.get(189)).setAttribute("chkcolor","" );
      ((Element)v.get(189)).setAttribute("visibilidad","" );
      ((Element)v.get(189)).setAttribute("incx","10" );
      ((Element)v.get(189)).setAttribute("incy","10" );
      ((Element)v.get(189)).setAttribute("nmin","" );
      ((Element)v.get(189)).setAttribute("nmax","1" );
      ((Element)v.get(189)).setAttribute("multisel","1" );
      ((Element)v.get(189)).setAttribute("accion","" );
      ((Element)v.get(189)).setAttribute("sep","|" );
      ((Element)v.get(189)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(189)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(189)).setAttribute("pixelsborde","1" );
      ((Element)v.get(189)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(189)).setAttribute("onSetDatos","" );
      ((Element)v.get(189)).setAttribute("blockImg","" );
      ((Element)v.get(189)).setAttribute("x","12" );
      ((Element)v.get(189)).setAttribute("y","0" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(190)).setAttribute("nombre","cab1" );
      ((Element)v.get(190)).setAttribute("height","20" );
      ((Element)v.get(190)).setAttribute("ancho","662" );
      ((Element)v.get(190)).setAttribute("colorf","#CCCCCC" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(191)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(191)).setAttribute("ancho","13" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */

      /* Empieza nodo:192 / Elemento padre: 190   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(192)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(192)).setAttribute("ancho","230" );
      ((Element)v.get(190)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(193)).setAttribute("nombre","lblElementoCampoCliProd" );
      ((Element)v.get(193)).setAttribute("ancho","230" );
      ((Element)v.get(193)).setAttribute("alto","20" );
      ((Element)v.get(193)).setAttribute("filas","1" );
      ((Element)v.get(193)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(193)).setAttribute("cod","1285" );
      ((Element)v.get(193)).setAttribute("enviaroculto","N" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */

      /* Empieza nodo:194 / Elemento padre: 190   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(194)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(194)).setAttribute("ancho","230" );
      ((Element)v.get(190)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(195)).setAttribute("nombre","lblTipoCliProd" );
      ((Element)v.get(195)).setAttribute("ancho","230" );
      ((Element)v.get(195)).setAttribute("alto","20" );
      ((Element)v.get(195)).setAttribute("filas","1" );
      ((Element)v.get(195)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(195)).setAttribute("cod","755" );
      ((Element)v.get(195)).setAttribute("enviaroculto","N" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */
      /* Termina nodo:190   */

      /* Empieza nodo:196 / Elemento padre: 189   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(196)).setAttribute("ancho","1383" );
      ((Element)v.get(196)).setAttribute("filas","1" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(196)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(189)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(197)).setAttribute("ancho","13" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */

      /* Empieza nodo:198 / Elemento padre: 196   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(198)).setAttribute("ancho","230" );
      ((Element)v.get(198)).setAttribute("caracteres","20" );
      ((Element)v.get(196)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */

      /* Empieza nodo:199 / Elemento padre: 196   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(199)).setAttribute("ancho","230" );
      ((Element)v.get(199)).setAttribute("caracteres","20" );
      ((Element)v.get(196)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:196   */

      /* Empieza nodo:200 / Elemento padre: 189   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(189)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:189   */
      /* Termina nodo:188   */

      /* Empieza nodo:201 / Elemento padre: 12   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(201)).setAttribute("nombre","capaListaOcultaSTC" );
      ((Element)v.get(201)).setAttribute("alto","100%" );
      ((Element)v.get(201)).setAttribute("ancho","100%" );
      ((Element)v.get(201)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(201)).setAttribute("borde","0" );
      ((Element)v.get(201)).setAttribute("imagenf","" );
      ((Element)v.get(201)).setAttribute("repeat","" );
      ((Element)v.get(201)).setAttribute("padding","" );
      ((Element)v.get(201)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(201)).setAttribute("contravsb","" );
      ((Element)v.get(201)).setAttribute("x","0" );
      ((Element)v.get(201)).setAttribute("y","565" );
      ((Element)v.get(201)).setAttribute("zindex","" );
      ((Element)v.get(12)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(202)).setAttribute("seleccion","boton" );
      ((Element)v.get(202)).setAttribute("nombre","listaOcultaSTC" );
      ((Element)v.get(202)).setAttribute("ancho","580" );
      ((Element)v.get(202)).setAttribute("alto","100" );
      ((Element)v.get(202)).setAttribute("entradax","" );
      ((Element)v.get(202)).setAttribute("entraday","" );
      ((Element)v.get(202)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(202)).setAttribute("oncolor","" );
      ((Element)v.get(202)).setAttribute("chkcolor","" );
      ((Element)v.get(202)).setAttribute("visibilidad","" );
      ((Element)v.get(202)).setAttribute("incx","10" );
      ((Element)v.get(202)).setAttribute("incy","10" );
      ((Element)v.get(202)).setAttribute("nmin","" );
      ((Element)v.get(202)).setAttribute("nmax","1" );
      ((Element)v.get(202)).setAttribute("multisel","1" );
      ((Element)v.get(202)).setAttribute("accion","" );
      ((Element)v.get(202)).setAttribute("sep","|" );
      ((Element)v.get(202)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(202)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(202)).setAttribute("pixelsborde","1" );
      ((Element)v.get(202)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(202)).setAttribute("onSetDatos","" );
      ((Element)v.get(202)).setAttribute("blockImg","" );
      ((Element)v.get(202)).setAttribute("x","12" );
      ((Element)v.get(202)).setAttribute("y","0" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(203)).setAttribute("nombre","cab2" );
      ((Element)v.get(203)).setAttribute("height","20" );
      ((Element)v.get(203)).setAttribute("ancho","662" );
      ((Element)v.get(203)).setAttribute("colorf","#CCCCCC" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(204)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(204)).setAttribute("ancho","13" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */

      /* Empieza nodo:205 / Elemento padre: 203   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(205)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(205)).setAttribute("ancho","230" );
      ((Element)v.get(203)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(206)).setAttribute("nombre","lblValueTipoCliente" );
      ((Element)v.get(206)).setAttribute("ancho","230" );
      ((Element)v.get(206)).setAttribute("alto","20" );
      ((Element)v.get(206)).setAttribute("filas","1" );
      ((Element)v.get(206)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(206)).setAttribute("cod","393" );
      ((Element)v.get(206)).setAttribute("enviaroculto","N" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */

      /* Empieza nodo:207 / Elemento padre: 203   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(207)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(207)).setAttribute("ancho","230" );
      ((Element)v.get(203)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(208)).setAttribute("nombre","lblElementoSubtipoCliente" );
      ((Element)v.get(208)).setAttribute("ancho","230" );
      ((Element)v.get(208)).setAttribute("alto","20" );
      ((Element)v.get(208)).setAttribute("filas","1" );
      ((Element)v.get(208)).setAttribute("id","datosCamposCabecera" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(208)).setAttribute("cod","595" );
      ((Element)v.get(208)).setAttribute("enviaroculto","N" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:207   */
      /* Termina nodo:203   */

      /* Empieza nodo:209 / Elemento padre: 202   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(209)).setAttribute("ancho","1383" );
      ((Element)v.get(209)).setAttribute("filas","1" );
      ((Element)v.get(209)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(202)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(210)).setAttribute("ancho","13" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */

      /* Empieza nodo:211 / Elemento padre: 209   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(211)).setAttribute("ancho","230" );
      ((Element)v.get(211)).setAttribute("caracteres","20" );
      ((Element)v.get(209)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */

      /* Empieza nodo:212 / Elemento padre: 209   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(212)).setAttribute("ancho","230" );
      ((Element)v.get(212)).setAttribute("caracteres","20" );
      ((Element)v.get(209)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:209   */

      /* Empieza nodo:213 / Elemento padre: 202   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(202)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:202   */
      /* Termina nodo:201   */
      /* Termina nodo:12   */


   }

}
