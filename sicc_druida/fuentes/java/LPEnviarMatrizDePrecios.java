import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.mln.MareBusinessID;
import java.util.Vector;
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.intsys.DTOEntradaConsultaDatosCampana;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.logicanegocio.intsys.ConstantesOCR;
import es.indra.sicc.dtos.intsys.DTOInterfaz;
import es.indra.sicc.dtos.intsys.DTOEntradaConsultaDatosCampana;

import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.seg.DTOAccesosPorCanal;

public class LPEnviarMatrizDePrecios extends LPSICCBase {
	
	public LPEnviarMatrizDePrecios() {
		super();
	}

	public void inicio() throws Exception {
		pagina("contenido_matriz_precios_enviar");
		this.getConfiguracionMenu();
	}

	public void ejecucion() throws Exception {
		
		rastreo();
		
		setTrazaFichero();
		String accion = conectorParametro("accion");
		accion = ( accion == null ) ? "" : accion;


		try {
			if ( accion.equals("") ) {
				//this.obtenerInformacionCriteriosDeSeleccion();
				this.obtenerValoresPorDefecto();
				this.cargarCombosMarcaCanal();

			    asignarAtributo("VAR", "hidIdioma", "valor", UtilidadesSession.getIdioma(this).toString() );
			    asignarAtributo("VAR", "hidPais", "valor", UtilidadesSession.getPais(this).toString() );
			    asignarAtributo("VAR", "hidCanal", "valor", UtilidadesSession.getCanalPorDefecto(this).toString() );
			    asignarAtributo("VAR", "hidMarca", "valor", UtilidadesSession.getMarcaPorDefecto(this).toString() );

				asignarAtributo("VAR", "casoDeUso", "valor", "EnviarMatrizDePrecios");
				asignarAtributo("PAGINA","contenido_matriz_precios_enviar","cod","0925");
	  			asignarAtributo("PAGINA","contenido_matriz_precios_enviar","titulo","0925");

			} else if ( accion.equals("Guardar") ) {
				traza("EnviarMatrizDePrecios va a guardar");
				conectorAction("LPGenerarFicheroDeEnviarMatrizPrecios");
				conectorActionParametro("action","");
			} 
		}
		catch ( Exception ex ) {
			traza("Error en ejecucion");
		    this.lanzarPaginaError(ex);
		}
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
              traza("*************************" + desc);
              asignarAtributo("VAR","labelDescripcion","valor",desc);
        }
	}
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

};
