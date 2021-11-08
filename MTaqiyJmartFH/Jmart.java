package MTaqiyJmartFH;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.*;
import java.io.File;
import java.util.*;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

/**
 * Jmart Class
 *
 * @author Muhammad Taqiy Nur Furqon
 */
public class Jmart
{
	public static List<Product> read(String filepath) throws FileNotFoundException {
		Gson gson = new Gson();
		Type userListType = new TypeToken<ArrayList<Product>>() {}.getType();
		BufferedReader br = new BufferedReader(new FileReader(filepath));
		List<Product> returnList = gson.fromJson(br, userListType);
		
		return returnList;
	}
	
	public static List<Product> filterByCategory(List<Product> list, ProductCategory category) {

		List<Product> returnList = new ArrayList<Product>();
		for (Product product : list) {
			if (product.category.equals(category)) {
				returnList.add(product);
			}
		}
		return returnList;

	}
	
	public static List<Product> filterByPrice(List<Product> list, double minPrice, double maxPrice) {
		List<Product> priceList = new ArrayList<Product>();

		for (Product product : list) {
			if (minPrice != 0.0 && product.price < minPrice) {
				continue;
			}
			if (maxPrice != 0.0 && product.price > maxPrice) {
				continue;
			}

			priceList.add(product);
		}

		return priceList;
	}
	
	public static List<Product> filterByAccountId(List<Product> list, int accountId, int page, int pageSize) {
		List<Product> accList = new ArrayList<Product>();

		for (Product prod : list) {
			if (accountId == prod.accountId) {
				accList.add(prod);
			}
		}

		return paginate(accList, page, pageSize, (e) -> e.accountId == accountId) ;
	}
	
	public static List<Product> filterByName(List<Product> list, String search, int page, int pageSize) {
		 List<Product> nameList = new ArrayList<>();
	        
	        for (Product product : list) {
	            if (product.name.toLowerCase().contains(search.toLowerCase())) {
	                nameList.add(product);
	            }
	        }
	        return paginate(nameList, page, pageSize, (e) -> e.name == search);
	}
	
	private static List<Product> paginate(List<Product> list, int page, int pageSize, Predicate<Product> pred) {
		if (page <= 0 || pageSize <= 0) {
			throw new IllegalArgumentException("Invalid Input!");
		}

		List<Product> pagList = new ArrayList<>();

		for (Product product : list) {
			if (pred.predicate(product) == true) {
				pagList.add(product);
			}
		}

		int index = (page - 1) * pageSize;
		
		if (pagList == null || pagList.size() <= index) {
			return Collections.emptyList();
		}
		
		int floorPage = Math.min(index + pageSize, pagList.size());
		
		return pagList.subList(index, floorPage);
	}
	
   public static void main(String[] args){
	   /*System.out.println("account id: " + new Account(null, null, null, -1).id);
	   System.out.println("account id: " + new Account(null, null, null, -1).id);
	   System.out.println("account id: " + new Account(null, null, null, -1).id);
	   
	   System.out.println("payment id: " + new Payment(-1, -1, -1, null).id);
	   System.out.println("payment id: " + new Payment(-1, -1, -1, null).id);
	   System.out.println("payment id: " + new Payment(-1, -1, -1, null).id);
	   */
	   
	   try {
		List<Product> list = read("C:\\Users\\mtaqi\\Documents\\Praktikum OOP\\jmart\\randomProductList.json");
		List<Product> filteredName = filterByName(list, "GTX", 1, 5);
		List<Product> filteredPrice = filterByPrice(list, 0.0, 20000.0);
		filteredPrice.forEach(product -> System.out.println(product.price));
		System.out.println("\n\n");
		filteredName.forEach(product -> System.out.println(product.name));
	   } catch (FileNotFoundException e) {
		e.printStackTrace();
	   }
	   
   }
   
}
