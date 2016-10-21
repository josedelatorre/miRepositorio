
public class Fraccion {

	//VARIABLES
    private int num, den;
    
    //CONSTRUCTORES
    public Fraccion(int num, int den) {
        this.num = num;
        if(den==0){
            den = 1;
        }
        this.den = den;
        simplificar();
    }
    
    //METODOS GET Y SET
    public int getDen() {
        return den;
    }

    public void setDen(int den) {
        this.den = den;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    
    //OTROS METODOS
    public Fraccion sumar(Fraccion f) {
        Fraccion aux = new Fraccion(num, den);
        aux.num = this.num * f.den + this.den * f.num;
        aux.den = this.den * f.den;
        aux.simplificar();  //se simplifica antes de devolverla
        return aux;
    }
    
    public Fraccion restar(Fraccion f) {
        Fraccion aux = new Fraccion(num, den);
        aux.num = this.num * f.den - this.den * f.num;
        aux.den = this.den * f.den;
        aux.simplificar();  //se simplifica antes de devolverla
        return aux;
    }
    
    public Fraccion multiplicar(Fraccion f) {
        Fraccion aux = new Fraccion(num, den);
        aux.num = this.num * f.num;
        aux.den = this.den * f.den;
        aux.simplificar();  //se simplifica antes de devolverla
        return aux;
    }
    
    public Fraccion dividir(Fraccion f) {
        Fraccion aux = new Fraccion(num, den);
        aux.num = this.num * f.den;
        aux.den = this.den * f.num;
        aux.simplificar();  //se simplifica antes de devolverla
        return aux;
    }
    
    private int mcd() {
        int u = Math.abs(num); //valor absoluto del numerador
        int v = Math.abs(den); //valor absoluto del denominador
        if (v == 0) {
            return u;
        }
        int r;
        while (v != 0) {
            r = u % v;
            u = v;
            v = r;
        }
        return u;
    }
    
    private void simplificar() {
        int n = mcd(); //se calcula el mcd de la fracción
        num = num / n;
        den = den / n;
    }
	
    @Override
    public String toString() {
       simplificar();
       return num + "/" + den;
    } 
    
    //METODO MAIN
	public static void main(String[] args) {
		Fraccion f1 = new Fraccion(15, 3);
		Fraccion f2 = new Fraccion(20, 4);
		
		System.out.println(f1.sumar(f2));
		System.out.println(f1.restar(f2));
		System.out.println(f1.multiplicar(f2));
		System.out.println(f1.dividir(f2));
	}

}
