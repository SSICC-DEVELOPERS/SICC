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

function init() {
	configurarMenuSecundario("frmConfigurarAyuda");
	var bErrores = hayErrores();
	//var exito = get("frmConfigurarAyuda.exito");
/*	if ( exito == "S") {
		GestionarMensaje("804", null, null, null);
		set("frmConfigurarAyuda.exito", "");
	}*/
	seteaFuncionCombo();  // Setea la funcion del combo seleccionada, si hay. 
    focaliza('frmConfigurarAyuda.comboCodFuncion');
	if (bErrores == true) {
		 //alert("Hay errores");
		 return;
	} else {
		;
	}

}

function hayErrores() {
	var codigoError = get("frmConfigurarAyuda.errCodigo");
	var descError = get("frmConfigurarAyuda.errDescripcion");
	if (codigoError == "")  // No hay errores
	 	 return false;
	else {
		 fMostrarMensajeError(codigoError, descError);  // Muestra mensaje de error de druida.
		 focaliza('frmConfigurarAyuda.comboCodFuncion');
		 return true;
	}
}

function enviaModificar() {	
  var grupos = ''; 
  grupos = 'grupo1'; 
  if(!sicc_validaciones_generales(grupos)) {
  } else {
   
   tmp = get("frmConfigurarAyuda.comboCodFuncion");

	 set("frmConfigurarAyuda.conectorAction", "LPConfiguracionAyuda");
	 set("frmConfigurarAyuda.accion", "modificar");
	 set("frmConfigurarAyuda.oidFuncion", tmp);

   //scs, acobacho el valor del combo por el q' acaba de ir a buscar.....
   set("frmConfigurarAyuda.hidOidFuncion", tmp);

   eval('frmConfigurarAyuda').oculto = 'S';
   enviaSICC('frmConfigurarAyuda', '', '', 'N');   
	 
  }
}

function enviaGrabar() {

  var grupos = ''; 
  grupos = 'grupo1, grupo2'; 
  if(!sicc_validaciones_generales(grupos)) {
  } else {
   var textoAyuda = get("frmConfigurarAyuda.areaObservaciones");
   set("frmConfigurarAyuda.conectorAction", "LPConfiguracionAyuda");
	 set("frmConfigurarAyuda.accion", "grabar");
	 set("frmConfigurarAyuda.textoAyuda", textoAyuda);

   eval('frmConfigurarAyuda').oculto = 'S';
   enviaSICC('frmConfigurarAyuda', '', '', 'N');   

  }
}

function chequeoCamposCompletos(textoAyuda, textoPath) {
	if (cdos_trim(textoAyuda) == "") {
		GestionarMensaje("980", null, null, null);
		focaliza("frmConfigurarAyuda.areaObservaciones");
		return false;
	}  
	return true;
}

function fGuardar() {
	enviaGrabar();
}

function fVolver() {
	set("frmConfigurarAyuda.conectorAction", "LPConfiguracionAyuda");
    set("frmConfigurarAyuda.accion", "")
	enviaSICC("frmConfigurarAyuda");
}

function seteaFuncionCombo()
{
	// ********************************************************************
	//  Setea la funcion seleccionada anteriormente en el combo
	// ********************************************************************
	var sOidFuncion = get("frmConfigurarAyuda.oidFuncion");
	var arrayBuffer = new Array();
	set ("frmConfigurarAyuda.hidOidFuncion2",get("frmConfigurarAyuda.oidFuncion"));
	alert(get("frmConfigurarAyuda.hidOidFuncion2") );
	arrayBuffer[0] = sOidFuncion;
	if ( sOidFuncion != null && sOidFuncion != "")  
		set("frmConfigurarAyuda.comboCodFuncion", arrayBuffer);

	return;
}

function fLimpiar() {

    eval("frmConfigurarAyuda").oculto="N";
    var accion = get("frmConfigurarAyuda.accion");
    focaliza('frmConfigurarAyuda.comboCodFuncion');
	
    if (accion == "") {
      set("frmConfigurarAyuda.comboCodFuncion", ""); 
      focaliza('frmConfigurarAyuda.comboCodFuncion');
	  ocultarLista();
    }

    if (accion == "modificar") {
 
	    var arrayBuffer = new Array();
			get("frmConfigurarAyuda.oidFuncion");
      arrayBuffer[0] = get("frmConfigurarAyuda.hidOidFuncion");
    
      set("frmConfigurarAyuda.comboCodFuncion", arrayBuffer);

      enviaModificar();
    }
}

function focalizaComponenteLargo() {  
    document.selection.empty();

    focaliza('frmConfigurarAyuda.comboCodFuncion');       
}

function focalizaComponenteCorto() {  
    document.selection.empty();

    if (document.all["capaResultado"].style.visibility == 'hidden') {
        focaliza('frmConfigurarAyuda.comboCodFuncion');       
    } else {
        focaliza('frmConfigurarAyuda.areaObservaciones');
    }
}

function focalizaComponenteCortoShift() {    
    document.selection.empty();

    if (document.all["capaResultado"].style.visibility == 'hidden') {
      focalizaBotonHTML('botonContenido','btnSeleccionar');
    } else {
      focaliza('frmConfigurarAyuda.areaObservaciones');
    }  
}

function guardoOk(p1, p2) {
  mostrarLista();
  set("frmConfigurarAyuda.areaObservaciones", p2);
  btnProxy(1, '1');
  set("frmConfigurarAyuda.accion", "modificar");
  eval('frmConfigurarAyuda').oculto = 'N';
        
  focalizaComponenteLargo();

}

function persistioOk() {
  eval("frmConfigurarAyuda").oculto="N";
  
  set("frmConfigurarAyuda.comboCodFuncion", "");
  focaliza('frmConfigurarAyuda.comboCodFuncion');
  ocultarLista();
  set("frmConfigurarAyuda.accion", "");
  
	//set("frmConfigurarAyuda.exito", "");
  
}

function noPersistio() {
 eval("frmConfigurarAyuda").oculto="N";
 focaliza('frmConfigurarAyuda.comboCodFuncion');
}
