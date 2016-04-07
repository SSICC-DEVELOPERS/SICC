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

var FORMULARIO = 'formulario';
var shitTab=false;
var longitudInicial;
function onLoadPag()   {

	DrdEnsanchaConMargenDcho('datosDeDetalle',12);
	document.all["CpdatosDeDetalle"].style.visibility='';
	document.all["CpLin1datosDeDetalle"].style.visibility='';
	document.all["CpLin2datosDeDetalle"].style.visibility='';
	document.all["CpLin3datosDeDetalle"].style.visibility='';
	document.all["CpLin4datosDeDetalle"].style.visibility='';
	
	document.all["primera1Div"].style.visibility='hidden';
	document.all["ret1Div"].style.visibility='hidden';
	document.all["ava1Div"].style.visibility='hidden'; 
	document.all["separaDiv"].style.visibility='hidden';
	
	eval (ON_RSZ);  
	
	if (get(FORMULARIO+'.errDescripcion')!='') {
	  var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'),get(FORMULARIO+'.errDescripcion'));
	}	
	longitudInicial=datosDeDetalle.datos.length;
	configurarMenuSecundario(FORMULARIO);	
	var accion=get(FORMULARIO+'.accion');
	var ConstantesINT_ESTADO_PENDIENTE=get(FORMULARIO+'.ConstantesINT_ESTADO_PENDIENTE');
	var ConstantesINT_ESTADO_ENVIADO=get(FORMULARIO+'.ConstantesINT_ESTADO_ENVIADO');
	var ConstantesINT_ESTADO_ANULADO=get(FORMULARIO+'.ConstantesINT_ESTADO_ANULADO');
	var ConstantesINT_ESTADO_CONFIRMADO=get(FORMULARIO+'.ConstantesINT_ESTADO_CONFIRMADO');
	var oidEstado=get(FORMULARIO+'.hOidEstatus');
	if(accion=='mantenimiento_descuentos'){
		document.all["btnGenerarDescuento"].disabled = true;
	}else if(accion=='recuperar_lote'){
		if(oidEstado==ConstantesINT_ESTADO_PENDIENTE){
			document.all["btnGenerarDescuento"].disabled = true;
		}else if(oidEstado==ConstantesINT_ESTADO_ENVIADO){
			document.all["btnGenerarFichero"].disabled = true;			
			for(i=0;i<longitudInicial;i++){
				if(document.all['txtImporteDeudaEnviarADAM_'+i]!=undefined){
					document.all['txtImporteDeudaEnviarADAM_'+i].disabled=true;					
				}
			}				
		}else if(oidEstado==ConstantesINT_ESTADO_ANULADO){
			bloqueaTodo();
		}else if(oidEstado==ConstantesINT_ESTADO_CONFIRMADO){
			bloqueaTodo();
		}
		
	}
	if(longitudInicial==0){
		document.all["btnGenerarFichero"].disabled = true;
		document.all["btnEliminar"].disabled = true;
		document.all["btnGuardarConsulta"].disabled = true;
		document.all["btnAnular"].disabled = true;
		document.all["btnGenerarDescuento"].disabled = true;
	}else{
		var separaMiles = get(FORMULARIO + '.hid_SeparadorMiles');
		var sepaDecimal	= get(FORMULARIO + '.hid_SeparadorDecimales');		
		for(i=0;i<longitudInicial;i++){			
			if(document.all['txtImporteDeudaEnviarADAM_'+i]){
				var valorAdam=document.all['txtImporteDeudaEnviarADAM_'+i].value;
				if (valorAdam && valorAdam!="" && valorAdam!="undefined"){
					var importeFormateado=formateaImporte(valorAdam, separaMiles,sepaDecimal);				
					document.all['txtImporteDeudaEnviarADAM_'+i].value=importeFormateado;
					datosDeDetalle.datos[i][14]=importeFormateado;
				}else{
					var valorAdam=datosDeDetalle.datos[i][13];					
					var importeFormateado=formateaImporte(valorAdam, separaMiles,sepaDecimal);	
					document.all['txtImporteDeudaEnviarADAM_'+i].value=importeFormateado;
					datosDeDetalle.datos[i][14]=importeFormateado;
				}
			}
			
			if(document.all['txtImporteDeudaDescontar_'+i]!=undefined){
				var valorImporte=document.all['txtImporteDeudaDescontar_'+i].value;
				if(valorImporte && valorImporte!="" && valorImporte!="undefined"){
					var importeFormateado=formateaImporte(valorImporte, separaMiles,sepaDecimal);
					document.all['txtImporteDeudaDescontar_'+i].value=importeFormateado;
					datosDeDetalle.datos[i][15]=importeFormateado;
				}else{
					var importeFormateado=formateaImporte(valorAdam, separaMiles,sepaDecimal);	
					document.all['txtImporteDeudaDescontar_'+i].value=importeFormateado;
					datosDeDetalle.datos[i][15]=importeFormateado;				
				}
			}
		}
		focalizaPrimeraCaja();			
	}

}
function validarCajasTexto(){
	var separadorMiles=get(FORMULARIO + '.hid_SeparadorMiles');
	var separadorDecimales	= get(FORMULARIO + '.hid_SeparadorDecimales');
	
	datosDeDetalle.actualizaDat();
	var puedoEnviar=false;
	for(i=0;i<datosDeDetalle.datos.length;i++){
		var cajaString = quitarSeparadorMiles(datosDeDetalle.datos[i][14], separadorMiles,separadorDecimales,'.');
		if((cajaString=="") || (cajaString==0)){
			puedoEnviar=false;
		}else{
			if(cajaString>0){
				puedoEnviar=true;
			}
		}
	}//for
			
	if(!puedoEnviar){
		//Al menos un campo de importe ADAM debe ser diferente de 0
		GestionarMensaje('UIINT-009');	
	}
	return puedoEnviar;
}

