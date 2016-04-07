  /**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */

/*
 *   INDRA/CAR/mmg
 *   $Id: apecentrdistr.js,v 1.1 2009/12/03 19:01:36 pecbazalar Exp $
 *   DESC
 */

//Variables temporales para almacenar los valores de los campos del formualrio
var jsApeCentrDistrId = "";
var jsApeCentrDistrValCentDist = "";
var jsApeCentrDistrValDesc = "";
var jsApeCentrDistrValNiveOuts = "";
var jsApeCentrDistrValSistCubi = "";
var jsApeCentrDistrValProgCubi = "";
var jsApeCentrDistrValProg = "";
var jsApeCentrDistrPaisOidPais = "";

//Variables de paginacion, 
var apeCentrDistrPageCount = 1;

//Varible de columna que representa el campo de choice
var apeCentrDistrChoiceColumn = 1;

//Flag de siguiente pagina;
var apeCentrDistrMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var apeCentrDistrTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 315;
var sizeFormView = 301;
var sizeFormUpdate = 301;

//Ultima busqueda realizada
var apeCentrDistrLastQuery= null;

/*  Vector con acciones de foco. El vector esta compuesto por 7 
columnas. 
  * La primera columna contiene el orden del foco 
  * Las otras seis columnas son las acción a ejecutar en los tres 
  posibles modos (query, modify, update) y para los dos evento 
  de foco (siguinete campo y campo)
  * [ordenFoco, anterior-Query, anterior-Create, 
  anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
  */
var accionesFoco = new Vector();
accionesFoco.cargar([
[2,'focaliza("apeCentrDistrFrm.valCentDist");',
'focaliza("apeCentrDistrFrm.valCentDist");',
'focaliza("apeCentrDistrFrm.valCentDist");',
'focaliza("apeCentrDistrFrm.valCentDist");',
'focaliza("apeCentrDistrFrm.valCentDist");',
'focaliza("apeCentrDistrFrm.valCentDist");'],
[3,'focaliza("apeCentrDistrFrm.valDesc");',
'focaliza("apeCentrDistrFrm.valDesc");',
'focaliza("apeCentrDistrFrm.valDesc");',
'focaliza("apeCentrDistrFrm.valDesc");',
'focaliza("apeCentrDistrFrm.valDesc");',
'focaliza("apeCentrDistrFrm.valDesc");'],
[4,'focaliza("apeCentrDistrFrm.valNiveOuts");',
'focaliza("apeCentrDistrFrm.valNiveOuts");',
'focaliza("apeCentrDistrFrm.valNiveOuts");',
'focaliza("apeCentrDistrFrm.valNiveOuts");',
'focaliza("apeCentrDistrFrm.valNiveOuts");',
'focaliza("apeCentrDistrFrm.valNiveOuts");'],
[5,'focaliza("apeCentrDistrFrm.valSistCubi");',
'focaliza("apeCentrDistrFrm.valSistCubi");',
'focaliza("apeCentrDistrFrm.valSistCubi");',
'focaliza("apeCentrDistrFrm.valSistCubi");',
'focaliza("apeCentrDistrFrm.valSistCubi");',
'focaliza("apeCentrDistrFrm.valSistCubi");'],
[6,'focaliza("apeCentrDistrFrm.valProgCubi");',
'focaliza("apeCentrDistrFrm.valProgCubi");',
'focaliza("apeCentrDistrFrm.valProgCubi");',
'focaliza("apeCentrDistrFrm.valProgCubi");',
'focaliza("apeCentrDistrFrm.valProgCubi");',
'focaliza("apeCentrDistrFrm.valProgCubi");'],
[7,'focaliza("apeCentrDistrFrm.valProg");',
'focaliza("apeCentrDistrFrm.valProg");',
'focaliza("apeCentrDistrFrm.valProg");',
'focaliza("apeCentrDistrFrm.valProg");',
'focaliza("apeCentrDistrFrm.valProg");',
'focaliza("apeCentrDistrFrm.valProg");'],
[8,'','','','','','']]);

