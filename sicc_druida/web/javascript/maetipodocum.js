

/*
    INDRA/CAR/mmg
    $Id: maetipodocum.js,v 1.1 2009/12/03 19:01:33 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsMaeTipoDocumId = "";
var jsMaeTipoDocumPaisOidPais = "";
var jsMaeTipoDocumCodTipoDocu = "";
var jsMaeTipoDocumIndObli = "";
var jsMaeTipoDocumDescripcion = "";
var jsMaeTipoDocumValSigl = "";
var jsMaeTipoDocumValLong = "";
var jsMaeTipoDocumIndDni = "";
var jsMaeTipoDocumIndDocIdenFisc = "";
var jsMaeTipoDocumTidoOidTipoDocu = "";

//Variables de paginacion, 
var maeTipoDocumPageCount = 1;

//Varible de columna que representa el campo de choice
var maeTipoDocumChoiceColumn = 8;

//Flag de siguiente pagina;
var maeTipoDocumMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var maeTipoDocumTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 147;
var sizeFormView = 129;
var sizeFormUpdate = 129;

//Ultima busqueda realizada
var maeTipoDocumLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'','','','','',''],[3,'focaliza("maeTipoDocumFrm.codTipoDocu");','focaliza("maeTipoDocumFrm.codTipoDocu");','focaliza("maeTipoDocumFrm.codTipoDocu");','focaliza("maeTipoDocumFrm.codTipoDocu");','focaliza("maeTipoDocumFrm.codTipoDocu");','focaliza("maeTipoDocumFrm.codTipoDocu");'],[4,'focaliza("maeTipoDocumFrm.indObli");','focaliza("maeTipoDocumFrm.indObli");','focaliza("maeTipoDocumFrm.indObli");','focaliza("maeTipoDocumFrm.indObli");','focaliza("maeTipoDocumFrm.indObli");','focaliza("maeTipoDocumFrm.indObli");'],[5,'focaliza("maeTipoDocumFrm.Descripcion");','focaliza("maeTipoDocumFrm.Descripcion");','focaliza("maeTipoDocumFrm.Descripcion");','focaliza("maeTipoDocumFrm.Descripcion");','focaliza("maeTipoDocumFrm.Descripcion");','focaliza("maeTipoDocumFrm.Descripcion");'],[6,'focaliza("maeTipoDocumFrm.valSigl");','focaliza("maeTipoDocumFrm.valSigl");','focaliza("maeTipoDocumFrm.valSigl");','focaliza("maeTipoDocumFrm.valSigl");','focaliza("maeTipoDocumFrm.valSigl");','focaliza("maeTipoDocumFrm.valSigl");'],[7,'focaliza("maeTipoDocumFrm.valLong");','focaliza("maeTipoDocumFrm.valLong");','focaliza("maeTipoDocumFrm.valLong");','focaliza("maeTipoDocumFrm.valLong");','focaliza("maeTipoDocumFrm.valLong");','focaliza("maeTipoDocumFrm.valLong");'],[8,'focaliza("maeTipoDocumFrm.indDni");','focaliza("maeTipoDocumFrm.indDni");','focaliza("maeTipoDocumFrm.indDni");','focaliza("maeTipoDocumFrm.indDni");','focaliza("maeTipoDocumFrm.indDni");','focaliza("maeTipoDocumFrm.indDni");'],[9,'focaliza("maeTipoDocumFrm.indDocIdenFisc");','focaliza("maeTipoDocumFrm.indDocIdenFisc");','focaliza("maeTipoDocumFrm.indDocIdenFisc");','focaliza("maeTipoDocumFrm.indDocIdenFisc");','focaliza("maeTipoDocumFrm.indDocIdenFisc");','focaliza("maeTipoDocumFrm.indDocIdenFisc");'],[10,'focalizaComboDependence("maeTipoDocum","tidoOidTipoDocu", false);','focalizaComboDependence("maeTipoDocum","tidoOidTipoDocu", false);','focalizaComboDependence("maeTipoDocum","tidoOidTipoDocu", false);','focalizaComboDependence("maeTipoDocum","tidoOidTipoDocu", true);','focalizaComboDependence("maeTipoDocum","tidoOidTipoDocu", true);','focalizaComboDependence("maeTipoDocum","tidoOidTipoDocu", true);']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[2,'','','','','',''],[5,'focaliza("maeTipoDocumFrm.Descripcion");','focaliza("maeTipoDocumFrm.Descripcion");','focaliza("maeTipoDocumFrm.Descripcion");','focaliza("maeTipoDocumFrm.Descripcion");','focaliza("maeTipoDocumFrm.Descripcion");','focaliza("maeTipoDocumFrm.Descripcion");'],[6,'focaliza("maeTipoDocumFrm.valSigl");','focaliza("maeTipoDocumFrm.valSigl");','focaliza("maeTipoDocumFrm.valSigl");','focaliza("maeTipoDocumFrm.valSigl");','focaliza("maeTipoDocumFrm.valSigl");','focaliza("maeTipoDocumFrm.valSigl");'],[7,'focaliza("maeTipoDocumFrm.valLong");','focaliza("maeTipoDocumFrm.valLong");','focaliza("maeTipoDocumFrm.valLong");','focaliza("maeTipoDocumFrm.valLong");','focaliza("maeTipoDocumFrm.valLong");','focaliza("maeTipoDocumFrm.valLong");'],[8,'focaliza("maeTipoDocumFrm.indDni");','focaliza("maeTipoDocumFrm.indDni");','focaliza("maeTipoDocumFrm.indDni");','focaliza("maeTipoDocumFrm.indDni");','focaliza("maeTipoDocumFrm.indDni");','focaliza("maeTipoDocumFrm.indDni");'],[9,'focaliza("maeTipoDocumFrm.indDocIdenFisc");','focaliza("maeTipoDocumFrm.indDocIdenFisc");','focaliza("maeTipoDocumFrm.indDocIdenFisc");','focaliza("maeTipoDocumFrm.indDocIdenFisc");','focaliza("maeTipoDocumFrm.indDocIdenFisc");','focaliza("maeTipoDocumFrm.indDocIdenFisc");'],[10,'focalizaComboDependence("maeTipoDocum","tidoOidTipoDocu", false);','focalizaComboDependence("maeTipoDocum","tidoOidTipoDocu", false);','focalizaComboDependence("maeTipoDocum","tidoOidTipoDocu", false);','focalizaComboDependence("maeTipoDocum","tidoOidTipoDocu", true);','focalizaComboDependence("maeTipoDocum","tidoOidTipoDocu", true);','focalizaComboDependence("maeTipoDocum","tidoOidTipoDocu", true);']]);

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
var tidoOidTipoDocuDependeceMap = new Vector();
tidoOidTipoDocuDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
tidoOidTipoDocuDependeceMap.agregar(['tidoOidTipoDocu', padresTmp, '', 'FacTipoDocum']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
maeTipoDocumLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var maeTipoDocumTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function maeTipoDocumInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('maeTipoDocumFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('maeTipoDocumFrm.accion')){
		case "query": maeTipoDocumQueryInitComponents(); break;
		case "view": maeTipoDocumViewInitComponents(); break;
		case "create": maeTipoDocumCreateInitComponents(); break;
		case "update": maeTipoDocumUpdateInitComponents(); break;
		case "remove": maeTipoDocumRemoveInitComponents(); break;
		case "lov": maeTipoDocumLovInitComponents(); break;
	}
	//alert('accion :' + get('maeTipoDocumFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('maeTipoDocumFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('maeTipoDocum')) maeTipoDocumCmdRequery();
}

function maeTipoDocumQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	focusFirstField('maeTipoDocumFrm', true);	
}

function maeTipoDocumViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('maeTipoDocumFrm', 'Descripcion', 1);
	
		
	//Establecemos el valor de los radiobuttons
		set('maeTipoDocumFrm.indObli', get('maeTipoDocumFrm.indObliCheckValue'));
		set('maeTipoDocumFrm.indDni', get('maeTipoDocumFrm.indDniCheckValue'));
		set('maeTipoDocumFrm.indDocIdenFisc', get('maeTipoDocumFrm.indDocIdenFiscCheckValue'));
		
	focusFirstField('maeTipoDocumFrm', true);
}

function maeTipoDocumCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('maeTipoDocumFrm.codTipoDocu','S', GestionarMensaje('MaeTipoDocum.codTipoDocu.requiered.message'));
	
	setMV('maeTipoDocumFrm.indObli','S', GestionarMensaje('MaeTipoDocum.indObli.requiered.message'));
	
	setMV('maeTipoDocumFrm.Descripcion','S', GestionarMensaje('MaeTipoDocum.Descripcion.requiered.message'));
	
	setMV('maeTipoDocumFrm.indDni','S', GestionarMensaje('MaeTipoDocum.indDni.requiered.message'));
	
	setMV('maeTipoDocumFrm.indDocIdenFisc','S', GestionarMensaje('MaeTipoDocum.indDocIdenFisc.requiered.message'));
	
	setMV('maeTipoDocumFrm.tidoOidTipoDocu','S', GestionarMensaje('MaeTipoDocum.tidoOidTipoDocu.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('maeTipoDocumFrm', true);
}

function maeTipoDocumUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('maeTipoDocumFrm.origen') == "pagina"){
		loadLocalizationWidget('maeTipoDocumFrm', 'Descripcion', 1);
		

		//Establecemos el valor de los radiobuttons
			set('maeTipoDocumFrm.indObli', get('maeTipoDocumFrm.indObliCheckValue'));
			set('maeTipoDocumFrm.indDni', get('maeTipoDocumFrm.indDniCheckValue'));
			set('maeTipoDocumFrm.indDocIdenFisc', get('maeTipoDocumFrm.indDocIdenFiscCheckValue'));
			

		//Registramos el valor del elemento que estamos modificando
		maeTipoDocumTmpUpdateValues = maeTipoDocumBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('maeTipoDocumFrm.codTipoDocu','S', GestionarMensaje('MaeTipoDocum.codTipoDocu.requiered.message'));
		setMV('maeTipoDocumFrm.indObli','S', GestionarMensaje('MaeTipoDocum.indObli.requiered.message'));
		setMV('maeTipoDocumFrm.Descripcion','S', GestionarMensaje('MaeTipoDocum.Descripcion.requiered.message'));
		setMV('maeTipoDocumFrm.indDni','S', GestionarMensaje('MaeTipoDocum.indDni.requiered.message'));
		setMV('maeTipoDocumFrm.indDocIdenFisc','S', GestionarMensaje('MaeTipoDocum.indDocIdenFisc.requiered.message'));
		setMV('maeTipoDocumFrm.tidoOidTipoDocu','S', GestionarMensaje('MaeTipoDocum.tidoOidTipoDocu.requiered.message'));
		
			focusFirstFieldModify('maeTipoDocumFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		focusFirstField('maeTipoDocumFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('maeTipoDocumFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function maeTipoDocumRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	maeTipoDocumList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('maeTipoDocumFrm', true);
}

function maeTipoDocumLovInitComponents(){
	maeTipoDocumLovReturnParameters = window.dialogArguments;
	
	focusFirstField('maeTipoDocumFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad












//Función que permite cargar los datos de un elemento de lov seleccionado
function maeTipoDocumSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('maeTipoDocumFrm.' + campo, id);
	set('maeTipoDocumFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function maeTipoDocumLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	maeTipoDocumLovReturnParameters.id = '';
	maeTipoDocumLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function maeTipoDocumLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeTipoDocumList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = maeTipoDocumList.codSeleccionados();
	var descripcion = maeTipoDocumList.extraeDato(
		maeTipoDocumList.codSeleccionados()[0], maeTipoDocumChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	maeTipoDocumLovReturnParameters.id = codigo;
	maeTipoDocumLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function maeTipoDocumCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('maeTipoDocumFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('maeTipoDocumFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "maeTipoDocumList", "MaeTipoDocumConectorTransactionQuery", 
		"result_ROWSET", parametros, "maeTipoDocumPostQueryActions(datos);"]], "", "");	
}

function maeTipoDocumCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('maeTipoDocumFrm.lastQueryToSession'));
	var i =0;
	set('maeTipoDocumFrm.codTipoDocu', paramsRequery.ij(i++));
	
	set('maeTipoDocumFrm.indObli', paramsRequery.ij(i++));
	
	set('maeTipoDocumFrm.Descripcion', paramsRequery.ij(i++));
	
	set('maeTipoDocumFrm.valSigl', paramsRequery.ij(i++));
	
	set('maeTipoDocumFrm.valLong', paramsRequery.ij(i++));
	
	set('maeTipoDocumFrm.indDni', paramsRequery.ij(i++));
	
	set('maeTipoDocumFrm.indDocIdenFisc', paramsRequery.ij(i++));
	
	set('maeTipoDocumFrm.tidoOidTipoDocu', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la página de busqueda como la actual
	maeTipoDocumPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	maeTipoDocumCmdQuery(maeTipoDocumPageCount);
}

function maeTipoDocumFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	maeTipoDocumPageCount = 1;
	maeTipoDocumCmdQuery(maeTipoDocumPageCount);
}

function maeTipoDocumPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeTipoDocumLastQuery){
		maeTipoDocumFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	maeTipoDocumPageCount--;
	maeTipoDocumCmdQuery(maeTipoDocumPageCount);
}

function maeTipoDocumNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeTipoDocumLastQuery){
		maeTipoDocumFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	maeTipoDocumPageCount++;
	maeTipoDocumCmdQuery(maeTipoDocumPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function maeTipoDocumPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('maeTipoDocumListLayer', 'O');
		visibilidad('maeTipoDocumListButtonsLayer', 'O');
		if(get('maeTipoDocumFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	maeTipoDocumLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	for(var i=0; i < datosTmp.longitud; i++){ 
		switch(datosTmp.ij(i, 2)){
			case '1': datosTmp.ij2(GestionarMensaje('MaeTipoDocum.indObli.1.value'), i, 2); break;
			case '0': datosTmp.ij2(GestionarMensaje('MaeTipoDocum.indObli.0.value'), i, 2); break;
			default: datosTmp .ij2('', i, 2);
		}
	}
	for(var i=0; i < datosTmp.longitud; i++){ 
		switch(datosTmp.ij(i, 6)){
			case '1': datosTmp.ij2(GestionarMensaje('MaeTipoDocum.indDni.1.value'), i, 6); break;
			case '0': datosTmp.ij2(GestionarMensaje('MaeTipoDocum.indDni.0.value'), i, 6); break;
			default: datosTmp .ij2('', i, 6);
		}
	}
	for(var i=0; i < datosTmp.longitud; i++){ 
		switch(datosTmp.ij(i, 7)){
			case '1': datosTmp.ij2(GestionarMensaje('MaeTipoDocum.indDocIdenFisc.1.value'), i, 7); break;
			case '0': datosTmp.ij2(GestionarMensaje('MaeTipoDocum.indDocIdenFisc.0.value'), i, 7); break;
			default: datosTmp .ij2('', i, 7);
		}
	}
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:maeTipoDocumViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, maeTipoDocumChoiceColumn) + "</A>",
			i, maeTipoDocumChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	maeTipoDocumList.setDatos(datosTmp.filtrar([0,1,2,3,4,5,6,7,8],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	maeTipoDocumTimeStamps = datosTmp.filtrar([9],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		maeTipoDocumMorePagesFlag = true;
		maeTipoDocumList.eliminar(mmgPageSize, 1);
	}else{
		maeTipoDocumMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('maeTipoDocumFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('maeTipoDocumListLayer', 'V');
	visibilidad('maeTipoDocumListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('maeTipoDocumList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	maeTipoDocumList.display();
	
	//Actualizamos el estado de los botones 
	if(maeTipoDocumMorePagesFlag){
		set_estado_botonera('maeTipoDocumPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('maeTipoDocumPaginationButtonBar',
			3,"inactivo");
	}
	if(maeTipoDocumPageCount > 1){
		set_estado_botonera('maeTipoDocumPaginationButtonBar',
			2,"activo");
		set_estado_botonera('maeTipoDocumPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('maeTipoDocumPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('maeTipoDocumPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function maeTipoDocumUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeTipoDocumList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('maeTipoDocumFrm.idSelection', maeTipoDocumList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('maeTipoDocumFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = maeTipoDocumList.codSeleccionados()[0];
		parametros["previousAction"] = get('maeTipoDocumFrm.accion');
		parametros["accion"] = get('maeTipoDocumFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('MaeTipoDocumLPStartUp', get('maeTipoDocumFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) maeTipoDocumCmdRequery();
	}
}

function maeTipoDocumRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeTipoDocumList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = maeTipoDocumList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('maeTipoDocumFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(maeTipoDocumList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += maeTipoDocumTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('maeTipoDocumFrm.timestamp', timestamps);


	maeTipoDocumFrm.oculto='S';
	envia('maeTipoDocumFrm');
	maeTipoDocumFrm.oculto='N';
}

function maeTipoDocumViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeTipoDocumList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	maeTipoDocumViewDetail(maeTipoDocumList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function maeTipoDocumViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('maeTipoDocumFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('MaeTipoDocumLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	
	setDefaultLanguageValue('maeTipoDocumFrm', 
		'Descripcion', 1,
		get('maeTipoDocumFrm.Descripcion'));	
	
	
	
	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('maeTipoDocumFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	if(!hasDefaultLanguageValue('maeTipoDocumFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('MaeTipoDocum.Descripcion.requiered.message'));
		focaliza('maeTipoDocumFrm.Descripcion');
		return;
	}	
	
	
	
	
	
	
		
	
	if(validacion){
		maeTipoDocumFrm.oculto='S';
		envia('maeTipoDocumFrm');
		maeTipoDocumFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('maeTipoDocumFrm.paisOidPais').toString() == ''){
		set('maeTipoDocumFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'maeTipoDocum');
		
	}
	if(get('maeTipoDocumFrm.tidoOidTipoDocu').toString() == ''){
		set('maeTipoDocumFrm.tidoOidTipoDocu', []);
		mmgResetCombosOnCascade('tidoOidTipoDocu', 'tidoOidTipoDocu', 'maeTipoDocum');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	maeTipoDocumRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('maeTipoDocumFrm.accion');
	var origenTmp = get('maeTipoDocumFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(maeTipoDocumBuildUpdateRecordString() != maeTipoDocumTmpUpdateValues){
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
	document.all.maeTipoDocumListLayer.style.display='none';
	document.all.maeTipoDocumListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.maeTipoDocumListLayer.style.display='';
	document.all.maeTipoDocumListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsMaeTipoDocumCodTipoDocu = get('maeTipoDocumFrm.codTipoDocu').toString();
	jsMaeTipoDocumIndObli = get('maeTipoDocumFrm.indObli');
	jsMaeTipoDocumDescripcion = get('maeTipoDocumFrm.Descripcion').toString();
	jsMaeTipoDocumValSigl = get('maeTipoDocumFrm.valSigl').toString();
	jsMaeTipoDocumValLong = get('maeTipoDocumFrm.valLong').toString();
	jsMaeTipoDocumIndDni = get('maeTipoDocumFrm.indDni');
	jsMaeTipoDocumIndDocIdenFisc = get('maeTipoDocumFrm.indDocIdenFisc');
	jsMaeTipoDocumTidoOidTipoDocu = get('maeTipoDocumFrm.tidoOidTipoDocu')[0];
	
	
	var parametros = "";
	parametros += jsMaeTipoDocumCodTipoDocu + "|";
	parametros += jsMaeTipoDocumIndObli + "|";
	parametros += jsMaeTipoDocumDescripcion + "|";
	parametros += jsMaeTipoDocumValSigl + "|";
	parametros += jsMaeTipoDocumValLong + "|";
	parametros += jsMaeTipoDocumIndDni + "|";
	parametros += jsMaeTipoDocumIndDocIdenFisc + "|";
	parametros += jsMaeTipoDocumTidoOidTipoDocu + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function maeTipoDocumBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsMaeTipoDocumCodTipoDocu + "|";
	parametros += jsMaeTipoDocumIndObli + "|";
	parametros += jsMaeTipoDocumDescripcion + "|";
	parametros += jsMaeTipoDocumValSigl + "|";
	parametros += jsMaeTipoDocumValLong + "|";
	parametros += jsMaeTipoDocumIndDni + "|";
	parametros += jsMaeTipoDocumIndDocIdenFisc + "|";
	parametros += jsMaeTipoDocumTidoOidTipoDocu + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeTipoDocumFrm.accion'), 
		get('maeTipoDocumFrm.origen'));
	
	jsMaeTipoDocumId = get('maeTipoDocumFrm.id').toString();
	jsMaeTipoDocumPaisOidPais = get('maeTipoDocumFrm.paisOidPais')[0];
	jsMaeTipoDocumCodTipoDocu = get('maeTipoDocumFrm.codTipoDocu').toString();
	jsMaeTipoDocumIndObli = get('maeTipoDocumFrm.indObli');
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsMaeTipoDocumDescripcion = buildLocalizedString('maeTipoDocumFrm', 1);
	}else{
		jsMaeTipoDocumDescripcion = get('maeTipoDocumFrm.Descripcion');
	}
	jsMaeTipoDocumValSigl = get('maeTipoDocumFrm.valSigl').toString();
	jsMaeTipoDocumValLong = get('maeTipoDocumFrm.valLong').toString();
	jsMaeTipoDocumIndDni = get('maeTipoDocumFrm.indDni');
	jsMaeTipoDocumIndDocIdenFisc = get('maeTipoDocumFrm.indDocIdenFisc');
	jsMaeTipoDocumTidoOidTipoDocu = get('maeTipoDocumFrm.tidoOidTipoDocu')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeTipoDocumFrm.accion'), 
		get('maeTipoDocumFrm.origen'));


	set('maeTipoDocumFrm.id', jsMaeTipoDocumId);
	set('maeTipoDocumFrm.paisOidPais', [jsMaeTipoDocumPaisOidPais]);
	set('maeTipoDocumFrm.codTipoDocu', jsMaeTipoDocumCodTipoDocu);
	set('maeTipoDocumFrm.indObli', jsMaeTipoDocumIndObli);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('maeTipoDocumFrm', 1,  jsMaeTipoDocumDescripcion)
		loadLocalizationWidget('maeTipoDocumFrm', 'Descripcion', 1);
	}else{
		set('maeTipoDocumFrm.Descripcion', jsMaeTipoDocumDescripcion);		
	}
	set('maeTipoDocumFrm.valSigl', jsMaeTipoDocumValSigl);
	set('maeTipoDocumFrm.valLong', jsMaeTipoDocumValLong);
	set('maeTipoDocumFrm.indDni', jsMaeTipoDocumIndDni);
	set('maeTipoDocumFrm.indDocIdenFisc', jsMaeTipoDocumIndDocIdenFisc);
	set('maeTipoDocumFrm.tidoOidTipoDocu', [jsMaeTipoDocumTidoOidTipoDocu]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsMaeTipoDocumCodTipoDocu = '';
	jsMaeTipoDocumIndObli = '';
	jsMaeTipoDocumDescripcion = '';
	jsMaeTipoDocumValSigl = '';
	jsMaeTipoDocumValLong = '';
	jsMaeTipoDocumIndDni = '';
	jsMaeTipoDocumIndDocIdenFisc = '';
	jsMaeTipoDocumTidoOidTipoDocu = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('maeTipoDocumFrm.errCodigo', errorCode);
	set('maeTipoDocumFrm.errDescripcion', description);
	set('maeTipoDocumFrm.errSeverity', severity);
	fMostrarMensajeError();
}
