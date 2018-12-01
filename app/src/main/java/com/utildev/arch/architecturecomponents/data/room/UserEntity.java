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

    public UserEntity(long id, String name, String job) {
        this.id = id;
        this.name = name;
        this.job = job;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name != null ? name : "";
    }

    public String getJob() {
        return job != null ? job : "";
    }
}
