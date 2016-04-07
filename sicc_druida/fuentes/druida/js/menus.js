// menus.js
// DRUIDA 1.1
// Menús desplegables
// Usado por la clase Menu.java
// Versión 2001.03.28
// Quitar los comentarios acelera la carga de las páginas

function display(nombre) {
	n=eval(nombre);
	n.m[0][0]=1;
	posiciona(nombre);						// calcula posicionamiento de cada submenú
	for (var i=0;i<n.m.length;i++) {		// posiciona los submenús
		if (ns) {
			eval(n.nsdoc+'.'+nombre+'M'+i+'.top=n.m[i][2]');
			eval(n.nsdoc+'.'+nombre+'M'+i+'.left=n.m[i][3]');
		}
		else {
			eval("document.all['"+nombre+"M"+i+"'].style.top=n.m[i][2]");
			eval("document.all['"+nombre+"M"+i+"'].style.left=n.m[i][3]");
		}
	}
	visibilidad(nombre,n.visibilidad);
}

function visibilidad_menu(nombre,codigo) {
	var tipo,nsdoc;
	var n=eval(nombre);
	if (ns) {
		nsdoc=eval(nombre+'.nsdoc');
		if (codigo=='V') {tipo="inherit";}
		else if (codigo=='O') {tipo="hide";}
		else if (codigo=='C') {tipo=eval(nombre+'.vsb');if (tipo=="visible") {tipo="hide";} else {tipo="inherit";}}
	}
	else {
		if (codigo=='V') {tipo="inherit";}
		else if (codigo=='O') {tipo="hidden";}
		else if (codigo=='C') {tipo=eval(nombre+'.vsb');if (tipo=="visible") {tipo="hidden";} else {tipo="inherit";}}
	}
	for(var i=0;i<n.m.length;i++) {	
		if (n.m[i][0]==0) continue;
		if (ns) {eval(nsdoc+'.'+nombre+'M'+i+'.visibility="'+tipo+'"');	}
		else {eval('document.all["'+nombre+'M'+i+'"].style.visibility="'+tipo+'"');}
	}
	if (tipo=="inherit") {eval(nombre+'.vsb="visible"');} else {eval(nombre+'.vsb="hidden"');}
}

function off(i,j,nombre) { //i=submenú, j=entrada, nombre_menú
	n=eval(nombre);
	n.ai=i;
	n.aj=j;
	n.temp=setTimeout("colapsar('"+nombre+"')", n.temp0);
}

function on(i,j,nombre) { // i=submenú, j=entrada, nombre_menú
	n=eval(nombre);
	clearTimeout(n.temp);
	var nsdoc=eval(nombre+'.nsdoc');
	if (i==n.ai) {
		if (n.e[n.ai][n.aj][3]!=-1) {cierra(nombre,n.e[n.ai][n.aj][3],1);}
		if (ns) {eval(nsdoc+'.'+nombre+'M'+n.ai+'.document.images["'+nombre+'M'+n.ai+'E'+n.aj+'"].src=n.ruta+n.nimgs[n.e[n.ai][n.aj][1]]');}
		else{eval('document["'+nombre+'M'+n.ai+'E'+n.aj+'"].src=n.ruta+n.nimgs[n.e[n.ai][n.aj][1]]');}
		n.e[n.ai][n.aj][0]=0;
	}
	else {cierra(nombre,i,0);}
	var io=n.e[i][j][2];
	if (ns) {eval(nsdoc+'.'+nombre+'M'+i+'.document.images["'+nombre+'M'+i+'E'+j+'"].src=n.ruta+n.nimgs[io]');}
	else{eval('document["'+nombre+'M'+i+'E'+j+'"].src=n.ruta+n.nimgs[io]');}
	n.e[i][j][0]=1;
	if (n.e[i][j][3]!=-1) {	// show
		if (ns) {eval(nsdoc+".layers['"+nombre+"M"+n.e[i][j][3]+"'].visibility='show'");}
		else {eval("document.all['"+nombre+"M"+n.e[i][j][3]+"'].style.visibility='visible'");}
		n.m[n.e[i][j][3]][0]=1;
	}
} // fin de activar

