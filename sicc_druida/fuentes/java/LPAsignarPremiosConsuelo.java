import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.inc.DTOPremConsueloFichero;
import es.indra.sicc.dtos.inc.DTOPremioDetalle;
import es.indra.sicc.dtos.mae.DTOBusquedaMateriales;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.druida.DruidaConector;
import es.indra.sicc.dtos.inc.DTOPremiosConsuelo;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.logicanegocio.inc.ConstantesINC;
import es.indra.druida.Contexto;
import es.indra.sicc.util.DTOOID;
import java.util.StringTokenizer;
import es.indra.sicc.util.UtilidadesSession;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Vector;
import java.io.FileReader;
import java.io.BufferedReader;
import es.indra.sicc.util.DTOOIDs;
import java.util.HashMap;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

public class LPAsignarPremiosConsuelo extends LPSICCBase { 
    
    private String accion = null; 
  
    public LPAsignarPremiosConsuelo() {
                  super(); 
    }

    public void inicio() throws Exception {                 
         pagina("contenido_premios_consuelo_asignar");
    }

    public void ejecucion() throws Exception {
      setTrazaFichero();
      try{
           
           accion = conectorParametro("accion")==null?"":conectorParametro("accion"); 
           traza(">>>> Acción................" + accion);                     
         
           if (accion.equals("")){
                this.inicializar(); 
           }else if (accion.equals("Concurso")){
                this.inicializarConcurso();
           } else if (accion.equals("Cliente")){    
                this.inicializarClientes();
           }else if (accion.equals("Fichero")){
                this.inicializarFichero();                
           }else if (accion.equals("procesarFichero")){
                this.procesarFichero(); 
           }else if(accion.equals("busqueda")){
                this.busquedaProd();
           }else if(accion.equals("guardar")){
                this.guardarPremioConsuelo();
           }
         
      asignarAtributo("VAR","accion","valor", this.accion);
      
      }//fin del try
      catch(Exception ex) {
             logStackTrace(ex);
             this.lanzarPaginaError(ex);
         }
    }
    
    
    
    private void logStackTrace(Throwable e) throws Exception {
         traza("Se produjo la excepcion, en LPAsignarPremiosConsuelo: " + e.getMessage());
         ByteArrayOutputStream pila = new ByteArrayOutputStream();
         PrintStream out = new PrintStream(pila);
        
         if (e instanceof MareException){
             MareException e2=(MareException)e;
             traza("Es una mare Exception con codigo de error: "+e2.getCode());
         }
        
         e.printStackTrace(out);
         traza("stack Trace : " +  pila.toString());
    }
    
  public void busquedaProd() throws Exception{
                  traza("LPAsignarPremiosConsuelo.busquedaProd() - Entrada");      
    
    pagina("contenido_premios_consuelo_busqueda");    
    getConfiguracionMenu("LPAsignarPremiosConsuelo" , "busqueda");
    
    // Validaciones
    getFormatosValidaciones();
    
    ComposerViewElementList cv = crearParametrosEntrada();
    ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
    traza("antes del conector.ejecucion");
    conector.ejecucion();
    traza("despues del conector");
    DruidaConector resultados = conector.getConector();
          
    asignar("COMBO","cbCenServGar",resultados,"INCObtenerCentroServicio");   
    asignar("COMBO","cbCenServEntrega",resultados,"INCObtenerCentroServicio");      
    
    traza("LPAsignarPremiosConsuelo.busquedaProd() - Salida");             
  }    
  
