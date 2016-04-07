package es.indra.sicc.entidades.ape;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ape.SublineaArmadoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class SublineaArmadoLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ape");
    private EntityManager em = emf.createEntityManager();

    public SublineaArmadoLocal create(Long codigoSublinea, Boolean postVenta, 
            char letraParaAnaquel, Boolean imprimirListaPicado, Boolean frenteEspalda, 
            Integer bahiasFrente, Integer bahiaEspalda, Integer numeroNivelesFrente, 
            Integer numeroNivelesEspalda, Integer numeroColumnasFrente, Integer numeroColumnasEspalda, 
            Long numeroOrdenBalanceo, Long oidLineaArmado, Long oidSistemaPicado, Long oidCentroDistribucion)
            throws MareException {
            
        Long oid = SecuenciadorOID.obtenerSiguienteValor("APE_SBAR_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        SublineaArmadoLocal local;
        local = new SublineaArmadoLocal(oid, codigoSublinea, postVenta, letraParaAnaquel,
            imprimirListaPicado, frenteEspalda, bahiasFrente, bahiaEspalda, numeroNivelesFrente,
            numeroNivelesEspalda, numeroColumnasFrente, numeroColumnasEspalda, numeroOrdenBalanceo,
            oidLineaArmado, oidSistemaPicado, oidCentroDistribucion);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(SublineaArmadoLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(SublineaArmadoLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public SublineaArmadoLocal findByPrimaryKey(Long  oid) {
        SublineaArmadoLocal local = em.find(SublineaArmadoLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    
    public Collection findAll() {
        Query query=em.createNamedQuery("SublineaArmadoLocal.FindAll");
        return query.getResultList();
    }

}
