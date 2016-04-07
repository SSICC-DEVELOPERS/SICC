/********************************** 
	$Id: d3combo.js,v 1.1 2009/12/03 19:03:47 pecbazalar Exp $
	Funciones javascript del COMBO
**********************************/

// Elimina elemento i de la combo
// Si se incluye j, elimina desde i->j ambos inclusive
// Si i ó j son <0, empieza desde el final (-1=último)
// Devuelve true/false según haya podido eliminar todos los elementos
function del_combo(campo,i,j) {
	var nsdoc=eval(campo+'NS');
	var iedoc=eval(campo+'IE');
	var l=eval((ns?nsdoc:iedoc)+'.length');
	if (i=='V') {for(var k=l-1;k>=0;k--) {if (eval((ns?nsdoc:iedoc)+'.options[k].value=="'+j+'"')) {eval((ns?nsdoc:iedoc)+'.options[k]=null');}}}
	else if (i=='T') {for(var k=l-1;k>=0;k--) {if (eval((ns?nsdoc:iedoc)+'.options[k].text=="'+j+'"')) {eval((ns?nsdoc:iedoc)+'.options[k]=null');}}}
	else {
		if (j) {if (i>j) {muestraMsgError(DrdMsgCore(177)+'(i>j)');return false;}}	else {j=i;} //err de index:...
		if (i<0 && j>0) {muestraMsgError(DrdMsgCore(177)+'(i<0, j>0)');return false;}
		if (i>=0) {k2=j; k1=i;}
		else {k2=l+j;	k1=l+i;}
		if (k1<0 || k1>=l) {muestraMsgError(DrdMsgCore(177+DrdMsgCore(178)));return false;} //err de index: entr a borr inex
		for(var k=k2;k>=k1;k--) {eval((ns?nsdoc:iedoc)+'.options[k]=null');}
	}
	return true;
}

// Selecciona todos los elementos de la combo
function select_combo(campo) {
	var l=combo_get(campo,'L');
	var arrai=new Array();
	for(var i=0;i<l;i++) {
		arrai[i]=combo_get(campo,'V',i);
	}
	set(campo,arrai);
}

// Devuelve elementos de la combo
// Tipo='L'(longitud combo), 'T'(texto), 'V'(value)
function combo_get(campo,tipo,indice) {
	var nsdoc=eval(campo+'NS');
	var iedoc=eval(campo+'IE');
	var n=eval(ns?nsdoc:iedoc);
	if (tipo=='L') {return n.length;}
	if (tipo=='T') {return n.options[indice].text;}
	if (tipo=='V') {return n.options[indice].value;}
}

// Añade una entrada al final de una combo (campo='form.nombre')
function combo_add(campo,value,descripcion) {
	var nsdoc=eval(campo+'NS');
	var iedoc=eval(campo+'IE');
	var n=eval(ns?nsdoc:iedoc);
	n.options[n.length]=new Option(descripcion,value);
}

// Establece el contenido de una combo (campo='form.nombre')
function set_combo(campo,opciones,selec) {
	var nsdoc=eval(campo+'NS');
	var iedoc=eval(campo+'IE');
	for(var i=eval((ns?nsdoc:iedoc)+'.length')-1;i>=0;i--) {eval((ns?nsdoc:iedoc)+'.options['+i+']=null');} // borramos las opciones anteriores
	if (opciones!=null && opciones!='') { // incluimos las nuevas opciones
		var n=eval(ns?nsdoc:iedoc);
		for(var i=0;i<opciones.length;i++) {
			n.options[i]=new Option(opciones[i][1],opciones[i][0]);
		}
	}
   if (selec!=null && selec.length && selec.length>0) { 
    	set(campo,selec);	// preseleccionamos valores y validamos
      }
   else  {//Si no hay selecc o length=0 selecciono el primero (si length de la combo >0), como en HTML
		var nsdoc=eval(campo+'NS');
		var iedoc=eval(campo+'IE');
		var n=eval(ns?nsdoc:iedoc);
		var longitud=n.length;
		if (longitud>0) {//Si hay elementos seleccionamos el primero
         set(campo,[n.options[0].value]);
      	}
      }
   }

