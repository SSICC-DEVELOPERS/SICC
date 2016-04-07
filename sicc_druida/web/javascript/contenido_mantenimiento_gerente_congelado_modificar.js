var listaVisible;

function onLoadPag(){
  
  configurarMenuSecundario('formulario');
	focaliza('formulario.txtCodCliente','');
	ocultarLista();
	listaVisible = "false";

}

function validarBuscarOnClick()
{
  if(sicc_validaciones_generales()){
		buscarOnClick();	
	}
}

/*function armarArray(){		

	var descAuto;
	var fechaD;
	var fechaH;
	var importeFormatoDruida;
	var importeFormatoJava;

	if(get('formulario.ckDescongelacionAutomatica')=="S") {
		descAuto= true;
	}else{
		descAuto= false;
	}

	fechaD= get('formulario.txtFechaDesde');
	fechaH= get('formulario.txtFechaHasta');
	 importeFormatoDruida= get('formulario.txtImporte');
	 if (importeFormatoDruida != "" &&		importeFormatoDruida !=  null 	){
				importeFormatoJava = numeroDeFormatoSICC(importeFormatoDruida); 
	 }

	if(get('formulario.txtFechaDesde')!="")	
		fechaD= obtenerFormatoFecha(get('formulario.txtFechaDesde'));

	if(get('formulario.txtFechaHasta')!="")
		fechaH= obtenerFormatoFecha(get('formulario.txtFechaHasta'));

	var arr = [ ['oidPais', get('formulario.varPais')], 
		['oidIdioma', get('formulario.varIdioma')],                                  
		['fechaDesde', fechaD], 
		['fechaHasta', fechaH], 
		['importe',importeFormatoJava], 
		['codigoCliente', get('formulario.txtCodCliente')], 
		['descongelacion', descAuto], 
		['vigente', 'true'],
		['oidCliente', get('formulario.oidCliente')] ];
	
	
	return arr;			 
	
}						  */



function agregaBoton(style)
{
    return;
}



function modificarOnClick (){	
    var cant = listado1.numSelecc();
	if (cant == 1) {
        var oid = listado1.codSeleccionados();
		var obj = new Object();
    
		obj.oidCongelado = oid;  
		obj.codigoCliente=listado1.extraeDato(oid, 0);
		obj.fechaDesde=listado1.extraeDato(oid, 1);
		obj.fechaHasta=listado1.extraeDato(oid, 2);
		obj.importe=listado1.extraeDato(oid, 3);
		obj.descongelacionAutomatica=listado1.extraeDato(oid, 4);
		obj.oidCliente=listado1.extraeDato(oid, 5);
        
        var arrayDevuelto = mostrarModalSICC('LPMantenimientoGerenteCongelado','modificacion',obj);

		if (arrayDevuelto != null && arrayDevuelto.length == 4) {
            listado1.insertaDato(oid,1,arrayDevuelto[0]); //fecha desde
            listado1.insertaDato(oid,2,arrayDevuelto[1]); //fecha hasta
            listado1.insertaDato(oid,3,arrayDevuelto[2]); //importe
            listado1.insertaDato(oid,4,arrayDevuelto[3]); //descongelacion
        }
		focaliza('formulario.txtCodCliente');
        return true;
    } else if (cant < 1) {
         GestionarMensaje('50'); // Debe seleccionar un elemento de la lista
		 return false;
    } else if (cant > 1) {
         cdos_mostrarAlert(GestionarMensaje('240')); // Debe seleccionar un solo elemento de la lista
		 return false;
    }
}

function ontabsh_txtCodCliente(){
	focaliza('formulario.ckDescongelacionAutomatica');
}

function ontab_ckDescongelacionAutomatica(){
	focaliza('formulario.txtCodCliente');
}

function agregaBoton(style)
{
		document.all["btnModificarDiv"].style.visibility=style;
}

