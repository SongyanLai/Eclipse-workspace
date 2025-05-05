package lab4;

import java.util.Scanner;

public class StringChopper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String s = scanner.nextLine();
        System.out.print("Enter the number of pieces: ");
        int n = scanner.nextInt();
        String result = chopAndHash(s, n);
        System.out.println("Output: " + result);
        scanner.close();
    }

    public static String chopAndHash(String s, int n) {

        int chunkSize = s.length() / n;
       
        String finalResult = "";
        
        for (int i = 0; i < n; i++) {
            // 计算当前块的起始和结束位置
            int startIndex = i * chunkSize;
            int endIndex = startIndex + chunkSize;
            
            // 提取子字符串
            String currentChunk = s.substring(startIndex, endIndex);
          
            int sum = 0;
            for (int j = 0; j < currentChunk.length(); j++) {
                char currentChar = currentChunk.charAt(j);
                int charIndex = currentChar - 'a';
                sum += charIndex; 
            }
 
            int hashedIndex = sum % 26;
            char hashedChar = (char) ('a' + hashedIndex);
            finalResult += hashedChar;
        }
        
        return finalResult;
    }
 
    
   
}

