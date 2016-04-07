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
import es.indra.druida.DruidaBase;
import es.indra.druida.dom.DruidaDOMObjeto;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.mgu.manager.Property;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.xml.XMLDocument;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.dtos.dto.DTOParametroMarca;
import es.indra.sicc.dtos.dto.DTOMatrizDescuento;
import es.indra.sicc.dtos.dto.DTODatosMatrizDescuentos;
import es.indra.sicc.dtos.dto.DTOBuscarMatricesDescuento;
import es.indra.sicc.dtos.dto.DTOParametroMatrizDescuentos;
import es.indra.sicc.dtos.dto.DTOParametroAcceso;
import es.indra.sicc.dtos.dto.DTOParametroBoolean;
import es.indra.sicc.dtos.dto.DTOParametroCanal;
import es.indra.sicc.dtos.dto.DTOParametroTipoCliente;
import es.indra.sicc.dtos.dto.DTOParametroSubacceso;
import es.indra.sicc.dtos.dto.DTOParametroNacional;
import es.indra.sicc.dtos.dto.DTOParametroTipoClasificacion;
import es.indra.sicc.dtos.dto.DTOParametroClasificacion;
import es.indra.sicc.dtos.dto.DTOParametroSubtipoCliente;
import es.indra.sicc.dtos.dto.DTOSCargarPaginaCrearMatrizDTO;
import es.indra.sicc.dtos.dto.DTOBuscarMatricesDescuento;
import org.w3c.dom.Document;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.util.Enumeration;
import java.lang.String;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class LPMantenimientoMatrizDescuentos extends LPSICCBase 
{
    DTOBelcorp dtoB = new DTOBelcorp();
    DTOBelcorp dto = new DTOBelcorp();
    RecordSet rsMarca = new RecordSet();
	 RecordSet rsCanal = new RecordSet();
    RecordSet rsAcceso = new RecordSet();    
    RecordSet rsSubAcceso = new RecordSet();
    RecordSet rsTipoCliente = new RecordSet();
	 RecordSet rsSubtipoCliente = new RecordSet();
    RecordSet rsTipoCla = new RecordSet();
	 RecordSet rsCla = new RecordSet();
    RecordSet rsMorosidad = new RecordSet();
    RecordSet rsDA = new RecordSet();
    RecordSet rsControlDesc = new RecordSet();
    RecordSet rsAfectaFactura = new RecordSet();
    RecordSet rsAfectaCC  = new RecordSet();
    RecordSet rsComunicacion = new RecordSet();
    RecordSet rsAlcance = new RecordSet();
    RecordSet rsVPDMorosidad = new RecordSet();
    RecordSet rsVPDDA = new RecordSet();
    RecordSet rsVPDControlDesc = new RecordSet();
    RecordSet rsVPDAfectaFactura = new RecordSet();
    RecordSet rsVPDAfectaCC = new RecordSet();
    RecordSet rsVPDComunicacion = new RecordSet();
	 RecordSet rsIndCul = new RecordSet();
    String id = "id";
    String desc = "descripcion";
	 String casodeuso = null;
    String accion = null;
      
      public LPMantenimientoMatrizDescuentos(){ 
            super();
      }
      
       public void inicio() throws Exception {
      }
      
      public void ejecucion() throws Exception { 
      try{
         setTrazaFichero();
         traza("Creando Accion");
         String accion = conectorParametro("accion")==null?"":conectorParametro("accion");
         String casodeuso = conectorParametro("casodeuso")==null?"":conectorParametro("casodeuso");
         traza("Accion: " + accion);
         traza("casodeuso: " + casodeuso);
         
         if (accion.equals("buscar")){
            traza("Entro por accion Buscar");
            Long atr = null;
				traza("idioma: " + UtilidadesSession.getIdioma(this).toString());
				pagina("contenido_matriz_descuento_consultar");
 			   getConfiguracionMenu("LPMantenimientoMatrizDescuentos","buscar");
				if (casodeuso.equals("eliminar"))
				   asignarAtributoPagina("cod","0333");
				if (casodeuso.equals("modificar"))
				   asignarAtributoPagina("cod","0334");
				if (casodeuso.equals("consultar"))
				   asignarAtributoPagina("cod","0237");
            anyadeHiddensI18N(true, "DTO_MATRI_DESCU", atr, new Integer(1),  "formulario", "txtDescripcion", false);
				asignarAtributo("VAR","idioma","valor",UtilidadesSession.getIdioma(this).toString());
				asignarAtributo("VAR","casoDeUso","valor",casodeuso);
         }
         if  (accion.equals("detalle")){
            traza("Entro por accion detalle");
     			Long atr = null;
				String tmpAtr= conectorParametroLimpia("hidOidMatriz","",true);
				if (!tmpAtr.equals("")){
					atr = new Long(tmpAtr);
				}
				pagina("contenido_matriz_descuento_crear");
            getConfiguracionMenu("LPMantenimientoMatrizDescuentos","detalle");            
            anyadeHiddensI18N(true, "DTO_MATRI_DESCU", atr, new Integer(1),  "formulario", "txtDescripcion", true);
				cargaPantalla();
				asignarAtributo("VAR","casoDeUso","valor","detalle");
                asignarAtributo("CAPA","capa1","visibilidad","hidden");
			   asignarAtributoPagina("cod","0237");
         }
         if (accion.equals("crear")){
            traza("Entro por accion Crear");
            pagina("contenido_matriz_descuento_crear");
            traza("Asigno la pagina");
            Long atr = null;
            getConfiguracionMenu("LPMantenimientoMatrizDescuentos","crear");        
            traza("Tras configurar menu");
            anyadeHiddensI18N(false, "DTO_MATRI_DESCU", atr, new Integer(1),  "formulario", "txtDescripcion", false);
            dtoB.setOidPais(UtilidadesSession.getPais(this));
            dtoB.setOidIdioma(UtilidadesSession.getIdioma(this));
            traza("dtoB: "+dtoB);
            cargaCombos(dtoB);
            asignarAtributo("CAPA","capa1","visibilidad","hidden");
         }
         if (accion.equals("modificar")){
            traza("en accion modificar: ");
            Long atr = null;
			String tmpAtr= conectorParametroLimpia("hidOidMatriz","",true);
				if (!tmpAtr.equals("")){
					atr = new Long(tmpAtr);
				}
            pagina("contenido_matriz_descuento_crear");
            getConfiguracionMenu("LPMantenimientoMatrizDescuentos","modificar");            
            anyadeHiddensI18N(true, "DTO_MATRI_DESCU", atr, new Integer(1),  "formulario", "txtDescripcion", false);
            asignarAtributoPagina("cod","0334");
            asignarAtributo("CAPA","capa1","visibilidad","hidden");
            cargaPantalla();
         }
         if (accion.equals("copiar")){
			traza("entro en copiar");
            pagina("contenido_matriz_descuento_copiar");
            getConfiguracionMenu("LPMantenimientoMatrizDescuentos","copiar");            
            cargaLista();
         }
         if (accion.equals("guardar")){
            pagina("contenido_matriz_descuento_crear");
            traza("Entro a la accion Guardar");
            if(guardarMatriz()){
                traza("ok");
                conectorAction("LPCrearMatrizDescuentos");
                conectorActionParametro("accion","");
				}
         }
			if (accion.equals("guardarModificacion")){
            if(guardarMatriz())	{
					traza("modificó");
				}
         }
         if (accion.equals("guardarCopia")){
            traza("entro a guardar copia");
            traza("oid: "+conectorParametro("hidOidMatriz"));
            traza("desc: "+conectorParametro("Descripcion"));            
            String oid = conectorParametro("hidOidMatriz");
            String descripc = conectorParametro("Descripcion");
            DTOMatrizDescuento dtoMd = new DTOMatrizDescuento();
            dtoMd.setOidCabeceraMatriz(new Long(oid));
            dtoMd.setOidIdioma(UtilidadesSession.getIdioma(this));
            dtoMd.setOidPais(UtilidadesSession.getPais(this));
            //dtoMd.setDescripcion(recuperaTraduccionesI18N(new Integer(1)));
				Vector vect = new Vector();
            DTOI18nSICC dtoi = new DTOI18nSICC();
            dtoi.setOidAtriuto(new Long(1));
            dtoi.setValorI18n(descripc);
            dtoi.setOidIdioma(UtilidadesSession.getIdioma(this));
            dtoi.setOidPais(UtilidadesSession.getPais(this));
			vect.add(dtoi);
			dtoMd.setDescripcion(vect);
            traza("dto: "+dtoMd);
            MareBusinessID mid2 = new MareBusinessID("DTOCopiarMatrizDescuentos");
            DruidaConector dc = new DruidaConector();
            Vector vec = new Vector();
            vec.add(dtoMd);
            vec.add(mid2);
            traza("antes de conectar copiar");
            dc = conectar("ConectorCopiarMatrizDescuentos", vec);
            traza("despues de conectar copiar");            
            pagina("contenido_matriz_descuento_copiar");
            anyadeHiddensI18N(false, "DTO_MATRI_DESCU", new Long(oid), new Integer(1),  "formulario", "Descripcion", false);
            cargaLista();
         }
			getConfiguracionMenu(); 
      }
      catch(Exception e){
         lanzarPaginaError(e);
         logStackTrace(e);
         traza("El caso de uso es: " + accion);
         if ((accion.equals("modificar")) || (accion.equals("guardar")) || (accion.equals("guardarCopia")))
            preservaHiddensI18n(new Integer(1), "DTO_MATRI_DESCU", "formulario", "Descripcion", false);
			}
      } 

      private void cargaCombos(DTOBelcorp dtoBelcorp) throws Exception{
        traza("entrando a cargaCombos");
        DruidaConector conCarga = null;
        Vector paraVec = new Vector();
        paraVec.add(dtoBelcorp);
        paraVec.add(new MareBusinessID("DTOCargarPaginaCrearMatrizDTO"));
        traza("conecta.....?");
        conCarga = conectar("ConectorCargarPaginaCrearMatrizDTO",paraVec);
        traza("conectó");
        DTOSCargarPaginaCrearMatrizDTO dtoSalida =(DTOSCargarPaginaCrearMatrizDTO)conCarga.objeto("dtoSalida");

		  RecordSet rs =dtoSalida.getParametros();
		  RecordSet rsSorted = sort(rs);

        StringBuffer st = new StringBuffer();
        int lon = rsSorted.getRowCount();
        for (int i = 0 ;i < lon ;i++ )  {
            st.append(rsSorted.getValueAt(i,0));
            st.append(",");
            st.append(rsSorted.getValueAt(i,3));
            st.append(",");
traza("Parametro....: "+rsSorted.getValueAt(i,2) + "   Valor: " + rsSorted.getValueAt(i,3));
        }
        if (st.length() >1){
			StringBuffer subcadena = st;
			traza(st);
			asignarAtributo("VAR","parametros","valor",st.substring(0,subcadena.length()- 1));
        }    

        Vector vecMarca = dtoSalida.getMarca().getColumnIdentifiers();
        int numColMarca       = dtoSalida.getMarca().getColumnCount();
        DruidaConector marca       = generarConector("DTOSalida.resultado_ROWSET",dtoSalida.getMarca(),vecMarca);
        asignar("COMBO","cbValoresPosiblesMarca",marca,"DTOSalida.resultado_ROWSET");                                                

        Vector vecCanal = dtoSalida.getCanal().getColumnIdentifiers();
        int numColCanal       = dtoSalida.getCanal().getColumnCount();
		  RecordSet rsC = dtoSalida.getCanal();
        DruidaConector canal       = generarConector("DTOSalida.resultado_ROWSET",rsC,vecCanal);
        asignar("COMBO","cbValoresPosiblesCanal",canal,"DTOSalida.resultado_ROWSET");                                                

			RecordSet rec = dtoSalida.getTipoCliente();
			rec.addColumn("porDef");
			int size = rec.getRowCount();
			for (int i =0;i < size;i++ ){
				rec.setValueAt("0",i,2);
			}
        Vector vectipoCliente = rec.getColumnIdentifiers();
        int numColtipoCliente       = rec.getColumnCount();
        DruidaConector tipoCliente       = generarConector("DTOSalida.resultado_ROWSET",rec,vectipoCliente);
        asignar("COMBO","cbValoresPosiblesTipoCliente",tipoCliente,"DTOSalida.resultado_ROWSET");   
        recargaCombos(dtoSalida);        
      }

      public void  cargaPantalla() throws Exception {
      
      
      try {
            DTOOID dtoMat = new DTOOID();        
            Long oidcabe = new Long (conectorParametro("hidOidMatriz").toString());
            asignarAtributo("VAR","hidOidMatriz","valor",oidcabe.toString());
			   accion = conectorParametroLimpia("accion","",true);
            dtoMat.setOid(oidcabe);
            dtoMat.setOidIdioma(UtilidadesSession.getIdioma(this));
            dtoMat.setOidPais(UtilidadesSession.getPais(this));
				StringBuffer selPorDef = new StringBuffer();
            Vector paramEntrada = new Vector();
          	DruidaConector conector = null;
            MareBusinessID midi = new MareBusinessID("DTOConsultarMatrizDescuentos");
            paramEntrada.add(dtoMat);
            paramEntrada.add(midi);
            traza("antes de conectar");
      		conector = conectar("ConectorConsultarMatrizDescuentos", paramEntrada);
          	traza("despues de conectar");
            DTODatosMatrizDescuentos dtoD = (DTODatosMatrizDescuentos)conector.objeto("dtoSalida");
				Vector vec = dtoD.getDescripcion();
				Iterator desc = vec.iterator();

            while(desc.hasNext()){
                DTOI18nSICC dto = (DTOI18nSICC)desc.next();
                if (dto.getOidIdioma().equals(UtilidadesSession.getIdioma(this)))
                    asignarAtributo("CTEXTO","txtDescripcion","valor",dto.getValorI18n().toString());
            }
				if(dtoD.getObservaciones()!=null)
	              asignarAtributo("AREATEXTO","atxtObservaciones","valor",dtoD.getObservaciones().toString());
				if(dtoD.getMatrizActiva()!=null){
						if(dtoD.getMatrizActiva().booleanValue())
							 asignarAtributo("VAR","radio","valor","S");
						else asignarAtributo("VAR","radio","valor","N");
				}
             Iterator iterador = dtoD.getListaParametros().iterator();

            while (iterador.hasNext()){
                DTOParametroMatrizDescuentos dtoP = (DTOParametroMatrizDescuentos)iterador.next();
                String param = dtoP.getOidParametro().toString();
                int para = Integer.parseInt(param);
                switch (para){
                    case 2:
                    {
							   traza("entro al 2");
								//asignarAtributo("CHECKBOX","ckVisibleIndicador","check",obtenerValor(dtoP.getVisible()));
                                //asignarAtributo("CHECKBOX","ckObligatorioIndicador","check",obtenerValor(dtoP.getObligatorio()));
								//asignarAtributo("CHECKBOX","ckModificableIndicador","check",obtenerValor(dtoP.getModificable()));
                                
                                asignarAtributo("CHECKBOX","ckVisibleIndicadorCulminacion","check",obtenerValor(dtoP.getVisible()));
							    asignarAtributo("CHECKBOX","ckObligatorioIndicadorCulminacion","check",obtenerValor(dtoP.getObligatorio()));
								asignarAtributo("CHECKBOX","ckModificableIndicadorCulminacion","check",obtenerValor(dtoP.getModificable()));
                        ArrayList arrIndCul = dtoP.getListaValoresPosibles();
                        Iterator itIndCul = arrIndCul.iterator();
                        StringBuffer st = new StringBuffer();
                        rsIndCul.addColumn("ID");
                        rsIndCul.addColumn("Descripcion");                            
                        rsIndCul.addColumn("porDef");                            
                        while (itIndCul.hasNext()){
                          DTOParametroBoolean dtoB = (DTOParametroBoolean)itIndCul.next();
                          traza("dtoB: "+dtoB);
                          st.append(dtoB.getValor());
                          st.append(",");                                     
                          if ((dtoB.getOid()!= null) && (dtoB.getValor()!=null)){
                            Vector vect = new Vector();
                            
                            //incidencia 23078
                            //agregado jsilva--------------------------
                            if (accion.equalsIgnoreCase("detalle") ){
                              traza("****JAS****entro por detalle");
                              vect.add (devolverOid (dtoB.getValor().toString() ) );
                            }else{
                              if (accion.equalsIgnoreCase("modificar") ){
                                traza("****JAS****entro por modificar");
                                vect.add(dtoB.getOid());
                              }
                            }
                            //agregado jsilva--------------------------
                            
                            if (dtoB.getValor().toString().equals("true"))
                              vect.add("Si");
													 else vect.add("No");
                            if (dtoB.getValorPorDefecto().booleanValue())
                              vect.add("s");
                            else vect.add("n");
                            traza("****JAS****El vector a agregar es: " + vect.toString());
                            rsIndCul.addRow(vect);
									 }
                        }
								traza("recordset: "+rsIndCul);
                        Vector colIDIndCul   =   rsIndCul.getColumnIdentifiers();
                        int numColIndCul            = rsIndCul.getColumnCount();
                        DruidaConector indCul       = generarConector("DTOSalida.resultado_ROWSET",rsIndCul,colIDIndCul);
								if (accion.equals("detalle"))
								asignar("COMBO","cbValoresPosiblesIndicadorCulminacion",indCul,"DTOSalida.resultado_ROWSET");                                                
                        asignar("COMBO","cbValoresDefectoIndicadorCulminacion",indCul,"DTOSalida.resultado_ROWSET");                                                
								if (st.length() >1){
                                StringBuffer cadena = st;
										  asignarAtributo("VAR","selIndicadorCulminacion","valor",st.substring(0,cadena.length()- 1));
                         }
                    }
                    break;
                    
                    
                    case 3:
                    {
							  traza("entro al 3");
								asignarAtributo("CHECKBOX","ckVisibleMarca","check",obtenerValor(dtoP.getVisible()));
                        asignarAtributo("CHECKBOX","ckObligatorioMarca","check",obtenerValor(dtoP.getObligatorio()));
                        asignarAtributo("CHECKBOX","ckModificableMarca","check",obtenerValor(dtoP.getModificable()));
                        ArrayList arrMarca = dtoP.getListaValoresPosibles();
                        Iterator itMarca = arrMarca.iterator();
								StringBuffer st = new StringBuffer();
								 rsMarca.addColumn("ID");
                         rsMarca.addColumn("Descripcion");
                         rsMarca.addColumn("porDef");
                        while (itMarca.hasNext() ){
                            DTOParametroMarca dtoM = (DTOParametroMarca)itMarca.next();
									 traza("dto: " + dtoM);
									 st.append(dtoM.getOidMarca());
									 st.append(",");
									 if ((dtoM.getOidMarca()!= null) && (dtoM.getDescripcion()!=null)){
		 								 Vector vect = new Vector();
                                vect.add(dtoM.getOidMarca());
                                vect.add(dtoM.getDescripcion());
										  if (dtoM.getValorPorDefecto().booleanValue())
											            vect.add("s");
												else   vect.add("n"); 
										  rsMarca.addRow(vect);
										}
                        }
								if (rsMarca.getRowCount() > 0){
										traza("recordset: "+rsMarca);
										Vector vecMarca             = rsMarca.getColumnIdentifiers();								
										int numColMarca              = rsMarca.getColumnCount();
										DruidaConector marca       = generarConector("DTOSalida.resultado_ROWSET",rsMarca,vecMarca);
								if (accion.equals("detalle"))
										asignar("COMBO","cbValoresPosiblesMarca",marca,"DTOSalida.resultado_ROWSET");
										asignar("COMBO","cbValoresDefectoMarca",marca,"DTOSalida.resultado_ROWSET");
								}
								if (st.length() >1){
										StringBuffer subcadena = st;
										asignarAtributo("VAR","selMarca","valor",st.substring(0,subcadena.length()- 1));
								}
                    }
                    break;

                    case 4:
                    {
							  traza("entro al 4");
                        asignarAtributo("CHECKBOX","ckVisibleCanal","check",obtenerValor(dtoP.getVisible()));
                        asignarAtributo("CHECKBOX","ckObligatorioCanal","check",obtenerValor(dtoP.getObligatorio()));
                        asignarAtributo("CHECKBOX","ckModificableCanal","check",obtenerValor(dtoP.getModificable()));
                        ArrayList arrCanal = dtoP.getListaValoresPosibles();
                        Iterator itCanal = arrCanal.iterator();
								StringBuffer st = new StringBuffer();
								 rsCanal.addColumn("ID");
                         rsCanal.addColumn("Descripcion");
                         rsCanal.addColumn("porDef");
                        while (itCanal.hasNext()){
                            DTOParametroCanal dtoC = (DTOParametroCanal)itCanal.next();
									 traza("dto: " + dtoC);
									 st.append(dtoC.getOidCanal());
									 st.append(",");
	 								 Vector vect = new Vector();
                            vect.add(dtoC.getOidCanal());
                             vect.add(dtoC.getDescripcion());
									  if (dtoC.getValorPorDefecto().booleanValue())
										            vect.add("s");
											else   vect.add("n"); 
									  rsCanal.addRow(vect);
								}
								if (rsCanal.getRowCount() > 0){
										traza("recordset: "+rsCanal);
										Vector vecCanal             = rsCanal.getColumnIdentifiers();								
										int numColCanal              = rsCanal.getColumnCount();
										DruidaConector canal       = generarConector("DTOSalida.resultado_ROWSET",rsCanal,vecCanal);
								if (accion.equals("detalle"))								
										asignar("COMBO","cbValoresPosiblesCanal",canal,"DTOSalida.resultado_ROWSET");
										asignar("COMBO","cbValoresDefectoCanal",canal,"DTOSalida.resultado_ROWSET");
								}
								if (st.length() >1){
										StringBuffer subcadena = st;
										asignarAtributo("VAR","selCanal","valor",st.substring(0,subcadena.length()- 1));
								}
                    }
                    break;

                    case 5:
                    {
							  traza("entro al 5");
                        asignarAtributo("CHECKBOX","ckVisibleAcceso","check",obtenerValor(dtoP.getVisible()));
                        asignarAtributo("CHECKBOX","ckObligatorioAcceso","check",obtenerValor(dtoP.getObligatorio()));
                        asignarAtributo("CHECKBOX","ckModificableAcceso","check",obtenerValor(dtoP.getModificable()));
								if (dtoP.getNumeroMaximoValores()!=null)
                        asignarAtributo("CTEXTO","txtNumMaxValoresAcceso","valor",dtoP.getNumeroMaximoValores().toString());  
                        ArrayList arrAcceso = dtoP.getListaValoresPosibles();
                        Iterator itAcceso = arrAcceso.iterator();
								StringBuffer st = new StringBuffer();
								rsAcceso.addColumn("ID");
                         rsAcceso.addColumn("Descripcion");
                         rsAcceso.addColumn("porDef");
                        while (itAcceso.hasNext()){
                             DTOParametroAcceso dtoA = (DTOParametroAcceso)itAcceso.next();
										st.append(dtoA.getOidAcceso());
									  st.append(",");
									  Vector vect = new Vector();
                             vect.add(dtoA.getOidAcceso());
                             vect.add(dtoA.getDescripcion());
                             if (dtoA.getValorPorDefecto().booleanValue())
										         vect.add("s");
										 else  vect.add("n");
                             rsAcceso.addRow(vect);									  
                        }
								if (rsAcceso.getRowCount() > 0){
										traza("recordset: "+rsAcceso);
										Vector colIDAcceso = rsAcceso.getColumnIdentifiers();
										int numColAcceso            = rsAcceso.getColumnCount();
										DruidaConector acceso       = generarConector("DTOSalida.resultado_ROWSET",rsAcceso,colIDAcceso);
								if (accion.equals("detalle"))								
										asignar("COMBO","cbValoresPosiblesAcceso",acceso,"DTOSalida.resultado_ROWSET");
										asignar("COMBO","cbValoresDefectoAcceso",acceso,"DTOSalida.resultado_ROWSET");
								}
								if (st.length() >1){
										StringBuffer subcadena = st;
										asignarAtributo("VAR","selAcceso","valor",st.substring(0,subcadena.length()- 1));
								}
                    }
                    break;

                    case 6:
                    {
							  traza("entro al 6");
                        asignarAtributo("CHECKBOX","ckVisibleSubacceso","check",obtenerValor(dtoP.getVisible()));
                        asignarAtributo("CHECKBOX","ckObligatorioSubacceso","check",obtenerValor(dtoP.getObligatorio()));
                        asignarAtributo("CHECKBOX","ckModificableSubacceso","check",obtenerValor(dtoP.getModificable()));
								if (dtoP.getNumeroMaximoValores()!=null)
		                        asignarAtributo("CTEXTO","txtNumMaxSubacceso","valor",dtoP.getNumeroMaximoValores().toString());  
                        ArrayList arrsubAcceso = dtoP.getListaValoresPosibles();
                        Iterator itsubAcceso = arrsubAcceso.iterator();
								StringBuffer st = new StringBuffer();
								rsSubAcceso.addColumn("ID");
                        rsSubAcceso.addColumn("Descripcion");
                        rsSubAcceso.addColumn("porDef");
								traza("antes while");
                        while (itsubAcceso.hasNext()){
									traza("while");
                            DTOParametroSubacceso dtoS = (DTOParametroSubacceso)itsubAcceso.next();
									 st.append(dtoS.getOidSubacceso());
									 st.append(",");
									 traza("dto: "+dtoS);
									 Vector vect = new Vector();
                            vect.add(dtoS.getOidSubacceso());
                            vect.add(dtoS.getDescripcionSubacceso());
                            if (dtoS.getValorPorDefecto().booleanValue())
										         vect.add("s");
										else    vect.add("n");
                             rsSubAcceso.addRow(vect);                                
                        }
								if (rsSubAcceso.getRowCount() > 0){
										traza("recordset: "+rsSubAcceso);
										Vector colIDSubAcceso =  rsSubAcceso.getColumnIdentifiers();
										int numColSubAcceso            = rsSubAcceso.getColumnCount();
										DruidaConector subacceso       = generarConector("DTOSalida.resultado_ROWSET",rsSubAcceso,colIDSubAcceso);
								if (accion.equals("detalle"))
										asignar("COMBO","cbValoresPosiblesSubacceso",subacceso,"DTOSalida.resultado_ROWSET");                        
										asignar("COMBO","cbValoresDefectoSubacceso",subacceso,"DTOSalida.resultado_ROWSET");                        
								}
								if (st.length() >1){
										StringBuffer subcadena = st;
										asignarAtributo("VAR","selSubacceso","valor",st.substring(0,subcadena.length()- 1));
								}
						  }
                    break;

                    case 7:
                    {   
							  traza("entro al 7");
                        asignarAtributo("CHECKBOX","ckVisibleVigenciaPeriodoInicial","check",obtenerValor(dtoP.getVisible()));
                        asignarAtributo("CHECKBOX","ckObligatorioVigenciaPeriodoInicial","check",obtenerValor(dtoP.getObligatorio()));
                        asignarAtributo("CHECKBOX","ckModificableVigenciaPeriodoInicial","check",obtenerValor(dtoP.getModificable()));
                    }
                    break;

                    case 8:
                    {
							  traza("entro al 8");
                        asignarAtributo("CHECKBOX","ckVisibleVigenciaPeriodoFinal","check",obtenerValor(dtoP.getVisible()));
                        asignarAtributo("CHECKBOX","ckObligatorioVigenciaPeriodoFinal","check",obtenerValor(dtoP.getObligatorio()));
                        asignarAtributo("CHECKBOX","ckModificableVigenciaPeriodoFinal","check",obtenerValor(dtoP.getModificable()));
                    }
                    break;

                    case 9:
                    {
							  traza("entro al 9");
                        asignarAtributo("CHECKBOX","ckVisibleTipoCliente","check",obtenerValor(dtoP.getVisible()));
                        asignarAtributo("CHECKBOX","ckObligatorioTipoCliente","check",obtenerValor(dtoP.getObligatorio()));
                        asignarAtributo("CHECKBOX","ckModificableTipoCliente","check",obtenerValor(dtoP.getModificable()));
								if (dtoP.getNumeroMaximoValores()!=null)
                        asignarAtributo("CTEXTO","txtNumMaxTipoCliente","valor",dtoP.getNumeroMaximoValores().toString());                          
                        ArrayList arrtCliente = dtoP.getListaValoresPosibles();
                        ArrayList arrSubtipoCliente = dtoP.getListaValoresPosibles2();
                        Iterator ittCliente = arrtCliente.iterator();
                        Iterator itstCliente = arrSubtipoCliente.iterator();
								StringBuffer st = new StringBuffer();
								StringBuffer st2 = new StringBuffer();
								//tipo cliente
                        rsTipoCliente.addColumn("ID");
                        rsTipoCliente.addColumn("Descripcion");
                         rsTipoCliente.addColumn("porDef");
								while (ittCliente.hasNext()){
                            DTOParametroTipoCliente dtoTC = (DTOParametroTipoCliente)ittCliente.next();
									 st.append(dtoTC.getOidTipoCliente());
									 st.append(",");
									Vector vect = new Vector();
                           vect.add(dtoTC.getOidTipoCliente());
                           vect.add(dtoTC.getDescripcion());
                           if (dtoTC.getValorPorDefecto().booleanValue())
										         vect.add("s");
										 else   vect.add("n");
                            rsTipoCliente.addRow(vect);
                        }
								//subtipo cliente
								rsSubtipoCliente.addColumn("ID");
                        rsSubtipoCliente.addColumn("Descripcion");
                        rsSubtipoCliente.addColumn("porDef");
								while (itstCliente.hasNext()){
                            DTOParametroSubtipoCliente dtoSTC = (DTOParametroSubtipoCliente)itstCliente.next();
									 st2.append(dtoSTC.getOidSubtipoCliente());
									 st2.append(",");
									 Vector vect = new Vector();
                            vect.add(dtoSTC.getOidSubtipoCliente());
                            vect.add(dtoSTC.getDescripcion());
                            if (dtoSTC.getValorPorDefecto().booleanValue())
										         vect.add("s");
										 else   vect.add("n");
                            rsSubtipoCliente.addRow(vect);
                        }
								if (rsTipoCliente.getRowCount() > 0){
										traza("recordset: "+rsTipoCliente);
										Vector colIDTipoCliente  = rsTipoCliente.getColumnIdentifiers();
										int numColTipoCliente            = rsTipoCliente.getColumnCount();
										DruidaConector tipocliente       = generarConector("DTOSalida.resultado_ROWSET",rsTipoCliente,colIDTipoCliente);
								if (accion.equals("detalle"))								
										asignar("COMBO","cbValoresPosiblesTipoCliente",tipocliente,"DTOSalida.resultado_ROWSET");                                                
										asignar("COMBO","cbValoresDefectoTipoCliente",tipocliente,"DTOSalida.resultado_ROWSET");                                                
								}
								if (rsSubtipoCliente.getRowCount() > 0)	{
										traza("recordset: "+rsSubtipoCliente);
										Vector colID  = rsSubtipoCliente.getColumnIdentifiers();
										int numCol            = rsSubtipoCliente.getColumnCount();
										DruidaConector subtipocliente       = generarConector("DTOSalida.resultado_ROWSET",rsSubtipoCliente,colID);
								if (accion.equals("detalle"))
										asignar("COMBO","cbValoresPosiblesSubtipoCliente",subtipocliente,"DTOSalida.resultado_ROWSET");                                                
										asignar("COMBO","cbValoresDefectoSubtipoCliente",subtipocliente,"DTOSalida.resultado_ROWSET");                                                
								}
								if (st.length() >1){
										StringBuffer subcadena = st;
										StringBuffer subcadena2 = st2;
										asignarAtributo("VAR","selTipoCliente","valor",st.substring(0,subcadena.length()- 1));
										asignarAtributo("VAR","selSubtipoCliente","valor",st2.substring(0,subcadena2.length()- 1));
								}
						  }
                    break;

                    case 10:
                    {
							  traza("entro al 10");
                        asignarAtributo("CHECKBOX","ckVisiblePorcentajeAdicionalLineaCarrera","check",obtenerValor(dtoP.getVisible()));
                        asignarAtributo("CHECKBOX","ckObligatorioPorcentajeAdicionalLineaCarrera","check",obtenerValor(dtoP.getObligatorio()));
                        asignarAtributo("CHECKBOX","ckModificablePorcentajeAdicionalLineaCarrera","check",obtenerValor(dtoP.getModificable()));
                        ArrayList arrtPorcentaje = dtoP.getListaValoresPosibles();
								ArrayList arrtPorcentaje2 = dtoP.getListaValoresPosibles2();
                        Iterator itPorcentaje = arrtPorcentaje.iterator();
								Iterator itPorcentaje2 = arrtPorcentaje2.iterator();
								StringBuffer st = new StringBuffer();
								StringBuffer st2 = new StringBuffer();
								//tipo clasificacion
								 rsTipoCla.addColumn("ID");
                         rsTipoCla.addColumn("Descripcion");
                         rsTipoCla.addColumn("porDef");
                        while (itPorcentaje.hasNext()){
                            DTOParametroTipoClasificacion dtotClas = (DTOParametroTipoClasificacion)itPorcentaje.next();
									 st.append(dtotClas.getOidTipoClasificacion());
									 st.append(",");
									 traza("dto: "+dtotClas);
									 if ((dtotClas.getOidTipoClasificacion()!= null) && (dtotClas.getDescripcionTipoClasificacion()!=null)){
                                  Vector vect = new Vector();
                                  vect.add(dtotClas.getOidTipoClasificacion());
                                  vect.add(dtotClas.getDescripcionTipoClasificacion());
											 if (dtotClas.getValorPorDefecto().booleanValue())
													  vect.add("s");
											 else vect.add("n");
                                  rsTipoCla.addRow(vect);
											}
                        }
								//clasificacion
								 rsCla.addColumn("ID");
                         rsCla.addColumn("Descripcion");
                         rsCla.addColumn("porDef");
                        while (itPorcentaje2.hasNext()){
                            DTOParametroClasificacion dtoClas = (DTOParametroClasificacion)itPorcentaje2.next();
									 st2.append(dtoClas.getOidClasificacion());
									 st2.append(",");
									 traza("dto: "+dtoClas);
									 if ((dtoClas.getOidClasificacion()!= null) && (dtoClas.getDescripcionClasificacion()!=null))	{
                                  Vector vect = new Vector();
                                  vect.add(dtoClas.getOidClasificacion());
                                  vect.add(dtoClas.getDescripcionClasificacion());
											 if (dtoClas.getValorPorDefecto().booleanValue())
													  vect.add("s");
											 else vect.add("n");
                                  rsCla.addRow(vect);
											}
                        }
								if (rsTipoCla.getRowCount() > 0){
											traza("recordset: "+rsTipoCla);
											Vector colIDTipoCla   =   rsTipoCla.getColumnIdentifiers();
											int numColTipoCla            = rsTipoCla.getColumnCount();
											DruidaConector tipocla       = generarConector("DTOSalida.resultado_ROWSET",rsTipoCla,colIDTipoCla);
								if (accion.equals("detalle"))
											asignar("COMBO","cbValoresPosiblesTipoClasificacion",tipocla,"DTOSalida.resultado_ROWSET");                                                
											asignar("COMBO","cbValoresDefectoTipoClasificacion",tipocla,"DTOSalida.resultado_ROWSET");                                                
								}
								if (rsCla.getRowCount() > 0){
											traza("recordset: "+rsCla);
											Vector colIDCla   =   rsCla.getColumnIdentifiers();
											int numColCla            = rsCla.getColumnCount();
											DruidaConector cla       = generarConector("DTOSalida.resultado_ROWSET",rsCla,colIDCla);
								if (accion.equals("detalle"))
											asignar("COMBO","cbValoresPosiblesClasificacion",cla,"DTOSalida.resultado_ROWSET");                                                
											asignar("COMBO","cbValoresDefectoClasificacion",cla,"DTOSalida.resultado_ROWSET");                                                
								}
								if (st.length() >1){
										StringBuffer subcadena = st;
										StringBuffer subcadena2 = st2;                            
										asignarAtributo("VAR","selTipoClasificacion","valor",st.substring(0,subcadena.length()- 1));
										asignarAtributo("VAR","selClasificacion","valor",st2.substring(0,subcadena2.length()- 1));
								}
                    }
                    break;
 
                    case 11:
                    {
							  traza("entro al 11");
                        asignarAtributo("CHECKBOX","ckVisibleDescuentosCliente","check",obtenerValor(dtoP.getVisible()));
                        asignarAtributo("CHECKBOX","ckObligatorioDescuentosCliente","check",obtenerValor(dtoP.getObligatorio()));
                        asignarAtributo("CHECKBOX","ckModificableDescuentosCliente","check",obtenerValor(dtoP.getModificable()));
                    }
                    break;

                    case 12:
                    {
							  traza("entro al 12");
                        asignarAtributo("CHECKBOX","ckVisibleAlcanceAdministrativoDescuento","check",obtenerValor(dtoP.getVisible()));
                        asignarAtributo("CHECKBOX","ckObligatorioAlcanceAdministrativoDescuento","check",obtenerValor(dtoP.getObligatorio()));
                        asignarAtributo("CHECKBOX","ckModificableAlcanceAdministrativoDescuento","check",obtenerValor(dtoP.getModificable()));
                        Iterator itAlcance = dtoP.getListaValoresPosibles().iterator();
                        StringBuffer st = new StringBuffer();
                        rsAlcance.addColumn("ID");
                        rsAlcance.addColumn("Descripcion");
                        rsAlcance.addColumn("porDef");
                        while(itAlcance.hasNext()){
                          DTOParametroNacional dtoN = (DTOParametroNacional) itAlcance.next();
                          traza("dtoB: "+dtoN);
                          st.append(dtoN.getValor());
                          st.append(",");
                          Vector vect = new Vector();
                        
                          //agregado jsilva----------------------
                          traza("accion tiene: " + accion);
                          traza("dtoN.getValor().toString() tiene: " + dtoN.getValor().toString() );
                          
                          if (accion.equalsIgnoreCase("detalle") ){
                            traza("entro por detalle");
                            if (dtoN.getValor().toString().equalsIgnoreCase("Nacional") ){
                              traza("entro por Nacional");
                              vect.add(new Long(1));
                            }else{
                              if (dtoN.getValor().toString().equalsIgnoreCase("No nacional")){
                                traza("entro por No nacional");
                                vect.add(new Long(2));
                              }
                            }
                          }else{
                            if (accion.equalsIgnoreCase("modificar") ){
                              traza("entro por modificar");
                              vect.add(dtoN.getOid());
                            }
                          }
                          //agregado jsilva-----------------------
                      
                          vect.add(dtoN.getValor());
                          if (dtoN.getValorPorDefecto().booleanValue())
                            vect.add("s");
                          else vect.add("n");
                          traza("****JAS****El vector a agregar es: " + vect.toString());
                          rsAlcance.addRow(vect);
                        }
                         
								 if (rsAlcance.getRowCount() > 0){
										 traza("recordset: "+rsAlcance);
										 Vector colIDAlcance    =  rsAlcance.getColumnIdentifiers();
										 int numColAlcance            = rsAlcance.getColumnCount();
										 DruidaConector alcance       = generarConector("DTOSalida.resultado_ROWSET",rsAlcance,colIDAlcance);
                     traza("****JAS**** alcance a asignar a los combos: " + alcance.toString());
								if (accion.equals("detalle"))								
										 asignar("COMBO","cbValoresPosiblesAlcanceAdministrativoDescuento",alcance,"DTOSalida.resultado_ROWSET");                                                
										 asignar("COMBO","cbValoresDefectoAlcanceAdministrativoDescuento",alcance,"DTOSalida.resultado_ROWSET");                                                
								 }
								 if (st.length() >1){
									 StringBuffer cadena = st;
                   asignarAtributo("VAR","selAlcanceAdministrativoDescuento","valor",st.substring(0,cadena.length()- 1));
                   traza("****JAS****se asigna a selAlcanceAdministrativoDescuento: " + st.substring(0,cadena.length()- 1));
								}
                    }
                    break;

                    case 13:
                    {
							  traza("entro al 13");
                        asignarAtributo("CHECKBOX","ckVisiblePorcentajeAdicionalAlcanceAdministrativo","check",obtenerValor(dtoP.getVisible()));
                        asignarAtributo("CHECKBOX","ckObligatorioPorcentajeAdicionalAlcanceAdministrativo","check",obtenerValor(dtoP.getObligatorio()));
                        asignarAtributo("CHECKBOX","ckModificablePorcentajeAdicionalAlcanceAdministrativo","check",obtenerValor(dtoP.getModificable()));
                    }
                    break;

                    case 14:
                    {
							  traza("entro al 14");
                        asignarAtributo("CHECKBOX","ckVisibleBaseCalculoDescuentoMarca","check",obtenerValor(dtoP.getVisible()));
                        asignarAtributo("CHECKBOX","ckObligatorioBaseCalculoDescuentoMarca","check",obtenerValor(dtoP.getObligatorio()));
                        asignarAtributo("CHECKBOX","ckModificableBaseCalculoDescuentoMarca","check",obtenerValor(dtoP.getModificable()));
                    }
                    break;

                    case 15:
                    {
							  traza("entro al 15");
                       asignarAtributo("CHECKBOX","ckVisibleBaseCalculoDescuentoUnidadNegocio","check",obtenerValor(dtoP.getVisible()));
                       asignarAtributo("CHECKBOX","ckObligatorioBaseCalculoDescuentoUnidadNegocio","check",obtenerValor(dtoP.getObligatorio()));
                       asignarAtributo("CHECKBOX","ckModificableBaseCalculoDUnidadNegocio","check",obtenerValor(dtoP.getModificable()));
                    }
                    break;

                    case 16: 
						  {
							  traza("entro al 16");
                        asignarAtributo("CHECKBOX","ckVisibleBaseCalculoDescuentoNegocio","check",obtenerValor(dtoP.getVisible()));
                        asignarAtributo("CHECKBOX","ckObligatorioBaseCalculoDescuentoNegocio","check",obtenerValor(dtoP.getObligatorio()));
                        asignarAtributo("CHECKBOX","ckModificableBaseCalculoDescuentoNegocio","check",obtenerValor(dtoP.getModificable()));
                    }
                    break;

                    case 17:
                    {
							  traza("entro al 17");
                        asignarAtributo("CHECKBOX","ckVisibleBaseCalculoDescuentoSupergenerico","check",obtenerValor(dtoP.getVisible()));
                        asignarAtributo("CHECKBOX","ckObligatorioBaseCalculoDescuentoSupergenerico","check",obtenerValor(dtoP.getObligatorio()));
                        asignarAtributo("CHECKBOX","ckModificableBaseCalculoDescuentoSupergenerico","check",obtenerValor(dtoP.getModificable()));
                    }
                    break;

                    case 18:
                    {
  							  traza("entro al 18");
                        asignarAtributo("CHECKBOX","ckVisibleBaseCalculoDescuentoGenerico","check",obtenerValor(dtoP.getVisible()));
                        asignarAtributo("CHECKBOX","ckObligatorioBaseCalculoDescuentoGenerico","check",obtenerValor(dtoP.getObligatorio()));
                        asignarAtributo("CHECKBOX","ckModificableBaseCalculoDescuentoGenerico","check",obtenerValor(dtoP.getModificable()));
                    }
                    break;

                    case 19:
                    {
 							  traza("entro al 19");
							  asignarAtributo("CHECKBOX","ckVisibleBaseCalculoDescuentoProducto","check",obtenerValor(dtoP.getVisible()));
                       asignarAtributo("CHECKBOX","ckObligatorioBaseCalculoDescuentoProducto","check",obtenerValor(dtoP.getObligatorio()));
                       asignarAtributo("CHECKBOX","ckModificableBaseCalculoDescuentoProducto","check",obtenerValor(dtoP.getModificable()));
                    }
                    break;

                    case 20:
                    {
							  traza("entro al 20");
                       asignarAtributo("CHECKBOX","ckVisibleBaseAplicacionDescuentoMarca","check",obtenerValor(dtoP.getVisible()));
                       asignarAtributo("CHECKBOX","ckObligatorioBaseAplicacionDescuentoMarca","check",obtenerValor(dtoP.getObligatorio()));
                       asignarAtributo("CHECKBOX","ckModificableBaseAplicacionDescuentoMarca","check",obtenerValor(dtoP.getModificable()));
                    }
                    break;
                    
                    case 21:
                    {
							  traza("entro al 21");
                       asignarAtributo("CHECKBOX","ckVisibleBaseAplicacionDescuentoUnidadNegocio","check",obtenerValor(dtoP.getVisible()));
                       asignarAtributo("CHECKBOX","ckObligatorioBaseAplicacionDescuentoUnidadNegocio","check",obtenerValor(dtoP.getObligatorio()));
                       asignarAtributo("CHECKBOX","ckModificableBaseAplicacionDescuentoUnidadNegocio","check",obtenerValor(dtoP.getModificable()));
                    }
                    break;

                    case 22:
                    {
							  traza("entro al 22");
                       asignarAtributo("CHECKBOX","ckVisibleBaseAplicacionDescuentoNegocio","check",obtenerValor(dtoP.getVisible()));
                       asignarAtributo("CHECKBOX","ckObligatorioBaseAplicacionDescuentoNegocio","check",obtenerValor(dtoP.getObligatorio()));
                       asignarAtributo("CHECKBOX","ckModificableBaseAplicacionDescuentoNegocio","check",obtenerValor(dtoP.getModificable()));
                    }
                    break;

                    case 23:
                    {
							  traza("entro al 23");
                       asignarAtributo("CHECKBOX","ckVisibleBaseAplicacionDescuentoSupergenerico","check",obtenerValor(dtoP.getVisible()));
                       asignarAtributo("CHECKBOX","ckObligatorioBaseAplicacionDescuentoSupergenerico","check",obtenerValor(dtoP.getObligatorio()));
                       asignarAtributo("CHECKBOX","ckModificableBaseAplicacionDescuentoSupergenerico","check",obtenerValor(dtoP.getModificable()));
                    }
                    break;

                    case 24:
                    {
							  traza("entro al 24");
                       asignarAtributo("CHECKBOX","ckVisibleBaseAplicacionDescuentoGenerico","check",obtenerValor(dtoP.getVisible()));
                       asignarAtributo("CHECKBOX","ckObligatorioBaseAplicacionDescuentoGenerico","check",obtenerValor(dtoP.getObligatorio()));
                       asignarAtributo("CHECKBOX","ckModificableBaseAplicacionDescuentoGenerico","check",obtenerValor(dtoP.getModificable()));
                    }
                    break;

                    case 25:
                    {
							  traza("entro al 25");
                       asignarAtributo("CHECKBOX","ckVisibleBaseAplicacionDescuentoProducto","check",obtenerValor(dtoP.getVisible()));
                       asignarAtributo("CHECKBOX","ckObligatorioBaseAplicacionDescuentoProducto","check",obtenerValor(dtoP.getObligatorio()));
                       asignarAtributo("CHECKBOX","ckModificableBaseAplicacionDescuentoProducto","check",obtenerValor(dtoP.getModificable()));
                    }
                    break;

                    case 26:
                    {
							  traza("entro al 26");
                       asignarAtributo("CHECKBOX","ckVisibleControlMorosidad","check",obtenerValor(dtoP.getVisible()));
                       asignarAtributo("CHECKBOX","ckObligatorioControlMorosidad","check",obtenerValor(dtoP.getObligatorio()));
                       asignarAtributo("CHECKBOX","ckModificableControlMorosidad","check",obtenerValor(dtoP.getModificable()));
                       ArrayList arrMorosidad = dtoP.getListaValoresPosibles();
                       Iterator itMorosidad = arrMorosidad.iterator();
                       StringBuffer st = new StringBuffer();
                       rsMorosidad.addColumn("ID");
                       rsMorosidad.addColumn("Descripcion");
                       rsMorosidad.addColumn("porDef");
                       while (itMorosidad.hasNext()){
                        DTOParametroBoolean dtoB = (DTOParametroBoolean)itMorosidad.next();
                        traza("dtoB: "+dtoB);
                        st.append(dtoB.getValor());
                        st.append(",");
                        if ((dtoB.getOid()!= null) && (dtoB.getValor()!=null)){
                          Vector vect = new Vector();
                          
                          //incidencia 23078
                          //agregado jsilva--------------------------
                          if (accion.equalsIgnoreCase("detalle") ){
                            traza("****JAS****entro por detalle");
                            vect.add (devolverOid (dtoB.getValor().toString() ) );
                          }else{
                            if (accion.equalsIgnoreCase("modificar") ){
                              traza("****JAS****entro por modificar");
                              vect.add(dtoB.getOid());
                            }
                          }
                          //agregado jsilva--------------------------
                          
                          if (dtoB.getValor().toString().equals("true"))
                            vect.add("Si");
                          else vect.add("No");
                          if (dtoB.getValorPorDefecto().booleanValue())
                            vect.add("s");
                          else vect.add("n");
                          
                          traza("****JAS****El vector a agregar es: " + vect.toString());
                          
                          rsMorosidad.addRow(vect);
                        
                        }
                       }
								
                
                    traza("recordset: "+rsMorosidad);
                    Vector colIDMorosidad  = rsMorosidad.getColumnIdentifiers();
                    int numColMorosidad            = rsMorosidad.getColumnCount();
                    DruidaConector morosidad       = generarConector("DTOSalida.resultado_ROWSET",rsMorosidad,colIDMorosidad);
                    if (accion.equals("detalle"))
                      asignar("COMBO","cbValoresPosiblesControlMorosidad",morosidad,"DTOSalida.resultado_ROWSET");
                      asignar("COMBO","cbValoresDefectoControlMorosidad",morosidad,"DTOSalida.resultado_ROWSET");
                    if (st.length() >1){
                      StringBuffer cadena = st;
                      asignarAtributo("VAR","selControlMorosidad","valor",st.substring(0,cadena.length()- 1));
                  }           
					  }
                    break;

                    case 27:
                    {
							  traza("entro al 27");
                       asignarAtributo("CHECKBOX","ckVisibleControlDevolucionesAnulaciones","check",obtenerValor(dtoP.getVisible()));
                       asignarAtributo("CHECKBOX","ckObligatorioControlDevolucionesAnulaciones","check",obtenerValor(dtoP.getObligatorio()));
                       asignarAtributo("CHECKBOX","ckModificableControlDevolucionesAnulaciones","check",obtenerValor(dtoP.getModificable()));
                        ArrayList arrDA = dtoP.getListaValoresPosibles();
                        Iterator itDA = arrDA.iterator();
                        StringBuffer st = new StringBuffer();
                        rsDA.addColumn("ID");
                        rsDA.addColumn("Descripcion");
                        rsDA.addColumn("porDef");
                        while (itDA.hasNext()){
                          DTOParametroBoolean dtoB = (DTOParametroBoolean)itDA.next();
                          traza("dtoB: "+dtoB);
                          st.append(dtoB.getValor());
                          st.append(",");                                     
                          if ((dtoB.getOid()!= null) && (dtoB.getValor()!=null)){
                            Vector vect = new Vector();
                            
                            //incidencia 23078
                            //agregado jsilva--------------------------
                            if (accion.equalsIgnoreCase("detalle") ){
                              traza("****JAS****entro por detalle");
                              vect.add (devolverOid (dtoB.getValor().toString() ) );
                            }else{
                              if (accion.equalsIgnoreCase("modificar") ){
                                traza("****JAS****entro por modificar");
                                vect.add(dtoB.getOid());
                              }
                            }
                            //agregado jsilva--------------------------
                            
                            if (dtoB.getValor().toString().equals("true"))
                              vect.add("Si");
                            else vect.add("No");
                            if (dtoB.getValorPorDefecto().booleanValue())
                              vect.add("s");
                            else vect.add("n");
                            traza("****JAS****El vector a agregar es: " + vect.toString());
                            rsDA.addRow(vect);
                          }
                        }
                        
                        traza("recordset: "+rsDA);
                        Vector colIDDA   = rsDA.getColumnIdentifiers();
                        int numColDA            = rsDA.getColumnCount();
                        DruidaConector da       = generarConector("DTOSalida.resultado_ROWSET",rsDA,colIDDA);
								if (accion.equals("detalle"))
								asignar("COMBO","cbValoresPosiblesControlDevolucionesAnulaciones",da,"DTOSalida.resultado_ROWSET");
                        asignar("COMBO","cbValoresDefectoControlDevolucionesAnulaciones",da,"DTOSalida.resultado_ROWSET");
								if (st.length() >1){
                                StringBuffer cadena = st;
									   asignarAtributo("VAR","selControlDevolucionesAnulaciones","valor",st.substring(0,cadena.length()- 1));
                         }
                    }
                    break;

                    case 28:
                    {
							  traza("entro al 28");
                       asignarAtributo("CHECKBOX","ckVisibleControlDescuentoAcumulativo","check",obtenerValor(dtoP.getVisible()));
                       asignarAtributo("CHECKBOX","ckObligatorioControlDescuentoAcumulativo","check",obtenerValor(dtoP.getObligatorio()));
                       asignarAtributo("CHECKBOX","ckModificableControlDescuentoAcumulativo","check",obtenerValor(dtoP.getModificable()));
                        ArrayList arrControlDesc = dtoP.getListaValoresPosibles();
                        Iterator itControlDesc = arrControlDesc.iterator();
                        StringBuffer st = new StringBuffer();
                        rsControlDesc.addColumn("ID");
                        rsControlDesc.addColumn("Descripcion");
                        rsControlDesc.addColumn("porDef");
                        while (itControlDesc.hasNext()){
                          DTOParametroBoolean dtoB = (DTOParametroBoolean)itControlDesc.next();
                          traza("dtoB: "+dtoB);
                          st.append(dtoB.getValor());
                          st.append(",");                                     
                          if ((dtoB.getOid()!= null) && (dtoB.getValor()!=null)){
                            Vector vect = new Vector();
                            
                            //incidencia 23078
                            //agregado jsilva--------------------------
                            if (accion.equalsIgnoreCase("detalle") ){
                              traza("****JAS****entro por detalle");
                              vect.add (devolverOid (dtoB.getValor().toString() ) );
                            }else{
                              if (accion.equalsIgnoreCase("modificar") ){
                                traza("****JAS****entro por modificar");
                                vect.add(dtoB.getOid());
                              }
                            }
                            //agregado jsilva--------------------------
                            if (dtoB.getValor().toString().equals("true"))
                              vect.add("Si");
                            else vect.add("No");
                            if (dtoB.getValorPorDefecto().booleanValue())
                              vect.add("s");
                            else vect.add("n");
                            traza("****JAS****El vector a agregar es: " + vect.toString());
                            rsControlDesc.addRow(vect);
									 }
								}
								traza("recordset: "+rsControlDesc);
                        Vector colIDControlDesc   =   rsControlDesc.getColumnIdentifiers();
                        int numColControlDesc            = rsControlDesc.getColumnCount();
                        DruidaConector controlDesc       = generarConector("DTOSalida.resultado_ROWSET",rsControlDesc,colIDControlDesc);
								if (accion.equals("detalle"))
								asignar("COMBO","cbValoresPosiblesControlDescuentoAcumulativo",controlDesc,"DTOSalida.resultado_ROWSET");
                        asignar("COMBO","cbValoresDefectoControlDescuentoAcumulativo",controlDesc,"DTOSalida.resultado_ROWSET");
								if (st.length() >1){
                               StringBuffer cadena = st;
										asignarAtributo("VAR","selControlDescuentoAcumulativo","valor",st.substring(0,cadena.length()- 1));
                          }
                    }
                    break;

                    case 29:
                    {
							  traza("entro al 29");
                        asignarAtributo("CHECKBOX","ckVisibleAfectaFacturas","check",obtenerValor(dtoP.getVisible()));
                        asignarAtributo("CHECKBOX","ckObligatorioAfectaFacturas","check",obtenerValor(dtoP.getObligatorio()));
                        asignarAtributo("CHECKBOX","ckModificableAfectaFacturas","check",obtenerValor(dtoP.getModificable()));
                        ArrayList arrAfectaFactura = dtoP.getListaValoresPosibles();
                        Iterator itAfectaFactura = arrAfectaFactura.iterator();
                        StringBuffer st = new StringBuffer();
                        rsAfectaFactura.addColumn("ID");
                        rsAfectaFactura.addColumn("Descripcion");
                        rsAfectaFactura.addColumn("porDef");
                        while (itAfectaFactura.hasNext()){
                          DTOParametroBoolean dtoB = (DTOParametroBoolean)itAfectaFactura.next();
                          traza("dtoB: "+dtoB);
                          st.append(dtoB.getValor());
                          st.append(",");                                     
                          if ((dtoB.getOid()!= null) && (dtoB.getValor()!=null)){
                            Vector vect = new Vector();
                            
                            //incidencia 23078
                            //agregado jsilva--------------------------
                            if (accion.equalsIgnoreCase("detalle") ){
                              traza("****JAS****entro por detalle");
                              vect.add (devolverOid (dtoB.getValor().toString() ) );
                            }else{
                              if (accion.equalsIgnoreCase("modificar") ){
                                traza("****JAS****entro por modificar");
                                vect.add(dtoB.getOid());
                              }
                            }
                            //agregado jsilva--------------------------
                            
                            if (dtoB.getValor().toString().equals("true"))
                              vect.add("Si");
                            else vect.add("No");
                            if (dtoB.getValorPorDefecto().booleanValue())
                              vect.add("s");
                            else vect.add("n");
                            traza("****JAS****El vector a agregar es: " + vect.toString());
                            rsAfectaFactura.addRow(vect);
									 }
                        }
								traza("recordset: "+rsAfectaFactura);
                        Vector colIDAfectaFactura   =  rsAfectaFactura.getColumnIdentifiers();
                        int numColAfectaFactura            = rsAfectaFactura.getColumnCount();
                        DruidaConector afectaFactura       = generarConector("DTOSalida.resultado_ROWSET",rsAfectaFactura,colIDAfectaFactura);
								if (accion.equals("detalle"))
								asignar("COMBO","cbValoresPosiblesAfectaFacturas",afectaFactura,"DTOSalida.resultado_ROWSET");
                        asignar("COMBO","cbValoresDefectoAfectaFacturas",afectaFactura,"DTOSalida.resultado_ROWSET");
								if (st.length() >1){
                                StringBuffer cadena = st;
											asignarAtributo("VAR","selAfectaFacturas","valor",st.substring(0,cadena.length()- 1));
                         }
                    }
                    break;

                    case 30:
                    {
							  traza("entro al 30");
                       asignarAtributo("CHECKBOX","ckVisibleAfectaCuentaCorriente","check",obtenerValor(dtoP.getVisible()));
                       asignarAtributo("CHECKBOX","ckObligatorioAfectaCuentaCorriente","check",obtenerValor(dtoP.getObligatorio()));
                       asignarAtributo("CHECKBOX","ckModificableAfectaCuentaCorriente","check",obtenerValor(dtoP.getModificable()));
                        ArrayList arrAfectaCC = dtoP.getListaValoresPosibles();
                        Iterator itAfectaCC = arrAfectaCC.iterator();
                        StringBuffer st = new StringBuffer();
                        rsAfectaCC.addColumn("ID");
                        rsAfectaCC.addColumn("Descripcion");
                        rsAfectaCC.addColumn("porDef");
                        while (itAfectaCC.hasNext()){
                          DTOParametroBoolean dtoB = (DTOParametroBoolean)itAfectaCC.next();
                          traza("dtoB: "+dtoB);
                          st.append(dtoB.getValor());
                          st.append(",");                                     
                          if ((dtoB.getOid()!= null) && (dtoB.getValor()!=null)){
                            Vector vect = new Vector();
                            
                            //incidencia 23078
                            //agregado jsilva--------------------------
                            if (accion.equalsIgnoreCase("detalle") ){
                              traza("****JAS****entro por detalle");
                              vect.add (devolverOid (dtoB.getValor().toString() ) );
                            }else{
                              if (accion.equalsIgnoreCase("modificar") ){
                                traza("****JAS****entro por modificar");
                                vect.add(dtoB.getOid());
                              }
                            }
                            //agregado jsilva--------------------------
                            
                            if (dtoB.getValor().toString().equals("true"))
                              vect.add("Si");
                            else vect.add("No");
                            if (dtoB.getValorPorDefecto().booleanValue())
                              vect.add("s");
                            else vect.add("n");
                            traza("****JAS****El vector a agregar es: " + vect.toString());
                            rsAfectaCC.addRow(vect);
									 }
                        }
									traza("recordset: "+rsAfectaCC);
                        Vector colIDAfectaCC    = rsAfectaCC.getColumnIdentifiers();
                        int numColAfectaCC            = rsAfectaCC.getColumnCount();
                        DruidaConector afectaCC       = generarConector("DTOSalida.resultado_ROWSET",rsAfectaCC,colIDAfectaCC);
								if (accion.equals("detalle"))
								asignar("COMBO","cbValoresPosiblesAfectaCuentaCorriente",afectaCC,"DTOSalida.resultado_ROWSET");                        
                        asignar("COMBO","cbValoresDefectoAfectaCuentaCorriente",afectaCC,"DTOSalida.resultado_ROWSET");                        
								if (st.length() >1){
					               StringBuffer cadena = st;
										asignarAtributo("VAR","selAfectaCuentaCorriente","valor",st.substring(0,cadena.length()- 1));
                          }
                    }
                    break;

                    case 31:
                    {
							  traza("entro al 31");
                       asignarAtributo("CHECKBOX","ckVisibleComunicacionParticipantes","check",obtenerValor(dtoP.getVisible()));
                       asignarAtributo("CHECKBOX","ckObligatorioComunicacionParticipantes","check",obtenerValor(dtoP.getObligatorio()));
                       asignarAtributo("CHECKBOX","ckModificableComunicacionParticipantes","check",obtenerValor(dtoP.getModificable()));
                        ArrayList arrComunicacion = dtoP.getListaValoresPosibles();
                        Iterator itComunicacion = arrComunicacion.iterator();
                        StringBuffer st = new StringBuffer();
                        rsComunicacion.addColumn("ID");
                        rsComunicacion.addColumn("Descripcion");                            
                        rsComunicacion.addColumn("porDef");                            
                        while (itComunicacion.hasNext()){
                          DTOParametroBoolean dtoB = (DTOParametroBoolean)itComunicacion.next();
                          traza("dtoB: "+dtoB);
                          st.append(dtoB.getValor());
                          st.append(",");                                     
                          if ((dtoB.getOid()!= null) && (dtoB.getValor()!=null)){
                            Vector vect = new Vector();
                            
                            //incidencia 23078
                            //agregado jsilva--------------------------
                            if (accion.equalsIgnoreCase("detalle") ){
                              traza("****JAS****entro por detalle");
                              vect.add (devolverOid (dtoB.getValor().toString() ) );
                            }else{
                              if (accion.equalsIgnoreCase("modificar") ){
                                traza("****JAS****entro por modificar");
                                vect.add(dtoB.getOid());
                              }
                            }
                            //agregado jsilva--------------------------
                            
                            if (dtoB.getValor().toString().equals("true"))
                              vect.add("Si");
                            else vect.add("No");
                            if (dtoB.getValorPorDefecto().booleanValue())
                              vect.add("s");
                            else vect.add("n");
                            traza("****JAS****El vector a agregar es: " + vect.toString());
                            rsComunicacion.addRow(vect);
                          }
                        }
								traza("recordset: "+rsComunicacion);
                        Vector colIDComunicacion   =   rsComunicacion.getColumnIdentifiers();
                        int numColComunicacion            = rsComunicacion.getColumnCount();
                        DruidaConector comunicacion       = generarConector("DTOSalida.resultado_ROWSET",rsComunicacion,colIDComunicacion);
								if (accion.equals("detalle"))
								asignar("COMBO","cbValoresPosiblesComunicacionParticipantes",comunicacion,"DTOSalida.resultado_ROWSET");                                                
								asignar("COMBO","cbValoresDefectoComunicacionParticipantes",comunicacion,"DTOSalida.resultado_ROWSET");                                                
								if (st.length() >1){
                                StringBuffer cadena = st;
											asignarAtributo("VAR","selComunicacionParticipantes","valor",st.substring(0,cadena.length()- 1));
                          }
                    }
                    break;
                  
                  
                }
            }
 		  asignarAtributo("VAR","selPorDef","valor",selPorDef.toString());
        DTOBelcorp dtoBelcorp = new DTOBelcorp();
        dtoBelcorp.setOidIdioma(UtilidadesSession.getIdioma(this));
        dtoBelcorp.setOidPais(UtilidadesSession.getPais(this));
			if (accion.equals("modificar"))
				cargaCombos(dtoBelcorp);
 		asignarAtributo("VAR","casoDeUso","valor","modificar");
     }
    catch(Exception ex){
            logStackTrace(ex);
			 this.lanzarPaginaError(ex);
          }
    
    
    }
    
    private Long devolverOid(String valor){
      
      //incidencia 23078
      //agregado jsilva----------------------------
      if (valor.equalsIgnoreCase("true") ){
        return(new Long(1));
      }else{
        return(new Long(0));//false
      }
      //agregado jsilva-----------------------------
    
    }
    
    private DruidaConector generarConector(String rowsetID, RecordSet datos,Vector columns)
		throws DOMException,Exception	{
    
		StringBuffer salida = new StringBuffer();
		int sizeColums = datos.getColumnCount();
		int sizeRows = datos.getRowCount();

		if ( columns == null ){
			columns = new Vector();
		}

		Vector columsDesc = datos.getColumnIdentifiers();		
		traza("datos de generar conector:" + datos);
		DruidaConector conectorValoresPosibles = new DruidaConector();				
		XMLDocument xmlDoc  = new XMLDocument();
		Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");			
		Element e_rows = docDestino.createElement("ROWSET");
		e_rows.setAttribute("ID",rowsetID);
		docDestino.getDocumentElement().appendChild(e_rows);
		
		for (int i=0; i < sizeRows; i++){
			Element e_row = docDestino.createElement("ROW");
			if (datos.getValueAt(i,2).toString().equals("s")){
			  e_row.setAttribute("check", "S");
			}
			e_rows.appendChild(e_row);

			for (int j=0; j < sizeColums; j++){
				if ( columns.contains(columsDesc.elementAt(j)) ){
					Element e_campo2   = docDestino.createElement("CAMPO");
					e_campo2.setAttribute("NOMBRE",columsDesc.elementAt(j).toString());
					e_campo2.setAttribute("TIPO","OBJECTO");
					e_campo2.setAttribute("LONGITUD","50");
					Text txt = docDestino.createTextNode((datos.getValueAt(i,j)==null?"":datos.getValueAt(i,j).toString()));
					e_campo2.appendChild(txt);
					e_row.appendChild(e_campo2);
				}
			}
		}	
		conectorValoresPosibles.setXML(docDestino.getDocumentElement());
		return conectorValoresPosibles;
	}

    public void recargaCombos(DTOSCargarPaginaCrearMatrizDTO dtoSalida) throws Exception {
            traza("entro a recargaCombos....");
       try{
				 //acceso
            traza("acceso");
            RecordSet acceso = dtoSalida.getAcceso();
				traza("recordset: "+acceso);
            Vector fila = null;
            int longitud = acceso.getRowCount();
            StringBuffer oids = new StringBuffer();
            StringBuffer desc = new StringBuffer();
            StringBuffer canal = new StringBuffer();
                
            BigDecimal big = null;
            for (int i = 0; i < longitud; i++){
                fila = acceso.getRow(i);
                big = (BigDecimal) fila.get(0); 
                oids.append( big.toString() );
                desc.append( (String) fila.get(1) );
                big = (BigDecimal) fila.get(2);
                canal.append(big.toString());
                traza("fila " + i + ": " + fila.toString() );
                if (i != (longitud-1) ) {
                    oids.append(",");
                    desc.append(",");
                    canal.append(",");
                }
            }
            asignarAtributo("VAR", "accesoOid", "valor", oids.toString());
            asignarAtributo("VAR", "accesoDesc", "valor", desc.toString());
            asignarAtributo("VAR", "accesoOidPadre", "valor", canal.toString());

            //subacceso
            traza("subacceso");
            RecordSet subacceso = dtoSalida.getSubacceso();
            fila = null;
            longitud = subacceso.getRowCount();
            oids = new StringBuffer();
            desc = new StringBuffer();
            StringBuffer acces = new StringBuffer();
                
            big = null;
            for (int i = 0; i < longitud; i++) {
                fila = subacceso.getRow(i);
                big = (BigDecimal) fila.get(0); 
                oids.append( big.toString() );
                desc.append( (String) fila.get(1) );
                big = (BigDecimal) fila.get(2);
                acces.append(big.toString());
                traza("fila " + i + ": " + fila.toString() );
                if (i != (longitud-1) ) {
                    oids.append(",");
                    desc.append(",");
                    acces.append(",");
                }
            }
            asignarAtributo("VAR", "SubaccesoOid", "valor", oids.toString());
            asignarAtributo("VAR", "SubaccesoDesc", "valor", desc.toString());
            asignarAtributo("VAR", "SubaccesoOidPadre", "valor", acces.toString());

            //subtipocliente
            traza("subtipocliente");
            RecordSet subtipocli = dtoSalida.getSubtipoCliente();
            fila = null;
            longitud = subtipocli.getRowCount();
            oids = new StringBuffer();
            desc = new StringBuffer();
            StringBuffer tipoCli = new StringBuffer();
                
            big = null;
            for (int i = 0; i < longitud; i++){
                fila = subtipocli.getRow(i);
                big = (BigDecimal) fila.get(0); 
                oids.append( big.toString() );
                big = (BigDecimal) fila.get(1);
                tipoCli.append(big.toString());
                desc.append( (String) fila.get(2) );
                traza("fila " + i + ": " + fila.toString() );
                if (i != (longitud-1) ) {
                    oids.append(",");
                    desc.append(",");
                    tipoCli.append(",");
                }
            }
            asignarAtributo("VAR", "SubtipoClienteOid", "valor", oids.toString());
            asignarAtributo("VAR", "SubtipoClienteDesc", "valor", desc.toString());
            asignarAtributo("VAR", "SubtipoClienteOidPadre", "valor", tipoCli.toString());

            //tipoclasificacion
            traza("tipoclasificacion");
            RecordSet tipocla = dtoSalida.getTipoClasificacion();
            fila = null;
            longitud = tipocla.getRowCount();
            oids = new StringBuffer();
            desc = new StringBuffer();
            StringBuffer subtipoCli = new StringBuffer();
                
            big = null;
            for (int i = 0; i < longitud; i++){
                fila = tipocla.getRow(i);
                big = (BigDecimal) fila.get(0); 
                oids.append( big.toString() );
                big = (BigDecimal) fila.get(1);
                subtipoCli.append(big.toString());
                desc.append( (String) fila.get(2) );
                traza("fila " + i + ": " + fila.toString() );
                if (i != (longitud-1) ) {
                    oids.append(",");
                    desc.append(",");
                    subtipoCli.append(",");
                }
            }
            asignarAtributo("VAR", "TipoClasificacionOid", "valor", oids.toString());
            asignarAtributo("VAR", "TipoClasificacionDesc", "valor", desc.toString());
            asignarAtributo("VAR", "TipoClasificacionOidPadre", "valor", subtipoCli.toString());

            //subtipoclasificacion
            traza("subtipoclasificacion");
            RecordSet subtipocla = dtoSalida.getSubtipoClasificacion();
            fila = null;
            longitud = subtipocla.getRowCount();
            oids = new StringBuffer();
            desc = new StringBuffer();
            StringBuffer tipoCla = new StringBuffer();
                
            big = null;
            for (int i = 0; i < longitud; i++){
                fila = subtipocla.getRow(i);
                big = (BigDecimal) fila.get(0); 
                oids.append( big.toString() );
                big = (BigDecimal) fila.get(1);
                tipoCla.append(big.toString());                
                desc.append((String) fila.get(2));
                traza("fila " + i + ": " + fila.toString() );
                if (i != (longitud-1) ) {
                    oids.append(",");
                    desc.append(",");
                    tipoCla.append(",");
                }
            }
            asignarAtributo("VAR", "ClasificacionOid", "valor", oids.toString());
            asignarAtributo("VAR", "ClasificacionDesc", "valor", desc.toString());
            asignarAtributo("VAR", "ClasificacionOidPadre", "valor", tipoCla.toString());

				asignarAtributo("VAR","exito","valor","s");
		}catch (Exception e){
			logStackTrace(e);
			lanzarPaginaError(e);
		}
   }

	String obtenerValor(Boolean bool){
			if(bool.booleanValue())
			   return "S";
			else
				return "N";
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

    public void cargaLista() throws Exception {
		 try{
            DTOBuscarMatricesDescuento dto = new DTOBuscarMatricesDescuento();
            dto.setOidIdioma(UtilidadesSession.getIdioma(this));
			DruidaConector conector = null;
			Vector param = new Vector();
			param.add(dto);
			param.add(new MareBusinessID("DTOBuscarMatricesDescuentos"));
			traza("antes de conectar buscar");
			conector = conectar("ConectorObjetoGenerico",param);
			traza("despues de conectar buscar");
			DTOSalida dtoSalida =(DTOSalida) conector.objeto("DTOSalida");			
			RecordSet rs = dtoSalida.getResultado();
			traza("recordset entrada: "+rs);
            RecordSet rsSalida = new RecordSet();
            rsSalida.addColumn("Oid");            
            rsSalida.addColumn("CodMartiz");
            rsSalida.addColumn("Descripcion");
            rsSalida.addColumn("MatrizActiva");
				BigDecimal matriz = null;
            for (int i=0 ;i < rs.getRowCount() ;i++ )  {
                Vector vec = new Vector();
                vec.add(rs.getValueAt(i,0));
                vec.add(rs.getValueAt(i,0));
                vec.add(rs.getValueAt(i,1));
					 BigDecimal matact = (BigDecimal) rs.getValueAt(i,3);
					 matriz =(BigDecimal) rs.getValueAt(i,0);
					 if (matact.intValue() == 1)
					       vec.add("S");	
					else if (matact.intValue() == 0) vec.add("N");	
                rsSalida.addRow(vec);
            }
            traza("recordset salida: "+rsSalida);
            if (!(rsSalida.esVacio()))  {
                String listado ="listado1";
               asignar("LISTADOA",listado,UtilidadesBelcorp.generarConector("dtoSalida", rsSalida,rsSalida.getColumnIdentifiers()),"dtoSalida");
					Integer mat = new Integer(matriz.intValue() +1);
					asignarAtributo("LABELC","lbNNuevo","valor",mat.toString());
            } else asignarAtributo("VAR","noMat","valor","S");
		  }catch (Exception e){
			logStackTrace(e);
			lanzarPaginaError(e);
		  }
    }

	 private Vector getVector(String para, HashMap hash) throws Exception{
					Vector vec = new Vector();
		try{
					StringTokenizer d = new StringTokenizer(hash.get(para).toString(),",");
					while(d.hasMoreTokens() ){
						vec.add(d.nextToken());
				}
		}catch (Exception e){
			logStackTrace(e);
			lanzarPaginaError(e);
		}
		return vec;
	 }

     private boolean guardarMatriz() throws Exception {
     try{
  			  pagina("salidaGenerica");
				boolean ok = false;
            HashMap param = new HashMap();
            MareBusinessID mid = new MareBusinessID("DTOGuardarMatrizDescuentos");
            param = conectorParametro();
				//traza("param: "+param);
            DTODatosMatrizDescuentos dtoDmd = new DTODatosMatrizDescuentos();
				String oid = (String)param.get("hidOidMatriz");
				traza("oid: "+oid);
				if(!oid.equals(""))
					dtoDmd.setOidCabeceraMatriz(new Long(oid));
				Vector vTtraducciones = recuperaTraduccionesI18N(new Integer(1));
				dtoDmd.setDescripcion(vTtraducciones);

            if ((param.get("rbMatrizActiva").toString()).equals("S"))
               dtoDmd.setMatrizActiva(Boolean.TRUE);
            else
               dtoDmd.setMatrizActiva(Boolean.FALSE);
            dtoDmd.setObservaciones(param.get("atxtObservaciones").toString());
            dtoDmd.setOidPais(UtilidadesSession.getPais(this));
            dtoDmd.setOidIdioma(UtilidadesSession.getIdioma(this));
				int i = 2;
				ArrayList arr = new ArrayList();
            ArrayList arrParams = new ArrayList();
            HashMap mapB = new HashMap();
            HashMap mapBo = new HashMap();
            HashMap mapM = new HashMap();
            HashMap mapA = new HashMap();
            HashMap mapS = new HashMap();
            HashMap mapN = new HashMap();
            HashMap mapC = new HashMap();
            HashMap mapTC = new HashMap();
            HashMap mapSC = new HashMap();
				HashMap mapTCL = new HashMap();
            HashMap mapCL = new HashMap();
            mapM.put("03", "Marca");
            mapC.put("4", "Canal");
				mapA.put("05", "Acceso");
            mapS.put("06", "Subacceso");
            mapN.put("12", "AlcanceAdministrativoDescuento");
				mapBo.put("2", "IndicadorCulminacion");
            mapBo.put("26", "ControlMorosidad");
            mapBo.put("27", "ControlDevolucionesAnulaciones");
            mapBo.put("28", "ControlDescuentoAcumulativo");
            mapBo.put("29", "AfectaFacturas");
            mapBo.put("30", "AfectaCuentaCorriente");
            mapBo.put("31", "ComunicacionParticipantes");

				mapB.put("07", "VigenciaPeriodoInicial");
            mapB.put("8", "VigenciaPeriodoFinal");
            mapB.put("11", "DescuentosCliente");
            mapB.put("13", "PorcentajeAdicionalAlcanceAdministrativo");
            mapB.put("14", "BaseCalculoDescuentoMarca");
            mapB.put("15", "BaseCalculoDescuentoUnidadNegocio");
            mapB.put("16", "BaseCalculoDescuentoNegocio");
            mapB.put("17", "BaseCalculoDescuentoSupergenerico");
            mapB.put("18", "BaseCalculoDescuentoGenerico");
            mapB.put("19", "BaseCalculoDescuentoProducto");
            mapB.put("20", "BaseAplicacionDescuentoMarca");
            mapB.put("21", "BaseAplicacionDescuentoUnidadNegocio");
            mapB.put("22", "BaseAplicacionDescuentoNegocio");
            mapB.put("23", "BaseAplicacionDescuentoSupergenerico");
            mapB.put("24", "BaseAplicacionDescuentoGenerico");
            mapB.put("25", "BaseAplicacionDescuentoProducto");

            mapTC.put("9", "TipoCliente");
            mapSC.put("x", "SubtipoCliente");
            mapTCL.put("z", "TipoClasificacion");
            mapCL.put("10", "Clasificacion");
            String[] casos = {"00", "01", "2", "03", "4", "05", "06", "07", "8", "9", "10", "11", "12", "13", "14", "15", "16",
													"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
            while (i <= 31){
               traza("Parametro " + i);
               DTOParametroMatrizDescuentos dtoPmd = new DTOParametroMatrizDescuentos();
               if(mapB.containsKey(casos[i])) {
                     traza("en boolean");
                     String str = "cbValoresDefecto" + mapB.get(casos[i]);
                     String strPos= "cbValoresPosibles" + mapB.get(casos[i]);
                     String oidc = "lbCodigo" + mapB.get(casos[i]);  
                     String obli = "ckObligatorio" + mapB.get(casos[i]);
                     String modi = "ckModificable" + mapB.get(casos[i]);
                     String visi = "ckVisible" + mapB.get(casos[i]);
                     if ((param.get(obli).toString()).equals("S"))
                        dtoPmd.setObligatorio(Boolean.TRUE);
                     else
                        dtoPmd.setObligatorio(Boolean.FALSE);
                     if ((param.get(modi).toString()).equals("S"))
                        dtoPmd.setModificable(Boolean.TRUE);
                     else
                        dtoPmd.setModificable(Boolean.FALSE);
                     if ((param.get(visi).toString()).equals("S"))
                        dtoPmd.setVisible(Boolean.TRUE);
                     else
                        dtoPmd.setVisible(Boolean.FALSE);

                     dtoPmd.setOidParametro(new Long(Integer.toString(i)));      
               }
					
               if(mapM.containsKey(casos[i])) { /*********Marca**********/
                     traza("en Marca");
                     String str = "cbValoresDefecto" + mapM.get(casos[i]);
                     String strPos= "cbValoresPosibles" + mapM.get(casos[i]);
                     String obli = "ckObligatorio" + mapM.get(casos[i]);
                     String modi = "ckModificable" + mapM.get(casos[i]);
                     String visi = "ckVisible" + mapM.get(casos[i]);
                     dtoPmd.setOidParametro(new Long(Integer.toString(i)));      
                     if ((param.get(obli).toString()).equals("S"))
                        dtoPmd.setObligatorio(Boolean.TRUE);
                     else
                        dtoPmd.setObligatorio(Boolean.FALSE);
                     if ((param.get(modi).toString()).equals("S"))
                        dtoPmd.setModificable(Boolean.TRUE);
                     else
                        dtoPmd.setModificable(Boolean.FALSE);
                     if ((param.get(visi).toString()).equals("S"))
                        dtoPmd.setVisible(Boolean.TRUE);
                     else
                        dtoPmd.setVisible(Boolean.FALSE);
                     ArrayList arrayPos = new ArrayList();
                     int j = 0;
                     StringTokenizer strx = new StringTokenizer(param.get(strPos).toString(), "|");
                     while (strx.hasMoreTokens())
                     {
                           arrayPos.add(strx.nextToken());
                     }
							Vector vec = getVector("dMarca",param);
                     int nro = arrayPos.size();
                     ArrayList valos = new ArrayList();
                     while (j < nro) {
                        DTOParametroMarca dtoPm = new DTOParametroMarca();
                        dtoPm.setOidMarca(new Long(arrayPos.get(j).toString()));
                                System.out.println("antes del if");
                                if (vec.size() > 0){
                                System.out.println("if");
								dtoPm.setDescripcion(vec.get(j).toString());                                        
                                }
                         if(arrayPos.get(j).toString().equals(param.get(str).toString()))
                           dtoPm.setValorPorDefecto(new Boolean("true"));
                        else
                           dtoPm.setValorPorDefecto(new Boolean("false"));
                        valos.add(dtoPm);
                        j++;
                     }
                     dtoPmd.setListaVariablesPosibles(valos);
               } 
               if(mapA.containsKey(casos[i])){   /*********Accesos**********/
                     traza("en Accesos");
                     String str = "cbValoresDefecto" + mapA.get(casos[i]);
                     String strPos= "cbValoresPosibles" + mapA.get(casos[i]);
                     String obli = "ckObligatorio" + mapA.get(casos[i]);
                     String modi = "ckModificable" + mapA.get(casos[i]);
                     String visi = "ckVisible" + mapA.get(casos[i]);
                     String nmax = "txtNumMaxValores" + mapA.get(casos[i]);
                     if ((param.get(nmax)!=null) && (!param.get(nmax).toString().equals("")))
		                     dtoPmd.setNumeroMaximoValores(new Integer(param.get(nmax).toString()));
                     dtoPmd.setOidParametro(new Long(Integer.toString(i)));      
                     if ((param.get(obli).toString()).equals("S"))
                        dtoPmd.setObligatorio(Boolean.TRUE);
                     else
                        dtoPmd.setObligatorio(Boolean.FALSE);
                     if ((param.get(modi).toString()).equals("S"))
                        dtoPmd.setModificable(Boolean.TRUE);
                     else
                        dtoPmd.setModificable(Boolean.FALSE);
                     if ((param.get(visi).toString()).equals("S"))
                        dtoPmd.setVisible(Boolean.TRUE);
                     else
                        dtoPmd.setVisible(Boolean.FALSE);
                     ArrayList arrayPos = new ArrayList();
                     int j = 0;
                     StringTokenizer strx = new StringTokenizer(param.get(strPos).toString(), "|");
                     while (strx.hasMoreTokens()){
                           arrayPos.add(strx.nextToken());
                     }
							Vector vec = getVector("dAcceso",param);
							int nro = arrayPos.size();
                     ArrayList valos = new ArrayList();
                     while (j < nro){
                        DTOParametroAcceso dtoPa = new DTOParametroAcceso();
                        dtoPa.setOidAcceso(new Long(arrayPos.get(j).toString()));
                             if ((vec.size() >= j)&&(vec.size() > 0))
								dtoPa.setDescripcion(vec.get(j).toString());
								if(arrayPos.get(j).toString().equals(param.get(str).toString()))
                           dtoPa.setValorPorDefecto(new Boolean("true"));
                        else
                           dtoPa.setValorPorDefecto(new Boolean("false"));
                        valos.add(dtoPa);
                        j++;
                     }
                     dtoPmd.setListaVariablesPosibles(valos);
               } 
               if(mapS.containsKey(casos[i])) { /*********Subaccesos**********/
						traza("en Subaccesos");
                     String str = "cbValoresDefecto" + mapS.get(casos[i]);
                     String strPos= "cbValoresPosibles" + mapS.get(casos[i]);
                     String obli = "ckObligatorio" + mapS.get(casos[i]);
                     String modi = "ckModificable" + mapS.get(casos[i]);
                     String visi = "ckVisible" + mapS.get(casos[i]);
                     String nmax = "txtNumMax" + mapS.get(casos[i]);
                     if ((param.get(nmax)!=null) && (!param.get(nmax).toString().equals("")))
									dtoPmd.setNumeroMaximoValores(new Integer(param.get(nmax).toString()));
                     dtoPmd.setOidParametro(new Long(Integer.toString(i)));      
                     if ((param.get(obli).toString()).equals("S"))
                        dtoPmd.setObligatorio(Boolean.TRUE);
                     else
                        dtoPmd.setObligatorio(Boolean.FALSE);
                     if ((param.get(modi).toString()).equals("S"))
                        dtoPmd.setModificable(Boolean.TRUE);
                     else
                        dtoPmd.setModificable(Boolean.FALSE);
                     if ((param.get(visi).toString()).equals("S"))
                        dtoPmd.setVisible(Boolean.TRUE);
                     else
                        dtoPmd.setVisible(Boolean.FALSE);
                     ArrayList arrayPos = new ArrayList();
                     int j = 0;
                     StringTokenizer strx = new StringTokenizer(param.get(strPos).toString(), "|");
                     while (strx.hasMoreTokens()){
                           arrayPos.add(strx.nextToken());
                     }
							Vector vec = getVector("dSubcceso",param);
                     int nro = arrayPos.size();
                     ArrayList valos = new ArrayList();
                     while (j < nro){
                        DTOParametroSubacceso dtoPs = new DTOParametroSubacceso();
                        dtoPs.setOidSubacceso(new Long(arrayPos.get(j).toString()));
                             if ((vec.size() >= j)&&(vec.size() > 0))
						dtoPs.setDescripcionSubacceso(vec.get(j).toString());
                         if(arrayPos.get(j).toString().equals(param.get(str).toString()))
                           dtoPs.setValorPorDefecto(new Boolean("true"));
                        else
                           dtoPs.setValorPorDefecto(new Boolean("false"));
                        valos.add(dtoPs);
                        j++;
                     }
                     dtoPmd.setListaVariablesPosibles(valos);
               } 
               if(mapN.containsKey(casos[i])) { /*********Alcance**********/
                     traza("en alcance");
                     String str = "cbValoresDefecto" + mapN.get(casos[i]);
                     String strPos= "cbValoresPosibles" + mapN.get(casos[i]);
                     String obli = "ckObligatorio" + mapN.get(casos[i]);
                     String modi = "ckModificable" + mapN.get(casos[i]);
                     String visi = "ckVisible" + mapN.get(casos[i]);
							String vdN = "vd" + mapN.get(casos[i]);
							String vd = param.get(vdN).toString();
								if(vd.equals("Nacional"))
										vd="1";
								else 
									if(vd.equals("No nacional"))
									vd="2";
                     dtoPmd.setOidParametro(new Long(Integer.toString(i)));      
                     if ((param.get(obli).toString()).equals("S"))
                        dtoPmd.setObligatorio(Boolean.TRUE);
                     else
                        dtoPmd.setObligatorio(Boolean.FALSE);
                     if ((param.get(modi).toString()).equals("S"))
                        dtoPmd.setModificable(Boolean.TRUE);
                     else
                        dtoPmd.setModificable(Boolean.FALSE);
                     if ((param.get(visi).toString()).equals("S"))
                        dtoPmd.setVisible(Boolean.TRUE);
                     else
                        dtoPmd.setVisible(Boolean.FALSE);
                     ArrayList arrayPos = new ArrayList();
                     int j = 0;
                     StringTokenizer strx = new StringTokenizer(param.get(strPos).toString(), "|");
                     while (strx.hasMoreTokens()){
                           arrayPos.add(strx.nextToken());
                     }
                     ArrayList valos = new ArrayList();
                     int nro = arrayPos.size();
							traza("arrayPos: "+arrayPos+" vd: "+vd);
                     while (j < nro){
                        DTOParametroNacional dtoPn = new DTOParametroNacional();
                        if(arrayPos.get(j).toString().equals("1"))
                           dtoPn.setValor("Nacional");
                        else   if(arrayPos.get(j).toString().equals("2"))
                           dtoPn.setValor("No nacional");
                         if(arrayPos.get(j).toString().equals(vd))
                           dtoPn.setValorPorDefecto(new Boolean("true"));
                        else
                           dtoPn.setValorPorDefecto(new Boolean("false"));
                        valos.add(dtoPn);
                        j++;
                     }
                     dtoPmd.setListaVariablesPosibles(valos);
               }
               if(mapC.containsKey(casos[i])) {  /********* Canal **********/
                     traza("En canal");
                     String str = "cbValoresDefecto" + mapC.get(casos[i]);
                     String strPos= "cbValoresPosibles" + mapC.get(casos[i]);
							String obli = "ckObligatorio" + mapC.get(casos[i]);
                     String modi = "ckModificable" + mapC.get(casos[i]);
                     String visi = "ckVisible" + mapC.get(casos[i]);
                    dtoPmd.setOidParametro(new Long(Integer.toString(i)));     
                     if ((param.get(obli).toString()).equals("S"))
                        dtoPmd.setObligatorio(Boolean.TRUE);
                     else
                        dtoPmd.setObligatorio(Boolean.FALSE);
                     if ((param.get(modi).toString()).equals("S"))
                        dtoPmd.setModificable(Boolean.TRUE);
                     else
                        dtoPmd.setModificable(Boolean.FALSE);
                     if ((param.get(visi).toString()).equals("S"))
                        dtoPmd.setVisible(Boolean.TRUE);
                     else
                        dtoPmd.setVisible(Boolean.FALSE);

							ArrayList arrayPos = new ArrayList();
                     int j = 0;
                     StringTokenizer strx = new StringTokenizer(param.get(strPos).toString(), "|");
                     while (strx.hasMoreTokens()){
                           arrayPos.add(strx.nextToken());
                     }
							Vector vec = getVector("dCanal",param);
                     int nro = arrayPos.size();
                     ArrayList valos = new ArrayList();
			
							while (j < nro){
								DTOParametroCanal dtoPc = new DTOParametroCanal();	
								dtoPc.setOidCanal(new Long(arrayPos.get(j).toString()));
                        if ((vec.size() >= j)&&(vec.size() > 0))
								dtoPc.setDescripcion(vec.get(j).toString());
								if(arrayPos.get(j).toString().equals(param.get(str).toString()))
                           dtoPc.setValorPorDefecto(new Boolean("true"));
                        else
                           dtoPc.setValorPorDefecto(new Boolean("false"));
                        valos.add(dtoPc);
                        j++;
                     }
                    dtoPmd.setListaVariablesPosibles(valos);
		          } 
                if(mapBo.containsKey(casos[i])) { /********* Booleans **********/
							traza("en boolean con combos");
                     String str = "cbValoresDefecto" + mapBo.get(casos[i]);
                     String strPos= "cbValoresPosibles" + mapBo.get(casos[i]);
                     dtoPmd.setOidParametro(new Long(Integer.toString(i)));      
                     String obli = "ckObligatorio" + mapBo.get(casos[i]);
                     String modi = "ckModificable" + mapBo.get(casos[i]);
                     String visi = "ckVisible" + mapBo.get(casos[i]);
							String vdB = "vd" + mapBo.get(casos[i]);
							String vd =param.get(vdB).toString();
							if ((vd.equals("Si"))||(vd.equals("si")))
									vd="true";
							else	if ((vd.equals("No"))||(vd.equals("no")))
									vd="false";
                     if ((param.get(obli).toString()).equals("S"))
                        dtoPmd.setObligatorio(Boolean.TRUE);
                     else
                        dtoPmd.setObligatorio(Boolean.FALSE);
                     if ((param.get(modi).toString()).equals("S"))
                        dtoPmd.setModificable(Boolean.TRUE);
                     else
                        dtoPmd.setModificable(Boolean.FALSE);
                     if ((param.get(visi).toString()).equals("S"))
                        dtoPmd.setVisible(Boolean.TRUE);
                     else
                        dtoPmd.setVisible(Boolean.FALSE);
                     ArrayList arrayPos = new ArrayList();
                     int j = 0;
                     StringTokenizer strx = new StringTokenizer(param.get(strPos).toString(), "|");
                     while (strx.hasMoreTokens()){
                           arrayPos.add(strx.nextToken());
                     }
                     int h = 0;
                     for(h = 0; h < arrayPos.size(); h++){
                        if(arrayPos.get(h).toString().equals("1"))
                           arrayPos.set(h, "true");
                        else
                           arrayPos.set(h, "false");
                     }
                     int nro = arrayPos.size();
                     ArrayList valos = new ArrayList();
                     while (j < nro)
                     {
                        DTOParametroBoolean dtoPbo = new DTOParametroBoolean();
                        dtoPbo.setValor(new Boolean(arrayPos.get(j).toString()));
								String val = null;
								if (param.get(str).toString().equals("1"))
										 val = "true";
								else if (param.get(str).toString().equals("0")) val = "false";
							  if(arrayPos.get(j).toString().equals(vd))
                           dtoPbo.setValorPorDefecto(new Boolean("true"));
                        else
									dtoPbo.setValorPorDefecto(new Boolean("false"));
                        valos.add(dtoPbo);
                        j++;
                     }
                     dtoPmd.setListaVariablesPosibles(valos);
               } 
               if(mapCL.containsKey(casos[i])) { /********* Tipo Clasificacion y Clasificacion **********/
						traza("en clasificacion");
							String str = "cbValoresDefecto" + mapTCL.get("z");
                     String strPos= "cbValoresPosibles" + mapTCL.get("z");
                     String str2 = "cbValoresDefecto" + mapCL.get(casos[i]);
                     String strPos2= "cbValoresPosibles" + mapCL.get(casos[i]);
							String obli = "ckObligatorioPorcentajeAdicionalLineaCarrera";
                     String modi = "ckModificablePorcentajeAdicionalLineaCarrera";
                     String visi = "ckVisiblePorcentajeAdicionalLineaCarrera";
                     dtoPmd.setOidParametro(new Long(Integer.toString(i)));      
                     if ((param.get(obli).toString()).equals("S"))
                        dtoPmd.setObligatorio(Boolean.TRUE);
                     else
                        dtoPmd.setObligatorio(Boolean.FALSE);
                     if ((param.get(modi).toString()).equals("S"))
                        dtoPmd.setModificable(Boolean.TRUE);
                     else
                        dtoPmd.setModificable(Boolean.FALSE);
                     if ((param.get(visi).toString()).equals("S"))
                        dtoPmd.setVisible(Boolean.TRUE);
                     else
                        dtoPmd.setVisible(Boolean.FALSE);
                     ArrayList arrayPos = new ArrayList();
                    ArrayList arrayPos2 = new ArrayList();
                     int j = 0;
                     int j2=0;
                     StringTokenizer strx = new StringTokenizer(param.get(strPos).toString(), "|");
                     StringTokenizer strx2 = new StringTokenizer(param.get(strPos2).toString(), "|");
                     while (strx.hasMoreTokens()){
                           arrayPos.add(strx.nextToken());
                     }
		               while (strx2.hasMoreTokens()){
                           arrayPos2.add(strx2.nextToken());
                     }
                     ArrayList valos = new ArrayList();
                     ArrayList valos2= new ArrayList();
							Vector vec = getVector("dTiposClasificacion",param);
							Vector vec2 = getVector("dClasificacion",param);
                     int nro = arrayPos.size();
                     int nro2 = arrayPos2.size();
							traza("nro: "+nro+" == vec.size: "+vec.size());
							traza("nro2: "+nro2+" == vec2.size: "+vec2.size());
                     while (j < nro){
                        DTOParametroTipoClasificacion dtoPtcl = new DTOParametroTipoClasificacion();
                        dtoPtcl.setOidTipoClasificacion(new Long(arrayPos.get(j).toString()));
                        if ((vec.size() >= j)&&(vec.size() > 0))
									dtoPtcl.setDescripcionTipoClasificacion(vec.get(j).toString());
                         if(arrayPos.get(j).toString().equals(param.get(str).toString()))
                           dtoPtcl.setValorPorDefecto(new Boolean("true"));
                        else
                           dtoPtcl.setValorPorDefecto(new Boolean("false"));
                        valos.add(dtoPtcl);
                        j++;
                     }
		               while (j2 < nro2){
                        DTOParametroClasificacion dtoPcl = new DTOParametroClasificacion();
                        dtoPcl.setOidClasificacion(new Long(arrayPos2.get(j2).toString()));
                         if ((vec2.size() >= j2)&&(vec2.size() > 0))
									dtoPcl.setDescripcionClasificacion(vec2.get(j2).toString());
                         if(arrayPos2.get(j2).toString().equals(param.get(str2).toString()))
                           dtoPcl.setValorPorDefecto(new Boolean("true"));
                        else
                           dtoPcl.setValorPorDefecto(new Boolean("false"));
                        valos2.add(dtoPcl);
                        j2++;
                     }
                     dtoPmd.setListaVariablesPosibles(valos);
                     dtoPmd.setListaVariablesPosibles2(valos2);
							/*traza("Lista 1 : "+ valos);
                     traza("Lista 2 : "+ valos2);*/
               } 
               if(mapTC.containsKey(casos[i])){ /********* Tipos Clientes y Subtipos Clientes **********/
                     traza("En cliente");
                     String str = "cbValoresDefecto" + mapTC.get(casos[i]);
                     String str2 = "cbValoresDefecto" + mapSC.get("x");
                     String strPos= "cbValoresPosibles" + mapTC.get(casos[i]);
                     String strPos2= "cbValoresPosibles" + mapSC.get("x");
                     dtoPmd.setOidParametro(new Long(Integer.toString(i)));      
                     DTOParametroMatrizDescuentos dtoPmd2 = new DTOParametroMatrizDescuentos();
                     String obli = "ckObligatorio" + mapTC.get(casos[i]);
                     String modi = "ckModificable" + mapTC.get(casos[i]);
                     String visi = "ckVisible" + mapTC.get(casos[i]);
                     String nmax = "txtNumMax" + mapTC.get(casos[i]);
                     if ((param.get(nmax)!=null) && (!param.get(nmax).toString().equals("")))
		                     dtoPmd.setNumeroMaximoValores(new Integer(param.get(nmax).toString()));
                     if ((param.get(obli).toString()).equals("S"))
                        dtoPmd.setObligatorio(Boolean.TRUE);
                     else
                        dtoPmd.setObligatorio(Boolean.FALSE);
                     if ((param.get(modi).toString()).equals("S"))
                        dtoPmd.setModificable(Boolean.TRUE);
                     else
                        dtoPmd.setModificable(Boolean.FALSE);
                     if ((param.get(visi).toString()).equals("S"))
                        dtoPmd.setVisible(Boolean.TRUE);
                     else
                        dtoPmd.setVisible(Boolean.FALSE);
                     ArrayList arrayPos = new ArrayList();
                     ArrayList arrayPos2 = new ArrayList();
                     int j = 0;
                     int j2=0;
                     StringTokenizer strx = new StringTokenizer(param.get(strPos).toString(), "|");
                     StringTokenizer strx2 = new StringTokenizer(param.get(strPos2).toString(), "|");
                     while (strx.hasMoreTokens()){
                           arrayPos.add(strx.nextToken());
                     }
                     while (strx2.hasMoreTokens()){
                           arrayPos2.add(strx2.nextToken());
                     }
                     ArrayList valos = new ArrayList();
                     ArrayList valos2= new ArrayList();
							Vector vec = getVector("dTiposClientes",param);
							Vector vec2 = getVector("dSubtiposClientes",param);
                     int nro = arrayPos.size();
                     int nro2 = arrayPos2.size();
                     while (j < nro){
                        DTOParametroTipoCliente dtoPtc = new DTOParametroTipoCliente();
                        dtoPtc.setOidTipoCliente(new Long(arrayPos.get(j).toString()));
                                if (vec.size() > 0)
								dtoPtc.setDescripcion(vec.get(j).toString());
                         if(arrayPos.get(j).toString().equals(param.get(str).toString()))
                           dtoPtc.setValorPorDefecto(new Boolean("true"));
                        else
                           dtoPtc.setValorPorDefecto(new Boolean("false"));
                        valos.add(dtoPtc);
                        j++;
                     }
                     while (j2 < nro2) {
                        DTOParametroSubtipoCliente dtoPsc = new DTOParametroSubtipoCliente();
                        dtoPsc.setOidSubtipoCliente(new Long(arrayPos2.get(j2).toString()));
                             if ((vec2.size() >= j2)&&(vec2.size() > 0))
								dtoPsc.setDescripcion(vec2.get(j2).toString());
                         if(arrayPos2.get(j2).toString().equals(param.get(str2).toString()))
                           dtoPsc.setValorPorDefecto(new Boolean("true"));
                        else
                           dtoPsc.setValorPorDefecto(new Boolean("false"));
                        valos2.add(dtoPsc);
                        j2++;
                     }
                     dtoPmd.setListaVariablesPosibles(valos);
                     dtoPmd.setListaVariablesPosibles2(valos2);
                     /*traza("Lista 1 : "+ valos);
                     traza("Lista 2 : "+ valos2);*/
               } 
               arrParams.add(dtoPmd);
               i++;
            }
            dtoDmd.setListaParametros(arrParams);
            Vector vec = new Vector();
            vec.add(dtoDmd);
            vec.add(mid);
            traza(dtoDmd);
            traza("Antes de conectar");
            DruidaConector conec = conectar("ConectorGuardarMatrizDescuentos", vec);
            traza("Despues de conectar");
				asignarAtributo("VAR","ejecutar","valor","actualizaPadre()");
				return true;
     }
     catch(Exception e){
			logStackTrace(e);
			lanzarPaginaError(e);
			return false;
     }
     }   

	  private RecordSet sort(RecordSet rs) throws Exception{
            RecordSet rec = new RecordSet();
		  try{
			traza("entro a sort: "+rs);
            int i = 0;
            rec.setColumnIdentifiers(rs.getColumnIdentifiers());
            while(i <=rs.getRowCount()){
                   for (int j = 0 ;j < rs.getRowCount() ;j++ )  {
                        if(rs.getValueAt(j,0).equals(new BigDecimal(i))){
                            rec.addRow(rs.getRow(j));
								}
                   }
                   i++;
            }
				traza("rec: "+rec);
		  }
		  catch(Exception e){
			  logStackTrace(e);
			lanzarPaginaError(e);
		  }
        return rec;
     }
}
