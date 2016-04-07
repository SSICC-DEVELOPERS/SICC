package es.indra.sicc.entidades.ape;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ape.HistoricoListaPicadoErrorSFLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.math.BigDecimal;

public class HistoricoListaPicadoErrorSFLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ape");
    private EntityManager em = emf.createEntityManager();

    public HistoricoListaPicadoErrorSFLocal create(Long codigoPosicion, Long unidadesProducto,
            BigDecimal valorLinea, Long numeroCaja, String indicadorImpresion, String nombrePicador, 
            Long unidadesPicadas, Long unidadesChequeadas, String nombreChequeador, 
            Long cabecera, Long mapaCentroDistribucionDetalle, Long tiposCajaEmbalaje, 
            Long producto, Long sistemaPicado, String obsRevision, Long codigoError) throws MareException {
            
        Long oid = SecuenciadorOID.obtenerSiguienteValor("APE_HLPE_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        HistoricoListaPicadoErrorSFLocal local;
        local = new HistoricoListaPicadoErrorSFLocal(oid, codigoPosicion, unidadesProducto,
            valorLinea,  numeroCaja,  indicadorImpresion,  nombrePicador, unidadesPicadas, 
            unidadesChequeadas, nombreChequeador, cabecera, mapaCentroDistribucionDetalle, 
            tiposCajaEmbalaje, producto, sistemaPicado, obsRevision, codigoError);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(HistoricoListaPicadoErrorSFLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(HistoricoListaPicadoErrorSFLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public HistoricoListaPicadoErrorSFLocal findByPrimaryKey(Long  oid) {
        HistoricoListaPicadoErrorSFLocal local = em.find(HistoricoListaPicadoErrorSFLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    public Collection findAll() {
        Query query=em.createNamedQuery("HistoricoListaPicadoErrorSFLocal.FindAll");
        return query.getResultList();
    }
}
