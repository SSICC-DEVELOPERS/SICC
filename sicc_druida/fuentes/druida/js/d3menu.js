/*
	$Id: d3menu.js,v 1.1 2009/12/03 19:03:47 pecbazalar Exp $
	INDRA/CAR/d3desa
*/


var total_menus=0;			// nº de submenús (barras y listas)
var menu=new Array();	// array conteniendo a todos los submenús
//var ns = (navigator.appName == "Netscape" && parseInt(navigator.appVersion) >= 4);	// diferenciación del navegador
var actual_menu=-1;		// nº de menú en que está el ratón
var actual_entrada=-1;	// nº de entrada del menú en que está el ratón
var temporizador_menu=null;
//var temporizador0_menu=1000; // retardo configurable

// Crea un nuevo submenú (vacío)
function menu_add(nombre,tipo,menu_padre,entrada_padre,top,left,width,height,offset_x,offset_y) {
	if (tipo!="barra" && tipo!="lista") {alert("menu_add:"+nombre+": El tipo debe ser: barra / lista");return;}
	if (menu_padre==null) {
		if (top==0 && left==0) {alert("menu_add:"+nombre+": Un menú base debe incluir coordenadas de la esquina superior izquierda");return;}
		entrada_padre=null;
	}
	else {
		for(var i=0;i<total_menus;i++) {if (menu[i].nombre==menu_padre) break;}
		if (i==total_menus) {alert("menu_add:"+nombre+": Padre inexistente");return;}
		menu_padre=i;
		for(var j=0;j<menu[i].total_entradas;j++) {if (menu[i].entradas[j].nombre==entrada_padre) break;}
		if (j==menu[i].total_entradas) {alert("menu_add:"+nombre+": Entrada inexistente");return;}
		entrada_padre=j;
	}
	menu[total_menus]=new Object;
	menu[total_menus].nombre=nombre;	// nombre del menú
	menu[total_menus].tipo=tipo;					// barra/lista
	menu[total_menus].menu_padre=menu_padre;		// menú del que desciende (nº menu_nombre/null)
	menu[total_menus].entrada_padre=entrada_padre;	// entrada de la que desciende (nº entrada_nombre/null)
	menu[total_menus].top=top;					// esquina superior izquierda (obligatorio si padre!=null; automático si top=left=0)
	menu[total_menus].left=left;
	menu[total_menus].width=width;			// ancho de cada entrada del menú
	menu[total_menus].height=height;			// altura de cada entrada del menú
	menu[total_menus].total_entradas=0;	// número de entradas de este menú
	menu[total_menus].visible=0;					// 1=visible, 0=hidden (incluido para acelerar funcionamiento)
	menu[total_menus].offset_x=offset_x;	// pixels de ajuste horizontal de un submenú sobre la entrada padre
	menu[total_menus].offset_y=offset_y;	// pixels de ajuste vertical de un submenú sobre la entrada padre
	menu[total_menus].entradas=new Array();	// relación de las entradas de este menú
	total_menus++;
} // fin de menu_add

function entrada_add(nombre_menu,nombre_entrada,img_off,img_on,hijo,enlace,info) {	// Añade una entrada a un submenú existente
	for(var i=0;i<total_menus;i++) {if (menu[i].nombre==nombre_menu) break;}
	if (i==total_menus) {alert("entrada_add:"+nombre_menu+":"+nombre_entrada+": Menú inexistente");return;}
	if (hijo!=null || enlace==null) {enlace="javascript:;";}
	var j=menu[i].total_entradas;
	menu[i].entradas[j]=new Object();
	menu[i].entradas[j].nombre=nombre_entrada;			// nombre de la entrada
	menu[i].entradas[j].img_off=img_off;
	menu[i].entradas[j].img_on=img_on;
	menu[i].entradas[j].hijo=hijo;						// submenú que despliega (null/nombre_menu)
	menu[i].entradas[j].enlace=enlace;				// URL a la que enlaza al pinchar sobre esta entrada
	menu[i].entradas[j].info=info;						// mensaje que muestra en la barra de estado
	menu[i].total_entradas++;
} // fin de entrada_add

