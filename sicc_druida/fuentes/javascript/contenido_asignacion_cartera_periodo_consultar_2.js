 function onLoadPag()   
    {           
      configurarMenuSecundario("formulario");
      DrdEnsanchaConMargenDcho('listado1',12); 
     
      document.all["Cplistado1"].style.visibility=''; 
      document.all["CpLin1listado1"].style.visibility='';  
      document.all["CpLin2listado1"].style.visibility=''; 
      document.all["CpLin3listado1"].style.visibility='';
      document.all["CpLin4listado1"].style.visibility='';  
      
      document.all["primera1Div"].style.visibility=''; 
      document.all["ret1Div"].style.visibility='';
      document.all["ava1Div"].style.visibility='';  
      document.all["separaDiv"].style.visibility=''; 
          
      eval (ON_RSZ);   
      
      paginado();
         
    }
    
    function paginado(){
		configurarPaginado(mipgndo,"COBDetalleCobranza",
              "ConectorDetalleCobranza",
              "es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOOIDPaginado",
              armaArray());
  }
  
  function fVolver(){
    window.close();
  }
  function armaArray(){
      var arrDatos = new Array();
      var i=0;

      if (get('formulario.hoidCobranza')!=''){
          arrDatos[i] = new Array('oid',get('formulario.hoidCobranza'));
          i++;
      }
      if (get('formulario.hoidPais')!=''){
            arrDatos[i] = new Array('oidPais',get('formulario.hoidPais'));
            i++;
      }    
      if (get('formulario.hoidIdioma')!=''){
            arrDatos[i] = new Array('oidIdioma',get('formulario.hoidIdioma'));
            i++;
      }           
      return arrDatos;      
  }  


  function muestraLista( ultima, rowset){   
    var tamano = rowset.length;   
    if (tamano == 0) {   
		fVolver();
    }else{
		return true;
	}
  }   
