/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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


//import LPSICCBase;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.presentacion.rastreador.*;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.dto.DTODatosMatrizDescuentos;
import es.indra.sicc.dtos.dto.DTODescuentoDG;
import es.indra.sicc.dtos.dto.DTOEAlcanceClasificacionDTO;
import es.indra.sicc.dtos.dto.DTOEAlcanceAdministrativoDTO;
import es.indra.sicc.dtos.dto.DTOEAlcanceAdministrativoDetalleDTO;
import es.indra.sicc.dtos.dto.DTOEBuscarAlcanceAdministrativoDTO;
import es.indra.sicc.dtos.dto.DTOParametroMatrizDescuentos;
import es.indra.sicc.dtos.dto.DTOParametroNacional;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.dtos.dto.DTOEAlcanceAdministrativoDetalleDTO;
import es.indra.sicc.dtos.dto.DTOAlcanceAdministrativoDetalleDto;
import es.indra.sicc.dtos.dto.DTOAlcanceAdministrativoDto;
import es.indra.sicc.dtos.dto.DTOGlobalDescuento;
import es.indra.sicc.logicanegocio.dto.ConstantesDTO;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.util.xml.XMLDocument;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.util.StringTokenizer;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 * Sistema:             Belcorp - SICC
 * Modulo:              DTO - Descuentos
 * Componente:          LPMantenimientoAlcanceAdministrativo
 * Fecha:               06/07/2004
 * Dcoumentacion:       
 *                      documentos: SICC-DMCO-DTO-201-324
 * Observaciones:
 * @version             3.0
 * @author              Cintia Verónica Argain
 * Notas:
 *    @wancho 21/11/2005, Inc.0014763
 * 
 */
public class LPMantenimientoAlcanceAdministrativo extends LPDescuentos {
    private Long lIdioma = null;
    private Long lPais = null;
	private DTOGlobalDescuento dtoDescuento = null;

    public LPMantenimientoAlcanceAdministrativo() { super(); }

    public void inicio() throws Exception {
	    pagina("contenido_alcance_administrativo_crear");
    }

    public void ejecucion() throws Exception {
        setTrazaFichero();
		traza("LPMantenimientoAlcanceAdministrativo.ejecucion() - Entrada");		

		casoDeUso = conectorParametroLimpia("casoDeUso", "", true);
        accion = conectorParametroLimpia("accion", "", true);
        lPais = UtilidadesSession.getPais(this);
        lIdioma = UtilidadesSession.getIdioma(this);

        traza("***** casoDeUso "+ casoDeUso);
        traza("***** accion " + accion);
        traza("***** lIdioma " + lIdioma);
        traza("***** lPais " + lPais);

		asignarAtributo("VAR","casoDeUso","valor",casoDeUso);
		asignarAtributo("VAR","accion","valor",accion);
        
        try { 
		    if (accion.equals("")){
				cargarPantalla();
			}
			else if(accion.equals("almacenar")) {
				almacenar();	
				redirigir(); 
			}
			else if(accion.equals("redirigir")) {
				redirigir();
			}
			else if(accion.equals("aniadir")) {
				aniadir();
			}
			else if(accion.equals("guardar")) {
				almacenar();
				guardar();
			}
			else if(accion.equals("siguiente")) {
				siguiente();
			}
			traza("LPMantenimientoAlcanceAdministrativo.ejecucion() - Salida");		
        }
		catch(Exception ex) {
			logStackTrace(ex);
			cargarPantalla();
			this.lanzarPaginaError(ex);
        }
    }

