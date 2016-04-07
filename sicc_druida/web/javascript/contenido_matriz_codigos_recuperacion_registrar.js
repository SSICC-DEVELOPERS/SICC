/*
    $Id: contenido_matriz_codigos_recuperacion_registrar.js,v 1.1 2009/12/03 19:02:29 pecbazalar Exp $
*/

var formName = 'frmFormulario.';
var formNameSinPunto = 'frmFormulario';
var array = new Array();

function fGuardar(){	
	if (get(formName + 'hidDatosReemp')=="S"){
		eval('frmFormulario').oculto="S";
		set(getFormularioSICC()+'.accion','guardarMatriz');
		set(getFormularioSICC()+'.conectorAction','LPMantenimientoMatrizCodigosRecuperacion');
		enviaSICC(getFormularioSICC(), null, null, "N");
	} else{
//		focalizaBotonHTML('botonContenido' ,'btnBuscarProductoReemplazo');	
	}
}

function reInicio() {
	eval('frmFormulario').oculto="N";
	set(getFormularioSICC()+'.accion','');
	set(getFormularioSICC()+'.conectorAction','LPMantenimientoMatrizCodigosRecuperacion');
	enviaSICC(getFormularioSICC(), null, null, "N");
}


function inicializar(){
	configurarMenuSecundario("frmFormulario");
	if( !fMostrarMensajeError() ){
		focalizaBotonHTML('botonContenido' ,'btnBuscarProductoActual');	
		if(get(formName + 'accion')=="Matriz seleccionada") {
			deshabilitarHabilitarBoton('botonContenido','btnBuscarProductoRecuperado','D');
			accion(formName + 'ckRecuperacionAutomatica','.disabled=true');  
			accion(formName + 'ckEmitirMensaje','.disabled=true');   
			accion(formName + 'cbPeriodoMatrizRecuperada','.disabled=true');  
		} else {
			//if(get(formName + 'accion')=="productoPrincipalSeleccionado") {
				deshabilitarHabilitarBoton('botonContenido','btnBuscarProductoRecuperado','A');
			//}
		}
		if(get(formName + 'hidDatosReemp')=="N") {
			//GestionarMensaje('1210',null,null,null);
			accion(formName + 'ckRecuperacionAutomatica','.disabled=true');  
			accion(formName + 'ckEmitirMensaje','.disabled=true');   
		} else {
			var per = get(getFormularioSICC()+'.oidPeriodo');
			if (per != "") {
				array[0] = (per);
				set(formName + "cbPeriodoMatrizRecuperada",array);
			}
			if(get(formName + 'hidDatosReemp')=="S") {
				btnProxy(1,'1');
			}
		}
		accion('frmFormulario.rbRegion', '.checked=true');
		this.onClickRegion();
	}
}

function buscarProductoPrincipal(){
	eval('frmFormulario').oculto="N";
	set(getFormularioSICC()+'.accion','buscarProductoPrincipalRecuparacion');

	set(getFormularioSICC()+'.conectorAction','LPBuscarProductosVenta');
	enviaSICC(getFormularioSICC(), null, null, "N");
}

function buscarGrupoProducto(accion){
	if(sicc_validaciones_generales()){
		eval('frmFormulario').oculto="N";
		set(getFormularioSICC()+'.accion',accion);
		set(getFormularioSICC()+'.UltimaLP',get(getFormularioSICC()+'.conectorAction'));
		set(getFormularioSICC()+'.conectorAction','LPBuscarProductosVenta');
		set(getFormularioSICC()+'.oidPeriodo',get(getFormularioSICC() + '.cbPeriodoMatrizRecuperada'));
		enviaSICC(getFormularioSICC(), null, null, "N");
	} 

}


function focalizaSig(componente) {
	if (componente==1){
	   if(get(formName + 'accion')=="Matriz seleccionada") {
			focalizaBotonHTML('botonContenido' ,'btnBuscarProductoActual');	
	   } else {
		   focaliza(formName + 'cbPeriodoMatrizRecuperada','');  
	   }  
	}else if (componente==2){
			focalizaBotonHTML('botonContenido' ,'btnBuscarProductoActual');	
	}
}


function focalizaAnt(componente) {
	if (componente==1){		
		focalizaBotonHTML('botonContenido' ,'btnBuscarProductoRecuperado');	
	} else if (componente==2){	
		if(get(formName + 'hidDatosReemp')=="S") 			
	      focaliza(formName + 'ckEmitirMensaje','');  
		else 
	     focaliza(formName + 'cbPeriodoMatrizRecuperada','');  
	}
}

	function onClickRegion(){
    	set('frmFormulario.cbRegion', '');
		set('frmFormulario.hZona', '');
		set('frmFormulario.hRegion', 'S');
		accion('frmFormulario.rbZona', '.checked=false');
		set('frmFormulario.cbZona', '');	
		accion('frmFormulario.cbZona', '.disabled=true');	
		accion('frmFormulario.cbRegion', '.disabled=false');
	}

	function onClickZona(){
		accion('frmFormulario.rbRegion', '.checked=false');
		set('frmFormulario.hZona', 'S');
		set('frmFormulario.hRegion', '');
		set('frmFormulario.cbRegion', '');
		accion('frmFormulario.cbRegion', '.disabled=true');
		accion('frmFormulario.cbZona', '.disabled=false');	
	}


	function tipoClienteOnChange(){

	  recargaCombo('frmFormulario.cbSubTipoCliente', 'MAEobtenerSubtipos', 'es.indra.sicc.util.DTOOID', makeParameter('oid',get('frmFormulario.cbTipoCliente') ));

	  set_combo('frmFormulario.cbTipoClasificacion',new Array()); 
	  set_combo('frmFormulario.cbClasificacion',new Array()); 
	}

	function onChangeSubtipoCliente(){

	  recargaCombo('frmFormulario.cbTipoClasificacion', 'MAEobtenerTipoClasificacion', 
				   'es.indra.sicc.util.DTOOID', makeParameter('oid',get('frmFormulario.cbSubTipoCliente')));
	  set_combo('frmFormulario.cbClasificacion',new Array()); 
	}

	function onChangeTipoClasificacion(){

	  recargaCombo('frmFormulario.cbClasificacion', 'MAEobtenerClasificacionesPorTipo', 
				   'es.indra.sicc.util.DTOOID', makeParameter('oid',get('frmFormulario.cbTipoClasificacion')));
	}

	
	
	function makeParameter(nombre, oid){
              var array = new Array();
              var i=0;
              array[i] = new Array('oidPais', get('frmFormulario.hPais') );
              i++;
              array[i] = new Array('oidIdioma', get('frmFormulario.hIdioma') );
              i++;
			  array[i] = new Array(nombre,oid);              
			  
              return array;
     }



	function focalizaTab(campo){  

		if(campo==1){
			if( cbSubTipoCliente.disabled == false )
				focaliza("frmFormulario.cbSubTipoCliente");
			else
				focoPrimerCampo();
		} else if(campo==2){
			if( cbTipoClasificacion.disabled == false )
				focaliza("frmFormulario.cbTipoClasificacion");
			else
				focoPrimerCampo();
		}else if(campo==3){
			if( cbClasificacion.disabled == false )
				focaliza("frmFormulario.cbClasificacion");
			else
				focoPrimerCampo();
		}else if(campo==4){
			focoPrimerCampo();
		}
   }