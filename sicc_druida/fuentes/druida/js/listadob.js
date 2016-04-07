/********************************** 
	ListadoB.js
	Funciones JavaScript asociadas a la clase ListadoB (ListadoB.java)
	12/06/2001
	DRUIDA 1.1
**********************************/
function ListadoB(nombre,nsdoc,filasc,filasf,colsd,colsi,bgcolor,cellspacing,oncolor,overcolor,celdas,estilos,anchos,caracteres,alto,multiseleccion,preseleccion,visibilidad,ruta,wi,w,wd,w5,hc,h,hf,bordepixels,separador,tituloy,accion) {
	this.nombre=nombre;
	this.nsdoc=nsdoc;
	this.filasc=filasc;
	this.filasf=filasf;
	this.colsi=colsi;
	this.colsd=colsd;
	this.bgcolor=bgcolor;
	this.oncolor=oncolor;
	this.overcolor=overcolor;
	this.celdas=celdas;
	this.estilos0=estilos;
	this.estilos=new Vector();
	this.id0='';
	this.cellspacing=cellspacing;
	this.anchos=new Array();
	for(i=0;i<anchos.length;i++) {this.anchos[i]=anchos[i]-this.cellspacing;}
	if (colsi!=0) {this.anchos[colsi-1]-=this.cellspacing;}
	if (colsd!=0) {this.anchos[anchos.length-1]-=this.cellspacing;}
	this.anchos[anchos.length-colsd-1]-=this.cellspacing;
	this.caracteres=caracteres;
	this.alto=alto;
	this.alto2=alto-this.cellspacing*2;
	this.multiseleccion=multiseleccion;
	this.preseleccion=preseleccion;
	this.visibilidad=visibilidad;
	this.ruta=ruta;
	this.wi=wi;
	this.w=w;
	this.wd=wd;
	this.w5=w5;
	this.hc=hc;
	this.h=h;
	this.hf=hf;
	this.h5=null;
	this.T0=hc+bordepixels+tituloy+(tituloy==0?0:bordepixels);
	this.T=this.T0;
	this.L0=wi+bordepixels;
	this.L=this.L0;
	this.separador=separador;
	this.accion=accion;
	this.scroll=false;
	this.N2=null;
	this.N4=null;
	this.N5=null;
	this.N6=null;
	this.N8=null;
	this.seleccion=new Array();for(i=0;i<celdas.length;i++) {this.seleccion[i]=false;}
	this.Nw=new Array();
	this.Nh=new Array();
	this.f_init=false;
	this.botones=new Array();
	this.checked=null;

	this.init=ListadoBInit;
	this.display=ListadoBdisplay;
	this.tablaN=ListadoBTablaN;
	this.Y=ListadoBY;
	this.X=ListadoBX;
	this.getSeleccion=ListadoBgetSeleccion;
	this.getNSeleccion=ListadoBgetNSeleccion;
}

function ListadoBInit() {
	if (ns) {
		this.N2=eval(this.nsdoc+'.'+this.nombre+'2');
		this.N4=eval(this.nsdoc+'.'+this.nombre+'4');
		this.N5=eval(this.nsdoc+'.'+this.nombre+'5');
		this.N6=eval(this.nsdoc+'.'+this.nombre+'6');
		this.N7=eval(this.nsdoc+'.'+this.nombre+'7');
		this.N8=eval(this.nsdoc+'.'+this.nombre+'8');
		this.N9=eval(this.nsdoc+'.'+this.nombre+'9');
	}
	else {
		this.N2=document.all[this.nombre+'2'].style;
		this.N4=document.all[this.nombre+'4'].style;
		this.N5=document.all[this.nombre+'5'].style;
		this.N6=document.all[this.nombre+'6'].style;
		this.N7=document.all[this.nombre+'7'].style;
		this.N8=document.all[this.nombre+'8'].style;
		this.N9=document.all[this.nombre+'9'].style;
	}
	this.display();
	this.f_init=true;
}

