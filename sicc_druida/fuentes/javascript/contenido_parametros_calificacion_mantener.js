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

var estatusVtaGlobal;
var calificacionParticipantesGlobal;

function onLoadPag(){
    fMostrarMensajeError();
	configurarMenuSecundario("formulario");        
    DrdEnsanchaConMargenDcho('listado3',32);
    document.all["Cplistado3"].style.visibility='';
    document.all["CpLin1listado3"].style.visibility='';
    document.all["CpLin2listado3"].style.visibility='';
    document.all["CpLin3listado3"].style.visibility='';
    document.all["CpLin4listado3"].style.visibility='';
    document.all["separa3Div"].style.visibility='hidden';
    document.all["primera3Div"].style.visibility='hidden';
    document.all["ret3Div"].style.visibility='hidden';
    document.all["ava3Div"].style.visibility='hidden';
    document.all["btnEliminarDiv"].style.visibility='';
   
    eval (ON_RSZ);  
    asignarLabels();    
	deshabilitarCampos();
    deshabilitarBotones();
	gestionarEstadoCapaIncrementos();
    finCargaPagina = true;
	asignarCampos();
	mostrarCapaIncrementos();
	onChangeBloquearMetas();
  
	var menu = get("formulario.opcionMenu");  
  
	if (menu == "Consultar Concurso"){
		deshabilitarCamposConsultar(); 
		btnProxy(1, 0);      
	}
	else if(menu == "Modificar Concurso") {
		btnProxy(2,'1');
		btnProxy(3,'0');
		btnProxy(7,'0');
		btnProxy(8,'0');
		btnProxy(9,'0');
	}
	else {
		focaliza('formulario.cbPeriodoEvaluacionDesde');
	}

	estatusVtaGlobal = get("formulario.tieneEstatusDeVenta");
	calificacionParticipantesGlobal = get("formulario.tieneCalificacionParticipantes");	
}

//Autor: Marcelo J. Maidana.
//Fecha:
function asignarLabels(){
    txt_to('lblDirigidoadt', get('formulario.hDescDirigidoA'));
    txt_to('lbldtTipoVentaCalificacion', get('formulario.descTipoVentaCalificacion'));
}

//Autor: Marcelo J. Maidana.
//Fecha:
function comprobarDatosObligatorios(){
		if (get('formulario.cbPeriodoEvaluacionDesde').toString() != '' &&
			get('formulario.cbPeriodoEvaluacionHasta').toString() != '' &&
			get('formulario.cbTipoDeterminacionMetas').toString() != ''){
	        return 'S';
		}
		else {
			return 'N';
	    }
}

//Autor: Marcelo J. Maidana.
//Fecha:
// INC 21052 - dmorello, 19/12/2005
// Se modificó el código completo de esta función
function onChangeMetasModificables(){
	if (get('formulario.ckMetasModificables')=='S'){
		if (get('formulario.ckBloquearMetas')=='S') {
			deshabilitarHabilitarBoton('botonContenido','btnMantenerMetas','D');
		}
		else {
			deshabilitarHabilitarBoton('botonContenido','btnMantenerMetas','A');
		}
    }
	else if (get('formulario.ckMetasModificables') == 'N') {        
		deshabilitarHabilitarBoton('botonContenido','btnMantenerMetas','D');
    }
}

//Autor: Marcelo J. Maidana.
//Fecha:
// INC 21052 - dmorello, 19/12/2005
// Se modificó el código completo de esta función
function onChangeBloquearMetas(){
	if (get('formulario.ckBloquearMetas') == 'S') {
	   deshabilitarHabilitarBoton('botonContenido','btnMantenerMetas','D');//Cleal - 22259
	} 
	if (get('formulario.ckBloquearMetas') == 'N') {
		if (get('formulario.ckMetasModificables') == 'S') {
			deshabilitarHabilitarBoton('botonContenido','btnMantenerMetas','A');//Cleal - 22259
		} 
		if (get('formulario.ckMetasModificables') == 'N') {
			deshabilitarHabilitarBoton('botonContenido','btnMantenerMetas','D');//Cleal - 22259
		}
	}
}


//Autor: Marcelo J. Maidana.
//Fecha:
function onChangeComunicacion(){
    if (get('formulario.ckComunicaciones')=='S'){
        accion('formulario.txtMensaje', '.disabled=false');
    } else {
        set('formulario.txtMensaje', '');
        accion('formulario.txtMensaje', '.disabled=true');
    }
}

//Autor: Marcelo J. Maidana.
//Fecha:
function gestionarEstadoCapaIncrementos(){
    if (get('formulario.hIndEstadoCapaIncrementos') == 'S'){
        mostrarCapaIncrementos();
    } else {
        ocultarCapaIncrementos();
    }
}

//Autor: Marcelo J. Maidana.
//Fecha:
function ocultarCapaIncrementos(){
    var a = document.getElementById('capaIncremento');
    a.style.display='none';

    //DrdEnsanchaConMargenDcho('listado3',32);
    document.all["Cplistado3"].style.visibility='hidden';
    document.all["CpLin1listado3"].style.visibility='hidden';
    document.all["CpLin2listado3"].style.visibility='hidden';
    document.all["CpLin3listado3"].style.visibility='hidden';
    document.all["CpLin4listado3"].style.visibility='hidden';
    document.all["separa3Div"].style.visibility='hidden';
    document.all["primera3Div"].style.visibility='hidden';
    document.all["ret3Div"].style.visibility='hidden';
    document.all["ava3Div"].style.visibility='hidden';
    document.all["btnEliminarDiv"].style.visibility='hidden';
}

//Autor: Marcelo J. Maidana.
//Fecha:
function mostrarCapaIncrementos(){
    var a = document.getElementById('capaIncremento');
    a.style.display='inline';

    //DrdEnsanchaConMargenDcho('listado3',32);
    document.all["Cplistado3"].style.visibility='';
    document.all["CpLin1listado3"].style.visibility='';
    document.all["CpLin2listado3"].style.visibility='';
    document.all["CpLin3listado3"].style.visibility='';
    document.all["CpLin4listado3"].style.visibility='';
    document.all["separa3Div"].style.visibility='hidden';
    document.all["primera3Div"].style.visibility='hidden';
    document.all["ret3Div"].style.visibility='hidden';
    document.all["ava3Div"].style.visibility='hidden';
    document.all["btnEliminarDiv"].style.visibility='';
}

