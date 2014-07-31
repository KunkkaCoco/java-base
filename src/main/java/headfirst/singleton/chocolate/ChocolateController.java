package headfirst.singleton.chocolate;

public class ChocolateController {
	public static void main(String args[]) {
		ChocolateBoiler boiler = ChocolateBoiler.getInstance();
		boiler.fill();
		boiler.boil();
		boiler.drain();
		System.out.println(boiler);
		// will return the existing instance
		ChocolateBoiler boiler2 = ChocolateBoiler.getInstance();
		boiler.fill();
		boiler.boil();
		boiler.drain();
		System.out.println(boiler2);
	}

}
