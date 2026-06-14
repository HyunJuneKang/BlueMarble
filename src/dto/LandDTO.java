package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor@AllArgsConstructor
@Getter@Setter@Builder

public class LandDTO {
	private String LandID;
	private String landType;   
	private String landName;   
	private Integer buyPrice;  
	private Integer tollPrice;  
	private Integer upgradeCost;
	private Integer upgradeMax; 
}
