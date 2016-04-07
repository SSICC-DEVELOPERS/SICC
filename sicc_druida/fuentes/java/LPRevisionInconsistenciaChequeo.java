import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.StringTokenizer;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.util.DTOColeccion;
import es.indra.sicc.dtos.ape.DTOListaPicadoDetalle;
import java.util.Date;
import java.text.SimpleDateFormat;

public class LPRevisionInconsistenciaChequeo extends LPSICCBase {	
    public LPRevisionInconsistenciaChequeo () { super(); }
	private String accion = null;
	private Long pais = null;     
	private Long idioma = null;
	public void inicio() throws Exception { }
  
    public void ejecucion() throws Exception {
		setTrazaFichero();
		traza("LPRevisionInconsistenciaChequeo.ejecucion() - Entrada");

     	accion = conectorParametroLimpia("accion", "", true);
	    pais = UtilidadesSession.getPais(this);
		idioma = UtilidadesSession.getIdioma(this);

		traza("**** accion : " + accion);
		traza("**** pais : " + pais);
		traza("**** idioma : " + idioma);
	    
		try  {			
			if (accion.equals("")) {
				cargarPagina(); 
			}
			else if(accion.equals("revisarCaja")) {
				revisarCaja();
			}			
			else if(accion.equals("revisarTodosDetalles")) {
				revisarTodosDetalles();
			}			
			else if(accion.equals("revisarDetallesError")) {
				revisarDetallesError();
			}	
			else if(accion.equals("guardarDetalle")) {
				guardarDetalle();
			}	
			
			cargarMenuSecundario();
			traza("LPRevisionInconsistenciaChequeo.ejecucion() - Salida");
		}
		catch ( Exception e )  {			
            e.printStackTrace();
			traza("Exception en LPRevisionInconsistenciaChequeo");
			traza(e);
			lanzarPaginaError(e);
	    }
	}

	public void cargarPagina() throws Exception {
		traza("LPRevisionInconsistenciaChequeo.cargarPagina() - Entrada");		
		pagina("contenido_revision_inconsistencia_chequeo"); 
		this.getFormatosValidaciones();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
		Date fechaSistema = new Date();
		String fecha = sdf.format(fechaSistema);
		traza("************* fecha " + fecha);		
		asignarAtributo("VAR", "fechaSistema", "valor", fecha);		

		asignarAtributo("VAR", "accion", "valor", accion);
		asignarAtributo("VAR", "pais", "valor", pais.toString());
		asignarAtributo("VAR", "idioma", "valor", idioma.toString());
		traza("LPRevisionInconsistenciaChequeo.cargarPagina() - Salida");		
	}

	public void guardarDetalle() throws Exception {
		traza("LPRevisionInconsistenciaChequeo.guardarDetalle() - Entrada");
		pagina("salidaGenerica");
		DTOColeccion dto = new DTOColeccion();
		ArrayList lista = new ArrayList();	
		
		String datosLista = conectorParametroLimpia("datosLista", "", true);		
		traza("***** datosLista " + datosLista);

		StringTokenizer stFilas = new StringTokenizer(datosLista,"?");
		  
		while(stFilas.hasMoreTokens()) {
			String elemento = stFilas.nextToken();
			StringTokenizer stCampos = new StringTokenizer(elemento,"|");

			DTOListaPicadoDetalle dtoLista = new DTOListaPicadoDetalle();
			
			int i=0;

		    while(stCampos.hasMoreTokens()) {
				String valor = stCampos.nextToken();
				if(!valor.equals(" ")) {
					traza("valor: " + valor);
					if(i==0) {
						dtoLista.setOid(new Long(valor));
					}else if(i==3){
						dtoLista.setUnidadesProducto(new Long(valor));	
					}
					else if(i==4) {
						dtoLista.setUnidadesChequeadas(new Long(valor));
					}
					/*else if(i==6) {
						dtoLista.setOidCodigoError(new Long(valor));
					}*/
					else if(i==8) {
						dtoLista.setNombrePicador(valor);
					}
					else if(i==9) {
						dtoLista.setObservaciones(valor);
					}
					else if(i==10) {
						dtoLista.setNumeroCaja(new Long(valor));
					}
					else if(i==11) {
						dtoLista.setOidCabecera(new Long(valor));
					}
					// BELC400000735 - dmorello, 14/09/2007
					else if(i==12) {
						dtoLista.setCodigoError(valor);
					}
					else if(i==13){
						dtoLista.setUnidadesVerificadas(new Long(valor));	
					}
				}

				i++;
			}
			traza("***** DTOListaPicadoDetalle " + dtoLista);
			lista.add(dtoLista);
		}

		traza("***** Cantidad de filas de la lista: " + lista.size());		
		dto.setLista(lista);	

  	    MareBusinessID businessID = new MareBusinessID("APEGuardarInconsistenciaChequeo");
		Vector parametros = new Vector();
		parametros.add(dto);
		parametros.add(businessID);

		try {
	        traza("******************* Antes de conectar");
			DruidaConector con = conectar("ConectorGuardarInconsistenciaChequeo", parametros);
			traza("******************* Despues de conectar");
		    asignarAtributo("VAR","ejecutar","valor","fGuardarOK()");        
		}
		catch(Exception e) {
			traza("******************* Entrando al catch...");
			asignarAtributo("VAR", "ejecutarError", "valor", "fGuardarERR()");  
			throw e;
		}

		traza("LPRevisionInconsistenciaChequeo.guardarDetalle() - Salida");
	}

