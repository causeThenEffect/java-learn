import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.AviatorEvaluatorInstance;
import com.googlecode.aviator.Expression;
import com.googlecode.aviator.Options;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 表达式计算
 */
public class Execute {
    public static void main(String[] args) {
        try {
            AviatorEvaluatorInstance evaluatorInstance = AviatorEvaluator.getInstance();
//            evaluatorInstance.setOption(Options.ALWAYS_PARSE_FLOATING_POINT_NUMBER_INTO_DECIMAL, true);
            evaluatorInstance.addInstanceFunctions("bbb", BigDecimal.class);
            evaluatorInstance.addInstanceFunctions("s", String.class);
            evaluatorInstance.addFunction(new Test());
            Expression expression = evaluatorInstance.compileScript("test1.av", false);

            Map map = new HashMap<String, Object>();
            map.put("a", -9.4);
            map.put("b", -9.5);
            map.put("c", -9.6);
            Object execute = expression.execute(map);
            System.out.println(execute.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
