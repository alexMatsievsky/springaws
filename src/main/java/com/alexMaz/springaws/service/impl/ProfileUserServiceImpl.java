package com.alexMaz.springaws.service.impl;

import com.alexMaz.springaws.bucket.BucketName;
import com.alexMaz.springaws.filestore.FileStore;
import com.alexMaz.springaws.profile.ProfileUser;
import com.alexMaz.springaws.service.ProfileUserDataAccessService;
import com.alexMaz.springaws.service.ProfileUserService;
import com.amazonaws.services.s3.model.Bucket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

import static org.apache.http.entity.ContentType.*;

@Service
public class ProfileUserServiceImpl implements ProfileUserService {

    @Autowired
    private ProfileUserDataAccessService profileUserDataAccessService;

    @Autowired
    private     FileStore fileStore;

    public List<ProfileUser> getProfiles(){
        return profileUserDataAccessService.getProfiles();
    }

    public void uploadUserProfileImage(UUID userProfileId, MultipartFile file) {
        isFileEmpty(file);
        isImage(file);
        ProfileUser profile = getProfileOrThrow(userProfileId);

        String path = String.format("%s/%s", BucketName.PROFILE_IMAGE.getBucketName(), profile.getUserProfileId());
        String filename = String.format("%s-%s", file.getOriginalFilename(), UUID.randomUUID());

        Map<String, String> metadata = extractMetada(file);

        try {
            fileStore.save(path, filename, Optional.of(metadata), file.getInputStream());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private Map<String, String> extractMetada(MultipartFile file) {
        Map<String, String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Lenth", String.valueOf(file.getSize()));
        return metadata;
    }

    private ProfileUser getProfileOrThrow(UUID userProfileId) {
        return profileUserDataAccessService.getProfiles().stream()
                .filter(profileUser -> profileUser.getUserProfileId().equals(userProfileId))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(String.format("User profile %s not found", userProfileId)));
    }

    private void isImage(MultipartFile file) {
        if (!Arrays.asList(IMAGE_JPEG.getMimeType(), IMAGE_PNG.getMimeType(), IMAGE_GIF.getMimeType()).contains(file.getContentType())){
            throw new IllegalStateException("File must be an image");
        }
    }

    private void isFileEmpty(MultipartFile file) {
        if(file.isEmpty()){
            throw new IllegalStateException("Cannot upload empty file [" + file.getSize()+"]");
        }
    }
}
