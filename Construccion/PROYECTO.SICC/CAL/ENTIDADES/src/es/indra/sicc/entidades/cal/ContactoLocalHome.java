package es.indra.sicc.entidades.cal;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cal.ContactoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;
import java.sql.Date;
import java.sql.Timestamp;

public class ContactoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cal");
	private EntityManager em = emf.createEntityManager();

	public ContactoLocal create(Long cod_cont, String cod_oper, Date fec_cont, Timestamp val_hora_inic, Long pais_oid_pais, Long clie_oid_clie, Long moco_oid, Long atec_oid) throws MareException {
		
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CAL_CONT_SEQ");final EntityTransaction et = em.getTransaction();
		et.begin();
		ContactoLocal local = new ContactoLocal(oid, cod_cont, cod_oper, fec_cont, val_hora_inic, pais_oid_pais, clie_oid_clie, moco_oid, atec_oid);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ContactoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ContactoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ContactoLocal findByPrimaryKey(Long  oid) {
		ContactoLocal local = (ContactoLocal)em.find(ContactoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}
       public Collection findAll() {
                Query query=em.createNamedQuery("ContactoLocal.FindAll");
                return query.getResultList();
       }

	
}
