package otis.AdvAnd.DAO;

public class User {

	public String name;
	public String username;
	public int imageResourse;
	public String mPhone;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getImageResourse() {
		return imageResourse;
	}

	public void setImageResourse(int imageResourse) {
		this.imageResourse = imageResourse;
	}

	public String getmPhone() {
		return mPhone;
	}

	public void setmPhone(String mPhone) {
		this.mPhone = mPhone;
	}

	
	
//	public User(String id, int imageResource, String phoneNumber){
//		this.username = id;
//		this.imageResourse = imageResource;
//		this.mPhone = phoneNumber;
//	}
	
	public String toString() {
		return username;
	}
}
