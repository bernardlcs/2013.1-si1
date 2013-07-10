package Tarefaslab03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Sistema {
	private List<Tarefa> tarefaIncompletas,tarefasCompletas;
	
	public Sistema(){
		tarefasCompletas = new ArrayList<Tarefa>();
		tarefaIncompletas = new ArrayList<Tarefa>();
	}

	public void cadastrarNovaTarefa(Tarefa tarefa) {
		tarefaIncompletas.add(tarefa);
		
	}

	public String ordenarTarefaPorCricao() {
		String tarefasNaoCompletadas="";
		for(int i = tarefaIncompletas.size() -1;i>=0;i--){
			tarefasNaoCompletadas+=tarefaIncompletas.get(i).getNomeTarefa()+"\n";
		}
		return tarefasNaoCompletadas;
	}

	public String ordenarTarefaDataLimite() {
		Collections.sort(tarefaIncompletas);
		String tarefasNaoCompletadas="";
		for(int i = tarefaIncompletas.size() -1;i>=0;i--){
			tarefasNaoCompletadas+=tarefaIncompletas.get(i).getNomeTarefa()+"\n";
		}
		return tarefasNaoCompletadas;
		
	}

	public boolean marcarTarefa(String nomeDaTarefa) {
		for(Tarefa tarefas:tarefaIncompletas){
			if(tarefas.getNomeTarefa().equals(nomeDaTarefa)){
				tarefaIncompletas.remove(tarefas);
				tarefasCompletas.add(tarefas);
				return true;
			}
		}
		return false;
	}

	public boolean removerTarefa(String nomeDaTarefa) {
		for(Tarefa tarefas:tarefaIncompletas){
			if( tarefas.getNomeTarefa().equals(nomeDaTarefa)){
				tarefaIncompletas.remove(tarefas);
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) throws Exception {
		Tarefa tarefa1,tarefa2,tarefa3,tarefa4,tarefa5;
		
		Sistema sistema = new Sistema();
		tarefa1 =new Tarefa("lab01", 12, 8, 2013, 10,00);
		tarefa2 =new Tarefa("lab02", 13, 7, 2013, 18,00);
		tarefa3 =new Tarefa("lab03", 15, 7, 2013, 14,00);
		tarefa4 =new Tarefa("lab04", 12, 9, 2013, 22,00);
		tarefa5 =new Tarefa("lab05", 1, 8, 2013, 8,00);
		
		sistema.cadastrarNovaTarefa(tarefa1);
		sistema.cadastrarNovaTarefa(tarefa2);
		sistema.cadastrarNovaTarefa(tarefa3);
		sistema.cadastrarNovaTarefa(tarefa4);
		sistema.cadastrarNovaTarefa(tarefa5);
		
		System.out.println(sistema.ordenarTarefaDataLimite());
	}
}
