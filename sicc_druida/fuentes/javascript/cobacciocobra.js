

/*
    INDRA/CAR/mmg
    $Id: cobacciocobra.js,v 1.1 2009/12/03 19:02:11 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsCobAccioCobraId = "";
var jsCobAccioCobraCodAcciCobr = "";
var jsCobAccioCobraValDesc = "";
var jsCobAccioCobraSaccOidSubtAcci = "";
var jsCobAccioCobraIndFechHoraSegu = "";
var jsCobAccioCobraIndFechImpoComp = "";
var jsCobAccioCobraIndFechHoraNuevSegu = "";
var jsCobAccioCobraIndAporPrue = "";
var jsCobAccioCobraIndDescPrue = "";
var jsCobAccioCobraIndNumeDocuSopo = "";
var jsCobAccioCobraIndTipoDocuPago = "";
var jsCobAccioCobraIndBancSucu = "";
var jsCobAccioCobraIndNuevDire = "";
var jsCobAccioCobraIndNuevTelf = "";
var jsCobAccioCobraIndPasaAdmi = "";
var jsCobAccioCobraIndPetiBloqAdmi = "";
var jsCobAccioCobraIndPetiDesbAdmi = "";
var jsCobAccioCobraIndAcciMensReco = "";
var jsCobAccioCobraIndObse = "";
var jsCobAccioCobraValObse = "";
var jsCobAccioCobraPaisOidPais = "";

//Variables de paginacion, 
var cobAccioCobraPageCount = 1;

//Varible de columna que representa el campo de choice
var cobAccioCobraChoiceColumn = 2;

//Flag de siguiente pagina;
var cobAccioCobraMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var cobAccioCobraTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 105;
var sizeFormView = 755;
var sizeFormUpdate = 755;

//Ultima busqueda realizada
var cobAccioCobraLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("cobAccioCobraFrm.codAcciCobr");','focaliza("cobAccioCobraFrm.codAcciCobr");','focaliza("cobAccioCobraFrm.codAcciCobr");','focaliza("cobAccioCobraFrm.codAcciCobr");','focaliza("cobAccioCobraFrm.codAcciCobr");','focaliza("cobAccioCobraFrm.codAcciCobr");'],[3,'focaliza("cobAccioCobraFrm.valDesc");','focaliza("cobAccioCobraFrm.valDesc");','focaliza("cobAccioCobraFrm.valDesc");','focaliza("cobAccioCobraFrm.valDesc");','focaliza("cobAccioCobraFrm.valDesc");','focaliza("cobAccioCobraFrm.valDesc");'],[4,'','focalizaComboDependence("cobAccioCobra","saccOidSubtAcci", false);','focalizaComboDependence("cobAccioCobra","saccOidSubtAcci", false);','','focalizaComboDependence("cobAccioCobra","saccOidSubtAcci", true);','focalizaComboDependence("cobAccioCobra","saccOidSubtAcci", true);'],[5,'','focaliza("cobAccioCobraFrm.indFechHoraSegu");','focaliza("cobAccioCobraFrm.indFechHoraSegu");','','focaliza("cobAccioCobraFrm.indFechHoraSegu");','focaliza("cobAccioCobraFrm.indFechHoraSegu");'],[6,'','focaliza("cobAccioCobraFrm.indFechImpoComp");','focaliza("cobAccioCobraFrm.indFechImpoComp");','','focaliza("cobAccioCobraFrm.indFechImpoComp");','focaliza("cobAccioCobraFrm.indFechImpoComp");'],[7,'','focaliza("cobAccioCobraFrm.indFechHoraNuevSegu");','focaliza("cobAccioCobraFrm.indFechHoraNuevSegu");','','focaliza("cobAccioCobraFrm.indFechHoraNuevSegu");','focaliza("cobAccioCobraFrm.indFechHoraNuevSegu");'],[8,'','focaliza("cobAccioCobraFrm.indAporPrue");','focaliza("cobAccioCobraFrm.indAporPrue");','','focaliza("cobAccioCobraFrm.indAporPrue");','focaliza("cobAccioCobraFrm.indAporPrue");'],[9,'','focaliza("cobAccioCobraFrm.indDescPrue");','focaliza("cobAccioCobraFrm.indDescPrue");','','focaliza("cobAccioCobraFrm.indDescPrue");','focaliza("cobAccioCobraFrm.indDescPrue");'],[10,'','focaliza("cobAccioCobraFrm.indNumeDocuSopo");','focaliza("cobAccioCobraFrm.indNumeDocuSopo");','','focaliza("cobAccioCobraFrm.indNumeDocuSopo");','focaliza("cobAccioCobraFrm.indNumeDocuSopo");'],[11,'','focaliza("cobAccioCobraFrm.indTipoDocuPago");','focaliza("cobAccioCobraFrm.indTipoDocuPago");','','focaliza("cobAccioCobraFrm.indTipoDocuPago");','focaliza("cobAccioCobraFrm.indTipoDocuPago");'],[12,'','focaliza("cobAccioCobraFrm.indBancSucu");','focaliza("cobAccioCobraFrm.indBancSucu");','','focaliza("cobAccioCobraFrm.indBancSucu");','focaliza("cobAccioCobraFrm.indBancSucu");'],[13,'','focaliza("cobAccioCobraFrm.indNuevDire");','focaliza("cobAccioCobraFrm.indNuevDire");','','focaliza("cobAccioCobraFrm.indNuevDire");','focaliza("cobAccioCobraFrm.indNuevDire");'],[14,'','focaliza("cobAccioCobraFrm.indNuevTelf");','focaliza("cobAccioCobraFrm.indNuevTelf");','','focaliza("cobAccioCobraFrm.indNuevTelf");','focaliza("cobAccioCobraFrm.indNuevTelf");'],[15,'','focaliza("cobAccioCobraFrm.indPasaAdmi");','focaliza("cobAccioCobraFrm.indPasaAdmi");','','focaliza("cobAccioCobraFrm.indPasaAdmi");','focaliza("cobAccioCobraFrm.indPasaAdmi");'],[16,'','focaliza("cobAccioCobraFrm.indPetiBloqAdmi");','focaliza("cobAccioCobraFrm.indPetiBloqAdmi");','','focaliza("cobAccioCobraFrm.indPetiBloqAdmi");','focaliza("cobAccioCobraFrm.indPetiBloqAdmi");'],[17,'','focaliza("cobAccioCobraFrm.indPetiDesbAdmi");','focaliza("cobAccioCobraFrm.indPetiDesbAdmi");','','focaliza("cobAccioCobraFrm.indPetiDesbAdmi");','focaliza("cobAccioCobraFrm.indPetiDesbAdmi");'],[18,'','focaliza("cobAccioCobraFrm.indAcciMensReco");','focaliza("cobAccioCobraFrm.indAcciMensReco");','','focaliza("cobAccioCobraFrm.indAcciMensReco");','focaliza("cobAccioCobraFrm.indAcciMensReco");'],[19,'','focaliza("cobAccioCobraFrm.indObse");','focaliza("cobAccioCobraFrm.indObse");','','focaliza("cobAccioCobraFrm.indObse");','focaliza("cobAccioCobraFrm.indObse");'],[20,'','focaliza("cobAccioCobraFrm.valObse");','focaliza("cobAccioCobraFrm.valObse");','','focaliza("cobAccioCobraFrm.valObse");','focaliza("cobAccioCobraFrm.valObse");'],[21,'','','','','','']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[3,'focaliza("cobAccioCobraFrm.valDesc");','focaliza("cobAccioCobraFrm.valDesc");','focaliza("cobAccioCobraFrm.valDesc");','focaliza("cobAccioCobraFrm.valDesc");','focaliza("cobAccioCobraFrm.valDesc");','focaliza("cobAccioCobraFrm.valDesc");'],[4,'','focalizaComboDependence("cobAccioCobra","saccOidSubtAcci", false);','focalizaComboDependence("cobAccioCobra","saccOidSubtAcci", false);','','focalizaComboDependence("cobAccioCobra","saccOidSubtAcci", true);','focalizaComboDependence("cobAccioCobra","saccOidSubtAcci", true);'],[5,'','focaliza("cobAccioCobraFrm.indFechHoraSegu");','focaliza("cobAccioCobraFrm.indFechHoraSegu");','','focaliza("cobAccioCobraFrm.indFechHoraSegu");','focaliza("cobAccioCobraFrm.indFechHoraSegu");'],[6,'','focaliza("cobAccioCobraFrm.indFechImpoComp");','focaliza("cobAccioCobraFrm.indFechImpoComp");','','focaliza("cobAccioCobraFrm.indFechImpoComp");','focaliza("cobAccioCobraFrm.indFechImpoComp");'],[7,'','focaliza("cobAccioCobraFrm.indFechHoraNuevSegu");','focaliza("cobAccioCobraFrm.indFechHoraNuevSegu");','','focaliza("cobAccioCobraFrm.indFechHoraNuevSegu");','focaliza("cobAccioCobraFrm.indFechHoraNuevSegu");'],[8,'','focaliza("cobAccioCobraFrm.indAporPrue");','focaliza("cobAccioCobraFrm.indAporPrue");','','focaliza("cobAccioCobraFrm.indAporPrue");','focaliza("cobAccioCobraFrm.indAporPrue");'],[9,'','focaliza("cobAccioCobraFrm.indDescPrue");','focaliza("cobAccioCobraFrm.indDescPrue");','','focaliza("cobAccioCobraFrm.indDescPrue");','focaliza("cobAccioCobraFrm.indDescPrue");'],[10,'','focaliza("cobAccioCobraFrm.indNumeDocuSopo");','focaliza("cobAccioCobraFrm.indNumeDocuSopo");','','focaliza("cobAccioCobraFrm.indNumeDocuSopo");','focaliza("cobAccioCobraFrm.indNumeDocuSopo");'],[11,'','focaliza("cobAccioCobraFrm.indTipoDocuPago");','focaliza("cobAccioCobraFrm.indTipoDocuPago");','','focaliza("cobAccioCobraFrm.indTipoDocuPago");','focaliza("cobAccioCobraFrm.indTipoDocuPago");'],[12,'','focaliza("cobAccioCobraFrm.indBancSucu");','focaliza("cobAccioCobraFrm.indBancSucu");','','focaliza("cobAccioCobraFrm.indBancSucu");','focaliza("cobAccioCobraFrm.indBancSucu");'],[13,'','focaliza("cobAccioCobraFrm.indNuevDire");','focaliza("cobAccioCobraFrm.indNuevDire");','','focaliza("cobAccioCobraFrm.indNuevDire");','focaliza("cobAccioCobraFrm.indNuevDire");'],[14,'','focaliza("cobAccioCobraFrm.indNuevTelf");','focaliza("cobAccioCobraFrm.indNuevTelf");','','focaliza("cobAccioCobraFrm.indNuevTelf");','focaliza("cobAccioCobraFrm.indNuevTelf");'],[15,'','focaliza("cobAccioCobraFrm.indPasaAdmi");','focaliza("cobAccioCobraFrm.indPasaAdmi");','','focaliza("cobAccioCobraFrm.indPasaAdmi");','focaliza("cobAccioCobraFrm.indPasaAdmi");'],[16,'','focaliza("cobAccioCobraFrm.indPetiBloqAdmi");','focaliza("cobAccioCobraFrm.indPetiBloqAdmi");','','focaliza("cobAccioCobraFrm.indPetiBloqAdmi");','focaliza("cobAccioCobraFrm.indPetiBloqAdmi");'],[17,'','focaliza("cobAccioCobraFrm.indPetiDesbAdmi");','focaliza("cobAccioCobraFrm.indPetiDesbAdmi");','','focaliza("cobAccioCobraFrm.indPetiDesbAdmi");','focaliza("cobAccioCobraFrm.indPetiDesbAdmi");'],[18,'','focaliza("cobAccioCobraFrm.indAcciMensReco");','focaliza("cobAccioCobraFrm.indAcciMensReco");','','focaliza("cobAccioCobraFrm.indAcciMensReco");','focaliza("cobAccioCobraFrm.indAcciMensReco");'],[19,'','focaliza("cobAccioCobraFrm.indObse");','focaliza("cobAccioCobraFrm.indObse");','','focaliza("cobAccioCobraFrm.indObse");','focaliza("cobAccioCobraFrm.indObse");'],[20,'','focaliza("cobAccioCobraFrm.valObse");','focaliza("cobAccioCobraFrm.valObse");','','focaliza("cobAccioCobraFrm.valObse");','focaliza("cobAccioCobraFrm.valObse");'],[21,'','','','','','']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var saccOidSubtAcciDependeceMap = new Vector();
saccOidSubtAcciDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
saccOidSubtAcciDependeceMap.agregar(['saccOidSubtAcci', padresTmp, '', 'CobSubtiAccio']);
var paisOidPaisDependeceMap = new Vector();
paisOidPaisDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais', padresTmp, '', 'SegPaisView']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
cobAccioCobraLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var cobAccioCobraTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function cobAccioCobraInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('cobAccioCobraFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('cobAccioCobraFrm.accion')){
		case "query": cobAccioCobraQueryInitComponents(); break;
		case "view": cobAccioCobraViewInitComponents(); break;
		case "create": cobAccioCobraCreateInitComponents(); break;
		case "update": cobAccioCobraUpdateInitComponents(); break;
		case "remove": cobAccioCobraRemoveInitComponents(); break;
		case "lov": cobAccioCobraLovInitComponents(); break;
	}
	//alert('accion :' + get('cobAccioCobraFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('cobAccioCobraFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('cobAccioCobra')) cobAccioCobraCmdRequery();
}

function cobAccioCobraQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	focusFirstField('cobAccioCobraFrm', true);	
}

function cobAccioCobraViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	//Establecemos el valor de los radiobuttons
		set('cobAccioCobraFrm.indFechHoraSegu', get('cobAccioCobraFrm.indFechHoraSeguCheckValue'));
		set('cobAccioCobraFrm.indFechImpoComp', get('cobAccioCobraFrm.indFechImpoCompCheckValue'));
		set('cobAccioCobraFrm.indFechHoraNuevSegu', get('cobAccioCobraFrm.indFechHoraNuevSeguCheckValue'));
		set('cobAccioCobraFrm.indAporPrue', get('cobAccioCobraFrm.indAporPrueCheckValue'));
		set('cobAccioCobraFrm.indDescPrue', get('cobAccioCobraFrm.indDescPrueCheckValue'));
		set('cobAccioCobraFrm.indNumeDocuSopo', get('cobAccioCobraFrm.indNumeDocuSopoCheckValue'));
		set('cobAccioCobraFrm.indTipoDocuPago', get('cobAccioCobraFrm.indTipoDocuPagoCheckValue'));
		set('cobAccioCobraFrm.indBancSucu', get('cobAccioCobraFrm.indBancSucuCheckValue'));
		set('cobAccioCobraFrm.indNuevDire', get('cobAccioCobraFrm.indNuevDireCheckValue'));
		set('cobAccioCobraFrm.indNuevTelf', get('cobAccioCobraFrm.indNuevTelfCheckValue'));
		set('cobAccioCobraFrm.indPasaAdmi', get('cobAccioCobraFrm.indPasaAdmiCheckValue'));
		set('cobAccioCobraFrm.indPetiBloqAdmi', get('cobAccioCobraFrm.indPetiBloqAdmiCheckValue'));
		set('cobAccioCobraFrm.indPetiDesbAdmi', get('cobAccioCobraFrm.indPetiDesbAdmiCheckValue'));
		set('cobAccioCobraFrm.indAcciMensReco', get('cobAccioCobraFrm.indAcciMensRecoCheckValue'));
		set('cobAccioCobraFrm.indObse', get('cobAccioCobraFrm.indObseCheckValue'));
		
	focusFirstField('cobAccioCobraFrm', true);
}

function cobAccioCobraCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('cobAccioCobraFrm.codAcciCobr','S', GestionarMensaje('CobAccioCobra.codAcciCobr.requiered.message'));
	
	setMV('cobAccioCobraFrm.valDesc','S', GestionarMensaje('CobAccioCobra.valDesc.requiered.message'));
	
	setMV('cobAccioCobraFrm.saccOidSubtAcci','S', GestionarMensaje('CobAccioCobra.saccOidSubtAcci.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('cobAccioCobraFrm', true);
}

function cobAccioCobraUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('cobAccioCobraFrm.origen') == "pagina"){
		

		//Establecemos el valor de los radiobuttons
			set('cobAccioCobraFrm.indFechHoraSegu', get('cobAccioCobraFrm.indFechHoraSeguCheckValue'));
			set('cobAccioCobraFrm.indFechImpoComp', get('cobAccioCobraFrm.indFechImpoCompCheckValue'));
			set('cobAccioCobraFrm.indFechHoraNuevSegu', get('cobAccioCobraFrm.indFechHoraNuevSeguCheckValue'));
			set('cobAccioCobraFrm.indAporPrue', get('cobAccioCobraFrm.indAporPrueCheckValue'));
			set('cobAccioCobraFrm.indDescPrue', get('cobAccioCobraFrm.indDescPrueCheckValue'));
			set('cobAccioCobraFrm.indNumeDocuSopo', get('cobAccioCobraFrm.indNumeDocuSopoCheckValue'));
			set('cobAccioCobraFrm.indTipoDocuPago', get('cobAccioCobraFrm.indTipoDocuPagoCheckValue'));
			set('cobAccioCobraFrm.indBancSucu', get('cobAccioCobraFrm.indBancSucuCheckValue'));
			set('cobAccioCobraFrm.indNuevDire', get('cobAccioCobraFrm.indNuevDireCheckValue'));
			set('cobAccioCobraFrm.indNuevTelf', get('cobAccioCobraFrm.indNuevTelfCheckValue'));
			set('cobAccioCobraFrm.indPasaAdmi', get('cobAccioCobraFrm.indPasaAdmiCheckValue'));
			set('cobAccioCobraFrm.indPetiBloqAdmi', get('cobAccioCobraFrm.indPetiBloqAdmiCheckValue'));
			set('cobAccioCobraFrm.indPetiDesbAdmi', get('cobAccioCobraFrm.indPetiDesbAdmiCheckValue'));
			set('cobAccioCobraFrm.indAcciMensReco', get('cobAccioCobraFrm.indAcciMensRecoCheckValue'));
			set('cobAccioCobraFrm.indObse', get('cobAccioCobraFrm.indObseCheckValue'));
			

		//Registramos el valor del elemento que estamos modificando
		cobAccioCobraTmpUpdateValues = cobAccioCobraBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('cobAccioCobraFrm.codAcciCobr','S', GestionarMensaje('CobAccioCobra.codAcciCobr.requiered.message'));
		setMV('cobAccioCobraFrm.valDesc','S', GestionarMensaje('CobAccioCobra.valDesc.requiered.message'));
		setMV('cobAccioCobraFrm.saccOidSubtAcci','S', GestionarMensaje('CobAccioCobra.saccOidSubtAcci.requiered.message'));
		
			focusFirstFieldModify('cobAccioCobraFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		focusFirstField('cobAccioCobraFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('cobAccioCobraFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function cobAccioCobraRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	cobAccioCobraList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('cobAccioCobraFrm', true);
}

function cobAccioCobraLovInitComponents(){
	cobAccioCobraLovReturnParameters = window.dialogArguments;
	
	focusFirstField('cobAccioCobraFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad























//Función que permite cargar los datos de un elemento de lov seleccionado
function cobAccioCobraSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('cobAccioCobraFrm.' + campo, id);
	set('cobAccioCobraFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function cobAccioCobraLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	cobAccioCobraLovReturnParameters.id = '';
	cobAccioCobraLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function cobAccioCobraLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cobAccioCobraList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = cobAccioCobraList.codSeleccionados();
	var descripcion = cobAccioCobraList.extraeDato(
		cobAccioCobraList.codSeleccionados()[0], cobAccioCobraChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	cobAccioCobraLovReturnParameters.id = codigo;
	cobAccioCobraLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function cobAccioCobraCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('cobAccioCobraFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('cobAccioCobraFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "cobAccioCobraList", "CobAccioCobraConectorTransactionQuery", 
		"result_ROWSET", parametros, "cobAccioCobraPostQueryActions(datos);"]], "", "");	
}

function cobAccioCobraCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('cobAccioCobraFrm.lastQueryToSession'));
	var i =0;
	set('cobAccioCobraFrm.codAcciCobr', paramsRequery.ij(i++));
	
	set('cobAccioCobraFrm.valDesc', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	cobAccioCobraPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	cobAccioCobraCmdQuery(cobAccioCobraPageCount);
}

function cobAccioCobraFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	cobAccioCobraPageCount = 1;
	cobAccioCobraCmdQuery(cobAccioCobraPageCount);
}

function cobAccioCobraPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != cobAccioCobraLastQuery){
		cobAccioCobraFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	cobAccioCobraPageCount--;
	cobAccioCobraCmdQuery(cobAccioCobraPageCount);
}

function cobAccioCobraNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != cobAccioCobraLastQuery){
		cobAccioCobraFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	cobAccioCobraPageCount++;
	cobAccioCobraCmdQuery(cobAccioCobraPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function cobAccioCobraPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('cobAccioCobraListLayer', 'O');
		visibilidad('cobAccioCobraListButtonsLayer', 'O');
		if(get('cobAccioCobraFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	cobAccioCobraLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:cobAccioCobraViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, cobAccioCobraChoiceColumn) + "</A>",
			i, cobAccioCobraChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	cobAccioCobraList.setDatos(datosTmp.filtrar([0,1,2],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	cobAccioCobraTimeStamps = datosTmp.filtrar([3],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		cobAccioCobraMorePagesFlag = true;
		cobAccioCobraList.eliminar(mmgPageSize, 1);
	}else{
		cobAccioCobraMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('cobAccioCobraFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('cobAccioCobraListLayer', 'V');
	visibilidad('cobAccioCobraListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('cobAccioCobraList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	cobAccioCobraList.display();
	
	//Actualizamos el estado de los botones 
	if(cobAccioCobraMorePagesFlag){
		set_estado_botonera('cobAccioCobraPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('cobAccioCobraPaginationButtonBar',
			3,"inactivo");
	}
	if(cobAccioCobraPageCount > 1){
		set_estado_botonera('cobAccioCobraPaginationButtonBar',
			2,"activo");
		set_estado_botonera('cobAccioCobraPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('cobAccioCobraPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('cobAccioCobraPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function cobAccioCobraUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cobAccioCobraList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('cobAccioCobraFrm.idSelection', cobAccioCobraList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('cobAccioCobraFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = cobAccioCobraList.codSeleccionados()[0];
		parametros["previousAction"] = get('cobAccioCobraFrm.accion');
		parametros["accion"] = get('cobAccioCobraFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('CobAccioCobraLPStartUp', get('cobAccioCobraFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) cobAccioCobraCmdRequery();
	}
}

function cobAccioCobraRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cobAccioCobraList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = cobAccioCobraList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('cobAccioCobraFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(cobAccioCobraList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += cobAccioCobraTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('cobAccioCobraFrm.timestamp', timestamps);


	cobAccioCobraFrm.oculto='S';
	envia('cobAccioCobraFrm');
	cobAccioCobraFrm.oculto='N';
}

function cobAccioCobraViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cobAccioCobraList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	cobAccioCobraViewDetail(cobAccioCobraList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function cobAccioCobraViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('cobAccioCobraFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('CobAccioCobraLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('cobAccioCobraFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	if(validacion){
		cobAccioCobraFrm.oculto='S';
		envia('cobAccioCobraFrm');
		cobAccioCobraFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('cobAccioCobraFrm.saccOidSubtAcci').toString() == ''){
		set('cobAccioCobraFrm.saccOidSubtAcci', []);
		mmgResetCombosOnCascade('saccOidSubtAcci', 'saccOidSubtAcci', 'cobAccioCobra');
		
	}
	if(get('cobAccioCobraFrm.paisOidPais').toString() == ''){
		set('cobAccioCobraFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'cobAccioCobra');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	cobAccioCobraRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('cobAccioCobraFrm.accion');
	var origenTmp = get('cobAccioCobraFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(cobAccioCobraBuildUpdateRecordString() != cobAccioCobraTmpUpdateValues){
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
	document.all.cobAccioCobraListLayer.style.display='none';
	document.all.cobAccioCobraListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.cobAccioCobraListLayer.style.display='';
	document.all.cobAccioCobraListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsCobAccioCobraCodAcciCobr = get('cobAccioCobraFrm.codAcciCobr').toString();
	jsCobAccioCobraValDesc = get('cobAccioCobraFrm.valDesc').toString();
	
	
	var parametros = "";
	parametros += jsCobAccioCobraCodAcciCobr + "|";
	parametros += jsCobAccioCobraValDesc + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function cobAccioCobraBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsCobAccioCobraCodAcciCobr + "|";
	parametros += jsCobAccioCobraValDesc + "|";
	parametros += jsCobAccioCobraSaccOidSubtAcci + "|";
	parametros += jsCobAccioCobraIndFechHoraSegu + "|";
	parametros += jsCobAccioCobraIndFechImpoComp + "|";
	parametros += jsCobAccioCobraIndFechHoraNuevSegu + "|";
	parametros += jsCobAccioCobraIndAporPrue + "|";
	parametros += jsCobAccioCobraIndDescPrue + "|";
	parametros += jsCobAccioCobraIndNumeDocuSopo + "|";
	parametros += jsCobAccioCobraIndTipoDocuPago + "|";
	parametros += jsCobAccioCobraIndBancSucu + "|";
	parametros += jsCobAccioCobraIndNuevDire + "|";
	parametros += jsCobAccioCobraIndNuevTelf + "|";
	parametros += jsCobAccioCobraIndPasaAdmi + "|";
	parametros += jsCobAccioCobraIndPetiBloqAdmi + "|";
	parametros += jsCobAccioCobraIndPetiDesbAdmi + "|";
	parametros += jsCobAccioCobraIndAcciMensReco + "|";
	parametros += jsCobAccioCobraIndObse + "|";
	parametros += jsCobAccioCobraValObse + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('cobAccioCobraFrm.accion'), 
		get('cobAccioCobraFrm.origen'));
	
	jsCobAccioCobraId = get('cobAccioCobraFrm.id').toString();
	jsCobAccioCobraCodAcciCobr = get('cobAccioCobraFrm.codAcciCobr').toString();
	jsCobAccioCobraValDesc = get('cobAccioCobraFrm.valDesc').toString();
	jsCobAccioCobraSaccOidSubtAcci = get('cobAccioCobraFrm.saccOidSubtAcci')[0];
	jsCobAccioCobraIndFechHoraSegu = get('cobAccioCobraFrm.indFechHoraSegu');
	jsCobAccioCobraIndFechImpoComp = get('cobAccioCobraFrm.indFechImpoComp');
	jsCobAccioCobraIndFechHoraNuevSegu = get('cobAccioCobraFrm.indFechHoraNuevSegu');
	jsCobAccioCobraIndAporPrue = get('cobAccioCobraFrm.indAporPrue');
	jsCobAccioCobraIndDescPrue = get('cobAccioCobraFrm.indDescPrue');
	jsCobAccioCobraIndNumeDocuSopo = get('cobAccioCobraFrm.indNumeDocuSopo');
	jsCobAccioCobraIndTipoDocuPago = get('cobAccioCobraFrm.indTipoDocuPago');
	jsCobAccioCobraIndBancSucu = get('cobAccioCobraFrm.indBancSucu');
	jsCobAccioCobraIndNuevDire = get('cobAccioCobraFrm.indNuevDire');
	jsCobAccioCobraIndNuevTelf = get('cobAccioCobraFrm.indNuevTelf');
	jsCobAccioCobraIndPasaAdmi = get('cobAccioCobraFrm.indPasaAdmi');
	jsCobAccioCobraIndPetiBloqAdmi = get('cobAccioCobraFrm.indPetiBloqAdmi');
	jsCobAccioCobraIndPetiDesbAdmi = get('cobAccioCobraFrm.indPetiDesbAdmi');
	jsCobAccioCobraIndAcciMensReco = get('cobAccioCobraFrm.indAcciMensReco');
	jsCobAccioCobraIndObse = get('cobAccioCobraFrm.indObse');
	jsCobAccioCobraValObse = get('cobAccioCobraFrm.valObse').toString();
	jsCobAccioCobraPaisOidPais = get('cobAccioCobraFrm.paisOidPais')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('cobAccioCobraFrm.accion'), 
		get('cobAccioCobraFrm.origen'));


	set('cobAccioCobraFrm.id', jsCobAccioCobraId);
	set('cobAccioCobraFrm.codAcciCobr', jsCobAccioCobraCodAcciCobr);
	set('cobAccioCobraFrm.valDesc', jsCobAccioCobraValDesc);
	set('cobAccioCobraFrm.saccOidSubtAcci', [jsCobAccioCobraSaccOidSubtAcci]);
	set('cobAccioCobraFrm.indFechHoraSegu', jsCobAccioCobraIndFechHoraSegu);
	set('cobAccioCobraFrm.indFechImpoComp', jsCobAccioCobraIndFechImpoComp);
	set('cobAccioCobraFrm.indFechHoraNuevSegu', jsCobAccioCobraIndFechHoraNuevSegu);
	set('cobAccioCobraFrm.indAporPrue', jsCobAccioCobraIndAporPrue);
	set('cobAccioCobraFrm.indDescPrue', jsCobAccioCobraIndDescPrue);
	set('cobAccioCobraFrm.indNumeDocuSopo', jsCobAccioCobraIndNumeDocuSopo);
	set('cobAccioCobraFrm.indTipoDocuPago', jsCobAccioCobraIndTipoDocuPago);
	set('cobAccioCobraFrm.indBancSucu', jsCobAccioCobraIndBancSucu);
	set('cobAccioCobraFrm.indNuevDire', jsCobAccioCobraIndNuevDire);
	set('cobAccioCobraFrm.indNuevTelf', jsCobAccioCobraIndNuevTelf);
	set('cobAccioCobraFrm.indPasaAdmi', jsCobAccioCobraIndPasaAdmi);
	set('cobAccioCobraFrm.indPetiBloqAdmi', jsCobAccioCobraIndPetiBloqAdmi);
	set('cobAccioCobraFrm.indPetiDesbAdmi', jsCobAccioCobraIndPetiDesbAdmi);
	set('cobAccioCobraFrm.indAcciMensReco', jsCobAccioCobraIndAcciMensReco);
	set('cobAccioCobraFrm.indObse', jsCobAccioCobraIndObse);
	set('cobAccioCobraFrm.valObse', jsCobAccioCobraValObse);
	set('cobAccioCobraFrm.paisOidPais', [jsCobAccioCobraPaisOidPais]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsCobAccioCobraCodAcciCobr = '';
	jsCobAccioCobraValDesc = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('cobAccioCobraFrm.errCodigo', errorCode);
	set('cobAccioCobraFrm.errDescripcion', description);
	set('cobAccioCobraFrm.errSeverity', severity);
	fMostrarMensajeError();
}
