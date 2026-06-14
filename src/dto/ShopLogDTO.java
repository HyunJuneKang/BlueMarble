package dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor@AllArgsConstructor
@Getter@Setter@Builder
public class ShopLogDTO {
    private Integer logId;
    private String userId;
    private String itemId;
    private String description;
    private Integer quantity;
    private Integer gold;
    private Date logDate;
}