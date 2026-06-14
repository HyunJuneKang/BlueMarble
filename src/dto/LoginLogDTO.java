package dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor@AllArgsConstructor
@Getter@Setter@Builder
public class LoginLogDTO {
    private Integer logId;
    private String userId;
    private String description;
    private Date logDate;
}