/********************************** 
	Arbol2.js
	Funciones JavaScript asociadas a la clase Arbol2 (Arbol2.java)
	07/06/2001
	DRUIDA 1.1
**********************************/
function Arbol2(nombre,nsdoc,bgcolor,oncolor,overcolor,id,imgs,entradas,multiseleccion,selecvisible,multiexpansion,visibilidad,rutaarbol,accion,alto) {
	this.nombre=nombre;
	this.nsdoc=nsdoc;
	this.bgcolor=bgcolor;
	this.oncolor=oncolor;
	this.overcolor=overcolor;
	this.id=id;
	this.imgs=null;
	if (imgs!=null) {this.imgs=new Array();for(var i=0;i<imgs.length;i++) {this.imgs[i]=new Image();this.imgs[i].src=imgs[i];}}
	this.imgs0=new Array();
	this.imgs0[0]=new Image();this.imgs0[0].src=rutaarbol+'p0.gif';
	this.imgs0[1]=new Image();this.imgs0[1].src=rutaarbol+'p1.gif';
	this.entradas0=entradas;
	this.multiseleccion=multiseleccion;
	this.selecvisible=selecvisible;
	this.multiexpansion=multiexpansion;
	this.visibilidad=visibilidad;
	this.rutaarbol=rutaarbol;
	this.accion=accion;
	this.alto=alto;
	this.entradas=new Vector();
	this.TAB=25;		// ancho de cada indentación de nivel	
	this.MAX_LONG_NIVEL=10;		// máxima longitud permitida para el código de un nivel
	this.pref_nivel=new Array();	 for(var i=0;i<=this.MAX_LONG_NIVEL;i++){this.pref_nivel[i]='';for(var j=0;j<i;j++){this.pref_nivel[i]+=' ';}}
	this.scroll=null;
	this.maxwidth=0; // ancho de la entrada más larga

	this.total=0;
	this.lastChecked=null;
	this.totalSelected=0;
	
	this.init=Arbol2Init;
	this.display=Arbol2Display;
	this.load=Arbol2Load;
	this.add=Arbol2Add;
	this.del=Arbol2Del;
	this.getIndex=Arbol2GetIndex;
	this.expand=Arbol2Expand;
	this.collapse=Arbol2Collapse;
	this.toggleExpansion=Arbol2ToggleExpansion;
	this.adjust=Arbol2Adjust;
	this.visualize=Arbol2Visualize;
	this.onMouse=Arbol2OnMouse;
	this.click=Arbol2Click;
	this.select=Arbol2Select;
	this.unselect=Arbol2UnSelect;
	this.toggleSelection=Arbol2ToggleSelection;
	this.reset=Arbol2Reset;
	this.clean=Arbol2Clean;
	this.getSelected=Arbol2GetSelected;
	this.getEntry=Arbol2GetEntry;
	this.getLastChecked=Arbol2GetLastChecked;
	this.delSelected=Arbol2DelSelected;
	this.getSelectedLevels=Arbol2GetSelectedLevels;
	this.getSelectedCodes=Arbol2GetSelectedCodes;
	this.selectAll=Arbol2SelectAll;
	this.unselectAll=Arbol2UnSelectAll;
	this.toggleSelectionAll=Arbol2ToggleSelectionAll;
	this.setImage=Arbol2SetImage;
	this.setText=Arbol2SetText;
	this.setCode=Arbol2SetCode;
	this.setAction=Arbol2SetAction;
}

function Arbol2Init() {
	if (ns) {var nsdoc=eval('drdArbolScroll'+this.nombre+'.nsdoc');this.scroll=eval(nsdoc+'.layers["drdArbolScroll'+this.nombre+'"].document');}
	else {this.scroll=document.all['drdArbolScroll'+this.nombre];}
	this.load(this.entradas0);
	this.display();
}

function Arbol2Reset() {this.load(this.entradas0);this.display();}
function Arbol2Clean() {this.entradas.borrar();this.total=0;this.totalSelected=0;this.lastChecked=null;this.display();}

