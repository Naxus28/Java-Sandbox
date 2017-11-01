
public class LampWithBulb4Test {

	public static void main(String[] args) {
		ColoredLightBulb2 bulb = new ColoredLightBulb2();
		ColoredLightBulb2 blueBulb = new ColoredLightBulb2("blue");
		
		LampWithBulb4 lamp = new LampWithBulb4(bulb);
		LampWithBulb4 lamp2 = new LampWithBulb4(blueBulb);
		
		lamp.turnOn();
		lamp.turnOn();
		lamp.turnOff();
		lamp.turnOff();
		
		System.out.println("========");
		
		lamp2.turnOn();
		lamp2.turnOn();
		lamp2.turnOff();
		lamp2.turnOff();

	}

}
