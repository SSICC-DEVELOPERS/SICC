
var dtoFlete;

function onLoadPag(){
		configurarMenuSecundario("formulario");
	
		var zonaUbigeo = get("formulario.hVisibleZona");
		//set("formulario.cbZona", ".disabled=true");
		dtoFlete = new Object();		
		deserializarRangosFlete();

		var ac = get("formulario.accion");

		if (zonaUbigeo == "S"){	
				accion("formulario.cbZona",".disabled=false");
				accion("formulario.txtUbigeo",".disabled=true");

		}else{
				accion("formulario.cbZona",".disabled=true");
				accion("formulario.txtUbigeo",".disabled=false");
		}		   

		if ((ac == "inserta") || (ac == "muestraInsercion")){	
			muestraValorPorDefecto();
			accion("formulario.cbSubTipoCliente",".disabled=true");
			accion("formulario.cbTipoClasificacion",".disabled=true");
			accion("formulario.cbClasificacion",".disabled=true");
			deshabilitarHabilitarBoton('botonContenido','btnDetalle','D');
			focaliza("formulario.cbMarca");
		}

	   if (ac== "muestraModificacion"){
			focaliza("formulario.txtDescripcion");
			accion("formulario.cbMarca",".disabled=true");
			accion("formulario.cbCanal",".disabled=true");
			accion("formulario.cbTipoDespacho",".disabled=true");		
			if (get("formulario.txtMontoFijo")=='0'){
				accion('formulario.txtMontoFijo', '.disabled=true');
			} else {
				deshabilitarHabilitarBoton('botonContenido','btnDetalle','D');				
			}
	   }

	   if(ac == "detalle"){	
		seteaValores();
		deshabilitaTodo();
		if (get("formulario.txtMontoFijo")=='0'){			
		} else {
			deshabilitarHabilitarBoton('botonContenido','btnDetalle','D');
		}
	   }

	   if(ac == "modificar"){	
			accion("formulario.cbMarca",".disabled=true");
			accion("formulario.cbCanal",".disabled=true");
			accion("formulario.cbZona",".disabled=true");
			accion("formulario.txtUbigeo",".disabled=true");
			accion("formulario.cbTipoDespacho",".disabled=true");
			focaliza("formulario.txtDescripcion");
			seteaValoresModificar();
			onChangeTipoCliente();
			if (get("formulario.txtMontoFijo")=='0'){
				accion('formulario.txtMontoFijo', '.disabled=true');
			} else {
				deshabilitarHabilitarBoton('botonContenido','btnDetalle','D');
			}
	   }

	   if (get('formulario.errDescripcion')!='') {
			 var wnd = fMostrarMensajeError(get('formulario.errCodigo'), get('formulario.errDescripcion'));
		}			
}

var form = 'formulario.';
function muestraValorPorDefecto(){			
		set(form + 'cbMarca', [get(form + 'marca')]);
		set(form + 'cbCanal', [get(form + 'canal')]);	
		set(form + 'esCargaInicial', 'SI');
		CanalOnChange();	
		set(form + 'cbZona', [get(form + 'zona')]);
		set(form + 'txtUbigeo', [get(form + 'OIDUbigeo')]);
}

function muestraValorPorDefectoBorrar(){
		set(form + 'cbMarca', [get(form + 'marca')]);
		set(form + 'cbCanal', [get(form + 'canal')]);
		CanalOnChange();
}		

function seteaValores(){

	btnProxy(3, 0);
	btnProxy(4, 0);
	btnProxy(5, 0);
	btnProxy(7, 0);
	btnProxy(8, 0);
	btnProxy(9, 0);
	btnProxy(10, 1);
    var aCombo = new Array(new Array("","")); 
	var z =get("formulario.zona");	
	set_combo("formulario.cbZona", new Array(new Array("z",z)), []);
	
	var m =  get("formulario.marca2");
	set_combo("formulario.cbMarca", new Array(new Array("m",m)), []);
	
	set(form + 'txtUbigeo', [get(form + 'OIDUbigeo')]);
	
	var c= get("formulario.canal2");	
	set_combo("formulario.cbCanal", new Array(new Array("c",c)), []);
	
    var d =  get("formulario.TipoDespacho");	
	set_combo("formulario.cbTipoDespacho", new Array(new Array("d",d)), []);
	
	var tc= get("formulario.TipoCliente");
	set_combo("formulario.cbTipoCliente", new Array(new Array("tc",tc)), []);

	var sb = get("formulario.SubTipoCliente");
	set_combo("formulario.cbSubTipoCliente", new Array(new Array("sb",sb)), []);

	var tcla =  get("formulario.TipoClasificacion");
	set_combo("formulario.cbTipoClasificacion", new Array(new Array("tcla",tcla)), []);
	
	var cla = get("formulario.Clasificacion");
	set_combo("formulario.cbClasificacion", new Array(new Array("cla",cla)), []);

}