	public void cargarPantalla() throws Exception {
		traza("LPMantenimientoAlcanceAdministrativo.cargarPantalla() - Entrada");			
		dtoDescuento = getDescuento();	
		traza("************** DTOGlobalDescuento " + dtoDescuento);					

		if(dtoDescuento.getIndAlcanceAdministrativo()!=null &&
  		   dtoDescuento.getIndAlcanceAdministrativo().booleanValue()==false) {
			asignarAtributo("VAR","primeraEntradaPestanya","valor","S");
		}
		else {
			asignarAtributo("VAR","primeraEntradaPestanya","valor","N");
		}

		if(dtoDescuento.getAlcanceAdministrativo()!=null) {
			if(dtoDescuento.getAlcanceAdministrativo().getDetalle()!=null) {
		        cargaListaEditable(dtoDescuento.getAlcanceAdministrativo().getDetalle());
			}
		}

		if(dtoDescuento.getDatosGralesDto().getOidDescuento()!=null) {
			asignarAtributo("VAR","hidOidDescuento","valor", 
			dtoDescuento.getDatosGralesDto().getOidDescuento().toString());
		}

		String sValorAlcance = 
		(dtoDescuento.getDatosGralesDto().getNacional().equals(new Boolean(false))) ? "N" : "S";
		traza("******** sValorAlcance " + sValorAlcance);
		asignarAtributo("VAR","hidAlcance","valor",sValorAlcance);
                        
		if( casoDeUso.equals("modificar") || casoDeUso.equals("consultar") ){
	        if(casoDeUso.equals("consultar")) {
                                
              String modvig = (String)conectorParametroSesion("modificarVigente");
              if ("true".equals(modvig)) {
                getConfiguracionMenu("LPMantenimientoAlcanceAdministrativo","modificar");
                asignarAtributoPagina("cod","0354");
              } else {
                getConfiguracionMenu("LPMantenimientoAlcanceAdministrativo","consultar");
                asignarAtributoPagina("cod","0233");
              }                
            }                  
        }

		if ((casoDeUso.equals("modificar"))||( casoDeUso.equals("insertar"))) {
	        getConfiguracionMenu("LPMantenimientoAlcanceAdministrativo","");                
            if (casoDeUso.equals("modificar")){
                getConfiguracionMenu("LPMantenimientoAlcanceAdministrativo","modificar");
                asignarAtributoPagina("cod","0354");
			}

            recuperaValoresConfiguracionMatrizDescuento(dtoDescuento);
        }

		traza("LPMantenimientoAlcanceAdministrativo.cargarPantalla() - Salida");	
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

    private void cargaListaEditable(DTOAlcanceAdministrativoDetalleDto[] dtoArrayAlcance)throws Exception{
		traza("LPMantenimientoAlcanceAdministrativo.cargaListaEditable() - Entrada");	    
        RecordSet rs = new RecordSet();

        for (int x=0;x<8 ;x++ )
            rs.addColumn("id");
        
		int lon = dtoArrayAlcance.length;
        
		for (int j=0;j<lon ;j++ ){
	        Vector vec = new Vector();
			DTOAlcanceAdministrativoDetalleDto dtoTemp = dtoArrayAlcance[j];

            vec.add(dtoTemp.getOidAlcance());  // oid alcance administrativo
            vec.add(dtoTemp.getOidSubgerencia()); //oid subgerencia venta
            vec.add(dtoTemp.getSubgerencia()); //descripcion subgerencia venta
            vec.add(dtoTemp.getOidRegion()); //oid region
            vec.add(dtoTemp.getRegion()); // descripcion region
            vec.add(dtoTemp.getOidZona()); // oid zona
            vec.add(dtoTemp.getZona()); // descripcion zona
            vec.add(dtoTemp.getPorcentajeAdicional()); // porcentaje adicional

           rs.addRow(vec);
        }

        traza("********* rs: " + rs);
        String nombreListado = "listado1";
        asignar("LISTADOA", nombreListado, generarConectorListEditCF("ROWSET", rs, (Vector)rs.getColumnIdentifiers()),"ROWSET");        

		traza("LPMantenimientoAlcanceAdministrativo.cargaListaEditable() - Salida");	
    }

	private DruidaConector generarConectorListEditCF(String rowsetID, RecordSet datos, Vector columns) 
			throws DOMException, Exception {
		StringBuffer salida = new StringBuffer();
		int sizeColums = datos.getColumnCount();
		int sizeRows = datos.getRowCount();
		
		if ( columns == null ) {
			columns = new Vector();
		}

		Vector columsDesc = datos.getColumnIdentifiers();
		DruidaConector conectorValoresPosibles = new DruidaConector();
				
		XMLDocument xmlDoc  = new XMLDocument();
		Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");			
		Element e_rows = docDestino.createElement("ROWSET");
		e_rows.setAttribute("ID",rowsetID);
		docDestino.getDocumentElement().appendChild(e_rows);

		for (int i=0; i < sizeRows; i++) {
			Element e_row = docDestino.createElement("ROW");
			e_rows.appendChild(e_row);
			
			for (int j=0; j < sizeColums; j++)

			if ( columns.contains(columsDesc.elementAt(j)) ){
				//------------------------------------------------------------
					Element e_campo2   = docDestino.createElement("CAMPO");
					e_campo2.setAttribute("NOMBRE",columsDesc.elementAt(j).toString());
					e_campo2.setAttribute("TIPO","OBJECTO");
					e_campo2.setAttribute("LONGITUD","50");
					traza("Armando: indice i= " + i + " indice j= " + j + " valor: " + datos.getValueAt(i,j));
					Text txt0 = docDestino.createTextNode((datos.getValueAt(i,j)==null?"":datos.getValueAt(i,j).toString()));
					e_campo2.appendChild(txt0);
					e_row.appendChild(e_campo2);
			}
		}
		
		conectorValoresPosibles.setXML(docDestino.getDocumentElement());
		traza("return");
		traza("Conector: " + conectorValoresPosibles.getXML() );
		return conectorValoresPosibles;
	}


     private void recuperaValoresConfiguracionMatrizDescuento(DTOGlobalDescuento dtoDescuento) throws Exception {
		traza("LPMantenimientoAlcanceAdministrativo.recuperaValoresConfiguracionMatrizDescuento() - Entrada");	
        DTODatosMatrizDescuentos dtoMatrizDescuento = dtoDescuento.getDatosMatriz();
		Iterator iterador = dtoMatrizDescuento.getListaParametros().iterator();

        while (iterador.hasNext()) {
            DTOParametroMatrizDescuentos dtoP = (DTOParametroMatrizDescuentos)iterador.next();
            String sParam = dtoP.getOidParametro().toString();
            int para = Integer.parseInt(sParam);

            switch (para){
                case 12: {
					traza("entro al 12");                    
                    asignarAtributo("VAR","VisibleAlcance","valor",obtenerValor(dtoP.getVisible()));
                    asignarAtributo("VAR","ObligatorioAlcance","valor",obtenerValor(dtoP.getObligatorio()));
                    asignarAtributo("VAR","ModificableAlcance","valor",obtenerValor(dtoP.getModificable()));

                    if (accion.equals("")) {
                        ArrayList arrCulminacion = dtoP.getListaValoresPosibles();
                        String sValorObtenido = obtenerValor ( arrCulminacion );
                        asignarAtributo("VAR","selAlcanceAdministrativoDescuento",
                        "valor",sValorObtenido);
                        traza("sValorObtenido Metodo " + sValorObtenido);
                    }
                }
                break;

                case 13: {
                    if (accion.equals("aniadir")) {
                        traza("entro al 13");
                        asignarAtributo("VAR","VisiblePorcentajeAdicional","valor",
						obtenerValor(dtoP.getVisible()));
                        
						asignarAtributo("VAR","ObligatorioPorcentajeAdicional","valor",							obtenerValor(dtoP.getObligatorio()));
                        
						asignarAtributo("VAR","ModificablePorcentajeAdicional","valor",
						obtenerValor(dtoP.getModificable()));
                    }
                }
                break;
            }
        }

		traza("LPMantenimientoAlcanceAdministrativo.recuperaValoresConfiguracionMatrizDescuento() - Salida");	
    }

    private String obtenerValor(Boolean bool){
		if(bool.booleanValue())
			return "S";
		else
			return "N";
    }

	private String obtenerValor(ArrayList arrValores) throws Exception {
		traza("LPMantenimientoAlcanceAdministrativo.obtenerValor() - Entrada");
        Iterator itMorosidad = arrValores.iterator();
        boolean  bFindit =  false;
        String sValorObtenido = new String();
		
        while (itMorosidad.hasNext() && !bFindit) {
            DTOParametroNacional dtoB = (DTOParametroNacional)itMorosidad.next();
            if ((dtoB.getOid()!= null) && (dtoB.getValor()!=null)){
			    traza("******* dtoB.getValorPorDefecto:   " + dtoB.getValorPorDefecto().booleanValue());
				traza("******* dtoB.getValor:   " + dtoB.getValor());

                if (dtoB.getValorPorDefecto().booleanValue()) {
                    if (dtoB.getValor().toString().toLowerCase().equals("nacional"))
                        sValorObtenido = "S";
                    else
                        sValorObtenido = "N";
						
                    bFindit =  true;	
                }
            }
        }
		traza("LPMantenimientoAlcanceAdministrativo.obtenerValor() - Salida");
        return sValorObtenido;
    }

    private ArrayList aplanarUnidadesAdministrativas(String listado) throws Exception{
        traza("LPMantenimientoAlcanceAdministrativo.aplanarUnidadesAdministrativas() - Entrada");
        traza("********** listado " + listado);

        StringTokenizer stRows = new StringTokenizer(listado, "$");
        int rowCount = stRows.countTokens();
        ArrayList listaDescuentos = new ArrayList();
        
        for(int cont =  0 ;stRows.hasMoreTokens(); cont++){
			DTOAlcanceAdministrativoDetalleDto dto = new DTOAlcanceAdministrativoDetalleDto();

            StringTokenizer stColss = new StringTokenizer(stRows.nextToken(), "|");
            for(int conta =  0 ;stColss.hasMoreTokens(); conta++){								
				StringTokenizer stCols = new StringTokenizer(stColss.nextToken(), ":");				

				for(int contad =  0 ;stCols.hasMoreTokens(); contad++){
					String desc = stCols.nextToken().toString();
	                String valor = stCols.nextToken().toString();
                
		            traza(desc + " " + valor);    
					
					//1° oid subgerencia ventas
			        if(desc.equals("sgv")) dto.setOidSubgerencia(Long.valueOf(valor));

					//2° oid region
					if(desc.equals("r")) dto.setOidRegion(Long.valueOf(valor));

					//3° oid zona
		            if(desc.equals("z")) dto.setOidZona(Long.valueOf(valor));

					//4° porcenaje adicional
				    if(desc.equals("da")) {
	                    String sPorcentajeAdic = this.desFormatearNumero(valor,this.FORMATO_DEFAULT);
		                dto.setPorcentajeAdicional(Float.valueOf(sPorcentajeAdic));
			        }

					//5° oid alcance administrativo
					if(desc.equals("oid")) dto.setOidAlcance(Long.valueOf(valor));

					//6° descripcion subgerencia ventas
					if(desc.equals("descsgv")) dto.setSubgerencia(new String(valor));

					//7° descripcion region
					if(desc.equals("descr")) dto.setRegion(new String(valor));

					//8° descripcion zona
					if(desc.equals("descz")) dto.setZona(new String(valor));					
				}
			}	
        
			traza("****** dto " + dto);
			listaDescuentos.add(dto);
        }

		traza("LPMantenimientoAlcanceAdministrativo.aplanarUnidadesAdministrativas() - Salida");
		return listaDescuentos;
     }

	 public void almacenar() throws Exception {
		traza("LPMantenimientoAlcanceAdministrativo.almacenar() - Entrada");
		/*if (accion.equals("siguiente")) asignarAtributo("VAR", "cerrarVentana", "valor", "false");            
		else asignarAtributo("VAR", "cerrarVentana", "valor", "true");	*/

		dtoDescuento = getDescuento();		

		if(dtoDescuento.getAlcanceAdministrativo()==null) {
			DTOAlcanceAdministrativoDto dtoTemp = new DTOAlcanceAdministrativoDto();
			dtoTemp.setDetalle(null);
			dtoDescuento.setAlcanceAdministrativo(dtoTemp);
		}
		else {	
			dtoDescuento.getAlcanceAdministrativo().setDetalle(null); 
		}

		String sNacional = conectorParametroLimpia("hidAlcance", "", true);				    
		traza("*********** sNacional " + sNacional);

		if(sNacional.equals("S")) {
			dtoDescuento.getDatosGralesDto().setNacional(Boolean.TRUE);
		}
		else {
			dtoDescuento.getDatosGralesDto().setNacional(Boolean.FALSE);
		}		

        String sDetalleUniAdmi = conectorParametroLimpia("hidDetalleUnidadesAdmin", "", true);
		traza("********** sDetalleUniAdmi " + sDetalleUniAdmi);
        ArrayList aDetalleUnidadesAdm = aplanarUnidadesAdministrativas(sDetalleUniAdmi);
		int cant = aDetalleUnidadesAdm.size();
		DTOAlcanceAdministrativoDetalleDto[] dtoArray = new DTOAlcanceAdministrativoDetalleDto[cant];

		for(int i=0; i<cant; i++) {
			DTOAlcanceAdministrativoDetalleDto dtoTemp = 
			(DTOAlcanceAdministrativoDetalleDto)aDetalleUnidadesAdm.get(i);
			traza("********** DTOAlcanceAdministrativoDetalleDto " + dtoTemp);
			dtoArray[i] = dtoTemp;
		}

        dtoDescuento.getAlcanceAdministrativo().setDetalle(dtoArray);

		dtoDescuento.setIndAlcanceAdministrativo(Boolean.TRUE);
		traza("********** DTOGlobalDescuento a grabar " + dtoDescuento);
		setDescuento(dtoDescuento);
		traza("LPMantenimientoAlcanceAdministrativo.almacenar() - Salida");
	 }

	 private void aniadir() throws Exception {
		 traza("LPMantenimientoAlcanceAdministrativo.aniadir() - Entrada");

		 dtoDescuento = getDescuento();		
		 traza("***** dtoDescuento " + dtoDescuento);	
		 DTODescuentoDG dtoDescuentoDG = dtoDescuento.getDatosGralesDto();

         String sOidDescuento = new String();
         sOidDescuento = conectorParametro("hidOidDescuento");

         lIdioma = UtilidadesSession.getIdioma(this);
         pagina("contenido_alcance_administrativo_detalle");

         getConfiguracionMenu("LPMantenimientoAlcanceAdministrativo","aniadir");
         asignarAtributo("VAR","hidIdioma","valor",lIdioma.toString());
         asignarAtributo("VAR","hidOidDescuento","valor", sOidDescuento);

         DTOUnidadAdministrativa dtoUniAdm= new DTOUnidadAdministrativa();
         dtoUniAdm.setOidPais(dtoDescuentoDG.getOidPais());
         dtoUniAdm.setOidMarca(dtoDescuentoDG.getOidMarca());
         dtoUniAdm.setOidCanal(dtoDescuentoDG.getOidCanal());

		 ComposerViewElementList cvEL = new ComposerViewElementList();

         ComposerViewElement ci1 = new ComposerViewElement();
         ci1.setIDBusiness("ZONRecargaSubgerenciaVentas");                
         ci1.setDTOE(dtoUniAdm);
		
		 cvEL.addViewElement(ci1);
         ConectorComposerView conector = new ConectorComposerView(cvEL, this.getRequest());
         conector.ejecucion();
         DruidaConector resultados = conector.getConector();
       
         asignar("COMBO", "cbSubgerenciaVenta", resultados, "ZONRecargaSubgerenciaVentas");
		 traza("LPMantenimientoAlcanceAdministrativo.aniadir() - Salida");
	 }

	 public void siguiente() throws Exception {
		 traza("LPMantenimientoAlcanceAdministrativo.siguiente() - Entrada");
		 casoDeUso = conectorParametroLimpia("casoDeUso", "", true);
         if(!casoDeUso.equals("consultar"))
			almacenar();

         conectorAction("LPMantenimientoBaseCalculo");
         conectorActionParametro("accion","");
         conectorActionParametro("casoDeUso",casoDeUso);
		 traza("LPMantenimientoAlcanceAdministrativo.siguiente() - Salida");
	 }
}
