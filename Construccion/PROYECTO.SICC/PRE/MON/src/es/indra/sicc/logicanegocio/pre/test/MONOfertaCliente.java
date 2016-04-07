package es.indra.sicc.logicanegocio.pre.test;
import es.indra.sicc.dtos.pre.DTODetalleOferta;
import es.indra.sicc.dtos.pre.DTOGrupo;
import es.indra.sicc.dtos.pre.DTOLineaPromocion;
import es.indra.sicc.dtos.pre.DTOOferta;
import es.indra.sicc.dtos.pre.DTOPromocion;
import es.indra.sicc.dtos.pre.DTOVentaExclusiva;
import es.indra.sicc.logicanegocio.pre.MONOferta;
import es.indra.sicc.logicanegocio.pre.MONOfertaHome;

import java.util.Hashtable;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;

public class MONOfertaCliente 
{
    public static void main(String [] args)
    {
        try
        {
            /*Para ejecutar las pruebas ir comentando y descomentando los métodos
             * abajo descriptos para ejecutar el que se desea.
             * */
             // /* PRUEBA 1 
            insertarDatosOferta();
            //*/ fin PRUEBA 1 
            // /* PRUEBA 2
            //insertarDatosOferta1();
            //*/ fin PRUEBA 2
            
            ///*PRUEBA 
            //modificarDatosOferta();
            //*/ fin PRUEBA 
            
            ///*PRUEBA 3
            //modificarDatosOferta2()
            //*/ fin PRUEBA 3
            
            ///*PRUEBA 4
            //modificarDatosOferta3() 
            //*/ fin PRUEBA 5
            
            ///*PRUEBA 6
            //modificarDatosOferta4() 
            //*/ fin PRUEBA 6
            
            //*/ PRUEBA 7
            //modificarDatosOferta5()
            //*/ fin PRUEBA 7
            
            //*/ PRUEBA 8
            //modificarDatosOfertaMultiple();
            //*/ fin PRUEBA 8
            
            
        }
        catch(Exception ex)
        {
            System.out.println("salio por error");
            ex.printStackTrace();
        }

    }

    private static Context getInitialContext() throws NamingException
    {
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.evermind.server.rmi.RMIInitialContextFactory");
        env.put(Context.SECURITY_PRINCIPAL, "PRUEBAS");
        env.put(Context.SECURITY_CREDENTIALS, "belcorp");
        env.put(Context.PROVIDER_URL, "ormi://cdos0075:23791/mare");

        return new InitialContext(env);
    }
    
    private static void insertarDatosOferta () throws Exception{
            Context context = getInitialContext();
            MONOfertaHome mONOfertaHome = (MONOfertaHome)PortableRemoteObject.narrow(context.lookup("MONOferta"), MONOfertaHome.class);
            MONOferta mONOferta;

            mONOferta = mONOfertaHome.create();

            DTOOferta dto = new DTOOferta();
            dto.setOidEstrategia(new Long (2));
            dto.setOidArgumentoVenta(new Long (1));
            dto.setOidCabeceraMF(new Long (1042));
            dto.setOidCatalogo(new Long (57));
            dto.setModificacionGrupo(Boolean.FALSE);
            //DetalleOferta
            Vector vDetaOfer = new Vector();
            DTODetalleOferta dtoDeta = new DTODetalleOferta();
            dtoDeta.setNumeroGrupo(new Integer(1));
            dtoDeta.setTipoOperacion("alta");
            dtoDeta.setProductoPrincipal(Boolean.FALSE);
            dtoDeta.setLineaOferta(new Integer(1));
            dtoDeta.setFactorRepeticion(new Integer (1));
            dtoDeta.setOidTipoOferta(new Long (1));
            dtoDeta.setOidCicloVida(new Long (1));
            dtoDeta.setDescripcion("una descripcion");
            dtoDeta.setUnidadesEstimadas(new Integer (2));
            dtoDeta.setOidSAP(new Long (224));
            dtoDeta.setCodigoVentaGenerado(Boolean.FALSE);
            vDetaOfer.add(dtoDeta);
            
            dto.setDetalleOferta(vDetaOfer);
            // fin DetalleOferta
            dto.setModificacionVentaExclusiva(Boolean.FALSE);
            // VentaExclusiva
            Vector vVentaEx = null;
            dto.setVentaExvlusiva(vVentaEx);
            // fin VentaExclusiva
            // Promocion
            Vector promocion = null;
            // Linea de promocion
            dto.setPromocion(promocion);
            // fin Promocion
            mONOferta.guardarOferta(dto);
    }
    