function seteaValoresModificar(){
	var aCombo = new Array(new Array("","")); 
	var z =get("formulario.zona");		
	var idioma = get("formulario.hIdioma");
	
	set_combo("formulario.cbZona", new Array(new Array("z",z)), []);
	
	var m =  get("formulario.marca2");
	set_combo("formulario.cbMarca", new Array(new Array("m",m)), []);
	
	var c= get("formulario.canal2");	
	set_combo("formulario.cbCanal", new Array(new Array("c",c)), []);
	
    var d =  get("formulario.TipoDespacho");	
	set_combo("formulario.cbTipoDespacho", new Array(new Array("d",d)), []);	

    var tc = get("formulario.OIDTipoCliente"); // oid
	var tCl= get("formulario.TipoCliente"); //descripcion
			
	var idioma = get("formulario.hIdioma");	
	var arr = new Array();   
	var oidd = get("formulario.OIDTipoCliente");
	 
	arr[arr.length] = new Array("oid", oidd +"");
	arr[arr.length] = new Array("oidIdioma", idioma +"");
	
	var a = new Array(get("formulario.OIDTipoCliente"));

	set("formulario.cbTipoCliente", a);	

	recargaCombo('formulario.cbSubTipoCliente', 'MAEobtenerSubtipos', 'es.indra.sicc.util.DTOOID', arr, 'cargaSubTipoCliente(datos);' );	
}


function cargaSubTipoCliente(datos){

	set_combo("formulario.cbSubTipoCliente", agregarBlanco(datos));
	iSeleccionado = new Array(get("formulario.subModi")); 	
	set("formulario.cbSubTipoCliente", iSeleccionado);

	if ((get("formulario.cbSubTipoCliente")) !=""){	
		recargaCombo('formulario.cbTipoClasificacion', 'MAEobtenerTipoClasificacion', 'es.indra.sicc.util.DTOOID', makeParameter('oid',get('formulario.cbSubTipoCliente')), 'cargaTipoClasificacion(datos);' );
	}
	else{
			set_combo("formulario.cbSubTipoCliente", arrayVacio());
			set_combo("formulario.cbClasificacion", arrayVacio());
			set_combo("formulario.cbClasificacion", arrayVacio());
			accion('formulario.cbSubTipoCliente', '.disabled=true')
			accion('formulario.cbTipoClasificacion', '.disabled=true');
			accion('formulario.cbClasificacion', '.disabled=true');
	}
} 

function cargaTipoClasificacion(datos){  
		set_combo("formulario.cbTipoClasificacion", agregarBlanco(datos));

		iSeleccionado = new Array(get("formulario.tipClas"));
		set("formulario.cbTipoClasificacion", iSeleccionado);

		if (iSeleccionado !=""){
				recargaCombo('formulario.cbClasificacion', 'MAEobtenerClasificacionesPorTipo', 'es.indra.sicc.util.DTOOID', makeParameter('oid', get("formulario.tipClas")), 'cargaClasificacion(datos);' ); 
		}else{
				//alert('desabilita los combos');
				set_combo("formulario.cbClasificacion", arrayVacio() );
				accion('formulario.cbClasificacion', '.disabled=true');
		}
}

function cargaClasificacion(datos){  

		set_combo("formulario.cbClasificacion", agregarBlanco(datos));

		iSeleccionado = new Array(get("formulario.clsi")); 
		set("formulario.cbClasificacion", iSeleccionado);

		if(get('formulario.accion')=='detalle'){
			accion('formulario.cbClasificacion', '.disabled=true');
		} else {
			focaliza("formulario.txtDescripcion");
		}

}

function agregarBlanco(datos){  
	    datosBlanco = new Array();

		datosBlanco[0]= new Array("","");

		for(var i=0; i< datos.length; i++){		
              datosBlanco[i+1] = new Array(datos[i][0], datos[i][1]);             
		}
		return datosBlanco;
}


 function makeParameter(nombre, oid){
       var array = new Array();
       var i=0;
       array[i] = new Array('oidPais', get('formulario.hPais') );
       i++;
       array[i] = new Array('oidIdioma', get('formulario.hIdioma') );
       i++;
       array[i] = new Array(nombre,oid);              
       return array;
}		


