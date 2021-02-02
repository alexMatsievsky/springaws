package com.alexMaz.springaws.profile;

import com.amazonaws.services.apigateway.model.Op;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@Builder
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
    public Optional<String> getUserImageLink() {
        return Optional.ofNullable(userImageLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userProfileId, name, userImageLink);
    }
}
