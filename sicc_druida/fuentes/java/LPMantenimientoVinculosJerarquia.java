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

import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;

import java.util.HashMap;
import java.util.Vector;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.math.BigDecimal;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.IBelcorpError;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;

import es.indra.sicc.dtos.seg.DTOEBuscarVinculosJerarquia;
import es.indra.sicc.dtos.seg.DTOEVinculoJerarquia;
import es.indra.sicc.dtos.seg.DTOAccesosPorCanal;




/**
 * Sistema:           Belcorp
 * Modulo:            SEG
 * Submódulo:         Seguridad
 * Componente:        LPManenimientoVinculosJerarquia
 * Fecha:             15/03/2004
 * Observaciones:     
 * @version           1.0
 * @autor             Viviana Bongiovanni
 */

public class LPMantenimientoVinculosJerarquia extends LPSICCBase {

  private Vector paramEntrada;
  private String mAccion;
  private String mCasoDeUso;
  private String mMarca;
  private String mCanal;
  private String mAcceso;
  private String mSubacceso;
  private String mEmpresa;
  private MareBusinessID id;


	public LPMantenimientoVinculosJerarquia() {
		super();
	}

	public void inicio() throws Exception {

		String sCasoDeUso = conectorParametroLimpia("casoDeUso","",true);    
		pagina("contenido_vinculo_jerarquia_consultar");

		if (sCasoDeUso.equals("insertar")){	
			pagina("contenido_vinculo_jerarquia_insertar");		
      asignarAtributoPagina("cod", "0639");
		} else if (sCasoDeUso.equals("consultar")){	
			pagina("contenido_vinculo_jerarquia_consultar");
			this.asignarAtributoPagina("cod","0640");
		} else if (sCasoDeUso.equals("eliminar")){	
			pagina("contenido_vinculo_jerarquia_consultar");
			this.asignarAtributoPagina("cod","0641");
		}

		
	}

