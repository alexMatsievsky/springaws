package com.alexMaz.springaws.controller;

import com.alexMaz.springaws.profile.ProfileUser;
import com.alexMaz.springaws.service.ProfileUserDataAccessService;
import com.alexMaz.springaws.service.ProfileUserService;
import com.amazonaws.services.opsworks.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping ("api/v1/profile")
public class ProfileUserController {

    @Autowired
    private ProfileUserService profileUserService;

    @GetMapping
    public List<ProfileUser> getUserProfile() {
        return profileUserService.getProfiles();
    }

    @PostMapping(
            path = "{userProfileId}/image/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void uploadUserProfileImage(
            @PathVariable("userProfileId") UUID userProfileId,
            @RequestParam("file") MultipartFile file) {
        profileUserService.uploadUserProfileImage(userProfileId, file);
    }

}
