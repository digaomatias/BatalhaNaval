import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;

public class BatalhaNaval extends UnicastRemoteObject implements BatalhaNavalInterface {
	
	private static final int MAX_JOGADORES = 100;
	private static final int MAX_PARTIDAS = 50;
	private ArrayList<Jogador> jogadores;
	private ArrayList<Jogo> jogos;
		
	/**
	 * 
	 */
	private static final long serialVersionUID = -488221494018748658L;

	protected BatalhaNaval() throws RemoteException {
		super();
		
		this.jogadores = new ArrayList<Jogador>(MAX_JOGADORES);
		this.jogos = new ArrayList<Jogo>(MAX_PARTIDAS);
	}

	@Override
	public int registraUsuario(String nome) throws RemoteException {
		if(jogadores.size() == MAX_JOGADORES)
			return RegistraUsuarioResult.MaxAtingido.getVal();
		if(Jogador.busca(jogadores, nome) != null)
			return RegistraUsuarioResult.JahCadastrado.getVal();
		
		int jogadorId = Jogador.GetNextId();
		Jogador novoJogador = new Jogador(jogadorId, nome);
		jogadores.add(novoJogador);
		
		//variavel pra saber se o jogador foi adicionado a um jogo existente, ou se precisa criar um novo jogo.
		boolean adicionado = false;
		for(Iterator<Jogo> i = jogos.iterator(); i.hasNext();)
		{
			Jogo jogo = i.next();
			if(!jogo.podeComecar())
			{
				jogo.addJogador(novoJogador);
				adicionado = true;
				break;
			}
		}
		
		if(!adicionado)
			jogos.add(new Jogo(novoJogador));
		
		return jogadorId;
	}

	@Override
	public String nomeOponente(int idUsuario) throws RemoteException {		
			Jogador j = Jogador.busca(jogadores, idUsuario);
			if(j == null)
				return "";
			
			Jogador oponente = j.getJogoAtual().getOpponent(j);
			return oponente != null ? oponente.getNome() : "Ainda não possui oponentes.";
	}

	@Override
	public int posicionaNavio(int idUsuario, String coord, int alin, int tipoNavio) throws RemoteException {
		Jogador jogador = Jogador.busca(jogadores, idUsuario);
		if(jogador == null)
			return PosicionaNavioResult.UsuarioNaoEncontrado.getVal();
		
		OrientacaoEnum orientacao = OrientacaoEnum.fromInt(alin);
		if(orientacao == null)
			return PosicionaNavioResult.OrientacaoInvalida.getVal();
		
		NavioEnum navio = NavioEnum.fromInt(tipoNavio); 
		if(navio == null)
			return PosicionaNavioResult.TipoNavioInvalido.getVal();
		
		if(!jogador.temNavio(navio))
			return PosicionaNavioResult.TipoNavioJahPosicionado.getVal();		
		
		
		if(!jogador.getTabuleiro().posicionaNavio(coord, navio, OrientacaoEnum.fromInt(alin)))
			return PosicionaNavioResult.PosicionamentoInvalido.getVal();
		
		jogador.navioPosicionado(navio);
		return PosicionaNavioResult.Sucesso.getVal();
	}

	@Override
	public int posicionamentoPronto(int idUsuario) throws RemoteException {
		Jogador jogador = Jogador.busca(jogadores, idUsuario);
		if(jogador == null)
			return PosicionamentoProntoResult.UsuarioNaoEncontrado.getVal();
		
		NavioEnum maiorNavio = jogador.getMaiorNavio();
		if(maiorNavio != null)
			return maiorNavio.getVal();
		
		return PosicionamentoProntoResult.Pronto.getVal();
	}

	@Override
	public int ehMinhaVez(int idUsuario) throws RemoteException {
		Jogador jogador = Jogador.busca(jogadores, idUsuario);
		if(jogador == null)
			return EhMinhaVezResult.Erro.getVal();
		Jogo jogo = jogador.getJogoAtual();
		Jogador oponente = jogo.getOpponent(jogador);
		if(oponente == null)
			return EhMinhaVezResult.Erro.getVal();
		
		if(jogador.ehVencedor())
			return EhMinhaVezResult.Vencedor.getVal();				
		
		if(oponente.ehVencedor())
			return EhMinhaVezResult.Perdedor.getVal();
		
		if(jogo.ehJogadorDaVez(jogador.getId()))
			return EhMinhaVezResult.Sim.getVal();
		else
			return EhMinhaVezResult.Nao.getVal();
	}

	@Override
	public String obtemTabuleiro(int idUsuario) throws RemoteException {
		Jogador j = Jogador.busca(jogadores, idUsuario);
		if(j == null)
			return "";
		
		Tabuleiro tabuleiro = j.getTabuleiro();
		return tabuleiro != null ? tabuleiro.toString() : "Esse jogador não possui tabuleiro.";
	}

	@Override
	public String obtemLancamentos(int idUsuario) throws RemoteException {
		Jogador jogador = Jogador.busca(jogadores, idUsuario);
		if(jogador == null)
			return "Jogador não encontrado.";
		
		return jogador.verMeusTiros();
	}

	@Override
	public int executaTiro(int idUsuario, String coord) throws RemoteException {		
		Jogador jogador = Jogador.busca(jogadores, idUsuario);
		if(jogador == null)
			ExecutaTiroResult.JogadorInvalido.getVal();
		
		TabuleiroCoord tabuleiroCoord = null;
		try
		{
			tabuleiroCoord = TabuleiroCoord.fromString(coord);		
		}
		catch(IllegalArgumentException e)
		{
			return ExecutaTiroResult.CoordenadaInvalida.getVal();
		}		
		
		int x = tabuleiroCoord.getX();
		int y = tabuleiroCoord.getY();
		if(jogador.jahDisparado(x, y))
			return ExecutaTiroResult.TiroJahDisparado.getVal();
		
		int result = jogador.getTabuleiro().getPosicao(tabuleiroCoord);
		
		switch(result)
		{
			case -1:				
				return ExecutaTiroResult.CoordenadaInvalida.getVal();
			case 0:
				jogador.marcarTiro(x, y, 0);
				return ExecutaTiroResult.TiroNaAgua.getVal();
			default:
				jogador.marcarTiro(x, y, 1);
				return ExecutaTiroResult.TiroCerteiro.getVal();	
		}
	}

}
