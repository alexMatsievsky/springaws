package com.alexMaz.springaws.bucket;

public enum BucketName {

    PROFILE_IMAGE("aws-bucket-image-upload");

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