	public void ejecucion() throws Exception {
	
    setTrazaFichero();

	  try{
      // Rastreo
      rastreo();
    
			mAccion = conectorParametroLimpia( "accion", "", true );
			mCasoDeUso = conectorParametroLimpia( "casoDeUso", "", true );
			mMarca = conectorParametroLimpia( "hMarca", "", true );
			mCanal = conectorParametroLimpia( "hCanal", "", true );
			mAcceso = conectorParametroLimpia( "hAcceso", "", true );
			mSubacceso = conectorParametroLimpia( "hSubacceso", "", true );
			mEmpresa = conectorParametroLimpia( "hEmpresa", "", true );

      traza("ACCION - "+mAccion);

			if ( mAccion.equals( "consultar" ) ) {
            traza("accion vacio");

            cargaInicialCombos();
    				asignarAtributo( "VAR", "hIdioma", "valor", UtilidadesSession.getIdioma(this).toString());
    				asignarAtributo( "VAR", "hPais", "valor", UtilidadesSession.getPais(this).toString());
    				asignarAtributo( "VAR", "casoDeUso", "valor", mCasoDeUso);

            traza("Marca session: "+UtilidadesSession.getMarcaPorDefecto(this));
            
            /*
            asignarAtributo( "VAR", "hMarca", "valor", UtilidadesSession.getMarcaPorDefecto(this).toString());
            asignarAtributo( "VAR", "hCanal", "valor", UtilidadesSession.getCanalPorDefecto(this).toString());
      			asignarAtributo( "VAR", "hAcceso", "valor", UtilidadesSession.getAccesoPorDefecto(this).toString());
            asignarAtributo( "VAR", "hSubacceso", "valor", UtilidadesSession.getSubaccesoPorDefecto(this).toString());
            asignarAtributo( "VAR", "hEmpresa", "valor", UtilidadesSession.getSociedadPorDefecto(this).toString());
            asignarAtributo( "VAR", "hDefMarca", "valor", UtilidadesSession.getMarcaPorDefecto(this).toString());
            asignarAtributo( "VAR", "hDefCanal", "valor", UtilidadesSession.getCanalPorDefecto(this).toString());
      			asignarAtributo( "VAR", "hDefAcceso", "valor", UtilidadesSession.getAccesoPorDefecto(this).toString());
            asignarAtributo( "VAR", "hDefSubacceso", "valor", UtilidadesSession.getSubaccesoPorDefecto(this).toString());
            asignarAtributo( "VAR", "hDefEmpresa", "valor", UtilidadesSession.getSociedadPorDefecto(this).toString());
            */
            asignarAtributo( "VAR", "hContDefCbAcceso", "valor", conectorParametroLimpia( "hContDefCbAcceso", "", true ));
            asignarAtributo( "VAR", "hContDefCbSubacceso", "valor", conectorParametroLimpia( "hContDefCbSubacceso", "", true ));

      		  getConfiguracionMenu("LPMantenimientoVinculosJerarquia","consultar");


      } else if ( mAccion.equals("buscar") ) {      
          traza("Accion buscar");
          cargaInicialCombos();
  				asignarAtributo( "VAR", "hMarca", "valor", mMarca);
  				asignarAtributo( "VAR", "hCanal", "valor", mCanal);
  				asignarAtributo( "VAR", "hAcceso", "valor", mAcceso);
  				asignarAtributo( "VAR", "hSubacceso", "valor", mSubacceso);
  				asignarAtributo( "VAR", "hEmpresa", "valor", mEmpresa);

  				asignarAtributo( "VAR", "casoDeUso", "valor", mCasoDeUso);
  				asignarAtributo( "VAR", "hIdioma", "valor", UtilidadesSession.getIdioma(this).toString());
  				asignarAtributo( "VAR", "hPais", "valor", UtilidadesSession.getPais(this).toString());

          DTOEBuscarVinculosJerarquia dtoEB = new DTOEBuscarVinculosJerarquia();
          dtoEB.setOidIdioma(UtilidadesSession.getIdioma(this));
          dtoEB.setOidPais(UtilidadesSession.getPais(this));
          if (!mMarca.equals(""))
              dtoEB.setOidMarca(new Long(mMarca));
          if (!mCanal.equals(""))
              dtoEB.setOidCanal(new Long(mCanal));
          if (!mAcceso.equals(""))
              dtoEB.setOidAcceso(new Long(mAcceso));
          if (!mSubacceso.equals(""))
              dtoEB.setOidSubacceso(new Long(mSubacceso));
          if (!mEmpresa.equals(""))
              dtoEB.setOidEmpresa(new Long(mEmpresa));

          dtoEB.setIndicadorSituacion(new Long(1));
          dtoEB.setTamanioPagina(new Integer(2));

          paramEntrada = new Vector();
          id = new MareBusinessID("SEGBuscarVinculosJerarquia");
      
          paramEntrada.add(dtoEB);
          paramEntrada.add(id);

          traza("ANTES DE CONECTAR: "+dtoEB);
          DruidaConector conectorBuscar = this.conectar( "ConectorBuscarVinculosJerarquia", paramEntrada );
          traza("CONECTO"+conectorBuscar.getXML());

          this.asignar( "LISTADOA", "listado1", conectorBuscar,"dtoSalida.resultado_ROWSET" );

    		  getConfiguracionMenu();


      } else if ( mAccion.equals("detalle") ) {      
          traza("Accion detalle");
    			pagina("contenido_vinculo_jerarquia_insertar");			
  				asignarAtributo( "VAR", "hListaMarca", "valor", conectorParametroLimpia( "hListaMarca", "", true ));
  				asignarAtributo( "VAR", "hListaCanal", "valor", conectorParametroLimpia( "hListaCanal", "", true ));
  				asignarAtributo( "VAR", "hListaAcceso", "valor", conectorParametroLimpia( "hListaAcceso", "", true ));
  				asignarAtributo( "VAR", "hListaSubacceso", "valor", conectorParametroLimpia( "hListaSubacceso", "", true ));
  				asignarAtributo( "VAR", "hListaEmpresa", "valor", conectorParametroLimpia( "hListaEmpresa", "", true ));
  				asignarAtributo( "VAR", "hCasoDeUsoDeta", "valor", conectorParametroLimpia( "hCasoDeUsoDeta", "", true ));
  				asignarAtributo( "VAR", "accion", "valor", mAccion);

    		  getConfiguracionMenu("LPMantenimientoVinculosJerarquia","detalle");

      } else if ( mAccion.equals("insertar") ) {      
             traza("Accion insertar");
            cargaInicialCombos();
    				asignarAtributo( "VAR", "hIdioma", "valor", UtilidadesSession.getIdioma(this).toString());
    				asignarAtributo( "VAR", "casoDeUso", "valor", mCasoDeUso);
            asignarAtributo( "VAR", "hMarca", "valor", UtilidadesSession.getMarcaPorDefecto(this).toString());
            asignarAtributo( "VAR", "hCanal", "valor", UtilidadesSession.getCanalPorDefecto(this).toString());
      			asignarAtributo( "VAR", "hAcceso", "valor", UtilidadesSession.getAccesoPorDefecto(this).toString());
            asignarAtributo( "VAR", "hSubacceso", "valor", UtilidadesSession.getSubaccesoPorDefecto(this).toString());
            asignarAtributo( "VAR", "hEmpresa", "valor", UtilidadesSession.getSociedadPorDefecto(this).toString());
            asignarAtributo( "VAR", "hDefMarca", "valor", UtilidadesSession.getMarcaPorDefecto(this).toString());
            asignarAtributo( "VAR", "hDefCanal", "valor", UtilidadesSession.getCanalPorDefecto(this).toString());
      			asignarAtributo( "VAR", "hDefAcceso", "valor", UtilidadesSession.getAccesoPorDefecto(this).toString());
            asignarAtributo( "VAR", "hDefSubacceso", "valor", UtilidadesSession.getSubaccesoPorDefecto(this).toString());
            asignarAtributo( "VAR", "hDefEmpresa", "valor", UtilidadesSession.getSociedadPorDefecto(this).toString());

      		  getConfiguracionMenu("LPMantenimientoVinculosJerarquia","insertar");

      } else if ( mAccion.equals("eliminar") ) {      
             traza("Accion eliminar");
            cargaInicialCombos();
    				asignarAtributo( "VAR", "hIdioma", "valor", UtilidadesSession.getIdioma(this).toString());
    				asignarAtributo( "VAR", "casoDeUso", "valor", mCasoDeUso);

            /*
            asignarAtributo( "VAR", "hMarca", "valor", UtilidadesSession.getMarcaPorDefecto(this).toString());
            asignarAtributo( "VAR", "hCanal", "valor", UtilidadesSession.getCanalPorDefecto(this).toString());
      			asignarAtributo( "VAR", "hAcceso", "valor", UtilidadesSession.getAccesoPorDefecto(this).toString());
            asignarAtributo( "VAR", "hSubacceso", "valor", UtilidadesSession.getSubaccesoPorDefecto(this).toString());
            asignarAtributo( "VAR", "hEmpresa", "valor", UtilidadesSession.getSociedadPorDefecto(this).toString());
            asignarAtributo( "VAR", "hDefMarca", "valor", UtilidadesSession.getMarcaPorDefecto(this).toString());
            asignarAtributo( "VAR", "hDefCanal", "valor", UtilidadesSession.getCanalPorDefecto(this).toString());
      			asignarAtributo( "VAR", "hDefAcceso", "valor", UtilidadesSession.getAccesoPorDefecto(this).toString());
            asignarAtributo( "VAR", "hDefSubacceso", "valor", UtilidadesSession.getSubaccesoPorDefecto(this).toString());
            asignarAtributo( "VAR", "hDefEmpresa", "valor", UtilidadesSession.getSociedadPorDefecto(this).toString());
            */

      		  getConfiguracionMenu();

      } else if ( mAccion.equals("guardar") ) {  

            pagina("salidaGenerica");
          
            traza("Accion guardar");
            
            DTOEVinculoJerarquia dtoE = new DTOEVinculoJerarquia();
            dtoE.setPrograma(UtilidadesSession.getFuncion(this));
            dtoE.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
            dtoE.setOidPais(UtilidadesSession.getPais(this));
            if (!mMarca.equals(""))
                dtoE.setOidMarca(new Long(mMarca));
            if (!mCanal.equals(""))
                dtoE.setOidCanal(new Long(mCanal));
            if (!mAcceso.equals(""))
                dtoE.setOidAcceso(new Long(mAcceso));
            if (!mSubacceso.equals(""))
                dtoE.setOidSubacceso(new Long(mSubacceso));
            if (!mEmpresa.equals(""))
                dtoE.setOidEmpresa(new Long(mEmpresa));

            paramEntrada = new Vector();
            id = new MareBusinessID("SEGGuardarVinculosJerarquia");
      
            paramEntrada.add(dtoE);
            paramEntrada.add(id);

            traza("ANTES DE CONECTAR: "+dtoE);
            DruidaConector conectorBuscar = this.conectar( "ConectorGuardarVinculosJerarquia", paramEntrada );
            traza("CONECTO");

            asignarAtributo("VAR","ejecutar","valor","persistioOk();");

      }

 
	  }catch (Exception ex){
      
      traza("En error MarcaDef: "+UtilidadesSession.getMarcaPorDefecto(this).toString());
      
      if (mAccion.equals("buscar") && mCasoDeUso.equals("eliminar")) {
          traza("Tratar menú en caso de no existir datos en eliminar");

			}
		  logStackTrace(ex); 

		  this.lanzarPaginaError(ex);
			asignarAtributo("VAR","ejecutarError","valor","ejecucionERROR();");
	  }


	}


