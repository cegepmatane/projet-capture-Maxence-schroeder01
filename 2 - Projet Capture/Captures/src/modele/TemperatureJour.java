package modele;

public class TemperatureJour {
	
	protected int idQuelHeure;
	protected int min;
	protected int max;
	protected int moy;
	
	
	public TemperatureJour(String id,String min, String max, String moy) {
		super();
		this.idQuelHeure = Integer.parseInt(id);
		this.min = Integer.parseInt(min);
		this.max = Integer.parseInt(max);
		this.moy = Integer.parseInt(moy);
	}
	
	public int getId() {
		return idQuelHeure;
	}
	public void setId(int idQuelHeure) {
		this.idQuelHeure = idQuelHeure;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getMoy() {
		return moy;
	}
	public void setMoy(int moy) {
		this.moy = moy;
	}

}


