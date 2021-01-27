package com.alexMaz.springaws.service;

import com.alexMaz.springaws.profile.ProfileUser;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

public interface ProfileUserService {

    List<ProfileUser> getProfiles();

    void uploadUserProfileImage(UUID userProfileId, MultipartFile file);
}
