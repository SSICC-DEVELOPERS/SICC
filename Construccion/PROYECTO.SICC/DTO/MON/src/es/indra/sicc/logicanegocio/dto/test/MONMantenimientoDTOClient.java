package es.indra.sicc.logicanegocio.dto.test;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import es.indra.sicc.logicanegocio.dto.MONMantenimientoDTO;
import es.indra.sicc.logicanegocio.dto.MONMantenimientoDTOHome;
import javax.naming.NamingException;
import java.util.Hashtable;

import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.dto.DTOGlobalDescuento;
import es.indra.sicc.dtos.dto.DTOCodigoClienteDto;
import es.indra.sicc.dtos.dto.DTOListaDescuentoCliente;
import es.indra.sicc.dtos.dto.DTOSBaseAplicacion;

import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.dtos.dto.DTODescuentoCliente;
import es.indra.sicc.util.DTOOIDs;

import java.util.Vector;
import java.util.ArrayList;
import java.math.BigDecimal;

import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.dtos.dto.DTODescuentoDG;
import es.indra.sicc.dtos.dto.DTOEAlcanceTipoCliente;
import es.indra.sicc.dtos.dto.DTOEAlcanceClasificacionDTO;
import es.indra.sicc.dtos.dto.DTOAlcanceAdministrativoDetalleDto;
import es.indra.sicc.dtos.dto.DTOEBaseCalculoDetalle;
import es.indra.sicc.dtos.dto.DTOSBaseAplicacionDetalle;
import es.indra.sicc.dtos.dto.DTOEscalon;
import es.indra.sicc.dtos.dto.DTOAlcanceAdministrativoDto;
import es.indra.sicc.dtos.dto.DTOSBaseCalculo;
import es.indra.sicc.dtos.dto.DTOListaBasesAplicacionDto;

public class MONMantenimientoDTOClient 
{

    public static void main(String [] args)
    {
        try
        {
            /*Para ejecutar las pruebas ir comentando y descomentando los métodos
             * abajo descriptos para ejecutar el que se desea.
             * */
             
             // /* PRUEBA 1 
            //obtenerDatosDescuentos();
            //*/ fin PRUEBA 1 
            // /* PRUEBA 2
            //guardarDescuentoDG();
            //*/ fin PRUEBA 2
            
            ///*PRUEBA 
            //consultarBaseAplicacionDTO();
            //*/ fin PRUEBA 
            
            ///*PRUEBA 3
            //obtenerAlcanceClienteDetalle();
            //*/ fin PRUEBA 3
            
            ///*PRUEBA 4
            guardarDatosDescuento();
            //*/ fin PRUEBA 5
            
            ///*PRUEBA 6
            //guardarListaAlcanceCliente();
            //*/ fin PRUEBA 6
             
            //*/ PRUEBA 7
            //consultarBasesAplicacionDTO();
            //*/ fin PRUEBA 7
            
        }
        catch(Exception ex)
        {
            System.out.println("salio por error");
            ex.printStackTrace();
        }

    }

    private static void obtenerDatosDescuentos() throws Exception{
            Context context = getInitialContext();
            MONMantenimientoDTOHome mONMantenimientoDTOHome = (MONMantenimientoDTOHome)PortableRemoteObject.narrow(context.lookup("MONMantenimientoDTO"), MONMantenimientoDTOHome.class);
            MONMantenimientoDTO mONMantenimientoDTO;

            mONMantenimientoDTO = mONMantenimientoDTOHome.create();

            DTOOID dto = new DTOOID();
            
            //seteos
            dto.setOid(new Long(1621));
            dto.setOidIdioma(new Long(1));
            dto.setOidPais(new Long(1));
            //

            DTOGlobalDescuento dtoDescuento = mONMantenimientoDTO.obtenerDatosDescuentos(dto);
            
            UtilidadesLog.debug("resultado de: obtenerDatosDescuentos.....: " + dtoDescuento);
    }

