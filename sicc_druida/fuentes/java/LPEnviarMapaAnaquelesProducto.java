/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
 
/**
 * @author SCSAAVEDRA
 * @fecha  30/04/2007
 * Notas: C.U. Enviar Mapa de Anaqueles Producto.
 */
import es.indra.druida.DruidaConector; 
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement; 
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.logicanegocio.ape.ConstantesAPE;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.cmn.negocio.interfaces.IGestorInterfaces;
import es.indra.mare.common.mln.MareBusinessID;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Vector;
import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;
import es.indra.sicc.dtos.ape.DTOMantenerAsignacionProductosAnaqueles;
import es.indra.sicc.dtos.ape.DTOAsignacionProductoAnaquelCabecera;
import es.indra.sicc.dtos.intsys.DTOINT;
import es.indra.sicc.dtos.intsys.DTOCargaInicialInterfaz;
import es.indra.sicc.dtos.cra.DTOBuscarPeriodos;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.util.DTOOID;

import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.dto.IMareDTO;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import es.indra.sicc.util.xml.XMLDocument;


public class LPEnviarMapaAnaquelesProducto extends LPSICCBase {
    
    private Long pais = null;
    private Long idioma = null;
    private String accion = null;
    
    public LPEnviarMapaAnaquelesProducto() {
    }
    
    public void inicio() throws Exception  {
    }
    
    public void ejecucion() throws Exception {
        
        setTrazaFichero();
        traza(" LPEnviarMapaAnaquelesProducto.ejecucion(): Entrada ");
        
        try {
                    
            pais = UtilidadesSession.getPais(this);
            idioma = UtilidadesSession.getIdioma(this);
            
            traza("     pais = " + pais);
            traza("     idioma = " + idioma);
            
            asignarAtributo("VAR", "pais", "valor", pais.toString());
            asignarAtributo("VAR", "idioma", "valor", idioma.toString());
            
            accion = conectorParametroLimpia("accion","", true);
            traza("     accion = " + accion);
            
            if(accion.equals("")) {
                cargarPantalla();
				getConfiguracionMenu();

			} else if (accion.equals("enviar")) {
				enviar();

			} else if (accion.equals("cargarVersiones")) {
				cargarComboVersiones();
			}
			
        
        } catch (Exception e) {
            traza("     pincho! ... " + e);
            logStackTrace(e);
            lanzarPaginaError(e);
        }
        traza(" LPEnviarMapaAnaquelesProducto.ejecucion(): Salida ");
    }
    
    private void logStackTrace(Throwable e) throws Exception {
       
       traza("Se produjo la excepcion: " + e.getMessage());
       ByteArrayOutputStream pila = new ByteArrayOutputStream();
       PrintStream out = new PrintStream(pila);
       
       if (e instanceof MareException) {
         MareException e2=(MareException)e;
         traza("Es una mare Exception con codigo de error: "+e2.getCode());
       }
       
       e.printStackTrace(out);
       traza("stack Trace : " +  pila.toString());
    }
    
    
    public void cargarPantalla() throws Exception {
        String opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
        traza("SCS opcionMenu: " + opcionMenu);
		
		if(opcionMenu.equals("")) {
			pagina("contenido_mapa_anaqueles_producto_enviar");
			asignarAtributoPagina("cod", "01000");
		}

	    // Validaciones
	    getFormatosValidaciones();
    
	    asignarAtributo("VAR","opcionMenu","valor", opcionMenu);  
	    asignarAtributo("VAR","hIdioma","valor", (idioma==null?"":idioma.toString()));
	    asignarAtributo("VAR","hPais","valor",  (pais==null?"":pais.toString()));

		this.cargarCombos();

		this.cargarOcultoPeriodosDefault();
    }

