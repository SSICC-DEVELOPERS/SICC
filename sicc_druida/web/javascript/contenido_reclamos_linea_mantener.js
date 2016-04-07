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


var FORMULARIO = 'frmContenido';
var delimLinea="@@";
var delimColum="||";
lineasDeOperacion=new Array();
var contadorOperaciones=1;
var oDatosPerdida = new Array();
var oControlProductosDevuelve= "";
var paginaOculta=true;
var existeAnulacion = "false";
var existeOperacion = "false";
var esModificacion = "";
var indGuardado = "";
var mOperacion = new Array();
var mLineas = new Array();
var controlAgrego ="";
var reclamosBloq ="";
var totalEnvia=parseFloat("0");
var totalDevuelve=parseFloat("0");
var saldoPagar=parseFloat("0");
var casoDeUso="";
//Array de objetos: 
function onLoadPag(){	 
    

	if (get(FORMULARIO+'.errDescripcion')!='') {
		ocultaLista();
		var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'),get(FORMULARIO+'.errDescripcion'));

	}
	casoDeUso = get(FORMULARIO+".casoUso");
	if (casoDeUso=="modificar"){
	  modificarReclamo();
	}else{
		document.all["Agregar"].disabled = true;	 
		document.all["GenSol"].disabled = true;
		consultarReclamo();
	    
	 }
	 setTimeout( 'configurarMenuSecundario(FORMULARIO);',200);


}

function vaciaSolicitudes(){
	
	frmContenido.oculto='N';
       	fLimpiarGenericoSICC();
       	
        limpiaPantalla();
        ocultaLista();
	 if (casoDeUso!="modificar"){
		document.all["GenSol"].disabled=true;
	  }	
		focaliza(FORMULARIO+'.txtCodCliente');
	btnProxy(1,1);	
	btnProxy(4,1);	        
}


function vaciaGuardar(){
	
	frmContenido.oculto='N';	
		
	btnProxy(1,0);	
	btnProxy(4,0);
    indGuardado = "true";
    document.all["GenSol"].disabled = false;
    calculaTotales();
}

function calculaTotales() {
  
	/* Modificado por ssantana, 18/08/2006, inc. DBLG500001063 */
	/* Se contempla que importeCargo pueda venir con valor no numerico, y se usa "0" en su defecto. */

    totalEnvia=parseFloat(0);
    totalDevuelve=parseFloat(0);
	var importeCargoBuffer = null;
	var importeAbonoBuffer = null;
	var sSeparadorMiles = get(FORMULARIO+".hid_SeparadorMiles");
	var sSeparadorDecimales = get(FORMULARIO+".hid_SeparadorDecimales");
	var sCantDecimales = get(FORMULARIO+".hid_NumeroDecimales");

	/* Modificado por ssantana, 27/07/2006, DBLG500001102 (inc. BELC300023896) */ 
	/* Se antepone "var=" a los contadores para que tengan el scope del método actual. */ 
	var cantLineasDeOperacion = lineasDeOperacion.length;
    for (var h=0; h < cantLineasDeOperacion; h++) {
	   var cantSubElementos = lineasDeOperacion[h].lineasOperacion.length;
       for (var j=0; j < cantSubElementos; j++){
			/* Contemplo diversos valores "no numericos" de importeCargo e importeAbono, uso 0 en ese caso. */ 

			/* Importe Cargo */
		   importeCargoBuffer = lineasDeOperacion[h].lineasOperacion[j].importeCargo;
		   if  (importeCargoBuffer == null || importeCargoBuffer == undefined || importeCargoBuffer == "") {
			  importeCargoBuffer = 0;
		   }
		   importeCargoBuffer = quitarSeparadorMiles(importeCargoBuffer,
																	sSeparadorMiles,
			                                                        sSeparadorDecimales);

			/* Importe Abono */
		   importeAbonoBuffer = lineasDeOperacion[h].lineasOperacion[j].importeAbono;
		   if ( importeAbonoBuffer == null || importeAbonoBuffer == undefined || importeAbonoBuffer == "") {
			   importeAbonoBuffer = 0;
		   }
		   importeAbonoBuffer = quitarSeparadorMiles(importeAbonoBuffer,
																	sSeparadorMiles,
			                                                        sSeparadorDecimales);

			/* Realizo Acumulacion */ 
		   totalEnvia = parseFloat(totalEnvia) + parseFloat(importeCargoBuffer);
		   totalDevuelve = parseFloat(totalDevuelve) + parseFloat(importeAbonoBuffer);
          /*totalEnvia = parseFloat(totalEnvia) + 
									parseFloat(quitarSeparadorMiles(lineasDeOperacion[h].lineasOperacion[j].importeCargo,get(FORMULARIO+".hid_SeparadorMiles"),get(FORMULARIO+".hid_SeparadorDecimales")));		 
          totalDevuelve = parseFloat(totalDevuelve)+parseFloat(quitarSeparadorMiles(lineasDeOperacion[h].lineasOperacion[j].importeAbono,get(FORMULARIO+".hid_SeparadorMiles"),get(FORMULARIO+".hid_SeparadorDecimales")));				*/
       }
    }

    saldoPagar = parseFloat(totalEnvia)-parseFloat(totalDevuelve);
	/* Redondeo con la cantidad de decimales establecida el Pais. */ 
	saldoPagar = redondea(saldoPagar, sCantDecimales);

	/* Fin Modificado por ssantana, 27/07/2006, DBLG500001102 (inc. BELC300023896) */ 
    
    txt_to("lblTotalEnviaX",formateaImporte(totalEnvia,
														  sSeparadorMiles,
														  sSeparadorDecimales));
    txt_to("lblTotalDevuelveX",formateaImporte(totalDevuelve,
															   sSeparadorMiles,
															   sSeparadorDecimales));
    txt_to("lblSaldoAPagarX",formateaImporte(saldoPagar,
															 sSeparadorMiles,
															 sSeparadorDecimales));

    set(FORMULARIO+".hTotalEnvia",totalEnvia);
    set(FORMULARIO+".hTotalDevuelve",totalDevuelve);
    set(FORMULARIO+".hSaldoPagar",saldoPagar);		

	/* Fin Modificacion por ssantana, 18/08/2006, inc. DBLG500001063 */

}


function accionBuscarCliente() {
	
	var objParams = new Object();
	var cliente = mostrarModalSICC('LPBusquedaRapidaCliente', '', objParams, null, null);            
	
	if (cliente != undefined && cliente.length > 1) {
		set(FORMULARIO + '.txtCodCliente', cliente[1]);
		set(FORMULARIO + '.txtNombre', cliente[2]);
		set(FORMULARIO + '.txtApellidoPaterno', cliente[4]);
		set(FORMULARIO + '.txtApellidoMaterno', cliente[5]);
	}
	
}



function fLimpiar(){
           fLimpiarGenericoSICC();
           limpiaPantalla();
          
}

function limpiaPantalla(){
	while(lineasDeOperacion.length>0){
		lineasDeOperacion.splice(0,1);
	}
	ineasDeOperacion=undefined;	
	ineasDeOperacion=new Array();
	
	contadorOperaciones= 1;
	listado1.actualizaDat();
	while(listado1.datos.length>0){
		listado1.eliminar(0);	
		listado1.actualizaDat();	
	}        
	listado2.actualizaDat();
	while(listado2.datos.length>0){
		listado2.eliminar(0);	
		listado2.actualizaDat();	
	} 
  existeAnulacion = "false";
  existeOperacion = "false";
}

