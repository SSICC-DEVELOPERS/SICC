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
var oControlProductosDevuelve = "";
var paginaOculta=true;
var existeAnulacion = "false";
var existeOperacion = "false";
var chequeoFisico = '';
var esModificacion = "";
var indGuardado = "";
var mOperacion = new Array();
var mLineas = new Array();
var controlAgrego ="";
var reclamosBloq ="";
var totalEnvia=parseFloat("0");
var totalDevuelve=parseFloat("0");
var saldoPagar=parseFloat("0");
//Array de objetos: 
function onLoadPag(){	 
    
    
    txt_to("lblTotalEnviaX",totalEnvia);
    txt_to("lblTotalDevuelveX",totalDevuelve);
    txt_to("lblSaldoAPagarX",saldoPagar);	
    //mostrarLista();		
			
    document.all["GenSol"].disabled = true;
  	document.all["Bloquear"].disabled = true;	
	
	if (get(FORMULARIO+'.errDescripcion')!='') {
		ocultaLista();
		var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'),get(FORMULARIO+'.errDescripcion'));

	}
	configurarMenuSecundario(FORMULARIO);


	 if (window.dialogArguments) { // Si es modal (se abrió mediante showModalDialog) DBLG500000915       
			
			btnProxy(2,1);  // boton 'volver', habilitado
            btnProxy(3,0);  // boton 'Ir a pantalla de inicio', deshabilitado
			ModificarToolbar();

    }

      focaliza(FORMULARIO+'.txtCodCliente');	
      set(FORMULARIO+".hTotalEnvia",totalEnvia);
      set(FORMULARIO+".hTotalDevuelve",totalDevuelve);
      set(FORMULARIO+".hSaldoPagar",saldoPagar);

}

/*
	Esta funcion se encarga de configurar la botonera, cuando se 
	la pagina es modal.Para eso se modifica la variable oculta 	
	SICC_TOOLBAR_CONFIG	  
	que viene por defecto para indicar la configuracion del menu.
*/
function ModificarToolbar(){

		//obtengo el String con la configuracion a aplicar
		var strCodigos = get(FORMULARIO+".SICC_TOOLBAR_CONFIG");

		/*Dentro del SICC_TOOLBAR_CONFIG, luego del segundo espacio en blanco, 
		 se encuentra la informacion sobre el ícono volver */
		 
		pos = strCodigos.indexOf(" ");
		pos = strCodigos.indexOf(" ",pos+1);
		pos= pos+2;
		//activo el boton volver
		strCodigos= setCharAt(strCodigos, pos, '1') ;
		
		/*La cuarte posicion del string  SICC_TOOLBAR_CONFIG 
		  (es decir luego del tercer espacio en blanco) contiene la informacion
		   sobre el icono inicio
		*/
		pos = strCodigos.indexOf(" ",pos);	
		pos = pos +2;
		//desactivo el boton inicio
		strCodigos= setCharAt(strCodigos, pos, '0') ;

		set(FORMULARIO+".SICC_TOOLBAR_CONFIG",strCodigos);
	
	}

	function setCharAt(str, index, ch) {
		return str.substr(0, index - 1) + ch + str.substr(index);
	}

function vaciaSolicitudes(){
	
	frmContenido.oculto='N';
       	fLimpiarGenericoSICC();
       	
        limpiaPantalla();
        ocultaLista();
	document.all["GenSol"].disabled=true;
        focaliza(FORMULARIO+'.txtCodCliente');
	btnProxy(1,1);	
	btnProxy(4,1);	       
}


function vaciaGuardar(){
	
	frmContenido.oculto='N';	
		
	btnProxy(1,0);	
	btnProxy(4,0);
  indGuardado = "true";
	
  if(get(FORMULARIO + '.cbMotivoBloqueo')!=''){
      document.all["Bloquear"].disabled = false;	
  }else{
      document.all["GenSol"].disabled = false;
  }

   calculaTotales();
}

