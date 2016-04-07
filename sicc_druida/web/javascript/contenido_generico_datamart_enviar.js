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

function onLoadPag(){	 

	DrdEnsanchaConMargenDcho('listado1',14);

	if (get(FORMULARIO+'.errDescripcion')!='') {
		ocultaLista();
		var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'),get(FORMULARIO+'.errDescripcion'));

	}
	
	configurarMenuSecundario(FORMULARIO);
	focaliza(FORMULARIO+'.cbMarca');
	
	var canal=get(FORMULARIO + '.cbCanal');
	if (canal!=""){
		onChangeCanal();
	}

	eval (ON_RSZ);
}

function onChangeMarca(){
	//var acceso = get(FORMULARIO + '.cbAcceso'); // Incidencia BELC300015449
	var marca=get(FORMULARIO + '.cbMarca');
	var canal=get(FORMULARIO + '.cbCanal');
	//if (acceso != ""&&canal!=""&&marca!="") { Incidencia BELC300015449
	if (canal!=""&&marca!="") {		
		var idBusiness="CRAObtienePeriodos";
		var dtoOid= "es.indra.sicc.dtos.cra.DTOPeriodo";	
		var oidPais = get(FORMULARIO+'.pais');		
		var oidIdioma = get(FORMULARIO+'.idioma'); 	

		var acceso = get(FORMULARIO + '.cbAcceso');
		if (acceso!=""){
			recargaCombo(FORMULARIO+'.cbPeriodoFacturacion', idBusiness, dtoOid,[["acceso",acceso],["marca",marca],["canal",canal],["oidIdioma",oidIdioma],["oidPais",oidPais]]);
		}else{
			recargaCombo(FORMULARIO+'.cbPeriodoFacturacion', idBusiness, dtoOid,[["marca",marca],["canal",canal],["oidIdioma",oidIdioma],["oidPais",oidPais]]);		
		}
	}else{
		vaciaCombo(FORMULARIO + '.cbPeriodoFacturacion');
	}	
	
}


function onChangeCanal(){                 
         
         var oid = get(FORMULARIO + '.cbCanal');			

         if (oid != "") {
                  var idBusiness="SEGObtieneAccesosPorCanal";
                  var dtoOid= "es.indra.sicc.util.DTOOID";	
                  var oidPais = get(FORMULARIO+'.pais');		
                  var oidIdioma = get(FORMULARIO+'.idioma'); 			
                  recargaCombo(FORMULARIO+'.cbAcceso', idBusiness, dtoOid,[["oid",oid],["oidIdioma",oidIdioma],["oidPais",oidPais]]);

		  var marca=get(FORMULARIO + '.cbMarca');
	 	  var canal=get(FORMULARIO + '.cbCanal');
	 	  var acceso = get(FORMULARIO + '.cbAcceso');
		  if (canal!=""&&marca!="") {		
			var idBusinessCRA="CRAObtienePeriodos";
			var dtoOidPERIODO= "es.indra.sicc.dtos.cra.DTOPeriodo";	
			if (acceso!=""){
				recargaCombo(FORMULARIO+'.cbPeriodoFacturacion', idBusinessCRA, dtoOidPERIODO,[["acceso",acceso],["marca",marca],["canal",canal],["oidIdioma",oidIdioma],["oidPais",oidPais]]);
			}else{
				recargaCombo(FORMULARIO+'.cbPeriodoFacturacion', idBusinessCRA, dtoOidPERIODO,[["marca",marca],["canal",canal],["oidIdioma",oidIdioma],["oidPais",oidPais]]);		
			}
		  }else{
			vaciaCombo(FORMULARIO + '.cbPeriodoFacturacion');
		  }	

                  
         }else{
                  vaciaCombo(FORMULARIO + '.cbAcceso');
                  vaciaCombo(FORMULARIO + '.cbPeriodoFacturacion');
         }
         
}


