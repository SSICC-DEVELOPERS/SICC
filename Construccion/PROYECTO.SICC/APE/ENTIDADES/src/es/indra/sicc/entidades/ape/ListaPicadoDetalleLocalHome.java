package es.indra.sicc.entidades.ape;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ape.ListaPicadoDetalleLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.math.BigDecimal;

public class ListaPicadoDetalleLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ape");
    private EntityManager em = emf.createEntityManager();

    public ListaPicadoDetalleLocal create(Long codigoPosicion,  Long unidadesProducto, 
            BigDecimal valorLinea, Long numeroCaja, String indicadorImpresion, 
            String nombrePicador, Long unidadesPicadas, Long unidadesChequeadas, 
            String nombreChequeador, Long cabecera, Long mapaCentroDistribucionDetalle, 
            Long tiposCajaEmbalaje, Long producto, Long sistemaPicado, Long undidadesVerificadas) throws MareException {
            
        Long oid = SecuenciadorOID.obtenerSiguienteValor("APE_LPDE_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        ListaPicadoDetalleLocal local;
        local = new ListaPicadoDetalleLocal(oid, codigoPosicion, unidadesProducto, valorLinea, 
            numeroCaja, indicadorImpresion, nombrePicador, unidadesPicadas, unidadesChequeadas, 
            nombreChequeador, cabecera, mapaCentroDistribucionDetalle, tiposCajaEmbalaje, 
            producto, sistemaPicado, undidadesVerificadas);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(ListaPicadoDetalleLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(ListaPicadoDetalleLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public ListaPicadoDetalleLocal findByPrimaryKey(Long  oid) {
        ListaPicadoDetalleLocal local = em.find(ListaPicadoDetalleLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    
    public Collection findAll() {
        Query query=em.createNamedQuery("ListaPicadoDetalleLocal.FindAll");
        return query.getResultList();
    }

}
