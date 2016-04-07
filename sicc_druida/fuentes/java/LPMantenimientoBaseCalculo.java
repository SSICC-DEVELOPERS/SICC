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
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.presentacion.rastreador.*;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import es.indra.sicc.dtos.dto.DTODatosMatrizDescuentos;
import es.indra.sicc.dtos.dto.DTODescuentoDG;
import es.indra.sicc.dtos.dto.DTOEBaseCalculoDetalle;
import es.indra.sicc.dtos.dto.DTOEBaseCalculo;
import es.indra.sicc.dtos.dto.DTOParametroMatrizDescuentos;
import es.indra.sicc.dtos.dto.DTOSBaseCalculo;
import es.indra.sicc.dtos.dto.DTOSBaseCalculoDetalle;
import es.indra.sicc.dtos.dto.DTOGlobalDescuento;
import es.indra.sicc.dtos.dto.DTOProductoDTO;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.DTOSalida; 
import es.indra.sicc.util.DTOOID;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector; 
 /**
  * Sistema:             Belcorp - SICC
  * Modulo:              DTO - Descuentos
  * Componente:          LPMantenimientoBaseCalculo
  * Fecha:               06/07/2004
  * Dcoumentacion:       
  *                      documentos: SICC-DMCO-DTO-201-324
  * Observaciones:
  * @version             3.0
  * @author              Cintia Verónica Argain
  */
 public class LPMantenimientoBaseCalculo extends LPDescuentos {
    private Long lIdioma = null;
    private Long lPais = null;
    private int codigoOculto=0;
  
  private DTOGlobalDescuento dtoDescuento = null;
 
    public LPMantenimientoBaseCalculo() { super(); }
 
    public void inicio() throws Exception {
		pagina("contenido_base_calculo_crear");
    }
 
    public void ejecucion() throws Exception {        
        setTrazaFichero();
        traza("LPMantenimientoBaseCalculo.ejecucion() - Entrada");

        accion = conectorParametroLimpia("accion", "", true);
        casoDeUso = conectorParametroLimpia("casoDeUso", "", true);
        lPais = UtilidadesSession.getPais(this);
        lIdioma = UtilidadesSession.getIdioma(this);

        traza("***** accion " + accion);
	    traza("***** casoDeUso "+ casoDeUso);
        traza("***** lIdioma " + lIdioma);
        traza("***** lPais " + lPais);

		asignarAtributo("VAR","casoDeUso","valor",casoDeUso);
		asignarAtributo("VAR","accion","valor",accion);
        
        try {

			if (accion.equals("")){
				//Comienza configuracion de menu secundario
				getConfiguracionMenu("LPMantenimientoBaseCalculo","");

                if (casoDeUso.equals("insertar"))
                    asignarAtributoPagina("cod","0644");                        

                if (casoDeUso.equals("modificar")){
                    getConfiguracionMenu("LPMantenimientoBaseCalculo","modificar");
                    asignarAtributoPagina("cod","0354");                                                        
                }

                if (casoDeUso.equals("consultar")){                    			 
                    String modvig = (String)conectorParametroSesion("modificarVigente");
                    if ("true".equals(modvig)) {
                      getConfiguracionMenu("LPMantenimientoBaseCalculo","modificar");
                      asignarAtributoPagina("cod","0354");
                    } else {
                      getConfiguracionMenu("LPMantenimientoBaseCalculo","consultar");
                      asignarAtributoPagina("cod","0233");
                    }                                                             
   				    
        			 }
				//Finaliza configuracion de menu secundario

				cargarPantalla();
			}
			else if (accion.equals("almacenar")){
				almacenar();
				redirigir();
			}
			else if (accion.equals("redirigir")){
				redirigir();
			}
			else if (accion.equals("guardarBaseCalculo")){
				almacenar();
				guardar();
			}
			else if (accion.equals("siguiente")){
				siguiente();
			}

        traza("LPMantenimientoBaseCalculo.ejecucion() - Salida");
        }
		catch(Exception ex) {
			logStackTrace(ex);
			cargarPantalla();
            this.lanzarPaginaError(ex);
        }
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

	private void AsignaValoresEnPantalla(DTOSBaseCalculo dtoBaseCal) throws Exception {
    
    traza("LPMantenimientoBaseCalculo.AsignaValoresEnPantalla() - Entrada");
		traza("************* DTOSBaseCalculo " + dtoBaseCal);
        
		//1° Recarga lista criterios
		
    traza("************* Recarga lista criterios");
    
    if (dtoBaseCal.getDetalle() != null) {

      ArrayList arr = dtoBaseCal.getDetalle();
      Iterator itDet = arr.iterator();
      RecordSet rs = new RecordSet();
      StringBuffer selTO = new StringBuffer();
      StringBuffer selCV = new StringBuffer();
            
            
      /*
      traza("********************JAS****************");
      traza("los criterios de seleccion que se recuperan de la BD son: " + arr);
      traza("********************JAS****************");
      */
      
      
      for(int i=0; i < 18;i++)          
        rs.addColumn("id");
        
        while(itDet.hasNext()){
          
          DTOSBaseCalculoDetalle dto = (DTOSBaseCalculoDetalle)itDet.next();
          
          traza("************* DTOSBaseCalculoDetalle " + dto);
          
          rs.addRow(generaVector(dto));
          
          if(dto.getMarca()!=null) 
            asignarAtributo("VAR","hidMarcasSel","valor",dto.getMarca().toString());
          
          if(dto.getUnidadNegocio()!=null) 
            asignarAtributo("VAR","hidUniNegSel","valor",dto.getUnidadNegocio().toString());
          
          if(dto.getNegocio()!=null)
            asignarAtributo("VAR","hidNegocioSel","valor",dto.getNegocio().toString());
          
          if(dto.getSupergenerico()!=null)
            asignarAtributo("VAR","hidSuperGenericoSel","valor",dto.getSupergenerico().toString());
          
          if(dto.getGenerico()!=null)
            asignarAtributo("VAR","hidGenericoSel","valor",dto.getGenerico().toString());
          
          if(dto.getExclusionTipoOferta()!=null)
            asignarAtributo("VAR","hidETO","valor",dto.getExclusionTipoOferta().toString());
          
          if(dto.getTipoOferta()!=null){
            selTO.append(dto.getTipoOferta().toString());
            selTO.append(",");
          } 
          
          if(dto.getCicloVida()!=null){
            selCV.append(dto.getCicloVida().toString());
            selCV.append(",");
          } 
          
        }//cierro el while
      
      
      if (selTO.length() >1){
        StringBuffer cadena = selTO;
        asignarAtributo("VAR","selTipoOferta","valor",selTO.substring(0,cadena.length()- 1));
      }
      
      if (selCV.length() >1){
         StringBuffer cadena = selCV;
         asignarAtributo("VAR","selCicloVida","valor",selCV.substring(0,cadena.length()- 1));
      }		
      
      traza("*********** rs " + rs);
      
      
      if(!rs.esVacio()){
        String listado ="listado2";
        asignar("LISTADOA",listado,UtilidadesBelcorp.generarConector("dtoSalida", rs,rs.getColumnIdentifiers()),"dtoSalida");
      }
      
      
  }

		
    //2° Recarga lista productos (solo para la parte visual)
		traza("************* Recarga lista productos");
        if (dtoBaseCal.getProductos() != null) {
			ArrayList arrTemp = dtoBaseCal.getProductos();
			Iterator itProductos = arrTemp.iterator();
			RecordSet rsProd = new RecordSet();   

			for(int i=0; i < 3;i++)
				rsProd.addColumn("id");      
			
			while(itProductos.hasNext()){
				DTOProductoDTO dtoTemp = (DTOProductoDTO)itProductos.next();

			    Vector vecp = new Vector();
                vecp.add(dtoTemp.getOidProducto());
                vecp.add(dtoTemp.getCodigoSAP());
				vecp.add(dtoTemp.getDescripcion());
                rsProd.addRow(vecp);
			}          

			traza("*********** rsProd " + rsProd);

			if(!rsProd.esVacio()){
                String listado ="listado1";
				asignar("LISTADOA",listado,UtilidadesBelcorp.generarConector("dtoSalida", rsProd,rsProd.getColumnIdentifiers()),"dtoSalida");
            }
		}

		traza("LPMantenimientoBaseCalculo.AsignaValoresEnPantalla() - Salida");
     }

	private Vector generaVector(DTOSBaseCalculoDetalle dto) throws Exception{
		traza("LPMantenimientoBaseCalculo.generaVector() - Entrada");

        Vector vec = new Vector();

        //jsilva
        //INC DBLG400000898
        
        String codigo = String.valueOf(++codigoOculto);
        vec.add(codigo);
        
        if(dto.getMarca()!=null){
            //vec.add(dto.getMarca());
            vec.add(dto.getMarca());            
        }else{
            //vec.add("1");
            vec.add("");            
        }

		if(dto.getDescripcionMarca()!=null) vec.add(dto.getDescripcionMarca());
        else vec.add("");
        
		if(dto.getUnidadNegocio()!=null)  vec.add(dto.getUnidadNegocio());            
        else vec.add("");
        
		if(dto.getDescripcionUnidadNegocio()!=null) vec.add(dto.getDescripcionUnidadNegocio());
        else vec.add("");
        
		if(dto.getNegocio()!=null) vec.add(dto.getNegocio());        
		else vec.add("");

		if(dto.getDescripcionNegocio()!=null) vec.add(dto.getDescripcionNegocio());
        else vec.add("");
        
		if(dto.getSupergenerico()!=null) vec.add(dto.getSupergenerico());
        else vec.add("");
        
		if(dto.getDescripcionSupergenerico()!=null) vec.add(dto.getDescripcionSupergenerico());
        else vec.add("");
        
		if(dto.getGenerico()!=null) vec.add(dto.getGenerico());
        else vec.add("");
        
		if(dto.getDescripcionGenerico()!=null) vec.add(dto.getDescripcionGenerico());
        else vec.add("");
        
		if(dto.getExclusionTipoOferta()!=null){
            if(dto.getExclusionTipoOferta().booleanValue()) vec.add("S");
            else vec.add("N");            
        }
        
		if(dto.getTipoOferta()!=null) vec.add(dto.getTipoOferta());
        else vec.add("");            
        
		if(dto.getDescripcionTipoOferta()!=null) vec.add(dto.getDescripcionTipoOferta());
        else vec.add("");            
        
		if(dto.getCicloVida()!=null) vec.add(dto.getCicloVida());
        else vec.add("");            
        
		if(dto.getDescripcionCicloVida()!=null) vec.add(dto.getDescripcionCicloVida());
        else vec.add("");            
        
		if(dto.getProducto()!=null) vec.add(dto.getProducto());
        else vec.add("");            
        
		if(dto.getDescripcionProducto()!=null) vec.add(dto.getDescripcionProducto());
        else vec.add("");               

		traza("LPMantenimientoBaseCalculo.generaVector() - Salida");
        return vec;
    }

  	private StringBuffer aplanaVector(Vector vElementos) throws Exception {
		StringBuffer sElementosAplanados = new StringBuffer();
		int i = 0;
		while (i < vElementos.size()) {
			String sDato = vElementos.elementAt(i).toString();
			traza("DATO:          " + sDato);
			sDato = sDato.substring(1, sDato.length()-1);
			sElementosAplanados.append(sDato);
			sElementosAplanados.append(",");
			i++;
		}
		traza(">>>>>> sElementosAplanados " + sElementosAplanados);
		/*Retorno 1 posición menos que corresponde a la última coma */
		return sElementosAplanados;
	 }

	 private String aplanaProductos(Vector vElementos) throws Exception {
		String sElementosAplanados = new String();
		int i = 0;
		sElementosAplanados = "$";
		while (i < vElementos.size())
		{
			String sDato = new String();
			sDato = vElementos.elementAt(i).toString();
			sDato = sDato.substring(1, sDato.length()-1);
			
			StringTokenizer strx = new StringTokenizer(sDato, ",");
			while (strx.hasMoreTokens())
			{
				String sInfo = new String();
				sInfo = strx.nextToken();
				//sElementosAplanados = sElementosAplanados + "|" + sInfo ;
				sElementosAplanados = sElementosAplanados + sInfo + "|"  ;
			}
			sElementosAplanados = sElementosAplanados +"$";
			i++;
		}
		traza(">>>>>> sElementosAplanados " + sElementosAplanados);
		return sElementosAplanados;		
	 }
    
	private void cargaCombos() throws Exception{	
        traza("LPMantenimientoBaseCalculo.cargaCombos() - Entrada");
		ComposerViewElementList cv = crearParametrosEntrada();
		ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
		conector.ejecucion();
		DruidaConector resultados = conector.getConector();

		asignar("COMBO", "cbMarca", resultados, "SEGRecuperarMarcasProductoMP");
		asignar("COMBO", "cbUnidadNegocio", resultados, "MAEObtenerUnidadesNegocioPorPais");
        asignar("COMBO", "cbNegocio", resultados, "MAEObtenerNegocioPorPais");
		asignar("COMBO", "cbSupergenerico", resultados, "MAEObtenerSuperGenericosPorPais");
        asignar("COMBO", "cbGenerico", resultados, "MAEObtenerGenericosPorPais");
        asignar("COMBO", "cbTipoOferta", resultados, "PREObtenerTiposOfertaPorCanal");
        asignar("COMBO", "cbCicloVida", resultados, "PREObtenerCiclosVida");
        traza("LPMantenimientoBaseCalculo.cargaCombos() - Salida");
    }
   
    private ComposerViewElementList crearParametrosEntrada() throws Exception {
        traza("LPMantenimientoBaseCalculo.crearParametrosEntrada() - Entrada");
		dtoDescuento = getDescuento();

        DTOBelcorp dtoBel = new DTOBelcorp();
        dtoBel.setOidIdioma(lIdioma);
        dtoBel.setOidPais(lPais);
        
		ComposerViewElementList lista = new ComposerViewElementList();

        DTOOID dtoOidMarca = new DTOOID();
	    dtoOidMarca.setOidIdioma(lIdioma);
        dtoOidMarca.setOidPais(lPais);
        dtoOidMarca.setOid(dtoDescuento.getDatosGralesDto().getOidMarca());    

        asignarAtributo("VAR","oidMarcaCorporativa","valor", 
		dtoDescuento.getDatosGralesDto().getOidMarca().toString());        
        
		ComposerViewElement ci1 = new ComposerViewElement();
		ci1.setIDBusiness("SEGRecuperarMarcasProductoMP");
		ci1.setDTOE(dtoOidMarca);

		ComposerViewElement ci2 = new ComposerViewElement();
		ci2.setIDBusiness("MAEObtenerGenericosPorPais");
		ci2.setDTOE(dtoBel);

        ComposerViewElement ci3 = new ComposerViewElement();
		ci3.setIDBusiness("MAEObtenerUnidadesNegocioPorPais");
		ci3.setDTOE(dtoBel);

        ComposerViewElement ci4 = new ComposerViewElement();
		ci4.setIDBusiness("MAEObtenerSuperGenericosPorPais");
		ci4.setDTOE(dtoBel);

        ComposerViewElement ci5 = new ComposerViewElement();
		ci5.setIDBusiness("MAEObtenerNegocioPorPais");
		ci5.setDTOE(dtoBel);

        ComposerViewElement ci6 = new ComposerViewElement();
        DTOOID  dtoOid = new DTOOID();
        dtoOid.setOid(dtoDescuento.getDatosGralesDto().getOidCanal());
        dtoOid.setOidIdioma(lIdioma);
        dtoOid.setOidPais(lPais);
		ci6.setIDBusiness("PREObtenerTiposOfertaPorCanal");
		ci6.setDTOE(dtoOid);

        ComposerViewElement ci7 = new ComposerViewElement();
		ci7.setIDBusiness("PREObtenerCiclosVida");
		ci7.setDTOE(dtoBel);        
		
		lista.addViewElement(ci1);
		lista.addViewElement(ci2);
        lista.addViewElement(ci3);
		lista.addViewElement(ci4);
        lista.addViewElement(ci5);
    	lista.addViewElement(ci6);
        lista.addViewElement(ci7);
		
        traza("LPMantenimientoBaseCalculo.crearParametrosEntrada() - Salida");
		return lista;
	}

	private void recuperaValoresConfiguracionMatrizDescuento(DTODatosMatrizDescuentos dtoMatrizDescuento)
		throws Exception {
        traza("LPMantenimientoBaseCalculo.recuperaValoresConfiguracionMatrizDescuento() - Entrada");
		Iterator iterador = dtoMatrizDescuento.getListaParametros().iterator();
		
		while (iterador.hasNext()){
			DTOParametroMatrizDescuentos dtoP = (DTOParametroMatrizDescuentos)iterador.next();
			String sParam = dtoP.getOidParametro().toString();
			int para = Integer.parseInt(sParam);
			
			switch (para){
				case 14:
                    {
						traza("entro al 14");
                        asignarAtributo("VAR","VisibleBCDM","valor",obtenerValor(dtoP.getVisible()));
                        asignarAtributo("VAR","ObligatorioBCDM","valor",obtenerValor(dtoP.getObligatorio()));
                        asignarAtributo("VAR","ModificableBCDM","valor",obtenerValor(dtoP.getModificable()));
                    }
                    break;

                    case 15:
                    {
						traza("entro al 15");
						asignarAtributo("VAR","VisibleBCDUN","valor",obtenerValor(dtoP.getVisible()));
						asignarAtributo("VAR","ObligatorioBCDUN","valor",obtenerValor(dtoP.getObligatorio()));
						asignarAtributo("VAR","ModificableBCDUN","valor",obtenerValor(dtoP.getModificable()));
                    }
                    break;

                    case 16:
                    {
						traza("entro al 16");
                        asignarAtributo("VAR","VisibleBCDN","valor",obtenerValor(dtoP.getVisible()));
                        asignarAtributo("VAR","ObligatorioBCDN","valor",obtenerValor(dtoP.getObligatorio()));
                        asignarAtributo("VAR","ModificableBCDN","valor",obtenerValor(dtoP.getModificable()));
                    }
                    break;

                    case 17:
                    {
						traza("entro al 17");
                        asignarAtributo("VAR","VisibleBCDSG","valor",obtenerValor(dtoP.getVisible()));
                        asignarAtributo("VAR","ObligatorioBCDSG","valor",obtenerValor(dtoP.getObligatorio()));
                        asignarAtributo("VAR","ModificableBCDSG","valor",obtenerValor(dtoP.getModificable()));
                    }
                    break;

                    case 18:
                    {
						traza("entro al 18");
                        asignarAtributo("VAR","VisibleBCDG","valor",obtenerValor(dtoP.getVisible()));
                        asignarAtributo("VAR","ObligatorioBCDG","valor",obtenerValor(dtoP.getObligatorio()));
                        asignarAtributo("VAR","ModificableBCDG","valor",obtenerValor(dtoP.getModificable()));
                    }
                    break;

                    case 19:
                    {
						traza("entro al 19");
						asignarAtributo("VAR","VisibleBCDP","valor",obtenerValor(dtoP.getVisible()));
						asignarAtributo("VAR","ObligatorioBCDP","valor",obtenerValor(dtoP.getObligatorio()));
						asignarAtributo("VAR","ModificableBCDP","valor",obtenerValor(dtoP.getModificable()));
                    }
                    break;
			}
		}

        traza("LPMantenimientoBaseCalculo.recuperaValoresConfiguracionMatrizDescuento() - Salida");
    }

    private String obtenerValor(Boolean bool){
		if(bool.booleanValue())
			return "S";
		else
			return "N";
	}

	private ArrayList aplanarCriterios(String listado2STR) throws Exception {   
		traza("LPMantenimientoBaseCalculo.aplanarCriterios() - Entrada");
	    StringTokenizer stRows = new StringTokenizer(listado2STR, "$");

        int rowCount = stRows.countTokens();
        ArrayList listaDescuentos = new ArrayList ();
        
        for(int cont =  0 ;stRows.hasMoreTokens(); cont++){
            DTOSBaseCalculoDetalle dtoBaseCalcDet = new DTOSBaseCalculoDetalle();
            dtoBaseCalcDet.setOidIdioma(lIdioma);
            dtoBaseCalcDet.setOidPais(lPais);
		
            StringTokenizer stColss = new StringTokenizer(stRows.nextToken(), "|");

			for(int conta =  0 ;stColss.hasMoreTokens(); conta++){								
				StringTokenizer stCols = new StringTokenizer(stColss.nextToken(), ":");				
					
				for(int contad =  0 ;stCols.hasMoreTokens(); contad++){								
					String desc = stCols.nextToken().toString();
                    String valor = stCols.nextToken().toString();

					traza(desc + " " + valor);                    

	                if(desc.equals("m"))
						dtoBaseCalcDet.setMarca(Long.valueOf(valor));
	                if(desc.equals("un"))											
						dtoBaseCalcDet.setUnidadNegocio(Long.valueOf(valor));
				    if(desc.equals("n"))
						dtoBaseCalcDet.setNegocio(Long.valueOf(valor));
					if(desc.equals("sg"))
						dtoBaseCalcDet.setSupergenerico(Long.valueOf(valor));			
			        if(desc.equals("g"))
						dtoBaseCalcDet.setGenerico(Long.valueOf(valor));										
					if(desc.equals("eto")){
						if(valor.equals("S")) 
							dtoBaseCalcDet.setExclusionTipoOferta(Boolean.TRUE);
				        else
							dtoBaseCalcDet.setExclusionTipoOferta(Boolean.FALSE);						
					}
					if(desc.toString().equals("to"))
						dtoBaseCalcDet.setTipoOferta(Long.valueOf(valor)); 										
	                if(desc.toString().equals("cv"))
						dtoBaseCalcDet.setCicloVida(Long.valueOf(valor));										
	                if(desc.toString().equals("pr"))
						dtoBaseCalcDet.setProducto(Long.valueOf(valor));
					if(desc.toString().equals("descmarca"))
						dtoBaseCalcDet.setDescripcionMarca(new String(valor));
					if(desc.toString().equals("descunidad"))
						dtoBaseCalcDet.setDescripcionUnidadNegocio(new String(valor));
					if(desc.toString().equals("descnegocio"))
						dtoBaseCalcDet.setDescripcionNegocio(new String(valor));
					if(desc.toString().equals("descsuper"))
						dtoBaseCalcDet.setDescripcionSupergenerico(new String(valor));
					if(desc.toString().equals("descgenerico"))
						dtoBaseCalcDet.setDescripcionGenerico(new String(valor));
					if(desc.toString().equals("desctipo"))
						dtoBaseCalcDet.setDescripcionTipoOferta(new String(valor));
					if(desc.toString().equals("descciclo"))
						dtoBaseCalcDet.setDescripcionCicloVida(new String(valor));
					if(desc.toString().equals("descproducto"))
						dtoBaseCalcDet.setDescripcionProducto(new String(valor));
			    }
			}

            traza("*********** dtoBaseCalcDet " + dtoBaseCalcDet);
            listaDescuentos.add(dtoBaseCalcDet);
        }

		traza("LPMantenimientoBaseCalculo.aplanarCriterios() - Salida");
        return listaDescuentos;
     }
	

  /**
   * @author eiraola 21/11/2005 
   * @description  DMCO-DTO-BELC300014763
   * @throws java.lang.Exception
   */
	public void cargarPantalla() throws Exception {
		traza("LPMantenimientoBaseCalculo.cargarPantalla() - Entrada");
		dtoDescuento = getDescuento();		
		traza("************** DTOGlobalDescuento " + dtoDescuento);					
		
		casoDeUso = conectorParametroLimpia("casoDeUso", "", true);
        asignarAtributo("VAR","casoDeUso","valor",casoDeUso);

	    cargaCombos();                    

   	    DTOSBaseCalculo dtoBaseCal = dtoDescuento.getBaseCalculo(); 
	    if (dtoBaseCal != null) {
			AsignaValoresEnPantalla(dtoBaseCal);
        }
		
		if(dtoDescuento.getDatosGralesDto().getOidDescuento()!=null) {
			asignarAtributo("VAR","hidOidDescuento","valor", 
			dtoDescuento.getDatosGralesDto().getOidDescuento().toString());
		}

        if ((casoDeUso.equals("modificar"))
			||(casoDeUso.equals("consultar"))){                    
			if(dtoBaseCal!=null) {
				if(dtoBaseCal.getOidBase()!=null) {
					asignarAtributo("VAR","hidOidBase","valor",
					dtoBaseCal.getOidBase().toString());

					traza("OidBase:  " + dtoBaseCal.getOidBase().toString());
				}            
			}
        }                

        if ((casoDeUso.equals("modificar"))
			||( casoDeUso.equals("insertar"))){
           recuperaValoresConfiguracionMatrizDescuento(dtoDescuento.getDatosMatriz());                    
        }

   		traza("LPMantenimientoBaseCalculo.cargarPantalla() - Salida");
	 }

   /**
   * @author eiraola 21/11/2005 
   * @description  DMCO-DTO-BELC300014763
   * @throws java.lang.Exception
   */
	 public void almacenar() throws Exception {
		 traza("LPMantenimientoBaseCalculo.almacenar() - Entrada");
		
		 dtoDescuento = getDescuento();
		 dtoDescuento.setIndBaseCalculo(Boolean.TRUE);

		 if(dtoDescuento.getBaseCalculo()!=null) {
			 dtoDescuento.getBaseCalculo().setDetalle(null);
		 }
		 else {
			 DTOSBaseCalculo dtoTemp = new DTOSBaseCalculo();
			 dtoTemp.setDetalle(null);
			 dtoDescuento.setBaseCalculo(dtoTemp);
		 }

         DTOSBaseCalculo dtoBaseCal = new DTOSBaseCalculo();

         String lOidDesc = conectorParametroLimpia("hidOidDescuento", "", true);
         String sOidBase = conectorParametroLimpia("hidOidBase", "", true);      
		 
		 traza("********* lOidDesc " + lOidDesc);
		 traza("********* sOidBase " + sOidBase);

         if(!lOidDesc.equals("")) {
			 dtoBaseCal.setOidDescuento(new Long(lOidDesc));
		 }		 

         if(!sOidBase.equals("")) {
			 dtoBaseCal.setOidBase(new Long(sOidBase));
		 }
        
         
         String sDetalleCriterios = conectorParametroLimpia("hidDetalleCriterios", "", true);
          
          traza("**********JAS**********");
          traza("lo que recibo de la pantalla//sDetalleCriterios es: " + sDetalleCriterios);
          traza("**********JAS**********");
         
         
         
         ArrayList aDetalleCriterio = aplanarCriterios(sDetalleCriterios);
         dtoBaseCal.setDetalle(aDetalleCriterio);
         
         traza("**********JAS**********");
         traza("lo que obtengo a la salida de aplanarCriterios es: " + aDetalleCriterio);
         traza("**********JAS**********");
         
        
        //de aca para abajo es del listado de productos.
        
		 String sDetalleProductos = conectorParametroLimpia("hidDetalleProductos", "", true);
         ArrayList aDetalleProductos = aplanarProductos(sDetalleProductos);
         dtoBaseCal.setProductos(aDetalleProductos);

   		 dtoDescuento.setBaseCalculo(dtoBaseCal);
 		 setDescuento(dtoDescuento);
 		 traza("********** DTOGlobalDescuento a grabar " + dtoDescuento);
		 traza("LPMantenimientoBaseCalculo.almacenar() - Salida");
	 }
	
  
  /**
   *  
   * @author eiraola 21/11/2005 
   * @description  DMCO-DTO-BELC300014763
   * @throws java.lang.Exception
   * @return Arraylisr
   * @param String sDetalleProductos
   */
	private ArrayList aplanarProductos(String sDetalleProductos) throws Exception{
		 traza("LPMantenimientoBaseCalculo.aplanarProductos() - Entrada");
		 traza("************** sDetalleProductos :" + sDetalleProductos);

   	     StringTokenizer stRows = new StringTokenizer(sDetalleProductos, "$");

         int rowCount = stRows.countTokens();
         ArrayList productos = new ArrayList();
        
         for(int cont =  0 ;stRows.hasMoreTokens(); cont++){
            DTOProductoDTO dtoProducto = new DTOProductoDTO();
		
            StringTokenizer stColss = new StringTokenizer(stRows.nextToken(), "|");

			for(int conta =  0 ;stColss.hasMoreTokens(); conta++){								
				StringTokenizer stCols = new StringTokenizer(stColss.nextToken(), ":");				
					
				for(int contad =  0 ;stCols.hasMoreTokens(); contad++){								
					String desc = stCols.nextToken().toString();
                    String valor = stCols.nextToken().toString();

					traza(desc + " " + valor);                    

	                if(desc.equals("oid")) {
						dtoProducto.setOidProducto(Long.valueOf(valor));
					}
						
	                if(desc.equals("codigosap")) {
						dtoProducto.setCodigoSAP(new String(valor));
					}
						
				    if(desc.equals("descripcion")) {
						dtoProducto.setDescripcion(new String(valor));
					}						
			    }
			}

            traza("*********** dtoProducto " + dtoProducto);
            productos.add(dtoProducto);
        }

 		traza("LPMantenimientoBaseCalculo.aplanarProductos() - Salida");
		return productos;
	}

  /**
   * @author eiraola 21/11/2005 
   * @description  DMCO-DTO-BELC300014763
   * @throws java.lang.Exception
   */
	public void siguiente() throws Exception {
		traza("LPMantenimientoBaseCalculo.siguiente() - Entrada");
		casoDeUso = conectorParametroLimpia("casoDeUso", "", true);
		
		if (!casoDeUso.equals("consultar")) {
			almacenar();
		}		

		conectorAction("LPMantenimientoBaseAplicacion");
		conectorActionParametro("accion",""); 
	    conectorActionParametro("casoDeUso",casoDeUso);
		traza("LPMantenimientoBaseCalculo.siguiente() - Salida");
	}
}
