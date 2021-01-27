package com.alexMaz.springaws.datastore.impl;

import com.alexMaz.springaws.datastore.FakeUserProfileRepository;
import com.alexMaz.springaws.profile.ProfileUser;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeUserProfileRepositoryImpl implements FakeUserProfileRepository {

    private static final List<ProfileUser> USER_PROFILE= new ArrayList<>();

    static {
        USER_PROFILE.add(ProfileUser.builder()
                            .userProfileId(UUID.randomUUID())
                            .name("Mary")
                            .build());
        USER_PROFILE.add(ProfileUser.builder()
                            .userProfileId(UUID.randomUUID())
                            .name("Joan")
                            .build());
    }

    public List<ProfileUser> getUserProfile(){
        return USER_PROFILE;
    }
}
