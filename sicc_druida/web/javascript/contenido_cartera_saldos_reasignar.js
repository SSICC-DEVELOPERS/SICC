// --------------------------------------------------------------------------------------------------------------------------------------------------      
	function onLoadPag()   
	{
      // splatas - 10/05/2006 - DBLG400000888
      // Si 'hListaVisible' != "" entonces se efectuó una búsqueda
      if(get('frmContenido.hListaVisible') == ""){  
        ocultarLista();
      
      } else {

        var tamLista = listado1.datos.length;
        if( tamLista < 1){  
            set('frmContenido.hListaVisible', "");    
            ocultarLista();    
        }

        var iSeleccionado = new Array();
        
        iSeleccionado[0] = get('frmContenido.usuarioOrigen');
        set ('frmContenido.cbUsuarioOrigen', iSeleccionado);
        
        iSeleccionado[0] = get('frmContenido.marca');
        set ('frmContenido.cbMarca', iSeleccionado);
        
        iSeleccionado[0] = get('frmContenido.canal');
        set ('frmContenido.cbCanal', iSeleccionado);
        
        var porcentaje = get('frmContenido.porcentajeHasta');
        set ('frmContenido.txtPorcentajeHasta', porcentaje);
        
        var importe = get('frmContenido.importeHasta');
        set ('frmContenido.txtImporteHasta', importe);
        
        usuarioOrigenOnChange();
        recargaPeriodo();            
        
      }
      
      configurarMenuSecundario("frmContenido");
	  DrdEnsanchaConMargenDcho('listado1',12);
      focaliza('frmContenido.cbUsuarioOrigen');
	  eval (ON_RSZ);  
      fMostrarMensajeError();
      
	}
  
  
// --------------------------------------------------------------------------------------------------------------------------------------------------  
      function usuarioOrigenOnChange() {
            var estadoLista = get('frmContenido.hListaVisible');
            
            if( estadoLista == "" ){  
                ocultarLista();
            }
            
            var arra = new Array();
            arra[0] = ["oidPais",get('frmContenido.oidPais')];
            arra[1] = ["oidIdioma",get('frmContenido.oidIdioma')];      
            arra[2] = ["oid",get('frmContenido.cbUsuarioOrigen')];
            
            // splatas - 10/05/2006 - DBLG400000888
            // recargaCombo("frmContenido.cbUsuarioDestino","COBObtenerUsuariosCobComboMenos1","es.indra.sicc.util.DTOOID",arra);
            asignar([['COMBO','frmContenido.cbUsuarioDestino',
                          'ConectorDruidaTransactionQuery',
                          'dtoSalida.resultado_ROWSET',
                          formarCadenaDT('COBObtenerUsuariosCobComboMenos1', 
                                        'es.indra.sicc.util.DTOOID', 
                                        arra), 
						  'recargarUsuDestino(datos);']]);
                          
    }
      
// splatas - 10/05/2006 - DBLG400000888 -----------------------------------------------------------------------------------------------------------------      
    function recargarUsuDestino(datos){
            
        var  arr = new Array();

        arr[arr.length] = new Array([''],['']);
        for (var i=0 ;i< datos.length ; i++)  {
            arr[arr.length] = datos[i];
        }

        set_combo('frmContenido.cbUsuarioDestino',arr);

        var iSeleccionado = new Array(); 
        var usuDestino = get('frmContenido.usuarioDestino');
        iSeleccionado[0] = usuDestino ;

        set('frmContenido.cbUsuarioDestino',iSeleccionado);
        
        var arra = new Array();
        arra[0] = ["oidPais",get('frmContenido.oidPais')];
        arra[1] = ["oidIdioma",get('frmContenido.oidIdioma')];      
        arra[2] = ["oid",get('frmContenido.cbUsuarioOrigen')];
        
        asignar([['COMBO','frmContenido.cbCodEtapaDeuda',
                          'ConectorDruidaTransactionQuery',
                          'dtoSalida.resultado_ROWSET',
                          formarCadenaDT('COBObtenerEtapasUsuarioCOB', 
                                         'es.indra.sicc.util.DTOOID', 
                                         arra), 
						  'recargarCodEtapaDeuda(datos);']]);
        
        // splatas - 10/05/2006 - DBLG400000888
        // recargaCombo("frmContenido.cbCodEtapaDeuda","COBObtenerEtapasUsuarioCOB","es.indra.sicc.util.DTOOID",arra);      
      
    }
     
