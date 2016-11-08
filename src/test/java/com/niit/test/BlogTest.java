package com.niit.test;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.BlogCommentDAO;
import com.niit.DAO.BlogDAO;
import com.niit.model.Blog;
import com.niit.model.BlogComment;

public class BlogTest {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		Blog blog = (Blog) context.getBean("blog");

		BlogDAO blogDAO = (BlogDAO) context.getBean("blogDAO");
		BlogComment blogComment = (BlogComment) context.getBean("blogComment");
		BlogCommentDAO blogCommentDAO = (BlogCommentDAO) context.getBean("blogCommentDAO");

		Date date = new Date();
		long time = date.getTime();
		Timestamp timestamp = new Timestamp(time);

		//blog.setBlogId("blg002");
		blog.setBlogName("First Blog");
		blog.setBlogDescription("This is  new blog created");
		blog.setStatus('A');
		blog.setCreatedAt(timestamp);
		blog.setModifiedAt(timestamp);

		blog.setUserId("URS001");

		//blogDAO.saveOrUpdateBlog(blog);

		blogComment.setBlog(blog);
		blogComment.setCommentedAt(timestamp);
		blogComment.setBlogCommentContent("Lorem ipsum dolor sit amet, "
				+ "consectetur adipisicing eliak vubhefuNOEFJWOIWJEZsd CA;ukhdW kjfweYBGRCukqjwhduqih3r t. Exsdfhnvvjdsagvozs mkvslbgkhsjngvmio;klpedita esse tempora impedit magnam magni ipsum molestias et autem ea rerum.");
		blogComment.setUserId("USR001");
		//blogCommentDAO.saveOrUpdateBlogComment(blogComment);
		
		
		
		BlogComment blogComment1 = new BlogComment();
		
		blogComment1.setBlog(blog);
		blogComment1.setCommentedAt(timestamp);
		blogComment1.setBlogCommentContent("Lorem ipsum dolor sit amet, updated   "
				+ "consectetur adipisicing eliak vubhefuNOEF uJWOIWJEZsd CA;ukhdW kjfweYBGRCukqjwhduqih3r t. Exsdfhnvvjdsagvozs mkvslbgkhsjngvmio;klpedita esse tempora impedit magnam magni ipsum molestias et autem ea rerum.");
		blogComment1.setUserId("USR001");
	//	blogCommentDAO.saveOrUpdateBlogComment(blogComment1);

		if (blogDAO.getBlog("blg005") != null) {
			System.out.println("blog exist");
		} else {
			System.out.println("NOt exist");
		}

		// System.out.println(blogDAO.listBlogs());
		
		System.out.println(blogDAO.listBlogsByCreatedAt('P').toString());

	}

}