function imagen_add(nombre_menu,img_off) {	// Añade una imagen a un submenú existente
	for(var i=0;i<total_menus;i++) {if (menu[i].nombre==nombre_menu) break;}
	if (i==total_menus) {alert("imagen_add:"+nombre_menu+":"+img_off+": Menú inexistente");return;}
	var j=menu[i].total_entradas;
	menu[i].entradas[j]=new Object();
	menu[i].entradas[j].nombre=null;			// null=>imagen
	menu[i].entradas[j].img_off=img_off;
	menu[i].total_entradas++;
} // fin de entrada_add

function activar(modo,i,j) { //modo=on/off, i=menú, j=entrada
	if (modo=="off") {
		actual_menu=i;
		actual_entrada=j;
		temporizador_menu=setTimeout("cierra(menu[0].nombre,0)",temporizador0_menu);
	}
	if (modo=="on") {
		clearTimeout(temporizador_menu);
		if (actual_menu!=-1){ // caso inicial
			if (i==actual_menu) {
				cierra(menu[actual_menu].entradas[actual_entrada].hijo,1);
				if (ns) {eval('document.'+menu[i].nombre+'.document.images["M'+actual_menu+'E'+actual_entrada+'"].src=menu['+actual_menu+'].entradas['+actual_entrada+'].img_off');}
				else{eval('document["M'+actual_menu+'E'+actual_entrada+'"].src=menu['+actual_menu+'].entradas['+actual_entrada+'].img_off');}
			}
			else {cierra(menu[i].nombre,0);}
		}
		if (ns) {eval('document.'+menu[i].nombre+'.document.images["M'+i+'E'+j+'"].src=menu['+i+'].entradas['+j+'].img_on');}
		else {eval('document["M'+i+'E'+j+'"].src=menu['+i+'].entradas['+j+'].img_on');}
		if (menu[i].entradas[j].hijo!=null) {	// show
			if (ns) {
				eval('document.'+menu[i].nombre+'.document.images["M'+i+'E'+j+'"].src=menu['+i+'].entradas['+j+'].img_on');
				document.layers[menu[i].entradas[j].hijo].visibility="show";
			}
			else {
				eval('document["M'+i+'E'+j+'"].src=menu['+i+'].entradas['+j+'].img_on');
				document.all[menu[i].entradas[j].hijo].style.visibility="visible";
			}
		for(var k=0;k<total_menus;k++) {if (menu[k].nombre==menu[i].entradas[j].hijo) {break;}}
		if (k==total_menus) {alert("activar:"+menu[i].entradas[j].hijo+": Menú inexistente");return;}
		menu[k].visible=1;
		}
	}
} // fin de activar

function cierra(nombre,modo) { //modo:0 (sólo submenúes), 1 (también menú)
	if (nombre==null)	{return;}
	for(var i=0;i<total_menus;i++) {if (menu[i].nombre==nombre) {break;}}
	if (i==total_menus) {alert("cierra:"+nombre+": Menú inexistente");return;}
	for(var j=0;j<menu[i].total_entradas;j++) {
		if (ns) {eval('document.'+menu[i].nombre+'.document.images["M'+i+'E'+j+'"].src=menu['+i+'].entradas['+j+'].img_off');}
		else {eval('document["M'+i+'E'+j+'"].src=menu['+i+'].entradas['+j+'].img_off');}
		cierra(menu[i].entradas[j].hijo,1);
	}
	if (modo==1 && menu[i].visible==1) {
		if (ns) {document.layers[menu[i].nombre].visibility="hide";}
		else {document.all[menu[i].nombre].style.visibility="hidden";}
		menu[i].visible=0;
	}
} // fin de cierra

