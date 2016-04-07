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
 /*
    INDRA/CAR/PROY
    $Id: LPSimulacionDescuento.java,v 1.1 2009/12/03 18:42:05 pecbazalar Exp $
    DESC
 */

/**
 * Sistema:           Belcorp
 * Modulo:            DTO
 * Submódulo:         
 * Componente:        LPSimulacionDescuento.java
 * Fecha:             30/07/2004
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DCMO-DTO-201-334-N024
 * @version           1.0
 * @autor             Andrés Pollitzer
 */


import es.indra.sicc.util.DTOColeccion;
import java.util.Iterator;
import es.indra.sicc.dtos.dto.DTOSolicitudSeleccionada;
import es.indra.sicc.dtos.dto.DTOSimulacionDescuento;
import es.indra.sicc.dtos.dto.DTOSolicitudDescuento;
import es.indra.sicc.dtos.dto.DTOObtenerCabeceraDTO;
import es.indra.sicc.dtos.dto.DTOSolicitudPosicionDescuento;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import java.util.ArrayList;
import java.util.Vector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.druida.DruidaConector;
import es.indra.sicc.util.DTOOID;
import java.util.StringTokenizer;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import es.indra.mare.common.exception.MareException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;



public class LPSimulacionDescuento extends LPSICCBase {

  String accion;

  String oidDescuento;
  String oidDescuentoSeleccionado;
  String oidSolicitud;
  String detalleSolicitudes;

  String codCliente;
  String nombreCliente;
  String campaniaSolicitud;
  String fechaSolicitud;
  String montoTotalSolicitud;


	public LPSimulacionDescuento()  {
      super();
  }

  public void inicio() throws Exception  {
        pagina("contenido_simulacion_descuentos_realizar");
  }

