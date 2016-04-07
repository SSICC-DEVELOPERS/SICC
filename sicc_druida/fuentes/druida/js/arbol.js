/********************************** 
	arbol.js
	Funciones JavaScript asociadas a la clase Arbol (Arbol.java)
	24/04/2001
	DRUIDA 1.1
**********************************/
// Gestiona entradas del árbol
// '+','n','nº imagen','codigo','texto','P/H','onclick' : Inserta la entrada de nivel n.
// '-',n : Elimina la entrada de nivel n. Si dicha entrada es un padre, elimina TODO lo que desciende de él. Si n=='.', elimina todas las entradas seleccionadas.
// '0',[array]: carga inicial de las entradas ['n1.n2.n3','n1.n2.n3'] del array (Sin [array], carga todas)
// 'F','*'/'': actualiza en campos ocultos las seleccionadas('*'), des-seleccionadas('') o toda la lista('F' sin más argumentos). Siempre y cuando el tipo no sea nulo en campos.
// 'T?',n: devuelve el texto de la entrada de nivel n
// 'I?',n: devuelve el nº de imagen de la entrada de nivel n
// 'C?',n: devuelve el código de la entrada de nivel n
// 't?',n: devuelve el tipo('P'/'H') de la entrada de nivel n
// 'T>',n,valor: establece el texto de la entrada de nivel n
// 'I>',n,valor: establece el nº de imagen de la entrada de nivel n
// 'C>',n,valor: establece el código de la entrada de nivel n
// 't>',n,valor: establece el tipo('P'/'H') de la entrada de nivel n
// '>?',n: devuelve '1'/'0' si la entrada de nivel n es hijo=seleccionado/no o padre=expandido/colapsado.
// '*?': devuelve longitud del árbol (total entradas padre+hijos)
// '#?': devuelve nº de entradas hijo seleccionadas
// '#': devuelve array con los niveles de las entradas hijo seleccionadas
// '?': devuelve la última entrada chequeada (seleccionada/deseleccionada o expandida/colapsada)
// '>!',n,'1'/'0': (des)selecciona entrada de nivel n. Si n=='.' (des)selecciona todas.
// 'f>!',n,'1'/'0': (des)selecciona entrada de nivel n. Si n=='.' (des)selecciona todas. A diferencia de la anterior, EJECUTA la función asociada a la entrada(si existe). Si dentro de dicha función existe un 'f>!', se produce una recursividad infinita.
// '>',n: conmuta la selección('H')/expansión('P) de una entrada de nivel n.
// ' ': borra todo el árbol
// '@': repinta el árbol
//TO-DO:// '*', array1,array2: Carga array1(col),array2(campos).- Multiexpansión

