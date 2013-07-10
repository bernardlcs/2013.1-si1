package Tarefaslab03;

import java.text.ParseException;

import org.junit.*;

public class TesteTarefa {
	
	private Tarefa tarefa1,tarefa2,tarefa3;
	
	@Before
	public void criarConstrutor() throws Exception{
		tarefa1 = new Tarefa("laboratorio1");
		tarefa2 = new Tarefa("laboratorio2");
		tarefa3 = new Tarefa("laboratorio 3",07,11,2013,12,00);
		
	}
	
	@Test
	public void testarCosntrutor(){
		try{
			tarefa1 = new Tarefa("");
		}catch(Exception e){
			Assert.assertEquals("teste nome tarefa vazio","Entrada invalida para nome de tarefa",e.getMessage());
		}
		
		try{
			tarefa1 = new Tarefa(null);
		}catch(Exception e){
			Assert.assertEquals("teste nome tarefa para null",null,e.getMessage());
		}
		
		try{
			tarefa1 = new Tarefa("laboratorio 1",0,11,2013,12,00);
		}catch(Exception e){
			Assert.assertEquals("teste nome tarefa para null","Entrada invalida , nao permitido numero menor que 1.",e.getMessage());
		}
		
		try{
			tarefa1 = new Tarefa("laboratorio 1",1,0,2013,12,00);
		}catch(Exception e){
			Assert.assertEquals("teste nome tarefa para null","Entrada invalida , nao permitido numero menor que 1.",e.getMessage());
		}
		
//		try{
//			tarefa1 = new Tarefa("laboratorio 1",1,7,2012,12,00);
//		}catch(Exception e){
//			Assert.assertEquals("teste nome tarefa para null","Entrada invalida, escolha o ano atual ou um proximo.",e.getMessage());
//		}
		
		try{
			tarefa1 = new Tarefa("laboratorio 1",1,11,2013,-1,00);
		}catch(Exception e){
			Assert.assertEquals("teste nome tarefa para null","Entrada invalida , nao permitido numero menor que 1.",e.getMessage());
		}
		
		try{
			tarefa1 = new Tarefa("laboratorio 1",1,11,2013,12,-2);
		}catch(Exception e){
			Assert.assertEquals("teste nome tarefa para null","Entrada invalida , nao permitido numero menor que 1.",e.getMessage());
		}
		
		try{
			tarefa1 = new Tarefa("laboratorio 1",41,11,2013,22,00);
		}catch(Exception e){
			Assert.assertEquals("teste nome tarefa para null","Entrada invalida, nao pode ser estimado este prazo,data/hora invalido",e.getMessage());
		}
		
		try{
			tarefa1 = new Tarefa("laboratorio 1",5,111,2013,22,00);
		}catch(Exception e){
			Assert.assertEquals("teste nome tarefa para null","Entrada invalida, nao pode ser estimado este prazo,data/hora invalido",e.getMessage());
		}
		
		try{
			tarefa1 = new Tarefa("laboratorio 1",5,11,2013,28,00);
		}catch(Exception e){
			Assert.assertEquals("teste nome tarefa para null","Entrada invalida, nao pode ser estimado este prazo,data/hora invalido",e.getMessage());
		}
		
		try{
			tarefa1 = new Tarefa("laboratorio 1",5,11,2013,22,78);
		}catch(Exception e){
			Assert.assertEquals("teste nome tarefa para null","Entrada invalida, nao pode ser estimado este prazo,data/hora invalido",e.getMessage());
		}
		
		try{
			tarefa1 = new Tarefa("laboratorio 1",5,7,2013,22,00);
		}catch(Exception e){
			Assert.assertEquals("teste nome tarefa para null","Prazo invalido.",e.getMessage());
		}
		
		
	}
	
	@Test
	public void testarPrazos() throws ParseException{
		
		Assert.assertEquals("teste de prazo data","07/11/2013",tarefa3.getPrazoData());
		Assert.assertEquals("teste prazo hora","12:0",tarefa3.getTempoPrazo());
		
		
		try{
			tarefa3.setPrazoData(-1,9,2013);
		}catch(Exception e){
			Assert.assertEquals("teste set prazo","Entrada invalida , nao permitido numero menor que 1.",e.getMessage());
		}
		
		try{
			tarefa3.setPrazoData(0,9,2013);
		}catch(Exception e){
			Assert.assertEquals("teste set prazo","Entrada invalida , nao permitido numero menor que 1.",e.getMessage());
		}
		
		try{
			tarefa3.setPrazoData(34,9,2013);
		}catch(Exception e){
			Assert.assertEquals("teste set prazo","Entrada invalida, nao pode ser estimado este prazo,data/hora invalido",e.getMessage());
		}
		
		try{
			tarefa3.setPrazoData(7,13,2013);
		}catch(Exception e){
			Assert.assertEquals("teste set prazo","Entrada invalida, nao pode ser estimado este prazo,data/hora invalido",e.getMessage());
		}
		
		
		try{
			tarefa3.setPrazoData(7,3,2013);
		}catch(Exception e){
			Assert.assertEquals("teste set prazo","Prazo invalido.",e.getMessage());
		}
		
		
		
	}
	
	

}