  public void ejecucion() throws Exception  {
    try{

        // 0.- Obtenemos la accion el pais, el idioma, la marca y el canal.
        this.obtenerEstadoInicial();

//accion == "" ---------------------------------------------------------------------------
      if (accion.equals(""))  {
          traza("Entra en accion vacia");
        inicioSimulacion();
        getConfiguracionMenu("LPSimulacionDescuento","");
          traza("Sale de accion vacia");
      }

//accion == "calcular" ---------------------------------------------------------------------------
      else if (accion.equals("calcular"))  {
          traza("Entra en accion calcular");
        calcular();
        getConfiguracionMenu("LPSimulacionDescuento","calcular");
          traza("Sale de accion calcular");
      }

//accion == "detalle" ---------------------------------------------------------------------------
      else if (accion.equals("detalle"))  {
          traza("Entra en accion detalle");
        detalle();
        getConfiguracionMenu("LPSimulacionDescuento","detalle");
          traza("Sale de accion detalle");
      }

//accion == "aprobar" ---------------------------------------------------------------------------
      else if (accion.equals("aprobar"))  {
          traza("Entra en accion aprobar");
        aprobar();
          traza("Sale de accion aprobar");
      }

//accion == "seleccionarSolicitudes" ---------------------------------------------------------------------------
      else if (accion.equals("seleccionarSolicitudes"))  {
          traza("Entra en accion seleccionarSolicitudes");
        seleccionarSolicitudes();
          traza("Sale de accion seleccionarSolicitudes");
      }

		asignarAtributo("VAR","accion","valor",accion);
        asignarAtributo("VAR","hSeparadorMilesPais","valor","puto druida");

    } catch (Exception ex) {
			this.logStackTrace(ex);
			this.lanzarPaginaError(ex);
		    asignarAtributo("VAR","accion","valor", "");
			asignarAtributo("VAR","oidDesc", "valor", this.oidDescuento);
			asignarAtributo("VAR","hOidDescuento", "valor", this.oidDescuentoSeleccionado);
			asignarAtributo("VAR","hOidSolicitud", "valor", this.oidSolicitud);
			asignarAtributo("VAR","hDetalleSolicitudes", "valor", "");
			asignarAtributo("VAR","hCodCliente", "valor", this.codCliente);
            asignarAtributo("VAR","hNombreCliente", "valor", this.nombreCliente);
            asignarAtributo("VAR","hCampaniaSolicitud","valor",this.campaniaSolicitud);
            asignarAtributo("VAR","hFechaSolicitud","valor",this.fechaSolicitud);
            asignarAtributo("VAR","hMontoTotalSolicitud","valor",this.montoTotalSolicitud);
			this.recargaPostError(ex);
    }

  }//fin ejecucion()


		
	private void obtenerEstadoInicial() throws Exception  {
			
		setTrazaFichero();
        generarHiddenFormatoFecha();

        accion = conectorParametroLimpia("accion","",true);

        oidDescuento = conectorParametroLimpia("oidDesc","",true);
        oidDescuentoSeleccionado = conectorParametroLimpia("hOidDescuento","",true);
        oidSolicitud = conectorParametroLimpia("hOidSolicitud","",true);
        detalleSolicitudes = conectorParametroLimpia("hDetalleSolicitudes","",true);

        codCliente = conectorParametroLimpia("hCodCliente","",true);
        nombreCliente = conectorParametroLimpia("hNombreCliente","",true);
        campaniaSolicitud = conectorParametroLimpia("hCampaniaSolicitud","",true);
        fechaSolicitud = conectorParametroLimpia("hFechaSolicitud","",true);
        montoTotalSolicitud = conectorParametroLimpia("hMontoTotalSolicitud","",true);

        traza(" ");
        traza("********************************************************");
        traza("******* ejecucion() LPSimulacionDescuento ********");
        traza("********************************************************");
        traza("accion : "                   + accion);

        traza("oidDescuento : "             + oidDescuento);
        traza("oidDescuentoSeleccionado : " + oidDescuentoSeleccionado);
        traza("oidSolicitud : "             + oidSolicitud);
        traza("detalleSolicitudes : "       + detalleSolicitudes);
	}


//-----------------------------------------------------------------------------------------------------------------------------
  private void inicioSimulacion() throws Exception  {
    //-> Tomar del request el valor del parámetro oidDescuento
    //-> Mapear ese valor en la variable oculta de pantalla oidDescuento
    asignarAtributo("VAR","hOidDescuento","valor",oidDescuento );
    //-> Tomar de sesión la variable "solicitudesSeleccionadas" de tipo arrayList con oidSolicitud de las solicitudes seleccionadas
    //Nota del desarrollador: se recibe un String y se crea el arrayList
    String oidsParsear = conectorParametroLimpia("solicitudesSeleccionadas","",true);
	asignarAtributo("VAR","solicitudesSeleccionadas","valor",oidsParsear);
    ArrayList oidsSolicitudes = parsearSolicitudesSeleccionadas( oidsParsear );
	traza("oidsSolicitudes: " + oidsSolicitudes.toString() );

	//-> Crear objeto DTOColeccion con array anterior
    DTOColeccion dtoOidSolicitudes = new DTOColeccion();
    dtoOidSolicitudes.setLista( oidsSolicitudes );

    Vector objBusiness = new Vector();
    objBusiness.add( dtoOidSolicitudes );
    //-> Crear idBusiness = "DTOCargarSolicitudes"
    objBusiness.add( new MareBusinessID("DTOCargarSolicitudes") );
    //-> Asignar conector "ConectorCargarSolicitudes"
      traza("objBusiness: " + objBusiness.toString() );
    DruidaConector con = conectar("ConectorCargarSolicitudes",objBusiness);
    DTOColeccion dtoSolicitudes = (DTOColeccion)con.objeto("DTOColeccion");
      traza("dtoSolicitudes: " + dtoSolicitudes );
    //-> Obtener objeto DTOColeccion de respuesta y ponerlo en sesión con el nombre "datosSolicitudesSeleccionadas"
    this.getSessionCache().put("datosSolicitudesSeleccionadas",dtoSolicitudes);
    
    //-> Hacer el siguiente mapeo en pantalla:
    //Para cada objeto DTOSolicitudSeleccionada hacer:
    Iterator it = dtoSolicitudes.getLista().iterator();
    String cadenas = "";
//-----------------------------------------------------------
    DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    Document docDestino = docBuilder.newDocument();
    Element rowset2 = docDestino.createElement("ROWSET2");
    Element rowset = docDestino.createElement("ROWSET");
    rowset.setAttribute("ID", "resultado");
    rowset2.appendChild(rowset);
//-----------------------------------------------------------
    while ( it.hasNext() )  {
      //-> Añadir un registro a la lista editable "solicitudes" con los datos de DTOSolicitudCabecera
      DTOSolicitudSeleccionada dtoSolicSelec = (DTOSolicitudSeleccionada)it.next();
      //Por incidencia 7292: DTOSolicitudSeleccionada.cabecera, que es de tipo DTOObtenerCabeceraDTO
      DTOObtenerCabeceraDTO dtoCabecera = dtoSolicSelec.getCabecera();
        traza("dtoCabecera : " + dtoCabecera );
//--------------------------------------------------------------
      Element elemRow = docDestino.createElement("ROW");
      rowset.appendChild(elemRow);
      Element elemDato;
      Text txt;
      String dato;
      
      elemDato = docDestino.createElement("CAMPO");
      elemDato.setAttribute("NOMBRE", "oidCabecera");
      elemDato.setAttribute("TIPO", "STRING");
      elemDato.setAttribute("LONGITUD", "50");
      dato = dtoCabecera.getOidCabecera() == null ? "" : dtoCabecera.getOidCabecera().toString();
      txt = docDestino.createTextNode(dato);
      elemDato.appendChild(txt);
      elemRow.appendChild(elemDato);

      elemDato = docDestino.createElement("CAMPO");
      elemDato.setAttribute("NOMBRE", "codigoCliente");
      elemDato.setAttribute("TIPO", "STRING");
      elemDato.setAttribute("LONGITUD", "50");
      dato = dtoCabecera.getCodigoCliente() == null ? "" : dtoCabecera.getCodigoCliente();
      txt = docDestino.createTextNode(dato);
      elemDato.appendChild(txt);
      elemRow.appendChild(elemDato);

      elemDato = docDestino.createElement("CAMPO");
      elemDato.setAttribute("NOMBRE", "nombreCliente");
      elemDato.setAttribute("TIPO", "STRING");
      elemDato.setAttribute("LONGITUD", "50");
      dato = dtoCabecera.getNombre() == null ? "" : dtoCabecera.getNombre();
      dato = dato + " " + ( dtoCabecera.getApellido1() == null ? "" : dtoCabecera.getApellido1() );
      dato = dato + " " + ( dtoCabecera.getApellido2() == null ? "" : dtoCabecera.getApellido2() );
      txt = docDestino.createTextNode(dato);
      elemDato.appendChild(txt);
      elemRow.appendChild(elemDato);

      //Campaña
      elemDato = docDestino.createElement("CAMPO");
      elemDato.setAttribute("NOMBRE", "campanya");
      elemDato.setAttribute("TIPO", "STRING");
      elemDato.setAttribute("LONGITUD", "50");
      dato = dtoCabecera.getNombrePeriodo() == null ? "" : dtoCabecera.getNombrePeriodo();
      txt = docDestino.createTextNode(dato);
      elemDato.appendChild(txt);
      elemRow.appendChild(elemDato);

      elemDato = docDestino.createElement("CAMPO");
      elemDato.setAttribute("NOMBRE", "fechaSolicitud");
      elemDato.setAttribute("TIPO", "STRING");
      elemDato.setAttribute("LONGITUD", "50");
      dato = dtoCabecera.getFechaSolicitud() == null ? "" : obtenerFechaFormatoPais(dtoCabecera.getFechaSolicitud());
      txt = docDestino.createTextNode(dato);
      elemDato.appendChild(txt);
      elemRow.appendChild(elemDato);

      elemDato = docDestino.createElement("CAMPO");
      elemDato.setAttribute("NOMBRE", "montoTotal");
      elemDato.setAttribute("TIPO", "STRING");
      elemDato.setAttribute("LONGITUD", "50");
      dato = dtoCabecera.getMontoTotalSolicitud() == null ? "" : UtilidadesBelcorp.formateaNumeroSICC(dtoCabecera.getMontoTotalSolicitud().toString(), this.FORMATO_DEFAULT, this);
      txt = docDestino.createTextNode(dato);
      elemDato.appendChild(txt);
      elemRow.appendChild(elemDato);
//-----------------------------------------------------------

      //-> Añadir a la variable oculta "detalleSolicitud" de pantalla un array de cadenas
      //-> En cada cadena irán los siguientes campos concatenados: "oidSolicitud|oidPosicion|cantidad|valorTotal|descuento"
      RecordSet rsPosicion = dtoSolicSelec.getDetalle();
        traza("rsPosicion: " + rsPosicion );
      for (int f=0; f<rsPosicion.getRowCount(); f++)  {
        cadenas = cadenas + dtoCabecera.getOidCabecera() + "|";
        cadenas = cadenas + rsPosicion.getValueAt(f,"OIDSOLICITUDPOSICION") + "|" ;
        cadenas = cadenas + rsPosicion.getValueAt(f,"CANTIDAD") + "|" ;
        cadenas = cadenas + rsPosicion.getValueAt(f,"VALORTOTAL") + "|" ;
        cadenas = cadenas + rsPosicion.getValueAt(f,"DESCUENTO") + "|" ;
          traza("cadenas: " + cadenas);
      }//fin for

    }//fin while
//--------------------------------------------------------------
    DruidaConector conector = new DruidaConector();
    conector.setXML(rowset2);
    asignar( "LISTADOA", "listado1", conector,"resultado" );
//--------------------------------------------------------------
    asignarAtributo("VAR","hDetalleSolicitudes","valor",cadenas);
    //-> deshabilitar los botones aprobar y calcular, y dejar habilitados los botones modificarSolicitud y seleccionarSolicitudes

  }
//-----------------------------------------------------------------------------------------------------------------------------
  private void calcular() throws Exception  {
    asignarAtributo("VAR","hOidDescuento","valor",oidDescuentoSeleccionado );
    //-> Tomar de sesión la variable "datosSolicitudesSeleccionadas" de tipo DTOColeccion, que lleva un array de
    //objetos DTOSolicitudSeleccionada
    //-> Lo guardaremos en una variable llamada "coleccionSolicitudes"
    DTOColeccion coleccionSolicitudes = (DTOColeccion)( this.getSessionCache().get("datosSolicitudesSeleccionadas") );
      traza("coleccionSolicitudes: " + coleccionSolicitudes.toString() );
    //-> Crear un objeto DTOSimulacionDescuento
    DTOSimulacionDescuento dtoSimulDesc = new DTOSimulacionDescuento();
    dtoSimulDesc.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
    dtoSimulDesc.setPrograma(UtilidadesSession.getFuncion(this));

    //-> Añadir al atributo DTOSimulacionDescuento.oidDescuento el valor de la variable oculta de pantalla oidDescuento
    dtoSimulDesc.setOidDescuento( Long.valueOf(oidDescuentoSeleccionado) );
    //-> Tomar el valor de la variable oculta de pantalla "detalleSolicitudes" y recorrerlo
    //"oidSolicitud N12 | oidPosicion N12 | cantidad N6 | valorTotal N12,2 | descuento N12,2"
    ArrayList detalleSolic = parsearString( detalleSolicitudes );
    traza("detalleSolic: " + detalleSolic.toString() );
    Iterator itDetalle = detalleSolic.iterator();
    //creo arrylist para asignar luego del while
    ArrayList alSolicitudesDto = new ArrayList();
    UtilidadesSession sesion = new UtilidadesSession(); //para asignar dentro del while

    //-> Buscar en "coleccionSolicitudes" aquella solicitud (DTOSolicitudSeleccionada) cuyo oid coincida
    //con el oid de solicitud guardado en el elemento
    Iterator itColeccionSolicitudes = coleccionSolicitudes.getLista().iterator();
    while ( itColeccionSolicitudes.hasNext() )  {
      DTOSolicitudSeleccionada dtoSolSel = (DTOSolicitudSeleccionada)itColeccionSolicitudes.next();
      //-> Crear objeto DTOSolicitudDescuento llamado "solicitudDescuento"
      DTOSolicitudDescuento solicitudDescuento = new DTOSolicitudDescuento();

      //->Tomar los datos DTOSolicitudSeleccionada.cabecera y mapearlos todos a "solicitudDescuento"
      solicitudDescuento.setCodigoCliente( dtoSolSel.getCabecera().getCodigoCliente() );
      solicitudDescuento.setFechaSolicitud( dtoSolSel.getCabecera().getFechaSolicitud() );
      solicitudDescuento.setMontoDescuento3( dtoSolSel.getCabecera().getImporteDescuento3TotalLocal() );
      solicitudDescuento.setMontoTotalSolicitud( dtoSolSel.getCabecera().getMontoTotalSolicitud() );
      solicitudDescuento.setNombreCliente( dtoSolSel.getCabecera().getNombre() );
      solicitudDescuento.setNombrePeriodo( dtoSolSel.getCabecera().getNombrePeriodo() );
      solicitudDescuento.setOidSolicitud( dtoSolSel.getCabecera().getOidCabecera() );
      solicitudDescuento.setOidTipoSolPais( dtoSolSel.getCabecera().getOidTipoSolicitudPais() );
      solicitudDescuento.setOidPais( dtoSolSel.getCabecera().getOidPais() );
      solicitudDescuento.setZona( dtoSolSel.getCabecera().getOidZona() );
      solicitudDescuento.setOidCliente( dtoSolSel.getCabecera().getOidCliente() );
      solicitudDescuento.setOidPeriodo( dtoSolSel.getCabecera().getOidPeriodo() );

      //-> Recorrer el RecordSet DTOSolicitudSeleccionada.detalle
      //-> Por cada registro crear un objeto DTOSolicitudPosicionDescuento mapeando todos los datos menos
      //aquellos que están en la posición del elemento, que son: cantidad, valorTotal y descuento
      ArrayList alSolicitudesPos = new ArrayList();
      ArrayList valoresPosicion = new ArrayList();
      for ( int r=0; r<dtoSolSel.getDetalle().getRowCount(); r++ )  {
        DTOSolicitudPosicionDescuento dtoSolPosDesc = new DTOSolicitudPosicionDescuento();
        RecordSet rsDetalle = dtoSolSel.getDetalle();
        //seteo de los tres valores tomados de sesion
        valoresPosicion = obtenerValoresDetalleSolicitudes(itDetalle, dtoSolSel.getCabecera().getOidCabecera(), rsDetalle.getValueAt(r,"OIDSOLICITUDPOSICION") );
        //cantidad
        dtoSolPosDesc.setCantidad( (Long)valoresPosicion.get(0) );//rsDetalle.getValueAt(r,"CANTIDAD") );
        //valorTotal
        dtoSolPosDesc.setValorTotal( (BigDecimal)valoresPosicion.get(1) ); //rsDetalle.getValueAt(r,"VALORTOTAL") );
        //descuento
        dtoSolPosDesc.setImporteDescuentoUnitarioLocal( (BigDecimal)valoresPosicion.get(2) ); // rsDetalle.getValueAt(r,"DESCUENTO") );
		//unidadesPorAtender, le copiamos el valor de cantidad para simular con la cantidad de unidades que ingresa el usuario
		dtoSolPosDesc.setUnidadesPorAtender(dtoSolPosDesc.getCantidad());
		
		dtoSolPosDesc.setCodigoVenta( (String)rsDetalle.getValueAt(r,"CODIGOVENTA") );
        if ( rsDetalle.getValueAt(r,"DESCRIPCIONPRODUCTO") != null )  {
          dtoSolPosDesc.setDescripcionProducto( (String)rsDetalle.getValueAt(r,"DESCRIPCIONPRODUCTO") );  
        }
        if ( rsDetalle.getValueAt(r,"ESTADOPOSICION") != null )  {
          dtoSolPosDesc.setEstadoPosicion( new Long( ((BigDecimal)rsDetalle.getValueAt(r,"ESTADOPOSICION")).toString() )  );
        }
        if ( rsDetalle.getValueAt(r,"OIDCICLOVIDA") != null )  {
          dtoSolPosDesc.setOidCicloVida( new Long( ((BigDecimal)rsDetalle.getValueAt(r,"OIDCICLOVIDA")).toString() )  );
        }
        if ( rsDetalle.getValueAt(r,"OIDGENERICO") != null )  {
          dtoSolPosDesc.setOidGenerico( new Long( ((BigDecimal)rsDetalle.getValueAt(r,"OIDGENERICO")).toString() )  );
        }
        if ( rsDetalle.getValueAt(r,"OIDMARCAPRODUCTO") != null )  {
          dtoSolPosDesc.setOidMarcaProducto( new Long( ((BigDecimal)rsDetalle.getValueAt(r,"OIDMARCAPRODUCTO")).toString() )  );
        }
        if ( rsDetalle.getValueAt(r,"OIDNEGOCIO") != null )  {
          dtoSolPosDesc.setOidNegocio( new Long( ((BigDecimal)rsDetalle.getValueAt(r,"OIDNEGOCIO")).toString() )  );
        }
        dtoSolPosDesc.setOidPosicion( new Long( ((BigDecimal)rsDetalle.getValueAt(r,"OIDSOLICITUDPOSICION")).toString() )  );
        dtoSolPosDesc.setOidProducto( new Long( ((BigDecimal)rsDetalle.getValueAt(r,"OIDPRODUCTO")).toString() )  );//oidProducto
        dtoSolPosDesc.setOidSolicitud( new Long( ((BigDecimal)rsDetalle.getValueAt(r,"OIDSOLICITUDCABECERA")).toString() )  );
        if ( rsDetalle.getValueAt(r,"OIDSUPERGENERICO") != null )  {
          dtoSolPosDesc.setOidSupergenerico( new Long( ((BigDecimal)rsDetalle.getValueAt(r,"OIDSUPERGENERICO")).toString() )  );
        }
        if ( rsDetalle.getValueAt(r,"OIDTIPOOFERTA") != null )  {
          dtoSolPosDesc.setOidTipoOferta( new Long( ((BigDecimal)rsDetalle.getValueAt(r,"OIDTIPOOFERTA")).toString() )  );
        }
        if ( rsDetalle.getValueAt(r,"OIDUNIDADNEGOCIO") != null )  {
          dtoSolPosDesc.setOidUnidadNegocio( new Long( ((BigDecimal)rsDetalle.getValueAt(r,"OIDUNIDADNEGOCIO")).toString() )  );
        }
        dtoSolPosDesc.setPorcentajeDescuento( (BigDecimal)rsDetalle.getValueAt(r,"PORCENTAJEDESCUENTO") );
        dtoSolPosDesc.setPrecioUnitarioCatalogoLocal( (BigDecimal)rsDetalle.getValueAt(r,"PRECIOUNITARIOCATALOGOLOCAL") );
        if ( rsDetalle.getValueAt(r,"PRODUCTOAPORTAMONTOAESCALA") != null )  {
          if ( (new Long( ((BigDecimal)rsDetalle.getValueAt(r,"PRODUCTOAPORTAMONTOAESCALA") ).toString() )).longValue() == 1 )  {
            dtoSolPosDesc.setProductoAportaMontoAEscala( new Boolean(true) );
          } else {
            dtoSolPosDesc.setProductoAportaMontoAEscala( new Boolean(false) );
          }
        }
        if ( rsDetalle.getValueAt(r,"PRODUCTOCOMISIONABLE") != null )  {
          if ( (new Long( ((BigDecimal)rsDetalle.getValueAt(r,"PRODUCTOCOMISIONABLE") ).toString() )).longValue() == 1 )  {
            dtoSolPosDesc.setProductoComisionable( new Boolean(true) );
          } else {
            dtoSolPosDesc.setProductoComisionable( new Boolean(false) );
          }
        }
		dtoSolPosDesc.setOidIdioma( sesion.getIdioma(this) );
        dtoSolPosDesc.setOidPais( sesion.getPais(this) );
        //-> Añadir cada DTOSolicitudPosicionDescuento creado al atributo solicitudDescuento.posiciones
        alSolicitudesPos.add( dtoSolPosDesc );
      }//fin for
      solicitudDescuento.setPosiciones( alSolicitudesPos );

      //Prepara el arraylist para luego agregarlo al DTOSimulacionDescuentos.solicitudes
      alSolicitudesDto.add(solicitudDescuento );
    }//fin while

    //-> Añadir "solicitudDescuento" al atributo DTOSimulacionDescuentos.solicitudes
    dtoSimulDesc.setListaSolicitudes( alSolicitudesDto );
    dtoSimulDesc.setOidIdioma( sesion.getIdioma(this) );
    dtoSimulDesc.setOidPais( sesion.getPais(this) );
    Vector objBusiness = new Vector();
    objBusiness.add( dtoSimulDesc );
    //-> Crear idBusiness = "DTOSimularDescuento"
    objBusiness.add( new MareBusinessID("DTOSimularDescuento") );
      traza("calcular() objBusiness: " + objBusiness);
    //-> Asignar conector "ConectorSimularDescuento" con idBusiness y DTOSimulacionDescuentos creados
    DruidaConector con = conectar("ConectorSimularDescuento",objBusiness);
      traza("con.getXML(): " + con.getXML() );

    //-> Recuperar DTOSimulacionDescuento de respuesta, mapeando los datos de las solicitudes en la
    //lista "solicitudes" y en la variable oculta "detalleSolicitudes", mostrando el descuento calculado y
    //deshabilitando el botón "calcular" y habilitando el botón "aprobar"

//-----------------------------------------------------------
    DTOSimulacionDescuento dtoSimulDto = (DTOSimulacionDescuento)con.objeto("DTOSimulacionDescuento");
      traza("dtoSimulDto: " + dtoSimulDto );
    Iterator it = dtoSimulDto.getListaSolicitudes().iterator();
    String cadenas = "";
//-----------------------------------------------------------
    DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    Document docDestino = docBuilder.newDocument();
    Element rowset2 = docDestino.createElement("ROWSET2");
    Element rowset = docDestino.createElement("ROWSET");
    rowset.setAttribute("ID", "resultado");
    rowset2.appendChild(rowset);
//-----------------------------------------------------------
    while ( it.hasNext() )  {
      //-> Añadir un registro a la lista editable "solicitudes"
      DTOSolicitudDescuento dtoSolicDto = (DTOSolicitudDescuento)it.next();

      Element elemRow = docDestino.createElement("ROW");
      rowset.appendChild(elemRow);
      Element elemDato;
      Text txt;
      String dato;
      
      elemDato = docDestino.createElement("CAMPO");
      elemDato.setAttribute("NOMBRE", "oidCabecera");
      elemDato.setAttribute("TIPO", "STRING");
      elemDato.setAttribute("LONGITUD", "50");
      dato = dtoSolicDto.getOidSolicitud() == null ? "" : dtoSolicDto.getOidSolicitud().toString();
      txt = docDestino.createTextNode(dato);
      elemDato.appendChild(txt);
      elemRow.appendChild(elemDato);

      elemDato = docDestino.createElement("CAMPO");
      elemDato.setAttribute("NOMBRE", "codigoCliente");
      elemDato.setAttribute("TIPO", "STRING");
      elemDato.setAttribute("LONGITUD", "50");
      dato = dtoSolicDto.getCodigoCliente() == null ? "" : dtoSolicDto.getCodigoCliente();
      txt = docDestino.createTextNode(dato);
      elemDato.appendChild(txt);
      elemRow.appendChild(elemDato);

      elemDato = docDestino.createElement("CAMPO");
      elemDato.setAttribute("NOMBRE", "nombreCliente");
      elemDato.setAttribute("TIPO", "STRING");
      elemDato.setAttribute("LONGITUD", "50");
      dato = dtoSolicDto.getNombreCliente() == null ? "" : dtoSolicDto.getNombreCliente();
//      dato = dato + " " + ( dtoCabecera.getApellido1() == null ? "" : dtoCabecera.getApellido1() );
//      dato = dato + " " + ( dtoCabecera.getApellido2() == null ? "" : dtoCabecera.getApellido2() );
      txt = docDestino.createTextNode(dato);
      elemDato.appendChild(txt);
      elemRow.appendChild(elemDato);

      //Campaña
      elemDato = docDestino.createElement("CAMPO");
      elemDato.setAttribute("NOMBRE", "campanya");
      elemDato.setAttribute("TIPO", "STRING");
      elemDato.setAttribute("LONGITUD", "50");
      dato = dtoSolicDto.getNombrePeriodo() == null ? "" : dtoSolicDto.getNombrePeriodo();
      txt = docDestino.createTextNode(dato);
      elemDato.appendChild(txt);
      elemRow.appendChild(elemDato);

      elemDato = docDestino.createElement("CAMPO");
      elemDato.setAttribute("NOMBRE", "fechaSolicitud");
      elemDato.setAttribute("TIPO", "STRING");
      elemDato.setAttribute("LONGITUD", "50");
      dato = dtoSolicDto.getFechaSolicitud() == null ? "" : obtenerFechaFormatoPais(dtoSolicDto.getFechaSolicitud());
      txt = docDestino.createTextNode(dato);
      elemDato.appendChild(txt);
      elemRow.appendChild(elemDato);

      elemDato = docDestino.createElement("CAMPO");
      elemDato.setAttribute("NOMBRE", "montoTotal");
      elemDato.setAttribute("TIPO", "STRING");
      elemDato.setAttribute("LONGITUD", "50");
      dato = dtoSolicDto.getMontoTotalSolicitud() == null ? "" : UtilidadesBelcorp.formateaNumeroSICC(dtoSolicDto.getMontoTotalSolicitud().toString(), this.FORMATO_DEFAULT, this);
      txt = docDestino.createTextNode(dato);
      elemDato.appendChild(txt);
      elemRow.appendChild(elemDato);
//-----------------------------------------------------------
      //-> En cada cadena irán los siguientes campos concatenados: "oidSolicitud|oidPosicion|cantidad|valorTotal|descuento"
      ArrayList alPosiciones = dtoSolicDto.getPosiciones();
        traza("alPosiciones: " + alPosiciones );
      Iterator itPosiciones = alPosiciones.iterator();
      while ( itPosiciones.hasNext() )  {
        DTOSolicitudPosicionDescuento dtoSolicPosDto = (DTOSolicitudPosicionDescuento)itPosiciones.next();
        cadenas = cadenas + dtoSolicPosDto.getOidSolicitud().toString() + "|";
        cadenas = cadenas + dtoSolicPosDto.getOidPosicion().toString() + "|" ;
        cadenas = cadenas + dtoSolicPosDto.getCantidad().toString() + "|" ;
        cadenas = cadenas + dtoSolicPosDto.getValorTotal().toString() + "|" ;
        cadenas = cadenas + dtoSolicPosDto.getImporteDescuentoUnitarioLocal().toString() + "|" ;
          traza("cadenas: " + cadenas);
      }
    }//fin while

    DruidaConector conector = new DruidaConector();
    conector.setXML(rowset2);
    asignar( "LISTADOA", "listado1", conector,"resultado" );
    asignarAtributo("VAR","hDetalleSolicitudes","valor",cadenas);

    //habilitar el boton aprobar
    asignarAtributo("VAR","hBtnAProbarHab","valor","1");
    
  }//fin calcular()

//-----------------------------------------------------------------------------------------------------------------------------
  private void aprobar() throws Exception  {
    //-> Llamar a la lp LPAprobarDescuento con acción = "" pasando el oidDescuento de la variable 
    //oculta de pantalla como parámetro
    conectorAction("LPAprobarDescuento");
    conectorActionParametro("accion","");
    conectorActionParametro("oidDtoSel",oidDescuentoSeleccionado);
  }//fin aprobar()
//-----------------------------------------------------------------------------------------------------------------------------
  private void seleccionarSolicitudes() throws Exception  {
    //Llamar a la lp LPSeleccionarDescuentos con accion = ""
    conectorAction("LPSeleccionarDescuentos");
    conectorActionParametro("accion","");
  }//fin seleccionarSolicitudes()
//-----------------------------------------------------------------------------------------------------------------------------
  private void detalle() throws Exception  {
    //-> Tomar los datos del registro seleccionado en la lista de la pantalla 
    //llamante "contenido_simulacion_descuentos_realizar", para asignarlos a la 
    //cabecera de la pantalla "contenido_solicitudes_pedir_detalle"
    pagina("contenido_solicitudes_pedir_detalle");
    asignarAtributo("LABELC","lbldtCodCliente","valor",codCliente);
    asignarAtributo("LABELC","lbldtNombreCliente","valor",nombreCliente);
    asignarAtributo("LABELC","lbldtCampanaSolicitud","valor",campaniaSolicitud);
    asignarAtributo("LABELC","lbldtFechaSolicitud","valor",fechaSolicitud);
    asignarAtributo("LABELC","lbldtMontoTotalSolicitud","valor",montoTotalSolicitud);
    //-> Crear objeto DTOOID con el oid de la solicitud seleccionada en la lista 
    //resultadosBusqueda de la pantalla "contenido_solicitudes_pedir"
    //Por incidencia 7333 origen de oid de pantalla "contenido_simulación_descuentos_realizar"
    DTOOID dtoOID = new DTOOID();
    dtoOID.setOid( Long.valueOf(oidSolicitud) );

    Vector objBusiness = new Vector();
    objBusiness.add(dtoOID);
    //-> Crear idBusiness "DTOPedirSolicitudesDetalle"
    objBusiness.add( new MareBusinessID("DTOPedirSolicitudesDetalle") );
      traza("detalle() objBusiness: " + objBusiness);
    //-> Asignar conector "ConectorPedirSolicitudesDetalle" ( incidencia 7763 )
    DruidaConector con = conectar("ConectorPedirSolicitudDetalles",objBusiness);
      traza("con: " + con.getXML() );
    //-> Mapear RecordSet del DTOSalida obtenido, en la lista "productosSolicitud" de 
    //la pantalla asignada al principio,
    //y sustituir en cada registro los datos de cantidad, valorTotal y descuento con los datos de
    //la variable "detalleSolicitudes" para la solicitud cuyo detalle se muestra y para cada
    //posición, cuyos datos están guardados de esta forma:
    //"oidSolicitud|oidPosicion|cantidad|valorTotal|descuento"
    DTOSalida dtoSolicitudDetalles = (DTOSalida)con.objeto("DTOSalida");
      traza("dtoSolicitudDetalles: " + dtoSolicitudDetalles );
    RecordSet rsSolicitudDetalles = dtoSolicitudDetalles.getResultado();
    BigDecimal oidSolPos = null;
//-----------------------------------------------------------
    DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    Document docDestino = docBuilder.newDocument();
    Element rowset2 = docDestino.createElement("ROWSET2");
    Element rowset = docDestino.createElement("ROWSET");
    rowset.setAttribute("ID", "resultado");
    rowset2.appendChild(rowset);
//-----------------------------------------------------------
    ArrayList solicitudes = parsearString( detalleSolicitudes );
      traza("solicitudes: " + solicitudes.toString() );
//"oidSolicitud N12 | oidPosicion N12 | cantidad N6 | valorTotal N12,2 | descuento N12,2"
//--------------------------------------------------------------
    for (int i=0; i<rsSolicitudDetalles.getRowCount(); i++)  {

      Element elemRow = docDestino.createElement("ROW");
      rowset.appendChild(elemRow);
      Element elemDato;
      Text txt;
      String dato;

      elemDato = docDestino.createElement("CAMPO");
      elemDato.setAttribute("NOMBRE", "oidPosicion");
      elemDato.setAttribute("TIPO", "STRING");
      elemDato.setAttribute("LONGITUD", "50");
      oidSolPos = (BigDecimal)rsSolicitudDetalles.getValueAt(i,"OIDSOLICITUDPOSICION");
      dato = oidSolPos == null ? "" :  ( oidSolPos ).toString();
      txt = docDestino.createTextNode(dato);
      elemDato.appendChild(txt);
      elemRow.appendChild(elemDato);

      elemDato = docDestino.createElement("CAMPO");
      elemDato.setAttribute("NOMBRE", "codigoVenta");
      elemDato.setAttribute("TIPO", "STRING");
      elemDato.setAttribute("LONGITUD", "50");
      dato = rsSolicitudDetalles.getValueAt(i,"CODIGOVENTA") == null ? "" : (String)rsSolicitudDetalles.getValueAt(i,"CODIGOVENTA");
      txt = docDestino.createTextNode(dato);
      elemDato.appendChild(txt);
      elemRow.appendChild(elemDato);

      elemDato = docDestino.createElement("CAMPO");
      elemDato.setAttribute("NOMBRE", "descripcionProducto");
      elemDato.setAttribute("TIPO", "STRING");
      elemDato.setAttribute("LONGITUD", "50");
      dato = rsSolicitudDetalles.getValueAt(i,"DESCRIPCIONPRODUCTO") == null ? "" : (String)rsSolicitudDetalles.getValueAt(i,"DESCRIPCIONPRODUCTO");
      txt = docDestino.createTextNode(dato);
      elemDato.appendChild(txt);
      elemRow.appendChild(elemDato);

      elemDato = docDestino.createElement("CAMPO");
      elemDato.setAttribute("NOMBRE", "cantidad");
      elemDato.setAttribute("TIPO", "STRING");
      elemDato.setAttribute("LONGITUD", "50");
      dato = (obtenerValor(oidSolPos,solicitudes,2) == null) 
                ? "" : UtilidadesBelcorp.formateaNumeroSICC(String.valueOf((Long)obtenerValor(oidSolPos,solicitudes,2)),this.FORMATO_DEFAULT, this);
      txt = docDestino.createTextNode(dato);
      elemDato.appendChild(txt);
      elemRow.appendChild(elemDato);

      elemDato = docDestino.createElement("CAMPO");
      elemDato.setAttribute("NOMBRE", "precioUnidad");
      elemDato.setAttribute("TIPO", "STRING");
      elemDato.setAttribute("LONGITUD", "50");
      dato = (rsSolicitudDetalles.getValueAt(i,"PRECIOUNITARIOCATALOGOLOCAL") == null) 
                ? "" : UtilidadesBelcorp.formateaNumeroSICC(((BigDecimal)rsSolicitudDetalles.getValueAt(i,"PRECIOUNITARIOCATALOGOLOCAL")).toString(),this.FORMATO_DEFAULT, this);
      txt = docDestino.createTextNode(dato);
      elemDato.appendChild(txt);
      elemRow.appendChild(elemDato);

      elemDato = docDestino.createElement("CAMPO");
      elemDato.setAttribute("NOMBRE", "valorTotal");
      elemDato.setAttribute("TIPO", "STRING");
      elemDato.setAttribute("LONGITUD", "50");
      dato = (obtenerValor(oidSolPos,solicitudes,3) == null) 
                ? "" : UtilidadesBelcorp.formateaNumeroSICC(String.valueOf((BigDecimal)obtenerValor(oidSolPos,solicitudes,3)), this.FORMATO_DEFAULT, this);
      txt = docDestino.createTextNode(dato);
      elemDato.appendChild(txt);
      elemRow.appendChild(elemDato);

      elemDato = docDestino.createElement("CAMPO");
      elemDato.setAttribute("NOMBRE", "descuento");
      elemDato.setAttribute("TIPO", "STRING");
      elemDato.setAttribute("LONGITUD", "50");
      dato = (obtenerValor(oidSolPos,solicitudes,4) == null)
                ? "" : UtilidadesBelcorp.formateaNumeroSICC(String.valueOf((BigDecimal)obtenerValor(oidSolPos,solicitudes,4)), this.FORMATO_DEFAULT, this);
      txt = docDestino.createTextNode(dato);
      elemDato.appendChild(txt);
      elemRow.appendChild(elemDato);
    }
//--------------------------------------------------------------
    DruidaConector conector = new DruidaConector();
    conector.setXML(rowset2);
    asignar( "LISTADOA", "listado1", conector,"resultado" );
//--------------------------------------------------------------

  }//fin detalle()
//-----------------------------------------------------------------------------------------------------------------------------
  public ArrayList parsearString(String aParsear) throws Exception  {
    StringTokenizer stk = new StringTokenizer(aParsear,"|");
    ArrayList cabeceras = new ArrayList();
    while (stk.hasMoreTokens())  {
      ArrayList posiciones = new ArrayList();
      posiciones.add( stk.nextToken() ); //oidSolicitud
      posiciones.add( Long.valueOf(stk.nextToken()) ); //oidPosicion
      posiciones.add( Long.valueOf(stk.nextToken()) ); //cantidad
      posiciones.add( new BigDecimal(stk.nextToken()) ); //valorTotal
      posiciones.add( new BigDecimal(stk.nextToken()) ); //descuento
      cabeceras.add(posiciones);
    }
    return cabeceras;
  }


