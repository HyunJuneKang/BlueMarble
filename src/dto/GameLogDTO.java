package dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor@AllArgsConstructor
@Getter@Setter@Builder
public class GameLogDTO {
    private Integer gameId;
    private String userId;
    private String result;
    private Integer turnCount;
    private Date playDate;
}