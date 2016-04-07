import es.indra.sicc.dtos.inc.DTOPlantilla;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import java.math.BigDecimal;
import es.indra.sicc.logicanegocio.inc.ConstantesINC;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.StringTokenizer;

import es.indra.sicc.dtos.cal.DTOBusqueda;
import es.indra.sicc.dtos.cal.DTOCabecera;
import es.indra.sicc.dtos.cal.DTODetalle;
import es.indra.sicc.dtos.cal.DTORedirigirDetalle;
import es.indra.sicc.dtos.cal.DTOCliente;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;

public class LPMantenimientoPlantilla extends LPSICCBase {	

    public LPMantenimientoPlantilla () { super(); }

	private String accion = null;
	private String opcionMenu = null;
	private String oidPlantilla = null;

	private String sPais = null;     
	private String sIdioma = null;

	private boolean estaCargadaTiposCalificacion;
	private boolean estaCargadaTiposVenta;

	private Long cteBaseCalculoMonto = null;
	private Long cteDirigidoAConsultora = null;
	private Long cteBaseCalculoNumeroPedidos = null;

	private String nombreplantilla = null;
	private String arraypaises = null;
	private String arraymarcas = null;
	private String canal = null;
	private String arrayaccesos = null;
	private String multinivel = null;
	private String fasecalificacion = null;
	private String tipocalificacion = null;
	private String incremental = null;
	private String dirigido = null;
	private String basecalculo = null;
	private String programanuevas = null;
	private String tipoventas = null;
	private String ambitogeografico = null;
	private String participacionparticipantes = null;
	private String productosvalidos = null;
	private String productosexcluidos = null;
	private String productosbonificados = null;
	private String productosexigidos = null;
	private String premiosacumulativos = null;
	private String nivelesrotativos = null;
	private String premioselectivos = null;
	private String puntajeservicio = null;
	private String activa = null;
	private String tipoconcurso = null;
	private String bloqueado = null;
	// vbongiov -- Cambio 20080811 -- 26/08/2009
	private String sorteo = null;

	public void inicio() throws Exception {     }
  
    public void ejecucion() throws Exception {
		setTrazaFichero();

	    sPais = UtilidadesSession.getPais(this).toString();
		sIdioma = UtilidadesSession.getIdioma(this).toString();
	    
		try  {
			traza("*********** Entre a LPMantenimientoPlantilla ");
			accion = conectorParametroLimpia("accion", "", true);
			opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
			traza(" **** accion : " + accion);
			traza(" **** opcionMenu : " + opcionMenu);
			
			if (accion.equals("")) {
				inicializar(); 
			}
			else {
				if (accion.equals("guardar")) {
					guardar();
				}
				else {
					if (accion.equals("modificar")) {
						modificarPlantilla();
					}
					else {
						if (accion.equals("detalle")) {
							consultarPlantilla();
						}
					}
				}
			}
			cargarMenuSecundario();
			
		}
		catch ( Exception e )  {
			if(opcionMenu.equals("InsertarPlantilla")) {
				preservaHiddensI18n(new Integer(1), "INC_PLANT_CONCU", "frmFormulario", "txtNombrePlantilla", false);
			}
			
            e.printStackTrace();
			traza("Exception en LPMantenimientoPlantilla");
			traza(e);
			lanzarPaginaError(e);
	    }
	}

	private void cargarConstantes() throws Exception {
		traza("*********** Entre a cargarConstantes - LPMantenimientoPlantilla");
		asignarAtributo("VAR", "OID_TIPO_CALIF_PROYECTADA", "valor", 
			ConstantesINC.OID_TIPO_CALIF_PROYECTADA.toString());

		asignarAtributo("VAR", "OID_DIRIGIDO_A_GERENTE", "valor", 
			ConstantesINC.OID_DIRIGIDO_A_GERENTE.toString());
	}

    public void inicializar() throws Exception {
		traza("*********** Entre a inicializar - LPMantenimientoPlantilla");

		opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
		traza(" **** opcionMenu : " + opcionMenu);
		
		if (opcionMenu.equals("InsertarPlantilla")) {
			cargarPGInsertarPlantilla();
			anyadeHiddensI18N(true, "INC_PLANT_CONCU", null, new Integer(1), "frmFormulario", "txtNombrePlantilla", false);
		}
		else {
	 		if (opcionMenu.equals("ModificarPlantilla") || opcionMenu.equals("ConsultarPlantilla") || opcionMenu.equals("EliminarPlantilla")) {
			cargarPGBuscarPlantilla();
			anyadeHiddensI18N(true, "INC_PLANT_CONCU", null, new Integer(1), "frmFormulario", "txtNombrePlantilla", false);
			}
		}
	}

