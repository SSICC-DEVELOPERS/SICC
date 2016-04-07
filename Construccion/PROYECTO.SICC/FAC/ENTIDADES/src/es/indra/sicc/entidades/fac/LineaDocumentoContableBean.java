package es.indra.sicc.entidades.fac;

import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import es.indra.sicc.util.BelcorpService;
//import java.util.ArrayList;
import java.util.Vector;
//import java.sql.Date;
import java.math.BigDecimal;
//import es.indra.sicc.util.DTOSalida;
//import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
//import es.indra.mare.common.mii.services.MareServiceException;
//import es.indra.mare.common.mii.services.ejbservice.EJBLocator;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mii.services.logging.LoggingService;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;
import org.apache.commons.logging.Log;

import javax.ejb.CreateException;
import javax.ejb.DuplicateKeyException;
import javax.ejb.FinderException;
import javax.ejb.EJBException;
import es.indra.sicc.util.UtilidadesLog;



public class LineaDocumentoContableBean implements EntityBean  {
    private EntityContext context;

    public BigDecimal precioTotalTotalDocumento;
    public BigDecimal precioNetoTotalDocumento;
    public BigDecimal importeImpuestoTotalDocumento;
    public BigDecimal importeDescuentoSinImpuestoTotalDocumento;
    public BigDecimal importeDescuentoTotalDocumento;
    public BigDecimal precioFacturaTotalDocumento;
    public BigDecimal precioCatalogoTotalDocumento;
	  public BigDecimal precioContableTotalDocumento;
	  public BigDecimal precioTotalUnitarioDocumento;
    public BigDecimal importeImpuestoUnitarioDocumento;
    public BigDecimal precioNetoUnitarioDocumento;
    public BigDecimal importeDescuentoSinImpuestosUnitarioDocumento;
    public BigDecimal importeDescuentoUnitarioDocumento;
	  public BigDecimal porcentajeDescuento;
    public BigDecimal precioSinImpuestosUnitarioDocumento;
    public BigDecimal precioFacturaUnitarioDocumento;
    public BigDecimal precioContableUnitarioDocumento;
    public BigDecimal precioCatalogoUnitarioDocumento;
    public BigDecimal precioTotalTotalLocal;
    public BigDecimal importeImpuestoTotalLocal;
    public BigDecimal precioNetoTotalLocal;
    public BigDecimal importeDescuentoSinImpuestosTotalLocal;
    public BigDecimal importeDescuentoTotalLocal;
    public BigDecimal precioSinImpuestosTotalLocal;
    public BigDecimal precioFacturaTotalLocal;
    public BigDecimal precioCatalogoTotalLocalUnidadesDemandaReal;
    public BigDecimal precioCatalogoTotalLocal;
    public BigDecimal precioContableTotalLocal;
    public BigDecimal precioTotalUnitarioLocal;
    public BigDecimal importeImpuestoUnitarioLocal;
    public BigDecimal precioNetoUnitarioLocal;
    public BigDecimal importeDescuentoSinImpuestosUnitarioLocal;
    public BigDecimal importeDescuentoUnitarioLocal;
    public BigDecimal precioSinImpuestosUnitarioLocal;
    public BigDecimal precioFacturaUnitarioLocal;
    public BigDecimal precioContableUnitarioLocal;
	  public BigDecimal precioCatalogoUnitarioLocal;
    public String indicadorDentroFueraCajaBolsa;
    public Integer numeroLinea;
    public Integer unidadesAtendidas;
    public Boolean indicadorNoImprimible;
    public Float precioSinImpuestosTotalDocumento;
    public Integer catalogo;
    public Integer pagina;
    public Long oid;
    public Long cabecera;
    public Long producto;
    public Long moneda;
	public Long posicionSolicitud;

    public Long ejbCreate() {
        return null;
    }

    public void ejbPostCreate() {
    }


    public Long ejbCreate(Long cabecera, Integer unidadesAtendidas, 
    Long posicionSolicitud, Long producto,/* Long moneda,*/ Integer numeroLinea) 
    throws DuplicateKeyException, CreateException {
		UtilidadesLog.info("****Metodo LineaDocumentoCiontable ejbCreate: Entrada");
        Vector parametros = new Vector();
        this.setCabecera(cabecera);
        this.setUnidadesAtendidas(unidadesAtendidas);
        this.setPosicionSolicitud(posicionSolicitud);
        this.setProducto(producto);
       // this.setMoneda(moneda);
        this.setNumeroLinea(numeroLinea);

        try {
			// Asignar el nuevo oid
			this.setOid(new Long(SecuenciadorOID.obtenerSiguienteValor("FAC_DCLI_SEQ").longValue()));
		} catch (MareException me) {
			throw new CreateException();
		}

         StringBuffer query  = new StringBuffer("");
        query.append(" INSERT INTO FAC_DOCUM_CONTA_LINEA (" 
         +" OID, "+" DCCA_OID_CABE , "+
         " NUM_UNID_ATEN, "+" SOPO_OID_SOLI_POSI, "+" PROD_OID_PROD, "/* +" MONE_OID_MONE, " */+
         " NUM_LINEA ) VALUES( ? , ? , ? , ? , ? , ?  )");
         parametros.add(this.getOid());
         parametros.add(this.getCabecera());
         parametros.add(this.getUnidadesAtendidas());
         parametros.add(this.getPosicionSolicitud());
         parametros.add(this.getProducto());
         //parametros.add(this.getMoneda());
         parametros.add(this.getNumeroLinea());

         try {
			ejecuta(query.toString(), parametros);
         } catch (EJBException ejbe) {
			String falloSQL = (ejbe.getCausedByException()).getMessage();
			if (falloSQL.indexOf("ORA-00001") != -1)
				throw new DuplicateKeyException();
			else if (falloSQL.indexOf("ORA-02291") != -1)
				throw new CreateException();
			else
				throw ejbe;
		 }

        UtilidadesLog.info("****Metodo LineaDocumentoCiontable ejbCreate: salida");
        return this.getOid();
    }

    public void ejbPostCreate(Long cabecera, Integer unidadesAtendidas, Long posicionSolicitud, Long producto,/* Long moneda,*/ Integer numeroLinea) throws DuplicateKeyException {
    }
	
