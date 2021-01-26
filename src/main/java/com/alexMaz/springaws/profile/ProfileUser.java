package com.alexMaz.springaws.profile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class ProfileUser {

    private UUID userProfileId;
    private String name;
    private String userImageLink; // S3 key

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfileUser that = (ProfileUser) o;
        return Objects.equals(userProfileId, that.userProfileId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(userImageLink, that.userImageLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userProfileId, name, userImageLink);
    }
}