    public void cargarPGInsertarPlantilla() throws Exception {
	    traza("*********** Entre a cargarPGInsertarPlantilla - LPMantenimientoPlantilla");
		pagina("contenido_plantilla_concurso_insertar");       

	    traza("*********** Llamando a cargarConstantes");
		cargarConstantes();
		
		traza("*********** opcionMenu " + opcionMenu);
		traza("*********** accion " + accion);
		traza("*********** sPais " + sPais);
		traza("*********** sIdioma " + sIdioma);

		asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
		asignarAtributo("VAR", "accion", "valor", accion);
		asignarAtributo("VAR", "oidPais", "valor", sPais);
		asignarAtributo("VAR", "oidIdioma", "valor", sIdioma);

		DTOBelcorp dtoe = new DTOBelcorp();

		dtoe.setOidPais(new Long(sPais));
		dtoe.setOidIdioma(new Long(sIdioma));

		ComposerViewElementList lista = new ComposerViewElementList();
		ComposerViewElement composer1 = new ComposerViewElement();
		ComposerViewElement composer2 = new ComposerViewElement();
		ComposerViewElement composer3 = new ComposerViewElement();
		ComposerViewElement composer4 = new ComposerViewElement();
		ComposerViewElement composer5 = new ComposerViewElement();
		ComposerViewElement composer6 = new ComposerViewElement();

		composer1.setIDBusiness("MENConsultaPaises");
		composer1.setDTOE(dtoe);

		lista.addViewElement(composer1);

		composer2.setIDBusiness("SEGConsultaCanales");
		composer2.setDTOE(dtoe);

		lista.addViewElement(composer2);

		composer3.setIDBusiness("SEGConsultaMarcas");
		composer3.setDTOE(dtoe);

		lista.addViewElement(composer3);

		composer4.setIDBusiness("INCConsultaDirigidoA");
		composer4.setDTOE(dtoe);

		lista.addViewElement(composer4);

		composer5.setIDBusiness("INCConsultaBasesCalculo");
		composer5.setDTOE(dtoe);

		lista.addViewElement(composer5);

		composer6.setIDBusiness("INCConsultaTiposConcursoIVR");
		composer6.setDTOE(dtoe);

		lista.addViewElement(composer6);

		ConectorComposerView conector = new ConectorComposerView(lista,this.getRequest());

		traza("*********** Antes de llamar a ejecucion");
		conector.ejecucion();
	    traza("*********** Despues de llamar a ejecucion");

		DruidaConector con = conector.getConector();
		asignar("COMBO", "cbPais", con, "MENConsultaPaises");
		asignar("COMBO", "cbCanal", con, "SEGConsultaCanales");
		asignar("COMBO", "cbMarca", con, "SEGConsultaMarcas");
		asignar("COMBO", "cbDirigidoA", con, "INCConsultaDirigidoA");
		asignar("COMBO", "cbBaseCalculo", con, "INCConsultaBasesCalculo");
		asignar("COMBO", "cbTipoConcursoIVR", con, "INCConsultaTiposConcursoIVR");

		//Por defecto se chequean los siguientes checkbox:
		//- chkAmbitoGeografico 
		//- chkParticipacionParticipantesComp 
		//- chkProductosValidos 
		//- chkPremiosAcumulativosPorNivel 
		asignarAtributo("CHECKBOX", "ckAmbitoGeograficoCompleto", "check", "S");
		asignarAtributo("CHECKBOX", "ckParticipacionParticipantesCompleto", "check", "S");
		asignarAtributo("CHECKBOX", "ckProductosValidosCompleto", "check", "S");
		asignarAtributo("CHECKBOX", "ckPremiosAcumulativosPorNiveles", "check", "S");

		//Por defecto se deshabilitan los siguientes campos:
		//- cbTipoVenta 
		//- cbTipoCalificacion 
		//- chkIncremental 
		asignarAtributo("VAR", "estaCargadaTiposVenta", "valor", "false");
		asignarAtributo("VAR", "estaCargadaTiposCalificacion", "valor", "false");

		asignarAtributo("VAR", "cteBaseCalculoMonto", "valor", ConstantesINC.OID_BASE_CALCULO_MONTO.toString());
		asignarAtributo("VAR", "cteDirigidoAConsultora", "valor", ConstantesINC.OID_DIRIGIDO_A_CONSULTORAS.toString());
		asignarAtributo("VAR", "cteBaseCalculoNumeroPedidos", "valor", ConstantesINC.OID_BASE_CALCULO_NPEDIDOS.toString());

        // vbongiov -- Cambio 20080811 -- 26/08/2009
		asignarAtributo("VAR", "OID_TIPO_CONCURSO_VENTAS", "valor", ConstantesINC.OID_TIPO_CONCURSO_VENTAS.toString());
	}
	
