
var FORMULARIO = 'frmCapturarCupon';

function onLoadPag(){
			
	var errDescripcion = get(FORMULARIO +'.errDescripcion');
    	if (errDescripcion !='') {                         
        	var errCodigo = get(FORMULARIO+'.errCodigo');
         	var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
    	}

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
	document.all["cancelarDiv"].style.visibility='';
	eval (ON_RSZ);  
	
   	setearCombosMarcaCanal();
	cambioMarcaCanal();
	window.setTimeout("setearCombosPeriodo()", 2800);

	configurarMenuSecundario(FORMULARIO);     
	focaliza(FORMULARIO+'.textAno');
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

function accionBTN_BuscarCliente(){
     
    var objParams = new Object();
    var cliente = mostrarModalSICC('LPBusquedaRapidaCliente', '', objParams, null, null);          

    if(typeof cliente!='undefined') {
         var codigoClienteHasta = cliente[1];
         set(FORMULARIO+'.textCodCliente',codigoClienteHasta);
    }
}


function textCodClienteOnBlur() {
	var codigoCliente = get(FORMULARIO+'.textCodCliente').toString();
    	if (codigoCliente != '') {
    		var longitudCodigoCliente = get(FORMULARIO+'.numDigitosCodigoCliente').toString();
        	var longitud = codigoCliente.length;
        	set(FORMULARIO+'.textCodCliente',rellenaCeros(codigoCliente,longitudCodigoCliente,longitud))
    }
}


function vaciaCanal(){
           set_combo(FORMULARIO+'.cbCanal',[['','']],['']);
}

function accionBTN_Buscar(){
		
	 var idioma = get(FORMULARIO +'.idioma');
         var pais = get(FORMULARIO +'.pais');		
			
	 var ano = get(FORMULARIO+'.textAno');
         var mes = get(FORMULARIO+'.textMes');
         var numero = get(FORMULARIO+'.textNumero');
         var codCliente = get(FORMULARIO+'.textCodCliente');
         var fechaDoc = get(FORMULARIO+'.textFechaDoc');
         var fechaMovimiento = get(FORMULARIO+'.textFechaMov');
         var banco = get(FORMULARIO+'.cbBanco');
         var situacion = get(FORMULARIO+'.cbSituacion');         

		 var marca = get(FORMULARIO+'.cbMarca');         
		 var periodo = get(FORMULARIO+'.cbPeriodo');         

         var contador = 0; 
         //Comprobamos si se han seleccionado al menos dos criterios de busqueda
         if(ano!=''){
                  contador++;
         }
         if(mes!=''){
                  contador++;
         }
         if(numero!=''){
                  contador++;
         }
         if(codCliente!=''){
                  contador++;
         }
         if(fechaDoc!=''){
                  contador++;
         }
         if(fechaMovimiento!=''){
                  contador++;
         }
         if(banco!=''){
                  contador++;
         }
         if(situacion!=''){
                  contador++;
         }
		 if(marca!=''){
                  contador++;
         }
		 if(periodo!=''){
                  contador++;
         }
         if(contador<2){
         	//mostramos el mensaje: "Debe seleccionar, al menos, 2 criterios de búsqueda" (UICCC008).
                //Codigo 1374
                cdos_mostrarAlert(GestionarMensaje('1374',2));
                focaliza(FORMULARIO+'.textAno');
         }else{
         	/*
		*	Pasándole los parámetros siguientes: 
		*	-idBusiness="CCCConsultarParaCancelarCupon3" 
		*	-la lista "resultados", 
		*	-ConectorConsultarCupon3, 
		*	-DTOCancelarCupon3 
		*
		*/
                
                configurarPaginado(mipgndo, 'CCCConsultarParaCancelarCupon3', 'ConectorConsultarParaCancelarCupon3', 
                                   'es.indra.sicc.dtos.ccc.DTOCancelarCupon3', 
                                    [['oidIdioma',idioma],
                                    ['oidPais',pais],
                                    ['fechaMovBanc', fechaMovimiento] ,
                                    ['anio', ano] , 
                                    ['mes', mes],
                                    ['numero',numero],
                                    ['codigoCliente',codCliente],
                                    ['fechaDoc',fechaDoc],                               
                                    //['oidBanco',banco],		jzd, 28/02/2008
                    				['oidCtaCteBria',banco],
					                ['oidMarca',marca],
									['oidPeriodo',periodo],
                                    ['oidSituacion',situacion]]);
        }
}

function  accionBTN_Cancelar(){
	 if (listado1.numSelecc() == 0) {
                  // "Debe seleccionar un elemento de la lista"
                  GestionarMensaje('50');
         } else {
                  var codSeleccion = new String(listado1.codSeleccionados());
                  set(FORMULARIO+'.codSeleccion', codSeleccion);
                  set(FORMULARIO+'.accion', 'Cancelar');
                  set(FORMULARIO+'.conectorAction', 'LPCancelarCupon3');
                  enviaSICC(FORMULARIO);

                  //var seleccion = codSeleccion.split(',');
	}
}

function muestraLista(ultima, rowset) {
           var tamano = rowset.length;
           if (tamano > 0) {
                      visibleLista();
                      return true;
           } else {
                      invisibleLista();
                      focaliza(FORMULARIO+'.textAno','');
                      return false;
           }
}

function visibleLista(){
           
	if (!get_visibilidad('capaLista')){
    	visibilidad('capaLista','V');
    }
}

function invisibleLista() {
           
    if (get_visibilidad('capaLista')){
    	visibilidad('capaLista','O');
    }
}  

function fLimpiar() {
         focaliza(FORMULARIO+'.textAno');	
}

function comprobarFecha(textFecha){ 
	var fecha = get(FORMULARIO+'.'+textFecha);
          
    	if(fecha != ""){
        	var resul = EsFechaValida(fecha,fecha, FORMULARIO,null);
         	if(resul==1 || resul==2){  
                	GestionarMensaje('1006', get(FORMULARIO+'.hFormatoFechaPais')); 
                  	focaliza(FORMULARIO+'.'+textFecha);
                  	return false;
         	}
         }
}

function validarMes(txtmes){
	var mes = get(FORMULARIO+'.'+txtmes);
	if(mes != ''){
		var num = validarNumerico(txtmes);
		if(num!=false){
			if( mes <= 0 || mes > 12){
				//mostramos el mensaje: "El mes introducido no es correcto"
				GestionarMensaje('1368');
				focaliza(FORMULARIO+'.'+txtmes);
			}
		}
	}
}

function validarAnio(txtanio){
         if(get(FORMULARIO+'.'+txtanio) != ''){
                  validarNumerico(txtanio);
         }
}

function validarNumerico(texto){                                             
         var num = get(FORMULARIO+'.'+texto); 
         if(num != ""){
                  var val = allTrim(num);                  
         //Como no nos interesa validar el número de dígitos que tiene el 
         //entero ponemos uno suficientemente grande. 
                  if ((ValidaInt(val.toString(),10000, 0)!="OK")||(val.toString() < 0)) {
                           GestionarMensaje('747', null, null, null);
                      focaliza(FORMULARIO+'.'+texto);
                      return false;
                  }
         }                                             
} 

function allTrim(sStr){ 
            return rTrim(lTrim(sStr)); 
}

function lTrim(sStr){ 
            while (sStr.charAt(0) == " "){
                         sStr = sStr.substr(1, sStr.length - 1); 
            }
            return sStr; 
}

function rTrim(sStr){ 
            while (sStr.charAt(sStr.length - 1) == " ") {
                         sStr = sStr.substr(0, sStr.length - 1); 
            }
            return sStr; 
}  

function focalizaBuscar(){
	   if (get_visibilidad("capaLista")){
                           document.all['cancelar'].focus();
                  }else{	                           
                           focaliza(FORMULARIO+'.textAno');		
                  }	
}

function onshtabTextAno(){
	 if (get_visibilidad("capaLista")){
                           document.all['cancelar'].focus();
                  }else{	                           
                           document.all['btnBuscar'].focus();		
                  }		
}

function ontabCancelar(){
	focaliza(FORMULARIO+'.textAno');
}

function onshtabCancelar(){
	document.all['btnBuscar'].focus();
}


function confirmacionCorrecta() {
                  fLimpiarGenericoSICC();
                  fLimpiar();
                  invisibleLista();
}
         
function validarNumero(txtNumero){
         if(get(FORMULARIO+'.'+txtNumero) != ''){
                  validarNumerico(txtNumero);
         }
}