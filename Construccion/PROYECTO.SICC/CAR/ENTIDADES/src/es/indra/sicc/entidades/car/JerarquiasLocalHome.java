package es.indra.sicc.entidades.car;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.car.JerarquiasLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class JerarquiasLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-car");
	private EntityManager em = emf.createEntityManager();

	public JerarquiasLocal create(String cod_jera, Long num_dias, Float val_porc_mont_maxi, Float val_porc_line_cred) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CAR_JERA_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		JerarquiasLocal local = new JerarquiasLocal(oid, cod_jera, num_dias, val_porc_mont_maxi, val_porc_line_cred);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(JerarquiasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(JerarquiasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public JerarquiasLocal findByPrimaryKey(Long  oid) {
		JerarquiasLocal local = (JerarquiasLocal)em.find(JerarquiasLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}
        
        public Collection findAll() {
            Query query=em.createNamedQuery("JerarquiasLocal.FindAll");          
            return query.getResultList();
        }

	
}