//Autor: Marcelo J. Maidana.
//Fecha:
function accionProductosCalificar(){
    set('formulario.conectorAction', 'LPMantenerProductos');
    set('formulario.valorMenu', "no");
    set('formulario.accion','cargarProductosGrupo1');

    var parametros = new Object();  
    parametros.opcionMenu = get('formulario.opcionMenu');
    parametros.valorMenu ="no";
    parametros.ocultarPestanyas = 'S';
    mostrarModalSICC("LPMantenerProductos", "cargarProductosGrupo1", parametros);
}

//Autor: Marcelo J. Maidana.
//Fecha:
function accionDefinirVentaProyectada(){
	var o = new Object();
	o.opcionMenu = get('formulario.opcionMenu');
	var whnd = mostrarModalSICC("LPMantenerParametrosCalificacion", "cargar variables venta proyectada", o);
	if(whnd!=null){
		set("formulario.sOidAgrupacion", whnd[0]);
		//Linea 1
		set("formulario.tempCkActivas", whnd[1]);
		set("formulario.tempCkIngreso", whnd[2]);
		set("formulario.tempCkReingreso", whnd[3]);
		set("formulario.tempCkEgresos", whnd[4]);
		set("formulario.tempCkEntregadas", whnd[5]);
		set("formulario.tempCkRecibidas", whnd[6]);
		set("formulario.tempCkCapitalizacion", whnd[7]);
		//Linea 2
		set("formulario.tempCkActivasFinales", whnd[8]);
		set("formulario.tempCkActividad", whnd[9]);
		set("formulario.tempCkNumpedidos", whnd[10]);
		set("formulario.tempCkPrecioPromedioUnitario", whnd[11]);
		set("formulario.tempCkPromedioVentaPedido", whnd[12]);
		//Linea 3
		set("formulario.tempCkPromedioUnidadesPedido", whnd[13]);
		set("formulario.tempCkPromedioOrdenesPedido", whnd[14]);
		set("formulario.tempCkRetencion", whnd[15]);
		set("formulario.tempCkVentaEstadisticable", whnd[16]);
	}
}

//Autor: Marcelo J. Maidana.
//Fecha:
function accionParticipantes(){				
	var parametros = new Object();  
    parametros.opcionMenu = get('formulario.opcionMenu');
    var listasCalificacion = mostrarModalSICC("LPMantenerParametrosCalificacion", 
                                            "participantes", parametros);	

	// Agregado por ssantana, 1/7/2005, se contempla la posibilidad que se cierre la modal
	// desde la barra de título (se toma como si el usuario hubiera cancelado la accion)
	if ( listasCalificacion != null && listasCalificacion != undefined ) {
		//TODO(listo): Verificar que listasCalificacion es un string, en caso de que 
		//sea un array formatearlo a un string.
		//Se recibe un String con el siguiente formato:
		//listaCalificacionParticipantes~listaParticipantes~lstEstatusVenta
		//y cada lista tiene el siguiente formato: xx,xx,xx|xx,xx,xx|...
		//Particularmente, lstEstatusVenta se compone de los siguientes campos;
		//oidEstatusVenta,oidEstatusVentaMAE,oidPeriodoDesde,oidPeriodoHasta,
		//desEstatusVentaMae,desPeriodoDesde,desPeriodoHasta|... (cada reg. se separa con un pipe
		//y corresponde a un DTOEstatusVenta).
		/*alert("listasCalificacion: " + listasCalificacion);
		alert("listasCalificacion.valor: " + listasCalificacion.valor);*/
		set('formulario.listasCalificacion', listasCalificacion);

		var arrayListas = listasCalificacion.split("~");
		var califParti = arrayListas[0];
		var parti = arrayListas[1];
		var estatusVenta = arrayListas[2];

		if(califParti!="" && califParti!="|") {
			calificacionParticipantesGlobal = "true";
		}

		if(estatusVenta!="") {
			estatusVtaGlobal = "true";
		}
	}
}

function accionCalcularMetas(){
    //Llamar al caso de uso :

	//1° Calculo de Metas Venta Histórica (tipo de venta calificación es "Venta histórica") o
    //2° Calculo de Metas Venta Proyectada (tipo de venta calificación es "Venta Proyectada") 

	var oidPerDesde = get("formulario.cbPeriodoEvaluacionDesde");
	var oidPerHasta = get("formulario.cbPeriodoEvaluacionHasta");
	var oidFormaCal = get("formulario.cbFormaCalculo");
	var tipoIncremento = get("formulario.cbTipoIncremento");
	var tempOidTipoVentaIncremental = get("formulario.cbTipoVentaIncremental");

	set('formulario.accion', get('formulario.accion'));
	set('formulario.opcionMenu', get('formulario.opcionMenu'));
	set('formulario.oidPerDesde', oidPerDesde);
	set('formulario.oidPerHasta', oidPerHasta);
	set('formulario.oidFormaCal', oidFormaCal);
	set('formulario.tipoIncremento', tipoIncremento);
	set('formulario.tempOidTipoVentaIncremental', tempOidTipoVentaIncremental);
	set('formulario.hComunicaciones', get('formulario.ckComunicaciones'));

	pasarListaAHidden();

    if (get('formulario.oidTipoVentaCalificacion') == get('formulario.cteOidTipoVtaCalifProyectada')){
		if(get("formulario.sOidAgrupacion")=="") {
			GestionarMensaje("INC030", null, null, null);
			return false;
		}

		if (!sicc_validaciones_generales('periodos')){
			return false;
		}

        set('formulario.conectorAction', 'LPMantenerParametrosCalificacion');
        set('formulario.accion', 'calcular metas venta proyectada');
		eval('formulario').oculto = 'S';
		enviaSICC('formulario', null, null, 'N');
	}
	else {
		if(get('formulario.oidTipoVentaCalificacion')==get('formulario.cteOidTipoVtaCalifHistorica')){
			//Jrivas 21205 14/10/2005
			//if(get("formulario.sOidAgrupacion")=="") {
			//	GestionarMensaje("INC030", null, null, null);
			//	return false;
			//}

			if (!sicc_validaciones_generales('periodos')){
				return false;
			}

			if (!sicc_validaciones_generales('tipoVentaIncremental')){
				return;
			}

			if (!sicc_validaciones_generales('FormaCalculo')){
				return;
			}

			if (!sicc_validaciones_generales('tipoIncremento')){
				return;
			}

			//Se debe validar que haya al menos un registro en la 
			//lista Incrementos por rango		
			var datos = listado3.datos;
			if(!datos.length>0) {
				GestionarMensaje("INC036", null, null, null);
				return false;
			}

			//Agregado por incidencia DBLG500000255 - cvalenzu - 29/05/2006
			//se valida estatus de venta y calificacion participantes
			var oidDirigidoA = get("formulario.oidDirigidoA");
			var cteOidDirigidoAConsultora = get("formulario.cteOidDirigidoAConsultora");			

			if(oidDirigidoA==cteOidDirigidoAConsultora && estatusVtaGlobal!="true") {
				GestionarMensaje("INC058");
				return false;
			}

			if(calificacionParticipantesGlobal!="true") {
				GestionarMensaje("INC059");
				return false;
			}
			//FIN - Agregado por incidencia DBLG500000255 - cvalenzu - 29/05/2006

			set('formulario.conectorAction', 'LPMantenerParametrosCalificacion');
			set('formulario.accion', 'calcular metas venta historica');			
			eval('formulario').oculto = 'S';
			enviaSICC('formulario', null, null, 'N');
		}
		else {
			GestionarMensaje("1574", null, null, null);
		}
	}
}

