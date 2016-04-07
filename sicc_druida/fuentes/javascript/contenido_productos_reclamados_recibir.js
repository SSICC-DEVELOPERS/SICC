// Elementos de la lista según vienen de negocio (DAORecibirProductos)
//var NLINEA = 0;
var OID = 1;
var OIDLINEAOPERACION = 2;
var NUMERORECLAMO = 3;
var DOCUMENTOREFERENCIA = 4;
var CODIGOCLIENTE = 5;
var ESTADORECLAMACION = 6;
var CODOPERACION = 7;
var TIPOOPERACION = 8;
var NUMEROOPERACION = 9;
var NUMEROLINEA = 10;
var CODIGOVENTA = 11;
var PRODUCTO = 12;
var NUMEROUNIDADESRECLAMADAS = 13;
var NUMEROUNIDADESDEVUELTAS = 14;
var NUMEROUNIDADESADEVOLVER = 15;
var UNIDADESADEVOLVERDEFECTO = 16;
var OIDSOLICITUDCABECERA = 17;
var OIDMARCA = 18;
var OIDCANAL = 19;
var OIDACCESO = 20;
var OIDSUBACCESO = 21; 
var OIDPERIODORECLAMO = 22;
var NUMEROATENCION = 23;
var IND_ESPE_MERC_FISI = 24;
var IND_DEVU_FISI_FACT = 25;
var VAL_PREC = 26;
var ENTREGA_MERCADERIA = 27;
var OID_OPERACION = 28;

var filaValidandose = -1;
var filaActual = -1;

/*Long oidLineaOperacion;              2       
Integer numeroUnidadesADevolver; 15          
Long oidSolicitudCabecera;       17          
Long oidMarca;                   18          
Long oidCanal;                   19          
Long oidAcceso;                  20          
Long oidSubAcceso;               21          
Long oidPeriodoReclamo;          22          
Long oidCabeceraReclamo;         1           
Long numeroAtencion;             23          
Boolean esperarMercaderia;     24            
Boolean devuelveFisico;          25          
Integer unidadesReclamadas;     13           
BigDecimal precioUnitario;      26           

*/
var FORMULARIO = 'frmFormulario';

function onLoadPag(){
	if (get(FORMULARIO + '.errDescripcion')!='') {
		var wnd = fMostrarMensajeError(get(FORMULARIO + '.errCodigo'), get(FORMULARIO + '.errDescripcion'));
		window.close();
	}

    configurarMenuSecundario(FORMULARIO);
	//visibleLista();
    focaliza(FORMULARIO+'.txtNumReclamo');
}

function onClickBuscar() {
    listado2.setDatos(new Array());

    var numReclamo = get(FORMULARIO+'.txtNumReclamo');
    var fechaReclamo = get(FORMULARIO+'.txtFechaReclamo');
    var operacion = get(FORMULARIO+'.cbOperacion');


    // Comprobamos que el usuario ha introducido al menos un elemento de búsqueda
    var valido = false;
    if((numReclamo=='')&&(fechaReclamo=='')&&(operacion=='')) {
		/* Modificado por ssantana, 08/08/2006, inc. DBLG500001192 */ 
        /* Debe introducir al menos un elemento de búsqueda UIGEN0006 */
        GestionarMensaje('UIGEN0006');
		/* Fin Modificado por ssantana, 08/08/2006, inc. DBLG500001192 */ 

        return false;
    }

    var pais = get(FORMULARIO+'.pais');
    var idioma = get(FORMULARIO+'.idioma');

    configurarPaginado(mipgndo, "RECBuscarProductosReclamados", "ConectorBuscarProductosReclamados", 
                                "es.indra.sicc.dtos.rec.DTOBuscarProductosReclamados", 
                                [["numeroReclamo", numReclamo], 
                                ["fechaReclamo", fechaReclamo], 
                                ["oidOperacion", operacion], 
                                ["oidPais", pais], 
                                ["oidIdioma", idioma]]);
}