function arbol(nombre,op,p1,p2,p3,p4,p5,p6)
{
	var n=eval(nombre);
	switch(op) {
		case '#?':	var contador=0;
						for(var i=0;i<n.E.longitud;i++) {if (n.E.ij(i,4)=='H' && n.E.ij(i,7)=='1') {contador++;}}
						return contador; break;
		case '#':	S=new Array();
						var contador=0;
						for(var i=0;i<n.E.longitud;i++) {
							if (n.E.ij(i,4)=='H' && n.E.ij(i,7)=='1') {S[contador++]=n.E.ij(i,0);}
						}
						return S;
						break;
		case '*?':	return n.E.longitud; break;
		case '?':	return n.ultima; break;
		case 'I?': return n.E.ij(arbol(nombre,'N?',p1),1); break;
		case 'C?': return n.E.ij(arbol(nombre,'N?',p1),2); break;
		case 't?': return n.E.ij(arbol(nombre,'N?',p1),4); break;
		case 'T?': return n.E.ij(arbol(nombre,'N?',p1),3); break;
		case 'I>': n.E.ij2(p2,arbol(nombre,'N?',p1),1); break;
		case 'C>': n.E.ij2(p2,arbol(nombre,'N?',p1),2); break;
		case 't>': n.E.ij2(p2,arbol(nombre,'N?',p1),4); break;
		case 'T>': n.E.ij2(p2,arbol(nombre,'N?',p1),3); break;
		case '>?': return n.E.ij(arbol(nombre,'N?',p1),6); break;
		case ' ':		n.E.borrar();
						break;
		case '+':	var visible=0,padre='';
						for(var j=0;j<n.E.longitud;j++) {
								if (p1==n.E.ij(j,0)) {alert("Árbol '"+nombre+"': entrada ("+n.E.ij(j,0)+") con nivel duplicado.");}
								if (p1>n.E.ij(j,0)) {continue;}
								if (p1.lastIndexOf('.')==-1) {visible='1';}
								else {
									padre=p1.substring(0,p1.lastIndexOf('.'));
									visible=n.E.ij(arbol(nombre,'N?',padre),7);
								}
								n.E.insertar(j,[p1,p2,p3,p4,p5,p6,visible,'0']);
								break;
							}
							if (j==n.E.longitud) {
								if (p1.lastIndexOf('.')==-1) {visible='1';}
								else {
									padre=p1.substring(0,p1.lastIndexOf('.'));
									visible=n.E.ij(arbol(nombre,'N?',padre),7);
								}
								n.E.agregar([p1,p2,p3,p4,p5,p6,visible,'0']);
							}
						n.maxwidth=(p4.length>n.maxwidth?p4.length:n.maxwidth);
						break;
		case '-':		if (p1=='.') {
							for(var i=n.E.longitud-1;i>=0;i--) {
								if (n.E.ij(i,4)=='P') continue;
								if (n.E.ij(i,7)=='1') {n.E.eliminar(i);}
							}
							break;
						}
						var p3=arbol(nombre,'N?',p1); if (p3==-1) {alert("Árbol '"+nombre+"': intento de eliminación de un nivel ("+p1+") inexistente.");return false;}
						if (n.E.ij(p3,4)=='H') {n.E.eliminar(p3);}
						else {
							p3=p1.length;
							for(var i=n.E.longitud-1;i>=0;i--) {
								if (n.E.ij(i,0).substr(0,p3)==p1) {n.E.eliminar(i);}
							}							
						}
						break;
		case '0':	var maxwidth=0;
						n.E.borrar();
						var seleccionado,i,j,flag=false;
						S0=new Vector();S0.cargar(n.seleccion0);
						for(i=0;i<n.entradas.length;i++) {
							if (p1) {
								for(j=0;j<p1.length;j++) {if (n.entradas[i][0]==p1[j]) break;}
								if (j==p1.length) continue;
							}
							seleccionado='0';
							for(j=0;j<S0.longitud;j++) {
								if (S0.ij(j)==n.entradas[i][0]) {
									if (n.entradas[i][4]=='H') {
										if (n.multiseleccion==false && flag) {alert("Árbol '"+nombre+"': no se admite multiselección en la carga inicial.");return false;}
										flag=true;
										n.ultima=n.entradas[i][0];
									}									
									seleccionado='1';
									S0.eliminar(j);
									break;
								}
							}
/*							for(j=0;j<n.E.longitud;j++) {
								if (n.entradas[i][0]==n.E.ij(j,0)) {alert("Árbol '"+nombre+"': entrada ("+n.E.ij(j,0)+") con nivel duplicado.");}
								if (n.entradas[i][0]>n.E.ij(j,0)) {continue;}
								n.E.insertar(j,[n.entradas[i][0],n.entradas[i][1],n.entradas[i][2],n.entradas[i][3],n.entradas[i][4],n.entradas[i][5],'0',seleccionado]);
								break;
							}
							if (j==n.E.longitud) {n.E.agregar([n.entradas[i][0],n.entradas[i][1],n.entradas[i][2],n.entradas[i][3],n.entradas[i][4],n.entradas[i][5],'0',seleccionado]);}
*/
							n.E.agregar([n.entradas[i][0],n.entradas[i][1],n.entradas[i][2],n.entradas[i][3],n.entradas[i][4],n.entradas[i][5],'0',seleccionado]);
							maxwidth=(n.entradas[i][3].length>maxwidth?n.entradas[i][3].length:maxwidth);
						}
						var nivel;
						for(var i=0;i<n.E.longitud;i++) {
							if (n.E.ij(i,0).indexOf(".")==-1) {n.E.ij2('1',i,6);}
							if (n.E.ij(i,7)=='0' || (n.selecvisible==false && n.E.ij(i,4)=='H')) {continue;}
							nivel=n.E.ij(i,0);
							while(1){
								for(var j=i;j>=0;j--) {
									if (n.E.ij(j,0)==nivel) {n.E.ij2('1',j,6);arbol(nombre,'&','1',nivel);break;}
								}
								if (nivel.lastIndexOf('.')==-1) {break;}
								nivel=nivel.substring(0,nivel.lastIndexOf('.'));
							}
						}
						n.maxwidth=maxwidth;
						break;
		case '&': // expandir/contraer padres (no selecciona hijos, pero des-selecciona si selecvisible)
						var lnivel=p2.length;
						var nivelp=p2; // nivel padre de p2
						if (p2.lastIndexOf('.')!=-1) {nivelp=p2.substring(0,p2.lastIndexOf('.'));}
						for(var i=0;i<n.E.longitud;i++) {
							if (n.E.ij(i,0).substr(0,lnivel)==p2) {
								if (n.E.ij(i,0)==p2) {
									if (n.E.ij(i,4)=='H') break;
									n.E.ij2(p1,i,7);
									continue;
								}
								if (p1=='0') { // Contrae
									n.E.ij2('0',i,6);
									if (n.E.ij(i,4)=='P' || n.selecvisible==true) {n.E.ij2('0',i,7);}
								}
								else {	// Expande
									if (n.E.ij(i,0).substr(lnivel+1).indexOf('.')==-1) {n.E.ij2('1',i,6);}
								}
							}
						}
						break;
	/*
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
*/
		case '@':	// pinta el árbol
						var nsdoc;
						if (ns) {
							nsdoc=eval(nombre+'Scroll.nsdoc');
							nsdoc=eval(nsdoc+'.layers["'+nombre+'Scroll"].document');
							nsdoc.open();
						}
						else {
							nsdoc=document.all[nombre+'Scroll'];
							nsdoc.innerHTML='';
						}
						var body='',j,fondo;
						var entrada=new Array();
						for(var i=0;i<n.E.longitud;i++) {
							entrada=n.E.ij(i);
							if (entrada[6]=='0') continue;
							if (entrada[4]=='H' && entrada[7]=='1') {fondo=n.oncolor;} else {fondo=n.bgcolor;}
							if (ns) {body+='<ILAYER BGCOLOR="'+fondo+'"';} else {body+='<TABLE BORDER=0 CELLPADDING=0 CELLSPACING=0><TR><TD NOWRAP><SPAN STYLE="background-color:'+fondo+';"';}
							body+=' ID='+nombre+i+'>';
							for(j=0;j<entrada[0].length;j++) {if (entrada[0].charAt(j)=='.') {body+='&nbsp;&nbsp;&nbsp;&nbsp;';}}
							if (n.imgs.length!=0 && entrada[1]!='') {body+='<IMG SRC="'+n.imgs[parseInt(entrada[1])]+'" BORDER=0>';}
							body+='<A';
							if (n.idoff!='') {body+=' ID='+n.idoff;}
							body+=' HREF="javascript:arbol(\''+nombre+'\',\'O\',\''+i+'\')"';
							body+=' onMouseOver="arbol(\''+nombre+'\',\'BG>\',\''+i+'\',1)" onMouseOut="arbol(\''+nombre+'\',\'BG>\',\''+i+'\',0)"';
							body+='>&nbsp;'+entrada[3]+'&nbsp</A>';
							if (ns) {body+='</ILAYER><BR>';} else {body+='</SPAN></TD></TR></TABLE>';}

							if (ns) {nsdoc.write(body);}
							else {nsdoc.insertAdjacentHTML('BeforeEnd',body);}
							body='';
						}
						if (ns) {nsdoc.close();} 
						eval(nombre+"Scroll_init()");
						if (eval(nombre+'Scroll.activoy!=-1')) {eval(nombre+'Scroll.activoy=1');scrolly(nombre+'Scroll',0);eval(nombre+'Scroll.activoy=0');}
						if (eval(nombre+'Scroll.activox!=-1')) {eval(nombre+'Scroll.activox=1');scrollx(nombre+'Scroll',0);eval(nombre+'Scroll.activox=0');}
//						arbol(nombre,'F');
						break;
		case 'O':
		case '>':
		case 'f>!': // chequea la función
		case '>!':	if (op=='>!' && p1=='.') {
							if (n.multiseleccion==false && p2=='1') {alert("Árbol '"+nombre+"': sin multiselección no se permite seleccionar todo."); break;}
							for(var i=0;i<n.E.longitud;i++) {
								if (n.E.ij(i,4)=='H') {
									if (p2=='1' && n.selecvisible==true && n.E.ij(i,6)=='0')  {continue;}
									arbol(nombre,'>!',n.E.ij(i,0),p2);
								}
							}
							break;
						}
						if (op!='O') {var p3=arbol(nombre,'N?',p1); if (p3==-1) {alert("Árbol '"+nombre+"': nivel ("+p1+") inexistente.");return false;} else {p1=p3;}}
						if (op!='>!') {if (n.E.ij(p1,7)=='1') {p2='0';} else {p2='1';}}
						n.ultima=n.E.ij(p1,0);
						if (n.E.ij(p1,5)!='' && (op=='f>!' || op=='O')) {if (!eval(n.E.ij(p1,5))) {break;}}
						if (n.E.ij(p1,4)=='H') {
							var fondo;
							if (p2=='0') {
								fondo=n.bgcolor;
								n.E.ij2('0',p1,7);
							}
							else {
								if (n.multiseleccion==false) {
									var unico=arbol(nombre,'#');
									if (unico.length!=0) {arbol(nombre,'>!',unico[0],'0');n.ultima=n.E.ij(p1,0);}
								}
								fondo=n.oncolor;
								n.E.ij2('1',p1,7);
							}
							if (n.E.ij(p1,6)=='0') break;
							if (ns) {
								nsdoc=eval(nombre+'Scroll.nsdoc');
								if (fondo=='') {eval(nsdoc+'.'+nombre+'Scroll.document.layers["'+nombre+p1+'"].bgColor=null');}
								else {eval(nsdoc+'.'+nombre+'Scroll.document.layers["'+nombre+p1+'"].bgColor="'+fondo+'"');}
							}
							else {document.all[nombre+p1].style.background=fondo;}
						}
						else {
							if (n.E.ij(p1,7)=='0') {arbol(nombre,'&','1',n.E.ij(p1,0));}
							else {arbol(nombre,'&','0',n.E.ij(p1,0));}
							if (op=='O') {arbol(nombre,'@');}
						}						
						break;
		case 'N?':	for(var i=0;i<n.E.longitud;i++) {if (n.E.ij(i,0)==p1) return i;}
						return -1;
						break;
		case 'BG>':
//						if (n.E.ij(p1,7)=='1' && n.E.ij(p1,4)=='H' && p2==0) {break;}
						if (p2==1) {p2=n.overcolor;}
						else {
							if (n.E.ij(p1,4)=='P') {p2=n.bgcolor;}
							else {
								if (n.E.ij(p1,7)=='1') {p2=n.oncolor;}
								else  {p2=n.bgcolor;}
							}
						}
						if (ns) {
								nsdoc=eval(nombre+'Scroll.nsdoc');
								if (p2=='') {eval(nsdoc+'.'+nombre+'Scroll.document.layers["'+nombre+p1+'"].bgColor=null');}
								else {eval(nsdoc+'.'+nombre+'Scroll.document.layers["'+nombre+p1+'"].bgColor="'+p2+'"');}}
						else {document.all[nombre+p1].style.background=p2;}		
						break;
		default: alert("Árbol '"+nombre+"': opción("+op+") no válida.");break;
	}
}

/*
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
*/