  private void cargaInicialCombos() throws Exception{
    traza("Inicio cargaInicialCombos");
		//Preparamos los parametros del subsistema
		ComposerViewElementList cv = crearParametrosEntrada();
		
		//Utilizamos el subsistema
		ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
		conector.ejecucion();
		DruidaConector resultados = conector.getConector();

		traza("resultados: "+resultados.getXML());

		asignar("COMBO", "cbMarca", resultados, "SEGObtenerMarcasSinFiltro");
		asignar("COMBO", "cbCanal", resultados, "SEGObtenerCanalesSinFiltro");
		asignar("COMBO", "cbEmpresa", resultados, "SEGObtenerEmpresasSinFiltro");
    if (UtilidadesSession.getCanalPorDefecto(this) != null) 
      	asignar("COMBO", "cbAcceso", resultados, "SEGObtenerAccesosSinFiltro");
    if (UtilidadesSession.getCanalPorDefecto(this) != null && UtilidadesSession.getAccesoPorDefecto(this) != null )
        asignar("COMBO", "cbSubacceso", resultados, "SEGObtenerSubccesosSinFiltro");

    traza("Fin cargaInicialCombos");

	}

	private ComposerViewElementList crearParametrosEntrada() throws Exception {
		ComposerViewElementList lista = new ComposerViewElementList(); 

    DTOBelcorp dtoBel = new DTOBelcorp();
    //UtilidadesSession sesion = new UtilidadesSession();
    //dtoBel.setOidPais(sesion.getPais(this));
    //dtoBel.setOidIdioma(sesion.getIdioma(this));
    dtoBel.setOidPais(UtilidadesSession.getPais(this));
    dtoBel.setOidIdioma(UtilidadesSession.getIdioma(this));
    traza("DTOBEL: "+dtoBel);
    
		//Primer combo
		ComposerViewElement ci1 = new ComposerViewElement();
		ci1.setIDBusiness("SEGObtenerMarcasSinFiltro");
		ci1.setDTOE(dtoBel);
		ci1.setPosOID((byte)0);
		ci1.setPosDesc((byte)1);

		//Segundo combo
		ComposerViewElement ci2 = new ComposerViewElement();
		ci2.setIDBusiness("SEGObtenerCanalesSinFiltro");
		ci2.setDTOE(dtoBel);
		ci2.setPosOID((byte)0);
		ci2.setPosDesc((byte)1);

		//Tercer combo
    DTOOID dtoEmpre = new DTOOID();
    dtoEmpre.setOid(UtilidadesSession.getPais(this));
		ComposerViewElement ci3 = new ComposerViewElement();
		ci3.setIDBusiness("SEGObtenerEmpresasSinFiltro");
		ci3.setDTOE(dtoEmpre);
		ci3.setPosOID((byte)0);
		ci3.setPosDesc((byte)1);
		
		lista.addViewElement(ci1);
		lista.addViewElement(ci2);
		lista.addViewElement(ci3);


		//Combo accesos
    if (UtilidadesSession.getCanalPorDefecto(this) != null) {
        DTOOID dtoO = new DTOOID();
        dtoO.setOidPais(UtilidadesSession.getPais(this));
        dtoO.setOidIdioma(UtilidadesSession.getIdioma(this));
        dtoO.setOid(UtilidadesSession.getCanalPorDefecto(this));
        
        ComposerViewElement ci4 = new ComposerViewElement();
        ci4.setIDBusiness("SEGObtenerAccesosSinFiltro");
        ci4.setDTOE(dtoO);
        ci4.setPosOID((byte)0);
        ci4.setPosDesc((byte)1);

    		lista.addViewElement(ci4);
    }

    if (UtilidadesSession.getCanalPorDefecto(this) != null && UtilidadesSession.getAccesoPorDefecto(this) != null ) {
        DTOOID dtoO = new DTOOID();
        dtoO.setOidPais(UtilidadesSession.getPais(this));
        dtoO.setOidIdioma(UtilidadesSession.getIdioma(this));
        dtoO.setOid(UtilidadesSession.getAccesoPorDefecto(this));
        
        ComposerViewElement ci5 = new ComposerViewElement();
        ci5.setIDBusiness("SEGObtenerSubccesosSinFiltro");
        ci5.setDTOE(dtoO);
        ci5.setPosOID((byte)0);
        ci5.setPosDesc((byte)1);

    		lista.addViewElement(ci5);
    }
    
		return lista;
	}


	public void logStackTrace(Throwable e) throws Exception {
		traza("Se produjo la excepcion: " + e.getMessage());

		ByteArrayOutputStream pila = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(pila);
		if (e instanceof MareException)
		{
			
			MareException e2=(MareException)e;
			traza("Es una mare Exception con codigo de error: "+e2.getCode());
		
		}
		e.printStackTrace(out);
		traza("stack Trace : " +  pila.toString());
	}


	private void traza(String s) throws Exception {
		super.traza(s);
		System.out.println(s);
	}



}