    private static void guardarDescuentoDG() throws Exception{
            Context context = getInitialContext();
            MONMantenimientoDTOHome mONMantenimientoDTOHome = (MONMantenimientoDTOHome)PortableRemoteObject.narrow(context.lookup("MONMantenimientoDTO"), MONMantenimientoDTOHome.class);
            MONMantenimientoDTO mONMantenimientoDTO;

            mONMantenimientoDTO = mONMantenimientoDTOHome.create();

            DTOGlobalDescuento dto = new DTOGlobalDescuento();
            DTODescuentoDG dtoDDG = new DTODescuentoDG();
            //seteos
            
            
            //accesos
            DTOOIDs accesos = new DTOOIDs();
            Long[] oids = new Long[1];
            oids[0] = new Long(1);
            accesos.setOids(oids);
            
            //subaccesos
            DTOOIDs subaccesos = new DTOOIDs();
            Long[] oids1 = new Long[1];
            oids1[0] = new Long(1);
            subaccesos.setOids(oids1);
            
            DTOI18nSICC attTradu = new  DTOI18nSICC();
            attTradu.setOidAtriuto(new Long(1));
            attTradu.setValorI18n(new String("titodesc8"));
            attTradu.setOidIdioma(new Long(1));
            attTradu.setOidPais(new Long(1));
            
            
            Vector attTradu1 = new Vector();
            attTradu1.add(attTradu);
            
            dtoDDG.setAccesos(accesos);
            dtoDDG.setSubaccesos(subaccesos);
            dtoDDG.setActivo(new Boolean(false));
            dtoDDG.setAfectaACuentasCorrientes(new Boolean(false));
            dtoDDG.setAfectaAFacturas(new Boolean(true));
            dtoDDG.setAprobado(new Boolean(false));
            dtoDDG.setAttTraducible(attTradu1);
            dtoDDG.setComunicacionAParticipantes(new Boolean(false));
            dtoDDG.setControlAnulaciones(new Boolean(false));
            dtoDDG.setControlDevoluciones(new Boolean(false));
            dtoDDG.setCulminacion(new Boolean(false));
            dtoDDG.setDescripcion(new String("descripcion....."));
            dtoDDG.setDescuentoAcumulativo(new Boolean(false));
            dtoDDG.setMorosidad(new Boolean(false));
            dtoDDG.setNacional(new Boolean(true));
            dtoDDG.setNumeroDescuento(new Long(310));
            dtoDDG.setOidCabeceraDTO(new Long(1015));
            dtoDDG.setOidCanal(new Long(1));
            //dto.getDatosGralesDto().setOidDescuento(new Long(1621));
            dtoDDG.setOidMarca(new Long(1));
            dtoDDG.setOidPais(new Long(1));
            dtoDDG.setOidPeriodoDesde(new Long(73));
            dtoDDG.setOidPeriodoHasta(new Long(1395));
            dtoDDG.setVigencia(new Character('V'));
            
            dto.setDatosGralesDto(dtoDDG);
            
            //

            DTOOID dtoREsu = mONMantenimientoDTO.guardarDescuentoDG(dto);
            
            UtilidadesLog.debug("resultado de: guardarDescuentoDG.....: " + dtoREsu);
    }

    private static void consultarBaseAplicacionDTO() throws Exception{
            Context context = getInitialContext();
            MONMantenimientoDTOHome mONMantenimientoDTOHome = (MONMantenimientoDTOHome)PortableRemoteObject.narrow(context.lookup("MONMantenimientoDTO"), MONMantenimientoDTOHome.class);
            MONMantenimientoDTO mONMantenimientoDTO;

            mONMantenimientoDTO = mONMantenimientoDTOHome.create();

            DTOOID dto = new DTOOID();
            
            //seteos
            dto.setOid(new Long(1140));
            dto.setOidIdioma(new Long(1));
            dto.setOidPais(new Long(1));
            //
            DTOSBaseAplicacion dtoBA = mONMantenimientoDTO.consultarBaseAplicacionDTO(dto);
            UtilidadesLog.debug("resultado de: consultarBaseAplicacionDTO.....: " + dtoBA);
    }
    
