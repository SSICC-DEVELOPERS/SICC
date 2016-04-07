/********************************** 
	listadoa.js
	Funciones JavaScript asociadas a la clase ListadoA (ListadoA.java)
	15/03/2002
	DRUIDA 1.1
   $Id: listadoa.js,v 1.1 2009/12/03 19:03:48 pecbazalar Exp $
**********************************/
function ListadoA(nombre,nsdoc,multiseleccion,imagenoff,imagenon,ids,anchos,caracteres,datos,separador,preseleccionados,accion,clienteCache,renderOptimizado) {

   //métodos caché de datos (japleon):
   this.tengoDatosClienteCache=tengoDatosClienteCache;
   this.guardarDatosEnClienteCache=guardarDatosEnClienteCache;
   this.recuperarDatosClienteCache=recuperarDatosClienteCache;
   //inicialización caché de datos:
   this.datos=new Vector();
   if(arguments && arguments.length>12 && clienteCache!=null ){  
      clienteCache[1]="self";
		if(opener){
			if(eval("opener."+clienteCache[0]))	{
				clienteCache[1]="window.opener";
			   }
   		}
      this.rutaClienteCache=clienteCache[1]+"."+clienteCache[0];
      this.rutaVarClienteCache=clienteCache[1]; 
      this.varClienteCache=clienteCache[2];
      if (!(this.tengoDatosClienteCache(this.varClienteCache)) && (datos.length>0))
         this.guardarDatosEnClienteCache(datos,this.varClienteCache)
      else
         datos=this.recuperarDatosClienteCache(this.varClienteCache);
      }

   //Inicialización
	this.nombre=nombre;
	this.nsdoc=nsdoc;
	this.multiseleccion=multiseleccion;
   this.renderOptimizado=renderOptimizado;

   this.imagenoff=DrdPrecImg(imagenoff)
   this.imagenon=DrdPrecImg(imagenon)

	this.ids=ids;
	this.anchos=anchos;
	this.caracteres=caracteres;
	if (datos!=null) {this.datos.cargar(ListadoAescape(datos));}
	this.separador=separador;
	this.seleccion=new Vector();
	this.ultimo_pulsado=null;
	this.accion=accion;
	if (preseleccionados!=null) {this.seleccion.cargar(preseleccionados);}
	this.onSetDatos=null;
	this.blockImg=new Image();
	this.bloqueados=new Vector();
	this.btnImgs=new Vector();
	this.estilosCeldas=null;

   //Métodos
	this.init=ListadoAinit;
	this.display=ListadoAdisplay;
	this.display_normal=ListadoAdisplay_normal;
	this.display_simplificado=ListadoAdisplay_simplificado;
	this.on=ListadoAon;
	this.off=ListadoAoff;
	this.chk=ListadoAchk;
	this.getSeleccion=ListadoAgetSelect;
	this.getSeleccionOrdenada=ListadoAgetSeleccionOrdenada;
	this.onN=ListadoAonN;
	this.offN=ListadoAoffN;
	this.setDatos=ListadoAsetDatos;
	this.ischk=ListadoAischk;
	this.bloquea=ListadoAbloquea;
	this.desbloquea=ListadoAdesbloquea;
	this.scrollTo=ListadoAscrollTo;
	this.setImgOff=ListadoAsetImgOff;
	this.setBotonImg=ListadoAsetBotonImg;
   }

function ListadoAbloquea(codigo) {
	var i=this.datos.buscar(codigo,0);
	if (this.bloqueados.buscar(codigo,0)==-1 && i!=-1)	{
		var j=this.seleccion.buscar(codigo);
		if (j==-1) {this.bloqueados.agregar([codigo,0]);}
		else  {this.seleccion.eliminar(j);this.bloqueados.agregar([codigo,1]);}
		if (ns) {
			var nsdoc=eval(this.nsdoc+'.'+this.nombre+'capa.document.'+this.nombre+'scrollDiv.document.'+this.nombre+'scrollDivtv.document.'+this.nombre+'scroll.document');
			nsdoc.images[this.nombre+'btn'+i].src=this.blockImg.src;
		}
		else {if (document.images[this.nombre+'btn'+i]) document.images[this.nombre+'btn'+i].src=this.blockImg.src;}
		var ii=this.btnImgs.buscar(codigo,0); if (ii!=-1) {this.btnImgs.eliminar(ii);}
	}
}