function accionMantenerMetas() {
	if (get('formulario.oidTipoVentaCalificacion') == get('formulario.cteOidTipoVtaCalifProyectada')){
		set('formulario.conectorAction', 'LPMantenerParametrosCalificacion');
	    set('formulario.accion', 'validar metas venta proyectada');
		eval('formulario').oculto = 'S';
		enviaSICC('formulario', null, null, 'N');  
	}	
	else if(get('formulario.oidTipoVentaCalificacion')==get('formulario.cteOidTipoVtaCalifHistorica')){
		cargarMantenerMetas();
	}	  
}

function mostrarError() {    		
	GestionarMensaje("INC041", null, null, null);		
}
	
function cargarMantenerMetas(){
	var parametros = new Object();
	parametros.accion = get('formulario.accion');
	parametros.opcionMenu = get('formulario.opcionMenu');
	parametros.sOidAgrupacion = get('formulario.sOidAgrupacion');

	parametros.tempCkActivas = get('formulario.tempCkActivas');
	parametros.tempCkIngreso = get('formulario.tempCkIngreso');
	parametros.tempCkReingreso = get('formulario.tempCkReingreso');
	parametros.tempCkEgresos = get('formulario.tempCkEgresos');
	parametros.tempCkEntregadas = get('formulario.tempCkEntregadas');
	parametros.tempCkRecibidas = get('formulario.tempCkRecibidas');
	parametros.tempCkCapitalizacion = get('formulario.tempCkCapitalizacion');
	parametros.tempCkActivasFinales = get('formulario.tempCkActivasFinales');
	parametros.tempCkActividad = get('formulario.tempCkActividad');
	parametros.tempCkNumpedidos = get('formulario.tempCkNumpedidos');
	parametros.tempCkPrecioPromedioUnitario = get('formulario.tempCkPrecioPromedioUnitario');
	parametros.tempCkPromedioVentaPedido = get('formulario.tempCkPromedioVentaPedido');
	parametros.tempCkPromedioUnidadesPedido = get('formulario.tempCkPromedioUnidadesPedido');
	parametros.tempCkPromedioOrdenesPedido = get('formulario.tempCkPromedioOrdenesPedido');
	parametros.tempCkRetencion = get('formulario.tempCkRetencion');
	parametros.tempCkVentaEstadisticable = get('formulario.tempCkVentaEstadisticable');

    if(get('formulario.oidTipoVentaCalificacion')==get('formulario.cteOidTipoVtaCalifProyectada')){		
		
        var obj = mostrarModalSICC("LPMantenerParametrosCalificacion", "cargar metas venta proyectada", parametros);
		try {
			set('formulario.listaMetasVentaProyectada', obj.valor);
		} 
		catch (e){}
    }
	else if(get('formulario.oidTipoVentaCalificacion')==get('formulario.cteOidTipoVtaCalifHistorica')){    
		var obj = mostrarModalSICC("LPMantenerParametrosCalificacion", "cargar metas tipo venta", parametros);
		try {
			eval('formulario').oculto="S"; 
			set('formulario.listaMetasTipoVenta', obj.valor);
			set('formulario.conectorAction','LPMantenerParametrosCalificacion');
			set('formulario.accion', 'actualizarSesionDtosVentaHistorica');
			enviaSICC('formulario');
		}
		catch (e){}
    }
}

function despuesActualizarSesionDtosVentaHistorica() {
	eval('formulario').oculto="N"; 
}

/**
*
*/
function accionConsultarMetasTipoVenta() {
    var parametros = new Object();  
    parametros.opcionMenu = get('formulario.opcionMenu');
    mostrarModalSICC("LPMantenerParametrosCalificacion", "cargar metas venta historica", parametros);
}

/**
*
*/
function accionConsultarMetasVentaProyectada() {
    var parametros = new Object();  
    parametros.opcionMenu = get('formulario.opcionMenu');
    mostrarModalSICC("LPMantenerParametrosCalificacion", "cargar metas venta proyectada", parametros);
}


//Autor: Marcelo J. Maidana.
//Fecha:
function onClickPestanyaPagina(numPestanya, form, lp){
	if(get("formulario.opcionMenu")!="Consultar Concurso") {
		//Cleal - 21049
		if (!sicc_validaciones_generales('periodos')){
			return;
		}

		if (!sicc_validaciones_generales('tipoDetMetas')){
			return;
		}

		if(get('formulario.oidTipoVentaCalificacion') == get('formulario.cteOidTipoVtaCalifHistorica')){
			if (!sicc_validaciones_generales('FormaCalculo')){
				return;
			}
		}

		if(!sicc_validaciones_generales('grupoValorIncremento')) {
			return false;
		}
	
		pasarCamposAHiddens();
		onClickPestanyaHabilitada(numPestanya, form, lp);
	}
	else {
		pasarCamposAHiddens();
		onClickPestanyaHabilitada(numPestanya, form, lp);
	}	
}