function ListadoBdisplay() {
	this.estilos.cargar(this.estilos0); this.id0='';
	var i=this.estilos.buscar('Tabla',0); if (i!=-1) {this.id0=this.estilos.ij(i,1);this.estilos.eliminar(i);}
	this.botones=new Array();

	this.h5=this.alto*(this.celdas.length-this.filasc-this.filasf);
	this.Nw=[0,this.wi,this.w5,this.wd,this.wi,this.w5,this.wd,this.wi,this.w5,this.wd];this.Nh=[0,this.hc,this.h,this.hf,this.hc,this.h,this.hf,this.hc,this.h,this.hf];
	if (ns) {eval(this.nsdoc.substring(0,this.nsdoc.length-9)+'.visibility="hide"');}
	else {document.all[this.nombre+'0'].style.visibility='hidden';}

	this.tablaN(1,0,0,this.filasc-1,this.colsi-1);
	this.tablaN(2,0,this.colsi,this.filasc-1,this.anchos.length-this.colsd-1);
	this.tablaN(3,0,this.anchos.length-this.colsd,this.filasc-1,this.anchos.length-1);
	this.tablaN(4,this.filasc,0,this.celdas.length-this.filasf-1,this.colsi-1);
	this.tablaN(5,this.filasc,this.colsi,this.celdas.length-this.filasf-1,this.anchos.length-this.colsd-1);
	this.tablaN(6,this.filasc,this.anchos.length-this.colsd,this.celdas.length-this.filasf-1,this.anchos.length-1);
	this.tablaN(7,this.celdas.length-this.filasf,0,this.celdas.length-1,this.colsi-1);
	this.tablaN(8,this.celdas.length-this.filasf,this.colsi,this.celdas.length-1,this.anchos.length-this.colsd-1);
	this.tablaN(9,this.celdas.length-this.filasf,this.anchos.length-this.colsd,this.celdas.length-1,this.anchos.length-1);

	if (ns) {eval(this.nsdoc.substring(0,this.nsdoc.length-9)+'.visibility="'+this.visibilidad+'"');}
	else {document.all[this.nombre+'0'].style.visibility=this.visibilidad;}
	if (this.h5<=this.h) {this.N7.top=this.hc+this.h5;this.N8.top=this.hc+this.h5;this.N9.top=this.hc+this.h5;}
	for(var i=0;i<this.botones.length;i++) {
		this.botones[i].f_init=false;
		this.botones[i].init();
	}
}

