import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
class PasswordTest
{
    public static void main(String args[])
    {
        BufferedReader reader;
        //int totalLower, totalUpper, totalDigit, totalSpecial;
        try {

            String format = "\t\t\t\t";

            reader = new BufferedReader(new FileReader("passwords.txt"));

            FileWriter fw = new FileWriter("passwordsAnalyzed.txt");

            fw.write("Password"+format+"CODED"+format+"No. of Digits"+"\t\t"+"UpperCase"+"\t\t"+"LowerCase"+"\t\t"+"Special"+format+"Entropy"+"\n");
            int  i;
            double totalLower = 0, totalUpper = 0, totalDigit = 0, totalSpecial = 0;
            double entropy;
            
            String line = reader.readLine();
            

            while(line != null){
                
                int digitCount = 0, upperCount = 0, lowerCount = 0, specialCharacter = 0;
                int length = line.length();
                String coded="";
                for(i=0; i < length; i++){

                    if(Character.isDigit(line.charAt(i)) == true){

                        digitCount++;
                        coded += "N";
                        totalDigit++;
                        continue;
                        
                    }
                    if(Character.isLetter(line.charAt(i)) == true){

                        if(Character.isUpperCase(line.charAt(i)) == true){

                            upperCount++;
                            coded += "U";
                            totalUpper++;

                        } else{

                            lowerCount++;
                            coded +="L";
                            totalLower++;

                        }
                    }
                    else{

                        specialCharacter++;
                        coded += "S";
                        totalSpecial++;

                    }
                }
                entropy = (Math.log(Math.pow(62,length)))/(Math.log(2));
                fw.write(line+format+coded+format+digitCount+format+upperCount+format+lowerCount+format+specialCharacter+format+entropy+"\n");
                line = reader.readLine();
            }
            reader.close();
            fw.close();
            System.out.println(totalDigit/500+"=Average Number of Digits.\n"+totalLower/500+"=Average Number of Lower Case.\n"+totalUpper/500+"=Average Number of Upper Case.\n"+totalSpecial/500+"=Average Number of Special Characters.");
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
}