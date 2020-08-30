package INFI.assignement;

public class Camera {
	String index;
	String name;
	String address;
	String location;
	
	public Camera(String name, String address, String location, String index) {
		this.name  = name;
		this.address = address;
		this.location = location;
		this.index = index;
	}
	
	public Camera() {
		// TODO Auto-generated constructor stub
	}

	String getName() {
		return name;
	}
	String getLocation() {
		return location;
	}
	String getAddress() {
		return address;
	}
	String getIndex() {
		return index;
	}
}
