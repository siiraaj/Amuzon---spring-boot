package fr.amu;
import static org.assertj.core.api.Assertions.assertThat; // Notez l'import en static !! Plus simple

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import fr.amu.controllers.IndexController;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= WebEnvironment.RANDOM_PORT)
public class IndexControllerTests {
	
	@LocalServerPort // prend le port choisi au hasard
	private int port;

	//injecter l'index controller
	@Autowired
	private IndexController controller;
	
	@Autowired
	private TestRestTemplate restTemplate; //permet de faire une requête simple, un accès à une url
	
	@Test
	public void contexLoads() throws Exception {
	assertThat(controller).isNotNull(); // on vérifie que le controller est bien lancé
//	assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
//			String.class)).contains("homepage"); // cette approche est limitée et n'est pas.
	}
}
