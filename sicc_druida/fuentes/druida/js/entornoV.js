/********************************** 
	valida.js
	Funciones javascript básicas de validación de campos de formulario
	28/05/2001
	DRUIDA 1.1

**********************************/

// Función de configuración del entorno de validación.
// Parámetros globales; abreviaturas de validaciones.
// Esta funcion puede ser sobreescrita por el proyecto en fución del idioma
function entornoV(parametro) {
	switch(parametro) {
		case 'N': return "ValidaNum(valor)";	// abreviatura ('valor' representa el valor a validar)
		case 'F': return "ValidaFecha(valor,'d/m/Y')";	// abreviatura
		case 'formatoF': return 'D/M/Y';	// formato de las fechas
		case 'Ym': return 1800;		// año mínimo en las fechas
		case 'YM': return 2055;	// año máximo en las fechas
		case 'CYm': return '3000.000';		// coordenada UTM_Y mínima
		case 'CYM': return '5000.000';	// coordenada UTM_Y máxima
		case ',': return ',';	// coma decimal (punto o coma). IMPORTANTE: JavaScript trabaja con '.' (si usamos ',' habrá que emplear la función Decimal2(valor,'.') en argumentos a funciones numéricas)
      case 'idioma': return "es";
      case 'numerodecimales': return 3;
		default: return 'DRD_ERROR_001';	 // No cambiar este texto. Se emplea en otras funciones.
	}
}
