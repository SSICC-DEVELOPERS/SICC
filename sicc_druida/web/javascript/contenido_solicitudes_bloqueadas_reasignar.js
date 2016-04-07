var form = "frmContenido."
	
	function onLoadPag()   {
		configurarMenuSecundario("frmContenido");
        fMostrarMensajeError();
		focaliza('frmContenido.areaObservacionesAprob');
		accion('frmContenido.areaObservacionesAprob', '.disabled=false');		
		configurarPaginado(mipgndo, "CAREjecutivosNuevos", "ConectorCAREjecutivosNuevos", 
							"es.indra.sicc.dtos.car.DTOPaginado", [['oidIdioma','1']]);
	}

	function mostrarLista(){
		DrdEnsanchaConMargenDcho('listado1',24);
		document.all["Cplistado1"].style.visibility='visible';
		document.all["CpLin1listado1"].style.visibility='visible';
		document.all["CpLin2listado1"].style.visibility='visible';
		document.all["CpLin3listado1"].style.visibility='visible';
		document.all["CpLin4listado1"].style.visibility='visible';
		document.all["primera1Div"].style.visibility='visible';
		document.all["ret1Div"].style.visibility='visible';
		document.all["ava1Div"].style.visibility='visible';
		document.all["separaDiv"].style.visibility='visible';
		eval (ON_RSZ);  
	}

	function gestionaLista(ultima, rowset){
		var tamano = rowset.length;
		if (tamano > 0) {
			mostrarLista();
			focaliza('frmContenido.areaObservacionesAprob');
//			btnProxy(4, 0);
			return true;
		}
/*		} else {
			ocultarLista();
//			btnProxy(4, 0);
//			focaliza(form + elementos[0]);
			return false;
		}*/
	}

	function fVolver(){
		window.close();
	}

	function aceptar_click(){
		if( sicc_validaciones_generales() ){
			var valorSeteado = mipgndo.lista.codSeleccionados();
			if( valorSeteado != '' ){
				set(form + 'accion', 'guardarReasignacion');
				set(form + 'seleccion', valorSeteado);
				enviaSICC("frmContenido");
			}else{
				GestionarMensaje('8', null, null, null);
			}
		}
	}

	function tab(elemento){
		if( elemento == 'areaObservacionesAprob' ){
			document.selection.empty();
			focalizaBotonHTML('botonContenido', 'btnAceptar');
		}
		if( elemento == 'btnAceptar' ) focaliza('frmContenido.areaObservacionesAprob');
	}
	
	function fLimpiar(){
		set('frmContenido.areaObservacionesAprob', '');
		focaliza('frmContenido.areaObservacionesAprob');
	}