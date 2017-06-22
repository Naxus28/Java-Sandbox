
public class LampWithBulbTest {

	public static void main(String[] args) {
		LightBulb bulb = new LightBulb();
		LampWithBulb lamp = new LampWithBulb();
		lamp.turnOn();
		lamp.setLightBulb(bulb);
		lamp.turnOn();
		lamp.turnOn();
		lamp.turnOff();
	}
}