// splatas - 10/05/2006 - DBLG400000888  ----------------------------------------------------------------------------------------------------------------
    function recargarCodEtapaDeuda(datos){
        var  arr = new Array();

        arr[arr.length] = new Array([''],['']);
        for (var i=0 ;i< datos.length ; i++)  {
            arr[arr.length] = datos[i];
        }

        set_combo('frmContenido.cbCodEtapaDeuda',arr);

        var iSeleccionado = new Array(); 
        var codEtapaDeuda = get('frmContenido.etapaDeuda');
        iSeleccionado[0] = codEtapaDeuda ;

        set('frmContenido.cbCodEtapaDeuda',iSeleccionado);
      
    }
      
// --------------------------------------------------------------------------------------------------------------------------------------------------      
    function recargaPeriodo(){
        var estadoLista = get('frmContenido.hListaVisible');
            
        if( estadoLista == ""){
            ocultarLista();
        }
        
        var arra = new Array();
        arra[0] = ["pais",get('frmContenido.oidPais')];
		arra[1] = ["canal",get('frmContenido.cbCanal')];
        arra[2] = ["marca",get('frmContenido.cbMarca')];
        //arra[1] = ["canal",get('frmContenido.cbMarca')];
        //arra[2] = ["marca",get('frmContenido.cbCanal')];
        
        // recargaCombo("frmContenido.cbCodPeriodo","CRAObtienePeriodos","es.indra.sicc.dtos.cra.DTOPeriodo",arra);
        asignar([['COMBO','frmContenido.cbCodPeriodo',
                          'ConectorDruidaTransactionQuery',
                          'dtoSalida.resultado_ROWSET',
                          formarCadenaDT('CRAObtienePeriodos', 
                                         'es.indra.sicc.dtos.cra.DTOPeriodo', 
                                         arra), 
						  'recargaCbCodPeriodo(datos);']]);
        
        
     
      }

// splatas - 10/05/2006 - DBLG400000888   -------------------------------------------------------------------------------------------------------------------
    function recargaCbCodPeriodo(datos){
        var  arr = new Array();

        arr[arr.length] = new Array([''],['']);
        for (var i=0 ;i< datos.length ; i++)  {
            arr[arr.length] = datos[i];
        }

        set_combo('frmContenido.cbCodPeriodo',arr);
        
        var iSeleccionado = new Array(); 
        iSeleccionado[0] = get('frmContenido.periodo');
        set('frmContenido.cbCodPeriodo', iSeleccionado);
        
    }
      
      
// --------------------------------------------------------------------------------------------------------------------------------------------------      
      function  buscarOnClick(){
        var porcentajeH = get('frmContenido.txtPorcentajeHasta');
        var importeH = get('frmContenido.txtImporteHasta');
      
        if(!sicc_validaciones_generales("gr")){
            return false;
        }  
            
        if ( porcentajeH != ''  &&  importeH != '' ) {
            GestionarMensaje("1474", null, null, null);
            focaliza('frmContenido.txtPorcentajeHasta');
            return;
        
        } else { 
          
            if( porcentajeH == ''  &&  importeH == '' ){   
              GestionarMensaje("3336", null, null, null);
              focaliza('frmContenido.txtPorcentajeHasta');
              return;
            
            } else {
                //  splatas: Se modifica para quitar el paginado - DBLG400000888
                // configurarPaginado(mipgndo,"COBBuscarAsignacionesCobranza",
                // "ConectorBuscarAsignacionesCobranza","es.indra.sicc.dtos.cob.DTOAsignacionesCobranza", 
                // armarArray());
                if( porcentajeH != ''  &&   porcentajeH > 100 ){
                    GestionarMensaje("3335", null, null, null);
                    focaliza('frmContenido.txtPorcentajeHasta');
                    return;
              }
                                          
              set('frmContenido.accion','buscar');         
              set('frmContenido.conectorAction','LPReasignarCarteraSaldos');
              enviaSICC('frmContenido', '', '', 'N');
            
            }
                    
        }
      
      }     
      