function vueltaNumDocumento(numeroDoc){	
	frmContenido.oculto='N';
	set(FORMULARIO + '.numAtencion',numeroDoc);
	mostrarLista();
}

function fBorrar(){
	
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
	
	while(listado2.datos.length>0){
		
		listado2.eliminar(0);	
		listado2.actualizaDat();	
		
	}	
	var flag = false;
  var oid = new String(listado1.codSeleccionados());
	var numero=0;	
  var borra = listado1.extraeDato(oid,19);
  var oidEliminar = "";
  
    	if (borra == 'No' ){
    		flag = true;
    	}
		
	if (!flag){
    if(get(FORMULARIO +".hOidsAEliminar")==""){
       oidEliminar = listado1.extraeDato(oid,18);

    }else{
       oidEliminar = get(FORMULARIO +".hOidsAEliminar")+";"+listado1.extraeDato(oid,18);
    }
    
    set('frmContenido.hOidsAEliminar', oidEliminar );
  
  
	for(i=0;i<lineasDeOperacion.length;i++){
		if(oid==lineasDeOperacion[i].oidOperacion){
			numero=i;
			break;
		}
	}	

	var arrayControl = oControlProductosDevuelve.split('|');
	oControlProductosDevuelve = "";
	var lineaTemp = "";
	for(j=0;j<lineasDeOperacion[numero].lineasOperacion.length;j++){
        var encontree=false;

		var posi = lineasDeOperacion[numero].lineasOperacion[j].oidPosicion;

		if(posi!=null && posi!="" && posi!=undefined && posi!="undefined"){

			for(h=0;h<arrayControl.length;h++){
				linea = arrayControl[h].split(',');

				objLinea = new Object();
				objLinea.oidPosicion = linea[0];
				objLinea.unidadesReclamadas = linea[1];
				objLinea.unidadesDisponibles = linea[2];
				if(objLinea.oidPosicion == posi){ 
				
					objLinea.unidadesReclamadas = new Number(objLinea.unidadesReclamadas) - new Number(lineasDeOperacion[numero].lineasOperacion[j].uReclamadas);
					objLinea.unidadesDisponibles = new Number(objLinea.unidadesDisponibles) + new Number(lineasDeOperacion[numero].lineasOperacion[j].uReclamadas);
					
					lineaTemp = objLinea.oidPosicion+','+objLinea.unidadesReclamadas+','+objLinea.unidadesDisponibles;
					encontree=true;
				}else{
					lineaTemp = objLinea.oidPosicion+','+objLinea.unidadesReclamadas+','+objLinea.unidadesDisponibles;
	
				}
				oControlProductosDevuelve +=lineaTemp;
			}
			
				if(encontree!=true){
					if(oControlProductosDevuelve!=null&&oControlProductosDevuelve!=undefined&&oControlProductosDevuelve!=""){
						oControlProductosDevuelve += '|';
					}
					oControlProductosDevuelve += posi+','+(new Number(lineasDeOperacion[numero].lineasOperacion[j].uReclamadas)*(-1))+','+(new Number(lineasDeOperacion[numero].lineasOperacion[j].uReclamadas)+',1');					
				}
		}			 							      				
	}		
	lineasDeOperacion.splice(numero,1);

  for(i=0;i<listado1.datos.length;i++){
		if(listado1.datos[i][0]==oid){			
			listado1.eliminar(i);	
			listado1.actualizaDat();	
			break;
		}
	}
	  existeAnulacion="false";
  	if(!listado1.datos.length>0){
      existeOperacion="false";
    }
    resecuenciar();

        calculaTotales();
		/* } */
    }else{
    		GestionarMensaje('REC023');
    }	
}


function resecuenciar(){
	
	for(i=0;i<listado1.datos.length;){
		if(listado1.datos[i][3] != (i + 1)){
			listado1.datos[i][3] = i + 1;
			fila = listado1.datos[i];
			listado1.eliminar(i);
			listado1.insertar(fila);
			listado1.actualizaDat();
		} else{
			i++;
		}
	}
    contadorOperaciones = listado1.datos.length + 1;
}

function onClickDetalle() {
	
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
	listado2.actualizaDat();
	while(listado2.datos.length>0){
		listado2.eliminar(0);	
		listado2.actualizaDat();	
	}         
	var oid = new String(listado1.codSeleccionados());
	var numero=0;
	
	
	for(i=0;i<lineasDeOperacion.length;i++){		
		
		if(oid==lineasDeOperacion[i].oidOperacion){
			numero=i;
			break;
		}
	}
	
	for(j=0;j<lineasDeOperacion[numero].lineasOperacion.length;j++){
		listado2.actualizaDat();	

        listado2.insertar([
		j+1
		,lineasDeOperacion[numero].lineasOperacion[j].tipoMovimiento
		,lineasDeOperacion[numero].lineasOperacion[j].codVenta
		,lineasDeOperacion[numero].lineasOperacion[j].codProducto
		,lineasDeOperacion[numero].lineasOperacion[j].descProducto
		,lineasDeOperacion[numero].lineasOperacion[j].uReclamadas
		,lineasDeOperacion[numero].lineasOperacion[j].precioProducto
		,lineasDeOperacion[numero].lineasOperacion[j].precioContable  //incidencia SiCC-20080557
		,lineasDeOperacion[numero].lineasOperacion[j].descuentoUnitario
		,lineasDeOperacion[numero].lineasOperacion[j].uDevueltas
		,lineasDeOperacion[numero].lineasOperacion[j].importeCargo
		,lineasDeOperacion[numero].lineasOperacion[j].importeAbono
		,lineasDeOperacion[numero].lineasOperacion[j].motivoDevolucion
		,lineasDeOperacion[numero].lineasOperacion[j].numLinea
		,lineasDeOperacion[numero].lineasOperacion[j].oidTipoMovimiento
		,lineasDeOperacion[numero].lineasOperacion[j].oidCodigoVenta
		,lineasDeOperacion[numero].lineasOperacion[j].oidCodigoProducto
		,lineasDeOperacion[numero].lineasOperacion[j].montoPerdida
		,lineasDeOperacion[numero].lineasOperacion[j].precioPerdida
		,lineasDeOperacion[numero].lineasOperacion[j].oidOperacion
		,lineasDeOperacion[numero].lineasOperacion[j].oidPosicion

		,lineasDeOperacion[numero].lineasOperacion[j].oidConcurso
		,lineasDeOperacion[numero].lineasOperacion[j].oidNivel
		,lineasDeOperacion[numero].lineasOperacion[j].oidPremio

		/*oidTipoOferta*/           
									 							      				
		]);		
		listado2.actualizaDat();			
	}		
}
 

