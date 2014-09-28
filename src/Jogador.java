import java.util.ArrayList;
import java.util.Iterator;


public class Jogador {
	private static final int NUM_SUBMARINOS = 3;
	private static final int NUM_CRUZADORES = 2;
	private static final int NUM_ENCOURACADOS = 1;
	private static final int NUM_PORTAAVIOES = 1;
	
	
	private int id;
	private String nome;
	private Tabuleiro tabuleiro;
	private Jogo jogoAtual;
	private ArrayList<NavioEnum> naviosAPosicionar;
	private int tirosParaVencer;
	public int[][] mapaDosTiros;
	private static int identityId = 1;
	
	public Jogador(int id, String nome)
	{
		//TODO validar nome e id do jogador
		this.id = id;
		this.nome = nome;
		this.tabuleiro = new Tabuleiro(6, 6);
		
		naviosAPosicionar = new ArrayList<NavioEnum>();
		mapaDosTiros = new int[6][6];
		
		inicializa();
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
	
	public void setJogoAtual(Jogo jogoAtual)
	{
		this.jogoAtual = jogoAtual;
	}
	 
	public Jogo getJogoAtual()
	{
		return this.jogoAtual;
	}
	
	public boolean temNavio(NavioEnum navioTipo)
	{
		//Verifica se ainda tem o navio especificado disponível para posicionar.
		for(Iterator<NavioEnum> i = naviosAPosicionar.iterator(); i.hasNext();)
		{
			NavioEnum navio = i.next();
			if(navio == navioTipo)
				return true;
		}
		
		return false;
	}
	
	public void navioPosicionado(NavioEnum navioTipo)
	{
		naviosAPosicionar.remove(navioTipo);
	}
	
	public NavioEnum getMaiorNavio()
	{
		NavioEnum maiorNavio = null;
		for(Iterator<NavioEnum> i = naviosAPosicionar.iterator(); i.hasNext();)
		{
			NavioEnum navio = i.next();
			if(maiorNavio == null || navio.getVal() > maiorNavio.getVal())
				maiorNavio = navio;			
		}
		
		return maiorNavio;
	}
	
	public void marcarTiro(int x, int y, int val)
	{
		//-1 água, 0 nada, 1 barco.
		mapaDosTiros[x][y] = val;
	}
	
	public String verMeusTiros()
	{
		StringBuilder builder = new StringBuilder();
		
		for(int i=0; i < 6; i++) {
			for(int h=0; h < 6; h++)
			{
				char val = '?';
				if(mapaDosTiros[i][h] == 0)
					val = '.';
				else if(mapaDosTiros[i][h] == 1)
					val = '*';
				
				builder.append(val);
			}
			
			builder.append('\n');
		}
		
		return builder.toString();
	}
	
	public boolean jahDisparado(int x, int y)
	{
		if(x >= 6 || x < 0 || y >= 6 || y < 0)
			throw new IllegalArgumentException();
		
		return mapaDosTiros[x][y] != -1;
	}
	
	public boolean ehVencedor()
	{
		return tirosParaVencer == 0;
	}
	
	public static int GetNextId()
	{
		return identityId++;
	}	
	
	public static Jogador busca(ArrayList<Jogador> jogadores, String nome)
	{
		for(Iterator<Jogador> i = jogadores.iterator(); i.hasNext();)
		{
			Jogador jogador = i.next();
			if(jogador.getNome().equals(nome))
				return jogador;
		}
		
		return null;
	}
	
	public static Jogador busca(ArrayList<Jogador> jogadores, int id)
	{
		for(Iterator<Jogador> i = jogadores.iterator(); i.hasNext();)
		{
			Jogador jogador = i.next();
			if(jogador.getId() == id)
				return jogador;
		}
		
		return null;
	}
	
	private void inicializa()
	{		
		for(int i = 0; i < NUM_SUBMARINOS; i++)
			naviosAPosicionar.add(NavioEnum.Submarino);
		for(int i = 0; i < NUM_CRUZADORES; i++)
			naviosAPosicionar.add(NavioEnum.Cruzador);
		for(int i = 0; i < NUM_ENCOURACADOS; i++)
			naviosAPosicionar.add(NavioEnum.Encouracado);				
		for(int i = 0; i < NUM_PORTAAVIOES; i++)
			naviosAPosicionar.add(NavioEnum.PortaAvioes);	
		
		tirosParaVencer = NavioEnum.Submarino.getSize() * NUM_SUBMARINOS;
		tirosParaVencer += NavioEnum.Cruzador.getSize() * NUM_CRUZADORES;
		tirosParaVencer += NavioEnum.Encouracado.getSize() * NUM_ENCOURACADOS;
		tirosParaVencer += NavioEnum.PortaAvioes.getSize() * NUM_PORTAAVIOES;
		
		for(int i=0; i < 6; i++)
			for(int h=0; h < 6; h++)
				mapaDosTiros[i][h] = -1;
	}
}