/* Vector con acciones de foco para la pantalla de modificación.
 * El vector esta compuesto por 7 columnas. 
 * La primera columna contiene el orden del foco 
 * Las otras seis columnas son las acción a ejecutar en los 
 tres posibles modos (query, modify, update) y para los dos 
 evento de foco (siguinete campo y campo)
 *[ordenFoco, anterior-Query, anterior-Create, anterior-Update, 
 siguiente-Query, siguinet-Create, siguiente-Upate]
*/
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([
[2,'focaliza("apeCentrDistrFrm.valCentDist");',
'focaliza("apeCentrDistrFrm.valCentDist");',
'focaliza("apeCentrDistrFrm.valCentDist");',
'focaliza("apeCentrDistrFrm.valCentDist");',
'focaliza("apeCentrDistrFrm.valCentDist");',
'focaliza("apeCentrDistrFrm.valCentDist");'],
[3,'focaliza("apeCentrDistrFrm.valDesc");',
'focaliza("apeCentrDistrFrm.valDesc");',
'focaliza("apeCentrDistrFrm.valDesc");',
'focaliza("apeCentrDistrFrm.valDesc");',
'focaliza("apeCentrDistrFrm.valDesc");',
'focaliza("apeCentrDistrFrm.valDesc");'],
[4,'focaliza("apeCentrDistrFrm.valNiveOuts");',
'focaliza("apeCentrDistrFrm.valNiveOuts");',
'focaliza("apeCentrDistrFrm.valNiveOuts");',
'focaliza("apeCentrDistrFrm.valNiveOuts");',
'focaliza("apeCentrDistrFrm.valNiveOuts");',
'focaliza("apeCentrDistrFrm.valNiveOuts");'],
[5,'focaliza("apeCentrDistrFrm.valSistCubi");',
'focaliza("apeCentrDistrFrm.valSistCubi");',
'focaliza("apeCentrDistrFrm.valSistCubi");',
'focaliza("apeCentrDistrFrm.valSistCubi");',
'focaliza("apeCentrDistrFrm.valSistCubi");',
'focaliza("apeCentrDistrFrm.valSistCubi");'],
[6,'focaliza("apeCentrDistrFrm.valProgCubi");',
'focaliza("apeCentrDistrFrm.valProgCubi");',
'focaliza("apeCentrDistrFrm.valProgCubi");',
'focaliza("apeCentrDistrFrm.valProgCubi");',
'focaliza("apeCentrDistrFrm.valProgCubi");',
'focaliza("apeCentrDistrFrm.valProgCubi");'],
[7,'focaliza("apeCentrDistrFrm.valProg");',
'focaliza("apeCentrDistrFrm.valProg");',
'focaliza("apeCentrDistrFrm.valProg");',
'focaliza("apeCentrDistrFrm.valProg");',
'focaliza("apeCentrDistrFrm.valProg");',
'focaliza("apeCentrDistrFrm.valProg");'],
[8,'','','','','','']]);

/* Creamos la información de las jerarquías de dependencias de combos (si existen)
 * Para cada jerarquía de dependencia definimos
 * un vector donde se defina la jeraría
 * La definición de la jerarquía consiste en definir 
 * para cada combo de la jerarquía cuales 
 * son sus padres (combos de los que depende para 
 * determinar sus valores) cual es su 
 * hijo(combo que depende de él para determianr
 * sus valores) y el  nombre de la entidad 
 * de los objetos que se representan en el combo. 
 * Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, 
 * entidadHija,nombreEntidadObjetos]
 */
var padresTmp = null;
var paisOidPaisDependeceMap = new Vector();
paisOidPaisDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais', padresTmp, '', 'SegPaisView']);

	
/* variable conreferencia al obejto usado para devolver 
 * los resultados de una búsqueda lov
 */
apeCentrDistrLovReturnParameters = null;

/* varible temporal donde se almacenan el valor del registro que se 
 * está modifica para chequear
 * que no se pierden datos
 */
var apeCentrDistrTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function apeCentrDistrInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('apeCentrDistrFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
  /* Guardamos los valores de los campos para poder recuperarlos 
   *  tras una operación de limpiar
	 */
  populateForm2Js();
	
	/* Simplemente analiza el tipo de acción a realizar
   * y llama a la función correspondiente
   */
  switch(get('apeCentrDistrFrm.accion')){
      case "query": apeCentrDistrQueryInitComponents(); break;
      case "view": apeCentrDistrViewInitComponents(); break;
      case "create": apeCentrDistrCreateInitComponents(); break;
      case "update": apeCentrDistrUpdateInitComponents(); break;
      case "remove": apeCentrDistrRemoveInitComponents(); break;
      case "lov": apeCentrDistrLovInitComponents(); break;
	}
	//alert('accion :' + get('apeCentrDistrFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('apeCentrDistrFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('apeCentrDistr')) {
      apeCentrDistrCmdRequery();
  }    
}

function apeCentrDistrQueryInitComponents(){
    //Los campos de los atributos de tipo list los desactivamos
    focusFirstField('apeCentrDistrFrm', true);	
}

function apeCentrDistrViewInitComponents(){
    /* Cargamos la descripción en el idioma por 
     * defecto del usuario de los atributos 
     * internacionalizables
     */ 
    focusFirstField('apeCentrDistrFrm', true);
}

function apeCentrDistrCreateInitComponents(){
    //Los campos de los atributos de tipo list los desactivamos
    //Asignamos los textos de campo requerido
    setMV('apeCentrDistrFrm.valCentDist',
          'S', GestionarMensaje('ApeCentrDistr.valCentDist.requiered.message'));
    setMV('apeCentrDistrFrm.valDesc','S',
          GestionarMensaje('ApeCentrDistr.valDesc.requiered.message'));	
    setMV('apeCentrDistrFrm.valNiveOuts','S',
          GestionarMensaje('ApeCentrDistr.valNiveOuts.requiered.message'));
	
  //Activamos el botón de guardar de la botonera;
    parent.iconos.set_estado_botonera('btnBarra',1,'activo');
    focusFirstField('apeCentrDistrFrm', true);
}

function apeCentrDistrUpdateInitComponents(){
    /* Desactivamos los campos y situamos el foco en el primer campo editable
     * Dependiendo del origen menu (para buscar) 
     * o de pagina (para modificar los datos)
     * En el caso de origen == menu desactivamos lsoc ampos que no sean de
     *  búsqueda .En el caso de origen == pagina desactivamos 
     * los campos que no sean de modificación
     */
    if(get('apeCentrDistrFrm.origen') == "pagina"){
    
        //Registramos el valor del elemento que estamos modificando
        apeCentrDistrTmpUpdateValues = apeCentrDistrBuildUpdateRecordString();
        //Los campos de los atributos de tipo list los desactivamos
      
        /* Asignamos los textos de campo requerido siempre y cuando 
         * estemos en el modo que lo requiea
         */
        setMV('apeCentrDistrFrm.valCentDist','S', 
              GestionarMensaje('ApeCentrDistr.valCentDist.requiered.message'));
        setMV('apeCentrDistrFrm.valDesc','S', 
              GestionarMensaje('ApeCentrDistr.valDesc.requiered.message'));
        setMV('apeCentrDistrFrm.valNiveOuts','S', 
              GestionarMensaje('ApeCentrDistr.valNiveOuts.requiered.message'));
      
        focusFirstFieldModify('apeCentrDistrFrm', true);
    }else{
        //Los campos de los atributos de tipo list los desactivamos
        focusFirstField('apeCentrDistrFrm', true);
    }
    
    //Activamos el botón de guardar de la botonera solo si el origen es pagina
    if(get('apeCentrDistrFrm.origen') == "pagina"){
        parent.iconos.set_estado_botonera('btnBarra',1,'activo');
    }else{
        parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
    }    
}

function apeCentrDistrRemoveInitComponents(){
    //Los campos de los atributos de tipo list los desactivamos
    
    //Ponemos el criterio de multiselección a la lista de resultados
    apeCentrDistrList.maxSel = -1;
    
    //Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
    parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
    
    focusFirstField('apeCentrDistrFrm', true);
}