function cierra(nombre,i,modo) { //modo:0 (sólo submenúes internos), 1 (también el propio submenú). i==nº de submenú a cerrar
	n=eval(nombre);
	var nsdoc=eval(nombre+'.nsdoc');
	switch (n.m[i][1]) {
		case 'BI':
		case 'LI':
						var e0=n.e[i]; var e0l=e0.length;
						for(var j=0;j<e0l;j++) {	
							if (n.e[i][j][0]==0) continue;
							if (n.e[i][j][3]!=-1) {cierra(nombre,n.e[i][j][3],1);}
							if (ns) {
							eval(nsdoc+'.'+nombre+'M'+i+'.document.images["'+nombre+'M'+i+'E'+j+'"].src=n.ruta+n.nimgs[n.e['+i+']['+j+'][1]]');}
							else{eval('document["'+nombre+'M'+i+'E'+j+'"].src=n.ruta+n.nimgs[n.e['+i+']['+j+'][1]]');}
							n.e[i][j][0]=0;
						}						
						break;
	}
	if (modo==0) return;
	if (n.m[i][0]==1) {
		if (ns) {eval(nsdoc+".layers['"+nombre+"M"+i+"'].visibility='hide'");}
		else {eval("document.all['"+nombre+"M"+i+"'].style.visibility='hidden'");}
		n.m[i][0]=0;
	}
} // fin de cierra

function colapsar(nombre) {
	cierra(nombre,0,0);
	n=eval(nombre);
	if (n.colapsototal) {visibilidad_menu(nombre,'O');}
}

function posiciona(nombre) // cálculo posicionamiento de los submenús
{
	n=eval(nombre);
	var h,w;
	for (var i=0;i<n.m.length;i++) {
		if ((n.m[i][2]==-1 || n.m[i][3]==-1) && i!=0) {	 // Ajuste a la mitad de altura (o_y=height/2)
			mp=n.m[i][8]; ep=n.m[i][9]; // índices del menú padre y entrada padre
			if (ns) {eval('n.m[i][7]-='+n.nsdoc+'.'+nombre+'M'+i+'.document.height/2-'+getwh(nombre,'H',mp,ep)/2);}
			else {eval("n.m[i][7]-=document.all['"+nombre+"M"+i+"'].scrollHeight/2-"+getwh(nombre,'H',mp,ep)/2);}
			n.m[i][2]=0;n.m[i][3]=0;
		}		
		if (n.m[i][2]==0 && n.m[i][3]==0 && i!=0) {	 // Ajuste automático de la posición del submenú
			h=0;w=0;
			mp=n.m[i][8]; ep=n.m[i][9]; // índices del menú padre y entrada padre
			if (n.m[mp][1]=="BI") { // menú padre tipo barra
				h=n.m[mp][5];
				if (h==0) {h=getwh(nombre,'H',mp,ep);}
				if (n.m[mp][4]==0) {for(var j=0;j<ep;j++) {w+=getwh(nombre,'W',mp,j);}}
				else {w=n.m[mp][4]*ep;}
			}
			else { // menú padre tipo lista
				w=n.m[mp][4];
				if (w==0) {w=getwh(nombre,'W',mp,ep);}
				if (n.m[mp][5]==0) {for(var j=0;j<ep;j++) {h+=getwh(nombre,'H',mp,j);}}
				else {h=n.m[mp][5]*ep;}
			}
			n.m[i][2]=n.m[mp][2]+h+n.m[i][7];
			n.m[i][3]=n.m[mp][3]+w+n.m[i][6];
		}
		else {
			n.m[i][2]+=n.m[i][7];
			n.m[i][3]+=n.m[i][6];
		}
	}
}

function getwh(nombre,wh,i,j) {
	var valor=0;
	var nsdoc=eval(nombre+'.nsdoc');
	switch(wh) {
		case 'W':	if (ns) {eval('valor='+nsdoc+'.'+nombre+'M'+i+'.document.images["'+nombre+'M'+i+'E'+j+'"].width');}
						else{eval('valor=document["'+nombre+'M'+i+'E'+j+'"].width');}
						break;
		case 'H':	if (ns) {eval('valor='+nsdoc+'.'+nombre+'M'+i+'.document.images["'+nombre+'M'+i+'E'+j+'"].height');}
						else{eval('valor=document["'+nombre+'M'+i+'E'+j+'"].height');}
						break;
	}
	return valor;
}
