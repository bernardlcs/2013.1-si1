package Tarefaslab03;

import org.junit.*;
public class TesteSistema {
	private Sistema sistema;
	private Tarefa tarefa1,tarefa2,tarefa3,tarefa4,tarefa5;
	
	@Before
	public void criarConstrutor() throws Exception{
		sistema = new Sistema();
		tarefa1 =new Tarefa("lab01", 12, 8, 2013, 10,00);
		tarefa2 =new Tarefa("lab02", 13, 7, 2013, 18,00);
		tarefa3 =new Tarefa("lab03", 15, 7, 2013, 14,00);
		tarefa4 =new Tarefa("lab04", 12, 9, 2013, 22,00);
		tarefa5 =new Tarefa("lab05", 1, 8, 2013, 8,00);
	}
	
	
	@Test	
	public void testarCadastarSistema(){
		sistema.cadastrarNovaTarefa(tarefa1);
		sistema.cadastrarNovaTarefa(tarefa2);
		sistema.cadastrarNovaTarefa(tarefa3);
		sistema.cadastrarNovaTarefa(tarefa4);
		sistema.cadastrarNovaTarefa(tarefa5);
		
		
	}	
	
	@Test
	public void testarOrdenacaoTarefaPorCriacao(){
		sistema.cadastrarNovaTarefa(tarefa1);
		sistema.cadastrarNovaTarefa(tarefa2);
		sistema.cadastrarNovaTarefa(tarefa3);
		sistema.cadastrarNovaTarefa(tarefa4);
		sistema.cadastrarNovaTarefa(tarefa5);
		
		Assert.assertEquals("teste de ordenaçao por criacao de tarefa","lab05\nlab04\nlab03\nlab02\nlab01\n",sistema.ordenarTarefaPorCricao());
		
	}
	
	@Test 
	public void testarOrdenaçaoPorData(){
		sistema.cadastrarNovaTarefa(tarefa1);
		sistema.cadastrarNovaTarefa(tarefa2);
		sistema.cadastrarNovaTarefa(tarefa3);
		sistema.cadastrarNovaTarefa(tarefa4);
		sistema.cadastrarNovaTarefa(tarefa5);
		
		Assert.assertEquals("teste de ordanaçao por data limite","lab04\nlab01\nlab05\nlab03\nlab02\n", sistema.ordenarTarefaDataLimite());
	}
	
	@Test
	public void testarMarcacaoTarefa(){
		sistema.cadastrarNovaTarefa(tarefa1);
		sistema.cadastrarNovaTarefa(tarefa2);
		sistema.cadastrarNovaTarefa(tarefa3);
		sistema.cadastrarNovaTarefa(tarefa4);
		sistema.cadastrarNovaTarefa(tarefa5);
		Assert.assertTrue("teste de marcar tarefa",sistema.marcarTarefa("lab05"));
		Assert.assertFalse("teste de marcar tarefa",sistema.marcarTarefa("lab05"));
		
		Assert.assertTrue("teste de marcar tarefa",sistema.marcarTarefa("lab01"));
		
	}
	
	@Test
	public void testarEdicaoTarefa(){
		
	}
	
	@Test
	public void testarRemoverTarefa(){
		sistema.cadastrarNovaTarefa(tarefa1);
		sistema.cadastrarNovaTarefa(tarefa2);
		sistema.cadastrarNovaTarefa(tarefa3);
		sistema.cadastrarNovaTarefa(tarefa4);
		sistema.cadastrarNovaTarefa(tarefa5);
		Assert.assertTrue("teste de remoçao de tarefa", sistema.removerTarefa("lab05"));
		Assert.assertFalse("teste de remover tarefa ja removida",sistema.removerTarefa("lab05"));
		Assert.assertTrue("teste remocao de tarefa",sistema.removerTarefa("lab04"));
		
	}
	

}