    private void cargarCombos() throws Exception{
  
        traza("antes de ComposerViewElementList  ");
        ComposerViewElementList cv = crearParametrosEntrada();
		ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
		traza("SCS antes del conector.ejecucion");
		conector.ejecucion();
		traza("SCS despues del conector");
		DruidaConector resultados = conector.getConector();
  
        traza(resultados.getXML());

		asignar("COMBO","cbCentroDistribucion",resultados,"APEObtenerDescripcionesCD");   
		asignar("COMBO","cbMarca",resultados,"SEGObtenerMarcasSinFiltro");   
		asignar("COMBO","cbCanal",resultados,"SEGObtenerCanalesSinFiltro");   

	    // Valores de defecto
		DTOBelcorp dtoBel = new DTOBelcorp();      
	    dtoBel.setOidPais(pais);
	    dtoBel.setOidIdioma(idioma);
      
	    MareBusinessID mareBusinessID = new MareBusinessID("APEObtenerValoresDefecto");
		Vector params = new Vector();		
		params.addElement(dtoBel);
		params.addElement(mareBusinessID);
 
	    traza("SCS antes del conector");
		DruidaConector dc  =	conectar("ConectorObtenerValoresDefecto", params);
	    traza("SCS despues del conector");
    
	    DTOSalida dtoSalida = (DTOSalida)dc.objeto("DTOSalida"); 
    
	    asignarAtributo("VAR", "hCbCentroDistribucion", "valor", obtenerCDDef(dtoSalida));
    }
    
    private String obtenerCDDef(DTOSalida dtoSalida) throws Exception{
        traza("SCS entro a obtenerCDDef");
        RecordSet valoresDef = dtoSalida.getResultado();
        String CDDef = "";
        int cant = valoresDef.getRowCount();
    
        for(int i=0; i<cant; i++){      
          if(((String)(valoresDef.getValueAt(i,"COMBO"))).equals(ConstantesAPE.CONFIGURACION_CD)){
             traza("SCS CDDef :" + valoresDef.getValueAt(i,"OID"));
             return ((BigDecimal)valoresDef.getValueAt(i,"OID")).toString();
          }
        }   
        traza("SCS No hay CD por defecto");
        return "";
    }

    private ComposerViewElementList crearParametrosEntrada() throws Exception{
  	    traza("SCS metodo ComposerViewElementList");
	    ComposerViewElementList lista = new ComposerViewElementList();
	    //combo codigo configuracion
	    ComposerViewElement descripcionesCD = new ComposerViewElement();
  
	    DTOBelcorp dtoBel = new DTOBelcorp();
	    traza("SCS antes de asignar al dtobelcorp");
	    dtoBel.setOidPais(pais);
	    dtoBel.setOidIdioma(idioma);
		byte aux = 0;
		  
	    descripcionesCD.setIDBusiness("APEObtenerDescripcionesCD");
	    descripcionesCD.setDTOE(dtoBel);

        descripcionesCD.setPosOID(aux);   
		aux = 1;
		descripcionesCD.setPosDesc(aux);
		  
	    lista.addViewElement(descripcionesCD);
		//
		ComposerViewElement marcas = new ComposerViewElement();

		aux = 0;
	    marcas.setIDBusiness("SEGObtenerMarcasSinFiltro");
	    marcas.setDTOE(dtoBel);
        marcas.setPosOID(aux);   
		aux = 1;
		marcas.setPosDesc(aux);

		lista.addViewElement(marcas);
		//
		ComposerViewElement canales = new ComposerViewElement();

		aux = 0;
	    canales.setIDBusiness("SEGObtenerCanalesSinFiltro");
	    canales.setDTOE(dtoBel);
        canales.setPosOID(aux);   
		aux = 1;
		canales.setPosDesc(aux);

		lista.addViewElement(canales);

		// Recupera los oids de los valores por defecto para cada combo 
		ComposerViewElement valoresDef = new ComposerViewElement();

	    valoresDef.setIDBusiness("APEObtenerValoresDefecto");
	    valoresDef.setDTOE(dtoBel);

		lista.addViewElement(valoresDef);
	  
	    return lista;
	}

