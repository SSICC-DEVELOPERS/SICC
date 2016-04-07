/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 */

import es.indra.druida.DruidaConector;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import es.indra.sicc.dtos.ape.DTOMantenerConfiguracionBalanceo;

import es.indra.sicc.logicanegocio.ape.ConstantesAPE;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesSession;

import java.math.BigDecimal;
import java.util.Vector;

import es.indra.sicc.util.DTOOID;

public class LPMantenerPrueba extends LPSICCBase {

    private Long pais = null;
    private Long idioma = null;
    private String accion = null;
    private String opcionMenu = null;


    public void inicio() throws Exception { }

    public void ejecucion() throws Exception {
        traza("*** Entrada - LPMantenerPrueba - ejecucion ***");
        try    {
            this.pais = UtilidadesSession.getPais(this);
            this.idioma = UtilidadesSession.getIdioma(this);
            this.accion = conectorParametroLimpia("accion", "", true);
            this.opcionMenu = conectorParametroLimpia("opcionMenu", "", true);

            traza("pais = " + this.pais);
            traza("idioma = " + this.idioma);
            traza("accion = " + this.accion);
            traza("opcionMenu = " + this.opcionMenu);

            if (accion.equals("")) {
                if (opcionMenu.equals("insertar")) {

                    pagina("contenido_prueba");
					asignarAtributoPagina("cod", "ApeConfBalanceo.create.label");
					getConfiguracionMenu("LPMantenerPrueba", opcionMenu);
					getFormatosValidaciones();
					this.cargarCombos();

                } else if (opcionMenu.equals("consultar") || opcionMenu.equals("modificar") || opcionMenu.equals("eliminar")) { 

                    pagina("contenido_prueba_consultar");
					if (opcionMenu.equals("consultar")) {
						asignarAtributoPagina("cod", "ApeConfBalanceo.query.label");
					} else if (opcionMenu.equals("modificar")) {
						asignarAtributoPagina("cod", "ApeConfBalanceo.update.label");
					} else if (opcionMenu.equals("eliminar")) {
						asignarAtributoPagina("cod", "ApeConfBalanceo.remove.label");
					}
					getConfiguracionMenu("LPMantenerPrueba", opcionMenu);
                    //this.cargarCombos();

                }
            } else if (accion.equals("guardar")) {

                this.guardar();

            } else if (accion.equals("modificar")) {

				String hOidCentroDistribucion = conectorParametroLimpia("hOidCentroDistribucion", "", true);
				String hDescCentroDistribucion = conectorParametroLimpia("hDescCentroDistribucion", "", true);
				String hOidLineaArmado = conectorParametroLimpia("hOidLineaArmado", "", true);
				String hDescLineaArmado = conectorParametroLimpia("hDescLineaArmado", "", true);
				String hPorcentajeVariacion = conectorParametroLimpia("hPorcentajeVariacion", "", true);
				String hOidFuncionDistribucion = conectorParametroLimpia("hOidFuncionDistribucion", "", true);
				String hDescFuncionDistribucion = conectorParametroLimpia("hDescFuncionDistribucion", "", true);

				traza("hOidCentroDistribucion: " + hOidCentroDistribucion);
				traza("hDescCentroDistribucion: " + hDescCentroDistribucion);
				traza("hOidLineaArmado: " + hOidLineaArmado);
				traza("hDescLineaArmado: " + hDescLineaArmado);
				traza("hPorcentajeVariacion: " + hPorcentajeVariacion);
				traza("hOidFuncionDistribucion: " + hOidFuncionDistribucion);
				traza("hDescFuncionDistribucion: " + hDescFuncionDistribucion);

                pagina("contenido_configuracion_balanceo_insertar");
                asignarAtributoPagina("cod", "ApeConfBalanceo.update.label");
				getConfiguracionMenu("LPMantenerPrueba", "detalleModificar");
				getFormatosValidaciones();

				asignar("VAR", "hOidCentroDistribucion", hOidCentroDistribucion);
				asignar("VAR", "hDescCentroDistribucion", hDescCentroDistribucion);
				asignar("VAR", "hDescLineaArmado", hDescLineaArmado);
				asignar("VAR", "hOidLineaArmado", hOidLineaArmado);
				asignar("VAR", "hPorcentajeVariacion", hPorcentajeVariacion);
				asignar("VAR", "hOidFuncionDistribucion", hOidFuncionDistribucion);
				asignar("VAR", "hDescFuncionDistribucion", hDescFuncionDistribucion);

				// BELC300024639 - dmorello, 16/01/2007
				this.cargarCombos();
				
				// Los combos cbCentroDistribucion y cbLineaArmado se deshabilitan mediante JavaScript

            } else if (accion.equals("detalle")) {

				String hDescCentroDistribucion = conectorParametroLimpia("hDescCentroDistribucion", "", true);
				String hDescLineaArmado = conectorParametroLimpia("hDescLineaArmado", "", true);
				String hPorcentajeVariacion = conectorParametroLimpia("hPorcentajeVariacion", "", true);
				String hDescFuncionDistribucion = conectorParametroLimpia("hDescFuncionDistribucion", "", true);

				traza("hDescCentroDistribucion: " + hDescCentroDistribucion);
				traza("hDescLineaArmado: " + hDescLineaArmado);
				traza("hPorcentajeVariacion: " + hPorcentajeVariacion);
				traza("hDescFuncionDistribucion: " + hDescFuncionDistribucion);

                pagina("contenido_configuracion_balanceo_insertar");
                asignarAtributoPagina("cod", "ApeConfBalanceo.view.label");
				getConfiguracionMenu("LPMantenerPrueba", accion); // accion == "detalle"

				asignar("VAR", "hDescCentroDistribucion", hDescCentroDistribucion);
				asignar("VAR", "hDescLineaArmado", hDescLineaArmado);
				asignar("VAR", "hPorcentajeVariacion", hPorcentajeVariacion);
				asignar("VAR", "hDescFuncionDistribucion", hDescFuncionDistribucion);

				// Todos los campos se deshabilitan mediante JavaScript
            } else if (accion.equals("buscarPrueba")) {
				pagina("contenido_prueba_consultar");
				buscarPrueba();

			}

			if (! accion.equals("guardar")) {
				asignar("VAR", "varPais", this.pais.toString());
				asignar("VAR", "varIdioma", this.idioma.toString());
				asignar("VAR", "accion", this.accion);
				asignar("VAR", "opcionMenu", this.opcionMenu);
			}

        } catch (Exception e) {
            traza("Exception en LPMantenerPrueba.ejecucion()");
            e.printStackTrace();
            lanzarPaginaError(e);
        }
        traza("*** Salida - LPMantenerPrueba - ejecucion ***");
    }

