/********************************** 
	$Id: valida.js,v 1.1 2009/12/03 19:03:47 pecbazalar Exp $
	Funciones javascript básicas de validación de campos de formulario
	28/05/2001
	DRUIDA 1.1

// Función ejemplo genérica de validación con campos como argumentos
// Debe devolver 'OK' si la validación es correcta, 'mensaje de error' en caso contrario
	function ValidaFuncion(valor1,valor2) {
			if (valor1>=valor2) {return 'OK';}
			else {return 'Valor1<valor2.';}
	}
**********************************/


// Valida todos los campos del array de entrada: ValidaCampos( ['f1.campo1','f2.campo2',...,'fn.campoN'] )
// alerta=true => salta un alert si falla la validación y posiciona el foco al 1er campo inválido
// ValidaCampos devuelve true si la validación es correcta, false en caso contrario
function ValidaCampos(campos, alerta) {
	var resultado;
	for(var i=0;i<campos.length;i++) {
		resultado=valida(campos[i],alerta,true);
		if (resultado==false) return false;
	}
	return true;
}

// Realiza varias Validaciones sobre el valor de entrada.
// ValidaMultiple(valor, [ "Valida1(valor, arg2, ...)" , ... , "ValidaN(valor, arg2, ...)" ])
// 'valor' representa el valor a validar. Admite abreviaturas ("N", ...).
// No comprueba si el valor es requerido o no, ni posiciona el foco en el campo inválido (hacerlo a través del argumento 'c/C' de los elementos de formulario).
// ValidaMultiple devuelve 'OK' si la validación múltiple es correcta, 'msg de error' en caso contrario
function ValidaMultiple(valor, validaciones) {
	var resultado;
	for(var i=0;i<validaciones.length;i++) {
		if (entornoV(validaciones[i])!='DRD_ERROR_001') {
         resultado=eval(entornoV(validaciones[i]));
         }
		else {resultado=eval(validaciones[i]);}
		if (resultado!='OK') return resultado;
	}
	return 'OK';
}

//Validación: número
function ValidaNum(value) {
	if (isNaN(value)) {return DrdMsgCore(101);}
	return 'OK';
}

//Validación: valor sólo contiene ciertos caracteres 
// crtab indica si el retorno de carro es permitido, falta implementar el tabulador
function ValidaCaracteres(valor, permitidos, crtab) {
	var c;
	if (!crtab) 
		crtab = false;
	for(var i = 0; i < valor.length; i++) {
		c = valor.charAt(i);
		if (!crtab) { 
			if (permitidos.indexOf(c)==-1 ) {
				return DrdMsgCore(102) + permitidos;
			}
		} else
		{
			if (permitidos.indexOf(c)==-1 && c != '\n' && c != '\r') 
				return DrdMsgCore(102) + permitidos;
		}
	 }
	return 'OK';
}

//Validación: texto
// vi=true => acepta grupo de caracteres ci
function ValidaTexto(texto,v0,v1,v2,v3,v4,v5) {
	var permitidos='';
	var c0='0123456789';
	var c1='abcdefghijklmnopqrstuvwxyz';
	var c2='ABCDEFGHIJKLMNOPQRSTUVWXYZ';
	var c3='ñáéíóúüç';
	var c4='ÑÁÉÍÓÚÜÇ';
	if (v0) {permitidos+=c0;}
	if (v1) {permitidos+=c1;}
	if (v2) {permitidos+=c2;}
	if (v3) {permitidos+=c3;}
	if (v4) {permitidos+=c4;}
	return ValidaCaracteres(texto,permitidos);
}
function ValidaLetras(texto) {return ValidaTexto(texto,false,true,true);}
function ValidaLetrasE(texto) {return ValidaTexto(texto,false,true,true,true,true);}
function ValidaMays(texto) {return ValidaTexto(texto,false,false,true);}
function ValidaMaysE(texto) {return ValidaTexto(texto,false,false,true,false,true);}
function ValidaMins(texto) {return ValidaTexto(texto,false,true,false);}
function ValidaMinsE(texto) {return ValidaTexto(texto,false,true,false,true);}
function ValidaDigitos(texto) {return ValidaTexto(texto,true);}
function ValidaAlfanumerico(texto) {return ValidaTexto(texto,true,true,true,false,false);}
function ValidaAlfanumericoE(texto) {return ValidaTexto(texto,true,true,true,true,true);}

