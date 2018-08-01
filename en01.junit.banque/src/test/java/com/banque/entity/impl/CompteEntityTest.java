package com.banque.entity.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.banque.entity.ICompteEntity;
import com.banque.entity.IOperationEntity;
import com.banque.entity.IUtilisateurEntity;







public class CompteEntityTest {

	private static final Logger LOG = LogManager.getLogger();

	// Tests sur constructeur
	// -setLibelle
	// -equals
	private ICompteEntity compte;

	@Before
	public void init() {
		CompteEntityTest.LOG.debug("on init()");
		compte = new CompteEntity(1, "libelle", 20.3, 10.0, 0.2);
		// Assert.assertNotNull("le vcompte ne doit pas etre null", compte);

	}


	@Test
	public void testCompteEntityConstructorNoInitialized() {

		CompteEntity c = new CompteEntity();


		Assert.assertNotNull(c);

		Assert.assertEquals("id doit etre 0", (Integer) 0, c.getId());
		Assert.assertEquals("libelle doit etre null", null, c.getLibelle());
		Assert.assertEquals("solde doit etre 0.0", 0.0, c.getSolde(), 0.001);
		Assert.assertEquals("decouvert doit etre 0.0", 0.0, c.getDecouvert(), 0.001);
		Assert.assertEquals("taux doit etre 0.0", 0.0, c.getTaux(), 0.001);

	}


	@Test
	public void testCompteEntityConstructorInitializedBySet() {

		ICompteEntity c = new CompteEntity();

		c.setId(3);
		c.setLibelle("hola");
		c.setSolde(23.8);
		c.setDecouvert(78.9);
		c.setTaux(0.8);

		Assert.assertEquals("id doit ertre egal a 3",(Integer) 3, c.getId());
		Assert.assertEquals("libelle doit etre egal a hola", "hola", c.getLibelle());
		Assert.assertEquals("solde doit etre egal a 23.8", 23.8, c.getSolde(), 0.0001);
		Assert.assertEquals("decouvert doit etre egal a 78.9",Double.valueOf(78.9), c.getDecouvert(), 0.001);
		Assert.assertEquals("taux doit etre egal a 0.8",0.8, c.getTaux(), 0.001);

		//		Assert.assertEquals((Integer) 1, c.getId());
		//		Assert.assertEquals("libelle", c.getLibelle());
		//		Assert.assertEquals((Double) 20.3, c.getSolde());
		//		Assert.assertEquals((Double) 10.0, c.getDecouvert());
		//		Assert.assertEquals((Double) 0.2, c.getTaux());
	}

	@Test
	public void testCompteEntityConstructor() {

		Assert.assertEquals("id doit etre egal a1", (Integer) 1, compte.getId());
		Assert.assertEquals("libelle doit etre egal a libelle", "libelle", compte.getLibelle());
		Assert.assertEquals("solde doit etre egal a 20.3", 20.3, compte.getSolde(), 0.001);
		Assert.assertEquals("decouvert doit etre egal a 10.0", 10.0, compte.getDecouvert(), 0.001);
		Assert.assertEquals("taux doit etre egal a 0.2", 0.2, compte.getTaux(), 0.001);
	}

	@Test
	public void testCompteEntityLibelle() {
		this.compte.setLibelle("Compte Courant");
		Assert.assertEquals("Compte Courant", compte.getLibelle());
	}

	@Test
	public void testCompteEntityLibelleNull() {
		this.compte.setLibelle(null);
		Assert.assertNull(compte.getLibelle());
	}

	@Test
	public void testCompteEntityLibelleVoidString() {
		ICompteEntity c = new CompteEntity(1, "libelle", 20.3, 10.0, 0.2);
		c.setLibelle(" ");

		Assert.assertFalse(this.compte.equals(c));
	}

	@Test
	public void testCompteEntityEqualsNull() {
		ICompteEntity c = null;
		Assert.assertFalse(this.compte.equals(c));
	}

	@Test
	public void testCompteEntityEqualsOperation() {
		IOperationEntity o = new OperationEntity();

		Assert.assertFalse(this.compte.equals(o));
	}

	@Test
	public void testCompteEntityEqualsUtilisateur() {
		IUtilisateurEntity e = new UtilisateurEntity();

		Assert.assertFalse(this.compte.equals(e));
	}

	@Test
	public void testCompteEntityEqualsInitializedByCompte() {
		ICompteEntity c = null;
		c = this.compte;
		Assert.assertTrue(this.compte.equals(c));
	}

	@Test
	public void testCompteEntityEqualsInitializedInitial() {
		ICompteEntity c = null;
		c = new CompteEntity(1, "libelle", 20.3, 10.0, 0.2);

		Assert.assertTrue(this.compte.equals(c));
	}

	@Test
	public void testCompteEntityEqualsLibelleVoidString() {
		ICompteEntity c = null;
		c = new CompteEntity(1, "", 20.3, 10.0, 0.2);

		Assert.assertTrue(this.compte.equals(c));
	}

	@Test
	public void testCompteEntityEqualsValuesDifferentFromInitial() {
		ICompteEntity c = null;
		c = new CompteEntity(1, "libelle", 20.3, 10.0, 0.2);

		CompteEntityTest.LOG.debug("compte verif= {}", this.compte.equals(c));
		Assert.assertTrue(this.compte.equals(c));

		c.setId(3);
		Assert.assertFalse(this.compte.equals(c));
		c = new CompteEntity(1, "libelle", 20.3, 10.0, 0.2);
		c.setLibelle("Compte courant");

		CompteEntityTest.LOG.debug("compte libelle= {}", c.getLibelle());
		CompteEntityTest.LOG.debug("compte libelle boolean= {}", this.compte.equals(c));
		Assert.assertFalse(this.compte.equals(c));

		c = new CompteEntity(1, "libelle", 20.3, 10.0, 0.2);
		c.setSolde(26.4);
		Assert.assertFalse(this.compte.equals(c));
		c = new CompteEntity(1, "libelle", 20.3, 10.0, 0.2);
		c.setDecouvert(45.0);
		Assert.assertFalse(this.compte.equals(c));
		c = new CompteEntity(1, "libelle", 20.3, 10.0, 0.2);
		c.setTaux(0.8);
		Assert.assertFalse(this.compte.equals(c));

	}

	@Test
	public void testCompteEntitygetClass() {

		// Assert.assertEquals("class com.banque.entity.impl.CompteEntity",
		// this.compte.getClass());

	}


}
