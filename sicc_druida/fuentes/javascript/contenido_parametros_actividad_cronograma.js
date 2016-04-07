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

function Inicializacion(){

  configurarMenuSecundario("frmParametrosActividad");
  eval (ON_RSZ); 
	LoadBar();
  
	
	posicionarCombo();
	
  if( get('frmParametrosActividad.hCasoDeUso')!='eliminar' ){
    visibilidad('capaBotones','V');
  }

	if(get_visibilidad('capaDatosActividadAnadida')){
		fnDisabled("btnModificar",true);
		fnDisabled('btnAnadir',true);
	}

	reformatFecha();

	DeshabilitarCampos();	

  LimpiarCombo('frmParametrosActividad.cbZona');
  var items = [get('frmParametrosActividad.hZona')];
  set('frmParametrosActividad.cbZona', items);

  var ii = document.all.tags('INPUT');
  for(i = 0; i < ii.length; i++){
    if(ii.item(i).type == 'radio'){
      ii[i].disabled = true;
    }
  }
   

  accion("frmParametrosActividad.txtDiasA", ".disabled=true");	 
  accion("frmParametrosActividad.txtFechaFinA", ".disabled=true"); 
  accion("frmParametrosActividad.txtFechaIniA", ".disabled=true"); 
}

function LimpiarCombo(cmb){
  var i = 1;

  try{
    if( combo_get(cmb, 'L') > 0 ){
      while(i==1){
        if( combo_get(cmb, 'T', 0)=='' ){
          del_combo(cmb, 0);
        }
        else{
          i=0;
        }
      }
    }
  }
  catch(e){}
}

function DeshabilitarCampos(){
	accion("frmParametrosActividad.txtCodigoActividad", ".disabled=true");
	accion("frmParametrosActividad.cbZona", ".disabled=true");
	accion("frmParametrosActividad.txtHora", ".disabled=true");
	accion("frmParametrosActividad.txtFechaIni", ".disabled=true");

  
}

function HabilitarCampos(){
	accion("frmParametrosActividad.cbZona", ".disabled=false");
	
	accion("frmParametrosActividad.txtHora", ".disabled=false");
	accion("frmParametrosActividad.txtFechaIni", ".disabled=false");

}

function LoadBar(){
	achicarTablaAbajo();

  if (get('frmParametrosActividad.hCasoDeUso')=='eliminar') {
		focaliza('frmParametrosActividad.cbZona', '');		
	} else {
		accion('frmParametrosActividad.cbZona','.disabled=true');
	}

	cargar_radio();
	ShowError();
}

function limpiarCampos(){
	DeshabilitarCampos();
	var APP_BARRA = parent.frames['iconos']; 
	APP_BARRA.desHabilitarGuardar();
	achicarTablaAbajo();
	sizeTo('capaBusqueda2',0,0);
	sizeTo('capaDatosActividadAnadida',0,0);
	moveTo('capaDatosActividadAnadida',0,0);
	sizeTo('capaBoton2',0,0);
	moveTo('capaBoton2',0,0);
	

	fnDisabled("btnModificar",false);
	fnDisabled('btnAnadir',false);

	set('frmParametrosActividad.txtHora',get('frmParametrosActividad.hidHora'));
	posicionarCombo();
	var items = [get('frmParametrosActividad.hZona')];
	set('frmParametrosActividad.cbZona', items);
	set('frmParametrosActividad.txtFechaIniA','');
	reformatFecha();
	
}

function ShowError(){
	 if (get('frmParametrosActividad.errDescripcion')!=''){
        
        var vResultado = fMostrarMensajeError(get('frmParametrosActividad.errCodigo'),
        get('frmParametrosActividad.errDescripcion'));
        if ( get('frmParametrosActividad.hCasoDeUso') == 'eliminar' ){
                cancelarEliminar();
        } else {
                cancelar();
        }
    }

}

function cancelarEliminar(){
    set('frmParametrosActividad.accion','');
    set('frmParametrosActividad.conectorAction','LPEliminarCronograma');
    envia('frmParametrosActividad');
}

