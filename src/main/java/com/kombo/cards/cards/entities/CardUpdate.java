package com.kombo.cards.cards.entities;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardUpdate {
    private String name;
    @Pattern(regexp = "^#([A-Fa-f0-9]{6})$", flags = { Pattern.Flag.CASE_INSENSITIVE, Pattern.Flag.MULTILINE }, message = "The Color code is invalid.")
    private String color;
    private String description;
    private CardStatus status;

}
