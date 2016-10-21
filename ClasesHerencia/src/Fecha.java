
public class Fecha {

	//VARIABLES
	private int dia, mes, anyo;
	
	//CONSTRUCTORES
    public Fecha(int dia, int mes, int anyo) {
        this.dia = dia;
        this.mes = mes;
        this.anyo = anyo;
    }
    
    //METODOS GET Y SET
	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}
	
	//OTROS METODOS
    private boolean esBisiesto() {
        return (anyo % 4 == 0 && anyo % 100 != 0 || anyo % 400 == 0);
    }
		
    public boolean fechaCorrecta() {
        boolean diaCorrecto, mesCorrecto, añoCorrecto;
        añoCorrecto = anyo > 0;
        mesCorrecto = mes >= 1 && mes <= 12;
        switch (mes) {
            case 2:
                if (esBisiesto()) {
                    diaCorrecto = dia >= 1 && dia <= 29;
                } else {
                    diaCorrecto = dia >= 1 && dia <= 28;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                diaCorrecto = dia >= 1 && dia <= 30;
                break;
            default:
                diaCorrecto = dia >= 1 && dia <= 31;
        }
        return diaCorrecto && mesCorrecto && añoCorrecto;
    }
	
    public void diaSiguiente() {
        dia++;
        if (!fechaCorrecta()) {
            dia = 1;
            mes++;
            if (!fechaCorrecta()) {
                mes = 1;
                anyo++;
            }
        }
    } 
    
	@Override
	public String toString() {
		return "Fecha [dia=" + dia + ", mes=" + mes + ", anyo=" + anyo + "]";
	}

	//METODO MAIN
	public static void main(String[] args) {
		Fecha f1 = new Fecha(25,8,1990);
		System.out.println(f1.toString());
		System.out.println(f1.esBisiesto());
		f1.diaSiguiente();
		System.out.println(f1.toString());
		f1.fechaCorrecta();
		System.out.println(f1.toString());
	}
}