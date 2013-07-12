package Tarefaslab03;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe Sistema
 * @author bernardLenin
 *
 */
public class Sistema implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private List<Tarefa> tarefaIncompletas,tarefasCompletas;
	
	/**
	 * construtor da classe Sistema
	 */
	public Sistema(){
		tarefasCompletas = new ArrayList<Tarefa>();
		tarefaIncompletas = new ArrayList<Tarefa>();
	}

	/**
	 * metodo cadastrarNovaTarefa
	 * @param tarefa
	 */
	public void cadastrarNovaTarefa(Tarefa tarefa) {
		tarefaIncompletas.add(tarefa);
		
	}

	/**
	 * metodo ordenarTarefaPorCricaoIncompletas
	 * @return string  tarefasNaoCompletadas
	 */
	public String ordenarTarefaPorCricaoIncompletas() {
		if(tarefaIncompletas.size()==0){
			System.out.println("Nao ha tarefas cadastradas");
		}
		String tarefasNaoCompletadas="";
		for(int i = tarefaIncompletas.size() -1;i>=0;i--){
			tarefasNaoCompletadas+=tarefaIncompletas.get(i).getNomeTarefa()+"\n";
		}
		return tarefasNaoCompletadas;
	}
	
	/**
	 * metodo ordenarTarefaPorCricaoCompletas
	 * @return string tarefasCompletadas
	 */
	public String ordenarTarefaPorCricaoCompletas() {
		if(tarefasCompletas.size()==0){
			System.out.println("Nao ha tarefas completadas");
		}
		String tarefasCompletadas="";
		for(int i = tarefasCompletas.size() -1;i>=0;i--){
			tarefasCompletadas+=tarefasCompletas.get(i).getNomeTarefa()+"\n";
		}
		return tarefasCompletadas;
	}

	/**
	 * metodo ordenarTarefaDataLimiteIncompletas
	 * @return string tarefasNaoCompletadas
	 * @throws ParseException 
	 */
	public String ordenarTarefaDataLimiteIncompletas() throws ParseException {
		if(tarefaIncompletas.size()==0){
			System.out.println("Nao ha tarefas cadastradas");
		}
		Collections.sort(tarefaIncompletas);
		String tarefasNaoCompletadas="";
		for(int i = tarefaIncompletas.size() -1;i>=0;i--){
			if(!(tarefaIncompletas.get(i).getPrazoData()==null)){
				
			}
			tarefasNaoCompletadas+=tarefaIncompletas.get(i).getNomeTarefa()+"\n";
		}
		return tarefasNaoCompletadas;
		
	}
	
	/**
	 * metodo ordenarTarefaDataLimiteCompletas
	 * @return string tarefasCompletadas
	 */
	public String ordenarTarefaDataLimiteCompletas() {
		if(tarefasCompletas.size()==0){
			System.out.println("Nao ha tarefas completadas");
		}
		Collections.sort(tarefasCompletas);
		String tarefasCompletadas="";
		for(int i = tarefasCompletas.size() -1;i>=0;i--){
			tarefasCompletadas+=tarefasCompletas.get(i).getNomeTarefa()+"\n";
		}
		return tarefasCompletadas;
		
	}

	/**
	 * metodo marcarTarefa
	 * @param nomeDaTarefa
	 * @return boolean
	 */
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

	/**
	 * metodo removerTarefaIncompleta
	 * @param nomeDaTarefa
	 * @return boolean
	 */
	public boolean removerTarefaIncompleta(String nomeDaTarefa) {
		for(Tarefa tarefas:tarefaIncompletas){
			if( tarefas.getNomeTarefa().equals(nomeDaTarefa)){
				tarefaIncompletas.remove(tarefas);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * metodo removerTarefaCompleta
	 * @param nomeDaTarefa
	 * @return boolean
	 */
	public boolean removerTarefaCompleta(String nomeDaTarefa) {
		for(Tarefa tarefas:tarefasCompletas){
			if( tarefas.getNomeTarefa().equals(nomeDaTarefa)){
				tarefasCompletas.remove(tarefas);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * metodo getTarefaIncompletas
	 * @return List
	 */
	public List<Tarefa> getTarefaIncompletas() {
		return tarefaIncompletas;
	}

	/**
	 * metodo getTarefasCompletas
	 * @return List
	 */
	public List<Tarefa> getTarefasCompletas() {
		return tarefasCompletas;
	}
	
	/**
	 * metodo setPrazoDataDaTarefa
	 * @param nomeTarefa
	 * @param dia
	 * @param mes
	 * @param ano
	 * @throws Exception
	 */
	public void setPrazoDataDaTarefa(String nomeTarefa,int dia,int mes,int ano) throws Exception{
		boolean procura = false;
		for (Tarefa tarefas:tarefaIncompletas){
			if(tarefas.getNomeTarefa().equals(nomeTarefa)){
				tarefas.setPrazoData(dia, mes, ano);
				procura = true;
				
			}
		}
		if(procura==false){
			throw new Exception("Tarefa nao econtrada");
		}
		
	}
	
	/**
	 * metodo setNomeTarefa
	 * @param nomeTarefa
	 * @param novoNomeTarefa
	 * @throws Exception
	 */
	public void setNomeTarefa(String nomeTarefa,String novoNomeTarefa) throws Exception{
		boolean procura = false;
		for (Tarefa tarefas:tarefaIncompletas){
			if(tarefas.getNomeTarefa().equals(nomeTarefa)){
				tarefas.setNomeTarefa(novoNomeTarefa);
				procura = true;
				
			}
		}
		if(procura==false){
			throw new Exception("Tarefa nao econtrada");
		}
	}
	
	/**
	 * metodo setPrazoHoraTarefa
	 * @param nomeTarefa
	 * @param hora
	 * @param minuto
	 * @throws Exception
	 */
	public void setPrazoHoraTarefa(String nomeTarefa,int hora,int minuto) throws Exception{
		boolean procura = false;
		for (Tarefa tarefas:tarefaIncompletas){
			if(tarefas.getNomeTarefa().equals(nomeTarefa)){
				tarefas.setTempoPrazo(hora, minuto);
				procura = true;
				
			}
		}
		if(procura==false){
			throw new Exception("Tarefa nao econtrada");
		}
	}
	
}
