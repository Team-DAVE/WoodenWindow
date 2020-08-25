package com.controllers;

import com.model.Profile;
import com.service.ProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path="/profile")
public class ProfileController {
    private ProfileService profileService = new ProfileService();

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> addProfile(@RequestBody Profile newProfile) throws URISyntaxException {
        System.out.println("ProfileController addProfile method reached");
        if (newProfile == null) {
            System.out.println("profile is empty");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } else {
            System.out.println("Profile is good");
            String profileName = newProfile.getProfileName();
            String resume = newProfile.getResume();
            int userId = newProfile.getUser().getUserId();
            profileService.addProfile(profileName, resume, userId);
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        }
    }

    @GetMapping(path="{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Profile>> getProfilesByUserId(@PathVariable int id) {
        System.out.println("ProfileController addProfile method reached");
        List<Profile> profiles = profileService.getProfilesByUserId(id);
        System.out.println(profiles);
        return new ResponseEntity<>(profiles, HttpStatus.OK);
    }
}