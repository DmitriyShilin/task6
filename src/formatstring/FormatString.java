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
        if(first!=0 && Math.abs(Integer.MAX_VALUE/first)<Math.abs(second)){
            throw new LargeNumberValueException(first, second);
        }
        
        StringBuilder format = new StringBuilder();        
        LinkedList<Object> argsList = new LinkedList<>();
        
        //parsing second
        LinkedList<Integer>  secondList = getList(second);
        
        int result = first*second;
        
        //line of digits
        int resultSize = String.valueOf(result).length();
        int firstSize = String.valueOf(first).length();
        int secondSize = String.valueOf(second).length();
        
        int maxSize = Math.max(Math.max(resultSize, firstSize),secondSize);
        
        //head multiply
        format.append(createFormatDecimal(maxSize)).append("%n");
        argsList.add(first);
        format.append(createFormatDecimal(maxSize)).append("%n");
        argsList.add(second);
        
        //if second not a single digit
        if(secondSize!=1 && first!=0 && second!=0){
            //underline
            int underline = Math.max(secondSize, firstSize);      
            format.append(createFormatString(maxSize)).append("%n");
            argsList.add(underLine(underline));
            //show multiply 
            for(int i = 0; i<secondList.size(); i++){           
                format.append(createFormatDecimal(maxSize-i)).append("%n");
                argsList.add(first*secondList.get(i));
            }
        }
        //underline
        format.append("%s").append("%n");
        argsList.add(underLine(maxSize));
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
