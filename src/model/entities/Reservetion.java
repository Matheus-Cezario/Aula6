package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservetion {
	
	private Integer roomNumber;
	private Date checkIn, checkOut;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservetion(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duration() {
	
		return TimeUnit.DAYS.convert((checkOut.getTime() - checkIn.getTime()), TimeUnit.MILLISECONDS);
	}
	
	public String updateDates(Date checkIn, Date checkOut) {
		
		if(!checkOut.after(checkIn)) {
			return "Error in reservation: Check-out date must be after check-in date" ;
		}
		if(checkIn.before(new Date())|| checkOut.before(new Date())){
			return "Error in reservation: Reservation dates for update must be future dates";
		}
		this.checkIn=checkIn;
		this.checkOut=checkOut;
		
		return null;
	}
	
	@Override
	public String toString() {
		return "Room "
				+roomNumber
				+", check-in: "
				+sdf.format(getCheckIn())
				+", check-out: "
				+sdf.format(getCheckOut())
				+", "
				+duration()
				+" nights";
	}
	

}
