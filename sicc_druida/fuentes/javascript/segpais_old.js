

/*
    INDRA/CAR/mmg
    $Id: segpais_old.js,v 1.1 2009/12/03 19:02:07 pecbazalar Exp $
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
var jsSegPaisValLimiDifeDePago = "";
var jsSegPaisIndEmisVenc = "";
var jsSegPaisValMaxiDifeAnlsComb = "";
var jsSegPaisNumDiasCaduRese = "";
var jsSegPaisValMoviReseCallCent = "";
var jsSegPaisNumPosiNumeClie = "";
var jsSegPaisValFormFech = "";
var jsSegPaisNumDeci = "";
var jsSegPaisValSepaMile = "";
var jsSegPaisValSepaDeci = "";
var jsSegPaisNumPeriEgre = "";
var jsSegPaisNumPeriReti = "";
var jsSegPaisFopaOidFormPago = "";
var jsSegPaisValCompTele = "";
var jsSegPaisValUrl = "";

//Variables de paginacion, 
var segPaisPageCount = 1;

//Varible de columna que representa el campo de choice
var segPaisChoiceColumn = 2;

//Flag de siguiente pagina;
var segPaisMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var segPaisTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 185;
var sizeFormView = 1305;
var sizeFormUpdate = 1200;

//Ultima busqueda realizada
var segPaisLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("segPaisFrm.codPais");','focaliza("segPaisFrm.codPais");','','focaliza("segPaisFrm.codPais");','focaliza("segPaisFrm.codPais");',''],[3,'focalizaComboDependence("segPais","moneOidMone", false);','focalizaComboDependence("segPais","moneOidMone", false);','','focalizaComboDependence("segPais","moneOidMone", true);','focalizaComboDependence("segPais","moneOidMone", true);',''],[4,'','focalizaComboDependence("segPais","moneOidMoneAlt", false);','focalizaComboDependence("segPais","moneOidMoneAlt", false);','','focalizaComboDependence("segPais","moneOidMoneAlt", true);','focalizaComboDependence("segPais","moneOidMoneAlt", true);'],[5,'','focaliza("segPaisFrm.Descripcion");','focaliza("segPaisFrm.Descripcion");','','focaliza("segPaisFrm.Descripcion");','focaliza("segPaisFrm.Descripcion");'],[6,'','focaliza("segPaisFrm.indInteGis");','focaliza("segPaisFrm.indInteGis");','','focaliza("segPaisFrm.indInteGis");','focaliza("segPaisFrm.indInteGis");'],[7,'','focaliza("segPaisFrm.valIden");','focaliza("segPaisFrm.valIden");','','focaliza("segPaisFrm.valIden");','focaliza("segPaisFrm.valIden");'],[8,'','focaliza("segPaisFrm.indSaldUnic");','focaliza("segPaisFrm.indSaldUnic");','','focaliza("segPaisFrm.indSaldUnic");','focaliza("segPaisFrm.indSaldUnic");'],[9,'','focaliza("segPaisFrm.valProgEjec");','focaliza("segPaisFrm.valProgEjec");','','focaliza("segPaisFrm.valProgEjec");','focaliza("segPaisFrm.valProgEjec");'],[10,'','focaliza("segPaisFrm.valPorcAlar");','focaliza("segPaisFrm.valPorcAlar");','','focaliza("segPaisFrm.valPorcAlar");','focaliza("segPaisFrm.valPorcAlar");'],[11,'','focaliza("segPaisFrm.indCompAuto");','focaliza("segPaisFrm.indCompAuto");','','focaliza("segPaisFrm.indCompAuto");','focaliza("segPaisFrm.indCompAuto");'],[12,'','focaliza("segPaisFrm.numDiasMora");','focaliza("segPaisFrm.numDiasMora");','','focaliza("segPaisFrm.numDiasMora");','focaliza("segPaisFrm.numDiasMora");'],[13,'','focaliza("segPaisFrm.indTratAcumDesc");','focaliza("segPaisFrm.indTratAcumDesc");','','focaliza("segPaisFrm.indTratAcumDesc");','focaliza("segPaisFrm.indTratAcumDesc");'],[14,'','focaliza("segPaisFrm.valTiemRezo");','focaliza("segPaisFrm.valTiemRezo");','','focaliza("segPaisFrm.valTiemRezo");','focaliza("segPaisFrm.valTiemRezo");'],[15,'','focaliza("segPaisFrm.valConfSecuCcc");','focaliza("segPaisFrm.valConfSecuCcc");','','focaliza("segPaisFrm.valConfSecuCcc");','focaliza("segPaisFrm.valConfSecuCcc");'],[16,'','focaliza("segPaisFrm.numDiasFact");','focaliza("segPaisFrm.numDiasFact");','','focaliza("segPaisFrm.numDiasFact");','focaliza("segPaisFrm.numDiasFact");'],[17,'','focaliza("segPaisFrm.valLimiDifeDePago");','focaliza("segPaisFrm.valLimiDifeDePago");','','focaliza("segPaisFrm.valLimiDifeDePago");','focaliza("segPaisFrm.valLimiDifeDePago");'],[18,'','focaliza("segPaisFrm.indEmisVenc");','focaliza("segPaisFrm.indEmisVenc");','','focaliza("segPaisFrm.indEmisVenc");','focaliza("segPaisFrm.indEmisVenc");'],[19,'','focaliza("segPaisFrm.valMaxiDifeAnlsComb");','focaliza("segPaisFrm.valMaxiDifeAnlsComb");','','focaliza("segPaisFrm.valMaxiDifeAnlsComb");','focaliza("segPaisFrm.valMaxiDifeAnlsComb");'],[20,'','focaliza("segPaisFrm.numDiasCaduRese");','focaliza("segPaisFrm.numDiasCaduRese");','','focaliza("segPaisFrm.numDiasCaduRese");','focaliza("segPaisFrm.numDiasCaduRese");'],[21,'','focaliza("segPaisFrm.valMoviReseCallCent");','focaliza("segPaisFrm.valMoviReseCallCent");','','focaliza("segPaisFrm.valMoviReseCallCent");','focaliza("segPaisFrm.valMoviReseCallCent");'],[22,'','focaliza("segPaisFrm.numPosiNumeClie");','focaliza("segPaisFrm.numPosiNumeClie");','','focaliza("segPaisFrm.numPosiNumeClie");','focaliza("segPaisFrm.numPosiNumeClie");'],[23,'','focaliza("segPaisFrm.valFormFech");','focaliza("segPaisFrm.valFormFech");','','focaliza("segPaisFrm.valFormFech");','focaliza("segPaisFrm.valFormFech");'],[24,'','focaliza("segPaisFrm.numDeci");','focaliza("segPaisFrm.numDeci");','','focaliza("segPaisFrm.numDeci");','focaliza("segPaisFrm.numDeci");'],[25,'','focaliza("segPaisFrm.valSepaMile");','focaliza("segPaisFrm.valSepaMile");','','focaliza("segPaisFrm.valSepaMile");','focaliza("segPaisFrm.valSepaMile");'],[26,'','focaliza("segPaisFrm.valSepaDeci");','focaliza("segPaisFrm.valSepaDeci");','','focaliza("segPaisFrm.valSepaDeci");','focaliza("segPaisFrm.valSepaDeci");'],[27,'','focaliza("segPaisFrm.numPeriEgre");','focaliza("segPaisFrm.numPeriEgre");','','focaliza("segPaisFrm.numPeriEgre");','focaliza("segPaisFrm.numPeriEgre");'],[28,'','focaliza("segPaisFrm.numPeriReti");','focaliza("segPaisFrm.numPeriReti");','','focaliza("segPaisFrm.numPeriReti");','focaliza("segPaisFrm.numPeriReti");'],[29,'','focalizaComboDependence("segPais","fopaOidFormPago", false);','focalizaComboDependence("segPais","fopaOidFormPago", false);','','focalizaComboDependence("segPais","fopaOidFormPago", true);','focalizaComboDependence("segPais","fopaOidFormPago", true);'],[30,'','focaliza("segPaisFrm.valCompTele");','focaliza("segPaisFrm.valCompTele");','','focaliza("segPaisFrm.valCompTele");','focaliza("segPaisFrm.valCompTele");'],[31,'','focaliza("segPaisFrm.valUrl");','focaliza("segPaisFrm.valUrl");','','focaliza("segPaisFrm.valUrl");','focaliza("segPaisFrm.valUrl");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquí consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nomrbe de la entidad 
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
	
	//Ponemos el foco en el primer campo
	focusFirstField('segPaisFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('segPais')) segPaisCmdRequery();
}

function segPaisQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
}

function segPaisViewInitComponents(){
	//En principiono se hace nada
}

function segPaisCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('segPaisFrm.codPais','S', GestionarMensaje('SegPais.codPais.requiered.message'));
	
	setMV('segPaisFrm.moneOidMone','S', GestionarMensaje('SegPais.moneOidMone.requiered.message'));
	
	setMV('segPaisFrm.moneOidMoneAlt','S', GestionarMensaje('SegPais.moneOidMoneAlt.requiered.message'));
	
	setMV('segPaisFrm.Descripcion','S', GestionarMensaje('SegPais.Descripcion.requiered.message'));
	
	setMV('segPaisFrm.indInteGis','S', GestionarMensaje('SegPais.indInteGis.requiered.message'));
	
	setMV('segPaisFrm.valIden','S', GestionarMensaje('SegPais.valIden.requiered.message'));
	
	setMV('segPaisFrm.valProgEjec','S', GestionarMensaje('SegPais.valProgEjec.requiered.message'));
	
	setMV('segPaisFrm.valPorcAlar','S', GestionarMensaje('SegPais.valPorcAlar.requiered.message'));
	
	setMV('segPaisFrm.numDiasMora','S', GestionarMensaje('SegPais.numDiasMora.requiered.message'));
	
	setMV('segPaisFrm.valTiemRezo','S', GestionarMensaje('SegPais.valTiemRezo.requiered.message'));
	
	setMV('segPaisFrm.numDiasFact','S', GestionarMensaje('SegPais.numDiasFact.requiered.message'));
	
	setMV('segPaisFrm.valLimiDifeDePago','S', GestionarMensaje('SegPais.valLimiDifeDePago.requiered.message'));
	
	setMV('segPaisFrm.valMaxiDifeAnlsComb','S', GestionarMensaje('SegPais.valMaxiDifeAnlsComb.requiered.message'));
	
	setMV('segPaisFrm.numDiasCaduRese','S', GestionarMensaje('SegPais.numDiasCaduRese.requiered.message'));
	
	setMV('segPaisFrm.numPosiNumeClie','S', GestionarMensaje('SegPais.numPosiNumeClie.requiered.message'));
	
	setMV('segPaisFrm.valFormFech','S', GestionarMensaje('SegPais.valFormFech.requiered.message'));
	
	setMV('segPaisFrm.numDeci','S', GestionarMensaje('SegPais.numDeci.requiered.message'));
	
	setMV('segPaisFrm.valSepaMile','S', GestionarMensaje('SegPais.valSepaMile.requiered.message'));
	
	setMV('segPaisFrm.valSepaDeci','S', GestionarMensaje('SegPais.valSepaDeci.requiered.message'));
	
	setMV('segPaisFrm.numPeriEgre','S', GestionarMensaje('SegPais.numPeriEgre.requiered.message'));
	
	setMV('segPaisFrm.numPeriReti','S', GestionarMensaje('SegPais.numPeriReti.requiered.message'));
	
	setMV('segPaisFrm.valUrl','S', GestionarMensaje('SegPais.valUrl.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
}

function segPaisUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('segPaisFrm.origen') == "pagina"){
		loadLocalizationWidget('segPaisFrm', 'Descripcion', 1);
		

		//Registramos el valor del elemento que estamos modificando
		segPaisTmpUpdateValues = segPaisBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('segPaisFrm.moneOidMoneAlt','S', GestionarMensaje('SegPais.moneOidMoneAlt.requiered.message'));
		
		setMV('segPaisFrm.Descripcion','S', GestionarMensaje('SegPais.Descripcion.requiered.message'));
		
		setMV('segPaisFrm.indInteGis','S', GestionarMensaje('SegPais.indInteGis.requiered.message'));
		
		setMV('segPaisFrm.valIden','S', GestionarMensaje('SegPais.valIden.requiered.message'));
		
		setMV('segPaisFrm.valProgEjec','S', GestionarMensaje('SegPais.valProgEjec.requiered.message'));
		
		setMV('segPaisFrm.valPorcAlar','S', GestionarMensaje('SegPais.valPorcAlar.requiered.message'));
		
		setMV('segPaisFrm.numDiasMora','S', GestionarMensaje('SegPais.numDiasMora.requiered.message'));
		
		setMV('segPaisFrm.valTiemRezo','S', GestionarMensaje('SegPais.valTiemRezo.requiered.message'));
		
		setMV('segPaisFrm.numDiasFact','S', GestionarMensaje('SegPais.numDiasFact.requiered.message'));
		
		setMV('segPaisFrm.valLimiDifeDePago','S', GestionarMensaje('SegPais.valLimiDifeDePago.requiered.message'));
		
		setMV('segPaisFrm.valMaxiDifeAnlsComb','S', GestionarMensaje('SegPais.valMaxiDifeAnlsComb.requiered.message'));
		
		setMV('segPaisFrm.numDiasCaduRese','S', GestionarMensaje('SegPais.numDiasCaduRese.requiered.message'));
		
		setMV('segPaisFrm.numPosiNumeClie','S', GestionarMensaje('SegPais.numPosiNumeClie.requiered.message'));
		
		setMV('segPaisFrm.valFormFech','S', GestionarMensaje('SegPais.valFormFech.requiered.message'));
		
		setMV('segPaisFrm.numDeci','S', GestionarMensaje('SegPais.numDeci.requiered.message'));
		
		setMV('segPaisFrm.valSepaMile','S', GestionarMensaje('SegPais.valSepaMile.requiered.message'));
		
		setMV('segPaisFrm.valSepaDeci','S', GestionarMensaje('SegPais.valSepaDeci.requiered.message'));
		
		setMV('segPaisFrm.numPeriEgre','S', GestionarMensaje('SegPais.numPeriEgre.requiered.message'));
		
		setMV('segPaisFrm.numPeriReti','S', GestionarMensaje('SegPais.numPeriReti.requiered.message'));
		
		setMV('segPaisFrm.valUrl','S', GestionarMensaje('SegPais.valUrl.requiered.message'));
		
		
	
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('segPaisFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function segPaisRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	segPaisList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');			
}

function segPaisLovInitComponents(){
	segPaisLovReturnParameters = window.dialogArguments;
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
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	segPaisLastQuery = parametros;

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
	
	
	
	//No se nos actualizar los parmámetros de la paginación
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
		visibilidad('segPaisPreListLayer', 'O');
		if(get('segPaisFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	for(var i=0; i < datosTmp.longitud; i++){
		if(datosTmp.ij(i, 3) == "true"){
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.yes.message'), i, 3);
		}else{
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.no.message'), i, 3);
		}
	}
	for(var i=0; i < datosTmp.longitud; i++){
		if(datosTmp.ij(i, 3) == "true"){
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.yes.message'), i, 3);
		}else{
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.no.message'), i, 3);
		}
	}
	for(var i=0; i < datosTmp.longitud; i++){
		if(datosTmp.ij(i, 3) == "true"){
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.yes.message'), i, 3);
		}else{
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.no.message'), i, 3);
		}
	}
	for(var i=0; i < datosTmp.longitud; i++){
		if(datosTmp.ij(i, 3) == "true"){
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.yes.message'), i, 3);
		}else{
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.no.message'), i, 3);
		}
	}
	
	
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
	visibilidad('segPaisPreListLayer', 'V');

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
		/*set('segPaisFrm.previousAction', 'update');
		set('segPaisFrm.ON', 'SegPaisLPStartUp');
		set('segPaisFrm.conectorAction', 'SegPaisLPStartUp');
		set('segPaisFrm.origen', 'pagina');
		envia('segPaisFrm');*/

		var parametros = new Array();
		parametros["idSelection"] = segPaisList.codSeleccionados()[0];
		parametros["previousAction"] = get('segPaisFrm.accion');
		parametros["accion"] = get('segPaisFrm.accion');
		parametros["origen"] = 'pagina';
		var result = mostrarModalSICC('SegPaisLPStartUp', get('segPaisFrm.accion'), parametros, null, sizeFormView + 30);
		if(result == MMG_RC_OK) segPaisCmdRequery();
	}
}

function segPaisRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(segPaisList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

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
	envia('segPaisFrm');
}

function segPaisViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(segPaisList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Actualizamos la accion a view, el origen a pagina, el action a la LP de StartUp y el modo desde el cual hemos
	//ido al view
	set('segPaisFrm.previousAction', get('segPaisFrm.accion'));
	set('segPaisFrm.accion', 'view');
	set('segPaisFrm.origen', 'pagina');
	set('segPaisFrm.ON', 'SegPaisLPStartUp');
	
	//Establcemos el id del elemento seleccionado
	set('segPaisFrm.idSelection', segPaisList.codSeleccionados()[0]);
	
	//Enviamos el formualrio
	//envia('segPaisFrm');
	segPaisViewDetail(segPaisList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function segPaisViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('segPaisFrm.accion');
	parametros["accion"] = get('segPaisFrm.accion');
	parametros["origen"] = 'pagina';
	mostrarModalSICC('SegPaisLPStartUp', get('segPaisFrm.accion'), parametros, null, sizeFormView + 30);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar on dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	if(validacion)envia('segPaisFrm');
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
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
	
		set('segPaisFrm.performRequery', 'true');
		set('segPaisFrm.accion', 
			get('segPaisFrm.previousAction'));
		set('segPaisFrm.origen', 'menu');
		set('segPaisFrm.ON', 'SegPaisLPStartUp');
		set('segPaisFrm.conectorAction', 'SegPaisLPStartUp');
		segPaisFrm.oculto='N';
		envia('segPaisFrm');
	}else if(accionTmp == 'view'){
		window.close();
	}else Volver();
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
	parametros += jsSegPaisValLimiDifeDePago + "|";
	parametros += jsSegPaisIndEmisVenc + "|";
	parametros += jsSegPaisValMaxiDifeAnlsComb + "|";
	parametros += jsSegPaisNumDiasCaduRese + "|";
	parametros += jsSegPaisValMoviReseCallCent + "|";
	parametros += jsSegPaisNumPosiNumeClie + "|";
	parametros += jsSegPaisValFormFech + "|";
	parametros += jsSegPaisNumDeci + "|";
	parametros += jsSegPaisValSepaMile + "|";
	parametros += jsSegPaisValSepaDeci + "|";
	parametros += jsSegPaisNumPeriEgre + "|";
	parametros += jsSegPaisNumPeriReti + "|";
	parametros += jsSegPaisFopaOidFormPago + "|";
	parametros += jsSegPaisValCompTele + "|";
	parametros += jsSegPaisValUrl + "|";

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
	if(get('segPaisFrm.indSaldUnic').toString() == 'S') jsSegPaisIndSaldUnic = "true";
	else jsSegPaisIndSaldUnic = "false";
	jsSegPaisValProgEjec = get('segPaisFrm.valProgEjec').toString();
	jsSegPaisValPorcAlar = get('segPaisFrm.valPorcAlar').toString();
	if(get('segPaisFrm.indCompAuto').toString() == 'S') jsSegPaisIndCompAuto = "true";
	else jsSegPaisIndCompAuto = "false";
	jsSegPaisNumDiasMora = get('segPaisFrm.numDiasMora').toString();
	if(get('segPaisFrm.indTratAcumDesc').toString() == 'S') jsSegPaisIndTratAcumDesc = "true";
	else jsSegPaisIndTratAcumDesc = "false";
	jsSegPaisValTiemRezo = get('segPaisFrm.valTiemRezo').toString();
	jsSegPaisValConfSecuCcc = get('segPaisFrm.valConfSecuCcc')[0];
	jsSegPaisNumDiasFact = get('segPaisFrm.numDiasFact').toString();
	jsSegPaisValLimiDifeDePago = get('segPaisFrm.valLimiDifeDePago').toString();
	if(get('segPaisFrm.indEmisVenc').toString() == 'S') jsSegPaisIndEmisVenc = "true";
	else jsSegPaisIndEmisVenc = "false";
	jsSegPaisValMaxiDifeAnlsComb = get('segPaisFrm.valMaxiDifeAnlsComb').toString();
	jsSegPaisNumDiasCaduRese = get('segPaisFrm.numDiasCaduRese').toString();
	jsSegPaisValMoviReseCallCent = get('segPaisFrm.valMoviReseCallCent').toString();
	jsSegPaisNumPosiNumeClie = get('segPaisFrm.numPosiNumeClie').toString();
	jsSegPaisValFormFech = get('segPaisFrm.valFormFech')[0];
	jsSegPaisNumDeci = get('segPaisFrm.numDeci').toString();
	jsSegPaisValSepaMile = get('segPaisFrm.valSepaMile')[0];
	jsSegPaisValSepaDeci = get('segPaisFrm.valSepaDeci')[0];
	jsSegPaisNumPeriEgre = get('segPaisFrm.numPeriEgre').toString();
	jsSegPaisNumPeriReti = get('segPaisFrm.numPeriReti').toString();
	jsSegPaisFopaOidFormPago = get('segPaisFrm.fopaOidFormPago')[0];
	jsSegPaisValCompTele = get('segPaisFrm.valCompTele').toString();
	jsSegPaisValUrl = get('segPaisFrm.valUrl').toString();

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

		
		if(jsSegPaisIndSaldUnic == "true") set('segPaisFrm.indSaldUnic', 'S');
		else set('segPaisFrm.indSaldUnic', 'N');
	set('segPaisFrm.valProgEjec', jsSegPaisValProgEjec);
	set('segPaisFrm.valPorcAlar', jsSegPaisValPorcAlar);

		
		if(jsSegPaisIndCompAuto == "true") set('segPaisFrm.indCompAuto', 'S');
		else set('segPaisFrm.indCompAuto', 'N');
	set('segPaisFrm.numDiasMora', jsSegPaisNumDiasMora);

		
		if(jsSegPaisIndTratAcumDesc == "true") set('segPaisFrm.indTratAcumDesc', 'S');
		else set('segPaisFrm.indTratAcumDesc', 'N');
	set('segPaisFrm.valTiemRezo', jsSegPaisValTiemRezo);
	set('segPaisFrm.valConfSecuCcc', [jsSegPaisValConfSecuCcc]);
	set('segPaisFrm.numDiasFact', jsSegPaisNumDiasFact);
	set('segPaisFrm.valLimiDifeDePago', jsSegPaisValLimiDifeDePago);

		
		if(jsSegPaisIndEmisVenc == "true") set('segPaisFrm.indEmisVenc', 'S');
		else set('segPaisFrm.indEmisVenc', 'N');
	set('segPaisFrm.valMaxiDifeAnlsComb', jsSegPaisValMaxiDifeAnlsComb);
	set('segPaisFrm.numDiasCaduRese', jsSegPaisNumDiasCaduRese);
	set('segPaisFrm.valMoviReseCallCent', jsSegPaisValMoviReseCallCent);
	set('segPaisFrm.numPosiNumeClie', jsSegPaisNumPosiNumeClie);
	set('segPaisFrm.valFormFech', [jsSegPaisValFormFech]);
	set('segPaisFrm.numDeci', jsSegPaisNumDeci);
	set('segPaisFrm.valSepaMile', [jsSegPaisValSepaMile]);
	set('segPaisFrm.valSepaDeci', [jsSegPaisValSepaDeci]);
	set('segPaisFrm.numPeriEgre', jsSegPaisNumPeriEgre);
	set('segPaisFrm.numPeriReti', jsSegPaisNumPeriReti);
	set('segPaisFrm.fopaOidFormPago', [jsSegPaisFopaOidFormPago]);
	set('segPaisFrm.valCompTele', jsSegPaisValCompTele);
	set('segPaisFrm.valUrl', jsSegPaisValUrl);

}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('segPaisFrm.errCodigo', errorCode);
	set('segPaisFrm.errDescripcion', description);
	set('segPaisFrm.errSeverity', severity);
	fMostrarMensajeError();
}





	
