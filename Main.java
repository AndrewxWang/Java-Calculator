import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    
    String sign = "";
    boolean isNum = false;
    System.out.println("");
    System.out.println("Maximum numbers: 2");
    System.out.println("Calculator: type \"quit\" to end.");

    while(true){
    double result = 0.0;
    System.out.println("");
    System.out.print("Enter: ");
    String tempinput = in.nextLine();   
    String input = tempinput.replaceAll("\\s",""); 
    
    if (input.equals("quit")) break;
    if (input.length()<1) continue;

    sign = changeSign(input);
    isNum = checkNum(input, sign);
    if (!sign.equals("") && isNum) result = getAns(input, sign); 
    System.out.print(" = " + result);
    }
    System.out.println("Quit.");
    in.close();
  }

  public static String changeSign(String str){
    if (str.contains("+")) return "+";
    else if (str.contains("-")) return "-";
    else if (str.contains("*")) return "*";
    //other option for multiplication
    else if (str.contains("x")) return "x";
    else if (str.contains("/")) return "/";
    else return "";
  }

  public static boolean checkNum(String input, String sign){
    int index = input.indexOf(sign);
    String sub = input.substring(0,index);
    String sub2 = input.substring(index+1);

    try {
      double a = Double.parseDouble(sub);
      double b = Double.parseDouble(sub2);
      return true;
    }
    catch (NumberFormatException nfe) {
    return false;
    }
  }
  
  public static double getAns(String input, String sign){
    int index = input.indexOf(sign);
    String sub = input.substring(0,index);
    String sub2 = input.substring(index+1);

    double res = 0.0;
    double a = Double.parseDouble(sub);
    double b = Double.parseDouble(sub2);
    
    if (sign.equals("+")) res = a + b;
    else if (sign.equals("-")) res = a - b;
    else if (sign.equals("*")) res = a * b;
    else if (sign.equals("x")) res = a * b;
    else if (sign.equals("/")) res = a / b;


    return res;
  }
}
