var form = "frmContenido.";

	function onLoadPag(){
	  mostrarListado();
	  configurarMenuSecundario('frmContenido');
  	  accionPaginacion();
	}

	function accionPaginacion(){
		configurarPaginado(mipgndo, "PEDDesgloseNumeroSolicitud", "ConectorDesgloseNumeroSolicitud", 
							"es.indra.sicc.dtos.ped.DTOEDesglose", armarArray());
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
		if( get(form + 'marca') != '' ) {
			hh[i] = new Array('marca', get(form + 'marca'));
			i++;
		}
		if( get(form + 'canal') != '' ) {
			hh[i] = new Array('canal', get(form + 'canal'));
			i++;
		}
		if( get(form + 'zona') != '' ){
			hh[i] = new Array('zona', get(form + 'zona'));
			i++;
		}
		if( get(form + 'grupoProcesos') != '' ){
			hh[i] = new Array('grupoProcesos', get(form + 'grupoProcesos'));
			i++;
		}
		if( get(form + 'tipoCliente') != '' ){
			hh[i] = new Array('tipoCliente', get(form + 'tipoCliente'));
			i++;
		}
		if( get(form + 'subtipoCliente') != '' ){
			hh[i] = new Array('subtipoCliente', get(form + 'subtipoCliente'));
			i++;
		}
		if( get(form + 'tipoClasificacion') != '' ){
			hh[i] = new Array('tipoClasificacion', get(form + 'tipoClasificacion'));
			i++;
		}
		if( get(form + 'clasificacion') != '' ){
			hh[i] = new Array('clasificacion', get(form + 'clasificacion'));
			i++;
		}
		if( get(form + 'acceso') != '' ){
			hh[i] = new Array('acceso', get(form + 'acceso'));
			i++;
		}
		if( get(form + 'estadoSolicitud') != '' ){
			hh[i] = new Array('estadoSolicitud', get(form + 'estadoSolicitud'));
			i++;
		}
//		hh[i] = new Array('hacerPaginacion', 'true');
	//	alert("Array: " + hh);
		return hh;
	}


	function gestionarLista(ultima, rowset){
		var tamano = rowset.length;
		if (tamano > 0) {
			mostrarListado();
//			focalizaBotonHTML('botonContenido', 'Desglose');
			return true;
		} else {
			mostrarListado();
			this.close();
			return false;
		}
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

		eval (ON_RSZ);  
		ON_RSZ = '';
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

		eval (ON_RSZ);  
		ON_RSZ = '';
	}

    function fVolver(){
        window.close();
    }