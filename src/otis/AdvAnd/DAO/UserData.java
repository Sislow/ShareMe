package otis.AdvAnd.DAO;

import java.util.ArrayList;
import java.util.List;

import android.R;
import android.content.Intent;
import otis.AdvAnd.shareme.CheckUser;

public class UserData {

	
	CheckUser nextUser = new CheckUser();
	private List<User> Users = new ArrayList<User>();
	public List<User> getUser()	{
	
		
		return Users;
	}
	
	
	
	public UserData() {
		//addItem(new User("Oliver", R.drawable.alert_dark_frame, "937773"));
		// Define user data dynamically 
		
		
	}

	private void addItem(User userItem) {
		// TODO Auto-generated method stub
		Users.add(userItem);
	}
	
	
}
