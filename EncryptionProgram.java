import java.util.*;

public class EncryptionProgram {

    private Scanner scanner;
	private Random random;
	private ArrayList<Character> list;
    private ArrayList<Character> shuffledList;
	private char character;
	private String line;
	private char[] letters;


    EncryptionProgram(){

        scanner = new Scanner(System.in);
        random = new Random();
        list = new ArrayList();
        shuffledList = new ArrayList();
        character=' ';

        newKey(); //automatically creates a new key for the user
        askQuestion();

    }
    private void askQuestion(){ 
        while(true){
            System.out.println("******************************");
            System.out.println("What do you want to do?");
            System.out.println("(N)ewKey, (G)etKey, (E)ncrypt, (D)ecrypt, (Q)uit");
            char response = Character.toUpperCase(scanner.nextLine().charAt(0));

            switch(response) {
                case 'N':
                newKey();
                break;

                case 'G':
                getKey();
                break;

                case 'E':
                encrypt();
                break;

                case 'D':
                decrypt();
                break;

                case 'Q':
                quit();
                break;

                default:
                System.out.println("Not a valid answer");

            }
        }

    }
    private void newKey(){ //Generate a new key
        character = ' '; 
        list.clear();
        shuffledList.clear();

        for (int i=32; i<127 ; i++){    //This would get us the next letter from the ascii table
            list.add(Character.valueOf(character));
            character++;
        }

        shuffledList = new ArrayList(list);
        Collections.shuffle(shuffledList);
        System.out.println("*A new key has been generated*");

    }
    private void getKey(){ //Retrieves the key
        System.out.print("Key: ");
        StringBuilder KeyBuilder = new StringBuilder();

        for(Character x: list){
            KeyBuilder.append(x);
        }
        System.out.println();
        for(Character x: shuffledList){
            KeyBuilder.append(x);
        }
        System.out.println(KeyBuilder);
    }
    private void encrypt() { // Encrypts the message
        System.out.println("Enter a message to be encrypted: ");
        String message = scanner.nextLine();

        letters = message.toCharArray();

        for(int i=0; i<letters.length; i++){
            for(int j=0; j<list.size(); j++){
                if(letters[i]==list.get(j)) {
                    letters[i]=shuffledList.get(j);
                    break;
                }
            }
        }
        System.out.println("Encrypted: ");
        for(char x: letters) {
            System.out.print(x);
        }
        System.out.println();

    }
    private void decrypt(){ // Decrypts the message
        System.out.println("Enter a message to be decrypted: ");
        String message = scanner.nextLine();

        letters = message.toCharArray();

        for(int i=0; i<letters.length; i++){
            for(int j=0; j<shuffledList.size(); j++){
                if(letters[i]==shuffledList.get(j)) {
                    letters[i]=list.get(j);
                    break;
                }
            }
        }
        System.out.println("Decrypted message: ");
        for(char x: letters) {
            System.out.print(x);
        }
        System.out.println();

    }
    private void quit(){  //This exits the program

        System.out.println("Thank you! Have a nice day!");
        System.exit(0);

    }
    
}