    private static void insertarDatosOferta1 () throws Exception{
            Context context = getInitialContext();
            MONOfertaHome mONOfertaHome = (MONOfertaHome)PortableRemoteObject.narrow(context.lookup("MONOferta"), MONOfertaHome.class);
            MONOferta mONOferta;

            // Use one of the create() methods below to create a new instance
            mONOferta = mONOfertaHome.create();

            // Call any of the Remote methods below to access the EJB
            DTOOferta dto = new DTOOferta();
            dto.setOidEstrategia(new Long (2));
            dto.setOidArgumentoVenta(new Long (1));
            dto.setOidCabeceraMF(new Long (1042));
            dto.setOidCatalogo(new Long (57));
            dto.setModificacionGrupo(Boolean.TRUE);
            //Grupo
            Vector vGrupos = new Vector();
            DTOGrupo dtoGrupo = new DTOGrupo();
            dtoGrupo.setFactorCuadre(new Integer(1));
            dtoGrupo.setIndicadorGrupo(Boolean.FALSE);
            dtoGrupo.setNumeroGrupo(new Integer(1));
            dtoGrupo.setCondicionado(Boolean.FALSE);
            dtoGrupo.setCondicionante(Boolean.FALSE);
            dtoGrupo.setTipoOperacion("alta");
            vGrupos.add(dtoGrupo);
            //Grupo
           
            dto.setGrupo(vGrupos); 
            //DetalleOferta
            Vector vDetaOfer = new Vector();
            DTODetalleOferta dtoDeta = new DTODetalleOferta();
            dtoDeta.setNumeroGrupo(new Integer(1)); // el mismo del grupo
            dtoDeta.setTipoOperacion("alta");
            dtoDeta.setProductoPrincipal(Boolean.FALSE);
            dtoDeta.setLineaOferta(new Integer(1));
            dtoDeta.setFactorRepeticion(new Integer (1));
            dtoDeta.setOidTipoOferta(new Long (1));
            dtoDeta.setOidCicloVida(new Long (1));
            dtoDeta.setDescripcion("una descripcion");
            dtoDeta.setUnidadesEstimadas(new Integer (2));
            dtoDeta.setOidSAP(new Long (224));
            dtoDeta.setCodigoVentaGenerado(Boolean.FALSE);
            
            
            vDetaOfer.add(dtoDeta);
            
            dto.setDetalleOferta(vDetaOfer);
            // fin DetalleOferta
            dto.setModificacionVentaExclusiva(Boolean.FALSE);
            // VentaExclusiva
            Vector vVentaEx = new Vector();
            DTOVentaExclusiva dtoVta = new DTOVentaExclusiva();
            dtoVta.setOidSubtipoCliente(new Long (1006));
            dtoVta.setOidEstatus(new Long (3));
            dtoVta.setOidClasificacion(new Long (1005));
            dtoVta.setOidTipoCliente(new Long (1005));
            dtoVta.setOidTipoClasificacion(new Long (1005));
            vVentaEx.add(dtoVta);
            
            dto.setVentaExvlusiva(vVentaEx);
            // fin VentaExclusiva
            // Promocion
            Vector promocion = new Vector();
            DTOPromocion dtoPromo = new DTOPromocion();
            
            dtoPromo.setNumeroCondicion(new Integer (1));
            dtoPromo.setFactorCuadre(new Integer (1));
            dtoPromo.setOidIndicadorCuadre(new Long (1));
            
            // Linea de promocion
            Vector lineaPromo = new Vector();            
            DTOLineaPromocion dtoLineaPromo = new DTOLineaPromocion();
            dtoLineaPromo.setOidCatalogo(new Long (57));
            char aux= 'A';
            dtoLineaPromo.setTipoRango(aux);
            dtoLineaPromo.setNumeroRangoInterno(new Integer(1));
            dtoLineaPromo.setValorDesde("7");
            dtoLineaPromo.setValorHasta("8");
            dtoLineaPromo.setIndicadorExclusion(Boolean.FALSE);
            dtoLineaPromo.setTipoOperacion("alta");
            lineaPromo.add(dtoLineaPromo);
            dtoPromo.setLineaPromocion(lineaPromo);
            //fin linea de promocion
            promocion.add(dtoPromo);
            dto.setPromocion(promocion);
            // fin Promocion
            
            mONOferta.guardarOferta(dto);
    }
    
