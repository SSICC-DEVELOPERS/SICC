/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.rec.DTOLineasOperacion;
import es.indra.sicc.dtos.rec.DTORecibirProductos;
import es.indra.sicc.util.DTOBelcorp;

import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream; 

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

public class LPRecibirProductos extends LPSICCBase {
          
    private String accion = null;
    private String casoUso = null;
    private Long pais;
    private Long idioma;

    public LPRecibirProductos() {
         super();
    }
           
    public void inicio() throws Exception {
    }
           
    public void ejecucion() throws Exception {
        setTrazaFichero();

        try {
            traza("*** HSH Entrada -  LPRecibirProductos - ejecucion ***");

            this.idioma = UtilidadesSession.getIdioma(this);
            this.pais = UtilidadesSession.getPais(this);
            this.accion = conectorParametroLimpia("accion","", true);
            traza("HSH accion=: "+accion+"||pais="+this.pais+"||idioma="+idioma);

            if(this.accion.equals("")){
traza("*** HSH accionVacia");
                pagina("contenido_productos_reclamados_recibir");
        		asignar("VAR", "idioma", idioma.toString());
        		asignar("VAR", "pais", pais.toString());	
traza("*** HSH idioma="+idioma.toString());
traza("*** HSH pais="+pais.toString());

traza("*** HSH Pagina asignada");
                getConfiguracionMenu("LPRecibirProductos", "");
traza("*** HSH menu asignado");
                this.generarHiddenFormatoFecha();
                this.cargarOperaciones();
            } else if(this.accion.equals("recibir")){
traza("*** HSH accion recibir");
                 this.accionRecibir();
            }
            traza("*** HSH Salida -  LPRecibirProductos - ejecucion ***");
        } catch (Exception e) {
            e.printStackTrace();
            logStackTrace(e);
            lanzarPaginaError(e); 
        }
    }