	public void revisarCaja() throws Exception {
		traza("LPRevisionInconsistenciaChequeo.revisarCaja() - Entrada");		
		String oidCabecera = conectorParametroLimpia("oidCabecera", "", true);
		String numeroCaja = conectorParametroLimpia("numeroCaja", "", true);
		String numeroEtiqueta = conectorParametroLimpia("numeroEtiqueta", "", true);

		traza("******** oidCabecera " + oidCabecera);
		traza("******** numeroCaja " + numeroCaja);
		traza("******** numeroEtiqueta " + numeroEtiqueta);

		pagina("contenido_revisar_caja");  

		this.getFormatosValidaciones();

		DTOListaPicadoDetalle dto = new DTOListaPicadoDetalle();
		dto.setOidCabecera(new Long(oidCabecera));
		dto.setNumeroCaja(new Long(numeroCaja));
		dto.setNumeroEtiqueta(new Long(numeroEtiqueta));
		//vbongiov -- Inc APE20080516 -- 24/06/2008 
        dto.setOidIdioma(idioma); 

		MareBusinessID businessID = new MareBusinessID("APERevisarCaja");
		Vector parametros = new Vector();
		parametros.add(dto);
		parametros.add(businessID);
		
		traza("*** Llamando a APERevisarCaja");
		DruidaConector con = conectar("ConectorRevisarCaja", parametros);
		traza("*** Despues de llamar a APERevisarCaja");

		DTOSalida dtoSalida = (DTOSalida)con.objeto("dtoSalida");
		traza("******** DTOSalida: " + dtoSalida.getResultado());
		
		if(dtoSalida.getResultado() != null) {
			DruidaConector conLista = generarConectorLista(dtoSalida.getResultado());
			this.asignar("LISTADOA", "listado1", conLista, "dtoSalida");
		}

		asignarAtributo("VAR", "accion", "valor", accion);
		asignarAtributo("VAR", "pais", "valor", pais.toString());
		asignarAtributo("VAR", "idioma", "valor", idioma.toString());

		traza("LPRevisionInconsistenciaChequeo.revisarCaja() - Salida");
	}

