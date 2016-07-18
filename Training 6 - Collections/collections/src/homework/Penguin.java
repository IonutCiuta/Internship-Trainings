package homework;

import java.util.List;

public class Penguin {
	public static boolean SAME_HASHCODE = false;

	private String name;
	private PenguinRace race;
	private double age;
	private List<Penguin> matingPartners;
	
	public Penguin(String name, PenguinRace race, double age) {
		this.name = name;
		this.race = race;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public PenguinRace getRace() {
		return race;
	}

	public String getRaceAsString() { return race.toString(); }

	public double getAge() {
		return age;
	}

	public List<Penguin> getMatingPartners() {
		return matingPartners;
	}

	public int getMatesCount() { return matingPartners != null ? matingPartners.size() : 0; }

	public double getMateAgeAverage() {
		double result = 0;

		if(matingPartners != null) {
			double sum = 0;
			for(Penguin penguin : matingPartners) {
				sum += penguin.getAge();
			}
			result = sum/matingPartners.size();
		}

		return result;
	}

	public void setMatingPartners(List<Penguin> matingPartners) {
		this.matingPartners = matingPartners;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Penguin)) return false;

		Penguin penguin = (Penguin) o;

		if (Double.compare(penguin.age, age) != 0) return false;
		if (!name.equals(penguin.name)) return false;
		if (race != penguin.race) return false;
		return matingPartners != null ? matingPartners.equals(penguin.matingPartners) : penguin.matingPartners == null;

	}

	@Override
	public int hashCode() {
		if(SAME_HASHCODE == true) {
			return 1;
		} else {
			int result;
			long temp;
			result = name.hashCode();
			result = 31 * result + race.hashCode();
			temp = Double.doubleToLongBits(age);
			result = 31 * result + (int) (temp ^ (temp >>> 32));
			return result;
		}
	}

	@Override
	public String toString() {
		return "Penguin {" + name + ", " + race + ", " + age + (getMatingPartners() != null ? "} -> " + matingPartners : "");
	}
}
