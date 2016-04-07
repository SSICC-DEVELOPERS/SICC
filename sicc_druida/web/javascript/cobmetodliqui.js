

/*
    INDRA/CAR/mmg
    $Id: cobmetodliqui.js,v 1.1 2009/12/03 19:02:28 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsCobMetodLiquiId = "";
var jsCobMetodLiquiCodMetoLiqu = "";
var jsCobMetodLiquiValDescMetoLiqu = "";
var jsCobMetodLiquiIndLiqu = "";
var jsCobMetodLiquiIndLiquGrupUsua = "";
var jsCobMetodLiquiValObse = "";
var jsCobMetodLiquiPaisOidPais = "";
var jsCobMetodLiquiBaesOidBaseEsca = "";

//Variables de paginacion, 
var cobMetodLiquiPageCount = 1;

//Varible de columna que representa el campo de choice
var cobMetodLiquiChoiceColumn = 1;

//Flag de siguiente pagina;
var cobMetodLiquiMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var cobMetodLiquiTimeStamps = null;

//Tama�os del formulario
var sizeFormQuery = 315;
var sizeFormView = 221;
var sizeFormUpdate = 309;

//Ultima busqueda realizada
var cobMetodLiquiLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acci�n a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("cobMetodLiquiFrm.codMetoLiqu");','focaliza("cobMetodLiquiFrm.codMetoLiqu");','focaliza("cobMetodLiquiFrm.codMetoLiqu");','focaliza("cobMetodLiquiFrm.codMetoLiqu");','focaliza("cobMetodLiquiFrm.codMetoLiqu");','focaliza("cobMetodLiquiFrm.codMetoLiqu");'],[3,'focaliza("cobMetodLiquiFrm.valDescMetoLiqu");','focaliza("cobMetodLiquiFrm.valDescMetoLiqu");','focaliza("cobMetodLiquiFrm.valDescMetoLiqu");','focaliza("cobMetodLiquiFrm.valDescMetoLiqu");','focaliza("cobMetodLiquiFrm.valDescMetoLiqu");','focaliza("cobMetodLiquiFrm.valDescMetoLiqu");'],[4,'focaliza("cobMetodLiquiFrm.indLiqu");','focaliza("cobMetodLiquiFrm.indLiqu");','focaliza("cobMetodLiquiFrm.indLiqu");','focaliza("cobMetodLiquiFrm.indLiqu");','focaliza("cobMetodLiquiFrm.indLiqu");','focaliza("cobMetodLiquiFrm.indLiqu");'],[5,'focaliza("cobMetodLiquiFrm.indLiquGrupUsua");','focaliza("cobMetodLiquiFrm.indLiquGrupUsua");','focaliza("cobMetodLiquiFrm.indLiquGrupUsua");','focaliza("cobMetodLiquiFrm.indLiquGrupUsua");','focaliza("cobMetodLiquiFrm.indLiquGrupUsua");','focaliza("cobMetodLiquiFrm.indLiquGrupUsua");'],[6,'focaliza("cobMetodLiquiFrm.valObse");','focaliza("cobMetodLiquiFrm.valObse");','focaliza("cobMetodLiquiFrm.valObse");','focaliza("cobMetodLiquiFrm.valObse");','focaliza("cobMetodLiquiFrm.valObse");','focaliza("cobMetodLiquiFrm.valObse");'],[7,'','','','','',''],[8,'focalizaComboDependence("cobMetodLiqui","baesOidBaseEsca", false);','focalizaComboDependence("cobMetodLiqui","baesOidBaseEsca", false);','focalizaComboDependence("cobMetodLiqui","baesOidBaseEsca", false);','focalizaComboDependence("cobMetodLiqui","baesOidBaseEsca", true);','focalizaComboDependence("cobMetodLiqui","baesOidBaseEsca", true);','focalizaComboDependence("cobMetodLiqui","baesOidBaseEsca", true);']]);

//Vector con acciones de foco para la pantalla de modificaci�n.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acci�n a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[3,'focaliza("cobMetodLiquiFrm.valDescMetoLiqu");','focaliza("cobMetodLiquiFrm.valDescMetoLiqu");','focaliza("cobMetodLiquiFrm.valDescMetoLiqu");','focaliza("cobMetodLiquiFrm.valDescMetoLiqu");','focaliza("cobMetodLiquiFrm.valDescMetoLiqu");','focaliza("cobMetodLiquiFrm.valDescMetoLiqu");'],[4,'focaliza("cobMetodLiquiFrm.indLiqu");','focaliza("cobMetodLiquiFrm.indLiqu");','focaliza("cobMetodLiquiFrm.indLiqu");','focaliza("cobMetodLiquiFrm.indLiqu");','focaliza("cobMetodLiquiFrm.indLiqu");','focaliza("cobMetodLiquiFrm.indLiqu");'],[5,'focaliza("cobMetodLiquiFrm.indLiquGrupUsua");','focaliza("cobMetodLiquiFrm.indLiquGrupUsua");','focaliza("cobMetodLiquiFrm.indLiquGrupUsua");','focaliza("cobMetodLiquiFrm.indLiquGrupUsua");','focaliza("cobMetodLiquiFrm.indLiquGrupUsua");','focaliza("cobMetodLiquiFrm.indLiquGrupUsua");'],[6,'focaliza("cobMetodLiquiFrm.valObse");','focaliza("cobMetodLiquiFrm.valObse");','focaliza("cobMetodLiquiFrm.valObse");','focaliza("cobMetodLiquiFrm.valObse");','focaliza("cobMetodLiquiFrm.valObse");','focaliza("cobMetodLiquiFrm.valObse");'],[7,'','','','','',''],[8,'focalizaComboDependence("cobMetodLiqui","baesOidBaseEsca", false);','focalizaComboDependence("cobMetodLiqui","baesOidBaseEsca", false);','focalizaComboDependence("cobMetodLiqui","baesOidBaseEsca", false);','focalizaComboDependence("cobMetodLiqui","baesOidBaseEsca", true);','focalizaComboDependence("cobMetodLiqui","baesOidBaseEsca", true);','focalizaComboDependence("cobMetodLiqui","baesOidBaseEsca", true);']]);

//Creamos la informaci�n de las jerarqu�as de dependencias de combos (si existen)
//Para cada jerarqu�a de dependencia definimos un vector donde se defina la jerar�a
//La definici�n de la jerarqu�a consiste en definir para cada combo de la jerarqu�a cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de �l para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedar�an [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var paisOidPaisDependeceMap = new Vector();
paisOidPaisDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais', padresTmp, '', 'SegPaisView']);
var baesOidBaseEscaDependeceMap = new Vector();
baesOidBaseEscaDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
baesOidBaseEscaDependeceMap.agregar(['baesOidBaseEsca', padresTmp, '', 'CobBaseEscal']);

	
//variable conreferencia al obejto usado para devolver los resultados de una b�squeda lov
cobMetodLiquiLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se est� modifica para chequear
//que no se pierden datos
var cobMetodLiquiTmpUpdateValues;



//Funci�n ejecutada en el onload de la pagina
function cobMetodLiquiInitComponents(){
	//Deshabilitamos la limpieza gen�rica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del men� secundario
	configurarMenuSecundario('cobMetodLiquiFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operaci�n de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acci�n a realizar y llama a la funci�n correspondiente
	switch(get('cobMetodLiquiFrm.accion')){
		case "query": cobMetodLiquiQueryInitComponents(); break;
		case "view": cobMetodLiquiViewInitComponents(); break;
		case "create": cobMetodLiquiCreateInitComponents(); break;
		case "update": cobMetodLiquiUpdateInitComponents(); break;
		case "remove": cobMetodLiquiRemoveInitComponents(); break;
		case "lov": cobMetodLiquiLovInitComponents(); break;
	}
	//alert('accion :' + get('cobMetodLiquiFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('cobMetodLiquiFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('cobMetodLiqui')) cobMetodLiquiCmdRequery();
}

function cobMetodLiquiQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	focusFirstField('cobMetodLiquiFrm', true);	
}

function cobMetodLiquiViewInitComponents(){
	//Cargamos la descripci�n en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	//Establecemos el valor de los radiobuttons
		set('cobMetodLiquiFrm.indLiqu', get('cobMetodLiquiFrm.indLiquCheckValue'));
		set('cobMetodLiquiFrm.indLiquGrupUsua', get('cobMetodLiquiFrm.indLiquGrupUsuaCheckValue'));
		
	focusFirstField('cobMetodLiquiFrm', true);
}

function cobMetodLiquiCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('cobMetodLiquiFrm.codMetoLiqu','S', GestionarMensaje('CobMetodLiqui.codMetoLiqu.requiered.message'));
	
	setMV('cobMetodLiquiFrm.valDescMetoLiqu','S', GestionarMensaje('CobMetodLiqui.valDescMetoLiqu.requiered.message'));
	
	setMV('cobMetodLiquiFrm.indLiqu','S', GestionarMensaje('CobMetodLiqui.indLiqu.requiered.message'));
	
	setMV('cobMetodLiquiFrm.indLiquGrupUsua','S', GestionarMensaje('CobMetodLiqui.indLiquGrupUsua.requiered.message'));
	
	setMV('cobMetodLiquiFrm.baesOidBaseEsca','S', GestionarMensaje('CobMetodLiqui.baesOidBaseEsca.requiered.message'));
	
	

	//Activamos el bot�n de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('cobMetodLiquiFrm', true);
}

function cobMetodLiquiUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de b�squeda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificaci�n
	if(get('cobMetodLiquiFrm.origen') == "pagina"){
		

		//Establecemos el valor de los radiobuttons
			set('cobMetodLiquiFrm.indLiqu', get('cobMetodLiquiFrm.indLiquCheckValue'));
			set('cobMetodLiquiFrm.indLiquGrupUsua', get('cobMetodLiquiFrm.indLiquGrupUsuaCheckValue'));
			

		//Registramos el valor del elemento que estamos modificando
		cobMetodLiquiTmpUpdateValues = cobMetodLiquiBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('cobMetodLiquiFrm.codMetoLiqu','S', GestionarMensaje('CobMetodLiqui.codMetoLiqu.requiered.message'));
		setMV('cobMetodLiquiFrm.valDescMetoLiqu','S', GestionarMensaje('CobMetodLiqui.valDescMetoLiqu.requiered.message'));
		setMV('cobMetodLiquiFrm.indLiqu','S', GestionarMensaje('CobMetodLiqui.indLiqu.requiered.message'));
		setMV('cobMetodLiquiFrm.indLiquGrupUsua','S', GestionarMensaje('CobMetodLiqui.indLiquGrupUsua.requiered.message'));
		setMV('cobMetodLiquiFrm.baesOidBaseEsca','S', GestionarMensaje('CobMetodLiqui.baesOidBaseEsca.requiered.message'));
		
			focusFirstFieldModify('cobMetodLiquiFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		focusFirstField('cobMetodLiquiFrm', true);
	}
	
	//Activamos el bot�n de guardar de la botonera solo si el origen es pagina
	if(get('cobMetodLiquiFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function cobMetodLiquiRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselecci�n a la lista de resultados
	cobMetodLiquiList.maxSel = -1;
	
	//Desctivamos el bot�n de borra de la botonera. Al realizar la query se activar�;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('cobMetodLiquiFrm', true);
}

function cobMetodLiquiLovInitComponents(){
	cobMetodLiquiLovReturnParameters = window.dialogArguments;
	
	focusFirstField('cobMetodLiquiFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad










//Funci�n que permite cargar los datos de un elemento de lov seleccionado
function cobMetodLiquiSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('cobMetodLiquiFrm.' + campo, id);
	set('cobMetodLiquiFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en di�logo de lov
function cobMetodLiquiLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	cobMetodLiquiLovReturnParameters.id = '';
	cobMetodLiquiLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function cobMetodLiquiLovSelectionAction(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(cobMetodLiquiList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habr� que limpiar para s�lo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = cobMetodLiquiList.codSeleccionados();
	var descripcion = cobMetodLiquiList.extraeDato(
		cobMetodLiquiList.codSeleccionados()[0], cobMetodLiquiChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	cobMetodLiquiLovReturnParameters.id = codigo;
	cobMetodLiquiLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con b�queda por intervalo


//Nos permite ejecutar la b�squeda
function cobMetodLiquiCmdQuery(pageNumber){
	//Llamamos a la validaci�n del formualrio. Si la validaci�n no es true finalizamos la ejecujcion
	var isValid = ValidaForm('cobMetodLiquiFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la funci�n
	var parametros = generateQuery();
	
	//A�adimos el pageCount y el pageSize a los par�metros de la b�squeda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los par�metros de la �ltima busqueda. (en la variable del formulario para el tema
	//de volver a la p�gina anterior)
	set('cobMetodLiquiFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "cobMetodLiquiList", "CobMetodLiquiConectorTransactionQuery", 
		"result_ROWSET", parametros, "cobMetodLiquiPostQueryActions(datos);"]], "", "");	
}

function cobMetodLiquiCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la �ltima b�squeda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('cobMetodLiquiFrm.lastQueryToSession'));
	var i =0;
	set('cobMetodLiquiFrm.codMetoLiqu', paramsRequery.ij(i++));
	
	set('cobMetodLiquiFrm.valDescMetoLiqu', paramsRequery.ij(i++));
	
	set('cobMetodLiquiFrm.indLiqu', paramsRequery.ij(i++));
	
	set('cobMetodLiquiFrm.indLiquGrupUsua', paramsRequery.ij(i++));
	
	set('cobMetodLiquiFrm.valObse', paramsRequery.ij(i++));
	
	set('cobMetodLiquiFrm.baesOidBaseEsca', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la p�gina de busqueda como la actual
	cobMetodLiquiPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	cobMetodLiquiCmdQuery(cobMetodLiquiPageCount);
}

function cobMetodLiquiFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	cobMetodLiquiPageCount = 1;
	cobMetodLiquiCmdQuery(cobMetodLiquiPageCount);
}

function cobMetodLiquiPreviousPage(){
	//Si los par�metros de busqueda han cambiado hacemos una b�squeda de firstpage
	if(generateQuery() != cobMetodLiquiLastQuery){
		cobMetodLiquiFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	cobMetodLiquiPageCount--;
	cobMetodLiquiCmdQuery(cobMetodLiquiPageCount);
}

function cobMetodLiquiNextPage(){
	//Si los par�metros de busqueda han cambiado hacemos una b�squeda de firstpage
	if(generateQuery() != cobMetodLiquiLastQuery){
		cobMetodLiquiFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	cobMetodLiquiPageCount++;
	cobMetodLiquiCmdQuery(cobMetodLiquiPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function cobMetodLiquiPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('cobMetodLiquiListLayer', 'O');
		visibilidad('cobMetodLiquiListButtonsLayer', 'O');
		if(get('cobMetodLiquiFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los par�metros de la �ltima busqueda. (en la variable javascript)
	cobMetodLiquiLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripci�n en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminaci�n)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:cobMetodLiquiViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, cobMetodLiquiChoiceColumn) + "</A>",
			i, cobMetodLiquiChoiceColumn);
	}*/

	//Filtramos el resultado para coger s�lo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	cobMetodLiquiList.setDatos(datosTmp.filtrar([0,1,2],'*'));
	
	//La �ltima fila de datos representa a los timestamps que debemos guardarlos
	cobMetodLiquiTimeStamps = datosTmp.filtrar([3],'*');
	
	//SI hay mas paginas reigistramos que es as� e eliminamos el �ltimo registro
	if(datosTmp.longitud > mmgPageSize){
		cobMetodLiquiMorePagesFlag = true;
		cobMetodLiquiList.eliminar(mmgPageSize, 1);
	}else{
		cobMetodLiquiMorePagesFlag = false;
	}
	
	//Activamos el bot�n de borrar si estamos en la acci�n
	if(get('cobMetodLiquiFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('cobMetodLiquiListLayer', 'V');
	visibilidad('cobMetodLiquiListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('cobMetodLiquiList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	cobMetodLiquiList.display();
	
	//Actualizamos el estado de los botones 
	if(cobMetodLiquiMorePagesFlag){
		set_estado_botonera('cobMetodLiquiPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('cobMetodLiquiPaginationButtonBar',
			3,"inactivo");
	}
	if(cobMetodLiquiPageCount > 1){
		set_estado_botonera('cobMetodLiquiPaginationButtonBar',
			2,"activo");
		set_estado_botonera('cobMetodLiquiPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('cobMetodLiquiPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('cobMetodLiquiPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function cobMetodLiquiUpdateSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(cobMetodLiquiList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('cobMetodLiquiFrm.idSelection', cobMetodLiquiList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificaci�n
	var validacion = ValidaForm('cobMetodLiquiFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = cobMetodLiquiList.codSeleccionados()[0];
		parametros["previousAction"] = get('cobMetodLiquiFrm.accion');
		parametros["accion"] = get('cobMetodLiquiFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('CobMetodLiquiLPStartUp', get('cobMetodLiquiFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) cobMetodLiquiCmdRequery();
	}
}

function cobMetodLiquiRemoveSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(cobMetodLiquiList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmaci�n para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = cobMetodLiquiList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('cobMetodLiquiFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(cobMetodLiquiList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += cobMetodLiquiTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('cobMetodLiquiFrm.timestamp', timestamps);


	cobMetodLiquiFrm.oculto='S';
	envia('cobMetodLiquiFrm');
	cobMetodLiquiFrm.oculto='N';
}

function cobMetodLiquiViewSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(cobMetodLiquiList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	cobMetodLiquiViewDetail(cobMetodLiquiList.codSeleccionados()[0]);
}

//Esta funci�n nos permite abrir un dialogo que permite visualiza un registro determianado
function cobMetodLiquiViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acci�n, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('cobMetodLiquiFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('CobMetodLiquiLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('cobMetodLiquiFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
	
		
	
	if(validacion){
		cobMetodLiquiFrm.oculto='S';
		envia('cobMetodLiquiFrm');
		cobMetodLiquiFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que ten�a el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarqu�a de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('cobMetodLiquiFrm.paisOidPais').toString() == ''){
		set('cobMetodLiquiFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'cobMetodLiqui');
		
	}
	if(get('cobMetodLiquiFrm.baesOidBaseEsca').toString() == ''){
		set('cobMetodLiquiFrm.baesOidBaseEsca', []);
		mmgResetCombosOnCascade('baesOidBaseEsca', 'baesOidBaseEsca', 'cobMetodLiqui');
		
	}
	
	
}

//Funci�n que se ejecuta cuando en la botonera se pulsa el bot�n de eliminar
function Borrar(){
	cobMetodLiquiRemoveSelection();
}

//Funci�n que se ejecuta cuando en la botonera se pulsa el bot�n de volver
function Volver(){
	var accionTmp = get('cobMetodLiquiFrm.accion');
	var origenTmp = get('cobMetodLiquiFrm.origen');
	
	//Si estamo en modo de view el volver hacia atr�s significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atr�s
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(cobMetodLiquiBuildUpdateRecordString() != cobMetodLiquiTmpUpdateValues){
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
	document.all.cobMetodLiquiListLayer.style.display='none';
	document.all.cobMetodLiquiListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.cobMetodLiquiListLayer.style.display='';
	document.all.cobMetodLiquiListButtonsLayer.style.display='';
}

//Esta funci�n genera los parametros de la b�squeda
function generateQuery(){
	//Determinamos los valores para realziar la b�squeda
	jsCobMetodLiquiCodMetoLiqu = get('cobMetodLiquiFrm.codMetoLiqu').toString();
	jsCobMetodLiquiValDescMetoLiqu = get('cobMetodLiquiFrm.valDescMetoLiqu').toString();
	jsCobMetodLiquiIndLiqu = get('cobMetodLiquiFrm.indLiqu');
	jsCobMetodLiquiIndLiquGrupUsua = get('cobMetodLiquiFrm.indLiquGrupUsua');
	jsCobMetodLiquiValObse = get('cobMetodLiquiFrm.valObse').toString();
	jsCobMetodLiquiBaesOidBaseEsca = get('cobMetodLiquiFrm.baesOidBaseEsca')[0];
	
	
	var parametros = "";
	parametros += jsCobMetodLiquiCodMetoLiqu + "|";
	parametros += jsCobMetodLiquiValDescMetoLiqu + "|";
	parametros += jsCobMetodLiquiIndLiqu + "|";
	parametros += jsCobMetodLiquiIndLiquGrupUsua + "|";
	parametros += jsCobMetodLiquiValObse + "|";
	parametros += jsCobMetodLiquiBaesOidBaseEsca + "|";
	
	return parametros;
}

//Esta funci�n nos permite obteber los valore del formulario cuando est� en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function cobMetodLiquiBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsCobMetodLiquiCodMetoLiqu + "|";
	parametros += jsCobMetodLiquiValDescMetoLiqu + "|";
	parametros += jsCobMetodLiquiIndLiqu + "|";
	parametros += jsCobMetodLiquiIndLiquGrupUsua + "|";
	parametros += jsCobMetodLiquiValObse + "|";
	parametros += jsCobMetodLiquiBaesOidBaseEsca + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('cobMetodLiquiFrm.accion'), 
		get('cobMetodLiquiFrm.origen'));
	
	jsCobMetodLiquiId = get('cobMetodLiquiFrm.id').toString();
	jsCobMetodLiquiCodMetoLiqu = get('cobMetodLiquiFrm.codMetoLiqu').toString();
	jsCobMetodLiquiValDescMetoLiqu = get('cobMetodLiquiFrm.valDescMetoLiqu').toString();
	jsCobMetodLiquiIndLiqu = get('cobMetodLiquiFrm.indLiqu');
	jsCobMetodLiquiIndLiquGrupUsua = get('cobMetodLiquiFrm.indLiquGrupUsua');
	jsCobMetodLiquiValObse = get('cobMetodLiquiFrm.valObse').toString();
	jsCobMetodLiquiPaisOidPais = get('cobMetodLiquiFrm.paisOidPais')[0];
	jsCobMetodLiquiBaesOidBaseEsca = get('cobMetodLiquiFrm.baesOidBaseEsca')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('cobMetodLiquiFrm.accion'), 
		get('cobMetodLiquiFrm.origen'));


	set('cobMetodLiquiFrm.id', jsCobMetodLiquiId);
	set('cobMetodLiquiFrm.codMetoLiqu', jsCobMetodLiquiCodMetoLiqu);
	set('cobMetodLiquiFrm.valDescMetoLiqu', jsCobMetodLiquiValDescMetoLiqu);
	set('cobMetodLiquiFrm.indLiqu', jsCobMetodLiquiIndLiqu);
	set('cobMetodLiquiFrm.indLiquGrupUsua', jsCobMetodLiquiIndLiquGrupUsua);
	set('cobMetodLiquiFrm.valObse', jsCobMetodLiquiValObse);
	set('cobMetodLiquiFrm.paisOidPais', [jsCobMetodLiquiPaisOidPais]);
	set('cobMetodLiquiFrm.baesOidBaseEsca', [jsCobMetodLiquiBaesOidBaseEsca]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la b�squeda
	jsCobMetodLiquiCodMetoLiqu = '';
	jsCobMetodLiquiValDescMetoLiqu = '';
	jsCobMetodLiquiIndLiqu = '';
	jsCobMetodLiquiIndLiquGrupUsua = '';
	jsCobMetodLiquiValObse = '';
	jsCobMetodLiquiBaesOidBaseEsca = '';
	
}

//Permite disprar una acci�n para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('cobMetodLiquiFrm.errCodigo', errorCode);
	set('cobMetodLiquiFrm.errDescripcion', description);
	set('cobMetodLiquiFrm.errSeverity', severity);
	fMostrarMensajeError();
}
