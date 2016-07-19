package homework;

import java.util.*;

public class PenguinFun {
	private static final int EQUAL   =  0;

	private static final PenguinHatchery hatchery = new PenguinHatchery();

	public static void main(String [] args){
		System.out.println("PENGUIN LIST:");
		List<Penguin> penguinList = getPenguinList();
		display(penguinList); //displays penguins in the order they were hatched

		System.out.println();

		System.out.println("PENGUIN SET:");
		Set<Penguin> penguinSet = new HashSet<>(penguinList);
		display(penguinSet); //displays penguins in a different order; HashSet does not keep the order of its elements

		System.out.println();

		System.out.println("PENGUIN LIST - RACE/AGE SORTED:");
		orderPenguinListByRaceAndAge(penguinList);
		display(penguinList);

		System.out.println();

		System.out.println("PENGUIN LIST - WITH MATES:");
		matePenguins(penguinList);
		display(penguinList);

		System.out.println();

		System.out.println("PENGUIN LIST - MATE SORTED:");
		orderPenguinsByMates(penguinList);
		display(penguinList);

		System.out.println();

		System.out.println("PENGUIN MAP:");
		HashMap<String, HashSet<Penguin>> penguinMap = transformPenguinListToMap(penguinList);
		displayPenguinMap(penguinMap);
	}

	private static void orderPenguinListByRaceAndAge(List<Penguin> input) {
		Collections.sort(input, new Comparator<Penguin>() {
			@Override
			public int compare(Penguin p1, Penguin p2) {
				if(p1.getRaceAsString().compareTo(p2.getRaceAsString()) == 0) {
					return EQUAL;
				} else {
					return p1.getRaceAsString().compareTo(p2.getRaceAsString());
				}
			}
		});
	}

	private static void orderPenguinsByMates(List<Penguin> penguins) {
		Collections.sort(penguins, new Comparator<Penguin>() {
			@Override
			public int compare(Penguin p1, Penguin p2) {
				if (p1.getMatesCount() == p2.getMatesCount()) {
					if (p1.getMateAgeAverage() == p2.getMateAgeAverage()) {
						if (p1.getName().charAt(6) == p2.getName().charAt(6)) {
							return EQUAL;
						} else {
							return p1.getName().charAt(6) - p2.getName().charAt(6);
						}
					} else {
						//can't convert to int; precision loss -> unwanted equality
						if(p1.getMateAgeAverage() - p2.getMateAgeAverage() < 0) {
							return -1;
						} else {
							return 1;
						}
					}
				} else {
					return p1.getMatesCount() - p2.getMatesCount();
				}
			}
		});
	}

	private static HashMap<String, HashSet<Penguin>>  transformPenguinListToMap(List<Penguin> penguins) {
		HashMap<String, HashSet<Penguin>> result = new HashMap<>();

		for(Penguin penguin : penguins) {
			HashSet<Penguin> set;

			if (result.containsKey(penguin.getRaceAsString())) {
				set = result.get(penguin.getRaceAsString());
			} else {
				set = new HashSet<>();
			}

			set.add(penguin);
			result.put(penguin.getRaceAsString(), set);
		}

		return result;
	}

	private static void display(Collection<?> collection) {
		collection.forEach(System.out::println);
	}

	private static void displayPenguinMap(HashMap<String, HashSet<Penguin>> map) {
		for(String key : map.keySet()) {
			System.out.println(key);
			display(map.get(key));
			System.out.println();
		}
	}

	private static List<Penguin> getPenguinList() {
		List<Penguin> result = new ArrayList<>();

		for(int i = 0; i < 10; i++) {
			result.add(hatchery.hatchPenguin());
		}

		return result;
	}

	private static void matePenguins(List<Penguin> penguins) {
		for (Penguin penguin : penguins) {
			penguin.setMatingPartners(hatchery.matePenguin());
		}
	}
}	
