var FORMULARIO = "Formulario"; 

function onLoadPag(){
         
         var errDescripcion = get(FORMULARIO +'.errDescripcion');
    if (errDescripcion !='') {                         
         var errCodigo = get(FORMULARIO+'.errCodigo');
         var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
    }
         //alert(1);
         
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
             
         //alert(2);

		 eval (ON_RSZ);  
         configurarMenuSecundario(FORMULARIO);

	   	 setearCombosMarcaCanal();
		 cambioMarcaCanal();
         
         //alert(3);

         focaliza(FORMULARIO+'.cbMarca');
		
		 //alert(4);	

}

function cambioMarcaCanal(){
	if (get(FORMULARIO + ".cbMarca")!=''
	&&get(FORMULARIO + ".cbCanal")!=''){
		accion(FORMULARIO + ".cbPeriodo",'.disabled=false');
		var oid = get(FORMULARIO + ".cbCanal").toString();
		var marca= get(FORMULARIO + ".cbMarca").toString();
		Formulario.hOidCanal = oid;
		Formulario.hOidMarca = marca;
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

function accionBTN_Buscar(){
         
         /*Documentation
         Este evento se desencadena al pulsar el botón "Buscar". 
         Intenta localizar registros que cumplan con los criterios de búsqueda introducidos por el usuario. 

         Validar que al menos un criterio ha sido tecleado ( No todos los campos en blanco ). 
         En caso contrario mostramos una ventana de mensaje (javascript:alert()) mostrando: 
         UICCC008 Debe seleccionar, al menos, {numero} criterios de búsqueda. Siendo numero=1. 
         */
         var idioma = get(FORMULARIO+'.idioma');
         var pais = get(FORMULARIO+'.pais');
         
         var periodo = get(FORMULARIO+'.cbPeriodo');
         var anio = get(FORMULARIO+'.txtAno');
         var mes = get(FORMULARIO+'.txtMes');
         var numero = get(FORMULARIO+'.txtNumero');
         var cliente = get(FORMULARIO+'.textCodCliente');
         var fechaDoc = get(FORMULARIO+'.textFechaDoc');
         var fechaMovimiento = get(FORMULARIO+'.textFechaMov');
         var banco = get(FORMULARIO+'.cbBanco');
         var situacion = get(FORMULARIO+'.cbSituacion');

		 var marca = get(FORMULARIO+'.cbMarca');
		 var canal = get(FORMULARIO+'.cbCanal');
                  
         var contador = 0;
         
         if (get(FORMULARIO+'.casoUso') == 'eliminar')
         btnProxy(4, 0); 

         
         if(periodo != ''){
                  contador++;
         }
         if(anio != ''){
                  contador++;
         }
         if(mes != ''){
                  contador++;
         }
         if(numero != ''){
                  contador++;
         }
         if(cliente != ''){
                  contador++;
         }
         if(fechaDoc != ''){
                  contador++;
         }
		 if(fechaMovimiento != ''){
                  contador++;
         }
         if(banco != ''){
                  contador++;
         }
         if(situacion != ''){
                  contador++;
         }
		 if(marca!=''){
                  contador++;
         }
		 if(periodo!=''){
                  contador++;
         }
         if(contador<1){
                  //mostramos el mensaje: "Debe seleccionar, al menos, 1 criterios de búsqueda" (UICCC008).
         //Codigo 1374
         cdos_mostrarAlert(GestionarMensaje('1374',1));
         focaliza(FORMULARIO+'.cbMarca');
         }else{
                  /*
                  Llamamos a configurarPaginado: 
                  //Función <<JavaScript>> del subsistema <<Paginacion>> 
                  - Llamamos a PaginacionSicc.configurarPaginadoExt(); 
                  Pasándole los parámetros siguientes: 

                  -la lista "resultados", 
                  -CCCConsultarCupon3, ConectorConsultarCupon3, 
                  -DTOConsultarCupon3 
                  */
                  configurarPaginado(mipgndo, "CCCConsultarCupon3", "ConectorConsultarCupon3","es.indra.sicc.dtos.ccc.DTOConsultarCupon3",
                                    [['oidIdioma',idioma],
                                    ['oidPais',pais],
                                    ['fechaMovBanc', fechaMovimiento] ,
                                    ['anio', anio] , 
                                    ['mes', mes],
                                    ['numero',numero],
                                    ['codigoCliente',cliente],
                                    ['fechaDoc',fechaDoc],                               
									//['oidBanco',banco],		jzd, 28/02/2008
									['oidCtaCteBria',banco],
					                ['oidMarca',marca],
									['oidPeriodo',periodo],
                                    ['oidSituacion',situacion]]);
         }
         
                  
}
function fBorrar(){
         accionBTN_Eliminar ()
}         

function accionBTN_Eliminar(){

         /*Documentation
         Construimos un DTOOIDs con los oidDetalleCuponTramiteDepuracion (oculto) de las filas seleccionadas 
         en la lista-paginable 'resultados'. 
         IdBusiness="CCCEliminarCupon3" 
         Invocamos el subsistema:Eliminación.
         */
         if (listado1.numSelecc() == 0) {
                  // "Debe seleccionar un elemento de la lista"
         GestionarMensaje('50');
         } else {
                  var oids = listado1.codSeleccionados();
             eliminarFilas(oids, "CCCEliminarCupon3", mipgndo);
             focaliza(FORMULARIO+'.cbMarca','');
                  }

}


function muestraLista( ultima, rowset){
                                  
         var tamano = rowset.length;
    if (tamano > 0) {
         visibleLista();
         //accion(FORMULARIO+'.cbEmpresa','.disabled=true');
         document.all['Consultar'].disabled = true;
         if (get(FORMULARIO+'.casoUso') == 'eliminar')
                  btnProxy(4, 1);
         return true;
   } else {
         invisibleLista();   
         btnProxy(4, 0);                   
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

function comprobarFecha(txtFecha){ 
          
         var fecha = get(FORMULARIO+'.'+txtFecha);
          
    if(fecha != ""){
         var resul = EsFechaValida(fecha,fecha, FORMULARIO,null);
         if(resul==1 || resul==2){  
                  GestionarMensaje('1006', get(FORMULARIO+'.hFormatoFechaPais')); 
                  focaliza(FORMULARIO+'.'+txtFecha);
                  return false;
         }
         }
}

function fLimpiar(){
         vaciaPeriodo();
         focaliza(FORMULARIO+'.cbMarca','');
}

function vaciaPeriodo(){
         set_combo(FORMULARIO+'.cbPeriodo',[['','']],['']);
}
function vaciaCanal(){
    set_combo(FORMULARIO+'.cbCanal',[['','']],['']);
    vaciaPeriodo();
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

function validarNumero(txtNumero){
         if(get(FORMULARIO+'.'+txtNumero) != ''){
                  validarNumerico(txtNumero);
         }
}