    public void cargarPGBuscarPlantilla() throws Exception {
		traza("*********** Entre a cargarPGBuscarPlantilla - LPMantenimientoPlantilla ");
		pagina("contenido_plantilla_concurso_modificar");        		
        this.getFormatosValidaciones();

		DTOBelcorp dtoe = new DTOBelcorp();

		dtoe.setOidPais(new Long(sPais));
		dtoe.setOidIdioma(new Long(sIdioma));

		ComposerViewElementList lista = new ComposerViewElementList();
		ComposerViewElement composer1 = new ComposerViewElement();
		ComposerViewElement composer2 = new ComposerViewElement();
		ComposerViewElement composer3 = new ComposerViewElement();

		composer1.setIDBusiness("MENConsultaPaises");
		composer1.setDTOE(dtoe);

		lista.addViewElement(composer1);

		composer2.setIDBusiness("SEGConsultaCanales");
		composer2.setDTOE(dtoe);

		lista.addViewElement(composer2);

		composer3.setIDBusiness("SEGConsultaMarcas");
		composer3.setDTOE(dtoe);

		lista.addViewElement(composer3);

		ConectorComposerView conector = new ConectorComposerView(lista,this.getRequest());
		conector.ejecucion();

		DruidaConector con = conector.getConector();

		asignar("COMBO", "cbPais", con, "MENConsultaPaises");
		asignar("COMBO", "cbCanal", con, "SEGConsultaCanales");
		asignar("COMBO", "cbMarca", con, "SEGConsultaMarcas");

		asignarAtributo("VAR", "accion", "valor", accion);
		asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
		asignarAtributo("VAR", "oidPais", "valor", sPais);
		asignarAtributo("VAR", "oidIdioma", "valor", sIdioma);

		/*Mostrar la página PGInsertarPlantilla pasándole además: 
		- accion 
		- opcionMenu */
	}

    public void guardar() throws Exception {
		traza("*********** Entre a guardar - LPMantenimientoPlantilla ");
		pagina("salidaGenerica");

		DTOPlantilla dtoe = crearDTOPlantilla();

		//Vector trad = recuperaTraduccionesI18N(new Integer(1));
  	    MareBusinessID businessID = new MareBusinessID("INCActualizarPlantilla");
		Vector parametros = new Vector();
		parametros.add(dtoe);
		parametros.add(businessID);

		try {
	        traza("******************* Entrando al try...");
	        traza("******************* Antes de conectar");
			DruidaConector con = conectar("ConectorActualizarPlantilla", parametros);
			traza("******************* Despues de conectar");

	        if(opcionMenu.equals("InsertarPlantilla")) {
		      traza("********** Ejecutar llama a reInicio");
			  asignarAtributo("VAR","ejecutar","valor","reInicio()");
	        }
		    else {
			  traza("********** Ejecutar llama a reModifica");
	          asignarAtributo("VAR","ejecutar","valor","reModifica();");
		    }        
      }
      catch(Exception e) {
        traza("******************* Entrando al catch...");
        if(opcionMenu.equals("InsertarPlantilla")) {
               asignarAtributo("VAR", "ejecutarError", "valor", "fErrorAlGuardarI()");
        }
        else {
          asignarAtributo("VAR", "ejecutarError", "valor", "fErrorAlGuardarM()");
        }  
        throw e;
      }     
	}

