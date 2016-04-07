
var borroUltimos = false;

function onLoadPag(){
    configurarMenuSecundario('formulario');
    focaliza('formulario.txtCodCliente','');
    ocultarLista();

}

/*function armarArray(){        

    var descAuto;
    
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
        ['oidCliente', get('formulario.oidCliente')] ];	*   /					
    
    var arrDatos = new Array();
      var i=0;
	
		arrDatos[i] = new Array('oidPais',get('formulario.varPais'));
      i++;

		arrDatos[i] = new Array('oidIdioma',get('formulario.varIdioma'));
 		
		//arrDatos[i] = new Array('oidIdioma',"1");
      i++;																																																				 

		if (get('formulario.txtFechaDesde')!=''){
            arrDatos[i] = new Array('fechaDesde',get('formulario.txtFechaDesde'));
            i++;
      }

		if (get('formulario.txtFechaHasta')!=''){
            arrDatos[i] = new Array('fechaHasta',get('formulario.txtFechaHasta'));
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
    	arrDatos[i] = new Array('vigente','true');
      i++;

		if (get('formulario.oidCliente')!=''){
            arrDatos[i] = new Array('oidCliente',get('formulario.oidCliente'));
            
      }
		
    return arrDatos;        
    
}		*/
/*function agregaBoton(style)
{
    return;
}				  */

 /*function llenarDigitos(){  

    var txt  = document.getElementsByName("txtCodCliente").item(0);
    
    if(get('formulario.txtCodCliente') != ''){
        
        txt.value = get('formulario.txtCodCliente');
        var uno = txt.value;            
        var primero = uno;
             
        for (var i= 0; i<primero.length; i++){
            var a = primero.charAt(i);                  
                 
            if (a == "%"){                   
                return false;
            }
        }           
                 
        var valor = new Array(10);
        var valoraux = new Array();
                   
        valor = txt.value;
        var con = Math.abs(11);
        var dif = con-valor.length;
             
        if(valor.length == con){    return;     }
              
        if(valor.length < con){
            
            for(var i=0; i<dif;i++){
                valoraux= valoraux + '0';
            }                    
                  
            set('formulario.txtCodCliente', valoraux + uno );
        
        }else{
            txt.value= "";
        }
    }

}		  */


function ontabsh_txtCodCliente(){
    focaliza('formulario.ckDescongelacionAutomatica');
}

function ontab_ckDescongelacionAutomatica(){
    focaliza('formulario.txtCodCliente');
}

function fBorrar(){
   
		 var seleccionados = listado1.codSeleccionados();
		 var cantSeleccionados = seleccionados.length;

		 if (cantSeleccionados > 0) {

						  if (listado1.datos.length == cantSeleccionados) { // Voy a eliminar todos los de mi lista
								borroUltimos = true;
						  } else {
								borroUltimos = false;
						  }
						  eliminarFilas(seleccionados, "COMEliminarGerentesCongelados", mipgndo);
						  return true;
					
		} else {
				  GestionarMensaje("4", null, null, null);
				  return false;
		}
	
}

/*  Verifica que el error indicado tenga un codigo que corresponda al pasado
 *  por parametro.
 *  
 *  @param: el mensaje de error, con la forma esperada "<codigo>|<mensaje>" (error)
 *  @param: el codigo de mensaje de error deseado (codigo)
 *  @return: true si coinciden y false en caso contrario o ante falla de formato 
 *  (si el separador no es '|' (pipe)).
 *  
 *  @author: eiraola
 *  @date: 08/03/2006
 *  
 */
function esMensajeErrorIndicado(error, codigo) {
    if(error != null && error.indexOf('|') > -1) {
         var arrError = error.split('|'); //Separa el mensaje de error
         var codigoAux = arrError[0].replace(' ', ''); //Elimina blancos del codigo
         if (codigoAux == codigo) {
             return true; // Hubo coincidencia
         } else {
             return false; // No hubo coincidencia
         }
    }
    return false; // No adecuado a formato
}

/*  Si es el caso en que acabo de borrar todos los registros de
 *  una lista editable devuelve string nulo ('') para que no se 
 *  muestre el mensaje de error "5|No existen datos con el criterio
 *  especificado".
 *  Se la utiliza en el onload del PAGINADO para darle valor a la
 *  variable msgError (antes de realizar procesarPaginado(mipgndo,
 *  msgError,...).
 *
 *  @author: eiraola
 *  @date: 09/03/2006
 *
 */
function administraMensajeNoExistenDatos(mensajeError) {
    if (borroUltimos && esMensajeErrorIndicado(mensajeError, '5')) { 
         borroUltimos = false;
         return ''; 
    } 
    return mensajeError;
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

	 //en el fomulario de eliminar no esta el check de vigentes
   /* if (get('formulario.tieneVigentes')=="S") {
        	if(get('formulario.ckVigentes')=="S"){
				vig= true;
			}else{
				vig= false;
			}
    }			  */

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
	//agregaBoton('visible');
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
	//agregaBoton('hidden');
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