// Carga el árbol con entradas sustituyendo lo que ya hubiera
// Este método precisa .display a continuación
function Arbol2Load(entradas) {this.clean();this.add(entradas);}

// Añade un array de entradas al árbol.
// Para añadir una entrada: .add([[nivel,img,texto,código,acción]])
// Este método precisa .display a continuación
function Arbol2Add(entradas) {
	if (entradas==null || entradas.length==0) return;
	var i,j,k,f;
	var nivel='';
	var subnivel=new Array();
	for(i=0;i<entradas.length;i++) {
		nivel='';
		f=false;
		subnivel=entradas[i][0].split('.');
		for(j=0;j<subnivel.length;j++) {nivel+=this.pref_nivel[this.MAX_LONG_NIVEL-subnivel[j].length]+subnivel[j];}
		for(j=this.entradas.longitud-1;j>=0;j--) {
			if (nivel==this.entradas.bd[j][5]) {alert('Árbol "'+this.nombre+'": entrada con nivel duplicado ("'+this.entradas.bd[j][0]+'")');break;}
			if (nivel<this.entradas.bd[j][5]) {continue;}
			f=true;break;
		}
		if (f || j==-1) {
			if (subnivel.length>1) {
				k=	this.getIndex(entradas[i][0].substring(0,entradas[i][0].lastIndexOf('.')));
				if (k==-1) {alert('Árbol "'+this.nombre+'": entrada ("'+entradas[i][0]+'") con algún subnivel padre inexistente');break;}
				else {if (this.entradas.bd[k][8]=='2') {this.entradas.bd[k][8]='0';}}
			}
			this.entradas.insertar(j+1,[entradas[i][0],entradas[i][1],entradas[i][2],entradas[i][3],entradas[i][4],nivel,'0',(subnivel.length==1||this.entradas.bd[k][8]=='1'?'1':'0'),'2']);
			if (ns) {k=(subnivel.length-1)*this.TAB+(entradas[i][2].length+5)*this.alto; if (k>this.maxwidth) {this.maxwidth=k;}}
		}
	}
	this.total=this.entradas.longitud;
}

function Arbol2GetIndex(nivel0) {
	if (this.entradas.longitud==0) {return -1;}
	var p1,p2,p,nivel='',subnivel;
	subnivel=nivel0.split('.');
	for(p=0;p<subnivel.length;p++) {nivel+=this.pref_nivel[this.MAX_LONG_NIVEL-subnivel[p].length]+subnivel[p];}
	p1=0;p2=this.entradas.longitud-1;
	while((p2-p1)>1) {
		p=parseInt((p1+p2)/2);
		if (nivel<this.entradas.bd[p][5]) {p2=p;}
		else if (nivel>this.entradas.bd[p][5]) {p1=p;}
		else {return p;}
	}
	if (nivel==this.entradas.bd[p1][5]) {return p1;}
	else if (nivel==this.entradas.bd[p2][5]) {return p2;}
	else {return -1;}
}

