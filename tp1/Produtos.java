package tp1;

//Classe com os dados referentes aos produtos
public class Produtos {

	 private String produto;
	 private String descricao;
	 private double valor;
	 private double lucro;
	 private double estoque;
	   
	 public Produtos() {
		 
	 }
	 public String Produto() {		   
		   return produto;
	   }
	   
	   public void nomeProd(String prod) {
		   produto = prod;
	   }
	   
	   public String Descricao() {		   
		   return descricao;
	   }
	   
	   public void prodDescricao(String descr) {
		   descricao = descr;
	   }
	   
	   public double Valor() {		   
		   return valor;
	   }
	   
	   public void prodValor(Double valorProduto) {
		   valor = valorProduto;
	   }
	   
	   public double Lucro() {		   
		   return lucro;
	   }
	   
	   public void vendaLucro(Double prodLucro) {
		   lucro = prodLucro;
	   }
	   
	   public double Estoque() {		   
		   return estoque;
	   }
	   
	   public void produtoEstoque(Double prodEstoque) {
		   estoque =  prodEstoque;
	   }
	   
}
