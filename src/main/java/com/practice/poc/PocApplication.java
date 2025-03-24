package com.practice.poc;

import com.practice.poc.BuilderDesignPattern.Phone;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PocApplication {

	public static void main(String[] args) {

		/*EagerSingleton singleton = EagerSingleton.getInstance();

		System.out.println("Singleton object is"+singleton);

		EagerSingleton singleton2 = EagerSingleton.getInstance();

		System.out.println("Singleton object is"+singleton2);*/

		/*LazySingleton lazySingleton = LazySingleton.getLazyInstance();

		System.out.println("Lazy object" + lazySingleton);

		LazySingleton lazySingleton2 = LazySingleton.getLazyInstance();

		System.out.println("Lazy object2" + lazySingleton2);*/

		/*Runnable task = () -> {
			LazySingletonNotThreadsafeProof singletonNotThreadsafeProof = LazySingletonNotThreadsafeProof.getSingletonObj();
			System.out.println(singletonNotThreadsafeProof);
		};

		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);
		Thread t3 = new Thread(task);

		t1.start();
		t2.start();
		t3.start();
*/
		Phone samsungPhone = new Phone.PhoneBuilder()
				.setCost(123.45)
				.setIs5gEnabled(true)
				.setModel("Samsung")
				.build();
		SpringApplication.run(PocApplication.class, args);
	}

}
