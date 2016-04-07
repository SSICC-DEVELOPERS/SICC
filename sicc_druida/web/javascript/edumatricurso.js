

/*
    INDRA/CAR/mmg
    $Id: edumatricurso.js,v 1.1 2009/12/03 19:01:52 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsEduMatriCursoId = "";
var jsEduMatriCursoPaisOidPais = "";
var jsEduMatriCursoCplcOidCabePlanCurs = "";
var jsEduMatriCursoCodCurs = "";
var jsEduMatriCursoTerrOidTerr = "";
var jsEduMatriCursoClasOidClas = "";
var jsEduMatriCursoFrcuOidFrec = "";
var jsEduMatriCursoRegaOidRega = "";
var jsEduMatriCursoZsgvOidSubgVent = "";
var jsEduMatriCursoZorgOidRegi = "";
var jsEduMatriCursoZzonOidZona = "";
var jsEduMatriCursoZsccOidSecc = "";
var jsEduMatriCursoZtadOidTerrAdmi = "";
var jsEduMatriCursoPerdOidPeriInicComp = "";
var jsEduMatriCursoPerdOidPeriFinaComp = "";
var jsEduMatriCursoPerdOidPeriInicCons = "";
var jsEduMatriCursoPerdOidPeriFinaCons = "";
var jsEduMatriCursoPerdOidPeriIngr = "";
var jsEduMatriCursoTicuOidTipoCurs = "";
var jsEduMatriCursoValPathFich = "";
var jsEduMatriCursoValObjeCurs = "";
var jsEduMatriCursoValContCurs = "";
var jsEduMatriCursoValRelaMateCurs = "";
var jsEduMatriCursoValMontVent = "";
var jsEduMatriCursoFecDispCurs = "";
var jsEduMatriCursoFecLanz = "";
var jsEduMatriCursoFecFinCurs = "";
var jsEduMatriCursoFecUltiCurs = "";
var jsEduMatriCursoFecConcCurs = "";
var jsEduMatriCursoFecIngr = "";
var jsEduMatriCursoNumPart = "";
var jsEduMatriCursoNumOrde = "";
var jsEduMatriCursoNumCampa = "";
var jsEduMatriCursoNumUnid = "";
var jsEduMatriCursoDesCurs = "";
var jsEduMatriCursoIndAcceDmrt = "";
var jsEduMatriCursoIndAcceInfo = "";
var jsEduMatriCursoIndAlcaGeog = "";
var jsEduMatriCursoIndBloqExte = "";
var jsEduMatriCursoIndMomeEntr = "";
var jsEduMatriCursoIndCondPedi = "";
var jsEduMatriCursoIndCtrlMoro = "";
var jsEduMatriCursoIndCtrlFunc = "";
var jsEduMatriCursoClclOidClieClasCapa = "";

//Variables de paginacion, 
var eduMatriCursoPageCount = 1;

//Varible de columna que representa el campo de choice
var eduMatriCursoChoiceColumn = 43;

//Flag de siguiente pagina;
var eduMatriCursoMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var eduMatriCursoTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 2495;
var sizeFormView = 2495;
var sizeFormUpdate = 2495;

//Ultima busqueda realizada
var eduMatriCursoLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[0,'focalizaComboDependence("eduMatriCurso","clclOidClieClasCapa", false);','focalizaComboDependence("eduMatriCurso","clclOidClieClasCapa", false);','focalizaComboDependence("eduMatriCurso","clclOidClieClasCapa", false);','focalizaComboDependence("eduMatriCurso","clclOidClieClasCapa", true);','focalizaComboDependence("eduMatriCurso","clclOidClieClasCapa", true);','focalizaComboDependence("eduMatriCurso","clclOidClieClasCapa", true);']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquí consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nomrbe de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var paisOidPaisDependeceMap = new Vector();
paisOidPaisDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais_fopaOidFormPago', padresTmp, 'paisOidPais', 'BelFormaPagoTapon']);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais_moneOidMone', padresTmp, 'paisOidPais', 'SegMoned']);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais_moneOidMoneAlt', padresTmp, 'paisOidPais', 'SegMoned']);
padresTmp =  new Vector();
padresTmp.cargar(['paisOidPais_fopaOidFormPago','paisOidPais_moneOidMone','paisOidPais_moneOidMoneAlt'])
paisOidPaisDependeceMap.agregar(['paisOidPais', padresTmp, '', 'SegPais']);
var cplcOidCabePlanCursDependeceMap = new Vector();
cplcOidCabePlanCursDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
cplcOidCabePlanCursDependeceMap.agregar(['cplcOidCabePlanCurs', padresTmp, '', 'EduPlantCursoCabec']);
var terrOidTerrDependeceMap = new Vector();
terrOidTerrDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
terrOidTerrDependeceMap.agregar(['terrOidTerr', padresTmp, '', 'ZonTerri']);
var clasOidClasDependeceMap = new Vector();
clasOidClasDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
clasOidClasDependeceMap.agregar(['clasOidClas_tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie', padresTmp, 'clasOidClas_tcclOidTipoClas_sbtiOidSubtClie', 'MaeTipoClienView']);
padresTmp =  new Vector();
padresTmp.cargar(['clasOidClas_tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie'])
clasOidClasDependeceMap.agregar(['clasOidClas_tcclOidTipoClas_sbtiOidSubtClie', padresTmp, 'clasOidClas_tcclOidTipoClas', 'MaeSubtiClien']);
padresTmp =  new Vector();
padresTmp.cargar(['clasOidClas_tcclOidTipoClas_sbtiOidSubtClie'])
clasOidClasDependeceMap.agregar(['clasOidClas_tcclOidTipoClas', padresTmp, 'clasOidClas', 'MaeTipoClasiClien']);
padresTmp =  new Vector();
padresTmp.cargar(['clasOidClas_tcclOidTipoClas'])
clasOidClasDependeceMap.agregar(['clasOidClas', padresTmp, '', 'MaeClasi']);
var frcuOidFrecDependeceMap = new Vector();
frcuOidFrecDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
frcuOidFrecDependeceMap.agregar(['frcuOidFrec', padresTmp, '', 'EduFrecuCurso']);
var regaOidRegaDependeceMap = new Vector();
regaOidRegaDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
regaOidRegaDependeceMap.agregar(['regaOidRega_prodOidProd', padresTmp, 'regaOidRega', 'MaeProdu']);
padresTmp =  new Vector();
padresTmp.cargar(['regaOidRega_prodOidProd'])
regaOidRegaDependeceMap.agregar(['regaOidRega', padresTmp, '', 'EduRegal']);
var zsgvOidSubgVentDependeceMap = new Vector();
zsgvOidSubgVentDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
zsgvOidSubgVentDependeceMap.agregar(['zsgvOidSubgVent', padresTmp, '', 'ZonSubGerenVenta']);
var zorgOidRegiDependeceMap = new Vector();
zorgOidRegiDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
zorgOidRegiDependeceMap.agregar(['zorgOidRegi', padresTmp, '', 'ZonRegio']);
var zzonOidZonaDependeceMap = new Vector();
zzonOidZonaDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
zzonOidZonaDependeceMap.agregar(['zzonOidZona', padresTmp, '', 'ZonZona']);
var zsccOidSeccDependeceMap = new Vector();
zsccOidSeccDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
zsccOidSeccDependeceMap.agregar(['zsccOidSecc', padresTmp, '', 'ZonSecci']);
var ztadOidTerrAdmiDependeceMap = new Vector();
ztadOidTerrAdmiDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
ztadOidTerrAdmiDependeceMap.agregar(['ztadOidTerrAdmi', padresTmp, '', 'ZonTerriAdmin']);
var perdOidPeriInicCompDependeceMap = new Vector();
perdOidPeriInicCompDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
perdOidPeriInicCompDependeceMap.agregar(['perdOidPeriInicComp', padresTmp, '', 'CraPerio']);
var perdOidPeriFinaCompDependeceMap = new Vector();
perdOidPeriFinaCompDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
perdOidPeriFinaCompDependeceMap.agregar(['perdOidPeriFinaComp', padresTmp, '', 'CraPerio']);
var perdOidPeriInicConsDependeceMap = new Vector();
perdOidPeriInicConsDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
perdOidPeriInicConsDependeceMap.agregar(['perdOidPeriInicCons', padresTmp, '', 'CraPerio']);
var perdOidPeriFinaConsDependeceMap = new Vector();
perdOidPeriFinaConsDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
perdOidPeriFinaConsDependeceMap.agregar(['perdOidPeriFinaCons', padresTmp, '', 'CraPerio']);
var perdOidPeriIngrDependeceMap = new Vector();
perdOidPeriIngrDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
perdOidPeriIngrDependeceMap.agregar(['perdOidPeriIngr', padresTmp, '', 'CraPerio']);
var ticuOidTipoCursDependeceMap = new Vector();
ticuOidTipoCursDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
ticuOidTipoCursDependeceMap.agregar(['ticuOidTipoCurs_marcOidMarc', padresTmp, 'ticuOidTipoCurs', 'SegMarca']);
padresTmp =  new Vector();
padresTmp.cargar(['ticuOidTipoCurs_marcOidMarc'])
ticuOidTipoCursDependeceMap.agregar(['ticuOidTipoCurs', padresTmp, '', 'EduTipoCurso']);
var clclOidClieClasCapaDependeceMap = new Vector();
clclOidClieClasCapaDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
clclOidClieClasCapaDependeceMap.agregar(['clclOidClieClasCapa', padresTmp, '', 'MaeClienClasi']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
eduMatriCursoLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var eduMatriCursoTmpUpdateValues;


//Función ejecutada en el onload de la pagina
function eduMatriCursoInitComponents(){
	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('eduMatriCursoFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('eduMatriCursoFrm.accion')){
		case "query": eduMatriCursoQueryInitComponents(); break;
		case "view": eduMatriCursoViewInitComponents(); break;
		case "create": eduMatriCursoCreateInitComponents(); break;
		case "update": eduMatriCursoUpdateInitComponents(); break;
		case "remove": eduMatriCursoRemoveInitComponents(); break;
		case "lov": eduMatriCursoLovInitComponents(); break;
	}
	
	//Ponemos el foco en el primer campo
	focusFirstField('eduMatriCursoFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('eduMatriCurso')) eduMatriCursoCmdRequery();
}

function eduMatriCursoQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

function eduMatriCursoViewInitComponents(){
	//En principiono se hace nada
}

function eduMatriCursoCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('eduMatriCursoFrm.paisOidPais','S', GestionarMensaje('EduMatriCurso.paisOidPais.requiered.message'));
	
	setMV('eduMatriCursoFrm.cplcOidCabePlanCurs','S', GestionarMensaje('EduMatriCurso.cplcOidCabePlanCurs.requiered.message'));
	
	setMV('eduMatriCursoFrm.codCurs','S', GestionarMensaje('EduMatriCurso.codCurs.requiered.message'));
	
	setMV('eduMatriCursoFrm.clclOidClieClasCapa','S', GestionarMensaje('EduMatriCurso.clclOidClieClasCapa.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
}

function eduMatriCursoUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('eduMatriCursoFrm.origen') == "pagina"){
		

		//Registramos el valor del elemento que estamos modificando
		eduMatriCursoTmpUpdateValues = eduMatriCursoBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('eduMatriCursoFrm.paisOidPais','S', GestionarMensaje('EduMatriCurso.paisOidPais.requiered.message'));
		
		setMV('eduMatriCursoFrm.cplcOidCabePlanCurs','S', GestionarMensaje('EduMatriCurso.cplcOidCabePlanCurs.requiered.message'));
		
		setMV('eduMatriCursoFrm.codCurs','S', GestionarMensaje('EduMatriCurso.codCurs.requiered.message'));
		
		setMV('eduMatriCursoFrm.clclOidClieClasCapa','S', GestionarMensaje('EduMatriCurso.clclOidClieClasCapa.requiered.message'));
		
		
	
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('eduMatriCursoFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function eduMatriCursoRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	eduMatriCursoList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');			
}

function eduMatriCursoLovInitComponents(){
	eduMatriCursoLovReturnParameters = window.dialogArguments;
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad














































//Función que permite cargar los datos de un elemento de lov seleccionado
function eduMatriCursoSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('eduMatriCursoFrm.' + campo, id);
	set('eduMatriCursoFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function eduMatriCursoLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	eduMatriCursoLovReturnParameters.id = '';
	eduMatriCursoLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function eduMatriCursoLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(eduMatriCursoList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = eduMatriCursoList.codSeleccionados();
	var descripcion = eduMatriCursoList.extraeDato(
		eduMatriCursoList.codSeleccionados()[0], eduMatriCursoChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	eduMatriCursoLovReturnParameters.id = codigo;
	eduMatriCursoLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function eduMatriCursoCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('eduMatriCursoFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	eduMatriCursoLastQuery = parametros;

	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('eduMatriCursoFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "eduMatriCursoList", "EduMatriCursoConectorTransactionQuery", 
		"result_ROWSET", parametros, "eduMatriCursoPostQueryActions(datos);"]], "", "");	
}

function eduMatriCursoCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('eduMatriCursoFrm.lastQueryToSession'));
	var i =0;
	set('eduMatriCursoFrm.paisOidPais', [paramsRequery.ij(i++)]);
	
	set('eduMatriCursoFrm.cplcOidCabePlanCurs', [paramsRequery.ij(i++)]);
	
	set('eduMatriCursoFrm.codCurs', paramsRequery.ij(i++));
	
	set('eduMatriCursoFrm.terrOidTerr', [paramsRequery.ij(i++)]);
	
	set('eduMatriCursoFrm.clasOidClas', [paramsRequery.ij(i++)]);
	
	set('eduMatriCursoFrm.frcuOidFrec', [paramsRequery.ij(i++)]);
	
	set('eduMatriCursoFrm.regaOidRega', [paramsRequery.ij(i++)]);
	
	set('eduMatriCursoFrm.zsgvOidSubgVent', [paramsRequery.ij(i++)]);
	
	set('eduMatriCursoFrm.zorgOidRegi', [paramsRequery.ij(i++)]);
	
	set('eduMatriCursoFrm.zzonOidZona', [paramsRequery.ij(i++)]);
	
	set('eduMatriCursoFrm.zsccOidSecc', [paramsRequery.ij(i++)]);
	
	set('eduMatriCursoFrm.ztadOidTerrAdmi', [paramsRequery.ij(i++)]);
	
	set('eduMatriCursoFrm.perdOidPeriInicComp', [paramsRequery.ij(i++)]);
	
	set('eduMatriCursoFrm.perdOidPeriFinaComp', [paramsRequery.ij(i++)]);
	
	set('eduMatriCursoFrm.perdOidPeriInicCons', [paramsRequery.ij(i++)]);
	
	set('eduMatriCursoFrm.perdOidPeriFinaCons', [paramsRequery.ij(i++)]);
	
	set('eduMatriCursoFrm.perdOidPeriIngr', [paramsRequery.ij(i++)]);
	
	set('eduMatriCursoFrm.ticuOidTipoCurs', [paramsRequery.ij(i++)]);
	
	set('eduMatriCursoFrm.valPathFich', paramsRequery.ij(i++));
	
	set('eduMatriCursoFrm.valObjeCurs', paramsRequery.ij(i++));
	
	set('eduMatriCursoFrm.valContCurs', paramsRequery.ij(i++));
	
	set('eduMatriCursoFrm.valRelaMateCurs', paramsRequery.ij(i++));
	
	set('eduMatriCursoFrm.valMontVent', paramsRequery.ij(i++));
	
	set('eduMatriCursoFrm.fecDispCurs', paramsRequery.ij(i++));
	
	set('eduMatriCursoFrm.fecLanz', paramsRequery.ij(i++));
	
	set('eduMatriCursoFrm.fecFinCurs', paramsRequery.ij(i++));
	
	set('eduMatriCursoFrm.fecUltiCurs', paramsRequery.ij(i++));
	
	set('eduMatriCursoFrm.fecConcCurs', paramsRequery.ij(i++));
	
	set('eduMatriCursoFrm.fecIngr', paramsRequery.ij(i++));
	
	set('eduMatriCursoFrm.numPart', paramsRequery.ij(i++));
	
	set('eduMatriCursoFrm.numOrde', paramsRequery.ij(i++));
	
	set('eduMatriCursoFrm.numCampa', paramsRequery.ij(i++));
	
	set('eduMatriCursoFrm.numUnid', paramsRequery.ij(i++));
	
	set('eduMatriCursoFrm.desCurs', paramsRequery.ij(i++));
	
	set('eduMatriCursoFrm.indAcceDmrt', paramsRequery.ij(i++));
	
	set('eduMatriCursoFrm.indAcceInfo', paramsRequery.ij(i++));
	
	set('eduMatriCursoFrm.indAlcaGeog', paramsRequery.ij(i++));
	
	set('eduMatriCursoFrm.indBloqExte', paramsRequery.ij(i++));
	
	set('eduMatriCursoFrm.indMomeEntr', paramsRequery.ij(i++));
	
	set('eduMatriCursoFrm.indCondPedi', paramsRequery.ij(i++));
	
	set('eduMatriCursoFrm.indCtrlMoro', paramsRequery.ij(i++));
	
	set('eduMatriCursoFrm.indCtrlFunc', paramsRequery.ij(i++));
	
	set('eduMatriCursoFrm.clclOidClieClasCapa', [paramsRequery.ij(i++)]);
	
	
	
	//No se nos actualizar los parmámetros de la paginación
	eduMatriCursoPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	eduMatriCursoCmdQuery(eduMatriCursoPageCount);
}

function eduMatriCursoFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	eduMatriCursoPageCount = 1;
	eduMatriCursoCmdQuery(eduMatriCursoPageCount);
}

function eduMatriCursoPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != eduMatriCursoLastQuery){
		eduMatriCursoFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	eduMatriCursoPageCount--;
	eduMatriCursoCmdQuery(eduMatriCursoPageCount);
}

function eduMatriCursoNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != eduMatriCursoLastQuery){
		eduMatriCursoFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	eduMatriCursoPageCount++;
	eduMatriCursoCmdQuery(eduMatriCursoPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function eduMatriCursoPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('eduMatriCursoListLayer', 'O');
		visibilidad('eduMatriCursoListButtonsLayer', 'O');
		if(get('eduMatriCursoFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:eduMatriCursoViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, eduMatriCursoChoiceColumn) + "</A>",
			i, eduMatriCursoChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	eduMatriCursoList.setDatos(datosTmp.filtrar([0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	eduMatriCursoTimeStamps = datosTmp.filtrar([44],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		eduMatriCursoMorePagesFlag = true;
		eduMatriCursoList.eliminar(mmgPageSize, 1);
	}else{
		eduMatriCursoMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('eduMatriCursoFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('eduMatriCursoListLayer', 'V');
	visibilidad('eduMatriCursoListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('eduMatriCursoList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	eduMatriCursoList.display();
	
	//Actualizamos el estado de los botones 
	if(eduMatriCursoMorePagesFlag){
		set_estado_botonera('eduMatriCursoPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('eduMatriCursoPaginationButtonBar',
			3,"inactivo");
	}
	if(eduMatriCursoPageCount > 1){
		set_estado_botonera('eduMatriCursoPaginationButtonBar',
			2,"activo");
		set_estado_botonera('eduMatriCursoPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('eduMatriCursoPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('eduMatriCursoPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function eduMatriCursoUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(eduMatriCursoList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('eduMatriCursoFrm.idSelection', eduMatriCursoList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('eduMatriCursoFrm', true);
	if(validacion){
		/*set('eduMatriCursoFrm.previousAction', 'update');
		set('eduMatriCursoFrm.ON', 'EduMatriCursoLPStartUp');
		set('eduMatriCursoFrm.conectorAction', 'EduMatriCursoLPStartUp');
		set('eduMatriCursoFrm.origen', 'pagina');
		envia('eduMatriCursoFrm');*/

		var parametros = new Array();
		parametros["idSelection"] = eduMatriCursoList.codSeleccionados()[0];
		parametros["previousAction"] = get('eduMatriCursoFrm.accion');
		parametros["accion"] = get('eduMatriCursoFrm.accion');
		parametros["origen"] = 'pagina';
		var result = mostrarModalSICC('EduMatriCursoLPStartUp', get('eduMatriCursoFrm.accion'), parametros, null, sizeFormView + 30);
		if(result == MMG_RC_OK) eduMatriCursoCmdRequery();
	}
}

function eduMatriCursoRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(eduMatriCursoList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = eduMatriCursoList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('eduMatriCursoFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(eduMatriCursoList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += eduMatriCursoTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('eduMatriCursoFrm.timestamp', timestamps);
	envia('eduMatriCursoFrm');
}

function eduMatriCursoViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(eduMatriCursoList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Actualizamos la accion a view, el origen a pagina, el action a la LP de StartUp y el modo desde el cual hemos
	//ido al view
	set('eduMatriCursoFrm.previousAction', get('eduMatriCursoFrm.accion'));
	set('eduMatriCursoFrm.accion', 'view');
	set('eduMatriCursoFrm.origen', 'pagina');
	set('eduMatriCursoFrm.ON', 'EduMatriCursoLPStartUp');
	
	//Establcemos el id del elemento seleccionado
	set('eduMatriCursoFrm.idSelection', eduMatriCursoList.codSeleccionados()[0]);
	
	//Enviamos el formualrio
	//envia('eduMatriCursoFrm');
	eduMatriCursoViewDetail(eduMatriCursoList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function eduMatriCursoViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('eduMatriCursoFrm.accion');
	parametros["accion"] = get('eduMatriCursoFrm.accion');
	parametros["origen"] = 'pagina';
	mostrarModalSICC('EduMatriCursoLPStartUp', get('eduMatriCursoFrm.accion'), parametros, null, sizeFormView + 30);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar on dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('eduMatriCursoFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	if(validacion)envia('eduMatriCursoFrm');
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	eduMatriCursoRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('eduMatriCursoFrm.accion');
	var origenTmp = get('eduMatriCursoFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(eduMatriCursoBuildUpdateRecordString() != eduMatriCursoTmpUpdateValues){
			var respuesta = cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.update.lostchanges.message'));
			if(respuesta == true){
				Guardar();
				return;
			}
		}
	
		set('eduMatriCursoFrm.performRequery', 'true');
		set('eduMatriCursoFrm.accion', 
			get('eduMatriCursoFrm.previousAction'));
		set('eduMatriCursoFrm.origen', 'menu');
		set('eduMatriCursoFrm.ON', 'EduMatriCursoLPStartUp');
		set('eduMatriCursoFrm.conectorAction', 'EduMatriCursoLPStartUp');
		eduMatriCursoFrm.oculto='N';
		envia('eduMatriCursoFrm');
	}else if(accionTmp == 'view'){
		window.close();
	}else Volver();
}

//Cambia el estado de las cajas de texto de los lovs del formulario
function setNonEditableElementsStatus(status){
	
}

function minimizeLayers(){
	document.all.eduMatriCursoListLayer.style.display='none';
	document.all.eduMatriCursoListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.eduMatriCursoListLayer.style.display='';
	document.all.eduMatriCursoListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda

	jsEduMatriCursoPaisOidPais = get('eduMatriCursoFrm.paisOidPais')[0];





	jsEduMatriCursoCplcOidCabePlanCurs = get('eduMatriCursoFrm.cplcOidCabePlanCurs')[0];




	jsEduMatriCursoCodCurs = get('eduMatriCursoFrm.codCurs').toString();







	jsEduMatriCursoTerrOidTerr = get('eduMatriCursoFrm.terrOidTerr')[0];





	jsEduMatriCursoClasOidClas = get('eduMatriCursoFrm.clasOidClas')[0];





	jsEduMatriCursoFrcuOidFrec = get('eduMatriCursoFrm.frcuOidFrec')[0];





	jsEduMatriCursoRegaOidRega = get('eduMatriCursoFrm.regaOidRega')[0];





	jsEduMatriCursoZsgvOidSubgVent = get('eduMatriCursoFrm.zsgvOidSubgVent')[0];





	jsEduMatriCursoZorgOidRegi = get('eduMatriCursoFrm.zorgOidRegi')[0];





	jsEduMatriCursoZzonOidZona = get('eduMatriCursoFrm.zzonOidZona')[0];





	jsEduMatriCursoZsccOidSecc = get('eduMatriCursoFrm.zsccOidSecc')[0];





	jsEduMatriCursoZtadOidTerrAdmi = get('eduMatriCursoFrm.ztadOidTerrAdmi')[0];





	jsEduMatriCursoPerdOidPeriInicComp = get('eduMatriCursoFrm.perdOidPeriInicComp')[0];





	jsEduMatriCursoPerdOidPeriFinaComp = get('eduMatriCursoFrm.perdOidPeriFinaComp')[0];





	jsEduMatriCursoPerdOidPeriInicCons = get('eduMatriCursoFrm.perdOidPeriInicCons')[0];





	jsEduMatriCursoPerdOidPeriFinaCons = get('eduMatriCursoFrm.perdOidPeriFinaCons')[0];





	jsEduMatriCursoPerdOidPeriIngr = get('eduMatriCursoFrm.perdOidPeriIngr')[0];





	jsEduMatriCursoTicuOidTipoCurs = get('eduMatriCursoFrm.ticuOidTipoCurs')[0];




	jsEduMatriCursoValPathFich = get('eduMatriCursoFrm.valPathFich').toString();






	jsEduMatriCursoValObjeCurs = get('eduMatriCursoFrm.valObjeCurs').toString();






	jsEduMatriCursoValContCurs = get('eduMatriCursoFrm.valContCurs').toString();






	jsEduMatriCursoValRelaMateCurs = get('eduMatriCursoFrm.valRelaMateCurs').toString();






	jsEduMatriCursoValMontVent = get('eduMatriCursoFrm.valMontVent').toString();






	jsEduMatriCursoFecDispCurs = get('eduMatriCursoFrm.fecDispCurs').toString();






	jsEduMatriCursoFecLanz = get('eduMatriCursoFrm.fecLanz').toString();






	jsEduMatriCursoFecFinCurs = get('eduMatriCursoFrm.fecFinCurs').toString();






	jsEduMatriCursoFecUltiCurs = get('eduMatriCursoFrm.fecUltiCurs').toString();






	jsEduMatriCursoFecConcCurs = get('eduMatriCursoFrm.fecConcCurs').toString();






	jsEduMatriCursoFecIngr = get('eduMatriCursoFrm.fecIngr').toString();






	jsEduMatriCursoNumPart = get('eduMatriCursoFrm.numPart').toString();






	jsEduMatriCursoNumOrde = get('eduMatriCursoFrm.numOrde').toString();






	jsEduMatriCursoNumCampa = get('eduMatriCursoFrm.numCampa').toString();






	jsEduMatriCursoNumUnid = get('eduMatriCursoFrm.numUnid').toString();






	jsEduMatriCursoDesCurs = get('eduMatriCursoFrm.desCurs').toString();






	jsEduMatriCursoIndAcceDmrt = get('eduMatriCursoFrm.indAcceDmrt').toString();






	jsEduMatriCursoIndAcceInfo = get('eduMatriCursoFrm.indAcceInfo').toString();






	jsEduMatriCursoIndAlcaGeog = get('eduMatriCursoFrm.indAlcaGeog').toString();






	jsEduMatriCursoIndBloqExte = get('eduMatriCursoFrm.indBloqExte').toString();






	jsEduMatriCursoIndMomeEntr = get('eduMatriCursoFrm.indMomeEntr').toString();






	jsEduMatriCursoIndCondPedi = get('eduMatriCursoFrm.indCondPedi').toString();






	jsEduMatriCursoIndCtrlMoro = get('eduMatriCursoFrm.indCtrlMoro').toString();






	jsEduMatriCursoIndCtrlFunc = get('eduMatriCursoFrm.indCtrlFunc').toString();







	jsEduMatriCursoClclOidClieClasCapa = get('eduMatriCursoFrm.clclOidClieClasCapa')[0];






	var parametros = "";
	parametros += jsEduMatriCursoPaisOidPais + "|";



	parametros += jsEduMatriCursoCplcOidCabePlanCurs + "|";



	parametros += jsEduMatriCursoCodCurs + "|";



	parametros += jsEduMatriCursoTerrOidTerr + "|";



	parametros += jsEduMatriCursoClasOidClas + "|";



	parametros += jsEduMatriCursoFrcuOidFrec + "|";



	parametros += jsEduMatriCursoRegaOidRega + "|";



	parametros += jsEduMatriCursoZsgvOidSubgVent + "|";



	parametros += jsEduMatriCursoZorgOidRegi + "|";



	parametros += jsEduMatriCursoZzonOidZona + "|";



	parametros += jsEduMatriCursoZsccOidSecc + "|";



	parametros += jsEduMatriCursoZtadOidTerrAdmi + "|";



	parametros += jsEduMatriCursoPerdOidPeriInicComp + "|";



	parametros += jsEduMatriCursoPerdOidPeriFinaComp + "|";



	parametros += jsEduMatriCursoPerdOidPeriInicCons + "|";



	parametros += jsEduMatriCursoPerdOidPeriFinaCons + "|";



	parametros += jsEduMatriCursoPerdOidPeriIngr + "|";



	parametros += jsEduMatriCursoTicuOidTipoCurs + "|";



	parametros += jsEduMatriCursoValPathFich + "|";



	parametros += jsEduMatriCursoValObjeCurs + "|";



	parametros += jsEduMatriCursoValContCurs + "|";



	parametros += jsEduMatriCursoValRelaMateCurs + "|";



	parametros += jsEduMatriCursoValMontVent + "|";



	parametros += jsEduMatriCursoFecDispCurs + "|";



	parametros += jsEduMatriCursoFecLanz + "|";



	parametros += jsEduMatriCursoFecFinCurs + "|";



	parametros += jsEduMatriCursoFecUltiCurs + "|";



	parametros += jsEduMatriCursoFecConcCurs + "|";



	parametros += jsEduMatriCursoFecIngr + "|";



	parametros += jsEduMatriCursoNumPart + "|";



	parametros += jsEduMatriCursoNumOrde + "|";



	parametros += jsEduMatriCursoNumCampa + "|";



	parametros += jsEduMatriCursoNumUnid + "|";



	parametros += jsEduMatriCursoDesCurs + "|";



	parametros += jsEduMatriCursoIndAcceDmrt + "|";



	parametros += jsEduMatriCursoIndAcceInfo + "|";



	parametros += jsEduMatriCursoIndAlcaGeog + "|";



	parametros += jsEduMatriCursoIndBloqExte + "|";



	parametros += jsEduMatriCursoIndMomeEntr + "|";



	parametros += jsEduMatriCursoIndCondPedi + "|";



	parametros += jsEduMatriCursoIndCtrlMoro + "|";



	parametros += jsEduMatriCursoIndCtrlFunc + "|";



	parametros += jsEduMatriCursoClclOidClieClasCapa + "|";




	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function eduMatriCursoBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsEduMatriCursoPaisOidPais + "|";
	parametros += jsEduMatriCursoCplcOidCabePlanCurs + "|";
	parametros += jsEduMatriCursoCodCurs + "|";
	parametros += jsEduMatriCursoTerrOidTerr + "|";
	parametros += jsEduMatriCursoClasOidClas + "|";
	parametros += jsEduMatriCursoFrcuOidFrec + "|";
	parametros += jsEduMatriCursoRegaOidRega + "|";
	parametros += jsEduMatriCursoZsgvOidSubgVent + "|";
	parametros += jsEduMatriCursoZorgOidRegi + "|";
	parametros += jsEduMatriCursoZzonOidZona + "|";
	parametros += jsEduMatriCursoZsccOidSecc + "|";
	parametros += jsEduMatriCursoZtadOidTerrAdmi + "|";
	parametros += jsEduMatriCursoPerdOidPeriInicComp + "|";
	parametros += jsEduMatriCursoPerdOidPeriFinaComp + "|";
	parametros += jsEduMatriCursoPerdOidPeriInicCons + "|";
	parametros += jsEduMatriCursoPerdOidPeriFinaCons + "|";
	parametros += jsEduMatriCursoPerdOidPeriIngr + "|";
	parametros += jsEduMatriCursoTicuOidTipoCurs + "|";
	parametros += jsEduMatriCursoValPathFich + "|";
	parametros += jsEduMatriCursoValObjeCurs + "|";
	parametros += jsEduMatriCursoValContCurs + "|";
	parametros += jsEduMatriCursoValRelaMateCurs + "|";
	parametros += jsEduMatriCursoValMontVent + "|";
	parametros += jsEduMatriCursoFecDispCurs + "|";
	parametros += jsEduMatriCursoFecLanz + "|";
	parametros += jsEduMatriCursoFecFinCurs + "|";
	parametros += jsEduMatriCursoFecUltiCurs + "|";
	parametros += jsEduMatriCursoFecConcCurs + "|";
	parametros += jsEduMatriCursoFecIngr + "|";
	parametros += jsEduMatriCursoNumPart + "|";
	parametros += jsEduMatriCursoNumOrde + "|";
	parametros += jsEduMatriCursoNumCampa + "|";
	parametros += jsEduMatriCursoNumUnid + "|";
	parametros += jsEduMatriCursoDesCurs + "|";
	parametros += jsEduMatriCursoIndAcceDmrt + "|";
	parametros += jsEduMatriCursoIndAcceInfo + "|";
	parametros += jsEduMatriCursoIndAlcaGeog + "|";
	parametros += jsEduMatriCursoIndBloqExte + "|";
	parametros += jsEduMatriCursoIndMomeEntr + "|";
	parametros += jsEduMatriCursoIndCondPedi + "|";
	parametros += jsEduMatriCursoIndCtrlMoro + "|";
	parametros += jsEduMatriCursoIndCtrlFunc + "|";
	parametros += jsEduMatriCursoClclOidClieClasCapa + "|";

	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('eduMatriCursoFrm.accion'), 
		get('eduMatriCursoFrm.origen'));
	
	jsEduMatriCursoId = get('eduMatriCursoFrm.id').toString();
	jsEduMatriCursoPaisOidPais = get('eduMatriCursoFrm.paisOidPais')[0];
	jsEduMatriCursoCplcOidCabePlanCurs = get('eduMatriCursoFrm.cplcOidCabePlanCurs')[0];
	jsEduMatriCursoCodCurs = get('eduMatriCursoFrm.codCurs').toString();
	jsEduMatriCursoTerrOidTerr = get('eduMatriCursoFrm.terrOidTerr')[0];
	jsEduMatriCursoClasOidClas = get('eduMatriCursoFrm.clasOidClas')[0];
	jsEduMatriCursoFrcuOidFrec = get('eduMatriCursoFrm.frcuOidFrec')[0];
	jsEduMatriCursoRegaOidRega = get('eduMatriCursoFrm.regaOidRega')[0];
	jsEduMatriCursoZsgvOidSubgVent = get('eduMatriCursoFrm.zsgvOidSubgVent')[0];
	jsEduMatriCursoZorgOidRegi = get('eduMatriCursoFrm.zorgOidRegi')[0];
	jsEduMatriCursoZzonOidZona = get('eduMatriCursoFrm.zzonOidZona')[0];
	jsEduMatriCursoZsccOidSecc = get('eduMatriCursoFrm.zsccOidSecc')[0];
	jsEduMatriCursoZtadOidTerrAdmi = get('eduMatriCursoFrm.ztadOidTerrAdmi')[0];
	jsEduMatriCursoPerdOidPeriInicComp = get('eduMatriCursoFrm.perdOidPeriInicComp')[0];
	jsEduMatriCursoPerdOidPeriFinaComp = get('eduMatriCursoFrm.perdOidPeriFinaComp')[0];
	jsEduMatriCursoPerdOidPeriInicCons = get('eduMatriCursoFrm.perdOidPeriInicCons')[0];
	jsEduMatriCursoPerdOidPeriFinaCons = get('eduMatriCursoFrm.perdOidPeriFinaCons')[0];
	jsEduMatriCursoPerdOidPeriIngr = get('eduMatriCursoFrm.perdOidPeriIngr')[0];
	jsEduMatriCursoTicuOidTipoCurs = get('eduMatriCursoFrm.ticuOidTipoCurs')[0];
	jsEduMatriCursoValPathFich = get('eduMatriCursoFrm.valPathFich').toString();
	jsEduMatriCursoValObjeCurs = get('eduMatriCursoFrm.valObjeCurs').toString();
	jsEduMatriCursoValContCurs = get('eduMatriCursoFrm.valContCurs').toString();
	jsEduMatriCursoValRelaMateCurs = get('eduMatriCursoFrm.valRelaMateCurs').toString();
	jsEduMatriCursoValMontVent = get('eduMatriCursoFrm.valMontVent').toString();
	jsEduMatriCursoFecDispCurs = get('eduMatriCursoFrm.fecDispCurs').toString();
	jsEduMatriCursoFecLanz = get('eduMatriCursoFrm.fecLanz').toString();
	jsEduMatriCursoFecFinCurs = get('eduMatriCursoFrm.fecFinCurs').toString();
	jsEduMatriCursoFecUltiCurs = get('eduMatriCursoFrm.fecUltiCurs').toString();
	jsEduMatriCursoFecConcCurs = get('eduMatriCursoFrm.fecConcCurs').toString();
	jsEduMatriCursoFecIngr = get('eduMatriCursoFrm.fecIngr').toString();
	jsEduMatriCursoNumPart = get('eduMatriCursoFrm.numPart').toString();
	jsEduMatriCursoNumOrde = get('eduMatriCursoFrm.numOrde').toString();
	jsEduMatriCursoNumCampa = get('eduMatriCursoFrm.numCampa').toString();
	jsEduMatriCursoNumUnid = get('eduMatriCursoFrm.numUnid').toString();
	jsEduMatriCursoDesCurs = get('eduMatriCursoFrm.desCurs').toString();
	jsEduMatriCursoIndAcceDmrt = get('eduMatriCursoFrm.indAcceDmrt').toString();
	jsEduMatriCursoIndAcceInfo = get('eduMatriCursoFrm.indAcceInfo').toString();
	jsEduMatriCursoIndAlcaGeog = get('eduMatriCursoFrm.indAlcaGeog').toString();
	jsEduMatriCursoIndBloqExte = get('eduMatriCursoFrm.indBloqExte').toString();
	jsEduMatriCursoIndMomeEntr = get('eduMatriCursoFrm.indMomeEntr').toString();
	jsEduMatriCursoIndCondPedi = get('eduMatriCursoFrm.indCondPedi').toString();
	jsEduMatriCursoIndCtrlMoro = get('eduMatriCursoFrm.indCtrlMoro').toString();
	jsEduMatriCursoIndCtrlFunc = get('eduMatriCursoFrm.indCtrlFunc').toString();
	jsEduMatriCursoClclOidClieClasCapa = get('eduMatriCursoFrm.clclOidClieClasCapa')[0];

}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('eduMatriCursoFrm.accion'), 
		get('eduMatriCursoFrm.origen'));


	set('eduMatriCursoFrm.id', jsEduMatriCursoId);
	set('eduMatriCursoFrm.paisOidPais', [jsEduMatriCursoPaisOidPais]);
	set('eduMatriCursoFrm.cplcOidCabePlanCurs', [jsEduMatriCursoCplcOidCabePlanCurs]);
	set('eduMatriCursoFrm.codCurs', jsEduMatriCursoCodCurs);
	set('eduMatriCursoFrm.terrOidTerr', [jsEduMatriCursoTerrOidTerr]);
	set('eduMatriCursoFrm.clasOidClas', [jsEduMatriCursoClasOidClas]);
	set('eduMatriCursoFrm.frcuOidFrec', [jsEduMatriCursoFrcuOidFrec]);
	set('eduMatriCursoFrm.regaOidRega', [jsEduMatriCursoRegaOidRega]);
	set('eduMatriCursoFrm.zsgvOidSubgVent', [jsEduMatriCursoZsgvOidSubgVent]);
	set('eduMatriCursoFrm.zorgOidRegi', [jsEduMatriCursoZorgOidRegi]);
	set('eduMatriCursoFrm.zzonOidZona', [jsEduMatriCursoZzonOidZona]);
	set('eduMatriCursoFrm.zsccOidSecc', [jsEduMatriCursoZsccOidSecc]);
	set('eduMatriCursoFrm.ztadOidTerrAdmi', [jsEduMatriCursoZtadOidTerrAdmi]);
	set('eduMatriCursoFrm.perdOidPeriInicComp', [jsEduMatriCursoPerdOidPeriInicComp]);
	set('eduMatriCursoFrm.perdOidPeriFinaComp', [jsEduMatriCursoPerdOidPeriFinaComp]);
	set('eduMatriCursoFrm.perdOidPeriInicCons', [jsEduMatriCursoPerdOidPeriInicCons]);
	set('eduMatriCursoFrm.perdOidPeriFinaCons', [jsEduMatriCursoPerdOidPeriFinaCons]);
	set('eduMatriCursoFrm.perdOidPeriIngr', [jsEduMatriCursoPerdOidPeriIngr]);
	set('eduMatriCursoFrm.ticuOidTipoCurs', [jsEduMatriCursoTicuOidTipoCurs]);
	set('eduMatriCursoFrm.valPathFich', jsEduMatriCursoValPathFich);
	set('eduMatriCursoFrm.valObjeCurs', jsEduMatriCursoValObjeCurs);
	set('eduMatriCursoFrm.valContCurs', jsEduMatriCursoValContCurs);
	set('eduMatriCursoFrm.valRelaMateCurs', jsEduMatriCursoValRelaMateCurs);
	set('eduMatriCursoFrm.valMontVent', jsEduMatriCursoValMontVent);
	set('eduMatriCursoFrm.fecDispCurs', jsEduMatriCursoFecDispCurs);
	set('eduMatriCursoFrm.fecLanz', jsEduMatriCursoFecLanz);
	set('eduMatriCursoFrm.fecFinCurs', jsEduMatriCursoFecFinCurs);
	set('eduMatriCursoFrm.fecUltiCurs', jsEduMatriCursoFecUltiCurs);
	set('eduMatriCursoFrm.fecConcCurs', jsEduMatriCursoFecConcCurs);
	set('eduMatriCursoFrm.fecIngr', jsEduMatriCursoFecIngr);
	set('eduMatriCursoFrm.numPart', jsEduMatriCursoNumPart);
	set('eduMatriCursoFrm.numOrde', jsEduMatriCursoNumOrde);
	set('eduMatriCursoFrm.numCampa', jsEduMatriCursoNumCampa);
	set('eduMatriCursoFrm.numUnid', jsEduMatriCursoNumUnid);
	set('eduMatriCursoFrm.desCurs', jsEduMatriCursoDesCurs);
	set('eduMatriCursoFrm.indAcceDmrt', jsEduMatriCursoIndAcceDmrt);
	set('eduMatriCursoFrm.indAcceInfo', jsEduMatriCursoIndAcceInfo);
	set('eduMatriCursoFrm.indAlcaGeog', jsEduMatriCursoIndAlcaGeog);
	set('eduMatriCursoFrm.indBloqExte', jsEduMatriCursoIndBloqExte);
	set('eduMatriCursoFrm.indMomeEntr', jsEduMatriCursoIndMomeEntr);
	set('eduMatriCursoFrm.indCondPedi', jsEduMatriCursoIndCondPedi);
	set('eduMatriCursoFrm.indCtrlMoro', jsEduMatriCursoIndCtrlMoro);
	set('eduMatriCursoFrm.indCtrlFunc', jsEduMatriCursoIndCtrlFunc);
	set('eduMatriCursoFrm.clclOidClieClasCapa', [jsEduMatriCursoClclOidClieClasCapa]);

}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('eduMatriCursoFrm.errCodigo', errorCode);
	set('eduMatriCursoFrm.errDescripcion', description);
	set('eduMatriCursoFrm.errSeverity', severity);
	fMostrarMensajeError();
}





	