    private static void modificarDatosOferta () throws Exception{
            Context context = getInitialContext();
            MONOfertaHome mONOfertaHome = (MONOfertaHome)
                                            PortableRemoteObject.narrow(context.lookup("MONOferta")
                                                                        , MONOfertaHome.class);
            MONOferta mONOferta;

            // Use one of the create() methods below to create a new instance
            mONOferta = mONOfertaHome.create();

            // Call any of the Remote methods below to access the EJB
            DTOOferta dto = new DTOOferta();
            dto.setOidOferta(new Long (1972)); // para modificacion
            dto.setNumeroOferta(new Integer (1)); // para modificacion
            dto.setOidEstrategia(new Long (3));
            dto.setOidArgumentoVenta(new Long (2));
            dto.setOidCabeceraMF(new Long (1042));
            dto.setNumeroOrden(new Integer (1));
            //dto.setOidCatalogo();
            dto.setModificacionGrupo(Boolean.FALSE);
            dto.setModificacionVentaExclusiva(Boolean.FALSE);
            dto.setModificacionRangoPromocion(Boolean.FALSE);
            dto.setModificacionPromocion(Boolean.FALSE);

            mONOferta.modificarOferta(dto);
    }
    
    private static void modificarDatosOferta2 () throws Exception{
            // MODIFICA GRUPOS
            Context context = getInitialContext();
            MONOfertaHome mONOfertaHome = (MONOfertaHome)
                                        PortableRemoteObject.narrow(context.lookup("MONOferta")
                                                                    , MONOfertaHome.class);
            MONOferta mONOferta;

            mONOferta = mONOfertaHome.create();

            DTOOferta dto = new DTOOferta();
            dto.setOidOferta(new Long (1972)); // para modificacion
            dto.setNumeroOferta(new Integer (1)); // para modificacion
            dto.setOidEstrategia(new Long (3));
            dto.setOidArgumentoVenta(new Long (2));
            dto.setOidCabeceraMF(new Long (1042));
            dto.setNumeroOrden(new Integer (1));
            //dto.setOidCatalogo();
            dto.setModificacionGrupo(Boolean.TRUE);
            dto.setModificacionVentaExclusiva(Boolean.FALSE);
            dto.setModificacionRangoPromocion(Boolean.FALSE);
            dto.setModificacionPromocion(Boolean.FALSE);
            Vector vDetaOfer = new Vector();
            dto.setDetalleOferta(vDetaOfer);
            //Grupo
            Vector vGrupos = new Vector();
            DTOGrupo dtoGrupo = new DTOGrupo();
            dtoGrupo.setOidGrupo(new Long (1193));
            dtoGrupo.setFactorCuadre(new Integer(1));
            dtoGrupo.setIndicadorGrupo(Boolean.TRUE);
            dtoGrupo.setNumeroGrupo(new Integer(3));
            dtoGrupo.setCondicionado(Boolean.TRUE);
            dtoGrupo.setCondicionante(Boolean.TRUE);
            dtoGrupo.setTipoOperacion("modificacion");
            vGrupos.add(dtoGrupo);
            dto.setGrupo(vGrupos);
            //Grupo

            mONOferta.modificarOferta(dto);
    }
    
