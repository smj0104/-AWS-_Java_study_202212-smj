package usermanagement.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data

public class RoleDtl {  //하나의 dtl에 하나의 mst가 따라온다
	
	private int roleDtlId;
	private int roleId;
	private int userId;
	
	private RoleMst roleMst;  //roleId와 짝이 지어진다

}