  private ComposerViewElementList crearParametrosEntrada() throws Exception{
      traza("metodo ComposerViewElementList");
      
      ComposerViewElementList lista = new ComposerViewElementList();
      //Combo Codigo configuracion
      ComposerViewElement descripcionesCS = new ComposerViewElement();
  
      DTOBelcorp dtoBel = new DTOBelcorp();
      traza("antes de asignar al dtobelcorp");
      dtoBel.setOidPais(UtilidadesSession.getPais(this));
            
      descripcionesCS.setIDBusiness("INCObtenerCentroServicio");
      descripcionesCS.setDTOE(dtoBel);
            
      lista.addViewElement(descripcionesCS);
      
      return lista;
    }
   
    
         public void inicializar() throws Exception{
                  traza("LPAsignarPremiosConsuelo.inicializar() - Entrada");         
         
         this.getFormatosValidaciones();  
         getConfiguracionMenu("LPAsignarPremiosConsuelo" , "");
         asignarAtributoPagina("cod", "0503");         
         
         DTOBelcorp dtob = new DTOBelcorp();
         dtob.setOidIdioma(UtilidadesSession.getIdioma(this));
         dtob.setOidPais(UtilidadesSession.getPais(this));
     
         DTOBusquedaMateriales dtoBusMat = new DTOBusquedaMateriales();
         dtoBusMat.setOidIdioma(UtilidadesSession.getIdioma(this));
         dtoBusMat.setOidPais(UtilidadesSession.getPais(this));     
     
         ComposerViewElementList cvEL = new ComposerViewElementList();
         
         ComposerViewElement ci1 = new ComposerViewElement();
         ci1.setIDBusiness("INCObtenerEnviarA");
         ci1.setDTOE(dtob);
         cvEL.addViewElement(ci1);

         ComposerViewElement ci2 = new ComposerViewElement();
         ci2.setIDBusiness("INCObtenerMotivosPremiosConsuelo");
         ci2.setDTOE(dtob);
         cvEL.addViewElement(ci2);         
         
         ConectorComposerView conector = new ConectorComposerView(cvEL,this.getRequest());
         conector.ejecucion();
         DruidaConector resultados = conector.getConector();
    
         asignar("COMBO", "cbEnviarA", resultados, "INCObtenerEnviarA");
         asignar("COMBO", "cbMotivo", resultados, "INCObtenerMotivosPremiosConsuelo");
         
         asignarAtributo("VAR","constanteCapturaFichero","valor", 
                  ConstantesINC.PREMIOS_CONSUELO_FICHERO.toString());
         
                  asignarAtributo("VAR","constanteClientes","valor", 
                  ConstantesINC.PREMIOS_CONSUELO_CLIENTES.toString());
         
                  asignarAtributo("VAR","constanteNumeroConcurso","valor",  ConstantesINC.PREMIOS_CONSUELO_NRO_CONCURSO.toString()); 
         traza("LPAsignarPremiosConsuelo.inicializar() - Salida");              
     }
     
     public void inicializarConcurso() throws Exception{
          traza("en el inicio del metodo inicializarConcurso");
          
          pagina("contenido_premios_consuelo_enviar");
          this.getFormatosValidaciones();   
          getConfiguracionMenu("LPAsignarPremiosConsuelo", "");
          asignarAtributoPagina("cod", "0503");
             
          DTOBelcorp dtob = new DTOBelcorp();
          dtob.setOidIdioma(UtilidadesSession.getIdioma(this));
          dtob.setOidPais(UtilidadesSession.getPais(this));
     
          ComposerViewElementList cvEL = new ComposerViewElementList();

          ComposerViewElement ci1 = new ComposerViewElement();
          ci1.setIDBusiness("INCObtenerConcursoGanadoras");
          ci1.setDTOE(dtob);
          cvEL.addViewElement(ci1);
          
          ConectorComposerView conector = new ConectorComposerView(cvEL,this.getRequest());
          conector.ejecucion();
          DruidaConector resultados = conector.getConector();
          
          traza("antes de asignar al combo cbNumConcurso");
          //cbClientes
          accion = conectorParametro("accion")==null?"":conectorParametro("accion"); 
          asignar("COMBO", "cbNumConcurso", resultados, "INCObtenerConcursoGanadoras");  
          asignarAtributo("VAR", "capa", "valor", "Concurso");
     
     }
     
     public void inicializarClientes() throws Exception{
          traza("en el inicio del metodo inicializarClientes");
          
          pagina("contenido_premios_consuelo_enviar");
          this.getFormatosValidaciones();           
          
          getConfiguracionMenu("LPAsignarPremiosConsuelo", "");          
          asignarAtributoPagina("cod", "0503");
         
          DTOBelcorp dtob = new DTOBelcorp();
          dtob.setOidIdioma(UtilidadesSession.getIdioma(this));
          dtob.setOidPais(UtilidadesSession.getPais(this));
     
          ComposerViewElementList cvEL = new ComposerViewElementList();

          ComposerViewElement ci1 = new ComposerViewElement();
          ci1.setIDBusiness("INCObtenerClientesGanadoras");
          ci1.setDTOE(dtob);
          cvEL.addViewElement(ci1);
          
          ConectorComposerView conector = new ConectorComposerView(cvEL,this.getRequest());
          conector.ejecucion();
          DruidaConector resultados = conector.getConector();
          
          //cbClientes
          asignar("COMBO", "cbClientes", resultados, "INCObtenerClientesGanadoras");  
          accion = conectorParametro("accion")==null?"":conectorParametro("accion"); 
          
          
          asignarAtributo("VAR", "capa", "valor", "Cliente");
     }
     
