package es.indra.sicc.logicanegocio.intsys;

import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.intsys.DTOCodProdOid;
import es.indra.sicc.entidades.mae.MaestroProductosLocal;
import es.indra.sicc.entidades.mae.MaestroProductosLocalHome;
import es.indra.sicc.entidades.mae.MaestroProductosPK;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.MAEEjbLocators;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.UtilidadesLog;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;




public class ExtensionINTBean implements SessionBean 
{
    public void ejbCreate()
    {
    }

    public void ejbActivate()
    {
    }

    public void ejbPassivate()
    {
    }

    public void ejbRemove()
    {
    }

    public void setSessionContext(SessionContext ctx)
    {
    }

    private MaestroProductosLocalHome getMaestroProducosLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MaestroProductosLocalHome)context.lookup("java:comp/env/MaestroProducos");
    }
    /**
     * @author pperanzola
     * @date 26/04/05
     * @throws es.indra.mare.common.exception.MareException
     * @param datos
     * Valida si un codigo de producto ingresado es  válido  inc BELC300016106 
     * devuelve DTOCodProdOid segun BELC300016106
     */
    public DTOCodProdOid validacionCodigoProducto(MareDTO datos) 
        throws MareException {
        UtilidadesLog.info("ExtensionINTBean.validacionCodigoProducto(MareDTO datos): Entrada");
        StringBuffer query = new StringBuffer();
        DTOCodProdOid dtoCodProd = new DTOCodProdOid();
        Long paramPais = (Long) datos.getProperty("paisOidPais");
        String prodOidProd = (String) datos.getProperty("prodOidProd");
        Boolean indicadorCodigo = (Boolean) datos.getProperty("indicadorCodigo");

        MaestroProductosLocalHome maeProduLH= null;
        MaestroProductosLocal maeProduL= null;
        maeProduLH = MAEEjbLocators.getMaestroProductosLocalHome();

        if (Boolean.TRUE.equals(indicadorCodigo)){            
            try{
                
                maeProduL = maeProduLH.findByUK(paramPais,prodOidProd);
            }catch(Exception ex){
                UtilidadesLog.error(ex);
                throw new MareException ( null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INT
                                                                                        , "", ErroresDeNegocio.INT_0084));
            }
            //dtoCodProd.setOidProducto();
            dtoCodProd.setProperty("oidProducto",maeProduL.getOid());
            UtilidadesLog.debug("ExtensionINTBean.validacionCodigoProducto OID : " + maeProduL.getOid());
        }else {
            try{
                Long lngProdOidProd = new Long (prodOidProd);
                MaestroProductosPK maePK = new MaestroProductosPK(lngProdOidProd);
                maeProduL = maeProduLH.findByPrimaryKey(maePK);
            }catch(Exception ex){
                UtilidadesLog.error(ex);
                throw new MareException ( null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INT
                                                                                        , "", ErroresDeNegocio.INT_0084));
            }
            //dtoCodProd.setCodProducto(maeProduL.getCodigoSAP());
            dtoCodProd.setProperty("codProducto",maeProduL.getCodigoSAP());
            UtilidadesLog.debug("ExtensionINTBean.validacionCodigoProducto COD SAP : " + maeProduL.getCodigoSAP());
        }
        
        
        return dtoCodProd;
            
    }

  
}