function cancelar(){
    set('frmParametrosActividad.accion','');
    set('frmParametrosActividad.conectorAction','LPModificarCronograma');
    envia('frmParametrosActividad');
}

function cargar_radio(){

	//valor = get('frmParametrosActividad.hidIndZona');
	//if (valor == 'Si'){ 
	//	set('frmParametrosActividad.RebelRepetitiva','S');
	//}
	//else {
	//   set('frmParametrosActividad.RebelRepetitiva','N');
	// }
}

function setRadioN() {

 set('frmParametrosActividad.hidIndZona', 'No');

}

function setRadioS() {

  set('frmParametrosActividad.hidIndZona', 'Si');
  
}

function obtenerZonal(){
	set('frmParametrosActividad.sZona', get('frmParametrosActividad.cbZona'));
	set('frmParametrosActividad.sSeccion', get('frmParametrosActividad.cbSeccion'));
	set('frmParametrosActividad.descZona', get('frmParametrosActividad.cbZona', 'T'));
	set('frmParametrosActividad.descSeccion', get('frmParametrosActividad.cbSeccion', 'T'));
}

function enviarFormulario() {

	set('frmParametrosActividad.hZonas', get('frmParametrosActividad.cbZonas'));
	enviaSICC('frmParametrosActividad');

}

function comprobarZona(){
	if(get('frmParametrosActividad.cbZonas') != ""){
		set('frmParametrosActividad.accion', 'seleccionZona');
		set('frmParametrosActividad.conectorAction', 'LP_Consultar_Cronograma');

		enviarFormulario();
	}
}

function comprobarRegion(){
	if(get('frmParametrosActividad.cbRegiones') != ""){
		set('frmParametrosActividad.accion', 'seleccionRegion');
		set('frmParametrosActividad.conectorAction', 'LP_Consultar_Cronograma');

		set('frmParametrosActividad.cbSecciones', '');

		enviarFormulario();
	}
}

function comprobarZonal(){
	if(	
		get('frmParametrosActividad.cbZona')	!= "" && 
		get('frmParametrosActividad.cbSeccion') != ""){
		
		set('frmParametrosActividad.accion', 'seleccionZonal');
		set('frmParametrosActividad.conectorAction', 'LP_Consultar_Cronograma');

		set('frmParametrosActividad.cbRegiones', '');
		set('frmParametrosActividad.cbZonas', '');
		set('frmParametrosActividad.cbSecciones', '');

		enviarFormulario();
	}
}

function posicionarCombo() {
	var iSeleccionadoP = new Array();
	iSeleccionadoP[0] = get('frmParametrosActividad.sZona');
	set('frmParametrosActividad.cbZona',iSeleccionadoP);

	var iSeleccionado = new Array();
	iSeleccionado[0] = get('frmParametrosActividad.sSeccion');
	set('frmParametrosActividad.cbCanales',iSeleccionado);

}

function siguiente(){
	if(lstDatosActividades.getSeleccion()!=''){
		habilitarCapaDeAbajo();
		var APP_BARRA = parent.frames['iconos']; 
		APP_BARRA.habilitarGuardar();

		var ii = document.all.tags('INPUT');
		var k=0;
		for(i = 0; i < ii.length; i++){
		    if(ii.item(i).type == 'radio'){

				if(k==2||k==3){
				  ii[i].disabled = false;
				}
  				k++;
			}
		}
	}else{
		GestionarMensaje('4');
	}
}

function habilitarCapaDeAbajo(){
	var tablas = document.all.tags("TABLE");
	for (var i=0;i<tablas.length ;i++ ){
		if(tablas[i].name=="tablaDatos"){
			tablas[i].style.display="block";
		}
	}
	visibilidad('capaBusqueda2', 'V');
	sizeTo('capaBusqueda2',230,605);
}


function achicarTablaAbajo(){
	var tablas = document.all.tags("TABLE");
	for (var i=0;i<tablas.length ;i++ ){
		if(tablas[i].name=="tablaDatos"){
			tablas[i].style.display="none";
		}
	}
}