//Autor: Marcelo J. Maidana.
//Fecha:
function deshabilitarCampos(){
	if(get('formulario.hEstadoCbPeriodoEvaluacionDesde')!='S'){
		accion('formulario.cbPeriodoEvaluacionDesde','.disabled=true');
	}
	if(get('formulario.hEstadoCbPeriodoEvaluacionHasta')!='S'){
		accion('formulario.cbPeriodoEvaluacionHasta','.disabled=true');
	}
	if(get('formulario.hEstadoCbTipoVentaIncremental')!='S'){
		accion('formulario.cbTipoVentaIncremental','.disabled=true');
	}
	if(get('formulario.hEstadoCbTipoVentaHistorica')!='S'){
		accion('formulario.cbTipoVentaHistorica','.disabled=true');
	}
	if(get('formulario.hEstadoCbFormaCalculo')!='S'){
		accion('formulario.cbFormaCalculo','.disabled=true');		
	}
	if(get('formulario.hEstadoCbTipoIncremento')!='S'){
		accion('formulario.cbTipoIncremento','.disabled=true');
	}

	if(get('formulario.hEstadoCkBloquearMetas')!='S'){
		accion('formulario.ckBloquearMetas','.disabled=true');
	}
	if(get('formulario.hEstadoCkMetasModificables')!='S'){
		accion('formulario.ckMetasModificables','.disabled=true');	
	}
	if(get('formulario.hEstadoCkComunicaciones')!='S'){
		accion('formulario.ckComunicaciones','.disabled=true');		
	}
	if(get('formulario.hEstadoCkDevolucines')!='S'){
		accion('formulario.ckDevolucines','.disabled=true');	
	}
	if(get('formulario.hEstadoCkAnulaciones')!='S'){
		accion('formulario.ckAnulaciones','.disabled=true');		
	}
	if(get('formulario.hEstadoCkFaltantesNoAnunciados')!='S'){
		accion('formulario.ckFaltantesNoAnunciados','.disabled=true');
	}

	if(get('formulario.hEstadoTxtMensaje')!='S'){
		accion('formulario.txtMensaje','.disabled=true');
	}
	if(get('formulario.hEstadoTxtDesde')!='S'){
		accion('formulario.txtDesde','.disabled=true');
	}
	if(get('formulario.hEstadoTxtHasta')!='S'){
		accion('formulario.txtHasta','.disabled=true');
	}
}

//Autor: Marcelo J. Maidana.
//Fecha:
function deshabilitarBotones(){
	if(get('formulario.hEstadoBtnAnadir')!='S'){
		deshabilitarHabilitarBoton('botonContenido', 'btnAnadir', 'D');
	}
  
	if(get('formulario.hEstadoBtnProductosCalificar')!='S'){  
		deshabilitarHabilitarBoton('botonContenido', 'btnProductosCalificar', 'D');
	}

	if(get('formulario.hEstadoBtnEliminar')!='S'){
		deshabilitarHabilitarBoton('botonContenido', 'btnEliminar', 'D');
	}

	if (get('formulario.hEstadoBtnDefinirVentaProyectada') != 'S') {
		deshabilitarHabilitarBoton('botonContenido','btnDefinirVentaProyectada','D');
	}
	// Fin agregado INC 21057
	var menu = get("formulario.opcionMenu"); 
	if (menu != "Consultar Concurso"){
		deshabilitarHabilitarBoton('botonContenido', 'btnConsultarMetasTipoVenta', 'D'); 
   	    deshabilitarHabilitarBoton('botonContenido', 'btnConsultarMetasVentaProyectada', 'D'); 
	} else{
			// incid 21501 - se habilita uno u otro boton 
			if (get('formulario.hEstadoBtnConsultarMetasTipoVenta') != 'S') { 
					 deshabilitarHabilitarBoton('botonContenido', 'btnConsultarMetasTipoVenta', 'D'); 
			} 
			if (get('formulario.hEstadoBtnConsultarMetasVentaProyectada') != 'S') { 
					 deshabilitarHabilitarBoton('botonContenido', 'btnConsultarMetasVentaProyectada', 'D'); 
			}
	}
}

//Autor: Marcelo J. Maidana.
//Fecha:
function pasarCamposAHiddens(){
	pasarCombosAHiddens();
	pasarChecksAHiddens();
	pasarListaAHidden();
}

//Autor: Marcelo J. Maidana.
//Fecha:
function pasarCombosAHiddens(){
	set('formulario.hPeriodoEvaluacionDesde', get('formulario.cbPeriodoEvaluacionDesde')[0]);
	set('formulario.hPeriodoEvaluacionHasta', get('formulario.cbPeriodoEvaluacionHasta')[0]);
	set('formulario.hTipoVentaHistorica', get('formulario.cbTipoVentaHistorica')[0]);
	set('formulario.hTipoVentaIncremental', get('formulario.cbTipoVentaIncremental')[0]);
	set('formulario.hTipoDeterminacionMetas', get('formulario.cbTipoDeterminacionMetas')[0]);
	set('formulario.hFormaCalculo', get('formulario.cbFormaCalculo')[0]);
	set('formulario.hTipoIncremento', get('formulario.cbTipoIncremento')[0]);
}

//Autor: Marcelo J. Maidana.
//Fecha:
function pasarChecksAHiddens(){
	set('formulario.hBloquearMetas', get('formulario.ckBloquearMetas'));
	set('formulario.hMetasModificables', get('formulario.ckMetasModificables'));
	set('formulario.hComunicaciones', get('formulario.ckComunicaciones'));
	set('formulario.hDevoluciones', get('formulario.ckDevolucines'));
	set('formulario.hAnulaciones', get('formulario.ckAnulaciones'));
	set('formulario.hFaltantesNoAnunciados', get('formulario.ckFaltantesNoAnunciados'));
}

//Autor: Marcelo J. Maidana.
//Fecha:
function asignarCampos(){
	asignarCombos();
	asignarChecks();
}