function ListadoAdesbloquea(codigo) {
	var i=this.datos.buscar(codigo,0);
	var j=this.bloqueados.buscar(codigo,0);
	if (j!=-1 && i!=-1)	{
		var codigoB=this.bloqueados.ij(j);
		this.bloqueados.eliminar(j);	
		if (codigoB[1]==0) {this.seleccion.agregar(codigoB[0]);this.off(codigoB[0]);}
		else {this.on(codigoB[0]);}
	}
}

function ListadoAescape(datos0) {
	if (datos0!=null) {
		for(var i=0;i<datos0.length;i++) {
			for(var j=0;j<datos0[i].length;j++) {
				datos0[i][j]=escapeISO(datos0[i][j]);
			}
		}
	}
	return datos0;
}

function ListadoAinit() {
	var datos=this.datos.volcar();
	if (this.onSetDatos) {
		if (eval(this.onSetDatos)==false) {
			this.datos.borrar();
			this.seleccion.borrar();
			return;
		}
	}
	this.display();
}

function ListadoAsetDatos(datos) {
	if (this.onSetDatos) {if (eval(	this.onSetDatos)==false) return;}
	this.datos.borrar();
	if (datos!=null) {
		this.datos.cargar(ListadoAescape(datos));
	}
	this.seleccion.borrar();
}


function ListadoAdisplay() {
	if (!this.renderOptimizado && (this.ocupado || window.ocupado_lista)) {d3ocupado_ver('d3general',d3ocupado_general);}	
   if (this.renderOptimizado)
    	//setTimeout(this.nombre+'.display_simplificado()',0);
      this.display_simplificado()
   else
   	//setTimeout(this.nombre+'.display_normal()',0);
      this.display_normal()
   }

function ListadoAShift(e) {
	var shiftPressed = (window.Event) ? e.modifiers & Event.SHIFT_MASK : event.shiftKey;
	return !shiftPressed;
}

