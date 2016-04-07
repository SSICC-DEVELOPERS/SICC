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
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import es.indra.druida.DruidaConector;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.*;

/*Imports para el uso del subsistema GestorCargaPantalla */
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.util.xml.XMLDocument;

 public class LPBuscarProductosDTO extends LPSICCBase{
    
    private Long lIdioma = null;
    private Long lPais = null;
    private String casoDeUso = "";
    	
    public void inicio() throws Exception{
        pagina("contenido_productos_buscar");
    }

    public void ejecucion() throws Exception{
        setTrazaFichero();
        traza("<<<<<<<<< Inicializando LPBuscarProductosDTO >>>>>>>>>>>>");		
    try{
            String sAccion = conectorParametro("accion")==null?"":conectorParametro("accion");
 			   String casoDeUso = conectorParametroLimpia("casoDeUso", "", true);
				traza("caso de uso: "+casoDeUso);

            if (sAccion.equals(""))
            {
//Acción "" 
//-> Asignar página "contenido_productos_buscar" 
                lIdioma = UtilidadesSession.getIdioma(this);
                lPais = UtilidadesSession.getPais(this);
                traza(">>>> Acción................" + sAccion);
                traza(">>>> Idioma................" + lIdioma);
                
//-> Crear objeto "DTOBelcorp" con el oid del Pais del usuario activo 
//-> Llamar al subsistema GestorCargaPantalla con los siguientes datos: 
//- idBusiness = "SEGObtenerMarcas" y un objeto "DTOBelcorp" => carga el combo "marca" 
//- idBusiness = "MAEObtenerGenericosPorPais" y un objeto "DTOBelcorp" => carga el combo "generico" 
//- idBusiness = "MAEObtenerUnidadesNegocioPorPais" y un objeto "DTOBelcorp" => carga el combo "unidadNegocio" 
//- idBusiness = "MAEObtenerSuperGenericosPorPais" y un objeto "DTOBelcorp" => carga el combo "superGenerico" 
//- idBusiness = "MAEObtenerNegocioPorPais" y un objeto "DTOBelcorp" => carga el combo "negocio" 
                cargaCombos();

				asignarTitulo(casoDeUso);
            }

        }catch(Exception e){
            ByteArrayOutputStream pila = new ByteArrayOutputStream();
            PrintStream out = new PrintStream(pila);
            e.printStackTrace(out);
            traza("El stack es como sigue : " + pila.toString());
            lanzarPaginaError(e);
        }

		this.getConfiguracionMenu();
    }

    // Asignar titulo a la pantalal
	private void asignarTitulo(String casoDeUso) throws Exception{

		if(casoDeUso.equals("insertar")){
			asignarAtributoPagina("cod", "0644");
		}else if(casoDeUso.equals("consultar")){
			asignarAtributoPagina("cod", "0233");
		}else if(casoDeUso.equals("modificar")){
			asignarAtributoPagina("cod", "0354");
		}else if(casoDeUso.equals("eliminar")){
			asignarAtributoPagina("cod", "0343");
		}else if(casoDeUso.equals("buscarProducto")){
			asignarAtributoPagina("cod", "445");
		}								
	}

    /*=================Uso del subsistema GestorCargaPantalla==================*/
    private void cargaCombos() throws Exception{
        traza("Entró a cargaCombos");
        //Preparamos los parametros del subsistema
		ComposerViewElementList cv = crearParametrosEntrada();
        traza("++++++++++++++ Parametros creados +++++++++++++++++++");
		//Utilizamos el subsistema
		ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
        traza("++++++++++++++ Ejecutando Conector +++++++++++++++++++");
		conector.ejecucion();
        traza("++++++++++++++ Conector Ejecutado +++++++++++++++++++");
		DruidaConector resultados = conector.getConector();
		//Cargamos los combos con los resultados
        traza("++++++++++++++ Asignando Combos +++++++++++++++++++");

        asignar("COMBO", "cbMarca", resultados, "SEGRecuperarMarcasProductoMP");
		asignar("COMBO", "cbUnidadNegocio", resultados, "MAEObtenerUnidadesNegocioPorPais");
        asignar("COMBO", "cbNegocio", resultados, "MAEObtenerNegocioPorPais");
		asignar("COMBO", "cbSupergenerico", resultados, "MAEObtenerSuperGenericosPorPais");
        asignar("COMBO", "cbGenerico", resultados, "MAEObtenerGenericosPorPais");

        traza("Salio de cargaCombos");
    }

    private ComposerViewElementList crearParametrosEntrada() throws Exception
    {

        DTOBelcorp dtoBel =  new DTOBelcorp();
        dtoBel.setOidIdioma(lIdioma);
        dtoBel.setOidPais(lPais);
        
		ComposerViewElementList lista = new ComposerViewElementList();

		//Combo Marca
        String sOidMarca = conectorParametro("oidMarcaCorporativa")==null?"":conectorParametro("oidMarcaCorporativa");
        traza("Marca.....:" + sOidMarca);

        DTOOID  dtoOidMarca = new DTOOID();
        if( (sOidMarca != null) &&  (!sOidMarca.equals("")) ) 
		{
			traza("Se envia marca con valor");
            dtoOidMarca.setOid(new Long(sOidMarca));
		}
        else
		{
			traza("Se envia marca SIN valor");
            dtoOidMarca.setOid(null);
		}
        traza("Paso 0");    
        dtoOidMarca.setOidIdioma(lIdioma);
        dtoOidMarca.setOidPais(lPais);
        traza("Paso 1");    
		ComposerViewElement ci1 = new ComposerViewElement();
		ci1.setIDBusiness("SEGRecuperarMarcasProductoMP");
		ci1.setDTOE(dtoOidMarca);
		traza("Paso 2");
		//Combo generico
		ComposerViewElement ci2 = new ComposerViewElement();
		ci2.setIDBusiness("MAEObtenerGenericosPorPais");
		ci2.setDTOE(dtoBel);
		traza("Paso 3");
        //Combo unidadNegocio
        ComposerViewElement ci3 = new ComposerViewElement();
		ci3.setIDBusiness("MAEObtenerUnidadesNegocioPorPais");
		ci3.setDTOE(dtoBel);
		traza("Paso 4");
        //Combo superGenerico
        ComposerViewElement ci4 = new ComposerViewElement();
		ci4.setIDBusiness("MAEObtenerSuperGenericosPorPais");
		ci4.setDTOE(dtoBel);
		traza("Paso 5");
        //Combo negocio
        ComposerViewElement ci5 = new ComposerViewElement();
		ci5.setIDBusiness("MAEObtenerNegocioPorPais");
		ci5.setDTOE(dtoBel);
		traza("Paso 6");
		lista.addViewElement(ci1);
		lista.addViewElement(ci2);
        lista.addViewElement(ci3);
		lista.addViewElement(ci4);
        lista.addViewElement(ci5);
		
		return lista;
	}

 }
