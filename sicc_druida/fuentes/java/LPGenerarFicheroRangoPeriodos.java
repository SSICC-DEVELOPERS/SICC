import es.indra.sicc.dtos.intsys.DTOCargaInicialInterfaz;
import es.indra.sicc.dtos.ndg.DTOInformacionDeFiltrado;

import es.indra.sicc.logicanegocio.ndg.ConstantesNDG;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.DTOSalida;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;
import es.indra.druida.DruidaBaseComun;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.HashMap;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import es.indra.sicc.dtos.cra.DTOPeriodo;



public class LPGenerarFicheroRangoPeriodos  extends LPSICCBase {
     private HashMap param = new HashMap();
     private String accion = null;  
     private String pais = null;
     private String idioma = null;     
  
  public LPGenerarFicheroRangoPeriodos() {
    super();
  }

  public void inicio() throws Exception {
    pagina("generar_fichero_matriz_precios");
	asignarAtributo("PAGINA","generar_fichero_matriz_precios","cod","0924");

   this.getFormatosValidaciones();
  }


  public void ejecucion() throws Exception {
    
    setTrazaFichero();
    accion     	= conectorParametroLimpia("accion", "", true);
        
    pais 	  	= UtilidadesSession.getPais(this).toString();
    traza("pais >>>>  "  +pais );
      
    idioma  	= UtilidadesSession.getIdioma(this).toString();
    traza("idioma >>>> " + idioma);	
      
    traza("Entro a LP con accion = "+ accion);    

	try{
		if(accion.equals("")){
			traza("va a traer los datos");
      rastreo();

      getConfiguracionMenu("LPGenerarFicheroRangoPeriodos","");

      this.obtenerValoresPorDefecto();
      
      
			cargarCombosMarcaCanal();
      
      
			traza("ya los trajos");

      asignarAtributo("VAR", "hidIdioma", "valor", UtilidadesSession.getIdioma(this).toString() );
      asignarAtributo("VAR", "hidPais", "valor", UtilidadesSession.getPais(this).toString() );
      asignarAtributo("VAR", "hidCanal", "valor", UtilidadesSession.getCanalPorDefecto(this).toString() );
      asignarAtributo("VAR", "hidMarca", "valor", UtilidadesSession.getMarcaPorDefecto(this).toString() );


      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
      Date fechaActual = new Date();
      traza("Fecha actual: " + fechaActual);
      String fechaFormateada = sdf.format(fechaActual);
      traza("esta es la fecha formateada: " + fechaFormateada);
      asignarAtributo("VAR", "hidFechaSistema", "valor", fechaFormateada);

			asignarAtributo("VAR","casoDeUso","valor","RangoPeriodos");
		}else if(accion.equals("RangoPeriodos")){
			pagina("salidaGenerica");
			generarFicheroRangoPeriodos();
		}
	}catch(Exception e){
		logStackTrace(e);
		this.lanzarPaginaError(e);
	}
}



	private void obtenerValoresPorDefecto() throws Exception {
        traza("Seteo al Carga Inicial de la Interfaz");


          DTOString dtos = new DTOString();

          traza("Seteo el idioma al dtos" + idioma);
          
          dtos.setOidIdioma(new Long(idioma));
          
          traza("Seteo el pais al dtos" + pais);
          
          dtos.setOidPais(new Long(pais));
          
          
          dtos.setCadena(ConstantesNDG.NDG_INTERFAZ_PERIODO);
          traza("dtos >>>> " + dtos);
                
          traza("antes de setea businessid");

        MareBusinessID idBusiness  = new MareBusinessID("INTCargaInicialInterfaz");

        Vector params = new Vector();
        params.add( dtos );
        params.add( idBusiness );
        traza("antes de llamar al conector");
        DruidaConector con = conectar("ConectorObjeto", params);
        traza("despues de conector");
        
        DTOCargaInicialInterfaz dtocii = (DTOCargaInicialInterfaz)con.objeto("DTOSalida");
        
        traza("antes de asignar a la pantalla");

        asignarAtributo("LABELC", "lblvalorLote", "valor", (dtocii.getNumeroLote()==null? "": dtocii.getNumeroLote().toString()));
        asignarAtributo("VAR", "descripcionH", "valor", (dtocii.getDescripcion()==null? "": dtocii.getDescripcion()));
        asignarAtributo("VAR", "loteH", "valor", (dtocii.getNumeroLote()==null? "": dtocii.getNumeroLote().toString()));

	}