function ListadoBTablaN(N,i1,j1,i2,j2) {
	var i,j,k,k2,html='',id='',dato='',nsdoc,nsdoc2;
	if (ns) {nsdoc=eval(this.nsdoc+'.'+this.nombre+N+'.document');nsdoc.open();} else {nsdoc=document.all[this.nombre+N];nsdoc.innerHTML='';}
	if (j1<=j2) {
		for(i=i1;i<=i2;i++) {
			if (N==5) {
				if (ns) {html='<LAYER id='+this.nombre+'S'+i+' height='+this.alto+' width='+this.w5+' bgcolor="'+(this.seleccion[i]?this.oncolor:this.bgcolor)+'" top='+((i-i1)*this.alto)+'>';}
				else {html='<DIV id='+this.nombre+'S'+i+' STYLE="position:absolute;height:'+this.alto+';width:'+this.w5+';background-color:\''+(this.seleccion[i]?this.oncolor:this.bgcolor)+'\';top:'+((i-i1)*this.alto)+';">';}
				html+='<TABLE BORDER=0 CELLPADDING=0 CELLSPACING='+this.cellspacing+' WIDTH='+this.w5+'><TR>';
			}
			else {html='<TABLE BORDER=0 CELLPADDING=0 CELLSPACING='+this.cellspacing+' WIDTH='+this.Nw[N]+'><TR>';}
			for(j=j1;j<=j2;j++) {
				id=this.id0;
				for(k=0;k<this.estilos.longitud;k++) {
					if (this.estilos.bd[k][0]=='Columnas') {id=this.estilos.bd[k][j+1];}
					else if (this.estilos.bd[k][0]=='Filas') {id=this.estilos.bd[k][(i%(this.estilos.bd[k].length-1))+1];}
					else if (this.estilos.bd[k][0]=='Cols') {id=this.estilos.bd[k][(j%(this.estilos.bd[k].length-1))+1];}
					else if (this.estilos.bd[k][0]=='Bloque') {id=this.estilos.bd[k][(i*this.celdas[0].length+j)%(this.estilos.bd[k].length-1)+1];}
					else if (this.estilos.bd[k][0]=='F#') {if ((this.estilos.bd[k][1]=='N' && j==(this.celdas.length-1))||(this.estilos.bd[k][1]==(i+1))) {id=this.estilos.bd[k][2];}}
					else if (this.estilos.bd[k][0]=='C#') {if ((this.estilos.bd[k][1]=='N' && j==(this.celdas[0].length-1))||(this.estilos.bd[k][1]==(j+1))) {id=this.estilos.bd[k][2];}}
					else if (this.estilos.bd[k][0]=='#') {if ((this.estilos.bd[k][1]==(i+1) || (this.estilos.bd[k][1]=='N' && i==this.celdas.length-1)) && (this.estilos.bd[k][2]==(j+1) || (this.estilos.bd[k][2]=='N' && j==this.anchos.length-1))) {id=this.estilos.bd[k][3];this.estilos.eliminar(k);k--;}}
				}			
				k=1;k2=this.anchos[j];while((j+k)<=j2 && this.celdas[i][j+k]==null){k2+=this.anchos[j+k];k++;}
				html+='<TD NOWRAP ID='+id;
				html+=' WIDTH='+k2;
				if (j==j1) {html+=' HEIGHT='+this.alto2;}

				if (this.celdas[i][j]==null) {dato='';}
				else if (this.celdas[i][j].substr(0,10)=='drd_boton_') {
					dato=eval(this.celdas[i][j].substr(10)+'.getBody()');
					var btn=eval(this.celdas[i][j].substr(10));
					this.botones[this.botones.length]=btn;
					if (ns) {btn.nsdoc=this.nsdoc+'.'+this.nombre+N+'.document.'+btn.nombre+'I';}
				}
				else {
					if (this.caracteres==null) {dato=this.celdas[i][j];}
					else {dato=renglon(this.celdas[i][j],this.caracteres[j+1],this.caracteres[0]);}
					if (dato=='' || dato==' ') {dato='&nbsp;';}
					else {if (dato.charAt(0)==' ') {dato='&nbsp;'+dato.substring(1);}}
				}
				if (k!=1) {html+=' COLSPAN='+k;j+=k-1;}
				html+='>'+dato;
				html+='</TD>';
			}
			html+='</TR></TABLE>';
			if (N==5) {
				if (ns) {
					html+='</LAYER>';nsdoc.write(html);
					if (this.multiseleccion!=0) {
						nsdoc2=eval(this.nsdoc+'.'+this.nombre+'5.document.layers[\''+this.nombre+'S'+i+'\']');
						nsdoc2.onmouseover=ListadoBover;
						nsdoc2.onmouseout=ListadoBout;
						nsdoc2.onmousedown=ListadoBchk;
						nsdoc2.i=i;
						nsdoc2.objeto=this.nombre;
						nsdoc2.captureEvents(Event.MOUSEDOWN);
					}
				}
				else {
					html+='</DIV>';nsdoc.insertAdjacentHTML('BeforeEnd',html);
					if (this.multiseleccion!=0) {
						nsdoc2=document.all[this.nombre+'S'+i];
						nsdoc2.onmouseover=ListadoBover;
						nsdoc2.onmouseout=ListadoBout;
						nsdoc2.onmousedown=ListadoBchk;
						nsdoc2.i=i;
						nsdoc2.objeto=this.nombre;
					}
				}
			}
			else {
				if (ns) {nsdoc.write(html);}
				else {nsdoc.insertAdjacentHTML('BeforeEnd',html);}
			}
		}
	}
	if (ns) {nsdoc.close();}
}

function ListadoBover(e) {
	var objeto=eval(this.objeto);
	if (objeto.multiseleccion==0) {return;}
	if (objeto.seleccion[this.i]) {return;}
	if (ns) {this.bgColor=objeto.overcolor;	} else {this.style.background=objeto.overcolor;}
}
function ListadoBout(e) {
	var objeto=eval(this.objeto);
	if (objeto.multiseleccion==0) {return;}
	if (objeto.seleccion[this.i]) {return;}
	if (ns) {this.bgColor=objeto.bgcolor;	} else {this.style.background=objeto.bgcolor;}
}