  public ArrayList parsearSolicitudesSeleccionadas(String aParsear) throws Exception  {
    StringTokenizer stk = new StringTokenizer(aParsear,"|");
    ArrayList claves = new ArrayList();
    while (stk.hasMoreTokens())  {
      claves.add(Long.valueOf(stk.nextToken()));
    }
    return claves;
  }

  /*
   * Devuelve el valor de sesion pedido ( cantidad, valorTotal o descuento )
   * cuando el oid de la solicitud y el oid de la posicion del arraylist
   * coinciden con el oid del recordset obtenido de la base de datos
   */
  private Object obtenerValor(BigDecimal oidPosicion, ArrayList al,int i) throws Exception  {
    Iterator itDetalle = al.iterator();
    ArrayList posicion = null;
    Object valor = null;
    String oidSolicitudSesion = "";
    BigDecimal oidPosicionSesion = null;
    while ( itDetalle.hasNext() )  {
      posicion = (ArrayList)itDetalle.next();
      oidSolicitudSesion = (String)posicion.get(0);
      oidPosicionSesion = new BigDecimal( String.valueOf((Long)posicion.get(1)) );
      
      if ( (oidSolicitud.equals( oidSolicitudSesion )) && ((oidPosicion).equals(oidPosicionSesion)) )
      {
        valor = posicion.get(i);
      }
    }
    return valor;
  }


