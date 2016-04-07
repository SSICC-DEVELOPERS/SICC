import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.inc.DTOConcurso;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.inc.DTONivelPremiacion;
import es.indra.sicc.dtos.inc.DTONivelesPremiacion;
import es.indra.sicc.dtos.inc.DTOPedidoPremiar;
import es.indra.sicc.dtos.inc.DTOProgramaNuevas;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.lang.Exception;
import java.util.Vector;
import java.math.BigDecimal;

public class LPMantenerProgramaNuevas extends LPIncentivos{ 
	private String pais = null;
	private String idioma = null;
	private String cantidadVeces = null;
	private String valoresLista = null; 
  
	public LPMantenerProgramaNuevas() { super(); }

	public void inicio() throws Exception {        
		this.obtenerFlagsPestanyas();
	    pagina("contenido_programa_nuevos_mantener");    
		this.cargarFlagsPestanyas();
	    this.getFormatosValidaciones();
	}		
  
	public void ejecucion() throws Exception {  
		setTrazaFichero();
		
		accion = conectorParametroLimpia("accion", "", true);        
		pais = UtilidadesSession.getPais(this).toString();
		idioma = UtilidadesSession.getIdioma(this).toString();
		opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
		cantidadVeces = conectorParametroLimpia("cantidad", "", true);
		valoresLista = conectorParametroLimpia("valoresLista", "", true);

		traza("********** accion " + accion);
		traza("********** pais "  +pais );
		traza("********** idioma " + idioma);	             
		traza("********** opcionMenu " + opcionMenu);  
		traza("********** cantidadVeces " + cantidadVeces);
		traza("********** valoresLista " + valoresLista);    
   
		try{                               
          //getConfiguracionMenu("LPMantenerProgramaNuevas" , "");
	        asignarAtributo("VAR","hPais","valor",pais);
          asignarAtributo("VAR","hIdioma","valor",idioma);	                               
      
			if (accion.equals("")){ 
                cargarPantalla();
	    }else if (accion.equals("almacenar")){ 
                  this.almacenar();                   
                 this.redirigir();
	          }else if (accion.equals("guardar")){           
                  this.almacenar(); 
                  this.guardar();            
            }
		    else if(accion.equals("redirigir")){
                  this.redirigir();
			}  
      
     getConfiguracionMenu("LPMantenerProgramaNuevas" , "");
     if(opcionMenu.equals("Crear concurso")){
          asignarAtributoPagina("cod", "0491");             
     }else if(opcionMenu.equals("Consultar Concurso")){
          asignarAtributoPagina("cod", "0493");
    }else if(opcionMenu.equals("Modificar Concurso")){
          asignarAtributoPagina("cod", "0486");
   }
    
      
 }
	catch (Exception e){
          traza("Exception en LPMantenerProgramaNuevas");
	        e.printStackTrace();     
          lanzarPaginaError(e);
	}
} 
 
 
 //Metodo que se ejecuta al inciar el caso de uso
	public void cargarPantalla() throws Exception{   
  
		traza("************** Entre a cargarPantalla");
		String listaPremiar = new String();    
		DTOConcurso dtoConcurso = this.getConcurso();   
	   
		if ((dtoConcurso.getListaNivelesPremiacion() != null) && 
			  (dtoConcurso.getListaNivelesPremiacion().getListaNiveles() != null) &&
			  (dtoConcurso.getListaNivelesPremiacion().getListaNiveles().length > 0)) {  
			  
			DTOBelcorp dtoe = new DTOBelcorp();       
		  
			dtoe.setOidIdioma(dtoConcurso.getOidIdioma());
			dtoe.setOidPais(dtoConcurso.getOidPais());
					
			ComposerViewElementList lista = new ComposerViewElementList();  
			
			ComposerViewElement cmb1 = new ComposerViewElement();
			cmb1.setIDBusiness("INCRecuperarTiposExigencia");
			cmb1.setDTOE(dtoe);  
			  
			ComposerViewElement cmb2 = new ComposerViewElement();
			cmb2.setIDBusiness("INCRecuperarTiposRequisito"); 
			cmb2.setDTOE(dtoe);
			
			lista.addViewElement(cmb1);
			lista.addViewElement(cmb2);
			
			ConectorComposerView conector = new ConectorComposerView(lista, this.getRequest());
			conector.ejecucion();
			
			DruidaConector resultados = conector.getConector();
				
			asignar("COMBO","cbTipoExigencia", resultados,"INCRecuperarTiposExigencia");                                             
			asignar("COMBO","cbTipoRequisito", resultados,"INCRecuperarTiposRequisito"); 
		  
			DTONivelPremiacion[] arrayNivelPremiacion = 
								  dtoConcurso.getListaNivelesPremiacion().getListaNiveles();
			
			// Obtiene los valores para el combo de la listaEditable
			StringBuffer linea = new StringBuffer("");
			DTONivelPremiacion dtoNivelPremiacion = null;
			for (int i = 0; i < arrayNivelPremiacion.length; i++) {
			  traza("Bucle " + i);
		  
			  dtoNivelPremiacion = arrayNivelPremiacion[i];
			  traza("dtoNivelPremiacion: " + dtoNivelPremiacion);
			  
			  Long oid = new Long(dtoNivelPremiacion.getNumeroNivel().longValue());
			  String descripcion = dtoNivelPremiacion.getNumeroNivel().toString();      
			  traza("oid -- " + oid);
			  traza("descripcion -- " + descripcion);        
			  linea.append(oid.toString());
			  linea.append(",");
			  linea.append(descripcion);
			  linea.append("|");
			}
		
			traza("linea: " + linea.toString());
			asignarAtributo("VAR","hdCombo","valor", linea.toString());   
			// FIN CARGA COMBO DE LISTAEDITABLE
			//----------------------------------------------------------------------
				
			if (dtoConcurso.getProgramaNuevas() == null)
			  dtoConcurso.setProgramaNuevas(new DTOProgramaNuevas());
			  
			if ((dtoConcurso.getIndProgramaNuevas() != null) && 
				  (dtoConcurso.getIndProgramaNuevas().booleanValue())){
			   
         
         ArrayList lstPedidosPremiar = 
								  dtoConcurso.getProgramaNuevas().getListaPedidosPremiar();
			   
         if (lstPedidosPremiar != null){
                  traza("lstPedidosPremiar --- " + lstPedidosPremiar.size());
			   }else{
                 traza("lstPedidosPremiar es null, se crea nuevo");
                 lstPedidosPremiar = new ArrayList();
			   }  
			 
			   String datos = new String(); 
			 
			   // Obtiene los valores ya guardados para la LE. 
			   //ArrayList aListaPedidos = dtoConcurso.getProgramaNuevas().getListaPedidosPremiar();
			   int cantRegistrosListas = lstPedidosPremiar.size();
         
         
			   traza("Se encontraron " + cantRegistrosListas + " registros");
         
			   RecordSet rLista = new RecordSet();
			   Vector vFila = null;         
			   Vector vCols = new Vector();
			 
			   // -- Seteo los cols Identifiers.
			   vCols.add("OID");
			   vCols.add("NPedido");
			   vCols.add("NPremiacion");
			   vCols.add("ExigMinima");
			   rLista.setColumnIdentifiers(vCols);
			   
			   for(int i=0; i<cantRegistrosListas; i++) {
                 traza("Bucle " + i);
                 
                 vFila = new Vector();
                 DTOPedidoPremiar dtoPedidoPremiar = (DTOPedidoPremiar) lstPedidosPremiar.get(i);
                 
                 Long oidPedidoPremiar = dtoPedidoPremiar.getOidPedidoPremiar();
				 BigDecimal exigenciaMinima = dtoPedidoPremiar.getExigenciaMinima();
				 traza("********** exigenciaMinima " + exigenciaMinima);
				 String tempExigencia;

				 if(exigenciaMinima!=null) {
					tempExigencia  = UtilidadesBelcorp.formateaNumeroSICC(exigenciaMinima.toString(),
					 this.FORMATO_DEFAULT, this);              				 
				 }
				 else {
					tempExigencia = "";
				 }
				 
				 traza("********** tempExigencia " + tempExigencia);                 
                 
				 Long oidNivelPremiacion = dtoPedidoPremiar.getOidNivelPremiacion();
                 Integer numPedido = dtoPedidoPremiar.getNumeroPedido();
                 
                 vFila.add(oidPedidoPremiar);
                 vFila.add(numPedido);
                 vFila.add(oidNivelPremiacion);
                 vFila.add(tempExigencia);
                 
                 rLista.addRow(vFila);
			   }
			 
			   traza("RecordSet generado: " + rLista);
			   DruidaConector con = 
					  UtilidadesBelcorp.generarConector("listaPremios", 
														rLista, 
														rLista.getColumnIdentifiers());
														
			   //this.asignarAtributo("VAR","hidLstPremiar","valor", listaPremiar);
			 
			   traza("*** Asigno Campos Controles ***");
			   if (dtoConcurso.getProgramaNuevas().getPeriodosEvaluar()!= null){             
             String  periodoEvaluar = dtoConcurso.getProgramaNuevas().getPeriodosEvaluar().toString();
             asignarAtributo("CTEXTO","txtNumPeriodoEvaluar","valor", periodoEvaluar);                
			   }
			 
			   if (dtoConcurso.getProgramaNuevas().getOidTipoExigencia()!= null){
             String oidTipoExigencia = dtoConcurso.getProgramaNuevas().getOidTipoExigencia().toString();
             this.asignarAtributo("VAR", "cbTipoExi", "valor", oidTipoExigencia);
             //asignarAtributo("COMBO", "cbTipoExigencia", "valor", oidTipoExigencia);
			   }
			 
			   if (dtoConcurso.getProgramaNuevas().getOidTipoRequisito()!= null){
             String oidTipoRequisito = dtoConcurso.getProgramaNuevas().getOidTipoRequisito().toString();
             this.asignarAtributo("VAR", "cbTipoRequi", "valor", oidTipoRequisito);
             //asignarAtributo("COMBO", "cbTipoRequisito", "valor", oidTipoRequisito);
			   }

			   if (dtoConcurso.getProgramaNuevas().getPedidosPremiar() != null){             
             String  periodoPremiar = dtoConcurso.getProgramaNuevas().getPedidosPremiar().toString();
             asignarAtributo("CTEXTO","txtNumPedidosPremiar","valor", periodoPremiar);                
			   }  
			   
			   this.asignar("LISTADOA", "listado1", con, "listaPremios"); 
         
			   if (cantRegistrosListas > 0) { // Indico que quiero que se muestre la lista, 
				  this.asignarAtributo("VAR", "mostrarLista", "valor", "S");
			   }
			
      }
			 asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
			 asignarAtributo("VAR", "accion", "valor", accion);
		}
		else{
           String error = new String();
           error = "INC-0015";		   
           asignarAtributo("VAR", "errCarga", "valor", error.toString());
		   asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
		   asignarAtributo("VAR", "accion", "valor", accion);
	    }     
  }
  
  
  //- Se ejecuta cuando se guardan los valores, cargados en la pantalla  
  public void almacenar() throws Exception {      
      traza("************ Entra en almacenar - LPMantenerProgramaNuevas");
      DTOConcurso dto = this.getConcurso();            
      
      if ( dto.getProgramaNuevas() == null){
        dto.setProgramaNuevas(new DTOProgramaNuevas() );
      }
      
      String datos = conectorParametroLimpia("hdatosObligatorios", "", true);
      String cantidadLista = conectorParametroLimpia("valoresOID", "", true);

      traza("********* datos " + datos);
      traza("********* cantidadLista " + cantidadLista);
      
      //- se indica que ya se ha rellenado la pestaña
      dto.setIndProgramaNuevas(new Boolean(true));
      
      //- parametro que se obtiene desde la pagina     
      if(datos.equals("true"))
          dto.setIndObligProgramaNuevas(Boolean.TRUE); 
      else    
          dto.setIndObligProgramaNuevas(Boolean.FALSE);      
      
      String txtPeridosEvaluar = conectorParametroLimpia("numPedidos", "", true);
      String oidTipoExigencia = conectorParametroLimpia("cbTipoExi", "", true);
      String oidTipoRequisito = conectorParametroLimpia("cbTipoRequi", "", true);
      String txtPedidosPreliminar = conectorParametroLimpia("numPedidosPrem", "", true);

      traza("********* txtPeridosEvaluar " + txtPeridosEvaluar);
      traza("********* oidTipoExigencia " + oidTipoExigencia);
      traza("********* oidTipoRequisito " + oidTipoRequisito);
      traza("********* txtPedidosPreliminar " + txtPedidosPreliminar);
      
      if (txtPeridosEvaluar != null && !txtPeridosEvaluar.equals("")){  
      
            Integer text = Integer.valueOf(txtPeridosEvaluar);	
            
            int a=0;
            a+= Integer.parseInt(txtPeridosEvaluar);
            a++;
            
            if (dto.getProgramaNuevas() != null)
                  dto.getProgramaNuevas().setPeriodosEvaluar(text);
      }else{
              dto.getProgramaNuevas().setPeriodosEvaluar(null);
	    }
      
      if ((oidTipoExigencia != null) && !(oidTipoExigencia.equals(""))){      
        if (dto.getProgramaNuevas() != null){
            dto.getProgramaNuevas().setOidTipoExigencia(new Long(oidTipoExigencia));
        }        
      }else{
            dto.getProgramaNuevas().setOidTipoExigencia(null);
      }     
      
      if ((oidTipoRequisito != null) && !(oidTipoRequisito.equals(""))){       
       if (dto.getProgramaNuevas() != null) {
            dto.getProgramaNuevas().setOidTipoRequisito(new Long(oidTipoRequisito));
       }       
      }else{
              dto.getProgramaNuevas().setOidTipoRequisito(null);
      }
      
      if ((txtPedidosPreliminar != null) && !(txtPedidosPreliminar.equals(""))){ 
      
              Integer textPremiar = Integer.valueOf(txtPedidosPreliminar);	
              int b=0;
              b+= Integer.parseInt(txtPedidosPreliminar);
              b++;
              
              traza("textPremiar ** " + textPremiar); 
              
              if (dto.getProgramaNuevas() != null)
                dto.getProgramaNuevas().setPedidosPremiar(textPremiar);             
             
      }else{
              dto.getProgramaNuevas().setPedidosPremiar(null);             
	    }      
       
       // - Si la lista tiene algun elemento se elimina la lista
       if (dto.getProgramaNuevas().getListaPedidosPremiar()!=null){
              dto.getProgramaNuevas().setListaPedidosPremiar(null);
       }
       
       String Lista = conectorParametroLimpia("valoresLista", "", true);
       traza("************ Lista " + Lista);
     
       /** Agregado por ssantana, 23/5/2005 - Parseo de Lista Editable
          Esta lista tiene los siguientes campos: 
                        - oidPedidosPremiar (oculto) 
                        - numeroPedido 
                        - oidNivelPremiacion 
                        - exigenciaMinima
       **/
       ArrayList listaDTOsPedidoPremiar = new ArrayList();
       DTOPedidoPremiar dtoPedidoPremiar =  null;
       StringTokenizer tokFilas = new StringTokenizer(Lista, "|");
       StringTokenizer tokCampos = null;
      
        while (tokFilas.hasMoreTokens()){ //--inc while
        
         // Obtengo la fila
         String sFila = tokFilas.nextToken();
         traza("sFila: " + sFila);
         
         // Obtengo los campos. 
         tokCampos = new StringTokenizer(sFila, "*");
         
         // Obtengo todos los campos.
         String sOid = tokCampos.nextToken();
         String sNumeroPedido = tokCampos.nextToken();
         String sOidNivelPremiacion = tokCampos.nextToken();		
		 String sExigenciaMinima = tokCampos.nextToken();
         
         traza("******** sOid: " + sOid);
         traza("******** sNumeroPedido: " + sNumeroPedido);
         traza("******** sOidNivelPremiacion: " + sOidNivelPremiacion);
         traza("******** sExigenciaMinima: " + sExigenciaMinima);

		 String tempExigenciaMinima = desFormatearNumero(sExigenciaMinima, this.FORMATO_DEFAULT);
         traza("******** tempExigenciaMinima: " + tempExigenciaMinima);

         // Completo el DTO con los valores de los campos. 
         dtoPedidoPremiar = new DTOPedidoPremiar();   
         
         if (sOid.equals("&"))
            dtoPedidoPremiar.setOidPedidoPremiar(null);
          else
            dtoPedidoPremiar.setOidPedidoPremiar(new Long(sOid));
            
         if (sNumeroPedido.equals("&"))
            dtoPedidoPremiar.setNumeroPedido(null);
         else
            dtoPedidoPremiar.setNumeroPedido(new Integer(sNumeroPedido));
            
         if (sOidNivelPremiacion.equals("&"))
            dtoPedidoPremiar.setOidNivelPremiacion(null);
         else
            dtoPedidoPremiar.setOidNivelPremiacion(new Long(sOidNivelPremiacion));
            
         if (sExigenciaMinima.equals("&"))
            dtoPedidoPremiar.setExigenciaMinima(null);
         else
            dtoPedidoPremiar.setExigenciaMinima(new BigDecimal(tempExigenciaMinima));
         
         listaDTOsPedidoPremiar.add(dtoPedidoPremiar);
      
      }//--fin del while
      
      dto.getProgramaNuevas().setListaPedidosPremiar(listaDTOsPedidoPremiar); 
      this.setConcurso(dto);   
   }
}
