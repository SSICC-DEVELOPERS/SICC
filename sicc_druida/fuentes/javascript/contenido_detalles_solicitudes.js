function onLoadPag() {
	  configurarMenuSecundario("frmFormulario");
	  asignarLabels();

	  mostrarListasResultados();                  
	  cargarListaDetalleSolicitudes(); 
	  configurarBotones();
 }

 function configurarBotones() {
		   btnProxy(2,'1');
		   btnProxy(3,'0');
		   btnProxy(5,'0');
		   btnProxy(7,'0');
		   btnProxy(8,'0');
		   btnProxy(9,'0');
 }
 
 function fVolver() {
		  window.close();
 }

 function asignarLabels(){
		  txt_to('lbldtCodCliente', get("frmFormulario.laCodigoCliente"));
		  txt_to('lbldtNombreApellido', get("frmFormulario.laNombreApellido"));
		  txt_to('lbldtNumConcurso', get("frmFormulario.laNumeroConcurso"));
		  txt_to('lbldtDescripcion', get("frmFormulario.laDescripcionConcurso"));
 }

 function mostrarListasResultados() { 
	 DrdEnsanchaConMargenDcho('listado1',12);	   
	 eval (ON_RSZ)
 }

 function cargarListaDetalleSolicitudes() {
		  var arr = new Array();
		  arr[arr.length] = new Array("oidConcurso", get("frmFormulario.oidConcurso")+"");
		  arr[arr.length] = new Array("oidCliente", get("frmFormulario.oidCliente")+"");
		  arr[arr.length] = new Array("numeroConcurso", get("frmFormulario.lanumeroConcurso")+"");
		  arr[arr.length] = new Array("oidRegion", get("frmFormulario.oidRegion")+""); 
		  arr[arr.length] = new Array("oidZona", get("frmFormulario.oidZona")+"");
		  arr[arr.length] = new Array("oidSeccion", get("frmFormulario.oidSeccion")+""); 
		  arr[arr.length] = new Array("oidPais", get("frmFormulario.oidPais")+"");
		  arr[arr.length] = new Array("oidIdioma", get("frmFormulario.oidIdioma")+"");
		  
		  configurarPaginado(mipgndo,"INCConsultarDetalleSolicitudes",
														"ConectorConsultarDetalleSolicitudes","es.indra.sicc.dtos.inc.DTOCabeceraConsultaIntegral",arr);		
 }

        