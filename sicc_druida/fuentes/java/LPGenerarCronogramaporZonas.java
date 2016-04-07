import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.logicanegocio.ape.ConstantesAPE;
import es.indra.sicc.rep.logicanegocio.ConstantesREP;


import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.mare.common.exception.MareException;

import java.util.Vector;
import java.util.HashMap;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringTokenizer;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import es.indra.sicc.util.DTOBoolean;

import es.indra.sicc.dtos.cra.DTOGenerarCronogramaporZonas;

public class LPGenerarCronogramaporZonas extends LPSICCBase {
    private Long pais = null;
    private Long idioma = null;
    private String accion =null;  
    private String soidCabeceraSolicitud = null;
    private Long oidCabeceraSolicitud = null;
    private String operacion = null;
    
    
    public void inicio() throws Exception{
    }

    public LPGenerarCronogramaporZonas() {
         super();
    }
  
    public void ejecucion() throws Exception {
         traza("Entra a LPGenerarCronogramaporZonas");
         String accion = conectorParametroLimpia("accion","", true);
         setTrazaFichero();
         try {
            this.rastreo();
            
            if (accion.equals("generar")){
               generar(); 
               traza("termino de generar");
            }else if (accion.equals("validar")) {
				validar();
            }else {
              cargarPagina();
            }
         
         } catch (Exception ex) {
                    
            ByteArrayOutputStream stack = new ByteArrayOutputStream();
                PrintStream out = new PrintStream(stack);
                  ex.printStackTrace(out);
              traza("EXCEPCION:" + stack.toString());
                lanzarPaginaError(ex);
         }
  }    

    private void cargarPagina() throws Exception{
         pagina("contenido_cronograma_generar_zona");
    
         pais=UtilidadesSession.getPais(this);
         idioma=UtilidadesSession.getIdioma(this);
         
         asignarAtributoPagina("cod", "3216");
         asignarAtributo("VAR", "idioma", "valor", UtilidadesSession.getIdioma(this).toString());
         asignarAtributo("VAR", "pais", "valor", UtilidadesSession.getPais(this).toString());
         
         cargarCombos();
         getFormatosValidaciones();
         getConfiguracionMenu("LPGenerarCronogramaporZonas");         
  }    

    private void generar() throws Exception{
        traza("*** LPGenerarCronogramaporZonas.generar() - Entrada ***");
		pagina("salidaGenerica");

		String cbZonaReferencia = conectorParametroLimpia("cbZonaReferencia", "", true);
		traza("cbZonaReferencia: " + cbZonaReferencia );

		String cbZonasRegenerar = conectorParametroLimpia("cbZonasRegenerar", "", true);
		traza("cbZonasRegenerar: " + cbZonasRegenerar );

		String cbPeriodo = conectorParametroLimpia("cbPeriodo", "", true);
		traza("cbPeriodo: " + cbPeriodo );

		String hayQueBorrar = conectorParametroLimpia("hayQueBorrar", "", true);
		traza("hayQueBorrar: " + hayQueBorrar );
		
		StringTokenizer st = new StringTokenizer(cbZonasRegenerar, "|");
		Long oid;
		Vector oids = new Vector(5);
		while (st.hasMoreTokens()) {
			oid = new Long(st.nextToken());
			oids.add(oid);      
		}

		DTOGenerarCronogramaporZonas dto = new DTOGenerarCronogramaporZonas();
		dto.setOidPeriodo(new Long(cbPeriodo));
		dto.setOidZonaReferencia(new Long(cbZonaReferencia));
		dto.setOidsZonasRegenerar(oids);
        dto.setOidPais(UtilidadesSession.getPais(this));
        dto.setOidIdioma(UtilidadesSession.getIdioma(this));

		if (hayQueBorrar != null && hayQueBorrar.equals("true")) {
			dto.setHayQueBorrar(Boolean.TRUE);
		} else {
			dto.setHayQueBorrar(Boolean.FALSE);
		}

		Vector parametros = new Vector();
		parametros.add(dto);
		parametros.add(new MareBusinessID("CRAGenerarCronogramasZonas"));

		traza("*** antes de conectar Generar");
		DruidaConector conector = conectar("ConectorObjeto", parametros);
		traza("*** despues de conectar Generar");

		asignarAtributo("VAR", "ejecutar", "valor", "fLimpiar();");            
        traza("*** LPGenerarCronogramaporZonas.generar() - Salida ***");
    } 