//Validación: tamaño del argumento valor (min<=tamaño_valor<=max)
//ValidaLongitud(valor,tam) => max=min=tam
function ValidaLongitud(valor,min,max) {
	if (!max) {if (valor.length!=min) {return DrdMsgCore(103)+min+DrdMsgCore(104);}}
	if (valor.length>max) {return DrdMsgCore(105)+max+DrdMsgCore(104);}
	if (valor.length<min) {return DrdMsgCore(106)+min+DrdMsgCore(104);}
	return 'OK';
}

//Validación: número de ocurrencias (ndo) de 'subcadena' dentro de 'cadena'
//Devuelve 'OK' si min<=ndo<=max
function ValidaOcurrencias(cadena,subcadena,min,max) {
	var contador=0;
	pos=cadena.indexOf(subcadena);
	while (pos!=-1) {
	   contador++;
	   pos=cadena.indexOf(subcadena,pos+1);
	}
	if ((contador<min)||(contador>max)) {return DrdMsgCore(107)+subcadena+DrdMsgCore(108)+cadena+DrdMsgCore(109)+min+DrdMsgCore(110)+max+"."}
	return 'OK';
}

//Validación: fecha
//ValidaFecha(fecha) => toma formato de entornoV
//formatos posibles: D/M/Y, D-M-Y, YMD, DMY, M/Y, D, d/m/Y,...
// D=día(01-31),d=día(1-31); M=mes(01-12), m=mes(1-12); Y=año(4 dígitos siempre)
// Comprobación fecha existente: si no se incluye el mes en el formato, se admite hasta 31 días. Si no se incluye el año, se admite 29/02.
// Si existen Fm(fecha mínima) y/o FM(fecha máxima), comprueba que fecha se encuentra comprendida entre ambas inclusive. Fm y FM deben ajustarse a formato.
function ValidaFecha(fecha, formato,Fm,FM) {
	var f1,f2,f3;
	var s1,s2,s3='A';
	if (!formato || formato=='') {formato=entornoV('formatoF');}
	f1=FormateaFecha(fecha,formato); if (f1.length!=3) {return f1;}
	s1=f1[2]+'/'+(f1[1]>9?'':'0')+f1[1]+'/'+(f1[0]>9?'':'0')+f1[0];
	if (Fm) {
		f2=FormateaFecha(Fm,formato); if (f2.length!=3) {return 'Fm: '+f2;}
		s2=f2[2]+'/'+(f2[1]>9?'':'0')+f2[1]+'/'+(f2[0]>9?'':'0')+f2[0];
	}
	if (FM) {
		f3=FormateaFecha(FM,formato); if (f3.length!=3) {return 'FM: '+f2;}
		s3=f3[2]+'/'+(f3[1]>9?'':'0')+f3[1]+'/'+(f3[0]>9?'':'0')+f3[0];
	}
	if (s1<s2) {return DrdMsgCore(111)+Fm+'.';}
	if (s1>s3) {return DrdMsgCore(112)+FM+'.';}
	return 'OK';
}

