package otis.AdvAnd.DAO;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.provider.OpenableColumns;
import otis.AdvAnd.shareme.CheckUser;

public class UserData {

	String mPhone;
	String mUser;
	String mName;
	User saveUser = new User();
	String fileName = "UserCard";
	FileOutputStream fileout;
	
	private List<User> Users = new ArrayList<User>();
	public List<User> setUser(User user)	{
		mUser = saveUser.getUsername();
		mPhone = saveUser.getmPhone();
		mName = saveUser.getName();
		Users.add(user);
		System.out.println(Users.toString());
		SaveData(user);
		
		return Users;
		

	}
	
	
	
	public void  SaveData(User user) {
		// Save the user to file
		
		
		
	}

	
	
}
