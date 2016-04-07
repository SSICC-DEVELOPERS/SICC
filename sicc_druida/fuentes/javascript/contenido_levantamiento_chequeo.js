function onLoadPag(){   
         if (get('formulario.errDescripcion')!='') {
              var wnd = fMostrarMensajeError(get('formulario.errCodigo'),get('formulario.errDescripcion'));
          }
		 fMostrarMensajeError();
         configurarMenuSecundario("formulario");  	
         document.all["capaConsolidado"].style.visibility='hidden';
         document.all["capaNoConsolidado"].style.visibility='hidden';
}

function evaluarRB(){
    if(get('formulario.darOpcion')=='consolidado'){

        mostrarCapaCons();
    }else if(get('formulario.darOpcion')=='region'){
    
        mostrarCapaNoCons();
        accion('formulario.cbZona', '.disabled=true');
        accion('formulario.cbSeccion', '.disabled=true'); 
    
    }else if(get('formulario.darOpcion')=='zona'){
    
       mostrarCapaNoCons();
       accion('formulario.cbZona', '.disabled=false');
       accion('formulario.cbSeccion', '.disabled=true');
    
    }else if(get('formulario.darOpcion')=='seccion'){
       mostrarCapaNoCons();
       accion('formulario.cbZona', '.disabled=false');
       accion('formulario.cbSeccion', '.disabled=false');
    
    }
    
}

function mostrarCapaCons(){
    document.all["capaConsolidado"].style.visibility='visible';
    document.all["capaNoConsolidado"].style.visibility='hidden';
    flimpiar();
}
function mostrarCapaNoCons(){
    document.all["capaNoConsolidado"].style.visibility='visible';
    document.all["capaConsolidado"].style.visibility='hidden'
    flimpiar();
}

function onchangeMarcaCanal(){
    var marca  = get('formulario.cbMarca');
    var canal  = get('formulario.cbCanal');
    if(marca != '' && canal != ''){
                    
         recargaCombo('formulario.cbRegion', 'ZONRecargaRegiones', 
           'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', [['oidMarca', get('formulario.cbMarca')], 
           ['oidCanal', get('formulario.cbCanal')], ['oidPais', get('formulario.pais')]]);
           
    } else {
         set_combo('formulario.cbRegion', arrayVacio());
         set_combo('formulario.cbZona', arrayVacio());
         set_combo('formulario.cbSeccion', arrayVacio());
    }
}

function cbRegionOnChange(){
    
    if(get('formulario.cbRegion')!='' && (get('formulario.darOpcion')=='zona' || get('formulario.darOpcion')=='seccion')){
             
         set_combo('formulario.cbSeccion', arrayVacio());
         recargaCombo('formulario.cbZona', 'ZONRecargaZonas', 
           'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', [['oidRegion', get('formulario.cbRegion')]]);
           
    } else {

         set_combo('formulario.cbZona', arrayVacio());
         set_combo('formulario.cbSeccion', arrayVacio());
    }
    
}

function onchangeZona(){
    var zona = get('formulario.cbZona');
    
    if(zona!='' && get('formulario.darOpcion')=='seccion' ){
       var arr = new Array();
        arr[arr.length] = ["oidIdioma", get('formulario.idioma')]; 
        arr[arr.length] = ["oidPais", get('formulario.pais')]; 
        arr[arr.length] = ["oidZona",zona]; 
        recargaCombo("formulario.cbSeccion", "ZONRecargaSecciones", "es.indra.sicc.dtos.zon.DTOUnidadAdministrativa",arr);
    }else{
         var aCombo = new Array(new Array("",""));
         set_combo('formulario.cbSeccion', aCombo, []); 
    }
   
}

function arrayVacio(){  
    var array = new Array();              
         array[0] = new Array('','');
  
    return array;
}

function flimpiar(){ 
     
     var arr = new Array();
     arr[arr.length] = ["oidIdioma", get('formulario.idioma')]; 
     arr[arr.length] = ["oidPais", get('formulario.pais')]; 
     if(get('formulario.cbMarca')!=""){
        set_combo('formulario.cbMarca', arrayVacio());
        recargaCombo("formulario.cbMarca", "SEGConsultaMarcas", "es.indra.sicc.util.DTOBelcorp",arr);
     }
     if(get('formulario.cbCanal')!=""){
        set_combo('formulario.cbCanal', arrayVacio());
        recargaCombo("formulario.cbCanal", "SEGConsultaCanales", "es.indra.sicc.util.DTOBelcorp",arr);
     }
     
     
     set_combo('formulario.cbRegion', arrayVacio());
     set_combo('formulario.cbZona', arrayVacio());
     set_combo('formulario.cbSeccion', arrayVacio());
     set('formulario.txtNroConsolidado',"");
     set('formulario.chkEvaluacion',"N");
     set('formulario.chkManual',"N");
     set('formulario.chkPrimer',"N");
}

