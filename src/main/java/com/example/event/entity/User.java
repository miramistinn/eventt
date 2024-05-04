package com.example.event.entity;

public class User {
    private Long id;
    private boolean isAdmin;

    private static User instance;
    private User(Long id, boolean isAdmin) {
        this.id = id;
        this.isAdmin = isAdmin;
    }

    public static User getInstance() {
        if (instance == null) {
            synchronized (User.class) {
                if (instance == null) {
                    instance = new User(0L, false);
                }
            }
        }
        return instance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    //как меенять
    //User user = User.getInstance();
    //user.setId(1);
    //user.setAdmin(true);
}