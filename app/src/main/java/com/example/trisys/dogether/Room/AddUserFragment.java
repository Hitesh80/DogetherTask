package com.example.trisys.dogether.Room;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.example.trisys.dogether.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddUserFragment extends Fragment {

  @BindView(R.id.userId) EditText userId;
  @BindView(R.id.userName) EditText userName;
  @BindView(R.id.email) EditText userEmail;
  @BindView(R.id.save) Button save;
  private Unbinder unbinder;

  public AddUserFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
   View view= inflater.inflate(R.layout.fragment_add_user, container, false);
    unbinder=ButterKnife.bind(this,view);
    return view;
  }

  @OnClick(R.id.save)
  public void saveUserDetails(){
    int id=Integer.parseInt(userId.getText().toString());
    String name=userName.getText().toString();
    String email=userEmail.getText().toString();
    User user=new User();
    user.setId(id);
    user.setEmail(email);
    user.setName(name);
    RoomHomeActivity.myRoomDatabase.myDao().addUser(user);
    Toast.makeText(getActivity(),"user added successfully",Toast.LENGTH_SHORT).show();

    userId.setText("");
    userName.setText("");
    userEmail.setText("");
  }

  @Override public void onDestroy() {
    super.onDestroy();
    unbinder.unbind();
  }
}
