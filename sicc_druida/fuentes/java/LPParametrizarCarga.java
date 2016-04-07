/*
    INDRA/CAR/PROY
    $Id: LPParametrizarCarga.java,v 1.2 2010/10/19 17:30:22 peextsapaza Exp $
    DESC
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.mav.DTOCargaParametrizacion;
import es.indra.sicc.dtos.mav.DTOParametrizacionMAV;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesSession;


public class LPParametrizarCarga extends LPSICCBase {

  String casoDeUso;
  String accion;

  String oIDParametrizacionMAV;
  String numRegsProdsGenerados;
  String limitePrecio;
  String autorizacionEnvioPago;
  String estrategia;
  String almacen;
  String dirElectronica;
  String tiposClienteRegion;
  String subtiposClienteRegion;
  String tiposClienteZona;
  String subtiposClienteZona;
  String subtiposCliente = "";
  Long oidsSTCRegion[] = null;
  Long oidsSTCZona[]= null;

  String catalogo;
  String condicionPromocion;
  
  public LPParametrizarCarga()  {
    super();
  }

  public void inicio() throws Exception  {
    pagina("contenido_carga_parametrizar");
  }

  public void ejecucion() throws Exception  {
    try{
      rastreo();
        setTrazaFichero();
      casoDeUso = conectorParametroLimpia("hCasoDeUso","",true);
      accion = conectorParametroLimpia("accion","",true);

      traza(" ");
      traza("********************************************************");
      traza("********************* ejecucion() LPParametrizarCarga **********************");
      traza("********************************************************");
      traza("casoDeUso : "     + casoDeUso);
      traza("accion : "        + accion);

//accion == " " ---------------------------------------------------------------------------
      if (accion.equals(""))  {
          traza( "Entro en accion " + accion );
        //-> Construir objeto "DTOOID" asignando al atributo oid el oid del pais activo tomándolo de la sesión.
        DTOOID dtoOID = new DTOOID();
        dtoOID.setOidPais(new UtilidadesSession().getPais(this));
        //-> Construir idBusiness = "MAVCargarParametrizacion"
        Vector objBussines = new Vector();
        objBussines.add(dtoOID);
        objBussines.add( new MareBusinessID("MAVCargarParametrizacion") );
        //-> Asignar conector "ConectorCargaParametrizacion"
        DruidaConector con = conectar("ConectorCargaParametrizacion",objBussines);
        //-> Recuperar el dto de salida "DTOCargaParametrizacion"
        DTOCargaParametrizacion dtoOut = (DTOCargaParametrizacion) con.objeto("DTOSalida");
          traza("Registro a parametrizar: dtoOut " + dtoOut);
        //-> Construir un objeto "DTOBelcorp"
        DTOBelcorp dtoIn = new DTOBelcorp();
        dtoIn.setOidPais(new UtilidadesSession().getPais(this));
        dtoIn.setOidIdioma(new UtilidadesSession().getIdioma(this));
          traza( dtoIn );
        asignarAtributo("VAR","hOidIdioma","valor", new UtilidadesSession().getIdioma(this).toString() );          
        //Si el atributo "DTOCargaParametrizacion.parametrizacionMAV" es igual a NULL entonces
        if ( dtoOut.getParametrizacionMAV() == null)  {
          //-> Llamar al subsistema GestorCargaPantalla con los siguientes datos:
          //idBusiness "MAEObtenerTipos" y "DTOBelcorp" => llena combo TipoClienteZona
          //idBusiness "MAEObtenerTipos" y "DTOBelcorp" => llena combo TipoClienteRegion
          //idBusiness "PREBuscarEstrategias" y "DTOBelcorp" => llena combo Estrategia
          //idBusiness "BELObtieneAlmacenPais" y "DTOBelcorp" => llena combo Almacen 
          cargarCombosInsertar(dtoIn);
          asignarAtributo("LABELC","lblPaisActual","valor",new UtilidadesSession().getDescripcionPais(this));

        }
        else {
          //-> Construir objeto "DTOOID" asignando al atributo "oid" el "oidTipoCliente" recuperado 
          //en el RecordSet "DTOCargaParametrizacion.parametrizacionMAV"
          DTOOID dtoOidTipoClienteRegion = new DTOOID();
          dtoOidTipoClienteRegion.setOidIdioma(new UtilidadesSession().getIdioma(this));
          dtoOidTipoClienteRegion.setOid( Long.valueOf(dtoOut.getParametrizacionMAV().getValueAt(0,"TICL_OID_TIPO_CLIE_REGI").toString()) );
          //-> Llamar al subsistema GestorCargaPantalla con los siguientes campos:
          //idBusiness "MAEObtenerTipos" y DTOBelcorp => llena combo TipoClienteZona
          //idBusiness "MAEObtenerTipos" y DTOBelcorp => llena combo TipoClienteRegion
          //idBusiness "PREBuscarEstrategias" y "DTOBelcorp" => llena combo Estrategia
          //idBusiness "BELObtieneAlmacenPais" y "DTOBelcorp" => llena combo Almacen 
          //idBusiness "MAEobtenerSubtipos" y DTOOID => llena combo SubtipoClienteGerenteZona
          //idBusiness "MAEobtenerSubtipos" y DTOOID => llena combo SubtipoClienteGerenteRegion
          cargarCombosModificar(dtoIn,dtoOidTipoClienteRegion);
          // y combo SubtipoClienteGerenteZona
          DTOOID dtoOidTipoClienteZona = new DTOOID();
          dtoOidTipoClienteZona.setOidIdioma(new UtilidadesSession().getIdioma(this));
          dtoOidTipoClienteZona.setOid( Long.valueOf(dtoOut.getParametrizacionMAV().getValueAt(0,"TICL_OID_TIPO_CLIE_ZONA").toString()) );
          cargarCombosModificarSTCZona(dtoOidTipoClienteZona);

          //-> Asignar a pantalla la información del objeto DTOCargaParametrizacion y
          //dejar seleccionados los valores recuperados en los combos y multiselect correspondientes.

          //El RecordSet "DTOCargaParametrizacion.parametrizacionMAV" llena los campos de pantalla:
          // país
          asignarAtributo("LABELC","lblPaisActual","valor",new UtilidadesSession().getDescripcionPais(this));
          //oIDParametrizacionMAV para accion Guardar
          asignarAtributo("VAR","hOidParametrizacionMAV","valor",dtoOut.getParametrizacionMAV().getValueAt(0,"OID_PARA_MAV").toString());
          //- numRegistrosProductosGenerados
          asignarAtributo("CTEXTO","textNRegistroProductosGenerados","valor",dtoOut.getParametrizacionMAV().getValueAt(0,"NUM_REGI_AVIS").toString());
          //- limitePrecio
          asignarAtributo("CTEXTO","textLimitePrecio","valor",dtoOut.getParametrizacionMAV().getValueAt(0,"VAL_LIMI_PREC_AUTO").toString());
          //- autorizacionEnvio (RadioButton S/N)
          String autorizacion = dtoOut.getParametrizacionMAV().getValueAt(0,"IND_REQU_AUTO").toString();
          if ( autorizacion == "0"  ) { asignarAtributo("VAR","hRbAutorizacionEnvioPago","valor","N"); }
          else { asignarAtributo("VAR","hRbAutorizacionEnvioPago","valor","S"); }
          //- estrategia
          asignarAtributo("VAR","hCbEstrategia","valor",dtoOut.getParametrizacionMAV().getValueAt(0,"COES_OID_ESTR").toString());
          //- almacen
          asignarAtributo("VAR","hCbAlmacen","valor",dtoOut.getParametrizacionMAV().getValueAt(0,"ALMC_OID_ALMA").toString());
          //- direccionElectronica
          asignarAtributo("CTEXTO","textDireccionElectronica","valor",dtoOut.getParametrizacionMAV().getValueAt(0,"VAL_DIRE_ELEC_ENVI_FALT_STOC").toString());
          
          //- catalogo          
          if(dtoOut.getParametrizacionMAV().getValueAt(0,"OCAT_OID_CATA")!=null)
        	  asignarAtributo("VAR","hCbCatalogo","valor",dtoOut.getParametrizacionMAV().getValueAt(0,"OCAT_OID_CATA").toString());

          //- condicion promocion          
          if(dtoOut.getParametrizacionMAV().getValueAt(0,"CNDP_OID_COND_PROM")!=null)
        	  asignarAtributo("VAR","hCbCondicionPromocion","valor",dtoOut.getParametrizacionMAV().getValueAt(0,"CNDP_OID_COND_PROM").toString());


          //- tipoClienteRegion (Seleccionar valor en combo cargado)
          asignarAtributo("VAR","hCbTipoCliente1","valor",dtoOut.getParametrizacionMAV().getValueAt(0,"TICL_OID_TIPO_CLIE_REGI").toString());
          //- tipoClienteZona (Seleccionar valor en combo cargado)
          asignarAtributo("VAR","hCbTipoCliente2","valor",dtoOut.getParametrizacionMAV().getValueAt(0,"TICL_OID_TIPO_CLIE_ZONA").toString());
          //El RecordSet "DTOCargaParametrizacion.parametrizacionGRegion" llena los campos de pantalla:
          //- subtipoClienteGerenteRegion (Seleccionar los valores en el multiselect cargado)
          if ( dtoOut.getParametrizacionGRegion() != null )  {
            int i = 0;
            while ( (dtoOut.getParametrizacionGRegion().existeFila(i)) )  {
              subtiposCliente = subtiposCliente.concat( dtoOut.getParametrizacionGRegion().getValueAt(i,"SBTI_OID_SUBT_CLIE").toString() );
              subtiposCliente = subtiposCliente.concat("|");
              i++;
            }
          }
          if ( subtiposCliente.length() != 0 ) subtiposCliente = subtiposCliente.substring( 0 , (subtiposCliente.length()-1) );
           traza("subtiposClienteRegion : "+ subtiposCliente);
          asignarAtributo("VAR","hCbSubtipoCliente1","valor",subtiposCliente);
          //El RecordSet "DTOCargaParametrizacion.parametrizacionGZona" llena los campos de pantalla:
          //- subtipoClienteGerenteZona (Seleccionar los valores en el multiselect cargado)
          if ( dtoOut.getParametrizacionGZona() != null )  {
            int j = 0;
            subtiposCliente = "";
            while ( (dtoOut.getParametrizacionGZona().existeFila(j)) )  {
              subtiposCliente = subtiposCliente.concat( dtoOut.getParametrizacionGZona().getValueAt(j,"SBTI_OID_SUBT_CLIE").toString() );
              subtiposCliente = subtiposCliente.concat("|");
              j++;
            }
          }
        if ( subtiposCliente.length() != 0 ) subtiposCliente = subtiposCliente.substring( 0 , (subtiposCliente.length()-1) );
           traza("subtiposClienteZona : "+ subtiposCliente);
          asignarAtributo("VAR","hCbSubtipoCliente2","valor",subtiposCliente);
        }
            traza("Sale de accion vacia");
      } //accion == " "

  //accion == "Guardar" ----------------------------------------------------------------------
        if (accion.equals("Guardar"))  {
            traza( "Entro en accion " + accion );
          pagina("salidaGenerica");
          oIDParametrizacionMAV = conectorParametroLimpia("hOidParametrizacionMAV","",true);
          numRegsProdsGenerados = conectorParametroLimpia("textNRegistroProductosGenerados","",true);
          limitePrecio = conectorParametroLimpia("textLimitePrecio","",true);
          autorizacionEnvioPago = conectorParametroLimpia("rbAutorizacionEnvioPago","",true);
          estrategia = conectorParametroLimpia("cbEstrategia","",true);
          almacen = conectorParametroLimpia("cbAlmacen","",true);
          dirElectronica = conectorParametroLimpia("textDireccionElectronica","",true);
          
          catalogo = conectorParametroLimpia("cbCatalogo","",true);
          condicionPromocion = conectorParametroLimpia("cbCondicionPromocion","",true);
          
          tiposClienteRegion = conectorParametroLimpia("cbTipoCliente1","",true);
          subtiposClienteRegion = conectorParametroLimpia("cbSubtipoCliente1","",true);
          tiposClienteZona = conectorParametroLimpia("cbTipoCliente2","",true);
          subtiposClienteZona = conectorParametroLimpia("cbSubtipoCliente2","",true);
          traza("oIDParametrizacionMAV : "  + oIDParametrizacionMAV);
          traza("numRegsProdsGenerados : "  + numRegsProdsGenerados);
          traza("limitePrecio : "           + limitePrecio);
          traza("autorizacionEnvioPago : "  + autorizacionEnvioPago);
          traza("estrategia : "             + estrategia);
          traza("almacen : "                + almacen);
          traza("dirElectronica : "         + dirElectronica);
          traza("tiposClienteRegion : "     + tiposClienteRegion);
          traza("subtiposClienteRegion : "  + subtiposClienteRegion);
          traza("tiposClienteZona : "       + tiposClienteZona);
          traza("subtiposClienteZona : "    + subtiposClienteZona);

          //-> Crear objeto "DTOParametrizacionMAV" tomando los datos de la página
          DTOParametrizacionMAV dtoGuardar = new DTOParametrizacionMAV();

          if ( oIDParametrizacionMAV == null || oIDParametrizacionMAV.equals("") )  { 
            dtoGuardar.setOidParametrizacionMAV(null);
          } else dtoGuardar.setOidParametrizacionMAV( Long.valueOf(oIDParametrizacionMAV) );

          dtoGuardar.setOidPais(new UtilidadesSession().getPais(this));
/*          if ( numRegsProdsGenerados == null || numRegsProdsGenerados.equals("") );
          else */
          dtoGuardar.setNumeroRegistrosAviso( Long.valueOf(numRegsProdsGenerados) );
