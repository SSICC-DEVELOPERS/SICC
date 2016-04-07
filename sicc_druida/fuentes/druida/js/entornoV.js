/********************************** 
	valida.js
	Funciones javascript b�sicas de validaci�n de campos de formulario
	28/05/2001
	DRUIDA 1.1

**********************************/

// Funci�n de configuraci�n del entorno de validaci�n.
// Par�metros globales; abreviaturas de validaciones.
// Esta funcion puede ser sobreescrita por el proyecto en fuci�n del idioma
function entornoV(parametro) {
	switch(parametro) {
		case 'N': return "ValidaNum(valor)";	// abreviatura ('valor' representa el valor a validar)
		case 'F': return "ValidaFecha(valor,'d/m/Y')";	// abreviatura
		case 'formatoF': return 'D/M/Y';	// formato de las fechas
		case 'Ym': return 1800;		// a�o m�nimo en las fechas
		case 'YM': return 2055;	// a�o m�ximo en las fechas
		case 'CYm': return '3000.000';		// coordenada UTM_Y m�nima
		case 'CYM': return '5000.000';	// coordenada UTM_Y m�xima
		case ',': return ',';	// coma decimal (punto o coma). IMPORTANTE: JavaScript trabaja con '.' (si usamos ',' habr� que emplear la funci�n Decimal2(valor,'.') en argumentos a funciones num�ricas)
      case 'idioma': return "es";
      case 'numerodecimales': return 3;
		default: return 'DRD_ERROR_001';	 // No cambiar este texto. Se emplea en otras funciones.
	}
}
