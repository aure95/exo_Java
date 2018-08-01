package com.banque.dao.impl;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import com.banque.dao.ICompteDAO;
import com.banque.dao.ex.ExceptionDao;
import com.banque.entity.ICompteEntity;
import com.banque.entity.impl.CompteEntity;



public class CompteDAOTest {

	private final static Logger LOG = LogManager.getLogger();
	@Test
	public void testSelectOk() throws ExceptionDao {
		ICompteDAO dao = new CompteDAO();
		ICompteEntity entite = dao.select(13);

		Assert.assertNotEquals("l'entite ne doit pas etre null", null, entite.getId().intValue());
		Assert.assertEquals("L'entite doit avoir l'id 13", 13, entite.getId().intValue());

	}

	@Test
	public void testSelectKo() throws ExceptionDao {
		ICompteDAO dao = new CompteDAO();
		ICompteEntity entite = dao.select(13000);

		Assert.assertNull("l'entite doit etre null", entite);

	}

	@Test
	public void testUpdateKo() throws ExceptionDao {
		ICompteDAO dao = new CompteDAO();
		ICompteEntity entite = dao.select(13);
		Assert.assertNotNull("l'entite doit etre null", entite);
		entite.setSolde(99999D);
		entite = dao.update(entite);
		Assert.assertNotNull("l'entite ne doit pas etre null", entite);
		Assert.assertEquals("l'entite doit avoir 99999 sur son solde", 99999D, entite.getSolde(), 0.01);

	}

	@Test
	public void testInsertOK() throws ExceptionDao {
		ICompteDAO dao = new CompteDAO();
		ICompteEntity entity = new CompteEntity(null, "testLibelle", 90D, 3.6, 0.4);
		entity.setUtilisateurId(2);
		entity.setTaux(0.2D);
		CompteDAOTest.LOG.debug("entity.getSolde()= {}", entity.getSolde());
		CompteDAOTest.LOG.debug("entity.getDecouvert()= {}", entity.getDecouvert());
		CompteDAOTest.LOG.debug("entity.getTaux()= {}", entity.getTaux());

		entity = dao.insert(entity);

		Assert.assertNotNull("le compte ne doit pas etre null", entity);

		entity = dao.select(22);
		Assert.assertNotNull("le compte ne doit pas etre null", entity);
		Assert.assertEquals(22, entity.getId().intValue());
		Assert.assertEquals("testLibelle", entity.getLibelle());
		Assert.assertEquals(90D, entity.getSolde().doubleValue(), 0.0001);
		Assert.assertEquals(3.6, entity.getDecouvert().doubleValue(), 0.001);

		CompteDAOTest.LOG.debug("entity.getSolde()= {}", entity.getSolde());
		CompteDAOTest.LOG.debug("entity.getDecouvert()= {}", entity.getDecouvert());
		CompteDAOTest.LOG.debug("entity.getTaux()= {}", entity.getTaux());

		Assert.assertEquals((Double) 0.2D, entity.getTaux());
		Assert.assertTrue(dao.delete(entity));

	}

	// le test est réussi si ExceptionDao.class est levée
	@Test(expected = ExceptionDao.class)
	public void testInsertKO2() throws ExceptionDao {
		ICompteDAO dao = new CompteDAO();
		ICompteEntity entity = new CompteEntity(null, "testLibelle", 90D, 3.6, 0.4);
		// cet id utilisateur n'existe pas
		entity.setUtilisateurId(1000000);

		entity = dao.insert(entity);

	}

}
