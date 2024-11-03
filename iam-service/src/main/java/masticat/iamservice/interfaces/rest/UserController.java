package masticat.iamservice.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import masticat.iamservice.domain.model.commands.CreateUserCommand;
import masticat.iamservice.domain.model.commands.UpdateUserCommand;
import masticat.iamservice.domain.model.entities.User;
import masticat.iamservice.domain.model.queries.GetAllUsersQuery;
import masticat.iamservice.domain.model.queries.GetUserByUuidQuery;
import masticat.iamservice.domain.services.UserCommandService;
import masticat.iamservice.domain.services.UserQueryService;
import masticat.iamservice.interfaces.rest.resource.CreateUserResource;
import masticat.iamservice.interfaces.rest.resource.UserResource;
import masticat.iamservice.interfaces.rest.resource.UpdateUserResource;
import masticat.iamservice.interfaces.rest.transform.CreateUserCommandFromResourceAssembler;
import masticat.iamservice.interfaces.rest.transform.UserResourceFromEntityAssembler;
import masticat.iamservice.interfaces.rest.transform.UpdateUserCommandFromResourceAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Users", description = "Users Management Endpoints")
public class UserController {

    @Autowired
    UserCommandService userCommandService;

    @Autowired
    UserQueryService userQueryService;

    @PostMapping()
    public ResponseEntity<UserResource> createUser(@RequestBody CreateUserResource resource) {
        CreateUserCommand createUserCommand = CreateUserCommandFromResourceAssembler.toCommandFromResource(resource);
        String userUuId = userCommandService.handle(createUserCommand);
        if(userUuId.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        GetUserByUuidQuery getUserByUuidQuery = new GetUserByUuidQuery(userUuId);
        Optional<User> user = userQueryService.handle(getUserByUuidQuery);
        if(user.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        UserResource userResource = UserResourceFromEntityAssembler.toResourceFromEntity(user.get());
        return new ResponseEntity<>(userResource, HttpStatus.CREATED);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<UserResource> putUser(@PathVariable String uuid, @RequestBody UpdateUserResource resource){
        UpdateUserCommand updateUserCommand = UpdateUserCommandFromResourceAssembler.toCommandFromResource(uuid, resource);
        Optional<User> updatedUser = userCommandService.handle(updateUserCommand);
        if(updatedUser.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        UserResource userResource = UserResourceFromEntityAssembler.toResourceFromEntity(updatedUser.get());
        return ResponseEntity.ok(userResource);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<UserResource> getUserByUuid(@PathVariable String uuid){
        GetUserByUuidQuery getUserByIdQuery = new GetUserByUuidQuery(uuid);
        Optional<User> user = userQueryService.handle(getUserByIdQuery);
        if (user.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        UserResource userResource = UserResourceFromEntityAssembler.toResourceFromEntity(user.get());
        return ResponseEntity.ok(userResource);
    }

    @GetMapping()
    public ResponseEntity<List<UserResource>> getAllUsers(){
        GetAllUsersQuery getAllUsersQuery = new GetAllUsersQuery();
        List<User> users = userQueryService.handle(getAllUsersQuery);
        if (users.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<UserResource> userResource = users.stream().map(UserResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(userResource);
    }
}
