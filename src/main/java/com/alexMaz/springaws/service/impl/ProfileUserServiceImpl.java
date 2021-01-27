package com.alexMaz.springaws.service.impl;

import com.alexMaz.springaws.profile.ProfileUser;
import com.alexMaz.springaws.service.ProfileUserDataAccessService;
import com.alexMaz.springaws.service.ProfileUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

public class ProfileUserServiceImpl implements ProfileUserService {

    @Autowired
    private ProfileUserDataAccessService profileUserDataAccessService;

    public List<ProfileUser> getProfiles(){
        return profileUserDataAccessService.getProfiles();
    }

    public void uploadUserProfileImage(UUID userProfileId, MultipartFile file) {

    }
}
