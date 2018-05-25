package com.example.trisys.dogether.Room;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import com.example.trisys.dogether.R;
import com.example.trisys.dogether.Room.ViewModel.RoomHomeActivityViewModel;

public class RoomHomeActivity extends LifecycleActivity {

  public static FragmentManager fragmentManager;
  public static MyRoomDatabase myRoomDatabase;
  public RoomHomeActivityViewModel mViewModel;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_room_home);
    myRoomDatabase= Room.databaseBuilder(getApplicationContext(),MyRoomDatabase.class,"MyRoom").allowMainThreadQueries().build();

    mViewModel = ViewModelProviders.of(this).get(RoomHomeActivityViewModel.class);

    fragmentManager=getSupportFragmentManager();

    if(findViewById(R.id.fragment_container)!=null){

      if(savedInstanceState!=null){
        return;
      }

      fragmentManager.beginTransaction().add(R.id.fragment_container,new HomeRoomFragment()).commit();

    }
  }
}