function ListadoAdisplay_normal() {
	var i,j,k=-1;
	var datoij='';

	var script_tab="";
	var tabIndex=null;
	eval("if (window."+this.nombre+"_tabIndex) tabIndex="+this.nombre+"_tabIndex;");
	if (tabIndex && tabIndex!="")
		script_tab+=" tabIndex='"+tabIndex+"' ";

	var ontab=null;
	eval("if (window."+this.nombre+"_ontab) ontab="+this.nombre+"_ontab;");

	var onshtab=null;
	eval("if (window."+this.nombre+"_onshtab) onshtab="+this.nombre+"_onshtab;");

	var html='<TABLE BORDER=0 CELLPADDING=0 CELLSPACING=0 WIDTH='+this.anchos[0]+'>';
	if (this.multiseleccion!=0) {
		for(i=0;i<this.datos.longitud;i++) {

			//Incluimos eventos de ontab y onshtab
			var script_tab_2="";
			if (this.datos.longitud==1)	{ //Si es el primero y a la vez es el último ...
				if (ontab || onshtab)	{
					script_tab_2+=" onKeyDown='";
					if (ontab)
						script_tab_2+="fontab_"+this.nombre+"(event);";
					if (onshtab)
						script_tab_2+="fonshtab_"+this.nombre+"(event);";
					script_tab_2+="' ";
					}
				}
			else if (i==0)	{ //Si es el primero ...
				if (onshtab)
					script_tab_2+=" onKeyDown='fonshtab_"+this.nombre+"(event);' ";
				}
			else if (i+1==this.datos.longitud)	{ //Si es el último ...
				if (ontab)
					script_tab_2+=" onKeyDown='fontab_"+this.nombre+"(event);' ";
				}

			html+='<TR>';
			html+="<TD WIDTH="+this.anchos[1]+" ID="+this.ids[((k+1)==this.ids.length?0:k+1)]+">";
			if (i==0) {html+="<IMG height='1' src='"+this.imgPath+"transparente.gif' width="+this.anchos[1]+"><br>";}
			if (this.dblClick) 
				{html+="<A "+script_tab+script_tab_2+" HREF='#' onDblClick='"+this.nombre+".chk(\""+this.datos.ij(i,0)+"\");' onclick='return ListadoAShift(event)' onmousedown='return ListadoAShift(event)'><IMG NAME='"+this.nombre+"btn"+i+"' SRC='";}
			else 
				{html+="<A "+script_tab+script_tab_2+" HREF='javascript:"+this.nombre+".chk(\""+this.datos.ij(i,0)+"\");void(null);' onclick='return ListadoAShift(event)' onmousedown='return ListadoAShift(event)'><IMG NAME='"+this.nombre+"btn"+i+"' SRC='";}
			var ii=this.btnImgs.buscar(this.datos.ij(i,0),0);
			if (ii!=-1) {html+=DrdImgPath()+this.btnImgs.ij(ii,1);}
			else if (this.bloqueados.buscar(this.datos.ij(i,0),0)!=-1) {html+=this.blockImg.src;}
			else {if (this.seleccion.buscar(this.datos.ij(i,0))==-1) {html+=this.imagenoff.src;} else {html+=this.imagenon.src;}}
			html+="' BORDER=0></A></TD>";
			for(j=1;j<this.anchos.length-1;j++) {
				var datoij0,cambio=false;
				k++; if (k==this.ids.length) {k=0;}
				datoij=(this.datos.ij(i,j)==''?'&nbsp;':this.datos.ij(i,j).toString());
//				if (this.caracteres!=null) {datoij=renglon(datoij,this.caracteres[j]*1,this.caracteres[0]*1);}
				if (this.caracteres!=null) {
					datoij0=datoij.replace(/&nbsp;/g,String.fromCharCode(160));
					datoij=renglon(datoij0,this.caracteres[j]*1,this.caracteres[0]*1);
					if (datoij0!=datoij && (this.caracteres[0]*1)!=0) cambio=true;
//					datoij=datoij.replace(/ /g,"&nbsp;");
				}
				var id2=null;
				if (this.estilosCeldas!=null) {id2=eval(this.estilosCeldas);} // estilosCeldas="mifuncion(i,j)"
				if (id2==null) {id2=this.ids[k];}
				html+='<TD WIDTH='+this.anchos[j+1]+' ID='+id2+'>'
				if (i==0) {html+="<IMG height='1' src='"+this.imgPath+"transparente.gif' width="+this.anchos[j+1]+"><br>";}
//				html+=datoij+'</TD>';
//				if (this.tooltips && this.caracteres!=null && datoij.length<this.datos.ij(i,j).length) {html+="<A ID="+this.ids[k]+"HREF='javascript:void(null)' onmouseover='tooltip(event, \""+this.datos.ij(i,j)+"\")' onmouseout='tooltip()' id='T1C'>"+datoij+"</A>";}
				if (this.tooltips && this.caracteres!=null && cambio) 
					{html+="<A ID="+id2+"HREF='javascript:void(null)' onmouseover='tooltip(event, \""+this.datos.ij(i,j)+"\")' onmouseout='tooltip()' id='T1C'>"+datoij+"</A>";}
				else {html+=datoij+'</TD>';}
			}
			html+='</TR>';
		}
	}
	else {
		for(i=0;i<this.datos.longitud;i++) {
			html+='<TR>';
			for(j=0;j<this.anchos.length-1;j++) {
                                var datoij0,cambio=false;
                                k++; if (k==this.ids.length) {k=0;}
                                datoij=(this.datos.ij(i,j)==''?'&nbsp;':this.datos.ij(i,j).toString());
                                if (this.caracteres!=null) {
                                        datoij0=datoij.replace(/&nbsp;/g,String.fromCharCode(160));
                                        datoij=renglon(datoij0,this.caracteres[j+1]*1,this.caracteres[0]*1);
                                        if (datoij0!=datoij && (this.caracteres[0]*1)!=0) cambio=true;
                                }  
				html+='<TD WIDTH='+this.anchos[j+1]+' ID='+this.ids[k]+'>';
                                if (i==0) {html+="<IMG height='1' src='"+this.imgPath+"transparente.gif' width="+this.anchos[j+1]+"><br>";}
				if (this.tooltips && this.caracteres!=null && cambio) 
					{html+="<A ID="+this.ids[k]+"HREF='javascript:void(null)' onmouseover='tooltip(event, \""+this.datos.ij(i,j)+"\")' onmouseout='tooltip()' id='T1C'>"+datoij+"</A>";}
                                else {html+=datoij+'</TD>';} 
			}
			html+='</TR>';
		}
	}
	html+='</TABLE>';
	scroll_to(this.nombre+'scroll', html);
	if (ie && this.multiseleccion!=0) { // refresca botones en IE que a veces no aparecen
		for(i=0;i<this.datos.longitud;i++) {
			if (document.images[this.nombre+'btn'+i]) {
				var ii=this.btnImgs.buscar(this.datos.ij(i,0),0);
				if (ii!=-1) {document.images[this.nombre+'btn'+i].src=DrdImgPath()+this.btnImgs.ij(ii,1);}
				else {document.images[this.nombre+'btn'+i].src=(this.seleccion.buscar(this.datos.ij(i,0))==-1?(this.bloqueados.buscar(this.datos.ij(i,0),0)==-1?this.imagenoff.src:this.blockImg.src):this.imagenon.src);}
			}
		}
	}
//	if (this.ocupado) {d3ocupado_ocultar(this.nombre);}
	if (this.ocupado || window.ocupado_lista) {d3ocupado_ocultar('d3general');}
}


