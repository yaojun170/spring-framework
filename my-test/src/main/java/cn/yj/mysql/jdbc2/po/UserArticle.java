package cn.yj.mysql.jdbc2.po;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-23
 */
public class UserArticle {
	private Integer id;
	private Integer userId;
	private String title;
	private String postTime;
	private Integer showCount;
	private Integer likeCount;
	private Integer forwardCount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPostTime() {
		return postTime;
	}

	public void setPostTime(String postTime) {
		this.postTime = postTime;
	}

	public Integer getShowCount() {
		return showCount;
	}

	public void setShowCount(Integer showCount) {
		this.showCount = showCount;
	}

	public Integer getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
	}

	public Integer getForwardCount() {
		return forwardCount;
	}

	public void setForwardCount(Integer forwardCount) {
		this.forwardCount = forwardCount;
	}

	@Override
	public String toString() {
		return "UserArticle{" +
				"id=" + id +
				", userId=" + userId +
				", title='" + title + '\'' +
				", postTime='" + postTime + '\'' +
				", showCount=" + showCount +
				", likeCount=" + likeCount +
				", forwardCount=" + forwardCount +
				'}';
	}
}