function sizeTo(nombre,alto,ancho) {
	if (ns) {
		var nsdoc=eval(nombre+'.nsdoc');
		nsdoc=nsdoc.substring(0,nsdoc.length-9);
		nsdoc=eval(nsdoc);
		if(!isNaN(parseFloat(alto))){
			nsdoc.height=parseFloat(alto);
		}
		if(!isNaN(parseFloat(ancho))){
			nsdoc.width=parseFloat(ancho);
		}
	}
	else {
		//debugger;		
		//alert(document.all[nombre]);
		if(!isNaN(parseFloat(alto))){
			document.all[nombre].runtimeStyle.height=parseFloat(alto);
		}
		if(!isNaN(parseFloat(ancho))){
			document.all[nombre].runtimeStyle.width=parseFloat(ancho);
		}

		var left, top, height, width;
		left = parseInt(document.all[nombre].currentStyle.left,10);
		top = parseInt(document.all[nombre].currentStyle.top,10);
		width = parseInt(document.all[nombre].currentStyle.width,10);
		height = parseInt(document.all[nombre].currentStyle.height,10);
		var arr = new Array(0,width,height,0);
		setClip(nombre,arr);
	}
}

function guardar(){
	if(get_visibilidad('capaBusqueda2') && validaciones()){
		set('frmParametrosActividad.hidCodActividadA', lstDatosActividades.getSeleccion());
		set('frmParametrosActividad.accion', 'Guardar');
		set('frmParametrosActividad.conectorAction', 'LPAnadirActividadCronograma');
		set('frmParametrosActividad.hidHora', get('frmParametrosActividad.txtHora'));
		

		enviarFormulario();
	}else{
		
		if(!get_visibilidad('capaBusqueda2') && verificarFecha3() ) { //&& valida ){
			//alert("IF 2");
				var valida = validaHora(get('frmParametrosActividad.txtHora'));

				if (!valida) {
					focaliza('frmParametrosActividad.txtHora');
					return;
				}

			set('frmParametrosActividad.hZona', get('frmParametrosActividad.cbZona'));

			set('frmParametrosActividad.hidHora', get('frmParametrosActividad.txtHora'));

			set('frmParametrosActividad.accion', 'modificarActividadCronograma');
			set('frmParametrosActividad.conectorAction', 'LPModificarCronograma');
			enviarFormulario();
		}else{

		}
	}
}

function validaciones(){
	//alert("Validaciones");
	if(fValidarCTEXT('frmParametrosActividad.txtDiasejA')) //&& (get('frmParametrosActividad.txtHoraA')=='' ))
	{

		try{
			if(get('frmParametrosActividad.txtFechaFinA')!='')
					return verificarFecha2();
		}catch(ex){return true;}

		if(get('frmParametrosActividad.RebelRepetitivaA')=='S')
			return (fValidarCTEXT('frmParametrosActividad.txtDiasA') && fValidarCTEXT('frmParametrosActividad.txtFechaFinA'));

		// Verificar que se haya seleccionado un elemento de la lista
		if( lstDatosActividades.getSeleccion() == null || lstDatosActividades.getSeleccion() == ''){
			GestionarMensaje('4');
			return false;
		}
		
		var valida = validaHora(get('frmParametrosActividad.txtHoraA'));
		if (!valida) {
			focaliza('frmParametrosActividad.txtHoraA');
			return;
		}
		
		return true;


	} 

/* else{
		if(get('frmParametrosActividad.txtHoraA')=='' || !valida)
				focaliza('frmParametrosActividad.txtHoraA');
		return false;
	}
*/

}

function anadir(){
	set('frmParametrosActividad.accion', 'TraerDatos');
	set('frmParametrosActividad.conectorAction', 'LPAnadirActividadCronograma');
	fnDisabled("btnModificar",true);
	fnDisabled('btnAnadir',true);
	enviarFormulario();
}

