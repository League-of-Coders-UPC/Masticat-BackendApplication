package masticat.profileservice.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import masticat.profileservice.domain.model.commands.CreatePetCommand;
import masticat.profileservice.domain.model.commands.UpdatePetCommand;
import masticat.profileservice.domain.model.entities.Pet;
import masticat.profileservice.domain.model.queries.GetAllPetsQuery;
import masticat.profileservice.domain.model.queries.GetPetByUuidQuery;
import masticat.profileservice.domain.services.PetCommandService;
import masticat.profileservice.domain.services.PetQueryService;
import masticat.profileservice.interfaces.rest.resource.CreatePetResource;
import masticat.profileservice.interfaces.rest.resource.PetResource;
import masticat.profileservice.interfaces.rest.resource.UpdatePetResource;
import masticat.profileservice.interfaces.rest.transform.CreatePetCommandFromResourceAssembler;
import masticat.profileservice.interfaces.rest.transform.PetResourceFromEntityAssembler;
import masticat.profileservice.interfaces.rest.transform.UpdatePetCommandFromResourceAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/pets", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Pets", description = "Pets Management Endpoints")
public class PetController {

    @Autowired
    PetCommandService petCommandService;

    @Autowired
    PetQueryService petQueryService;

    @PostMapping
    public ResponseEntity<PetResource> createPet(@RequestBody CreatePetResource resource) {
        CreatePetCommand createPetCommand = CreatePetCommandFromResourceAssembler.toCommandFromResource(resource);
        String petUuId = petCommandService.handle(createPetCommand);
        if(petUuId.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        GetPetByUuidQuery getPetByUuidQuery = new GetPetByUuidQuery(petUuId);
        Optional<Pet> pet = petQueryService.handle(getPetByUuidQuery);
        if(pet.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        PetResource petResource = PetResourceFromEntityAssembler.toResourceFromEntity(pet.get());
        return new ResponseEntity<>(petResource, HttpStatus.CREATED);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<PetResource> putPet(@PathVariable String uuid, @RequestBody UpdatePetResource resource){
        UpdatePetCommand updatePetCommand = UpdatePetCommandFromResourceAssembler.toCommandFromResource(uuid, resource);
        Optional<Pet> updatedPet = petCommandService.handle(updatePetCommand);
        if(updatedPet.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        PetResource petResource = PetResourceFromEntityAssembler.toResourceFromEntity(updatedPet.get());
        return ResponseEntity.ok(petResource);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<PetResource> getPetByUuid(@PathVariable String uuid){
        GetPetByUuidQuery getPetByIdQuery = new GetPetByUuidQuery(uuid);
        Optional<Pet> pet = petQueryService.handle(getPetByIdQuery);
        if (pet.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        PetResource petResource = PetResourceFromEntityAssembler.toResourceFromEntity(pet.get());
        return ResponseEntity.ok(petResource);
    }

    @GetMapping()
    public ResponseEntity<List<PetResource>> getAllPets(){
        GetAllPetsQuery getAllPetsQuery = new GetAllPetsQuery();
        List<Pet> pets = petQueryService.handle(getAllPetsQuery);
        if (pets.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<PetResource> petResource = pets.stream().map(PetResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(petResource);
    }
}
