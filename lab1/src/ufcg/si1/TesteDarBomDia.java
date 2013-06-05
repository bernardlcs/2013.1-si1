package ufcg.si1;
import org.junit.*;

public class TesteDarBomDia {
	private DarBomDia pessoa;
	
	@Before
	public void criarConstrutor(){
		pessoa = new DarBomDia();
	}
	
	@Test
	public void testeMetodoXpto(){
		Assert.assertEquals("BOM DIA", pessoa.metodoXpto());
	}

}
