import es.indra.druida.DruidaConector;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;

public class LPCronogramaCOBPeriodoConsulta extends LPSICCBase
{
     public LPCronogramaCOBPeriodoConsulta() {
         super();
     }  
     
     public void inicio() throws Exception {
      this.pagina("contenido_cronograma_cobranza_periodo_consultar");
      this.getConfiguracionMenu();
      this.getFormatosValidaciones();
      this.asignarAtributoPagina("cod", "0231");
     }

// ----------------------------------------------------------------------------------------------
     public void ejecucion() throws Exception 
     {  
        this.setTrazaFichero();
        try 
        {
            traza("---- Entrando a LPCronogramaCOBPeriodoConsulta() ");
            String sAccion = this.conectorParametroLimpia("", "", true);
            traza("sAccion: " + sAccion);
            if (sAccion.equals(""))
              this.cargarPagina();  
        
        } catch (Exception ex)
        {
            ex.printStackTrace();
            this.lanzarPaginaError(ex);
        }
        
     }
     
     private void cargarPagina() throws Exception
     {
        traza("cargarPagina");
        Long oidPais = UtilidadesSession.getPais(this);
        Long oidIdioma = UtilidadesSession.getIdioma(this);
        
        // Cargo en var. de form. valores de Sesion.
        this.asignarAtributo("VAR", "hPais", "valor", oidPais.toString());
        this.asignarAtributo("VAR", "hIdioma", "valor", oidIdioma.toString() );
        
        
        // Llamo a la parte servidora para obtener Marcas y Canales
        DTOBelcorp dtoBelcorp = new DTOBelcorp();
        dtoBelcorp.setOidIdioma(oidIdioma);
        dtoBelcorp.setOidPais(oidPais);
        
        
        ComposerViewElement cElement1 = new ComposerViewElement();
        ComposerViewElement cElement2 = new ComposerViewElement();
        ComposerViewElementList compList = new ComposerViewElementList();
        
        cElement1.setDTOE(dtoBelcorp);
        cElement1.setIDBusiness("SEGConsultaCanales");
        
        cElement2.setDTOE(dtoBelcorp);
        cElement2.setIDBusiness("SEGConsultaMarcas");
        
        compList.addViewElement(cElement1);
        compList.addViewElement(cElement2);
        
        ConectorComposerView conCompView = new ConectorComposerView(compList, this.getRequest() );
        traza("Conectando para completar Combos Canal y Marca....");
        conCompView.ejecucion();
        traza("Conexion Done!");
        DruidaConector con = conCompView.getConector();
        
        this.asignar("COMBO", "cbMarca", con, "SEGConsultaMarcas");
        this.asignar("COMBO", "cbCanal", con, "SEGConsultaCanales");        
        
     }
     

     
}
