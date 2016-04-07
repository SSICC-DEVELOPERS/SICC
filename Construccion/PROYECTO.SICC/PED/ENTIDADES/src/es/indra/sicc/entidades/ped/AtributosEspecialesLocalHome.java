package es.indra.sicc.entidades.ped;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ped.AtributosEspecialesLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class AtributosEspecialesLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ped");
    private EntityManager em = emf.createEntityManager();

    public AtributosEspecialesLocal create(String cod_atri, String des_atri, Long modu_oid_modu)
            throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("PED_ATRE_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        AtributosEspecialesLocal local = new AtributosEspecialesLocal(oid, cod_atri, des_atri, modu_oid_modu);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(AtributosEspecialesLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(AtributosEspecialesLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public AtributosEspecialesLocal findByPrimaryKey(Long  oid) {
        AtributosEspecialesLocal local = em.find(AtributosEspecialesLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    
    public AtributosEspecialesLocal findByUK(String codigoAtributo) {
        Query query=em.createNamedQuery("AtributosEspecialesLocal.FindByUK");
        query.setParameter(1, codigoAtributo);
        return (AtributosEspecialesLocal)(query.getSingleResult());
    }

    public Collection findAll() {
        Query query=em.createNamedQuery("AtributosEspecialesLocal.FindAll");
        return query.getResultList();
    }

}
