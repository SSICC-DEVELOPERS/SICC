var FORMULARIO = "frmFormulario";
//
var COL_COMBO = 4;
var COL_OID = 0;
var COL_OBS = 5;
//
function onLoadPag()   {
  
    DrdEnsanchaConMargenDcho('listado1',12);
    eval (ON_RSZ);  
    
    var errDescripcion = get(FORMULARIO +'.errDescripcion');
    
    configurarMenuSecundario(FORMULARIO);
    btnProxy(1 , 1);

    if (errDescripcion !='') {
         var errCodigo = get(FORMULARIO+'.errCodigo');
         var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
    } else{
    	paginado();
		// INC BELC300021334
		cargarComboResultadosChequeo();
	}
    


}
/* COMIENZO
INC BELC300021334
gPineda cdos
03/05/06
*/
function cargarComboResultadosChequeo(){
		var aOidsResultadoChequeo;
		var aDescsResultadoChequeo;
		var aIndsResultadoChequeo;

		aOidsResultadoChequeo = get(FORMULARIO+'.hOidsResultadoChequeo').split(','); // cargados en la LP
		aDescsResultadoChequeo = get(FORMULARIO+'.hDescsResultadoChequeo').split(','); // cargados en la LP
		aIndsResultadoChequeo = get(FORMULARIO+'.hIndsResultadoChequeo').split(','); // cargados en la LP
		
		aDatosComboResultadoChequeo = new Array();
		aDatosComboResultadoChequeo[0] = new Array('', '');

		for (var i = 0; i < aOidsResultadoChequeo.length; i++){
			aDatosComboResultadoChequeo[i + 1] = new Array(aOidsResultadoChequeo[i], aDescsResultadoChequeo[i]);
		}
		
		listado1.tiposCol[COL_COMBO][2] = aDatosComboResultadoChequeo;
		listado1.repinta();
            
		return true;
	}

function getIndicador( oid ){
		var aOidsResultadoChequeo;
		var aIndsResultadoChequeo;

		aOidsResultadoChequeo = get(FORMULARIO+'.hOidsResultadoChequeo').split(','); // cargados en la LP
		aIndsResultadoChequeo = get(FORMULARIO+'.hIndsResultadoChequeo').split(','); // cargados en la LP

		for (var i = 0; i < aOidsResultadoChequeo.length; i++){
			if( aOidsResultadoChequeo[i] == oid ){
				return aIndsResultadoChequeo[i];
			}
		}
		return null;
}

function onChangeComboResultadoChequeo(FILA){
	var indicador;
	var codFila;

	codFila = listado1.datos[FILA][COL_OID];
	indicador = getIndicador( listado1.extraeDato(codFila, COL_COMBO) );

	if (indicador == 0 ){
		if (GestionarMensaje("REC-012")){
			var objParams = new Object();
			objParams.oid = listado1.datos[FILA][COL_OID];
			objParams.revision = listado1.extraeDato(codFila, COL_COMBO);
			objParams.observaciones = listado1.extraeDato(codFila, COL_OBS);
			mostrarModalSICC('LPReclamosEnLinea', '', objParams, null, null);
		}
	}
}


function fGuardar(){
	set(FORMULARIO+'.accion','aceptarResultadoChequeo');
	 listado1.actualizaDat();
	var param = new Object();
	set(FORMULARIO + '.sXml' , listaToXML());
	set(FORMULARIO + '.conectorAction' ,"LPIntroducirResultadoChequeos");
    //setConectorAction(,"LPIntroducirResultadoChequeos.java");
	eval(FORMULARIO).oculto = "S";
    enviaSICC(FORMULARIO, null, null, "N");
	/*mostrarModalSICC('LPIntroducirResultadoChequeos','aceptarResultadoChequeo', param);		 */
}
// FIN - INC BELC300021334

function paginado(){
	var oidCliente = get(FORMULARIO + '.oidCliente');
	var pais = get(FORMULARIO + '.pais');
	var idioma = get(FORMULARIO + '.idioma');
	
	configurarPaginado(mipgndo, "RECBuscarSolicitudesCliente", "ConectorBuscarSolicitudesCliente", 
	"es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOOIDPaginado", 
	[ ["oid", oidCliente], ["oidPais", pais], ["oidIdioma", idioma] ] );
}

function detalleOnClick(){

	if (listado1.numSelecc() == 0){
		GestionarMensaje('50');
	} else if (listado1.numSelecc() > 1){
		GestionarMensaje('8');
		var seleccion=listado1.codigos();
		var i=0;
		while(seleccion[i]!=null){
			listado1.deselecciona(i); 
			i++; 
		}
	} else{
		var objParams = new Object();
		objParams.oid = listado1.codSeleccionados();
		var codigoProducto = mostrarModalSICC('LPIntroducirResultadoChequeos', 'detalle', objParams, null, null);
	}
}

