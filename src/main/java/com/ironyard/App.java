package com.ironyard;

import com.google.gson.Gson;
import com.ironyard.data.Person;
import com.ironyard.data.PersonTransporter;
import com.ironyard.data.UpgradePerson;

import java.io.*;
import java.util.Iterator;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{


    public static void main( String[] args )
    {

        Properties prop = new Properties();
        FileReader input = null;

        try {
        // load into your own prop object

         // old way, uses hard coded path == bad
         //   input = new FileReader("/Users/jasonskipper/Documents/java_projects/ioexamples/src/main/resources/application.properties");
            InputStream fis = App.class.getClassLoader().getResourceAsStream(PropKeyHolder.APP_PROP_FILE_NAME);
            prop.load(fis);

            // load into the system properties
            System.getProperties().load(App.class.getClassLoader().getResourceAsStream(PropKeyHolder.APP_PROP_FILE_NAME));
        } catch (IOException io) {
            io.printStackTrace();
        }
//        printAllSystemProperties();

        doPersonJsonFun(prop);
        doUpgradedPersonStuff();

    }

    private static void printAllSystemProperties() {
        Iterator<Object> keys = System.getProperties().keySet().iterator();
        while(keys.hasNext()){
            Object aKey = keys.next();
            System.out.printf("KEY: %s , VALUE: %s \n", aKey, System.getProperty(aKey.toString()));
        }
    }

    private static void doUpgradedPersonStuff() {
        // read a single Upgraded Perosn
        System.out.println("=======> Starting UpgradePerson Stuff...");
        try {
            FileReader fr = new FileReader(System.getProperty(PropKeyHolder.KEY_JSON_PERSON_UPGRADED));
            Gson tmpG = new Gson();
            UpgradePerson person = tmpG.fromJson(fr, UpgradePerson.class);
            System.out.println("single --------> GOT: " + person);
        }catch (Exception myBigMistake){
            System.out.println(myBigMistake.getMessage());
        }
    }

    private static void doPersonJsonFun(Properties aPropHolder) {
        System.out.println("=======> Starting Regular Person Stuff...");
        // create reader to read file
        try {

            // read a single perosn
            FileReader fr = new FileReader(System.getProperty(PropKeyHolder.KEY_JSON_PERSON));
            Gson tmpG = new Gson();
            Person person = tmpG.fromJson(fr, Person.class);
            System.out.println("single --------> GOT: " + person);

            // read an array of people
            FileReader fr2 = new FileReader(System.getProperty(PropKeyHolder.KEY_JSON_PEOPLE_ARRAY));
            Gson tmpG2 = new Gson();
            Person[] persons = tmpG2.fromJson(fr2, Person[].class);

            for(Person p: persons) {
                // find one named 'jason'
                if(p.getName().toLowerCase().equals("jason")){
                    System.out.println("FOUND JASON!");
                }
                System.out.println("array --------> GOT: " + p);
            }

            // read an object with an array attached
            FileReader fr3 = new FileReader(System.getProperty(PropKeyHolder.KEY_JSON_PEOPLE_OBJECT));
            Gson tmpG3 = new Gson();
            PersonTransporter pT = tmpG3.fromJson(fr3, PersonTransporter.class);

            for(Person p: pT.getPeoples()) {
                System.out.println("object w/array --------> GOT: " + p);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
