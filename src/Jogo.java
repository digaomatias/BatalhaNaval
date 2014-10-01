import java.util.ArrayList;

public class Jogo {
	
	public ArrayList<Jogador> jogadores;
	Jogador jogadorDaVez;
			
	public Jogo(Jogador jogador)
	{
		jogadores = new ArrayList<Jogador>(2);
		jogadores.add(jogador);
		jogadorDaVez = jogador;
		jogador.setJogoAtual(this);
	}
	
	public void addJogador(Jogador jogador)
	{
		if(!podeComecar())
		{
			jogadores.add(jogador);
			jogador.setJogoAtual(this);
		}
	}
	
	public boolean podeComecar()
	{
		return jogadores.size() == 2;
	}
	
	public void finalizarTurno()
	{
		if(jogadores.get(0).getId() == jogadorDaVez.getId())
			jogadorDaVez = jogadores.get(1);
		else
			jogadorDaVez = jogadores.get(0);
	}
	
	public boolean ehJogadorDaVez(int id)
	{
		return jogadorDaVez.getId() == id;
	}

	public Jogador getOpponent(Jogador jogador) {
		if(!podeComecar())
			return null;
		
		if(jogadores.get(0).getId() == jogador.getId())			
			return jogadores.get(1);
		else
			return jogadores.get(0);
	}
}
