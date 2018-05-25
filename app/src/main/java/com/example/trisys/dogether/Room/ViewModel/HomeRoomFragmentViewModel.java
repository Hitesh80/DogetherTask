package com.example.trisys.dogether.Room.ViewModel;

import android.arch.lifecycle.ViewModel;
import com.example.trisys.dogether.Room.RoomHomeActivity;
import com.example.trisys.dogether.Room.User;
import java.util.List;

/**
 * Created by trisys on 20/5/18.
 */

public class HomeRoomFragmentViewModel extends ViewModel {

  public List<User> getUserData(){
    return RoomHomeActivity.myRoomDatabase.myDao().getAllUser();
  }

  public void deleteUser(User user){
        RoomHomeActivity.myRoomDatabase.myDao().deleteUser(user);

    }

  public void updateUser(User user) {
    RoomHomeActivity.myRoomDatabase.myDao().updateUser(user);
  }
}