/*          if ( limitePrecio == null || limitePrecio.equals("") );
          else */
          dtoGuardar.setLimitePrecioAutorizacion( Long.valueOf(limitePrecio) );
/*          if ( autorizacionEnvioPago == null || autorizacionEnvioPago.equals("") );
          else */
          if ( autorizacionEnvioPago.equals("S") ) dtoGuardar.setAutorizacionEnvio( Boolean.TRUE );
          else dtoGuardar.setAutorizacionEnvio( Boolean.FALSE);
/*          if ( estrategia == null || estrategia.equals("") );
          else */
          dtoGuardar.setOidEstrategia( Long.valueOf(estrategia) );
/*          if ( almacen == null || almacen.equals("") );
          else */
          dtoGuardar.setOidAlmacen( Long.valueOf(almacen) );
/*          if ( dirElectronica == null || dirElectronica.equals("") );
          else */
          dtoGuardar.setDireccionElectronicaEnvio( dirElectronica );
          
          if(!catalogo.equals(""))
        	  dtoGuardar.setOidCatalogo(Long.valueOf(catalogo));
          if(!condicionPromocion.equals(""))
        	  dtoGuardar.setOidCondicionPromocion(Long.valueOf(condicionPromocion));
          
          //Gerentes de región
/*          if ( tiposClienteRegion == null || tiposClienteRegion.equals("") );
          else */
          dtoGuardar.setOidTipoClienteRegion( Long.valueOf(tiposClienteRegion) );