function buscarClienteOnClick (){
			var obj = new Object();
			var whnd = mostrarModalSICC('LPBusquedaRapidaCliente','',obj);
			if(whnd!=null){
				var oid = whnd[0];
				var cod = whnd[1];
				set("formulario.txtCodCliente", cod);
				set("formulario.codigoCliente", cod);
				set("formulario.oidCliente", oid);
			}
		}

function buscarOnClick (){
		
		 if(sicc_validaciones_generales()){
			if (get('formulario.txtCodCliente') != get('formulario.codigoCliente')){					
				set('formulario.codigoCliente', get('formulario.txtCodCliente'));
				set('formulario.oidCliente','');
			}
			
			var arr = armarArray();
			
			configurarPaginado(mipgndo, "COMBuscarGerenteCongelado",	
										"ConectorBuscarGerentesCongelados", 
										"es.indra.sicc.dtos.com.DTODatosGerenteCongelacion",arr); 						
	}
}

function onChangeCodigoCliente() {
    set('formulario.oidCliente','');
    if (get('formulario.txtCodCliente')!='') {
	    var codigo = get('formulario.txtCodCliente');
	    var longitudMax = get('formulario.hLongitudCodCliente');
	    var longitud =  codigo.length
	    set('formulario.txtCodCliente', rellenaCeros(codigo, longitudMax, longitud));
    }
}

function armarArray(){        

    var descAuto;
	var vig= true;

    if (get('formulario.tieneVigentes')=="S") {
        	if(get('formulario.ckVigentes')=="S"){
				vig= true;
			}else{
				vig= false;
			}
    }

    if(get('formulario.ckDescongelacionAutomatica')=="S") {
        descAuto= true;
    }else{
        descAuto= false;
    }

   /* var arr = [ ['oidPais', get('formulario.varPais')], 
        ['oidIdioma', get('formulario.varIdioma')],                                  
        ['fechaDesde', obtenerFormatoFecha(get('formulario.txtFechaDesde'))], 
        ['fechaHasta', obtenerFormatoFecha(get('formulario.txtFechaHasta'))], 
        ['importe', transformarImporte(get('formulario.txtImporte'))], 
        ['codigoCliente', get('formulario.txtCodCliente')], 
        ['descongelacion', descAuto], 
        ['vigente', 'true'],    
        ['oidCliente', get('formulario.oidCliente')] ];						*/
    
    var arrDatos = new Array();
	var i=0;

	arrDatos[i] = new Array('oidPais',get('formulario.varPais'));
	i++;

	arrDatos[i] = new Array('oidIdioma',get('formulario.varIdioma'));
 		
		//arrDatos[i] = new Array('oidIdioma',"1");
     i++;																																																				 

	 if (get('formulario.txtFechaDesde')!=''){
           var fechaD=obtenerFormatoFecha(get('formulario.txtFechaDesde'));
	
			arrDatos[i] = new Array('fechaDesde',fechaD);
            i++;
      }

	if (get('formulario.txtFechaHasta')!=''){
				var fechaH= obtenerFormatoFecha(get('formulario.txtFechaHasta'));
            arrDatos[i] = new Array('fechaHasta',fechaH);
            i++;
      }

	if (get('formulario.txtImporte')!=''){				
				var	 importe1 =  get('formulario.txtImporte');
				
				var importe2= numeroDeFormatoSICC(importe1); 
            
				arrDatos[i] = new Array('importe',importe2);
            i++;
     }

	if (get('formulario.txtCodCliente')!=''){
            arrDatos[i] = new Array('codigoCliente',get('formulario.txtCodCliente'));
            i++;
     }
     
	arrDatos[i] = new Array('descongelacion',descAuto);
	i++;
	
	arrDatos[i] = new Array('vigente',vig);
	i++;

	if (get('formulario.oidCliente')!=''){
		arrDatos[i] = new Array('oidCliente',get('formulario.oidCliente'));
		
  }
	
    return arrDatos;        
  }

