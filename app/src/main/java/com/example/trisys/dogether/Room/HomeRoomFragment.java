package com.example.trisys.dogether.Room;

import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.example.trisys.dogether.R;
import com.example.trisys.dogether.Room.ViewModel.HomeRoomFragmentViewModel;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeRoomFragment extends LifecycleFragment {
  @BindView(R.id.viewuser) Button viewUser;
  @BindView(R.id.adduser) Button addUser;
  @BindView(R.id.deleteuser) Button deleteUser;
  @BindView(R.id.updateuser) Button updateuser;
  private Unbinder unbinder;
  private List<User> users;
  private HomeRoomFragmentViewModel mViewModel;

  public HomeRoomFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view=inflater.inflate(R.layout.fragment_home_room, container, false);
    unbinder=ButterKnife.bind(this,view);
    mViewModel= ViewModelProviders.of(this).get(HomeRoomFragmentViewModel.class);
    return view;


  }

  @OnClick(R.id.adduser)
  public void addUser(){
    RoomHomeActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new AddUserFragment())
        .addToBackStack(null).commit();
  }
  @OnClick(R.id.viewuser)
  public void viewUser(){
    users=mViewModel.getUserData();

  }
  @OnClick(R.id.deleteuser)
  public void deleteUser(){
    for (int i=0;i<users.size();i++){
      if(users.get(i).getId()==1){
        mViewModel.deleteUser(users.get(i));
      }
    }
  }
  @OnClick(R.id.updateuser)
  public void updateUser(){
    for (int i=0;i<users.size();i++){
      if(users.get(i).getId()==1){
        users.get(i).setName("Reema");
        mViewModel.updateUser(users.get(i));
      }
    }
  }


  @Override public void onDestroy() {
    super.onDestroy();
    unbinder.unbind();
  }

}
