package calculate.service;

import org.springframework.stereotype.Service;

@Service
public class CalculateServiceImpl implements CalculateService {
    @Override
    public String calculate(String sign, int number1, int number2) {
        String result;
        if (sign.equalsIgnoreCase("plus")) {
            result = String.valueOf(number1 + number2);
        } else if (sign.equalsIgnoreCase("minus")) {
            result = String.valueOf(number1 - number2);
        } else if (sign.equalsIgnoreCase("time")) {
            result = String.valueOf(number1 * number2);
        } else if (sign.equalsIgnoreCase("divide")) {
            if (number2 > 0) {
                result = String.valueOf(number1 / number2);
            } else {
                result = "Can't not divide by 0";
            }
        } else {
            result = "Please input number!";
        }
        return result;
    }
}
