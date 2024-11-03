package masticat.subscriptionbillingservice.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import masticat.subscriptionbillingservice.domain.model.commands.CreateSubscriptionCommand;
import masticat.subscriptionbillingservice.domain.model.commands.UpdateSubscriptionCommand;
import masticat.subscriptionbillingservice.domain.model.entities.Subscription;
import masticat.subscriptionbillingservice.domain.model.queries.GetAllSubscriptionsQuery;
import masticat.subscriptionbillingservice.domain.model.queries.GetSubscriptionByUuidQuery;
import masticat.subscriptionbillingservice.domain.services.SubscriptionCommandService;
import masticat.subscriptionbillingservice.domain.services.SubscriptionQueryService;
import masticat.subscriptionbillingservice.interfaces.rest.resource.CreateSubscriptionResource;
import masticat.subscriptionbillingservice.interfaces.rest.resource.SubscriptionResource;
import masticat.subscriptionbillingservice.interfaces.rest.resource.UpdateSubscriptionResource;
import masticat.subscriptionbillingservice.interfaces.rest.transform.CreateSubscriptionCommandFromResourceAssembler;
import masticat.subscriptionbillingservice.interfaces.rest.transform.SubscriptionResourceFromEntityAssembler;
import masticat.subscriptionbillingservice.interfaces.rest.transform.UpdateSubscriptionCommandFromResourceAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/subscriptions", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Subscriptions", description = "Subscriptions Management Endpoints")
public class SubscriptionController {

    @Autowired
    SubscriptionCommandService subscriptionCommandService;

    @Autowired
    SubscriptionQueryService subscriptionQueryService;

    @PostMapping()
    public ResponseEntity<SubscriptionResource> createSubscription(@RequestBody CreateSubscriptionResource resource) {
        CreateSubscriptionCommand createSubscriptionCommand = CreateSubscriptionCommandFromResourceAssembler.toCommandFromResource(resource);
        String subscriptionUuId = subscriptionCommandService.handle(createSubscriptionCommand);
        if(subscriptionUuId.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        GetSubscriptionByUuidQuery getSubscriptionByUuidQuery = new GetSubscriptionByUuidQuery(subscriptionUuId);
        Optional<Subscription> subscription = subscriptionQueryService.handle(getSubscriptionByUuidQuery);
        if(subscription.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        SubscriptionResource subscriptionResource = SubscriptionResourceFromEntityAssembler.toResourceFromEntity(subscription.get());
        return new ResponseEntity<>(subscriptionResource, HttpStatus.CREATED);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<SubscriptionResource> putSubscription(@PathVariable String uuid, @RequestBody UpdateSubscriptionResource resource){
        UpdateSubscriptionCommand updateSubscriptionCommand = UpdateSubscriptionCommandFromResourceAssembler.toCommandFromResource(uuid, resource);
        Optional<Subscription> updatedSubscription = subscriptionCommandService.handle(updateSubscriptionCommand);
        if(updatedSubscription.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        SubscriptionResource subscriptionResource = SubscriptionResourceFromEntityAssembler.toResourceFromEntity(updatedSubscription.get());
        return ResponseEntity.ok(subscriptionResource);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<SubscriptionResource> getSubscriptionByUuid(@PathVariable String uuid){
        GetSubscriptionByUuidQuery getSubscriptionByIdQuery = new GetSubscriptionByUuidQuery(uuid);
        Optional<Subscription> subscription = subscriptionQueryService.handle(getSubscriptionByIdQuery);
        if (subscription.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        SubscriptionResource subscriptionResource = SubscriptionResourceFromEntityAssembler.toResourceFromEntity(subscription.get());
        return ResponseEntity.ok(subscriptionResource);
    }

    @GetMapping()
    public ResponseEntity<List<SubscriptionResource>> getAllSubscriptions(){
        GetAllSubscriptionsQuery getAllSubscriptionsQuery = new GetAllSubscriptionsQuery();
        List<Subscription> subscriptions = subscriptionQueryService.handle(getAllSubscriptionsQuery);
        if (subscriptions.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<SubscriptionResource> subscriptionResource = subscriptions.stream().map(SubscriptionResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(subscriptionResource);
    }
}
