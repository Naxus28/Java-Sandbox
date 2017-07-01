
public class LampTest {

	public static void main(String[] args) {
		Lamp lamp = new Lamp();
		String name = lamp.getName();
		System.out.println("Class name: " + name);
		lamp.turnOn();
		lamp.turnOn();
		lamp.turnOff();
		lamp.turnOff();
	}
}
