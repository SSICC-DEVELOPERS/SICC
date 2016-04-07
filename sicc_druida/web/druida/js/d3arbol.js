/********************************** 
	d3arbol.js
	Funciones JavaScript asociadas a la clase Arbol (Arbol.java)
	26/03/2002
	DRUIDA 1.1
**********************************/
// Gestiona entradas del árbol
// '+','n','nº imagen','codigo','texto','P/H','onclick' : Inserta la entrada de nivel n.
// '-',n : Elimina la entrada de nivel n. Si dicha entrada es un padre, elimina TODO lo que desciende de él. Si n=='.', elimina todas las entradas seleccionadas.
// '0',[array]: carga inicial de las entradas ['n1.n2.n3','n1.n2.n3'] del array (Sin [array], carga todas)
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

function arbol(nombre,op,p1,p2,p3,p4,p5,p6) {
	var n=eval(nombre);
	switch(op) {
		case '#?':	var contador=0;
						for(var i=0;i<n.E.longitud;i++) {if (n.E.ij(i,4)=='H' && n.E.ij(i,7)=='1') {contador++;}}
						return contador; break;
		case '#':	S=new Array();
						var contador=0;
						for(var i=0;i<n.E.longitud;i++) {
							if (n.E.ij(i,4)=='H' && n.E.ij(i,7)=='1') {
                        S[contador++]=n.E.ij(i,0);
                        }
                     else if (n.E.ij(i,4)=='P' && n.E.ij(i,8)=='1') { //Los padres marcan con el 8
                        S[contador++]=n.E.ij(i,0);
                        }  
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
		case '0':	var maxwidth=0;  //Carga inicial
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
							n.E.agregar([n.entradas[i][0],n.entradas[i][1],n.entradas[i][2],n.entradas[i][3],n.entradas[i][4],n.entradas[i][5],'0',seleccionado,'0']);
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
							if ((entrada[4]=='H' && entrada[7]=='1') || (entrada[4]=='P' && entrada[8]=='1')) {
                        fondo=n.oncolor;
                        }
                     else {
                        fondo=n.bgcolor;
                        }

                     var jsImg="";
                     var jsAhref="";
                     var js2clAhref="";
    
                     var elarbol=eval(nombre);
                     var haypadreselecc=elarbol.padreselecc
                     var haydblclick=elarbol.dblclick
    
                     if (!haypadreselecc)   {
                        jsAhref='arbol(\''+nombre+'\',\'O\',\''+i+'\')';
                        }
                     else  {
                        if(entrada[4]=='H')  {
                           jsAhref='arbol(\''+nombre+'\',\'O\',\''+i+'\')';
                           }
                        else  {
                           if (!haydblclick)
                              jsAhref='arbol(\''+nombre+'\',\'O\',\''+i+'\',\'\',\'\',true);';//Esto es lo que selecciona al padre
                           else  {
                              var msegdblclick=eval(nombre+".msegDobleClick");
                              if (!msegdblclick)
                                 msegdblclick=200;
                              jsAhref=nombre+".IDCLICK=setTimeout(\'arbol(\\'"+nombre+"\\',\\'O\\',\\'"+i+"\\',\\'\\',\\'\\',true);\',"+msegdblclick+");"
                              js2clAhref="DrArbolDblClickPadre(\'"+nombre+"\',\'O\',\'"+i+"\')";
                              }
                           jsImg='arbol(\''+nombre+'\',\'O\',\''+i+'\');';
                           }
                        }

							if (ns) {body+='<ILAYER BGCOLOR="'+fondo+'"';} else {body+='<TABLE BORDER=0 CELLPADDING=0 CELLSPACING=0 width="100%"><TR><TD NOWRAP><SPAN STYLE="background-color:'+fondo+';"';}
							body+=' ID='+nombre+i+'>';
							for(j=0;j<entrada[0].length;j++) {if (entrada[0].charAt(j)=='.') {body+='&nbsp;&nbsp;&nbsp;&nbsp;';}}

							if (n.imgs.length!=0 && entrada[1]!='') {
                        var numIco=parseInt(entrada[1]);
                        var elwidth=(n.anchos && n.anchos[numIco][0]!='')?" WIDTH=\""+n.anchos[numIco][0]+"\" ":""
                        var elheight=(n.anchos && n.anchos[numIco][1]!='')?" HEIGHT=\""+n.anchos[numIco][1]+"\" ":""
                        body+='<IMG '+elwidth+elheight+  (jsImg!=""? " onclick=\""+jsImg+"\" " :"")  +' SRC="'+n.imgs[numIco]+'" BORDER=0>';
                        }

							body+='<A';
							if (n.idoff!='') 
                        {body+=' ID='+n.idoff;}
							body+=' HREF="javascript:void(null)" onclick="'+jsAhref+'"';
                     if (js2clAhref!="")
                        body+=' ondblclick="'+js2clAhref+'" '
							body+=' onMouseOver="arbol(\''+nombre+'\',\'BG>\',\''+i+'\',1)" onMouseOut="arbol(\''+nombre+'\',\'BG>\',\''+i+'\',0)"';
							body+='>&nbsp;'

                     body+=entrada[3]+'&nbsp';
                     body+="</A>"
							if (ns) {body+='</ILAYER><BR>';} else {body+='</SPAN></TD></TR></TABLE>';}

							if (ns) {nsdoc.write(body);}
							else {nsdoc.insertAdjacentHTML('BeforeEnd',body);}
							body='';
						}
						if (ns) {nsdoc.close();} 
						eval(nombre+"Scroll_init()");
						if (eval(nombre+'Scroll.activoy!=-1')) {eval(nombre+'Scroll.activoy=1');scrolly(nombre+'Scroll',0);eval(nombre+'Scroll.activoy=0');}
						if (eval(nombre+'Scroll.activox!=-1')) {eval(nombre+'Scroll.activox=1');scrollx(nombre+'Scroll',0);eval(nombre+'Scroll.activox=0');}
						break;
		case 'O':
		case '>':
		case 'f>!': // chequea la función
		case '>!':	var soypadre=(n.E.ij(p1,4)=='P')?true:false;
                  if (op=='>!' && p1=='.') {
							if (n.multiseleccion==false && p2=='1') {alert("Árbol '"+nombre+"': sin multiselección no se permite seleccionar todo."); break;}
							for(var i=0;i<n.E.longitud;i++) {
								if (n.E.ij(i,4)=='H') {
									if (p2=='1' && n.selecvisible==true && n.E.ij(i,6)=='0')  {continue;}
									arbol(nombre,'>!',n.E.ij(i,0),p2);
								}
							}
							break;
						}

						if (op!='O') {
                     var p3=arbol(nombre,'N?',p1);
                     if (p3==-1) {
                        alert("Árbol '"+nombre+"': nivel ("+p1+") inexistente.");
                        return false;
                        }
                     else {
                        p1=p3;
                        }
                     }
						if (op!='>!') { //quiero seleccionar o deseleccionar
                     if ( (!soypadre && n.E.ij(p1,7)=='1') || (soypadre && n.E.ij(p1,8)=='1'))
                        {p2='0';}
                     else 
                        {p2='1';}
                     }
						n.ultima=n.E.ij(p1,0);
						if (n.E.ij(p1,5)!='' && (op=='f>!' || op=='O')) {if (!eval(n.E.ij(p1,5))) {break;}}
						if (!soypadre || p4) { //si p4 es true es que aunque sea un padre lo quiero seleccionar
                     //Lo quiero seleccionar
							var fondo;
							if (p2=='0') {
								fondo=n.bgcolor;
								if (!soypadre) 
                           n.E.ij2('0',p1,7);
                        else 
                           n.E.ij2('0',p1,8);
   							}
							else {
								if (n.multiseleccion==false) {
									var unico=arbol(nombre,'#');
									if (unico.length!=0) {arbol(nombre,'>!',unico[0],'0');n.ultima=n.E.ij(p1,0);}
								}
								fondo=n.oncolor;
								if (!soypadre) 
                           n.E.ij2('1',p1,7);
                        else 
                           n.E.ij2('1',p1,8);
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
                     //quiero abrir un nodo padre (no seleccionarlo)
							if (n.E.ij(p1,7)=='0') {arbol(nombre,'&','1',n.E.ij(p1,0));}
							else {arbol(nombre,'&','0',n.E.ij(p1,0));}
							if (op=='O') {arbol(nombre,'@');}
						}						
						break;
		case 'N?':	for(var i=0;i<n.E.longitud;i++) {if (n.E.ij(i,0)==p1) return i;}
						return -1;
						break;
		case 'BG>':
						if (p2==1) 
                     {p2=n.overcolor;}
						else {

							if (n.E.ij(p1,4)=='P' && !eval(nombre+".padreselecc")) {
                        p2=n.bgcolor;
                        }
							else {
								if ( (n.E.ij(p1,4)=='H' && n.E.ij(p1,7)=='1') || (n.E.ij(p1,4)=='P' && n.E.ij(p1,8)=='1') ) 
                           {p2=n.oncolor;}
								else
                           {p2=n.bgcolor;}
							}
						}
						if (ns) {
								nsdoc=eval(nombre+'Scroll.nsdoc');
								if (p2=='') {eval(nsdoc+'.'+nombre+'Scroll.document.layers["'+nombre+p1+'"].bgColor=null');}
								else {eval(nsdoc+'.'+nombre+'Scroll.document.layers["'+nombre+p1+'"].bgColor="'+p2+'"');}}
						else {
                     //document.all[nombre+p1].pepepe.papa=pipo
                     if (eval(nombre+".SELECC_ANCHO"))   {
                        document.all[nombre+p1].style.background=p2;
                        document.all[nombre+p1].parentElement.style.background=p2;
                        }
                     else  {
                        document.all[nombre+p1].style.background=p2;
                        }
                     }		
						break;
		default: alert("Árbol '"+nombre+"': opción("+op+") no válida.");break;
	}
}


/********************************** 
	d3arbol.js
	Funciones JavaScript asociadas a la clase Arbol (Arbol.java)
	26/03/2002
	DRUIDA 1.1
**********************************/
// Gestiona entradas del árbol
// '+','n','nº imagen','codigo','texto','P/H','onclick' : Inserta la entrada de nivel n.
// '-',n : Elimina la entrada de nivel n. Si dicha entrada es un padre, elimina TODO lo que desciende de él. Si n=='.', elimina todas las entradas seleccionadas.
// '0',[array]: carga inicial de las entradas ['n1.n2.n3','n1.n2.n3'] del array (Sin [array], carga todas)
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

function arbolM(nombre,op,p1,p2,p3,p4,p5,p6)  {

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
		case 'I?': return n.E.ij(arbolM(nombre,'N?',p1),1); break;
		case 'C?': return n.E.ij(arbolM(nombre,'N?',p1),2); break;
		case 't?': return n.E.ij(arbolM(nombre,'N?',p1),4); break;
		case 'T?': return n.E.ij(arbolM(nombre,'N?',p1),3); break;
		case 'I>': n.E.ij2(p2,arbolM(nombre,'N?',p1),1); break;
		case 'C>': n.E.ij2(p2,arbolM(nombre,'N?',p1),2); break;
		case 't>': n.E.ij2(p2,arbolM(nombre,'N?',p1),4); break;
		case 'T>': n.E.ij2(p2,arbolM(nombre,'N?',p1),3); break;
		case '>?': return n.E.ij(arbolM(nombre,'N?',p1),6); break;
		case ' ':	n.E.borrar();
					break;
		case '+':	var visible=0,padre='';
					for(var j=0;j<n.E.longitud;j++) {
						if (p1==n.E.ij(j,0)) {alert("Árbol '"+nombre+"': entrada ("+n.E.ij(j,0)+") con nivel duplicado.");}
						if (p1>n.E.ij(j,0)) {continue;}
						if (p1.lastIndexOf('.')==-1) {visible='1';}
						else {
							padre=p1.substring(0,p1.lastIndexOf('.'));
							visible=n.E.ij(arbolM(nombre,'N?',padre),7);
						}
						n.E.insertar(j,[p1,p2,p3,p4,p5,p6,visible,'0']);
						break;
					}
					if (j==n.E.longitud) {
						if (p1.lastIndexOf('.')==-1) {visible='1';}
						else {
							padre=p1.substring(0,p1.lastIndexOf('.'));
							visible=n.E.ij(arbolM(nombre,'N?',padre),7);
						}
						n.E.agregar([p1,p2,p3,p4,p5,p6,visible,'0','0']);
					}
					n.maxwidth=(p4.length>n.maxwidth?p4.length:n.maxwidth);
					break;
		case '-':	if (p1=='.') {
						for(var i=n.E.longitud-1;i>=0;i--) {
							if (n.E.ij(i,4)=='P') continue;
							if (n.E.ij(i,7)=='1') {n.E.eliminar(i);}
						}
						break;
					}
					var p3=arbolM(nombre,'N?',p1); if (p3==-1) {alert("Árbol '"+nombre+"': intento de eliminación de un nivel ("+p1+") inexistente.");return false;}
					if (n.E.ij(p3,4)=='H') {n.E.eliminar(p3);}
					else {
						p3=p1.length;
						for(var i=n.E.longitud-1;i>=0;i--) {
							if (n.E.ij(i,0).substr(0,p3)==p1) {n.E.eliminar(i);}
						}							
					}
					break;
		case '0':	var maxwidth=0;
               if(n.renderOptimizado && !n.onMouseOverTabla)  {
                  n.onMouseOverTabla = DrArbolOnMouseOverTabla
                  n.onMouseOutTabla = DrArbolOnMouseOutTabla
                  n.onClickTabla = DrArbolOnClickTabla
                  n.nombre=nombre;
                  }
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
									if (n.multiseleccion==false && flag)
										{alert("Árbol '"+nombre+"': no se admite multiselección en la carga inicial.");return false;}
									flag=true;
									n.ultima=n.entradas[i][0];
								}									
								seleccionado='1';
								S0.eliminar(j);
								break;
							}
						}
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
								if (n.E.ij(j,0)==nivel) {n.E.ij2('1',j,6);arbolM(nombre,'&','1',nivel);break;}
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
		case '@':	// pinta el árbol
               if(n.renderOptimizado)  {
                  DrPintaArbolMenuSimplificado(nombre,n);
                  break;
                  }
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
					// Ignoro la primera entrada
               var filasVisibles=0;
					for(var i=1;i<n.E.longitud;i++) {
						entrada=n.E.ij(i);
                  var eltexto=entrada[3];
						if (entrada[6]=='0') {
							continue;
							}
						//if (entrada[4]=='H' && entrada[7]=='1')
                  if (entrada[4]=='H' && entrada[0]==arbolM(nombre,'?'))   {//Solo la última pulsada //ESTO NO FUNC
                     fondo=n.oncolor;
                     eval(nombre).ultimaSeleccionada=entrada[0];
                     //alert('meto en '+nombre+".ultimaSeleccionada:"+eval(nombre).ultimaSeleccionada)
                     } 
                  else 
                     {fondo=n.bgcolor;}
						if (ns) {
							body+='<ILAYER STYLE="'+n.id+'" BGCOLOR="'+fondo+'"';
						} else {
                     
                     var elJavascript="";
                     if (eval(nombre+'.overcolor'))   {
	                     elJavascript=" onmouseover=\"this.oldBackgroundColor=this.style.backgroundColor;this.style.backgroundColor="+nombre+".overcolor\" onMouseOut=\"	if(this.oldBackgroundColor){this.style.backgroundColor=this.oldBackgroundColor} else this.style.backgroundColor=''\" "
                        }

							var vNiv=0;
							for(j=0;j<entrada[0].length;j++) {
								if (entrada[0].charAt(j)=='.') {
									vNiv++;
								}
							}
							var estilo = n.id + vNiv;
							//var vTAncho = n.ancho + 16;
							var vTAncho = '100%';
							var vTAlto = n.altofila;
                     var vtooltip="";
                     if (!ns && n.repEnTooltip)  
                        vtooltip=" TITLE=\""+DrdEscXML(eltexto)+"\" "
                     var vImgFondo="";
                     if (n.imgFondo != null) 
                        var vImgFondo = " BACKGROUND=\""+DrdImgPath()+n.imgFondo+vNiv+".gif\" ";
                        //BACKGROUND="'+vImgFondo+'"

                     body+='<TABLE '+vtooltip+' WIDTH="'+vTAncho+'" BORDER=0 CELLPADDING=0 CELLSPACING=0><TR height="'+vTAlto+'"><TD NOWRAP valign="middle" class="'+estilo+'" '+vImgFondo+' ><SPAN ';                     
						}
						body+=' ID='+nombre+i+'>';
						var vNiv=0;
						for(j=0;j<entrada[0].length;j++) {
							if (entrada[0].charAt(j)=='.') {
//								body+='&nbsp;&nbsp;&nbsp;';
								vNiv++;
							}
						}

						var vIndentado = n.indentado * (vNiv - 1); 
						var estilo = n.id+vNiv;
//						body+='<A class="'+n.id+'"';
						body+='<A style="width:100%" class="'+estilo+'"';
						if (n.idoff!='') { body+=' ID='+n.idoff; }
                  var elOnOpenClose=n.onOpenClose?n.onOpenClose:'';
						body+=' HREF="javascript:arbolM(\''+nombre+'\',\'O\',\''+i+'\');'+elOnOpenClose+';"';

                  body += elJavascript;

						//body+=' onMouseOver="arbolM(\''+nombre+'\',\'BG>\',\''+i+'\',1); window.status=\''+entrada[3]+'\'; return true;"';
						//body+=' onMouseOut="arbolM(\''+nombre+'\',\'BG>\',\''+i+'\',0)"';

						body+='>';

						body+='<IMG SRC="' + DrdImgPath() + 'transparente.gif" WIDTH="'+vIndentado+'" HEIGHT="1" BORDER="0" >';

						if ( (n.imgs.length!=0 && entrada[1]!='') || (entrada[4]=='P' && n.icorama) || (entrada[4]=='H' && n.icofinal)) {
							src_img="";

							//si Tengo hijos ...
							if (entrada[4]=='P')	{
								//Tengo atributo icorama definido?
								if (n.icorama)	{
									//Estoy abierto ...
									if (''+entrada[7]=='0')	
										src_img=DrdImgPath()+n.icorama+"0.gif";
									//O cerrado ...
									else
										src_img=DrdImgPath()+n.icorama+"1.gif";
									}
								//Si no lo tengo, busco el icono correspondiente y lo pinto
								else	{
									src_img=n.imgs[parseInt(entrada[1])];
									}
								}
							//si soy nodo final ...
							else	{
								//Tengo atributo icofinal definido?
								if (n.icofinal)	{
									src_img=DrdImgPath()+n.icofinal+".gif";
									}
								//Si no lo tengo, busco el icono correspondiente y lo pinto
								else	{
									src_img=n.imgs[parseInt(entrada[1])];
									}
								}

							body+='<IMG align="absmiddle" SRC="'+src_img+'" BORDER=0>';
							}

                  var textoArreglado=eltexto;
                  if (n.maxCar)  {
                     var maxCarNiv=(n.carPorTab)?n.maxCar - ((vNiv - 1)*n.carPorTab) : n.maxCar;
                     textoArreglado=DrArreglaTam(textoArreglado,maxCarNiv);
                     }
                  body+='&nbsp;'+textoArreglado+'&nbsp;</A>';

						if (ns) {body+='</ILAYER><BR>';} 
                  else {body+='</SPAN></TD></TR></TABLE>';}

						if (ns) {nsdoc.write(body);}
						else {nsdoc.insertAdjacentHTML('BeforeEnd',body);}
    					body='';
                  filasVisibles++;
					}
					if (ns) {nsdoc.close();} 
               
               if (!n.sinScroll) {
   					eval(nombre+"Scroll_init()");
	   				if (eval(nombre+'Scroll.activoy!=-1')) {eval(nombre+'Scroll.activoy=1');scrolly(nombre+'Scroll',0);eval(nombre+'Scroll.activoy=0');}
   					if (eval(nombre+'Scroll.activox!=-1')) {eval(nombre+'Scroll.activox=1');scrollx(nombre+'Scroll',0);eval(nombre+'Scroll.activox=0');}
                  }
               n.filasVisibles=filasVisibles;
               n.tamCalculadoFilasVisibles=filasVisibles*n.altofila;
					break;
      case '@2': DrPintaArbolMenuSimplificado(nombre,n);break;
		case 'O':
		case '>': //Si p4=true pinta a la vez que abre (es lo mejor) porque si no se pierde la selección
		case 'f>!': // chequea la función
		case '>!':	

            //alert('>! '+p1+" "+p2+" "+p3+" "+p4);

               if (op=='>!' && p1=='.') {
						if (n.multiseleccion==false && p2=='1') {alert("Árbol '"+nombre+"': sin multiselección no se permite seleccionar todo."); break;}
						for(var i=0;i<n.E.longitud;i++) {
							if (n.E.ij(i,4)=='H') {
								if (p2=='1' && n.selecvisible==true && n.E.ij(i,6)=='0')  {continue;}
								arbolM(nombre,'>!',n.E.ij(i,0),p2);
							}
						}
						break;
					}
					if (op!='O') {var p3=arbolM(nombre,'N?',p1); if (p3==-1) {alert("Árbol '"+nombre+"': nivel ("+p1+") inexistente.");return false;} else {p1=p3;}}
					if (op!='>!') {if (n.E.ij(p1,7)=='1') {p2='0';} else {p2='1';}}
					n.ultima=n.E.ij(p1,0);

               //Calculo RAMA_SIN_CARGAR, ES_RAMA y RAMA_ABIERTA
               var RAMA_SIN_CARGAR=false;
               var ES_RAMA=false;
               var RAMA_ABIERTA=false;
               if (n.E.ij(p1,4)!='H') {//Si es RAMA
                  ES_RAMA=true;
                  if (n.E.ij(p1,7)!='0')                  
                     RAMA_ABIERTA=true
                  if (n.dinamico)	{ //SI HAY CARGA DINAMICA ...
                     if (eval("window."+nombre+".trayendo"))
                        break;
                     if (DrNumHijosNodoArbol(n.E,p1)==0)
                        RAMA_SIN_CARGAR=true;
                     }
                  }

               if (n.E.ij(p1,5)!=' ' && n.E.ij(p1,5)!='' && (op=='f>!' || op=='O')) {
                  //hago el eval de la funcion
                  if (!eval(n.E.ij(p1,5))) {
                     break;
                     }
                  }

					if (!ES_RAMA) {//Si es hijo ...
   					var fondo;
						if (p2=='0') {
							fondo=n.bgcolor;
							n.E.ij2('0',p1,7);
						}
						else {
							if (n.multiseleccion==false) {
								var unico=arbolM(nombre,'#');
								if (unico.length!=0) {arbolM(nombre,'>!',unico[0],'0');n.ultima=n.E.ij(p1,0);}
							}
							fondo=n.oncolor;

							n.E.ij2('1',p1,7);
						}
						if (n.E.ij(p1,6)=='0') break;
						if (ns) {
							nsdoc=eval(nombre+'Scroll.nsdoc');
							if (fondo=='') {
								eval(nsdoc+'.'+nombre+'Scroll.document.layers["'+nombre+p1+'"].bgColor=null');
								}
							else {eval(nsdoc+'.'+nombre+'Scroll.document.layers["'+nombre+p1+'"].bgColor="'+fondo+'"');}
						   }
						else {
                     //+++++++++++
                     var arbb=eval(nombre)
                     var arbults=arbb.ultimaSeleccionada
                     if (arbults && arbults.style) {
                        if (arbb.imgFondo)
                           arbults.style.background=""; 
                        else
                           arbults.style.background=n.bgcolor; //Aqui quito del anterior
                        }
                     //------------
                     var rr=document.all[nombre+p1]
                     if (rr && rr.style)  {
                        //rr.oldcolor=rr.style.background;
							   rr.style.background=n.oncolor; //Aqui pongo el color
                        arbb.ultimaSeleccionada=rr;
                        }
                     }

					   }
					else { //PADRE

                  if (RAMA_SIN_CARGAR)	{ //Si es padre sin hijos, llamamos a la función de conectar con BD
                     var conn=eval(nombre+'.conector');
                     var cod_=n.E.ij(p1,0);
                     var ind_=cod_.lastIndexOf('.');
                     if (ind_!=-1)
                        cod_=cod_.slice(ind_+1);
                     asignar([["RAMA","frmSalida.id"+nombre,conn,"rama_rowset",cod_,"DrTomaResultadoConectArbol(datos,\""+nombre+"\",\""+n.E.ij(p1,0)+"\")"]],"","");
                     eval("window."+nombre+".trayendo=true");
                     break;
                     }

						if (n.E.ij(p1,7)=='0') {
							arbolM(nombre,'&','1',n.E.ij(p1,0));
							}
						else {
							arbolM(nombre,'&','0',n.E.ij(p1,0));
							}

						if (op=='O' || p4) {
							arbolM(nombre,'@'); //REPINTO
							}

   					if (ns) {
						   }
						else {
                     var arbb=eval(nombre);
                     var arbults=arbb.ultimaSeleccionada
                     if (arbults && arbults.style) 
                        arbults.style.background=n.bgcolor;
                     var rr=document.all[nombre+p1]
							if (rr && rr.style)  {
                        rr.style.background=n.oncolor; //Aqui pongo el color
                        //alert('pongo')
                        arbb.ultimaSeleccionada=rr;
                        }
                     }
					}
					break;
		case 'N?':	for(var i=0;i<n.E.longitud;i++) {if (n.E.ij(i,0)==p1) return i;}
					return -1;
					break;
		case 'BG>':
					if (p2==1) {
						p2=n.id;
					}
					else {
						if (n.E.ij(p1,4)=='P') {p2=n.bgcolor;}   //alert('hola')
						else {
							if (n.E.ij(p1,7)=='1') {p2=n.oncolor;}   //alert('2');
							else  {p2=n.bgcolor;}   //alert('3');
						}
					}
					if (ns) {
							nsdoc=eval(nombre+'Scroll.nsdoc');
							if (p2=='') {
								eval(nsdoc+'.'+nombre+'Scroll.document.layers["'+nombre+p1+'"].style=null');
							} else {
								eval(nsdoc+'.'+nombre+'Scroll.document.layers["'+nombre+p1+'"].style="'+p2+'"');
							}
						}					
					break;
		default: alert("Árbol '"+nombre+"': opción("+op+") no válida.");break;
	}
}