/*          if ( subtiposClienteRegion == null || subtiposClienteRegion.equals("") );
          else */
          DTOOIDs dtoOidsRegion = new DTOOIDs();
          //subtiposClienteRegion
          Vector vectorOidsR = parsearString( subtiposClienteRegion );
          oidsSTCRegion = vec2Longs( vectorOidsR );
          dtoOidsRegion.setOids( oidsSTCRegion );
          dtoGuardar. setSubtiposClienteGerenteRegion( dtoOidsRegion );
          //Gerentes de zona
/*          if ( tiposClienteZona == null || tiposClienteZona.equals("") );
          else */
          dtoGuardar.setOidTipoClienteZona( Long.valueOf(tiposClienteZona) );
/*          if ( subtiposClienteZona == null || subtiposClienteZona.equals("") );
          else */
          DTOOIDs dtoOidsZona = new DTOOIDs();
          //subtiposClienteZona
          Vector vectorOidsZ = parsearString( subtiposClienteZona );
          oidsSTCZona = vec2Longs( vectorOidsZ );
          dtoOidsZona.setOids( oidsSTCZona );
          dtoGuardar.setSubtiposClienteGerenteZona( dtoOidsZona );
            traza( "dtoGuardar : " + dtoGuardar );

          Vector objBusiness = new Vector();
          objBusiness.add( dtoGuardar );
          //-> Crear idBusiness = "MAVGuardarParametrizacion"
          objBusiness.add( new MareBusinessID("MAVGuardarParametrizacion") );

          //-> Asignar conector "ConectorGuardarParametrizacion"
          conectar("ConectorGuardarParametrizacion",objBusiness);
		  asignarAtributo("VAR", "ejecutar", "valor", "muestraExito()");
            traza("Sale de accion Guardar");
        }

      } catch (Exception e) {
          lanzarPaginaError(e);
          logStackTrace(e);
        }

      getConfiguracionMenu("LPMantenimientoActividadesMAV","insertar");

    }


  public Long[] vec2Longs( Vector vec ) throws Exception {
    Iterator iter = vec.iterator();
    Long[] objs = new Long[vec.size()] ;
    for(int i = 0; iter.hasNext() ; i++)  {
      objs[i] = (Long)iter.next();
    }
    return objs;
  }


  public Vector parsearString(String aParsear) throws Exception  {
    StringTokenizer stk = new StringTokenizer(aParsear,"|");
    Vector claves = new Vector();
    while (stk.hasMoreTokens())  {
      claves.addElement( new Long( stk.nextToken() ) );
    }
    return claves;
  }


	private void cargarCombosInsertar(DTOBelcorp dtoB) throws Exception  {
		//Preparamos los parametros del subsistema
		ComposerViewElementList cv = crearParametrosInsertar(dtoB);
		//Utilizamos el subsistema
		ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
		conector.ejecucion();
		DruidaConector resultados = conector.getConector();
      traza("resultados: " + resultados.getXML() );
		//Cargamos los combos con los resultados
		asignar("COMBO", "cbTipoCliente1", resultados, "MAEObtenerTipos");
		asignar("COMBO", "cbTipoCliente2", resultados, "MAEObtenerTipos");    
		asignar("COMBO", "cbEstrategia", resultados, "PREBuscarEstrategias");
		asignar("COMBO", "cbAlmacen", resultados, "BELObtieneAlmacenPais");
		
		asignar("COMBO", "cbCatalogo", resultados, "MAVCargarCatalagosBP");
		asignar("COMBO", "cbCondicionPromocion", resultados, "MAVObtenerCondicionesPromocion");
	}  


  private ComposerViewElementList crearParametrosInsertar(DTOBelcorp dto)  {
    ComposerViewElementList lista = new ComposerViewElementList(); 
		//combo TipoClienteRegion y combo TipoClienteZona
		ComposerViewElement ci1 = new ComposerViewElement();
		ci1.setIDBusiness("MAEObtenerTipos");
		ci1.setDTOE(dto);
		//combo Estrategia
		ComposerViewElement ci2 = new ComposerViewElement();
		ci2.setIDBusiness("PREBuscarEstrategias");
		ci2.setDTOE(dto);
		//combo Almacen
		ComposerViewElement ci3 = new ComposerViewElement();
		ci3.setIDBusiness("BELObtieneAlmacenPais");
		ci3.setDTOE(dto);

		// sapaza -- PER-SiCC-2010-0606 -- 18/10/2010
        ComposerViewElement ci5 = new ComposerViewElement();
        ci5.setIDBusiness("MAVCargarCatalagosBP");          
        ci5.setDTOE(dto);
        ComposerViewElement ci6 = new ComposerViewElement();
        ci6.setIDBusiness("MAVObtenerCondicionesPromocion");          
        ci6.setDTOE(dto);
        
		lista.addViewElement(ci1);
		lista.addViewElement(ci2);
		lista.addViewElement(ci3);

		lista.addViewElement(ci5); // sapaza -- PER-SiCC-2010-0606 -- 18/10/2010
		lista.addViewElement(ci6); // sapaza -- PER-SiCC-2010-0606 -- 18/10/2010
		
		return lista;
	}


	private void cargarCombosModificar(DTOBelcorp dtoB, DTOOID dtoOidTCRegion) throws Exception  {
  	//Preparamos los parametros del subsistema
		ComposerViewElementList cv = crearParametrosModificar(dtoB,dtoOidTCRegion);
		//Utilizamos el subsistema
		ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
		conector.ejecucion();
		DruidaConector resultados = conector.getConector();
      traza("resultados: " + resultados.getXML() );
		//Cargamos los combos con los resultados
		asignar("COMBO", "cbTipoCliente1", resultados, "MAEObtenerTipos");
		asignar("COMBO", "cbTipoCliente2", resultados, "MAEObtenerTipos");    
		asignar("COMBO", "cbEstrategia", resultados, "PREBuscarEstrategias");
		asignar("COMBO", "cbAlmacen", resultados, "BELObtieneAlmacenPais");
		asignar("COMBO", "cbSubtipoCliente1", resultados, "MAEobtenerSubtipos");
		asignar("COMBO", "cbSubtipoCliente2", resultados, "MAEobtenerSubtipos");

		asignar("COMBO", "cbCatalogo", resultados, "MAVCargarCatalagosBP");
		asignar("COMBO", "cbCondicionPromocion", resultados, "MAVObtenerCondicionesPromocion");
	}

  private ComposerViewElementList crearParametrosModificar(DTOBelcorp dto, DTOOID dtoOidRegion)  {
    ComposerViewElementList lista = new ComposerViewElementList();
		//combo TipoClienteRegion y combo TipoClienteZona
		ComposerViewElement ci1 = new ComposerViewElement();
		ci1.setIDBusiness("MAEObtenerTipos");
		ci1.setDTOE(dto);
		//combo Estrategia
		ComposerViewElement ci2 = new ComposerViewElement();
		ci2.setIDBusiness("PREBuscarEstrategias");
		ci2.setDTOE(dto);
		//combo Almacen
		ComposerViewElement ci3 = new ComposerViewElement();
		ci3.setIDBusiness("BELObtieneAlmacenPais");
		ci3.setDTOE(dto);

    //combo SubtipoClienteGerenteRegion
		ComposerViewElement ci4 = new ComposerViewElement();
		ci4.setIDBusiness("MAEobtenerSubtipos");
		ci4.setDTOE(dtoOidRegion);
		
		// sapaza -- PER-SiCC-2010-0606 -- 18/10/2010
        ComposerViewElement ci5 = new ComposerViewElement();
        ci5.setIDBusiness("MAVCargarCatalagosBP");          
        ci5.setDTOE(dto);
        ComposerViewElement ci6 = new ComposerViewElement();
        ci6.setIDBusiness("MAVObtenerCondicionesPromocion");          
        ci6.setDTOE(dto);
		
		lista.addViewElement(ci1);
		lista.addViewElement(ci2);
		lista.addViewElement(ci3);
		lista.addViewElement(ci4);
		lista.addViewElement(ci5); // sapaza -- PER-SiCC-2010-0606 -- 18/10/2010
		lista.addViewElement(ci6); // sapaza -- PER-SiCC-2010-0606 -- 18/10/2010
		return lista;
	}


	private void cargarCombosModificarSTCZona(DTOOID dtoOidTCZona) throws Exception  {
  	//Preparamos los parametros del subsistema
		ComposerViewElementList cv = crearParametrosModificarSTCZona(dtoOidTCZona);
		//Utilizamos el subsistema
		ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
		conector.ejecucion();
		DruidaConector resultados = conector.getConector();
      traza("resultadosSTCZona: " + resultados.getXML() );
		//Cargamos los combos con los resultados
		asignar("COMBO", "cbSubtipoCliente2", resultados, "MAEobtenerSubtipos");
	}

  private ComposerViewElementList crearParametrosModificarSTCZona(DTOOID dtoOidZona)  {
    ComposerViewElementList lista = new ComposerViewElementList();
    //combo SubtipoClienteGerenteZona
		ComposerViewElement ci1 = new ComposerViewElement();
		ci1.setIDBusiness("MAEobtenerSubtipos");
		ci1.setDTOE(dtoOidZona);
		lista.addViewElement(ci1);
		return lista;
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



}