function onClickGenerarFichero(){ 
   if(validarCajasTexto())
   {
   		
	rellenaListaDetalles();
	var objParams = new Object();	
	objParams.hMarca=get(FORMULARIO+".hMarca");                      
	objParams.hCanal=get(FORMULARIO+".hCanal");                 
	objParams.hAcceso=get(FORMULARIO+".hAcceso");                
	objParams.hOidEstatus=get(FORMULARIO+".hOidEstatus");            
	objParams.hEstatus=get(FORMULARIO+".hEstatus");               
	objParams.hDescripcion=get(FORMULARIO+".hDescripcion");           
	objParams.hFechaVencimientoDesde=get(FORMULARIO+".hFechaVencimientoDesde"); 
	objParams.hFechaVencimientoHasta=get(FORMULARIO+".hFechaVencimientoHasta"); 
	objParams.hNumeroLote=get(FORMULARIO+".hNumeroLote");            
	objParams.hNumeroDocumento=get(FORMULARIO+".hNumeroDocumento");       
	objParams.hFechaCreacion=get(FORMULARIO+".hFechaCreacion");         
	objParams.areatxtObservaciones=get(FORMULARIO+".areatxtObservaciones");   	
						
 	objParams.listaOidClientes=get(FORMULARIO+'.listaOidClientes');       
	objParams.listaOidSubTipoClientes=get(FORMULARIO+'.listaOidSubTipoClientes');
	objParams.listaImporteCalculados=get(FORMULARIO+'.listaImporteCalculados'); 
	objParams.listaImportesDescontar=get(FORMULARIO+'.listaImportesDescontar'); 
	objParams.listaImportesEnviar=get(FORMULARIO+'.listaImportesEnviar');    
	objParams.listaCodCliente=get(FORMULARIO+'.listaCodCliente');     	
	objParams.listaTipoCliente=get(FORMULARIO+'.listaTipoCliente');    	
	objParams.listaCodPlanilla=get(FORMULARIO+'.listaCodPlanilla');    	
	
	vuelta=mostrarModalSICC('LPAdam','generar_fichero',objParams, 525, 230);	
			
	if(vuelta!=undefined){
		var vCorrecto=vuelta[0];
		var vEstado=vuelta[1];
		var vNumeroDeLote=vuelta[2];
		if (vCorrecto=='true'){
			document.all["btnGenerarFichero"].disabled = true;
			document.all["btnEliminar"].disabled = false;
			document.all["btnGuardarConsulta"].disabled = false;
			document.all["btnAnular"].disabled = false;
			document.all["btnGenerarDescuento"].disabled = false;	
			set(FORMULARIO+'.hNumeroLote',vNumeroDeLote);	
			txt_to('lbldtEstatus',vEstado);
			txt_to('lbldtLote',vNumeroDeLote);
			btnProxy(1,0);	
			btnProxy(4,0);
			btnProxy(5,0);			
		}else{
			GestionarMensaje('UIINT-008');	
		}
	}
    }//el de validarCajas de texto.
	
						
}



