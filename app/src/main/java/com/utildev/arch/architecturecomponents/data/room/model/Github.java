package com.utildev.arch.architecturecomponents.data.room.model;

import com.utildev.arch.architecturecomponents.data.remote.BaseModel;

public class Github extends BaseModel {
    private String title, lib, github;

    public Github(String title, String lib, String github) {
        this.title = title;
        this.lib = lib;
        this.github = github;
    }

    public String getTitle() {
        return title;
    }

    public String getLib() {
        return lib;
    }

    public String getGithub() {
        return github;
    }
}
