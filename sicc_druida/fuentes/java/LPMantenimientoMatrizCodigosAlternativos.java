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

/**
 * Sistema:             Belcorp - SICC
 * Modulo:              PRE 
 * * Componente:          LPMantenimientoMatrizCodigosAlternativos
 * Fecha:               13/02/2004
 * Dcoumentacion:       
 * @version             3.0
 */


//import LPSICCBase;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.pre.DTOProductoVenta;
import es.indra.sicc.dtos.pre.DTOProductosVenta;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.xml.XMLDocument;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;

import org.jaxen.dom.DOMXPath;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

public class LPMantenimientoMatrizCodigosAlternativos extends LPSICCBase {

  private Vector vParamEntrada	= new Vector();
  private String condi;
  private String LP;

  public LPMantenimientoMatrizCodigosAlternativos() {		
    super();	
  }

  public void inicio() throws Exception {		
    pagina("contenido_matriz_codigos_alternativos_registrar");
  }

  public void ejecucion() throws Exception {
      
    setTrazaFichero();
    
	  String accion = conectorParametroLimpia("accion", "", true);
       
    Long pais = UtilidadesSession.getPais(this);
    Long idioma = UtilidadesSession.getIdioma(this);

	  String descripcion = conectorParametro("gDescripcionPVenta");
	  String oidMatrizCodigoAlternativo = conectorParametroLimpia("oidMatrizCodigoAlternativo", "", true);
    String oidMatrizFacturacion = conectorParametroLimpia("oidMatrizFacturacion", "", true);

	  Vector paramEntrada = new Vector();
    DTOProductosVenta dtoe = null;

	  String elementosSeleccionados = conectorParametroLimpia( "elementosSeleccionados","",true );

	  String mensajeLog;

    DruidaConector ConectorCargaPantallasRegistro = null;
	  DruidaConector ConectorGuardarMatrizCodigosAlternativos = null;	
	  
	  traza("/* -LPMantenimiento- accion " + accion + "*/");
    traza("conectorParametroSesion(gLPVolver) ::::" + conectorParametroSesion("gLPVolver") );	

	  asignarAtributo("VAR", "accion", "valor", accion );

    try{//10

      cargarMenuSecundario();
      
      rastreo();
		
      if(accion.equals("")){
        conectorAction("LPSeleccionarMF");				
		    conectorParametroSesion("UltimaLP","LPMantenimientoMatrizCodigosAlternativos");
      }else if(accion.equals("Matriz seleccionada")){//8
          /*
					Obtener de la sesión el oid de la matriz seleccionada en la
					actividad anterior 	Mostrar pagina 
					"_matriz_codigos_alternativos_registrar" vacía 
          */
			    String sOidMatriz = ((Long) conectorParametroSesion("oidCabeceraMF")).toString(); 
          traza("contenido del oid de matriz  ::: . " + sOidMatriz);	
				
          asignarAtributo("VAR", "oidMatrizFacturacion", "valor", sOidMatriz);
			}else if (accion.equals("buscarProductoPrincipal")){//7	
        /*
				Guardar en sesión el nombre de la LP actual en la variable "UltimaLP" y 
				llamar a la LP "LPBuscarProductosVenta", accion "buscarProductoPrincipal" 	
				*/
				traza("%%%%%%% buscarProductoPrincipal");	
				conectorParametroSesion("UltimaLP", "LPMantenimientoMatrizCodigosAlternativos");
				conectorAction("LPBuscarProductosVenta");				
				conectorActionParametro("accion","buscarProductoPrincipal");
      }else if (accion.equals("productoPrincipalSeleccionado")){//6
			  /*
				Obtener de la sesión el objeto DTOProductoVenta 
				Construir idBusiness = "PRECargarRegistroMatrizCodigosAlternativos" 
				Asignar conector "ConectorCargaPantallasRegistro" 
				Asignar a la pagina el objeto dto de respuesta "DTOSalida"
			  */
				traza(" productoPrincipalSeleccionado");	
				DTOProductoVenta dtop  = (DTOProductoVenta)conectorParametroSesion("DTOProductoVenta");
				traza("dtop :::" + dtop);

				dtop.setOidIdioma(UtilidadesSession.getIdioma(this));
     
				paramEntrada.add(dtop);
				paramEntrada.add(new MareBusinessID("PRECargarRegistroMatrizCodigosAlternativos"));
						
				String sCampo = dtop.getCodigoVenta();

				asignarAtributo("LABELC", "lblCodigoVentaXX", "valor", sCampo);
				sCampo =dtop.getDescripcion();	
				asignarAtributo("LABELC", "lblDescripcionXX", "valor", sCampo);

				
				traza("antes de conector");
			  DruidaConector conector = conectar("ConectorCargaPantallasRegistro",paramEntrada);
				traza("despues de conector");

				DTOSalida dtoSalida = (DTOSalida)conector.objeto("DTOSalida");
            
        RecordSet rs = dtoSalida.getResultado();

        traza("contenidod de rs ::: " + rs);
        if(rs.esVacio() ){
          asignarAtributo("VAR", "hidDatosReemp", "valor", "N");
        }else{
          traza("contenido del dtoSalida :::::: " + dtoSalida);				
					asignarAtributo("VAR", "oidMatrizFacturacion", "valor", dtop.getOidMatrizFacturacion().toString());
					asignarAtributo("VAR", "accion", "valor", "productoPrincipalSeleccionado");				

					asignar("LISTAEDITABLE", "listado1", generarConectorListEditCF("ROWSET", rs, (Vector)rs.getColumnIdentifiers()),"ROWSET");
					asignarAtributo("VAR", "hidDatosReemp", "valor", "S");
					traza("paso por aca:::");
				}
      }else if (accion.equals("buscarProductosAlternativos")){//5
        /*
        Guardar en sesión el nombre de la LP actual en la variable "UltimaLP" 
        y llamar a la LP "LPBuscarProductosVenta", accion 
        "buscarGrupoProductosAlternativos" 
        */
		    RecordSet prodAlter= armarRecordSet(elementosSeleccionados);
        traza("lista: " + prodAlter);
        conectorParametroSesion("ProductosAlternativosAnt", prodAlter);

        conectorParametroSesion("UltimaLP", "LPMantenimientoMatrizCodigosAlternativos");
        
        conectorAction("LPBuscarProductosVenta");
        conectorActionParametro("accion","buscarGrupoProductosAlternativos");		
      }else if (accion.equals("grupoProductosSeleccionado")){
        /* Obtener de la sesión el objeto DTOProductosVenta y añadir las posiciones del 
			  array que lleva dentro a la tabla de productos alternativos 
        */	
        traza("%%%%%%%%% grupoProductosSeleccionado");
        DTOProductoVenta dtop  = (DTOProductoVenta)conectorParametroSesion("DTOProductoVenta");
        DTOProductosVenta dtope  =(DTOProductosVenta)conectorParametroSesion("DTOProductosVenta");

        String sCampo = dtop.getDescripcion();	
    		asignarAtributo("LABELC", "lblDescripcionXX", "valor", sCampo);

        String sCamp = dtop.getCodigoVenta();	
        asignarAtributo("LABELC", "lblCodigoVentaXX", "valor", sCamp);

        vParamEntrada.add(dtope);
			
        ArrayList ar = new ArrayList();

        ar = dtope.getListaProductos();
        int tamanio = ar.size();

        RecordSet recLista = new RecordSet();

        Vector vec = new Vector();

        recLista.setColumnIdentifiers(vec);
        DTOProductoVenta  dtoPv =  new DTOProductoVenta();

        recLista.addColumn("oids");
        recLista.addColumn("codVenta");
        recLista.addColumn("desc");
        recLista.addColumn("nroOrden");
        recLista.addColumn("emiteMen");		
		
        for( int i=0; i < tamanio; i++){
          dtoPv = (DTOProductoVenta) ar.get(i);		
	
          recLista.setRowCount( ar.size() );

          if((dtoPv.getOidMatrizFacturacion() == null) || (dtoPv.getOidMatrizFacturacion().equals(""))){
            vec.add("");
            recLista.setValueAt("",i,0);
          }else{
            vec.add(dtoPv.getOidMatrizFacturacion());
		    		recLista.setValueAt(dtoPv.getOidMatrizFacturacion(),i,0);
          }
		
          if((dtoPv.getCodigoVenta() == null) || (dtoPv.getCodigoVenta().equals(""))){
            vec.add("");
            recLista.setValueAt("",i,1);				
          }else{					
            vec.add(dtoPv.getCodigoVenta());
		    		recLista.setValueAt(dtoPv.getCodigoVenta(),i,1);
          }
          
          if((dtoPv.getDescripcion() == null) || (dtoPv.getDescripcion().equals(""))){			
            vec.add("");
            recLista.setValueAt("",i,2);
          }else{					
            vec.add(dtoPv.getDescripcion());
            recLista.setValueAt(dtoPv.getDescripcion(),i,2);
          }

          if((dtoPv.getNumeroOrden() == null)){
            vec.add("");
            recLista.setValueAt("",i,3);
          }else{
            vec.add(dtoPv.getNumeroOrden());
            recLista.setValueAt(vec,i,3);	
          }

          if((dtoPv.getEmiteMensaje() == null)){	
            vec.add("");
            recLista.setValueAt("",i,4);
          }else{
            vec.add(dtoPv.getEmiteMensaje());
            recLista.setValueAt(vec,i,4);
          }
        }

        traza("nueva lista: " + recLista);

        RecordSet listaCombinada= combinarListas((RecordSet)conectorParametroSesion("ProductosAlternativosAnt"), recLista);

        String nombreListado = "listado1";
    		asignar("LISTADOA", nombreListado, generarConectorListEditCF("ROWSET", listaCombinada, (Vector)listaCombinada.getColumnIdentifiers()),"ROWSET");
        asignarAtributo("VAR", "hidDatosReemp", "valor", "S");
        
      }else if (accion.equals("guardarMatriz")){//2
      
        /* 
				Construir un objeto DTOProductosVenta 
				Guardar el producto principal de la pantalla en un objeto 
				DTOProductoVenta y añadirlo al parámetro productoPrincipal 
				del DTOProductosVenta 

				Por cada registro de la tabla de productos alternativos 
				construir un objeto DTOProductoVenta, y almacenarlos todos en
				un objeto DTOProductosVenta, en un array que contiene como 
				atributo
				   
				Construir idBusiness = "PREGuardarMatrizCodigosAlternativos" 
				Asignar conector "ConectorGuardarMatrizCodigosAlternativos"
				*/
        
        pagina("salidaGenerica");

				traza("*** dentro del metodo de guardarMatriz-------");	
             
				ArrayList arrayL = new ArrayList();   

				DTOProductosVenta dtopVt = new DTOProductosVenta();
				DTOProductoVenta dtoP = new DTOProductoVenta();


        //Parametros auditoria
				dtopVt.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
        dtopVt.setPrograma( UtilidadesSession.getFuncion(this) );

        dtoP.setIpCliente( UtilidadesBelcorp.getIPCliente(this) );
        dtoP.setPrograma( UtilidadesSession.getFuncion(this) );


				//Para obtener el producto principal de pantalla*************
				DTOProductoVenta dtopto  = (DTOProductoVenta)conectorParametroSesion("DTOProductoVenta");

        //Parametros auditoria
        dtopto.setIpCliente( UtilidadesBelcorp.getIPCliente(this) );
        dtopto.setPrograma( UtilidadesSession.getFuncion(this) );

				dtopVt.setProductoPrincipal(dtopto);
				traza("producto Principal :::" + dtopto);
					
				String elementosSeleccionado = conectorParametroLimpia( "elementosSeleccionados","",true );
				traza("elementosSeleccionado:::..."+ elementosSeleccionado);
		
				StringTokenizer tokTemp = new StringTokenizer(elementosSeleccionado, "|");	

				StringTokenizer tok = null;

				traza("StringTokenizer:::::...." + tok);
				
				String oid = new String();
				String codigoDeVenta = new String();
				String descripci = new String();
				String numOrden = new String();
				String mensaje = new String();
     		boolean mensaje1 = false;

			  int indice = -1;	

        while (tokTemp.hasMoreTokens()){
          String linea = tokTemp.nextToken();
          tok = new StringTokenizer(linea, ",");

          traza("contenido de tokTemp ::::.  " + tokTemp); 
          
          while (tok.hasMoreTokens()) {
            traza("antes de oid");
            oid = tok.nextToken();
            traza("despues ::::" + oid);
			   
            traza("antes del codigoDeVenta");
            codigoDeVenta = tok.nextToken();
            traza("codigoDeVenta:::: " + codigoDeVenta);				   
            traza("despues del codigoDeVenta");

            traza("antes del descripcion");	
            descripci = tok.nextToken();
            traza(":::::descripcion :::: " + descripci);
            traza("despues del descripcion");		
            int i = 0;

            traza("antes del numOrden");	
            numOrden = tok.nextToken();	
            traza("numn Orden '''''''  "+ numOrden); 

            if(numOrden.equals("S")){
              traza("°°°°°°°°°°°°°°°°°°°°°");
              traza("contenido de numOrden .... S???" + numOrden);
              mensaje = numOrden;
              traza("contenido de mensaje----" + mensaje);
              mensaje1 = true;
              numOrden = "";
              traza("contenido de numOrden .... S?" + numOrden);
              i = 1;
            }else{
              if (numOrden.equals("N")){
                traza("!!!!!!!!!!!!!!!!!!");
								traza("contenido de numOrden N????" + numOrden);
								mensaje = numOrden;
								traza("contenido de mensaje----" + mensaje);
								mensaje1 = false;
								numOrden = "";
								traza("contenido de numOrden   " + numOrden);
								i=1;
							}
            }
            
            traza(":::::::....numOrden::::..." +numOrden);
				   
            if(i  != 1){ 
              traza("antes del mensaje");	
              mensaje = tok.nextToken();

              if(mensaje.equals("S")){
                mensaje1 = true;
              }else{
                mensaje1 = false;	
              } 
            }
            
            traza("::::: mensaje::::.  "+ mensaje1);

            DTOProductoVenta dtoProVta = new DTOProductoVenta();

            //Parametros auditoria
            dtoProVta.setIpCliente( UtilidadesBelcorp.getIPCliente(this) );
            dtoProVta.setPrograma( UtilidadesSession.getFuncion(this) );
            
            dtoProVta.setCodigoVenta(codigoDeVenta);
            dtoProVta.setDescripcion(descripci);

            if(numOrden==null||numOrden.trim().equals("")){
              dtoProVta.setNumeroOrden(new Long(0));
            }else{				
              dtoProVta.setNumeroOrden(new Long(numOrden));
            }
				
            dtoProVta.setEmiteMensaje(new Boolean(mensaje1));
            dtoProVta.setOidMatrizFacturacion(new Long(oid));	
            traza("%%%%% dtopVt******" + dtopVt);

            arrayL.add(dtoProVta);
            dtopVt.setListaProductos(arrayL);	

            traza("+++++++ contenido del DTOPVT, que le mando el array:::::" + dtopVt);
          }
        }
        /* enozigli 17/11/2004 incidencia BELC300009420 V3.2
        -> Comprobar que no existe ningún número de orden repetido y todos los productos tienen un
          número asignado
        -> En caso contrario, mostrar el mensaje de error PRE-0050 "Existen productos con números de
          orden repetidos o nulos
        */
        ArrayList arrValidar = dtopVt.getListaProductos();
        Collection valida = new Vector();
        boolean ok = true;
        Iterator itValidar = arrValidar.iterator();
        while (itValidar.hasNext()&&ok){
              DTOProductoVenta dtopvvalidar = (DTOProductoVenta)itValidar.next();
              if (dtopvvalidar.getNumeroOrden()!=null){
                if(!valida.contains(dtopvvalidar.getNumeroOrden())){
                  valida.add(dtopvvalidar.getNumeroOrden());
                } else {
                  traza("repetido el "+ dtopvvalidar.getNumeroOrden());
                  ok = false;
                }
              } else {
                traza("nulo el de CV "+ dtopvvalidar.getCodigoVenta());
                traza("y descripcion "+ dtopvvalidar.getDescripcion());
                ok = false;
              }
              //valida
        }

        if (!ok){
           throw new MareException(new Exception(),50050);  
        }       
        
	    	MareBusinessID id = new MareBusinessID("PREGuardarMatrizCodigosAlternativos");
				Vector paramEnt = new Vector();
				paramEnt.add(dtopVt);
				paramEnt.add(id);				

				traza("antes del conector");
				DruidaConector conector = conectar("ConectorGuardarMatrizCodigosAlternativos", paramEnt); 								
				traza("despues del conector");

				asignarAtributo("VAR", "ejecutar", "valor", "cargarAccion('','N');");
      }//9
      
        // Agregado por SICC20070322 - Rafael Romero - 24/07/2007
        agregarMenuComplementario();
        // Fin agregado SICC20070322
      
    }catch ( Exception e ){
      traza("pincho la lp principal");
      ByteArrayOutputStream pila = new ByteArrayOutputStream();
      PrintStream out = new PrintStream(pila);
      e.printStackTrace(out);
      traza("EL STACK ES COMO SIGUE : " +  pila.toString());
      e.printStackTrace(); 
      e.getMessage();
      lanzarPaginaError(e);
    }
  }


