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
var idenListado=1;
function onLoadPag()   {

	DrdEnsanchaConMargenDcho('listado1',24);
	document.all["Cplistado1"].style.visibility='';
	document.all["CpLin1listado1"].style.visibility='';
	document.all["CpLin2listado1"].style.visibility='';
	document.all["CpLin3listado1"].style.visibility='';
	document.all["CpLin4listado1"].style.visibility='';
	
	document.all["primera1Div"].style.visibility='hidden';
	document.all["ret1Div"].style.visibility='hidden';
	document.all["ava1Div"].style.visibility='hidden';
	document.all["separaDiv"].style.visibility='hidden';
	document.all["btnEliminarDiv"].style.visibility='visible';
	eval (ON_RSZ);  
		
	if (get(FORMULARIO+'.errDescripcion')!='') {
	  var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'),get(FORMULARIO+'.errDescripcion'));
	}	
	
	configurarMenuSecundario(FORMULARIO);	
	focaliza(FORMULARIO+'.txtDescripcion');
}
function onClickAceptar(){

	if(!sicc_validaciones_generales()){
		return;		
	}	
	if(get(FORMULARIO+'.estadoP')=="true"){
		GestionarMensaje('UIINT-006');

	}	
	fechaHasta = get(FORMULARIO+'.FechaVencimientoHasta');
        fechaDesde = get(FORMULARIO+'.FechaVencimientoDesde');
	diaHasta=obtenerDiaFecha(fechaHasta);
	diaDesde=obtenerDiaFecha(fechaDesde);
	if(diaDesde!='21'){
		if(!GestionarMensaje('UIINT-003')){
			focaliza(FORMULARIO+'.FechaVencimientoDesde');
			return;
		}
	}
	if(fechaDesde!=get(FORMULARIO+'.fechaInterfaz')){
		if(!GestionarMensaje('UIINT-004')){
			focaliza(FORMULARIO+'.FechaVencimientoDesde');
			return;
		}		
	}
	if(diaHasta!='20'){
		if(!GestionarMensaje('UIINT-005')){
			focaliza(FORMULARIO+'.FechaVencimientoHasta');
			return;
		}
	}	
	if(!comprobarFechas()){
		GestionarMensaje('UIINT-001');
		return;
	}	
	if(listado1.datos.length>0){
		var cadenaTipos=new String (listado1.datos[0][1]);
		var cadenaSubTipos=new String (listado1.datos[0][2]);
		for(i=1;i<listado1.datos.length;i++){
			cadenaTipos=cadenaTipos+"|"+listado1.datos[i][1];
			cadenaSubTipos=cadenaSubTipos+"|"+listado1.datos[i][2];
			
		}				
		set(FORMULARIO+'.listaOidTiposCliente',cadenaTipos);		
		set(FORMULARIO+'.listaOidSubTiposCliente',cadenaSubTipos);
	}
		
	set(FORMULARIO+'.descMarca',get(FORMULARIO+'.cbMarca','T'));
	set(FORMULARIO+'.descCanal',get(FORMULARIO+'.cbCanal','T'));
	set(FORMULARIO+'.descAcceso',get(FORMULARIO+'.cbAcceso','T'));
	
	set(FORMULARIO+'.accion','mantenimiento_descuentos');
	set(FORMULARIO+'.conectorAction','LPAdam');
	enviaSICC(FORMULARIO);	
	
	
	
	
}
function onClickEliminar(){	
	
	if (listado1.numSelecc() == 0) {
		GestionarMensaje('50');	
		return;
	}
	var oids = listado1.codSeleccionados();		
	for(j=0;j<oids.length;j++){
		for(i=0;i<listado1.datos.length;i++){
			if(listado1.datos[i][0]==oids[j]){
				listado1.eliminar(i);	
				listado1.actualizaDat();	
				break;
			}
		}
	}
	
}
function onClickAnadir(){	
	var oidTipoCliente = get(FORMULARIO + '.cbTipoCliente');
	var txtTipoCliente = get(FORMULARIO + '.cbTipoCliente','T');
	var oidSubtipoCliente = get(FORMULARIO + '.cbSubtipocliente');
	var txtSubtipoCliente = get(FORMULARIO + '.cbSubtipocliente','T');
	if(oidTipoCliente!=""&&oidSubtipoCliente!=""){
		listado1.actualizaDat();	
		listado1.insertar([idenListado,oidTipoCliente,oidSubtipoCliente,txtTipoCliente,txtSubtipoCliente]);
		idenListado++;
		listado1.actualizaDat();
	}else{
		GestionarMensaje('UIINT-007');
		return;
	}
}

