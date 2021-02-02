package com.alexMaz.springaws.datastore;

import com.alexMaz.springaws.profile.ProfileUser;

import java.util.List;

public interface FakeUserProfileRepository {

    public List<ProfileUser> getUserProfile();
}