function calculaTotales() {
  
    totalEnvia=parseFloat(0);
    totalDevuelve=parseFloat(0);
    
    for(h=0;h<lineasDeOperacion.length;h++){
        for(j=0;j<lineasDeOperacion[h].lineasOperacion.length;j++){
          totalEnvia=parseFloat(totalEnvia)+parseFloat(quitarSeparadorMiles(lineasDeOperacion[h].lineasOperacion[j].importeCargo,get(FORMULARIO+".hid_SeparadorMiles"),get(FORMULARIO+".hid_SeparadorDecimales")));		 
          totalDevuelve=parseFloat(totalDevuelve)+parseFloat(quitarSeparadorMiles(lineasDeOperacion[h].lineasOperacion[j].importeAbono,get(FORMULARIO+".hid_SeparadorMiles"),get(FORMULARIO+".hid_SeparadorDecimales")));				
          
        }
    }
 			
			
    saldoPagar=parseFloat(totalEnvia)-parseFloat(totalDevuelve);																		
    
    txt_to("lblTotalEnviaX",formateaImporte(totalEnvia,get(FORMULARIO+".hid_SeparadorMiles"),get(FORMULARIO+".hid_SeparadorDecimales")));
    txt_to("lblTotalDevuelveX",formateaImporte(totalDevuelve,get(FORMULARIO+".hid_SeparadorMiles"),get(FORMULARIO+".hid_SeparadorDecimales")));
    txt_to("lblSaldoAPagarX",formateaImporte(saldoPagar,get(FORMULARIO+".hid_SeparadorMiles"),get(FORMULARIO+".hid_SeparadorDecimales")));

    set(FORMULARIO+".hTotalEnvia",totalEnvia);
    set(FORMULARIO+".hTotalDevuelve",totalDevuelve);
    set(FORMULARIO+".hSaldoPagar",saldoPagar);		
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
	set(FORMULARIO + '.cbMotivoBloqueo', ['']);
       		
	document.all["Bloquear"].disabled=true;
  existeAnulacion = "false";
  existeOperacion = "false";
  var oControlProductosDevuelve = "";
}