function modificarOnClick(){
/*
INC BELC300021334 gpineda 03/05/06

	if (listado1.numSelecc() == 0){
		GestionarMensaje('50');
	} else if (listado1.numSelecc() > 1){
		GestionarMensaje('8');
		var seleccion=listado1.codigos();
		var i=0;
		while(seleccion[i]!=null){
			listado1.deselecciona(i); 
			i++; 
		}
	} else{
		var objParams = new Object();
		objParams.oid = listado1.codSeleccionados();
		objParams.revision = listado1.extraeDato(listado1.codSeleccionados(),4);
		objParams.observaciones = listado1.extraeDato(listado1.codSeleccionados(),5);
		
    	var fila = mostrarModalSICC('LPIntroducirResultadoChequeos', 'modificar', objParams, null, null);
    	if(typeof(fila)!='undefined') {
			listado1.actualizaDat();
			listado1.insertaDato(listado1.codSeleccionados(),4,fila[1].toString());
			listado1.insertaDato(listado1.codSeleccionados(),5,fila[2].toString());
			listado1.repinta();
			
			var indicador = fila[0];
    		if (indicador == '0'){
    			if (GestionarMensaje("REC-012")){
    				varObjParams2 = new Object
    				mostrarModalSICC('LPReclamosEnLinea', '', objParams, null, null);
    			}
    		}
    	}
	}
*/
}

function detalleOnShTab(){
	document.all['Modificar'].focus();
}

function modificarOnTab(){
	document.all['Detalle'].focus();
}

function muestraLista(ultima, rowset) {
	var tamano = rowset.length;
                 
	if (tamano > 0) {
		mostrarLista();
		return true;
	} else {
		ocultaLista();
		return false;
	}
}

function mostrarLista() {
	DrdEnsanchaConMargenDcho('listado1',12);
	eval (ON_RSZ);  

	//Dependiendo del caso de uso mostramos los botones
	//var casoUso = get(FORMULARIO+'.casoUso');
	
	/*
	if (casoUso == 'consultar' || casoUso == 'eliminar') {
		document.all["ModificarDiv"].style.visibility='hidden';
		document.all["DetalleDiv"].style.visibility='visible';
	} else if (casoUso == 'modificar') {
		document.all["ModificarDiv"].style.visibility='visible';
		document.all["DetalleDiv"].style.visibility='hidden';
	}
	*/

	//document.all["CplistaResultados"].style.visibility='visible';
	//document.all["CpLin1listaResultados"].style.visibility='visible';
	//document.all["CpLin2listaResultados"].style.visibility='visible';
	//document.all["CpLin3listaResultados"].style.visibility='visible';
	//document.all["CpLin4listaResultados"].style.visibility='visible';
	//document.all["primera1Div"].style.visibility='visible';
	//document.all["ret1Div"].style.visibility='visible';
	//document.all["ava1Div"].style.visibility='visible';
	//document.all["separaDiv"].style.visibility='visible'; 
}

function ocultaLista() {
	//visibilidad('capaLista','O');
	//document.all["ModificarDiv"].style.visibility='hidden';
	//document.all["DetalleDiv"].style.visibility='hidden';

	//document.all["CplistaResultados"].style.visibility='hidden';
	//document.all["CpLin1listaResultados"].style.visibility='hidden';
	//document.all["CpLin2listaResultados"].style.visibility='hidden';
	//document.all["CpLin3listaResultados"].style.visibility='hidden';
	//document.all["CpLin4listaResultados"].style.visibility='hidden';
	//document.all["primera1Div"].style.visibility='hidden';
	//document.all["ret1Div"].style.visibility='hidden';
	//document.all["ava1Div"].style.visibility='hidden';
	//document.all["separaDiv"].style.visibility='hidden'; 
} 
 /*	INC BELC300021334	   */
function retornoGuardar() {
    onLoadPag() ;
}

/*INC BELC300021334 */
function listaToXML() {

	var arrayNombreCampos = new Array();
	arrayNombreCampos[0] = "Oid";
	arrayNombreCampos[1] = "Nro Doc";
	arrayNombreCampos[2] = "Fecha Emision";
	arrayNombreCampos[3] = "Tipo Solicitud";
	arrayNombreCampos[4] = "Periodo";
	arrayNombreCampos[5] = "Resultado";
	arrayNombreCampos[6] = "Observaciones";

	var xmlDoc = "<?xml version='1.0' encoding='ISO-8859-1' standalone='yes'?>";

	xmlDoc = xmlDoc + "<DOC>";
	var datos = listado1.datos;
	var cantFilas = datos.length;
	/* Recorre las filas */ 
	for (var i = 0; i < cantFilas; i++) {
					
		if( datos[i][COL_COMBO + 1]== "" ) continue;
		var linea = datos[i]; 
		xmlDoc = xmlDoc + "<ROW>";
		/* Recorre los campos dentro de la fila */

		var cantCampos = linea.length;
		for (var j = 0; j < cantCampos; j++ ) {
			/* Quito formato local de numero */ 
			var campo = linea[j]; 
			xmlDoc = xmlDoc + "<CAMPO nombre='" + arrayNombreCampos[j] + "'>" + SICC_DrdEscXML(campo) + "</CAMPO>";
		}
		xmlDoc = xmlDoc + "</ROW>"
	}
	xmlDoc = xmlDoc + "</DOC>";

	return xmlDoc; 
}