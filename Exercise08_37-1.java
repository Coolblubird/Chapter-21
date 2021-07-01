import java.util.*;

public class Exercise08_37 {
  public static void main(String[] args) {
    Map<String, String> map = new HashMap<>();
    
    String[] states ={"Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusettes", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New York", "New Mexico", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"};
    
    String[] stateCapitals = {"Montgomery", "Juneau","Phoenix","Little Rock","Sacramento","Denver","Hartford","Dover","Tallahassee","Atlanta","Honolulu","Boise","Springfield","Indianapolis","Des Moines","Topeka","Frankfort","Baton Rouge","Augusta","Annapolis","Boston","Lansing","Saint Paul","Jackson","Jefferson City","Helena","Lincoln","Carson City","Concord","Trenton","Albany","Santa Fe","Raleigh","Bismarck","Columbus","Oklahoma City","Salem","Harrisburg","Providence","Columbia","Pierre","Nashville","Austin","Salt Lake City","Montpelier","Richmond","Olympia","Charleston","Madison","Cheyenne"};

    for (int i = 0; i < states.length; i++) {
      map.put(states[i].toLowerCase(), stateCapitals[i]);
    }

    Scanner input = new Scanner(System.in);
    
    int correctCount = 0;

    while (true){
      // Prompt the user with a question
      System.out.print("Please enter an USA State: ");
      String state = input.nextLine().trim().toLowerCase();
      
      System.out.println("The capital for that state is: " + map.get(state));
    }
  }
}
