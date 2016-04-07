

/*
    INDRA/CAR/mmg
    $Id: beltipomovimalmacview.js,v 1.1 2009/12/03 19:02:21 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsBelTipoMovimAlmacViewId = "";
var jsBelTipoMovimAlmacViewPaisOidPais = "";
var jsBelTipoMovimAlmacViewCodTipoMovi = "";
var jsBelTipoMovimAlmacViewCodMoviSap = "";
var jsBelTipoMovimAlmacViewIndMoviEntrAlma = "";
var jsBelTipoMovimAlmacViewIndMantMovi = "";
var jsBelTipoMovimAlmacViewIndSap = "";
var jsBelTipoMovimAlmacViewCodOper1 = "";
var jsBelTipoMovimAlmacViewCodOper2 = "";

//Variables de paginacion, 
var belTipoMovimAlmacViewPageCount = 1;

//Varible de columna que representa el campo de choice
var belTipoMovimAlmacViewChoiceColumn = 1;

//Flag de siguiente pagina;
var belTipoMovimAlmacViewMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var belTipoMovimAlmacViewTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 399;
var sizeFormView = 393;
var sizeFormUpdate = 393;

//Ultima busqueda realizada
var belTipoMovimAlmacViewLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focalizaComboDependence("belTipoMovimAlmacView","paisOidPais", false);','focalizaComboDependence("belTipoMovimAlmacView","paisOidPais", false);','focalizaComboDependence("belTipoMovimAlmacView","paisOidPais", false);','focalizaComboDependence("belTipoMovimAlmacView","paisOidPais", true);','focalizaComboDependence("belTipoMovimAlmacView","paisOidPais", true);','focalizaComboDependence("belTipoMovimAlmacView","paisOidPais", true);'],[3,'focaliza("belTipoMovimAlmacViewFrm.codTipoMovi");','focaliza("belTipoMovimAlmacViewFrm.codTipoMovi");','focaliza("belTipoMovimAlmacViewFrm.codTipoMovi");','focaliza("belTipoMovimAlmacViewFrm.codTipoMovi");','focaliza("belTipoMovimAlmacViewFrm.codTipoMovi");','focaliza("belTipoMovimAlmacViewFrm.codTipoMovi");'],[4,'focaliza("belTipoMovimAlmacViewFrm.codMoviSap");','focaliza("belTipoMovimAlmacViewFrm.codMoviSap");','focaliza("belTipoMovimAlmacViewFrm.codMoviSap");','focaliza("belTipoMovimAlmacViewFrm.codMoviSap");','focaliza("belTipoMovimAlmacViewFrm.codMoviSap");','focaliza("belTipoMovimAlmacViewFrm.codMoviSap");'],[5,'focaliza("belTipoMovimAlmacViewFrm.indMoviEntrAlma");','focaliza("belTipoMovimAlmacViewFrm.indMoviEntrAlma");','focaliza("belTipoMovimAlmacViewFrm.indMoviEntrAlma");','focaliza("belTipoMovimAlmacViewFrm.indMoviEntrAlma");','focaliza("belTipoMovimAlmacViewFrm.indMoviEntrAlma");','focaliza("belTipoMovimAlmacViewFrm.indMoviEntrAlma");'],[6,'focaliza("belTipoMovimAlmacViewFrm.indMantMovi");','focaliza("belTipoMovimAlmacViewFrm.indMantMovi");','focaliza("belTipoMovimAlmacViewFrm.indMantMovi");','focaliza("belTipoMovimAlmacViewFrm.indMantMovi");','focaliza("belTipoMovimAlmacViewFrm.indMantMovi");','focaliza("belTipoMovimAlmacViewFrm.indMantMovi");'],[7,'focaliza("belTipoMovimAlmacViewFrm.indSap");','focaliza("belTipoMovimAlmacViewFrm.indSap");','focaliza("belTipoMovimAlmacViewFrm.indSap");','focaliza("belTipoMovimAlmacViewFrm.indSap");','focaliza("belTipoMovimAlmacViewFrm.indSap");','focaliza("belTipoMovimAlmacViewFrm.indSap");'],[10,'focaliza("belTipoMovimAlmacViewFrm.codOper1");','focaliza("belTipoMovimAlmacViewFrm.codOper1");','focaliza("belTipoMovimAlmacViewFrm.codOper1");','focaliza("belTipoMovimAlmacViewFrm.codOper1");','focaliza("belTipoMovimAlmacViewFrm.codOper1");','focaliza("belTipoMovimAlmacViewFrm.codOper1");'],[11,'focaliza("belTipoMovimAlmacViewFrm.codOper2");','focaliza("belTipoMovimAlmacViewFrm.codOper2");','focaliza("belTipoMovimAlmacViewFrm.codOper2");','focaliza("belTipoMovimAlmacViewFrm.codOper2");','focaliza("belTipoMovimAlmacViewFrm.codOper2");','focaliza("belTipoMovimAlmacViewFrm.codOper2");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[2,'focalizaComboDependence("belTipoMovimAlmacView","paisOidPais", false);','focalizaComboDependence("belTipoMovimAlmacView","paisOidPais", false);','focalizaComboDependence("belTipoMovimAlmacView","paisOidPais", false);','focalizaComboDependence("belTipoMovimAlmacView","paisOidPais", true);','focalizaComboDependence("belTipoMovimAlmacView","paisOidPais", true);','focalizaComboDependence("belTipoMovimAlmacView","paisOidPais", true);'],[3,'focaliza("belTipoMovimAlmacViewFrm.codTipoMovi");','focaliza("belTipoMovimAlmacViewFrm.codTipoMovi");','focaliza("belTipoMovimAlmacViewFrm.codTipoMovi");','focaliza("belTipoMovimAlmacViewFrm.codTipoMovi");','focaliza("belTipoMovimAlmacViewFrm.codTipoMovi");','focaliza("belTipoMovimAlmacViewFrm.codTipoMovi");'],[4,'focaliza("belTipoMovimAlmacViewFrm.codMoviSap");','focaliza("belTipoMovimAlmacViewFrm.codMoviSap");','focaliza("belTipoMovimAlmacViewFrm.codMoviSap");','focaliza("belTipoMovimAlmacViewFrm.codMoviSap");','focaliza("belTipoMovimAlmacViewFrm.codMoviSap");','focaliza("belTipoMovimAlmacViewFrm.codMoviSap");'],[5,'focaliza("belTipoMovimAlmacViewFrm.indMoviEntrAlma");','focaliza("belTipoMovimAlmacViewFrm.indMoviEntrAlma");','focaliza("belTipoMovimAlmacViewFrm.indMoviEntrAlma");','focaliza("belTipoMovimAlmacViewFrm.indMoviEntrAlma");','focaliza("belTipoMovimAlmacViewFrm.indMoviEntrAlma");','focaliza("belTipoMovimAlmacViewFrm.indMoviEntrAlma");'],[6,'focaliza("belTipoMovimAlmacViewFrm.indMantMovi");','focaliza("belTipoMovimAlmacViewFrm.indMantMovi");','focaliza("belTipoMovimAlmacViewFrm.indMantMovi");','focaliza("belTipoMovimAlmacViewFrm.indMantMovi");','focaliza("belTipoMovimAlmacViewFrm.indMantMovi");','focaliza("belTipoMovimAlmacViewFrm.indMantMovi");'],[7,'focaliza("belTipoMovimAlmacViewFrm.indSap");','focaliza("belTipoMovimAlmacViewFrm.indSap");','focaliza("belTipoMovimAlmacViewFrm.indSap");','focaliza("belTipoMovimAlmacViewFrm.indSap");','focaliza("belTipoMovimAlmacViewFrm.indSap");','focaliza("belTipoMovimAlmacViewFrm.indSap");'],[10,'focaliza("belTipoMovimAlmacViewFrm.codOper1");','focaliza("belTipoMovimAlmacViewFrm.codOper1");','focaliza("belTipoMovimAlmacViewFrm.codOper1");','focaliza("belTipoMovimAlmacViewFrm.codOper1");','focaliza("belTipoMovimAlmacViewFrm.codOper1");','focaliza("belTipoMovimAlmacViewFrm.codOper1");'],[11,'focaliza("belTipoMovimAlmacViewFrm.codOper2");','focaliza("belTipoMovimAlmacViewFrm.codOper2");','focaliza("belTipoMovimAlmacViewFrm.codOper2");','focaliza("belTipoMovimAlmacViewFrm.codOper2");','focaliza("belTipoMovimAlmacViewFrm.codOper2");','focaliza("belTipoMovimAlmacViewFrm.codOper2");']]);

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

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
belTipoMovimAlmacViewLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var belTipoMovimAlmacViewTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function belTipoMovimAlmacViewInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('belTipoMovimAlmacViewFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('belTipoMovimAlmacViewFrm.accion')){
		case "query": belTipoMovimAlmacViewQueryInitComponents(); break;
		case "view": belTipoMovimAlmacViewViewInitComponents(); break;
		case "create": belTipoMovimAlmacViewCreateInitComponents(); break;
		case "update": belTipoMovimAlmacViewUpdateInitComponents(); break;
		case "remove": belTipoMovimAlmacViewRemoveInitComponents(); break;
		case "lov": belTipoMovimAlmacViewLovInitComponents(); break;
	}
	//alert('accion :' + get('belTipoMovimAlmacViewFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('belTipoMovimAlmacViewFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('belTipoMovimAlmacView')) belTipoMovimAlmacViewCmdRequery();
}

function belTipoMovimAlmacViewQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	focusFirstField('belTipoMovimAlmacViewFrm', true);	
}

function belTipoMovimAlmacViewViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('belTipoMovimAlmacViewFrm', true);
}

function belTipoMovimAlmacViewCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('belTipoMovimAlmacViewFrm.paisOidPais','S', GestionarMensaje('BelTipoMovimAlmacView.paisOidPais.requiered.message'));
	
	setMV('belTipoMovimAlmacViewFrm.codTipoMovi','S', GestionarMensaje('BelTipoMovimAlmacView.codTipoMovi.requiered.message'));
	
	setMV('belTipoMovimAlmacViewFrm.indMoviEntrAlma','S', GestionarMensaje('BelTipoMovimAlmacView.indMoviEntrAlma.requiered.message'));
	
	setMV('belTipoMovimAlmacViewFrm.indMantMovi','S', GestionarMensaje('BelTipoMovimAlmacView.indMantMovi.requiered.message'));
	
	setMV('belTipoMovimAlmacViewFrm.indSap','S', GestionarMensaje('BelTipoMovimAlmacView.indSap.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('belTipoMovimAlmacViewFrm', true);
}

function belTipoMovimAlmacViewUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('belTipoMovimAlmacViewFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		belTipoMovimAlmacViewTmpUpdateValues = belTipoMovimAlmacViewBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('belTipoMovimAlmacViewFrm.paisOidPais','S', GestionarMensaje('BelTipoMovimAlmacView.paisOidPais.requiered.message'));
		setMV('belTipoMovimAlmacViewFrm.codTipoMovi','S', GestionarMensaje('BelTipoMovimAlmacView.codTipoMovi.requiered.message'));
		setMV('belTipoMovimAlmacViewFrm.indMoviEntrAlma','S', GestionarMensaje('BelTipoMovimAlmacView.indMoviEntrAlma.requiered.message'));
		setMV('belTipoMovimAlmacViewFrm.indMantMovi','S', GestionarMensaje('BelTipoMovimAlmacView.indMantMovi.requiered.message'));
		setMV('belTipoMovimAlmacViewFrm.indSap','S', GestionarMensaje('BelTipoMovimAlmacView.indSap.requiered.message'));
		
			focusFirstFieldModify('belTipoMovimAlmacViewFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		focusFirstField('belTipoMovimAlmacViewFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('belTipoMovimAlmacViewFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function belTipoMovimAlmacViewRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	belTipoMovimAlmacViewList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('belTipoMovimAlmacViewFrm', true);
}

function belTipoMovimAlmacViewLovInitComponents(){
	belTipoMovimAlmacViewLovReturnParameters = window.dialogArguments;
	
	focusFirstField('belTipoMovimAlmacViewFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad











//Función que permite cargar los datos de un elemento de lov seleccionado
function belTipoMovimAlmacViewSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('belTipoMovimAlmacViewFrm.' + campo, id);
	set('belTipoMovimAlmacViewFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function belTipoMovimAlmacViewLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	belTipoMovimAlmacViewLovReturnParameters.id = '';
	belTipoMovimAlmacViewLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function belTipoMovimAlmacViewLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(belTipoMovimAlmacViewList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = belTipoMovimAlmacViewList.codSeleccionados();
	var descripcion = belTipoMovimAlmacViewList.extraeDato(
		belTipoMovimAlmacViewList.codSeleccionados()[0], belTipoMovimAlmacViewChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	belTipoMovimAlmacViewLovReturnParameters.id = codigo;
	belTipoMovimAlmacViewLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function belTipoMovimAlmacViewCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('belTipoMovimAlmacViewFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('belTipoMovimAlmacViewFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "belTipoMovimAlmacViewList", "BelTipoMovimAlmacViewConectorTransactionQuery", 
		"result_ROWSET", parametros, "belTipoMovimAlmacViewPostQueryActions(datos);"]], "", "");	
}

function belTipoMovimAlmacViewCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('belTipoMovimAlmacViewFrm.lastQueryToSession'));
	var i =0;
	set('belTipoMovimAlmacViewFrm.paisOidPais', [paramsRequery.ij(i++)]);
	
	set('belTipoMovimAlmacViewFrm.codTipoMovi', paramsRequery.ij(i++));
	
	set('belTipoMovimAlmacViewFrm.codMoviSap', paramsRequery.ij(i++));
	
	set('belTipoMovimAlmacViewFrm.indMoviEntrAlma', paramsRequery.ij(i++));
	
	set('belTipoMovimAlmacViewFrm.indMantMovi', paramsRequery.ij(i++));
	
	set('belTipoMovimAlmacViewFrm.indSap', paramsRequery.ij(i++));
	
	set('belTipoMovimAlmacViewFrm.codOper1', paramsRequery.ij(i++));
	
	set('belTipoMovimAlmacViewFrm.codOper2', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	belTipoMovimAlmacViewPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	belTipoMovimAlmacViewCmdQuery(belTipoMovimAlmacViewPageCount);
}

function belTipoMovimAlmacViewFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	belTipoMovimAlmacViewPageCount = 1;
	belTipoMovimAlmacViewCmdQuery(belTipoMovimAlmacViewPageCount);
}

function belTipoMovimAlmacViewPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != belTipoMovimAlmacViewLastQuery){
		belTipoMovimAlmacViewFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	belTipoMovimAlmacViewPageCount--;
	belTipoMovimAlmacViewCmdQuery(belTipoMovimAlmacViewPageCount);
}

function belTipoMovimAlmacViewNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != belTipoMovimAlmacViewLastQuery){
		belTipoMovimAlmacViewFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	belTipoMovimAlmacViewPageCount++;
	belTipoMovimAlmacViewCmdQuery(belTipoMovimAlmacViewPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function belTipoMovimAlmacViewPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('belTipoMovimAlmacViewListLayer', 'O');
		visibilidad('belTipoMovimAlmacViewListButtonsLayer', 'O');
		if(get('belTipoMovimAlmacViewFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	belTipoMovimAlmacViewLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:belTipoMovimAlmacViewViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, belTipoMovimAlmacViewChoiceColumn) + "</A>",
			i, belTipoMovimAlmacViewChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	belTipoMovimAlmacViewList.setDatos(datosTmp.filtrar([0,1,2,3,4,5,6,7,8],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	belTipoMovimAlmacViewTimeStamps = datosTmp.filtrar([9],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		belTipoMovimAlmacViewMorePagesFlag = true;
		belTipoMovimAlmacViewList.eliminar(mmgPageSize, 1);
	}else{
		belTipoMovimAlmacViewMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('belTipoMovimAlmacViewFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('belTipoMovimAlmacViewListLayer', 'V');
	visibilidad('belTipoMovimAlmacViewListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('belTipoMovimAlmacViewList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	belTipoMovimAlmacViewList.display();
	
	//Actualizamos el estado de los botones 
	if(belTipoMovimAlmacViewMorePagesFlag){
		set_estado_botonera('belTipoMovimAlmacViewPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('belTipoMovimAlmacViewPaginationButtonBar',
			3,"inactivo");
	}
	if(belTipoMovimAlmacViewPageCount > 1){
		set_estado_botonera('belTipoMovimAlmacViewPaginationButtonBar',
			2,"activo");
		set_estado_botonera('belTipoMovimAlmacViewPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('belTipoMovimAlmacViewPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('belTipoMovimAlmacViewPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function belTipoMovimAlmacViewUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(belTipoMovimAlmacViewList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('belTipoMovimAlmacViewFrm.idSelection', belTipoMovimAlmacViewList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('belTipoMovimAlmacViewFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = belTipoMovimAlmacViewList.codSeleccionados()[0];
		parametros["previousAction"] = get('belTipoMovimAlmacViewFrm.accion');
		parametros["accion"] = get('belTipoMovimAlmacViewFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('BelTipoMovimAlmacViewLPStartUp', get('belTipoMovimAlmacViewFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) belTipoMovimAlmacViewCmdRequery();
	}
}

function belTipoMovimAlmacViewRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(belTipoMovimAlmacViewList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = belTipoMovimAlmacViewList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('belTipoMovimAlmacViewFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(belTipoMovimAlmacViewList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += belTipoMovimAlmacViewTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('belTipoMovimAlmacViewFrm.timestamp', timestamps);


	belTipoMovimAlmacViewFrm.oculto='S';
	envia('belTipoMovimAlmacViewFrm');
	belTipoMovimAlmacViewFrm.oculto='N';
}

function belTipoMovimAlmacViewViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(belTipoMovimAlmacViewList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	belTipoMovimAlmacViewViewDetail(belTipoMovimAlmacViewList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function belTipoMovimAlmacViewViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('belTipoMovimAlmacViewFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('BelTipoMovimAlmacViewLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('belTipoMovimAlmacViewFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
	
	
		
	
	if(validacion){
		belTipoMovimAlmacViewFrm.oculto='S';
		envia('belTipoMovimAlmacViewFrm');
		belTipoMovimAlmacViewFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('belTipoMovimAlmacViewFrm.paisOidPais').toString() == ''){
		set('belTipoMovimAlmacViewFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'belTipoMovimAlmacView');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	belTipoMovimAlmacViewRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('belTipoMovimAlmacViewFrm.accion');
	var origenTmp = get('belTipoMovimAlmacViewFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(belTipoMovimAlmacViewBuildUpdateRecordString() != belTipoMovimAlmacViewTmpUpdateValues){
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
	document.all.belTipoMovimAlmacViewListLayer.style.display='none';
	document.all.belTipoMovimAlmacViewListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.belTipoMovimAlmacViewListLayer.style.display='';
	document.all.belTipoMovimAlmacViewListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsBelTipoMovimAlmacViewPaisOidPais = get('belTipoMovimAlmacViewFrm.paisOidPais')[0];
	jsBelTipoMovimAlmacViewCodTipoMovi = get('belTipoMovimAlmacViewFrm.codTipoMovi').toString();
	jsBelTipoMovimAlmacViewCodMoviSap = get('belTipoMovimAlmacViewFrm.codMoviSap').toString();
	jsBelTipoMovimAlmacViewIndMoviEntrAlma = get('belTipoMovimAlmacViewFrm.indMoviEntrAlma').toString();
	jsBelTipoMovimAlmacViewIndMantMovi = get('belTipoMovimAlmacViewFrm.indMantMovi').toString();
	jsBelTipoMovimAlmacViewIndSap = get('belTipoMovimAlmacViewFrm.indSap').toString();
	jsBelTipoMovimAlmacViewCodOper1 = get('belTipoMovimAlmacViewFrm.codOper1').toString();
	jsBelTipoMovimAlmacViewCodOper2 = get('belTipoMovimAlmacViewFrm.codOper2').toString();
	
	
	var parametros = "";
	parametros += jsBelTipoMovimAlmacViewPaisOidPais + "|";
	parametros += jsBelTipoMovimAlmacViewCodTipoMovi + "|";
	parametros += jsBelTipoMovimAlmacViewCodMoviSap + "|";
	parametros += jsBelTipoMovimAlmacViewIndMoviEntrAlma + "|";
	parametros += jsBelTipoMovimAlmacViewIndMantMovi + "|";
	parametros += jsBelTipoMovimAlmacViewIndSap + "|";
	parametros += jsBelTipoMovimAlmacViewCodOper1 + "|";
	parametros += jsBelTipoMovimAlmacViewCodOper2 + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function belTipoMovimAlmacViewBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsBelTipoMovimAlmacViewPaisOidPais + "|";
	parametros += jsBelTipoMovimAlmacViewCodTipoMovi + "|";
	parametros += jsBelTipoMovimAlmacViewCodMoviSap + "|";
	parametros += jsBelTipoMovimAlmacViewIndMoviEntrAlma + "|";
	parametros += jsBelTipoMovimAlmacViewIndMantMovi + "|";
	parametros += jsBelTipoMovimAlmacViewIndSap + "|";
	parametros += jsBelTipoMovimAlmacViewCodOper1 + "|";
	parametros += jsBelTipoMovimAlmacViewCodOper2 + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('belTipoMovimAlmacViewFrm.accion'), 
		get('belTipoMovimAlmacViewFrm.origen'));
	
	jsBelTipoMovimAlmacViewId = get('belTipoMovimAlmacViewFrm.id').toString();
	jsBelTipoMovimAlmacViewPaisOidPais = get('belTipoMovimAlmacViewFrm.paisOidPais')[0];
	jsBelTipoMovimAlmacViewCodTipoMovi = get('belTipoMovimAlmacViewFrm.codTipoMovi').toString();
	jsBelTipoMovimAlmacViewCodMoviSap = get('belTipoMovimAlmacViewFrm.codMoviSap').toString();
	jsBelTipoMovimAlmacViewIndMoviEntrAlma = get('belTipoMovimAlmacViewFrm.indMoviEntrAlma').toString();
	jsBelTipoMovimAlmacViewIndMantMovi = get('belTipoMovimAlmacViewFrm.indMantMovi').toString();
	jsBelTipoMovimAlmacViewIndSap = get('belTipoMovimAlmacViewFrm.indSap').toString();
	jsBelTipoMovimAlmacViewCodOper1 = get('belTipoMovimAlmacViewFrm.codOper1').toString();
	jsBelTipoMovimAlmacViewCodOper2 = get('belTipoMovimAlmacViewFrm.codOper2').toString();
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('belTipoMovimAlmacViewFrm.accion'), 
		get('belTipoMovimAlmacViewFrm.origen'));


	set('belTipoMovimAlmacViewFrm.id', jsBelTipoMovimAlmacViewId);
	set('belTipoMovimAlmacViewFrm.paisOidPais', [jsBelTipoMovimAlmacViewPaisOidPais]);
	set('belTipoMovimAlmacViewFrm.codTipoMovi', jsBelTipoMovimAlmacViewCodTipoMovi);
	set('belTipoMovimAlmacViewFrm.codMoviSap', jsBelTipoMovimAlmacViewCodMoviSap);
	set('belTipoMovimAlmacViewFrm.indMoviEntrAlma', jsBelTipoMovimAlmacViewIndMoviEntrAlma);
	set('belTipoMovimAlmacViewFrm.indMantMovi', jsBelTipoMovimAlmacViewIndMantMovi);
	set('belTipoMovimAlmacViewFrm.indSap', jsBelTipoMovimAlmacViewIndSap);
	set('belTipoMovimAlmacViewFrm.codOper1', jsBelTipoMovimAlmacViewCodOper1);
	set('belTipoMovimAlmacViewFrm.codOper2', jsBelTipoMovimAlmacViewCodOper2);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsBelTipoMovimAlmacViewPaisOidPais = '';
	jsBelTipoMovimAlmacViewCodTipoMovi = '';
	jsBelTipoMovimAlmacViewCodMoviSap = '';
	jsBelTipoMovimAlmacViewIndMoviEntrAlma = '';
	jsBelTipoMovimAlmacViewIndMantMovi = '';
	jsBelTipoMovimAlmacViewIndSap = '';
	jsBelTipoMovimAlmacViewCodOper1 = '';
	jsBelTipoMovimAlmacViewCodOper2 = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('belTipoMovimAlmacViewFrm.errCodigo', errorCode);
	set('belTipoMovimAlmacViewFrm.errDescripcion', description);
	set('belTipoMovimAlmacViewFrm.errSeverity', severity);
	fMostrarMensajeError();
}