    private static void obtenerAlcanceClienteDetalle() throws Exception{
            Context context = getInitialContext();
            MONMantenimientoDTOHome mONMantenimientoDTOHome = (MONMantenimientoDTOHome)PortableRemoteObject.narrow(context.lookup("MONMantenimientoDTO"), MONMantenimientoDTOHome.class);
            MONMantenimientoDTO mONMantenimientoDTO;

            mONMantenimientoDTO = mONMantenimientoDTOHome.create();

            DTOCodigoClienteDto dto = new DTOCodigoClienteDto();
            
            dto.setOid(new Long(1));
            dto.setCodigo(new String("30000000020"));

            DTODescuentoCliente dtoResu = mONMantenimientoDTO.obtenerAlcanceClienteDetalle(dto);
            UtilidadesLog.debug("resultado de: obtenerAlcanceClienteDetalle.....: " + dtoResu);
    }

    private static void guardarDatosDescuento() throws Exception{
            Context context = getInitialContext();
            MONMantenimientoDTOHome mONMantenimientoDTOHome = (MONMantenimientoDTOHome)PortableRemoteObject.narrow(context.lookup("MONMantenimientoDTO"), MONMantenimientoDTOHome.class);
            MONMantenimientoDTO mONMantenimientoDTO;

            mONMantenimientoDTO = mONMantenimientoDTOHome.create();

            DTOGlobalDescuento dto = new DTOGlobalDescuento();
            DTODescuentoDG dtoDDG = new DTODescuentoDG();
            //seteos
            
            
            //accesos
            DTOOIDs accesos = new DTOOIDs();
            Long[] oids = new Long[1];
            oids[0] = new Long(1);
            accesos.setOids(oids);
            
            //subaccesos
            DTOOIDs subaccesos = new DTOOIDs();
            Long[] oids1 = new Long[1];
            oids1[0] = new Long(1);
            subaccesos.setOids(oids1);
            
            DTOI18nSICC attTradu = new  DTOI18nSICC();
            attTradu.setOidAtriuto(new Long(1));
            attTradu.setValorI18n(new String("titodesc8"));
            attTradu.setOidIdioma(new Long(1));
            attTradu.setOidPais(new Long(1));
            
            
            Vector attTradu1 = new Vector();
            attTradu1.add(attTradu);
            
            dtoDDG.setAccesos(accesos);
            dtoDDG.setSubaccesos(subaccesos);
            dtoDDG.setActivo(new Boolean(false));
            dtoDDG.setAfectaACuentasCorrientes(new Boolean(false));
            dtoDDG.setAfectaAFacturas(new Boolean(true));
            dtoDDG.setAprobado(new Boolean(false));
            dtoDDG.setAttTraducible(attTradu1);
            dtoDDG.setComunicacionAParticipantes(new Boolean(false));
            dtoDDG.setControlAnulaciones(new Boolean(false));
            dtoDDG.setControlDevoluciones(new Boolean(false));
            dtoDDG.setCulminacion(new Boolean(false));
            dtoDDG.setDescripcion(new String("descripcion....."));
            dtoDDG.setDescuentoAcumulativo(new Boolean(false));
            dtoDDG.setMorosidad(new Boolean(false));
            dtoDDG.setNacional(new Boolean(true));
            dtoDDG.setNumeroDescuento(new Long(310));
            dtoDDG.setOidCabeceraDTO(new Long(1015));
            dtoDDG.setOidCanal(new Long(1));
            //dto.getDatosGralesDto().setOidDescuento(new Long(1621));
            dtoDDG.setOidMarca(new Long(1));
            dtoDDG.setOidPais(new Long(1));
            dtoDDG.setOidPeriodoDesde(new Long(73));
            dtoDDG.setOidPeriodoHasta(new Long(1396));
            dtoDDG.setVigencia(new Character('V'));
            
            dto.setDatosGralesDto(dtoDDG);
            
            //indicadores
            dto.setIndAlcanceTipoCliente(new Boolean(true));
            dto.setIndAlcanceCliente(new Boolean(true));
            dto.setIndAlcanceAdministrativo(new Boolean(true));
            dto.setIndBaseCalculo(new Boolean(true));
            dto.setIndBaseAplicacion(new Boolean(true));
            
            
            //alcance tipo cliente
            DTOEAlcanceTipoCliente dtoATC = new DTOEAlcanceTipoCliente();
            
            Long[] oids2 = new Long[2];
            oids2[0] = new Long(1043);
            oids2[1] = new Long(1042);
            
            DTOOIDs registro0 = new DTOOIDs();
            registro0.setOids(oids2);
            
            dtoATC.setTipoCliente(registro0);



            
            ArrayList lstDesc = new ArrayList();
            DTOEAlcanceClasificacionDTO dtoEACdto = new DTOEAlcanceClasificacionDTO();
            
            dtoEACdto.setOidClasificacion(new Long(1058));
            dtoEACdto.setPorcentajeAdicional(new Double(30.20));
            lstDesc.add(dtoEACdto);
            
            dtoATC.setListaDescuentos(lstDesc);
            dto.setAlcanceTipoCliente(dtoATC);
            
            
            //alcance cliente
            DTOListaDescuentoCliente dtoLDC = new DTOListaDescuentoCliente();
            
            DTODescuentoCliente[] dtoDC = new DTODescuentoCliente[1];
            
            DTODescuentoCliente registro = new DTODescuentoCliente();
            
            registro.setCodigoCliente(new String("00000000015"));
            registro.setImporteDescuento(new Double(40.30));
            dtoDC[0]=registro;
            
            dtoLDC.setAlcanceCliente(dtoDC);
            dtoLDC.setOidIdioma(new Long(1));
            dtoLDC.setOidPais(new Long(1));
            
            dto.setAlcanceCliente(dtoLDC);
            
            
            //Alcance Administrativo
            DTOAlcanceAdministrativoDetalleDto[] dtoAADdto = new DTOAlcanceAdministrativoDetalleDto[1];
            DTOAlcanceAdministrativoDetalleDto registro1 = new DTOAlcanceAdministrativoDetalleDto();
            
            DTOAlcanceAdministrativoDto dtoAAdto = new DTOAlcanceAdministrativoDto();
            
            registro1.setOidSubgerencia(new Long(1));
            registro1.setOidRegion(new Long(1));
            registro1.setOidZona(new Long(4));
            registro1.setPorcentajeAdicional(new Float(75.20));
            
            dtoAADdto[0] = registro1;
            dtoAAdto.setDetalle(dtoAADdto);
            
            dto.setAlcanceAdministrativo(dtoAAdto);
            
            
            //Base Calculo
            
            ArrayList detalle = new ArrayList();
            DTOEBaseCalculoDetalle registro2 = new DTOEBaseCalculoDetalle();
            
            registro2.setCicloVida(new Long(3));
            //registro2.setSupergenerico(new Long());
            registro2.setProducto(new Long(16));
            //registro2.setGenericos(new Long());
            //registro2.setMarca(new Long());
            registro2.setUnidadNegocio(new Long(1085));
            //registro2.setNegocio(new Long());
            registro2.setTipoOferta(new Long(1));
            registro2.setExclusionTipoOferta(new Boolean(true));
            
            detalle.add(registro2);
            //dto.getBaseCalculo().setDetalle(detalle);
            
            DTOSBaseCalculo dtoSBC = new DTOSBaseCalculo();
            dtoSBC.setDetalle(detalle);
            
            dto.setBaseCalculo(dtoSBC);
            
            
            //dto.getBaseCalculo().setIpCliente();
            //dto.getBaseCalculo().setOidBase();
            dto.getBaseCalculo().setOidIdioma(new Long(1));
            dto.getBaseCalculo().setOidPais(new Long(1));
            dto.getBaseCalculo().setPrograma(new String("Programa"));
            
            
            //Base Aplicacion
            
            
            DTOSBaseAplicacion[] dtoSBA = new DTOSBaseAplicacion[1];
            DTOSBaseAplicacion registro3 = new DTOSBaseAplicacion();
            
            ArrayList detalle1 = new  ArrayList();
            ArrayList escalones = new  ArrayList();
            
            //registro3.setIpCliente();
            registro3.setNumeroUnidadesObligatorias(new Integer(20));
            registro3.setOidBase(new Long(1136));
            registro3.setOidIdioma(new Long(1));
            registro3.setOidPais(new Long(1));
            
            
            
            DTOSBaseAplicacionDetalle registro4 = new DTOSBaseAplicacionDetalle();
            registro4.setCicloVida(new Long(3));
            registro4.setExclusionTipoOferta(new Boolean(false));
            registro4.setGenerico(new Long(3));
            //registro4.setIpCliente();
            //registro4.setMarca();
            //registro4.setNegocio();
            registro4.setOidIdioma(new Long(1));
            registro4.setOidPais(new Long(1));
            registro4.setProducto(new Long(15));
            registro4.setSupergenerico(new Long(3));
            registro4.setTipoOferta(new Long(1));
            //registro4.setUnidadNegocio();
            detalle1.add(registro4);
            registro3.setDetalle(detalle1);


            DTOEscalon registro5 = new DTOEscalon();
            
            registro5.setEscalaDesde(new BigDecimal(new String("5")));
            registro5.setEscalaHasta(new BigDecimal(new String("40")));
            registro5.setOidEscalon(new Long(1092));
            registro5.setPorcentajeDescuento(new Double(10));

            escalones.add(registro5);
            registro3.setEscalones(escalones);
            
            dtoSBA[0] = registro3;
            
            
            DTOListaBasesAplicacionDto dtoLBAdto = new DTOListaBasesAplicacionDto();
            dtoLBAdto.setBasesAplicacion(dtoSBA);
            
            dto.setBasesAplicacion(dtoLBAdto);
            //dto.getBasesAplicacion().setBasesAplicacion(dtoSBA);
            
            //
            mONMantenimientoDTO.guardarDatosDescuento(dto);
    }

