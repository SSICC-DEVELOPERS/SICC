/********************************** 
   INDRA/CAR/Druida 3.0
   $Id: d3calendario.js,v 1.1 2009/12/03 19:03:47 pecbazalar Exp $
**********************************/
//function Calendario(nombre,nsdoc,width,height,bordepixels,idmesanno,idsemana,iddiaoff,iddiaon,ruta,fm,fM,d,m,a,accion,despl, festivos,finde, mostrarmeses, mostrarSoloMes) {
   function Calendario(nombre,width,height,bordepixels,idmesanno,idsemana,iddiaoff,iddiaon,ruta,fm,fM,d,m,a,accion,despl, festivos,finde, mostrarmeses, mostrarSoloMes) {
	this.nombre=nombre;
	//this.nsdoc=nsdoc;
	this.width=width;
	this.height=height;
	this.bordepixels=bordepixels;
	this.idmesanno=idmesanno;
	this.idsemana=idsemana;
	this.iddiaoff=iddiaoff;
	this.iddiaon=iddiaon;
	this.ruta=ruta;
	this.fm=fm;	// fecha mínima
	this.mm=1;	// mes mínimo	
	if (fm!=null) {this.mm=parseInt(fm.substr(0,2));this.ym=parseInt(fm.substr(3,4));}
	else {this.ym=entornoV('Ym');}	// año mínimo
	this.fM=fM;	// fecha máxima
	this.mM=12;	// mes máximo
	if (fM!=null) {this.mM=parseInt(fM.substr(0,2));this.yM=parseInt(fM.substr(3,4));}
	else {this.yM=entornoV('YM');}	// año máximo
	this.a=a;
	this.m=m;
	this.d=d;
	this.selected=null;
	this.accion=accion;
	this.desplazamiento=despl;
   if (this.desplazamiento=='null')
   {this.desplazamiento=null;
   }
	this.festivos=new Vector(); if (festivos!=null) {this.festivos.cargar(festivos);}
	this.finde=finde;
	this.mostrarmeses=mostrarmeses;
	this.f_init=false;
	this.semana=[DrdMsgCore(229),DrdMsgCore(223),DrdMsgCore(224),DrdMsgCore(225),DrdMsgCore(226),DrdMsgCore(227),DrdMsgCore(228),DrdMsgCore(229)];
   this.meses=['',DrdMsgCore(204),DrdMsgCore(205),DrdMsgCore(206),DrdMsgCore(207),DrdMsgCore(208),DrdMsgCore(209),DrdMsgCore(210),DrdMsgCore(211),DrdMsgCore(212),DrdMsgCore(213),DrdMsgCore(214),DrdMsgCore(215)];
	this.ancho=null;
	this.ancho2=null;
	this.ancho3=null;
	this.alto=null;
	this.ds=null;
	this.imgs=new Array();
	this.imgs[0]=new Image(); this.imgs[0].src=ruta+'cr1.gif';
	this.imgs[1]=new Image(); this.imgs[1].src=ruta+'cr2.gif';
	this.imgs[2]=new Image(); this.imgs[2].src=ruta+'ca1.gif';
	this.imgs[3]=new Image(); this.imgs[3].src=ruta+'ca2.gif';
	this.top=new Array();
	this.left=new Array();
   this.mostrarSoloMes=mostrarSoloMes;
   
	this.init=CalendarioInit;
	this.display=CalendarioDisplay;
	this.setAnno=CalendarioSetAnno;
	this.setMes=CalendarioSetMes;
	this.setDia=CalendarioSetDia;
	this.clickDia=CalendarioClickDia;
	this.getLongitudMes=CalendarioGetLongitudMes;
	this.getAnno=CalendarioGetAnno;
	this.getMes=CalendarioGetMes;
	this.getDia=CalendarioGetDia;
	this.getDiaSeleccionado=CalendarioGetDiaSeleccionado;
	this.getDiaSemana=CalendarioGetDiaSemana;
	this.getAnnoActual=CalendarioGetAnnoActual;
	this.getMesActual=CalendarioGetMesActual;
	this.getDiaActual=CalendarioGetDiaActual;
	this.getDiaSemanaActual=CalendarioGetDiaSemanaActual;
	this.getFechaPosterior=CalendarioGetFechaPosterior;
	this.capa=CalendarioCapa;
	this.over=CalendarioOver;
	this.incrementaMes=CalendarioIncrementaMes;
	this.decrementaMes=CalendarioDecrementaMes;
	this.incrementaAnno=CalendarioIncrementaAnno;
	this.decrementaAnno=CalendarioDecrementaAnno;
	this.isFestivo=CalendarioIsFestivo;
	this.getFestivoID=CalendarioGetFestivoID;
	this.addFestivo=CalendarioAddFestivo;
	this.delFestivo=CalendarioDelFestivo;
	this.setFinSemanaID=CalendarioSetFinSemanaID;
}