function onClickAgregar () {

	var objParams = new Object();
	
    objParams.numAtencion = get(FORMULARIO + '.numAtencion');
	objParams.oidNumDocumento = get(FORMULARIO + '.oidNumDocumento');
	objParams.numDocumento = get(FORMULARIO + '.numDocumento');
	objParams.oidCliente = get(FORMULARIO + '.oidCliente');
	objParams.hFechaIngreso = get(FORMULARIO + '.hFechaIngreso');
    var moneda = get(FORMULARIO + '.hMoneda');
	objParams.numeroSecuencialOperacion=contadorOperaciones;
    objParams.controlProductosDevuelve = oControlProductosDevuelve;
    objParams.existeOperacionAnulacion  = existeAnulacion;
    objParams.existeOperacion = existeOperacion;
    objParams.opeAEliminar = get(FORMULARIO + '.hOidsAEliminar');
    var linea0 = "";
    

  //Se parsea todo esto a pedido de S.Satanas

	var xmlDoc = "<?xml version='1.0' encoding='ISO-8859-1' standalone='yes'?>";
	xmlDoc = xmlDoc + "<DOC>";

    if( oDatosPerdida !=undefined && oDatosPerdida !=null ){ //oDatosPerdida !="" &&
        
        for(b=0;b<oDatosPerdida.length;b++){
            //delimLinea="@@";
            //delimColum="||";
			xmlDoc = 	xmlDoc + "<ROW>";

			xmlDoc = xmlDoc + "<CAMPO>"; 
            if(oDatosPerdida[b].oidOperacion != null &&
						oDatosPerdida[b].oidOperacion!=undefined  ){
                xmlDoc = xmlDoc + DrdEscXML(oDatosPerdida[b].oidOperacion);
            }
			xmlDoc = xmlDoc + "</CAMPO>"; 
            
			xmlDoc = xmlDoc + "<CAMPO>"; 
            if(oDatosPerdida[b].oidCliente != null && 
						oDatosPerdida[b].oidCliente!=undefined) {
                xmlDoc = xmlDoc + DrdEscXML(oDatosPerdida[b].oidCliente);
            }
			xmlDoc = xmlDoc + "</CAMPO>"; 

			xmlDoc = xmlDoc + "<CAMPO>"; 
            if(oDatosPerdida[b].oidAsumePerdida != null && 
						oDatosPerdida[b].oidAsumePerdida!=undefined) {
                xmlDoc = xmlDoc + DrdEscXML(oDatosPerdida[b].oidAsumePerdida);
            }
			xmlDoc = xmlDoc + "</CAMPO>"; 
            
			xmlDoc = xmlDoc + "<CAMPO>"; 
            if(oDatosPerdida[b].precioCalculo != null && 
						oDatosPerdida[b].precioCalculo!=undefined) {
                xmlDoc = xmlDoc + DrdEscXML(oDatosPerdida[b].precioCalculo);
            }
			xmlDoc = xmlDoc + "</CAMPO>"; 
            
			xmlDoc = xmlDoc + "<CAMPO>"; 
            if(oDatosPerdida[b].porcentajeRecargo != null && 
						oDatosPerdida[b].porcentajeRecargo!=undefined){
                xmlDoc = xmlDoc + DrdEscXML(oDatosPerdida[b].precioCalculo);
            }
			xmlDoc = xmlDoc + "</CAMPO>"; 
            
			xmlDoc = xmlDoc + "<CAMPO>"; 
            if(oDatosPerdida[b].oidProductoSeguro != null && 
							oDatosPerdida[b].oidProductoSeguro!=undefined) {
                xmlDoc = xmlDoc + DrdEscXML(oDatosPerdida[b].oidProductoSeguro);
            }
			xmlDoc = xmlDoc + "</CAMPO>"; 
            
			xmlDoc = xmlDoc + "<CAMPO>"; 
            if(oDatosPerdida[b].oidClienteSeguro != null && 
							oDatosPerdida[b].oidClienteSeguro!=undefined) {
                xmlDoc = xmlDoc + DrdEscXML(oDatosPerdida[b].oidClienteSeguro);
            }
			xmlDoc = xmlDoc + "</CAMPO>"; 
            
			xmlDoc = xmlDoc + "<CAMPO>"; 
            if(oDatosPerdida[b].importeSeguro != null && 
							oDatosPerdida[b].importeSeguro!=undefined) {
                xmlDoc = xmlDoc + DrdEscXML(oDatosPerdida[b].importeSeguro);
            }            
			xmlDoc = xmlDoc + "</CAMPO>"; 
			xmlDoc = xmlDoc + "</ROW>"; 
           
        }
       
    }
 
     xmlDoc = xmlDoc + "</DOC>"; 
	objParams.datosDePerdida = xmlDoc;


	
    if(existeAnulacion!="true"){
     var datosRetorno = mostrarModalSICC('LPOperacionReclamos', 'agregar operacion', objParams, null, null); 
	

        if(datosRetorno!=undefined){
            oControlProductosDevuelve = datosRetorno.controlProductosDevuelve;
            oDatosPerdida = datosRetorno.operacionesPerdida;
            existeOperacion = datosRetorno.existeOperacion;
            existeAnulacion = datosRetorno.existeOperacionAnulacion;
            oLineas=new Object();
            oLineas.oidOperacion=contadorOperaciones;
            oLineas.lineasOperacion=datosRetorno.datosLista;
            lineasDeOperacion.push(oLineas);
            
        /*
                Object.operacionesPerdida = ArrayList de objetos del sig. formato:
                ObjetoPerdida.oidOperacion
                ObjetoPerdida.oidCliente
                ObjetoPerdida.oidAsumePerdida
                ObjetoPerdida.precioCalculodatoLinea
                ObjetoPerdida.porcentajeRecargo
                ObjetoPerdida.oidProductoSegurogenera
                ObjetoPerdida.oidClienteSeguro
                ObjetoPerdida.importeSeguro 
            */
            /*
          datosRetorno.numAtencion es comun
          datosRetorno.oidCliente  es comun
          datosRetorno.codOper
          datosRetorno.codTipoOper
          datosRetorno.numSecOper
          datosRetorno.oidNumDocumento
          datosRetorno.montoPerdida
          datosRetorno.uReclamadas
          datosRetorno.uDevueltas
          datosRetorno.totalCargo
          datosRetorno.totalAbono
          datosRetorno.oidMotivoBloqueo
          datosRetorno.oidEstadoOperacion
          datosRetorno.tipoBloqueo
          datosRetorno.motivoBloq		
    
            Object.oidOpSeleccionada = Oid Operacion
            Object.descRetorno = Desc. Operacion
            Object.oidTipoOpSeleccionada = Oid Tipo Operacion
            Object.oidMotivoBloqueo = Oid Motivo Bloqueo
            Object.chequeoFisico = Chequeo Fisico.
            */

            objDatosBloqueo=new Object();
            objDatosBloqueo = datosRetorno.datosBloqueo;
            objOperacionesPerdida=new Object();
            objOperacionesPerdida=datosRetorno.operacionesPerdida[contadorOperaciones-1];
            
            var oidAsumePerdida = "null";
            var oPrecioCalculo = "null";
            var porcentajeRecargo="null";
            var oidProductoSeguro="null";
            var oidClienteSeguro ="null";
            var importeSeguro ="null";
            var oidClieAsumePerdida ="null";
            if(objOperacionesPerdida!=null){
                oidAsumePerdida  = objOperacionesPerdida.oidAsumePerdida;
                oPrecioCalculo = objOperacionesPerdida.precioCalculo
                porcentajeRecargo = objOperacionesPerdida.porcentajeRecargo
                oidProductoSeguro =objOperacionesPerdida.oidProductoSeguro
                oidClienteSeguro = objOperacionesPerdida.oidClienteSeguro
                importeSeguro = objOperacionesPerdida.importeSeguro 
                oidClieAsumePerdida =  objOperacionesPerdida.oidCliente
            }
            
            /*
            set(FORMULARIO+".hTotalEnvia",totalEnvia);
        set(FORMULARIO+".hTotalDevuelve",totalDevuelve);
        set(FORMULARIO+".hSaldoPagar",saldoPagar);*/
      
          /*Object.oidOpSeleccionada = Oid Operacion
                Object.descRetorno = Desc. Operacion
                Object.oidTipoOpSeleccionada = Oid Tipo Operacion
                Object.oidMotivoBloqueo = Oid Motivo Bloqueo
                Object.chequeoFisico = Chequeo Fisico.
    
            /* Operaciones Perdida */ /*
            Object.operacionesPerdida = ArrayList de objetos del sig. formato:
    
                ObjetoPerdida.oidCliente
                ObjetoPerdida.oidAsumePerdida
                ObjetoPerdida.precioCalculo
                ObjetoPerdida.porcentajeRecargo
                ObjetoPerdida.oidProductoSeguro
                ObjetoPerdida.oidClienteSeguro
                ObjetoPerdida.importeSeguro 
            */
            listado1.actualizaDat();	
    
            listado1.insertar([
            contadorOperaciones  
            ,datosRetorno.codOperacion
            ,datosRetorno.codTipoOperacion
            ,contadorOperaciones
            ,datosRetorno.descRetorno  /* se introduce por incidencia 21602 */
            ,datosRetorno.numDocumento 
            ,moneda      		      
            ,objDatosBloqueo.oidMotivoBloqueo
            ,objDatosBloqueo.tipoBloqueo		
            ,datosRetorno.oidTipoOpSeleccionada  
            ,datosRetorno.oidOpSeleccionada  /*perdida */
            ,oidAsumePerdida
            ,oPrecioCalculo
            ,porcentajeRecargo
            ,oidProductoSeguro
            ,oidClienteSeguro
            ,importeSeguro 
            ,oidClieAsumePerdida
            ,datosRetorno.oidNumDocumento
            ,""
            ,""
            ]);
            
    
        while(listado2.datos.length>0){
          listado2.eliminar(0);	
          listado2.actualizaDat();
        }
        /*
          objLineaOperacion.numLinea  -
          objLineaOperacion.tipoMovimiento -
          objLineaOperacion.oidTipoMovimiento
          objLineaOperacion.codVenta -
          objLineaOperacion.codProducto -
          objLineaOperacion.descProducto -
          objLineaOperacion.uReclamadas -
          objLineaOperacion.motivoDevolucion -
          objLineaOperacion.oidMotivoDevolucion 
          objLineaOperacion.precioProducto - 
          objLineaOperacion.importeCargo -
          objLineaOperacion.importeAbono -
          objLineaOperacion.uDevueltas -
          objLineaOperacion.oidCodigoVenta -
          objLineaOperacion.oidCodigoProducto -
          objLineaOperacion.montoPerdida -
          objLineaOperacion.descuentoUnitario -
        */
        
        for(j=0;j<datosRetorno.datosLista.length;j++){
          datosRetorno.datosLista[j].oidOperacion = datosRetorno.oidOpSeleccionada;
          if(datosRetorno.datosLista[j].descuentoUnitario == 'null' ){
            datosRetorno.datosLista[j].descuentoUnitario = '0.0' ; 
          }
                listado2.actualizaDat();	
                listado2.insertar([
          j+1			
          ,datosRetorno.datosLista[j].tipoMovimiento
          ,datosRetorno.datosLista[j].codVenta
          ,datosRetorno.datosLista[j].codProducto
          ,datosRetorno.datosLista[j].descProducto 
          ,datosRetorno.datosLista[j].uReclamadas
          ,datosRetorno.datosLista[j].precioProducto
          ,datosRetorno.datosLista[j].precioContable  //incidencia SiCC-20080557
          ,datosRetorno.datosLista[j].descuentoUnitario
          ,datosRetorno.datosLista[j].uDevueltas
          ,datosRetorno.datosLista[j].importeCargo
          ,datosRetorno.datosLista[j].importeAbono
          ,datosRetorno.datosLista[j].motivoDevolucion
          ,datosRetorno.datosLista[j].numLinea		
          ,datosRetorno.datosLista[j].oidTipoMovi 			
          ,datosRetorno.datosLista[j].oidCodigoVenta  
          ,datosRetorno.datosLista[j].oidCodigoProducto 
          ,datosRetorno.datosLista[j].montoPerdida 
          ,datosRetorno.datosLista[j].precioCalculo
          ,datosRetorno.datosLista[j].oidOperacion
		  ,datosRetorno.datosLista[j].oidPosicion
		  ,datosRetorno.datosLista[j].oidConcurso
          ,datosRetorno.datosLista[j].oidNivel
		  ,datosRetorno.datosLista[j].oidPremio
          ]);	
                
            }
            
        contadorOperaciones++;	

              calculaTotales();

        }   
    }else{
        GestionarMensaje('REC028');
    }
}

