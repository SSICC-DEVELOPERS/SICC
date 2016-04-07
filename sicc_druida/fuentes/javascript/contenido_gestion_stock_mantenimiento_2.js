function onLoadPag(){
	configurarMenuSecundario("frmContenido");
	set('frmContenido.hPeriodo',  window.dialogArguments.parametros.hPeriodo);
	fMostrarMensajeError();

    DrdEnsanchaConMargenDcho('listado1',12);
    document.all["Cplistado1"].style.visibility='';
    document.all["CpLin1listado1"].style.visibility='';
    document.all["CpLin2listado1"].style.visibility='';
    document.all["CpLin3listado1"].style.visibility='';
    document.all["CpLin4listado1"].style.visibility='';
    document.all["separaDiv"].style.visibility='';
    document.all["primera1Div"].style.visibility='';
    document.all["ret1Div"].style.visibility='';
    document.all["ava1Div"].style.visibility='';
    document.all["btnAceptarDiv"].style.visibility='';
    
	eval (ON_RSZ);  
	ON_RSZ = '';

	ocultarLista();

	focaliza('frmContenido.txtCodigoSAP');

}

function onClickBuscar(){
    /*
    Modificado para cambio SiCC 20070248
    Rafael Romero - 08/07/2007
    */
	if( sicc_validaciones_generales() ){
        var codSAP      = get('frmContenido.txtCodigoSAP');
        var codCATALOGO = get('frmContenido.cbCodCatalogo')
		var desde = get('frmContenido.txtPaginaCatalogoDesde');
		var hasta = get('frmContenido.txtPaginaCatalogoHasta');
        
        if((codSAP == '' && codCATALOGO == '')
                ||(codSAP != '' && codCATALOGO != '')
                ||(codSAP != '' && desde != '')
                ||(codSAP != '' && hasta != '')){
            GestionarMensaje('PED_085');
            return;
        }
        
        if( codCATALOGO != '' && desde != '' && hasta != '' && desde > hasta ){
            GestionarMensaje('PED-0001');
            return;
        }
        
        ocultarLista();
        var a = armarArray();
        //alert("array: " + a);
        configurarPaginado( mipgndo, "PREBuscarCodigoVentaPeriodo2", "ConectorBuscaCodigoVenta2", 
            "es.indra.sicc.dtos.pre.DTOBuscarCodigoVentaPeriodo", a );

	}
}

function muestraLista( ultima, rowset){
	var tamano = rowset.length;
	if (tamano > 0) {
		mostrarLista();
		eval (ON_RSZ);
		ON_RSZ = '';
		focaliza("frmContenido.cbCodCatalogo");
		return true;
	} else {
		ocultarLista();
		focaliza("frmContenido.cbCodCatalogo");
		return false;
	}
}

function fVolver(){
    window.close();
}
	
function onClickAceptar(){
	setMV('frmContenido.cbCodCatalogo', 'N');
    devolverValoresSeleccionados()
}

//Funciones de servicio
function ocultarLista(){
    DrdEnsanchaConMargenDcho('listado1',12);
    document.all["Cplistado1"].style.visibility='hidden';
    document.all["CpLin1listado1"].style.visibility='hidden';
    document.all["CpLin2listado1"].style.visibility='hidden';
    document.all["CpLin3listado1"].style.visibility='hidden';
    document.all["CpLin4listado1"].style.visibility='hidden';
    document.all["separaDiv"].style.visibility='hidden';
    document.all["primera1Div"].style.visibility='hidden';
    document.all["ret1Div"].style.visibility='hidden';
    document.all["ava1Div"].style.visibility='hidden';
    document.all["btnAceptarDiv"].style.visibility='hidden';
    eval (ON_RSZ);  
    ON_RSZ = '';
}


function mostrarLista(){
    document.all["Cplistado1"].style.visibility='visible';
    document.all["CpLin1listado1"].style.visibility='visible';
    document.all["CpLin2listado1"].style.visibility='visible';
    document.all["CpLin3listado1"].style.visibility='visible';
    document.all["CpLin4listado1"].style.visibility='visible';
    document.all["separaDiv"].style.visibility='visible';
    document.all["primera1Div"].style.visibility='visible';
    document.all["ret1Div"].style.visibility='visible';
    document.all["ava1Div"].style.visibility='visible';
    document.all["btnAceptarDiv"].style.visibility='visible';
}


