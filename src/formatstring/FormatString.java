package formatstring;

import formatstring.exception.LargeNumberValueException;
import java.util.Formatter;
import java.util.LinkedList;

public class FormatString {
    
    private int first;
    private int second;    
    
    public FormatString(int first, int second){
        this.first = first;
        this.second = second;
    }
    
    //parsing a number
    public LinkedList<Integer> getList(int number){
        LinkedList<Integer> list = new LinkedList<>();
        while(number != 0){
            list.add(number%10);
            number /= 10;            
        }
        return list;
    }
    
    //create underline
    public String underLine(int size){
        StringBuilder underline = new StringBuilder();
        for(int i = 0; i<size; i++){
            underline.append("_");
        }
        return underline.toString();        
    }
    
    public void multiply() throws LargeNumberValueException{
        if(Integer.MAX_VALUE/first < second){
            throw new LargeNumberValueException(first, second);
        }
        
        StringBuilder format = new StringBuilder();        
        LinkedList<Object> argsList = new LinkedList<>();
        
        //parsing second
        LinkedList<Integer>  secondList = getList(second);
        
        int result = first*second;
        int resultSize = String.valueOf(result).length();
        
        //head multiply
        format.append(createFormatDecimal(resultSize)).append("%n");
        argsList.add(first);
        format.append(createFormatDecimal(resultSize)).append("%n");
        argsList.add(second);
        
        //if second a single digit
        if(String.valueOf(second).length() != 1){
            //underline
            int underline = String.valueOf(first).length()>String.valueOf(second).length() ? String.valueOf(first).length() : String.valueOf(second).length();        
            format.append(createFormatString(resultSize)).append("%n");
            argsList.add(underLine(underline));
            //show multiply 
            for(int i = 0; i<secondList.size(); i++){           
                format.append(createFormatDecimal(resultSize-i)).append("%n");
                argsList.add(first*secondList.get(i));
            }
        }
        //underline
        format.append("%s").append("%n");
        argsList.add(underLine(resultSize));
        //result multiply
        format.append("%d").append("%n").append("%n");
        argsList.add(result);
        //show on display
        try(Formatter fmt = new Formatter()){
            System.out.println(fmt.format(format.toString(), argsList.toArray()));
        }
    }
    
    public String createFormatDecimal(int indent){
        return "%" + indent + "d";
    }
    
    public String createFormatString(int indent){
        return "%" + indent + "s";
    }
}
