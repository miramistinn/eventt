package com.example.event;

import com.example.event.entity.Client;
import com.example.event.entity.Roles;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static com.example.event.entity.Roles.ROLE_USER;

@SpringBootApplication
public class EventApplication {

	public static void main(String[] args) {
//		String strDateTime = "2022-05-01T10:30";
//		LocalDateTime dateTime = LocalDateTime.parse(strDateTime);
//		Set<Roles> roles = new HashSet<>();
//
//		roles.add(Roles.ROLE_ADMIN);
//		Client client = new Client( 1L,  "adfsdg", "dfxghg", false, false, roles,dateTime );
//		System.out.println(client.getRoles());
		SpringApplication.run(EventApplication.class, args);
	}

}
