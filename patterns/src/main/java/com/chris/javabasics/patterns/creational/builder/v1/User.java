package com.chris.javabasics.patterns.creational.builder.v1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public record User(
        String email,
        String name,
        List<String> permissions) {

    public User {
        if (email == null || email.isBlank())
            throw new IllegalArgumentException("'email' must be set.");

        if (permissions == null)
            permissions = Collections.emptyList();
    }

    // The builder is implemented as an inner static class
    //      mimicking all the components of its parent Record.
    //
    public static class Builder {
        private String email;
        private String name;
        private final List<String> permissions = new ArrayList<>();

        // Each component has its dedicated set-only method that returns the Builder instance for fluent call chains.
        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        // Additional methods for Collection-based fields allow you to add single elements.
        public Builder addPermission(String permission) {
            this.permissions.add(permission);
            return this;
        }

        // The build method simply calls the appropriate User constructor.
        public User build() {
            return new User(
                    this.email,
                    this.name,
                    this.permissions
            );
        }
    }

    // A static builder method is added so that you don’t need to create a Builder instance yourself.
    public static Builder builder() {
        return new Builder();
    }
}