function onClickGenerarDescuentosDeuda(){	
	rellenaListaDetalles();
	formulario.oculto='S';
	set(FORMULARIO+'.accion','generar_descuentos_deuda');
	set(FORMULARIO+'.conectorAction','LPAdam');
	enviaSICC(FORMULARIO);	
				
}

function onClickEliminar(){	
	if (datosDeDetalle.numSelecc() == 0) {
		GestionarMensaje('50');	
		return;
	}	
	var ConstantesINT_ESTADO_PENDIENTE=get(FORMULARIO+'.ConstantesINT_ESTADO_PENDIENTE');
	var ConstantesINT_ESTADO_ENVIADO=get(FORMULARIO+'.ConstantesINT_ESTADO_ENVIADO');
	var oidEstatus=get(FORMULARIO+'.hOidEstatus');	
	if(oidEstatus==ConstantesINT_ESTADO_PENDIENTE){	
		var oids = datosDeDetalle.codSeleccionados();		
		for(j=0;j<oids.length;j++){
			for(i=0;i<datosDeDetalle.datos.length;i++){
				if(datosDeDetalle.datos[i][0]==oids[j]){
					datosDeDetalle.eliminar(i);	
					datosDeDetalle.actualizaDat();	
					break;
				}
			}
		}
		if(datosDeDetalle.datos.length==0){
			bloqueaTodo();
		}		
	}else if(oidEstatus==ConstantesINT_ESTADO_ENVIADO){
		var oids = datosDeDetalle.codSeleccionados();		
		for(j=0;j<oids.length;j++){
			for(i=0;i<datosDeDetalle.datos.length;i++){
				if(datosDeDetalle.datos[i][0]==oids[j]){
					document.all['txtImporteDeudaDescontar_'+i].value="0";
					datosDeDetalle.datos[i][14]="0";
					datosDeDetalle.actualizaDat();	
					break;
				}
			}
		}		
	}
	
					
}

function onClickGuardar(){	
	
	rellenaListaDetalles();
	formulario.oculto='S';
	set(FORMULARIO+'.accion','guardar');
	set(FORMULARIO+'.conectorAction','LPAdam');
	enviaSICC(FORMULARIO);	
				
}

function onClickAnular(){	
	
	rellenaListaDetalles();	
	formulario.oculto='S';	
	set(FORMULARIO+'.accion','anular');
	set(FORMULARIO+'.conectorAction','LPAdam');
	enviaSICC(FORMULARIO);
				
}
function vacia(){
}
function importeDeudaOnBlurEspera(FILAEVENTO,nombreCajaText,columna) {
	setTimeout("vacia();",10); 
	importeDeudaOnBlur(FILAEVENTO,nombreCajaText,columna)
}
function importeDeudaOnBlur(FILAEVENTO,nombreCajaText,columna) {
	       
	datosDeDetalle.actualizaDat();
	var importeDeuda = datosDeDetalle.datos[FILAEVENTO][columna];
	var separaMiles = get(FORMULARIO + '.hid_SeparadorMiles');
	var sepaDecimal	= get(FORMULARIO + '.hid_SeparadorDecimales');
	var nombrelistado = "datosDeDetalle";         
	if(importeDeuda != ""){		
		var enteros = new Number(10);
		var decimales = new Number(2);
		var resultado = ValidaMilesDecimales(importeDeuda, enteros, decimales, separaMiles,sepaDecimal);
		
		if (resultado != 'OK') {			
			if(resultado == 0){			
				GestionarMensaje('1465');
			}else{
				cdos_mostrarAlert(resultado);
			}			
			document.all[nombreCajaText+'_'+FILAEVENTO].select();			
			return;
		}
	}
	var importeDeudaSimple=quitarSeparadorMiles(importeDeuda, separaMiles,sepaDecimal);
	var importeFormateado=formateaImporte(importeDeudaSimple, separaMiles,sepaDecimal);	
	datosDeDetalle.datos[FILAEVENTO][columna]=importeFormateado;
	document.all[nombreCajaText+'_'+FILAEVENTO].value=importeFormateado;
	datosDeDetalle.actualizaDat();
	if(FILAEVENTO==0&&columna==14&&shitTab){
		if(document.all['btnGenerarDescuento'].disabled){
			if(document.all['btnAnular'].disabled){
				if(document.all['btnGuardarConsulta'].disabled){
					if(document.all['btnEliminar'].disabled){
						if(document.all['btnGenerarFichero'].disabled){
							focalizaPrimeraCaja();
						}else{
							setTimeout("document.all['btnGenerarFichero'].focus();",5); 
						}
					}else{
						setTimeout("document.all['btnEliminar'].focus();",5); 
					}
				}else{					
					setTimeout("document.all['btnGuardarConsulta'].focus();",5); 
				}
			}else{				
				setTimeout("document.all['btnAnular'].focus();",5); 
			}	
		}else{	
			setTimeout("document.all['btnGenerarDescuento'].focus();",5); 
		}
		shitTab=false;
	}
	
}
function ValidaMilesDecimales(valor, enteros, decimales, separadorMiles, separadorDecimales) {
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
                    valorSinSeparadorMiles += separadorDecimales;
                    valorSinSeparadorMiles += valoresPrimario[1];
           }
           ok=ValidaFloat(valorSinSeparadorMiles, enteros, decimales, entornoSeparador, null, null);

  } else {return DrdMsgCore(101);}

  return ok;
}

