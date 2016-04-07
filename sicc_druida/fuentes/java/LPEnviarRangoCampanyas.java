import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.ListaEditableDinamica;
import es.indra.sicc.dtos.intsys.DTOGenerarFicheroRangoCampanya;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;


import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;

import es.indra.sicc.dtos.mav.DTOActividadMAV;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

import es.indra.sicc.dtos.ndg.DTOInformacionDeFiltrado;

import es.indra.sicc.dtos.intsys.DTOInterfaz;
import es.indra.sicc.logicanegocio.intsys.ConstantesOCR;

import es.indra.sicc.dtos.cra.DTOPeriodo;

public class LPEnviarRangoCampanyas extends LPSICCBase {

  public LPEnviarRangoCampanyas() {
    super();
  }
    
 public void inicio() throws Exception {
    pagina("contenido_matriz_precios_enviar");
	asignarAtributo("PAGINA","contenido_matriz_precios_enviar","cod","0924");
	asignarAtributo("PAGINA","contenido_matriz_precios_enviar","titulo","0924");
    this.getConfiguracionMenu("LPEnviarRangoCampanyas");
  }

  public void ejecucion() throws Exception {
	  rastreo();
      setTrazaFichero();
      String accion = conectorParametro("accion");
	  traza("action: " + conectorParametro("action"));
      //accion = (accion==null )?"":accion;
      traza("accion de entrada " + accion);   
      try{
      if (accion == null || accion.equals("")) {
		  //this.obtenerInformacionCriteriosDeSeleccion();
		  this.obtenerValoresPorDefecto();
		  this.cargarCombosMarcaCanal();
		  asignarAtributo("VAR", "hidIdioma", "valor", UtilidadesSession.getIdioma(this).toString() );
		  asignarAtributo("VAR", "hidPais", "valor", UtilidadesSession.getPais(this).toString() );
		  asignarAtributo("VAR", "hidCanal", "valor", UtilidadesSession.getCanalPorDefecto(this).toString() );
	      asignarAtributo("VAR", "hidMarca", "valor", UtilidadesSession.getMarcaPorDefecto(this).toString() );

      } else if(accion.equals("Guardar")){
        pagina("salidaGenerica");
		this.guardar();		
		asignarAtributo("VAR", "ejecutar", "valor", "ok()");
      }

	  asignarAtributo("VAR","casoDeUso","valor","EnviarRangoCampanyas");
      
      }catch(Exception  e){
		traza("ERROR: " + e);
        e.printStackTrace();
		//pagina("salidaGenerica");
		asignarAtributo("VAR","errDescripcion","valor","Error al generar fichero");
      }
  }

/*  private void obtenerInformacionCriteriosDeSeleccion() throws Exception {
		DTOInformacionDeFiltrado in = new DTOInformacionDeFiltrado(); 
		in.setPais(UtilidadesSession.getPais(this)); 
		in.setCodUsuario(UtilidadesSession.getIdUsuario(this)); 
		ComposerViewElementList marca = this.getConectores("NDGObtenerInformacionCriteriosDeSeleccion",(DTOInformacionDeFiltrado)in     ,"es.indra.sicc.dtos.ndg.DTOInformacionDeFiltrado",0,1); 
		ComposerViewElementList canal = this.getConectores("NDGObtenerInformacionCriteriosDeSeleccion",(DTOInformacionDeFiltrado)in     ,"es.indra.sicc.dtos.ndg.DTOInformacionDeFiltrado",2,3); 
		ComposerViewElementList acceso = this.getConectores("NDGObtenerInformacionCriteriosDeSeleccion",(DTOInformacionDeFiltrado)in     ,"es.indra.sicc.dtos.ndg.DTOInformacionDeFiltrado",4,5); 
		ComposerViewElementList periodo = this.getConectores("NDGObtenerInformacionCriteriosDeSeleccion",(DTOInformacionDeFiltrado)in     ,"es.indra.sicc.dtos.ndg.DTOInformacionDeFiltrado",6,7); 
				 
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
		DruidaConector rPeri1 = conectorPeri.getConector(); 
				 
		asignar("COMBO","cbMarcaAux",rMarca,"NDGObtenerInformacionCriteriosDeSeleccion"); 
		asignar("COMBO","cbCanalAux",rCanal,"NDGObtenerInformacionCriteriosDeSeleccion"); 
		asignar("COMBO","cbAcc",rAcces,"NDGObtenerInformacionCriteriosDeSeleccion"); 
		asignar("COMBO","cbDsde",rPeri1,"NDGObtenerInformacionCriteriosDeSeleccion"); 
		asignar("COMBO","cbHasta",rPeri1,"NDGObtenerInformacionCriteriosDeSeleccion"); 

  }
*/
  private void guardar() throws Exception {
    traza("param: " + conectorParametro());
    
    MareBusinessID idBusiness = new MareBusinessID("INTEnviarRangoDeCampanyas");
    Vector params = new Vector();
    DTOGenerarFicheroRangoCampanya dto = new DTOGenerarFicheroRangoCampanya(); 
    
    dto.setOidPais(UtilidadesSession.getPais(this));
    
    traza("\n1: cbMarca: " + conectorParametro("marca").toString());
    dto.setMarca(conectorParametro("marca"));
    
    traza("\n2: cbCanal: " + conectorParametro("canal").toString());
    dto.setCanal(conectorParametro("canal"));
    
    traza("\n3: cbAcceso: " + conectorParametro("acceso").toString());
    dto.setAcceso(conectorParametro("acceso"));
    
    traza("\n4: cbPeriodoDesde: " + conectorParametro("desde").toString());
    dto.setOidPeriodoDesde(new Long(conectorParametro("desde").toString().trim()));
    
    if(conectorParametro("hasta") != null && !"".equals(conectorParametro("hasta").trim())) {
      traza("\n5: cbPeriodoHasta: " + conectorParametro("hasta").toString());
      dto.setOidPeriodoHasta(new Long(conectorParametro("hasta")));
    }
    
    traza("\n6: labelLote: " + conectorParametro("labelLote"));
    String aux = conectorParametro("labelLote");
    traza("\n7: labelLote " + aux);
    Long numeroLote = null;
    if(aux != null && !"".equals(aux)) {
      numeroLote = new Long(aux);
    }    
    dto.setNumLote( numeroLote ); 
    traza("********************" + dto);
    params.add(dto);
    params.add(idBusiness);
    traza("se va a hacer el conectar");
    conectar("ConectorGenerarFicheroDeEnviarConsultoras", params);
	//DruidaConector con = conectar("OCRGenerarFicheroDeEnviarConsultoras", params);


  }

