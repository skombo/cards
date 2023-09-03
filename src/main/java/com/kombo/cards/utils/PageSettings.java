package com.kombo.cards.utils;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class PageSettings {
    private int page = 0;
    @NotBlank

    private int elementPerPage = 5;


    private String direction = "dsc";


    private String key;

    public Sort buildSort() {
        if(direction!=null){
            switch (direction) {
                case "dsc":
                    return Sort.by(key).descending();
                case "asc":
                    return Sort.by(key).ascending();
                default:
                    log.warn("Invalid direction provided in PageSettings, using descending direction as default value");
                    return Sort.by(key).descending();
            }
        }else {
            return Sort.unsorted();

        }

    }
}
