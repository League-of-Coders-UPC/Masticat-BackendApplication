package masticat.profileservice.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import masticat.profileservice.domain.model.commands.CreateProfileCommand;
import masticat.profileservice.domain.model.commands.UpdateProfileCommand;
import masticat.profileservice.domain.model.entities.Profile;
import masticat.profileservice.domain.model.queries.GetAllProfilesQuery;
import masticat.profileservice.domain.model.queries.GetProfileByUuidQuery;
import masticat.profileservice.domain.services.ProfileCommandService;
import masticat.profileservice.domain.services.ProfileQueryService;
import masticat.profileservice.interfaces.rest.resource.CreateProfileResource;
import masticat.profileservice.interfaces.rest.resource.ProfileResource;
import masticat.profileservice.interfaces.rest.resource.UpdateProfileResource;
import masticat.profileservice.interfaces.rest.transform.CreateProfileCommandFromResourceAssembler;
import masticat.profileservice.interfaces.rest.transform.ProfileResourceFromEntityAssembler;
import masticat.profileservice.interfaces.rest.transform.UpdateProfileCommandFromResourceAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/profiles", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Profiles", description = "Profiles Management Endpoints")
public class ProfileController {

    @Autowired
    ProfileCommandService profileCommandService;

    @Autowired
    ProfileQueryService profileQueryService;

    @PostMapping()
    public ResponseEntity<ProfileResource> createProfile(@RequestBody CreateProfileResource resource) {
        CreateProfileCommand createProfileCommand = CreateProfileCommandFromResourceAssembler.toCommandFromResource(resource);
        String profileUuId = profileCommandService.handle(createProfileCommand);
        if(profileUuId.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        GetProfileByUuidQuery getProfileByUuidQuery = new GetProfileByUuidQuery(profileUuId);
        Optional<Profile> profile = profileQueryService.handle(getProfileByUuidQuery);
        if(profile.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        ProfileResource profileResource = ProfileResourceFromEntityAssembler.toResourceFromEntity(profile.get());
        return new ResponseEntity<>(profileResource, HttpStatus.CREATED);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<ProfileResource> putProfile(@PathVariable String uuid, @RequestBody UpdateProfileResource resource){
        UpdateProfileCommand updateProfileCommand = UpdateProfileCommandFromResourceAssembler.toCommandFromResource(uuid, resource);
        Optional<Profile> updatedProfile = profileCommandService.handle(updateProfileCommand);
        if(updatedProfile.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        ProfileResource profileResource = ProfileResourceFromEntityAssembler.toResourceFromEntity(updatedProfile.get());
        return ResponseEntity.ok(profileResource);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<ProfileResource> getProfileByUuid(@PathVariable String uuid){
        GetProfileByUuidQuery getProfileByIdQuery = new GetProfileByUuidQuery(uuid);
        Optional<Profile> profile = profileQueryService.handle(getProfileByIdQuery);
        if (profile.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        ProfileResource profileResource = ProfileResourceFromEntityAssembler.toResourceFromEntity(profile.get());
        return ResponseEntity.ok(profileResource);
    }

    @GetMapping()
    public ResponseEntity<List<ProfileResource>> getAllProfiles(){
        GetAllProfilesQuery getAllProfilesQuery = new GetAllProfilesQuery();
        List<Profile> profiles = profileQueryService.handle(getAllProfilesQuery);
        if (profiles.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<ProfileResource> profileResource = profiles.stream().map(ProfileResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(profileResource);
    }
}
