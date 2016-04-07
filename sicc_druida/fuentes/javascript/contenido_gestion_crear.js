	function onLoadPag(){ 
		
        // Prepara los filtros 
		var arrDatos = new Array();
        var i=0;
        
        arrDatos[i] = new Array('oidPais',get('frmFormulario.hPais'));
		i++;
		arrDatos[i] = new Array('oidIdioma',get('frmFormulario.hIdioma'));
		i++;
		arrDatos[i] = new Array('paginacion', true);
		i++;

		setTimeout ('configurarMenuSecundario("frmFormulario");',200); 
        // Invoca a la busqueda

		configurarPaginado(mipgndo,'COBBuscarAccionesCobranza','ConectorBuscarAccionesCobranza',
            'es.indra.sicc.dtos.cob.DTOBuscarAccionesCobranza',arrDatos);

        setTimeout ('fMostrarMensajeError();',200);

	    DrdEnsanchaConMargenDcho('listado1',12);
	    
/*	    document.all["Cplistado1"].style.visibility='';
	    document.all["CpLin1listado1"].style.visibility='';
	    document.all["CpLin2listado1"].style.visibility='';
	    document.all["CpLin3listado1"].style.visibility='';
	    document.all["CpLin4listado1"].style.visibility='';

	    document.all["primera1Div"].style.visibility='';
	    document.all["ret1Div"].style.visibility='';
	    document.all["ava1Div"].style.visibility='';
	    document.all["separaDiv"].style.visibility='';*/

	    setTimeout ('eval (ON_RSZ);',200); 

		//[1] focalizaBotonHTML_XY('Crear');

	}

	/*function crearOnClick(){
		var valorSeleccionado = mipgndo.lista.codSeleccionados();

		if( valorSeleccionado != '' ){

		   set('frmFormulario.hOidAccionCob', valorSeleccionado);
		   set('frmFormulario.conectorAction', 'LPCrearGestion');

		   //alert(get('frmFormulario.accion'))

		   if(get('frmFormulario.accion')=="ejecutarSeguimientoTel") {
				set('frmFormulario.accion', 'crearSeguimientoTel');
		   } else {
				set('frmFormulario.accion', 'crear');
		   }

		   enviaSICC('frmFormulario');

		}else{
			GestionarMensaje('8', null, null, null);
		}
	}*/

	function crearOnClick(){
		var valorSeleccionado = mipgndo.lista.codSeleccionados();

		if( valorSeleccionado != '' ){

		   //set('frmFormulario.hOidAccionCob', valorSeleccionado);
		   //set('frmFormulario.conectorAction', 'LPCrearGestion');

		   //alert(get('frmFormulario.accion'))
		   var accion;
		   if(get('frmFormulario.accion')=="ejecutarSeguimientoTel") {
				//set('frmFormulario.accion', 'crearSeguimientoTel');
				accion = "crearSeguimientoTel";
		   } else {
				//set('frmFormulario.accion', 'crear');
				accion = "crear";
		   }

		   //enviaSICC('frmFormulario');
		   var obj = new Object();
		   obj.accion = accion;
		   obj.hOidAccionCob = valorSeleccionado;
		   obj.conectorAction= "LPCrearGestion";
		   var retorno = mostrarModalSICC('LPCrearGestion', obj.accion, obj, null, null);

		}else{
			GestionarMensaje('8', null, null, null);
		}
	}


	function fVolver(){	
		window.close();
	}