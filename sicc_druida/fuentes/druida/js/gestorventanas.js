/********************************** 
	gestorventanas.js
	Funciones JavaScript asociadas a la clase GestorVentanas (GestorVentanas.java)
	20/04/2001
	DRUIDA 1.1
**********************************/

function GestorVentanas(nombre,descripcion,scroll,id,alto,numeracion,pars) {
	this.nombre=nombre;
	this.descripcion=descripcion;
	this.scroll=null; if (scroll) {this.scroll=scroll;}
	this.id=null;
	this.alto=null;
	this.numeracion=null;
	this.pars=null;
	this.opener=null;
	this.top=(descripcion=='TOP');
	if (this.top) {
		this.id=id;
		this.alto=alto;
		this.numeracion=numeracion;
		this.pars=pars;
	}
	else {this.opener=eval('opener.'+this.nombre);}	
	this.w=null;
	this.numero=0;

	this.init=GestorVentanasInit;
	this.finit=GestorVentanasFinit;
	this.openWin=GestorVentanasOpenWin;
	this.closeWin=GestorVentanasCloseWin;
	this.addWin=GestorVentanasAddWin;
	this.delWin=GestorVentanasDelWin;
	this.getWin=GestorVentanasGetWin;
	this.getWinTarget=GestorVentanasGetWinTarget;
	this.testWin=GestorVentanasTestWin;
	this.focus=GestorVentanasFocus;
	this.blur=GestorVentanasBlur;
	this.print=GestorVentanasPrint;
	this.accion=GestorVentanasAccion;
	this.display=GestorVentanasDisplay;
}

function GestorVentanasInit() {
	if (this.top) {this.w=new Vector();}
	else {this.opener.addWin(this.descripcion,window.self);}
}

function GestorVentanasFinit() {
	if (this.top) {this.id=null;while(this.w.longitud!=0) {eval('this.w.ij(0,1).'+this.nombre+'.nombre=null');this.closeWin(this.w.ij(0,0));}}
	else {if (this.nombre!=null) {this.opener.delWin(this.descripcion);}}
}

function GestorVentanasOpenWin(href,descripcion,overlap,pars) { // pars=opcional
	if (this.top) {
		var nombre;
		var i=this.w.buscar(descripcion,0);
		if (i!=-1 && !overlap) {this.w.ij(i,1).focus();return;}
		if (i==-1) {this.numero++;nombre='w'+this.numero;}
		else {nombre=this.w.ij(i,1).name;}
		referencia=window.open(href,'w'+this.numero,(pars?pars:this.pars));
		referencia.focus();
		if (href=='') {this.addWin(descripcion,referencia);}
	}
	else {if (pars) {this.opener.openWin(href,descripcion,overlap,pars);} else {this.opener.openWin(href,descripcion,overlap);}}
}

function GestorVentanasAddWin(descripcion,referencia) {
	if (this.top) {
		var i=this.w.buscar(descripcion,0);
		if (i==-1) {this.w.agregar([descripcion,referencia]);this.display();return true;}
		return false;
	}
	else {this.opener.addWin(descripcion,referencia);}
}

function GestorVentanasCloseWin(descripcion,del) {
	if (this.top) {
		var i=this.w.buscar(descripcion,0);
		if (i==-1) {return false;}
		if (!del) {if (!(this.w.ij(i,1).closed)) {this.w.ij(i,1).close();}}
		this.w.ij2(null,i,1);
		this.w.eliminar(i);
		if(this.id!=null) {this.display();}
		return true;
	}
	else {this.opener.closeWin(descripcion,(del==true?true:false));}
}

function GestorVentanasDelWin(descripcion) {
	if (this.top) {this.closeWin(descripcion,true);}
	else {this.opener.closeWin(descripcion,true);}
}

function GestorVentanasTestWin(descripcion) {
	if (this.top) {return (this.w.buscar(descripcion,0)!=-1);}
	else {return this.opener.testWin(descripcion);}
}

function GestorVentanasGetWin(descripcion) {
	if (this.top) {
		var i=this.w.buscar(descripcion,0); if (i==-1) {return null;}
		return this.w.ij(i,1);
	}
	else {return this.opener.getWin(descripcion);}
}

function GestorVentanasGetWinTarget(descripcion) {
	if (this.top) {
		var i=this.w.buscar(descripcion,0); if (i==-1) {return null;}
		return this.w.ij(i,1).name;
	}
	else {return this.opener.getWinTarget(descripcion);}
}

function GestorVentanasAccion(descripcion,tipo) {
	var accion='';
	switch(tipo) {
		case 'focus': accion='focus()'; break;
		case 'blur': accion='blur()'; break;
		case 'print': this.accion(descripcion,'focus');accion='print()'; break;
	}
	if (this.top) {
		if (descripcion=='TOP') {eval('window.'+accion);}
		else {
			var i=this.w.buscar(descripcion,0);if (i==-1) {return false;}
			eval('this.w.ij(i,1).'+accion);
		}
		return true;
	}
	else {eval('this.opener.'+tipo+'(descripcion)');}
}

function GestorVentanasFocus(descripcion) {this.accion(descripcion,'focus');}
function GestorVentanasBlur(descripcion) {this.accion(descripcion,'blur');}
function GestorVentanasPrint(descripcion) {this.accion(descripcion,'print');}

function GestorVentanasDisplay() {
	if (this.top) {
		var html='<TABLE BORDER=0 CELLPADDING=0 CELLSPACING=0>';
		for(var i=0;i<this.w.longitud;i++) {
			if (this.w.ij(i,1).closed) {this.w.ij2(null,i,1);this.w.eliminar(i);if (i>=this.w.longitud) {break;}}
			html+='<TR><TD'+(this.alto==0?'':' HEIGHT='+this.alto)+' NOWRAP><A HREF="javascript:'+this.nombre+'.w.ij('+i+',1).focus()"'+(this.id==null?'':' ID='+this.id)+'>'+(this.numeracion?(i+1)+'. ':'')+this.w.ij(i,0)+'</A></TD></TR>';
		}
		html+='</TABLE>';
		scroll_to(this.scroll,html);
	}
	else {this.opener.display();}
}
