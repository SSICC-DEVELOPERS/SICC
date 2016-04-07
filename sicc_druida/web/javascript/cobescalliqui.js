

/*
    INDRA/CAR/mmg
    $Id: cobescalliqui.js,v 1.1 2009/12/03 19:02:09 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsCobEscalLiquiId = "";
var jsCobEscalLiquiNumOrdeEsca = "";
var jsCobEscalLiquiImpRangDesdImpo = "";
var jsCobEscalLiquiImpRangHastImpo = "";
var jsCobEscalLiquiValRangDesdPorc = "";
var jsCobEscalLiquiValRangHastPorc = "";
var jsCobEscalLiquiImpComiPorc = "";
var jsCobEscalLiquiImpComiImpo = "";
var jsCobEscalLiquiValObse = "";
var jsCobEscalLiquiMelcOidMetoLiquCobr = "";

//Variables de paginacion, 
var cobEscalLiquiPageCount = 1;

//Varible de columna que representa el campo de choice
var cobEscalLiquiChoiceColumn = 9;

//Flag de siguiente pagina;
var cobEscalLiquiMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var cobEscalLiquiTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 147;
var sizeFormView = 305;
var sizeFormUpdate = 305;

//Ultima busqueda realizada
var cobEscalLiquiLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("cobEscalLiquiFrm.numOrdeEsca");','focaliza("cobEscalLiquiFrm.numOrdeEsca");','focaliza("cobEscalLiquiFrm.numOrdeEsca");','focaliza("cobEscalLiquiFrm.numOrdeEsca");','focaliza("cobEscalLiquiFrm.numOrdeEsca");','focaliza("cobEscalLiquiFrm.numOrdeEsca");'],[3,'','focaliza("cobEscalLiquiFrm.impRangDesdImpo");','focaliza("cobEscalLiquiFrm.impRangDesdImpo");','','focaliza("cobEscalLiquiFrm.impRangDesdImpo");','focaliza("cobEscalLiquiFrm.impRangDesdImpo");'],[4,'','focaliza("cobEscalLiquiFrm.impRangHastImpo");','focaliza("cobEscalLiquiFrm.impRangHastImpo");','','focaliza("cobEscalLiquiFrm.impRangHastImpo");','focaliza("cobEscalLiquiFrm.impRangHastImpo");'],[5,'','focaliza("cobEscalLiquiFrm.valRangDesdPorc");','focaliza("cobEscalLiquiFrm.valRangDesdPorc");','','focaliza("cobEscalLiquiFrm.valRangDesdPorc");','focaliza("cobEscalLiquiFrm.valRangDesdPorc");'],[6,'','focaliza("cobEscalLiquiFrm.valRangHastPorc");','focaliza("cobEscalLiquiFrm.valRangHastPorc");','','focaliza("cobEscalLiquiFrm.valRangHastPorc");','focaliza("cobEscalLiquiFrm.valRangHastPorc");'],[7,'','focaliza("cobEscalLiquiFrm.impComiPorc");','focaliza("cobEscalLiquiFrm.impComiPorc");','','focaliza("cobEscalLiquiFrm.impComiPorc");','focaliza("cobEscalLiquiFrm.impComiPorc");'],[8,'','focaliza("cobEscalLiquiFrm.impComiImpo");','focaliza("cobEscalLiquiFrm.impComiImpo");','','focaliza("cobEscalLiquiFrm.impComiImpo");','focaliza("cobEscalLiquiFrm.impComiImpo");'],[9,'','focaliza("cobEscalLiquiFrm.valObse");','focaliza("cobEscalLiquiFrm.valObse");','','focaliza("cobEscalLiquiFrm.valObse");','focaliza("cobEscalLiquiFrm.valObse");'],[10,'focalizaComboDependence("cobEscalLiqui","melcOidMetoLiquCobr", false);','focalizaComboDependence("cobEscalLiqui","melcOidMetoLiquCobr", false);','focalizaComboDependence("cobEscalLiqui","melcOidMetoLiquCobr", false);','focalizaComboDependence("cobEscalLiqui","melcOidMetoLiquCobr", true);','focalizaComboDependence("cobEscalLiqui","melcOidMetoLiquCobr", true);','focalizaComboDependence("cobEscalLiqui","melcOidMetoLiquCobr", true);']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[3,'','focaliza("cobEscalLiquiFrm.impRangDesdImpo");','focaliza("cobEscalLiquiFrm.impRangDesdImpo");','','focaliza("cobEscalLiquiFrm.impRangDesdImpo");','focaliza("cobEscalLiquiFrm.impRangDesdImpo");'],[4,'','focaliza("cobEscalLiquiFrm.impRangHastImpo");','focaliza("cobEscalLiquiFrm.impRangHastImpo");','','focaliza("cobEscalLiquiFrm.impRangHastImpo");','focaliza("cobEscalLiquiFrm.impRangHastImpo");'],[5,'','focaliza("cobEscalLiquiFrm.valRangDesdPorc");','focaliza("cobEscalLiquiFrm.valRangDesdPorc");','','focaliza("cobEscalLiquiFrm.valRangDesdPorc");','focaliza("cobEscalLiquiFrm.valRangDesdPorc");'],[6,'','focaliza("cobEscalLiquiFrm.valRangHastPorc");','focaliza("cobEscalLiquiFrm.valRangHastPorc");','','focaliza("cobEscalLiquiFrm.valRangHastPorc");','focaliza("cobEscalLiquiFrm.valRangHastPorc");'],[7,'','focaliza("cobEscalLiquiFrm.impComiPorc");','focaliza("cobEscalLiquiFrm.impComiPorc");','','focaliza("cobEscalLiquiFrm.impComiPorc");','focaliza("cobEscalLiquiFrm.impComiPorc");'],[8,'','focaliza("cobEscalLiquiFrm.impComiImpo");','focaliza("cobEscalLiquiFrm.impComiImpo");','','focaliza("cobEscalLiquiFrm.impComiImpo");','focaliza("cobEscalLiquiFrm.impComiImpo");'],[9,'','focaliza("cobEscalLiquiFrm.valObse");','focaliza("cobEscalLiquiFrm.valObse");','','focaliza("cobEscalLiquiFrm.valObse");','focaliza("cobEscalLiquiFrm.valObse");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var melcOidMetoLiquCobrDependeceMap = new Vector();
melcOidMetoLiquCobrDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
melcOidMetoLiquCobrDependeceMap.agregar(['melcOidMetoLiquCobr', padresTmp, '', 'CobMetodLiquiView']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
cobEscalLiquiLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var cobEscalLiquiTmpUpdateValues;


		//funcion para impRangHastImpo y su validación con impRangDesdImpo
		function validacionimpRangHastImpoimpRangDesdImpo(){
			if ((get('cobEscalLiquiFrm.impRangHastImpo','T').toString()=="") || 
			(get('cobEscalLiquiFrm.impRangDesdImpo','T').toString()==""))
				//en este caso no hay alguno de los valores introducidos y no se puede realizar la verificación.
				return 'OK';
			if (!(parseFloat(get('cobEscalLiquiFrm.impRangHastImpo','T').toString())>parseFloat(get('cobEscalLiquiFrm.impRangDesdImpo','T').toString()))) {
				//mensaje de error internacionalizable
				return GestionarMensaje("CobEscalLiqui.impRangHastImpoimpRangDesdImpo.message");
			}
			else
				return 'OK';
		}
		
		//funcion para valRangHastPorc y su validación con valRangDesdPorc
		function validacionvalRangHastPorcvalRangDesdPorc(){
			if ((get('cobEscalLiquiFrm.valRangHastPorc','T').toString()=="") || 
			(get('cobEscalLiquiFrm.valRangDesdPorc','T').toString()==""))
				//en este caso no hay alguno de los valores introducidos y no se puede realizar la verificación.
				return 'OK';
			if (!(parseFloat(get('cobEscalLiquiFrm.valRangHastPorc','T').toString())>parseFloat(get('cobEscalLiquiFrm.valRangDesdPorc','T').toString()))) {
				//mensaje de error internacionalizable
				return GestionarMensaje("CobEscalLiqui.valRangHastPorcvalRangDesdPorc.message");
			}
			else
				return 'OK';
		}
		

//Función ejecutada en el onload de la pagina
function cobEscalLiquiInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('cobEscalLiquiFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('cobEscalLiquiFrm.accion')){
		case "query": cobEscalLiquiQueryInitComponents(); break;
		case "view": cobEscalLiquiViewInitComponents(); break;
		case "create": cobEscalLiquiCreateInitComponents(); break;
		case "update": cobEscalLiquiUpdateInitComponents(); break;
		case "remove": cobEscalLiquiRemoveInitComponents(); break;
		case "lov": cobEscalLiquiLovInitComponents(); break;
	}
	//alert('accion :' + get('cobEscalLiquiFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('cobEscalLiquiFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('cobEscalLiqui')) cobEscalLiquiCmdRequery();
}

function cobEscalLiquiQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	focusFirstField('cobEscalLiquiFrm', true);	
}

function cobEscalLiquiViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('cobEscalLiquiFrm', true);
}

function cobEscalLiquiCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('cobEscalLiquiFrm.numOrdeEsca','S', GestionarMensaje('CobEscalLiqui.numOrdeEsca.requiered.message'));
	
	setMV('cobEscalLiquiFrm.impComiPorc','S', GestionarMensaje('CobEscalLiqui.impComiPorc.requiered.message'));
	
	setMV('cobEscalLiquiFrm.impComiImpo','S', GestionarMensaje('CobEscalLiqui.impComiImpo.requiered.message'));
	
	setMV('cobEscalLiquiFrm.melcOidMetoLiquCobr','S', GestionarMensaje('CobEscalLiqui.melcOidMetoLiquCobr.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('cobEscalLiquiFrm', true);
}

function cobEscalLiquiUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('cobEscalLiquiFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		cobEscalLiquiTmpUpdateValues = cobEscalLiquiBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('cobEscalLiquiFrm.numOrdeEsca','S', GestionarMensaje('CobEscalLiqui.numOrdeEsca.requiered.message'));
		setMV('cobEscalLiquiFrm.impComiPorc','S', GestionarMensaje('CobEscalLiqui.impComiPorc.requiered.message'));
		setMV('cobEscalLiquiFrm.impComiImpo','S', GestionarMensaje('CobEscalLiqui.impComiImpo.requiered.message'));
		setMV('cobEscalLiquiFrm.melcOidMetoLiquCobr','S', GestionarMensaje('CobEscalLiqui.melcOidMetoLiquCobr.requiered.message'));
		
			focusFirstFieldModify('cobEscalLiquiFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		focusFirstField('cobEscalLiquiFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('cobEscalLiquiFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function cobEscalLiquiRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	cobEscalLiquiList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('cobEscalLiquiFrm', true);
}

function cobEscalLiquiLovInitComponents(){
	cobEscalLiquiLovReturnParameters = window.dialogArguments;
	
	focusFirstField('cobEscalLiquiFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad












//Función que permite cargar los datos de un elemento de lov seleccionado
function cobEscalLiquiSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('cobEscalLiquiFrm.' + campo, id);
	set('cobEscalLiquiFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function cobEscalLiquiLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	cobEscalLiquiLovReturnParameters.id = '';
	cobEscalLiquiLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function cobEscalLiquiLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cobEscalLiquiList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = cobEscalLiquiList.codSeleccionados();
	var descripcion = cobEscalLiquiList.extraeDato(
		cobEscalLiquiList.codSeleccionados()[0], cobEscalLiquiChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	cobEscalLiquiLovReturnParameters.id = codigo;
	cobEscalLiquiLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function cobEscalLiquiCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('cobEscalLiquiFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('cobEscalLiquiFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "cobEscalLiquiList", "CobEscalLiquiConectorTransactionQuery", 
		"result_ROWSET", parametros, "cobEscalLiquiPostQueryActions(datos);"]], "", "");	
}

function cobEscalLiquiCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('cobEscalLiquiFrm.lastQueryToSession'));
	var i =0;
	set('cobEscalLiquiFrm.numOrdeEsca', paramsRequery.ij(i++));
	
	set('cobEscalLiquiFrm.melcOidMetoLiquCobr', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la página de busqueda como la actual
	cobEscalLiquiPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	cobEscalLiquiCmdQuery(cobEscalLiquiPageCount);
}

function cobEscalLiquiFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	cobEscalLiquiPageCount = 1;
	cobEscalLiquiCmdQuery(cobEscalLiquiPageCount);
}

function cobEscalLiquiPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != cobEscalLiquiLastQuery){
		cobEscalLiquiFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	cobEscalLiquiPageCount--;
	cobEscalLiquiCmdQuery(cobEscalLiquiPageCount);
}

function cobEscalLiquiNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != cobEscalLiquiLastQuery){
		cobEscalLiquiFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	cobEscalLiquiPageCount++;
	cobEscalLiquiCmdQuery(cobEscalLiquiPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function cobEscalLiquiPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('cobEscalLiquiListLayer', 'O');
		visibilidad('cobEscalLiquiListButtonsLayer', 'O');
		if(get('cobEscalLiquiFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	cobEscalLiquiLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:cobEscalLiquiViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, cobEscalLiquiChoiceColumn) + "</A>",
			i, cobEscalLiquiChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	cobEscalLiquiList.setDatos(datosTmp.filtrar([0,1,2,3,4,5,6,7,8,9],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	cobEscalLiquiTimeStamps = datosTmp.filtrar([10],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		cobEscalLiquiMorePagesFlag = true;
		cobEscalLiquiList.eliminar(mmgPageSize, 1);
	}else{
		cobEscalLiquiMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('cobEscalLiquiFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('cobEscalLiquiListLayer', 'V');
	visibilidad('cobEscalLiquiListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('cobEscalLiquiList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	cobEscalLiquiList.display();
	
	//Actualizamos el estado de los botones 
	if(cobEscalLiquiMorePagesFlag){
		set_estado_botonera('cobEscalLiquiPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('cobEscalLiquiPaginationButtonBar',
			3,"inactivo");
	}
	if(cobEscalLiquiPageCount > 1){
		set_estado_botonera('cobEscalLiquiPaginationButtonBar',
			2,"activo");
		set_estado_botonera('cobEscalLiquiPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('cobEscalLiquiPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('cobEscalLiquiPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function cobEscalLiquiUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cobEscalLiquiList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('cobEscalLiquiFrm.idSelection', cobEscalLiquiList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('cobEscalLiquiFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = cobEscalLiquiList.codSeleccionados()[0];
		parametros["previousAction"] = get('cobEscalLiquiFrm.accion');
		parametros["accion"] = get('cobEscalLiquiFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('CobEscalLiquiLPStartUp', get('cobEscalLiquiFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) cobEscalLiquiCmdRequery();
	}
}

function cobEscalLiquiRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cobEscalLiquiList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = cobEscalLiquiList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('cobEscalLiquiFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(cobEscalLiquiList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += cobEscalLiquiTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('cobEscalLiquiFrm.timestamp', timestamps);


	cobEscalLiquiFrm.oculto='S';
	envia('cobEscalLiquiFrm');
	cobEscalLiquiFrm.oculto='N';
}

function cobEscalLiquiViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cobEscalLiquiList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	cobEscalLiquiViewDetail(cobEscalLiquiList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function cobEscalLiquiViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('cobEscalLiquiFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('CobEscalLiquiLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('cobEscalLiquiFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
	
	
	
		
	
	if(validacion){
		cobEscalLiquiFrm.oculto='S';
		envia('cobEscalLiquiFrm');
		cobEscalLiquiFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('cobEscalLiquiFrm.melcOidMetoLiquCobr').toString() == ''){
		set('cobEscalLiquiFrm.melcOidMetoLiquCobr', []);
		mmgResetCombosOnCascade('melcOidMetoLiquCobr', 'melcOidMetoLiquCobr', 'cobEscalLiqui');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	cobEscalLiquiRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('cobEscalLiquiFrm.accion');
	var origenTmp = get('cobEscalLiquiFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(cobEscalLiquiBuildUpdateRecordString() != cobEscalLiquiTmpUpdateValues){
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
	document.all.cobEscalLiquiListLayer.style.display='none';
	document.all.cobEscalLiquiListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.cobEscalLiquiListLayer.style.display='';
	document.all.cobEscalLiquiListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsCobEscalLiquiNumOrdeEsca = get('cobEscalLiquiFrm.numOrdeEsca').toString();
	jsCobEscalLiquiMelcOidMetoLiquCobr = get('cobEscalLiquiFrm.melcOidMetoLiquCobr')[0];
	
	
	var parametros = "";
	parametros += jsCobEscalLiquiNumOrdeEsca + "|";
	parametros += jsCobEscalLiquiMelcOidMetoLiquCobr + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function cobEscalLiquiBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsCobEscalLiquiNumOrdeEsca + "|";
	parametros += jsCobEscalLiquiImpRangDesdImpo + "|";
	parametros += jsCobEscalLiquiImpRangHastImpo + "|";
	parametros += jsCobEscalLiquiValRangDesdPorc + "|";
	parametros += jsCobEscalLiquiValRangHastPorc + "|";
	parametros += jsCobEscalLiquiImpComiPorc + "|";
	parametros += jsCobEscalLiquiImpComiImpo + "|";
	parametros += jsCobEscalLiquiValObse + "|";
	parametros += jsCobEscalLiquiMelcOidMetoLiquCobr + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('cobEscalLiquiFrm.accion'), 
		get('cobEscalLiquiFrm.origen'));
	
	jsCobEscalLiquiId = get('cobEscalLiquiFrm.id').toString();
	jsCobEscalLiquiNumOrdeEsca = get('cobEscalLiquiFrm.numOrdeEsca').toString();
	jsCobEscalLiquiImpRangDesdImpo = get('cobEscalLiquiFrm.impRangDesdImpo').toString();
	jsCobEscalLiquiImpRangHastImpo = get('cobEscalLiquiFrm.impRangHastImpo').toString();
	jsCobEscalLiquiValRangDesdPorc = get('cobEscalLiquiFrm.valRangDesdPorc').toString();
	jsCobEscalLiquiValRangHastPorc = get('cobEscalLiquiFrm.valRangHastPorc').toString();
	jsCobEscalLiquiImpComiPorc = get('cobEscalLiquiFrm.impComiPorc').toString();
	jsCobEscalLiquiImpComiImpo = get('cobEscalLiquiFrm.impComiImpo').toString();
	jsCobEscalLiquiValObse = get('cobEscalLiquiFrm.valObse').toString();
	jsCobEscalLiquiMelcOidMetoLiquCobr = get('cobEscalLiquiFrm.melcOidMetoLiquCobr')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('cobEscalLiquiFrm.accion'), 
		get('cobEscalLiquiFrm.origen'));


	set('cobEscalLiquiFrm.id', jsCobEscalLiquiId);
	set('cobEscalLiquiFrm.numOrdeEsca', jsCobEscalLiquiNumOrdeEsca);
	set('cobEscalLiquiFrm.impRangDesdImpo', jsCobEscalLiquiImpRangDesdImpo);
	set('cobEscalLiquiFrm.impRangHastImpo', jsCobEscalLiquiImpRangHastImpo);
	set('cobEscalLiquiFrm.valRangDesdPorc', jsCobEscalLiquiValRangDesdPorc);
	set('cobEscalLiquiFrm.valRangHastPorc', jsCobEscalLiquiValRangHastPorc);
	set('cobEscalLiquiFrm.impComiPorc', jsCobEscalLiquiImpComiPorc);
	set('cobEscalLiquiFrm.impComiImpo', jsCobEscalLiquiImpComiImpo);
	set('cobEscalLiquiFrm.valObse', jsCobEscalLiquiValObse);
	set('cobEscalLiquiFrm.melcOidMetoLiquCobr', [jsCobEscalLiquiMelcOidMetoLiquCobr]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsCobEscalLiquiNumOrdeEsca = '';
	jsCobEscalLiquiMelcOidMetoLiquCobr = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('cobEscalLiquiFrm.errCodigo', errorCode);
	set('cobEscalLiquiFrm.errDescripcion', description);
	set('cobEscalLiquiFrm.errSeverity', severity);
	fMostrarMensajeError();
}
