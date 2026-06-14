package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor@AllArgsConstructor
@Getter@Setter@Builder
public class UsersDTO {
    private String userId;
    private String password;
    private String userName;
    private String question;
    private String answer;
    private Integer gold;
    private Integer experience;
}