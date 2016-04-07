package com.calipso.reportgenerator.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Contiene todas las traducciones en castellano.
 */

public class LanguageTraslatorES implements ILanguageTraslator{

  private HashMap dictionaryES;

  /**
   * Constructor de la clase
   */
  public LanguageTraslatorES() {
  }

  /**
   * Devuelve el String en castellano a partir del id
   * @param id
   * @return
   */
  public String getExceptionFromId(String id){
    return ((String) getDictionary().get(id));
  }

  /**
   * Crea un diccionario que contiene para cada indice
   * su String correspondiente en castellano.
   * @return
   */
  public Map getDictionary(){
    if(dictionaryES == null){
      initialize();
    }
    return dictionaryES;
  }

  /**
   * Inicializa el diccionario completamente en castellano
   */
  private void initialize(){
    dictionaryES = new HashMap();
    dictionaryES.put("1","INFO - No se indicó la definición");
    dictionaryES.put("2","INFO - Se debe indigar el ID de la definición del reporte");
    dictionaryES.put("3","INFO - Para poder obtener el reporte se debe indicar la definición");
    dictionaryES.put("4","INFO - No se pudo crear el Reporte por no poder obtener el origen de los datos");
    dictionaryES.put("5","INFO - Para obtener el reporte se debe indicar el ID de la definición");
    dictionaryES.put("6","INFO - Para poder crear un reporte se debe indicar la definición");
    dictionaryES.put("7","INFO - Error instanciando Reporte");
    dictionaryES.put("8","INFO - No se puede obtener un origen de dato si no se indica la definicion de reporte");
    dictionaryES.put("9","INFO - No se puede obtener el origen de datos si no se indica la defnición del origen de datos");
    dictionaryES.put("10","INFO - No se pudo obtener el report source");
    dictionaryES.put("11","INFO - No se pudo obtener el report source");
    dictionaryES.put("12","INFO - No se puede preparar un reporte si no se indica la definición del reporte");
    dictionaryES.put("13","INFO - Error preparando Reporte");
    dictionaryES.put("14","INFO - No se puede preparar un reporte si no se indica la definición del reporte ");
    dictionaryES.put("15","INFO - Error preparando Reporte");
    dictionaryES.put("16","INFO - Para poder recuperar una definición de reporte se debe indicar su ID ");
    dictionaryES.put("17","INFO - PAra poder recuperar una definición de origen de reporte se debe indicar su ID");
    dictionaryES.put("18","INFO - Para poder preparar un reporte se debe indicar un ID de la definición de origen de dato");
    dictionaryES.put("19","INFO - Error obteniendo definición de origen de datos");
    dictionaryES.put("20","INFO - No se pudo obtener la lista de definiciones de reportes");
    dictionaryES.put("21","INFO - No se pudo obtener la lista de definiciones de origenes de datos");
    dictionaryES.put("22","INFO - Se debe indicar la entidad");
    dictionaryES.put("23","INFO - No se pudo obtener la lista de definiciones disponibles para una entidad");
    dictionaryES.put("24","INFO - El reporte requerido no está registrado");
    dictionaryES.put("25","INFO - No se puede grabar una definición si no se indica cual");
    dictionaryES.put("26","INFO - No se pudo grabar la definición de reporte");
    dictionaryES.put("27","INFO - No se puede grabar una definición de origen de dato si no se indica cuál es la definición");
    dictionaryES.put("28","INFO - No se pudo invalidar el origen de dato po r no poder obtener la definición");
    dictionaryES.put("29","INFO - Para poder invalidar un origen de dato se debe indicar que definición");
    dictionaryES.put("30","INFO - No se puede obtener la query si no se indica la definición del reporte");
    dictionaryES.put("31","INFO - No se puede obtener la query por defecto si no se indica la definición del reporte");
    dictionaryES.put("32","INFO - No se puede obtener el report query si no se indica el reporte del cual se debe obtener");
    dictionaryES.put("33","INFO - No se puede obtener si no se indica el reporte");
    dictionaryES.put("34","INFO - No se puede obtener si no se indica el reporte");
    dictionaryES.put("35","INFO - No se puede calcular el resultado del reporte si no se lo indica");
    dictionaryES.put("36","INFO - No se puede ejecutar un reporte si no se indica el ID de la definición");
    dictionaryES.put("37","INFO - No se puede calcular el reporte si no se indica la definición de reporte");
    dictionaryES.put("38","INFO - No se pudo ejecutar el reporte");
    dictionaryES.put("39","INFO - Error instanciando Reporte");
    dictionaryES.put("40","INFO - No se puede calcular el reporte si no se indica la definición");
    dictionaryES.put("41","INFO - Error instanciando Reporte");
    dictionaryES.put("42","INFO - INFO - Debe asignarse la definición de origen de dato y la configuración del administrador de reportes");
    dictionaryES.put("43","INFO - Debe asignarse la  matriz");
    dictionaryES.put("44","INFO - Se produjo un error al resolver los orígenes de datos");
    dictionaryES.put("45","INFO - Se produjo un error al recorrer el origen de datos y llenar la matriz ");
    dictionaryES.put("46","INFO - Error llenando un registro de la matriz");
    dictionaryES.put("47","INFO - Debe asignar la especificación de reporte y el origen de dato");
    dictionaryES.put("48","INFO - Error al incializar el reporte");
    dictionaryES.put("49","INFO - Debe indicarse la query");
    dictionaryES.put("50","INFO - Query no válida");
    dictionaryES.put("51","INFO - No se pudo obtener el objeto");
    dictionaryES.put("52","INFO - no se indicó el objeto o el nombre destino");
    dictionaryES.put("53","INFO - no se pudo grabar el archivo");
    dictionaryES.put("54","INFO - no se pudo crear el archivo destino");
    dictionaryES.put("55","INFO - se debe indicar un nombre de archivo");
    dictionaryES.put("56","INFO - No se pudo obtener el objeto");
    dictionaryES.put("57","INFO - Se debe inficar el nombre del archivo a borrar");
    dictionaryES.put("58","INFO - No se pudo borrar el archivo");
    dictionaryES.put("59","INFO - No se pudo leer la definición de reporte");
    dictionaryES.put("60","INFO - No se pudo grabar la definición de origen de reporte");
    dictionaryES.put("61","INFO - No se pudo obtener la definición de reporte");
    dictionaryES.put("62","INFO - Error obteniendo nombre del archivo");
    dictionaryES.put("63","INFO - No se pudo grabar la definición");
    dictionaryES.put("64","INFO - No se pudo obtener el nombre del archivo");
    dictionaryES.put("65","INFO - No se pudo resolver el origen de dato");
    dictionaryES.put("66","INFO - Error al obtener la fecha de última ejecución");
    dictionaryES.put("67","INFO - No se pudo objener la fecha de expiración");
    dictionaryES.put("68","INFO - No se pudo grabar el ReportSource con el nombre");
    dictionaryES.put("69","INFO - No se pudo grabar el ReportSource");
    dictionaryES.put("70","INFO - Error obteniendo la fecha de expiración del report source");
    dictionaryES.put("71","INFO - No se pudo invalidar el report source");
    dictionaryES.put("72","INFO - No se puede remover el objeto si no se indica el nombre");
    dictionaryES.put("73","INFO - No se pudo remover del cache el objeto");
    dictionaryES.put("74","INFO - No se puede obtener el objeto si no se indica el nombre");
    dictionaryES.put("75","INFO - No se pudo obtener el objeto con el objeto ");
    dictionaryES.put("76","INFO - Error generando Result.xml");
    dictionaryES.put("77","INFO - Se produjo un error al asignar la fecha");
    dictionaryES.put("78","INFO - Error obteniendo el report Manager StateFul");
    dictionaryES.put("79","INFO - Error obteniendo el data source");
    dictionaryES.put("80","INFO - Error calculando valor de la dimensión");
    dictionaryES.put("81","INFO - Debe existir archivo de configuración");
    dictionaryES.put("82","INFO - Error en la traducción de la query para el Cubo");
    dictionaryES.put("83","INFO - No existe una métrica con el nombre: {0}");
    dictionaryES.put("84","INFO - No existe una dimensión con el nombre: {0}");
    dictionaryES.put("85","INFO - Se produjo un error al construir el filtro");
    dictionaryES.put("86","INFO - Error en la traducción de la query para el reporte estático");
    dictionaryES.put("87","INFO - Falló la llamada remota: {0}");
    dictionaryES.put("88","INFO - Error obteniendo el report manager StateLess");
    dictionaryES.put("89","INFO - Error obteniendo los valores de la dimension");
    dictionaryES.put("90","INFO - Error calculando valor de la dimensión");
    dictionaryES.put("91","INFO - No se pudo obtener la vista solicitada");
    dictionaryES.put("92","INFO - Error obteniendo nombre del archivo");
    dictionaryES.put("93","INFO - No se pudo grabar la vista");
    dictionaryES.put("94","INFO - No se pudo instanciar las vistas del repositorio");
    dictionaryES.put("95","INFO - Error obteniendo data source SQL");
    dictionaryES.put("96","INFO - Error obteniendo la coneccion SQL distribuida");

    dictionaryES.put("98","INFO - Error obteniendo los nombres de las columnas");
    dictionaryES.put("99","INFO - Error generando Result.xml");
    dictionaryES.put("100","INFO - Error obteniendo el XML data source");
    dictionaryES.put("101","INFO - Error cargando el data source desde XML");
    dictionaryES.put("102","INFO - Se produjo un error en el cálculo del cubo");
    dictionaryES.put("103","INFO - Se produjo un error al calcular las combinaciones de dimensiones para totales");
    dictionaryES.put("104","INFO - Se produjo un error en el cálculo del cubo");
    dictionaryES.put("105","INFO - Se produjo un error al llenar el cubo");
    dictionaryES.put("106","INFO - No se pudo crear el formulario de perfiles");
    dictionaryES.put("107","INFO - No se encontró la métrica");
    dictionaryES.put("108","INFO - Se debe indicar el resultado del reporte para poder visualizarlo");
    dictionaryES.put("109","Perfiles");
    dictionaryES.put("110","Por filas");
    dictionaryES.put("111","Por columnas");
    dictionaryES.put("112","Aceptar");
    dictionaryES.put("113","Cancelar");
    dictionaryES.put("114","Area");
    dictionaryES.put("115","Barras Horizontales");
    dictionaryES.put("116","Torta");
    dictionaryES.put("117","mayor que ");
    dictionaryES.put("118","menor que ");
    dictionaryES.put("119","mayor o igual a ");
    dictionaryES.put("120","menor o igual a ");
    dictionaryES.put("121","igual a ");
    dictionaryES.put("122","valor");
    dictionaryES.put("123","Simple");
    dictionaryES.put("124","Desde");
    dictionaryES.put("125","Hasta");
    dictionaryES.put("126","Rango");
    dictionaryES.put("127","Color");
    dictionaryES.put("128","EL valor {0} no es un número válido");
    dictionaryES.put("129","Los valores {0} y {1} no son números válidos");
    dictionaryES.put("130","Agregar");
    dictionaryES.put("131","Borrar");
    dictionaryES.put("132","Cerrar");
    dictionaryES.put("133","Métricas");
    dictionaryES.put("134","Imprimir");
    dictionaryES.put("135","Totales");
    dictionaryES.put("136","Tamaños");
    dictionaryES.put("137","Al menos debe exitir una metrica visible");
    dictionaryES.put("138","Verifique los valores: debe seleccionar una definición" + " y el UserId no puede estar vacío");
    dictionaryES.put("139","Definiciones");
    dictionaryES.put("140","Gráfico");
    dictionaryES.put("141","Usuario");
    dictionaryES.put("142","Verifique los valores:  debe seleccionar una definición" +
                                                                     " y el Usuario no puede estar vacío");
    dictionaryES.put("143","Ejecutar");
    dictionaryES.put("144","Salir");
    dictionaryES.put("145","INFO - Debe existir al menos una metrica activa");
    dictionaryES.put("146","Desde");
    dictionaryES.put("147","Hasta");
    dictionaryES.put("148","INFO - Error obteniendo los valores no seleccionados de la dimension");
    dictionaryES.put("149","Cantidad");
    dictionaryES.put("150","Valor");
    dictionaryES.put("151","INFO - No se pudo ejecutar el Drill Down");
    dictionaryES.put("152", "Valores incorrectos: ");
    dictionaryES.put("153", "Debe existir por lo menos algún valor seleccionado");
    dictionaryES.put("154", "Ranking");
    dictionaryES.put("155", "INFO - Error resolviendo dataSource OQL");
    dictionaryES.put("156", "INFO - Error resolviendo dataSource SQL");
    dictionaryES.put("157", "INFO - Error resolviendo dataSource Externa");
    dictionaryES.put("158", "Obteniendo reportSpec");
    dictionaryES.put("159", "Obteniendo un Report Manager");
    dictionaryES.put("160", "Obteniendo Data Source");
    dictionaryES.put("161", "Preprocesando origen de datos");
    dictionaryES.put("162", "Grabando definicion de reporte");
    dictionaryES.put("163", "Grabando definicion de origen de reporte");
    dictionaryES.put("164", "Invalidando origen de reporte");
    dictionaryES.put("165", "Obteniendo un report query");
    dictionaryES.put("166", "Obteniendo un report query por defecto");
    dictionaryES.put("167", "Ejecutando consulta");
    dictionaryES.put("168", "Obteniendo report view");
    dictionaryES.put("169", "Grabando report view");
    dictionaryES.put("170", "Semáforo");
    dictionaryES.put("171", "Orden");
    dictionaryES.put("172", "Ejecutando query");
    dictionaryES.put("173", "Ninguno");
    dictionaryES.put("174", "Reportes");
    dictionaryES.put("175", "Perfiles");
    dictionaryES.put("176", "INFO - Error obteniendo el Report Definition");
    dictionaryES.put("177", "INFO - Error obteniendo el Report Source Definition");
    dictionaryES.put("178", "INFO - Error obteniendo el Report View");
    dictionaryES.put("179", "Agregar");
    dictionaryES.put("180", "Quitar");
    dictionaryES.put("181", "Aplicar");
    dictionaryES.put("182", "Exportar");
    dictionaryES.put("183", "Importar");
    dictionaryES.put("184", "Defecto");
    dictionaryES.put("185", "Importar Xml");
    dictionaryES.put("186", "Filtros");
    dictionaryES.put("187", "Ninguna");
    dictionaryES.put("188", "Dimensión");
    dictionaryES.put("189", "ascendente");
    dictionaryES.put("190", "descentente");
    dictionaryES.put("191", "Criterio");
    dictionaryES.put("192", "Orden de dimensiones");
    dictionaryES.put("193", "Ranking por métrica");
    dictionaryES.put("194", "INFO - Error al recuperar xml");
    dictionaryES.put("195", "INFO - Error al grabar xml");
    dictionaryES.put("196", "Iniciando sesion de reporte");
    dictionaryES.put("197", "Finalizando sesion de reporte");
    dictionaryES.put("198", "Error finalizando sesion de reporte");
    dictionaryES.put("199", "Error traduciendo");
    dictionaryES.put("200", "Llenando reporte desde la matriz");
    dictionaryES.put("201", "Procesando origenes de datos");
    dictionaryES.put("202", "Procesando origen de datos SQL");
    dictionaryES.put("203", "Procesando origen de datos OQL");
    dictionaryES.put("204", "Procesando origen de datos XML");
    dictionaryES.put("205", "Procesando origen de datos EXT");
    dictionaryES.put("206", "INFO - No se pudo obtener el servicio de ejecución de SQL");
    dictionaryES.put("207", "Procesando origen de datos BDLQL");
    dictionaryES.put("208", "INFO - Error resolviendo dataSource BDLQL");
    dictionaryES.put("209", "INFO - No se pudieron registrar los report sources definition");
    dictionaryES.put("210", "INFO - No se pudieron registrar los report definition");
    dictionaryES.put("211", "INFO - No se pudo obtener el Local File System Manager");
    dictionaryES.put("212", "INFO - No se pudo resolver el path");
    dictionaryES.put("213", "INFO - Error al recorrer el directorio");
    dictionaryES.put("214", "INFO - No se pudo construir la nueva Query");
    dictionaryES.put("215", "INFO - No se pudo agregar el nuevo perfil");
    dictionaryES.put("216", "INFO - No se pudo aplicar el nuevo perfil");
    dictionaryES.put("217", "INFO - Error al exportar el perfil a xml");
    dictionaryES.put("218", "INFO - Error al importar un perfil");
    dictionaryES.put("219", "INFO - Error al generar un nuevo ColorConditionManager");
    dictionaryES.put("220", "INFO - Error al generar el reporte estatico");
    dictionaryES.put("221", "INFO - Error generando el reporte");
    dictionaryES.put("222", "INFO - Error ejecutando una consulta");
    dictionaryES.put("223", "INFO - Error instanciando ReportManager");
    dictionaryES.put("224", "INFO - Error ejecutando un reporte");
    dictionaryES.put("225", "INFO - Error obteniendo reportes disponibles");
    dictionaryES.put("226", "INFO - Error de formato");
    dictionaryES.put("227", "INFO - Error al cargar el objeto PivotTableProperties");
    dictionaryES.put("228", "INFO - No se pudo cargar el ReportGeneratorConfiguration");
    dictionaryES.put("229", "INFO - No se pudo ejecutar la previsualización del reporte");
    dictionaryES.put("230", "Detalle");
    dictionaryES.put("231", "Error");
    dictionaryES.put("232", "Nombre");
    dictionaryES.put("233", "INFO - No se pudo registrar el report definition");
    dictionaryES.put("234", "INFO - No se pudo registrar el report source definition");
    dictionaryES.put("235", "Leyenda");
    dictionaryES.put("236", "ToolTips");
    dictionaryES.put("237", "Color del grafico");
    dictionaryES.put("238","Graficos estadisticos");
    dictionaryES.put("239","Personalizar");
    dictionaryES.put("240","Criterio");
    dictionaryES.put("241","Tipo de gráfico");
    dictionaryES.put("242","Lineas");
    dictionaryES.put("243","Barras verticales");
    dictionaryES.put("244","Barras verticales en 3D");
    dictionaryES.put("245","Barras horizontales en 3D");
    dictionaryES.put("246","Ha vencido la vigencia de ejecución la aplicación");
    dictionaryES.put("247","Ha superado la cantidad máxima de definiciones registrables de la aplicación");
    dictionaryES.put("248","Vaciar");
    dictionaryES.put("249","Registrar");
    dictionaryES.put("250","Ha superado la cantidad máxima de vistas registrables de la aplicación");
    dictionaryES.put("251", "INFO - No se pudo registrar el report view");
    dictionaryES.put("252", "INFO - No se pudieron registrar los report views");
    dictionaryES.put("253", "INFO - No se pudo borrar el archivo:");
    dictionaryES.put("254", "INFO - No se pudo asignar la vista por defecto:");
    dictionaryES.put("255", "INFO - No se pudo desasignar la vista por defecto anterior");
    dictionaryES.put("256", "INFO - No se pudo borrar las definiciones");
    dictionaryES.put("257", "INFO - No se pudo cargar las definiciones");
    dictionaryES.put("258", "INFO - No se pudo borrar la vista");
    dictionaryES.put("259", "INFO - No se pudo asignar la vista por defecto");
    dictionaryES.put("260", "INFO - Se produjo un error al registrar las definiciones");
    dictionaryES.put("261", "Instanciando nuevo ReportManagerStateless");
    dictionaryES.put("262", "Error convirtiendo dato de XML string a formato date");
    dictionaryES.put("263", "INFO - No se pudo ejecutar el MicroReport");
    dictionaryES.put("264", "Cargar");
    dictionaryES.put("265", "INFO - No se pudo cargar el Microreport del zip");
    dictionaryES.put("265", "INFO - No se pudo generar el zip del Microreport");
    dictionaryES.put("266", "Exportar");
    dictionaryES.put("267", "INFO - No se pudo generar el zip del Microreport desde el cliente");
    dictionaryES.put("268", "INFO - No se pudo generar el zip del Microreport desde el servidor");
    dictionaryES.put("269", "INFO - No se pudo cargar y ejecutar el Micro Report");
    dictionaryES.put("270", "Importar Micro Report");
    dictionaryES.put("271", "Ejecutar Micro Report guardado");
    dictionaryES.put("272", "Esta opción no es válida para cubos de solo lectura");
    dictionaryES.put("273", "Error intentando obtener la conexión de Open Office");
    dictionaryES.put("274", "Error intentando obtener el file de Open Office");
    dictionaryES.put("275", "Registrando ReportSourceDefinition");
    dictionaryES.put("276", "Registrando ReportDefinition");
    dictionaryES.put("277", "Registrando ReportView");
    dictionaryES.put("278","INFO - No se pudo invalidar el report source");
    dictionaryES.put("279","INFO - No se pudo convertir a float");
    dictionaryES.put("280","Dimension: ");
    dictionaryES.put("281","Valor: ");
    dictionaryES.put("282","Buscar ");
    dictionaryES.put("283","Debe seleccionar una celda para realizar la busqueda");
    dictionaryES.put("284","Buscar próximo");
    dictionaryES.put("285","No es posible encontrar ");
    dictionaryES.put("286","Gráfico");
    dictionaryES.put("287","Error al intentar de ejecutar el thread que verifica el cache");
    dictionaryES.put("288","Nuevo Reporte");
    dictionaryES.put("289","INFO - Se produjo un error al intentar ejecutar un nuevo reporte");
    dictionaryES.put("290","Reporte");
    dictionaryES.put("291","Selector de Reportes");
    dictionaryES.put("292","Ejecutar");
    dictionaryES.put("293","INFO - Error ejecutando el nuevo reporte");
    dictionaryES.put("294","Operaciones");
    dictionaryES.put("295","Error validando usuario");
    dictionaryES.put("296","Inicio de Sesión");
    dictionaryES.put("297","Nombre de usuario");
    dictionaryES.put("298","Contraseña");
    dictionaryES.put("299","Login cancelado por el usuario");
    dictionaryES.put("300","Falló la validación del usuario, verifique que el nombre y la contraseña sean correctos o " +
                                         "contacte al administrador del sistema");
    dictionaryES.put("301","Exportar");
    dictionaryES.put("302","Exportar a PDF");
    dictionaryES.put("303","Exportar a Html");
    dictionaryES.put("304","Exportar a Excel");
    dictionaryES.put("305","Exportar a CVS");
    dictionaryES.put("306","Exportar a XML");
    dictionaryES.put("307","INFO - Error al ejecutar el visualizador de reportes");
    dictionaryES.put("308","Grupos: ");
    dictionaryES.put("309","Detalles: ");
    dictionaryES.put("310","Metricas: ");
    dictionaryES.put("311","Error al intentar exportar el reporte");
    dictionaryES.put("312","Error al intentar generar el reporte");
    dictionaryES.put("313","JAnalyzer - Visualizador de Reportes");
    dictionaryES.put("314","ACUMULADO");
    dictionaryES.put("315","Acumulado");
    dictionaryES.put("316","INFO - Error al intentar establecer el origen de datos de ms Excel");
    dictionaryES.put("317","Procesando origen de datos Excel");
    dictionaryES.put("318","No se pudo obtener la imagen de fondo");
    dictionaryES.put("319","Error al convertir el valor de la métrica");
    dictionaryES.put("320","Siguiente >");
    dictionaryES.put("321","< Volver");
    dictionaryES.put("322","Finalizar");
    dictionaryES.put("323","Ayuda...");
    dictionaryES.put("324","* Requerido");
    dictionaryES.put("325","Excel");
    dictionaryES.put("326","Error de memoria");
    dictionaryES.put("327","Error obteniendo datos al colapsar nodo");
    dictionaryES.put("328","Error al llamar a la obtención de datos al colapsar nodo");
    dictionaryES.put("329","El usuario es inexistente, desea darlo de alta ?");
    dictionaryES.put("330","Ingrese el password de root: ");
    dictionaryES.put("331","Imprimir");
    dictionaryES.put("332","Busqueda de valores");
    dictionaryES.put("333","Modificar");
    dictionaryES.put("334","Debe estar seleccionada alguna definicion");
    dictionaryES.put("335","Error");
    dictionaryES.put("336","Dimensiones");
    dictionaryES.put("337","Medidas");
    dictionaryES.put("338","Visualizacion");
    dictionaryES.put("339","Totales");
    dictionaryES.put("340","Mostrar");
    dictionaryES.put("341","Ocultar");
    dictionaryES.put("342","Tamaños");
    dictionaryES.put("343","Imprime la definición actual");
    dictionaryES.put("344","Exporta a disco la definición actual");
    dictionaryES.put("345","Realiza gráficos estadísticos");
    dictionaryES.put("346","Buscador de valores para las dimensiones");
    dictionaryES.put("347","Importa a formato excel los valores de la tabla");
    dictionaryES.put("348","Semaforización para valores de las medidas de la tabla");
    dictionaryES.put("349","Establece perfiles de usuarios");
    dictionaryES.put("350","Realiza un ranking sobre una dimensión en base a una métrica");
    dictionaryES.put("351","Permite modificar el ancho de las columnas");
    dictionaryES.put("352","Muestra y oculta los totales");
    dictionaryES.put("353","Ejecuta una definicion");
    dictionaryES.put("354","Exportar a XML");
    dictionaryES.put("355","Error de ingreso, verifique los campos");
    dictionaryES.put("356","Error al intentar convertir tipos de datos");
    dictionaryES.put("357","Error al obtener el archivo con la definición de Jasper");
    dictionaryES.put("358","Total");
    dictionaryES.put("359","Horizontal");
    dictionaryES.put("360","Vertical");
    dictionaryES.put("361","Error convirtiendo el tipo de dato");
    dictionaryES.put("362","INFO - Error obteniendo data source SQL remoto");
    dictionaryES.put("363","INFO - Error de protección de llave. No se encuentra la llave.");
    dictionaryES.put("364","INFO - Error en login. Finalizando ejecucion...");
    dictionaryES.put("365","INFO - Error obteniendo la dimension para el filtro");
    dictionaryES.put("366","INFO - Error convirtiendo fecha en filtro IN");
    dictionaryES.put("367","Error - Error exportando a XML");
    dictionaryES.put("368","Error - Error al aplicar el perfil");
    dictionaryES.put("369","Error - Error al cargar los perfiles asociados al reporte");
    dictionaryES.put("370","¿ Desea guardar el perfil para posteriores usos ?");
    dictionaryES.put("371","Error - Error al visualizar los perfiles.");
    dictionaryES.put("372","Error obteniendo el archivo de configuracion - No existe en el directorio adecuado");
    dictionaryES.put("373","Info - Error llenando los campos del diseño");
    dictionaryES.put("374","Info - No puede especificarse un tipo Booleno con un dato numerico");
    dictionaryES.put("375","Info - No se encontraron dimensiones en la definicion");
    dictionaryES.put("376","Info - No se pudo escribir correctamente el XML al transformarlo de version");
    dictionaryES.put("377","Info - No se encontro la metrica");
    dictionaryES.put("378","El nombre de la columna no es valido: ");
    dictionaryES.put("379","La posicion no existe o no es una posicion de planilla de excel valida");
    dictionaryES.put("380", "No se puede insertar una fila nula");
    dictionaryES.put("381", "INFO - La fila no tiene el número de columnas actual de este DataSource. Debería tener tamaño ");
    dictionaryES.put("382"," y tiene tamaño ");
    dictionaryES.put("383","Ayuda");
    dictionaryES.put("384","Acerca de JAnalyzer");
    dictionaryES.put("385","Versión");
    dictionaryES.put("386","INFO - Error cargando el data source desde Excel");
    dictionaryES.put("387","Activa y desactiva el refresco automático");
    dictionaryES.put("388","Ordena en forma ascendente o descendente");
    dictionaryES.put("389","licenciada para");
    dictionaryES.put("390","Valores ','");
    dictionaryES.put("391","Multiples ejes");
    dictionaryES.put("392", "Archivo no encontrado: ReportGeneratorConfiguration.properties");
    dictionaryES.put("393","Columna no encontrada");
    dictionaryES.put("394","Error validando la version del XML");
  }


}