function CalendarioInit() {
	var alto=parseInt(this.height/8)-this.bordepixels; this.alto=alto;
	var ancho=parseInt((this.width-this.bordepixels*8)/7); this.ancho=ancho;
	var ancho2=parseInt((this.width-this.bordepixels*7-64)*2/3); this.ancho2=ancho2;
	var ancho3=7*ancho-ancho2-64+this.bordepixels; this.ancho3=ancho3;
	var html='<TABLE BORDER=0 CELLPADDING=0 CELLSPACING='+this.bordepixels+' WIDTH='+(7*ancho+8*this.bordepixels)+'><TR>';
   //var html='<TABLE BORDER=0 CELLPADDING=0 CELLSPACING='+this.bordepixels+' WIDTH=100%><TR>';

	if (this.desplazamiento == 'N') {
		html+='<TD WIDTH=16 ID='+this.idmesanno+'><IMG NAME=\''+this.nombre+'RM\' SRC="'+this.ruta+'cr2.gif" BORDER="0" ALT="'+DrdMsgCore(197)+'"></TD>';
   } else if (this.desplazamiento==null) {
		html+='';
	} else {
		html+='<TD WIDTH=16 ID='+this.idmesanno+'><A HREF=\'javascript:'+this.nombre+'.decrementaMes();';
      if (this.mostrarmeses=='3')
      {
         // decrementar meses anterior y siguiente
         var calAnterior = this.nombre+'anterior';
         html += calAnterior+'.decrementaMes();';
         var calSiguiente = this.nombre+'siguiente';
         html += calSiguiente+'.decrementaMes();';
      }
         
      html+='void(null);\' onMouseOver=\''+this.nombre+'.over("RM",true);return true;\' onMouseOut=\''+this.nombre+'.over("RM")\'><IMG NAME=\''+this.nombre+'RM\' SRC='+this.ruta+'cr1.gif BORDER=0 ALT="'+DrdMsgCore(197)+'"></A></TD>';
	}

	html+='<TD HEIGHT='+alto+' WIDTH='+ancho2+' ID='+this.idmesanno+' ALIGN=center>&nbsp;</TD>';
	
	if (this.desplazamiento == 'N') {
		html+='<TD WIDTH=16 ID='+this.idmesanno+'><IMG NAME=\''+this.nombre+'AM\' SRC='+this.ruta+'ca2.gif BORDER=0 ALT="'+DrdMsgCore(198)+'"></A></TD>';
	} else if (this.desplazamiento==null) {
		html+='';
   } else {
		html+='<TD WIDTH=16 ID='+this.idmesanno+'><A HREF=\'javascript:'+this.nombre+'.incrementaMes();';
      if (this.mostrarmeses=='3')
      {
         // incrementar meses anterior y siguiente
         var calAnterior = this.nombre+'anterior';
         html += calAnterior+'.incrementaMes();';
         var calSiguiente = this.nombre+'siguiente';
         html += calSiguiente+'.incrementaMes();';
      }
      
      html+= 'void(null);\' onMouseOver=\''+this.nombre+'.over("AM",true);return true;\' onMouseOut=\''+this.nombre+'.over("AM")\'><IMG NAME=\''+this.nombre+'AM\' SRC='+this.ruta+'ca1.gif BORDER=0 ALT="'+DrdMsgCore(198)+'"></A></TD>';
	}

   if (!this.mostrarSoloMes){
   
      if (this.desplazamiento == 'N') {
         html+='<TD WIDTH=16 ID='+this.idmesanno+'><IMG NAME=\''+this.nombre+'RA\' SRC='+this.ruta+'cr2.gif BORDER=0 ALT="'+DrdMsgCore(199)+'"></TD>';
      } else if (this.desplazamiento==null) {
         html+='';
      } else {

         html+='<TD WIDTH=16 ID='+this.idmesanno+'><A HREF=\'javascript:'+this.nombre+'.decrementaAnno();';

         if (this.mostrarmeses=='3')
         {
            // decrementar año de los meses anterior y siguiente
            var calAnterior = this.nombre+'anterior';
            html += calAnterior+'.decrementaAnno();';
            var calSiguiente = this.nombre+'siguiente';
            html += calSiguiente+'.decrementaAnno();';
         }
         
         html+='void(null);\' onMouseOver=\''+this.nombre+'.over("RA",true);return true;\' onMouseOut=\''+this.nombre+'.over("RA")\'><IMG NAME=\''+this.nombre+'RA\' SRC='+this.ruta+'cr1.gif BORDER=0 ALT="'+DrdMsgCore(199)+'"></A></TD>';
      }

      html+='<TD WIDTH='+ancho3+' ID='+this.idmesanno+' ALIGN=center>&nbsp;</TD>';

      if (this.desplazamiento == 'N') {
         html+='<TD WIDTH=16 ID='+this.idmesanno+'><IMG NAME=\''+this.nombre+'AA\' SRC='+this.ruta+'ca2.gif BORDER=0 ALT="'+DrdMsgCore(200)+'"></TD>';
      } else if (this.desplazamiento==null) {
   //		html+='<TD WIDTH=16 ID='+this.idmesanno+'></TD>';
         html+='';
      } else {

         html+='<TD WIDTH=16 ID='+this.idmesanno+'><A HREF=\'javascript:'+this.nombre+'.incrementaAnno();';
         if (this.mostrarmeses=='3')
         {
            // incrementar meses anterior y siguiente
            var calAnterior = this.nombre+'anterior';
            html += calAnterior+'.incrementaAnno();';
            var calSiguiente = this.nombre+'siguiente';
            html += calSiguiente+'.incrementaAnno();';
         }
         
         html+='void(null);\' onMouseOver=\''+this.nombre+'.over("AA",true);return true;\' onMouseOut=\''+this.nombre+'.over("AA")\'><IMG NAME=\''+this.nombre+'AA\' SRC='+this.ruta+'ca1.gif BORDER=0 ALT="'+DrdMsgCore(200)+'"></A></TD>';
      }
   }
	html+='</TR></TABLE>';

   if (this.desplazamiento==null) {
      vPxlBordeCab=this.bordepixels;
   } else {
      vPxlBordeCab=this.bordepixels;
   }

   // Cabecera
/* 	if (ns) {
		html+='<LAYER id='+this.nombre+'71 top='+this.bordepixels+' left='+(16+2*vPxlBordeCab)+'><TABLE BORDER=0 CELLPADDING=0 CELLSPACING=0><TR><TD ID='+this.idmesanno+' HEIGHT='+alto+' WIDTH='+ancho2+' ALIGN=center>&nbsp;</TD></TR></TABLE></LAYER>';
		html+='<LAYER id='+this.nombre+'72 top='+this.bordepixels+' left='+(48+5*vPxlBordeCab+ancho2)+'><TABLE BORDER=0 CELLPADDING=0 CELLSPACING=0><TR><TD ID='+this.idmesanno+' HEIGHT='+alto+' WIDTH='+ancho3+' ALIGN=center>&nbsp;</TD></TR></TABLE></LAYER>';
	}
	else */
	 if (!this.mostrarSoloMes){
		html+='<DIV id='+this.nombre+'71 STYLE="position:absolute;top:'+vPxlBordeCab+';left:'+(16+2*vPxlBordeCab)+';"><TABLE BORDER=0 CELLPADDING=0 CELLSPACING=0><TR><TD ID='+this.idmesanno+' HEIGHT='+alto+' WIDTH='+ancho2+' ALIGN=center>&nbsp;</TD></TR></TABLE></DIV>';
		html+='<DIV id='+this.nombre+'72 STYLE="position:absolute;top:'+vPxlBordeCab+';left:'+(48+5*vPxlBordeCab+ancho2)+';"><TABLE BORDER=0 CELLPADDING=0 CELLSPACING=0><TR><TD ID='+this.idmesanno+' HEIGHT='+alto+' WIDTH='+ancho3+' ALIGN=center>&nbsp;</TD></TR></TABLE></DIV>';
	}
   else {//this.mostrarSoloMes=true
      var elLeft=Math.round(((7*ancho+8*this.bordepixels)-ancho2)/2);
		html+='<DIV id='+this.nombre+'71 STYLE="position:absolute;top:'+vPxlBordeCab+';left:'+elLeft+';"><TABLE BORDER=0 CELLPADDING=0 CELLSPACING=0><TR><TD ID='+this.idmesanno+' HEIGHT='+alto+' WIDTH='+ancho2+' ALIGN=center>&nbsp;</TD></TR></TABLE></DIV>';
		html+='<DIV id='+this.nombre+'72 STYLE="visibility:hidden; border:1px solid red;position:absolute;top:'+vPxlBordeCab+';left:'+(48+5*vPxlBordeCab+ancho2)+';"></DIV>';
      }

   // Dias del mes
	for(var j=1;j<=7;j++) {
		//if (ns) {html+='<LAYER id='+this.nombre+'0'+j+' top='+(alto+2*this.bordepixels)+' left='+((j-1)*(ancho+this.bordepixels)+this.bordepixels)+'><TABLE BORDER=0 CELLPADDING=0 CELLSPACING=0><TR><TD ID='+this.idsemana+' HEIGHT='+alto+' WIDTH='+ancho+' ALIGN=center>'+this.semana[j]+'</TD></TR></TABLE></LAYER>';}
		//else {
         html+='<DIV id='+this.nombre+'0'+j+' STYLE="position:absolute;top:'+(alto+2*this.bordepixels)+';left:'+((j-1)*(ancho+this.bordepixels)+this.bordepixels)+';"><TABLE BORDER=0 CELLPADDING=0 CELLSPACING=0><TR><TD ID='+this.idsemana+' HEIGHT='+alto+' WIDTH='+ancho+' ALIGN=center>'+this.semana[j]+'</TD></TR></TABLE></DIV>';
         //}
	}
	//if (ns) {html+='<LAYER id='+this.nombre+'11 top='+(2*(alto+this.bordepixels))+' left=0></LAYER>';html+='<LAYER id='+this.nombre+'12 top=0 left=0 visibility=hidden></LAYER>';}
	//else {
      html+='<DIV id='+this.nombre+'11 STYLE="position:absolute;top:'+(2*(alto+this.bordepixels))+';left:0;"></DIV>';html+='<DIV id='+this.nombre+'12 STYLE="position:absolute;top:0;left:0;visibility:hidden"><TABLE BORDER=0 CELLPADDING=0 CELLSPACING=0><TR><TD ID='+this.iddiaoff+' HEIGHT='+alto+' WIDTH='+ancho+' ALIGN=center>&nbsp;</TD></TR></TABLE></DIV>';
      //}

	var contador=11;
	for(var i=1;i<7;i++) {
		for(var j=1;j<=7;j++) {
			this.top[contador]=(i+1)*(alto+this.bordepixels)+this.bordepixels;
			this.left[contador++]=(j-1)*(ancho+this.bordepixels)+this.bordepixels;
		}
	}

	//if (ns) {this.nsdoc=eval(this.nsdoc);this.nsdoc.open();this.nsdoc.write(html);this.nsdoc.close();}
	//else {
      this.nsdoc=document.all[this.nombre+'0'];
      this.nsdoc.innerHTML=html;
      //}

	this.setAnno(this.a,true);
	this.setMes(this.m,true);
	this.setDia(this.d,true);
	this.ds=this.getDiaSemana(1,this.m,this.a);
	this.display();
	this.f_init=true;
}

