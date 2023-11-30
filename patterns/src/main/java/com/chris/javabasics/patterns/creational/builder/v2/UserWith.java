package com.chris.javabasics.patterns.creational.builder.v2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

// Consumer-based higher-order methods must be added to the builder
public record UserWith(
        String email,
        String name,
        List<String> permissions) {

    public UserWith {
        if (email == null || email.isBlank())
            throw new IllegalArgumentException("'email' must be set.");

        if (permissions == null)
            permissions = Collections.emptyList();
    }

    public static class Builder {

        // The builder fields need to be public to be mutable in the Consumer.
        public String email;
        public String name;

        // not all fields should be public
        // Collection-based types are better served by their own with methods.
        private final List<String> permissions = new ArrayList<>();

        public Builder with(Consumer<Builder> builderFn) {
            builderFn.accept(this);
            return this;
        }

        public Builder withPermissions(Consumer<List<String>> permissionsFn) {
            permissionsFn.accept(this.permissions);
            return this;
        }

        public UserWith build() {
            return new UserWith(
                    this.email,
                    this.name,
                    this.permissions
            );
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
