package com.utildev.arch.architecturecomponents.data.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = RoomConstant.USER)
public class UserEntity {
    @PrimaryKey(autoGenerate = true)
    private long id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "job")
    private String job;
}
