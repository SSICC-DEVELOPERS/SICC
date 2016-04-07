/********************************** 
	$Id: d3listafila.js,v 1.1 2009/12/03 19:03:47 pecbazalar Exp $
	Funciones javascript de la LISTA tipo="fila"
**********************************/

function scrollToListaFila(nombre,primera_fila) {	
	var alto_fila=eval(nombre+'.entraday');
	var T=eval(nombre+'Scroll.top');
	scroll_Y(nombre+'Scroll',-alto_fila*(primera_fila-1)-T);
}

function scroll_Y(nombre,inc) {
	var obj=eval(nombre);
	obj.activoy=1;
	scrolly(nombre,inc);
	obj.activoy=0;
}

// Gestiona entradas de una Lista
//'+',tipo,posicion,requerido. Inserta una entrada del tipo(>=0) en la posición. Si posicion==0=>añade al final. Si requerido==true valida no nulo.Devuelve true/false
// '-',array : Elimina entradas del array. Si array==[0], elimina las seleccionadas.
//'0',[array]: carga inicial sólo de las entradas(>=1) del array ([0]: carga todas)
// 'V?',i,j: devuelve campo j de la entrada i(>=1) de los campos visibles
// 'H?',i,j: devuelve campo j de la entrada i(>=1) de los campos ocultos (van al formulario)
// '>V',i,j,valor: establece valor en campo j de la entrada i(>=1) de los campos visibles
// '>H',i,j,valor: establece valor en campo j de la entrada i(>=1) de los campos ocultos (van al formulario)
// 'F','*'/'': actualiza en campos ocultos las seleccionadas('*'), des-seleccionadas('') o toda la lista('F' sin más argumentos). Siempre y cuando el tipo no sea nulo en campos.
//'T?',i: nº del tipo de la entrada i
//'>?',i: true/false si i(>=1) seleccionado
// '*?': devuelve longitud de la lista
// '#?': devuelve nº de entradas seleccionadas
// '#': devuelve array con el índice de las entradas seleccionadas (empieza en 1)
// '?': devuelve la última entrada chequeada (seleccionada o deseleccionada)
// '>!',i,''/'*': (des)selecciona entrada i. Si i==0, (des)selecciona todas.
// '>',i: conmuta la selección de una entrada
// ' ': borra toda la lista (no comprueba si se cumple la condición del mínimo nº de entradas de la lista)
// '\',j: ordena la lista por el campo j
// '@': repinta la lista
//TO-DO:// '*', array1,array2: Carga array1(col),array2(campos)
function lista(nombre, op, p1, p2,p3)
{
	nom=eval(nombre);
	V=nom.V;	// Vector campos visibles
	H=nom.H;	// Vector campos ocultos
	col=nom.col;	// Array col
	campos=nom.campos;	// Array campos
	switch(op) {
		case '#':	S=new Array();
						var contador=0;
						for(var i=0;i<V.longitud;i++) {
							if (V.ij(i,0)=='*') {S[contador++]=i+1;}
						}
						return S;
						break;
		case 'V?': return V.ij(p1-1,p2); break;
		case 'H?': return H.ij(p1-1,p2); break;
		case '>V': V.ij2(p3,p1-1,p2); break;
		case '>H': H.ij2(p3,p1-1,p2); break;
		case '*?': return V.longitud; break;
		case '?': return nom.ultima; break;
		case 'T?': return H.ij(p1-1,0); break;
		case '>?': if (V.ij(p1-1,0)=='*') {return true;} else {return false;}	break;
		case '#?':	var contador=0;
						for(var i=0;i<V.longitud;i++) {if (V.ij(i,0)=='*') {contador++;}}
						return contador; break;
		case ' ':		V.borrar(); H.borrar();
						lista(nombre,'F');
						break;
		case '+':	if (V.longitud==nom.max) {muestraMsgError(DrdMsgCore(181)+nom.max); return false;}
						V2=new Array();H2=new Array();
						V2[0]=col[p1][0];
						for(var j=1;j<col[p1].length;j++) {
							V2[j]=eval(col[p1][j]);
							if (p3 && V2[j]=='') {muestraMsgError(DrdMsgCore(182)); return false;}
						}
						H2[0]=campos[p1][0];
						for(var i=1;i<campos[p1].length;i++) {
							H2[i]=eval(campos[p1][i]);
							if (p3 && H2[j]=='') {muestraMsgError(DrdMsgCore(182)); return false;}
						}
						if (p2==0 || p2>V.longitud) {V.agregar(V2);H.agregar(H2);}
						else {V.insertar(p2-1,V2);H.insertar(p2-1,H2);}
						lista(nombre,'F'); return true;
						break;
		case '-':		var l=V.longitud;
						if (p1[0]==0) {
							if ((V.longitud-lista(nombre,'#?'))<nom.min) {muestraMsgError(DrdMsgCore(183)+nom.min); return false;}
							for(var i=0;i<V.longitud;i++) {if (V.ij(i,0)=='*') {V.eliminar(i);H.eliminar(i);i--;}}
						}
						else {
							if ((V.longitud-p1.length)<nom.min) {muestraMsgError(DrdMsgCore(183)+nom.min); return false;}
							p1.sort(comparanumeros);
							for(var j=0;j<p1.length;j++) {
								for(var i=V.longitud-1;i>=0;i--) {
									if (i==(p1[j]-1)) {V.eliminar(i);H.eliminar(i);break;}
								}
							}
						}
						if (V.longitud==l) {muestraMsgError(DrdMsgCore(184)); return false;}
						lista(nombre,'F');return true;
						break;
		case '>f':	
		case '>':	if (V.ij(p1-1,0)=='*') {p2='';} else {p2='*';}
		case '>!':	var ultima2=nom.ultima;nom.ultima=p1;
						if (op!='>f') {if (!eval(nom.accion)) {nom.ultima=ultima2;return false;}}
						nom.ultima=ultima2;
						if(p1==0) {
							if (lista(nombre,'#?')==1 && !nom.multiple && p2=='*') {lista(nombre,'>F',lista(nombre,'#').toString());}
							for(var i=0;i<V.longitud;i++) {
								V.ij2(p2,i,0);
								var fondo=''; if (V.ij(i,0)=='*') {fondo=nom.chkcolor;} else {fondo=nom.bgcolor;}
								if (ns) {var nsdoc=eval(nombre+'Scroll.nsdoc');nsdoc+='.'+nombre+'Scroll.document.layers[\''+nombre+(i)+'\']';eval(nsdoc+'.bgColor="'+fondo+'"');}
								else {document.all[nombre+(i)].style.background=fondo;}
								nom.ultima=i;
							}
						lista(nombre,'F');return true;
						}
						else {
							if (V.ij(p1-1,0)==p2) {nom.ultima=p1;return true;}
							if (lista(nombre,'#?')==1 && !nom.multiple && p2=='*') {lista(nombre,'>f',lista(nombre,'#').toString());}
							V.ij2(p2,p1-1,0);
							var fondo=''; if (V.ij(p1-1,0)=='*') {fondo=nom.chkcolor;} else {fondo=nom.bgcolor;}
							if (ns) {var nsdoc=eval(nombre+'Scroll.nsdoc');nsdoc+='.'+nombre+'Scroll.document.layers[\''+nombre+(p1-1)+'\']';eval(nsdoc+'.bgColor="'+fondo+'"');}
							else {
								if (document.all[nombre+(p1-1)]) {document.all[nombre+(p1-1)].style.background=fondo;}
							}
							nom.ultima=p1;
							lista(nombre,'F'); return true;
						}
						break;
		case '0':	V.borrar(); H.borrar();
						col0=nom.col0;	// Array col iniciales
						campos0=nom.campos0;	// Array campos iniciales
						for(var i=0;i<col0.length;i++) {
							if (p1[0]!=0) {
								for(var j=0;j<p1.length;j++) {if (i==(p1[j]-1)) break;	}
								if (j==p1.length) continue;
							}
							V2=new Array();
							for(var j=0;j<col0[i].length;j++) {V2[j]=eval(col0[i][j]);}
							V.agregar(V2);
							H2=new Array();H2[0]=campos0[i][0];
							for(var j=1;j<campos0[i].length;j++) {H2[j]=eval(campos0[i][j]);}
							H.agregar(H2);
						}
						lista(nombre,'F');
						break;
		case 'F':	// actualiza los campos ocultos
						var criterios=new Array();
						H3=new Vector();
						if (p1 || p1=='') {
							for(var i=0;i<V.longitud;i++) {
								if (V.ij(i,0)==p1) {H3.agregar(H.ij(i));}
							}
						}
						else {H3.cargar(H.filtrar([-1],'*'));}

						for(var i=0;i<nom.nonulos.length;i++) {
							criterios[i]=['|',0,'==',nom.nonulos[i]];
						}
						H2=new Vector('H2');H2.cargar(H3.filtrar([-1],criterios));
						for(var i=1;i<campos[nom.nonulos[0]].length;i++) {
							fondo=eval('document.'+nom.formulario+'.'+nombre+'H'+i);
//							fondo.value=H2.unir(nom.separador,i); La línea de debajo es imposición de los PL/SQL
							fondo.value=H2.unir(nom.separador,i)+nom.separador;
						}
						return;		
		case '@':	if (nom.ocupado) {d3ocupado_ver(nombre,eval('d3ocupado'+nombre));}
						setTimeout("lista('"+nombre+"','@2')",1);
						break;
		case '@2':	// pinta la lista
						var Lbody='';
						var Lscript='';
						nom=eval(nombre);
						V=nom.V;	H=nom.H;	
						campos=nom.campos;	
						var fondo='';
						nom.estilosFilas=null;
						if (nom.funcEstilosFilas) {nom.estilosFilas=eval(nom.funcEstilosFilas);}
						for(var i=0;i<V.longitud;i++) {
							var e2=nom.entrada[H.ij(i,0)];
							if (nom.estilosFilas!=null) {e2=nom.estilosFilas[i];}
							var busca=/\$[^\$]+\$/g;
							var campos2=e2.match(busca);
							if (campos2!=null) {
								var indice, sust;
								for(var j=0;j<campos2.length;j++) {
									indice=campos2[j].substring(1,campos2[j].length-1);
									if (indice=='i') {sust=i+1;}
									else {
//										sust=V.ij(i,indice).replace(/ /g,"&nbsp;");
										sust=V.ij(i,indice);
										if (nom.caracteres) {	
											var num_car=(nom.caracteres.length==campos2.length?j:j-1);
											sust=renglon(sust,nom.caracteres[num_car],1);
										}
										sust=sust.replace(/ /g,"&nbsp;");
									}
									if (ns) {e2=e2.replace(/\$[^\$]+\$/,sust);}
									else {e2=e2.replace(campos2[j],sust);}
								}
							}
							if (ns) {
								var Lstyle='height='+nom.entraday+' width='+nom.entradax;
								if (V.ij(i,0)=='*') {fondo=nom.chkcolor;} else {fondo=nom.bgcolor;}
								Lstyle+=' bgcolor="'+fondo+'"';
								Lstyle+=' top='+i*nom.entraday+'';
								Lbody+='<layer id='+nombre+i+' '+Lstyle+' style="border:solid black 10 px">'+e2+'</layer>';
							}
							else {
								var Lstyle='"position:absolute;height:'+nom.entraday+';width:'+nom.entradax+';clip:rect(0,'+nom.entradax+','+nom.entraday+',0);';
								if (V.ij(i,0)=='*') {fondo=nom.chkcolor;} else {fondo=nom.bgcolor;}
								Lstyle+='background-color:'+fondo+';';
								Lstyle+='top:'+i*nom.entraday+';"';
								Lbody+='<div id='+nombre+i+' STYLE='+Lstyle+'>'+e2+'</div>';
							}							

							if (ns) {
								var nsdoc=eval(nombre+'Scroll.nsdoc');
								nsdoc+='.'+nombre+'Scroll.document.layers[\''+nombre+i+'\']';
								Lscript+=nsdoc+'.onmouseover=listaon;';
								Lscript+=nsdoc+'.onmouseout=listaoff;';
								Lscript+=nsdoc+'.onmousedown=listachk;';
								Lscript+=nsdoc+'.i='+i+';';
								Lscript+=nsdoc+'.lista=\''+nombre+'\';';
								Lscript+=nsdoc+'.captureEvents(Event.MOUSEDOWN);';
							}
							else {
								Lscript+='document.all[\''+nombre+i+'\'].onmouseover=listaon;';
								Lscript+='document.all[\''+nombre+i+'\'].onmouseout=listaoff;';
								Lscript+='document.all[\''+nombre+i+'\'].onmousedown=listachk;';
								Lscript+='document.all[\''+nombre+i+'\'].i='+i+';';
								Lscript+='document.all[\''+nombre+i+'\'].lista=\''+nombre+'\';';
							}
						}
						if (V.longitud!=0) {Lbody+='<TABLE BORDER=0 CELLSPACING=0 CELLPADDING=0 WIDTH="'+nom.entradax+'" HEIGHT="'+i*nom.entraday+'"><TR><TD>&nbsp;</TABLE>';}
						scroll_to(nombre+'Scroll',Lbody);
						eval(Lscript);
						if (nom.ocupado) {d3ocupado_ocultar(nombre);}
						break;
		default: muestraMsgError(DrdMsgCore(185));break;
	}
}

function comparanumeros(a,b) {return b-a;}

function listaon(e) {
	con=eval(this.lista);
	if (con.V.ij(this.i,0)=='*') {return;}
	if (ns) {this.bgColor=con.oncolor;	} else {this.style.background=con.oncolor;}
}

function listaoff(e) {
	con=eval(this.lista);
	if (con.V.ij(this.i,0)=='*') {return;}
	if (ns) {this.bgColor=con.bgcolor;	} else {this.style.background=con.bgcolor;}
}

function listachk(e) {lista(this.lista,'>',(this.i+1));}

// Limita cadenas demasiado largas (para que quepan en columnas, ...)
// cadena=texto a limitar
// n=nº de caracteres por fila (mínimo 3). n incluye los '...' en caso de que los hubiera. n=0 no actúa sobre cadena.
// filas=nº de filas máximo. Si la cadena ocupa más filas, se trunca con '...'.
// Si filas=0, muestra tantas filas como sea necesario
// Si n<0, trunca por espacios en blanco, sin cortar palabras. Elimina múltiples espacios consecutivos.
// Devuelve la cadena modificada
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