function ListadoBchk(e) {
	var objeto=eval(this.objeto);
	objeto.checked=this.i;
	if (objeto.multiseleccion==0) {return;}
	if (objeto.accion!=null && !eval(objeto.accion)) {return false;}
	if (objeto.multiseleccion!=-1) {
		if (objeto.multiseleccion==1) {
			var sel0=objeto.getSeleccion();
			if (sel0!='' && sel0!=this.i) {
				objeto.seleccion[sel0]=false;
				if (ns) {eval(objeto.nsdoc+'.'+objeto.nombre+'5.document.layers[\''+objeto.nombre+'S'+sel0+'\'].bgColor="'+objeto.bgcolor+'"');}
				else {document.all[objeto.nombre+'S'+sel0].style.background=objeto.bgcolor;}
			}
		}
		else {if (objeto.getNSeleccion()==objeto.multiseleccion && objeto.seleccion[this.i]==false) {alert('El máximo permitido son '+objeto.multiseleccion+' filas seleccionadas');return false;}}
	}
	objeto.seleccion[this.i]=!objeto.seleccion[this.i];
	var color=(objeto.seleccion[this.i]?objeto.oncolor:objeto.overcolor);
	if (ns) {this.bgColor=color;} else {this.style.background=color;}
	return false;
}

function ListadoBY(dir,inc) { //dir=1=>up, -1=>down
	if (this.h5<=this.h) return;
	this.T+=dir*inc;
	if(dir==1) {if (this.T>this.T0) {this.T=this.T0;}}
	else {if ((this.T0-this.T)>(this.h5-this.h)) {this.T=this.T0-this.h5+this.h;}}
	this.N4.top=this.T;
	this.N5.top=this.T;
	this.N6.top=this.T;
	if (ns) {
		this.N4.clip.top=this.T0-this.T;this.N4.clip.bottom=this.T0-this.T+this.h;
		this.N5.clip.top=this.T0-this.T;this.N5.clip.bottom=this.T0-this.T+this.h;
		this.N6.clip.top=this.T0-this.T;this.N6.clip.bottom=this.T0-this.T+this.h;
	}
	else {//divName.style.clip = "rect(0px 100px 50px 0px)"//clip:rect(top,right,bottom,left)
		this.N4.clip="rect("+(this.T0-this.T)+"px "+this.Nw[4]+"px "+(this.T0-this.T+this.h)+"px 0px)";
		this.N5.clip="rect("+(this.T0-this.T)+"px "+(this.L0-this.L+this.w)+"px "+(this.T0-this.T+this.h)+"px "+(this.L0-this.L)+"px)";
		this.N6.clip="rect("+(this.T0-this.T)+"px "+this.Nw[6]+"px "+(this.T0-this.T+this.h)+"px 0px)";
	}
	if (this.scroll) {setTimeout(this.nombre+'.Y('+dir+','+inc+')',20);}
}

function ListadoBX(dir,inc) { //dir=1=>izq, -1=>der
	if (this.w5<=this.w) return;
	this.L+=dir*inc;
	if(dir==1) {if (this.L>this.L0) {this.L=this.L0;}}
	else {if ((this.L0-this.L)>(this.w5-this.w)) {this.L=this.L0-this.w5+this.w;}}
	this.N2.left=this.L;
	this.N5.left=this.L;
	this.N8.left=this.L;
	if (ns) {
		this.N2.clip.left=this.L0-this.L;this.N2.clip.right=this.L0-this.L+this.w;
		this.N5.clip.left=this.L0-this.L;this.N5.clip.right=this.L0-this.L+this.w;
		this.N8.clip.left=this.L0-this.L;this.N8.clip.right=this.L0-this.L+this.w;
	}
	else {
		this.N2.clip="rect(0px "+(this.L0-this.L+this.w)+"px "+this.Nh[2]+"px "+(this.L0-this.L)+"px)";
		this.N5.clip="rect("+(this.T0-this.T)+"px "+(this.L0-this.L+this.w)+"px "+(this.T0-this.T+this.h)+"px "+(this.L0-this.L)+"px)";
		this.N8.clip="rect(0px "+(this.L0-this.L+this.w)+"px "+this.Nh[8]+"px "+(this.L0-this.L)+"px)";
	}
	if (this.scroll) {setTimeout(this.nombre+'.X('+dir+','+inc+')',20);}
}

function ListadoBgetSeleccion() {
	var selec='';
	for(var i=0;i<this.celdas.length;i++) {
		if (this.seleccion[i]) {
			if (selec!='') {selec+=this.separador;}
			selec+=i;
		}
	}
	return selec;
}

function ListadoBgetNSeleccion() {
	var contador=0;
	for(var i=0;i<this.celdas.length;i++) {if (this.seleccion[i]) {contador++;}}
	return contador;
}