  /*
   * Devuelve los valores de sesion ( cantidad, valorTotal o descuento )
   * cuando el oid de la solicitud y el oid de la posicion
   * coinciden tanto en sesion como en base de datos
   */
  private ArrayList obtenerValoresDetalleSolicitudes(Iterator it, Long oidCabecera, Object oidPosicion ) throws Exception  {
    ArrayList valoresBuscados = new ArrayList();
    boolean encontro = false;

    while ( (!encontro) && (it.hasNext()) )  {
      ArrayList posicion = (ArrayList)it.next();
        traza("posicion: " + posicion );
      if ( ( oidCabecera.toString().equals( (String)posicion.get(0) ) ) && ( ( new Long( ((BigDecimal)oidPosicion).toString() ) ).equals( (Long)posicion.get(1) ) ) ) {
        valoresBuscados.add( posicion.get(2) );
        valoresBuscados.add( posicion.get(3) );
        valoresBuscados.add( posicion.get(4) );
        encontro = true;
      }
    }
      traza("valoresBuscados: " + valoresBuscados.toString() );
    return valoresBuscados;
  } 


    /**
     * Retorna string fecha en formato YYYY-MM-DD, tal como lo maneja Date.
     * Recibe el string fecha en formato en el formato del pais. 
     */
    private String obtenerFechaFormatoDate(String fecha) throws Exception {
        // obtenemos el formato de fecha segun el pais
        // String formatoFecha = conectorParametro("hFormatoFechaPais");
        String formatoFecha = UtilidadesSession.getFormatoFecha(this);
        // aseguro el indicador de mes a mayuscula  
        formatoFecha = formatoFecha.replace('m','M');
        //trabajamos con el formato del pais
        SimpleDateFormat formatoPais = new SimpleDateFormat(formatoFecha);
        //formateamos la fecha segun el formato Date yyyy-mmm-dd
        Date fechaFormatoDate = new java.sql.Date(formatoPais.parse(fecha).getTime());
        //retorna la fecha formateada
        return fechaFormatoDate.toString();
    }