  private DruidaConector generarConector(String rowsetID, RecordSet datos, Vector columns) throws DOMException, Exception{
      StringBuffer salida = new StringBuffer();
      int sizeColums = datos.getColumnCount();
      int sizeRows = datos.getRowCount();
      
      if ( columns == null ){
        columns = new Vector();
      }
  
      Vector columsDesc = datos.getColumnIdentifiers();		
      
      DruidaConector conectorValoresPosibles = new DruidaConector();
      
      XMLDocument xmlDoc  = new XMLDocument();
      Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");			
      Element e_rows = docDestino.createElement("ROWSET");
      e_rows.setAttribute("ID",rowsetID);
      docDestino.getDocumentElement().appendChild(e_rows);
      
      for (int i=0; i < sizeRows; i++){
        Element e_row = docDestino.createElement("ROW");
        e_rows.appendChild(e_row);
  
        Element e_campo0   = docDestino.createElement("CAMPO");
  
        for(int j=0; j < sizeColums; j++){
          if( columns.contains(columsDesc.elementAt(j))){
            Element e_campo2   = docDestino.createElement("CAMPO");
            
            if(j == 0){
              e_campo0.setAttribute("NOMBRE","oculto");
            }else{
              e_campo2.setAttribute("NOMBRE",columsDesc.elementAt(j).toString());
            }
            e_campo2.setAttribute("TIPO","OBJECTO");
            e_campo2.setAttribute("LONGITUD","50");
            Text txt0 = docDestino.createTextNode((datos.getValueAt(i,j)==null?"":datos.getValueAt(i,j).toString()));
            e_campo2.appendChild(txt0);
            e_row.appendChild(e_campo2);
          }
        }
      }
      conectorValoresPosibles.setXML(docDestino.getDocumentElement());
      traza("DruidaConector: " + conectorValoresPosibles.getXML());
      return conectorValoresPosibles;
  }

  private RecordSet agregarBlanco(RecordSet entrada) throws Exception{
      RecordSet rsNuevo = new RecordSet();
      
      if(entrada!=null){
          
          rsNuevo.setColumnIdentifiers(entrada.getColumnIdentifiers());
          
          rsNuevo.addRow(new Object[] {" ", " "});
          
          for(int i=0; i < entrada.getRowCount(); i++){
              rsNuevo.addRow(entrada.getRow(i));
          }
      }
      return rsNuevo;
  }

  public void enviar() throws Exception {
	  pagina("salidaGenerica");
	  traza(" LPEnviarMapaAnaquelesProducto.enviar(): Entrada ");

	  DTOOID dtoOID = new DTOOID();

	  dtoOID.setOidIdioma(idioma);
	  dtoOID.setOidPais(pais);

	  String oidVersAsign = conectorParametroLimpia("hCbVersionAsignacion", "", true);

      dtoOID.setOid(Long.valueOf(oidVersAsign));

	  MareBusinessID mareBusinessID=new MareBusinessID("INTEnviarMapaAnaquelesProductoBatch");
	  Vector paramSalida = new Vector();
	  paramSalida.add(dtoOID);
	  paramSalida.add(mareBusinessID);	

	  traza("dtooid: " + dtoOID);
      traza("SCS antes del conector");
	  DruidaConector dc  =	conectar("ConectorEnviarMapaAnaquelesProductoBatch", paramSalida);
      traza("SCS despues del conector");

      asignarAtributo("VAR", "ejecutar", "valor", "enviarOk();");

	  traza(" LPEnviarMapaAnaquelesProducto.enviar(): Salida ");
  }

	private void cargarOcultoPeriodosDefault() throws Exception {
		traza("LPEnviarMapaAnaquelesProducto.cargarOcultoPeriodosDefault(): Entrada");
		
		// Signatura del metodo en el MON
		// public Collection obtienePeriodosActuales(DTOBuscarPeriodos dtoE)
		DTOBuscarPeriodos dtoBuscarPeriodos = new DTOBuscarPeriodos();
		dtoBuscarPeriodos.setOidPais(pais);
		dtoBuscarPeriodos.setOidIdioma(idioma);
		dtoBuscarPeriodos.setPeriodoMasNuevoPrimero(new Boolean(true));
		
		Vector paramEntrada = new Vector();
		paramEntrada.add(dtoBuscarPeriodos);
		paramEntrada.add(new MareBusinessID("CRAObtienePeriodosActuales"));
		
		traza("  antes de CRAObtienePeriodosActuales");
		DruidaConector conectorPeriodosActuales = conectar("ConectorObtienePeriodosActuales", paramEntrada);
		traza("  despues de CRAObtienePeriodosActuales");
		
		IMareDTO dtoSalida = (MareDTO) conectorPeriodosActuales.objeto("dtoSalida");
		Collection periodosActuales = (ArrayList)dtoSalida.getProperty("periodosActuales");
		
		traza("  se recuperaron los periodos actuales");
		
	    asignarAtributo("VAR", "hPeriodosActualesDefault", "valor", this.periodosActualesToString((ArrayList)periodosActuales));
		
		traza("LPEnviarMapaAnaquelesProducto.cargarOcultoPeriodosDefault(): Salida");
	}