 //*************Metodos de la clase****************
//-----------------------------------------------------------------	
/*    ComposerViewElementList getConectores(String negocio,Object objto,String clase,int posOid, int posDesc)throws Exception{
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
*/
    //---------------------------------------------------------------------------------------------------------------------------------------//

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
        
        DTOPeriodo dtop = new DTOPeriodo();
        dtop.setPais(es.indra.sicc.util.UtilidadesSession.getPais(this));
        dtop.setMarca(UtilidadesSession.getMarcaPorDefecto(this));
        dtop.setCanal(UtilidadesSession.getCanalPorDefecto(this));
        dtop.setFechaInicio(new java.sql.Date(System.currentTimeMillis()));
  
        ComposerViewElement ci3 = new ComposerViewElement();
        ci3.setIDBusiness( "CRAObtienePeriodosFecha" );//CRAObtenerPeriodos
        ci3.setDTOE( dtop );

        lista.addViewElement( ci1 );
        lista.addViewElement( ci2 );
        lista.addViewElement( ci3 );

		//Utilizamos el subsistema
		ConectorComposerView conector = new ConectorComposerView(lista, this.getRequest());
		conector.ejecucion();
        DruidaConector resultados = null;
        resultados = conector.getConector();

        asignar("COMBO", "cbCanal", resultados, "SEGConsultaCanales");
        asignar("COMBO", "cbMarca", resultados, "SEGConsultaMarcas");
        
        asignar("COMBO", "cbPeriodoDesde", resultados, "CRAObtienePeriodosFecha");//CRAObtenerPeriodos
        asignar("COMBO", "cbPeriodoHasta", resultados, "CRAObtienePeriodosFecha");//CRAObtenerPeriodos
    }

	//---------------------------------------------------------------------------------------------------------------------------------------//
	private void obtenerValoresPorDefecto() throws Exception {
	    MareBusinessID idBusiness     = new MareBusinessID("INTObtenerValoresPorDefecto");
        DTOInterfaz dto = new DTOInterfaz();
		dto.setCodInterfaz( ConstantesOCR.OCR_INTERFAZ_MATRIZ_PRECIOS );
        Vector params = new Vector();
        params.add( dto );
        params.add( idBusiness );
        DruidaConector con = conectar("ConectorObtenerValoresPorDefecto", params);
        DTOSalida        out  = ( DTOSalida ) con.objeto("dtoSalida");
        RecordSet rs = out.getResultado();
         if ( !rs.esVacio() ) {
              Long lote = ( Long ) rs.getValueAt(0,"Numero_Lote");
              asignarAtributo("VAR","labelLote","valor",lote.toString());
              String desc = (String) rs.getValueAt(0,"Descripcion");
              asignarAtributo("VAR","labelDescripcion","valor",desc);
        }
	}

}