// Pasa 'fecha' a 'formato'
// No es función de validación, sino auxiliar de ValidaFecha
function FormateaFecha(fecha, formato) {
	var d='', m='', a='';
	var i=0, j=0, separador='';
	if (ValidaCaracteres(formato,'dmDMY/-')!='OK') {return DrdMsgCore(113)+"dmDMY/-";}
	if (formato.indexOf('/')!=-1 && formato.indexOf('-')!=-1) {return DrdMsgCore(114);}
	if (formato.indexOf('D')!=-1 && formato.indexOf('d')!=-1) {return DrdMsgCore(115);}
	if (formato.indexOf('M')!=-1 && formato.indexOf('m')!=-1) {return DrdMsgCore(116);}
	if (ValidaOcurrencias(formato,'D',0,1)!='OK') {return DrdMsgCore(117);}
	if (ValidaOcurrencias(formato,'d',0,1)!='OK') {return DrdMsgCore(118);}
	if (ValidaOcurrencias(formato,'M',0,1)!='OK') {return DrdMsgCore(119);}
	if (ValidaOcurrencias(formato,'m',0,1)!='OK') {return DrdMsgCore(120);}
	if (ValidaOcurrencias(formato,'Y',0,1)!='OK') {return DrdMsgCore(121);}
	if (formato.indexOf('/')!=-1) {separador='/';}
	else if (formato.indexOf('-')!=-1) {separador='-';}
	if ((formato.indexOf('d')!=-1)&&(formato.charAt(formato.indexOf('d')+1)!='')&&(formato.charAt(formato.indexOf('d')+1)!=separador)) {return DrdMsgCore(122);}
	if ((formato.indexOf('m')!=-1)&&(formato.charAt(formato.indexOf('m')+1)!='')&&(formato.charAt(formato.indexOf('m')+1)!=separador)) {return DrdMsgCore(123);}
	if (ValidaCaracteres(fecha,'0123456789'+separador) !='OK') {return DrdMsgCore(124)+'0123456789'+separador;}
	for(i=0;i<formato.length;i++) {
		if (j>=fecha.length) {return DrdMsgCore(125)+formato+DrdMsgCore(126);}
		switch(formato.charAt(i)) {
			case 'D': d=fecha.substr(j,2); j+=2; if (d.length!=2 || ValidaDigitos(d)!='OK') {return DrdMsgCore(127);} break;
			case 'M': m=fecha.substr(j,2); j+=2; if (m.length!=2 || ValidaDigitos(m)!='OK') {return DrdMsgCore(128);} break;
			case 'Y': a=fecha.substr(j,4); j+=4; if (a.length!=4 || ValidaDigitos(a)!='OK')  {return DrdMsgCore(129);} break;
			case 'd': if (fecha.charAt(j)!=separador) {d+=fecha.charAt(j++); if(j<fecha.length) i--;} else {if (d=='') return DrdMsgCore(125)+formato+DrdMsgCore(126);} break;
			case 'm': if (fecha.charAt(j)!=separador) {m+=fecha.charAt(j++); if(j<fecha.length) i--;} else {if (m=='') return DrdMsgCore(125)+formato+DrdMsgCore(126);}break;
			case '/':
			case '-': if (fecha.charAt(j++)!=separador) {return DrdMsgCore(130)+formato+DrdMsgCore(131);} break;
		}		
	}
	if (j<fecha.length) {return DrdMsgCore(132);}
	// Comprobación fecha existente
	if (a!='') {
		a=parseInt(Number(a),10);
		if (a<entornoV('Ym') || a>entornoV('YM')) {return DrdMsgCore(133)+entornoV('Ym')+DrdMsgCore(134)+entornoV('YM')+'.';}
	} else {a=0;}
	if (m!='') {
		m=parseInt(Number(m),10);
		if (m<1 || m>12) {return DrdMsgCore(135);}
	} else {m=0;}
	if (d!='') {
		d=parseInt(Number(d),10);
		if (d<1 || d>31) {return DrdMsgCore(136);}
		if (d==31 && (m==4 || m==6 || m==9 || m==11)) {return DrdMsgCore(137);}
		if (m==2) {	// ¿año bisiesto?
			var max=29;
			if (a!=0) {
				if (a%4!=0) {max=28;}
				else {if (a%100==0 && a%400!=0) {max=28;}	}
			}
			if (d>max) {	return DrdMsgCore(138)+max+DrdMsgCore(139);}
		}
	} else {d=0;}
	return [d,m,a];
}

//Comparación de fechas
//ComparaFechas(fecha1,fecha2) => toma formato de entornoV
//formatos posibles: ver ValidaFecha
// Devuelve: -1 si f1>f2, 0 si f1=f2, 1 si f1<f2
function ComparaFechas(fecha1, fecha2, formato) {
	var f1,f2;
	var s1,s2='A';
	if (!formato || formato=='') {formato=entornoV('formatoF');}
	f1=FormateaFecha(fecha1,formato); if (f1.length!=3) {return f1;}
	s1=f1[2]+'/'+(f1[1]>9?'':'0')+f1[1]+'/'+(f1[0]>9?'':'0')+f1[0];
	f2=FormateaFecha(fecha2,formato); if (f2.length!=3) {return f2;}
	s2=f2[2]+'/'+(f2[1]>9?'':'0')+f2[1]+'/'+(f2[0]>9?'':'0')+f2[0];
	if (s1==s2) return 0;
	if (s1>s2) return -1;
	if (s1<s2) return 1;
}

