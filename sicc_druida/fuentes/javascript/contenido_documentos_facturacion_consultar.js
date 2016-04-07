/**
* Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

/*
    INDRA/CAR/PROY
    $Id: contenido_documentos_facturacion_consultar.js,v 1.1 2009/12/03 19:01:33 pecbazalar Exp $
    DESC
*/

var FORMULARIO = 'frmFormulario';

function onLoadPag(){
  
    DrdEnsanchaConMargenDcho('listado1',12);
    var errDescripcion = get(FORMULARIO +'.errDescripcion');
	if (errDescripcion !='') {		
    	var errCodigo = get(FORMULARIO+'.errCodigo');
        var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
	}
	configurarMenuSecundario(FORMULARIO);
	
    document.all["Cplistado1"].style.visibility='';
    document.all["CpLin1listado1"].style.visibility='';
    document.all["CpLin2listado1"].style.visibility='';
    document.all["CpLin3listado1"].style.visibility='';
    document.all["CpLin4listado1"].style.visibility='';

    document.all["primera1Div"].style.visibility='';
    document.all["ret1Div"].style.visibility='';
    document.all["ava1Div"].style.visibility='';
    document.all["separaDiv"].style.visibility='';
    document.all["btnVisualizarDiv"].style.visibility='';	
    //document.all["btnDetalleDiv"].style.visibility='';	
    eval (ON_RSZ);  
	focaliza(FORMULARIO+'.txtCodigoCliente');
}


function visibleLista() {
       
	visibilidad('capaLista','V');
    DrdEnsanchaConMargenDcho('listado1',12);
    eval (ON_RSZ);  
}

function noVisibleLista() {
	visibilidad('capaLista','O');
}

function muestraLista( ultima, rowset){
         
	var tamano = rowset.length;
    if (tamano > 0) {
    	visibleLista();
        return true;
    } else {
    	noVisibleLista();
        // No se ha encontrado ningún elemento con los criterios especificados
        //Control del foco
        	focaliza(FORMULARIO+'.txtCodigoCliente');
            return false;
    }
}

function desplazar(){
                  
	if(get_visibilidad("capaLista")){
    	document.all['btnVisualizar'].focus();
    }else{
    	focaliza(FORMULARIO+'.txtCodigoCliente');
    }
}
function desplazarSift(){
           
	if(get_visibilidad("capaLista")){
  		document.all['btnVisualizar'].focus();
	}else{
    	document.all['btnBuscar'].focus();         
	}
}

function desplazarONStab(){
	document.all['btnBuscar'].focus();
}

function comprobarFecha(txtFecha){ 
         
	var fecha = get(FORMULARIO+'.'+txtFecha);
	 
	if(fecha != ""){
	var resul = EsFechaValida(fecha,fecha, FORMULARIO,null);
		if(resul==1 || resul==2){  
	    	GestionarMensaje('1006', get(FORMULARIO+'.hFormatoFechaPais')); 
	        focaliza(FORMULARIO+'.'+txtFecha);
	        return false;
		}
	}
}

function codClienteOnBlur() {
	var codigoCliente = get(FORMULARIO+'.txtCodigoCliente').toString();
    if (codigoCliente != '') {
    	codigoCliente = codigoCliente.toUpperCase();
    	var longitudCodigoCliente = get(FORMULARIO+'.numDigitosCodigoCliente').toString();
        var longitud = codigoCliente.length;
        set(FORMULARIO+'.txtCodigoCliente',rellenaCeros(codigoCliente,longitudCodigoCliente,longitud))
    }
}
function buscarCliente(){
   
    //Llamamos al proceso correspondiente Modal
    var objParams = new Object();
    var cliente = mostrarModalSICC('LPBusquedaRapidaCliente', '', objParams, null, null);          

    if(typeof cliente!='undefined') {
         var codigoCliente = cliente[1];
         set(FORMULARIO+'.txtCodigoCliente',codigoCliente);
    }
}