function apeCentrDistrLovInitComponents(){
    apeCentrDistrLovReturnParameters = window.dialogArguments;
	
    focusFirstField('apeCentrDistrFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad

/*Función que permite cargar los datos de un elemento de lov seleccionado
 */
function apeCentrDistrSetLovSelection(campo, id, descripcion){
	
    /*Actualizamos el valor del campo oculto y el valor de la caja de texto
     *del campo que es una lista
     */
    set('apeCentrDistrFrm.' + campo, id);
    set('apeCentrDistrFrm.' + campo + 'LovDescription', descripcion);
}

//Funciones cuando la entidad es abierta en diálogo de lov
function apeCentrDistrLovNullSelectionAction(){
  	//Indicamos en el parametro de retorno de lov que hau que poner valor null
    apeCentrDistrLovReturnParameters.id = '';
    apeCentrDistrLovReturnParameters.description = '';
	
    //Finalmente cerramos la ventana
    window.close();
}

function apeCentrDistrLovSelectionAction(){
    //Si no se ha seleccionado ningún elemento no hacemos nada
    if(apeCentrDistrList.numSelecc() <= 0) return;
  
  
    /* Determinamos el codigo del elemento seleccionado y la descripcion
     * Debido a que en la columna del choice hay codigo html habrá que limpiar
     * para sólo coger (Esto ultimo queda comentado ya que la columna 
     * delm choice a fecha 29/10/2003 no aparece como codigo HTML)
     * el valor real
     */
    var codigo = apeCentrDistrList.codSeleccionados();
    var descripcion = apeCentrDistrList.extraeDato(
      apeCentrDistrList.codSeleccionados()[0], apeCentrDistrChoiceColumn);
    //descripcion = descripcion.substring(descripcion.indexOf('>')+1, 
    //descripcion.lastIndexOf('<'));
    
    apeCentrDistrLovReturnParameters.id = codigo;
    apeCentrDistrLovReturnParameters.description = descripcion;
  
    //Finalmente cerramos la ventana
    window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function apeCentrDistrCmdQuery(pageNumber){
    /*Llamamos a la validación del formualrio. Si la validación 
     * no es true finalizamos la ejecujcion
     */
    var isValid = ValidaForm('apeCentrDistrFrm', true);
    if(!isValid) {
      return;
    }  
    //Construimos la cadena de parametros que pasamos en la función
    var parametros = generateQuery();
    
    //Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
    parametros += pageNumber + "|";
    parametros += mmgPageSize;
    
    /* Guardamos los parámetros de la última busqueda. 
    * (en la variable del formulario para el tema
    */
    //de volver a la página anterior)
    set('apeCentrDistrFrm.lastQueryToSession', parametros);
    
    /* Ponemos el cursor a wait y hacemos la llamada al conector y 
     * cargamos los datos en la combo y volvemosa poner el
     * curor al estado normal
     */
    document.body.style.cursor='wait';
    asignar([["LISTA", "apeCentrDistrList",
              "ApeCentrDistrConectorTransactionQuery", 
              "result_ROWSET", parametros, 
              "apeCentrDistrPostQueryActions(datos);"]],
              "", "");	
}

function apeCentrDistrCmdRequery(){
    //Vamos estableciendo en el formulario los valores de la última búsqueda
    var paramsRequery = new Vector();
    paramsRequery.token('|', get('apeCentrDistrFrm.lastQueryToSession'));
    var i =0;
    set('apeCentrDistrFrm.valCentDist', paramsRequery.ij(i++));  
    set('apeCentrDistrFrm.valDesc', paramsRequery.ij(i++));
    set('apeCentrDistrFrm.valNiveOuts', paramsRequery.ij(i++));
    set('apeCentrDistrFrm.valSistCubi', paramsRequery.ij(i++));
    set('apeCentrDistrFrm.valProgCubi', paramsRequery.ij(i++));
    set('apeCentrDistrFrm.valProg', paramsRequery.ij(i++));
    
    //Establecemos la página de busqueda como la actual
    apeCentrDistrPageCount = paramsRequery.ij(i++);
    
    //Ejecutamos de nuevo la query
    apeCentrDistrCmdQuery(apeCentrDistrPageCount);
}

function apeCentrDistrFirstPage(){
    //Restemaos el contados de paginas y ejecutamos la query
    apeCentrDistrPageCount = 1;
    apeCentrDistrCmdQuery(apeCentrDistrPageCount);
}

function apeCentrDistrPreviousPage(){
    //Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
    if(generateQuery() != apeCentrDistrLastQuery){
      apeCentrDistrFirstPage();
      return;
    }
	
    //Disminuimos en una unidad el contador de paginas y ejecutamos la query
    apeCentrDistrPageCount--;
    apeCentrDistrCmdQuery(apeCentrDistrPageCount);
}

function apeCentrDistrNextPage(){
    //Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
    if(generateQuery() != apeCentrDistrLastQuery){
        apeCentrDistrFirstPage();
        return;
    }

    //Aumentamos en una unidad el contador de paginas y ejecutamos la query
    apeCentrDistrPageCount++;
    apeCentrDistrCmdQuery(apeCentrDistrPageCount);
}

/* Esta fucnion ejecuta las acciones necesarias 
 * de realizar una vez ejecutada la query
 */
function apeCentrDistrPostQueryActions(datos){
    /* Primer comprovamos que hay datos. Si no hay datos 
     * lo  indicamos, ocultamos las capas,
     *que estubiesen visibles, las minimizamos y finalizamos
     */
    if(datos.length == 0){
      document.body.style.cursor='default';
      visibilidad('apeCentrDistrListLayer', 'O');
      visibilidad('apeCentrDistrListButtonsLayer', 'O');
      if(get('apeCentrDistrFrm.accion') == "remove"){
        parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
      }
      resetJsAttributeVars();
      minimizeLayers();
      cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
      return;
    }
	
    //Guardamos los parámetros de la última busqueda. (en la variable javascript)
    apeCentrDistrLastQuery = generateQuery();

    /* Antes de cargar los datos en la lista preparamos los datos
     * Las columnas que sean de tipo valores predeterminados ponemos 
     * la descripción en vez del codigo
     * Las columnas que tengan widget de tipo checkbox sustituimos
     * el true/false por el texto en idioma
     */
    var datosTmp = new Vector();
    datosTmp.cargar(datos);
	
    /* Ponemos en el campo del choice un link para poder
     * visualizar el registro (DESHABILITADO. Existe el modo view.
     * A este se accede desde el modo de consulta o desde el modo de eliminación)
     */
    
    /*for(var i=0; i < datosTmp.longitud; i++){
      datosTmp.ij2("<A HREF=\'javascript:apeCentrDistrViewDetail(" 
                        + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij
                        (i, apeCentrDistrChoiceColumn) + "</A>",
                        i, apeCentrDistrChoiceColumn);
      }
     */

    //Filtramos el resultado para coger sólo los datos correspondientes a
    //las columnas de la lista Y cargamos los datos en la lista
    apeCentrDistrList.setDatos(datosTmp.filtrar([0,1,2,3,4,5,6],'*'));
	
  	//La última fila de datos representa a los timestamps que debemos guardarlos
    apeCentrDistrTimeStamps = datosTmp.filtrar([7],'*');
	
    //SI hay mas paginas reigistramos que es así e eliminamos el último registro
    if(datosTmp.longitud > mmgPageSize){
        apeCentrDistrMorePagesFlag = true;
        apeCentrDistrList.eliminar(mmgPageSize, 1);
    }else{
        apeCentrDistrMorePagesFlag = false;
    }
	
    //Activamos el botón de borrar si estamos en la acción
    if(get('apeCentrDistrFrm.accion') == "remove"){
        parent.iconos.set_estado_botonera('btnBarra',4,'activo');
    }
    //Estiramos y hacemos visibles las capas que sean necesarias
    maximizeLayers();
    visibilidad('apeCentrDistrListLayer', 'V');
    visibilidad('apeCentrDistrListButtonsLayer', 'V');
    //Ajustamos la lista de resultados con el margen derecho de la ventana
    DrdEnsanchaConMargenDcho('apeCentrDistrList',20);
    eval(ON_RSZ);  

    /* Es necesario realizar un repintado de la tabla
    * debido a que hemos eliminado registro
    */
    apeCentrDistrList.display();
	
    //Actualizamos el estado de los botones 
    if(apeCentrDistrMorePagesFlag){
        set_estado_botonera('apeCentrDistrPaginationButtonBar',
                              3,"activo");
    }else{
        set_estado_botonera('apeCentrDistrPaginationButtonBar',
                            3,"inactivo");
    }
    if(apeCentrDistrPageCount > 1){
        set_estado_botonera('apeCentrDistrPaginationButtonBar',
                            2,"activo");
        set_estado_botonera('apeCentrDistrPaginationButtonBar',
                            1,"activo");
    }else{
        set_estado_botonera('apeCentrDistrPaginationButtonBar',
                            2,"inactivo");
        set_estado_botonera('apeCentrDistrPaginationButtonBar',
                            1,"inactivo");
    }
	
    //Ponemos el cursor de vuelta a su estado normal
    document.body.style.cursor='default';
}

function apeCentrDistrUpdateSelection(){
    //Si no se ha seleccionado ningún elemento no hacemos nada
    if(apeCentrDistrList.numSelecc() != 1){
        cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
        return;
    }
  
    //Guardamos en la variable ID el id de la fila seleccionada
    set('apeCentrDistrFrm.idSelection', apeCentrDistrList.codSeleccionados()[0]);
  
    /* Validamos el formualrio y lo enviamos. Cambiamos el ON
     * para que vaya al startup y prepare el formulario
     * para la modificación
     */
    var validacion = ValidaForm('apeCentrDistrFrm', true);
    if(validacion){
        var parametros = new Array();
        parametros["idSelection"] = apeCentrDistrList.codSeleccionados()[0];
        parametros["previousAction"] = get('apeCentrDistrFrm.accion');
        parametros["accion"] = get('apeCentrDistrFrm.accion');
        parametros["origen"] = 'pagina';
    
       var result = mostrarModalSICC('ApeCentrDistrLPStartUp', 
                                    get('apeCentrDistrFrm.accion'),
                                    parametros,
                                    null, null);
        if(result == MMG_RC_OK){
          apeCentrDistrCmdRequery();
        }  
    }
}

function apeCentrDistrRemoveSelection(){
    //Si no se ha seleccionado ningún elemento no hacemos nada
    if(apeCentrDistrList.numSelecc() == 0){
        cdos_mostrarAlert(GestionarMensaje
                              ('MMGGlobal.remove.noselection.message'));
        return;
    }
  
    //Solicitamos confirmación para borrar 
    if(cdos_mostrarConfirm(GestionarMensaje
              ('MMGGlobal.remove.confirmation.message')) == false){
              
        return;
    }    
  
    //Guardamos en la variable ID el id de la fila seleccionada 
    //y enviamos el formulario
    var ids = apeCentrDistrList.codSeleccionados();
    var idsTmp = new Vector();
    idsTmp.cargar(ids);
    set('apeCentrDistrFrm.idSelection', idsTmp.unir('|'));
  
    //Sacamos los timestamps
    var timestamps = '';
    var idsSeleccionados = new Vector();
    var datosList = new Vector();
    idsSeleccionados.cargar(ids);
    datosList.cargar(apeCentrDistrList.datos);
    for(var i=0; i< idsSeleccionados.longitud; i++){
        timestamps += 
                apeCentrDistrTimeStamps[datosList.buscar(idsSeleccionados.ij(i),
                                        0)][0] + '|';
    }
    timestamps = timestamps.substr(0, timestamps.length-1);
    set('apeCentrDistrFrm.timestamp', timestamps);
  
  
    apeCentrDistrFrm.oculto='S';
    envia('apeCentrDistrFrm');
    apeCentrDistrFrm.oculto='N';
}

function apeCentrDistrViewSelection(){
    //Si no se ha seleccionado ningún elemento no hacemos nada
    if(apeCentrDistrList.numSelecc() != 1){
        cdos_mostrarAlert(GestionarMensaje
                              ('MMGGlobal.view.singleselection.message'));
        return;
    }
    
    //Enviamos el formualrio
    apeCentrDistrViewDetail(apeCentrDistrList.codSeleccionados()[0]);
}

/* Esta función nos permite abrir un dialogo que permite visualiza
 * un registro determianado
 */
function apeCentrDistrViewDetail(idRegistro){
    /* Abrimos ventana modal en modo de detalle pasando como parametros el
     * id del elemento seleccionado
     * y los parametros de acción, origen y previousAction para que la
     * lp de startup pueda determinar el modo
     */
    var parametros = new Array();
    parametros["idSelection"] = idRegistro;
    parametros["previousAction"] = get('apeCentrDistrFrm.accion');
    parametros["accion"] = 'view'
    parametros["origen"] = 'pagina';
    
    mostrarModalSICC('ApeCentrDistrLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
    /* Nos aseguramos que de los campos i18n se coge la descripción 
     * del idioma por defecto intreoducido directamente a través del widget. 
     * Esto se pone debio a que la tecla rápida
     * de guardar no dispara un evento de onblur sobre el
     * componte que tenga el foco
     */
  
   /* Validamos el formualrio y lo enviamos.
    *  Druida al detectar un error en un campo lleva el foco a el para
    *  mostrar que es el campo del error
    *  Si el campo es de tipo list pega un casque de javascript luego 
    *  antes de validar hacemos los campos
    *  de los list editables. Una vez hecha la validación los volvemos
    *  a poner a no editables
    */
    setNonEditableElementsStatus(false);
    var validacion = ValidaForm('apeCentrDistrFrm', true);
    setNonEditableElementsStatus(true);
    
    //Si ha habido un pete volvemos
    if(!validacion){
        return;
    }    
    
    /* Determinamos que los campos internacionalizables requeridos 
     * tengan valor y que se haya dado
     */
    if(validacion){
        apeCentrDistrFrm.oculto='S';
        envia('apeCentrDistrFrm');
        apeCentrDistrFrm.oculto='N';
    }
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	/*Si los valores raices de las combos de una generarquía
   * de dependencia no tienen valor
	 * limpiamops el resto de combos
	 */
  if(get('apeCentrDistrFrm.paisOidPais').toString() == ''){
      set('apeCentrDistrFrm.paisOidPais', []);
      mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'apeCentrDistr');	
	}
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
    apeCentrDistrRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
    var accionTmp = get('apeCentrDistrFrm.accion');
    var origenTmp = get('apeCentrDistrFrm.origen');
    
    /* Si estamo en modo de view el volver hacia atrás significa ejecutar 
     * un requery sobre el modo anterior
     * Si no simplemente es volver para atrás
     */
    if(accionTmp == 'update' && origenTmp == 'pagina'){
      //chequemaos que no se vaya a perder cambios 
      if(apeCentrDistrBuildUpdateRecordString() != apeCentrDistrTmpUpdateValues){
        var respuesta = cdos_mostrarConfirm
                          (GestionarMensaje(
                                MMGGlobal.update.lostchanges.message));
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
    document.all.apeCentrDistrListLayer.style.display='none';
    document.all.apeCentrDistrListButtonsLayer.style.display='none';
}

function maximizeLayers(){
    document.all.apeCentrDistrListLayer.style.display='';
    document.all.apeCentrDistrListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
    //Determinamos los valores para realziar la búsqueda
    jsApeCentrDistrValCentDist = get('apeCentrDistrFrm.valCentDist').toString();
    jsApeCentrDistrValDesc = get('apeCentrDistrFrm.valDesc').toString();
    jsApeCentrDistrValNiveOuts = get('apeCentrDistrFrm.valNiveOuts').toString();
    jsApeCentrDistrValSistCubi = get('apeCentrDistrFrm.valSistCubi').toString();
    jsApeCentrDistrValProgCubi = get('apeCentrDistrFrm.valProgCubi').toString();
    jsApeCentrDistrValProg = get('apeCentrDistrFrm.valProg').toString();
	
  	var parametros = "";
    parametros += jsApeCentrDistrValCentDist + "|";
    parametros += jsApeCentrDistrValDesc + "|";
    parametros += jsApeCentrDistrValNiveOuts + "|";
    parametros += jsApeCentrDistrValSistCubi + "|";
    parametros += jsApeCentrDistrValProgCubi + "|";
    parametros += jsApeCentrDistrValProg + "|";	
    return parametros;
}

/* Esta función nos permite obteber los valore del formulario 
 * cuando está en modo de update form
 * El metodo esta pensado para saber si se han modificado los campos
 */
function apeCentrDistrBuildUpdateRecordString(){
    //Sacamos los valores del formulario
    populateForm2Js();
  
    var parametros = "";
    parametros += jsApeCentrDistrValCentDist + "|";
    parametros += jsApeCentrDistrValDesc + "|";
    parametros += jsApeCentrDistrValNiveOuts + "|";
    parametros += jsApeCentrDistrValSistCubi + "|";
    parametros += jsApeCentrDistrValProgCubi + "|";
    parametros += jsApeCentrDistrValProg + "|";
    
    return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
    //Primero determinamos el modo en el que estamos;
    var mode = getMMGMode(get('apeCentrDistrFrm.accion'), 
      get('apeCentrDistrFrm.origen'));
    
    jsApeCentrDistrId = get('apeCentrDistrFrm.id').toString();
    jsApeCentrDistrValCentDist = get('apeCentrDistrFrm.valCentDist').toString();
    jsApeCentrDistrValDesc = get('apeCentrDistrFrm.valDesc').toString();
    jsApeCentrDistrValNiveOuts = get('apeCentrDistrFrm.valNiveOuts').toString();
    jsApeCentrDistrValSistCubi = get('apeCentrDistrFrm.valSistCubi').toString();
    jsApeCentrDistrValProgCubi = get('apeCentrDistrFrm.valProgCubi').toString();
    jsApeCentrDistrValProg = get('apeCentrDistrFrm.valProg').toString();
    jsApeCentrDistrPaisOidPais = get('apeCentrDistrFrm.paisOidPais')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
    //Primero determinamos el modo en el que estamos;
    var mode = getMMGMode(get('apeCentrDistrFrm.accion'), 
      get('apeCentrDistrFrm.origen'));
  
  
    set('apeCentrDistrFrm.id', jsApeCentrDistrId);
    set('apeCentrDistrFrm.valCentDist', jsApeCentrDistrValCentDist);
    set('apeCentrDistrFrm.valDesc', jsApeCentrDistrValDesc);
    set('apeCentrDistrFrm.valNiveOuts', jsApeCentrDistrValNiveOuts);
    set('apeCentrDistrFrm.valSistCubi', jsApeCentrDistrValSistCubi);
    set('apeCentrDistrFrm.valProgCubi', jsApeCentrDistrValProgCubi);
    set('apeCentrDistrFrm.valProg', jsApeCentrDistrValProg);
    set('apeCentrDistrFrm.paisOidPais', [jsApeCentrDistrPaisOidPais]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
    //Determinamos los valores para realizar la búsqueda
    jsApeCentrDistrValCentDist = '';
    jsApeCentrDistrValDesc = '';
    jsApeCentrDistrValNiveOuts = '';
    jsApeCentrDistrValSistCubi = '';
    jsApeCentrDistrValProgCubi = '';
    jsApeCentrDistrValProg = '';
    
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
    set('apeCentrDistrFrm.errCodigo', errorCode);
    set('apeCentrDistrFrm.errDescripcion', description);
    set('apeCentrDistrFrm.errSeverity', severity);
    fMostrarMensajeError();
}