    public void guardar() throws Exception {
        traza("*** Entrada - LPMantenerPrueba - guardar ***");
        try {

			pagina("salidaGenerica");

			// Obtengo de las variables hidden la info para armar el DTO
			String strOidCentro = conectorParametroLimpia("hOidCentroDistribucion", "", true);
			String strOidLinea = conectorParametroLimpia("hOidLineaArmado", "", true);
			String strPorcentaje = conectorParametroLimpia("hPorcentajeVariacion", "", true);
			String strOidFuncion = conectorParametroLimpia("hOidFuncionDistribucion", "", true);

			traza("strOidCentro: " + strOidCentro);
			traza("strOidLinea: " + strOidLinea);
			traza("strPorcentaje: " + strPorcentaje);
			traza("strOidFuncion: " + strOidFuncion);

			DTOMantenerConfiguracionBalanceo dto = new DTOMantenerConfiguracionBalanceo();
			dto.setOidCentroDistribucion(new Long(strOidCentro));
			dto.setOidLineaArmado(new Long(strOidLinea));
			dto.setPorcentajeVariacionEstimado(new BigDecimal(strPorcentaje));
			dto.setOidFuncionDistribucion(new Long(strOidFuncion));

			traza("DTOMantenerConfiguracionBalanceo que se va a enviar: " + dto);

			MareBusinessID id = new MareBusinessID("APEGuardarConfiguracionBalanceo");
			Vector paramsEntrada = new Vector();
			paramsEntrada.add(dto);
			paramsEntrada.add(id);

			// Guardo...
			try	{
				traza("*** Antes de conectar para guardar");
				DruidaConector conector = conectar("ConectorGuardarConfiguracionBalanceo", paramsEntrada);
				traza("*** Despues de conectar para guardar");
				this.asignarAtributo("VAR", "ejecutar", "valor", "guardoCorrectamente('" + this.opcionMenu + "')");
			} catch (Exception e) {
				this.asignarAtributo("VAR","ejecutarError","valor","noPudoGuardar()");
				throw e;
			}

            
        } catch (Exception e) {
            traza("Exception en LPMantenerPrueba.guardar()");
            e.printStackTrace();
            lanzarPaginaError(e);

        }
        traza("*** Salida - LPMantenerPrueba - guardar ***");
    }