function DrNumHijosNodoArbol (vec,numHijo)	{
	//Numero de hijos para el nodo numero 'numHijo' en el vector vec
	var i,abuscar=vec.ij(numHijo,0)+".";
	var cont=0;
	for (i=0;i<vec.longitud;i++)	{
		var esteNiv=vec.ij(i,0);
		if (esteNiv.indexOf(abuscar)==0)
			cont++;
		}
	return cont;
	}


function DrNumeroNodoConNivel (nombreArb,niv)	{
	//Numero de hijo (con nivel 'niv') en el Vector interno del arbol 'nombreArb'
	var i,n=eval(nombreArb);
	for (i=0;i<n.E.longitud;i++)	
		if (n.E.ij(i,0)==niv)
			return i
	return -1;
	}


function DrTomaResultadoConectArbol (datos,nombreArb,nivNodoPadr)	{
   if (datos.length==0) {
      d3ocupado_ocultar('d3general');
      eval("window."+nombreArb+".trayendo=false");
      return;
      }
	var i;
	for (i=0;i<datos.length;i++)	
		arbolM(nombreArb,'+',nivNodoPadr+'.'+datos[i][0],datos[i][1],datos[i][2],datos[i][3],datos[i][4],datos[i][5]);
	var nn=DrNumeroNodoConNivel(nombreArb,nivNodoPadr);
	eval("window."+nombreArb+".trayendo=false");
	arbolM(nombreArb,'O',nn);
	//arbolM(nombreArb,'@');//Aparentemente no hace falta
	}


