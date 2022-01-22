package pe.lacafetalab.pao.shared.framework;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Context implements Serializable {
	private static final long serialVersionUID = 1L;

	private String transactionId;
	private String address;
	private String userId;
	private String userRole;
	private long start;
	private String uri;

}