     public void inicializarFichero() throws Exception{
     
     
          pagina("contenido_premios_consuelo_enviar");
          getConfiguracionMenu("LPAsignarPremiosConsuelo", "");
          asignarAtributoPagina("cod", "0503");          
          asignarAtributo("VAR", "capa", "valor", "Fichero");        
     
     }
     
     public void procesarFichero() throws Exception{
         pagina("salidaGenerica");
         asignarAtributo("VAR", "cerrarVentana", "valor", "false");
         traza("en la funcion procesarFichero ");   
      
         String nombreArchivo = Contexto.getPropiedad("TMP.UPLOAD2") + "/" + conectorParametroLimpia("clientesFicheroSeleccionados", "", true);;
         traza("nombreArchivo " + nombreArchivo);
                
         
                  String s;
                  
                  // Inserto el contenido de texto en el ArrayList lista.
                  FileReader fr = new FileReader(nombreArchivo);
         
                  BufferedReader entrada = new BufferedReader(fr);
         
         String dato = new String();
         
                  while ((s = entrada.readLine())!= null) {
             traza("s: "+ s);
                           StringTokenizer st = new StringTokenizer(s, ";");
                  
                  String valorTres = new String();
                  String valor = new String();
                  
                  if (st.hasMoreTokens())                   
                      valor = st.nextToken(); 
                      
                  traza("valor: " + valor);
                  
                  if (st.hasMoreTokens())                      
                     valorTres = ";" + st.nextToken();
                      
                  traza("valorTres: " + valorTres);
                  
                  dato = dato + valor + valorTres + "|";
                  traza("datol parcial: " + dato);
         }
         
         
         traza("dato Final: " + dato);
         
         // Cierro el fichero.
                  fr.close();
                  traza("cerrado fichero");
      
         asignarAtributo("VAR","clientesFicheroSeleccionados","valor",dato );
         asignarAtributo("VAR","ejecutar","valor","tomaValores('" +dato + "')");
         traza("hasta aca******");
         
         asignarAtributo("VAR","accion","valor", "Fichero");
     
     
     
     } //--procesarFichero
     
     
     //Incidencia BELC300023493
     //cvalenzu     
          //23/08/2006

