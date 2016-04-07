

/*
    INDRA/CAR/mmg
    $Id: facformu.js,v 1.1 2009/12/03 19:02:07 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsFacFormuId = "";
var jsFacFormuCodForm = "";
var jsFacFormuNumLine = "";
var jsFacFormuValTamaForm = "";
var jsFacFormuValRutiDiseForm = "";
var jsFacFormuIndImpr = "";
var jsFacFormuIndPrei = "";
var jsFacFormuIndSpooIndi = "";
var jsFacFormuTeimOidTecn = "";
var jsFacFormuValNombForm = "";
var jsFacFormuIndActi = "";
var jsFacFormuIndNumOfic = "";
var jsFacFormuNumLineSaltPagi = "";
var jsFacFormuTidoOidTipoDocu = "";
var jsFacFormuDeimOidDestImpr = "";
var jsFacFormuTifoOidTipoForm = "";

//Variables de paginacion, 
var facFormuPageCount = 1;

//Varible de columna que representa el campo de choice
var facFormuChoiceColumn = 0;

//Flag de siguiente pagina;
var facFormuMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var facFormuTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 189;
var sizeFormView = 309;
var sizeFormUpdate = 309;

//Ultima busqueda realizada
var facFormuLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("facFormuFrm.codForm");','focaliza("facFormuFrm.codForm");','focaliza("facFormuFrm.codForm");','focaliza("facFormuFrm.codForm");','focaliza("facFormuFrm.codForm");','focaliza("facFormuFrm.codForm");'],[3,'','focaliza("facFormuFrm.numLine");','focaliza("facFormuFrm.numLine");','','focaliza("facFormuFrm.numLine");','focaliza("facFormuFrm.numLine");'],[4,'','focaliza("facFormuFrm.valTamaForm");','focaliza("facFormuFrm.valTamaForm");','','focaliza("facFormuFrm.valTamaForm");','focaliza("facFormuFrm.valTamaForm");'],[5,'','focaliza("facFormuFrm.valRutiDiseForm");','focaliza("facFormuFrm.valRutiDiseForm");','','focaliza("facFormuFrm.valRutiDiseForm");','focaliza("facFormuFrm.valRutiDiseForm");'],[6,'focaliza("facFormuFrm.indImpr");','focaliza("facFormuFrm.indImpr");','focaliza("facFormuFrm.indImpr");','focaliza("facFormuFrm.indImpr");','focaliza("facFormuFrm.indImpr");','focaliza("facFormuFrm.indImpr");'],[7,'','focaliza("facFormuFrm.indPrei");','focaliza("facFormuFrm.indPrei");','','focaliza("facFormuFrm.indPrei");','focaliza("facFormuFrm.indPrei");'],[8,'','focaliza("facFormuFrm.indSpooIndi");','focaliza("facFormuFrm.indSpooIndi");','','focaliza("facFormuFrm.indSpooIndi");','focaliza("facFormuFrm.indSpooIndi");'],[9,'','focalizaComboDependence("facFormu","teimOidTecn", false);','focalizaComboDependence("facFormu","teimOidTecn", false);','','focalizaComboDependence("facFormu","teimOidTecn", true);','focalizaComboDependence("facFormu","teimOidTecn", true);'],[10,'focaliza("facFormuFrm.valNombForm");','focaliza("facFormuFrm.valNombForm");','focaliza("facFormuFrm.valNombForm");','focaliza("facFormuFrm.valNombForm");','focaliza("facFormuFrm.valNombForm");','focaliza("facFormuFrm.valNombForm");'],[11,'focaliza("facFormuFrm.indActi");','focaliza("facFormuFrm.indActi");','focaliza("facFormuFrm.indActi");','focaliza("facFormuFrm.indActi");','focaliza("facFormuFrm.indActi");','focaliza("facFormuFrm.indActi");'],[12,'','focaliza("facFormuFrm.indNumOfic");','focaliza("facFormuFrm.indNumOfic");','','focaliza("facFormuFrm.indNumOfic");','focaliza("facFormuFrm.indNumOfic");'],[13,'','focaliza("facFormuFrm.numLineSaltPagi");','focaliza("facFormuFrm.numLineSaltPagi");','','focaliza("facFormuFrm.numLineSaltPagi");','focaliza("facFormuFrm.numLineSaltPagi");'],[14,'focalizaComboDependence("facFormu","tidoOidTipoDocu", false);','focalizaComboDependence("facFormu","tidoOidTipoDocu", false);','focalizaComboDependence("facFormu","tidoOidTipoDocu", false);','focalizaComboDependence("facFormu","tidoOidTipoDocu", true);','focalizaComboDependence("facFormu","tidoOidTipoDocu", true);','focalizaComboDependence("facFormu","tidoOidTipoDocu", true);'],[15,'','focalizaComboDependence("facFormu","deimOidDestImpr", false);','focalizaComboDependence("facFormu","deimOidDestImpr", false);','','focalizaComboDependence("facFormu","deimOidDestImpr", true);','focalizaComboDependence("facFormu","deimOidDestImpr", true);'],[16,'','focalizaComboDependence("facFormu","tifoOidTipoForm", false);','focalizaComboDependence("facFormu","tifoOidTipoForm", false);','','focalizaComboDependence("facFormu","tifoOidTipoForm", true);','focalizaComboDependence("facFormu","tifoOidTipoForm", true);']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[3,'','focaliza("facFormuFrm.numLine");','focaliza("facFormuFrm.numLine");','','focaliza("facFormuFrm.numLine");','focaliza("facFormuFrm.numLine");'],[4,'','focaliza("facFormuFrm.valTamaForm");','focaliza("facFormuFrm.valTamaForm");','','focaliza("facFormuFrm.valTamaForm");','focaliza("facFormuFrm.valTamaForm");'],[5,'','focaliza("facFormuFrm.valRutiDiseForm");','focaliza("facFormuFrm.valRutiDiseForm");','','focaliza("facFormuFrm.valRutiDiseForm");','focaliza("facFormuFrm.valRutiDiseForm");'],[6,'focaliza("facFormuFrm.indImpr");','focaliza("facFormuFrm.indImpr");','focaliza("facFormuFrm.indImpr");','focaliza("facFormuFrm.indImpr");','focaliza("facFormuFrm.indImpr");','focaliza("facFormuFrm.indImpr");'],[7,'','focaliza("facFormuFrm.indPrei");','focaliza("facFormuFrm.indPrei");','','focaliza("facFormuFrm.indPrei");','focaliza("facFormuFrm.indPrei");'],[8,'','focaliza("facFormuFrm.indSpooIndi");','focaliza("facFormuFrm.indSpooIndi");','','focaliza("facFormuFrm.indSpooIndi");','focaliza("facFormuFrm.indSpooIndi");'],[9,'','focalizaComboDependence("facFormu","teimOidTecn", false);','focalizaComboDependence("facFormu","teimOidTecn", false);','','focalizaComboDependence("facFormu","teimOidTecn", true);','focalizaComboDependence("facFormu","teimOidTecn", true);'],[10,'focaliza("facFormuFrm.valNombForm");','focaliza("facFormuFrm.valNombForm");','focaliza("facFormuFrm.valNombForm");','focaliza("facFormuFrm.valNombForm");','focaliza("facFormuFrm.valNombForm");','focaliza("facFormuFrm.valNombForm");'],[11,'focaliza("facFormuFrm.indActi");','focaliza("facFormuFrm.indActi");','focaliza("facFormuFrm.indActi");','focaliza("facFormuFrm.indActi");','focaliza("facFormuFrm.indActi");','focaliza("facFormuFrm.indActi");'],[12,'','focaliza("facFormuFrm.indNumOfic");','focaliza("facFormuFrm.indNumOfic");','','focaliza("facFormuFrm.indNumOfic");','focaliza("facFormuFrm.indNumOfic");'],[13,'','focaliza("facFormuFrm.numLineSaltPagi");','focaliza("facFormuFrm.numLineSaltPagi");','','focaliza("facFormuFrm.numLineSaltPagi");','focaliza("facFormuFrm.numLineSaltPagi");'],[14,'focalizaComboDependence("facFormu","tidoOidTipoDocu", false);','focalizaComboDependence("facFormu","tidoOidTipoDocu", false);','focalizaComboDependence("facFormu","tidoOidTipoDocu", false);','focalizaComboDependence("facFormu","tidoOidTipoDocu", true);','focalizaComboDependence("facFormu","tidoOidTipoDocu", true);','focalizaComboDependence("facFormu","tidoOidTipoDocu", true);'],[15,'','focalizaComboDependence("facFormu","deimOidDestImpr", false);','focalizaComboDependence("facFormu","deimOidDestImpr", false);','','focalizaComboDependence("facFormu","deimOidDestImpr", true);','focalizaComboDependence("facFormu","deimOidDestImpr", true);'],[16,'','focalizaComboDependence("facFormu","tifoOidTipoForm", false);','focalizaComboDependence("facFormu","tifoOidTipoForm", false);','','focalizaComboDependence("facFormu","tifoOidTipoForm", true);','focalizaComboDependence("facFormu","tifoOidTipoForm", true);']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var teimOidTecnDependeceMap = new Vector();
teimOidTecnDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
teimOidTecnDependeceMap.agregar(['teimOidTecn', padresTmp, '', 'FacTecnoImpre']);
var tidoOidTipoDocuDependeceMap = new Vector();
tidoOidTipoDocuDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
tidoOidTipoDocuDependeceMap.agregar(['tidoOidTipoDocu', padresTmp, '', 'FacTipoDocum']);
var deimOidDestImprDependeceMap = new Vector();
deimOidDestImprDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
deimOidDestImprDependeceMap.agregar(['deimOidDestImpr', padresTmp, '', 'FacDestiImpre']);
var tifoOidTipoFormDependeceMap = new Vector();
tifoOidTipoFormDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
tifoOidTipoFormDependeceMap.agregar(['tifoOidTipoForm', padresTmp, '', 'FacTipoFormu']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
facFormuLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var facFormuTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function facFormuInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('facFormuFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('facFormuFrm.accion')){
		case "query": facFormuQueryInitComponents(); break;
		case "view": facFormuViewInitComponents(); break;
		case "create": facFormuCreateInitComponents(); break;
		case "update": facFormuUpdateInitComponents(); break;
		case "remove": facFormuRemoveInitComponents(); break;
		case "lov": facFormuLovInitComponents(); break;
	}
	//alert('accion :' + get('facFormuFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('facFormuFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('facFormu')) facFormuCmdRequery();
}

function facFormuQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	focusFirstField('facFormuFrm', true);	
}

function facFormuViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	//Establecemos el valor de los radiobuttons
		set('facFormuFrm.indImpr', get('facFormuFrm.indImprCheckValue'));
		set('facFormuFrm.indPrei', get('facFormuFrm.indPreiCheckValue'));
		set('facFormuFrm.indSpooIndi', get('facFormuFrm.indSpooIndiCheckValue'));
		
	focusFirstField('facFormuFrm', true);
}

function facFormuCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('facFormuFrm.codForm','S', GestionarMensaje('FacFormu.codForm.requiered.message'));
	
	setMV('facFormuFrm.numLine','S', GestionarMensaje('FacFormu.numLine.requiered.message'));
	
	setMV('facFormuFrm.valTamaForm','S', GestionarMensaje('FacFormu.valTamaForm.requiered.message'));
	
	setMV('facFormuFrm.valRutiDiseForm','S', GestionarMensaje('FacFormu.valRutiDiseForm.requiered.message'));
	
	setMV('facFormuFrm.indImpr','S', GestionarMensaje('FacFormu.indImpr.requiered.message'));
	
	setMV('facFormuFrm.indPrei','S', GestionarMensaje('FacFormu.indPrei.requiered.message'));
	
	setMV('facFormuFrm.indSpooIndi','S', GestionarMensaje('FacFormu.indSpooIndi.requiered.message'));
	
	setMV('facFormuFrm.teimOidTecn','S', GestionarMensaje('FacFormu.teimOidTecn.requiered.message'));
	
	setMV('facFormuFrm.valNombForm','S', GestionarMensaje('FacFormu.valNombForm.requiered.message'));
	
	setMV('facFormuFrm.indActi','S', GestionarMensaje('FacFormu.indActi.requiered.message'));
	
	setMV('facFormuFrm.indNumOfic','S', GestionarMensaje('FacFormu.indNumOfic.requiered.message'));
	
	setMV('facFormuFrm.numLineSaltPagi','S', GestionarMensaje('FacFormu.numLineSaltPagi.requiered.message'));
	
	setMV('facFormuFrm.deimOidDestImpr','S', GestionarMensaje('FacFormu.deimOidDestImpr.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('facFormuFrm', true);
}

function facFormuUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('facFormuFrm.origen') == "pagina"){
		

		//Establecemos el valor de los radiobuttons
			set('facFormuFrm.indImpr', get('facFormuFrm.indImprCheckValue'));
			set('facFormuFrm.indPrei', get('facFormuFrm.indPreiCheckValue'));
			set('facFormuFrm.indSpooIndi', get('facFormuFrm.indSpooIndiCheckValue'));
			

		//Registramos el valor del elemento que estamos modificando
		facFormuTmpUpdateValues = facFormuBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('facFormuFrm.codForm','S', GestionarMensaje('FacFormu.codForm.requiered.message'));
		setMV('facFormuFrm.numLine','S', GestionarMensaje('FacFormu.numLine.requiered.message'));
		setMV('facFormuFrm.valTamaForm','S', GestionarMensaje('FacFormu.valTamaForm.requiered.message'));
		setMV('facFormuFrm.valRutiDiseForm','S', GestionarMensaje('FacFormu.valRutiDiseForm.requiered.message'));
		setMV('facFormuFrm.indImpr','S', GestionarMensaje('FacFormu.indImpr.requiered.message'));
		setMV('facFormuFrm.indPrei','S', GestionarMensaje('FacFormu.indPrei.requiered.message'));
		setMV('facFormuFrm.indSpooIndi','S', GestionarMensaje('FacFormu.indSpooIndi.requiered.message'));
		setMV('facFormuFrm.teimOidTecn','S', GestionarMensaje('FacFormu.teimOidTecn.requiered.message'));
		setMV('facFormuFrm.valNombForm','S', GestionarMensaje('FacFormu.valNombForm.requiered.message'));
		setMV('facFormuFrm.indActi','S', GestionarMensaje('FacFormu.indActi.requiered.message'));
		setMV('facFormuFrm.indNumOfic','S', GestionarMensaje('FacFormu.indNumOfic.requiered.message'));
		setMV('facFormuFrm.numLineSaltPagi','S', GestionarMensaje('FacFormu.numLineSaltPagi.requiered.message'));
		setMV('facFormuFrm.deimOidDestImpr','S', GestionarMensaje('FacFormu.deimOidDestImpr.requiered.message'));
		
			focusFirstFieldModify('facFormuFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		focusFirstField('facFormuFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('facFormuFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function facFormuRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	facFormuList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('facFormuFrm', true);
}

function facFormuLovInitComponents(){
	facFormuLovReturnParameters = window.dialogArguments;
	
	focusFirstField('facFormuFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad


















//Función que permite cargar los datos de un elemento de lov seleccionado
function facFormuSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('facFormuFrm.' + campo, id);
	set('facFormuFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function facFormuLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	facFormuLovReturnParameters.id = '';
	facFormuLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function facFormuLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(facFormuList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = facFormuList.codSeleccionados();
	var descripcion = facFormuList.extraeDato(
		facFormuList.codSeleccionados()[0], facFormuChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	facFormuLovReturnParameters.id = codigo;
	facFormuLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function facFormuCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('facFormuFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('facFormuFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "facFormuList", "FacFormuConectorTransactionQuery", 
		"result_ROWSET", parametros, "facFormuPostQueryActions(datos);"]], "", "");	
}

function facFormuCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('facFormuFrm.lastQueryToSession'));
	var i =0;
	set('facFormuFrm.codForm', paramsRequery.ij(i++));
	
	set('facFormuFrm.indImpr', paramsRequery.ij(i++));
	
	set('facFormuFrm.valNombForm', paramsRequery.ij(i++));
	
	set('facFormuFrm.indActi', [paramsRequery.ij(i++)]);
	
	set('facFormuFrm.tidoOidTipoDocu', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la página de busqueda como la actual
	facFormuPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	facFormuCmdQuery(facFormuPageCount);
}

function facFormuFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	facFormuPageCount = 1;
	facFormuCmdQuery(facFormuPageCount);
}

function facFormuPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != facFormuLastQuery){
		facFormuFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	facFormuPageCount--;
	facFormuCmdQuery(facFormuPageCount);
}

function facFormuNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != facFormuLastQuery){
		facFormuFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	facFormuPageCount++;
	facFormuCmdQuery(facFormuPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function facFormuPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('facFormuListLayer', 'O');
		visibilidad('facFormuListButtonsLayer', 'O');
		if(get('facFormuFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	facFormuLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	for(var i=0; i < datosTmp.longitud; i++){ 
		switch(datosTmp.ij(i, 2)){
			case '1': datosTmp.ij2(GestionarMensaje('FacFormu.indImpr.1.value'), i, 2); break;
			case '0': datosTmp.ij2(GestionarMensaje('FacFormu.indImpr.0.value'), i, 2); break;
			default: datosTmp .ij2('', i, 2);
		}
	}
	for(var i=0; i < datosTmp.longitud; i++){ 
		switch(datosTmp.ij(i, 4)){
			case '1': datosTmp.ij2(GestionarMensaje('FacFormu.indActi.1.value'), i, 4); break;
			case '0': datosTmp.ij2(GestionarMensaje('FacFormu.indActi.0.value'), i, 4); break;
			default: datosTmp .ij2('', i, 4);
		}
	}
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:facFormuViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, facFormuChoiceColumn) + "</A>",
			i, facFormuChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	facFormuList.setDatos(datosTmp.filtrar([0,1,2,3,4,5],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	facFormuTimeStamps = datosTmp.filtrar([6],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		facFormuMorePagesFlag = true;
		facFormuList.eliminar(mmgPageSize, 1);
	}else{
		facFormuMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('facFormuFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('facFormuListLayer', 'V');
	visibilidad('facFormuListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('facFormuList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	facFormuList.display();
	
	//Actualizamos el estado de los botones 
	if(facFormuMorePagesFlag){
		set_estado_botonera('facFormuPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('facFormuPaginationButtonBar',
			3,"inactivo");
	}
	if(facFormuPageCount > 1){
		set_estado_botonera('facFormuPaginationButtonBar',
			2,"activo");
		set_estado_botonera('facFormuPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('facFormuPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('facFormuPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function facFormuUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(facFormuList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('facFormuFrm.idSelection', facFormuList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('facFormuFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = facFormuList.codSeleccionados()[0];
		parametros["previousAction"] = get('facFormuFrm.accion');
		parametros["accion"] = get('facFormuFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('FacFormuLPStartUp', get('facFormuFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) facFormuCmdRequery();
	}
}

function facFormuRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(facFormuList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = facFormuList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('facFormuFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(facFormuList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += facFormuTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('facFormuFrm.timestamp', timestamps);


	facFormuFrm.oculto='S';
	envia('facFormuFrm');
	facFormuFrm.oculto='N';
}

function facFormuViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(facFormuList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	facFormuViewDetail(facFormuList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function facFormuViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('facFormuFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('FacFormuLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	// Validación: El 'Tipo de numeración documento = Oficial' implica que 'Preimpreso = Sí' 
	if((get('facFormuFrm.indNumOfic').toString() == '1') && (get('facFormuFrm.indPrei').toString() == '0')){		
		cdos_mostrarAlert(GestionarMensaje('FacFormu.indNumOfic.validation.message'));		
		focaliza("facFormuFrm.indPrei");
		return;
	}


	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('facFormuFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	if(validacion){
		facFormuFrm.oculto='S';
		envia('facFormuFrm');
		facFormuFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('facFormuFrm.teimOidTecn').toString() == ''){
		set('facFormuFrm.teimOidTecn', []);
		mmgResetCombosOnCascade('teimOidTecn', 'teimOidTecn', 'facFormu');
		
	}
	if(get('facFormuFrm.tidoOidTipoDocu').toString() == ''){
		set('facFormuFrm.tidoOidTipoDocu', []);
		mmgResetCombosOnCascade('tidoOidTipoDocu', 'tidoOidTipoDocu', 'facFormu');
		
	}
	if(get('facFormuFrm.deimOidDestImpr').toString() == ''){
		set('facFormuFrm.deimOidDestImpr', []);
		mmgResetCombosOnCascade('deimOidDestImpr', 'deimOidDestImpr', 'facFormu');
		
	}
	if(get('facFormuFrm.tifoOidTipoForm').toString() == ''){
		set('facFormuFrm.tifoOidTipoForm', []);
		mmgResetCombosOnCascade('tifoOidTipoForm', 'tifoOidTipoForm', 'facFormu');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	facFormuRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('facFormuFrm.accion');
	var origenTmp = get('facFormuFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(facFormuBuildUpdateRecordString() != facFormuTmpUpdateValues){
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
	document.all.facFormuListLayer.style.display='none';
	document.all.facFormuListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.facFormuListLayer.style.display='';
	document.all.facFormuListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsFacFormuCodForm = get('facFormuFrm.codForm').toString();
	jsFacFormuIndImpr = get('facFormuFrm.indImpr');
	jsFacFormuValNombForm = get('facFormuFrm.valNombForm').toString();
	jsFacFormuIndActi = get('facFormuFrm.indActi')[0];
	jsFacFormuTidoOidTipoDocu = get('facFormuFrm.tidoOidTipoDocu')[0];
	
	
	var parametros = "";
	parametros += jsFacFormuCodForm + "|";
	parametros += jsFacFormuIndImpr + "|";
	parametros += jsFacFormuValNombForm + "|";
	parametros += jsFacFormuIndActi + "|";
	parametros += jsFacFormuTidoOidTipoDocu + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function facFormuBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsFacFormuCodForm + "|";
	parametros += jsFacFormuNumLine + "|";
	parametros += jsFacFormuValTamaForm + "|";
	parametros += jsFacFormuValRutiDiseForm + "|";
	parametros += jsFacFormuIndImpr + "|";
	parametros += jsFacFormuIndPrei + "|";
	parametros += jsFacFormuIndSpooIndi + "|";
	parametros += jsFacFormuTeimOidTecn + "|";
	parametros += jsFacFormuValNombForm + "|";
	parametros += jsFacFormuIndActi + "|";
	parametros += jsFacFormuIndNumOfic + "|";
	parametros += jsFacFormuNumLineSaltPagi + "|";
	parametros += jsFacFormuTidoOidTipoDocu + "|";
	parametros += jsFacFormuDeimOidDestImpr + "|";
	parametros += jsFacFormuTifoOidTipoForm + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('facFormuFrm.accion'), 
		get('facFormuFrm.origen'));
	
	jsFacFormuId = get('facFormuFrm.id').toString();
	jsFacFormuCodForm = get('facFormuFrm.codForm').toString();
	jsFacFormuNumLine = get('facFormuFrm.numLine').toString();
	jsFacFormuValTamaForm = get('facFormuFrm.valTamaForm').toString();
	jsFacFormuValRutiDiseForm = get('facFormuFrm.valRutiDiseForm').toString();
	jsFacFormuIndImpr = get('facFormuFrm.indImpr');
	jsFacFormuIndPrei = get('facFormuFrm.indPrei');
	jsFacFormuIndSpooIndi = get('facFormuFrm.indSpooIndi');
	jsFacFormuTeimOidTecn = get('facFormuFrm.teimOidTecn')[0];
	jsFacFormuValNombForm = get('facFormuFrm.valNombForm').toString();
	jsFacFormuIndActi = get('facFormuFrm.indActi')[0];
	jsFacFormuIndNumOfic = get('facFormuFrm.indNumOfic')[0];
	jsFacFormuNumLineSaltPagi = get('facFormuFrm.numLineSaltPagi').toString();
	jsFacFormuTidoOidTipoDocu = get('facFormuFrm.tidoOidTipoDocu')[0];
	jsFacFormuDeimOidDestImpr = get('facFormuFrm.deimOidDestImpr')[0];
	jsFacFormuTifoOidTipoForm = get('facFormuFrm.tifoOidTipoForm')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('facFormuFrm.accion'), 
		get('facFormuFrm.origen'));


	set('facFormuFrm.id', jsFacFormuId);
	set('facFormuFrm.codForm', jsFacFormuCodForm);
	set('facFormuFrm.numLine', jsFacFormuNumLine);
	set('facFormuFrm.valTamaForm', jsFacFormuValTamaForm);
	set('facFormuFrm.valRutiDiseForm', jsFacFormuValRutiDiseForm);
	set('facFormuFrm.indImpr', jsFacFormuIndImpr);
	set('facFormuFrm.indPrei', jsFacFormuIndPrei);
	set('facFormuFrm.indSpooIndi', jsFacFormuIndSpooIndi);
	set('facFormuFrm.teimOidTecn', [jsFacFormuTeimOidTecn]);
	set('facFormuFrm.valNombForm', jsFacFormuValNombForm);
	set('facFormuFrm.indActi', [jsFacFormuIndActi]);
	set('facFormuFrm.indNumOfic', [jsFacFormuIndNumOfic]);
	set('facFormuFrm.numLineSaltPagi', jsFacFormuNumLineSaltPagi);
	set('facFormuFrm.tidoOidTipoDocu', [jsFacFormuTidoOidTipoDocu]);
	set('facFormuFrm.deimOidDestImpr', [jsFacFormuDeimOidDestImpr]);
	set('facFormuFrm.tifoOidTipoForm', [jsFacFormuTifoOidTipoForm]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsFacFormuCodForm = '';
	jsFacFormuIndImpr = '';
	jsFacFormuValNombForm = '';
	jsFacFormuIndActi = '';
	jsFacFormuTidoOidTipoDocu = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('facFormuFrm.errCodigo', errorCode);
	set('facFormuFrm.errDescripcion', description);
	set('facFormuFrm.errSeverity', severity);
	fMostrarMensajeError();
}