    private DruidaConector generarConectorLista(RecordSet rsParam) throws Exception {
  		 traza("LPRevisionInconsistenciaChequeo.generarConectorLista() - Entrada");
         int cant = rsParam.getRowCount();
  
         RecordSet rs = new RecordSet();
         Vector v = null;
    
         rs.addColumn("OID_LIST_PICA_DETA");	
         rs.addColumn("NUM_CODI_POSI");
         rs.addColumn("DES_CORT");
         rs.addColumn("NUM_UNID_PROD");
         rs.addColumn("NUM_UNID_CHEQ");	
         rs.addColumn("NUM_ANAQ");
         rs.addColumn("UNIDCOMERROR");
         rs.addColumn("VAL_NOMB_CHEQ");
         rs.addColumn("VAL_NOMB_PICA");	
         rs.addColumn("VAL_OBSE_REVI");
         rs.addColumn("NUM_CAJA");
         rs.addColumn("OID_LIST_PICA_CABE");
		 rs.addColumn("COD_ERRO_CHEQ");  // BELC400000735 - dmorello, 14/09/2007
		 rs.addColumn("NUM_UNID_VERI");  // Agregado por cambio 20090839
  
         for (int i = 0; i<cant ; i++){
             v = new Vector();

			 v.add(rsParam.getValueAt(i, "OID_LIST_PICA_DETA"));
             v.add(rsParam.getValueAt(i, "NUM_CODI_POSI"));
             v.add(rsParam.getValueAt(i, "DES_CORT"));
             v.add(rsParam.getValueAt(i, "NUM_UNID_PROD"));
			 v.add(rsParam.getValueAt(i, "NUM_UNID_CHEQ"));
             v.add(rsParam.getValueAt(i, "NUM_ANAQ"));
             v.add(rsParam.getValueAt(i, "UNIDCOMERROR"));
             v.add(rsParam.getValueAt(i, "VAL_NOMB_CHEQ"));
             v.add(rsParam.getValueAt(i, "VAL_NOMB_PICA"));
             v.add(rsParam.getValueAt(i, "VAL_OBSE_REVI"));
             v.add(rsParam.getValueAt(i, "NUM_CAJA"));
             v.add(rsParam.getValueAt(i, "OID_LIST_PICA_CABE"));
             v.add(rsParam.getValueAt(i, "COD_ERRO_CHEQ"));  // BELC400000735 - dmorello, 14/09/2007
			 v.add(rsParam.getValueAt(i, "NUM_UNID_VERI")); // Agregado por cambio 20090839
			 rs.addRow(v);
			 //TESTING
			 /*v = new Vector();

			 v.add(rsParam.getValueAt(i, "OID_LIST_PICA_DETA"));
             v.add(rsParam.getValueAt(i, "NUM_CODI_POSI"));
             v.add(rsParam.getValueAt(i, "COD_SAP"));
 			 v.add(new Long(140));
			 v.add(new Long(150));
             v.add(rsParam.getValueAt(i, "NUM_ANAQ"));
             //v.add(rsParam.getValueAt(i, "COD_ERRO_CHEQ"));
			 v.add(null);
             v.add(rsParam.getValueAt(i, "VAL_NOMB_CHEQ"));
             v.add(rsParam.getValueAt(i, "VAL_NOMB_PICA"));
             v.add(rsParam.getValueAt(i, "VAL_OBSE_REVI"));
             v.add(rsParam.getValueAt(i, "NUM_CAJA"));
             v.add(rsParam.getValueAt(i, "OID_LIST_PICA_CABE"));

			 rs.addRow(v);


			 v = new Vector();

			 v.add(rsParam.getValueAt(i, "OID_LIST_PICA_DETA"));
             v.add(rsParam.getValueAt(i, "NUM_CODI_POSI"));
             v.add(rsParam.getValueAt(i, "COD_SAP"));
 			 v.add(new Long(45));
			 v.add(new Long(55));
             v.add(rsParam.getValueAt(i, "NUM_ANAQ"));
             //v.add(rsParam.getValueAt(i, "COD_ERRO_CHEQ"));
			 v.add(null);
             v.add(rsParam.getValueAt(i, "VAL_NOMB_CHEQ"));
             v.add(rsParam.getValueAt(i, "VAL_NOMB_PICA"));
             v.add(rsParam.getValueAt(i, "VAL_OBSE_REVI"));
             v.add(rsParam.getValueAt(i, "NUM_CAJA"));
             v.add(rsParam.getValueAt(i, "OID_LIST_PICA_CABE"));

			 rs.addRow(v);*/
			 //fin - TESTING
         }

		 traza("* * * * * RecordSet: " + rs);
		 traza("LPRevisionInconsistenciaChequeo.generarConectorLista() - Salida");
         return UtilidadesBelcorp.generarConector("dtoSalida", rs, rs.getColumnIdentifiers());
    }

	public void revisarTodosDetalles() throws Exception {
		traza("LPRevisionInconsistenciaChequeo.revisarTodosDetalles() - Entrada");
		String datosLista = conectorParametroLimpia("datosLista", "", true);
		traza("************* datosLista: " + datosLista);

		pagina("contenido_revisar_detalles");  
		this.getFormatosValidaciones();

		asignarAtributo("VAR", "datosLista", "valor", datosLista);
		asignarAtributo("VAR", "accion", "valor", accion);
		asignarAtributo("VAR", "pais", "valor", pais.toString());
		asignarAtributo("VAR", "idioma", "valor", idioma.toString());
		traza("LPRevisionInconsistenciaChequeo.revisarTodosDetalles() - Salida");
	}

	public void revisarDetallesError() throws Exception {
		traza("LPRevisionInconsistenciaChequeo.revisarDetallesError() - Entrada");
		String datosLista = conectorParametroLimpia("datosLista", "", true);
		traza("************* datosLista: " + datosLista);

		pagina("contenido_revisar_detalles");  
		this.getFormatosValidaciones();

		asignarAtributo("VAR", "datosLista", "valor", datosLista);
		asignarAtributo("VAR", "accion", "valor", accion);
		asignarAtributo("VAR", "pais", "valor", pais.toString());
		asignarAtributo("VAR", "idioma", "valor", idioma.toString());
		traza("LPRevisionInconsistenciaChequeo.revisarDetallesError() - Salida");
	}

	private void cargarMenuSecundario() throws Exception {     
		traza("LPRevisionInconsistenciaChequeo.cargarMenuSecundario() - Entrada");		
	
		if(accion.equals("")) {
			getConfiguracionMenu("LPRevisionInconsistenciaChequeo","");
		    asignarAtributoPagina("cod","3179");
		}	
		else if(accion.equals("revisarCaja")) {
			getConfiguracionMenu("LPRevisionInconsistenciaChequeo","revisarCaja");
		    asignarAtributoPagina("cod","3156");
		}
		else if(accion.equals("revisarTodosDetalles")) {
			getConfiguracionMenu("LPRevisionInconsistenciaChequeo","revisarTodosDetalles");
		    asignarAtributoPagina("cod","3163");
		}
		else if(accion.equals("revisarDetallesError")) {
			getConfiguracionMenu("LPRevisionInconsistenciaChequeo","revisarDetallesError");
		    asignarAtributoPagina("cod","3162");
		}
	
		traza("LPRevisionInconsistenciaChequeo.cargarMenuSecundario() - Salida");
	}

}
