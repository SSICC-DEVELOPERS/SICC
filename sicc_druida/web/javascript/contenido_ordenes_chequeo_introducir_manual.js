/**
* Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
* Avda. de Bruselas, 35
* Parque Empresarial Arroyo de la Vega
* 28108 Alcobendas, Madrid
* España
*
* Privado y Confidencial.
* La información contenida en este documento es propiedad de Indra sistemas.
* Para uso exclusivo de empleados autorizados no permitiéndose
* la distribución de este código sin permiso expreso.
*/ 


/*
    INDRA/CAR/PROY
    $Id: contenido_ordenes_chequeo_introducir_manual.js,v 1.1 2009/12/03 19:02:08 pecbazalar Exp $
    DESC
*/
var FORMULARIO = 'frmFormulario';
var codFila = 1;
	
	function onLoadPag() {

		if (get(FORMULARIO + '.errDescripcion')!='') {
			var wnd = fMostrarMensajeError(get(FORMULARIO + '.errCodigo'), get(FORMULARIO + '.errDescripcion'));
			window.close();
		}
		set(FORMULARIO + '.cbMarca1', [get(FORMULARIO + '.marcaPorDefecto')])
		set(FORMULARIO + '.cbCanal1', [get(FORMULARIO + '.canalPorDefecto')])
		cbMarca1OnChange();
		configurarMenuSecundario(FORMULARIO);
		DrdEnsanchaConMargenDcho('listado1', 12);
		eval (ON_RSZ);
		focaliza(FORMULARIO + '.cbMarca1');
	}
 
	function cbMarca1OnChange() {
		vaciaCombo(FORMULARIO + '.cbPeriodo1');
		if (get(FORMULARIO + '.cbMarca1') != "" && get(FORMULARIO + '.cbCanal1') != "")
			recargaPeriodo(get(FORMULARIO + '.cbMarca1').toString(), get(FORMULARIO + '.cbCanal1').toString());
	}

	function recargaPeriodo(marca, canal) {
		/*
		Llamar al método recargaCombo utilizando el DTOPeriodo y el idBusiness = "CRAObtenerPeriodosPosteriores". 
		Parametros del DTOPeriodo: 
		- DTOPeriodo.oidPais = oid del pais activo 
		- DTOPeriodo.oidMarca = oid de la marca seleccionada 
		- DTOPeriodo.oidCanal = oid del canal seleccionado 
		*/
		
		recargaCombo(FORMULARIO + '.cbPeriodo1', 'CRAObtenerPeriodosPosterioresActivos', 'es.indra.sicc.dtos.cra.DTOPeriodo', [["pais", get(FORMULARIO + '.pais').toString()], ["oidPais", get(FORMULARIO + '.pais').toString()], ["oidIdioma", get(FORMULARIO + '.idioma').toString()], ["marca", marca], ["canal", canal]]);
	}

	function vaciaCombo(combo) {
		set_combo(combo, [['','']], ['']);
	}

// vbongiov -- Cambio 20080756 -- 29/04/2009
function cbPeriodo1OnChange() {
		 var periodoDesde = get(FORMULARIO + '.cbPeriodo1');  

         if(periodoDesde!="") {
              recargaCombo(FORMULARIO + '.cbPeriodo2', 'CRAObtenerPeriodosPosterioresActivos', 'es.indra.sicc.dtos.cra.DTOPeriodo', armarArrayDTOPeriodoComboHasta());
         }
         else {
			  var array = new Array();
			  array[0] = ['', ''];    
			  set_combo(FORMULARIO + '.cbPeriodo2', array);          
         }	
}

// vbongiov -- Cambio 20080756 -- 29/04/2009
function armarArrayDTOPeriodoComboHasta(){
          var pais = get(FORMULARIO + '.pais');
          var marca = get(FORMULARIO + '.cbMarca1');
          var canal = get(FORMULARIO + '.cbCanal1'); 
          var periodoDesde = get(FORMULARIO + '.cbPeriodo1');
  
          var array = new Array();
          var index = 0;

          if( pais != null && pais != '' ){
                   array[index] = new Array('pais', pais);
              index++;
          }      

          if( marca != null && marca[0] != null && marca[0] != '' ){
                        array[index] = new Array('marca', marca[0]);
              index++;
          }

          if( canal != null && canal != '' ){
                            array[index] = new Array('canal', canal);
              index++;
          }

                   if( periodoDesde != null && periodoDesde != '' ){
                            array[index] = new Array('oid', periodoDesde);
              index++;
          }
  
          return array;
}

