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
	var FORMULARIO = 'frmFormulario';
         
     function onLoadPag() {

          if (get(FORMULARIO + '.errDescripcion')!='') {
               var wnd = fMostrarMensajeError(get(FORMULARIO + '.errCodigo'), get(FORMULARIO + '.errDescripcion'));
               window.close();
          }
          set(FORMULARIO + '.cbMarca', [get(FORMULARIO + '.marcaPorDefecto')])
          set(FORMULARIO + '.cbCanal', [get(FORMULARIO + '.canalPorDefecto')])
          cbMarcaOnChange();
          configurarMenuSecundario(FORMULARIO);
          focaliza(FORMULARIO + '.txtDescripcion');
     }

     //para mostrar la capa de campos 'enLinea'
     function cbMarcaOnChange() {
		vaciaCombo(FORMULARIO + '.cbPeriodo');
		if (get(FORMULARIO + '.cbMarca') != "" && get(FORMULARIO + '.cbCanal') != "")
			recargaPeriodo(get(FORMULARIO + '.cbMarca').toString(), get(FORMULARIO + '.cbCanal').toString());
     }

     function recargaPeriodo(marca, canal) {
          /*
          Llamar al método recargaCombo utilizando el DTOPeriodo y el idBusiness = "CRAObtienePeriodos". 
          Parametros del DTOPeriodo: 
          - DTOPeriodo.oidPais = oid del pais activo 
          - DTOPeriodo.oidMarca = oid de la marca seleccionada 
          - DTOPeriodo.oidCanal = oid del canal seleccionado 
          */
          recargaCombo(FORMULARIO + '.cbPeriodo', 'CRAObtienePeriodos', 'es.indra.sicc.dtos.cra.DTOPeriodo', [["pais", get(FORMULARIO + '.pais').toString()], ["oidPais", get(FORMULARIO + '.pais').toString()], ["oidIdioma", get(FORMULARIO + '.idioma').toString()], ["marca", marca], ["canal", canal]]);
     }

     function vaciaCombo(combo) {
          set_combo(combo, [['','']], ['']);
     }

	
	function fLimpiar() {
		vaciaCombo(FORMULARIO + '.cbPeriodo');
		set(FORMULARIO + '.areatxtObservaciones', "")
		set(FORMULARIO + '.cbMarca', [get(FORMULARIO + '.marcaPorDefecto')])
		set(FORMULARIO + '.cbCanal', [get(FORMULARIO + '.canalPorDefecto')])
		cbMarcaOnChange();
		focaliza(FORMULARIO + '.txtDescripcion');
	}

	function fGuardar() {
		if (!sicc_validaciones_generales()) { return false; }

		//set(FORMULARIO + '.accion', 'enviarFuenteVentaReal');
		set(FORMULARIO + '.conectorAction', "LPSAPBPS");
		enviaSICC(FORMULARIO);
	}

	//agregado por eamores
	function cerrarVentana(){ 
			var formulario = getFormularioSICC();
			set(formulario+".conectorAction","LPInicioBelcorp"); 
			set(formulario+".accion","");
			try{ 
				parent.frames['menu'].location.reload();
				 parent.frames["iconos"].mostrarCapa(); 
			}catch(e){}
			 eval(formulario).oculto = 'N';
			 enviaSICC(formulario,'','','N');
	} 
