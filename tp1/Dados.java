package tp1;

//Classe com os dados referentes aos clientes
public class Dados {
    
	   private String nome;
	   private String telefone;
	   private String endereco;
	    
	   public Dados(){
	   
	   }
	   
	   public String Nome(){
		   return nome;
	   }
	   
	   public void nomeCliente(String cliente){
		   nome = cliente;
	   }
	   
	   public String Telefone(){
		   return telefone;
	   }
	   
	   public void telCliente(String tel ){
		   telefone = tel;
	   }
	   
	   public String Endereco(){	   
		   return endereco;
	   }
	   
	   public void endCliente(String end){
	   		   endereco = end;
	   }
	   
	}