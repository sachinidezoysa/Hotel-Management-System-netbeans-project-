//uow_w1626638
//2016212

package hotelManagement;

import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;
public class HotelManagementSystem {

    public static void main(String[] args) {
            //created a scanner object to get user inputs
        Scanner input = new Scanner(System.in);

        String Customer = null;
        int roomNum = 1;
        String Option;

        String[] hotel = new String[12];//created a string array named as hatel

        initialise(hotel); //call initialise array and passed array as th arg

        while ( roomNum  < 11 && roomNum > 0)  
        {//give menu to customer
            System.out.println("* * * * * * * * * * * * * * * * * * * * * *");
            System.out.println("Hotel Booking Options");
            System.out.println("* * * * * * * * * * * * * * * * * * * * * *");
            System.out.println("A: To Add customer to a room");
            System.out.println("V: To View all rooms");
            System.out.println("E: To Display empty rooms");
            System.out.println("D: To Delete customer from a room");
            System.out.println("F: Find room from customer name");
            System.out.println("S: Store program data in to file");
            System.out.println("L: Load	program	data from file");
            System.out.println("O: View rooms alphabetically by name");
            System.out.println("* * * * * * * * * * * * * * * * * * * * * *");

            Option = input.next();

            if (Option.equalsIgnoreCase("V")){ //viewing all rooms
                view(hotel, Customer);  
            }

            if (Option.equalsIgnoreCase("A")){ // adding a customer to a room
   
                 for(roomNum=1 ; roomNum < 10; roomNum++){
                  System.out.println("Enter a room number ( 1-10):");
                  roomNum =input.nextInt();
                  
                  while(roomNum <1 || roomNum > 10){
                      System.out.println("Enter a valied room number");
                      System.out.println("* * * * * * * * * * * * * * * * * * ");
                      System.out.println("Enter a room number (1-10):");
                      roomNum =input.nextInt();
                      
                  }
                  
                  System.out.println("Enter a name for room " + roomNum + " : " ) ;
                  Customer = input.next();
                  hotel[roomNum] = Customer ;// adding customer to roomNm[]
                  add(hotel, Customer);
               
                  if(roomNum<11){
                   System.out.println("Do you want an another room: if yes enter 'y' if no enter 'n'");
                   Option = input.next();
                
                    if (Option.equalsIgnoreCase("n")) {
                        break;
                    }   
                  
                   }
                 }

            }

            if (Option.equalsIgnoreCase("E")){ //view all empty rooms
                vacant(hotel, Customer);
            }

            if (Option.equalsIgnoreCase("D")){ //Deletes a customer from a room

                //Searches if room is occupied, if it is then it will delete customer from that room
                view(hotel, Customer);
                System.out.println("Enter the room which you want to delete a customer from: ");
                roomNum = input.nextInt();
                hotel[roomNum] = "empty";

                delete(hotel, Customer);
                System.out.println("");

            }

            if (Option.equalsIgnoreCase("F")){ //view all empty rooms
                find(hotel); //links to private static void empty
            }
            if (Option.equalsIgnoreCase("S")){//Store program data in to file
                 store(hotel);
            }
            if(Option.equalsIgnoreCase("L")){//Load program data from file
              readFile(hotel); 
            }
            if(Option.equalsIgnoreCase("O")){//View rooms alphabetically by name
                 orderedAlphabetically(hotel); 
            }

        }
    }

    private static void initialise( String hotelRef[] )
    {
        for (int x = 1; x < 11; x++ )
            hotelRef[x] = "empty";
        System.out.println( "Welcome to Hotel Seafresh");
        
    }


 public static void view(String hotel[], String Customer)
    {

        for (int x =1; x <11; x++)
        {
	//catching and handling exceptions using a try catch block 
            try 
            {
                int z=0;
                String Customername = Customer;
                hotel[z]= Customername;

                if (hotel[x].equals("empty"))
                    System.out.println("room " + x + " is empty");
                else 
                {
                    System.out.println("room " + x + " is occupied by "+ hotel[x]);
                }
            }
            catch (Exception e ) 
            {
    		JOptionPane.showMessageDialog(null, "Wrong Input. Please enter again.");
            }
        }
    }