// --------------------------------------------------------------------------------------------------------------------------------------------------      
       function armarArray(){
            var arra = new Array();
            var pos = 0;

            if(get("frmContenido.cbUsuarioOrigen")!="" && get("frmContenido.cbUsuarioOrigen")!=null){
                arra[pos] = ["usuarioOrigen",get('frmContenido.cbUsuarioOrigen')];
                set ('frmContenido.usuarioOrigen',get('frmContenido.cbUsuarioOrigen'));
                pos++;
             }
             
             if(get("frmContenido.cbUsuarioDestino")!="" && get("frmContenido.cbUsuarioDestino")!=null){
                arra[pos] = ["usuarioDestino",get('frmContenido.cbUsuarioDestino')];
                set ('frmContenido.usuarioOrigen',get('frmContenido.cbUsuarioDestino'));
                pos++;
             }
             
             if(get("frmContenido.cbCodEtapaDeuda")!="" && get("frmContenido.cbCodEtapaDeuda")!=null){
                arra[pos] = ["etapaDeuda",get('frmContenido.cbCodEtapaDeuda')];
                set ('frmContenido.etapaDeuda',get('frmContenido.cbCodEtapaDeuda'));
                pos++;
             }
             
             if(get("frmContenido.cbMarca")!="" && get("frmContenido.cbMarca")!=null){
                arra[pos] = ["marca",get('frmContenido.cbMarca')];
                set ('frmContenido.marca',get('frmContenido.cbMarca'));
                pos++;
             }
             
             if(get("frmContenido.cbCanal")!="" && get("frmContenido.cbCanal")!=null){
                arra[pos] = ["canal",get('frmContenido.cbCanal')];
                set ('frmContenido.canal',get('frmContenido.cbCanal'));
                pos++;
             }
             
             if(get("frmContenido.cbCodPeriodo")!="" && get("frmContenido.cbCodPeriodo")!=null){
                arra[pos] = ["periodo",get('frmContenido.cbCodPeriodo')];
                set ('frmContenido.periodo',get('frmContenido.cbCodPeriodo'));
                pos++;
             }
             
             if(get("frmContenido.txtPorcentajeHasta")!="" && get("frmContenido.txtPorcentajeHasta")!=null){
                arra[pos] = ["porcentajeHasta",get('frmContenido.txtPorcentajeHasta')];
                set ('frmContenido.porcentajeHasta',get('frmContenido.txtPorcentajeHasta'));
                pos++;
             }
             
             if(get("frmContenido.txtImporteHasta")!="" && get("frmContenido.txtImporteHasta")!=null){
                arra[pos] = ["importeHasta",get('frmContenido.txtImporteHasta')];
                set ('frmContenido.importeHasta',get('frmContenido.txtImporteHasta'));
                pos++;
             }
             
             arra[pos] = ["paginado","1"];
             
             
             set ('frmContenido.porcentajeHasta',get('frmContenido.txtPorcentajeHasta'));
             set ('frmContenido.importeHasta',get('frmContenido.importeHasta'));
         
      return arra;
    }
    
// --------------------------------------------------------------------------------------------------------------------------------------------------
    function tabSimple(nombre){
        focaliza(nombre);
    }
    
// --------------------------------------------------------------------------------------------------------------------------------------------------    
    function tabHTML (nombre){
        focaliza(nombre);
    }
    
// --------------------------------------------------------------------------------------------------------------------------------------------------
   function muestraLista(ultima, rowset) {
        var tamano = rowset.length;
        if (tamano > 0) {
			mostrarLista();
        }else{
			ocultarLista();
        }
		// dmorello, 05/06/2005
		return true;
	}   

// --------------------------------------------------------------------------------------------------------------------------------------------------
   function ocultarLista(){
	    document.all["Cplistado1"].style.visibility='hidden';
	    document.all["CpLin1listado1"].style.visibility='hidden';
	    document.all["CpLin2listado1"].style.visibility='hidden';
	    document.all["CpLin3listado1"].style.visibility='hidden';
	    document.all["CpLin4listado1"].style.visibility='hidden';
	    document.all["primera1Div"].style.visibility='hidden';
	    document.all["ret1Div"].style.visibility='hidden';
	    document.all["ava1Div"].style.visibility='hidden';
	    document.all["separaDiv"].style.visibility='hidden';
        document.all["Reasignar"].style.visibility='hidden';
      
	    eval (ON_RSZ);  
	    
	}
  