function CalendarioDisplay() {
	var id0;

	//if (ns) {var nsdoc=this.nsdoc.layers[this.nombre+'12'];nsdoc.visibility="hide";}
	//else {
      document.all[this.nombre+'12'].style.visibility="hidden";
      //}
	var html='<TABLE BORDER=0 CELLPADDING=0 CELLSPACING='+this.bordepixels+'>';
	var dM=this.getLongitudMes(this.m,this.a);
	var dia=0;
	var contador=11;
	for(var i=1;i<7;i++) {html+='<TR>';
		for(var j=1;j<=7;j++) {
			dia=contador-9-this.ds;
			if (dia<1 || dia>dM) {dia='&nbsp;';}
			if (this.isFestivo(dia,this.m,this.a)) {id0=this.getFestivoID(dia,this.m,this.a);}
			else if (j>5 && dia!='&nbsp;') {id0=this.finde;}
			else {id0=this.iddiaoff;}
			html+='<TD id='+id0+' HEIGHT='+this.alto+' WIDTH='+this.ancho+" ALIGN=center><A HREF='javascript:"+this.nombre+".clickDia("+dia+");void(null);' onMouseOver='window.status=\""+dia+'/'+this.m+'/'+this.a+"\";return true;' ID="+id0+">"+dia+"</A></TD>";
			contador++;
		}
		html+='</TR>';
	}
	html+='</TABLE>';
	//if (ns) {var nsdoc=this.nsdoc.layers[this.nombre+'11'].document;nsdoc.open();nsdoc.write(html);nsdoc.close();}
	//else {
      document.all[this.nombre+'11'].innerHTML=html;
      //}
	this.capa('71',this.ancho2,this.idmesanno,this.meses[this.m]);
	this.capa('72',this.ancho3,this.idmesanno,this.a);
	if (this.d!=-1) {this.setDia(this.d);}

   // Ver si visualizo tres calendarios
      if (this.mostrarmeses=='3')
      {
         // añadir festivo a los meses anterior y siguiente
         var calAnterior = eval(this.nombre+'anterior');
//         alert('Anterior');
         calAnterior.display();
         var calSiguiente = eval(this.nombre+'siguiente');
 //        alert('Siguiente');
         calSiguiente.display();
      }


}