function generaDatosMatrizReclamo(){
	//delimLinea
	//delimColum

	var cabecera="";
	var detalles="";
	var lineas=listado1.datos.length;
	var columnas=listado1.datos[0].length;	
	for(i=0;i<lineas;i++){
		if(i!=0){
			cabecera=cabecera+delimLinea;
		}
		for(j=0;j<columnas;j++){
			if(listado1.datos[i][j]==""){
				if(j==0){
					cabecera=cabecera+"_";										
				}else{
					cabecera=cabecera+delimColum+"_";
				}
			}else{
				if(j==0){
					cabecera=cabecera+listado1.datos[i][j];
				}else{
					cabecera=cabecera+delimColum+listado1.datos[i][j];
				}
			
			}
		}
		
	}
		/*		objLineaOperacion.numLinea  -
			objLineaOperacion.tipoMovimiento -
			objLineaOperacion.oidTipoMovimiento
			objLineaOperacion.codVenta -
			objLineaOperacion.codProducto -
			objLineaOperacion.descProducto -
			objLineaOperacion.uReclamadas -
			objLineaOperacion.motivoDevolucion -
			objLineaOperacion.oidMotivoDevolucion 
			objLineaOperacion.precioProducto - 
			objLineaOperacion.importeCargo -
			objLineaOperacion.importeAbono -
			objLineaOperacion.uDevueltas -
			objLineaOperacion.oidCodigoVenta -
			objLineaOperacion.oidCodigoProducto -
			objLineaOperacion.montoPerdida -
			objLineaOperacion.descuentoUnitario -
		*/
    for(i=0;i<lineasDeOperacion.length;i++){
		
        
		for(j=0;j<lineasDeOperacion[i].lineasOperacion.length;j++){	
				 						
			detalles=detalles+lineasDeOperacion[i].oidOperacion; 
			
			var temp=new String(lineasDeOperacion[i].lineasOperacion[j].tipoMovimiento);
			if(temp!=""){
				detalles=detalles+delimColum+temp;
			}else{
				detalles=detalles+delimColum+"_";
			}
			
			temp=new String(lineasDeOperacion[i].lineasOperacion[j].codVenta);
			if(temp!=""){
				detalles=detalles+delimColum+temp;
			}else{
				detalles=detalles+delimColum+"_";
			}

			temp=new String(lineasDeOperacion[i].lineasOperacion[j].codProducto);
			if(temp!=""){
				detalles=detalles+delimColum+temp;
			}else{
				detalles=detalles+delimColum+"_";
			}

			temp=new String(lineasDeOperacion[i].lineasOperacion[j].descProducto);
			if(temp!=""){
				detalles=detalles+delimColum+temp;
			}else{
				detalles=detalles+delimColum+"_";
			}
			
			temp=new String(lineasDeOperacion[i].lineasOperacion[j].uReclamadas);
			//agregado por mamontie 14/11/05 inc bloqueante
			temp=quitarSeparadorMiles(temp,get(FORMULARIO+".hid_SeparadorMiles"),get(FORMULARIO+".hid_SeparadorDecimales"));
			if(temp!=""){
				detalles=detalles+delimColum+temp;
			}else{
				detalles=detalles+delimColum+"_";
			}
			//quitarSeparadorMiles(cantidad, separadorMiles,separadorDecimales)
			
			temp=new String(lineasDeOperacion[i].lineasOperacion[j].precioProducto);
			temp=quitarSeparadorMiles(temp,get(FORMULARIO+".hid_SeparadorMiles"),get(FORMULARIO+".hid_SeparadorDecimales"));

			if(temp!=""){
				detalles=detalles+delimColum+temp;
			}else{
				detalles=detalles+delimColum+"_";
			}

			temp=new String(lineasDeOperacion[i].lineasOperacion[j].descuentoUnitario);
			if(temp!=""){
				detalles=detalles+delimColum+temp;
			}else{
				detalles=detalles+delimColum+"_";
			}

			temp=new String(lineasDeOperacion[i].lineasOperacion[j].uDevueltas);
			//agregado por mamontie 14/11/05 inc bloqueante
			temp=quitarSeparadorMiles(temp,get(FORMULARIO+".hid_SeparadorMiles"),get(FORMULARIO+".hid_SeparadorDecimales"));

			if(temp!=""){
				detalles=detalles+delimColum+temp;
			}else{
				detalles=detalles+delimColum+"_";
			}

			temp=new String(lineasDeOperacion[i].lineasOperacion[j].importeCargo);
			temp=quitarSeparadorMiles(temp,get(FORMULARIO+".hid_SeparadorMiles"),get(FORMULARIO+".hid_SeparadorDecimales"));
			if(temp!=""){
				detalles=detalles+delimColum+temp;
			}else{
				detalles=detalles+delimColum+"_";
			}

			temp=new String(lineasDeOperacion[i].lineasOperacion[j].importeAbono);

			temp=quitarSeparadorMiles(temp,get(FORMULARIO+".hid_SeparadorMiles"),get(FORMULARIO+".hid_SeparadorDecimales"));
			if(temp!=""){
				detalles=detalles+delimColum+temp;
			}else{
				detalles=detalles+delimColum+"_";
			}

			temp=new String(lineasDeOperacion[i].lineasOperacion[j].motivoDevolucion);
			if(temp!=""){
				detalles=detalles+delimColum+temp;
			}else{
				detalles=detalles+delimColum+"_";
			}

			temp=new String(lineasDeOperacion[i].lineasOperacion[j].numLinea);
			if(temp!=""){
				detalles=detalles+delimColum+temp;
			}else{
				detalles=detalles+delimColum+"_";
			}

			temp=new String(lineasDeOperacion[i].lineasOperacion[j].oidTipoMovimiento);
			if(temp!=""){
				detalles=detalles+delimColum+temp;
			}else{
				detalles=detalles+delimColum+"_";
			}
			
			temp=new String(lineasDeOperacion[i].lineasOperacion[j].oidCodigoVenta);				
			if(temp!=""){
				detalles=detalles+delimColum+temp;
			}else{
				detalles=detalles+delimColum+"_";
			}

			temp=new String(lineasDeOperacion[i].lineasOperacion[j].oidCodigoProducto);					
			if(temp!=""){
				detalles=detalles+delimColum+temp;
			}else{
				detalles=detalles+delimColum+"_";
			}

			temp=new String(lineasDeOperacion[i].lineasOperacion[j].montoPerdida);			
			if(temp!=""){
				detalles=detalles+delimColum+temp;
			}else{
				detalles=detalles+delimColum+"_";
			}

			temp=new String(lineasDeOperacion[i].lineasOperacion[j].precioPerdida);			
			if(temp!=""){
				detalles=detalles+delimColum+temp;
			}else{
				detalles=detalles+delimColum+"_";
			}

			temp=new String(lineasDeOperacion[i].lineasOperacion[j].oidOperacion);
			if(temp!=""){
				detalles=detalles+delimColum+temp;
			}else{
				detalles=detalles+delimColum+"_";
			}
							
			temp=new String(lineasDeOperacion[i].lineasOperacion[j].oidTipoOferta);
			if(temp!=""){
				detalles=detalles+delimColum+temp;
			}else{
				detalles=detalles+delimColum+"_";
			}
			

			temp=new String(lineasDeOperacion[i].lineasOperacion[j].oidMotivoDevolucion);
			if(temp!=""){
				detalles=detalles+delimColum+temp;
			}else{
				detalles=detalles+delimColum+"_";
			}
						
			temp=new String(lineasDeOperacion[i].lineasOperacion[j].oidPosicion);
			if(temp!=""){
				detalles=detalles+delimColum+temp;
			}else{
				detalles=detalles+delimColum+"_";
			}
			temp=new String(lineasDeOperacion[i].lineasOperacion[j].oidConcurso);
			if(temp!=""){
				detalles=detalles+delimColum+temp;
			}else{
				detalles=detalles+delimColum+"_";
			}
			temp=new String(lineasDeOperacion[i].lineasOperacion[j].oidNivel);
			if(temp!=""){
				detalles=detalles+delimColum+temp;
			}else{
				detalles=detalles+delimColum+"_";
			}
			temp=new String(lineasDeOperacion[i].lineasOperacion[j].oidPremio);
			if(temp!=""){
				detalles=detalles+delimColum+temp;
			}else{
				detalles=detalles+delimColum+"_";
			}

			temp=new String(lineasDeOperacion[i].lineasOperacion[j].precioContable);
			temp=quitarSeparadorMiles(temp,get(FORMULARIO+".hid_SeparadorMiles"),get(FORMULARIO+".hid_SeparadorDecimales"));

			if(temp!=""){
				detalles=detalles+delimColum+temp;
			}else{
				detalles=detalles+delimColum+"_";
			}

			if(((j+1)<lineasDeOperacion[i].lineasOperacion.length)||((i+1)<lineasDeOperacion.length)){
				detalles=detalles+delimLinea;
			}
			
		}
	}

    //alert("cabecera "+cabecera);
   //alert("detalle "+detalles);

	set(FORMULARIO+'.hMatrizReclamoCabeceras',cabecera);
	set(FORMULARIO+'.hMatrizReclamoDetalles',detalles);			
}
var idenListadoOper=0;