function onChangeAcceso(){ 
       /*var acceso = get(FORMULARIO + '.cbAcceso'); 
       var marca=get(FORMULARIO + '.cbMarca'); 
       var canal=get(FORMULARIO + '.cbCanal'); 
       if (acceso != ""&&canal!=""&&marca!="") { 

               var idBusiness="CRAObtienePeriodos"; 
               var dtoOid= "es.indra.sicc.dtos.cra.DTOPeriodo";         
               var oidPais = get(FORMULARIO+'.pais');                 
               var oidIdioma = get(FORMULARIO+'.idioma');                         
               
               recargaCombo(FORMULARIO+'.cbPeriodoFacturacion', idBusiness, dtoOid,[["acceso",acceso],["marca",marca],["canal",canal],["oidIdioma",oidIdioma],["oidPais",oidPais]]); 

       }else{ 
               if (canal!=""&&marca!="") { 
                       var idBusiness="CRAObtienePeriodos"; 
                       var dtoOid= "es.indra.sicc.dtos.cra.DTOPeriodo";         
                       var oidPais = get(FORMULARIO+'.pais');                 
                       var oidIdioma = get(FORMULARIO+'.idioma');                         
                       recargaCombo(FORMULARIO+'.cbPeriodoFacturacion', idBusiness, dtoOid,[["marca",marca],["canal",canal],["oidIdioma",oidIdioma],["oidPais",oidPais]]); 
               }else{ 
                       vaciaCombo(FORMULARIO + '.cbPeriodoFacturacion'); 
               } 
       }        */ 
       
} 


function vaciaCombo(combo){
           set_combo(combo,[['','']],['']);
}



function onclikEnviar(){
	if(!sicc_validaciones_generales()){
		return;		
	}
	//	Agregado por HRCS - Fecha 18/04/2007 - Cambio Sicc20070215
	listado1.actualizaDat();
	var datosLista = listado1.datos;
	var longLista = datosLista.length;
	var listaSelecc = '';
	var listaNoSelecc = '';
	var i = 1;
	var u = 1;
	for ( var j = 0; j < longLista; j++)	{
		if (datosLista[j][3] == 'S')	{
			var codigoLista = datosLista[j][0];
			if (i==1)	{
				listaSelecc = codigoLista;
			}
			else	{
				listaSelecc = listaSelecc + ',' + codigoLista;
			}
			i++;
		}
		else	{
			var codigoInte = datosLista[j][1];
			if (u==1)	{
				listaNoSelecc = codigoInte;
			}
			else	{
				listaNoSelecc = listaNoSelecc + ',' + codigoInte;
			}
			u++;
		}
	}

	//	Valida si existen codigos
	if (listaSelecc == '')	{
		GestionarMensaje('INT0001');
	}
	else	{
		if (listaNoSelecc != '')	{
			var r = GestionarMensaje('INT0002', listaNoSelecc);
			if ( !r )
			{
				return;
			}
		}
		set(FORMULARIO+'.hListaInterfaces', listaSelecc );
		set(FORMULARIO+'.accion','enviar');
		set(FORMULARIO+'.conectorAction','LPEnviarGenericoDatamart');
		enviaSICC(FORMULARIO);
	}
	
}

function cerrarVentana(){

         var formulario = getFormularioSICC();
         set(formulario+".conectorAction","LPInicioBelcorp");
         set(formulario+".accion","");
         try{
                  parent.frames['menu'].location.reload();
                  parent.frames["iconos"].mostrarCapa();
         }catch(e){
         
         }
         eval(formulario).oculto = 'N';
         enviaSICC(formulario,'','','N');
         
}

function fechaValida(fechaEntrada){
          
           var fecha = get(FORMULARIO+'.'+fechaEntrada);
           if(fecha != ""){
                      var resul = EsFechaValida(fecha,fecha, FORMULARIO,null);
                      if(resul==1 || resul==2){
                              GestionarMensaje('1006', get(FORMULARIO+'.hFormatoFechaPais'));
                                  focaliza(FORMULARIO+'.'+fechaEntrada);
                                  return false;
                }
           }
}

function fLimpiar(){
	fLimpiarGenericoSICC();
	set(FORMULARIO+'.areatxtObservaciones','');    
	vaciaCombo(FORMULARIO + '.cbAcceso');
	vaciaCombo(FORMULARIO + '.cbPeriodoFacturacion');                  
}