function CalendarioCapa(numero,ancho,estilo,texto) {
	if (estilo==this.iddiaoff) {return;}
	var texto2=texto;
	if (texto!='&nbsp;' && numero<70) {texto2="<A HREF='javascript:"+this.nombre+".clickDia("+texto+");void(null);' onMouseOver='window.status=\""+texto+'/'+this.m+'/'+this.a+"\";return true;' ID="+estilo+">"+texto+"</A>";}
	var html='<TABLE BORDER=0 CELLPADDING=0 CELLSPACING=0><TR><TD ID='+estilo+' HEIGHT='+this.alto+' WIDTH='+ancho+' ALIGN=center>'+texto2+'</TD></TR></TABLE>';
	if (numero>10 && numero<70) {
		numero=12;
		var posi=9+texto+this.ds;
		//if (ns) {var nsdoc=this.nsdoc.layers[this.nombre+numero];nsdoc.top=this.top[posi];nsdoc.left=this.left[posi];nsdoc.visibility="inherit";}
		//else {
         document.all[this.nombre+numero].style.top=this.top[posi];document.all[this.nombre+numero].style.left=this.left[posi];document.all[this.nombre+numero].style.visibility="inherit";
         //}
	}
	//if (ns) {var nsdoc=this.nsdoc.layers[this.nombre+numero].document;nsdoc.open();nsdoc.write(html);nsdoc.close();}
	//else {
      document.all[this.nombre+numero].innerHTML=html;
      //}
}