function onClickGenerar () {
	// Mejora SiCC 20070534 - dmorello, 12/02/2008
    document.all["GenSol"].disabled = true;

	if(get(FORMULARIO + '.hReclamoBloq')!="true"){
        var ok=false;
        for(i=0;i<lineasDeOperacion.length;i++){				
            if(lineasDeOperacion[i].lineasOperacion.length>0){
                ok=true;
                break;
            }
        }
        if(!ok){
            // Modificado por ssantana, 25/10/2005. Inc.  BELC300021263.
            // El codigo de mensaje estaba repetido en el fichero de mensajes.es.
            GestionarMensaje('REC050'); //La operación no tiene líneas de operación asociadas
			// Mejora SiCC 20070534 - dmorello, 12/02/2008
			document.all["GenSol"].disabled = false;
            return;
            
        }
        
        frmContenido.oculto='S';
        set(FORMULARIO + '.accion','generar_solicitudes');
        set(FORMULARIO + '.conectorAction',"LPReclamosEnLinea");
        enviaSICC(FORMULARIO);
		// Mejora SiCC 20070534 - dmorello, 12/02/2008
		//fVolver();
	}
}

function validaNumReclamo(){
	
	if(ValidaCaracteres(get(FORMULARIO+'.txtNReclamo'),'0123456789')!='OK'){
		cdos_mostrarAlert(DrdMsgCore(143)+'0123456789');
		focaliza(FORMULARIO+'.txtNReclamo');		
	}
}