//Autor: Marcelo J. Maidana.
//Fecha:
function asignarCombos(){
	if (get('formulario.hPeriodoEvaluacionDesde') != ''){
		set('formulario.cbPeriodoEvaluacionDesde', [get('formulario.hPeriodoEvaluacionDesde')]);
	}

	if (get('formulario.hPeriodoEvaluacionHasta') != ''){
		set('formulario.cbPeriodoEvaluacionHasta', [get('formulario.hPeriodoEvaluacionHasta')]);
	}

	if (get('formulario.hTipoVentaHistorica') != ''){
		set('formulario.cbTipoVentaHistorica', [get('formulario.hTipoVentaHistorica')]);
	}

	if (get('formulario.hTipoVentaIncremental') != ''){
		set('formulario.cbTipoVentaIncremental', [get('formulario.hTipoVentaIncremental')]);
	}

	if (get('formulario.hTipoDeterminacionMetas') != ''){
		set('formulario.cbTipoDeterminacionMetas', [get('formulario.hTipoDeterminacionMetas')]);
	}

	if (get('formulario.hFormaCalculo') != ''){
		set('formulario.cbFormaCalculo', [get('formulario.hFormaCalculo')]);
	}

	if (get('formulario.hTipoIncremento') != ''){
		set('formulario.cbTipoIncremento', [get('formulario.hTipoIncremento')]);
	}
}

//Autor: Marcelo J. Maidana.
//Fecha:
function asignarChecks(){
	var bloquearMetas = get('formulario.hBloquearMetas');
	var metasModificables = get('formulario.hMetasModificables');
	var comunicaciones = get('formulario.hComunicaciones');
	var devoluciones = get('formulario.hDevoluciones');
	var anulaciones = get('formulario.hAnulaciones');
	var faltantesNoAnunciados = get('formulario.hFaltantesNoAnunciados');

	if(bloquearMetas == 'S'){
		set('formulario.ckBloquearMetas', 'S');
	}else{
		set('formulario.ckBloquearMetas', 'N');
	}

	if(metasModificables == 'S'){
		set('formulario.ckMetasModificables', 'S');
	}else{
		set('formulario.ckMetasModificables', 'N');
	}
	
	if(comunicaciones == 'S'){
		set('formulario.ckComunicaciones', 'S');
	}else{
		set('formulario.ckComunicaciones', 'N');
	}

	if(devoluciones == 'S'){
		set('formulario.ckDevolucines', 'S');
	}else{
		set('formulario.ckDevolucines', 'N');
	}

	if(anulaciones == 'S'){
		set('formulario.ckAnulaciones', 'S');
	}else{
		set('formulario.ckAnulaciones', 'N');
	}

	if(faltantesNoAnunciados == 'S'){
		set('formulario.ckFaltantesNoAnunciados', 'S');
	}else{
		set('formulario.ckFaltantesNoAnunciados', 'N');
	}
}

//Autor: Marcelo J. Maidana.
//Fecha:
function fGuardar(){
	//Cleal - 21049
	
	if (!sicc_validaciones_generales('periodos')){
				return;
			}

	if (!sicc_validaciones_generales('tipoDetMetas')){
				return;
	}

	if(get('formulario.oidTipoVentaCalificacion') == get('formulario.cteOidTipoVtaCalifHistorica')){
		if (!sicc_validaciones_generales('FormaCalculo')){
				return;
			}
	}

	if(!sicc_validaciones_generales('grupoValorIncremento')) {
		return false;
	}

	pasarCamposAHiddens();
	var datosObligatorios = comprobarDatosObligatorios();
	set('formulario.datosObligatorios', datosObligatorios);
	eval('formulario').oculto = 'S';
	set('formulario.conectorAction', 'LPMantenerParametrosCalificacion');
	set('formulario.accion', 'guardar');
	enviaSICC("formulario", "", "", "N");
}

