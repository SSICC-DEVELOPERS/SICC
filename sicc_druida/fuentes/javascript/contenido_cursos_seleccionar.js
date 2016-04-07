/**
* Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
* Avda. de Bruselas, 35
* Parque Empresarial Arroyo de la Vega
* 28108 Alcobendas, Madrid
* España
*
* Privado y Confidencial.
* La información contenida en este documento es propiedad de Indra sistemas.
* Para uso exclusivo de empleados autorizados no permitiéndose
* la distribución de este código sin permiso expreso.
*/ 

/*
    INDRA/CAR/PROY
    $Id: contenido_cursos_seleccionar.js,v 1.1 2009/12/03 19:02:10 pecbazalar Exp $
    DESC
*/
	function onLoadPag()   {
  
		configurarMenuSecundario('frmContenido');
    	DrdEnsanchaConMargenDcho('listado1',12);

    	eval (ON_RSZ);  
    	var idioma = get('frmContenido.idioma').toString();
		configurarPaginado(mipgndo, "EDUConsultaPlantilla", "ConectorObtienePlantilla", "es.indra.sicc.dtos.edu.DTOPlantillaCurso", [["oidIdioma", idioma]] );     
	}

	function fGuardar()  {
		if (listado1.numSelecc() > 0 ){
			var objParams = new Object();
			objParams.listado1=listado1.codSeleccionados();
			objParams.casoUso="insertar";
			mostrarModalSICC('LPInsertaCurso', 'aceptar', objParams, null, null);

			/*set('frmContenido.accion','aceptar');
			set('frmContenido.conectorAction',"LPInsertaCurso");
			enviaSICC('frmContenido');*/
		} else {
			GestionarMensaje('50');
		}

	}

function muestraLista(ultima, rowset) {
         var tamano = rowset.length;
         if (tamano > 0) {
                  return true;
         } else {
                  return false;
         }
}
