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

function inicializacion(){
 	configurarMenuSecundario("frmModificarActividad");

	//Cargar Combo
	combo_add('frmModificarActividad.cboActividadDeOrigen', '', 'Inicio Periodo');

	if(get('frmModificarActividad.hDescActividadOrigen') != 'null' && get('frmModificarActividad.hDescActividadOrigen') != ''){
		combo_add('frmModificarActividad.cboActividadDeOrigen', get('frmModificarActividad.hActividadOrigen'), get('frmModificarActividad.hDescActividadOrigen'));
		del_combo('frmModificarActividad.cboActividadDeOrigen', 0);
		var vv1 = [get('frmModificarActividad.hActividadOrigen')];
		set('frmModificarActividad.cboActividadDeOrigen', vv1);
	}else{
		del_combo('frmModificarActividad.cboActividadDeOrigen', 0);
		var vv = ['Inicio Periodo'];
		set('frmModificarActividad.cboActividadDeOrigen', vv);
	}

	if (get('frmModificarActividad.hDescActividadOrigen')=='null' ||get('frmModificarActividad.hDescActividadOrigen')==''){
		set('frmModificarActividad.hDescActividadOrigen','');
		txt_to('lblActividadDeReferencia', 'Inicio Periodo');//re harcode
	 }else
		txt_to('lblActividadDeReferencia', get('frmModificarActividad.hDescActividadOrigen'));//re harcode
	 txt_to('lblValorGrupoDeZonas', get('frmModificarActividad.hGrupoDeZona'));
	 txt_to('lblActividad1', get('frmModificarActividad.hDescActividad'));
	 set('frmModificarActividad.txtDiasDeDesplazamiento', get('frmModificarActividad.hDiasDesp'));
	 set('frmModificarActividad.txtCadaCuantosDias', get('frmModificarActividad.hCantDias'));
	 set('frmModificarActividad.txtFechaFinal', get('frmModificarActividad.hFechaFinal'));

	 var cuantDias = get("frmModificarActividad.txtCadaCuantosDias");
     var fechFin = get("frmModificarActividad.txtFechaFinal");

     if( ((cuantDias == '') && (fechFin == '')) ||((cuantDias == '0') && (fechFin == '0'))){
	 		set('frmModificarActividad.chkRepetitiva', 'N');
			set('frmModificarActividad.txtCadaCuantosDias', '');
			set('frmModificarActividad.txtFechaFinal', '');
			fEnableDisableActividades();
	 }else{
	    	set('frmModificarActividad.chkRepetitiva', 'S');
	 }

     var tipoFact = get('frmModificarActividad.hTipoFacturacion');
     if (tipoFact == '') {
			  accion('frmModificarActividad.chkRepetitiva','.disabled=true');
			  accion('frmModificarActividad.txtCadaCuantosDias','.disabled=true');
			  accion('frmModificarActividad.txtFechaFinal','.disabled=true');
     }
     focaliza('frmModificarActividad.cboActividadDeOrigen','');
}

function obtenerCampos(){
	 set('frmModificarActividad.hDescActividadOrigen', get('frmModificarActividad.cboActividadDeOrigen','T'));
	 set('frmModificarActividad.hActividadOrigen', get('frmModificarActividad.cboActividadDeOrigen','V'));
	 set('frmModificarActividad.hDiasDesp', get('frmModificarActividad.txtDiasDeDesplazamiento'));
	 if ( get('frmModificarActividad.chkRepetitiva') == 'S'){
		set('frmModificarActividad.hCantDias', get('frmModificarActividad.txtCadaCuantosDias'));
		set('frmModificarActividad.hFechaFinal', get('frmModificarActividad.txtFechaFinal'));
	 } else {
		set('frmModificarActividad.hCantDias', '');
		set('frmModificarActividad.hFechaFinal', '');
	 }
}

