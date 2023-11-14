package com.chris.javabasics.patterns.creational.builder.v2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

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

    public static class Builder {
        // First, it enables lazy computation of expensive values. Instead of accepting a value directly,
        // a Supplier gives you a lazy wrapper that’s only resolved in the build call
        private Supplier<String> emailSupplier;
        private Supplier<String> nameSupplier;
        private final List<String> permissions = new ArrayList<>();

        public Builder email(String email) {
            return email(
                    () -> email
            );
        }

        public Builder email(Supplier<String> emailSupplier) {
            // First, it enables lazy computation of expensive values. Instead of accepting a value directly,
            // a Supplier gives you a lazy wrapper that’s only resolved in the build call
            this.emailSupplier = emailSupplier;
            return this;
        }

        public Builder name(String name) {
            return name(
                    () -> name
            );
        }

        public Builder name(Supplier<String> nameSupplier) {
            this.nameSupplier = nameSupplier;
            return this;
        }

        public Builder addPermission(String permission) {
            this.permissions.add(permission);
            return this;
        }

        public User build() {
            return new User(
                    // First, it enables lazy computation of expensive values. Instead of accepting a value directly,
                    // a Supplier gives you a lazy wrapper that’s only resolved in the build call
                    this.emailSupplier.get(),

                    this.nameSupplier.get(),
                    this.permissions
            );
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