function Arbol2Display() {
	var i,j,contador=0;
	var body=(ns?'<TABLE BORDER=0 CELLPADDING=0 CELLSPACING=0 WIDTH='+this.maxwidth+'><TR><TD HEIGHT='+this.alto*this.entradas.longitud+'>&nbsp;</TD></TR></TABLE>':'');
	if (ns) {this.scroll.open();this.scroll.write(body);} else {this.scroll.innerHTML='';}
	if (ns) {
		for(i=0;i<this.entradas.longitud;i++) {
			body='<LAYER ID='+this.nombre+i+' left='+(this.entradas.bd[i][5].length/this.MAX_LONG_NIVEL-1)*this.TAB+' height='+this.alto;
			if (this.entradas.bd[i][6]=='1') {body+=' bgcolor="'+this.oncolor+'"';}
			if (this.entradas.bd[i][7]=='0') {body+=' visibility=hidden';}
			else {body+=' visibility=visible';body+=' top='+contador*(this.alto)+'"';contador++;}

			body+='><TABLE BORDER=0 CELLPADDING=0 CELLSPACING=0><TR>';
			body+=(this.entradas.bd[i][8]=='2'?'<TD WIDTH=16>&nbsp;</TD>':'<TD><A HREF="javascript:'+this.nombre+'.toggleExpansion(\''+this.entradas.bd[i][0]+'\');void(null);"><IMG NAME='+this.nombre+'I'+i+' SRC='+this.imgs0[this.entradas.bd[i][8]].src+' BORDER=0></A></TD>');
//			body+='<TD WIDTH=16>'+(this.entradas.bd[i][8]=='2'?'':'<A STYLE="font-size:10pt;font-weight:bold;text-decoration:none" HREF="javascript:'+this.nombre+'.toggleExpansion(\''+this.entradas.bd[i][0]+'\');void(null);">['+(this.entradas.bd[i][8]=='0'?'+':'-')+']</A>')+'</TD>';
			if (this.entradas.bd[i][1]!='') {body+='<TD><IMG NAME='+this.nombre+'G'+i+' SRC='+this.imgs[this.entradas.bd[i][1]].src+' BORDER=0></TD>';}
			body+='<TD NOWRAP><A ID='+this.id+' HREF="javascript:'+this.nombre+'.click('+i+',true);void(null);" onMouseOver="'+this.nombre+'.onMouse('+i+',\'on\')" onMouseOut="'+this.nombre+'.onMouse('+i+',\'off\')">'+this.entradas.bd[i][2]+'</A></TD>';
			body+='</TR></TABLE>';
			this.scroll.write(body+'</LAYER>');
		}
		this.scroll.close();
	}
	else {
		for(i=0;i<this.entradas.longitud;i++) {
			body+='<TABLE ID='+this.nombre+i+' BORDER=0 CELLPADDING=0 CELLSPACING=0 HEIGHT='+this.alto+' STYLE="display:'+(this.entradas.bd[i][7]=='0'?'none':'inline')+'"><TD WIDTH='+(this.entradas.bd[i][5].length/this.MAX_LONG_NIVEL-1)*this.TAB+' NOWRAP></TD>';
			body+=(this.entradas.bd[i][8]=='2'?'<TD WIDTH=16 NOWRAP></TD>':'<TD><A HREF="javascript:'+this.nombre+'.toggleExpansion(\''+this.entradas.bd[i][0]+'\');void(null);"><IMG NAME='+this.nombre+'I'+i+' BORDER=0></A></TD>');
			if (this.entradas.bd[i][1]!='') {body+='<TD><IMG NAME='+this.nombre+'G'+i+' BORDER=0></TD>';}
			body+='<TD NOWRAP WIDTH=100%><A ID='+this.nombre+'L'+i+' HREF="javascript:'+this.nombre+'.click('+i+',true);void(null);" onMouseOver="'+this.nombre+'.onMouse('+i+',\'on\')" onMouseOut="'+this.nombre+'.onMouse('+i+',\'off\')" STYLE="background-color='+(this.entradas.bd[i][6]=='1'?this.oncolor:this.bgcolor)+';" ><SPAN ID='+this.id+'>'+this.entradas.bd[i][2]+'</SPAN></A></TD>';
			body+='</TR></TABLE>';
			if (i/10==parseInt(i/10)) {this.scroll.insertAdjacentHTML('BeforeEnd',body);body='';}
		}
		if (body!='') {this.scroll.insertAdjacentHTML('BeforeEnd',body);}
		for(i=0;i<this.entradas.longitud;i++) {
			if (this.entradas.bd[i][8]!='2'){document.images[this.nombre+'I'+i].src=this.imgs0[this.entradas.bd[i][8]].src;}
			if (this.entradas.bd[i][1]!=''){document.images[this.nombre+'G'+i].src=this.imgs[this.entradas.bd[i][1]].src;}
		}
	}
	eval('drdArbolScroll'+this.nombre+"_init()");
	if (eval('drdArbolScroll'+this.nombre+'.activoy!=-1')) {eval('drdArbolScroll'+this.nombre+'.activoy=1');scrolly('drdArbolScroll'+this.nombre,0);eval('drdArbolScroll'+this.nombre+'.activoy=0');}
	if (eval('drdArbolScroll'+this.nombre+'.activox!=-1')) {eval('drdArbolScroll'+this.nombre+'.activox=1');scrollx('drdArbolScroll'+this.nombre,0);eval('drdArbolScroll'+this.nombre+'.activox=0');}
	this.lastChecked=null;
}