function CalendarioOver(opcion,over) {
	var estado='', imagen=0;
	switch(opcion) {
		case 'RM': estado=DrdMsgCore(197); imagen=0; break;
		case 'AM': estado=DrdMsgCore(198); imagen=2; break;
		case 'RA': estado=DrdMsgCore(199); imagen=0; break;
		case 'AA': estado=DrdMsgCore(200); imagen=2; break;
	}
	if (over) {window.status=estado;imagen++;}
	//if (ns) {this.nsdoc.images[this.nombre+opcion].src=this.imgs[imagen].src;}
	//else {
      document.images[this.nombre+opcion].src=this.imgs[imagen].src;
      //}
}

function CalendarioSetAnno(anno,noDisplay) {
	if (anno==0) {anno=this.getAnnoActual();}
	if (anno<this.ym) {this.a=this.ym;}
	else if (anno>this.yM) {this.a=this.yM;}
	else {this.a=anno;}
   //Si estoy en un año 'limite' testeo también el més
   if (anno == this.yM || anno == this.ym)   {
      this.setMes (this.m,noDisplay);
      }
	this.ds=this.getDiaSemana(1,this.m,this.a);
	if (!noDisplay) {this.display();}
}

function CalendarioSetMes(mes,noDisplay) {
	if (mes==0) {mes=this.getMesActual();}
	if (mes<1) {this.m=1;}
	else if (mes>12) {this.m=12;}
	else {this.m=mes;}
	if (this.a==this.ym && this.m<this.mm) {this.m=this.mm;}
	if (this.a==this.yM && this.m>this.mM) {this.m=this.mM;}
	this.ds=this.getDiaSemana(1,this.m,this.a);
	if (!noDisplay) {this.display();}
}

