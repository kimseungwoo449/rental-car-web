package rentalCarServer.board.model;

import java.security.Timestamp;

public class Board {
	private int postNumber;
	private String userId;
	private String title;
	private String contents;
	private String adminComment;
	private boolean isCommented;
	private Timestamp postDate;
	private Timestamp modDate;
	private boolean isNotice;
	
	public Board(int postNumber, String userId, String title, String contents, String adminComment, boolean isCommented,
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

	public int getPostNumber() {
		return postNumber;
	}

	public String getUserId() {
		return userId;
	}

	public String getTitle() {
		return title;
	}

	public String getContents() {
		return contents;
	}

	public String getAdminComment() {
		return adminComment;
	}

	public boolean isCommented() {
		return isCommented;
	}

	public Timestamp getPostDate() {
		return postDate;
	}

	public Timestamp getModDate() {
		return modDate;
	}

	public boolean isNotice() {
		return isNotice;
	}
}
