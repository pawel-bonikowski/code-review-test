package com.sii.test;

/**
 * try to refactor with using generics methods
 */
public class Generic {

    public static void main(String... arg) {
        User some = new User("some", "otherName");
        OtherUser otherUser = new OtherUser("otherName", "surName");
        User copy = copy(some);
        OtherUser copy2 = copy(otherUser);
        System.out.println("Other propery of user is: " + copy.getSomeOtherProperty());
        System.out.println("Other user SurName is: " + copy2.getSurName());
    }

    static User copy(User user) {
        validate(user);
        return new User(user.getName(), user.getSomeOtherProperty());
    }

    static OtherUser copy(OtherUser user) {
        validate(user);
        return new OtherUser(user.getName(), user.getSurName());
    }

    private static void validate(Named name) {
        if (name.getName() == null) {
            throw new IllegalArgumentException();
        }
    }


}

interface Named {
    String getName();
}

class User implements Named {
    private final String name;
    private final String someOtherProperty;

    User(String name, String someOtherProperty) {
        this.name = name;
        this.someOtherProperty = someOtherProperty;
    }


    public String getName() {
        return name;
    }

    public String getSomeOtherProperty() {
        return someOtherProperty;
    }
}

class OtherUser implements Named {

    private final String name;
    private final String surName;

    OtherUser(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }
}