/*******************************************************************************************************
Accion = "" 

-> Construir objeto "DTOOID" asignando al atributo oid el oid del pais activo tomándolo de la sesión. 
-> Construir idBusiness = "MAVCargarParametrizacion" 
-> Asignar conector "ConectorCargaParametrizacion" 
-> Recuperar el dto de salida "DTOCargaParametrizacion" 

-> Construir un objeto "DTOBelcorp" 
Si el atributo "DTOCargaParametrizacion.parametrizacionMAV" es igual a NULL entonces 
-> Llamar al subsistema GestorCargaPantalla con los siguientes datos: 
idBusiness "MAEObtenerTipos" y "DTOBelcorp" => llena combo TipoClienteZona 
idBusiness "MAEObtenerTipos" y "DTOBelcorp" => llena combo TipoClienteRegion
idBusiness "PREBuscarEstrategias" y "DTOBelcorp" => llena combo Estrategia
idBusiness "BELObtieneAlmacenPais" y "DTOBelcorp" => llena combo Almacen 
Si no entonces 
-> Construir objeto "DTOOID" asignando al atributo "oid" el "oidTipoCliente" recuperado en el RecordSet "DTOCargaParametrizacion.parametrizacionMAV" 
-> Llamar al subsistema GestorCargaPantalla con los siguientes campos: 
idBusiness "MAEObtenerTipos" y DTOBelcorp => llena combo TipoClienteZona 
idBusiness "MAEObtenerTipos" y DTOBelcorp => llena combo TipoClienteRegion
idBusiness "PREBuscarEstrategias" y "DTOBelcorp" => llena combo Estrategia
idBusiness "BELObtieneAlmacenPais" y "DTOBelcorp" => llena combo Almacen 
idBusiness "MAEobtenerSubtipos" y DTOOID => llena combo SubtipoClienteGerenteZona 
idBusiness "MAEobtenerSubtipos" y DTOOID => llena combo SubtipoClienteGerenteRegion 

-> Asignar a pantalla la información del objeto DTOCargaParametrizacion y dejar seleccionados los valores recuperados en los combos y multiselect correspondientes. 

Fin Si 

El RecordSet "DTOCargaParametrizacion.parametrizacionMAV" llena los campos de pantalla: 
- numRegistrosProductosGenerados 
- limitePrecio 
- autorizacionEnvio (RadioButton S/N) 
- estrategia 
- almacen 
- direccionElectronica 
- tipoClienteRegion (Seleccionar valor en combo cargado) 
- tipoClienteZona (Seleccionar valor en combo cargado) 

El RecordSet "DTOCargaParametrizacion.parametrizacionGRegion" llena los campos de pantalla: 
- subtipoClienteGerenteRegion (Seleccionar los valores en el multiselect cargado) 

El RecordSet "DTOCargaParametrizacion.parametrizacionGZona" llena los campos de pantalla: 
- subtipoClienteGerenteZona (Seleccionar los valores en el multiselect cargado) 

Acción "guardar" 

-> Crear idBusiness = "MAVGuardarParametrizacion" 
-> Crear objeto "DTOParametrizacionMAV" tomando los datos de la página 
-> Asignar conector "ConectorGuardarParametrizacion"
*******************************************************************************************************/
