var form = "frmContenido.";

	function onLoadPag(){
        configurarMenuSecundario('frmContenido');
		mostrarListado();
		accionPaginacion();		
	}

	function ocultarListado(){
		DrdEnsanchaConMargenDcho('listado1',12);

		document.all["Cplistado1"].style.visibility='hidden';
		document.all["CpLin1listado1"].style.visibility='hidden';
		document.all["CpLin2listado1"].style.visibility='hidden';
		document.all["CpLin3listado1"].style.visibility='hidden';
		document.all["CpLin4listado1"].style.visibility='hidden';

		document.all["primera1Div"].style.visibility='hidden';
		document.all["ret1Div"].style.visibility='hidden';
		document.all["ava1Div"].style.visibility='hidden';
		document.all["separaDiv"].style.visibility='hidden';

		document.all["DesgloseDiv"].style.visibility='hidden';		

		eval (ON_RSZ);  
		ON_RSZ = '';
	}


	function mostrarListado(){
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

		document.all["DesgloseDiv"].style.visibility='visible';		

		eval (ON_RSZ);  
		ON_RSZ = '';
	}


	function gestionarLista(ultima, rowset){
		var tamano = rowset.length;
		if (tamano > 0) {
			mostrarListado();
			focalizaBotonHTML('botonContenido', 'Desglose');
			return true;
		} else {
			mostrarListado();
			this.close();
			
		}
	}


	function accionPaginacion(){
		configurarPaginado(mipgndo, "PEDAgrupacionEstados", "ConectorAgrupacionEstados", 
                          "es.indra.sicc.dtos.ped.DTOEDesglose", armarArray() );
	}


	function armarArray(){
		var hh = new Array();
		var i=0;
		hh[i] = new Array('oidPais', get(form + 'pais'));
		i++;
		hh[i] = new Array('oidIdioma', get(form + 'idioma'));
		i++;
		if( get(form + 'fechaInicio') != '' ){
			hh[i] = new Array('fechaInicio', get(form + 'fechaInicio'));
			i++;
		}
		if( get(form + 'fechaFin') != '' ){
			hh[i] = new Array('fechaFin', get(form + 'fechaFin'));
			i++;
		}
		if( get(form + 'oidTipoSolicitud') != '' ) {
			hh[i] = new Array('tipoSolicitud', get(form + 'oidTipoSolicitud'));
			i++;
		}
		if( get(form + 'oidZona') != '' ){
			hh[i] = new Array('zona', get(form + 'oidZona'));
			i++;
		}
		if( get(form + 'oidGrupoProcesos') != '' ){
			hh[i] = new Array('grupoProcesos', get(form + 'oidGrupoProcesos'));
			i++;
		}
		hh[i] = new Array('hacerPaginacion', 'true');
	//	alert("Array: " + hh);
		return hh;
	}


	function accionDesglose(){
		var valorSeteado = mipgndo.lista.codSeleccionados();
		if( valorSeteado != '' ){
		//	alert("ValorSeteado: " + valorSeteado);
			var obj = new Object();
			obj.accion = 'desglose';
			obj.fechaInicio = get(form + 'fechaInicio');
			obj.fechaFin = get(form + 'fechaFin');
			obj.oidTipoSolicitud = get(form + 'oidTipoSolicitud');
			obj.oidMarca = get(form + 'oidMarca');
			obj.oidCanal = get(form + 'oidCanal');
			obj.oidZona = get(form + 'oidZona');
			obj.oidGrupoProcesos = get(form + 'oidGrupoProcesos');
//			obj.oidAcceso = valorSeteado;
			var winModal = mostrarModalSICC('LPDesgloseEstados', 'desglose', obj, 790, 398);
		}else{
			GestionarMensaje('4', null, null, null);
		}
	}

    function fVolver(){
        window.close();
    }