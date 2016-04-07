function LoadBar(){
	configurarMenuSecundario("frmContenido");

	parametros = window.dialogArguments.parametros;
	dtoFlete = window.dialogArguments.parametros.dtoFlete;
	ac = window.dialogArguments.parametros.accion;
	cu = window.dialogArguments.parametros.casoDeUso;

	if (cu == "inserta") {
	}
    if ((cu == "muestraModificacion")|| (cu == "muestraInsercion")) {
		alert(ac);
    }
    if(cu == "consultar") {
		deshabilitaTodo();
    }
    if(cu == "modificar") {
    }

	cargarLista();
	focaliza('frmContenido.txtRangoInf','');
	fMostrarMensajeError();
}
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function deshabilitaTodo(){
	accion("frmContenido.txtRangoInf", ".disabled=true");
	accion("frmContenido.txtRangoSup", ".disabled=true");
	accion("frmContenido.txtMontoFijo", ".disabled=true");
	deshabilitarHabilitarBoton('botonContenido','btnAnadir','D');
	deshabilitarHabilitarBoton('botonContenido','btnEliminar','D');
	btnProxy(1, 0);
	btnProxy(4, 0);
}
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function fGuardar() {
	//ordenamiento de los rangos
	if(dtoFlete.rangosFlete!=null&&dtoFlete.rangosFlete.length!=null) {
		var lonRanFle = dtoFlete.rangosFlete.length;
		for (var i=1; i<lonRanFle; i++) {
			  for (var j=0 ; j<lonRanFle - 1; j++) {
				  if (numeroDeFormatoSICC(dtoFlete.rangosFlete[j].rangoInf) > numeroDeFormatoSICC(dtoFlete.rangosFlete[j+1].rangoInf)) {
						temp = dtoFlete.rangosFlete[j];
						dtoFlete.rangosFlete[j] = dtoFlete.rangosFlete[j+1];
						dtoFlete.rangosFlete[j+1] = temp;
				  }
			  }
		}

		lonRanFle = dtoFlete.rangosFlete.length;
		for (var i=0; i<lonRanFle; i++) {
			dtoFlete.rangosFlete[i].guardado = 'si';
		}
	}
	window.close();
}
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function accionAnadir() {
	if(!sicc_validaciones_generales()){
	  return false;
	}                    

	var dtoRangoFlete = new Object();

	dtoRangoFlete.oidRangoFlete = nuevoOidRangoFlete();
	dtoRangoFlete.rangoInf = get('frmContenido.txtRangoInf');
	dtoRangoFlete.rangoSup = get('frmContenido.txtRangoSup');
	dtoRangoFlete.montoFij = get('frmContenido.txtMontoFijo');
	dtoRangoFlete.oidFlete = null;
	dtoRangoFlete.modificado = 'nuevo';
	dtoRangoFlete.guardado = 'no';
	dtoRangoFlete.aEliminar = 'no';

	var rangoInf = numeroDeFormatoSICC(dtoRangoFlete.rangoInf);    
	var rangoSup = numeroDeFormatoSICC(dtoRangoFlete.rangoSup);    
	var montoFij = numeroDeFormatoSICC(dtoRangoFlete.montoFij);    

	if (rangoInf<rangoSup) {	
		if (!superponeRangoFlete(dtoRangoFlete)){
			agregarRangoFlete(dtoRangoFlete);
			var row = new Array();
			row[0] = dtoRangoFlete.oidRangoFlete;//oid
			row[1] = numeroAsFormatoSICC(rangoInf);//rango inf
			row[2] = numeroAsFormatoSICC(rangoSup);//rango sup
			row[3] = numeroAsFormatoSICC(montoFij);//monto fijo

			listado1.insertar(row);

			set('frmContenido.txtRangoInf','');
			set('frmContenido.txtRangoSup','');
			set('frmContenido.txtMontoFijo','');
			focaliza('frmContenido.txtRangoInf','');			
		} else {
			cdos_mostrarAlert(GestionarMensaje('3383'));//msg "El Rango se superpone con uno ya existente."
		}
	} else {
		cdos_mostrarAlert(GestionarMensaje('3382'));//msg "El campo 'Cantidad Desde' debe ser menor al valor del campo 'Cantidad Hasta'"
	}
}
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function cargarLista(){
	if(dtoFlete.rangosFlete!=null&&dtoFlete.rangosFlete.length!=null){
		for (var i = 0; i < dtoFlete.rangosFlete.length ; i++) {
					if(dtoFlete.rangosFlete[i].aEliminar!='si'){
						var row = new Array();
						row[0] = dtoFlete.rangosFlete[i].oidRangoFlete;//oid
						row[1] = numeroAsFormatoSICC(dtoFlete.rangosFlete[i].rangoInf);
						row[2] = numeroAsFormatoSICC(dtoFlete.rangosFlete[i].rangoSup);
						row[3] = numeroAsFormatoSICC(dtoFlete.rangosFlete[i].montoFij);

						listado1.insertar(row);
					}
		}
	}
}

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function fLimpiar(){
	set('frmContenido.txtRangoInf','');
	set('frmContenido.txtRangoSup','');
	set('frmContenido.txtMontoFijo','');
	focaliza('frmContenido.txtRangoInf','');
	if (dtoFlete.rangosFlete!=null&&dtoFlete.rangosFlete.length!=null) {
		var lon = new Number(dtoFlete.rangosFlete.length);
		for (var i=0;i<lon;i++){
			if (dtoFlete.rangosFlete[i].aEliminar=='si') {
				dtoFlete.rangosFlete[i].aEliminar='';
			}
			if (dtoFlete.rangosFlete[i].modificado=='nuevo') {
				dtoFlete.rangosFlete = miSplice(dtoFlete.rangosFlete,i);
				i--;
				lon--;
			}
		}

		len = listado1.codigos().length;

		if (len>0){
			listado1.eliminar(0,len);
		}

		cargarLista();
	}
}
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function fBorrar(){
	accionEliminar();
}
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function accionEliminar() {
  if (listado1.numSelecc()>0){
		if(GestionarMensaje("5")){
			var arrElim = new Array();
			var lon = dtoFlete.rangosFlete.length;
			var cods = listado1.codSeleccionados();
			for (var i=0;i<lon;i++){
				for (var j=0;j<cods.length;j++){
					if (dtoFlete.rangosFlete[i].oidRangoFlete==cods[j]) {
						arrElim[arrElim.length]=i;
					}
				}
			}
			for (var k=arrElim.length-1;k>=0;k--){
				if (dtoFlete.rangosFlete[arrElim[k]].modificado=='nuevo'){
					dtoFlete.rangosFlete = miSplice(dtoFlete.rangosFlete,arrElim[k]);
				} else {
					dtoFlete.rangosFlete[arrElim[k]].aEliminar='si';
				}
			}
			listado1.eliminarSelecc();
		}
  } else {
		GestionarMensaje("4");
  }
}
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function fVolver(){
	window.close();
}
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function arrayComponentes(){
	var arr = new Array();
	arr[arr.length]= new Array("txtRangoInf","");
	arr[arr.length]= new Array("txtRangoSup","");    
	arr[arr.length]= new Array("txtMontoFijo","");    	
	arr[arr.length]= new Array("btnAnadir","BOTON");
	arr[arr.length]= new Array("btnEliminar","BOTON");
					 
	return arr;
}
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function tabGenerico(nombreComp, tipotab){       
	var arr = arrayComponentes();
	var tabular = false;
	var nombreFormulario = getFormularioSICC();
	var j = 0;
	var k = arr.length;
	if (tipotab != "sh") {
		j = j-1;                
		k = k-1;
	}

	while(j<k){
		var t;
		if(tipotab == "sh"){
		  k--;
		  t = k;
		} else{
		  j++;
		  t = j;                  
		}
		  
		var nombre = arr[t][0];
		var tipo = arr[t][1];
		if (tabular==false){
		  if (nombreComp==nombre){
			  tabular=true;
			  if (tipotab == "sh"){
				if (k==0) k= arr.length;
			  } else {
				if ((j+1)==arr.length)  j = -1;
			  }
		  }                
		} else {
		  try {
			var name = nombreFormulario+"."+nombre;
			if (tipo=="BOTONXY"){
			   focalizaBotonHTML_XY(nombre);
			} else if (tipo=="BOTON") {
			   focalizaBotonHTML("botonContenido",nombre)
			} else {
			   focaliza(name);
			}
			return;
		  } catch (e) {
		  }
		}
	}
}
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------