function CalendarioSetDia(dia,noDisplay) {
	if (!noDisplay && this.d!=-1) {this.capa(this.d+9+this.ds,this.ancho,this.iddiaoff,this.d);}
	if (dia==-1) {this.d=-1;return;}
	if (dia==0) {dia=this.getDiaActual();}
	if (dia<1) {this.d=1;}
	else if (dia>this.getLongitudMes(this.m,this.a)) {this.d=this.getLongitudMes(this.m,this.a);}
	else {this.d=dia;}
	if (!noDisplay) {	this.capa(this.d+9+this.ds,this.ancho,this.iddiaon,this.d);}
}

function CalendarioClickDia(dia) {
	this.selected=dia;
	if (this.accion!=null && !eval(this.accion)) {return;}
	this.setDia(dia);
}

function CalendarioGetLongitudMes(mes,anno) {
	if (mes==4||mes==6||mes==9||mes==11) return 30;
	else if (mes==2 && (((anno%4==0) && (anno%100!=0)) || (anno%400==0))) return 29;
	else if (mes==2) return 28;
	else return 31;
}

function CalendarioGetDiaSeleccionado() {return this.selected;}
function CalendarioGetDia() {return this.d;}
function CalendarioGetDiaSemana(d,m,a) {
	var hoy=new Date();
	if (d) {hoy.setFullYear(a,m-1,d);}
	else {
		if (this.a==-1) {return -1;}
		hoy.setFullYear(this.a,this.m-1,this.d);
	}
	return (hoy.getDay()==0?7:hoy.getDay());
}
function CalendarioGetMes() {return this.m;}
function CalendarioGetAnno() {return this.a;}
function CalendarioGetDiaActual() {var hoy=new Date();return hoy.getDate();}
function CalendarioGetDiaSemanaActual() {var hoy=new Date();return (hoy.getDay()==0?7:hoy.getDay());}
function CalendarioGetMesActual() {var hoy=new Date();return hoy.getMonth()+1;}
function CalendarioGetAnnoActual() {var hoy=new Date();return hoy.getFullYear();}
function CalendarioGetFechaPosterior(d0,m0,a0,D,M,A) { // (10,07,2001,+-1,+-2,+-3)
	var hoy=new Date();
   hoy.setFullYear((a0+A),(m0+M-1),(d0+D)); // En setFullYear los dias empiezan en 1 pero los meses en 0
	return [hoy.getDate(),hoy.getMonth()+1,hoy.getFullYear()];
}

