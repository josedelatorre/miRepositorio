
public class Complejo {

	//VARIABLES
    private double real, imag;
   
    //CONSTRUCTORES
	public Complejo(double real, double imag) {
		super();
		this.real = real;
		this.imag = imag;
	}
	
	//METODOS GET Y SET
	public double getReal() {
		return real;
	}

	public void setReal(double real) {
		this.real = real;
	}

	public double getImag() {
		return imag;
	}

	public void setImag(double imag) {
		this.imag = imag;
	}
	
	//OTROS METODOS
    public Complejo sumar(Complejo c){
        Complejo aux = new Complejo(real, imag);
        aux.real = real + c.real;
        aux.imag = imag + c.imag;
        return aux;
    }
    
    public Complejo restar(Complejo c){
        Complejo aux = new Complejo(real, imag);
        aux.real = real - c.real;
        aux.imag = imag - c.imag;
        return aux;
    }
    
    public Complejo multiplicar(Complejo c){
        Complejo aux = new Complejo(real, imag);
        aux.real = real * c.real - imag * c.imag;
        aux.imag = real * c.imag + imag * c.real;
        return aux;
    }
    
    public Complejo dividir(Complejo c){
        Complejo aux = new Complejo(real, imag);
        aux.real = (real * c.real + imag * c.imag)/(c.real * c.real + c.imag * c.imag);
        aux.imag = (imag * c.real - real * c.imag)/(c.real * c.real + c.imag * c.imag);
        return aux;
    }
    
    @Override
    public String toString() {
    	return "(" + real + ", " + imag + ")";
    }
    
    @Override
   public boolean equals(Object obj) {
       if (obj == null) {
           return false;
       }
       if (getClass() != obj.getClass()) {
           return false;
       }
       final Complejo other = (Complejo) obj;
       if (this.real != other.real) {
           return false;
       }
       if (this.imag != other.imag) {
           return false;
       }
       return true;
   }  
    
	//METODO MAIN
	public static void main(String[] args) {	
		Complejo c1 = new Complejo(5, 2);
		Complejo c2 = new Complejo(15, 3);
		
		System.out.println(c1.sumar(c2));
		System.out.println(c1.restar(c2));
		System.out.println(c1.multiplicar(c2));
		System.out.println(c1.dividir(c2));
	}
}