function fGuardar () {	
	
  if(!sicc_validaciones_generales()){
        return;
  }

  if(listado1.datos.length<1){
		GestionarMensaje('REC014');
		return;
  }

  //18586  
    generaDatosMatrizReclamo();

    frmContenido.oculto='S';
    set(FORMULARIO + '.accion','guardar');
    set(FORMULARIO + '.conectorAction',"LPReclamosEnLinea");

    
    enviaSICC(FORMULARIO);

}


function fLimpiar() {
	set(FORMULARIO + '.txtCodCliente', "");
	set(FORMULARIO + '.txtNumeroDocumento',"");
	set(FORMULARIO + '.txtNombre', "");
	set(FORMULARIO + '.txtApellidoPaterno', "");
	set(FORMULARIO + '.txtApellidoMaterno', "");
	ocultaLista();
}

function gestionFocoBuscar(){

	if (paginaOculta) {         
		focaliza(FORMULARIO+'.txtCodCliente');
	}else {		
		focaliza(FORMULARIO+'.txtNReclamo');		
	}	
	
}

function ontabPag(){
	if (!get_visibilidad("GenSol")) {         
		focaliza(FORMULARIO+'.txtCodCliente');
	}else {
	
	}
}

function onshtabCliente() {
	document.body.focus();
	if (paginaOculta) {   
		 document.all['btnBuscar'].focus();
	} else {
		if (document.all['GenSol'].disabled) {
			if (document.all['Bloquear'].disabled)
				document.all['ConsRec'].focus();
			else
				document.all['Bloquear'].focus();	
		} else {
			document.all['GenSol'].focus();
		}
	}	
}

function gestionFocoBloquear(){
	if (document.all['GenSol'].disabled)
		focaliza(FORMULARIO + '.txtCodCliente');	
	else
		document.all['GenSol'].focus();
}

function gestionFocoConsRec(){

		if (document.all['GenSol'].disabled)
			focaliza(FORMULARIO + '.txtCodCliente');
		else
			document.all['GenSol'].focus();
}

function mostrarLista() { 
	
	DrdEnsanchaConMargenDcho('listado1',24); 
	DrdEnsanchaConMargenDcho('listado2',24); 
	
	document.all["Cplistado1"].style.visibility='visible'; 
	document.all["CpLin1listado1"].style.visibility='visible'; 
	document.all["CpLin2listado1"].style.visibility='visible'; 
	document.all["CpLin3listado1"].style.visibility='visible'; 
	document.all["CpLin4listado1"].style.visibility='visible'; 
	document.all["Cplistado2"].style.visibility='visible'; 
	document.all["CpLin1listado2"].style.visibility='visible'; 
	document.all["CpLin2listado2"].style.visibility='visible'; 
	document.all["CpLin3listado2"].style.visibility='visible'; 
	document.all["CpLin4listado2"].style.visibility='visible'; 
	
	document.all["primera1Div"].style.visibility='visible'; 
	document.all["ret1Div"].style.visibility='visible'; 
	document.all["ava1Div"].style.visibility='visible'; 
	document.all["separa1Div"].style.visibility='visible'; 
	document.all["primera2Div"].style.visibility='visible'; 
	document.all["ret2Div"].style.visibility='visible'; 
	document.all["ava2Div"].style.visibility='visible'; 
	document.all["separa2Div"].style.visibility='visible'; 
	
	
	document.all["AgregarDiv"].style.visibility='visible'; 
	document.all["btnDetalleDiv"].style.visibility='visible'; 
	
	document.all["ocultarAbajo"].style.visibility='visible'; 
	document.all["botonesAbajo"].style.visibility='visible'; 
	
	setTimeout('eval (ON_RSZ);',200);
	paginaOculta=false;
	
}            


function ocultaLista() { 
		
	DrdEnsanchaConMargenDcho('listado1',24); 
	DrdEnsanchaConMargenDcho('listado2',24); 
	
	document.all["Cplistado1"].style.visibility='hidden'; 
	document.all["CpLin1listado1"].style.visibility='hidden'; 
	document.all["CpLin2listado1"].style.visibility='hidden'; 
	document.all["CpLin3listado1"].style.visibility='hidden'; 
	document.all["CpLin4listado1"].style.visibility='hidden'; 
	document.all["Cplistado2"].style.visibility='hidden'; 
	document.all["CpLin1listado2"].style.visibility='hidden'; 
	document.all["CpLin2listado2"].style.visibility='hidden'; 
	document.all["CpLin3listado2"].style.visibility='hidden'; 
	document.all["CpLin4listado2"].style.visibility='hidden'; 
	
	document.all["primera1Div"].style.visibility='hidden'; 
	document.all["ret1Div"].style.visibility='hidden'; 
	document.all["ava1Div"].style.visibility='hidden'; 
	document.all["separa1Div"].style.visibility='hidden'; 
	document.all["primera2Div"].style.visibility='hidden'; 
	document.all["ret2Div"].style.visibility='hidden'; 
	document.all["ava2Div"].style.visibility='hidden'; 
	document.all["separa2Div"].style.visibility='hidden'; 
	
	document.all["btnDetalleDiv"].style.visibility='hidden'; 	
	document.all["AgregarDiv"].style.visibility='hidden'; 
	document.all["ocultarAbajo"].style.visibility='hidden'; 
	document.all["botonesAbajo"].style.visibility='hidden'; 
    
    setTimeout('eval (ON_RSZ);',200);
	paginaOculta=true;
} 

function onclickConsultaReclamo(){
	//mostrarModalSICC('LPConsultarReclamo','', objParams, null, null);

	var objParams = new Object();

	objParams.accion = 'consultar reclamo';
	objParams.txtCodigoCliente = get(FORMULARIO + '.hLblCodClienteX');

	mostrarModalSICC('LPConsultarInforme', 'consultar reclamo', objParams, null, null);
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
                           resultado=resultado+"."+decimales;
                  }
         }

         return resultado;
}         

function codigoClienteOnBlur() {
          var codigoCliente = get(FORMULARIO+'.txtCodCliente');
          if (codigoCliente != '') {
                    var longitudCodigoCliente = get(FORMULARIO+'.tamanio');
                    var longitud = codigoCliente.length;
                    
                    set(FORMULARIO+'.txtCodCliente',rellenaCeros(codigoCliente,longitudCodigoCliente,longitud));
          }
}

function validaNumDocumento(){
	
	if(ValidaCaracteres(get(FORMULARIO+'.txtNumeroDocumento'),'0123456789')!='OK'){
		cdos_mostrarAlert(DrdMsgCore(143)+'0123456789');
		focaliza(FORMULARIO+'.txtNumeroDocumento');		
	}
}

