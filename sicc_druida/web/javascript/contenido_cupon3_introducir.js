/**
* Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
    $Id: contenido_cupon3_introducir.js,v 1.1 2009/12/03 19:01:45 pecbazalar Exp $
    DESC
*/
var FORMULARIO = 'frmCapturarCupon';
function onLoadPag() { 
	 eval (ON_RSZ);
	if (get(FORMULARIO+'.errDescripcion')!='') {
		var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'), get(FORMULARIO+'.errDescripcion'));
	}
	/*if(get(FORMULARIO + '.canal') != ""){
		set(FORMULARIO + '.cbCanal', [get(FORMULARIO + '.canal')]);
		if (get(FORMULARIO + '.cbCanal') == "") //para evidenciar foco
			set(FORMULARIO + '.cbCanal', ['']);
		canalOnChange();
	}
*/
configurarMenuSecundario(FORMULARIO);
   	setearCombosMarcaCanal();
	cambioMarcaCanal();
	window.setTimeout("setearCombosPeriodo()", 2800);
	set(FORMULARIO + ".textFechaDigit", get(FORMULARIO + ".hFechaDigitacion"));
	//Control del foco
	focaliza(FORMULARIO + ".cbMarca");
}
	function cambioMarcaCanal(){
        if (get(FORMULARIO + ".cbMarca")!=''
        &&get(FORMULARIO + ".cbCanal")!=''){
            accion(FORMULARIO + ".cbPeriodo",'.disabled=false');
            var oid = get(FORMULARIO + ".cbCanal").toString();
            var marca= get(FORMULARIO + ".cbMarca").toString();
            frmCapturarCupon.hOidCanal = oid;
            frmCapturarCupon.hOidMarca = marca;
            if(oid != "") {                    
                recargaCombo(FORMULARIO + ".cbPeriodo","PRECargarPeriodos","es.indra.sicc.dtos.cra.DTOPeriodo",makeParameters());
            }      
		}
    }

    function setearCombosMarcaCanal(){
        var array = new Array();
        array[0]= get(FORMULARIO + ".hOidCanal");
        set(FORMULARIO + ".cbCanal",array);
        array = new Array();
        array[0]= get(FORMULARIO + ".hOidMarca");
        set(FORMULARIO + ".cbMarca",array);
    }

    function setearCombosPeriodo(){
        var array = new Array();
        array[0]= get(FORMULARIO + ".hOidPeriodo");
        set(FORMULARIO + ".cbPeriodo",array);
    }

    function makeParameters() {
        var array = new Array();
        var i=0;
        array[i] = new Array('pais',get(FORMULARIO + '.oidPais'));
        i++;
        array[i] = new Array('marca',get(FORMULARIO + '.cbMarca'));
        i++;
        array[i] = new Array('canal',get(FORMULARIO + '.cbCanal'));
        return array;
    }
	// Incluye la opcion vacia al principio del array 
	function incluyeOpcionVacia(datos) {
	         var datos2 = new Array();
	         datos2[0] = ['',''];   
	         for (var i=0;i<datos.length;i++) {
	         	datos2[i+1] = datos[i];
	         }
	         return datos2;
	}

	function fLimpiar() {
		vaciaCombo(FORMULARIO + ".cbMarca");
		vaciaCombo(FORMULARIO + ".cbCanal");
		vaciaCombo(FORMULARIO + ".cbPeriodo");

		if(get(FORMULARIO + ".canal") != ""){
			set(FORMULARIO + ".cbCanal", [get(FORMULARIO + ".canal")]);
			canalOnChange();
		}
		focaliza(FORMULARIO + ".cbMarca");
	}

	function fVolver(){
     	window.close();
	}
	//valida la fecha si el campo es modificable y no vacío 
	function validaFecha() {
		if (get(FORMULARIO + '.textFechaDigit') != "") {
			var resul = EsFechaValida(get(FORMULARIO + '.textFechaDigit'), get(FORMULARIO + '.textFechaDigit'), FORMULARIO, null);
			if (resul == 1 || resul == 2) {  
				GestionarMensaje('1006', get(FORMULARIO + '.hFormatoFechaPais'));
				focaliza(FORMULARIO + '.textFechaDigit');
				return false;
			}
		    //recargo el numero de cupon
			eval(FORMULARIO).oculto = 'S';
   		    set(FORMULARIO + '.accion', 'recargNroCupon');
			set(FORMULARIO + '.conectorAction', "LPCapturarCupon3");
			enviaSICC(FORMULARIO);
		} 
	}
   
	function cool(nroCupon) {
		eval(FORMULARIO).oculto = 'N';
		set(FORMULARIO + '.lbldtNumero', nroCupon);
		txt_to('lbldtNumero',nroCupon);
		set(FORMULARIO + '.numero', nroCupon);
	}

	function vaciaCombo(combo) {
		set_combo(combo, [['','']], ['']);
	}

	function accionBTN_Introducir() {
		if (!sicc_validaciones_generales()) { return false; }
				var objParams = new Object();
				objParams.anyo = get(FORMULARIO + '.anyo');
				objParams.mes = get(FORMULARIO + '.mes');
				objParams.numero = get(FORMULARIO + '.numero');
				objParams.cbMarcaDesc = get(FORMULARIO + '.cbMarca', 'T');
				objParams.cbCanalDesc = get(FORMULARIO + '.cbCanal', 'T');
				objParams.cbPeriodoDesc = get(FORMULARIO + '.cbPeriodo', 'T');
				objParams.cbMarca = get(FORMULARIO + '.cbMarca');
				objParams.cbCanal = get(FORMULARIO + '.cbCanal');
				objParams.cbPeriodo = get(FORMULARIO + '.cbPeriodo');
				objParams.textFechaDigit = get(FORMULARIO + '.textFechaDigit');
				objParams.textRefExt = get(FORMULARIO + '.textRefExt');
				objParams.areatxtObservaciones = get(FORMULARIO + '.areatxtObservaciones');
	            var recarga = mostrarModalSICC('LPCapturarCupon3', 'introducir', objParams, null, null);
	            if (recarga != null && recarga == "recarga") {
                    eval(FORMULARIO).oculto = 'N';
					set(FORMULARIO + '.accion', 'recargTodoSalvoNroCupon');
					set(FORMULARIO + '.conectorAction', "LPCapturarCupon3");
					set(FORMULARIO + '.numeroDeCuponEnSesion', get(FORMULARIO + '.numero'));
					enviaSICC(FORMULARIO);
	            }
	}

	function validacionCorrecta() {
		fLimpiarGenericoSICC();
		fLimpiar();
	}