    /**
     * Retorna el string fecha segun el formato por pais.
     * La fecha a formatear viene en formato Date YYYY-MM-DD.
     */
    private String obtenerFechaFormatoPais(Date fecha) throws Exception {
        // obtenemos el formato de fecha segun el pais
        // String formatoFecha = conectorParametro("hFormatoFechaPais");
        String formatoFecha = UtilidadesSession.getFormatoFecha(this);
        // aseguro el indicador de mes a mayuscula  
        formatoFecha = formatoFecha.replace('m','M');
        //trabajamos con el formato del pais
        SimpleDateFormat formatoPais = new SimpleDateFormat(formatoFecha);
        //formateamos la fecha segun el formato del pais
        String fechaFormatoPaisStr = formatoPais.format(fecha);
        //retorna la fecha formateada
        return fechaFormatoPaisStr;
    }


    /**
     * Recarga la pagina luego de un error.
     * Si es un error de negocio, recarga la pagina segun el error particular.
     * El estado deseado es el mismo que produce ejecucion.
     */
    private void recargaPostError(Exception ex) throws Exception {
        traza("metodo recargaPostError");
        // si no es Error peticion de datos no existente, reinicia la simulacion.
		if (ex instanceof MareException) {
			MareException mex =(MareException)ex;
			traza("codigo mex: " + mex.getCode());
            //Recarga post error existe ya el grupo de zonas en la matriz
            if (mex.getCode() == 5) {
				// Error peticion de datos no existente.
				traza("Error peticion de datos no existente.");
				return;
            }
		}
		traza("Recarga de error de negocio");
		// 1.- obtenemos estado inicial, variable ocultas y demas.
		this.obtenerEstadoInicial();
		// 2.- recarga la pagina con el estado inicial
		this.inicioSimulacion();
	}


