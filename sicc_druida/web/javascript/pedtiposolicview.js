

/*
    INDRA/CAR/mmg
    $Id: pedtiposolicview.js,v 1.1 2009/12/03 19:01:29 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsPedTipoSolicViewId = "";
var jsPedTipoSolicViewCodTipoSoli = "";
var jsPedTipoSolicViewIndCons = "";
var jsPedTipoSolicViewIndSoliNega = "";
var jsPedTipoSolicViewIndDevo = "";
var jsPedTipoSolicViewIndAnul = "";
var jsPedTipoSolicViewCodGrupSoli = "";
var jsPedTipoSolicViewDescripcion = "";

//Variables de paginacion, 
var pedTipoSolicViewPageCount = 1;

//Varible de columna que representa el campo de choice
var pedTipoSolicViewChoiceColumn = 6;

//Flag de siguiente pagina;
var pedTipoSolicViewMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var pedTipoSolicViewTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 315;
var sizeFormView = 355;
var sizeFormUpdate = 355;

//Ultima busqueda realizada
var pedTipoSolicViewLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("pedTipoSolicViewFrm.codTipoSoli");','focaliza("pedTipoSolicViewFrm.codTipoSoli");','focaliza("pedTipoSolicViewFrm.codTipoSoli");','focaliza("pedTipoSolicViewFrm.codTipoSoli");','focaliza("pedTipoSolicViewFrm.codTipoSoli");','focaliza("pedTipoSolicViewFrm.codTipoSoli");'],[7,'focaliza("pedTipoSolicViewFrm.indCons");','focaliza("pedTipoSolicViewFrm.indCons");','focaliza("pedTipoSolicViewFrm.indCons");','focaliza("pedTipoSolicViewFrm.indCons");','focaliza("pedTipoSolicViewFrm.indCons");','focaliza("pedTipoSolicViewFrm.indCons");'],[8,'focaliza("pedTipoSolicViewFrm.indSoliNega");','focaliza("pedTipoSolicViewFrm.indSoliNega");','focaliza("pedTipoSolicViewFrm.indSoliNega");','focaliza("pedTipoSolicViewFrm.indSoliNega");','focaliza("pedTipoSolicViewFrm.indSoliNega");','focaliza("pedTipoSolicViewFrm.indSoliNega");'],[10,'focaliza("pedTipoSolicViewFrm.indDevo");','focaliza("pedTipoSolicViewFrm.indDevo");','focaliza("pedTipoSolicViewFrm.indDevo");','focaliza("pedTipoSolicViewFrm.indDevo");','focaliza("pedTipoSolicViewFrm.indDevo");','focaliza("pedTipoSolicViewFrm.indDevo");'],[11,'focaliza("pedTipoSolicViewFrm.indAnul");','focaliza("pedTipoSolicViewFrm.indAnul");','focaliza("pedTipoSolicViewFrm.indAnul");','focaliza("pedTipoSolicViewFrm.indAnul");','focaliza("pedTipoSolicViewFrm.indAnul");','focaliza("pedTipoSolicViewFrm.indAnul");'],[13,'focaliza("pedTipoSolicViewFrm.codGrupSoli");','focaliza("pedTipoSolicViewFrm.codGrupSoli");','focaliza("pedTipoSolicViewFrm.codGrupSoli");','focaliza("pedTipoSolicViewFrm.codGrupSoli");','focaliza("pedTipoSolicViewFrm.codGrupSoli");','focaliza("pedTipoSolicViewFrm.codGrupSoli");'],[14,'','focaliza("pedTipoSolicViewFrm.Descripcion");','focaliza("pedTipoSolicViewFrm.Descripcion");','','focaliza("pedTipoSolicViewFrm.Descripcion");','focaliza("pedTipoSolicViewFrm.Descripcion");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[2,'focaliza("pedTipoSolicViewFrm.codTipoSoli");','focaliza("pedTipoSolicViewFrm.codTipoSoli");','focaliza("pedTipoSolicViewFrm.codTipoSoli");','focaliza("pedTipoSolicViewFrm.codTipoSoli");','focaliza("pedTipoSolicViewFrm.codTipoSoli");','focaliza("pedTipoSolicViewFrm.codTipoSoli");'],[7,'focaliza("pedTipoSolicViewFrm.indCons");','focaliza("pedTipoSolicViewFrm.indCons");','focaliza("pedTipoSolicViewFrm.indCons");','focaliza("pedTipoSolicViewFrm.indCons");','focaliza("pedTipoSolicViewFrm.indCons");','focaliza("pedTipoSolicViewFrm.indCons");'],[8,'focaliza("pedTipoSolicViewFrm.indSoliNega");','focaliza("pedTipoSolicViewFrm.indSoliNega");','focaliza("pedTipoSolicViewFrm.indSoliNega");','focaliza("pedTipoSolicViewFrm.indSoliNega");','focaliza("pedTipoSolicViewFrm.indSoliNega");','focaliza("pedTipoSolicViewFrm.indSoliNega");'],[10,'focaliza("pedTipoSolicViewFrm.indDevo");','focaliza("pedTipoSolicViewFrm.indDevo");','focaliza("pedTipoSolicViewFrm.indDevo");','focaliza("pedTipoSolicViewFrm.indDevo");','focaliza("pedTipoSolicViewFrm.indDevo");','focaliza("pedTipoSolicViewFrm.indDevo");'],[11,'focaliza("pedTipoSolicViewFrm.indAnul");','focaliza("pedTipoSolicViewFrm.indAnul");','focaliza("pedTipoSolicViewFrm.indAnul");','focaliza("pedTipoSolicViewFrm.indAnul");','focaliza("pedTipoSolicViewFrm.indAnul");','focaliza("pedTipoSolicViewFrm.indAnul");'],[13,'focaliza("pedTipoSolicViewFrm.codGrupSoli");','focaliza("pedTipoSolicViewFrm.codGrupSoli");','focaliza("pedTipoSolicViewFrm.codGrupSoli");','focaliza("pedTipoSolicViewFrm.codGrupSoli");','focaliza("pedTipoSolicViewFrm.codGrupSoli");','focaliza("pedTipoSolicViewFrm.codGrupSoli");'],[14,'','focaliza("pedTipoSolicViewFrm.Descripcion");','focaliza("pedTipoSolicViewFrm.Descripcion");','','focaliza("pedTipoSolicViewFrm.Descripcion");','focaliza("pedTipoSolicViewFrm.Descripcion");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
pedTipoSolicViewLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var pedTipoSolicViewTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function pedTipoSolicViewInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('pedTipoSolicViewFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('pedTipoSolicViewFrm.accion')){
		case "query": pedTipoSolicViewQueryInitComponents(); break;
		case "view": pedTipoSolicViewViewInitComponents(); break;
		case "create": pedTipoSolicViewCreateInitComponents(); break;
		case "update": pedTipoSolicViewUpdateInitComponents(); break;
		case "remove": pedTipoSolicViewRemoveInitComponents(); break;
		case "lov": pedTipoSolicViewLovInitComponents(); break;
	}
	//alert('accion :' + get('pedTipoSolicViewFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('pedTipoSolicViewFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('pedTipoSolicView')) pedTipoSolicViewCmdRequery();
}

function pedTipoSolicViewQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	focusFirstField('pedTipoSolicViewFrm', true);	
}

function pedTipoSolicViewViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('pedTipoSolicViewFrm', 'Descripcion', 1);
	
		
	
	focusFirstField('pedTipoSolicViewFrm', true);
}

function pedTipoSolicViewCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('pedTipoSolicViewFrm.codTipoSoli','S', GestionarMensaje('PedTipoSolicView.codTipoSoli.requiered.message'));
	
	setMV('pedTipoSolicViewFrm.indCons','S', GestionarMensaje('PedTipoSolicView.indCons.requiered.message'));
	
	setMV('pedTipoSolicViewFrm.indSoliNega','S', GestionarMensaje('PedTipoSolicView.indSoliNega.requiered.message'));
	
	setMV('pedTipoSolicViewFrm.indDevo','S', GestionarMensaje('PedTipoSolicView.indDevo.requiered.message'));
	
	setMV('pedTipoSolicViewFrm.indAnul','S', GestionarMensaje('PedTipoSolicView.indAnul.requiered.message'));
	
	setMV('pedTipoSolicViewFrm.Descripcion','S', GestionarMensaje('PedTipoSolicView.Descripcion.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('pedTipoSolicViewFrm', true);
}

function pedTipoSolicViewUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('pedTipoSolicViewFrm.origen') == "pagina"){
		loadLocalizationWidget('pedTipoSolicViewFrm', 'Descripcion', 1);
		

		

		//Registramos el valor del elemento que estamos modificando
		pedTipoSolicViewTmpUpdateValues = pedTipoSolicViewBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('pedTipoSolicViewFrm.codTipoSoli','S', GestionarMensaje('PedTipoSolicView.codTipoSoli.requiered.message'));
		setMV('pedTipoSolicViewFrm.indCons','S', GestionarMensaje('PedTipoSolicView.indCons.requiered.message'));
		setMV('pedTipoSolicViewFrm.indSoliNega','S', GestionarMensaje('PedTipoSolicView.indSoliNega.requiered.message'));
		setMV('pedTipoSolicViewFrm.indDevo','S', GestionarMensaje('PedTipoSolicView.indDevo.requiered.message'));
		setMV('pedTipoSolicViewFrm.indAnul','S', GestionarMensaje('PedTipoSolicView.indAnul.requiered.message'));
		setMV('pedTipoSolicViewFrm.Descripcion','S', GestionarMensaje('PedTipoSolicView.Descripcion.requiered.message'));
		
			focusFirstFieldModify('pedTipoSolicViewFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		focusFirstField('pedTipoSolicViewFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('pedTipoSolicViewFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function pedTipoSolicViewRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	pedTipoSolicViewList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('pedTipoSolicViewFrm', true);
}

function pedTipoSolicViewLovInitComponents(){
	pedTipoSolicViewLovReturnParameters = window.dialogArguments;
	
	focusFirstField('pedTipoSolicViewFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad










//Función que permite cargar los datos de un elemento de lov seleccionado
function pedTipoSolicViewSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('pedTipoSolicViewFrm.' + campo, id);
	set('pedTipoSolicViewFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function pedTipoSolicViewLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	pedTipoSolicViewLovReturnParameters.id = '';
	pedTipoSolicViewLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function pedTipoSolicViewLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(pedTipoSolicViewList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = pedTipoSolicViewList.codSeleccionados();
	var descripcion = pedTipoSolicViewList.extraeDato(
		pedTipoSolicViewList.codSeleccionados()[0], pedTipoSolicViewChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	pedTipoSolicViewLovReturnParameters.id = codigo;
	pedTipoSolicViewLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function pedTipoSolicViewCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('pedTipoSolicViewFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('pedTipoSolicViewFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "pedTipoSolicViewList", "PedTipoSolicViewConectorTransactionQuery", 
		"result_ROWSET", parametros, "pedTipoSolicViewPostQueryActions(datos);"]], "", "");	
}

function pedTipoSolicViewCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('pedTipoSolicViewFrm.lastQueryToSession'));
	var i =0;
	set('pedTipoSolicViewFrm.codTipoSoli', paramsRequery.ij(i++));
	
	set('pedTipoSolicViewFrm.indCons', paramsRequery.ij(i++));
	
	set('pedTipoSolicViewFrm.indSoliNega', paramsRequery.ij(i++));
	
	set('pedTipoSolicViewFrm.indDevo', paramsRequery.ij(i++));
	
	set('pedTipoSolicViewFrm.indAnul', paramsRequery.ij(i++));
	
	set('pedTipoSolicViewFrm.codGrupSoli', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	pedTipoSolicViewPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	pedTipoSolicViewCmdQuery(pedTipoSolicViewPageCount);
}

function pedTipoSolicViewFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	pedTipoSolicViewPageCount = 1;
	pedTipoSolicViewCmdQuery(pedTipoSolicViewPageCount);
}

function pedTipoSolicViewPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != pedTipoSolicViewLastQuery){
		pedTipoSolicViewFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	pedTipoSolicViewPageCount--;
	pedTipoSolicViewCmdQuery(pedTipoSolicViewPageCount);
}

function pedTipoSolicViewNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != pedTipoSolicViewLastQuery){
		pedTipoSolicViewFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	pedTipoSolicViewPageCount++;
	pedTipoSolicViewCmdQuery(pedTipoSolicViewPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function pedTipoSolicViewPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('pedTipoSolicViewListLayer', 'O');
		visibilidad('pedTipoSolicViewListButtonsLayer', 'O');
		if(get('pedTipoSolicViewFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	pedTipoSolicViewLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:pedTipoSolicViewViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, pedTipoSolicViewChoiceColumn) + "</A>",
			i, pedTipoSolicViewChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	pedTipoSolicViewList.setDatos(datosTmp.filtrar([0,1,2,3,4,5,6],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	pedTipoSolicViewTimeStamps = datosTmp.filtrar([7],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		pedTipoSolicViewMorePagesFlag = true;
		pedTipoSolicViewList.eliminar(mmgPageSize, 1);
	}else{
		pedTipoSolicViewMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('pedTipoSolicViewFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('pedTipoSolicViewListLayer', 'V');
	visibilidad('pedTipoSolicViewListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('pedTipoSolicViewList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	pedTipoSolicViewList.display();
	
	//Actualizamos el estado de los botones 
	if(pedTipoSolicViewMorePagesFlag){
		set_estado_botonera('pedTipoSolicViewPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('pedTipoSolicViewPaginationButtonBar',
			3,"inactivo");
	}
	if(pedTipoSolicViewPageCount > 1){
		set_estado_botonera('pedTipoSolicViewPaginationButtonBar',
			2,"activo");
		set_estado_botonera('pedTipoSolicViewPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('pedTipoSolicViewPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('pedTipoSolicViewPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function pedTipoSolicViewUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(pedTipoSolicViewList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('pedTipoSolicViewFrm.idSelection', pedTipoSolicViewList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('pedTipoSolicViewFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = pedTipoSolicViewList.codSeleccionados()[0];
		parametros["previousAction"] = get('pedTipoSolicViewFrm.accion');
		parametros["accion"] = get('pedTipoSolicViewFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('PedTipoSolicViewLPStartUp', get('pedTipoSolicViewFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) pedTipoSolicViewCmdRequery();
	}
}

function pedTipoSolicViewRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(pedTipoSolicViewList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = pedTipoSolicViewList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('pedTipoSolicViewFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(pedTipoSolicViewList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += pedTipoSolicViewTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('pedTipoSolicViewFrm.timestamp', timestamps);


	pedTipoSolicViewFrm.oculto='S';
	envia('pedTipoSolicViewFrm');
	pedTipoSolicViewFrm.oculto='N';
}

function pedTipoSolicViewViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(pedTipoSolicViewList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	pedTipoSolicViewViewDetail(pedTipoSolicViewList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function pedTipoSolicViewViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('pedTipoSolicViewFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('PedTipoSolicViewLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	
	
	
	
	setDefaultLanguageValue('pedTipoSolicViewFrm', 
		'Descripcion', 1,
		get('pedTipoSolicViewFrm.Descripcion'));	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('pedTipoSolicViewFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
	if(!hasDefaultLanguageValue('pedTipoSolicViewFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('PedTipoSolicView.Descripcion.requiered.message'));
		focaliza('pedTipoSolicViewFrm.Descripcion');
		return;
	}	
	
		
	
	if(validacion){
		pedTipoSolicViewFrm.oculto='S';
		envia('pedTipoSolicViewFrm');
		pedTipoSolicViewFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	pedTipoSolicViewRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('pedTipoSolicViewFrm.accion');
	var origenTmp = get('pedTipoSolicViewFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(pedTipoSolicViewBuildUpdateRecordString() != pedTipoSolicViewTmpUpdateValues){
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
	document.all.pedTipoSolicViewListLayer.style.display='none';
	document.all.pedTipoSolicViewListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.pedTipoSolicViewListLayer.style.display='';
	document.all.pedTipoSolicViewListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsPedTipoSolicViewCodTipoSoli = get('pedTipoSolicViewFrm.codTipoSoli').toString();
	jsPedTipoSolicViewIndCons = get('pedTipoSolicViewFrm.indCons').toString();
	jsPedTipoSolicViewIndSoliNega = get('pedTipoSolicViewFrm.indSoliNega').toString();
	jsPedTipoSolicViewIndDevo = get('pedTipoSolicViewFrm.indDevo').toString();
	jsPedTipoSolicViewIndAnul = get('pedTipoSolicViewFrm.indAnul').toString();
	jsPedTipoSolicViewCodGrupSoli = get('pedTipoSolicViewFrm.codGrupSoli').toString();
	
	
	var parametros = "";
	parametros += jsPedTipoSolicViewCodTipoSoli + "|";
	parametros += jsPedTipoSolicViewIndCons + "|";
	parametros += jsPedTipoSolicViewIndSoliNega + "|";
	parametros += jsPedTipoSolicViewIndDevo + "|";
	parametros += jsPedTipoSolicViewIndAnul + "|";
	parametros += jsPedTipoSolicViewCodGrupSoli + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function pedTipoSolicViewBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsPedTipoSolicViewCodTipoSoli + "|";
	parametros += jsPedTipoSolicViewIndCons + "|";
	parametros += jsPedTipoSolicViewIndSoliNega + "|";
	parametros += jsPedTipoSolicViewIndDevo + "|";
	parametros += jsPedTipoSolicViewIndAnul + "|";
	parametros += jsPedTipoSolicViewCodGrupSoli + "|";
	parametros += jsPedTipoSolicViewDescripcion + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('pedTipoSolicViewFrm.accion'), 
		get('pedTipoSolicViewFrm.origen'));
	
	jsPedTipoSolicViewId = get('pedTipoSolicViewFrm.id').toString();
	jsPedTipoSolicViewCodTipoSoli = get('pedTipoSolicViewFrm.codTipoSoli').toString();
	jsPedTipoSolicViewIndCons = get('pedTipoSolicViewFrm.indCons').toString();
	jsPedTipoSolicViewIndSoliNega = get('pedTipoSolicViewFrm.indSoliNega').toString();
	jsPedTipoSolicViewIndDevo = get('pedTipoSolicViewFrm.indDevo').toString();
	jsPedTipoSolicViewIndAnul = get('pedTipoSolicViewFrm.indAnul').toString();
	jsPedTipoSolicViewCodGrupSoli = get('pedTipoSolicViewFrm.codGrupSoli').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsPedTipoSolicViewDescripcion = buildLocalizedString('pedTipoSolicViewFrm', 1);
	}else{
		jsPedTipoSolicViewDescripcion = get('pedTipoSolicViewFrm.Descripcion');
	}
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('pedTipoSolicViewFrm.accion'), 
		get('pedTipoSolicViewFrm.origen'));


	set('pedTipoSolicViewFrm.id', jsPedTipoSolicViewId);
	set('pedTipoSolicViewFrm.codTipoSoli', jsPedTipoSolicViewCodTipoSoli);
	set('pedTipoSolicViewFrm.indCons', jsPedTipoSolicViewIndCons);
	set('pedTipoSolicViewFrm.indSoliNega', jsPedTipoSolicViewIndSoliNega);
	set('pedTipoSolicViewFrm.indDevo', jsPedTipoSolicViewIndDevo);
	set('pedTipoSolicViewFrm.indAnul', jsPedTipoSolicViewIndAnul);
	set('pedTipoSolicViewFrm.codGrupSoli', jsPedTipoSolicViewCodGrupSoli);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('pedTipoSolicViewFrm', 1,  jsPedTipoSolicViewDescripcion)
		loadLocalizationWidget('pedTipoSolicViewFrm', 'Descripcion', 1);
	}else{
		set('pedTipoSolicViewFrm.Descripcion', jsPedTipoSolicViewDescripcion);		
	}
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsPedTipoSolicViewCodTipoSoli = '';
	jsPedTipoSolicViewIndCons = '';
	jsPedTipoSolicViewIndSoliNega = '';
	jsPedTipoSolicViewIndDevo = '';
	jsPedTipoSolicViewIndAnul = '';
	jsPedTipoSolicViewCodGrupSoli = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('pedTipoSolicViewFrm.errCodigo', errorCode);
	set('pedTipoSolicViewFrm.errDescripcion', description);
	set('pedTipoSolicViewFrm.errSeverity', severity);
	fMostrarMensajeError();
}
