function onLoadPag(){
	
	fMostrarMensajeError();
    configurarMenuSecundario('formulario');
	 
	if(get('formulario.opcionMenu') == 'insertar'){
		focaliza('formulario.txtCodEncuesta');
	
    }
	else if(get('formulario.opcionMenu') == 'modificar'){
			 btnProxy(1,1);
			 btnProxy(2,1);
			 set('formulario.cbMarca', [get('formulario.oidMarca')]);	
			 accion('formulario.txtCodEncuesta', '.disabled = true');
			 accion('formulario.txtDescripcion', '.disabled = false');
			 accion('formulario.cbMarca', '.disabled = false');
	}
	else if(get('formulario.opcionMenu') == 'eliminar' || get('formulario.opcionMenu') == 'consultar'){
			 btnProxy(2,1);
			 set('formulario.cbMarca', [get('formulario.oidMarca')]);
    	     accion('formulario.txtCodEncuesta', '.disabled = true');
			 accion('formulario.txtDescripcion', '.disabled = true');
			 accion('formulario.cbMarca', '.disabled = true');		
	}
}

function fVolver() {
    window.close();
}

function fGuardarOK(){	
         if(get('formulario.opcionMenu') == 'insertar'){	
                  fLimpiar();
         }
         else{
                  window.returnValue = true;
         }

}


function fGuardarERR(){
            eval("formulario").oculto= "N";
}

function fLimpiar(){
		set('formulario.txtCodEncuesta', '');
		set('formulario.txtDescripcion', '');
        set('formulario.cbMarca','');
		limpiaI18N('formulario', 1);
}
function fGuardar(){
	if(sicc_validaciones_generales()) {
		set('formulario.oidMarca', get('formulario.cbMarca'));
		eval('formulario').oculto = 'S';
		set('formulario.conectorAction', 'LPMantenimientoTipoEncuesta');
		set('formulario.accion', 'guardar'); 
		enviaSICC('formulario');	
	}
}
function onTabTxtCodEncuesta(){

	focaliza('formulario.txtDescripcion');

}
function onShTabTxtCodEncuesta(){

	focaliza('formulario.cbMarca');

}
function onTabTxtDescripcion(){

	focaliza('formulario.cbMarca');

}
function onShTabTxtDescripcion(){

	focaliza("formulario.txtCodEncuesta");

}
function onTabCbMarca(){

	focaliza('formulario.txtCodEncuesta');

}
function onShTabCbMarca(){

	focaliza('formulario.txtDescripcion');

}

