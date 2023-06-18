import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorDouble;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.math.BigDecimal;
import java.util.Map;

public class Test extends AbstractFunction {

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {
        Number num1 = FunctionUtils.getNumberValue(arg1,env);
        String stringValue = FunctionUtils.getStringValue(arg2, env);
        BigDecimal bigDecimal = new BigDecimal(num1.doubleValue());
        double doubleValue = 0;
        if (stringValue.equals("ROUND_HALF_UP")) {
            doubleValue = bigDecimal.setScale(0, BigDecimal.ROUND_HALF_UP).doubleValue();
        } else {
            doubleValue = bigDecimal.setScale(0, BigDecimal.ROUND_HALF_DOWN).doubleValue();
        }
        AviatorDouble aviatorDouble = new AviatorDouble(doubleValue);
        return aviatorDouble;
    }

    @Override
    public String getName() {
        return "test1";
    }
}
