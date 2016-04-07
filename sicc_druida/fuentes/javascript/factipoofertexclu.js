

/*
    INDRA/CAR/mmg
    $Id: factipoofertexclu.js,v 1.1 2009/12/03 19:01:31 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsFacTipoOfertExcluId = "";
var jsFacTipoOfertExcluPaisOidPais = "";
var jsFacTipoOfertExcluFecDesd = "";
var jsFacTipoOfertExcluFecHast = "";
var jsFacTipoOfertExcluTofeOidTipoOfer = "";

//Variables de paginacion, 
var facTipoOfertExcluPageCount = 1;

//Varible de columna que representa el campo de choice
var facTipoOfertExcluChoiceColumn = 3;

//Flag de siguiente pagina;
var facTipoOfertExcluMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var facTipoOfertExcluTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 189;
var sizeFormView = 221;
var sizeFormUpdate = 175;

//Ultima busqueda realizada
var facTipoOfertExcluLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[3,'focaliza("facTipoOfertExcluFrm.fecDesd");','focaliza("facTipoOfertExcluFrm.fecDesd");','focaliza("facTipoOfertExcluFrm.fecDesd");','focaliza("facTipoOfertExcluFrm.fecDesd");','focaliza("facTipoOfertExcluFrm.fecDesd");','focaliza("facTipoOfertExcluFrm.fecDesd");'],[4,'focaliza("facTipoOfertExcluFrm.fecHast");','focaliza("facTipoOfertExcluFrm.fecHast");','focaliza("facTipoOfertExcluFrm.fecHast");','focaliza("facTipoOfertExcluFrm.fecHast");','focaliza("facTipoOfertExcluFrm.fecHast");','focaliza("facTipoOfertExcluFrm.fecHast");'],[5,'focalizaComboDependence("facTipoOfertExclu","tofeOidTipoOfer", false);','focalizaComboDependence("facTipoOfertExclu","tofeOidTipoOfer", false);','focalizaComboDependence("facTipoOfertExclu","tofeOidTipoOfer", false);','focalizaComboDependence("facTipoOfertExclu","tofeOidTipoOfer", true);','focalizaComboDependence("facTipoOfertExclu","tofeOidTipoOfer", true);','focalizaComboDependence("facTipoOfertExclu","tofeOidTipoOfer", true);']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[3,'focaliza("facTipoOfertExcluFrm.fecDesd");','focaliza("facTipoOfertExcluFrm.fecDesd");','focaliza("facTipoOfertExcluFrm.fecDesd");','focaliza("facTipoOfertExcluFrm.fecDesd");','focaliza("facTipoOfertExcluFrm.fecDesd");','focaliza("facTipoOfertExcluFrm.fecDesd");'],[4,'focaliza("facTipoOfertExcluFrm.fecHast");','focaliza("facTipoOfertExcluFrm.fecHast");','focaliza("facTipoOfertExcluFrm.fecHast");','focaliza("facTipoOfertExcluFrm.fecHast");','focaliza("facTipoOfertExcluFrm.fecHast");','focaliza("facTipoOfertExcluFrm.fecHast");'],[5,'focalizaComboDependence("facTipoOfertExclu","tofeOidTipoOfer", false);','focalizaComboDependence("facTipoOfertExclu","tofeOidTipoOfer", false);','focalizaComboDependence("facTipoOfertExclu","tofeOidTipoOfer", false);','focalizaComboDependence("facTipoOfertExclu","tofeOidTipoOfer", true);','focalizaComboDependence("facTipoOfertExclu","tofeOidTipoOfer", true);','focalizaComboDependence("facTipoOfertExclu","tofeOidTipoOfer", true);']]);

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
var tofeOidTipoOferDependeceMap = new Vector();
tofeOidTipoOferDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
tofeOidTipoOferDependeceMap.agregar(['tofeOidTipoOfer_canaOidCana', padresTmp, 'tofeOidTipoOfer', 'SegCanalView']);
padresTmp =  new Vector();
padresTmp.cargar(['tofeOidTipoOfer_canaOidCana'])
tofeOidTipoOferDependeceMap.agregar(['tofeOidTipoOfer', padresTmp, '', 'PreTipoOfert']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
facTipoOfertExcluLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var facTipoOfertExcluTmpUpdateValues;


		//funcion para fecHast y su validación con fecDesd
		function validacionfecHastfecDesd(){
			if ((get('facTipoOfertExcluFrm.fecHast','T').toString()=="") || 
			(get('facTipoOfertExcluFrm.fecDesd','T').toString()==""))
				//en este caso no hay alguno de los valores introducidos y no se puede realizar la verificación.
				return 'OK';
			
				var errorLevel = EsFechaValida(get('facTipoOfertExcluFrm.fecDesd','T') ,get('facTipoOfertExcluFrm.fecHast','T') , "facTipoOfertExcluFrm", "N");
				
			
			if ( errorLevel == 3){
			     return GestionarMensaje("FacTipoOfertExclu.fecHastfecDesd.message");
			}else
			     return 'OK';
		}
		

//Función ejecutada en el onload de la pagina
function facTipoOfertExcluInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('facTipoOfertExcluFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('facTipoOfertExcluFrm.accion')){
		case "query": facTipoOfertExcluQueryInitComponents(); break;
		case "view": facTipoOfertExcluViewInitComponents(); break;
		case "create": facTipoOfertExcluCreateInitComponents(); break;
		case "update": facTipoOfertExcluUpdateInitComponents(); break;
		case "remove": facTipoOfertExcluRemoveInitComponents(); break;
		case "lov": facTipoOfertExcluLovInitComponents(); break;
	}
	//alert('accion :' + get('facTipoOfertExcluFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('facTipoOfertExcluFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('facTipoOfertExclu')) facTipoOfertExcluCmdRequery();

		//Seteamos en el load los valores por default de combos estructurales
	var entityFormName = 'facTipoOfertExclu';
	var comboEntityName;
	var comboRealName;
	var valorDefault; 
	
			comboEntityName = '';
			comboRealName   = '';
			valorDefault    = '';
			comboEntityName = 'SegPais';
			
			comboRealName   = 'paisOidPais';
			valorDefault    = mmgGetStructuralEntityDefaultValue(entityFormName, comboEntityName);
			if(valorDefault != null || valorDefault != '') set(entityFormName + "Frm." + comboRealName, [1]);


}

function facTipoOfertExcluQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	focusFirstField('facTipoOfertExcluFrm', true);	
}

function facTipoOfertExcluViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('facTipoOfertExcluFrm', true);
}

function facTipoOfertExcluCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('facTipoOfertExcluFrm.paisOidPais','S', GestionarMensaje('FacTipoOfertExclu.paisOidPais.requiered.message'));
	
	setMV('facTipoOfertExcluFrm.fecDesd','S', GestionarMensaje('FacTipoOfertExclu.fecDesd.requiered.message'));
	
	setMV('facTipoOfertExcluFrm.fecHast','S', GestionarMensaje('FacTipoOfertExclu.fecHast.requiered.message'));
	
	setMV('facTipoOfertExcluFrm.tofeOidTipoOfer','S', GestionarMensaje('FacTipoOfertExclu.tofeOidTipoOfer.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('facTipoOfertExcluFrm', true);
}

function facTipoOfertExcluUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('facTipoOfertExcluFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		facTipoOfertExcluTmpUpdateValues = facTipoOfertExcluBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('facTipoOfertExcluFrm.fecDesd','S', GestionarMensaje('FacTipoOfertExclu.fecDesd.requiered.message'));
		setMV('facTipoOfertExcluFrm.fecHast','S', GestionarMensaje('FacTipoOfertExclu.fecHast.requiered.message'));
		setMV('facTipoOfertExcluFrm.tofeOidTipoOfer','S', GestionarMensaje('FacTipoOfertExclu.tofeOidTipoOfer.requiered.message'));
		
			focusFirstFieldModify('facTipoOfertExcluFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		focusFirstField('facTipoOfertExcluFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('facTipoOfertExcluFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function facTipoOfertExcluRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	facTipoOfertExcluList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('facTipoOfertExcluFrm', true);
}

function facTipoOfertExcluLovInitComponents(){
	facTipoOfertExcluLovReturnParameters = window.dialogArguments;
	
	focusFirstField('facTipoOfertExcluFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad







//Función que permite cargar los datos de un elemento de lov seleccionado
function facTipoOfertExcluSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('facTipoOfertExcluFrm.' + campo, id);
	set('facTipoOfertExcluFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function facTipoOfertExcluLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	facTipoOfertExcluLovReturnParameters.id = '';
	facTipoOfertExcluLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function facTipoOfertExcluLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(facTipoOfertExcluList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = facTipoOfertExcluList.codSeleccionados();
	var descripcion = facTipoOfertExcluList.extraeDato(
		facTipoOfertExcluList.codSeleccionados()[0], facTipoOfertExcluChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	facTipoOfertExcluLovReturnParameters.id = codigo;
	facTipoOfertExcluLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function facTipoOfertExcluCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('facTipoOfertExcluFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('facTipoOfertExcluFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "facTipoOfertExcluList", "FacTipoOfertExcluConectorTransactionQuery", 
		"result_ROWSET", parametros, "facTipoOfertExcluPostQueryActions(datos);"]], "", "");	
}

function facTipoOfertExcluCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('facTipoOfertExcluFrm.lastQueryToSession'));
	var i =0;
	set('facTipoOfertExcluFrm.fecDesd', paramsRequery.ij(i++));
	
	set('facTipoOfertExcluFrm.fecHast', paramsRequery.ij(i++));
	
	set('facTipoOfertExcluFrm.tofeOidTipoOfer', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la página de busqueda como la actual
	facTipoOfertExcluPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	facTipoOfertExcluCmdQuery(facTipoOfertExcluPageCount);
}

function facTipoOfertExcluFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	facTipoOfertExcluPageCount = 1;
	facTipoOfertExcluCmdQuery(facTipoOfertExcluPageCount);
}

function facTipoOfertExcluPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != facTipoOfertExcluLastQuery){
		facTipoOfertExcluFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	facTipoOfertExcluPageCount--;
	facTipoOfertExcluCmdQuery(facTipoOfertExcluPageCount);
}

function facTipoOfertExcluNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != facTipoOfertExcluLastQuery){
		facTipoOfertExcluFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	facTipoOfertExcluPageCount++;
	facTipoOfertExcluCmdQuery(facTipoOfertExcluPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function facTipoOfertExcluPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('facTipoOfertExcluListLayer', 'O');
		visibilidad('facTipoOfertExcluListButtonsLayer', 'O');
		if(get('facTipoOfertExcluFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	facTipoOfertExcluLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:facTipoOfertExcluViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, facTipoOfertExcluChoiceColumn) + "</A>",
			i, facTipoOfertExcluChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	facTipoOfertExcluList.setDatos(datosTmp.filtrar([0,1,2,3],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	facTipoOfertExcluTimeStamps = datosTmp.filtrar([4],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		facTipoOfertExcluMorePagesFlag = true;
		facTipoOfertExcluList.eliminar(mmgPageSize, 1);
	}else{
		facTipoOfertExcluMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('facTipoOfertExcluFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('facTipoOfertExcluListLayer', 'V');
	visibilidad('facTipoOfertExcluListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('facTipoOfertExcluList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	facTipoOfertExcluList.display();
	
	//Actualizamos el estado de los botones 
	if(facTipoOfertExcluMorePagesFlag){
		set_estado_botonera('facTipoOfertExcluPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('facTipoOfertExcluPaginationButtonBar',
			3,"inactivo");
	}
	if(facTipoOfertExcluPageCount > 1){
		set_estado_botonera('facTipoOfertExcluPaginationButtonBar',
			2,"activo");
		set_estado_botonera('facTipoOfertExcluPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('facTipoOfertExcluPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('facTipoOfertExcluPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function facTipoOfertExcluUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(facTipoOfertExcluList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('facTipoOfertExcluFrm.idSelection', facTipoOfertExcluList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('facTipoOfertExcluFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = facTipoOfertExcluList.codSeleccionados()[0];
		parametros["previousAction"] = get('facTipoOfertExcluFrm.accion');
		parametros["accion"] = get('facTipoOfertExcluFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('FacTipoOfertExcluLPStartUp', get('facTipoOfertExcluFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) facTipoOfertExcluCmdRequery();
	}
}

function facTipoOfertExcluRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(facTipoOfertExcluList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = facTipoOfertExcluList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('facTipoOfertExcluFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(facTipoOfertExcluList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += facTipoOfertExcluTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('facTipoOfertExcluFrm.timestamp', timestamps);


	facTipoOfertExcluFrm.oculto='S';
	envia('facTipoOfertExcluFrm');
	facTipoOfertExcluFrm.oculto='N';
}

function facTipoOfertExcluViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(facTipoOfertExcluList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	facTipoOfertExcluViewDetail(facTipoOfertExcluList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function facTipoOfertExcluViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('facTipoOfertExcluFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('FacTipoOfertExcluLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('facTipoOfertExcluFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
		
	
	if(validacion){
		facTipoOfertExcluFrm.oculto='S';
		envia('facTipoOfertExcluFrm');
		facTipoOfertExcluFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('facTipoOfertExcluFrm.paisOidPais').toString() == ''){
		set('facTipoOfertExcluFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'facTipoOfertExclu');
		
	}
	if(get('facTipoOfertExcluFrm.tofeOidTipoOfer').toString() == ''){
		set('facTipoOfertExcluFrm.tofeOidTipoOfer_canaOidCana', []);
		mmgResetCombosOnCascade('tofeOidTipoOfer_canaOidCana', 'tofeOidTipoOfer', 'facTipoOfertExclu');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	facTipoOfertExcluRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('facTipoOfertExcluFrm.accion');
	var origenTmp = get('facTipoOfertExcluFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(facTipoOfertExcluBuildUpdateRecordString() != facTipoOfertExcluTmpUpdateValues){
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
	document.all.facTipoOfertExcluListLayer.style.display='none';
	document.all.facTipoOfertExcluListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.facTipoOfertExcluListLayer.style.display='';
	document.all.facTipoOfertExcluListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsFacTipoOfertExcluFecDesd = get('facTipoOfertExcluFrm.fecDesd').toString();
	jsFacTipoOfertExcluFecHast = get('facTipoOfertExcluFrm.fecHast').toString();
	jsFacTipoOfertExcluTofeOidTipoOfer = get('facTipoOfertExcluFrm.tofeOidTipoOfer')[0];
	
	
	var parametros = "";
	parametros += jsFacTipoOfertExcluFecDesd + "|";
	parametros += jsFacTipoOfertExcluFecHast + "|";
	parametros += jsFacTipoOfertExcluTofeOidTipoOfer + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function facTipoOfertExcluBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsFacTipoOfertExcluFecDesd + "|";
	parametros += jsFacTipoOfertExcluFecHast + "|";
	parametros += jsFacTipoOfertExcluTofeOidTipoOfer + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('facTipoOfertExcluFrm.accion'), 
		get('facTipoOfertExcluFrm.origen'));
	
	jsFacTipoOfertExcluId = get('facTipoOfertExcluFrm.id').toString();
	jsFacTipoOfertExcluPaisOidPais = get('facTipoOfertExcluFrm.paisOidPais')[0];
	jsFacTipoOfertExcluFecDesd = get('facTipoOfertExcluFrm.fecDesd').toString();
	jsFacTipoOfertExcluFecHast = get('facTipoOfertExcluFrm.fecHast').toString();
	jsFacTipoOfertExcluTofeOidTipoOfer = get('facTipoOfertExcluFrm.tofeOidTipoOfer')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('facTipoOfertExcluFrm.accion'), 
		get('facTipoOfertExcluFrm.origen'));


	set('facTipoOfertExcluFrm.id', jsFacTipoOfertExcluId);
	set('facTipoOfertExcluFrm.paisOidPais', [jsFacTipoOfertExcluPaisOidPais]);
	set('facTipoOfertExcluFrm.fecDesd', jsFacTipoOfertExcluFecDesd);
	set('facTipoOfertExcluFrm.fecHast', jsFacTipoOfertExcluFecHast);
	set('facTipoOfertExcluFrm.tofeOidTipoOfer', [jsFacTipoOfertExcluTofeOidTipoOfer]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsFacTipoOfertExcluFecDesd = '';
	jsFacTipoOfertExcluFecHast = '';
	jsFacTipoOfertExcluTofeOidTipoOfer = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('facTipoOfertExcluFrm.errCodigo', errorCode);
	set('facTipoOfertExcluFrm.errDescripcion', description);
	set('facTipoOfertExcluFrm.errSeverity', severity);
	fMostrarMensajeError();
}