Array.prototype.mete= function (obj)   {//Mucho mas rapido que ir sumando en una cadena
   this[this.length]=obj;
   }

function ListadoAdisplay_simplificado() {
	var i,j,k=-1;
	var datoij='';

	var script_tab="";
	var tabIndex=window[this.nombre+"_tabIndex"];
	if (tabIndex && tabIndex!="")
		script_tab+=" tabIndex='"+tabIndex+"' ";
   var ontab=window[this.nombre+"_onshtab"];
   var onshtab=window[this.nombre+"_onshtab"];
	var html=['<TABLE BORDER=0 CELLPADDING=0 CELLSPACING=0 WIDTH='+this.anchos[0]+'>'];
	if (this.multiseleccion!=0) { //SI HAY MULTISELECCION
      for(i=0,longit=this.datos.longitud;i<longit;i++) { //Por cada fila
         //Trato la primera columna
			var script_tab_2="";
			if (this.datos.longitud==1)	{ //Si es el primero y a la vez es el último ...
				if (ontab || onshtab)	{
					script_tab_2+=" onKeyDown='";
					if (ontab)
						script_tab_2+="fontab_"+this.nombre+"(event);";
					if (onshtab)
						script_tab_2+="fonshtab_"+this.nombre+"(event);";
					script_tab_2+="' ";
					}
				}
			else if (i==0)	{ //Si es primera fila ...
				if (onshtab)
					script_tab_2+=" onKeyDown='fonshtab_"+this.nombre+"(event);' ";
				}
			else if (i+1==this.datos.longitud)	{ //Si es el último ...
				if (ontab)
					script_tab_2+=" onKeyDown='fontab_"+this.nombre+"(event);' ";
				}
			html.mete('<TR>');
			html.mete("<TD ID="+this.ids[((k+1)==this.ids.length?0:k+1)]+">");
         if (this.dblClick) 
   			html.mete("<IMG style=cursor:hand "+script_tab+script_tab_2+" NAME='"+this.nombre+"btn"+i+"' onDblClick='javascript:"+this.nombre+".chk(\""+this.datos.ij(i,0)+"\");' onclick='return ListadoAShift(event)' SRC='")
         else
            html.mete("<IMG style=cursor:hand "+script_tab+script_tab_2+" NAME='"+this.nombre+"btn"+i+"' onclick='javascript:"+this.nombre+".chk(\""+this.datos.ij(i,0)+"\");return ListadoAShift(event)' SRC='")
			var ii=this.btnImgs.buscar(this.datos.ij(i,0),0);
			if (ii!=-1) {html.mete(DrdImgPath()+this.btnImgs.ij(ii,1));}
			else if (this.bloqueados.buscar(this.datos.ij(i,0),0)!=-1) {html.mete(this.blockImg.src);}
			else {if (this.seleccion.buscar(this.datos.ij(i,0))==-1) {html.mete(this.imagenoff.src);} else {html.mete(this.imagenon.src);}}
			html.mete("'>");
         if (i==0)
            html.mete("<BR><div style=height:1;width:"+this.anchos[1]+"><x/></div>");//Como la img transp
			html.mete("</TR>");

         //Trato resto de columnas
			for(j=1;j<this.anchos.length-1;j++) {//Por cada columna salvo la primera ...
				var datoij0,cambio=false;
				k++; if (k==this.ids.length) {k=0;}
				datoij=(this.datos.ij(i,j)==''?'&nbsp;':this.datos.ij(i,j).toString());
				if (this.caracteres!=null) {
					datoij0=datoij.replace(/&nbsp;/g,String.fromCharCode(160));
					datoij=renglon(datoij0,this.caracteres[j]*1,this.caracteres[0]*1);
					if (datoij0!=datoij && (this.caracteres[0]*1)!=0) cambio=true;
				}
				var id2=null;
				if (this.estilosCeldas!=null) {id2=eval(this.estilosCeldas);} // estilosCeldas="mifuncion(i,j)"
				if (id2==null) {id2=this.ids[k];}
				html.mete('<TD ID='+id2+'>')
				if(this.tooltips && this.caracteres!=null && cambio) 
					{html.mete("<A ID="+id2+"HREF='javascript:void(null)' onmouseover='tooltip(event, \""+this.datos.ij(i,j)+"\")' onmouseout='tooltip()' id='T1C'>"+datoij+"</A>");}
				else {html.mete(datoij);}
            if (i==0)
               html.mete("<BR><div style=height:1;width:"+this.anchos[j+1]+"><x/></div>");
            html.mete("</TD>")
			}
			html.mete('</TR>');
		}
	}
	else { //SI NO HAY MULTISELECCION
		for(i=0,longit=this.datos.longitud;i<longit;i++) {
			html.mete('<TR>');
			for(j=0;j<this.anchos.length-1;j++) {
                                var datoij0,cambio=false;
                                k++; if (k==this.ids.length) {k=0;}
                                datoij=(this.datos.ij(i,j)==''?'&nbsp;':this.datos.ij(i,j).toString());
                                if (this.caracteres!=null) {
                                        datoij0=datoij.replace(/&nbsp;/g,String.fromCharCode(160));
                                        datoij=renglon(datoij0,this.caracteres[j+1]*1,this.caracteres[0]*1);
                                        if (datoij0!=datoij && (this.caracteres[0]*1)!=0) cambio=true;
                                }  
				html.mete('<TD WIDTH='+this.anchos[j+1]+' ID='+this.ids[k]+'>');
                                if (i==0) {html.mete("<IMG height='1' src='"+this.imgPath+"transparente.gif' width="+this.anchos[j+1]+"><br>");}
				if (this.tooltips && this.caracteres!=null && cambio) 
					{html.mete("<A ID="+this.ids[k]+"HREF='javascript:void(null)' onmouseover='tooltip(event, \""+this.datos.ij(i,j)+"\")' onmouseout='tooltip()' id='T1C'>"+datoij+"</A>");}
                                else {html.mete(datoij+'</TD>');}
			}
			html.mete('</TR>');
		}
	}
	html.mete('</TABLE>');
	scroll_to(this.nombre+'scroll', html.join(''));
   /*
	if (ie && this.multiseleccion!=0) { // refresca botones en IE que a veces no aparecen
      ... que pongan cache correctamente y con la precarga debería funcionar, si no, mejorar la precarga (como los otros)
      esto tardaba mucho
   	}
   */
	//if (this.ocupado || window.ocupado_lista) {d3ocupado_ocultar('d3general');}
}


