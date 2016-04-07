import java.util.HashMap;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.Boolean;
import java.util.Vector;
 
 import es.indra.mare.common.exception.MareException;
 import es.indra.mare.common.mln.MareBusinessID;
 import es.indra.sicc.util.UtilidadesSession;
 
 import es.indra.sicc.util.DTOBelcorp;
 import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
 import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
 import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
 
 import es.indra.druida.DruidaBase;
 import es.indra.druida.DruidaConector;
 import es.indra.druida.dom.DruidaDOMObjeto;
 import es.indra.druida.DruidaBaseComun;
 
 import es.indra.sicc.dtos.car.DTOTipoReevaluacion;
 import es.indra.sicc.logicanegocio.car.ConstantesCAR;
import java.util.StringTokenizer;

public class LPCreditoRiesgoIndividual extends LPSICCBase {
  private HashMap param = new HashMap();
  
  
  public LPCreditoRiesgoIndividual() {
    super();
  }
    
  public void inicio() throws Exception {
      pagina("contenido_linea_credito_nivel_riesgo_individual_revaluar");
      this.getConfiguracionMenu(); 
  }

  public void ejecucion() throws Exception {
      String accion = conectorParametro("accion");
      accion = (accion==null )?"":accion;
      param=conectorParametro();
      setTrazaFichero();
      traza("Parametros de entrada" + param);
      traza("Entro a LP con accion = "+ accion);
      try{
         if(accion.equals("")){
			this.rastreo();
            cargaInicial(); 
          }

           if(accion.equals("Reevaluar")){
            pagina("salidaGenerica");
            reevaluar();
          }
      }catch(Exception ex){
       this.traza("Error en ejecucion");
          this.lanzarPaginaError(ex);
          
         
      }
  }
  
  //----------------------Metodos de la clase
  
  private void cargaInicial()throws Exception
  {
    DTOBelcorp dto1 = new DTOBelcorp();
    
    dto1.setOidIdioma(UtilidadesSession.getIdioma(this));
    dto1.setOidPais(UtilidadesSession.getPais(this));
    traza("1");
    ComposerViewElementList cbClaseSolicitud  = this.getConectores("PEDClasesSolicitudOrdenCompra",(DTOBelcorp)dto1 ,"es.indra.sicc.util.DTOBelcorp",0,1);
    traza("2");
    ComposerViewElementList cbTipoReevaluacion  = this.getConectores("CARObtieneTipoReevaluacion",(DTOBelcorp)dto1 ,"es.indra.sicc.util.DTOBelcorp",0,1);
    traza("3");
    ConectorComposerView conectorClaseSolicitud = new ConectorComposerView(cbClaseSolicitud,this.getRequest());
    traza("4");
    ConectorComposerView conectorTipoReevaluacion = new ConectorComposerView(cbTipoReevaluacion,this.getRequest());
    traza("5");
    conectorClaseSolicitud.ejecucion();
    traza("6");
    conectorTipoReevaluacion.ejecucion();
    traza("7");
    DruidaConector tipoSolicitud = conectorClaseSolicitud.getConector();
    traza("8");
    DruidaConector TipoReevaluacion = conectorTipoReevaluacion.getConector();  
    traza("9");
     asignar("COMBO","cbClaseSolicitud",tipoSolicitud,"PEDClasesSolicitudOrdenCompra");
    traza("10");
    asignar("COMBO","cmbTipoReevaluacion",TipoReevaluacion,"CARObtieneTipoReevaluacion");
    traza("11");
     asignarAtributo("VAR","hPais","valor",UtilidadesSession.getPais(this).toString());
    asignarAtributo("VAR","hIdioma","valor",UtilidadesSession.getIdioma(this).toString());
    
    /*
    * Agregado por Rafael Romero (04-04-2007)
    * para traer la longitud del codigo de cliente por defecto segun el pais
    */
    Byte longCodClie = this.obtenerLongitudCodigoCliente();
    if(longCodClie==null){
        this.asignarAtributo("VAR", "longCodClienteDefault", "valor", "0");
    }else{
        this.asignarAtributo("VAR", "longCodClienteDefault", "valor", longCodClie.toString());
    }
    
  }
  
