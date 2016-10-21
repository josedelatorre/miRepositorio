
public class Contador {

	//VARIABLES
	private int cont;
	
	//CONSTRUCTORES
   public Contador() {
   }

   public Contador(int cont) {
       if (cont < 0) {
           this.cont = 0;
       } else {
           this.cont = cont;
       }
   }

   public Contador(final Contador c) {
       cont = c.cont;
   }

   //METODOS GET Y SET
	public int getCont() {
		return cont;
	}

	public void setCont(int cont) {
        if (cont < 0) {
            this.cont = 0;
        } else {
            this.cont = cont;
        }
	}

	//OTROS METODOS
    public void incrementar() {
        cont++;
    }
    
    public void decrementar(){
       cont--;
       if (cont < 0) {
           cont = 0;
       }
    }
	
    //METODO MAIN
	public static void main(String[] args) {
		Contador c1 = new Contador(5);
		
		System.out.println(c1.getCont());
		c1.incrementar();
		c1.incrementar();
		c1.incrementar();
		c1.incrementar();
		System.out.println(c1.getCont());
		c1.decrementar();
		System.out.println(c1.getCont());
	}
}