function camposValidos(){
	 if(fValidarNumero(get('frmModificarActividad.txtDiasDeDesplazamiento'), 10, -9999999999, 9999999999) != 'OK'){
			GestionarMensaje('405',null,null,null);
			focaliza('frmModificarActividad.txtDiasDeDesplazamiento');
			return false;
	 }
	 if(fValidarNumero(get('frmModificarActividad.txtCadaCuantosDias'), 10, 0, 9999999999) != 'OK' && get('frmModificarActividad.chkRepetitiva') == 'S'){
			GestionarMensaje('405',null,null,null);
			focaliza('frmModificarActividad.txtCadaCuantosDias');
			return false;   
	 }
	 if(fValidarNumero(get('frmModificarActividad.txtFechaFinal'), 10, 0, 9999999999) != 'OK' && get('frmModificarActividad.chkRepetitiva') == 'S'){
			GestionarMensaje('405',null,null,null);
			focaliza('frmModificarActividad.txtFechaFinal');
			return false;
	 }
	 return true;
}

function fGuardar(){
	 if (!camposValidos()) return;
	 obtenerCampos();

	 set('frmModificarActividad.accion', 'GuardarEntradaMatriz');
	 enviaSICC('frmModificarActividad');
	}

function fBorrar(){
	 if(GestionarMensaje('5')){
		obtenerCampos();
		set('frmModificarActividad.accion', 'EliminarEntradaMatriz');
		enviaSICC('frmModificarActividad');
	 }
}

function fEnableDisableActividades(){
	 if ( get("frmModificarActividad.chkRepetitiva" ) == "S" ){
			accion("frmModificarActividad.txtCadaCuantosDias", ".disabled=false");
			accion("frmModificarActividad.txtFechaFinal", ".disabled=false");
	 }else {
	   	    set('frmModificarActividad.txtCadaCuantosDias','');
			set('frmModificarActividad.txtFechaFinal','');
 			accion("frmModificarActividad.txtCadaCuantosDias", ".disabled=true");
			accion("frmModificarActividad.txtFechaFinal", ".disabled=true");
	 }            
}

function fLimpiar(){ 
	  //alert(parent.frames['contenido'].location.href);
	  parent.frames['contenido'].location.reload();           	
	  
	  /*
 set('frmModificarActividad.chkRepetitiva','');
 set('frmModificarActividad.txtCadaCuantosDias','');
 set('frmModificarActividad.txtFechaFinal','');
 set('frmModificarActividad.cboActividadDeOrigen','');
 set('frmModificarActividad.rbMoverActividadesOrigen','');
 set('frmModificarActividad.txtDiasDeDesplazamiento','');
 fEnableDisableActividades();
 focaliza('frmModificarActividad.cboActividadDeOrigen','');
 */             
}

function ShowError(){

} 

function cdosFC(componente) {
 if (componente == null || componente == '') return;
 try{
	setTimeout('focaliza(\'' + componente + '\', \'\')', 100);
 }
 catch(e){
 }
}

function fVolver(){
	 set('frmModificarActividad.accion', 'Volver');
	 enviaSICC('frmModificarActividad');
}

function moverTab() {
		//alert(document.all.chkRepetitiva.disabled=='disabled');
		
		try
		{
				 //document.all.chkRepetitiva.focus();
				 focaliza('frmModificarActividad.chkRepetitiva','');
		}
		catch (e)
		{
				 if (document.all.rbMoverActividadesOrigen[1].checked == true) {
						  //alert("Focaliza SI");
					document.all.rbMoverActividadesOrigen[1].focus();
					//focaliza('frmModificarActividad.rbMoverActividadesOrigen','',1);
				 } else {
						  //alert("Focaliza NO");
					document.all.rbMoverActividadesOrigen[0].focus();
				 }

		}
}

function focalizaRB(){
	 if (document.all.rbMoverActividadesOrigen[1].checked == true)
		document.all.rbMoverActividadesOrigen[1].focus();
		//focaliza('frmModificarActividad.rbMoverActividadesOrigen','',1);
	 else
		document.all.rbMoverActividadesOrigen[0].focus();
		//focaliza('frmModificarActividad.rbMoverActividadesOrigen','',0);         
}