function accionAnyadir(){
	var desde = get('formulario.txtDesde');
	var hasta = get('formulario.txtHasta');
	var incremento = get('formulario.txtIncremento');
	var porcentaje = get("formulario.incrementoPorcentaje");
	var cantidad = get("formulario.incrementoCantidad");
	var tipoIncre = get("formulario.cbTipoIncremento");

	//1° SE VALIDA QUE SE HAYA INGRESADO UN VALOR EN
	//LOS CAMPOS DESDE, HASTA Y QUE ADEMAS SEAN NUMEROS
	if (!sicc_validaciones_generales('rangoIncremento')){
		return false;
	}	

	//2° SE VALIDA QUE SI EL USUARIO ELIGIO "PORCENTAJE"
	//EN EL COMBO TIPO INCREMENTO EL VALOR DE INCREMENTOS
	//ESTE ENTRE 1 Y 999
	//DE LO CONTRARIO VALIDA QUE SEA UN NUMERO ENTRE 0 Y 9999999.99
	if(tipoIncre==porcentaje) {
		if (!sicc_validaciones_generales('rangoIncrementoPorcentaje')){
			return false;
		}
	}
	else {
		if (!sicc_validaciones_generales('rangoIncrementoNOPorcentaje')){
			return false;
		}
	}

	//3° SE VALIDA QUE LOS RANGOS NO SE SOLAPEN
	var rangoCorrecto = "true";
	var todos = listado3.datos;
	var cantidad = todos.length;
	var hastaMayor = 0;
	var desdeMenor = 0;

	//PARA ESTO, PRIMERO OBTENGO EL VALOR MAS GRANDE
	//DE LA COLUMA "HASTA" EN LA LISTA
	var formatoDef = get('formulario.hFormatoDef');
	for(var i=0; i<cantidad; i++) {
		var hastaLista = todos[i][2];

		if(i==0) {
			hastaMayor = hastaLista;
		}
		else {
			if(numeroDeFormatoSICC(hastaLista, formatoDef) > numeroDeFormatoSICC(hastaMayor, formatoDef)) {
				hastaMayor = hastaLista;
			}
		}
	}

	//DESPUES OBTENGO EL VALOR MAS CHICO DE LA COLUMA "DESDE" EN LA LISTA
	for(var i=0; i<cantidad; i++) {
		var desdeLista = todos[i][1];

		if(i==0) {
			desdeMenor = desdeLista;
		}
		else {
			if(numeroDeFormatoSICC(desdeLista, formatoDef) < numeroDeFormatoSICC(desdeMenor, formatoDef)) {
				desdeMenor = desdeLista;
			}
		}
	}

	var longitudDesde = desde.length;
	var longitudHasta = hasta.length;

	//OBTENGO EL SEPARADOR DE MILES DE SESION PARA
	//QUITARLO DEL VALOR INGRESADO POR EL USUARIO
	//ESTO ES NECESARIO PARA QUE FUNCIONE LA COMPARACION
	//QUE EL DESDE SEA MAYOR A TODOS LOS "HASTA" QUE
	//EXISTAN EN LA LISTA
	var sepMiles = get("formulario.hSeparadorMilesPais");
	var desdeAux = "";
	var hastaAux = "";

	//SE QUITA EL SEPARADOR DE MILES DE LOS CAMPOS DESDE Y HASTA
	for(var i=0; i<longitudDesde; i++) {
		var temp = desde.charAt(i);
		if(temp!=sepMiles) desdeAux = desdeAux + desde.charAt(i);
	}

	for(var i=0; i<longitudHasta; i++) {
		var temp = hasta.charAt(i);
		if(temp!=sepMiles) hastaAux = hastaAux + hasta.charAt(i);
	}

	//********** VERIFICA DESDE *************
	var solapado = "false";	

	//SI EL DESDE ES MENOR O IGUAL AL "HASTA" MAYOR DE LA LISTA y 
	//ES MAYOR O IGUAL AL "DESDE" MENOR DE LA LISTA...
	if(numeroDeFormatoSICC(desdeAux, formatoDef) <= numeroDeFormatoSICC(hastaMayor, formatoDef) &&
	   numeroDeFormatoSICC(desdeAux, formatoDef) >= numeroDeFormatoSICC(desdeMenor, formatoDef)) {

		for(var i=0; i<cantidad; i++) {
			var desdeTemp = todos[i][1];
			var hastaTemp = todos[i][2];

			//VERIFICA POR CADA UNO DE LOS REGISTROS SI EXISTEN
			//RANGOS SOLAPADOS.
			if(numeroDeFormatoSICC(desdeAux, formatoDef) >= numeroDeFormatoSICC(desdeTemp, formatoDef) &&
			   numeroDeFormatoSICC(desdeAux, formatoDef) <= numeroDeFormatoSICC(hastaTemp, formatoDef)) {
				solapado = "true";
			}
		}
	}

	//********** VERIFICA HASTA *************
	//SI EL HASTA ES MENOR O IGUAL AL "HASTA" MAYOR DE LA LISTA y 
	//ES MAYOR O IGUAL AL "DESDE" MENOR DE LA LISTA...
	if(numeroDeFormatoSICC(hastaAux, formatoDef) <= numeroDeFormatoSICC(hastaMayor, formatoDef) &&
	   numeroDeFormatoSICC(hastaAux, formatoDef) >= numeroDeFormatoSICC(desdeMenor, formatoDef)) {

		for(var i=0; i<cantidad; i++) {
			var desdeTemp = todos[i][1];
			var hastaTemp = todos[i][2];

			//VERIFICA POR CADA UNO DE LOS REGISTROS SI EXISTEN
			//RANGOS SOLAPADOS.
			if(numeroDeFormatoSICC(hastaAux, formatoDef) >= numeroDeFormatoSICC(desdeTemp, formatoDef) &&
			   numeroDeFormatoSICC(hastaAux, formatoDef) <= numeroDeFormatoSICC(hastaTemp, formatoDef)) {
				solapado = "true";
			}
		}
	}

	if(numeroDeFormatoSICC(hastaAux, formatoDef) >= numeroDeFormatoSICC(hastaMayor, formatoDef) &&
	   numeroDeFormatoSICC(desdeAux, formatoDef) <= numeroDeFormatoSICC(hastaMayor, formatoDef)) {
		solapado = "true";
	}

	if(solapado=="true") {
		//"No se puede insertar el registro. Existen rangos solapados."
		GestionarMensaje('INC047');
		return false;
	}

	//SE VALIDA QUE EL DESDE SEA MENOR AL HASTA
	if(numeroDeFormatoSICC(desdeAux, formatoDef) >= numeroDeFormatoSICC(hastaAux, formatoDef)) {
		rangoCorrecto = "false";
		//"El valor Desde debe ser menor al valor Hasta"
		GestionarMensaje('INC048');
		return false;
	}	

	//FINALMENTE SI PASO TODAS LAS VALIDACIONES, 
	//SE INGRESA EL REGISTRO EN LA LISTA
	var a = listado3.datos;
	var oid;

	if(a != null && a.length > 0){
		var ind = a.length;
		var ind2 = ind - 1;
		var arr = a[ind2];
		oid = eval(arr[0]) + 1;
	}
	else{
		oid = 1;
	}

	var dat = new Array();
	dat[0] = oid;
	dat[1] = desdeAux;
	dat[2] = hastaAux;
	dat[3] = incremento;

	listado3.insertar(dat);

	//se limpian los campos
	set('formulario.txtDesde', '');
	set('formulario.txtHasta', '');
	set('formulario.txtIncremento', '');
	//se pone el foco en desde
	focaliza("formulario.txtDesde");
}

//Autor: Marcelo J. Maidana.
//Fecha:
function accionEliminar(){
	if (listado3.numSelecc()== 0) {
		GestionarMensaje('1021',null,null,null);
		return;
    }

	listado3.eliminarSelecc();

	var datos = listado3.datos;
	var linea;
	var j;

	if(datos != null && datos.length > 0){
		for(j = 0; j < datos.length; j++){
			linea = datos[j];
			if(linea != null && linea.length > 0){
				var num = j + 1;
				linea[0] = num.toString();
			}
		}
		listado3.setDatos(datos);
	}
}

//Autor: Marcelo J. Maidana.
//Fecha:
function pasarListaAHidden(){
	var o = new Object();
	var datos = listado3.datos;
	var datoTemp;
	var sDatoTemp = '';
	var i;

	for(i = 0; i < datos.length; i++){
		var oid = datos[i][0];
		var desde = datos[i][1];
		var hasta = datos[i][2];
		var incre = datos[i][3];

		datoTemp = oid + "$" + desde + "$" + hasta + "$" + incre;

		if(i > 0){
			sDatoTemp += '|';
		}
		sDatoTemp += datoTemp.toString();
	}
	
	set('formulario.listaIncrementosPorRango', sDatoTemp);
}

