
public class Cuenta {
	
	//VARIABLES
	private String nombre, apellidos, direccion, telefono, nif;
	private double saldo;
	
	//CONSTRUCTORES
	public Cuenta(String nombre, String apellidos, String direccion,
			String telefono, String nif, double saldo) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		this.nif = nif;
		this.saldo = saldo;
	}

   public Cuenta(final Cuenta c) {
       this.nombre = c.nombre;
       this.saldo = c.saldo;
   }
	
	//METODOS GET Y SET
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	//OTROS METODOS
	   public boolean ingreso(double n) {
	        boolean ingresoCorrecto = true;
	        if (n < 0) {
	            ingresoCorrecto = false;
	        } else {
	            saldo = saldo + n;
	        }
	        return ingresoCorrecto;
	    }

	     public boolean reintegro(double n) {
	         boolean reintegroCorrecto = true;
	         if (n < 0) {
	             reintegroCorrecto = false;
	         } else if (saldo >= n) {
	             saldo -= n;
	         } else {
	             reintegroCorrecto = false;
	         }
	         return reintegroCorrecto;
	     }
	
	     public boolean transferencia(Cuenta c, double n) {
	         boolean correcto = true;
	         if (n < 0) {
	             correcto = false;
	         } else if (saldo >= n) {
	             reintegro(n);
	             c.ingreso(n);
	         } else {
	             correcto = false;
	         }
	         return correcto;
	     }
	
	@Override
	public String toString() {
		return "Cuenta [nombre=" + nombre + ", apellidos=" + apellidos
				+ ", direccion=" + direccion + ", telefono=" + telefono
				+ ", nif=" + nif + ", saldo=" + saldo + "]";
	}

	//METODO MAIN
	public static void main(String[] args) {
		Cuenta c1 = new Cuenta("Jorge", "Zambrana", "Calle Centro", "952111222", "11223344-A", 50);
		Cuenta c2 = new Cuenta("Juan", "Lopez", "Calle Arriba", "952333444", "55667788-B", 120);
		
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		c1.ingreso(300);
		System.out.println(c1.toString());
		c1.reintegro(20);
		System.out.println(c1.toString());
		c1.transferencia(c2, 80);
		System.out.println(c1.toString());
		System.out.println(c2.toString());		
	}
}
