
import es.indra.druida.DruidaConector;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.cob.DTOAsignacionesCobranza;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;

import java.util.Vector;
import java.lang.Long;
import java.lang.String;
import es.indra.mare.common.exception.MareException;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;
import java.text.SimpleDateFormat;



public class LPReasignarCarteraTerritorios extends LPSICCBase {
    
    
    private String accion;
    private String pais;
    private String idioma;

	public LPReasignarCarteraTerritorios() {	super();	}

	public void inicio() throws Exception {
  pagina ("contenido_cartera_territorios_reasignar");
  }
  
  public void ejecucion() throws Exception {
    setTrazaFichero();
    try  {
          //this.rastreo();
          traza(" Entrando a LPReasignarCarteraSaldos.ejecucion");
          pais = (UtilidadesSession.getPais(this)).toString();
          idioma = (UtilidadesSession.getIdioma(this)).toString();
          
          asignarAtributo("VAR","oidPais","valor", pais.toString());
          asignarAtributo("VAR","oidIdioma","valor", idioma.toString());
          
          
          accion = conectorParametroLimpia("accion", "", true);
          traza("Accion de sesion: " + accion);
          if( accion.equals("")){
            getConfiguracionMenu("LPReasignarCarteraTerritorios", accion);	
            this.cargarPagina();
            }else if( accion.equals("reasignar")){
                    //getConfiguracionMenu("LPReasignarCarteraSaldos", accion);	
                    this.reasignar();
            }
          
    }
    catch ( Exception e )  {
      traza("Exception en LPConsultarResumenAsignacion");
      e.printStackTrace();     
      lanzarPaginaError(e);
    }
  }
  
  
  	private void cargarPagina() throws Exception{
    
          ComposerViewElementList cv = crearParametrosEntrada();

    
          traza ("cv " + cv);
          
          ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
          traza ("conector " +conector);
          conector.ejecucion();
          traza("Ejecutado");                                    
          // 5.- DruidaConector conConsultar = conectar("ConectorCargaPantalla", paramEntrada); 
          DruidaConector conConsultar = conector.getConector(); 
          asignar("COMBO", "cbUsuarioOrigen", conConsultar, "COBObtenerUsuariosCobCombo");
          asignar("COMBO", "cbMarca", conConsultar, "SEGConsultaMarcas");
          asignar("COMBO", "cbCanal", conConsultar, "SEGConsultaCanales");
          
          
      }
    
    
        private ComposerViewElementList crearParametrosEntrada()throws Exception {
        traza("en crearParamentrosEntrada");
        DTOBelcorp dtoBel =  new DTOBelcorp();
        dtoBel.setOidIdioma(UtilidadesSession.getIdioma(this));
        dtoBel.setOidPais(UtilidadesSession.getPais(this));
        
        ComposerViewElementList lista = new ComposerViewElementList();
    
        //Combo canal
        ComposerViewElement ci1 = new ComposerViewElement();
        ci1.setIDBusiness("SEGConsultaCanales");
        ci1.setDTOE(dtoBel);
        
        //Combo marca
        ComposerViewElement ci2 = new ComposerViewElement();
    		ci2.setIDBusiness("SEGConsultaMarcas");
        ci2.setDTOE(dtoBel);
        
        //Combo grupo procesos
        ComposerViewElement ci3 = new ComposerViewElement();
        ci3.setIDBusiness("COBObtenerUsuariosCobCombo");
        ci3.setDTOE(dtoBel);

        lista.addViewElement(ci1);
        lista.addViewElement(ci2);
        lista.addViewElement(ci3);
        
        traza("saliendo de crearParamentrosEntrada");        
        return lista;
	}
  
  
  
  
  private void reasignar ()throws Exception {
  
    try{

     MareBusinessID id = new MareBusinessID("COBReasignarCartera");
     DTOAsignacionesCobranza dto = new DTOAsignacionesCobranza();
     dto.setOidPais(new Long(pais));
     dto.setOidIdioma(new Long(idioma));
     
     String usuarioOrigen = conectorParametroLimpia("cbUsuarioOrigen", "", true);
     String usuarioDestino  = conectorParametroLimpia("cbUsuarioDestino", "", true);
     String etapaDeuda =   conectorParametroLimpia("cbCodEtDeuda", "", true);
     String marca = conectorParametroLimpia("cbMarca", "", true);
     String canal = conectorParametroLimpia("cbCanal", "", true);
     String periodo = conectorParametroLimpia("cbCodPeriodo", "", true);
     
     
     String subGerencia = conectorParametroLimpia("cbSubgerenciaVentas", "", true);
     String zona = conectorParametroLimpia("cbZona", "", true);
     String region = conectorParametroLimpia("cbRegion", "", true);
     String seccion =conectorParametroLimpia("cbSeccion", "", true);
     
     String territorio = conectorParametroLimpia("txtTerritorio", "", true);
     
     
	 traza("usuarioOrigen: " + usuarioOrigen);
	 traza("usuarioDestino: " + usuarioDestino);
	 traza("etapaDeuda " + etapaDeuda);
	 traza("marca: " + marca);
	 traza("canal: " + canal);
	 traza("periodo: " + periodo);
	 traza("subGerencia: " + subGerencia);
	 traza("zona: " + zona);
	 traza("region: " + region);
	 traza("seccion: " + seccion);
	 traza("territorio: " + territorio);
     
     if ((usuarioOrigen != null) && !(usuarioOrigen.equals(""))){
          dto.setUsuarioOrigen(new Long(usuarioOrigen)); 
          traza ("usuarioOrigen"+ usuarioOrigen);
     }
     if ((usuarioDestino != null) && !(usuarioDestino.equals(""))){
          dto.setUsuarioDestino(new Long(usuarioDestino));
          traza ("usuarioDestino"+ usuarioDestino);
     }
     
     if ((etapaDeuda != null) && !(etapaDeuda.equals(""))){
            dto.setEtapaDeuda(new Long(etapaDeuda));
            traza ("etapaDeuda"+ etapaDeuda);
     }
     
     if ( (marca != null) && !(marca.equals(""))){
            dto.setMarca(new Long(marca));
            traza ("marca"+ marca);
     }
     if ((canal != null) && !(canal.equals(""))){
          dto.setCanal(new Long(canal));
          traza ("canal"+ canal);
     }     
     
     
     if ((periodo != null) &&!(periodo.equals(""))){
          dto.setPeriodo(new Long(periodo));
          traza ("periodo"+ periodo);
          
    }   
     
     if ((subGerencia != null) && !(subGerencia.equals(""))){
          dto.setSubgerencia(new Long(subGerencia));
          traza ("subGerencia"+ subGerencia);
     }
     
    if ((zona != null) && !(zona.equals(""))){
          dto.setZona(new Long(zona));
          traza ("zona"+ zona);
    }     
    
    if ((region != null) && !(region.equals(""))){
          dto.setRegion(new Long (region));
          traza ("region"+ region);
    }    
    
    if ((seccion != null) && !(seccion.equals(""))){
          dto.setSeccion(new Long (seccion));
          traza ("seccion"+ seccion);
    }
    
    
    if ((territorio != null) && !(territorio.equals(""))){
          dto.setTerritorio((territorio));
          traza ("territorio"+ territorio);
    }
    
    pagina("salidaGenerica"); 
    Vector parametros = new Vector();
    parametros.add(dto);
    parametros.add(id);
    traza("Conectando a ConectorReasignarCartera... ");
    DruidaConector conector = conectar("ConectorReasignarCartera", parametros);
    traza("Conectó.");
	 //-> Asignar conector "ConectorReasignarCartera" con idBusiness y dto creados

	asignarAtributo("VAR", "ejecutar", "valor", "fLimpiar();");

   } catch(Exception e) {
	  traza("Excepcion: " + e);
	  asignarAtributo("VAR", "ejecutarError", "valor", "focalizaBotonReasignar();");
	  throw e;
  }
  
}
  
}
