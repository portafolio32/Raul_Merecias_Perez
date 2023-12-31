package Modelo;
/**
 * @author Raul Merecias Perez
 *  Fecha 06/10/2022
 * @version 1.0
 * 
 * Clase Modelo con las propiedades y metodos necesarios para crear el objeto Empleado para obtener los datos para las operaciones. 
 */
public class Empleado {
	int id;
	int hrExtra;
	String idEmpleado;
    String Nombre;
    String Rol;
    String Mes;
    float Sueldo;
    int Horas;
    int Entregas;
    float Bonos;
    float Reten;
    float Vales;
	int pagoxCarga;
	
	  public int getHrExtra() {
			return hrExtra;
		}

		public void setHrExtra(int hrExtra) {
			this.hrExtra = hrExtra;
		}

    public int getPagoxCarga() {
		return pagoxCarga;
	}

	public void setPagoxCarga(int pagoxCarga) {
		this.pagoxCarga = pagoxCarga;
	}

    public String getMes() {
		return Mes;
	}

	public void setMes(String mes) {
		Mes = mes;
	}

	public float getSueldo() {
		return Sueldo;
	}

	public void setSueldo(float sueldo) {
		Sueldo = sueldo;
	}

	public float getHoras() {
		return Horas;
	}

	public void setHoras(int horas) {
		Horas = horas;
	}

	public int getEntregas() {
		return Entregas;
	}

	public void setEntregas(int entregas) {
		Entregas = entregas;
	}

	public float getBonos() {
		return Bonos;
	}

	public void setBonos(float bonos) {
		Bonos = bonos;
	}

	public float getReten() {
		return Reten;
	}

	public void setReten(float reten) {
		Reten = reten;
	}

	public float getVales() {
		return Vales;
	}

	public void setVales(float vales) {
		Vales = vales;
	}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }

    public Empleado() {
    }
    
}