    /**
     * Imprime el stack trace en caso de errores.
     */
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


}//fin clase


/*****************************************************************************************************************
Class LPSimulacionDescuento {Java}
**********************************

Operation --Not Named-- ejecucion (), in Class LPSimulacionDescuento

Documentation
Si acción = "" entonces 
-> ejecutar método privado inicioSimulacion() 
Si no Si acción = "calcular" entonces 
-> ejecutar método privado calcular() 
Si no Si acción = "detalle" entonces 
-> ejecutar método privado detalle() 
Si no Si acción = "aprobar" entonces 
-> ejecutar método privado aprobar() 
Si no Si acción = "seleccionarSolicitudes" entonces 
-> ejecutar método privado seleccionarSolicitudes() 
Fin Si 

-----------------------------------------------------------------------------------------------------------------------------

Operation --Not Named-- inicioSimulacion (), in Class LPSimulacionDescuento

Documentation
-> Asignar página "contenido_simulacion_descuentos_realizar" 
-> Tomar del request el valor del parámetro oidDescuento 
-> Mapear ese valor en la variable oculta de pantalla oidDescuento 
-> Tomar de sesión la variable "solicitudesSeleccionadas" de tipo arrayList con oidSolicitud de las solicitudes seleccionadas 
-> Crear objeto DTOColeccion con array anterior 
-> Crear idBusiness = "DTOCargarSolicitudes" 
-> Asignar conector "ConectorCargarSolicitudes" 
-> Obtener objeto DTOColeccion de respuesta y ponerlo en sesión con el nombre "datosSolicitudesSeleccionadas" 
-> Hacer el siguiente mapeo en pantalla: 
Para cada objeto DTOSolicitudSeleccionada hacer: 
-> Añadir un registro a la lista editable "solicitudes" con los datos de DTOSolicitudCabecera 
-> Añadir a la variable oculta "detalleSolicitud" de pantalla un array de cadenas 
-> En cada cadena irán los siguientes campos concatenados: "oidSolicitud|oidPosicion|cantidad|valorTotal|descuento" 
Fin Para 
-> deshabilitar los botones aprobar y calcular, y dejar habilitados los botones modificarSolicitud y seleccionarSolicitudes 

-----------------------------------------------------------------------------------------------------------------------------

Operation --Not Named-- calcular (), in Class LPSimulacionDescuento

Documentation
-> Tomar de sesión la variable "datosSolicitudesSeleccionadas" de tipo DTOColeccion, que lleva un array de objetos DTOSolicitudSeleccionada 
-> Lo guardaremos en una variable llamada "coleccionSolicitudes" 
-> Crear un objeto DTOSimulacionDescuento 
-> Añadir al atributo DTOSimulacionDescuento.oidDescuento el valor de la variable oculta de pantalla oidDescuento 
-> Tomar el valor de la variable oculta de pantalla "detalleSolicitudes" y recorrerlo 
Para cada elemento hacer: 
-> Crear objeto DTOSolicitudDescuento llamado "solicitudDescuento" 
-> Buscar en "coleccionSolicitudes" aquella solicitud (DTOSolicitudSeleccionada) cuyo oid coincida con el oid de solicitud guardado en el elemento 
-> Tomar los datos DTOSolicitudSeleccionada.cabecera y mapearlos todos a "solicitudDescuento" 
-> Recorrer el RecordSet DTOSolicitudSeleccionada.detalle 
-> Por cada registro crear un objeto DTOSolicitudPosicionDescuento mapeando todos los datos menos aquellos que están en la posición del elemento, que son: cantidad, valorTotal y descuento 
-> Añadir cada DTOSolicitudPosicionDescuento creado al atributo solicitudDescuento.posiciones 
-> Añadir "solicitudDescuento" al atributo DTOSimulacionDescuentos.solicitudes 
Fin Para 
-> Crear idBusiness = "DTOSimularDescuento" 
-> Asignar conector "ConectorSimularDescuento" con idBusiness y DTOSimulacionDescuentos creados 
-> Recuperar DTOSimulacionDescuento de respuesta, mapeando los datos de las solicitudes en la lista "solicitudes" y en la variable oculta "detalleSolicitudes", mostrando el descuento calculado y deshabilitando el botón "calcular" y habilitando el botón "aprobar"

-----------------------------------------------------------------------------------------------------------------------------

Operation --Not Named-- aprobar (), in Class LPSimulacionDescuento

Documentation
-> Llamar a la lp LPAprobarDescuento con acción = "" pasando el oidDescuento de la variable oculta de pantalla como parámetro
-----------------------------------------------------------------------------------------------------------------------------

Operation --Not Named-- seleccionarSolicitudes (), in Class LPSimulacionDescuento

Documentation
Llamar a la lp LPSeleccionarDescuentos con accion = ""
-----------------------------------------------------------------------------------------------------------------------------

Operation --Not Named-- detalle (), in Class LPSimulacionDescuento

Documentation
-> Tomar los datos del registro seleccionado en la lista de la pantalla 
llamante "contenido_simulacion_descuentos_realizar", para asignarlos a la 
cabecera de la pantalla "contenido_solicitudes_pedir_detalle" 
-> Crear objeto DTOOID con el oid de la solicitud seleccionada en la lista 
resultadosBusqueda de la pantalla "contenido_solicitudes_pedir" 
-> Crear idBusiness "DTOPedirSolicitudesDetalle" 
-> Asignar conector "ConectorPedirSolicitudesDetalle" 
-> Mapear RecordSet del DTOSalida obtenido en la lista "productosSolicitud" de 
la pantalla asignada al principio, y sustituir en cada registro los datos de cantidad, valorTotal y descuento con los datos de la variable "detalleSolicitudes" para la solicitud cuyo detalle se muestra y para cada posición, cuyos datos están guardados de esta forma: "oidSolicitud|oidPosicion|cantidad|valorTotal|descuento". 
/*****************************************************************************************************************/
