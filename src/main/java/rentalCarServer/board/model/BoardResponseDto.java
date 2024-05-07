package rentalCarServer.board.model;

import java.security.Timestamp;

public class BoardResponseDto {
	private int postNumber;
	private String userId;
	private String title;
	private String contents;
	private String adminComment;
	private boolean isCommented;
	private Timestamp postDate;
	private Timestamp modDate;
	private boolean isNotice;
	
	public BoardResponseDto(int postNumber, String userId, String title, String contents, String adminComment, boolean isCommented,
			Timestamp postDate, Timestamp modDate, boolean isNotice) {
		super();
		this.postNumber = postNumber;
		this.userId = userId;
		this.title = title;
		this.contents = contents;
		this.adminComment = adminComment;
		this.isCommented = isCommented;
		this.postDate = postDate;
		this.modDate = modDate;
		this.isNotice = isNotice;
	}
	
	public BoardResponseDto() {
		
	}

	public int getPostNumber() {
		return postNumber;
	}

	public void setPostNumber(int postNumber) {
		this.postNumber = postNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getAdminComment() {
		return adminComment;
	}

	public void setAdminComment(String adminComment) {
		this.adminComment = adminComment;
	}

	public boolean isCommented() {
		return isCommented;
	}

	public void setCommented(boolean isCommented) {
		this.isCommented = isCommented;
	}

	public Timestamp getPostDate() {
		return postDate;
	}

	public void setPostDate(Timestamp postDate) {
		this.postDate = postDate;
	}

	public Timestamp getModDate() {
		return modDate;
	}

	public void setModDate(Timestamp modDate) {
		this.modDate = modDate;
	}

	public boolean isNotice() {
		return isNotice;
	}

	public void setNotice(boolean isNotice) {
		this.isNotice = isNotice;
	}
	
	
}