function CalendarioIncrementaMes() {
	this.m++;
	if (this.m==13) {this.m=1;this.incrementaAnno();}
	else {this.setMes(this.m);}
}

function CalendarioDecrementaMes() {
	this.m--;
	if (this.m==0) {this.m=12;this.decrementaAnno();}
	else {this.setMes(this.m);}
}

function CalendarioIncrementaAnno() {this.a++;this.setAnno(this.a);}
function CalendarioDecrementaAnno() {this.a--;this.setAnno(this.a);}

function CalendarioIsFestivo(dia,mes,anno) {
	if (this.festivos.longitud!=0) {
		for(var i=0;i<this.festivos.longitud;i++) {
			if (this.festivos.ij(i,0)==dia && this.festivos.ij(i,1)==mes && (this.festivos.ij(i,2)==anno || this.festivos.ij(i,2)=='*')) {return true;}
		}
	}
	return false;
}

function CalendarioGetFestivoID(dia,mes,anno) {
	if (this.festivos.longitud!=0) {
		for(var i=0;i<this.festivos.longitud;i++) {
			if (this.festivos.ij(i,0)==dia && this.festivos.ij(i,1)==mes && (this.festivos.ij(i,2)==anno || this.festivos.ij(i,2)=='*')) {return this.festivos.ij(i,3);}
		}
	}
	return "";
}

function CalendarioAddFestivo() {
	var d,m,a,id;
	if (CalendarioAddFestivo.arguments.length==3) {
		d=CalendarioAddFestivo.arguments[0];
		m=CalendarioAddFestivo.arguments[1];
		a='*';
		id=CalendarioAddFestivo.arguments[2];
	}
	else if (CalendarioAddFestivo.arguments.length==4) {
		d=CalendarioAddFestivo.arguments[0];
		m=CalendarioAddFestivo.arguments[1];
		a=CalendarioAddFestivo.arguments[2];
		id=CalendarioAddFestivo.arguments[3];
	}
	else {
      muestraMsgError(DrdMsgCore(201));  // nº de argumentos incorrecto
      return;
      }
	this.festivos.agregar([d,m,a,id]);
   // Ver si visualizo tres calendarios
      if (this.mostrarmeses=='3')
      {
         // añadir festivo a los meses anterior y siguiente
         var calAnterior = eval(this.nombre+'anterior');
         calAnterior.addFestivo(d,m,a,id);
         var calSiguiente = eval(this.nombre+'siguiente');
         calSiguiente.addFestivo(d,m,a,id);
      }
}

function CalendarioDelFestivo() {
	var d,m,a,id;
	if (CalendarioDelFestivo.arguments.length==2) {
		d=CalendarioDelFestivo.arguments[0];
		m=CalendarioDelFestivo.arguments[1];
		a='*';
	}
	else if (CalendarioDelFestivo.arguments.length==3) {
		d=CalendarioDelFestivo.arguments[0];
		m=CalendarioDelFestivo.arguments[1];
		a=CalendarioDelFestivo.arguments[2];
	}
	else {
      muestraMsgError(DrdMsgCore(203));  //festivo inexistente
      return;
      }
	for(var i=0;i<this.festivos.longitud;i++) {
		if (this.festivos.ij(i,0)==d && this.festivos.ij(i,1)==m && this.festivos.ij(i,2)==a) {this.festivos.eliminar(i);return;}
	}
   // Ver si visualizo tres calendarios

   muestraMsgError(DrdMsgCore(202));  // nº de argumentos incorrecto
}

function CalendarioSetFinSemanaID(findeID) {this.finde=findeID;}
