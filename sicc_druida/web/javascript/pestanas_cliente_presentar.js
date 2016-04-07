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

var FORMULARIO = 'frmFormulario';

function onClickPestana(pestana) {
	var activo = get(FORMULARIO+'.accion');
	var cargadoContenido=false;
	if (typeof(parent.contenidoPestana) != undefined && 
		(typeof(parent.contenidoPestana.cargado) != undefined) &&
		(parent.contenidoPestana.cargado)) cargadoContenido = true;
	if(pestana != activo && cargadoContenido) {
		      set(FORMULARIO+'.accion',pestana);
        	set(FORMULARIO+'.conectorAction','LPCargarPestanas');
			 //var objParamsInt = new Object();          
			//objParamsInt.accion = pestana;
			//objParamsInt.conectorAction= 'LPCargarPestanas';
         
			//setValues(objParamsInt);
         	enviaSICC(FORMULARIO);
	}
     if (cargadoContenido) {
        if (activo == 'lblFicha' || activo == 'lblContactos'){
       		 parent.contenidoPestana.formulario.oculto="N";
         	}

       		if(pestana == 'lblFicha') {
        		parent.contenidoPestana.accionFicha();
         	} else if(pestana == 'lblContactos') {
         		parent.contenidoPestana.accionContactos();
        	} else if(pestana == 'lblCuentaCorriente') {
        		parent.contenidoPestana.accionCuentasCorrientes();
        	} else if(pestana == 'lblPedidos') {
        		parent.contenidoPestana.accionPedidos();
       		} else if(pestana == 'lblVinculos') {
       			parent.contenidoPestana.accionVinculos();
        	} else if(pestana == 'lblDocumentos') {
        		parent.contenidoPestana.accionDocumentos();
        	} else if(pestana == 'lblDireccion') {
        		parent.contenidoPestana.accionDireccion();
        	}
          
     }
		
   }

/*function setValues(objParams){
	if(objParams.parametros){

		var atributos;
		//Limpio todos los campos insertados del frm que envio
		eliminaElementosDinamicos();
		for(atributos in objParams.parametros){
			if(atributos != "window" && atributos != "length"){
				var hidden = document.createElement("INPUT");
				hidden.type = "hidden";
				hidden.insertado = "1";
				hidden.name = atributos;
				hidden.value = (objParams.parametros[atributos]==null)?"":objParams.parametros[atributos];
				document.forms["frmContenidoEnvia"].appendChild(hidden);
			}
		}
		set('frmContenidoEnvia.conectorAction', objParams.conectorAction);
		enviaSICC("frmContenidoEnvia");
	}	
}


function eliminaElementosDinamicos(){
	var elementos = document.forms["frmContenidoEnvia"].elements;
	var longitud = elementos.length;
	for ( i = 0;i < longitud; i++ ){
		var oChild=document.forms["frmContenidoEnvia"].children(i);	
		if (oChild!= null && oChild.insertado=="1"){
			document.forms["frmContenidoEnvia"].removeChild(oChild);
			i = i-1;
		}
	}
}*/