//Autor: Marcelo J. Maidana.
//Fecha:
function deshabilitarCamposConsultar(){
    accion("formulario.cbPeriodoEvaluacionDesde", ".disabled=true");
    accion("formulario.cbPeriodoEvaluacionHasta", ".disabled=true");
    accion("formulario.ckBloquearMetas", ".disabled=true");
    accion("formulario.ckMetasModificables", ".disabled=true");
    accion("formulario.ckComunicaciones", ".disabled=true");
    accion("formulario.txtMensaje", ".disabled=true");
    accion("formulario.cbTipoVentaHistorica", ".disabled=true");
    accion("formulario.cbTipoVentaIncremental", ".disabled=true");
    accion("formulario.cbTipoDeterminacionMetas", ".disabled=true");
    accion("formulario.ckDevolucines", ".disabled=true");
    accion("formulario.ckAnulaciones", ".disabled=true");
    accion("formulario.ckFaltantesNoAnunciados", ".disabled=true");
    accion("formulario.cbFormaCalculo", ".disabled=true");    
    accion("formulario.cbTipoIncremento", ".disabled=true");
    accion("formulario.txtDesde", ".disabled=true");
    accion("formulario.txtHasta", ".disabled=true");
    accion("formulario.txtIncremento", ".disabled=true");
    
    deshabilitarHabilitarBoton('botonContenido','btnAnadir','D');
    deshabilitarHabilitarBoton('botonContenido','btnEliminar','D');
    deshabilitarHabilitarBoton('botonContenido','btnMantenerMetas','D');
	deshabilitarHabilitarBoton('botonContenido','btnCalcularMetas','D');
	
	//Si estamos en Consultar concurso, se deshabilitan los iconos
	//Limpiar, Clave, Favoritos y Pais
    btnProxy(2, 1);
    btnProxy(3, 0);
    btnProxy(5, 0);
    btnProxy(7, 0);
    btnProxy(8, 0);
    btnProxy(9, 0);
}

function fVolver() {
	window.close();
}

//Autor:Marcelo J. Maidana
//Fecha: 13/06/2005
function setTabFocus(campo){
	var a = document.getElementById('capaIncremento');

	if (campo == 'cbPeriodoEvaluacionDesde'){
		focaliza('formulario.cbPeriodoEvaluacionHasta');
	} else if (campo == 'cbPeriodoEvaluacionHasta'){
		if (ckBloquearMetas.disabled == false){
			focaliza('formulario.ckBloquearMetas');
		}else {
			setTabFocus('ckBloquearMetas');
		}
	} else if (campo == 'ckBloquearMetas'){
		if (ckMetasModificables.disabled == false){
			focaliza('formulario.ckMetasModificables');
		} else {
			setTabFocus('ckMetasModificables');
		}
	} else if (campo == 'ckMetasModificables'){
		if (ckComunicaciones.disabled == false){
			focaliza('formulario.ckComunicaciones');
		} else {
			setTabFocus('ckComunicaciones');
		}
	} else if (campo == 'ckComunicaciones'){
		if (txtMensaje.disabled == false){
			focaliza('formulario.txtMensaje');
		} else {
			setTabFocus('txtMensaje');
		}
	} else if (campo == 'txtMensaje'){
		if (cbTipoVentaHistorica.disabled == false){
			focaliza('formulario.cbTipoVentaHistorica');
		} else {
			setTabFocus('cbTipoVentaHistorica');
		}
	} else if (campo == 'cbTipoVentaHistorica'){
		if (cbTipoVentaIncremental.disabled == false){
			focaliza('formulario.cbTipoVentaIncremental');
		} else {
			setTabFocus('cbTipoVentaIncremental');
		}
	} else if (campo == 'cbTipoVentaIncremental'){
		if (cbTipoDeterminacionMetas.disabled == false){
			focaliza('formulario.cbTipoDeterminacionMetas');
		} else {
			setTabFocus('cbTipoDeterminacionMetas');
		}
	} else if (campo == 'cbTipoDeterminacionMetas'){
		if (ckDevolucines.disabled == false){
			focaliza('formulario.ckDevolucines');
		} else {
			setTabFocus('ckDevolucines');
		}
	} else if (campo == 'ckDevolucines'){
		if (ckAnulaciones.disabled == false){
			focaliza('formulario.ckAnulaciones');
		} else {
			setTabFocus('ckAnulaciones');
		}
	} else if (campo == 'ckAnulaciones'){
		if (ckFaltantesNoAnunciados.disabled == false){
			focaliza('formulario.ckFaltantesNoAnunciados');
		} else {
			setTabFocus('ckFaltantesNoAnunciados');
		}
	} else if (campo == 'ckFaltantesNoAnunciados'){
		if (cbFormaCalculo.disabled == false){
			focaliza('formulario.cbFormaCalculo');
		} else {
			setTabFocus('cbFormaCalculo');
		}
	} else if (campo == 'cbFormaCalculo'){
		if (cbTipoIncremento.disabled == false){
			focaliza('formulario.cbTipoIncremento');
		} else {
			setTabFocus('cbTipoIncremento');
		}
	}
	else if (campo == 'cbTipoIncremento'){
			focaliza('formulario.txtDesde');
	}
	else if (campo == 'txtDesde'){
		focaliza('formulario.txtHasta');
	} else if (campo == 'txtHasta'){
		focaliza('formulario.txtIncremento');
	} else if (campo == 'txtIncremento'){
		focalizaBotonHTML('botonContenido', 'btnAnadir');
	} else if (campo == 'btnAnadir'){
		focalizaBotonHTML('botonContenido', 'btnEliminar');
	} else if (campo == 'btnEliminar'){
		if (document.all["btnProductosCalificar"].disabled == false){
			focalizaBotonHTML('botonContenido','btnProductosCalificar');
		} else {
			setTabFocus('btnProductosCalificar');
		}
	} else if (campo == 'btnProductosCalificar'){
		if (document.all["btnDefinirVentaProyectada"].disabled == false){
			focalizaBotonHTML('botonContenido', 'btnDefinirVentaProyectada');
		} else {
			setTabFocus('btnParticipantes');
		}
	} else if (campo == 'btnDefinirVentaProyectada'){
		if (document.all["btnParticipantes"].disabled == false){
			focalizaBotonHTML('botonContenido', 'btnParticipantes');
		} else {
			setTabFocus('btnCalcularMetas');
		}
	} else if (campo == 'btnParticipantes'){
		if (document.all["btnCalcularMetas"].disabled == false){
			focalizaBotonHTML('botonContenido', 'btnCalcularMetas');
		} else {
			setTabFocus('btnMantenerMetas');
		}
	} else if (campo == 'btnCalcularMetas'){
		if (document.all["btnMantenerMetas"].disabled == false){
			focalizaBotonHTML('botonContenido', 'btnMantenerMetas');
		} else {
			focaliza('formulario.cbPeriodoEvaluacionDesde');
		}
	} else if (campo == 'btnMantenerMetas'){
		focaliza('formulario.cbPeriodoEvaluacionDesde');
	} 
}