    private static void modificarDatosOferta3 () throws Exception{
            // MODIFICA DETALLE OFERTA
            Context context = getInitialContext();
            MONOfertaHome mONOfertaHome = (MONOfertaHome)
                                            PortableRemoteObject.narrow(context.lookup("MONOferta")
                                                                        , MONOfertaHome.class);
            MONOferta mONOferta;

            mONOferta = mONOfertaHome.create();

            DTOOferta dto = new DTOOferta();
            dto.setOidOferta(new Long (1972)); // para modificacion
            dto.setNumeroOferta(new Integer (1)); // para modificacion
            dto.setOidEstrategia(new Long (3));
            dto.setOidArgumentoVenta(new Long (2));
            dto.setOidCabeceraMF(new Long (1042));
            dto.setNumeroOrden(new Integer (1));
            //dto.setOidCatalogo();
            dto.setModificacionGrupo(Boolean.FALSE);
            dto.setModificacionVentaExclusiva(Boolean.FALSE);
            dto.setModificacionRangoPromocion(Boolean.FALSE);
            dto.setModificacionPromocion(Boolean.FALSE);
            //Grupo
            Vector vGrupos = new Vector();
            dto.setGrupo(vGrupos);
            //Grupo
           
            //DetalleOferta
            Vector vDetaOfer = new Vector();
            DTODetalleOferta dtoDeta = new DTODetalleOferta();
            dtoDeta.setOidDetalleOferta(new Long (2321));
            dtoDeta.setNumeroGrupo(new Integer(2)); // el mismo del grupo
            dtoDeta.setTipoOperacion("modificacion");
            dtoDeta.setProductoPrincipal(Boolean.FALSE);
            dtoDeta.setLineaOferta(new Integer(3));
            dtoDeta.setFactorRepeticion(new Integer (10));
            dtoDeta.setOidTipoOferta(new Long (1));
            dtoDeta.setOidCicloVida(new Long (1));
            dtoDeta.setDescripcion("nueva descripcion");
            dtoDeta.setUnidadesEstimadas(new Integer (3));
            dtoDeta.setOidSAP(new Long (229));
            dtoDeta.setCodigoVentaGenerado(Boolean.FALSE);
            vDetaOfer.add(dtoDeta);
            
            dto.setDetalleOferta(vDetaOfer);
            // fin DetalleOferta
           
            mONOferta.modificarOferta(dto);
    }
    
    private static void modificarDatosOferta4 () throws Exception{
            // MODIFICA PROMOCIONES
            Context context = getInitialContext();
            MONOfertaHome mONOfertaHome = (MONOfertaHome)
                                            PortableRemoteObject.narrow(context.lookup("MONOferta")
                                                                        , MONOfertaHome.class);
            MONOferta mONOferta;

            // Use one of the create() methods below to create a new instance
            mONOferta = mONOfertaHome.create();

            // Call any of the Remote methods below to access the EJB
            DTOOferta dto = new DTOOferta();
            dto.setOidOferta(new Long (1972)); // para modificacion
            dto.setNumeroOferta(new Integer (1)); // para modificacion
            dto.setOidEstrategia(new Long (3));
            dto.setOidArgumentoVenta(new Long (2));
            dto.setOidCabeceraMF(new Long (1042));
            dto.setNumeroOrden(new Integer (1));
            //dto.setOidCatalogo();
            dto.setModificacionGrupo(Boolean.FALSE);
            dto.setModificacionVentaExclusiva(Boolean.FALSE);
            dto.setModificacionRangoPromocion(Boolean.TRUE);
            dto.setModificacionPromocion(Boolean.TRUE);
            Vector vGrupos = new Vector();
            dto.setGrupo(vGrupos);
            Vector vDetaOfer = new Vector();            
            dto.setDetalleOferta(vDetaOfer);
            
            Vector promocion = new Vector();
            DTOPromocion dtoPromo = new DTOPromocion();
            dtoPromo.setOidPromocion(new Long (1090));
            dtoPromo.setNumeroCondicion(new Integer (1));
            dtoPromo.setFactorCuadre(new Integer (1));
            dtoPromo.setOidIndicadorCuadre(new Long (1));
            
            // Linea de promocion
            Vector lineaPromo = new Vector();            
            DTOLineaPromocion dtoLineaPromo = new DTOLineaPromocion();
            dtoLineaPromo.setOidLineaPromocion(new Long (1180));
            dtoLineaPromo.setOidCatalogo(new Long (57));
            char aux= 'B';
            dtoLineaPromo.setTipoRango(aux);
            dtoLineaPromo.setNumeroRangoInterno(new Integer(2));
            dtoLineaPromo.setValorDesde("1");
            dtoLineaPromo.setValorHasta("29");
            dtoLineaPromo.setIndicadorExclusion(Boolean.TRUE);
            dtoLineaPromo.setTipoOperacion("baja");
            lineaPromo.add(dtoLineaPromo);
            dtoPromo.setLineaPromocion(lineaPromo);
            //fin linea de promocion
            promocion.add(dtoPromo);
            dto.setPromocion(promocion);
            // fin Promocion

           
            mONOferta.modificarOferta(dto);
    }
    
