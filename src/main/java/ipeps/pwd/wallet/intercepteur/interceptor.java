package ipeps.pwd.wallet.intercepteur;

import org.hibernate.EmptyInterceptor;
import org.springframework.util.StringUtils;

public class interceptor extends EmptyInterceptor {
    @Override
    public String onPrepareStatement(String sql) {
        if (StringUtils.hasLength(sql)&& sql.toLowerCase().startsWith("select")){
            if (sql.contains("where")) {
                sql = sql + "and id = 1";
            }
            else {
                sql = sql + "where id = 1";

            }
        }
        return super.onPrepareStatement(sql);
    }
}
