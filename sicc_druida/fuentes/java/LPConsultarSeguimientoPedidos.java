//import LPSICCBase;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.druida.DruidaConector;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import java.util.Date;
import java.util.Vector;
import java.util.StringTokenizer;
import es.indra.sicc.dtos.mav.DTOEstadoMAV;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.rep.logicanegocio.ConstantesREP;
import java.util.HashMap;
                             
public class LPConsultarSeguimientoPedidos   extends LPSICCBase{
  private String casoDeUso = null;
  private String accion = null;
  private Long idioma = null;
  private Long pais = null;
  private String descPais = null;
  private String oide =null;
  private String estatus1 =null;
  private String estatus2 =null;
  private String ipcliente =null;
  private String programa =null;
  private String detalle=null; 
  private String  esta1 = null;
  private String soidCabeceraSolicitud = null;  
  private Long oidCabeceraSolicitud = null;  
  
  public LPConsultarSeguimientoPedidos() 
  {
    super();
  }
              
   public void inicio() throws Exception
   {
   }
   /* modificaciones: 24/06/2005 - inc 16881 - pperanzola
   */
  
  public void ejecucion() throws Exception
  {
    /*-----------------------------------------------------------------------------
    Si accion == "" 
    { 
      Llamar al método inicializar() 
    } 

    sino 
        Si accion == "Visualizar documento" 
        { 
          Llamar al método visualizarDocumento() 
        }

     ------------------------------------------------------------------------------*/

         setTrazaFichero();
         pagina("contenido_seguimiento_pedidos");
         getConfiguracionMenu("LPConsultarSeguimientoPedidos","");
			getFormatosValidaciones();
        try{
          
        
          casoDeUso = conectorParametro("casoDeUso")==null?"":conectorParametro("casoDeUso");
          accion = conectorParametro("accion")==null?"":conectorParametro("accion");
          pais = UtilidadesSession.getPais(this);
          idioma= UtilidadesSession.getIdioma(this);
          ipcliente= UtilidadesBelcorp.getIPCliente(this);
          programa = UtilidadesSession.getFuncion(this);
          descPais = UtilidadesSession.getDescripcionPais(this);
          if (accion.equals("")) 
          {
            this.inicializar();  
          }

          //modif. Gpons APE-111: Invoca a CU "Visualizar Lista Picado" 
		  if (accion.equalsIgnoreCase("VisualizarLP")) 
          {
            this.visualizaLP();  
          }
		  //fin modif. Gpons APE-111
          
		  if (accion.equalsIgnoreCase("Visualizar documento")) 
          {
            this.visualizaDocumento();  
          }
          asignarAtributo("VAR","casoDeUso","valor",this.casoDeUso);
           asignarAtributo("VAR","accion","valor",this.accion);
           asignarAtributo("VAR","idio","valor",this.idioma.toString());
           asignarAtributo("VAR","pais","valor",this.pais.toString());

		   asignarAtributo("VAR","KTipoDocPedido","valor",ConstantesPED.TIPO_DOCUMENTO_PEDIDO.toString());
		   asignarAtributo("VAR","KTipoDocConsolidado","valor",ConstantesPED.TIPO_DOCUMENTO_CONSOLIDADO.toString());
		   asignarAtributo("VAR","KTipoDocOrdenTransporte","valor",ConstantesPED.TIPO_DOCUMENTO_ORDEN_TRANSPORTE.toString());
		   asignarAtributo("VAR","KTipoDocListaPicado","valor",ConstantesPED.TIPO_DOCUMENTO_LISTA_PICADO.toString());
        }
        catch (Exception ex) 
        {
         java.io.StringWriter sw = new java.io.StringWriter();
         java.io.PrintWriter pw = new java.io.PrintWriter(sw);
         ex.printStackTrace(pw);
         pw.flush();
         this.lanzarPaginaError(ex);  
         
        }
      }
      public void inicializar() throws Exception{
      
        DTOBelcorp dto =new DTOBelcorp();
        traza("pais"+ this.pais);
        traza("idioma"+ this.idioma);
        dto.setOidIdioma(this.idioma);
        dto.setOidPais(this.pais);
        /* contenedor de todos los combos */
        traza("creo la lista que va a contener los combos");
        ComposerViewElementList todos = new ComposerViewElementList();
        /* primer combo a cargar */
        traza("combo canales");
        ComposerViewElement canales = new ComposerViewElement();
        traza("meto el dto de canales");
        canales.setDTOE(dto);
        traza("meto el bussines id de canales");
        canales.setIDBusiness("SEGConsultaCanales");
        traza("pido co.lumnas");
        byte pos =1;
        canales.setPosDesc(pos);
        pos=0;
        canales.setPosOID(pos);
        traza("meto en la lista a canales");
        todos.addViewElement(canales);
        
        /* segundo combo combo a cargar */
        traza("combo hitos");
        ComposerViewElement hito = new ComposerViewElement();
        traza("meto el dto de hitos");
        hito.setDTOE(dto);
        traza("meto el bussines id de hitos");
        hito.setIDBusiness("PEDObtenerHitosSeguimiento");
        traza("meto en la lista a hito");
        todos.addViewElement(hito);

        /* tercer combo combo a cargar */
        traza("combo tip doc");
        ComposerViewElement doc = new ComposerViewElement();
        traza("meto el dto de tipd doc");
        doc.setDTOE(dto);
        traza("meto el bussines id de tip doc");
        doc.setIDBusiness("PEDObtenerTiposDocumentoSeguimiento");
        traza("meto en la lista a tip doc");
        todos.addViewElement(doc);

        /*realizo los conectores */
        traza("conecto");
        ConectorComposerView conecto =new ConectorComposerView(todos,this.getRequest());
        traza("ejecuto");
        conecto.ejecucion();
        traza("obtengo resultado");
        DruidaConector resu = conecto.getConector();
        traza("asigno");
        asignar("COMBO","cbCanalConsolidado",resu,"SEGConsultaCanales");
        traza("asigno");
        asignar("COMBO","cbHitoSeguimiento",resu,"PEDObtenerHitosSeguimiento");
        traza("asigno");
        asignar("COMBO","cbTipoDocumento",resu,"PEDObtenerTiposDocumentoSeguimiento");
        
        
      }
      public void visualizaDocumento() throws Exception {
        
      }

      public void visualizaLP() throws Exception {

            soidCabeceraSolicitud = conectorParametro("oidCabeceraSolicitud");
            try{
                oidCabeceraSolicitud = (soidCabeceraSolicitud==null||soidCabeceraSolicitud.equals(""))?null:new Long(soidCabeceraSolicitud);
            }catch (NumberFormatException ne) {
            //Vino un valor no vacio que no es un numero.
                oidCabeceraSolicitud = null;
            }
        
            traza("soidCabeceraSolicitud"+soidCabeceraSolicitud);    
            traza("oidCabeceraSolicitud"+oidCabeceraSolicitud);    

      
           HashMap datos = new HashMap();
           datos.put("MODULO", "APE");
           datos.put(ConstantesREP.TITULO, "Lista de Picado");
           datos.put("CONSOLIDADOVALUE", soidCabeceraSolicitud);

           traza("++++++Antes de enviar a reportes " + datos);            
               
             //ejecutarReporte(datos, "REPGenerarReporte", "RD_REP-018", null);
             ejecutarReporte2(datos, "REPGenerarReporteBatch", "RD_APE-014", "pdf");
      }

  }