//Autor: Marcelo J. Maidana
//Fecha: 13/06/2005
function setSHTabFocus(campo){
	var a = document.getElementById('capaIncremento');

	if (campo == 'btnMantenerMetas'){
		if (document.all["btnCalcularMetas"].disabled == false){
			focalizaBotonHTML('botonContenido', 'btnCalcularMetas');
		} else {
			setSHTabFocus('btnCalcularMetas');
		}
	} else if (campo == 'btnCalcularMetas'){
		if (document.all["btnParticipantes"].disabled == false){
			focalizaBotonHTML('botonContenido', 'btnParticipantes');
		} else {
			setSHTabFocus('btnParticipantes');
		}
	} else if (campo == 'btnParticipantes'){
		if (document.all["btnDefinirVentaProyectada"].disabled == false){
			focalizaBotonHTML('botonContenido', 'btnDefinirVentaProyectada');
		} else {
			setSHTabFocus('btnDefinirVentaProyectada');
		}
	} else if (campo == 'btnDefinirVentaProyectada'){
		if (document.all["btnProductosCalificar"].disabled == false){
			focalizaBotonHTML('botonContenido', 'btnProductosCalificar');
		} else {
			setSHTabFocus('btnProductosCalificar');
		}
	} else if (campo == 'btnProductosCalificar'){
			focalizaBotonHTML('botonContenido', 'btnEliminar');
	} else if (campo == 'btnEliminar'){
		focalizaBotonHTML('botonContenido', 'btnAnadir');
	} else if (campo == 'btnAnadir'){
		focaliza('formulario.txtIncremento');
	} else if (campo == 'txtIncremento'){
		focaliza('formulario.txtHasta');
	} else if (campo == 'txtHasta'){
		focaliza('formulario.txtDesde');
	}else if (campo == 'txtDesde'){
		focaliza('formulario.cbTipoIncremento');		
	}
	else if (campo == 'cbTipoIncremento'){
		if (cbFormaCalculo.disabled == false){
			focaliza('formulario.cbFormaCalculo');
		} else {
			setSHTabFocus('cbFormaCalculo');
		}
	} else if (campo == 'cbFormaCalculo'){
		if (ckFaltantesNoAnunciados.disabled == false){
			focaliza('formulario.ckFaltantesNoAnunciados');
		} else {
			setSHTabFocus('ckFaltantesNoAnunciados');
		}
	} else if (campo == 'ckFaltantesNoAnunciados'){
		if (ckAnulaciones.disabled == false){
			focaliza('formulario.ckAnulaciones');
		} else {
			setSHTabFocus('ckAnulaciones');
		}
	} else if (campo == 'ckAnulaciones'){
		if (ckDevolucines.disabled == false){
			focaliza('formulario.ckDevolucines');
		} else {
			setSHTabFocus('ckDevolucines');
		}
	} else if (campo == 'ckDevolucines'){
		if (cbTipoDeterminacionMetas.disabled == false){
			focaliza('formulario.cbTipoDeterminacionMetas');
		} else {
			setSHTabFocus('cbTipoDeterminacionMetas');
		}
	} else if (campo == 'cbTipoDeterminacionMetas'){
		if (cbTipoVentaIncremental.disabled == false){
			focaliza('formulario.cbTipoVentaIncremental');
		} else {
			setSHTabFocus('cbTipoVentaIncremental');
		}
	} else if (campo == 'cbTipoVentaIncremental'){
		if (cbTipoVentaHistorica.disabled == false){
			focaliza('formulario.cbTipoVentaHistorica');
		} else {
			setSHTabFocus('cbTipoVentaHistorica');
		}
	} else if (campo == 'cbTipoVentaHistorica'){
		if (txtMensaje.disabled == false){
			focaliza('formulario.txtMensaje');
		} else {
			setSHTabFocus('txtMensaje');
		}
	} else if (campo == 'txtMensaje'){
		if (ckComunicaciones.disabled == false){
			focaliza('formulario.ckComunicaciones');
		} else {
			setSHTabFocus('ckComunicaciones');
		}
	} else if (campo == 'ckComunicaciones'){
		if (ckMetasModificables.disabled == false){
			focaliza('formulario.ckMetasModificables');
		} else {
			setSHTabFocus('ckMetasModificables');
		}
	} else if (campo == 'ckMetasModificables'){
		if (ckBloquearMetas.disabled == false){
			focaliza('formulario.ckBloquearMetas');
		}else {
			setSHTabFocus('ckBloquearMetas');
		}
	} else if (campo == 'ckBloquearMetas'){
		focaliza('formulario.cbPeriodoEvaluacionHasta');
	} else if (campo == 'cbPeriodoEvaluacionHasta'){
		focaliza('formulario.cbPeriodoEvaluacionDesde');
	} else if (campo == 'cbPeriodoEvaluacionDesde'){
		if (document.all["btnMantenerMetas"].disabled == false){
			focalizaBotonHTML('botonContenido', 'btnMantenerMetas');
		} else {
			setSHTabFocus('btnMantenerMetas');
		}
	}
}

function calcularMetasVentaProyectadaOK() {
	eval("formulario").oculto= "N";
	focaliza('formulario.cbPeriodoEvaluacionDesde');
}

function calcularMetasVentaProyectadaERR() {
	focaliza('formulario.cbPeriodoEvaluacionDesde');
}

function calcularMetasTipoVentaOK() {
	eval("formulario").oculto= "N";
	focaliza('formulario.cbPeriodoEvaluacionDesde');
}

function calcularMetasTipoVentaERR() {
	focaliza('formulario.cbPeriodoEvaluacionDesde');
}
