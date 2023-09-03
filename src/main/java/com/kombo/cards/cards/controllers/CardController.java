package com.kombo.cards.cards.controllers;
import com.kombo.cards.cards.entities.*;
import com.kombo.cards.cards.services.CardService;
import com.kombo.cards.utils.PageSettings;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@Tag(name = "Card Manager")
@AllArgsConstructor
public class CardController {
    private  final CardService cardService;
    @PostMapping("users/ids/{userId}/cards/create")
    @Operation(summary = "Create Card")
    public ResponseEntity<CardResponse>create(@PathVariable String userId,@RequestBody @Valid CardRequest request){
        CardDTO toCreate= new CardDTO();
        toCreate.setColor(request.getColor());
        toCreate.setDescription(request.getDescription());
        toCreate.setName(request.getName());
        CardDTO created=cardService.create(userId,toCreate);
        CardResponse response= new CardResponse();
        response.setColor(created.getColor());
        response.setName(created.getName());
        response.setDescription(created.getDescription());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Operation(summary = "Get All Cards By Color")
    @GetMapping("users/ids/{userId}/cards/colors/{color}/get")
    public ResponseEntity<Map<String, Object>>getByColor(@PathVariable String userId, @PathVariable String color, PageSettings page){
        Pageable pageable= PageRequest.of(page.getPage(), page.getElementPerPage(),page.buildSort());
    Page<CardDTO>cardDTOS= cardService.findByColor(userId,color,pageable);
        Map<String, Object> response = convertToResponse(cardDTOS);
        return new ResponseEntity<>(response,HttpStatus.OK);

    }
    @Operation(summary = "Get All Cards By Color")
    @GetMapping("users/ids/{userId}/cards/status/{status}/get")
public ResponseEntity<Map<String, Object>>getAllByStatus(@PathVariable String userId,@PathVariable CardStatus status, PageSettings page){
Pageable pageable=PageRequest.of(page.getPage(),page.getElementPerPage(),page.buildSort());
Page<CardDTO>cardDTOS=cardService.findByStatus(userId,status,pageable);
Map<String, Object> response = convertToResponse(cardDTOS);
return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @Operation(summary = "Get All Cards")
    @GetMapping("cards/get/all")
public ResponseEntity<Map<String, Object>>getAll(PageSettings page){
        Pageable pageable=PageRequest.of(page.getPage(), page.getElementPerPage(),page.buildSort());
        Page<CardDTO>cardDTOS=cardService.findAll(pageable);
        System.err.println(cardDTOS);
        Map<String, Object> response = convertToResponse(cardDTOS);
        return new ResponseEntity<>(response,HttpStatus.OK);
}

@PutMapping("/users/ids/{userId}/cards/{cardId}/update")
@Operation(summary = "Update Card")
public ResponseEntity<CardResponse>Update(@PathVariable String userId, @PathVariable String cardId, @RequestBody CardUpdate updateRequest){
CardDTO cardDTO=cardService.update(userId,cardId,updateRequest);
CardResponse response= new CardResponse();
response.setName(cardDTO.getName());
response.setDescription(cardDTO.getDescription());
response.setColor(cardDTO.getColor());
response.setPublicId(cardDTO.getPublicId());
return  new ResponseEntity<>(response,HttpStatus.CREATED);
}
@DeleteMapping("users/ids/{userId}/cards/ids{cardId}/delete")
public ResponseEntity<String>delete(@PathVariable String userId,  @PathVariable String cardId){
cardService.delete(userId, cardId);
    return null;
}



            private Map<String, Object> convertToResponse(final Page<CardDTO> responses) {
        Map<String, Object> response = new HashMap<>();
        response.put("cards", responses.getContent());
        response.put("pageNumber", responses.getNumber());
        response.put("totalCards", responses.getTotalElements());
        response.put("totalPages", responses.getTotalPages());
        return response;
    }
}
