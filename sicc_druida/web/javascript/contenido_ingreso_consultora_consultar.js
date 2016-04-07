var FORMULARIO = "formulario";


function onLoadPag(){
  
  	configurarMenuSecundario(FORMULARIO); 
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
    
   /* Llamamos a 'configurarPaginado' pasándole los siguientes parámetros: 

	Objeto paginado: 
	- idBusiness: "CALObtenerStatusConsultora" 
	- ConectorObtenerStatusConsultora 
	- DTOIngresoConsultora 
	- Parametros del DTO: 
	-oidPais 
	-oidMarca 
	-oidCanal 
	-oidCliente 
	los que el usuario no haya rellenado, se ponen a null
	*/
	var oidMarca = get(FORMULARIO+'.oidMarca');
	var oidCanal = get(FORMULARIO+'.oidCanal');
	var oidCliente = get(FORMULARIO+'.oidCliente');
	var idioma = get(FORMULARIO+'.idioma');
	var pais = get(FORMULARIO+'.pais');         

                 
	var DTOIngresoConsultora = 'es.indra.sicc.dtos.cal.DTOIngresoConsultora';
	         
	configurarPaginado(mipgndo, 'CALObtenerStatusConsultora', 'ConectorObtenerStatusConsultora', 
	DTOIngresoConsultora , [['oidMarca', oidMarca], ['oidCanal', oidCanal], ['oidCliente', oidCliente], ['oidIdioma',idioma], ['oidPais',pais] ] );

}

  function fVolver(){
		window.returnValue=get(FORMULARIO+'.oidContacto');
 		window.close();            

 }

 

  function unLoadPag(){
        window.returnValue=get(FORMULARIO+'.oidContacto');
 }




   
