import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.AviatorEvaluatorInstance;
import com.googlecode.aviator.Expression;
import com.googlecode.aviator.Options;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Execute {
    public static void main(String[] args) {
        try {
            AviatorEvaluatorInstance evaluatorInstance = AviatorEvaluator.getInstance();
//            evaluatorInstance.setOption(Options.ALWAYS_PARSE_FLOATING_POINT_NUMBER_INTO_DECIMAL, true);
            Expression expression = evaluatorInstance.compileScript("test1.av", false);

            Map map = new HashMap<String, Object>();
            map.put("a", 0.3);
            map.put("b", 0.1);
            Object execute = expression.execute(map);
            System.out.println(execute.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