function fBorrar(){
  if(GestionarMensaje('5')){
    set('frmParametrosActividad.accion', 'eliminar');
    set('frmParametrosActividad.conectorAction', 'LPEliminarCronograma');
    enviarFormulario();
  }
}

function habilitarModificacion(){
	var APP_BARRA = parent.frames['iconos']; 
	APP_BARRA.habilitarGuardar();
	HabilitarCampos();
	fnDisabled('btnAnadir',true);
	fnDisabled("btnModificar",true);
}


function reformatFecha(){
	var aux = "" + get('frmParametrosActividad.hidFechaIni');
		if(aux.indexOf('-')>-1){
      
			var desde = aux.split('-');
			var anoDesde = desde[0];
			var mesDesde = desde[1];
			var diaDesde = desde[2];
			set('frmParametrosActividad.txtFechaIni',diaDesde+'/'+mesDesde+'/'+anoDesde);
		}else{
      
			set('frmParametrosActividad.txtFechaIni',get('frmParametrosActividad.hidFechaIni'));
		}

		aux = "" + get('frmParametrosActividad.fechaFin');
		if(aux.indexOf('-')>-1){
			var hasta = get('frmParametrosActividad.fechaFin').split('-');
			var anoHasta = hasta[0];
			var mesHasta = hasta[1];
			var diaHasta = hasta[2];

			// SE COMENTO DEBIDO A QUE SE ELIMINO EL COMPONENTE
			//set('frmParametrosActividad.txtFechaFin',diaHasta+'/'+mesHasta+'/'+anoHasta);

		}else{
			// SE COMENTO DEBIDO A QUE SE ELIMINO EL COMPONENTE
			//set('frmParametrosActividad.txtFechaFin',get('frmParametrosActividad.fechaFin'));
		}
        
}

function fnDisabled(nombre,status){
	try{
		var obj = document.all.tags("INPUT").item(nombre);

		if(obj!=null && !obj.length){
			obj.disabled = (status==true);
		}
	}catch(e){
		//alert(e.description)
	}
}

function validaHora(input){

	var expHora = new RegExp('[0-2][0-9]:[0-5][0-9]:[0-5][0-9]');

//	alert(expHora.test(horaIngresada));

	if (expHora.test(input)) {
		var horaHHmmss = input.split(':');

		var hora = horaHHmmss[0];
	
		if (fValidarNumero(hora,2,0,23)!='OK'){	
			GestionarMensaje('2516');
			return false;
		}
	} else {
		GestionarMensaje('2516');
		return false;
	}

/*
	if(input != null && input!=""){
		if(input.indexOf(':')==-1){
			cdos_mostrarAlert(GestionarMensaje('942'));
			return false;
		}

		var aux = (""+input).split(':');

		var hora = aux[0];

		var min = 0;

		if (aux.length==2)
			min = aux[1];


		if (fValidarNumero(hora,2,0,23)!='OK' || fValidarNumero(min,2,0,59)!='OK' ){	
			cdos_mostrarAlert(GestionarMensaje('942'));
			return false;
		}

	
	}
*/
	return true;
}

function verificarFecha(){
	
    if(get('frmParametrosActividad.txtFechaIni')!='' &&
    get('frmParametrosActividad.txtFechaIniA')!='' && 
	ValidaFecha(get('frmParametrosActividad.txtFechaIni'), 'd/m/Y')=='OK' &&
	ValidaFecha(get('frmParametrosActividad.txtFechaIniA'), 'd/m/Y')=='OK'){
        //procedemos a verificar que una fecha sea mayor que la otra
        var desde = get('frmParametrosActividad.txtFechaIni').split('/');
        var hasta = get('frmParametrosActividad.txtFechaIniA').split('/');
        var diaDesde = desde[0];
        var mesDesde = desde[1];
        var anoDesde = desde[2];
        
        var diaHasta = hasta[0];
        var mesHasta = hasta[1];
        var anoHasta = hasta[2];
        if(anoHasta < anoDesde || (anoHasta == anoDesde && mesHasta < mesDesde) ||
        (anoHasta == anoDesde && mesHasta == mesDesde && diaHasta < diaDesde) ){
           cdos_mostrarAlert(GestionarMensaje('935'));
			focaliza('frmParametrosActividad.txtDiasejA');
			return false;
		}
		return true;
    }else{
      var valida = ValidaFecha(get('frmParametrosActividad.txtFechaIni'), 'd/m/Y');
      if(valida!='OK'){
        cdos_mostrarAlert(valida);
        focaliza('frmParametrosActividad.txtFechaIni');
        return false;
      }
      
      valida = ValidaFecha(get('frmParametrosActividad.txtFechaIniA'), 'd/m/Y');
      if(valida!='OK'){
        cdos_mostrarAlert(valida);
        focaliza('frmParametrosActividad.txtDiasejA');
        return false;
      }
      
    }
	return false;
	
}

