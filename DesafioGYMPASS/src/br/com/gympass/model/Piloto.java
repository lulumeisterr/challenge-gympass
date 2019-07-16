package br.com.gympass.model;

public class Piloto {

	private int id;
	private String nome;
	private String hora;
	private Integer numeroVoltas;
	private String tempoVolta;
	private Float velocidadeMedia;

	public Piloto() {

	}

	@Override
	public String toString() {
		return "Nome  : " + nome + " numero de voltas : " + numeroVoltas + " Tempo de volta : " + tempoVolta + " Velocidade media : " + velocidadeMedia + " horas : " + hora; 
	}

	public Piloto(int id, String nome, String hora, Integer numeroVoltas, String tempoVolta,
			Float velocidadeMedia) {
		super();
		this.id = id;
		this.nome = nome;
		this.hora = hora;
		this.numeroVoltas = numeroVoltas;
		this.tempoVolta = tempoVolta;
		this.velocidadeMedia = velocidadeMedia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String localTime) {
		this.hora = localTime;
	}

	public Integer getNumeroVoltas() {
		return numeroVoltas;
	}

	public void setNumeroVoltas(Integer numeroVoltas) {
		this.numeroVoltas = numeroVoltas;
	}

	public String getTempoVolta() {
		return tempoVolta;
	}

	public void setTempoVolta(String tempoVolta) {
		this.tempoVolta = tempoVolta;
	}

	public Float getVelocidadeMedia() {
		return velocidadeMedia;
	}

	public void setVelocidadeMedia(Float velocidadeMedia) {
		this.velocidadeMedia = velocidadeMedia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) { 
		if (obj == null)
			return false; 
		if (!(obj instanceof Piloto));
		return false;

	}
}