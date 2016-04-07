/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

import es.indra.sicc.cmn.negocio.interfaces.IGestorInterfaces;
import es.indra.sicc.dtos.intsys.DTOCargaInicialInterfaz;
import es.indra.sicc.dtos.intsys.DTOInterfaz;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.dto.IMareDTO;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.ndg.DTOInformacionDeFiltrado;
import es.indra.sicc.util.DTOString;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgu.manager.Property;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.cra.DTOPeriodo;

import es.indra.sicc.cmn.presentacion.rastreador.Rastreador;
import es.indra.sicc.cmn.presentacion.rastreador.IRastreador;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import es.indra.sicc.util.UtilidadesSession;

//Librerias druida
import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;
import es.indra.druida.DruidaBaseComun;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import es.indra.sicc.dtos.cra.DTOPeriodo;

 public class LPGenerarFicheroMatrizPrecios extends LPSICCBase {
     private HashMap param = new HashMap();
     private String accion = null;  
     private String pais = null;
     private String idioma = null;     
     
     public LPGenerarFicheroMatrizPrecios() {
        super();
    }

    public void inicio() throws Exception {
      pagina("generar_fichero_matriz_precios");
       //asignarAtributo("PAGINA","generar_fichero_matriz_precios","cod","0925");
       //asignarAtributo("PAGINA","generar_fichero_matriz_precios","titulo","0925");
       //this.getConfiguracionMenu("LPGenerarFicheroMatrizPrecios","");
       this.getFormatosValidaciones();
	}

	  public void ejecucion() throws Exception {
      
        setTrazaFichero();
        accion     	= conectorParametroLimpia("accion", "", true);
        traza("accion>>>> " + accion);
        
        pais 	  	= UtilidadesSession.getPais(this).toString();
        traza("pais >>>>  "  +pais );
        
        idioma  	= UtilidadesSession.getIdioma(this).toString();
        traza("idioma >>>> " + idioma);	
      

        traza("Entro a LP con accion = "+ accion);
        
     // this.getConfiguracionMenu();
      try{
      
            traza("antes de cargar>>>>");	
            rastreo();
            
            getConfiguracionMenu("LPGenerarFicheroMatrizPrecios","");

            asignarAtributo("VAR","hidPais","valor",pais);
            asignarAtributo("VAR","hidIdioma","valor",idioma);	     
            
            traza("accion>>>> " + accion);      
        
          if(accion.equals("")){
              traza("va a traer los datos this.obtenerValoresPorDefecto() ");
          
              this.obtenerValoresPorDefecto();
            
              this.cargarCombosMarcaCanal();
      
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
              asignarAtributo("VAR","casoDeUso","valor","MatrizPrecios");	
            //obtenerInformacionCriteriosDeSeleccion();
                  traza("y alos trajos");
            
           
          }
          if(accion.equals("GenerarFichero")){
           pagina("salidaGenerica");
           this.generarFicherosMatrizPrecios(); 
          }
         }catch (Exception ex) {
          this.traza("Error en ejecucion");
          this.lanzarPaginaError(ex);
         }
        
         
    }


//*************Metodos de la clase****************
	private void obtenerValoresPorDefecto() throws Exception {
        traza("Seteo al Carga Inicial de la Interfaz");


          DTOString dtos = new DTOString();

          traza("Seteo el idioma al dtos" + idioma);
          
          dtos.setOidIdioma(new Long(idioma));
          
          traza("Seteo el pais al dtos" + pais);
          
          dtos.setOidPais(new Long(pais));
          
          dtos.setCadena(IGestorInterfaces.NDG_2);

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

    private void cargarCombosMarcaCanal() throws Exception {
		traza("Entrada a cargar combos marca canal");
		DTOBelcorp dtoe = new DTOBelcorp();
        
        traza("Pais" + this.pais);
        traza("Idioma" + this.idioma);
        
        dtoe.setOidPais( UtilidadesSession.getPais( this ) );
        dtoe.setOidIdioma( UtilidadesSession.getIdioma( this ) );

        ComposerViewElementList lista = new ComposerViewElementList();

        ComposerViewElement ci2 = new ComposerViewElement();
        ci2.setIDBusiness( "SEGConsultaMarcas" );
        ci2.setDTOE( dtoe );

        ComposerViewElement ci1 = new ComposerViewElement();
        ci1.setIDBusiness( "SEGConsultaCanales" );
        ci1.setDTOE( dtoe );

        /*DTOPeriodo dtop = new DTOPeriodo();
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
    
            asignar("COMBO", "cbCanal", resultados, "SEGConsultaCanales");
            asignar("COMBO", "cbMarca", resultados, "SEGConsultaMarcas");
        /*asignar("COMBO", "cbPeriodoDesde", resultados, "CRAObtienePeriodosFecha");//CRAObtenerPeriodos
        asignar("COMBO", "cbPeriodoHasta", resultados, "CRAObtienePeriodosFecha");//CRAObtenerPeriodos*/
    }

//-----------------------------------------------------------------
    private void generarFicherosMatrizPrecios()throws Exception{

         String lote = conectorParametro("loteH");
     
         String descripcion = conectorParametro("descripcionH");
                      
         String observaciones = conectorParametro("observacionesH");
                      

        DTOInformacionDeFiltrado dtoInfoFiltrado = new DTOInformacionDeFiltrado();
      
        dtoInfoFiltrado.setPais(UtilidadesSession.getPais(this));

        dtoInfoFiltrado.setCodUsuario(UtilidadesSession.getIdUsuario(this));
        
        
        String marca = conectorParametro("marca");
        
        dtoInfoFiltrado.setOidMarca(new Long(marca));
        
        String canal = conectorParametro("canal");
        dtoInfoFiltrado.setOidCanal(new Long(canal));
        
        String acceso = conectorParametro("acceso"); 
        traza("cbAcceso**** " + acceso + "********");
        if (acceso != null && acceso.toString().trim().length() >0){		                  
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
		//Se cambia para que vaya lo de batch	
		//MareBusinessID id = new MareBusinessID("NDGGenerarFicherosMatrizPrecios");
        MareBusinessID id = new MareBusinessID("NDGGenerarFicherosMatrizPreciosBatch");
        traza(" variable in " + dtoInfoFiltrado.toString());
        objBussines.add(dtoInfoFiltrado);
        objBussines.add(id);		
        DruidaConector con = conectar("ConectorGenerarFicheroMatrizPrecios", objBussines);
//		DruidaConector con = conectar("ConectorGenerarFicheroRangoPeriodos", objBussines);
        
        asignarAtributo("VAR", "ejecutar", "valor", "ok()");
        
        conectorAction("LPInicioBelcorp");
        conectorActionParametro("accion","");

    }
//-----------------------------------------------------------------

  ComposerViewElementList getConectores(String negocio,Object objto,String clase,int posOid, int posDesc)throws Exception{
     ComposerViewElementList lista = new ComposerViewElementList();
    
     Class c = Class.forName(clase);
     Object Dto = c.newInstance();
     Dto = objto;
     ComposerViewElement c1 = new ComposerViewElement();
     ComposerViewElement c2 = new ComposerViewElement();
     ComposerViewElement c3 = new ComposerViewElement();
     ComposerViewElement c4 = new ComposerViewElement();
     ComposerViewElement c5 = new ComposerViewElement();
     
     c1.setIDBusiness(negocio);
     c1.setDTOE((DTOBelcorp)Dto);
     c1.setPosOID((byte)posOid);
     c1.setPosDesc((byte)posDesc);

    

     lista.addViewElement(c1);
     

     return lista;
  }

  private void obtenerInformacionCriteriosDeSeleccion() throws Exception{
        DTOInformacionDeFiltrado in = new DTOInformacionDeFiltrado();
        in.setPais(UtilidadesSession.getPais(this));
        in.setCodUsuario(UtilidadesSession.getIdUsuario(this));
        ComposerViewElementList marca = this.getConectores("NDGObtenerInformacionCriteriosDeSeleccion",(DTOInformacionDeFiltrado)in ,"es.indra.sicc.dtos.ndg.DTOInformacionDeFiltrado",0,1);
        ComposerViewElementList canal = this.getConectores("NDGObtenerInformacionCriteriosDeSeleccion",(DTOInformacionDeFiltrado)in ,"es.indra.sicc.dtos.ndg.DTOInformacionDeFiltrado",2,3);
        ComposerViewElementList acceso = this.getConectores("NDGObtenerInformacionCriteriosDeSeleccion",(DTOInformacionDeFiltrado)in ,"es.indra.sicc.dtos.ndg.DTOInformacionDeFiltrado",4,5);
        ComposerViewElementList periodo = this.getConectores("NDGObtenerInformacionCriteriosDeSeleccion",(DTOInformacionDeFiltrado)in ,"es.indra.sicc.dtos.ndg.DTOInformacionDeFiltrado",6,7);

        
        ConectorComposerView conectorMarca = new ConectorComposerView(marca,this.getRequest());
        ConectorComposerView conectorCanal = new ConectorComposerView(canal,this.getRequest());
        ConectorComposerView conectorAcces = new ConectorComposerView(acceso,this.getRequest());
        ConectorComposerView conectorPeri = new ConectorComposerView(periodo,this.getRequest());
        conectorMarca.ejecucion();
        conectorCanal.ejecucion();
        conectorAcces.ejecucion();
        conectorPeri.ejecucion();
        
        DruidaConector rMarca = conectorMarca.getConector();
        DruidaConector rCanal = conectorCanal.getConector();
        DruidaConector rAcces = conectorAcces.getConector();
        traza(rAcces.getXML());
        DruidaConector rPeri1 = conectorPeri.getConector();
       



        
         asignar("COMBO","cbMarcaAux",rMarca,"NDGObtenerInformacionCriteriosDeSeleccion");
         asignar("COMBO","cbCanalAux",rCanal,"NDGObtenerInformacionCriteriosDeSeleccion");
         asignar("COMBO","cbAcc",rAcces,"NDGObtenerInformacionCriteriosDeSeleccion");
         asignar("COMBO","cbDsde",rPeri1,"NDGObtenerInformacionCriteriosDeSeleccion");
         asignar("COMBO","cbHasta",rPeri1,"NDGObtenerInformacionCriteriosDeSeleccion");
         asignarAtributo("VAR","casoDeUso","valor","MatrizPrecios");

        
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
