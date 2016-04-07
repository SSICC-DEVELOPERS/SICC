

/*
    INDRA/CAR/mmg
    $Id: cobusuarcobraview.js,v 1.1 2009/12/03 19:02:00 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsCobUsuarCobraViewId = "";
var jsCobUsuarCobraViewFecUltiEsta = "";
var jsCobUsuarCobraViewIndJefeCobr = "";
var jsCobUsuarCobraViewIndUsuaSupe = "";
var jsCobUsuarCobraViewIndUsuaExte = "";
var jsCobUsuarCobraViewValTurnHoraEntr = "";
var jsCobUsuarCobraViewValTurnHoraSali = "";
var jsCobUsuarCobraViewValObse = "";
var jsCobUsuarCobraViewUserOidUsuaCobr = "";
var jsCobUsuarCobraViewPaisOidPais = "";

//Variables de paginacion, 
var cobUsuarCobraViewPageCount = 1;

//Varible de columna que representa el campo de choice
var cobUsuarCobraViewChoiceColumn = 7;

//Flag de siguiente pagina;
var cobUsuarCobraViewMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var cobUsuarCobraViewTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 441;
var sizeFormView = 423;
var sizeFormUpdate = 423;

//Ultima busqueda realizada
var cobUsuarCobraViewLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[0,'focalizaComboDependence("cobUsuarCobraView","paisOidPais", false);','focalizaComboDependence("cobUsuarCobraView","paisOidPais", false);','focalizaComboDependence("cobUsuarCobraView","paisOidPais", false);','focalizaComboDependence("cobUsuarCobraView","paisOidPais", true);','focalizaComboDependence("cobUsuarCobraView","paisOidPais", true);','focalizaComboDependence("cobUsuarCobraView","paisOidPais", true);'],[2,'focaliza("cobUsuarCobraViewFrm.fecUltiEsta");','focaliza("cobUsuarCobraViewFrm.fecUltiEsta");','focaliza("cobUsuarCobraViewFrm.fecUltiEsta");','focaliza("cobUsuarCobraViewFrm.fecUltiEsta");','focaliza("cobUsuarCobraViewFrm.fecUltiEsta");','focaliza("cobUsuarCobraViewFrm.fecUltiEsta");'],[3,'focaliza("cobUsuarCobraViewFrm.indJefeCobr");','focaliza("cobUsuarCobraViewFrm.indJefeCobr");','focaliza("cobUsuarCobraViewFrm.indJefeCobr");','focaliza("cobUsuarCobraViewFrm.indJefeCobr");','focaliza("cobUsuarCobraViewFrm.indJefeCobr");','focaliza("cobUsuarCobraViewFrm.indJefeCobr");'],[4,'focaliza("cobUsuarCobraViewFrm.indUsuaSupe");','focaliza("cobUsuarCobraViewFrm.indUsuaSupe");','focaliza("cobUsuarCobraViewFrm.indUsuaSupe");','focaliza("cobUsuarCobraViewFrm.indUsuaSupe");','focaliza("cobUsuarCobraViewFrm.indUsuaSupe");','focaliza("cobUsuarCobraViewFrm.indUsuaSupe");'],[5,'focaliza("cobUsuarCobraViewFrm.indUsuaExte");','focaliza("cobUsuarCobraViewFrm.indUsuaExte");','focaliza("cobUsuarCobraViewFrm.indUsuaExte");','focaliza("cobUsuarCobraViewFrm.indUsuaExte");','focaliza("cobUsuarCobraViewFrm.indUsuaExte");','focaliza("cobUsuarCobraViewFrm.indUsuaExte");'],[6,'focaliza("cobUsuarCobraViewFrm.valTurnHoraEntr");','focaliza("cobUsuarCobraViewFrm.valTurnHoraEntr");','focaliza("cobUsuarCobraViewFrm.valTurnHoraEntr");','focaliza("cobUsuarCobraViewFrm.valTurnHoraEntr");','focaliza("cobUsuarCobraViewFrm.valTurnHoraEntr");','focaliza("cobUsuarCobraViewFrm.valTurnHoraEntr");'],[7,'focaliza("cobUsuarCobraViewFrm.valTurnHoraSali");','focaliza("cobUsuarCobraViewFrm.valTurnHoraSali");','focaliza("cobUsuarCobraViewFrm.valTurnHoraSali");','focaliza("cobUsuarCobraViewFrm.valTurnHoraSali");','focaliza("cobUsuarCobraViewFrm.valTurnHoraSali");','focaliza("cobUsuarCobraViewFrm.valTurnHoraSali");'],[8,'focaliza("cobUsuarCobraViewFrm.valObse");','focaliza("cobUsuarCobraViewFrm.valObse");','focaliza("cobUsuarCobraViewFrm.valObse");','focaliza("cobUsuarCobraViewFrm.valObse");','focaliza("cobUsuarCobraViewFrm.valObse");','focaliza("cobUsuarCobraViewFrm.valObse");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[0,'focalizaComboDependence("cobUsuarCobraView","paisOidPais", false);','focalizaComboDependence("cobUsuarCobraView","paisOidPais", false);','focalizaComboDependence("cobUsuarCobraView","paisOidPais", false);','focalizaComboDependence("cobUsuarCobraView","paisOidPais", true);','focalizaComboDependence("cobUsuarCobraView","paisOidPais", true);','focalizaComboDependence("cobUsuarCobraView","paisOidPais", true);'],[2,'focaliza("cobUsuarCobraViewFrm.fecUltiEsta");','focaliza("cobUsuarCobraViewFrm.fecUltiEsta");','focaliza("cobUsuarCobraViewFrm.fecUltiEsta");','focaliza("cobUsuarCobraViewFrm.fecUltiEsta");','focaliza("cobUsuarCobraViewFrm.fecUltiEsta");','focaliza("cobUsuarCobraViewFrm.fecUltiEsta");'],[3,'focaliza("cobUsuarCobraViewFrm.indJefeCobr");','focaliza("cobUsuarCobraViewFrm.indJefeCobr");','focaliza("cobUsuarCobraViewFrm.indJefeCobr");','focaliza("cobUsuarCobraViewFrm.indJefeCobr");','focaliza("cobUsuarCobraViewFrm.indJefeCobr");','focaliza("cobUsuarCobraViewFrm.indJefeCobr");'],[4,'focaliza("cobUsuarCobraViewFrm.indUsuaSupe");','focaliza("cobUsuarCobraViewFrm.indUsuaSupe");','focaliza("cobUsuarCobraViewFrm.indUsuaSupe");','focaliza("cobUsuarCobraViewFrm.indUsuaSupe");','focaliza("cobUsuarCobraViewFrm.indUsuaSupe");','focaliza("cobUsuarCobraViewFrm.indUsuaSupe");'],[5,'focaliza("cobUsuarCobraViewFrm.indUsuaExte");','focaliza("cobUsuarCobraViewFrm.indUsuaExte");','focaliza("cobUsuarCobraViewFrm.indUsuaExte");','focaliza("cobUsuarCobraViewFrm.indUsuaExte");','focaliza("cobUsuarCobraViewFrm.indUsuaExte");','focaliza("cobUsuarCobraViewFrm.indUsuaExte");'],[6,'focaliza("cobUsuarCobraViewFrm.valTurnHoraEntr");','focaliza("cobUsuarCobraViewFrm.valTurnHoraEntr");','focaliza("cobUsuarCobraViewFrm.valTurnHoraEntr");','focaliza("cobUsuarCobraViewFrm.valTurnHoraEntr");','focaliza("cobUsuarCobraViewFrm.valTurnHoraEntr");','focaliza("cobUsuarCobraViewFrm.valTurnHoraEntr");'],[7,'focaliza("cobUsuarCobraViewFrm.valTurnHoraSali");','focaliza("cobUsuarCobraViewFrm.valTurnHoraSali");','focaliza("cobUsuarCobraViewFrm.valTurnHoraSali");','focaliza("cobUsuarCobraViewFrm.valTurnHoraSali");','focaliza("cobUsuarCobraViewFrm.valTurnHoraSali");','focaliza("cobUsuarCobraViewFrm.valTurnHoraSali");'],[8,'focaliza("cobUsuarCobraViewFrm.valObse");','focaliza("cobUsuarCobraViewFrm.valObse");','focaliza("cobUsuarCobraViewFrm.valObse");','focaliza("cobUsuarCobraViewFrm.valObse");','focaliza("cobUsuarCobraViewFrm.valObse");','focaliza("cobUsuarCobraViewFrm.valObse");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var userOidUsuaCobrDependeceMap = new Vector();
userOidUsuaCobrDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
userOidUsuaCobrDependeceMap.agregar(['userOidUsuaCobr', padresTmp, '', 'GenUsers']);
var paisOidPaisDependeceMap = new Vector();
paisOidPaisDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais', padresTmp, '', 'SegPaisView']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
cobUsuarCobraViewLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var cobUsuarCobraViewTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function cobUsuarCobraViewInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('cobUsuarCobraViewFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('cobUsuarCobraViewFrm.accion')){
		case "query": cobUsuarCobraViewQueryInitComponents(); break;
		case "view": cobUsuarCobraViewViewInitComponents(); break;
		case "create": cobUsuarCobraViewCreateInitComponents(); break;
		case "update": cobUsuarCobraViewUpdateInitComponents(); break;
		case "remove": cobUsuarCobraViewRemoveInitComponents(); break;
		case "lov": cobUsuarCobraViewLovInitComponents(); break;
	}
	//alert('accion :' + get('cobUsuarCobraViewFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('cobUsuarCobraViewFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('cobUsuarCobraView')) cobUsuarCobraViewCmdRequery();
}

function cobUsuarCobraViewQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	focusFirstField('cobUsuarCobraViewFrm', true);	
}

function cobUsuarCobraViewViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('cobUsuarCobraViewFrm', true);
}

function cobUsuarCobraViewCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('cobUsuarCobraViewFrm.userOidUsuaCobr','S', GestionarMensaje('CobUsuarCobraView.userOidUsuaCobr.requiered.message'));
	
	setMV('cobUsuarCobraViewFrm.paisOidPais','S', GestionarMensaje('CobUsuarCobraView.paisOidPais.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('cobUsuarCobraViewFrm', true);
}

function cobUsuarCobraViewUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('cobUsuarCobraViewFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		cobUsuarCobraViewTmpUpdateValues = cobUsuarCobraViewBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('cobUsuarCobraViewFrm.userOidUsuaCobr','S', GestionarMensaje('CobUsuarCobraView.userOidUsuaCobr.requiered.message'));
		setMV('cobUsuarCobraViewFrm.paisOidPais','S', GestionarMensaje('CobUsuarCobraView.paisOidPais.requiered.message'));
		
			focusFirstFieldModify('cobUsuarCobraViewFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		focusFirstField('cobUsuarCobraViewFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('cobUsuarCobraViewFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function cobUsuarCobraViewRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	cobUsuarCobraViewList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('cobUsuarCobraViewFrm', true);
}

function cobUsuarCobraViewLovInitComponents(){
	cobUsuarCobraViewLovReturnParameters = window.dialogArguments;
	
	focusFirstField('cobUsuarCobraViewFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad












//Función que permite cargar los datos de un elemento de lov seleccionado
function cobUsuarCobraViewSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('cobUsuarCobraViewFrm.' + campo, id);
	set('cobUsuarCobraViewFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function cobUsuarCobraViewLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	cobUsuarCobraViewLovReturnParameters.id = '';
	cobUsuarCobraViewLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function cobUsuarCobraViewLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cobUsuarCobraViewList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = cobUsuarCobraViewList.codSeleccionados();
	var descripcion = cobUsuarCobraViewList.extraeDato(
		cobUsuarCobraViewList.codSeleccionados()[0], cobUsuarCobraViewChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	cobUsuarCobraViewLovReturnParameters.id = codigo;
	cobUsuarCobraViewLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function cobUsuarCobraViewCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('cobUsuarCobraViewFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('cobUsuarCobraViewFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "cobUsuarCobraViewList", "CobUsuarCobraViewConectorTransactionQuery", 
		"result_ROWSET", parametros, "cobUsuarCobraViewPostQueryActions(datos);"]], "", "");	
}

function cobUsuarCobraViewCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('cobUsuarCobraViewFrm.lastQueryToSession'));
	var i =0;
	set('cobUsuarCobraViewFrm.fecUltiEsta', paramsRequery.ij(i++));
	
	set('cobUsuarCobraViewFrm.indJefeCobr', paramsRequery.ij(i++));
	
	set('cobUsuarCobraViewFrm.indUsuaSupe', paramsRequery.ij(i++));
	
	set('cobUsuarCobraViewFrm.indUsuaExte', paramsRequery.ij(i++));
	
	set('cobUsuarCobraViewFrm.valTurnHoraEntr', paramsRequery.ij(i++));
	
	set('cobUsuarCobraViewFrm.valTurnHoraSali', paramsRequery.ij(i++));
	
	set('cobUsuarCobraViewFrm.valObse', paramsRequery.ij(i++));
	
	set('cobUsuarCobraViewFrm.userOidUsuaCobr', [paramsRequery.ij(i++)]);
	
	set('cobUsuarCobraViewFrm.paisOidPais', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la página de busqueda como la actual
	cobUsuarCobraViewPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	cobUsuarCobraViewCmdQuery(cobUsuarCobraViewPageCount);
}

function cobUsuarCobraViewFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	cobUsuarCobraViewPageCount = 1;
	cobUsuarCobraViewCmdQuery(cobUsuarCobraViewPageCount);
}

function cobUsuarCobraViewPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != cobUsuarCobraViewLastQuery){
		cobUsuarCobraViewFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	cobUsuarCobraViewPageCount--;
	cobUsuarCobraViewCmdQuery(cobUsuarCobraViewPageCount);
}

function cobUsuarCobraViewNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != cobUsuarCobraViewLastQuery){
		cobUsuarCobraViewFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	cobUsuarCobraViewPageCount++;
	cobUsuarCobraViewCmdQuery(cobUsuarCobraViewPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function cobUsuarCobraViewPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('cobUsuarCobraViewListLayer', 'O');
		visibilidad('cobUsuarCobraViewListButtonsLayer', 'O');
		if(get('cobUsuarCobraViewFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	cobUsuarCobraViewLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:cobUsuarCobraViewViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, cobUsuarCobraViewChoiceColumn) + "</A>",
			i, cobUsuarCobraViewChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	cobUsuarCobraViewList.setDatos(datosTmp.filtrar([0,1,2,3,4,5,6,7,8,9],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	cobUsuarCobraViewTimeStamps = datosTmp.filtrar([10],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		cobUsuarCobraViewMorePagesFlag = true;
		cobUsuarCobraViewList.eliminar(mmgPageSize, 1);
	}else{
		cobUsuarCobraViewMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('cobUsuarCobraViewFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('cobUsuarCobraViewListLayer', 'V');
	visibilidad('cobUsuarCobraViewListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('cobUsuarCobraViewList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	cobUsuarCobraViewList.display();
	
	//Actualizamos el estado de los botones 
	if(cobUsuarCobraViewMorePagesFlag){
		set_estado_botonera('cobUsuarCobraViewPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('cobUsuarCobraViewPaginationButtonBar',
			3,"inactivo");
	}
	if(cobUsuarCobraViewPageCount > 1){
		set_estado_botonera('cobUsuarCobraViewPaginationButtonBar',
			2,"activo");
		set_estado_botonera('cobUsuarCobraViewPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('cobUsuarCobraViewPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('cobUsuarCobraViewPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function cobUsuarCobraViewUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cobUsuarCobraViewList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('cobUsuarCobraViewFrm.idSelection', cobUsuarCobraViewList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('cobUsuarCobraViewFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = cobUsuarCobraViewList.codSeleccionados()[0];
		parametros["previousAction"] = get('cobUsuarCobraViewFrm.accion');
		parametros["accion"] = get('cobUsuarCobraViewFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('CobUsuarCobraViewLPStartUp', get('cobUsuarCobraViewFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) cobUsuarCobraViewCmdRequery();
	}
}

function cobUsuarCobraViewRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cobUsuarCobraViewList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = cobUsuarCobraViewList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('cobUsuarCobraViewFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(cobUsuarCobraViewList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += cobUsuarCobraViewTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('cobUsuarCobraViewFrm.timestamp', timestamps);


	cobUsuarCobraViewFrm.oculto='S';
	envia('cobUsuarCobraViewFrm');
	cobUsuarCobraViewFrm.oculto='N';
}

function cobUsuarCobraViewViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cobUsuarCobraViewList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	cobUsuarCobraViewViewDetail(cobUsuarCobraViewList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function cobUsuarCobraViewViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('cobUsuarCobraViewFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('CobUsuarCobraViewLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('cobUsuarCobraViewFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
	
	
	
		
	
	if(validacion){
		cobUsuarCobraViewFrm.oculto='S';
		envia('cobUsuarCobraViewFrm');
		cobUsuarCobraViewFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('cobUsuarCobraViewFrm.userOidUsuaCobr').toString() == ''){
		set('cobUsuarCobraViewFrm.userOidUsuaCobr', []);
		mmgResetCombosOnCascade('userOidUsuaCobr', 'userOidUsuaCobr', 'cobUsuarCobraView');
		
	}
	if(get('cobUsuarCobraViewFrm.paisOidPais').toString() == ''){
		set('cobUsuarCobraViewFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'cobUsuarCobraView');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	cobUsuarCobraViewRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('cobUsuarCobraViewFrm.accion');
	var origenTmp = get('cobUsuarCobraViewFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(cobUsuarCobraViewBuildUpdateRecordString() != cobUsuarCobraViewTmpUpdateValues){
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
	document.all.cobUsuarCobraViewListLayer.style.display='none';
	document.all.cobUsuarCobraViewListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.cobUsuarCobraViewListLayer.style.display='';
	document.all.cobUsuarCobraViewListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsCobUsuarCobraViewFecUltiEsta = get('cobUsuarCobraViewFrm.fecUltiEsta').toString();
	jsCobUsuarCobraViewIndJefeCobr = get('cobUsuarCobraViewFrm.indJefeCobr').toString();
	jsCobUsuarCobraViewIndUsuaSupe = get('cobUsuarCobraViewFrm.indUsuaSupe').toString();
	jsCobUsuarCobraViewIndUsuaExte = get('cobUsuarCobraViewFrm.indUsuaExte').toString();
	jsCobUsuarCobraViewValTurnHoraEntr = get('cobUsuarCobraViewFrm.valTurnHoraEntr').toString();
	jsCobUsuarCobraViewValTurnHoraSali = get('cobUsuarCobraViewFrm.valTurnHoraSali').toString();
	jsCobUsuarCobraViewValObse = get('cobUsuarCobraViewFrm.valObse').toString();
	jsCobUsuarCobraViewUserOidUsuaCobr = get('cobUsuarCobraViewFrm.userOidUsuaCobr')[0];
	jsCobUsuarCobraViewPaisOidPais = get('cobUsuarCobraViewFrm.paisOidPais')[0];
	
	
	var parametros = "";
	parametros += jsCobUsuarCobraViewFecUltiEsta + "|";
	parametros += jsCobUsuarCobraViewIndJefeCobr + "|";
	parametros += jsCobUsuarCobraViewIndUsuaSupe + "|";
	parametros += jsCobUsuarCobraViewIndUsuaExte + "|";
	parametros += jsCobUsuarCobraViewValTurnHoraEntr + "|";
	parametros += jsCobUsuarCobraViewValTurnHoraSali + "|";
	parametros += jsCobUsuarCobraViewValObse + "|";
	parametros += jsCobUsuarCobraViewUserOidUsuaCobr + "|";
	parametros += jsCobUsuarCobraViewPaisOidPais + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function cobUsuarCobraViewBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsCobUsuarCobraViewFecUltiEsta + "|";
	parametros += jsCobUsuarCobraViewIndJefeCobr + "|";
	parametros += jsCobUsuarCobraViewIndUsuaSupe + "|";
	parametros += jsCobUsuarCobraViewIndUsuaExte + "|";
	parametros += jsCobUsuarCobraViewValTurnHoraEntr + "|";
	parametros += jsCobUsuarCobraViewValTurnHoraSali + "|";
	parametros += jsCobUsuarCobraViewValObse + "|";
	parametros += jsCobUsuarCobraViewUserOidUsuaCobr + "|";
	parametros += jsCobUsuarCobraViewPaisOidPais + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('cobUsuarCobraViewFrm.accion'), 
		get('cobUsuarCobraViewFrm.origen'));
	
	jsCobUsuarCobraViewId = get('cobUsuarCobraViewFrm.id').toString();
	jsCobUsuarCobraViewFecUltiEsta = get('cobUsuarCobraViewFrm.fecUltiEsta').toString();
	jsCobUsuarCobraViewIndJefeCobr = get('cobUsuarCobraViewFrm.indJefeCobr').toString();
	jsCobUsuarCobraViewIndUsuaSupe = get('cobUsuarCobraViewFrm.indUsuaSupe').toString();
	jsCobUsuarCobraViewIndUsuaExte = get('cobUsuarCobraViewFrm.indUsuaExte').toString();
	jsCobUsuarCobraViewValTurnHoraEntr = get('cobUsuarCobraViewFrm.valTurnHoraEntr').toString();
	jsCobUsuarCobraViewValTurnHoraSali = get('cobUsuarCobraViewFrm.valTurnHoraSali').toString();
	jsCobUsuarCobraViewValObse = get('cobUsuarCobraViewFrm.valObse').toString();
	jsCobUsuarCobraViewUserOidUsuaCobr = get('cobUsuarCobraViewFrm.userOidUsuaCobr')[0];
	jsCobUsuarCobraViewPaisOidPais = get('cobUsuarCobraViewFrm.paisOidPais')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('cobUsuarCobraViewFrm.accion'), 
		get('cobUsuarCobraViewFrm.origen'));


	set('cobUsuarCobraViewFrm.id', jsCobUsuarCobraViewId);
	set('cobUsuarCobraViewFrm.fecUltiEsta', jsCobUsuarCobraViewFecUltiEsta);
	set('cobUsuarCobraViewFrm.indJefeCobr', jsCobUsuarCobraViewIndJefeCobr);
	set('cobUsuarCobraViewFrm.indUsuaSupe', jsCobUsuarCobraViewIndUsuaSupe);
	set('cobUsuarCobraViewFrm.indUsuaExte', jsCobUsuarCobraViewIndUsuaExte);
	set('cobUsuarCobraViewFrm.valTurnHoraEntr', jsCobUsuarCobraViewValTurnHoraEntr);
	set('cobUsuarCobraViewFrm.valTurnHoraSali', jsCobUsuarCobraViewValTurnHoraSali);
	set('cobUsuarCobraViewFrm.valObse', jsCobUsuarCobraViewValObse);
	set('cobUsuarCobraViewFrm.userOidUsuaCobr', [jsCobUsuarCobraViewUserOidUsuaCobr]);
	set('cobUsuarCobraViewFrm.paisOidPais', [jsCobUsuarCobraViewPaisOidPais]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsCobUsuarCobraViewFecUltiEsta = '';
	jsCobUsuarCobraViewIndJefeCobr = '';
	jsCobUsuarCobraViewIndUsuaSupe = '';
	jsCobUsuarCobraViewIndUsuaExte = '';
	jsCobUsuarCobraViewValTurnHoraEntr = '';
	jsCobUsuarCobraViewValTurnHoraSali = '';
	jsCobUsuarCobraViewValObse = '';
	jsCobUsuarCobraViewUserOidUsuaCobr = '';
	jsCobUsuarCobraViewPaisOidPais = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('cobUsuarCobraViewFrm.errCodigo', errorCode);
	set('cobUsuarCobraViewFrm.errDescripcion', description);
	set('cobUsuarCobraViewFrm.errSeverity', severity);
	fMostrarMensajeError();
}
