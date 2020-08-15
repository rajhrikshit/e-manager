package com.pracdev.emanager.handlers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pracdev.emanager.utils.UserProfile;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;

public class Profiler {

    private static Profiler profiler;

    private Profiler() {
        ;
    }

    public static Profiler getInstance() {
        if(profiler == null) {
            profiler = new Profiler();
        }
        return profiler;
    }

    public UserProfile getProfile(String userName) throws IOException {
        UserProfile userProfile= null;
        ObjectMapper objectMapper = new ObjectMapper();
        File profiles = ResourceUtils.getFile("classpath:user_profiles.json");
        JsonNode rootNode = objectMapper.readTree(profiles);
        JsonNode profile = rootNode.path(userName);
        userProfile = objectMapper.treeToValue(profile, UserProfile.class);
        if(userProfile != null) {
            userProfile.setUserName(userName);
        }
        return userProfile;
    }
}