    private static void modificarDatosOferta5 () throws Exception{
            // MODIFICA DETALLE OFERTA
            Context context = getInitialContext();
            MONOfertaHome mONOfertaHome = (MONOfertaHome)PortableRemoteObject.narrow(context.lookup("MONOferta"), MONOfertaHome.class);
            MONOferta mONOferta;

            // Use one of the create() methods below to create a new instance
            mONOferta = mONOfertaHome.create();

            // Call any of the Remote methods below to access the EJB
            DTOOferta dto = new DTOOferta();
            dto.setOidOferta(new Long (1972)); // para modificacion
            dto.setNumeroOferta(new Integer (1)); // para modificacion
            dto.setOidEstrategia(new Long (3));
            dto.setOidArgumentoVenta(new Long (2));
            dto.setOidCabeceraMF(new Long (1042));
            dto.setNumeroOrden(new Integer (1));
            //dto.setOidCatalogo();
            dto.setModificacionGrupo(Boolean.FALSE);
            dto.setModificacionVentaExclusiva(Boolean.TRUE);
            dto.setModificacionRangoPromocion(Boolean.FALSE);
            dto.setModificacionPromocion(Boolean.FALSE);
            Vector vGrupos = new Vector();
            dto.setGrupo(vGrupos);
            Vector vDetaOfer = new Vector();            
            dto.setDetalleOferta(vDetaOfer);
            Vector promocion = new Vector();
            dto.setPromocion(promocion);
            
            Vector vVentaEx = new Vector();
            DTOVentaExclusiva dtoVta = new DTOVentaExclusiva();
            dtoVta.setOidVentaExclusiva(new Long (1037));
            dtoVta.setOidSubtipoCliente(new Long (1));
            dtoVta.setOidEstatus(new Long (1));
            dtoVta.setOidClasificacion(new Long (1));
            dtoVta.setOidTipoCliente(new Long (2));
            dtoVta.setOidTipoClasificacion(new Long (1));
            vVentaEx.add(dtoVta);
            
            dto.setVentaExvlusiva(vVentaEx);

           
            mONOferta.modificarOferta(dto);
    }
    