function btnlevantar(){
	/* BELC400000725 - dmorello, 06/09/2007
	 * Se verificarán los datos obligatorios según la capa que se encuentra activa (visible). */
	//if(get('formulario.chkEvaluacion')=='S' ||	get('formulario.chkManual')=='S' || get('formulario.chkPrimer')=='S' ){
	if (datosObligatoriosOK()) {

     set('formulario.hMarca', get('formulario.cbMarca') );
     set('formulario.hCanal', get('formulario.cbCanal'));
     set('formulario.hRegion', get('formulario.cbRegion'));
     set('formulario.hZona', get('formulario.cbZona'));
     set('formulario.hSeccion', get('formulario.cbSeccion'));
     set('formulario.hConsolidado', get('formulario.txtNroConsolidado'));
     set('formulario.hReclamo', get('formulario.chkEvaluacion'));
     set('formulario.hManual', get('formulario.chkManual'));
     set('formulario.hPedido', get('formulario.chkPrimer'));
    
     set('formulario.conectorAction', 'LPLevantamientoChequeo');
     set('formulario.accion', 'levantar');
	 eval('formulario').oculto = "S";
     enviaSICC("formulario",null,null,"N");
	}else{
		GestionarMensaje('APEUI065');
	}
    
}

/* BELC400000725 - dmorello, 06/09/2007
 * Verifica si se llenaron los datos obligatorios de la capa activa */
function datosObligatoriosOK() {
	if (document.all["capaConsolidado"].style.visibility == 'visible') {
		// Capa consolidado visible -> no hay datos obligatorios
		return true;
	} else {
		// Capa zonas visible -> se verifica que los datos obligatorios hayan sido rellenados
		return get('formulario.chkEvaluacion')=='S'
					||	get('formulario.chkManual')=='S'
					|| get('formulario.chkPrimer')=='S';
	}
}

function fVolver(){
         window.close();
}



function tabdarOpcion(){
    if(get('formulario.darOpcion')=='consolidado'){
        document.selection.empty();
        focaliza('formulario.txtNroConsolidado');	
    }else{
        document.selection.empty();
        focaliza('formulario.cbMarca');	
    }
    return;
}
function shtabdarOpcion(){
    if(get('formulario.darOpcion')=='consolidado'){
        document.selection.empty();
        document.all['btnLevantarChequeo'].focus();
    }else{
        document.selection.empty();
        document.all['btnLevantarChequeo'].focus();	
    }
    return;
}    

function shtabtxtNroConsolidado(){
    
     document.selection.empty();
     focaliza('formulario.darOpcion');
     return;
    
}    
function tabtxtNroConsolidado(){
    document.selection.empty();
    document.all['btnLevantarChequeo2'].focus();
    return;

}
function shtabcbMarca(){
    
     document.selection.empty();
     focaliza('formulario.darOpcion');
     return;
    
}    
function tabcbMarca(){
    document.selection.empty();
    focaliza('formulario.cbCanal');	
    return;

}

function shtabcbCanal(){
    
     document.selection.empty();
     focaliza('formulario.cbMarca');
     return;
    
}    
function tabcbCanal(){
    document.selection.empty();
    focaliza('formulario.cbRegion');	
    return;

}

function shtabcbRegion(){
    
     document.selection.empty();
     focaliza('formulario.cbCanal');
     return;
    
}    
function tabcbRegion(){
    document.selection.empty();
    focaliza('formulario.cbZona');	
    return;

}
function shtabcbZona(){
    
     document.selection.empty();
     focaliza('formulario.cbRegion');
     return;
    
}    
function tabcbZona(){
    document.selection.empty();
    focaliza('formulario.cbSeccion');	
    return;

}

function shtabcbSeccion(){
    
     document.selection.empty();
     focaliza('formulario.cbZona');
     return;
    
}    
function tabcbSeccion(){
    document.selection.empty();
    focaliza('formulario.chkEvaluacion');	
    return;

}
function shtabchkEvaluacion(){
    
     document.selection.empty();
     focaliza('formulario.cbSeccion');
     return;
    
}    
function tabchkEvaluacion(){
    document.selection.empty();
    focaliza('formulario.chkManual');	
    return;

}
function shtabchkManual(){
    
     document.selection.empty();
     focaliza('formulario.chkEvaluacion');
     return;
    
}    
function tabchkManual(){
    document.selection.empty();
    focaliza('formulario.chkPrimer');	
    return;

}

function shtabchkPrimer(){
    
     document.selection.empty();
     focaliza('formulario.chkManual');
     return;
    
}    
function tabchkPrimer(){
    document.selection.empty();
    document.all['btnLevantarChequeo'].focus();
    return;

}
function shtabbtnLevantarChequeo2(){
    
     document.selection.empty();
     focaliza('formulario.txtNroConsolidado');
     return;
    
}    
function tabbtnLevantarChequeo2(){
    document.selection.empty();
    focaliza('formulario.darOpcion');	
    return;

}

function shtabbtnLevantarChequeo(){
    
     document.selection.empty();
     focaliza('formulario.chkPrimer');
     return;
    
}    
function tabbtnLevantarChequeo(){
    document.selection.empty();
    focaliza('formulario.darOpcion');	
    return;

}

function mostrarError(){
	fMostrarMensajeError();
}