function Arbol2Expand(nivel) {
	var n=this.getIndex(nivel);
	if (n==-1) {alert('Árbol "'+this.nombre+'": el nivel "'+nivel+'" no existe');return false;}
	var nsdoc;
	if (this.entradas.bd[n][8]=='2') {alert('Árbol "'+this.nombre+'": el nivel "'+nivel+'" no se puede expandir por no tener subnivel');return false;}
	if (this.entradas.bd[n][8]=='1') {return true;}
	this.entradas.bd[n][8]='1';
	if (ns) {nsdoc=this.scroll.layers[this.nombre+n].document.images[this.nombre+'I'+n];}
	else {nsdoc=document.images[this.nombre+'I'+n];}
	nsdoc.src=this.imgs0[1].src;
	this.visualize(n);
	if(ns) {this.adjust();}
	else{
		eval('drdArbolScroll'+this.nombre+"_init()");
		if (eval('drdArbolScroll'+this.nombre+'.activoy!=-1')) {eval('drdArbolScroll'+this.nombre+'.activoy=1');scrolly('drdArbolScroll'+this.nombre,0);eval('drdArbolScroll'+this.nombre+'.activoy=0');}
		if (eval('drdArbolScroll'+this.nombre+'.activox!=-1')) {eval('drdArbolScroll'+this.nombre+'.activox=1');scrollx('drdArbolScroll'+this.nombre,0);eval('drdArbolScroll'+this.nombre+'.activox=0');}
	}
	return true;
}

function Arbol2Visualize(n) {
	var nivel2=this.entradas.bd[n][5];
	var l=nivel2.length;
	for(var i=n+1;i<this.entradas.longitud;i++) {
		if (this.entradas.bd[i][5].substr(0,l)!=nivel2) {return;}
		if (this.entradas.bd[i][5].length==(l+this.MAX_LONG_NIVEL)) {
			this.entradas.bd[i][7]='1';
			if (!ns) {document.all[this.nombre+i].style.display='inline';}
			if (this.entradas.bd[i][8]=='1') {this.visualize(i);}
		}
	}	
}

function Arbol2Collapse(nivel) {
	var n=this.getIndex(nivel);
	if (n==-1) {alert('Árbol "'+this.nombre+'": el nivel "'+nivel+'" no existe');return false;}	
	var i,l,nivel2;
	if (this.entradas.bd[n][8]=='2') {alert('Árbol "'+this.nombre+'": el nivel "'+nivel+'" no se puede colapsar por no tener subnivel');return false;}
	if (this.entradas.bd[n][8]=='0') {return true;}
	this.entradas.bd[n][8]='0';
	if (ns) {nsdoc=this.scroll.layers[this.nombre+n].document.images[this.nombre+'I'+n];}
	else {nsdoc=document.images[this.nombre+'I'+n];}
	nsdoc.src=this.imgs0[0].src;
	nivel2=this.entradas.bd[n][5];
	l=nivel2.length;
	for(i=n+1;i<this.entradas.longitud;i++) {
		if (this.entradas.bd[i][5].substr(0,l)!=nivel2) {break;}
		this.entradas.bd[i][7]='0';
		if (!ns) {document.all[this.nombre+i].style.display='none';}
	}
	if (ns) {this.adjust();}
	else{
		eval('drdArbolScroll'+this.nombre+"_init()");
		if (eval('drdArbolScroll'+this.nombre+'.activoy!=-1')) {eval('drdArbolScroll'+this.nombre+'.activoy=1');scrolly('drdArbolScroll'+this.nombre,0);eval('drdArbolScroll'+this.nombre+'.activoy=0');}
		if (eval('drdArbolScroll'+this.nombre+'.activox!=-1')) {eval('drdArbolScroll'+this.nombre+'.activox=1');scrollx('drdArbolScroll'+this.nombre,0);eval('drdArbolScroll'+this.nombre+'.activox=0');}
	}
	return true;
}