function mostrarLista(){
    DrdEnsanchaConMargenDcho('listado1',12);
    document.all["Cplistado1"].style.visibility='visible';
    document.all["CpLin1listado1"].style.visibility='visible';
    document.all["CpLin2listado1"].style.visibility='visible';
    document.all["CpLin3listado1"].style.visibility='visible';
    document.all["CpLin4listado1"].style.visibility='visible';
    document.all["primera1Div"].style.visibility='visible';
    document.all["ret1Div"].style.visibility='visible';
    document.all["ava1Div"].style.visibility='visible';
    document.all["separaDiv"].style.visibility='visible';
	agregaBoton('visible');
    eval (ON_RSZ);
}

function ocultarLista() {
    document.all["Cplistado1"].style.visibility='hidden';
    document.all["CpLin1listado1"].style.visibility='hidden';
    document.all["CpLin2listado1" ].style.visibility='hidden';
    document.all["CpLin3listado1"].style.visibility='hidden';
    document.all["CpLin4listado1"].style.visibility='hidden';
    document.all["primera1Div"].style.visibility='hidden';
    document.all["ret1Div"].style.visibility='hidden';
    document.all["ava1Div"].style.visibility='hidden';
    document.all["separaDiv"].style.visibility='hidden';
	agregaBoton('hidden');
}

function muestraLista( ultima, rowset){                                                        
                                                                                                    
         var tamano = rowset.length;                                                           
    if (tamano > 0) {                                                                      
         mostrarLista();    
		 listaVisible = "true";
         return true;                                                                  
    } else {                                                                                 
         ocultarLista();       
		 listaVisible = "false";
         // No se ha encontrado ningún elemento con los criterios especificados
         //Control del foco                                                                     
         //focaliza(FORMULARIO + ".txtNatencion");                             
         return false;                                                                        
    }                                                                                        
}

function transformarImporte(importe){
	var index;
	var pEnt;

	index= importe.indexOf(",");
	if(index > 0)
	{ 
		pEnt= importe.substring(0,index)+ importe.substring(index+1, importe.length);	
		return pEnt;
	}
	return importe;
}


/*modificado DBLG500000800*/

function setOnTab(nombre) {

	if (nombre == "txtCodCliente") {
		focaliza('formulario.txtFechaDesde');

	} else if (nombre == "txtFechaDesde") {
		focaliza('formulario.txtFechaHasta');

	} else if (nombre == "txtFechaHasta") {
		focaliza('formulario.txtImporte');

	} else if (nombre == "txtImporte") {
		focaliza('formulario.ckDescongelacionAutomatica');

	} else if (nombre == "ckDescongelacionAutomatica") {
		focalizaBotonHTML('botonContenido','btnBuscar');

	} else if (nombre = "btnBuscar") {
		if (listaVisible == "true") {
			focalizaBotonHTML_XY("btnModificar");
		} else {
			focaliza('formulario.txtCodCliente');
		}

	} else if (nombre == "btnModificar") {
		focaliza('formulario.txtCodCliente');

	}
}

function setOnShTab(nombre) {

	if (nombre == "txtCodCliente") {
		if (listaVisible == "true") {
			focalizaBotonHTML_XY("btnModificar");
		} else {
			focalizaBotonHTML('botonContenido','btnBuscar');
		}

	} else if (nombre == "txtFechaDesde") {
		focaliza('formulario.txtCodCliente');

	} else if (nombre == "txtFechaHasta") {
		focaliza('formulario.txtFechaDesde');

	} else if (nombre == "txtImporte") {
		focaliza('formulario.txtFechaHasta');

	} else if (nombre == "ckDescongelacionAutomatica") {
		focaliza('formulario.txtImporte');

	} else if (nombre == "btnBuscar") {
		focaliza('formulario.ckDescongelacionAutomatica');

	} else if (nombre == "btnModificar") {
		focalizaBotonHTML('botonContenido','btnBuscar');
	}
}
/*modificado DBLG500000800*/