function setearSubtipoClientes(datos){
	set_combo("formulario.cbSubTipoCliente",datos);	
	var sb = get("formulario.SubTipoCliente");
	set("formulario.cbSubTipoCliente", new Array(sb));
}


function arrayVacio(){  
		var array = new Array();             
        array[0] = new Array('','');
		return array;
}

function deshabilitaTodo(){
	accion("formulario.cbMarca", ".disabled=true");
	accion("formulario.cbCanal", ".disabled=true");
	accion("formulario.cbZona", ".disabled=true");
	accion("formulario.txtUbigeo", ".disabled=true");	
	accion("formulario.cbTipoDespacho", ".disabled=true");
	accion("formulario.cbTipoCliente", ".disabled=true");
	accion("formulario.txtDescripcion", ".disabled=true");
	accion("formulario.txtMontoFijo", ".disabled=true");
	accion("formulario.txtTasa", ".disabled=true");
	accion("formulario.txtFleteMin", ".disabled=true");
	accion("formulario.txtFleteMax", ".disabled=true");
	accion("formulario.txtContraEntrega", ".disabled=true");
	accion("formulario.cbTipoCliente", ".disabled=true");
	accion("formulario.cbSubTipoCliente",".disabled=true");
	accion("formulario.cbTipoClasificacion",".disabled=true");
	accion("formulario.cbClasificacion",".disabled=true");
}


var form = 'formulario.';
function muestraValores(){
	set(form + 'cbMarca', [get(form + 'marca')]);
	set(form + 'cbCanal', [get(form + 'canal')]);
	CanalOnChange();
}

