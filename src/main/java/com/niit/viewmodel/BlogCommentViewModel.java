package com.niit.viewmodel;

import com.niit.model.Blog;
import com.niit.model.BlogComment;

public class BlogCommentViewModel {

	private Blog blog;
	private BlogComment blogComment;
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	public BlogComment getBlogComment() {
		return blogComment;
	}
	public void setBlogComment(BlogComment blogComment) {
		this.blogComment = blogComment;
	}
	
	
	
	
}
