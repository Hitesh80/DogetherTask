package com.example.trisys.dogether.Room

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by trisys on 21/5/18.
 */
@Entity(tableName = "users")
class User {

  fun getId(): Int {
    return id
  }

  fun setId(id: Int) {
    this.id = id
  }

  fun getName(): String? {
    return name
  }

  fun setName(name: String) {
    this.name = name
  }

  fun getEmail(): String? {
    return email
  }

  fun setEmail(email: String) {
    this.email = email
  }

  @PrimaryKey
  private var id: Int = 0

  @ColumnInfo(name = "userName")
  private var name: String? = null

  @ColumnInfo(name = "userEmail")
  private var email: String? = null
}