function DrArbolDblClickPadre(nombre,a,b,c,d,e)  {//Auxiliar de arbol() para controlar el doble click
   var elarbol=eval(nombre)
   if (!elarbol.IDCLICK)//Falta al principio del otro hacerlo null
      return
   clearTimeout(elarbol.IDCLICK);
   arbol(nombre,a,b,c,d,e)
   }

function DrArreglaTam (cad,tamMax)  {
   if (cad.length>tamMax)  
      return cad.substr(0,tamMax)+"..."
   return cad
   }

function DrPintaArbolMenuSimplificado(nombre,objArbol)   {
   n=objArbol;
   var nsdoc;
   nsdoc=document.all[nombre+'Scroll'];
   var body=[],j,fondo;
   var elOnMouseOutTabla='',elOnMouseOverTabla='';
   if (objArbol.overcolor)   {
      elOnMouseOverTabla=" onMouseOver="+nombre+".onMouseOverTabla() "
      elOnMouseOutTabla=" onMouseOut="+nombre+".onMouseOutTabla() "
      }
   var elOnClickTabla=" onClick="+nombre+".onClickTabla() "
   body.mete('<TABLE class=brdTblDat'+nombre+' BORDER=0 CELLPADDING=0 CELLSPACING=0 '+elOnMouseOverTabla+elOnMouseOutTabla+elOnClickTabla+'>')
   //Variables para el bucle
   var vTAlto = n.altofila;
   var n_id = n.id;
   var fondo=n.bgcolor
   var hayTooltip=n.repEnTooltip;
   var htmlImgFondo1="";
   var n_indentado=n.indentado,n_idoff=n.idoff,n_imgs_length=n.imgs.length,n_icorama=n.icorama,n_icofinal=n.icofinal,n_imgs=n.imgs,n_maxCar=n.maxCar,n_carPorTab=n.carPorTab
   if (n.imgFondo != null) 
      htmlImgFondo1=" BACKGROUND=\""+DrdImgPath()+n.imgFondo
   var elOnOpenClose=n.onOpenClose?n.onOpenClose:'';
   var filasVisibles=0;
   for(var i=1, longit=n.E.longitud;i<longit;i++) {   // Ignoro la primera entrada
      entrada=n.E.ij(i);
      var eltexto=entrada[3];
      if (entrada[6]=='0') 
         continue;
      /*
      if (entrada[4]=='H' && entrada[0]==arbolM(nombre,'?'))   {//Solo la última pulsada
         fondo=n.oncolor;
         objArbol.ultimaSeleccionada=entrada[0];
         } 
      else 
         fondo=n.bgcolor;*/
      var vNiv=entrada[0].split('.').length -1
      var estilo = n_id + vNiv;
      body.mete('<TR ')
      if (hayTooltip)  
         body.mete(" TITLE=\""+DrdEscXML(eltexto)+"\" ");
      body.mete('><TD NOWRAP class="')
      body.mete(estilo)
      body.mete('" ');
      if (htmlImgFondo1 != "") {
         body.mete(htmlImgFondo1)
         body.mete(vNiv)
         body.mete(".gif\" ")
         }
      body.mete(' ><SPAN ');
      body.mete(' ID='+nombre+i+'>');
      var vIndentado = n_indentado * (vNiv - 1); 
      var estilo = n_id+vNiv;
      body.mete('<A class="'+estilo+'"');
      if (n_idoff!='') { body.mete(' ID='+n_idoff); }
      body.mete(' CONTROL='+i+' ><IMG SRC="')
      body.mete( DrdImgPath() )
      body.mete('transparente.gif" align="absmiddle"  WIDTH="'+vIndentado+'" HEIGHT="1">');
      if ( (n_imgs_length!=0 && entrada[1]!='') || (entrada[4]=='P' && n_icorama) || (entrada[4]=='H' && n_icofinal)) {
         src_img="";
         if (entrada[4]=='P')	{//si Tengo hijos ...
            if (n_icorama)	{            //Tengo atributo icorama definido?
               if (''+entrada[7]=='0')	               //Estoy abierto ...
                  src_img=DrdImgPath()+n_icorama+"0.gif";
               else               //O cerrado ...
                  src_img=DrdImgPath()+n_icorama+"1.gif";
               }
            else	           //Si no lo tengo, busco el icono correspondiente y lo pinto
               src_img=n_imgs[parseInt(entrada[1])];
            }
         else	{//si soy nodo final ...
            if (n_icofinal)//Tengo atributo icofinal definido?
               src_img=DrdImgPath()+n_icofinal+".gif";
            else	//Si no lo tengo, busco el icono correspondiente y lo pinto
               src_img=n_imgs[parseInt(entrada[1])];
            }
         body.mete('<IMG align="absmiddle" SRC="'+src_img+'">');
         }
      var textoArreglado=eltexto;
      if (n_maxCar)  {
         var maxCarNiv=(n_carPorTab)?n_maxCar - ((vNiv - 1)*n_carPorTab) : n_maxCar;
         textoArreglado=DrArreglaTam(textoArreglado,maxCarNiv);
         }
      body.mete('&nbsp;')
      body.mete(textoArreglado)
      body.mete('&nbsp;</A></SPAN></TD></TR>');
      filasVisibles++;
      }
   body.mete('</TABLE>');
   nsdoc.innerHTML=body.join('');
   //Falta iluminar la que estaba iluminada
   if (!n.sinScroll) {
      eval(nombre+"Scroll_init()");
      if (eval(nombre+'Scroll.activoy!=-1')) {eval(nombre+'Scroll.activoy=1');scrolly(nombre+'Scroll',0);eval(nombre+'Scroll.activoy=0');}
      if (eval(nombre+'Scroll.activox!=-1')) {eval(nombre+'Scroll.activox=1');scrollx(nombre+'Scroll',0);eval(nombre+'Scroll.activox=0');}
      }
   n.filasVisibles=filasVisibles;
   n.tamCalculadoFilasVisibles=filasVisibles*n.altofila;
   }


Array.prototype.mete= function (obj)   {//Mucho mas rapido que ir sumando en una cadena
   this[this.length]=obj;
   }

function DrArbolOnMouseOverTabla()  {//Solo IE
   var elA=event.toElement;
   while (elA.tagName!="A" && elA.tagName!="TABLE" && elA.parentElement)
      elA=elA.parentElement
   if (elA.tagName!="A")
      return
   elA.oldbgcol=elA.style.backgroundColor;
   elA.style.backgroundColor=this.overcolor;
   }
function DrArbolOnMouseOutTabla()   {
   var elA=event.fromElement; 
   while (elA.tagName!="A" && elA.tagName!="TABLE" && elA.parentElement)
      elA=elA.parentElement
   if (elA.tagName!="A")
      return
   elA.style.backgroundColor=elA.oldbgcol
   }
function DrArbolOnClickTabla()   {
   var elA=event.srcElement;
   while (elA.tagName!="A" && elA.tagName!="TABLE" && elA.parentElement)
      elA=elA.parentElement
   if (elA.tagName!="A" || !elA.CONTROL)
      return
   arbolM(this.nombre,'O',elA.CONTROL);
   if(this.onOpenClose)
      eval(this.onOpenClose);
   }