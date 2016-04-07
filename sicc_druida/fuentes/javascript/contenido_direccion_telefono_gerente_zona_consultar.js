var FORMULARIO = 'formulario';
function onLoadPag(){
    DrdEnsanchaConMargenDcho('listado1',12);
    document.all["Cplistado1"].style.visibility='';
    document.all["CpLin1listado1"].style.visibility='';
    document.all["CpLin2listado1"].style.visibility='';
    document.all["CpLin3listado1"].style.visibility='';
    document.all["CpLin4listado1"].style.visibility='';
    document.all["separaDiv"].style.visibility='';
    document.all["primera1Div"].style.visibility='';
    document.all["ret1Div"].style.visibility='';
    document.all["ava1Div"].style.visibility='';
    eval (ON_RSZ);      
    configurarMenuSecundario(FORMULARIO);
}

 
function fVolver(){
	window.returnValue=get(FORMULARIO+'.oidContacto');
 	window.close();            
 }

 

function unLoadPag(){
            window.returnValue=get(FORMULARIO+'.oidContacto');
 }

 
