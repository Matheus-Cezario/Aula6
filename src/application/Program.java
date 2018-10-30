package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservetion;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date" );
		}
		else {
			Reservetion reservetion = new Reservetion(number, checkIn, checkOut);
			System.out.println("Reservetion: "+reservetion);
			
			System.out.println("----------------------------------");
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			
			if(!checkOut.after(checkIn)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date" );
			}
			else if(checkIn.before(new Date())|| checkOut.before(new Date())){
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			}
			else {
				reservetion.updateDates(checkIn, checkOut);
				System.out.print("Reservetion: "+reservetion);
			}
		}
		
		
		sc.close();
	}

}
