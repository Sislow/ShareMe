package otis.AdvAnd.DAO;

public class User {

	public String username;
	public int imageResourse;
	public String mPhone;
	
	public User(String id, int imageResource, String phoneNumber){
		this.username = id;
		this.imageResourse = imageResource;
		this.mPhone = phoneNumber;
	}
	
	public String toString() {
		return username;
	}
}