function verificarFecha2(){
    if(get('frmParametrosActividad.txtFechaIniA')!='' &&
    get('frmParametrosActividad.txtFechaFinA')!='' && 
	ValidaFecha(get('frmParametrosActividad.txtFechaIniA'), 'd/m/Y')=='OK' &&
	ValidaFecha(get('frmParametrosActividad.txtFechaFinA'), 'd/m/Y')=='OK'){
        //procedemos a verificar que una fecha sea mayor que la otra
        var desde = get('frmParametrosActividad.txtFechaIniA').split('/');
        var hasta = get('frmParametrosActividad.txtFechaFinA').split('/');
        var diaDesde = desde[0]-0;
        var mesDesde = desde[1]-0;
        var anoDesde = desde[2]-0;
        
        var diaHasta = hasta[0]-0;
        var mesHasta = hasta[1]-0;
        var anoHasta = hasta[2]-0;
        if(anoHasta < anoDesde || (anoHasta == anoDesde && mesHasta < mesDesde) ||
        (anoHasta == anoDesde && mesHasta == mesDesde && diaHasta < diaDesde) ){
			cdos_mostrarAlert(GestionarMensaje('936'));
			focaliza('frmParametrosActividad.txtFechaFinA');
			return false;
		}
		return true;
    }else{
      var valida = ValidaFecha(get('frmParametrosActividad.txtFechaIniA'), 'd/m/Y');
      if(valida!='OK'){
        cdos_mostrarAlert(valida);
        focaliza('frmParametrosActividad.txtDiasejA');
        return false;
      }
      if(get('frmParametrosActividad.txtFechaFinA')!=''){
        valida = ValidaFecha(get('frmParametrosActividad.txtFechaFinA'), 'd/m/Y');
       if(valida!='OK'){
         cdos_mostrarAlert(valida);
         focaliza('frmParametrosActividad.txtFechaFinA');
         return false;
       }
      }else{
        return true;
      }
      
    }
	return false;
}