function onClickAnyadir() {
	listado1.actualizaDat();
	listado2.actualizaDat();
    // Debe seleccionar al menos un elemento de la lista
    if(listado1.codSeleccionados().length==0) {
        // Mensaje: Debe seleccionar al menos un elemento de la lista
        GestionarMensaje('4');
        return false;
    }

    // Recorremos todos los elementos seleccionados
    var i;
    var j;
    var registroValido;
    var seleccionados = listado1.selecc;
    for (i = 0; i < seleccionados.length; i++) {
    	if (seleccionados[i] == '1') {
			/*alert('NUMEROUNIDADESADEVOLVER-->listado1.datos['+i+']['+NUMEROUNIDADESADEVOLVER+']='+listado1.datos[i][NUMEROUNIDADESADEVOLVER]);
			alert('NUMEROUNIDADESRECLAMADAS-->listado1.datos['+i+']['+NUMEROUNIDADESRECLAMADAS+']='+listado1.datos[i][NUMEROUNIDADESRECLAMADAS]);
			alert('NUMEROUNIDADESADEVOLVERDEFECTO-->listado1.datos['+i+']['+UNIDADESADEVOLVERDEFECTO+']='+listado1.datos[i][UNIDADESADEVOLVERDEFECTO]);*/
	        // Comprobamos que el registro no esté introducido
	        registroValido = true;
	        for (j = 0; j < listado2.datos.length; j++) {
	            if (listado1.datos[i][OIDLINEAOPERACION]==listado2.datos[j][OIDLINEAOPERACION]) {
	                // Está repetido. Mostrar error REC016: "El registro está repetido:" + nº operación + nº línea
	                GestionarMensaje('REC016', listado1.datos[i][NUMEROOPERACION], 
	                                            listado1.datos[i][NUMEROLINEA]);
	                registroValido = false;
	                break;
	            }
	        }
	
	        if(registroValido) {
	        		// BELC300019645: Si columna unidadesADevolver + unidadesDevueltas > columna unidadesReclamadas mostrar error
	            // Compruebo si los datos son correctos REC015

				//yyy
				//alert("UNIDADESADEVOLVERDEFECTO: " + listado1.datos[i][UNIDADESADEVOLVERDEFECTO]);
				//alert("NUMEROUNIDADESADEVOLVER: " + listado1.datos[i][NUMEROUNIDADESADEVOLVER]);
				//alert("NUMEROUNIDADESDEVUELTAS: " + listado1.datos[i][NUMEROUNIDADESDEVUELTAS]);
				//alert("NUMEROUNIDADESRECLAMADAS: " + listado1.datos[i][NUMEROUNIDADESRECLAMADAS]);

	            //if( ((Number(listado1.datos[i][NUMEROUNIDADESADEVOLVER]) + Number(listado1.datos[i][NUMEROUNIDADESDEVUELTAS])) > Number(listado1.datos[i][NUMEROUNIDADESRECLAMADAS]))
	            //	|| (Number(listado1.datos[i][NUMEROUNIDADESADEVOLVER]) < Number(listado1.datos[i][UNIDADESADEVOLVERDEFECTO])) ){

				if ((Number(listado1.datos[i][NUMEROUNIDADESADEVOLVER]) + Number(listado1.datos[i][NUMEROUNIDADESDEVUELTAS])) > Number(listado1.datos[i][NUMEROUNIDADESRECLAMADAS])){
	                GestionarMensaje('REC015', listado1.datos[i][NUMERORECLAMO], 
	                                            listado1.datos[i][NUMEROOPERACION], 
	                                            listado1.datos[i][NUMEROLINEA]);
			          eval('listado1.preparaCamposDR()');
			          focaliza('frmlistado1.Texto1_'+i,''); 
	                                            
	            } 
	            // BELC300019645
             	else if(Number(listado1.datos[i][NUMEROUNIDADESADEVOLVER]) == Number(0))
	            {
	                GestionarMensaje('REC018');
			          eval('listado1.preparaCamposDR()');
			          focaliza('frmlistado1.Texto1_'+i,''); 
	            }
	            else {
	                // Si es correcto lo inserto
	                listado2.insertar(listado1.datos[i]);
	                listado1.deselecciona(i);
	                listado2.reajusta();

	            }
	        }	        
    	}
    }
}



