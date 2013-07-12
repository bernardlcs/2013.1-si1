package Tarefaslab03;

import javax.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import java.util.*;

/**
 * Classe ControllerTarefa
 * @author bernardLenin
 *
 */

@ManagedBean
@ViewScoped
public class ControllerTarefa {
	
	private Tarefa tarefa;
	private Sistema sistema;
	private DataModel listaT;
	
	public DataModel getListarTarefaIncompleta(){
		List<Tarefa> listaTarefa = new Sistema().getTarefaIncompletas();
		listaT = new ListDataModel(listaTarefa);
		return listaT;
	}
	public Tarefa getTarefa(){
		return tarefa;
	}
	
	public void setTarefa(Tarefa novaTarefa){
		this.tarefa = novaTarefa;
	}
	
	public String prepararAdicionarTarefa(){
		tarefa = new Tarefa();
		return "gerenciarTarefa";
	}
	
	public String excluirTarefa(){
		return "index";
	}
	
	public String prepararAlterarTarefa(){
		return "gerenciarTarefa";
	}
	
	public String adicionarTarefa(){
		return "index";
	}
	
	public String alterarTarefa(){
		return "index";
	}
	

}
