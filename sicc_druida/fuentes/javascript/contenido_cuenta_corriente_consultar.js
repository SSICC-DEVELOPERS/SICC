  function onLoadPag()   {
  
     configurarMenuSecundario('Formulario');
     DrdEnsanchaConMargenDcho('listado1',12);
 
     /*document.all["Cplistado1"].style.visibility='';
     document.all["CpLin1listado1"].style.visibility='';
     document.all["CpLin2listado1"].style.visibility='';
     document.all["CpLin3listado1"].style.visibility='';
     document.all["CpLin4listado1"].style.visibility='';*/

	if(get('Formulario.casoDeUso')=="reasignarPagos"){
		//deshabilito los botones debajo de la lista
		document.all["SaldoCampanas"].disabled=true;
		document.all["OrdenarFechaValor"].disabled=true;
		document.all["Detalle"].disabled=true;
		document.all["Cobranza"].disabled=true;
	}

     setTimeout ('eval (ON_RSZ)',200);
     recalcularSaldo();

     fMostrarMensajeError();

	   if (window.dialogArguments) { // Si es modal (se abrió mediante showModalDialog) DBLG500000915
            btnProxy(2,1);  // boton 'volver', habilitado
            btnProxy(3,0);  // boton 'Ir a pantalla de inicio', deshabilitado
        }


   }
   
//------------------------------------------------------------------------------   

	function fVolver(){     
					  window.close();
	}

//------------------------------------------------------------------------------   
   
   function saldoCampana(){
   
        if (listado1.codSeleccionados().length == 1) {    
            var a = new Object();
            //var periodo = listado1.extraeDato(listado1.codSeleccionados(), 11);
	     var periodo = listado1.extraeDato(listado1.codSeleccionados(), 10);
            a.oidPeriodo = periodo;   
            a.accion = 'saldoCampana';
            a.oidCliente = get('Formulario.oidCliente')
            mostrarModalSICC('CCCConsultaCC', 'saldoCampana', a, 795, 505);
        }else {   
            GestionarMensaje('4');   
        }   
         
   
   }

//------------------------------------------------------------------------------   

   function detalle(){
	 var seleccionados = listado1.codSeleccionados();
        if (seleccionados.length == 1) {    
            var a = new Object();
            a.oid = seleccionados;
            a.accion = 'detalle';
            mostrarModalSICC('CCCConsultaCC', 'detalle', a, 795, 505);
        }else {   
            GestionarMensaje('4');   
        }   
   
   
   } 
//------------------------------------------------------------------------------   

   function cobranza(){
      var a = new Object();
     
      a.accion = 'generar';
      a.codigoCliente = get('Formulario.codigoCliente');
      a.camposBusqueda = '1';

      mostrarModalSICC('COBConsultaCobranza', 'generar', a, 795, 505);
   }

//------------------------------------------------------------------------------  
   function recalcularSaldo(){

	var saldoAnterior;
	var importe;
	var saldoCuenta;
	var saldoTotal  = new Number(get('Formulario.hiddenDeudaTotal'));
	var cantidadDecimales = 2;
	var cantidad = listado1.datos.length;
	var mathPow = Math.pow(10,cantidadDecimales);	

	if(cantidad > 0){
	   listado1.datos[0][9] = saldoTotal;	   
	   for (f = 1; f < cantidad ; f++) {
		//if (listado1.datos[f][13] == 'A'){ 
		if (listado1.datos[f][12] == 'A'){ 
	           listado1.datos[f][9] = saldoTotal;
		    //listado1.datos[f][8] = saldoTotal;
		}else{
		   saldoAnterior = new Number(listado1.datos[f-1][9]);
		   importeAnterior = new Number(listado1.datos[f-1][8]);
		   //saldoAnterior = new Number(listado1.datos[f-1][8]);	   
		   //importe = new Number(listado1.datos[f][7]);
		   /*saldoCuenta = saldoAnterior + importe;
		   Se calcula el saldo de la manera siguiente porque javascript
		   */
		   //saldoCuenta = Math.round(new Number(saldoAnterior + importe)*Math.pow(10,cantidadDecimales))/Math.pow(10,cantidadDecimales);		   
		   saldoCuenta = Math.round(new Number(saldoAnterior - importeAnterior)*mathPow)/mathPow;		   
  		   listado1.datos[f][9] = saldoCuenta;
		   //listado1.datos[f][8] = saldoCuenta;
		}
	    }
		
	}
	listado1.repinta();
		
   }
//------------------------------------------------------------------------------  

   function ordenar(){
      listado1.ordenaPorColumna(1,true);
      recalcularSaldo();
   }