function Arbol2ToggleExpansion(nivel) {
	var n=this.getIndex(nivel);
	if (n==-1) {alert('Árbol "'+this.nombre+'": el nivel "'+nivel+'" no existe');return false;}	
	if (this.entradas.bd[n][8]=='2') {alert('Árbol "'+this.nombre+'": el nivel "'+nivel+'" no se puede expandir por no tener subnivel');return false;}
	if (this.entradas.bd[n][8]=='0') {return this.expand(nivel);} else {return this.collapse(nivel);}
}

function Arbol2Adjust() { // Ajusta posición y visibilidad
		var nsdoc,v;
		var contador=0;
		for(var i=0;i<this.entradas.longitud;i++) {
			v='hide';
			nsdoc=this.scroll.layers[this.nombre+i];
			if (this.entradas.bd[i][7]=='1') {v='inherit';nsdoc.top=contador*this.alto;contador++;}
			nsdoc.visibility=v;
		}
}

function Arbol2OnMouse(n,tipo) {
	if (this.multiseleccion==0 || this.overcolor=='' || this.entradas.bd[n][6]=='1') return;
	var bgcolor;
	if (tipo=='on') {bgcolor=this.overcolor;} else {bgcolor=this.bgcolor;} 
	if (ns) {this.scroll.layers[this.nombre+n].bgColor=(bgcolor==''?null:bgcolor);}
	else {document.all[this.nombre+'L'+n].style.background=bgcolor;}
}

function Arbol2Click(nivel,flag) {
	var n,accion=this.accion;
	if (flag) {n=nivel;}	else {n=this.getIndex(nivel);}
	if (n==-1 || n>this.entradas.longitud) {alert('Árbol "'+this.nombre+'": el nivel "'+nivel+'" no existe');return false;}
	this.lastChecked=this.entradas.bd[n][0];
	if (this.entradas.bd[n][4]!='') {accion=this.entradas.bd[n][4];}
	if (accion!='') {if (!eval(accion)) {return false;}}
	if (this.entradas.bd[n][6]=='0') {return this.select(n,true);} else {return this.unselect(n,true);}
}

function Arbol2Select(nivel,flag) {
	if (this.multiseleccion==0) {return false;}
	var n;
	if (flag) {n=nivel;}	else {n=this.getIndex(nivel);}
	if (n==-1 || n>this.entradas.longitud) {alert('Árbol "'+this.nombre+'": el nivel "'+nivel+'" no existe');return false;}
	if (this.entradas.bd[n][6]=='1') {return true;}
	if (this.multiseleccion==1) {if (this.totalSelected==1) {this.unselect(this.getSelectedLevels());}}
	else if (this.multiseleccion!=-1) {if (this.totalSelected>=this.multiseleccion) {alert('El máximo permitido de niveles seleccionados es '+this.multiseleccion+'.');return false;}}
	this.entradas.bd[n][6]='1';
	this.totalSelected++;
	if (ns) {this.scroll.layers[this.nombre+n].bgColor=this.oncolor;} else {document.all[this.nombre+'L'+n].style.background=this.oncolor;}
	return true;
}

function Arbol2UnSelect(nivel,flag) {
	var n;
	if (flag) {n=nivel;}	else {n=this.getIndex(nivel);}
	if (n==-1 || n>this.entradas.longitud) {alert('Árbol "'+this.nombre+'": el nivel "'+nivel+'" no existe');return false;}
	if (this.entradas.bd[n][6]=='0') {return true;}
	this.entradas.bd[n][6]='0';
	this.totalSelected--;
	if (ns) {this.scroll.layers[this.nombre+n].bgColor=(this.bgcolor==''?null:this.bgcolor);} else {document.all[this.nombre+'L'+n].style.background=this.bgcolor;}
	return true;
}

