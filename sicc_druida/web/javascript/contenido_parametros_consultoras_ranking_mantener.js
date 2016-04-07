/**
     Autor : Pcabrera
**/


function onLoadPag() {  
        configurarMenuSecundario('formulario');
  
        focaliza("formulario.cbBaseCalculo");
  
        if (get('formulario.errDescripcion')!='') {
            var wnd = fMostrarMensajeError(get('formulario.errCodigo'), get('formulario.errDescripcion'));
        }	
    
        datosCargados();  
        comprobarHabilitacion();
        
        var menu = get("formulario.opcionMenu");
        if (menu=="Consultar Concurso Ranking"){
                btnProxy(1,'0');
                btnProxy(2,'1');
                btnProxy(5,'0');
                btnProxy(7, 0);
                btnProxy(8, 0);
                btnProxy(9, 0);
                deshabilitarBotones();
        }
        
         if (get("formulario.opcionMenu") == "Modificar Concurso Ranking"){
            btnProxy(2,'1');
            btnProxy(7, 0);
			btnProxy(8, 0);
			btnProxy(9, 0);
        }
  
        finCargaPagina = true; 
   
    }//--Fin onLoadPag


    function onChangeBaseCalculo(){

        var oidSelecc = get("formulario.cbBaseCalculo"); 
        var consMont = get("formulario.oidBC_Calculo_Monto");
        var consCal = get("formulario.oidBC_Recomendada");
    
        if (oidSelecc == consMont){
            accion("formulario.cbTipoVenta", ".disabled=false");
            /*accion("formulario.cbPeriodoDesde", ".disabled=false");
            accion("formulario.cbPeriodoHasta", ".disabled=false");*/
            
            accion("formulario.cbPeriodoDesde", ".disabled=true");
           accion("formulario.cbPeriodoHasta", ".disabled=true");
        }else{
            set("formulario.cbTipoVenta", "");
            accion("formulario.cbTipoVenta", ".disabled=true");       
               
            if (oidSelecc == consCal){
                accion("formulario.cbPeriodoDesde", ".disabled=false");
                accion("formulario.cbPeriodoHasta", ".disabled=false");
            }else{
                set("formulario.cbPeriodoDesde", "");
                set("formulario.cbPeriodoHasta", "");          
                accion("formulario.cbPeriodoDesde", ".disabled=true");
                accion("formulario.cbPeriodoHasta", ".disabled=true");  
             }  
          }
  
    } //--Fin onChangeBaseCalculo()


    function comprobarDatosObligatorios(){
        var datosObligatorios = true;
    
        if(get('formulario.cbBaseCalculo')== '')
            datosObligatorios = false;
    
        return datosObligatorios;            
    }//-- Fin comprobarDatosObligatorios()


    function fGuardar(){
        if (sicc_validaciones_generales('datosAdicionalesObligatorios')){
            var vDatosOblig = comprobarDatosObligatorios();
            set('formulario.datosObligatorios', vDatosOblig); 
            
            set('formulario.conectorAction', 'LPMantenerParametrosConsultorasRanking');
            eval('formulario').oculto="S"; 
            set('formulario.accion', 'guardar');
            enviaSICC('formulario','','','N');
    
        }  
    } //--Fin fGuardar
    
    
    
    function focalizaTab(){
        if(cbTipoVenta.disabled == false ){
            focaliza("formulario.cbTipoVenta");      
        }   
		else{
            if(cbPeriodoDesde.disabled == true ){
                focalizaBotonHTML('botonContenido','btnEstatusVenta');
            }
            else{
                focaliza("formulario.cbPeriodoDesde");             
            }    
        } 
    } //--Fin focalizaTab
 
 
    function focalizaTab1(){
        focaliza("formulario.cbBaseCalculo"); 
    }


    function focalizaShTab(){  
        focalizaBotonHTML('botonContenido','btnParticipantes');
    }  


    function onClickEstatusVenta(){
        var obj = new Object();
        obj.opcionMenu = get('formulario.opcionMenu');
        var whnd = mostrarModalSICC('LPMantenerParametrosConsultorasRanking','cargar estatus venta ranking',obj,null,510);
        
        if (whnd != null){
            set('formulario.hidIngresoEVTA','1');
            set ('formulario.hidLstEstatusVta',whnd[0]);         
            set('formulario.conectorAction', 'LPMantenerParametrosConsultorasRanking');
            eval('formulario').oculto="S"; 
            set('formulario.accion', 'almacenar estatus venta ranking');
            enviaSICC('formulario', null, null, 'N');
        }
    }//-- Fin onClickEstatusVenta


    function onClickParticipantes() {                
        var obj = new Object();
        obj.opcionMenu = get('formulario.opcionMenu');
        
        var whnd = mostrarModalSICC('LPMantenerParametrosConsultorasRanking','cargar clasificacion participantes ranking',obj);
        
        if (whnd != null) {		  
            set('formulario.hidIngresoPAR','1');
            set('formulario.hidLstClasConsul', whnd[0] );
            set('formulario.hidListaClasif', whnd[1] );
            set('formulario.conectorAction', 'LPMantenerParametrosConsultorasRanking');
            eval('formulario').oculto="S"; 
            set('formulario.accion', 'almacenar clasificacion participantes ranking');
            enviaSICC('formulario', null, null, 'N'); 
        }
    } //-- Fin onClickParticipantes

	function accionExitosa(){
		eval('formulario').oculto="N";
	}
   
    function fLimpiar(){
        if(get('formulario.opcionMenu')!="Modificar Concurso Ranking"){  
        
            set("formulario.cbBaseCalculo", "");  
            set("formulario.cbTipoVenta", "");        
            set("formulario.cbPeriodoDesde", "");
            set("formulario.cbPeriodoHasta", "");        
            accion("formulario.cbPeriodoDesde", ".disabled=true");
            accion("formulario.cbPeriodoHasta", ".disabled=true");     
            
            focaliza("formulario.cbBaseCalculo");
        
        } else {
            set('formulario.conectorAction', 'LPMantenerParametrosConsultorasRanking'); 
            set('formulario.accion', '');
            eval('formulario').oculto = 'N';
            enviaSICC('formulario',null,null,'N');
        }
    
    }//--Fin fLimpiar  
    
	function fVolver(){
      window.close();
	}
   
    
    //--Para saber si tengo datos seleccionados 
    //--en los combos
    function datosCargados(){
        
        var oidBase = get("formulario.oidBaseCalculo");    
        
        if (oidBase !=""){
             marcaSeleccionDelUsuario('formulario.cbBaseCalculo', get('formulario.oidBaseCalculo'));
        }
        
        var oidTipVenta = get("formulario.oidTipoVenta");
        
        if (oidTipVenta !=""){
            marcaSeleccionDelUsuario('formulario.cbTipoVenta', get('formulario.oidTipoVenta'));
        }
        
        var oidTPerD = get("formulario.oidPerDesde");  
        
        if (oidTPerD !=""){
            marcaSeleccionDelUsuario('formulario.cbPeriodoDesde', get('formulario.oidPerDesde'));
        }
        
        var oidTPerH = get("formulario.oidPerHasta"); 
        
        if (oidTPerH !=""){
            marcaSeleccionDelUsuario('formulario.cbPeriodoHasta', get('formulario.oidPerHasta'));
        }
    
    }
    
    
    function marcaSeleccionDelUsuario(pControl, datos){
		datos = datos.split(",");
		var comb = pControl;
        set(comb, datos);
	}
   
   
   function comprobarHabilitacion(){
       var oidSelecc = get("formulario.oidBaseCalculo");    
       var consMont = get("formulario.oidBC_Calculo_Monto");
       var consCal = get("formulario.oidBC_Recomendada");

       if (oidSelecc == consMont){
           accion("formulario.cbTipoVenta", ".disabled=false");
           accion("formulario.cbPeriodoDesde", ".disabled=true");
           accion("formulario.cbPeriodoHasta", ".disabled=true");
      }else{
           accion("formulario.cbTipoVenta", ".disabled=true");     
           set("formulario.cbTipoVenta", "");
            
           if (oidSelecc == consCal){
               accion("formulario.cbPeriodoDesde", ".disabled=false");
               accion("formulario.cbPeriodoHasta", ".disabled=false");
            }else{
                 set("formulario.cbPeriodoDesde", "");
                 set("formulario.cbPeriodoHasta", "");          
                 accion("formulario.cbPeriodoDesde", ".disabled=true");
                 accion("formulario.cbPeriodoHasta", ".disabled=true");  
             }  		
     }
    
    }
   
    function deshabilitarBotones(){     
        
        accion("formulario.cbBaseCalculo", ".disabled=true");
        accion("formulario.cbTipoVenta", ".disabled=true");
        accion("formulario.cbPeriodoDesde", ".disabled=true");
        accion("formulario.cbPeriodoHasta", ".disabled=true");
      
    
    }
    
    
    function guardarKO(){
        if(get('formulario.opcionMenu')=="Modificar Concurso Ranking"){  
            btnProxy(1,1);
            btnProxy(2,1);
            btnProxy(3,0);
            btnProxy(4,0);
            btnProxy(5,1);
            btnProxy(7,0);
            btnProxy(8,0);
            btnProxy(9,0);
          
            focaliza('formulario.cbBaseCalculo');
          
        } else {
                focaliza('formulario.cbBaseCalculo');
        }
    }
