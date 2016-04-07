package es.indra.sicc.logicanegocio.fac.generaciondocumentos;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.fac.DTOFACPosicionSolicitud;
import es.indra.sicc.util.UtilidadesLog;

import java.util.ArrayList;
import java.util.Iterator;

public class SolicitudPostVenta  extends DocumentoFAC {
    private byte[] documento; 
    public SolicitudPostVenta() {
    }
    
      public void componerFactura(DTODocLegal datosDocLegal) throws MareException {
        try {
          UtilidadesLog.info("SolicitudPostVenta.componerFactura(DTODocLegal datosDocLegal): Entrada");
          ArrayList listaPaginas = datosDocLegal.getlistaPaginas();
          SerializadorFacturaColombia2 sf2 = new SerializadorFacturaColombia2();          
          Parseador miParseador = Parseador.getInstance();
            
          DTOFACDocumentoContable docuContable = (DTOFACDocumentoContable)listaPaginas.get(0);
          DTOFACDocumentoContableCabecera miCabecera = docuContable.getCabecera();
          ArrayList misDetalles = miCabecera.getListaDetalle();

          DAODocuContable daoActivo = new DAODocuContable();
          String codigoVentaSPV = (String)daoActivo.obtenerCodigoVentaSPV(miCabecera.getOidPais());
          Iterator it = (Iterator)miCabecera.getListaSolicitudes().iterator();
          int numeroCopiasSPV = 0;
          
          Integer numeroReclamos = (Integer)daoActivo.obtenerReclamosAnteriores(miCabecera.getOidCliente(), miCabecera.getFechaFacturacion());          
          numeroCopiasSPV = numeroCopiasSPV + numeroReclamos.intValue();
          
          /*
          boolean solicitudReclamo = false;
          while (it.hasNext()) {
            DTOFACCabeceraSolicitud dtoCabeceraSolicitud = (DTOFACCabeceraSolicitud)it.next(); 
            if (dtoCabeceraSolicitud.getModulo().equals(new Long(ConstantesSEG.MODULO_REC))) {
               solicitudReclamo = true; 
               break;
            }
          }
          
          if (solicitudReclamo) {
            numeroCopiasSPV++;
          }
          */
          
          int arraySize = misDetalles.size();
          for (int i = 0; i < arraySize; i++) {
              DTOFACPosicionSolicitud dtoDetalle = (DTOFACPosicionSolicitud)misDetalles.get(i);
              if (dtoDetalle.getCodigoVenta().equals(codigoVentaSPV)) {
                numeroCopiasSPV = numeroCopiasSPV + dtoDetalle.getUnidadesAtendidas().intValue();
              }                
          }
          
          if (numeroCopiasSPV > 0) {
            String mensa = "<frmspv copies=" + '\u0022' + numeroCopiasSPV + '\u0022' + "> </frmspv> ";            
            sf2.addMensaje(mensa);
            
            sf2.componerDocumento();
            
            try {
              sf2.saveDocument("c:\\", "SolicitudPostVenta.txt");
              this.documento = sf2.bufferOut;

            } catch (Exception e) {
              e.printStackTrace();
            }
         } else {
            this.documento = new byte[0];
         } 
          
          UtilidadesLog.debug("SolicitudPostVenta: " + sf2.toString());
          UtilidadesLog.info("SolicitudPostVenta.componerFactura(DTODocLegal datosDocLegal): Salida");
           
          } catch (Exception e) {
              UtilidadesLog.error("ERROR en SolicitudPostVenta",e);
              if (e instanceof MareException){
                  throw (MareException)e;
              }
              throw new MareException(e);
          }
    }

    public byte[] getDocument() {
      return this.documento;
    }
}