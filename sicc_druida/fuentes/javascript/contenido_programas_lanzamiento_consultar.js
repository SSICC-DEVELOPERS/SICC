var FORMULARIO = 'formulario';
  function onLoadPag()   {
    DrdEnsanchaConMargenDcho('listado1',12);
    eval (ON_RSZ);  
 
    configurarMenuSecundario(FORMULARIO); 
    var pais = get(FORMULARIO+'.pais');
    var idioma = get(FORMULARIO+'.idioma');
    configurarPaginado(mipgndo, "CALConsultarProgramasLanzamiento", 
    "ConectorConsultarProgramasLanzamiento", "es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion",
    [["oidPais",pais], ["oidIdioma", idioma ]]);
    
   }
   
  function fVolver(){
  		window.returnValue=get(FORMULARIO+'.oidContacto');
        window.close();	
	}

function unLoadPag(){
	window.returnValue=get(FORMULARIO+'.oidContacto');
}