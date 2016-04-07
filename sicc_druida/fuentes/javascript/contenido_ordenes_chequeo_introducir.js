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
    $Id: contenido_ordenes_chequeo_introducir.js,v 1.1 2009/12/03 19:02:16 pecbazalar Exp $
    DESC
*/
var FORMULARIO = 'frmFormulario';
	
	function onLoadPag() {

		if (get(FORMULARIO + '.errDescripcion')!='') {
			var wnd = fMostrarMensajeError(get(FORMULARIO + '.errCodigo'), get(FORMULARIO + '.errDescripcion'));
		}
		configurarMenuSecundario(FORMULARIO);
		focaliza(FORMULARIO + '.cbSeleccionarChequeo');
		if (window.dialogArguments) { // Si es modal (se abrió mediante showModalDialog) DBLG500000915
            btnProxy(2,1);  // boton 'volver', habilitado
            btnProxy(3,0);  // boton 'Ir a pantalla de inicio', deshabilitado
		}
	}

    function fVolver() {
           window.close();
    }

	function btnAceptar_onclick() {
		if (!sicc_validaciones_generales()) return false;
		var objParams = new Object();
		objParams.cbSeleccionarChequeo = get(FORMULARIO + '.cbSeleccionarChequeo');
		objParams.descripcion = get(FORMULARIO + '.cbSeleccionarChequeo', 'T');
		var datos = mostrarModalSICC('LPIntroducirOrdenesChequeos', 'Seleccionar tipo orden', objParams, null, null);	
	}

	function fLimpiar() {
	}