    public Long ejbCreate(BigDecimal precioTotalTotalDocumento, BigDecimal precioNetoTotalDocumento, BigDecimal importeImpuestoTotalDocumento, BigDecimal importeDescuentoSinImpuestoTotalDocumento, BigDecimal importeDescuentoTotalDocumento, BigDecimal precioFacturaTotalDocumento, BigDecimal precioCatalogoTotalDocumento, BigDecimal precioTotalUnitarioDocumento, BigDecimal importeImpuestoUnitarioDocumento, BigDecimal precioNetoUnitarioDocumento,BigDecimal importeDescuentoSinImpuestosUnitarioDocumento, 
	BigDecimal importeDescuentoUnitarioDocumento, BigDecimal porcentajeDescuento, BigDecimal precioSinImpuestosUnitarioDocumento, BigDecimal precioFacturaUnitarioDocumento, BigDecimal precioContableUnitarioDocumento, BigDecimal precioCatalogoUnitarioDocumento, BigDecimal precioTotalTotalLocal, BigDecimal importeImpuestoTotalLocal, BigDecimal precioNetoTotalLocal, BigDecimal importeDescuentoSinImpuestosTotalLocal, BigDecimal importeDescuentoTotalLocal, BigDecimal precioSinImpuestosTotalLocal, BigDecimal precioFacturaTotalLocal, BigDecimal precioCatalogoTotalLocalUnidadesDemandaReal, BigDecimal precioCatalogoTotalLocal, BigDecimal precioContableTotalLocal, BigDecimal precioTotalUnitarioLocal, BigDecimal importeImpuestoUnitarioLocal, BigDecimal precioNetoUnitarioLocal, BigDecimal importeDescuentoSinImpuestosUnitarioLocal, BigDecimal importeDescuentoUnitarioLocal, BigDecimal precioSinImpuestosUnitarioLocal, BigDecimal precioFacturaUnitarioLocal, BigDecimal precioContableUnitarioLocal, BigDecimal precioCatalogoUnitarioLocal, String indicadorDentroFueraCajaBolsa, Integer numeroLinea, Integer unidadesAtendidas, Boolean indicadorNoImprimible, Float precioSinImpuestosTotalDocumento, Integer catalogo, Integer pagina, Long cabecera, Long producto, Long moneda, Long posicionSolicitud, BigDecimal precioContableTotalDocumento)
	throws DuplicateKeyException, CreateException {
    UtilidadesLog.info("****Metodo LineaDocumentoCiontable ejbCreateTodo: Entrada");
        Vector parametros = new Vector();

        this.setCabecera(cabecera);
        this.setCatalogo(catalogo);
        this.setImporteDescuentoSinImpuestoTotalDocumento( importeDescuentoSinImpuestoTotalDocumento);  
        this.setImporteDescuentoSinImpuestosTotalLocal( importeDescuentoSinImpuestosTotalLocal);
        this.setImporteDescuentoSinImpuestosUnitarioDocumento(importeDescuentoSinImpuestosUnitarioDocumento);
        this.setImporteDescuentoSinImpuestosUnitarioLocal(importeDescuentoSinImpuestosUnitarioLocal);
        this.setImporteDescuentoTotalDocumento(importeDescuentoTotalDocumento);
        this.setImporteDescuentoTotalLocal(importeDescuentoTotalLocal);
        this.setImporteDescuentoUnitarioDocumento( importeDescuentoUnitarioDocumento);
        this.setImporteDescuentoUnitarioLocal( importeDescuentoUnitarioLocal);
        this.setImporteImpuestoTotalDocumento( importeImpuestoTotalDocumento);
        this.setImporteImpuestoTotalLocal( importeImpuestoTotalLocal);
        this.setImporteImpuestoUnitarioDocumento(importeImpuestoUnitarioDocumento);
        this.setImporteImpuestoUnitarioLocal(importeImpuestoUnitarioLocal);
        this.setIndicadorDentroFueraCajaBolsa(indicadorDentroFueraCajaBolsa);
        this.setIndicadorNoImprimible(indicadorNoImprimible);
        this.setMoneda( moneda);
        this.setNumeroLinea( numeroLinea);
        //this.setOid(oid);
        this.setPagina(pagina);
        this.setPorcentajeDescuento(porcentajeDescuento);
        this.setPosicionSolicitud( posicionSolicitud);
        this.setPrecioCatalogoTotalDocumento( precioCatalogoTotalDocumento);
        this.setPrecioCatalogoTotalLocal( precioCatalogoTotalLocal);
        this.setPrecioCatalogoTotalLocalUnidadesDemandaReal( precioCatalogoTotalLocalUnidadesDemandaReal);
        this.setPrecioCatalogoUnitarioDocumento( precioCatalogoUnitarioDocumento);
        this.setPrecioCatalogoUnitarioLocal( precioCatalogoUnitarioLocal);
        this.setPrecioContableTotalDocumento( precioContableTotalDocumento);
        this.setPrecioContableTotalLocal( precioContableTotalLocal);
        this.setPrecioContableUnitarioDocumento( precioContableUnitarioDocumento);
        this.setPrecioContableUnitarioLocal( precioContableUnitarioLocal);
        this.setPrecioFacturaTotalDocumento( precioFacturaTotalDocumento);
        this.setPrecioFacturaTotalLocal( precioFacturaTotalLocal);
        this.setPrecioFacturaUnitarioDocumento( precioFacturaUnitarioDocumento);
        this.setPrecioFacturaUnitarioLocal( precioFacturaUnitarioLocal);
        this.setPrecioNetoTotalDocumento( precioNetoTotalDocumento);
        this.setPrecioNetoTotalLocal( precioNetoTotalLocal);
        this.setPrecioNetoUnitarioDocumento( precioNetoUnitarioDocumento);
        this.setPrecioNetoUnitarioLocal( precioNetoUnitarioLocal);
        this.setPrecioSinImpuestosTotalDocumento(precioSinImpuestosTotalDocumento);
        this.setPrecioSinImpuestosTotalLocal( precioSinImpuestosTotalLocal);
        this.setPrecioSinImpuestosUnitarioDocumento( precioSinImpuestosUnitarioDocumento);
        this.setPrecioSinImpuestosUnitarioLocal( precioSinImpuestosUnitarioLocal);
        this.setPrecioTotalTotalDocumento( precioTotalTotalDocumento);
        this.setPrecioTotalTotalLocal( precioTotalTotalLocal);
        this.setPrecioTotalUnitarioDocumento( precioTotalUnitarioDocumento);
        this.setPrecioTotalUnitarioLocal( precioTotalUnitarioLocal);
        this.setProducto( producto);
        this.setUnidadesAtendidas( unidadesAtendidas);

        try {
			// Asignar el nuevo oid
			this.setOid(new Long(SecuenciadorOID.obtenerSiguienteValor("FAC_DCLI_SEQ").longValue()));
		} catch (MareException me) {
			throw new CreateException();
		}

        StringBuffer query  = new StringBuffer("");

        query.append(" INSERT INTO FAC_DOCUM_CONTA_LINEA ("
        +" OID, "+" DCCA_OID_CABE , "+
         " NUM_UNID_ATEN, "+" SOPO_OID_SOLI_POSI, "+" PROD_OID_PROD, "+
         " NUM_LINEA ,");
         //Campos obligatorios
        parametros.add(this.getOid());
        parametros.add(this.getCabecera());
        parametros.add(this.getUnidadesAtendidas());
        parametros.add(this.getPosicionSolicitud());
        parametros.add(this.getProducto());
        parametros.add(this.getNumeroLinea());
		if(this.getMoneda()!=null){
			query.append(" MONE_OID_MONE , ");
			parametros.add(this.getMoneda());
		}
        if(this.getPrecioCatalogoTotalDocumento() != null){

            query.append(" VAL_PREC_CATA_TOTA_DOCU , ");
            parametros.add(this.getPrecioCatalogoTotalDocumento( ));
        }
        if(this.getPrecioNetoTotalDocumento( ) != null){

            query.append(" VAL_PREC_NETO_TOTA_DOCU , ");
            parametros.add(this.getPrecioNetoTotalDocumento( ));
            
        }
        if(this.getImporteImpuestoTotalDocumento( ) != null){

            query.append(" IMP_IMPU_TOTA_DOCU , ");
            parametros.add(this.getImporteImpuestoTotalDocumento( ));
        }
        if(this.getImporteDescuentoSinImpuestoTotalDocumento( ) != null){

            query.append(" IMP_DESC_SIN_IMPU_TOTA_DOCU , ");
            parametros.add(this.getImporteDescuentoSinImpuestoTotalDocumento( ));  
        }
        if(this.getImporteDescuentoTotalDocumento( ) != null){

            query.append(" IMP_DESC_TOTA_DOCU , ");
            	parametros.add(this.getImporteDescuentoTotalDocumento());

            
        }
        if(this.getPrecioFacturaTotalDocumento( ) != null){

            query.append(" VAL_PREC_FACT_TOTA_DOCU , ");
            parametros.add(this.getPrecioFacturaTotalDocumento( ));
            
        }
        if(this.getPrecioTotalTotalDocumento( ) != null){

            query.append(" VAL_PREC_TOTA_TOTA_DOCU , ");
            parametros.add(this.getPrecioTotalTotalDocumento( ));
            
        }
        if(this.getPrecioContableTotalDocumento( ) != null){

            query.append(" VAL_PREC_CONT_TOTA_DOCU , ");
            parametros.add(this.getPrecioContableTotalDocumento( ));
            
        }
        if(this.getPrecioTotalUnitarioDocumento( ) != null){

            query.append(" VAL_PREC_TOTA_UNIT_DOCU , ");
            parametros.add(this.getPrecioTotalUnitarioDocumento( ));
            
        }
        if(this.getImporteImpuestoUnitarioDocumento( ) != null){

            query.append(" IMP_IMPU_UNIT_DOCU , ");
            parametros.add(this.getImporteImpuestoUnitarioDocumento());
            
        }
        if(this.getPrecioNetoUnitarioDocumento( ) != null){

            query.append(" VAL_PREC_NETO_UNIT_DOCU , ");
            parametros.add(this.getPrecioNetoUnitarioDocumento( ));
            
        }
        if(this.getImporteDescuentoSinImpuestosUnitarioDocumento( ) != null){

            query.append(" IMP_DESC_SIN_IMPU_UNIT_DOCU , ");
            parametros.add(this.getImporteDescuentoSinImpuestosUnitarioDocumento());
            
        }
        if(this.getImporteDescuentoUnitarioDocumento( ) != null){

            query.append(" IMP_DESC_UNIT_DOCU , ");
            parametros.add(this.getImporteDescuentoUnitarioDocumento( ));
            
        }
        if(this.getPorcentajeDescuento( ) != null){

            query.append(" VAL_PORC_DESC , ");
            parametros.add(this.getPorcentajeDescuento( ));
            
        }
        if(this.getPrecioSinImpuestosUnitarioDocumento( ) != null){

            query.append(" VAL_PREC_SIN_IMPU_UNIT_DOCU , ");
            parametros.add(this.getPrecioSinImpuestosUnitarioDocumento( ));
            
        }
        if(this.getPrecioFacturaUnitarioDocumento( ) != null){

            query.append(" VAL_PREC_FACT_UNIT_DOCU , ");
            parametros.add(this.getPrecioFacturaUnitarioDocumento( ));
            
        }
        if(this.getPrecioContableUnitarioDocumento( ) != null){

            query.append(" VAL_PREC_CONT_UNIT_DOCU , ");
            parametros.add(this.getPrecioContableUnitarioDocumento( ));
            
        }
        if(this.getPrecioCatalogoUnitarioDocumento( ) != null){

            query.append(" VAL_PREC_CATA_UNIT_DOCU , ");
            parametros.add(this.getPrecioCatalogoUnitarioDocumento( ));
            
        }
        if(this.getPrecioTotalTotalLocal( ) != null){

            query.append(" VAL_PREC_TOTA_TOTA_LOCA , ");
            parametros.add(this.getPrecioTotalTotalLocal( ));
            
        }
        if(this.getImporteImpuestoTotalLocal( ) != null){

            query.append(" IMP_IMPU_TOTA_LOCA , ");
            parametros.add(this.getImporteImpuestoTotalLocal( ));
            
        }
        if(this.getPrecioNetoTotalLocal( ) != null){

            query.append(" VAL_PREC_NETO_TOTA_LOCA , ");
            parametros.add(this.getPrecioNetoTotalLocal( ));
            
        }
        if(this.getImporteDescuentoSinImpuestosTotalLocal( ) != null){

            query.append(" IMP_DESC_SIN_IMPU_TOTA_LOCA , ");
            parametros.add(this.getImporteDescuentoSinImpuestosTotalLocal( ));
            
        }
        if(this.getImporteDescuentoTotalLocal( ) != null){

            query.append(" IMP_DESC_TOTA_LOCA , ");
            parametros.add(this.getImporteDescuentoTotalLocal());
        }
        if(this.getPrecioSinImpuestosTotalLocal( ) != null){

            query.append(" VAL_PREC_SIN_IMPU_TOTA_LOCA , ");
            parametros.add(this.getPrecioSinImpuestosTotalLocal( ));
            
        }
        if(this.getPrecioFacturaTotalLocal( ) != null){

            query.append(" VAL_PREC_FACT_TOTA_LOCA , ");
            parametros.add(this.getPrecioFacturaTotalLocal( ));
            
        }
        if(this.getPrecioCatalogoTotalLocalUnidadesDemandaReal( ) != null){

            query.append(" VAL_PREC_CATA_LOCA_UNID_DEMA , ");
            parametros.add(this.getPrecioCatalogoTotalLocalUnidadesDemandaReal( ));
            
        }
        if(this.getPrecioCatalogoTotalLocal( ) != null){

            query.append(" VAL_PREC_CATA_TOTA_LOCA , ");
            parametros.add(this.getPrecioCatalogoTotalLocal( ));
            
        }
        if(this.getPrecioContableTotalLocal( ) != null){

            query.append(" VAL_PREC_CONT_TOTA_LOCA , ");
            parametros.add(this.getPrecioContableTotalLocal( ));
            
        }
        if(this.getPrecioTotalUnitarioLocal( ) != null){

            query.append(" VAL_PREC_TOTA_UNIT_LOCA , ");
            parametros.add(this.getPrecioTotalUnitarioLocal( ));
            
        }
        if(this.getImporteImpuestoUnitarioLocal( ) != null){

            query.append(" IMP_IMPU_UNIT_LOCA , ");
            parametros.add(this.getImporteImpuestoUnitarioLocal());
            
        }
        if(this.getPrecioNetoUnitarioLocal( ) != null){

            query.append(" VAL_PREC_NETO_UNIT_LOCA , ");
            parametros.add(this.getPrecioNetoUnitarioLocal( ));
            
        }
        if(this.getImporteDescuentoUnitarioLocal( ) != null){

            query.append(" IMP_DESC_UNIT_LOCA , ");
            parametros.add(this.getImporteDescuentoUnitarioLocal( ));
            
        }
        if(this.getPrecioSinImpuestosUnitarioLocal( ) != null){

            query.append(" VAL_PREC_SIN_IMPU_UNIT , ");
            parametros.add(this.getPrecioSinImpuestosUnitarioLocal( ));
            
        }
        if(this.getImporteDescuentoSinImpuestosUnitarioLocal( ) != null){

            query.append(" IMP_DESC_SIN_IMPU_UNIT , ");
            parametros.add(this.getImporteDescuentoSinImpuestosUnitarioLocal());
            
        }
        if(this.getPrecioFacturaUnitarioLocal( ) != null){

            query.append(" VAL_PREC_FACT_UNIT_LOCA , ");
            parametros.add(this.getPrecioFacturaUnitarioLocal( ));
            
        }
        if(this.getPrecioContableUnitarioLocal( ) != null){

            query.append(" VAL_PREC_CONT_UNIT_LOCA , ");
            parametros.add(this.getPrecioContableUnitarioLocal( ));
            
        }
        if(this.getPrecioCatalogoUnitarioLocal( ) != null){

            query.append(" VAL_PREC_CATA_UNIT_LOCA , ");
            parametros.add(this.getPrecioCatalogoUnitarioLocal( ));
            
        }
        if(this.getPrecioSinImpuestosTotalDocumento( ) != null){

            query.append(" VAL_PREC_SIN_IMPU_TOTA_DOCU , ");
            parametros.add(this.getPrecioSinImpuestosTotalDocumento());
            
        }
        if(this.getPagina( ) != null){

            query.append(" NUM_PAGI , ");
            parametros.add(this.getPagina());
            
        }
        if(this.getIndicadorDentroFueraCajaBolsa( ) != null){

            query.append(" IND_DENT_FUER_CAJA_BOLS , ");
            parametros.add(this.getIndicadorDentroFueraCajaBolsa());
            
        }
        if(this.getIndicadorNoImprimible( ) != null){

            query.append(" IND_NO_IMPR , ");
            parametros.add(this.getIndicadorNoImprimible());
            
        }
        if(this.getCatalogo( ) != null){

            query.append(" VAL_CATA , ");
            parametros.add(this.getCatalogo());
            
        }
        StringBuffer temp = null;
        temp = query.delete(query.length()-2,query.length()); //para quitar el ultimo espacio y la ,
        query = temp;
        query.append(") VALUES ( ");
        for (int i = 0; i < parametros.size(); i++){
            query.append(" ? ,");
        }
        temp = query.delete(query.length()-1,query.length()); //para quitar la ,
        query.append(")");
        
        try {
			ejecuta(query.toString(), parametros);
         } catch (EJBException ejbe) {
            ejbe.printStackTrace();
			String falloSQL = (ejbe.getCausedByException()).getMessage();
			if (falloSQL.indexOf("ORA-00001") != -1)
				throw new DuplicateKeyException();
			else if (falloSQL.indexOf("ORA-02291") != -1)
				throw new CreateException();
			else
				throw ejbe;
		 }catch (Exception e){
        e.printStackTrace();
        throw new CreateException();
     }
          UtilidadesLog.info("****Metodo LineaDocumentoCiontable ejbCreateTodo: Salida");
        return this.getOid();
       
    }

