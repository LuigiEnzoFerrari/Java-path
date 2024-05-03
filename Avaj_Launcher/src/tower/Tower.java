package tower;
import java.util.ArrayList;
import java.util.List;

import interfaces.Flyable;

public class Tower {
	private List<Flyable> observers;

	public void register(Flyable p_flyable) {
		if (observers == null) {
			observers = new ArrayList<Flyable>();
		}
		observers.add(p_flyable);
	};
	public void unregister(Flyable p_flyable) {};

	protected void conditionChanged() {
		for (Flyable observer : observers) {
			observer.updateConditions();
		}
	};
}