  private void reevaluar()throws Exception
  {
    Boolean bLC = new Boolean(false);
    Boolean bNR = new Boolean(false);
    
    DTOTipoReevaluacion dtoR = new DTOTipoReevaluacion();
    traza("R1");
   dtoR.setOidPais(UtilidadesSession.getPais(this));
   //dtoR.setOidPais(new Long(3));
    traza("R2");
    dtoR.setOidIdioma(UtilidadesSession.getIdioma(this));
    traza("R3");
    dtoR.setOidMarca(new Long(param.get("cbMarca").toString()));
    traza("R4");
    dtoR.setOidCanal(new Long(param.get("cbCanal").toString()));
    traza("R5");
    dtoR.setOidClaseSolicitud(new Long(param.get("cbClaseSolicitud").toString()));
    traza("R6");
    dtoR.setCodCliente(param.get("txtCodigoCliente").toString());
    traza("R7");
    
    //Evaluamos combo con constantes
    Long[]valOid = this.getOidSeleccionados();
    
    
    for(int i=0;i<valOid.length;i++)
    {
        if(valOid[i].equals(ConstantesCAR.TIPO_REEVALUACION_NR))
        {
          bNR = new Boolean(true);
        }
        
        if(valOid[i].equals(ConstantesCAR.TIPO_REEVALUACION_LC))
        {
          bLC = new Boolean(true);
        }
    }
    
    dtoR.setTiposReevaluacion(valOid);
    
    //Invocamos la logica del negocio
     Vector objBussines = new Vector();
    
    MareBusinessID id = new MareBusinessID("CARCreditoRiesgoIndividual");
    objBussines.add(dtoR);
    objBussines.add(id);
    try{
		traza("antes del conector");
		DruidaConector con = conectar("ConectorCreditoRiesgoIndividual", objBussines);
		traza("despues del conector");
    }catch(Exception e)
    {
	   asignarAtributo("VAR", "ejecutarError", "valor", "foc()");
       throw e;
    }

    traza(dtoR);
    
    if(bLC.booleanValue() && bNR.booleanValue())
    {
      traza("blc1");
      asignarAtributo("VAR", "ejecutar", "valor", "mensajeLP('4008')");
    } else if(bLC.booleanValue())
    {
      traza("blc2");
      asignarAtributo("VAR", "ejecutar", "valor", "mensajeLP('4009')");
    }else if(bNR.booleanValue()){
      traza("blc3");
     asignarAtributo("VAR", "ejecutar", "valor", "mensajeLP('4010')");
    }
    
  }
  
  ComposerViewElementList getConectores(String negocio,Object objto,String clase,int posOid, int posDesc)throws Exception{
     ComposerViewElementList lista = new ComposerViewElementList();
    
     Class c = Class.forName(clase);
     Object Dto = c.newInstance();
     Dto = objto;
     ComposerViewElement c1 = new ComposerViewElement();
     
     
     c1.setIDBusiness(negocio);
     c1.setDTOE((DTOBelcorp)Dto);
     c1.setPosOID((byte)posOid);
     c1.setPosDesc((byte)posDesc);

    

     lista.addViewElement(c1);
     

     return lista;
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
    
    //-----------------------------------------------------------------------------
   private Long[] getOidSeleccionados()throws Exception{

	String str = param.get("hvalOids").toString();
	StringTokenizer tok = new StringTokenizer(str,",");
	
  Vector v = new Vector();
	String elem;
	int dif=0;
  
      while (tok.hasMoreTokens()) {
             elem=tok.nextToken().toString();
             traza("##############"+elem);
             v.add((String)elem);
      }
      Long[]valOids = new Long[v.size()];
      for(int i=0;i<v.size();i++)
      {
         valOids[i]=new Long(v.get(i).toString()); 
      }
      
      return valOids;
	
  }
}
