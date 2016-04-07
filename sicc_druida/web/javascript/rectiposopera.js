

/*
    INDRA/CAR/mmg
    $Id: rectiposopera.js,v 1.1 2009/12/03 19:02:23 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsRecTiposOperaId = "";
var jsRecTiposOperaValTipoOper = "";
var jsRecTiposOperaIndCampRefeUnic = "";
var jsRecTiposOperaNumDiasHaciAtra = "";
var jsRecTiposOperaValInfoEbelNoti = "";
var jsRecTiposOperaIndDevuEstaFact = "";
var jsRecTiposOperaIndEnviEstaFact = "";
var jsRecTiposOperaRopeOidOper = "";
var jsRecTiposOperaMrdbOidMotiRechDesb = "";
var jsRecTiposOperaMoblOidBloqDife = "";
var jsRecTiposOperaMoblOidReclAnte = "";
var jsRecTiposOperaMoblOidBloqImpo = "";
var jsRecTiposOperaMoblOidBloqUnid = "";

//Variables de paginacion, 
var recTiposOperaPageCount = 1;

//Varible de columna que representa el campo de choice
var recTiposOperaChoiceColumn = 12;

//Flag de siguiente pagina;
var recTiposOperaMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var recTiposOperaTimeStamps = null;

//Tama�os del formulario
var sizeFormQuery = 567;
var sizeFormView = 557;
var sizeFormUpdate = 557;

//Ultima busqueda realizada
var recTiposOperaLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acci�n a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("recTiposOperaFrm.valTipoOper");','focaliza("recTiposOperaFrm.valTipoOper");','focaliza("recTiposOperaFrm.valTipoOper");','focaliza("recTiposOperaFrm.valTipoOper");','focaliza("recTiposOperaFrm.valTipoOper");','focaliza("recTiposOperaFrm.valTipoOper");'],[3,'focaliza("recTiposOperaFrm.indCampRefeUnic");','focaliza("recTiposOperaFrm.indCampRefeUnic");','focaliza("recTiposOperaFrm.indCampRefeUnic");','focaliza("recTiposOperaFrm.indCampRefeUnic");','focaliza("recTiposOperaFrm.indCampRefeUnic");','focaliza("recTiposOperaFrm.indCampRefeUnic");'],[4,'focaliza("recTiposOperaFrm.numDiasHaciAtra");','focaliza("recTiposOperaFrm.numDiasHaciAtra");','focaliza("recTiposOperaFrm.numDiasHaciAtra");','focaliza("recTiposOperaFrm.numDiasHaciAtra");','focaliza("recTiposOperaFrm.numDiasHaciAtra");','focaliza("recTiposOperaFrm.numDiasHaciAtra");'],[5,'focaliza("recTiposOperaFrm.valInfoEbelNoti");','focaliza("recTiposOperaFrm.valInfoEbelNoti");','focaliza("recTiposOperaFrm.valInfoEbelNoti");','focaliza("recTiposOperaFrm.valInfoEbelNoti");','focaliza("recTiposOperaFrm.valInfoEbelNoti");','focaliza("recTiposOperaFrm.valInfoEbelNoti");'],[6,'focaliza("recTiposOperaFrm.indDevuEstaFact");','focaliza("recTiposOperaFrm.indDevuEstaFact");','focaliza("recTiposOperaFrm.indDevuEstaFact");','focaliza("recTiposOperaFrm.indDevuEstaFact");','focaliza("recTiposOperaFrm.indDevuEstaFact");','focaliza("recTiposOperaFrm.indDevuEstaFact");'],[7,'focaliza("recTiposOperaFrm.indEnviEstaFact");','focaliza("recTiposOperaFrm.indEnviEstaFact");','focaliza("recTiposOperaFrm.indEnviEstaFact");','focaliza("recTiposOperaFrm.indEnviEstaFact");','focaliza("recTiposOperaFrm.indEnviEstaFact");','focaliza("recTiposOperaFrm.indEnviEstaFact");'],[8,'focalizaComboDependence("recTiposOpera","ropeOidOper", false);','focalizaComboDependence("recTiposOpera","ropeOidOper", false);','focalizaComboDependence("recTiposOpera","ropeOidOper", false);','focalizaComboDependence("recTiposOpera","ropeOidOper", true);','focalizaComboDependence("recTiposOpera","ropeOidOper", true);','focalizaComboDependence("recTiposOpera","ropeOidOper", true);'],[9,'focalizaComboDependence("recTiposOpera","mrdbOidMotiRechDesb", false);','focalizaComboDependence("recTiposOpera","mrdbOidMotiRechDesb", false);','focalizaComboDependence("recTiposOpera","mrdbOidMotiRechDesb", false);','focalizaComboDependence("recTiposOpera","mrdbOidMotiRechDesb", true);','focalizaComboDependence("recTiposOpera","mrdbOidMotiRechDesb", true);','focalizaComboDependence("recTiposOpera","mrdbOidMotiRechDesb", true);'],[10,'focalizaComboDependence("recTiposOpera","moblOidBloqDife", false);','focalizaComboDependence("recTiposOpera","moblOidBloqDife", false);','focalizaComboDependence("recTiposOpera","moblOidBloqDife", false);','focalizaComboDependence("recTiposOpera","moblOidBloqDife", true);','focalizaComboDependence("recTiposOpera","moblOidBloqDife", true);','focalizaComboDependence("recTiposOpera","moblOidBloqDife", true);'],[11,'focalizaComboDependence("recTiposOpera","moblOidReclAnte", false);','focalizaComboDependence("recTiposOpera","moblOidReclAnte", false);','focalizaComboDependence("recTiposOpera","moblOidReclAnte", false);','focalizaComboDependence("recTiposOpera","moblOidReclAnte", true);','focalizaComboDependence("recTiposOpera","moblOidReclAnte", true);','focalizaComboDependence("recTiposOpera","moblOidReclAnte", true);'],[12,'focalizaComboDependence("recTiposOpera","moblOidBloqImpo", false);','focalizaComboDependence("recTiposOpera","moblOidBloqImpo", false);','focalizaComboDependence("recTiposOpera","moblOidBloqImpo", false);','focalizaComboDependence("recTiposOpera","moblOidBloqImpo", true);','focalizaComboDependence("recTiposOpera","moblOidBloqImpo", true);','focalizaComboDependence("recTiposOpera","moblOidBloqImpo", true);'],[13,'focalizaComboDependence("recTiposOpera","moblOidBloqUnid", false);','focalizaComboDependence("recTiposOpera","moblOidBloqUnid", false);','focalizaComboDependence("recTiposOpera","moblOidBloqUnid", false);','focalizaComboDependence("recTiposOpera","moblOidBloqUnid", true);','focalizaComboDependence("recTiposOpera","moblOidBloqUnid", true);','focalizaComboDependence("recTiposOpera","moblOidBloqUnid", true);']]);

//Vector con acciones de foco para la pantalla de modificaci�n.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acci�n a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[2,'focaliza("recTiposOperaFrm.valTipoOper");','focaliza("recTiposOperaFrm.valTipoOper");','focaliza("recTiposOperaFrm.valTipoOper");','focaliza("recTiposOperaFrm.valTipoOper");','focaliza("recTiposOperaFrm.valTipoOper");','focaliza("recTiposOperaFrm.valTipoOper");'],[3,'focaliza("recTiposOperaFrm.indCampRefeUnic");','focaliza("recTiposOperaFrm.indCampRefeUnic");','focaliza("recTiposOperaFrm.indCampRefeUnic");','focaliza("recTiposOperaFrm.indCampRefeUnic");','focaliza("recTiposOperaFrm.indCampRefeUnic");','focaliza("recTiposOperaFrm.indCampRefeUnic");'],[4,'focaliza("recTiposOperaFrm.numDiasHaciAtra");','focaliza("recTiposOperaFrm.numDiasHaciAtra");','focaliza("recTiposOperaFrm.numDiasHaciAtra");','focaliza("recTiposOperaFrm.numDiasHaciAtra");','focaliza("recTiposOperaFrm.numDiasHaciAtra");','focaliza("recTiposOperaFrm.numDiasHaciAtra");'],[5,'focaliza("recTiposOperaFrm.valInfoEbelNoti");','focaliza("recTiposOperaFrm.valInfoEbelNoti");','focaliza("recTiposOperaFrm.valInfoEbelNoti");','focaliza("recTiposOperaFrm.valInfoEbelNoti");','focaliza("recTiposOperaFrm.valInfoEbelNoti");','focaliza("recTiposOperaFrm.valInfoEbelNoti");'],[6,'focaliza("recTiposOperaFrm.indDevuEstaFact");','focaliza("recTiposOperaFrm.indDevuEstaFact");','focaliza("recTiposOperaFrm.indDevuEstaFact");','focaliza("recTiposOperaFrm.indDevuEstaFact");','focaliza("recTiposOperaFrm.indDevuEstaFact");','focaliza("recTiposOperaFrm.indDevuEstaFact");'],[7,'focaliza("recTiposOperaFrm.indEnviEstaFact");','focaliza("recTiposOperaFrm.indEnviEstaFact");','focaliza("recTiposOperaFrm.indEnviEstaFact");','focaliza("recTiposOperaFrm.indEnviEstaFact");','focaliza("recTiposOperaFrm.indEnviEstaFact");','focaliza("recTiposOperaFrm.indEnviEstaFact");'],[8,'focalizaComboDependence("recTiposOpera","ropeOidOper", false);','focalizaComboDependence("recTiposOpera","ropeOidOper", false);','focalizaComboDependence("recTiposOpera","ropeOidOper", false);','focalizaComboDependence("recTiposOpera","ropeOidOper", true);','focalizaComboDependence("recTiposOpera","ropeOidOper", true);','focalizaComboDependence("recTiposOpera","ropeOidOper", true);'],[9,'focalizaComboDependence("recTiposOpera","mrdbOidMotiRechDesb", false);','focalizaComboDependence("recTiposOpera","mrdbOidMotiRechDesb", false);','focalizaComboDependence("recTiposOpera","mrdbOidMotiRechDesb", false);','focalizaComboDependence("recTiposOpera","mrdbOidMotiRechDesb", true);','focalizaComboDependence("recTiposOpera","mrdbOidMotiRechDesb", true);','focalizaComboDependence("recTiposOpera","mrdbOidMotiRechDesb", true);'],[10,'focalizaComboDependence("recTiposOpera","moblOidBloqDife", false);','focalizaComboDependence("recTiposOpera","moblOidBloqDife", false);','focalizaComboDependence("recTiposOpera","moblOidBloqDife", false);','focalizaComboDependence("recTiposOpera","moblOidBloqDife", true);','focalizaComboDependence("recTiposOpera","moblOidBloqDife", true);','focalizaComboDependence("recTiposOpera","moblOidBloqDife", true);'],[11,'focalizaComboDependence("recTiposOpera","moblOidReclAnte", false);','focalizaComboDependence("recTiposOpera","moblOidReclAnte", false);','focalizaComboDependence("recTiposOpera","moblOidReclAnte", false);','focalizaComboDependence("recTiposOpera","moblOidReclAnte", true);','focalizaComboDependence("recTiposOpera","moblOidReclAnte", true);','focalizaComboDependence("recTiposOpera","moblOidReclAnte", true);'],[12,'focalizaComboDependence("recTiposOpera","moblOidBloqImpo", false);','focalizaComboDependence("recTiposOpera","moblOidBloqImpo", false);','focalizaComboDependence("recTiposOpera","moblOidBloqImpo", false);','focalizaComboDependence("recTiposOpera","moblOidBloqImpo", true);','focalizaComboDependence("recTiposOpera","moblOidBloqImpo", true);','focalizaComboDependence("recTiposOpera","moblOidBloqImpo", true);'],[13,'focalizaComboDependence("recTiposOpera","moblOidBloqUnid", false);','focalizaComboDependence("recTiposOpera","moblOidBloqUnid", false);','focalizaComboDependence("recTiposOpera","moblOidBloqUnid", false);','focalizaComboDependence("recTiposOpera","moblOidBloqUnid", true);','focalizaComboDependence("recTiposOpera","moblOidBloqUnid", true);','focalizaComboDependence("recTiposOpera","moblOidBloqUnid", true);']]);

//Creamos la informaci�n de las jerarqu�as de dependencias de combos (si existen)
//Para cada jerarqu�a de dependencia definimos un vector donde se defina la jerar�a
//La definici�n de la jerarqu�a consiste en definir para cada combo de la jerarqu�a cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de �l para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedar�an [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var ropeOidOperDependeceMap = new Vector();
ropeOidOperDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
ropeOidOperDependeceMap.agregar(['ropeOidOper', padresTmp, '', 'RecOpera']);
var mrdbOidMotiRechDesbDependeceMap = new Vector();
mrdbOidMotiRechDesbDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
mrdbOidMotiRechDesbDependeceMap.agregar(['mrdbOidMotiRechDesb', padresTmp, '', 'RecMotivRechaDesbl']);
var moblOidBloqDifeDependeceMap = new Vector();
moblOidBloqDifeDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
moblOidBloqDifeDependeceMap.agregar(['moblOidBloqDife', padresTmp, '', 'RecMotivBloqu']);
var moblOidReclAnteDependeceMap = new Vector();
moblOidReclAnteDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
moblOidReclAnteDependeceMap.agregar(['moblOidReclAnte', padresTmp, '', 'RecMotivBloqu']);
var moblOidBloqImpoDependeceMap = new Vector();
moblOidBloqImpoDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
moblOidBloqImpoDependeceMap.agregar(['moblOidBloqImpo', padresTmp, '', 'RecMotivBloqu']);
var moblOidBloqUnidDependeceMap = new Vector();
moblOidBloqUnidDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
moblOidBloqUnidDependeceMap.agregar(['moblOidBloqUnid', padresTmp, '', 'RecMotivBloqu']);

	
//variable conreferencia al obejto usado para devolver los resultados de una b�squeda lov
recTiposOperaLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se est� modifica para chequear
//que no se pierden datos
var recTiposOperaTmpUpdateValues;



//Funci�n ejecutada en el onload de la pagina
function recTiposOperaInitComponents(){
	//Deshabilitamos la limpieza gen�rica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del men� secundario
	configurarMenuSecundario('recTiposOperaFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operaci�n de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acci�n a realizar y llama a la funci�n correspondiente
	switch(get('recTiposOperaFrm.accion')){
		case "query": recTiposOperaQueryInitComponents(); break;
		case "view": recTiposOperaViewInitComponents(); break;
		case "create": recTiposOperaCreateInitComponents(); break;
		case "update": recTiposOperaUpdateInitComponents(); break;
		case "remove": recTiposOperaRemoveInitComponents(); break;
		case "lov": recTiposOperaLovInitComponents(); break;
	}
	//alert('accion :' + get('recTiposOperaFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('recTiposOperaFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('recTiposOpera')) recTiposOperaCmdRequery();
}

function recTiposOperaQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	focusFirstField('recTiposOperaFrm', true);	
}

function recTiposOperaViewInitComponents(){
	//Cargamos la descripci�n en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('recTiposOperaFrm', true);
}

function recTiposOperaCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('recTiposOperaFrm.valTipoOper','S', GestionarMensaje('RecTiposOpera.valTipoOper.requiered.message'));
	
	setMV('recTiposOperaFrm.indCampRefeUnic','S', GestionarMensaje('RecTiposOpera.indCampRefeUnic.requiered.message'));
	
	setMV('recTiposOperaFrm.ropeOidOper','S', GestionarMensaje('RecTiposOpera.ropeOidOper.requiered.message'));
	
	setMV('recTiposOperaFrm.mrdbOidMotiRechDesb','S', GestionarMensaje('RecTiposOpera.mrdbOidMotiRechDesb.requiered.message'));
	
	

	//Activamos el bot�n de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('recTiposOperaFrm', true);
}

function recTiposOperaUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de b�squeda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificaci�n
	if(get('recTiposOperaFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		recTiposOperaTmpUpdateValues = recTiposOperaBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('recTiposOperaFrm.valTipoOper','S', GestionarMensaje('RecTiposOpera.valTipoOper.requiered.message'));
		setMV('recTiposOperaFrm.indCampRefeUnic','S', GestionarMensaje('RecTiposOpera.indCampRefeUnic.requiered.message'));
		setMV('recTiposOperaFrm.ropeOidOper','S', GestionarMensaje('RecTiposOpera.ropeOidOper.requiered.message'));
		setMV('recTiposOperaFrm.mrdbOidMotiRechDesb','S', GestionarMensaje('RecTiposOpera.mrdbOidMotiRechDesb.requiered.message'));
		
			focusFirstFieldModify('recTiposOperaFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		
		focusFirstField('recTiposOperaFrm', true);
	}
	
	//Activamos el bot�n de guardar de la botonera solo si el origen es pagina
	if(get('recTiposOperaFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function recTiposOperaRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselecci�n a la lista de resultados
	recTiposOperaList.maxSel = -1;
	
	//Desctivamos el bot�n de borra de la botonera. Al realizar la query se activar�;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('recTiposOperaFrm', true);
}

function recTiposOperaLovInitComponents(){
	recTiposOperaLovReturnParameters = window.dialogArguments;
	
	focusFirstField('recTiposOperaFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad















//Funci�n que permite cargar los datos de un elemento de lov seleccionado
function recTiposOperaSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('recTiposOperaFrm.' + campo, id);
	set('recTiposOperaFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en di�logo de lov
function recTiposOperaLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	recTiposOperaLovReturnParameters.id = '';
	recTiposOperaLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function recTiposOperaLovSelectionAction(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(recTiposOperaList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habr� que limpiar para s�lo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = recTiposOperaList.codSeleccionados();
	var descripcion = recTiposOperaList.extraeDato(
		recTiposOperaList.codSeleccionados()[0], recTiposOperaChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	recTiposOperaLovReturnParameters.id = codigo;
	recTiposOperaLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con b�queda por intervalo


//Nos permite ejecutar la b�squeda
function recTiposOperaCmdQuery(pageNumber){
	//Llamamos a la validaci�n del formualrio. Si la validaci�n no es true finalizamos la ejecujcion
	var isValid = ValidaForm('recTiposOperaFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la funci�n
	var parametros = generateQuery();
	
	//A�adimos el pageCount y el pageSize a los par�metros de la b�squeda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los par�metros de la �ltima busqueda. (en la variable del formulario para el tema
	//de volver a la p�gina anterior)
	set('recTiposOperaFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "recTiposOperaList", "RecTiposOperaConectorTransactionQuery", 
		"result_ROWSET", parametros, "recTiposOperaPostQueryActions(datos);"]], "", "");	
}

function recTiposOperaCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la �ltima b�squeda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('recTiposOperaFrm.lastQueryToSession'));
	var i =0;
	set('recTiposOperaFrm.valTipoOper', paramsRequery.ij(i++));
	
	set('recTiposOperaFrm.indCampRefeUnic', paramsRequery.ij(i++));
	
	set('recTiposOperaFrm.numDiasHaciAtra', paramsRequery.ij(i++));
	
	set('recTiposOperaFrm.valInfoEbelNoti', paramsRequery.ij(i++));
	
	set('recTiposOperaFrm.indDevuEstaFact', paramsRequery.ij(i++));
	
	set('recTiposOperaFrm.indEnviEstaFact', paramsRequery.ij(i++));
	
	set('recTiposOperaFrm.ropeOidOper', [paramsRequery.ij(i++)]);
	
	set('recTiposOperaFrm.mrdbOidMotiRechDesb', [paramsRequery.ij(i++)]);
	
	set('recTiposOperaFrm.moblOidBloqDife', [paramsRequery.ij(i++)]);
	
	set('recTiposOperaFrm.moblOidReclAnte', [paramsRequery.ij(i++)]);
	
	set('recTiposOperaFrm.moblOidBloqImpo', [paramsRequery.ij(i++)]);
	
	set('recTiposOperaFrm.moblOidBloqUnid', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la p�gina de busqueda como la actual
	recTiposOperaPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	recTiposOperaCmdQuery(recTiposOperaPageCount);
}

function recTiposOperaFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	recTiposOperaPageCount = 1;
	recTiposOperaCmdQuery(recTiposOperaPageCount);
}

function recTiposOperaPreviousPage(){
	//Si los par�metros de busqueda han cambiado hacemos una b�squeda de firstpage
	if(generateQuery() != recTiposOperaLastQuery){
		recTiposOperaFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	recTiposOperaPageCount--;
	recTiposOperaCmdQuery(recTiposOperaPageCount);
}

function recTiposOperaNextPage(){
	//Si los par�metros de busqueda han cambiado hacemos una b�squeda de firstpage
	if(generateQuery() != recTiposOperaLastQuery){
		recTiposOperaFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	recTiposOperaPageCount++;
	recTiposOperaCmdQuery(recTiposOperaPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function recTiposOperaPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('recTiposOperaListLayer', 'O');
		visibilidad('recTiposOperaListButtonsLayer', 'O');
		if(get('recTiposOperaFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los par�metros de la �ltima busqueda. (en la variable javascript)
	recTiposOperaLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripci�n en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminaci�n)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:recTiposOperaViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, recTiposOperaChoiceColumn) + "</A>",
			i, recTiposOperaChoiceColumn);
	}*/

	//Filtramos el resultado para coger s�lo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	recTiposOperaList.setDatos(datosTmp.filtrar([0,1,2,3,4,5,6,7,8,9,10,11,12],'*'));
	
	//La �ltima fila de datos representa a los timestamps que debemos guardarlos
	recTiposOperaTimeStamps = datosTmp.filtrar([13],'*');
	
	//SI hay mas paginas reigistramos que es as� e eliminamos el �ltimo registro
	if(datosTmp.longitud > mmgPageSize){
		recTiposOperaMorePagesFlag = true;
		recTiposOperaList.eliminar(mmgPageSize, 1);
	}else{
		recTiposOperaMorePagesFlag = false;
	}
	
	//Activamos el bot�n de borrar si estamos en la acci�n
	if(get('recTiposOperaFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('recTiposOperaListLayer', 'V');
	visibilidad('recTiposOperaListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('recTiposOperaList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	recTiposOperaList.display();
	
	//Actualizamos el estado de los botones 
	if(recTiposOperaMorePagesFlag){
		set_estado_botonera('recTiposOperaPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('recTiposOperaPaginationButtonBar',
			3,"inactivo");
	}
	if(recTiposOperaPageCount > 1){
		set_estado_botonera('recTiposOperaPaginationButtonBar',
			2,"activo");
		set_estado_botonera('recTiposOperaPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('recTiposOperaPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('recTiposOperaPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function recTiposOperaUpdateSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(recTiposOperaList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('recTiposOperaFrm.idSelection', recTiposOperaList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificaci�n
	var validacion = ValidaForm('recTiposOperaFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = recTiposOperaList.codSeleccionados()[0];
		parametros["previousAction"] = get('recTiposOperaFrm.accion');
		parametros["accion"] = get('recTiposOperaFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('RecTiposOperaLPStartUp', get('recTiposOperaFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) recTiposOperaCmdRequery();
	}
}

function recTiposOperaRemoveSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(recTiposOperaList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmaci�n para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = recTiposOperaList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('recTiposOperaFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(recTiposOperaList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += recTiposOperaTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('recTiposOperaFrm.timestamp', timestamps);


	recTiposOperaFrm.oculto='S';
	envia('recTiposOperaFrm');
	recTiposOperaFrm.oculto='N';
}

function recTiposOperaViewSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(recTiposOperaList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	recTiposOperaViewDetail(recTiposOperaList.codSeleccionados()[0]);
}

//Esta funci�n nos permite abrir un dialogo que permite visualiza un registro determianado
function recTiposOperaViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acci�n, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('recTiposOperaFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('RecTiposOperaLPStartUp', 'view', parametros, null, null);
}

//Funci�n ejecutada cuando se pulsa el bot�n de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripci�n del idioma por defecto
	//intreoducido directamente a trav�s del widget. Esto se pone debio a que la tecla r�pida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	
	
	
	
	
	
	
	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validaci�n los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('recTiposOperaFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	if(validacion){
		recTiposOperaFrm.oculto='S';
		envia('recTiposOperaFrm');
		recTiposOperaFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que ten�a el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarqu�a de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('recTiposOperaFrm.ropeOidOper').toString() == ''){
		set('recTiposOperaFrm.ropeOidOper', []);
		mmgResetCombosOnCascade('ropeOidOper', 'ropeOidOper', 'recTiposOpera');
		
	}
	if(get('recTiposOperaFrm.mrdbOidMotiRechDesb').toString() == ''){
		set('recTiposOperaFrm.mrdbOidMotiRechDesb', []);
		mmgResetCombosOnCascade('mrdbOidMotiRechDesb', 'mrdbOidMotiRechDesb', 'recTiposOpera');
		
	}
	if(get('recTiposOperaFrm.moblOidBloqDife').toString() == ''){
		set('recTiposOperaFrm.moblOidBloqDife', []);
		mmgResetCombosOnCascade('moblOidBloqDife', 'moblOidBloqDife', 'recTiposOpera');
		
	}
	if(get('recTiposOperaFrm.moblOidReclAnte').toString() == ''){
		set('recTiposOperaFrm.moblOidReclAnte', []);
		mmgResetCombosOnCascade('moblOidReclAnte', 'moblOidReclAnte', 'recTiposOpera');
		
	}
	if(get('recTiposOperaFrm.moblOidBloqImpo').toString() == ''){
		set('recTiposOperaFrm.moblOidBloqImpo', []);
		mmgResetCombosOnCascade('moblOidBloqImpo', 'moblOidBloqImpo', 'recTiposOpera');
		
	}
	if(get('recTiposOperaFrm.moblOidBloqUnid').toString() == ''){
		set('recTiposOperaFrm.moblOidBloqUnid', []);
		mmgResetCombosOnCascade('moblOidBloqUnid', 'moblOidBloqUnid', 'recTiposOpera');
		
	}
	
	
}

//Funci�n que se ejecuta cuando en la botonera se pulsa el bot�n de eliminar
function Borrar(){
	recTiposOperaRemoveSelection();
}

//Funci�n que se ejecuta cuando en la botonera se pulsa el bot�n de volver
function Volver(){
	var accionTmp = get('recTiposOperaFrm.accion');
	var origenTmp = get('recTiposOperaFrm.origen');
	
	//Si estamo en modo de view el volver hacia atr�s significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atr�s
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(recTiposOperaBuildUpdateRecordString() != recTiposOperaTmpUpdateValues){
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
	document.all.recTiposOperaListLayer.style.display='none';
	document.all.recTiposOperaListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.recTiposOperaListLayer.style.display='';
	document.all.recTiposOperaListButtonsLayer.style.display='';
}

//Esta funci�n genera los parametros de la b�squeda
function generateQuery(){
	//Determinamos los valores para realziar la b�squeda
	jsRecTiposOperaValTipoOper = get('recTiposOperaFrm.valTipoOper').toString();
	jsRecTiposOperaIndCampRefeUnic = get('recTiposOperaFrm.indCampRefeUnic').toString();
	jsRecTiposOperaNumDiasHaciAtra = get('recTiposOperaFrm.numDiasHaciAtra').toString();
	jsRecTiposOperaValInfoEbelNoti = get('recTiposOperaFrm.valInfoEbelNoti').toString();
	jsRecTiposOperaIndDevuEstaFact = get('recTiposOperaFrm.indDevuEstaFact').toString();
	jsRecTiposOperaIndEnviEstaFact = get('recTiposOperaFrm.indEnviEstaFact').toString();
	jsRecTiposOperaRopeOidOper = get('recTiposOperaFrm.ropeOidOper')[0];
	jsRecTiposOperaMrdbOidMotiRechDesb = get('recTiposOperaFrm.mrdbOidMotiRechDesb')[0];
	jsRecTiposOperaMoblOidBloqDife = get('recTiposOperaFrm.moblOidBloqDife')[0];
	jsRecTiposOperaMoblOidReclAnte = get('recTiposOperaFrm.moblOidReclAnte')[0];
	jsRecTiposOperaMoblOidBloqImpo = get('recTiposOperaFrm.moblOidBloqImpo')[0];
	jsRecTiposOperaMoblOidBloqUnid = get('recTiposOperaFrm.moblOidBloqUnid')[0];
	
	
	var parametros = "";
	parametros += jsRecTiposOperaValTipoOper + "|";
	parametros += jsRecTiposOperaIndCampRefeUnic + "|";
	parametros += jsRecTiposOperaNumDiasHaciAtra + "|";
	parametros += jsRecTiposOperaValInfoEbelNoti + "|";
	parametros += jsRecTiposOperaIndDevuEstaFact + "|";
	parametros += jsRecTiposOperaIndEnviEstaFact + "|";
	parametros += jsRecTiposOperaRopeOidOper + "|";
	parametros += jsRecTiposOperaMrdbOidMotiRechDesb + "|";
	parametros += jsRecTiposOperaMoblOidBloqDife + "|";
	parametros += jsRecTiposOperaMoblOidReclAnte + "|";
	parametros += jsRecTiposOperaMoblOidBloqImpo + "|";
	parametros += jsRecTiposOperaMoblOidBloqUnid + "|";
	
	return parametros;
}

//Esta funci�n nos permite obteber los valore del formulario cuando est� en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function recTiposOperaBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsRecTiposOperaValTipoOper + "|";
	parametros += jsRecTiposOperaIndCampRefeUnic + "|";
	parametros += jsRecTiposOperaNumDiasHaciAtra + "|";
	parametros += jsRecTiposOperaValInfoEbelNoti + "|";
	parametros += jsRecTiposOperaIndDevuEstaFact + "|";
	parametros += jsRecTiposOperaIndEnviEstaFact + "|";
	parametros += jsRecTiposOperaRopeOidOper + "|";
	parametros += jsRecTiposOperaMrdbOidMotiRechDesb + "|";
	parametros += jsRecTiposOperaMoblOidBloqDife + "|";
	parametros += jsRecTiposOperaMoblOidReclAnte + "|";
	parametros += jsRecTiposOperaMoblOidBloqImpo + "|";
	parametros += jsRecTiposOperaMoblOidBloqUnid + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('recTiposOperaFrm.accion'), 
		get('recTiposOperaFrm.origen'));
	
	jsRecTiposOperaId = get('recTiposOperaFrm.id').toString();
	jsRecTiposOperaValTipoOper = get('recTiposOperaFrm.valTipoOper').toString();
	jsRecTiposOperaIndCampRefeUnic = get('recTiposOperaFrm.indCampRefeUnic').toString();
	jsRecTiposOperaNumDiasHaciAtra = get('recTiposOperaFrm.numDiasHaciAtra').toString();
	jsRecTiposOperaValInfoEbelNoti = get('recTiposOperaFrm.valInfoEbelNoti').toString();
	jsRecTiposOperaIndDevuEstaFact = get('recTiposOperaFrm.indDevuEstaFact').toString();
	jsRecTiposOperaIndEnviEstaFact = get('recTiposOperaFrm.indEnviEstaFact').toString();
	jsRecTiposOperaRopeOidOper = get('recTiposOperaFrm.ropeOidOper')[0];
	jsRecTiposOperaMrdbOidMotiRechDesb = get('recTiposOperaFrm.mrdbOidMotiRechDesb')[0];
	jsRecTiposOperaMoblOidBloqDife = get('recTiposOperaFrm.moblOidBloqDife')[0];
	jsRecTiposOperaMoblOidReclAnte = get('recTiposOperaFrm.moblOidReclAnte')[0];
	jsRecTiposOperaMoblOidBloqImpo = get('recTiposOperaFrm.moblOidBloqImpo')[0];
	jsRecTiposOperaMoblOidBloqUnid = get('recTiposOperaFrm.moblOidBloqUnid')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('recTiposOperaFrm.accion'), 
		get('recTiposOperaFrm.origen'));


	set('recTiposOperaFrm.id', jsRecTiposOperaId);
	set('recTiposOperaFrm.valTipoOper', jsRecTiposOperaValTipoOper);
	set('recTiposOperaFrm.indCampRefeUnic', jsRecTiposOperaIndCampRefeUnic);
	set('recTiposOperaFrm.numDiasHaciAtra', jsRecTiposOperaNumDiasHaciAtra);
	set('recTiposOperaFrm.valInfoEbelNoti', jsRecTiposOperaValInfoEbelNoti);
	set('recTiposOperaFrm.indDevuEstaFact', jsRecTiposOperaIndDevuEstaFact);
	set('recTiposOperaFrm.indEnviEstaFact', jsRecTiposOperaIndEnviEstaFact);
	set('recTiposOperaFrm.ropeOidOper', [jsRecTiposOperaRopeOidOper]);
	set('recTiposOperaFrm.mrdbOidMotiRechDesb', [jsRecTiposOperaMrdbOidMotiRechDesb]);
	set('recTiposOperaFrm.moblOidBloqDife', [jsRecTiposOperaMoblOidBloqDife]);
	set('recTiposOperaFrm.moblOidReclAnte', [jsRecTiposOperaMoblOidReclAnte]);
	set('recTiposOperaFrm.moblOidBloqImpo', [jsRecTiposOperaMoblOidBloqImpo]);
	set('recTiposOperaFrm.moblOidBloqUnid', [jsRecTiposOperaMoblOidBloqUnid]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la b�squeda
	jsRecTiposOperaValTipoOper = '';
	jsRecTiposOperaIndCampRefeUnic = '';
	jsRecTiposOperaNumDiasHaciAtra = '';
	jsRecTiposOperaValInfoEbelNoti = '';
	jsRecTiposOperaIndDevuEstaFact = '';
	jsRecTiposOperaIndEnviEstaFact = '';
	jsRecTiposOperaRopeOidOper = '';
	jsRecTiposOperaMrdbOidMotiRechDesb = '';
	jsRecTiposOperaMoblOidBloqDife = '';
	jsRecTiposOperaMoblOidReclAnte = '';
	jsRecTiposOperaMoblOidBloqImpo = '';
	jsRecTiposOperaMoblOidBloqUnid = '';
	
}

//Permite disprar una acci�n para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('recTiposOperaFrm.errCodigo', errorCode);
	set('recTiposOperaFrm.errDescripcion', description);
	set('recTiposOperaFrm.errSeverity', severity);
	fMostrarMensajeError();
}
