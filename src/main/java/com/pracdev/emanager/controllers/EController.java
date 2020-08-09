package com.pracdev.emanager.controllers;

import com.pracdev.emanager.utils.Profiler;
import com.pracdev.emanager.utils.UserProfile;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class EController{

    @RequestMapping(value = "/profile/{userName}", method = RequestMethod.GET)
    @ResponseBody
    public UserProfile getUserProfile(@PathVariable String userName) throws IOException {
        return Profiler.getInstance().getProfile(userName);
    }
}
