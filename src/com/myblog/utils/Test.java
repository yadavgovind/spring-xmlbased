package com.myblog.utils;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.myblog.domain.Category;
import com.myblog.service.BlogService;

public class Test {
	static BlogService blogService = null;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
//FileSystemXmlApplicationContext context =new FileSystemXmlApplicationContext("hibernate.hbm.xml");
        // read obj ,mapping file
         cfg=cfg.configure("hibernate.cfg.xml");
         Transaction tx=null;
            SessionFactory  factory = cfg.buildSessionFactory();
         //open session
         Session ses=factory.openSession();
  // Category cat1= (Category)ses.load(Category.class,43L);
     
		Category cat=new Category();
		cat.setId(101L);
	//	for(int i=0;i<=5;i++){
			cat.setId(48L);
			cat.setName("govind ");
			//System.out.println("category name is: "+cat.getName());
			ses.save(cat);
			tx.commit();
		//}
	
		//System.out.println("=========== : "+blogService);
		//List<Category> catlist=blogService.getCategory();
		
		//System.out.println(catlist.get(0));
		//System.out.println(catlist.get(1));

//System.out.println(catlist.get(0));
//System.out.println(catlist.get(0));
//System.out.println(catlist.get(0));
ses.close();
	}

}