function onClickBuscar(){

	if(sicc_validaciones_generales()){
		var rangoDesdeDocInt = get(FORMULARIO+'.textRangoDesdeDocInterno');
		var rangoHastaDocInt = get(FORMULARIO+'.textRangoHastaDocInterno');
		var serieDoc = get(FORMULARIO+'.textSerieDocLegal');
		var rangoDesdeDocLegal = get(FORMULARIO+'.textRangoDesdeDocLegal');
		var rangoHastaDocLegal = get(FORMULARIO+'.textRangoHastaDocLegal');
		var fechaFactDesde = get(FORMULARIO+'.textFechaFacturacionDesde');
		var fechaFactHasta = get(FORMULARIO+'.textFechaFacturacionHasta');
		var fechaProcDesde = get(FORMULARIO+'.textFechaProcesoDesde');
		var fechaProcHasta = get(FORMULARIO+'.textFechaProcesoHasta');
		if(rangoDesdeDocInt != "" || rangoHastaDocInt != "" || serieDoc != "" || rangoDesdeDocLegal != "" ||
			rangoHastaDocLegal != ""){
			
			/*if(rangoDesdeDocInt <= rangoHastaDocInt && rangoDesdeDocLegal <= rangoHastaDocLegal && 
				fechaFactDesde <= fechaFactHasta && fechaProcDesde <= fechaProcHasta){*/
			if ((rangoDesdeDocInt != "" && rangoHastaDocInt != "" && parseInt(rangoDesdeDocInt) > parseInt(rangoHastaDocInt)) ||
				(rangoDesdeDocLegal != "" && rangoHastaDocLegal != "" && parseInt(rangoDesdeDocLegal) > parseInt(rangoHastaDocLegal)) ||
				(fechaFactDesde != "" && fechaFactHasta != "" && !fechamayor(fechaFactDesde,fechaFactHasta)) ||// fechaFactDesde > fechaFactHasta) ||
				(fechaProcDesde != "" &&  fechaProcHasta != "" && !fechamayor(fechaProcDesde,fechaProcHasta))){//fechaProcDesde > fechaProcHasta)){
				// Mostrar mensaje de error("Error en rangos de búsqueda") Incidencia 8879
				cdos_mostrarAlert(GestionarMensaje('1409'));
			}else{
				var idioma = get(FORMULARIO+'.idioma');
	        	var pais = get(FORMULARIO+'.pais');
				var codCliente = get(FORMULARIO+'.txtCodigoCliente');
				var tipoDocCont = get(FORMULARIO+'.cbTipoDocumentoContable');
				var ejercicio = get(FORMULARIO+'.textEjercicio');
				var canal = get(FORMULARIO+'.cbCanl');
				var acceso = get(FORMULARIO+'.cbAcceso');
				var subacceso = get(FORMULARIO+'.cbSubacceso');
				var numConsolidadoD = get(FORMULARIO+'.textNumeroConsolidadoDesde');
				var numConsolidadoH = get(FORMULARIO+'.textNumeroConsolidadoHasta');
							
				var dto = [ ["oidPais",pais], ["pais", pais], ["oidIdioma",idioma], ["codigoCliente",codCliente], ["tipoDocumentoContable",tipoDocCont],
							["ejercicio",ejercicio], ["rangoDesdeDocumentoInterno",rangoDesdeDocInt], ["rangoHastaDocumentoInterno",rangoHastaDocInt],
							["serieDocumentoLegal",serieDoc], ["rangoDesdeDocumentoLegal",rangoDesdeDocLegal],
							["rangoHastaDocumentoLegal",rangoHastaDocLegal], ["canal",canal], ["acceso",acceso],
							["subacceso",subacceso], ["numeroConsolidadoDesde",numConsolidadoD], ["numeroConsolidadoHasta",numConsolidadoH],
							["fechaFacturacionDesde",fechaFactDesde], ["fechaFacturacionHasta",fechaFactHasta],
							["fechaProcesoDesde",fechaProcDesde], ["fechaProcesoHasta",fechaProcHasta] ];
							
		
				configurarPaginado(mipgndo, "FACConsultarFacturas", "ConectorConsultaFacturas", 
					"es.indra.sicc.dtos.fac.DTOFACConsultaFacturas",dto);
			} 
		}else{
			//Mostrar mensaje de error( "Debe rellenar al menos el rango documento interno o la serie y rango documento legal" ) 
			cdos_mostrarAlert(GestionarMensaje('1402'));
		}
	}
}

function canalOnChange(){
	/*Documentation
Llamar al método recargaCombo utilizando el DTOOID y el idBusiness = "SEGObtenerAccesosPorCanal". 
Parametros del DTOOID: 
- DTOOID.oid = oid del canal seleccionado en cbCanal 

Obtenemos un DTOSalida y cargamos el combo */
	vaciaAcceso();
	var oidcanal = get(FORMULARIO+'.cbCanal');
	//alert("canal = "+oidcanal);
	if (oidcanal != ""){
    	var oidpais = get(FORMULARIO+'.pais');
        var oididioma = get(FORMULARIO+'.idioma'); 
        recargaCombo(FORMULARIO+'.cbAcceso', 'SEGObtieneAccesosPorCanal', 'es.indra.sicc.util.DTOOID', [['oidPais', oidpais], ['oidIdioma', oididioma], ['oid', oidcanal]]);
	}
}

