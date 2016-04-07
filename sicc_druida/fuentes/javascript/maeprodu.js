

/*
    INDRA/CAR/mmg
    $Id: maeprodu.js,v 1.1 2009/12/03 19:01:42 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsMaeProduId = "";
var jsMaeProduPaisOidPais = "";
var jsMaeProduCodSap = "";
var jsMaeProduCodiAnti = "";
var jsMaeProduDesCort = "";
var jsMaeProduValJera1 = "";
var jsMaeProduValJera2 = "";
var jsMaeProduValJera3 = "";
var jsMaeProduValAtri1 = "";
var jsMaeProduValAtri2 = "";
var jsMaeProduValAtri3 = "";
var jsMaeProduValDimeAlto = "";
var jsMaeProduValDimeLarg = "";
var jsMaeProduValDimeAnch = "";
var jsMaeProduValPeso = "";
var jsMaeProduValVolu = "";
var jsMaeProduValCostEstd = "";
var jsMaeProduValPrecPosi = "";
var jsMaeProduValPrecCata = "";
var jsMaeProduValPrecCont = "";
var jsMaeProduNumUnidDentPedi = "";
var jsMaeProduNumUnidCaja = "";
var jsMaeProduCodImpu = "";
var jsMaeProduPctUnid = "";
var jsMaeProduGeneOidGene = "";
var jsMaeProduSgenOidSupeGene = "";
var jsMaeProduUnmdOidUnidMedi = "";
var jsMaeProduUnmdOidUnidMediPeso = "";
var jsMaeProduUnmdOidUnidMediDime = "";
var jsMaeProduNegoOidNego = "";
var jsMaeProduMeudOidEstaProd = "";
var jsMaeProduLiprOidLineProd = "";
var jsMaeProduUnegOidUnidNego = "";
var jsMaeProduPerdOidPeriInic = "";
var jsMaeProduPerdOidPeriFin = "";
var jsMaeProduIndLote = "";
var jsMaeProduIndProdServ = "";
var jsMaeProduCodIndSitu = "";
var jsMaeProduCodIndDentCaja = "";
var jsMaeProduIndKit = "";
var jsMaeProduFopaOidFormPago = "";
var jsMaeProduMaprOidMarcProd = "";
var jsMaeProduValGrupArti = "";
var jsMaeProduCodUnicVent = "";
var jsMaeProduPrfiOidProgFide = "";

//Variables de paginacion, 
var maeProduPageCount = 1;

//Varible de columna que representa el campo de choice
var maeProduChoiceColumn = 44;

//Flag de siguiente pagina;
var maeProduMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var maeProduTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 1911;
var sizeFormView = 1893;
var sizeFormUpdate = 1893;

//Ultima busqueda realizada
var maeProduLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[0,'focalizaComboDependence("maeProdu","prfiOidProgFide", false);','focalizaComboDependence("maeProdu","prfiOidProgFide", false);','focalizaComboDependence("maeProdu","prfiOidProgFide", false);','focalizaComboDependence("maeProdu","prfiOidProgFide", true);','focalizaComboDependence("maeProdu","prfiOidProgFide", true);','focalizaComboDependence("maeProdu","prfiOidProgFide", true);']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[0,'focalizaComboDependence("maeProdu","prfiOidProgFide", false);','focalizaComboDependence("maeProdu","prfiOidProgFide", false);','focalizaComboDependence("maeProdu","prfiOidProgFide", false);','focalizaComboDependence("maeProdu","prfiOidProgFide", true);','focalizaComboDependence("maeProdu","prfiOidProgFide", true);','focalizaComboDependence("maeProdu","prfiOidProgFide", true);']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var paisOidPaisDependeceMap = new Vector();
paisOidPaisDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais', padresTmp, '', 'SegPaisView']);
var geneOidGeneDependeceMap = new Vector();
geneOidGeneDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
geneOidGeneDependeceMap.agregar(['geneOidGene', padresTmp, '', 'MaeGener']);
var sgenOidSupeGeneDependeceMap = new Vector();
sgenOidSupeGeneDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
sgenOidSupeGeneDependeceMap.agregar(['sgenOidSupeGene', padresTmp, '', 'MaeSuperGener']);
var unmdOidUnidMediDependeceMap = new Vector();
unmdOidUnidMediDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
unmdOidUnidMediDependeceMap.agregar(['unmdOidUnidMedi_magnOidMagn', padresTmp, 'unmdOidUnidMedi', 'MaeMagni']);
padresTmp =  new Vector();
padresTmp.cargar(['unmdOidUnidMedi_magnOidMagn'])
unmdOidUnidMediDependeceMap.agregar(['unmdOidUnidMedi', padresTmp, '', 'MaeUnidaMedid']);
var unmdOidUnidMediPesoDependeceMap = new Vector();
unmdOidUnidMediPesoDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
unmdOidUnidMediPesoDependeceMap.agregar(['unmdOidUnidMediPeso_magnOidMagn', padresTmp, 'unmdOidUnidMediPeso', 'MaeMagni']);
padresTmp =  new Vector();
padresTmp.cargar(['unmdOidUnidMediPeso_magnOidMagn'])
unmdOidUnidMediPesoDependeceMap.agregar(['unmdOidUnidMediPeso', padresTmp, '', 'MaeUnidaMedid']);
var unmdOidUnidMediDimeDependeceMap = new Vector();
unmdOidUnidMediDimeDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
unmdOidUnidMediDimeDependeceMap.agregar(['unmdOidUnidMediDime_magnOidMagn', padresTmp, 'unmdOidUnidMediDime', 'MaeMagni']);
padresTmp =  new Vector();
padresTmp.cargar(['unmdOidUnidMediDime_magnOidMagn'])
unmdOidUnidMediDimeDependeceMap.agregar(['unmdOidUnidMediDime', padresTmp, '', 'MaeUnidaMedid']);
var negoOidNegoDependeceMap = new Vector();
negoOidNegoDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
negoOidNegoDependeceMap.agregar(['negoOidNego', padresTmp, '', 'MaeNegoc']);
var meudOidEstaProdDependeceMap = new Vector();
meudOidEstaProdDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
meudOidEstaProdDependeceMap.agregar(['meudOidEstaProd', padresTmp, '', 'MaeEstatProdu']);
var liprOidLineProdDependeceMap = new Vector();
liprOidLineProdDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
liprOidLineProdDependeceMap.agregar(['liprOidLineProd', padresTmp, '', 'MaeLineaProdu']);
var unegOidUnidNegoDependeceMap = new Vector();
unegOidUnidNegoDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
unegOidUnidNegoDependeceMap.agregar(['unegOidUnidNego', padresTmp, '', 'MaeUnidaNegoc']);
var perdOidPeriInicDependeceMap = new Vector();
perdOidPeriInicDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
perdOidPeriInicDependeceMap.agregar(['perdOidPeriInic', padresTmp, '', 'CraPerio']);
var perdOidPeriFinDependeceMap = new Vector();
perdOidPeriFinDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
perdOidPeriFinDependeceMap.agregar(['perdOidPeriFin', padresTmp, '', 'CraPerio']);
var fopaOidFormPagoDependeceMap = new Vector();
fopaOidFormPagoDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
fopaOidFormPagoDependeceMap.agregar(['fopaOidFormPago', padresTmp, '', 'BelFormaPago']);
var maprOidMarcProdDependeceMap = new Vector();
maprOidMarcProdDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
maprOidMarcProdDependeceMap.agregar(['maprOidMarcProd', padresTmp, '', 'SegMarcaProdu']);
var prfiOidProgFideDependeceMap = new Vector();
prfiOidProgFideDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
prfiOidProgFideDependeceMap.agregar(['prfiOidProgFide', padresTmp, '', 'MaeProgrFidel']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
maeProduLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var maeProduTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function maeProduInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('maeProduFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('maeProduFrm.accion')){
		case "query": maeProduQueryInitComponents(); break;
		case "view": maeProduViewInitComponents(); break;
		case "create": maeProduCreateInitComponents(); break;
		case "update": maeProduUpdateInitComponents(); break;
		case "remove": maeProduRemoveInitComponents(); break;
		case "lov": maeProduLovInitComponents(); break;
	}
	//alert('accion :' + get('maeProduFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('maeProduFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('maeProdu')) maeProduCmdRequery();
}

function maeProduQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	focusFirstField('maeProduFrm', true);	
}

function maeProduViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('maeProduFrm', true);
}

function maeProduCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('maeProduFrm.paisOidPais','S', GestionarMensaje('MaeProdu.paisOidPais.requiered.message'));
	
	setMV('maeProduFrm.codSap','S', GestionarMensaje('MaeProdu.codSap.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('maeProduFrm', true);
}

function maeProduUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('maeProduFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		maeProduTmpUpdateValues = maeProduBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('maeProduFrm.paisOidPais','S', GestionarMensaje('MaeProdu.paisOidPais.requiered.message'));
		setMV('maeProduFrm.codSap','S', GestionarMensaje('MaeProdu.codSap.requiered.message'));
		
			focusFirstFieldModify('maeProduFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		focusFirstField('maeProduFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('maeProduFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function maeProduRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	maeProduList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('maeProduFrm', true);
}

function maeProduLovInitComponents(){
	maeProduLovReturnParameters = window.dialogArguments;
	
	focusFirstField('maeProduFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad















































//Función que permite cargar los datos de un elemento de lov seleccionado
function maeProduSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('maeProduFrm.' + campo, id);
	set('maeProduFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function maeProduLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	maeProduLovReturnParameters.id = '';
	maeProduLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function maeProduLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeProduList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = maeProduList.codSeleccionados();
	var descripcion = maeProduList.extraeDato(
		maeProduList.codSeleccionados()[0], maeProduChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	maeProduLovReturnParameters.id = codigo;
	maeProduLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function maeProduCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('maeProduFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('maeProduFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "maeProduList", "MaeProduConectorTransactionQuery", 
		"result_ROWSET", parametros, "maeProduPostQueryActions(datos);"]], "", "");	
}

function maeProduCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('maeProduFrm.lastQueryToSession'));
	var i =0;
	set('maeProduFrm.paisOidPais', [paramsRequery.ij(i++)]);
	
	set('maeProduFrm.codSap', paramsRequery.ij(i++));
	
	set('maeProduFrm.codiAnti', paramsRequery.ij(i++));
	
	set('maeProduFrm.desCort', paramsRequery.ij(i++));
	
	set('maeProduFrm.valJera1', paramsRequery.ij(i++));
	
	set('maeProduFrm.valJera2', paramsRequery.ij(i++));
	
	set('maeProduFrm.valJera3', paramsRequery.ij(i++));
	
	set('maeProduFrm.valAtri1', paramsRequery.ij(i++));
	
	set('maeProduFrm.valAtri2', paramsRequery.ij(i++));
	
	set('maeProduFrm.valAtri3', paramsRequery.ij(i++));
	
	set('maeProduFrm.valDimeAlto', paramsRequery.ij(i++));
	
	set('maeProduFrm.valDimeLarg', paramsRequery.ij(i++));
	
	set('maeProduFrm.valDimeAnch', paramsRequery.ij(i++));
	
	set('maeProduFrm.valPeso', paramsRequery.ij(i++));
	
	set('maeProduFrm.valVolu', paramsRequery.ij(i++));
	
	set('maeProduFrm.valCostEstd', paramsRequery.ij(i++));
	
	set('maeProduFrm.valPrecPosi', paramsRequery.ij(i++));
	
	set('maeProduFrm.valPrecCata', paramsRequery.ij(i++));
	
	set('maeProduFrm.valPrecCont', paramsRequery.ij(i++));
	
	set('maeProduFrm.numUnidDentPedi', paramsRequery.ij(i++));
	
	set('maeProduFrm.numUnidCaja', paramsRequery.ij(i++));
	
	set('maeProduFrm.codImpu', paramsRequery.ij(i++));
	
	set('maeProduFrm.pctUnid', paramsRequery.ij(i++));
	
	set('maeProduFrm.geneOidGene', [paramsRequery.ij(i++)]);
	
	set('maeProduFrm.sgenOidSupeGene', [paramsRequery.ij(i++)]);
	
	set('maeProduFrm.unmdOidUnidMedi', [paramsRequery.ij(i++)]);
	
	set('maeProduFrm.unmdOidUnidMediPeso', [paramsRequery.ij(i++)]);
	
	set('maeProduFrm.unmdOidUnidMediDime', [paramsRequery.ij(i++)]);
	
	set('maeProduFrm.negoOidNego', [paramsRequery.ij(i++)]);
	
	set('maeProduFrm.meudOidEstaProd', [paramsRequery.ij(i++)]);
	
	set('maeProduFrm.liprOidLineProd', [paramsRequery.ij(i++)]);
	
	set('maeProduFrm.unegOidUnidNego', [paramsRequery.ij(i++)]);
	
	set('maeProduFrm.perdOidPeriInic', [paramsRequery.ij(i++)]);
	
	set('maeProduFrm.perdOidPeriFin', [paramsRequery.ij(i++)]);
	
	set('maeProduFrm.indLote', paramsRequery.ij(i++));
	
	set('maeProduFrm.indProdServ', paramsRequery.ij(i++));
	
	set('maeProduFrm.codIndSitu', paramsRequery.ij(i++));
	
	set('maeProduFrm.codIndDentCaja', paramsRequery.ij(i++));
	
	set('maeProduFrm.indKit', paramsRequery.ij(i++));
	
	set('maeProduFrm.fopaOidFormPago', [paramsRequery.ij(i++)]);
	
	set('maeProduFrm.maprOidMarcProd', [paramsRequery.ij(i++)]);
	
	set('maeProduFrm.valGrupArti', paramsRequery.ij(i++));
	
	set('maeProduFrm.codUnicVent', paramsRequery.ij(i++));
	
	set('maeProduFrm.prfiOidProgFide', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la página de busqueda como la actual
	maeProduPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	maeProduCmdQuery(maeProduPageCount);
}

function maeProduFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	maeProduPageCount = 1;
	maeProduCmdQuery(maeProduPageCount);
}

function maeProduPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeProduLastQuery){
		maeProduFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	maeProduPageCount--;
	maeProduCmdQuery(maeProduPageCount);
}

function maeProduNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeProduLastQuery){
		maeProduFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	maeProduPageCount++;
	maeProduCmdQuery(maeProduPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function maeProduPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('maeProduListLayer', 'O');
		visibilidad('maeProduListButtonsLayer', 'O');
		if(get('maeProduFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	maeProduLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:maeProduViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, maeProduChoiceColumn) + "</A>",
			i, maeProduChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	maeProduList.setDatos(datosTmp.filtrar([0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	maeProduTimeStamps = datosTmp.filtrar([45],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		maeProduMorePagesFlag = true;
		maeProduList.eliminar(mmgPageSize, 1);
	}else{
		maeProduMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('maeProduFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('maeProduListLayer', 'V');
	visibilidad('maeProduListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('maeProduList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	maeProduList.display();
	
	//Actualizamos el estado de los botones 
	if(maeProduMorePagesFlag){
		set_estado_botonera('maeProduPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('maeProduPaginationButtonBar',
			3,"inactivo");
	}
	if(maeProduPageCount > 1){
		set_estado_botonera('maeProduPaginationButtonBar',
			2,"activo");
		set_estado_botonera('maeProduPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('maeProduPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('maeProduPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function maeProduUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeProduList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('maeProduFrm.idSelection', maeProduList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('maeProduFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = maeProduList.codSeleccionados()[0];
		parametros["previousAction"] = get('maeProduFrm.accion');
		parametros["accion"] = get('maeProduFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('MaeProduLPStartUp', get('maeProduFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) maeProduCmdRequery();
	}
}

function maeProduRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeProduList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = maeProduList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('maeProduFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(maeProduList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += maeProduTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('maeProduFrm.timestamp', timestamps);


	maeProduFrm.oculto='S';
	envia('maeProduFrm');
	maeProduFrm.oculto='N';
}

function maeProduViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeProduList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	maeProduViewDetail(maeProduList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function maeProduViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('maeProduFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('MaeProduLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('maeProduFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	if(validacion){
		maeProduFrm.oculto='S';
		envia('maeProduFrm');
		maeProduFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('maeProduFrm.paisOidPais').toString() == ''){
		set('maeProduFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'maeProdu');
		
	}
	if(get('maeProduFrm.geneOidGene').toString() == ''){
		set('maeProduFrm.geneOidGene', []);
		mmgResetCombosOnCascade('geneOidGene', 'geneOidGene', 'maeProdu');
		
	}
	if(get('maeProduFrm.sgenOidSupeGene').toString() == ''){
		set('maeProduFrm.sgenOidSupeGene', []);
		mmgResetCombosOnCascade('sgenOidSupeGene', 'sgenOidSupeGene', 'maeProdu');
		
	}
	if(get('maeProduFrm.unmdOidUnidMedi').toString() == ''){
		set('maeProduFrm.unmdOidUnidMedi_magnOidMagn', []);
		mmgResetCombosOnCascade('unmdOidUnidMedi_magnOidMagn', 'unmdOidUnidMedi', 'maeProdu');
		
	}
	if(get('maeProduFrm.unmdOidUnidMediPeso').toString() == ''){
		set('maeProduFrm.unmdOidUnidMediPeso_magnOidMagn', []);
		mmgResetCombosOnCascade('unmdOidUnidMediPeso_magnOidMagn', 'unmdOidUnidMediPeso', 'maeProdu');
		
	}
	if(get('maeProduFrm.unmdOidUnidMediDime').toString() == ''){
		set('maeProduFrm.unmdOidUnidMediDime_magnOidMagn', []);
		mmgResetCombosOnCascade('unmdOidUnidMediDime_magnOidMagn', 'unmdOidUnidMediDime', 'maeProdu');
		
	}
	if(get('maeProduFrm.negoOidNego').toString() == ''){
		set('maeProduFrm.negoOidNego', []);
		mmgResetCombosOnCascade('negoOidNego', 'negoOidNego', 'maeProdu');
		
	}
	if(get('maeProduFrm.meudOidEstaProd').toString() == ''){
		set('maeProduFrm.meudOidEstaProd', []);
		mmgResetCombosOnCascade('meudOidEstaProd', 'meudOidEstaProd', 'maeProdu');
		
	}
	if(get('maeProduFrm.liprOidLineProd').toString() == ''){
		set('maeProduFrm.liprOidLineProd', []);
		mmgResetCombosOnCascade('liprOidLineProd', 'liprOidLineProd', 'maeProdu');
		
	}
	if(get('maeProduFrm.unegOidUnidNego').toString() == ''){
		set('maeProduFrm.unegOidUnidNego', []);
		mmgResetCombosOnCascade('unegOidUnidNego', 'unegOidUnidNego', 'maeProdu');
		
	}
	if(get('maeProduFrm.perdOidPeriInic').toString() == ''){
		set('maeProduFrm.perdOidPeriInic', []);
		mmgResetCombosOnCascade('perdOidPeriInic', 'perdOidPeriInic', 'maeProdu');
		
	}
	if(get('maeProduFrm.perdOidPeriFin').toString() == ''){
		set('maeProduFrm.perdOidPeriFin', []);
		mmgResetCombosOnCascade('perdOidPeriFin', 'perdOidPeriFin', 'maeProdu');
		
	}
	if(get('maeProduFrm.fopaOidFormPago').toString() == ''){
		set('maeProduFrm.fopaOidFormPago', []);
		mmgResetCombosOnCascade('fopaOidFormPago', 'fopaOidFormPago', 'maeProdu');
		
	}
	if(get('maeProduFrm.maprOidMarcProd').toString() == ''){
		set('maeProduFrm.maprOidMarcProd', []);
		mmgResetCombosOnCascade('maprOidMarcProd', 'maprOidMarcProd', 'maeProdu');
		
	}
	if(get('maeProduFrm.prfiOidProgFide').toString() == ''){
		set('maeProduFrm.prfiOidProgFide', []);
		mmgResetCombosOnCascade('prfiOidProgFide', 'prfiOidProgFide', 'maeProdu');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	maeProduRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('maeProduFrm.accion');
	var origenTmp = get('maeProduFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(maeProduBuildUpdateRecordString() != maeProduTmpUpdateValues){
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
	document.all.maeProduListLayer.style.display='none';
	document.all.maeProduListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.maeProduListLayer.style.display='';
	document.all.maeProduListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsMaeProduPaisOidPais = get('maeProduFrm.paisOidPais')[0];
	jsMaeProduCodSap = get('maeProduFrm.codSap').toString();
	jsMaeProduCodiAnti = get('maeProduFrm.codiAnti').toString();
	jsMaeProduDesCort = get('maeProduFrm.desCort').toString();
	jsMaeProduValJera1 = get('maeProduFrm.valJera1').toString();
	jsMaeProduValJera2 = get('maeProduFrm.valJera2').toString();
	jsMaeProduValJera3 = get('maeProduFrm.valJera3').toString();
	jsMaeProduValAtri1 = get('maeProduFrm.valAtri1').toString();
	jsMaeProduValAtri2 = get('maeProduFrm.valAtri2').toString();
	jsMaeProduValAtri3 = get('maeProduFrm.valAtri3').toString();
	jsMaeProduValDimeAlto = get('maeProduFrm.valDimeAlto').toString();
	jsMaeProduValDimeLarg = get('maeProduFrm.valDimeLarg').toString();
	jsMaeProduValDimeAnch = get('maeProduFrm.valDimeAnch').toString();
	jsMaeProduValPeso = get('maeProduFrm.valPeso').toString();
	jsMaeProduValVolu = get('maeProduFrm.valVolu').toString();
	jsMaeProduValCostEstd = get('maeProduFrm.valCostEstd').toString();
	jsMaeProduValPrecPosi = get('maeProduFrm.valPrecPosi').toString();
	jsMaeProduValPrecCata = get('maeProduFrm.valPrecCata').toString();
	jsMaeProduValPrecCont = get('maeProduFrm.valPrecCont').toString();
	jsMaeProduNumUnidDentPedi = get('maeProduFrm.numUnidDentPedi').toString();
	jsMaeProduNumUnidCaja = get('maeProduFrm.numUnidCaja').toString();
	jsMaeProduCodImpu = get('maeProduFrm.codImpu').toString();
	jsMaeProduPctUnid = get('maeProduFrm.pctUnid').toString();
	jsMaeProduGeneOidGene = get('maeProduFrm.geneOidGene')[0];
	jsMaeProduSgenOidSupeGene = get('maeProduFrm.sgenOidSupeGene')[0];
	jsMaeProduUnmdOidUnidMedi = get('maeProduFrm.unmdOidUnidMedi')[0];
	jsMaeProduUnmdOidUnidMediPeso = get('maeProduFrm.unmdOidUnidMediPeso')[0];
	jsMaeProduUnmdOidUnidMediDime = get('maeProduFrm.unmdOidUnidMediDime')[0];
	jsMaeProduNegoOidNego = get('maeProduFrm.negoOidNego')[0];
	jsMaeProduMeudOidEstaProd = get('maeProduFrm.meudOidEstaProd')[0];
	jsMaeProduLiprOidLineProd = get('maeProduFrm.liprOidLineProd')[0];
	jsMaeProduUnegOidUnidNego = get('maeProduFrm.unegOidUnidNego')[0];
	jsMaeProduPerdOidPeriInic = get('maeProduFrm.perdOidPeriInic')[0];
	jsMaeProduPerdOidPeriFin = get('maeProduFrm.perdOidPeriFin')[0];
	jsMaeProduIndLote = get('maeProduFrm.indLote').toString();
	jsMaeProduIndProdServ = get('maeProduFrm.indProdServ').toString();
	jsMaeProduCodIndSitu = get('maeProduFrm.codIndSitu').toString();
	jsMaeProduCodIndDentCaja = get('maeProduFrm.codIndDentCaja').toString();
	jsMaeProduIndKit = get('maeProduFrm.indKit').toString();
	jsMaeProduFopaOidFormPago = get('maeProduFrm.fopaOidFormPago')[0];
	jsMaeProduMaprOidMarcProd = get('maeProduFrm.maprOidMarcProd')[0];
	jsMaeProduValGrupArti = get('maeProduFrm.valGrupArti').toString();
	jsMaeProduCodUnicVent = get('maeProduFrm.codUnicVent').toString();
	jsMaeProduPrfiOidProgFide = get('maeProduFrm.prfiOidProgFide')[0];
	
	
	var parametros = "";
	parametros += jsMaeProduPaisOidPais + "|";
	parametros += jsMaeProduCodSap + "|";
	parametros += jsMaeProduCodiAnti + "|";
	parametros += jsMaeProduDesCort + "|";
	parametros += jsMaeProduValJera1 + "|";
	parametros += jsMaeProduValJera2 + "|";
	parametros += jsMaeProduValJera3 + "|";
	parametros += jsMaeProduValAtri1 + "|";
	parametros += jsMaeProduValAtri2 + "|";
	parametros += jsMaeProduValAtri3 + "|";
	parametros += jsMaeProduValDimeAlto + "|";
	parametros += jsMaeProduValDimeLarg + "|";
	parametros += jsMaeProduValDimeAnch + "|";
	parametros += jsMaeProduValPeso + "|";
	parametros += jsMaeProduValVolu + "|";
	parametros += jsMaeProduValCostEstd + "|";
	parametros += jsMaeProduValPrecPosi + "|";
	parametros += jsMaeProduValPrecCata + "|";
	parametros += jsMaeProduValPrecCont + "|";
	parametros += jsMaeProduNumUnidDentPedi + "|";
	parametros += jsMaeProduNumUnidCaja + "|";
	parametros += jsMaeProduCodImpu + "|";
	parametros += jsMaeProduPctUnid + "|";
	parametros += jsMaeProduGeneOidGene + "|";
	parametros += jsMaeProduSgenOidSupeGene + "|";
	parametros += jsMaeProduUnmdOidUnidMedi + "|";
	parametros += jsMaeProduUnmdOidUnidMediPeso + "|";
	parametros += jsMaeProduUnmdOidUnidMediDime + "|";
	parametros += jsMaeProduNegoOidNego + "|";
	parametros += jsMaeProduMeudOidEstaProd + "|";
	parametros += jsMaeProduLiprOidLineProd + "|";
	parametros += jsMaeProduUnegOidUnidNego + "|";
	parametros += jsMaeProduPerdOidPeriInic + "|";
	parametros += jsMaeProduPerdOidPeriFin + "|";
	parametros += jsMaeProduIndLote + "|";
	parametros += jsMaeProduIndProdServ + "|";
	parametros += jsMaeProduCodIndSitu + "|";
	parametros += jsMaeProduCodIndDentCaja + "|";
	parametros += jsMaeProduIndKit + "|";
	parametros += jsMaeProduFopaOidFormPago + "|";
	parametros += jsMaeProduMaprOidMarcProd + "|";
	parametros += jsMaeProduValGrupArti + "|";
	parametros += jsMaeProduCodUnicVent + "|";
	parametros += jsMaeProduPrfiOidProgFide + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function maeProduBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsMaeProduPaisOidPais + "|";
	parametros += jsMaeProduCodSap + "|";
	parametros += jsMaeProduCodiAnti + "|";
	parametros += jsMaeProduDesCort + "|";
	parametros += jsMaeProduValJera1 + "|";
	parametros += jsMaeProduValJera2 + "|";
	parametros += jsMaeProduValJera3 + "|";
	parametros += jsMaeProduValAtri1 + "|";
	parametros += jsMaeProduValAtri2 + "|";
	parametros += jsMaeProduValAtri3 + "|";
	parametros += jsMaeProduValDimeAlto + "|";
	parametros += jsMaeProduValDimeLarg + "|";
	parametros += jsMaeProduValDimeAnch + "|";
	parametros += jsMaeProduValPeso + "|";
	parametros += jsMaeProduValVolu + "|";
	parametros += jsMaeProduValCostEstd + "|";
	parametros += jsMaeProduValPrecPosi + "|";
	parametros += jsMaeProduValPrecCata + "|";
	parametros += jsMaeProduValPrecCont + "|";
	parametros += jsMaeProduNumUnidDentPedi + "|";
	parametros += jsMaeProduNumUnidCaja + "|";
	parametros += jsMaeProduCodImpu + "|";
	parametros += jsMaeProduPctUnid + "|";
	parametros += jsMaeProduGeneOidGene + "|";
	parametros += jsMaeProduSgenOidSupeGene + "|";
	parametros += jsMaeProduUnmdOidUnidMedi + "|";
	parametros += jsMaeProduUnmdOidUnidMediPeso + "|";
	parametros += jsMaeProduUnmdOidUnidMediDime + "|";
	parametros += jsMaeProduNegoOidNego + "|";
	parametros += jsMaeProduMeudOidEstaProd + "|";
	parametros += jsMaeProduLiprOidLineProd + "|";
	parametros += jsMaeProduUnegOidUnidNego + "|";
	parametros += jsMaeProduPerdOidPeriInic + "|";
	parametros += jsMaeProduPerdOidPeriFin + "|";
	parametros += jsMaeProduIndLote + "|";
	parametros += jsMaeProduIndProdServ + "|";
	parametros += jsMaeProduCodIndSitu + "|";
	parametros += jsMaeProduCodIndDentCaja + "|";
	parametros += jsMaeProduIndKit + "|";
	parametros += jsMaeProduFopaOidFormPago + "|";
	parametros += jsMaeProduMaprOidMarcProd + "|";
	parametros += jsMaeProduValGrupArti + "|";
	parametros += jsMaeProduCodUnicVent + "|";
	parametros += jsMaeProduPrfiOidProgFide + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeProduFrm.accion'), 
		get('maeProduFrm.origen'));
	
	jsMaeProduId = get('maeProduFrm.id').toString();
	jsMaeProduPaisOidPais = get('maeProduFrm.paisOidPais')[0];
	jsMaeProduCodSap = get('maeProduFrm.codSap').toString();
	jsMaeProduCodiAnti = get('maeProduFrm.codiAnti').toString();
	jsMaeProduDesCort = get('maeProduFrm.desCort').toString();
	jsMaeProduValJera1 = get('maeProduFrm.valJera1').toString();
	jsMaeProduValJera2 = get('maeProduFrm.valJera2').toString();
	jsMaeProduValJera3 = get('maeProduFrm.valJera3').toString();
	jsMaeProduValAtri1 = get('maeProduFrm.valAtri1').toString();
	jsMaeProduValAtri2 = get('maeProduFrm.valAtri2').toString();
	jsMaeProduValAtri3 = get('maeProduFrm.valAtri3').toString();
	jsMaeProduValDimeAlto = get('maeProduFrm.valDimeAlto').toString();
	jsMaeProduValDimeLarg = get('maeProduFrm.valDimeLarg').toString();
	jsMaeProduValDimeAnch = get('maeProduFrm.valDimeAnch').toString();
	jsMaeProduValPeso = get('maeProduFrm.valPeso').toString();
	jsMaeProduValVolu = get('maeProduFrm.valVolu').toString();
	jsMaeProduValCostEstd = get('maeProduFrm.valCostEstd').toString();
	jsMaeProduValPrecPosi = get('maeProduFrm.valPrecPosi').toString();
	jsMaeProduValPrecCata = get('maeProduFrm.valPrecCata').toString();
	jsMaeProduValPrecCont = get('maeProduFrm.valPrecCont').toString();
	jsMaeProduNumUnidDentPedi = get('maeProduFrm.numUnidDentPedi').toString();
	jsMaeProduNumUnidCaja = get('maeProduFrm.numUnidCaja').toString();
	jsMaeProduCodImpu = get('maeProduFrm.codImpu').toString();
	jsMaeProduPctUnid = get('maeProduFrm.pctUnid').toString();
	jsMaeProduGeneOidGene = get('maeProduFrm.geneOidGene')[0];
	jsMaeProduSgenOidSupeGene = get('maeProduFrm.sgenOidSupeGene')[0];
	jsMaeProduUnmdOidUnidMedi = get('maeProduFrm.unmdOidUnidMedi')[0];
	jsMaeProduUnmdOidUnidMediPeso = get('maeProduFrm.unmdOidUnidMediPeso')[0];
	jsMaeProduUnmdOidUnidMediDime = get('maeProduFrm.unmdOidUnidMediDime')[0];
	jsMaeProduNegoOidNego = get('maeProduFrm.negoOidNego')[0];
	jsMaeProduMeudOidEstaProd = get('maeProduFrm.meudOidEstaProd')[0];
	jsMaeProduLiprOidLineProd = get('maeProduFrm.liprOidLineProd')[0];
	jsMaeProduUnegOidUnidNego = get('maeProduFrm.unegOidUnidNego')[0];
	jsMaeProduPerdOidPeriInic = get('maeProduFrm.perdOidPeriInic')[0];
	jsMaeProduPerdOidPeriFin = get('maeProduFrm.perdOidPeriFin')[0];
	jsMaeProduIndLote = get('maeProduFrm.indLote').toString();
	jsMaeProduIndProdServ = get('maeProduFrm.indProdServ').toString();
	jsMaeProduCodIndSitu = get('maeProduFrm.codIndSitu').toString();
	jsMaeProduCodIndDentCaja = get('maeProduFrm.codIndDentCaja').toString();
	jsMaeProduIndKit = get('maeProduFrm.indKit').toString();
	jsMaeProduFopaOidFormPago = get('maeProduFrm.fopaOidFormPago')[0];
	jsMaeProduMaprOidMarcProd = get('maeProduFrm.maprOidMarcProd')[0];
	jsMaeProduValGrupArti = get('maeProduFrm.valGrupArti').toString();
	jsMaeProduCodUnicVent = get('maeProduFrm.codUnicVent').toString();
	jsMaeProduPrfiOidProgFide = get('maeProduFrm.prfiOidProgFide')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeProduFrm.accion'), 
		get('maeProduFrm.origen'));


	set('maeProduFrm.id', jsMaeProduId);
	set('maeProduFrm.paisOidPais', [jsMaeProduPaisOidPais]);
	set('maeProduFrm.codSap', jsMaeProduCodSap);
	set('maeProduFrm.codiAnti', jsMaeProduCodiAnti);
	set('maeProduFrm.desCort', jsMaeProduDesCort);
	set('maeProduFrm.valJera1', jsMaeProduValJera1);
	set('maeProduFrm.valJera2', jsMaeProduValJera2);
	set('maeProduFrm.valJera3', jsMaeProduValJera3);
	set('maeProduFrm.valAtri1', jsMaeProduValAtri1);
	set('maeProduFrm.valAtri2', jsMaeProduValAtri2);
	set('maeProduFrm.valAtri3', jsMaeProduValAtri3);
	set('maeProduFrm.valDimeAlto', jsMaeProduValDimeAlto);
	set('maeProduFrm.valDimeLarg', jsMaeProduValDimeLarg);
	set('maeProduFrm.valDimeAnch', jsMaeProduValDimeAnch);
	set('maeProduFrm.valPeso', jsMaeProduValPeso);
	set('maeProduFrm.valVolu', jsMaeProduValVolu);
	set('maeProduFrm.valCostEstd', jsMaeProduValCostEstd);
	set('maeProduFrm.valPrecPosi', jsMaeProduValPrecPosi);
	set('maeProduFrm.valPrecCata', jsMaeProduValPrecCata);
	set('maeProduFrm.valPrecCont', jsMaeProduValPrecCont);
	set('maeProduFrm.numUnidDentPedi', jsMaeProduNumUnidDentPedi);
	set('maeProduFrm.numUnidCaja', jsMaeProduNumUnidCaja);
	set('maeProduFrm.codImpu', jsMaeProduCodImpu);
	set('maeProduFrm.pctUnid', jsMaeProduPctUnid);
	set('maeProduFrm.geneOidGene', [jsMaeProduGeneOidGene]);
	set('maeProduFrm.sgenOidSupeGene', [jsMaeProduSgenOidSupeGene]);
	set('maeProduFrm.unmdOidUnidMedi', [jsMaeProduUnmdOidUnidMedi]);
	set('maeProduFrm.unmdOidUnidMediPeso', [jsMaeProduUnmdOidUnidMediPeso]);
	set('maeProduFrm.unmdOidUnidMediDime', [jsMaeProduUnmdOidUnidMediDime]);
	set('maeProduFrm.negoOidNego', [jsMaeProduNegoOidNego]);
	set('maeProduFrm.meudOidEstaProd', [jsMaeProduMeudOidEstaProd]);
	set('maeProduFrm.liprOidLineProd', [jsMaeProduLiprOidLineProd]);
	set('maeProduFrm.unegOidUnidNego', [jsMaeProduUnegOidUnidNego]);
	set('maeProduFrm.perdOidPeriInic', [jsMaeProduPerdOidPeriInic]);
	set('maeProduFrm.perdOidPeriFin', [jsMaeProduPerdOidPeriFin]);
	set('maeProduFrm.indLote', jsMaeProduIndLote);
	set('maeProduFrm.indProdServ', jsMaeProduIndProdServ);
	set('maeProduFrm.codIndSitu', jsMaeProduCodIndSitu);
	set('maeProduFrm.codIndDentCaja', jsMaeProduCodIndDentCaja);
	set('maeProduFrm.indKit', jsMaeProduIndKit);
	set('maeProduFrm.fopaOidFormPago', [jsMaeProduFopaOidFormPago]);
	set('maeProduFrm.maprOidMarcProd', [jsMaeProduMaprOidMarcProd]);
	set('maeProduFrm.valGrupArti', jsMaeProduValGrupArti);
	set('maeProduFrm.codUnicVent', jsMaeProduCodUnicVent);
	set('maeProduFrm.prfiOidProgFide', [jsMaeProduPrfiOidProgFide]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsMaeProduPaisOidPais = '';
	jsMaeProduCodSap = '';
	jsMaeProduCodiAnti = '';
	jsMaeProduDesCort = '';
	jsMaeProduValJera1 = '';
	jsMaeProduValJera2 = '';
	jsMaeProduValJera3 = '';
	jsMaeProduValAtri1 = '';
	jsMaeProduValAtri2 = '';
	jsMaeProduValAtri3 = '';
	jsMaeProduValDimeAlto = '';
	jsMaeProduValDimeLarg = '';
	jsMaeProduValDimeAnch = '';
	jsMaeProduValPeso = '';
	jsMaeProduValVolu = '';
	jsMaeProduValCostEstd = '';
	jsMaeProduValPrecPosi = '';
	jsMaeProduValPrecCata = '';
	jsMaeProduValPrecCont = '';
	jsMaeProduNumUnidDentPedi = '';
	jsMaeProduNumUnidCaja = '';
	jsMaeProduCodImpu = '';
	jsMaeProduPctUnid = '';
	jsMaeProduGeneOidGene = '';
	jsMaeProduSgenOidSupeGene = '';
	jsMaeProduUnmdOidUnidMedi = '';
	jsMaeProduUnmdOidUnidMediPeso = '';
	jsMaeProduUnmdOidUnidMediDime = '';
	jsMaeProduNegoOidNego = '';
	jsMaeProduMeudOidEstaProd = '';
	jsMaeProduLiprOidLineProd = '';
	jsMaeProduUnegOidUnidNego = '';
	jsMaeProduPerdOidPeriInic = '';
	jsMaeProduPerdOidPeriFin = '';
	jsMaeProduIndLote = '';
	jsMaeProduIndProdServ = '';
	jsMaeProduCodIndSitu = '';
	jsMaeProduCodIndDentCaja = '';
	jsMaeProduIndKit = '';
	jsMaeProduFopaOidFormPago = '';
	jsMaeProduMaprOidMarcProd = '';
	jsMaeProduValGrupArti = '';
	jsMaeProduCodUnicVent = '';
	jsMaeProduPrfiOidProgFide = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('maeProduFrm.errCodigo', errorCode);
	set('maeProduFrm.errDescripcion', description);
	set('maeProduFrm.errSeverity', severity);
	fMostrarMensajeError();
}
