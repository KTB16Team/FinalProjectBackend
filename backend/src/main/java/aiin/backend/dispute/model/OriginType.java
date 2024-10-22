package aiin.backend.dispute.model;

public enum OriginType {
	TEXT("text"),
	VOICE("voice");

	private String value;

	OriginType(String value) {
		this.value = value;
	}
}
