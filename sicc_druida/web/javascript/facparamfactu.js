

/*
    INDRA/CAR/mmg
    $Id: facparamfactu.js,v 1.1 2009/12/03 19:02:18 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsFacParamFactuId = "";
var jsFacParamFactuPaisOidPais = "";
var jsFacParamFactuIndDocuMonoPagi = "";
var jsFacParamFactuValMontLimiUit = "";
var jsFacParamFactuNumMaxiCampPrd = "";
var jsFacParamFactuIndTipoProyRegi = "";
var jsFacParamFactuIndMostVencCupo = "";
var jsFacParamFactuNumMaxiPediProy = "";
var jsFacParamFactuCodModaDist = "";
var jsFacParamFactuIndCheqClieNuev = "";
var jsFacParamFactuIndPrecCont = "";

//Variables de paginacion, 
var facParamFactuPageCount = 1;

//Varible de columna que representa el campo de choice
var facParamFactuChoiceColumn = 8;

//Flag de siguiente pagina;
var facParamFactuMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var facParamFactuTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 357;
var sizeFormView = 351;
var sizeFormUpdate = 351;

//Ultima busqueda realizada
var facParamFactuLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'','','','','',''],[3,'focaliza("facParamFactuFrm.indDocuMonoPagi");','focaliza("facParamFactuFrm.indDocuMonoPagi");','focaliza("facParamFactuFrm.indDocuMonoPagi");','focaliza("facParamFactuFrm.indDocuMonoPagi");','focaliza("facParamFactuFrm.indDocuMonoPagi");','focaliza("facParamFactuFrm.indDocuMonoPagi");'],[4,'focaliza("facParamFactuFrm.valMontLimiUit");','focaliza("facParamFactuFrm.valMontLimiUit");','focaliza("facParamFactuFrm.valMontLimiUit");','focaliza("facParamFactuFrm.valMontLimiUit");','focaliza("facParamFactuFrm.valMontLimiUit");','focaliza("facParamFactuFrm.valMontLimiUit");'],[5,'focaliza("facParamFactuFrm.numMaxiCampPrd");','focaliza("facParamFactuFrm.numMaxiCampPrd");','focaliza("facParamFactuFrm.numMaxiCampPrd");','focaliza("facParamFactuFrm.numMaxiCampPrd");','focaliza("facParamFactuFrm.numMaxiCampPrd");','focaliza("facParamFactuFrm.numMaxiCampPrd");'],[6,'focaliza("facParamFactuFrm.indTipoProyRegi");','focaliza("facParamFactuFrm.indTipoProyRegi");','focaliza("facParamFactuFrm.indTipoProyRegi");','focaliza("facParamFactuFrm.indTipoProyRegi");','focaliza("facParamFactuFrm.indTipoProyRegi");','focaliza("facParamFactuFrm.indTipoProyRegi");'],[7,'focaliza("facParamFactuFrm.indMostVencCupo");','focaliza("facParamFactuFrm.indMostVencCupo");','focaliza("facParamFactuFrm.indMostVencCupo");','focaliza("facParamFactuFrm.indMostVencCupo");','focaliza("facParamFactuFrm.indMostVencCupo");','focaliza("facParamFactuFrm.indMostVencCupo");'],[8,'focaliza("facParamFactuFrm.numMaxiPediProy");','focaliza("facParamFactuFrm.numMaxiPediProy");','focaliza("facParamFactuFrm.numMaxiPediProy");','focaliza("facParamFactuFrm.numMaxiPediProy");','focaliza("facParamFactuFrm.numMaxiPediProy");','focaliza("facParamFactuFrm.numMaxiPediProy");'],[9,'focaliza("facParamFactuFrm.codModaDist");','focaliza("facParamFactuFrm.codModaDist");','focaliza("facParamFactuFrm.codModaDist");','focaliza("facParamFactuFrm.codModaDist");','focaliza("facParamFactuFrm.codModaDist");','focaliza("facParamFactuFrm.codModaDist");'],[10,'','','','','',''],[11,'','','','','','']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[3,'focaliza("facParamFactuFrm.indDocuMonoPagi");','focaliza("facParamFactuFrm.indDocuMonoPagi");','focaliza("facParamFactuFrm.indDocuMonoPagi");','focaliza("facParamFactuFrm.indDocuMonoPagi");','focaliza("facParamFactuFrm.indDocuMonoPagi");','focaliza("facParamFactuFrm.indDocuMonoPagi");'],[4,'focaliza("facParamFactuFrm.valMontLimiUit");','focaliza("facParamFactuFrm.valMontLimiUit");','focaliza("facParamFactuFrm.valMontLimiUit");','focaliza("facParamFactuFrm.valMontLimiUit");','focaliza("facParamFactuFrm.valMontLimiUit");','focaliza("facParamFactuFrm.valMontLimiUit");'],[5,'focaliza("facParamFactuFrm.numMaxiCampPrd");','focaliza("facParamFactuFrm.numMaxiCampPrd");','focaliza("facParamFactuFrm.numMaxiCampPrd");','focaliza("facParamFactuFrm.numMaxiCampPrd");','focaliza("facParamFactuFrm.numMaxiCampPrd");','focaliza("facParamFactuFrm.numMaxiCampPrd");'],[6,'focaliza("facParamFactuFrm.indTipoProyRegi");','focaliza("facParamFactuFrm.indTipoProyRegi");','focaliza("facParamFactuFrm.indTipoProyRegi");','focaliza("facParamFactuFrm.indTipoProyRegi");','focaliza("facParamFactuFrm.indTipoProyRegi");','focaliza("facParamFactuFrm.indTipoProyRegi");'],[7,'focaliza("facParamFactuFrm.indMostVencCupo");','focaliza("facParamFactuFrm.indMostVencCupo");','focaliza("facParamFactuFrm.indMostVencCupo");','focaliza("facParamFactuFrm.indMostVencCupo");','focaliza("facParamFactuFrm.indMostVencCupo");','focaliza("facParamFactuFrm.indMostVencCupo");'],[8,'focaliza("facParamFactuFrm.numMaxiPediProy");','focaliza("facParamFactuFrm.numMaxiPediProy");','focaliza("facParamFactuFrm.numMaxiPediProy");','focaliza("facParamFactuFrm.numMaxiPediProy");','focaliza("facParamFactuFrm.numMaxiPediProy");','focaliza("facParamFactuFrm.numMaxiPediProy");'],[9,'focaliza("facParamFactuFrm.codModaDist");','focaliza("facParamFactuFrm.codModaDist");','focaliza("facParamFactuFrm.codModaDist");','focaliza("facParamFactuFrm.codModaDist");','focaliza("facParamFactuFrm.codModaDist");','focaliza("facParamFactuFrm.codModaDist");'],[10,'','','','','','']]);

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
facParamFactuLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var facParamFactuTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function facParamFactuInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('facParamFactuFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('facParamFactuFrm.accion')){
		case "query": facParamFactuQueryInitComponents(); break;
		case "view": facParamFactuViewInitComponents(); break;
		case "create": facParamFactuCreateInitComponents(); break;
		case "update": facParamFactuUpdateInitComponents(); break;
		case "remove": facParamFactuRemoveInitComponents(); break;
		case "lov": facParamFactuLovInitComponents(); break;
	}
	//alert('accion :' + get('facParamFactuFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('facParamFactuFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('facParamFactu')) facParamFactuCmdRequery();
}

function facParamFactuQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	focusFirstField('facParamFactuFrm', true);	
}

function facParamFactuViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('facParamFactuFrm', true);
}

function facParamFactuCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('facParamFactuFrm.indDocuMonoPagi','S', GestionarMensaje('FacParamFactu.indDocuMonoPagi.requiered.message'));
	
	setMV('facParamFactuFrm.numMaxiCampPrd','S', GestionarMensaje('FacParamFactu.numMaxiCampPrd.requiered.message'));
	
	setMV('facParamFactuFrm.indTipoProyRegi','S', GestionarMensaje('FacParamFactu.indTipoProyRegi.requiered.message'));
	
	setMV('facParamFactuFrm.indMostVencCupo','S', GestionarMensaje('FacParamFactu.indMostVencCupo.requiered.message'));
	
	setMV('facParamFactuFrm.numMaxiPediProy','S', GestionarMensaje('FacParamFactu.numMaxiPediProy.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('facParamFactuFrm', true);
}

function facParamFactuUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('facParamFactuFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		facParamFactuTmpUpdateValues = facParamFactuBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('facParamFactuFrm.indDocuMonoPagi','S', GestionarMensaje('FacParamFactu.indDocuMonoPagi.requiered.message'));
		setMV('facParamFactuFrm.numMaxiCampPrd','S', GestionarMensaje('FacParamFactu.numMaxiCampPrd.requiered.message'));
		setMV('facParamFactuFrm.indTipoProyRegi','S', GestionarMensaje('FacParamFactu.indTipoProyRegi.requiered.message'));
		setMV('facParamFactuFrm.indMostVencCupo','S', GestionarMensaje('FacParamFactu.indMostVencCupo.requiered.message'));
		setMV('facParamFactuFrm.numMaxiPediProy','S', GestionarMensaje('FacParamFactu.numMaxiPediProy.requiered.message'));
		
			focusFirstFieldModify('facParamFactuFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		focusFirstField('facParamFactuFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('facParamFactuFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function facParamFactuRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	facParamFactuList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('facParamFactuFrm', true);
}

function facParamFactuLovInitComponents(){
	facParamFactuLovReturnParameters = window.dialogArguments;
	
	focusFirstField('facParamFactuFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad













//Función que permite cargar los datos de un elemento de lov seleccionado
function facParamFactuSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('facParamFactuFrm.' + campo, id);
	set('facParamFactuFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function facParamFactuLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	facParamFactuLovReturnParameters.id = '';
	facParamFactuLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function facParamFactuLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(facParamFactuList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = facParamFactuList.codSeleccionados();
	var descripcion = facParamFactuList.extraeDato(
		facParamFactuList.codSeleccionados()[0], facParamFactuChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	facParamFactuLovReturnParameters.id = codigo;
	facParamFactuLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function facParamFactuCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('facParamFactuFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('facParamFactuFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "facParamFactuList", "FacParamFactuConectorTransactionQuery", 
		"result_ROWSET", parametros, "facParamFactuPostQueryActions(datos);"]], "", "");	
}

function facParamFactuCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('facParamFactuFrm.lastQueryToSession'));
	var i =0;
	set('facParamFactuFrm.indDocuMonoPagi', [paramsRequery.ij(i++)]);
	
	set('facParamFactuFrm.valMontLimiUit', paramsRequery.ij(i++));
	
	set('facParamFactuFrm.numMaxiCampPrd', paramsRequery.ij(i++));
	
	set('facParamFactuFrm.indTipoProyRegi', [paramsRequery.ij(i++)]);
	
	set('facParamFactuFrm.indMostVencCupo', [paramsRequery.ij(i++)]);
	
	set('facParamFactuFrm.numMaxiPediProy', paramsRequery.ij(i++));
	
	set('facParamFactuFrm.codModaDist', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la página de busqueda como la actual
	facParamFactuPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	facParamFactuCmdQuery(facParamFactuPageCount);
}

function facParamFactuFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	facParamFactuPageCount = 1;
	facParamFactuCmdQuery(facParamFactuPageCount);
}

function facParamFactuPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != facParamFactuLastQuery){
		facParamFactuFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	facParamFactuPageCount--;
	facParamFactuCmdQuery(facParamFactuPageCount);
}

function facParamFactuNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != facParamFactuLastQuery){
		facParamFactuFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	facParamFactuPageCount++;
	facParamFactuCmdQuery(facParamFactuPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function facParamFactuPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('facParamFactuListLayer', 'O');
		visibilidad('facParamFactuListButtonsLayer', 'O');
		if(get('facParamFactuFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	facParamFactuLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	for(var i=0; i < datosTmp.longitud; i++){ 
		switch(datosTmp.ij(i, 1)){
			case '1': datosTmp.ij2(GestionarMensaje('FacParamFactu.indDocuMonoPagi.1.value'), i, 1); break;
			case '0': datosTmp.ij2(GestionarMensaje('FacParamFactu.indDocuMonoPagi.0.value'), i, 1); break;
			default: datosTmp .ij2('', i, 1);
		}
	}
	for(var i=0; i < datosTmp.longitud; i++){ 
		switch(datosTmp.ij(i, 4)){
			case '1': datosTmp.ij2(GestionarMensaje('FacParamFactu.indTipoProyRegi.1.value'), i, 4); break;
			case '2': datosTmp.ij2(GestionarMensaje('FacParamFactu.indTipoProyRegi.2.value'), i, 4); break;
			default: datosTmp .ij2('', i, 4);
		}
	}
	for(var i=0; i < datosTmp.longitud; i++){ 
		switch(datosTmp.ij(i, 5)){
			case '1': datosTmp.ij2(GestionarMensaje('FacParamFactu.indMostVencCupo.1.value'), i, 5); break;
			case '0': datosTmp.ij2(GestionarMensaje('FacParamFactu.indMostVencCupo.0.value'), i, 5); break;
			default: datosTmp .ij2('', i, 5);
		}
	}
	for(var i=0; i < datosTmp.longitud; i++){ 
		switch(datosTmp.ij(i, 7)){
			case 'A': datosTmp.ij2(GestionarMensaje('FacParamFactu.codModaDist.A.value'), i, 7); break;
			case 'L': datosTmp.ij2(GestionarMensaje('FacParamFactu.codModaDist.L.value'), i, 7); break;
			case 'O': datosTmp.ij2(GestionarMensaje('FacParamFactu.codModaDist.O.value'), i, 7); break;
			default: datosTmp .ij2('', i, 7);
		}
	}
	for(var i=0; i < datosTmp.longitud; i++){ 
		switch(datosTmp.ij(i, 8)){
			case '1': datosTmp.ij2(GestionarMensaje('FacParamFactu.indCheqClieNuev.1.value'), i, 8); break;
			case '0': datosTmp.ij2(GestionarMensaje('FacParamFactu.indCheqClieNuev.0.value'), i, 8); break;
			default: datosTmp .ij2('', i, 8);
		}
	}
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:facParamFactuViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, facParamFactuChoiceColumn) + "</A>",
			i, facParamFactuChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	facParamFactuList.setDatos(datosTmp.filtrar([0,1,2,3,4,5,6,7,8],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	facParamFactuTimeStamps = datosTmp.filtrar([9],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		facParamFactuMorePagesFlag = true;
		facParamFactuList.eliminar(mmgPageSize, 1);
	}else{
		facParamFactuMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('facParamFactuFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('facParamFactuListLayer', 'V');
	visibilidad('facParamFactuListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('facParamFactuList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	facParamFactuList.display();
	
	//Actualizamos el estado de los botones 
	if(facParamFactuMorePagesFlag){
		set_estado_botonera('facParamFactuPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('facParamFactuPaginationButtonBar',
			3,"inactivo");
	}
	if(facParamFactuPageCount > 1){
		set_estado_botonera('facParamFactuPaginationButtonBar',
			2,"activo");
		set_estado_botonera('facParamFactuPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('facParamFactuPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('facParamFactuPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function facParamFactuUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(facParamFactuList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('facParamFactuFrm.idSelection', facParamFactuList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('facParamFactuFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = facParamFactuList.codSeleccionados()[0];
		parametros["previousAction"] = get('facParamFactuFrm.accion');
		parametros["accion"] = get('facParamFactuFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('FacParamFactuLPStartUp', get('facParamFactuFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) facParamFactuCmdRequery();
	}
}

function facParamFactuRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(facParamFactuList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = facParamFactuList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('facParamFactuFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(facParamFactuList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += facParamFactuTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('facParamFactuFrm.timestamp', timestamps);


	facParamFactuFrm.oculto='S';
	envia('facParamFactuFrm');
	facParamFactuFrm.oculto='N';
}

function facParamFactuViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(facParamFactuList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	facParamFactuViewDetail(facParamFactuList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function facParamFactuViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('facParamFactuFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('FacParamFactuLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('facParamFactuFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
	
	
	
	
		
	
	if(validacion){
		facParamFactuFrm.oculto='S';
		envia('facParamFactuFrm');
		facParamFactuFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('facParamFactuFrm.paisOidPais').toString() == ''){
		set('facParamFactuFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'facParamFactu');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	facParamFactuRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('facParamFactuFrm.accion');
	var origenTmp = get('facParamFactuFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(facParamFactuBuildUpdateRecordString() != facParamFactuTmpUpdateValues){
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
	document.all.facParamFactuListLayer.style.display='none';
	document.all.facParamFactuListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.facParamFactuListLayer.style.display='';
	document.all.facParamFactuListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsFacParamFactuIndDocuMonoPagi = get('facParamFactuFrm.indDocuMonoPagi')[0];
	jsFacParamFactuValMontLimiUit = get('facParamFactuFrm.valMontLimiUit').toString();
	jsFacParamFactuNumMaxiCampPrd = get('facParamFactuFrm.numMaxiCampPrd').toString();
	jsFacParamFactuIndTipoProyRegi = get('facParamFactuFrm.indTipoProyRegi')[0];
	jsFacParamFactuIndMostVencCupo = get('facParamFactuFrm.indMostVencCupo')[0];
	jsFacParamFactuNumMaxiPediProy = get('facParamFactuFrm.numMaxiPediProy').toString();
	jsFacParamFactuCodModaDist = get('facParamFactuFrm.codModaDist')[0];
	
	
	var parametros = "";
	parametros += jsFacParamFactuIndDocuMonoPagi + "|";
	parametros += jsFacParamFactuValMontLimiUit + "|";
	parametros += jsFacParamFactuNumMaxiCampPrd + "|";
	parametros += jsFacParamFactuIndTipoProyRegi + "|";
	parametros += jsFacParamFactuIndMostVencCupo + "|";
	parametros += jsFacParamFactuNumMaxiPediProy + "|";
	parametros += jsFacParamFactuCodModaDist + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function facParamFactuBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsFacParamFactuIndDocuMonoPagi + "|";
	parametros += jsFacParamFactuValMontLimiUit + "|";
	parametros += jsFacParamFactuNumMaxiCampPrd + "|";
	parametros += jsFacParamFactuIndTipoProyRegi + "|";
	parametros += jsFacParamFactuIndMostVencCupo + "|";
	parametros += jsFacParamFactuNumMaxiPediProy + "|";
	parametros += jsFacParamFactuCodModaDist + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('facParamFactuFrm.accion'), 
		get('facParamFactuFrm.origen'));
	
	jsFacParamFactuId = get('facParamFactuFrm.id').toString();
	jsFacParamFactuPaisOidPais = get('facParamFactuFrm.paisOidPais')[0];
	jsFacParamFactuIndDocuMonoPagi = get('facParamFactuFrm.indDocuMonoPagi')[0];
	jsFacParamFactuValMontLimiUit = get('facParamFactuFrm.valMontLimiUit').toString();
	jsFacParamFactuNumMaxiCampPrd = get('facParamFactuFrm.numMaxiCampPrd').toString();
	jsFacParamFactuIndTipoProyRegi = get('facParamFactuFrm.indTipoProyRegi')[0];
	jsFacParamFactuIndMostVencCupo = get('facParamFactuFrm.indMostVencCupo')[0];
	jsFacParamFactuNumMaxiPediProy = get('facParamFactuFrm.numMaxiPediProy').toString();
	jsFacParamFactuCodModaDist = get('facParamFactuFrm.codModaDist')[0];
	jsFacParamFactuIndCheqClieNuev = get('facParamFactuFrm.indCheqClieNuev')[0];
	jsFacParamFactuIndPrecCont = get('facParamFactuFrm.indPrecCont')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('facParamFactuFrm.accion'), 
		get('facParamFactuFrm.origen'));


	set('facParamFactuFrm.id', jsFacParamFactuId);
	set('facParamFactuFrm.paisOidPais', [jsFacParamFactuPaisOidPais]);
	set('facParamFactuFrm.indDocuMonoPagi', [jsFacParamFactuIndDocuMonoPagi]);
	set('facParamFactuFrm.valMontLimiUit', jsFacParamFactuValMontLimiUit);
	set('facParamFactuFrm.numMaxiCampPrd', jsFacParamFactuNumMaxiCampPrd);
	set('facParamFactuFrm.indTipoProyRegi', [jsFacParamFactuIndTipoProyRegi]);
	set('facParamFactuFrm.indMostVencCupo', [jsFacParamFactuIndMostVencCupo]);
	set('facParamFactuFrm.numMaxiPediProy', jsFacParamFactuNumMaxiPediProy);
	set('facParamFactuFrm.codModaDist', [jsFacParamFactuCodModaDist]);
	set('facParamFactuFrm.indCheqClieNuev', [jsFacParamFactuIndCheqClieNuev]);
	set('facParamFactuFrm.indPrecCont', [jsFacParamFactuIndPrecCont]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsFacParamFactuIndDocuMonoPagi = '';
	jsFacParamFactuValMontLimiUit = '';
	jsFacParamFactuNumMaxiCampPrd = '';
	jsFacParamFactuIndTipoProyRegi = '';
	jsFacParamFactuIndMostVencCupo = '';
	jsFacParamFactuNumMaxiPediProy = '';
	jsFacParamFactuCodModaDist = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('facParamFactuFrm.errCodigo', errorCode);
	set('facParamFactuFrm.errDescripcion', description);
	set('facParamFactuFrm.errSeverity', severity);
	fMostrarMensajeError();
}