function ListadoAon(codigo) {
	if (this.bloqueados.buscar(codigo,0)!=-1) {return false;}
	if (this.multiseleccion==0) {return false;}
	if (this.seleccion.buscar(codigo)!=-1) {return true;}
	if (this.multiseleccion>1 && this.seleccion.longitud>=this.multiseleccion) {alert('El máximo número de entradas seleccionables es '+this.multiseleccion+'.');return false;}
	var i=this.datos.buscar(codigo,0);
	if (i==-1) {alert(this.nombre+': el código ('+codigo+') no se encuentra en el listado.');return false;}
	if (this.seleccion.longitud!=0 && this.multiseleccion==1) {this.offN();}
	this.seleccion.agregar(codigo);
	if (ns) {
		var nsdoc=eval(this.nsdoc+'.'+this.nombre+'capa.document.'+this.nombre+'scrollDiv.document.'+this.nombre+'scrollDivtv.document.'+this.nombre+'scroll.document');
		nsdoc.images[this.nombre+'btn'+i].src=this.imagenon.src;
	}
	else {if (document.images[this.nombre+'btn'+i]) document.images[this.nombre+'btn'+i].src=this.imagenon.src;}
	var ii=this.btnImgs.buscar(codigo,0); if (ii!=-1) {this.btnImgs.eliminar(ii);}
	return true;
}

