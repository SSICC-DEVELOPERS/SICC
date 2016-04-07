

/*
    INDRA/CAR/mmg
    $Id: cccparamconta.js,v 1.1 2009/12/03 19:01:41 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsCccParamContaId = "";
var jsCccParamContaSubpOidSubp = "";
var jsCccParamContaValDebeHabe = "";
var jsCccParamContaValObteCuen = "";
var jsCccParamContaCucoOidCuenContDire = "";
var jsCccParamContaValTextApun = "";
var jsCccParamContaIndConcFech = "";
var jsCccParamContaValObse = "";

//Variables de paginacion, 
var cccParamContaPageCount = 1;

//Varible de columna que representa el campo de choice
var cccParamContaChoiceColumn = 4;

//Flag de siguiente pagina;
var cccParamContaMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var cccParamContaTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 105;
var sizeFormView = 175;
var sizeFormUpdate = 175;

//Ultima busqueda realizada
var cccParamContaLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[3,'focalizaComboDependence("cccParamConta","subpOidSubp", false);','focalizaComboDependence("cccParamConta","subpOidSubp", false);','focalizaComboDependence("cccParamConta","subpOidSubp", false);','focalizaComboDependence("cccParamConta","subpOidSubp", true);','focalizaComboDependence("cccParamConta","subpOidSubp", true);','focalizaComboDependence("cccParamConta","subpOidSubp", true);'],[4,'focaliza("cccParamContaFrm.valDebeHabe");','focaliza("cccParamContaFrm.valDebeHabe");','focaliza("cccParamContaFrm.valDebeHabe");','focaliza("cccParamContaFrm.valDebeHabe");','focaliza("cccParamContaFrm.valDebeHabe");','focaliza("cccParamContaFrm.valDebeHabe");'],[5,'','focaliza("cccParamContaFrm.valObteCuen");','focaliza("cccParamContaFrm.valObteCuen");','','focaliza("cccParamContaFrm.valObteCuen");','focaliza("cccParamContaFrm.valObteCuen");'],[6,'','focalizaComboDependence("cccParamConta","cucoOidCuenContDire", false);','focalizaComboDependence("cccParamConta","cucoOidCuenContDire", false);','','focalizaComboDependence("cccParamConta","cucoOidCuenContDire", true);','focalizaComboDependence("cccParamConta","cucoOidCuenContDire", true);'],[7,'','focaliza("cccParamContaFrm.valTextApun");','focaliza("cccParamContaFrm.valTextApun");','','focaliza("cccParamContaFrm.valTextApun");','focaliza("cccParamContaFrm.valTextApun");'],[8,'','focaliza("cccParamContaFrm.indConcFech");','focaliza("cccParamContaFrm.indConcFech");','','focaliza("cccParamContaFrm.indConcFech");','focaliza("cccParamContaFrm.indConcFech");'],[9,'','','','','','']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[3,'focalizaComboDependence("cccParamConta","subpOidSubp", false);','focalizaComboDependence("cccParamConta","subpOidSubp", false);','focalizaComboDependence("cccParamConta","subpOidSubp", false);','focalizaComboDependence("cccParamConta","subpOidSubp", true);','focalizaComboDependence("cccParamConta","subpOidSubp", true);','focalizaComboDependence("cccParamConta","subpOidSubp", true);'],[4,'focaliza("cccParamContaFrm.valDebeHabe");','focaliza("cccParamContaFrm.valDebeHabe");','focaliza("cccParamContaFrm.valDebeHabe");','focaliza("cccParamContaFrm.valDebeHabe");','focaliza("cccParamContaFrm.valDebeHabe");','focaliza("cccParamContaFrm.valDebeHabe");'],[5,'','focaliza("cccParamContaFrm.valObteCuen");','focaliza("cccParamContaFrm.valObteCuen");','','focaliza("cccParamContaFrm.valObteCuen");','focaliza("cccParamContaFrm.valObteCuen");'],[6,'','focalizaComboDependence("cccParamConta","cucoOidCuenContDire", false);','focalizaComboDependence("cccParamConta","cucoOidCuenContDire", false);','','focalizaComboDependence("cccParamConta","cucoOidCuenContDire", true);','focalizaComboDependence("cccParamConta","cucoOidCuenContDire", true);'],[7,'','focaliza("cccParamContaFrm.valTextApun");','focaliza("cccParamContaFrm.valTextApun");','','focaliza("cccParamContaFrm.valTextApun");','focaliza("cccParamContaFrm.valTextApun");'],[8,'','focaliza("cccParamContaFrm.indConcFech");','focaliza("cccParamContaFrm.indConcFech");','','focaliza("cccParamContaFrm.indConcFech");','focaliza("cccParamContaFrm.indConcFech");'],[9,'','','','','','']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var subpOidSubpDependeceMap = new Vector();
subpOidSubpDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
subpOidSubpDependeceMap.agregar(['subpOidSubp_ccprOidProc', padresTmp, 'subpOidSubp', 'CccProce']);
padresTmp =  new Vector();
padresTmp.cargar(['subpOidSubp_ccprOidProc'])
subpOidSubpDependeceMap.agregar(['subpOidSubp', padresTmp, '', 'CccSubpr']);
var cucoOidCuenContDireDependeceMap = new Vector();
cucoOidCuenContDireDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
cucoOidCuenContDireDependeceMap.agregar(['cucoOidCuenContDire', padresTmp, '', 'CccCuentContaView']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
cccParamContaLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var cccParamContaTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function cccParamContaInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('cccParamContaFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('cccParamContaFrm.accion')){
		case "query": cccParamContaQueryInitComponents(); break;
		case "view": cccParamContaViewInitComponents(); break;
		case "create": cccParamContaCreateInitComponents(); break;
		case "update": cccParamContaUpdateInitComponents(); break;
		case "remove": cccParamContaRemoveInitComponents(); break;
		case "lov": cccParamContaLovInitComponents(); break;
	}
	//alert('accion :' + get('cccParamContaFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('cccParamContaFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('cccParamConta')) cccParamContaCmdRequery();
}

function cccParamContaQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	focusFirstField('cccParamContaFrm', true);	
}

function cccParamContaViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	//Establecemos el valor de los radiobuttons
		set('cccParamContaFrm.valDebeHabe', get('cccParamContaFrm.valDebeHabeCheckValue'));
		set('cccParamContaFrm.indConcFech', get('cccParamContaFrm.indConcFechCheckValue'));
		
	focusFirstField('cccParamContaFrm', true);
}

function cccParamContaCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('cccParamContaFrm.subpOidSubp','S', GestionarMensaje('CccParamConta.subpOidSubp.requiered.message'));
	
	setMV('cccParamContaFrm.valDebeHabe','S', GestionarMensaje('CccParamConta.valDebeHabe.requiered.message'));
	
	setMV('cccParamContaFrm.valTextApun','S', GestionarMensaje('CccParamConta.valTextApun.requiered.message'));
	
	setMV('cccParamContaFrm.indConcFech','S', GestionarMensaje('CccParamConta.indConcFech.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('cccParamContaFrm', true);
}

function cccParamContaUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('cccParamContaFrm.origen') == "pagina"){
		

		//Establecemos el valor de los radiobuttons
			set('cccParamContaFrm.valDebeHabe', get('cccParamContaFrm.valDebeHabeCheckValue'));
			set('cccParamContaFrm.indConcFech', get('cccParamContaFrm.indConcFechCheckValue'));
			

		//Registramos el valor del elemento que estamos modificando
		cccParamContaTmpUpdateValues = cccParamContaBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('cccParamContaFrm.subpOidSubp','S', GestionarMensaje('CccParamConta.subpOidSubp.requiered.message'));
		setMV('cccParamContaFrm.valDebeHabe','S', GestionarMensaje('CccParamConta.valDebeHabe.requiered.message'));
		setMV('cccParamContaFrm.valTextApun','S', GestionarMensaje('CccParamConta.valTextApun.requiered.message'));
		setMV('cccParamContaFrm.indConcFech','S', GestionarMensaje('CccParamConta.indConcFech.requiered.message'));
		
			focusFirstFieldModify('cccParamContaFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		focusFirstField('cccParamContaFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('cccParamContaFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function cccParamContaRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	cccParamContaList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('cccParamContaFrm', true);
}

function cccParamContaLovInitComponents(){
	cccParamContaLovReturnParameters = window.dialogArguments;
	
	focusFirstField('cccParamContaFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad










//Función que permite cargar los datos de un elemento de lov seleccionado
function cccParamContaSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('cccParamContaFrm.' + campo, id);
	set('cccParamContaFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function cccParamContaLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	cccParamContaLovReturnParameters.id = '';
	cccParamContaLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function cccParamContaLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cccParamContaList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = cccParamContaList.codSeleccionados();
	var descripcion = cccParamContaList.extraeDato(
		cccParamContaList.codSeleccionados()[0], cccParamContaChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	cccParamContaLovReturnParameters.id = codigo;
	cccParamContaLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function cccParamContaCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('cccParamContaFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('cccParamContaFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "cccParamContaList", "CccParamContaConectorTransactionQuery", 
		"result_ROWSET", parametros, "cccParamContaPostQueryActions(datos);"]], "", "");	
}

function cccParamContaCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('cccParamContaFrm.lastQueryToSession'));
	var i =0;
	set('cccParamContaFrm.subpOidSubp', [paramsRequery.ij(i++)]);
	
	set('cccParamContaFrm.valDebeHabe', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	cccParamContaPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	cccParamContaCmdQuery(cccParamContaPageCount);
}

function cccParamContaFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	cccParamContaPageCount = 1;
	cccParamContaCmdQuery(cccParamContaPageCount);
}

function cccParamContaPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != cccParamContaLastQuery){
		cccParamContaFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	cccParamContaPageCount--;
	cccParamContaCmdQuery(cccParamContaPageCount);
}

function cccParamContaNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != cccParamContaLastQuery){
		cccParamContaFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	cccParamContaPageCount++;
	cccParamContaCmdQuery(cccParamContaPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function cccParamContaPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('cccParamContaListLayer', 'O');
		visibilidad('cccParamContaListButtonsLayer', 'O');
		if(get('cccParamContaFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	cccParamContaLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	for(var i=0; i < datosTmp.longitud; i++){ 
		switch(datosTmp.ij(i, 2)){
			case 'D': datosTmp.ij2(GestionarMensaje('CccParamConta.valDebeHabe.D.value'), i, 2); break;
			case 'H': datosTmp.ij2(GestionarMensaje('CccParamConta.valDebeHabe.H.value'), i, 2); break;
			default: datosTmp .ij2('', i, 2);
		}
	}
	for(var i=0; i < datosTmp.longitud; i++){ 
		switch(datosTmp.ij(i, 3)){
			case 'D': datosTmp.ij2(GestionarMensaje('CccParamConta.valObteCuen.D.value'), i, 3); break;
			case 'B': datosTmp.ij2(GestionarMensaje('CccParamConta.valObteCuen.B.value'), i, 3); break;
			case 'P': datosTmp.ij2(GestionarMensaje('CccParamConta.valObteCuen.P.value'), i, 3); break;
			case 'T': datosTmp.ij2(GestionarMensaje('CccParamConta.valObteCuen.T.value'), i, 3); break;
			case 'C': datosTmp.ij2(GestionarMensaje('CccParamConta.valObteCuen.C.value'), i, 3); break;
			case 'N': datosTmp.ij2(GestionarMensaje('CccParamConta.valObteCuen.N.value'), i, 3); break;
			default: datosTmp .ij2('', i, 3);
		}
	}
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:cccParamContaViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, cccParamContaChoiceColumn) + "</A>",
			i, cccParamContaChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	cccParamContaList.setDatos(datosTmp.filtrar([0,1,2,3,4],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	cccParamContaTimeStamps = datosTmp.filtrar([5],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		cccParamContaMorePagesFlag = true;
		cccParamContaList.eliminar(mmgPageSize, 1);
	}else{
		cccParamContaMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('cccParamContaFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('cccParamContaListLayer', 'V');
	visibilidad('cccParamContaListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('cccParamContaList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	cccParamContaList.display();
	
	//Actualizamos el estado de los botones 
	if(cccParamContaMorePagesFlag){
		set_estado_botonera('cccParamContaPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('cccParamContaPaginationButtonBar',
			3,"inactivo");
	}
	if(cccParamContaPageCount > 1){
		set_estado_botonera('cccParamContaPaginationButtonBar',
			2,"activo");
		set_estado_botonera('cccParamContaPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('cccParamContaPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('cccParamContaPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function cccParamContaUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cccParamContaList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('cccParamContaFrm.idSelection', cccParamContaList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('cccParamContaFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = cccParamContaList.codSeleccionados()[0];
		parametros["previousAction"] = get('cccParamContaFrm.accion');
		parametros["accion"] = get('cccParamContaFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('CccParamContaLPStartUp', get('cccParamContaFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) cccParamContaCmdRequery();
	}
}

function cccParamContaRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cccParamContaList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = cccParamContaList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('cccParamContaFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(cccParamContaList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += cccParamContaTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('cccParamContaFrm.timestamp', timestamps);


	cccParamContaFrm.oculto='S';
	envia('cccParamContaFrm');
	cccParamContaFrm.oculto='N';
}

function cccParamContaViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cccParamContaList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	cccParamContaViewDetail(cccParamContaList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function cccParamContaViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('cccParamContaFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('CccParamContaLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('cccParamContaFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
	
		
	
	if(validacion){
		cccParamContaFrm.oculto='S';
		envia('cccParamContaFrm');
		cccParamContaFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('cccParamContaFrm.subpOidSubp').toString() == ''){
		set('cccParamContaFrm.subpOidSubp_ccprOidProc', []);
		mmgResetCombosOnCascade('subpOidSubp_ccprOidProc', 'subpOidSubp', 'cccParamConta');
		
	}
	if(get('cccParamContaFrm.cucoOidCuenContDire').toString() == ''){
		set('cccParamContaFrm.cucoOidCuenContDire', []);
		mmgResetCombosOnCascade('cucoOidCuenContDire', 'cucoOidCuenContDire', 'cccParamConta');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	cccParamContaRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('cccParamContaFrm.accion');
	var origenTmp = get('cccParamContaFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(cccParamContaBuildUpdateRecordString() != cccParamContaTmpUpdateValues){
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
	document.all.cccParamContaListLayer.style.display='none';
	document.all.cccParamContaListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.cccParamContaListLayer.style.display='';
	document.all.cccParamContaListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsCccParamContaSubpOidSubp = get('cccParamContaFrm.subpOidSubp')[0];
	jsCccParamContaValDebeHabe = get('cccParamContaFrm.valDebeHabe');
	
	
	var parametros = "";
	parametros += jsCccParamContaSubpOidSubp + "|";
	parametros += jsCccParamContaValDebeHabe + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function cccParamContaBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsCccParamContaSubpOidSubp + "|";
	parametros += jsCccParamContaValDebeHabe + "|";
	parametros += jsCccParamContaValObteCuen + "|";
	parametros += jsCccParamContaCucoOidCuenContDire + "|";
	parametros += jsCccParamContaValTextApun + "|";
	parametros += jsCccParamContaIndConcFech + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('cccParamContaFrm.accion'), 
		get('cccParamContaFrm.origen'));
	
	jsCccParamContaId = get('cccParamContaFrm.id').toString();
	jsCccParamContaSubpOidSubp = get('cccParamContaFrm.subpOidSubp')[0];
	jsCccParamContaValDebeHabe = get('cccParamContaFrm.valDebeHabe');
	jsCccParamContaValObteCuen = get('cccParamContaFrm.valObteCuen')[0];
	jsCccParamContaCucoOidCuenContDire = get('cccParamContaFrm.cucoOidCuenContDire')[0];
	jsCccParamContaValTextApun = get('cccParamContaFrm.valTextApun').toString();
	jsCccParamContaIndConcFech = get('cccParamContaFrm.indConcFech');
	jsCccParamContaValObse = get('cccParamContaFrm.valObse').toString();
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('cccParamContaFrm.accion'), 
		get('cccParamContaFrm.origen'));


	set('cccParamContaFrm.id', jsCccParamContaId);
	set('cccParamContaFrm.subpOidSubp', [jsCccParamContaSubpOidSubp]);
	set('cccParamContaFrm.valDebeHabe', jsCccParamContaValDebeHabe);
	set('cccParamContaFrm.valObteCuen', [jsCccParamContaValObteCuen]);
	set('cccParamContaFrm.cucoOidCuenContDire', [jsCccParamContaCucoOidCuenContDire]);
	set('cccParamContaFrm.valTextApun', jsCccParamContaValTextApun);
	set('cccParamContaFrm.indConcFech', jsCccParamContaIndConcFech);
	set('cccParamContaFrm.valObse', jsCccParamContaValObse);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsCccParamContaSubpOidSubp = '';
	jsCccParamContaValDebeHabe = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('cccParamContaFrm.errCodigo', errorCode);
	set('cccParamContaFrm.errDescripcion', description);
	set('cccParamContaFrm.errSeverity', severity);
	fMostrarMensajeError();
}
