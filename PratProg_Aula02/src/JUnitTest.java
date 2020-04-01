

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JUnitTest {

	Pais principal, copia, menorArea;
	static int id = 5;
	
	@Before
	public void setup() {
		System.out.println("Setup");
		principal = new Pais (id, "Italia", 60390560, 301338.0);
		copia = new Pais (id, "Italia", 60390560, 301338.0);
	}
	
	@Test
	public void test1Read() {
		System.out.println("Carregar teste");
		Pais fixture = new Pais (1 , "Uganda", 40006700, 241038.0);
		Pais novo = new Pais ();
		novo.setId(1);
		
		novo.read();

		assertEquals(fixture, novo);
	}
	
	@Test
	public void test2Create() {
		System.out.println("Criar teste");
		principal.create();
		
		assertEquals(principal, copia);
		
		
	}
	
	@Test
	public void test3Update() {
		System.out.println("Atualizar teste");
		principal.setPopulacao(666);
		principal.update();
		
		copia.read();
		
		assertEquals(principal, copia);
	}
	
	@Test
	public void test4Delete() {
		System.out.println("Apagar teste");
		
		principal.delete();
		principal.read();
		Pais vazio = new Pais(); 
		
		assertEquals(principal, vazio);
		
		
	}
	
	@Test
	public void test5MenorArea() {
		System.out.println("Menor area teste");
		principal.setArea(1.0);
		copia.setArea(1.0);
		
		principal.create();
		
		copia.menorArea();
		
		assertEquals(principal, copia);
		
		PaisDAO.delete(id);
	}
	
	@Test
	public void test6MaiorPopulacao() {
		System.out.println("Maior Populacao teste");
		principal.setPopulacao(999999999);
		copia.setPopulacao(999999999);
		
		principal.create();
		
		copia.maiorPopulacao();
		
		assertEquals(principal, copia);
		
		PaisDAO.delete(id);
		
	}
	
	@Test
	public void test7TresPaises() {
		
		Pais vetor[] = PaisService.tresPaises();
		Pais pais[] = {new Pais(1, "Uganda", 40006700, 241038.0), new Pais(2, "Brasil", 210147125, 8515767.0), new Pais(3, "Canada", 37373000, 9984670.0)};
		assertArrayEquals(pais, vetor);
	}
	
}
