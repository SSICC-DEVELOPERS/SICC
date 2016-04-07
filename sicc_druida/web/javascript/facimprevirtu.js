

/*
    INDRA/CAR/mmg
    $Id: facimprevirtu.js,v 1.1 2009/12/03 19:01:56 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsFacImpreVirtuId = "";
var jsFacImpreVirtuCodImpr = "";
var jsFacImpreVirtuDesImpr = "";
var jsFacImpreVirtuTiimOidTipo = "";
var jsFacImpreVirtuIndEstaActi = "";
var jsFacImpreVirtuValAtr1 = "";
var jsFacImpreVirtuValAtr2 = "";
var jsFacImpreVirtuValAtr3 = "";
var jsFacImpreVirtuValAtr4 = "";
var jsFacImpreVirtuValTamaBuff = "";
var jsFacImpreVirtuNumSecu = "";

//Variables de paginacion, 
var facImpreVirtuPageCount = 1;

//Varible de columna que representa el campo de choice
var facImpreVirtuChoiceColumn = 5;

//Flag de siguiente pagina;
var facImpreVirtuMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var facImpreVirtuTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 309;
var sizeFormView = 625;
var sizeFormUpdate = 625;

//Ultima busqueda realizada
var facImpreVirtuLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("facImpreVirtuFrm.codImpr");','focaliza("facImpreVirtuFrm.codImpr");','focaliza("facImpreVirtuFrm.codImpr");','focaliza("facImpreVirtuFrm.codImpr");','focaliza("facImpreVirtuFrm.codImpr");','focaliza("facImpreVirtuFrm.codImpr");'],[3,'focaliza("facImpreVirtuFrm.desImpr");','focaliza("facImpreVirtuFrm.desImpr");','focaliza("facImpreVirtuFrm.desImpr");','focaliza("facImpreVirtuFrm.desImpr");','focaliza("facImpreVirtuFrm.desImpr");','focaliza("facImpreVirtuFrm.desImpr");'],[4,'focalizaComboDependence("facImpreVirtu","tiimOidTipo", false);','focalizaComboDependence("facImpreVirtu","tiimOidTipo", false);','focalizaComboDependence("facImpreVirtu","tiimOidTipo", false);','focalizaComboDependence("facImpreVirtu","tiimOidTipo", true);','focalizaComboDependence("facImpreVirtu","tiimOidTipo", true);','focalizaComboDependence("facImpreVirtu","tiimOidTipo", true);'],[5,'focaliza("facImpreVirtuFrm.indEstaActi");','focaliza("facImpreVirtuFrm.indEstaActi");','focaliza("facImpreVirtuFrm.indEstaActi");','focaliza("facImpreVirtuFrm.indEstaActi");','focaliza("facImpreVirtuFrm.indEstaActi");','focaliza("facImpreVirtuFrm.indEstaActi");'],[6,'focaliza("facImpreVirtuFrm.valAtr1");','focaliza("facImpreVirtuFrm.valAtr1");','focaliza("facImpreVirtuFrm.valAtr1");','focaliza("facImpreVirtuFrm.valAtr1");','focaliza("facImpreVirtuFrm.valAtr1");','focaliza("facImpreVirtuFrm.valAtr1");'],[7,'','focaliza("facImpreVirtuFrm.valAtr2");','focaliza("facImpreVirtuFrm.valAtr2");','','focaliza("facImpreVirtuFrm.valAtr2");','focaliza("facImpreVirtuFrm.valAtr2");'],[8,'','focaliza("facImpreVirtuFrm.valAtr3");','focaliza("facImpreVirtuFrm.valAtr3");','','focaliza("facImpreVirtuFrm.valAtr3");','focaliza("facImpreVirtuFrm.valAtr3");'],[9,'','focaliza("facImpreVirtuFrm.valAtr4");','focaliza("facImpreVirtuFrm.valAtr4");','','focaliza("facImpreVirtuFrm.valAtr4");','focaliza("facImpreVirtuFrm.valAtr4");'],[10,'','focaliza("facImpreVirtuFrm.valTamaBuff");','focaliza("facImpreVirtuFrm.valTamaBuff");','','focaliza("facImpreVirtuFrm.valTamaBuff");','focaliza("facImpreVirtuFrm.valTamaBuff");'],[11,'','focaliza("facImpreVirtuFrm.numSecu");','focaliza("facImpreVirtuFrm.numSecu");','','focaliza("facImpreVirtuFrm.numSecu");','focaliza("facImpreVirtuFrm.numSecu");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[3,'focaliza("facImpreVirtuFrm.desImpr");','focaliza("facImpreVirtuFrm.desImpr");','focaliza("facImpreVirtuFrm.desImpr");','focaliza("facImpreVirtuFrm.desImpr");','focaliza("facImpreVirtuFrm.desImpr");','focaliza("facImpreVirtuFrm.desImpr");'],[4,'focalizaComboDependence("facImpreVirtu","tiimOidTipo", false);','focalizaComboDependence("facImpreVirtu","tiimOidTipo", false);','focalizaComboDependence("facImpreVirtu","tiimOidTipo", false);','focalizaComboDependence("facImpreVirtu","tiimOidTipo", true);','focalizaComboDependence("facImpreVirtu","tiimOidTipo", true);','focalizaComboDependence("facImpreVirtu","tiimOidTipo", true);'],[5,'focaliza("facImpreVirtuFrm.indEstaActi");','focaliza("facImpreVirtuFrm.indEstaActi");','focaliza("facImpreVirtuFrm.indEstaActi");','focaliza("facImpreVirtuFrm.indEstaActi");','focaliza("facImpreVirtuFrm.indEstaActi");','focaliza("facImpreVirtuFrm.indEstaActi");'],[6,'focaliza("facImpreVirtuFrm.valAtr1");','focaliza("facImpreVirtuFrm.valAtr1");','focaliza("facImpreVirtuFrm.valAtr1");','focaliza("facImpreVirtuFrm.valAtr1");','focaliza("facImpreVirtuFrm.valAtr1");','focaliza("facImpreVirtuFrm.valAtr1");'],[7,'','focaliza("facImpreVirtuFrm.valAtr2");','focaliza("facImpreVirtuFrm.valAtr2");','','focaliza("facImpreVirtuFrm.valAtr2");','focaliza("facImpreVirtuFrm.valAtr2");'],[8,'','focaliza("facImpreVirtuFrm.valAtr3");','focaliza("facImpreVirtuFrm.valAtr3");','','focaliza("facImpreVirtuFrm.valAtr3");','focaliza("facImpreVirtuFrm.valAtr3");'],[9,'','focaliza("facImpreVirtuFrm.valAtr4");','focaliza("facImpreVirtuFrm.valAtr4");','','focaliza("facImpreVirtuFrm.valAtr4");','focaliza("facImpreVirtuFrm.valAtr4");'],[10,'','focaliza("facImpreVirtuFrm.valTamaBuff");','focaliza("facImpreVirtuFrm.valTamaBuff");','','focaliza("facImpreVirtuFrm.valTamaBuff");','focaliza("facImpreVirtuFrm.valTamaBuff");'],[11,'','focaliza("facImpreVirtuFrm.numSecu");','focaliza("facImpreVirtuFrm.numSecu");','','focaliza("facImpreVirtuFrm.numSecu");','focaliza("facImpreVirtuFrm.numSecu");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var tiimOidTipoDependeceMap = new Vector();
tiimOidTipoDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
tiimOidTipoDependeceMap.agregar(['tiimOidTipo', padresTmp, '', 'FacTipoImpre']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
facImpreVirtuLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var facImpreVirtuTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function facImpreVirtuInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('facImpreVirtuFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('facImpreVirtuFrm.accion')){
		case "query": facImpreVirtuQueryInitComponents(); break;
		case "view": facImpreVirtuViewInitComponents(); break;
		case "create": facImpreVirtuCreateInitComponents(); break;
		case "update": facImpreVirtuUpdateInitComponents(); break;
		case "remove": facImpreVirtuRemoveInitComponents(); break;
		case "lov": facImpreVirtuLovInitComponents(); break;
	}
	//alert('accion :' + get('facImpreVirtuFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('facImpreVirtuFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('facImpreVirtu')) facImpreVirtuCmdRequery();
}

function facImpreVirtuQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	focusFirstField('facImpreVirtuFrm', true);	
}

function facImpreVirtuViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('facImpreVirtuFrm', true);
}

function facImpreVirtuCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('facImpreVirtuFrm.codImpr','S', GestionarMensaje('FacImpreVirtu.codImpr.requiered.message'));
	
	setMV('facImpreVirtuFrm.desImpr','S', GestionarMensaje('FacImpreVirtu.desImpr.requiered.message'));
	
	setMV('facImpreVirtuFrm.tiimOidTipo','S', GestionarMensaje('FacImpreVirtu.tiimOidTipo.requiered.message'));
	
	setMV('facImpreVirtuFrm.indEstaActi','S', GestionarMensaje('FacImpreVirtu.indEstaActi.requiered.message'));
	
	setMV('facImpreVirtuFrm.valTamaBuff','S', GestionarMensaje('FacImpreVirtu.valTamaBuff.requiered.message'));
	
	setMV('facImpreVirtuFrm.numSecu','S', GestionarMensaje('FacImpreVirtu.numSecu.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('facImpreVirtuFrm', true);
}

function facImpreVirtuUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('facImpreVirtuFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		facImpreVirtuTmpUpdateValues = facImpreVirtuBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('facImpreVirtuFrm.codImpr','S', GestionarMensaje('FacImpreVirtu.codImpr.requiered.message'));
		setMV('facImpreVirtuFrm.desImpr','S', GestionarMensaje('FacImpreVirtu.desImpr.requiered.message'));
		setMV('facImpreVirtuFrm.tiimOidTipo','S', GestionarMensaje('FacImpreVirtu.tiimOidTipo.requiered.message'));
		setMV('facImpreVirtuFrm.indEstaActi','S', GestionarMensaje('FacImpreVirtu.indEstaActi.requiered.message'));
		setMV('facImpreVirtuFrm.valTamaBuff','S', GestionarMensaje('FacImpreVirtu.valTamaBuff.requiered.message'));
		setMV('facImpreVirtuFrm.numSecu','S', GestionarMensaje('FacImpreVirtu.numSecu.requiered.message'));
		
			focusFirstFieldModify('facImpreVirtuFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		focusFirstField('facImpreVirtuFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('facImpreVirtuFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function facImpreVirtuRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	facImpreVirtuList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('facImpreVirtuFrm', true);
}

function facImpreVirtuLovInitComponents(){
	facImpreVirtuLovReturnParameters = window.dialogArguments;
	
	focusFirstField('facImpreVirtuFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad













//Función que permite cargar los datos de un elemento de lov seleccionado
function facImpreVirtuSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('facImpreVirtuFrm.' + campo, id);
	set('facImpreVirtuFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function facImpreVirtuLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	facImpreVirtuLovReturnParameters.id = '';
	facImpreVirtuLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function facImpreVirtuLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(facImpreVirtuList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = facImpreVirtuList.codSeleccionados();
	var descripcion = facImpreVirtuList.extraeDato(
		facImpreVirtuList.codSeleccionados()[0], facImpreVirtuChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	facImpreVirtuLovReturnParameters.id = codigo;
	facImpreVirtuLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function facImpreVirtuCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('facImpreVirtuFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('facImpreVirtuFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "facImpreVirtuList", "FacImpreVirtuConectorTransactionQuery", 
		"result_ROWSET", parametros, "facImpreVirtuPostQueryActions(datos);"]], "", "");	
}

function facImpreVirtuCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('facImpreVirtuFrm.lastQueryToSession'));
	var i =0;
	set('facImpreVirtuFrm.codImpr', paramsRequery.ij(i++));
	
	set('facImpreVirtuFrm.desImpr', paramsRequery.ij(i++));
	
	set('facImpreVirtuFrm.tiimOidTipo', [paramsRequery.ij(i++)]);
	
	set('facImpreVirtuFrm.indEstaActi', [paramsRequery.ij(i++)]);
	
	set('facImpreVirtuFrm.valAtr1', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	facImpreVirtuPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	facImpreVirtuCmdQuery(facImpreVirtuPageCount);
}

function facImpreVirtuFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	facImpreVirtuPageCount = 1;
	facImpreVirtuCmdQuery(facImpreVirtuPageCount);
}

function facImpreVirtuPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != facImpreVirtuLastQuery){
		facImpreVirtuFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	facImpreVirtuPageCount--;
	facImpreVirtuCmdQuery(facImpreVirtuPageCount);
}

function facImpreVirtuNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != facImpreVirtuLastQuery){
		facImpreVirtuFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	facImpreVirtuPageCount++;
	facImpreVirtuCmdQuery(facImpreVirtuPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function facImpreVirtuPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('facImpreVirtuListLayer', 'O');
		visibilidad('facImpreVirtuListButtonsLayer', 'O');
		if(get('facImpreVirtuFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	facImpreVirtuLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	for(var i=0; i < datosTmp.longitud; i++){ 
		switch(datosTmp.ij(i, 4)){
			case '0': datosTmp.ij2(GestionarMensaje('FacImpreVirtu.indEstaActi.0.value'), i, 4); break;
			case '1': datosTmp.ij2(GestionarMensaje('FacImpreVirtu.indEstaActi.1.value'), i, 4); break;
			default: datosTmp .ij2('', i, 4);
		}
	}
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:facImpreVirtuViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, facImpreVirtuChoiceColumn) + "</A>",
			i, facImpreVirtuChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	facImpreVirtuList.setDatos(datosTmp.filtrar([0,1,2,3,4,5],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	facImpreVirtuTimeStamps = datosTmp.filtrar([6],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		facImpreVirtuMorePagesFlag = true;
		facImpreVirtuList.eliminar(mmgPageSize, 1);
	}else{
		facImpreVirtuMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('facImpreVirtuFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('facImpreVirtuListLayer', 'V');
	visibilidad('facImpreVirtuListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('facImpreVirtuList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	facImpreVirtuList.display();
	
	//Actualizamos el estado de los botones 
	if(facImpreVirtuMorePagesFlag){
		set_estado_botonera('facImpreVirtuPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('facImpreVirtuPaginationButtonBar',
			3,"inactivo");
	}
	if(facImpreVirtuPageCount > 1){
		set_estado_botonera('facImpreVirtuPaginationButtonBar',
			2,"activo");
		set_estado_botonera('facImpreVirtuPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('facImpreVirtuPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('facImpreVirtuPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function facImpreVirtuUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(facImpreVirtuList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('facImpreVirtuFrm.idSelection', facImpreVirtuList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('facImpreVirtuFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = facImpreVirtuList.codSeleccionados()[0];
		parametros["previousAction"] = get('facImpreVirtuFrm.accion');
		parametros["accion"] = get('facImpreVirtuFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('FacImpreVirtuLPStartUp', get('facImpreVirtuFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) facImpreVirtuCmdRequery();
	}
}

function facImpreVirtuRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(facImpreVirtuList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = facImpreVirtuList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('facImpreVirtuFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(facImpreVirtuList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += facImpreVirtuTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('facImpreVirtuFrm.timestamp', timestamps);


	facImpreVirtuFrm.oculto='S';
	envia('facImpreVirtuFrm');
	facImpreVirtuFrm.oculto='N';
}

function facImpreVirtuViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(facImpreVirtuList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	facImpreVirtuViewDetail(facImpreVirtuList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function facImpreVirtuViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('facImpreVirtuFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('FacImpreVirtuLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	// splatas - DBLG500000796 - 10/07/2006
	var valAtr1 = get('facImpreVirtuFrm.valAtr1');	
	set('facImpreVirtuFrm.valAtr1', valAtr1);
	
	// splatas - DBLG500000796 - 10/07/2006
	var valAtr2 = get('facImpreVirtuFrm.valAtr2');	
	set('facImpreVirtuFrm.valAtr2', valAtr2);
	
	// splatas - DBLG500000796 - 10/07/2006
	var valAtr3 = get('facImpreVirtuFrm.valAtr3');	
	set('facImpreVirtuFrm.valAtr3', valAtr3);
	
	// splatas - DBLG500000796 - 10/07/2006
	var valAtr4 = get('facImpreVirtuFrm.valAtr4');	
	set('facImpreVirtuFrm.valAtr4', valAtr4);
	
	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('facImpreVirtuFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
	
	
	
	
		
	
	if(validacion){
		facImpreVirtuFrm.oculto='S';
		envia('facImpreVirtuFrm');
		facImpreVirtuFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('facImpreVirtuFrm.tiimOidTipo').toString() == ''){
		set('facImpreVirtuFrm.tiimOidTipo', []);
		mmgResetCombosOnCascade('tiimOidTipo', 'tiimOidTipo', 'facImpreVirtu');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	facImpreVirtuRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('facImpreVirtuFrm.accion');
	var origenTmp = get('facImpreVirtuFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(facImpreVirtuBuildUpdateRecordString() != facImpreVirtuTmpUpdateValues){
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
	document.all.facImpreVirtuListLayer.style.display='none';
	document.all.facImpreVirtuListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.facImpreVirtuListLayer.style.display='';
	document.all.facImpreVirtuListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsFacImpreVirtuCodImpr = get('facImpreVirtuFrm.codImpr').toString();
	jsFacImpreVirtuDesImpr = get('facImpreVirtuFrm.desImpr').toString();
	jsFacImpreVirtuTiimOidTipo = get('facImpreVirtuFrm.tiimOidTipo')[0];
	jsFacImpreVirtuIndEstaActi = get('facImpreVirtuFrm.indEstaActi')[0];
	jsFacImpreVirtuValAtr1 = get('facImpreVirtuFrm.valAtr1').toString();
	
	
	var parametros = "";
	parametros += jsFacImpreVirtuCodImpr + "|";
	parametros += jsFacImpreVirtuDesImpr + "|";
	parametros += jsFacImpreVirtuTiimOidTipo + "|";
	parametros += jsFacImpreVirtuIndEstaActi + "|";
	parametros += jsFacImpreVirtuValAtr1 + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function facImpreVirtuBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsFacImpreVirtuCodImpr + "|";
	parametros += jsFacImpreVirtuDesImpr + "|";
	parametros += jsFacImpreVirtuTiimOidTipo + "|";
	parametros += jsFacImpreVirtuIndEstaActi + "|";
	parametros += jsFacImpreVirtuValAtr1 + "|";
	parametros += jsFacImpreVirtuValAtr2 + "|";
	parametros += jsFacImpreVirtuValAtr3 + "|";
	parametros += jsFacImpreVirtuValAtr4 + "|";
	parametros += jsFacImpreVirtuValTamaBuff + "|";
	parametros += jsFacImpreVirtuNumSecu + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('facImpreVirtuFrm.accion'), 
		get('facImpreVirtuFrm.origen'));
	
	jsFacImpreVirtuId = get('facImpreVirtuFrm.id').toString();
	jsFacImpreVirtuCodImpr = get('facImpreVirtuFrm.codImpr').toString();
	jsFacImpreVirtuDesImpr = get('facImpreVirtuFrm.desImpr').toString();
	jsFacImpreVirtuTiimOidTipo = get('facImpreVirtuFrm.tiimOidTipo')[0];
	jsFacImpreVirtuIndEstaActi = get('facImpreVirtuFrm.indEstaActi')[0];
	jsFacImpreVirtuValAtr1 = get('facImpreVirtuFrm.valAtr1').toString();
	jsFacImpreVirtuValAtr2 = get('facImpreVirtuFrm.valAtr2').toString();
	jsFacImpreVirtuValAtr3 = get('facImpreVirtuFrm.valAtr3').toString();
	jsFacImpreVirtuValAtr4 = get('facImpreVirtuFrm.valAtr4').toString();
	jsFacImpreVirtuValTamaBuff = get('facImpreVirtuFrm.valTamaBuff').toString();
	jsFacImpreVirtuNumSecu = get('facImpreVirtuFrm.numSecu')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('facImpreVirtuFrm.accion'), 
		get('facImpreVirtuFrm.origen'));


	set('facImpreVirtuFrm.id', jsFacImpreVirtuId);
	set('facImpreVirtuFrm.codImpr', jsFacImpreVirtuCodImpr);
	set('facImpreVirtuFrm.desImpr', jsFacImpreVirtuDesImpr);
	set('facImpreVirtuFrm.tiimOidTipo', [jsFacImpreVirtuTiimOidTipo]);
	set('facImpreVirtuFrm.indEstaActi', [jsFacImpreVirtuIndEstaActi]);
	set('facImpreVirtuFrm.valAtr1', jsFacImpreVirtuValAtr1);
	set('facImpreVirtuFrm.valAtr2', jsFacImpreVirtuValAtr2);
	set('facImpreVirtuFrm.valAtr3', jsFacImpreVirtuValAtr3);
	set('facImpreVirtuFrm.valAtr4', jsFacImpreVirtuValAtr4);
	set('facImpreVirtuFrm.valTamaBuff', jsFacImpreVirtuValTamaBuff);
	set('facImpreVirtuFrm.numSecu', [jsFacImpreVirtuNumSecu]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsFacImpreVirtuCodImpr = '';
	jsFacImpreVirtuDesImpr = '';
	jsFacImpreVirtuTiimOidTipo = '';
	jsFacImpreVirtuIndEstaActi = '';
	jsFacImpreVirtuValAtr1 = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('facImpreVirtuFrm.errCodigo', errorCode);
	set('facImpreVirtuFrm.errDescripcion', description);
	set('facImpreVirtuFrm.errSeverity', severity);
	fMostrarMensajeError();
}