    private static void add(String[] hotel, String Customer)
    {
    	for (int x =1; x <11; x++)
        {

        if (hotel[x].equals("empty"))
            System.out.println("room " + x + " is empty");
        else 
        {
            System.out.println("room " + x + " is occupied by "+ hotel[x]);
        }

        }
    }
    private static void vacant(String hotel[], String Customer)
    {
        try
        {
            for (int x = 1; x < 11; x++ )
            {
                int z=0;
                String Customername = Customer;
                hotel[z]= Customername;
                if (hotel[x].equals("empty")) 
                System.out.println("successfully deleted. room " + x + " is empty"); 
            }
        }
        catch (Exception e ) 
        {
            JOptionPane.showMessageDialog(null, "Wrong Input. Please enter again.");
	}
    }


    private static void delete(String hotel[], String Customer)
    { 
        
            for (int x = 1; x < 11; x++ )
            {
                int z=0;
                String Customername = Customer;
                hotel[z]= Customername;
                if (hotel[x].equals("empty"))
                { 
                    System.out.println("room " + x + " is empty");
                    break;
                }
                else {
			System.err.println("The room is empty");
                        
		}
            }

    }

    private static void find(String hotel[])
    {
    
            Scanner input = new Scanner(System.in);   
            System.out.println("Enter customer name for room:" );
            String consumersname;
            consumersname = input.next();  //stores name they enter as consumers name
            for (int x = 1; x < 11; x++ )
            {
                if (hotel[x].equalsIgnoreCase(consumersname)){
                   System.out.println("room " + x + " is occupied by "+hotel[x]);
                   
                }
                else{
                    System.out.println("Sorry! There is no any custermer as "+ consumersname);
                    break;
                }
                
            }
        
           
    }
	
    private static void orderedAlphabetically(String hotel[]) 
    {
        List<String> orderedGuestHouse = new ArrayList<>();
	String temp;
	for (int i = 0; i < 11; i++) 
        {
            for (int j = i + 1; j < 11; j++) 
            {
		if (hotel[i] != null) 
                    {
			if (hotel[i].compareTo(hotel[j]) > 0) 
                            {
				temp = hotel[i];
				hotel[i] = hotel[j];
				hotel[j] = temp;
                            }
                    }
            }

	}
	System.out.println("Names in alphabetical order : ");
	for (int i = 0; i < 11 - 1; i++) 
        {
            if (hotel[i] != null) 
            {
                if (hotel[i].equals("empty")) 
                {

		} 
                else 
                {
		orderedGuestHouse.add(hotel[i]);
		}

            }
	}
	orderedGuestHouse.add(hotel[(11) - 1]);
        orderedGuestHouse.stream().forEach((name) -> 
            {
            System.out.println(name);
            }
            );
    }
    
    public static void save(String r)
    {
                try {
		String filename="HotelDetails.txt";
		
		File file = new File(filename);
		FileWriter fw = null;
		PrintWriter pw = null;
		
		
			
			fw = new FileWriter(file,true);
			pw = new PrintWriter(fw, true);
			pw.println(r);
				
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "File not found please check the file");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Something wrong with IO please check");
		}
		
		
	}
    
    public static void store(String hotel[])
    {
		String tem = "";
            for (String hotel1 : hotel) 
            {
                tem += hotel1 + ";";
            }
		System.out.println(tem);
		save(tem);
		System.out.println("File Created Success");
	}
	
	public static void readFile(String hotel[])
        {
		String fileName="HotelDetails.txt";
		File f=new File(fileName);
		
			try{
			Scanner sc=new Scanner (f);
			
			String code=sc.next();
			String[] text = code.split(";");	
                    System.arraycopy(text, 0, hotel, 0, text.length);
			
			} 
                        catch (FileNotFoundException e) 
                        {
				System.out.println("file not found . Try again");
			}
			System.out.println("File Read Completed");
	}
		
    }