function accesoOnChange(){

/*Documentation
Llamar al método recargaCombo utilizando el DTOOID y el idBusiness = "SEGObtenerSubccesosPorAcceso". 
Parametros del DTOOID: 
- DTOOID.oid = oid del acceso seleccionado en cbAcceso 

Obtenemos un DTOSalida y cargamos el combo cbSubacceso 
*/
	vaciaSubacceso();
	var oidAcceso = get(FORMULARIO+'.cbAcceso');
	if(oidAcceso != ""){ 
		var oidpais = get(FORMULARIO+'.pais');
        var oididioma = get(FORMULARIO+'.idioma'); 
        recargaCombo(FORMULARIO+'.cbSubacceso', 'SegObtenerSubaccesosPorAcceso', 'es.indra.sicc.util.DTOOID', [['oidPais', oidpais], ['oidIdioma', oididioma], ['oid', oidAcceso]]);
	}
}

function vaciaSubacceso(){
          set_combo(FORMULARIO+'.cbSubacceso',[['','']],['']);
}
function vaciaAcceso(){
          set_combo(FORMULARIO+'.cbAcceso',[['','']],['']);
          vaciaSubacceso();
}
function vaciaCanal(){
          set_combo(FORMULARIO+'.cbCanal',[['','']],['']);
          vaciaAcceso();
}

function validarNumerico(texto){                                   
         var num = get(FORMULARIO+'.'+texto); 
         if(num != ""){
                  var val = allTrim(num);              
         //Como no nos interesa validar el número de dígitos que tiene el 
         //entero ponemos uno suficientemente grande. 
                  if ((ValidaInt(val.toString(),10000, 0)!="OK")||(val.toString() < 0)) {
                           GestionarMensaje('747', null, null, null);
                           focaliza(FORMULARIO+'.'+texto);
                           return false;
                  }
         }                                   
} 
function allTrim(sStr){ 
          return rTrim(lTrim(sStr)); 
}
function lTrim(sStr){ 
          while (sStr.charAt(0) == " "){
                    sStr = sStr.substr(1, sStr.length - 1); 
          }
          return sStr; 
} 
function rTrim(sStr){ 
          while (sStr.charAt(sStr.length - 1) == " ") {
                    sStr = sStr.substr(0, sStr.length - 1); 
          }
          return sStr; 
}  

	
function fLimpiar(){
	canalOnChange();
	accesoOnChange();
}

function serieDocLegalOnBlur(){
	set(FORMULARIO + '.textSerieDocLegal',get(FORMULARIO + '.textSerieDocLegal').toUpperCase());
}


function btnVisualizarAccion(){
	
	if (listado1.numSelecc() == 0) {
    	//Mostramos mensaje de error 
        GestionarMensaje('50');
    }else {
     	if (listado1.numSelecc()!=1) {
        	//Muesta el mensaje: "Debe seleccionar un solo registro"
            GestionarMensaje('8');
            //Se limpia la lista editable
            var seleccion=listado1.codigos();
            var i=0;
            while(seleccion[i]!=null){
            	listado1.deselecciona(i); 
                i++;            
            }
      	}else {
			/*
			var objParams = new Object();
	
			var codigo = listado1.codSeleccionados();
			objParams.oid = codigo;
			//mostrarModalSICC('LPConsultaFacturas', 'visualizar', objParams, null, null); 
			*/
			var codigo;
			if(listado1.codSeleccionados().length){
				codigo = listado1.codSeleccionados()[0]+"";
			}else{
				codigo = listado1.codSeleccionados()+"";
			}
			set(FORMULARIO+".oid",codigo+"");
			set(FORMULARIO+".conectorAction","LPConsultaFacturas");
			set(FORMULARIO+".accion","visualizar");
			enviaSICC(FORMULARIO,null,"ifMostrarPDF");
			
		}
	}
}

function fechamayor(fecha,fech)
{
	/*************************************************************************/
	// Devuelve true si la segunda fecha es mayor que la primera. False en caso contrario
	/*************************************************************************/
	if (fecha!=fech)
	{
		//Comprobar q no sea mayor q la fecha actual	
		fecha2=fecha.split("/");
		fech2=fech.split("/");
		if (fecha2[2]<=fech2[2])
		{
			if (fecha2[2]==fech2[2])
			{
				if (fecha2[1]<=fech2[1])
				{
					if (fecha2[1]==fech2[1])
					{
						if (fecha2[0]<=fech2[0])
						{
							return true;
						}
						else
						{
							//alert('fecha de fin');
							return false;
						}
					}
					else
					{
						return true;
					}
				}
				else
				{
					//alert('La fecha ');
					return false;
				}
			}
			else
			{
				return true;
			}
		}
		else
		{
			//alert('o no puede ser mayor q');
			return false;
		}
	
	}
	return true;
}