    public void cargarCombos() throws Exception {
        traza("*** Entrada - LPMantenerPrueba - cargarCombos ***");
        try    {

            DTOBelcorp dtoe = new DTOBelcorp();
            dtoe.setOidPais(this.pais);
            dtoe.setOidIdioma(this.idioma);

            traza("dtoe: " + dtoe);
            
            ComposerViewElementList list = new ComposerViewElementList();
            ComposerViewElement element;

            /* BELC300024639 - dmorello, 16/01/2007: Este bloque se encierra en el IF */
			if (! accion.equals("modificar")) {
				element = new ComposerViewElement();
				element.setIDBusiness("APEObtenerDescripcionesCD");
				element.setDTOE(dtoe);
				element.setPosOID((byte)0);
				element.setPosDesc((byte)1);
				list.addViewElement(element);
			}

			/* BELC300024639 - dmorello, 18/01/2007 */
			//if (opcionMenu.equals("insertar")) {
			if ( (accion.equals("") && opcionMenu.equals("insertar")) || (accion.equals("modificar") || opcionMenu.equals("modificar")) ) {
				element = new ComposerViewElement();
				element.setIDBusiness("APEObtenerFuncionDistribucion");
				element.setDTOE(dtoe);
				list.addViewElement(element);
            }

            ConectorComposerView conector = new ConectorComposerView(list, this.getRequest());
            conector.ejecucion();

            traza("*** antes de conectar");    
            DruidaConector drdConector = conector.getConector();
            traza("*** despues de conectar ");

			/* BELC300024639 - dmorello, 17/01/2007 */
			//asignar("COMBO", "cbCentroDistribucion", drdConector, "APEObtenerDescripcionesCD");
			if (! accion.equals("modificar")) {
				asignar("COMBO", "cbCentroDistribucion", drdConector, "APEObtenerDescripcionesCD");
			}
			//if (opcionMenu.equals("insertar")) {
			if ( (accion.equals("") && opcionMenu.equals("insertar")) || (accion.equals("modificar") && opcionMenu.equals("modificar")) ) {
				asignar("COMBO", "cbFuncionDistribucion", drdConector, "APEObtenerFuncionDistribucion");
			}
			/* Fin BELC300024639 dmorello 17/01/2007 */


			/*
			 * Recupero el valor por defecto para el combo cbCentroDistribucion
			 * y lo asigno a la variable hidden.
			 * NOTA (dmorello, 19/01/2007):
			 * En el DMCO se indica hacerlo usando ConectorComposerView
			 * pero se optó por esta forma, ya que así es como viene haciéndose.
			 * Esta forma de implementar hizo necesario crear el
			 * ConectorObtenerValoresDefecto, que no figura en el modelo.
			 * 
			 * // Recupera los oids de los valores por defecto para cada combo
			 *  Crear un elemento de tipo ComposerViewElement() para cargar los periodos
			 *  elem.IDBusiness = "APEObtenerValoresDefecto";
			 *  elem.DTOE = dtoe;
			 *  Añadir el elemento a la lista
			 *
			 */
			// dmorello, 19/01/2007: Ejecuto esto sólo cuando no voy a levantar la modal.
			if (accion.equals("")) {
				Vector parametros = new Vector();
				parametros.add(dtoe);
				parametros.add(new MareBusinessID("APEObtenerValoresDefecto"));

				traza("*** antes de conectar para obtener valores por defecto");
				DruidaConector conector2 = conectar("ConectorObtenerValoresDefecto", parametros);
				traza("*** despues de conectar para obtener valores por defecto");

				DTOSalida dtoSalida = (DTOSalida)conector2.objeto("DTOSalida");
				RecordSet rs = dtoSalida.getResultado();
				traza("*** rs: " + rs);

				/*
				 * dmorello, 19/01/2007: Aqui guardo todas las lineas de armado por defecto
				 * Los OIDs van separados por pipes y luego se envian a la pagina
				 */
				StringBuffer lineasDef = new StringBuffer();

				int size = rs.getRowCount();
				for (int i = 0; i < size; i++) {
					Object combo = rs.getValueAt(i, "COMBO");
					if (ConstantesAPE.CONFIGURACION_CD.equals(combo)) {
						asignar("VAR", "hOidCentroDistribucionDefecto", rs.getValueAt(i, "OID").toString());
					} else if (ConstantesAPE.LINEA_ARMADO.equals(combo)) {
						lineasDef.append(rs.getValueAt(i, "OID").toString()).append('|');
					}
				}

				// Borro el ultimo pipe, a fin de hacer un split en JavaScript
				int length = lineasDef.length();
				if (length > 0) {
					lineasDef.delete(length-1, length);
				}
				asignar("VAR", "hOidsLineasArmadoDefecto", lineasDef.toString());
				// Fin dmorello 19-01-2007
			}


        } catch (Exception e) {
            traza("Exception en LPMantenerPrueba.guardar()");
            e.printStackTrace();
            lanzarPaginaError(e);

        }
        traza("*** Salida - LPMantenerPrueba - cargarCombos ***");
    }

	private void buscarPrueba() throws Exception {
		
		DTOOID dtoe = new DTOOID();
		dtoe.setOid(new Long("647"));

		traza("dtoe: " + dtoe);

		Vector parametros = new Vector();
		parametros.add(dtoe);
		parametros.add(new MareBusinessID("APEVisualizarListaPicado"));

		traza("*** antes de conectar para obtener valores por defecto");
		DruidaConector conector2 = conectar("ConectorConsultarPrueba", parametros);
		traza("*** despues de conectar para obtener valores por defecto");

		DTOSalida dtoSalida = (DTOSalida)conector2.objeto("DTOSalida");
		RecordSet rs = dtoSalida.getResultado();
		traza("*** rs PRUEBA: " + rs);
	}
}