    public void ejbPostCreate(BigDecimal precioTotalTotalDocumento, BigDecimal precioNetoTotalDocumento, BigDecimal importeImpuestoTotalDocumento, BigDecimal importeDescuentoSinImpuestoTotalDocumento, BigDecimal importeDescuentoTotalDocumento, BigDecimal precioFacturaTotalDocumento, BigDecimal precioCatalogoTotalDocumento, BigDecimal precioTotalUnitarioDocumento, BigDecimal importeImpuestoUnitarioDocumento, BigDecimal precioNetoUnitarioDocumento,
	  BigDecimal importeDescuentoSinImpuestosUnitarioDocumento, BigDecimal importeDescuentoUnitarioDocumento, BigDecimal porcentajeDescuento, BigDecimal precioSinImpuestosUnitarioDocumento, BigDecimal precioFacturaUnitarioDocumento, BigDecimal precioContableUnitarioDocumento, BigDecimal precioCatalogoUnitarioDocumento, BigDecimal precioTotalTotalLocal, BigDecimal importeImpuestoTotalLocal, BigDecimal precioNetoTotalLocal, BigDecimal importeDescuentoSinImpuestosTotalLocal, BigDecimal importeDescuentoTotalLocal, BigDecimal precioSinImpuestosTotalLocal, BigDecimal precioFacturaTotalLocal, BigDecimal precioCatalogoTotalLocalUnidadesDemandaReal, BigDecimal precioCatalogoTotalLocal, BigDecimal precioContableTotalLocal, BigDecimal precioTotalUnitarioLocal, BigDecimal importeImpuestoUnitarioLocal, BigDecimal precioNetoUnitarioLocal, BigDecimal importeDescuentoSinImpuestosUnitarioLocal, BigDecimal importeDescuentoUnitarioLocal, BigDecimal precioSinImpuestosUnitarioLocal, BigDecimal precioFacturaUnitarioLocal, BigDecimal precioContableUnitarioLocal, BigDecimal precioCatalogoUnitarioLocal, String indicadorDentroFueraCajaBolsa, Integer numeroLinea, Integer unidadesAtendidas, Boolean indicadorNoImprimible, Float precioSinImpuestosTotalDocumento, Integer catalogo, Integer pagina, Long cabecera, Long producto, Long moneda, Long posicionSolicitud, BigDecimal precioContableTotalDocumento) throws DuplicateKeyException {
    }

    public Long ejbFindByPrimaryKey(Long primaryKey) throws FinderException {
		 UtilidadesLog.info("****Metodo LineaDocumentoCiontable ejbFindByPrimaryKey: Entrada");
        Vector parametros = new Vector();
        StringBuffer query= new StringBuffer("");

        query.append(" SELECT OID FROM FAC_DOCUM_CONTA_LINEA ");
        query.append(" WHERE OID = ? ");
        parametros.add(primaryKey);

        RecordSet resultado = null;

		try {
			resultado = this.ejecutaConsulta(query.toString(), parametros);
		} catch (EJBException ex) {
			throw new EJBException();
		}

        if (resultado.esVacio()) {
            throw new FinderException();
        }
        UtilidadesLog.info("****Metodo LineaDocumentoCiontable ejbFindByPrimaryKey: Salida");
        return primaryKey;
    }

    public void ejbActivate() {
    }