function ListadoAoff(codigo) {
	if (this.bloqueados.buscar(codigo,0)!=-1) {return false;}
	if (this.multiseleccion==0) {return false;}
	var j=this.seleccion.buscar(codigo);
	if (j==-1) {return true;}
	var i=this.datos.buscar(codigo,0);
	if (i==-1) {alert(this.nombre+': el código ('+codigo+') no se encuentra en el listado.');return false;}
	this.seleccion.eliminar(j);
	if (ns) {
		var nsdoc=eval(this.nsdoc+'.'+this.nombre+'capa.document.'+this.nombre+'scrollDiv.document.'+this.nombre+'scrollDivtv.document.'+this.nombre+'scroll.document');
		nsdoc.images[this.nombre+'btn'+i].src=this.imagenoff.src;
	}
	else {if (document.images[this.nombre+'btn'+i]) document.images[this.nombre+'btn'+i].src=this.imagenoff.src;}
	var ii=this.btnImgs.buscar(codigo,0); if (ii!=-1) {this.btnImgs.eliminar(ii);}
	return true;
}

function ListadoAchk(codigo) {
	if (this.multiseleccion==0) {return false;}
	this.ultimo_pulsado=codigo;
	if (this.accion!=null && !eval(this.accion)) {return false;}
	if (this.seleccion.buscar(codigo)!=-1) {return this.off(codigo);}
	else {return this.on(codigo);}
}

function ListadoAgetSelect() {
   return this.seleccion.unir(this.separador);
   }

function estaEnElArrayUnidimensional(elarray,elelemento) {
   var encontrado=false;
   for (var f=0;f<elarray.length && !encontrado;f++)  
      if (elarray[f]==elelemento)
         encontrado=true;
   return encontrado;
   }

function ListadoAgetSeleccionOrdenada() {
   //Se necesita que sean retornados en el orden en que están en la lista
   var losSelecc=this.seleccion.bd;
   var losDat=this.datos.bd
   var resulFinal=[]
   for (var f=0;f<losDat.length;f++)   {
      var cod=losDat[f][0];
      if (estaEnElArrayUnidimensional(losSelecc,cod))
         resulFinal[resulFinal.length]=cod;
      }
   return resulFinal
   }