function onChangeTipoCliente(){
	
	var oid = get(FORMULARIO + '.cbTipoCliente');		
	if (oid != "") {
		var idBusiness="MAEobtenerSubtipos";
		var dtoOid= "es.indra.sicc.util.DTOOID";	
		var oidPais = get(FORMULARIO+'.pais');
		var oidIdioma = get(FORMULARIO+'.idioma'); 	
		recargaCombo(FORMULARIO+'.cbSubtipocliente', idBusiness, dtoOid,[["oid",oid],["oidPais",oidPais],["oidIdioma",oidIdioma]]);
	}else{
		vaciaCombo(FORMULARIO + '.cbSubtipocliente');
	}
}

function onChangeCanal(){		
	
	var oid = get(FORMULARIO + '.cbCanal');		
	
	if (oid != "") {
		var idBusiness="SEGObtieneAccesosPorCanal";
		var dtoOid= "es.indra.sicc.util.DTOOID";	
		var oidPais = get(FORMULARIO+'.pais');		
		var oidIdioma = get(FORMULARIO+'.idioma'); 			
		recargaCombo(FORMULARIO+'.cbAcceso', idBusiness, dtoOid,[["oid",oid],["oidIdioma",oidIdioma],["oidPais",oidPais]]);
	}else{
		vaciaCombo(FORMULARIO + '.cbAcceso');
	}
	
}

function obtenerDiaFecha(fechaEntrada){
	formatoFechaUser=new String(get(FORMULARIO+'.hFormatoFechaPais'));
	delim = obtieneDelimitador(FORMULARIO);
	var numeroDia="";
	arrayFormatoFecha=formatoFechaUser.split(delim);
	arrayFechaEntrada=fechaEntrada.split(delim);
	for(i=0;i<arrayFormatoFecha.length;i++){
		if(arrayFormatoFecha[i]=='dd'||arrayFormatoFecha[i]=='DD'){
			numeroDia=arrayFechaEntrada[i];
		}
		
	}	
	return numeroDia;
}

function fechaValida(fechaEntrada){
         
          var fecha = get(FORMULARIO+'.'+fechaEntrada);
          if(fecha != ""){
                    var resul = EsFechaValida(fecha,fecha, FORMULARIO,null);
                    if(resul==1 || resul==2){
                           GestionarMensaje('1006', get(FORMULARIO+'.hFormatoFechaPais'));
                              focaliza(FORMULARIO+'.'+fechaEntrada);
                              return false;
              }
          }
}
function onShTab(){                                                                
          document.all['btnAceptar'].focus();                                    
} 
                                                                                   
function onTab(){
          focaliza(FORMULARIO+'.txtDescripcion');
}   

function vaciaCombo(combo){
          set_combo(combo,[['','']],['']);
}

function fLimpiar(){
        fLimpiarGenericoSICC();
        set(FORMULARIO+'.areatxtObservaciones','');          
	vaciaCombo(FORMULARIO + '.cbSubtipocliente');      
	vaciaCombo(FORMULARIO + '.cbAcceso');  
	while(listado1.datos.length!=0){
		listado1.eliminar(0);
		listado1.actualizaDat();
	}
}

function comprobarFechas(){
         
         fechaHasta = get(FORMULARIO+'.FechaVencimientoHasta');
         fechaDesde = get(FORMULARIO+'.FechaVencimientoDesde');
         var aux = EsFechaValida(fechaDesde,fechaHasta,FORMULARIO,null);
         // EsFechaValida devuelve un 3 si fechaDesde es mayor que fechaHasta
         
         if(aux == 3){
                  return false;
         } else{
                  return true;
         }
}
