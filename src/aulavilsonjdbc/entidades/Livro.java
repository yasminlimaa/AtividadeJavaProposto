package aulavilsonjdbc.entidades;

public class Livro {
	private int id;
	private String nome;
	private String paginas;
	private String genero;
	
	public Livro() {
		
	}
	
	public Livro(String nome, String paginas, String genero) {
		super();
		this.nome = nome;
		this.paginas = paginas;
		this.genero = genero;
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
	public String getPaginas() {
		return paginas;
	}
	public void setPaginas(String paginas) {
		this.paginas = paginas;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
}
