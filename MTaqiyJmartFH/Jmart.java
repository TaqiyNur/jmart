package MTaqiyJmartFH;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;

/**
 * Write a description of class Jmart here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Jmart
{
	public static List<Product> read(String filepath) throws FileNotFoundException {
		JsonReader jr = new JsonReader(new FileReader(filepath));
		Product[] products = new Gson().fromJson(jr,  Product[].class);
		
		List<Product> list = new ArrayList<Product>();
		Collections.addAll(list,  products);
		
		return list;
	}
	
	public static List<Product> filterByCategory(List<Product> product, ProductCategory category) {
		/*List<Product> categoryList = Algorithm.<Product>collect(product, (e) -> e.category == category);
		return categoryList;
		*/
		return null;
	}
	
	public static List<Product> filterByPrice(List<Product> list, double minPrice, double maxPrice) {
		List<Product> priceList = new ArrayList<Product>();
		
		for(Product product : list) {
			if(minPrice != 0.0 && product.price < minPrice) {
				continue;
			}
			
			if (maxPrice != 0.0 && product.price > maxPrice) {
				continue;
			}
			
			priceList.add(product);
		}
		
		return priceList;
	}
	
   public static void main(String[] args) {
	   System.out.println("account id: " + new Account(null, null, null, -1).id);
	   System.out.println("account id: " + new Account(null, null, null, -1).id);
	   System.out.println("account id: " + new Account(null, null, null, -1).id);
	   
	   System.out.println("payment id: " + new Payment(-1, -1, -1, null).id);
	   System.out.println("payment id: " + new Payment(-1, -1, -1, null).id);
	   System.out.println("payment id: " + new Payment(-1, -1, -1, null).id);
	   
   }
   
}
