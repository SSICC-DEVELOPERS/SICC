

/*
    INDRA/CAR/mmg
    $Id: segpais.js,v 1.1 2009/12/03 19:02:04 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsSegPaisId = "";
var jsSegPaisCodPais = "";
var jsSegPaisMoneOidMone = "";
var jsSegPaisMoneOidMoneAlt = "";
var jsSegPaisDescripcion = "";
var jsSegPaisIndInteGis = "";
var jsSegPaisValIden = "";
var jsSegPaisIndSaldUnic = "";
var jsSegPaisValProgEjec = "";
var jsSegPaisValPorcAlar = "";
var jsSegPaisIndCompAuto = "";
var jsSegPaisNumDiasMora = "";
var jsSegPaisIndTratAcumDesc = "";
var jsSegPaisValTiemRezo = "";
var jsSegPaisValConfSecuCcc = "";
var jsSegPaisNumDiasFact = "";
var jsSegPaisNumLimiDifePago = "";
var jsSegPaisIndEmisVenc = "";
var jsSegPaisValMaxiDifeAnlsComb = "";
var jsSegPaisNumPosiNumeClie = "";
var jsSegPaisValFormFech = "";
var jsSegPaisValSepaMile = "";
var jsSegPaisValSepaDeci = "";
var jsSegPaisNumPeriEgre = "";
var jsSegPaisNumPeriReti = "";
var jsSegPaisFopaOidFormPago = "";
var jsSegPaisValCompTele = "";
var jsSegPaisIndFletZonaUbig = "";
var jsSegPaisValIndiSecuMoni = "";
var jsSegPaisIndSecu = "";
var jsSegPaisIndBalaAreaCheq = "";
var jsSegPaisValUrl = "";
var jsSegPaisIndImpuIncl = "";

//Variables de paginacion, 
var segPaisPageCount = 1;

//Varible de columna que representa el campo de choice
var segPaisChoiceColumn = 2;

//Flag de siguiente pagina;
var segPaisMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var segPaisTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 105;
var sizeFormView = 425;
var sizeFormUpdate = 425;

//Ultima busqueda realizada
var segPaisLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("segPaisFrm.codPais");','focaliza("segPaisFrm.codPais");','focaliza("segPaisFrm.codPais");','focaliza("segPaisFrm.codPais");','focaliza("segPaisFrm.codPais");','focaliza("segPaisFrm.codPais");'],[3,'focalizaComboDependence("segPais","moneOidMone", false);','focalizaComboDependence("segPais","moneOidMone", false);','focalizaComboDependence("segPais","moneOidMone", false);','focalizaComboDependence("segPais","moneOidMone", true);','focalizaComboDependence("segPais","moneOidMone", true);','focalizaComboDependence("segPais","moneOidMone", true);'],[4,'','focalizaComboDependence("segPais","moneOidMoneAlt", false);','focalizaComboDependence("segPais","moneOidMoneAlt", false);','','focalizaComboDependence("segPais","moneOidMoneAlt", true);','focalizaComboDependence("segPais","moneOidMoneAlt", true);'],[5,'','focaliza("segPaisFrm.Descripcion");','focaliza("segPaisFrm.Descripcion");','','focaliza("segPaisFrm.Descripcion");','focaliza("segPaisFrm.Descripcion");'],[6,'','focaliza("segPaisFrm.indInteGis");','focaliza("segPaisFrm.indInteGis");','','focaliza("segPaisFrm.indInteGis");','focaliza("segPaisFrm.indInteGis");'],[7,'','focaliza("segPaisFrm.valIden");','focaliza("segPaisFrm.valIden");','','focaliza("segPaisFrm.valIden");','focaliza("segPaisFrm.valIden");'],[8,'','focaliza("segPaisFrm.indSaldUnic");','focaliza("segPaisFrm.indSaldUnic");','','focaliza("segPaisFrm.indSaldUnic");','focaliza("segPaisFrm.indSaldUnic");'],[9,'','focaliza("segPaisFrm.valProgEjec");','focaliza("segPaisFrm.valProgEjec");','','focaliza("segPaisFrm.valProgEjec");','focaliza("segPaisFrm.valProgEjec");'],[10,'','focaliza("segPaisFrm.valPorcAlar");','focaliza("segPaisFrm.valPorcAlar");','','focaliza("segPaisFrm.valPorcAlar");','focaliza("segPaisFrm.valPorcAlar");'],[11,'','focaliza("segPaisFrm.indCompAuto");','focaliza("segPaisFrm.indCompAuto");','','focaliza("segPaisFrm.indCompAuto");','focaliza("segPaisFrm.indCompAuto");'],[12,'','focaliza("segPaisFrm.numDiasMora");','focaliza("segPaisFrm.numDiasMora");','','focaliza("segPaisFrm.numDiasMora");','focaliza("segPaisFrm.numDiasMora");'],[13,'','focaliza("segPaisFrm.indTratAcumDesc");','focaliza("segPaisFrm.indTratAcumDesc");','','focaliza("segPaisFrm.indTratAcumDesc");','focaliza("segPaisFrm.indTratAcumDesc");'],[14,'','focaliza("segPaisFrm.valTiemRezo");','focaliza("segPaisFrm.valTiemRezo");','','focaliza("segPaisFrm.valTiemRezo");','focaliza("segPaisFrm.valTiemRezo");'],[15,'','focaliza("segPaisFrm.valConfSecuCcc");','focaliza("segPaisFrm.valConfSecuCcc");','','focaliza("segPaisFrm.valConfSecuCcc");','focaliza("segPaisFrm.valConfSecuCcc");'],[16,'','focaliza("segPaisFrm.numDiasFact");','focaliza("segPaisFrm.numDiasFact");','','focaliza("segPaisFrm.numDiasFact");','focaliza("segPaisFrm.numDiasFact");'],[17,'','focaliza("segPaisFrm.numLimiDifePago");','focaliza("segPaisFrm.numLimiDifePago");','','focaliza("segPaisFrm.numLimiDifePago");','focaliza("segPaisFrm.numLimiDifePago");'],[18,'','focaliza("segPaisFrm.indEmisVenc");','focaliza("segPaisFrm.indEmisVenc");','','focaliza("segPaisFrm.indEmisVenc");','focaliza("segPaisFrm.indEmisVenc");'],[19,'','focaliza("segPaisFrm.valMaxiDifeAnlsComb");','focaliza("segPaisFrm.valMaxiDifeAnlsComb");','','focaliza("segPaisFrm.valMaxiDifeAnlsComb");','focaliza("segPaisFrm.valMaxiDifeAnlsComb");'],[20,'','focaliza("segPaisFrm.numPosiNumeClie");','focaliza("segPaisFrm.numPosiNumeClie");','','focaliza("segPaisFrm.numPosiNumeClie");','focaliza("segPaisFrm.numPosiNumeClie");'],[21,'','focaliza("segPaisFrm.valFormFech");','focaliza("segPaisFrm.valFormFech");','','focaliza("segPaisFrm.valFormFech");','focaliza("segPaisFrm.valFormFech");'],[22,'','focaliza("segPaisFrm.valSepaMile");','focaliza("segPaisFrm.valSepaMile");','','focaliza("segPaisFrm.valSepaMile");','focaliza("segPaisFrm.valSepaMile");'],[23,'','focaliza("segPaisFrm.valSepaDeci");','focaliza("segPaisFrm.valSepaDeci");','','focaliza("segPaisFrm.valSepaDeci");','focaliza("segPaisFrm.valSepaDeci");'],[24,'','focaliza("segPaisFrm.numPeriEgre");','focaliza("segPaisFrm.numPeriEgre");','','focaliza("segPaisFrm.numPeriEgre");','focaliza("segPaisFrm.numPeriEgre");'],[25,'','focaliza("segPaisFrm.numPeriReti");','focaliza("segPaisFrm.numPeriReti");','','focaliza("segPaisFrm.numPeriReti");','focaliza("segPaisFrm.numPeriReti");'],[26,'','focalizaComboDependence("segPais","fopaOidFormPago", false);','focalizaComboDependence("segPais","fopaOidFormPago", false);','','focalizaComboDependence("segPais","fopaOidFormPago", true);','focalizaComboDependence("segPais","fopaOidFormPago", true);'],[27,'','focaliza("segPaisFrm.valCompTele");','focaliza("segPaisFrm.valCompTele");','','focaliza("segPaisFrm.valCompTele");','focaliza("segPaisFrm.valCompTele");'],[28,'','focaliza("segPaisFrm.indFletZonaUbig");','focaliza("segPaisFrm.indFletZonaUbig");','','focaliza("segPaisFrm.indFletZonaUbig");','focaliza("segPaisFrm.indFletZonaUbig");'],[29,'','focaliza("segPaisFrm.valIndiSecuMoni");','focaliza("segPaisFrm.valIndiSecuMoni");','','focaliza("segPaisFrm.valIndiSecuMoni");','focaliza("segPaisFrm.valIndiSecuMoni");'],[30,'','focaliza("segPaisFrm.indSecu");','focaliza("segPaisFrm.indSecu");','','focaliza("segPaisFrm.indSecu");','focaliza("segPaisFrm.indSecu");'],[31,'','focaliza("segPaisFrm.indBalaAreaCheq");','focaliza("segPaisFrm.indBalaAreaCheq");','','focaliza("segPaisFrm.indBalaAreaCheq");','focaliza("segPaisFrm.indBalaAreaCheq");'],[32,'','focaliza("segPaisFrm.valUrl");','focaliza("segPaisFrm.valUrl");','','focaliza("segPaisFrm.valUrl");','focaliza("segPaisFrm.valUrl");'],[33,'','focaliza("segPaisFrm.indImpuIncl");','focaliza("segPaisFrm.indImpuIncl");','','focaliza("segPaisFrm.indImpuIncl");','focaliza("segPaisFrm.indImpuIncl");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[4,'','focalizaComboDependence("segPais","moneOidMoneAlt", false);','focalizaComboDependence("segPais","moneOidMoneAlt", false);','','focalizaComboDependence("segPais","moneOidMoneAlt", true);','focalizaComboDependence("segPais","moneOidMoneAlt", true);'],[5,'','focaliza("segPaisFrm.Descripcion");','focaliza("segPaisFrm.Descripcion");','','focaliza("segPaisFrm.Descripcion");','focaliza("segPaisFrm.Descripcion");'],[6,'','focaliza("segPaisFrm.indInteGis");','focaliza("segPaisFrm.indInteGis");','','focaliza("segPaisFrm.indInteGis");','focaliza("segPaisFrm.indInteGis");'],[7,'','focaliza("segPaisFrm.valIden");','focaliza("segPaisFrm.valIden");','','focaliza("segPaisFrm.valIden");','focaliza("segPaisFrm.valIden");'],[8,'','focaliza("segPaisFrm.indSaldUnic");','focaliza("segPaisFrm.indSaldUnic");','','focaliza("segPaisFrm.indSaldUnic");','focaliza("segPaisFrm.indSaldUnic");'],[9,'','focaliza("segPaisFrm.valProgEjec");','focaliza("segPaisFrm.valProgEjec");','','focaliza("segPaisFrm.valProgEjec");','focaliza("segPaisFrm.valProgEjec");'],[10,'','focaliza("segPaisFrm.valPorcAlar");','focaliza("segPaisFrm.valPorcAlar");','','focaliza("segPaisFrm.valPorcAlar");','focaliza("segPaisFrm.valPorcAlar");'],[11,'','focaliza("segPaisFrm.indCompAuto");','focaliza("segPaisFrm.indCompAuto");','','focaliza("segPaisFrm.indCompAuto");','focaliza("segPaisFrm.indCompAuto");'],[12,'','focaliza("segPaisFrm.numDiasMora");','focaliza("segPaisFrm.numDiasMora");','','focaliza("segPaisFrm.numDiasMora");','focaliza("segPaisFrm.numDiasMora");'],[13,'','focaliza("segPaisFrm.indTratAcumDesc");','focaliza("segPaisFrm.indTratAcumDesc");','','focaliza("segPaisFrm.indTratAcumDesc");','focaliza("segPaisFrm.indTratAcumDesc");'],[14,'','focaliza("segPaisFrm.valTiemRezo");','focaliza("segPaisFrm.valTiemRezo");','','focaliza("segPaisFrm.valTiemRezo");','focaliza("segPaisFrm.valTiemRezo");'],[15,'','focaliza("segPaisFrm.valConfSecuCcc");','focaliza("segPaisFrm.valConfSecuCcc");','','focaliza("segPaisFrm.valConfSecuCcc");','focaliza("segPaisFrm.valConfSecuCcc");'],[16,'','focaliza("segPaisFrm.numDiasFact");','focaliza("segPaisFrm.numDiasFact");','','focaliza("segPaisFrm.numDiasFact");','focaliza("segPaisFrm.numDiasFact");'],[17,'','focaliza("segPaisFrm.numLimiDifePago");','focaliza("segPaisFrm.numLimiDifePago");','','focaliza("segPaisFrm.numLimiDifePago");','focaliza("segPaisFrm.numLimiDifePago");'],[18,'','focaliza("segPaisFrm.indEmisVenc");','focaliza("segPaisFrm.indEmisVenc");','','focaliza("segPaisFrm.indEmisVenc");','focaliza("segPaisFrm.indEmisVenc");'],[19,'','focaliza("segPaisFrm.valMaxiDifeAnlsComb");','focaliza("segPaisFrm.valMaxiDifeAnlsComb");','','focaliza("segPaisFrm.valMaxiDifeAnlsComb");','focaliza("segPaisFrm.valMaxiDifeAnlsComb");'],[20,'','focaliza("segPaisFrm.numPosiNumeClie");','focaliza("segPaisFrm.numPosiNumeClie");','','focaliza("segPaisFrm.numPosiNumeClie");','focaliza("segPaisFrm.numPosiNumeClie");'],[21,'','focaliza("segPaisFrm.valFormFech");','focaliza("segPaisFrm.valFormFech");','','focaliza("segPaisFrm.valFormFech");','focaliza("segPaisFrm.valFormFech");'],[22,'','focaliza("segPaisFrm.valSepaMile");','focaliza("segPaisFrm.valSepaMile");','','focaliza("segPaisFrm.valSepaMile");','focaliza("segPaisFrm.valSepaMile");'],[23,'','focaliza("segPaisFrm.valSepaDeci");','focaliza("segPaisFrm.valSepaDeci");','','focaliza("segPaisFrm.valSepaDeci");','focaliza("segPaisFrm.valSepaDeci");'],[24,'','focaliza("segPaisFrm.numPeriEgre");','focaliza("segPaisFrm.numPeriEgre");','','focaliza("segPaisFrm.numPeriEgre");','focaliza("segPaisFrm.numPeriEgre");'],[25,'','focaliza("segPaisFrm.numPeriReti");','focaliza("segPaisFrm.numPeriReti");','','focaliza("segPaisFrm.numPeriReti");','focaliza("segPaisFrm.numPeriReti");'],[26,'','focalizaComboDependence("segPais","fopaOidFormPago", false);','focalizaComboDependence("segPais","fopaOidFormPago", false);','','focalizaComboDependence("segPais","fopaOidFormPago", true);','focalizaComboDependence("segPais","fopaOidFormPago", true);'],[27,'','focaliza("segPaisFrm.valCompTele");','focaliza("segPaisFrm.valCompTele");','','focaliza("segPaisFrm.valCompTele");','focaliza("segPaisFrm.valCompTele");'],[28,'','focaliza("segPaisFrm.indFletZonaUbig");','focaliza("segPaisFrm.indFletZonaUbig");','','focaliza("segPaisFrm.indFletZonaUbig");','focaliza("segPaisFrm.indFletZonaUbig");'],[29,'','focaliza("segPaisFrm.valIndiSecuMoni");','focaliza("segPaisFrm.valIndiSecuMoni");','','focaliza("segPaisFrm.valIndiSecuMoni");','focaliza("segPaisFrm.valIndiSecuMoni");'],[30,'','focaliza("segPaisFrm.indSecu");','focaliza("segPaisFrm.indSecu");','','focaliza("segPaisFrm.indSecu");','focaliza("segPaisFrm.indSecu");'],[31,'','focaliza("segPaisFrm.indBalaAreaCheq");','focaliza("segPaisFrm.indBalaAreaCheq");','','focaliza("segPaisFrm.indBalaAreaCheq");','focaliza("segPaisFrm.indBalaAreaCheq");'],[32,'','focaliza("segPaisFrm.valUrl");','focaliza("segPaisFrm.valUrl");','','focaliza("segPaisFrm.valUrl");','focaliza("segPaisFrm.valUrl");'],[33,'','focaliza("segPaisFrm.indImpuIncl");','focaliza("segPaisFrm.indImpuIncl");','','focaliza("segPaisFrm.indImpuIncl");','focaliza("segPaisFrm.indImpuIncl");']]);

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
segPaisLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var segPaisTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function segPaisInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('segPaisFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('segPaisFrm.accion')){
		case "query": segPaisQueryInitComponents(); break;
		case "view": segPaisViewInitComponents(); break;
		case "create": segPaisCreateInitComponents(); break;
		case "update": segPaisUpdateInitComponents(); break;
		case "remove": segPaisRemoveInitComponents(); break;
		case "lov": segPaisLovInitComponents(); break;
	}
	//alert('accion :' + get('segPaisFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('segPaisFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('segPais')) segPaisCmdRequery();
}

function segPaisQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	focusFirstField('segPaisFrm', true);	
}

function segPaisViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('segPaisFrm', 'Descripcion', 1);
	
		
	//Establecemos el valor de los radiobuttons
		set('segPaisFrm.indSaldUnic', get('segPaisFrm.indSaldUnicCheckValue'));
		set('segPaisFrm.indCompAuto', get('segPaisFrm.indCompAutoCheckValue'));
		set('segPaisFrm.indTratAcumDesc', get('segPaisFrm.indTratAcumDescCheckValue'));
		set('segPaisFrm.indEmisVenc', get('segPaisFrm.indEmisVencCheckValue'));
		set('segPaisFrm.valIndiSecuMoni', get('segPaisFrm.valIndiSecuMoniCheckValue'));
		set('segPaisFrm.indImpuIncl', get('segPaisFrm.indImpuInclCheckValue'));
		
	focusFirstField('segPaisFrm', true);
}

function segPaisCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('segPaisFrm.codPais','S', GestionarMensaje('SegPais.codPais.requiered.message'));
	
	setMV('segPaisFrm.moneOidMone','S', GestionarMensaje('SegPais.moneOidMone.requiered.message'));
	
	setMV('segPaisFrm.Descripcion','S', GestionarMensaje('SegPais.Descripcion.requiered.message'));
	
	setMV('segPaisFrm.indInteGis','S', GestionarMensaje('SegPais.indInteGis.requiered.message'));
	
	setMV('segPaisFrm.valIden','S', GestionarMensaje('SegPais.valIden.requiered.message'));
	
	setMV('segPaisFrm.indSaldUnic','S', GestionarMensaje('SegPais.indSaldUnic.requiered.message'));
	
	setMV('segPaisFrm.valProgEjec','S', GestionarMensaje('SegPais.valProgEjec.requiered.message'));
	
	setMV('segPaisFrm.valPorcAlar','S', GestionarMensaje('SegPais.valPorcAlar.requiered.message'));
	
	setMV('segPaisFrm.indCompAuto','S', GestionarMensaje('SegPais.indCompAuto.requiered.message'));
	
	setMV('segPaisFrm.numDiasMora','S', GestionarMensaje('SegPais.numDiasMora.requiered.message'));
	
	setMV('segPaisFrm.indTratAcumDesc','S', GestionarMensaje('SegPais.indTratAcumDesc.requiered.message'));
	
	setMV('segPaisFrm.valTiemRezo','S', GestionarMensaje('SegPais.valTiemRezo.requiered.message'));
	
	setMV('segPaisFrm.valConfSecuCcc','S', GestionarMensaje('SegPais.valConfSecuCcc.requiered.message'));
	
	setMV('segPaisFrm.numDiasFact','S', GestionarMensaje('SegPais.numDiasFact.requiered.message'));
	
	setMV('segPaisFrm.numLimiDifePago','S', GestionarMensaje('SegPais.numLimiDifePago.requiered.message'));
	
	setMV('segPaisFrm.indEmisVenc','S', GestionarMensaje('SegPais.indEmisVenc.requiered.message'));
	
	setMV('segPaisFrm.valMaxiDifeAnlsComb','S', GestionarMensaje('SegPais.valMaxiDifeAnlsComb.requiered.message'));
	
	setMV('segPaisFrm.numPosiNumeClie','S', GestionarMensaje('SegPais.numPosiNumeClie.requiered.message'));
	
	setMV('segPaisFrm.valFormFech','S', GestionarMensaje('SegPais.valFormFech.requiered.message'));
	
	setMV('segPaisFrm.valSepaMile','S', GestionarMensaje('SegPais.valSepaMile.requiered.message'));
	
	setMV('segPaisFrm.valSepaDeci','S', GestionarMensaje('SegPais.valSepaDeci.requiered.message'));
	
	setMV('segPaisFrm.numPeriEgre','S', GestionarMensaje('SegPais.numPeriEgre.requiered.message'));
	
	setMV('segPaisFrm.numPeriReti','S', GestionarMensaje('SegPais.numPeriReti.requiered.message'));
	
	setMV('segPaisFrm.indFletZonaUbig','S', GestionarMensaje('SegPais.indFletZonaUbig.requiered.message'));
	
	setMV('segPaisFrm.valIndiSecuMoni','S', GestionarMensaje('SegPais.valIndiSecuMoni.requiered.message'));
	
	setMV('segPaisFrm.valUrl','S', GestionarMensaje('SegPais.valUrl.requiered.message'));
	
	setMV('segPaisFrm.indImpuIncl','S', GestionarMensaje('SegPais.indImpuIncl.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('segPaisFrm', true);
}

function segPaisUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('segPaisFrm.origen') == "pagina"){
		loadLocalizationWidget('segPaisFrm', 'Descripcion', 1);
		

		//Establecemos el valor de los radiobuttons
			set('segPaisFrm.indSaldUnic', get('segPaisFrm.indSaldUnicCheckValue'));
			set('segPaisFrm.indCompAuto', get('segPaisFrm.indCompAutoCheckValue'));
			set('segPaisFrm.indTratAcumDesc', get('segPaisFrm.indTratAcumDescCheckValue'));
			set('segPaisFrm.indEmisVenc', get('segPaisFrm.indEmisVencCheckValue'));
			set('segPaisFrm.valIndiSecuMoni', get('segPaisFrm.valIndiSecuMoniCheckValue'));
			set('segPaisFrm.indImpuIncl', get('segPaisFrm.indImpuInclCheckValue'));
			

		//Registramos el valor del elemento que estamos modificando
		segPaisTmpUpdateValues = segPaisBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('segPaisFrm.codPais','S', GestionarMensaje('SegPais.codPais.requiered.message'));
		setMV('segPaisFrm.moneOidMone','S', GestionarMensaje('SegPais.moneOidMone.requiered.message'));
		setMV('segPaisFrm.Descripcion','S', GestionarMensaje('SegPais.Descripcion.requiered.message'));
		setMV('segPaisFrm.indInteGis','S', GestionarMensaje('SegPais.indInteGis.requiered.message'));
		setMV('segPaisFrm.valIden','S', GestionarMensaje('SegPais.valIden.requiered.message'));
		setMV('segPaisFrm.indSaldUnic','S', GestionarMensaje('SegPais.indSaldUnic.requiered.message'));
		setMV('segPaisFrm.valProgEjec','S', GestionarMensaje('SegPais.valProgEjec.requiered.message'));
		setMV('segPaisFrm.valPorcAlar','S', GestionarMensaje('SegPais.valPorcAlar.requiered.message'));
		setMV('segPaisFrm.indCompAuto','S', GestionarMensaje('SegPais.indCompAuto.requiered.message'));
		setMV('segPaisFrm.numDiasMora','S', GestionarMensaje('SegPais.numDiasMora.requiered.message'));
		setMV('segPaisFrm.indTratAcumDesc','S', GestionarMensaje('SegPais.indTratAcumDesc.requiered.message'));
		setMV('segPaisFrm.valTiemRezo','S', GestionarMensaje('SegPais.valTiemRezo.requiered.message'));
		setMV('segPaisFrm.valConfSecuCcc','S', GestionarMensaje('SegPais.valConfSecuCcc.requiered.message'));
		setMV('segPaisFrm.numDiasFact','S', GestionarMensaje('SegPais.numDiasFact.requiered.message'));
		setMV('segPaisFrm.numLimiDifePago','S', GestionarMensaje('SegPais.numLimiDifePago.requiered.message'));
		setMV('segPaisFrm.indEmisVenc','S', GestionarMensaje('SegPais.indEmisVenc.requiered.message'));
		setMV('segPaisFrm.valMaxiDifeAnlsComb','S', GestionarMensaje('SegPais.valMaxiDifeAnlsComb.requiered.message'));
		setMV('segPaisFrm.numPosiNumeClie','S', GestionarMensaje('SegPais.numPosiNumeClie.requiered.message'));
		setMV('segPaisFrm.valFormFech','S', GestionarMensaje('SegPais.valFormFech.requiered.message'));
		setMV('segPaisFrm.valSepaMile','S', GestionarMensaje('SegPais.valSepaMile.requiered.message'));
		setMV('segPaisFrm.valSepaDeci','S', GestionarMensaje('SegPais.valSepaDeci.requiered.message'));
		setMV('segPaisFrm.numPeriEgre','S', GestionarMensaje('SegPais.numPeriEgre.requiered.message'));
		setMV('segPaisFrm.numPeriReti','S', GestionarMensaje('SegPais.numPeriReti.requiered.message'));
		setMV('segPaisFrm.indFletZonaUbig','S', GestionarMensaje('SegPais.indFletZonaUbig.requiered.message'));
		setMV('segPaisFrm.valIndiSecuMoni','S', GestionarMensaje('SegPais.valIndiSecuMoni.requiered.message'));
		setMV('segPaisFrm.valUrl','S', GestionarMensaje('SegPais.valUrl.requiered.message'));
		setMV('segPaisFrm.indImpuIncl','S', GestionarMensaje('SegPais.indImpuIncl.requiered.message'));
		
			focusFirstFieldModify('segPaisFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		focusFirstField('segPaisFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('segPaisFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function segPaisRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	segPaisList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('segPaisFrm', true);
}

function segPaisLovInitComponents(){
	segPaisLovReturnParameters = window.dialogArguments;
	
	focusFirstField('segPaisFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad



































//Función que permite cargar los datos de un elemento de lov seleccionado
function segPaisSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('segPaisFrm.' + campo, id);
	set('segPaisFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function segPaisLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	segPaisLovReturnParameters.id = '';
	segPaisLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function segPaisLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(segPaisList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = segPaisList.codSeleccionados();
	var descripcion = segPaisList.extraeDato(
		segPaisList.codSeleccionados()[0], segPaisChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	segPaisLovReturnParameters.id = codigo;
	segPaisLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function segPaisCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('segPaisFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('segPaisFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "segPaisList", "SegPaisConectorTransactionQuery", 
		"result_ROWSET", parametros, "segPaisPostQueryActions(datos);"]], "", "");	
}

function segPaisCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('segPaisFrm.lastQueryToSession'));
	var i =0;
	set('segPaisFrm.codPais', paramsRequery.ij(i++));
	
	set('segPaisFrm.moneOidMone', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la página de busqueda como la actual
	segPaisPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	segPaisCmdQuery(segPaisPageCount);
}

function segPaisFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	segPaisPageCount = 1;
	segPaisCmdQuery(segPaisPageCount);
}

function segPaisPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != segPaisLastQuery){
		segPaisFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	segPaisPageCount--;
	segPaisCmdQuery(segPaisPageCount);
}

function segPaisNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != segPaisLastQuery){
		segPaisFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	segPaisPageCount++;
	segPaisCmdQuery(segPaisPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function segPaisPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('segPaisListLayer', 'O');
		visibilidad('segPaisListButtonsLayer', 'O');
		if(get('segPaisFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	segPaisLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:segPaisViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, segPaisChoiceColumn) + "</A>",
			i, segPaisChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	segPaisList.setDatos(datosTmp.filtrar([0,1,2],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	segPaisTimeStamps = datosTmp.filtrar([3],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		segPaisMorePagesFlag = true;
		segPaisList.eliminar(mmgPageSize, 1);
	}else{
		segPaisMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('segPaisFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('segPaisListLayer', 'V');
	visibilidad('segPaisListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('segPaisList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	segPaisList.display();
	
	//Actualizamos el estado de los botones 
	if(segPaisMorePagesFlag){
		set_estado_botonera('segPaisPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('segPaisPaginationButtonBar',
			3,"inactivo");
	}
	if(segPaisPageCount > 1){
		set_estado_botonera('segPaisPaginationButtonBar',
			2,"activo");
		set_estado_botonera('segPaisPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('segPaisPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('segPaisPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function segPaisUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(segPaisList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('segPaisFrm.idSelection', segPaisList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('segPaisFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = segPaisList.codSeleccionados()[0];
		parametros["previousAction"] = get('segPaisFrm.accion');
		parametros["accion"] = get('segPaisFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('SegPaisLPStartUp', get('segPaisFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) segPaisCmdRequery();
	}
}

function segPaisRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(segPaisList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = segPaisList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('segPaisFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(segPaisList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += segPaisTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('segPaisFrm.timestamp', timestamps);


	segPaisFrm.oculto='S';
	envia('segPaisFrm');
	segPaisFrm.oculto='N';
}

function segPaisViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(segPaisList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	segPaisViewDetail(segPaisList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function segPaisViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('segPaisFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('SegPaisLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	
	setDefaultLanguageValue('segPaisFrm', 
		'Descripcion', 1,
		get('segPaisFrm.Descripcion'));	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('segPaisFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	if(!hasDefaultLanguageValue('segPaisFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('SegPais.Descripcion.requiered.message'));
		focaliza('segPaisFrm.Descripcion');
		return;
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	if(validacion){
		segPaisFrm.oculto='S';
		envia('segPaisFrm');
		segPaisFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('segPaisFrm.moneOidMone').toString() == ''){
		set('segPaisFrm.moneOidMone', []);
		mmgResetCombosOnCascade('moneOidMone', 'moneOidMone', 'segPais');
		
	}
	if(get('segPaisFrm.moneOidMoneAlt').toString() == ''){
		set('segPaisFrm.moneOidMoneAlt', []);
		mmgResetCombosOnCascade('moneOidMoneAlt', 'moneOidMoneAlt', 'segPais');
		
	}
	if(get('segPaisFrm.fopaOidFormPago').toString() == ''){
		set('segPaisFrm.fopaOidFormPago', []);
		mmgResetCombosOnCascade('fopaOidFormPago', 'fopaOidFormPago', 'segPais');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	segPaisRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('segPaisFrm.accion');
	var origenTmp = get('segPaisFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(segPaisBuildUpdateRecordString() != segPaisTmpUpdateValues){
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
	document.all.segPaisListLayer.style.display='none';
	document.all.segPaisListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.segPaisListLayer.style.display='';
	document.all.segPaisListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsSegPaisCodPais = get('segPaisFrm.codPais').toString();
	jsSegPaisMoneOidMone = get('segPaisFrm.moneOidMone')[0];
	
	
	var parametros = "";
	parametros += jsSegPaisCodPais + "|";
	parametros += jsSegPaisMoneOidMone + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function segPaisBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsSegPaisCodPais + "|";
	parametros += jsSegPaisMoneOidMone + "|";
	parametros += jsSegPaisMoneOidMoneAlt + "|";
	parametros += jsSegPaisDescripcion + "|";
	parametros += jsSegPaisIndInteGis + "|";
	parametros += jsSegPaisValIden + "|";
	parametros += jsSegPaisIndSaldUnic + "|";
	parametros += jsSegPaisValProgEjec + "|";
	parametros += jsSegPaisValPorcAlar + "|";
	parametros += jsSegPaisIndCompAuto + "|";
	parametros += jsSegPaisNumDiasMora + "|";
	parametros += jsSegPaisIndTratAcumDesc + "|";
	parametros += jsSegPaisValTiemRezo + "|";
	parametros += jsSegPaisValConfSecuCcc + "|";
	parametros += jsSegPaisNumDiasFact + "|";
	parametros += jsSegPaisNumLimiDifePago + "|";
	parametros += jsSegPaisIndEmisVenc + "|";
	parametros += jsSegPaisValMaxiDifeAnlsComb + "|";
	parametros += jsSegPaisNumPosiNumeClie + "|";
	parametros += jsSegPaisValFormFech + "|";
	parametros += jsSegPaisValSepaMile + "|";
	parametros += jsSegPaisValSepaDeci + "|";
	parametros += jsSegPaisNumPeriEgre + "|";
	parametros += jsSegPaisNumPeriReti + "|";
	parametros += jsSegPaisFopaOidFormPago + "|";
	parametros += jsSegPaisValCompTele + "|";
	parametros += jsSegPaisIndFletZonaUbig + "|";
	parametros += jsSegPaisValIndiSecuMoni + "|";
	parametros += jsSegPaisIndSecu + "|";
	parametros += jsSegPaisIndBalaAreaCheq + "|";
	parametros += jsSegPaisValUrl + "|";
	parametros += jsSegPaisIndImpuIncl + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('segPaisFrm.accion'), 
		get('segPaisFrm.origen'));
	
	jsSegPaisId = get('segPaisFrm.id').toString();
	jsSegPaisCodPais = get('segPaisFrm.codPais').toString();
	jsSegPaisMoneOidMone = get('segPaisFrm.moneOidMone')[0];
	jsSegPaisMoneOidMoneAlt = get('segPaisFrm.moneOidMoneAlt')[0];
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsSegPaisDescripcion = buildLocalizedString('segPaisFrm', 1);
	}else{
		jsSegPaisDescripcion = get('segPaisFrm.Descripcion');
	}
	jsSegPaisIndInteGis = get('segPaisFrm.indInteGis')[0];
	jsSegPaisValIden = get('segPaisFrm.valIden')[0];
	jsSegPaisIndSaldUnic = get('segPaisFrm.indSaldUnic');
	jsSegPaisValProgEjec = get('segPaisFrm.valProgEjec').toString();
	jsSegPaisValPorcAlar = get('segPaisFrm.valPorcAlar').toString();
	jsSegPaisIndCompAuto = get('segPaisFrm.indCompAuto');
	jsSegPaisNumDiasMora = get('segPaisFrm.numDiasMora').toString();
	jsSegPaisIndTratAcumDesc = get('segPaisFrm.indTratAcumDesc');
	jsSegPaisValTiemRezo = get('segPaisFrm.valTiemRezo').toString();
	jsSegPaisValConfSecuCcc = get('segPaisFrm.valConfSecuCcc')[0];
	jsSegPaisNumDiasFact = get('segPaisFrm.numDiasFact').toString();
	jsSegPaisNumLimiDifePago = get('segPaisFrm.numLimiDifePago').toString();
	jsSegPaisIndEmisVenc = get('segPaisFrm.indEmisVenc');
	jsSegPaisValMaxiDifeAnlsComb = get('segPaisFrm.valMaxiDifeAnlsComb').toString();
	jsSegPaisNumPosiNumeClie = get('segPaisFrm.numPosiNumeClie').toString();
	jsSegPaisValFormFech = get('segPaisFrm.valFormFech')[0];
	jsSegPaisValSepaMile = get('segPaisFrm.valSepaMile')[0];
	jsSegPaisValSepaDeci = get('segPaisFrm.valSepaDeci')[0];
	jsSegPaisNumPeriEgre = get('segPaisFrm.numPeriEgre').toString();
	jsSegPaisNumPeriReti = get('segPaisFrm.numPeriReti').toString();
	jsSegPaisFopaOidFormPago = get('segPaisFrm.fopaOidFormPago')[0];
	jsSegPaisValCompTele = get('segPaisFrm.valCompTele').toString();
	jsSegPaisIndFletZonaUbig = get('segPaisFrm.indFletZonaUbig')[0];
	jsSegPaisValIndiSecuMoni = get('segPaisFrm.valIndiSecuMoni');
	jsSegPaisIndSecu = get('segPaisFrm.indSecu')[0];
	jsSegPaisIndBalaAreaCheq = get('segPaisFrm.indBalaAreaCheq')[0];
	jsSegPaisValUrl = get('segPaisFrm.valUrl').toString();
	jsSegPaisIndImpuIncl = get('segPaisFrm.indImpuIncl');
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('segPaisFrm.accion'), 
		get('segPaisFrm.origen'));


	set('segPaisFrm.id', jsSegPaisId);
	set('segPaisFrm.codPais', jsSegPaisCodPais);
	set('segPaisFrm.moneOidMone', [jsSegPaisMoneOidMone]);
	set('segPaisFrm.moneOidMoneAlt', [jsSegPaisMoneOidMoneAlt]);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('segPaisFrm', 1,  jsSegPaisDescripcion)
		loadLocalizationWidget('segPaisFrm', 'Descripcion', 1);
	}else{
		set('segPaisFrm.Descripcion', jsSegPaisDescripcion);		
	}
	set('segPaisFrm.indInteGis', [jsSegPaisIndInteGis]);
	set('segPaisFrm.valIden', [jsSegPaisValIden]);
	set('segPaisFrm.indSaldUnic', jsSegPaisIndSaldUnic);
	set('segPaisFrm.valProgEjec', jsSegPaisValProgEjec);
	set('segPaisFrm.valPorcAlar', jsSegPaisValPorcAlar);
	set('segPaisFrm.indCompAuto', jsSegPaisIndCompAuto);
	set('segPaisFrm.numDiasMora', jsSegPaisNumDiasMora);
	set('segPaisFrm.indTratAcumDesc', jsSegPaisIndTratAcumDesc);
	set('segPaisFrm.valTiemRezo', jsSegPaisValTiemRezo);
	set('segPaisFrm.valConfSecuCcc', [jsSegPaisValConfSecuCcc]);
	set('segPaisFrm.numDiasFact', jsSegPaisNumDiasFact);
	set('segPaisFrm.numLimiDifePago', jsSegPaisNumLimiDifePago);
	set('segPaisFrm.indEmisVenc', jsSegPaisIndEmisVenc);
	set('segPaisFrm.valMaxiDifeAnlsComb', jsSegPaisValMaxiDifeAnlsComb);
	set('segPaisFrm.numPosiNumeClie', jsSegPaisNumPosiNumeClie);
	set('segPaisFrm.valFormFech', [jsSegPaisValFormFech]);
	set('segPaisFrm.valSepaMile', [jsSegPaisValSepaMile]);
	set('segPaisFrm.valSepaDeci', [jsSegPaisValSepaDeci]);
	set('segPaisFrm.numPeriEgre', jsSegPaisNumPeriEgre);
	set('segPaisFrm.numPeriReti', jsSegPaisNumPeriReti);
	set('segPaisFrm.fopaOidFormPago', [jsSegPaisFopaOidFormPago]);
	set('segPaisFrm.valCompTele', jsSegPaisValCompTele);
	set('segPaisFrm.indFletZonaUbig', [jsSegPaisIndFletZonaUbig]);
	set('segPaisFrm.valIndiSecuMoni', jsSegPaisValIndiSecuMoni);
	set('segPaisFrm.indSecu', [jsSegPaisIndSecu]);
	set('segPaisFrm.indBalaAreaCheq', [jsSegPaisIndBalaAreaCheq]);
	set('segPaisFrm.valUrl', jsSegPaisValUrl);
	set('segPaisFrm.indImpuIncl', jsSegPaisIndImpuIncl);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsSegPaisCodPais = '';
	jsSegPaisMoneOidMone = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('segPaisFrm.errCodigo', errorCode);
	set('segPaisFrm.errDescripcion', description);
	set('segPaisFrm.errSeverity', severity);
	fMostrarMensajeError();
}