function onClickAceptar() {

    if(listado2.datos.length == 0) {
        // Mostrar error: REC013. Muestro el 'REC017' Debe definirse correctamente
        GestionarMensaje('REC017');
        return false;
    }

    var FINLINEA = "|";   
    var lista = '';

    // Recorro las filas
    for(fila = 0; fila < listado2.datos.length; fila++) {

		lista += trataElemento(listado2.datos[fila][OIDLINEAOPERACION]);
		lista += trataElemento(listado2.datos[fila][NUMEROUNIDADESADEVOLVER]); 
		lista += trataElemento(listado2.datos[fila][OIDSOLICITUDCABECERA]);
		lista += trataElemento(listado2.datos[fila][OIDMARCA]);
		lista += trataElemento(listado2.datos[fila][OIDCANAL]);
		lista += trataElemento(listado2.datos[fila][OIDACCESO]);
		lista += trataElemento(listado2.datos[fila][OIDSUBACCESO]);
		lista += trataElemento(listado2.datos[fila][OIDPERIODORECLAMO]);
		lista += trataElemento(listado2.datos[fila][OID]);
		lista += trataElemento(listado2.datos[fila][NUMEROATENCION]);
		lista += trataElemento(listado2.datos[fila][IND_ESPE_MERC_FISI]);
		lista += trataElemento(listado2.datos[fila][IND_DEVU_FISI_FACT]);
		lista += trataElemento(listado2.datos[fila][NUMEROUNIDADESRECLAMADAS]);
		lista += trataElemento(listado2.datos[fila][VAL_PREC]);
		lista += trataElemento(listado2.datos[fila][ENTREGA_MERCADERIA]);
		lista += trataElemento(listado2.datos[fila][NUMEROOPERACION]);

		lista += trataElemento(listado2.datos[fila][NUMEROUNIDADESDEVUELTAS]); 


        // Termina esta linea
        lista += FINLINEA;
    }

    set(FORMULARIO + '.lista', lista);
    set(FORMULARIO + '.accion', 'recibir');
    set(FORMULARIO + '.conectorAction', 'LPRecibirProductos');

    FORMULARIO.oculto = 'S';
    enviaSICC(FORMULARIO);
}

	function trataElemento(valor) {
	    var BLANCO = "/";     
	    var ELEMENTO = "*";   
	    if (valor != '')	return valor + ELEMENTO;
		else return BLANCO + ELEMENTO;
	}

function cerrarVentana(){
/*
    var formulario = getFormularioSICC();
    set(formulario+".conectorAction","LPInicioBelcorp");
    set(formulario+".accion","");
    try{
             parent.frames['menu'].location.reload();
             parent.frames["iconos"].mostrarCapa();
    }catch(e){}
    eval(formulario).oculto = 'N';
    enviaSICC(formulario,'','','N');
*/
	fLimpiarGenericoSICC();
	listado1.setDatos(new Array());
    listado2.setDatos(new Array());

    invisibleLista();
	fLimpiar();
}

function onTabBuscar() {
    if(get_visibilidad("capaLista")) {
        focalizaPrimeroListado(); //document.all['Anadir'].focus();
    } else {
        focaliza(FORMULARIO + '.txtNumReclamo');
    }
}

function onTabAnyadir() {
    document.all['Eliminar'].focus();
}

function onTabAceptar() {
    focaliza(FORMULARIO + '.txtNumReclamo');
}

function onShTabNumeroReclamo() {
	document.body.focus();
    if(get_visibilidad("capaLista")) {
        document.all['Aceptar'].focus();
    } else {
        document.all['btnBuscar'].focus();
    }
}

function onShTabAnyadir() {
    focalizaUltimoListado(); //document.all['btnBuscar'].focus();
}

function onShTabEliminar() {
    document.all['Anadir'].focus();
}

function habilitaCriterios() {
    /*document.getElementById('txtNumReclamo').disabled=false;
    document.getElementById('txtFechaReclamo').disabled=false;
    document.getElementById('cbOperacion').disabled=false;
    document.all['btnBuscar'].disabled = false;*/
}

function desHabilitaCriterios() {
    /*document.getElementById('txtNumReclamo').disabled=true;
    document.getElementById('txtFechaReclamo').disabled=true;
    document.getElementById('cbOperacion').disabled=true;
    document.all['btnBuscar'].disabled = true;*/

}

function visibleLista() {
    DrdEnsanchaConMargenDcho('listado1',12);
    DrdEnsanchaConMargenDcho('listado2',12);
    visibilidad('capaLista','V');
    eval (ON_RSZ); 
    setTimeout('focalizaPrimeroListado()', 5); 
}

function invisibleLista() {
    visibilidad('capaLista','O');
    eval (ON_RSZ);  
}

function muestraLista(ultima, rowset){
    var tamano = rowset.length;
    if (tamano > 0) {
    	//desHabilitaCriterios();
        visibleLista();
        return true;
    } else {
        invisibleLista();
        return false;
    }
}

function fLimpiar() {
    /*listado1.setDatos(new Array());
    listado2.setDatos(new Array());

    invisibleLista();

    //habilitaCriterios();*/

    focaliza(FORMULARIO + '.txtNumReclamo');
}

function fBorrar() {

    // Debe seleccionar al menos un elemento de la lista
    if(listado2.codSeleccionados().length==0) {
        // Mensaje: Debe seleccionar al menos un elemento de la lista
        GestionarMensaje('4');
        return false;
    }
    listado2.eliminarSelecc(); //eliminar(seleccionados[i]);
}