function ValidaMilesDecimalesOriginal(valor, enteros, decimales, separadorMiles) {
	var ok= 'OK';
	var valoresPrimario = null;
	if (ValidaCaracteres(valor,'0123456789' + separadorMiles)!='OK'){		
		return DrdMsgCore(143) + separadorMiles + '0123456789';
	}
		
	if (valor.indexOf(separadorMiles) == 0) {		
		return DrdMsgCore(101);
	}
		
	if (valor.indexOf(separadorMiles) == valor.length-1){		
		return DrdMsgCore(101);
	}
	
	var valorSeparador = valor.split(separadorMiles);
	var separador = false;
	for(i=1; i<valorSeparador.length; i++){
		separador = true;
		if(valorSeparador[i].length != 3){
			return 0;	
		}
	}
	if((valorSeparador[0].length > 3)&&(separador)){
		return 0;
	}
	
	return ok;
}

function rellenaListaDetalles(){
	var separadorMiles=get(FORMULARIO + '.hid_SeparadorMiles');
	var separadorDecimales	= get(FORMULARIO + '.hid_SeparadorDecimales');
	if(datosDeDetalle.datos.length>0){
		var listaOidClientes       =new String (datosDeDetalle.datos[0][0]);
		if(listaOidClientes==""){
			listaOidClientes="_";
		}
		var listaOidSubTipoClientes=new String (datosDeDetalle.datos[0][9]);
		if(listaOidSubTipoClientes==""){
			listaOidSubTipoClientes="_";
		}		
		var listaImporteCalculados =new String (quitarSeparadorMiles(datosDeDetalle.datos[0][13], separadorMiles,separadorDecimales,'.'));
		if(listaImporteCalculados==""){
			listaImporteCalculados="_";
		}
		var listaImportesDescontar =new String (quitarSeparadorMiles(datosDeDetalle.datos[0][15], separadorMiles,separadorDecimales,'.'));
		if(listaImportesDescontar=="" || listaImportesDescontar == "undefined" ){
			listaImportesDescontar="_";
		}
		var listaImportesEnviar    =new String (quitarSeparadorMiles(datosDeDetalle.datos[0][14], separadorMiles,separadorDecimales,'.'));
		if(listaImportesEnviar=="" || listaImportesEnviar== "undefined" ){
			listaImportesEnviar="_";
		}

		var listaCodCliente 	   =new String (datosDeDetalle.datos[0][1]);
		if(listaCodCliente==""){
			listaCodCliente="_";
		}
		var listaTipoCliente	   =new String (datosDeDetalle.datos[0][7]);
		if(listaTipoCliente==""){
			listaTipoCliente="_";
		}
		var listaCodPlanilla	   =new String (datosDeDetalle.datos[0][6]);			
		if(listaCodPlanilla==""){
			listaCodPlanilla="_";
		}		
		for(i=1;i<datosDeDetalle.datos.length;i++){
			if(new String (datosDeDetalle.datos[i][0])==""){
				listaOidClientes=listaOidClientes+"|_";
			}else{
				listaOidClientes=listaOidClientes+"|"+datosDeDetalle.datos[i][0];
			}
			if(new String (datosDeDetalle.datos[i][9])==""){
				listaOidSubTipoClientes=listaOidSubTipoClientes+"|_";
			}else{				
				listaOidSubTipoClientes=listaOidSubTipoClientes+"|"+datosDeDetalle.datos[i][9];
			}
				
			if(new String (datosDeDetalle.datos[i][13])==""){
				listaImporteCalculados=listaImporteCalculados+"|_";
			}else{				
				listaImporteCalculados=listaImporteCalculados+"|"+quitarSeparadorMiles(datosDeDetalle.datos[i][13], separadorMiles,separadorDecimales,'.');
			}
			if(new String (datosDeDetalle.datos[i][15])==""){
				listaImportesDescontar=listaImportesDescontar+"|_";
			}else{				
				listaImportesDescontar=listaImportesDescontar+"|"+quitarSeparadorMiles(datosDeDetalle.datos[i][15], separadorMiles,separadorDecimales),'.';
			}
			if(new String (datosDeDetalle.datos[i][14])==""){ 
				listaImportesEnviar=listaImportesEnviar+"|_";
			}else{				
				listaImportesEnviar=listaImportesEnviar+"|"+quitarSeparadorMiles(datosDeDetalle.datos[i][14], separadorMiles,separadorDecimales,'.');
			}
			if(new String (datosDeDetalle.datos[i][1])==""){
				listaOidClientes=listaOidClientes+"|_";
			}else{				
				listaCodCliente=listaCodCliente+"|"+datosDeDetalle.datos[i][1];
			}
			if(new String (datosDeDetalle.datos[i][7])==""){
				listaTipoCliente=listaTipoCliente+"|_";
			}else{				
				listaTipoCliente=listaTipoCliente+"|"+datosDeDetalle.datos[i][7];
			}
			if(new String (datosDeDetalle.datos[i][6])==""){
				listaCodPlanilla=listaCodPlanilla+"|_";
			}else{				
				listaCodPlanilla=listaCodPlanilla+"|"+datosDeDetalle.datos[i][6];			
			}
		}	
				
		set(FORMULARIO+'.listaOidClientes',listaOidClientes);       
		set(FORMULARIO+'.listaOidSubTipoClientes',listaOidSubTipoClientes);
		set(FORMULARIO+'.listaImporteCalculados',listaImporteCalculados); 
		set(FORMULARIO+'.listaImportesDescontar',listaImportesDescontar); 
		set(FORMULARIO+'.listaImportesEnviar',listaImportesEnviar);  		
		set(FORMULARIO+'.listaCodCliente',listaCodCliente);  
		set(FORMULARIO+'.listaTipoCliente',listaTipoCliente);  
		set(FORMULARIO+'.listaCodPlanilla',listaCodPlanilla);  
				 		 								
	}	

}
function gestionaTabBotones(boton){
	if(boton=='btnGenerarFichero'){
		if(document.all['btnEliminar'].disabled){
			if(document.all['btnGuardarConsulta'].disabled){
				if(document.all['btnAnular'].disabled){
					if(document.all['btnGenerarDescuento'].disabled){
						focalizaPrimeraCaja();
					}else{
						document.all['btnGenerarDescuento'].focus();
					}
				}else{
					document.all['btnAnular'].focus();
				}
			}else{
				document.all['btnGuardarConsulta'].focus();
			}
		}else{
			document.all['btnEliminar'].focus();
		}
	}else if(boton=='btnEliminar'){
		if(document.all['btnGuardarConsulta'].disabled){
			if(document.all['btnAnular'].disabled){
				if(document.all['btnGenerarDescuento'].disabled){
					focalizaPrimeraCaja();		
				}else{
					document.all['btnGenerarDescuento'].focus();
				}
			}else{
				document.all['btnAnular'].focus();
			}
		}else{
			document.all['btnGuardarConsulta'].focus();
		}
	}else if(boton=='btnGuardarConsulta'){
		if(document.all['btnAnular'].disabled){
			if(document.all['btnGenerarDescuento'].disabled){
				focalizaPrimeraCaja();		
			}else{
				document.all['btnGenerarDescuento'].focus();
			}
		}else{
			document.all['btnAnular'].focus();
		}
	}else if(boton=='btnAnular'){
		if(document.all['btnGenerarDescuento'].disabled){
			focalizaPrimeraCaja();			
		}else{
			document.all['btnGenerarDescuento'].focus();
		}
	}else if(boton=='btnGenerarDescuento'){
		focalizaPrimeraCaja();				
	}
		                    
}