// Diferencia en días entre dos fechas
// DiferenciaFechas(fecha1,fecha2) => toma formato de entornoV
// formatos posibles: ver ValidaFecha
// Devuelve: nº días
// Asume fecha1<fecha2. Si fecha2<fecha1, devuelve la diferencia en negativo
function DiferenciaFechas(fecha1, fecha2, formato) {
	var f1,f2;
	var d1,d2;
	var dias=0;
	if (!formato || formato=='') {formato=entornoV('formatoF');}
	f1=FormateaFecha(fecha1,formato); if (f1.length!=3) {return f1;}
	f2=FormateaFecha(fecha2,formato); if (f2.length!=3) {return f2;}
	d1=new Date(f1[2],f1[1]-1,f1[0]);
	d2=new Date(f2[2],f2[1]-1,f2[0]);
	dias=d2.getTime()-d1.getTime();
	dias=dias/86400000;
	return parseInt(dias);	// para redondear el cambio de hora
}

//Validación: min <= valor <= max
//Admite cadenas/números. La comparación es numérica o lexicográfica según si max/min son cadenas o números.
function ValidaRango(valor,min,max) {
	if (valor>=min && valor<=max) {return 'OK';}
	return DrdMsgCore(140)+min+DrdMsgCore(141)+max;
}

// Devuelve un String conteniendo valor con la coma decimal representada por separador ('.' o ',')
// El argumento de entrada 'valor' puede ser un número o una cadena. Siempre devuelve una cadena.
// No es función de validación.
function Decimal2(valor,separador) {
	valor=valor+'';
	valor=valor.replace(/\./g,separador);
	valor=valor.replace(/\,/g,separador);
	return valor;
}

// Transforma valor a un String con la coma decimal configurada según entornoV. No es función de validación.
function Coma(valor) {
	return Decimal2(valor,entornoV(','));
}

//Validación: número decimal
//Compuesto de hasta 'enteros' dígitos en la parte entera y hasta 'decimales' dígitos en la parte decimal
//Valor puede ser número o cadena
//Si entorno==false, admite como coma decimal tanto el '.' como la ',' (el primero que aparezca. En caso de la (,), valor debe ser una cadena).
//Si entorno==true, admite como coma decimal únicamente la configurada en entornoV(',')
// Se asume que las unidades de millar, millón, ... no van separadas por (,) ni (.).
// min,max: Pueden omitirse. Valida min<=valor<=max. Tanto min como max deben ajustarse al formato enteros.decimales
function ValidaFloat(valor,enteros,decimales,entorno,min,max) {
   if (entorno==null)
      entorno=true;
   if ( (!decimales || decimales=='') && entornoV('numerodecimales')!='DRD_ERROR_001') 
      decimales=entornoV('numerodecimales');
	valor=valor+'';
	if (valor=='') {return DrdMsgCore(142);}
	var separador;
	var ne=0,nd=0;
	var flag=false;
	if (entorno) {separador=entornoV(',');}
	else {if (valor.indexOf(",")!=-1 && (valor.indexOf(".")==-1||valor.indexOf(",")<valor.indexOf("."))) {separador=",";} else {separador=".";}}
	if (ValidaCaracteres(valor,'-0123456789'+separador)!='OK') {return DrdMsgCore(143)+'-0123456789'+(entorno?separador:',.');}
	if (ValidaOcurrencias(valor,separador,0,1)!='OK') {return DrdMsgCore(144);}
	for(var i=0;i<valor.length;i++) {
		if (valor.charAt(i)==separador) {flag=true;continue;}
		if (valor.charAt(i)=='-') {
			if (i!=0) {return DrdMsgCore(145);}
			continue;
		}
		if (flag) nd++; else ne++;
	}
	if (ne>enteros || nd>decimales) {return DrdMsgCore(146)+enteros+DrdMsgCore(147)+decimales+DrdMsgCore(148);}
	if(min || min==0) {
		if (ValidaFloat(min,enteros,decimales,entorno)!='OK') {return DrdMsgCore(149);}
		if (Decimal2(valor,'.')*1<Decimal2(min,'.')*1) {return DrdMsgCore(150)+min;}
	}
	if(max || max==0) {
		if (ValidaFloat(max,enteros,decimales,entorno)!='OK') {return DrdMsgCore(151);}
		if (Decimal2(valor,'.')*1>Decimal2(max,'.')*1) {return DrdMsgCore(152)+max;}
	}
	return 'OK';
}