     //Incidencia BELC300023491
     //cvalenzu     
          //6/10/2006
     public void guardarPremioConsuelo() throws Exception{         
         pagina("salidaGenerica");
         traza("LPAsignarPremiosConsuelo.guardarPremioConsuelo() - Entrada");
         asignarAtributo("VAR", "cerrarVentana", "valor", "false");
         
         DTOPremiosConsuelo dtoPremioConsuelo = new DTOPremiosConsuelo();         
         dtoPremioConsuelo.setOidIdioma(UtilidadesSession.getIdioma(this));
         dtoPremioConsuelo.setOidPais(UtilidadesSession.getPais(this));     
     
         Boolean puedeGuardar = Boolean.FALSE;
         
                  //**************************************************************************
                  //oids del combo
         //String premiosConsuelo = conectorParametroLimpia("cbPremiosConsuelo", "", true);
                  String premiosConsuelo = conectorParametroLimpia("premiosConsuelo", "", true);
         traza("***** premiosConsuelo " + premiosConsuelo ); 
         
                  //descripciones del combo
         String descPremioConsuelo = conectorParametroLimpia("desPremioConsuelo", "", true);         
         traza("***** descPremioConsuelo " + descPremioConsuelo );                  
         
         // Definir un HashMap
         HashMap global = new HashMap();         
         ArrayList premConsuelo = new ArrayList();
         StringTokenizer tokFilas = new StringTokenizer(premiosConsuelo, "|");
         StringTokenizer tokCampos = null;                  
         StringTokenizer tokFilasDes = new StringTokenizer(descPremioConsuelo, "|");
         StringTokenizer tokCamposDes = null;
      
         int y=0;
         String dato= new String();
         
         while (tokFilas.hasMoreTokens()){ //--inc while         
            // Obtengo la fila
            String sFila = tokFilas.nextToken();
            traza("sFila: " + sFila);                   
            
            if (y==0){            
                  String a = tokFilasDes.nextToken();
                  traza("valor de a " + a);
                  tokCamposDes = new StringTokenizer(a, ",");                   
                  
                  dato = tokCamposDes.nextToken();
                  traza("dato - " + dato);
                  
                  y++;
                  global.put(Long.valueOf(sFila), dato);                  
            }
                     else{            
                  dato = tokCamposDes.nextToken();
                  traza("dato sss " + dato);                  
                  global.put(Long.valueOf(sFila), dato);           
            }
            
                     traza("global *" + global);                 
         }//--Fin while
                
         traza("global " + global);
         dtoPremioConsuelo.setLstPremiosConsuelo(global);        
   
         // Detalles
         String premiosDetalles = conectorParametroLimpia("premiosDetalles", "", true);         
         traza("***** premiosDetalles " + premiosDetalles );  
         
         ArrayList detalles = new ArrayList();
         StringTokenizer stkListaDetalles = new StringTokenizer(premiosDetalles,"|");
         StringTokenizer stkRegDetalle = null;
         StringTokenizer stkDatosDetalle = null;
         Long oidProducto = null;
         DTOPremioDetalle dtoPremioDetalle = null;
         String indCenServGar = null;
         String oidCentroServGar = null;
         String numMeses = null;
         String observacionesDet = null;
         String indTipoEntrega = null;  
         String oidCentroServEntrega = null;
         
         while (stkListaDetalles.hasMoreTokens()) {
             stkRegDetalle = new StringTokenizer(stkListaDetalles.nextToken(),"&");
             
             dtoPremioDetalle = new DTOPremioDetalle();
             
             oidProducto = Long.valueOf(stkRegDetalle.nextToken());             
             dtoPremioDetalle.setOidProducto(oidProducto);
             
             stkDatosDetalle = new StringTokenizer(stkRegDetalle.nextToken(),"#");
             
             indCenServGar = stkDatosDetalle.nextToken();
             dtoPremioDetalle.setIndCentroServGar(indCenServGar.equals("S")?Boolean.TRUE:Boolean.FALSE);
             
             oidCentroServGar = stkDatosDetalle.nextToken();
             dtoPremioDetalle.setOidCentroServGar(oidCentroServGar.equals("BLANCO")?null:Long.valueOf(oidCentroServGar));
             
             numMeses = stkDatosDetalle.nextToken();
             dtoPremioDetalle.setNumMeses(numMeses.equals("BLANCO")?null:Integer.valueOf(numMeses));
             
             observacionesDet = stkDatosDetalle.nextToken();
             dtoPremioDetalle.setObservaciones(observacionesDet.equals("BLANCO")?null:observacionesDet);
             
             indTipoEntrega = stkDatosDetalle.nextToken();
             dtoPremioDetalle.setIndTipoEntrega(indTipoEntrega);
             
             oidCentroServEntrega = stkDatosDetalle.nextToken();
             dtoPremioDetalle.setOidCentroServEntrega(oidCentroServEntrega.equals("BLANCO")?null:Long.valueOf(oidCentroServEntrega));             
            
             detalles.add(dtoPremioDetalle);             
         }
         
         traza("detalles: " + detalles);     
         
         dtoPremioConsuelo.setLstPremiosDetalles(detalles);   
         
                 
                  //**************************************************************************
         
         String enviarA = conectorParametroLimpia("cbEnviarA", "", true);
         traza("enviarA " + enviarA );        
         
         String unidades = conectorParametroLimpia("txtUnidades", "", true);
         traza("unidades "+ unidades);
         
         String motivo = conectorParametroLimpia("cbMotivo", "", true);
         traza("motivo " + motivo);
         
         String observaciones = conectorParametroLimpia("atxtObservaciones", "", true);
         traza("observaciones " + observaciones);
         
         String despachaArticulo = conectorParametroLimpia("ckDespachaArticulo", "", true);
         traza("despachaArticulo " + despachaArticulo);
         
         String comunicacion = conectorParametroLimpia("ckComunicacion", "", true);
         traza("comunicacion " + comunicacion);
         
         String codMensaje = conectorParametroLimpia("txtCodMensaje", "", true);
         traza("codMensaje "  +codMensaje);
         
         String clientesSeleccionados = conectorParametro("clientesSeleccionados");
         traza("clientesSeleccionados " + clientesSeleccionados);         
         
         //--solo puedo tener un valor, oid
         String nroConcursoSeleccionados = conectorParametro("nroConcursoSeleccionados");
         traza("nroConcursoSeleccionados " + nroConcursoSeleccionados);
         
         String clientesFicheroSeleccionados = conectorParametro("clientesFicheroSeleccionados");
         traza("clientesFicheroSeleccionados "+ clientesFicheroSeleccionados);        
         
         if ( (enviarA!=null) && (enviarA.length()>0) ){
             dtoPremioConsuelo.setEnviarA(Long.valueOf(enviarA));
         }
                  
         if ( (unidades!=null) && (unidades.length()>0) ){
             dtoPremioConsuelo.setUnidades(Integer.valueOf(unidades));
         }
     
         if ( (motivo!=null) && (motivo.length()>0) ){
             dtoPremioConsuelo.setMotivo(Long.valueOf(motivo));
         }
         
         if ( (observaciones!=null) && (observaciones.length()>0) ){
             dtoPremioConsuelo.setObservaciones(observaciones);
         }
         
         if ( (despachaArticulo!=null) && (despachaArticulo.length()>0) ){
             if (despachaArticulo.equals("S")){
                  dtoPremioConsuelo.setDespachaArticulo(new Boolean(true));
             }else{
                  dtoPremioConsuelo.setDespachaArticulo(new Boolean(false));
             }    
         }
         
         if ( (comunicacion!=null) && (comunicacion.length()>0) ){
             if (comunicacion.equals("S")){
                  dtoPremioConsuelo.setComunicacion(new Boolean(true));
             }else{
                  dtoPremioConsuelo.setComunicacion(new Boolean(false));
             }    
         }
         
         if ( (codMensaje!=null) && (codMensaje.length()>0) ){
             dtoPremioConsuelo.setCodMensaje(codMensaje);
         }
        
         traza("** Contenido del dto ** " +  dtoPremioConsuelo);             
         
         //--Ver de donde se envia este dato
         traza("ConstantesINC.PREMIOS_CONSUELO_FICHERO " + ConstantesINC.PREMIOS_CONSUELO_FICHERO);
        
         //IF 1°
         if ((enviarA.equals(ConstantesINC.PREMIOS_CONSUELO_FICHERO.toString())) 
                           &&(clientesFicheroSeleccionados != null)){             
                           traza("entra a la condicion");
         
                           String fichero = conectorParametro("clientesFicheroSeleccionados");
                           traza("fichero "+ fichero); 
                     
                           StringTokenizer tokFila = new StringTokenizer(fichero, "|");
                           StringTokenizer tokCampo = null;
                           DTOOIDs dtoOid = new DTOOIDs(); 		  
                    
                           ArrayList aList = new ArrayList();
                    
                           int cont = tokFila.countTokens();
                           traza("************ cantidad de elementos " + cont);
                    
                           int i = 0;
            	    while (tokFila.hasMoreTokens()){ //--inc while			   
                                    DTOPremConsueloFichero dtoPrem = new DTOPremConsueloFichero();
                                    
                                    // Obtengo la fila
                                    String sFila = tokFila.nextToken();
                                    traza("sFila: " + sFila);
                              
                                    // Obtengo los campos. 
                                    tokCampo = new StringTokenizer(sFila, ";");
                                    traza("tokCampo " + tokCampo);
                              
                                //SE SETEA OID CONCURSO
                                    String oidConcurso = new String();
                              
                                    if (tokCampo.hasMoreTokens()){
                                             oidConcurso  = tokCampo.nextToken();
                                             //dtoPrem.setOidConcurso(oidConcurso); 
                                             //SE CAMBIA EL SETEO
                                             dtoPrem.setNroConcurso(oidConcurso); 
                                    }  
                                traza("oidConcurso : " + oidConcurso );           
                              
                                //SE SETEA OID CLIENTE
                                String oidCliente = new String();
                              
                                if (tokCampo.hasMoreTokens()){
                                        oidCliente  = tokCampo.nextToken();
                                        
                                        if (oidCliente !=""){
                                              //dtoPrem.setOidCliente(oidCliente);
                                              //SE CAMBIA EL SETEO
                                              dtoPrem.setCodCliente(oidCliente);
                                        }  
                                }
                                traza("oidCliente : " + oidCliente );

                                    //SE SETEA EL DTO AL ARRAYLIST
                                    dtoPrem.setOidPais(UtilidadesSession.getPais(this));
                                aList.add(dtoPrem);
                                i++;  			   
                           }   
                    
                           dtoPremioConsuelo.setClientesFicheroSeleccionados(aList);		
                           traza("****** dtoPremioConsuelo a " + dtoPremioConsuelo);		   

                           //se setea el pais de sesion
                           dtoPremioConsuelo.setOidPais(UtilidadesSession.getPais(this));
                           //se setea el pais de sesion
                           puedeGuardar = Boolean.TRUE;     
             } //ELSE  IF 2°
                  else if((enviarA.equals(ConstantesINC.PREMIOS_CONSUELO_CLIENTES.toString())) 
                           &&(clientesFicheroSeleccionados != null)) {    
      
                      DTOOIDs dtoOid = new DTOOIDs();   
                           traza("clientesSeleccionados: " + clientesSeleccionados);
      
                      StringTokenizer stColss = new StringTokenizer(clientesSeleccionados, "|");
                           Long[] oids = new Long[stColss.countTokens()];	
      
                      for(int a=0; stColss.hasMoreTokens(); a++){         
                      String oid = stColss.nextToken();
                           traza("oid " + oid);
                                oids[a] = Long.valueOf(oid);
                      }
      
                           traza("oids: " + oids);
      
                      dtoOid.setOids(oids);
                           dtoPremioConsuelo.setClientesSeleccionados(dtoOid);
      
                      traza(" dtoPremioConsuelo ---- " +  dtoPremioConsuelo.getClientesSeleccionados());
                           puedeGuardar = Boolean.TRUE;     
             }//-- PREMIOS_CONSUELO_CLIENTES
                  //ELSE IF 3°
                  else if((enviarA.equals(ConstantesINC.PREMIOS_CONSUELO_NRO_CONCURSO.toString())) 
                           &&(clientesFicheroSeleccionados != null))    {         
      
                      DTOOID dtoOid = new DTOOID(); 
                           dtoOid.setOidPais(UtilidadesSession.getPais(this));
                           dtoOid.setOidIdioma(UtilidadesSession.getIdioma(this));
      
                      if ((!nroConcursoSeleccionados.equals("")) && (nroConcursoSeleccionados.length()>0)){
                                    dtoOid.setOid(Long.valueOf(nroConcursoSeleccionados));
                      }     
      
                      dtoPremioConsuelo.setNroConcursoSeleccionados(dtoOid);           
                      traza(" dtoPremioConsuelo PREMIOS_CONSUELO_NRO_CONCURSO ---- " +  dtoPremioConsuelo.getClientesSeleccionados());    
                      puedeGuardar = Boolean.TRUE;    
                  }
                  //ELSE 4°
                  else{
                           puedeGuardar = Boolean.FALSE;      
                  }

//********************************************** -- *******************************************  
         if (puedeGuardar.booleanValue()){        
                  MareBusinessID businessID = new MareBusinessID("INCGuardarPremiosConsuelo");
         Vector parametros = new Vector();
             parametros.add(dtoPremioConsuelo);
             parametros.add(businessID);     
         traza("ANTES  >>>> " + parametros); 
         DruidaConector con = conectar("ConectorGuardarPremiosConsuelo", parametros);
             traza(" SALE ");
             DTOSalida dtoDatos = (DTOSalida) con.objeto("DTOSalida");         
         traza("dtoDatos :: " + dtoDatos);      
         traza("dtoDatos " + dtoDatos); 
         Long cantNoProcesados = null;        
         RecordSet rs = dtoDatos.getResultado();
         traza("contenido de rs ::: " + rs);      
        
         if(rs.esVacio() ){
                           
         }
                  else{
                           traza("contenido del dtoSalida :::::: " + dtoDatos);             
             RecordSet rsSalida = new RecordSet();             
             rsSalida.addColumn("cantNoProcesados");
             
             for (int i=0 ;i < rs.getRowCount() ;i++ ){      
                  traza(" rs.getValueAt(i,0) " + rs.getValueAt(i,0));    
                  cantNoProcesados =( Long.valueOf(rs.getValueAt(i,0).toString()));
                  traza("cantNoProcesados:: " + cantNoProcesados);
             }
         }
        
         if ((cantNoProcesados !=null) && (cantNoProcesados.intValue() > 0) ){         
           traza("cantNoProcesados !=null");                   
           asignarAtributo("VAR","ejecutar","valor","errorCantNoProcesados('" +cantNoProcesados.toString() + "')");      
         }
                  else{
             traza("por aca *** ");
             asignarAtributo("VAR", "ejecutar", "valor", "borrarTodo()");        
         }
   }
   else{
                  //--Mostrar mensaje error INC022 "Enviar A no coincide con los datos 
                  //almacenados, corrija y vuelva a grabar"             
         String error = new String();
         error = "INC-0339";                
         asignarAtributo("VAR", "errCarga", "valor", error.toString());             
   } 

//********************************************** -- *******************************************  

  } //--fin del metodo de guardar!    
} //--Fin LPAsignarPremiosConsuelo