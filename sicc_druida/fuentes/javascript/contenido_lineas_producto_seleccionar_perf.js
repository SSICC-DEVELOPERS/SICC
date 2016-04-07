function onLoadPag()   {  
	DrdEnsanchaConMargenDcho('listado1',12);
    eval (ON_RSZ); 
    configurarMenuSecundario('frmContenido');
	
	btnProxy(3, '0');
	btnProxy(7, '0');
	btnProxy(8, '0');
	btnProxy(9, '0');

    configurarPaginado (mipgndo,'PREBuscarLineasProductos','ConectorBuscarLineasProductos',
    'es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion', armarArray());         
}

function fVolver() {
	window.close();
}

function armarArray() {
	var vArray = new Array();
    vArray[0] = new Array('oidIdioma','1');
    vArray[1] = new Array('oidPais','1');        
    return vArray;
}

/*function accionAnadir(){
	// Tomar todos los valores seleccionados y meterlos en un array
    if (listado1.numSelecc() > 0) {
	    var strV = '';
        var codigo = new Array();
        codigo = listado1.codSeleccionados();
            
        for(i=0;i<listado1.codSeleccionados().length;i++) {
	        strV += codigo[i] + ',' + 
            listado1.extraeDato(listado1.codSeleccionados()[i], 0) +
            ';'+ listado1.extraeDato(listado1.codSeleccionados()[i], 1);

			if (i<listado1.codSeleccionados().length)
				strV += '|';
        }
            
        set('frmContenido.hidLineasSeleccionadas', strV);
        set('frmContenido.conectorAction', 'LPSeleccionarLineasProductosPerf');
        set('frmContenido.accion', 'Lineas seleccionadas');
        enviaSICC('frmContenido');
	}
    else {
	    //Muestra el mensaje PRE-0013
        GestionarMensaje('4');
    }
}*/

//Cambios por performance
function accionAnadir(){
    if (listado1.numSelecc() > 0) {
		var matriz = new Array();
		var j = 0;

 	     for(i=0;i<listado1.codSeleccionados().length;i++) {
  		    var fila = new Array();

			fila[0] = listado1.codSeleccionados()[i];
			fila[1] = listado1.extraeDato(listado1.codSeleccionados()[i], 0)
			fila[2] = listado1.extraeDato(listado1.codSeleccionados()[i], 1)

			matriz[j] = fila;
			j++;
		}
	
		returnValue = matriz;
		window.close();
	}
    else {
	    //Muestra el mensaje PRE-0013
        GestionarMensaje('4');
    }
}