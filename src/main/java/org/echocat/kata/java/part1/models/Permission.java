package org.echocat.kata.java.part1.models;

public enum Permission {
    AUTHOR_READ("author:read"),
    AUTHOR_EDIT("author:edit");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
