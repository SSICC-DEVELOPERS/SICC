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
    set('formulario.txtCodCliente', completaCampo('txtCodCliente', '0') );
}

/*  Completa el campo cuyo 'nombre' (atributo Druida del tag CTEXTO) se indique,
 *  repitiendo el caracter que se pasa como parametro (pad) hasta alcanzar el tope 
 *  del campo en cuestión (indicado en el atributo 'max' del tag CTEXTO).
 *  
 *  @param: el nombre que identifica a un campo de texto de la página (nombreCampo)
 *  @param: el caracter con que se quiere completar el contenido del campo (pad)
 *  @return: un string con el texto para cargarle al campo.
 *  
 *  @author: eiraola
 *  @date: 06/03/2006
 *  
 */

function completaCampo(nombreCampo, pad) {
    var obj = document.getElementById(nombreCampo);
    var cantidadMaxima = 11;// Lo ideal sería asignar la capacidad del campo: obj.maxLength;

    if ( obj.value.length != '0' ) { // El campo debe tener algún valor para que lo completemos
         while(obj.value.length < cantidadMaxima) {
             obj.value= pad + obj.value;
         }
    }
    return obj.value;
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
         return true;                                                                  
    } else {                                                                                 
         ocultarLista();                                                              
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