function onBlurNumAtencion() {
    var numReclamo = get(FORMULARIO+'.txtNumReclamo');
    if(numReclamo!='') {
        if(ValidaCaracteres(numReclamo, '0123456789')!='OK') {
            cdos_mostrarAlert(DrdMsgCore(143) + '0123456789');
            focaliza(FORMULARIO+'.txtNumReclamo');
            return false;
        }        
    }   
}

function onBlurFecha() {
    if (get(FORMULARIO+'.txtFechaReclamo')!=''){
        if (!EsFechaValida_SICC(get(FORMULARIO + '.txtFechaReclamo'), FORMULARIO)) {		
            GestionarMensaje('1395', get(FORMULARIO + '.hFormatoFechaPais'));
            focaliza(FORMULARIO+'.txtFechaReclamo');
            return false;
        } 
    }
}

	function focalizaPrimeroListado() {
		listado1.actualizaDat();
		var datos = listado1.datos;
		listado1.preparaCamposDR();
		focaliza('frmlistado1.Texto1_0', '');
	}

	function focalizaUltimoListado() {
		listado1.actualizaDat();
		var datos = listado1.datos;
		var numeroFila = datos.length - 1;
		listado1.preparaCamposDR();
		focaliza('frmlistado1.Texto1_'+ numeroFila, '');
	}
         
                  
	function focalizaSiguienteLista(FILAEVENTO, TECLAEVENTO) {
		if (FILAEVENTO == listado1.datos.length-1 && TECLAEVENTO == 9) {
			if (ValidaForm(FORMULARIO, false)) {
				//document.body.focus();
				setTimeout("document.all['Anadir'].focus();tr=document.body.createTextRange();tr.execCommand('Unselect');", 5);
			} 
		}
	}

	function focalizaAnteriorLista(FILAEVENTO, TECLAEVENTO) {
		if (FILAEVENTO == 0 && TECLAEVENTO == 9) {
			if (ValidaForm(FORMULARIO, false)) {
				//document.body.focus();
				setTimeout("document.all['btnBuscar'].focus();tr=document.body.createTextRange();tr.execCommand('Unselect');", 5);
			} 
		}
	}
	
	//valida entero si el campo es modificable y no vacío 
	function validaEntero(valor) {	
			if (valor != "")
				//Como no nos interesa validar el número de dígitos que tiene el entero ponemos uno suficientemente grande.
				if (ValidaInt(valor, 10000, -10000) != "OK") {
					GestionarMensaje('747', null, null, null);
					focaliza(FORMULARIO + '.' + nombreElemento);
					return false;
				} 
	}

	// llamada en el onblur de la caja de texto editable de las filas de la lista editable (unidades a devolver)
	// BELC300019645
	function validarUnidadesDevolver(FILAEVENTO) {
		
		var objetoUnidadesDevolver = eval('listado1.form.Texto1_' +  FILAEVENTO);

		if (! esNumerico(objetoUnidadesDevolver.value)) {
			GestionarMensaje('405');
			objetoUnidadesDevolver.focus();
			var tr = objetoUnidadesDevolver.createTextRange();
			tr.execCommand("SelectAll");                            
			return;					
		}
		
		if ( (Number(listado1.datos[FILAEVENTO][NUMEROUNIDADESDEVUELTAS]) == Number(listado1.datos[FILAEVENTO][NUMEROUNIDADESRECLAMADAS])) 
			&& (Number(objetoUnidadesDevolver.value) != Number(0)) ) 
		{
			// se lleva el foco a la caja de texto con el numero de unidades a devolver incorrecto
			objetoUnidadesDevolver.focus();
			// se actualiza a 0
			objetoUnidadesDevolver.value = 0;
			var tr = objetoUnidadesDevolver.createTextRange();
			tr.execCommand("SelectAll");                                
			// se muestra mensaje REC018 - "Los datos introducidos no son correctos"
			GestionarMensaje('REC018');
		}
	}
	
	function esNumerico(valor) {
		
		var esNumeroValido = true;
		
		if (ValidaInt(valor, 10000, -10000) != "OK")
			esNumeroValido = false; 
			
		return esNumeroValido;
	}
	
	function validar() {
		// el valor de filaActual se asigna en el xml
		var objetoUnidadesDevolver = eval('listado1.form.Texto1_' +  filaActual);

		if (! esNumerico(objetoUnidadesDevolver.value)) {
			return "KO";
		}
		if ( (Number(listado1.datos[filaActual][NUMEROUNIDADESDEVUELTAS]) == Number(listado1.datos[filaActual][NUMEROUNIDADESRECLAMADAS]))  
			&& objetoUnidadesDevolver.value != 0) 
		{
			return "KO";
		}
		
		return "OK";
	}