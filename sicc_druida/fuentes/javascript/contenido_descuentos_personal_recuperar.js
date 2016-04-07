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

function onLoadPag()   {

	DrdEnsanchaConMargenDcho('listado1',12);
	document.all["Cplistado1"].style.visibility='';
	document.all["CpLin1listado1"].style.visibility='';
	document.all["CpLin2listado1"].style.visibility='';
	document.all["CpLin3listado1"].style.visibility='';
	document.all["CpLin4listado1"].style.visibility='';
	
	document.all["primera1Div"].style.visibility='';
	document.all["ret1Div"].style.visibility='';
	document.all["ava1Div"].style.visibility=''; 
	document.all["separaDiv"].style.visibility='';
	
	eval (ON_RSZ);  
	if (get(FORMULARIO+'.errDescripcion')!='') {
	  var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'),get(FORMULARIO+'.errDescripcion'));
	}	
	
	configurarMenuSecundario(FORMULARIO);	
	focaliza(FORMULARIO+'.txtNumeroDocumento');
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

function onclickBuscar(){	
	novisibleLista();
        if(get(FORMULARIO+'.FechaVencimientoHasta')!=''&&get(FORMULARIO+'.FechaVencimientoDesde')!=''){		
		if(!comprobarFechas()){
			GestionarMensaje('UIINT-001');
			return;
		}			
        }
	var numeroDocumento =get(FORMULARIO+'.txtNumeroDocumento');//Long   
	var numeroLote =get(FORMULARIO+'.txtLote');//String   
	var descripcionLote =get(FORMULARIO+'.txtDescripcion');//String   
	var oidMarca =get(FORMULARIO+'.cbMarca');//Long   
	var oidCanal =get(FORMULARIO+'.cbCanal');//Long   
	var oidAcceso =get(FORMULARIO+'.cbAcceso');//Long   
	var fechaVencimientoDesde =get(FORMULARIO+'.FechaVencimientoDesde');//String  
	var fechaVencimientoHasta =get(FORMULARIO+'.FechaVencimientoHasta');//String 
	var formatoFecha= get(FORMULARIO+'.hFormatoFechaPais')
	
	var cadenaEstados =get(FORMULARIO+'.cbEstado');//ArrayList ?????????
	estados=new String(cadenaEstados.toString());
	/*
	arrayEstados=estados.split(",");
	var cadenaEstadosEnviar=new String(arrayEstados[0]);	
	for(i=1;i<arrayEstados.length;i++){
		cadenaEstadosEnviar=cadenaEstadosEnviar+" %23 "+arrayEstados[i];
	}
	*/
	var idioma=get(FORMULARIO+'.idioma');
	var pais=get(FORMULARIO+'.pais');
	configurarPaginado(mipgndo, "INTBuscarDescuentos", "ConectorBuscarDescuentosINT","es.indra.sicc.dtos.intsys.DTOBusquedaDescuentos",
		[["oidPais",pais],
		["oidIdioma",idioma],
		['numeroDocumento',numeroDocumento],
		['numeroLote',numeroLote],
		['descripcionLote',descripcionLote],
		['oidMarca',oidMarca],
		['oidCanal',oidCanal],
		['oidAcceso',oidAcceso],
		['fechaVencimientoDesde',fechaVencimientoDesde],
		['fechaVencimientoHasta',fechaVencimientoHasta],
		['formatoFecha',formatoFecha],
		['stringStatus',estados]]);
	
}

function onClickRecuperarLote(){
	
	if (listado1.numSelecc() == 0) {
		GestionarMensaje('50');	
		return;
	} else if (listado1.numSelecc() != 1 ) {	
		GestionarMensaje('8');
		var seleccion=listado1.codigos();
		var i=0;
		while(seleccion[i]!=null){
			listado1.deselecciona(i); 
			i++;            
		}
		return;
	}
	var oid = new String(listado1.codSeleccionados());			
	for(i=0;i<listado1.datos.length;i++){	
		if(listado1.datos[i][0]==oid){	
			set(FORMULARIO+'.descMarca',listado1.datos[i][1]);	
			set(FORMULARIO+'.descCanal',listado1.datos[i][2]);	
			set(FORMULARIO+'.descAcceso',listado1.datos[i][3]);
			break;
		}
	}
	set(FORMULARIO+'.hOidDescuentoPersonalCabecera',oid);
	set(FORMULARIO+'.accion','recuperar_lote');
	set(FORMULARIO+'.conectorAction','LPAdam');
	enviaSICC(FORMULARIO);	
	
}

function vaciaCombo(combo){
          set_combo(combo,[['','']],['']);
}

function fLimpiar(){
        fLimpiarGenericoSICC();              
	vaciaCombo(FORMULARIO + '.cbAcceso');  

}   

function visibleLista() {
    DrdEnsanchaConMargenDcho('listado1',12);
    
    visibilidad('capaLista','V');
    
    eval (ON_RSZ);
}

function novisibleLista() {
    visibilidad('capaLista','O');
}

function focoBotonBuscar(){
         if(get_visibilidad("capaLista")){
                           document.all['btnRecuperarLote'].focus();
         }else{
                  focaliza(FORMULARIO+'.txtNumeroDocumento');
         }
}

function focoNumeroDocumento(){
         if(get_visibilidad("capaLista")){
                           document.all['btnRecuperarLote'].focus();
         }else{
                  document.all['btnBuscar'].focus();
         }
}

function muestraLista( ultima, rowset){
	var tamano = rowset.length;
	if (tamano > 0) {
		visibleLista();
		return true;
	} else {
		novisibleLista();
		focaliza(FORMULARIO+'.txtNumeroDocumento','');
		return false;
	}
	
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