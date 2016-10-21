
public class NIF {

	//VARIABLES
    private int dni;
    private char letra;
   
    //CONSTRUCTORES
	public NIF(int dni) {
		super();
		this.dni = dni;
	}

	//METODOS GET Y SET
	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}
	
	//OTROS METODOS
    private char calcularLetra() {
        char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X',
                                'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        return letras[dni % 23];
    }	
	
	//METODO MAIN
	public static void main(String[] args) {
		NIF n1 = new NIF(74841356);
		
		System.out.println(n1.calcularLetra());
	}
}