function vueltaNumDocumento(datos){	
	
	var arr = datos.split('@@');
	var numeroDoc = arr[0];
    var fechaingreso = arr[1];
	set(FORMULARIO + '.hFechaIngreso',fechaingreso);

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

		,lineasDeOperacion[numero].lineasOperacion[j].precioContable

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
    
    var linea0 = "";
    

  //Se parsea todo esto a pedido de S.Satanas

	var xmlDoc = "<?xml version='1.0' encoding='ISO-8859-1' standalone='yes'?>";
	xmlDoc = xmlDoc + "<DOC>";

    if( oDatosPerdida !=undefined && oDatosPerdida !=null ){ //oDatosPerdida !="" &&
        
        for(b=0;b<oDatosPerdida.length;b++){
    
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


	
	if (existeAnulacion!="true"){
		var datosRetorno = mostrarModalSICC('LPOperacionReclamos', 'agregar operacion', objParams, null, null); 
	
        if(datosRetorno!=undefined){
            oControlProductosDevuelve = datosRetorno.controlProductosDevuelve;
            oDatosPerdida = datosRetorno.operacionesPerdida;
            existeOperacion = datosRetorno.existeOperacion;
            existeAnulacion = datosRetorno.existeOperacionAnulacion;

			/* manejo del chequeo fisico */
			var chkFisicoOperacion = datosRetorno.chequeoFisico;
			var chkFisico = get('frmContenido.chequeoFisico');

			if (chkFisico == ''){
				set('frmContenido.chequeoFisico', chkFisicoOperacion)
			} else {
				set('frmContenido.chequeoFisico', chkFisico + ',' + chkFisicoOperacion);
			}

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
          ,datosRetorno.datosLista[j].precioContable
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
			temp=quitarSeparadorMiles(temp,get(FORMULARIO+".hid_SeparadorMiles"),get(FORMULARIO+".hid_SeparadorDecimales"));
			if(temp!=""){
				detalles=detalles+delimColum+temp;
			}else{
				detalles=detalles+delimColum+"_";
			}
		
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

    //alert("cabecera " + cabecera);
    //alert("detalle " + detalles);

	set(FORMULARIO+'.hMatrizReclamoCabeceras',cabecera);
	set(FORMULARIO+'.hMatrizReclamoDetalles',detalles);			
}
var idenListadoOper=0;

function generaDatosDeRetorno(){
	objeto=new Object();
	/*	
        
		,oidAsumePerdida
        ,oPrecioCalculo
        ,porcentajeRecargo
        ,oidProductoSeguro
        ,oidClienteSeguro
        ,importeSeguro 
	*/	
        
	objeto.codOperacion="345"+idenListadoOper;
	objeto.codTipoOperacion="145"+idenListadoOper;
	objeto.numSecOper=idenListadoOper;		
	objeto.numDocumento="98790243"+idenListadoOper; 
	objeto.descRetorno="Descripcretorno";    		
	objeto.oidNumDocumento="234"; 
	objeto.montoPerdida="2,346.5"; 
	objeto.uReclamadas="22"; 
	objeto.uDevueltas="23"; 
	objeto.totalCargo="434.32"; 
	objeto.totalAbono="24.3"; 
	objeto.oidMotivoBloqueo="2435"; 
	objeto.oidEstadoOperacion="4356"; 
	objeto.tipoBloqueo="56";		
	objeto.oidTipoOpSeleccionada="12";
	objeto.oidOpSeleccionada="123";				
	
	lista = new Array();
	//para cada linea de detalle

	for(i=1;i<10;i++){		
        objetoLista=new Object();
		objetoLista.tipoMovimiento="Compra_"+idenListadoOper+"_"+i;
		objetoLista.codVenta="121243";
		objetoLista.codProducto="12243";
		objetoLista.descProducto="Java Book Reference_"+idenListadoOper+"_"+i;
		objetoLista.uReclamadas="10";
		objetoLista.precioProducto="1000";
		objetoLista.descuentoUnitario="122";
		objetoLista.uDevueltas="12";
		objetoLista.importeCargo="1212";
		objetoLista.importeAbono="12123";
		objetoLista.motivoDevolucion="11";
		objetoLista.numLinea="12";
		objetoLista.oidTipoMovi="122";
		objetoLista.oidCodigoVenta="234";
		objetoLista.oidCodigoProducto="423";
		objetoLista.montoPerdida="432";
		objetoLista.precioCalculo="123";
		objetoLista.oidOperacion="53";      
					
		lista.push(objetoLista);
	}
	//fin del para	


	
	objeto.lista=lista;	
	idenListadoOper++;
	return objeto;
}

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
	
	   generaDatosMatrizReclamo();

    frmContenido.oculto='S';
    set(FORMULARIO + '.accion','guardar');
    set(FORMULARIO + '.conectorAction',"LPReclamosEnLinea");
    //document.all['Bloquear'].disabled = false;
    
    enviaSICC(FORMULARIO);

}

function onClickbloquear() {
 //18586
    if(get(FORMULARIO+".cbMotivoBloqueo")!=''){
      frmContenido.oculto='S';
      set(FORMULARIO + '.accion','bloquear');
   set(FORMULARIO + '.oidMotivoBloqueo', get(FORMULARIO + '.cbMotivoBloqueo'));
      set(FORMULARIO + '.conectorAction',"LPReclamosEnLinea");
      enviaSICC(FORMULARIO);
    }
 else{
     GestionarMensaje('REC030');
  focaliza(FORMULARIO+'.cbMotivoBloqueo');
    }  
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
	if(document.all['Bloquear'].disabled) {
		if (document.all['GenSol'].disabled)
			focaliza(FORMULARIO + '.txtCodCliente');
		else
			document.all['GenSol'].focus();
	} else
		document.all['Bloquear'].focus();
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
	
	eval (ON_RSZ);   
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
	eval (ON_RSZ);   
	paginaOculta=true;
} 

function onclickConsultaReclamo(){
	//mostrarModalSICC('LPConsultarReclamo','', objParams, null, null);

	var objParams = new Object();

	objParams.accion = 'consultar reclamo';
	//	Modificado por HRCS - 03/08/2007 - REC-004
	if (get(FORMULARIO + '.hLblCodClienteX')!='')	{
		objParams.txtCodigoCliente = get(FORMULARIO + '.hLblCodClienteX');
	}
	else {
		objParams.txtCodigoCliente = get(FORMULARIO + '.hLblCodClienteX');
	}
	objParams.txtCodigoCliente = get(FORMULARIO + '.txtCodCliente');
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
	
	// vbongiov -- RI 20090931 -- 4/06/2009
	if (oid == undefined || oid == ''){
		objeto.oidCliente = '';
	} else {
		var arrayS = oid.split("@@");
		objeto.oidCliente = oid ;
    	set(FORMULARIO + ".hCierre",arrayS[6]);  
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
		
		set(FORMULARIO + ".hMoneda",dato.moneda);

		set(FORMULARIO + ".hFechaIngreso",dato.hFechaIngreso);

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
	
	//	Seteamos por defecto el periodo actual
	var numElem = combo_get('frmContenido.cbPeriodoRec', 'L', null);
	var asigno = 1;
	if(get('frmContenido.hCierre')>0){
		asigno = 2;
    }
	if ( numElem > asigno )	{
		var codigo = combo_get('frmContenido.cbPeriodoRec', 'V', asigno);
		if (codigo != "")	{
			var arrayN = codigo.split(",");
			set('frmContenido.cbPeriodoRec', arrayN );
		}
	}
}

function onClickBuscar(){
      ocultaLista();
      document.all['GenSol'].disabled=true;
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
    
    txt_to("lblNDocX",valores[8]);			
    txt_to("lblCodClienteX",valores[9]);
    txt_to("lblNombreApellidosX",valores[10].replace("¿?","'"));// SiCC 20070200
    txt_to("lblNumeroZonaX",valores[11]);
    txt_to("lblEstadoClienteX",valores[12]);  
    
    set(FORMULARIO + ".hMoneda",valores[13]);
    set(FORMULARIO + ".hFechaIngreso",valores[14]);
	set(FORMULARIO + ".hCierre",valores[15]); 

    frmContenido.oculto='S';
        set(FORMULARIO + '.accion','buscar_numero_doc');
        set(FORMULARIO + '.conectorAction',"LPReclamosEnLinea");
        enviaSICC(FORMULARIO);

	//	Seteamos por defecto el periodo actual
	var numElem = combo_get('frmContenido.cbPeriodoRec', 'L', null);
	var asigno = 1;
	if(get('frmContenido.hCierre')>0){
		asigno = 2;
    }

	if ( numElem > asigno )	{
		var codigo = combo_get('frmContenido.cbPeriodoRec', 'V', asigno);
		if (codigo != "")	{
			var arrayN = codigo.split(",");
			set('frmContenido.cbPeriodoRec', arrayN );
		}
	}
}

function fVolver(){
  window.close();
}

function onChangeMotivoBloqueo(){
  if(indGuardado == "true"){
    if(get(FORMULARIO + '.cbMotivoBloqueo')!=''){
        document.all["Bloquear"].disabled = false;	
        document.all["GenSol"].disabled = true;
    }else{
        document.all["Bloquear"].disabled = true;	
        document.all["GenSol"].disabled = false;
   }
 }
}


// Creada por Mejora SiCC 20070534
// dmorello - 12/02/2008
function errorGenerarSolicitudes() {
    document.all["GenSol"].disabled = false;
}
