var FORMULARIO = "formulario";


function accionAceptar() {
	
	if (sicc_validaciones_generales()) {
		//pzerbino incidencia BELC300024255 25/9/2006 Devuelve oid Oculto
		//var oid = get(FORMULARIO + '.cbProducto').toString();
		var oid = get(FORMULARIO + '.hOidProducto').toString();
		
		//var producto = get(FORMULARIO + '.cbProducto','T').toString();
		var producto = get(FORMULARIO + '.txtProducto').toString();
		var cantidad = get(FORMULARIO + '.txtCantidad').toString();
		
		//obtenemos el numero decimal
		cantidad=obtieneNumeroDecimal(cantidad,get(FORMULARIO + '.hid_SeparadorDecimales'));
		
		//formateamos la cantidad con separador de miles
		var cantidad=formateaImporte(cantidad,get(FORMULARIO + '.hid_SeparadorMiles'),get(FORMULARIO + '.hid_SeparadorDecimales'));
		
		var precioVentaNeto = get(FORMULARIO + '.txtPrecioVentaNeto').toString();
		var precioContable = get(FORMULARIO + '.txtPrecioContable').toString();
		
		//validamos si el precioVentaNeto es correcto
		if (precioVentaNeto!='' && !validaImporte('txtPrecioVentaNeto',12)){
			return false;
		}
		
		//validamos si el precioContable es correcto
		if (precioContable!='' && !validaImporte('txtPrecioContable',12)){
			return false;
		}
		
		
		
		window.returnValue = [oid, producto, cantidad, precioVentaNeto, precioContable];
		window.close();
	}
} 

/* funcion que comprueba si es correcto el formato de decimales
* elemento -> es el nombre del elemento que contiene el valor
* enteros -> numero de digitos que como máximo tendrá la parte entera
*/
function validaImporte(elemento,enteros) {
     //Validamos que no inserte en un formato incorrecto
     /*if (valor != '') {
     	return ValidaMilesDecimales(valor, enteros, get(FORMULARIO + '.hid_NumeroDecimales'), 
                                get(FORMULARIO + '.hid_SeparadorMiles'), get(FORMULARIO + '.hid_SeparadorDecimales'), 0);
     }*/
    
    var valor = get(FORMULARIO + '.'+elemento);
    if (valor!='') {
    	
		var mensaje = ValidaMilesDecimales(valor, enteros, get(FORMULARIO + '.hid_NumeroDecimales'), 
	                                    get(FORMULARIO + '.hid_SeparadorMiles'), get(FORMULARIO + '.hid_SeparadorDecimales'), 0);
	    //no recoge bien los valores de la session porque fallo en UtilidadesSesion.GetFormatoNumerico
	    //var mensaje = ValidaMilesDecimales(valor, enteros,"2",".",",",0);
	    if (mensaje != "OK") {
			cdos_mostrarAlert(mensaje);
			focaliza(FORMULARIO + '.'+elemento);
			return false;
		}   
	}        
	return true;        
}


/* valida decimales positivos(formato con separador de miles y de decimales)
  * valor es una cadena con el numero decimal
  * enteros -> numero de digitos que como máximo tendrá la parte entera
  * decimales -> numero de digitos que como máximo tendrá la parte decimal
  * separadorMiles -> carácter de separador de miles
  * separadorDecimales -> carácter de separador de decimales
  * min -> valor minimo que tendrá el número
  * max -> valor maximo que tendrá el número (se puede omitir)
  * devuelve el mensaje 'OK' si el numero decimal es valido, en caso contrario devuelve el mensaje de error a mostrar
  */
 function ValidaMilesDecimales(valor, enteros, decimales, separadorMiles, separadorDecimales, min, max) {
          var ok;
          var valoresPrimario = null;
          if (ValidaCaracteres(valor,'0123456789' + separadorMiles + separadorDecimales)!='OK') {return DrdMsgCore(143) + separadorMiles + separadorDecimales + '0123456789';}
          
          //empieza por separadordecimales
          if (valor.indexOf(separadorDecimales) == 0) {return DrdMsgCore(101);}

          //termina por separadordecimales
          if (valor.indexOf(separadorDecimales) == valor.length-1) {return DrdMsgCore(101);}
          
          //empieza por separadormiles
          if (valor.indexOf(separadorMiles) == 0) {return DrdMsgCore(101);}

          //termina por separadormiles
          if (valor.indexOf(separadorMiles) == valor.length-1) {return DrdMsgCore(101);}
          
          valoresPrimario = valor.split(separadorDecimales);
          if (valoresPrimario.length > 0 && valoresPrimario.length < 3 && valoresPrimario[0].length > 0 ) {
                   //parte entera no está vacía
                   var valores = valoresPrimario[0].split(separadorMiles);
                   if (valores.length > 1) {
                            if (valores[0].length < 1 || valores[0].length > 3 ){return DrdMsgCore(101);}
                            for (i = 1; i < valores.length; i++)
                                     if(valores[i].length < 3 ){return DrdMsgCore(101);}
                   }
                   var entornoSeparador = (separadorDecimales == ",")?true:false;
                   
                   var valorSinSeparadorMiles = valoresPrimario[0];
                   while (valorSinSeparadorMiles.indexOf(separadorMiles) != -1) {
                            valorSinSeparadorMiles = valorSinSeparadorMiles.replace(separadorMiles, '');
                           
                   }
                   if (valoresPrimario.length == 2) {
                   			//comprobar si valoresPrimario[1] tiene el separador de miles, en ese caso devolvemos mensaje de error
                   			if (valoresPrimario[1].indexOf(separadorMiles)!=-1){
                   				return DrdMsgCore(101);
                   			}
                            valorSinSeparadorMiles += separadorDecimales;
                            valorSinSeparadorMiles += valoresPrimario[1];
                            
                   }
                   
                   ok=ValidaFloat(valorSinSeparadorMiles, enteros, decimales, entornoSeparador, min, max);

          } else {return DrdMsgCore(101);}
 
          return ok;
 }
 
 
