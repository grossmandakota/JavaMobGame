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
    private HashMap<String, MobBoss> hMapOfMB = new HashMap<String, MobBoss>();
    private HashMap<String, Room> hMapOfRooms = new HashMap<String, Room>();
    private Room trigger;
    /**
     * Constructor for objects of class GameWorld
     */
    // this way you can only create a gameWorld here
    private GameWorld()
    {
        entrance = createWorld();
        createMobBosses();
        createWorld();
        NotificationCenter.getInstance().addObserver("PlayerEnteredRoom",this ,"player");
    }

    public Room getEntrance()
    {
        return entrance;
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
        Room districtS = new Room("in the south district");
        Room districtSE = new Room("in the southeast district");
        Room districtSW = new Room("in the southwest district");
        Room districtE = new Room("in the east district");
        Room districtW = new Room("in the west district");
        Room shop = new Room("in the shop");
        Room districtNE = new Room("in the northeast district");
        Room districtN = new Room("in the north district");
        Room districtNW = new Room("in the northwest district");

        districtS.setExit("west", districtSW);
        districtS.setExit("east", districtSE);
        districtS.setExit("north", shop);

        districtSE.setExit("west", districtS);
        districtSE.setExit("north", districtE);

        districtSW.setExit("east", districtS);
        districtSW.setExit("north", districtW);

        districtE.setExit("west", shop);
        districtE.setExit("north", districtNE);
        districtE.setExit("south", districtSE);

        districtW.setExit("east", shop);
        districtW.setExit("north", districtNW);
        districtW.setExit("south", districtSW);

        shop.setExit("south", districtS);
        shop.setExit("north", districtN);
        shop.setExit("east", districtE);
        shop.setExit("west", districtW);

        districtNE.setExit("west", districtN);
        districtNE.setExit("south", districtE);

        districtN.setExit("south", shop);
        districtN.setExit("east", districtNE);
        districtN.setExit("west", districtNW);

        districtNW.setExit("south", districtW);
        districtNW.setExit("east", districtN);

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