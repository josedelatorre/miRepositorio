
public class Empleado {

	//VARIABLES
    private static double pagoPorHoraExtra;
    private String nif;
	private String nombre;
	private double sueldoBase;
	private int horasExtras;
	private double tipoIRPF;
	private char casado;//	s/n
	private int numeroHijos;
	
	//CONSTRUCTORES
	public Empleado(String nif, String nombre, double sueldoBase,
			int horasExtras, double tipoIRPF, char casado, int numeroHijos) {
		super();
		this.nif = nif;
		this.nombre = nombre;
		this.sueldoBase = sueldoBase;
		this.horasExtras = horasExtras;
		this.tipoIRPF = tipoIRPF;
		this.casado = casado;
		this.numeroHijos = numeroHijos;
	}
	
	//METODOS GET Y SET
	public static double getPagoPorHoraExtra() {
		return pagoPorHoraExtra;
	}

	public static void setPagoPorHoraExtra(double pagoPorHoraExtra) {
		Empleado.pagoPorHoraExtra = pagoPorHoraExtra;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(double sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	public int getHorasExtras() {
		return horasExtras;
	}

	public void setHorasExtras(int horasExtras) {
		this.horasExtras = horasExtras;
	}

	public double getTipoIRPF() {
		return tipoIRPF;
	}

	public void setTipoIRPF(double tipoIRPF) {
		this.tipoIRPF = tipoIRPF;
	}

	public char getCasado() {
		return casado;
	}

	public void setCasado(char casado) {
		this.casado = casado;
	}

	public int getNumeroHijos() {
		return numeroHijos;
	}

	public void setNumeroHijos(int numeroHijos) {
		this.numeroHijos = numeroHijos;
	}
	
	//OTROS METODOS
    public double calcularImporteHorasExtras(){
        return horasExtras * pagoPorHoraExtra;
    }
    
    public double calcularSueldoBruto(){
        return sueldoBase + calcularImporteHorasExtras();
    }
    
    public double calcularRetencionIrpf(){
        double tipo = tipoIRPF;
        if(casado == 's' || casado == 'S') {
            tipo = tipo - 2;
        }
        tipo = tipo - numeroHijos;
        if(tipo<0){
            tipo = 0;
        }
        return calcularSueldoBruto() * tipo / 100;
    }
    
    public double calcularSueldo(){
        return calcularSueldoBruto() - calcularRetencionIrpf();
    }
    
	@Override
	public String toString() {
		return "Empleado [nif=" + nif + ", nombre=" + nombre + ", sueldoBase="
				+ sueldoBase + ", horasExtras=" + horasExtras + ", tipoIRPF="
				+ tipoIRPF + ", casado=" + casado + ", numeroHijos="
				+ numeroHijos + "]";
	}   

	public static void main(String[] args) {
		Empleado e1 = new Empleado("11223344-A","Pepe",730.8,2,21,'s',2);
		System.out.println(e1.toString());
		System.out.println("Importe Horas Extra=" + e1.calcularImporteHorasExtras());
		System.out.println("Retencion IRPF=" + e1.calcularRetencionIrpf());
		System.out.println("Sueldo Bruto=" + e1.calcularSueldoBruto());
		System.out.println("Sueldo Neto=" + e1.calcularSueldo());
	}
}
