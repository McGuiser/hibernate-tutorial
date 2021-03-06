package com.corey.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.corey.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// Create a student object
			System.out.println("Creating a new student object...");
			Student tempStudent = new Student("John", "Doe", "john@java.com");
			
			// Start a transaction
			session.beginTransaction();
			
			// Save the student object
			System.out.println("Saving the student...");
			session.save(tempStudent);
			
			// Commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
			
		} finally {
			factory.close();
		}

	}

}
