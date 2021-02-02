package com.alexMaz.springaws.service.impl;

import com.alexMaz.springaws.datastore.FakeUserProfileRepository;
import com.alexMaz.springaws.profile.ProfileUser;
import com.alexMaz.springaws.service.ProfileUserDataAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileUserDataAccessServiceImpl  implements ProfileUserDataAccessService {

    @Autowired
    private FakeUserProfileRepository fakeUserProfileRepository;

    public List<ProfileUser> getProfiles(){
        return fakeUserProfileRepository.getUserProfile();
    }

}
