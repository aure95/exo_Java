package com.banque.service.impl;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.banque.entity.IUtilisateurEntity;
import com.banque.service.IAuthentificationService;
import com.banque.service.ex.ErreurTechniqueException;
import com.banque.service.ex.FonctionnelleException;

public class AuthentificationServiceTest {

	private static IAuthentificationService service;

	@BeforeClass
	public static void init() {
		AuthentificationServiceTest.service = new AuthentificationService();

	}

	@Test
	public void testAuthentificationOk() throws FonctionnelleException, ErreurTechniqueException {

		final String login = "df";
		final String password = "df";

		IUtilisateurEntity entite = AuthentificationServiceTest.service.authentifier(login, password);
		Assert.assertNotNull(entite);
		Assert.assertEquals(login, entite.getLogin());

	}

	// login null,pwd pas null;
	@Test(expected = IllegalArgumentException.class)
	public void testAuthentifierKo1() throws FonctionnelleException, ErreurTechniqueException {
		String login = null;
		String password = "df";
		AuthentificationServiceTest.service.authentifier(login, password);
	}

	// login pas null,pwd null
	@Test(expected = IllegalArgumentException.class)
	public void testAuthentifierKo2() throws FonctionnelleException, ErreurTechniqueException {
		String login = "df";
		String password = null;
		AuthentificationServiceTest.service.authentifier(login, password);
	}
	// login null,pwd null
	@Test(expected = IllegalArgumentException.class)
	public void testAuthentifierKo3() throws FonctionnelleException, ErreurTechniqueException {
		String login = null;
		String password = null;
		AuthentificationServiceTest.service.authentifier(login, password);
	}
	// login="",pwd=pas ""
	@Test(expected = IllegalArgumentException.class)
	public void testAuthentifierKo4() throws FonctionnelleException, ErreurTechniqueException {
		String login = "";
		String password = "df";
		AuthentificationServiceTest.service.authentifier(login, password);
	}

	//// login=pas "",pwd=""
	@Test(expected = IllegalArgumentException.class)
	public void testAuthentifierKo5() throws FonctionnelleException, ErreurTechniqueException {
		String login = "df";
		String password = "";
		AuthentificationServiceTest.service.authentifier(login, password);
	}

	// login="",pwd=null
	@Test(expected = IllegalArgumentException.class)
	public void testAuthentifierKo6() throws FonctionnelleException, ErreurTechniqueException {
		String login = "";
		String password = null;
		AuthentificationServiceTest.service.authentifier(login, password);
	}
	// login=null,pwd=""
	@Test(expected = IllegalArgumentException.class)
	public void testAuthentifierKo7() throws FonctionnelleException, ErreurTechniqueException {
		String login = null;
		String password = "";
		AuthentificationServiceTest.service.authentifier(login, password);
	}
	// login=wrong login,pwd=wrong pwd
	@Test(expected = Exception.class)
	public void testAuthentifierKo8() throws FonctionnelleException, ErreurTechniqueException {
		String login = "gh";
		String password = "gh";
		AuthentificationServiceTest.service.authentifier(login, password);
	}
	// login=wrong login,pwd=good pwd
	@Test(expected = Exception.class)
	public void testAuthentifierKo9() throws FonctionnelleException, ErreurTechniqueException {
		String login = "df";
		String password = "gh";
		AuthentificationServiceTest.service.authentifier(login, password);
	}
	// login=good login,pwd=bad pwd
	@Test(expected = Exception.class)
	public void testAuthentifierKo10() throws FonctionnelleException, ErreurTechniqueException {
		String login = "gh";
		String password = "df";
		AuthentificationServiceTest.service.authentifier(login, password);
	}

}