    private static void insertarDatosOferta2 () throws Exception{
            Context context = getInitialContext();
            MONOfertaHome mONOfertaHome = (MONOfertaHome)PortableRemoteObject.narrow(context.lookup("MONOferta"), MONOfertaHome.class);
            MONOferta mONOferta;

            // Use one of the create() methods below to create a new instance
            mONOferta = mONOfertaHome.create();

            // Call any of the Remote methods below to access the EJB
            DTOOferta dto = new DTOOferta();
            dto.setOidEstrategia(new Long (2));
            dto.setOidArgumentoVenta(new Long (1));
            dto.setOidCabeceraMF(new Long (1042));
            dto.setOidCatalogo(new Long (57));
            dto.setModificacionGrupo(Boolean.TRUE);
            //Grupo
            Vector vGrupos = new Vector();
            DTOGrupo dtoGrupo = new DTOGrupo();
            dtoGrupo.setFactorCuadre(new Integer(1));
            dtoGrupo.setIndicadorGrupo(Boolean.FALSE);
            dtoGrupo.setNumeroGrupo(new Integer(1));
            dtoGrupo.setCondicionado(Boolean.FALSE);
            dtoGrupo.setCondicionante(Boolean.TRUE);
            dtoGrupo.setTipoOperacion("alta");
            vGrupos.add(dtoGrupo);
                //AGREGADO
                dtoGrupo = new DTOGrupo();
                dtoGrupo.setFactorCuadre(new Integer(2));
                dtoGrupo.setIndicadorGrupo(Boolean.TRUE);
                dtoGrupo.setNumeroGrupo(new Integer(2));
                dtoGrupo.setCondicionado(Boolean.TRUE);
                dtoGrupo.setCondicionante(Boolean.FALSE);
                dtoGrupo.setTipoOperacion("alta");
                vGrupos.add(dtoGrupo);
                //AGREGADO
                dto.setGrupo(vGrupos); 
            //Grupo
           
            
            
            
            //DetalleOferta
            Vector vDetaOfer = new Vector();
            DTODetalleOferta dtoDeta = new DTODetalleOferta();
            dtoDeta.setNumeroGrupo(new Integer(1)); // el mismo del grupo
            dtoDeta.setTipoOperacion("alta");
            dtoDeta.setProductoPrincipal(Boolean.FALSE);
            dtoDeta.setLineaOferta(new Integer(1));
            dtoDeta.setFactorRepeticion(new Integer (1));
            dtoDeta.setOidTipoOferta(new Long (1));
            dtoDeta.setOidCicloVida(new Long (1));
            dtoDeta.setDescripcion("una descripcion");
            dtoDeta.setUnidadesEstimadas(new Integer (2));
            dtoDeta.setOidSAP(new Long (224));
            dtoDeta.setCodigoVentaGenerado(Boolean.FALSE);
            vDetaOfer.add(dtoDeta);
            
                //AGREGADO
                dtoDeta = new DTODetalleOferta();
                dtoDeta.setNumeroGrupo(new Integer(1)); 
                dtoDeta.setTipoOperacion("alta");
                dtoDeta.setProductoPrincipal(Boolean.TRUE);
                dtoDeta.setLineaOferta(new Integer(2));
                dtoDeta.setFactorRepeticion(new Integer (15));
                dtoDeta.setOidTipoOferta(new Long (1));
                dtoDeta.setOidCicloVida(new Long (1));
                dtoDeta.setDescripcion("OTRA descripcion");
                dtoDeta.setUnidadesEstimadas(new Integer (2));
                dtoDeta.setOidSAP(new Long (229));
                dtoDeta.setCodigoVentaGenerado(Boolean.TRUE);
                dtoDeta.setCodigoVenta("CODIGO VENTA");
                vDetaOfer.add(dtoDeta);
                //AGREGADO
            
            
            dto.setDetalleOferta(vDetaOfer);
            // fin DetalleOferta
            dto.setModificacionVentaExclusiva(Boolean.FALSE);
            // VentaExclusiva
            Vector vVentaEx = new Vector();
            DTOVentaExclusiva dtoVta = new DTOVentaExclusiva();
            dtoVta.setOidSubtipoCliente(new Long (1006));
            dtoVta.setOidEstatus(new Long (3));
            dtoVta.setOidClasificacion(new Long (1005));
            dtoVta.setOidTipoCliente(new Long (1005));
            dtoVta.setOidTipoClasificacion(new Long (1005));
            vVentaEx.add(dtoVta);
            
                //AGREGADO
                dtoVta = new DTOVentaExclusiva();
                dtoVta.setOidSubtipoCliente(new Long (1));
                dtoVta.setOidEstatus(new Long (1));
                dtoVta.setOidClasificacion(new Long (1));
                dtoVta.setOidTipoCliente(new Long (2));
                dtoVta.setOidTipoClasificacion(new Long (1));
                
                vVentaEx.add(dtoVta);
                //AGREGADO
            dto.setVentaExvlusiva(vVentaEx);
            // fin VentaExclusiva
            // Promocion
            Vector promocion = new Vector();
            DTOPromocion dtoPromo = new DTOPromocion();
            
            dtoPromo.setNumeroCondicion(new Integer (1));
            dtoPromo.setFactorCuadre(new Integer (1));
            dtoPromo.setOidIndicadorCuadre(new Long (1));
            
            // Linea de promocion
            Vector lineaPromo = new Vector();            
            DTOLineaPromocion dtoLineaPromo = new DTOLineaPromocion();
            dtoLineaPromo.setOidCatalogo(new Long (57));
            char aux= 'A';
            dtoLineaPromo.setTipoRango(aux);
            dtoLineaPromo.setNumeroRangoInterno(new Integer(1));
            dtoLineaPromo.setValorDesde("7");
            dtoLineaPromo.setValorHasta("8");
            dtoLineaPromo.setIndicadorExclusion(Boolean.FALSE);
            dtoLineaPromo.setTipoOperacion("alta");
            lineaPromo.add(dtoLineaPromo);
            
            dtoLineaPromo = new DTOLineaPromocion();
            dtoLineaPromo.setOidCatalogo(new Long (57));
            aux= 'B';
            dtoLineaPromo.setTipoRango(aux);
            dtoLineaPromo.setNumeroRangoInterno(new Integer(2));
            dtoLineaPromo.setValorDesde("9");
            dtoLineaPromo.setValorHasta("10");
            dtoLineaPromo.setIndicadorExclusion(Boolean.FALSE);
            dtoLineaPromo.setTipoOperacion("alta");
            lineaPromo.add(dtoLineaPromo);
            
            dtoPromo.setLineaPromocion(lineaPromo);
            //fin linea de promocion
            promocion.add(dtoPromo);
            dto.setPromocion(promocion);
            // fin Promocion
            
            mONOferta.guardarOferta(dto);
    }
    
    
    
