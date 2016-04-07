

/*
    INDRA/CAR/mmg
    $Id: segpaisview.js,v 1.1 2009/12/03 19:02:27 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsSegPaisViewId = "";
var jsSegPaisViewCodPais = "";
var jsSegPaisViewMoneOidMone = "";
var jsSegPaisViewMoneOidMoneAlt = "";
var jsSegPaisViewDescripcion = "";
var jsSegPaisViewIndInteGis = "";
var jsSegPaisViewValIden = "";
var jsSegPaisViewIndSaldUnic = "";
var jsSegPaisViewValProgEjec = "";
var jsSegPaisViewValPorcAlar = "";
var jsSegPaisViewIndCompAuto = "";
var jsSegPaisViewNumDiasMora = "";
var jsSegPaisViewIndTratAcumDesc = "";
var jsSegPaisViewValTiemRezo = "";
var jsSegPaisViewValConfSecuCcc = "";
var jsSegPaisViewNumDiasFact = "";
var jsSegPaisViewNumLimiDifePago = "";
var jsSegPaisViewIndEmisVenc = "";
var jsSegPaisViewValMaxiDifeAnlsComb = "";
var jsSegPaisViewNumPosiNumeClie = "";
var jsSegPaisViewValFormFech = "";
var jsSegPaisViewValSepaMile = "";
var jsSegPaisViewValSepaDeci = "";
var jsSegPaisViewNumPeriEgre = "";
var jsSegPaisViewNumPeriReti = "";
var jsSegPaisViewFopaOidFormPago = "";
var jsSegPaisViewValCompTele = "";
var jsSegPaisViewIndFletZonaUbig = "";
var jsSegPaisViewValIndiSecuMoni = "";
var jsSegPaisViewIndSecu = "";
var jsSegPaisViewIndBalaAreaCheq = "";
var jsSegPaisViewValUrl = "";

//Variables de paginacion, 
var segPaisViewPageCount = 1;

//Varible de columna que representa el campo de choice
var segPaisViewChoiceColumn = 2;

//Flag de siguiente pagina;
var segPaisViewMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var segPaisViewTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 105;
var sizeFormView = 425;
var sizeFormUpdate = 425;

//Ultima busqueda realizada
var segPaisViewLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("segPaisViewFrm.codPais");','focaliza("segPaisViewFrm.codPais");','focaliza("segPaisViewFrm.codPais");','focaliza("segPaisViewFrm.codPais");','focaliza("segPaisViewFrm.codPais");','focaliza("segPaisViewFrm.codPais");'],[3,'focalizaComboDependence("segPaisView","moneOidMone", false);','focalizaComboDependence("segPaisView","moneOidMone", false);','focalizaComboDependence("segPaisView","moneOidMone", false);','focalizaComboDependence("segPaisView","moneOidMone", true);','focalizaComboDependence("segPaisView","moneOidMone", true);','focalizaComboDependence("segPaisView","moneOidMone", true);'],[4,'','focalizaComboDependence("segPaisView","moneOidMoneAlt", false);','focalizaComboDependence("segPaisView","moneOidMoneAlt", false);','','focalizaComboDependence("segPaisView","moneOidMoneAlt", true);','focalizaComboDependence("segPaisView","moneOidMoneAlt", true);'],[5,'','focaliza("segPaisViewFrm.Descripcion");','focaliza("segPaisViewFrm.Descripcion");','','focaliza("segPaisViewFrm.Descripcion");','focaliza("segPaisViewFrm.Descripcion");'],[6,'','focaliza("segPaisViewFrm.indInteGis");','focaliza("segPaisViewFrm.indInteGis");','','focaliza("segPaisViewFrm.indInteGis");','focaliza("segPaisViewFrm.indInteGis");'],[7,'','focaliza("segPaisViewFrm.valIden");','focaliza("segPaisViewFrm.valIden");','','focaliza("segPaisViewFrm.valIden");','focaliza("segPaisViewFrm.valIden");'],[8,'','focaliza("segPaisViewFrm.indSaldUnic");','focaliza("segPaisViewFrm.indSaldUnic");','','focaliza("segPaisViewFrm.indSaldUnic");','focaliza("segPaisViewFrm.indSaldUnic");'],[9,'','focaliza("segPaisViewFrm.valProgEjec");','focaliza("segPaisViewFrm.valProgEjec");','','focaliza("segPaisViewFrm.valProgEjec");','focaliza("segPaisViewFrm.valProgEjec");'],[10,'','focaliza("segPaisViewFrm.valPorcAlar");','focaliza("segPaisViewFrm.valPorcAlar");','','focaliza("segPaisViewFrm.valPorcAlar");','focaliza("segPaisViewFrm.valPorcAlar");'],[11,'','focaliza("segPaisViewFrm.indCompAuto");','focaliza("segPaisViewFrm.indCompAuto");','','focaliza("segPaisViewFrm.indCompAuto");','focaliza("segPaisViewFrm.indCompAuto");'],[12,'','focaliza("segPaisViewFrm.numDiasMora");','focaliza("segPaisViewFrm.numDiasMora");','','focaliza("segPaisViewFrm.numDiasMora");','focaliza("segPaisViewFrm.numDiasMora");'],[13,'','focaliza("segPaisViewFrm.indTratAcumDesc");','focaliza("segPaisViewFrm.indTratAcumDesc");','','focaliza("segPaisViewFrm.indTratAcumDesc");','focaliza("segPaisViewFrm.indTratAcumDesc");'],[14,'','focaliza("segPaisViewFrm.valTiemRezo");','focaliza("segPaisViewFrm.valTiemRezo");','','focaliza("segPaisViewFrm.valTiemRezo");','focaliza("segPaisViewFrm.valTiemRezo");'],[15,'','focaliza("segPaisViewFrm.valConfSecuCcc");','focaliza("segPaisViewFrm.valConfSecuCcc");','','focaliza("segPaisViewFrm.valConfSecuCcc");','focaliza("segPaisViewFrm.valConfSecuCcc");'],[16,'','focaliza("segPaisViewFrm.numDiasFact");','focaliza("segPaisViewFrm.numDiasFact");','','focaliza("segPaisViewFrm.numDiasFact");','focaliza("segPaisViewFrm.numDiasFact");'],[17,'','focaliza("segPaisViewFrm.numLimiDifePago");','focaliza("segPaisViewFrm.numLimiDifePago");','','focaliza("segPaisViewFrm.numLimiDifePago");','focaliza("segPaisViewFrm.numLimiDifePago");'],[18,'','focaliza("segPaisViewFrm.indEmisVenc");','focaliza("segPaisViewFrm.indEmisVenc");','','focaliza("segPaisViewFrm.indEmisVenc");','focaliza("segPaisViewFrm.indEmisVenc");'],[19,'','focaliza("segPaisViewFrm.valMaxiDifeAnlsComb");','focaliza("segPaisViewFrm.valMaxiDifeAnlsComb");','','focaliza("segPaisViewFrm.valMaxiDifeAnlsComb");','focaliza("segPaisViewFrm.valMaxiDifeAnlsComb");'],[20,'','focaliza("segPaisViewFrm.numPosiNumeClie");','focaliza("segPaisViewFrm.numPosiNumeClie");','','focaliza("segPaisViewFrm.numPosiNumeClie");','focaliza("segPaisViewFrm.numPosiNumeClie");'],[21,'','focaliza("segPaisViewFrm.valFormFech");','focaliza("segPaisViewFrm.valFormFech");','','focaliza("segPaisViewFrm.valFormFech");','focaliza("segPaisViewFrm.valFormFech");'],[22,'','focaliza("segPaisViewFrm.valSepaMile");','focaliza("segPaisViewFrm.valSepaMile");','','focaliza("segPaisViewFrm.valSepaMile");','focaliza("segPaisViewFrm.valSepaMile");'],[23,'','focaliza("segPaisViewFrm.valSepaDeci");','focaliza("segPaisViewFrm.valSepaDeci");','','focaliza("segPaisViewFrm.valSepaDeci");','focaliza("segPaisViewFrm.valSepaDeci");'],[24,'','focaliza("segPaisViewFrm.numPeriEgre");','focaliza("segPaisViewFrm.numPeriEgre");','','focaliza("segPaisViewFrm.numPeriEgre");','focaliza("segPaisViewFrm.numPeriEgre");'],[25,'','focaliza("segPaisViewFrm.numPeriReti");','focaliza("segPaisViewFrm.numPeriReti");','','focaliza("segPaisViewFrm.numPeriReti");','focaliza("segPaisViewFrm.numPeriReti");'],[26,'','focalizaComboDependence("segPaisView","fopaOidFormPago", false);','focalizaComboDependence("segPaisView","fopaOidFormPago", false);','','focalizaComboDependence("segPaisView","fopaOidFormPago", true);','focalizaComboDependence("segPaisView","fopaOidFormPago", true);'],[27,'','focaliza("segPaisViewFrm.valCompTele");','focaliza("segPaisViewFrm.valCompTele");','','focaliza("segPaisViewFrm.valCompTele");','focaliza("segPaisViewFrm.valCompTele");'],[28,'','focaliza("segPaisViewFrm.indFletZonaUbig");','focaliza("segPaisViewFrm.indFletZonaUbig");','','focaliza("segPaisViewFrm.indFletZonaUbig");','focaliza("segPaisViewFrm.indFletZonaUbig");'],[29,'','focaliza("segPaisViewFrm.valIndiSecuMoni");','focaliza("segPaisViewFrm.valIndiSecuMoni");','','focaliza("segPaisViewFrm.valIndiSecuMoni");','focaliza("segPaisViewFrm.valIndiSecuMoni");'],[30,'','focaliza("segPaisViewFrm.indSecu");','focaliza("segPaisViewFrm.indSecu");','','focaliza("segPaisViewFrm.indSecu");','focaliza("segPaisViewFrm.indSecu");'],[31,'','focaliza("segPaisViewFrm.indBalaAreaCheq");','focaliza("segPaisViewFrm.indBalaAreaCheq");','','focaliza("segPaisViewFrm.indBalaAreaCheq");','focaliza("segPaisViewFrm.indBalaAreaCheq");'],[32,'','focaliza("segPaisViewFrm.valUrl");','focaliza("segPaisViewFrm.valUrl");','','focaliza("segPaisViewFrm.valUrl");','focaliza("segPaisViewFrm.valUrl");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[4,'','focalizaComboDependence("segPaisView","moneOidMoneAlt", false);','focalizaComboDependence("segPaisView","moneOidMoneAlt", false);','','focalizaComboDependence("segPaisView","moneOidMoneAlt", true);','focalizaComboDependence("segPaisView","moneOidMoneAlt", true);'],[5,'','focaliza("segPaisViewFrm.Descripcion");','focaliza("segPaisViewFrm.Descripcion");','','focaliza("segPaisViewFrm.Descripcion");','focaliza("segPaisViewFrm.Descripcion");'],[6,'','focaliza("segPaisViewFrm.indInteGis");','focaliza("segPaisViewFrm.indInteGis");','','focaliza("segPaisViewFrm.indInteGis");','focaliza("segPaisViewFrm.indInteGis");'],[7,'','focaliza("segPaisViewFrm.valIden");','focaliza("segPaisViewFrm.valIden");','','focaliza("segPaisViewFrm.valIden");','focaliza("segPaisViewFrm.valIden");'],[8,'','focaliza("segPaisViewFrm.indSaldUnic");','focaliza("segPaisViewFrm.indSaldUnic");','','focaliza("segPaisViewFrm.indSaldUnic");','focaliza("segPaisViewFrm.indSaldUnic");'],[9,'','focaliza("segPaisViewFrm.valProgEjec");','focaliza("segPaisViewFrm.valProgEjec");','','focaliza("segPaisViewFrm.valProgEjec");','focaliza("segPaisViewFrm.valProgEjec");'],[10,'','focaliza("segPaisViewFrm.valPorcAlar");','focaliza("segPaisViewFrm.valPorcAlar");','','focaliza("segPaisViewFrm.valPorcAlar");','focaliza("segPaisViewFrm.valPorcAlar");'],[11,'','focaliza("segPaisViewFrm.indCompAuto");','focaliza("segPaisViewFrm.indCompAuto");','','focaliza("segPaisViewFrm.indCompAuto");','focaliza("segPaisViewFrm.indCompAuto");'],[12,'','focaliza("segPaisViewFrm.numDiasMora");','focaliza("segPaisViewFrm.numDiasMora");','','focaliza("segPaisViewFrm.numDiasMora");','focaliza("segPaisViewFrm.numDiasMora");'],[13,'','focaliza("segPaisViewFrm.indTratAcumDesc");','focaliza("segPaisViewFrm.indTratAcumDesc");','','focaliza("segPaisViewFrm.indTratAcumDesc");','focaliza("segPaisViewFrm.indTratAcumDesc");'],[14,'','focaliza("segPaisViewFrm.valTiemRezo");','focaliza("segPaisViewFrm.valTiemRezo");','','focaliza("segPaisViewFrm.valTiemRezo");','focaliza("segPaisViewFrm.valTiemRezo");'],[15,'','focaliza("segPaisViewFrm.valConfSecuCcc");','focaliza("segPaisViewFrm.valConfSecuCcc");','','focaliza("segPaisViewFrm.valConfSecuCcc");','focaliza("segPaisViewFrm.valConfSecuCcc");'],[16,'','focaliza("segPaisViewFrm.numDiasFact");','focaliza("segPaisViewFrm.numDiasFact");','','focaliza("segPaisViewFrm.numDiasFact");','focaliza("segPaisViewFrm.numDiasFact");'],[17,'','focaliza("segPaisViewFrm.numLimiDifePago");','focaliza("segPaisViewFrm.numLimiDifePago");','','focaliza("segPaisViewFrm.numLimiDifePago");','focaliza("segPaisViewFrm.numLimiDifePago");'],[18,'','focaliza("segPaisViewFrm.indEmisVenc");','focaliza("segPaisViewFrm.indEmisVenc");','','focaliza("segPaisViewFrm.indEmisVenc");','focaliza("segPaisViewFrm.indEmisVenc");'],[19,'','focaliza("segPaisViewFrm.valMaxiDifeAnlsComb");','focaliza("segPaisViewFrm.valMaxiDifeAnlsComb");','','focaliza("segPaisViewFrm.valMaxiDifeAnlsComb");','focaliza("segPaisViewFrm.valMaxiDifeAnlsComb");'],[20,'','focaliza("segPaisViewFrm.numPosiNumeClie");','focaliza("segPaisViewFrm.numPosiNumeClie");','','focaliza("segPaisViewFrm.numPosiNumeClie");','focaliza("segPaisViewFrm.numPosiNumeClie");'],[21,'','focaliza("segPaisViewFrm.valFormFech");','focaliza("segPaisViewFrm.valFormFech");','','focaliza("segPaisViewFrm.valFormFech");','focaliza("segPaisViewFrm.valFormFech");'],[22,'','focaliza("segPaisViewFrm.valSepaMile");','focaliza("segPaisViewFrm.valSepaMile");','','focaliza("segPaisViewFrm.valSepaMile");','focaliza("segPaisViewFrm.valSepaMile");'],[23,'','focaliza("segPaisViewFrm.valSepaDeci");','focaliza("segPaisViewFrm.valSepaDeci");','','focaliza("segPaisViewFrm.valSepaDeci");','focaliza("segPaisViewFrm.valSepaDeci");'],[24,'','focaliza("segPaisViewFrm.numPeriEgre");','focaliza("segPaisViewFrm.numPeriEgre");','','focaliza("segPaisViewFrm.numPeriEgre");','focaliza("segPaisViewFrm.numPeriEgre");'],[25,'','focaliza("segPaisViewFrm.numPeriReti");','focaliza("segPaisViewFrm.numPeriReti");','','focaliza("segPaisViewFrm.numPeriReti");','focaliza("segPaisViewFrm.numPeriReti");'],[26,'','focalizaComboDependence("segPaisView","fopaOidFormPago", false);','focalizaComboDependence("segPaisView","fopaOidFormPago", false);','','focalizaComboDependence("segPaisView","fopaOidFormPago", true);','focalizaComboDependence("segPaisView","fopaOidFormPago", true);'],[27,'','focaliza("segPaisViewFrm.valCompTele");','focaliza("segPaisViewFrm.valCompTele");','','focaliza("segPaisViewFrm.valCompTele");','focaliza("segPaisViewFrm.valCompTele");'],[28,'','focaliza("segPaisViewFrm.indFletZonaUbig");','focaliza("segPaisViewFrm.indFletZonaUbig");','','focaliza("segPaisViewFrm.indFletZonaUbig");','focaliza("segPaisViewFrm.indFletZonaUbig");'],[29,'','focaliza("segPaisViewFrm.valIndiSecuMoni");','focaliza("segPaisViewFrm.valIndiSecuMoni");','','focaliza("segPaisViewFrm.valIndiSecuMoni");','focaliza("segPaisViewFrm.valIndiSecuMoni");'],[30,'','focaliza("segPaisViewFrm.indSecu");','focaliza("segPaisViewFrm.indSecu");','','focaliza("segPaisViewFrm.indSecu");','focaliza("segPaisViewFrm.indSecu");'],[31,'','focaliza("segPaisViewFrm.indBalaAreaCheq");','focaliza("segPaisViewFrm.indBalaAreaCheq");','','focaliza("segPaisViewFrm.indBalaAreaCheq");','focaliza("segPaisViewFrm.indBalaAreaCheq");'],[32,'','focaliza("segPaisViewFrm.valUrl");','focaliza("segPaisViewFrm.valUrl");','','focaliza("segPaisViewFrm.valUrl");','focaliza("segPaisViewFrm.valUrl");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var moneOidMoneDependeceMap = new Vector();
moneOidMoneDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
moneOidMoneDependeceMap.agregar(['moneOidMone', padresTmp, '', 'SegMoned']);
var moneOidMoneAltDependeceMap = new Vector();
moneOidMoneAltDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
moneOidMoneAltDependeceMap.agregar(['moneOidMoneAlt', padresTmp, '', 'SegMoned']);
var fopaOidFormPagoDependeceMap = new Vector();
fopaOidFormPagoDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
fopaOidFormPagoDependeceMap.agregar(['fopaOidFormPago', padresTmp, '', 'BelFormaPagoTapon']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
segPaisViewLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var segPaisViewTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function segPaisViewInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('segPaisViewFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('segPaisViewFrm.accion')){
		case "query": segPaisViewQueryInitComponents(); break;
		case "view": segPaisViewViewInitComponents(); break;
		case "create": segPaisViewCreateInitComponents(); break;
		case "update": segPaisViewUpdateInitComponents(); break;
		case "remove": segPaisViewRemoveInitComponents(); break;
		case "lov": segPaisViewLovInitComponents(); break;
	}
	//alert('accion :' + get('segPaisViewFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('segPaisViewFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('segPaisView')) segPaisViewCmdRequery();
}

function segPaisViewQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	focusFirstField('segPaisViewFrm', true);	
}

function segPaisViewViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('segPaisViewFrm', 'Descripcion', 1);
	
		
	//Establecemos el valor de los radiobuttons
		set('segPaisViewFrm.indSaldUnic', get('segPaisViewFrm.indSaldUnicCheckValue'));
		set('segPaisViewFrm.indTratAcumDesc', get('segPaisViewFrm.indTratAcumDescCheckValue'));
		set('segPaisViewFrm.indEmisVenc', get('segPaisViewFrm.indEmisVencCheckValue'));
		set('segPaisViewFrm.valIndiSecuMoni', get('segPaisViewFrm.valIndiSecuMoniCheckValue'));
		
	focusFirstField('segPaisViewFrm', true);
}

function segPaisViewCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('segPaisViewFrm.codPais','S', GestionarMensaje('SegPaisView.codPais.requiered.message'));
	
	setMV('segPaisViewFrm.moneOidMone','S', GestionarMensaje('SegPaisView.moneOidMone.requiered.message'));
	
	setMV('segPaisViewFrm.Descripcion','S', GestionarMensaje('SegPaisView.Descripcion.requiered.message'));
	
	setMV('segPaisViewFrm.indInteGis','S', GestionarMensaje('SegPaisView.indInteGis.requiered.message'));
	
	setMV('segPaisViewFrm.valIden','S', GestionarMensaje('SegPaisView.valIden.requiered.message'));
	
	setMV('segPaisViewFrm.indSaldUnic','S', GestionarMensaje('SegPaisView.indSaldUnic.requiered.message'));
	
	setMV('segPaisViewFrm.valProgEjec','S', GestionarMensaje('SegPaisView.valProgEjec.requiered.message'));
	
	setMV('segPaisViewFrm.valPorcAlar','S', GestionarMensaje('SegPaisView.valPorcAlar.requiered.message'));
	
	setMV('segPaisViewFrm.indCompAuto','S', GestionarMensaje('SegPaisView.indCompAuto.requiered.message'));
	
	setMV('segPaisViewFrm.numDiasMora','S', GestionarMensaje('SegPaisView.numDiasMora.requiered.message'));
	
	setMV('segPaisViewFrm.indTratAcumDesc','S', GestionarMensaje('SegPaisView.indTratAcumDesc.requiered.message'));
	
	setMV('segPaisViewFrm.valTiemRezo','S', GestionarMensaje('SegPaisView.valTiemRezo.requiered.message'));
	
	setMV('segPaisViewFrm.valConfSecuCcc','S', GestionarMensaje('SegPaisView.valConfSecuCcc.requiered.message'));
	
	setMV('segPaisViewFrm.numDiasFact','S', GestionarMensaje('SegPaisView.numDiasFact.requiered.message'));
	
	setMV('segPaisViewFrm.numLimiDifePago','S', GestionarMensaje('SegPaisView.numLimiDifePago.requiered.message'));
	
	setMV('segPaisViewFrm.indEmisVenc','S', GestionarMensaje('SegPaisView.indEmisVenc.requiered.message'));
	
	setMV('segPaisViewFrm.valMaxiDifeAnlsComb','S', GestionarMensaje('SegPaisView.valMaxiDifeAnlsComb.requiered.message'));
	
	setMV('segPaisViewFrm.numPosiNumeClie','S', GestionarMensaje('SegPaisView.numPosiNumeClie.requiered.message'));
	
	setMV('segPaisViewFrm.valFormFech','S', GestionarMensaje('SegPaisView.valFormFech.requiered.message'));
	
	setMV('segPaisViewFrm.valSepaMile','S', GestionarMensaje('SegPaisView.valSepaMile.requiered.message'));
	
	setMV('segPaisViewFrm.valSepaDeci','S', GestionarMensaje('SegPaisView.valSepaDeci.requiered.message'));
	
	setMV('segPaisViewFrm.numPeriEgre','S', GestionarMensaje('SegPaisView.numPeriEgre.requiered.message'));
	
	setMV('segPaisViewFrm.numPeriReti','S', GestionarMensaje('SegPaisView.numPeriReti.requiered.message'));
	
	setMV('segPaisViewFrm.indFletZonaUbig','S', GestionarMensaje('SegPaisView.indFletZonaUbig.requiered.message'));
	
	setMV('segPaisViewFrm.valIndiSecuMoni','S', GestionarMensaje('SegPaisView.valIndiSecuMoni.requiered.message'));
	
	setMV('segPaisViewFrm.valUrl','S', GestionarMensaje('SegPaisView.valUrl.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('segPaisViewFrm', true);
}

function segPaisViewUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('segPaisViewFrm.origen') == "pagina"){
		loadLocalizationWidget('segPaisViewFrm', 'Descripcion', 1);
		

		//Establecemos el valor de los radiobuttons
			set('segPaisViewFrm.indSaldUnic', get('segPaisViewFrm.indSaldUnicCheckValue'));
			set('segPaisViewFrm.indTratAcumDesc', get('segPaisViewFrm.indTratAcumDescCheckValue'));
			set('segPaisViewFrm.indEmisVenc', get('segPaisViewFrm.indEmisVencCheckValue'));
			set('segPaisViewFrm.valIndiSecuMoni', get('segPaisViewFrm.valIndiSecuMoniCheckValue'));
			

		//Registramos el valor del elemento que estamos modificando
		segPaisViewTmpUpdateValues = segPaisViewBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('segPaisViewFrm.codPais','S', GestionarMensaje('SegPaisView.codPais.requiered.message'));
		setMV('segPaisViewFrm.moneOidMone','S', GestionarMensaje('SegPaisView.moneOidMone.requiered.message'));
		setMV('segPaisViewFrm.Descripcion','S', GestionarMensaje('SegPaisView.Descripcion.requiered.message'));
		setMV('segPaisViewFrm.indInteGis','S', GestionarMensaje('SegPaisView.indInteGis.requiered.message'));
		setMV('segPaisViewFrm.valIden','S', GestionarMensaje('SegPaisView.valIden.requiered.message'));
		setMV('segPaisViewFrm.indSaldUnic','S', GestionarMensaje('SegPaisView.indSaldUnic.requiered.message'));
		setMV('segPaisViewFrm.valProgEjec','S', GestionarMensaje('SegPaisView.valProgEjec.requiered.message'));
		setMV('segPaisViewFrm.valPorcAlar','S', GestionarMensaje('SegPaisView.valPorcAlar.requiered.message'));
		setMV('segPaisViewFrm.indCompAuto','S', GestionarMensaje('SegPaisView.indCompAuto.requiered.message'));
		setMV('segPaisViewFrm.numDiasMora','S', GestionarMensaje('SegPaisView.numDiasMora.requiered.message'));
		setMV('segPaisViewFrm.indTratAcumDesc','S', GestionarMensaje('SegPaisView.indTratAcumDesc.requiered.message'));
		setMV('segPaisViewFrm.valTiemRezo','S', GestionarMensaje('SegPaisView.valTiemRezo.requiered.message'));
		setMV('segPaisViewFrm.valConfSecuCcc','S', GestionarMensaje('SegPaisView.valConfSecuCcc.requiered.message'));
		setMV('segPaisViewFrm.numDiasFact','S', GestionarMensaje('SegPaisView.numDiasFact.requiered.message'));
		setMV('segPaisViewFrm.numLimiDifePago','S', GestionarMensaje('SegPaisView.numLimiDifePago.requiered.message'));
		setMV('segPaisViewFrm.indEmisVenc','S', GestionarMensaje('SegPaisView.indEmisVenc.requiered.message'));
		setMV('segPaisViewFrm.valMaxiDifeAnlsComb','S', GestionarMensaje('SegPaisView.valMaxiDifeAnlsComb.requiered.message'));
		setMV('segPaisViewFrm.numPosiNumeClie','S', GestionarMensaje('SegPaisView.numPosiNumeClie.requiered.message'));
		setMV('segPaisViewFrm.valFormFech','S', GestionarMensaje('SegPaisView.valFormFech.requiered.message'));
		setMV('segPaisViewFrm.valSepaMile','S', GestionarMensaje('SegPaisView.valSepaMile.requiered.message'));
		setMV('segPaisViewFrm.valSepaDeci','S', GestionarMensaje('SegPaisView.valSepaDeci.requiered.message'));
		setMV('segPaisViewFrm.numPeriEgre','S', GestionarMensaje('SegPaisView.numPeriEgre.requiered.message'));
		setMV('segPaisViewFrm.numPeriReti','S', GestionarMensaje('SegPaisView.numPeriReti.requiered.message'));
		setMV('segPaisViewFrm.indFletZonaUbig','S', GestionarMensaje('SegPaisView.indFletZonaUbig.requiered.message'));
		setMV('segPaisViewFrm.valIndiSecuMoni','S', GestionarMensaje('SegPaisView.valIndiSecuMoni.requiered.message'));
		setMV('segPaisViewFrm.valUrl','S', GestionarMensaje('SegPaisView.valUrl.requiered.message'));
		
			focusFirstFieldModify('segPaisViewFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		focusFirstField('segPaisViewFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('segPaisViewFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function segPaisViewRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	segPaisViewList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('segPaisViewFrm', true);
}

function segPaisViewLovInitComponents(){
	segPaisViewLovReturnParameters = window.dialogArguments;
	
	focusFirstField('segPaisViewFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad


































//Función que permite cargar los datos de un elemento de lov seleccionado
function segPaisViewSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('segPaisViewFrm.' + campo, id);
	set('segPaisViewFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function segPaisViewLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	segPaisViewLovReturnParameters.id = '';
	segPaisViewLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function segPaisViewLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(segPaisViewList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = segPaisViewList.codSeleccionados();
	var descripcion = segPaisViewList.extraeDato(
		segPaisViewList.codSeleccionados()[0], segPaisViewChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	segPaisViewLovReturnParameters.id = codigo;
	segPaisViewLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function segPaisViewCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('segPaisViewFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('segPaisViewFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "segPaisViewList", "SegPaisViewConectorTransactionQuery", 
		"result_ROWSET", parametros, "segPaisViewPostQueryActions(datos);"]], "", "");	
}

function segPaisViewCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('segPaisViewFrm.lastQueryToSession'));
	var i =0;
	set('segPaisViewFrm.codPais', paramsRequery.ij(i++));
	
	set('segPaisViewFrm.moneOidMone', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la página de busqueda como la actual
	segPaisViewPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	segPaisViewCmdQuery(segPaisViewPageCount);
}

function segPaisViewFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	segPaisViewPageCount = 1;
	segPaisViewCmdQuery(segPaisViewPageCount);
}

function segPaisViewPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != segPaisViewLastQuery){
		segPaisViewFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	segPaisViewPageCount--;
	segPaisViewCmdQuery(segPaisViewPageCount);
}

function segPaisViewNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != segPaisViewLastQuery){
		segPaisViewFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	segPaisViewPageCount++;
	segPaisViewCmdQuery(segPaisViewPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function segPaisViewPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('segPaisViewListLayer', 'O');
		visibilidad('segPaisViewListButtonsLayer', 'O');
		if(get('segPaisViewFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	segPaisViewLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:segPaisViewViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, segPaisViewChoiceColumn) + "</A>",
			i, segPaisViewChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	segPaisViewList.setDatos(datosTmp.filtrar([0,1,2],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	segPaisViewTimeStamps = datosTmp.filtrar([3],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		segPaisViewMorePagesFlag = true;
		segPaisViewList.eliminar(mmgPageSize, 1);
	}else{
		segPaisViewMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('segPaisViewFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('segPaisViewListLayer', 'V');
	visibilidad('segPaisViewListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('segPaisViewList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	segPaisViewList.display();
	
	//Actualizamos el estado de los botones 
	if(segPaisViewMorePagesFlag){
		set_estado_botonera('segPaisViewPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('segPaisViewPaginationButtonBar',
			3,"inactivo");
	}
	if(segPaisViewPageCount > 1){
		set_estado_botonera('segPaisViewPaginationButtonBar',
			2,"activo");
		set_estado_botonera('segPaisViewPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('segPaisViewPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('segPaisViewPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function segPaisViewUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(segPaisViewList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('segPaisViewFrm.idSelection', segPaisViewList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('segPaisViewFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = segPaisViewList.codSeleccionados()[0];
		parametros["previousAction"] = get('segPaisViewFrm.accion');
		parametros["accion"] = get('segPaisViewFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('SegPaisViewLPStartUp', get('segPaisViewFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) segPaisViewCmdRequery();
	}
}

function segPaisViewRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(segPaisViewList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = segPaisViewList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('segPaisViewFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(segPaisViewList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += segPaisViewTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('segPaisViewFrm.timestamp', timestamps);


	segPaisViewFrm.oculto='S';
	envia('segPaisViewFrm');
	segPaisViewFrm.oculto='N';
}

function segPaisViewViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(segPaisViewList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	segPaisViewViewDetail(segPaisViewList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function segPaisViewViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('segPaisViewFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('SegPaisViewLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	
	setDefaultLanguageValue('segPaisViewFrm', 
		'Descripcion', 1,
		get('segPaisViewFrm.Descripcion'));	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('segPaisViewFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	if(!hasDefaultLanguageValue('segPaisViewFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('SegPaisView.Descripcion.requiered.message'));
		focaliza('segPaisViewFrm.Descripcion');
		return;
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	if(validacion){
		segPaisViewFrm.oculto='S';
		envia('segPaisViewFrm');
		segPaisViewFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('segPaisViewFrm.moneOidMone').toString() == ''){
		set('segPaisViewFrm.moneOidMone', []);
		mmgResetCombosOnCascade('moneOidMone', 'moneOidMone', 'segPaisView');
		
	}
	if(get('segPaisViewFrm.moneOidMoneAlt').toString() == ''){
		set('segPaisViewFrm.moneOidMoneAlt', []);
		mmgResetCombosOnCascade('moneOidMoneAlt', 'moneOidMoneAlt', 'segPaisView');
		
	}
	if(get('segPaisViewFrm.fopaOidFormPago').toString() == ''){
		set('segPaisViewFrm.fopaOidFormPago', []);
		mmgResetCombosOnCascade('fopaOidFormPago', 'fopaOidFormPago', 'segPaisView');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	segPaisViewRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('segPaisViewFrm.accion');
	var origenTmp = get('segPaisViewFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(segPaisViewBuildUpdateRecordString() != segPaisViewTmpUpdateValues){
			var respuesta = cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.update.lostchanges.message'));
			if(respuesta == true){
				Guardar();
				return;
			}
		}
		window.close();
	}else if(accionTmp == 'view'){
		window.close();
	}
}

//Cambia el estado de las cajas de texto de los lovs del formulario
function setNonEditableElementsStatus(status){
	
}

function minimizeLayers(){
	document.all.segPaisViewListLayer.style.display='none';
	document.all.segPaisViewListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.segPaisViewListLayer.style.display='';
	document.all.segPaisViewListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsSegPaisViewCodPais = get('segPaisViewFrm.codPais').toString();
	jsSegPaisViewMoneOidMone = get('segPaisViewFrm.moneOidMone')[0];
	
	
	var parametros = "";
	parametros += jsSegPaisViewCodPais + "|";
	parametros += jsSegPaisViewMoneOidMone + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function segPaisViewBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsSegPaisViewCodPais + "|";
	parametros += jsSegPaisViewMoneOidMone + "|";
	parametros += jsSegPaisViewMoneOidMoneAlt + "|";
	parametros += jsSegPaisViewDescripcion + "|";
	parametros += jsSegPaisViewIndInteGis + "|";
	parametros += jsSegPaisViewValIden + "|";
	parametros += jsSegPaisViewIndSaldUnic + "|";
	parametros += jsSegPaisViewValProgEjec + "|";
	parametros += jsSegPaisViewValPorcAlar + "|";
	parametros += jsSegPaisViewIndCompAuto + "|";
	parametros += jsSegPaisViewNumDiasMora + "|";
	parametros += jsSegPaisViewIndTratAcumDesc + "|";
	parametros += jsSegPaisViewValTiemRezo + "|";
	parametros += jsSegPaisViewValConfSecuCcc + "|";
	parametros += jsSegPaisViewNumDiasFact + "|";
	parametros += jsSegPaisViewNumLimiDifePago + "|";
	parametros += jsSegPaisViewIndEmisVenc + "|";
	parametros += jsSegPaisViewValMaxiDifeAnlsComb + "|";
	parametros += jsSegPaisViewNumPosiNumeClie + "|";
	parametros += jsSegPaisViewValFormFech + "|";
	parametros += jsSegPaisViewValSepaMile + "|";
	parametros += jsSegPaisViewValSepaDeci + "|";
	parametros += jsSegPaisViewNumPeriEgre + "|";
	parametros += jsSegPaisViewNumPeriReti + "|";
	parametros += jsSegPaisViewFopaOidFormPago + "|";
	parametros += jsSegPaisViewValCompTele + "|";
	parametros += jsSegPaisViewIndFletZonaUbig + "|";
	parametros += jsSegPaisViewValIndiSecuMoni + "|";
	parametros += jsSegPaisViewIndSecu + "|";
	parametros += jsSegPaisViewIndBalaAreaCheq + "|";
	parametros += jsSegPaisViewValUrl + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('segPaisViewFrm.accion'), 
		get('segPaisViewFrm.origen'));
	
	jsSegPaisViewId = get('segPaisViewFrm.id').toString();
	jsSegPaisViewCodPais = get('segPaisViewFrm.codPais').toString();
	jsSegPaisViewMoneOidMone = get('segPaisViewFrm.moneOidMone')[0];
	jsSegPaisViewMoneOidMoneAlt = get('segPaisViewFrm.moneOidMoneAlt')[0];
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsSegPaisViewDescripcion = buildLocalizedString('segPaisViewFrm', 1);
	}else{
		jsSegPaisViewDescripcion = get('segPaisViewFrm.Descripcion');
	}
	jsSegPaisViewIndInteGis = get('segPaisViewFrm.indInteGis')[0];
	jsSegPaisViewValIden = get('segPaisViewFrm.valIden')[0];
	jsSegPaisViewIndSaldUnic = get('segPaisViewFrm.indSaldUnic');
	jsSegPaisViewValProgEjec = get('segPaisViewFrm.valProgEjec').toString();
	jsSegPaisViewValPorcAlar = get('segPaisViewFrm.valPorcAlar').toString();
	jsSegPaisViewIndCompAuto = get('segPaisViewFrm.indCompAuto').toString();
	jsSegPaisViewNumDiasMora = get('segPaisViewFrm.numDiasMora').toString();
	jsSegPaisViewIndTratAcumDesc = get('segPaisViewFrm.indTratAcumDesc');
	jsSegPaisViewValTiemRezo = get('segPaisViewFrm.valTiemRezo').toString();
	jsSegPaisViewValConfSecuCcc = get('segPaisViewFrm.valConfSecuCcc')[0];
	jsSegPaisViewNumDiasFact = get('segPaisViewFrm.numDiasFact').toString();
	jsSegPaisViewNumLimiDifePago = get('segPaisViewFrm.numLimiDifePago').toString();
	jsSegPaisViewIndEmisVenc = get('segPaisViewFrm.indEmisVenc');
	jsSegPaisViewValMaxiDifeAnlsComb = get('segPaisViewFrm.valMaxiDifeAnlsComb').toString();
	jsSegPaisViewNumPosiNumeClie = get('segPaisViewFrm.numPosiNumeClie').toString();
	jsSegPaisViewValFormFech = get('segPaisViewFrm.valFormFech')[0];
	jsSegPaisViewValSepaMile = get('segPaisViewFrm.valSepaMile')[0];
	jsSegPaisViewValSepaDeci = get('segPaisViewFrm.valSepaDeci')[0];
	jsSegPaisViewNumPeriEgre = get('segPaisViewFrm.numPeriEgre').toString();
	jsSegPaisViewNumPeriReti = get('segPaisViewFrm.numPeriReti').toString();
	jsSegPaisViewFopaOidFormPago = get('segPaisViewFrm.fopaOidFormPago')[0];
	jsSegPaisViewValCompTele = get('segPaisViewFrm.valCompTele').toString();
	jsSegPaisViewIndFletZonaUbig = get('segPaisViewFrm.indFletZonaUbig')[0];
	jsSegPaisViewValIndiSecuMoni = get('segPaisViewFrm.valIndiSecuMoni');
	jsSegPaisViewIndSecu = get('segPaisViewFrm.indSecu')[0];
	jsSegPaisViewIndBalaAreaCheq = get('segPaisViewFrm.indBalaAreaCheq')[0];
	jsSegPaisViewValUrl = get('segPaisViewFrm.valUrl').toString();
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('segPaisViewFrm.accion'), 
		get('segPaisViewFrm.origen'));


	set('segPaisViewFrm.id', jsSegPaisViewId);
	set('segPaisViewFrm.codPais', jsSegPaisViewCodPais);
	set('segPaisViewFrm.moneOidMone', [jsSegPaisViewMoneOidMone]);
	set('segPaisViewFrm.moneOidMoneAlt', [jsSegPaisViewMoneOidMoneAlt]);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('segPaisViewFrm', 1,  jsSegPaisViewDescripcion)
		loadLocalizationWidget('segPaisViewFrm', 'Descripcion', 1);
	}else{
		set('segPaisViewFrm.Descripcion', jsSegPaisViewDescripcion);		
	}
	set('segPaisViewFrm.indInteGis', [jsSegPaisViewIndInteGis]);
	set('segPaisViewFrm.valIden', [jsSegPaisViewValIden]);
	set('segPaisViewFrm.indSaldUnic', jsSegPaisViewIndSaldUnic);
	set('segPaisViewFrm.valProgEjec', jsSegPaisViewValProgEjec);
	set('segPaisViewFrm.valPorcAlar', jsSegPaisViewValPorcAlar);
	set('segPaisViewFrm.indCompAuto', jsSegPaisViewIndCompAuto);
	set('segPaisViewFrm.numDiasMora', jsSegPaisViewNumDiasMora);
	set('segPaisViewFrm.indTratAcumDesc', jsSegPaisViewIndTratAcumDesc);
	set('segPaisViewFrm.valTiemRezo', jsSegPaisViewValTiemRezo);
	set('segPaisViewFrm.valConfSecuCcc', [jsSegPaisViewValConfSecuCcc]);
	set('segPaisViewFrm.numDiasFact', jsSegPaisViewNumDiasFact);
	set('segPaisViewFrm.numLimiDifePago', jsSegPaisViewNumLimiDifePago);
	set('segPaisViewFrm.indEmisVenc', jsSegPaisViewIndEmisVenc);
	set('segPaisViewFrm.valMaxiDifeAnlsComb', jsSegPaisViewValMaxiDifeAnlsComb);
	set('segPaisViewFrm.numPosiNumeClie', jsSegPaisViewNumPosiNumeClie);
	set('segPaisViewFrm.valFormFech', [jsSegPaisViewValFormFech]);
	set('segPaisViewFrm.valSepaMile', [jsSegPaisViewValSepaMile]);
	set('segPaisViewFrm.valSepaDeci', [jsSegPaisViewValSepaDeci]);
	set('segPaisViewFrm.numPeriEgre', jsSegPaisViewNumPeriEgre);
	set('segPaisViewFrm.numPeriReti', jsSegPaisViewNumPeriReti);
	set('segPaisViewFrm.fopaOidFormPago', [jsSegPaisViewFopaOidFormPago]);
	set('segPaisViewFrm.valCompTele', jsSegPaisViewValCompTele);
	set('segPaisViewFrm.indFletZonaUbig', [jsSegPaisViewIndFletZonaUbig]);
	set('segPaisViewFrm.valIndiSecuMoni', jsSegPaisViewValIndiSecuMoni);
	set('segPaisViewFrm.indSecu', [jsSegPaisViewIndSecu]);
	set('segPaisViewFrm.indBalaAreaCheq', [jsSegPaisViewIndBalaAreaCheq]);
	set('segPaisViewFrm.valUrl', jsSegPaisViewValUrl);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsSegPaisViewCodPais = '';
	jsSegPaisViewMoneOidMone = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('segPaisViewFrm.errCodigo', errorCode);
	set('segPaisViewFrm.errDescripcion', description);
	set('segPaisViewFrm.errSeverity', severity);
	fMostrarMensajeError();
}
