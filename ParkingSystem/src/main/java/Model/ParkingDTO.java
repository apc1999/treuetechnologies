package Model;

public class ParkingDTO {
     private  int spotId;
     private int spotNumber;
     private String location;
     private int spotAvailability;
     private double price;
     private int bookingId;
     private String bookDate;
     private String checkIn;
     private String checkOut;
     
     
  


	

	public ParkingDTO(int spotId, int spotNumber, String location, int spotAvailability, double price, int bookingId,
			String bookDate, String checkIn, String checkOut) {
		super();
		this.spotId = spotId;
		this.spotNumber = spotNumber;
		this.location = location;
		this.spotAvailability = spotAvailability;
		this.price = price;
		this.bookingId = bookingId;
		this.bookDate = bookDate;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}


	public ParkingDTO() {
	
	}


	public int getSpotId() {
		return spotId;
	}


	public void setSpotId(int spotId) {
		this.spotId = spotId;
	}


	public int getSpotNumber() {
		return spotNumber;
	}


	public void setSpotNumber(int spotNumber) {
		this.spotNumber = spotNumber;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public int getSpotAvailability() {
		return spotAvailability;
	}


	public void setSpotAvailability(int spotAvailability) {
		this.spotAvailability = spotAvailability;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getBookDate() {
		return bookDate;
	}


	public void setBookDate(String bookDate) {
		this.bookDate = bookDate;
	}


	public String getCheckIn() {
		return checkIn;
	}


	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}


	public String getCheckOut() {
		return checkOut;
	}


	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}


	public int getBookingId() {
		return bookingId;
	}


	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	
   	
	
   	
     
     
     
}
