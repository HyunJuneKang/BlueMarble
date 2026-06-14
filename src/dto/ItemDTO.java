package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor@AllArgsConstructor
@Getter@Setter@Builder
public class ItemDTO {
    private Integer itemId;
    private String itemName;
    private Integer price;
    private String description;
    private String effectType;
    private Integer effectValue;
}