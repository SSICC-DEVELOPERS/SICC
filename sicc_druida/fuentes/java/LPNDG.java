import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import java.util.Vector;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.cmn.negocio.interfaces.IGestorInterfaces;
import es.indra.sicc.dtos.intsys.DTOCargaInicialInterfaz;
import es.indra.sicc.dtos.ndg.DTOInformacionDeFiltrado;

public class LPNDG extends LPSICCBase {

  private String accion = null;  
  private String pais = null;
  private String idioma = null;

  
  
  public LPNDG() {	
      super();	
  }


  public void inicio() throws Exception {	
    pagina("contenido_consultora_enviar");    
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

        try {
            
            traza("antes de cargar>>>>");	
            rastreo();
            getConfiguracionMenu("LPNDG","");

            asignarAtributo("VAR","hPais","valor",pais);
            asignarAtributo("VAR","hIdioma","valor",idioma);	     
            
            traza("accion>>>> " + accion);
            
            if (accion.equals("")) 
            { 
              /** 
               * Creamos un DTOString con la constante IGestorInterfaces.COD_INTERFAZ_GIS6 
               * (además del pais y el idioma) 
               * Llamamos al ConectorObjeto con el idBusiness "INTCargaInicialInterfaz" 
               * y el dto. 
               * Con el DTOCargaInicialInterfaz obtenido mostramos la pantallaSeleccionDatos 
               * cargando los campos numeroLote y descripcionLote con los atributos 
               * numeroLote y descripcionInterfaz
               *          
               * */
               
                DTOString dtos = new DTOString();
                //Asigno la constante


                dtos.setOidIdioma(new Long(idioma));
                dtos.setOidPais(new Long(pais));
                                
                dtos.setCadena(IGestorInterfaces.NDG_1);

	            traza("dtos >>>> " + dtos);
                
                traza("antes de setea businessid");
                MareBusinessID mid = new MareBusinessID("INTCargaInicialInterfaz");
                
                Vector vec = new Vector();
                vec.add(dtos);
                vec.add(mid);
                
                traza("antes de llamar al conector");
                DruidaConector dc = conectar("ConectorObjeto", vec);
                traza("despues de conector");
                
                DTOCargaInicialInterfaz dtocii = (DTOCargaInicialInterfaz)dc.objeto("DTOSalida");
                
                traza("antes de asignar a la pantalla");
                
                asignarAtributo("LABELC", "lblvalorLote", "valor", (dtocii.getNumeroLote()==null? "": dtocii.getNumeroLote().toString()));
                asignarAtributo("VAR", "descripcionH", "valor", (dtocii.getDescripcion()==null? "": dtocii.getDescripcion()));
                asignarAtributo("VAR", "loteH", "valor", (dtocii.getNumeroLote()==null? "": dtocii.getNumeroLote().toString()));
           } 
          
          else{	
                if (accion.equals("Guardar")) 
                { 
                      /**
                      * 
                      *  Creamos un DTOInformacionDeFiltrado que rellenamos con los campos 
                      *  recogidos de la pantalla (además del pais y el idioma) 
                      *  Llamamos al ConectorGenerarFicheroDeUsuarios con el dto 
                      *  creado y el idBusiness "NDGGenerarFicheroConsultoras" 
                      * */
                      
                      pagina("salidaGenerica");
                      traza("esta en accion ::::  " + accion);
      
                      String lote = conectorParametro("loteH");
                      traza("lote**** " + lote);
      
                      String descripcion = conectorParametro("descripcionH");
                      traza("descripcion**** " + descripcion);
                      
                      String observaciones = conectorParametro("observacionesH");
                      traza("observaciones**** " + observaciones);
                      
                      String paisdto = 	conectorParametroLimpia("hPais","",true);
                      traza("paisdto**** " + paisdto);

                      String idiomadto = 	conectorParametroLimpia("hIdioma","",true);
                      traza("idiomadto**** " + idiomadto);

                      DTOInformacionDeFiltrado dto = new DTOInformacionDeFiltrado();                                                        
                      
                      dto.setNumeroLote(new Long(lote));
                      dto.setOidIdioma(new Long(idiomadto));
                      dto.setOidPais(new Long(paisdto));
                      dto.setPais(new Long(paisdto));
                                            
                      traza("PaisSeteado**** " + dto.getPais());
                   
                      
                      if (!observaciones.equals("")){
                          dto.setObservacionesLote(observaciones);
                      } 
                      
                      if (!descripcion.equals("")){
                          dto.setDescripcionLote(descripcion);
                      }
                       
                      traza("el dto DTOInformacionDeFiltrado, que mando, contiene: " + dto);
                    
                    
                      traza("antes de setea businessid");
                      MareBusinessID mid = new MareBusinessID("NDGGenerarFicheroConsultoras");
                      
                      Vector vec = new Vector();
                      vec.add(dto);
                      vec.add(mid);
                      
                      traza("antes de llamar al conector");
                      DruidaConector dc = conectar("ConectorGenerarFicheroDeUsuarios", vec);
                      traza("despues de conector");
                      
                      conectorAction("LPInicioBelcorp");
                      conectorActionParametro("accion","");
                   } 
          }
        }
          catch ( Exception e )  {
            traza("Exception en LPNDG");
            e.printStackTrace();     
            lanzarPaginaError(e);
          }
  }

}