    private static void modificarDatosOfertaMultiple () throws Exception{
            // MODIFICA DETALLE OFERTA
            Context context = getInitialContext();
            MONOfertaHome mONOfertaHome = (MONOfertaHome)PortableRemoteObject.narrow(context.lookup("MONOferta"), MONOfertaHome.class);
            MONOferta mONOferta;

            mONOferta = mONOfertaHome.create();


            DTOOferta dto = new DTOOferta();
            dto.setOidOferta(new Long (1973));
            dto.setNumeroOferta(new Integer (1)); 
            dto.setOidEstrategia(new Long (3));
            dto.setOidArgumentoVenta(new Long (2));
            dto.setOidCabeceraMF(new Long (1042));
            dto.setNumeroOrden(new Integer (1));

            dto.setModificacionGrupo(Boolean.TRUE);
            dto.setModificacionVentaExclusiva(Boolean.TRUE);
            dto.setModificacionRangoPromocion(Boolean.TRUE);
            dto.setModificacionPromocion(Boolean.TRUE);
            
            
            //Grupo======================================================================
            Vector vGrupos = new Vector();
            DTOGrupo dtoGrupo = new DTOGrupo();
            dtoGrupo.setOidGrupo(new Long (1194));
            dtoGrupo.setFactorCuadre(new Integer(12));
            dtoGrupo.setIndicadorGrupo(Boolean.TRUE);
            dtoGrupo.setNumeroGrupo(new Integer(3));
            dtoGrupo.setCondicionado(Boolean.TRUE);
            dtoGrupo.setCondicionante(Boolean.FALSE);
            dtoGrupo.setTipoOperacion("modificacion");
            vGrupos.add(dtoGrupo);
                //AGREGADO
                dtoGrupo = new DTOGrupo();
                dtoGrupo.setOidGrupo(new Long (1195));
                dtoGrupo.setFactorCuadre(new Integer(22));
                dtoGrupo.setIndicadorGrupo(Boolean.FALSE);
                dtoGrupo.setNumeroGrupo(new Integer(4));
                dtoGrupo.setCondicionado(Boolean.FALSE);
                dtoGrupo.setCondicionante(Boolean.TRUE);
                dtoGrupo.setTipoOperacion("baja");
                vGrupos.add(dtoGrupo);
                //AGREGADO
                dto.setGrupo(vGrupos); 
            //Grupo======================================================================
           
           
           
            //DetalleOferta ======================================================================
            Vector vDetaOfer = new Vector();
            DTODetalleOferta dtoDeta = new DTODetalleOferta();
            dtoDeta.setOidDetalleOferta(new Long (2322));
            dtoDeta.setNumeroGrupo(new Integer(2));
            dtoDeta.setTipoOperacion("modificacion");
            dtoDeta.setProductoPrincipal(Boolean.TRUE);
            dtoDeta.setLineaOferta(new Integer(2));
            dtoDeta.setFactorRepeticion(new Integer (12));
            dtoDeta.setOidTipoOferta(new Long (1));
            dtoDeta.setOidCicloVida(new Long (1));
            dtoDeta.setDescripcion("una descripcion 2");
            dtoDeta.setUnidadesEstimadas(new Integer (22));
            dtoDeta.setOidSAP(new Long (230));
            dtoDeta.setCodigoVentaGenerado(Boolean.FALSE);
            vDetaOfer.add(dtoDeta);
            
                //AGREGADO
                dtoDeta = new DTODetalleOferta();
                dtoDeta.setOidDetalleOferta(new Long (2323));
                dtoDeta.setNumeroGrupo(new Integer(2)); 
                dtoDeta.setTipoOperacion("baja");
                dtoDeta.setProductoPrincipal(Boolean.FALSE);
                dtoDeta.setLineaOferta(new Integer(1));
                dtoDeta.setFactorRepeticion(new Integer (152));
                dtoDeta.setOidTipoOferta(new Long (1));
                dtoDeta.setOidCicloVida(new Long (1));
                dtoDeta.setDescripcion("OTRA descripcion 2");
                dtoDeta.setUnidadesEstimadas(new Integer (22));
                dtoDeta.setOidSAP(new Long (228));
                dtoDeta.setCodigoVentaGenerado(Boolean.FALSE);
                vDetaOfer.add(dtoDeta);
                //AGREGADO
            
            
            dto.setDetalleOferta(vDetaOfer);
            // fin DetalleOferta ======================================================================
           
           
            // VentaExclusiva ======================================================================
            Vector vVentaEx = new Vector();
            DTOVentaExclusiva dtoVta = new DTOVentaExclusiva();
            dtoVta.setOidVentaExclusiva(new Long (1040));
            dtoVta.setOidSubtipoCliente(new Long (1006));
            dtoVta.setOidEstatus(new Long (3));
            dtoVta.setOidClasificacion(new Long (1005));
            dtoVta.setOidTipoCliente(new Long (1005));
            dtoVta.setOidTipoClasificacion(new Long (1005));
            dtoVta.setTipoOperacion("modificacion");
            vVentaEx.add(dtoVta);
            
                //AGREGADO
                dtoVta = new DTOVentaExclusiva();
                dtoVta.setOidVentaExclusiva(new Long (1039));
                dtoVta.setTipoOperacion("baja");
                dtoVta.setOidSubtipoCliente(new Long (1));
                dtoVta.setOidEstatus(new Long (1));
                dtoVta.setOidClasificacion(new Long (1));
                dtoVta.setOidTipoCliente(new Long (2));
                dtoVta.setOidTipoClasificacion(new Long (1));
                
                vVentaEx.add(dtoVta);
                //AGREGADO
            dto.setVentaExvlusiva(vVentaEx);
            // fin VentaExclusiva ======================================================================
           
           
           // Promocion======================================================================
            Vector promocion = new Vector();
            DTOPromocion dtoPromo = new DTOPromocion();
            dtoPromo.setOidPromocion(new Long (1092));
            dtoPromo.setTipoOperacion("modificacion");
            dtoPromo.setNumeroCondicion(new Integer (1));
            dtoPromo.setFactorCuadre(new Integer (2));
            dtoPromo.setOidIndicadorCuadre(new Long (1));
            
            // Linea de promocion
            Vector lineaPromo = new Vector();            
            DTOLineaPromocion dtoLineaPromo = new DTOLineaPromocion();
            dtoLineaPromo.setOidCatalogo(new Long (57));
            dtoLineaPromo.setOidLineaPromocion(new Long (1182));
            char aux= 'A';
            dtoLineaPromo.setTipoRango(aux);
            dtoLineaPromo.setNumeroRangoInterno(new Integer(1));
            dtoLineaPromo.setValorDesde("7");
            dtoLineaPromo.setValorHasta("8");
            dtoLineaPromo.setIndicadorExclusion(Boolean.FALSE);
            dtoLineaPromo.setTipoOperacion("baja");
            lineaPromo.add(dtoLineaPromo);
            
            dtoLineaPromo = new DTOLineaPromocion();
            dtoLineaPromo.setOidLineaPromocion(new Long (1183));
            dtoLineaPromo.setOidCatalogo(new Long (57));
            aux= 'C';
            dtoLineaPromo.setTipoRango(aux);
            dtoLineaPromo.setNumeroRangoInterno(new Integer(2));
            dtoLineaPromo.setValorDesde("1");
            dtoLineaPromo.setValorHasta("20");
            dtoLineaPromo.setIndicadorExclusion(Boolean.FALSE);
            dtoLineaPromo.setTipoOperacion("baja");
            lineaPromo.add(dtoLineaPromo);
            
            dtoPromo.setLineaPromocion(lineaPromo);
            //fin linea de promocion
            promocion.add(dtoPromo);
            dto.setPromocion(promocion);
            // fin Promocion======================================================================
           
           
            mONOferta.modificarOferta(dto);
    }
    
    
}