function Arbol2ToggleSelection(nivel,flag) {
	var n;
	if (flag) {n=nivel;}	else {n=this.getIndex(nivel);}
	if (n==-1 || n>this.entradas.longitud) {alert('Árbol "'+this.nombre+'": el nivel "'+nivel+'" no existe');return false;}
	if (this.entradas.bd[n][6]=='0') {return this.select(n,true);} else {return this.unselect(n,true);}
}

function Arbol2GetSelected() {
	var salida=new Array();
	var contador=0;
	for(var i=0;i<this.entradas.longitud;i++) {
		if (this.entradas.bd[i][6]=='0') continue;
		salida[contador++]=[this.entradas.bd[i][0],this.entradas.bd[i][1],this.entradas.bd[i][2],this.entradas.bd[i][3],this.entradas.bd[i][4]];
	}
	return salida;
}

function Arbol2GetEntry(nivel) {
	var n=this.getIndex(nivel);
	if (n==-1) {return null;}	
	return [this.entradas.bd[n][0],this.entradas.bd[n][1],this.entradas.bd[n][2],this.entradas.bd[n][3],this.entradas.bd[n][4]];
}

function Arbol2GetSelectedLevels(separador) {
	var salida=new Array();
	var contador=0;
	for(var i=0;i<this.entradas.longitud;i++) {
		if (this.entradas.bd[i][6]=='0') continue;
		salida[contador++]=this.entradas.bd[i][0];
	}
	if (this.multiseleccion==1) {separador=' ';}
	if (separador) {return salida.join(separador);}
	else return salida;
}

function Arbol2GetSelectedCodes(separador) {
	var salida=new Array();
	var contador=0;
	for(var i=0;i<this.entradas.longitud;i++) {
		if (this.entradas.bd[i][6]=='0') continue;
		salida[contador++]=this.entradas.bd[i][3];
	}
	if (this.multiseleccion==1) {separador=' ';}
	if (separador) {return salida.join(separador);}
	else return salida;
}

// Elimina un array de niveles (y sus subniveles, si procede)
// Para un único nivel: .del(['01.02.03']);
// Este método precisa .display() a continuación
function Arbol2Del(niveles) {
	if (niveles==null || niveles.length==0) return;
	if (this.multiseleccion==1) {niveles=[niveles];}
	var n,i,j,nivel,l,p,nsdoc;
	for(i=0;i<niveles.length;i++) {
		n=this.getIndex(niveles[i]);
		if (n==-1) {continue;}
		if (this.entradas.bd[n][8]=='2') {
			if (this.entradas.bd[n][6]=='1') {this.totalSelected--;}
			this.entradas.eliminar(n);
			this.total--;
		}
		else {
			nivel=this.entradas.bd[n][5]; l=nivel.length;
			for(j=n;j<this.entradas.longitud;j++) {
				if (this.entradas.bd[j][5].substr(0,l)==nivel) {if (this.entradas.bd[j][6]=='1') {this.totalSelected--;} this.entradas.eliminar(j); this.total--; j--;}
				else {break;}
			}
		}
		p=n-1;
		if (n==0 || this.entradas.bd[p][8]=='2') {continue;}
		nivel=this.entradas.bd[p][5]; l=nivel.length;
		if (n!=this.entradas.longitud && this.entradas.bd[n][5].substr(0,l)==nivel) {continue;}
		this.entradas.bd[p][8]='2';
	}
}

// Este método precisa .display() a continuación
function Arbol2DelSelected() {this.del(this.getSelectedLevels());}

function Arbol2GetLastChecked() {
	if (this.lastChecked==null) {return null;}
	return [this.entradas.bd[this.lastChecked][0],this.entradas.bd[this.lastChecked][1],this.entradas.bd[this.lastChecked][2],this.entradas.bd[this.lastChecked][3],this.entradas.bd[this.lastChecked][4]];
}