  private DruidaConector generarConectorListEditCF(String rowsetID, RecordSet datos, Vector columns) throws DOMException, Exception{
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
      
      /*  e_campo0.setAttribute("NOMBRE","oculto");
					e_campo0.setAttribute("TIPO","OBJECTO");
					e_campo0.setAttribute("LONGITUD","50");
					Text txt = docDestino.createTextNode(String.valueOf(i));
					e_campo0.appendChild(txt);
					e_row.appendChild(e_campo0);*/

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
		traza("contenido de conectorValoresPosibles ::::::" + conectorValoresPosibles.getXML());
		return conectorValoresPosibles;
	}// Fin metodo generarConectorListEditCF

	
  private void cargarMenuSecundario() throws Exception {      
    LP = conectorParametroSesion("gLPVolver").toString();
    traza("contenido de LP:::" + LP);
   
    if(LP.equals("LPRegistrarMatrizCodigosAlternativos")) {
      traza("esta en registrar del menu");
      getConfiguracionMenu("LPMantenimientoMatrizCodigosAlternativos","registrar");
      asignarAtributoPagina("cod","0135");
    }

    if(LP.equals("LPEliminarMatrizCodigosAlternativos")){
      traza(" eliminar ::::::");
      getConfiguracionMenu("LPMantenimientoMatrizCodigosAlternativos","eliminar");
      asignarAtributoPagina("cod","0136");
    }	   
  }


