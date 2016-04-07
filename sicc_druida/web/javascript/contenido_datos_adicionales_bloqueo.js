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
function onLoadPag()   {
    configurarMenuSecundario('formulario');
    fMostrarMensajeError();
    focaliza('formulario.cbTipoBloqueo');
}

function fGuardar()  {    
    if (!sicc_validaciones_generales()) { 
        return false; 
    }
	eval("formulario").oculto= "S";
	set('formulario.accion','GuardarBloqueoAdm');
	set("formulario.hOidTipoBloqueo", get('formulario.cbTipoBloqueo'));
	set("formulario.hTxtMotBloq", get('formulario.txtMotivoBloqueo'));
	set("formulario.hObsBloq", get('formulario.txtObsBloqueo'));
	set('formulario.conectorAction','LPPresentarClientes');

	enviaSICC("formulario");
}

function guardBloqOK() {
	//cdos_mostrarAlert(GestionarMensaje('1461'));
	cdos_mostrarAlert('Se ha bloqueado administrativamente al cliente');
	// vbongiov -- 30/05/2008
	close();
}

function fLimpiar() {
 	set('formulario.txtMotivoBloqueo', "");
	set('formulario.txtObsBloqueo', "");
 	set('formulario.cbTipoBloqueo', ['']);
}