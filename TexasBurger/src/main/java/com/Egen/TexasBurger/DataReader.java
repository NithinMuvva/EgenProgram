package com.Egen.TexasBurger;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.Egen.TexasBurger.Menu.Menu;
import com.Egen.TexasBurger.Menu.SpecialMenu;


public class DataReader {
    
    SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yy");
    private Map<String,List<Item>> categoryMap;
    private List<Item> specialList;
    private List<Location> locationsList;
    private List<Restuarant> resList;
    
    public DataReader() throws FileNotFoundException, IOException, ParseException
    {   
       categoryMap = new HashMap<>();
       specialList = new ArrayList<>();
       locationsList = new ArrayList<>();
       resList = new ArrayList<>();
       //BufferedReader categoryReader = new BufferedReader(new FileReader("Category.csv"));
       BufferedReader itemsReader = new BufferedReader(new FileReader(new File("Items.csv").getAbsolutePath()));
       itemsReader.readLine(); 
       
       String fileLine = null;
//       while((fileLine = categoryReader.readLine())!= null)
//       {
//           String[] fields = fileLine.split(",");
//           
//           String category = fields[0];
//           
//           if(fields.length == 0){
//               continue;
//           }
//           
//           if(!categoryMap.containsKey(category)) {
//        	   categoryMap.put(category,new ArrayList<Item>());
//           }
//       }
           
       while((fileLine = itemsReader.readLine())!= null)
       {
           String[] fields = fileLine.split(",");
           if(fields.length == 0){
               continue;
           }
           else 
           {
        	    String category = fields[0];
        	    String name = fields[1];
    	    	Double price = Double.parseDouble(fields[2]);
    	    	String type = fields[3];
    	    	Item i = new Item(name, price, type);
        	    if(!categoryMap.containsKey(category)) {
             	  categoryMap.put(category,new ArrayList<Item>());
                }
        	    categoryMap.get(category).add(i);
           }
           
       }
       
       BufferedReader splReader = new BufferedReader(new FileReader("Specials.csv"));
       splReader.readLine(); 
       while((fileLine = splReader.readLine())!= null)
       {
           String[] fields = fileLine.split(",");
           if(fields.length == 0){
               continue;
           }
           else 
           {
        	    String category = fields[0];
        	    String name = fields[1];
    	    	Double price = Double.parseDouble(fields[2]);
    	    	String type = fields[3];
    	    	Item i = new Item(name, price, type);
        	    this.specialList.add(i);
           }
           
       }
       
       BufferedReader locationsReader = new BufferedReader(new FileReader("Locations.csv"));
       locationsReader.readLine(); 
       while((fileLine = locationsReader.readLine())!= null)
       {
           String[] fields = fileLine.split(",");
           
           String street = fields[0];
           String city = fields[1];
           String state = fields[2];
           String country = fields[3];
           Integer phone = Integer.parseInt(fields[4]); 
           Integer zip = Integer.parseInt(fields[5]);
          // Date jd = format.parse(fields[3]);
           Double lat = Double.parseDouble(fields[6]);
           Double lon = Double.parseDouble(fields[7]);
           Location l = new Location(street, state,city, country, zip, phone, lat, lon);
           locationsList.add(l);
       }
       
       Menu menu = new Menu();
       menu.setCategoryMap(categoryMap);
       SpecialMenu splMenu = new SpecialMenu();
       splMenu.setSpecials(this.specialList);
       
       Restuarant  chicRest = new Restuarant(menu, locationsList.get(1));
       locationsList.get(1).setRestuarant(chicRest);
       Restuarant  bosRest = new Restuarant(menu,  locationsList.get(0));
       locationsList.get(0).setRestuarant(bosRest);
       Restuarant  nyRest = new Restuarant(menu, locationsList.get(2));
       locationsList.get(2).setRestuarant(nyRest);
       
       this.resList.add(chicRest);
       this.resList.add(bosRest);
       this.resList.add(nyRest);
       
    }
    
       
    public SimpleDateFormat getFormat() {
		return format;
	}


	public Map<String, List<Item>> getCategoryMap() {
		return categoryMap;
	}


	public List<Item> getSpecialList() {
		return specialList;
	}


	public List<Location> getLocationsList() {
		return locationsList;
	}


	public List<Restuarant> getResList() {
		return resList;
	}


	public void setFormat(SimpleDateFormat format) {
		this.format = format;
	}


	public void setCategoryMap(Map<String, List<Item>> categoryMap) {
		this.categoryMap = categoryMap;
	}


	public void setSpecialList(List<Item> specialList) {
		this.specialList = specialList;
	}


	public void setLocationsList(List<Location> locationsList) {
		this.locationsList = locationsList;
	}


	public void setResList(List<Restuarant> resList) {
		this.resList = resList;
	}


	public void DataWriter() throws IOException, ParseException
    {
        FileWriter fw = new FileWriter("Items.csv",false);
        BufferedWriter itemsWriter = new BufferedWriter(fw);
        
        for(Entry<String, List<Item>> entry: categoryMap.entrySet()) {
            for(Item i: entry.getValue())
            {   
            	itemsWriter.write(entry.getKey()+","+ i.getName()+","+
                        i.getPrice()+","+
                        i.getType());
            	itemsWriter.newLine();
            }
        }
        itemsWriter.flush();
        
        FileWriter fw1 = new FileWriter("locationsList.csv",false);
        BufferedWriter locWriter = new BufferedWriter(fw1);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
        for(Location l: this.locationsList){
        	locWriter.write(l.getStreet() +","+l.getCity()+","+l.getState()+","+l.getCountry()+","+l.getPhone()+","+l.getZipcode()+","+l.getLatitude()+","+l.getLongitude()); 
        	locWriter.newLine();
        }
        locWriter.flush();
    }
  
}


 