    public void ejbLoad() {
		 UtilidadesLog.info("****Metodo LineaDocumentoCiontable ejbLoad: Entrada");
        Vector parametros = new Vector();
        StringBuffer query = new StringBuffer("");
        
        query.append(" SELECT * FROM FAC_DOCUM_CONTA_LINEA ");
        query.append(" WHERE OID = ? ");
        parametros.add((Long)context.getPrimaryKey());//Se toma la PK del contexto

        RecordSet resultado = null;

		try {
			resultado = this.ejecutaConsulta(query.toString(), parametros);
		} catch (EJBException ex) {
			throw new EJBException();
		}

        if(!resultado.esVacio()){

      // Al oid le damos la primary key, esto es obligatorio hacerlo, pues                                       
			// si venimos de un findby, el oid no se cargaría                                                          
			this.setOid((Long)context.getPrimaryKey());
            
            this.setCabecera(new Long(((BigDecimal)resultado.getValueAt(0,"DCCA_OID_CABE")).longValue()));
			
            this.setNumeroLinea( new Integer(((BigDecimal)resultado.getValueAt(0,"NUM_LINEA")).intValue()));
            this.setPosicionSolicitud( new Long(((BigDecimal)resultado.getValueAt(0,"SOPO_OID_SOLI_POSI")).longValue()));
            this.setProducto( new Long(((BigDecimal)resultado.getValueAt(0,"PROD_OID_PROD")).longValue()));
            this.setUnidadesAtendidas(new Integer(((BigDecimal)resultado.getValueAt(0,"NUM_UNID_ATEN")).intValue()));

            this.setMoneda((BigDecimal)resultado.getValueAt(0,"MONE_OID_MONE")!=null ? new Long(((BigDecimal)resultado.getValueAt(0,"MONE_OID_MONE")).longValue()):null);
            this.setImporteDescuentoSinImpuestoTotalDocumento( (BigDecimal)resultado.getValueAt(0,"IMP_DESC_SIN_IMPU_TOTA_DOCU") != null ?(BigDecimal)resultado.getValueAt(0,"IMP_DESC_SIN_IMPU_TOTA_DOCU") : null);  
            this.setImporteDescuentoSinImpuestosTotalLocal( (BigDecimal)resultado.getValueAt(0,"IMP_DESC_SIN_IMPU_TOTA_LOCA") != null ?(BigDecimal)resultado.getValueAt(0,"IMP_DESC_SIN_IMPU_TOTA_LOCA"):null);
            this.setImporteDescuentoSinImpuestosUnitarioDocumento((BigDecimal)resultado.getValueAt(0,"IMP_DESC_SIN_IMPU_UNIT_DOCU") != null ?(BigDecimal)resultado.getValueAt(0,"IMP_DESC_SIN_IMPU_UNIT_DOCU"): null);
            this.setImporteDescuentoSinImpuestosUnitarioLocal((BigDecimal)resultado.getValueAt(0,"IMP_DESC_SIN_IMPU_UNIT") != null ? (BigDecimal)resultado.getValueAt(0,"IMP_DESC_SIN_IMPU_UNIT") : null);
            this.setImporteDescuentoTotalDocumento((BigDecimal)resultado.getValueAt(0,"IMP_DESC_TOTA_DOCU") != null ? (BigDecimal)resultado.getValueAt(0,"IMP_DESC_TOTA_DOCU"): null);
            this.setImporteDescuentoTotalLocal((BigDecimal)resultado.getValueAt(0,"IMP_DESC_TOTA_LOCA") != null ?(BigDecimal)resultado.getValueAt(0,"IMP_DESC_TOTA_LOCA"):null);
            this.setImporteDescuentoUnitarioDocumento( (BigDecimal)resultado.getValueAt(0,"IMP_DESC_UNIT_DOCU") != null ?(BigDecimal)resultado.getValueAt(0,"IMP_DESC_UNIT_DOCU"): null);
            this.setImporteDescuentoUnitarioLocal( (BigDecimal)resultado.getValueAt(0,"IMP_DESC_UNIT_LOCA") != null ?(BigDecimal)resultado.getValueAt(0,"IMP_DESC_UNIT_LOCA"): null);
            this.setImporteImpuestoTotalDocumento( (BigDecimal)resultado.getValueAt(0,"IMP_IMPU_TOTA_DOCU") != null ?(BigDecimal)resultado.getValueAt(0,"IMP_IMPU_TOTA_DOCU"): null);
            this.setImporteImpuestoTotalLocal((BigDecimal)resultado.getValueAt(0,"IMP_IMPU_TOTA_LOCA") != null ? (BigDecimal)resultado.getValueAt(0,"IMP_IMPU_TOTA_LOCA"): null);
            this.setImporteImpuestoUnitarioDocumento((BigDecimal)resultado.getValueAt(0,"IMP_IMPU_UNIT_DOCU")!= null ?(BigDecimal)resultado.getValueAt(0,"IMP_IMPU_UNIT_DOCU"): null);
            this.setImporteImpuestoUnitarioLocal((BigDecimal)resultado.getValueAt(0,"IMP_IMPU_UNIT_LOCA") != null ? (BigDecimal)resultado.getValueAt(0,"IMP_IMPU_UNIT_LOCA"): null);
            this.setIndicadorDentroFueraCajaBolsa((BigDecimal)resultado.getValueAt(0,"IND_DENT_FUER_CAJA_BOLS")!= null ? ((BigDecimal)resultado.getValueAt(0,"IND_DENT_FUER_CAJA_BOLS")).toString(): null);

			this.setCatalogo((BigDecimal)resultado.getValueAt(0,"VAL_CATA") != null ? new Integer(((BigDecimal)resultado.getValueAt(0,"VAL_CATA")).intValue()): null);
			if(((BigDecimal)resultado.getValueAt(0,"IND_NO_IMPR"))!=null){
				this.setIndicadorNoImprimible(new Boolean(((BigDecimal)resultado.getValueAt(0,"IND_NO_IMPR")).intValue() == 1 ? true : false));
			}
            this.setPrecioSinImpuestosTotalDocumento((BigDecimal)resultado.getValueAt(0,"VAL_PREC_SIN_IMPU_TOTA_DOCU ") != null ? new Float(((BigDecimal)resultado.getValueAt(0,"VAL_PREC_SIN_IMPU_TOTA_DOCU ")).floatValue()): null);
            this.setPagina((BigDecimal)resultado.getValueAt(0,"NUM_PAGI") != null ? new Integer(((BigDecimal)resultado.getValueAt(0,"NUM_PAGI")).intValue()): null);
            this.setPorcentajeDescuento((BigDecimal)resultado.getValueAt(0,"VAL_PORC_DESC") != null ? (BigDecimal)resultado.getValueAt(0,"VAL_PORC_DESC"): null);
           
            this.setPrecioCatalogoTotalDocumento((BigDecimal)resultado.getValueAt(0,"VAL_PREC_CATA_TOTA_DOCU") != null ?(BigDecimal)resultado.getValueAt(0,"VAL_PREC_CATA_TOTA_DOCU"): null);
            this.setPrecioCatalogoTotalLocal( (BigDecimal)resultado.getValueAt(0,"VAL_PREC_CATA_TOTA_LOCA") != null ? (BigDecimal)resultado.getValueAt(0,"VAL_PREC_CATA_TOTA_LOCA"): null);
            this.setPrecioCatalogoTotalLocalUnidadesDemandaReal((BigDecimal)resultado.getValueAt(0,"VAL_PREC_CATA_LOCA_UNID_DEMA") != null ?(BigDecimal)resultado.getValueAt(0,"VAL_PREC_CATA_LOCA_UNID_DEMA"): null);
            this.setPrecioCatalogoUnitarioDocumento( (BigDecimal)resultado.getValueAt(0,"VAL_PREC_CATA_UNIT_DOCU") != null ?(BigDecimal)resultado.getValueAt(0,"VAL_PREC_CATA_UNIT_DOCU"): null);
            this.setPrecioCatalogoUnitarioLocal( (BigDecimal)resultado.getValueAt(0,"VAL_PREC_CATA_UNIT_LOCA") != null ?(BigDecimal)resultado.getValueAt(0,"VAL_PREC_CATA_UNIT_LOCA"): null);
            this.setPrecioContableTotalDocumento((BigDecimal)resultado.getValueAt(0,"VAL_PREC_CONT_TOTA_DOCU") != null ?(BigDecimal)resultado.getValueAt(0,"VAL_PREC_CONT_TOTA_DOCU"): null);
            this.setPrecioContableTotalLocal( (BigDecimal)resultado.getValueAt(0,"VAL_PREC_CONT_TOTA_LOCA") != null ?(BigDecimal)resultado.getValueAt(0,"VAL_PREC_CONT_TOTA_LOCA"): null);
            this.setPrecioContableUnitarioDocumento( (BigDecimal)resultado.getValueAt(0,"VAL_PREC_CONT_UNIT_DOCU") != null ?(BigDecimal)resultado.getValueAt(0,"VAL_PREC_CONT_UNIT_DOCU"): null);
            this.setPrecioContableUnitarioLocal( (BigDecimal)resultado.getValueAt(0,"VAL_PREC_CONT_UNIT_LOCA") != null ?(BigDecimal)resultado.getValueAt(0,"VAL_PREC_CONT_UNIT_LOCA"): null);
            this.setPrecioFacturaTotalDocumento( (BigDecimal)resultado.getValueAt(0,"VAL_PREC_FACT_TOTA_DOCU") != null ?(BigDecimal)resultado.getValueAt(0,"VAL_PREC_FACT_TOTA_DOCU"): null);
            this.setPrecioFacturaTotalLocal( (BigDecimal)resultado.getValueAt(0,"VAL_PREC_FACT_TOTA_LOCA") != null ?(BigDecimal)resultado.getValueAt(0,"VAL_PREC_FACT_TOTA_LOCA"): null);
            this.setPrecioFacturaUnitarioDocumento( (BigDecimal)resultado.getValueAt(0,"VAL_PREC_FACT_UNIT_DOCU") != null ?(BigDecimal)resultado.getValueAt(0,"VAL_PREC_FACT_UNIT_DOCU"): null);
            this.setPrecioFacturaUnitarioLocal( (BigDecimal)resultado.getValueAt(0,"VAL_PREC_FACT_UNIT_LOCA") != null ?(BigDecimal)resultado.getValueAt(0,"VAL_PREC_FACT_UNIT_LOCA"): null);
            this.setPrecioNetoTotalDocumento( (BigDecimal)resultado.getValueAt(0,"VAL_PREC_NETO_TOTA_DOCU") != null ?(BigDecimal)resultado.getValueAt(0,"VAL_PREC_NETO_TOTA_DOCU"): null);
            this.setPrecioNetoTotalLocal( (BigDecimal)resultado.getValueAt(0,"VAL_PREC_NETO_TOTA_LOCA") != null ?(BigDecimal)resultado.getValueAt(0,"VAL_PREC_NETO_TOTA_LOCA"): null);
            this.setPrecioNetoUnitarioDocumento( (BigDecimal)resultado.getValueAt(0,"VAL_PREC_NETO_UNIT_DOCU") != null ?(BigDecimal)resultado.getValueAt(0,"VAL_PREC_NETO_UNIT_DOCU"): null);
            this.setPrecioNetoUnitarioLocal((BigDecimal)resultado.getValueAt(0,"VAL_PREC_NETO_UNIT_LOCA") != null ?(BigDecimal)resultado.getValueAt(0,"VAL_PREC_NETO_UNIT_LOCA"): null);
            
            this.setPrecioSinImpuestosTotalLocal( (BigDecimal)resultado.getValueAt(0,"VAL_PREC_SIN_IMPU_TOTA_LOCA") != null ? (BigDecimal)resultado.getValueAt(0,"VAL_PREC_SIN_IMPU_TOTA_LOCA"): null);
            this.setPrecioSinImpuestosUnitarioDocumento((BigDecimal)resultado.getValueAt(0,"VAL_PREC_SIN_IMPU_UNIT_DOCU") != null ?(BigDecimal)resultado.getValueAt(0,"VAL_PREC_SIN_IMPU_UNIT_DOCU"): null);
            this.setPrecioSinImpuestosUnitarioLocal( (BigDecimal)resultado.getValueAt(0,"VAL_PREC_SIN_IMPU_UNIT") != null ?(BigDecimal)resultado.getValueAt(0,"VAL_PREC_SIN_IMPU_UNIT"): null);
            this.setPrecioTotalTotalDocumento((BigDecimal)resultado.getValueAt(0,"VAL_PREC_TOTA_TOTA_DOCU") != null ?(BigDecimal)resultado.getValueAt(0,"VAL_PREC_TOTA_TOTA_DOCU"): null);
            this.setPrecioTotalTotalLocal( (BigDecimal)resultado.getValueAt(0,"VAL_PREC_TOTA_TOTA_LOCA") != null ?(BigDecimal)resultado.getValueAt(0,"VAL_PREC_TOTA_TOTA_LOCA"): null);
            this.setPrecioTotalUnitarioDocumento((BigDecimal)resultado.getValueAt(0,"VAL_PREC_TOTA_UNIT_DOCU") != null ?(BigDecimal)resultado.getValueAt(0,"VAL_PREC_TOTA_UNIT_DOCU"): null);
            this.setPrecioTotalUnitarioLocal( (BigDecimal)resultado.getValueAt(0,"VAL_PREC_TOTA_UNIT_LOCA") != null ? (BigDecimal)resultado.getValueAt(0,"VAL_PREC_TOTA_UNIT_LOCA"): null);
            

            UtilidadesLog.info("****Metodo LineaDocumentoCiontable ejbLoad: Salida");
        }
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
		 UtilidadesLog.info("****Metodo LineaDocumentoCiontable ejbRemove: Entrada");
        Vector parametros = new Vector();
        StringBuffer query = new StringBuffer("");

        query.append(" DELETE FROM FAC_DOCUM_CONTA_LINEA ");
        query.append(" WHERE OID = ? ");
        parametros.add((Long)context.getPrimaryKey());

        try {
			ejecuta(query.toString(), parametros);
        } catch (Exception exception) {
			throw new EJBException(exception);
        }
		UtilidadesLog.info("****Metodo LineaDocumentoCiontable ejbRemove: Salida");
    }

