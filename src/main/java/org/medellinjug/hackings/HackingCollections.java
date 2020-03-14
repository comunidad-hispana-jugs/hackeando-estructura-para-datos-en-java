package org.medellinjug.hackings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HackingCollections {

	/*
	* Use case: Un producto X ha sido comprado N clientes en un almacen, cada cliente puede haberlo comprado varias veces,
	* las comprar se han hecho por diferentes plataformas que usan diferentes basee de datos.
	* La lista de compradores se han unificado en un solo archivo tomando los números de cedulas de los diferentes sistemas
	* el almacén necesita saber el numero de clientes que ha comprado dicho producto
	* */

	public static int countUniqueClientsWithList(List<String> clients){
		List<String> clientsUnique = new ArrayList<>();
		for(String client: clients){
			if(!clientsUnique.contains(client)){
				clientsUnique.add(client);
			}
		}
		return clientsUnique.size();
	}

	public static int countUniqueClientsWithSets(List<String> clients){
		Set<String> clientsUnique = new HashSet<>();
		for(String client: clients){
			if(!clientsUnique.contains(client)){
				clientsUnique.add(client);
			}
		}
		return clientsUnique.size();
	}

}