function Arbol2SelectAll() {if (this.multiseleccion==-1) {for(var n=0;n<this.entradas.longitud;n++) {this.select(n,true);}}}
function Arbol2UnSelectAll() {for(var n=0;n<this.entradas.longitud;n++) {this.unselect(n,true);}}
function Arbol2ToggleSelectionAll() {if (this.multiseleccion==-1) {for(var n=0;n<this.entradas.longitud;n++) {this.toggleSelection(n,true);}}}

function Arbol2SetImage(nivel,imagen) {
	var n=this.getIndex(nivel);
	if (n==-1) {alert('Árbol "'+this.nombre+'": el nivel "'+nivel+'" no existe');return false;}
	if (this.entradas.bd[n][1]=='') {alert('Árbol "'+this.nombre+'": el nivel '+nivel+' no tiene ninguna imagen asociada para poder cambiar');return false;}
	if (isNaN(imagen) || imagen*1<0 || imagen*1>=this.imgs.length)  {alert('Árbol "'+this.nombre+'": la imagen número '+imagen+' no existe');return false;}
	this.entradas.bd[n][1]=imagen;
	if (ns) {nsdoc=this.scroll.layers[this.nombre+n].document.images[this.nombre+'G'+n];}
	else {nsdoc=document.images[this.nombre+'G'+n];}
	nsdoc.src=this.imgs[imagen].src;
	return true;
}

function Arbol2SetText(nivel,texto) {
	var i=this.getIndex(nivel);
	if (i==-1) {alert('Árbol "'+this.nombre+'": el nivel "'+nivel+'" no existe');return false;}
	this.entradas.bd[i][2]=texto;
	if (ns) {
		var body='<TABLE BORDER=0 CELLPADDING=0 CELLSPACING=0><TR>';
		body+=(this.entradas.bd[i][8]=='2'?'<TD><IMG SRC='+this.imgs0[this.entradas.bd[i][8]].src+' BORDER=0></TD>':'<TD><A HREF="javascript:'+this.nombre+'.toggleExpansion(\''+this.entradas.bd[i][0]+'\');void(null);"><IMG NAME='+this.nombre+'I'+i+' SRC='+this.imgs0[this.entradas.bd[i][8]].src+' BORDER=0></A></TD>');
		if (this.entradas.bd[i][1]!='') {body+='<TD><IMG NAME='+this.nombre+'G'+i+' SRC='+this.imgs[this.entradas.bd[i][parseInt(1)]].src+' BORDER=0></TD>';}
		body+='<TD><A ID='+this.id+' HREF="javascript:'+this.nombre+'.click('+i+',true);void(null);" onMouseOver="'+this.nombre+'.onMouse('+i+',\'on\')" onMouseOut="'+this.nombre+'.onMouse('+i+',\'off\')">'+this.entradas.bd[i][2]+'</A></TD>';
		body+='</TR></TABLE>';	
		this.scroll.layers[this.nombre+i].document.open();this.scroll.layers[this.nombre+i].document.write(body);this.scroll.layers[this.nombre+i].document.close();
	}
	else {
		var body='<SPAN ID='+this.id+'>'+this.entradas.bd[i][2]+'</SPAN>';
		document.all[this.nombre+'L'+i].innerHTML=body;
	}	
	return true;
}

function Arbol2SetCode(nivel,codigo) {
	var i=this.getIndex(nivel); if (i==-1) {alert('Árbol "'+this.nombre+'": el nivel "'+nivel+'" no existe');return false;}
	this.entradas.bd[i][3]=codigo;
	return true;
}

function Arbol2SetAction(nivel,accion) {
	var i=this.getIndex(nivel); if (i==-1) {alert('Árbol "'+this.nombre+'": el nivel "'+nivel+'" no existe');return false;}
	this.entradas.bd[i][4]=accion;
	return true;
}
