package aviation.control;
import java.util.ArrayList;
import java.util.List;

import aviation.flyable.Flyable;

public class Tower {
	private List<Flyable> observers;

	public void register(Flyable p_flyable) {
		if (observers == null) {
			observers = new ArrayList<Flyable>();
		}
		observers.add(p_flyable);
		System.out.println("Tower says: "
			+ p_flyable.toString()
			+ " registered to weather tower.");
	};

	public void unregister(Flyable p_flyable) {
		if (observers != null && observers.isEmpty() == false) {
			observers.remove(p_flyable);
			System.out.println("Tower says: "
			+ p_flyable.toString()
			+ " unregistered from weather tower.\n"
			+ p_flyable.toString() + "landing."
			);
		}
	};

	protected void conditionChanged() {
		if (observers == null || observers.isEmpty() == true) {
			return ;
		}
		List<Flyable> copyOfObservers = new ArrayList<>(observers);
		for (Flyable observer : copyOfObservers) {
				observer.updateConditions();
		}
	};
}