function focalizaPrimeraCaja(){
	
	if(document.all['txtImporteDeudaEnviarADAM_0']!=undefined&&!document.all['txtImporteDeudaEnviarADAM_0'].disabled){
		document.all['txtImporteDeudaEnviarADAM_0'].select();
	}		
	
}

function gestionaOnShTabCaja(FILAEVENTO, TECLAEVENTO){

	//if(FILAEVENTO==0){
		document.all['btnGenerarFichero'].focus();
	//}
}

function focalizaAnt(FILAEVENTO, TECLAEVENTO){
	if(FILAEVENTO==0){
		shitTab=true;
	}
	
}

function ponerSeparadorMiles(cantidad, separadorMiles) {
         
         if (cantidad.indexOf(separadorMiles) == -1) {
                  var cantidadFormateadaInversa = '';
         
                  contador=0;
                  for (i=cantidad.length -1; i >= 0; i--) {
                           contador++;
                           cantidadFormateadaInversa += cantidad.charAt(i);
                           if ((contador % 3) == 0 && i > 0) {
                                    cantidadFormateadaInversa += separadorMiles;
                           }
                  }
                  
                  var cantidadFormateada = '';
                  for (i=0; i < cantidadFormateadaInversa.length; i++) {
                           cantidadFormateada += cantidadFormateadaInversa.charAt(cantidadFormateadaInversa.length - i -1);
                  }
                  
                  return cantidadFormateada;
         }
         return cantidad;
}

