package stringCalculator;

public class Calculator {

    public Calculator() {
    }

    public int calculate(String input){
        int result = 0;
        String[] list;

        isBlank(input);

        list = input.split(" ");
        Directives directives = new Directives(list);
        Numbers numbers = new Numbers(list);

        for (int i = 0; i < directives.getDirectivesSize(); i++) {
            Operator o = directives.findOperator(i);
            result = numbers.interact(o, result, i);
        }

        return result;
    }

    private void isBlank(String s){
        s = s.trim();
        if (s.isBlank() || s.isEmpty()){
            System.out.println("계산할 값이 없습니다.");
            throw new IllegalArgumentException();
        }
    }
    

}