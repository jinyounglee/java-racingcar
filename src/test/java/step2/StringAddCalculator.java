package step2;

class StringAddCalculator {

    public int addNumber(String text) {
        Split split = new Split(text);
        Conversion conversion = new Conversion(split.getResult());
        Sum sum = new Sum(conversion.stringToNumber());
        return sum.getResult();
    }
}