function mostrarClienteReclamos(oid) {
	objeto=new Object();
	objeto.txtCodCliente=get(FORMULARIO+'.txtCodCliente');
	objeto.txtNumeroDocumento=get(FORMULARIO+'.txtNumeroDocumento');
	objeto.txtNombre=get(FORMULARIO+'.txtNombre');
	objeto.txtApellidoPaterno=get(FORMULARIO+'.txtApellidoPaterno');
	objeto.txtApellidoMaterno=get(FORMULARIO+'.txtApellidoMaterno');
	
	if (oid == ''){
		objeto.oidCliente = '';
	} else {
		objeto.oidCliente = oid;
	}
	dato = mostrarModalSICC('LPReclamosEnLinea', 'buscar_cliente2', objeto, null, null);

	if (dato!=undefined){	
		limpiaPantalla();								
		set(FORMULARIO + ".hCanal",dato.canal);
		set(FORMULARIO + ".hAcceso",dato.acceso);
		set(FORMULARIO + ".hSubAcceso",dato.subAcceso);			
		set(FORMULARIO + ".oidCliente",dato.oidCliente);
		set(FORMULARIO + ".oidNumDocumento",dato.oidDocumento);
		set(FORMULARIO + ".numDocumento",dato.codigoOperacion);
		set(FORMULARIO + ".oidPeriodo",dato.oidPeriodo);			
		set(FORMULARIO + ".oidTerriAdmin",dato.oidTerriAdmin);
		
		txt_to("lblNDocX",dato.codigoOperacion);			
		txt_to("lblCodClienteX",dato.codigoCliente);
		txt_to("lblNombreApellidosX",dato.nombreApellidos);
		txt_to("lblNumeroZonaX",dato.numeroZona);
		txt_to("lblEstadoClienteX",dato.estadoCliente);  

		frmContenido.oculto='S';
		set(FORMULARIO + '.accion','buscar_numero_doc');
		set(FORMULARIO + '.conectorAction',"LPReclamosEnLinea");
		enviaSICC(FORMULARIO);			
		
    }else{
        limpiaPantalla();
        ocultaLista();
    }
	
	
}

function onClickBuscar(){
      ocultaLista();
	  if (casoDeUso!="modificar"){
		document.all['GenSol'].disabled=true;
	  }
	  var txtCodCliente=get(FORMULARIO+'.txtCodCliente');    
      var txtNumeroDocumento=get(FORMULARIO+'.txtNumeroDocumento');
      var txtNombre=get(FORMULARIO+'.txtNombre');
      var txtApellidoPaterno=get(FORMULARIO+'.txtApellidoPaterno');
      var txtApellidoMaterno=get(FORMULARIO+'.txtApellidoMaterno');
	
  	if ((txtCodCliente!='')||(txtNumeroDocumento!='')||(txtNombre!='')||(txtApellidoPaterno!='')||(txtApellidoMaterno!='')){ 
        frmContenido.oculto='S';
        set(FORMULARIO + '.accion','buscar_cliente');
        set(FORMULARIO + '.conectorAction',"LPReclamosEnLinea");
	
        enviaSICC(FORMULARIO);
    }else{
        GestionarMensaje('REC009');
        focaliza(FORMULARIO+'.txtCodCliente');
    }
	
}

function mostrarReclamo(cadena){
    valores = cadena.split("@@"); 
    limpiaPantalla();								
    set(FORMULARIO + ".hCanal",valores[0]);
    set(FORMULARIO + ".hAcceso",valores[1]);
    set(FORMULARIO + ".hSubAcceso",valores[2]);			
    set(FORMULARIO + ".oidCliente",valores[3]);
    set(FORMULARIO + ".oidNumDocumento",valores[4]);
    set(FORMULARIO + ".numDocumento",valores[5]);
    set(FORMULARIO + ".oidPeriodo",valores[6]);			
    set(FORMULARIO + ".oidTerriAdmin",valores[7]);

	set(FORMULARIO + ".hLblCodClienteX",valores[9]);
    
	txt_to("lblNDocX",valores[8]);			
    txt_to("lblCodClienteX",valores[9]);
    txt_to("lblNombreApellidosX",valores[10]);
    txt_to("lblNumeroZonaX",valores[11]);
    txt_to("lblEstadoClienteX",valores[12]);  
    
    set(FORMULARIO + ".hMoneda",valores[13]);
	//set(FORMULARIO + ".hReclamoBloq",valores[15]); 
    frmContenido.oculto='S';

        vueltaNumDocumento(valores[16])
        set('frmContenido.txtNReclamo', valores[14] );
        accion("frmContenido.txtNReclamo", ".disabled=true");    

	//	Agregado por HRCS - Fecha 10/03/2007 - SICC-GCC-REC-007-Periodo de Reclamo_V3
	var arrayN = valores[17].split(",");
	set('frmContenido.cbPeriodoRec', arrayN );
}

function modificarReclamo(){
        mostrarReclamo(get(FORMULARIO+".hVModificar"));
        listado1.alternaVerColumna(19,true,true);
        listado1.actualizaDat();
        cargaModificacion('modificar');
        existeAnulacion = get(FORMULARIO + ".hExisteAnulacion");
        existeOperacion = get(FORMULARIO + ".hExisteOperacion")
        btnProxy(2,1);	
        btnProxy(3,0); 
        btnProxy(5,0);
        /********        oLineas=new Object();
		oLineas.oidOperacion=contadorOperaciones;
		oLineas.lineasOperacion=datosRetorno.datosLista;
		lineasDeOperacion.push(oLineas);*/

}
function consultarReclamo(){

        //mostrarReclamo(get(FORMULARIO+".hVModificar"));
		mostrarReclamoConsulta (get(FORMULARIO+".hVModificar"));
		setTimeout ('alternaColumnaConsulta();',200);
        cargaModificacion('consulta');
}


function mostrarReclamoConsulta(cadena){
    valores = cadena.split("@@");    
	txt_to("lblNDocX",valores[8]);			
    txt_to("lblCodClienteX",valores[9]);
    txt_to("lblNombreApellidosX",valores[10]);
    txt_to("lblNumeroZonaX",valores[11]);
    txt_to("lblEstadoClienteX",valores[12]);  
    
    set(FORMULARIO + ".hMoneda",valores[13]);
    vueltaNumDocumento(valores[14])
    set('frmContenido.txtNReclamo', valores[14] );
    setTimeout('accion("frmContenido.txtNReclamo", ".disabled=true");',200);
    
	//	Agregado por HRCS - Fecha 09/03/2007 - SICC-GCC-REC-007-Periodo de Reclamo_V3
	combo_add('frmContenido.cbPeriodoRec', valores[16], valores[17]);
	var arrayN = valores[16].split(",");
	set('frmContenido.cbPeriodoRec', arrayN );
	setTimeout('accion("frmContenido.cbPeriodoRec", ".disabled=true");',200);
}

function alternaColumnaConsulta(){
		listado1.alternaVerColumna(20,true,true);        
		listado1.alternaVerColumna(21,true,true);
		listado1.alternaVerColumna(22,true,true);
		listado1.alternaVerColumna(23,true,true);
		listado1.alternaVerColumna(24,true,true);
		listado1.alternaVerColumna(25,true,true);
		listado1.alternaVerColumna(26,true,true);
    	listado1.alternaVerColumna(27,true,true);
		listado1.alternaVerColumna(28,true,true);
		listado1.alternaVerColumna(29,true,true);
		listado1.alternaVerColumna(30,true,true);
		listado1.actualizaDat();
}

