package Tarefaslab03;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * 
 * @author bernardLenin
 *Classe Tarefa
 */

@ManagedBean (name="tarefa")
@ViewScoped
public class Tarefa implements Comparable<Tarefa> {
	private String nomeTarefa;

	private Date tarefaCriada,prazoFinal;
	
	/**
	 * Construtor da classe Tarefa
	 * @param nomeDaTarefa
	 * @param dia
	 * @param mes
	 * @param ano
	 * @param hora
	 * @param minutos
	 * @throws Exception
	 */
	public Tarefa(String nomeDaTarefa, int dia, int mes, int ano, int hora, int minutos) throws Exception {
		
		
		
		if(nomeDaTarefa.equals("")){
			throw new Exception("Entrada invalida para nome de tarefa");
		}
		else if(dia<1 || mes<1|| hora<0||minutos<0){
			throw new Exception("Entrada invalida , nao permitido numero menor que 1.");
		}
		
		else if(dia>31|| mes>12|| hora>24|| minutos>60){
			throw new Exception("Entrada invalida, nao pode ser estimado este prazo,data/hora invalido");
		}
		
		tarefaCriada = new Date();				
		prazoFinal = new Date(ano -1900, mes -1, dia, hora, minutos);		
		this.nomeTarefa = nomeDaTarefa;
		
		if(tarefaCriada.after(prazoFinal)){
			throw new Exception("Prazo invalido.");
		}
		
		
		
	}
	
	

	public Tarefa(String nomeDaTarefa) throws Exception {
		if(nomeDaTarefa.equals("")){
			throw new Exception("Entrada invalida para nome de tarefa");
		}
		
		tarefaCriada = new Date();
		
		this.nomeTarefa = nomeDaTarefa;
	}
	
	public String getNomeTarefa(){
		return this.nomeTarefa;
	}
	public void setNomeTarefa(String novoNomeTarefa) throws Exception{
		if(novoNomeTarefa.equals("")){
			throw new Exception("Entrada invalida para nome de tarefa");
		}
		this.nomeTarefa = novoNomeTarefa;
		
	}

	public String getPrazoData() throws ParseException {
		DateFormat f = DateFormat.getDateInstance(DateFormat.MEDIUM);
		return f.format(prazoFinal);
	}

	public String getTempoTarefaCriada() {
		//tempo da tarefa criada
		return String.format("%d:%d", tarefaCriada.getHours(),tarefaCriada.getMinutes()); 
	}
	public String getDataCriacaoTarefa(){
		//hora formtada do geito certo
		DateFormat f = DateFormat.getDateInstance(DateFormat.MEDIUM);
		return f.format(tarefaCriada);
	}
	
	public String getTempoPrazo(){
		return String.format("%d:%d", prazoFinal.getHours(),prazoFinal.getMinutes());
	}

	public void setPrazoData(int dia, int mes , int ano) throws Exception {
		 if(dia<1 || mes<1){
			throw new Exception("Entrada invalida , nao permitido numero menor que 1.");
		}
		
		else if(dia>31|| mes>12){
			throw new Exception("Entrada invalida, nao pode ser estimado este prazo,data/hora invalido");
		}
		 prazoFinal.setMonth(mes -1);
		 prazoFinal.setYear(ano -1900);
		 prazoFinal.setDate(dia);
		 
		 if(tarefaCriada.after(prazoFinal)){
				throw new Exception("Prazo invalido.");
			}
		
	}

	@Override
	public int compareTo(Tarefa outraTarefa) {
		if(this.prazoFinal.before(outraTarefa.prazoFinal)){
			return -1;
		}
		else if(this.prazoFinal.after(outraTarefa.prazoFinal)){
			return 1;
		}
		return 0;
	}

}
