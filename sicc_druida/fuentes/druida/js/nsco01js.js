/********************************** 
	utils.js
	Funciones javascript asociadas al servlet nsco01jg
	22/05/2001
	DRUIDA 1.1
**********************************/
// Quitar los comentarios acelera la carga de la página


// Función para controlar la carga de la tabla
function Ocultos()
{
	var fecha1=get('f1.date1');
	var fecha2=get('f1.date2');
	var Socio=get('f1.RSocio');

	
	set('f1.date11',fecha1);
	set('f1.date22',fecha2);
	set('f1.Socios',Socio);

	
}

