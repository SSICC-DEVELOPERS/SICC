import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.inc.DTOAmbitRC;
import es.indra.sicc.dtos.inc.DTOComunicarParticipantes;
import es.indra.sicc.dtos.inc.DTORankingNivelesPremios;
import es.indra.sicc.dtos.inc.DTOVentaRankingGerentes;
import es.indra.sicc.dtos.inc.DTOAsignarPremios;
import es.indra.sicc.logicanegocio.inc.ConstantesINC;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.xml.XMLDocument;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.lang.reflect.InvocationTargetException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.StringTokenizer;
import java.util.Vector;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class LPMantenimientoRanking extends LPSICCBase {           
   public LPMantenimientoRanking() {	 
     super();
  }

  public void inicio() throws Exception { 
     
  }

  public void ejecucion() throws Exception {		
     
     String accion = conectorParametroLimpia("accion","", true);
     
     
     setTrazaFichero();
     try {
        this.rastreo();
        
        if (accion.equals("")){
           cargarPantalla();
           getConfiguracionMenu("LPMantenimientoRanking");
        } 
        
        if(accion.equals("calcularRanking")){
           cargarPantalla2(); 
           getConfiguracionMenu("LPMantenimientoRanking");
        }
       
        if(accion.equals("resultadosRankingGerentes")) {
           resultadosRanking();
           getConfiguracionMenu("LPMantenimientoRanking","resultadosRankingGerentes");
        }
        
        if(accion.equals("verDesglose")){
           verDesglose();
           getConfiguracionMenu("LPMantenimientoRanking","verDesglose");
        }
        
        if(accion.equals("asignarPremiosRankingRecuperarNiveles")){
           asignarPremiosRankingRecuperarNiveles();
           getConfiguracionMenu("LPMantenimientoRanking","asignarPremiosRankingRecuperarNiveles");
        }
        
        if(accion.equals("cargarGanadoras")){
           cargarGanadoras();  
           getConfiguracionMenu("LPMantenimientoRanking","cargarGanadoras");
        }
        
        if(accion.equals("comunicar")){
           comunicarAParticipantes();
        }
        
        if(accion.equals("asignarPremios")){
           asignarPremios();
        }
		
		// vbongiov -- 26/07/2006 -- inc DBLG500000906
		if(accion.equals("calificar")){
           calificar();
        }
        
     } catch (Exception ex) {
     		              
        ByteArrayOutputStream stack = new ByteArrayOutputStream();
		    PrintStream out = new PrintStream(stack);
			  ex.printStackTrace(out);
	      traza("EXCEPCION:" + stack.toString());
		    lanzarPaginaError(ex);

     }
   
  }
  
  private void cargarPantalla() throws Exception{
     
     pagina("contenido_ranking_calcular");
     ComposerViewElementList cv = crearParametrosEntrada();
     ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
     conector.ejecucion();
     DruidaConector resultados = conector.getConector();
     traza(" 4 " + resultados.getXML());
           
     asignar("COMBO","cbBaseCalculo",resultados,"INCConsultaBasesCalculo");              
     asignar("COMBO","cbValorCalculo",resultados,"INCObtenerFormaCalculo");
     asignar("COMBO","cbNumConcurso",resultados,"INCObtenerNroConcursosRankingActivos");
     asignarAtributo("VAR","idioma","valor", UtilidadesSession.getIdioma(this).toString());
     traza("la base de calculo " + ConstantesINC.BASE_CALCULO.toString());
     asignarAtributo("VAR", "baseCalculo", "valor", ConstantesINC.BASE_CALCULO.toString());
     
    
   
  }
  
   private void cargarPantalla2() throws Exception{
   
      pagina("contenido_parametrizacion_ranking_calcular");
      String oidConcurso = conectorParametroLimpia("oidConcurso", "", true);      
      asignarAtributo("VAR", "oidConcurso", "valor", oidConcurso);
      asignarAtributo("VAR", "descConcurso", "valor", conectorParametroLimpia("descConcurso", "", true));
      asignarAtributo("VAR", "version", "valor", conectorParametroLimpia("version", "", true));
      asignarAtributo("VAR", "descValorCalculo", "valor", conectorParametroLimpia("descValorCalculo", "", true));
      asignarAtributo("VAR", "oidValorCalculo", "valor", conectorParametroLimpia("oidValorCalculo", "", true));
      asignarAtributo("VAR", "descBaseCalculo", "valor", conectorParametroLimpia("descBaseCalculo", "", true));
      asignarAtributo("VAR", "oidBaseCalculo", "valor", conectorParametroLimpia("oidBaseCalculo", "", true));
      asignarAtributo("VAR", "oidDirigidoA", "valor", conectorParametroLimpia("oidDirigidoA", "", true));

	  traza("oidTipoRanking: " + conectorParametroLimpia("oidTipoRanking", "", true));

      asignarAtributo("VAR", "oidTipoRanking", "valor", conectorParametroLimpia("oidTipoRanking", "", true));

	  
      ComposerViewElementList cv = crearParametrosEntradaNivelAgrupamiento();
      ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
      conector.ejecucion();
      DruidaConector resultados = conector.getConector();
      traza(" 4 " + resultados.getXML());
           
      asignar("COMBO","cbNivelAgregacion",resultados,"INCObtenerNivelAgrupamiento");  
      
      asignarAtributo("VAR", "agrupacionGeneral", "valor", ConstantesINC.OID_AGRUPACION_GENERAL_RANKING.toString());
      asignarAtributo("VAR", "agrupacionSGV", "valor", ConstantesINC.OID_AGRUPACION_SUBGERENCIA_VTA_RANKING.toString() );
      asignarAtributo("VAR", "agrupacionRegion", "valor", ConstantesINC.OID_AGRUPACION_REGION_RANKING.toString() );
      asignarAtributo("VAR", "agrupacionZona", "valor", ConstantesINC.OID_AGRUPACION_ZONA_RANKING.toString() );
      asignarAtributo("VAR", "agrupacionSeccion", "valor", ConstantesINC.OID_AGRUPACION_SECCION_RANKING.toString()); 
      asignarAtributo("VAR", "agrupacionTerritorio", "valor", ConstantesINC.OID_AGRUPACION_TERRITORIO_RANKING.toString()); 
      asignarAtributo("VAR", "dirigidoGte", "valor", ConstantesINC.OID_DIRIGIDO_A_GERENTE.toString()); 
      asignarAtributo("VAR", "variablesVenta", "valor", ConstantesINC.VARIABLES_VENTA.toString()); 
      
      asignarAtributo("VAR", "pais", "valor", UtilidadesSession.getPais(this).toString()); 
      asignarAtributo("VAR","idioma","valor", UtilidadesSession.getIdioma(this).toString());
      
      /*
      DTOAmbitRC dtoARC = new DTOAmbitRC();
      dtoARC.setOidPais(UtilidadesSession.getPais(this));
      dtoARC.setOidIdioma(UtilidadesSession.getIdioma(this));
      dtoARC.setOidConcurso(new Long(oidConcurso));
      
      traza("antesde la lista oculta de Regiones");
      MareBusinessID idRegiones = new MareBusinessID("INCObtenerRegionesConcursoAmbito");
      Vector vecReg = new Vector();
      vecReg.add(dtoARC);
      vecReg.add(idRegiones);
      DTOSalida dtoRegiones = (DTOSalida) conectar("ConectorUA",vecReg).objeto("dtoSalida"); 
      RecordSet region = (RecordSet)dtoRegiones.getResultado();
      Vector colRegion = region.getColumnIdentifiers();
      DruidaConector regiones = generarConector("DTOSalida.regiones_ROWSET",region, colRegion);
      //traza("regiones "+dtoRegiones.getResultado());
      //traza("regiones "+dtoRegiones.getResultado().getColumnIdentifiers());
      this.crearListaLP(colRegion, region.getColumnCount(), "CapaReg","ListaRegiones", "14", "200");
      asignar("LISTA", "ListaRegiones", regiones, "DTOSalida.regiones_ROWSET");  

     //cargo la lista oculta de Zonas 
      traza("antesde la lista oculta de Zonas");
      MareBusinessID idZonas = new MareBusinessID("INCObtenerZonasConcursoAmbito");
      Vector vecZ = new Vector();
      vecZ.add(dtoARC);
      vecZ.add(idZonas);
      DTOSalida dtoZonas = (DTOSalida) conectar("ConectorUA",vecZ).objeto("dtoSalida"); 
      RecordSet zona = (RecordSet)dtoZonas.getResultado();
      Vector colZona = zona.getColumnIdentifiers();
      DruidaConector zonas = generarConector("DTOSalida.zonas_ROWSET",zona, colZona);
      //traza("zonas "+dtoZonas.getResultado());
      //traza("zonas "+dtoZonas.getResultado().getColumnIdentifiers());
      this.crearListaLP(colZona, zona.getColumnCount(), "CapaZon","ListaZonas", "14", "200");
      asignar("LISTA", "ListaZonas", zonas, "DTOSalida.zonas_ROWSET");  
      
      //cargo la lista oculta de Secciones
      traza("antesde la lista oculta de Secciones");
      MareBusinessID idSecciones = new MareBusinessID("INCObtenerSeccionesConcursoAmbito");
      Vector vecSec = new Vector();
      vecSec.add(dtoARC);
      vecSec.add(idSecciones);
      DTOSalida dtoSecciones = (DTOSalida) conectar("ConectorUA",vecSec).objeto("dtoSalida"); 
      RecordSet seccion = (RecordSet)dtoSecciones.getResultado();
      Vector colSeccion = seccion.getColumnIdentifiers();
      DruidaConector secciones = generarConector("DTOSalida.secciones_ROWSET",seccion, colSeccion);
      //traza("secciones "+dtoSecciones.getResultado());
      //traza("secciones "+dtoSecciones.getResultado().getColumnIdentifiers());
      this.crearListaLP(colSeccion, seccion.getColumnCount(), "CapaSeccion","ListaSecciones", "14", "200");
      asignar("LISTA", "ListaSecciones", secciones, "DTOSalida.secciones_ROWSET");  
      
      //cargo la lista oculta de Territorios
      traza("antesde la lista oculta de Territorios");
      MareBusinessID idTerritorios = new MareBusinessID("INCObtenerTerritoriosConcursoAmbito");
      Vector vecTer = new Vector();
      vecTer.add(dtoARC);
      vecTer.add(idTerritorios);
      DTOSalida dtoTerritorios = (DTOSalida) conectar("ConectorUA",vecTer).objeto("dtoSalida"); 
      RecordSet territorio = (RecordSet)dtoTerritorios.getResultado();
      Vector colTerritorio = territorio.getColumnIdentifiers();
      DruidaConector territorios = generarConector("DTOSalida.territorios_ROWSET",territorio, colTerritorio);
      //traza("territorios "+dtoTerritorios.getResultado());
      //traza("territorios "+dtoTerritorios.getResultado().getColumnIdentifiers());
      this.crearListaLP(colTerritorio, territorio.getColumnCount(), "CapaTerritorio","ListaTerritorios", "14", "200");
      asignar("LISTA", "ListaTerritorios", territorios, "DTOSalida.territorios_ROWSET");  

   */
   }
   
   private void resultadosRanking() throws Exception{
      pagina("contenido_resultado_ranking_presentar");
      
     //try{
                 
        DTOVentaRankingGerentes dto = new DTOVentaRankingGerentes();
        MareBusinessID id = new MareBusinessID("INCRecuperarVentaRankinGerentes");
        String oidConcurso = conectorParametroLimpia("oidConcurso", "", true);
        asignarAtributo("VAR", "oidConcurso", "valor", oidConcurso);
        dto.setOidConcurso(new Long(oidConcurso));

		traza("1");
                
        String nivelAgregacion = conectorParametroLimpia("oidNivelAgrupacion", "", true);     
       
        asignarAtributo("VAR", "nivelAgrupacion", "valor", nivelAgregacion);
        asignarAtributo("VAR", "agrupacionGeneral", "valor", ConstantesINC.OID_AGRUPACION_GENERAL_RANKING.toString());
        asignarAtributo("VAR", "agrupacionSGV", "valor", ConstantesINC.OID_AGRUPACION_SUBGERENCIA_VTA_RANKING.toString() );
        asignarAtributo("VAR", "agrupacionRegion", "valor", ConstantesINC.OID_AGRUPACION_REGION_RANKING.toString() );
        asignarAtributo("VAR", "agrupacionZona", "valor", ConstantesINC.OID_AGRUPACION_ZONA_RANKING.toString() );
        asignarAtributo("VAR", "agrupacionSeccion", "valor", ConstantesINC.OID_AGRUPACION_SECCION_RANKING.toString()); 
        asignarAtributo("VAR", "agrupacionTerritorio", "valor", ConstantesINC.OID_AGRUPACION_TERRITORIO_RANKING.toString()); 
        
        dto.setOidNivelAgrupacion(new Long(nivelAgregacion));
        
        String numAspi = conectorParametroLimpia("numAspi", "", true);   
        dto.setIndIncurrencias(new Integer(new Long(numAspi).intValue()));

		traza("2");
 
        //SGV    
        String sgv = conectorParametroLimpia("sgv", "", true);    
		traza("sgv: " + sgv);

        if(!sgv.equals("")){
           dto.setOidSGV(this.armarUG(sgv));   
        }
      
        //Region 
        String region = conectorParametroLimpia("region", "", true);      
		traza("region: " + region);

        if(!region.equals("")){
           dto.setOidRegion(this.armarUG(region));   
           // BORRAR
          /* Long[] a = new Long[]{new Long(1),new Long(3)};
           dto.setOidRegion(a);
           */
        }
      
        //Zona
        String zona = conectorParametroLimpia("zona", "", true);      
		traza("zona: " + zona);

        if(!zona.equals("")){
          dto.setOidZona(this.armarUG(zona));   
           // BORRAR
          /* Long[] a = new Long[]{new Long(11),new Long(2)};
           dto.setOidZona(a);
           */
        }
      
        //Seccion
        String seccion = conectorParametroLimpia("seccion", "", true);      
		traza("seccion: " + seccion);

        if(!seccion.equals("")){
           dto.setOidSeccion(this.armarUG(seccion));   
           // BORRAR
           /*Long[] a = new Long[]{new Long(2)};
           dto.setOidSeccion(a);
           */
        }
      
        //Territorio
        String territorio = conectorParametroLimpia("territorio", "", true);      
		traza("territorio: " + territorio);

        if(!territorio.equals("")){
           dto.setOidTerritorio(this.armarUG(territorio));   
        }

		traza("2.5");

        String oidTipoRanking = conectorParametroLimpia("tipoRanking", "", true);      
        if(!oidTipoRanking.equals("")){
          dto.setOidTipoRanking( new Long(oidTipoRanking) );
		}	

		traza("oidTipoRanking : " + oidTipoRanking);
		traza("3.0");
        
        dto.setOidPais(UtilidadesSession.getPais(this));
        Vector vec = new Vector();
        
        vec.add(dto);
        vec.add(id);
        DruidaConector con =  conectar("ConectorRecuperarVentaRankingGerentes", vec);
        DTOSalida dtoArbol = (DTOSalida) con.objeto("DTOSalida"); 
        RecordSet arbol = (RecordSet)dtoArbol.getResultado();

		traza("3.1: " + arbol);
        Vector colArbol = arbol.getColumnIdentifiers();
        DruidaConector arboles = generarConector("DTOSalida.arbol_ROWSET",arbol, colArbol);
        traza("colArbol "+dtoArbol.getResultado());
        traza("colArbol "+dtoArbol.getResultado().getColumnIdentifiers());

		if (arbol.getColumnCount()!= 0) {
			// Hay datos para el arbol
			this.crearListaLP(colArbol, arbol.getColumnCount(), "CapaArbol","ListaArbol", "14", "200");
			asignar("LISTA", "ListaArbol", arboles, "DTOSalida.arbol_ROWSET"); 
		}

		traza("4");
		
		IMareDTO dtoMare = (IMareDTO)con.objeto("DTOSalida");
		RecordSet colRanking = new RecordSet();    
		colRanking = (RecordSet)dtoMare.getProperty("resultado");
		
		traza("5");
		
		this.crearArbol(colRanking, new Long(nivelAgregacion));         
        
      //} catch (Exception e) {

		    /* if(e instanceof InvocationTargetException) {
            if (((InvocationTargetException) e).getTargetException() instanceof MareException) {
                 MareException mareException = (MareException) ((InvocationTargetException) e).getTargetException();
                 traza("la mare-exc. que me retorna, tiene el codigo : " + mareException.getCode());	                 

                if (mareException.getCode() == 130025) {            
           		    this.lanzarPaginaError(e);
		              asignarAtributo("VAR", "ejecutarError", "valor", "close();");
                }
            }
         }   
      } */     
     
   }    
   
   private void crearArbol(RecordSet colRanking, Long nivelAgrupacion) throws Exception{
        DruidaDOMObjeto miObj = new DruidaDOMObjeto();
        Document document = this.getXML();

        traza("entrada"+colRanking.toString());
      
        Element element = document.createElement("ARBOL");
        
        miObj.setXML(element);
      
        this.setAttr2MenuTag(element,"0");
         
        Element elementRoot = this.getXML().createElement("RAMA");
        elementRoot.setAttribute("nombre", "root");
        elementRoot.setAttribute("icono", "1");
        elementRoot.setAttribute("codigo", "root");
        elementRoot.setAttribute("texto", "Jerarquía de unidad geográfica");
        element.appendChild(elementRoot);

		if(!colRanking.esVacio()){
			this.addBranches(colRanking,elementRoot, nivelAgrupacion);
		}

        DruidaConector drd = new DruidaConector();
        drd.setXML(miObj.getXML());
      
        traza("drd.getXML().......: " + elementRoot.toString());
        traza("drd.getXML().......: " + miObj.getXML());
        traza("salida.......: " + drd.getXML());      
      
        asignar("REJILLA", "RArbol", drd);
  }
  
   private void addBranches(RecordSet colRanking,Element elementRoot, Long nivelAgrupacion) throws Exception{	
      
      Long agrupacionGeneral    = ConstantesINC.OID_AGRUPACION_GENERAL_RANKING;
      Long agrupacionSGV        = ConstantesINC.OID_AGRUPACION_SUBGERENCIA_VTA_RANKING;
      Long agrupacionRegion     = ConstantesINC.OID_AGRUPACION_REGION_RANKING;
      Long agrupacionZona       = ConstantesINC.OID_AGRUPACION_ZONA_RANKING;
      Long agrupacionSeccion    = ConstantesINC.OID_AGRUPACION_SECCION_RANKING; 
      Long agrupacionTerritorio = ConstantesINC.OID_AGRUPACION_TERRITORIO_RANKING;    
      
      
    // Arma el arbol segun el agrupamiento
	  if(nivelAgrupacion.equals(agrupacionGeneral)){
          traza("Agrupacion General");
          this.agrupGeneral(colRanking, elementRoot);
		  
      }
      if(nivelAgrupacion.equals(agrupacionSGV)){
          traza("Agrupacion por Subg");
          this.agrupSubg(colRanking, elementRoot);
        
      } else if((nivelAgrupacion.equals(agrupacionRegion))){
          traza("Agrupacion por Region");
          this.agrupReg(colRanking, elementRoot);
          
      } else if((nivelAgrupacion.equals(agrupacionZona))){
          traza("Agrupacion por Zona");
          this.agrupZona(colRanking, elementRoot);
        
      } else if(nivelAgrupacion.equals(agrupacionSeccion) || nivelAgrupacion.equals(agrupacionTerritorio)){
          traza("Agrupacion por Seccion y Territorio");
          this.agrupSeccion(colRanking, elementRoot);
      }
  }
  
  private void agrupSeccion(RecordSet colRanking, Element elementRoot) throws Exception{
  
      String subgerenciaAnterior = null;
      String subgerenciaActual = null;
      Element sgvElementAnterior = null;
      String regionAnterior = null;
      String regionActual = null;
      Element regElementAnterior = null;
      String zonaAnterior = null;
      String zonaActual = null;
      Element zonaElementAnterior = null;
      String seccionAnterior = null;
      String seccionActual = null;
      Element seccionElementAnterior = null;
      
      Element sgv = null;   
      Element region = null;   
      Element zona = null;   
      Element seccion = null;   
      
      for (int i = 0; i < colRanking.getRowCount(); i++) {
      
          subgerenciaActual = colRanking.getValueAt(i,1).toString();
          regionActual = colRanking.getValueAt(i,3).toString();
          zonaActual = colRanking.getValueAt(i,5).toString();
          seccionActual = colRanking.getValueAt(i,7).toString();
          
          if(subgerenciaActual.equals(subgerenciaAnterior)){
              traza("igual subg");
              if(regionActual.equals(regionAnterior)){
                  traza("igual reg");
                  if(zonaActual.equals(zonaAnterior)){
                      traza("igual zona");
                      if(seccionActual.equals(seccionAnterior)){
                          traza("igual seccion");
                          crearGerente(seccionElementAnterior, colRanking, i, 10); 
                          seccionAnterior = seccionActual;
                          seccionElementAnterior = seccion;
                      } else {
                          traza("dist seccion");
                          seccion = crearSeccion(zonaElementAnterior, colRanking, i); 
                          crearGerente(seccion, colRanking, i, 10); 
                          seccionAnterior = seccionActual;
                          seccionElementAnterior = seccion;
                      }
                      
                  } else {
                      traza("dist zona");
                      zona = crearZona(regElementAnterior, colRanking, i); 
                      seccion = crearSeccion(zona, colRanking, i); 
                      crearGerente(seccion, colRanking, i, 10); 
                      zonaAnterior = zonaActual;
                      zonaElementAnterior = zona;
                      seccionAnterior = seccionActual;
                      seccionElementAnterior = seccion;
                  }
              
              } else {
                  traza("dist reg");
                  region = crearRegion(sgvElementAnterior, colRanking, i); 
                  zona = crearZona(region, colRanking, i); 
                  seccion = crearSeccion(zona, colRanking, i); 
                  crearGerente(seccion, colRanking, i, 10); 
                  regionAnterior = regionActual;
                  regElementAnterior = region;
                  zonaAnterior = zonaActual;
                  zonaElementAnterior = zona;
                  seccionAnterior = seccionActual;
                  seccionElementAnterior = seccion;
              }
            
          } else {
              traza("dist subg");
              sgv = crearSubgerencia(elementRoot, colRanking, i); 
              region = crearRegion(sgv, colRanking, i); 
              zona = crearZona(region, colRanking, i); 
              seccion = crearSeccion(zona, colRanking, i); 
              crearGerente(seccion, colRanking, i, 10); 
              subgerenciaAnterior = subgerenciaActual;
              sgvElementAnterior = sgv;
              regionAnterior = regionActual;
              regElementAnterior = region;
              zonaAnterior = zonaActual;
              zonaElementAnterior = zona;
              seccionAnterior = seccionActual;
              seccionElementAnterior = seccion;
          } 
      }
  }
  
  
  private void agrupZona(RecordSet colRanking, Element elementRoot) throws Exception{
  
      String subgerenciaAnterior = null;
      String subgerenciaActual = null;
      Element sgvElementAnterior = null;
      String regionAnterior = null;
      String regionActual = null;
      Element regElementAnterior = null;
      String zonaAnterior = null;
      String zonaActual = null;
      Element zonaElementAnterior = null;
      
      Element sgv = null;   
      Element region = null;   
      Element zona = null;   
      
      for (int i = 0; i < colRanking.getRowCount(); i++) {
      
          subgerenciaActual = colRanking.getValueAt(i,1).toString();
          regionActual = colRanking.getValueAt(i,3).toString();
          zonaActual = colRanking.getValueAt(i,5).toString();
          
          if(subgerenciaActual.equals(subgerenciaAnterior)){
              traza("igual subg");
              if(regionActual.equals(regionAnterior)){
                  traza("igual reg");
                  if(zonaActual.equals(zonaAnterior)){
                      traza("igual zona");
                      crearGerente(zonaElementAnterior, colRanking, i, 8); 
                      zonaAnterior = zonaActual;
                      zonaElementAnterior = zona;
                  } else {
                      traza("dist zona");
                      zona = crearZona(regElementAnterior, colRanking, i); 
                      crearGerente(zona, colRanking, i, 8); 
                      zonaAnterior = zonaActual;
                      zonaElementAnterior = zona;
                  }
              
              } else {
                  traza("dist reg");
                  region = crearRegion(sgvElementAnterior, colRanking, i); 
                  zona = crearZona(region, colRanking, i); 
                  crearGerente(zona, colRanking, i, 8); 
                  regionAnterior = regionActual;
                  regElementAnterior = region;
                  zonaAnterior = zonaActual;
                  zonaElementAnterior = zona;
              }
            
          } else {
              traza("dist subg");
              sgv = crearSubgerencia(elementRoot, colRanking, i); 
              region = crearRegion(sgv, colRanking, i); 
              zona = crearZona(region, colRanking, i); 
              crearGerente(zona, colRanking, i, 8); 
              subgerenciaAnterior = subgerenciaActual;
              sgvElementAnterior = sgv;
              regionAnterior = regionActual;
              regElementAnterior = region;
              zonaAnterior = zonaActual;
              zonaElementAnterior = zona;
          } 
      }
  }
  
  private void agrupReg(RecordSet colRanking, Element elementRoot) throws Exception{
  
      String subgerenciaAnterior = null;
      String subgerenciaActual = null;
      Element sgvElementAnterior = null;
      String regionAnterior = null;
      String regionActual = null;
      Element regElementAnterior = null;
      
      Element sgv = null;   
      Element region = null;   
      
      for (int i = 0; i < colRanking.getRowCount(); i++) {
      
          subgerenciaActual = colRanking.getValueAt(i,1).toString();
          regionActual = colRanking.getValueAt(i,3).toString();
          
          if(subgerenciaActual.equals(subgerenciaAnterior)){
              traza("igual subg");
              if(regionActual.equals(regionAnterior)){
                  traza("igual reg");
                  crearGerente(regElementAnterior, colRanking, i, 6); 
                  regionAnterior = regionActual;
                  regElementAnterior = region;
              
              } else {
                  traza("dist reg");
                  region = crearRegion(sgvElementAnterior, colRanking, i); 
                  crearGerente(region, colRanking, i, 6); 
                  regionAnterior = regionActual;
                  regElementAnterior = region;
              }
            
          } else {
              traza("dist subg");
              sgv = crearSubgerencia(elementRoot, colRanking, i); 
              region = crearRegion(sgv, colRanking, i); 
              crearGerente(region, colRanking, i, 6); 
              subgerenciaAnterior = subgerenciaActual;
              sgvElementAnterior = sgv;
              regionAnterior = regionActual;
              regElementAnterior = region;
          } 
      }
  }
  
  private void agrupSubg(RecordSet colRanking, Element elementRoot) throws Exception{
  
      String subgerenciaAnterior = null;
      String subgerenciaActual = null;
      Element sgvElementAnterior = null;
      Element sgv = null;   
  
      for (int i = 0; i < colRanking.getRowCount(); i++) {
             
          subgerenciaActual = colRanking.getValueAt(i,1).toString();
       
          if(subgerenciaActual.equals(subgerenciaAnterior)){
              crearGerente(sgvElementAnterior, colRanking, i, 4); 
              subgerenciaAnterior = subgerenciaActual;
              sgvElementAnterior = sgv;
              
          } else {
              sgv = crearSubgerencia(elementRoot, colRanking, i); 
              crearGerente(sgv, colRanking, i, 4); 
              subgerenciaAnterior = subgerenciaActual;
              sgvElementAnterior = sgv;
          } 
      }
  }

  // vbongiov -- 9/11/2006
  private void agrupGeneral(RecordSet colRanking, Element elementRoot) throws Exception{
  
      for (int i = 0; i < colRanking.getRowCount(); i++) {
             
          crearGerente(elementRoot, colRanking, i, 2); 
      }
  }
  
  private Element crearSeccion(Element elementPadre, RecordSet colRanking, int i) throws Exception{
      Element seccion = null;   
       
      seccion = this.getXML().createElement("RAMA");
      seccion.setAttribute("nombre", "name"+ colRanking.getValueAt(i,8).toString());
      seccion.setAttribute("icono", "1");
      seccion.setAttribute("codigo", colRanking.getValueAt(i,7).toString()); 
      seccion.setAttribute("texto", colRanking.getValueAt(i,8).toString());
      
      // Agrega la seccion a root
      elementPadre.appendChild(seccion);
      
      return seccion;
  }
  
  private Element crearZona(Element elementPadre, RecordSet colRanking, int i) throws Exception{
      Element zona = null;   
       
      zona = this.getXML().createElement("RAMA");
      zona.setAttribute("nombre", "name"+ colRanking.getValueAt(i,6).toString());
      zona.setAttribute("icono", "1");
      zona.setAttribute("codigo", colRanking.getValueAt(i,5).toString()); 
      zona.setAttribute("texto", colRanking.getValueAt(i,6).toString());
      
      // Agrega la zona a root
      elementPadre.appendChild(zona);
      
      return zona;
  }
  
  private Element crearRegion(Element elementPadre, RecordSet colRanking, int i) throws Exception{
      Element region = null;   
       
      region = this.getXML().createElement("RAMA");
      region.setAttribute("nombre", "name"+ colRanking.getValueAt(i,4).toString());
      region.setAttribute("icono", "1");
      region.setAttribute("codigo", colRanking.getValueAt(i,3).toString()); 
      region.setAttribute("texto", colRanking.getValueAt(i,4).toString());
      
      // Agrega la region a root
      elementPadre.appendChild(region);
      
      return region;
  }
  
  private Element crearSubgerencia(Element elementPadre, RecordSet colRanking, int i) throws Exception{
      Element sgv = null;   
       
      sgv = this.getXML().createElement("RAMA");
      sgv.setAttribute("nombre", "name"+ colRanking.getValueAt(i,2).toString());
      sgv.setAttribute("icono", "1");
      sgv.setAttribute("codigo", colRanking.getValueAt(i,1).toString()); 
      sgv.setAttribute("texto", colRanking.getValueAt(i,2).toString());
      
      // Agrega la subgerencia a root
      elementPadre.appendChild(sgv);
      
      return sgv;
  }
  
  private void crearGerente(Element elementPadre, RecordSet colRanking, int i, int pos) throws Exception{
        Element gerente = null;
        Element total = null;
        
        gerente = this.getXML().createElement("RAMA");
        gerente.setAttribute("nombre", "name"+colRanking.getValueAt(i,pos).toString());
        gerente.setAttribute("icono", "1");
        gerente.setAttribute("codigo", colRanking.getValueAt(i,pos).toString()); 
        gerente.setAttribute("texto", colRanking.getValueAt(i,pos).toString());
              
        total = this.getXML().createElement("HOJA");
        total.setAttribute("nombre", "nameTotal"+colRanking.getValueAt(i,pos).toString());
        total.setAttribute("icono", "2");
        total.setAttribute("codigo", colRanking.getValueAt(i,0).toString()); 
        total.setAttribute("texto", UtilidadesBelcorp.formateaNumeroSICC(colRanking.getValueAt(i,pos+1).toString(), this.FORMATO_DEFAULT, this));
        total.setAttribute("onclick", "obtenerOid();");

        
        // Agrega el total a gerentes
        gerente.appendChild(total);
        
        // Agrega el gerente a la rama padre
        elementPadre.appendChild(gerente);
  }
        
/*private Element addElement(Vector vec,Element element,String tag) throws Exception{
                  Element elementAux;    
                  elementAux = this.getXML().createElement(tag);

    if (tag.equals("RAMA")){      
      Vector hijo = vec;
      
      traza("creo Rama " + hijo.get(0));
      elementAux = this.getXML().createElement("RAMA");
      elementAux.setAttribute("nombre", "name"+hijo.get(0));
      elementAux.setAttribute("icono", "1");
      elementAux.setAttribute("codigo", hijo.get(0).toString()); 
      elementAux.setAttribute("texto", hijo.get(1).toString());
      elementAux.setAttribute("onclick", "miFuncionArbol(name0,p1,p2,p4,soypadre);");    
      
    

      
    } else {
      //Nuevo
   
           traza("creo Hoja "+hijo.get().toString());
           elementAux.setAttribute("nombre", "name"+hijo.getOidDetalle().toString());
           elementAux.setAttribute("icono", "2");
           elementAux.setAttribute("codigo", hijo.getOidDetalle().toString());
           elementAux.setAttribute("onclick", "fhoja();");
           if (hijo.getZona().getCodigoZona()!=null) //CAMBIAR CODIGO POR DESCRIPCIOn
                elementAux.setAttribute("texto", hijo.getZona().getDescZona());
           else
                elementAux.setAttribute("texto", "Zona Sin Descripcion");
      }else{
           DTOCabecerasGruposZonas hijo = (DTOCabecerasGruposZonas)dto;
           traza("creo Hoja/RAMA "+hijo.getOidGrupo().toString());
           elementAux.setAttribute("nombre", "name"+hijo.getOidGrupo().toString());
           elementAux.setAttribute("icono", "2");
           elementAux.setAttribute("codigo", hijo.getOidGrupo().toString());
           elementAux.setAttribute("onclick", "miFuncionArbol(name0,p1,p2,p4,soypadre);");
           if (hijo.getNombreGrupo()!=null) //CAMBIAR CODIGO POR DESCRIPCIOn
                elementAux.setAttribute("texto", hijo.getNombreGrupo());
           else
                elementAux.setAttribute("texto", "Rama Sin Descripcion");
      }
      
    }
    traza("addElement:"+elementAux.toString()); 
                  element.appendChild(elementAux);
                  return elementAux;
         }*/
  
  private void setAttr2MenuTag(Element element,String oid) throws Exception{
     element.setAttribute("x","1" ) ;
     element.setAttribute("y", "1");
     element.setAttribute("nombre", "name"+oid);
     element.setAttribute("id", "datosCampos");
     element.setAttribute("ancho", "300"); 
     element.setAttribute("alto", "210");
     element.setAttribute("multisel", "S");    
     element.setAttribute("incx", "10");
     element.setAttribute("incy", "10");
     element.setAttribute("visibilidad", "");
     element.setAttribute("padreSeleccionable", "S");
     element.setAttribute("oncolor", "#D0D9E8");
     element.setAttribute("overcolor", "#DDDDDD");

     this.addIconos(element);
  }
  
  private void addIconos(Element element) throws Exception{
     Element elementAux = this.getXML().createElement("ICONOS");
     element.appendChild(elementAux);
     element = this.getXML().createElement("ICONO");
     element.setAttribute("src", "b.gif");
     elementAux.appendChild(element);
     element = this.getXML().createElement("ICONO");
     element.setAttribute("src", "flechaMenuVert.gif");
     elementAux.appendChild(element);
     element = this.getXML().createElement("ICONO");
     element.setAttribute("src", "flechaMenuHorz.gif");
     elementAux.appendChild(element);
  }

 
   
   private Long[] armarUG(String parametro) throws Exception{
      
        StringTokenizer tok = new StringTokenizer(parametro, ",");
        ArrayList arrList = new ArrayList();
  
        while (tok.hasMoreTokens()) {
           arrList.add( new Long(tok.nextToken()));
        }
         
        return((Long[])arrList.toArray(new Long[arrList.size()]));      
   
   }
  
  
   
   private void verDesglose() throws Exception{
      pagina("contenido_premios_ranking_detalle_gerentes");   
      this.getFormatosValidaciones();     
      
      String nivelAgrupacion = conectorParametroLimpia("nivelAgrupacion", "", true);
      
      String sgv            = conectorParametroLimpia("sgv", "", true);
      String gerente        = conectorParametroLimpia("gerente", "", true);
      String impVentas      = conectorParametroLimpia("impVentas", "", true);
      String actiIni        = conectorParametroLimpia("actiIni", "", true);
      String actiFinal      = conectorParametroLimpia("actiFinal", "", true);
      String nPedidos       = conectorParametroLimpia("nPedidos", "", true);
      String actividad      = conectorParametroLimpia("actividad", "", true);
      String constancia     = conectorParametroLimpia("constancia", "", true);
      String ingresos       = conectorParametroLimpia("ingresos", "", true);
      String reingresos     = conectorParametroLimpia("reingresos", "", true);
      String egresos        = conectorParametroLimpia("egresos", "", true);
      String entregadas     = conectorParametroLimpia("entregadas", "", true);
      String recibidas      = conectorParametroLimpia("recibidas", "", true);
      String capitalizacion = conectorParametroLimpia("capitalizacion", "", true);
      String ppu            = conectorParametroLimpia("ppu", "", true);
      String pvp            = conectorParametroLimpia("pvp", "", true);
      String pup            = conectorParametroLimpia("pup", "", true);
      String pop            = conectorParametroLimpia("pop", "", true);
      String retencion      = conectorParametroLimpia("retencion", "", true);
      String cobranza       = conectorParametroLimpia("cobranza", "", true);
      String rotacion       = conectorParametroLimpia("rotacion", "", true);
         
      
      String region        = conectorParametroLimpia("region", "", true); 
      if(!region.equals("")){
         asignarAtributo("LABELC", "lbldtRegion", "valor", region);
      }
      
      String zona         = conectorParametroLimpia("zona", "", true); 
      if(!zona.equals("")){
         asignarAtributo("LABELC", "lbldtZona", "valor", zona);
      }
            
      String seccion      = conectorParametroLimpia("seccion", "", true); 
      if(!seccion.equals("")){
         asignarAtributo("LABELC", "lbldtSeccion", "valor", seccion);
      }
         
      if(!sgv.equals("")){
         asignarAtributo("LABELC", "lbldtSubgerenciaVentas", "valor", sgv);
      }
      
      if(!gerente.equals("")){
         asignarAtributo("LABELC", "lbldtGerente", "valor", gerente);
      }
      
      if(!impVentas.equals("")){
         asignarAtributo("LABELC", "lbldtImporteVentas1", "valor", UtilidadesBelcorp.formateaNumeroSICC(impVentas, this.FORMATO_MONEDA, this));
      }
      
      if(!actiIni.equals("")){
         asignarAtributo("LABELC", "lbldtActivasIniciales1", "valor", UtilidadesBelcorp.formateaNumeroSICC(actiIni, this.FORMATO_DEFAULT, this));
      }
      
      if(!actiFinal.equals("")){
         asignarAtributo("LABELC", "lbldtActivasFinales1", "valor", UtilidadesBelcorp.formateaNumeroSICC(actiFinal, this.FORMATO_DEFAULT, this));
      }   
      
      if(!nPedidos.equals("")){
         asignarAtributo("LABELC", "lbldtNumPedidos1", "valor", UtilidadesBelcorp.formateaNumeroSICC(nPedidos, this.FORMATO_DEFAULT, this));
      }  
      
      if(!actividad.equals("")){
         asignarAtributo("LABELC", "lbldtActividad1", "valor", UtilidadesBelcorp.formateaNumeroSICC(actividad, this.FORMATO_DEFAULT, this));
      }  
      
      if(!constancia.equals("")){
         asignarAtributo("LABELC", "lbldtConstancia1", "valor", UtilidadesBelcorp.formateaNumeroSICC(constancia, this.FORMATO_DEFAULT, this));
      }  
      
      if(!ingresos.equals("")){
         asignarAtributo("LABELC", "lbldtIngresos1", "valor", UtilidadesBelcorp.formateaNumeroSICC(ingresos, this.FORMATO_DEFAULT, this));
      }  
      
      if(!reingresos.equals("")){
         asignarAtributo("LABELC", "lbldtReingresos1", "valor", UtilidadesBelcorp.formateaNumeroSICC(reingresos, this.FORMATO_DEFAULT, this));
      }  
      
      if(!egresos.equals("")){
         asignarAtributo("LABELC", "lbldtEgresos1", "valor", UtilidadesBelcorp.formateaNumeroSICC(egresos, this.FORMATO_DEFAULT, this));
      } 
      
      if(!entregadas.equals("")){
         asignarAtributo("LABELC", "lbldtEntregadas1", "valor", UtilidadesBelcorp.formateaNumeroSICC(entregadas, this.FORMATO_DEFAULT, this));
      } 
      
      if(!recibidas.equals("")){
         asignarAtributo("LABELC", "lbldtRecibidas1", "valor", UtilidadesBelcorp.formateaNumeroSICC(recibidas, this.FORMATO_DEFAULT, this));
      } 
      
      if(!capitalizacion.equals("")){
         asignarAtributo("LABELC", "lbldtCapitalizacion1", "valor", UtilidadesBelcorp.formateaNumeroSICC(capitalizacion, this.FORMATO_DEFAULT, this));
      } 
      
      if(!ppu.equals("")){
         asignarAtributo("LABELC", "lbldtPPU1", "valor", UtilidadesBelcorp.formateaNumeroSICC(ppu, this.FORMATO_DEFAULT, this));
      } 
      
      if(!pvp.equals("")){
         asignarAtributo("LABELC", "lbldtPVP1", "valor", UtilidadesBelcorp.formateaNumeroSICC(pvp, this.FORMATO_DEFAULT, this));
      } 
         
      if(!pup.equals("")){
         asignarAtributo("LABELC", "lbldtPUP1", "valor", UtilidadesBelcorp.formateaNumeroSICC(pup, this.FORMATO_DEFAULT, this));
      } 
      
      if(!pop.equals("")){
         asignarAtributo("LABELC", "lbldtPOP1", "valor", UtilidadesBelcorp.formateaNumeroSICC(pop, this.FORMATO_DEFAULT, this));
      } 
      
      if(!retencion.equals("")){
         asignarAtributo("LABELC", "lbldtRetencion1", "valor", UtilidadesBelcorp.formateaNumeroSICC(retencion, this.FORMATO_DEFAULT, this));
      } 
      
      if(!cobranza.equals("")){
         asignarAtributo("LABELC", "lbldtCobranza1", "valor", UtilidadesBelcorp.formateaNumeroSICC(cobranza, this.FORMATO_DEFAULT, this));
      } 
      
      if(!rotacion.equals("")){
         asignarAtributo("LABELC", "lbldtRotacion1", "valor", UtilidadesBelcorp.formateaNumeroSICC(rotacion, this.FORMATO_DEFAULT, this));
      } 
  
      
      
   }
   
   private void asignarPremiosRankingRecuperarNiveles() throws Exception{
      pagina("contenido_premios_ranking_asignar");
      //Recuperar los oid de los gerentes envidados desde la ventana llamante y setearlos 
      //al hidden oidClientes 

      //Crear idBussiness "INCRecuperarPremiosNiveles" 
      //Crear DTORankingNivelesPremios dto con oidConcurso y version del 
      //concurso recibidos desde la ventana llamante 
      
      MareBusinessID id = new MareBusinessID("INCRecuperarPremiosNiveles");
      DTORankingNivelesPremios dto = new DTORankingNivelesPremios();
      DruidaConector con = null;
      DTOSalida dtoS = null;
            
      String concurso = conectorParametroLimpia("concurso", "", true);
      String gerentes = conectorParametroLimpia("gerentes", "", true);
      asignarAtributo("VAR", "gerentes", "valor", gerentes);
      asignarAtributo("VAR", "oidConcurso", "valor", concurso);
      
      
      dto.setOidConcurso(new Long(concurso));
      dto.setOidIdioma(UtilidadesSession.getIdioma(this));
      dto.setTamanioPagina(new Integer(20));
      dto.setIndicadorSituacion(new Long(0));
         
         
      Vector vec = new Vector();
      vec.add(dto);
      vec.add(id);
      traza("Paso 10");
      
      con = conectar("ConectorRecuperarPremiosNiveles",vec);
      if( con != null ){
         traza("Paso 11");

         dtoS = (DTOSalida)con.objeto("DTOSalida");
         RecordSet res = dtoS.getResultado();

         if(!res.esVacio()){
            DruidaConector conLista = UtilidadesBelcorp.generarConector("LISTA", res, res.getColumnIdentifiers());
            asignar("LISTADOA", "listado1", conLista, "LISTA");

         }
      }
        
   }
   
   private void cargarGanadoras() throws Exception{
      pagina("contenido_datos_concurso_ranking_mostrar");
      
      asignarAtributo("VAR","oidConcurso","valor", conectorParametroLimpia("oidConcurso", "", true));
      asignarAtributo("VAR","oidNivelPremiacion","valor", conectorParametroLimpia("oidNivelPremiacion", "", true));
      asignarAtributo("VAR","inicialPuntos","valor", conectorParametroLimpia("inicialPuntos", "", true));
      asignarAtributo("VAR","finalPuntos","valor", conectorParametroLimpia("finalPuntos", "", true));
      asignarAtributo("VAR","numPremio","valor", conectorParametroLimpia("numPremio", "", true));
      asignarAtributo("VAR","numAspirantes","valor", conectorParametroLimpia("numAspirantes", "", true));
      asignarAtributo("VAR","oidPremio","valor", conectorParametroLimpia("oidPremio", "", true));
      asignarAtributo("VAR","oidTipoPremio","valor", conectorParametroLimpia("oidTipoPremio", "", true));
	  asignarAtributo("VAR","hIndCalificar","valor", conectorParametroLimpia("indCalificar", "", true));
	  asignarAtributo("VAR","pantalla","valor", conectorParametroLimpia("pantalla", "", true));
   }
  
   private void comunicarAParticipantes() throws Exception{
      pagina("salidaGenerica");
     
      DTOComunicarParticipantes dto = new DTOComunicarParticipantes();
      
      String clientes = conectorParametroLimpia("oidClientes", "", true);
      String posiciones = conectorParametroLimpia("posiciones", "", true);
      traza("las posiciones "  + posiciones);

	  String pantalla = conectorParametroLimpia("pantalla", "", true);

      ArrayList oidsClientes = new ArrayList();
      ArrayList numPosiciones = new ArrayList();
           
      StringTokenizer tokTemp = new StringTokenizer(clientes, ",");
      StringTokenizer tokTempPos = new StringTokenizer(posiciones, ",");
      
      while (tokTemp.hasMoreTokens()) {
         oidsClientes.add( new Long(tokTemp.nextToken()));
      }
      
      while (tokTempPos.hasMoreTokens()) {
         numPosiciones.add( new Long(tokTempPos.nextToken()));
      }
          
      
      dto.setClientes((Long[])oidsClientes.toArray(new Long[oidsClientes.size()]));
      dto.setPosicion((Long[])numPosiciones.toArray(new Long[numPosiciones.size()]));
      dto.setOidPais(UtilidadesSession.getPais(this));
	  dto.setOidIdioma(UtilidadesSession.getIdioma(this));
      dto.setOidConcurso(new Long(conectorParametroLimpia("oidConcurso", "", true)));
      dto.setOidTipoPremio(new Long(conectorParametroLimpia("oidTipoPremio", "", true)));
      dto.setOidNivelPremiacion(new Long(conectorParametroLimpia("oidNivelPremiacion", "", true)));
      
      traza("el dto: " + dto);

	  MareBusinessID id = null;

	  if(pantalla.equals("resultado concurso evolutivo")){
			id = new MareBusinessID("INCComunicarAParticipantesEvolutivo");
	  } else {
		    id = new MareBusinessID("INCComunicarAParticipantes");
	  }

      Vector vec = new Vector();
      
      vec.add(dto);
      vec.add(id);
      
      DruidaConector con;
      
      con = conectar("ConectorComunicarAParticipantes", vec);
     
   
   }

   // vbongiov -- 26/07/2006 -- inc DBLG500000906
   private void calificar() throws Exception{
      pagina("salidaGenerica");
     
      DTOComunicarParticipantes dto = new DTOComunicarParticipantes();
      
      String clientes = conectorParametroLimpia("oidClientes", "", true);
      String posiciones = conectorParametroLimpia("posiciones", "", true);
      traza("las posiciones "  + posiciones);
      ArrayList oidsClientes = new ArrayList();
      ArrayList numPosiciones = new ArrayList();
           
      StringTokenizer tokTemp = new StringTokenizer(clientes, ",");
      StringTokenizer tokTempPos = new StringTokenizer(posiciones, ",");
      
      while (tokTemp.hasMoreTokens()) {
         oidsClientes.add( new Long(tokTemp.nextToken()));
      }
      
      while (tokTempPos.hasMoreTokens()) {
         numPosiciones.add( new Long(tokTempPos.nextToken()));
      }
          
      
      dto.setClientes((Long[])oidsClientes.toArray(new Long[oidsClientes.size()]));
      dto.setPosicion((Long[])numPosiciones.toArray(new Long[numPosiciones.size()]));
      dto.setOidPais(UtilidadesSession.getPais(this));
	  dto.setOidIdioma(UtilidadesSession.getIdioma(this));
      dto.setOidConcurso(new Long(conectorParametroLimpia("oidConcurso", "", true)));
      dto.setOidTipoPremio(new Long(conectorParametroLimpia("oidTipoPremio", "", true)));
      dto.setOidNivelPremiacion(new Long(conectorParametroLimpia("oidNivelPremiacion", "", true)));
      
      traza("el dto: " + dto);
      MareBusinessID id = new MareBusinessID("INCCalificar");
      Vector vec = new Vector();
      
      vec.add(dto);
      vec.add(id);
      
      DruidaConector con;
      
      con = conectar("ConectorCalificar", vec);
     
   
   }
   
   
   private void  asignarPremios() throws Exception{
      pagina("salidaGenerica");
      asignarAtributo("VAR","cerrarVentana", "valor", "false");
            
      DTOAsignarPremios dto =  new DTOAsignarPremios();
      MareBusinessID id = new MareBusinessID("INCAsignarPremiosRanking");
            
      String gerentes = conectorParametroLimpia("gerentes", "", true);
      String oidConcurso = conectorParametroLimpia("oidConcurso", "", true);
      String niveles = conectorParametroLimpia("niveles", "", true);
      String paramGenerPremi = conectorParametroLimpia("paramGenerPremi", "", true);
      
      traza("gerentes: " + gerentes);
      traza("oidConcurso: " + oidConcurso);
      traza("niveles: " + niveles);
      traza("paramGenerPremi: " + paramGenerPremi);
           
      if(gerentes.indexOf(",") != -1){
      
          StringTokenizer tokTemp = new StringTokenizer(gerentes, ",");
          ArrayList oidsGerentes = new ArrayList();
          while (tokTemp.hasMoreTokens()) {
             oidsGerentes.add( new Long(tokTemp.nextToken()));
          }
          dto.setOidGanadores((Long[])oidsGerentes.toArray(new Long[oidsGerentes.size()]));
      }else{
          Long[] soloUnGerente = new Long[]{new Long(gerentes)};
          dto.setOidGanadores(soloUnGerente);
      }
      
      if(niveles.indexOf(",") != -1){
          StringTokenizer tokTempNiv = new StringTokenizer(niveles, ",");
          ArrayList oidsNiveles = new ArrayList();
      
          while (tokTempNiv.hasMoreTokens()) {
            oidsNiveles.add( new Long(tokTempNiv.nextToken()));
          }
          dto.setOidNivelesPremios((Long[])oidsNiveles.toArray(new Long[oidsNiveles.size()]));
      }else{
          Long[] soloUnNivel = new Long[]{new Long(niveles)};
          dto.setOidNivelesPremios(soloUnNivel);
      }
      
      dto.setOidPGenPrem(new Long(paramGenerPremi));
      dto.setOidConcurso(new Long(oidConcurso));
      
      
      DruidaConector con;
      Vector vec = new Vector();
      vec.add(dto);
      vec.add(id);
      traza("el dto es " + dto);
      con = conectar("ConectorAsignarPremiosRankingGerentes", vec);
   
   }
   


/***************************METODOS AUXILIARES*********************************/   

   private void crearListaLP(Vector nomColumns, int cantColumns,
           String nomCapa, String nomLista, String XCapa, String YCapa)
           throws Exception {
           traza("dentro de crearListaLP()  " + nomColumns + " " + cantColumns);
 
           Document document = getXML();
 
           Element eCapa = document.createElement("CAPA");
           eCapa.setAttribute("nombre", nomCapa);
           eCapa.setAttribute("alto", "162");
           eCapa.setAttribute("ancho", "580");
           eCapa.setAttribute("colorf", "");
           eCapa.setAttribute("borde", "1");
           eCapa.setAttribute("imagenf", "");
           eCapa.setAttribute("repeat", "");
           eCapa.setAttribute("padding", "");
           eCapa.setAttribute("visibilidad", "hidden");
           eCapa.setAttribute("contravsb", "");
           eCapa.setAttribute("zindex", "");
           eCapa.setAttribute("x", XCapa);
           eCapa.setAttribute("y", YCapa);
 
           Element eLista = document.createElement("LISTA");
 
           eLista.setAttribute("seleccion", "boton");
           eLista.setAttribute("nombre", nomLista);
           eLista.setAttribute("ancho", "580");
           eLista.setAttribute("alto", "150");
           eLista.setAttribute("multisel", "0");
           eLista.setAttribute("incy", "1");
           eLista.setAttribute("incx", "10");
           eLista.setAttribute("colorf", "#EFEFEF");
           eLista.setAttribute("imagenoff", "close_no.gif");
           eLista.setAttribute("imagenon", "close_up.gif");
           eLista.setAttribute("accion", "");
           eLista.setAttribute("sep", "|");
           eLista.setAttribute("pixelsborde", "3");
           eLista.setAttribute("colorborde", "#CCCCCC");
 
           Element eCABECERA = document.createElement("CABECERA");
           eCABECERA.setAttribute("nombre", "cabecera");
           eCABECERA.setAttribute("height", "20");
 
           Integer anchoCab;
 
           if (cantColumns < 4) {
                anchoCab = new Integer(580 / cantColumns);
           } else {
                anchoCab = new Integer(150);
           }
 
           Element eCOL_1 = document.createElement("COL");
           eCOL_1.setAttribute("id", "fondoCabecera");
           eCOL_1.setAttribute("ancho", anchoCab.toString());
 
           Element eCOL_2 = document.createElement("COL");
           eCOL_2.setAttribute("id", "fondoCabecera");
           eCOL_2.setAttribute("ancho", anchoCab.toString());
 
           Element eCOL_3 = document.createElement("COL");
           eCOL_3.setAttribute("id", "fondoCabecera");
           eCOL_3.setAttribute("ancho", anchoCab.toString());
 
           Element eCOL_4 = document.createElement("COL");
           eCOL_4.setAttribute("id", "fondoCabecera");
           eCOL_4.setAttribute("ancho", anchoCab.toString());
 
           Element eCOL_5 = document.createElement("COL");
           eCOL_5.setAttribute("id", "fondoCabecera");
           eCOL_5.setAttribute("ancho", anchoCab.toString());
 
           Element eCOL_6 = document.createElement("COL");
           eCOL_6.setAttribute("id", "fondoCabecera");
           eCOL_6.setAttribute("ancho", anchoCab.toString());
 
           Vector columnas = new Vector();
 
           for (int i = 0; i < cantColumns; i++) {
                Element eLABEL_2 = document.createElement("LABELC");
                eLABEL_2.setAttribute("id", "fondoCabecera");
                eLABEL_2.setAttribute("nombre", "lbDivisionesPoliticas" + i);
                eLABEL_2.setAttribute("ancho", anchoCab.toString());
                eLABEL_2.setAttribute("alto", "20");
                eLABEL_2.setAttribute("filas", "1");
                eLABEL_2.setAttribute("id", "datosCamposCabecera");
 
                if (i != 0) {
                      eLABEL_2.setAttribute("valor", (String) nomColumns.get(i));
                } else {
                      eLABEL_2.setAttribute("cod", "199");
                }
 
                eLABEL_2.setAttribute("enviaroculto", "N");
                columnas.add(eLABEL_2); //Agrego label a la columna
           }
 
           traza("despues de poner en variables los titulos " + columnas + " " +
                cantColumns);
 
           if (cantColumns >= 1) {
                eCOL_1.appendChild((Element) columnas.get(0));
                eCABECERA.appendChild(eCOL_1);
                traza("1");
           }
 
           if (cantColumns >= 2) {
                eCOL_2.appendChild((Element) columnas.get(1));
                eCABECERA.appendChild(eCOL_2);
                traza("1");
           }
 
           if (cantColumns >= 3) {
                eCOL_3.appendChild((Element) columnas.get(2));
                eCABECERA.appendChild(eCOL_3);
                traza("1");
           }
 
           if (cantColumns >= 4) {
                eCOL_4.appendChild((Element) columnas.get(3));
                eCABECERA.appendChild(eCOL_4);
                traza("1");
           }
 
           if (cantColumns >= 5) {
                eCOL_5.appendChild((Element) columnas.get(4));
                eCABECERA.appendChild(eCOL_5);
                traza("1");
           }
 
           if (cantColumns >= 6) {
                eCOL_6.appendChild((Element) columnas.get(5));
                eCABECERA.appendChild(eCOL_6);
                traza("1");
           }
 
           Element ePRESENTACION = document.createElement("PRESENTACION");
           Integer ancho = new Integer(cantColumns * anchoCab.intValue());
           ePRESENTACION.setAttribute("ancho", ancho.toString());
           ePRESENTACION.setAttribute("filas", "1");
 
           int swX1 = 0;
           StringBuffer cadena = new StringBuffer("['datosCamposCenterImpar'");
           traza("break brain");
 
           for (int i = 1; i < cantColumns; i++) {
                if (swX1 == 0) {
                      cadena.append(", 'datosCamposCenterPar'");
                      swX1 = 1;
                } else {
                      cadena.append(", 'datosCamposCenterImpar'");
                      swX1 = 0;
                }
           }
 
           for (int i = 0; i < cantColumns; i++) {
                Element eCOLP_2 = document.createElement("COL");
                eCOLP_2.setAttribute("ancho", anchoCab.toString());
                eCOLP_2.setAttribute("caracteres", "150");
                ePRESENTACION.appendChild(eCOLP_2); //Agrego columna a la presentacion
           }
 
           cadena.append("]");
 
           traza("### " + cadena.toString());
           ePRESENTACION.setAttribute("bloquesid", cadena.toString());
 
           Element eROWSET = document.createElement("ROWSET");
 
           eLista.appendChild(eCABECERA); //Agrego la cabecera de la lista
           eLista.appendChild(ePRESENTACION); //Agrego la presentacion de la lista
           eLista.appendChild(eROWSET); //Agrego el rowset de la lista
 
           eCapa.appendChild(eLista);
 
           getXML().getElementsByTagName("FORMULARIO").item(0).appendChild(eCapa);
    }

 
 private DruidaConector generarConector(String rowsetID, RecordSet datos,
           Vector columns) throws DOMException, Exception {
           StringBuffer salida = new StringBuffer();
 
           int sizeColums = datos.getColumnCount();
           int sizeRows = datos.getRowCount();
 
           if (columns == null) {
                columns = new Vector();
           }
           

 
           Vector columsDesc = datos.getColumnIdentifiers();
 
           DruidaConector conectorValoresPosibles = new DruidaConector();
           XMLDocument xmlDoc = new XMLDocument();
           Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");
           Element e_rows = docDestino.createElement("ROWSET");
           e_rows.setAttribute("ID", rowsetID);
           docDestino.getDocumentElement().appendChild(e_rows);
 
           for (int i = 0; i < sizeRows; i++) {
                Element e_row = docDestino.createElement("ROW");
                e_rows.appendChild(e_row);
 
                for (int j = 0; j < sizeColums; j++) {
                      if (columns.contains(columsDesc.elementAt(j))) {
                            Element e_campo2 = docDestino.createElement("CAMPO");
                            e_campo2.setAttribute("NOMBRE",
                                  columsDesc.elementAt(j).toString());
                            e_campo2.setAttribute("TIPO", "OBJECTO");
                            e_campo2.setAttribute("LONGITUD", "50");
 
                            Text txt = docDestino.createTextNode(((datos.getValueAt(i, j) == null)
                                         ? "" : datos.getValueAt(i, j).toString()));
                            e_campo2.appendChild(txt);
                            e_row.appendChild(e_campo2);
                      }
                }
           }
 
           conectorValoresPosibles.setXML(docDestino.getDocumentElement());
 
           return conectorValoresPosibles;
    }
 
  
  
  private ComposerViewElementList crearParametrosEntrada() throws Exception{
     
     traza("metodo crearParametrosEntrada() ");
     DTOBelcorp dtoBel = new DTOBelcorp();
     
     dtoBel.setOidPais(UtilidadesSession.getPais(this));
     dtoBel.setOidIdioma(UtilidadesSession.getIdioma(this));
        
     ComposerViewElementList lista = new ComposerViewElementList();
     
     //Carga de combo base de calculo
     ComposerViewElement cbBaseCalculo = new ComposerViewElement();
     cbBaseCalculo.setIDBusiness("INCConsultaBasesCalculo");
     cbBaseCalculo.setDTOE(dtoBel);
     
     //Carga de combo valor de calculo
     ComposerViewElement cbValorCalculo = new ComposerViewElement();
     cbValorCalculo.setIDBusiness("INCObtenerFormaCalculo");
     cbValorCalculo.setDTOE(dtoBel);
     
    //Carga de combo concurso
     ComposerViewElement cbConcurso = new ComposerViewElement();
     cbConcurso.setIDBusiness("INCObtenerNroConcursosRankingActivos");
     cbConcurso.setDTOE(dtoBel);
      
     lista.addViewElement(cbBaseCalculo);
     lista.addViewElement(cbValorCalculo);
     lista.addViewElement(cbConcurso);
     

     return lista;
  }
  
  private ComposerViewElementList crearParametrosEntradaNivelAgrupamiento() throws Exception{
     
     traza("metodo crearParametrosEntrada() ");
     DTOBelcorp dtoBel = new DTOBelcorp();
     
     dtoBel.setOidPais(UtilidadesSession.getPais(this));
     dtoBel.setOidIdioma(UtilidadesSession.getIdioma(this));
        
     ComposerViewElementList lista = new ComposerViewElementList();
     
     //Carga de combo base de calculo
     ComposerViewElement cbNivelAgrupamiento = new ComposerViewElement();
     cbNivelAgrupamiento.setIDBusiness("INCObtenerNivelAgrupamiento");
     cbNivelAgrupamiento.setDTOE(dtoBel);
            
     lista.addViewElement(cbNivelAgrupamiento);
    
     

     return lista;
  }

  
  
}