function display() // genera el código HTML del menú
{
	var html='';
	var h,w;
	for (var i=0;i<total_menus;i++) {
		if (ns) {	html+='<LAYER ID="'+menu[i].nombre+'" top='+menu[i].top+' left='+menu[i].left;}
		else{html+='<DIV ID="'+menu[i].nombre+'" STYLE="position:absolute;top:'+menu[i].top+';left:'+menu[i].left+';';}
		if (menu[i].menu_padre!=null) {html+=' visibility=hidden';} else {menu[i].visible=1;}
		if (ns) {html+='>';} else {html+='">';}
		for (var j=0;j<menu[i].total_entradas;j++) {
			if (menu[i].entradas[j].nombre==null) {
				html+='<IMG NAME="M'+i+'E'+j+'" SRC="'+menu[i].entradas[j].img_off+'" BORDER=0>';
			}
			else {
				html+='<A HREF="'+menu[i].entradas[j].enlace+'" onMouseOver="activar(\'on\','+i+','+j+')';
				if (menu[i].entradas[j].info!=null) {html+=';window.status=\''+menu[i].entradas[j].info+'\';return true;';}
				html+='" onMouseOut="activar(\'off\','+i+','+j+')">';
				html+='<IMG NAME="M'+i+'E'+j+'" SRC="'+menu[i].entradas[j].img_off+'" BORDER=0';
				if (menu[i].width!=0) {html+=' WIDTH='+menu[i].width;}
				if (menu[i].height!=0) {html+=' HEIGHT='+menu[i].height;}
				html+='></A>';
			}
			if (menu[i].tipo=="lista") {html+='<BR>';}
		}
		if (ns) {html+='</LAYER>';} else {html+='</DIV>';}
	}
	return html;
} // fin de display

function posiciona() {
	var h,w;
	for (var i=0;i<total_menus;i++) {	
		if (menu[i].top==0 && menu[i].left==0) {	 // Ajuste automático de la posición del submenú
			h=0;w=0;
			if (menu[menu[i].menu_padre].tipo=="barra") {
				if (menu[menu[i].menu_padre].height==0) {h=getwh('H',menu[i].menu_padre,menu[i].entrada_padre);}
				else {h=menu[menu[i].menu_padre].height;}
				if (menu[menu[i].menu_padre].width==0) {
					for (var j=0;j<menu[i].entrada_padre;j++) {
						var w1=0;while(w1==0) {w1=getwh('W',menu[i].menu_padre,j);}
						w=w+w1;
					}
				}
				else {w=menu[menu[i].menu_padre].width*menu[i].entrada_padre;}
				menu[i].top=menu[menu[i].menu_padre].top+h+menu[i].offset_y;
				menu[i].left=menu[menu[i].menu_padre].left+w+menu[i].offset_x;
			}
			else {	// lista
				if (menu[menu[i].menu_padre].width==0) {w=getwh('W',menu[i].menu_padre,menu[i].entrada_padre);}
				else {w=menu[menu[i].menu_padre].width;}
				if (menu[menu[i].menu_padre].height==0) {
					for (var j=0;j<menu[i].entrada_padre;j++) {
						var h1=0;while(h1==0) {h1=getwh('H',menu[i].menu_padre,j);}
						h=h+h1;
					}
				}
				else {h=menu[menu[i].menu_padre].height*menu[i].entrada_padre;}
				menu[i].top=menu[menu[i].menu_padre].top+h+menu[i].offset_y;
				menu[i].left=menu[menu[i].menu_padre].left+w+menu[i].offset_x;
			}
			if (ns) {eval("document."+menu[i].nombre+".top="+menu[i].top);eval("document."+menu[i].nombre+".left="+menu[i].left);}
			else {eval("document.all[\""+menu[i].nombre+"\"].style.top="+menu[i].top);eval("document.all[\""+menu[i].nombre+"\"].style.left="+menu[i].left);}
		}
	}
}

function getwh(wh,i,j) {
	var valor=0;
	var nombre=menu[i].nombre;
	switch(wh) {
		case 'W':	if (ns) {eval('valor=document.'+nombre+'.document.images["M'+i+'E'+j+'"].width');}
						else{eval('valor=document["M'+i+'E'+j+'"].width');}
						break;
		case 'H':	if (ns) {eval('valor=document.'+nombre+'.document.images["M'+i+'E'+j+'"].height');}
						else{eval('valor=document["M'+i+'E'+j+'"].height');}
						break;
	}
	return valor;
}