	private String periodosActualesToString(ArrayList periodosActuales) throws Exception {
		traza("LPEnviarMapaAnaquelesProducto.periodosActualesToString(): Entrada");
		
		StringBuffer cadena = new StringBuffer("");
		
		int cantRegistros = periodosActuales.size();
		traza("  cantidad de periodos actuales: " + cantRegistros);
		
		DTOPeriodo dtoPeriodo = null;

		Iterator it = periodosActuales.iterator();
		
		while (it.hasNext()) {
			dtoPeriodo = (DTOPeriodo)it.next();
			cadena.append(dtoPeriodo.getMarca() + "," + dtoPeriodo.getCanal() + "," + dtoPeriodo.getOid());
			if (it.hasNext()) {
				cadena.append("|");
			}
		}
		traza(" --- vamos a retornar 'periodosActuales': " + cadena);
		traza("LPEnviarMapaAnaquelesProducto.periodosActualesToString(): Salida");
		return cadena.toString();
	}

	private void cargarComboVersiones() throws Exception {
		traza("LPEnviarMapaAnaquelesProducto.cargarComboVersiones(): Entrada");
        pagina("salidaGenerica");
        String oidPeriodo = conectorParametroLimpia("cbPeriodo", "", true);
        String oidCD = conectorParametroLimpia("cbCentroDistribucion", "", true);
        String oidMapaCD = conectorParametroLimpia("cbMapaCentroDistribucion", "", true);
		traza("  -- Parametros (oidCD/oidMapaCD/oidPeriodo): " + oidCD + "/" + oidMapaCD + "/" + oidPeriodo);

		// Signatura del metodo en el MON
		// public Collection obtenerVersionesAsignacionActiva(DTOMantenerAsignacionProductosAnaqueles dtoE)
		DTOMantenerAsignacionProductosAnaqueles dtoMantAsigProdAnaq = new DTOMantenerAsignacionProductosAnaqueles();
		dtoMantAsigProdAnaq.setOidPais(pais);
		dtoMantAsigProdAnaq.setOidIdioma(idioma);
		// Parametros para buscar la version activa para facturacion
		dtoMantAsigProdAnaq.setOidPeriodo(new Long(oidPeriodo));
		dtoMantAsigProdAnaq.setOidMapaCentroDistribucion(new Long(oidMapaCD));
		
		Vector paramEntrada = new Vector();
		paramEntrada.add(dtoMantAsigProdAnaq);
		paramEntrada.add(new MareBusinessID("APEObtenerVersionesAsignacionActiva"));
		
		traza("  antes de APEObtenerVersionesAsignacion");
		DruidaConector conectorPeriodosActuales = conectar("ConectorObtenerVersionesAsignacionActiva", paramEntrada);
		traza("  despues de APEObtenerVersionesAsignacion");
		
		IMareDTO dtoSalida = (MareDTO) conectorPeriodosActuales.objeto("dtoSalida");
		Collection versionesActivas = (ArrayList)dtoSalida.getProperty("versionesActivas");
		String strOidVersionActiva = "";

		if (versionesActivas != null && versionesActivas.size() > 0) {
			int cantRegistros = versionesActivas.size();
			traza("  cantidad de versiones activas (con los parametros seleccionado): " + cantRegistros);
			Iterator it = versionesActivas.iterator();
			if (it.hasNext()) {
				DTOAsignacionProductoAnaquelCabecera dtoAPAC = (DTOAsignacionProductoAnaquelCabecera)it.next();
				strOidVersionActiva = (dtoAPAC.getOid() != null)? dtoAPAC.getOid().toString() : "";
			}
		}
		traza("  Version activa para facturacion: " + strOidVersionActiva);
		//cambio ape-02, ver modificacion de metodo: DAOAsignacionProductos==>>obtenerVersionesAsignacionActiva 
		asignarAtributo("VAR", "ejecutar", "valor", "recargaCbVersion("+ strOidVersionActiva +")");
		//asignarAtributo("VAR", "hiddenVersionActiva", "valor", strOidVersionActiva);
		
		traza("LPEnviarMapaAnaquelesProducto.cargarComboVersiones(): Salida");
	}

}