    public void ejbStore() {
		UtilidadesLog.info("****Metodo LineaDocumentoCiontable ejbStore: Entrada");
        Vector parametros = new Vector();
        StringBuffer query = new StringBuffer("");

        query.append(" UPDATE FAC_DOCUM_CONTA_LINEA SET ");
        //Campos obligatorios
        /*" DCCA_OID_CABE , "+
         " NUM_UNID_ATEN, "+" SOPO_OID_SOLI_POSI, "+" PROD_OID_PROD, "+" MONE_OID_MONE, "+
         " NUM_LINEA ,"*/
         query.append(" DCCA_OID_CABE = ? , ");
         parametros.add(this.getCabecera());
         query.append(" NUM_UNID_ATEN = ? , ");
         parametros.add(this.getUnidadesAtendidas());
         query.append(" SOPO_OID_SOLI_POSI = ? , ");
         parametros.add(this.getPosicionSolicitud());
         query.append(" PROD_OID_PROD = ? , ");
         parametros.add(this.getProducto());

         query.append(" NUM_LINEA  = ? , ");
         parametros.add(this.getNumeroLinea());
         //campos nulables
		if(this.getMoneda()!=null){
			query.append(" MONE_OID_MONE = ? , ");
			parametros.add(this.getMoneda());	
		}
         if(this.getPrecioCatalogoTotalDocumento() != null){

            query.append(" VAL_PREC_CATA_TOTA_DOCU  = ? , ");
            parametros.add(this.getPrecioCatalogoTotalDocumento( ));
        }
		else{
			query.append(" VAL_PREC_CATA_TOTA_DOCU  = null , ");
		}
        if(this.getPrecioNetoTotalDocumento( ) != null){

            query.append(" VAL_PREC_NETO_TOTA_DOCU  = ? , ");
            parametros.add(this.getPrecioNetoTotalDocumento( ));
            
        }else{
			query.append(" VAL_PREC_NETO_TOTA_DOCU  = null , ");
		}
		
        if(this.getImporteImpuestoTotalDocumento( ) != null){

            query.append(" IMP_IMPU_TOTA_DOCU  = ? , ");
            parametros.add(this.getImporteImpuestoTotalDocumento( ));
        }else{
			query.append(" IMP_IMPU_TOTA_DOCU  = null , ");
		}
		
        if(this.getImporteDescuentoSinImpuestoTotalDocumento( ) != null){

            query.append(" IMP_DESC_SIN_IMPU_TOTA_DOCU  = ? , ");
            parametros.add(this.getImporteDescuentoSinImpuestoTotalDocumento( ));  
        }else{
			query.append(" IMP_DESC_SIN_IMPU_TOTA_DOCU  = null , ");
		}
        if(this.getImporteDescuentoTotalDocumento( ) != null){

            query.append(" IMP_DESC_TOTA_DOCU  = ? , ");
            parametros.add(this.getImporteDescuentoTotalDocumento());
  
        }else{
			query.append(" IMP_DESC_TOTA_DOCU  = null , ");
		}
        if(this.getPrecioFacturaTotalDocumento( ) != null){

            query.append(" VAL_PREC_FACT_TOTA_DOCU  = ? , ");
            parametros.add(this.getPrecioFacturaTotalDocumento( ));
            
        }else{
			query.append(" VAL_PREC_FACT_TOTA_DOCU  = null , ");
		}
        if(this.getPrecioTotalTotalDocumento( ) != null){

            query.append(" VAL_PREC_TOTA_TOTA_DOCU  = ? , ");
            parametros.add(this.getPrecioTotalTotalDocumento( ));
            
        }else{
			query.append(" VAL_PREC_TOTA_TOTA_DOCU  = null , ");
		}
        if(this.getPrecioContableTotalDocumento( ) != null){

            query.append(" VAL_PREC_CONT_TOTA_DOCU  = ? , ");
            parametros.add(this.getPrecioContableTotalDocumento( ));
        }else{
			query.append(" VAL_PREC_CONT_TOTA_DOCU  = null , ");
		}
        if(this.getPrecioTotalUnitarioDocumento( ) != null){

            query.append(" VAL_PREC_TOTA_UNIT_DOCU  = ? , ");
            parametros.add(this.getPrecioTotalUnitarioDocumento( ));
            
        }else{
			query.append(" VAL_PREC_TOTA_UNIT_DOCU  = null , ");
		}
        if(this.getImporteImpuestoUnitarioDocumento( ) != null){

            query.append(" IMP_IMPU_UNIT_DOCU  = ? , ");
            parametros.add(this.getImporteImpuestoUnitarioDocumento());
            
        }else{
			query.append(" IMP_IMPU_UNIT_DOCU  = null , ");
		}
        if(this.getPrecioNetoUnitarioDocumento( ) != null){

            query.append(" VAL_PREC_NETO_UNIT_DOCU  = ? , ");
            parametros.add(this.getPrecioNetoUnitarioDocumento( ));
            
        }else{
			query.append(" VAL_PREC_NETO_UNIT_DOCU  = null , ");
		}
        if(this.getImporteDescuentoSinImpuestosUnitarioDocumento( ) != null){

            query.append(" IMP_DESC_SIN_IMPU_UNIT_DOCU  = ? , ");
            parametros.add(this.getImporteDescuentoSinImpuestosUnitarioDocumento());
            
        }else{
			query.append(" IMP_DESC_SIN_IMPU_UNIT_DOCU  = null , ");
		}
        if(this.getImporteDescuentoUnitarioDocumento( ) != null){

            query.append(" IMP_DESC_UNIT_DOCU  = ? , ");
            parametros.add(this.getImporteDescuentoUnitarioDocumento( ));
            
        }else{
			query.append(" IMP_DESC_UNIT_DOCU  = null , ");
		}
        if(this.getPorcentajeDescuento( ) != null){

            query.append(" VAL_PORC_DESC  = ? , ");
            parametros.add(this.getPorcentajeDescuento( ));
            
        }else{
			query.append(" VAL_PORC_DESC  = null , ");
		}
        if(this.getPrecioSinImpuestosUnitarioDocumento( ) != null){

            query.append(" VAL_PREC_SIN_IMPU_UNIT_DOCU  = ? , ");
            parametros.add(this.getPrecioSinImpuestosUnitarioDocumento( ));
            
        }else{
			query.append(" VAL_PREC_SIN_IMPU_UNIT_DOCU  = null , ");
		}
        if(this.getPrecioFacturaUnitarioDocumento( ) != null){

            query.append(" VAL_PREC_FACT_UNIT_DOCU  = ? , ");
            parametros.add(this.getPrecioFacturaUnitarioDocumento( ));
            
        }else{
			query.append(" VAL_PREC_FACT_UNIT_DOCU  = null , ");
		}
        if(this.getPrecioContableUnitarioDocumento( ) != null){

            query.append(" VAL_PREC_CONT_UNIT_DOCU  = ? , ");
            parametros.add(this.getPrecioContableUnitarioDocumento( ));
            
        }else{
			query.append(" VAL_PREC_CONT_UNIT_DOCU  = null , ");
		}
        if(this.getPrecioCatalogoUnitarioDocumento( ) != null){

            query.append(" VAL_PREC_CATA_UNIT_DOCU  = ? , ");
            parametros.add(this.getPrecioCatalogoUnitarioDocumento( ));
            
        }else{
			query.append(" VAL_PREC_CATA_UNIT_DOCU  = null , ");
		}
        if(this.getPrecioTotalTotalLocal( ) != null){

            query.append(" VAL_PREC_TOTA_TOTA_LOCA  = ? , ");
            parametros.add(this.getPrecioTotalTotalLocal( ));
            
        }else{
			query.append(" VAL_PREC_TOTA_TOTA_LOCA  = null , ");
		}
        if(this.getImporteImpuestoTotalLocal( ) != null){

            query.append(" IMP_IMPU_TOTA_LOCA  = ? , ");
            parametros.add(this.getImporteImpuestoTotalLocal( ));
            
        }else{
			query.append(" IMP_IMPU_TOTA_LOCA  = null , ");
		}
        if(this.getPrecioNetoTotalLocal( ) != null){

            query.append(" VAL_PREC_NETO_TOTA_LOCA  = ? , ");
            parametros.add(this.getPrecioNetoTotalLocal( ));
            
        }else{
			query.append(" VAL_PREC_NETO_TOTA_LOCA  = null , ");
		}
        if(this.getImporteDescuentoSinImpuestosTotalLocal( ) != null){

            query.append(" IMP_DESC_SIN_IMPU_TOTA_LOCA  = ? , ");
            parametros.add(this.getImporteDescuentoSinImpuestosTotalLocal( ));
            
        }else{
			query.append(" IMP_DESC_SIN_IMPU_TOTA_LOCA  = null , ");
		}
        if(this.getImporteDescuentoTotalLocal( ) != null){

            query.append(" IMP_DESC_TOTA_LOCA  = ? , ");
            parametros.add(this.getImporteDescuentoTotalLocal());
        }else{
			query.append(" IMP_DESC_TOTA_LOCA  = null , ");
		}
        if(this.getPrecioSinImpuestosTotalLocal( ) != null){

            query.append(" VAL_PREC_SIN_IMPU_TOTA_LOCA  = ? , ");
            parametros.add(this.getPrecioSinImpuestosTotalLocal( ));
            
        }else{
			query.append(" VAL_PREC_SIN_IMPU_TOTA_LOCA  = null , ");
		}
        if(this.getPrecioFacturaTotalLocal( ) != null){

            query.append(" VAL_PREC_FACT_TOTA_LOCA  = ? , ");
            parametros.add(this.getPrecioFacturaTotalLocal( ));
            
        }else{
			query.append(" VAL_PREC_FACT_TOTA_LOCA  = null , ");
		}
        if(this.getPrecioCatalogoTotalLocalUnidadesDemandaReal( ) != null){

            query.append(" VAL_PREC_CATA_LOCA_UNID_DEMA  = ? , ");
            parametros.add(this.getPrecioCatalogoTotalLocalUnidadesDemandaReal( ));
            
        }else{
			query.append(" VAL_PREC_CATA_LOCA_UNID_DEMA  = null , ");
		}
        if(this.getPrecioCatalogoTotalLocal( ) != null){

            query.append(" VAL_PREC_CATA_TOTA_LOCA  = ? , ");
            parametros.add(this.getPrecioCatalogoTotalLocal( ));
            
        }else{
			query.append(" VAL_PREC_CATA_TOTA_LOCA  = null , ");
		}
        if(this.getPrecioContableTotalLocal( ) != null){

            query.append(" VAL_PREC_CONT_TOTA_LOCA  = ? , ");
            parametros.add(this.getPrecioContableTotalLocal( ));
            
        }else{
			query.append(" VAL_PREC_CONT_TOTA_LOCA  = null , ");
		}
        if(this.getPrecioTotalUnitarioLocal( ) != null){

            query.append(" VAL_PREC_TOTA_UNIT_LOCA  = ? , ");
            parametros.add(this.getPrecioTotalUnitarioLocal( ));
            
        }else{
			query.append(" VAL_PREC_TOTA_UNIT_LOCA  = null , ");
		}
        if(this.getImporteImpuestoUnitarioLocal( ) != null){

            query.append(" IMP_IMPU_UNIT_LOCA  = ? , ");
            parametros.add(this.getImporteImpuestoUnitarioLocal());
            
        }else{
			query.append(" IMP_IMPU_UNIT_LOCA  = null , ");
		}
        if(this.getPrecioNetoUnitarioLocal( ) != null){

            query.append(" VAL_PREC_NETO_UNIT_LOCA  = ? , ");
            parametros.add(this.getPrecioNetoUnitarioLocal( ));
            
        }else{
			query.append(" VAL_PREC_NETO_UNIT_LOCA  = null , ");
		}
        if(this.getImporteDescuentoUnitarioLocal( ) != null){

            query.append(" IMP_DESC_UNIT_LOCA  = ? , ");
            parametros.add(this.getImporteDescuentoUnitarioLocal( ));
            
        }else{
			query.append(" IMP_DESC_UNIT_LOCA  = null , ");
		}
        if(this.getPrecioSinImpuestosUnitarioLocal( ) != null){

            query.append(" VAL_PREC_SIN_IMPU_UNIT  = ? , ");
            parametros.add(this.getPrecioSinImpuestosUnitarioLocal( ));
            
        }else{
			query.append(" VAL_PREC_SIN_IMPU_UNIT  = null , ");
		}
        if(this.getImporteDescuentoSinImpuestosUnitarioLocal( ) != null){

            query.append(" IMP_DESC_SIN_IMPU_UNIT  = ? , ");
            parametros.add(this.getImporteDescuentoSinImpuestosUnitarioLocal());
            
        }else{
			query.append(" IMP_DESC_SIN_IMPU_UNIT  = null , ");
		}
        if(this.getPrecioFacturaUnitarioLocal( ) != null){

            query.append(" VAL_PREC_FACT_UNIT_LOCA  = ? , ");
            parametros.add(this.getPrecioFacturaUnitarioLocal( ));
            
        }else{ query.append(" VAL_PREC_FACT_UNIT_LOCA  = null , ");
			}
			
        if(this.getPrecioContableUnitarioLocal( ) != null){

            query.append(" VAL_PREC_CONT_UNIT_LOCA  = ? , ");
            parametros.add(this.getPrecioContableUnitarioLocal( ));
            
        }else{
			query.append(" VAL_PREC_CONT_UNIT_LOCA  = null , ");
		}
        if(this.getPrecioCatalogoUnitarioLocal( ) != null){

            query.append(" VAL_PREC_CATA_UNIT_LOCA  = ? , ");
            parametros.add(this.getPrecioCatalogoUnitarioLocal( ));
            
        }else{
			query.append(" VAL_PREC_CATA_UNIT_LOCA  = null , ");
		}
        if(this.getPrecioSinImpuestosTotalDocumento( ) != null){

            query.append(" VAL_PREC_SIN_IMPU_TOTA_DOCU  = ? , ");
            parametros.add(this.getPrecioSinImpuestosTotalDocumento());
            
        }else{
			query.append(" VAL_PREC_SIN_IMPU_TOTA_DOCU  = null , ");
		}
        if(this.getPagina( ) != null){

            query.append(" NUM_PAGI  = ? , ");
            parametros.add(this.getPagina());
            
        }else{
			query.append(" NUM_PAGI  = null , ");
		}
        if(this.getIndicadorDentroFueraCajaBolsa( ) != null){

            query.append(" IND_DENT_FUER_CAJA_BOLS  = ? , ");
            parametros.add(this.getIndicadorDentroFueraCajaBolsa());
            
        }else{
			query.append(" IND_DENT_FUER_CAJA_BOLS  = null , ");
		}
        if(this.getIndicadorNoImprimible( ) != null){

            query.append(" IND_NO_IMPR  = ? , ");
            parametros.add(this.getIndicadorNoImprimible());
            
        }else{
			query.append(" IND_NO_IMPR  = null , ");
		}
        if(this.getCatalogo( ) != null){

            query.append(" VAL_CATA  = ? , ");
            parametros.add(this.getCatalogo());
            
        }else{
			query.append(" VAL_CATA  = null , ");
		}

        StringBuffer temp = null;
        temp = query.delete(query.length()-2,query.length()); //para quitar el ultimo espacio y la ,
        query = temp;

        query.append(" WHERE OID = ? ");
        parametros.add((Long)context.getPrimaryKey());
        

        try {
			ejecuta(query.toString(), parametros);
        } catch (Exception exception) {
			throw new EJBException(exception);
        }
        UtilidadesLog.info("****Metodo LineaDocumentoCiontable ejbStore: Salida");
        
    }