	private RecordSet armarRecordSet(String elementosSeleccionados) {
    // Armo un RecordSet con los datos actuales de la lista
		RecordSet rs = new RecordSet();
         
		rs.addColumn("oids");
		rs.addColumn("codVenta");
		rs.addColumn("desc");
		rs.addColumn("nroOrden");
		rs.addColumn("emiteMen");		

		StringTokenizer st = new StringTokenizer(elementosSeleccionados,"|");

		while(st.hasMoreTokens()){	
      StringTokenizer st1 = new StringTokenizer(st.nextToken(),",");        
			rs.addRow(new Object[] {st1.nextToken(), st1.nextToken(), st1.nextToken(), st1.nextToken(), st1.nextToken()});
		}
		return rs; 
	}


	private RecordSet combinarListas(RecordSet listaVieja, RecordSet listaNueva) throws Exception {
    // Armo un RecordSet con los datos anteriores de la lista
		RecordSet rs = new RecordSet();
         
		rs.addColumn("oids");
		rs.addColumn("codVenta");
		rs.addColumn("desc");
		rs.addColumn("nroOrden");
		rs.addColumn("emiteMen");		

		for(int i=0; i < listaVieja.getRowCount(); i++){
			rs.addRow(listaVieja.getRow(i));
		}

		traza("RS: "+ rs);

		// Aniado al RecordSet los nuevos productos 
    Vector lineaNueva = null;
		Vector lineaVieja = null;
		String oid = null;
		String codVenta = null;
		String desc = null;
		boolean agregar = false;

		for(int j=0; j < listaNueva.getRowCount(); j++){
      agregar = true;
			lineaNueva = listaNueva.getRow(j);
			oid = ((Long)lineaNueva.elementAt(0)).toString();
		  codVenta = (String)lineaNueva.elementAt(1);
		  desc = (String)lineaNueva.elementAt(2);

			for(int k=0; k < listaVieja.getRowCount(); k++){
        lineaVieja = listaVieja.getRow(k);
				if(oid.equals((String)lineaVieja.elementAt(0)) && codVenta.equals((String)lineaVieja.elementAt(1)) && desc.equals((String)lineaVieja.elementAt(2))){
          agregar = false;
					break;
				}
			}

			if(agregar){
        rs.addRow(listaNueva.getRow(j));
			}
		}

    traza("RS final: " + rs);

		return rs; 
	}
    // Agregado por SICC20070322 - Rafael Romero - 24/07/2007
    private void agregarMenuComplementario() throws Exception{
        if(conectorParametroSesion("descripcionPeriodo")!=null){
            DOMXPath xform = new DOMXPath("//PAGINA/FORMULARIO[VAR[@nombre='conectorAction']]");
            Element formulario = (Element)xform.selectSingleNode(getXML());
            if(formulario != null)
            {
                DOMXPath xpath = new DOMXPath("//VAR[@nombre='SICC_CUSTOM_TITTLE']");
                Node var = (Node)xpath.selectSingleNode(getXML());
                if(var == null)
                {
                    var = getXML().createElement("VAR");
                    ((Element)var).setAttribute("nombre", "SICC_CUSTOM_TITTLE");
                }
                ((Element)var).setAttribute("valor", (String)conectorParametroSesion("descripcionPeriodo"));
                
                formulario.appendChild(var);
            }
        }
    }
    // Fin agregado SICC20070322
}