function ListadoAonN() {if (this.multiseleccion!=-1) {return;} else {for(var i=0;i<this.datos.longitud;i++) {this.on(this.datos.ij(i,0));}}}
function ListadoAoffN() {for(var i=0;i<this.datos.longitud;i++) {this.off(this.datos.ij(i,0));}}

function ListadoAischk(codigo) {return (this.seleccion.buscar(codigo)==-1?false:true);}

function ListadoAscrollTo(codigo) {
	var i=this.datos.buscar(codigo,0);
	if (i==-1) return;
	if (document.images[this.nombre+'btn'+i]) {
		var y=document.images[this.nombre+'btn'+i].offsetParent.offsetTop;
	        var T=eval(this.nombre+'scroll.top');
		scroll_Y(this.nombre+'scroll',-y-T);		
	}
}

function ListadoAsetImgOff(imagenoff) {this.imagenoff.src=DrdImgPath()+imagenoff;}

function ListadoAsetBotonImg(codigo,img) {
	if (this.multiseleccion!=0) {
		var i=this.datos.buscar(codigo,0);
		if (i==-1) {alert(this.nombre+': el código ('+codigo+') no se encuentra en el listado.');return false;}
		if (ns) {
			var nsdoc=eval(this.nsdoc+'.'+this.nombre+'capa.document.'+this.nombre+'scrollDiv.document.'+this.nombre+'scrollDivtv.document.'+this.nombre+'scroll.document');
			nsdoc.images[this.nombre+'btn'+i].src=DrdImgPath()+img;
		}
		else {if (document.images[this.nombre+'btn'+i]) document.images[this.nombre+'btn'+i].src=DrdImgPath()+img;}
		var j=this.btnImgs.buscar(codigo,0);
		if (j==-1) {j=this.btnImgs.longitud;this.btnImgs.agregar(['','']);}
		this.btnImgs.ij2([codigo,img],j);
	}
}


//Cacheo (japleon)
function tengoDatosClienteCache(varNomb){
   return (eval(this.rutaClienteCache+".tengoListado("+this.rutaClienteCache+"."+varNomb+",'"+varNomb+"')"));
   }
function guardarDatosEnClienteCache(datos,varNomb){
   eval(this.rutaClienteCache+".almacenaListado("+this.rutaClienteCache+"."+varNomb+",datos,'"+varNomb+"')");
   }
function recuperarDatosClienteCache(varNomb){ 
   if(varNomb)
      datos=eval(this.rutaClienteCache+".recuperaListado("+this.rutaClienteCache+"."+varNomb+",'"+varNomb+"')")
   else
      datos=null;
   return datos;
   }

function renglon(cadena,n,filas) {
	if (n==0 || cadena==null) {return cadena;}
	var i=0,j=0,n_filas=0,cadena2='',palabras=false;
	if (n<0) {n=-n;palabras=true;cadena=cadena.replace(/\s+/g,' ');}
	while(i<cadena.length) {
		if (cadena2!='') {cadena2+='<BR>';}
		if (palabras==false) {cadena2+=cadena.substr(i,n);i+=n;}
		else { // trunca sin cortar palabras
			j=i+n;
			if (j>=cadena.length) {cadena2+=cadena.substr(i);i=cadena.length;}
			else if(cadena.charAt(j)==' ') {cadena2+=cadena.substr(i,n);i=j+1;}
			else {
				for(j--;j>=i;j--) {if (cadena.charAt(j)==' ') {break;}}
				if (j<i) {cadena2+=cadena.substr(i,n);i+=n;}
				else {cadena2+=cadena.substring(i,j);i=j+1;}
			}
		}
		n_filas++;
		if (n_filas==filas) break;
	}
	if(i<cadena.length) {cadena2=cadena2.substr(0,cadena2.length-3)+'...';}
	return cadena2;
}