    private static void guardarListaAlcanceCliente() throws Exception{
            Context context = getInitialContext();
            MONMantenimientoDTOHome mONMantenimientoDTOHome = (MONMantenimientoDTOHome)PortableRemoteObject.narrow(context.lookup("MONMantenimientoDTO"), MONMantenimientoDTOHome.class);
            MONMantenimientoDTO mONMantenimientoDTO;

            mONMantenimientoDTO = mONMantenimientoDTOHome.create();
            
            //seteos
            DTOListaDescuentoCliente dto = new DTOListaDescuentoCliente();
            DTODescuentoCliente[] listaAlcClte = new DTODescuentoCliente[2];
            
            DTODescuentoCliente dtoDC = new DTODescuentoCliente();
            dtoDC.setCodigoCliente(new String("00000000003"));
            dtoDC.setImporteDescuento(new Double(100));
            listaAlcClte[0] = dtoDC;
            DTODescuentoCliente dtoDC1 = new DTODescuentoCliente();
            dtoDC1.setCodigoCliente(new String("00000000011"));
            dtoDC1.setPorcentajeDescuento(new Float(10.20));
            listaAlcClte[1] = dtoDC1;
            
            dto.setAlcanceCliente(listaAlcClte);
            dto.setOidDescuento(new Long(1618));
            
            dto.setOidPais(new Long(1));
            dto.setOidIdioma(new Long(1));

            mONMantenimientoDTO.guardarListaAlcanceCliente(dto);
    }

    private static void consultarBasesAplicacionDTO() throws Exception{
            Context context = getInitialContext();
            MONMantenimientoDTOHome mONMantenimientoDTOHome = (MONMantenimientoDTOHome)PortableRemoteObject.narrow(context.lookup("MONMantenimientoDTO"), MONMantenimientoDTOHome.class);
            MONMantenimientoDTO mONMantenimientoDTO;

            mONMantenimientoDTO = mONMantenimientoDTOHome.create();

            DTOOID dto = new DTOOID();
            dto.setOid(new Long(1621));

            DTOOIDs resu = mONMantenimientoDTO.consultarBasesAplicacionDTO(dto);
            UtilidadesLog.debug("resultado de: consultarBasesAplicacionDTO.....: " + resu);
    }
    
    private static Context getInitialContext() throws NamingException
    {
        Hashtable env = new Hashtable();
        // Standalone OC4J connection details
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.evermind.server.rmi.RMIInitialContextFactory");
        env.put(Context.SECURITY_PRINCIPAL, "PRUEBAS");
        env.put(Context.SECURITY_CREDENTIALS, "belcorp");
        env.put(Context.PROVIDER_URL, "ormi://cdos0075:23791/mare");

        return new InitialContext(env);
    }
    
}