function armarArray(){
	var array = new Array();
	var i = 0;

    // Agregado para busqueda por COD.SAP - SiCC 20070284
	if( get('frmContenido.txtCodigoSAP') != '' ){
		array[i] = new Array("codigoSAP", get('frmContenido.txtCodigoSAP'));
		i++;
	}
    // Fin Agregado

	if( get('frmContenido.hPeriodo') != '' ){
		array[i] = new Array("periodo", get('frmContenido.hPeriodo'));
		i++;
	}

	if( get('frmContenido.cbCodCatalogo') != '' ){
		array[i] = new Array("catalogo", get('frmContenido.cbCodCatalogo'));
		i++;
	}

	if( get('frmContenido.txtPaginaCatalogoDesde') != '' ){
		array[i] = new Array("paginaDesde", get('frmContenido.txtPaginaCatalogoDesde'));
		i++;
	}

	if( get('frmContenido.txtPaginaCatalogoHasta') != '' ){
		array[i] = new Array("paginaHasta", get('frmContenido.txtPaginaCatalogoHasta'));
		i++;
	}
	
    // Agregado para busqueda descripcion SAP - SiCC 20070284
	if( get('frmContenido.hIdioma') != '' ){
		array[i] = new Array("oidIdioma", get('frmContenido.hIdioma'));
		i++;
	}
    
	return array;
}

function pasarCombosAHiddens(){
	set( 'frmContenido.hCodCatalogo', get( 'frmContenido.cbCodCatalogo' ) );
}

function setTabFocus( campo ){
	if( campo == 'txtCodigoSAP' ){
		focaliza('frmContenido.cbCodCatalogo');
	}else if( campo == 'cbCodCatalogo' ){
		focaliza('frmContenido.txtPaginaCatalogoDesde');
	}else if( campo == 'txtPaginaCatalogoDesde' ){
		focaliza('frmContenido.txtPaginaCatalogoHasta');
	}else if( campo == 'txtPaginaCatalogoHasta' ){
		focalizaBotonHTML('botonContenido','btnBuscar');
	}else if( campo == 'btnBuscar' ){
		if( document.all["btnAceptarDiv"].style.visibility != 'hidden' ){
			focalizaBotonHTML_XY('btnAceptar');
		}else{
			setTabFocus('btnAceptar');
		}
	}else if( campo == 'btnAceptar' ){
		focaliza('frmContenido.txtCodigoSAP');
	}
}

function setSHTabFocus( campo ){
	if( campo == 'txtCodigoSAP' ){
		if( document.all["btnAceptarDiv"].style.visibility != 'hidden' ){
			focalizaBotonHTML_XY('btnAceptar');
		}else{
			setSHTabFocus('btnAceptar');
		}
	}else if( campo == 'cbCodCatalogo' ){
		focaliza('frmContenido.txtCodigoSAP');
	}else if( campo == 'txtPaginaCatalogoDesde' ){
		focaliza('frmContenido.cbCodCatalogo');
	}else if( campo == 'txtPaginaCatalogoHasta' ){
		focaliza('frmContenido.txtPaginaCatalogoDesde');
	}else if( campo == 'btnBuscar' ){
		focaliza('frmContenido.txtPaginaCatalogoHasta');
	}else if( campo == 'btnAceptar' ){
		focalizaBotonHTML('botonContenido','btnBuscar');
	}
}

function fLimpiar(){
	focaliza('frmContenido.cbCodCatalogo');
}

function devolverValoresSeleccionados(){
    var seleccionados = listado1.codSeleccionados();
    var array = new Array();
    if( seleccionados.length > 0 ){
        var codigos = listado1.codigos();
		for(j = 0; j < seleccionados.length; j++ ){
			for(i = 0; i < codigos.length; i++ ){
				if( seleccionados[j] == codigos[i] ){
                    array[j] = new Object();
                    array[j].codigoVenta = listado1.datos[i][0];
                    array[j].txtCodigoVenta = listado1.datos[i][1];
                    array[j].codigoSAP = listado1.datos[i][2];
                    array[j].descripcionSAP = listado1.datos[i][3];
                    array[j].codigoCatalogo = listado1.datos[i][4];
                    array[j].posPagina = listado1.datos[i][5];
                    array[j].precioCatalogp = listado1.datos[i][6];
					break;
				}
			}
		}
	}

    //Se hace que la ventana retorne los registros seleccionados en la lista
    //editable y se cierra.
    window.returnValue = array;
    window.close();
}