// --------------------------------------------------------------------------------------------------------------------------------------------------  
  	function mostrarLista(){
          DrdEnsanchaConMargenDcho('listado1',12);
          document.all["Cplistado1"].style.visibility='visible';
          document.all["CpLin1listado1"].style.visibility='visible';
          document.all["CpLin2listado1"].style.visibility='visible';
          document.all["CpLin3listado1"].style.visibility='visible';
          document.all["CpLin4listado1"].style.visibility='visible';
          document.all["primera1Div"].style.visibility='visible';
          document.all["ret1Div"].style.visibility='visible';
          document.all["ava1Div"].style.visibility='visible';
          document.all["separaDiv"].style.visibility='visible';
          document.all["Reasignar"].style.visibility='visible';
          eval (ON_RSZ);  
	}
    
// --------------------------------------------------------------------------------------------------------------------------------------------------
   function fLimpiar(){
        set_combo('frmContenido.cbUsuarioDestino', [[''],['']]);
        set_combo('frmContenido.cbCodEtapaDeuda', [[''],['']]);
        set_combo('frmContenido.cbCodPeriodo', [[''],['']]);
        ocultarLista();
        focaliza('frmContenido.cbUsuarioOrigen','');
	}
  
// --------------------------------------------------------------------------------------------------------------------------------------------------
   function reasignarOnClick(){
    set('frmContenido.accion','reasignar');
    set('frmContenido.conectorAction','LPReasignarCarteraSaldos');
    
    // splatas - 10/05/2006 - DBLG400000888
    //eval("frmContenido").oculto="S";
    enviaSICC('frmContenido', '', '', 'N');
    
  }

// --------------------------------------------------------------------------------------------------------------------------------------------------  
  function quitaOculto(){
    eval("frmContenido").oculto="N";
  }      

// --------------------------------------------------------------------------------------------------------------------------------------------------
    function validarNumericosPorcentaje(){
		if (get('frmContenido.txtPorcentajeHasta')!=''){
	  	    accion('frmContenido.txtImporteHasta','.disabled=true');
		} else {
	  	    accion('frmContenido.txtImporteHasta','.disabled=false');
		}
  		if(!sicc_validaciones_generales("gr1")){
			return false;
		}      
    }

// --------------------------------------------------------------------------------------------------------------------------------------------------    
    function validarNumericosImporte(){
		if (get('frmContenido.txtImporteHasta')!=''){	  	    
	  	    accion('frmContenido.txtPorcentajeHasta','.disabled=true');
		} else {
	  	    accion('frmContenido.txtPorcentajeHasta','.disabled=false');
		}
  		if(!sicc_validaciones_generales("gr1")){
			return false;
		}      
    }
   
// --------------------------------------------------------------------------------------------------------------------------------------------------   
              function arrayComponentes(){
              var arr = new Array();
              arr[arr.length]= new Array("cbUsuarioOrigen","");
              arr[arr.length]= new Array("btnBuscar","BOTON");            
              arr[arr.length]= new Array("Reasignar","BOTONXY");            
              
              return arr;
          }
// --------------------------------------------------------------------------------------------------------------------------------------------------          
          function tabGenerico(nombreComp, tipotab){       
            var arr = arrayComponentes();
            var tabular = false;
            var nombreFormulario = getFormularioSICC();
            var j = 0;
            var k = arr.length;
            if (tipotab != "sh") {
                j = j-1;                
                k = k-1;
            }

            while(j<k){
                var t;
                if(tipotab == "sh"){
                  k--;
                  t = k;
                } else{
                  j++;
                  t = j;                  
                }
                  
                var nombre = arr[t][0];
                var tipo = arr[t][1];
                if (tabular==false){
                  if (nombreComp==nombre){
                      tabular=true;
                      if (tipotab == "sh"){
                        if (k==0) k= arr.length;
                      } else {
                        if ((j+1)==k)  j = -1;
                      }
                  }                
                } else {
                  try {
                    var name = nombreFormulario+"."+nombre;
                    if (tipo=="BOTONXY"){
			if (document.all["primera1Div"].style.visibility=='hidden') throw new Exception();
                       focalizaBotonHTML_XY(nombre);
                    } else if (tipo=="BOTON") {
                       focalizaBotonHTML("botonContenido",nombre);
                    } else {
                       focaliza(name);
                    }
                    return;
                  } catch (e) {
                  }
                }
            }
          }
// --------------------------------------------------------------------------------------------------------------------------------------------------