function quitarSeparadorMiles(cantidad, separadorMiles,separadorDecimales) {
	var resultado = '';
	var cantidadString=new String(cantidad);
	if(cantidadString!=""){
		var arrayNumero=cantidadString.split(separadorDecimales);
		var numeroEntero=arrayNumero[0];
		var decimales="";
		if(arrayNumero[1]!=undefined){
			decimales=new String(arrayNumero[1]);			
		}
		var numeroEnteroSep=numeroEntero.split(separadorMiles);
		for (n=0;n<numeroEnteroSep.length;n++){
			resultado=resultado+numeroEnteroSep[n];
		}
		if(decimales!=""){
			resultado=resultado+separadorDecimales+decimales;
		}
	}
		
	return resultado;
}        

function vueltaAnular(descEstado){
	txt_to('lbldtEstatus',descEstado);
	bloqueaTodo();
}

function bloqueaTodo(){
	
	document.all["btnGenerarFichero"].disabled = true;
	document.all["btnEliminar"].disabled = true;
	document.all["btnGuardarConsulta"].disabled = true;
	document.all["btnAnular"].disabled = true;
	document.all["btnGenerarDescuento"].disabled = true;	
	btnProxy(1,0);	
	btnProxy(4,0);
	btnProxy(5,0);	
	for(i=0;i<longitudInicial;i++){
		if(document.all['txtImporteDeudaEnviarADAM_'+i]!=undefined){
			document.all['txtImporteDeudaEnviarADAM_'+i].disabled=true;
			document.all['txtImporteDeudaDescontar_'+i].disabled=true;
		}
	}	
	
}

function fVolver(){
	var accion=get(FORMULARIO+'.accion');
	if(accion!='mantenimiento_descuentos'){
		set(FORMULARIO+'.conectorAction','LPRecuperarDescuentos');
	}else{
		set(FORMULARIO+'.conectorAction','LPEnviarDescuentos');
	}
	set(FORMULARIO+'.accion','');
	enviaSICC(FORMULARIO);
	
}

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