  public void generarFicheroRangoPeriodos () throws Exception {

		traza("entro a generarFicheroRangoPeriodos");
    
    
    String lote = conectorParametro("loteH");
    traza("lote**** " + lote);
     
    String descripcion = conectorParametro("descripcionH");
    traza("descripcion**** " + descripcion);
                      
    String observaciones = conectorParametro("observacionesH");
    traza("observaciones**** " + observaciones);
                      

    DTOInformacionDeFiltrado dtoInfoFiltrado = new DTOInformacionDeFiltrado();
    traza("Pais " + UtilidadesSession.getPais(this));
    dtoInfoFiltrado.setPais(UtilidadesSession.getPais(this));

    traza("Usuario " + UtilidadesSession.getIdUsuario(this));
    dtoInfoFiltrado.setCodUsuario(UtilidadesSession.getIdUsuario(this));
        
        
    String marca = conectorParametro("marca");
    traza("cbMarca**** " + marca);
        
    dtoInfoFiltrado.setOidMarca(new Long(marca));
       
    String canal = conectorParametro("canal");
    traza("cbCanal**** " + canal);
    dtoInfoFiltrado.setOidCanal(new Long(canal));
        
    String acceso = conectorParametro("acceso"); 
    traza("cbAcceso**** " + acceso);
    if (!acceso.equals(""))
    {      
       dtoInfoFiltrado.setOidAcceso(new Long(acceso));
    }else 
    {
       dtoInfoFiltrado.setOidAcceso(null);
    }
                
    String desde = conectorParametro("desde");
    traza("cbPeriodoDesde**** " + desde);
    dtoInfoFiltrado.setOidPeriodoDesde(new Long(desde));
                
    dtoInfoFiltrado.setNumeroLote(new Long(lote));
                      
    if (!observaciones.equals("")){
           dtoInfoFiltrado.setObservacionesLote(observaciones);
    } 
                      
    if (!descripcion.equals("")){
            dtoInfoFiltrado.setDescripcionLote(descripcion);
    }        

        
    String hasta = conectorParametro("hasta");
    traza("cbPeriodoHasta**** " + hasta);

    if(param.get("cbPeriodoHasta")!=null ){            
        dtoInfoFiltrado.setOidPeriodoHasta(new Long(hasta));
    } else
    {
         dtoInfoFiltrado.setOidPeriodoHasta(null);
    }

    Vector objBussines = new Vector();
    MareBusinessID id = new MareBusinessID("NDGGenerarFicheroRangoPeriodos");
    traza(" variable in " + dtoInfoFiltrado.toString());
    objBussines.add(dtoInfoFiltrado);
    objBussines.add(id);
		traza("va a conectar NDGGenerarFicheroRangoPeriodos");
        DruidaConector con = conectar("ConectorGenerarFicheroRangoPeriodos", objBussines);
		traza("conecto");
    asignarAtributo("VAR", "ejecutar", "valor", "ok()");
    conectorAction("LPInicioBelcorp");
    conectorActionParametro("accion","");        
    
  }



  //Carga combos MARCA, CANAL, .... Debe reemplazar al metodo obtenerInformacionCriteriosDeSeleccion
  private void cargarCombosMarcaCanal() throws Exception {
    DTOBelcorp dtoe = new DTOBelcorp();
    dtoe.setOidPais( UtilidadesSession.getPais( this ) );
    dtoe.setOidIdioma( UtilidadesSession.getIdioma( this ) );

    ComposerViewElementList lista = new ComposerViewElementList();

    ComposerViewElement ci1 = new ComposerViewElement();
    ci1.setIDBusiness( "SEGConsultaCanales" );
    ci1.setDTOE( dtoe );
    
    ComposerViewElement ci2 = new ComposerViewElement();
    ci2.setIDBusiness( "SEGConsultaMarcas" );
    ci2.setDTOE( dtoe );



    /*
  	DTOPeriodo dtop = new DTOPeriodo();
  	dtop.setPais(es.indra.sicc.util.UtilidadesSession.getPais(this));
  	dtop.setMarca(UtilidadesSession.getMarcaPorDefecto(this));
  	dtop.setCanal(UtilidadesSession.getCanalPorDefecto(this));
  	dtop.setFechaInicio(new java.sql.Date(System.currentTimeMillis()));

    ComposerViewElement ci3 = new ComposerViewElement();
    ci3.setIDBusiness( "CRAObtienePeriodosFecha" );//CRAObtenerPeriodos
    ci3.setDTOE( dtop );
    */  
    lista.addViewElement( ci1 );
    lista.addViewElement( ci2 );
    //lista.addViewElement( ci3 );

	//Utilizamos el subsistema
	ConectorComposerView conector = new ConectorComposerView(lista, this.getRequest());
	conector.ejecucion();
    DruidaConector resultados = null;
    resultados = conector.getConector();
    
    asignar("COMBO", "cbMarca", resultados, "SEGConsultaMarcas");
    asignar("COMBO", "cbCanal", resultados, "SEGConsultaCanales");
    //asignar("COMBO", "cbPeriodoDesde", resultados, "CRAObtienePeriodosFecha");//CRAObtenerPeriodos
    //asignar("COMBO", "cbPeriodoHasta", resultados, "CRAObtienePeriodosFecha");//CRAObtenerPeriodos
  }



  private void logStackTrace(Throwable e) throws Exception {
        traza("Se produjo la excepcion: " + e.getMessage());
 
        ByteArrayOutputStream pila = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(pila);
 
        if (e instanceof MareException) {
            MareException e2 = (MareException) e;
            traza("Es una mare Exception con codigo de error: " + e2.getCode());
        }
 
        e.printStackTrace(out);
        traza("stack Trace : " + pila.toString());
    }
}
