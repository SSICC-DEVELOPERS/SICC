function onLoadPag(){
		configurarMenuSecundario("frmContenido");
        fMostrarMensajeError();
		focaliza('frmContenido.cbMotivoAprobacion');
	}
	
	function fVolver(){
		window.close();
	}

	function fLimpiar(){
		set('frmContenido.areaObservacionesAprob', '');
		focaliza('frmContenido.cbMotivoAprobacion');
	}

	function btnaceptar_click(){
		if( sicc_validaciones_generales() ){
			set('frmContenido.accion', 'guardarAprobacion');
			enviaSICC("frmContenido");
		}
	}

	function tab(elemento){
		switch(elemento){
			case 'cbMotivoAprobacion': focaliza('frmContenido.areaObservacionesAprob'); break;
			case 'areaObservacionesAprob': document.selection.empty(); focalizaBotonHTML('botonContenido', 'btnAceptar'); break;
			case 'btnAceptar': focaliza('frmContenido.cbMotivoAprobacion'); break;
		}
	}

	function shtab(elemento){
		switch(elemento){
			case 'cbMotivoAprobacion': focalizaBotonHTML('botonContenido', 'btnAceptar'); break; 
			case 'areaObservacionesAprob': document.selection.empty(); focaliza('frmContenido.cbMotivoAprobacion'); break;
			case 'btnAceptar': focaliza('frmContenido.areaObservacionesAprob'); break;
		}
	}