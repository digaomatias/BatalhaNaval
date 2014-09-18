
public class Jogador {

	private int id;
	private String nome;
	private Tabuleiro tabuleiro;
	
	public Jogador(int id, String nome)
	{
		//TODO validar nome e id do jogador
		
		this.id = id;
		this.nome = nome;
		this.tabuleiro = new Tabuleiro(6, 6);
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public Tabuleiro getTabuleiro(){
		return tabuleiro;
	}
}