    public DTOPlantilla crearDTOPlantilla() throws Exception {
		traza("*********** Entre a | - LPMantenimientoPlantilla ");
		
		accion = conectorParametroLimpia("accion", "", true);
		opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
		traza("*********** accion " + accion);
		traza("*********** opcionMenu " + opcionMenu);

		DTOPlantilla dto = new DTOPlantilla();
		oidPlantilla = conectorParametroLimpia("oidPlantilla", "", true);
		traza("*********** oidPlantilla " + oidPlantilla);
		
		if (opcionMenu.equals("InsertarPlantilla")) {
			traza("*********** Seteando oid a null");
			dto.setOidPlantilla(null);
			traza("*********** setAttriTraducible");
			dto.setAttriTraducible(this.recuperaTraduccionesI18N(new Integer(1)));
			traza("******** Valor recuperaTraduccionesI18N " + this.recuperaTraduccionesI18N(new Integer(1)).toString());
		}
		else {
			traza("*********** Seteando oid");
			dto.setOidPlantilla(new Long(oidPlantilla));
			traza("*********** setAttriTraducible");
			dto.setAttriTraducible(this.recuperaTraduccionesI18N(new Integer(1)));
		}		

		nombreplantilla = conectorParametroLimpia("nombreplantilla", "", true);
		arraypaises = conectorParametroLimpia("arraypaises", "", true);
		arraymarcas = conectorParametroLimpia("arraymarcas", "", true);
		canal = conectorParametroLimpia("canal", "", true);
		arrayaccesos = conectorParametroLimpia("arrayaccesos", "", true);
		multinivel = conectorParametroLimpia("multinivel", "", true);
		fasecalificacion = conectorParametroLimpia("fasecalificacion", "", true);
		tipocalificacion = conectorParametroLimpia("tipocalificacion", "", true);
		incremental = conectorParametroLimpia("incremental", "", true);
		dirigido = conectorParametroLimpia("dirigido", "", true);
		basecalculo = conectorParametroLimpia("basecalculo", "", true);
		programanuevas = conectorParametroLimpia("programanuevas", "", true);
		tipoventas = conectorParametroLimpia("tipoventas", "", true);
		ambitogeografico = conectorParametroLimpia("ambitogeografico", "", true);
		participacionparticipantes = conectorParametroLimpia("participacionparticipantes", "", true);
		productosvalidos = conectorParametroLimpia("productosvalidos", "", true);
		productosexcluidos = conectorParametroLimpia("productosexcluidos", "", true);
		productosbonificados = conectorParametroLimpia("productosbonificados", "", true);
		productosexigidos = conectorParametroLimpia("productosexigidos", "", true);
		premiosacumulativos = conectorParametroLimpia("premiosacumulativos", "", true);
		nivelesrotativos = conectorParametroLimpia("nivelesrotativos", "", true);
		premioselectivos = conectorParametroLimpia("premioselectivos", "", true);
		puntajeservicio = conectorParametroLimpia("puntajeservicio", "", true);
		activa = conectorParametroLimpia("activa", "", true);
		tipoconcurso = conectorParametroLimpia("tipoconcurso", "", true);
	    // vbongiov -- Cambio 20080811 -- 26/08/2009
        sorteo = conectorParametroLimpia("sorteo", "", true);
		bloqueado = conectorParametroLimpia("bloqueado", "", true);

		traza("******** nombreplantilla " + nombreplantilla);
		traza("******** arraypaises " + arraypaises);
		traza("******** arraymarcas " + arraymarcas);
		traza("******** canal " + canal);
		traza("******** arrayaccesos " + arrayaccesos);
		traza("******** multinivel " + multinivel);
		traza("******** fasecalificacion " + fasecalificacion);
		traza("******** tipocalificacion " + tipocalificacion);
		traza("******** incremental " + incremental);
		traza("******** dirigido " + dirigido);
		traza("******** basecalculo " + basecalculo);
		traza("******** programanuevas " + programanuevas);
		traza("******** tipoventas " + tipoventas);
		traza("******** ambitogeografico " + ambitogeografico);
		traza("******** participacionparticipantes " + participacionparticipantes);
		traza("******** productosvalidos " + productosvalidos);
		traza("******** productosexcluidos " + productosexcluidos);
		traza("******** productosbonificados " + productosbonificados);
		traza("******** productosexigidos " + productosexigidos);
		traza("******** premiosacumulativos " + premiosacumulativos);
		traza("******** nivelesrotativos " + nivelesrotativos);
		traza("******** premioselectivos " + premioselectivos);
		traza("******** puntajeservicio " + puntajeservicio);
		traza("******** activa " + activa);
		traza("******** tipoconcurso " + tipoconcurso);
		traza("******** sorteo " + sorteo);
    traza("******** bloqueado " + bloqueado);
    
    
    
    //1° Seteando oids de paises
		StringTokenizer stPaises = new StringTokenizer(arraypaises,",");
		ArrayList listaPaises = new ArrayList();
        int i = 0;      
        while(stPaises.hasMoreTokens()) {
          String elementoI = stPaises.nextToken();
          traza("************ elementoI: " + elementoI);
          Long elem = new Long(elementoI);
          traza("************ elem: " + elem);
		  listaPaises.add(i,elem);
          i++;
        }
		dto.setOidPaises(listaPaises);

		//2° Seteando oids de marcas
		StringTokenizer stMarcas = new StringTokenizer(arraymarcas,",");
		ArrayList listaMarcas = new ArrayList();
        int j = 0;      
        while(stMarcas.hasMoreTokens()) {
          String elementoI = stMarcas.nextToken();
          traza("************ elementoI: " + elementoI);
          Long elem = new Long(elementoI);
          traza("************ elem: " + elem);
		  listaMarcas.add(j,elem);
          j++;
        }
		dto.setOidMarcas(listaMarcas);

		//3° Seteando oid de canal
		dto.setOidCanal(new Long(canal));

		//4° Seteando oids de accesos
		StringTokenizer stAccesos = new StringTokenizer(arrayaccesos,",");
		ArrayList listaAccesos = new ArrayList();
        int k = 0;      
        while(stAccesos.hasMoreTokens()) {
          String elementoI = stAccesos.nextToken();
          traza("************ elementoI: " + elementoI);
          Long elem = new Long(elementoI);
          traza("************ elem: " + elem);
		  listaAccesos.add(k,elem);
          k++;
        }
		dto.setOidAccesos(listaAccesos);

		//5° Seteando Multinivel
		if(multinivel.equals("S")) {
			dto.setIndMultinivel(new Boolean(true));
		}
		else {
			dto.setIndMultinivel(new Boolean(false));
		}

		//6° Seteando Fase calificacion
		if(fasecalificacion.equals("S")) {
			dto.setIndFaseCalificacion(new Boolean(true));
		}
		else {
			dto.setIndFaseCalificacion(new Boolean(false));
		}

		//7° Seteando Tipo calificacion
		if(!tipocalificacion.equals("")) dto.setOidTipoCalificacion(new Long(tipocalificacion));

		//8° Seteando Incremental
		if(incremental.equals("S")) {
			dto.setIndIncremental(new Boolean(true));
		}
		else {
			if(incremental.equals("N")) {
				dto.setIndIncremental(new Boolean(false));
			}
			else {
				dto.setIndIncremental(null);
			}
		}

		//9° Seteando dirigido
		dto.setOidDirigidoA(new Long(dirigido));

		//10° Seteando Base de calculo
		if(!basecalculo.equals("")) dto.setOidBaseCalculo(new Long(basecalculo));

		//11° Seteando Programas nuevas
		if(programanuevas.equals("S")) {
			dto.setIndProgramaNuevas(new Boolean(true));
		}
		else {
			dto.setIndProgramaNuevas(new Boolean(false));
		}

		//12° Seteando tipo de ventas
		if(!tipoventas.equals("")) dto.setOidTipoVenta(new Long(tipoventas));

		//13° Seteando Ambito geografico
		if(ambitogeografico.equals("S")) {
			dto.setIndAmbitoGeografico(new Boolean(true));
		}
		else {
			dto.setIndAmbitoGeografico(new Boolean(false));
		}

		//14° Seteando participacion participantes
		if(participacionparticipantes.equals("S")) {
			dto.setIndPartParticipantesCompleto(new Boolean(true));
		}
		else {
			dto.setIndPartParticipantesCompleto(new Boolean(false));
		}

		//15° Seteando indicador productos validos
		if(productosvalidos.equals("S")) {
			dto.setIndProductosValidos(new Boolean(true));
		}
		else {
			dto.setIndProductosValidos(new Boolean(false));
		}

		//16° Seteando productos excluidos
		if(productosexcluidos.equals("S")) {
			dto.setIndProductosExcluidos(new Boolean(true));
		}
		else {
			dto.setIndProductosExcluidos(new Boolean(false));
		}

		//17° Seteando productos bonificados
		if(productosbonificados.equals("S")) {
			dto.setIndProductosBonificados(new Boolean(true));
		}
		else {
			dto.setIndProductosBonificados(new Boolean(false));
		}

		//18° Seteando productos exigidos
		if(productosexigidos.equals("S")) {
			dto.setIndProductosExigidos(new Boolean(true));
		}
		else {
			dto.setIndProductosExigidos(new Boolean(false));
		}

		//19° Seteando premios acumulativos
		if(premiosacumulativos.equals("S")) {
			dto.setIndPremiosAcumuPorNiveles(new Boolean(true));
		}
		else {
			dto.setIndPremiosAcumuPorNiveles(new Boolean(false));
		}

		//20° Seteando niveles rotativos
		if(nivelesrotativos.equals("S")) {
			dto.setIndNivelesRotativos(new Boolean(true));
		}
		else {
			dto.setIndNivelesRotativos(new Boolean(false));
		}

		//21° Seteando premios electivos
		if(premioselectivos.equals("S")) {
			dto.setIndPremiosElectivos(new Boolean(true));
		}
		else {
			dto.setIndPremiosElectivos(new Boolean(false));
		}

		//22° Seteando puntaje servicio
		if(puntajeservicio.equals("S")) {
			dto.setIndPuntajeServicio(new Boolean(true));
		}
		else {
			dto.setIndPuntajeServicio(new Boolean(false));
		}

		//23° Seteando indicador activa
		if(activa.equals("S")) {
			dto.setIndActiva(new Boolean(true));
		}
		else {
			dto.setIndActiva(new Boolean(false));
		}
    
		//24° Seteando tipo concurso
		if(!tipoconcurso.equals("")) dto.setOidTipoConcursoIVR(new Long(tipoconcurso));

		//25° Seteando indicador activa
		if(sorteo.equals("S")) {
			dto.setIndSorteo(new Boolean(true));
		}
		else {
			dto.setIndSorteo(new Boolean(false));
		}
    
    
    //jsilva
    //INC BELC300022480
    //26° Seteando indicador bloqueado
    if(bloqueado.equals("S")) {
			dto.setIndBloqueado(new Boolean(true));
		}else{
      dto.setIndBloqueado(new Boolean(false));
		}
    
    return dto;
	
  }