//valida que el campo cantidad sea numerico
function validaCantidad (elemento) {
	
	var valor = get(FORMULARIO + '.'+elemento);
	if (valor != "") {
		
		if (ValidaCaracteres(valor,'-0123456789' + get(FORMULARIO + '.hid_SeparadorMiles'))!='OK') {
			
			var mensaje= DrdMsgCore(143) + get(FORMULARIO + '.hid_SeparadorMiles') + '-0123456789';
			if (mensaje != "OK") {
				cdos_mostrarAlert(mensaje);
				focaliza(FORMULARIO + '.'+elemento);
				return false;
			}  
		}
	}
	
}

 //formatea un decimal a cadena con separadores de miles, separador de decimales
 //el número decimal debe tener la parte decimal en el formato adecuado
 function formateaImporte(numeroDecimal, separadorMiles, separadorDecimales){
          var dineroEntrada = "" + numeroDecimal;
          var negativo = false;
          if (dineroEntrada.indexOf('-') == 0) {
                   dineroEntrada = dineroEntrada.replace('-', '');
                   negativo = true;
          }
          var tokens = dineroEntrada.split('.');
          var bufferEntero = tokens[0];// almacena la parte entera.
          var bufferDinero = "";//almacena el resultado
          var bufferDecimales = "";//almacena la parte decimal
          if (tokens.length > 1)
                   bufferDecimales = tokens[1];

          while (bufferEntero.length > 0) {
                   if (bufferEntero.length > 3) {
                            bufferDinero = separadorMiles + bufferEntero.substr(bufferEntero.length-3) + bufferDinero ;
                            bufferEntero = bufferEntero.substr(0, bufferEntero.length-3);
                   } else {
                            bufferDinero = bufferEntero.substr(0) + bufferDinero ;
                            bufferEntero = "";
                   }
          }
          if (bufferDecimales != "") {
                   if (bufferDecimales != "0" && bufferDecimales != "00") {
                            bufferDinero = bufferDinero + separadorDecimales + bufferDecimales;
                   }
          }
          if (negativo)
                            bufferDinero = '-' + bufferDinero;
          return bufferDinero;
 }
 
 //convierte a numero decimal una cadena con formato de miles y decimales
 function obtieneNumeroDecimal(cadena, separadorDecimales) {
      if (cadena != "") {
               //eliminar separador de miles
               if (separadorDecimales == ".") {
                        cadena = cadena.replace(/,/g,'');
               } else {
                        cadena = cadena.replace(/\./g,'');
                        //sustituir separador decimal por punto
                        cadena = cadena.replace(/,/g,'.');
               }
               return Number(cadena);
      }
 }
 
 function onLoadPag(){
	if (get(FORMULARIO+'.errDescripcion')!='') {                    
                  var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'),get(FORMULARIO+'.errDescripcion'));
     } 	
     // pasar el foco al primer control de la pagina
	//pzerbino incidencia BELC300024255  25/9/2006
	//focaliza(FORMULARIO + ".cbProducto");
	focaliza(FORMULARIO + ".txtProducto");
 	configurarMenuSecundario(FORMULARIO);	
}

function fVolver(){
	window.close();	
}

function fLimpiar(){
	set(FORMULARIO + '.cbAplicacion', '');
	// pasar el foco al primer control de la pagina
		//pzerbino incidencia BELC300024255  25/9/2006
	//focaliza(FORMULARIO + ".cbProducto");
	focaliza(FORMULARIO + ".txtProducto");
}

function focalizaTabAceptar() {
	//para que desde el campo Aceptar tabule al combo Productos
	//focaliza(FORMULARIO + ".btnAnadir");	
	//document.all['cbProducto'].focus();
		//pzerbino incidencia BELC300024255  25/9/2006
	//focaliza(FORMULARIO + ".cbProducto");
	focaliza(FORMULARIO + ".txtProducto");
}

function focalizaShiftProducto(){
	//para que desde el el combo Producto tabule a aceptar
	//focaliza(FORMULARIO + ".btnAceptar");
	document.all['btnAceptar'].focus();
	
}

function onClickBuscarProducto(){
	     var datos = new Object();
         datos.dto = "es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOGenBusquedaGenerico";
         datos.conector = "ConectorGENBusquedaProducto";
         var salida = abrirBusquedaGenerica(datos, "","0075");
         var oid = "";
         var descripcion = "";
         if(salida){
                  oid = salida[0][0];
                  descripcion = salida [0][2];
         }
         set(FORMULARIO+'.hOidProducto',oid);
         set(FORMULARIO+'.txtProducto',descripcion);
}