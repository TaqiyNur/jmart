package MTaqiyJmartFH;

import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.Vector;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;

public class JsonTable<T> extends Vector<Object>{
	public final String filepath;
	private static final Gson gson = new Gson();
	
	public JsonTable(Class<T> clazz, String filepath) throws IOException{
		this.filepath = filepath;
	}
	
	public static <T> Object readJson(Class<T> clazz, String filepath) throws FileNotFoundException {
		final JsonReader read = new JsonReader(new FileReader(filepath));
		  return gson.fromJson(read, clazz);
	}
	
	public void writeJson() throws IOException {
		writeJson(this, this.filepath);
	}
	
	public static void writeJson(Object object, String filepath) throws IOException {
		final FileWriter writer = new FileWriter(filepath);
		writer.write(gson.toJson(object));
		writer.close();
	}
}