function cargaModificacion(tipoDeCarga){
            
  /*carga de datos */
  var xLinea = get(FORMULARIO+'.hLinea');
  var xOperacion = get(FORMULARIO+'.hOperacion');
  var moneda;
  if (xOperacion!="") {
    xOperacion = xOperacion.split("@@");
    xLinea = xLinea.split("@@");
   // var lista= new Array();
	var oListado = new Object();
	moneda = get(FORMULARIO + ".hMoneda");
    for (h=0;h<xOperacion.length;h++){
		  var yOperacion = xOperacion[h].split("||");
		  //var datosRR = new Object(); 
		  oLineas =new Object();
		  oLineas.oidOperacion = yOperacion[0];
		  oLineas.lineasOperacion = new Array();
		  //lista.push(oLineas);
		  oListado[yOperacion[0]] = oLineas;				 
		  insertaEnListado1(yOperacion, moneda )
	}// fin for h
	listado1.repinta();            
	
	for (j=0;j<xLinea.length;j++)  {
		var yLinea = xLinea[j].split("||");
	    if (yLinea[0]!= undefined) {
			objLista =new Object();
			armaObjLista (yLinea,objLista);
			if (tipoDeCarga != 'consulta'){
				insertaEnListado2 (objLista,j);
			}			
			oListado[yLinea[12]].lineasOperacion.push(objLista);//incidencia SiCC-20080557
	    } /* Fin si */    
		contadorOperaciones= listado1.codigos().length+1;
		controlAgrego = listado1.codigos().length;
	}  /* Fin for j */ 
    if (tipoDeCarga != 'consulta'){
		listado2.repinta();
	}		  

	/* Modificado por ssantana, 27/06/2006, inc. DBLG500001102
	 Esto estaba adentro del For "j", aparentemente calculaba mal debido a esto */
	for (atributos in oListado ){
	  lineasDeOperacion.push(oListado[atributos]);
	}
	calculaTotales();
   }  /* Fin si xOperacion*/
        
        

}

function insertaEnListado1(yOperacion, moneda ){
listado1.insertar([
	 yOperacion[0]  
	,yOperacion[1]
	,yOperacion[2]
	,yOperacion[3]
	,yOperacion[4]  
	,yOperacion[5] 
	,moneda
	,moneda
	,""
	,""  
	,""
	,""
	,""
	,""
	,""
	,""
	,""
	,""
	,""     //18
	,((yOperacion[6]=='null') ? "": yOperacion[6]) //19
	,yOperacion[7] //20
	,((yOperacion[8]=='null') ? "": yOperacion[8])
	,((yOperacion[9]=='null') ? "": yOperacion[9])
	,((yOperacion[10]=='null')? "": yOperacion[10])
	,((yOperacion[11]=='null')? "": yOperacion[11])
	,((yOperacion[12]=='null')? "": yOperacion[12])
	,((yOperacion[13]=='null')? "": yOperacion[13])
	,((yOperacion[14]=='null')? "": yOperacion[14])
	,((yOperacion[15]=='null')? "": yOperacion[15])
	,((yOperacion[16]=='null')? "": yOperacion[16])
	,((yOperacion[17]=='null')? "": yOperacion[17])
	,((yOperacion[18]=='null')? "": yOperacion[18])
	],true);   
}

function armaObjLista(yLinea, objLista ){
	objLista.tipoMovimiento = yLinea[0];
	objLista.codVenta = "";
	objLista.codProducto = "";
	objLista.descProducto = "";
	objLista.uReclamadas = "";
	objLista.precioProducto = "";
	objLista.precioContable = "";  	//incidencia SiCC-20080557
	objLista.descuentoUnitario = "";
	objLista.uDevueltas = "";
	objLista.importeCargo = "";
	objLista.importeAbono = "";
	objLista.motivoDevolucion = "";
	objLista.numLinea = "";
	objLista.oidTipoMovi = "";
	objLista.oidCodigoVenta = "";
	objLista.oidCodigoProducto = "";
	objLista.montoPerdida = "";
	objLista.precioCalculo = "";
	objLista.oidOperacion = "";
	objLista.oidPosicion = "";

/*	if(yLinea[1]!='null')
	objLista.codVenta = yLinea[1];
	if(yLinea[2]!='null')
	objLista.codProducto = yLinea[2];
	if(yLinea[3]!='null')
	objLista.descProducto = yLinea[3];
	if(yLinea[4]!='null')
	objLista.uReclamadas = yLinea[4];
	if(yLinea[5]!='null')
	objLista.precioProducto = yLinea[5];
	if(yLinea[6]!='null')
	objLista.uDevueltas = yLinea[6];
	if(yLinea[7]!='null')
	objLista.importeCargo = yLinea[7];
	if(yLinea[8]!='null')
	objLista.importeAbono = yLinea[8];			
	if(yLinea[9]!='null')
	objLista.oidOperacion = yLinea[9];

	if(yLinea[11]!='null'){
	 if (casoDeUso=="modificar"){

		objLista.oidPosicion = yLinea[11];
	 }else{

		objLista.montoPerdida = yLinea[11];
	 }
	}*/
  //pzerbino 15/11/2006 Incidencia 24290
  
	if(yLinea[1]!='null')
	objLista.codVenta = yLinea[1];
	if(yLinea[2]!='null')
	objLista.codProducto = yLinea[2];
	if(yLinea[3]!='null')
	objLista.descProducto = yLinea[3];
	if(yLinea[4]!='null')
	objLista.uReclamadas = yLinea[4];
	if(yLinea[5]!='null')
	objLista.precioProducto = yLinea[5];
	if(yLinea[6]!='null')
	objLista.descuentoUnitario = yLinea[6];  
	//incidencia SiCC-20080557
	if(yLinea[7]!='null')
	objLista.precioContable = yLinea[7];  
	if(yLinea[8]!='null')
    objLista.uDevueltas = yLinea[8];
	if(yLinea[9]!='null')
	objLista.importeCargo = yLinea[9];
	if(yLinea[10]!='null')
	objLista.importeAbono = yLinea[10];			
	if(yLinea[12]!='null')
	objLista.oidOperacion = yLinea[12];

	if(yLinea[13]!='null'){
	 if (casoDeUso=="modificar"){

		objLista.oidPosicion = yLinea[13];
	 }else{

		objLista.montoPerdida = yLinea[13];
	 }
	}
}

function insertaEnListado2(objLista, j ){
 listado2.insertar([
	j+1			 
	,objLista.tipoMovimiento
	,objLista.codVenta
	,objLista.codProducto
	,objLista.descProducto 
	,objLista.uReclamadas
	,objLista.precioProducto
	,objLista.precioContable	//incidencia SiCC-20080557
	,objLista.descuentoUnitario
	,objLista.uDevueltas
	,objLista.importeCargo
	,objLista.importeAbono
	,objLista.motivoDevolucion
	,objLista.numLinea		
	,objLista.oidTipoMovi 			
	,objLista.oidCodigoVenta  
	,objLista.oidCodigoProducto 
	,objLista.montoPerdida 
	,objLista.precioCalculo
	,objLista.oidOperacion
	,objLista.oidPosicion
	],true);

}

function fVolver(){
  
  window.close();
}

// Creada por Mejora SiCC 20070534
// dmorello - 12/02/2008
function errorGenerarSolicitudes() {
    document.all["GenSol"].disabled = false;
}