// vbongiov -- Cambio 20080756 -- 29/04/2009
function btnDetalleOnClick(){

	if(sicc_validaciones_generales("gDetalle")) {

		var obj = new Object();
            
		obj.accion = 'detalleManual';
		obj.oidPeriodoDesde = get(FORMULARIO + '.cbPeriodo1');
		obj.oidPeriodoHasta = get(FORMULARIO + '.cbPeriodo2');
		obj.codCliente = get(FORMULARIO + '.txtCodigoCliente1');
		obj.oidTipoChequeo = get(FORMULARIO + '.cbTipoChequeo');
		
		var retorno = mostrarModalSICC('LPIntroducirOrdenesChequeos', 'detalleManual', obj, '800', '500');

	}
}

     function accionSeleccionarCliente() {
		var objParams = new Object();
		var resultado = mostrarModalSICC('LPBusquedaRapidaCliente', '', objParams, null, null);
		if (resultado != null && resultado.length > 1)
			set(FORMULARIO + '.txtCodigoCliente1', resultado[1]);
     }

	function codigoClienteOnBlur() {
		var codigoCliente = get(FORMULARIO + '.txtCodigoCliente1').toString();
		
		if (codigoCliente != '') {
			var longitudCodigoCliente = get(FORMULARIO + '.longitudCodigoCliente').toString();
			var longitud = codigoCliente.length;
			
			// Se rellena el código de cliente con ceros
			var cadena = rellenaCeros(codigoCliente, longitudCodigoCliente, longitud);
			set(FORMULARIO + '.txtCodigoCliente1', cadena);
		}
	}

    // vbongiov -- Cambio 20080756 -- 29/04/2009
	function fLimpiar() {

		eval('frmFormulario').oculto = 'S';
		set('frmFormulario.conectorAction', 'LPIntroducirOrdenesChequeos');
		set('frmFormulario.accion', 'limpiarManual');
		enviaSICC('frmFormulario', null, null, 'N');
	}

   // vbongiov -- Cambio 20080756 -- 29/04/2009
   function limpiarManual() {

		codFila = 1;
		vaciaCombo(FORMULARIO + '.cbPeriodo1');
		vaciaCombo(FORMULARIO + '.cbPeriodo2');
		// vbongiov -- Cambio 20080756 -- 29/04/2009
		set(FORMULARIO + '.txtCodigoCliente1', '');
		set(FORMULARIO + '.cbTipoChequeo', '');

		listado1.setDatos(new Array());
		listado1.reajusta();
		set(FORMULARIO + '.cbMarca1', [get(FORMULARIO + '.marcaPorDefecto')])
		set(FORMULARIO + '.cbCanal1', [get(FORMULARIO + '.canalPorDefecto')])
		cbMarca1OnChange();
		focaliza(FORMULARIO + '.cbMarca1');
	}

	// vbongiov -- Cambio 20080756 -- 29/04/2009
	function ejecutarErrorLimpiar() {
		focaliza("frmFormulario.cbMarca1");
	}

	function fVolver() {
		window.close();
	}

	function btnAnyadirOnClick() {
/*		- cbMarca 
- cbCanal 
- cbPeriodo 
- cbTipoRevision 

Añade una nueva fila a la lista lstClientesChequear con los valores: 
- Marca: Descripción seleccionada en cbMarca 
- Canal: Descripción seleccionada en cbCanal 
- Periodo: Descripción seleccionada en cbPeriodo 
- Código cliente: Introducido en txtCliente 
- Tipo chequeo: Descripción seleccionada en cbTipoChequeo 

Añade una nueva fila al array clientesChequear con los datos de la línea: 
- {oidPeriodo, codigo cliente, oidTipoChequeo}*/

	if (!sicc_validaciones_generales()) return false;

    // vbongiov -- Cambio 20080756 -- 29/04/2009
	eval('frmFormulario').oculto = 'S';
	set('frmFormulario.conectorAction', 'LPIntroducirOrdenesChequeos');
	set('frmFormulario.accion', 'verificarChequeosDefinidos');
	enviaSICC('frmFormulario', null, null, 'N');

 }

  // vbongiov -- Cambio 20080756 -- 29/04/2009
  function aniadirRegistro() {

		listado1.insertar([codFila++, 
				get(FORMULARIO + '.cbMarca1', 'T').toString(),
				get(FORMULARIO + '.cbCanal1', 'T').toString(),
				get(FORMULARIO + '.cbPeriodo1', 'T').toString(),
				get(FORMULARIO + '.cbPeriodo2', 'T').toString(),
				get(FORMULARIO + '.txtCodigoCliente1').toString(),
				get(FORMULARIO + '.cbTipoChequeo', 'T').toString(),
				get(FORMULARIO + '.cbPeriodo1').toString(),
				get(FORMULARIO + '.cbPeriodo2').toString(),
				get(FORMULARIO + '.cbTipoChequeo').toString()]);

		listado1.reajusta();

		limpiarCombos();
	}

    // vbongiov -- Cambio 20080756 -- 29/04/2009
	function limpiarCombos() {
		vaciaCombo(FORMULARIO + '.cbPeriodo1');
		vaciaCombo(FORMULARIO + '.cbPeriodo2');
		set(FORMULARIO + '.txtCodigoCliente1', '');
		set(FORMULARIO + '.cbTipoChequeo', '');
		set(FORMULARIO + '.cbMarca1', [get(FORMULARIO + '.marcaPorDefecto')])
		set(FORMULARIO + '.cbCanal1', [get(FORMULARIO + '.canalPorDefecto')])
		cbMarca1OnChange();
		focaliza(FORMULARIO + '.cbMarca1');

	}


    // vbongiov -- Cambio 20080756 -- 29/04/2009
	function ejecutarErrorVerificar() {
		focaliza("frmFormulario.cbPeriodo1");
	}


	function fBorrar() {
		if (listado1.numSelecc() == 0) {
			// Muestra el mensaje: "Debe seleccionar al menos un elemento de la lista"
			GestionarMensaje('1021');

		} else {
			// vbongiov -- Cambio 20080756 -- 29/04/2009
			var codSeleccionados = listado1.codSeleccionados();    
			registrosEliminados = "";

			for (var i=0; i<codSeleccionados.length ; i++){         
				 if(registrosEliminados==""){
					 registrosEliminados = registrosEliminados + listado1.extraeDato(codSeleccionados[i], 4) 
						                                 + "," + listado1.extraeDato(codSeleccionados[i], 6) 
														 + "," + listado1.extraeDato(codSeleccionados[i], 7) 
														 + "," + listado1.extraeDato(codSeleccionados[i], 8);
				 } else {
					 registrosEliminados = registrosEliminados + "|" + listado1.extraeDato(codSeleccionados[i], 4)
														 + "," + listado1.extraeDato(codSeleccionados[i], 6) 
														 + "," + listado1.extraeDato(codSeleccionados[i], 7) 
														 + "," + listado1.extraeDato(codSeleccionados[i], 8);
				 }
			}

			eval('frmFormulario').oculto = 'S';
			set('frmFormulario.conectorAction', 'LPIntroducirOrdenesChequeos');
			set('frmFormulario.accion', 'eliminarRegistrosManual');
			set('frmFormulario.registrosEliminados', registrosEliminados);
			enviaSICC('frmFormulario', null, null, 'N');
		}
    }

    // vbongiov -- Cambio 20080756 -- 29/04/2009
	function borrarRegistros() {
			listado1.eliminarSelecc();

			focaliza(FORMULARIO + '.cbMarca1');
	}

	function fGuardar() {
		listado1.actualizaDat();
		if (listado1.datos.length == 0)
			GestionarMensaje('1392');
		else {
			// vbongiov -- Cambio 20080756 -- 29/04/2009
			set(FORMULARIO + '.accion', 'Guardar chequeo manual');
			set(FORMULARIO + '.conectorAction', "LPIntroducirOrdenesChequeos");
			enviaSICC(FORMULARIO, null, null, 'N');
		}
	}


	function recuperarClientes() {
		listado1.actualizaDat(); //Actualiza el array 'datos'
		var datosFinal = listado1.datos;
		var resultado = "";
		for (i = 0; i < datosFinal.length; i++) {
			var fila = datosFinal[i];
			resultado += fila[6] + "@" + fila[4] + "@" + fila[7] + "#";
		}
		return resultado;
	}


function focalizaShTab(){
    focalizaBotonHTML('botonContenido','btnDetalle');
}

