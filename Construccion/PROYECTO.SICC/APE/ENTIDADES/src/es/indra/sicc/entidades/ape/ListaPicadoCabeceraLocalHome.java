package es.indra.sicc.entidades.ape;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ape.ListaPicadoCabeceraLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Timestamp;

public class ListaPicadoCabeceraLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ape");
    private EntityManager em = emf.createEntityManager();

    public ListaPicadoCabeceraLocal create(Timestamp fecCrea, Long perdOidPeri, 
            Long ccdiOidConfCentDist, Long liarOidLineArma, Long zorgOidRegi, String indImp1)
            throws MareException {
            
        Long oid = SecuenciadorOID.obtenerSiguienteValor("APE_LPCA_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        ListaPicadoCabeceraLocal local = new ListaPicadoCabeceraLocal(oid, fecCrea,
            perdOidPeri, ccdiOidConfCentDist, liarOidLineArma, zorgOidRegi, indImp1);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(ListaPicadoCabeceraLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(ListaPicadoCabeceraLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public ListaPicadoCabeceraLocal findByPrimaryKey(Long  oid) {
        ListaPicadoCabeceraLocal local = em.find(ListaPicadoCabeceraLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    
    public Collection findAll() {
        Query query=em.createNamedQuery("ListaPicadoCabeceraLocal.FindAll");
        return query.getResultList();
    }

}
