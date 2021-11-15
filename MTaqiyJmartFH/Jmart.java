package MTaqiyJmartFH;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.*;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

/**
 * Jmart Class
 *
 * @author Muhammad Taqiy Nur Furqon
 */
public class Jmart
{
	public static long DELIVERED_LIMIT_MS;
	public static long ON_DELIVERY_LIMIT_MS;
	public static long ON_PROGRESS_LIMIT_MS;
	public static long WAITING_CONF_LIMIT_MS;
	
	public static boolean paymentTimeKeeper(Payment payment) {
		return false;
	}
	
   public static void main(String[] args){
	   /*
		try {
			String filepath = "C:\\Users\\mtaqi\\Documents\\Praktikum OOP\\jmart\\account.json";
			JsonTable<Account> tableAccount = new JsonTable<>(Account.class, filepath);
			tableAccount.add(new Account("name", "email", "password"));
			tableAccount.writeJson();
			
			tableAccount = new JsonTable<>(Account.class,filepath);
			tableAccount.forEach(account -> System.out.println(account.toString()));
		} catch (Throwable t) {
			t.printStackTrace();
		}*/
		
		/*
		 * try { JsonTable<Payment> table = new JsonTable<>(Payment.class,
		 * "randomPaymentList.json"); ObjectPoolThread<Payment> paymentPool = new
		 * ObjectPoolThread<Payment>("Thread-PP", Jmart::paymentTimekeeper);
		 * paymentPool.start(); table.forEach(payment -> paymentPool.add(payment));
		 * while (paymentPool.size() != 0); paymentPool.exit(); while
		 * (paymentPool.isAlive()); System.out.println("Thread exited successfully");
		 * Gson gson = new Gson(); table.forEach(payment -> { String history =
		 * gson.toJson(payment.history); System.out.println(history); }); } catch
		 * (Throwable t) { t.printStackTrace(); }
		 */
		
	}

	public static List<Product> read(String filepath) throws FileNotFoundException {
		Gson gson = new Gson();
		Type userListType = new TypeToken<ArrayList<Product>>() {
		}.getType();
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
		return paginate(list, page, pageSize, product -> product.accountId == accountId);
	}

	public static List<Product> filterByName(List<Product> list, String search, int page, int pageSize) {
		return paginate(list, page, pageSize, product -> product.name.toLowerCase().contains(search.toLowerCase()));
	}

	private static List<Product> paginate(List<Product> list, int page, int pageSize, Predicate<Product> pred) {
		List<Product> resultList = new ArrayList<>(pageSize);
		int startingIndex = (page) * pageSize;
		int iteration = 0;
		int occurences = 0;

		for (; iteration < list.size() && occurences < startingIndex; ++iteration) {
			if (pred.predicate(list.get(iteration))) {
				++occurences;
			}
		}

		for (int i = iteration; i < list.size() && resultList.size() < pageSize; ++i) {
			if (pred.predicate(list.get(i))) {
				resultList.add(list.get(i));
			}
		}

		return resultList;
	}
   
}