    private void accionRecibir() throws Exception {
        try {
            traza("*** HSH Entrada -  LPRecibirProductos - accionRecibir ***");

            pagina("salidaGenerica");
            asignar("VAR", "cerrarVentana", "false");


            // Separaciones entre los elementos de la lista.
            final String BLANCO = "/";
            final String FINLINEA = "|";
            final String ELEMENTO = "*";

            DTORecibirProductos dtoRecibirProductos = new DTORecibirProductos();

            dtoRecibirProductos.setOidPais(this.pais);
            dtoRecibirProductos.setOidIdioma(this.idioma);

            ArrayList arrayLineas = new ArrayList();
            DTOLineasOperacion dtoLineas = null;

            // Obtenemos la lista de la página, almacenada en un hidden
            String listaOriginal = conectorParametroLimpia("lista","", true);

            StringTokenizer tokenLineas = new StringTokenizer(listaOriginal, FINLINEA);
            StringTokenizer tokenColumnas = null;

            String oidLineaOperacion = null;
            String numeroUnidadesADevolver = null;
            String oidSolicitudCabecera = null;
            String oidMarca = null;
            String oidCanal = null;
            String oidAcceso = null;
            String oidSubAcceso = null;
            String oidPeriodoReclamo = null;
            String oidCabeceraReclamo = null;
            String numeroAtencion = null;
            String esperarMercaderia = null;
            String devuelveFisico = null;
            String unidadesReclamadas = null;
            String precioUnitario = null;

			String entregaMercaderia = null;
			String numeroOperacion = null;
			String numeroUnidadesDevueltas = null;

		traza("LINEA: "+listaOriginal);
            // Recorremos todas las lineas
            while(tokenLineas.hasMoreTokens()) {
                tokenColumnas = new StringTokenizer(tokenLineas.nextToken(), ELEMENTO);
                dtoLineas = new DTOLineasOperacion();

                // Obtenemos los datos
                oidLineaOperacion = tokenColumnas.nextToken();
                numeroUnidadesADevolver = tokenColumnas.nextToken();
                oidSolicitudCabecera = tokenColumnas.nextToken();
                oidMarca = tokenColumnas.nextToken();
                oidCanal = tokenColumnas.nextToken();
                oidAcceso = tokenColumnas.nextToken();
                oidSubAcceso = tokenColumnas.nextToken();
                oidPeriodoReclamo = tokenColumnas.nextToken();
                oidCabeceraReclamo = tokenColumnas.nextToken();
                numeroAtencion = tokenColumnas.nextToken();
                esperarMercaderia = tokenColumnas.nextToken();
                devuelveFisico = tokenColumnas.nextToken();
                unidadesReclamadas = tokenColumnas.nextToken();
                precioUnitario = tokenColumnas.nextToken();

				entregaMercaderia = tokenColumnas.nextToken();
				numeroOperacion = tokenColumnas.nextToken();
				numeroUnidadesDevueltas = tokenColumnas.nextToken();

traza("HSH token oidLineaOperacion="+oidLineaOperacion);
traza("HSH token numeroUnidadesADevolver="+numeroUnidadesADevolver);
traza("HSH token oidSolicitudCabecera="+oidSolicitudCabecera);
traza("HSH token oidMarca="+oidMarca);
traza("HSH token oidCanal="+oidCanal);
traza("HSH token oidAcceso="+oidAcceso);
traza("HSH token oidSubAcceso="+oidSubAcceso);
traza("HSH token oidPeriodoReclamo="+oidPeriodoReclamo);
traza("HSH token oidCabeceraReclamo="+oidCabeceraReclamo);
traza("HSH token numeroAtencion="+numeroAtencion);
traza("HSH token esperarMercaderia="+esperarMercaderia);
traza("HSH token devuelveFisico="+devuelveFisico);
traza("HSH token unidadesReclamadas="+unidadesReclamadas);
traza("HSH token precioUnitario="+precioUnitario);

traza("HSH token entregaMercaderia="+entregaMercaderia);
traza("HSH token numeroOperacion="+numeroOperacion);
traza("HSH token numeroUnidadesDevueltas="+numeroUnidadesDevueltas);

                // Insertamos los datos en el dto
                if(!oidLineaOperacion.equals(BLANCO)) {
                    dtoLineas.setOidLineaOperacion(new Long(oidLineaOperacion));
                }
                if(!numeroUnidadesADevolver.equals(BLANCO)) {
                    dtoLineas.setNumeroUnidadesADevolver(new Integer(numeroUnidadesADevolver));
                }
                if(!oidSolicitudCabecera.equals(BLANCO)) {
                    dtoLineas.setOidSolicitudCabecera(new Long(oidSolicitudCabecera));
                }
                if(!oidMarca.equals(BLANCO)) {
                    dtoLineas.setOidMarca(new Long(oidMarca));
                }
                if(!oidCanal.equals(BLANCO)) {
                    dtoLineas.setOidCanal(new Long(oidCanal));
                }
                if(!oidAcceso.equals(BLANCO)) {
                    dtoLineas.setOidAcceso(new Long(oidAcceso));
                }
                if(!oidSubAcceso.equals(BLANCO)) {
                    dtoLineas.setOidSubAcceso(new Long(oidSubAcceso));
                }
                if(!oidPeriodoReclamo.equals(BLANCO)) {
                    dtoLineas.setOidPeriodoReclamo(new Long(oidPeriodoReclamo));
                }
                if(!oidCabeceraReclamo.equals(BLANCO)) {
                    dtoLineas.setOidCabeceraReclamo(new Long(oidCabeceraReclamo));
                }
                if(!numeroAtencion.equals(BLANCO)) {
                    dtoLineas.setNumeroAtencion(new Long(numeroAtencion));
                }
                if(!esperarMercaderia.equals(BLANCO)) {
                	if (esperarMercaderia.equals("1")){
                    		dtoLineas.setEsperarMercaderia(new Boolean(true));
                    	}else{
                    		dtoLineas.setEsperarMercaderia(new Boolean(false));
                    	}
                }
                if(!devuelveFisico.equals(BLANCO)) {
                    if (devuelveFisico.equals("1")){
                    		dtoLineas.setDevuelveFisico(new Boolean(true));
                    	}else{
                    		dtoLineas.setDevuelveFisico(new Boolean(false));
                    }
                }
                if(!unidadesReclamadas.equals(BLANCO)) {
                    dtoLineas.setUnidadesReclamadas(new Integer(unidadesReclamadas));
                }
                if(!precioUnitario.equals(BLANCO)) {
                    dtoLineas.setPrecioUnitario(new BigDecimal(precioUnitario));
                }

				//yyy
				if (!entregaMercaderia.equals(BLANCO)){
					dtoLineas.setIndEntregaMercaderia(new Long(entregaMercaderia));
				}

				if (!numeroOperacion.equals(BLANCO)){
					dtoLineas.setNumeroOperacion(new Integer(numeroOperacion));
				}

				if (!numeroUnidadesDevueltas.equals(BLANCO)){
					dtoLineas.setNumeroUnidadesDevueltas(new Integer(numeroUnidadesDevueltas));
				}

traza("HSH dtoLineas generado = "+dtoLineas);
                arrayLineas.add(dtoLineas);
            }

            dtoRecibirProductos.setLineas(arrayLineas); 
            
            MareBusinessID idBusiness = new MareBusinessID("RECRecibirProductos");

            Vector paramEntrada = new Vector();
            paramEntrada.add(dtoRecibirProductos);
            paramEntrada.add(idBusiness);

            // Se invoca al conector 
            DruidaConector conector = conectar("ConectorRecibirProductos", paramEntrada);

            // Llamamos a la función que nos devuelve al menú principal
            asignarAtributo("VAR", "ejecutar", "valor", "cerrarVentana()");

            traza("*** HSH Salida -  LPRecibirProductos - accionRecibir ***");
        } catch (Exception e) {
            e.printStackTrace();
            logStackTrace(e);
            lanzarPaginaError(e); 
        }
    }

    private void cargarOperaciones() throws Exception {
        try{
            traza("*** HSH Entrada -  LPRecibirProductos - cargarOperaciones ***");

            ComposerViewElementList listelem = new ComposerViewElementList();
            ComposerViewElement elem = null;

            DTOBelcorp dtoBelcorp = new DTOBelcorp();
            dtoBelcorp.setOidPais(this.pais);
            dtoBelcorp.setOidIdioma(this.idioma);
   
            elem = new ComposerViewElement(); 
            elem.setIDBusiness("RECObtenerCodigosOperacion");
            elem.setDTOE(dtoBelcorp);
            listelem.addViewElement(elem);
        
            // Llamamos al subsistema GestorCargaPantalla. 
            ConectorComposerView conector = new ConectorComposerView(listelem, this.getRequest());
            conector.ejecucion();
            DruidaConector conConsulta = conector.getConector();
                     
            asignar("COMBO", "cbOperacion", conConsulta, "RECObtenerCodigosOperacion");

            traza("*** HSH Salida -  LPRecibirProductos - cargarOperaciones ***");
        } catch (Exception e) {
            e.printStackTrace();
            logStackTrace(e);
            lanzarPaginaError(e); 
        }
    }

    private void logStackTrace(Throwable e) throws Exception {
         traza("Se produjo la excepcion: " + e.getMessage());             
         ByteArrayOutputStream baos = new ByteArrayOutputStream();
         PrintStream ps = new PrintStream(baos);
         e.printStackTrace(ps);           
         traza("Stack Trace: " + baos.toString());
    }
}