//Validación: número entero con máximo número de dígitos='enteros'.
// min,max: Pueden omitirse. Valida min<=valor<=max. Tanto min como max deben ajustarse al formato enteros dígitos
function ValidaInt(valor,enteros,min,max) {
	var ok;
	if (ValidaCaracteres(valor,'-0123456789')!='OK') {return DrdMsgCore(143)+'-0123456789';}
	//Si hay un par de guiones o hay numeros a la izquierda del guion o no hay numeros a la derecha del guion, error
	if (valor.search(/(-0123456789)*-(-0123456789)*-(-0123456789)*/)!=-1
		|| valor.search(/(-0123456789)+-(-0123456789)*/)!=-1
		|| valor.search(/-$/)!=-1)
		return DrdMsgCore(153);
	if (max || max==0) {ok=ValidaFloat(valor,enteros,0,false,min,max);}
	else	if (min || min==0) {ok=ValidaFloat(valor,enteros,0,false,min);}
	else {ok=ValidaFloat(valor,enteros,0,false);}
	return ok;
}

function ValidaFormato(valor,formato,min,max) {
	var c=FormateaDato(valor,formato);
	if (c!='OK') return c;	
	if (min) {
		c=FormateaDato(min,formato);
		if (c!='OK') return DrdMsgCore(154)+c;
		if (valor<min) {return DrdMsgCore(155)+min;}
	}
	if (max) {
		c=FormateaDato(max,formato);
		if (c!='OK') return DrdMsgCore(156)+c;
		if (valor>max) {return DrdMsgCore(157)+max;}
	}	
	return 'OK';
}

// No es función de validación, sino auxiliar de ValidaFormato
function FormateaDato(dato,formato) {
	var j=0,c;
	if (formato=='') {return DrdMsgCore(158);}
	if (formato=='*') {return 'OK';}
	if (ValidaOcurrencias(formato,'**',0,0)!='OK') {return DrdMsgCore(159);}
	if (ValidaOcurrencias(formato,'*?',0,0)!='OK') {return DrdMsgCore(160);}
	if (ValidaOcurrencias(formato,'?*',0,0)!='OK') {return DrdMsgCore(161);}
	if (formato.lastIndexOf(']')<formato.indexOf('[')) {return DrdMsgCore(162);}
	for(var i=0;i<formato.length;i++) {
		if (j==dato.length) {return DrdMsgCore(163);}
		switch(formato.charAt(i)) {
			case '\\': i++;if (i==formato.length) {return DrdMsgCore(164);} else if (dato.charAt(j)!=formato.charAt(i)) {return DrdMsgCore(165)+(j+1)+DrdMsgCore(166)+formato.charAt(i)+"'.";} break;
			case 'A': if (ValidaMaysE(dato.charAt(j))!='OK') {return DrdMsgCore(165)+(j+1)+DrdMsgCore(168);} break;
			case 'a': if (ValidaMinsE(dato.charAt(j))!='OK') {return DrdMsgCore(165)+(j+1)+DrdMsgCore(169);} break;
			case '9': if (ValidaDigitos(dato.charAt(j))!='OK') {return DrdMsgCore(165)+(j+1)+DrdMsgCore(170);} break;
			case 'Z': if (ValidaLetrasE(dato.charAt(j))!='OK') {return DrdMsgCore(165)+(j+1)+DrdMsgCore(171);} break;
			case '?': break;
			case '[':		c='';while(formato.charAt(++i)!=']') {c+=formato.charAt(i);}
							if (ValidaCaracteres(dato.charAt(j),c)!='OK') {return DrdMsgCore(165)+(j+1)+DrdMsgCore(172)+c;}
							break;
			case '*':	if ((i+1)==formato.length) {return 'OK';}
							c=formato.charAt(++i);
							if (c=='\\') {c+=formato.charAt(++i);}
							if (c=='[') {while(formato.charAt(++i)!=']') {c+=formato.charAt(i);} c+=']';}
							while(FormateaDato(dato.charAt(j),c)!='OK') {j++; if (j==dato.length) return DrdMsgCore(173)+dato+DrdMsgCore(174)+FormateaDato(dato.charAt(j-1),c);}
							break;
			default: if (dato.charAt(j)!=formato.charAt(i)) {return DrdMsgCore(165)+(j+1)+DrdMsgCore(166)+formato.charAt(i)+"'.";} break;
		}
		j++;
	}
	if (j!=dato.length) {return DrdMsgCore(163);}
	return 'OK';
}