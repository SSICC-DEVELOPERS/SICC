package es.indra.sicc.entidades.car;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.car.IndNivelJerarquicoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class IndNivelJerarquicoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-car");
	private EntityManager em = emf.createEntityManager();

	public IndNivelJerarquicoLocal create(String cod_indi_nive_jera) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CAR_INIJ_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		IndNivelJerarquicoLocal local = new IndNivelJerarquicoLocal(oid, cod_indi_nive_jera);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(IndNivelJerarquicoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(IndNivelJerarquicoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public IndNivelJerarquicoLocal findByPrimaryKey(Long  oid) {
		IndNivelJerarquicoLocal local = (IndNivelJerarquicoLocal)em.find(IndNivelJerarquicoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}
        
        public Collection findAll() {
            Query query=em.createNamedQuery("IndNivelJerarquicoLocal.FindAll");          
            return query.getResultList();
        }

	
}