function MarcaOnChange(){
	document.selection.empty();
	var zonaUbigeo = get("formulario.hVisibleZona");
	var pais = get("formulario.hPais");

	var canal= get("formulario.cbCanal");
	var marca= get("formulario.cbMarca");
	
	if (zonaUbigeo == "S"){	
			accion("formulario.cbZona",".disabled=false");
			accion("formulario.txtUbigeo",".disabled=true");
			
			var arr = new Array();
			arr[arr.length] = new Array("oidPais", pais+"");
			arr[arr.length] = new Array("oidMarca", get("formulario.cbMarca")+"");
			arr[arr.length] = new Array("oidCanal", get("formulario.cbCanal")+"");

		if((canal != "") && (marca != "")){			
			recargaCombo("formulario.cbZona", 'ZONRecargaZonas', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa',arr);
		}
		else{
				var aCombo = new Array(new Array("",""));
				set_combo("formulario.cbZona",aCombo,[]);
				accion("formulario.cbZona",".disabled=true");
				set("formulario.cbCanal","");

		}
	}
	else{
				accion("formulario.cbZona",".disabled=true");
				accion("formulario.txtUbigeo",".disabled=false");
	}
}

function CanalOnChange(){
	var zonaUbigeo = get("formulario.hVisibleZona");
	var pais = get("formulario.hPais");


	if (zonaUbigeo == "S"){	
			accion("formulario.cbZona",".disabled=false");
			accion("formulario.txtUbigeo",".disabled=true");
			
			var arr = new Array();
			arr[arr.length] = new Array("oidPais", pais +"");
			arr[arr.length] = new Array("oidMarca", get("formulario.cbMarca")+"");
			arr[arr.length] = new Array("oidCanal", get("formulario.cbCanal")+"");		
			if ((get("formulario.cbMarca") !="") && (get("formulario.cbCanal") !="")){				
				recargaCombo("formulario.cbZona", 'ZONRecargaZonas', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa',arr, 'setearZona(datos)');
			}else{
					set("formulario.cbZona", ".disabled=true");
			}			
			focaliza("formulario.cbMarca");
	 }
	 else {
			 accion("formulario.txtUbigeo",".disabled=false");
	 }
}


function setearZona(datos){	
	seteo = cargaArray(datos);
	set_combo(form + 'cbZona', seteo);
	if( get(form + 'esCargaInicial') == 'SI' ){
			set(form + 'cbZona', [get(form + 'zona')]);		
	}else{
			set(form + 'cbZona', ['']);
			set_combo(form + 'cbZona', ['','']);
	}	
}

function cargaArray(datos){
		var seteo = new Array(datos.length + 1);
		seteo[0] = ['' , '']
		for(i = 0; i < datos.length; i++){
			seteo[i+1] = [ datos[i][0], datos[i][1] ]
		}
		return seteo;
}

function onChangeTipoCliente(){

	   var idioma = get("formulario.hIdioma");	
	   var arr = new Array();   
	   var oidd = get("formulario.cbTipoCliente");

	   
	   arr[arr.length] = new Array("oid", get("formulario.cbTipoCliente")+"");
	   arr[arr.length] = new Array("oidIdioma", idioma +"");

	   if (oidd != ""){
				recargaCombo("formulario.cbSubTipoCliente", 'MAEobtenerSubtipos', 'es.indra.sicc.util.DTOOID',arr);
				accion("formulario.cbSubTipoCliente",".disabled=false");				
				accion('formulario.cbTipoClasificacion', '.disabled=true');
				accion('formulario.cbClasificacion', '.disabled=true');
				
				set_combo("formulario.cbTipoClasificacion", arrayVacio());
				set_combo("formulario.cbClasificacion", arrayVacio());			
		}else{

				set_combo("formulario.cbSubTipoCliente", arrayVacio() );
				set_combo("formulario.cbTipoClasificacion", arrayVacio());
			    set_combo("formulario.cbClasificacion", arrayVacio());
				accion('formulario.cbSubTipoCliente', '.disabled=true');
				accion('formulario.cbTipoClasificacion', '.disabled=true');
				accion('formulario.cbClasificacion', '.disabled=true');
		}	
}

function cerrarVentana(){
		window.close();
}		


function fVolver(){	
		window.close();
}

function onChangeSubtipoCliente(){

	   var idioma = get("formulario.hIdioma");	
	   
	   var arr = new Array();
	   var sub = get("formulario.cbSubTipoCliente");	
	  
	   arr[arr.length] = new Array("oid", sub +"");
	   arr[arr.length] = new Array("oidIdioma", idioma +"");

	   if (sub !=""){	  
			   recargaCombo("formulario.cbTipoClasificacion", 'MAEobtenerTipoClasificacion', 'es.indra.sicc.util.DTOOID',arr);
			   accion("formulario.cbTipoClasificacion",".disabled=false");
	  }else{
				set_combo("formulario.cbTipoClasificacion", arrayVacio());
				set_combo("formulario.cbClasificacion", arrayVacio() );

				accion('formulario.cbTipoClasificacion', '.disabled=true');
				accion('formulario.cbClasificacion', '.disabled=true');	   
	  }
}


function onChangeTipoClasificacion(){

	   var idioma = get("formulario.hIdioma");	
	   var clasi =  get("formulario.cbTipoClasificacion");
	   
	   var arr = new Array();
	   arr[arr.length] = new Array("oidIdioma",idioma +"");
	   arr[arr.length] = new Array("oid", get("formulario.cbTipoClasificacion")+"");
	
	   if(clasi !=""){		
				recargaCombo('formulario.cbClasificacion', 'MAEobtenerClasificacionesPorTipo', 'es.indra.sicc.util.DTOOID',arr);
				accion("formulario.cbClasificacion",".disabled=false");	
		}else{
				set_combo("formulario.cbClasificacion", arrayVacio());
				accion('formulario.cbClasificacion', '.disabled=true');
		}
}

function setearSubtipo(datos){
	seteo = cargaArray(datos);
      set_combo('formulario.cbZona',datos, []);				   
      set('formulario.cbZona', [get('formulario.zona')]); 
      accion('formulario.cbZona', '.disabled=false');
}

function fGuardar(){
	var sepMiles = get("formulario.hSepMiles");
	var sepDec = get("formulario.hSepDec");	
	var marca =  get("formulario.cbMarca");	
	var canal = get("formulario.cbCanal");	
	var tipoDespacho = get("formulario.cbTipoDespacho");
	var desc = get("formulario.txtDescripcion");
	set("formulario.descrip", desc);
	var accion = get("formulario.accion");
	var zona = get("formulario.cbZona");

	var ubigeo = get("formulario.txtUbigeo");	
	var tipoCliente = get("formulario.cbTipoCliente");
	var montof =  get("formulario.txtMontoFijo");
	var TipoClas = get("formulario.cbTipoClasificacion");
	var SubC = get("formulario.cbSubTipoCliente");
	var Clas = get("formulario.cbClasificacion");

	////----------------------------------------------------------------/////
	var formatoDef = get("formulario.hFormatoDef");

	
	if (sicc_validaciones_generales()){
				var tasa = get("formulario.txtTasa");							
				var fleteMin = get("formulario.txtFleteMin");							
				var fleteMax = get("formulario.txtFleteMax");							
				var contraEntrega = get("formulario.txtContraEntrega");	

				if ((fleteMin !="") && (fleteMax !="")){
					   if(numeroDeFormatoSICC(fleteMin, formatoDef) > numeroDeFormatoSICC(fleteMax, formatoDef)){
							GestionarMensaje('1334', null, null, null);
							focaliza("formulario.txtFleteMax");
							return;
					   }
				}
					
				set("formulario.tas", tasa);		
				set("formulario.OIDUbigeo", ubigeo);
				set("formulario.OIDTipoCliente",tipoCliente);											
				set("formulario.OIDSubTipoCliente", SubC);									
				set("formulario.OIDTipoClasificacion", TipoClas);											
				set("formulario.OIDClasificacion", Clas);																			
				set("formulario.fmin", fleteMin);
				set("formulario.fmax", fleteMax);											
				set("formulario.contraE", contraEntrega);
				set("formulario.montoF", montof);
				set("formulario.hSDetalleFlete", serializarRangosFlete());
											
				set("formulario.conectorAction","LPMantieneFlete");
				set("formulario.accion","guardar");						
				enviaSICC("formulario");  
		}			
}

function cerrarVentana(){
		window.returnValue = true;
}


function errorAlGuardar(){
		if( get('formulario.accion') == 'modificar')
			focaliza('formulario.txtDescripcion');	
		else
			{ 
				if (get("formulario.errCodigo") == "10033"){
					focaliza('formulario.txtUbigeo');
				}else{	
					focaliza('formulario.cbMarca');	
				}
			}	
					
}


function borrarTodo(){
		
		set("formulario.txtMontoFijo", "");
		set("formulario.txtZona", "");
		set("formulario.txtTasa", "");
		set("formulario.txtFleteMin", "");
		set("formulario.txtFleteMax", "");
		set("formulario.txtContraEntrega", "");
		set("formulario.txtDescripcion", "");
		set("formulario.txtUbigeo","");
		limpiaI18N("formulario", 1);
		set('formulario.cbTipoCliente', arrayVacio());
		set_combo('formulario.cbSubTipoCliente', arrayVacio());
		set_combo('formulario.cbTipoClasificacion', arrayVacio());
		set_combo('formulario.cbClasificacion',arrayVacio());
		accion("formulario.cbSubTipoCliente",".disabled=true");
		accion("formulario.cbTipoClasificacion",".disabled=true");
		accion("formulario.cbClasificacion",".disabled=true")

		muestraValorPorDefectoBorrar();
		
		set('formulario.cbTipoDespacho',arrayVacio());
		focaliza("formulario.cbMarca");	
		cerrarVentana();	
}

function fLimpiar(){

	var ac = get("formulario.accion");
	var zonaUbigeo = get("formulario.hVisibleZona")
	set("formulario.txtMontoFijo", "");
	set("formulario.txtZona", "");
	set("formulario.txtTasa", "");
	set("formulario.txtFleteMin", "");
	set("formulario.txtFleteMax", "");
	set("formulario.txtContraEntrega", "");
	set("formulario.txtDescripcion", "");
	limpiaI18N("formulario", 1);

	var aCombo = new Array(new Array("",""));

	set_combo("formulario.cbSubTipoCliente",aCombo,[]);	
	set_combo("formulario.cbTipoClasificacion",aCombo,[]);	
	set_combo("formulario.cbClasificacion",aCombo,[]);
	accion("formulario.cbSubTipoCliente",".disabled=true");
	accion("formulario.cbTipoClasificacion",".disabled=true");
	accion("formulario.cbClasificacion",".disabled=true")

	set("formulario.txtUbigueo", "");
	
	
	if ((ac == "inserta") || (ac == "muestraInsercion")){
		muestraValorPorDefecto();
		focaliza("formulario.cbMarca");
		accion("formulario.cbSubTipoCliente",".disabled=true");
		accion("formulario.cbTipoClasificacion",".disabled=true");
		accion("formulario.cbClasificacion",".disabled=true");

		accion('formulario.txtMontoFijo', '.disabled=false');
		deshabilitarHabilitarBoton('botonContenido','btnDetalle','D');
		dtoFlete = new Object();
	}
 
    if ((ac == 'modificacion') ||(ac == 'modificar')){			
			focaliza("formulario.txtDescripcion");	
			accion("formulario.cbSubTipoCliente",".disabled=true");
			accion("formulario.cbTipoClasificacion",".disabled=true");
			accion("formulario.cbClasificacion",".disabled=true");
			accion('formulario.txtMontoFijo', '.disabled=false');
			deshabilitarHabilitarBoton('botonContenido','btnDetalle','D');
			dtoFlete = new Object();		
	}
}


function focalizaShTab(campo){  
		if(campo==1){
			if( cbClasificacion.disabled == false ){
				focaliza("formulario.cbClasificacion");
			}else if( cbTipoClasificacion.disabled == false ){
				focaliza("formulario.cbTipoClasificacion");
			}else if( cbSubTipoCliente.disabled == false ){
				focaliza("formulario.cbSubTipoCliente");
			}else{
				focaliza("formulario.cbTipoCliente");
			}
		}if(campo==2){
			if(get('formulario.casoDeUso')=='insertar'){
			  focaliza("formulario.cbTipoDespacho");
			}else if(get('formulario.casoDeUso')=='modificar'){
				focalizaShTab(1);
			}
		}
}

function focalizaTab(campo){  

		if(campo==1){
			if(cbSubTipoCliente.disabled == false )
				focaliza("formulario.cbSubTipoCliente");
			else
				primerCampo();
		} else if(campo==2){
			if(cbTipoClasificacion.disabled == false )
				focaliza("formulario.cbTipoClasificacion");
			else
				primerCampo();
		}else if(campo==3){
			if( cbClasificacion.disabled == false )
				focaliza("formulario.cbClasificacion");
			else
				primerCampo();
		}else if(campo==4){
			primerCampo();
		}
}


function primerCampo(){  
		if(get('formulario.casoDeUso')=='insertar'){
			focaliza("formulario.cbMarca");
		}else if(get('formulario.casoDeUso')=='modificar'){
			focaliza("formulario.txtDescripcion");
		}
}

function detalle(){

	var parametros = new Object();     
	parametros.dtoFlete = dtoFlete;
	parametros.casoDeUso = get('formulario.casoDeUso');
	parametros.accion = get('formulario.accion');
	
	var an = screen.availWidth;
	var al = screen.availHeight;

	var res = mostrarModalSICC("LPMantieneFlete", "detalleFlete", parametros, 600, 500);

	if (dtoFlete.rangosFlete!=null&&dtoFlete.rangosFlete.length!=null&&dtoFlete.rangosFlete.length!=0) {
		var lon = new Number(dtoFlete.rangosFlete.length);
		for (var i=0;i<lon;i++){
			if (dtoFlete.rangosFlete[i].guardado=='no') {
				dtoFlete.rangosFlete = miSplice(dtoFlete.rangosFlete,i);
				i--;
				lon--;
			}
		}
		lon = new Number(dtoFlete.rangosFlete.length);
		var hayRangos = false;
		for (var i=0;i<lon;i++){
			if (dtoFlete.rangosFlete[i].aEliminar!='si') {
				hayRangos = true;
			}
		}
		if (hayRangos) {
			accion('formulario.txtMontoFijo', '.disabled=true');
		} else {
			accion('formulario.txtMontoFijo', '.disabled=false');
		}
	} else {
		accion('formulario.txtMontoFijo', '.disabled=false');
	}

	focaliza('formulario.cbTipoCliente');
}
function deserializarRangosFlete(){
		var rangosFlete = get('formulario.hSDetalleFlete');
		rangosFlete = rangosFlete.split("#");

		for (var i=0;i<(rangosFlete.length-1);i++) {
				var rangoFlete = rangosFlete[i].split("&");
				if (rangoFlete.length!=0) {
					var dtoRangoFlete = new Object();
					for (var j=0;j<rangoFlete.length;j++) {
								var propVal = rangoFlete[j].split("¿");
								eval("dtoRangoFlete."+propVal[0]+"="+propVal[1]);							
					}
					agregarRangoFlete(dtoRangoFlete);
				}
		}

}

function chngMontoFijo() {
	if (get("formulario.txtMontoFijo")==0) {
		deshabilitarHabilitarBoton('botonContenido','btnDetalle','A');
	} else {
		deshabilitarHabilitarBoton('botonContenido','btnDetalle','D');
	}
}