    public void modificarPlantilla() throws Exception {
		traza("*********** Entre a modificarPlantilla - LPMantenimientoPlantilla ");
		oidPlantilla = conectorParametroLimpia("oidPlantilla", "", true);
		DTOPlantilla dto = obtenerPlantilla();
		cargarPGInsertarPlantilla();
		mostrarDatosPlantilla(dto);

		//Deshabilitar el campo txtNumeroPlantilla
	}

    public DTOPlantilla obtenerPlantilla() throws Exception {
		traza("*********** Entre a obtenerPlantilla - LPMantenimientoPlantilla ");
		DTOOID dto = new DTOOID();
		dto.setOid(new Long(oidPlantilla));
		dto.setOidIdioma(new Long(sIdioma));

		MareBusinessID businessID = new MareBusinessID("INCObtenerPlantilla");
		Vector parametros = new Vector();
		parametros.add(dto);
		parametros.add(businessID);

		traza("******** Antes de conectar");
		DruidaConector con = conectar("ConectorObtenerPlantilla", parametros);
		traza("******** Despues de conectar");

		DTOPlantilla dsal = (DTOPlantilla)con.objeto("dtoPlantilla");
		return dsal;
	}

    public void mostrarDatosPlantilla(DTOPlantilla DTOE) throws Exception {
      traza("*********** Entre a mostrarDatosPlantilla - LPMantenimientoPlantilla ");
	  Vector atributos = null;
	  ArrayList paises = new ArrayList();
  	  ArrayList marcas = new ArrayList();
   	  ArrayList accesos = new ArrayList();

	  traza("*********** DTOE " + DTOE);

      //1° Recupero oid
	  traza("*********** Obteniendo oidPlantilla");
	  oidPlantilla = new String(DTOE.getOidPlantilla().toString());


	  //2° Recupero nombre de plantilla
   	  traza("*********** Obteniendo nombrePlantilla");
	  if(opcionMenu.equals("ModificarPlantilla")) {
		this.anyadeHiddensI18N(true,"INC_PLANT_CONCU",DTOE.getOidPlantilla(),new Integer(1),"frmFormulario","txtNombrePlantilla",false);
	  }
	  else {
		this.anyadeHiddensI18N(true,"INC_PLANT_CONCU",DTOE.getOidPlantilla(),new Integer(1),"frmFormulario","txtNombrePlantilla",true);
	  }	  

	  Long idiomaSesion = UtilidadesSession.getIdioma(this);
	  atributos = DTOE.getAttriTraducible();
	  for(int i=0; i<atributos.size(); i++) {
	  	  DTOI18nSICC i18 =(DTOI18nSICC) atributos.get(i);

		  Long idiomaDTO = i18.getOidIdioma();

		  if(idiomaDTO.longValue() == idiomaSesion.longValue()) {
		 	  nombreplantilla = i18.getValorI18n();
		  }
	  }

	  //3° Recupero oids de paises
   	  traza("*********** Obteniendo paises");
	  paises = DTOE.getOidPaises();
	  for(int i=0; i< paises.size(); i++) {
		if(i==0) {
			Long temp = (Long)paises.get(i);
			arraypaises = temp.toString();;
		}
		else {
			Long temp = (Long)paises.get(i);
			arraypaises = arraypaises + ',' + temp.toString();
		}		
	  }


	  //4° Recupero oids de marcas
   	  traza("*********** Obteniendo marcas");
	  marcas = DTOE.getOidMarcas();
	  for(int i=0; i< marcas.size(); i++) {
		if(i==0) {
			Long temp = (Long)marcas.get(i);
			arraymarcas = temp.toString();
		}
		else {
			Long temp = (Long)marcas.get(i);
			arraymarcas = arraymarcas + ',' + temp.toString();
		}		
	  }


	  //5° Recupero oid de canal
   	  traza("*********** Obteniendo canal");
	  canal = new String(DTOE.getOidCanal().toString());


	  //6° Recupero oids de accesos
   	  traza("*********** Obteniendo accesos");
	  accesos = DTOE.getOidAccesos();
	  for(int i=0; i< accesos.size(); i++) {
		if(i==0) {
			Long temp = (Long)accesos.get(i);
			arrayaccesos = temp.toString();
		}
		else {
			Long temp = (Long)accesos.get(i);
			arrayaccesos = arrayaccesos + ',' + temp.toString();
		}		
	  }  


	  //7° Recupero indicador multinivel
  	  traza("*********** Obteniendo multinivel");
	  if(DTOE.getIndMultinivel().booleanValue()==true) {
		multinivel = "S";
	  }
	  else {
		multinivel = "N";
	  }


	  //8° Recupero indicador fase calificacion
  	  traza("*********** Obteniendo fase calificacion");
	  if(DTOE.getIndFaseCalificacion().booleanValue()==true) {
		fasecalificacion = "S";
	  }
	  else {
		fasecalificacion = "N";
	  }


	  //9° Recupero oid tipo calificacion
   	  traza("*********** Obteniendo tipo calificacion");
	  if(DTOE.getOidTipoCalificacion()!=null) {
		  tipocalificacion = new String(DTOE.getOidTipoCalificacion().toString());
	  }
	  else {
		tipocalificacion = "";
	  }




	  //10° Recupero indicador incremental
   	  traza("*********** Obteniendo incremental");
	  if(DTOE.getIndIncremental().booleanValue()==true) {
		incremental = "S";
	  }
	  else {
		incremental = "N";
	  }


	  //11° Recupero oid dirigido a 
   	  traza("*********** Obteniendo dirigido a");
	  dirigido = new String(DTOE.getOidDirigidoA().toString());


	  //12° Recupero oid base de calculo
   	  traza("*********** Obteniendo base de calculo");	 
	  if(DTOE.getOidBaseCalculo()!=null) {
		basecalculo = new String(DTOE.getOidBaseCalculo().toString());
	  }
	  else {
		basecalculo = "";
	  }
	  
	  //13° Recupero indicador programa nuevas 
   	  traza("*********** Obteniendo programa nuevas");
	  if(DTOE.getIndProgramaNuevas().booleanValue()==true) {
	   programanuevas = "S";
	  }
	  else {
	  	programanuevas = "N";
	  }
	  
	  
	  //14° Recupero oid tipo venta
   	  traza("*********** Obteniendo tipo ventas");
	  if(DTOE.getOidTipoVenta()!=null) {
		  tipoventas = new String(DTOE.getOidTipoVenta().toString());
	  }
	  else {
		  tipoventas = "";
	  }	  
	  
	  //15° Recupero indicador ambito geografico
   	  traza("*********** Obteniendo ambito geografico");
	  if(DTOE.getIndAmbitoGeografico().booleanValue()==true) {
		ambitogeografico = "S";
	  }
	  else {
		ambitogeografico = "N";
	  }
	  
	  
	  //16° Recupero indicador participacion participantes
  	  traza("*********** Obteniendo participacion participantes");
	  if(DTOE.getIndPartParticipantesCompleto().booleanValue()==true) {
		participacionparticipantes = "S";
	  }
	  else {
		participacionparticipantes = "N";
	  }
	  
	  
	  //17° Recupero indicador productos validos
   	  traza("*********** Obteniendo productos validos");
	  if(DTOE.getIndProductosValidos().booleanValue()==true) {
		productosvalidos = "S";
	  }
	  else {
		productosvalidos = "N";
	  }
	  
	  
	  //18° Recupero indicador productos excluidos
   	  traza("*********** Obteniendo productos excluidos");
	  if(DTOE.getIndProductosExcluidos().booleanValue()==true) {
		productosexcluidos = "S";
	  }
	  else {
		productosexcluidos = "N";
	  }
	  
	  
	  //19° Recupero indicador productos bonificados
   	  traza("*********** Obteniendo productos bonificados");
	  if(DTOE.getIndProductosBonificados().booleanValue()==true) {
		productosbonificados = "S";
	  }
	  else {
		productosbonificados = "N";
	  }
	  
	  
	  //20° Recupero indicador productos exigidos
   	  traza("*********** Obteniendo productos exigidos");
	  if(DTOE.getIndProductosExigidos().booleanValue()==true) {
		productosexigidos = "S";
	  }
	  else {
		productosexigidos = "N";
	  }
	  
	  
	  //21° Recupero indicador premios acumulativos
  	  traza("*********** Obteniendo premios acumulativos");
	  if(DTOE.getIndPremiosAcumuPorNiveles().booleanValue()==true) {
		premiosacumulativos = "S";
	  }
	  else {
		premiosacumulativos = "N";
	  }
	  
	  
	  //22° Recupero indicador niveles rotativos
   	  traza("*********** Obteniendo niveles rotativos");
	  if(DTOE.getIndNivelesRotativos().booleanValue()==true) {
		nivelesrotativos = "S";
	  }
	  else {
		nivelesrotativos = "N";
	  }
	  
	  
	  //23° Recupero indicador premios electivos
   	  traza("*********** Obteniendo premios electivos");
	  if(DTOE.getIndPremiosElectivos().booleanValue()==true) {
		premioselectivos = "S";
	  }
	  else {
		premioselectivos = "N";
	  }
	  
	  
	  //24° Recupero indicador puntaje servicio
   	  traza("*********** Obteniendo puntaje servicio");
 	  if(DTOE.getIndPuntajeServicio().booleanValue()==true) {
		puntajeservicio = "S";
	  }
	  else {
		puntajeservicio = "N";
	  }
	  
	  
	  //25° Recupero indicador activa
   	  traza("*********** Obteniendo activa");
	  if(DTOE.getIndActiva().booleanValue()==true) {
		activa = "S";
	  }
	  else {
		activa = "N";
	  }
	  
	  
	  //26° Recupero oid de tipo concurso
   	  traza("*********** Obteniendo tipo concurso");
	  if(DTOE.getOidTipoConcursoIVR()!=null) {
		  tipoconcurso = new String(DTOE.getOidTipoConcursoIVR().toString());
	  }
	  else {
		tipoconcurso = "";
	  }

      // vbongiov -- Cambio 20080811 -- 26/08/2009
	  traza("*********** Obteniendo sorteo");
	  if(DTOE.getIndSorteo() != null && DTOE.getIndSorteo().booleanValue()==true) {
		sorteo = "S";
	  }
	  else {
		sorteo = "N";
	  }


	  //28° Recupero indicador bloqueado
   	  traza("*********** Obteniendo bloqueado");
	  if(DTOE.getIndBloqueado()!=null) {
		if(DTOE.getIndBloqueado().booleanValue()==true) {
		  bloqueado = "S";
		}
		else {
		  bloqueado = "N";
		}
	  }
	  else {
		  bloqueado = "";
	  }


      traza("*********** oidPlantilla " + oidPlantilla);
	  traza("*********** nombreplantilla " + nombreplantilla);
	  traza("*********** arraypaises " + arraypaises);
	  traza("*********** arraymarcas " + arraymarcas);
	  traza("*********** canal " + canal);
      traza("*********** arrayaccesos " + arrayaccesos);
	  traza("*********** multinivel " + multinivel);
	  traza("*********** fasecalificacion " + fasecalificacion);
	  traza("*********** tipocalificacion " + tipocalificacion);
	  traza("*********** incremental " + incremental);
      traza("*********** dirigido " + dirigido);
	  traza("*********** basecalculo " + basecalculo);
	  traza("*********** programanuevas " + programanuevas);
	  traza("*********** tipoventas " + tipoventas);
	  traza("*********** ambitogeografico " + ambitogeografico);
      traza("*********** participacionparticipantes " + participacionparticipantes);
	  traza("*********** productosvalidos " + productosvalidos);
	  traza("*********** productosexcluidos " + productosexcluidos);
	  traza("*********** productosbonificados " + productosbonificados);
	  traza("*********** productosexigidos " + productosexigidos);
      traza("*********** premiosacumulativos " + premiosacumulativos);
	  traza("*********** nivelesrotativos " + nivelesrotativos);
	  traza("*********** premioselectivos " + premioselectivos);
	  traza("*********** puntajeservicio " + puntajeservicio);
	  traza("*********** activa " + activa);
  	  traza("*********** tipoconcurso " + tipoconcurso);
      traza("*********** sorteo " + sorteo);
 	  traza("*********** bloqueado " + bloqueado);

	  asignarAtributo("VAR", "oidPlantilla", "valor", oidPlantilla);
 	  asignarAtributo("VAR", "nombreplantilla", "valor", nombreplantilla);
	
	  if(arraypaises!=null) {
	  	  asignarAtributo("VAR", "arraypaises", "valor", arraypaises);
	  }
	  else {
		  asignarAtributo("VAR", "arraypaises", "valor", "");
	  }

  	  asignarAtributo("VAR", "arraymarcas", "valor", arraymarcas);
  	  asignarAtributo("VAR", "canal", "valor", canal);
  	  asignarAtributo("VAR", "arrayaccesos", "valor", arrayaccesos);
 	  asignarAtributo("VAR", "multinivel", "valor", multinivel);
  	  asignarAtributo("VAR", "fasecalificacion", "valor", fasecalificacion);
  	  asignarAtributo("VAR", "tipocalificacion", "valor", tipocalificacion);
  	  asignarAtributo("VAR", "incremental", "valor", incremental);
 	  asignarAtributo("VAR", "dirigido", "valor", dirigido);
 	  asignarAtributo("VAR", "basecalculo", "valor", basecalculo);
 	  asignarAtributo("VAR", "programanuevas", "valor", programanuevas);
  	  asignarAtributo("VAR", "tipoventas", "valor", tipoventas);
  	  asignarAtributo("VAR", "ambitogeografico", "valor", ambitogeografico);
  	  asignarAtributo("VAR", "participacionparticipantes", "valor", participacionparticipantes);
 	  asignarAtributo("VAR", "productosvalidos", "valor", productosvalidos);
  	  asignarAtributo("VAR", "productosexcluidos", "valor", productosexcluidos);
  	  asignarAtributo("VAR", "productosbonificados", "valor", productosbonificados);
  	  asignarAtributo("VAR", "productosexigidos", "valor", productosexigidos);	  
  	  asignarAtributo("VAR", "premiosacumulativos", "valor", premiosacumulativos);
  	  asignarAtributo("VAR", "nivelesrotativos", "valor", nivelesrotativos);
 	  asignarAtributo("VAR", "premioselectivos", "valor", premioselectivos);
  	  asignarAtributo("VAR", "puntajeservicio", "valor", puntajeservicio);
  	  asignarAtributo("VAR", "activa", "valor", activa);
  	  asignarAtributo("VAR", "tipoconcurso", "valor", tipoconcurso);	  
	  // vbongiov -- Cambio 20080811 -- 26/08/2009
	  asignarAtributo("VAR", "sorteo", "valor", sorteo);	

	  asignarAtributo("VAR", "bloqueado", "valor", bloqueado);	  
	}
 

