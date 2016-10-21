
public class Libro {

	//VARIABLES
    private String titulo, autor;
    private int ejemplares, prestados;
	
    //CONSTRUCTORES
	public Libro(String titulo, String autor, int ejemplares, int prestados) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.ejemplares = ejemplares;
		this.prestados = prestados;
	}
	
	public Libro(){
		
	}
	
	//METODOS GET Y SET
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getEjemplares() {
		return ejemplares;
	}

	public void setEjemplares(int ejemplares) {
		this.ejemplares = ejemplares;
	}

	public int getPrestados() {
		return prestados;
	}

	public void setPrestados(int prestados) {
		this.prestados = prestados;
	}
	
	//OTROS METODOS
    public boolean prestamo() {
        boolean prestado = true;
        if (prestados < ejemplares) {
            prestados++;
        } else {
            prestado = false;
        }
        return prestado;
    }
    
    public boolean devolucion() {
        boolean devuelto = true;
        if (prestados == 0) {
            devuelto = false;
        } else {
            prestados--;
        }
        return devuelto;
    }
    
    @Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + ", ejemplares="
				+ ejemplares + ", prestados=" + prestados + "]";
	}

	//METODO MAIN
	public static void main(String[] args) {
		Libro l1 = new Libro("IT", "Stephen King", 6, 2);
		
		System.out.println(l1.toString());
		l1.prestamo();
		l1.prestamo();
		l1.prestamo();
		l1.devolucion();
		System.out.println(l1.toString());	
	}
}
