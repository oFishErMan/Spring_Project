package com.CustomSoft.Controller;

class Car {
	String model;
	String color;
	int yyyy;
	
	Car(String model, String color, int yyyy) {
		this.model = model;
		this.color = color;
		this.yyyy = yyyy;
		System.out.println(model);
		
	}
	
}

public class tsestsest {

	public static void main(String[] args) {
		int yyyy=2020;
		Car c = new Car("SUV", "흰색", yyyy++);
		System.out.println(",year:" +c.yyyy);
		System.out.println(",year:" +yyyy);
		
		System.out.println(",year:" +yyyy);
		System.out.println(",year:" +yyyy);
		
	}

}
