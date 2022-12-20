package test.musique.common;


public class AppException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String category;

	public AppException(String category, String message) {
        super(message);
        this.category = category;
    }

	public String getCategory() {
		return category;
	}
}