	private void cargarCombos() throws Exception {
         traza("*** LPGenerarCronogramaporZonas.cargarCombos() - Entrada ***");
            
         Vector dtos = new Vector();
         DTOBelcorp dtoBelcorp = new DTOBelcorp();
         dtoBelcorp.setOidIdioma(idioma);
         dtoBelcorp.setOidPais(pais);
    
         String[] idBusiness = new String[] {"SEGObtenerMarcasSinFiltro", "SEGObtenerCanalesSinFiltro"};
         String[] comboBox = new String[] {"cbMarca", "cbCanal" };                
    
         cargarCombos(dtoBelcorp, idBusiness, comboBox, null, null);
         
         traza("*** LPGenerarCronogramaporZonas.cargarCombos() - Salida ***");
	}

        
    private void cargarCombos(DTOBelcorp dto, String[] idBusiness, String[] comboBox, String[] column, String[] selected) throws Exception {
         traza("*** Entrada - LPGenerarCronogramaporZonas - cargarCombos ***");
    
         ComposerViewElementList list = new ComposerViewElementList();
         ComposerViewElement element = null;
    
         for (int i = 0; i < idBusiness.length; i++) { 
            element = new ComposerViewElement(); 
            element.setIDBusiness(idBusiness[i]);
            traza("*** idBusiness[i]: , " + idBusiness[i]);
            element.setDTOE(dto);
            list.addViewElement(element);
         }
    
         traza("***dto : , " + dto);
    
         // Obtener un RowSet que contiene los datos solicitados por list.
         ConectorComposerView ccv = new ConectorComposerView(list, this.getRequest());
    
         ccv.ejecucion();
         DruidaConector dc = ccv.getConector();
    
         // Asignar los datos obtenidos a los combos.
         if (selected != null && column != null) {
            for (int i = 0; i < comboBox.length; i++) {
                if (selected[i] != null && column[i] != null) {
                    asignar("COMBO", comboBox[i], dc, idBusiness[i], column[i], selected[i]);
                } else {
                    asignar("COMBO", comboBox[i], dc, idBusiness[i]); 
                }
            }   
         } else {
            for(int i = 0; i < comboBox.length; i++) {
                asignar("COMBO", comboBox[i], dc, idBusiness[i]); 
            }
         }
         traza("*** Salida - LPGenerarCronogramaporZonas - cargarCombos ***");
	}   
         
    private void validar() throws Exception {
		pagina("salidaGenerica");

		String cbZonaReferencia = conectorParametroLimpia("cbZonaReferencia", "", true);
		traza("cbZonaReferencia: " + cbZonaReferencia );

		String cbZonasRegenerar = conectorParametroLimpia("cbZonasRegenerar", "", true);
		traza("cbZonasRegenerar: " + cbZonasRegenerar );

		String cbPeriodo = conectorParametroLimpia("cbPeriodo", "", true);
		traza("cbPeriodo: " + cbPeriodo );
		
		StringTokenizer st = new StringTokenizer(cbZonasRegenerar, "|");
		Long oid;
		Vector oids = new Vector(5);
		while (st.hasMoreTokens()) {
			oid = new Long(st.nextToken());
			oids.add(oid);      
		}

		DTOGenerarCronogramaporZonas dto = new DTOGenerarCronogramaporZonas();
		dto.setOidPeriodo(new Long(cbPeriodo));
		dto.setOidZonaReferencia(new Long(cbZonaReferencia));
		dto.setOidsZonasRegenerar(oids);

		Vector parametros = new Vector();
		parametros.add(dto);
		parametros.add(new MareBusinessID("CRAValidarGeneracion"));

		traza("*** antes de conectar para validar generacion");
		DruidaConector conector = conectar("ConectorValidarTerritorio", parametros);
		traza("*** despues de conectar para validar generacion");

		Object aux = conector.objeto("DTOBoolean");

		if (aux.toString().trim().equals("")) {
			asignarAtributo("VAR", "ejecutar", "valor", "terminar();");
		} else {
			DTOBoolean hayQueBorrar = (DTOBoolean)aux;
			if (hayQueBorrar.getValor()) {
				asignarAtributo("VAR", "ejecutar", "valor", "hayQueBorrar();");            
			}else{
				asignarAtributo("VAR", "ejecutar", "valor", "generar('false');");               
			}
		}
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

