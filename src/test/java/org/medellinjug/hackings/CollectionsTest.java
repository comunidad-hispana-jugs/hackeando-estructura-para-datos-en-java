package org.medellinjug.hackings;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

public class CollectionsTest {

	public static List<String> getClients(){
		List<String> clients = new ArrayList<>(  );

		for(int it=0; it<50000000;it++){
			clients.add("PATRICIA");
			clients.add("DANIEL");
			clients.add("HILLMER");

		}
		return clients;
	}

	@Test
	public void countUniqueClientsWithList() {

		List<String> clients = getClients();

		Date start = new Date();
		HackingCollections.countUniqueClientsWithList(clients);

		Date end = new Date();
		System.out.println( end.getTime()-start.getTime());

	}

	@Test
	public void countUniqueClientsWithSets() {
		List<String> clients = getClients();

		Date start = new Date();
		HackingCollections.countUniqueClientsWithSets(clients);
		Date end = new Date();
		System.out.println( end.getTime()-start.getTime());
	}
}
