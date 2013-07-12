package Tarefaslab03;

import java.text.ParseException;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		final String saudacao="=========Bem vindo ao gerenciamento de tarefas.===========";
		final String menu="Escolha uma operacao abaixo.\n1-Criar nova tarefa.\n2-Visualizar tarefa incompletas.\n3-Visualizar tarefas Completas.\n4-Editar tarefas.\n5-Remover tarefas.\n6-Marcacao de tarefas.\n7-Sair.\n";
		final String subMenu1="1-Editar nome da tarefa.\n2-Editar data do prazo.\n3-Editar tempo do prazo";
		final String subMenu2="1-Ordenar por data de criaçao da tarefa.\n2-Ordenar por prazo da tarefa.";
		final String subMenu3="1-Criar tarefa sem prazo.\n2-Criar tarefa com prazo";
		final String submenu4="1-Remover tarefas completadas\n2-Remover tarefas incompletas";
		
		
		Scanner entradaSc = new Scanner(System.in);
		Tarefa tarefa;
		Sistema sistema = new Sistema();
		
		int escolha = 1;
		System.out.println(saudacao);
		while(!(escolha==7)){
			System.out.println(menu);
			escolha = entradaSc.nextInt();
			
			switch (escolha) {
			case 1:
				System.out.println(subMenu3);
				escolha = entradaSc.nextInt();
				switch (escolha) {
				case 1:
					System.out.println("Nome da tarefa:");
					String nomeDaTarefa = entradaSc.next();
					try{
						tarefa = new Tarefa(nomeDaTarefa);
						sistema.cadastrarNovaTarefa(tarefa); 
					}catch(Exception e){
						System.out.println(e.getMessage());
					}
					break;
				
				 case 2:
					System.out.println("Nome da tarefa:");
					String nomeDaTarefa2 = entradaSc.next();
					System.out.println("Dia:");
					int dia = entradaSc.nextInt();
					System.out.println("Mes");
					int mes = entradaSc.nextInt();
					System.out.println("Ano:");
					int ano = entradaSc.nextInt();
					System.out.println("Hora:");
					int hora = entradaSc.nextInt();
					System.out.println("minutos");
					int minuto = entradaSc.nextInt();
					
					try{
						tarefa = new Tarefa(nomeDaTarefa2, dia, mes, ano, hora, minuto);
						sistema.cadastrarNovaTarefa(tarefa);
					}catch(Exception e){
						System.out.println(e.getMessage());
					}
					break;
					

				default:
					break;
				} 
				
				break;
				
			case 2:
				System.out.println(subMenu2);
				escolha = entradaSc.nextInt();
				
				switch (escolha) {
				
				case 1:
					System.out.println(sistema.ordenarTarefaPorCricaoIncompletas());
					break;
				
				case 2:
					System.out.println(sistema.ordenarTarefaDataLimiteIncompletas());

				default:
					break;
				}
				break;
			
			case 3:
				System.out.println(subMenu2);
				escolha = entradaSc.nextInt();
				
				switch (escolha) {
				
				case 1:
					System.out.println(sistema.ordenarTarefaPorCricaoCompletas());
					break;
				
				case 2:
					System.out.println(sistema.ordenarTarefaDataLimiteCompletas());

				default:
					break;
				}
				break;
				
			case 4:
				System.out.println(subMenu1);
				escolha = entradaSc.nextInt();
				
				switch (escolha) {
				case 1:
					System.out.println("Nome da tarefa");
					String nome = entradaSc.next();
					System.out.println("Novo nome para a tarefa");
					String novoNome = entradaSc.next();
					 try{
						 sistema.setNomeTarefa(nome, novoNome);
					 }catch(Exception e){
						 System.out.println(e.getMessage());
					 }
					break;
					
				case 2:
					System.out.println("Nome da tarefa");
					String nome2 = entradaSc.next();
					System.out.println("Dia");
					int novoDia = entradaSc.nextInt();
					System.out.println("Mes");
					int novoMes = entradaSc.nextInt();
					System.out.println("Ano");
					int novoAno = entradaSc.nextInt();
					
					try{
						 sistema.setPrazoDataDaTarefa(nome2, novoDia, novoMes, novoAno);
					 }catch(Exception e){
						 System.out.println(e.getMessage());
					 }
					break;
				
				case 3:
					System.out.println("Nome da tarefa");
					String nome3 = entradaSc.next();
					System.out.println("Hora");
					int novaHora= entradaSc.nextInt();
					System.out.println("Minuto");
					int novominuto = entradaSc.nextInt();
					
					try{
						 sistema.setPrazoHoraTarefa(nome3, novaHora, novominuto);
					 }catch(Exception e){
						 System.out.println(e.getMessage());
					 }
					break;
					

				default:
					break;
				}
				break;
				
			
			case 5:
				escolha = entradaSc.nextInt();
				switch (escolha) {
				case 1:
					System.out.println("Digite o nome da tarefa que deseja remover.");
					String tarefaRemovida = entradaSc.next();
					
					sistema.removerTarefaCompleta(tarefaRemovida);
					
					if(sistema.removerTarefaCompleta(tarefaRemovida)==true){
						System.out.println("Tarefa removida com sucesso.");
					}else{
						System.out.println("Tarefa nao  esta na lista");
					}
					break;
				case 2:
					System.out.println("Digite o nome da tarefa que deseja remover.");
					String tarefaRemovida2 = entradaSc.next();
					
					sistema.removerTarefaIncompleta(tarefaRemovida2);
					
					if(sistema.removerTarefaIncompleta(tarefaRemovida2)==true){
						System.out.println("Tarefa removida com sucesso.");
					}else{
						System.out.println("Tarefa nao  esta na lista");
					}
					break;

				default:
					break;
				}
				
				break;
			
			case 6:
				System.out.println("Digite o nome da tarefa que deseja marcar.");
				String tarefaMarcada = entradaSc.next();
				sistema.marcarTarefa(tarefaMarcada);
				break;
			
			case 7:
				System.out.println("Sistema finalizado.");
				System.exit(0);
				break;
			
			default:
				break;
			}
			
			
		}

	}

}
