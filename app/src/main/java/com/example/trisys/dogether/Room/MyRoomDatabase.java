package com.example.trisys.dogether.Room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by trisys on 19/5/18.
 */


@Database(entities = {User.class},version = 1)
public abstract class MyRoomDatabase extends RoomDatabase {

  public abstract MyDao myDao();
}