    public void setEntityContext(EntityContext ctx) {
        this.context = ctx;
    }

    public void unsetEntityContext() {
        this.context = null;
    }

    public Long getCabecera() {
        return cabecera;
    }

    public void setCabecera(Long newCabecera) {
        cabecera = newCabecera;
    }

    public Integer getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Integer newCatalogo) {
        catalogo = newCatalogo;
    }

    public BigDecimal getImporteDescuentoSinImpuestoTotalDocumento() {
        return importeDescuentoSinImpuestoTotalDocumento;
    }

    public void setImporteDescuentoSinImpuestoTotalDocumento(BigDecimal newImporteDescuentoSinImpuestoTotalDocumento) {
        importeDescuentoSinImpuestoTotalDocumento = newImporteDescuentoSinImpuestoTotalDocumento;
    }

    public BigDecimal getImporteDescuentoSinImpuestosTotalLocal() {
        return importeDescuentoSinImpuestosTotalLocal;
    }

    public void setImporteDescuentoSinImpuestosTotalLocal(BigDecimal newImporteDescuentoSinImpuestosTotalLocal) {
        importeDescuentoSinImpuestosTotalLocal = newImporteDescuentoSinImpuestosTotalLocal;
    }

    public BigDecimal getImporteDescuentoSinImpuestosUnitarioDocumento() {
        return importeDescuentoSinImpuestosUnitarioDocumento;
    }

    public void setImporteDescuentoSinImpuestosUnitarioDocumento(BigDecimal newImporteDescuentoSinImpuestosUnitarioDocumento) {
        importeDescuentoSinImpuestosUnitarioDocumento = newImporteDescuentoSinImpuestosUnitarioDocumento;
    }

    public BigDecimal getImporteDescuentoSinImpuestosUnitarioLocal() {
        return importeDescuentoSinImpuestosUnitarioLocal;
    }

    public void setImporteDescuentoSinImpuestosUnitarioLocal(BigDecimal newImporteDescuentoSinImpuestosUnitarioLocal) {
        importeDescuentoSinImpuestosUnitarioLocal = newImporteDescuentoSinImpuestosUnitarioLocal;
    }

    public BigDecimal getImporteDescuentoTotalDocumento() {
        return importeDescuentoTotalDocumento;
    }

    public void setImporteDescuentoTotalDocumento(BigDecimal newImporteDescuentoTotalDocumento) {
        importeDescuentoTotalDocumento = newImporteDescuentoTotalDocumento;
    }

    public BigDecimal getImporteDescuentoTotalLocal() {
        return importeDescuentoTotalLocal;
    }

    public void setImporteDescuentoTotalLocal(BigDecimal newImporteDescuentoTotalLocal) {
        importeDescuentoTotalLocal = newImporteDescuentoTotalLocal;
    }

    public BigDecimal getImporteDescuentoUnitarioDocumento() {
        return importeDescuentoUnitarioDocumento;
    }

    public void setImporteDescuentoUnitarioDocumento(BigDecimal newImporteDescuentoUnitarioDocumento) {
        importeDescuentoUnitarioDocumento = newImporteDescuentoUnitarioDocumento;
    }

    public BigDecimal getImporteDescuentoUnitarioLocal() {
        return importeDescuentoUnitarioLocal;
    }

    public void setImporteDescuentoUnitarioLocal(BigDecimal newImporteDescuentoUnitarioLocal) {
        importeDescuentoUnitarioLocal = newImporteDescuentoUnitarioLocal;
    }

    public BigDecimal getImporteImpuestoTotalDocumento() {
        return importeImpuestoTotalDocumento;
    }

    public void setImporteImpuestoTotalDocumento(BigDecimal newImporteImpuestoTotalDocumento) {
        importeImpuestoTotalDocumento = newImporteImpuestoTotalDocumento;
    }

    public BigDecimal getImporteImpuestoTotalLocal() {
        return importeImpuestoTotalLocal;
    }

    public void setImporteImpuestoTotalLocal(BigDecimal newImporteImpuestoTotalLocal) {
        importeImpuestoTotalLocal = newImporteImpuestoTotalLocal;
    }

    public BigDecimal getImporteImpuestoUnitarioDocumento() {
        return importeImpuestoUnitarioDocumento;
    }

    public void setImporteImpuestoUnitarioDocumento(BigDecimal newImporteImpuestoUnitarioDocumento) {
        importeImpuestoUnitarioDocumento = newImporteImpuestoUnitarioDocumento;
    }

    public BigDecimal getImporteImpuestoUnitarioLocal() {
        return importeImpuestoUnitarioLocal;
    }

    public void setImporteImpuestoUnitarioLocal(BigDecimal newImporteImpuestoUnitarioLocal) {
        importeImpuestoUnitarioLocal = newImporteImpuestoUnitarioLocal;
    }

    public String getIndicadorDentroFueraCajaBolsa() {
        return indicadorDentroFueraCajaBolsa;
    }

    public void setIndicadorDentroFueraCajaBolsa(String newIndicadorDentroFueraCajaBolsa) {
        indicadorDentroFueraCajaBolsa = newIndicadorDentroFueraCajaBolsa;
    }

    public Boolean getIndicadorNoImprimible() {
        return indicadorNoImprimible;
    }

    public void setIndicadorNoImprimible(Boolean newIndicadorNoImprimible) {
        indicadorNoImprimible = newIndicadorNoImprimible;
    }

    public Long getMoneda() {
        return moneda;
    }

    public void setMoneda(Long newMoneda) {
        moneda = newMoneda;
    }

    public Integer getNumeroLinea() {
        return numeroLinea;
    }

    public void setNumeroLinea(Integer newNumeroLinea) {
        numeroLinea = newNumeroLinea;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long newOid) {
        oid = newOid;
    }

    public Integer getPagina() {
        return pagina;
    }

    public void setPagina(Integer newPagina) {
        pagina = newPagina;
    }

    public BigDecimal getPorcentajeDescuento() {
		return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(BigDecimal newPorcentajeDescuento) {
		porcentajeDescuento = newPorcentajeDescuento;
    }

    public Long getPosicionSolicitud() {
        return posicionSolicitud;
    }

    public void setPosicionSolicitud(Long newPosicionSolicitud) {
        posicionSolicitud = newPosicionSolicitud;
    }

    public BigDecimal getPrecioCatalogoTotalDocumento() {
        return precioCatalogoTotalDocumento;
    }

    public void setPrecioCatalogoTotalDocumento(BigDecimal newPrecioCatalogoTotalDocumento) {
        precioCatalogoTotalDocumento = newPrecioCatalogoTotalDocumento;
    }

    public BigDecimal getPrecioCatalogoTotalLocal() {
        return precioCatalogoTotalLocal;
    }

    public void setPrecioCatalogoTotalLocal(BigDecimal newPrecioCatalogoTotalLocal) {
        precioCatalogoTotalLocal = newPrecioCatalogoTotalLocal;
    }

    public BigDecimal getPrecioCatalogoTotalLocalUnidadesDemandaReal() {
        return precioCatalogoTotalLocalUnidadesDemandaReal;
    }

    public void setPrecioCatalogoTotalLocalUnidadesDemandaReal(BigDecimal newPrecioCatalogoTotalLocalUnidadesDemandaReal) {
        precioCatalogoTotalLocalUnidadesDemandaReal = newPrecioCatalogoTotalLocalUnidadesDemandaReal;
    }

    public BigDecimal getPrecioCatalogoUnitarioDocumento() {
        return precioCatalogoUnitarioDocumento;
    }

    public void setPrecioCatalogoUnitarioDocumento(BigDecimal newPrecioCatalogoUnitarioDocumento) {
        precioCatalogoUnitarioDocumento = newPrecioCatalogoUnitarioDocumento;
    }

    public BigDecimal getPrecioCatalogoUnitarioLocal() {
        return precioCatalogoUnitarioLocal;
    }

    public void setPrecioCatalogoUnitarioLocal(BigDecimal newPrecioCatalogoUnitarioLocal) {
        precioCatalogoUnitarioLocal = newPrecioCatalogoUnitarioLocal;
    }

    public BigDecimal getPrecioContableTotalDocumento() {
        return precioContableTotalDocumento;
    }

    public void setPrecioContableTotalDocumento(BigDecimal newPrecioContableTotalDocumento) {
        precioContableTotalDocumento = newPrecioContableTotalDocumento;
    }

    public BigDecimal getPrecioContableTotalLocal() {
        return precioContableTotalLocal;
    }

    public void setPrecioContableTotalLocal(BigDecimal newPrecioContableTotalLocal) {
        precioContableTotalLocal = newPrecioContableTotalLocal;
    }

    public BigDecimal getPrecioContableUnitarioDocumento() {
        return precioContableUnitarioDocumento;
    }

    public void setPrecioContableUnitarioDocumento(BigDecimal newPrecioContableUnitarioDocumento) {
        precioContableUnitarioDocumento = newPrecioContableUnitarioDocumento;
    }

    public BigDecimal getPrecioContableUnitarioLocal() {
        return precioContableUnitarioLocal;
    }

    public void setPrecioContableUnitarioLocal(BigDecimal newPrecioContableUnitarioLocal) {
        precioContableUnitarioLocal = newPrecioContableUnitarioLocal;
    }

    public BigDecimal getPrecioFacturaTotalDocumento() {
        return precioFacturaTotalDocumento;
    }

    public void setPrecioFacturaTotalDocumento(BigDecimal newPrecioFacturaTotalDocumento) {
        precioFacturaTotalDocumento = newPrecioFacturaTotalDocumento;
    }

    public BigDecimal getPrecioFacturaTotalLocal() {
        return precioFacturaTotalLocal;
    }

    public void setPrecioFacturaTotalLocal(BigDecimal newPrecioFacturaTotalLocal) {
        precioFacturaTotalLocal = newPrecioFacturaTotalLocal;
    }

    public BigDecimal getPrecioFacturaUnitarioDocumento() {
        return precioFacturaUnitarioDocumento;
    }

    public void setPrecioFacturaUnitarioDocumento(BigDecimal newPrecioFacturaUnitarioDocumento) {
        precioFacturaUnitarioDocumento = newPrecioFacturaUnitarioDocumento;
    }

    public BigDecimal getPrecioFacturaUnitarioLocal() {
        return precioFacturaUnitarioLocal;
    }

    public void setPrecioFacturaUnitarioLocal(BigDecimal newPrecioFacturaUnitarioLocal) {
        precioFacturaUnitarioLocal = newPrecioFacturaUnitarioLocal;
    }

    public BigDecimal getPrecioNetoTotalDocumento() {
        return precioNetoTotalDocumento;
    }

    public void setPrecioNetoTotalDocumento(BigDecimal newPrecioNetoTotalDocumento) {
        precioNetoTotalDocumento = newPrecioNetoTotalDocumento;
    }

    public BigDecimal getPrecioNetoTotalLocal() {
        return precioNetoTotalLocal;
    }

    public void setPrecioNetoTotalLocal(BigDecimal newPrecioNetoTotalLocal) {
        precioNetoTotalLocal = newPrecioNetoTotalLocal;
    }

    public BigDecimal getPrecioNetoUnitarioDocumento() {
        return precioNetoUnitarioDocumento;
    }

    public void setPrecioNetoUnitarioDocumento(BigDecimal newPrecioNetoUnitarioDocumento) {
        precioNetoUnitarioDocumento = newPrecioNetoUnitarioDocumento;
    }

    public BigDecimal getPrecioNetoUnitarioLocal() {
        return precioNetoUnitarioLocal;
    }

    public void setPrecioNetoUnitarioLocal(BigDecimal newPrecioNetoUnitarioLocal) {
        precioNetoUnitarioLocal = newPrecioNetoUnitarioLocal;
    }

    public Float getPrecioSinImpuestosTotalDocumento() {
        return precioSinImpuestosTotalDocumento;
    }

    public void setPrecioSinImpuestosTotalDocumento(Float newPrecioSinImpuestosTotalDocumento) {
        precioSinImpuestosTotalDocumento = newPrecioSinImpuestosTotalDocumento;
    }

    public BigDecimal getPrecioSinImpuestosTotalLocal() {
        return precioSinImpuestosTotalLocal;
    }

    public void setPrecioSinImpuestosTotalLocal(BigDecimal newPrecioSinImpuestosTotalLocal) {
        precioSinImpuestosTotalLocal = newPrecioSinImpuestosTotalLocal;
    }

    public BigDecimal getPrecioSinImpuestosUnitarioDocumento() {
        return precioSinImpuestosUnitarioDocumento;
    }

    public void setPrecioSinImpuestosUnitarioDocumento(BigDecimal newPrecioSinImpuestosUnitarioDocumento) {
        precioSinImpuestosUnitarioDocumento = newPrecioSinImpuestosUnitarioDocumento;
    }

    public BigDecimal getPrecioSinImpuestosUnitarioLocal() {
        return precioSinImpuestosUnitarioLocal;
    }

    public void setPrecioSinImpuestosUnitarioLocal(BigDecimal newPrecioSinImpuestosUnitarioLocal) {
        precioSinImpuestosUnitarioLocal = newPrecioSinImpuestosUnitarioLocal;
    }

    public BigDecimal getPrecioTotalTotalDocumento() {
        return precioTotalTotalDocumento;
    }

    public void setPrecioTotalTotalDocumento(BigDecimal newPrecioTotalTotalDocumento) {
        precioTotalTotalDocumento = newPrecioTotalTotalDocumento;
    }

    public BigDecimal getPrecioTotalTotalLocal() {
        return precioTotalTotalLocal;
    }

    public void setPrecioTotalTotalLocal(BigDecimal newPrecioTotalTotalLocal) {
        precioTotalTotalLocal = newPrecioTotalTotalLocal;
    }

    public BigDecimal getPrecioTotalUnitarioDocumento() {
        return precioTotalUnitarioDocumento;
    }

    public void setPrecioTotalUnitarioDocumento(BigDecimal newPrecioTotalUnitarioDocumento) {
        precioTotalUnitarioDocumento = newPrecioTotalUnitarioDocumento;
    }

    public BigDecimal getPrecioTotalUnitarioLocal() {
        return precioTotalUnitarioLocal;
    }

    public void setPrecioTotalUnitarioLocal(BigDecimal newPrecioTotalUnitarioLocal) {
        precioTotalUnitarioLocal = newPrecioTotalUnitarioLocal;
    }

    public Long getProducto() {
        return producto;
    }

    public void setProducto(Long newProducto) {
        producto = newProducto;
    }

    public Integer getUnidadesAtendidas() {
        return unidadesAtendidas;
    }

    public void setUnidadesAtendidas(Integer newUnidadesAtendidas) {
        unidadesAtendidas = newUnidadesAtendidas;
    }

    private int ejecuta(String query, Vector argumentos) throws EJBException {
		UtilidadesLog.info("****Metodo LineaDocumentoCiontable ejecuta: Entrada");
        BelcorpService bs = null;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new EJBException(e);
        }
        try {
			//this.loguearSql("**** BMP LineaDocumentoContable: ", query, argumentos);
			UtilidadesLog.info("****Metodo LineaDocumentoCiontable ejecuta: Salida");
		    return bs.dbService.executePreparedUpdate(query, argumentos);
        } catch (Exception e) {
            throw new EJBException(e);
        }
    }

    private RecordSet ejecutaConsulta(String consulta, Vector params) throws EJBException {                                                                
         UtilidadesLog.info("****Metodo LineaDocumentoCiontable ejecutaConsulta: Entrada");                                                                                                      
		BelcorpService bs = null;                                                                                          
                                                                                                                
		try {                                                                                                       
		   bs = BelcorpService.getInstance();                                                                      
		} catch (MareMiiServiceNotFoundException e) {                                                               
		    throw new EJBException(e);                                                                              
		}                                                                                                           
                                                                                                                
		RecordSet res = null;                                                                                              
                                                                                                                
		try {                                                                                                       
			res = bs.dbService.executePreparedQuery(consulta, params);                                              
		} catch (Exception e) {                                                                                     
			throw new EJBException(e);                                                                              
		}                                                                                                           
		 //loguearSql("**** BMP LineaDocumentoContable: ", consulta, params);  
		 UtilidadesLog.info("****Metodo LineaDocumentoCiontable ejecutaConsulta: Salida"); 
		return res;                                                                                                 
	}             

    private void loguearSql(String metodo, String sql, Vector params) {                                             
           UtilidadesLog.info("****Metodo LineaDocumentoCiontable loguearSql: Entrada");                                                                                                       
		this.getLog().info(metodo + sql);                                                                           
                                                                                                                
		if (params != null && params.size() > 0) {                                                                  
			String sParams = "";                                                                                    
			for (int i=0; i<params.size(); i++) {                                                                   
				if (params.elementAt(i) != null)                                                                    
					sParams += "param "+ (i+1) + ": " +  (params.elementAt(i)).toString() + ", ";                   
				else                                                                                                
					sParams += "param "+ (i+1) + ": es nulo, ";                                                     
			}                                                                                                       
			this.getLog().info(metodo + sParams);                                                                   
		}		
		UtilidadesLog.info("****Metodo LineaDocumentoCiontable loguearSql: Salida");
	}
    private Log getLog() {                                                                                          
		Log log = null;                                                                                             
		try {                                                                                                       
			return (((LoggingService)MareMii.getService(new MareTopic("LoggingService"))).getMareLog());            
		} catch (Exception e) {                                                                                     
			e.printStackTrace();                                                                                    
			//System.out.println ("No se pudo obtener el objeto Log");                                                
			throw new RuntimeException ("No se pudo obtener el objeto Log");                                        
		}                                                                                                           
	}	     

}