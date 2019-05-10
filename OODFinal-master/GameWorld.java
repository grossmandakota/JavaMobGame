import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
/**
 * Write a description of class GameWorld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GameWorld
{
    private static GameWorld instance;
    private Room entrance;
    private Door door;
    private HashMap<String, MobBoss> hMapOfMB = new HashMap<String, MobBoss>();
    private HashMap<String, Room> hMapOfRooms = new HashMap<String, Room>();
    /**
     * Constructor for objects of class GameWorld
     */
    // this way you can only create a gameWorld here
    private GameWorld()
    {
        entrance = createWorld();
        createMobBosses();
    }

    public Room getEntrance()
    {
        return entrance;
    }
    
    public Door getDoor()
    {
        return this.door;
    }

    public HashMap<String, MobBoss> getHMapOfMB()
    {
        return hMapOfMB;
    }

    public HashMap<String, Room> getHMapOfRooms()
    {
        return hMapOfRooms;
    } 

    public static GameWorld getInstance()
    {
        if(instance == null)
        {
            instance = new GameWorld();
        }
        return instance;
    }

    private Room createWorld()
    {
        Room districtS = new Room("the south district");
        Room districtSE = new Room("the southeast district");
        Room districtSW = new Room("the southwest district");
        Room districtE = new Room("the east district");
        Room districtW = new Room("the west district");
        Room shop = new Room("the shop");
        Room districtNE = new Room("the northeast district");
        Room districtN = new Room("the north district");
        Room districtNW = new Room("the northwest district");
        
        
        Door door1 = Door.makeDoor(districtS, districtSW, "west", "east");  // tony's door
        door1.close();
        
        Door door2 = Door.makeDoor(districtSE, districtS, "west", "east"); // tony'e door
        door2.close();
        RegularLock aLock = new RegularLock();
        door2.setDelegate(aLock);
        aLock.lock();
        
        Door door3 = Door.makeDoor(shop, districtS, "south", "north"); // stays open
        
        Door door4 = Door.makeDoor(districtSE, districtE, "north", "south"); // james door
        door4.close();
        
        Door door5 = Door.makeDoor(districtSW, districtW, "north", "south"); // james door
        door5.close();
        
        Door door6 = Door.makeDoor(districtE, shop, "west", "east");  // james door
        door6.close();
        
        Door door7 = Door.makeDoor(districtE, districtNE, "north", "south"); // henry's door
        door7.close();
        
        Door door8 = Door.makeDoor(districtW, shop, "east", "west"); // james door
        door8.close();
        
        Door door9 = Door.makeDoor(districtW, districtNW, "north", "south"); // henry's door
        door9.close();
        
        Door door10 = Door.makeDoor(shop, districtN, "north", "south"); // henry's door
        door10.close();
        
        Door door11 = Door.makeDoor(districtNE, districtN, "west", "east"); // stays open
        
        Door door12 = Door.makeDoor(districtN, districtNW, "west", "east"); // stays open
        
        hMapOfRooms.put("districtS", districtS);
        hMapOfRooms.put("districtSE", districtSE);
        hMapOfRooms.put("districtSW", districtSW);
        hMapOfRooms.put("districtE", districtE);
        hMapOfRooms.put("districtW", districtW);
        hMapOfRooms.put("districtN", districtN);
        hMapOfRooms.put("districtNE", districtNE);
        hMapOfRooms.put("districtNW", districtNW);
        hMapOfRooms.put("shop", shop);


        return districtS;
    }

    private HashMap<String, MobBoss> createMobBosses()
    {
        MobBoss mobBoss1 = new MobBoss(100000, 60, 5000, "Tony");
        MobBoss mobBoss2 = new MobBoss(100000, 60, 5000, "James");
        MobBoss mobBoss3 = new MobBoss(150000, 90, 10000, "Henry");

        mobBoss1.addDistrict(hMapOfRooms.get("districtSE"));//set owned disticts
        mobBoss1.addDistrict(hMapOfRooms.get("districtSW"));

        mobBoss2.addDistrict(hMapOfRooms.get("districtE"));
        mobBoss2.addDistrict(hMapOfRooms.get("districtW"));

        mobBoss3.addDistrict(hMapOfRooms.get("districtN"));
        mobBoss3.addDistrict(hMapOfRooms.get("districtNE"));
        mobBoss3.addDistrict(hMapOfRooms.get("districtNW"));
        
        //hMapOfRooms
        hMapOfMB.put(mobBoss1.getName(), mobBoss1);
        hMapOfMB.put(mobBoss2.getName(), mobBoss2);
        hMapOfMB.put(mobBoss3.getName(), mobBoss3);
        return hMapOfMB;
    }
}