function verificarFecha3(){

	//ESTA ES LA CONDICION ORIGINAL
	// SE COMENTO DEBIDO A QUE SE ELIMINO EL COMPONENTE txtFechaFin
	/*
    if(get('frmParametrosActividad.txtFechaIni')!='' &&
    get('frmParametrosActividad.txtFechaFin')!='' && 
    ValidaFecha(get('frmParametrosActividad.txtFechaIni'), 'd/m/Y')=='OK' &&
    ValidaFecha(get('frmParametrosActividad.txtFechaFin'), 'd/m/Y')=='OK')
	*/

    if(get('frmParametrosActividad.txtFechaIni')!='' && ValidaFecha(get('frmParametrosActividad.txtFechaIni'), 'd/m/Y')=='OK'){

        //procedemos a verificar que una fecha sea mayor que la otra

		// SE COMENTO DEBIDO A QUE SE ELIMINO EL COMPONENTE txtFechaFin
		/*
        var desde = get('frmParametrosActividad.txtFechaIni').split('/');
        var hasta = get('frmParametrosActividad.txtFechaFin').split('/');
        var diaDesde = desde[0];
        var mesDesde = desde[1];
        var anoDesde = desde[2];
        
        var diaHasta = hasta[0];
        var mesHasta = hasta[1];
        var anoHasta = hasta[2];
        if(anoHasta < anoDesde || (anoHasta == anoDesde && mesHasta < mesDesde) ||
        (anoHasta == anoDesde && mesHasta == mesDesde && diaHasta < diaDesde) ){
			cdos_mostrarAlert(GestionarMensaje('936'));
			focaliza('frmParametrosActividad.txtFechaFin');
			return false;
		}
		*/

		return true;
    }
    else{
      var valida = ValidaFecha(get('frmParametrosActividad.txtFechaIni'), 'd/m/Y');
      if(valida!='OK'){
        cdos_mostrarAlert(valida);
        focaliza('frmParametrosActividad.txtFechaIni');
        return false;
      }

	  // este else se agrego debido al codigo comentado de mas abajo
	  // en caso de que todas las fechas esten bien se devuelve true
	  // 6/9/03
	  else{
		return true;
	  }

	// SE COMENTO DEBIDO A QUE SE ELIMINO EL COMPONENTE txtFechaFin 6/9/03
	  /*
      if(get('frmParametrosActividad.txtFechaFin')!=''){
        valida = ValidaFecha(get('frmParametrosActividad.txtFechaFin'), 'd/m/Y');
       if(valida!='OK'){
         cdos_mostrarAlert(valida);
         focaliza('frmParametrosActividad.txtFechaFin');
         return false;
       }
      }
	  else{
		return true;
      }
      */

    }
    
	return false;
}


function Volver(){
	set('frmParametrosActividad.accion', 'volver');
  if( get('frmParametrosActividad.hCasoDeUso')=='eliminar' ){
    set('frmParametrosActividad.conectorAction', 'LPEliminarCronograma');
  }
  else{
    set('frmParametrosActividad.conectorAction', 'LPModificarCronograma');
  }
	envia('frmParametrosActividad');
}

/*Las siguientes 2 son de fotero*/
function desHabilitarDias(){
	set("frmParametrosActividad.txtDiasA",'');
	set("frmParametrosActividad.txtFechaFinA",'');
	accion("frmParametrosActividad.txtDiasA", ".disabled=true");
	accion("frmParametrosActividad.txtFechaFinA", ".disabled=true");
}

function habilitarDias(){
	accion("frmParametrosActividad.txtDiasA", ".disabled=false");
	accion("frmParametrosActividad.txtFechaFinA", ".disabled=false");
}


function armarFechaInicio(){
	var formatoValido = fValidarNumero(get('frmParametrosActividad.txtDiasejA'),2,0,99);
	if(get('frmParametrosActividad.txtDiasejA')!='' && formatoValido=='OK'){
	 var desde = get('frmParametrosActividad.txtFechaIni').split('/');
	 var diaDesde = desde[0];
     var mesDesde = desde[1];
     var anoDesde = desde[2];
	 
	 
	 
	 var dia = new Date(mesDesde+"/"+diaDesde+"/"+anoDesde);
	 var dias = (get('frmParametrosActividad.txtDiasejA'))*1000*60*60*24;
	 dia = new Date(dia.getTime()+dias);

	 sDia = dia.getDate();

	 if(sDia < 10) {
		sDia = '0' + sDia;
	 }

	 sMes = dia.getMonth()+1;

	 if(sMes < 10) {
		sMes = '0' + sMes;
	 }



	 //set('frmParametrosActividad.txtFechaIniA',dia.getDate()+"/"+(dia.getMonth()+1)+"/"+dia.getYear());
	 set('frmParametrosActividad.txtFechaIniA',sDia+"/"+sMes+"/"+dia.getYear());
	}else{
		if(formatoValido!='OK')
			cdos_mostrarAlert(formatoValido);
		
		set('frmParametrosActividad.txtFechaIniA','');
		setTimeout("foco('frmParametrosActividad.txtDiasejA')",50	);
	 }
}