    public void consultarPlantilla() throws Exception {
		traza("*********** Entre a consultarPlantilla - LPMantenimientoPlantilla ");
		oidPlantilla = conectorParametroLimpia("oidPlantilla", "", true);

		DTOPlantilla dto = obtenerPlantilla();
		cargarPGInsertarPlantilla();
		mostrarDatosPlantilla(dto);
	}

	 private void cargarMenuSecundario() throws Exception {      
		traza("*********** Entre a cargarMenuSecundario - LPMantenimientoPlantilla");
		traza("*********** accion " + accion);
		traza("*********** opcionMenu " + opcionMenu);

		if (opcionMenu.equals("InsertarPlantilla")) {
			getConfiguracionMenu("LPMantenimientoPlantilla","InsertarPlantilla");
	        asignarAtributoPagina("cod","0939");
		}

		if (opcionMenu.equals("ModificarPlantilla")) {
			if(accion.equals("modificar")) {
				getConfiguracionMenu("LPMantenimientoPlantilla","ModificarPlantillaDetalle");
		        asignarAtributoPagina("cod","0940");
			}
			else if (accion.equals("")){
				getConfiguracionMenu("LPMantenimientoPlantilla","ModificarPlantilla");
		        asignarAtributoPagina("cod","0940");
			}
		}

		if (opcionMenu.equals("ConsultarPlantilla")) {
			if(accion.equals("detalle")) {
				getConfiguracionMenu("LPMantenimientoPlantilla","ConsultarPlantillaDetalle");
		        asignarAtributoPagina("cod","0941");
			}
			else if(accion.equals("")) {
				getConfiguracionMenu("LPMantenimientoPlantilla","ConsultarPlantilla");
				asignarAtributoPagina("cod","0941");
			}
		}

		if (opcionMenu.equals("EliminarPlantilla")) {
			if(accion.equals("detalle")) {
				getConfiguracionMenu("LPMantenimientoPlantilla","EliminarPlantillaDetalle");
		        asignarAtributoPagina("cod","0942");
			}
			else if(accion.equals("")) {
				getConfiguracionMenu("LPMantenimientoPlantilla","EliminarPlantilla");
				asignarAtributoPagina("cod","0942");
			}
		}		
     }
}
